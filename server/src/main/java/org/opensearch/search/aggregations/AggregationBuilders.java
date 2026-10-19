     * Create a new {@link Global} aggregation with the given name.
        return new StatsAggregationBuilder(name);
        return new AdjacencyMatrixAggregationBuilder(name, separator, filters);
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
     * Create a new {@link Sampler} aggregation with the given name.  
 * Utility class to create aggregations.
     */
    }
 *  
    public static CardinalityAggregationBuilder cardinality(String name) {
    public static ExtendedStatsAggregationBuilder extendedStats(String name) {
    /**
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
    }
     * Create a new {@link Sum} aggregation with the given name.
        return new TopHitsAggregationBuilder(name);
    public static AdjacencyMatrixAggregationBuilder adjacencyMatrix(String name, Map<String, QueryBuilder> filters) {  
    /**  
    /**
 *
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
    public static DateHistogramAggregationBuilder dateHistogram(String name) {
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;  
     * Create a new {@link ValueCount} aggregation with the given name.
    }  
 * license agreements. See the NOTICE file distributed with
    /**
     */
    /**
 * @opensearch.internal
     */
     */
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
     * Create a new {@link TopHits} aggregation with the given name.
     */
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
    }  
     */
 */
     */
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
    }
    public static TermsAggregationBuilder terms(String name) {
    /**
        return new SumAggregationBuilder(name);
    /**
    public static ValueCountAggregationBuilder count(String name) {
    }  
    }  
     */
        return new MultiTermsAggregationBuilder(name);
     * Create a new {@link Filters} aggregation with the given name.  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.metrics.TopHits;
 * GitHub history for details.
    public static StatsAggregationBuilder stats(String name) {
    public static IpRangeAggregationBuilder ipRange(String name) {  
        return new AvgAggregationBuilder(name);  
    /**  
    public static ReverseNestedAggregationBuilder reverseNested(String name) {
    /**  
import org.opensearch.search.aggregations.metrics.Avg;
        return new HistogramAggregationBuilder(name);
        return new FilterAggregationBuilder(name, filter);
    /**
import org.opensearch.search.aggregations.metrics.ValueCount;  
/*
 *
    /**
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        return new RangeAggregationBuilder(name);  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     */
import org.opensearch.search.aggregations.bucket.missing.Missing;
     */  
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;
    }
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;  
    public static SumAggregationBuilder sum(String name) {  
        return new FiltersAggregationBuilder(name, filters);
import org.opensearch.common.geo.GeoDistance;  
    /**
import org.opensearch.search.aggregations.metrics.Max;  
    /**  
 */  
     */
    }
import org.opensearch.search.aggregations.bucket.nested.ReverseNested;  
/*  
    }
        return new ScriptedMetricAggregationBuilder(name);  
     */  
    public static MultiTermsAggregationBuilder multiTerms(String name) {
     */
    }  
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix;  
        return new IpRangeAggregationBuilder(name);
        return new CardinalityAggregationBuilder(name);  
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
    /**
     * Create a new {@link Nested} aggregation with the given name.
    /**
        return new SignificantTextAggregationBuilder(name, fieldName);  
        return new AdjacencyMatrixAggregationBuilder(name, filters);
import org.opensearch.search.aggregations.metrics.PercentilesAggregationBuilder;  
    /**  
    public static GeoCentroidAggregationBuilder geoCentroid(String name) {
     * Create a new {@link DateRangeAggregationBuilder} aggregation with the
    public static NestedAggregationBuilder nested(String name, String path) {  
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;  
    public static TopHitsAggregationBuilder topHits(String name) {  
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
    public static SamplerAggregationBuilder sampler(String name) {
        return new ExtendedStatsAggregationBuilder(name);  
     */  
     */
import org.opensearch.search.aggregations.metrics.PercentileRanksAggregationBuilder;
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
    }  
import org.opensearch.search.aggregations.metrics.Min;
    }  
    }  
     * given name.
     * Create a new {@link AdjacencyMatrix} aggregation with the given name and separator
 * KIND, either express or implied.  See the License for the
    }
     */  
 */
 */
     * Create a new {@link Percentiles} aggregation with the given name.  
    }  
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;  
import java.util.List;
    public static MaxAggregationBuilder max(String name) {
     */
    }
    /**
     * Create a new {@link DateHistogramAggregationBuilder} aggregation with the given
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
    /**
    /**
import org.opensearch.search.aggregations.metrics.ScriptedMetric;
     */  
     * Create a new {@link GeoCentroid} aggregation with the given name.
    public static DateRangeAggregationBuilder dateRange(String name) {
import java.util.Map;
    }  
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;  
    }
     */
        return new MaxAggregationBuilder(name);
        return new GeoDistanceAggregationBuilder(name, origin);  
 * SPDX-License-Identifier: Apache-2.0
    /**
        return new ReverseNestedAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.range.Range;
    public static RangeAggregationBuilder range(String name) {
     * Create a new {@link Avg} aggregation with the given name.  
import org.opensearch.common.geo.GeoPoint;
    public static FilterAggregationBuilder filter(String name, QueryBuilder filter) {  
     * Create a new {@link Terms} aggregation with the given name.
    public static HistogramAggregationBuilder histogram(String name) {  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
        return new NestedAggregationBuilder(name, path);
        return new CompositeAggregationBuilder(name, sources);
     */  
     * Create a new {@link ExtendedStats} aggregation with the given name.  
    /**
    public static WeightedAvgAggregationBuilder weightedAvg(String name) {  
    public static MedianAbsoluteDeviationAggregationBuilder medianAbsoluteDeviation(String name) {
import org.opensearch.search.aggregations.bucket.global.Global;  
     * Create a new {@link Min} aggregation with the given name.  
    /**  
    /**
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    private AggregationBuilders() {}
     */  
     */  
    public static MinAggregationBuilder min(String name) {
    public static FiltersAggregationBuilder filters(String name, QueryBuilder... filters) {
     * Create a new {@link AdjacencyMatrix} aggregation with the given name.
        return new TermsAggregationBuilder(name);
    public static FiltersAggregationBuilder filters(String name, KeyedFilter... filters) {
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviation;
        return new WeightedAvgAggregationBuilder(name);
        return new PercentileRanksAggregationBuilder(name, values);
        return new SamplerAggregationBuilder(name);  
    }
     * name.
    public static AvgAggregationBuilder avg(String name) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
     * Create a new {@link Range} aggregation with the given name.  
     */  
     * given name.
     */
    /**
     */
     * Create a new {@link ReverseNested} aggregation with the given name.
        return new FiltersAggregationBuilder(name, filters);  
    /**
    }
        return new GeoCentroidAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.sampler.Sampler;
     */
    public static ScriptedMetricAggregationBuilder scriptedMetric(String name) {
import org.opensearch.search.aggregations.metrics.Sum;
     */
     * Create a new {@link Filter} aggregation with the given name.
    public static AdjacencyMatrixAggregationBuilder adjacencyMatrix(String name, String separator, Map<String, QueryBuilder> filters) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
    public static PercentilesAggregationBuilder percentiles(String name) {
     * Create a new {@link Missing} aggregation with the given name.  
     * Create a new {@link ScriptedMetric} aggregation with the given name.  
        return new ValueCountAggregationBuilder(name);
    }
    }
import org.opensearch.search.aggregations.metrics.ExtendedStats;
    }
 * under the License.  
    public static SignificantTermsAggregationBuilder significantTerms(String name) {
/**
    }
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
 * this file be licensed under the Apache-2.0 license or a
     * Create a new {@link MultiTermsAggregationBuilder} aggregation with the given name.
        return new SignificantTermsAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
 * specific language governing permissions and limitations
    /**  
    public static GeoDistanceAggregationBuilder geoDistance(String name, GeoPoint origin) {
     */  
import org.opensearch.search.aggregations.metrics.PercentileRanks;  
import org.opensearch.search.aggregations.bucket.filter.Filter;
     * Create a new {@link PercentileRanks} aggregation with the given name.
     */
package org.opensearch.search.aggregations;
    }
     */
     */
public class AggregationBuilders {  
        return new PercentilesAggregationBuilder(name);  
import org.opensearch.index.query.QueryBuilder;
     * Create a new {@link Avg} aggregation with the given name.
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
        return new DateRangeAggregationBuilder(name);
import org.opensearch.search.aggregations.metrics.Percentiles;
    /**  
    public static CompositeAggregationBuilder composite(String name, List<CompositeValuesSourceBuilder<?>> sources) {  
import org.opensearch.search.aggregations.bucket.nested.Nested;
import org.opensearch.search.aggregations.bucket.terms.SignificantTextAggregationBuilder;
    }
    }  
import org.opensearch.search.aggregations.metrics.GeoCentroid;
     * Create a new {@link Max} aggregation with the given name.
}
 *  
     */  
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;  
     */
    public static MissingAggregationBuilder missing(String name) {
     */  
    public static GlobalAggregationBuilder global(String name) {
        return new MinAggregationBuilder(name);  
    public static SignificantTextAggregationBuilder significantText(String name, String fieldName) {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
        return new MissingAggregationBuilder(name);  
     * Create a new {@link MedianAbsoluteDeviation} aggregation with the given name
import org.opensearch.search.aggregations.metrics.Cardinality;  
    /**
    /**  
    }
        return new DiversifiedAggregationBuilder(name);
    }
    }
    /**
     * Create a new {@link Histogram} aggregation with the given name.
    /**
     * Create a new {@link CompositeAggregationBuilder} aggregation with the given name.
    /**
    /**  
    }  
    }
     * Create a new {@link GeoDistance} aggregation with the given name.  
import org.opensearch.search.aggregations.metrics.Stats;  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
     * Create a new {@link Stats} aggregation with the given name.
    /**
     * Create a new {@link Sampler} aggregation with the given name.
    /**  
     * Create a new {@link IpRangeAggregationBuilder} aggregation with the  
     */  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        return new MedianAbsoluteDeviationAggregationBuilder(name);
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
    }
    public static PercentileRanksAggregationBuilder percentileRanks(String name, double[] values) {  
        return new GlobalAggregationBuilder(name);
        return new DateHistogramAggregationBuilder(name);
/*
     * Create a new {@link SignificantTextAggregationBuilder} aggregation with the given name and text field name  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
 * software distributed under the License is distributed on an
    public static DiversifiedAggregationBuilder diversifiedSampler(String name) {  
import org.opensearch.search.aggregations.bucket.filter.Filters;  
     * Create a new {@link Cardinality} aggregation with the given name.  
     */  
 * Licensed to Elasticsearch under one or more contributor  
     * Create a new {@link SignificantTerms} aggregation with the given name.
     */
     * Create a new {@link Filters} aggregation with the given name.
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;  
    /**
