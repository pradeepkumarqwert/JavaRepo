package LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _015_Streams_One {

    @Test
    public void run1()
    {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Pradeeep");
        names.add("Aravind");
        names.add("Rupesh");
        names.add("Amar");
        names.add("Ganesh");
        names.add("bala");
        names.add("Ajay");
        names.add("Ashwin");

        names.stream().filter(s->s.startsWith("A")).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        names.stream().filter(s->s.startsWith("A")).count();
        System.out.println("-------------------------------------------------------");
        names.stream().filter(s -> s.contains("i")).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        names.stream().filter(s-> s.startsWith("P")).map(s-> s.toUpperCase()).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        names.stream().filter(s-> s.length()>4).forEach(System.out::println);
        names.stream().filter(s-> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void run2()
    {
        ArrayList<String> names1 = new ArrayList<String>();

        names1.add("Pradeeep");
        names1.add("Aravind");
        names1.add("Rupesh");
        names1.add("Amar");
        names1.add("Ganesh");
        names1.add("bala");
        names1.add("Ajay");
        names1.add("Ashwin");

        List<String> names2 = Arrays.asList("dosa", "Sambar", "Chattuni", "Pongal", "Thair Satham");

        Stream.concat(names1.stream(),names2.stream()).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        Stream<String> newStream2 = Stream.concat(names1.stream(),names2.stream());

        boolean  strameTorF= newStream2.anyMatch(s-> s.equalsIgnoreCase("sambar"));

        SoftAssert sAssert = new SoftAssert();

        sAssert.assertTrue(strameTorF);
        sAssert.assertAll();


    }


    @Test
    public void run3Collector()
    {
        ArrayList<String> names1 = new ArrayList<String>();

        names1.add("Pradeeep");
        names1.add("Aravind");
        names1.add("Rupesh");
        names1.add("Amar");
        names1.add("Ganesh");
        names1.add("bala");
        names1.add("Ajay");
        names1.add("Ashwin");

        List<String> ls = names1.stream().filter(s -> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
        System.out.println(ls.size());
        System.out.println(ls.get(ls.size()-1));



        System.out.println("---------------------------------------");
        List<Integer> numbers = Arrays.asList(1,5,25,22,221,1,1,2,5,78,99,5434,3,72,25,8,34,4,5,76);

        numbers.stream().distinct().sorted().forEach(System.out::println);




    }


}
