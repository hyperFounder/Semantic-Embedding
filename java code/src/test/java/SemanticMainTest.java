import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SemanticMainTest {
    private SemanticMain mySM = null;
    private StopWatch mySW = new StopWatch();
    List<CosSimilarityPair> listWN;
    List<CosSimilarityPair> listLA;

    private String GetString(List<CosSimilarityPair> _list) {
        StringBuilder mySB = new StringBuilder();
        if (_list.size() > 0) {
            for (int i = 0; i < (_list.size() > 10 ? 10 : _list.size()); i++) {
                mySB.append(_list.get(i).getWord2()).append(",").append(String.format("%.5f", _list.get(i).getCosineSimilarity())).append("\n");
            }
            mySB.delete(mySB.length() - 1, mySB.length());
        }
        return mySB.toString();
    }

    @BeforeEach
    void SetUp() throws IOException {
        mySM = new SemanticMain();
        Toolkit.loadGLOVE();
        mySM.listVocabulary = Toolkit.getListVocabulary();
        mySM.listVectors = Toolkit.getlistVectors();
        mySM.listGlove = mySM.CreateGloveList();
        mySW.reset();
    }

    @Test
    void CreateGloveList() {
        assertEquals(38515, mySM.listGlove.size());
    }
}