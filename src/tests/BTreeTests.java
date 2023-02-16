package tests;

import org.junit.Test;
import work.BTree;

import static org.junit.jupiter.api.Assertions.*;

public class BTreeTests {

    @Test
    public void checkEmptyTree() {
        BTree t = new BTree();
        assertEquals("", t.levelOrder());
    }

    @Test
    public void checkOneElementInTree() {
        BTree t = new BTree();
        t.add(3);
        assertEquals("1: 3 \n", t.levelOrder());
    }

    @Test
    public void checkBigTree() {
        BTree t = new BTree();
        int[] arr = {3, 1, 0, 2, 6, 5, 7};
        t.addArray(arr);
        String expected =   "1: 3 \n" +
                            "2: 1 6 \n" +
                            "3: 0 2 5 7 \n";
        assertEquals(expected, t.levelOrder());
    }

    @Test
    public void checkDeletingElementInTree() {
        BTree t = new BTree();
        int[] arr = {3, 2, 4};
        t.addArray(arr);
        assertEquals("1: 3 \n2: 2 4 \n", t.levelOrder());
        t.delete(4);
        assertEquals("1: 3 \n2: 2 \n", t.levelOrder());
    }

    @Test
    public void checkSearchingElement() {
        BTree t = new BTree();
        int[] arr = {3, 1, 0, 2, 6, 5, 7};
        t.addArray(arr);
        String expected =   "1: 3 \n" +
                            "2: 1 6 \n" +
                            "3: 0 2 5 7 \n";
        assertEquals(expected, t.levelOrder());
        String expectedSearchResult = "3 -> 6 -> 5";
        assertEquals(expectedSearchResult, t.find(5));
    }

    @Test
    public void checkSearchingNotExistingElement() {
        BTree t = new BTree();
        int[] arr = {3, 1, 0, 2, 6, 5, 7};
        t.addArray(arr);
        String expected =   "1: 3 \n" +
                            "2: 1 6 \n" +
                            "3: 0 2 5 7 \n";
        assertEquals(expected, t.levelOrder());
        String expectedSearchResult = "This element doesn't exist.";
        assertEquals(expectedSearchResult, t.find(8));
    }
}
