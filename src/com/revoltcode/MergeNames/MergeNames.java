package com.revoltcode.MergeNames;

import java.util.*;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Map<String, String> nameMap = new HashMap<>();
        List<String> nameData = new ArrayList<>();
        List<String> uniqueNames = new ArrayList<>();

        Collections.addAll(nameData, names1);
        Collections.addAll(nameData, names2);

        for (String name : nameData) {
            if(nameMap.get(name)==null){
                uniqueNames.add(name);
                nameMap.put(name, name);
            }
        }
        return uniqueNames.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}