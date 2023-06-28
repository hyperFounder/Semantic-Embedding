import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ToolkitTest {
    private StopWatch mySW = new StopWatch();

    private String doubleToString(double[] _doubleArray) {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < _doubleArray.length; i++) {
            mySB.append(String.format("%.5f", _doubleArray[i])).append(",");
        }
        mySB.delete(mySB.length() - 1, mySB.length());
        return mySB.toString();
    }

    @Test
    void loadGLOVE() throws IOException {
        mySW.start();
        Toolkit.loadGLOVE();
        mySW.stop();
        System.out.println(mySW.getTime());
        assertEquals(true, mySW.getTime() < 600);
        mySW.reset();
        assertEquals(38534, Toolkit.getListVocabulary().size());
        assertEquals(38534, Toolkit.getlistVectors().size());
        assertEquals(50, Toolkit.getlistVectors().get(0).length);
        assertEquals("abacus", Toolkit.getListVocabulary().get(0));
        assertEquals("0.91020,-0.22416,0.37178,0.81798,0.36196,-0.22736,0.18227,-0.65806,-0.68216,0.55412,-0.00682,0.51684,-0.22591,0.62869,-0.31783,-0.04545,-0.29130,-0.31577,-0.09752,0.23169,0.78351,-0.49638,-0.29270,-0.44133,-0.66269,0.50245,-0.35885,-0.12590,-1.00160,-0.74963,-0.23634,-0.52698,0.64290,-0.17031,-0.41484,-0.66797,-0.18608,-0.36538,0.72661,0.27342,0.35811,-0.35126,-0.09303,0.99202,-0.38579,-0.73833,0.42013,1.36120,0.09186,0.34126", doubleToString(Toolkit.getlistVectors().get(0)));
        assertEquals("diskette", Toolkit.getListVocabulary().get(10000));
        assertEquals("-0.49209,-0.76410,1.85160,-0.27413,-0.07538,-0.09049,-0.02073,-1.00880,0.18535,1.03220,-0.52850,-0.54231,0.15589,0.12521,-0.01730,-0.24813,-1.04610,0.60019,1.04710,-0.05143,-0.17494,-0.81117,-0.23783,-0.00254,0.34878,0.04589,0.32036,0.63555,0.75448,-0.73136,0.08431,-1.28650,-0.22761,0.83771,0.66784,0.97248,0.11451,0.20307,-0.06278,-0.53176,0.76212,-0.40505,-1.01780,0.43932,0.03875,-0.31888,1.61950,0.41650,-0.09802,-0.74725", doubleToString(Toolkit.getlistVectors().get(10000)));
        assertEquals("zymogen", Toolkit.getListVocabulary().get(38533));
        assertEquals("-0.34302,-0.76724,0.13492,-0.00597,0.48681,-0.07070,0.51518,0.87200,0.05105,0.85437,0.78227,0.09527,0.76955,0.98725,-0.67563,0.26199,-0.23906,0.03835,0.28952,0.66234,-0.96697,-1.25970,0.59936,0.82306,-0.68298,0.91953,0.01823,0.16589,0.32776,0.92470,-0.97598,-0.64046,0.09786,-0.23237,0.49565,0.33539,0.18704,0.06581,0.19750,-0.21133,0.44679,-0.19354,-1.86070,0.76211,-0.93576,0.35687,0.26919,0.50355,-0.08195,0.37539", doubleToString(Toolkit.getlistVectors().get(38533)));
    }

    @Test
    void loadStopWords() throws IOException {
        mySW.start();
        List<String> myList = Toolkit.loadStopWords();
        mySW.stop();
        assertEquals(true, mySW.getTime() < 3);
        mySW.reset();
        assertEquals(127, myList.size());
        assertEquals("i", myList.get(0));
        assertEquals("any", myList.get(100));
        assertEquals("now", myList.get(126));
    }

}