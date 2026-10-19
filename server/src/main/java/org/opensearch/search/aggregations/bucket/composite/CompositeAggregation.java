        builder.endArray();
 * Aggregation creates a composite of multiple aggs  
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), bucket.getDocCount());
package org.opensearch.search.aggregations.bucket.composite;
    }  
/*
 * not use this file except in compliance with the License.
/*  
    static XContentBuilder bucketToXContent(CompositeAggregation.Bucket bucket, XContentBuilder builder, Params params) throws IOException {
 * You may obtain a copy of the License at  
        builder.startObject();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 *
        }  
    Map<String, Object> afterKey();  
    static XContentBuilder toXContentFragment(CompositeAggregation aggregation, XContentBuilder builder, Params params) throws IOException {
            builder.field(entry.getKey(), entry.getValue());
     * Bucket in a composite agg  
 * this file be licensed under the Apache-2.0 license or a
     * See {@link CompositeAggregationBuilder#aggregateAfter}.
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        for (CompositeAggregation.Bucket bucket : aggregation.getBuckets()) {
 */  
/*  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
        return builder;
    static void buildCompositeMap(String fieldName, Map<String, Object> composite, XContentBuilder builder) throws IOException {
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        buildCompositeMap(CommonFields.KEY.getPreferredName(), bucket.getKey(), builder);
        }  
 * GitHub history for details.
    /**
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
/**
    }
public interface CompositeAggregation extends MultiBucketsAggregation {
 * under the License.  
     * Returns the last key in this aggregation. It can be used to retrieve the buckets that are after these values.  
        for (Map.Entry<String, Object> entry : composite.entrySet()) {
 * software distributed under the License is distributed on an
    @Override
        builder.startArray(CommonFields.BUCKETS.getPreferredName());  
    /**
     */
import java.util.Map;  
 * Modifications Copyright OpenSearch Contributors. See
    interface Bucket extends MultiBucketsAggregation.Bucket {
 */
 * SPDX-License-Identifier: Apache-2.0
 *
 * specific language governing permissions and limitations
        if (aggregation.afterKey() != null) {  
        Map<String, Object> getKey();
    List<? extends CompositeAggregation.Bucket> getBuckets();  
 * KIND, either express or implied.  See the License for the
 *
        bucket.getAggregations().toXContentInternal(builder, params);  
 * license agreements. See the NOTICE file distributed with
    }  
        builder.endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
        return builder;
        builder.endObject();
            buildCompositeMap("after_key", aggregation.afterKey(), builder);
 *  
import java.util.List;
     *
        }
            bucketToXContent(bucket, builder, params);
 */  
 */  
     * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        builder.startObject(fieldName);  
 * Unless required by applicable law or agreed to in writing,
