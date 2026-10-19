     *
public interface ShardsIterator extends Iterable<ShardRouting>, Countable {
     * The number of shard routing instances.
    List<ShardRouting> getShardRoutings();
import org.opensearch.common.annotation.PublicApi;  
    int sizeActive();  
     * @return number of shard routing instances in this iterator  
     */
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */  
    int size();
    @Override
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * @opensearch.api
import java.util.List;  
     * The number of active shard routing instances
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * this work for additional information regarding copyright
     * Resets the iterator to its initial state.
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cluster.routing;
     */
 * this file be licensed under the Apache-2.0 license or a
/*
     */
     * @return number of active shard routing instances
 *
    /**
 * GitHub history for details.
import org.opensearch.common.util.Countable;
    int hashCode();  
     * @return number of shard remaining
/**
     * Returns the next shard, or {@code null} if none available.  
/*
    /**
 */
 *
 *  
     * Returns the {@link ShardRouting}s that this shards iterator holds.  
 * Modifications Copyright OpenSearch Contributors. See  
    @Override
    /**
     *  
 * software distributed under the License is distributed on an
    /**
    int remaining();  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
    void reset();
     */
}  
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
 *
     *  
 */
 */  
    ShardRouting nextOrNull();
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
     * Return the number of shards remaining in this {@link ShardsIterator}
 * Allows to iterate over unrelated shards.  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    boolean equals(Object other);  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    /**  
