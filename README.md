# Custom Java Collections Framework

This repository contains a custom implementation of a collections framework in Java. The framework includes a set of data structures that are commonly used in programming, such as dynamic arrays, linked lists, stacks, queues, and binary heaps.

## MyList.java

This is an interface defining the structure for our custom collections. It includes methods for adding, removing, and accessing elements, as well as methods for checking size, clearing the collection, and more. It extends `Iterable` to allow collections to be used in enhanced for loops.

## MyArrayList.java

This class implements the `MyList` interface using a dynamic array. As elements are added, the array grows to accommodate them. It includes methods to:

- Add elements to the collection.
- Retrieve elements by index.
- Remove elements by index.
- Clear the collection.
- Sort the collection using the `Comparable` interface.
- Convert the collection to an array.
- Iterate over the collection.

## MyLinkedList.java

`MyLinkedList` is a doubly-linked list implementation of the `MyList` interface. It supports efficient insertion and removal of elements at both ends of the list, and it includes all `MyList` methods, including:

- Methods to add elements at the start and end.
- Methods to remove elements from the start and end.
- Methods to access the first and last elements.

## MyStack.java

`MyStack` provides a standard stack implementation with methods to:

- `push`: Add an item to the top of the stack.
- `pop`: Remove the top item from the stack and return it.
- `peek`: Look at the top item on the stack without removing it.
- `isEmpty`: Check if the stack is empty.
- `size`: Return the number of items in the stack.

## MyQueue.java

`MyQueue` implements a queue with methods for:

- `enqueue`: Add an item to the end of the queue.
- `dequeue`: Remove the first item in the queue and return it.
- `peek`: Look at the first item in the queue without removing it.
- `isEmpty`: Check if the queue is empty.
- `size`: Return the number of items in the queue.

## MyMinHeap.java

`MyMinHeap` is a binary min-heap which provides efficient access to the smallest item. It includes methods to:

- `add`: Insert a new element into the heap.
- `remove`: Remove the smallest element and return it.
- `peek`: Retrieve the smallest element without removing it.
- `isEmpty`: Check if the heap is empty.
- `size`: Return the number of elements in the heap.

## Main.java

This is the entry point for testing the collections. It contains examples of how to use `MyArrayList`, `MyLinkedList`, `MyStack`, `MyQueue`, and `MyMinHeap`.
