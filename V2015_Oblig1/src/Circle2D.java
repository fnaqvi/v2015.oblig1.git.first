public class Circle2D {

	// Data fields (private)
	private double x;
	private double y;
	private double radius;

	// Getters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	/**
	 * Creates a circle with centre at origin (0, 0) and radius 1
	 */
	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	/**
	 * Creates a circle at a given point (supplied as (x, y)) and given radius
	 * 
	 * @param x
	 *            x-coordinate of centre
	 * @param y
	 *            y-coordinate of centre
	 * @param radius
	 */
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * Returns area of the circle
	 */
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	/**
	 * Returns perimeter (circumference) of the circle
	 */
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	/**
	 * Determines if this circle contains a given point (supplied as (x, y))
	 * 
	 * @param x
	 *            x-coordinate of the point in question
	 * @param y
	 *            x-coordinate of the point in question
	 */
	public boolean contains(double x, double y) {
		Boolean containsPoint = (this.distanceFromMyCentre(x, y) < this.radius);

		return containsPoint;
	}

	/**
	 * Determines if this circle contains a given circle (supplied as a Circle2D
	 * object)
	 * 
	 * @param otherCircle
	 *            another circle of type Circle2D
	 */
	public boolean contains(Circle2D otherCircle) {
		double distanceBetweenCentres = distanceFromMyCentre(otherCircle.x,
				otherCircle.y);

		boolean containsOtherCircle = (distanceBetweenCentres <= Math
				.abs(this.radius - otherCircle.radius));

		return containsOtherCircle;
	}

	/**
	 * Determines if this circle overlaps a given circle (supplied as a Circle2D
	 * object)
	 * 
	 * @param otherCircle
	 *            another circle of type Circle2D
	 */
	public boolean overlaps(Circle2D otherCircle) {
		double distanceBetweenCentres = distanceFromMyCentre(otherCircle.x,
				otherCircle.y);

		boolean overlapsOtherCircle = (distanceBetweenCentres <= (this.radius + otherCircle.radius));

		return overlapsOtherCircle;
	}

	private double distanceFromMyCentre(double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - this.getX(), 2)
				+ Math.pow(y2 - this.getY(), 2));
	}
	
	
	// Main method
	public static void main(String[] args) {

		Circle2D c1 = new Circle2D(2, 5, 5.5);

		System.out
				.format("Circle with centre (%.2f, %.2f) and radius %.2f has area %.2f and perimeter %.2f.\n",
						c1.getX(), c1.getY(), c1.getRadius(), c1.getArea(),
						c1.getPerimeter());

		Double x = 3.0, y = 3.0;
		System.out.format("The circle '"
				+ (c1.contains(x, y) ? "contains" : "does not contain")
				+ "' point (%.2f, %.2f).\n", x, y);
		
		Circle2D c2 = new Circle2D(4, 5, 10.5);
		System.out.format("The circle '"
				+ (c1.contains(c2) ? "contains" : "does not contain")
				+ "' circle with centre (%.2f, %.2f) and radius %.2f.\n", c2.getX(), c2.getY(), c2.getRadius());
		
		Circle2D c3 = new Circle2D(3, 5, 2.3);
		System.out.format("The circle '"
				+ (c1.contains(c3) ? "overlaps" : "does not overlap")
				+ "' circle with centre (%.2f, %.2f) and radius %.2f.\n", c3.getX(), c3.getY(), c3.getRadius());
	}
}
