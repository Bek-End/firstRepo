package sample;
import javafx.scene.canvas.GraphicsContext;
import java.util.Arrays;
import java.util.Random;

public class ArrayContainer {
    private final Random random = new Random();
    private Figure[] elements;
    private int index = 0;

    public ArrayContainer() {
        elements = new Figure[10];
    }

    public void add(Figure shape){
        if (index >= elements.length){
            growArray();
        }
        elements[index++] = shape;
    }

    private void growArray() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    Figure get(int index) {
        return elements[index];
    }

    void iterator(String action, GraphicsContext gc) {
        for (int i = 0; i < index; i++) {
            Figure tFigure = get(i);
            switch (action) {
                case ("Show"):
                    tFigure.show(gc);
                    break;
                case ("RemoveAll"):{
                    tFigure.remove(gc);
                    remove(i);
                    break;
                }
                case ("MoveCircle"):
                    if (tFigure instanceof CirclePro) {
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y, gc);
                    }
                    break;

                case ("MoveRectangle"):
                    if (tFigure instanceof RectanglePro) {
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y, gc);
                    }
                    break;
                case ("MoveEllipse"):
                    if (tFigure instanceof EllipsePro) {
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y, gc);
                    }
                    break;
                case ("MoveLine"):
                    if (tFigure instanceof LinePro) {
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y, gc);
                    }
                    break;
                case ("MoveSquare"):
                    if (tFigure instanceof SquarePro) {
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y, gc);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public void remove(int index_1){
        for (int j = index_1; j < index - 1; j++) {
            elements[j] = elements[j + 1];
        }
        index--;
    }
}