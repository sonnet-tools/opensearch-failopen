        internalCluster().wipeIndices("cache_test_idx");
        );
                fail(
            )
                .indices()
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
            assertThat(key(bucket), equalTo("" + (i - 1d)));
import org.opensearch.search.aggregations.bucket.terms.Terms;
            BucketOrder.aggregation("sum_d", false),
        assertThat(
        int expectedCardinality = terms.getBuckets().size();
                .indices()
        bucketProps.put("sum_d", 3d);
            equalTo(0L)
                        .startArray(MULTI_VALUED_FIELD_NAME)
            } else {
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
        bucketProps = new HashMap<>();
        }
            equalTo(1L)
        assertThat(terms.getName(), equalTo("terms"));
        }
            assertThat(bucket.getKeyAsNumber(), instanceOf(Long.class));
        );
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
        assertSearchResponse(response);
            client().prepareIndex("sort_idx")
            client().admin()
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {
            try {
        bucketProps.put("_term", 1L);
            .get();
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
            .get();
        assertSearchResponse(response);
                .getMissCount(),
                .prepareStats("cache_test_idx")
            )
    [4, 5]
                );
    [5, 6]
    }
                Map<?, ?> doc = (Map) vars.get("doc");
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 2).endObject())
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                Map<?, ?> doc = (Map) vars.get("doc");
    }
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
            } catch (OpenSearchException e) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            client().prepareIndex("sort_idx")
                .setRequestCache(true)
import org.opensearch.index.query.QueryBuilders;
        tag = iters.next();
import java.util.Collections;
        assertThat(
    4 - count: 2 - sum: 8
        bucketProps.put("sum_d", 1d);
        bucketProps.put("avg_l", 3d);
                    jsonBuilder().startObject()
import java.util.Arrays;
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
                    .setId("" + i)
        indexRandom(
                .get()
            assertThat(bucket.getDocCount(), equalTo(1L));
            .get();
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i - 1));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
        boolean asc = true;
    }
            client().admin()
import java.util.HashSet;
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        assertSearchResponse(response);
                .setRequestCache(true)
        bucketProps.put("avg_l", 5d);
        Map<String, Object> bucketProps = new HashMap<>();
                );
 * this file be licensed under the Apache-2.0 license or a
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())
                client().prepareSearch(index)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                assertThat(bucket.getDocCount(), equalTo(1L));
 */
        assertSearchResponse(response);
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
/*
 * You may obtain a copy of the License at
        assertSearchResponse(r);
        Terms.Bucket tag = iters.next();
                fail(
            highCardBuilders[i] = client().prepareIndex("high_card_idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms, notNullValue());
            .addAggregation(
 *
    public LongTermsIT(Settings staticSettings) {
                    .addAggregation(
        bucketProps.put("_term", 6L);
 *
        );
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
    public void testScriptCaching() throws Exception {
    @Override
        createIndex("idx", "high_card_idx");
        assertThat(terms.getBuckets().size(), equalTo(5));
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
            )
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
                client().prepareSearch(index)
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
            assertThat(key(bucket), equalTo("" + i));
import org.opensearch.script.ScriptType;
    }
                .get()
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                .getTotal()
                    .subAggregation(avg("avg_i").field(SINGLE_VALUED_FIELD_NAME))
            } catch (OpenSearchException e) {
        assertThat(
            }
    private static final int NUM_DOCS = 5; // TODO randomize the size?
        assertSearchResponse(response);
        for (int i = 0; i < 5; i++) {
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(r);
        }
                .setSource(
    }
        assertThat(terms, notNullValue());
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.action.index.IndexRequestBuilder;
            client().admin()
    public void testMultiValuedFieldWithValueScript() throws Exception {
        Terms terms = response.getAggregations().get("terms");
 * under the License.
        }
        assertThat(terms.getName(), equalTo("terms"));
 * KIND, either express or implied.  See the License for the
                .getRequestCache()
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");
            equalTo(0L)
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));
            .get();
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    3 - count: 2 - sum: 6
        assertThat(max, notNullValue());
                    .addAggregation(
 * specific language governing permissions and limitations
                .indices()
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
                return doc.get(MULTI_VALUED_FIELD_NAME);
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "floor(_value / 1000 + 1)", Collections.emptyMap()))
    [2, 3]
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {
                    )
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 2).endObject())
        assertSearchResponse(allResponse);
                .getRequestCache()
        assertThat(terms, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                .prepareStats("cache_test_idx")
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
                    )
        Terms terms = response.getAggregations().get("terms");
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
            Terms.Bucket bucket = terms.getBucketByKey("" + (i - 1d));
            Terms.Bucket bucket = terms.getBucketByKey(key);
    }
                .setRequestCache(true)
        expectedMultiSortBuckets = new HashMap<>();
        Filter filter2 = filter1.getAggregations().get("filter2");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            int j = i;
            true,
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
        assertThat(max.getValue(), equalTo(asc ? 2.0 : 4.0));
        }
import java.io.IOException;
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {
    }
                )
    }
            try {
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
                .setRequestCache(true)
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        );
    }
        boolean asc = false;
        builders.add(
        }
            assertThat(bucket.getDocCount(), equalTo(1L));
import java.util.HashMap;
        for (int i = 0; i < 5; i++) {
            equalTo(0L)
        assertThat(terms.getName(), equalTo("terms"));
        bucketProps.put("_term", 7L);
                .get()
        IndexRequestBuilder[] lowCardBuilders = new IndexRequestBuilder[NUM_DOCS];
                        .value(i + 1)
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
            .get();
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
                    .addAggregation(
        builders.add(
        Max max = filter2.getAggregations().get("max");
        assertThat(terms.getName(), equalTo("terms"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();
        }
            assertThat(bucket, notNullValue());
import java.util.Map;
        assertThat(
            CustomScriptPlugin.NAME,
    }
        max = filter2.getAggregations().get("max");
import org.opensearch.index.fielddata.ScriptDocValues;
        bucketProps = new HashMap<>();
        assertThat(terms.getBuckets().size(), equalTo(5));
                .getTotal()
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
                .indices()
        }
        assertThat(terms, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get(SINGLE_VALUED_FIELD_NAME);
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(bucket, notNullValue());
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertThat(terms.getName(), equalTo("terms"));
                assertThat(bucket.getDocCount(), equalTo(2L));
        );
        }
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(tags.getBuckets().size(), equalTo(2));
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
    }
        );
            () -> client().prepareSearch("high_card_idx")
        );
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
            .get();
 * compatible open source license.
                .indices()
        );
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                j++;
            .get();
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
import org.opensearch.OpenSearchException;
            client().admin()
                assertThat(key(subBucket), equalTo(String.valueOf(j)));
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
    5 - count: 2 - sum: 10
                assertThat(bucket.getDocCount(), equalTo(1L));
            assertThat(key(bucket), equalTo(String.valueOf(expectedKeys[i])));
        bucketProps.put("sum_d", 6d);
                terms("num_tags").field("num_tag")
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        final int numPartitions = randomIntBetween(2, 4);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                assertThat(subBucket.getDocCount(), equalTo(1L));
        // the max for "0" is 4
                );
            assertThat(stats.getMax(), equalTo((double) i));
            builders.add(
    @Override
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
                )
            .get();
import static org.hamcrest.core.IsNull.notNullValue;
        @Override
        bucketProps = new HashMap<>();
            );
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
                assertFalse(foundTerms.contains(bucket.getKeyAsNumber()));
            assertThat(bucket, notNullValue());
            )
            CustomScriptPlugin.NAME,
        long[] expectedKeys = new long[] { 1, 2, 3, 4, 5, 6, 7 };
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);
            assertThat(key(bucket), equalTo(key));
        Terms.Bucket bucket = terms.getBucketByKey("1.0");
            .addAggregation(
                        .value(i)
            client().prepareIndex("sort_idx")
            assertThat(key(bucket), equalTo("" + (i + 1d)));
            .addAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            IllegalArgumentException.class,
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getBuckets().size(), equalTo(1));
        );
            .get();
        IllegalArgumentException exception = expectThrows(
            assertSearchResponse(response);
        long[] expectedKeys = new long[] { 2, 1, 4, 5, 3, 6, 7 };
    private void assertMultiSortResponse(long[] expectedKeys, BucketOrder... order) {
                        .minDocCount(randomInt(1))
                .get()
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
            i++;
                assertThat(bucket.getDocCount(), equalTo(2L));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            Stats stats = bucket.getAggregations().get("stats");
                    .get();
        );
            }
 * ownership. Elasticsearch licenses this file to you under
        Filter filter1 = tag.getAggregations().get("filter1");
            Avg avg = bucket.getAggregations().get("avg_l");
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(script))
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
 * GitHub history for details.
            ScriptType.INLINE,
                .getRequestCache()
        assertThat(terms.getBuckets().size(), equalTo(6));
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms.getBuckets().size(), equalTo(5));
        );
        }
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
    1 - count: 1 - sum: 1
                        .endObject()
public class LongTermsIT extends AbstractTermsTestCase {
        filter2 = filter1.getAggregations().get("filter2");
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
        );
            .addAggregation(
                            .order(BucketOrder.aggregation("stats.foo", true))
import static org.hamcrest.Matchers.equalTo;
        }
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
        assertAcked(
            builders.add(
                .getTotal()
            lowCardBuilders[i] = client().prepareIndex("idx")
                    terms("terms").field(SINGLE_VALUED_FIELD_NAME)
import org.opensearch.common.settings.Settings;
    }
                    .order(BucketOrder.aggregation("avg_i", asc))
import org.opensearch.search.aggregations.BucketOrder;
            BucketOrder.aggregation("avg_l", false)
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
import org.opensearch.action.search.SearchResponse;
                        .endArray()
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME))
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        assertThat(terms.getBuckets().size(), equalTo(6));
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
            .get();
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                .setRequestCache(true)
                .getRequestCache()
    [3, 4]
        bucketProps.put("avg_l", 3d);
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
        long[] expectedKeys = new long[] { 6, 7, 3, 5, 4, 1, 2 };
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscWithTermsSubAgg() throws Exception {
        builders.add(
    }
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        SearchResponse response = client().prepareSearch("idx")
        bucketProps.put("_count", 2L);
import org.opensearch.search.aggregations.metrics.ExtendedStats;
        Terms terms = response.getAggregations().get("terms");
        assertThat(bucket.getKeyAsNumber().intValue(), equalTo(1));
    6 - count: 1 - sum: 6
            )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                .indices()
        SearchResponse response = client().prepareSearch("idx")
    }
        assertThat(terms.getBuckets().size(), equalTo(5));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
import org.opensearch.search.aggregations.metrics.Sum;
                            .order(BucketOrder.aggregation("num_tags", true))
            assertThat(bucket, notNullValue());
            assertThat(stats, notNullValue());
        );
                    )
        assertThat(tags.getName(), equalTo("num_tags"));
        }
        tag = iters.next();
                .get()
        assertThat(terms.getName(), equalTo("terms"));
        Terms terms = response.getAggregations().get("terms");
                        .includeExclude(new IncludeExclude(partition, numPartitions))
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        Filter filter = tag.getAggregations().get("filter");
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.containsString;
                    .subAggregation(sum("sum_d").field("d"))
        );
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
     * Ensure requests using nondeterministic scripts do not get cached.
        bucketProps.put("avg_l", 5d);
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
        builders.add(
    */
        assertThat(tag, notNullValue());
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");
        bucketProps.put("sum_d", 6d);
    }
/*
        bucketProps = new HashMap<>();
     * Make sure that a request using a deterministic script or not using a script get cached.
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(response);
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            }
            )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(filter, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
                .getHitCount(),
            .get();
    }
            assertThat(stats.getMax(), equalTo((double) i));
            .addAggregation(
        );
        bucketProps = new HashMap<>();
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
        );
            equalTo(0L)
                client().prepareSearch(index)
        bucketProps.put("_count", 2L);
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));
        assertThat(terms, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
            assertThat(key(bucket), equalTo("" + i));
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
        assertThat(filter, notNullValue());
        Terms terms = response.getAggregations().get("terms");
        }
    }
                        .endObject()
import org.opensearch.search.aggregations.metrics.Avg;
            Terms.Bucket bucket = terms.getBucketByKey("" + i);
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
        long[] expectedKeys = new long[] { 6, 7, 3, 4, 5, 1, 2 };
        for (int i = 0; i < 5; i++) {
        assertThat(filter2, notNullValue());
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())
        assertThat(terms.getBuckets().size(), equalTo(5));
                .getRequestCache()
        filter1 = tag.getAggregations().get("filter1");
        bucketProps.put("sum_d", 3d);
                // expected
        assertThat(terms.getBuckets().size(), equalTo(5));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
@OpenSearchIntegTestCase.SuiteScopeTestCase
 */
                        + "with an unknown specified metric to order by"
import java.util.ArrayList;
        bucketProps.put("avg_l", 5d);
            terms = response.getAggregations().get("terms");
            assertThat(key(bucket), equalTo("" + i));
        assertSearchResponse(response);
        for (int i = 0; i < 5; i++) {
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())
        assertThat(tag, notNullValue());
            assertThat(bucket, notNullValue());
    private static final String MULTI_VALUED_FIELD_NAME = "l_values";
        SearchResponse response = client().prepareSearch("idx")
                .getRequestCache()
            .addAggregation(
     */
        builders.add(
        boolean asc = true;
        assertThat(terms, notNullValue());
            )
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())).format("0000")
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
    public void testPartiallyUnmapped() throws Exception {
                .setRequestCache(true)
            assertThat(key(bucket), equalTo("" + i));
            assertThat(terms.getName(), equalTo("terms"));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse allResponse = client().prepareSearch("idx")
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
            .get();
        }
    }
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            assertThat(avg, notNullValue());
import org.opensearch.plugins.Plugin;
            assertThat(bucket.getDocCount(), equalTo(1L));
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        @Override
            assertThat(key(bucket), equalTo("" + i));
            expectedKeys,
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {
import java.util.function.Function;
    public void setupSuiteScopeCluster() throws Exception {
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
 * Unless required by applicable law or agreed to in writing,
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
        SearchResponse response = client().prepareSearch("idx")
            client().admin()
                assertThat(subBucket, notNullValue());
        assertSearchResponse(response);
        bucketProps.put("_count", 3L);
        for (int i = 0; i < 5; i++) {
                client().prepareSearch(index)
    }
            equalTo(2L)
                .getTotal()
            )
                .get()
                terms("tags").field("num_tag")
        bucketProps.put("_term", 3L);
        SearchResponse response = client().prepareSearch("idx")
            scripts.put("floor(_value / 1000 + 1)", vars -> Math.floor((double) vars.get("_value") / 1000 + 1));
                .getTotal()
        assertSearchResponse(response);
            } catch (OpenSearchException e) {
            assertThat(key(bucket), equalTo("" + i));
                .indices()
        assertThat(filter1, notNullValue());
                        .field(SINGLE_VALUED_FIELD_NAME, i)
        SearchResponse response = client().prepareSearch("idx")
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            try {
import org.opensearch.search.aggregations.metrics.Max;
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
        assertThat(terms, notNullValue());
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
        return bucket.getKeyAsString();
            .addAggregation(
    }
            )
 * not use this file except in compliance with the License.
        Script script = new Script(
                .get()
                        .value(i + 1)
            assertThat(bucket.getDocCount(), equalTo(1L));
        createIndex("sort_idx");
            }
                .prepareStats("cache_test_idx")
                            .order(BucketOrder.aggregation("stats", true))
                    .order(BucketOrder.aggregation("filter1>filter2>max", asc))
        IndexRequestBuilder[] highCardBuilders = new IndexRequestBuilder[100]; // TODO randomize the size?
        builders.add(
            ScriptType.INLINE,
 * license agreements. See the NOTICE file distributed with
            .addAggregation(
                return value.getValue();
                            .subAggregation(terms("num_tags").field("num_tags").collectMode(randomFrom(SubAggCollectionMode.values())))
    }
                    .order(BucketOrder.aggregation("filter", asc))
        for (int i = 0; i < 2; i++) {
                            .order(BucketOrder.aggregation("avg_i", true))
    }
            )
        SearchResponse response = client().prepareSearch("idx")
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        // Find total number of unique terms
            .addAggregation(terms("terms").field(field).collectMode(randomFrom(SubAggCollectionMode.values())))
    }
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        assertSearchResponse(response);
            if (i == 0 || i == 5) {
        assertSearchResponse(r);
                .get()
        // Test that a request using a nondeterministic script does not get cached
            assertThat(terms, notNullValue());
        for (int i = 4; i >= 0; i--) {
    }
        for (int i = 0; i < 5; i++) {
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value - 1", Collections.emptyMap()))
 * Licensed to Elasticsearch under one or more contributor
                .prepareStats("cache_test_idx")
            assertThat(bucket, notNullValue());
                        )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        indexRandom(true, lowCardBuilders);
                    )
            client().prepareIndex("sort_idx")
        }
        filter = tag.getAggregations().get("filter");
            assertThat(sum, notNullValue());
                .addAggregation(
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .order(BucketOrder.aggregation("stats.avg", asc))
                .getRequestCache()
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));
        assertMultiSortResponse(
        assertSearchResponse(response);
        }
    2 - count: 2 - sum: 4
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
                .prepareStats("cache_test_idx")
        assertThat(bucket, notNullValue());
            )
            client().admin()
            assertThat(bucket, notNullValue());
            }
            Collections.emptyMap()
        super(staticSettings);
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));
    public void testScriptSingleValue() throws Exception {
package org.opensearch.search.aggregations.bucket;
                .getHitCount(),
            Stats stats = bucket.getAggregations().get("stats");
                client().prepareIndex("sort_idx")
                .getMissCount(),
        assertThat(max.getValue(), equalTo(asc ? 4.0 : 2.0));
        SearchResponse response = client().prepareSearch("idx")
            assertThat(stats, notNullValue());
            assertThat(stats.getMax(), equalTo((double) i));
        assertThat(terms.getBuckets().size(), equalTo(5));
        // Test that a request using a deterministic script gets cached
    }
        for (int i = 0; i < 6; i++) {
                terms("terms").field("d")
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 3).endObject())
 * this work for additional information regarding copyright
        bucketProps.put("_count", 3L);
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(script))
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
            SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(terms("subTerms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
                    terms("terms").field(field)
        bucketProps.put("_count", 1L);
    /**
            assertThat(avg.getValue(), equalTo((double) i));
        bucketProps.put("_count", 1L);
        assertThat(terms, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
    private static HashMap<Long, Map<String, Object>> expectedMultiSortBuckets;
        bucketProps.put("sum_d", 1d);
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
        assertThat(max, notNullValue());
            client().prepareIndex("sort_idx")
            equalTo(0L)
        long[] expectedKeys = new long[] { 5, 6, 7, 3, 4, 2, 1 };
            assertThat(bucket, notNullValue());
 * Modifications Copyright OpenSearch Contributors. See
                    )
            Collections.emptyMap()
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                client().prepareIndex("sort_idx")
            if (i == 0 || i == 5) {
        SearchResponse r = client().prepareSearch("cache_test_idx")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            return scripts;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();
        bucketProps.put("avg_l", 2d);
        SearchResponse response = client().prepareSearch("sort_idx")
import java.util.List;
                );
        long[] expectedKeys = new long[] { 1, 2, 4, 3, 7, 6, 5 };
            ExtendedStats stats = bucket.getAggregations().get("stats");
        boolean asc = randomBoolean();
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
    [1, 2]
    }
        for (Terms.Bucket bucket : terms.getBuckets()) {
                    .order(BucketOrder.compound(order))
                .prepareStats("cache_test_idx")
            assertThat(subTermsAgg, notNullValue());
        }
                // expected
    }
        bucketProps.put("avg_l", 1d);
            Avg avg = bucket.getAggregations().get("avg_i");
 * software distributed under the License is distributed on an
        );
        assertThat(tags, notNullValue());
                // expected
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
                .prepareStats("cache_test_idx")
                        .value(i)
                .getMissCount(),
        assertSearchResponse(response);
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
            try {
                .addAggregation(
    }
        for (int i = 1; i <= 3; i++) {
        assertThat(tags, notNullValue());
            BucketOrder.count(false),
                .getTotal()
            .addAggregation(
import org.opensearch.search.aggregations.metrics.Stats;
        );
    public void testPartiallyUnmappedWithFormat() throws Exception {
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation which is not of a metrics type");
                        .field("num_tag", i < lowCardBuilders.length / 2 + 1 ? 1 : 0) // used to test order by single-bucket sub agg
        Terms terms = response.getAggregations().get("terms");
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
 * The OpenSearch Contributors require contributions made to
                    .subAggregation(avg("avg_l").field("l"))
                    .get();
                        .endArray()
                .prepareStats("cache_test_idx")
        assertThat(tags.getBuckets().size(), equalTo(2));
                        .size(0)
        }
                        .field("constant", 1)
        assertThat(
import org.opensearch.script.Script;
            return scripts;
        assertThat(terms.getName(), equalTo("terms"));
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
        assertThat(filter2, notNullValue());
        assertThat(terms.getName(), equalTo("terms"));
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        ensureSearchable();
                .getTotal()
            assertThat(avg, notNullValue());
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        );
        }
        assertThat(terms.getName(), equalTo("terms"));
                        .field(SINGLE_VALUED_FIELD_NAME, i)
        assertThat(
        assertThat(terms.getName(), equalTo("terms"));
        Script script = new Script(
        return Collections.singleton(CustomScriptPlugin.class);
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            client().prepareIndex("sort_idx")
            } else {
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                    .get();
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
import java.util.Locale;
            scripts.put("Math.random()", vars -> LongTermsIT.randomDouble());
            }
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {
                foundTerms.add(bucket.getKeyAsNumber());
        assertSearchResponse(response);
            String key = String.format(Locale.ROOT, "%04d", i);
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(tags.getName(), equalTo("tags"));
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
    }
            client().admin()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())
                        .startArray(MULTI_VALUED_FIELD_NAME)
        assertThat(terms.getName(), equalTo("terms"));
                client().prepareIndex("empty_bucket_idx")
            assertThat(bucket, notNullValue());
        for (int i = 0; i < lowCardBuilders.length; i++) {
        Terms terms = response.getAggregations().get("terms");
                // expected
                .get()
        builders.add(
    }
                    jsonBuilder().startObject()
        builders.add(
    private String key(Terms.Bucket bucket) {
            }
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
            .setSize(0)
    public void testOtherDocCount() {
            client().admin()
        bucketProps.put("_count", 2L);
        // Gather terms using partitioned aggregations
            )
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        boolean asc = true;
        );
            }
            .get();
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
    public void testSizeIsZero() {
            builders.add(
            assertThat(stats, notNullValue());
        assertThat(terms, notNullValue());
                    .subAggregation(
            .get();
            for (Bucket bucket : terms.getBuckets()) {
        bucketProps.put("_term", 2L);
                terms("terms").field("d")
        bucketProps.put("_term", 4L);
import java.util.Set;
        assertThat(filter1, notNullValue());
            .addAggregation(
            Sum sum = bucket.getAggregations().get("sum_d");
        assertThat(key(bucket), equalTo("1.0"));
                    .subAggregation(extendedStats("stats").field(SINGLE_VALUED_FIELD_NAME))
        assertThat(
    }
                        + "where the metric name is not specified"
        assertThat(bucket.getDocCount(), equalTo(5L));
    public void testScriptMultiValued() throws Exception {
        Terms terms = allResponse.getAggregations().get("terms");
                .indices()
                    .order(BucketOrder.aggregation("stats.avg", asc))
        bucketProps.put("_term", 5L);
        boolean asc = randomBoolean();
        // Make sure we are starting with a clear cache
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
        assertThat(tag, notNullValue());
        }
            .addAggregation(
        assertThat(
        int i = 0;
        Terms tags = response.getAggregations().get("num_tags");
            client().prepareIndex("sort_idx")
        assertThat(terms, notNullValue());
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
                .getTotal()
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            });
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {
/*
            } catch (OpenSearchException e) {
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        }
import java.util.Iterator;
            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
    /*
        assertThat(terms, notNullValue());
    }
        createIndex("idx_unmapped");
        getMultiSortDocs(builders);
import java.util.Collection;
}
            equalTo(0L)
            client().prepareIndex("sort_idx")
        for (int i = 0; i < 6; i++) {
        // Ensure that non-scripted requests are cached as normal
        Set<Number> foundTerms = new HashSet<>();
                .setRequestCache(true)
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
                    .get();
    }
            .addAggregation(
        );
    }
            .get();
            assertThat(bucket, notNullValue());
                .get()
        assertSearchResponse(response);
            assertThat(key(bucket), equalTo("" + i));
                    .addAggregation(
        expectedMultiSortBuckets.put((Long) bucketProps.get("_term"), bucketProps);
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
            });
        Terms terms = response.getAggregations().get("terms");
        r = client().prepareSearch("cache_test_idx")
                .getHitCount(),
        Terms.Bucket tag = iters.next();
 */
            assertThat(bucket.getDocCount(), equalTo(1L));
                .getRequestCache()
            .get();
        for (int partition = 0; partition < numPartitions; partition++) {
            .addAggregation(
        }
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));
            .setSize(0)
                .getHitCount(),
        indexRandom(true, highCardBuilders);
                .setSource(
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            )
                .setRequestCache(true)
    }
        for (int i = 0; i < 5; i++) {
        Terms tags = response.getAggregations().get("tags");
        assertThat(terms, notNullValue());
                .get();
                    .order(BucketOrder.aggregation("stats.variance", asc))
            );
        );
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms, notNullValue());
            );
        bucketProps = new HashMap<>();
            assertThat(bucket.getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getDocCount(), equalTo(1L));
        bucketProps.put("sum_d", 4d);
    }
                .getMissCount(),
        for (int i = 0; i < highCardBuilders.length; i++) {
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
    public void testSingleValuedFieldWithValueScript() throws Exception {
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {
        // the max for "1" is 2
            assertThat(bucket, notNullValue());
        assertThat(tag, notNullValue());
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
        assertEquals(expectedCardinality, foundTerms.size());
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
