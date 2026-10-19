        return agg.getState().size() > 0;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static boolean hasValue(InternalScriptedMetric agg) {
        // Could check for null too, but a script might return null on purpose...
    }
/*
        return agg.getCount() > 0;
 * the Apache License, Version 2.0 (the "License"); you may
 * helpers for some aggs that have package-private getters.  AggregationInspectionHelper delegates to these
/*
 * KIND, either express or implied.  See the License for the
    }
 * license agreements. See the NOTICE file distributed with
 */  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
public class MetricInspectionHelper {
    public static boolean hasValue(InternalCardinality agg) {
    public static boolean hasValue(InternalMedianAbsoluteDeviation agg) {
 * under the License.  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        return agg.getCounts() != null;
    }
 * ownership. Elasticsearch licenses this file to you under  
    }  
    }  
    public static boolean hasValue(InternalWeightedAvg agg) {
 * SPDX-License-Identifier: Apache-2.0
 *
 * helpers.  
        return agg.getState().getTotalCount() > 0;  
    public static boolean hasValue(InternalTDigestPercentiles agg) {  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
        return true;  
        return agg.aggregationsList().size() > 0;
        return agg.getValuesSketch().size() > 0;
    public static boolean hasValue(InternalAvg agg) {  
    public static boolean hasValue(InternalHDRPercentileRanks agg) {
    public static boolean hasValue(InternalHDRPercentiles agg) {  
 * specific language governing permissions and limitations
    public static boolean hasValue(InternalDerivative agg) {
import org.opensearch.search.aggregations.pipeline.InternalDerivative;  
 * not use this file except in compliance with the License.
    }
 * software distributed under the License is distributed on an
            && Double.isNaN(agg.getTopDocs().maxScore)) == false;
}
    }
        return (agg.getSum() == 0.0 && agg.getWeight() == 0L) == false;
 *
 */
 * The OpenSearch Contributors require contributions made to  
            && Double.isNaN(agg.getHits().getMaxScore())  
 * Counterpart to {@link org.opensearch.search.aggregations.support.AggregationInspectionHelper}, providing  
 * compatible open source license.
        return (agg.getHits().getTotalHits().value() == 0
    public static boolean hasValue(InternalTDigestPercentileRanks agg) {
    public static boolean hasValue(InternalTopHits agg) {
 * helpers when needed, and consumers should prefer to use AggregationInspectionHelper instead of these
    }  
        // TODO better way to know if the scripted metric received documents?  
/**
        return agg.getState().getTotalCount() > 0;
 *
 * GitHub history for details.
 *  
    }
package org.opensearch.search.aggregations.metrics;
 */  
        return agg.getState().size() > 0;  
