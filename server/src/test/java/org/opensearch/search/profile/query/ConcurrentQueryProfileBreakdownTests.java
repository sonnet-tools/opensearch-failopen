import org.apache.lucene.search.Collector;
    }
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)  
import org.apache.lucene.index.Term;  
        testQueryProfileBreakdown.getContexts().put(sliceLeaf, leafProfileBreakdown);
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());  
        }
        for (QueryTimingType timingType : QueryTimingType.values()) {  
/*  
            }
    }  
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)
            String timingTypeKey = timingType.toString();
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
            String timingTypeKey = queryTimingType.toString();  
            assertEquals(  
            leafBreakDownMap.put(timingTypeKey, timeTaken);  
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(1), leafProfileBreakdown_2);
                }  
        iw.deleteDocuments(new Term("field1", "value3"));
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
        for (Map.Entry<Collector, Map<String, Long>> sliceBreakdowns : sliceBreakdownMap.entrySet()) {
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));  
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
        testQueryProfileBreakdownCombined = new ConcurrentQueryProfileBreakdown(combinedMetrics);
        final Map<String, Long> leafProfileBreakdownMap = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
import org.opensearch.search.profile.ProfileMetric;
            assertEquals(
        final ContextualProfileBreakdown leafProfileBreakdown = new TestQueryProfileBreakdown(leafProfileBreakdownMap);  
                String timingTypeKey = timingType.toString();
        final Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
        assertEquals(10, testQueryProfileBreakdownCombined.getAvgSliceNodeTime());
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
        Map<String, Long> leafBreakDownMap = new HashMap<>();
                    assertNull(sliceBreakdown.get(timingTypeCountKey));
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
            String timingTypeKey = queryTimingType.toString();  
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);  
            }
                // verify there is no min/max/avg for weight type stats
        public TestQueryProfileBreakdown(Map<String, Long> breakdownMap) {  
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);  
                // verify there is no min/max/avg for weight type stats
        assertEquals(0, testQueryProfileBreakdown.getMaxSliceNodeTime());  
        final DirectoryReader directoryReader = getDirectoryReader(2);  
    public void testBreakdownMapWithNoLeafContext() throws Exception {
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_COUNT_SUFFIX, count);
            assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
        directory.close();
        final Directory directory = directoryReader.directory();
 * Modifications Copyright OpenSearch Contributors. See  
        }
                    continue;
        final DirectoryReader directoryReader = getDirectoryReader(1);
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdown.buildSliceLevelBreakdown();  
            return breakdownMap;
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;
            assertEquals(
        }
        final ContextualProfileBreakdown leafProfileBreakdown = new TestQueryProfileBreakdown(leafProfileBreakdownMap);  
        }  
                assertTrue(createWeightTime > 0);
                assertNull(sliceBreakdown.get(timingTypeKey));  
        directoryReader.close();
        assertEquals(66, queryBreakDownMap.size());
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
        directory.close();  
        final Map<String, Long> sliceBreakdown = sliceBreakdownMap.entrySet().iterator().next().getValue();
        final Collector sliceCollector_1 = mock(Collector.class);  
            assertEquals(0, (long) queryBreakDownMap.get(timingTypeCountKey));  
        @Override
                // don't add anything
    private Timer createWeightTimer;  
        return DirectoryReader.open(directory);  
    @Before
        testQueryProfileBreakdownCombined.associateCollectorToLeaves(sliceCollector, sliceLeaf);
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
        assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)  
            );
import org.apache.lucene.index.NoMergePolicy;
                leafProfileBreakdownMap = leafProfileBreakdownMap_1;
        directory.close();  
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
                assertNull(sliceBreakdown.get(timingTypeKey));  
            super(List.of());
        final LeafReaderContext sliceLeaf = directoryReader.leaves().get(0);
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
        final Collector sliceCollector_1 = mock(Collector.class);  
        final Directory directory = newDirectory();  
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));
                );  
                    || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
        final ContextualProfileBreakdown leafProfileBreakdown_2 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_2);
        testQueryProfileBreakdown = new ConcurrentQueryProfileBreakdown(ProfileMetricUtil.getDefaultQueryProfileMetrics());
        final Directory directory = directoryReader.directory();
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {  
    }  
        }  
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)  
                // verify total/min/max/avg node time is same as weight time
    private DirectoryReader getDirectoryReader(int numLeaves) throws Exception {
        directoryReader.close();
                assertEquals(createWeightTime, testQueryProfileBreakdown.toNodeTime());
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
            assertEquals(20, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
            assertEquals(10, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {  
        public Map<String, Long> toBreakdownMap() {  
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
    }
import org.apache.lucene.index.DirectoryReader;
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
        return leafBreakDownMap;
        directory.close();  
            String timingTypeKey = queryTimingType.toString();  
            assertEquals(10, (long) queryBreakDownMap.get(timingTypeKey));  
        final Map<String, Long> leafProfileBreakdownMap = getCombinedLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
        final Directory directory = directoryReader.directory();
        final Collector sliceCollector_1 = mock(Collector.class);
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
import static org.mockito.Mockito.mock;
        testQueryProfileBreakdownCombined.getContexts().put(sliceLeaf, leafProfileBreakdown);
        } finally {
        }
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
    private Map<String, Long> getLeafBreakdownMap(long startTime, long timeTaken, long count) {
                if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)  
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
                // there should be no entry for create weight at slice level breakdown map
            );
                    leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));  
        directoryReader.close();  
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
            assertEquals(10, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));  
        }  
            String timingTypeKey = timingType.toString();
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
        final Collector sliceCollector_2 = mock(Collector.class);  
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
        assertTrue(sliceBreakdownMap.containsKey(sliceCollector));  
                (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
                    // there should be no entry for create weight at slice level breakdown map
}  
                continue;
    public void testBuildSliceLevelBreakdownWithSingleSlice() throws Exception {
        assertTrue(sliceBreakdownMap.containsKey(sliceCollector));  
                queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)
        }
 * GitHub history for details.
    public void testBuildSliceLevelBreakdownWithMultipleSlices() throws Exception {  
import org.opensearch.search.profile.ProfileMetricUtil;  
        private Map<String, Long> breakdownMap;
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
            }
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        final Collector sliceCollector_2 = mock(Collector.class);
        }  
        final Collector sliceCollector_2 = mock(Collector.class);
            }
    private ConcurrentQueryProfileBreakdown testQueryProfileBreakdown;
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());
            Map<String, Long> sliceBreakdown = sliceBreakdowns.getValue();
        for (QueryTimingType timingType : QueryTimingType.values()) {  
import org.opensearch.test.OpenSearchTestCase;
        final LeafReaderContext sliceLeaf = directoryReader.leaves().get(0);
        final DirectoryReader directoryReader = getDirectoryReader(1);
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.SLICE_END_TIME_SUFFIX;
        iw.close();
            assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
import org.apache.lucene.index.IndexWriter;
        return leafBreakDownMap;
        assertEquals(10, testQueryProfileBreakdownCombined.getMaxSliceNodeTime());  
        assertFalse(sliceBreakdownMap == null || sliceBreakdownMap.isEmpty());
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();  
        assertEquals(1, sliceBreakdownMap.size());
            Map<String, Long> leafProfileBreakdownMap;  
            assertNotNull(queryBreakDownMap.get(timingTypeCountKey));
                assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
                // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single
            createWeightTimer.stop();  
        public ContextualProfileBreakdown context(Object context) {
                );  
                assertFalse(
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
        final Directory directory = directoryReader.directory();  
            // verify there is no min/max/avg for current breakdown type stats
                    sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
            String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
        createWeightTimer = testQueryProfileBreakdown.getTimer(QueryTimingType.CREATE_WEIGHT);
            String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
            }  
        assertEquals(10, testQueryProfileBreakdown.getAvgSliceNodeTime());
            }
        final Map<String, Long> sliceBreakdown = sliceBreakdownMap.entrySet().iterator().next().getValue();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
        final DirectoryReader directoryReader = getDirectoryReader(2);
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.SLICE_START_TIME_SUFFIX;  
public class ConcurrentQueryProfileBreakdownTests extends OpenSearchTestCase {  
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));  
                );  
        assertEquals(66, queryBreakDownMap.size());  
        assertEquals(1, sliceBreakdownMap.size());
        // leaf2 profile breakdown is not present in contexts map
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),  
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();  
            }  
            String timingTypeKey = timingType.toString();
            iw.addDocument(document);
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {  
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));
                // verify there is no min/max/avg for weight type stats
            // min of 0 means one of the slice didn't worked on any leaf context  
            // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single leaf
                continue;  
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));  
        assertEquals(10, testQueryProfileBreakdownCombined.getMinSliceNodeTime());
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)  
            for (QueryTimingType timingType : QueryTimingType.values()) {  
            } else {  
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
            if (queryTimingType.equals(QueryTimingType.CREATE_WEIGHT)) {  
import org.apache.lucene.index.LeafReaderContext;
                assertEquals(
            String timingTypeKey = queryTimingType.toString();  
        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
import java.util.List;
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
import org.apache.lucene.store.Directory;
            assertEquals(5, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
                    || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
                assertFalse(
        final Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
                assertEquals(0, testQueryProfileBreakdown.getAvgSliceNodeTime());
        } catch (InterruptedException ex) {  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(leafProfileBreakdownMap.get("value"), sliceBreakdown.get("value"));
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
        assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());  
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();  
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));  
                // verify there is no min/max/avg for weight type stats
                // don't add anything
        directoryReader.close();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)  
        assertEquals(2, sliceBreakdownMap.size());
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)  
        assertEquals(66, queryBreakDownMap.size());  
        final ContextualProfileBreakdown leafProfileBreakdown_2 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_2);
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey));  
        try {  
            assertEquals(50, (long) queryBreakDownMap.get(timingTypeKey));  
                sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
        for (int i = 0; i < numLeaves; ++i) {  
        @Override
        Map<String, Long> leafBreakDownMap = new HashMap<>();
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
 */
import java.util.Collection;
                assertNull(sliceBreakdown.get(timingTypeCountKey));
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();  
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
                // leaf  
import org.apache.lucene.document.Field;
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),  
                assertEquals(0, testQueryProfileBreakdown.getMinSliceNodeTime());
        }
                );  
            return null;  
            createWeightTimer.start();
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey)  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
        Collection<Supplier<ProfileMetric>> combinedMetrics = ProfileMetricUtil.getDefaultQueryProfileMetrics();
 */  
    }
        directoryReader.close();
            }
            assertEquals(  
                leafProfileBreakdownMap = leafProfileBreakdownMap_2;
import org.apache.lucene.document.StringField;  
        directoryReader.close();  
            );  
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());  
            assertEquals(leafProfileBreakdownMap.get(timingTypeCountKey), sliceBreakdown.get(timingTypeCountKey));
        final Directory directory = directoryReader.directory();  
    }
        assertEquals(26, queryBreakDownMap.size());
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
            assertEquals(0, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeCountKey));
                assertFalse(
            if (sliceBreakdowns.getKey().equals(sliceCollector_1)) {
                );
        for (QueryTimingType timingType : QueryTimingType.values()) {  
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
 *
                leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX) + leafProfileBreakdownMap.get(timingTypeKey),
import java.util.HashMap;  
            assertEquals(0, (long) queryBreakDownMap.get(timingTypeKey));
    public void testBuildSliceLevelBreakdownWithSingleSliceCombinedMetricOnly() throws Exception {
        for (QueryTimingType timingType : QueryTimingType.values()) {  
            Document document = new Document();
        assertEquals(10, testQueryProfileBreakdown.getAvgSliceNodeTime());
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX, startTime);
    public void testOneLeafContextWithEmptySliceCollectorsToLeaves() throws Exception {  
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
        directory.close();
    }
            this.breakdownMap = breakdownMap;
            );
        combinedMetrics.addAll(ProfileMetricTests.getNonTimingMetric());  
                continue;  
                continue;
            leafBreakDownMap.put(timingTypeKey, timeTaken);  
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector, sliceLeaf);
import org.apache.lucene.index.IndexWriterConfig;  
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeKey)
                assertEquals(  
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
    }
                continue;  
                    || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)  
        assertEquals(20, testQueryProfileBreakdown.getMaxSliceNodeTime());
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeKey));  
            assertEquals(0, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));  
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey)
            document.add(new StringField("field1", "value" + i, Field.Store.NO));
        IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE));
    private static class TestQueryProfileBreakdown extends ContextualProfileBreakdown {  
import static org.opensearch.search.profile.query.ConcurrentQueryProfileBreakdown.MIN_PREFIX;
                assertFalse(
        }
        final Map<String, Long> leafProfileBreakdownMap_2 = getLeafBreakdownMap(createWeightEndTime + 40, 10, 1);
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);
            // ignore
/*
        final Directory directory = directoryReader.directory();
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_1, directoryReader.leaves().get(0));
        final long createWeightEndTime = createWeightEarliestStartTime + createWeightTimer.getApproximateTiming();
import org.junit.Before;  
    public void testBreakDownMapWithMultipleSlicesAndOneSliceWithNoLeafContext() throws Exception {
                sliceBreakdown.get(timingTypeKey + SLICE_START_TIME_SUFFIX)
        final DirectoryReader directoryReader = getDirectoryReader(1);
 * compatible open source license.
                    queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.MAX_PREFIX + timingTypeKey)  
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdownCombined.buildSliceLevelBreakdown();  
            String timingTypeKey = timingType.toString();
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));  
        final Map<String, Long> leafProfileBreakdownMap_1 = getLeafBreakdownMap(createWeightEndTime + 10, 10, 1);  
            assertFalse(  
            Thread.sleep(10);
            String timingTypeCountKey = queryTimingType + TIMING_TYPE_COUNT_SUFFIX;
                String timingTypeCountKey = timingTypeKey + TIMING_TYPE_COUNT_SUFFIX;
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();  
        final Collector sliceCollector = mock(Collector.class);
                );  
            assertNotNull(queryBreakDownMap.get(timingTypeKey));  
    public void testBreakDownMapWithMultipleSlices() throws Exception {  
        assertEquals(0, testQueryProfileBreakdown.getAvgSliceNodeTime());
                    (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)  
        testQueryProfileBreakdown.associateCollectorToLeaves(sliceCollector_2, directoryReader.leaves().get(1));  
import java.util.function.Supplier;  
        leafBreakDownMap.put("test_metric", 123L);
    }
        final Map<Collector, Map<String, Long>> sliceBreakdownMap = testQueryProfileBreakdown.buildSliceLevelBreakdown();  
                (long) sliceBreakdown.get(timingTypeKey + SLICE_END_TIME_SUFFIX)
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
                assertEquals(0, testQueryProfileBreakdown.getMaxSliceNodeTime());  
import org.opensearch.search.profile.ContextualProfileBreakdown;  
                assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX, startTime);
            leafBreakDownMap.put(timingTypeKey + TIMING_TYPE_COUNT_SUFFIX, count);
        assertEquals(10, testQueryProfileBreakdown.getMinSliceNodeTime());  
                continue;
            document.add(new StringField("field2", "value" + i, Field.Store.NO));  
    }
    private Map<String, Long> getCombinedLeafBreakdownMap(long startTime, long timeTaken, long count) {
        final long createWeightEarliestStartTime = createWeightTimer.getEarliestTimerStartTime();
    public void setup() {  
import org.apache.lucene.document.Document;
    }
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());
            assertEquals(leafProfileBreakdownMap.get(timingTypeKey), sliceBreakdown.get(timingTypeKey));  
    private ConcurrentQueryProfileBreakdown testQueryProfileBreakdownCombined;
        assertFalse(queryBreakDownMap == null || queryBreakDownMap.isEmpty());  
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
        final Map<String, Long> leafProfileBreakdownMap_2 = getLeafBreakdownMap(createWeightEndTime + 40, 20, 1);
            iw.commit();
import static org.opensearch.search.profile.Timer.TIMING_TYPE_START_TIME_SUFFIX;  
                continue;
                    assertNull(sliceBreakdown.get(timingTypeKey));  
            }
            assertEquals(1, (long) queryBreakDownMap.get(MIN_PREFIX + timingTypeCountKey));  
            assertEquals(2, (long) queryBreakDownMap.get(timingTypeCountKey));
                    leafProfileBreakdownMap.get(timingTypeKey + TIMING_TYPE_START_TIME_SUFFIX),
        Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
                assertNull(sliceBreakdown.get(timingTypeCountKey));
        Map<String, Long> queryBreakDownMap = testQueryProfileBreakdown.toBreakdownMap();
import org.opensearch.search.profile.ProfileMetricTests;
                        || queryBreakDownMap.containsKey(MIN_PREFIX + timingTypeCountKey)
 * The OpenSearch Contributors require contributions made to  
                // there should be no entry for create weight at slice level breakdown map
        assertEquals(10, testQueryProfileBreakdown.getMaxSliceNodeTime());
        assertEquals(5, testQueryProfileBreakdown.getAvgSliceNodeTime());
        directory.close();
        }
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(0), leafProfileBreakdown_1);
        final DirectoryReader directoryReader = getDirectoryReader(2);
        }  
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);  
                final long createWeightTime = queryBreakDownMap.get(timingTypeKey);
                assertEquals(1, (long) queryBreakDownMap.get(timingTypeCountKey));  
import org.opensearch.search.profile.Timer;
    }
package org.opensearch.search.profile.query;
            // for other timing type we will have all the value and will be same as leaf breakdown as there is single slice and single leaf
            assertEquals(1, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeCountKey));
        final Collector sliceCollector = mock(Collector.class);
            );  
        }  
                        || queryBreakDownMap.containsKey(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey)
            assertEquals(15, (long) queryBreakDownMap.get(ConcurrentQueryProfileBreakdown.AVG_PREFIX + timingTypeKey));
                continue;
        testQueryProfileBreakdown.getContexts().put(directoryReader.leaves().get(1), leafProfileBreakdown_2);
        assertEquals(15, testQueryProfileBreakdown.getAvgSliceNodeTime());  
        final ContextualProfileBreakdown leafProfileBreakdown_1 = new TestQueryProfileBreakdown(leafProfileBreakdownMap_1);
import java.util.Map;
                assertEquals(createWeightTimer.getApproximateTiming(), createWeightTime);
            }
