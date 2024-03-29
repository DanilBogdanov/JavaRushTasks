package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;
    private static final long serialVersionUID = 1L;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max((int) (Math.ceil(collection.size() / .75f)), 16);
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }

    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Set<E> setToSeril = new HashSet<>(map.keySet());
        stream.writeObject(setToSeril);
        int capacity = (int) HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        stream.writeInt(capacity);
        float loadFactor = (float) HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        stream.writeFloat(loadFactor);
        stream.close();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Set<E> set = (Set<E>) stream.readObject();
        int capacity = stream.readInt();
        float loadFactor = stream.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        for (E object : set) {
            map.put(object, PRESENT);
        }

        stream.close();
    }

    public static void main(String[] args) throws Exception {
        AmigoSet<Integer> firstSet = new AmigoSet<>();
        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(3);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(firstSet);
        firstSet.clear();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        AmigoSet<Integer> secondSet = (AmigoSet<Integer>) ois.readObject();

        System.out.println("first set");
        for (Integer integer : firstSet) {
            System.out.println("\t" + integer);
        }
        System.out.println("\nsecond set");
        for (Integer integer : secondSet) {
            System.out.println("\t" + integer);
        }

    }
}
