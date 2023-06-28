import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CosSimilarityPairTest {
    String strWord1 = "Hello";
    String strWord2 = "World";
    Vector vecVector = new Vector(new double[]{1,2,3});
    double doubCS = 0.5;

    @Test
    void getWord1() {
        CosSimilarityPair myCSP = new CosSimilarityPair(strWord1, strWord2, doubCS);
        assertEquals("Hello",myCSP.getWord1());
    }

    @Test
    void setWord1() {
        CosSimilarityPair myCSP = new CosSimilarityPair(strWord1, strWord2, doubCS);
        myCSP.setWord1("ModifiedHello");
        assertEquals("ModifiedHello",myCSP.getWord1());
    }

    @Test
    void getWord2() {
        CosSimilarityPair myCSP = new CosSimilarityPair(strWord1, strWord2, doubCS);
        assertEquals("World",myCSP.getWord2());
    }

    @Test
    void setWord2() {
        CosSimilarityPair myCSP = new CosSimilarityPair(strWord1, strWord2, doubCS);
        myCSP.setWord2("ModifiedWorld");
        assertEquals("ModifiedWorld",myCSP.getWord2());
    }

    @Test
    void getVector() {
        CosSimilarityPair myCSP = new CosSimilarityPair(vecVector, strWord2, doubCS);
        assertEquals("1.00000,2.00000,3.00000",myCSP.getVector().toString());
    }

    @Test
    void setVector() {
        CosSimilarityPair myCSP = new CosSimilarityPair(vecVector, strWord2, doubCS);
        myCSP.setVector(new Vector(new double[]{4,5,6}));
        assertEquals("4.00000,5.00000,6.00000",myCSP.getVector().toString());
    }

    @Test
    void getCosineSimilarity() {
        CosSimilarityPair myCSP = new CosSimilarityPair(vecVector, strWord2, doubCS);
        CosSimilarityPair myCSP1 = new CosSimilarityPair(strWord1, strWord2, doubCS);
        assertEquals(myCSP1.getCosineSimilarity(),myCSP.getCosineSimilarity());
        assertEquals(0.5,myCSP.getCosineSimilarity());
        assertEquals(0.5,myCSP1.getCosineSimilarity());
    }

    @Test
    void setCosineSimilarity() {
        CosSimilarityPair myCSP = new CosSimilarityPair(vecVector, strWord2, doubCS);
        CosSimilarityPair myCSP1 = new CosSimilarityPair(strWord1, strWord2, doubCS);
        myCSP.setCosineSimilarity(0.1);
        myCSP1.setCosineSimilarity(0.2);
        assertEquals(0.1,myCSP.getCosineSimilarity());
        assertEquals(0.2,myCSP1.getCosineSimilarity());
    }
}