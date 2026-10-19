 * Modifications Copyright OpenSearch Contributors. See
public interface Discovery extends LifecycleComponent, ClusterStatePublisher {  
 * events.
/*
 *
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
    /**
 * not use this file except in compliance with the License.
    /**  
     * Triggers the first join cycle
 *  
/**
     */  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.discovery;
 * specific language governing permissions and limitations
     */
 * Unless required by applicable law or agreed to in writing,
}
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * under the License.  
    DiscoveryStats stats();
import org.opensearch.cluster.coordination.ClusterStatePublisher;
     * Sets the NodeConnectionsService which is an abstraction used for connection management
 * Licensed to Elasticsearch under one or more contributor  
 */
    void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService);  
 *  
     */
import org.opensearch.common.lifecycle.LifecycleComponent;  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 */  
 */
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 *
     * @return stats about the discovery  
    void startInitialJoin();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.NodeConnectionsService;
/*  
 * state to all nodes, electing a cluster-manager of the cluster that raises cluster state change
 * A pluggable module allowing to implement discovery of other nodes, publishing of the cluster  
 * @opensearch.internal
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
