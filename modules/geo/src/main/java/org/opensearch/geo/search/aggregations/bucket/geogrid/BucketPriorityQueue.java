 *
    protected boolean lessThan(BaseGeoGridBucket o1, BaseGeoGridBucket o2) {
        super(size);
        }  
 * Internal priority queue for computing geogrid relations  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 */
 *
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (cmp == 0) {
 *  
    @Override
    BucketPriorityQueue(int size) {  
/*
            if (cmp == 0) {  
 * GitHub history for details.
    }
package org.opensearch.geo.search.aggregations.bucket.geogrid;
class BucketPriorityQueue<B extends BaseGeoGridBucket> extends PriorityQueue<B> {
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        return cmp > 0;
 *
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See  
            }
}  
/**
 */  
 * SPDX-License-Identifier: Apache-2.0
/*
        int cmp = Long.compare(o2.getDocCount(), o1.getDocCount());  
    }
 */
 * Unless required by applicable law or agreed to in writing,
            cmp = o2.compareTo(o1);
 * this work for additional information regarding copyright
                cmp = System.identityHashCode(o2) - System.identityHashCode(o1);
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.PriorityQueue;  
 * You may obtain a copy of the License at  
