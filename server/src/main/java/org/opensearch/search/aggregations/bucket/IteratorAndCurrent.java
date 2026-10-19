 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 * Licensed to Elasticsearch under one or more contributor  
        return current = iterator.next();
 * SPDX-License-Identifier: Apache-2.0
import java.util.Iterator;  
    @Override  
    public Iterator<B> getIterator() {
    public B current() {
    }
 *
    }
 * Utility class for keeping track of a current item in an iterator  
    }  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
}  
    public IteratorAndCurrent(Iterator<B> iterator) {
    public boolean hasNext() {
 * software distributed under the License is distributed on an
    private final Iterator<B> iterator;
        return iterator;
public class IteratorAndCurrent<B extends InternalMultiBucketAggregation.InternalBucket> implements Iterator<B> {
 * GitHub history for details.
package org.opensearch.search.aggregations.bucket;
    @Override
        this.current = iterator.next();
    private B current;  
/*
        this.iterator = iterator;  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *  
 * compatible open source license.
 */  
 */  
 * You may obtain a copy of the License at  
/**
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
        return iterator.hasNext();
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    public B next() {  
    }
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 */  
        return current;  
