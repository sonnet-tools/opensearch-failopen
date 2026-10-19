 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
            return buildEmptyAggregation();
 * Modifications Copyright OpenSearch Contributors. See  
 *  
        return new InternalTDigestPercentiles(name, keys, new TDigestState(compression), keyed, formatter, metadata());
    }
        DocValueFormat formatter,  
 * specific language governing permissions and limitations
/*  
 * compatible open source license.
 *
        SearchContext context,
/**  
        Map<String, Object> metadata
 * software distributed under the License is distributed on an
/*
import org.opensearch.search.aggregations.support.ValuesSource;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;  
    }
        boolean keyed,
        ValuesSource valuesSource,  
 * Aggregate all docs into a single TDigest Percentile
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
    }  
package org.opensearch.search.aggregations.metrics;
            return new InternalTDigestPercentiles(name, keys, state, keyed, formatter, metadata());  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.internal.SearchContext;
    public double metric(String name, long bucketOrd) {
 * KIND, either express or implied.  See the License for the
        } else {
 * this file be licensed under the Apache-2.0 license or a
        TDigestState state = getState(bucketOrd);  
        } else {  
            return state.quantile(Double.parseDouble(name) / 100);
    ) throws IOException {
        Aggregator parent,
    @Override
    public InternalAggregation buildEmptyAggregation() {  
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
 * this work for additional information regarding copyright
        if (state == null) {  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        TDigestState state = getState(owningBucketOrdinal);
        if (state == null) {
 * the Apache License, Version 2.0 (the "License"); you may
            return Double.NaN;
 */
        }
 * @opensearch.internal  
 * GitHub history for details.
        double compression,
    @Override
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.InternalAggregation;
    @Override  
 *
    TDigestPercentilesAggregator(
 */  
        }
        String name,
        double[] percents,  
 */
        super(name, valuesSource, context, parent, percents, compression, keyed, formatter, metadata);  
    }
}  
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.DocValueFormat;  
 */
class TDigestPercentilesAggregator extends AbstractTDigestPercentilesAggregator {
 * You may obtain a copy of the License at  
