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

    @Test
    void WordsNearest_Word() {
        mySW.start();
        listWN = mySM.WordsNearest("university");
        mySW.stop();
        System.out.println(mySW.getTime());
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("college,0.87446\nharvard,0.87106\nyale,0.85668\ngraduate,0.85529\ninstitute,0.84836\nprofessor,0.84170\nschool,0.82615\nfaculty,0.82578\nacademy,0.81037\nprinceton,0.81034", GetString(listWN));
        mySW.reset();

        mySW.start();
        listWN = mySM.WordsNearest("student");
        mySW.stop();

        assertEquals(true, mySW.getTime() < 100);
        assertEquals("teacher,0.89621\ngraduate,0.83006\nschool,0.82393\nteaching,0.80788\nfaculty,0.80156\neducation,0.80144\nyouth,0.77885\nacademic,0.77782\ncollege,0.77041\nundergraduate,0.76067", GetString(listWN));
        mySW.reset();

        mySW.start();
        listWN = mySM.WordsNearest("uk");
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("australian,0.73177\nbritish,0.72840\ncanadian,0.71741\nlimited,0.71697\naustralia,0.70297\nlondon,0.69863\ncanada,0.69446\nchart,0.68917\nlabel,0.68107\nzealand,0.67887", GetString(listWN));
        mySW.reset();

        listWN = mySM.WordsNearest("O_O");
        assertEquals("mistake,0.71746\ntiming,0.69099\ndifference,0.68459\nfoul,0.68042\nprobability,0.67415\nfault,0.65943\nresult,0.65640\naccuracy,0.65417\ncalculation,0.64628\nstatistic,0.64075", GetString(listWN));

        listWN = mySM.WordsNearest("above");
        assertEquals("mistake,0.71746\ntiming,0.69099\ndifference,0.68459\nfoul,0.68042\nprobability,0.67415\nfault,0.65943\nresult,0.65640\naccuracy,0.65417\ncalculation,0.64628\nstatistic,0.64075", GetString(listWN));
    }

    @Test
    void WordsNearest_Vector() {
        mySW.start();
        listWN = mySM.WordsNearest(new Vector(new double[]{-0.22427, 0.27427, 0.054742, 1.4692, 0.061821, -0.51894, 0.45027, -0.32164, 0.57876, -0.049142, 0.52523, -0.18784, 0.52539, -0.058431, 0.19741, 0.30754, -0.45412, 0.38268, 0.33441, 0.42801, 0.98406, -0.7637, -0.066755, -1.0027, 1.1942, -2.3916, 0.24326, -0.40705, -0.63413, -0.20832, 3.8851, 0.75046, 0.14857, 0.24485, -1.0143, -0.76356, -0.63824, 0.73037, -1.2025, 0.18932, -1.2139, -0.55377, 1.3033, -0.82461, 0.9965, 0.15117, -0.65753, 0.28569, 0.45374, -0.85646})); //word = china
        mySW.stop();
        System.out.println(mySW.getTime());
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("taiwan,0.93608\nchinese,0.89572\nbeijing,0.89209\nmainland,0.86448\njapan,0.84288\nvietnam,0.82873\nkorea,0.82346\nasian,0.79149\nthailand,0.78890\nasia,0.78832", GetString(listWN));
        mySW.reset();

        mySW.start();
        listWN = mySM.WordsNearest(new Vector(new double[]{1.028, -1.5226, 0.18132, 1.2824, -0.43872, -1.594, -0.13842, -1.2056, -0.19988, 1.1825, 0.39901, -0.23756, 1.085, -0.4708, -0.31306, 0.31879, -0.82113, 0.89139, 0.0065573, 0.64755, -0.31353, 0.27502, -0.4065, 0.95904, 0.76842, -0.15136, 0.4732, -0.18431, -0.39377, -0.63589, 2.3685, -1.5863, -0.88763, -0.22783, 0.90984, 0.42915, -0.14046, -1.0618, -0.21038, 0.40454, -0.098995, 0.46445, 0.0024477, -0.24164, -0.42419, 1.0077, 1.0097, -0.18129, 0.53966, -0.82229})); //word = java
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("semarang,0.71504\nremote,0.68494\napplet,0.67988\nsumatra,0.65579\ndos,0.64838\ninterface,0.63713\nmindanao,0.62318\njakarta,0.61711\nunix,0.61615\nvista,0.61486", GetString(listWN));
        mySW.reset();

        mySW.start();
        listWN = mySM.WordsNearest(new Vector(new double[]{-0.90962, -0.16793, -0.28244, 1.2006, 0.35477, -0.054996, -1.2784, 0.056494, -0.7309, 0.65448, 0.060675, 0.084152, -1.3827, 0.16752, 1.1236, -0.52102, 0.14212, -0.32316, -1.9348, 0.055645, -0.89574, -0.31206, -0.0033612, 0.082128, 0.32966, -1.01, 0.11907, -0.087034, 0.99483, -1.5931, 3.4081, 1.0488, 0.20391, -0.43841, 0.1119, 0.87173, 0.62297, 0.62392, -0.2883, -0.97984, -0.016959, -0.39827, -0.97197, 0.59183, -0.57886, 0.96217, 0.76927, 0.40248, -0.013602, 0.18745})); //word = game
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("play,0.87717\nseason,0.84388\nplayer,0.82933\nscoring,0.80904\nplaying,0.80330\nstarting,0.79644\nmatch,0.78401\nscore,0.78372\nteam,0.78044\nstart,0.76872", GetString(listWN));
        mySW.reset();

        mySW.start();
        listWN = mySM.WordsNearest(new Vector(new double[]{-0.20832, 3.8851, 0.75046, 0.14857, 0.24485, -1.0143, -1.2784, 0.056494, 0.7309, 0.65448, 0.060675, 0.084152, -1.3827, 0.16752, 1.1236, -0.52102, 0.14212, -0.32316, -1.9348, 0.055645, -0.89574, -0.31206, -0.39377, -0.63589, 2.3685, -1.5863, -0.88763, -0.22783, 0.99483, -1.5931, 3.4081, 1.0488, 0.20391, -0.43841, 0.1119, 0.87173, -0.57886, 0.96217, 0.76927, 0.40248, -0.013602, 0.18745, -0.97197, 0.59183, -0.57886, 0.96217, 0.76927, 0.40248, -0.013602, 0.18745})); //word = RANDOM, DOESN'T EXIST IN THE LIST
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("great,0.70434\ngame,0.67548\nfield,0.65782\nluck,0.65459\ncoming,0.65362\nhistory,0.65281\ngood,0.65170\nbest,0.64893\nperfect,0.64535\nmoment,0.64124", GetString(listWN));
        mySW.reset();
    }

    @Test
    void LogicalAnalogies() {
        mySW.start();
        listLA = mySM.LogicalAnalogies("", "", "", 0);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("mother", "father", "O_O", 10);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("mother", "O_O", "son", 10);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("O_O", "father", "son", 10);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("mother", "father", "son", 1);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("daughter,0.96325", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("paris", "london", "britain", 10);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("france,0.93823\nfrench,0.81501\nbelgium,0.79350\nspain,0.77122\ngermany,0.75342\nswitzerland,0.75223\neurope,0.74869\nitaly,0.74238\naustria,0.73956\neuropean,0.73806", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("banana", "apple", "red", 10);
        mySW.stop();
        System.out.println(mySW.getTime());
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("yellow,0.67739\nblack,0.63436\npurple,0.61858\ncoat,0.61234\nblue,0.59562\nrobe,0.59457\nivory,0.59108\nturquoise,0.59057\nflag,0.58690\npink,0.58525", GetString(listLA));
        mySW.reset();

        mySW.start();
        listLA = mySM.LogicalAnalogies("banana", "apple", "red", -1);
        mySW.stop();
        assertEquals(true, mySW.getTime() < 100);
        assertEquals("", GetString(listLA));
        mySW.reset();
    }


}