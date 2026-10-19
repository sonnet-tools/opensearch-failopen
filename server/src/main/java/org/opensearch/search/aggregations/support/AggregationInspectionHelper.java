import org.opensearch.search.aggregations.metrics.InternalExtendedStats;
    }
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;
    }
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.opensearch.search.aggregations.metrics.InternalScriptedMetric;
        return StreamSupport.stream(agg.spliterator(), false).allMatch(p -> Double.isNaN(p.getValue())) == false;
import org.opensearch.search.aggregations.bucket.histogram.InternalVariableWidthHistogram;
        return agg.getValue() > 0;
    public static boolean hasValue(UnmappedSampler agg) {
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
    public static <B extends InternalRange.Bucket, R extends InternalRange<B, R>> boolean hasValue(InternalRange<B, R> agg) {
/**
 */
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
    }
    public static boolean hasValue(InternalGlobal agg) {
/*
import org.opensearch.search.aggregations.metrics.InternalMax;
    }
        return MetricInspectionHelper.hasValue(agg);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return MetricInspectionHelper.hasValue(agg);
 * Provides a set of static helpers to determine if a particular type of InternalAggregation "has a value"
    }
 *
    }
 * It is not entirely accurate for all aggs, since some do not expose or track the needed state
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
        InternalSignificantTerms<A, B> agg
        return agg.getDocCount() > 0;
        return false;
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
    public static boolean hasValue(InternalStats agg) {
        return (Double.isInfinite(agg.getValue()) || Double.isNaN(agg.getValue())) == false;
    public static <A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>> boolean hasValue(
        return agg.getDocCount() > 0;
 *
    }
        return agg.getValue() != Double.NEGATIVE_INFINITY;
    public static boolean hasValue(InternalPercentilesBucket agg) {
        return MetricInspectionHelper.hasValue(agg);
    public static boolean hasValue(InternalMedianAbsoluteDeviation agg) {
 * Licensed to Elasticsearch under one or more contributor
    public static boolean hasValue(InternalTopHits agg) {
 * You may obtain a copy of the License at
    }
    }
    public static boolean hasValue(InternalSampler agg) {
public class AggregationInspectionHelper {
    }
import org.opensearch.search.aggregations.metrics.InternalMin;
    }
    public static boolean hasValue(InternalMin agg) {
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    public static boolean hasValue(InternalComposite agg) {
 * GitHub history for details.
    public static boolean hasValue(UnmappedSignificantTerms agg) {
    }
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
 * The OpenSearch Contributors require contributions made to
 * different internal bookkeeping to determine if it is empty or not (NaN, +/-Inf, 0.0, etc).
    }
 *
 */
import org.opensearch.search.aggregations.pipeline.InternalPercentilesBucket;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
package org.opensearch.search.aggregations.support;
    }
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
    ) {
import org.opensearch.search.aggregations.metrics.InternalWeightedAvg;
    public static boolean hasValue(InternalReverseNested agg) {
        return agg.getValue() != 0.0;
    public static boolean hasValue(InternalFilter agg) {
    }
import org.opensearch.search.aggregations.metrics.InternalSum;
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;
/*
import org.opensearch.search.aggregations.metrics.InternalGeoCentroid;
    public static boolean hasValue(InternalValueCount agg) {
 * or not.  This can be difficult to determine from an external perspective because each agg uses
        return MetricInspectionHelper.hasValue(agg);
        return MetricInspectionHelper.hasValue(agg);
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
import org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviation;
    }
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
    }
    public static boolean hasValue(InternalHDRPercentileRanks agg) {
    public static boolean hasValue(InternalGeoCentroid agg) {
import org.opensearch.search.aggregations.bucket.terms.UnmappedSignificantTerms;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.missing.InternalMissing;
    public static boolean hasValue(InternalNested agg) {
    public static boolean hasValue(InternalMissing agg) {
 * this file be licensed under the Apache-2.0 license or a
    }
    public static boolean hasValue(InternalMax agg) {
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    public static boolean hasValue(InternalTDigestPercentileRanks agg) {
        return agg.getValue() != Double.POSITIVE_INFINITY;
    public static boolean hasValue(InternalVariableWidthHistogram agg) {
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.metrics.InternalStats;
 * @opensearch.internal
        return agg.getDocCount() > 0;
    public static boolean hasValue(InternalAdjacencyMatrix agg) {
        return agg.getDocCount() > 0;
/*
 * <p>
import org.opensearch.search.aggregations.bucket.nested.InternalReverseNested;
    }
    public static boolean hasValue(InternalExtendedStats agg) {
    public static boolean hasValue(InternalHDRPercentiles agg) {
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
        return agg.getCount() > 0;
 * This set of helpers aim to ease that task by codifying what "empty" is for each agg.
        // This is a coarse approximation, since some aggs use positive/negative infinity or NaN
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
    }
    public static boolean hasValue(InternalHistogram agg) {
    }
import java.util.stream.StreamSupport;
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
 * specific language governing permissions and limitations
 *
    }
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
        return MetricInspectionHelper.hasValue(agg);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    }
    public static boolean hasValue(InternalSum agg) {
    public static boolean hasValue(InternalFilters agg) {
    public static boolean hasValue(InternalBucketMetricValue agg) {
        return false;
    }
    }
        // TODO this could be incorrect... e.g. +1 + -1
        return MetricInspectionHelper.hasValue(agg);
 * compatible open source license.
    }
    }
 */
        return agg.getDocCount() > 0;
    }
import org.opensearch.search.aggregations.bucket.sampler.UnmappedSampler;
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    }
        return MetricInspectionHelper.hasValue(agg);
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
        return agg.centroid() != null && agg.count() > 0;
 * (e.g. sum doesn't record count, so it's not clear if the sum is 0.0 because it is empty
    }
 * generated the value.
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
import org.opensearch.search.aggregations.metrics.InternalTopHits;
        return agg.getCount() > 0;
 */
    public static <A extends InternalTerms<A, B>, B extends InternalTerms.Bucket<B>> boolean hasValue(InternalTerms<A, B> agg) {
    public static boolean hasValue(InternalTDigestPercentiles agg) {
 * license agreements. See the NOTICE file distributed with
        return false;
    public static boolean hasValue(InternalDateHistogram agg) {
 * <p>
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
    public static boolean hasValue(InternalScriptedMetric agg) {
    }
import org.opensearch.search.aggregations.metrics.InternalAvg;
 * by these helpers since most share InternalSimpleValue and it's not clear which pipeline
    }
import org.opensearch.search.aggregations.metrics.InternalCardinality;
        return Double.isInfinite(agg.value()) == false;
    }
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
import org.opensearch.search.aggregations.bucket.terms.InternalSignificantTerms;
    public static boolean hasValue(InternalAutoDateHistogram agg) {
 * or because of summing to zero).  Pipeline aggs in particular are not well supported
        return MetricInspectionHelper.hasValue(agg);
    public static boolean hasValue(InternalAvg agg) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.range.InternalRange;
        return MetricInspectionHelper.hasValue(agg);
    }
 * not use this file except in compliance with the License.
}
 * under the License.
        return agg.getDocCount() > 0;
    }
    public static boolean hasValue(InternalSimpleValue agg) {
    }
 * SPDX-License-Identifier: Apache-2.0
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.metrics.MetricInspectionHelper;
import org.opensearch.search.aggregations.bucket.adjacency.InternalAdjacencyMatrix;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public static boolean hasValue(InternalWeightedAvg agg) {
import org.opensearch.search.aggregations.metrics.InternalValueCount;
    public static boolean hasValue(UnmappedTerms agg) {
    public static boolean hasValue(InternalCardinality agg) {
