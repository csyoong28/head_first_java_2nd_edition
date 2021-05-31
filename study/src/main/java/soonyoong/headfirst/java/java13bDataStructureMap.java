package soonyoong.headfirst.java;

import java.util.*;
import java.io.*;

public class java13bDataStructureMap {
	public static void main(String[] args) {
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("Kathy", 42);
		scores.put("Bert", 343);
		scores.put("Skyler", 420);
		System.out.println(scores);
		System.out.println(scores.get("Bert"));
	}
}
