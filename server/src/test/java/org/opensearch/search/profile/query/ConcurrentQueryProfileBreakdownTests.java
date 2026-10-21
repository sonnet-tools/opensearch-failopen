        assertEquals(10, testQueryProfileBreakdownCombined.getAvgSliceNodeTime());
import org.apache.lucene.index.IndexWriterConfig;
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
    @Before
            }
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
        final Collector sliceCollector_1 = mock(Collector.class);
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());
            // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single leaf
                // verify there is no min/max/avg for weight type stats
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
                assertEquals(createWeightTime, testQueryProfileBreakdown.toNodeTime());
        testQueryProfileBreakdown = new ConcurrentQueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
        } catch (InterruptedException ex) {
            }
        }
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
                assertFalse(
            }
        final Directory directory = directoryReader.directory();
import java.util.Map;
            assertFalse(
    private DirectoryReader getDirectoryReader(int numLeaves) throws Exception {
            assertEquals(20, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));
        final LeafReaderContext sliceLeaf = directoryReader.leaves().get(0);
                    assertNull(sliceBreakdown.get(timingTypeCountKey));
                assertEquals(
import org.opensearch.search.profile.Timer;
        }
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
    private static class TestQueryProfileBreakdown extends ContextualProfileBreakdown {
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
        final DirectoryReader directoryReader = getDirectoryReader(1);
        testQueryProfileBreakdown.getContexts().put(sliceLeaf, leafProfileBreakdown);
        }
        assertEquals(66, queryBreakDownMap.size());
        final Directory directory = newDirectory();
        } finally {
        }
        assertEquals(2, sliceBreakdownMap.size());
            Map<String, Long> sliceBreakdown = sliceBreakdowns.getValue();
        for (QueryTimingType timingType : QueryTimingType.values()) {
                );
                assertEquals(
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {
            assertEquals(10, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
                queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {
    }
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
                    || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
                assertNull(sliceBreakdown.get(timingTypeCountKey));
            assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
                continue;
import org.opensearch.test.OpenSearchTestCase;
            String timingTypeKey = timingType.toString();
        public Map<String, Long> toBreakdownMap() {
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
        Map<String, Long> leafBreakDownMap = new HashMap<>();
                    assertNull(sliceBreakdown.get(timingTypeKey));
public class ConcurrentQueryProfileBreakdownTests extends OpenSearchTestCase {
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
        final ContextualProfileBreakdown leafProfileBreakdown = new TestQueryProfileBreakdown(leafProfileBreakdownMap);
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.MIN_PREFIX;
    }
import java.util.function.Supplier;
    public void setup() {
            // min of 0 means one of the slice didn't worked on any leaf context
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
        for (QueryTimingType timingType : QueryTimingType.values()) {
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
        // leaf2 profile breakdown is not present in contexts map
import org.apache.lucene.store.Directory;
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));
        final ContextualProfileBreakdown leafProfileBreakdown_2 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_2);
 * compatible open source license.
 */
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {
 */
                if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());
package org.opensearch.search.profile.query;
            leafBreakDownMap.put(timingTypeKey, timeTaken);
        directoryReader.close();
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
            assertNotNull(queryBreakDownMap.get(timingTypeCountKey));
        final Collector sliceCollector = mock(Collector.class);
import org.opensearch.search.profile.ProfileMetric;
        }
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
        final Directory directory = directoryReader.directory();
            // verify there is no min/max/avg for current breakdown type stats
import org.apache.lucene.document.Document;
        iw.deleteDocuments(new Term("field1", "value3"));
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdown.buildSliceLevelBreakdown();
        assertEquals(0, testQueryProfileBreakdown.getAvgSliceNodeTime());
        public TestQueryProfileBreakdown(Map<String, Long> breakdownMap) {
        final Directory directory = directoryReader.directory();
        @Override
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX, startTime);
        final Map<String, Long> leafProfileBreakdownMap_2 = getLeafBreakdownMap(createWeightEndTime + 40, 20, 1);
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals(0, testQueryProfileBreakdown.getMaxSliceNodeTime());
                );
                // verify there is no min/max/avg for weight type stats
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
        final DirectoryReader directoryReader = getDirectoryReader(2);
        directory.close();
        try {
        directoryReader.close();
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.SLICE_START_TIME_SUFFIX;
    }
        assertEquals(1, sliceBreakdownMap.size());
                continue;
        final DirectoryReader directoryReader = getDirectoryReader(1);
            assertEquals(
import static org.opensearch.search.profile.Timer.TIMING_TYPE_START_TIME_SUFFIX;
            assertEquals(
        final DirectoryReader directoryReader = getDirectoryReader(2);
            for (QueryTimingType timingType : QueryTimingType.values()) {
            }
import org.opensearch.search.profile.ProfileMetricTests;
        directoryReader.close();
        private Map<String, Long> breakdownMap;
            leafBreakDownMap.put(timingTypeKey, timeTaken);
            String timingTypeKey = timingType.toString();
        final ContextualProfileBreakdown leafProfileBreakdown = new TestQueryProfileBreakdown(leafProfileBreakdownMap);
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
import org.junit.Before;
                    continue;
                assertFalse(
            return null;
import java.util.HashMap;
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
            String timingTypeKey = queryTimingType.toString();
        final Directory directory = directoryReader.directory();
    }
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
    private ConcurrentQueryProfileBreakdown testQueryProfileBreakdown;
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));
        directory.close();
        final Collector sliceCollector_2 = mock(Collector.class);
        assertEquals(26, queryBreakDownMap.size());
            createWeightTimer.stop();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
                );
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_COUNT_SUFFIX, count);
            String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
        final Map<String, Long> sliceBreakdown = sliceBreakdownMap.entrySet().iterator().next().getValue();
                );
        directoryReader.close();
    }
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
            }
        final Directory directory = directoryReader.directory();
        }
        for (QueryTimingType timingType : QueryTimingType.values()) {
import org.apache.lucene.index.IndexWriter;
            Document document = new Document();
import org.apache.lucene.document.Field;
                leafProfileBreakdownMap = leafProfileBreakdownMap_2;
                (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)
                // verify total/min/max/avg node time is same as weight time
 * this file be licensed under the Apache-2.0 license or a
            iw.commit();
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
                continue;
            String timingTypeKey = timingType.toString();
                // don't add anything
        @Override
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
                assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());
        directoryReader.close();
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
        assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());
        final DirectoryReader directoryReader = getDirectoryReader(2);
import org.apache.lucene.index.Term;
        return DirectoryReader.open(directory);
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
            }
            assertNotNull(queryBreakDownMap.get(timingTypeKey));
            assertEquals(
                    || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
        }
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdownCombined.buildSliceLevelBreakdown();
                    leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
            assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
            assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
                assertFalse(
        iw.close();
import org.apache.lucene.index.LeafReaderContext;
            assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX, startTime);
            );
        assertEquals(15, testQueryProfileBreakdown.getAvgSliceNodeTime());
        for (int i = 0; i < numLeaves; ++i) {
                // leaf
                assertFalse(
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
            createWeightTimer.start();
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
        return leafBreakDownMap;
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
                sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
        assertEquals(20, testQueryProfileBreakdown.getMaxSliceNodeTime());
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        testQueryProfileBreakdownCombined = new ConcurrentQueryProfileBreakdown(combinedMetrics);
        assertEquals(66, queryBreakDownMap.size());
        Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
import java.util.List;
        final DirectoryReader directoryReader = getDirectoryReader(1);
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdown.buildSliceLevelBreakdown();
        final Collector sliceCollector = mock(Collector.class);
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
        assertEquals(10, testQueryProfileBreakdownCombined.getMaxSliceNodeTime());
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
                // there should be no entry for create weight at slice level breakdown map
        final Directory directory = directoryReader.directory();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
    }
                sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
                    leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),
            assertEquals(1, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.SLICE_END_TIME_SUFFIX;
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);
 * GitHub history for details.
            String timingTypeKey = queryTimingType.toString();
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
import org.opensearch.search.profile.ContextualProfileBreakdown;
            }
        assertEquals(10, testQueryProfileBreakdown.getAvgSliceNodeTime());
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));
        }
        final Collector sliceCollector_1 = mock(Collector.class);
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
        testQueryProfileBreakdownCombined.associateCollectorToLeaves(sliceCollector, sliceLeaf);
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
import org.opensearch.search.profile.ProfileMetricUtil;
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));
        assertEquals(5, testQueryProfileBreakdown.getAvgSliceNodeTime());
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),
                leafProfileBreakdownMap = leafProfileBreakdownMap_1;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        final Collector sliceCollector_1 = mock(Collector.class);
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
        final Map<String, Long> leafProfileBreakdownMap = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
                    sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
            document.add(new StringField("field2", "value" + i, Field.Store.NO));
        final Map<String, Long> leafProfileBreakdownMap = getCombinedLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
        assertTrue(sliceBreakdownMap.containsKey(sliceCollector));
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));
            assertEquals(2, (long) queryBreakDownMap.get(timingTypeCountKey));
import org.apache.lucene.index.NoMergePolicy;
                );
import org.apache.lucene.document.StringField;
                continue;
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
                    (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)
        combinedMetrics.addAll(ProfileMetricTests.getNonTimingMetric());
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
    public void testOneLeafContextWithEmptySliceCollectorsToLeaves() throws Exception {
            // ignore
/*
 *
                String timingTypeKey = timingType.toString();
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);
                // verify there is no min/max/avg for weight type stats
                );
    private Timer createWeightTimer;
            } else {
/*
                assertNull(sliceBreakdown.get(timingTypeCountKey));
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
        directory.close();
                assertTrue(createWeightTime > 0);
        }
                assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));
            Map<String, Long> leafProfileBreakdownMap;
            return breakdownMap;
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
        final Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
            assertEquals(
    }
                assertNull(sliceBreakdown.get(timingTypeKey));
            assertEquals(5, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));
            assertEquals(0, (long) queryBreakDownMap.get(timingTypeKey));
            assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
        final Collector sliceCollector_2 = mock(Collector.class);
 * SPDX-License-Identifier: Apache-2.0
            iw.addDocument(document);
            String timingTypeKey = queryTimingType.toString();
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        for (Map.Entry<Collector, Map<String, Long>> sliceBreakdowns : sliceBreakdownMap.entrySet()) {
            );
                continue;
    private Map<String, Long> getLeafBreakdownMap(long startTime, long timeTaken, long count) {
        createWeightTimer = testQueryProfileBreakdown.getTimer(QueryTimingType.CREATE_WEIGHT);
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
        final Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);
            String timingTypeKey = timingType.toString();
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_COUNT_SUFFIX, count);
    public void testBreakdownMapWithNoLeafContext() throws Exception {
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));
                // don't add anything
                // verify there is no min/max/avg for weight type stats
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(1), leafProfileBreakdown_2);
        final Collector sliceCollector_2 = mock(Collector.class);
        testQueryProfileBreakdownCombined.getContexts().put(sliceLeaf, leafProfileBreakdown);
                String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
            assertEquals(10, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));
        directory.close();
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));
        directoryReader.close();
        }
        Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
    public void testBuildSliceLevelBreakdownWithSingleSliceCombinedMetricOnly() throws Exception {
}
            // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single leaf
            assertEquals(15, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
            assertEquals(10, (long) queryBreakDownMap.get(timingTypeKey));
    }
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        final LeafReaderContext sliceLeaf = directoryReader.leaves().get(0);
        directory.close();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
    }
    public void testBuildSliceLevelBreakdownWithSingleSlice() throws Exception {
            super(List.of());
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
import org.apache.lucene.search.Collector;
        }
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
                }
    }
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector, sliceLeaf);
        assertTrue(sliceBreakdownMap.containsKey(sliceCollector));
    private Map<String, Long> getCombinedLeafBreakdownMap(long startTime, long timeTaken, long count) {
        assertEquals(0, testQueryProfileBreakdown.getMaxSliceNodeTime());
            Thread.sleep(10);
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
        IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE));
        for (QueryTimingType timingType : QueryTimingType.values()) {
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
    public void testBuildSliceLevelBreakdownWithMultipleSlices() throws Exception {
            assertEquals(0, (long) queryBreakDownMap.get(timingTypeCountKey));
                // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
        final Map<String, Long> sliceBreakdown = sliceBreakdownMap.entrySet().iterator().next().getValue();
        assertEquals(10, testQueryProfileBreakdown.getAvgSliceNodeTime());
                assertNull(sliceBreakdown.get(timingTypeKey));
                assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
        final ContextualProfileBreakdown leafProfileBreakdown_2 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_2);
        leafBreakDownMap.put("test_metric", 123L);
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
            }
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
                continue;
    }
    }
    public void testBreakDownMapWithMultipleSlices() throws Exception {
import java.util.Collection;
            String timingTypeKey = queryTimingType.toString();
            if (sliceBreakdowns.getKey().equals(sliceCollector_1)) {
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));
        assertEquals(1, sliceBreakdownMap.size());
        assertEquals(leafProfileBreakdownMap.get("value"), sliceBreakdown.get("value"));
            String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
    private ConcurrentQueryProfileBreakdown testQueryProfileBreakdownCombined;
        directory.close();
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
            document.add(new StringField("field1", "value" + i, Field.Store.NO));
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
    public void testBreakDownMapWithMultipleSlicesAndOneSliceWithNoLeafContext() throws Exception {
                continue;
        assertEquals(66, queryBreakDownMap.size());
            );
                assertEquals(0, testQueryProfileBreakdown.getAvgSliceNodeTime());
        }
                continue;
            assertEquals(50, (long) queryBreakDownMap.get(timingTypeKey));
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
            }
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
            this.breakdownMap = breakdownMap;
import static org.mockito.Mockito.mock;
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;
        Collection<Supplier<ProfileMetric>> combinedMetrics = ProfileMetricUtil.getDefaultQueryProfileMetrics();
                    // there should be no entry for create weight at slice level breakdown map
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(1), leafProfileBreakdown_2);
        }
        assertEquals(10, testQueryProfileBreakdownCombined.getMinSliceNodeTime());
        Map<String, Long> leafBreakDownMap = new HashMap<>();
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
            );
 * The OpenSearch Contributors require contributions made to
        return leafBreakDownMap;
                (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)
            );
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));
        final Map<String, Long> leafProfileBreakdownMap_2 = getLeafBreakdownMap(createWeightEndTime + 40, 10, 1);
import org.apache.lucene.index.DirectoryReader;
                // there should be no entry for create weight at slice level breakdown map
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
        }
            }
        public ContextualProfileBreakdown context(Object context) {
