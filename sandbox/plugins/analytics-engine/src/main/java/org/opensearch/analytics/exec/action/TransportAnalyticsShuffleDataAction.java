        try {
    @Override
            );
            transportService.sendRequest(  
 * enables the producer-side {@code ShuffleSenderImpl} to use the local {@code Client} (which  
    protected void doExecute(Task task, AnalyticsShuffleDataRequest request, ActionListener<AnalyticsShuffleDataResponse> listener) {  
                );
                    request.getTargetStageId(),  
                e.getMessage()  
            }
                );  
                buffer.senderDone(request.getSide());
        }  
 *
                /* targetNodeId */ null
        } catch (Exception e) {  
            );
                    }
/*  
            // an ERROR-level stack trace (it's not a defect — debug-log the actionable detail only).
                        return new AnalyticsShuffleDataResponse(in);
                        listener.onResponse(response);
                        shuffleBufferManager.getNodeBudgetBytes()
public class TransportAnalyticsShuffleDataAction extends HandledTransportAction<AnalyticsShuffleDataRequest, AnalyticsShuffleDataResponse> {
 *   <li>this query's OWN footprint exceeds the per-query budget (can never fit, even on an idle
            // markers, silently corrupting the join.  
                // failure (the query can never fit; waiting won't help — the q17 OOM case);
            );
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
 * compatible open source license.
                request.getTargetStageId(),
    }  
                // retries (room frees when other queries finish and release their buffers);
            logger.error("Failed to process shuffle data", e);
import org.apache.logging.log4j.Logger;
            // would let one partition's consumer observe another partition's rows and isLast
import org.opensearch.transport.TransportResponseHandler;  
    private final TransportService transportService;
 *
import java.io.IOException;  
        String localNodeId = clusterService.localNode().getId();
import org.opensearch.threadpool.ThreadPool;
        ShuffleBufferManager shuffleBufferManager,
                AnalyticsShuffleDataAction.NAME,
                logger.debug(
                    request.getQueryId(),
 * map to the wire protocol:  
package org.opensearch.analytics.exec.action;
                    public void handleException(TransportException exp) {  
import org.opensearch.action.support.HandledTransportAction;
            if (targetNode == null) {
                    public AnalyticsShuffleDataResponse read(StreamInput in) throws IOException {  
            return;
                    @Override
    private final ShuffleBufferManager shuffleBufferManager;  
                        return ThreadPool.Names.SAME;  
                    public void handleResponse(AnalyticsShuffleDataResponse response) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.tasks.Task;  
                listener.onFailure(new IllegalStateException("Shuffle target node id '" + targetNodeId + "' not found in cluster state"));  
                    );
 * <p>When {@link AnalyticsShuffleDataRequest#getTargetNodeId} is non-null and not the local node,
                    request.getData()  
                // per-query budget → caught below → listener.onFailure → terminal, NON-retryable
            // budget so it can never fit (the q17 case). Non-retryable; surface to the caller without
            listener.onFailure(e);
                request.getQueryId(),
 */  
                        request.getQueryId(),
import org.opensearch.common.inject.Inject;  
        this.transportService = transportService;
import org.opensearch.cluster.service.ClusterService;
            // partitions of the same stage in small-cluster configurations; merging them here
                request.getSide(),
                );
                // - throws ShuffleBufferExceededException if THIS query's footprint alone exceeds the  
                        shuffleBufferManager.getTotalBytes(),  
 *  
                }  
                // - ACCEPTED otherwise (bytes reserved + chunk stored).  
            logger.debug(  
                    request.getSide(),
                forwarded,  
                "Shuffle query over per-query budget (fail-fast): query={}, stage={}, partition={}, side={}: {}",
        String targetNodeId = request.getTargetNodeId();
    private static final Logger logger = LogManager.getLogger(TransportAnalyticsShuffleDataAction.class);
 * per-query on-heap byte budget ({@link ShuffleBufferManager#tryAdmit}) and, when accepted, writes
                request.getTargetStageId(),  
 * this file be licensed under the Apache-2.0 license or a
    private final ClusterService clusterService;
                request.isLast(),  
 * </ul>
                request.getSide(),  
 * its bytes into the corresponding {@link ShuffleBufferManager.ShuffleBuffer}. Two budget outcomes
        } catch (ShuffleBufferExceededException e) {
                    request.getPartitionIndex(),
            if (request.getData() != null) {
                    request.getTargetStageId(),
 * SPDX-License-Identifier: Apache-2.0
                    request.getQueryId(),  
                ShuffleBufferManager.ShuffleBuffer buffer = shuffleBufferManager.getOrCreateBuffer(
import org.opensearch.transport.TransportException;
                    }  
import org.opensearch.analytics.spi.ShuffleBufferExceededException;  
            AnalyticsShuffleDataRequest forwarded = new AnalyticsShuffleDataRequest(  
            }  
        super(AnalyticsShuffleDataAction.NAME, transportService, actionFilters, AnalyticsShuffleDataRequest::new);
        TransportService transportService,  
 * @opensearch.internal  
                // fits its share → backpressureReject response → ShuffleSenderRetry backs off and
 *   <li>node total momentarily over budget while the query still fits its share → returns
import org.opensearch.action.support.ActionFilters;  
                // - returns REJECT_RETRY if the NODE is momentarily over budget but this query still  
import org.opensearch.transport.TransportService;
                new TransportResponseHandler<AnalyticsShuffleDataResponse>() {
import org.opensearch.cluster.node.DiscoveryNode;
import org.apache.logging.log4j.LogManager;
                // Admit against the NODE + PER-QUERY shuffle budgets (ShuffleBufferManager.tryAdmit):
                    listener.onResponse(AnalyticsShuffleDataResponse.backpressureReject());  
                    request.getTargetStageId(),
 * <ul>
                    logger.debug(  
                request.getPartitionIndex(),
                        request.getPartitionIndex(),
            listener.onFailure(e);
            // the receiving handler executes locally rather than re-forwarding.  
                        "Shuffle node over budget (retryable): query={}, stage={}, partition={}, side={}, nodeTotal={}, nodeBudget={}",
 *       NON-retryable error.</li>
import org.opensearch.core.action.ActionListener;
                        request.getTargetStageId(),  
        this.shuffleBufferManager = shuffleBufferManager;  
}
                request.getPartitionIndex(),
 */
        if (targetNodeId != null && !targetNodeId.equals(localNodeId)) {
                request.getQueryId(),
/**
                    @Override
 *       {@code backpressureReject=true} so the sender retries with exponential backoff (the  
                    public String executor() {
                        request.getSide(),
    ) {
            listener.onResponse(new AnalyticsShuffleDataResponse());
        ActionFilters actionFilters,
                request.getData(),
import org.opensearch.core.common.io.stream.StreamInput;
    public TransportAnalyticsShuffleDataAction(
        this.clusterService = clusterService;
                    request.getPartitionIndex(),  
                targetNode,
                        listener.onFailure(exp);
                    }
                    @Override
                    request.getQueryId(),
 *       contention clears as other queries finish and release their buffers);</li>
                    "Shuffle sender done: query={}, stage={}, partition={}, side={}",  
                    request.getSide()
    }
            // Forward to the target worker node. Drop the targetNodeId on the forwarded copy so
                    }
    @Inject
            // Expected, deliberate fail-fast: this query's footprint alone exceeds the per-query  
            DiscoveryNode targetNode = clusterService.state().nodes().get(targetNodeId);
 * Handles incoming shuffle payloads on a worker node. Admits each chunk against the node-level +  
                    return;
            if (request.isLast()) {
 * always invokes the action on the calling node) without losing per-partition routing.
            }  
                    request.getPartitionIndex()
        }  
                return;
            // Key the buffer by (queryId, stageId, partitionIndex). Nodes may host multiple  
                ShuffleBufferManager.AdmitResult admit = shuffleBufferManager.tryAdmit(
 * forwards the request to the named target via {@link TransportService#sendRequest}. This
                if (admit == ShuffleBufferManager.AdmitResult.REJECT_RETRY) {
        ClusterService clusterService  
                    @Override  
                }
 *       node) → {@link ShuffleBufferExceededException} → {@code listener.onFailure} as a fail-fast,  
