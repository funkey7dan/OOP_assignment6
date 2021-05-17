//XXXXXXXXX

/**
 * The interface for hittable objects.
 * <p>
 * Supports getting the collision shape of an object, and the hit logic.
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     *
     * @return the shape of the collision
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  - the collision point with the object
     * @param currentVelocity - the current velocity of the hitting object
     * @return the new velocity for the hitting object.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Adds the object to the game.
     *
     * @param g - the game we want to add to.
     */
    void addToGame(Game g);

    /**
     * @return returns the type of object.
     */
    String getType();//TODO check if redundant


}

