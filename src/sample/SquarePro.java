package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class SquarePro extends RectanglePro{
    private final int r2;

    public SquarePro(){
        super();
        this.r2 = new Random().nextInt(60)+10;
    }

    @Override
    public void show(GraphicsContext PlaceToDraw){
        PlaceToDraw.fillRect(getX(),getY(),getR(),r2);
        PlaceToDraw.setFill(getColor());
        System.out.println("I can hear you");
    }

    @Override
    public void remove(GraphicsContext PlaceToDraw){
        PlaceToDraw.setFill(Color.WHITE);
        PlaceToDraw.setStroke(Color.WHITE);
        PlaceToDraw.fillRect(getX(),getY(),getR(),r2);
    }
}