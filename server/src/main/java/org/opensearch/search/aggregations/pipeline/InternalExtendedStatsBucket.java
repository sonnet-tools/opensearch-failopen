 *  
        long count,  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
        double min,
import java.io.IOException;  
        DocValueFormat formatter,  
        Map<String, Object> metadata
        double max,  
 * license agreements. See the NOTICE file distributed with
    }
 * software distributed under the License is distributed on an
        throw new UnsupportedOperationException("Not supported");
 * You may obtain a copy of the License at  
public class InternalExtendedStatsBucket extends InternalExtendedStats implements ExtendedStatsBucket {  
/*
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import java.util.Map;
}
        double sumOfSqrs,
        return ExtendedStatsBucketPipelineAggregationBuilder.NAME;  
import org.opensearch.search.aggregations.metrics.InternalExtendedStats;
 */  
/*  
 * under the License.  
    public String getWriteableName() {
    @Override  
    @Override
 * not use this file except in compliance with the License.
        super(name, count, sum, min, max, sumOfSqrs, sigma, formatter, metadata);  
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
package org.opensearch.search.aggregations.pipeline;
    InternalExtendedStatsBucket(
    }
        double sum,
/*  
 *
import org.opensearch.search.DocValueFormat;
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 */  
 * Implementation of extended stats pipeline
    }
 * Licensed to Elasticsearch under one or more contributor  
        String name,
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
     */
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under  
    ) {
 *
 */
 * this file be licensed under the Apache-2.0 license or a
        double sigma,
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregation;  
 * The OpenSearch Contributors require contributions made to  
 *  
    public InternalExtendedStatsBucket(StreamInput in) throws IOException {  
/**
import org.opensearch.core.common.io.stream.StreamInput;
    public InternalExtendedStats reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
