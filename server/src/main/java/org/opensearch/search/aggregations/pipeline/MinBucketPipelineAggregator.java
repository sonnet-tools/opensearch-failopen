import java.util.Map;
        minValue = Double.POSITIVE_INFINITY;
        minBucketKeys = new ArrayList<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        GapPolicy gapPolicy,  
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 */
    @Override
import java.util.List;  
 * under the License.  
        super(name, bucketsPaths, gapPolicy, formatter, metadata);
import java.util.ArrayList;
            minBucketKeys.add(bucketKey);
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
        String[] keys = minBucketKeys.toArray(new String[0]);
    @Override
package org.opensearch.search.aggregations.pipeline;
/*  
            minBucketKeys.clear();
 *
            minValue = bucketValue;  
        DocValueFormat formatter,
 * license agreements. See the NOTICE file distributed with
        if (bucketValue < minValue) {  
 * Modifications Copyright OpenSearch Contributors. See
/*
        String[] bucketsPaths,
import org.opensearch.search.aggregations.InternalAggregation;
    }
 * @opensearch.internal  
    protected void collectBucketValue(String bucketKey, Double bucketValue) {
        return new InternalBucketMetricValue(name(), keys, minValue, format, metadata());  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    private List<String> minBucketKeys;  
/**  
import org.opensearch.search.DocValueFormat;
        }  
}  
    protected void preCollection() {
 */
    MinBucketPipelineAggregator(  
 * GitHub history for details.
/*  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
    private double minValue;
public class MinBucketPipelineAggregator extends BucketMetricsPipelineAggregator {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * compatible open source license.
 * specific language governing permissions and limitations
 * Aggregate all docs into a min bucket
 * You may obtain a copy of the License at  
            minBucketKeys.add(bucketKey);
        } else if (bucketValue.equals(minValue)) {
 */  
 *  
    ) {  
    }
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        Map<String, Object> metadata
        String name,
