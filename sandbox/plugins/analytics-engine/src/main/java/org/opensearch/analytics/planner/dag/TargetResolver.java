 * SPDX-License-Identifier: Apache-2.0
    /**  
     * @param childManifest manifest returned by the child stage (null for leaf stages).
 * </ul>  
 * DAG construction. Called lazily by the Scheduler just before dispatch.
     */
public abstract class TargetResolver {
 *
 * Resolves execution targets for a {@link Stage}. Attached at plan time during
/*  
import org.opensearch.common.Nullable;
 */  
import org.opensearch.cluster.ClusterState;
}  
 *       {@link ExecutionTargetCreator} for dynamic allocation (shuffle, broadcast)</li>
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
package org.opensearch.analytics.planner.dag;
 * <p>Implementations:
 *   <li>{@link ComposableTargetResolver} — composes a {@link NodeSelector} with an
     * Resolves execution targets for this stage.
 *
     *
     * @param clusterState  current cluster state  
 *   <li>{@link ShardTargetResolver} — resolves shard targets from ClusterState</li>  
     *                      TODO: replace Object with a typed ShuffleManifest/BroadcastManifest
 * <ul>
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
    public abstract List<ExecutionTarget> resolve(ClusterState clusterState, @Nullable Object childManifest);
 */  
 * compatible open source license.
     *                      once shuffle and broadcast are implemented.  
 *  
/**  
