 * software distributed under the License is distributed on an
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    @Override
        double sum,
        return StatsBucketPipelineAggregationBuilder.NAME;
        Map<String, Object> metadata
import org.opensearch.search.DocValueFormat;
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
public class InternalStatsBucket extends InternalStats implements StatsBucket {  
 *
    public InternalStatsBucket(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/**
package org.opensearch.search.aggregations.pipeline;
        double min,
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 */  
import org.opensearch.search.aggregations.InternalAggregation;  
    public InternalStats reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
 * Implementation of stats pipeline
import org.opensearch.search.aggregations.metrics.InternalStats;
    @Override
    public InternalStatsBucket(
/*  
 * KIND, either express or implied.  See the License for the
/*
        throw new UnsupportedOperationException("Not supported");  
    public String getWriteableName() {  
        double max,  
 * specific language governing permissions and limitations
import java.io.IOException;  
     */  
 * not use this file except in compliance with the License.
    ) {  
    }
    }
 */  
}
 *
        long count,  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
        String name,
        super(name, count, sum, min, max, formatter, metadata);
import java.util.List;
 */
 *  
        DocValueFormat formatter,
 * The OpenSearch Contributors require contributions made to  
     * Read from a stream.
 * this work for additional information regarding copyright
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
