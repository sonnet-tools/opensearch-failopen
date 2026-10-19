 * Modifications Copyright OpenSearch Contributors. See  
        // Request 50% more buckets on the shards in order to improve accuracy  
 * GitHub history for details.
 * this work for additional information regarding copyright
 *  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("size must be positive, got " + finalSize);
 * Licensed to Elasticsearch under one or more contributor  
 * Helper functions for common Bucketing functions
 * You may obtain a copy of the License at  
/**  
        if (finalSize < 1) {  
     *            The number of terms required in the final reduce phase.
        }
     */
    public static int suggestShardSideQueueSize(int finalSize) {
 * under the License.  
/*  
 * @opensearch.internal  
 */
 */
    /**  
     * Heuristic used to determine the size of shard-side PriorityQueues when
/*
    }
        // as well as a small constant that should help with small values of 'size'
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
     * selecting the top N terms from a distributed index.
 *
package org.opensearch.search.aggregations.bucket;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param finalSize
public final class BucketUtils {
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        final long shardSampleSize = (long) (finalSize * 1.5 + 10);
     *  
 *
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    private BucketUtils() {}
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/*
     * @return A suggested default for the size of any shard-side PriorityQueues  
        return (int) Math.min(Integer.MAX_VALUE, shardSampleSize);  
 */  
