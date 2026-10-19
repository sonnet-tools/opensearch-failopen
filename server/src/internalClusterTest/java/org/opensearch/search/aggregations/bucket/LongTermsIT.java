            equalTo(0L)  
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(filter1, notNullValue());  
                    .get();
import java.util.Collection;
        max = filter2.getAggregations().get("max");
        );
                    .order(BucketOrder.aggregation("avg_i", asc))
                    .subAggregation(avg("avg_l").field("l"))  
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
                        .endObject()
        bucketProps.put("_term", 4L);  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        boolean asc = true;  
    }
 * specific language governing permissions and limitations
        );  
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
            .addAggregation(  
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
            equalTo(0L)  
                            .order(BucketOrder.aggregation("avg_i", true))
        ensureSearchable();  
        builders.add(
        bucketProps.put("_term", 7L);  
        }
        tag = iters.next();
                assertThat(subBucket.getDocCount(), equalTo(1L));
        assertThat(filter1, notNullValue());
                return doc.get(MULTI_VALUED_FIELD_NAME);
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);  
 *
                j++;
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
 * KIND, either express or implied.  See the License for the
    }
                .getRequestCache()  
                assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(terms, notNullValue());
    }
        assertThat(terms, notNullValue());
            if (i == 0 || i == 5) {
            return scripts;
        assertThat(tags.getName(), equalTo("tags"));  
        );
        bucketProps = new HashMap<>();
                client().prepareIndex("sort_idx")  
        assertThat(terms.getName(), equalTo("terms"));
            } catch (OpenSearchException e) {
                // expected  
                .prepareStats("cache_test_idx")
     * Ensure requests using nondeterministic scripts do not get cached.  
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();  
    }
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
                .indices()
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms, notNullValue());
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
                assertThat(bucket.getDocCount(), equalTo(2L));  
        );  
                        .startArray(MULTI_VALUED_FIELD_NAME)  
        boolean asc = true;
        tag = iters.next();
import org.opensearch.search.aggregations.metrics.ExtendedStats;
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
        bucketProps.put("sum_d", 1d);  
        assertSearchResponse(r);
        assertThat(terms.getName(), equalTo("terms"));  
 * ownership. Elasticsearch licenses this file to you under  
            try {  
                    .get();  
                        .field("num_tag", i < lowCardBuilders.length / 2 + 1 ? 1 : 0) // used to test order by single-bucket sub agg  
        }
                .indices()
            assertThat(bucket.getDocCount(), equalTo(1L));  
        }
            client().admin()
 */  
        for (int i = 0; i < 5; i++) {  
            client().prepareIndex("sort_idx")
                .indices()
    /*
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));
                .getRequestCache()
            assertThat(key(bucket), equalTo("" + i));  
        SearchResponse response = client().prepareSearch("sort_idx")
            assertThat(bucket.getDocCount(), equalTo(1L));  
        bucketProps.put("sum_d", 3d);  
                .addAggregation(  
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
            .addAggregation(
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())).format("0000")
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
    public void testScriptCaching() throws Exception {
        }
            assertThat(stats, notNullValue());
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
        assertThat(terms.getName(), equalTo("terms"));
        for (int i = 0; i < 5; i++) {
        Script script = new Script(
        indexRandom(true, highCardBuilders);
    }  
        assertThat(terms.getBuckets().size(), equalTo(5));  
        }  
            .get();  
        Terms terms = allResponse.getAggregations().get("terms");
        for (int i = 0; i < 6; i++) {
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(tag, notNullValue());
        for (int i = 0; i < 5; i++) {
                        .endArray()  
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {
 */
    @Override
                .getTotal()  
        for (int partition = 0; partition < numPartitions; partition++) {  
 * Licensed to Elasticsearch under one or more contributor  
                    )
        for (int i = 0; i < highCardBuilders.length; i++) {
                .get()
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
            builders.add(
        assertThat(terms.getName(), equalTo("terms"));  
        }
            builders.add(  
                    .subAggregation(extendedStats("stats").field(SINGLE_VALUED_FIELD_NAME))
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())  
        assertThat(terms.getBuckets().size(), equalTo(5));
            assertThat(key(bucket), equalTo(key));
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
import java.util.ArrayList;  
        );
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
import org.opensearch.search.aggregations.bucket.filter.Filter;  
                .getTotal()  
    private String key(Terms.Bucket bucket) {  
                .prepareStats("cache_test_idx")
    }
                .get();
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
            equalTo(0L)
import org.opensearch.search.aggregations.bucket.terms.Terms;
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
        Max max = filter2.getAggregations().get("max");  
                        .field("constant", 1)
                .getMissCount(),
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));
            .get();
        boolean asc = randomBoolean();
            .get();
                Map<?, ?> doc = (Map) vars.get("doc");  
 * software distributed under the License is distributed on an
                .getRequestCache()
    }
            )  
        assertThat(
        createIndex("idx_unmapped");  
            assertThat(bucket.getDocCount(), equalTo(1L));
            assertThat(bucket, notNullValue());
        assertAcked(  
            BucketOrder.count(false),
            .get();  
        assertSearchResponse(response);  
            .addAggregation(
        builders.add(  
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));  
        assertThat(terms, notNullValue());
            assertThat(stats, notNullValue());
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
import java.util.Locale;
        }
                        .value(i)
                client().prepareSearch(index)
        builders.add(
                client().prepareIndex("sort_idx")
 */
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertSearchResponse(response);
                .getHitCount(),
        Filter filter1 = tag.getAggregations().get("filter1");  
        );
import java.util.Arrays;
        // Make sure we are starting with a clear cache
                .setRequestCache(true)
        Terms terms = response.getAggregations().get("terms");  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")  
            .get();
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(  
                        .startArray(MULTI_VALUED_FIELD_NAME)
package org.opensearch.search.aggregations.bucket;
            Collections.emptyMap()
        assertThat(terms, notNullValue());
        boolean asc = false;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        assertThat(  
            }
        indexRandom(
            .get();  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            Terms.Bucket bucket = terms.getBucketByKey(key);
            assertThat(stats, notNullValue());  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        Terms terms = response.getAggregations().get("terms");
        );
            client().prepareIndex("sort_idx")
            if (i == 0 || i == 5) {  
        filter2 = filter1.getAggregations().get("filter2");
                            .order(BucketOrder.aggregation("stats.foo", true))
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
                .getHitCount(),
import static org.hamcrest.core.IsNull.notNullValue;
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        );
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));  
import org.opensearch.search.aggregations.metrics.Sum;
            int j = i;  
import org.opensearch.action.index.IndexRequestBuilder;
        builders.add(
        assertSearchResponse(response);  
        return Collections.singleton(CustomScriptPlugin.class);
        assertThat(terms.getBuckets().size(), equalTo(6));
                );
        SearchResponse response = client().prepareSearch("idx")  
                .getRequestCache()  
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
            )
                .getTotal()  
    }
            }
            client().admin()
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))  
                .getHitCount(),
                foundTerms.add(bucket.getKeyAsNumber());
                    jsonBuilder().startObject()
            } catch (OpenSearchException e) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                .prepareStats("cache_test_idx")  
        bucketProps = new HashMap<>();
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
        assertSearchResponse(r);
            Avg avg = bucket.getAggregations().get("avg_l");
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
import java.io.IOException;
                    .subAggregation(sum("sum_d").field("d"))
    }
            equalTo(0L)  
                client().prepareSearch(index)
import java.util.function.Function;
                .getTotal()
            .addAggregation(
                fail(
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {  
        assertThat(max, notNullValue());
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
                    )
        Filter filter = tag.getAggregations().get("filter");
        assertThat(terms, notNullValue());
                        .endArray()
            assertThat(terms, notNullValue());
        assertThat(filter, notNullValue());
        createIndex("idx", "high_card_idx");
        assertSearchResponse(response);
            assertSearchResponse(response);
        assertThat(terms.getName(), equalTo("terms"));  
    }  
                .get()
            )
                // expected
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 2).endObject())  
        bucketProps.put("_term", 1L);  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                // expected  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            equalTo(0L)
        long[] expectedKeys = new long[] { 6, 7, 3, 4, 5, 1, 2 };  
            )  
        bucketProps.put("avg_l", 5d);
        assertThat(tag, notNullValue());  
        assertThat(terms.getName(), equalTo("terms"));  
            equalTo(1L)
            lowCardBuilders[i] = client().prepareIndex("idx")
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 3).endObject())
     */
    }
/*
import org.opensearch.action.search.SearchResponse;
    }
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
            assertThat(bucket, notNullValue());  
            assertThat(key(bucket), equalTo("" + i));
            );  
            )
        long[] expectedKeys = new long[] { 2, 1, 4, 5, 3, 6, 7 };
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
        }
        );
        }
import org.opensearch.script.Script;
            Avg avg = bucket.getAggregations().get("avg_i");
        assertMultiSortResponse(
            )
                    jsonBuilder().startObject()  
    [3, 4]
                terms("terms").field(MULTI_VALUED_FIELD_NAME)  
        assertThat(terms.getName(), equalTo("terms"));
                .getRequestCache()  
                        .field(SINGLE_VALUED_FIELD_NAME, i)
    }
        assertThat(terms.getBuckets().size(), equalTo(5));
    public void testMultiValuedFieldWithValueScript() throws Exception {  
        // Ensure that non-scripted requests are cached as normal
                            .order(BucketOrder.aggregation("stats", true))
                .setRequestCache(true)
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        Terms tags = response.getAggregations().get("num_tags");
            });  
    }  
    public void testScriptMultiValued() throws Exception {
            assertThat(key(bucket), equalTo("" + i));
        for (int i = 0; i < 5; i++) {
            client().prepareIndex("sort_idx")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        SearchResponse r = client().prepareSearch("cache_test_idx")  
        assertThat(max, notNullValue());  
            Sum sum = bucket.getAggregations().get("sum_d");
        IndexRequestBuilder[] lowCardBuilders = new IndexRequestBuilder[NUM_DOCS];
                .getRequestCache()  
                            .subAggregation(terms("num_tags").field("num_tags").collectMode(randomFrom(SubAggCollectionMode.values())))
            assertThat(bucket, notNullValue());  
            Terms.Bucket bucket = terms.getBucketByKey("" + i);  
        Terms terms = response.getAggregations().get("terms");
        SearchResponse response = client().prepareSearch("idx")  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(terms, notNullValue());  
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
        );  
        bucketProps.put("avg_l", 5d);
 * the Apache License, Version 2.0 (the "License"); you may
            .get();  
                terms("tags").field("num_tag")  
                client().prepareSearch(index)
            assertThat(stats.getMax(), equalTo((double) i));
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));  
        // Find total number of unique terms
            }
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));  
        long[] expectedKeys = new long[] { 5, 6, 7, 3, 4, 2, 1 };
            "doc['" + MULTI_VALUED_FIELD_NAME + "']",  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscWithTermsSubAgg() throws Exception {
            assertThat(bucket, notNullValue());  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {  
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(script))  
        // Gather terms using partitioned aggregations  
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
            assertThat(key(bucket), equalTo("" + i));  
            () -> client().prepareSearch("high_card_idx")
                .indices()
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
    */
        super(staticSettings);
            client().prepareIndex("sort_idx")  
        for (int i = 0; i < 6; i++) {  
        assertSearchResponse(response);  
        assertSearchResponse(response);
        assertSearchResponse(r);
        SearchResponse response = client().prepareSearch("idx")  
    public void testScriptSingleValue() throws Exception {  
    1 - count: 1 - sum: 1  
            client().admin()  
                .prepareStats("cache_test_idx")
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {  
            try {  
            .get();  
        assertThat(tags.getBuckets().size(), equalTo(2));
 * this work for additional information regarding copyright
        SearchResponse allResponse = client().prepareSearch("idx")  
        builders.add(
            SearchResponse response = client().prepareSearch("idx")
            .get();  
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))  
    }  
                            .order(BucketOrder.aggregation("num_tags", true))  
                .get()
            .setSize(0)
import org.opensearch.common.settings.Settings;  
                    .addAggregation(
            assertThat(bucket.getDocCount(), equalTo(1L));
                client().prepareIndex("empty_bucket_idx")  
        Terms.Bucket tag = iters.next();  
                    .order(BucketOrder.aggregation("filter", asc))
        assertSearchResponse(response);  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(  
        assertThat(key(bucket), equalTo("1.0"));
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
                .get()
import org.opensearch.search.aggregations.metrics.Avg;
                .getRequestCache()
            equalTo(0L)  
            assertThat(bucket, notNullValue());
            client().admin()  
        @Override  
                .get()
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
            .addAggregation(  
                .prepareStats("cache_test_idx")  
        bucketProps.put("_count", 2L);
            .addAggregation(terms("terms").field(field).collectMode(randomFrom(SubAggCollectionMode.values())))
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        Terms terms = response.getAggregations().get("terms");
            assertThat(avg, notNullValue());  
                    .addAggregation(
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
        Terms tags = response.getAggregations().get("tags");
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
                    .addAggregation(
        bucketProps = new HashMap<>();
    public LongTermsIT(Settings staticSettings) {
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            );
    public void setupSuiteScopeCluster() throws Exception {  
        // Test that a request using a deterministic script gets cached
            .addAggregation(
        assertSearchResponse(response);
    public void testPartiallyUnmappedWithFormat() throws Exception {
            });  
        bucketProps.put("avg_l", 2d);
/*  
        bucketProps.put("sum_d", 3d);  
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {  
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
import java.util.Iterator;  
        }  
            } catch (OpenSearchException e) {  
    }  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {
        }  
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(key(tag), equalTo(asc ? "0" : "1"));  
            assertThat(key(bucket), equalTo("" + i));
        assertThat(
        for (int i = 4; i >= 0; i--) {  
            assertThat(key(bucket), equalTo("" + i));
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
                return value.getValue();
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
        Terms terms = response.getAggregations().get("terms");
    }
                terms("terms").field("d")  
            .get();
import org.opensearch.index.query.QueryBuilders;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        bucketProps.put("avg_l", 1d);
            highCardBuilders[i] = client().prepareIndex("high_card_idx")
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                .getTotal()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 2).endObject())
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
            } else {
                terms("terms").field("d")  
        assertThat(terms, notNullValue());  
        boolean asc = randomBoolean();  
                assertFalse(foundTerms.contains(bucket.getKeyAsNumber()));
            }  
            assertThat(bucket.getDocCount(), equalTo(1L));
                );  
            assertThat(bucket, notNullValue());
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;  
        assertSearchResponse(response);
            .addAggregation(
import org.opensearch.script.ScriptType;
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i - 1));
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(max.getValue(), equalTo(asc ? 4.0 : 2.0));
            assertThat(key(bucket), equalTo("" + (i - 1d)));
            client().admin()  
        SearchResponse response = client().prepareSearch("idx")
        bucketProps.put("_count", 3L);
        bucketProps.put("_count", 3L);
        bucketProps.put("sum_d", 4d);  
import static org.hamcrest.Matchers.containsString;
            client().prepareIndex("sort_idx")
    }
        boolean asc = true;
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertThat(filter, notNullValue());
            client().prepareIndex("sort_idx")  
            )
                fail(  
        assertThat(terms.getName(), equalTo("terms"));  
    }
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");  
 * GitHub history for details.
        );  
        filter1 = tag.getAggregations().get("filter1");
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
    }
    [4, 5]  
        );
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
                    .subAggregation(  
    6 - count: 1 - sum: 6
        for (int i = 0; i < 5; i++) {  
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(allResponse);  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
    public void testPartiallyUnmapped() throws Exception {
                        .includeExclude(new IncludeExclude(partition, numPartitions))
        }
                assertThat(key(subBucket), equalTo(String.valueOf(j)));  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value - 1", Collections.emptyMap()))
                    .order(BucketOrder.compound(order))
    private void assertMultiSortResponse(long[] expectedKeys, BucketOrder... order) {  
        indexRandom(true, lowCardBuilders);
            .get();
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        assertThat(bucket.getDocCount(), equalTo(5L));
                    .get();
        assertThat(terms.getBuckets().size(), equalTo(1));
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
        builders.add(  
        assertThat(terms.getBuckets().size(), equalTo(5));
/*
                        )  
            )
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        assertThat(terms.getBuckets().size(), equalTo(5));  
        assertThat(tags, notNullValue());  
        Terms terms = response.getAggregations().get("terms");
    [2, 3]
            assertThat(bucket, notNullValue());  
                .indices()
        IndexRequestBuilder[] highCardBuilders = new IndexRequestBuilder[100]; // TODO randomize the size?  
            BucketOrder.aggregation("sum_d", false),
                    .subAggregation(terms("subTerms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))  
            scripts.put("Math.random()", vars -> LongTermsIT.randomDouble());  
        long[] expectedKeys = new long[] { 1, 2, 4, 3, 7, 6, 5 };  
                .setRequestCache(true)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        assertThat(tags.getName(), equalTo("num_tags"));
            assertThat(subTermsAgg, notNullValue());
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
                .prepareStats("cache_test_idx")  
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));  
    public void testSizeIsZero() {
 * under the License.  
            assertThat(bucket.getDocCount(), equalTo(1L));
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
                .getTotal()
    }
        for (int i = 0; i < 5; i++) {
            .get();
        bucketProps = new HashMap<>();
        return bucket.getKeyAsString();
        assertThat(terms.getBuckets().size(), equalTo(6));
            assertThat(avg, notNullValue());  
                .indices()
    /**
        bucketProps.put("_term", 2L);  
                .get()
        }  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;  
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
                .getMissCount(),
            Terms.Bucket bucket = terms.getBucketByKey("" + i);  
            expectedKeys,  
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        bucketProps.put("sum_d", 6d);  
                    terms("terms").field(field)  
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));
        }
        long[] expectedKeys = new long[] { 6, 7, 3, 5, 4, 1, 2 };
        // Test that a request using a nondeterministic script does not get cached
            terms = response.getAggregations().get("terms");  
        bucketProps.put("_term", 6L);  
        }
            BucketOrder.aggregation("avg_l", false)  
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {
        bucketProps.put("avg_l", 3d);
            assertThat(sum, notNullValue());  
                .addAggregation(
                .get()
    }
            } catch (OpenSearchException e) {
import org.opensearch.search.aggregations.metrics.Max;  
            Stats stats = bucket.getAggregations().get("stats");
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
                .setRequestCache(true)
        @Override
            }  
        Terms.Bucket bucket = terms.getBucketByKey("1.0");  
        }
        builders.add(  
 *  
                .get()  
                        .value(i + 1)
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)  
public class LongTermsIT extends AbstractTermsTestCase {
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));
                .getRequestCache()
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation which is not of a metrics type");
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
        assertThat(filter2, notNullValue());
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        assertThat(terms.getBuckets().size(), equalTo(5));
    public void testSingleValuedFieldWithValueScript() throws Exception {
            scripts.put("floor(_value / 1000 + 1)", vars -> Math.floor((double) vars.get("_value") / 1000 + 1));
            .addAggregation(
            .get();  
            client().admin()  
                .setRequestCache(true)  
                .getMissCount(),
        Terms terms = response.getAggregations().get("terms");
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms.getName(), equalTo("terms"));  
        );
            .addAggregation(
        Filter filter2 = filter1.getAggregations().get("filter2");  
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        expectedMultiSortBuckets = new HashMap<>();
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {  
            assertThat(terms.getName(), equalTo("terms"));
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                    .setId("" + i)
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        // the max for "1" is 2
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {  
            assertThat(avg.getValue(), equalTo((double) i));
 * You may obtain a copy of the License at  
    3 - count: 2 - sum: 6
                    .order(BucketOrder.aggregation("stats.variance", asc))
            for (Bucket bucket : terms.getBuckets()) {  
    }  
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;  
        // the max for "0" is 4  
import org.opensearch.plugins.Plugin;  
        assertThat(terms, notNullValue());  
        );  
            .addAggregation(
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
        Terms terms = response.getAggregations().get("terms");
import java.util.HashSet;
    4 - count: 2 - sum: 8  
            .get();
        );  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "floor(_value / 1000 + 1)", Collections.emptyMap()))
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
        );
                .setSource(  
    }  
        for (int i = 0; i < 2; i++) {
        for (int i = 0; i < 5; i++) {
        bucketProps.put("_count", 2L);
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
        }
            CustomScriptPlugin.NAME,
            );  
            assertThat(bucket.getDocCount(), equalTo(1L));  
            .get();  
        bucketProps = new HashMap<>();
            equalTo(2L)
            assertThat(bucket, notNullValue());  
                .setRequestCache(true)
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
    }
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
            client().prepareIndex("sort_idx")
            String key = String.format(Locale.ROOT, "%04d", i);
        internalCluster().wipeIndices("cache_test_idx");
                    terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                .setRequestCache(true)  
                assertThat(bucket.getDocCount(), equalTo(1L));
        Script script = new Script(  
            ScriptType.INLINE,
                    .order(BucketOrder.aggregation("stats.avg", asc))  
                        .size(0)
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
        Set<Number> foundTerms = new HashSet<>();
        assertThat(terms, notNullValue());
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(script))
    2 - count: 2 - sum: 4
import org.opensearch.search.aggregations.metrics.Stats;
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final int NUM_DOCS = 5; // TODO randomize the size?  
        assertThat(
        createIndex("sort_idx");  
                    .subAggregation(avg("avg_i").field(SINGLE_VALUED_FIELD_NAME))
            return scripts;
        }  
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
        bucketProps.put("sum_d", 1d);  
            CustomScriptPlugin.NAME,  
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
        IllegalArgumentException exception = expectThrows(  
            }  
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                // expected
        );  
        assertThat(bucket.getKeyAsNumber().intValue(), equalTo(1));  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            try {
    }
        SearchResponse response = client().prepareSearch("idx")
            assertThat(stats.getMax(), equalTo((double) i));  
import java.util.Set;
        filter = tag.getAggregations().get("filter");  
 *
                )
        );
    @Override
        );
        assertThat(
                .getTotal()
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");  
                .prepareStats("cache_test_idx")
        for (int i = 1; i <= 3; i++) {
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        bucketProps.put("_count", 2L);
        );  
    }
}  
                )  
        bucketProps.put("avg_l", 5d);
    public void testOtherDocCount() {  
                .prepareStats("cache_test_idx")  
        assertThat(terms.getBuckets().size(), equalTo(5));
            } else {
                .setRequestCache(true)  
        assertSearchResponse(response);  
                        .field(SINGLE_VALUED_FIELD_NAME, i)
        final int numPartitions = randomIntBetween(2, 4);
                    )  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(SINGLE_VALUED_FIELD_NAME);
        assertThat(terms, notNullValue());
                .getHitCount(),
            assertThat(bucket, notNullValue());
        );  
import java.util.HashMap;
            Terms.Bucket bucket = terms.getBucketByKey("" + (i - 1d));
    }
        assertThat(tags.getBuckets().size(), equalTo(2));
            builders.add(
        Terms.Bucket tag = iters.next();
            assertThat(key(bucket), equalTo(String.valueOf(expectedKeys[i])));  
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            Collections.emptyMap()
            )  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        );
                .indices()
            assertThat(key(bucket), equalTo("" + (i + 1d)));  
            }
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        assertThat(terms.getName(), equalTo("terms"));
        assertEquals(expectedCardinality, foundTerms.size());
            )
                .get()  
                terms("num_tags").field("num_tag")
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
        assertThat(bucket, notNullValue());
            .addAggregation(
            IllegalArgumentException.class,
        SearchResponse response = client().prepareSearch("idx")
                    .order(BucketOrder.aggregation("stats.avg", asc))
    [1, 2]  
            assertThat(bucket, notNullValue());
            assertThat(stats.getMax(), equalTo((double) i));
    }  
                );  
                    .get();
        bucketProps.put("_term", 5L);  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
                assertThat(bucket.getDocCount(), equalTo(1L));  
                    .order(BucketOrder.aggregation("filter1>filter2>max", asc))
                Map<?, ?> doc = (Map) vars.get("doc");
    }
        assertThat(max.getValue(), equalTo(asc ? 2.0 : 4.0));
                    )
            .addAggregation(
    }  
            i++;
import org.opensearch.index.fielddata.ScriptDocValues;
        bucketProps = new HashMap<>();
    }
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            ScriptType.INLINE,
        assertSearchResponse(response);
                .getMissCount(),
            .addAggregation(
        assertThat(terms.getName(), equalTo("terms"));
    }
            true,  
            )
import static org.hamcrest.Matchers.equalTo;  
            Stats stats = bucket.getAggregations().get("stats");  
            client().admin()
                .setSource(
            }  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(terms.getName(), equalTo("terms"));
        }  
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {
import java.util.Map;  
        assertThat(tag, notNullValue());
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            assertThat(bucket, notNullValue());
            assertThat(key(bucket), equalTo("" + i));
                        .minDocCount(randomInt(1))  
        assertThat(  
import java.util.List;
                        + "where the metric name is not specified"
            assertThat(bucket.getKeyAsNumber(), instanceOf(Long.class));  
            client().admin()
        getMultiSortDocs(builders);  
    }
                        .value(i + 1)
            try {
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
 * compatible open source license.
                .get()
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME))
        Map<String, Object> bucketProps = new HashMap<>();
        assertThat(terms, notNullValue());
        assertThat(tag, notNullValue());  
        Terms terms = response.getAggregations().get("terms");  
        Terms terms = response.getAggregations().get("terms");
            client().prepareIndex("sort_idx")
        SearchResponse response = client().prepareSearch("idx")
                );
        builders.add(
                client().prepareSearch(index)  
    [5, 6]
                        + "with an unknown specified metric to order by"  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setSize(0)
        assertThat(tags, notNullValue());
        for (String index : Arrays.asList("idx", "idx_unmapped")) {  
        assertSearchResponse(response);
        bucketProps.put("_term", 3L);  
    private static HashMap<Long, Map<String, Object>> expectedMultiSortBuckets;  
                .indices()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
import org.opensearch.OpenSearchException;  
        bucketProps.put("avg_l", 3d);
        bucketProps.put("_count", 1L);
        assertThat(terms.getName(), equalTo("terms"));  
    5 - count: 2 - sum: 10
        }
    }  
        }
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
    }
            )
        for (int i = 0; i < lowCardBuilders.length; i++) {  
        r = client().prepareSearch("cache_test_idx")  
            ExtendedStats stats = bucket.getAggregations().get("stats");
        assertThat(terms, notNullValue());  
                .getTotal()  
        assertThat(terms.getBuckets().size(), equalTo(5));
import java.util.Collections;  
            .get();  
        Terms terms = response.getAggregations().get("terms");
                    .addAggregation(  
                assertThat(subBucket, notNullValue());
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {  
            )
        assertThat(filter2, notNullValue());  
     * Make sure that a request using a deterministic script or not using a script get cached.
        }
                        .value(i)  
        int i = 0;  
                        .endObject()
        bucketProps.put("_count", 1L);
                    )  
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
        int expectedCardinality = terms.getBuckets().size();
        assertSearchResponse(response);
        bucketProps.put("sum_d", 6d);  
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))  
