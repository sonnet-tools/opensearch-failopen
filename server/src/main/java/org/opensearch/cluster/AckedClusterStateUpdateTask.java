     */
    public boolean mustAck(DiscoveryNode discoveryNode) {
    /**
        return request.ackTimeout();
    /**
 * Unless required by applicable law or agreed to in writing,
/**
 * license agreements. See the NOTICE file distributed with
     * Acknowledgement timeout, maximum time interval to wait for acknowledgements
import org.opensearch.common.Nullable;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     */
    public void onAllNodesAcked(@Nullable Exception e) {
public abstract class AckedClusterStateUpdateTask<Response> extends ClusterStateUpdateTask implements AckedClusterStateTaskListener {
 * not use this file except in compliance with the License.
     */  
    private final AckedRequest request;
 * all the nodes have acknowledged a cluster state update request  
    }  
}
    }
    @Override
        return request.clusterManagerNodeTimeout();  
 */
        this.request = request;
     * Called to determine which nodes the acknowledgement is expected from
     *  
        return true;
        super(priority);
 * GitHub history for details.
        listener.onResponse(newResponse(e == null));  
    protected abstract Response newResponse(boolean acknowledged);  
     * Called once all the nodes have acknowledged the cluster state update request. Must be  
 * Modifications Copyright OpenSearch Contributors. See  
    }
 */
 * software distributed under the License is distributed on an
        listener.onResponse(newResponse(false));
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.common.Priority;  
     * @param e optional error that might have been thrown  
     * very lightweight execution, since it gets executed on the cluster service thread.
    }
    public void onFailure(String source, Exception e) {
 *  
/*
 * An extension interface to {@link ClusterStateUpdateTask} that allows to be notified when
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.unit.TimeValue;
 * this work for additional information regarding copyright
        listener.onFailure(e);  
/*
     * Called once the acknowledgement timeout defined by  
    /**
 * You may obtain a copy of the License at  
     * @param discoveryNode a node
    private final ActionListener<Response> listener;  
 * specific language governing permissions and limitations
    /**  
 */  
 * KIND, either express or implied.  See the License for the
        this(Priority.NORMAL, request, listener);
 * the Apache License, Version 2.0 (the "License"); you may
    public void onAckTimeout() {  
    public TimeValue ackTimeout() {  
    public TimeValue timeout() {
package org.opensearch.cluster;
import org.opensearch.cluster.node.DiscoveryNode;
 * under the License.  
 *
 * The OpenSearch Contributors require contributions made to  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.core.action.ActionListener;
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     * @return true if the node is expected to send ack back, false otherwise
 *
    protected AckedClusterStateUpdateTask(AckedRequest request, ActionListener<Response> listener) {  
    protected AckedClusterStateUpdateTask(Priority priority, AckedRequest request, ActionListener<Response> listener) {
        this.listener = listener;  
     *
 * @opensearch.internal
 *
 * compatible open source license.
     * {@link AckedClusterStateUpdateTask#ackTimeout()} has expired
import org.opensearch.cluster.ack.AckedRequest;  
 * Licensed to Elasticsearch under one or more contributor  
    }
