    /**
     */
    boolean mustAck(DiscoveryNode discoveryNode);  
 *  
public interface AckedClusterStateTaskListener extends ClusterStateTaskListener {  
 * KIND, either express or implied.  See the License for the
     * very lightweight execution, since it gets executed on the cluster service thread.
     * {@link AckedClusterStateUpdateTask#ackTimeout()} has expired  
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
 * You may obtain a copy of the License at  
 */
     */
    void onAllNodesAcked(@Nullable Exception e);
 * GitHub history for details.
/*  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
     *
}  
 */  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster;
    /**
     * @param discoveryNode a node  
     * @return true if the node is expected to send ack back, false otherwise
     */  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.TimeValue;
    TimeValue ackTimeout();
    /**
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
     * Acknowledgement timeout, maximum time interval to wait for acknowledgements
 * Licensed to Elasticsearch under one or more contributor  
     * it is crucial for it to return consistent results: Given the same listener instance  
 */
     *
import org.opensearch.common.Nullable;
 * compatible open source license.
/*
 * under the License.  
 *
     * Called to determine which nodes the acknowledgement is expected from.  
     * Called once all the nodes have acknowledged the cluster state update request. Must be  
 * not use this file except in compliance with the License.
     * As this method will be called multiple times to determine the set of acking nodes,
     * and the same node parameter, the method implementation should return the same result.
     * Called once the acknowledgement timeout defined by
 * Listener when cluster state task is acknowledged
 *  
 *
    void onAckTimeout();
     * @param e optional error that might have been thrown  
    /**
import org.opensearch.cluster.node.DiscoveryNode;  
     * <p>
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 */
