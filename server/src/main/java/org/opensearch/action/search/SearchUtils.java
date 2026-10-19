import org.opensearch.transport.RemoteClusterService;
 */  
import java.util.Set;
        Set<String> clusters
/*  
     */
import org.opensearch.core.action.ActionListener;
}
        ClusterState state,
        return lookupListener;
        final StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = new StepListener<>();
import org.opensearch.action.StepListener;
package org.opensearch.action.search;
        } else {
/**
    }  
        RemoteClusterService remoteClusterService,  
import java.util.function.BiFunction;
            remoteClusterService.collectNodes(clusters, lookupListener);  
    public static ActionListener<BiFunction<String, String, DiscoveryNode>> getConnectionLookupListener(
     * Get connection lookup listener for list of clusters passed  
 * The OpenSearch Contributors require contributions made to  
public class SearchUtils {
        if (clusters.isEmpty()) {  
 */  
 * Helper class for common search functions
    public SearchUtils() {}  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 *
    /**
    ) {  
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.node.DiscoveryNode;  
            lookupListener.onResponse((cluster, nodeId) -> state.getNodes().get(nodeId));
