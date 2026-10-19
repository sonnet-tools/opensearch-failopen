/*
 * KIND, either express or implied.  See the License for the
        SearchContext context,
 * this work for additional information regarding copyright
    }
 */
        Aggregator parent,
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        String name,
        double compression,
/*
 * Licensed to Elasticsearch under one or more contributor  
 */
 * compatible open source license.
        Map<String, Object> metadata
package org.opensearch.search.aggregations.metrics;
 * ownership. Elasticsearch licenses this file to you under  
        ValuesSource valuesSource,  
    @Override  
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
class TDigestPercentileRanksAggregator extends AbstractTDigestPercentilesAggregator {
 * software distributed under the License is distributed on an
        } else {
 *
    }
        }
 * this file be licensed under the Apache-2.0 license or a
/**  
import org.opensearch.search.aggregations.support.ValuesSource;  
        double[] percents,  
        DocValueFormat formatter,  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        TDigestState state = getState(owningBucketOrdinal);
 */  
    TDigestPercentileRanksAggregator(
import java.util.Map;
    }
        return new InternalTDigestPercentileRanks(name, keys, new TDigestState(compression), keyed, formatter, metadata());  
 * GitHub history for details.
import org.opensearch.search.internal.SearchContext;
 * Aggregate all docs into a the TDigenst Percentile Ranks
    public InternalAggregation buildEmptyAggregation() {
        }
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public double metric(String name, long bucketOrd) {
            return Double.NaN;
 *
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        TDigestState state = getState(bucketOrd);
    ) throws IOException {
import org.opensearch.search.aggregations.Aggregator;
    @Override  
        } else {
        if (state == null) {  
import org.opensearch.search.DocValueFormat;  
    }
 * SPDX-License-Identifier: Apache-2.0
        if (state == null) {  
 */
            return InternalTDigestPercentileRanks.percentileRank(state, Double.valueOf(name));  
        boolean keyed,
            return new InternalTDigestPercentileRanks(name, keys, state, keyed, formatter, metadata());  
 * Modifications Copyright OpenSearch Contributors. See  
        super(name, valuesSource, context, parent, percents, compression, keyed, formatter, metadata);  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
            return buildEmptyAggregation();
 * You may obtain a copy of the License at  
}  
 *
 * under the License.  
 *  
import org.opensearch.search.aggregations.InternalAggregation;
