package com.example.demo;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> t){
        type=t;
    }
    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static <T> Generator<T> creat(Class<T> type){
        return new BasicGenerator<>(type);
    }
}

class CountedObject{
    private static long counter=0;
    private final long id=counter++;
    public long id(){
        return id;
    }
    public String toString(){
        return "CountedObject "+id;
    }

    public static void main(String[] args) {
        //Generator<CountedObject> gen=BasicGenerator.creat(CountedObject.class);
        Generator<CountedObject> gen=new BasicGenerator<>(CountedObject.class);
        for (int i=0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}
