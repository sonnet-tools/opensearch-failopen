            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
    }
                Histogram.Bucket bucket = buckets.get(j);  
                if (!(rootCause instanceof IllegalArgumentException)) {  
            assertThat(percentilesBucketValue.getName(), equalTo("percentile_histo_bucket"));  
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
    public void testDocCountAsSubAgg() throws Exception {
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
    static int numValueBuckets;  
        }
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    terms("terms").field("tag")
import java.util.Arrays;  
        for (Double p : PERCENTS) {  
            Histogram histo = termsBucket.getAggregations().get("histo");  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentile_terms_bucket");
        assertThat(terms.getName(), equalTo("terms"));
            }
            .addAggregation(  
        for (int i = 0; i < numDocs; i++) {
                assertThat(bucket, notNullValue());
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .get();
    }  
                .addAggregation(
    }
            assertThat(bucket, notNullValue());  
import org.opensearch.test.OpenSearchIntegTestCase;
            }
                            .extendedBounds(minRandomValue, maxRandomValue)  
            builders.add(
            fail("Illegal percent's were provided but no exception was thrown.");
            .addAggregation(
            assertThat(bucket.getDocCount(), greaterThan(0L));
                            .interval(interval)
            assertThat(percentilesBucketValue, notNullValue());
                    .order(BucketOrder.key(true))
            for (int j = 0; j < numValueBuckets; ++j) {
 * software distributed under the License is distributed on an
                terms("terms").field("tag")
        } catch (Exception e) {  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        Arrays.sort(values);  
        interval = randomIntBetween(2, 5);
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
                    .subAggregation(percentilesBucket("percentiles_bucket", "histo>sum").setPercents(PERCENTS))  
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentile_terms_bucket");
import org.opensearch.action.index.IndexRequestBuilder;
import static org.hamcrest.Matchers.greaterThan;  
                    )
                    throw e;
            );  
            assertTrue(it.hasNext());
    public PercentilesBucketIT(Settings staticSettings) {  
        assertThat(termsBuckets.size(), equalTo(interval));
 *
 */
                client().prepareIndex("idx")
                if (bucket.getDocCount() != 0) {  
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
 * not use this file except in compliance with the License.
        for (int i = 0; i < interval; ++i) {
                assertThat(bucket, notNullValue());
            Terms.Bucket bucket = buckets.get(i);
                                .extendedBounds(minRandomValue, maxRandomValue)
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
            .get();
        assertThat(buckets.size(), equalTo(interval));
        Terms terms = response.getAggregations().get("terms");  
            assertThat(sum, notNullValue());
        assertSearchResponse(response);
            assertPercentileBucket(PERCENTS, values, percentilesBucketValue);  
        assertThat(percentilesBucketValue, notNullValue());  
            .addAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(PERCENTS))
            assertThat(termsBucket, notNullValue());
            Collections.sort(values);
            double expected = values[(int) ((p / 100) * values.length)];  
    @Override
                innerValues[j] = bucket.getDocCount();  
    public static Collection<Object[]> parameters() {
                    .subAggregation(  
        for (Double p : percent) {
 *  
        );
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
                    assertThat(sum, notNullValue());
        Iterator<Percentile> it = percentiles.iterator();
            Histogram histo = termsBucket.getAggregations().get("histo");
        Terms terms = response.getAggregations().get("terms");  
        assertPercentileBucket(values, percentilesBucketValue);
    private void assertPercentileBucket(double[] percents, double[] values, PercentilesBucket percentiles) {
            values[i] = bucket.getDocCount();  
        }
            assertThat(histo.getName(), equalTo("histo"));
        }  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));  
                    )
                .get();  
                    )  
            )  
import java.util.ArrayList;
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
        for (int i = 0; i < percents.length; ++i) {  
                    .setSource(  
        SearchResponse response = client().prepareSearch("idx")  
                        jsonBuilder().startObject()
 * ownership. Elasticsearch licenses this file to you under  
            assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
        assertThat(terms.getName(), equalTo("terms"));
import java.util.Iterator;  
import java.util.Collection;
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);  
        Histogram histo = response.getAggregations().get("histo");  
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            assertThat(termsBucket, notNullValue());  
            assertThat(sum, notNullValue());
            for (int j = 0; j < numValueBuckets; ++j) {
                    .subAggregation(  
        Arrays.sort(values);
    }
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
        assertSearchResponse(response);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            for (int j = 0; j < numValueBuckets; ++j) {
                    .includeExclude(new IncludeExclude(null, "tag.*"))
            assertThat(percentilesBucketValue, notNullValue());  
        assertThat(percentilesBucketValue, notNullValue());  
            assertThat(histo, notNullValue());  
import org.opensearch.search.aggregations.metrics.Percentile;  
            .get();
        }
            )
                .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(badPercents))
        assertThat(buckets.size(), equalTo(interval));
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 */  
    public void setupSuiteScopeCluster() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            assertThat(bucket, notNullValue());  
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms, notNullValue());
            );
    public void testMetricAsSubAgg() throws Exception {
            assertThat(termsBucket, notNullValue());
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
        for (int i = 0; i < interval; ++i) {
                    )
        for (int i = 0; i < interval; ++i) {  
    }  
        assertSearchResponse(response);
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    }  
        SearchResponse response = client().prepareSearch("idx")  
        Arrays.sort(values);
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
    }
                if (!(rootCause instanceof IllegalArgumentException)) {
        }  
                Histogram.Bucket bucket = buckets.get(j);  
            }
        Terms terms = response.getAggregations().get("terms");  
            // All good
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();  
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.percentilesBucket;
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();  
        }  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
        assertThat(percentilesBucketValue, notNullValue());
        }
            .get();
            assertThat(histo, notNullValue());  
    public void testNoBuckets() throws Exception {  
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
                assertThat(bucket, notNullValue());
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
            .get();
        SearchResponse response = client().prepareSearch("idx")
        Terms terms = response.getAggregations().get("terms");
            .addAggregation(
        }  
        assertThat(percentilesBucketValue.getName(), equalTo("percentile_terms_bucket"));
    }  
        valueCounts = new long[numValueBuckets];
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        double[] values = new double[numValueBuckets];  
            .addAggregation(percentilesBucket("percentile_terms_bucket", "terms>percentile_histo_bucket.50").setPercents(PERCENTS))
        assertThat(percentilesBucketValue, notNullValue());
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        assertThat(terms, notNullValue());
        }
            assertPercentileBucket(innerValues, percentilesBucketValue);
                assertThat(bucket, notNullValue());  
        for (int i = 0; i < interval; ++i) {  
                    )
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
                }  
            assertEquals(percentiles.percentile(percentile.getPercent()), percentile.getValue(), 0d);
        double[] badPercents = { -1.0, 110.0 };  
/*
            }
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
 * license agreements. See the NOTICE file distributed with
            assertThat(termsBucket, notNullValue());
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
                    .subAggregation(
                }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            )
            fail("2.0 was not a valid percent, should have thrown exception");
 *
            Histogram histo = termsBucket.getAggregations().get("histo");
            assertThat(bucket, notNullValue());  
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        double[] values = new double[termsBuckets.size()];
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
 * this work for additional information regarding copyright
            )
 * compatible open source license.
            List<? extends Histogram.Bucket> buckets = histo.getBuckets();
                values[j] = bucket.getDocCount();
            int index = (int) Math.round((percentile.getPercent() / 100.0) * (values.length - 1));
    }  
                    .subAggregation(percentilesBucket("percentile_histo_bucket", "histo>_count").setPercents(percent))
            )
        assertThat(termsBuckets.size(), equalTo(interval));
            Terms.Bucket termsBucket = termsBuckets.get(i);
            } else if (cause instanceof SearchPhaseExecutionException) {  
                Histogram.Bucket bucket = buckets.get(j);
                .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
            double[] values = new double[numValueBuckets];
        for (Percentile percentile : percentiles) {  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                )
        } catch (Exception e) {
import static org.hamcrest.core.IsNull.notNullValue;
                    .subAggregation(
                Throwable rootCause = spee.getRootCause();  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        numDocs = randomIntBetween(6, 20);  
            assertThat(termsBucket, notNullValue());
 * GitHub history for details.
        for (int i = 0; i < numValueBuckets; ++i) {
        assertThat(percentilesBucketValue.getName(), equalTo("percentile_terms_bucket"));  
        assertThat(terms.getName(), equalTo("terms"));  
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
        assertThat(terms, notNullValue());
        }  
        }  
import org.opensearch.ExceptionsHelper;  
            double[] values = new double[numValueBuckets];
        assertThat(terms.getName(), equalTo("terms"));
        double[] values = new double[termsBuckets.size()];
            assertThat(bucket.getDocCount(), greaterThan(0L));
            .addAggregation(percentilesBucket("percentile_terms_bucket", "terms>percentile_histo_bucket[99.9]").setPercents(percent))  
    public void testNestedWithDecimal() throws Exception {
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
            assertThat(percentile.getValue(), equalTo(values[index]));  
            Histogram.Bucket bucket = buckets.get(i);
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");  
        SearchResponse response = client().prepareSearch("idx")
                terms("terms").field("tag")
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(terms.getName(), equalTo("terms"));
            Sum sum = bucket.getAggregations().get("sum");  
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentile_histo_bucket");
    }
            .addAggregation(
                assertThat(sum, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        assertSearchResponse(response);
                    .order(BucketOrder.key(true))  
            }  
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");  
import org.opensearch.common.settings.Settings;
        }  
            Terms.Bucket termsBucket = termsBuckets.get(i);
            values[i] = sum.value();
        assertSearchResponse(response);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
            Sum sum = bucket.getAggregations().get("sum");  
        SearchResponse response = client().prepareSearch("idx")
    public void testNested() throws Exception {
        assertThat(terms, notNullValue());  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                        .subAggregation(
            values[i] = percentilesBucketValue.percentile(99.9);  
                terms("terms").field("tag")
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
        assertThat(percentilesBucketValue, notNullValue());  
                    throw e;
            Terms.Bucket termsBucket = termsBuckets.get(i);
import org.opensearch.search.aggregations.metrics.Sum;
            }
                terms("terms").field("tag")  
                    )  
    }  
        assertSearchResponse(response);
}
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
                innerValues[j] = bucket.getDocCount();
        assertThat(buckets.size(), equalTo(0));  
                        )
                .get();
        for (int i = 0; i < 2; i++) {  
 * this file be licensed under the Apache-2.0 license or a
            values[i] = percentilesBucketValue.percentile(50.0);
        assertThat(termsBuckets.size(), equalTo(interval));
            .addAggregation(
    static int minRandomValue;
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    .order(BucketOrder.key(true))
                        percentilesBucket("percentiles_bucket", "histo>sum").gapPolicy(BucketHelpers.GapPolicy.INSERT_ZEROS)
        assertThat(terms, notNullValue());
    static int interval;  
        PercentilesBucket percentilesBucketValue = response.getAggregations().get("percentiles_bucket");
    }
 * The OpenSearch Contributors require contributions made to  
        assertThat(terms.getName(), equalTo("terms"));
        ensureSearchable();
            new Object[] {
        assertThat(termsBuckets.size(), equalTo(interval));  
package org.opensearch.search.aggregations.pipeline;
        double[] badPercents = { -1.0, 110.0 };  
        }
            .addAggregation(  
            new Object[] {  
        maxRandomValue = 20;
    private static final double[] PERCENTS = { 0.0, 1.0, 25.0, 50.0, 75.0, 99.0, 100.0 };
                throw e;  
    public void testMetricTopLevel() throws Exception {
    static int numDocs;
        Terms terms = response.getAggregations().get("terms");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
    public void testBadPercents() throws Exception {
                    .subAggregation(percentilesBucket("percentile_histo_bucket", "histo>_count").setPercents(PERCENTS))  
        }
                    )  
                            .setPercents(PERCENTS)
            }
            assertEquals(percents[i], it.next().getPercent(), 0d);
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));  
        try {
                        .subAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(badPercents))  
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
            assertThat(percentilesBucketValue.percentile(p), equalTo(expected));
        minRandomValue = 0;  
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentiles_bucket");
                                .interval(interval)  
            )
            )
            assertThat(histo.getName(), equalTo("histo"));
    }
import java.util.List;
            assertThat(histo, notNullValue());
        assertSearchResponse(response);
    @ParametersFactory
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();
            if (cause == null) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                            .extendedBounds(minRandomValue, maxRandomValue)  
        assertThat(percentilesBucketValue, notNullValue());
/*  
        SearchResponse response = client().prepareSearch("idx")  
        SearchResponse response = client().prepareSearch("idx")
            PercentilesBucket percentilesBucketValue = termsBucket.getAggregations().get("percentile_histo_bucket");
    }
                    .subAggregation(  
            assertThat(percentilesBucketValue.getName(), equalTo("percentiles_bucket"));
        assertThat(terms.getName(), equalTo("terms"));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        for (int i = 0; i < interval; ++i) {  
/*  
            assertThat(percentilesBucketValue.percentile(p), equalTo(Double.NaN));
            Histogram histo = termsBucket.getAggregations().get("histo");
    public void testDocCountopLevel() throws Exception {
        } catch (IllegalArgumentException exception) {  
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))
        assertSearchResponse(response);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            } else if (!(cause instanceof IllegalArgumentException)) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            )  
                    .subAggregation(percentilesBucket("percentiles_bucket", "histo>_count").setPercents(PERCENTS))
                values[j] = sum.value();  
        assertThat(histo, notNullValue());
            client().prepareSearch("idx")  
            assertThat(histo.getName(), equalTo("histo"));  
        assertSearchResponse(response);
    }
        }  
            assertThat(histo.getName(), equalTo("histo"));
    public void testBadPercents_asSubAgg() throws Exception {
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
                Histogram.Bucket bucket = buckets.get(j);  
        }
            .get();  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertThat(histo.getName(), equalTo("histo"));
            double[] innerValues = new double[numValueBuckets];  
        for (int i = 0; i < interval; ++i) {
        assertFalse(it.hasNext());
    static long[] valueCounts;
        assertPercentileBucket(values, percentiles);
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))
        Arrays.sort(values);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
    public void testMetricTopLevelDefaultPercents() throws Exception {
        super(staticSettings);
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        double[] percent = { 99.9 };
            client().prepareSearch("idx")  
        assertThat(terms, notNullValue());
            assertThat(percentilesBucketValue, notNullValue());
            new Object[] {
        try {
            .get();
            values[i] = sum.value();
                    .includeExclude(new IncludeExclude(null, "tag.*"))  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
import org.opensearch.search.aggregations.BucketOrder;
                Histogram.Bucket bucket = buckets.get(j);
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());  
            builders.add(
        SearchResponse response = client().prepareSearch("idx")
            Arrays.sort(values);  
            Terms.Bucket termsBucket = termsBuckets.get(i);
            Arrays.sort(innerValues);  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(histo.getName(), equalTo("histo"));
            Arrays.sort(innerValues);
        assertThat(terms, notNullValue());
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
                    .order(BucketOrder.key(true))
                            .endObject()
            assertPercentileBucket(PERCENTS, innerValues, percentilesBucketValue);
                throw e;
        indexRandom(true, builders);
            for (int j = 0; j < numValueBuckets; ++j) {  
            assertPercentileBucket(PERCENTS, values.stream().mapToDouble(Double::doubleValue).toArray(), percentilesBucketValue);  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        Terms terms = response.getAggregations().get("terms");  
 * SPDX-License-Identifier: Apache-2.0
            fail("Illegal percent's were provided but no exception was thrown.");
    }
            assertThat(histo, notNullValue());  
                    Sum sum = bucket.getAggregations().get("sum");
            double[] innerValues = new double[numValueBuckets];
                        .order(BucketOrder.key(true))  
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum").setPercents(PERCENTS))  
                    .order(BucketOrder.key(true))  
            assertThat(percentilesBucketValue, notNullValue());  
            Throwable cause = ExceptionsHelper.unwrapCause(e);
            .addAggregation(percentilesBucket("percentiles_bucket", "terms>sum"))
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))  
        Arrays.sort(values);
        for (int i = 0; i < interval; ++i) {
        assertThat(terms.getName(), equalTo("terms"));  
            percentilesBucketValue.percentile(2.0);
                    .setId("" + i)  
                    .subAggregation(  
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
        assertThat(terms, notNullValue());  
            Throwable cause = ExceptionsHelper.unwrapCause(e);  
        assertThat(termsBuckets.size(), equalTo(interval));
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        return Arrays.asList(  
                terms("terms").field("tag")
                throw e;
        SearchResponse response = client().prepareSearch("idx")
        try {  
            } else if (!(cause instanceof IllegalArgumentException)) {  
                    values.add(sum.value());  
                            .field("tag", "tag" + (i % interval))  
            assertThat(histo, notNullValue());
 * You may obtain a copy of the License at  
            .addAggregation(  
            } else if (cause instanceof SearchPhaseExecutionException) {
                Sum sum = bucket.getAggregations().get("sum");  
            assertThat(percentilesBucketValue.getName(), equalTo("percentile_histo_bucket"));
        createIndex("idx_unmapped");
            List<Double> values = new ArrayList<>(numValueBuckets);
    static int maxRandomValue;
        assertPercentileBucket(PERCENTS, values, percentilesBucketValue);
            valueCounts[bucket]++;
            Arrays.sort(values);
            .get();
 */  
import java.util.Collections;
        double[] values = new double[interval];  
                terms("terms").field("tag")
    public void testWrongPercents() throws Exception {
                Throwable rootCause = spee.getRootCause();
            .get();  
            Histogram histo = termsBucket.getAggregations().get("histo");
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
 * Licensed to Elasticsearch under one or more contributor  
        Terms terms = response.getAggregations().get("terms");
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))  
 * under the License.  
                            .interval(interval)
            .addAggregation(
                }
            if (cause == null) {
 * Modifications Copyright OpenSearch Contributors. See
            Terms.Bucket bucket = buckets.get(i);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * KIND, either express or implied.  See the License for the
                assertThat(bucket, notNullValue());
                throw e;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import static org.hamcrest.Matchers.equalTo;
                terms("terms").field("tag")
        assertThat(terms, notNullValue());
 * specific language governing permissions and limitations
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
        Terms terms = response.getAggregations().get("terms");
public class PercentilesBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                client().prepareIndex("empty_bucket_idx")
        assertThat(buckets.size(), equalTo(0));
    private void assertPercentileBucket(double[] values, PercentilesBucket percentiles) {
import org.opensearch.action.search.SearchPhaseExecutionException;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        assertThat(percentilesBucketValue, notNullValue());
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        Terms terms = response.getAggregations().get("terms");  
import org.opensearch.action.search.SearchResponse;  
                            histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(percentilesBucketValue, notNullValue());
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(buckets.size(), equalTo(numValueBuckets));
        double[] values = new double[interval];  
