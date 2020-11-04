package com.company;

        import java.util.Collection;
        import java.util.Iterator;

public class MyList<T> implements Collection<T> {
    class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value){
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

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

    public int length;
    private Node<T> root;
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

    public Node end(){
        if (this.root == null)
            return null;
        Node<T> p = this.root;
        while (p.hasNext()) {
            p = p.getNext();
        }
        return p;
    }

    public T Get(int index){
        Node<T> p = root;
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
    public boolean add(T Value){
        Node<T> node = new Node<T>(Value);
        Node<T> iter = this.end();
        if (iter == null)
            this.root = node;
        else
            iter.setNext(node);
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
            Node<T> iter = this.root;
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
        Node<T> nextLink1 = null;
        Node<T> nextLink2 = null;
        int firstNumber = firstPos;
        int secondNumber = secondPos;
        Node<T> link1 = null;
        Node<T> link2 = null;
        Node<T> previousLink1 = null;
        Node<T> previousLink2 = null;
        boolean flag = (firstPos == 0 || secondPos == 0);


        if (-1 + this.length >= firstNumber) {
            Node<T> iter = this.root;
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


        if (-1 + this.length >= secondNumber) {
            Node<T> iter = this.root;
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
        Node<T> iter = this.root;

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
                } else {
                    iter.setNext(link2);
                    iter = iter.getNext();
                    iter.setNext(nextLink1);
                    break;
                }
            }
        }
    }

    /*
    Внизу нерабочее ******, метод compare - помойка
     */

//    public void sort(){
//        int z = this.getLength();
//        while (z > 0){
//            for (int i = 0; i < z - 1; i++)
//            {
//                Node<T> a = indexAt(i);
//                Node<T> b = indexAt(i+1);
//
//
//                if (comp.compare(a, b) == 1) {
//                    this.swap(i, i + 1);
//                }
//            }
//            z--;
//        }
//    }

    public Node indexAt (int index){
        if ((index <= this.length - 1) & (index >= 0)) {
            Node p = root;
            for (; index > 0; --index) {
                p = p.getNext();
            }
            return p;
        } else
            return null;
    }

}

interface Comparable {
    int compare(MyList.Node a, MyList.Node b);
}