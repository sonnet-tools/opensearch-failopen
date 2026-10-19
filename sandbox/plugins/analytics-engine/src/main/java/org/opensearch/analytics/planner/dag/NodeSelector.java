     * @param childManifest manifest from child stage (null for leaf stages).  
 */
 * @opensearch.internal  
 * Selects the nodes a stage should execute on. Used by {@link ComposableTargetResolver}.
 * SPDX-License-Identifier: Apache-2.0
/*  
    /**
/**
 * <p>TODO: add ResourceAwareNodeSelector when cluster resource metrics are available.
 *
}
import org.opensearch.cluster.node.DiscoveryNode;
     * @param clusterState  current cluster state
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
import org.opensearch.cluster.ClusterState;
 * The OpenSearch Contributors require contributions made to  
 *  
     */
    List<DiscoveryNode> select(ClusterState clusterState, @Nullable Object childManifest);  
 *
     *                      TODO: replace Object with typed manifest once shuffle is implemented.
import java.util.List;
public interface NodeSelector {
package org.opensearch.analytics.planner.dag;
import org.opensearch.common.Nullable;  
