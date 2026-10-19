        return MetricInspectionHelper.hasValue(agg);  
        return MetricInspectionHelper.hasValue(agg);  
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    public static boolean hasValue(InternalTDigestPercentileRanks agg) {  
    public static boolean hasValue(InternalComposite agg) {
    }  
    }  
        return agg.getCount() > 0;  
    }
import org.opensearch.search.aggregations.metrics.InternalMax;
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
public class AggregationInspectionHelper {
    }
/*
 * Provides a set of static helpers to determine if a particular type of InternalAggregation "has a value"
 */  
import org.opensearch.search.aggregations.metrics.InternalSum;  
 * not use this file except in compliance with the License.
    }
    }
import org.opensearch.search.aggregations.bucket.range.InternalRange;  
    }
/*
    }  
    }  
 * under the License.  
    public static boolean hasValue(InternalScriptedMetric agg) {
    public static boolean hasValue(InternalMax agg) {
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);  
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
    }
    public static boolean hasValue(InternalFilters agg) {
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    }
        return MetricInspectionHelper.hasValue(agg);
    }
 * compatible open source license.
    ) {
    public static boolean hasValue(InternalMedianAbsoluteDeviation agg) {
    }
        return agg.getValue() != 0.0;
        // TODO this could be incorrect... e.g. +1 + -1
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.metrics.MetricInspectionHelper;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
 *
        return Double.isInfinite(agg.value()) == false;
        return MetricInspectionHelper.hasValue(agg);
        return agg.getDocCount() > 0;
        return agg.getValue() != Double.NEGATIVE_INFINITY;
    public static boolean hasValue(InternalTopHits agg) {
    public static boolean hasValue(InternalSimpleValue agg) {
        // This is a coarse approximation, since some aggs use positive/negative infinity or NaN  
 * Unless required by applicable law or agreed to in writing,
 * (e.g. sum doesn't record count, so it's not clear if the sum is 0.0 because it is empty  
    }  
import org.opensearch.search.aggregations.pipeline.InternalPercentilesBucket;
import org.opensearch.search.aggregations.bucket.sampler.UnmappedSampler;
        return StreamSupport.stream(agg.spliterator(), false).allMatch(p -> Double.isNaN(p.getValue())) == false;  
 * or not.  This can be difficult to determine from an external perspective because each agg uses  
        InternalSignificantTerms<A, B> agg  
 * @opensearch.internal
    public static boolean hasValue(UnmappedTerms agg) {  
import org.opensearch.search.aggregations.metrics.InternalStats;
import org.opensearch.search.aggregations.metrics.InternalScriptedMetric;
        return agg.getDocCount() > 0;  
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
    public static boolean hasValue(InternalExtendedStats agg) {  
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;  
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);  
        return false;
    }  
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;  
    public static boolean hasValue(InternalHistogram agg) {
import org.opensearch.search.aggregations.bucket.terms.UnmappedSignificantTerms;
    public static <B extends InternalRange.Bucket, R extends InternalRange<B, R>> boolean hasValue(InternalRange<B, R> agg) {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.metrics.InternalValueCount;
    }  
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;
        return false;  
 * The OpenSearch Contributors require contributions made to  
    public static boolean hasValue(InternalValueCount agg) {  
import org.opensearch.search.aggregations.bucket.nested.InternalReverseNested;
    public static boolean hasValue(InternalSum agg) {  
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
import org.opensearch.search.aggregations.bucket.histogram.InternalVariableWidthHistogram;
    public static boolean hasValue(InternalFilter agg) {
 *
 * software distributed under the License is distributed on an
        return MetricInspectionHelper.hasValue(agg);  
    public static boolean hasValue(InternalGeoCentroid agg) {
import org.opensearch.search.aggregations.metrics.InternalGeoCentroid;
    }  
    public static boolean hasValue(InternalStats agg) {
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
 * <p>
        return (Double.isInfinite(agg.getValue()) || Double.isNaN(agg.getValue())) == false;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.metrics.InternalTopHits;  
        return agg.getDocCount() > 0;
    }  
        return agg.getDocCount() > 0;  
package org.opensearch.search.aggregations.support;
import org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviation;
    }
    public static boolean hasValue(InternalCardinality agg) {
    }  
 * KIND, either express or implied.  See the License for the
 * This set of helpers aim to ease that task by codifying what "empty" is for each agg.  
    public static boolean hasValue(InternalBucketMetricValue agg) {
    public static boolean hasValue(UnmappedSignificantTerms agg) {
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
        return MetricInspectionHelper.hasValue(agg);
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * different internal bookkeeping to determine if it is empty or not (NaN, +/-Inf, 0.0, etc).
    public static boolean hasValue(InternalMissing agg) {  
        return agg.getCount() > 0;
import org.opensearch.search.aggregations.metrics.InternalAvg;
 * SPDX-License-Identifier: Apache-2.0
    }
    }
    public static boolean hasValue(UnmappedSampler agg) {
    public static boolean hasValue(InternalAdjacencyMatrix agg) {  
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
    public static boolean hasValue(InternalVariableWidthHistogram agg) {
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
import org.opensearch.search.aggregations.metrics.InternalCardinality;
        return agg.getValue() != Double.POSITIVE_INFINITY;
        return MetricInspectionHelper.hasValue(agg);
import org.opensearch.search.aggregations.bucket.terms.InternalSignificantTerms;  
    }
import org.opensearch.search.aggregations.metrics.InternalExtendedStats;  
 */
    public static boolean hasValue(InternalPercentilesBucket agg) {
    public static boolean hasValue(InternalHDRPercentileRanks agg) {
        return agg.centroid() != null && agg.count() > 0;
        return false;
        return agg.getDocCount() > 0;
 * by these helpers since most share InternalSimpleValue and it's not clear which pipeline
        return agg.getValue() > 0;
        return MetricInspectionHelper.hasValue(agg);  
/*  
import org.opensearch.search.aggregations.metrics.InternalWeightedAvg;
 * It is not entirely accurate for all aggs, since some do not expose or track the needed state
    }  
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;  
    }
 *
    public static boolean hasValue(InternalGlobal agg) {  
    }
    public static boolean hasValue(InternalReverseNested agg) {
 * generated the value.  
    public static boolean hasValue(InternalMin agg) {  
        return MetricInspectionHelper.hasValue(agg);
import org.opensearch.search.aggregations.bucket.adjacency.InternalAdjacencyMatrix;  
    public static boolean hasValue(InternalNested agg) {
    public static boolean hasValue(InternalWeightedAvg agg) {
    }  
    public static <A extends InternalTerms<A, B>, B extends InternalTerms.Bucket<B>> boolean hasValue(InternalTerms<A, B> agg) {
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
    }  
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    }  
 *  
    public static boolean hasValue(InternalAutoDateHistogram agg) {  
import java.util.stream.StreamSupport;
}  
 */  
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
    public static boolean hasValue(InternalTDigestPercentiles agg) {
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);  
        return agg.getDocCount() > 0;
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
    }
    public static boolean hasValue(InternalHDRPercentiles agg) {  
    }
    }
    public static boolean hasValue(InternalDateHistogram agg) {
 * <p>
 */
import org.opensearch.search.aggregations.bucket.missing.InternalMissing;  
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
    }
        return MetricInspectionHelper.hasValue(agg);  
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;  
import org.opensearch.search.aggregations.metrics.InternalMin;  
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;  
/**
 * or because of summing to zero).  Pipeline aggs in particular are not well supported
 * Modifications Copyright OpenSearch Contributors. See  
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
    }
    public static boolean hasValue(InternalAvg agg) {
    public static boolean hasValue(InternalSampler agg) {
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
    public static <A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>> boolean hasValue(
