            .get();
        double[] expectedKeys = new double[] { 6, 7, 3, 5, 4, 1, 2 };  
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
                            .value((double) i)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            )
                    terms("terms").field(field)
            } else {  
        assertThat(terms.getName(), equalTo("terms"));
     * Make sure that a request using a deterministic script or not using a script get cached.  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2.5)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            assertThat(bucket, notNullValue());
            .addAggregation(
                terms("num_tags").field("num_tag")
    private static final int NUM_DOCS = 5; // TODO: randomize the size?
                .indices()  
    }
            Terms.Bucket bucket = terms.getBucketByKey(key);
            assertThat(avg, notNullValue());
        for (int i = 0; i < 5; i++) {
        indexRandom(  
                            Collections.emptyMap()
            scripts.put("Math.random()", vars -> DoubleTermsIT.randomDouble());
            assertThat(bucket, notNullValue());
                .setRequestCache(true)
        }  
        SearchResponse response = client().prepareSearch("sort_idx")
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
        Terms terms = response.getAggregations().get("terms");  
            if (i == 0 || i == 5) {
            assertThat(bucket.getDocCount(), equalTo(1L));  
        for (int i = 0; i < 100; i++) {  
            .addAggregation(  
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);  
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
            .get();
        );
    [4, 5]
public class DoubleTermsIT extends AbstractTermsTestCase {
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {
            assertThat(bucket, notNullValue());  
        assertThat(tags.getBuckets().size(), equalTo(2));
                .getMissCount(),
        SearchResponse allResponse = client().prepareSearch("idx")
import org.opensearch.script.ScriptType;
            );
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {
                            ScriptType.INLINE,
 * GitHub history for details.
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
    [3, 4]  
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
                            .order(BucketOrder.aggregation("avg_i", true))
                            .endObject()
                terms("terms").field(MULTI_VALUED_FIELD_NAME)  
        assertThat(terms.getBuckets().size(), equalTo(6));  
        // Test that a request using a deterministic script gets cached  
                .prepareStats("cache_test_idx")  
    }
        assertThat(terms.getBuckets().size(), equalTo(5));  
            .addAggregation(
        assertThat(bucket.getKeyAsNumber().intValue(), equalTo(1));
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())  
                // expected  
 * not use this file except in compliance with the License.
        createIndex("idx");
        assertSearchResponse(response);
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
            assertThat(bucket.getDocCount(), equalTo(1L));  
            client().prepareIndex("sort_idx")  
                    .subAggregation(sum("sum_d").field("d"))
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(aggregationScript))
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
        }
            return scripts;  
        assertSearchResponse(response);
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
            assertThat(bucket.getDocCount(), equalTo(i == 1 ? 3L : 1L));
                .getRequestCache()
import java.util.Map;  
            .get();  
            builders.add(
        assertThat(bucket, notNullValue());
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));  
import java.util.Arrays;
        }
        Terms.Bucket bucket = terms.getBucketByKey("1.0");
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                            .startArray(MULTI_VALUED_FIELD_NAME)  
        createIndex("idx_unmapped");  
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);  
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
 * this work for additional information regarding copyright
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
                client().prepareIndex("sort_idx")
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
                return value.getValue();
        ensureSearchable();
            assertThat(bucket.getDocCount(), equalTo(1L));  
        bucketProps.put("avg_l", 2d);  
                            "doc['" + MULTI_VALUED_FIELD_NAME + "'].value",  
            assertThat(bucket, notNullValue());  
        filter = tag.getAggregations().get("filter");  
                    .subAggregation(avg("avg_i").field(SINGLE_VALUED_FIELD_NAME))
            )  
            Avg avg = bucket.getAggregations().get("avg_l");  
import org.opensearch.test.OpenSearchIntegTestCase;  
     * Ensure requests using nondeterministic scripts do not get cached.
        int expectedCardinality = terms.getBuckets().size();
        assertThat(tags, notNullValue());
                    )
            assertThat(key(bucket), equalTo("" + (i + 1d)));
            assertThat(key(bucket), equalTo("" + (double) i));
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
        Terms terms = allResponse.getAggregations().get("terms");
                    .order(BucketOrder.aggregation("stats.avg", asc))
            BucketOrder.aggregation("avg_l", false)
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))  
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {  
 */
            .get();
            assertThat(key(bucket), equalTo("" + (double) i));
            assertThat(avg.getValue(), equalTo((double) i));
        assertThat(terms.getName(), equalTo("terms"));
    }  
        assertEquals(expectedCardinality, foundTerms.size());  
        );
            .addAggregation(
        assertThat(terms, notNullValue());
            equalTo(1L)  
        SearchResponse response = client().prepareSearch("idx")
            ScriptType.INLINE,  
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
        assertThat(terms.getBuckets().size(), equalTo(5));  
                client().prepareIndex("high_card_idx")
    6 - count: 1 - sum: 6  
                .getRequestCache()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
                .getRequestCache()
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))  
                    .subAggregation(  
                .get()  
    }  
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            assertThat(bucket, notNullValue());
        );  
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                terms("terms").field("d")
        assertSearchResponse(response);  
        // Ensure that non-scripted requests are cached as normal  
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())  
                .indices()
                terms("tags").field("num_tag")  
        bucketProps.put("_term", 3d);
                            .field("num_tag", i < NUM_DOCS / 2 + 1 ? 1 : 0) // used to test order by single-bucket sub agg
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");  
                .get()
                    )
            )  
    }
        Terms terms = response.getAggregations().get("terms");  
                            .order(BucketOrder.aggregation("num_tags", true))  
                client().prepareSearch(index)
                            .endArray()  
import java.util.Iterator;  
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
                    )  
                .prepareStats("cache_test_idx")
                .get()  
            assertThat(avg, notNullValue());  
                client().prepareIndex("sort_idx")
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscWithSubTermsAgg() throws Exception {
 *
import java.util.Collection;
            return scripts;  
                assertThat(subBucket.getDocCount(), equalTo(1L));
        Terms.Bucket tag = iters.next();
                .indices()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 2).endObject())  
    }
                client().prepareIndex("idx")  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tags, notNullValue());  
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
            )
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
        for (int i = 0; i < 5; i++) {  
            .addAggregation(  
        bucketProps.put("_count", 2L);
        tag = iters.next();
        Filter filter1 = tag.getAggregations().get("filter1");  
        }
            scripts.put("ceil(_score.doubleValue()/3)", vars -> {
                .get()  
    }
        assertThat(terms.getName(), equalTo("terms"));
                .addAggregation(
        assertThat(terms.getName(), equalTo("terms"));  
/*  
            prepareCreate("cache_test_idx").setMapping("d", "type=float")
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        bucketProps.put("avg_l", 5d);  
                .getHitCount(),  
        Filter filter2 = filter1.getAggregations().get("filter2");  
                    .order(BucketOrder.aggregation("avg_i", asc))
import java.util.List;
        }
            assertThat(terms.getName(), equalTo("terms"));  
            Avg avg = bucket.getAggregations().get("avg_i");
            );  
                            .value(i + 1d)
                    )  
                    .order(BucketOrder.compound(order))  
            )
            IllegalArgumentException.class,
        builders.add(  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms.getName(), equalTo("terms"));
import org.opensearch.search.aggregations.metrics.Sum;
            } catch (OpenSearchException e) {
        bucketProps.put("avg_l", 3d);  
/*
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
import java.util.Collections;  
                )
import org.opensearch.search.aggregations.metrics.Avg;
import org.opensearch.search.aggregations.metrics.Stats;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
/*
                .getMissCount(),
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
            assertThat(bucket, notNullValue());
            client().prepareIndex("sort_idx")
                .getRequestCache()
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {  
        assertThat(terms.getName(), equalTo("terms"));
    }
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
            .setQuery(functionScoreQuery(scriptFunction(scoringScript)))
                assertThat(subBucket, notNullValue());
            .get();
        assertMultiSortResponse(  
        assertThat(terms.getBuckets().size(), equalTo(1));
        }
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);  
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(r);
    }
        for (int i = 0; i < 5; i++) {
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
                    .get();  
                    .order(BucketOrder.aggregation("stats.avg", asc))
 *  
    }
        );
import org.opensearch.search.aggregations.metrics.ExtendedStats;
        assertSearchResponse(response);
    }
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
            .get();
            assertThat(bucket, notNullValue());
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
    }  
            client().admin()
                .getMissCount(),
import static org.hamcrest.Matchers.containsString;
        assertThat(terms.getName(), equalTo("terms"));  
        for (int i = 0; i < 2; i++) {
            } catch (OpenSearchException e) {
                            ScriptType.INLINE,
            assertThat(bucket, notNullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        for (int i = 1; i <= 3; i++) {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
import org.opensearch.action.index.IndexRequestBuilder;
                    .addAggregation(
            expectedKeys,
                            CustomScriptPlugin.NAME,
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            });
    /**
                .setRequestCache(true)
        SearchResponse response = client().prepareSearch("idx")  
        Script aggregationScript = new Script(
        bucketProps.put("_term", 1d);
        Terms terms = response.getAggregations().get("terms");
        assertThat(tags.getBuckets().size(), equalTo(2));
            true,
        bucketProps.put("sum_d", 6d);
    private static final String MULTI_VALUED_FIELD_NAME = "d_values";  
    3 - count: 2 - sum: 6  
        assertSearchResponse(allResponse);
        assertThat(  
        bucketProps.put("sum_d", 6d);
import java.util.HashSet;
        indexRandom(true, builders);  
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
            builders.add(  
        assertThat(terms, notNullValue());
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "(long) (_value / 1000 + 1)", Collections.emptyMap()))
                return doc.get(MULTI_VALUED_FIELD_NAME);
    private static final String SINGLE_VALUED_FIELD_NAME = "d_value";
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        assertSearchResponse(response);  
                terms("terms").field("d")
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
                .indices()  
import java.util.function.Function;
            SearchResponse response = client().prepareSearch("idx")
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME + "2")  
        for (int i = 0; i < 3; i++) {  
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));
import java.util.ArrayList;  
        assertThat(filter, notNullValue());
            assertThat(key(bucket), equalTo("" + (double) i));  
                            Collections.emptyMap()
        double[] expectedKeys = new double[] { 6, 7, 3, 4, 5, 1, 2 };
            assertThat(bucket.getDocCount(), equalTo(1L));  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
    */
        double[] expectedKeys = new double[] { 1, 2, 3, 4, 5, 6, 7 };  
                // expected  
            )
        assertSearchResponse(response);
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));  
    }
import static org.hamcrest.core.IsNull.notNullValue;
        assertThat(key(bucket), equalTo("1.0"));  
            client().prepareIndex("sort_idx")
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");  
                .getTotal()
                return value.getValue();
            client().admin()
            for (Bucket bucket : terms.getBuckets()) {
 *
        assertSearchResponse(response);
        assertThat(  
        assertThat(terms.getName(), equalTo("terms"));
                .getTotal()  
                .get()  
        Terms tags = response.getAggregations().get("num_tags");
        boolean asc = true;  
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;  
                );  
        assertThat(tag, notNullValue());
            )  
        assertThat(
                Map<?, ?> doc = (Map) vars.get("doc");
                .indices()
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
        Terms tags = response.getAggregations().get("tags");
        assertThat(terms, notNullValue());
        }
        assertThat(tag, notNullValue());  
        );
                .prepareStats("cache_test_idx")  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
            .get();  
            client().prepareIndex("sort_idx")
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        return bucket.getKeyAsString();
                .setRequestCache(true)
                .indices()
                .getHitCount(),  
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
        bucketProps.put("_count", 2L);
            try {  
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));  
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(terms, notNullValue());  
    }  
import java.util.HashMap;
        }  
        Terms terms = response.getAggregations().get("terms");
    public void testMultiValuedFieldWithValueScript() throws Exception {
            Collections.emptyMap()  
import org.opensearch.search.aggregations.bucket.filter.Filter;  
    private String key(Terms.Bucket bucket) {
                    )  
        bucketProps = new HashMap<>();  
        builders.add(  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
    private static HashMap<Double, Map<String, Object>> expectedMultiSortBuckets;
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                            .field("constant", 1)
    private void assertMultiSortResponse(double[] expectedKeys, BucketOrder... order) {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME))
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);
            equalTo(0L)
                .get();
        IllegalArgumentException exception = expectThrows(
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {  
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
        );
            client().admin()
            .setSize(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())).format("0000.00")
    }  
            Stats stats = bucket.getAggregations().get("stats");
            assertThat(key(bucket), equalTo("" + (i + 1d)));
            .get();
        );
            .addAggregation(
    public void setupSuiteScopeCluster() throws Exception {
        }
        }
    }
                .setRequestCache(true)
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertAcked(prepareCreate("sort_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=double"));
        expectedMultiSortBuckets = new HashMap<>();
            );  
        }
        assertThat(max.getValue(), equalTo(asc ? 4.0 : 2.0));
                        .collectMode(randomFrom(SubAggCollectionMode.values()))  
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
                        )  
import org.opensearch.search.aggregations.BucketOrder;
                            .collectMode(randomFrom(SubAggCollectionMode.values()))  
                .setRequestCache(true)
        double[] expectedKeys = new double[] { 1, 2, 4, 3, 7, 6, 5 };
        for (int i = 4; i >= 0; i--) {
            client().prepareIndex("sort_idx")
        max = filter2.getAggregations().get("max");
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
                client().prepareSearch(index)
        );
            assertThat(bucket.getDocCount(), equalTo(1L));
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));
        bucketProps.put("sum_d", 3d);
        assertThat(tag, notNullValue());  
        for (int i = 0; i < 5; i++) {
 * under the License.  
                .prepareStats("cache_test_idx")  
        assertThat(
                .indices()  
            String key = String.format(Locale.ROOT, "%07.2f", (double) i);
    }
                    .order(BucketOrder.aggregation("filter", asc))
        boolean asc = randomBoolean();  
            client().prepareIndex("sort_idx")
                fail(
            .get();
                        + "with an unknown specified metric to order by"  
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
    }
            equalTo(0L)  
                .prepareStats("cache_test_idx")
        assertSearchResponse(response);
            CustomScriptPlugin.NAME,  
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
                assertThat(bucket.getDocCount(), equalTo(1L));  
        builders.add(  
            builders.add(
                .get()
        Terms terms = response.getAggregations().get("terms");
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
            .get();  
import java.io.IOException;
            .get();
                    .addAggregation(
        bucketProps.put("_count", 3L);
                assertThat(bucket.getKeyAsNumber(), instanceOf(Double.class));  
        bucketProps.put("_count", 3L);
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
                .getHitCount(),  
        assertThat(bucket.getDocCount(), equalTo(5L));
            )
            Sum sum = bucket.getAggregations().get("sum_d");  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())  
        bucketProps = new HashMap<>();  
        }
                            .value(i + 1d)
                    terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
    5 - count: 2 - sum: 10
            )
            assertThat(key(bucket), equalTo("" + (double) i));
    }
            equalTo(0L)
 * KIND, either express or implied.  See the License for the
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
            terms = response.getAggregations().get("terms");
        }  
            ScriptType.INLINE,
 * SPDX-License-Identifier: Apache-2.0
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {
                        jsonBuilder().startObject()
        assertThat(max.getValue(), equalTo(asc ? 2.0 : 4.0));
                .prepareStats("cache_test_idx")  
 */
            }
        Terms terms = response.getAggregations().get("terms");  
        @Override  
 * this file be licensed under the Apache-2.0 license or a
        for (Terms.Bucket bucket : terms.getBuckets()) {
                .prepareStats("cache_test_idx")
                assertThat(bucket.getDocCount(), equalTo(2L));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
    1 - count: 1 - sum: 1
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get(MULTI_VALUED_FIELD_NAME);  
 * Licensed to Elasticsearch under one or more contributor  
            BucketOrder.aggregation("sum_d", false),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertSearchResponse(response);  
        assertThat(
    }
        Terms terms = response.getAggregations().get("terms");
                    .get();
        SearchResponse response = client().prepareSearch("idx")
        for (int partition = 0; partition < numPartitions; partition++) {
                        new Script(
        assertThat(  
        Max max = filter2.getAggregations().get("max");  
        );
                    )
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            client().admin()
            i++;  
            client().prepareIndex("sort_idx")
import static org.hamcrest.Matchers.instanceOf;  
        assertThat(tag, notNullValue());
                    .addAggregation(
        bucketProps.put("_term", 5d);
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));  
    }  
                        + "where the metric name is not specified"
 * specific language governing permissions and limitations
            assertThat(key(bucket), equalTo(String.valueOf(expectedKeys[i])));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
        );  
            .addAggregation(
    }
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {  
import java.util.Locale;
            builders.add(  
        Terms.Bucket tag = iters.next();  
    }  
            client().prepareIndex("sort_idx")  
            );  
            } catch (OpenSearchException e) {  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
            double j = i;  
                            .value((double) i)
        }
        for (int i = 0; i < NUM_DOCS; i++) {
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            Stats stats = bucket.getAggregations().get("stats");
        tag = iters.next();
                .indices()  
            .get();
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {
        bucketProps.put("_term", 4d);
                .getRequestCache()
            assertThat(key(bucket), equalTo("" + (double) i));
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
    4 - count: 2 - sum: 8
        assertThat(terms, notNullValue());  
        }
            .addAggregation(
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));
            });
    public DoubleTermsIT(Settings staticSettings) {  
        boolean asc = true;
    }  
        Terms terms = response.getAggregations().get("terms");
    /*
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
package org.opensearch.search.aggregations.bucket;
        assertThat(terms, notNullValue());  
        assertThat(  
                            .endArray()  
    public void testPartiallyUnmapped() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(stats.getMax(), equalTo((double) i));
            .get();
                            .field(SINGLE_VALUED_FIELD_NAME, (double) i)  
            equalTo(0L)  
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
            client().admin()
    public void testScriptScore() {  
    2 - count: 2 - sum: 4
        assertThat(key(tag), equalTo(asc ? "0" : "1"));  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
    }
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;  
            .addAggregation(terms("terms").field(field).size(10000).collectMode(randomFrom(SubAggCollectionMode.values())))
        );
    }
        for (int i = 0; i < 5; i++) {
        bucketProps = new HashMap<>();  
        }
                .setRequestCache(true)
    }
        internalCluster().wipeIndices("cache_test_idx");
    public void testScriptMultiValued() throws Exception {
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat(terms.getBuckets().size(), equalTo(5));
            });
        );
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        // the max for "0" is 4  
                    .script(
    }
            scripts.put("(long) (_value / 1000 + 1)", vars -> (long) ((double) vars.get("_value") / 1000 + 1));  
            assertThat(bucket, notNullValue());
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            )  
            BucketOrder.count(false),
        bucketProps.put("_term", 2d);
        assertSearchResponse(response);
                .getTotal()  
}
        }
 * the Apache License, Version 2.0 (the "License"); you may
            });
                Map<?, ?> doc = (Map) vars.get("doc");  
        );
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(terms.getBuckets().size(), equalTo(5));
        Set<Number> foundTerms = new HashSet<>();  
        assertThat(terms, notNullValue());
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        filter1 = tag.getAggregations().get("filter1");
                    .subAggregation(extendedStats("stats").field(SINGLE_VALUED_FIELD_NAME))  
                .getRequestCache()
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms.getBuckets().size(), equalTo(6));
                Map<?, ?> doc = (Map) vars.get("doc");
        assertThat(terms.getBuckets().size(), equalTo(5));  
            assertThat(stats, notNullValue());  
        );
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))  
                assertThat(bucket.getDocCount(), equalTo(2L));
        Map<String, Object> bucketProps = new HashMap<>();  
        // Make sure we are starting with a clear cache  
            }
                    .setId("" + i)
            assertThat(subTermsAgg, notNullValue());
                            .order(BucketOrder.aggregation("stats", true))
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;  
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))  
 * Modifications Copyright OpenSearch Contributors. See  
        double[] expectedKeys = new double[] { 2, 1, 4, 5, 3, 6, 7 };
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {
        }
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
                            CustomScriptPlugin.NAME,  
        Terms terms = response.getAggregations().get("terms");  
        assertThat(filter1, notNullValue());  
        bucketProps.put("sum_d", 1d);
            )
    [5, 6]
        assertThat(terms, notNullValue());
                    .subAggregation(avg("avg_l").field("l"))
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));  
            "ceil(_score.doubleValue()/3)",
    }  
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                .getTotal()  
        bucketProps.put("_count", 1L);
            .get();  
            .get();
    public void testSizeIsZero() {  
            client().admin()
                );
import java.util.Set;
        filter2 = filter1.getAggregations().get("filter2");
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
                )  
                .prepareStats("cache_test_idx")
            .get();
        boolean asc = false;  
                client().prepareIndex("empty_bucket_idx")
import org.opensearch.index.fielddata.ScriptDocValues;
    }  
        double[] expectedKeys = new double[] { 1, 2, 3, 4, 5, 6, 7 };  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {
            .setSize(0)
        }
        assertThat(terms, notNullValue());  
                .setRequestCache(true)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .getRequestCache()
            assertThat(terms, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms, notNullValue());
            } else {
        bucketProps.put("avg_l", 5d);  
        builders.add(
        bucketProps.put("_term", 7d);
                        jsonBuilder().startObject()
        bucketProps.put("_count", 2L);
        assertThat(terms.getName(), equalTo("terms"));
            client().admin()
                    .subAggregation(terms("subTerms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))  
                            .field(SINGLE_VALUED_FIELD_NAME, (double) i)
import org.opensearch.OpenSearchException;  
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat(terms.getBuckets().size(), equalTo(5));  
            )  
    }  
            }
            assertThat(key(bucket), equalTo(key));
                    )
    }
        assertThat(terms, notNullValue());
        // Gather terms using partitioned aggregations
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            CustomScriptPlugin.NAME,
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
        );
            .get();
            .get();  
            );
        bucketProps.put("sum_d", 4d);
                            .order(BucketOrder.aggregation("stats.foo", true))
                // expected
                            .endObject()
                .get()
    @Override
            () -> client().prepareSearch("high_card_idx")  
            } catch (OpenSearchException e) {
            .addAggregation(  
                    .setSource(  
            assertThat(key(bucket), equalTo("" + (double) i));  
                .get()
            assertThat(sum, notNullValue());
        assertThat(
            )  
    }
                Number score = (Number) vars.get("_score");
    public void testSingleValuedFieldWithValueScript() throws Exception {  
                        new Script(  
        SearchResponse response = client().prepareSearch("idx")
        );
        bucketProps = new HashMap<>();  
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
            )
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))  
        bucketProps.put("avg_l", 1d);  
        builders.add(
        );  
                assertThat(bucket.getDocCount(), equalTo(1L));
        bucketProps = new HashMap<>();  
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())  
            assertThat(stats.getMax(), equalTo((double) i));
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
 * license agreements. See the NOTICE file distributed with
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        bucketProps = new HashMap<>();  
        return Collections.singleton(CustomScriptPlugin.class);  
                .get()
                    .get();
                client().prepareSearch(index)  
        for (int i = 0; i < 5; i++) {
                assertTrue(foundTerms.add(bucket.getKeyAsNumber()));
import org.opensearch.index.query.QueryBuilders;
        for (int i = 0; i < 5; i++) {
        assertThat(terms, notNullValue());
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
                        )
    [2, 3]
            equalTo(2L)  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 2).endObject())
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1.5),
    [1, 2]
        assertThat(terms, notNullValue());  
    }  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        Terms terms = response.getAggregations().get("terms");
                .getTotal()
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        boolean asc = true;  
            }  
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get(SINGLE_VALUED_FIELD_NAME);  
                .getTotal()
        super(staticSettings);
        SearchResponse response = client().prepareSearch("idx")
                // expected
            .addAggregation(  
                    .get();
        assertThat(filter1, notNullValue());
        // Find total number of unique terms  
    }  
        for (String index : Arrays.asList("idx", "idx_unmapped")) {  
                        )  
        assertSearchResponse(response);  
            assertThat(stats, notNullValue());  
        Terms terms = response.getAggregations().get("terms");
            }  
        }
            assertThat(key(bucket), equalTo("" + (double) i));
        assertAcked(
                client().prepareSearch(index)
        }
                fail(  
            equalTo(0L)
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        assertThat(tags.getName(), equalTo("tags"));  
        assertThat(terms.getName(), equalTo("terms"));
        bucketProps.put("avg_l", 3d);  
                .getTotal()
                    )
        }
        assertThat(max, notNullValue());
 * software distributed under the License is distributed on an
import org.opensearch.action.search.SearchResponse;
        );  
    public void testOtherDocCount() {
            }
                assertThat(key(subBucket), equalTo(String.valueOf(j)));  
        assertThat(filter, notNullValue());
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        // Test that a request using a nondeterministic script does not get cached  
                            .startArray(MULTI_VALUED_FIELD_NAME)  
        builders.add(
                            .subAggregation(terms("num_tags").field("num_tags").collectMode(randomFrom(SubAggCollectionMode.values())))
                return Math.ceil(score.doubleValue() / 3);  
            try {
                .getRequestCache()
        Terms terms = response.getAggregations().get("terms");  
            assertThat(key(bucket), equalTo("" + (double) i));
            .addAggregation(  
        assertSearchResponse(r);
        assertSearchResponse(response);
        bucketProps.put("sum_d", 1d);
            assertThat(bucket, notNullValue());  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        );
 * You may obtain a copy of the License at  
                    )
            .addAggregation(  
        bucketProps.put("_count", 1L);
        assertThat(terms.getName(), equalTo("terms"));  
            client().admin()
            assertThat(stats.getMax(), equalTo((double) i));
        assertThat(terms.getBuckets().size(), equalTo(5));
        // the max for "1" is 2
        SearchResponse r = client().prepareSearch("cache_test_idx")
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "'].value", vars -> {
            if (i == 0 || i == 5) {
        assertSearchResponse(response);  
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
    public void testScriptSingleValue() throws Exception {
 * compatible open source license.
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertSearchResponse(response);
    public void testScriptCaching() throws Exception {  
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));  
            try {
        builders.add(
        Script scoringScript = new Script(
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
        Terms terms = response.getAggregations().get("terms");  
            Collections.emptyMap()
            try {  
        bucketProps.put("avg_l", 5d);  
        assertSearchResponse(r);
                    .order(BucketOrder.aggregation("filter1>filter2>max", asc))
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
            )
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())
        );
            assertThat(bucket, notNullValue());
     */
            assertSearchResponse(response);  
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(filter2, notNullValue());
        boolean asc = randomBoolean();
        r = client().prepareSearch("cache_test_idx")
            assertThat(stats, notNullValue());  
                    .order(BucketOrder.aggregation("stats.variance", asc))
            .addAggregation(
            equalTo(0L)
import org.opensearch.plugins.Plugin;  
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .size(0)
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(filter2, notNullValue());  
            builders.add(
                .addAggregation(  
        bucketProps.put("_term", 6d);
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
        for (int i = 0; i < 6; i++) {  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 3).endObject())
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
        Filter filter = tag.getAggregations().get("filter");
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        );
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 */  
import org.opensearch.search.aggregations.metrics.Max;  
        assertThat(tags.getName(), equalTo("num_tags"));
                .get()
            }  
                .getHitCount(),  
        SearchResponse response = client().prepareSearch("idx")  
                .setRequestCache(true)
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
                .getTotal()  
            }
                        .includeExclude(new IncludeExclude(partition, numPartitions))
        for (int i = 0; i < 6; i++) {
        bucketProps.put("sum_d", 3d);
                j++;
                .getMissCount(),
import org.opensearch.common.settings.Settings;  
    public void testPartiallyUnmappedWithFormat() throws Exception {
        double[] expectedKeys = new double[] { 5, 6, 7, 3, 4, 2, 1 };
        );
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();
import org.opensearch.script.Script;
                    .setSource(
        assertSearchResponse(response);
        }
    }  
                        .minDocCount(randomInt(1))  
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
        final int numPartitions = randomIntBetween(2, 4);
            ExtendedStats stats = bucket.getAggregations().get("stats");
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        getMultiSortDocs(builders);
                    .script(  
        assertThat(terms.getBuckets().size(), equalTo(5));  
        assertThat(max, notNullValue());  
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(terms, notNullValue());
        builders.add(
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation which is not of a metrics type");
                    .addAggregation(  
        assertThat(terms.getName(), equalTo("terms"));
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        int i = 0;
            assertThat(bucket, notNullValue());  
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
