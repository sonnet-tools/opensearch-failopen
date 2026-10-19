        }
                    .interval(2L)
    public void testScriptMultiValued() throws Exception {
        final double[] pcts = new double[] { minValue - 1, maxValue + 1 };
            .setQuery(matchAllQuery())
    }
        assertHitCount(searchResponse, 10);
        }
    private static PercentileRanksAggregationBuilder randomCompression(PercentileRanksAggregationBuilder builder) {
    @Override
        SearchResponse searchResponse = client().prepareSearch("idx")
            .get();
    }
            )
    @Override
            builder.compression(randomIntBetween(20, 120) + randomDouble());
            previous = p99;
            .get();
            .get();
        assertHitCount(searchResponse, 10);
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
                .indices()
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
                .getRequestCache()
                .indices()
                .setRequestCache(true)
            client().admin()
        assertThat(reversePercentiles, notNullValue());
        assertConsistent(pcts, values, minValues - 1);
    public void testScriptMultiValuedWithParams() throws Exception {
                .get()
        assertHitCount(searchResponse, 10);
            equalTo(0L)
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
/*
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
                    .subAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 99 }).field("value")))
            assertThat(percentile.getPercent(), lessThanOrEqualTo(100.0));
        // Ensure that non-scripted requests are cached as normal
        // Make sure we are starting with a clear cache
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("values"))
        assertThat(
            .get();
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertHitCount(searchResponse, 10);
            client().admin()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value * -1", emptyMap()))
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertThat(global, notNullValue());
                .getRequestCache()
            .addAggregation(
                    .subAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 10, 15 }).field("value")))
            PercentileRanks values = bucket.getAggregations().get("percentile_ranks");
        assertThat(global.getName(), equalTo("global"));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                    percents[i] = (randomDouble() * (maxValue - minValue)) + minValue;
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
    }
    @Override
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(values);
        }
            () -> client().prepareSearch("idx")
            }
            .get();
                    )
import static java.util.Collections.emptyMap;
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
 * Licensed to Elasticsearch under one or more contributor
                .setRequestCache(true)
    @Override
    /**
            .get();
            client().admin()
                .getTotal()
        assertConsistent(pcts, values, -maxValues);
        params.put("dec", 1);
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
        SearchResponse r = client().prepareSearch("cache_test_idx")
            IllegalArgumentException.class,
        assertThat(histo, notNullValue());
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        Map<String, Object> params = new HashMap<>();
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
        SearchResponse searchResponse = client().prepareSearch("idx")
                .get()
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
                .indices()
                .addAggregation(percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.TDIGEST).field("value"))
    public void testScriptCaching() throws Exception {
        params.put("dec", 1);
                .setRequestCache(true)
            .setQuery(matchAllQuery())
                .setRequestCache(true)
            .setQuery(matchAllQuery())
        final double[] pcts = randomPercents(minValue, maxValue);
    }
                .get()
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {
            .addAggregation(
                )
        final double[] pcts = randomPercents(minValue, maxValue);
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                    break;
        }
        );
        // Test that a request using a nondeterministic script does not get cached
import org.opensearch.search.aggregations.BucketOrder;
        assertHitCount(searchResponse, 10);
        final double[] pcts = randomPercents(-maxValues, -minValues);
            assertThat(filter, notNullValue());
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
                .prepareStats("cache_test_idx")
        IllegalArgumentException e = expectThrows(
            true,
                .setRequestCache(true)
            )
                .getMissCount(),
    public TDigestPercentileRanksIT(Settings staticSettings) {
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
    }
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        Histogram histo = searchResponse.getAggregations().get("histo");
import static org.opensearch.search.aggregations.AggregationBuilders.percentileRanks;
            )
            .setQuery(matchAllQuery())
                percentileRanks("foo", new double[] { 50.0 }).field("d")
        SearchResponse searchResponse = client().prepareSearch("idx")
 *
    private void assertConsistent(double[] pcts, PercentileRanks values, long minValue) {
package org.opensearch.search.aggregations.metrics;
            .addAggregation(
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.Plugin;
        if (randomBoolean()) {
            equalTo(2L)
        LogManager.getLogger(TDigestPercentileRanksIT.class).info("Using values={}", Arrays.toString(percents));
                assertThat(p99, lessThanOrEqualTo(previous));
        assertThat(values, notNullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .get();
 */
        Global global = searchResponse.getAggregations().get("global");
    public void testScriptSingleValued() throws Exception {
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))
import static org.hamcrest.Matchers.equalTo;
        }
                .get()
        SearchResponse searchResponse = client().prepareSearch("idx")
            double p99 = values.percent(99);
                .get()
    @Override
            .setSize(0)
            .setQuery(matchAllQuery())
        assertThat(buckets, notNullValue());
                case 1:
        assertHitCount(searchResponse, 10);
    }
            assertThat(percentile.getValue(), equalTo(pcts[i]));
            equalTo(1L)
    }
 * Unless required by applicable law or agreed to in writing,
    public void testMultiValuedFieldWithValueScript() throws Exception {
            client().admin()
            .get();
            )
        r = client().prepareSearch("cache_test_idx")
            equalTo(0L)
                assertThat(percentile.getValue(), lessThanOrEqualTo((double) minValue));
        SearchResponse searchResponse = client().prepareSearch("idx")
            .get();
        Map<String, Object> params = new HashMap<>();
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        PercentileRanks values = global.getAggregations().get("percentile_ranks");
        Arrays.sort(percents);
    @Override
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
    @Override
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
import org.opensearch.common.settings.Settings;
     * Ensure requests using nondeterministic scripts do not get cached.
                .setRequestCache(true)
        assertConsistent(pcts, values, minValue - 1);
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
                .get()
        final double[] percents = new double[length];
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setSize(0)
    @Override
                histogram("histo").field("value")
                .prepareStats("cache_test_idx")
        return builder;
    @Override
            .get();
        );
    }
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
            client().admin()
                assertThat(p99, greaterThanOrEqualTo(previous));
        for (int i = 0; i < pcts.length; ++i) {
                terms("terms").field("value")
            .get();
    }
        );
            Filter filter = bucket.getAggregations().get("filter");
            final Percentile percentile = percentileList.get(i);
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertThat(reversePercentiles.percent(100), equalTo(Double.NaN));
    }
                .indices()
 * not use this file except in compliance with the License.
                .get()
                .getRequestCache()
            .setQuery(matchAllQuery())
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
import org.opensearch.search.aggregations.bucket.filter.Filter;
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 0, 10, 15, 100 })).field("value"))
    public void testEmptyValuesField() throws Exception {
        assertConsistent(pcts, values, minValues);
import org.apache.logging.log4j.LogManager;
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
import org.opensearch.search.aggregations.bucket.global.Global;
public class TDigestPercentileRanksIT extends AbstractNumericTestCase {
        Histogram histo = searchResponse.getAggregations().get("histo");
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
        assertThat(e.getMessage(), equalTo("[values] must not be null: [percentile_ranks]"));
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                        filter("filter", termQuery("value", 100)).subAggregation(
        assertHitCount(searchResponse, 10);
    @Override
        assertThat(
        assertThat(values.getName(), equalTo("percentile_ranks"));
                    .order(BucketOrder.aggregation("percentile_ranks", "99", asc))
        final double[] pcts = randomPercents(minValue, maxValue);
    }
 */
        );
        SearchResponse searchResponse = client().prepareSearch("idx")
                percentileRanks("foo", new double[] { 50.0 }).field("d")
            .get();
 * specific language governing permissions and limitations
            assertThat(ranks.percent(99), equalTo(Double.NaN));
import org.opensearch.script.ScriptType;
import org.opensearch.script.Script;
    @Override
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")
        Terms terms = searchResponse.getAggregations().get("terms");
        assertConsistent(pcts, values, minValue);
            client().admin()
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")
        assertThat(bucket, notNullValue());
            switch (randomInt(20)) {
    }
                .setRequestCache(true)
                .getRequestCache()
    }
                .getHitCount(),
        assertThat(
 * software distributed under the License is distributed on an
        assertAcked(
    }
                    .minDocCount(0)
                .prepareStats("cache_test_idx")
import org.opensearch.core.common.util.CollectionUtils;
            .setQuery(matchAllQuery())
            .get();
            () -> client().prepareSearch("idx")
    }
            .addAggregation(percentileRanks("foo", new double[] { 50.0 }).field("d"))
        SearchResponse searchResponse = client().prepareSearch("idx")
                .get()
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")
        assertThat(((InternalAggregation) global).getProperty("percentile_ranks"), sameInstance(values));
 * this file be licensed under the Apache-2.0 license or a
            Terms.Bucket bucket = buckets.get(i);
                .prepareStats("cache_test_idx")
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>ranks.99", true)))
import java.util.Arrays;
                .getTotal()
            assertThat(filter.getDocCount(), equalTo(0L));
    }
        boolean asc = randomBoolean();
            .addAggregation(
import java.util.List;
                .get()
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);
        Map<String, Object> params = new HashMap<>();
        final double[] pcts = null;
/*
/*
 * GitHub history for details.
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
        for (int i = 0; i < percents.length; ++i) {
            equalTo(0L)
    }
                .getMissCount(),
            IllegalArgumentException.class,
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
                default:
                        )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(e.getMessage(), equalTo("[values] must not be an empty array: [percentile_ranks]"));
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            }
                .getRequestCache()
        // Test that a request using a deterministic script gets cached
            .get();
                .get()
                .getTotal()
            client().admin()
        return percents;
 * compatible open source license.
            )
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap())
                histogram("histo").field("value")
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
                .getMissCount(),
            .setQuery(matchAllQuery())
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                    percents[i] = maxValue;
        assertThat(
            .addAggregation(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertHitCount(searchResponse, 10);
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")
                    percents[i] = minValue;
 * under the License.
        super(staticSettings);
import org.opensearch.search.aggregations.bucket.terms.Terms;
                .indices()
import static org.hamcrest.Matchers.sameInstance;
            if (percentile.getPercent() == 0) {
        assertSearchResponse(r);
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
        assertSearchResponse(r);
            )
                .setQuery(matchAllQuery())
                .getHitCount(),
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            PercentileRanks ranks = filter.getAggregations().get("ranks");
        PercentileRanks reversePercentiles = searchResponse.getAggregations().get("percentile_ranks");
            client().admin()
        assertHitCount(searchResponse, 10);
        }
        for (int i = 0; i < 10; i++) {
        assertThat(global.getDocCount(), equalTo(10L));
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))
        Histogram.Bucket bucket = histo.getBuckets().get(1);
                .getTotal()
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                    break;
    public void testOrderByEmptyAggregation() throws Exception {
        params.put("dec", 1);
import java.util.Collections;
        final int length = randomIntBetween(1, 20);
        assertConsistent(pcts, values, minValue);
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
                .setRequestCache(true)
                .getTotal()
            .setQuery(matchAllQuery())
 */
                .getTotal()
import static org.hamcrest.Matchers.notNullValue;
                .getTotal()
                .getMissCount(),
        assertHitCount(searchResponse, 10);
                .prepareStats("cache_test_idx")
                .getTotal()
        );
        assertHitCount(searchResponse, 10);
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to
    private static double[] randomPercents(long minValue, long maxValue) {
                randomCompression(percentileRanks("percentile_ranks", pcts)).script(
 * KIND, either express or implied.  See the License for the
        assertThat(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(buckets.size(), equalTo(10));
                .prepareStats("cache_test_idx")
        r = client().prepareSearch("cache_test_idx")
        );
 *
            )
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
    public void testOrderBySubAggregation() {
                .addAggregation(percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.TDIGEST).field("value"))
            )
                .prepareStats("cache_test_idx")
    @Override
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            .get();
            .get();
    public void testNullValuesField() throws Exception {
    }
import org.opensearch.search.aggregations.InternalAggregation;
            .setQuery(matchAllQuery())
        assertConsistent(pcts, values, minValues);
    public void testMultiValuedField() throws Exception {
                .indices()
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .getRequestCache()
                .prepareStats("cache_test_idx")
        );
import java.util.Collection;
        assertHitCount(searchResponse, 10);
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        IllegalArgumentException e = expectThrows(
            .addAggregation(
            assertThat(bucket.getDocCount(), equalTo(1L));
        PercentileRanks reversePercentiles = bucket.getAggregations().get("percentile_ranks");
        final double[] pcts = new double[0];
 * this work for additional information regarding copyright
    public void testUnmapped() throws Exception {
                .getRequestCache()
                .indices()
        assertConsistent(pcts, values, minValue);
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            equalTo(0L)
            .setQuery(matchAllQuery())
    public void testSingleValuedFieldWithValueScript() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("idx")
    @Override
        );
    @Override
 *
            .get();
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertHitCount(searchResponse, 10);
            .addAggregation(
        assertEquals(pcts.length, percentileList.size());
        assertConsistent(pcts, values, minValues - 1);
     * Make sure that a request using a deterministic script or not using a script get cached.
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
     */
    public void testSingleValuedFieldOutsideRange() throws Exception {
            .setQuery(matchAllQuery())
        internalCluster().wipeIndices("cache_test_idx");
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
            )
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))
        assertThat(
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
    }
        );
import static org.opensearch.search.aggregations.AggregationBuilders.global;
                    .subAggregation(
    }
import java.util.Map;
 * You may obtain a copy of the License at
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    public void testSingleValuedField() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import static org.opensearch.index.query.QueryBuilders.termQuery;
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchResponse;
                    .interval(1L)
    public void testSingleValuedFieldGetProperty() throws Exception {
    }
    }
        assertConsistent(pcts, values, minValue - 1);
            equalTo(0L)
        indexRandom(
        final double[] pcts = randomPercents(minValues, maxValues);
            } else {
            .setQuery(matchAllQuery())
            if (asc) {
 * the Apache License, Version 2.0 (the "License"); you may
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
            .setSize(0)
            .addAggregation(global("global").subAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")))
            assertThat(bucket, notNullValue());
        for (int i = 1; i < percentileList.size(); ++i) {
            .get();
        assertThat(reversePercentiles, notNullValue());
        assertSearchResponse(r);
            .addAggregation(
            }
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            assertThat(ranks, notNullValue());
            .get();
            .addAggregation(
 * SPDX-License-Identifier: Apache-2.0
                case 0:
                .getHitCount(),
        assertThat(
}
    public void testEmptyAggregation() throws Exception {
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
            .addAggregation(
    public void testScriptSingleValuedWithParams() throws Exception {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        );
    }
        assertConsistent(pcts, values, minValue);
                .setQuery(matchAllQuery())
        );
        assertConsistent(pcts, values, minValues - 1);
        return Collections.singleton(AggregationTestScriptsPlugin.class);
                .getHitCount(),
            assertThat(percentile.getPercent(), greaterThanOrEqualTo(0.0));
        assertThat(terms, notNullValue());
        assertConsistent(pcts, values, minValue - 1);
        final double[] pcts = randomPercents(minValue, maxValue);
    }
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
    @Override
                .indices()
                            percentileRanks("ranks", new double[] { 99 }).method(PercentilesMethod.TDIGEST).field("value")
        assertThat(reversePercentiles.percent(0), equalTo(Double.NaN));
        SearchResponse searchResponse = client().prepareSearch("idx")
        final double[] pcts = randomPercents(minValues, maxValues);
                .get()
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
                .getRequestCache()
        SearchResponse searchResponse = client().prepareSearch("idx")
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertThat(global.getAggregations(), notNullValue());
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertHitCount(searchResponse, 10);
 * ownership. Elasticsearch licenses this file to you under
            )
            equalTo(0L)
            .addAggregation(
                    break;
