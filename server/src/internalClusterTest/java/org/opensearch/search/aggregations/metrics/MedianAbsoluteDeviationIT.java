    public void testScriptCaching() throws Exception {
import static org.hamcrest.Matchers.hasSize;
 */  
     * Make sure that a request using a deterministic script or not using a script get cached.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
        final long[] lowerBucketSample = Arrays.stream(singleValueSample)  
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {  
            client().admin()
                .get()
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
 * the Apache License, Version 2.0 (the "License"); you may
                .getMissCount(),
            equalTo(1L)
            client().admin()  
        singleValueExactMAD = calculateMAD(singleValueSample);  
            .setQuery(matchAllQuery())
        final SearchResponse response = client().prepareSearch("idx")  
                randomBuilder().script(
    }
                .getHitCount(),
            .setQuery(matchAllQuery())
            .get();
    private static final int MAX_SAMPLE_VALUE = 1000000;  
        minValues = MIN_SAMPLE_VALUE;  
        );
                .setRequestCache(true)  
        );  
        final SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < 2; i++) {
            .addAggregation(global("global").subAggregation(randomBuilder().field("value")))  
            )
                .getRequestCache()  
/*  
        final SearchResponse response = client().prepareSearch("idx")
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
    public void testMultiValuedField() throws Exception {
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        assertHitCount(response, 2);
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));
    @Override
                    .subAggregation(
                .prepareStats("cache_test_idx")
            MedianAbsoluteDeviation mad = filter.getAggregations().get("mad");  
        );  
                    )
            .setQuery(matchAllQuery())
                        .field("value", singleValueDatapoint)
            final long singleValueDatapoint = sampleSupplier.get();
                .getRequestCache()  
        final SearchResponse response = client().prepareSearch("idx")
        params.put("inc", 1);
        );  
    }  
                    .addRange(rangeBoundary, MAX_SAMPLE_VALUE)
        minValue = MIN_SAMPLE_VALUE;
            .get();
    public void testScriptSingleValued() throws Exception {
        // Ensure that non-scripted requests are cached as normal
            .setQuery(matchAllQuery())  
    @Override
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
        assertThat(mad, notNullValue());
            .addAggregation(
 * GitHub history for details.
                        AggregationTestScriptsPlugin.NAME,
            )  
    private static final int NUMBER_OF_DOCS = 1000;
        assertThat(buckets, hasSize(numberOfBuckets));
        SearchResponse r = client().prepareSearch("cache_test_idx")  
            Filter filter = bucket.getAggregations().get("filter");
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));  
        assertThat(bucket, notNullValue());
                range("range").field("value")  
import org.opensearch.action.index.IndexRequestBuilder;
public class MedianAbsoluteDeviationIT extends AbstractNumericTestCase {  
                .get()
import org.opensearch.search.aggregations.InternalAggregation;  
    private static double multiValueExactMAD;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addAggregation(randomBuilder().field("values"))
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(multiValueSample).map(point -> point + 1).toArray());
            )
            singleValueSample[i] = singleValueDatapoint;
                        ScriptType.INLINE,
            .get();
/*  
        final long[] upperBucketSample = Arrays.stream(singleValueSample)  
        );  
        List<IndexRequestBuilder> builders = new ArrayList<>();
    }
            Arrays.stream(singleValueSample).flatMap(point -> LongStream.of(point, point + 1)).toArray()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        return Collections.singleton(AggregationTestScriptsPlugin.class);  
            .get();
            .addAggregation(
            )
                    .addRange(MIN_SAMPLE_VALUE, rangeBoundary)
        assertHitCount(response, NUMBER_OF_DOCS);
    private static final Supplier<Long> sampleSupplier = () -> randomLongBetween(MIN_SAMPLE_VALUE, MAX_SAMPLE_VALUE);
                .indices()
        assertThat(global.getAggregations().asMap().entrySet(), hasSize(1));
                .getMissCount(),
                        .value(secondMultiValueDatapoint)
                .getHitCount(),
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(multiValueExactMAD));  
                        .endArray()
            )
                        .value(firstMultiValueDatapoint)  
            .get();
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.IsCloseToRelative.closeToRelative;
        final SearchResponse response = client().prepareSearch("idx")
                randomBuilder().field("value")
    /**  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
        final SearchResponse response = client().prepareSearch("idx")
        assertThat(global.getDocCount(), is((long) NUMBER_OF_DOCS));
        assertSearchResponse(r);
            assertThat(mad.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
    }
        assertThat(  
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));
    @Override  
        final Settings settings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();  
        assertThat(lowerBucketMAD.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(lowerBucketSample)));  
        final SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
            .get();  
                .getRequestCache()
    @Override
        }  
import static java.util.Collections.emptyMap;
                .prepareStats("cache_test_idx")  
        assertThat(  
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                .getMissCount(),
        assertThat(lowerBucketMAD, notNullValue());
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(mad, notNullValue());
    @Override
            .addAggregation(
        params.put("inc", 1);
    @Override  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
            client().admin()  
                randomBuilder().field("d")  
        ensureSearchable();
    public void testUnmapped() throws Exception {
                .indices()
            .addAggregation(randomBuilder().field("value"))
        final Map<String, Object> params = new HashMap<>();
            )
        assertThat(mad.getName(), is("mad"));
    }  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")  
            final long firstMultiValueDatapoint = sampleSupplier.get();
            .addAggregation(
        assertThat(mad, notNullValue());
            .addAggregation(  
            .get();
package org.opensearch.search.aggregations.metrics;
    }  
}  
            final long secondMultiValueDatapoint = sampleSupplier.get();  
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
            .setQuery(matchAllQuery())
            .get();  
            .toArray();
            )
                .getHitCount(),
                .setRequestCache(true)
        // Test moved to MedianAbsoluteDeviationAggregatorTests.testUnmapped()
    private static long[] singleValueSample;
import java.util.function.Supplier;
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>mad", true)))
            )
            );
                .prepareStats("cache_test_idx")  
import static org.hamcrest.Matchers.sameInstance;
            client().admin()
            .setSize(0)
            .toArray();
    private static final int MIN_SAMPLE_VALUE = -1000000;
    }  
                .setRequestCache(true)
        assertThat(mad, notNullValue());
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
        assertThat(mad.getName(), is("mad"));
        );
        final int numberOfBuckets = 10;
            .get();  
        }
        final SearchResponse response = client().prepareSearch("idx")  
 * not use this file except in compliance with the License.
            )  
        );  
        params.put("inc", 1);
                    .size(numberOfBuckets)  
/*
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
                .prepareStats("cache_test_idx")  
                terms("terms").field("value")
    public void testOrderByEmptyAggregation() throws Exception {  
            .get();  
        assertThat(((InternalAggregation) global).getProperty("mad"), sameInstance(mad));  
        assertThat(mad, notNullValue());
            true,  
        final Range range = response.getAggregations().get("range");
    @Override
        assertThat(terms, notNullValue());
    private static double singleValueExactMAD;  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
        final SearchResponse response = client().prepareSearch("idx")
import org.opensearch.script.ScriptType;  
                        filter("filter", termQuery("value", MAX_SAMPLE_VALUE + 1)).subAggregation(randomBuilder().field("value"))  
                .prepareStats("cache_test_idx")
        assertHitCount(response, NUMBER_OF_DOCS);  
 * under the License.  
            )
            .addAggregation(randomBuilder().field("value"))  
    }
            multiValueSample[(i * 2) + 1] = secondMultiValueDatapoint;
        }
            equalTo(0L)  
     */  
        assertThat(mad, notNullValue());
            builders.add(  
        final int rangeBoundary = (MAX_SAMPLE_VALUE + MIN_SAMPLE_VALUE) / 2;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
    }
                randomBuilder().field("values")  
        assertThat(mad.getName(), is("mad"));
    }  
    public void testScriptMultiValued() throws Exception {  
    public void testScriptSingleValuedWithParams() throws Exception {
        final Map<String, Object> params = new HashMap<>();
                .setRequestCache(true)
            .addAggregation(
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        assertHitCount(response, NUMBER_OF_DOCS);
                )  
        assertThat(mad.getName(), is("mad"));
                randomBuilder().field("value")
        if (randomBoolean()) {
    }
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(range, notNullValue());
            )
            .setQuery(matchAllQuery())
        assertThat(mad, notNullValue());
        assertThat(global.getAggregations(), notNullValue());  
    private static long[] multiValueSample;
import org.opensearch.search.aggregations.bucket.range.Range;
        maxValues = MAX_SAMPLE_VALUE;
        assertThat(buckets, hasSize(2));
 * this file be licensed under the Apache-2.0 license or a
                .get()
            .setQuery(matchAllQuery())
                randomBuilder().script(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setQuery(matchAllQuery())  
    @Override
        );
        final MedianAbsoluteDeviation upperBucketMAD = upperBucket.getAggregations().get("mad");
import org.opensearch.search.aggregations.bucket.global.Global;
            equalTo(2L)
                randomBuilder().field("d")  
                .getHitCount(),
import java.util.HashMap;
        assertThat(upperBucket, notNullValue());  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        final SearchResponse response = client().prepareSearch("idx")
                randomBuilder().script(
                    new Script(  
        createIndex("idx_unmapped", settings);  
            .addAggregation(
        builders = new ArrayList<>();
import java.util.ArrayList;
        final Histogram.Bucket bucket = histogram.getBuckets().get(1);  
            equalTo(0L)  
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
import static org.hamcrest.core.Is.is;  
        final MedianAbsoluteDeviation mad = bucket.getAggregations().get("mad");  
                .getMissCount(),
import java.util.Arrays;
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                .setRequestCache(true)  
    @Override
 * The OpenSearch Contributors require contributions made to  
            .filter(point -> point >= rangeBoundary && point < MAX_SAMPLE_VALUE)
        multiValueSample = new long[NUMBER_OF_DOCS * 2];
        assertThat(mad.getMedianAbsoluteDeviation(), is(Double.NaN));  
 * You may obtain a copy of the License at  
        maxValue = MAX_SAMPLE_VALUE;
            .filter(point -> point >= MIN_SAMPLE_VALUE && point < rangeBoundary)
            IndexRequestBuilder builder = client().prepareIndex("idx")  
                .getTotal()  
    }
        // Make sure we are starting with a clear cache
            .setQuery(matchAllQuery())
import org.opensearch.plugins.Plugin;
            .get();
        final SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                        "[ doc['value'].value, doc['value'].value + inc ]",  
        final MedianAbsoluteDeviation lowerBucketMAD = lowerBucket.getAggregations().get("mad");
    public void testMultiValuedFieldWithValueScript() throws Exception {
                    jsonBuilder().startObject()  
        assertThat(buckets, notNullValue());
import java.util.stream.LongStream;  
 * compatible open source license.
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");  
            .setQuery(matchAllQuery())
                .getRequestCache()
        assertThat(  
                .prepareStats("cache_test_idx")
        assertSearchResponse(r);
        assertThat(mad.getName(), is("mad"));
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", Collections.emptyMap())
            assertThat(filter, notNullValue());  
import static org.hamcrest.core.IsNull.notNullValue;
        indexRandom(true, builders);  
        assertThat(mad.getName(), is("mad"));  
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        final Range.Bucket upperBucket = buckets.get(1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        final Map<String, Object> params = new HashMap<>();  
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");  
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", Collections.emptyMap())  
            .setQuery(matchAllQuery())  
        for (int i = 0; i < NUMBER_OF_DOCS; i++) {  
            .addAggregation(  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .prepareStats("cache_test_idx")
                .get()
        params.put("inc", 1);  
            .get();  
        final Range.Bucket lowerBucket = buckets.get(0);
    }
        assertThat(mad.getName(), is("mad"));
                .getTotal()  
import org.opensearch.search.aggregations.bucket.filter.Filter;
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
            .get();
        assertThat(upperBucketMAD.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(upperBucketSample)));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");  
    public void testSingleValuedField() throws Exception {  
    }
            equalTo(0L)  
                );
    }  
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
        assertThat(
            equalTo(0L)  
        assertThat(mad, notNullValue());  
                client().prepareIndex("empty_bucket_idx")
        assertThat(mad.getName(), is("mad"));  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
 */
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(multiValueSample).map(point -> point + 1).toArray());
                .get()
                    .setId(String.valueOf(i))
            .get();  
    public MedianAbsoluteDeviationIT(Settings staticSettings) {  
        assertHitCount(response, NUMBER_OF_DOCS);
        assertThat(upperBucketMAD, notNullValue());  
        assertThat(global.getName(), is("global"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                .setRequestCache(true)  
                .indices()
import static org.hamcrest.Matchers.equalTo;  
        }
            assertThat(mad, notNullValue());
                .getRequestCache()  
        final SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                .get()
        multiValueExactMAD = calculateMAD(multiValueSample);
     * Ensure requests using nondeterministic scripts do not get cached.
                .indices()
        super(staticSettings);
import org.opensearch.search.aggregations.BucketOrder;
            assertThat(bucket, notNullValue());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        );
        assertHitCount(response, NUMBER_OF_DOCS);
                    .subAggregation(randomBuilder().field("value"))  
                        params
                .getTotal()  
        for (int i = 0; i < numberOfBuckets; i++) {
            builder.compression(randomDoubleBetween(20, 1000, false));  
 * Modifications Copyright OpenSearch Contributors. See
        assertHitCount(response, NUMBER_OF_DOCS);  
        assertThat(histogram, notNullValue());
 *
import static org.opensearch.search.aggregations.AggregationBuilders.range;
            .addAggregation(
 * this work for additional information regarding copyright
        assertThat(
        final SearchResponse response = client().prepareSearch("idx")  
                randomBuilder().field("values")
            equalTo(0L)
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        singleValueSample = new long[NUMBER_OF_DOCS];
        final Map<String, Object> params = new HashMap<>();
        final SearchResponse response = client().prepareSearch("empty_bucket_idx")
 * Licensed to Elasticsearch under one or more contributor  
            .setQuery(matchAllQuery())  
import java.util.Collection;  
        // Test that a request using a deterministic script gets cached
                .getTotal()
                .getRequestCache()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
        createIndex("idx", settings);
                .getTotal()
 *
                .setId(String.valueOf(i))
    }
        assertThat(mad.getName(), is("mad"));
        assertThat(
        r = client().prepareSearch("cache_test_idx")  
 * Unless required by applicable law or agreed to in writing,
                .setRequestCache(true)  
    }
        final MedianAbsoluteDeviation mad = global.getAggregations().get("mad");  
        assertAcked(
            .get();
            .setQuery(matchAllQuery())
        assertThat(  
                .getTotal()
 *  
 * software distributed under the License is distributed on an
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {  
                .getRequestCache()  
import java.util.List;  
                .indices()
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());  
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.ExactMedianAbsoluteDeviation.calculateMAD;
            .get();
import org.opensearch.action.search.SearchResponse;
            client().admin()  
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");  
        return builder;
            .addAggregation(histogram("histogram").field("value").interval(1).minDocCount(0).subAggregation(randomBuilder().field("value")))
            multiValueSample[i * 2] = firstMultiValueDatapoint;  
        assertThat(mad, notNullValue());  
    @Override
                )  
        List<? extends Range.Bucket> buckets = range.getBuckets();  
    @Override  
            builders.add(builder);  
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
                .getRequestCache()
        assertHitCount(response, NUMBER_OF_DOCS);  
    public void setupSuiteScopeCluster() throws Exception {
        final Terms terms = response.getAggregations().get("terms");
        // Test that a request using a nondeterministic script does not get cached
    public void testSingleValuedFieldGetProperty() throws Exception {  
    public void testAsSubAggregation() throws Exception {
                .getTotal()
                .setRequestCache(true)
        assertHitCount(response, NUMBER_OF_DOCS);
        assertThat(lowerBucket, notNullValue());
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));  
            assertThat(filter.getDocCount(), equalTo(0L));
                        .endObject()  
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(multiValueExactMAD));
                        .startArray("values")
        assertThat(buckets, notNullValue());
        final Global global = response.getAggregations().get("global");
            .setQuery(matchAllQuery())  
        final MedianAbsoluteDeviationAggregationBuilder builder = new MedianAbsoluteDeviationAggregationBuilder("mad");
            client().admin()  
        internalCluster().wipeIndices("cache_test_idx");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
 * specific language governing permissions and limitations
        final SearchResponse response = client().prepareSearch("idx")  
    @Override
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))  
                .indices()
        assertHitCount(response, NUMBER_OF_DOCS);
            .addAggregation(
    }  
        indexRandom(
        assertThat(mad, notNullValue());
                    )
            .setSize(0)
import org.opensearch.script.Script;
                .indices()
                randomBuilder().script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value + inc", params))  
            )
        assertThat(mad, notNullValue());  
                .indices()
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                .prepareStats("cache_test_idx")  
 */  
    @Override
        );  
        assertHitCount(response, NUMBER_OF_DOCS);  
    }
        assertThat(
        assertThat(mad, notNullValue());
        assertHitCount(response, NUMBER_OF_DOCS);
    @Override  
        assertSearchResponse(r);
            .get();  
        assertThat(global, notNullValue());  
import java.util.Collections;
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
        assertHitCount(response, NUMBER_OF_DOCS);
        assertThat(mad.getName(), is("mad"));
            client().admin()
            Terms.Bucket bucket = buckets.get(i);
        );  
        assertHitCount(response, NUMBER_OF_DOCS);
                .get()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
        final Histogram histogram = response.getAggregations().get("histogram");
import java.util.Map;
                .get()
    public void testEmptyAggregation() throws Exception {  
        assertThat(mad.getName(), is("mad"));
    public void testScriptMultiValuedWithParams() throws Exception {
    @Override
                .get()
                )
        assertThat(mad, notNullValue());
                .getTotal()  
    private static MedianAbsoluteDeviationAggregationBuilder randomBuilder() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indexRandom(true, builders);  
    @Override  
    }
        final double fromIncrementedSampleMAD = calculateMAD(
    public void testSingleValuedFieldWithValueScript() throws Exception {
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
    @Override
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(randomBuilder().field("d")).get();  
            client().admin()
        assertHitCount(response, NUMBER_OF_DOCS);
            .addAggregation(  
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());
            equalTo(0L)
                .setSource(
