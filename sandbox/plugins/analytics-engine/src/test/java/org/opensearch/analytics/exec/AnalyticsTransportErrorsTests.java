    public void testFromWireErrorRebuildsBreakerFromResourceExhausted() {
        Exception wrapped = new RuntimeException("Stage 0 failed", new TaskCancelledException("sbp cancel nested"));
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
    public void testToWireErrorTagsTaskCancelledAsCancelled() {
        StreamException wire = new StreamException(StreamErrorCode.INTERNAL, "boom");
        Exception b = new RuntimeException("b", a);
        assertTrue(
/**
        assertSame(a, AnalyticsTransportErrors.toWireError(a));
 *
            "round-tripped CANCELLED must remain TaskCancelledException (got " + recovered.getClass().getName() + ")",
package org.opensearch.analytics.exec;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
 * compatible open source license.
        Exception wrapped = new RuntimeException("Stage 0 failed", new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, "breaker"));
        assertEquals("pool full on shard", recovered.getMessage());
    public void testToWireErrorFindsBreakerInCauseChain() {
    }
import org.opensearch.core.tasks.TaskCancelledException;
    }
        assertSame(other, AnalyticsTransportErrors.toWireError(other));
/*
        assertEquals(RestStatus.SERVICE_UNAVAILABLE, ((OpenSearchStatusException) recovered).status());
    }
        Exception wire = AnalyticsTransportErrors.toWireError(wrapped);
            "CANCELLED must surface as TaskCancelledException, not ISE (got " + recovered.getClass().getName() + ")",
 */
    public void testFromWireErrorFindsCodeInCauseChain() {
 * Tests the shard-send / coordinator-receive error-mapping pair in {@link AnalyticsTransportErrors}.
        );
        Exception other = new IllegalStateException("not a breaker");
        Exception recovered = AnalyticsTransportErrors.fromWireError(wrapped);
        Exception wire = AnalyticsTransportErrors.toWireError(breaker);
        StreamException wire = new StreamException(StreamErrorCode.UNAVAILABLE, "Network closed for unknown reason");
        Exception wire = AnalyticsTransportErrors.toWireError(wrapped);
    public void testToWireErrorPassesThroughNonResourceFailure() {
import org.opensearch.transport.stream.StreamException;
 * SPDX-License-Identifier: Apache-2.0
        assertSame(wire, AnalyticsTransportErrors.fromWireError(wire));
        a.initCause(b);
public class AnalyticsTransportErrorsTests extends OpenSearchTestCase {
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) wire).getErrorCode());
    public void testToWireErrorTagsBreakerAsResourceExhausted() {
        assertTrue(wire instanceof StreamException);
import org.opensearch.transport.stream.StreamErrorCode;
    public void testToWireErrorTagsAny429OpenSearchException() {
}
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());
 * The OpenSearch Contributors require contributions made to
        assertEquals("sbp cancel", wire.getMessage());
    public void testFromWireErrorMapsUnavailableTo503() {
    }
        assertEquals("pool full", wire.getMessage());
import org.opensearch.core.common.breaker.CircuitBreakingException;
    public void testFromWireErrorRebuildsTaskCancelledFromCancelled() {
        Exception other = new IllegalArgumentException("bad query");
    public void testBreakerSurvivesRoundTripAs429() {
        );
        Exception recovered = AnalyticsTransportErrors.fromWireError(onWire);
        Exception wrapped = new RuntimeException(
    }
        Exception recovered = AnalyticsTransportErrors.fromWireError(onWire);
            "Stage 0 failed",
        OpenSearchStatusException admission = new OpenSearchStatusException("admission rejected", RestStatus.TOO_MANY_REQUESTS);
        assertTrue(recovered instanceof CircuitBreakingException);
        Exception wire = AnalyticsTransportErrors.toWireError(admission);
    // ── fromWireError (coordinator receive side) ──────────────────────────
    }
    public void testToWireErrorIsCycleSafe() {
        Exception onWire = AnalyticsTransportErrors.toWireError(cancelled);
    }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(recovered instanceof CircuitBreakingException);
    public void testTaskCancelledSurvivesRoundTripAsTaskCancelled() {
    }
 */
        CircuitBreakingException breaker = new CircuitBreakingException("pool full", 100, 50, CircuitBreaker.Durability.TRANSIENT);
            recovered instanceof TaskCancelledException
        TaskCancelledException cancelled = new TaskCancelledException("sbp cancel");
    }
    }
import org.opensearch.core.common.breaker.CircuitBreaker;
        StreamException wire = new StreamException(StreamErrorCode.CANCELLED, "task cancelled by search backpressure");
    public void testFromWireErrorPassesThroughOtherCodes() {
        Exception wire = AnalyticsTransportErrors.toWireError(cancelled);
        assertTrue(wire instanceof StreamException);
        assertTrue(wire instanceof StreamException);
        assertTrue(recovered instanceof OpenSearchStatusException);
        assertTrue(wire instanceof StreamException);
        Exception a = new RuntimeException("a");
        TaskCancelledException cancelled = new TaskCancelledException("sbp cancel");
            recovered instanceof TaskCancelledException
 * this file be licensed under the Apache-2.0 license or a
        assertSame(other, AnalyticsTransportErrors.fromWireError(other));
        assertEquals("task cancelled by search backpressure", recovered.getMessage());
        assertTrue(wire instanceof StreamException);
        assertEquals("limit hit", recovered.getMessage());
        // A self-referential cause chain must not loop forever (ExceptionsHelper uses an identity set).
    // ── toWireError (data-node send side) ─────────────────────────────────
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
        );
        assertTrue(
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
import org.opensearch.OpenSearchStatusException;
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) wire).getErrorCode());
    }
        assertTrue(recovered instanceof CircuitBreakingException);
            new CircuitBreakingException("nested", 1, 1, CircuitBreaker.Durability.TRANSIENT)
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
    // ── round-trip ────────────────────────────────────────────────────────
        StreamException wire = new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, "pool full on shard");
    public void testFromWireErrorPassesThroughNonStreamException() {
        assertEquals("sbp cancel", recovered.getMessage());
        // shard tags it → (Flight would carry the code) → coordinator rebuilds it.
    }
    public void testToWireErrorFindsTaskCancelledInCauseChain() {
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());
    }
        Exception onWire = AnalyticsTransportErrors.toWireError(breaker);
        CircuitBreakingException breaker = new CircuitBreakingException("limit hit", 100, 50, CircuitBreaker.Durability.TRANSIENT);
    }
    }
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());
