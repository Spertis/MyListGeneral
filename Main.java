package com.company;

public class Main {

    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>((a, b) -> {return(Integer.parseInt(a.toString()) - Integer.parseInt(b.toString()));});
//        MyList<Boolean> listB = new MyList<>((a, b) -> {return(Integer.parseInt(a.toString()) - Integer.parseInt(b.toString()));});
        MyList<String> listS = new MyList<>((a, b) -> {return((a.toString()).compareTo(b.toString()));});
        listS.add(Randomizer.randomFill_string(50));
        listS.add(Randomizer.randomFill_string(10));
        listS.add(Randomizer.randomFill_string(30));
        listS.add(Randomizer.randomFill_string(20));

        Randomizer.randomFill_int(list, 10);

//        System.out.println(list.toString());
//        list.swap(0,2);
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(6);
//        list.add(7);
//        list.add(2);
//        list.add(1);
//        list.add(10);
        System.out.println("Integer list -> " + list);
        list.sort();
        System.out.println("Changed Integer list -> " + list);
        System.out.println("String list -> " + listS);
        listS.sort();
        System.out.println("Changed String list -> " + listS);
    }
}