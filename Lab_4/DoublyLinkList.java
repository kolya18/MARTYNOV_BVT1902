package com.company;

public class DoublyLinkList<T>
{
    public class Dek<T>
    {
        private T t;
        private Dek next;
        private Dek prev;

        public  Dek()
        {
        }

        public Dek(T t)
        {
            this.t = t;
        }

        public T getT()
        {
            return t;
        }

        public void setT(T t)
        {
            this.t = t;
        }

        public Dek getNext()
        {
            return next;
        }

    }

    public Dek head;
    public Dek tail;

    //Добавить в начало
    public void addHead(T t)
    {
        Dek newEl = new Dek(t);

        if (head == null) {
            newEl.next = null;
            newEl.prev = null;
            head = newEl;
            tail = newEl;

        } else {
            head.prev = newEl;
            newEl.next = head;
            newEl.prev = null;
            head = newEl;
        }
    }
    //Добавить в конец
    public void addTail(T t)
    {
        Dek newEl = new Dek(t);

        if (head == null) {
            newEl.next = null;
            newEl.prev = null;
            head = newEl;
            tail = newEl;

        } else {
            tail.next = newEl;
            newEl.next = null;
            newEl.prev = tail;
            tail = newEl;
        }
    }

    //Удалить с начала

    public void removeHead()
    {
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    //Удалить с конца

    public void removeTail()
    {
        if (tail.prev == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }


   /* public int compareTo(Dek other)
    {
        return head.toString().compareTo(other.toString());
    }*/




    @Override
    public String toString()
    {
        String stringBuffer = "Дек {\n";
        Dek dek = head;
        while (dek != null)
        {
            stringBuffer = stringBuffer + dek.getT().toString();
            stringBuffer+=(",\n");
            dek = dek.getNext();
        }
        stringBuffer+=("}");
        return stringBuffer;
    }


    public String toChar()
    {
        String stringBuffer = "";
        Dek dek = head;
        while (dek != null)
        {
            stringBuffer = stringBuffer + dek.getT().toString();
            dek = dek.getNext();
        }
        return stringBuffer;
    }



}

