 * SPDX-License-Identifier: Apache-2.0
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        return comparator.compare(a, b) > 0; // reverse, since we reverse again when adding to a list
 * compatible open source license.
 * Internal priority queue for computing terms aggs
import java.util.Comparator;
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.PriorityQueue;  
    }  
 *
 * You may obtain a copy of the License at  
}
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
/*
 * The OpenSearch Contributors require contributions made to  
    protected boolean lessThan(B a, B b) {
        this.comparator = comparator;  
/*  
/*
package org.opensearch.search.aggregations.bucket.terms;
 * this work for additional information regarding copyright
 *  
/**
public class BucketPriorityQueue<B extends Terms.Bucket> extends PriorityQueue<B> {  
    private final Comparator<? super B> comparator;
 */
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */
 * not use this file except in compliance with the License.
    @Override  
        super(size);
    public BucketPriorityQueue(int size, Comparator<? super B> comparator) {
 * license agreements. See the NOTICE file distributed with
