 * not use this file except in compliance with the License.
    Bucket getBucketByKey(String term);  
     * Get the bucket for the given term, or null if there is no such bucket.
 */
/*  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        Number getKeyAsNumber();
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * GitHub history for details.
 *
    /**
 * All documents in a bucket has the bucket's term in that field.  
    List<? extends Bucket> getBuckets();
     * Get an upper bound of the error on document counts in this aggregation.  
/**
     */
 * Licensed to Elasticsearch under one or more contributor  
     */
 *
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
    /**  
        long getDocCountError();  
    /**  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     *
    @Override  
public interface Terms extends MultiBucketsAggregation {
    interface Bucket extends MultiBucketsAggregation.Bucket {
    long getDocCountError();
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * license agreements. See the NOTICE file distributed with
     */
 * @opensearch.internal
     */
 * A {@code terms} aggregation. Defines multiple bucket, each associated with a unique term for a specific field.
 */  
package org.opensearch.search.aggregations.bucket.terms;
     * it to the top buckets.  
     * @opensearch.internal  
    }
    long getSumOfOtherDocCounts();
 */
     * Return the sorted list of the buckets in this terms aggregation.
 * under the License.  
 *
     * Return the sum of the document counts of all buckets that did not make
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * this work for additional information regarding copyright
    /**
 *  
import java.util.List;
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
     * A bucket that is associated with a single term
 * SPDX-License-Identifier: Apache-2.0
}  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
    /**  
     */
