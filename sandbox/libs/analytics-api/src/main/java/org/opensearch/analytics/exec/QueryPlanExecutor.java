     *
 * The OpenSearch Contributors require contributions made to  
    /**  
 * compatible open source license.
    }  
     * Executes the given logical fragment with profiling enabled. Captures per-stage
     * Executes the given logical fragment and delivers the result stream (or a failure)
/*  
 * Executes a logical query plan fragment against the underlying data store.  
     * @param plan     the logical subtree to execute
     * to {@code listener}.
    void execute(LogicalPlan plan, QueryRequestContext queryCtx, ActionListener<Stream> listener);
     * @param plan     the logical subtree to execute  
     * containing both the query results and the profile snapshot.
     * timing from the coordinator's perspective and delivers a {@link ProfiledResult}  
 * this file be licensed under the Apache-2.0 license or a
     * @param listener receives the produced stream on success, or the failure cause on error  
public interface QueryPlanExecutor<LogicalPlan, Stream> {
}
 *
     */
     * @param queryCtx per-query snapshot ({@code null} → executor reads a fresh cluster state)
    /**
import org.opensearch.analytics.exec.profile.ProfiledResult;
        listener.onFailure(new UnsupportedOperationException(getClass().getSimpleName() + " does not support executeWithProfile"));
     * @param listener receives the profiled result on success, or the failure cause on error
 * @opensearch.internal
    default void executeWithProfile(LogicalPlan plan, QueryRequestContext queryCtx, ActionListener<ProfiledResult> listener) {
     *  
package org.opensearch.analytics.exec;
 *
 * SPDX-License-Identifier: Apache-2.0
     */  
 */  
import org.opensearch.analytics.QueryRequestContext;
/**
 */  
     * @param queryCtx per-query snapshot ({@code null} → executor reads a fresh cluster state)
import org.opensearch.core.action.ActionListener;  
