package www.bryant.cancino.com;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Perimeter {

	public static ArrayList<Point> addStartEndPoints(ArrayList<Point> points) {

		int minPoint = -1, maxPoint = -1;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		for (int i = 0; i < points.size(); i++) {

			if (points.get(i).x < minX) {
				minX = points.get(i).x;
				minPoint = i;
			}
			if (points.get(i).x > maxX) {
				maxX = points.get(i).x;
				maxPoint = i;
			}
		}
		Point ini = points.get(minPoint);
		Point end = points.get(maxPoint);

		if (ini.y != 0) {
			points.add(0, new Point(ini.x, 0));
		}
		if (end.y != 0) {
			points.add(new Point(end.x, 0));
		}

		return points;
	}

	public static ArrayList<Point> deleteRepeatedPoints(ArrayList<Point> points) {

		ArrayList<Point> cleanPoints = new ArrayList<Point>();

		for (int i = 0; i < points.size(); i++) {
			if (!cleanPoints.contains(points.get(i))) {
				cleanPoints.add(points.get(i));
			}
		}
		return cleanPoints;
	}

	public static ArrayList<Point> cleanHorizontalPoints(ArrayList<Point> points) {

		Collections.sort(points, new Comparator<Point>() {
			private Integer X1;
			private Integer X2;
			private Integer Y1;
			private Integer Y2;

			@Override
			public int compare(Point o1, Point o2) {
				this.X1 = o1.x;
				this.X2 = o2.x;
				this.Y1 = o1.y;
				this.Y2 = o2.y;

				if (X1.equals(X2)) {
					return Y1.compareTo(Y2);
				}
				return X1.compareTo(X2);
			}
		});

		Integer nextValueX = null;
		for (int i = 0; i < points.size(); i++) {			
			
			if (i < points.size() - 1) {
				nextValueX = points.get(i + 1).x;
				
				if(i < points.size() - 2 && 
						points.get(i).x == points.get(i + 1).x &&
						points.get(i).x == points.get(i + 2).x) {
					points.remove(i+1);	
				}
				
			} else {
				nextValueX = null;
			}
			
			if (nextValueX != null && points.get(i).x != nextValueX) {
				points.add((i+1), new Point(points.get(i+1).x, points.get(i).y));
				i=i+1;
			}
		}

		return points;
	}
}
