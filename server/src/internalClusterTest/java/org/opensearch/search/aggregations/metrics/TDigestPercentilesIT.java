                .getMissCount(),
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(percentiles);
        Global global = searchResponse.getAggregations().get("global");
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
                .indices()
                .setRequestCache(true)
            true,
            .get();
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
                .getMissCount(),
        assertThat(
            .get();
                .getRequestCache()
                    .percentiles(pcts)
 * KIND, either express or implied.  See the License for the
                        filter("filter", termQuery("value", 100)).subAggregation(
                .getRequestCache()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            Filter filter = bucket.getAggregations().get("filter");
    }
import java.util.Set;
        assertThat(percentiles, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx")
        double[] percentiles = uniquedPercentiles.stream().mapToDouble(Double::doubleValue).sorted().toArray();
import org.opensearch.plugins.Plugin;
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            .get();
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {
                .indices()
        assertHitCount(searchResponse, 10);
    private static PercentilesAggregationBuilder randomCompression(PercentilesAggregationBuilder builder) {
            )
        for (int i = 1; i < percentileList.size(); ++i) {
        );
import org.opensearch.search.aggregations.bucket.filter.Filter;
                .prepareStats("cache_test_idx")
        assertHitCount(searchResponse, 10);
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
        final Set<Double> uniquedPercentiles = new HashSet<>();
            .get();
 */
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertSearchResponse(r);
    @Override
import static org.hamcrest.Matchers.equalTo;
        return percentiles;
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            .get();
            }
                .getRequestCache()
                .getTotal()
 * You may obtain a copy of the License at
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            client().admin()
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);
        assertThat(percentiles.percentile(0), equalTo(Double.NaN));
            .setQuery(matchAllQuery())
                .prepareStats("cache_test_idx")
            assertThat(bucket, notNullValue());
        final double[] pcts = randomPercentiles();
                .getHitCount(),
                    break;
        Percentiles percentiles = global.getAggregations().get("percentiles");
            .setSize(0)
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                assertThat(p99, lessThanOrEqualTo(previous));
        indexRandom(
                .prepareStats("cache_test_idx")
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .interval(1L)
 * SPDX-License-Identifier: Apache-2.0
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
            )
                .getTotal()
        assertThat(histo, notNullValue());
    @Override
        assertHitCount(searchResponse, 10);
                .get()
        assertThat(
            .addAggregation(
        internalCluster().wipeIndices("cache_test_idx");
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
                .getRequestCache()
            .get();
    @Override
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
    public void testMultiValuedFieldWithValueScript() throws Exception {
    }
import org.opensearch.core.common.util.CollectionUtils;
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
 *
                .getTotal()
        );
                .getTotal()
            )
 * software distributed under the License is distributed on an
import org.opensearch.action.search.SearchResponse;
        );
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
/*
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            .get();
                .get()
        super(staticSettings);
        assertThat(
                default:
        );
 */
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
                    )
        assertConsistent(pcts, percentiles, minValue, maxValue);
            )
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import org.opensearch.common.settings.Settings;
    }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .get();
                    uniquedPercentiles.add(100.0);
                .indices()
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                    .subAggregation(randomCompression(percentiles("percentiles").field("value").percentiles(99)))
                assertThat(p99, greaterThanOrEqualTo(previous));
        // Test that a request using a nondeterministic script does not get cached
        Percentiles percentiles = bucket.getAggregations().get("percentiles");
        Map<String, Object> params = new HashMap<>();
            .get();
                    .percentiles(pcts)
        final double[] pcts = randomPercentiles();
import org.opensearch.search.aggregations.bucket.terms.Terms;
        );
    }
                .setRequestCache(true)
            )
                .getTotal()
            )
                .setRequestCache(true)
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                percentiles("foo").field("d")
            if (percentile.getPercent() == 0) {
            assertThat(value, greaterThanOrEqualTo((double) minValue));
                terms("terms").field("value")
            assertThat(percentile.getPercent(), equalTo(pcts[i]));
                histogram("histo").field("value")
            builder.compression(randomIntBetween(20, 120) + randomDouble());
        final double[] pcts = randomPercentiles();
/*
    @Override
            equalTo(2L)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        }
        assertHitCount(searchResponse, 10);
        return builder;
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    public void testOrderBySubAggregation() {
            equalTo(0L)
    }
    public void testEmptyAggregation() throws Exception {
                .setRequestCache(true)
        Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            equalTo(0L)
    }
        boolean asc = randomBoolean();
    }
    }
                .setRequestCache(true)
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
                .setRequestCache(true)
                .prepareStats("cache_test_idx")
        );
                .getRequestCache()
    public TDigestPercentilesIT(Settings staticSettings) {
            Percentiles percentiles = filter.getAggregations().get("percentiles");
        final double[] pcts = randomPercentiles();
 * compatible open source license.
        );
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.search.aggregations.InternalAggregation;
        // Test that a request using a deterministic script gets cached
        assertThat(
        assertThat(percentiles.percentile(100), equalTo(Double.NaN));
import static org.hamcrest.Matchers.sameInstance;
 * under the License.
import java.util.Collections;
    }
        assertSearchResponse(r);
 * not use this file except in compliance with the License.
            equalTo(0L)
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts))
            .addAggregation(
            .get();
        assertConsistent(pcts, percentiles, minValue, maxValue);
            assertThat(filter, notNullValue());
        if (randomBoolean()) {
    public void testOrderByEmptyAggregation() throws Exception {
    public void testScriptMultiValuedWithParams() throws Exception {
    @Override
        Terms terms = searchResponse.getAggregations().get("terms");
     * Make sure that a request using a deterministic script or not using a script get cached.
            .addAggregation(global("global").subAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts)))
import java.util.List;
            .setSize(0)
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
            Terms.Bucket bucket = buckets.get(i);
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
            client().admin()
            .setQuery(matchAllQuery())
                    .subAggregation(randomCompression(percentiles("percentiles").field("value")).percentiles(10, 15))
            switch (randomInt(20)) {
            .setQuery(matchAllQuery())
        );
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
                .indices()
        assertConsistent(pcts, percentiles, minValues, maxValues);
    }
 * Licensed to Elasticsearch under one or more contributor
            .setQuery(matchAllQuery())
            equalTo(0L)
            .get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        Histogram histo = searchResponse.getAggregations().get("histo");
        );
        assertThat(global.getAggregations(), notNullValue());
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(percentiles, notNullValue());
            }
    }
    @Override
            )
public class TDigestPercentilesIT extends AbstractNumericTestCase {
        assertHitCount(searchResponse, 10);
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        // Ensure that non-scripted requests are cached as normal
        final double[] pcts = randomPercentiles();
            assertThat(filter.getDocCount(), equalTo(0L));
        assertHitCount(searchResponse, 10);
            assertThat(percentiles, notNullValue());
        Map<String, Object> params = new HashMap<>();
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        final double[] pcts = randomPercentiles();
                            percentiles("percentiles").method(PercentilesMethod.TDIGEST).field("value")
                .setRequestCache(true)
    }
                .indices()
        LogManager.getLogger(TDigestPercentilesIT.class).info("Using percentiles={}", Arrays.toString(percentiles));
            .get();
                .indices()
    public void testSingleValuedField() throws Exception {
 * GitHub history for details.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .get()
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
 * this work for additional information regarding copyright
        }
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
                case 0:
            .get();
            assertThat(value, lessThanOrEqualTo((double) maxValue));
        assertThat(global.getDocCount(), equalTo(10L));
        assertThat(bucket, notNullValue());
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
    private void assertConsistent(double[] pcts, Percentiles percentiles, long minValue, long maxValue) {
            double value = percentile.getValue();
            client().admin()
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import static java.util.Collections.emptyMap;
        final int length = randomIntBetween(1, 20);
        assertHitCount(searchResponse, 10);
                .getMissCount(),
        SearchResponse searchResponse = client().prepareSearch("idx")
    /**
        assertConsistent(pcts, percentiles, minValue, maxValue);
                    break;
            if (percentile.getPercent() == 100) {
    public void testSingleValuedFieldGetProperty() throws Exception {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertConsistent(pcts, percentiles, -maxValues, -minValues);
            .setQuery(matchAllQuery())
            if (asc) {
        assertThat(
                .prepareStats("cache_test_idx")
            } else {
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                    .subAggregation(
            .addAggregation(
                    .percentiles(pcts)
        assertThat(buckets.size(), equalTo(10));
    }
                randomCompression(percentiles("percentiles")).field("values")
            .addAggregation(
            equalTo(0L)
import java.util.HashMap;
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    @Override
                .indices()
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);
                histogram("histo").field("value")
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < length; ++i) {
        params.put("dec", 1);
            .get();
                .getTotal()
        assertThat(((InternalAggregation) global).getProperty("percentiles"), sameInstance(percentiles));
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
            double p99 = percentiles.percentile(99);
    }
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);
        assertThat(
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
        SearchResponse r = client().prepareSearch("cache_test_idx")
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
import java.util.HashSet;
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(percentiles("foo").field("d").percentiles(50.0)).get();
            .addAggregation(
            client().admin()
                randomCompression(percentiles("percentiles")).field("value")
            client().admin()
                    .interval(2L)
        final double[] pcts = randomPercentiles();
    }
                .get()
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                .setRequestCache(true)
            client().admin()
                    break;
        assertHitCount(searchResponse, 10);
        assertThat(percentiles.getName(), equalTo("percentiles"));
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
                assertThat(value, equalTo((double) maxValue));
        final double[] pcts = randomPercentiles();
                .get()
    public void testScriptCaching() throws Exception {
 * license agreements. See the NOTICE file distributed with
    @Override
 *
import java.util.Collection;
                    uniquedPercentiles.add(0.0);
            final Percentile percentile = percentileList.get(i);
                case 1:
 * specific language governing permissions and limitations
        }
                percentiles("foo").field("d")
    }
     * Ensure requests using nondeterministic scripts do not get cached.
        assertHitCount(searchResponse, 10);
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .getRequestCache()
import org.opensearch.search.aggregations.BucketOrder;
        );
    public void testScriptMultiValued() throws Exception {
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>percentiles.99", true)))
 */
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(pcts.length, percentileList.size());
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
    }
        r = client().prepareSearch("cache_test_idx")
            .get();
    }
import org.opensearch.script.ScriptType;
                .getHitCount(),
                .get()
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
     */
            equalTo(0L)
        assertAcked(
    @Override
                .prepareStats("cache_test_idx")
        assertConsistent(pcts, percentiles, minValues, maxValues);
                .prepareStats("cache_test_idx")
                    .percentiles(pcts)
    public void testMultiValuedField() throws Exception {
}
            .setQuery(matchAllQuery())
                .prepareStats("cache_test_idx")
        assertThat(global, notNullValue());
        params.put("dec", 1);
        assertThat(percentiles.getName(), equalTo("percentiles"));
                .getTotal()
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
    @Override
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap());
 * The OpenSearch Contributors require contributions made to
        assertHitCount(searchResponse, 10);
            .get();
import org.opensearch.script.Script;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);
        assertThat(global.getName(), equalTo("global"));
import org.opensearch.search.aggregations.bucket.global.Global;
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            .addAggregation(
/*
                        )
            .setQuery(matchAllQuery())
                .getRequestCache()
        for (int i = 0; i < pcts.length; ++i) {
            client().admin()
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
        assertHitCount(searchResponse, 10);
 *
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            )
import java.util.Arrays;
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(0, 10, 15, 100))
                .getRequestCache()
                randomCompression(percentiles("percentiles")).field("values")
        for (int i = 0; i < 10; i++) {
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testScriptSingleValued() throws Exception {
                    .minDocCount(0)
    @Override
                .getHitCount(),
                .getHitCount(),
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .percentiles(50.0)
        assertThat(buckets, notNullValue());
                randomCompression(percentiles("percentiles")).field("value")
        final double[] pcts = randomPercentiles();
            .addAggregation(
            Percentiles percentiles = bucket.getAggregations().get("percentiles");
                .get()
        final double[] pcts = randomPercentiles();
            .addAggregation(randomCompression(percentiles("percentiles")).field("values").percentiles(pcts))
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                    uniquedPercentiles.add(randomDouble() * 100);
            .setQuery(matchAllQuery())
    @Override
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value * -1", emptyMap()))
            .addAggregation(
package org.opensearch.search.aggregations.metrics;
        assertHitCount(searchResponse, 10);
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
import static org.hamcrest.Matchers.notNullValue;
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
        assertThat(
                assertThat(value, equalTo((double) minValue));
        Map<String, Object> params = new HashMap<>();
        // Make sure we are starting with a clear cache
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        assertThat(percentiles.getName(), equalTo("percentiles"));
    private static double[] randomPercentiles() {
                .getTotal()
                    .percentiles(pcts)
            .setQuery(matchAllQuery())
            )
        assertHitCount(searchResponse, 10);
        assertThat(percentiles, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
    @Override
            }
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
            assertThat(percentiles.percentile(99), equalTo(Double.NaN));
        assertThat(terms, notNullValue());
                .getMissCount(),
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
                .indices()
            .get();
        }
        final double[] pcts = randomPercentiles();
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    public void testUnmapped() throws Exception {
            previous = p99;
            .setQuery(matchAllQuery())
        }
            .setQuery(matchAllQuery())
        Histogram histo = searchResponse.getAggregations().get("histo");
            equalTo(1L)
    }
    public void testSingleValuedFieldWithValueScript() throws Exception {
            }
import java.util.Map;
    }
        assertSearchResponse(r);
        params.put("dec", 1);
        final double[] pcts = randomPercentiles();
    @Override
    }
            .setQuery(matchAllQuery())
            client().admin()
    public void testScriptSingleValuedWithParams() throws Exception {
import org.apache.logging.log4j.LogManager;
            .addAggregation(
                .get()
                    .percentiles(50.0)
        assertHitCount(searchResponse, 10);
                randomCompression(percentiles("percentiles")).field("values")
 * ownership. Elasticsearch licenses this file to you under
            .setQuery(matchAllQuery())
    @Override
                    .order(BucketOrder.aggregation("percentiles", "99", asc))
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                .get()
    }
            .addAggregation(
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
        SearchResponse searchResponse = client().prepareSearch("idx")
        return Collections.singleton(AggregationTestScriptsPlugin.class);
            .setQuery(matchAllQuery())
        final double[] pcts = randomPercentiles();
        }
