package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean upper = true;
            for (String i : x){
                if(i.startsWith(String.valueOf(i.charAt(0)).toLowerCase())){
                    upper = false;
                }
            }
            return upper;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>(x);
            for (Integer i : list){
                if(i%2 == 0){
                    x.add(i);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>(values);
            for(String i : list){
                boolean fits = true;
                if(i.startsWith(String.valueOf(i.charAt(0)).toLowerCase())){
                    fits = false;
                }
                if(!i.endsWith(".")){
                    fits =false;
                }
                StringTokenizer st = new StringTokenizer(i);
                if (st.countTokens() <4){
                    fits = false;
                }

                if(!fits){
                    values.remove(i);
                }
            }

            return values;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> m = new HashMap<>();
                for(String i : x){
                    m.put(i, i.length());
                }
            return m;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) ->{
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
