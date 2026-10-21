        return new AdjacencyMatrixAggregationBuilder(name, filters);
 * Licensed to Elasticsearch under one or more contributor
    }
    /**
    /**
     * Create a new {@link SignificantTerms} aggregation with the given name.
    /**
        return new AvgAggregationBuilder(name);
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.search.aggregations.bucket.filter.Filters;
        return new CardinalityAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.terms.SignificantTextAggregationBuilder;
    public static MinAggregationBuilder min(String name) {
 */
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
     */
 *
        return new SignificantTextAggregationBuilder(name, fieldName);
        return new GeoCentroidAggregationBuilder(name);
    /**
     * Create a new {@link Terms} aggregation with the given name.
        return new PercentilesAggregationBuilder(name);
    public static AdjacencyMatrixAggregationBuilder adjacencyMatrix(String name, Map<String, QueryBuilder> filters) {
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;
    public static PercentileRanksAggregationBuilder percentileRanks(String name, double[] values) {
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
     */
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
}
    public static MultiTermsAggregationBuilder multiTerms(String name) {
    public static FiltersAggregationBuilder filters(String name, QueryBuilder... filters) {
public class AggregationBuilders {
        return new MaxAggregationBuilder(name);
package org.opensearch.search.aggregations;
     * Create a new {@link ReverseNested} aggregation with the given name.
 */
    public static ScriptedMetricAggregationBuilder scriptedMetric(String name) {
    public static AdjacencyMatrixAggregationBuilder adjacencyMatrix(String name, String separator, Map<String, QueryBuilder> filters) {
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
    }
    /**
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        return new TermsAggregationBuilder(name);
     */
    /**
    /**
        return new FiltersAggregationBuilder(name, filters);
     * Create a new {@link Max} aggregation with the given name.
     * Create a new {@link SignificantTextAggregationBuilder} aggregation with the given name and text field name
     */
     * Create a new {@link DateRangeAggregationBuilder} aggregation with the
    }
    /**
     * Create a new {@link Range} aggregation with the given name.
import org.opensearch.search.aggregations.bucket.terms.Terms;
    }
    public static NestedAggregationBuilder nested(String name, String path) {
    public static FiltersAggregationBuilder filters(String name, KeyedFilter... filters) {
        return new HistogramAggregationBuilder(name);
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.aggregations.metrics.PercentilesAggregationBuilder;
    }
    /**
    }
import org.opensearch.search.aggregations.bucket.missing.Missing;
import org.opensearch.search.aggregations.metrics.GeoCentroid;
    public static SamplerAggregationBuilder sampler(String name) {
     */
     * Create a new {@link DateHistogramAggregationBuilder} aggregation with the given
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
    /**
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
     * Create a new {@link PercentileRanks} aggregation with the given name.
    public static RangeAggregationBuilder range(String name) {
     * given name.
import org.opensearch.search.aggregations.metrics.Cardinality;
    /**
     */
     * Create a new {@link MedianAbsoluteDeviation} aggregation with the given name
        return new ScriptedMetricAggregationBuilder(name);
import org.opensearch.search.aggregations.metrics.TopHits;
    /**
    }
        return new DateHistogramAggregationBuilder(name);
/*
    /**
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.metrics.Min;
    }
     */
    public static TermsAggregationBuilder terms(String name) {
     */
 * @opensearch.internal
    }
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
     */
    /**
    }
     */
    }
    }
    /**
import org.opensearch.search.aggregations.metrics.Avg;
     * Create a new {@link Sampler} aggregation with the given name.
import org.opensearch.search.aggregations.bucket.nested.ReverseNested;
import org.opensearch.search.aggregations.bucket.range.Range;
/*
    public static CompositeAggregationBuilder composite(String name, List<CompositeValuesSourceBuilder<?>> sources) {
    private AggregationBuilders() {}
    public static StatsAggregationBuilder stats(String name) {
     * Create a new {@link Histogram} aggregation with the given name.
     * Create a new {@link ScriptedMetric} aggregation with the given name.
    /**
    }
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
    /**
    }
import org.opensearch.search.aggregations.metrics.ExtendedStats;
    }
    public static HistogramAggregationBuilder histogram(String name) {
    }
    }
        return new WeightedAvgAggregationBuilder(name);
     * Create a new {@link MultiTermsAggregationBuilder} aggregation with the given name.
     */
    public static MaxAggregationBuilder max(String name) {
 * GitHub history for details.
 */
    public static WeightedAvgAggregationBuilder weightedAvg(String name) {
    /**
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviation;
 *
     */
    /**
     */
     * Create a new {@link AdjacencyMatrix} aggregation with the given name and separator
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
    public static PercentilesAggregationBuilder percentiles(String name) {
     * Create a new {@link Avg} aggregation with the given name.
        return new ValueCountAggregationBuilder(name);
import org.opensearch.search.aggregations.metrics.ScriptedMetric;
     */
 * SPDX-License-Identifier: Apache-2.0
    public static SumAggregationBuilder sum(String name) {
 */
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.metrics.PercentileRanks;
        return new SumAggregationBuilder(name);
        return new AdjacencyMatrixAggregationBuilder(name, separator, filters);
    public static DateHistogramAggregationBuilder dateHistogram(String name) {
        return new GlobalAggregationBuilder(name);
    }
     */
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
        return new ExtendedStatsAggregationBuilder(name);
     * Create a new {@link Avg} aggregation with the given name.
import org.opensearch.search.aggregations.bucket.sampler.Sampler;
     */
        return new SamplerAggregationBuilder(name);
        return new TopHitsAggregationBuilder(name);
        return new MissingAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
import org.opensearch.search.aggregations.bucket.global.Global;
    }
     * Create a new {@link CompositeAggregationBuilder} aggregation with the given name.
     * Create a new {@link TopHits} aggregation with the given name.
    }
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
     * given name.
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
     */
     */
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
     * Create a new {@link Cardinality} aggregation with the given name.
    /**
     * name.
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
    }
     */
     * Create a new {@link Filter} aggregation with the given name.
    /**
     */
        return new MedianAbsoluteDeviationAggregationBuilder(name);
    public static ExtendedStatsAggregationBuilder extendedStats(String name) {
    /**
     * Create a new {@link Stats} aggregation with the given name.
     */
    public static SignificantTermsAggregationBuilder significantTerms(String name) {
    public static MissingAggregationBuilder missing(String name) {
    /**
import org.opensearch.search.aggregations.metrics.Percentiles;
    }
    public static TopHitsAggregationBuilder topHits(String name) {
     * Create a new {@link Filters} aggregation with the given name.
 * KIND, either express or implied.  See the License for the
    public static FilterAggregationBuilder filter(String name, QueryBuilder filter) {
     * Create a new {@link Sampler} aggregation with the given name.
        return new MinAggregationBuilder(name);
     * Create a new {@link ExtendedStats} aggregation with the given name.
     * Create a new {@link AdjacencyMatrix} aggregation with the given name.
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
        return new MultiTermsAggregationBuilder(name);
    public static SignificantTextAggregationBuilder significantText(String name, String fieldName) {
     * Create a new {@link Min} aggregation with the given name.
    }
     * Create a new {@link Global} aggregation with the given name.
    }
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
    public static DateRangeAggregationBuilder dateRange(String name) {
    }
    /**
    /**
 *
     * Create a new {@link Sum} aggregation with the given name.
    /**
     */
    /**
    /**
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
    /**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.nested.Nested;
    }
     */
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
 * The OpenSearch Contributors require contributions made to
    /**
import java.util.Map;
/**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.common.geo.GeoDistance;
    public static CardinalityAggregationBuilder cardinality(String name) {
 * not use this file except in compliance with the License.
    /**
    }
/*
    }
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
 * under the License.
import org.opensearch.search.aggregations.metrics.ValueCount;
    }
        return new DiversifiedAggregationBuilder(name);
        return new ReverseNestedAggregationBuilder(name);
     */
    /**
     */
     * Create a new {@link GeoCentroid} aggregation with the given name.
     */
import org.opensearch.search.aggregations.metrics.PercentileRanksAggregationBuilder;
        return new IpRangeAggregationBuilder(name);
     */
    /**
import org.opensearch.search.aggregations.metrics.Max;
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
        return new FiltersAggregationBuilder(name, filters);
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
    }
 * compatible open source license.
    public static GlobalAggregationBuilder global(String name) {
     */
 * You may obtain a copy of the License at
     * Create a new {@link Missing} aggregation with the given name.
     */
     */
        return new FilterAggregationBuilder(name, filter);
    }
     * Create a new {@link Filters} aggregation with the given name.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static ValueCountAggregationBuilder count(String name) {
import org.opensearch.search.aggregations.metrics.Sum;
     */
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
    public static MedianAbsoluteDeviationAggregationBuilder medianAbsoluteDeviation(String name) {
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
    }
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
        return new PercentileRanksAggregationBuilder(name, values);
        return new RangeAggregationBuilder(name);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
    public static GeoDistanceAggregationBuilder geoDistance(String name, GeoPoint origin) {
        return new GeoDistanceAggregationBuilder(name, origin);
     */
 * Utility class to create aggregations.
    }
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
        return new SignificantTermsAggregationBuilder(name);
        return new StatsAggregationBuilder(name);
    public static IpRangeAggregationBuilder ipRange(String name) {
     * Create a new {@link Nested} aggregation with the given name.
    }
    }
import java.util.List;
    /**
 * software distributed under the License is distributed on an
    public static GeoCentroidAggregationBuilder geoCentroid(String name) {
        return new CompositeAggregationBuilder(name, sources);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
     * Create a new {@link IpRangeAggregationBuilder} aggregation with the
     * Create a new {@link Percentiles} aggregation with the given name.
    public static AvgAggregationBuilder avg(String name) {
    public static ReverseNestedAggregationBuilder reverseNested(String name) {
    /**
 *
    /**
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
        return new NestedAggregationBuilder(name, path);
     * Create a new {@link ValueCount} aggregation with the given name.
import org.opensearch.search.aggregations.metrics.Stats;
        return new DateRangeAggregationBuilder(name);
    }
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
     */
     * Create a new {@link GeoDistance} aggregation with the given name.
    public static DiversifiedAggregationBuilder diversifiedSampler(String name) {
import org.opensearch.search.aggregations.bucket.filter.Filter;
     */
     */
     */
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
