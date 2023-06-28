import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class VectorTest {
    private Vector myVector1 = new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
    private Vector myVector2 = new Vector(new double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6});
    private Vector myVector3 = new Vector(new double[]{6.0, 7.0, 8.0});
    private Vector myVector4 = new Vector(new double[]{1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 0.0});

    @Test
    void getElementatIndex() {
        assertEquals(1.0, myVector1.getElementatIndex(0));
        assertEquals(0.4, myVector2.getElementatIndex(3));
        assertEquals(8.0, myVector3.getElementatIndex(2));
        assertEquals(-1, myVector3.getElementatIndex(3));
    }

    @Test
    void setElementatIndex() {
        Vector myVector = new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
        myVector.setElementatIndex(7.0, 0);
        assertEquals(7.0, myVector.getElementatIndex(0));
        myVector.setElementatIndex(7.0, 6);
        assertEquals(7.0, myVector.getElementatIndex(5));
    }

    @Test
    void getAllElements() {
        assertEquals(6.0, myVector3.getAllElements()[0]);
        assertEquals(7.0, myVector3.getAllElements()[1]);
        assertEquals(8.0, myVector3.getAllElements()[2]);
    }

    @Test
    void getVectorSize() {
        assertEquals(6.0, myVector1.getVectorSize());
        assertEquals(6.0, myVector2.getVectorSize());
        assertEquals(3.0, myVector3.getVectorSize());
    }

    @Test
    void reSize() {
        assertEquals(new Vector(new double[]{1.0, 2.0}), myVector1.reSize(2));
        assertEquals(new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, -1.0, -1.0, -1.0, -1.0}), myVector1.reSize(10));
        assertEquals(new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}), myVector1.reSize(6));
        assertEquals(new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}), myVector1.reSize(0));
        assertEquals(new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}), myVector1.reSize(-1));
    }

    @Test
    void add_SameSize() {
        assertEquals("1.10000,2.20000,3.30000,4.40000,5.50000,6.60000", myVector1.add(myVector2).toString());
    }

    @Test
    void add_DifferentSize() {
        assertEquals("7.00000,9.00000,11.00000,3.00000,4.00000,5.00000", myVector1.add(myVector3).toString());
        assertEquals("1.20000,2.40000,3.60000,4.80000,6.00000,7.20000,6.70000,7.80000,8.90000,-1.00000", myVector2.add(myVector4).toString());
    }

    @Test
    void subtraction_SameSize() {
        assertEquals("0.90000,1.80000,2.70000,3.60000,4.50000,5.40000", myVector1.subtraction(myVector2).toString());
    }

    @Test
    void subtraction_DifferentSize() {
        assertEquals("-5.00000,-5.00000,-5.00000,5.00000,6.00000,7.00000", myVector1.subtraction(myVector3).toString());
        assertEquals("-1.00000,-2.00000,-3.00000,-4.00000,-5.00000,-6.00000,-8.70000,-9.80000,-10.90000,-1.00000", myVector2.subtraction(myVector4).toString());
    }

    @Test
    void dotProduct_SameSize() {
        assertEquals("9.10000", String.format("%.5f",myVector1.dotProduct(myVector2)));
    }

    @Test
    void dotProduct_DifferentSize() {
        assertEquals("29.00000", String.format("%.5f",myVector1.dotProduct(myVector3)));
        assertEquals("-16.39000", String.format("%.5f",myVector2.dotProduct(myVector4)));
    }

    @Test
    void cosineSimilarity_SameSize() {
        assertEquals("1.00000", String.format("%.5f",myVector1.cosineSimilarity(myVector2)));
    }

    @Test
    void cosineSimilarity_DifferentSize() {
        assertEquals("0.24658", String.format("%.5f",myVector1.cosineSimilarity(myVector3)));
        assertEquals("-0.39831", String.format("%.5f",myVector2.cosineSimilarity(myVector4)));
    }
}