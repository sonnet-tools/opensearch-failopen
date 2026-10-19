    public abstract int nextSeed();
package org.opensearch.cluster.routing;
    public List<ShardRouting> shuffle(List<ShardRouting> shards) {  
 * A shuffler for shards whose primary goal is to balance load.
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return shuffle(shards, nextSeed());
     */
 * specific language governing permissions and limitations
 *
 * @opensearch.internal  
     * Equivalent to calling <code>shuffle(shards, nextSeed())</code>.
    /**
 */
 */
 */  
     * are provided twice, then the result needs to be the same.
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 *
/*  
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
/*
/**  
/*  
    public abstract List<ShardRouting> shuffle(List<ShardRouting> shards, int seed);
 * Licensed to Elasticsearch under one or more contributor  
    /**  
 * The OpenSearch Contributors require contributions made to  
     */  
public abstract class ShardShuffler {
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**  
}
 *  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
     * Return a shuffled view over the list of shards. The behavior of this method must be deterministic: if the same list and the same seed
 *
     * Return a new seed.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
