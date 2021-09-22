package com.lsm.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
    public static void main(String[] args) {
        String[] language = {"c", "c++", "c#", "java", "python", "go", "hive", "php"};
        List<String> languageList = Arrays.asList(language);
        languageList.forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------------------------");

        Runnable runnable = () -> System.out.println("hello carl");
        runnable.run();
        System.out.println("---------------------------------------------------------");

        String[] language2 = {"b", "a", "d", "c", "python", "go", "hive", "php"};
        Arrays.sort(language2, (o1, o2) -> (o1.compareTo(o2)));
        List<String> languageList2 = Arrays.asList(language2);
        languageList2.forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------------------------");

        functionalInterface(() -> System.out.println("myFunctionalInterface"));
        System.out.println("---------------------------------------------------------");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "张三", "M"));
        students.add(new Student(2, "李四", "M"));
        students.add(new Student(3, "王五", "F"));
        List<Student> result = filter(students, (s) -> s.getSex().equals("F"));
        System.out.println(result);
        System.out.println("---------------------------------------------------------");

        List<String> arrays = new ArrayList<>();
        arrays.add("java");
        arrays.add("python");
        arrays.add("go");
        arrays.add("hive");
        foreach(arrays, (s) -> System.out.print(s + ","));
        System.out.println();
        System.out.println("---------------------------------------------------------");

        String value = "666";
        Integer result2 = convert(value, (s) -> Integer.parseInt(s) + 222);
        System.out.println(result2);
        System.out.println("---------------------------------------------------------");

        int[] arr = {100, 20, 50, 30, -99, 101, -50};
        Integer result3 = getMin(() -> {
            int min = arr[0];
            for (int i : arr) {
                if (i < min) {
                    min = i;
                }
            }
            return min;
        });
        System.out.println(result3);
        System.out.println("---------------------------------------------------------");

        students = new ArrayList<>();
        students.add(new Student(2, "张三", "M"));
        students.add(new Student(1, "李四", "M"));
        students.add(new Student(3, "王五", "F"));
        students.sort(Comparator.comparing(Student::getId));
        System.out.println(students);
        System.out.println("---------------------------------------------------------");

        students = new ArrayList<>();
        students.add(new Student(1, "张三", "M", 19));
        students.add(new Student(1, "李四", "M", 18));
        students.add(new Student(1, "王五", "F", 21));
        students.add(new Student(1, "赵六", "F", 20));
        List<String> results = students.stream().filter(s -> s.getAge() < 20).sorted(Comparator.comparing(Student::getAge)).map(Student::getName).collect(Collectors.toList());
        System.out.println(results);
        System.out.println("---------------------------------------------------------");

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4);
        List<Integer> result4 = numberList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println(result4);
        System.out.println("---------------------------------------------------------");

        List<Integer> numberList2 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4);
        List<Integer> collect = numberList2.stream().limit(5).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("---------------------------------------------------------");

        List<Integer> numberList3 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4);
        List<Integer> collect2 = numberList3.stream().limit(5).skip(2).collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println("---------------------------------------------------------");

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 19, true));
        studentList.add(new Student(1, "李四啊啊", "M", 18, false));
        studentList.add(new Student(1, "王五", "F", 21, true));
        studentList.add(new Student(1, "赵六啊", "F", 20, false));
        List<Integer> nameList = studentList.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(nameList);
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 19, true));
        studentList.add(new Student(2, "李四", "M", 18, false));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六", "F", 20, false));
        if (studentList.stream().anyMatch(s -> s.getAge() < 20)) {
            System.out.println("集合中有符合条件的学生");
        }
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 19, true));
        studentList.add(new Student(2, "李四", "M", 18, true));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六", "F", 20, false));
        if (studentList.stream().allMatch(Student::isPass)) {
            System.out.println("所有学生合格");
        } else {
            System.out.println("有学生不合格");
        }
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 18, true));
        studentList.add(new Student(2, "李四", "M", 19, true));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六1", "F", 15, false));
        studentList.add(new Student(5, "赵六2", "F", 16, false));
        studentList.add(new Student(6, "赵六3", "F", 17, false));
        studentList.add(new Student(7, "赵六4", "F", 18, false));
        studentList.add(new Student(8, "赵六5", "F", 19, false));
        Optional<Student> optional = studentList.stream().filter(s -> s.getAge() < 20).findAny();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 18, true));
        studentList.add(new Student(2, "李四", "M", 19, true));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六1", "F", 15, false));
        studentList.add(new Student(5, "赵六2", "F", 16, false));
        studentList.add(new Student(6, "赵六3", "F", 17, false));
        studentList.add(new Student(7, "赵六4", "F", 18, false));
        studentList.add(new Student(8, "赵六5", "F", 19, false));
        optional = studentList.parallelStream().filter(s -> s.getAge() < 20).findAny();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 18, true));
        studentList.add(new Student(2, "李四", "M", 19, true));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六1", "F", 15, false));
        studentList.add(new Student(5, "赵六2", "F", 16, false));
        studentList.add(new Student(6, "赵六3", "F", 17, false));
        studentList.add(new Student(7, "赵六4", "F", 18, false));
        studentList.add(new Student(8, "赵六5", "F", 19, false));
        optional = studentList.stream().filter(s -> s.getAge() < 20).findFirst();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 18, true));
        studentList.add(new Student(2, "李四", "M", 19, true));
        studentList.add(new Student(3, "王五", "F", 21, true));
        studentList.add(new Student(4, "赵六1", "F", 15, false));
        studentList.add(new Student(5, "赵六2", "F", 16, false));
        studentList.add(new Student(6, "赵六3", "F", 17, false));
        studentList.add(new Student(7, "赵六4", "F", 18, false));
        studentList.add(new Student(8, "赵六5", "F", 19, false));
        optional = studentList.parallelStream().filter(s -> s.getAge() < 20).findFirst();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println("---------------------------------------------------------");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        Integer reduce2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println(reduce2);
        System.out.println("---------------------------------------------------------");

        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        Optional<Integer> optional2 = numbers.stream().reduce(Integer::max);
        Optional<Integer> optional3 = numbers.stream().max(Integer::compareTo);
        if (optional2.isPresent()) {
            Integer integer = optional2.get();
            System.out.println(integer);
        }
        if (optional3.isPresent()) {
            Integer integer = optional3.get();
            System.out.println(integer);
        }
        System.out.println("---------------------------------------------------------");

        Stream<String> stringStream = Stream.of("1", "2", "3");
        stringStream.forEach(d -> System.out.println(d));
        Stream<Object> stream = Stream.of("1", "2", 3, true, new St());
        stream.forEach(d -> System.out.println(d));
        Integer[] numbers2 = new Integer[]{1, 2, 3, 4, 5, 6};
        Stream<Integer> integerStream = Arrays.stream(numbers2);
        integerStream.forEach(d -> System.out.println(d));
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 19, true));
        studentList.add(new Student(2, "李四", "M", 18, false));
        studentList.add(new Student(3, "王五", "F", 20, true));
        studentList.add(new Student(4, "赵六", "F", 20, false));
        Map<Integer, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map);
        Long collect3 = studentList.stream().collect(Collectors.counting());
        System.out.println(collect3);
        long count = studentList.stream().count();
        System.out.println(count);
        Optional<Student> optional4 = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        if (optional4.isPresent()) {
            Student student = optional4.get();
            System.out.println(student);
        }
        Optional<Student> studentOptional = studentList.stream().max(Comparator.comparing(Student::getAge));
        System.out.println(studentOptional.get());
        studentOptional = studentList.stream().min(Comparator.comparing(Student::getAge));
        System.out.println(studentOptional.get());
        Integer collect4 = studentList.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(collect4);
        int sum = studentList.stream().mapToInt(Student::getAge).sum();
        System.out.println(sum);
        Double collect5 = studentList.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(collect5);
        OptionalDouble average = studentList.stream().mapToDouble(Student::getAge).average();
        System.out.println(average.getAsDouble());
        IntSummaryStatistics collect6 = studentList.stream().collect(Collectors.summarizingInt(Student::getAge));
        long count2 = collect6.getCount();
        long sum2 = collect6.getSum();
        int max = collect6.getMax();
        int min = collect6.getMin();
        double average2 = collect6.getAverage();
        System.out.println("count2:" + count2 + ",sum2:" + sum2 + ",max:" + max + ",min:" + min + ",average2:" + average2);
        String collect7 = studentList.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(collect7);
        collect7 = studentList.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(collect7);
        Map<Integer, Map<String, List<Student>>> collect8 = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(student -> {
            if (student.isPass()) {
                return "pass";
            } else {
                return "not pass";
            }
        })));
        System.out.println(collect8);
        //根据年龄进行分组,获取并汇总人数
        Map<Integer, Long> collect9 = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        System.out.println(collect9);
        //根据年龄与是否及格进行分组,并汇总人数
        Map<Integer, Map<Boolean, Long>> collect10 = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::isPass, Collectors.counting())));
        System.out.println(collect10);
        System.out.println("---------------------------------------------------------");

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "张三", "M", 19, true, 54));
        studentList.add(new Student(2, "李四", "M", 18, false, 78));
        studentList.add(new Student(3, "王五", "F", 20, true, 32));
        studentList.add(new Student(4, "赵六", "F", 20, false, 99));
        //根据年龄和是否通过进行分组,并获取每组中分数最高的学生
        Map<Integer, Map<Boolean, Student>> collect11 = studentList.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.groupingBy(Student::isPass,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Student::getScore)), Optional::get))));
        System.out.println(collect11);
        System.out.println("---------------------------------------------------------");
    }

    public static void functionalInterface(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.execute();
    }

    public static List<Student> filter(List<Student> studentList, Predicate<Student> predicate) {
        ArrayList<Student> list = new ArrayList<>();
        studentList.forEach(s -> {
            if (predicate.test(s)) {
                list.add(s);
            }
        });
        return list;
    }

    public static void foreach(List<String> arrays, Consumer<String> consumer) {
        arrays.forEach(s -> consumer.accept(s));
    }

    public static Integer convert(String value, Function<String, Integer> function) {
        return function.apply(value);
    }

    public static Integer getMin(Supplier<Integer> supplier) {
        return supplier.get();
    }
}

class St {
}
