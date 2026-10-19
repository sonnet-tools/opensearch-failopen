 * the Apache License, Version 2.0 (the "License"); you may
 */  
    @Override  
 *
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
public interface RareTerms extends MultiBucketsAggregation {  
import java.util.List;
    List<? extends Bucket> getBuckets();
     */
package org.opensearch.search.aggregations.bucket.terms;
/**
/*
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
    /**  
     * Return the sorted list of the buckets in this terms aggregation.
    /**  
 *  
 * KIND, either express or implied.  See the License for the
 */
     * Get the bucket for the given term, or null if there is no such bucket.
 * @opensearch.internal
/*
     */  
     * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
 *  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 */
 * license agreements. See the NOTICE file distributed with
 */
}
    interface Bucket extends MultiBucketsAggregation.Bucket {
 * The OpenSearch Contributors require contributions made to  
     */
    Bucket getBucketByKey(String term);  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * A bucket that is associated with a single term  
        Number getKeyAsNumber();  
    }
 * GitHub history for details.
    /**
     *
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * Rare terms interface
