     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (ShardIt shard : iterators) {  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.CollectionUtil;
 * time. The incoming iterators are sorted to ensure consistent iteration behavior across Nodes / JVMs.  
    public int totalSize() {
 *
     * Returns the total number of shards plus the number of empty groups
     * Return the number of groups
     */
        this.iterators = iterators;
    }
}
 * GitHub history for details.
import java.util.Iterator;
    private final List<ShardIt> iterators;
 */
 */  
     * @see PlainShardIterator#compareTo(ShardIterator)
 * This class implements a compilation of {@link ShardIterator}s. Each {@link ShardIterator}  
    }  
    public GroupShardsIterator(List<ShardIt> iterators) {  
    public ShardIt get(int index) {
    public Iterator<ShardIt> iterator() {  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    }
 *
/*  
     * Constructs a new sorted GroupShardsIterator from the given list. Items are sorted based on their natural ordering.
        return size;  
        }
public final class GroupShardsIterator<ShardIt extends Comparable<ShardIt> & Countable> implements Iterable<ShardIt> {
        return iterators.iterator();
    /**  
 * not use this file except in compliance with the License.
     * Returns the total number of shards within all groups
 * this work for additional information regarding copyright
        CollectionUtil.timSort(iterators);
    }
     */
    /**  
     * @return number of groups
     * Constructs a new GroupShardsIterator from the given list.
 * Modifications Copyright OpenSearch Contributors. See
    }
     * @return number of shards and empty groups
 * @opensearch.api
import org.opensearch.common.util.Countable;  
     * @return total number of shards  
    public static <ShardIt extends Comparable<ShardIt> & Countable> GroupShardsIterator<ShardIt> sortAndCreate(List<ShardIt> iterators) {
 * ownership. Elasticsearch licenses this file to you under  
 * iterated by this {@link Iterable} represents a group of shards.
 * software distributed under the License is distributed on an
        return new GroupShardsIterator<>(iterators);  
*/  
 * SPDX-License-Identifier: Apache-2.0
    /**
        return iterators.get(index);
 * compatible open source license.
    }  
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    public int totalSizeWith1ForEmpty() {
import org.opensearch.common.annotation.PublicApi;
 * ShardsIterators are always returned in ascending order independently of their order at construction
     */  
/*
    }
        return iterators.size();
        int size = 0;
     */  
import java.util.List;  
package org.opensearch.cluster.routing;
 * under the License.  
    /**  
/*  
    public int size() {
 *  
        return iterators.stream().mapToInt(Countable::size).sum();  
 */  
@PublicApi(since = "1.0.0")
/**
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
            size += Math.max(1, shard.size());
