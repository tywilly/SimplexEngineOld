package com.tywilly.SimplexEngine.util;

public class LinkedList<E> {

    private class LinkedListObject<E> {

        private E payload;
        private LinkedListObject next;

        public LinkedListObject(E payload){
            this.payload = payload;
            this.next = null;
        }

        public LinkedListObject(E payload, LinkedListObject next){
            this.payload = payload;
            this.next = next;
        }

        public E getPayload(){
            return payload;
        }

        public void setPayload(E payload){
            this.payload = payload;
        }

        public LinkedListObject getNext(){
            return next;
        }

        public void setNext(LinkedListObject next){
            this.next = next;
        }

    }

    private LinkedListObject<E> root;

    public LinkedList(){
        root = null;
    }

    public void add(E data){
        LinkedListObject<E> newNode = new LinkedListObject<E>(data, root);
        root = newNode;
    }

    public E get(int index){
        LinkedListObject<E> node = root;

        for(int i=0;i<=index;i++){
            node = node.getNext();
        }

        return node.getPayload();
    }

    public void remove(int index){



    }

}
