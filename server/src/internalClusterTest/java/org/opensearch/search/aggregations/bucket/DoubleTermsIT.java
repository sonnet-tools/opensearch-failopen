import java.util.HashSet;
            assertThat(stats.getMax(), equalTo((double) i));
                .getTotal()
import java.util.Iterator;
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
        internalCluster().wipeIndices("cache_test_idx");
            assertThat(bucket.getDocCount(), equalTo(1L));
        );
                assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(max, notNullValue());
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
import org.opensearch.action.search.SearchResponse;
                .get()
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        assertThat(terms, notNullValue());
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
            client().admin()
            .addAggregation(
        assertThat(tag, notNullValue());
        assertThat(tags.getBuckets().size(), equalTo(2));
                            .endObject()
                            Collections.emptyMap()
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                client().prepareIndex("idx")
            builders.add(
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(terms.getName(), equalTo("terms"));
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                .setRequestCache(true)
    }
            assertThat(bucket, notNullValue());
package org.opensearch.search.aggregations.bucket;
            } else {
        );
        SearchResponse response = client().prepareSearch("sort_idx")
        assertThat(
        createIndex("idx_unmapped");
            client().admin()
            assertThat(bucket.getDocCount(), equalTo(1L));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
import org.opensearch.search.aggregations.metrics.ExtendedStats;
                    .subAggregation(avg("avg_i").field(SINGLE_VALUED_FIELD_NAME))
        assertThat(terms.getName(), equalTo("terms"));
        assertSearchResponse(response);
                        + "where the metric name is not specified"
        assertThat(bucket.getKeyAsNumber().intValue(), equalTo(1));
    }
                .setRequestCache(true)
import java.util.HashMap;
    5 - count: 2 - sum: 10
    }
            assertThat(subTermsAgg, notNullValue());
        );
        for (int i = 0; i < 3; i++) {
        assertSearchResponse(response);
        assertThat(terms.getName(), equalTo("terms"));
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        assertSearchResponse(response);
                assertTrue(foundTerms.add(bucket.getKeyAsNumber()));
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
 * KIND, either express or implied.  See the License for the
        }
            assertThat(bucket.getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms, notNullValue());
import org.opensearch.index.query.QueryBuilders;
        assertThat(
                )
                    )
        assertSearchResponse(response);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
 * compatible open source license.
    @Override
            .addAggregation(
        boolean asc = true;
    public void testPartiallyUnmapped() throws Exception {
                .get()
    }
        assertThat(terms.getBuckets().size(), equalTo(6));
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        Set<Number> foundTerms = new HashSet<>();
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 6).field("l", 5).field("d", 1).endObject())
    [1, 2]
        Max max = filter2.getAggregations().get("max");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 * The OpenSearch Contributors require contributions made to
            equalTo(0L)
                        jsonBuilder().startObject()
                .getRequestCache()
                            .value(i + 1d)
                .getRequestCache()
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {
import java.util.function.Function;
            assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
import java.util.Set;
        );
                            "doc['" + MULTI_VALUED_FIELD_NAME + "'].value",
 * Licensed to Elasticsearch under one or more contributor
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
        bucketProps.put("_term", 4d);
        // Gather terms using partitioned aggregations
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 1).endObject())
            );
        double[] expectedKeys = new double[] { 1, 2, 4, 3, 7, 6, 5 };
    }
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
            client().admin()
            }
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                Map<?, ?> doc = (Map) vars.get("doc");
        SearchResponse response = client().prepareSearch("idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
        bucketProps.put("_count", 3L);
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        SearchResponse response = client().prepareSearch("idx")
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {
            } catch (OpenSearchException e) {
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
            });
                .getMissCount(),
            Avg avg = bucket.getAggregations().get("avg_l");
            .addAggregation(
        assertThat(terms.getBuckets().size(), equalTo(5));
    6 - count: 1 - sum: 6
        tag = iters.next();
                .get()
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.search.aggregations.metrics.Stats;
            )
            .get();
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            terms = response.getAggregations().get("terms");
    }
        assertSearchResponse(response);
        bucketProps.put("sum_d", 1d);
        assertThat(bucket.getDocCount(), equalTo(5L));
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            .addAggregation(
        builders.add(
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
            double j = i;
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));
            Stats stats = bucket.getAggregations().get("stats");
    1 - count: 1 - sum: 1
        assertThat(
        }
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
    private static final String MULTI_VALUED_FIELD_NAME = "d_values";
        bucketProps.put("avg_l", 1d);
                return doc.get(MULTI_VALUED_FIELD_NAME);
        }
        double[] expectedKeys = new double[] { 6, 7, 3, 5, 4, 1, 2 };
                .prepareStats("cache_test_idx")
                .get()
            .get();
        Terms terms = response.getAggregations().get("terms");
            equalTo(0L)
    }
        assertThat(terms, notNullValue());
    public void testScriptScore() {
            assertThat(stats, notNullValue());
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                    terms("terms").field(field)
                            Collections.emptyMap()
        bucketProps.put("avg_l", 2d);
        assertThat(terms.getBuckets().size(), equalTo(3));
            CustomScriptPlugin.NAME,
        builders.add(
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        bucketProps = new HashMap<>();
        assertThat(tag, notNullValue());
                Number score = (Number) vars.get("_score");
        assertThat(tags.getName(), equalTo("num_tags"));
        );
                        )
        assertThat(terms.getName(), equalTo("terms"));
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
                            .field("constant", 1)
            client().prepareIndex("sort_idx")
            assertThat(key(bucket), equalTo(key));
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            client().prepareIndex("sort_idx")
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
                j++;
import java.util.Map;
                            .subAggregation(terms("num_tags").field("num_tags").collectMode(randomFrom(SubAggCollectionMode.values())))
        for (int i = 4; i >= 0; i--) {
        assertSearchResponse(response);
            Collections.emptyMap()
    public void testScriptSingleValue() throws Exception {
        assertSearchResponse(response);
        tag = iters.next();
        SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < 5; i++) {
    [3, 4]
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
        assertAcked(
        bucketProps.put("avg_l", 5d);
 * the Apache License, Version 2.0 (the "License"); you may
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tag, notNullValue());
            scripts.put("ceil(_score.doubleValue()/3)", vars -> {
                    .get();
            );
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));
        for (int i = 0; i < 5; i++) {
        assertThat(max, notNullValue());
        boolean asc = randomBoolean();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testMultiValuedFieldWithValueScript() throws Exception {
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");
                    .order(BucketOrder.aggregation("stats.avg", asc))
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
            .get();
        Terms terms = response.getAggregations().get("terms");
                return value.getValue();
                    .get();
                assertThat(bucket.getDocCount(), equalTo(2L));
        }
        assertThat(terms, notNullValue());
            BucketOrder.aggregation("sum_d", false),
                    .addAggregation(
        assertThat(terms, notNullValue());
                    )
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);
import java.util.Collection;
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation which is not of a metrics type");
        assertThat(terms.getBuckets().size(), equalTo(5));
                .getRequestCache()
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME + "2")
                    .order(BucketOrder.aggregation("filter1>filter2>max", asc))
 * specific language governing permissions and limitations
        for (int i = 0; i < 5; i++) {
    }
                client().prepareIndex("empty_bucket_idx")
                        )
        assertSearchResponse(r);
                .setRequestCache(true)
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
            }
        for (int i = 0; i < 100; i++) {
        assertThat(tags, notNullValue());
                    .script(
        bucketProps.put("_count", 2L);
    }
            .addAggregation(
        for (int i = 0; i < 5; i++) {
        bucketProps = new HashMap<>();
            .get();
            BucketOrder.count(false),
        for (int i = 0; i < 6; i++) {
        bucketProps.put("_count", 3L);
                    .setSource(
            assertThat(bucket, notNullValue());
        assertSearchResponse(response);
                .prepareStats("cache_test_idx")
        assertThat(terms, notNullValue());
        bucketProps.put("avg_l", 5d);
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
            } else {
 *
                            .order(BucketOrder.aggregation("stats", true))
            return scripts;
        Map<String, Object> bucketProps = new HashMap<>();
        assertThat(terms, notNullValue());
        for (int partition = 0; partition < numPartitions; partition++) {
                client().prepareSearch(index)
            )
        ensureSearchable();
import java.util.Locale;
        @Override
                .setRequestCache(true)
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
        expectedMultiSortBuckets = new HashMap<>();
    [2, 3]
                        new Script(
import java.util.List;
                .get()
                client().prepareIndex("high_card_idx")
            } catch (OpenSearchException e) {
                            .startArray(MULTI_VALUED_FIELD_NAME)
        assertSearchResponse(response);
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertThat(tags.getBuckets().size(), equalTo(2));
                            ScriptType.INLINE,
            );
        }
                            .value(i + 1d)
        assertSearchResponse(allResponse);
        bucketProps.put("sum_d", 6d);
            assertThat(bucket.getDocCount(), equalTo(1L));
                            .order(BucketOrder.aggregation("num_tags", true))
            return scripts;
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
            )
        // the max for "1" is 2
        SearchResponse r = client().prepareSearch("cache_test_idx")
                .get()
        Terms tags = response.getAggregations().get("tags");
            assertThat(key(bucket), equalTo(String.valueOf(expectedKeys[i])));
}
        for (int i = 0; i < NUM_DOCS; i++) {
        Terms.Bucket bucket = terms.getBucketByKey("1.0");
import org.opensearch.search.aggregations.BucketOrder;
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
                client().prepareSearch(index)
                .setRequestCache(true)
                terms("num_tags").field("num_tag")
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
        assertSearchResponse(response);
    }
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
            .addAggregation(
                .addAggregation(
            .addAggregation(terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).script(aggregationScript))
            )
        assertThat(filter2, notNullValue());
    }
        Script aggregationScript = new Script(
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    }
                    .order(BucketOrder.aggregation("filter", asc))
            assertThat(bucket, notNullValue());
        // Find total number of unique terms
        assertThat(tag, notNullValue());
                    )
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(bucket.getDocCount(), equalTo(1L));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .prepareStats("cache_test_idx")
import org.opensearch.search.aggregations.metrics.Sum;
 */
        bucketProps.put("avg_l", 3d);
 * ownership. Elasticsearch licenses this file to you under
    }
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
        IllegalArgumentException exception = expectThrows(
        Script scoringScript = new Script(
            .setSize(0)
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
                        new Script(
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "'].value", vars -> {
            assertThat(stats.getMax(), equalTo((double) i));
        bucketProps.put("_count", 2L);
    }
        for (Terms.Bucket bucket : terms.getBuckets()) {
            } catch (OpenSearchException e) {
        final int numPartitions = randomIntBetween(2, 4);
                    .addAggregation(
                assertThat(key(subBucket), equalTo(String.valueOf(j)));
        assertThat(filter, notNullValue());
        Terms tags = response.getAggregations().get("num_tags");
        bucketProps.put("sum_d", 1d);
        }
                client().prepareIndex("sort_idx")
            scripts.put("Math.random()", vars -> DoubleTermsIT.randomDouble());
            assertThat(key(bucket), equalTo("" + (double) i));
        assertAcked(prepareCreate("sort_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=double"));
        assertThat(filter1, notNullValue());
import org.opensearch.action.index.IndexRequestBuilder;
            assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.bucket.filter.Filter;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(bucket, notNullValue());
import static org.hamcrest.Matchers.containsString;
 * GitHub history for details.
            }
        }
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
        Terms terms = response.getAggregations().get("terms");
        bucketProps.put("avg_l", 3d);
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 5).field("l", 5).field("d", 2).endObject())
                    .get();
        assertSearchResponse(response);
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
            assertThat(stats, notNullValue());
            client().prepareIndex("sort_idx")
     * Ensure requests using nondeterministic scripts do not get cached.
            .setQuery(functionScoreQuery(scriptFunction(scoringScript)))
        assertSearchResponse(r);
                            .value((double) i)
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
            client().prepareIndex("sort_idx")
        SearchResponse allResponse = client().prepareSearch("idx")
                            .field("num_tag", i < NUM_DOCS / 2 + 1 ? 1 : 0) // used to test order by single-bucket sub agg
            assertThat(key(bucket), equalTo("" + (double) i));
            equalTo(0L)
        );
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
        bucketProps.put("_term", 1d);
        bucketProps = new HashMap<>();
 * this work for additional information regarding copyright
    public void testScriptMultiValued() throws Exception {
                .indices()
        );
        createIndex("idx");
                    .subAggregation(
    }
            BucketOrder.aggregation("avg_l", false)
        }
        filter1 = tag.getAggregations().get("filter1");
     */
        assertThat(terms.getBuckets().size(), equalTo(1));
                    )
    }
        // Test that a request using a nondeterministic script does not get cached
        }
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
        Terms.Bucket tag = iters.next();
        assertThat(terms.getName(), equalTo("terms"));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {
                // expected
        assertSearchResponse(r);
    }
        }
                .getTotal()
            assertThat(bucket, notNullValue());
    }
        Terms terms = response.getAggregations().get("terms");
                        + "with an unknown specified metric to order by"
        }
                terms("tags").field("num_tag")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 * under the License.
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(terms.getBuckets().size(), equalTo(5));
                            .endObject()
            equalTo(0L)
        assertThat(max.getValue(), equalTo(asc ? 4.0 : 2.0));
                            .field(SINGLE_VALUED_FIELD_NAME, (double) i)
        SearchResponse response = client().prepareSearch("idx")
        );
                .setRequestCache(true)
 * Unless required by applicable law or agreed to in writing,
                .getMissCount(),
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
public class DoubleTermsIT extends AbstractTermsTestCase {
            ExtendedStats stats = bucket.getAggregations().get("stats");
                .getTotal()
            assertThat(terms.getName(), equalTo("terms"));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        builders.add(
            .get();
    /**
            }
import org.opensearch.plugins.Plugin;
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
            Sum sum = bucket.getAggregations().get("sum_d");
                .prepareStats("cache_test_idx")
    public void testPartiallyUnmappedWithFormat() throws Exception {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                            .order(BucketOrder.aggregation("avg_i", true))
    @Override
        assertThat(terms.getName(), equalTo("terms"));
        assertSearchResponse(response);
                            CustomScriptPlugin.NAME,
                .getHitCount(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(key(bucket), equalTo("" + (double) i));
    }
            assertThat(bucket.getDocCount(), equalTo(1L));
            assertThat(bucket.getDocCount(), equalTo(i == 1 ? 3L : 1L));
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {
                .getTotal()
            CustomScriptPlugin.NAME,
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
        }
            )
            assertThat(bucket, notNullValue());
        );
        for (int i = 0; i < 5; i++) {
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get(SINGLE_VALUED_FIELD_NAME);
                // expected
            assertThat(bucket, notNullValue());
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
import org.opensearch.common.settings.Settings;
            .setSize(0)
    }
    }
        @Override
                .indices()
                    )
    }
            .get();
            client().admin()
 * You may obtain a copy of the License at
                client().prepareIndex("sort_idx")
        builders.add(
        for (int i = 0; i < 2; i++) {
        assertThat(terms, notNullValue());
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
            try {
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(bucket, notNullValue());
    }
        for (int i = 0; i < 6; i++) {
                .setRequestCache(true)
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscWithSubTermsAgg() throws Exception {
        boolean asc = true;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
                .get()
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
            });
                        .minDocCount(randomInt(1))
    }
        }
        builders.add(
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
    }
        assertThat(terms.getBuckets().size(), equalTo(6));
            client().admin()
                    .addAggregation(
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(max("max").field(SINGLE_VALUED_FIELD_NAME))
                .indices()
        assertThat(bucket, notNullValue());
        max = filter2.getAggregations().get("max");
            client().admin()
            Terms.Bucket bucket = terms.getBucketByKey(key);
                    .order(BucketOrder.aggregation("avg_i", asc))
            }
                .indices()
            client().prepareIndex("sort_idx")
            .addAggregation(
            assertThat(terms, notNullValue());
    }
                .get()
            )
        assertThat(tags.getName(), equalTo("tags"));
            .get();
            builders.add(
            try {
 */
                .getTotal()
 *
                            .value((double) i)
        Terms.Bucket tag = iters.next();
        assertThat(terms.getName(), equalTo("terms"));
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
                return Math.ceil(score.doubleValue() / 3);
        // the max for "0" is 4
            builders.add(
                            .endArray()
            );
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 2).endObject())
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
            }
        assertThat(terms.getName(), equalTo("terms"));
            )
        int expectedCardinality = terms.getBuckets().size();
        assertSearchResponse(response);
 * license agreements. See the NOTICE file distributed with
            .get();
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            client().prepareIndex("sort_idx")
            }
            equalTo(0L)
        int i = 0;
/*
            )
        assertThat(terms, notNullValue());
        assertThat(terms.getBuckets().size(), equalTo(5));
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
import java.io.IOException;
                Map<?, ?> doc = (Map) vars.get("doc");
     * Make sure that a request using a deterministic script or not using a script get cached.
                // expected
                )
        Terms terms = response.getAggregations().get("terms");
        bucketProps = new HashMap<>();
            true,
            assertThat(bucket.getDocCount(), equalTo(1L));
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        );
                // expected
                    )
            .addAggregation(
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i));
                        terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        );
        assertThat(terms.getName(), equalTo("terms"));
        );
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
        }
            assertThat(avg.getValue(), equalTo((double) i));
                .getRequestCache()
        assertThat(terms.getName(), equalTo("terms"));
        getMultiSortDocs(builders);
                assertThat(subBucket.getDocCount(), equalTo(1L));
        }
                assertThat(bucket.getKeyAsNumber(), instanceOf(Double.class));
            IllegalArgumentException.class,
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                    .order(BucketOrder.aggregation("stats.avg", asc))
                .getMissCount(),
            client().admin()
        );
                terms("terms").field("d")
            builders.add(
                fail(
            .get();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        );
                );
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    }
            .get();
/*
        builders.add(
        double[] expectedKeys = new double[] { 1, 2, 3, 4, 5, 6, 7 };
            try {
@OpenSearchIntegTestCase.SuiteScopeTestCase
        double[] expectedKeys = new double[] { 2, 1, 4, 5, 3, 6, 7 };
                            .endArray()
                .getRequestCache()
    public void testScriptCaching() throws Exception {
            for (Bucket bucket : terms.getBuckets()) {
                    )
    }
            assertThat(key(bucket), equalTo("" + (i + 1d)));
                        .size(0)
        builders.add(
        assertMultiSortResponse(
        Filter filter2 = filter1.getAggregations().get("filter2");
            scripts.put("(long) (_value / 1000 + 1)", vars -> (long) ((double) vars.get("_value") / 1000 + 1));
    private String key(Terms.Bucket bucket) {
        Terms terms = response.getAggregations().get("terms");
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
                            .order(BucketOrder.aggregation("stats.foo", true))
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx")
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        );
 * software distributed under the License is distributed on an
            assertThat(bucket, notNullValue());
                            ScriptType.INLINE,
        assertThat(
        bucketProps.put("_term", 5d);
    [4, 5]
            try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            if (i == 0 || i == 5) {
        assertThat(terms, notNullValue());
            Stats stats = bucket.getAggregations().get("stats");
import org.opensearch.script.ScriptType;
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(bucket.getKeyAsNumber().intValue(), equalTo(i + 1));
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(key(bucket), equalTo("" + (double) i));
            .addAggregation(
                .getRequestCache()
        bucketProps.put("sum_d", 3d);
            )
        assertThat(filter2, notNullValue());
    private static final int NUM_DOCS = 5; // TODO: randomize the size?
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        bucketProps.put("_term", 2d);
        SearchResponse response = client().prepareSearch("idx")
                    .addAggregation(
                            .startArray(MULTI_VALUED_FIELD_NAME)
        bucketProps.put("sum_d", 4d);
        SearchResponse response = client().prepareSearch("idx")
        Filter filter1 = tag.getAggregations().get("filter1");
                    terms("terms").field(SINGLE_VALUED_FIELD_NAME)
                .prepareStats("cache_test_idx")
    }
            }
 *
        );
            assertThat(key(bucket), equalTo("" + (double) i));
        assertEquals(expectedCardinality, foundTerms.size());
 * SPDX-License-Identifier: Apache-2.0
                .get();
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
import org.opensearch.search.aggregations.metrics.Max;
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
                    .setId("" + i)
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 1).field("l", 1).field("d", i).endObject())
        assertThat(terms, notNullValue());
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
/*
        bucketProps.put("_term", 6d);
                client().prepareSearch(index)
                client().prepareSearch(index)
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            });
            .addAggregation(
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 7).field("l", 5).field("d", 1).endObject())
            Terms.Bucket bucket = terms.getBucketByKey("" + (i + 1d));
                    )
                .getRequestCache()
                    )
        assertThat(filter1, notNullValue());
        assertThat(filter, notNullValue());
            .get();
            .addAggregation(
            .get();
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
                .setRequestCache(true)
                .getHitCount(),
        SearchResponse response = client().prepareSearch("idx")
                .getMissCount(),
        bucketProps = new HashMap<>();
    3 - count: 2 - sum: 6
        bucketProps.put("avg_l", 5d);
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
                );
        boolean asc = randomBoolean();
 * this file be licensed under the Apache-2.0 license or a
            "ceil(_score.doubleValue()/3)",
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 2).field("l", 2).field("d", i).endObject())
        r = client().prepareSearch("cache_test_idx")
                            CustomScriptPlugin.NAME,
                .prepareStats("cache_test_idx")
            .addAggregation(
        assertThat(terms.getBuckets().size(), equalTo(5));
    public void testSizeIsZero() {
    2 - count: 2 - sum: 4
                assertThat(bucket.getDocCount(), equalTo(2L));
                .getTotal()
    public void testOtherDocCount() {
            i++;
            .addAggregation(
        assertThat(key(tag), equalTo(asc ? "0" : "1"));
            if (i == 0 || i == 5) {
            )
                .indices()
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
        assertThat(
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
        assertThat(terms.getName(), equalTo("terms"));
            client().prepareIndex("sort_idx")
                        )
            .get();
        Terms terms = allResponse.getAggregations().get("terms");
        indexRandom(true, builders);
            assertThat(stats.getMax(), equalTo((double) i));
            () -> client().prepareSearch("high_card_idx")
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
                Map<?, ?> doc = (Map) vars.get("doc");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(stats, notNullValue());
            Avg avg = bucket.getAggregations().get("avg_i");
                terms("terms").field(MULTI_VALUED_FIELD_NAME)
        );
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));
        double[] expectedKeys = new double[] { 6, 7, 3, 4, 5, 1, 2 };
    private static HashMap<Double, Map<String, Object>> expectedMultiSortBuckets;
import org.opensearch.script.Script;
        assertThat(
import java.util.Arrays;
        assertThat(key(bucket), equalTo("1.0"));
        // Ensure that non-scripted requests are cached as normal
        assertThat(terms, notNullValue());
        bucketProps.put("_count", 1L);
            assertThat(key(bucket), equalTo("" + (double) i));
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
    public DoubleTermsIT(Settings staticSettings) {
        bucketProps.put("_term", 7d);
                            .field(SINGLE_VALUED_FIELD_NAME, (double) i)
        for (int i = 0; i < 5; i++) {
                .getRequestCache()
        bucketProps.put("_count", 2L);
        assertSearchResponse(response);
    */
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
                assertThat(subBucket, notNullValue());
        Terms terms = response.getAggregations().get("terms");
        SearchResponse response = client().prepareSearch("idx")
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 3).field("l", 3).field("d", 1).endObject())
            .get();
            client().prepareIndex("sort_idx")
                .get()
    public void testSingleValuedFieldWithValueScript() throws Exception {
        Terms terms = response.getAggregations().get("terms");
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            )
        }
        assertThat(
        bucketProps.put("_term", 3d);
                .getHitCount(),
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        }
import static org.hamcrest.core.IsNull.notNullValue;
        );
                    .get();
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
    /*
        assertThat(
                .getTotal()
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getBuckets().size(), equalTo(5));
import static org.hamcrest.Matchers.instanceOf;
            } catch (OpenSearchException e) {
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 1).endObject())
            assertThat(bucket.getDocCount(), equalTo(1L));
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {
        return Collections.singleton(CustomScriptPlugin.class);
import java.util.ArrayList;
        assertThat(key(tag), equalTo(asc ? "1" : "0"));
            assertThat(key(bucket), equalTo("" + (i + 1d)));
        );
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
            assertThat(sum, notNullValue());
                    .subAggregation(avg("avg_l").field("l"))
            ScriptType.INLINE,
 * not use this file except in compliance with the License.
        boolean asc = false;
            )
            assertThat(key(bucket), equalTo("" + (double) i));
        builders.add(
                .prepareStats("cache_test_idx")
            });
    private static final String SINGLE_VALUED_FIELD_NAME = "d_value";
                .getTotal()
        double[] expectedKeys = new double[] { 5, 6, 7, 3, 4, 2, 1 };
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {
        double[] expectedKeys = new double[] { 1, 2, 3, 4, 5, 6, 7 };
        }
 */
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2.5)
                    .setSource(
    }
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        assertSearchResponse(response);
            .get();
                .get()
        assertThat(max.getValue(), equalTo(asc ? 2.0 : 4.0));
        }
import org.opensearch.index.fielddata.ScriptDocValues;
        filter = tag.getAggregations().get("filter");
                .addAggregation(
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1.5),
            client().admin()
        );
            )
import org.opensearch.OpenSearchException;
        filter2 = filter1.getAggregations().get("filter2");
    }
        Terms terms = response.getAggregations().get("terms");
    }
                .prepareStats("cache_test_idx")
    }
        bucketProps.put("sum_d", 6d);
            )
            assertThat(bucket, notNullValue());
                return value.getValue();
                    .subAggregation(sum("sum_d").field("d"))
    4 - count: 2 - sum: 8
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
        Filter filter = tag.getAggregations().get("filter");
                        jsonBuilder().startObject()
                .indices()
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
            String key = String.format(Locale.ROOT, "%07.2f", (double) i);
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "(long) (_value / 1000 + 1)", Collections.emptyMap()))
        for (int i = 0; i < 5; i++) {
    private void assertMultiSortResponse(double[] expectedKeys, BucketOrder... order) {
        assertThat(terms, notNullValue());
        bucketProps = new HashMap<>();
            .addAggregation(terms("terms").field(field).size(10000).collectMode(randomFrom(SubAggCollectionMode.values())))
            equalTo(2L)
                            .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
        bucketProps.put("sum_d", 3d);
        List<IndexRequestBuilder> builders = new ArrayList<>();
        indexRandom(
    }
                    .subAggregation(extendedStats("stats").field(SINGLE_VALUED_FIELD_NAME))
        }
        );
                    .subAggregation(terms("subTerms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
                .indices()
    public void setupSuiteScopeCluster() throws Exception {
            assertThat(avg, notNullValue());
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
            Terms.Bucket bucket = terms.getBucketByKey("" + (double) i);
    }
                terms("terms").field("d")
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get(MULTI_VALUED_FIELD_NAME);
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(terms.getName(), equalTo("terms"));
                fail(
            assertThat(bucket, notNullValue());
                assertThat(bucket.getDocCount(), equalTo(1L));
        // Make sure we are starting with a clear cache
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
                    .order(BucketOrder.aggregation("stats.variance", asc))
        for (int i = 1; i <= 3; i++) {
                        .includeExclude(new IncludeExclude(partition, numPartitions))
                .getHitCount(),
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
            Collections.emptyMap()
            SearchResponse response = client().prepareSearch("idx")
        );
        Terms terms = response.getAggregations().get("terms");
                .indices()
        // Test that a request using a deterministic script gets cached
import org.opensearch.search.aggregations.bucket.terms.Terms;
        expectedMultiSortBuckets.put((Double) bucketProps.get("_term"), bucketProps);
            prepareCreate("cache_test_idx").setMapping("d", "type=float")
                terms("terms").field(SINGLE_VALUED_FIELD_NAME)
            .get();
    [5, 6]
        return bucket.getKeyAsString();
            ScriptType.INLINE,
            );
        }
        SearchResponse response = client().prepareSearch("idx")
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
        assertThat(terms.getBuckets().size(), equalTo(5));
        super(staticSettings);
    }
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, 4).field("l", 3).field("d", 3).endObject())
            equalTo(0L)
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
                    .script(
        }
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())).format("0000.00")
        bucketProps.put("_count", 1L);
        boolean asc = true;
        assertThat(tags, notNullValue());
            .addAggregation(
            assertThat(avg, notNullValue());
            expectedKeys,
import org.opensearch.search.aggregations.metrics.Avg;
            equalTo(1L)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
        assertThat(terms, notNullValue());
            .get();
import java.util.Collections;
                    .order(BucketOrder.compound(order))
            .get();
            assertThat(key(bucket), equalTo("" + (double) i));
            builders.add(
