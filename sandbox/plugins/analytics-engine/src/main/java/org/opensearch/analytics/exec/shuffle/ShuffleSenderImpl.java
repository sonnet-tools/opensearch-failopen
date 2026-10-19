                        + partitionIndex
                    );  
                    listener.onResponse(null);  
                ThreadPool.Names.GENERIC
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataRequest;
 * this file be licensed under the Apache-2.0 license or a
                        + ", partition="  
package org.opensearch.analytics.exec.shuffle;
            data == null || data.length == 0 ? null : data,  
                                    + ", target="
                public void onResponse(AnalyticsShuffleDataResponse response) {  
                @Override  
                        + "' not found in cluster state for queryId="  
                            + ", target="
                        return;
                        // sink stamps firstError and the producer fragment fails the query.  
                        + ", side="
                org.opensearch.common.unit.TimeValue.timeValueMillis(delayMs),
                        + side
                                    + ", stage="
        this.client = client;
                }
            listener.onFailure(
                        listener.onFailure(
import org.opensearch.cluster.node.DiscoveryNode;
    private final int targetStageId;  
 */  
                            + ", side="
                                    + ", partition="  
 *  
                        + targetWorkerNodeId
    private final String side;
            request,  
                )
            (req, l) -> client.execute(AnalyticsShuffleDataAction.INSTANCE, req, l),
            return;
                            + ", partition="  
                                "Shuffle send rejected after retry exhaustion (queryId="  
                }
                        "Shuffle send failed (queryId="  
                        );  
            targetWorkerNodeId
        String queryId,
import org.opensearch.cluster.service.ClusterService;
                new IllegalStateException(  
    ) {
                            + targetWorkerNodeId  
        );
 * SPDX-License-Identifier: Apache-2.0
                            + ")",
            (delayMs, runnable) -> threadPool.schedule(
        Client client,
        this.targetStageId = targetStageId;  
        this.side = side;
        int targetStageId,
        this.queryId = queryId;
        ShuffleSenderRetry.sendWithRetry(
                            + queryId
 * <p>Backpressure handling: each send goes through {@link ShuffleSenderRetry} so a
        );  
                        // Retry budget exhausted on backpressure — surface as a failure so the
 * Framework implementation of {@link ShuffleSender} that wires backend partitioned sinks to the
    @Override
                            new RuntimeException(
    }
            new ActionListener<>() {
                                    + targetWorkerNodeId  
                    LOGGER.debug(
        this.clusterService = clusterService;
/*  
    private final Client client;
}  
                    }
import org.opensearch.analytics.spi.ShuffleSender;  
import org.opensearch.transport.client.Client;
                                    + partitionIndex
                            + side
                    listener.onFailure(e);
                        + queryId
        String side  
public final class ShuffleSenderImpl implements ShuffleSender {
                        + ", stage="
            partitionIndex,
            }  
            side,
        DiscoveryNode targetNode = clusterService.state().nodes().get(targetWorkerNodeId);  
    private final ClusterService clusterService;
 * {@code (queryId, targetStageId, side)} so the receiver routes payloads into the correct
    public void send(String targetWorkerNodeId, int partitionIndex, byte[] data, boolean isLast, ActionListener<Void> listener) {
                        + targetStageId  
 * <p>Routing: the sender does not route by remote node directly — it dispatches via the local  
        ThreadPool threadPool,
                                    + ", side="
    private final ThreadPool threadPool;  
                        e
 *
 * {@code backpressureRejected=true} response triggers exponential-backoff retry. Backends never
                                    + side
 *
                                    + ")"
            );  
 * {@link ActionListener#onFailure} on retry exhaustion / non-backpressure error.
import org.apache.logging.log4j.LogManager;
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataResponse;
                    if (response.isBackpressureRejected()) {
            isLast,
                @Override
    private final String queryId;
                            )
 *
        this.threadPool = threadPool;  
import org.opensearch.threadpool.ThreadPool;
                            + partitionIndex
        ClusterService clusterService,  
                runnable,  
 * @opensearch.internal
                            + ", stage="
            ),  
 * through the standard {@code RemoteClusterClient} path. This is the same shape OLAP's
                            + targetStageId  
            targetStageId,  
 * see backpressure; they get a single {@link ActionListener#onResponse} on success or  
 * shuffle transport without exposing transport types to backends. Stamps every send with  
    public ShuffleSenderImpl(  
                public void onFailure(Exception e) {
        if (targetNode == null) {
    private static final Logger LOGGER = LogManager.getLogger(ShuffleSenderImpl.class);  
                    "ShuffleSenderImpl: target node id '"
import org.opensearch.core.action.ActionListener;  
 * compatible open source license.
            queryId,
 * node's {@link Client}, which the action's transport layer fans out to {@code targetWorkerNodeId}
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataAction;  
    }
                                    + targetStageId  
import org.apache.logging.log4j.Logger;
 * {@code ShuffleSender} uses and avoids duplicating connection lookup.  
        }
 * The OpenSearch Contributors require contributions made to  
/**
        AnalyticsShuffleDataRequest request = new AnalyticsShuffleDataRequest(
                                    + queryId
 */  
 * buffer slice on the consumer's node.
