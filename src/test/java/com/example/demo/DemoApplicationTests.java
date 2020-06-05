package com.example.demo;

import net.bytebuddy.asm.Advice;
import org.apache.el.parser.AstMapData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
      //  LinkedList
        ArrayList arrayList=new ArrayList();
       // arrayList.forEach();
        System.out.println(arrayList.size());

        Tuple<TupleA,TupleB> tuple=new Tuple<>(null,null);
        tuple.setTwo(new TupleB());
        tuple.getTwo().setS("111");
        System.out.println(tuple.getTwo().getS());
        System.out.println(tuple.getTwo());
    }
}
