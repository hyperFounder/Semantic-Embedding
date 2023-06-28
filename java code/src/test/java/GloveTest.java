import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GloveTest {
    String strWord1 = "HelloWorld";
    Vector vecVector = new Vector(new double[]{1,2,3});
    Glove myGlove = new Glove(strWord1, vecVector);

    @Test
    void getVocabulary() {
        assertEquals("HelloWorld",myGlove.getVocabulary());
    }

    @Test
    void setVocabulary() {
        myGlove.setVocabulary("ModifiedText");
        assertEquals("ModifiedText",myGlove.getVocabulary());
    }

   @Test
    void getVector() {
        assertEquals("1.00000,2.00000,3.00000",myGlove.getVector().toString());
    }

    @Test
    void setVector() {
        myGlove.setVector(new Vector(new double[]{4,5,6}));
        assertEquals("4.00000,5.00000,6.00000",myGlove.getVector().toString());
    }
}