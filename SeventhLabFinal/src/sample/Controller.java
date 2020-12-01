package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
    @FXML
    public Button MoveBtn = new Button();
    @FXML
    public Button DestroyBtn = new Button();
    @FXML
    public ComboBox<String> ContainerPicker = new ComboBox<>();
    @FXML
    public Button CreateEmptyContainer = new Button();
    @FXML
    public Button CreateFullContainer = new Button();
    @FXML
    private Button RCreate = new Button();
    @FXML
    private Button Rotate = new Button();
    @FXML
    private ComboBox<String> ShapeBox = new ComboBox<>();
    @FXML
    private ListView<String> BoxList = new ListView<>();
    @FXML
    public Canvas PlaceToDraw = new Canvas();
    @FXML
    public ComboBox<String> FigurePicker = new ComboBox<>();
    @FXML
    public Group group = new Group();
    private final ArrayList<String> arrShapes = new ArrayList<>();
    private final ObservableList<String> list = FXCollections.observableArrayList("Circle", "Rectangle", "Line", "Ellipse", "Square");
    private final ObservableList<String> contain = FXCollections.observableArrayList("Array", "List");
    private final ObservableList<String> figures = FXCollections.observableArrayList("All","Circle", "Rectangle", "Line", "Ellipse", "Square");
    private final ObservableList<String> shapes = FXCollections.observableArrayList(arrShapes);
    private int SELECTED_INDEX;
    private static CirclePro circlePro;
    private static RectanglePro rectanglePro;
    private static LinePro linePro;
    private static EllipsePro ellipsePro;
    private static SquarePro squarePro;
    ArrayContainer arrayContainer;
    LinkedList linkedList;

    public Controller() {
    }

    @FXML
    void initialize() {
        GraphicsContext graphicsContext = PlaceToDraw.getGraphicsContext2D();
        ShapeBox.setItems(list);
        BoxList.setItems(shapes);
        ContainerPicker.setItems(contain);
        ContainerPicker.setValue("Array");
        FigurePicker.setItems(figures);
        FigurePicker.setValue("All");

        CreateEmptyContainer.setOnAction(actionEvent -> {
            if (ContainerPicker.getValue().equals("Array")){
                arrayContainer = new ArrayContainer();
            }else if (ContainerPicker.getValue().equals("List")){
                linkedList = new LinkedList();
            }
        });
        CreateFullContainer.setOnAction(actionEvent -> {
            if (ContainerPicker.getValue().equals("Array")){
                arrayContainer = new ArrayContainer();
            }else if (ContainerPicker.getValue().equals("List")){
                linkedList = new LinkedList();
            }
            for (int i=0; i<20; i++) {
                int r = new Random().nextInt(5);
                switch (r) {
                    case 0:
                        circlePro = new CirclePro();
                        if (ContainerPicker.getValue().equals("Array")) {
                            arrayContainer.add(circlePro);
                        } else {
                            linkedList.addAtStart(circlePro);
                        }
                        circlePro.show(graphicsContext);
                        break;
                    case 1:
                        rectanglePro = new RectanglePro();
                        if (ContainerPicker.getValue().equals("Array")) {
                            arrayContainer.add(rectanglePro);
                        } else {
                            linkedList.addAtStart(rectanglePro);
                        }
                        rectanglePro.show(graphicsContext);
                        break;
                    case 2:
                        linePro = new LinePro();
                        if (ContainerPicker.getValue().equals("Array")) {
                            arrayContainer.add(linePro);
                        } else {
                            linkedList.addAtStart(linePro);
                        }
                        linePro.show(graphicsContext);
                        break;
                    case 3:
                        ellipsePro = new EllipsePro();
                        if (ContainerPicker.getValue().equals("Array")) {
                            arrayContainer.add(ellipsePro);
                        } else {
                            linkedList.addAtStart(ellipsePro);
                        }
                        ellipsePro.show(graphicsContext);
                        break;
                    case 4:
                        squarePro = new SquarePro();
                        if (ContainerPicker.getValue().equals("Array")) {
                            arrayContainer.add(squarePro);
                        } else {
                            linkedList.addAtStart(squarePro);
                        }
                        squarePro.show(graphicsContext);
                        break;
                    default:
                        break;
                }
            }
        });
        RCreate.setOnAction(event -> {
            int r = new Random().nextInt(5);
            switch (r) {
                case 0:
                    circlePro =  new CirclePro();
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.add(circlePro);
                    }else {
                        linkedList.add(circlePro);
                    }
                    circlePro.show(graphicsContext);
                    break;
                case 1:
                    rectanglePro =  new RectanglePro();
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.add(rectanglePro);
                    }else {
                        linkedList.add(rectanglePro);
                    }
                    rectanglePro.show(graphicsContext);
                    break;
                case 2:
                    linePro = new LinePro();
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.add(linePro);
                    }else {
                        linkedList.add(linePro);
                    }
                    linePro.show(graphicsContext);
                    break;
                case 3:
                    ellipsePro = new EllipsePro();
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.add(ellipsePro);
                    }else {
                        linkedList.add(ellipsePro);
                    }
                    ellipsePro.show(graphicsContext);
                    break;
                case 4:
                    squarePro = new SquarePro();
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.add(squarePro);
                    }else {
                        linkedList.add(squarePro);
                    }
                    squarePro.show(graphicsContext);
                    break;
                default:
                    break;
            }
        });

        ShapeBox.setOnAction(actionEvent -> SELECTED_INDEX = ShapeBox.getSelectionModel().getSelectedIndex());

        MoveBtn.setOnAction(actionEvent -> {
            String detector;
            switch (SELECTED_INDEX){
                case 0:
                    detector = "MoveCircle";
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.iterator(detector,graphicsContext);
                    }else {
                        linkedList.iterator(detector,graphicsContext);
                    }
                    break;
                case 1:
                    detector = "MoveRectangle";
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.iterator(detector,graphicsContext);
                    }else {
                        linkedList.iterator(detector,graphicsContext);
                    }
                    break;
                case 2:
                    detector = "MoveLine";
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.iterator(detector,graphicsContext);
                    }else {
                        linkedList.iterator(detector,graphicsContext);
                    }
                    break;
                case 3:
                    detector = "MoveEllipse";
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.iterator(detector,graphicsContext);
                    }else {
                        linkedList.iterator(detector,graphicsContext);
                    }
                    break;
                case 4:
                    detector = "MoveSquare";
                    if (ContainerPicker.getValue().equals("Array")){
                        arrayContainer.iterator(detector,graphicsContext);
                    }else {
                        linkedList.iterator(detector,graphicsContext);
                    }
                    break;
            }
            graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
            if (ContainerPicker.getValue().equals("Array")){
                arrayContainer.iterator("Show",graphicsContext);
            }else {
                linkedList.iterator("Show",graphicsContext);
            }
        });

        DestroyBtn.setOnAction(actionEvent -> {
            String detector = "RemoveAll";
            if (ContainerPicker.getValue().equals("Array")){
                arrayContainer.iterator(detector,graphicsContext);
                arrayContainer = null;
            }else {
                linkedList.iterator(detector,graphicsContext);
                linkedList = null;
            }
            graphicsContext.clearRect(PlaceToDraw.getLayoutX(), PlaceToDraw.getLayoutY(), PlaceToDraw.getWidth(), PlaceToDraw.getHeight());
        });
    }
}