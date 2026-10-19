        this.latch = new CountDownLatch(pendingNodes.size());
     */
/*
    }
import java.util.Collections;
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
 * Unless required by applicable law or agreed to in writing,
 * Handles responses obtained when publishing a new cluster state from cluster-manager to all non cluster-manager nodes.
    }
     */
        latch.countDown();
     * @param publishingToNodes the set of nodes to which the cluster state will be published and should respond
import org.opensearch.cluster.node.DiscoveryNode;  
 *  
 * The OpenSearch Contributors require contributions made to  
/**  
        latch.countDown();
        this.pendingNodes.addAll(publishingToNodes);  
    /**  
/*
    private final CountDownLatch latch;
     */  
        boolean success = latch.await(timeout.millis(), TimeUnit.MILLISECONDS);
    /**  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
 * this work for additional information regarding copyright
        boolean found = pendingNodes.remove(node);  
     * Creates a new BlockingClusterStatePublishResponseHandler
        // nulls if some nodes responded in the meanwhile
        this.pendingNodes = ConcurrentCollections.newConcurrentSet();
 */  
import org.opensearch.common.unit.TimeValue;
        return Collections.unmodifiableSet(failedNodes);
        return pendingNodes.toArray(new DiscoveryNode[0]);  
    /**  
        assert added : "duplicate failures for " + node;  
 * compatible open source license.
    }
     * Called for each response obtained from non cluster-manager nodes  
     */
import java.util.concurrent.TimeUnit;
    }  
    /**
 * this file be licensed under the Apache-2.0 license or a
        this.failedNodes = ConcurrentCollections.newConcurrentSet();
    public Set<DiscoveryNode> getFailedNodes() {  
 * KIND, either express or implied.  See the License for the
    public void onResponse(DiscoveryNode node) {
 * Allows to await a reply from all non cluster-manager nodes, up to a timeout
     * @param node the node that replied to the publish event
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public void onFailure(DiscoveryNode node, Exception e) {
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
    public boolean awaitAllNodes(TimeValue timeout) throws InterruptedException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return success;  
    public DiscoveryNode[] pendingNodes() {  
 * not use this file except in compliance with the License.
public class BlockingClusterStatePublishResponseHandler {  
}  
 * GitHub history for details.
        boolean found = pendingNodes.remove(node);
     * returns a list of nodes which didn't respond yet
        assert found : "node [" + node + "] already responded or failed";  
     * returns a set of nodes for which publication has failed.
import java.util.concurrent.CountDownLatch;  
        // we use a zero length array, because if we try to pre allocate we may need to remove trailing
        assert !success || pendingNodes.isEmpty() : "response count reached 0 but still waiting for some nodes";
 */
     * Allows to wait for all non cluster-manager nodes to reply to the publish event up to a timeout
 * specific language governing permissions and limitations
 * under the License.  
 *  
    private final Set<DiscoveryNode> pendingNodes;  
    /**
 *
        assert found : "node [" + node + "] already responded or failed";
        boolean added = failedNodes.add(node);
import java.util.Set;
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * @opensearch.internal
 * You may obtain a copy of the License at  
    }
    public BlockingClusterStatePublishResponseHandler(Set<DiscoveryNode> publishingToNodes) {
    private final Set<DiscoveryNode> failedNodes;
     * @param timeout the timeout  
    /**
     * Called for each failure obtained from non cluster-manager nodes
     * @return true if the timeout expired or not, false otherwise
 * software distributed under the License is distributed on an
    }
 */
package org.opensearch.discovery;
     * @param node the node that replied to the publish event  
     *
