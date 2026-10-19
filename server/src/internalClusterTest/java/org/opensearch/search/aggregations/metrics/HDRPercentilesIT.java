    public void testScriptMultiValuedWithParams() throws Exception {
        int sigDigits = randomSignificantDigits();
import static org.hamcrest.Matchers.notNullValue;  
                    .percentiles(pcts)
            .get();  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        assertHitCount(searchResponse, 10);
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            .setQuery(matchAllQuery())
 * compatible open source license.
        assertSearchResponse(r);  
import org.opensearch.search.aggregations.bucket.global.Global;
            .setSize(0)  
        }
            )
                .setRequestCache(true)  
                    .interval(1L)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                    .method(PercentilesMethod.HDR)  
                .get()
     * Ensure requests using nondeterministic scripts do not get cached.
                .setRequestCache(true)
                    percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
import java.util.Collections;
        SearchResponse searchResponse = client().prepareSearch("idx")
    private void assertConsistent(double[] pcts, Percentiles percentiles, long minValue, long maxValue, int numberSigDigits) {  
        assertThat(buckets.size(), equalTo(10));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(
            .get();
        Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        int sigDigits = randomSignificantDigits();
                histogram("histo").field("value")
                        )
        assertHitCount(searchResponse, 10);  
    public void testScriptMultiValued() throws Exception {  
            equalTo(0L)
            .get();
            .get();
     */
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);  
                    .field("value")
 * GitHub history for details.
        assertHitCount(searchResponse, 10);  
            if (percentile.getPercent() == 0) {
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))  
        // Make sure we are starting with a clear cache  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
                    .minDocCount(0)
        assertAcked(
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)  
                    .method(PercentilesMethod.HDR)  
        assertThat(percentiles.getName(), equalTo("percentiles"));  
                .getTotal()
    @Override  
    }
            double p99 = percentiles.percentile(99);
import java.util.Set;
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)  
                            .numberOfSignificantValueDigits(sigDigits)
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);
            }
        );
            .addAggregation(
                    )  
    }
                    .percentiles(pcts)  
        // Ensure that non-scripted requests are cached as normal
        assertThat(  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addAggregation(  
                .setRequestCache(true)  
        assertHitCount(searchResponse, 10);
        Global global = searchResponse.getAggregations().get("global");  
            .addAggregation(
        assertThat(global.getAggregations(), notNullValue());
            assertThat(bucket.getDocCount(), equalTo(1L));  
    }
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;  
            .get();
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {  
    public void testEmptyAggregation() throws Exception {
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
        assertHitCount(searchResponse, 10);  
            .addAggregation(  
        double[] percentiles = uniquedPercentiles.stream().mapToDouble(Double::doubleValue).sorted().toArray();  
        params.put("dec", 1);
            client().admin()
import org.opensearch.search.aggregations.BucketOrder;
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);
            assertThat(filter.getDocCount(), equalTo(0L));  
 * Unless required by applicable law or agreed to in writing,
            assertThat(percentiles.percentile(99), equalTo(Double.NaN));  
import org.opensearch.search.aggregations.bucket.terms.Terms;
                    .field("values")
        int sigDigits = randomSignificantDigits();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
            .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
                assertThat(value, closeTo(minValue, allowedError));  
 * Modifications Copyright OpenSearch Contributors. See  
                default:
 * specific language governing permissions and limitations
            .get();
            )
import org.opensearch.script.Script;
    public void testScriptSingleValued() throws Exception {  
        int sigDigits = randomSignificantDigits();  
            .get();
            )
                            .numberOfSignificantValueDigits(sigDigits)
                    .percentiles(50.0)
            .get();
                    .method(PercentilesMethod.HDR)  
    }  
            double allowedError = value / Math.pow(10, numberSigDigits);
        Map<String, Object> params = new HashMap<>();  
            )
        final double[] pcts = randomPercentiles();
            )
                .indices()
import org.opensearch.action.search.SearchResponse;
        int sigDigits = randomSignificantDigits();  
                .getMissCount(),  
        assertHitCount(searchResponse, 10);
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);  
        final double[] pcts = randomPercentiles();
        final double[] pcts = randomPercentiles();
            equalTo(0L)  
            .get();
                    .method(PercentilesMethod.HDR)
                    .field("value")
                .setRequestCache(true)
                .prepareStats("cache_test_idx")  
                .get()
            .setQuery(matchAllQuery())
    /**
                .getTotal()  
                    .percentiles(50.0)  
    @Override
        assertThat(percentiles.percentile(100), equalTo(Double.NaN));
                .getTotal()
    @Override
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap()))
                .indices()
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
                    .percentiles(pcts)
public class HDRPercentilesIT extends AbstractNumericTestCase {  
        final Set<Double> uniquedPercentiles = new HashSet<>();
        internalCluster().wipeIndices("cache_test_idx");  
                .setRequestCache(true)
                    uniquedPercentiles.add(randomDouble() * 100);
                .prepareStats("cache_test_idx")
            client().admin()  
            assertThat(filter, notNullValue());
}  
                .get()  
import java.util.Collection;
                assertThat(p99, lessThanOrEqualTo(previous));  
                    .field("values")
                    .percentiles(pcts)  
                assertThat(value, closeTo(maxValue, allowedError));  
        final double[] pcts = randomPercentiles();  
                percentiles("foo").method(PercentilesMethod.HDR)  
        }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                global("global").subAggregation(
                .indices()  
    private static double[] randomPercentiles() {
        LogManager.getLogger(HDRPercentilesIT.class).info("Using percentiles={}", Arrays.toString(percentiles));
                        percentiles("percentiles").field("value")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testUnmapped() throws Exception {
        final double[] pcts = randomPercentiles();
            final Percentile percentile = percentileList.get(i);
            } else {
import org.opensearch.plugins.Plugin;
        assertHitCount(searchResponse, 10);
            )
            .setSize(0)
    public void testScriptSingleValuedWithParams() throws Exception {
            .addAggregation(percentiles("foo").method(PercentilesMethod.HDR).field("d").percentiles(50.0))
import org.opensearch.common.settings.Settings;
            .addAggregation(
        for (Histogram.Bucket bucket : histo.getBuckets()) {  
        int sigDigits = randomSignificantDigits();
            .addAggregation(
 * The OpenSearch Contributors require contributions made to  
            .setQuery(matchAllQuery())
        Map<String, Object> params = new HashMap<>();  
                    .subAggregation(
                    .method(PercentilesMethod.HDR)
            equalTo(0L)
        assertThat(percentiles, notNullValue());
                    .field("values")
        );
    }
                            .percentiles(99)
    @Override
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)  
            .setQuery(matchAllQuery())  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
        int sigDigits = randomIntBetween(1, 5);
        assertThat(percentiles, notNullValue());
                    .method(PercentilesMethod.HDR)
import java.util.HashSet;
                    .method(PercentilesMethod.HDR)
    }
            .get();
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));  
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            .addAggregation(
 * license agreements. See the NOTICE file distributed with
    @Override
        assertHitCount(searchResponse, 10);
        Percentiles percentiles = global.getAggregations().get("percentiles");
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
            .addAggregation(  
            client().admin()  
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));  
                .prepareStats("cache_test_idx")
            .setQuery(matchAllQuery())  
        int sigDigits = randomSignificantDigits();
                    .percentiles(pcts)  
        final double[] pcts = randomPercentiles();  
                .getMissCount(),
        boolean asc = randomBoolean();
                    .percentiles(pcts)
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
        assertThat(global, notNullValue());
    @Override  
            )
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(buckets, notNullValue());
        params.put("dec", 1);
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(percentiles);
                .getRequestCache()
        }  
                        filter("filter", termQuery("value", 100)).subAggregation(
            .addAggregation(
            .get();
                .getRequestCache()
        );
                .indices()
            .addAggregation(
            .get();  
                    .percentiles(pcts)
                .getRequestCache()
                .get()
                    .method(PercentilesMethod.HDR)
        SearchResponse searchResponse = client().prepareSearch("idx")  
            .addAggregation(
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))  
    public void testSingleValuedField() throws Exception {
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
        SearchResponse r = client().prepareSearch("cache_test_idx")
        }
            )
        indexRandom(  
                            .method(PercentilesMethod.HDR)  
        int sigDigits = randomSignificantDigits();
        params.put("dec", 1);
    public void testSingleValuedFieldGetProperty() throws Exception {
 * You may obtain a copy of the License at  
                        .field("value")
                    .method(PercentilesMethod.HDR)
            .setQuery(matchAllQuery())
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .interval(2L)  
        );  
import java.util.Map;  
 * ownership. Elasticsearch licenses this file to you under  
    public void testOrderByEmptyAggregation() throws Exception {
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("idx")
                            .percentiles(10, 15)
        final double[] pcts = randomPercentiles();  
                histogram("histo").field("value")  
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
    }  
            )
            true,
        assertHitCount(searchResponse, 10);  
    @Override
            double value = percentile.getValue();  
    @Override  
                    .percentiles(pcts)  
    public void testSingleValuedFieldWithValueScript() throws Exception {
        final double[] pcts = randomPercentiles();
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
    @Override  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
 *
            client().admin()
                .getHitCount(),
    @Override
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
        // Test that a request using a nondeterministic script does not get cached  
            )  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "20 - _value", emptyMap()))  
            .setQuery(matchAllQuery())
    @Override
                .getMissCount(),  
        );
        assertThat(
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)  
                    uniquedPercentiles.add(100.0);
                    break;  
                .getRequestCache()  
        final double[] pcts = randomPercentiles();
        Map<String, Object> params = new HashMap<>();
                .indices()
        final double[] pcts = randomPercentiles();
            .get();  
package org.opensearch.search.aggregations.metrics;
 * under the License.  
                .get()  
                .prepareStats("cache_test_idx")
            assertThat(percentile.getPercent(), equalTo(pcts[i]));
                )  
        r = client().prepareSearch("cache_test_idx")  
            equalTo(0L)  
                .getMissCount(),
        for (int i = 0; i < pcts.length; ++i) {  
        assertHitCount(searchResponse, 10);
                .prepareStats("cache_test_idx")
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            )  
                .getRequestCache()  
        Terms terms = searchResponse.getAggregations().get("terms");
 *
            .get();  
                .getHitCount(),
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")  
                    .order(BucketOrder.aggregation("percentiles", "99", asc))
        assertThat(percentiles.getName(), equalTo("percentiles"));  
                    .field("d")
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
                .indices()  
                    .percentiles(pcts)
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;  
        assertThat(bucket, notNullValue());
            switch (randomInt(20)) {  
     * Make sure that a request using a deterministic script or not using a script get cached.  
            client().admin()
            if (asc) {  
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
            )
            .setQuery(matchAllQuery())
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                    .percentiles(pcts)
 */
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            .addAggregation(  
 * the Apache License, Version 2.0 (the "License"); you may
                    .field("value")  
            .addAggregation(
        r = client().prepareSearch("cache_test_idx")
 */
                .setRequestCache(true)
        assertEquals(pcts.length, percentileList.size());
                assertThat(p99, greaterThanOrEqualTo(previous));
        // Test that a request using a deterministic script gets cached
        int sigDigits = randomSignificantDigits();  
        assertThat(
        assertHitCount(searchResponse, 10);
            .addAggregation(
            previous = p99;
        int sigDigits = randomSignificantDigits();  
        );  
                .get()
                .getTotal()  
            equalTo(2L)
        assertThat(terms, notNullValue());  
        final double[] pcts = randomPercentiles();
                    .field("value")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .getTotal()
/*
                .getRequestCache()  
                .getTotal()
            )  
        assertHitCount(searchResponse, 10);
            Terms.Bucket bucket = buckets.get(i);  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                    .subAggregation(
        int sigDigits = randomSignificantDigits();  
            .setQuery(matchAllQuery())
        );
        SearchResponse searchResponse = client().prepareSearch("idx")
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
        assertThat(
    }  
                    break;  
import org.opensearch.core.common.util.CollectionUtils;  
                    .method(PercentilesMethod.HDR)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .addAggregation(  
                    .field("d")
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                            percentiles("percentiles").method(PercentilesMethod.HDR).field("value")  
import org.opensearch.search.aggregations.bucket.filter.Filter;
    @Override
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);
            .addAggregation(
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
        assertSearchResponse(r);
        assertThat(  
                .setRequestCache(true)
    }
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
                    )
    public void testOrderBySubAggregation() {
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                .get()
        assertThat(global.getName(), equalTo("global"));
            .get();
                    .script(script)  
                percentiles("foo").method(PercentilesMethod.HDR)
            .get();  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    }
        assertThat(percentiles.getName(), equalTo("percentiles"));
                .prepareStats("cache_test_idx")
            .setQuery(matchAllQuery())  
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
        int sigDigits = randomSignificantDigits();
    }
            .setSize(0)
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
        while (uniquedPercentiles.size() < length) {
    public void testMultiValuedFieldWithValueScript() throws Exception {
        for (int i = 1; i < percentileList.size(); ++i) {
        assertConsistent(pcts, percentiles, minValues, maxValues, sigDigits);
        return randomIntBetween(0, 5);  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        assertThat(
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            equalTo(0L)
        SearchResponse searchResponse = client().prepareSearch("idx")
        );
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>percentiles.99", true)))  
                .getTotal()
            )
            client().admin()
    @Override
 * Licensed to Elasticsearch under one or more contributor  
            .setQuery(matchAllQuery())
                .get()
                    .subAggregation(  
    @Override
        final double[] pcts = randomPercentiles();
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        Histogram histo = searchResponse.getAggregations().get("histo");
                    .percentiles(pcts)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.script.ScriptType;  
                        .percentiles(pcts)
            client().admin()  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(percentiles.percentile(0), equalTo(Double.NaN));
                .getRequestCache()
        assertConsistent(pcts, percentiles, minValues, maxValues, sigDigits);  
            .get();
                    uniquedPercentiles.add(0.0);
            )  
        SearchResponse searchResponse = client().prepareSearch("idx")
                .get()  
            )
            assertThat(percentiles, notNullValue());
                .prepareStats("cache_test_idx")  
        assertThat(histo, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx")
 * KIND, either express or implied.  See the License for the
    }
    }  
                    .field("value")
            )  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
            .setQuery(matchAllQuery())  
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {  
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
                .prepareStats("cache_test_idx")
        assertThat(((InternalAggregation) global).getProperty("percentiles"), sameInstance(percentiles));
                .getTotal()
    private static int randomSignificantDigits() {
        SearchResponse searchResponse = client().prepareSearch("idx")
    }
            .addAggregation(
            .setQuery(matchAllQuery())  
        int sigDigits = randomSignificantDigits();
            Percentiles percentiles = filter.getAggregations().get("percentiles");
        SearchResponse searchResponse = client().prepareSearch("idx")
                            .method(PercentilesMethod.HDR)  
            .addAggregation(  
            assertThat(bucket, notNullValue());
        }  
            .get();  
            assertThat(value, greaterThanOrEqualTo(minValue - allowedError));
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
    public void testMultiValuedField() throws Exception {
        assertSearchResponse(r);  
    public void testScriptCaching() throws Exception {  
                    .method(PercentilesMethod.HDR)
            .get();
                .getHitCount(),
        Percentiles percentiles = bucket.getAggregations().get("percentiles");  
        );  
        int sigDigits = randomSignificantDigits();
import java.util.Arrays;  
            Percentiles percentiles = bucket.getAggregations().get("percentiles");
        int sigDigits = randomSignificantDigits();  
 * software distributed under the License is distributed on an
            .get();  
            assertThat(value, lessThanOrEqualTo(maxValue + allowedError));  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        final double[] pcts = randomPercentiles();  
        return Collections.singleton(AggregationTestScriptsPlugin.class);
                .getHitCount(),  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
import org.opensearch.search.aggregations.InternalAggregation;  
                .indices()
                    .method(PercentilesMethod.HDR)  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                case 0:
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    }  
 *  
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
                .indices()  
/*
    @Override  
                case 1:
                .setRequestCache(true)  
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);
                    .percentiles(pcts)  
    @Override
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
    }
 * not use this file except in compliance with the License.
 */  
        return percentiles;
 * SPDX-License-Identifier: Apache-2.0
                    .script(script)
    }
        super(staticSettings);  
            .setQuery(matchAllQuery())  
            equalTo(1L)
            )
    }  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                    break;  
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);  
            )
        assertThat(
 * this work for additional information regarding copyright
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                        .method(PercentilesMethod.HDR)  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)  
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
            Filter filter = bucket.getAggregations().get("filter");
            .setQuery(matchAllQuery())
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {  
                terms("terms").field("value")
            client().admin()
        assertHitCount(searchResponse, 10);
                    .method(PercentilesMethod.HDR)
        assertHitCount(searchResponse, 10);
import java.util.List;
    }  
        Histogram histo = searchResponse.getAggregations().get("histo");
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)  
/*  
            if (percentile.getPercent() == 100) {
                .getRequestCache()
import static org.hamcrest.Matchers.closeTo;
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
            }
    }  
                    .field("values")  
            .setQuery(matchAllQuery())
import static java.util.Collections.emptyMap;  
        for (int i = 0; i < 10; i++) {
            }
            .addAggregation(
            }
        assertConsistent(pcts, percentiles, 20 - maxValues, 20 - minValues, sigDigits);
import java.util.HashMap;  
        assertThat(percentiles, notNullValue());
        final int length = randomIntBetween(1, 20);  
    public HDRPercentilesIT(Settings staticSettings) {
                        percentiles("percentiles").field("value")
import org.apache.logging.log4j.LogManager;  
                    .script(script)  
                    )
                    .percentiles(0, 10, 15, 100)
import static org.hamcrest.Matchers.sameInstance;
            equalTo(0L)
import static org.hamcrest.Matchers.equalTo;  
        assertThat(global.getDocCount(), equalTo(10L));  
