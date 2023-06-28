public class Glove {
    private String strVocabulary;
    private Vector vecVector;

    public Glove(String _vocabulary, Vector _vector) {
        this.strVocabulary = _vocabulary;
        this.vecVector = _vector;
    }

    public String getVocabulary() {
        return strVocabulary;
    }

    public Vector getVector() {
        return vecVector;
    }

    public void setVocabulary(String _vocabulary) {
        this.strVocabulary = _vocabulary;
    }

    public void setVector(Vector _vector) {
        this.vecVector = _vector;
    }
}
