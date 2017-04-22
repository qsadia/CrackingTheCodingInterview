package Moderate;

import java.awt.Point;

public class LineIntersection {

	public static class Line {
		public double slope;
		public double yIntercept;

		public Line(Point start, Point end) {
			this.slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
			this.yIntercept = end.getY() - this.slope * end.getX();
			System.out.println("Slope = " + slope + " y Intercept = " + yIntercept);
		}
	}

	private Line l1;
	private Line l2;

	public LineIntersection(Line l1, Line l2) {
		this.l1 = l1;
		this.l2 = l2;
	}

	public void printIntersection() {

		if (l1.slope == l2.slope && l1.yIntercept == l2.yIntercept) {
			System.out.println("They are the same line");
		}

		else if (l1.slope == l2.slope) {
			System.out.println("The lines are parallel.");
		}

		// Intersection exists
		double xIntersection = (l2.yIntercept - l1.yIntercept) / (l1.slope - l2.slope);
		double yIntersection = l1.slope * xIntersection + l1.yIntercept;

		System.out.println("Intersection is: x = " + xIntersection + " y = " + yIntersection);
	}


	public static void main(String[] args) {
		Line l1 = new Line(new Point(-1,-2), new Point(8, 7));
		Line l2 = new Line(new Point(-2,1), new Point(8, 9));
		LineIntersection l = new LineIntersection(l1, l2);
		l.printIntersection();
	}

}
