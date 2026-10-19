        Map<String, Object> metadata
/**
        super(name, bucketsPaths, gapPolicy, formatter, metadata);
 */
 *  
 * GitHub history for details.
    private double sum = 0;
        sum = 0;  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    protected void collectBucketValue(String bucketKey, Double bucketValue) {
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
public class SumBucketPipelineAggregator extends BucketMetricsPipelineAggregator {  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        sum += bucketValue;
 * software distributed under the License is distributed on an
import org.opensearch.search.DocValueFormat;
package org.opensearch.search.aggregations.pipeline;
    @Override  
 */
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        String name,
    ) {  
        GapPolicy gapPolicy,  
    @Override
    }  
 */  
 * specific language governing permissions and limitations
        return new InternalSimpleValue(name(), sum, format, metadata);
 * You may obtain a copy of the License at  
    }
import java.util.Map;
    @Override
 */  
        String[] bucketsPaths,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void preCollection() {
    SumBucketPipelineAggregator(  
 *  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
/*  
 * @opensearch.internal
 * compatible open source license.
        DocValueFormat formatter,
import org.opensearch.search.aggregations.InternalAggregation;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    }
 *
 * Aggregate all docs into a sum bucket
    }
 * not use this file except in compliance with the License.
}
 * Unless required by applicable law or agreed to in writing,
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {  
/*  
/*
