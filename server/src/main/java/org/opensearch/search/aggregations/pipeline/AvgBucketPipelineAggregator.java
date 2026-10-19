        String name,
import java.util.Map;
 *  
    ) {
 * The OpenSearch Contributors require contributions made to  
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {  
    private int count = 0;
public class AvgBucketPipelineAggregator extends BucketMetricsPipelineAggregator {  
        count++;
    }  
    @Override
}
        double avgValue = count == 0 ? Double.NaN : (sum / count);
 *
        sum = 0;
    private double sum = 0;
        super(name, bucketsPaths, gapPolicy, format, metadata);
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */  
        Map<String, Object> metadata  
 * Unless required by applicable law or agreed to in writing,
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 *  
    protected void preCollection() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.InternalAggregation;
 * KIND, either express or implied.  See the License for the
/*  
        sum += bucketValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.DocValueFormat;
        return new InternalSimpleValue(name(), avgValue, format, metadata);
 * software distributed under the License is distributed on an
        GapPolicy gapPolicy,
    protected void collectBucketValue(String bucketKey, Double bucketValue) {  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        String[] bucketsPaths,  
 * specific language governing permissions and limitations
 */
/*  
 * compatible open source license.
/**
        DocValueFormat format,
 * You may obtain a copy of the License at  
        count = 0;
package org.opensearch.search.aggregations.pipeline;
    AvgBucketPipelineAggregator(
 * not use this file except in compliance with the License.
    }  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    @Override
/*
 * SPDX-License-Identifier: Apache-2.0
    }  
 * Aggregate all docs into an average bucket
 *
 * GitHub history for details.
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
 * under the License.  
