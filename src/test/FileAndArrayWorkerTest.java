package test;

import code.FileAndArrayWorker;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileAndArrayWorkerTest {

    @Test
    public void readFile() throws IOException {
        Integer[] actual = new Integer[]{1, 2, 11, 14, 15, 16, 19};
        Integer[] expected = FileAndArrayWorker.readFile(new File("resources/A.txt"));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void glueArrays() {
        Integer[] actual = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] expected = FileAndArrayWorker.glueArrays(new Integer[]{1, 4, 5} ,new Integer[]{2, 3, 6});
        Assert.assertArrayEquals(expected, actual);
    }
}