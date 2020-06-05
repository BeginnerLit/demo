package com.example.demo;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

public class SubTest   {
    public final String first;
    public final String last;
    public final String address;

    public SubTest(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person:"+first+" "+last+" "+address;
    }

    public static class NullPerson extends SubTest implements Null {

        private NullPerson() {
            super("none", "none", "none");
        }
    }
    public static final SubTest NULL=new NullPerson();

    public static void main(String[] args) {
        System.out.println(SubTest.NULL);
    }
}
