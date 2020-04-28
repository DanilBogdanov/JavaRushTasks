package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String elementName) {
        List<Entry> rootEntry = new ArrayList<>();
        List<Entry> branchEntry = new ArrayList<>();

        rootEntry.add(root);

        boolean isAdded = false;

        while (!isAdded) {
            for (Entry<String> entry : rootEntry) {
                if (entry.isAvailableToAddChildren()) {
                    Entry<String> newEntry = new Entry<>(elementName);
                    newEntry.parent = entry;

                    if (entry.availableToAddLeftChildren) {
                        entry.leftChild = newEntry;
                        entry.availableToAddLeftChildren = false;
                    } else {
                        entry.rightChild = newEntry;
                        entry.availableToAddRightChildren = false;
                    }

                    isAdded = true;
                    size++;
                    break;
                }

                //add branches from root
                branchEntry.add(entry.leftChild);
                branchEntry.add(entry.rightChild);
            }

            //If didn't find free an entry to add, then get all branches from root
            rootEntry = new ArrayList<>(branchEntry);
            branchEntry.clear();
        }

        return true;
    }

    public String getParent(String value) {
        List<Entry> parentEntries = new ArrayList<>();
        List<Entry> branchesEntries = new ArrayList<>();

        if (root.leftChild != null) {
            parentEntries.add(root.leftChild);
        }
        if (root.rightChild != null) {
            parentEntries.add(root.rightChild);
        }

        while (!parentEntries.isEmpty()) {
            for (CustomTree.Entry entry : parentEntries) {
                if (entry.elementName.equals(value)) {
                    return entry.parent.elementName;
                }

                if (entry.leftChild != null) {
                    branchesEntries.add(entry.leftChild);
                }
                if (entry.rightChild != null) {
                    branchesEntries.add(entry.rightChild);
                }
            }

            parentEntries = new ArrayList<>(branchesEntries);
            branchesEntries.clear();
        }
        return null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public CustomTree() {
        this.root = new Entry<String>("0");
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    void printTree() {
        List<Entry> parentEntries = new ArrayList<>();
        List<Entry> branchesEntries = new ArrayList<>();

        if (root.leftChild != null) {
            parentEntries.add(root.leftChild);
        }
        if (root.rightChild != null) {
            parentEntries.add(root.rightChild);
        }

        while (!parentEntries.isEmpty()) {
            for (Entry entry : parentEntries) {
                System.out.printf("name-%s parent-%s\n", entry.elementName, entry.parent.elementName);

                if (entry.leftChild != null) {
                    branchesEntries.add(entry.leftChild);
                }
                if (entry.rightChild != null) {
                    branchesEntries.add(entry.rightChild);
                }
            }

            parentEntries = new ArrayList<>(branchesEntries);
            branchesEntries.clear();
        }

    }
}
