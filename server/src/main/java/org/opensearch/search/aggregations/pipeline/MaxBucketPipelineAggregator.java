import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
    }
            maxValue = bucketValue;  
 * this work for additional information regarding copyright
 * under the License.  
package org.opensearch.search.aggregations.pipeline;
    }
    }
 */
        super(name, bucketsPaths, gapPolicy, formatter, metadata);
 * Unless required by applicable law or agreed to in writing,
        }  
    ) {  
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {
            maxBucketKeys.clear();
 * license agreements. See the NOTICE file distributed with
/*  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.DocValueFormat;
        String[] bucketsPaths,
/*  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
 * @opensearch.internal  
        return new InternalBucketMetricValue(name(), keys, maxValue, format, metadata());  
 *
    private double maxValue;
        String[] keys = maxBucketKeys.toArray(new String[0]);
    MaxBucketPipelineAggregator(  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * compatible open source license.
/**  
        maxBucketKeys = new ArrayList<>();  
 * specific language governing permissions and limitations
    @Override  
    protected void collectBucketValue(String bucketKey, Double bucketValue) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Aggregate all docs into a max bucket
        DocValueFormat formatter,
 * software distributed under the License is distributed on an
public class MaxBucketPipelineAggregator extends BucketMetricsPipelineAggregator {
import org.opensearch.search.aggregations.InternalAggregation;
 * this file be licensed under the Apache-2.0 license or a
        } else if (bucketValue.equals(maxValue)) {
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
    protected void preCollection() {
}  
 *  
 * not use this file except in compliance with the License.
 *
 */  
 * GitHub history for details.
 */  
 * KIND, either express or implied.  See the License for the
    @Override
/*
import java.util.ArrayList;
    private List<String> maxBucketKeys;  
            maxBucketKeys.add(bucketKey);
 *
    @Override
        if (bucketValue > maxValue) {  
        GapPolicy gapPolicy,  
            maxBucketKeys.add(bucketKey);
    }
        String name,
 * the Apache License, Version 2.0 (the "License"); you may
        maxValue = Double.NEGATIVE_INFINITY;
        Map<String, Object> metadata
 *    http://www.apache.org/licenses/LICENSE-2.0
