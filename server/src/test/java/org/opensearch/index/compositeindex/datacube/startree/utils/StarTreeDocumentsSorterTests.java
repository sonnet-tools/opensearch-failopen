    public void testSortDocumentsOffHeap_SingleElement() {  
        comparatorList.add(new UnsignedLongDimension("dim4").comparator());
 * this file be licensed under the Apache-2.0 license or a
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)
        for (int i = 0; i < numDocs; i++) {  
            Long[] dimensions = new Long[numDimensions];
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);  
        }
        int numDocs = 10;  
        int numDocs = 10;  
            for (int j = 0; j < numDimensions; j++) {
            }
        // Generate random test data
    }
                if (comparison < 0) {
        testData.put(0, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], null, 150L, 100L, 300L, null });
                "Sorting error when sorting from dimension index "  
            new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], null, -100L, 9223372036854775807L, 200L, -300L }
    }
        assertArrayEquals(new int[] {}, sortedDocIds);  
    public void testSortDocumentsOffHeap_StartFromFirstDimension() {  
        Map<Integer, Long[]> testData = new HashMap<>();
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int i = 0;  
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
            assertTrue(
 */  
        testData.put(5, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, 150L, -5L, 200L, 295L });  
import java.util.concurrent.atomic.AtomicInteger;
        comparatorList.add(new NumericDimension("dim5").comparator());
            boolean isCorrectOrder = true;
    public void testTheRandomSort() {
        testData.put(  
        Map<Integer, Long[]> testData = new HashMap<>();
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int dimensionId = 1;
}
            for (int j = dimensionId + 1; j < numDimensions; j++) {
        comparatorList.addAll(Collections.nCopies(4, dateDimension.comparator()));  
 * The OpenSearch Contributors require contributions made to  
            8,
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC
        int dimensionId = 4;
    }
    }
            testRandomizedSort();
        for (int i = 0; i < numDimensions; i++) {  
                    dimensions[j] = random.nextLong();  
            testData.add(dimensions);  
    public void testSortDocumentsOffHeap_Negatives() {
        int dimensionId = 0;
        int dimensionId = -1;
        int numDocs = 10;  
        }
    }
        testData.put(2, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, -100L, -15L, 250L, null });  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
/**
 * compatible open source license.
    private Map<Integer, Long[]> testData;  
        assertArrayEquals(new int[] { 1, 2, 7, 3, 9, 5, 0, 8, 6, 4 }, sortedDocIds);  
        );
        Long[] date_dims = new Long[4];
    }
        super.setUp();
 *
        comparatorList.add(new NumericDimension("dim1").comparator());
import org.opensearch.test.OpenSearchTestCase;  
        AtomicInteger dimIndex = new AtomicInteger(0);  
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);  
        int dimensionId = -1;
            new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, -100L, -10L, 210L, -9223372036854775807L }  
        int dimensionId = -1;
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
import org.opensearch.index.compositeindex.datacube.DateDimension;  
        // for example to start from dimension in 0th index, we need to pass -1 to sort method
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);  
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);  
                if (random.nextFloat() < 0.5) {  
            );
        comparatorList = new ArrayList<>();
        testData.put(0, new Long[] { null, null, null, null, null, null, null, null, null });
        testData.put(9, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, null, -10L, 210L, 325L });
    }  
import java.util.HashMap;
                    break;
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int numDimensions = random.nextBoolean() ? randomIntBetween(2, 10) : randomIntBetween(2, 100);  
    }  
        Random random = Randomness.get();
                int comparison = comparatorList.get(j).compare(prev[j], curr[j]);  
    public void testSortDocumentsOffHeap_StartFromSixthDimension() {  
    public void testSortDocumentsOffHeap_StartFromFifthDimension() {  
        assertArrayEquals(new int[] { 3, 4, 2, 1, 0 }, sortedDocIds);
        }
                    + " Prev : "
                    break;
                    + Arrays.toString(curr),
    }
        int dimensionId = 3;
 * Tests for {@link StarTreeDocumentsSorter}.
 */  
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private void testRandomizedSort() {
        testData.put(0, new Long[] { -1L, -2L, -3L, -4L, -10L, 0L, null, 0L, -5L });  
        List<Long[]> testData = new ArrayList<>();
        }  
            Long[] curr = testData.get(sortedDocIds[i]);  
    public void setUp() throws Exception {
        );  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // 10 documents with 6 dimensions each  
        int numDocs = 10;  
            if (!isUnsignedLong) comparatorList.add(new NumericDimension("fieldName").comparator());
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
import org.opensearch.common.Randomness;
        int numDocs = 10;  
 * SPDX-License-Identifier: Apache-2.0
        testData.put(6, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 3L, 105L, null, -200L, -315L });
import org.junit.Before;
                    + dimensionId
import java.util.Collections;
        // skew more towards realistic number of dimensions
        int dimensionId = -1;
        testData = new HashMap<>();  
            i++;  
        for (int i = 0; i < numDocs; i++) {
        for (int i = 1; i < numDocs; i++) {
        testData.put(
import java.util.ArrayList;  
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int numDocs = 5;
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        assertArrayEquals(new int[] { 0 }, sortedDocIds);  
        int dimensionId = random.nextInt(numDimensions) - 1;  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
    @Before  
                }  
    private List<Comparator<Long>> comparatorList;
        int numDocs = randomIntBetween(0, 1000);  
    }
import java.util.Comparator;  
import java.util.List;
public class StarTreeDocumentsSorterTests extends OpenSearchTestCase {
                    isCorrectOrder = false;
        int dimensionId = -1;
        assertArrayEquals(new int[] { 0, 1, 2 }, sortedDocIds);
import java.util.Random;
        while (i < 10) {
        testData.put(2, new Long[] { null, null, null, null, null, null, null, null, null });
        testData.put(4, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, 120L, null, null, 305L });
    public void testSortDocumentsOffHeap_EmptyArray() {  
        // sort dimensionId + 1 to numDimensions
        int numDocs = 10;  
        int numDocs = 1;  
        int numDocs = 3;
    }
                isCorrectOrder  
        int dimensionId = 2;
    public void testSortDocumentsOffHeap_AllNulls() {  
import org.opensearch.common.Rounding;
        int[] sortedDocIds = new int[numDocs];  
        // Sort using StarTreeDocumentsSorter  
    public void testSortDocumentsOffHeap_StartFromThirdDimension() {  
        comparatorList.add(new UnsignedLongDimension("dim2").comparator());
    }
    public void testSortDocumentsOffHeap_StartFromSecondDimension() {  
        comparatorList.add(new NumericDimension("dim3").comparator());  
        testData.put(1, new Long[] { null, null, null, null, null, null, null, null, null });  
        testData.put(3, new Long[] { -9L, -2L, -3L, -4L, -7L, 0L, null, 0L, -20L });  
        testData.put(2, new Long[] { -5L, -3L, -3L, -4L, -9L, 0L, null, 0L, 15L });
        int[] sortedDocIds = {};
                    + Arrays.toString(prev)  
        }
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
    }
            3,
        int[] sortedDocIds = { 0, 1, 2, 3, 4 };  
            Boolean isUnsignedLong = random.nextBoolean();
            else comparatorList.add(new UnsignedLongDimension("fieldName").comparator());  
            sortedDocIds[i] = i;
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);  
        int numDocs = 0;  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
import java.util.Map;  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        List<DateTimeUnitRounding> intervals = Arrays.asList(  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
import java.util.Arrays;
        assertArrayEquals(new int[] { 6, 7, 4, 5, 0, 2, 3, 8, 1, 9 }, sortedDocIds);  
                } else if (comparison > 0) {  
        int dimensionId = 5;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),  
        // Verify the sorting  
        );
/*  
                } else {
package org.opensearch.index.compositeindex.datacube.startree.utils;
        int[] sortedDocIds = { 0 };
        testData.put(4, new Long[] { -8L, -2L, -3L, -4L, -15L, 0L, null, 0L, -25L });
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    }
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
import org.opensearch.index.mapper.DateFieldMapper;
        testData.put(7, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, 120L, -10L, 205L, 310L });
        dateDimension.setDimensionValues(testValue, value -> { date_dims[dimIndex.getAndIncrement()] = value; });
        int[] sortedDocIds = { 0, 1, 2 };  
        List<Comparator<Long>> comparatorList = new ArrayList<>();
    public void testSortDocumentsOffHeap_StartFromSeventhDimension() {  
        testData.put(1, new Long[] { -5L, -2L, -3L, -4L, -9L, 0L, null, 0L, -10L });
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
                }
        int numDocs = 10;  
            Long[] prev = testData.get(sortedDocIds[i - 1]);
                    dimensions[j] = random.nextBoolean() ? Long.valueOf(0L) : random.nextBoolean() ? -1L : null;
        // The order should remain unchanged as all elements are equal (null)  
                    + " :: Curr : "
        testData.put(1, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, null, -9223372036854775807L, 200L, 300L });
            }
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
    public void testSortDocumentsOffHeap_StartFromFourthDimension() {  
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);  
