public class CosSimilarityPair {
    private String strWord1;
    private String strWord2;
    private double doubCS;
    private Vector vecVector;

    public CosSimilarityPair(String _word1, String _word2, double _cosinesimilarity) {
        this.strWord1 = _word1;
        this.strWord2 = _word2;
        this.doubCS = _cosinesimilarity;
    }

    public CosSimilarityPair(Vector _vector, String _word2, double _cosinesimilarity) {
        this.vecVector = _vector;
        this.strWord2 = _word2;
        this.doubCS = _cosinesimilarity;
    }

    public String getWord1() {
        return strWord1;
    }

    public String getWord2() {
        return strWord2;
    }

    public double getCosineSimilarity() {
        return doubCS;
    }

    public void setCosineSimilarity(double _cs) {
        this.doubCS = _cs;
    }

    public void setWord1(String _word) {
        this.strWord1 = _word;
    }

    public void setWord2(String _word) {
        this.strWord2 = _word;
    }

    public Vector getVector() {
        return vecVector;
    }

    public void setVector(Vector _vector) {
        this.vecVector = _vector;
    }

}
