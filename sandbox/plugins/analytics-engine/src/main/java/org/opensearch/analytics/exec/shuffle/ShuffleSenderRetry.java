        long initialBackoffMillis,
 *
        AnalyticsShuffleDataRequest request,  
public final class ShuffleSenderRetry {
 * {@code maxAttempts}. Retrying is non-optional — the worker's transport handler must not block  
import org.apache.logging.log4j.LogManager;
    private static final long DEFAULT_INITIAL_BACKOFF_MILLIS = 50;
                        "Shuffle sender gave up after {} attempts for query={}, stage={}, partition={}",
 * (OpenSearch transport threads), so a full buffer translates to a reject + sender retry.
    private ShuffleSenderRetry() {}
    ) {
            }
     * @param scheduler      schedules a Runnable after a given millis delay — one call per retry
        sender.accept(request, new ActionListener<>() {
        });
            @Override  
    public static void sendWithRetry(
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender,
                finalListener.onFailure(e);  
    }  
                }
                    backoff,
            @Override  
                LOGGER.debug(  
    private static final int DEFAULT_MAX_ATTEMPTS = 8;  
     *                       or exhausts retries / fails for a non-backpressure reason  
        BiConsumer<Long, Runnable> scheduler,
                    LOGGER.warn(
    private static void sendWithRetry(
                        request.getTargetStageId(),
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * <p>This helper does not cover retrying on transport errors (node unreachable, shard not found);  
 * — the {@code scheduler} {@link BiConsumer} abstraction lets callers wire whatever ThreadPool /  
import java.util.function.BiConsumer;
     * @param request        the shuffle payload to deliver
                );
                    () -> sendWithRetry(request, sender, scheduler, finalListener, maxAttempts, initialBackoffMillis, attempt + 1)
                    maxAttempts,
                        request.getPartitionIndex()  
                        request.getQueryId(),
        ActionListener<AnalyticsShuffleDataResponse> finalListener  
 */  
                    finalListener.onResponse(response);  
     * Dispatch {@code request} via {@code sender}; on backpressure reject, re-dispatch after
                    attempt + 1,  
     *
    private static final Logger LOGGER = LogManager.getLogger(ShuffleSenderRetry.class);
    ) {
                scheduler.accept(  
                    return;  
        int attempt  
     */
                    backoff,
import org.opensearch.core.action.ActionListener;
                    request.getPartitionIndex()
                // Non-backpressure transport error: M2 scope is backpressure retry only; bubble up.
}
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataRequest;  
                    finalListener.onResponse(response);
     * @param sender         performs one send attempt (e.g. transport client wrapper)  
 * It also assumes the underlying transport client provides a way to schedule a delayed retry
                    return;
                if (attempt >= maxAttempts) {  
            public void onFailure(Exception e) {
                }
        ActionListener<AnalyticsShuffleDataResponse> finalListener,  
/**  
 * those are out of scope for M2 and tracked as follow-up per doc 90 §3 / doc 65 out-of-scope #5.
            }
package org.opensearch.analytics.exec.shuffle;
 *
                        attempt,  
     * {@code maxAttempts}.  
                long backoff = Math.min(DEFAULT_MAX_BACKOFF_MILLIS, initialBackoffMillis << (attempt - 1));
    }  
     * exponential backoff (50ms, 100ms, 200ms, ..., capped at 5s). Caps total attempts at
 * @opensearch.internal  
 * Scheduler they have (test: same-thread executor; production: {@code ThreadPool.schedule}).
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
                );  
                    request.getTargetStageId(),  
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataResponse;
                    request.getQueryId(),
        sendWithRetry(request, sender, scheduler, finalListener, DEFAULT_MAX_ATTEMPTS, DEFAULT_INITIAL_BACKOFF_MILLIS, 1);
 * The OpenSearch Contributors require contributions made to  
 * Sender-side retry loop for {@link AnalyticsShuffleDataRequest}. When the worker responds with
        AnalyticsShuffleDataRequest request,  
     * @param finalListener  notified once the shuffle write either succeeds (non-rejected response)
                    );
 *
 */
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender,
    /**  
/*  
    private static final long DEFAULT_MAX_BACKOFF_MILLIS = 5_000;
                if (!response.isBackpressureRejected()) {
                    "Shuffle backpressure-rejected, retrying in {}ms (attempt {}/{}): query={}, stage={}, partition={}",
 * {@code backpressureRejected=true}, reschedule the same request with exponential backoff up to
        BiConsumer<Long, Runnable> scheduler,
        int maxAttempts,
            public void onResponse(AnalyticsShuffleDataResponse response) {
