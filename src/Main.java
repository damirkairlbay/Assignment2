public class Main {
    public static void main(String[] args) {
        MyArrayList<String> itemList = new MyArrayList<>();
        MyLinkedList<Integer> numberList = new MyLinkedList<>();

        itemList.add("new_item_1");
        itemList.add("new_item_2");
        itemList.add("new_item_3");
        itemList.add("new_item_4");
        itemList.add("new_item_5");
        itemList.printArray();
        System.out.println("Current size of array: " + itemList.getSize());
        itemList.add("new_item_6");
        itemList.add("new_item_7");
        itemList.add("new_item_8");

        itemList.printArray();
        System.out.println("Size after additions: " + itemList.getSize());
        itemList.remove(6);
        itemList.printArray();
        System.out.println("Size after removal: " + itemList.getSize());
        itemList.clear();
        System.out.println("Size after clear: " + itemList.getSize());

        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        System.out.println(numberList.get(2));
    }
}
