package ru.bgpu.lk.list;

import java.util.Objects;

public class CounterVisitor implements Visitor {

    private String search;
    private int count = 0;

    public CounterVisitor(String search) {
        this.search = search;
    }

    @Override
    public void visit(Object value) {
        if(Objects.equals(search,value != null ? value.toString() : null)) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}
