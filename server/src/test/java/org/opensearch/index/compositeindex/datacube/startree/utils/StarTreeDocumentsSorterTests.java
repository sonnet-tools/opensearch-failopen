        testData = new HashMap<>();
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    }
        // Generate random test data
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);
    private void testRandomizedSort() {
        comparatorList.addAll(Collections.nCopies(4, dateDimension.comparator()));
            new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, -100L, -10L, 210L, -9223372036854775807L }
        // Sort using StarTreeDocumentsSorter
    }
        testData.put(0, new Long[] { -1L, -2L, -3L, -4L, -10L, 0L, null, 0L, -5L });
}
                if (random.nextFloat() < 0.5) {
        testData.put(1, new Long[] { -5L, -2L, -3L, -4L, -9L, 0L, null, 0L, -10L });
        int dimensionId = 4;
 * compatible open source license.
        comparatorList.add(new UnsignedLongDimension("dim2").comparator());
        int dimensionId = -1;
    public void testSortDocumentsOffHeap_StartFromSixthDimension() {
        int numDocs = 10;
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        );
 * The OpenSearch Contributors require contributions made to
        testData.put(1, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, null, -9223372036854775807L, 200L, 300L });
        int numDocs = 10;
    }
        testData.put(
 */
            Long[] dimensions = new Long[numDimensions];
        // 10 documents with 6 dimensions each
        List<DateTimeUnitRounding> intervals = Arrays.asList(
        testData.put(9, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, null, -10L, 210L, 325L });
            new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], null, -100L, 9223372036854775807L, 200L, -300L }
                    + Arrays.toString(curr),
                }
            for (int j = dimensionId + 1; j < numDimensions; j++) {
    public void testSortDocumentsOffHeap_EmptyArray() {
import org.opensearch.index.mapper.DateFieldMapper;
import java.util.Random;
        int i = 0;
        Map<Integer, Long[]> testData = new HashMap<>();
            8,
package org.opensearch.index.compositeindex.datacube.startree.utils;
    public void testSortDocumentsOffHeap_StartFromSeventhDimension() {
                    + Arrays.toString(prev)
                    + " Prev : "
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        testData.put(
        super.setUp();
            for (int j = 0; j < numDimensions; j++) {
        testData.put(2, new Long[] { -5L, -3L, -3L, -4L, -9L, 0L, null, 0L, 15L });
        testData.put(6, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 3L, 105L, null, -200L, -315L });
        testData.put(2, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, -100L, -15L, 250L, null });
    @Before
        int dimensionId = -1;
                    dimensions[j] = random.nextLong();
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);
        comparatorList.add(new UnsignedLongDimension("dim4").comparator());
    public void testSortDocumentsOffHeap_AllNulls() {
        int dimensionId = 0;
        testData.put(0, new Long[] { null, null, null, null, null, null, null, null, null });
        // Verify the sorting
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.common.Rounding;
        assertArrayEquals(new int[] { 1, 2, 7, 3, 9, 5, 0, 8, 6, 4 }, sortedDocIds);
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        testData.put(4, new Long[] { -8L, -2L, -3L, -4L, -15L, 0L, null, 0L, -25L });
    }
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        int numDocs = randomIntBetween(0, 1000);
                }
 */
                } else {
                } else if (comparison > 0) {
                int comparison = comparatorList.get(j).compare(prev[j], curr[j]);
    }
    public void testSortDocumentsOffHeap_Negatives() {
 * this file be licensed under the Apache-2.0 license or a
                "Sorting error when sorting from dimension index "
                    dimensions[j] = random.nextBoolean() ? Long.valueOf(0L) : random.nextBoolean() ? -1L : null;
    public void testSortDocumentsOffHeap_StartFromThirdDimension() {
public class StarTreeDocumentsSorterTests extends OpenSearchTestCase {
    public void testSortDocumentsOffHeap_StartFromSecondDimension() {
/*
        );
        dateDimension.setDimensionValues(testValue, value -> { date_dims[dimIndex.getAndIncrement()] = value; });
        Random random = Randomness.get();
    }
            }
        // sort dimensionId + 1 to numDimensions
            testData.add(dimensions);
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
        comparatorList.add(new NumericDimension("dim1").comparator());
        testData.put(0, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], null, 150L, 100L, 300L, null });
        comparatorList.add(new NumericDimension("dim3").comparator());
        int numDimensions = random.nextBoolean() ? randomIntBetween(2, 10) : randomIntBetween(2, 100);
        int numDocs = 10;
        }
    public void testSortDocumentsOffHeap_StartFromFourthDimension() {
        int[] sortedDocIds = {};
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);
        );
        assertArrayEquals(new int[] {}, sortedDocIds);
    }
        int numDocs = 10;
        int numDocs = 10;
import java.util.HashMap;
        int numDocs = 0;
 *
        int dimensionId = -1;
                isCorrectOrder
    }
import java.util.concurrent.atomic.AtomicInteger;
        int numDocs = 10;
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);
            Long[] curr = testData.get(sortedDocIds[i]);
        comparatorList = new ArrayList<>();
    }
        for (int i = 1; i < numDocs; i++) {
        int numDocs = 10;
        while (i < 10) {
    private List<Comparator<Long>> comparatorList;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
        assertArrayEquals(new int[] { 0 }, sortedDocIds);
        testData.put(5, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 2L, 150L, -5L, 200L, 295L });
                    isCorrectOrder = false;
        }
        testData.put(7, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, 120L, -10L, 205L, 310L });
        int dimensionId = 5;
                    + " :: Curr : "
                    break;
import org.opensearch.index.compositeindex.datacube.DateDimension;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            }
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
            boolean isCorrectOrder = true;
        }
import java.util.List;
import java.util.Collections;
                    break;
        int dimensionId = -1;
        assertArrayEquals(new int[] { 0, 1, 2 }, sortedDocIds);
        int[] sortedDocIds = { 0, 1, 2 };
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC
        assertArrayEquals(new int[] { 3, 4, 2, 1, 0 }, sortedDocIds);
        Map<Integer, Long[]> testData = new HashMap<>();
    public void testTheRandomSort() {
        for (int i = 0; i < numDimensions; i++) {
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            if (!isUnsignedLong) comparatorList.add(new NumericDimension("fieldName").comparator());
        comparatorList.add(new NumericDimension("dim5").comparator());
            3,
            Boolean isUnsignedLong = random.nextBoolean();
import java.util.Arrays;
import org.opensearch.test.OpenSearchTestCase;
        // skew more towards realistic number of dimensions
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                    + dimensionId
        int dimensionId = 2;
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
    }
/**
        Long[] date_dims = new Long[4];
            else comparatorList.add(new UnsignedLongDimension("fieldName").comparator());
            testRandomizedSort();
        }
                if (comparison < 0) {
    }
import org.opensearch.common.Randomness;
import java.util.ArrayList;
    }
        int[] sortedDocIds = { 0 };
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        testData.put(3, new Long[] { -9L, -2L, -3L, -4L, -7L, 0L, null, 0L, -20L });
        List<Long[]> testData = new ArrayList<>();
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
        // for example to start from dimension in 0th index, we need to pass -1 to sort method
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int numDocs = 3;
            Long[] prev = testData.get(sortedDocIds[i - 1]);
            sortedDocIds[i] = i;
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
    public void testSortDocumentsOffHeap_StartFromFirstDimension() {
        assertArrayEquals(new int[] { 7, 4, 1, 5, 2, 3, 9, 6, 0, 8 }, sortedDocIds);
        AtomicInteger dimIndex = new AtomicInteger(0);
        for (int i = 0; i < numDocs; i++) {
        int dimensionId = random.nextInt(numDimensions) - 1;
        int[] sortedDocIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int dimensionId = 1;
 * Tests for {@link StarTreeDocumentsSorter}.
    }
import java.util.Map;
    private Map<Integer, Long[]> testData;
        int dimensionId = 3;
import org.junit.Before;
        int numDocs = 1;
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        assertArrayEquals(new int[] { 6, 7, 4, 5, 0, 2, 3, 8, 1, 9 }, sortedDocIds);
import java.util.Comparator;
        testData.put(4, new Long[] { date_dims[0], date_dims[1], date_dims[2], date_dims[3], 1L, 120L, null, null, 305L });
        int numDocs = 5;
        int dimensionId = -1;
            );
        int[] sortedDocIds = { 0, 1, 2, 3, 4 };
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
        testData.put(2, new Long[] { null, null, null, null, null, null, null, null, null });
    public void setUp() throws Exception {
        // The order should remain unchanged as all elements are equal (null)
        }
        int[] sortedDocIds = new int[numDocs];
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, i -> testData.get(sortedDocIds[i]), comparatorList);
    }
    public void testSortDocumentsOffHeap_SingleElement() {
    public void testSortDocumentsOffHeap_StartFromFifthDimension() {
            i++;
        List<Comparator<Long>> comparatorList = new ArrayList<>();
            assertTrue(
        testData.put(1, new Long[] { null, null, null, null, null, null, null, null, null });
 * SPDX-License-Identifier: Apache-2.0
