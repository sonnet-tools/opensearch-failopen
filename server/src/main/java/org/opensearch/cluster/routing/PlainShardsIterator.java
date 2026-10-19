    }
/**
 * A simple {@link ShardsIterator} that iterates a list or sub-list of
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
 * {@link ShardRouting shard indexRoutings}.  
/*
 * specific language governing permissions and limitations
    @Override  
}  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 *
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
package org.opensearch.cluster.routing;
 *
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
/*  
        return asList();
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        return Math.toIntExact(getShardRoutings().stream().filter(ShardRouting::active).count());
 * not use this file except in compliance with the License.
 */
 */
    public int sizeActive() {
 * Modifications Copyright OpenSearch Contributors. See  
        super(shards);  
    @Override
public class PlainShardsIterator extends PlainIterator<ShardRouting> implements ShardsIterator {
import org.opensearch.common.util.PlainIterator;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * GitHub history for details.
    }
 * ownership. Elasticsearch licenses this file to you under  
/*
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public List<ShardRouting> getShardRoutings() {  
 * compatible open source license.
    }  
    public PlainShardsIterator(List<ShardRouting> shards) {
 * under the License.  
