package code;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * File work class
 * @author Steven Altamirano
 * @version 1.0
 */
public class FileAndArrayWorker {

    /**
     * function for read file
     * @author Steven Altamirano
     * @param file file we want to read
     * @return array of Integer
     */
    public static Integer[] readFile (File file) throws IOException {
        List<Integer> elementsList = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            elementsList.add(Integer.valueOf(scanner.nextLine()));
        }
        fileReader.close();
        return elementsList.toArray(new Integer[0]);
    }

    /**
     * function for write our sorted array to file
     * @author Steven Altamirano
     * @param file file to write
     * @param elements List of our elements we want to write
     */
    private void writeFile (File file, List<Integer> elements) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < elements.size(); i++) {
            if (i != elements.size() - 1) {
                fileWriter.write(elements.get(i).toString() + "\n");
            } else {
                fileWriter.write(elements.get(i).toString());
            }
        }
        fileWriter.close();
    }

    /**
     * Function for create and sort array c that consists of array a and array b
     * @param a array a
     * @param b array b
     * @return created and sorted array c
     */
    public static Integer[] glueArrays (Integer[] a, Integer[] b) {
        Integer[] c = new Integer[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, 0 + a.length, b.length);
        Arrays.sort(c);
        return c;
    }

    public static void main(String[] args) throws IOException {
        FileAndArrayWorker fileAndArrayWorker = new FileAndArrayWorker();
        Integer[] a = fileAndArrayWorker.readFile(new File("resources/A.txt"));
        Integer[] b = fileAndArrayWorker.readFile(new File("resources/B.txt"));
        Integer[] c = fileAndArrayWorker.glueArrays(a, b);
        fileAndArrayWorker.writeFile(new File("resources/C.txt"), Arrays.asList(c));
    }
}