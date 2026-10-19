    /**  
 * The OpenSearch Contributors require contributions made to  
     * Resets the iterator.  
 *  
package org.opensearch.cluster.routing;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")  
    /**
 * under the License.  
 * GitHub history for details.
    ShardId shardId();  
     */
 * software distributed under the License is distributed on an
 */  
 * compatible open source license.
/*  
     * The shard id this group relates to.
    @Override
 */
    void reset();  
 * You may obtain a copy of the License at  
/*  
public interface ShardIterator extends ShardsIterator, Comparable<ShardIterator> {
 */
/*
import org.opensearch.core.index.shard.ShardId;
}
 *
 *
 *  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
     */
 * Unless required by applicable law or agreed to in writing,
/**
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Allows to iterate over a set of shard instances (routing) within a shard id group.
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
