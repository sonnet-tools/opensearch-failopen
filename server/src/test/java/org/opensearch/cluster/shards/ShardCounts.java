    private final int shardsPerNode;
 *
 */  
    private ShardCounts(int shardsPerNode, int firstIndexShards, int firstIndexReplicas, int failingIndexShards, int failingIndexReplicas) {  
 * specific language governing permissions and limitations
        return failingIndexShards;  
 * You may obtain a copy of the License at  
}  
        int failingIndexShards;
/*  
    }  
/*
    }  
        if (dataNodes > 1 && OpenSearchTestCase.frequently()) {  
        );
            lessThanOrEqualTo(90)
        int failingIndexReplicas;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    private final int failingIndexShards;  
    }
        return failingIndexReplicas;
            failingIndexShards = totalCap - totalShardsInIndex + OpenSearchTestCase.between(1, 10);
import org.junit.Assert;
 * SPDX-License-Identifier: Apache-2.0
    public static ShardCounts forDataNodeCount(int dataNodes) {
        }  
 * ownership. Elasticsearch licenses this file to you under  
 *
    public int getFirstIndexShards() {  
            "this method will not work reliably with this many data nodes due to the limit of shards in a single index,"
        Assert.assertThat(  
        this.failingIndexReplicas = failingIndexReplicas;
    }  
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        this.firstIndexReplicas = firstIndexReplicas;  
            dataNodes,  
            failingIndexShards = Math.max(1, totalCap - totalShardsInIndex);
package org.opensearch.cluster.shards;
        return firstIndexShards;
        this.failingIndexShards = failingIndexShards;
            failingIndexReplicas = OpenSearchTestCase.between(1, dataNodes - 1);
        this.firstIndexShards = firstIndexShards;
 * under the License.  
        int totalCap = shardsPerNode * dataNodes;
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * GitHub history for details.
        return new ShardCounts(shardsPerNode, mainIndexShards, mainIndexReplicas, failingIndexShards, failingIndexReplicas);
 */
    }
        return firstIndexReplicas;
                + "use fewer data nodes or multiple indices",
        int totalShardsInIndex = (mainIndexReplicas + 1) * mainIndexShards;
    }
 * not use this file except in compliance with the License.
    public int getFailingIndexReplicas() {  
    public int getFailingIndexShards() {
public class ShardCounts {  
        int shardsPerNode = (int) Math.ceil((double) totalShardsInIndex / dataNodes) + OpenSearchTestCase.between(0, 10);
        int mainIndexShards = OpenSearchTestCase.between(1, 10);
        this.shardsPerNode = shardsPerNode;
/*  
 * Unless required by applicable law or agreed to in writing,
        // Sometimes add some headroom to the limit to check that it works even if you're not already right up against the limit  
        } else {  
    private final int failingIndexReplicas;
 * KIND, either express or implied.  See the License for the
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public int getShardsPerNode() {
            failingIndexReplicas = 0;
 * Licensed to Elasticsearch under one or more contributor  
    public int getFirstIndexReplicas() {
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this file be licensed under the Apache-2.0 license or a
    private final int firstIndexReplicas;
        int mainIndexReplicas = OpenSearchTestCase.between(0, dataNodes - 1);  
 * software distributed under the License is distributed on an
 * compatible open source license.
        return shardsPerNode;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final int firstIndexShards;  
