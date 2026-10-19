        DocValueFormat format,
 *
        super(name, valuesSource, context, parent, percents, numberOfSignificantValueDigits, keyed, format, metadata);
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    public InternalAggregation buildEmptyAggregation() {
    @Override
import org.opensearch.search.internal.SearchContext;
    @Override  
 *  
 * ownership. Elasticsearch licenses this file to you under  
            return InternalHDRPercentileRanks.percentileRank(state, Double.valueOf(name));
    }  
    public double metric(String name, long bucketOrd) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        state.setAutoResize(true);
 * GitHub history for details.
 */
        if (state == null) {
        }  
    }
 * compatible open source license.
    }
        Aggregator parent,
 * software distributed under the License is distributed on an
/*
    ) throws IOException {
 * Aggregate all docs into an HDR percentile ranks values  
        DoubleHistogram state = getState(bucketOrd);
 * this work for additional information regarding copyright
        SearchContext context,  
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {  
        }  
/*  
        double[] percents,
 * under the License.  
 *
/*
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
        state = new DoubleHistogram(numberOfSignificantValueDigits);  
import org.opensearch.search.aggregations.Aggregator;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
}
            return new InternalHDRPercentileRanks(name, keys, state, keyed, format, metadata());
        ValuesSource valuesSource,
    }  
        DoubleHistogram state;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.support.ValuesSource;  
    @Override
        DoubleHistogram state = getState(owningBucketOrdinal);
        return new InternalHDRPercentileRanks(name, keys, state, keyed, format, metadata());
        } else {
import java.util.Map;
 * @opensearch.internal
 */  
 *
    HDRPercentileRanksAggregator(  
package org.opensearch.search.aggregations.metrics;
        if (state == null) {
class HDRPercentileRanksAggregator extends AbstractHDRPercentilesAggregator {
 */
        Map<String, Object> metadata  
import org.opensearch.search.aggregations.InternalAggregation;
            return buildEmptyAggregation();  
        String name,
        boolean keyed,
        int numberOfSignificantValueDigits,  
 * SPDX-License-Identifier: Apache-2.0
            return Double.NaN;  
import org.opensearch.search.DocValueFormat;  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
import org.HdrHistogram.DoubleHistogram;  
/**
