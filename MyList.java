package com.company;

import java.util.Collection;
import java.util.Iterator;


public class MyList<T> implements Collection<T> {
    private long counter;

    class Item<T>{
        private T value;
        private Item<T> next;

        public Item(T value){
            this.value = value;
            this.next = null;
        }

        public boolean hasNext(){
            if (this.next == null){
                return false;
            }
            else {
                return true;
            }
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }

        public Item<T> getNext(){
            return next;
        }

        public void setNext(Item<T> next){
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

    public int length;
    private Item<T> root;
    private Comparable comp;

    public MyList(Comparable comp){
        this.length = 0;
        this.root = null;
        this.comp = comp;
    }

    public int getLength()
    {
        return length;
    }

    public Item end(){
        if (this.root == null)
            return null;
        Item<T> p = this.root;
        while (p.hasNext()) {
            p = p.getNext();
        }
        return p;
    }

    public T Get(int index){
        Item<T> p = root;
        for (int i = 0; i<index; i++){
            p = p.getNext();
        }
        T res = p.getValue();
        return res;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (this.root == null ? true : false);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T pValue){
        Item<T> newItem = new Item<T>(pValue);
        Item<T> iter = this.end();
        if (iter == null)
            this.root = newItem;
        else
            iter.setNext(newItem);
        this.length += 1;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public String toString() {
        String result = "[";
        if (this.root == null) {
            return null;
        }
        else {
            Item<T> iter = this.root;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString();
        }
        result += "]";
        return result;
    }

    public void swap(int firstPos, int secondPos) {
        Item<T> nextLink1 = null;
        Item<T> nextLink2 = null;
        int firstNumber = firstPos;
        int secondNumber = secondPos;
        Item<T> link1 = null;
        Item<T> link2 = null;
        Item<T> previousLink1 = null;
        Item<T> previousLink2 = null;
        boolean flag = (firstPos == 0 || secondPos == 0);


        if (-1 + this.counter >= firstNumber) {
            Item iter = this.root;
            for (; firstNumber >= 0; --firstNumber) {
                iter = iter.getNext();
            }
            nextLink1 = iter;
            iter = this.root;
            firstNumber = firstPos;

            for (; firstNumber > 1; --firstNumber) {
                iter = iter.getNext();
            }
            previousLink1 = iter;

            iter = this.root;
            firstNumber = firstPos;

            for (; firstNumber > 0; --firstNumber) {
                iter = iter.getNext();
            }
            link1 = iter;
        }
        firstNumber = firstPos;


        if (-1 + this.counter >= secondNumber) {
            Item iter = this.root;
            for (; secondNumber >= 0; --secondNumber) {
                iter = iter.getNext();
            }
            nextLink2 = iter;
            iter = this.root;
            secondNumber = secondPos;

            for (; secondNumber > 1; --secondNumber) {
                iter = iter.getNext();
            }
            previousLink2 = iter;
            iter = this.root;
            secondNumber = secondPos;

            for (; secondNumber > 0; --secondNumber) {
                iter = iter.getNext();
            }
            link2 = iter;
            secondNumber = secondPos;

        }
        Item iter = this.root;

        while (iter != null) {
            if (!flag) {
                if (iter == previousLink1 && previousLink1 != link2) {
                    iter.setNext(link2);
                    iter = iter.getNext();
                    if (Math.abs(secondPos - firstPos) == 1) {
                        iter.setNext(link1);
                        iter = iter.getNext();
                        iter.setNext(nextLink2);
                    } else {
                        iter.setNext(nextLink1);
                    }
                }

                if (iter == previousLink2 && previousLink2 != link1) {
                    iter.setNext(link1);
                    iter = iter.getNext();
                    if (Math.abs(secondPos - firstPos) == 1) {
                        iter.setNext(link2);
                        iter = iter.getNext();
                        iter.setNext(nextLink1);
                    } else {
                        iter.setNext(nextLink2);
                    }
                } else {
                    iter = iter.getNext();
                }

            } else if (firstPos == secondPos) {
                break;
            } else if (flag && firstPos == 0) {
                this.root = link2;
                iter = this.root;
                if (previousLink2 != link1) {
                    iter.setNext(nextLink1);

                    while (iter != null) {
                        if (iter == previousLink2) {
                            iter.setNext(link1);
                            iter = iter.getNext();
                            iter.setNext(nextLink2);
                        } else {
                            iter = iter.getNext();

                        }
                    }
                } else {
                    iter.setNext(link1);
                    iter = iter.getNext();
                    iter.setNext(nextLink2);
                    break;
                }
            } else if (flag && secondPos == 0) {
                this.root = link1;
                iter = this.root;
                if (previousLink1 != link2) {
                    iter.setNext(nextLink2);

                    while (iter != null) {
                        if (iter == previousLink1) {
                            iter.setNext(link2);
                            iter = iter.getNext();
                            iter.setNext(nextLink1);
                        } else {
                            iter = iter.getNext();
                        }
                    }
                }
                else {
                    iter.setNext(link2);
                    iter = iter.getNext();
                    iter.setNext(nextLink1);
                    break;
                }
            }
        }
    }


    public void Sort(){
        int length = this.getLength();
        while (length > 0){
            for (int i = 0; i < length - 1; i++)
            {
                Item <T> a = indexAt(i);
                Item <T> b = indexAt(i+1);
                if (comp.compare(a, b) > 0)
                {
                    this.swap(i, i + 1);
                }
            }
            length--;
        }
    }

    public Item indexAt ( int index){
        if ((index <= this.counter - 1) & (index >= 0)) {
            Item p = this.root;
            for (; index > 0; --index) {
                p = p.getNext();
            }
            System.out.println(p);
            return p;
        } else
            return null;
    }

}

interface Comparable {
    int compare(MyList.Item a, MyList.Item b);
}