            .addAggregation(
            @Override
import org.opensearch.search.aggregations.support.ValuesSource;
 * the Apache License, Version 2.0 (the "License"); you may
                return factory;
        };
        final boolean asc = randomBoolean();
        assertThat(terms, notNullValue());
import org.opensearch.search.aggregations.BucketOrder;
        return Arrays.asList(
        }
    }
                histogram("histo").field("long_value")
 *
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        double previousValue = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        );
 * compatible open source license.
 * GitHub history for details.
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
            double value = agg.getValue(sub);
 */
            public ExtendedStatsAggregationBuilder builder() {
            XContentBuilder source = jsonBuilder().startObject()
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                    .order(BucketOrder.aggregation(agg.sortKey(), asc))
                    .interval(randomIntBetween(1, 2))
            }
import java.util.Collection;
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertTrue(Comparators.compareDiscardNaN(previousValue, value, asc) <= 0);
 *
                return ((ExtendedStats) aggregation).getVariance();
        testTerms("string_value");
            )
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
import java.util.Arrays;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * KIND, either express or implied.  See the License for the
    private enum SubAggregation {
                ? extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, ?>>
        }
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
 * specific language governing permissions and limitations
 *
            Aggregation sub = bucket.getAggregations().get(agg.name);
                ValuesSource.Numeric,
            }
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                factory.field("numeric_field");
package org.opensearch.search.aggregations.bucket;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SubAggregation agg = randomFrom(SubAggregation.values());
                    .subAggregation(agg.builder())
            @Override
import org.opensearch.common.util.Comparators;
        public abstract
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("string_value", "type=keyword").get());
        }
    }
            public double getValue(Aggregation aggregation) {
            @Override
            assertTrue(Comparators.compareDiscardNaN(previousValue, value, asc) <= 0);
            @Override
            final long value = randomInt(5);
            public double getValue(Aggregation aggregation) {
            }
import org.opensearch.search.aggregations.metrics.Avg;
        double previousValue = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    public void testLongTerms() {
    }
                return name + ".std_deviation";
            Aggregation sub = bucket.getAggregations().get(agg.name);
            .addAggregation(
                return ((ExtendedStats) aggregation).getStdDeviation();
            if (randomBoolean()) {
                ExtendedStatsAggregationBuilder factory = extendedStats(name);
    public void testTerms(String fieldName) {
        public String name;
        final boolean asc = randomBoolean();
    public void testLongHistogram() {
    public static Collection<Object[]> parameters() {
    @Override
            previousValue = value;
            @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchIntegTestCase;
            public AvgAggregationBuilder builder() {
    @ParametersFactory
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .subAggregation(agg.builder())
            previousValue = value;
    public void testStringTerms() {
        AVG("avg") {
            }
        STD_DEVIATION("std_deviation") {
        SubAggregation(String name) {
        final Histogram histo = response.getAggregations().get("histo");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
/*
            public String sortKey() {
        ensureSearchable();
    }
    public void setupSuiteScopeCluster() throws Exception {
    private void assertCorrectlySorted(Histogram histo, boolean asc, SubAggregation agg) {
        testTerms("long_value");
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            builder();
        }
            }
import static org.hamcrest.core.IsNull.notNullValue;
import org.opensearch.common.settings.Settings;
                source.field("numeric_value", randomDouble());
 * Modifications Copyright OpenSearch Contributors. See
        super(staticSettings);
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        assertSearchResponse(response);
        assertThat(histo, notNullValue());
                ExtendedStatsAggregationBuilder factory = extendedStats(name);
    private void assertCorrectlySorted(Terms terms, boolean asc, SubAggregation agg) {
            }
            this.name = name;
/*
 * this work for additional information regarding copyright
            public String sortKey() {
                return factory;
 */
            public ExtendedStatsAggregationBuilder builder() {
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            }
 * You may obtain a copy of the License at
            return name;
 * The OpenSearch Contributors require contributions made to
                .field("double_value", value + 0.05)
                factory.field("numeric_field");
    }
        final Terms terms = response.getAggregations().get("terms");
 */
        for (Terms.Bucket bucket : terms.getBuckets()) {
        testTerms("double_value");
        },
                factory.field("numeric_field");
        assertSearchResponse(response);
        }
}
import org.opensearch.search.aggregations.Aggregation;
/*
        indexRandomForMultipleSlices("idx");
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
    public NaNSortingIT(Settings staticSettings) {
                .field("string_value", "str_" + value);
            client().prepareIndex("idx").setSource(source.endObject()).get();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.search.SearchResponse;
        for (int i = 0; i < numDocs; ++i) {
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
                terms("terms").field(fieldName)
            .get();
            public double getValue(Aggregation aggregation) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        refresh();
                return name + ".variance";
 * this file be licensed under the Apache-2.0 license or a
                return factory;
        public abstract double getValue(Aggregation aggregation);
        SubAggregation agg = randomFrom(SubAggregation.values());
    }
            double value = agg.getValue(sub);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            }
 * Licensed to Elasticsearch under one or more contributor
    public void testDoubleTerms() {
                return ((Avg) aggregation).getValue();
        assertCorrectlySorted(terms, asc, agg);
        SearchResponse response = client().prepareSearch("idx")
                AvgAggregationBuilder factory = avg(name);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
        VARIANCE("variance") {
            @Override
            ValuesSourceAggregationBuilder.LeafOnly<
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * SPDX-License-Identifier: Apache-2.0
        },
        assertCorrectlySorted(histo, asc, agg);
    }
                .field("long_value", value)
        public String sortKey() {
@OpenSearchIntegTestCase.SuiteScopeTestCase
 * not use this file except in compliance with the License.
            .get();
            @Override
            }
import org.opensearch.core.xcontent.XContentBuilder;
                    .order(BucketOrder.aggregation(agg.sortKey(), asc))
import org.opensearch.search.aggregations.metrics.ExtendedStats;
public class NaNSortingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
        final int numDocs = randomIntBetween(2, 10);
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
