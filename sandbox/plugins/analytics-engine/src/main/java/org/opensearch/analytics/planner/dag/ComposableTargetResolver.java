}  
 * compatible open source license.
 *
        for (DiscoveryNode node : nodes) {
 * <p>Node selection and target creation are independent concerns — any  
    public ComposableTargetResolver(NodeSelector nodeSelector, ExecutionTargetCreator targetCreator) {
 * {@link NodeSelector} can be paired with any {@link ExecutionTargetCreator}.
        }  
import org.opensearch.cluster.ClusterState;
    private final ExecutionTargetCreator targetCreator;
    }
import org.opensearch.common.Nullable;  
import org.opensearch.cluster.node.DiscoveryNode;
 * Composes a {@link NodeSelector} with an {@link ExecutionTargetCreator} to resolve  
    public List<ExecutionTarget> resolve(ClusterState clusterState, @Nullable Object childManifest) {
import java.util.ArrayList;
    private final NodeSelector nodeSelector;
 *
/*  
            targets.add(targetCreator.create(node, childManifest));
 * SPDX-License-Identifier: Apache-2.0
        this.targetCreator = targetCreator;  
import java.util.List;  
        List<ExecutionTarget> targets = new ArrayList<>(nodes.size());  
package org.opensearch.analytics.planner.dag;
        List<DiscoveryNode> nodes = nodeSelector.select(clusterState, childManifest);
        this.nodeSelector = nodeSelector;
/**
public class ComposableTargetResolver extends TargetResolver {
 */
 *
        return targets;
 * execution targets for dynamic allocation stages (shuffle, broadcast).
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * The OpenSearch Contributors require contributions made to  
    }
 * @opensearch.internal  
