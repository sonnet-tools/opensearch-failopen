        clusterApplier.setInitialState(bootstrapClusterState);  
    @Override
        this.clusterApplier = clusterApplier;  
}  
import org.opensearch.cluster.ClusterChangedEvent;
import org.opensearch.cluster.NodeConnectionsService;  
/*  
import org.opensearch.cluster.node.DiscoveryNode;  
    }
    }
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            .nodes(DiscoveryNodes.builder().localNodeId(localNode.getId()).add(localNode).build())
 * this file be licensed under the Apache-2.0 license or a
/**
import org.opensearch.transport.TransportService;  
import org.opensearch.cluster.coordination.PendingClusterStateStats;
 * SPDX-License-Identifier: Apache-2.0
    public DiscoveryStats stats() {
    @Override
    @Override  
        throw new UnsupportedOperationException("Should not be called in clusterless mode");  
import org.opensearch.cluster.service.ClusterStateStats;  
 * compatible open source license.
 * Clusterless implementation of Discovery. This is only able to "discover" the local node.
    private static final DiscoveryStats EMPTY_STATS = new DiscoveryStats(
    protected void doStop() {
 */  
public class LocalDiscovery extends AbstractLifecycleComponent implements Discovery {
    }  
        this.transportService = transportService;
    }
    @Override  
    );  
 */  
    public void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {  
        new PendingClusterStateStats(0, 0, 0),  
    }
import java.io.IOException;
    public void startInitialJoin() {
    public void publish(ClusterChangedEvent clusterChangedEvent, ActionListener<Void> publishListener, AckListener ackListener) {
    protected void doStart() {
    @Override
import org.opensearch.cluster.node.DiscoveryNodes;
    }  
    @Override  
import org.opensearch.cluster.ClusterState;
        new ClusterStateStats()
        ClusterState bootstrapClusterState = ClusterState.builder(ClusterState.EMPTY_STATE)  
import org.opensearch.cluster.service.ClusterApplier;
        new PublishClusterStateStats(0, 0, 0),
    protected void doClose() throws IOException {  
            .build();
        return EMPTY_STATS;  
    private final TransportService transportService;
    }
 * The OpenSearch Contributors require contributions made to  
        // In clusterless mode, we should never be asked to publish a cluster state.
    @Override  
    }
import org.opensearch.core.action.ActionListener;
 *
        DiscoveryNode localNode = transportService.getLocalNode();
package org.opensearch.discovery;
    private final ClusterApplier clusterApplier;
    public LocalDiscovery(TransportService transportService, ClusterApplier clusterApplier) {
import org.opensearch.cluster.coordination.PublishClusterStateStats;
