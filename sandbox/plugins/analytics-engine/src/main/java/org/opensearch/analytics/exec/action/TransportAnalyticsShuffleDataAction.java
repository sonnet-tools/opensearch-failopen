            logger.error("Failed to process shuffle data", e);
    private final TransportService transportService;
import org.opensearch.tasks.Task;
 * </ul>
 * map to the wire protocol:
            );
                // failure (the query can never fit; waiting won't help — the q17 OOM case);
            listener.onResponse(new AnalyticsShuffleDataResponse());
 * Handles incoming shuffle payloads on a worker node. Admits each chunk against the node-level +
            // an ERROR-level stack trace (it's not a defect — debug-log the actionable detail only).
import org.opensearch.cluster.node.DiscoveryNode;
                );
                if (admit == ShuffleBufferManager.AdmitResult.REJECT_RETRY) {
    protected void doExecute(Task task, AnalyticsShuffleDataRequest request, ActionListener<AnalyticsShuffleDataResponse> listener) {
 *   <li>node total momentarily over budget while the query still fits its share → returns
 * The OpenSearch Contributors require contributions made to
                    request.getPartitionIndex(),
                        request.getSide(),
            // would let one partition's consumer observe another partition's rows and isLast
            );
    @Override
                request.getQueryId(),
                request.getPartitionIndex(),
import org.opensearch.transport.TransportException;
                ShuffleBufferManager.ShuffleBuffer buffer = shuffleBufferManager.getOrCreateBuffer(
        } catch (ShuffleBufferExceededException e) {
                );
            );
 *
import org.opensearch.threadpool.ThreadPool;
                    logger.debug(
                ShuffleBufferManager.AdmitResult admit = shuffleBufferManager.tryAdmit(
                // - throws ShuffleBufferExceededException if THIS query's footprint alone exceeds the
    private static final Logger logger = LogManager.getLogger(TransportAnalyticsShuffleDataAction.class);
                // - ACCEPTED otherwise (bytes reserved + chunk stored).
 * its bytes into the corresponding {@link ShuffleBufferManager.ShuffleBuffer}. Two budget outcomes
    }
 * forwards the request to the named target via {@link TransportService#sendRequest}. This
        ActionFilters actionFilters,
                    }
import org.apache.logging.log4j.Logger;
                /* targetNodeId */ null
        String targetNodeId = request.getTargetNodeId();
}
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
                    public AnalyticsShuffleDataResponse read(StreamInput in) throws IOException {
                request.getSide(),
        if (targetNodeId != null && !targetNodeId.equals(localNodeId)) {
                    );
                request.getPartitionIndex(),
                listener.onFailure(new IllegalStateException("Shuffle target node id '" + targetNodeId + "' not found in cluster state"));
                    request.getQueryId(),
 * enables the producer-side {@code ShuffleSenderImpl} to use the local {@code Client} (which
 * per-query on-heap byte budget ({@link ShuffleBufferManager#tryAdmit}) and, when accepted, writes
                        request.getTargetStageId(),
                        "Shuffle node over budget (retryable): query={}, stage={}, partition={}, side={}, nodeTotal={}, nodeBudget={}",
import java.io.IOException;
        this.clusterService = clusterService;
        TransportService transportService,
            listener.onFailure(e);
                return;
                e.getMessage()
public class TransportAnalyticsShuffleDataAction extends HandledTransportAction<AnalyticsShuffleDataRequest, AnalyticsShuffleDataResponse> {
                request.getTargetStageId(),
                // fits its share → backpressureReject response → ShuffleSenderRetry backs off and
                    @Override
                    request.getTargetStageId(),
            }
                        shuffleBufferManager.getTotalBytes(),
                "Shuffle query over per-query budget (fail-fast): query={}, stage={}, partition={}, side={}: {}",
 * this file be licensed under the Apache-2.0 license or a
 */
    @Inject
        ClusterService clusterService
        } catch (Exception e) {
                        listener.onResponse(response);
 * @opensearch.internal
                    @Override
                request.getQueryId(),
            logger.debug(
            }
import org.opensearch.analytics.spi.ShuffleBufferExceededException;
            // markers, silently corrupting the join.
    ) {
            // budget so it can never fit (the q17 case). Non-retryable; surface to the caller without
                request.isLast(),
                }
            // Key the buffer by (queryId, stageId, partitionIndex). Nodes may host multiple
        super(AnalyticsShuffleDataAction.NAME, transportService, actionFilters, AnalyticsShuffleDataRequest::new);
 */
                // per-query budget → caught below → listener.onFailure → terminal, NON-retryable
                    public String executor() {
            // Forward to the target worker node. Drop the targetNodeId on the forwarded copy so
                        return ThreadPool.Names.SAME;
            DiscoveryNode targetNode = clusterService.state().nodes().get(targetNodeId);
 *       {@code backpressureReject=true} so the sender retries with exponential backoff (the
 * SPDX-License-Identifier: Apache-2.0
                    request.getQueryId(),
            }
            // the receiving handler executes locally rather than re-forwarding.
import org.opensearch.cluster.service.ClusterService;
    private final ShuffleBufferManager shuffleBufferManager;
        ShuffleBufferManager shuffleBufferManager,
import org.opensearch.action.support.ActionFilters;
                forwarded,
        this.transportService = transportService;
import org.opensearch.transport.TransportService;
 *   <li>this query's OWN footprint exceeds the per-query budget (can never fit, even on an idle
                // - returns REJECT_RETRY if the NODE is momentarily over budget but this query still
                request.getSide(),
import org.apache.logging.log4j.LogManager;
import org.opensearch.transport.TransportResponseHandler;
/*
                    request.getData()
package org.opensearch.analytics.exec.action;
                    }
import org.opensearch.core.action.ActionListener;
    public TransportAnalyticsShuffleDataAction(
            if (targetNode == null) {
                    public void handleResponse(AnalyticsShuffleDataResponse response) {
                    request.getSide(),
                new TransportResponseHandler<AnalyticsShuffleDataResponse>() {
/**
                        request.getPartitionIndex(),
                    listener.onResponse(AnalyticsShuffleDataResponse.backpressureReject());
 * <ul>
                    request.getTargetStageId(),
                );
                // Admit against the NODE + PER-QUERY shuffle budgets (ShuffleBufferManager.tryAdmit):
                request.getTargetStageId(),
                buffer.senderDone(request.getSide());
 *       node) → {@link ShuffleBufferExceededException} → {@code listener.onFailure} as a fail-fast,
                AnalyticsShuffleDataAction.NAME,
            if (request.getData() != null) {
import org.opensearch.common.inject.Inject;
 *       NON-retryable error.</li>
                    public void handleException(TransportException exp) {
 * compatible open source license.
        this.shuffleBufferManager = shuffleBufferManager;
                    }
            listener.onFailure(e);
                }
                    request.getSide()
            // partitions of the same stage in small-cluster configurations; merging them here
                // retries (room frees when other queries finish and release their buffers);
                    request.getPartitionIndex(),
                request.getData(),
            transportService.sendRequest(
 * always invokes the action on the calling node) without losing per-partition routing.
                        return new AnalyticsShuffleDataResponse(in);
        try {
 *
import org.opensearch.action.support.HandledTransportAction;
        }
import org.opensearch.core.common.io.stream.StreamInput;
        String localNodeId = clusterService.localNode().getId();
 *
                    @Override
            AnalyticsShuffleDataRequest forwarded = new AnalyticsShuffleDataRequest(
    private final ClusterService clusterService;
                    "Shuffle sender done: query={}, stage={}, partition={}, side={}",
                    request.getPartitionIndex()
                    request.getQueryId(),
                logger.debug(
            return;
                        request.getQueryId(),
        }
                    request.getTargetStageId(),
                    }
                        listener.onFailure(exp);
    }
            // Expected, deliberate fail-fast: this query's footprint alone exceeds the per-query
            if (request.isLast()) {
 * <p>When {@link AnalyticsShuffleDataRequest#getTargetNodeId} is non-null and not the local node,
                        shuffleBufferManager.getNodeBudgetBytes()
 *       contention clears as other queries finish and release their buffers);</li>
                    return;
                targetNode,
                    @Override
