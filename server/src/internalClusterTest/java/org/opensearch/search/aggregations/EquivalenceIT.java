    }
            client().prepareIndex("idx").setSource(source).get();
        assertEquals(value < 6 ? value : 0, sum.getValue(), 0d);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
import java.util.function.Function;
            for (int j = 0; j < values.length; ++j) {
        ).get();
import org.opensearch.search.aggregations.bucket.filter.Filter;
        indexRandom(true, indexingRequests);
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            }
                query.addRange(key, ranges[i][0], ranges[i][1]);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
import java.util.HashSet;
        prepareCreate("idx").setMapping(
                    ranges[i] = new double[] { Double.NEGATIVE_INFINITY, randomInt(100) };
        Range range = resp.getAggregations().get("range");
            for (double[] values : docs) {
        assertThat(bucket, notNullValue());
                terms("terms").field("values")
            assertNotNull(stringGlobalOrdinalsDVBucket);
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "floor(_value / interval)", params))
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        Histogram histo = resp.getAggregations().get("histo");
            if (ranges[i][0] != Double.NEGATIVE_INFINITY) {
                terms("f1").field("f1")
        @Override
    }
    public void testRandomRanges() throws Exception {
            )
                .endObject()
import org.opensearch.script.ScriptType;
 * The OpenSearch Contributors require contributions made to
    private void setupMaxBuckets() {
                    break;
                query.addUnboundedTo(key, ranges[i][1]);
        final int numDocs = scaledRandomIntBetween(500, 5000);
            }
import java.util.List;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            .get();
        SearchResponse resp = reqBuilder.get();
    }
        final Terms t2 = r2.getAggregations().get("f1");
                .startObject("values")
        Range.Bucket bucket = buckets.get(0);
            }
            .addAggregation(
            source = source.endArray().endObject();
        indexRandom(true, reqs);
            for (int j = 0; j < values.length; ++j) {
            .get();
        assertAllSuccessful(response);
            RangeQueryBuilder filter = QueryBuilders.rangeQuery("values");
                    .executionHint(TermsAggregatorFactory.ExecutionMode.MAP.toString())
            assertEquals(b1.getDocCount(), b2.getDocCount());
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
import org.opensearch.index.query.RangeQueryBuilder;
/*
import org.opensearch.action.index.IndexRequestBuilder;
        cluster().wipeIndices("idx");
                            .subAggregation(terms("f3").field("f3").collectMode(SubAggCollectionMode.BREADTH_FIRST))
import org.opensearch.script.MockScriptPlugin;
            new Object[] {
 */
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                .startObject("long_values")
                .endObject()
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Collections.singletonMap("search.max_buckets", null)).get();
        createIndex("idx");
        for (Bucket bucket : buckets) {
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            )
    }
        assertThat(terms, notNullValue());
            .get();
            assertThat(filter.getDocCount(), equalTo(count));
                .endObject()
        assertThat(terms.getBuckets().size(), equalTo(histo.getBuckets().size()));
            client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).execute().get()
        for (Iterator<? extends Terms.Bucket> it1 = t1Buckets.iterator(), it2 = t2Buckets.iterator(); it1.hasNext();) {
        final double[][] docs = new double[numDocs][];
        SearchResponse response = client().prepareSearch("idx")
                .endObject()
            assertEquals(bucket.getKeyAsString(), Integer.toString(i), bucket.getKeyAsString());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            for (int j = 0; j < numValues; ++j) {
            .addAggregation(
            .addAggregation(histogram("histo").field("values").interval(interval).minDocCount(1))
        final int maxNumTerms = randomIntBetween(10, 5000);
public class EquivalenceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                .startObject("double_values")
                .endObject()
                filter = filter.from(ranges[i][0]);
        Range range = filter.getAggregations().get("range");
import org.opensearch.core.xcontent.XContentBuilder;
            client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).execute().get()
        }
 */
                        terms("f2").field("f2")
            bucketMap.put(bucket.getKeyAsString(), bucket);
                case 1:
    public void testDuelTerms() throws Exception {
            assertEquals(sub1, sub2);
    @After
        return Arrays.asList(
                .endObject()
                assertEquals(subSub1, subSub2);
        assertEquals(numDocs, response.getHits().getTotalHits().value());
        client().admin()
                    .size(maxNumTerms)
        assertNoFailures(
            final Terms.Bucket b2 = t2.getBucketByKey(b1.getKeyAsString());
                .field("type", "double")
                docs[i][j] = randomDouble() * 100;
        Terms terms = resp.getAggregations().get("terms");
            final int[] values = new int[randomInt(4)];
        assertEquals(numDocs, resp.getHits().getTotalHits().value());
            new Object[] {
                terms("string_global_ordinals_doc_values").field("string_values.doc_values")
        final int numDocs = scaledRandomIntBetween(1000, 2000);
            }
    }
        for (int i = 0; i < ranges.length; ++i) {
 * software distributed under the License is distributed on an
import org.opensearch.script.Script;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilders;
            .addAggregation(
        final Terms stringGlobalOrdinalsTerms = resp.getAggregations().get("string_global_ordinals");
            source = source.endArray().endObject();
                }
            new Object[] {
                final Terms subSub1 = subB1.getAggregations().get("f3");
    public void testDuelDepthBreadthFirst() throws Exception {
            .addAggregation(
        for (int i = 0; i < numDocs; ++i) {
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
        assertThat(range.getName(), equalTo("range"));
                            .collectMode(SubAggCollectionMode.DEPTH_FIRST)
            final int v3 = randomInt(1 << randomInt(7));
 * specific language governing permissions and limitations
            .get();
        }
        assertSearchResponse(r2);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .startObject("doc_values")
    public void testReduce() throws Exception {
        final int interval = randomIntBetween(1, 100);
        assertNoFailures(
        indexRandom(true, indexingRequests);
            for (int j = 0; j < values.length; ++j) {
        assertEquals(valuesSet.size(), stringGlobalOrdinalsTerms.getBuckets().size());
                    .subAggregation(
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    // Make sure that unordered, reversed, disjoint and/or overlapping ranges are supported
 * GitHub history for details.
    public static class CustomScriptPlugin extends MockScriptPlugin {
                source = source.value((double) values[j]);
        assertSearchResponse(resp);
                final Terms.Bucket subB2 = sub2.getBucketByKey(subB1.getKeyAsString());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
        }
            }
                    break;
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
    public static Collection<Object[]> parameters() {
        final Terms t1 = r1.getAggregations().get("f1");
        SearchResponse response = client().prepareSearch("idx")
                    )
                return Math.floor(value / interval.doubleValue());
        final Terms stringMapTerms = resp.getAggregations().get("string_map");
import org.opensearch.action.search.SearchRequestBuilder;
            if (ranges[i][1] != Double.POSITIVE_INFINITY) {
        params.put("interval", interval);
            for (Terms.Bucket subB1 : sub1.getBuckets()) {
 */
    @ParametersFactory
        assertEquals(value >= 6 ? value : 0, sum.getValue(), 0d);
                    .collectMode(SubAggCollectionMode.DEPTH_FIRST)
        assertEquals(valuesSet.size(), stringMapTerms.getBuckets().size());
            )
        assertSearchResponse(r1);
                .startObject("properties")
                            .collectMode(SubAggCollectionMode.BREADTH_FIRST)
        SearchRequestBuilder reqBuilder = client().prepareSearch("idx").addAggregation(query);
            }
            final int numValues = randomInt(5);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        for (int i = 0; i < ranges.length; ++i) {
                    break;
 * Modifications Copyright OpenSearch Contributors. See
        assertAllSuccessful(resp);
                    .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())
            final Range.Bucket bucket = bucketMap.get(Integer.toString(i));
            .prepareUpdateSettings()
            });
        Sum sum = bucket.getAggregations().get("sum");
        assertEquals(valuesSet.size(), doubleTerms.getBuckets().size());
 *    http://www.apache.org/licenses/LICENSE-2.0
        final SearchResponse r2 = client().prepareSearch("idx")
            .get();
        for (int i = 0; i < numDocs; ++i) {
                .field("type", "double")
        Filter filter = response.getAggregations().get("filter");
import org.opensearch.action.support.IndicesOptions;
                        terms("f2").field("f2")
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
                .endObject()
                        ++count;
            indexingRequests.add(client().prepareIndex("idx").setId(Integer.toString(i)).setSource("double_value", randomDouble()));
            switch (randomInt(2)) {
                    .subAggregation(max("max").field("num"))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        }
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
import org.opensearch.search.aggregations.metrics.Sum;
            assertNotNull(stringMapBucket);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            final int v2 = randomInt(1 << randomInt(7));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .subAggregation(extendedStats("stats").field("num"))
            jsonBuilder().startObject()
                source = source.value(Integer.toString(values[j]));
            String key = Integer.toString(i);
            reqBuilder = reqBuilder.addAggregation(filter("filter" + i, filter));
        for (Terms.Bucket bucket : longTerms.getBuckets()) {
        final int numRanges = randomIntBetween(1, 20);
 * Unless required by applicable law or agreed to in writing,
        }
            assertNotNull(stringGlobalOrdinalsBucket);
            if (ranges[i][0] == Double.NEGATIVE_INFINITY) {
                .endObject()
    }
import java.util.Map;
        for (int i = 0; i < ranges.length; ++i) {
        final int maxNumTerms = randomIntBetween(10, 2000);
        ).get();
                .field("type", "double")
 */
                values[j] = randomInt(maxNumTerms - 1) - 1000;
        ).get();
            assertEquals(bucket.getDocCount(), stringGlobalOrdinalsBucket.getDocCount());
        // disables the max bucket limit for this test
                .endObject()
import static org.hamcrest.core.IsNull.notNullValue;
                    if (value >= ranges[i][0] && value < ranges[i][1]) {
        }
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            for (int j = 0; j < docs[i].length; ++j) {
    }
        }
        }
    // Duel between histograms and scripted terms
                    )
                    .size(maxNumTerms)
        assertEquals(valuesSet.size(), longTerms.getBuckets().size());
        final Integer[] values = new Integer[maxNumTerms];
    }
import org.junit.Before;
        indexRandom(true, client().prepareIndex("idx").setSource("f", value));
            docs[i] = new double[numValues];
        logger.info("Indexing [{}] docs", numDocs);
        }
        assertThat(bucket, notNullValue());
import org.opensearch.plugins.Plugin;
                source = source.value(docs[i][j]);
        );
                .field("type", "keyword")
        }
            final Terms.Bucket termsBucket = terms.getBucketByKey(String.valueOf(key));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
package org.opensearch.search.aggregations;
        for (int i = 0; i < ranges.length; ++i) {
            )
        final SearchResponse r1 = client().prepareSearch("idx")
            final int v1 = randomInt(1 << randomInt(7));
            client().prepareIndex("idx").setSource(source).get();
        assertNoFailures(client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
        super(staticSettings);
            final double key = ((Number) bucket.getKey()).doubleValue() / interval;
 *
        );
            .addAggregation(
            jsonBuilder().startObject()
import java.util.Iterator;
 *
    private void assertEquals(Terms t1, Terms t2) {
        bucket = buckets.get(1);
        assertThat(buckets.size(), equalTo(2));
        final Set<Integer> valuesSet = new HashSet<>();
        assertEquals(1, filter.getDocCount());
            }
}
            final Terms.Bucket doubleBucket = doubleTerms.getBucketByKey(Double.toString(Long.parseLong(bucket.getKeyAsString())));
            assertEquals(bucket.getDocCount(), doubleBucket.getDocCount());
        assertThat(range, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.range;
                Integer interval = (Integer) vars.get("interval");
                    .subAggregation(
        );
                    .size(maxNumTerms)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(histo, notNullValue());
            )
    }
            assertEquals(bucket.getDocCount(), stringMapBucket.getDocCount());
        List<? extends Bucket> buckets = range.getBuckets();
        final int numDocs = scaledRandomIntBetween(2500, 5000);
            final int numValues = randomInt(4);
                .endObject()
            )
            }
import java.util.Set;
/*
                .startObject("properties")
 * this work for additional information regarding copyright
        }
        HashMap<String, Bucket> bucketMap = new HashMap<>(buckets.size());
import java.util.HashMap;
            } else {
import java.util.Collections;
 * You may obtain a copy of the License at
            for (int j = 0; j < values.length; ++j) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            values[i] = randomInt(maxNumTerms * 3) - maxNumTerms;
    // https://github.com/elastic/elasticsearch/issues/6435
                .field("type", "double")
            assertEquals(bucket.getKeyAsString(), count, bucket.getDocCount());
        for (int i = 0; i < numDocs; ++i) {
        assertThat(bucket.getDocCount(), equalTo(value < 6 ? 1L : 0L));
        List<? extends Terms.Bucket> t2Buckets = t1.getBuckets();
                case 0:
        assertThat(bucket.getDocCount(), equalTo(value >= 6 ? 1L : 0L));
        final Terms doubleTerms = resp.getAggregations().get("double");
                terms("f1").field("f1")
                .startObject("properties")
    private void cleanupMaxBuckets() {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat((String) bucket.getKey(), equalTo("6.0-*"));
                terms("terms").field("double_value")
                .startObject("properties")
        assertThat((String) bucket.getKey(), equalTo("*-6.0"));
        SearchResponse resp = client().prepareSearch("idx")
            final Terms.Bucket stringGlobalOrdinalsBucket = stringGlobalOrdinalsTerms.getBucketByKey(bucket.getKeyAsString());
        prepareCreate("idx").setMapping(
                case 2:
        for (int i = 0; i < numDocs; ++i) {
                .field("type", "keyword")
                    }
                source = source.value(values[j]);
            .cluster()
            jsonBuilder().startObject()
        final int numDocs = scaledRandomIntBetween(500, 5000);
        prepareCreate("idx").setMapping(
            }
        sum = bucket.getAggregations().get("sum");
    // test long/double/string terms aggs with high number of buckets that require array growth
        prepareCreate("idx").setMapping(
                .endObject()
        }
            final Filter filter = resp.getAggregations().get("filter" + i);
            return Collections.singletonMap("floor(_value / interval)", vars -> {
            final Terms.Bucket b2 = it2.next();
        final Terms stringGlobalOrdinalsDVTerms = resp.getAggregations().get("string_global_ordinals_doc_values");
            }
        }
        }
 * KIND, either express or implied.  See the License for the
            for (int j = 0; j < numValues; ++j) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                )
            }
        for (int i = 0; i < docs.length; ++i) {
            )
        final int value = randomIntBetween(0, 10);
                valuesSet.add(values[j]);
import java.util.Arrays;
                filter("filter", QueryBuilders.matchAllQuery()).subAggregation(
 * compatible open source license.
        }
            source = source.endArray().startArray("double_values");
                .field("type", "double")
        // test high numbers of percentile buckets to make sure paging and release work correctly
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    // Duel with filters
            .addAggregation(
 * not use this file except in compliance with the License.
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
 * the growth of dynamic arrays is tested.
            XContentBuilder source = jsonBuilder().startObject().field("num", randomDouble()).startArray("values");
                    .subAggregation(stats("stats").field("num"))
/*
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        assertSearchResponse(response);
        assertEquals(t1Buckets.size(), t2Buckets.size());
                terms("string_global_ordinals").field("string_values")
    @Override
import org.opensearch.common.settings.Settings;
        List<? extends Terms.Bucket> t1Buckets = t1.getBuckets();
        for (int i = 0; i < numDocs; ++i) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        List<IndexRequestBuilder> indexingRequests = new ArrayList<>();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                .endObject()
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
            )
                    .size(maxNumTerms)
        return Collections.singleton(CustomScriptPlugin.class);
 * Additional tests that aim at testing more complex aggregation trees on larger random datasets, so that things like
                            .subAggregation(terms("f3").field("f3").collectMode(SubAggCollectionMode.DEPTH_FIRST))
        SearchResponse resp = client().prepareSearch("idx")
 * Licensed to Elasticsearch under one or more contributor
            .addAggregation(
                    .subAggregation(min("min").field("num"))
        Map<String, Object> params = new HashMap<>();
            )
 * license agreements. See the NOTICE file distributed with
            XContentBuilder source = jsonBuilder().startObject().startArray("values");
                terms("string_map").field("string_values")
        List<IndexRequestBuilder> indexingRequests = new ArrayList<>();
/**
        final double[][] ranges = new double[numRanges][];
        assertNotNull(filter);
            .setTransientSettings(Collections.singletonMap("search.max_buckets", Integer.MAX_VALUE))
                terms("double").field("double_values")
                terms("long").field("long_values")
                        break;
import static org.hamcrest.Matchers.equalTo;
    public void testDuelTermsHistogram() throws Exception {
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
import java.util.Collection;
 * ownership. Elasticsearch licenses this file to you under
    }
            source = source.endArray().startArray("string_values");
            } else if (ranges[i][1] == Double.POSITIVE_INFINITY) {
                .startObject("fields")
                    .subAggregation(percentiles("pcts").field("double_value"))
                .endObject()
            }
            long count = 0;
            .addAggregation(
                .startObject("num")
                .startObject("string_values")
                    .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())
                .endObject()
                    range("range").field("f").addUnboundedTo(6).addUnboundedFrom(6).subAggregation(sum("sum").field("f"))
            }
            final Terms.Bucket b1 = it1.next();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            assertEquals(bucket.getDocCount(), stringGlobalOrdinalsDVBucket.getDocCount());
                .field("type", "long")
                .endObject()
        ).get();
                for (double value : values) {
            jsonBuilder().startObject()
            )
            final Terms sub1 = b1.getAggregations().get("f2");
        RangeAggregationBuilder query = range("range").field("values");
            assertEquals(b1.getKey(), b2.getKey());
                    .size(maxNumTerms)
            source = source.endArray().endObject();
            assertEquals(bucket.getDocCount(), termsBucket.getDocCount());
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
import org.opensearch.search.aggregations.bucket.range.Range;
        assertEquals(valuesSet.size(), stringGlobalOrdinalsDVTerms.getBuckets().size());
        for (int i = 0; i < values.length; ++i) {
        for (Terms.Bucket b1 : t1.getBuckets()) {
                    ranges[i] = new double[] { randomInt(100), randomInt(100) };
        }
    @Before
import java.util.ArrayList;
            final Terms.Bucket stringMapBucket = stringMapTerms.getBucketByKey(bucket.getKeyAsString());
                default:
                .endObject()
            .get();
                final Terms subSub2 = subB2.getAggregations().get("f3");
                .endObject()
            XContentBuilder source = jsonBuilder().startObject().field("num", randomDouble()).startArray("long_values");
        List<IndexRequestBuilder> reqs = new ArrayList<>();
                query.addUnboundedFrom(key, ranges[i][0]);
 *
                source = source.value(randomFrom(values));
    public EquivalenceIT(Settings staticSettings) {
            .addAggregation(
            indexingRequests.add(client().prepareIndex("idx").setSource(source));
    }
 * under the License.
                Double value = (Double) vars.get("_value");
            .addAggregation(
                    ranges[i] = new double[] { randomInt(100), Double.POSITIVE_INFINITY };
            assertNotNull(doubleBucket);
                    throw new AssertionError();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        final int numDocs = randomIntBetween(100, 500);
    public void testLargeNumbersOfPercentileBuckets() throws Exception {
        }
                filter = filter.to(ranges[i][1]);
        assertEquals(t1, t2);
    }
                .field("index", false)
                .startObject("double_value")
        createIndex("idx");
            reqs.add(client().prepareIndex("idx").setSource("f1", v1, "f2", v2, "f3", v3));
            final Terms sub2 = b2.getAggregations().get("f2");
        final Terms longTerms = resp.getAggregations().get("long");
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));
import org.junit.After;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .subAggregation(extendedStats("stats").field("num"))
            final Terms.Bucket stringGlobalOrdinalsDVBucket = stringGlobalOrdinalsDVTerms.getBucketByKey(bucket.getKeyAsString());
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .size(maxNumTerms)
        List<? extends Bucket> buckets = range.getBuckets();
                .startObject("num")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
