package cc189.ch3;

import java.util.*;

/**
 * Created by xu_xt on 10/9/18.
 */
public class Shelter {
    private Map<AnimalType, Queue<Animal>> map;
    private int order;
    Shelter() {
        map = new HashMap<>();
    }

    public void enqueue(Animal animal) {
        if (!map.containsKey(animal.getType())) {
            map.put(animal.getType(), new LinkedList<>());
        }
        animal.setOrder(order++);
        map.get(animal.getType()).add(animal);
    }

    public Animal dequeue(AnimalType type) {
        if (!map.containsKey(type)) {
            return null;
        }
        return map.get(type).poll();
    }

    public Animal dequeueAny() {
        Animal a = null;
        for (Queue<Animal> q : map.values()) {
            if (q.isEmpty()) {
                continue;
            }
            if (a == null || a.compareTo(q.peek()) > 0) {
                a = q.peek();
            }
        }
        if (a == null) {
            return null;
        } else {
            return map.get(a.getType()).poll();
        }
    }

    public abstract class Animal implements Comparable<Animal>{
        private int order;

        @Override
        public int compareTo(Animal a) {
            return this.order - a.order;
        }
        public abstract AnimalType getType();
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }
    }

    public class Dog extends Animal{
        public AnimalType getType(){
            return AnimalType.DOG;
        }
    }

    public class Cat extends Animal{
        public AnimalType getType() {
            return AnimalType.CAT;
        }
    }

    public enum AnimalType {
        DOG,
        CAT;
    }

}


