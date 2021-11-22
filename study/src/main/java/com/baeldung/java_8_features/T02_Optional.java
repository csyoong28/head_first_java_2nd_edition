package com.baeldung.java_8_features;

import java.util.Optional;

public class T02_Optional {
    public static void main(String[] args) {
//        optionalMap();
        optionalThrow();
    }
    
    public static void optionalMap() {
        User user = new User();
        Optional<User> userOptional = Optional.ofNullable(user);
        String result = userOptional
          .map(User::getAddress)
          .map(Address::getStreet)
          .orElse("not specified");
        System.out.println(result);
    }
    
    public static void optionalThrow() {
        String value = "aaa";   //or null
        Optional<String> valueOpt = Optional.ofNullable(value);
        String result = valueOpt.orElseThrow(CustomException::new).toUpperCase();
        System.out.println(result);
    }
}
