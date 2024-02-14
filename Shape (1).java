import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 *
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

// The superclass in our inheritance hierarchy. All "common" features, functions and data
// should go here. For example, all shapes in Java 2D have an (x, y) that declares their
// position, and many of the shapes exposed have a width and a height (but not all, so we
// didn't put width and height here). Note that this class is mostly empty, as there is
// no algorithm generic enough to guess an arbitrary shape's area (future subclasses must
// override getArea() to provide something reasonable). Also, the draw method is empty too,
// as we don't know what shape to draw here! (Again, our subclasses will need to replace
// this method with one that actually draws things).
class Shape extends Object {
    private int x = 0;
    private int y = 0;

    public Shape(int a, int b) {
        x = a;
        y = b;
    }

    public double getArea() {
        return -1;
    }

    public void draw(Graphics g) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}