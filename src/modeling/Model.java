package modeling;

import nets.Perceptron;
import nets.Teacher;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Анатолий on 11.11.2015.
 */
public class Model {

    private Map<String, int[][]> allProjectionMatrix = new HashMap<>();
    private Map<String, BufferedImage> allProjectionImages = new HashMap<>();
    private Map<String, Perceptron> allPerceptons = new HashMap<>();
    private Perceptron perceptron;
    private Teacher teacher;

    public Model() {
        perceptron = new Perceptron(5, 1280 * 720); //initializing perceptron by number of neurons and img dimensions
        allPerceptons.put(MyConstants.TOP_PERCEPTRON, perceptron);
        perceptron = new Perceptron(5, 1280 * 720);
        allPerceptons.put(MyConstants.FRONT_PERCEPTRON, perceptron);
        perceptron = new Perceptron(5, 1280 * 720);
        allPerceptons.put(MyConstants.LEFT_PERCEPTRON, perceptron);
    }

    public Perceptron getPerceptron(String perceptron) {
        return allPerceptons.get(perceptron);
    }

    public int[][] getProjectionMatrix(String projection) {
        return allProjectionMatrix.get(projection);
    }

    public void addProjectionMatrix(String projection, int[][] projectionMatrix) {
        allProjectionMatrix.put(projection, projectionMatrix);
    }

    public void addProjectionImage(String projection, BufferedImage image) {
        allProjectionImages.put(projection, image);
    }

    public BufferedImage getProjectionImage(String projection) {
        return allProjectionImages.get(projection);
    }

    public void teachPerceptrons(String path) {

    }
}
