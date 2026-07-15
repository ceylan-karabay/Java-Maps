package org.example;


import org.example.entity.Employee;

import java.util.*;



public class Main {
    public static List<Employee> findDuplicates(List<Employee> employees) {

        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            } else if (!seen.add(employee) && !duplicates.contains(employee)) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            map.putIfAbsent(employee.getId(), employee);
        }

        return map;
    }

    public static List<Employee> removeDuplicates (List<Employee> employees){

        Map<Integer, Integer> countMap = new HashMap<>();

        // Her id'nin kaç kez geçtiğini say
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            countMap.put(employee.getId(),
                    countMap.getOrDefault(employee.getId(), 0) + 1);
        }

        List<Employee> result = new ArrayList<>();

        // Sadece 1 kez geçenleri ekle
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }




    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Serin"));
        employees.add(new Employee(2, "Ayşe", "Yel"));
        employees.add(new Employee(3, "Veli", "Derin"));
        employees.add(new Employee(1, "Ali", "Serin"));
        employees.add(new Employee(5, "Esra", "Demir"));
        employees.add(new Employee(6, "Aslı", "Duran"));
        employees.add(new Employee(7, "Yavuz", "Sır"));
        employees.add(new Employee(2, "Ayşe", "Yel"));
        employees.add(new Employee(5, "Esra", "Demir"));


        List<Employee> duplicates = findDuplicates(employees);
        System.out.println(duplicates);

        Map<Integer, Employee> uniqueEmployees = findUniques(employees);

        System.out.println(uniqueEmployees);

        List<Employee> uniqueList = removeDuplicates(employees);

        System.out.println(uniqueList);



        Map<String, Integer> result = WordCounter.calculatedWord();

        System.out.println(result);
    }

}