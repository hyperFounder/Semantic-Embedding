import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HeapSortTest {
    @Test
    void doHeapSort_Array() {
        int[] intArray = new int[]{4,6,1,9,5,2};
        assertEquals("[9, 6, 5, 4, 2, 1]", Arrays.toString(HeapSort.doHeapSort(intArray)));
    }

    @Test
    void doHeapSort_List() {
        List<CosSimilarityPair> myList = new ArrayList<>();
        CosSimilarityPair myCSP1 = new CosSimilarityPair("Word1", "Word2", 0.4);
        CosSimilarityPair myCSP2 = new CosSimilarityPair("Word3", "Word4", 0.6);
        CosSimilarityPair myCSP3 = new CosSimilarityPair("Word5", "Word6", -0.1);
        CosSimilarityPair myCSP4 = new CosSimilarityPair("Word7", "Word8", 0.9);
        CosSimilarityPair myCSP5 = new CosSimilarityPair("Word9", "Word10", 0.5);
        CosSimilarityPair myCSP6 = new CosSimilarityPair("Word11", "Word22", 0.2);
        myList.add(myCSP1);
        myList.add(myCSP2);
        myList.add(myCSP3);
        myList.add(myCSP4);
        myList.add(myCSP5);
        myList.add(myCSP6);

        List<CosSimilarityPair> myList_Sorted = HeapSort.doHeapSort(myList);
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < myList_Sorted.size();i++){
            mySB.append(myList_Sorted.get(i).getCosineSimilarity()).append(",");
        }
        mySB.delete(mySB.length() - 1, mySB.length());
        assertEquals("0.9,0.6,0.5,0.4,0.2,-0.1", mySB.toString());
        assertEquals("Word7", myList_Sorted.get(0).getWord1());
        assertEquals("Word8", myList_Sorted.get(0).getWord2());
        assertEquals(0.9, myList_Sorted.get(0).getCosineSimilarity());
        assertEquals("Word1", myList_Sorted.get(3).getWord1());
        assertEquals("Word2", myList_Sorted.get(3).getWord2());
        assertEquals(0.4, myList_Sorted.get(3).getCosineSimilarity());
        assertEquals("Word5", myList_Sorted.get(5).getWord1());
        assertEquals("Word6", myList_Sorted.get(5).getWord2());
        assertEquals(-0.1, myList_Sorted.get(5).getCosineSimilarity());
    }
}