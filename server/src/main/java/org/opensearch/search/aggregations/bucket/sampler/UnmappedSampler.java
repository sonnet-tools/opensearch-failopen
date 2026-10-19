 * Unless required by applicable law or agreed to in writing,
}
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 *  
 * @opensearch.internal
/*
     */  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    }
    /**
    }  
/**
import java.util.List;
 * this work for additional information regarding copyright
public class UnmappedSampler extends InternalSampler {  
 * under the License.  
 * You may obtain a copy of the License at  
    public boolean isMapped() {
    }  
    @Override
import org.opensearch.search.aggregations.InternalAggregation;  
 * license agreements. See the NOTICE file distributed with
    }
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
/*  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        return new UnmappedSampler(name, metadata);  
    }
 * SPDX-License-Identifier: Apache-2.0
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * Implementation of an unmapped sampler
 */
        return false;
    @Override  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        return builder;
    public UnmappedSampler(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 */
        return NAME;
import java.io.IOException;  
import org.opensearch.search.aggregations.Aggregation;
 */
 *
 * GitHub history for details.
     * Read from a stream.
 * KIND, either express or implied.  See the License for the
    }  
    public String getWriteableName() {  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        builder.field(Aggregation.CommonFields.DOC_COUNT.getPreferredName(), 0);
import java.util.Map;
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.search.aggregations.bucket.sampler;
    @Override
        super(name, 0, InternalAggregations.EMPTY, metadata);
    @Override
import org.opensearch.search.aggregations.InternalAggregations;
    UnmappedSampler(String name, Map<String, Object> metadata) {  
 *  
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;  
    public static final String NAME = "unmapped_sampler";
