package modeling;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Анатолий on 11.11.2015.
 */
public class Model {

    private Map<String,int[][]> allProjectionMatrix = new HashMap<String, int[][]>();

    public Map<String, int[][]> getAllProjectionMatrix() {
        return allProjectionMatrix;
    }

    public void setAllProjectionMatrix(Map<String, int[][]> allProjectionMatrix) {
        this.allProjectionMatrix = allProjectionMatrix;
    }

    public int[][] getProjectionMatrixByKey(String projection){
        return allProjectionMatrix.get(projection);
    }

    public void addProjectionMatrix(String projection, int[][] projectionMatrix){
        allProjectionMatrix.put(projection, projectionMatrix);
    }
}
