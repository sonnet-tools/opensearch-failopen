        assertEquals("pool full", wire.getMessage());  
        Exception wire = AnalyticsTransportErrors.toWireError(wrapped);  
    }  
        assertTrue(wire instanceof StreamException);
        assertTrue(recovered instanceof CircuitBreakingException);  
        Exception recovered = AnalyticsTransportErrors.fromWireError(onWire);
        assertEquals("sbp cancel", recovered.getMessage());  
import org.opensearch.transport.stream.StreamException;
 * SPDX-License-Identifier: Apache-2.0
        StreamException wire = new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, "pool full on shard");
        Exception wire = AnalyticsTransportErrors.toWireError(wrapped);  
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) wire).getErrorCode());  
        );
        CircuitBreakingException breaker = new CircuitBreakingException("pool full", 100, 50, CircuitBreaker.Durability.TRANSIENT);  
        Exception other = new IllegalArgumentException("bad query");
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
        assertTrue(
    public void testFromWireErrorPassesThroughOtherCodes() {
    }  
package org.opensearch.analytics.exec;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
        assertSame(wire, AnalyticsTransportErrors.fromWireError(wire));
        assertEquals(StreamErrorCode.CANCELLED, ((StreamException) wire).getErrorCode());
        assertSame(other, AnalyticsTransportErrors.fromWireError(other));  
    }  
    public void testFromWireErrorMapsUnavailableTo503() {
        assertEquals("task cancelled by search backpressure", recovered.getMessage());
    public void testFromWireErrorPassesThroughNonStreamException() {
        StreamException wire = new StreamException(StreamErrorCode.UNAVAILABLE, "Network closed for unknown reason");  
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
        // A self-referential cause chain must not loop forever (ExceptionsHelper uses an identity set).
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((CircuitBreakingException) recovered).status());
        Exception wrapped = new RuntimeException("Stage 0 failed", new TaskCancelledException("sbp cancel nested"));
        Exception wire = AnalyticsTransportErrors.toWireError(breaker);
import org.opensearch.transport.stream.StreamErrorCode;
        assertTrue(  
 */  
    public void testToWireErrorTagsBreakerAsResourceExhausted() {
 * The OpenSearch Contributors require contributions made to  
            "Stage 0 failed",
 * this file be licensed under the Apache-2.0 license or a
            "round-tripped CANCELLED must remain TaskCancelledException (got " + recovered.getClass().getName() + ")",  
    }  
 */  
        assertSame(a, AnalyticsTransportErrors.toWireError(a));
        StreamException wire = new StreamException(StreamErrorCode.CANCELLED, "task cancelled by search backpressure");
        Exception recovered = AnalyticsTransportErrors.fromWireError(onWire);  
    }
import org.opensearch.core.rest.RestStatus;
    public void testBreakerSurvivesRoundTripAs429() {
    // ── round-trip ────────────────────────────────────────────────────────  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
    }
        assertEquals(RestStatus.SERVICE_UNAVAILABLE, ((OpenSearchStatusException) recovered).status());
    public void testFromWireErrorRebuildsTaskCancelledFromCancelled() {
import org.opensearch.core.tasks.TaskCancelledException;
            recovered instanceof TaskCancelledException
        Exception b = new RuntimeException("b", a);  
    }
    // ── fromWireError (coordinator receive side) ──────────────────────────
        Exception wrapped = new RuntimeException("Stage 0 failed", new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, "breaker"));  
    public void testToWireErrorFindsBreakerInCauseChain() {  
        Exception onWire = AnalyticsTransportErrors.toWireError(breaker);  
        Exception wrapped = new RuntimeException(
        a.initCause(b);
        Exception wire = AnalyticsTransportErrors.toWireError(admission);  
    }
        assertSame(other, AnalyticsTransportErrors.toWireError(other));
        assertEquals("limit hit", recovered.getMessage());
        Exception recovered = AnalyticsTransportErrors.fromWireError(wrapped);
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());  
        assertTrue(wire instanceof StreamException);
        TaskCancelledException cancelled = new TaskCancelledException("sbp cancel");  
        assertTrue(recovered instanceof CircuitBreakingException);
    public void testToWireErrorIsCycleSafe() {  
    }
        Exception wire = AnalyticsTransportErrors.toWireError(cancelled);
import org.opensearch.core.common.breaker.CircuitBreaker;
    }  
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());  
/**
    }
public class AnalyticsTransportErrorsTests extends OpenSearchTestCase {
 * Tests the shard-send / coordinator-receive error-mapping pair in {@link AnalyticsTransportErrors}.
 *
        Exception onWire = AnalyticsTransportErrors.toWireError(cancelled);
    public void testTaskCancelledSurvivesRoundTripAsTaskCancelled() {
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
        Exception other = new IllegalStateException("not a breaker");
/*  
    }
    }
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, ((StreamException) wire).getErrorCode());
import org.opensearch.OpenSearchStatusException;
        StreamException wire = new StreamException(StreamErrorCode.INTERNAL, "boom");  
        assertTrue(recovered instanceof CircuitBreakingException);  
        assertTrue(wire instanceof StreamException);
        assertEquals("sbp cancel", wire.getMessage());  
        OpenSearchStatusException admission = new OpenSearchStatusException("admission rejected", RestStatus.TOO_MANY_REQUESTS);
        assertTrue(wire instanceof StreamException);
    public void testToWireErrorTagsTaskCancelledAsCancelled() {
    }
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals("pool full on shard", recovered.getMessage());
        assertTrue(recovered instanceof OpenSearchStatusException);
        );  
    public void testFromWireErrorFindsCodeInCauseChain() {
    }  
        CircuitBreakingException breaker = new CircuitBreakingException("limit hit", 100, 50, CircuitBreaker.Durability.TRANSIENT);  
            "CANCELLED must surface as TaskCancelledException, not ISE (got " + recovered.getClass().getName() + ")",
        );
 * compatible open source license.
        // shard tags it → (Flight would carry the code) → coordinator rebuilds it.
            new CircuitBreakingException("nested", 1, 1, CircuitBreaker.Durability.TRANSIENT)  
    public void testToWireErrorFindsTaskCancelledInCauseChain() {  
    public void testToWireErrorTagsAny429OpenSearchException() {  
    public void testToWireErrorPassesThroughNonResourceFailure() {  
        Exception a = new RuntimeException("a");
        TaskCancelledException cancelled = new TaskCancelledException("sbp cancel");  
        Exception recovered = AnalyticsTransportErrors.fromWireError(wire);
    // ── toWireError (data-node send side) ─────────────────────────────────  
        assertTrue(wire instanceof StreamException);
            recovered instanceof TaskCancelledException
}
    public void testFromWireErrorRebuildsBreakerFromResourceExhausted() {
