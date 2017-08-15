package br.com.vgusmao.streams;

import java.util.Iterator;
import java.util.stream.Stream;

public class StreamWork implements IVstream{
	
	private Stream<Character> stream;
	private Iterator<Character> iterator;
	private int aCount;
	private int eCount;
	private int iCount;
	private int oCount;
	private int uCount;
	private char last;
	private char beforeLast;
	
	public StreamWork(Stream<Character> stream){
		this.stream = stream;
		this.iterator = stream.iterator();
	}
	
	@Override
	public Boolean hasNext() {		
		return iterator.hasNext();
	}

	@Override
	public char getNext() {
		return this.iterator.next();
	}	
	
	
	public char firstChar(Stream input) { 
		String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
		String vowels = "aeiouAEIOU";
		char tempChar = '\u0000';
		while(hasNext()){
		
			char current = getNext();
			//boolean hasNext =  hasNext();
			
			if(current == 'a'){		
				aCount++;
				if(aCount == 1 
						&& consonants.contains(String.valueOf(last)) 
						&& vowels.contains(String.valueOf(beforeLast)));
					tempChar = current;
			}
			
			else if(current == 'e'){
				eCount++;
				if(eCount == 1 
						&& consonants.contains(String.valueOf(last)) 
						&& vowels.contains(String.valueOf(beforeLast)));
					tempChar = current;
			}
			
			else if(current == 'i'){		
				iCount++;
				if(iCount == 1 
						&& consonants.contains(String.valueOf(last)) 
						&& vowels.contains(String.valueOf(beforeLast)));
					tempChar = current;				
			}
			
			else if(current == 'o'){		
				oCount++;
				if(oCount == 1 
						&& consonants.contains(String.valueOf(last)) 
						&& vowels.contains(String.valueOf(beforeLast)));
					tempChar = current;
			}
			
			else if(current == 'u'){		
				uCount++;
				if(uCount == 1 
						&& consonants.contains(String.valueOf(last)) 
						&& vowels.contains(String.valueOf(beforeLast)));
					tempChar = current;
			}
			beforeLast = last;
			last = current;
		}
		return tempChar;		
	}
	
	public static void main(String[] args) {		
		
		Stream<Character> chars = "aAbBABacafe".chars().mapToObj(i -> (char)i);
		
		StreamWork ws = new StreamWork(chars);
		
		System.out.println(ws.firstChar(chars));
		
	}

}
