                randomBuilder().script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value + inc", params))
                .setSource(
            .filter(point -> point >= rangeBoundary && point < MAX_SAMPLE_VALUE)
        final Map<String, Object> params = new HashMap<>();
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.IsCloseToRelative.closeToRelative;
            equalTo(0L)
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        List<? extends Range.Bucket> buckets = range.getBuckets();
        // Test that a request using a deterministic script gets cached
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
                .get()
    public void testScriptSingleValued() throws Exception {
            .setQuery(matchAllQuery())
        );
     * Make sure that a request using a deterministic script or not using a script get cached.
            assertThat(filter.getDocCount(), equalTo(0L));
            .addAggregation(randomBuilder().field("value"))
    public void testEmptyAggregation() throws Exception {
    private static final int MIN_SAMPLE_VALUE = -1000000;
        internalCluster().wipeIndices("cache_test_idx");
    @Override
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
    @Override
 * GitHub history for details.
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.sameInstance;
                .indices()
        assertThat(mad.getName(), is("mad"));
        assertHitCount(response, NUMBER_OF_DOCS);
        final Histogram.Bucket bucket = histogram.getBuckets().get(1);
        // Ensure that non-scripted requests are cached as normal
            )
        assertThat(mad, notNullValue());
    @Override
    }
        assertThat(global, notNullValue());
    @Override
 * license agreements. See the NOTICE file distributed with
    }
        builders = new ArrayList<>();
            equalTo(0L)
        final SearchResponse response = client().prepareSearch("idx")
        assertThat(mad.getName(), is("mad"));
        minValues = MIN_SAMPLE_VALUE;
            .addAggregation(histogram("histogram").field("value").interval(1).minDocCount(0).subAggregation(randomBuilder().field("value")))
            .addAggregation(
 * under the License.
        assertThat(
        final MedianAbsoluteDeviation upperBucketMAD = upperBucket.getAggregations().get("mad");
        assertHitCount(response, NUMBER_OF_DOCS);
                )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
        minValue = MIN_SAMPLE_VALUE;
import org.opensearch.search.aggregations.bucket.range.Range;
                .prepareStats("cache_test_idx")
                .setRequestCache(true)
    @Override
    }
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
        assertThat(upperBucketMAD, notNullValue());
        maxValue = MAX_SAMPLE_VALUE;
        }
                .getMissCount(),
            assertThat(bucket, notNullValue());
            )
    }
            final long secondMultiValueDatapoint = sampleSupplier.get();
                .getHitCount(),
        assertThat(bucket, notNullValue());
        assertThat(buckets, hasSize(2));
 * the Apache License, Version 2.0 (the "License"); you may
                    .size(numberOfBuckets)
        assertHitCount(response, NUMBER_OF_DOCS);
                .indices()
        assertThat(mad, notNullValue());
/*
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(randomBuilder().field("d")).get();
    private static final Supplier<Long> sampleSupplier = () -> randomLongBetween(MIN_SAMPLE_VALUE, MAX_SAMPLE_VALUE);
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", Collections.emptyMap())
        indexRandom(true, builders);
    public void setupSuiteScopeCluster() throws Exception {
                randomBuilder().field("value")
            .addAggregation(
            .addAggregation(
        final Range range = response.getAggregations().get("range");
        );
 * The OpenSearch Contributors require contributions made to
        assertHitCount(response, 2);
        assertThat(histogram, notNullValue());
    public MedianAbsoluteDeviationIT(Settings staticSettings) {
            .addAggregation(
            )
                    .subAggregation(
    @Override
            .addAggregation(
                    )
    }
    }
        final Range.Bucket upperBucket = buckets.get(1);
        assertHitCount(response, NUMBER_OF_DOCS);
import static java.util.Collections.emptyMap;
        assertThat(mad.getName(), is("mad"));
        multiValueSample = new long[NUMBER_OF_DOCS * 2];
import org.opensearch.search.aggregations.bucket.terms.Terms;
    @Override
 *
        assertThat(((InternalAggregation) global).getProperty("mad"), sameInstance(mad));
                )
        return builder;
        final double fromIncrementedSampleMAD = calculateMAD(
    public void testScriptCaching() throws Exception {
                .setRequestCache(true)
                .indices()
    public void testScriptSingleValuedWithParams() throws Exception {
            .setQuery(matchAllQuery())
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .getTotal()
        }
                .prepareStats("cache_test_idx")
            builders.add(
 * Unless required by applicable law or agreed to in writing,
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                    new Script(
    @Override
        createIndex("idx_unmapped", settings);
import java.util.ArrayList;
        assertHitCount(response, NUMBER_OF_DOCS);
            )
            .addAggregation(randomBuilder().field("values"))
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
import org.opensearch.search.aggregations.bucket.filter.Filter;
            client().admin()
            equalTo(2L)
                .getMissCount(),
        assertHitCount(response, NUMBER_OF_DOCS);
                        filter("filter", termQuery("value", MAX_SAMPLE_VALUE + 1)).subAggregation(randomBuilder().field("value"))
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
            .get();
import static org.hamcrest.core.Is.is;
        if (randomBoolean()) {
            )
        assertThat(range, notNullValue());
    }
    @Override
        final Histogram histogram = response.getAggregations().get("histogram");
        assertThat(mad.getMedianAbsoluteDeviation(), is(Double.NaN));
            final long singleValueDatapoint = sampleSupplier.get();
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
        assertThat(mad, notNullValue());
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", emptyMap()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
 * You may obtain a copy of the License at
                .indices()
        indexRandom(
            )
                        .value(secondMultiValueDatapoint)
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
                    .subAggregation(randomBuilder().field("value"))
                randomBuilder().script(
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.ExactMedianAbsoluteDeviation.calculateMAD;
        final Map<String, Object> params = new HashMap<>();
    }
    @Override
        SearchResponse r = client().prepareSearch("cache_test_idx")
                        AggregationTestScriptsPlugin.NAME,
                        ScriptType.INLINE,
        assertThat(lowerBucketMAD, notNullValue());
        assertThat(global.getAggregations(), notNullValue());
            equalTo(0L)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final int rangeBoundary = (MAX_SAMPLE_VALUE + MIN_SAMPLE_VALUE) / 2;
        assertHitCount(response, NUMBER_OF_DOCS);
            .addAggregation(
 *
                .indices()
        final Range.Bucket lowerBucket = buckets.get(0);
        assertThat(global.getAggregations().asMap().entrySet(), hasSize(1));
        final SearchResponse response = client().prepareSearch("idx")
                .getRequestCache()
    /**
            Terms.Bucket bucket = buckets.get(i);
import static org.opensearch.index.query.QueryBuilders.termQuery;
import java.util.Arrays;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            )
            .get();
        );
    private static double multiValueExactMAD;
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
    @Override
            .get();
import java.util.Collection;
        assertSearchResponse(r);
        assertThat(mad.getName(), is("mad"));
    }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                .setRequestCache(true)
            )
            .get();
                .get()
        params.put("inc", 1);
        assertThat(buckets, notNullValue());
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", Collections.emptyMap())
                .getTotal()
 * compatible open source license.
                .setRequestCache(true)
        // Make sure we are starting with a clear cache
            .setQuery(matchAllQuery())
                range("range").field("value")
        final Map<String, Object> params = new HashMap<>();
            client().admin()
            client().admin()
            .get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(multiValueExactMAD));
     * Ensure requests using nondeterministic scripts do not get cached.
        final SearchResponse response = client().prepareSearch("idx")
                    .addRange(MIN_SAMPLE_VALUE, rangeBoundary)
            )
        assertThat(upperBucketMAD.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(upperBucketSample)));
                .get()
    public void testOrderByEmptyAggregation() throws Exception {
        multiValueExactMAD = calculateMAD(multiValueSample);
        final MedianAbsoluteDeviationAggregationBuilder builder = new MedianAbsoluteDeviationAggregationBuilder("mad");
    @Override
    private static long[] singleValueSample;
                .get()
            Arrays.stream(singleValueSample).flatMap(point -> LongStream.of(point, point + 1)).toArray()
    @Override
                );
    public void testSingleValuedField() throws Exception {
            .addAggregation(global("global").subAggregation(randomBuilder().field("value")))
            .toArray();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                .getMissCount(),
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>mad", true)))
                .getHitCount(),
                    )
        assertThat(
                terms("terms").field("value")
        assertThat(mad.getName(), is("mad"));
    }
                .getTotal()
            true,
    private static MedianAbsoluteDeviationAggregationBuilder randomBuilder() {
        return Collections.singleton(AggregationTestScriptsPlugin.class);
        createIndex("idx", settings);
        assertThat(upperBucket, notNullValue());
    }
 */
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
                randomBuilder().script(
                .indices()
                .prepareStats("cache_test_idx")
        assertHitCount(response, NUMBER_OF_DOCS);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .field("value", singleValueDatapoint)
            builder.compression(randomDoubleBetween(20, 1000, false));
                        .endObject()
            .get();
        assertThat(mad.getName(), is("mad"));
        final Settings settings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build();
            )
            .addAggregation(
                .getTotal()
    @Override
        final SearchResponse response = client().prepareSearch("idx")
        assertThat(lowerBucket, notNullValue());
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", emptyMap()))
        assertThat(
                    jsonBuilder().startObject()
            .get();
                )
                randomBuilder().field("values")
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
import org.opensearch.script.ScriptType;
        assertThat(mad, notNullValue());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .get();
            .addAggregation(
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                .indices()
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(mad, notNullValue());
    }
            client().admin()
                        .value(firstMultiValueDatapoint)
        final int numberOfBuckets = 10;
public class MedianAbsoluteDeviationIT extends AbstractNumericTestCase {
                randomBuilder().script(
        final SearchResponse response = client().prepareSearch("idx")
import java.util.stream.LongStream;
                .getRequestCache()
        assertThat(mad, notNullValue());
        assertThat(mad.getName(), is("mad"));
        assertThat(mad, notNullValue());
            .setQuery(matchAllQuery())
/*
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
        final SearchResponse response = client().prepareSearch("idx")
                .getRequestCache()
        assertThat(
            .setQuery(matchAllQuery())
                randomBuilder().field("d")
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));
        ensureSearchable();
        params.put("inc", 1);
    public void testMultiValuedField() throws Exception {
        for (int i = 0; i < 2; i++) {
        final MedianAbsoluteDeviation lowerBucketMAD = lowerBucket.getAggregations().get("mad");
        assertThat(mad.getName(), is("mad"));
            .get();
        );
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());
        // Test that a request using a nondeterministic script does not get cached
 * ownership. Elasticsearch licenses this file to you under
                .get()
 * specific language governing permissions and limitations
import org.opensearch.action.index.IndexRequestBuilder;
    }
/*
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
    public void testMultiValuedFieldWithValueScript() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        final SearchResponse response = client().prepareSearch("idx")
                .getTotal()
    @Override
            .setSize(0)
        final Global global = response.getAggregations().get("global");
            equalTo(1L)
            .get();
 * KIND, either express or implied.  See the License for the
    public void testAsSubAggregation() throws Exception {
                .setRequestCache(true)
        final SearchResponse response = client().prepareSearch("idx")
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
package org.opensearch.search.aggregations.metrics;
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        final Map<String, Object> params = new HashMap<>();
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
        assertThat(
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * this work for additional information regarding copyright
        }
            .get();
            client().admin()
import static org.hamcrest.Matchers.hasSize;
        assertHitCount(response, NUMBER_OF_DOCS);
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());
            .toArray();
                    .addRange(rangeBoundary, MAX_SAMPLE_VALUE)
            .addAggregation(
                .getTotal()
import java.util.HashMap;
            .filter(point -> point >= MIN_SAMPLE_VALUE && point < rangeBoundary)
    }
        );
                .prepareStats("cache_test_idx")
            .addAggregation(
 * not use this file except in compliance with the License.
            assertThat(mad.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
            Filter filter = bucket.getAggregations().get("filter");
        // Test moved to MedianAbsoluteDeviationAggregatorTests.testUnmapped()
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(multiValueSample).map(point -> point + 1).toArray());
        assertThat(lowerBucketMAD.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(lowerBucketSample)));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertHitCount(response, NUMBER_OF_DOCS);
        assertAcked(
        singleValueSample = new long[NUMBER_OF_DOCS];
            client().admin()
        final SearchResponse response = client().prepareSearch("idx")
            IndexRequestBuilder builder = client().prepareIndex("idx")
    @Override
        assertThat(global.getDocCount(), is((long) NUMBER_OF_DOCS));
                .getRequestCache()
 */
        assertThat(buckets, notNullValue());
                .prepareStats("cache_test_idx")
        assertHitCount(response, NUMBER_OF_DOCS);
                        .startArray("values")
        final SearchResponse response = client().prepareSearch("empty_bucket_idx")
                .prepareStats("cache_test_idx")
                .indices()
                .get()
import org.opensearch.action.search.SearchResponse;
import org.opensearch.plugins.Plugin;
        assertThat(mad, notNullValue());
    }
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
                .setRequestCache(true)
    }
                .prepareStats("cache_test_idx")
            .setSize(0)
        final long[] lowerBucketSample = Arrays.stream(singleValueSample)
                .getHitCount(),
import java.util.Collections;
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
            equalTo(0L)
        for (int i = 0; i < numberOfBuckets; i++) {
            client().admin()
            multiValueSample[i * 2] = firstMultiValueDatapoint;
import org.opensearch.search.aggregations.bucket.global.Global;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
                .getHitCount(),
        assertThat(mad, notNullValue());
                .getRequestCache()
            .setQuery(matchAllQuery())
    private static final int NUMBER_OF_DOCS = 1000;
    public void testSingleValuedFieldGetProperty() throws Exception {
import org.opensearch.search.aggregations.InternalAggregation;
        );
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(
        final SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat(mad, notNullValue());
        );
            .get();
                    .setId(String.valueOf(i))
        final SearchResponse response = client().prepareSearch("idx")
            .get();
    public void testUnmapped() throws Exception {
 * software distributed under the License is distributed on an
                        params
        singleValueExactMAD = calculateMAD(singleValueSample);
 *
                .get()
            .setQuery(matchAllQuery())
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
                randomBuilder().field("value")
        assertThat(mad, notNullValue());
        assertThat(mad, notNullValue());
                .getRequestCache()
        );
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
        indexRandom(true, builders);
        }
                .getMissCount(),
            MedianAbsoluteDeviation mad = filter.getAggregations().get("mad");
            .get();
        assertHitCount(response, NUMBER_OF_DOCS);
            .setQuery(matchAllQuery())
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(singleValueSample).map(point -> point + 1).toArray());
            .setQuery(matchAllQuery())
import org.opensearch.script.Script;
        assertThat(mad.getName(), is("mad"));
    private static double singleValueExactMAD;
        final SearchResponse response = client().prepareSearch("idx")
                randomBuilder().field("d")
                .get()
 */
            equalTo(0L)
                        "[ doc['value'].value, doc['value'].value + inc ]",
                .getTotal()
        assertHitCount(response, NUMBER_OF_DOCS);
                client().prepareIndex("empty_bucket_idx")
        final SearchResponse response = client().prepareSearch("idx")
        assertThat(mad.getName(), is("mad"));
            multiValueSample[(i * 2) + 1] = secondMultiValueDatapoint;
        for (int i = 0; i < NUMBER_OF_DOCS; i++) {
            .setQuery(matchAllQuery())
        final Terms terms = response.getAggregations().get("terms");
                .getRequestCache()
            client().admin()
        );
                .setRequestCache(true)
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(singleValueExactMAD));
            .addAggregation(
            .get();
        assertThat(mad, notNullValue());
    }
    }
            final long firstMultiValueDatapoint = sampleSupplier.get();
        final double fromIncrementedSampleMAD = calculateMAD(Arrays.stream(multiValueSample).map(point -> point + 1).toArray());
                .getRequestCache()
            )
        final MedianAbsoluteDeviation mad = bucket.getAggregations().get("mad");
    @Override
            );
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .get()
                .prepareStats("cache_test_idx")
            assertThat(mad, notNullValue());
        assertThat(mad.getName(), is("mad"));
            .addAggregation(randomBuilder().field("value"))
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(
    public void testScriptMultiValuedWithParams() throws Exception {
        final MedianAbsoluteDeviation mad = response.getAggregations().get("mad");
     */
                .setId(String.valueOf(i))
        params.put("inc", 1);
                .setRequestCache(true)
        assertThat(
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(fromIncrementedSampleMAD));
        final MedianAbsoluteDeviation mad = global.getAggregations().get("mad");
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import org.opensearch.common.settings.Settings;
import org.opensearch.search.aggregations.BucketOrder;
            .setQuery(matchAllQuery())
        assertThat(global.getName(), is("global"));
        r = client().prepareSearch("cache_test_idx")
import static org.hamcrest.core.IsNull.notNullValue;
            )
                        .endArray()
            builders.add(builder);
            .get();
        assertSearchResponse(r);
        );
            .setQuery(matchAllQuery())
            equalTo(0L)
    public void testScriptMultiValued() throws Exception {
                .getTotal()
        assertThat(mad.getMedianAbsoluteDeviation(), closeToRelative(multiValueExactMAD));
    }
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
 * SPDX-License-Identifier: Apache-2.0
    private static long[] multiValueSample;
import static org.opensearch.search.aggregations.AggregationBuilders.range;
        assertHitCount(response, NUMBER_OF_DOCS);
            assertThat(filter, notNullValue());
        assertSearchResponse(r);
        );
    public void testSingleValuedFieldWithValueScript() throws Exception {
import static org.hamcrest.Matchers.equalTo;
    private static final int MAX_SAMPLE_VALUE = 1000000;
            singleValueSample[i] = singleValueDatapoint;
            .setQuery(matchAllQuery())
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        final SearchResponse response = client().prepareSearch("idx")
        assertThat(terms, notNullValue());
        maxValues = MAX_SAMPLE_VALUE;
        params.put("inc", 1);
        super(staticSettings);
                randomBuilder().field("values")
        assertThat(buckets, hasSize(numberOfBuckets));
            .addAggregation(
import java.util.function.Supplier;
import java.util.Map;
        final long[] upperBucketSample = Arrays.stream(singleValueSample)
}
