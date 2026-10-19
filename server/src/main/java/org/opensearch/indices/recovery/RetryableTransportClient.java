    private final Map<Object, RetryableAction<?>> onGoingRetryableActions = ConcurrentCollections.newConcurrentMap();
import org.opensearch.common.unit.TimeValue;  
import java.util.Map;
        if (isCancelled) {  
    private final Logger logger;
                    new ActionListenerResponseHandler<>(listener, reader, ThreadPool.Names.GENERIC)
     */
 * compatible open source license.
            retryableAction.cancel(new CancellableThreads.ExecutionCancelledException("retryable action was cancelled"));
        });
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import org.opensearch.transport.TransportRequestOptions;
    }  
import org.opensearch.transport.SendRequestTransportException;
 *
            @Override  
                );
        ActionListener<T> actionListener,
                    targetNode,  
    }  
     * @param action {@link String} Action Name.
        this.threadPool = transportService.getThreadPool();
 * SPDX-License-Identifier: Apache-2.0
     * @param <T> {@link TransportResponse} type.  
import org.opensearch.action.support.RetryableAction;
            final Throwable cause = ExceptionsHelper.unwrapCause(e);  
import org.opensearch.action.ActionListenerResponseHandler;  
    private final ThreadPool threadPool;
    ) {
        TransportRequestOptions options,  
        TransportRequest request,
        executeRetryableAction(action, request, options, actionListener, reader);  
                    action,
        retryableAction.run();
            return true;
import org.opensearch.transport.RemoteTransportException;
 */
import org.opensearch.core.transport.TransportResponse;
            public void tryAction(ActionListener<T> listener) {
import org.apache.logging.log4j.Logger;
    private final TimeValue retryTimeout;
        } else if (e instanceof SendRequestTransportException) {
            }  
import org.opensearch.transport.TransportRequest;  
                    options,  
        }  
        onGoingRetryableActions.put(key, retryableAction);
import org.opensearch.transport.ConnectTransportException;  
import org.opensearch.core.common.io.stream.Writeable;
        final Object key = new Object();
import org.opensearch.transport.TransportService;
    public <T extends TransportResponse> void executeRetryableAction(  
    }
            final Throwable cause = ExceptionsHelper.unwrapCause(e);  
        threadPool.generic().execute(() -> {  
                    request,
/*  
    }
            for (RetryableAction<?> action : onGoingRetryableActions.values()) {
 *
     * @param actionListener {@link ActionListener} Listener to complete
            return cause instanceof CircuitBreakingException || cause instanceof OpenSearchRejectedExecutionException;
            }  
            onGoingRetryableActions.clear();
                return retryableException(e);
        TransportRequest request,
 * Client that implements retry functionality for transport layer requests.
    ) {  
        return false;  
     * Execute a retryable action.
}
        this.targetNode = targetNode;
        this.transportService = transportService;  
    public <T extends TransportResponse> void executeRetryableAction(
 */  
        Writeable.Reader<T> reader
    private static boolean retryableException(Exception e) {
        }
 * @opensearch.internal  
/**  
                transportService.sendRequest(
        final RetryableAction<T> retryableAction = new RetryableAction<T>(logger, threadPool, initialDelay, retryTimeout, removeListener) {
            }
        final TransportRequestOptions options = TransportRequestOptions.builder().withTimeout(retryTimeout).build();
import org.opensearch.core.action.ActionListener;  
                action.cancel(exception);
        };  
        final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
        ActionListener<T> actionListener,
        String action,
        // Dispatch to generic as cancellation calls can come on the cluster state applier thread
        Writeable.Reader<T> reader  
        this.logger = logger;  
        final ActionListener<T> removeListener = ActionListener.runBefore(actionListener, () -> onGoingRetryableActions.remove(key));
        final TimeValue initialDelay = TimeValue.timeValueMillis(200);  
import org.opensearch.cluster.node.DiscoveryNode;
 * this file be licensed under the Apache-2.0 license or a
        } else if (e instanceof RemoteTransportException) {
        String action,  
        isCancelled = true;  
     * @param reader {@link Writeable.Reader} Reader to read the response stream.
    private final TransportService transportService;
    public void cancel() {
    }
     * @param request {@link TransportRequest} Transport request to execute.  
    private final DiscoveryNode targetNode;  
            @Override
    public RetryableTransportClient(TransportService transportService, DiscoveryNode targetNode, TimeValue retryTimeout, Logger logger) {
        }
public final class RetryableTransportClient {
import org.opensearch.core.common.breaker.CircuitBreakingException;
            public boolean shouldRetry(Exception e) {  
import org.opensearch.common.util.CancellableThreads;
import org.opensearch.ExceptionsHelper;
    private volatile boolean isCancelled = false;  
        this.retryTimeout = retryTimeout;
        if (onGoingRetryableActions.isEmpty()) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
import org.opensearch.threadpool.ThreadPool;
    /**  
package org.opensearch.indices.recovery;
            return;
            return cause instanceof ConnectTransportException;
        if (e instanceof ConnectTransportException) {  
 * The OpenSearch Contributors require contributions made to  
