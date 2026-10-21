            .get();
        IllegalArgumentException e = expectThrows(
        for (int i = 0; i < pcts.length; ++i) {
        Histogram histo = searchResponse.getAggregations().get("histo");
                .getMissCount(),
                .getRequestCache()
                    .numberOfSignificantValueDigits(sigDigits)
        assertThat(buckets.size(), equalTo(10));
                .addAggregation(
                        percentileRanks("percentile_ranks", new double[] { 10, 15 }).field("value")
            .setQuery(matchAllQuery())
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                        percentileRanks("percentile_ranks", new double[] { 99 }).field("value")
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);
        }
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
                    break;
        assertThat(
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        int sigDigits = randomSignificantDigits();
            assertThat(filter.getDocCount(), equalTo(0L));
            client().admin()
                    .numberOfSignificantValueDigits(sigDigits)
        assertThat(histo, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        r = client().prepareSearch("cache_test_idx")
        assertHitCount(searchResponse, 10);
                    .field("value")
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            () -> client().prepareSearch("idx")
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                double allowedError = minValue / Math.pow(10, numberSigDigits);
                .getRequestCache()
            equalTo(0L)
            .get();
import org.opensearch.search.aggregations.bucket.global.Global;
                    )
        assertThat(bucket, notNullValue());
                percentileRanks("percentile_ranks", new double[] { 0, 10, 15, 100 }).method(PercentilesMethod.HDR)
            if (percentile.getPercent() == 0) {
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
                .setRequestCache(true)
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                    .subAggregation(
        final double[] pcts = randomPercents(minValues, maxValues);
                .get()
        SearchResponse searchResponse = client().prepareSearch("idx")
            .addAggregation(
 */
                .prepareStats("cache_test_idx")
            .setQuery(matchAllQuery())
                .getTotal()
 *
        Global global = searchResponse.getAggregations().get("global");
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap()))
                        .field("value")
 * The OpenSearch Contributors require contributions made to
            .get();
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);
import java.util.Arrays;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * compatible open source license.
    }
            client().admin()
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
                .getRequestCache()
                    .field("value")
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                .prepareStats("cache_test_idx")
            )
                .prepareStats("cache_test_idx")
                .getRequestCache()
            .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
                percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR)
    public void testEmptyValuesField() throws Exception {
        assertConsistent(pcts, values, 20 - maxValues, 20 - minValues, sigDigits);
import java.util.Collections;
            .addAggregation(
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                .get()
                assertThat(p99, lessThanOrEqualTo(previous));
            .setSize(0)
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {
                .indices()
                .setRequestCache(true)
        // Ensure that non-scripted requests are cached as normal
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .addAggregation(
        );
        );
    }
        LogManager.getLogger(HDRPercentileRanksIT.class).info("Using values={}", Arrays.toString(percents));
        int sigDigits = randomSignificantDigits();
import static org.hamcrest.Matchers.sameInstance;
            .addAggregation(
        assertEquals(pcts.length, percentileList.size());
                .get()
            final Percentile percentile = percentileList.get(i);
        int sigDigits = randomSignificantDigits();
    public void testScriptMultiValuedWithParams() throws Exception {
                    .numberOfSignificantValueDigits(sigDigits)
        assertHitCount(searchResponse, 10);
                    .script(script)
import org.opensearch.script.ScriptType;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .addAggregation(
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);
    @Override
                    .field("value")
    @Override
                .prepareStats("cache_test_idx")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        Terms terms = searchResponse.getAggregations().get("terms");
            assertThat(filter, notNullValue());
            )
        final List<Percentile> percentileList = iterableAsArrayList(values);
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
    public void testOrderByEmptyAggregation() throws Exception {
                .getHitCount(),
    }
 * software distributed under the License is distributed on an
        PercentileRanks reversePercentiles = bucket.getAggregations().get("percentile_ranks");
        int sigDigits = randomSignificantDigits();
/*
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            equalTo(0L)
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
        Arrays.sort(percents);
    }
            .setQuery(matchAllQuery())
        return randomIntBetween(0, 5);
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "20 - _value", emptyMap()))
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                .setRequestCache(true)
            )
        int sigDigits = randomSignificantDigits();
            .setQuery(matchAllQuery())
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
 * GitHub history for details.
        );
        SearchResponse searchResponse = client().prepareSearch("idx")
                percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR)
    @Override
import static java.util.Collections.emptyMap;
                    .field("value")
            )
        int sigDigits = randomSignificantDigits();
        SearchResponse searchResponse = client().prepareSearch("idx")
                assertThat(percentile.getValue(), greaterThanOrEqualTo(maxValue - allowedError));
            equalTo(0L)
 *
                global("global").subAggregation(
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
            .setQuery(matchAllQuery())
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
 * KIND, either express or implied.  See the License for the
    }
                .get()
                .indices()
                    .numberOfSignificantValueDigits(sigDigits)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                    break;
import static org.opensearch.index.query.QueryBuilders.termQuery;
        int sigDigits = randomSignificantDigits();
import java.util.Collection;
import org.opensearch.plugins.Plugin;
import static org.hamcrest.Matchers.notNullValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
            .get();
        int sigDigits = randomSignificantDigits();
/*
            }
 * license agreements. See the NOTICE file distributed with
                .setRequestCache(true)
        final double[] pcts = randomPercents(minValue, maxValue);
                    .field("value")
        assertThat(reversePercentiles.percent(100), equalTo(Double.NaN));
            .addAggregation(
        assertThat(reversePercentiles, notNullValue());
    public void testMultiValuedFieldWithValueScript() throws Exception {
        PercentileRanks values = global.getAggregations().get("percentile_ranks");
        assertSearchResponse(r);
                .prepareStats("cache_test_idx")
        assertHitCount(searchResponse, 10);
 * Licensed to Elasticsearch under one or more contributor
    @Override
            if (percentile.getPercent() == 100) {
            )
                .get()
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
        assertSearchResponse(r);
        int sigDigits = randomSignificantDigits();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            )
                .indices()
                .setQuery(matchAllQuery())
                    .field("values")
                histogram("histo").field("value")
                default:
        }
    }
            equalTo(2L)
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
    public void testMultiValuedField() throws Exception {
        Map<String, Object> params = new HashMap<>();
                .getTotal()
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
 * Modifications Copyright OpenSearch Contributors. See
                            percentileRanks("ranks", new double[] { 99 }).method(PercentilesMethod.HDR).field("value")
        final int length = randomIntBetween(1, 20);
                    .subAggregation(
    @Override
                .indices()
    @Override
 */
        int sigDigits = randomSignificantDigits();
            )
                .getMissCount(),
    @Override
                .setRequestCache(true)
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);
                .getMissCount(),
    /**
    }
            )
            .addAggregation(
                    .numberOfSignificantValueDigits(sigDigits)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .addAggregation(
                    .numberOfSignificantValueDigits(sigDigits)
                    .subAggregation(
        SearchResponse searchResponse = client().prepareSearch("idx")
                            .method(PercentilesMethod.HDR)
            .addAggregation(
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        assertThat(
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    public void testNullValuesField() throws Exception {
    }
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                .setRequestCache(true)
            .get();
        assertThat(e.getMessage(), equalTo("[values] must not be an empty array: [percentile_ranks]"));
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
                .get()
            .get();
    @Override
        assertHitCount(searchResponse, 10);
        );
            .get();
    }
        assertHitCount(searchResponse, 10);
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            .get();
        r = client().prepareSearch("cache_test_idx")
                    .field("values")
                    .interval(1L)
            equalTo(0L)
                .getRequestCache()
            .get();
 * not use this file except in compliance with the License.
    @Override
        int sigDigits = randomSignificantDigits();
                .prepareStats("cache_test_idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
            IllegalArgumentException.class,
        assertAcked(
                .get()
                    .field("d")
            .setSize(0)
        for (int i = 0; i < percents.length; ++i) {
        final double[] pcts = new double[0];
            .setQuery(matchAllQuery())
     * Ensure requests using nondeterministic scripts do not get cached.
            .get();
                    break;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
package org.opensearch.search.aggregations.metrics;
            Terms.Bucket bucket = buckets.get(i);
            client().admin()
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertThat(global, notNullValue());
                .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
                    percents[i] = maxValue;
        // Make sure we are starting with a clear cache
            .get();
        assertHitCount(searchResponse, 10);
        assertConsistent(pcts, values, minValues, maxValues, sigDigits);
    public void testSingleValuedFieldWithValueScript() throws Exception {
 */
    @Override
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
    }
                .get()
                .getRequestCache()
            .get();
                .indices()
        assertSearchResponse(r);
            )
            .setQuery(matchAllQuery())
    }
                    .numberOfSignificantValueDigits(sigDigits)
                    .numberOfSignificantValueDigits(sigDigits)
        assertHitCount(searchResponse, 10);
        int sigDigits = randomSignificantDigits();
                )
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
        // Test that a request using a deterministic script gets cached
    public HDRPercentileRanksIT(Settings staticSettings) {
            assertThat(percentile.getValue(), equalTo(pcts[i]));
        int sigDigits = randomSignificantDigits();
                .getTotal()
        assertThat(
        params.put("dec", 1);
        int sigDigits = randomSignificantDigits();
import java.util.List;
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
            .addAggregation(
            assertThat(percentile.getPercent(), lessThanOrEqualTo(100.0));
            assertThat(ranks.percent(99), equalTo(Double.NaN));
            )
            .get();
        Histogram histo = searchResponse.getAggregations().get("histo");
    @Override
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
            assertThat(bucket.getDocCount(), equalTo(1L));
            () -> client().prepareSearch("idx")
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                    .field("value")
import org.opensearch.script.Script;
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
            .setQuery(matchAllQuery())
        int sigDigits = randomSignificantDigits();
            .setQuery(matchAllQuery())
            equalTo(0L)
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);
            .addAggregation(
        assertHitCount(searchResponse, 10);
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);
    public void testOrderBySubAggregation() {
        );
import java.util.Map;
            )
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("idx")
            )
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
                            .method(PercentilesMethod.HDR)
        boolean asc = randomBoolean();
        }
    public void testSingleValuedFieldGetProperty() throws Exception {
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
        );
 * under the License.
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    private static int randomSignificantDigits() {
            client().admin()
        assertThat(
    @Override
                .get()
            .addAggregation(
                .getTotal()
                .getTotal()
        final double[] pcts = randomPercents(minValues, maxValues);
        assertHitCount(searchResponse, 10);
        assertThat(global.getAggregations(), notNullValue());
                assertThat(p99, greaterThanOrEqualTo(previous));
import org.opensearch.action.search.SearchResponse;
                .prepareStats("cache_test_idx")
            .get();
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);
    }
            assertThat(bucket, notNullValue());
    @Override
            .get();
                .setRequestCache(true)
                .indices()
            client().admin()
            .addAggregation(
        assertThat(global.getDocCount(), equalTo(10L));
import java.util.HashMap;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            .get();
import org.opensearch.search.aggregations.InternalAggregation;
                .getHitCount(),
            )
            IllegalArgumentException.class,
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertThat(reversePercentiles, notNullValue());
            )
        assertThat(reversePercentiles.percent(0), equalTo(Double.NaN));
        );
        int sigDigits = randomSignificantDigits();
        final double[] pcts = randomPercents(20 - maxValues, 20 - minValues);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testScriptSingleValuedWithParams() throws Exception {
        assertThat(terms, notNullValue());
        int sigDigits = randomSignificantDigits();
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .numberOfSignificantValueDigits(sigDigits)
        assertThat(values.getName(), equalTo("percentile_ranks"));
            assertThat(ranks, notNullValue());
        assertHitCount(searchResponse, 10);
                terms("terms").field("value")
     * Make sure that a request using a deterministic script or not using a script get cached.
            .setQuery(matchAllQuery())
    }
                case 1:
        assertThat(
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            )
                    .script(script)
                .getTotal()
                case 0:
            .get();
                    .numberOfSignificantValueDigits(sigDigits)
        assertConsistent(pcts, values, minValues, maxValues, sigDigits);
    }
/*
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
    private static double[] randomPercents(long minValue, long maxValue) {
            equalTo(0L)
                        .field("value")
    public void testScriptMultiValued() throws Exception {
        assertThat(buckets, notNullValue());
            switch (randomInt(20)) {
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        params.put("dec", 1);
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
            PercentileRanks values = bucket.getAggregations().get("percentile_ranks");
import static org.opensearch.search.aggregations.AggregationBuilders.percentileRanks;
                )
 * this file be licensed under the Apache-2.0 license or a
        assertThat(
        Map<String, Object> params = new HashMap<>();
import org.opensearch.search.aggregations.bucket.terms.Terms;
                    .order(BucketOrder.aggregation("percentile_ranks", "99", asc))
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
                    )
            )
        assertThat(e.getMessage(), equalTo("[values] must not be null: [percentile_ranks]"));
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        for (int i = 1; i < percentileList.size(); ++i) {
                .getTotal()
    @Override
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
            }
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                        .numberOfSignificantValueDigits(sigDigits)
 *
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);
                        .numberOfSignificantValueDigits(sigDigits)
                    .numberOfSignificantValueDigits(sigDigits)
    }
        assertThat(values, notNullValue());
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
    }
                    .numberOfSignificantValueDigits(sigDigits)
                .getRequestCache()
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
                histogram("histo").field("value")
                    .field("values")
            .get();
                .getTotal()
                            .numberOfSignificantValueDigits(sigDigits)
    public void testScriptSingleValued() throws Exception {
                .setRequestCache(true)
        for (int i = 0; i < 10; i++) {
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);
            .get();
        );
        );
        );
            .addAggregation(percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR).field("d"))
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
                .getHitCount(),
            } else {
                    percents[i] = minValue;
        final double[] pcts = randomPercents(minValue, maxValue);
                    .script(script)
        final double[] pcts = new double[] { minValue - 1, maxValue + 1 };
    }
        params.put("dec", 1);
}
            .addAggregation(
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>ranks.99", true)))
            .get();
        final double[] percents = new double[length];
                    .minDocCount(0)
                .get()
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .addAggregation(
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
            client().admin()
        SearchResponse searchResponse = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.global;
            assertThat(percentile.getPercent(), greaterThanOrEqualTo(0.0));
                    .interval(2L)
        assertHitCount(searchResponse, 10);
    }
            if (asc) {
 * this work for additional information regarding copyright
        assertThat(global.getName(), equalTo("global"));
        return Collections.singleton(AggregationTestScriptsPlugin.class);
        final double[] pcts = null;
            .addAggregation(
                .getMissCount(),
            .setQuery(matchAllQuery())
            client().admin()
        super(staticSettings);
    public void testUnmapped() throws Exception {
import org.apache.logging.log4j.LogManager;
                .addAggregation(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
import org.opensearch.common.settings.Settings;
            .addAggregation(
public class HDRPercentileRanksIT extends AbstractNumericTestCase {
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                    .field("values")
                .indices()
        IllegalArgumentException e = expectThrows(
        SearchResponse r = client().prepareSearch("cache_test_idx")
        assertThat(
            )
    }
        internalCluster().wipeIndices("cache_test_idx");
                .indices()
        );
            .setQuery(matchAllQuery())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        )
        assertHitCount(searchResponse, 10);
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                )
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
    @Override
            }
    }
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
                    percents[i] = (randomDouble() * (maxValue - minValue)) + minValue;
            .addAggregation(
                .prepareStats("cache_test_idx")
            previous = p99;
            .addAggregation(
                .getHitCount(),
        indexRandom(
            )
            PercentileRanks ranks = filter.getAggregations().get("ranks");
                .get()
            .get();
            equalTo(1L)
        Map<String, Object> params = new HashMap<>();
        final double[] pcts = randomPercents(minValue, maxValue);
            client().admin()
        return percents;
            .setSize(0)
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
    @Override
import static org.hamcrest.Matchers.equalTo;
        SearchResponse searchResponse = client().prepareSearch("idx")
        int sigDigits = randomSignificantDigits();
    }
        // Test that a request using a nondeterministic script does not get cached
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .addAggregation(
        assertThat(((InternalAggregation) global).getProperty("percentile_ranks"), sameInstance(values));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        final double[] pcts = randomPercents(minValue, maxValue);
        assertThat(
        }
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
            double p99 = values.percent(99);
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
    private void assertConsistent(double[] pcts, PercentileRanks values, long minValue, long maxValue, int numberSigDigits) {
        SearchResponse searchResponse = client().prepareSearch("idx")
    public void testScriptCaching() throws Exception {
            .setQuery(matchAllQuery())
import org.opensearch.search.aggregations.BucketOrder;
        assertHitCount(searchResponse, 10);
    }
            }
        PercentileRanks reversePercentiles = searchResponse.getAggregations().get("percentile_ranks");
                    .numberOfSignificantValueDigits(sigDigits)
        int sigDigits = randomSignificantDigits();
                assertThat(percentile.getValue(), lessThanOrEqualTo(minValue + allowedError));
                double allowedError = maxValue / Math.pow(10, numberSigDigits);
    }
    public void testSingleValuedFieldOutsideRange() throws Exception {
                            .numberOfSignificantValueDigits(sigDigits)
 * specific language governing permissions and limitations
    public void testSingleValuedField() throws Exception {
                    .field("d")
            true,
            )
                        .numberOfSignificantValueDigits(sigDigits)
                    )
                    .numberOfSignificantValueDigits(sigDigits)
            Filter filter = bucket.getAggregations().get("filter");
                        .field("value")
                        filter("filter", termQuery("value", 100)).subAggregation(
        assertHitCount(searchResponse, 10);
     */
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
    public void testEmptyAggregation() throws Exception {
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
                .getRequestCache()
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);
        }
            .setQuery(matchAllQuery())
 * SPDX-License-Identifier: Apache-2.0
    }
