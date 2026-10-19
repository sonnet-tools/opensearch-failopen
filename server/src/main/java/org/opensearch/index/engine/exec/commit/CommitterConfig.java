/*  
 * because the shared writer has no matching segments), the merge-apply callback handles  
 *  
 * The OpenSearch Contributors require contributions made to  
 * <p>For merges that never reach the hook (pure Parquet merges, or Lucene merges that skip
 * <p>{@code preMergeCommitHook} is invoked by committers that own writers participating in
public record CommitterConfig(EngineConfig engineConfig, Runnable preMergeCommitHook, boolean isReplica) {
 * @param engineConfig         engine configuration
 * between {@code mergeMiddle} and {@code commitMerge}, while the underlying writer's
    public CommitterConfig(EngineConfig engineConfig, Runnable preMergeCommitHook) {
}
 * ready but before it is made visible. The hook is expected to run on the merge thread  
 *                             visible; ownership of anything it acquires is transferred to  
 * inside {@code commitMerge}. Any ownership acquired by the hook is transferred to the
 * Initialization parameters for a {@link Committer}.
 * avoiding the lock inversion that would occur if the engine acquired the refresh lock
 * @param preMergeCommitHook   hook run on the merge thread before a merged segment is made
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
    }  
 * merges (e.g. the Lucene {@code MergeIndexWriter}) at the moment a merged segment becomes
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        this(engineConfig, preMergeCommitHook, false);
/**
 */  
 * acquisition so that merge-thread visibility is serialised against concurrent refreshes,  
import org.opensearch.common.annotation.ExperimentalApi;
 * coordination on its own. Committers that do not need this coordination may install the
 *                             the engine's merge-apply callback
 *  
 */  
 *
 * hook but take no action when it fires.
import org.opensearch.index.engine.EngineConfig;
 * engine's merge-apply callback, which releases it after the catalog is updated.  
 *
package org.opensearch.index.engine.exec.commit;
 * exclusive monitor is <em>not</em> held. The engine wires this hook to refresh-lock
