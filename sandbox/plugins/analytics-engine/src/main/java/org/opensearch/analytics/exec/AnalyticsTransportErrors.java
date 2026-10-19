        String message = se.getMessage();  
     * Anything else passes through unchanged.
            e,  
import org.opensearch.ExceptionsHelper;
        StreamException se = ExceptionsHelper.<StreamException>unwrapCausesAndSuppressed(
            CircuitBreakingException breaker = new CircuitBreakingException(
 * {@link CircuitBreakingException}, HTTP 429) would otherwise reach the coordinator as a typeless
        return new OpenSearchStatusException(message != null ? message : "service unavailable", RestStatus.SERVICE_UNAVAILABLE, e);
        if (cancelled != null) {
    /**
                CircuitBreaker.Durability.TRANSIENT  
     * Other failures pass through unchanged.  
                && (s.getErrorCode() == StreamErrorCode.RESOURCE_EXHAUSTED
            // so the original StreamException/stack is kept for server-side troubleshooting.  
     *   <li>HTTP-429 {@link OpenSearchException} (circuit breaker / admission rejection) →
        }
import org.opensearch.transport.stream.StreamErrorCode;
import org.opensearch.OpenSearchException;
    }  
     * as a generic 500:
     */  
        if (se.getErrorCode() == StreamErrorCode.RESOURCE_EXHAUSTED) {
 * this file be licensed under the Apache-2.0 license or a
        if (resourceExhausted != null) {
     *   <li>{@link StreamErrorCode#UNAVAILABLE} → 503 {@link OpenSearchStatusException} — a transport  
 * pair that preserves the status across the wire via the error <em>code</em>:  
 *   <li>{@link #fromWireError} — <b>coordinator receive side</b>: rebuild a typed exception with the
package org.opensearch.analytics.exec;
        Throwable cancelled = ExceptionsHelper.unwrapCausesAndSuppressed(e, t -> t instanceof TaskCancelledException).orElse(null);
        ).orElse(null);
        if (se.getErrorCode() == StreamErrorCode.CANCELLED) {
 *   {@link StreamErrorCode#RESOURCE_EXHAUSTED} before it crosses Flight.
     *   <li>{@link TaskCancelledException} (e.g. SBP cancellation) → {@link StreamErrorCode#CANCELLED} —  
     *   memory-pool / breaker trip.
     */
 *   <li>{@link #toWireError} — <b>data-node send side</b>: tag a resource-exhaustion failure as  
            return e;
final class AnalyticsTransportErrors {
     *   drop (node gone, connection reset) is "service unavailable", not an internal error.
import org.opensearch.core.common.breaker.CircuitBreakingException;
            t -> t instanceof OpenSearchException ose && ose.status() == RestStatus.TOO_MANY_REQUESTS
            t -> t instanceof StreamException s
 * <ul>
        }
 * compatible open source license.
 *
 *
        }  
    }
        }
            return new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, resourceExhausted.getMessage(), e);
                message != null ? message : "circuit breaking exception",
     * </ul>
     * Data-node send side. Tags a typed failure with the right {@link StreamErrorCode} so the signal  
 * @opensearch.internal
     *   stays a recognizable cancellation instead of degrading to a generic ISE that clients would retry.  
 * description string survive the wire. So a typed failure on the data node (e.g. a memory-gate  
            );
/**
     * in {@link #fromWireError}:
import org.opensearch.core.common.breaker.CircuitBreaker;
 * Cause-chain walks use {@link ExceptionsHelper#unwrapCausesAndSuppressed} (cycle-safe).  
 * {@code INTERNAL} error and surface to the user as a generic 500. These two methods are a matched
     *   otherwise it crosses as INTERNAL and surfaces as a generic 500/ISE that clients retry.
            return breaker;  
     *   <li>{@link StreamErrorCode#CANCELLED} → {@link TaskCancelledException} — a shard cancel (e.g. SBP)
                    || s.getErrorCode() == StreamErrorCode.CANCELLED)
            cancelled.initCause(e);
                    || s.getErrorCode() == StreamErrorCode.UNAVAILABLE  
 * <p>Flight does not serialize the Java exception type — only a {@link StreamErrorCode} and a
        if (se == null) {  
import org.opensearch.OpenSearchStatusException;  
 * </ul>
     * survives Flight (which doesn't serialize the exception type) and the coordinator can rebuild it
            e,
            TaskCancelledException cancelled = new TaskCancelledException(message != null ? message : "task cancelled");  
        Throwable resourceExhausted = ExceptionsHelper.unwrapCausesAndSuppressed(  
     *   {@link StreamErrorCode#RESOURCE_EXHAUSTED}.
 *
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
     * <ul>  
import org.opensearch.core.tasks.TaskCancelledException;
 *   right HTTP status from the {@link StreamException} that crossed the wire.  
     *   <li>{@link StreamErrorCode#RESOURCE_EXHAUSTED} → {@link CircuitBreakingException} (429) — a
 *
        ).orElse(null);  
    private AnalyticsTransportErrors() {}  
 */  
    static Exception fromWireError(Exception e) {
            return cancelled;
import org.opensearch.transport.stream.StreamException;  
 *
     * Coordinator receive side. Inverse of {@link #toWireError}: maps a {@link StreamException} that  
        return e;
}  
     * </ul>
/*  
import org.opensearch.core.rest.RestStatus;  
     * crossed transport back to a typed exception, so a shard-side failure doesn't surface to the user
     * <ul>  
    static Exception toWireError(Exception e) {
            // CircuitBreakingException has no cause-accepting ctor; attach the wire exception via initCause
            breaker.initCause(e);
            return new StreamException(StreamErrorCode.CANCELLED, cancelled.getMessage(), e);  
        }  
    /**
 * Error mapping for the two ends of an analytics shard RPC over Flight stream transport.  
 */  
