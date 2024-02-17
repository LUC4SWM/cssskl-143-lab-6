import java.awt.*;

public class FractalFlake extends Shape {
    private final int limit;
    private final int numBranches;
    private final int size;
    public FractalFlake(int x, int y, int size, int limit, int numBranches){
        super(x,y);
        this.size = size;
        this.limit = validateLimit(limit);
        this.numBranches = validateNumBranches(numBranches);
    }
    private int validateLimit(int limit){
        return Math.max(1, Math.min(50, limit));
    }
    private int validateNumBranches(int numBranches){
        return Math.max(5, Math.min(12, numBranches));
    }

    @Override
    public void draw(Graphics g) {
        draw(g, getX(), getY(), limit);
    }
    private void draw(Graphics g, int startX, int startY, int limit){
        if (limit >= 3){
            for (int i = 0; i < numBranches; i++){
                int x2 = startX + (int) (limit * Math.cos((2 * Math.PI / numBranches) * i));
                int y2 = startY - (int) (limit * Math.sin((2 * Math.PI / numBranches) * i));
                g.drawLine(startX, startY,x2, y2);
                draw(g, x2, y2, limit/3);
            }
        }
    }

}
