package sample;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public class LinkedList {
    private final Random random = new Random();

    private Node head = null;
    private Node tail = null;

    public void add(Figure data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void addAtStart(Figure data){
        Node newNode = new Node(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    void iterator(String action, GraphicsContext gc){
        Node current = head;
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        while(current != null) {
            Figure tFigure = current.getData();
            switch (action){
                case ("Show"):
                    tFigure.show(gc);
                    break;
                case ("RemoveAll"):
                    if(tFigure instanceof CirclePro){
                        tFigure.remove(gc);
                    }
                    if(tFigure instanceof SquarePro){
                        tFigure.remove(gc);
                    }
                    if(tFigure instanceof EllipsePro){
                        tFigure.remove(gc);
                    }
                    if(tFigure instanceof RectanglePro){
                        tFigure.remove(gc);
                    }
                    if(tFigure instanceof LinePro){
                        tFigure.remove(gc);
                    }
                    if (current == tail){
                        head = null;
                        tail = null;
                    }
                    break;

                case ("MoveCircle"):
                    if (tFigure instanceof CirclePro){
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y,gc);
                    }
                    break;

                case ("MoveSquare"):
                    if (tFigure instanceof SquarePro){
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y,gc);
                    }
                    break;
                case ("MoveEllipse"):
                    if (tFigure instanceof EllipsePro){
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x, y,gc);
                    }
                    break;
                case ("MoveRectangle"):
                    if (tFigure instanceof RectanglePro){
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x,y,gc);
                    }
                    break;
                case ("MoveLine"):
                    if (tFigure instanceof LinePro){
                        double x = random.nextInt(800);
                        double y = random.nextInt(450);
                        tFigure.moveTo(x,y,gc);
                    }
                    break;
            }
            current = current.getNext();
        }
    }
}