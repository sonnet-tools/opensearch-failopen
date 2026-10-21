                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            fail("Illegal percent's were provided but no exception was thrown.");
            )
        for (Double p : PERCENTS) {
            Histogram histo = termsBucket.getAggregations().get("histo");
        for (Double p : percent) {
            Histogram histo = termsBucket.getAggregations().get("histo");
            assertEquals(percentiles.percentile(percentile.getPercent()), percentile.getValue(), 0d);
                assertThat(bucket, notNullValue());
            if (cause == null) {
    }
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
    }
        }
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(0));
    public void testBadPercents() throws Exception {
        }
                    .subAggregation(percentilesBucket("percentile_histo_bucket", "histo>_count").setPercents(percent))
    @Override
        for (int i = 0; i < percents.length; ++i) {
    }
                            .endObject()
        assertSearchResponse(response);
                            .interval(interval)
                    .order(BucketOrder.key(true))
        assertSearchResponse(response);
            new Object[] {
                    .subAggregation(
    }
                .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        assertThat(percentilesBucketValue, notNullValue());
 * this work for additional information regarding copyright
    }
            .addAggregation(
            Terms.Bucket bucket = buckets.get(i);
        assertThat(terms, notNullValue());
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            }
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.index.IndexRequestBuilder;
            assertThat(bucket.getDocCount(), greaterThan(0L));
        }
                values[j] = bucket.getDocCount();
                    .subAggregation(
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentile_histo_bucket");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            fail("2.0 was not a valid percent, should have thrown exception");
                        .subAggregation(
            assertThat(sum, notNullValue());
        }
                terms("terms").field("tag")
import org.opensearch.search.aggregations.metrics.Sum;
        assertSearchResponse(response);
        maxRandomValue = 20;
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentile_terms_bucket");
                )
        double[] badPercents = { -1.0, 110.0 };
import java.util.Arrays;
            .get();
        }
            assertPercentileBucket(PERCENTS, values.stream().mapToDouble(Double::doubleValue).toArray(), percentilesBucketValue);
        return Arrays.asList(
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(sum, notNullValue());
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
        assertSearchResponse(response);
                throw e;
                assertThat(bucket, notNullValue());
            assertPercentileBucket(PERCENTS, innerValues, percentilesBucketValue);
                terms("terms").field("tag")
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        assertFalse(it.hasNext());
            assertThat(bucket.getDocCount(), greaterThan(0L));
            assertThat(percentilesBucketValue.percentile(p), equalTo(Double.NaN));
    public static Collection<Object[]> parameters() {
        createIndex("idx_unmapped");
            assertThat(histo, notNullValue());
                    assertThat(sum, notNullValue());
            )
    public void testMetricTopLevel() throws Exception {
                    )
 * The OpenSearch Contributors require contributions made to
        }
        Arrays.sort(values);
            int index = (int) Math.round((percentile.getPercent() / 100.0) * (values.length - 1));
            List<Double> values = new ArrayList<>(numValueBuckets);
            } else if (cause instanceof SearchPhaseExecutionException) {
    public void testNested() throws Exception {
    }
                    )
        Terms terms = response.getAggregations().get("terms");
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
            assertThat(percentilesBucketValue.getName(), equalTo("percentile_histo_bucket"));
            );
                    .order(BucketOrder.key(true))
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
                                .extendedBounds(minRandomValue, maxRandomValue)
    }
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        SearchResponse response = client().prepareSearch("idx")
            .get();
                    )
package org.opensearch.search.aggregations.pipeline;
        assertThat(termsBuckets.size(), equalTo(interval));
                throw e;
                                .interval(interval)
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(percentilesBucketValue, notNullValue());
        valueCounts = new long[numValueBuckets];
            }
import java.util.Iterator;
    }
            .addAggregation(
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))
                    throw e;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        for (int i = 0; i < interval; ++i) {
            assertThat(termsBucket, notNullValue());
            percentilesBucketValue.percentile(2.0);
        SearchResponse response = client().prepareSearch("idx")
        }
        for (Percentile percentile : percentiles) {
        Terms terms = response.getAggregations().get("terms");
            values[i] = bucket.getDocCount();
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    }
                Histogram.Bucket bucket = buckets.get(j);
 * specific language governing permissions and limitations
    public PercentilesBucketIT(Settings staticSettings) {
        assertThat(terms.getName(), equalTo("terms"));
                Histogram.Bucket bucket = buckets.get(j);
            .addAggregation(
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
        try {
                terms("terms").field("tag")
                            histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
    public void testNestedWithDecimal() throws Exception {
        assertThat(termsBuckets.size(), equalTo(interval));
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))
        Terms terms = response.getAggregations().get("terms");
        assertThat(buckets.size(), equalTo(interval));
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            Terms.Bucket termsBucket = termsBuckets.get(i);
            Terms.Bucket termsBucket = termsBuckets.get(i);
        }
                    .subAggregation(percentilesBucket("percentile_histo_bucket", "histo>_count").setPercents(PERCENTS))
            double[] values = new double[numValueBuckets];
            } else if (!(cause instanceof IllegalArgumentException)) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
        for (int i = 0; i < 2; i++) {
        ensureSearchable();
            double expected = values[(int) ((p / 100) * values.length)];
                    .subAggregation(
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            for (int j = 0; j < numValueBuckets; ++j) {
            .get();
                .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(badPercents))
            .get();
        assertThat(terms, notNullValue());
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        assertPercentileBucket(values, percentilesBucketValue);
import static org.hamcrest.core.IsNull.notNullValue;
            assertThat(percentilesBucketValue, notNullValue());
                client().prepareIndex("empty_bucket_idx")
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
            assertThat(percentile.getValue(), equalTo(values[index]));
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            assertThat(histo.getName(), equalTo("histo"));
                terms("terms").field("tag")
                    .subAggregation(
                Histogram.Bucket bucket = buckets.get(j);
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
                client().prepareIndex("idx")
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                            .field("tag", "tag" + (i % interval))
                    throw e;
        double[] values = new double[interval];
            assertTrue(it.hasNext());
            assertThat(termsBucket, notNullValue());
            assertThat(termsBucket, notNullValue());
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        for (int i = 0; i < interval; ++i) {
            }
        assertSearchResponse(response);
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");
        assertSearchResponse(response);
 */
            assertThat(percentilesBucketValue.getName(), equalTo("percentile_histo_bucket"));
        assertThat(terms.getName(), equalTo("terms"));
        } catch (Exception e) {
            builders.add(
    }
            assertThat(bucket, notNullValue());
        for (int i = 0; i < interval; ++i) {
            // All good
        assertPercentileBucket(values, percentiles);
            }
        } catch (Exception e) {
                Sum sum = bucket.getAggregations().get("sum");
            for (int j = 0; j < numValueBuckets; ++j) {
                        )
        assertThat(percentilesBucketValue.getName(), equalTo("percentile_terms_bucket"));
            assertThat(histo, notNullValue());
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
    public void testWrongPercents() throws Exception {
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            .addAggregation(percentilesBucket("percentile_terms_bucket", "terms>percentile_histo_bucket.50").setPercents(PERCENTS))
            .get();
        assertThat(terms, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(percentilesBucketValue, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        minRandomValue = 0;
                    .subAggregation(
        Terms terms = response.getAggregations().get("terms");
        Iterator<Percentile> it = percentiles.iterator();
 * not use this file except in compliance with the License.
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
 * under the License.
            values[i] = sum.value();
        Arrays.sort(values);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        SearchResponse response = client().prepareSearch("idx")
        }
        double[] badPercents = { -1.0, 110.0 };
                Throwable rootCause = spee.getRootCause();
        }
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertSearchResponse(response);
        assertThat(terms.getName(), equalTo("terms"));
            new Object[] {
        }
                    )
@OpenSearchIntegTestCase.SuiteScopeTestCase
    }
    private void assertPercentileBucket(double[] percents, double[] values, PercentilesBucket percentiles) {
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum"))
        SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < interval; ++i) {
                            .extendedBounds(minRandomValue, maxRandomValue)
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
                Histogram.Bucket bucket = buckets.get(j);
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
            )
            Terms.Bucket termsBucket = termsBuckets.get(i);
 *
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                            .interval(interval)
                    values.add(sum.value());
            )
            assertThat(termsBucket, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));
        }
    }
 * compatible open source license.
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        Arrays.sort(values);
                terms("terms").field("tag")
 * this file be licensed under the Apache-2.0 license or a
/*
        SearchResponse response = client().prepareSearch("idx")
        assertThat(percentilesBucketValue, notNullValue());
                    .setSource(
            .get();
            assertThat(histo.getName(), equalTo("histo"));
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                terms("terms").field("tag")
        for (int i = 0; i < numValueBuckets; ++i) {
            .get();
        assertThat(terms.getName(), equalTo("terms"));
            if (cause == null) {
            assertThat(percentilesBucketValue, notNullValue());
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
    public void testDocCountopLevel() throws Exception {
            assertThat(bucket, notNullValue());
            .addAggregation(
                assertThat(sum, notNullValue());
        assertThat(terms.getName(), equalTo("terms"));
            )
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                .addAggregation(
            assertThat(termsBucket, notNullValue());
                    )
            Arrays.sort(innerValues);
        assertThat(terms, notNullValue());
            .addAggregation(
            .get();
    public void testDocCountAsSubAgg() throws Exception {
        assertThat(buckets.size(), equalTo(interval));
            assertThat(histo.getName(), equalTo("histo"));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        }
            }
    static int interval;
        Terms terms = response.getAggregations().get("terms");
        for (int i = 0; i < interval; ++i) {
 * the Apache License, Version 2.0 (the "License"); you may
                throw e;
        SearchResponse response = client().prepareSearch("idx")
            for (int j = 0; j < numValueBuckets; ++j) {
                    .order(BucketOrder.key(true))
        numDocs = randomIntBetween(6, 20);
import java.util.Collections;
            assertThat(histo, notNullValue());
    static int numDocs;
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentile_histo_bucket");
            values[i] = sum.value();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
/*
                        .order(BucketOrder.key(true))
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            values[i] = percentilesBucketValue.percentile(50.0);
import org.opensearch.search.aggregations.bucket.terms.Terms;
import static org.hamcrest.Matchers.equalTo;
        assertThat(percentilesBucketValue, notNullValue());
                    .order(BucketOrder.key(true))
 * software distributed under the License is distributed on an
        super(staticSettings);
            assertThat(histo.getName(), equalTo("histo"));
        Histogram histo = response.getAggregations().get("histo");
import java.util.List;
            .get();
public class PercentilesBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            Terms.Bucket termsBucket = termsBuckets.get(i);
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        assertSearchResponse(response);
import java.util.ArrayList;
import org.opensearch.action.search.SearchPhaseExecutionException;
                }
        assertThat(terms, notNullValue());
        assertThat(terms, notNullValue());
                        percentilesBucket("percentiles_bucket", "histo>sum").gapPolicy(BucketHelpers.GapPolicy.INSERT_ZEROS)
        indexRandom(true, builders);
    public void testNoBuckets() throws Exception {
                    .subAggregation(
    private void assertPercentileBucket(double[] values, PercentilesBucket percentiles) {
    public void testMetricTopLevelDefaultPercents() throws Exception {
        double[] values = new double[interval];
        for (int i = 0; i < interval; ++i) {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            Terms.Bucket bucket = buckets.get(i);
            client().prepareSearch("idx")
    private static final double[] PERCENTS = { 0.0, 1.0, 25.0, 50.0, 75.0, 99.0, 100.0 };
            double[] innerValues = new double[numValueBuckets];
            values[i] = percentilesBucketValue.percentile(99.9);
    }
                .get();
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            assertThat(bucket, notNullValue());
    }
                Histogram.Bucket bucket = buckets.get(j);
import org.opensearch.ExceptionsHelper;
            .addAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(PERCENTS))
            builders.add(
        assertThat(terms, notNullValue());
 * Unless required by applicable law or agreed to in writing,
        assertThat(percentilesBucketValue, notNullValue());
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            fail("Illegal percent's were provided but no exception was thrown.");
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentile_terms_bucket");
import static org.hamcrest.Matchers.greaterThan;
 * You may obtain a copy of the License at
            .addAggregation(
            .get();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        assertSearchResponse(response);
            for (int j = 0; j < numValueBuckets; ++j) {
            double[] innerValues = new double[numValueBuckets];
        assertThat(percentilesBucketValue.getName(), equalTo("percentile_terms_bucket"));
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
                        jsonBuilder().startObject()
            )
        assertThat(buckets.size(), equalTo(0));
        assertThat(percentilesBucketValue, notNullValue());
        interval = randomIntBetween(2, 5);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                throw e;
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
                    .setId("" + i)
            Histogram histo = termsBucket.getAggregations().get("histo");
                innerValues[j] = bucket.getDocCount();
                assertThat(bucket, notNullValue());
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
    static int numValueBuckets;
 *
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
import org.opensearch.search.aggregations.metrics.Percentile;
        assertThat(terms.getName(), equalTo("terms"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertPercentileBucket(innerValues, percentilesBucketValue);
        assertThat(terms, notNullValue());
                }
 * GitHub history for details.
            Sum sum = bucket.getAggregations().get("sum");
import org.opensearch.action.search.SearchResponse;
    }
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
    static int minRandomValue;
            new Object[] {
            Histogram histo = termsBucket.getAggregations().get("histo");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    )
        assertThat(terms.getName(), equalTo("terms"));
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
 * ownership. Elasticsearch licenses this file to you under
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        Terms terms = response.getAggregations().get("terms");
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
        );
 * license agreements. See the NOTICE file distributed with
            valueCounts[bucket]++;
                    .includeExclude(new IncludeExclude(null, "tag.*"))
        assertThat(terms.getName(), equalTo("terms"));
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
        }
}
            assertThat(histo, notNullValue());
        try {
            assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
                    terms("terms").field("tag")
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                }
                terms("terms").field("tag")
        assertThat(terms.getName(), equalTo("terms"));
    public void testBadPercents_asSubAgg() throws Exception {
            } else if (!(cause instanceof IllegalArgumentException)) {
            Arrays.sort(innerValues);
        Terms terms = response.getAggregations().get("terms");
        }
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
        for (int i = 0; i < interval; ++i) {
        assertThat(percentilesBucketValue, notNullValue());
        assertThat(terms, notNullValue());
        }
            Arrays.sort(values);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            }
            )
            Collections.sort(values);
                assertThat(bucket, notNullValue());
                innerValues[j] = bucket.getDocCount();
                if (!(rootCause instanceof IllegalArgumentException)) {
/*
                    .subAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(PERCENTS))
                values[j] = sum.value();
                Throwable rootCause = spee.getRootCause();
            assertThat(histo, notNullValue());
                            .setPercents(PERCENTS)
            assertThat(percentilesBucketValue, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 */
                    .order(BucketOrder.key(true))
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse response = client().prepareSearch("idx")
        double[] values = new double[termsBuckets.size()];
        } catch (IllegalArgumentException exception) {
                    )
            client().prepareSearch("idx")
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
import java.util.Collection;
        for (int i = 0; i < numDocs; i++) {
            Arrays.sort(values);
            );
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
        assertThat(termsBuckets.size(), equalTo(interval));
        double[] values = new double[numValueBuckets];
            assertThat(histo.getName(), equalTo("histo"));
            assertThat(percentilesBucketValue.percentile(p), equalTo(expected));
                assertThat(bucket, notNullValue());
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    static long[] valueCounts;
        Arrays.sort(values);
            assertEquals(percents[i], it.next().getPercent(), 0d);
        double[] percent = { 99.9 };
            Throwable cause = ExceptionsHelper.unwrapCause(e);
            Throwable cause = ExceptionsHelper.unwrapCause(e);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * KIND, either express or implied.  See the License for the
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            )
import org.opensearch.test.OpenSearchIntegTestCase;
            Sum sum = bucket.getAggregations().get("sum");
    static int maxRandomValue;
 *
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
            }
            .addAggregation(
                    .includeExclude(new IncludeExclude(null, "tag.*"))
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
            double[] values = new double[numValueBuckets];
                if (!(rootCause instanceof IllegalArgumentException)) {
                        .subAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(badPercents))
                            .extendedBounds(minRandomValue, maxRandomValue)
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.percentilesBucket;
            .addAggregation(percentilesBucket("percentile_terms_bucket", "terms>percentile_histo_bucket[99.9]").setPercents(percent))
            Terms.Bucket termsBucket = termsBuckets.get(i);
    public void setupSuiteScopeCluster() throws Exception {
        }
            Histogram.Bucket bucket = buckets.get(i);
                if (bucket.getDocCount() != 0) {
        assertThat(histo.getName(), equalTo("histo"));
    @ParametersFactory
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        SearchResponse response = client().prepareSearch("idx")
    public void testMetricAsSubAgg() throws Exception {
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");
        assertSearchResponse(response);
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(buckets.size(), equalTo(numValueBuckets));
                    .subAggregation(percentilesBucket("percentiles_bucket", "histo>sum").setPercents(PERCENTS))
            for (int j = 0; j < numValueBuckets; ++j) {
        double[] values = new double[termsBuckets.size()];
        Arrays.sort(values);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    }
        SearchResponse response = client().prepareSearch("idx")
        try {
                    Sum sum = bucket.getAggregations().get("sum");
            assertThat(percentilesBucketValue, notNullValue());
        assertThat(histo, notNullValue());
            } else if (cause instanceof SearchPhaseExecutionException) {
    }
import org.opensearch.search.aggregations.BucketOrder;
                .get();
