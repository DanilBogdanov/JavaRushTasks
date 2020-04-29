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

    //include fist element
    private int getSizeOfEntry(Entry entry) {
        List<Entry> parentEntries = new ArrayList<>();
        List<Entry> branchesEntries = new ArrayList<>();

        if (entry == null) {
            return 0;
        }
        int count = 1;

        if (entry.leftChild != null) {
            parentEntries.add(root.leftChild);
        }
        if (entry.rightChild != null) {
            parentEntries.add(root.rightChild);
        }

        while (!parentEntries.isEmpty()) {
            for (CustomTree.Entry e : parentEntries) {
                count++;

                if (e.leftChild != null) {
                    branchesEntries.add(e.leftChild);
                }
                if (e.rightChild != null) {
                    branchesEntries.add(e.rightChild);
                }
            }

            parentEntries = new ArrayList<>(branchesEntries);
            branchesEntries.clear();
        }
        return count;
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
                if (entry.leftChild != null) {
                    branchEntry.add(entry.leftChild);
                }
                if (entry.rightChild != null) {
                    branchEntry.add(entry.rightChild);
                }
            }

            //If didn't find free an entry to add, then get all branches from root
            rootEntry = new ArrayList<>(branchEntry);
            branchEntry.clear();

            if (rootEntry.size() == 0) {
                rootEntry.add(root);
                fixRoot();
            }
        }

        return true;
    }

    private void fixRoot() {
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
                if (!entry.isAvailableToAddChildren() &&
                        (entry.leftChild == null && entry.rightChild == null)) {
                    entry.availableToAddLeftChildren = true;
                    entry.availableToAddRightChildren = true;
                    return;
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

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        String elementName = (String) o;
        Entry<String> removeEntry = findElement(elementName);
        if (removeEntry == null) {
            return false;
        }

        //size -= getSizeOfEntry(removeEntry);

        Entry parent = removeEntry.parent;

        if (parent.leftChild == removeEntry) {
            parent.leftChild = null;
            //parent.availableToAddLeftChildren = true;
        } else {
            parent.rightChild = null;
            //parent.availableToAddRightChildren = true;
        }

        size = getSizeOfEntry(root) - 1;
        return true;
    }

    //return first finded element
    private Entry<String> findElement(String elementName) {
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
                if (entry.elementName.equals(elementName)) {
                    return entry;
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
