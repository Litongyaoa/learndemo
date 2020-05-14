package io;

import java.util.*;

public class IoDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Iterator<String> iterator = list.iterator();
      /*  while (iterator.next() != null){
            System.out.println(iterator.next());
        }*/
        Map<String ,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        Set<String> strings = map.keySet();
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext() ){
            System.out.println(iterator1.next());
        }


/*        for (String strs:
                strings) {
            System.out.println(strs);
            System.out.println(map.get(strs));
        }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> str:
             entries) {
            System.out.println(str.getKey());
        }*/

    }
}
