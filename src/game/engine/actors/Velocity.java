//XXXXXXXXX
package game.engine.actors;

import game.ui.shapes.Point;

/**
 * @author Daniel Bronfman
 * @Email: <daniel.bronfman2010@gmail.com>
 * game.engine.actors.Velocity specifies the change in position on the `x` and the `y` axes.
 * Supports applying the change in position to a given point, and the reverse of it.
 */
public class Velocity {

    // the horizontal component of the velocity
    private double dx;

    // the vertical component of the velocity
    private double dy;

    // the difference in the position we want to set
    private static final double DELTA = 3;

    private double speed;

    /**
     * Constructor for game.engine.actors.Velocity.
     *
     * @param dx - the horizontal component of the velocity
     * @param dy - the vertical component of the velocity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;

    }

    /**
     * Constructor for Velocity.
     *
     * @param dx    - the horizontal component of the velocity
     * @param dy    - the vertical component of the velocity
     * @param speed1 - the speed.
     */
    public Velocity(double dx, double dy, double speed1) {
        this.dx = dx;
        this.dy = dy;
        this.speed = speed1;

    }

    /**
     * Converts angle and speed to vertical and horizontal deltas.
     * We using trigonometric functions to separate the given speed into it's components.
     *
     * @param angle - the angle of the velocity.
     * @param speed - the change in the position.
     * @return returns the converted velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {

        //convert the angle to Radians
        angle = Math.toRadians(angle);


        // sin(x) = Opposite / hypotenuse
        double dx = Math.sin(angle) * speed;

        // cos(x) = Adjacent / hypotenuse
        double dy = -(Math.cos(angle) * speed);
        return new Velocity(Math.round(dx), Math.round(dy), speed);
    }

    /**
     * Sets speed.
     *
     * @param speed1 the speed
     */
    public void setSpeed(double speed1) {
        double angle = Math.toDegrees(Math.asin(this.dx / 3));
        this.speed = speed1;
        this.dx = Math.sin(angle) * speed;
        this.dy = (Math.cos(angle) * speed);
    }


    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    //accessors
    //getters

    /**
     * @return returns the horizontal speed.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return returns the vertical speed.
     */
    public double getDy() {
        return this.dy;
    }


    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p - the point we apply to
     * @return returns the modified point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + Math.round(this.dx), p.getY() + Math.round(this.dy));
    }


    /**
     * Take the collision point and return a point almost, but not quite, entirely unlike the collision point.
     *
     * @param p         - the point we apply to
     * @param direction - the direction from where the hit happened
     * @return returns the modified point
     */
    public Point applyLessToPoint2(Point p, String direction) {

        switch (direction) {
            case ("top"):
                return new Point(p.getX(), p.getY() - DELTA);

            case ("left"):
                return new Point(p.getX() - DELTA, p.getY());

            case ("right"):
                return new Point(p.getX() + DELTA, p.getY());

            case ("bottom"):
                return new Point(p.getX(), p.getY() + DELTA);
            default:
            case (""):
                return applyToPoint(p);
        }
    }

}