    SHARD_FRAGMENT,
     * fetched columns back by row position, and emits the wrapper's output schema
    /**
     * and any residual coordinator-side reduction the backend owns. Child
     * upstream. No Substrait fragment — the stage execution drives fetch transport
 */  
     */  
    WORKER_FRAGMENT,  
     * stages sitting above children that already produced the final rows.
     * output, fans out fetch-by-rowid requests to data nodes (one per UGSI), stitches  
     * Runs at the coordinator as a pure gather — no backend compute, no
     * whose data lives on the coordinator rather than on a shard.  
    /**
 *
     * QTF (late-materialization) Scatter-Gather stage. Drains the upstream Sort+Limit
    COORDINATOR_REDUCE,
     * Runs the fragment locally on the coordinator via the backend's in-process  
    /**
public enum StageExecutionType {
 * used by {@code StageExecutionBuilder} to look up the scheduler for the stage.  
 */  
     * stage's fragment.
/**
     * Fragment dispatched per-shard to data nodes; responses are row batches.  
     * fragment dispatch. The walker attaches a {@code RowProducingSink} and
     * No shard scan; the fragment reads only from named-input streams registered by
    /**  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.planner.dag;
/*  
    LOCAL_COMPUTE,
     * literal-row sources ({@code LogicalValues}) and any future leaf operator
     * (from {@code ExchangeSinkProvider}). Used for final aggregation, sort,
 * compatible open source license.
     * Used by scans, filters, partial aggregates, and anything else that runs
     * accumulates child output directly. Used only for root/parent gather  
    /**  
    /**
     * A single-stage query that scans shards is {@link #SHARD_FRAGMENT}, not this.
 * SPDX-License-Identifier: Apache-2.0
     */
     */
     */
     */
     * Hash-shuffle worker: one fragment per partition, dispatched to a worker node.
     * Runs at the coordinator with a backend-provided {@code ExchangeSink}  
 *
    LATE_MATERIALIZATION  
     * SHARD_FRAGMENT stage outputs are fed into the sink.  
 * The OpenSearch Contributors require contributions made to  
     * execution engine. No shard dispatch, no children expected. Used for
 * Classifies a stage by its execution shape (dispatch target + response shape),
    LOCAL_PASSTHROUGH,
     * directly. Marked by an {@code OpenSearchLateMaterialization} node in the  
     * a shard-local fragment producing rows.
     */  
     * a separate transport ({@code WorkerFragmentExecutionAction}).
}
 * @opensearch.internal
     * shuffle-scan instructions. Sibling of {@link #SHARD_FRAGMENT} but routed through  
