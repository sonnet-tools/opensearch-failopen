        final Terms stringMapTerms = resp.getAggregations().get("string_map");
    public void testRandomRanges() throws Exception {
        ).get();  
import org.opensearch.action.index.IndexRequestBuilder;  
        assertEquals(1, filter.getDocCount());  
                }  
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
                .startObject("doc_values")
            )  
            for (int j = 0; j < docs[i].length; ++j) {
    @ParametersFactory
            source = source.endArray().endObject();
        final Integer[] values = new Integer[maxNumTerms];  
import org.junit.Before;
            .addAggregation(
            final Terms.Bucket stringGlobalOrdinalsDVBucket = stringGlobalOrdinalsDVTerms.getBucketByKey(bucket.getKeyAsString());
    }  
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
        assertEquals(t1, t2);  
            for (int j = 0; j < values.length; ++j) {
        assertEquals(value >= 6 ? value : 0, sum.getValue(), 0d);  
        assertThat(bucket, notNullValue());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        }
        assertEquals(valuesSet.size(), stringGlobalOrdinalsDVTerms.getBuckets().size());  
            reqs.add(client().prepareIndex("idx").setSource("f1", v1, "f2", v2, "f3", v3));
            assertEquals(bucket.getKeyAsString(), Integer.toString(i), bucket.getKeyAsString());
/*
                .field("index", false)  
                .startObject("values")
        final int numRanges = randomIntBetween(1, 20);  
        final Terms stringGlobalOrdinalsTerms = resp.getAggregations().get("string_global_ordinals");
            source = source.endArray().startArray("double_values");
            assertNotNull(stringGlobalOrdinalsDVBucket);  
                .endObject()
        );
 */  
import static org.hamcrest.Matchers.equalTo;
                    .size(maxNumTerms)  
                terms("double").field("double_values")
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())
            .addAggregation(
        final int maxNumTerms = randomIntBetween(10, 2000);  
        bucket = buckets.get(1);
        assertNotNull(filter);
    // test long/double/string terms aggs with high number of buckets that require array growth  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchResponse;
            }
                source = source.value(Integer.toString(values[j]));
            final Terms.Bucket b1 = it1.next();
        for (int i = 0; i < numDocs; ++i) {
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                terms("string_global_ordinals").field("string_values")  
        SearchRequestBuilder reqBuilder = client().prepareSearch("idx").addAggregation(query);  
            jsonBuilder().startObject()
    }
        }  
import org.opensearch.script.Script;
                .startObject("num")
                values[j] = randomInt(maxNumTerms - 1) - 1000;  
}  
            for (int j = 0; j < values.length; ++j) {  
                        break;
            assertNotNull(stringMapBucket);
        SearchResponse response = client().prepareSearch("idx")  
        SearchResponse resp = reqBuilder.get();  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(6.0));
                        terms("f2").field("f2")
            }
        ).get();  
                    throw new AssertionError();
            new Object[] {
    private void assertEquals(Terms t1, Terms t2) {  
            jsonBuilder().startObject()
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .addAggregation(  
            .get();  
                valuesSet.add(values[j]);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
        for (int i = 0; i < ranges.length; ++i) {
    @After
            final int numValues = randomInt(4);
            for (int j = 0; j < numValues; ++j) {
import java.util.Set;
        super(staticSettings);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            jsonBuilder().startObject()  
 */
        createIndex("idx");
import org.opensearch.common.settings.Settings;
import java.util.Collection;  
import java.util.Map;  
    public void testLargeNumbersOfPercentileBuckets() throws Exception {  
import org.opensearch.script.ScriptType;
        prepareCreate("idx").setMapping(
            if (ranges[i][1] != Double.POSITIVE_INFINITY) {  
 * the Apache License, Version 2.0 (the "License"); you may
            }  
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singleton(CustomScriptPlugin.class);
                terms("terms").field("values")
                .endObject()  
                    ranges[i] = new double[] { randomInt(100), Double.POSITIVE_INFINITY };
            assertThat(filter.getDocCount(), equalTo(count));
        SearchResponse response = client().prepareSearch("idx")
            final int numValues = randomInt(5);  
                    .subAggregation(max("max").field("num"))
            client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).execute().get()  
            assertEquals(bucket.getDocCount(), stringMapBucket.getDocCount());
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
                .startObject("num")
        for (int i = 0; i < ranges.length; ++i) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(numDocs, response.getHits().getTotalHits().value());
                .field("type", "double")
            assertEquals(bucket.getDocCount(), doubleBucket.getDocCount());
        cluster().wipeIndices("idx");  
        }
        final double[][] ranges = new double[numRanges][];
            for (int j = 0; j < values.length; ++j) {
import org.opensearch.search.aggregations.bucket.terms.Terms;  
                terms("terms").field("double_value")
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(6.0));  
import org.opensearch.action.support.IndicesOptions;  
                .startObject("long_values")
        }  
            assertNotNull(stringGlobalOrdinalsBucket);
            if (ranges[i][0] == Double.NEGATIVE_INFINITY) {  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                query.addRange(key, ranges[i][0], ranges[i][1]);
            )
                terms("string_global_ordinals_doc_values").field("string_values.doc_values")
        Range range = filter.getAggregations().get("range");
            )  
                .field("type", "keyword")
                .endObject()  
                .endObject()
            assertNotNull(doubleBucket);  
            XContentBuilder source = jsonBuilder().startObject().startArray("values");  
package org.opensearch.search.aggregations;
            .get();
                source = source.value(randomFrom(values));  
 * GitHub history for details.
    public void testReduce() throws Exception {
                    }
            assertEquals(b1.getDocCount(), b2.getDocCount());
        indexRandom(true, indexingRequests);  
import java.util.Iterator;
            final int v3 = randomInt(1 << randomInt(7));
            final Filter filter = resp.getAggregations().get("filter" + i);
        for (Iterator<? extends Terms.Bucket> it1 = t1Buckets.iterator(), it2 = t2Buckets.iterator(); it1.hasNext();) {
        indexRandom(true, reqs);
    }
            )
            assertEquals(bucket.getDocCount(), stringGlobalOrdinalsDVBucket.getDocCount());
        assertEquals(valuesSet.size(), stringMapTerms.getBuckets().size());
import org.opensearch.action.search.SearchRequestBuilder;
                filter = filter.from(ranges[i][0]);
    private void cleanupMaxBuckets() {
                    .subAggregation(min("min").field("num"))
            )  
 * under the License.  
import java.util.function.Function;
                terms("f1").field("f1")
 * software distributed under the License is distributed on an
                source = source.value(docs[i][j]);
        List<IndexRequestBuilder> indexingRequests = new ArrayList<>();
            client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).execute().get()  
                .field("type", "long")
            for (int j = 0; j < numValues; ++j) {
                query.addUnboundedTo(key, ranges[i][1]);
                .startObject("fields")  
                filter = filter.to(ranges[i][1]);
            assertEquals(sub1, sub2);
                    range("range").field("f").addUnboundedTo(6).addUnboundedFrom(6).subAggregation(sum("sum").field("f"))  
        final int numDocs = scaledRandomIntBetween(500, 5000);  
            }
            source = source.endArray().startArray("string_values");
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
                    break;  
                .endObject()  
                .endObject()
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(Double.NEGATIVE_INFINITY));
        @Override
            for (int j = 0; j < values.length; ++j) {
            reqBuilder = reqBuilder.addAggregation(filter("filter" + i, filter));  
            }  
            .addAggregation(
        }  
        assertSearchResponse(r1);
import java.util.HashSet;  
    }
            new Object[] {
        }
import java.util.Collections;
                .endObject()  
                .startObject("properties")  
        assertNoFailures(
                    .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())  
            return Collections.singletonMap("floor(_value / interval)", vars -> {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .field("type", "keyword")
 */  
        for (int i = 0; i < numDocs; ++i) {
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Collections.singletonMap("search.max_buckets", null)).get();  
        Terms terms = resp.getAggregations().get("terms");  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
    }
        for (int i = 0; i < numDocs; ++i) {  
                .endObject()
            .addAggregation(
    }
        for (Terms.Bucket bucket : longTerms.getBuckets()) {
/**
                case 2:
            final int v1 = randomInt(1 << randomInt(7));
        assertSearchResponse(resp);
        for (Terms.Bucket b1 : t1.getBuckets()) {
        );
                    .subAggregation(extendedStats("stats").field("num"))
                terms("f1").field("f1")
        List<? extends Bucket> buckets = range.getBuckets();
                .endObject()
            assertEquals(bucket.getDocCount(), termsBucket.getDocCount());
                    .subAggregation(percentiles("pcts").field("double_value"))  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "floor(_value / interval)", params))
 *  
    public static class CustomScriptPlugin extends MockScriptPlugin {
            switch (randomInt(2)) {  
        final Set<Integer> valuesSet = new HashSet<>();
            final Terms sub2 = b2.getAggregations().get("f2");
        assertThat(buckets.size(), equalTo(2));  
            .addAggregation(
        for (int i = 0; i < ranges.length; ++i) {
                    .size(maxNumTerms)  
 * specific language governing permissions and limitations
                filter("filter", QueryBuilders.matchAllQuery()).subAggregation(
        }
        assertThat(bucket, notNullValue());  
 */
        }  
            final Terms.Bucket b2 = t2.getBucketByKey(b1.getKeyAsString());
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            source = source.endArray().endObject();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(range, notNullValue());  
                final Terms.Bucket subB2 = sub2.getBucketByKey(subB1.getKeyAsString());
            )
    public EquivalenceIT(Settings staticSettings) {
        );
import java.util.List;
        Filter filter = response.getAggregations().get("filter");
            )  
        return Arrays.asList(
                .startObject("properties")
        params.put("interval", interval);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                    .size(maxNumTerms)
            assertEquals(bucket.getDocCount(), stringGlobalOrdinalsBucket.getDocCount());  
        assertThat((String) bucket.getKey(), equalTo("6.0-*"));
            .get();
            final double key = ((Number) bucket.getKey()).doubleValue() / interval;  
    public static Collection<Object[]> parameters() {  
                    .size(maxNumTerms)  
            final Terms.Bucket stringMapBucket = stringMapTerms.getBucketByKey(bucket.getKeyAsString());  
                default:
        indexRandom(true, indexingRequests);  
    public void testDuelDepthBreadthFirst() throws Exception {  
        final Terms t2 = r2.getAggregations().get("f1");
                .startObject("string_values")
        prepareCreate("idx").setMapping(
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
        }
        final Terms stringGlobalOrdinalsDVTerms = resp.getAggregations().get("string_global_ordinals_doc_values");  
            final Terms.Bucket b2 = it2.next();  
            .addAggregation(
                Integer interval = (Integer) vars.get("interval");  
                terms("string_map").field("string_values")
                final Terms subSub1 = subB1.getAggregations().get("f3");
        for (Bucket bucket : buckets) {
            } else if (ranges[i][1] == Double.POSITIVE_INFINITY) {
            .addAggregation(  
        // disables the max bucket limit for this test
                case 0:
                    .size(maxNumTerms)
/*  
            for (double[] values : docs) {  
        assertThat((String) bucket.getKey(), equalTo("*-6.0"));
 * the growth of dynamic arrays is tested.  
        assertThat(bucket.getDocCount(), equalTo(value >= 6 ? 1L : 0L));
            final Terms.Bucket stringGlobalOrdinalsBucket = stringGlobalOrdinalsTerms.getBucketByKey(bucket.getKeyAsString());
        List<? extends Terms.Bucket> t2Buckets = t1.getBuckets();
            final Terms.Bucket doubleBucket = doubleTerms.getBucketByKey(Double.toString(Long.parseLong(bucket.getKeyAsString())));
        prepareCreate("idx").setMapping(
        assertThat(histo, notNullValue());  
 * The OpenSearch Contributors require contributions made to  
                .endObject()
        SearchResponse resp = client().prepareSearch("idx")  
 * not use this file except in compliance with the License.
            if (ranges[i][0] != Double.NEGATIVE_INFINITY) {  
import org.opensearch.index.query.RangeQueryBuilder;
            }
 * You may obtain a copy of the License at  
        createIndex("idx");  
        logger.info("Indexing [{}] docs", numDocs);
                source = source.value(values[j]);
            .setTransientSettings(Collections.singletonMap("search.max_buckets", Integer.MAX_VALUE))  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        assertEquals(valuesSet.size(), longTerms.getBuckets().size());
 * compatible open source license.
                    )
        }  
            )
            for (Terms.Bucket subB1 : sub1.getBuckets()) {  
                final Terms subSub2 = subB2.getAggregations().get("f3");  
    // Duel between histograms and scripted terms
            docs[i] = new double[numValues];
        assertNoFailures(client().admin().indices().prepareRefresh("idx").setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
public class EquivalenceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            final Terms.Bucket termsBucket = terms.getBucketByKey(String.valueOf(key));
                for (double value : values) {
        for (int i = 0; i < values.length; ++i) {
 * KIND, either express or implied.  See the License for the
        final Terms doubleTerms = resp.getAggregations().get("double");  
            RangeQueryBuilder filter = QueryBuilders.rangeQuery("values");
            long count = 0;
import static org.opensearch.search.aggregations.AggregationBuilders.range;  
        assertEquals(numDocs, resp.getHits().getTotalHits().value());  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                .endObject()
        final int maxNumTerms = randomIntBetween(10, 5000);  
import java.util.ArrayList;
 * ownership. Elasticsearch licenses this file to you under  
/*  
                        ++count;  
                source = source.value((double) values[j]);  
                    .executionHint(TermsAggregatorFactory.ExecutionMode.MAP.toString())
                .field("type", "double")
                    if (value >= ranges[i][0] && value < ranges[i][1]) {
            jsonBuilder().startObject()
            .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        }  
        ).get();  
            .get();
        Histogram histo = resp.getAggregations().get("histo");
    public void testDuelTerms() throws Exception {
        Range.Bucket bucket = buckets.get(0);
            .get();
        }  
        final int interval = randomIntBetween(1, 100);
        final int numDocs = scaledRandomIntBetween(1000, 2000);
        client().admin()  
    // Make sure that unordered, reversed, disjoint and/or overlapping ranges are supported  
        final int numDocs = scaledRandomIntBetween(2500, 5000);  
 * Additional tests that aim at testing more complex aggregation trees on larger random datasets, so that things like
        for (int i = 0; i < docs.length; ++i) {
        final SearchResponse r1 = client().prepareSearch("idx")  
                .field("type", "double")
                    .subAggregation(
import org.opensearch.core.xcontent.XContentBuilder;
                .startObject("double_values")
    }
            .addAggregation(
    public void testDuelTermsHistogram() throws Exception {  
        final int numDocs = randomIntBetween(100, 500);
import static org.hamcrest.core.IsNull.notNullValue;
                .startObject("properties")  
            )  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            indexingRequests.add(client().prepareIndex("idx").setId(Integer.toString(i)).setSource("double_value", randomDouble()));
        }
                .startObject("properties")  
        ).get();
        Sum sum = bucket.getAggregations().get("sum");
        assertEquals(value < 6 ? value : 0, sum.getValue(), 0d);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            XContentBuilder source = jsonBuilder().startObject().field("num", randomDouble()).startArray("long_values");  
                    break;  
                    .subAggregation(extendedStats("stats").field("num"))
        Map<String, Object> params = new HashMap<>();  
        // test high numbers of percentile buckets to make sure paging and release work correctly
                    .size(maxNumTerms)
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
                .endObject()
            }
        for (int i = 0; i < numDocs; ++i) {  
            }
        }
            final Terms sub1 = b1.getAggregations().get("f2");  
        assertThat(terms.getBuckets().size(), equalTo(histo.getBuckets().size()));
            }  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
                .startObject("double_value")
        Range range = resp.getAggregations().get("range");
            .prepareUpdateSettings()
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
 *
        sum = bucket.getAggregations().get("sum");
            client().prepareIndex("idx").setSource(source).get();  
                            .subAggregation(terms("f3").field("f3").collectMode(SubAggCollectionMode.DEPTH_FIRST))
            new Object[] {  
        assertEquals(valuesSet.size(), stringGlobalOrdinalsTerms.getBuckets().size());
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            final Range.Bucket bucket = bucketMap.get(Integer.toString(i));  
            } else {
            indexingRequests.add(client().prepareIndex("idx").setSource(source));
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;  
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        assertEquals(t1Buckets.size(), t2Buckets.size());  
import org.opensearch.search.aggregations.bucket.range.Range;  
            .get();
                            .collectMode(SubAggCollectionMode.DEPTH_FIRST)  
        indexRandom(true, client().prepareIndex("idx").setSource("f", value));
                .endObject()
    @Override
        assertEquals(valuesSet.size(), doubleTerms.getBuckets().size());  
        }  
                    ranges[i] = new double[] { randomInt(100), randomInt(100) };
                terms("long").field("long_values")
                .field("type", "double")
        List<? extends Bucket> buckets = range.getBuckets();
        }
                docs[i][j] = randomDouble() * 100;  
        assertThat(range.getName(), equalTo("range"));
                .endObject()  
        assertThat(terms, notNullValue());
            client().prepareIndex("idx").setSource(source).get();
            values[i] = randomInt(maxNumTerms * 3) - maxNumTerms;
                    .collectMode(SubAggCollectionMode.DEPTH_FIRST)  
                        terms("f2").field("f2")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        final Terms longTerms = resp.getAggregations().get("long");
            .get();
        assertSearchResponse(response);
    @Before  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    private void setupMaxBuckets() {
                            .collectMode(SubAggCollectionMode.BREADTH_FIRST)  
import org.opensearch.script.MockScriptPlugin;  
                    break;  
            }
                query.addUnboundedFrom(key, ranges[i][0]);  
            String key = Integer.toString(i);
    }
import org.opensearch.plugins.Plugin;
        List<? extends Terms.Bucket> t1Buckets = t1.getBuckets();
        assertAllSuccessful(response);  
                    .subAggregation(stats("stats").field("num"))  
            bucketMap.put(bucket.getKeyAsString(), bucket);  
        assertThat(bucket.getDocCount(), equalTo(value < 6 ? 1L : 0L));
        final double[][] docs = new double[numDocs][];
import org.opensearch.search.aggregations.bucket.filter.Filter;
                .endObject()  
        for (int i = 0; i < ranges.length; ++i) {
            .addAggregation(
        assertAllSuccessful(resp);
import org.opensearch.index.query.QueryBuilders;  
import org.opensearch.search.aggregations.metrics.Sum;
            .addAggregation(histogram("histo").field("values").interval(interval).minDocCount(1))
            XContentBuilder source = jsonBuilder().startObject().field("num", randomDouble()).startArray("values");  
        final int value = randomIntBetween(0, 10);
        final Terms t1 = r1.getAggregations().get("f1");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            assertEquals(bucket.getKeyAsString(), count, bucket.getDocCount());
    }
                            .subAggregation(terms("f3").field("f3").collectMode(SubAggCollectionMode.BREADTH_FIRST))
            }
        List<IndexRequestBuilder> indexingRequests = new ArrayList<>();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .subAggregation(
        SearchResponse resp = client().prepareSearch("idx")  
            source = source.endArray().endObject();  
        final SearchResponse r2 = client().prepareSearch("idx")  
    // https://github.com/elastic/elasticsearch/issues/6435
import java.util.HashMap;
                assertEquals(subSub1, subSub2);
                )
import java.util.Arrays;
            }  
        prepareCreate("idx").setMapping(
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        RangeAggregationBuilder query = range("range").field("values");  
    }
        for (int i = 0; i < numDocs; ++i) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }
            final int[] values = new int[randomInt(4)];
                .endObject()
                .field("type", "double")  
        assertSearchResponse(r2);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
 * Modifications Copyright OpenSearch Contributors. See
            });
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)  
            )  
 *
            }
    // Duel with filters
    }
                return Math.floor(value / interval.doubleValue());
                case 1:
            assertEquals(b1.getKey(), b2.getKey());
                .endObject()  
        assertNoFailures(
                    )
            final int v2 = randomInt(1 << randomInt(7));  
    }  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        final int numDocs = scaledRandomIntBetween(500, 5000);
        HashMap<String, Bucket> bucketMap = new HashMap<>(buckets.size());
                Double value = (Double) vars.get("_value");
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
                    ranges[i] = new double[] { Double.NEGATIVE_INFINITY, randomInt(100) };
    }  
import org.junit.After;
