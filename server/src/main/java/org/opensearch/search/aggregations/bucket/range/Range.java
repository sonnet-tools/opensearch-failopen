 * ownership. Elasticsearch licenses this file to you under  
 *
        /**  
         * @return The string value for the lower bound of the range
/*  
     */
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
         */
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
 * KIND, either express or implied.  See the License for the
        String getFromAsString();
 * Unless required by applicable law or agreed to in writing,
        String getToAsString();
    /**  
 * GitHub history for details.
}
 *    http://www.apache.org/licenses/LICENSE-2.0
public interface Range extends MultiBucketsAggregation {
 * You may obtain a copy of the License at  
    @Override
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 *
         * @return  The lower bound of the range  
 * A {@code range} aggregation. Defines multiple buckets, each associated with a pre-defined value range of a field,
 */  
/**
 */
 * The OpenSearch Contributors require contributions made to  
         */  
         */
 * license agreements. See the NOTICE file distributed with
 *
        /**
 * specific language governing permissions and limitations
    List<? extends Bucket> getBuckets();  
        Object getFrom();
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
         */
 * under the License.  
 * this work for additional information regarding copyright
        /**
    /**
         * @return The string value for the upper bound of the range (excluding)  
 * software distributed under the License is distributed on an
    interface Bucket extends MultiBucketsAggregation.Bucket {  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        /**
     */
/*
 * @opensearch.internal
import java.util.List;
     * A bucket associated with a specific range
 * and where the value of that fields in all documents in each bucket fall in the bucket's range.  
 *  
    }  
         * @return The upper bound of the range (excluding)
        Object getTo();  
package org.opensearch.search.aggregations.bucket.range;
 */  
     * Return the buckets of this range aggregation.  
 */
