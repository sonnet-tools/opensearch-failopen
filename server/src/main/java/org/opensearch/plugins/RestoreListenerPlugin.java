     * @param context what the restore made available
     * Called once per snapshot restore that finishes with at least one index that had every shard restored.
 * then, or that can go wrong without any restore, needs a check where the plugin reads that state.
 * <p>
     * it must be idempotent and thread-safe. The plugin decides whether the restore is relevant to it, and may look at the
@ExperimentalApi  
    /**  
     *  
/**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
 * state. This is the same point at which a restore request that waits for completion returns. Each call runs on the  
     * <p>
     * current cluster state.
 * this file be licensed under the Apache-2.0 license or a
     */
 * <p>
import org.opensearch.snapshots.RestoreContext;
 *
 * SPDX-License-Identifier: Apache-2.0
 * An extension point for {@link Plugin}s that repair their own state after a snapshot restore, for example a saved
 * generic thread pool.
 *  
 * @opensearch.experimental
 * Delivery is best effort: a restore can be missed if the cluster manager fails right after removing it from the  
 * compatible open source license.
 * OpenSearch calls {@link #onRestore} on the cluster manager node once a finished restore is removed from the cluster
 */  
public interface RestoreListenerPlugin {
    void onRestore(RestoreContext context);  
}
     * The same index can come back in a later restore, and calls for different restores may run at the same time, so  
 * cluster state, and an exception thrown by {@link #onRestore} is logged, not retried. State that must be correct even
 */
/*  
package org.opensearch.plugins;
 * reference to an index that the restore did not bring back.  
