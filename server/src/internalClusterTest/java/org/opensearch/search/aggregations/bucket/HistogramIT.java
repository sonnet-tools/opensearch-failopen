                        .interval(interval)
        assertThat(histo.getName(), equalTo("histo"));
        SearchResponse response = client().prepareSearch("idx")
                        .interval(interval)
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                throw e;
        builders.add(
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                .prepareStats("cache_test_idx")
            scripts.put("_value + 1", vars -> {
        numValueBuckets = numDocs / interval + 1;
        assertThat(buckets.size(), equalTo(numValuesBuckets));
        // constructing the newly expected bucket list
            .addAggregation(
            } else {
    }
            assertThat(sum.getValue(), equalTo((double) s));
        addExpectedBucket(5, 2, 5, 3);
        }
        assertSearchResponse(r);
            }
            assertThat(sum.getValue(), equalTo((double) s));
 * this work for additional information regarding copyright
        // first bucket should start at -5, contain 4 documents
                        .order(BucketOrder.aggregation("inner_histo>avg", asc))
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        }
        assertThat(histo.getName(), equalTo("histo"));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");
            assertThat(avg, notNullValue());
            assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                )
            client().prepareIndex("cache_test_idx").setId("1").setSource("d", -0.6),
                // expected
            .get();
            assertThat(bucket, notNullValue());
                long expectedFirstBucketCount = offset - 1;
        }
            Histogram.Bucket bucket = buckets.get(i);
        }
            .addAggregation(
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())
            .addAggregation(
        assertThat(
        long[] expectedKeys = new long[] { 2, 1, 4, 5, 3, 6, 7 };
        assertThat(histo, notNullValue());
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
    }
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));
        addExpectedBucket(3, 2, 3, 3);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    public void testUnmapped() throws Exception {
                .get()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5.1).field("l", 5).field("d", 2).endObject())
            client().prepareIndex("sort_idx")
            assertThat(bucket, notNullValue());
            for (int j = 0; j < numDocs; ++j) {
    public void singleValuedField_withOffset() throws Exception {
                )
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                    .subAggregation(filter("filter", matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME)))
            } else {
import java.util.Arrays;
        Histogram histo = response.getAggregations().get("histo");
                .getTotal()
        assertThat(histo.getBuckets().size(), equalTo(expectedNumberOfBuckets));
    public void testMultiValuedFieldOrderedByKeyDesc() throws Exception {
        assertEquals(1, buckets.get(1).getDocCount());
                .setRequestCache(true)
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                .get()
    }
import static org.hamcrest.Matchers.equalTo;
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
            assertTrue(buckets.add(key));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                assertThat(bucket.getDocCount(), equalTo((long) interval));
                .prepareStats("cache_test_idx")
        // last bucket should have (numDocs % interval + 1) docs
            boundsMaxKeyDelta = -boundsMaxKeyDelta;
            assertThat(bucket.getDocCount(), equalTo(0L));
        final long[] counts = new long[(numDocs + 2) / interval + 1];
        );
        assertThat(bucket, notNullValue());
            assertThat(bucket, notNullValue());
    }
     * Ensure requests using nondeterministic scripts do not get cached.
        indexRandom(
        assertThat(histo, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
        }
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
    public void testSingleValuedFieldOrderedByKeyAsc() throws Exception {
                            .startArray(MULTI_VALUED_FIELD_NAME)
            boundsMinKey = -boundsMinKey;
        Histogram histo = response.getAggregations().get("histo");
        bucketProps.put("sum_d", sum);
            true,
        );
    }
                        .extendedBounds(boundsMin, boundsMax)
            equalTo(0L)
        assertThat(histo.getName(), equalTo("sub_histo"));
        Histogram histo = response.getAggregations().get("histo");
                .get()
        }
    }
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            assertTrue(buckets.add(key));
            assertThat(bucket, notNullValue());
        );
        histogram = r.getAggregations().get("histo");
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        );
        for (int i = 0; i < numDocs; ++i) {
    /**
        assertEquals(0.05, (double) buckets.get(1).getKey(), 0.01d);
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertMultiSortResponse(
            assertThat(bucket, notNullValue());
        assertThat(histo.getName(), equalTo("histo"));
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                docsCounted += expectedFirstBucketCount;
    }
                .getRequestCache()
        }
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        long boundsMinKey = addedBucketsLeft * interval;
/*
    private void assertMultiSortResponse(long[] expectedKeys, BucketOrder... order) {
            key += interval;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.metrics.Max;
        SearchResponse response = client().prepareSearch("idx")
    }
    public void testPartiallyUnmappedWithExtendedBounds() throws Exception {
        }
                .get()
import org.opensearch.search.aggregations.bucket.filter.Filter;
                .getTotal()
    public void testSingleValuedFieldWithRandomOffset() throws Exception {
                    .order(BucketOrder.aggregation("sum", false))
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) ((i - 1) * interval + offset)));
        assertThat(histogram, notNullValue());
        long[] expectedKeys = new long[] { 6, 7, 3, 4, 5, 1, 2 };
            true,
        assertThat(histo, notNullValue());
            .get();
import static org.hamcrest.Matchers.is;
        assertThat(histo, notNullValue());
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
        }
    }
        SearchResponse response = client().prepareSearch("idx")
        bucketProps.put("_count", docCount);
    private long key(Histogram.Bucket bucket) {
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
            )
    }
        assertThat(histo, notNullValue());
            }
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
            Histogram.Bucket bucket = buckets.get(i);
                            .endObject()
        long previousCount = Long.MAX_VALUE;
        long boundsMaxKeyDelta = addedBucketsRight * interval;
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        assertEquals(-0.65, (double) buckets.get(0).getKey(), 0.01d);
        // from setup we have between 6 and 20 documents, each with value 1 in test field
                    .interval(1)
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
        assertThat(
            });
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
            int b = (int) (key / interval);
import org.opensearch.script.Script;
            )
        numValuesBuckets = (numDocs + 1) / interval + 1;
            client().prepareIndex("sort_idx")
        } catch (SearchPhaseExecutionException e) {
        }
                .indices()
                    .subAggregation(sum("sum_d").field("d"))
            assertThat(sum, notNullValue());
        SearchResponse response = client().prepareSearch("sort_idx")
                )
            )
import org.opensearch.search.aggregations.metrics.Avg;
import java.util.List;
                .get()
        );
            prepareCreate("cache_test_idx").setMapping("d", "type=float")
            long s = 0;
                histogram("histo").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['l_value'].value", emptyMap()))
        expectedMultiSortBuckets.put(key, bucketProps);
                .getRequestCache()
import org.opensearch.action.search.SearchResponse;
 * ownership. Elasticsearch licenses this file to you under
                if ((j + 1) / interval == b) {
            assertThat(propertiesDocCounts[i], equalTo(valueCounts[i]));
                    .interval(interval)
 */
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertSearchResponse(r);
        SearchResponse r = client().prepareSearch("test")
            () -> client().prepareSearch("empty_bucket_idx")
            .addAggregation(
        assertThat(histo, notNullValue());
    public void testSingleValuedFieldOrderedBySubAggregationDesc() throws Exception {
        long boundsMin = boundsMinKey + randomIntBetween(0, interval - 1);
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))
                .prepareStats("cache_test_idx")
        boolean invalidBoundsError = boundsMin > boundsMax;
        for (int i = 0; i < numDocs; i++) {
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationDesc() throws Exception {
        long[] extendedValueCounts = new long[bucketsCount];
        List<? extends Bucket> buckets = histo.getBuckets();
        valueCounts = new long[numValueBuckets];
    }
            valuesCounts[bucket1]++;
            .setSize(0)
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3.8).field("l", 3).field("d", 2).endObject())
        );
            assertThat(max, Matchers.notNullValue());
        createIndex("idx");
import java.util.Collections;
            );
        assertThat(histo.getName(), equalTo("histo"));
                .getRequestCache()
        }
            Filter filter = bucket.getAggregations().get("filter");
                return;
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
        }
        );
            .get();
            equalTo(0L)
        SearchResponse response = client().prepareSearch("idx_unmapped")
        assertThat(((Number) bucket.getKey()).longValue(), equalTo(numDocs % interval1 + 5L));
        assertSearchResponse(response);
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))
            Histogram.Bucket bucket = buckets.get(i);
                .get();
        for (int i = 0; i < numDocs; i++) {
        Histogram histo = response.getAggregations().get("histo");
            }
                .get()
                .prepareStats("cache_test_idx")
                    .interval(0.7)
            .get();
        SearchResponse response = client().prepareSearch("idx")
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        // randomizing the number of buckets on the min bound
                histogram("histo").field("d")
                histogram("histo").field("d")
        r = client().prepareSearch("test")
        SearchResponse response = null;
            final int bucket1 = (i + 1) / interval;
            assertThat(bucket, notNullValue());
                .getTotal()
        double previousSum = Double.NEGATIVE_INFINITY;
        int lastDataBucketKey = (numValueBuckets - 1) * interval;
        assertThat(histo.getBuckets().size(), equalTo(numValuesBuckets));
        assertThat(
        getMultiSortDocs(builders);
        }
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
    }
        bucket = histo.getBuckets().get(0);
                    .extendedBounds(-1 * 2 * interval, valueCounts.length * interval)
        addExpectedBucket(4, 2, 3, 4);
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) (i - 2) * interval));
            assertEquals(propertiesKeys[i], (double) i * interval);
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
import org.opensearch.common.settings.Settings;
            client().admin()
                .getTotal()
        assertThat(histo.getName(), equalTo("histo"));
        }
import org.opensearch.search.aggregations.bucket.histogram.DoubleBounds;
            BucketOrder.count(false),
                        .extendedBounds(boundsMin, boundsMax)
        return ((Number) bucket.getKey()).longValue();
        Histogram histo = response.getAggregations().get("histo");
     */
        boolean asc = true;
        assertSearchResponse(r);
            );
                .setQuery(QueryBuilders.termQuery("foo", "bar"))
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4.4).field("l", 3).field("d", 3).endObject())
                                .subAggregation(avg("avg").field("value"))
    public void testMultiValuedField() throws Exception {
        );
        SearchResponse response = client().prepareSearch("idx")
            .get();
            assertTrue(visited.add(key));
        for (int i = 0; i < numValueBuckets; ++i) {
        assertThat(bucket, Matchers.notNullValue());
            }
        );
                        )
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.count(false)))
        int offset = 5;
            previousSum = s;
            Histogram.Bucket bucket = buckets.get(i);
                        .minDocCount(0)
                throw e;
                .getHitCount(),
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            return scripts;
                .indices()
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        Histogram.Bucket bucket = buckets.get(0);
            for (int j = 0; j < numDocs; ++j) {
        assertThat(histo.getName(), equalTo("histo"));
    public void testExeptionOnNegativerInterval() {
                return;
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
            Sum sum = bucket.getAggregations().get("sum");
            .get();
            () -> client().prepareSearch("empty_bucket_idx")
        buckets = histogram.getBuckets();
            assertEquals(0, key % interval);
        assertSearchResponse(r);
            assertThat(sum, notNullValue());
        );
        // it could be that the random bounds.min we chose ended up greater than bounds.max - this should cause an
            }
        assertEquals(-0.6, (double) buckets.get(0).getKey(), 0.01d);
        Histogram histo = response.getAggregations().get("histo");
        // Ensure that non-scripted requests are cached as normal
 * KIND, either express or implied.  See the License for the
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndKeyAsc() throws Exception {
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) key));
            assertTrue(visited.add(key));
        assertThat(bucket, notNullValue());
            boundsMinKey = -boundsMinKey;
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        builders.add(
        } else {
        SearchResponse response = client().prepareSearch("idx")
            client().prepareIndex("test").setId("3").setSource("d", 0.1)
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));
            long s = 0;
        assertThat(histo, notNullValue());
        @Override
    public void testMultiValuedFieldWithValueScript() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            assertTrue(visited.add(key));
    public static Collection<Object[]> parameters() {
 * not use this file except in compliance with the License.
                    .order(BucketOrder.aggregation("sum", true))
                .setRequestCache(true)
 *
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyDesc() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        }
            fail();
                .addAggregation(
        }
            assertTrue(visited.add(key));
        long boundsMax = boundsMaxKey + randomIntBetween(0, interval - 1);
import org.opensearch.script.ScriptType;
            key += interval;
        assertSearchResponse(r);
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
            )
    }
    public void setupSuiteScopeCluster() throws Exception {
        int interval1 = 10;
        int addedBucketsRight = randomIntBetween(0, numValueBuckets);
        }
        SearchPhaseExecutionException e = expectThrows(
        for (int i = 0; i < bucketsCount; i++) {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo.getName(), equalTo("histo"));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
        final Set<Long> visited = new HashSet<>();
        for (int i = 0; i < numValueBuckets; ++i) {
        SearchResponse response = client().prepareSearch("idx")
            client().prepareIndex("test").setId("2").setSource("d", 0.5),
            final int bucket1 = (i + 2) / interval;
        }
@OpenSearchIntegTestCase.SuiteScopeTestCase
        int expectedNumberOfBuckets = (offset >= (numDocs % interval + 1)) ? numValueBuckets : numValueBuckets + 1;
            previousSum = s;
        // randomizing the number of buckets on the max bound
            boundsMaxKeyDelta = -boundsMaxKeyDelta;
                    s += j + 1;
     * Special care needs to be taken for expecations on counts in first and last bucket.
                    throw e;
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        for (int i = 0; i < 2; i++) {
            client().admin()
        long boundsMaxKey = lastDataBucketKey + boundsMaxKeyDelta;
import org.opensearch.script.MockScriptPlugin;
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
        assertSearchResponse(response);
        valuesCounts = new long[numValuesBuckets];
    }
                } else {
            addedBucketsLeft = 0;
            long key = ((Number) bucket.getKey()).longValue();
        assertThat(buckets.size(), equalTo(numBuckets));
        }
            .get();
        } catch (IllegalArgumentException e) {
import static org.hamcrest.core.IsNull.notNullValue;
 * GitHub history for details.
        assertThat(histo.getName(), equalTo("histo"));
        }
                    s += j + 1;
        assertThat(histo, notNullValue());
        for (int i = 0; i < numValueBuckets; ++i) {
        assertSearchResponse(response);
        // shifting by offset>2 creates new extra bucket [0,offset-1]
                            .field("tag", "tag" + i)
        try {
        List<? extends Bucket> buckets = histo.getBuckets();
        Histogram histo = response.getAggregations().get("histo");
                assertThat(bucket.getDocCount(), equalTo((long) numDocs - docsCounted));
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            Max max = filter.getAggregations().get("max");
                docsCounted += interval;
                }
        assertSearchResponse(response);
            Sum sum = bucket.getAggregations().get("sum");
        Histogram histogram = response.getAggregations().get("histo");
            assertThat(bucket.getDocCount(), equalTo(counts[key / interval]));
        assertThat(histo, notNullValue());
        long boundsMaxKeyDelta = addedBucketsRight * interval;
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        @Override
            client().prepareIndex("sort_idx")
        Histogram histogram = r.getAggregations().get("histo");
        Histogram histo = response.getAggregations().get("histo");
                .getMissCount(),
        assertThat(histo.getName(), equalTo("histo"));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        // it could be that the random bounds.min we chose ended up greater than bounds.max - this should cause an
                histogram("histo").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['l_values']", emptyMap()))
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertSearchResponse(response);
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        );
            assertThat(bucket, notNullValue());
            assertThat(stats.getSum(), lessThanOrEqualTo(previousSum));
                .get()
                .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(-1).minDocCount(0))
        }
                    .subAggregation(avg("avg_l").field("l"))
        for (int i = 0; i < numValueBuckets; ++i) {
        assertSearchResponse(response);
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
            addedBucketsRight = 0;
        Histogram histo = response.getAggregations().get("histo");
        assertThat(buckets.size(), equalTo(numValuesBuckets));
                return doc.get(SINGLE_VALUED_FIELD_NAME);
            client().admin()
            client().admin()
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));
     */
                .indices()
        int bucketsCount = numValueBuckets + addedBucketsLeft + addedBucketsRight;
        assertAcked(prepareCreate("decimal_values").setMapping("d", "type=float").get());
    public void testEmptyWithExtendedBounds() throws Exception {
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
                .get()
                OpenSearchException rootCause = rootCauses[0];
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) key));
    public void testSingleValuedFieldWithExtendedBounds() throws Exception {
    public void testDecimalIntervalAndOffset() throws Exception {
    }
                .getRequestCache()
            return scripts;
        for (int i = 0; i < numValueBuckets; ++i) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(bucket, notNullValue());
            ++counts[bucket1];
        assertSearchResponse(response);
import static java.util.Collections.emptyMap;
    @ParametersFactory
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(true)))
        assertThat(histo, Matchers.notNullValue());
            .setQuery(matchAllQuery())
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
            for (int j = 0; j < numDocs; ++j) {
    static long[] valueCounts, valuesCounts;
    }
            valueCounts[bucket]++;
            assertThat(e.toString(), containsString("[interval] must be >0 for histogram aggregation [histo]"));
        for (int i = 0; i < numValuesBuckets; ++i) {
            equalTo(0L)
                .addAggregation(
    @Override
        assertThat(histo.getName(), equalTo("histo"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                .get();
            Histogram.Bucket bucket = buckets.get(numValueBuckets - i - 1);
        histogram = r.getAggregations().get("histo");
        Histogram histo = response.getAggregations().get("histo");
        }
            if (rootCauses.length == 1) {
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval1).offset(offset))
                    .interval(interval)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(
        assertThat(bucket.getDocCount(), equalTo(4L));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(histo, notNullValue());
            BucketOrder.aggregation("sum_d", false),
            int key = ((2 / interval) + i) * interval;
        assertThat(buckets.size(), equalTo(numBuckets));
        assertSearchResponse(response);
    public static class CustomScriptPlugin extends MockScriptPlugin {
import org.opensearch.search.aggregations.metrics.Stats;
        assertSearchResponse(response);
        } else {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            .get();
            .get();
        addExpectedBucket(1, 3, 1, 6);
            } else {
            expectedKeys,
        System.arraycopy(valueCounts, 0, extendedValueCounts, addedBucketsLeft, valueCounts.length);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        assertSearchResponse(response);
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) -1 * interval));
            scripts.put("Math.random()", vars -> HistogramIT.randomDouble());
    /**
                .get();
        for (int i = 0; i < numValuesBuckets; ++i) {
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        assertSearchResponse(response);
        List<? extends Bucket> buckets = histo.getBuckets();
                .getRequestCache()
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
        if (rarely()) {
    }
        for (int i = 0; i < numValueBuckets; ++i) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .get();
        assertThat(buckets.size(), equalTo(bucketsCount));
    public void testHardBounds() throws Exception {
        assertThat(histo, notNullValue());
        for (int i = 0; i < numValueBuckets; ++i) {
        }
            long key = ((Number) bucket.getKey()).longValue();
            }
        bucket = buckets.get(1);
        assertThat(
        // (can sometimes fall within the data range, but more frequently will fall before the data range)
            )
        }
            if (invalidBoundsError) {
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");
    }
        long[] expectedKeys = new long[] { 5, 6, 7, 3, 4, 2, 1 };
        );
        double previousSum = Double.POSITIVE_INFINITY;
        List<? extends Bucket> buckets = histogram.getBuckets();
            .get();
            client().prepareIndex("sort_idx")
        SearchResponse r = client().prepareSearch("cache_test_idx")
            builders.add(
 * The OpenSearch Contributors require contributions made to
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        final int numBuckets = (numDocs + 2) / interval - 2 / interval + 1;
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(buckets.size(), equalTo(bucketsCount));
            Histogram.Bucket bucket = buckets.get(i);
    }
    }
            .get();
    public void testSingleValuedFieldWithValueScript() throws Exception {
        }
                    .subAggregation(histogram("sub_histo").field(SINGLE_VALUED_FIELD_NAME).interval(1L))
                    .order(BucketOrder.aggregation("max_constant", randomBoolean()))
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
        assertThat(buckets.size(), equalTo(numValueBuckets));
        long previousCount = Long.MIN_VALUE;
                .setRequestCache(true)
        }
            .get();
            .addAggregation(histogram("histo").field("d").interval(0.7).offset(0.05))
                    .offset(0.05)
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                }
                return doc.get(MULTI_VALUED_FIELD_NAME);
        int i = 0;
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
        super(staticSettings);
    }
        addExpectedBucket(2, 3, 2, 6);
            assertThat(sum, notNullValue());
                return value + 1L;
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");
            for (int j = 0; j < numDocs; ++j) {
            .get();
        for (int i = 0; i < numBuckets; i++) {
            client().prepareIndex("sort_idx")
                    .subAggregation(max("max_constant").field("constant"))
            assertThat(key(bucket), equalTo(expectedKeys[i]));
            assertThat(stats.getSum(), equalTo((double) s));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
            assertThat(propertiesCounts[i], equalTo((double) s));
        );
            assertThat(bucket, notNullValue());
                assertThat(bucket.getDocCount(), equalTo(expectedFirstBucketCount));
        createIndex("idx_unmapped");
            equalTo(0L)
    public void testSingleValuedFieldOrderedBySubAggregationAsc() throws Exception {
        for (int i = 0; i < numValueBuckets; ++i) {
        final Set<Long> buckets = new HashSet<>();
        assertThat(histogram.getName(), equalTo("histo"));
    }
                client().prepareIndex("sort_idx")
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(null, 0.0)))
            }
    public void testInvalidBounds() {
    static Map<Long, Map<String, Object>> expectedMultiSortBuckets;
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                    .offset(0.05)
    public HistogramIT(Settings staticSettings) {
        Histogram histo = response.getAggregations().get("histo");
            );
        assertSearchResponse(response);
        for (int i = 0; i < numValueBuckets; ++i) {
import org.hamcrest.Matchers;
        assertEquals(0.5, (double) buckets.get(4).getKey(), 0.01d);
        internalCluster().wipeIndices("cache_test_idx");
                    .interval(interval)
    }
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())
            assertThat(bucket, notNullValue());
            int b = (int) (key / interval);
        assertThat(buckets.size(), equalTo(numValueBuckets));
    }
        int expectedNumberOfBuckets = (offset >= (numDocs % interval + 1)) ? numValueBuckets : numValueBuckets + 1;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo, notNullValue());
        assertSearchResponse(response);
            client().prepareIndex("sort_idx")
        assertSearchResponse(response);
        int offset = randomIntBetween(2, interval);
        interval = randomIntBetween(2, 5);
                    .setId("" + i)
     * Shift buckets by random offset between [2..interval]. From setup we have 1 doc per values from 1..numdocs.
                        .minDocCount(0)
        assertEquals(1, buckets.size());
        );
            .addAggregation(
import org.opensearch.action.index.IndexRequestBuilder;
        assertSearchResponse(response);
    }
                }
            assertThat(bucket, notNullValue());
     */
                .getTotal()
        assertThat(histo.getBuckets().size(), equalTo(0));
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
                if ((j + 1) / interval == i) {
                .getHitCount(),
        assertThat(bucket.getDocCount(), equalTo((numDocs % interval) + 1L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            .get();
import java.util.ArrayList;
            long s = 0;
        assertThat(histo.getName(), equalTo("histo"));
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            builders.add(
        builders.add(
 */
            Histogram.Bucket bucket = buckets.get(i);
            .get();
            assertThat(bucket, notNullValue());
        }
package org.opensearch.search.aggregations.bucket;
            assertThat(sum.getValue(), equalTo((double) s));
            Histogram.Bucket bucket = buckets.get(numValuesBuckets - i - 1);
    }
        Histogram histo = searchResponse.getAggregations().get("histo");
            }
            fail("Expected an exception");
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;
        assertSearchResponse(response);
        try {
        try {
            client().prepareIndex("decimal_values").setId("1").setSource("d", -0.6),
            OpenSearchException[] rootCauses = e.guessRootCauses();
                Map<?, ?> doc = (Map) vars.get("doc");
    }
            .addAggregation(
    public void testScriptMultiValued() throws Exception {
        }
            .get();
            assertThat(bucket.getDocCount(), equalTo(valueCounts[(int) (key / interval)]));
        List<? extends Bucket> buckets = histo.getBuckets();
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        long boundsMax = boundsMaxKey + randomIntBetween(0, interval - 1);
        assertSearchResponse(response);
        boolean invalidBoundsError = boundsMin > boundsMax;
        long boundsMinKey = addedBucketsLeft * interval;
        Histogram histo = response.getAggregations().get("histo");
            assertThat(bucket.getDocCount(), lessThanOrEqualTo(previousCount));
    public void testPartiallyUnmapped() throws Exception {
        long[] expectedKeys = new long[] { 1, 2, 4, 3, 7, 6, 5 };
                    .order(BucketOrder.aggregation("stats.sum", false))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        for (int i = 0; i < numValueBuckets; ++i) {
                if (rootCause instanceof AggregationExecutionException) {
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(histo.getName(), equalTo("histo"));
            Histogram.Bucket bucket = buckets.get(i);
        ensureSearchable();
            assertThat(max.getValue(), asc ? greaterThanOrEqualTo(prevMax) : lessThanOrEqualTo(prevMax));
        }
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            assertThat(sum.getValue(), greaterThanOrEqualTo(previousSum));
            )
        for (int i = 0; i < numValueBuckets; ++i) {
        assertSearchResponse(response);
 * compatible open source license.
                            .value(i + 2)
import java.util.function.Function;
                if ((j + 1) / interval == b) {
    /**
        assertThat(histo, notNullValue());
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        SearchResponse response = null;
            }
                .getTotal()
        for (int i = 0; i < numValuesBuckets; ++i) {
            assertThat(bucket.getDocCount(), equalTo(counts[key / interval]));
        assertThat(histo, notNullValue());
                Map<?, ?> doc = (Map) vars.get("doc");
        } catch (IllegalArgumentException e) {
        assertThat(((InternalAggregation) histo).getProperty("_bucket_count"), equalTo(numValueBuckets));
                .setRequestCache(true)
            assertThat(bucket, notNullValue());
                histogram("histo").field(MULTI_VALUED_FIELD_NAME)
        assertThat(histo, notNullValue());
        long key = boundsMinKey;
                // first bucket
        assertThat(histo.getName(), equalTo("histo"));
                .getMissCount(),
            Histogram.Bucket bucket = buckets.get(i);
import java.util.Set;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                .indices()
                .setRequestCache(true)
    static int numDocs;
        SearchResponse response = client().prepareSearch("idx")
        Histogram histo = response.getAggregations().get("histo");
        long key = Math.min(boundsMinKey, 0);
                            .field(SINGLE_VALUED_FIELD_NAME, i + 1)
        for (int i = 0; i < numValueBuckets; ++i) {
            response = client().prepareSearch("idx")
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
                    .order(BucketOrder.aggregation("filter>max", asc))
        // (can sometimes fall within the data range, but more frequently will fall before the data range)
                .addAggregation(
                throw e;
        assertThat(histo.getName(), equalTo("histo"));
                .indices()
        );
            .get();
        assertThat(histo, notNullValue());
        for (int i = 0; i < numDocs; i++) {
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i - 2]));
        try {
 *
        assertThat(e.toString(), containsString("Extended bounds have to be inside hard bounds, hard bounds"));
        for (int i = 0; i < numDocs; ++i) {
        assertEquals(1, buckets.get(0).getDocCount());
                    .interval(interval)
        e = expectThrows(
                    .order(BucketOrder.compound(order))
        // randomizing the number of buckets on the max bound
            previousCount = bucket.getDocCount();
    }
            client().prepareIndex("sort_idx")
        addExpectedBucket(7, 1, 5, 1);
                .getRequestCache()
                .getHitCount(),
            addedBucketsRight = 0;
        );
            .addAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        bucketProps.put("key", key);
            });
        Histogram histo = response.getAggregations().get("histo");
        assertSearchResponse(response);
            .addAggregation(
            )
        // error
            assertThat(bucket.getDocCount(), equalTo(extendedValueCounts[i]));
                client().prepareIndex("idx")
                    .interval(interval)
 * this file be licensed under the Apache-2.0 license or a
        );
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        SearchResponse response = client().prepareSearch("idx")
            Histogram.Bucket bucket = histoBuckets.get(i);
        for (int i = 1; i <= 3; i++) {
        Histogram histo = response.getAggregations().get("histo");
            previousSum = s;
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.count(true)))
            Histogram.Bucket bucket = buckets.get(i);
            if (invalidBoundsError) {
                            histogram("inner_histo").interval(interval)
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                    .interval(1L)
        );
            )
        assertThat(histo.getName(), equalTo("histo"));
            client().admin()
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        expectedMultiSortBuckets = new HashMap<>();
                .prepareStats("cache_test_idx")
            .get();
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))
            int b = (int) (key / interval);
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo, notNullValue());
                ++counts[bucket2];
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(histo, notNullValue());
            assertThat(bucket, notNullValue());
        );
                .prepareStats("cache_test_idx")
    }
        SearchResponse response = client().prepareSearch("idx")
            .get();
            assertThat(bucket.getDocCount(), equalTo(valueCounts[(int) (key / interval)]));
        }
        builders.add(
        final Set<Long> visited = new HashSet<>();
        long boundsMaxKey = lastDataBucketKey + boundsMaxKeyDelta;
        long boundsMin = boundsMinKey + randomIntBetween(0, interval - 1);
            scripts.put("doc['l_value'].value", vars -> {
        assertThat(histo, notNullValue());
        int addedBucketsRight = randomIntBetween(0, numValueBuckets);
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        );
            i++;
            .addAggregation(
    }
            .get();
        assertThat(histo, Matchers.notNullValue());
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(0.0, 0.3)))
            if (invalidBoundsError) {
        assertSearchResponse(response);
        }
        assertThat(histo.getBuckets().isEmpty(), is(true));
    public void testSingleValuedFieldOrderedByCountAsc() throws Exception {
                    .setSource(
    public void testSingleValuedFieldOrderedByCountDesc() throws Exception {
            .get();
 * under the License.
            .addAggregation(histogram("histo").field(MULTI_VALUED_FIELD_NAME).interval(interval))
            scripts.put("doc['l_values']", vars -> {
        assertSearchResponse(r);
        List<Histogram.Bucket> histoBuckets = new ArrayList<>(histo.getBuckets());
                .setRequestCache(true)
        builders.add(
                    s += j + 1;
        assertSearchResponse(response);
        builders.add(
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
            .addAggregation(histogram("histo").field(MULTI_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(false)))
        buckets = histogram.getBuckets();
                    .minDocCount(0)
                            .endArray()
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(histo, notNullValue());
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
            long key = ((Number) bucket.getKey()).longValue();
                .get()
}
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(bucket, notNullValue());
            client().admin()
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
            prevMax = max.getValue();
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        indexRandom(
            assertThat(stats, notNullValue());
            if (invalidBoundsError) {
    private void addExpectedBucket(long key, long docCount, double avg, double sum) {
        final long[] counts = new long[(numDocs + 1) / interval + 1];
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            .addAggregation(
        assertAcked(
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
            .get();
            if (i == 0) {
            Histogram.Bucket bucket = buckets.get(i);
        SearchResponse response = client().prepareSearch("idx")
            Avg avg = bucket.getAggregations().get("avg_l");
        // Test that a request using a deterministic script gets cached
            .get();
        List<? extends Bucket> buckets = histogram.getBuckets();
        builders.add(
import org.opensearch.test.OpenSearchIntegTestCase;
            )
            assertThat(bucket, notNullValue());
                .getMissCount(),
        int lastDataBucketKey = (numValueBuckets - 1) * interval;
            }
            .get();
        numDocs = randomIntBetween(6, 20);
        Histogram histogram = r.getAggregations().get("histo");
            Stats stats = bucket.getAggregations().get("stats");
            .addAggregation(
                double value = (double) vars.get("_value");
        assertAcked(prepareCreate("test").setMapping("d", "type=double").get());
                        .interval(interval)
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        SearchResponse response = client().prepareSearch("idx")
        );
        );
                .addAggregation(
    }
        assertSearchResponse(response);
        // Make sure we are starting with a clear cache
                    .interval(interval)
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
        if (rarely()) {
        assertThat(
        }
                            .value(i + 1)
    public void testSingleValuedField() throws Exception {
            BucketOrder.aggregation("avg_l", false)
        assertThat(histogram.getBuckets().size(), equalTo(expectedKeys.length));
import org.opensearch.OpenSearchException;
        );
            .addAggregation(
                .getHitCount(),
            Histogram.Bucket bucket = buckets.get(i);
                .getMissCount(),
    public void testScriptSingleValue() throws Exception {
    }
        long[] expectedKeys = new long[] { 6, 7, 3, 5, 4, 1, 2 };
    }
/*
    public void testSingleValuedFieldOrderedBySubAggregationDescDeepOrderPath() throws Exception {
        for (int i = 0; i < numBuckets; i++) {
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
            Histogram.Bucket bucket = histo.getBuckets().get(i);
import java.util.HashSet;
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", emptyMap()))
 * license agreements. See the NOTICE file distributed with
        SearchResponse response = client().prepareSearch("idx")
            } else {
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
        r = client().prepareSearch("test")
    public void testScriptCaching() throws Exception {
import org.opensearch.search.aggregations.InternalAggregation;
            .get();
        SearchResponse r = client().prepareSearch("decimal_values")
 */
            response = client().prepareSearch("idx")
        for (int i = 0; i < bucketsCount; i++) {
                                .field(MULTI_VALUED_FIELD_NAME)
import java.util.Map;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(histo.getName(), equalTo("histo"));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            assertThat(bucket, notNullValue());
        Histogram.Bucket bucket = buckets.get(1);
import org.opensearch.search.aggregations.metrics.Sum;
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
        assertEquals(1, buckets.size());
    }
        long[] extendedValueCounts = new long[valueCounts.length + addedBucketsLeft + addedBucketsRight];
import java.util.HashMap;
public class HistogramIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    static int numValueBuckets, numValuesBuckets;
        assertSearchResponse(r);
        SearchResponse response = client().prepareSearch("idx")
        // Test that a request using a nondeterministic script does not get cached
            );
            assertThat(bucket.getDocCount(), greaterThanOrEqualTo(previousCount));
        indexRandom(true, builders);
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
        assertEquals(0.1, (double) buckets.get(0).getKey(), 0.01d);
        assertThat(histo.getName(), equalTo("histo"));
                .getRequestCache()
        // if offset is >= number of values in original last bucket, that effect is canceled
            });
                client().prepareIndex("empty_bucket_idx")
                .get();
            .addAggregation(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            )
                return;
    }
    }
                .getTotal()
            assertThat(((Number) bucket.getKey()).longValue(), equalTo(key));
                }
            .addAggregation(
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            client().admin()
            .addAggregation(histogram("histo").field("d").interval(0.7).offset(0.05))
import org.opensearch.index.query.QueryBuilders;
            } else if (i < expectedNumberOfBuckets - 1) {
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
            if (bucket1 != bucket2) {
            assertEquals(0, key % interval);
        Histogram histo = response.getAggregations().get("histo");
        builders.add(
                .getTotal()
    }
import java.util.Collection;
            Histogram.Bucket bucket = buckets.get(i);
        bucketProps.put("avg_l", avg);
        List<? extends Bucket> buckets = histo.getBuckets();
        final Set<Long> visited = new HashSet<>();
            assertThat(sum.getValue(), lessThanOrEqualTo(previousSum));
            previousCount = bucket.getDocCount();
                }
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(false)))
            int b = (int) (key / interval);
            equalTo(0L)
            )
            final int bucket = (i + 1) / interval;
            assertThat(bucket, notNullValue());
            if (bucket1 != bucket2) {
            .get();
            client().admin()
        );
    public void testSingleValuedFieldOrderedByTieBreaker() throws Exception {
        }
            )
        assertSearchResponse(response);
    static int interval;
        // constructing the newly expected bucket list
        assertThat(histo.getName(), equalTo("histo"));
        int addedBucketsLeft = randomIntBetween(0, numValueBuckets);
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        final Set<Long> buckets = new HashSet<>();
        r = client().prepareSearch("cache_test_idx")
     * see issue #9634, negative interval in histogram should raise exception
                .getRequestCache()
        assertThat(histo, notNullValue());
        assertSearchResponse(response);
        histo = bucket.getAggregations().get("sub_histo");
    }
            equalTo(1L)
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        }
        assertEquals(2, buckets.size());
                )
                .setRequestCache(true)
        System.arraycopy(valueCounts, 0, extendedValueCounts, addedBucketsLeft, valueCounts.length);
            client().prepareIndex("decimal_values").setId("2").setSource("d", 0.1)
        return Collections.singleton(CustomScriptPlugin.class);
                    .interval(interval)
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
            .setSize(0)
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
 * Licensed to Elasticsearch under one or more contributor
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).offset(offset))
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME).hardBounds(new DoubleBounds(3.0, null)).extendedBounds(0, 20)
                    )
            )
        assertThat(
            addedBucketsLeft = 0;
                    .interval(0.7)
            long key = ((Number) bucket.getKey()).longValue();
                            .field("constant", 1)
        assertThat(((Number) bucket.getKey()).longValue(), equalTo(-5L));
            ++counts[(i + 2) / interval];
            int key = ((2 / interval) + i) * interval;
                        jsonBuilder().startObject()
        assertThat(histo.getName(), equalTo("histo"));
 * specific language governing permissions and limitations
            client().prepareIndex("cache_test_idx").setId("2").setSource("d", 0.1)
                .indices()
        int bucketsCount = (int) ((boundsMaxKey - boundsMinKey) / interval) + 1;
                .indices()
            Histogram.Bucket bucket = buckets.get(i);
                    .interval(interval)
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
                .prepareStats("cache_test_idx")
        assertThat(bucket, notNullValue());
                // expected
            Histogram.Bucket bucket = histoBuckets.get(i);
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())
        Histogram histo = response.getAggregations().get("histo");
    }
    public void testEmptyAggregation() throws Exception {
                    assertThat(aggException.getMessage(), Matchers.startsWith("Invalid aggregation order path"));
        assertThat(histo.getBuckets().size(), equalTo(expectedNumberOfBuckets));
        assertThat(histo, notNullValue());
            assertThat(sum, notNullValue());
        for (int i = 2; i < numValueBuckets + 2; ++i) {
            equalTo(2L)
        assertThat(
        }
        List<? extends Bucket> buckets = histo.getBuckets();
    }
        for (int i = 0; i < numValueBuckets; ++i) {
import org.opensearch.search.aggregations.AggregationExecutionException;
                    .interval(interval)
        Map<String, Object> bucketProps = new HashMap<>();
            final int bucket2 = (i + 2) / interval;
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        return Arrays.asList(
                valuesCounts[bucket2]++;
            assertThat(bucket.getDocCount(), equalTo(filter.getDocCount()));
        // randomizing the number of buckets on the min bound
        }
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        final int numBuckets = (numDocs + 1) / interval - 2 / interval + 1;
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(0.0, null)))
                client().prepareIndex("sort_idx")
        List<? extends Bucket> buckets = histo.getBuckets();
        Histogram.Bucket bucket = histo.getBuckets().get(0);
        // error
            Sum sum = bucket.getAggregations().get("sum");
        }
        double prevMax = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            Sum sum = bucket.getAggregations().get("sum_d");
        assertThat(histo, notNullValue());
        int docsCounted = 0;
            )
                        .subAggregation(
/*
            client().prepareIndex("test").setId("1").setSource("d", -0.6),
                return;
        assertThat(e.toString(), containsString("Extended bounds have to be inside hard bounds, hard bounds"));
            assertThat(((Number) bucket.getKey()).longValue(), equalTo(key));
        Histogram histo = response.getAggregations().get("histo");
            long key = ((Number) bucket.getKey()).longValue();
        Histogram histo = response.getAggregations().get("histo");
            Histogram.Bucket bucket = buckets.get(i);
            .get();
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
            builders.add(
        assertThat(buckets.size(), equalTo(numValueBuckets + 3));
            assertThat(bucket, notNullValue());
            final int bucket2 = (i + 3) / interval;
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME).hardBounds(new DoubleBounds(0.0, 10.0)).extendedBounds(3, 20)
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        assertEquals(5, buckets.size());
    public void testsingleValuedFieldOrderedByKeyDesc() throws Exception {
            .setSize(0)
 * You may obtain a copy of the License at
        } catch (IllegalArgumentException e) {
            .addAggregation(
        for (int i = 0; i < expectedNumberOfBuckets; ++i) {
import java.io.IOException;
        boolean asc = randomBoolean();
     * Make sure that a request using a deterministic script or not using a script get cached.
                    .interval(interval)
            }
            Histogram.Bucket bucket = buckets.get(i);
            .get();
        assertThat(histo, notNullValue());
            long s = 0;
            assertThat(filter, notNullValue());
            assertThat(bucket, notNullValue());
            .get();
            assertThat(bucket, notNullValue());
            true,
            long key = ((Number) bucket.getKey()).longValue();
                .indices()
            equalTo(0L)
 *
                if ((j + 1) / interval == b) {
    }
            }
import static org.hamcrest.Matchers.containsString;
        for (Histogram.Bucket bucket : histogram.getBuckets()) {
 * software distributed under the License is distributed on an
            SearchPhaseExecutionException.class,
            )
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            SearchPhaseExecutionException.class,
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {
            client().prepareSearch("empty_bucket_idx")
            client().prepareSearch("idx")
                .setRequestCache(true)
        indexRandom(
    }
        }
                .addAggregation(
        if (frequently()) {
        internalCluster().wipeIndices("test");
            builders.add(
            .get();
                )
        assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) -1 * 2 * interval));
        assertThat(histo.getName(), equalTo("histo"));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyAsc() throws Exception {
import org.opensearch.plugins.Plugin;
        }
        assertThat(buckets.size(), equalTo(numValueBuckets));
        Histogram histo = response.getAggregations().get("histo");
        List<? extends Bucket> buckets = histo.getBuckets();
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
        int addedBucketsLeft = randomIntBetween(0, numValueBuckets);
        r = client().prepareSearch("cache_test_idx")
        List<? extends Bucket> buckets = histo.getBuckets();
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())
    }
        final Set<Long> visited = new HashSet<>();
        }
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
            client().prepareIndex("sort_idx")
        List<IndexRequestBuilder> builders = new ArrayList<>();
import org.opensearch.action.search.SearchPhaseExecutionException;
                .get()
            bucket = buckets.get(i);
            assertThat(bucket, notNullValue());
    }
                    .interval(interval)
                .get()
        if (frequently()) {
        double previousSum = Double.POSITIVE_INFINITY;
        List<Histogram.Bucket> histoBuckets = new ArrayList<>(histo.getBuckets());
        addExpectedBucket(6, 1, 5, 1);
        Histogram histo = response.getAggregations().get("histo");
        assertThat(bucket.getDocCount(), equalTo(0L));
        List<? extends Bucket> buckets = histo.getBuckets();
                .prepareStats("cache_test_idx")
            assertThat(bucket, notNullValue());
    @Override
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
        assertThat(histo.getName(), equalTo("histo"));
        internalCluster().wipeIndices("decimal_values");
        assertEquals(0.1, (double) buckets.get(0).getKey(), 0.01d);
                    s += j + 1;
        assertAcked(client().admin().indices().prepareCreate("sort_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=double").get());
