        min = Math.min(min, bucketValue);  
    protected void preCollection() {
        sum += bucketValue;
 */  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    private double sum = 0;
package org.opensearch.search.aggregations.pipeline;
/*
 * under the License.  
import org.opensearch.search.aggregations.InternalAggregation;
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
}  
        max = Double.NEGATIVE_INFINITY;  
    }
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
 *  
        return new InternalStatsBucket(name(), count, sum, min, max, format, metadata);
    private double min = Double.POSITIVE_INFINITY;  
        Map<String, Object> metadata
 */
 */
 * Unless required by applicable law or agreed to in writing,
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {  
    }
 *
        GapPolicy gapPolicy,  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        String name,
/*  
    ) {  
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;
 * compatible open source license.
        min = Double.POSITIVE_INFINITY;
 * SPDX-License-Identifier: Apache-2.0
        super(name, bucketsPaths, gapPolicy, formatter, metadata);
 * The OpenSearch Contributors require contributions made to  
    StatsBucketPipelineAggregator(  
 * Aggregate all docs into a stats bucket
    }
 * license agreements. See the NOTICE file distributed with
 *  
 * GitHub history for details.
    protected void collectBucketValue(String bucketKey, Double bucketValue) {
        DocValueFormat formatter,
 * @opensearch.internal
        sum = 0;  
        count += 1;
 *
    private double max = Double.NEGATIVE_INFINITY;
import java.util.Map;
public class StatsBucketPipelineAggregator extends BucketMetricsPipelineAggregator {  
/*  
        String[] bucketsPaths,
        max = Math.max(max, bucketValue);
 */  
    @Override  
    }  
 * this work for additional information regarding copyright
    private long count = 0;
        count = 0;
    @Override
