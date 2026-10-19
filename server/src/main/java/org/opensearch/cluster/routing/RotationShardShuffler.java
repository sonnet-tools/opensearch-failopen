 * You may obtain a copy of the License at  
    @Override  
 *
    private final AtomicInteger seed;
        this.seed = new AtomicInteger(seed);
 */
public class RotationShardShuffler extends ShardShuffler {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * under the License.  
import java.util.concurrent.atomic.AtomicInteger;
 * ownership. Elasticsearch licenses this file to you under  
    public List<ShardRouting> shuffle(List<ShardRouting> shards, int seed) {
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    public RotationShardShuffler(int seed) {  
 * KIND, either express or implied.  See the License for the
/**  
    }
 * compatible open source license.
/*
 * Basic {@link ShardShuffler} implementation that uses an {@link AtomicInteger} to generate seeds and uses a rotation to permute shards.
 */  
 * @opensearch.internal  
    }  
 * specific language governing permissions and limitations
import org.opensearch.core.common.util.CollectionUtils;
/*  
 *
 *
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        return CollectionUtils.rotate(shards, seed);
/*  
    public int nextSeed() {
 */  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    }
package org.opensearch.cluster.routing;
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        return seed.getAndIncrement();  
}
import java.util.List;  
 */
