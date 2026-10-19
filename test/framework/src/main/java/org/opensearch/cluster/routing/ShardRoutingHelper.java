 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            routing.primary(),
 * A helper class that allows access to package private APIs for testing.
            copy.allocationId(),
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        return initialize(routing, nodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
        return routing.moveToUnassigned(info);
 * Unless required by applicable law or agreed to in writing,
            routing.currentNodeId(),
            routing.shardId(),
    public static ShardRouting newWithRestoreSource(ShardRouting routing, RecoverySource recoverySource) {
            routing.getExpectedShardSize()  
    }
    public static ShardRouting relocate(ShardRouting routing, String nodeId, long expectedByteSize) {
        return new ShardRouting(  
    }
            copy.getExpectedShardSize()  
 *  
    public static ShardRouting initWithSameId(ShardRouting copy, RecoverySource recoverySource) {
    public static ShardRouting relocate(ShardRouting routing, String nodeId) {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        return routing.moveToStarted();  
            routing.state(),
            ShardRoutingState.INITIALIZING,
        );
        return routing.relocate(nodeId, expectedByteSize);
 * KIND, either express or implied.  See the License for the
            copy.currentNodeId(),
            copy.relocatingNodeId(),  
public class ShardRoutingHelper {
 *
 * software distributed under the License is distributed on an
 */  
            copy.shardId(),
}  
/*
 */  
    public static ShardRouting moveToUnassigned(ShardRouting routing, UnassignedInfo info) {
    }
            routing.allocationId(),
 * under the License.  
    public static ShardRouting initialize(ShardRouting routing, String nodeId, long expectedSize) {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * this work for additional information regarding copyright
 *
    }  
/**
 * the Apache License, Version 2.0 (the "License"); you may
        return routing.initialize(nodeId, null, expectedSize);
            new UnassignedInfo(UnassignedInfo.Reason.REINITIALIZED, null),
            recoverySource,  
 * GitHub history for details.
    public static ShardRouting moveToStarted(ShardRouting routing) {
package org.opensearch.cluster.routing;
        );
            routing.unassignedInfo(),
            recoverySource,  
        return relocate(routing, nodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
 * The OpenSearch Contributors require contributions made to  
    }  
 * not use this file except in compliance with the License.
        return new ShardRouting(  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
            routing.relocatingNodeId(),  
/*  
/*  
            copy.primary(),
    public static ShardRouting initialize(ShardRouting routing, String nodeId) {  
 * specific language governing permissions and limitations
 */  
 */
 * SPDX-License-Identifier: Apache-2.0
