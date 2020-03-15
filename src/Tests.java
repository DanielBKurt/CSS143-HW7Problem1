import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Tests {
    Dictionary dictionary;
    public void testAll()
    {
        testContains();
        testRemove();
    }
    public void testContains()
    {
        dictionary = new Dictionary(1);
        for (int i = -1; i < 2; i++)
            assertTrue(!dictionary.contains(i));

        dictionary.add(0,103);
        assertTrue(!dictionary.contains(2));
        assertTrue(dictionary.contains(0));

        dictionary = new Dictionary(2);
        dictionary.add(0,103);
        dictionary.add(1,105);
        assertTrue(dictionary.contains(0));
        assertTrue(dictionary.contains(1));
        assertTrue(!dictionary.contains(2));
        assertTrue(!dictionary.contains(3));

        dictionary = new Dictionary(3);
        dictionary.add(0,103);
        dictionary.add(1,105);
        assertTrue(!dictionary.contains(3));
        dictionary.add(2,206);
        assertTrue(dictionary.contains(1));

        dictionary.add(4,407);
        assertTrue(dictionary.contains(1));
        assertTrue(dictionary.contains(4));
        assertTrue(!dictionary.contains(7));
        assertTrue(!dictionary.contains(8));
    }
    public void testRemove()
    {
        dictionary = new Dictionary(5);
        assertTrue(!dictionary.remove(3)); //remove from empty dictionary

        dictionary.add(3,6);
        dictionary.add(4,7);
        dictionary.add(5,8);
        assertTrue(dictionary.remove(3)); //remove existing key

        assertTrue(!dictionary.remove(7)); //remove non-existing key

        dictionary.add(0,9);
        assertTrue(dictionary.remove(5)); //remove collision key

        dictionary.add(5,10);
        assertTrue(dictionary.remove(4)); //remove non-collision key from dictionary with collision

        assertTrue(!dictionary.remove(4)); //remove non-existing key from dictionary with collision
    }
}
