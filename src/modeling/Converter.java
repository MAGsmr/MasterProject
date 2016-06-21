package modeling;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.util.*;

/**
 * Created by Anatoliy on 01.11.2015.
 */
public class Converter {

    public static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {
        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    public static List<int[][]> getPerceptronsWeightsFromFile(String filePath, int numberOfPerceptrons, int[] numberOfNeurons) {
        List<int[][]> allWeights = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int[][] weights = new int[numberOfNeurons.length][];
            for (int i = 0; i < numberOfNeurons.length; i++) {
                weights[i] = new int[numberOfNeurons[i]];
            }
            for (int i = 0; i < numberOfPerceptrons; i++) {
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(" ");
                    for (int k = 0; k < weights[j].length; k++) {
                        weights[j][k] = Integer.parseInt(temp[k]);
                    }
                }
                allWeights.add(i, weights);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWeights;
    }

    public static void writePerceptronsWeightsToFile(String filePath, List<int[][]> allweights){
        try {
            File file = new File(filePath);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < allweights.size(); i++){
                int[][] weights = allweights.get(i);
                for (int j = 0; j < weights.length; j++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int k = 0; k < weights[j].length; k++){
                        stringBuilder.append(weights[j][k] + " ");
                    }
                    stringBuilder.setCharAt(stringBuilder.length(), '\n');
                    bw.write(stringBuilder.toString());
                    bw.flush();
                }
            }

            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
