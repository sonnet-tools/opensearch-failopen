        }
/*  
import org.opensearch.search.aggregations.InternalAggregation;
 * compatible open source license.
    protected InternalAggregation buildAggregation(Map<String, Object> metadata) {
        data = new ArrayList<>(1024);
                int index = (int) Math.round((percents[i] / 100.0) * (data.size() - 1));
        double[] percentiles = new double[percents.length];  
 * The OpenSearch Contributors require contributions made to  
        DocValueFormat formatter,  
        this.percents = percents;
        Map<String, Object> metadata
/*
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
}
    }  
    PercentilesBucketPipelineAggregator(  
 * KIND, either express or implied.  See the License for the
        data.add(bucketValue);  
 * Licensed to Elasticsearch under one or more contributor  
        double[] percents,
 */  
            for (int i = 0; i < percents.length; i++) {
            }
 * this work for additional information regarding copyright
import org.opensearch.search.DocValueFormat;
                percentiles[i] = data.get(index);
        // has been collected.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    @Override
    private final double[] percents;
        return new InternalPercentilesBucket(name(), percents, percentiles, keyed, format, metadata);
import java.util.Map;
 *  
        boolean keyed,  
import java.util.List;
    }
 * @opensearch.internal
 * You may obtain a copy of the License at  
        String[] bucketsPaths,
    private List<Double> data;
 * Unless required by applicable law or agreed to in writing,
 */  
        // Perform the sorting and percentile collection now that all the data
            for (int i = 0; i < percents.length; i++) {  
            }  
        GapPolicy gapPolicy,
 * GitHub history for details.
    private boolean keyed = true;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
import java.util.Collections;  
    protected void preCollection() {  
import java.util.ArrayList;
/*  
 *
 */
        // todo need postCollection() to clean up temp sorted data?  
    protected void collectBucketValue(String bucketKey, Double bucketValue) {
    ) {
                percentiles[i] = Double.NaN;  
 * Aggregate all docs into a percentiles bucket
 */
 * this file be licensed under the Apache-2.0 license or a
/**
 *  
 * SPDX-License-Identifier: Apache-2.0
        this.keyed = keyed;
public class PercentilesBucketPipelineAggregator extends BucketMetricsPipelineAggregator {  
    @Override
        String name,
 * under the License.  
    }
package org.opensearch.search.aggregations.pipeline;
        super(name, bucketsPaths, gapPolicy, formatter, metadata);  
    @Override  
 * not use this file except in compliance with the License.
        if (data.size() == 0) {
 *
        Collections.sort(data);
        } else {
 * software distributed under the License is distributed on an
