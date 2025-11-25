package com.scripts.resource;
import java.io.*;
import java.util.zip.*;
import java.nio.file.*;
import java.util.regex.*;

public class ExtractZip {

    public static void main(String[] args) throws Exception {

        String zipPath = "C:\\Users\\User\\Downloads\\iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1 (5).zip"; // change your file name
        String extractDir = "extracted_ios";

        unzip(zipPath, extractDir);

        File plist = findInfoPlist(new File(extractDir));

        if (plist == null) {
            System.out.println("❌ Info.plist not found");
            return;
        }

        String content = new String(Files.readAllBytes(plist.toPath()));

        Pattern pattern = Pattern.compile(
                "<key>CFBundleIdentifier</key>\\s*<string>(.*?)</string>"
        );

        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            System.out.println("✅ Bundle ID: " + matcher.group(1));
        } else {
            System.out.println("❌ Bundle ID not found");
        }
    }

    private static void unzip(String zipFilePath, String destDir) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(destDir, entry.getName());
            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                newFile.getParentFile().mkdirs();
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
        zis.close();
    }

    private static File findInfoPlist(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                File result = findInfoPlist(file);
                if (result != null) return result;
            } else if (file.getName().equalsIgnoreCase("Info.plist")) {
                return file;
            }
        }
        return null;
    }
}
