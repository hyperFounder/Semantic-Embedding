import org.apache.commons.lang3.time.StopWatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SemanticMain {
    public List<String> listVocabulary = new ArrayList<>();  //List that contains all the vocabularies loaded from the csv file.
    public List<double[]> listVectors = new ArrayList<>(); //Associated vectors from the csv file.
    public List<Glove> listGlove = new ArrayList<>();
    public final List<String> STOPWORDS;

    public SemanticMain() throws IOException {
        STOPWORDS = Toolkit.loadStopWords();
        Toolkit.loadGLOVE();
    }


    public static void main(String[] args) throws IOException {
        StopWatch mySW = new StopWatch();
        mySW.start();


        SemanticMain mySM = new SemanticMain();
        mySM.listVocabulary = Toolkit.getListVocabulary();
        mySM.listVectors = Toolkit.getlistVectors();
        mySM.listGlove = mySM.CreateGloveList();

        List<CosSimilarityPair> listWN = mySM.WordsNearest("computer");
        Toolkit.PrintSemantic(listWN, 5);

        listWN = mySM.WordsNearest("phd");
        Toolkit.PrintSemantic(listWN, 5);

        listWN = mySM.WordsNearest("banana");
        Toolkit.PrintSemantic(listWN, 5);

        listWN = mySM.WordsNearest("hater");
        Toolkit.PrintSemantic(listWN, 5);


    }

    public List<Glove> CreateGloveList() {
        List<Glove> listResult = new ArrayList<>();
        for (int i = 0; i<listVocabulary.size(); i++){
            String word = listVocabulary.get(i);
            Vector v = new Vector(listVectors.get(i));
            if (!STOPWORDS.contains(word)) {
                Glove glove = new Glove(word, v);
                listResult.add(glove);
            }
        }
        return listResult;
    }

    public List<CosSimilarityPair> WordsNearest(String _word) {
       List<CosSimilarityPair> listCosineSimilarity = new ArrayList<>();

        for (Glove glove : listGlove) {
            String vocabulary = glove.getVocabulary();
            if (!vocabulary.equals(_word)) {
                Vector vector1 = glove.getVector();
                Vector vector2 = getVectorForWord(_word);
                if (vector2 != null) {
                    double csValue = vector1.cosineSimilarity(vector2);
                    CosSimilarityPair csPair = new CosSimilarityPair(_word, vocabulary, csValue);
                    listCosineSimilarity.add(csPair);
                }
            }
        }
        HeapSort.doHeapSort(listCosineSimilarity);
        return (listCosineSimilarity);
    }

    private Vector getVectorForWord(String _word) {
        for (Glove glove : listGlove) {
            if (glove.getVocabulary().equals(_word)) {
                return glove.getVector();
            }
        }
        return null;
    }

}