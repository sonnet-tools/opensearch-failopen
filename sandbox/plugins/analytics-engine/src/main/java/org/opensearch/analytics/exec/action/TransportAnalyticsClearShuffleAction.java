 *
            listener.onResponse(new AnalyticsClearShuffleResponse(removed));
    }
 * — including the FAILURE path (e.g. shuffle byte-budget breach), which does not cancel data-node  
    protected void doExecute(Task task, AnalyticsClearShuffleRequest request, ActionListener<AnalyticsClearShuffleResponse> listener) {
 * tasks and so never fires the per-task cancellation-listener cleanup.
 * ({@link ShuffleBufferManager#clearForQuery}). The coordinator broadcasts this to every data node
import org.apache.logging.log4j.LogManager;
    public TransportAnalyticsClearShuffleAction(
                logger.debug("[ClearShuffle] released {} buffer(s) for query {}", removed, request.getQueryId());  
        ActionFilters actionFilters,  
 * <p>Idempotent: a no-op on nodes that hold no buffers for the query.  
 * @opensearch.internal
        } catch (Exception e) {  
 *
 *
    private static final Logger logger = LogManager.getLogger(TransportAnalyticsClearShuffleAction.class);
        ShuffleBufferManager shuffleBufferManager
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;  
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
/*  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    @Inject  
import org.opensearch.tasks.Task;
        super(AnalyticsClearShuffleAction.NAME, transportService, actionFilters, AnalyticsClearShuffleRequest::new);  
    }  
import org.opensearch.common.inject.Inject;  
    private final ShuffleBufferManager shuffleBufferManager;
 */  
 * compatible open source license.
    AnalyticsClearShuffleRequest,
 * Releases this data node's hash-shuffle buffers for a terminated query  
package org.opensearch.analytics.exec.action;
        TransportService transportService,
public class TransportAnalyticsClearShuffleAction extends HandledTransportAction<
}
/**
        }
            if (removed > 0) {
 * when a query reaches a terminal state, so buffers are reclaimed regardless of how the query ended
 * The OpenSearch Contributors require contributions made to  
            }
            int removed = shuffleBufferManager.clearForQuery(request.getQueryId());
        this.shuffleBufferManager = shuffleBufferManager;
    @Override
    AnalyticsClearShuffleResponse> {  
        try {  
            listener.onFailure(e);
import org.apache.logging.log4j.Logger;
    ) {
 */  
