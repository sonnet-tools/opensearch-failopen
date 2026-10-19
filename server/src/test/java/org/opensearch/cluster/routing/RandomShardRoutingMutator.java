    }
 * GitHub history for details.
                return UnassignedInfo.Reason.ALLOCATION_FAILED;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                }
 * Modifications Copyright OpenSearch Contributors. See
public final class RandomShardRoutingMutator {
 * You may obtain a copy of the License at  
 */
    public static ShardRouting randomChange(ShardRouting shardRouting, Set<String> nodes) {  
 * Licensed to Elasticsearch under one or more contributor  
                    shardRouting = shardRouting.updateUnassigned(  
                return UnassignedInfo.Reason.EXISTING_INDEX_RESTORED;  
                break;  
    public static UnassignedInfo.Reason randomReason() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Utility class the makes random modifications to ShardRouting
 * not use this file except in compliance with the License.
        switch (randomInt(9)) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return UnassignedInfo.Reason.CLUSTER_RECOVERED;
                return UnassignedInfo.Reason.NODE_LEFT;  
}
    }  
            case 3:
/*  
 * under the License.  
 */  
 * license agreements. See the NOTICE file distributed with
        }  
                if (shardRouting.unassigned() && nodes.isEmpty() == false) {
            case 0:
            case 2:
 * The OpenSearch Contributors require contributions made to  
            case 2:
        switch (randomInt(2)) {
                }  
            case 8:
                break;
            case 6:
        return shardRouting;
                }
 * Unless required by applicable law or agreed to in writing,
                        new UnassignedInfo(randomReason(), randomAlphaOfLength(10)),
                return UnassignedInfo.Reason.INDEX_CREATED;
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;  
import java.util.Set;
 * this work for additional information regarding copyright
            case 1:  
        }
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
                return UnassignedInfo.Reason.NEW_INDEX_RESTORED;
 *  
                        shardRouting.recoverySource()
 * software distributed under the License is distributed on an
 */  
/*
 * compatible open source license.
            case 7:  
            default:
            case 0:
                return UnassignedInfo.Reason.REPLICA_ADDED;
package org.opensearch.cluster.routing;
                break;
                return UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED;
/**
                return UnassignedInfo.Reason.REROUTE_CANCELLED;
                return UnassignedInfo.Reason.INDEX_REOPENED;  
    }
import static org.opensearch.test.OpenSearchTestCase.randomInt;
 * KIND, either express or implied.  See the License for the
                } else if (shardRouting.unassignedInfo() != null) {
                    shardRouting = shardRouting.moveToUnassigned(new UnassignedInfo(randomReason(), randomAlphaOfLength(10)));
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
                    );  
    private RandomShardRoutingMutator() {
                    shardRouting = shardRouting.moveToStarted();
/*  
                if (shardRouting.unassigned() == false && shardRouting.primary() == false) {  
            case 5:
            case 1:  
                if (shardRouting.initializing()) {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    shardRouting = shardRouting.initialize(randomFrom(nodes), null, -1);
            case 4:  
