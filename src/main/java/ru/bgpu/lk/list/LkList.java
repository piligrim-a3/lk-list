package ru.bgpu.lk.list;

public class LkList {

    public class ListItem {

        private Object value;
        private ListItem next;

        public ListItem(Object value, ListItem next) {
            this.value = value;
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public ListItem getNext() {
            return next;
        }

        public void setNext(ListItem next) {
            this.next = next;
        }
    }

    private ListItem first = null;
    private ListItem last = null;
    private int size = 0;

    public void addFirst(Object value) {
        ListItem item = new ListItem(value,first);
        first = item;
        if(last == null) {
            last = first;
        }
        size++;
    }

    public Object removeFirst() {
        Object value = null;
        if(first != null) {
            value = first.getValue();
            first = first.getNext();
            if(first == null) {
                last = null;
            }
            size--;
        }
        return value;
    }

    public Object remove() {
        Object value = null;
        if(first != null) {
            if(first == last) {
                value = first.getValue();
                first = last = null;
            } else {
                ListItem item = first;
                while (item.getNext() != last) {
                    item = item.getNext();
                }
                value = last.getValue();
                last = item;
                item.setNext(null);
            }
            size--;
        }
        return value;
    }

    public void add(Object value) {
        ListItem item = new ListItem(value,null);
        if(last == null) {
            last = first = item;
        } else {
            last.setNext(item);
            last = item;
        }
        size++;
    }

    public Object getElementAt(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        ListItem item = first;
        for(int i = 0; i < index; i++) {
            item = item.getNext();
        }
        return item.getValue();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String out = "[";
        ListItem item = first;
        while (item != null) {
            out += item.getValue();
            if(item.getNext() != null) {
                out += ",";
            }
            item = item.getNext();
        }
        return out+"]";
    }

    public void visitList(Visitor visitor) {
        ListItem item = first;
        while (item != null) {
            visitor.visit(item.getValue());
            item = item.getNext();
        }
    }
}
