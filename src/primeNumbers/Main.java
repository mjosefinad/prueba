package primeNumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		String path = "inputFile/numbers.txt";;
		ArrayList<Integer> testCases = generateList(path);
				
		for (Integer test : testCases) {
			
			ArrayList<Integer> primes = new ArrayList<Integer>();
			
			int j = 2;
			while (j < test){
				
				if (isPrime(j) ){
					
					primes.add(j);
					
				}
				j++;
			}
			
			printList(primes);
		}

	}
	
private static boolean isPrime (Integer p){
		
		for (int i = 2; i <= p / 2; i++) {
			
			if (p % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static ArrayList<Integer> generateList(String path){
	
		ArrayList<Integer> testCases = new ArrayList<Integer>();
		try {
			for (String line : Files.readAllLines(Paths.get(path))) {
				
				 Integer i = Integer.parseInt(line);
				 testCases.add(i);
				        
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return testCases;
	}
	
	private static void printList(List<Integer> newList){
		
		Iterator<Integer> i = newList.iterator();
		  if (i.hasNext()) {
		    System.out.print(i.next());
		    while (i.hasNext())
		      System.out.print(","+i.next());
		  }
		  System.out.println();
		
	}

}
