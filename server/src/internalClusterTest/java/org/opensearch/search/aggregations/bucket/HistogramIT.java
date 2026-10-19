            .addAggregation(histogram("histo").field("d").interval(0.7).offset(0.05))  
            Histogram.Bucket bucket = buckets.get(i);
            assertThat(sum, notNullValue());
import java.util.HashSet;  
        return Arrays.asList(
        internalCluster().wipeIndices("cache_test_idx");  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
            client().prepareIndex("sort_idx")
import org.opensearch.search.aggregations.bucket.histogram.DoubleBounds;
            });
            int b = (int) (key / interval);  
        assertThat(
                .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(-1).minDocCount(0))
        List<? extends Bucket> buckets = histo.getBuckets();
            equalTo(0L)
        } else {
        expectedMultiSortBuckets = new HashMap<>();  
        // first bucket should start at -5, contain 4 documents
    }  
        double previousSum = Double.POSITIVE_INFINITY;
    private void addExpectedBucket(long key, long docCount, double avg, double sum) {
            client().prepareIndex("sort_idx")
                            .field("constant", 1)  
        createIndex("idx");  
                .getRequestCache()  
                .getHitCount(),
        long[] expectedKeys = new long[] { 1, 2, 4, 3, 7, 6, 5 };
                .setQuery(QueryBuilders.termQuery("foo", "bar"))  
        final long[] counts = new long[(numDocs + 1) / interval + 1];
        for (int i = 0; i < numValueBuckets; ++i) {
                    .setSource(
            Histogram.Bucket bucket = buckets.get(i);
        List<? extends Bucket> buckets = histo.getBuckets();
        long previousCount = Long.MIN_VALUE;
import java.util.Collections;
        double prevMax = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                .indices()  
        int docsCounted = 0;
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        Histogram histo = response.getAggregations().get("histo");
        assertThat(
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            .get();
        assertThat(histo, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));  
                long expectedFirstBucketCount = offset - 1;
        Histogram histo = response.getAggregations().get("histo");
            assertThat(sum.getValue(), equalTo((double) s));
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
        assertSearchResponse(response);  
        // (can sometimes fall within the data range, but more frequently will fall before the data range)
        assertSearchResponse(response);  
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) key));
        assertThat(histo.getBuckets().size(), equalTo(0));
        }
 * not use this file except in compliance with the License.
            final int bucket1 = (i + 1) / interval;
                }  
            SearchPhaseExecutionException.class,
    }
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(histo, Matchers.notNullValue());
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(histo.getName(), equalTo("histo"));
 * ownership. Elasticsearch licenses this file to you under  
    public void testHardBounds() throws Exception {
        SearchResponse response = client().prepareSearch("idx")  
            .get();
                }
        long[] expectedKeys = new long[] { 6, 7, 3, 5, 4, 1, 2 };  
                docsCounted += expectedFirstBucketCount;
        }
                .getHitCount(),  
        int offset = 5;
            equalTo(0L)
        // Test that a request using a nondeterministic script does not get cached  
    public void testDecimalIntervalAndOffset() throws Exception {  
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        SearchResponse r = client().prepareSearch("test")
                return doc.get(SINGLE_VALUED_FIELD_NAME);
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));  
        assertSearchResponse(r);  
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
        SearchPhaseExecutionException e = expectThrows(
        assertThat(buckets.size(), equalTo(numValueBuckets));
                throw e;
            response = client().prepareSearch("idx")
            Histogram.Bucket bucket = buckets.get(i);  
                .get();
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i - 2]));  
                    .interval(interval)  
            int b = (int) (key / interval);
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
            addedBucketsLeft = 0;
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(bucket, notNullValue());
        super(staticSettings);
            client().prepareIndex("sort_idx")  
        // last bucket should have (numDocs % interval + 1) docs
        assertThat(buckets.size(), equalTo(numValuesBuckets));  
            )
            assertThat(bucket, notNullValue());
        // Ensure that non-scripted requests are cached as normal
            client().prepareIndex("sort_idx")
                .setRequestCache(true)
        assertThat(histo.getName(), equalTo("histo"));  
        Histogram histo = response.getAggregations().get("histo");  
            i++;
import static org.hamcrest.Matchers.equalTo;
        SearchResponse response = client().prepareSearch("idx")  
            Histogram.Bucket bucket = buckets.get(i);
        int addedBucketsLeft = randomIntBetween(0, numValueBuckets);
import java.util.HashMap;
        SearchResponse response = client().prepareSearch("idx")  
                    .interval(interval)  
        builders.add(
        r = client().prepareSearch("test")
        assertSearchResponse(r);  
        boolean invalidBoundsError = boundsMin > boundsMax;
        }
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };  
        assertEquals(-0.65, (double) buckets.get(0).getKey(), 0.01d);
            assertThat(bucket, notNullValue());
                )
        }
                        .order(BucketOrder.aggregation("inner_histo>avg", asc))  
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
            assertThat(bucket, notNullValue());
        final Set<Long> visited = new HashSet<>();
            prevMax = max.getValue();
                )  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
    public void testPartiallyUnmapped() throws Exception {
import org.opensearch.action.search.SearchResponse;
            }  
    public void testMultiValuedFieldWithValueScript() throws Exception {  
        assertThat(histo, notNullValue());  
        SearchResponse r = client().prepareSearch("cache_test_idx")
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationDesc() throws Exception {
        int addedBucketsRight = randomIntBetween(0, numValueBuckets);  
            assertThat(bucket, notNullValue());
            .addAggregation(  
                .get()
        assertThat(buckets.size(), equalTo(numBuckets));
            .addAggregation(histogram("histo").field(MULTI_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(false)))
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
import java.util.ArrayList;
        assertThat(histo.getBuckets().size(), equalTo(expectedNumberOfBuckets));  
                .getTotal()
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
        // randomizing the number of buckets on the min bound
            if (bucket1 != bucket2) {
 */
     * see issue #9634, negative interval in histogram should raise exception
        assertThat(buckets.size(), equalTo(bucketsCount));
                return doc.get(MULTI_VALUED_FIELD_NAME);  
        }
        for (int i = 0; i < numValueBuckets; ++i) {  
            assertThat(bucket.getDocCount(), greaterThanOrEqualTo(previousCount));  
    }  
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        for (int i = 0; i < numDocs; i++) {
    }
            .get();
            Sum sum = bucket.getAggregations().get("sum");  
        assertThat(histo, notNullValue());  
        assertThat(bucket, notNullValue());
                        jsonBuilder().startObject()
        // if offset is >= number of values in original last bucket, that effect is canceled
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertSearchResponse(response);
        assertThat(buckets.size(), equalTo(numValueBuckets + 3));
        );  
        for (int i = 0; i < expectedNumberOfBuckets; ++i) {
    }  
        final int numBuckets = (numDocs + 1) / interval - 2 / interval + 1;  
        e = expectThrows(  
            builders.add(
        Histogram histo = response.getAggregations().get("histo");
        );  
                        .interval(interval)
            OpenSearchException[] rootCauses = e.guessRootCauses();
            scripts.put("doc['l_value'].value", vars -> {
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            assertThat(bucket, notNullValue());
    public void testMultiValuedField() throws Exception {  
            assertThat(bucket, notNullValue());
                            .endObject()
import java.util.Map;
                        .extendedBounds(boundsMin, boundsMax)
/*  
                .getRequestCache()
        }
                // first bucket
        Histogram histo = searchResponse.getAggregations().get("histo");
            assertTrue(buckets.add(key));
                .getMissCount(),
        assertSearchResponse(response);  
        );  
            )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }  
        assertThat(histo.getName(), equalTo("histo"));
    }
        assertThat(buckets.size(), equalTo(numValueBuckets));  
        assertSearchResponse(response);  
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(true)))
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())
        }  
        Histogram histo = response.getAggregations().get("histo");  
            client().admin()
            valuesCounts[bucket1]++;  
        }
    public void testSingleValuedFieldOrderedByTieBreaker() throws Exception {  
            builders.add(
                .getTotal()  
            assertThat(bucket, notNullValue());  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            client().prepareIndex("sort_idx")  
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
        long boundsMax = boundsMaxKey + randomIntBetween(0, interval - 1);  
        } else {
            long key = ((Number) bucket.getKey()).longValue();
        assertEquals(-0.6, (double) buckets.get(0).getKey(), 0.01d);  
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };  
import org.opensearch.search.aggregations.AggregationExecutionException;  
        assertThat(histo.getName(), equalTo("histo"));  
            previousSum = s;
        } catch (IllegalArgumentException e) {
                .getHitCount(),
    }
        Histogram histo = response.getAggregations().get("histo");  
            }
        }
        assertThat(histo.getName(), equalTo("histo"));
                .prepareStats("cache_test_idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
                .get()
@OpenSearchIntegTestCase.SuiteScopeTestCase
        } catch (SearchPhaseExecutionException e) {  
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
    }  
        final Set<Long> visited = new HashSet<>();
            assertThat(max.getValue(), asc ? greaterThanOrEqualTo(prevMax) : lessThanOrEqualTo(prevMax));
            assertThat(bucket.getDocCount(), equalTo(0L));
            client().prepareIndex("test").setId("2").setSource("d", 0.5),
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");  
                    .offset(0.05)  
                    .subAggregation(max("max_constant").field("constant"))  
            }
        // randomizing the number of buckets on the min bound
 *
            .addAggregation(  
            BucketOrder.count(false),
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
                .addAggregation(
            assertThat(sum.getValue(), equalTo((double) s));
            }
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(e.toString(), containsString("Extended bounds have to be inside hard bounds, hard bounds"));
            final int bucket2 = (i + 3) / interval;  
            if (invalidBoundsError) {  
        List<? extends Bucket> buckets = histo.getBuckets();
    }
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
                    assertThat(aggException.getMessage(), Matchers.startsWith("Invalid aggregation order path"));  
    }
        assertEquals(1, buckets.get(0).getDocCount());
        assertThat(buckets.size(), equalTo(numBuckets));
                    .interval(interval)
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            final int bucket1 = (i + 2) / interval;
        assertThat(bucket, notNullValue());
            )
                return;  
            builders.add(  
            .get();
    @Override
        try {
 *  
        long key = boundsMinKey;  
        int interval1 = 10;
        assertThat(bucket, notNullValue());
        assertSearchResponse(r);
        Histogram histo = response.getAggregations().get("histo");
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                histogram("histo").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['l_value'].value", emptyMap()))
        double previousSum = Double.POSITIVE_INFINITY;
            assertThat(bucket.getDocCount(), lessThanOrEqualTo(previousCount));  
        addExpectedBucket(6, 1, 5, 1);  
        assertSearchResponse(response);
            assertThat(bucket, notNullValue());
        );
        System.arraycopy(valueCounts, 0, extendedValueCounts, addedBucketsLeft, valueCounts.length);
        // Make sure we are starting with a clear cache  
                    .interval(1L)  
        assertThat(((Number) bucket.getKey()).longValue(), equalTo(numDocs % interval1 + 5L));
                return value + 1L;
        long key = Math.min(boundsMinKey, 0);
            client().prepareIndex("test").setId("3").setSource("d", 0.1)
            .addAggregation(
        }  
                .prepareStats("cache_test_idx")
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
 * this file be licensed under the Apache-2.0 license or a
    public void testScriptSingleValue() throws Exception {
        assertSearchResponse(response);
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        );
        try {  
            }
        assertEquals(2, buckets.size());  
 */  
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
            .get();
        assertThat(histo, notNullValue());
        bucketProps.put("avg_l", avg);  
        assertThat(histo, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
            key += interval;  
        );
            boundsMinKey = -boundsMinKey;  
    }  
                .indices()  
                .get()
                        )
                    .order(BucketOrder.aggregation("stats.sum", false))
                .prepareStats("cache_test_idx")  
                .getTotal()
                .getTotal()  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyDesc() throws Exception {  
        assertThat(histo, notNullValue());
                    .minDocCount(0)
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())
                    s += j + 1;
        }
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
        long[] expectedKeys = new long[] { 6, 7, 3, 4, 5, 1, 2 };
                    .interval(interval)
            assertThat(bucket, notNullValue());
        SearchResponse response = null;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );  
                if ((j + 1) / interval == b) {
            .addAggregation(
}  
    }
        List<IndexRequestBuilder> builders = new ArrayList<>();
                .get();
        assertEquals(1, buckets.size());  
            boundsMaxKeyDelta = -boundsMaxKeyDelta;  
                    .subAggregation(sum("sum_d").field("d"))
        List<Histogram.Bucket> histoBuckets = new ArrayList<>(histo.getBuckets());  
        numValuesBuckets = (numDocs + 1) / interval + 1;
                docsCounted += interval;
        createIndex("idx_unmapped");
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
 * The OpenSearch Contributors require contributions made to  
            long s = 0;
 *
    static long[] valueCounts, valuesCounts;
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).offset(offset))
                .get()
        Histogram.Bucket bucket = buckets.get(1);
            .get();  
        assertThat(buckets.size(), equalTo(numValueBuckets));
import org.opensearch.script.Script;
            equalTo(2L)
        assertThat(histo.getName(), equalTo("histo"));  
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
import java.util.List;
        for (int i = 0; i < numBuckets; i++) {
            assertThat(((Number) bucket.getKey()).longValue(), equalTo(key));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
import org.hamcrest.Matchers;
            .setSize(0)  
            Avg avg = bucket.getAggregations().get("avg_l");
import org.opensearch.search.aggregations.metrics.Stats;  
        assertThat(bucket.getDocCount(), equalTo(0L));
        SearchResponse response = client().prepareSearch("idx_unmapped")
    }
    @Override
        assertThat(((Number) bucket.getKey()).longValue(), equalTo(-5L));
        long boundsMax = boundsMaxKey + randomIntBetween(0, interval - 1);
            Max max = filter.getAggregations().get("max");
    }  
        List<? extends Bucket> buckets = histo.getBuckets();
        );
    }
        List<? extends Bucket> buckets = histo.getBuckets();  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3.8).field("l", 3).field("d", 2).endObject())
                .addAggregation(  
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));  
            .get();
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        assertSearchResponse(response);  
                if ((j + 1) / interval == b) {
                )
        Histogram histogram = r.getAggregations().get("histo");
        assertThat(histo.getName(), equalTo("histo"));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyAsc() throws Exception {
        // error  
            long key = ((Number) bucket.getKey()).longValue();
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
        final int numBuckets = (numDocs + 2) / interval - 2 / interval + 1;
        long boundsMin = boundsMinKey + randomIntBetween(0, interval - 1);
                }  
            .addAggregation(
            assertThat(stats.getSum(), equalTo((double) s));  
import org.opensearch.OpenSearchException;
        }
            equalTo(0L)
            .addAggregation(
                    )
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) (i - 2) * interval));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));
            assertThat(max, Matchers.notNullValue());  
            boundsMinKey = -boundsMinKey;
        return ((Number) bucket.getKey()).longValue();
                .setRequestCache(true)  
import org.opensearch.common.settings.Settings;  
        numDocs = randomIntBetween(6, 20);  
            }
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(0.0, null)))  
 * software distributed under the License is distributed on an
            assertThat(bucket.getDocCount(), equalTo(filter.getDocCount()));
                throw e;
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) key));
                    .interval(interval)
        ensureSearchable();
        assertThat(bucket.getDocCount(), equalTo(0L));  
        SearchResponse response = client().prepareSearch("idx")
        );  
            .setSize(0)
                client().prepareIndex("sort_idx")  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        builders.add(
            Histogram.Bucket bucket = histoBuckets.get(i);  
        assertThat(histo, notNullValue());
            assertThat(propertiesCounts[i], equalTo((double) s));
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(histo.getName(), equalTo("histo"));
            );
                client().prepareIndex("empty_bucket_idx")
                            .field("tag", "tag" + i)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    public HistogramIT(Settings staticSettings) {
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.key(false)))
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));  
            assertThat(stats, notNullValue());
            )
        List<? extends Bucket> buckets = histo.getBuckets();
        for (int i = 0; i < numValuesBuckets; ++i) {
        Histogram histo = response.getAggregations().get("histo");
                    .order(BucketOrder.aggregation("max_constant", randomBoolean()))
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import org.opensearch.search.aggregations.bucket.filter.Filter;  
        valuesCounts = new long[numValuesBuckets];
            client().prepareIndex("decimal_values").setId("1").setSource("d", -0.6),
        int bucketsCount = numValueBuckets + addedBucketsLeft + addedBucketsRight;
     * Special care needs to be taken for expecations on counts in first and last bucket.
import org.opensearch.search.aggregations.metrics.Max;
        assertThat(histo.getName(), equalTo("histo"));
                    .order(BucketOrder.aggregation("sum", true))
            .addAggregation(
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(((InternalAggregation) histo).getProperty("_bucket_count"), equalTo(numValueBuckets));
            assertThat(stats.getSum(), lessThanOrEqualTo(previousSum));
                    .interval(1)
    }  
            } else {
        for (int i = 0; i < bucketsCount; i++) {
            BucketOrder.aggregation("sum_d", false),  
            client().prepareIndex("cache_test_idx").setId("1").setSource("d", -0.6),
        if (frequently()) {
        );
            )
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
import static org.hamcrest.Matchers.is;  
                .get()  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", emptyMap()))
        );  
        Map<String, Object> bucketProps = new HashMap<>();  
        }
import java.util.Set;  
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
import java.util.Arrays;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
            assertEquals(0, key % interval);  
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(sum, notNullValue());  
        addExpectedBucket(2, 3, 2, 6);
        assertThat(histo.getName(), equalTo("sub_histo"));  
                        .subAggregation(
            client().prepareIndex("sort_idx")
                // expected
        }  
    }
        getMultiSortDocs(builders);  
        long boundsMinKey = addedBucketsLeft * interval;
        builders.add(
                        .interval(interval)  
        long boundsMaxKey = lastDataBucketKey + boundsMaxKeyDelta;  
    public void testSingleValuedFieldWithValueScript() throws Exception {
        @Override
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo, notNullValue());  
     * Shift buckets by random offset between [2..interval]. From setup we have 1 doc per values from 1..numdocs.
            assertThat(bucket, notNullValue());  
                ++counts[bucket2];  
        r = client().prepareSearch("cache_test_idx")  
        assertSearchResponse(response);
        }  
                .get();
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
            Histogram.Bucket bucket = buckets.get(i);
            long key = ((Number) bucket.getKey()).longValue();
        }
        Histogram histo = response.getAggregations().get("histo");
        }
        );
            return scripts;  
    public void testSingleValuedFieldOrderedByCountDesc() throws Exception {
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
                    .interval(interval)  
            true,
        assertThat(  
                .setRequestCache(true)
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {  
            equalTo(0L)  
            if (rootCauses.length == 1) {
            for (int j = 0; j < numDocs; ++j) {  
    }
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));  
        );
        assertAcked(client().admin().indices().prepareCreate("sort_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=double").get());  
        assertThat(histo.getName(), equalTo("histo"));
    public void testSingleValuedFieldOrderedByKeyAsc() throws Exception {
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
    public void singleValuedField_withOffset() throws Exception {  
            assertThat(bucket, notNullValue());
     */  
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));  
        assertThat(
                .indices()
        SearchResponse response = client().prepareSearch("idx")
    public void testEmptyAggregation() throws Exception {
                assertThat(bucket.getDocCount(), equalTo((long) interval));  
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(null, 0.0)))
            true,
    }  
        assertThat(histo.getName(), equalTo("histo"));
        assertSearchResponse(response);
                            .value(i + 2)  
                .indices()
        Histogram histo = response.getAggregations().get("histo");
        }
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5.1).field("l", 5).field("d", 2).endObject())  
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
                .prepareStats("cache_test_idx")
            .get();
        r = client().prepareSearch("test")
        }
                            histogram("inner_histo").interval(interval)
        }
        List<? extends Bucket> buckets = histogram.getBuckets();
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4.4).field("l", 3).field("d", 3).endObject())
        Histogram histo = response.getAggregations().get("histo");  
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.count(true)))
        List<? extends Bucket> buckets = histo.getBuckets();  
            assertThat(sum.getValue(), lessThanOrEqualTo(previousSum));  
            if (bucket1 != bucket2) {
                .getTotal()
        for (int i = 0; i < numValueBuckets; ++i) {  
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
    /**  
        builders.add(
        assertThat(histo.getName(), equalTo("histo"));  
    }
        final Set<Long> buckets = new HashSet<>();
            long key = ((Number) bucket.getKey()).longValue();  
        assertThat(histo, notNullValue());  
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
    public void testUnmapped() throws Exception {
        for (int i = 0; i < numDocs; i++) {
            } else {
        indexRandom(true, builders);
                .get()
            assertThat(bucket, notNullValue());  
        for (int i = 0; i < bucketsCount; i++) {
        addExpectedBucket(1, 3, 1, 6);
    /**
        assertAcked(prepareCreate("test").setMapping("d", "type=double").get());  
        );
import org.opensearch.search.aggregations.InternalAggregation;
    }
        int i = 0;  
                    .order(BucketOrder.aggregation("sum", false))
        );
        );
import java.util.Collection;  
        assertSearchResponse(response);
            } else {
            for (int j = 0; j < numDocs; ++j) {
        }
            ++counts[bucket1];
    public void testSingleValuedFieldOrderedBySubAggregationDescDeepOrderPath() throws Exception {  
                    .subAggregation(avg("avg_l").field("l"))  
                    .subAggregation(histogram("sub_histo").field(SINGLE_VALUED_FIELD_NAME).interval(1L))
        final Set<Long> visited = new HashSet<>();  
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            long s = 0;
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.metrics.Sum;
        // constructing the newly expected bucket list  
            assertThat(filter, notNullValue());  
        SearchResponse response = client().prepareSearch("sort_idx")
        assertThat(histo, notNullValue());
        for (Histogram.Bucket bucket : histogram.getBuckets()) {
        List<? extends Bucket> buckets = histogram.getBuckets();
                .getMissCount(),  
        long boundsMin = boundsMinKey + randomIntBetween(0, interval - 1);
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).order(BucketOrder.count(false)))
        );
        assertThat(histo, notNullValue());
                .addAggregation(
        assertThat(
        );
            valueCounts[bucket]++;
        assertThat(histo, notNullValue());
        assertThat(histogram, notNullValue());
        valueCounts = new long[numValueBuckets];
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))  
            assertThat(sum, notNullValue());
            )  
    /**
        for (int i = 0; i < numValueBuckets; ++i) {
            Histogram.Bucket bucket = buckets.get(i);  
            )  
            Histogram.Bucket bucket = buckets.get(i);
        assertEquals(0.1, (double) buckets.get(0).getKey(), 0.01d);
                )  
        assertThat(histo, notNullValue());
                throw e;
            .get();
        Histogram histogram = response.getAggregations().get("histo");
    public void testSingleValuedFieldOrderedByCountAsc() throws Exception {
            )  
        assertSearchResponse(response);
        assertEquals(0.5, (double) buckets.get(4).getKey(), 0.01d);
        assertThat(histo, notNullValue());
                .indices()
            .get();  
        int bucketsCount = (int) ((boundsMaxKey - boundsMinKey) / interval) + 1;
            .addAggregation(histogram("histo").field("d").interval(0.1).hardBounds(new DoubleBounds(0.0, 0.3)))  
                )
            assertThat(bucket, notNullValue());
                            .startArray(MULTI_VALUED_FIELD_NAME)
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
                client().prepareIndex("sort_idx")
    }
            Histogram.Bucket bucket = buckets.get(numValueBuckets - i - 1);
            client().admin()
    }  
        }
                .getRequestCache()  
                if (rootCause instanceof AggregationExecutionException) {
        boolean invalidBoundsError = boundsMin > boundsMax;
        assertThat(e.toString(), containsString("Extended bounds have to be inside hard bounds, hard bounds"));
            client().prepareIndex("sort_idx")  
        assertSearchResponse(response);
                assertThat(bucket.getDocCount(), equalTo((long) numDocs - docsCounted));  
        assertThat(bucket, notNullValue());
        return Collections.singleton(CustomScriptPlugin.class);  
        );
            for (int j = 0; j < numDocs; ++j) {
        bucketProps.put("sum_d", sum);
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        }
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
    }  
        addExpectedBucket(4, 2, 3, 4);
            .addAggregation(
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());  
        long boundsMaxKeyDelta = addedBucketsRight * interval;
        assertThat(buckets.size(), equalTo(bucketsCount));
    }
        long previousCount = Long.MAX_VALUE;
    static Map<Long, Map<String, Object>> expectedMultiSortBuckets;
package org.opensearch.search.aggregations.bucket;
            fail("Expected an exception");
            )
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) ((i - 1) * interval + offset)));
 * GitHub history for details.
            }
        List<Histogram.Bucket> histoBuckets = new ArrayList<>(histo.getBuckets());  
        for (int i = 0; i < numValueBuckets; ++i) {
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(histogram.getBuckets().size(), equalTo(expectedKeys.length));
        for (int i = 0; i < numDocs; ++i) {
            });
        }
        int lastDataBucketKey = (numValueBuckets - 1) * interval;  
        for (int i = 0; i < numBuckets; i++) {  
                    .order(BucketOrder.compound(order))
        for (int i = 0; i < numDocs; i++) {  
            assertEquals(propertiesKeys[i], (double) i * interval);
        }  
            for (int j = 0; j < numDocs; ++j) {  
        assertThat(histo.getBuckets().isEmpty(), is(true));
        SearchResponse response = client().prepareSearch("idx")
            }  
            .get();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        // constructing the newly expected bucket list
    }  
        buckets = histogram.getBuckets();
            boundsMaxKeyDelta = -boundsMaxKeyDelta;
        assertThat(histo.getName(), equalTo("histo"));
    }
        boolean asc = randomBoolean();
        for (int i = 0; i < numValueBuckets; ++i) {  
            }
        assertSearchResponse(response);  
                histogram("histo").field(MULTI_VALUED_FIELD_NAME)  
            assertThat(sum.getValue(), greaterThanOrEqualTo(previousSum));  
                    s += j + 1;
                                .subAggregation(avg("avg").field("value"))
        assertSearchResponse(response);
                Map<?, ?> doc = (Map) vars.get("doc");  
                .getRequestCache()
                .getRequestCache()
                if ((j + 1) / interval == i) {  
            client().prepareSearch("idx")
                    throw e;
        assertEquals(5, buckets.size());  
        );
        } catch (IllegalArgumentException e) {  
            equalTo(1L)
        } catch (IllegalArgumentException e) {
        List<? extends Bucket> buckets = histo.getBuckets();  
                // expected
                return;
import org.opensearch.index.query.QueryBuilders;
        // error
            .addAggregation(histogram("histo").field(MULTI_VALUED_FIELD_NAME).interval(interval))
/*
        // randomizing the number of buckets on the max bound  
                .get();
        final long[] counts = new long[(numDocs + 2) / interval + 1];  
    }  
    public void testInvalidBounds() {
            addedBucketsRight = 0;
                } else {
        long[] extendedValueCounts = new long[bucketsCount];
 * SPDX-License-Identifier: Apache-2.0
        assertThat(histo, notNullValue());
                    .order(BucketOrder.aggregation("filter>max", asc))  
            } else {  
            Histogram.Bucket bucket = histoBuckets.get(i);  
    }  
        int expectedNumberOfBuckets = (offset >= (numDocs % interval + 1)) ? numValueBuckets : numValueBuckets + 1;  
            SearchPhaseExecutionException.class,  
                Map<?, ?> doc = (Map) vars.get("doc");
            client().admin()
        assertThat(histo.getBuckets().size(), equalTo(numValuesBuckets));
import org.opensearch.script.ScriptType;
 * You may obtain a copy of the License at  
        try {
            bucket = buckets.get(i);  
            .get();
            Sum sum = bucket.getAggregations().get("sum");  
            int key = ((2 / interval) + i) * interval;
        assertThat(histo, notNullValue());  
            fail();  
            .addAggregation(  
        // randomizing the number of buckets on the max bound
        assertSearchResponse(response);
        indexRandom(  
    public void setupSuiteScopeCluster() throws Exception {
            true,  
            scripts.put("_value + 1", vars -> {  
        assertThat(histo.getBuckets().size(), equalTo(expectedNumberOfBuckets));
            assertThat(bucket, notNullValue());
            equalTo(0L)  
            int key = ((2 / interval) + i) * interval;  
            if (invalidBoundsError) {  
            assertThat(bucket, notNullValue());  
public class HistogramIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        builders.add(  
            );  
        }
            Histogram.Bucket bucket = buckets.get(numValuesBuckets - i - 1);
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
    }
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            long s = 0;
            final int bucket2 = (i + 2) / interval;
                assertThat(bucket.getDocCount(), equalTo(expectedFirstBucketCount));  
            .get();  
            });  
        assertSearchResponse(response);
        int expectedNumberOfBuckets = (offset >= (numDocs % interval + 1)) ? numValueBuckets : numValueBuckets + 1;
            );  
        assertThat(histo, notNullValue());
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        SearchResponse response = client().prepareSearch("idx")  
            } else if (i < expectedNumberOfBuckets - 1) {
            client().admin()  
        assertThat(
        histogram = r.getAggregations().get("histo");
        if (rarely()) {
        buckets = histogram.getBuckets();
                .getMissCount(),
        if (rarely()) {
        }
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())  
            assertThat(bucket, notNullValue());
        for (int i = 0; i < numValueBuckets; ++i) {
        long[] extendedValueCounts = new long[valueCounts.length + addedBucketsLeft + addedBucketsRight];  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", emptyMap()))
        Histogram histo = response.getAggregations().get("histo");
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
        interval = randomIntBetween(2, 5);
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());  
        }
            Histogram.Bucket bucket = histo.getBuckets().get(i);  
                if ((j + 1) / interval == b) {
            assertEquals(0, key % interval);  
     */
     * Make sure that a request using a deterministic script or not using a script get cached.  
        for (int i = 1; i <= 3; i++) {
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
                .prepareStats("cache_test_idx")  
        assertEquals(1, buckets.size());
    public void testScriptMultiValued() throws Exception {
                    .interval(interval)  
                    .interval(0.7)  
        final Set<Long> visited = new HashSet<>();
                .getHitCount(),
        assertThat(bucket.getDocCount(), equalTo((numDocs % interval) + 1L));  
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
import static org.hamcrest.Matchers.containsString;  
            Histogram.Bucket bucket = buckets.get(i);  
            Histogram.Bucket bucket = buckets.get(i);
                .indices()
        System.arraycopy(valueCounts, 0, extendedValueCounts, addedBucketsLeft, valueCounts.length);  
            equalTo(0L)
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertTrue(buckets.add(key));
                .getRequestCache()
        Histogram histo = response.getAggregations().get("histo");
            .get();
                            .field(SINGLE_VALUED_FIELD_NAME, i + 1)  
     * Ensure requests using nondeterministic scripts do not get cached.
        for (int i = 0; i < numValuesBuckets; ++i) {
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
                histogram("histo").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['l_values']", emptyMap()))
    }  
            assertThat(bucket, notNullValue());  
            assertThat(bucket.getDocCount(), equalTo(counts[key / interval]));  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo.getName(), equalTo("histo"));
import org.opensearch.test.OpenSearchIntegTestCase;
            client().prepareSearch("empty_bucket_idx")  
        assertSearchResponse(response);
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval))
     */  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
        indexRandom(
        assertSearchResponse(r);
            builders.add(
            BucketOrder.aggregation("avg_l", false)
            .addAggregation(  
                .getRequestCache()
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
            long s = 0;  
 * license agreements. See the NOTICE file distributed with
                .prepareStats("cache_test_idx")
        Histogram histo = response.getAggregations().get("histo");
            .get();
                    .setId("" + i)  
    private void assertMultiSortResponse(long[] expectedKeys, BucketOrder... order) {  
        Histogram histo = response.getAggregations().get("histo");  
    static int numDocs;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
            previousCount = bucket.getDocCount();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
    public void testSingleValuedFieldWithRandomOffset() throws Exception {
 * specific language governing permissions and limitations
        );  
            .get();  
            if (invalidBoundsError) {
                    s += j + 1;
 * this work for additional information regarding copyright
        assertThat(histo.getName(), equalTo("histo"));
            scripts.put("Math.random()", vars -> HistogramIT.randomDouble());
            long key = ((Number) bucket.getKey()).longValue();
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
    public void testScriptCaching() throws Exception {  
            long key = ((Number) bucket.getKey()).longValue();
                return;
            .get();  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        // shifting by offset>2 creates new extra bucket [0,offset-1]
        Histogram histo = response.getAggregations().get("histo");  
        assertThat(histo, notNullValue());
        assertThat(histo, notNullValue());
        }  
            .get();  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndKeyAsc() throws Exception {
            Stats stats = bucket.getAggregations().get("stats");
                .get()
            assertThat(key(bucket), equalTo(expectedKeys[i]));  
        );
            .addAggregation(histogram("histo").field("d").interval(0.7).offset(0.05))
            Sum sum = bucket.getAggregations().get("sum_d");
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            }  
                        .minDocCount(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")  
    public void testSingleValuedFieldOrderedBySubAggregationDesc() throws Exception {
        indexRandom(
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())
        try {
        assertThat(
        assertSearchResponse(response);
            assertThat(bucket.getDocCount(), equalTo(counts[key / interval]));
                .indices()
    }  
        assertThat(histo.getName(), equalTo("histo"));
        r = client().prepareSearch("cache_test_idx")
    public void testExeptionOnNegativerInterval() {
    public void testSingleValuedFieldWithExtendedBounds() throws Exception {
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME).hardBounds(new DoubleBounds(3.0, null)).extendedBounds(0, 20)
        assertEquals(0.1, (double) buckets.get(0).getKey(), 0.01d);
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            client().admin()
                client().prepareIndex("idx")  
            Histogram.Bucket bucket = buckets.get(i);
                    .interval(interval)  
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        long[] expectedKeys = new long[] { 5, 6, 7, 3, 4, 2, 1 };
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));  
            )  
        }
                }
    }
            .get();  
        histogram = r.getAggregations().get("histo");  
        for (int i = 0; i < 2; i++) {  
    }
        numValueBuckets = numDocs / interval + 1;  
            .setSize(0)
            assertThat(bucket, notNullValue());  
import org.opensearch.action.search.SearchPhaseExecutionException;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
import org.opensearch.search.aggregations.metrics.Avg;
        }  
            Sum sum = bucket.getAggregations().get("sum");
 * the Apache License, Version 2.0 (the "License"); you may
        bucketProps.put("key", key);
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
                    .extendedBounds(-1 * 2 * interval, valueCounts.length * interval)
                histogram("histo").field("d")  
        bucket = histo.getBuckets().get(0);  
        assertThat(histo, notNullValue());  
    }  
        }  
        for (int i = 0; i < numValueBuckets; ++i) {
        assertThat(histogram.getName(), equalTo("histo"));  
        long boundsMaxKeyDelta = addedBucketsRight * interval;  
        int addedBucketsLeft = randomIntBetween(0, numValueBuckets);  
    }
        Histogram.Bucket bucket = histo.getBuckets().get(0);  
    public static Collection<Object[]> parameters() {  
        assertEquals(0.05, (double) buckets.get(1).getKey(), 0.01d);  
                .setRequestCache(true)
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        assertThat(  
            .get();
        builders.add(  
    }
            .get();  
        assertThat(histo.getName(), equalTo("histo"));
    }
        bucket = buckets.get(1);  
        Histogram.Bucket bucket = buckets.get(0);
        }
    public void testsingleValuedFieldOrderedByKeyDesc() throws Exception {
                .get()  
import org.opensearch.action.index.IndexRequestBuilder;  
    private long key(Histogram.Bucket bucket) {  
                histogram("histo").field("d")
        assertAcked(prepareCreate("decimal_values").setMapping("d", "type=float").get());
        Histogram histo = response.getAggregations().get("histo");  
import static org.hamcrest.core.IsNull.notNullValue;
            assertThat(e.toString(), containsString("[interval] must be >0 for histogram aggregation [histo]"));
        internalCluster().wipeIndices("decimal_values");
                .setRequestCache(true)  
            }  
            if (i == 0) {  
            assertThat(bucket, notNullValue());
            Filter filter = bucket.getAggregations().get("filter");
        builders.add(
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(histo.getName(), equalTo("histo"));
            Histogram.Bucket bucket = buckets.get(i);  
            key += interval;
        SearchResponse response = null;  
                OpenSearchException rootCause = rootCauses[0];  
                .addAggregation(
            )  
        assertThat(histo.getName(), equalTo("histo"));  
        for (int i = 0; i < numValueBuckets; ++i) {
        assertThat(buckets.size(), equalTo(numValuesBuckets));
                .getTotal()
        assertThat(histo, Matchers.notNullValue());
        assertSearchResponse(response);  
        for (int i = 0; i < numValueBuckets; ++i) {  
                                .field(MULTI_VALUED_FIELD_NAME)  
        long boundsMaxKey = lastDataBucketKey + boundsMaxKeyDelta;
        int addedBucketsRight = randomIntBetween(0, numValueBuckets);
            assertTrue(visited.add(key));  
            assertThat(bucket, notNullValue());  
        SearchResponse response = client().prepareSearch("idx")  
        Histogram histo = response.getAggregations().get("histo");
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {
                    .interval(interval)
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
    }
    }
            assertThat(bucket, notNullValue());
        }
                .setRequestCache(true)
            assertTrue(visited.add(key));
            .get();
        double previousSum = Double.NEGATIVE_INFINITY;
        }  
            .get();
 * KIND, either express or implied.  See the License for the
    public void testMultiValuedFieldOrderedByKeyDesc() throws Exception {  
            )  
            assertTrue(visited.add(key));
        addExpectedBucket(7, 1, 5, 1);
        assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) -1 * 2 * interval));  
            previousSum = s;
        long[] expectedKeys = new long[] { 2, 1, 4, 5, 3, 6, 7 };
        builders.add(  
        }
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
 * under the License.  
            response = client().prepareSearch("idx")
                .setRequestCache(true)
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo, notNullValue());
                        .extendedBounds(boundsMin, boundsMax)  
        assertSearchResponse(r);
                double value = (double) vars.get("_value");
            expectedKeys,
        assertThat(bucket, Matchers.notNullValue());
        SearchResponse r = client().prepareSearch("decimal_values")
            .get();
    public void testSingleValuedField() throws Exception {  
                .prepareStats("cache_test_idx")
                }  
            final int bucket = (i + 1) / interval;  
        Histogram histo = response.getAggregations().get("histo");  
            .addAggregation(  
            )
                        .interval(interval)
        assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) -1 * interval));
        Histogram histo = response.getAggregations().get("histo");
                            .endArray()
            .get();
            client().prepareIndex("cache_test_idx").setId("2").setSource("d", 0.1)  
        assertSearchResponse(response);
                .get()  
        for (int i = 0; i < numValuesBuckets; ++i) {
            .setQuery(matchAllQuery())  
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));  
        // (can sometimes fall within the data range, but more frequently will fall before the data range)  
                .indices()  
        }  
        expectedMultiSortBuckets.put(key, bucketProps);
            addedBucketsRight = 0;  
        assertSearchResponse(response);  
import static java.util.Collections.emptyMap;  
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
        histo = bucket.getAggregations().get("sub_histo");
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));
        // Test that a request using a deterministic script gets cached
            .get();
import org.opensearch.plugins.Plugin;
        addExpectedBucket(3, 2, 3, 3);  
            return scripts;  
 * Unless required by applicable law or agreed to in writing,
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                .getMissCount(),  
        // it could be that the random bounds.min we chose ended up greater than bounds.max - this should cause an  
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());  
            Histogram.Bucket bucket = buckets.get(i);  
    public void testPartiallyUnmappedWithExtendedBounds() throws Exception {
        for (int i = 0; i < numValueBuckets; ++i) {
                .setRequestCache(true)  
            previousSum = s;
            previousCount = bucket.getDocCount();
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                .getRequestCache()  
/*
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
            .get();  
        for (int i = 0; i < numValueBuckets; ++i) {  
            addedBucketsLeft = 0;  
        for (int i = 0; i < numValueBuckets; ++i) {
            assertThat(sum.getValue(), equalTo((double) s));
    @ParametersFactory
        long boundsMinKey = addedBucketsLeft * interval;
            )  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            assertThat(((Number) bucket.getKey()).longValue(), equalTo(key));
            .get();
 */
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                    .offset(0.05)
        for (int i = 2; i < numValueBuckets + 2; ++i) {
                        .minDocCount(0)
        assertThat(bucket.getDocCount(), equalTo(4L));  
        assertSearchResponse(response);
    public void testEmptyWithExtendedBounds() throws Exception {
                    .interval(interval)
            )
            if (invalidBoundsError) {
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        @Override  
import java.io.IOException;  
            int b = (int) (key / interval);  
    }  
        assertSearchResponse(r);
                .get()  
        Histogram histo = response.getAggregations().get("histo");  
            assertThat(bucket.getDocCount(), equalTo(valuesCounts[i]));
        Histogram histo = response.getAggregations().get("histo");
        boolean asc = true;  
import java.util.function.Function;
            }  
            .addAggregation(
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(bucket.getDocCount(), equalTo(valueCounts[(int) (key / interval)]));
        assertThat(histo, notNullValue());
        for (int i = 0; i < numDocs; ++i) {
        assertAcked(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        SearchResponse response = client().prepareSearch("idx")
            client().admin()  
                .getTotal()
        internalCluster().wipeIndices("test");
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(histo.getName(), equalTo("histo"));  
import org.opensearch.script.MockScriptPlugin;  
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                .getTotal()
            scripts.put("doc['l_values']", vars -> {
    }  
    }
            .get();
        int offset = randomIntBetween(2, interval);
        assertThat(histo, notNullValue());  
                    .subAggregation(filter("filter", matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME)))
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
            client().admin()  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        if (frequently()) {  
            .get();
            assertThat(propertiesDocCounts[i], equalTo(valueCounts[i]));  
        int lastDataBucketKey = (numValueBuckets - 1) * interval;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        }
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));  
                .addAggregation(  
            .get();
    static int numValueBuckets, numValuesBuckets;  
        );  
        bucketProps.put("_count", docCount);
        assertThat(histo.getName(), equalTo("histo"));  
                valuesCounts[bucket2]++;
    }  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;  
    static int interval;
            int b = (int) (key / interval);
            .addAggregation(
            assertThat(bucket.getDocCount(), equalTo(valueCounts[b]));
        SearchResponse response = client().prepareSearch("idx")
        final Set<Long> buckets = new HashSet<>();
            assertThat(bucket, notNullValue());
                    .interval(interval)  
                    .interval(0.7)
            assertThat(bucket.getDocCount(), equalTo(valueCounts[(int) (key / interval)]));
        List<? extends Bucket> buckets = histo.getBuckets();  
 * compatible open source license.
    public void testSingleValuedFieldOrderedBySubAggregationAsc() throws Exception {
            () -> client().prepareSearch("empty_bucket_idx")
        assertMultiSortResponse(  
            prepareCreate("cache_test_idx").setMapping("d", "type=float")
        assertThat(histo.getName(), equalTo("histo"));
        assertSearchResponse(r);
        addExpectedBucket(5, 2, 5, 3);
            client().prepareIndex("test").setId("1").setSource("d", -0.6),  
                .get()
            () -> client().prepareSearch("empty_bucket_idx")
    }  
                    s += j + 1;  
        );  
            ++counts[(i + 2) / interval];  
            assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                .prepareStats("cache_test_idx")
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval1).offset(offset))
            client().admin()
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");
    }
            .addAggregation(
        Histogram histo = response.getAggregations().get("histo");
            assertThat(bucket.getDocCount(), equalTo(extendedValueCounts[i]));  
            client().prepareIndex("decimal_values").setId("2").setSource("d", 0.1)
                            .value(i + 1)
            );
        assertThat(histo.getName(), equalTo("histo"));  
        // it could be that the random bounds.min we chose ended up greater than bounds.max - this should cause an
            client().prepareIndex("sort_idx")
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;
        assertThat(histo, notNullValue());
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
        Histogram histogram = r.getAggregations().get("histo");
            assertThat(sum, notNullValue());  
        assertSearchResponse(response);
            assertTrue(visited.add(key));
            assertThat(avg, notNullValue());  
        // from setup we have between 6 and 20 documents, each with value 1 in test field
        assertEquals(1, buckets.get(1).getDocCount());
    }
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME).hardBounds(new DoubleBounds(0.0, 10.0)).extendedBounds(3, 20)  
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
        assertThat(histo.getBuckets().size(), equalTo(numValueBuckets));  
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                return;  
