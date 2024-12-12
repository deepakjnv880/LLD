package helloWorld;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Abc {
    public static int i = 0;

    static {
        i++;
        System.out.println("CodeBlock1=" + i);
        //called at time of classloading
    }

    {
        i++;
        System.out.println("CodeBlock2=" + i);
        //called just before constructor
    }

    public Abc() {
        System.out.println("CodeBlock3=" + i);
        //parent constructor will be called first
    }
}

public class Main extends Abc {
    static {
        System.out.println("CodeBlock4=" + i);
        i++;
    }

    {
        System.out.println("CodeBlock5=" + i);
        i++;
    }

    public Main() {
        System.out.println("CodeBlock6=" + i);
    }

    public static void main(String[] args) {
        ////////////////////////
        System.out.println("CodeBlock0");
        Main m = new Main();
        System.out.println("CodeBlock7");

        ////////////////////////
        // java puzzle
        int x = 9;
        x = ++x + ++x;
        System.out.println(x); // 21
        x = 9;
        x = x++ + x++;
        System.out.println(x); // 19
        x = 9;
        x = ++x + x++;
        System.out.println(x); // 20
        x = 9;
        x = x++ + ++x; // 20
        System.out.println(x);

        ////////////////////////
        //Stream code to remove duplicate from list
        List<String> l = List.of("python", "c", "java", "c", "c++", "python");
        List<String> n = l.stream().distinct().collect(Collectors.toList());
        System.out.println(n);
        //Stream code to print frequency
        String s = "I am looser. Nothing can be done";
        //below can be done in 1 step but just showcasing things
        Map<Character, Long> map = s.chars().mapToObj(e -> ((char) e)).filter(e -> !e.equals(' ')).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        String st = map.keySet().stream().map(e -> e + "=" + map.get(e) + ",").collect(Collectors.joining());
        System.out.println(st);

    }
}
