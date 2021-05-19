package com.company;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;


public class Lab2 {

//БВТ1902 Мартынов Николай 16 вариант

    public static int binSearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }



    public static int interpolationSearch(int[] sortedArray, int toFind) {
        // Возвращает индекс элемента со значением toFind или -1, если такого элемента не существует
        int mid;
        int low = 0;
        int high = sortedArray.length - 1;

        while (sortedArray[low] < toFind && sortedArray[high] > toFind) {
            if (sortedArray[high] == sortedArray[low]) // Защита от деления на 0
                break;
            mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);

            if (sortedArray[mid] < toFind)
                low = mid + 1;
            else if (sortedArray[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }

        if (sortedArray[low] == toFind)
            return low;
        if (sortedArray[high] == toFind)
            return high;

        return -1; // Not found
    }

    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }


    public static int[] removeElement(int index, int[] n) {

        int end = n.length;

        for(int j = index; j < end - 1; j++) {
            n[j] = n[j + 1];
        }
        end--;

        int[] newArr = new int[end];
        for(int k = 0; k < newArr.length; k++) {
            newArr[k] = n[k];
        }

        return newArr;
    }

    public static class Map<K, V> {

        class MapNode<K, V> {

            K key;
            V value;
            MapNode<K, V> next;

            public MapNode(K key, V value)
            {
                this.key = key;
                this.value = value;
                next = null;
            }
        }

        // Массив ведра, где
        // узлы, содержащие пары K-V, хранятся
        ArrayList<MapNode<K, V> > buckets;

        //Количество хранимых пар - n
        int size;

        // Размер bucketArray - b
        int numBuckets;

        //LoadFactor по умолчанию
        final double DEFAULT_LOAD_FACTOR = 0.75;

        public Map()
        {
            numBuckets = 5;

            buckets = new ArrayList<>(numBuckets);

            for (int i = 0; i < numBuckets; i++) {
                // Инициализация до нуля
                buckets.add(null);
            }
            System.out.println("HashMap созданный");
            System.out.println("\n" + "Количество пар на Map: " + size);
            System.out.println("Размер Map: " + numBuckets);
            System.out.println("Коэффициент нагрузки по умолчанию : " + DEFAULT_LOAD_FACTOR + "\n");
        }

        private int getBucketInd(K key)
        {

            // Использование встроенной функции из объектного класса
            int hashCode = key.hashCode();

            // array index = hashCode%numBuckets
            return (hashCode % numBuckets);
        }

        public void insert(K key, V value)
        {
            //Получение индекса, по которому его нужно вставить
            int bucketInd = getBucketInd(key);

            // Первый узел в этом индексе
            MapNode<K, V> head = buckets.get(bucketInd);

            // Сначала прокрутите все узлы, присутствующие в этом индексе
            // чтобы проверить, существует ли уже ключ
          /*  while (head != null) {

                // Если уже присутствует, значение обновляется
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }*/

            //новый узел с K и V
            MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);

            // главный узел в индексе
            head = buckets.get(bucketInd);

            // новый узел вставлен
            // сделав это head
            // и это следующая это предыдущая head
            newElementNode.next = head;

            buckets.set(bucketInd, newElementNode);

            System.out.println("Пара (" + key + ", " + value + ") вставлено успешно.\n");

            // Увеличение размера
            // по мере добавления новой пары K-V на map
            size++;

            // Расчетный коэффициент нагрузки
            double loadFactor = (1.0 * size) / numBuckets;

            System.out.println("Текущий коэффициент нагрузки = " + loadFactor);

            // Если коэффициент нагрузки> 0,75, выполняется повторное хеширование.
            if (loadFactor > DEFAULT_LOAD_FACTOR) {
                System.out.println(loadFactor + " больше, чем " + DEFAULT_LOAD_FACTOR);
                System.out.println("Поэтому повторное хеширование будет выполнено.\n");
                // Rehash
                rehash();

                System.out.println("Новый размер для Map: " + numBuckets + "\n");
            }

            System.out.println("Количество пар в Map: " + size);
            System.out.println("Размер Map: " + numBuckets + "\n");
        }

        private void rehash()
        {

            System.out.println("\nНачало рехеширования\n");

            // Настоящий список ведра составлен на временной основе.
            ArrayList<MapNode<K, V> > temp = buckets;

            // Создается новый bucketList вдвое больше старого
            buckets = new ArrayList<MapNode<K, V> >(2 * numBuckets);

            for (int i = 0; i < 2 * numBuckets; i++) {
                // Initialised to null
                buckets.add(null);
            }
            // Теперь размер обнулен
            // мы перебираем все узлы в исходном списке ведра (temp)
            // и вставляем в новый список
            size = 0;
            numBuckets *= 2;

            for (int i = 0; i < temp.size(); i++) {

                // глава цепочки по этому индексу
                MapNode<K, V> head = temp.get(i);

                while (head != null) {
                    K key = head.key;
                    V val = head.value;

                    // вызов функции вставки для каждого узла в temp
                    // поскольку новый список теперь bucketArray
                    insert(key, val);
                    head = head.next;
                }
            }

            System.out.println("\nРехеширование закончилось\n");
        }

        public void printMap()
        {

            // Настоящий список ведра составлен на временной основе.
            ArrayList<MapNode<K, V> > temp = buckets;

            System.out.println("Построенный HashMap:");
            // loop through all the nodes and print them
            for (int i = 0; i < temp.size(); i++) {

                // пройтись по всем узлам и распечатать их
                MapNode<K, V> head = temp.get(i);

                while (head != null) {
                    System.out.println("ключ = " + head.key + ", значение = " + head.value);

                    head = head.next;
                }
            }
            System.out.println();
        }
    }

    public static class HashNode<K, V> {
        K key;
        V value;

        // Ссылка на следующий узел
        HashNode<K, V> next;

        // Конструктор
        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    // Класс для представления всей хеш-таблицы
   public static class Map2<K, V> {
        // bucketArray используется для хранения массива цепочек
        private ArrayList<HashNode<K, V>> bucketArray;
        // Текущая емкость списка массивов
        private int numBuckets;
        // Текущий размер списка массивов
        private int size;

        // Конструктор (инициализирует емкость, размер и
        // пустые цепи.
        public Map2() {
            bucketArray = new ArrayList<>();
            numBuckets = 10;
            size = 0;

            // Создание пустых цепей
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        // Это реализует хеш-функцию для поиска индекса
        // для ключа
        private int getBucketIndex(K key) {
            int hashCode = key.hashCode();
            int index = hashCode % numBuckets;
            // key.hashCode() может быть отрицательным.
            index = index < 0 ? index * -1 : index;
            return index;
        }

        // Метод удаления данного ключа
        public V remove(K key) {
            // Применить хеш-функцию, чтобы найти индекс для данного ключа
            int bucketIndex = getBucketIndex(key);
            // Получить head цепи
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            // Поиск ключа в цепочке
            HashNode<K, V> prev = null;
            while (head != null) {
                // Если ключ найден
                if (head.key.equals(key))
                    break;

                // Иначе продолжайте двигаться по цепочке
                prev = head;
                head = head.next;
            }

            // Если бы ключа не было
            if (head == null)
                return null;

            // Уменьшить размер
            size--;

            // Удалить ключ
            if (prev != null)
                prev.next = head.next;
            else
                bucketArray.set(bucketIndex, head.next);

            return head.value;
        }

        // Возвращает значение ключа
        public V get(K key) {
            // Найти головку цепочки для данного ключа
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            // Поиск ключей в цепочке
            while (head != null) {
                if (head.key.equals(key))
                    return head.value;
                head = head.next;
            }

            // Если ключ не найден
            return null;
        }

        // Добавляет пару "ключ-значение" в хэш
        public void add(K key, V value) {
            // Найти head цепочки для данного ключа
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            // Проверить, присутствует ли уже ключ
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            // Вставить ключ в цепочку
            size++;
            head = bucketArray.get(bucketIndex);
            HashNode<K, V> newNode
                    = new HashNode<K, V>(key, value);
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode);

            // Если коэффициент загрузки превышает пороговое значение, то
            // размер двойной хеш-таблицы
            if ((1.0 * size) / numBuckets >= 0.7) {
                ArrayList<HashNode<K, V>> temp = bucketArray;
                bucketArray = new ArrayList<>();
                numBuckets = 2 * numBuckets;
                size = 0;
                for (int i = 0; i < numBuckets; i++)
                    bucketArray.add(null);

                for (HashNode<K, V> headNode : temp) {
                    while (headNode != null) {
                        add(headNode.key, headNode.value);
                        headNode = headNode.next;
                    }
                }
            }
        }
    }








    public static void main (String[]args) {
        Scanner scan = new Scanner(System.in);
        int n, min, max;
        System.out.println("Введите размерность набора данных:");
        n = scan.nextInt();
        System.out.println("Минимальный элемент генерации набора данных:");
        min = scan.nextInt();
        System.out.println("Максимальный элемент генерации набора данных:");
        max = scan.nextInt();

        int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                 a[i] = (int) (Math.random() * ((max - min) + 1)) + min;
            }

        System.out.println("Набор данных:");

        Lab_1.heapSort(a);
        Tree tree = new Tree();
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + "  ");
                tree.insertNode(a[i]);
        }

        int keySearch = 0;
        System.out.println("\n"+"Элемент для поиска:");
        keySearch = scan.nextInt();
        int first = 0; //первый элемент массива
        int last = a.length - 1; //последний элемент массива
        long time1 = System.nanoTime();
        System.out.println("Бинарный поиск нашел индекс = "+ binSearch(a,keySearch,first,last)+" time: "+(System.nanoTime()-time1) +"ns");
        long time2 = System.nanoTime();
        Node foundNode = tree.findNodeByValue(keySearch);
        foundNode.printNode();
        System.out.println(" time: "+(System.nanoTime()-time2) +"ns");
        long time3 = System.nanoTime();
        System.out.println("Фибоначчиев поиск нашел индекс = " + Fibonacci.fibMonaccianSearch(a,keySearch,n)+" time: "+(System.nanoTime()-time3) +"ns");
        long time4 = System.nanoTime();
        System.out.println("Интерполяционный поиск нашел индекс = " + interpolationSearch(a,keySearch)+" time: "+(System.nanoTime()-time4) +"ns");
        long time5 = System.nanoTime();
        System.out.println("Стандартный поиск = " + Arrays.stream(a).boxed().collect(Collectors.toList()).indexOf(keySearch) +" time: "+(System.nanoTime()-time5) +"ns");


        System.out.println("Добавть элемент: ");
        int addInt;
        addInt = scan.nextInt();
        a = addElement(a,addInt);
        Lab_1.heapSort(a);
        for (int i = 0; i < n+1; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("\n"+"Элемент для поиска:");
        keySearch = scan.nextInt();
        System.out.println("Интерполяционный поиск нашел индекс = " + interpolationSearch(a,keySearch));
        System.out.println("\n"+"Элемент для удаления:");
        keySearch = scan.nextInt();
        a = removeElement(interpolationSearch(a,keySearch),a);
        Lab_1.heapSort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "  ");
        }

        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(a.length);
        for (int i=0; i<a.length; i++)
        {
           table.put(i,a[i]);
        }
        System.out.println(table);
        table.get(5);




        System.out.println("\nРехеширование");
        Map<Integer, Integer> map = new Map<Integer, Integer>();
        for (int i=0; i<a.length; i++)
        {
            map.insert(i,a[i]);
        }
        map.printMap();
        map.rehash();
        map.printMap();

        System.out.println("\nМетод цепочек");
        Map2<Integer, Integer> map2 = new Map2<Integer, Integer>();
        for (int i=0; i<a.length; i++)
        {
            map2.add(i,a[i]);
            System.out.println("Ключ: " + map2.getBucketIndex(i) + " Значение: "+ map2.get(i));
        }
        System.out.println("Размер: "+map2.size);
        System.out.println("Удалить элемент по ключу: ");
        int d;
        d = scan.nextInt();
        map2.remove(d);
        for (int i=0; i<a.length; i++)
        {
            System.out.println("Ключ: " + map2.getBucketIndex(i) + " Значение: "+ map2.get(i));
        }
        System.out.println("Размер: "+map2.size);
        System.out.println("Найти элемент по ключу: ");
        int p;
        p = scan.nextInt();
        System.out.println("Найден элемент: " +map2.get(p));






        /*
        Table tab = new Table(a.length);
        for (int i=0; i<a.length; i++)
        {
           tab.put(i,a[i]);
        }
       tab.hashCode();
        tab.remove(5);
        tab.get(5);
        tab.showTable(); */


        /*for (int i=0; i<a.length; i++)
        {
            table.put(i,a[i]);
        }
        System.out.println("\n");
        for (int i=0; i<a.length; i++)
        {
            System.out.println(table);
        }

        table.remove(9);
        table.put(2,10);
        System.out.println("\n");
        for (int i=0; i<a.length; i++)
        {
            System.out.println(table);
        }


        System.out.println(table.get(3));*/



    }

}
