package demoCollection;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo01 = new Demo1();
        //demo01.demoList();
        demo01.demoMap();
    }

    private void demoMap() {
        // TODO Auto-generated method stub
        Map<String, Integer> map = new HashMap<>();
        map.put("n1", 20);
        map.put("n2", 30);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }

    private void demoList() {
        // Should declare as interface
        //List<String> names = new ArrayList<String>(); Java 1.7--
        List<String> names = new ArrayList<>(); //Java 1.8++
        System.out.println(names.size());
        System.out.println("Demo List");
        names.add("Name1");
        names.add("Name2");
        for (String string : names) {
            System.out.println(string);
        }
        
        //Cool lambda method
        names.forEach(name -> System.out.println(name));
    }
    
}
