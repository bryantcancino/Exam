package www.bryant.cancino.com;

import java.awt.Point;
import java.util.ArrayList;

public class Main {

    static void printArray(ArrayList<Point> points) {
		for (int i = 0; i < points.size(); i++){
			System.out.println("(" + points.get(i).x + ", " + points.get(i).y + ")");
		}
    }
    
    static Boolean validationArray(ArrayList<Point> points) {
		if (points.size() < 3) {
			return false;
		}
		for (int i = 0; i < points.size(); i++){
			if(points.get(i).x < 0 || points.get(i).y < 0) {
				return false;
			}
		}
		
		return true;
    }    

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<Point>();

		points.add(new Point(13, 10));
		points.add(new Point(12, 0));
		points.add(new Point(2, 10));
		points.add(new Point(2, 5));
		points.add(new Point(17, 1));
		points.add(new Point(17, 1));
		points.add(new Point(3, 15));
		points.add(new Point(6, 12));
		points.add(new Point(2, 10));
		points.add(new Point(16, 5));


		if(!validationArray(points)) {
			System.out.println("Check the format");
			return;
		}
		
		points = Perimeter.addStartEndPoints(points);
		points = Perimeter.deleteRepeatedPoints(points);
		points = Perimeter.cleanHorizontalPoints(points);		
		printArray(points);
		Frame.drawGraphic(points);
	}

}
