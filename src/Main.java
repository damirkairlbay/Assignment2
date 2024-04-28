public class Main {
    public static void main(String[] args) {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");
        stringList.sort();
        for (String s : stringList) {
            System.out.println(s);
        }

        MyLinkedList<Integer> integerList = new MyLinkedList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        integerList.sort();
        for (int i : integerList) {
            System.out.println(i);
        }
    }
}
