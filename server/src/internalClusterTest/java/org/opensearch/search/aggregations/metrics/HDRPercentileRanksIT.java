        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
                .get()  
                    )
                .setQuery(matchAllQuery())
    }
            }
                .getHitCount(),  
import java.util.List;  
                .get()
        return randomIntBetween(0, 5);  
        for (int i = 1; i < percentileList.size(); ++i) {
            .addAggregation(
            if (asc) {
                    .numberOfSignificantValueDigits(sigDigits)
                            .numberOfSignificantValueDigits(sigDigits)  
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
            assertThat(ranks, notNullValue());  
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
/*
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
 */  
            .addAggregation(
            .get();  
            .get();
        );
                .getTotal()
    @Override  
        assertThat(  
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
            if (percentile.getPercent() == 100) {
            .addAggregation(
        );  
        for (Histogram.Bucket bucket : histo.getBuckets()) {
    }
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        percentileRanks("percentile_ranks", new double[] { 10, 15 }).field("value")
                        .numberOfSignificantValueDigits(sigDigits)  
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));  
    }  
                .addAggregation(  
                .getMissCount(),
        assertThat(e.getMessage(), equalTo("[values] must not be null: [percentile_ranks]"));
            )
        int sigDigits = randomSignificantDigits();
                percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR)
            .addAggregation(  
                        .field("value")  
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);  
            .addAggregation(  
    }  
        SearchResponse searchResponse = client().prepareSearch("idx")  
            assertThat(filter.getDocCount(), equalTo(0L));
                    .order(BucketOrder.aggregation("percentile_ranks", "99", asc))
            } else {  
    public void testScriptCaching() throws Exception {
            )
        final double[] pcts = new double[0];
        SearchResponse searchResponse = client().prepareSearch("idx")
                assertThat(percentile.getValue(), greaterThanOrEqualTo(maxValue - allowedError));  
            .get();
        params.put("dec", 1);  
                    .numberOfSignificantValueDigits(sigDigits)
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                .getMissCount(),  
                .getTotal()
                terms("terms").field("value")  
        assertThat(global, notNullValue());
                .getHitCount(),
        int sigDigits = randomSignificantDigits();
            .setQuery(matchAllQuery())
                    )  
        assertThat(
    }
                .getTotal()
import static org.opensearch.search.aggregations.AggregationBuilders.percentileRanks;
                .get()
        final int length = randomIntBetween(1, 20);  
        Map<String, Object> params = new HashMap<>();
            equalTo(0L)  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>ranks.99", true)))
            equalTo(0L)
        assertHitCount(searchResponse, 10);
            .addAggregation(
        assertThat(reversePercentiles, notNullValue());  
        assertSearchResponse(r);
                .setRequestCache(true)
        assertThat(values.getName(), equalTo("percentile_ranks"));  
import static org.hamcrest.Matchers.equalTo;  
        assertHitCount(searchResponse, 10);  
    }
            assertThat(filter, notNullValue());  
        final double[] pcts = new double[] { minValue - 1, maxValue + 1 };
            client().admin()  
        int sigDigits = randomSignificantDigits();  
                .getRequestCache()  
        assertSearchResponse(r);
    }
                    .field("values")  
                histogram("histo").field("value")  
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;  
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
            double p99 = values.percent(99);  
    }
                .setRequestCache(true)
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {  
        assertThat(buckets, notNullValue());  
            equalTo(1L)  
                    .field("value")
            assertThat(bucket.getDocCount(), equalTo(1L));
        boolean asc = randomBoolean();  
        SearchResponse searchResponse = client().prepareSearch("idx")
            Filter filter = bucket.getAggregations().get("filter");
            equalTo(2L)  
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())  
        );  
        }  
     * Ensure requests using nondeterministic scripts do not get cached.
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        int sigDigits = randomSignificantDigits();
    }
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);  
    public void testScriptMultiValued() throws Exception {
import org.opensearch.search.aggregations.InternalAggregation;
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        int sigDigits = randomSignificantDigits();
                .indices()
            equalTo(0L)
        Arrays.sort(percents);  
            .addAggregation(
 * KIND, either express or implied.  See the License for the
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        final List<Percentile> percentileList = iterableAsArrayList(values);
    public void testUnmapped() throws Exception {
        for (int i = 0; i < pcts.length; ++i) {  
            .setQuery(matchAllQuery())
                        .field("value")
            .addAggregation(percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR).field("d"))  
    }
        final double[] pcts = randomPercents(minValues, maxValues);  
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
            .setSize(0)
            )
                        filter("filter", termQuery("value", 100)).subAggregation(  
            )
import java.util.Map;
                .getHitCount(),
            .setQuery(matchAllQuery())
        assertConsistent(pcts, values, minValues, maxValues, sigDigits);
            .get();
        assertThat(
            )
                    .numberOfSignificantValueDigits(sigDigits)
    @Override
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
            IllegalArgumentException.class,
                .getRequestCache()
            .addAggregation(
                    percents[i] = maxValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
                .getRequestCache()  
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);
            .setQuery(matchAllQuery())  
        int sigDigits = randomSignificantDigits();  
                .addAggregation(
 *
        assertThat(((InternalAggregation) global).getProperty("percentile_ranks"), sameInstance(values));
            .setQuery(matchAllQuery())  
        }
    @Override  
            .addAggregation(  
        int sigDigits = randomSignificantDigits();
                .getRequestCache()
                .get()
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {  
                    .script(script)  
    }  
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);  
        assertHitCount(searchResponse, 10);  
            .get();
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
            prepareCreate("cache_test_idx").setMapping("d", "type=long")  
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")  
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
                .setRequestCache(true)
            .addAggregation(
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));
                    .field("values")
 * Unless required by applicable law or agreed to in writing,
        int sigDigits = randomSignificantDigits();  
                    )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            equalTo(0L)
            equalTo(0L)
                )
            .get();
 * not use this file except in compliance with the License.
    @Override
            equalTo(0L)
        // Make sure we are starting with a clear cache
                    .numberOfSignificantValueDigits(sigDigits)  
            .addAggregation(
                .prepareStats("cache_test_idx")
                    .minDocCount(0)
            .setQuery(matchAllQuery())
                    .numberOfSignificantValueDigits(sigDigits)
                    .field("value")
                .setRequestCache(true)
 * under the License.  
    @Override  
    @Override
            .setQuery(matchAllQuery())
        r = client().prepareSearch("cache_test_idx")  
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
            .addAggregation(  
                        .numberOfSignificantValueDigits(sigDigits)
import static java.util.Collections.emptyMap;  
    }
        int sigDigits = randomSignificantDigits();
    public void testNullValuesField() throws Exception {  
        int sigDigits = randomSignificantDigits();
                percentileRanks("foo", new double[] { 50.0 }).method(PercentilesMethod.HDR)  
            )
                    .script(script)
import java.util.Arrays;
                .setRequestCache(true)  
                    .subAggregation(  
                .getMissCount(),
        final double[] pcts = randomPercents(minValue, maxValue);
                            percentileRanks("ranks", new double[] { 99 }).method(PercentilesMethod.HDR).field("value")
import org.opensearch.script.ScriptType;
    public void testScriptSingleValued() throws Exception {  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),  
    }  
            .addAggregation(  
        r = client().prepareSearch("cache_test_idx")
                assertThat(p99, greaterThanOrEqualTo(previous));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
        assertHitCount(searchResponse, 10);
            }
        params.put("dec", 1);
        );
    @Override
        final double[] pcts = null;
            .get();
            )  
        assertHitCount(searchResponse, 10);
    }
                histogram("histo").field("value")
                .get()
        Map<String, Object> params = new HashMap<>();  
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);  
            .get();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertThat(
                    .field("value")
            previous = p99;  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
                        .field("value")
                    percents[i] = minValue;
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);  
    @Override
            )  
        assertThat(
import org.opensearch.action.search.SearchResponse;
            if (percentile.getPercent() == 0) {  
 *
        // Test that a request using a deterministic script gets cached
        }
            )  
            assertThat(percentile.getPercent(), lessThanOrEqualTo(100.0));
        assertHitCount(searchResponse, 10);  
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")  
        );
                    .numberOfSignificantValueDigits(sigDigits)  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
        assertHitCount(searchResponse, 10);  
                .prepareStats("cache_test_idx")
        int sigDigits = randomSignificantDigits();
                .get()  
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
        return percents;
        assertConsistent(pcts, values, minValues, maxValues, sigDigits);
        SearchResponse searchResponse = client().prepareSearch("idx")
                .prepareStats("cache_test_idx")
                )
    public void testMultiValuedField() throws Exception {
        Histogram histo = searchResponse.getAggregations().get("histo");  
        int sigDigits = randomSignificantDigits();
                .getRequestCache()
                .prepareStats("cache_test_idx")
                    break;  
        );
            Terms.Bucket bucket = buckets.get(i);
                    .field("d")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            )  
        final double[] pcts = randomPercents(20 - maxValues, 20 - minValues);
    public void testOrderByEmptyAggregation() throws Exception {
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);  
        super(staticSettings);  
                .prepareStats("cache_test_idx")  
import static org.opensearch.search.aggregations.AggregationBuilders.global;
                            .method(PercentilesMethod.HDR)
                    .interval(2L)
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));  
    public void testSingleValuedFieldGetProperty() throws Exception {
    }  
            client().admin()  
        int sigDigits = randomSignificantDigits();
            PercentileRanks ranks = filter.getAggregations().get("ranks");
                )  
    @Override
            .setSize(0)  
                .get()
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);  
    }
        assertThat(reversePercentiles.percent(100), equalTo(Double.NaN));
import static org.hamcrest.Matchers.sameInstance;
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")  
    public void testSingleValuedFieldOutsideRange() throws Exception {
            client().admin()
        final double[] pcts = randomPercents(minValue, maxValue);
    private static int randomSignificantDigits() {
                global("global").subAggregation(
            .setSize(0)
    public void testEmptyAggregation() throws Exception {
import static org.hamcrest.Matchers.notNullValue;  
 * specific language governing permissions and limitations
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
        // Test that a request using a nondeterministic script does not get cached
                    .numberOfSignificantValueDigits(sigDigits)
        SearchResponse searchResponse = client().prepareSearch("idx")
 * this work for additional information regarding copyright
        Map<String, Object> params = new HashMap<>();
                    .subAggregation(
    }  
                    .numberOfSignificantValueDigits(sigDigits)
        LogManager.getLogger(HDRPercentileRanksIT.class).info("Using values={}", Arrays.toString(percents));
package org.opensearch.search.aggregations.metrics;
    private void assertConsistent(double[] pcts, PercentileRanks values, long minValue, long maxValue, int numberSigDigits) {  
        );
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
        assertSearchResponse(r);
        assertThat(global.getDocCount(), equalTo(10L));  
 * You may obtain a copy of the License at  
                case 1:
        params.put("dec", 1);
            client().admin()
            .setQuery(matchAllQuery())
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
        assertHitCount(searchResponse, 10);
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
            )
        assertConsistent(pcts, values, minValues - 1, maxValues - 1, sigDigits);
        assertEquals(pcts.length, percentileList.size());
            }  
            .addAggregation(
            client().admin()
        SearchResponse r = client().prepareSearch("cache_test_idx")
        );
        assertThat(global.getName(), equalTo("global"));
                double allowedError = maxValue / Math.pow(10, numberSigDigits);
        SearchResponse searchResponse = client().prepareSearch("idx")
                default:
 * Modifications Copyright OpenSearch Contributors. See  
        int sigDigits = randomSignificantDigits();  
                .setRequestCache(true)
            .get();  
        assertHitCount(searchResponse, 10);
import org.opensearch.search.aggregations.bucket.global.Global;
 * Licensed to Elasticsearch under one or more contributor  
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")  
                .indices()
                            .method(PercentilesMethod.HDR)
    @Override  
            client().admin()
                    .numberOfSignificantValueDigits(sigDigits)
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        int sigDigits = randomSignificantDigits();  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap()))
            )  
            .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    }
            )
import java.util.Collections;
            .get();
        internalCluster().wipeIndices("cache_test_idx");
    @Override
                    .interval(1L)
        );  
                .prepareStats("cache_test_idx")  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
    }  
            switch (randomInt(20)) {  
                double allowedError = minValue / Math.pow(10, numberSigDigits);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setQuery(matchAllQuery())
                    .subAggregation(  
            .get();
                    .field("value")
import org.opensearch.script.Script;
                .get()
                .get()  
 * compatible open source license.
            .addAggregation(
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                    .script(script)  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
                        .numberOfSignificantValueDigits(sigDigits)
                .get()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
        Terms terms = searchResponse.getAggregations().get("terms");  
            )
            .get();
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
        assertThat(e.getMessage(), equalTo("[values] must not be an empty array: [percentile_ranks]"));
import java.util.HashMap;
                .getRequestCache()
        assertThat(  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
import java.util.Collection;  
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
                assertThat(percentile.getValue(), lessThanOrEqualTo(minValue + allowedError));
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {  
        int sigDigits = randomSignificantDigits();  
     * Make sure that a request using a deterministic script or not using a script get cached.
        assertThat(
            )  
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
 * The OpenSearch Contributors require contributions made to  
    public void testEmptyValuesField() throws Exception {
                .getRequestCache()
import static org.opensearch.index.query.QueryBuilders.termQuery;  
import org.opensearch.search.aggregations.bucket.filter.Filter;  
                    .field("values")  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "20 - _value", emptyMap()))  
    @Override  
            .get();
                .getHitCount(),  
                assertThat(p99, lessThanOrEqualTo(previous));
                .getRequestCache()
        for (int i = 0; i < 10; i++) {  
        assertHitCount(searchResponse, 10);
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
     */  
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);  
        Global global = searchResponse.getAggregations().get("global");  
    }
        assertThat(reversePercentiles, notNullValue());  
                    .numberOfSignificantValueDigits(sigDigits)  
                .prepareStats("cache_test_idx")  
                .getTotal()
    }
    public void testSingleValuedField() throws Exception {  
    public void testSingleValuedFieldWithValueScript() throws Exception {
    public void testScriptMultiValuedWithParams() throws Exception {
        IllegalArgumentException e = expectThrows(
        PercentileRanks values = global.getAggregations().get("percentile_ranks");
                    .field("value")
    public HDRPercentileRanksIT(Settings staticSettings) {
            )  
        assertHitCount(searchResponse, 10);  
        assertThat(global.getAggregations(), notNullValue());
            .setQuery(matchAllQuery())
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
    public void testMultiValuedFieldWithValueScript() throws Exception {
import org.opensearch.common.settings.Settings;
                    percents[i] = (randomDouble() * (maxValue - minValue)) + minValue;
    @Override  
        for (int i = 0; i < percents.length; ++i) {
        Histogram histo = searchResponse.getAggregations().get("histo");
        final double[] percents = new double[length];
                .setRequestCache(true)  
            .get();  
            )
        final double[] pcts = randomPercents(minValue, maxValue);
    }  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        assertThat(bucket, notNullValue());  
                .indices()
        assertConsistent(pcts, values, minValue, maxValue, sigDigits);  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                .setQuery(matchAllQuery())  
                        percentileRanks("percentile_ranks", new double[] { 99 }).field("value")
    /**  
            true,
        assertHitCount(searchResponse, 10);  
                .indices()  
                    break;  
            .setQuery(matchAllQuery())
            assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.bucket.terms.Terms;  
    public void testOrderBySubAggregation() {
/*
            .get();
        // Ensure that non-scripted requests are cached as normal  
        assertThat(  
        assertThat(buckets.size(), equalTo(10));
            .addAggregation(
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
                .indices()  
            .get();
                .get()  
    @Override  
            .get();  
    }
                case 0:
        assertThat(values, notNullValue());
    @Override
    public void testScriptSingleValuedWithParams() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
        assertThat(histo, notNullValue());
        assertHitCount(searchResponse, 10);
 * GitHub history for details.
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
            )  
                    .field("value")  
    }  
/*  
                        )
            IllegalArgumentException.class,  
                            .numberOfSignificantValueDigits(sigDigits)  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
                .setRequestCache(true)
                    .field("values")
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
import org.apache.logging.log4j.LogManager;  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            )
        int sigDigits = randomSignificantDigits();
            .setQuery(matchAllQuery())
            .get();
            .get();
            .setQuery(matchAllQuery())
public class HDRPercentileRanksIT extends AbstractNumericTestCase {  
        assertThat(reversePercentiles.percent(0), equalTo(Double.NaN));
            client().admin()
            }
        );
            assertThat(percentile.getPercent(), greaterThanOrEqualTo(0.0));  
        return Collections.singleton(AggregationTestScriptsPlugin.class);
 * license agreements. See the NOTICE file distributed with
        assertConsistent(pcts, values, minValue - 1, maxValue - 1, sigDigits);  
        assertConsistent(pcts, values, 20 - maxValues, 20 - minValues, sigDigits);
            PercentileRanks values = bucket.getAggregations().get("percentile_ranks");
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        }  
            .addAggregation(
import org.opensearch.search.aggregations.BucketOrder;
            assertThat(ranks.percent(99), equalTo(Double.NaN));
                .getTotal()  
            )  
                .getMissCount(),
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);  
        assertHitCount(searchResponse, 10);
 * software distributed under the License is distributed on an
        final double[] pcts = randomPercents(minValue, maxValue);
        );
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
import org.opensearch.plugins.Plugin;  
        int sigDigits = randomSignificantDigits();
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;  
                .getTotal()  
        PercentileRanks reversePercentiles = searchResponse.getAggregations().get("percentile_ranks");
            .addAggregation(
                .getTotal()  
            .addAggregation(  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
}
 *  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                    .numberOfSignificantValueDigits(sigDigits)
        assertAcked(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override
 */
        int sigDigits = randomSignificantDigits();
                .indices()  
        }
            .addAggregation(
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
                    .numberOfSignificantValueDigits(sigDigits)
 * SPDX-License-Identifier: Apache-2.0
                .indices()
        final double[] pcts = randomPercents(minValues, maxValues);  
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
        );  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
                .prepareStats("cache_test_idx")
            .get();  
                percentileRanks("percentile_ranks", new double[] { 0, 10, 15, 100 }).method(PercentilesMethod.HDR)  
    private static double[] randomPercents(long minValue, long maxValue) {
            assertThat(percentile.getValue(), equalTo(pcts[i]));
                    break;  
                    .numberOfSignificantValueDigits(sigDigits)
        IllegalArgumentException e = expectThrows(  
            () -> client().prepareSearch("idx")
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)  
        SearchResponse searchResponse = client().prepareSearch("idx")  
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            () -> client().prepareSearch("idx")
        indexRandom(
        assertThat(terms, notNullValue());
            final Percentile percentile = percentileList.get(i);
                percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
            .setQuery(matchAllQuery())  
 */
                .indices()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .numberOfSignificantValueDigits(sigDigits)
            client().admin()
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                    percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.HDR)
        PercentileRanks reversePercentiles = bucket.getAggregations().get("percentile_ranks");
        SearchResponse searchResponse = client().prepareSearch("idx")
                    .field("d")  
                .getTotal()
