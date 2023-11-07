package com.core;

public enum MessPlan {
	MONTHLY(3000), QUARTERLY(11700), HALFYEAR(17500),YEARLY(32000);
	
	private int cost;
	MessPlan(int cost){
		this.cost=cost;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
