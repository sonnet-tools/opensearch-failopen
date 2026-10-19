import org.opensearch.action.ActionType;
        super(NAME, AnalyticsClearShuffleResponse::new);
 * <p>Needed because a query that FAILS (e.g. on the shuffle byte budget) does not cancel the
public class AnalyticsClearShuffleAction extends ActionType<AnalyticsClearShuffleResponse> {
/*  
 * Transport action the coordinator broadcasts to every data node when a query reaches a terminal
 * compatible open source license.
    }
package org.opensearch.analytics.exec.action;
 *
    public static final String NAME = "indices:data/read/analytics/shuffle/clear";  
 *
 * SPDX-License-Identifier: Apache-2.0
 */  
 * is correct and cheap (no need to track the exact participating set).  
 * this file be licensed under the Apache-2.0 license or a
    public static final AnalyticsClearShuffleAction INSTANCE = new AnalyticsClearShuffleAction();
 * @opensearch.internal
 * holds for that query ({@code ShuffleBufferManager.clearForQuery}).  
 * and a no-op on nodes that hold no buffers for the query, so a blanket broadcast to all data nodes
    private AnalyticsClearShuffleAction() {  
 * state (success / failure / cancel), instructing the node to release any hash-shuffle buffers it
 * The OpenSearch Contributors require contributions made to  
 * Arrow-IPC {@code byte[]} on-heap until the next query OOMs. {@code clearForQuery} is idempotent
/**  
 */  
}  
 *
 * data-node tasks, so the per-task cancellation-listener cleanup never fires — leaving the buffered  
