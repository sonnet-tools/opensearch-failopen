        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
    [4, 5]
import java.util.ArrayList;
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        Map<String, Object> params = new HashMap<>();  
 * license agreements. See the NOTICE file distributed with
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));  
                    .setSource(
        assertThat(  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertSearchResponse(response);
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    }
        assertThat(range.getBuckets().size(), equalTo(4));
 * Unless required by applicable law or agreed to in writing,
        assertThat(bucket, notNullValue());  
    public void testScriptSingleValue() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket, notNullValue());
    }  
                .getMissCount(),
        assertThat(bucket.getFromAsString(), equalTo("4.0"));
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
    }
        Range.Bucket bucket = buckets.get(0);
        for (int i = 5; i < numDocs; ++i) {  
    }  
            .get();  
                .prepareStats("cache_test_idx")  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));  
        assertThat(bucket.getToAsString(), equalTo("3.0"));
 * KIND, either express or implied.  See the License for the
            }
        }
    [7, 8j
     * Ensure requests using nondeterministic scripts do not get cached.  
        assertThat(range, notNullValue());
    public void testEmptyRange() throws Exception {  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
    [10, 11]
        assertThat(bucket.getToAsString(), equalTo("6.0"));  
                .getRequestCache()  
    public void testSingleValuedFieldWithSubAggregation() throws Exception {  
        assertThat(bucket.getToAsString(), nullValue());  
                    .setSource(
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getToAsString(), equalTo("5.0"));  
        List<? extends Range.Bucket> buckets = range.getBuckets();
        sum = bucket.getAggregations().get("sum");  
                    .subAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
    [2, 3]  
        assertThat(propertiesKeys[1], equalTo("3.0-6.0"));  
        assertThat(bucket.getFromAsString(), nullValue());
/*
        Range range = response.getAggregations().get("range");
            .get();
                .getHitCount(),  
            client().admin()  
            }  
        assertThat(bucket.getToAsString(), nullValue());  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        // one, and a concrete field in the other.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        assertThat(bucket.getFromAsString(), nullValue());  
            equalTo(1L)  
        assertThat(buckets.get(0).getFromAsString(), equalTo("0.0"));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
 *
    [5, 6]  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));  
        Range range = response.getAggregations().get("range");  
        SearchResponse response = client().prepareSearch("idx")
                range("foo").field("i")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
    [8, 9]  
            ScriptType.INLINE,  
    [7, 8j  
        assertThat(bucket.getDocCount(), equalTo(3L));  
        assertThat(bucket.getKey(), equalTo("*-50.0"));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(bucket.getKey(), equalTo("*-3.0"));
                .prepareStats("cache_test_idx")  
        assertSearchResponse(response);
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    /*
                .getTotal()  
        assertSearchResponse(response);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));  
        assertThat(bucket.getDocCount(), equalTo(1L)); // 2
        SearchResponse response = client().prepareSearch("idx")
    [9, 10]
import org.opensearch.search.aggregations.InternalAggregation;  
                    .addUnboundedFrom(6)
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getFromAsString(), equalTo("3.0"));  
            .setSize(0)
        assertThat(bucket, notNullValue());  
    public void testPartiallyUnmapped() throws Exception {
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
            builders.add(
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKey(), equalTo("50.0-150.0"));
 * this work for additional information regarding copyright
        Range.Bucket bucket = buckets.get(0);
    @Override  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));  
        );
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getDocCount(), equalTo(2L));
import java.util.Map;
    }
            .addAggregation(
        assertThat(range.getName(), equalTo("range"));  
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(5.0));
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        assertThat(bucket.getKey(), equalTo("*-3.0"));  
            .get();  
import java.util.function.Function;
        assertThat(bucket, notNullValue());
            total += i + 1;
        List<? extends Bucket> buckets = range.getBuckets();
                .indices()
        assertThat(histo, Matchers.notNullValue());  
        bucket = buckets.get(1);  
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(range.getBuckets().size(), equalTo(3));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        bucket = buckets.get(1);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));  
        Range range = response.getAggregations().get("range");
        List<? extends Bucket> buckets = range.getBuckets();
    r3: 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11  
        assertSearchResponse(response);
            } else {
        assertThat(bucket.getToAsString(), equalTo("3.0"));  
        builders.add(client().prepareIndex("new_index").setSource(Collections.emptyMap()));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
    public void setupSuiteScopeCluster() throws Exception {
            client().admin()
        assertThat(bucket.getKey(), equalTo("6.0-*"));
                .indices()
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
        assertThat(sum, notNullValue());
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
        assertThat(range, notNullValue());
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
import static org.opensearch.search.aggregations.AggregationBuilders.range;
        assertThat(bucket.getDocCount(), equalTo(2L));
                .getMissCount(),
                .getHitCount(),  
        Range.Bucket bucket = buckets.get(0);
            .get();
        assertThat(bucket.getFromAsString(), nullValue());
        SearchResponse response = client().prepareSearch("idx")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(sum, notNullValue());
 * Modifications Copyright OpenSearch Contributors. See  
                .getRequestCache()
        assertThat(bucket.getToAsString(), nullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(range, notNullValue());  
import org.opensearch.search.aggregations.metrics.Sum;
                    .addRange(3, 6)  
        assertThat(bucket.getDocCount(), equalTo(4L));
            return scripts;
import org.opensearch.action.search.SearchResponse;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        List<? extends Bucket> buckets = range.getBuckets();  
        assertThat(bucket, notNullValue());  
                range("range").field(SINGLE_VALUED_FIELD_NAME)  
                .setRequestCache(true)
        assertThat(bucket.getKey(), equalTo("*-3.0"));  
        for (int i = 0; i < numDocs; i++) {
/*  
    }
        bucket = buckets.get(2);
        assertThat(buckets.get(0).getKey(), equalTo("0-2"));
                .getTotal()  
            client().prepareIndex("cache_test_idx").setId("1").setSource(jsonBuilder().startObject().field("i", 1).endObject()),
                .prepareStats("cache_test_idx")
        assertThat(bucket, notNullValue());  
            Range.Bucket rangeBucket = buckets.get(0);
        assertThat(sum.getValue(), equalTo(3.0)); // 1 + 2
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(4.0));  
        assertThat(bucket.getKey(), equalTo("6.0-*"));  
        bucket = buckets.get(1);
        assertThat(bucket.getKey(), equalTo("6.0-*"));
import org.opensearch.action.search.SearchPhaseExecutionException;  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
            .get();
        List<? extends Bucket> buckets = range.getBuckets();
    }
        return Collections.singleton(CustomScriptPlugin.class);
        // TODO: use diamond once JI-9019884 is fixed
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .addUnboundedTo(3)
        assertThat(bucket.getToAsString(), equalTo("3.0"));
            .get();  
                .getTotal()  
                .getTotal()
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));  
                .setRequestCache(true)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                .setRequestCache(true)  
            .setSize(0)  
        assertThat(bucket.getFromAsString(), equalTo("4.0"));
        assertThat(bucket.getFromAsString(), nullValue());  
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getToAsString(), equalTo("6"));
    [8, 9]  
            client().admin()
    [6, 7]
        bucket = buckets.get(1);  
    public void testNoRangesInQuery() {
        builders.add(client().prepareIndex("new_index").setSource("route_length_miles", 100.2));
        createIndex("idx_unmapped");
        indexRandom(
    }
        assertThat(bucket, notNullValue());
                .getRequestCache()
                    .addRange(0, 10)
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
                .getRequestCache()
        assertThat(bucket, notNullValue());
}
        List<? extends Bucket> buckets = range.getBuckets();
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        List<? extends Bucket> buckets = range.getBuckets();  
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(bucket.getKey(), equalTo("6.0-*"));  
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(bucket.getToAsString(), equalTo("6.0"));
    public void testMultiValuedFieldWithValueScript() throws Exception {  
        assertThat(bucket.getDocCount(), equalTo(1L));  
        Histogram.Bucket bucket = histo.getBuckets().get(1);
                            // shift sequence by 1, to ensure we have negative values, and value 3 on the edge of the tested ranges  
        List<? extends Bucket> buckets = range.getBuckets();
        bucket = buckets.get(1);
            assertThat(rangeBucket.getToAsString(), equalTo("6.0"));
    public void testSingleValueFieldWithCustomKey() throws Exception {
    }  
    [2, 3]  
        assertThat(bucket, notNullValue());  
     */
        );
    /*
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
            fail();
        bucket = buckets.get(2);
 * not use this file except in compliance with the License.
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getFromAsString(), equalTo("3.0"));  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(bucket, notNullValue());  
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getKey(), equalTo("6.0-*"));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            .addAggregation(
    public static Collection<Object[]> parameters() {
                .prepareStats("cache_test_idx")
        assertThat(
        assertThat(bucket.getKey(), equalTo("*-3.0"));  
    }  
        assertThat(bucket.getKey(), equalTo("150.0-*"));  
    [6, 7]
        assertThat(bucket.getToAsString(), equalTo("6.0"));
    }  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(5.0));
        assertThat(range.getName(), equalTo("range"));  
        assertThat(bucket, notNullValue());
        bucket = buckets.get(2);
            assertThat(rangeBucket.getFromAsString(), equalTo("3.0"));  
        List<? extends Range.Bucket> buckets = range.getBuckets();  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            )
        assertThat(bucket.getFromAsString(), equalTo("6.0"));  
        assertThat(buckets.size(), is(1));  
            assertThat(rangeBucket.getKeyAsString(), equalTo("3.0-6.0"));
        assertThat(bucket.getToAsString(), equalTo("6.0"));  
        bucket = buckets.get(2);  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
    [3, 4]
        assertThat(
        );
        assertThat(bucket.getToAsString(), equalTo("6.0"));
                    .addRange(3, 6)
     * Make sure that a request using a deterministic script or not using a script get cached.
                return value;
        Range range = response.getAggregations().get("range");  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(terms, notNullValue());
    public void testMultiValuedField() throws Exception {  
        assertThat(bucket.getKey(), equalTo("6-*"));  
        assertThat(range.getBuckets().size(), equalTo(2));
    }
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(range, notNullValue());
        assertThat(range, notNullValue());
        internalCluster().wipeIndices("cache_test_idx");
    public RangeIT(Settings staticSettings) {  
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(bucket, notNullValue());  
        Script script = new Script(
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
            )
    r3: 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12
    [7, 8j
        assertThat(propertiesCounts[0], equalTo(3.0));
                Map<?, ?> doc = (Map) vars.get("doc");  
    /**
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(range, notNullValue());  
        assertThat(range.getName(), equalTo("range"));
            );
        bucket = buckets.get(1);
        assertThat(range.getName(), equalTo("range"));  
        assertThat(range.getName(), equalTo("range"));  
                .setRequestCache(true)
    [2, 3]
        bucket = buckets.get(2);
            assertThat(rangeBucket.getKeyAsString(), equalTo("*-3.0"));  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
    }
        bucket = buckets.get(2);  
                assertThat(rangeBucket.getDocCount(), equalTo(0L));  
                return value.getValue();
        createIndex("idx");
    }
        builders.add(client().prepareIndex("old_index").setSource("distance", 50.5));
import static org.hamcrest.Matchers.equalTo;
        assertSearchResponse(response);  
        assertThat(bucket, notNullValue());
                .getMissCount(),
        assertThat(bucket.getDocCount(), equalTo(1L));
                .prepareStats("cache_test_idx")
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(-1.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
        assertThat(bucket.getToAsString(), equalTo("6.0"));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertThat(bucket.getDocCount(), equalTo(3L));  
        Range.Bucket bucket = buckets.get(0);
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) range).getProperty("_key");  
        bucket = buckets.get(2);
            assertThat(rangeBucket, notNullValue());
            equalTo(0L)
                .getHitCount(),
        bucket = buckets.get(1);
                Map<?, ?> doc = (Map) vars.get("doc");  
        assertSearchResponse(r);
            )
            equalTo(0L)
        assertThat(bucket, notNullValue());
        assertThat(range, notNullValue());
        assertThat(bucket.getFromAsString(), nullValue());  
            )
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getDocCount(), equalTo(3L));  
    [3, 4]
        assertThat(  
        assertThat(bucket.getKey(), equalTo("1000.0-*"));  
    [1, 2]
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bucket, notNullValue());  
 *
        assertThat(bucket, notNullValue());
        Sum sum = bucket.getAggregations().get("sum");  
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(range.getBuckets().size(), equalTo(3));  
        assertThat(bucket.getKey(), equalTo("150.0-*"));
        assertThat(bucket.getKey(), equalTo("*-3"));  
        Range.Bucket bucket = buckets.get(0);  
                .get()
                .prepareStats("cache_test_idx")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
            assertThat(rangeBucket.getToAsString(), nullValue());
        assertSearchResponse(response);
        assertThat(bucket, notNullValue());  
        Range.Bucket bucket = buckets.get(0);
                range("foo").field("i")  
                .indices()  
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();  
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
    [4, 5]
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(range.getBuckets().size(), equalTo(3));  
        assertThat(bucket.getToAsString(), equalTo("6.0"));
     */
            } else {  
        prepareCreate("old_index").setMapping("distance", "type=double", "route_length_miles", "type=alias,path=distance").get();  
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6).format("#"))
        assertThat(bucket.getDocCount(), equalTo(3L)); // 3, 4, 5
import static org.hamcrest.core.IsNull.notNullValue;
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));  
        assertAcked(  
        }  
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getToAsString(), equalTo("5.0"));  
    [9, 10]
            });  
 * software distributed under the License is distributed on an
                .getTotal()  
    [10, 11]
            )
            .addAggregation(
import static org.hamcrest.Matchers.instanceOf;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            client().prepareSearch("idx").addAggregation(range("foobar").field(SINGLE_VALUED_FIELD_NAME)).get();
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("6.0"));  
        assertThat(bucket.getToAsString(), nullValue());
            CustomScriptPlugin.NAME,
        assertThat(buckets.size(), equalTo(3));  
        assertThat(bucket, notNullValue());
import org.opensearch.index.fielddata.ScriptDocValues;  
                    .addUnboundedFrom(6)
import java.util.HashMap;
                    .subAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addRange("0-2", 0.0, 2.0))  
public class RangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    [3, 4]
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [foobar] aggregation");  
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        assertThat(bucket.getFromAsString(), equalTo("6.0"));  
            .get();  
                    .addUnboundedFrom(6)  
            } else {
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));  
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(propertiesKeys[2], equalTo("6.0-*"));
        assertThat(bucket.getDocCount(), equalTo(0L));
            });  
            client().admin()  
        assertThat(range.getBuckets().size(), equalTo(3));
        assertSearchResponse(response);  
    public void testSingleValueFieldWithFormat() throws Exception {  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(range.getName(), equalTo("range"));  
        assertThat(bucket.getDocCount(), equalTo(2L));  
                .setRequestCache(true)
        assertThat(bucket.getDocCount(), equalTo(2L));
            .get();  
        assertThat(bucket, notNullValue());
    [6, 7]
                .indices()  
import java.util.Collection;  
                client().prepareIndex("empty_bucket_idx")
            if (i == 3 || i == 6) {
        assertThat(range, notNullValue());
                    .setId("" + i)  
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());  
import org.opensearch.test.OpenSearchIntegTestCase;  
            assertThat(rangeBucket, notNullValue());
        assertThat(bucket.getKey(), equalTo("*-3.0"));  
            client().admin()
        assertThat(buckets.get(0).getToAsString(), equalTo("2.0"));
                    .size(100)
        assertThat(bucket.getDocCount(), equalTo(0L));
    [9, 10]
                .get()
            .addAggregation(
    [2, 3]  
                client().prepareIndex("idx")
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
     */
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        numDocs = randomIntBetween(10, 20);  
            assertThat(rangeBucket.getToAsString(), equalTo("3.0"));  
                .get()
            .addAggregation(  
            assertThat(rangeBucket, notNullValue());  
        // Ensure that non-scripted requests are cached as normal  
        assertThat(bucket.getFromAsString(), nullValue());  
        assertThat(bucket.getToAsString(), nullValue());
        bucket = buckets.get(1);
import org.opensearch.action.index.IndexRequestBuilder;
        return Arrays.asList(  
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
    r2: 3, 3, 4, 4, 5, 5  
 * compatible open source license.
 */
import java.util.Arrays;
        assertThat(bucket.getDocCount(), equalTo(2L));
    r1: 2
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(MULTI_VALUED_FIELD_NAME);
        bucket = buckets.get(1);
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(4L));
                .prepareStats("cache_test_idx")  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getDocCount(), equalTo(2L));  
        } catch (SearchPhaseExecutionException spee) {  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(bucket.getKey(), equalTo("6.0-*"));  
        assertThat(bucket, notNullValue());
        bucket = buckets.get(2);
        super(staticSettings);
        );
        assertThat(bucket, notNullValue());  
                            .value(i + 1)  
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) range).getProperty("_count");
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
        try {  
        List<? extends Bucket> buckets = range.getBuckets();
        for (int i = 0; i < 2; i++) {  
        assertThat(range, Matchers.notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        );
        assertThat(range.getBuckets().size(), equalTo(3));
 */  
        assertThat(bucket.getKey(), equalTo("*-3.0"));
            .addAggregation(range("range").script(script).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))  
            .setQuery(matchAllQuery())
            assertThat(rangeBucket.getKey(), equalTo("6.0-*"));
                .setRequestCache(true)
            .get();
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));
    @ParametersFactory
    }
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
    [5, 6]  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        }
        assertThat(bucket.getFromAsString(), equalTo("3.0"));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));  
        assertThat(propertiesDocCounts[1], equalTo(3L));
        assertThat(range.getBuckets().size(), equalTo(3));  
        prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer").get();
     */
        assertThat(bucket.getToAsString(), equalTo("3.0"));
                    )
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKey(), equalTo("50.0-150.0"));
            .get();
            equalTo(2L)  
    }  
                .getRequestCache()
            prepareCreate("cache_test_idx").setMapping("i", "type=integer")
 * GitHub history for details.
            ScriptType.INLINE,  
            client().prepareIndex("cache_test_idx").setId("2").setSource(jsonBuilder().startObject().field("i", 2).endObject())
        assertThat(bucket.getKey(), equalTo("r3"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
        assertThat(range, notNullValue());
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        assertSearchResponse(response);  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));  
        assertThat(bucket.getKey(), equalTo("3-6"));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
                        jsonBuilder().startObject()  
        assertThat(bucket, notNullValue());
        assertThat(range, notNullValue());
                assertThat(rangeBucket.getDocCount(), equalTo(0L));
                range("range").field(SINGLE_VALUED_FIELD_NAME)  
        Terms terms = response.getAggregations().get("terms");  
            Collections.emptyMap()  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));
            Collections.emptyMap()  
                range("range").field("route_length_miles").missing(0.0).addUnboundedTo(50.0).addRange(50.0, 150.0).addUnboundedFrom(150.0)
        assertThat(range, notNullValue());  
        assertThat(bucket.getDocCount(), equalTo(3L));
                .get()
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
                            .endArray()
        assertThat(bucket, notNullValue());
    }
 * SPDX-License-Identifier: Apache-2.0
        sum = bucket.getAggregations().get("sum");  
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        // Create two indices and add the field 'route_length_miles' as an alias in
        Range.Bucket bucket = buckets.get(0);
            .get();
        assertThat(bucket.getFromAsString(), equalTo("6"));  
                .get()  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));  
                .get()  
            rangeBucket = buckets.get(2);  
                range("range").field(MULTI_VALUED_FIELD_NAME)  
            .get();  
                range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo("r1", 3).addRange("r2", 3, 6).addUnboundedFrom("r3", 6)
    }
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
            .addAggregation(
            } else if (i == 2) {  
        List<? extends Bucket> buckets = range.getBuckets();
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
        assertThat(bucket.getToAsString(), nullValue());
        SearchResponse response = client().prepareSearch("idx_unmapped")
            .addAggregation(
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
    public void testUnmapped() throws Exception {  
        );  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getDocCount(), equalTo(0L));
            if (i == 6 || i == numDocs + 1) {  
            } else if (i < 6) {
            equalTo(0L)  
    }
        long total = 0;
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(propertiesCounts[1], equalTo(12.0));
        List<IndexRequestBuilder> builders = new ArrayList<>();
    [11, 12]  
                range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(5).addRange(3, 6).addRange(4, 5).addUnboundedFrom(4)  
                            .endObject()  
    [10, 11]  
        assertSearchResponse(response);
        }  
            equalTo(0L)
 * You may obtain a copy of the License at  
        );  
            CustomScriptPlugin.NAME,
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        Range range = bucket.getAggregations().get("range");
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
        );  
        assertThat(bucket.getKey(), equalTo("4.0-*"));
                .get()
            Throwable rootCause = spee.getCause().getCause();
        assertSearchResponse(response);
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket, notNullValue());
            );
                .getTotal()
            .get();
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
            )  
        assertThat(bucket.getToAsString(), equalTo("-1.0"));
    }  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
     */
        assertSearchResponse(response);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000d));
        assertThat(range.getName(), equalTo("range"));
        assertThat(range, notNullValue());
    @Override  
            final long docCount = i == 1 || i == numDocs + 1 ? 1 : 2;  
        Range range = response.getAggregations().get("range");
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));  
            if (i == 1 || i == 3) {
        List<Range.Bucket> buckets = new ArrayList<>(range.getBuckets());  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
            assertThat(rangeBucket.getKey(), equalTo("*-3.0"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getKey(), equalTo("6.0-*"));
        r = client().prepareSearch("cache_test_idx")  
        assertThat(range.getBuckets().size(), equalTo(3));
        assertSearchResponse(r);
import org.opensearch.common.settings.Settings;
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));  
            }
        bucket = buckets.get(2);
            client().admin()
 * under the License.  
    r1: 1, 2, 2
    public void testSingleValueField() throws Exception {
        // Test that a request using a nondeterministic script does not get cached
        assertThat(bucket, notNullValue());
                .prepareStats("cache_test_idx")  
        for (int i = 1; i < numDocs + 2; ++i) {  
        assertThat(propertiesDocCounts[2], equalTo(numDocs - 5L));
    }
        assertThat(  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));  
        );
        Histogram histo = searchResponse.getAggregations().get("histo");
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
        );
        assertThat(range, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
                    .minDocCount(0)
                .indices()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.search.aggregations.bucket.range.Range;
            client().admin()
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
    r2: 3, 3, 4, 4, 5, 5
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
        bucket = buckets.get(1);
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
        assertThat(((Number) buckets.get(0).getTo()).doubleValue(), equalTo(2.0));  
        );  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 3L));
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;  
        assertThat(bucket.getKey(), equalTo("6.0-*"));  
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));  
    }  
    public void testScriptMultiValued() throws Exception {
            )
        bucket = buckets.get(1);  
        assertThat(range.getName(), equalTo("range"));
    /*
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(range.getName(), equalTo("range"));
        assertSearchResponse(response);
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(SINGLE_VALUED_FIELD_NAME);
        assertThat(range.getBuckets().size(), equalTo(3));
        assertThat(bucket.getFromAsString(), nullValue());
            scripts.put("Math.random()", vars -> RangeIT.randomDouble());  
    [7, 8j
            .addAggregation(range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(-1).addUnboundedFrom(1000))
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(2L));
        Script script = new Script(
        Range.Bucket bucket = buckets.get(0);
        bucket = buckets.get(2);
        bucket = buckets.get(2);
        assertThat(bucket.getDocCount(), equalTo(2L));  
            } else if (i == 4 || i == 5) {
        assertThat(bucket.getFromAsString(), equalTo("6.0"));
                            .startArray(MULTI_VALUED_FIELD_NAME)
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
    public void testFieldAliasWithMissingValue() {
    [4, 5]
            equalTo(0L)  
        assertThat(((Number) buckets.get(0).getFrom()).doubleValue(), equalTo(0.0));
                .getHitCount(),
        Range.Bucket bucket = buckets.get(0);  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(range("foo").field("i").addRange(0, 10)).get();
    [10, 11]
        assertThat(bucket.getKey(), equalTo("*-3.0"));  
            rangeBucket = buckets.get(1);
                            .value(i + 2)
        assertThat(bucket.getFromAsString(), nullValue());  
                .getMissCount(),
        assertThat(bucket.getDocCount(), equalTo(0L));
        // Test that a request using a deterministic script gets cached
                .getTotal()
            List<? extends Bucket> buckets = range.getBuckets();  
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket, notNullValue());
    }  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
            .addAggregation(range("range").script(script).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
                .get()  
                            .field(SINGLE_VALUED_FIELD_NAME, i + 1)
import org.opensearch.script.Script;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
            .addAggregation(range("range").field("route_length_miles").addUnboundedTo(50.0).addRange(50.0, 150.0).addUnboundedFrom(150.0))
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        assertThat(bucket.getDocCount(), equalTo(2L));
        }
        assertThat(bucket.getToAsString(), equalTo("6.0"));
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
                    .addUnboundedTo(3)
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), nullValue());  
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getKey(), equalTo("r1"));
        bucket = buckets.get(3);  
        assertThat(bucket, notNullValue());
        }
        prepareCreate("new_index").setMapping("route_length_miles", "type=double").get();
            return scripts;
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getToAsString(), nullValue());
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
        Range.Bucket bucket = buckets.get(0);
            assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), equalTo("6.0"));
    [8, 9]  
        assertThat(bucket.getKey(), equalTo("*-5.0"));
                assertThat(rangeBucket.getDocCount(), equalTo(2L));
                .getRequestCache()  
        SearchResponse r = client().prepareSearch("cache_test_idx")
                .getRequestCache()
        assertThat(
        SearchResponse response = client().prepareSearch("old_index", "new_index")  
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) range).getProperty("sum.value");
    public void testScriptCaching() throws Exception {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            .addAggregation(
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("3.0"));  
        Range range = response.getAggregations().get("range");
        Range.Bucket bucket = buckets.get(0);  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(sum.getValue(), equalTo(12.0)); // 3 + 4 + 5
        assertThat(bucket.getKey(), equalTo("*-3.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertSearchResponse(response);
        assertThat(propertiesKeys[0], equalTo("*-3.0"));  
    [8, 9]
            .addAggregation(range("range").field(SINGLE_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))  
        bucket = buckets.get(2);
        Range range = response.getAggregations().get("range");
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(4.0));  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        assertThat(buckets.size(), equalTo(3));
 * specific language governing permissions and limitations
                .indices()
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();  
        ensureSearchable();
        assertThat(bucket.getFromAsString(), equalTo("6.0"));  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));
 */
                assertThat(rangeBucket.getDocCount(), equalTo(1L));
import static org.hamcrest.core.IsNull.nullValue;
        bucket = buckets.get(2);
                .indices()
        assertThat(propertiesDocCounts[0], equalTo(2L));
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        assertThat(bucket.getKey(), equalTo("r2"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
    public void testSingleValuedFieldWithValueScript() throws Exception {  
        bucket = buckets.get(1);
        @Override
            .get();  
        bucket = buckets.get(2);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        Range.Bucket bucket = buckets.get(0);
        assertSearchResponse(response);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        assertThat(bucket.getKey(), equalTo("4.0-5.0"));
        Range range = response.getAggregations().get("range");
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        }  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));
 * ownership. Elasticsearch licenses this file to you under  
    [11, 12]  
import org.hamcrest.Matchers;
            assertThat(bucket.getDocCount(), equalTo(docCount));
        assertThat(bucket.getFromAsString(), nullValue());  
        assertThat(  
        // Make sure we are starting with a clear cache
    public void testEmptyAggregation() throws Exception {
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertThat(bucket, notNullValue());  
                assertThat(rangeBucket.getDocCount(), equalTo(1L));  
            builders.add(  
import org.opensearch.plugins.Plugin;
import java.util.Collections;
    static int numDocs;
    public void testFieldAlias() {
            assertThat(rangeBucket.getKeyAsString(), equalTo("6.0-*"));
                    .addRange(3, 6)  
        assertThat(bucket, notNullValue());  
        @Override
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat(sum.getValue(), equalTo((double) total));  
        assertThat(bucket.getKey(), equalTo("*-50.0"));
                .get()
        assertThat(bucket.getDocCount(), equalTo(2L));  
        bucket = buckets.get(1);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(rangeBucket.getKey(), equalTo("3.0-6.0"));  
        assertThat(bucket, notNullValue());
/*
            .get();  
        assertThat(bucket.getToAsString(), equalTo("3.0"));
    [3, 4]
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertThat(sum, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));  
        assertThat(
import java.util.List;  
        assertThat(range.getName(), equalTo("range"));
        indexRandom(true, builders);
        List<? extends Bucket> buckets = range.getBuckets();
                assertThat(rangeBucket.getDocCount(), equalTo(0L));  
        assertThat(bucket.getToAsString(), equalTo("3.0"));
        Range range = response.getAggregations().get("range");
                    )  
                    .addUnboundedTo(3)
        assertThat(terms.getBuckets().size(), equalTo(numDocs + 1));
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        params.put("fieldname", "date");
    public void testRangeAsSubAggregation() throws Exception {
                    .interval(1L)
        assertThat(bucket.getFromAsString(), equalTo("6.0"));  
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(rangeBucket.getFromAsString(), nullValue());
        SearchResponse response = client().prepareSearch("idx")
    [1, 2]  
        assertThat(bucket.getToAsString(), equalTo("3"));
            .addAggregation(  
                .getRequestCache()
        assertThat(bucket, notNullValue());  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getToAsString(), nullValue());
            )
            .get();
        assertThat(bucket.getDocCount(), equalTo(numDocs - 5L));  
                .indices()
        bucket = buckets.get(1);
        assertThat(bucket.getKey(), equalTo("3.0-6.0"));  
        assertThat(range.getName(), equalTo("range"));  
                        jsonBuilder().startObject()
            .addAggregation(range("range").field(MULTI_VALUED_FIELD_NAME).addUnboundedTo(3).addRange(3, 6).addUnboundedFrom(6))
        SearchResponse response = client().prepareSearch("old_index", "new_index")
        assertThat(range, notNullValue());
        indexRandomForConcurrentSearch("empty_bucket_idx");
            .get();  
        assertThat(range.getName(), equalTo("range"));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(range.getName(), equalTo("range"));  
                .setRequestCache(true)  
        assertSearchResponse(r);
                            .field(SINGLE_VALUED_FIELD_NAME, i * 2 - 1)
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                .getTotal()
        assertThat(bucket.getFromAsString(), equalTo("3"));  
            .addAggregation(
        );
        assertThat(range.getBuckets().size(), equalTo(3));
import static org.hamcrest.Matchers.is;  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));  
            )  
    public void testOverlappingRanges() throws Exception {  
        assertThat(bucket, notNullValue());
            true,  
        assertThat(bucket.getToAsString(), nullValue());
            )
package org.opensearch.search.aggregations.bucket;
        assertThat(bucket, notNullValue());
        assertThat(propertiesCounts[2], equalTo((double) total));  
        Range range = response.getAggregations().get("range");  
                .setRequestCache(true)
        );
            Range range = bucket.getAggregations().get("range");
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(3.0));  
        assertThat(bucket.getDocCount(), equalTo(3L));  
        bucket = buckets.get(1);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
        indexRandomForMultipleSlices("idx", "old_index", "new_index");  
        assertThat(bucket.getFromAsString(), equalTo("3.0"));
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
    }
            assertThat(rangeBucket.getFromAsString(), equalTo("6.0"));
    /*
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getFromAsString(), equalTo("3.0"));  
                            .endObject()
        assertSearchResponse(response);  
    [5, 6]
        SearchResponse response = client().prepareSearch("idx")
                assertThat(rangeBucket.getDocCount(), equalTo(1L));
            client().admin()
            .get();  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
    [4, 5]  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(3.0));
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
import org.opensearch.script.ScriptType;  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
    [6, 7]
    [5, 6]  
            equalTo(0L)
        assertThat(range, notNullValue());  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
 *  
                    .addRange(0, 10)
        Range range = response.getAggregations().get("range");
    [9, 10]
        builders.add(client().prepareIndex("old_index").setSource("distance", 42.0));  
        assertThat(bucket.getKey(), equalTo("*--1.0"));  
