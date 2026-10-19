/**
     * Fires the listener exactly once — {@code onResponse} with the root output's
     *         (e.g. profiling). Callers that don't need it may ignore the return value.
 *
     */  
import org.apache.arrow.vector.VectorSchemaRoot;
 * to layer retries at the query level) can plug in without touching call sites.  
 * Coordinator-side query control flow. Given a {@link QueryContext}, drives the
     * for wrapping the listener with any caller-side cleanup hooks (task  
 */  
 *
     * Drives the query described by {@code config} to completion. Never blocks.
     * unregister, etc.) — the scheduler's single-fire guarantee on the listener
package org.opensearch.analytics.exec;
     * @return the {@link QueryExecution} driving this query, for post-execution inspection
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
public interface Scheduler {
 * a {@link QueryExecution} using state listeners. The interface stays so an
 */  
 * @opensearch.internal
     * makes {@link ActionListener#runAfter} the natural place to attach them.
 * query to completion and signals the caller via an {@link ActionListener}.  
 * {@link ExecutionGraph} via {@link ExecutionGraph#build} and drives it through  
 *
    /**  
}
     * is responsible for any row materialization needed at the external API and
    QueryExecution execute(QueryContext context, ActionListener<Iterable<VectorSchemaRoot>> listener);
 * alternative orchestration strategy (e.g. one that wraps the existing scheduler
     * Arrow batches on success, {@code onFailure} with the captured cause on  
     * failure or cancellation. The caller (e.g., {@code DefaultPlanExecutor})
 * <p>One implementation: {@link QueryScheduler}, which builds an
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
/*  
     *  
import org.opensearch.core.action.ActionListener;
