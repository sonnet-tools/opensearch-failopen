package org.opensearch.analytics.planner.dag;
 * compatible open source license.
 */  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Nullable;
 *
     */  
public interface ExecutionTargetCreator {  
import org.opensearch.cluster.node.DiscoveryNode;
     *                      TODO: replace Object with typed manifest once shuffle is implemented.
 * Creates an {@link ExecutionTarget} for a specific node. Used by {@link ComposableTargetResolver}.
     * @param node          the node selected by {@link NodeSelector}  
 *  
    ExecutionTarget create(DiscoveryNode node, @Nullable Object childManifest);
 * when shuffle aggregates, joins, and broadcast joins are implemented.
/**
 *  
 * this file be licensed under the Apache-2.0 license or a
    /**
/*  
 */
 * <p>TODO: add ShuffleStreamExecutionTargetCreator, InMemoryExecutionTargetCreator
 * SPDX-License-Identifier: Apache-2.0
     * @param childManifest manifest from child stage (null for leaf stages).
}
