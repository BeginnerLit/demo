package com.example.demo;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount=0;

    public InstrumentedSet(Set<E> s){
        super(s);
    }

    public InstrumentedSet() {
        super();
    }

    @Override
    public boolean add(E o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
