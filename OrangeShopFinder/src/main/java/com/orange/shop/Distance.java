package com.orange.shop;

public class Distance {
	public double distance;
	public Line line;
	public double getDistance() {
		return distance;
	}
	public Distance(double value, Line line) {
		super();
		this.distance = value;
		this.line = line;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}

}
