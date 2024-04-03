package day02;

import java.util.Comparator;

public class Point {

	int x;
	int y;

	public Point() {

	}

	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

class Pointx implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {
		return p1.x - p2.x; // 내림차순
	}
}

class Pointy implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {

		if (p1.x == p2.x) {
			return p2.y - p1.y; // 내림차순
		}
		return p1.x - p2.x;
	}
}