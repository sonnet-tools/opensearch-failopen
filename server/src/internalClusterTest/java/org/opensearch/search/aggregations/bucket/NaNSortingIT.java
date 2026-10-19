import org.opensearch.search.aggregations.BucketOrder;  
        assertCorrectlySorted(histo, asc, agg);  
 */  
            builder();
                factory.field("numeric_field");  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(histo, notNullValue());
                factory.field("numeric_field");
        }  
            }
 */  
            public ExtendedStatsAggregationBuilder builder() {
/*
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
/*  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 *
            if (randomBoolean()) {  
        testTerms("double_value");
                ? extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, ?>>
            }
 * GitHub history for details.
        public String name;
            )
                return name + ".std_deviation";
                terms("terms").field(fieldName)
        SubAggregation agg = randomFrom(SubAggregation.values());  
 * specific language governing permissions and limitations
    }
                ExtendedStatsAggregationBuilder factory = extendedStats(name);  
            final long value = randomInt(5);
 * Licensed to Elasticsearch under one or more contributor  
            previousValue = value;
    @ParametersFactory  
        final boolean asc = randomBoolean();
import java.util.Collection;
            public double getValue(Aggregation aggregation) {
                return factory;
            public AvgAggregationBuilder builder() {
import org.opensearch.common.util.Comparators;
        STD_DEVIATION("std_deviation") {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().prepareIndex("idx").setSource(source.endObject()).get();  
                ExtendedStatsAggregationBuilder factory = extendedStats(name);  
 * under the License.  
                    .order(BucketOrder.aggregation(agg.sortKey(), asc))
                AvgAggregationBuilder factory = avg(name);
    public void setupSuiteScopeCluster() throws Exception {  
            public String sortKey() {  
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                    .order(BucketOrder.aggregation(agg.sortKey(), asc))  
                return name + ".variance";
        SubAggregation(String name) {
            @Override
            @Override
    }
            @Override
    public static Collection<Object[]> parameters() {
            )
        VARIANCE("variance") {  
        for (int i = 0; i < numDocs; ++i) {  
    }
            @Override
 * compatible open source license.
    private void assertCorrectlySorted(Histogram histo, boolean asc, SubAggregation agg) {  
            }
            public double getValue(Aggregation aggregation) {
            @Override
        }
            @Override  
                return factory;
import java.util.Arrays;  
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("string_value", "type=keyword").get());
 * KIND, either express or implied.  See the License for the
 */
        final boolean asc = randomBoolean();  
import org.opensearch.common.settings.Settings;
            .addAggregation(  
    public void testLongHistogram() {
import org.opensearch.search.aggregations.Aggregation;
        }  
            ValuesSourceAggregationBuilder.LeafOnly<
            assertTrue(Comparators.compareDiscardNaN(previousValue, value, asc) <= 0);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
 * not use this file except in compliance with the License.
            previousValue = value;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.search.aggregations.metrics.Avg;  
        assertCorrectlySorted(terms, asc, agg);
                source.field("numeric_value", randomDouble());
            return name;
    }  
        AVG("avg") {
 * the Apache License, Version 2.0 (the "License"); you may
            }  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            XContentBuilder source = jsonBuilder().startObject()
        super(staticSettings);  
    private enum SubAggregation {
    public void testStringTerms() {
        public abstract double getValue(Aggregation aggregation);
    public NaNSortingIT(Settings staticSettings) {
        },
        SubAggregation agg = randomFrom(SubAggregation.values());
        }  
        ensureSearchable();
 * ownership. Elasticsearch licenses this file to you under  
                    .subAggregation(agg.builder())  
                histogram("histo").field("long_value")  
        final Histogram histo = response.getAggregations().get("histo");
        testTerms("string_value");
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        public abstract
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSource;
    public void testTerms(String fieldName) {
 *  
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.core.IsNull.notNullValue;
    public void testDoubleTerms() {  
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
        assertThat(terms, notNullValue());
                return ((Avg) aggregation).getValue();  
    }  
            .get();
            @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    public void testLongTerms() {
                    .subAggregation(agg.builder())
            }
            assertTrue(Comparators.compareDiscardNaN(previousValue, value, asc) <= 0);  
    }
        public String sortKey() {
        assertSearchResponse(response);
                return ((ExtendedStats) aggregation).getVariance();  
        for (Terms.Bucket bucket : terms.getBuckets()) {
    }
            Aggregation sub = bucket.getAggregations().get(agg.name);
            public ExtendedStatsAggregationBuilder builder() {
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                .field("double_value", value + 0.05)
            double value = agg.getValue(sub);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        double previousValue = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
import org.opensearch.action.search.SearchResponse;  
            }
        testTerms("long_value");  
            this.name = name;
                return ((ExtendedStats) aggregation).getStdDeviation();  
        indexRandomForMultipleSlices("idx");  
        assertSearchResponse(response);
            @Override
}  
                    .interval(randomIntBetween(1, 2))
        for (Histogram.Bucket bucket : histo.getBuckets()) {  
                ValuesSource.Numeric,  
                .field("string_value", "str_" + value);
        double previousValue = asc ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;  
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        refresh();
            public double getValue(Aggregation aggregation) {
package org.opensearch.search.aggregations.bucket;
import org.opensearch.test.OpenSearchIntegTestCase;  
            .get();  
public class NaNSortingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        },
                factory.field("numeric_field");
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            Aggregation sub = bucket.getAggregations().get(agg.name);
/*  
        }
@OpenSearchIntegTestCase.SuiteScopeTestCase
                return factory;
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.core.xcontent.XContentBuilder;  
        final Terms terms = response.getAggregations().get("terms");  
    private void assertCorrectlySorted(Terms terms, boolean asc, SubAggregation agg) {
                .field("long_value", value)  
            double value = agg.getValue(sub);  
import org.opensearch.search.aggregations.metrics.ExtendedStats;
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;  
    }  
    }
        return Arrays.asList(
        };
            }
            public String sortKey() {  
        final int numDocs = randomIntBetween(2, 10);
    @Override
 * software distributed under the License is distributed on an
 *
        );
