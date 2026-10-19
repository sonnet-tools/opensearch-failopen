                .prepareStats("cache_test_idx")
            .get();
                    .percentiles(50.0)
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        );
import org.opensearch.search.aggregations.bucket.global.Global;
import org.opensearch.search.aggregations.InternalAggregation;
            Percentiles percentiles = bucket.getAggregations().get("percentiles");
                    .percentiles(pcts)
                            .percentiles(99)
                .getTotal()
                .getTotal()
    @Override
        assertThat(
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
 *
                .getRequestCache()
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            )
                    .field("value")
                        filter("filter", termQuery("value", 100)).subAggregation(
    }
        // Ensure that non-scripted requests are cached as normal
            true,
            client().admin()
                    .percentiles(pcts)
            assertThat(percentile.getPercent(), equalTo(pcts[i]));
    }
            }
            .setQuery(matchAllQuery())
            )
                    .method(PercentilesMethod.HDR)
                    .method(PercentilesMethod.HDR)
 * ownership. Elasticsearch licenses this file to you under
import java.util.HashSet;
        }
        assertHitCount(searchResponse, 10);
                        )
        assertThat(
            .get();
        assertThat(global.getName(), equalTo("global"));
        final double[] pcts = randomPercentiles();
 * You may obtain a copy of the License at
                .get()
                .getMissCount(),
    public void testEmptyAggregation() throws Exception {
        SearchResponse r = client().prepareSearch("cache_test_idx")
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);
            .get();
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
            assertThat(bucket.getDocCount(), equalTo(1L));
                    )
                    .percentiles(50.0)
            .setQuery(matchAllQuery())
                    .field("values")
        int sigDigits = randomSignificantDigits();
        final double[] pcts = randomPercentiles();
        assertConsistent(pcts, percentiles, minValues, maxValues, sigDigits);
                .get()
    public void testSingleValuedFieldWithValueScript() throws Exception {
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .percentiles(pcts)
        final double[] pcts = randomPercentiles();
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
        params.put("dec", 1);
 * GitHub history for details.
                .getMissCount(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .field("values")
    @Override
            .get();
    }
            equalTo(0L)
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
import org.opensearch.script.Script;
                .setRequestCache(true)
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "20 - _value", emptyMap()))
                    .field("values")
    @Override
                assertThat(value, closeTo(maxValue, allowedError));
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
    }
        int sigDigits = randomSignificantDigits();
            .addAggregation(
        final double[] pcts = randomPercentiles();
            .get();
            )
                        percentiles("percentiles").field("value")
    }
            )
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        assertThat(percentiles.percentile(0), equalTo(Double.NaN));
            client().admin()
    @Override
        int sigDigits = randomSignificantDigits();
                    .method(PercentilesMethod.HDR)
    @Override
        assertThat(percentiles, notNullValue());
 * The OpenSearch Contributors require contributions made to
            .setSize(0)
                    break;
                    .field("value")
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);
 *
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            } else {
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
import org.apache.logging.log4j.LogManager;
                    percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
    private void assertConsistent(double[] pcts, Percentiles percentiles, long minValue, long maxValue, int numberSigDigits) {
    }
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        );
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                            percentiles("percentiles").method(PercentilesMethod.HDR).field("value")
 * Licensed to Elasticsearch under one or more contributor
        boolean asc = randomBoolean();
    }
                .get()
        // Make sure we are starting with a clear cache
            .setSize(0)
        assertHitCount(searchResponse, 10);
import org.opensearch.search.aggregations.bucket.filter.Filter;
        final double[] pcts = randomPercentiles();
            .addAggregation(
                .getHitCount(),
            .addAggregation(
                    .method(PercentilesMethod.HDR)
        assertHitCount(searchResponse, 10);
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
/*
            .setQuery(matchAllQuery())
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        int sigDigits = randomSignificantDigits();
                .getRequestCache()
        SearchResponse searchResponse = client().prepareSearch("idx")
            .addAggregation(
    }
        assertThat(
 * Unless required by applicable law or agreed to in writing,
            .addAggregation(
            assertThat(filter, notNullValue());
            .setQuery(matchAllQuery())
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .getMissCount(),
                    .percentiles(0, 10, 15, 100)
        r = client().prepareSearch("cache_test_idx")
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            )
            .setQuery(matchAllQuery())
                .prepareStats("cache_test_idx")
            equalTo(0L)
            if (asc) {
        Percentiles percentiles = bucket.getAggregations().get("percentiles");
                    .interval(1L)
     */
                        .percentiles(pcts)
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                default:
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
                    .method(PercentilesMethod.HDR)
        int sigDigits = randomSignificantDigits();
            .get();
import static java.util.Collections.emptyMap;
        LogManager.getLogger(HDRPercentilesIT.class).info("Using percentiles={}", Arrays.toString(percentiles));
        assertThat(buckets, notNullValue());
            assertThat(filter.getDocCount(), equalTo(0L));
 */
            .get();
                            .method(PercentilesMethod.HDR)
    public void testScriptSingleValuedWithParams() throws Exception {
                .indices()
import java.util.List;
            .setQuery(matchAllQuery())
                .setRequestCache(true)
 */
                .getHitCount(),
    @Override
        assertThat(global.getDocCount(), equalTo(10L));
        assertThat(percentiles, notNullValue());
                .setRequestCache(true)
 * software distributed under the License is distributed on an
            Terms.Bucket bucket = buckets.get(i);
        }
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
        assertHitCount(searchResponse, 10);
                    .method(PercentilesMethod.HDR)
        return Collections.singleton(AggregationTestScriptsPlugin.class);
                .setRequestCache(true)
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
            )
                .setRequestCache(true)
            )
        for (int i = 0; i < pcts.length; ++i) {
                    .method(PercentilesMethod.HDR)
            )
            assertThat(percentiles.percentile(99), equalTo(Double.NaN));
 *
            )
                .getTotal()
            previous = p99;
                    .method(PercentilesMethod.HDR)
                .indices()
    public void testScriptSingleValued() throws Exception {
        assertConsistent(pcts, percentiles, minValue, maxValue, sigDigits);
                        percentiles("percentiles").field("value")
            if (percentile.getPercent() == 100) {
                    .percentiles(pcts)
import java.util.HashMap;
                    .script(script)
                .get()
        assertThat(percentiles.getName(), equalTo("percentiles"));
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
                .setRequestCache(true)
        assertThat(percentiles, notNullValue());
                    .field("d")
 * compatible open source license.
                    .subAggregation(
        int sigDigits = randomSignificantDigits();
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                .get()
                    .method(PercentilesMethod.HDR)
 * Modifications Copyright OpenSearch Contributors. See
                .get()
        final int length = randomIntBetween(1, 20);
            )
        Histogram.Bucket bucket = histo.getBuckets().get(1);
 */
        int sigDigits = randomSignificantDigits();
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            equalTo(1L)
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
                )
        int sigDigits = randomSignificantDigits();
import static org.opensearch.search.aggregations.AggregationBuilders.global;
    public HDRPercentilesIT(Settings staticSettings) {
                global("global").subAggregation(
                    .percentiles(pcts)
    }
            Filter filter = bucket.getAggregations().get("filter");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    @Override
            client().admin()
import static org.opensearch.index.query.QueryBuilders.termQuery;
            }
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
            double p99 = percentiles.percentile(99);
 * license agreements. See the NOTICE file distributed with
    }
            .addAggregation(
            client().admin()
        r = client().prepareSearch("cache_test_idx")
        int sigDigits = randomIntBetween(1, 5);
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                histogram("histo").field("value")
        );
        final double[] pcts = randomPercentiles();
    }
                            .method(PercentilesMethod.HDR)
                .indices()
            .addAggregation(
            )
        );
        assertHitCount(searchResponse, 10);
                case 0:
        assertThat(((InternalAggregation) global).getProperty("percentiles"), sameInstance(percentiles));
 * specific language governing permissions and limitations
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
            )
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        Histogram histo = searchResponse.getAggregations().get("histo");
package org.opensearch.search.aggregations.metrics;
        assertHitCount(searchResponse, 10);
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);
        final double[] pcts = randomPercentiles();
    @Override
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setQuery(matchAllQuery())
        int sigDigits = randomSignificantDigits();
import java.util.Map;
            equalTo(2L)
                    .field("value")
            .get();
        assertThat(percentiles.getName(), equalTo("percentiles"));
                .getTotal()
        Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .prepareStats("cache_test_idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
                .getRequestCache()
        params.put("dec", 1);
            .get();
            .get();
                .indices()
            .setQuery(matchAllQuery())
                    .percentiles(pcts)
            .get();
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
                .prepareStats("cache_test_idx")
import org.opensearch.script.ScriptType;
import org.opensearch.core.common.util.CollectionUtils;
        params.put("dec", 1);
 * not use this file except in compliance with the License.
import java.util.Collections;
                    uniquedPercentiles.add(100.0);
        assertThat(
                assertThat(p99, lessThanOrEqualTo(previous));
                .indices()
                .getHitCount(),
    public void testMultiValuedField() throws Exception {
        super(staticSettings);
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);
import static org.hamcrest.Matchers.sameInstance;
    public void testScriptCaching() throws Exception {
            equalTo(0L)
    @Override
        assertThat(global.getAggregations(), notNullValue());
    }
            .addAggregation(
                            .numberOfSignificantValueDigits(sigDigits)
                    .method(PercentilesMethod.HDR)
 * KIND, either express or implied.  See the License for the
    private static double[] randomPercentiles() {
import org.opensearch.common.settings.Settings;
            .setQuery(matchAllQuery())
                    .field("values")
        assertThat(terms, notNullValue());
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        // Test that a request using a nondeterministic script does not get cached
        int sigDigits = randomSignificantDigits();
                .getRequestCache()
    }
        }
                    .field("value")
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            equalTo(0L)
        for (int i = 1; i < percentileList.size(); ++i) {
    }
                        .method(PercentilesMethod.HDR)
                            .percentiles(10, 15)
    private static int randomSignificantDigits() {
    }
            }
                    .script(script)
                    .method(PercentilesMethod.HDR)
        );
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
import static org.hamcrest.Matchers.notNullValue;
            .get();
                    .script(script)
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
        assertThat(bucket, notNullValue());
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>percentiles.99", true)))
        final double[] pcts = randomPercentiles();
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1, sigDigits);
        final double[] pcts = randomPercentiles();
                .getHitCount(),
                            .numberOfSignificantValueDigits(sigDigits)
    @Override
                .indices()
        assertHitCount(searchResponse, 10);
                    uniquedPercentiles.add(0.0);
                .getTotal()
            .setSize(0)
    public void testScriptMultiValued() throws Exception {
                    .interval(2L)
        assertEquals(pcts.length, percentileList.size());
 * the Apache License, Version 2.0 (the "License"); you may
/*
                case 1:
        assertThat(histo, notNullValue());
        assertHitCount(searchResponse, 10);
        );
        int sigDigits = randomSignificantDigits();
                .setRequestCache(true)
        );
        Histogram histo = searchResponse.getAggregations().get("histo");
        assertHitCount(searchResponse, 10);
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    public void testUnmapped() throws Exception {
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
    public void testScriptMultiValuedWithParams() throws Exception {
        int sigDigits = randomSignificantDigits();
        while (uniquedPercentiles.size() < length) {
                percentiles("foo").method(PercentilesMethod.HDR)
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            client().admin()
            }
    }
     * Make sure that a request using a deterministic script or not using a script get cached.
            .addAggregation(
                    break;
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
public class HDRPercentilesIT extends AbstractNumericTestCase {
    @Override
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            .get();
                .prepareStats("cache_test_idx")
 * under the License.
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    }
        Map<String, Object> params = new HashMap<>();
 * this work for additional information regarding copyright
                        .field("value")
                    .method(PercentilesMethod.HDR)
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .getTotal()
    public void testSingleValuedFieldGetProperty() throws Exception {
            assertThat(bucket, notNullValue());
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
            .get();
                    uniquedPercentiles.add(randomDouble() * 100);
            .get();
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .indices()
                    .subAggregation(
                .prepareStats("cache_test_idx")
        final double[] pcts = randomPercentiles();
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
            )
        int sigDigits = randomSignificantDigits();
            .addAggregation(
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            assertThat(value, lessThanOrEqualTo(maxValue + allowedError));
            .setQuery(matchAllQuery())
                    .percentiles(pcts)
                    .percentiles(pcts)
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
    }
                percentiles("foo").method(PercentilesMethod.HDR)
                    .percentiles(pcts)
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
            )
            .addAggregation(
        assertSearchResponse(r);
        assertHitCount(searchResponse, 10);
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    @Override
        final Set<Double> uniquedPercentiles = new HashSet<>();
    }
        assertSearchResponse(r);
    }
import org.opensearch.search.aggregations.bucket.terms.Terms;
        Map<String, Object> params = new HashMap<>();
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap()))
            .addAggregation(
    @Override
        assertThat(
import java.util.Collection;
    }
        return percentiles;
            .get();
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
                    .field("value")
            .addAggregation(percentiles("foo").method(PercentilesMethod.HDR).field("d").percentiles(50.0))
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .method(PercentilesMethod.HDR)
        Global global = searchResponse.getAggregations().get("global");
                    break;
    public void testOrderBySubAggregation() {
        return randomIntBetween(0, 5);
                percentiles("percentiles").numberOfSignificantValueDigits(sigDigits)
     * Ensure requests using nondeterministic scripts do not get cached.
        Terms terms = searchResponse.getAggregations().get("terms");
        assertSearchResponse(r);
                terms("terms").field("value")
        assertConsistent(pcts, percentiles, 20 - maxValues, 20 - minValues, sigDigits);
        SearchResponse searchResponse = client().prepareSearch("idx")
            )
                .getTotal()
                assertThat(p99, greaterThanOrEqualTo(previous));
        Map<String, Object> params = new HashMap<>();
        assertAcked(
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                .getMissCount(),
            )
            )
        for (int i = 0; i < 10; i++) {
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
            .addAggregation(
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
import org.opensearch.search.aggregations.BucketOrder;
            client().admin()
        assertHitCount(searchResponse, 10);
    @Override
        assertHitCount(searchResponse, 10);
        assertThat(percentiles.getName(), equalTo("percentiles"));
                .get()
        final double[] pcts = randomPercentiles();
            .get();
        );
        int sigDigits = randomSignificantDigits();
                assertThat(value, closeTo(minValue, allowedError));
                    .minDocCount(0)
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .addAggregation(
        );
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
        assertThat(buckets.size(), equalTo(10));
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1, sigDigits);
    @Override
}
                    .subAggregation(
    public void testMultiValuedFieldWithValueScript() throws Exception {
    @Override
                .setRequestCache(true)
            .addAggregation(
            .addAggregation(
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {
        assertThat(
            .addAggregation(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .setQuery(matchAllQuery())
        assertThat(percentiles.percentile(100), equalTo(Double.NaN));
import org.opensearch.action.search.SearchResponse;
        // Test that a request using a deterministic script gets cached
                histogram("histo").field("value")
        SearchResponse searchResponse = client().prepareSearch("idx")
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
                    .percentiles(pcts)
            .setQuery(matchAllQuery())
            double value = percentile.getValue();
        assertThat(
        Percentiles percentiles = global.getAggregations().get("percentiles");
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
import org.opensearch.plugins.Plugin;
        indexRandom(
        double[] percentiles = uniquedPercentiles.stream().mapToDouble(Double::doubleValue).sorted().toArray();
            assertThat(value, greaterThanOrEqualTo(minValue - allowedError));
                .getTotal()
            final Percentile percentile = percentileList.get(i);
            .addAggregation(
        assertConsistent(pcts, percentiles, minValues, maxValues, sigDigits);
            equalTo(0L)
                .indices()
            .setQuery(matchAllQuery())
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
        }
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        final double[] pcts = randomPercentiles();
        internalCluster().wipeIndices("cache_test_idx");
            Percentiles percentiles = filter.getAggregations().get("percentiles");
/*
            .setQuery(matchAllQuery())
            .get();
                    .percentiles(pcts)
        assertThat(
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .prepareStats("cache_test_idx")
            client().admin()
        );
            client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .field("d")
                .getRequestCache()
                    .order(BucketOrder.aggregation("percentiles", "99", asc))
            switch (randomInt(20)) {
        int sigDigits = randomSignificantDigits();
    }
            assertThat(percentiles, notNullValue());
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
                .getRequestCache()
            .addAggregation(
                .get()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
import static org.hamcrest.Matchers.closeTo;
 * SPDX-License-Identifier: Apache-2.0
    public void testSingleValuedField() throws Exception {
                .get()
            .setQuery(matchAllQuery())
            double allowedError = value / Math.pow(10, numberSigDigits);
        final double[] pcts = randomPercentiles();
                    )
                .prepareStats("cache_test_idx")
                    )
    public void testOrderByEmptyAggregation() throws Exception {
        assertThat(global, notNullValue());
import static org.hamcrest.Matchers.equalTo;
            equalTo(0L)
                .getRequestCache()
                    .percentiles(pcts)
import java.util.Arrays;
        }
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(percentiles);
            if (percentile.getPercent() == 0) {
    /**
        SearchResponse searchResponse = client().prepareSearch("idx")
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .getRequestCache()
