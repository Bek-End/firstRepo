package sample;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public abstract class Figure {

    private double x, y;

    public Figure(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Figure(){
        this.x = new Random().nextInt(900)+100;
        this.y = new Random().nextInt(340)+110;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    void show(GraphicsContext placeToDraw){};
    void remove(GraphicsContext placeToDraw){};

    public final void moveTo(double dx, double dy, GraphicsContext PlaceToDraw)
    {
        remove(PlaceToDraw);
        setX(dx);
        setY(dy);
        show(PlaceToDraw);
    };
}