                .setRequestCache(true)
                randomCompression(percentiles("percentiles")).field("values")
    }  
        assertThat(
        Percentiles percentiles = bucket.getAggregations().get("percentiles");
 * under the License.  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);
                .indices()
        );  
                histogram("histo").field("value")  
            .get();
            .setQuery(matchAllQuery())  
        Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            assertThat(value, greaterThanOrEqualTo((double) minValue));  
            .get();
        assertThat(
            .addAggregation(  
                    .percentiles(pcts)
        );
        Map<String, Object> params = new HashMap<>();
    public void testScriptSingleValued() throws Exception {
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
        SearchResponse searchResponse = client().prepareSearch("idx")  
        params.put("dec", 1);
import java.util.Set;
        }
 * Licensed to Elasticsearch under one or more contributor  
            )  
            previous = p99;
        Terms terms = searchResponse.getAggregations().get("terms");
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            )
            true,  
            .get();  
        assertThat(  
        r = client().prepareSearch("cache_test_idx")
            .get();
 * Unless required by applicable law or agreed to in writing,
        assertThat(percentiles.getName(), equalTo("percentiles"));
                .setRequestCache(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            }
            .setQuery(matchAllQuery())
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
    public void testMultiValuedFieldWithValueScript() throws Exception {
    }
    }
    }
        assertAcked(  
        final double[] pcts = randomPercentiles();  
            if (asc) {
        assertThat(percentiles, notNullValue());  
import org.opensearch.search.aggregations.InternalAggregation;  
        indexRandom(
import org.apache.logging.log4j.LogManager;  
 * this file be licensed under the Apache-2.0 license or a
                .getHitCount(),
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * KIND, either express or implied.  See the License for the
            .get();
        return percentiles;
            client().admin()
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts))
                    .percentiles(pcts)  
        assertThat(
                percentiles("foo").field("d")
                .prepareStats("cache_test_idx")  
                .getRequestCache()
            )
        );  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
        assertThat(percentiles.getName(), equalTo("percentiles"));  
            client().admin()
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
            equalTo(2L)
        }
                assertThat(value, equalTo((double) minValue));
        assertThat(((InternalAggregation) global).getProperty("percentiles"), sameInstance(percentiles));  
        final double[] pcts = randomPercentiles();
    @Override
public class TDigestPercentilesIT extends AbstractNumericTestCase {
 * not use this file except in compliance with the License.
    @Override
                .indices()
                    break;
        );
    }  
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
    /**
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        final double[] pcts = randomPercentiles();
        }  
                .get()
            .setQuery(matchAllQuery())
        );
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
        for (int i = 0; i < length; ++i) {
    @Override  
            client().admin()  
        assertThat(percentiles.percentile(0), equalTo(Double.NaN));
import java.util.Collection;
import static org.opensearch.search.aggregations.AggregationBuilders.global;
            .addAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(global, notNullValue());  
                .get()  
                .getHitCount(),
            .addAggregation(
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
        assertSearchResponse(r);
import static org.hamcrest.Matchers.equalTo;
        assertHitCount(searchResponse, 10);
        SearchResponse searchResponse = client().prepareSearch("idx")  
        SearchResponse r = client().prepareSearch("cache_test_idx")  
                    .percentiles(pcts)
import java.util.HashSet;
    public TDigestPercentilesIT(Settings staticSettings) {
        }
        for (int i = 0; i < pcts.length; ++i) {
            assertThat(percentiles, notNullValue());
/*  
    public void testUnmapped() throws Exception {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .prepareStats("cache_test_idx")
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
    }  
            assertThat(filter, notNullValue());
                    .interval(2L)
            )
                .setRequestCache(true)
                .getRequestCache()
        SearchResponse searchResponse = client().prepareSearch("idx")
import org.opensearch.common.settings.Settings;
    @Override
        assertHitCount(searchResponse, 10);
            double p99 = percentiles.percentile(99);
        );
                    uniquedPercentiles.add(0.0);
    }
        assertConsistent(pcts, percentiles, minValue - 1, maxValue - 1);
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        assertThat(global.getName(), equalTo("global"));
    }  
            .setQuery(matchAllQuery())
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                randomCompression(percentiles("percentiles")).field("values")  
                .get()  
    @Override
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", emptyMap());
    public void testScriptMultiValuedWithParams() throws Exception {
        final int length = randomIntBetween(1, 20);
            .setQuery(matchAllQuery())
                .prepareStats("cache_test_idx")
            assertThat(percentileList.get(i).getValue(), greaterThanOrEqualTo(percentileList.get(i - 1).getValue()));  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                histogram("histo").field("value")  
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(percentiles, notNullValue());
                .get()  
    }
    @Override  
                .setRequestCache(true)  
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value - dec", params);  
            equalTo(0L)  
            builder.compression(randomIntBetween(20, 120) + randomDouble());  
        assertHitCount(searchResponse, 10);
        assertThat(percentiles.getName(), equalTo("percentiles"));
        assertThat(  
            .setQuery(matchAllQuery())
        assertThat(bucket, notNullValue());
 * software distributed under the License is distributed on an
                .getTotal()
                assertThat(p99, lessThanOrEqualTo(previous));
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")  
            .addAggregation(
                .getRequestCache()
    public void testOrderByEmptyAggregation() throws Exception {  
import static org.hamcrest.Matchers.sameInstance;  
        assertThat(percentiles, notNullValue());
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                .get()
                    )
                    .subAggregation(randomCompression(percentiles("percentiles").field("value")).percentiles(10, 15))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .subAggregation(randomCompression(percentiles("percentiles").field("value").percentiles(99)))
            .addAggregation(  
        LogManager.getLogger(TDigestPercentilesIT.class).info("Using percentiles={}", Arrays.toString(percentiles));  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(10));
            equalTo(0L)
            .get();  
        assertThat(
            Terms.Bucket bucket = buckets.get(i);
                .getTotal()
    @Override
        assertHitCount(searchResponse, 10);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        final double[] pcts = randomPercentiles();
                .getTotal()
            .get();
            )
            )
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
        return Collections.singleton(AggregationTestScriptsPlugin.class);
import org.opensearch.script.Script;
        assertThat(percentiles.percentile(100), equalTo(Double.NaN));
            .addAggregation(  
    }  
import org.opensearch.core.common.util.CollectionUtils;  
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {  
            .get();
    public void testMultiValuedField() throws Exception {
                .get()
            )
                    break;
package org.opensearch.search.aggregations.metrics;
            client().admin()
            assertThat(percentile.getPercent(), equalTo(pcts[i]));
            )
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(0, 10, 15, 100))  
import java.util.HashMap;  
            equalTo(0L)
    @Override
                .indices()  
                .getTotal()  
                    .order(BucketOrder.aggregation("percentiles", "99", asc))  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                .getTotal()
    public void testOrderBySubAggregation() {
        double previous = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
import org.opensearch.search.aggregations.BucketOrder;
        Histogram histo = searchResponse.getAggregations().get("histo");
    public void testScriptMultiValued() throws Exception {  
     * Make sure that a request using a deterministic script or not using a script get cached.
                    .interval(1L)
                .getTotal()  
 * specific language governing permissions and limitations
            double value = percentile.getValue();
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        SearchResponse searchResponse = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        // Make sure we are starting with a clear cache
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
import java.util.Arrays;  
                case 0:  
import org.opensearch.search.aggregations.bucket.global.Global;
            equalTo(0L)
            .setQuery(matchAllQuery())
                .indices()  
        boolean asc = randomBoolean();
                .indices()
        assertSearchResponse(r);  
 * You may obtain a copy of the License at  
                .prepareStats("cache_test_idx")
 * SPDX-License-Identifier: Apache-2.0
        }
            } else {
            equalTo(1L)
                .indices()
            )
    }
    public void testScriptCaching() throws Exception {
            final Percentile percentile = percentileList.get(i);  
 * this work for additional information regarding copyright
            .setQuery(matchAllQuery())  
        final List<Percentile> percentileList = CollectionUtils.iterableAsArrayList(percentiles);  
import org.opensearch.plugins.Plugin;
                .indices()  
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        SearchResponse searchResponse = client().prepareSearch("idx")
    private void assertConsistent(double[] pcts, Percentiles percentiles, long minValue, long maxValue) {
                    .subAggregation(  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
                .setRequestCache(true)
                    uniquedPercentiles.add(100.0);
            Percentiles percentiles = filter.getAggregations().get("percentiles");  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
    }
            .get();
                .indices()
                .getMissCount(),
    private static PercentilesAggregationBuilder randomCompression(PercentilesAggregationBuilder builder) {
            .get();
 *
    private static double[] randomPercentiles() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        final double[] pcts = randomPercentiles();
            client().admin()
                    .percentiles(pcts)
    @Override
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", emptyMap());  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))  
            if (percentile.getPercent() == 100) {  
        final double[] pcts = randomPercentiles();
                .getTotal()
     * Ensure requests using nondeterministic scripts do not get cached.  
                        )  
        final Set<Double> uniquedPercentiles = new HashSet<>();  
        super(staticSettings);
    }
        assertThat(histo, notNullValue());  
                .getHitCount(),
        assertHitCount(searchResponse, 10);  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        final double[] pcts = randomPercentiles();  
        SearchResponse searchResponse = client().prepareSearch("idx")
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(percentiles("foo").field("d").percentiles(50.0)).get();
                .setRequestCache(true)
        Map<String, Object> params = new HashMap<>();  
            client().admin()  
        Map<String, Object> params = new HashMap<>();
                .prepareStats("cache_test_idx")
        assertHitCount(searchResponse, 10);
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
        assertEquals(pcts.length, percentileList.size());
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {  
            .get();
        params.put("dec", 1);
        assertConsistent(pcts, percentiles, minValue, maxValue);
        final double[] pcts = randomPercentiles();  
        assertThat(buckets, notNullValue());
            .addAggregation(  
import java.util.Map;  
        Histogram histo = searchResponse.getAggregations().get("histo");  
        assertThat(
import static java.util.Collections.emptyMap;  
    @Override
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
                .prepareStats("cache_test_idx")
            .get();
                .getRequestCache()
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);  
                .get()
        SearchResponse searchResponse = client().prepareSearch("idx")
            Filter filter = bucket.getAggregations().get("filter");  
                            percentiles("percentiles").method(PercentilesMethod.TDIGEST).field("value")
                .getMissCount(),  
            .get();  
            .addAggregation(
    }
        internalCluster().wipeIndices("cache_test_idx");  
            equalTo(0L)  
        for (Histogram.Bucket bucket : histo.getBuckets()) {
                .getRequestCache()
    }  
        SearchResponse searchResponse = client().prepareSearch("idx")  
            .setSize(0)
        final double[] pcts = randomPercentiles();
    public void testScriptSingleValuedWithParams() throws Exception {
            .addAggregation(
 *  
import org.opensearch.script.ScriptType;  
import java.util.Collections;
    }  
        SearchResponse searchResponse = client().prepareSearch("idx")
 * GitHub history for details.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        assertThat(
        assertHitCount(searchResponse, 10);  
        // Test that a request using a deterministic script gets cached  
        assertHitCount(searchResponse, 10);
                percentiles("foo").field("d")  
    public void testSingleValuedFieldGetProperty() throws Exception {
 */  
            .addAggregation(global("global").subAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts)))  
        for (int i = 0; i < 10; i++) {
                    .percentiles(50.0)
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
        Global global = searchResponse.getAggregations().get("global");
            .setQuery(matchAllQuery())
            .setSize(0)
                randomCompression(percentiles("percentiles")).field("value")
            )  
        assertConsistent(pcts, percentiles, minValues, maxValues);  
            assertThat(filter.getDocCount(), equalTo(0L));
 */
            equalTo(0L)
            }
}
    }
                .getMissCount(),  
 * ownership. Elasticsearch licenses this file to you under  
    public void testMultiValuedFieldWithValueScriptReverse() throws Exception {  
    }  
                .setRequestCache(true)  
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        final double[] pcts = randomPercentiles();
            assertThat(value, lessThanOrEqualTo((double) maxValue));
 * compatible open source license.
    public void testSingleValuedFieldWithValueScript() throws Exception {  
     */
            .setQuery(matchAllQuery())  
                .getHitCount(),  
        final double[] pcts = randomPercentiles();  
                    break;
                .get()
        for (int i = 1; i < percentileList.size(); ++i) {
        // Ensure that non-scripted requests are cached as normal
            client().admin()  
    @Override
    @Override
                .get()  
                .getRequestCache()  
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;  
/*
                randomCompression(percentiles("percentiles")).field("values")
        assertConsistent(pcts, percentiles, minValue, maxValue);
    public void testSingleValuedField() throws Exception {  
                default:  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);
            .addAggregation(randomCompression(percentiles("percentiles")).script(script).percentiles(pcts))
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");
                    uniquedPercentiles.add(randomDouble() * 100);
    }  
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
                randomCompression(percentiles("percentiles")).field("value")
    @Override
        assertThat(percentiles.percentile(10), equalTo(Double.NaN));  
import org.opensearch.action.search.SearchResponse;
                    .percentiles(50.0)
                case 1:  
        if (randomBoolean()) {
        SearchResponse searchResponse = client().prepareSearch("idx")
import java.util.List;
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
                .getRequestCache()  
            Percentiles percentiles = bucket.getAggregations().get("percentiles");  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
                terms("terms").field("value")
        assertHitCount(searchResponse, 10);
                .getRequestCache()  
        // Test that a request using a nondeterministic script does not get cached
        final double[] pcts = randomPercentiles();
                .getTotal()
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
            .setQuery(matchAllQuery())
            switch (randomInt(20)) {
        );
            assertThat(percentiles.percentile(99), equalTo(Double.NaN));
            assertThat(bucket, notNullValue());  
                assertThat(p99, greaterThanOrEqualTo(previous));  
            .addAggregation(randomCompression(percentiles("percentiles")).field("values").percentiles(pcts))  
        final Percentiles percentiles = searchResponse.getAggregations().get("percentiles");  
    @Override  
            }  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
                .getMissCount(),
 *
        assertThat(global.getDocCount(), equalTo(10L));
            .addAggregation(
        assertConsistent(pcts, percentiles, minValue, maxValue);
            .get();
            if (percentile.getPercent() == 0) {  
            .get();  
        assertThat(terms, notNullValue());
import org.opensearch.search.aggregations.bucket.filter.Filter;
                    .percentiles(pcts)  
 * The OpenSearch Contributors require contributions made to  
        assertHitCount(searchResponse, 10);
            .setQuery(matchAllQuery())  
        assertConsistent(pcts, percentiles, minValues, maxValues);  
                .prepareStats("cache_test_idx")  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
        assertConsistent(pcts, percentiles, -maxValues, -minValues);
            client().admin()
        SearchResponse searchResponse = client().prepareSearch("idx")
            .addAggregation(randomCompression(percentiles("percentiles")).field("value").percentiles(pcts))
        );  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value * -1", emptyMap()))  
    }
        assertThat(global.getAggregations(), notNullValue());  
                .prepareStats("cache_test_idx")
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.notNullValue;
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        params.put("dec", 1);
    public void testEmptyAggregation() throws Exception {
    @Override
            .setQuery(matchAllQuery())
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))  
            .get();
    }
        );
            .setQuery(matchAllQuery())  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>percentiles.99", true)))
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))  
        assertThat(percentiles.percentile(15), equalTo(Double.NaN));
            .setQuery(matchAllQuery())
        assertHitCount(searchResponse, 10);
            .get();  
        assertHitCount(searchResponse, 10);  
        assertHitCount(searchResponse, 10);  
 * license agreements. See the NOTICE file distributed with
 */
        return builder;
                .setRequestCache(true)  
        );  
                        filter("filter", termQuery("value", 100)).subAggregation(
        assertSearchResponse(r);  
            .get();
        Script script = AggregationTestScriptsPlugin.DECREMENT_ALL_VALUES;
                    .minDocCount(0)
    @Override
/*
        assertConsistent(pcts, percentiles, minValues - 1, maxValues - 1);
                assertThat(value, equalTo((double) maxValue));
        Percentiles percentiles = global.getAggregations().get("percentiles");  
        final double[] pcts = randomPercentiles();
            .setQuery(matchAllQuery())
    }
        double[] percentiles = uniquedPercentiles.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        assertHitCount(searchResponse, 10);
