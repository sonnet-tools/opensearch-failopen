    public static int resolve(Settings settings, ClusterState state, CapabilityRegistry registry, List<String> viableBackends) {
 *
 *   <li>Otherwise, the maximum of {@code defaultShuffleParallelism(clusterState)} across the
            if (n > max) max = n;
 *
 */  
 *       max ensures we don't artificially under-size when at least one viable backend supports
 * <p>Returns {@code 1} if no backend opts in. Callers should treat {@code partitionCount ≤ 1}
 *       {@code 1}; backends that do return a real count (typically the data-node count). The  
/**  
    }
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
        }
 *       given viable backends. Backends that don't participate in MPP shuffle return
 *       shuffle.</li>
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
        }
 * SPDX-License-Identifier: Apache-2.0
public final class MppShufflePartitions {
import org.opensearch.analytics.planner.CapabilityRegistry;
            AnalyticsSearchBackendPlugin backend = registry.getBackend(backendId);
            int n = backend.defaultShuffleParallelism(state);  
import org.opensearch.cluster.ClusterState;
        Integer override = AnalyticsSettings.MPP_SHUFFLE_PARTITIONS.get(settings);
 * compatible open source license.
 * fire and the strategy advisor falls back to BROADCAST or COORDINATOR_CENTRIC.
 *       override pinning the count.</li>  
 *
 * <p>Resolution order:  
 *   <li>{@link AnalyticsSettings#MPP_SHUFFLE_PARTITIONS} cluster setting if positive — operator
}
    /** Resolves the partition count using settings + the registry's view of viable backends. */  
import org.opensearch.common.settings.Settings;
 * Single source of truth for resolving the hash-shuffle partition count.
        if (override != null && override > 0) {  
/*  
            return override;
 */
import java.util.List;
 * <ol>
package org.opensearch.analytics.exec.join;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.AnalyticsSettings;
        int max = 1;  
        return max;  
    private MppShufflePartitions() {}
 *
        for (String backendId : viableBackends) {
 * </ol>  
 * as "shuffle is disabled for this join" — the {@code OpenSearchHashJoinSplitRule} refuses to  
