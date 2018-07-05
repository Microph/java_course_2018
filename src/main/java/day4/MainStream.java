package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) {
        MainStream p = new MainStream();
        p.start();
    }

    private void start() {
        //Array Stream
        String[] data = new String[]{"One", "Two", "Three"};
        Stream<String> stream = Arrays.stream(data);
        //stream.forEach(System.out::print);
        
        //Collection Stream
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        //Stream<String> stream2 = list.stream();
        //stream2.forEach(System.out::print);
        
        //Filter Demo
        //Collectors.toList will convert Stream back to list to be reusable
        list.stream().filter(string -> string.startsWith("T")).collect(Collectors.toList()).forEach(System.out::print);
    }
}
