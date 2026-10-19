import java.util.List;
public class PickRandomNodeSelector implements NodeSelector {  
        this.count = count;
import org.opensearch.cluster.ClusterState;
    public List<DiscoveryNode> select(ClusterState clusterState, @Nullable Object childManifest) {  
/*  
/**
 */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNode;
 * @opensearch.internal
 *  
import org.opensearch.common.Nullable;  
 *
 * compatible open source license.
    }  
 * <p>TODO: implement ResourceAwareNodeSelector as an alternative that picks nodes
 * this file be licensed under the Apache-2.0 license or a
 *  
    public PickRandomNodeSelector(int count) {
 */  
    }  
 * Selects N random data nodes from the cluster for shuffle partition assignment.
    private final int count;
package org.opensearch.analytics.planner.dag;
 * based on available memory and disk metrics.
        throw new UnsupportedOperationException("PickRandomNodeSelector not yet implemented");
    @Override
}
        // TODO: implement when shuffle aggregates/joins are added.
