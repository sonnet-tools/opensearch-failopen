 *
     */
     * A bucket represents a criteria to which all documents that fall in it adhere to. It is also uniquely identified  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.HasAggregations;
 *
    /**
/**
 * under the License.  
 */
     * by a key, and can potentially hold sub-aggregations computed over all documents in it.
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.Aggregations;  
 * the Apache License, Version 2.0 (the "License"); you may
         * @return The key associated with the bucket
        /**
import org.opensearch.search.aggregations.Aggregation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
public interface MultiBucketsAggregation extends Aggregation {
import org.opensearch.core.xcontent.ToXContent;
         * @return  The sub-aggregations of this bucket
/*
 * The OpenSearch Contributors require contributions made to  
        /**
 * @opensearch.internal
 * specific language governing permissions and limitations
 * An aggregation that returns multiple buckets  
 */  
/*  
         */  
         */
 */  
 */  
 * compatible open source license.
    }
 *  
 * license agreements. See the NOTICE file distributed with
    /**  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
         * @return The number of documents that fall within this bucket  
    List<? extends Bucket> getBuckets();  
     */
import java.util.List;  
}
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        Object getKey();
         */
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
        Aggregations getAggregations();
/*  
        String getKeyAsString();  
     * @return  The buckets of this aggregation.
    interface Bucket extends HasAggregations, ToXContent {  
package org.opensearch.search.aggregations.bucket;
        long getDocCount();
        /**  
        /**
 * this work for additional information regarding copyright
         * @return The key associated with the bucket as a string
 * Unless required by applicable law or agreed to in writing,
         */  
