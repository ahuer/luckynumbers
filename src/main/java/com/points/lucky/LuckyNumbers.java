package com.points.lucky;

import java.util.HashSet;
import java.util.Set;

public class LuckyNumbers {
	private Set<Integer> luckySet = new HashSet<>();
	private int originalNumber;
	private final int MAX_ITERATIONS = 100;
	private final int BASE_CASE = 1;
	
	public boolean isLucky(int num){	
		if (num == 0) {
			return false;
		}
		if (this.luckySet.contains(num)){
			return true;
		}
		this.originalNumber = num;
		return recursiveLucky(num, 1);
	}
	
	private boolean recursiveLucky(int num, int recCount){
		if(num == this.BASE_CASE){
			this.luckySet.add(this.originalNumber);
			return true;
		}
		if(recCount >= this.MAX_ITERATIONS){
			return false;
		}
		
		int result = luckify(num);		
		return recursiveLucky(result, recCount + 1);		
	}
	
	private static int luckify(int num){
		int squareSum = 0;
		int divResult = num;
		
		while(divResult != 0) {
			squareSum += (int)Math.pow((divResult % 10),2);
			divResult = divResult / 10;
		}
		
		return squareSum;
	}
	
	public int getCacheSetSize() {
		return this.luckySet.size();
	}

}
