 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * @opensearch.internal
            return buildEmptyAggregation();  
        } else {
    }  
 * KIND, either express or implied.  See the License for the
import java.util.Map;
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {  
    HDRPercentilesAggregator(  
        Map<String, Object> metadata  
        }  
 * GitHub history for details.
    ) throws IOException {
/*
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        boolean keyed,
}
import org.opensearch.search.DocValueFormat;  
import org.HdrHistogram.DoubleHistogram;  
 */
/*  
        DocValueFormat formatter,
        if (state == null) {
        if (state == null) {  
        DoubleHistogram state;  
class HDRPercentilesAggregator extends AbstractHDRPercentilesAggregator {
 */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public double metric(String name, long bucketOrd) {
 *
        DoubleHistogram state = getState(bucketOrd);
        int numberOfSignificantValueDigits,  
 */
 * compatible open source license.
package org.opensearch.search.aggregations.metrics;
import java.io.IOException;  
            return new InternalHDRPercentiles(name, keys, state, keyed, format, metadata());
import org.opensearch.search.aggregations.InternalAggregation;
    @Override
 *
 *
 * Modifications Copyright OpenSearch Contributors. See  
        return new InternalHDRPercentiles(name, keys, state, keyed, format, metadata());  
    @Override  
        double[] percents,
        String name,
        state.setAutoResize(true);
 * Aggregate all docs into a single HDR percentile  
import org.opensearch.search.aggregations.Aggregator;
 *  
        DoubleHistogram state = getState(owningBucketOrdinal);
 * not use this file except in compliance with the License.
import org.opensearch.search.internal.SearchContext;
 * The OpenSearch Contributors require contributions made to  
/**
        }
import org.opensearch.search.aggregations.support.ValuesSource;  
        Aggregator parent,
        state = new DoubleHistogram(numberOfSignificantValueDigits);
    public InternalAggregation buildEmptyAggregation() {
            return state.getValueAtPercentile(Double.parseDouble(name));  
        super(name, valuesSource, context, parent, percents, numberOfSignificantValueDigits, keyed, formatter, metadata);
 * specific language governing permissions and limitations
 * under the License.  
        ValuesSource valuesSource,
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        } else {
 * this file be licensed under the Apache-2.0 license or a
            return Double.NaN;
 */  
    }
        SearchContext context,  
    @Override
