        Histogram histo = searchResponse.getAggregations().get("histo");
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(values);
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        PercentileRanks reversePercentiles = searchResponse.getAggregations().get("percentile_ranks");
                .getRequestCache()
                    .interval(1L)
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")
        assertHitCount(searchResponse, 10);  
            double p99 = values.percent(99);
    }
        assertHitCount(searchResponse, 10);
                .setRequestCache(true)
                .getRequestCache()
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
        SearchResponse searchResponse = client().prepareSearch("idx")
    }
    @Override
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
                .prepareStats("cache_test_idx")  
                .prepareStats("cache_test_idx")
    private static double[] randomPercents(long minValue, long maxValue) {
import java.util.Collection;
 * The OpenSearch Contributors require contributions made to  
            if (asc) {  
    public void testScriptSingleValued() throws Exception {
    }
        assertConsistent(pcts, values, minValue);
            )  
        SearchResponse searchResponse = client().prepareSearch("idx")  
        assertHitCount(searchResponse, 10);
        // Ensure that non-scripted requests are cached as normal  
        params.put("dec", 1);  
                .getHitCount(),  
        assertConsistent(pcts, values, minValues - 1);
    }  
        }
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
            final Percentile percentile = percentileList.get(i);
                .getTotal()  
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))
            .get();
            assertThat(filter.getDocCount(), equalTo(0L));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
        assertHitCount(searchResponse, 10);
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
    public void testSingleValuedFieldOutsideRange() throws Exception {  
                .getTotal()
    }  
        assertSearchResponse(r);
            .get();
 * not use this file except in compliance with the License.
                .getTotal()  
        assertThat(e.getMessage(), equalTo("[values] must not be an empty array: [percentile_ranks]"));
    @Override
                    .minDocCount(0)
    public TDigestPercentileRanksIT(Settings staticSettings) {
import static org.hamcrest.Matchers.equalTo;  
            }
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;  
                .getMissCount(),
import org.opensearch.search.aggregations.bucket.terms.Terms;
        final double[] pcts = randomPercents(minValue, maxValue);  
            .addAggregation(
        PercentileRanks reversePercentiles = bucket.getAggregations().get("percentile_ranks");
 *
        assertConsistent(pcts, values, minValue - 1);
        assertThat(reversePercentiles.percent(0), equalTo(Double.NaN));
        assertThat(  
        final double[] pcts = randomPercents(minValue, maxValue);  
            client().admin()
import java.util.Arrays;  
                assertThat(percentile.getValue(), lessThanOrEqualTo((double) minValue));
import org.opensearch.search.aggregations.bucket.global.Global;
    public void testUnmapped() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
            )  
        assertThat(reversePercentiles, notNullValue());  
                .getMissCount(),
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                .get()
    }
                histogram("histo").field("value")  
    }
            .get();
        assertThat(values, notNullValue());
    }
            client().admin()
import org.opensearch.search.aggregations.bucket.filter.Filter;
            )  
    public void testEmptyValuesField() throws Exception {
    @Override
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))  
                .indices()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    @Override
                .setRequestCache(true)
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
                randomCompression(percentileRanks("percentile_ranks", pcts)).script(  
    public void testScriptMultiValuedWithParams() throws Exception {
        indexRandom(  
            .setQuery(matchAllQuery())
        final double[] pcts = randomPercents(minValues, maxValues);  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);  
            .setSize(0)
        assertHitCount(searchResponse, 10);
            assertThat(bucket, notNullValue());
        Map<String, Object> params = new HashMap<>();
                    .order(BucketOrder.aggregation("percentile_ranks", "99", asc))
import static java.util.Collections.emptyMap;
            .get();
            .get();
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);  
        final double[] pcts = null;  
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
        Arrays.sort(percents);  
                    .subAggregation(
            assertThat(ranks, notNullValue());
 * ownership. Elasticsearch licenses this file to you under  
            .setQuery(matchAllQuery())
            Filter filter = bucket.getAggregations().get("filter");
        assertThat(  
 * the Apache License, Version 2.0 (the "License"); you may
                .getRequestCache()
 */
        final double[] pcts = randomPercents(-maxValues, -minValues);
    }
            .setQuery(matchAllQuery())  
                .setRequestCache(true)
        LogManager.getLogger(TDigestPercentileRanksIT.class).info("Using values={}", Arrays.toString(percents));
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 0, 10, 15, 100 })).field("value"))  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(bucket, notNullValue());
            previous = p99;
            )
        assertHitCount(searchResponse, 10);
import org.opensearch.script.ScriptType;  
                .get()
        final double[] pcts = randomPercents(minValue - 1, maxValue - 1);
                .addAggregation(percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.TDIGEST).field("value"))
        );
        assertThat(  
        assertSearchResponse(r);
        final double[] pcts = new double[] { minValue - 1, maxValue + 1 };
        params.put("dec", 1);
            .get();
import static org.hamcrest.Matchers.notNullValue;  
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
import static org.hamcrest.Matchers.sameInstance;
            )  
        assertThat(((InternalAggregation) global).getProperty("percentile_ranks"), sameInstance(values));  
    }
/*
        );
            client().admin()
                .getMissCount(),
                    )
        assertThat(global.getDocCount(), equalTo(10L));
                .getMissCount(),
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));  
                histogram("histo").field("value")
import static org.opensearch.search.aggregations.AggregationBuilders.global;
    }  
            .setQuery(matchAllQuery())
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
    @Override  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
 * specific language governing permissions and limitations
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
        assertHitCount(searchResponse, 10);
            .addAggregation(global("global").subAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")))  
        assertHitCount(searchResponse, 10);  
        r = client().prepareSearch("cache_test_idx")
        final double[] pcts = randomPercents(minValue, maxValue);
            .addAggregation(  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
                .indices()
import java.util.Map;
                case 1:
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
            .addAggregation(percentileRanks("foo", new double[] { 50.0 }).field("d"))  
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .get();
        // Make sure we are starting with a clear cache  
        Map<String, Object> params = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
            .get();  
                .indices()  
    @Override  
        SearchResponse searchResponse = client().prepareSearch("idx")
            .addAggregation(
                case 0:
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
                .prepareStats("cache_test_idx")
    }  
        IllegalArgumentException e = expectThrows(
    }  
            () -> client().prepareSearch("idx")  
                    percents[i] = (randomDouble() * (maxValue - minValue)) + minValue;
        r = client().prepareSearch("cache_test_idx")
                .addAggregation(percentileRanks("percentile_ranks", pcts).method(PercentilesMethod.TDIGEST).field("value"))
    }  
        assertHitCount(searchResponse, 10);
        Map<String, Object> params = new HashMap<>();
            .get();  
        assertThat(values.getName(), equalTo("percentile_ranks"));
        assertThat(buckets, notNullValue());
    public void testScriptSingleValuedWithParams() throws Exception {
        IllegalArgumentException e = expectThrows(
            equalTo(0L)  
        super(staticSettings);  
                .getTotal()  
    /**
    public void testMultiValuedFieldWithValueScript() throws Exception {  
            assertThat(bucket.getDocCount(), equalTo(1L));  
}
            .addAggregation(
        SearchResponse searchResponse = client().prepareSearch("idx")
                .get()  
import org.opensearch.search.aggregations.BucketOrder;
        );
        assertConsistent(pcts, values, -maxValues);
            .addAggregation(  
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
                    break;  
                assertThat(p99, greaterThanOrEqualTo(previous));
        SearchResponse searchResponse = client().prepareSearch("idx")  
        assertThat(reversePercentiles, notNullValue());
        );
                    .interval(2L)
            .setQuery(matchAllQuery())  
            .setQuery(matchAllQuery())  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        assertThat(reversePercentiles.getName(), equalTo("percentile_ranks"));
                .get()  
                .setRequestCache(true)
        assertConsistent(pcts, values, minValue - 1);
import org.opensearch.search.aggregations.InternalAggregation;  
            equalTo(0L)
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {
    }  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.util.CollectionUtils;  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)  
        final double[] pcts = new double[0];  
                .get()  
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")  
    }  
    @Override  
            equalTo(0L)
                .getRequestCache()
        assertHitCount(searchResponse, 10);  
        assertThat(e.getMessage(), equalTo("[values] must not be null: [percentile_ranks]"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            true,
        assertEquals(pcts.length, percentileList.size());
            PercentileRanks values = bucket.getAggregations().get("percentile_ranks");
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .setQuery(matchAllQuery())  
            .setQuery(matchAllQuery())
    @Override
        }
            assertThat(percentile.getValue(), equalTo(pcts[i]));
        assertHitCount(searchResponse, 10);  
                .indices()  
            .setQuery(matchAllQuery())  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))  
     */
        for (Histogram.Bucket bucket : histo.getBuckets()) {  
        assertHitCount(searchResponse, 10);
        assertThat(reversePercentiles.percent(15), equalTo(Double.NaN));
/*
            )
        assertConsistent(pcts, values, minValues - 1);  
        assertHitCount(searchResponse, 10);
                .get()  
            client().admin()
        final int length = randomIntBetween(1, 20);  
    public void testScriptMultiValued() throws Exception {
            () -> client().prepareSearch("idx")  
                .get()
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));
            equalTo(0L)
            Terms.Bucket bucket = buckets.get(i);  
    public void testScriptCaching() throws Exception {  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    @Override  
                .prepareStats("cache_test_idx")
        SearchResponse searchResponse = client().prepareSearch("idx")  
import org.opensearch.plugins.Plugin;
            .get();
                .get()
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {  
                    break;  
            assertThat(ranks.percent(99), equalTo(Double.NaN));  
        );
        assertConsistent(pcts, values, minValue);  
            if (percentile.getPercent() == 0) {  
import java.util.HashMap;  
        assertHitCount(searchResponse, 10);  
            .setQuery(matchAllQuery())  
                .setRequestCache(true)
            )  
        final double[] pcts = randomPercents(minValue, maxValue);
        for (int i = 0; i < percents.length; ++i) {
        SearchResponse r = client().prepareSearch("cache_test_idx")
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
                .getTotal()
    }  
     * Make sure that a request using a deterministic script or not using a script get cached.  
        return Collections.singleton(AggregationTestScriptsPlugin.class);
        for (int i = 1; i < percentileList.size(); ++i) {
        );
    @Override
        final double[] percents = new double[length];
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
 * software distributed under the License is distributed on an
public class TDigestPercentileRanksIT extends AbstractNumericTestCase {  
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    @Override
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {  
        assertAcked(
                            percentileRanks("ranks", new double[] { 99 }).method(PercentilesMethod.TDIGEST).field("value")  
        final double[] pcts = randomPercents(minValues, maxValues);
import org.opensearch.script.Script;
            .addAggregation(
                        filter("filter", termQuery("value", 100)).subAggregation(
            )
                .setQuery(matchAllQuery())
            equalTo(1L)  
        );
        }
        );
            }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
        assertConsistent(pcts, values, minValues);
        assertThat(reversePercentiles.percent(10), equalTo(Double.NaN));  
                .get()  
            equalTo(2L)  
            equalTo(0L)
 * Unless required by applicable law or agreed to in writing,
                    .subAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 99 }).field("value")))  
        assertConsistent(pcts, values, minValues - 1);
        Global global = searchResponse.getAggregations().get("global");
    }
                    .subAggregation(randomCompression(percentileRanks("percentile_ranks", new double[] { 10, 15 }).field("value")))  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .prepareStats("cache_test_idx")
        assertThat(buckets.size(), equalTo(10));  
            .get();  
                .setRequestCache(true)
 */  
        SearchResponse searchResponse = client().prepareSearch("idx")  
        assertThat(
    public void testOrderBySubAggregation() {
            .get();
    public void testOrderByEmptyAggregation() throws Exception {
        final double[] pcts = randomPercents(minValues - 1, maxValues - 1);
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
            client().admin()
            .setQuery(matchAllQuery())
        // Test that a request using a deterministic script gets cached  
            .get();
        assertThat(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                percentileRanks("foo", new double[] { 50.0 }).field("d")
                percentileRanks("foo", new double[] { 50.0 }).field("d")
        assertThat(global.getName(), equalTo("global"));
                default:
    }
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
     * Ensure requests using nondeterministic scripts do not get cached.
 */
            .get();
        boolean asc = randomBoolean();  
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).script(script))
                .getHitCount(),  
    public void testSingleValuedFieldGetProperty() throws Exception {
    @Override  
            assertThat(percentile.getPercent(), greaterThanOrEqualTo(0.0));  
import static org.opensearch.index.query.QueryBuilders.termQuery;  
    @Override
    }  
import org.apache.logging.log4j.LogManager;  
 *
            .setQuery(matchAllQuery())
            client().admin()
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap())
            }
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");
            .addAggregation(  
        }  
                .getTotal()
        SearchResponse searchResponse = client().prepareSearch("idx")
                .prepareStats("cache_test_idx")  
        return builder;  
 * GitHub history for details.
                .getRequestCache()
        assertConsistent(pcts, values, minValue);
    public void testNullValuesField() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("idx")
 * under the License.  
                .getTotal()
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {  
            .setQuery(matchAllQuery())
                .getTotal()  
        assertConsistent(pcts, values, minValues);
        assertThat(reversePercentiles.percent(100), equalTo(Double.NaN));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value * -1", emptyMap()))
                .setRequestCache(true)
import org.opensearch.common.settings.Settings;
        Histogram histo = searchResponse.getAggregations().get("histo");
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("values"))
            .addAggregation(
                .indices()  
        PercentileRanks values = global.getAggregations().get("percentile_ranks");  
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
            .addAggregation(
            .addAggregation(  
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
                .getRequestCache()
        assertThat(terms, notNullValue());  
        // Test that a request using a nondeterministic script does not get cached  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        SearchResponse searchResponse = client().prepareSearch("idx")
        }  
                    percents[i] = maxValue;
    public void testSingleValuedField() throws Exception {  
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
                    break;  
                        )
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("values")
    public void testSingleValuedFieldWithValueScript() throws Exception {
        final PercentileRanks values = searchResponse.getAggregations().get("percentile_ranks");  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        for (int i = 0; i < pcts.length; ++i) {  
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));  
            IllegalArgumentException.class,
        Terms terms = searchResponse.getAggregations().get("terms");
            IllegalArgumentException.class,
        params.put("dec", 1);
            } else {
        }
    }
    @Override
        assertThat(
import static org.opensearch.search.aggregations.AggregationBuilders.percentileRanks;
            .get();  
        assertThat(
                terms("terms").field("value")
        SearchResponse searchResponse = client().prepareSearch("idx")
            equalTo(0L)  
        assertSearchResponse(r);
            .setQuery(matchAllQuery())
    }  
            assertThat(filter, notNullValue());
    }  
import org.opensearch.action.search.SearchResponse;
    public void testEmptyAggregation() throws Exception {
            .setQuery(matchAllQuery())
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * Modifications Copyright OpenSearch Contributors. See  
        assertConsistent(pcts, values, minValue - 1);  
            .get();  
            builder.compression(randomIntBetween(20, 120) + randomDouble());
                .getRequestCache()
            client().admin()
                .indices()  
        internalCluster().wipeIndices("cache_test_idx");
            .get();
    private void assertConsistent(double[] pcts, PercentileRanks values, long minValue) {  
                .getRequestCache()
                assertThat(p99, lessThanOrEqualTo(previous));  
        assertConsistent(pcts, values, minValue);  
        return percents;
                .get()
        assertHitCount(searchResponse, 10);
            .addAggregation(randomCompression(percentileRanks("percentile_ranks", pcts)).field("value"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
 * compatible open source license.
            .setQuery(matchAllQuery())
                .setQuery(matchAllQuery())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .get();
/*  
                .setRequestCache(true)
    @Override
    private static PercentileRanksAggregationBuilder randomCompression(PercentileRanksAggregationBuilder builder) {
                .getHitCount(),  
                )
            )  
        for (int i = 0; i < 10; i++) {
                .get()  
                .indices()
            switch (randomInt(20)) {  
        assertThat(global.getAggregations(), notNullValue());  
            assertThat(percentile.getPercent(), lessThanOrEqualTo(100.0));
                .prepareStats("cache_test_idx")  
                randomCompression(percentileRanks("percentile_ranks", pcts)).field("value")  
                .indices()
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.metrics;
        assertThat(global, notNullValue());  
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
            client().admin()
                    percents[i] = minValue;
        assertHitCount(searchResponse, 10);  
            .get();
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
            PercentileRanks ranks = filter.getAggregations().get("ranks");
    public void testMultiValuedField() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("idx")  
 * You may obtain a copy of the License at  
            )
import java.util.List;
    }
    }
 *  
            .get();
        assertThat(histo, notNullValue());  
        );
            .setSize(0)
                .getHitCount(),  
    @Override  
            .setSize(0)
        assertThat(  
            )
                .prepareStats("cache_test_idx")  
            .addAggregation(  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>ranks.99", true)))  
