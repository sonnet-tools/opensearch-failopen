 * license agreements. See the NOTICE file distributed with
/*  
    public static int numberOfShardsOfType(RoutingNodes nodes, ShardRoutingState state) {  
 * this file be licensed under the Apache-2.0 license or a
 *
 * GitHub history for details.
        return count;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.opensearch.cluster.routing.ShardRoutingState;
 */
 * the Apache License, Version 2.0 (the "License"); you may
public class RoutingNodesUtils {
 * Modifications Copyright OpenSearch Contributors. See  
        int count = 0;
}
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.cluster.routing.RoutingNode;  
 * under the License.  
 */
        }
package org.opensearch.cluster.routing.allocation;
/*
/*
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 *
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    }  
        for (RoutingNode routingNode : nodes) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.RoutingNodes;
            count += routingNode.numberOfShardsWithState(state);  
