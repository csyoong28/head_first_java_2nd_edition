package soonyoong.headfirst.java;

import com.Box;

public class java13gGenericClass {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
      
       // integerBox.add(new Integer(10));  //compile error
        stringBox.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
     }

}
