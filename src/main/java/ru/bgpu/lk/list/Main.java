package ru.bgpu.lk.list;

public class Main {

    public static void main(String[] args) {
        LkList list = new LkList();
        System.out.println(list);
        for(int i =0; i < 5; i++) {
            list.add(i);
        }
        list.add("2");
        CounterVisitor visitor = new CounterVisitor("2");
        list.visitList(visitor);
        System.out.println(visitor.getCount());
        //1
        list.visitList(new Visitor() {
            @Override
            public void visit(Object value) {
                System.out.println(value);
            }
        });
        //2
        list.visitList(value -> System.out.println(value));
        //3
        list.visitList(System.out::println);
    }
}
