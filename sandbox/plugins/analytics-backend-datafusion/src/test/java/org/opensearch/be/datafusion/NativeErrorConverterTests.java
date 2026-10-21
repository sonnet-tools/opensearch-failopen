        assertTrue(result instanceof CircuitBreakingException);
        Exception result = NativeErrorConverter.convert(original);
/*
        // Coordinator-side safety net: the controlled message arriving via StreamException.
        assertSame(original, result);
        // the controlled message produced by the data node's NativeErrorConverter.
package org.opensearch.be.datafusion;
    public void testAdmissionRejectionConvertsToStatusException() {
        // Build a chain deeper than 10
        assertNotNull(result);
    public void testNullMessageInCauseChainHandledGracefully() {
    public void testRawRecursionLimitConvertsToIllegalArgumentException() {
    private static void assertNoNativeLeak(Throwable t) {
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());
        OpenSearchStatusException statusEx = (OpenSearchStatusException) result;
        assertEquals("Native query admission rejected: insufficient memory budget available", result.getMessage());
        Exception result = NativeErrorConverter.convert(original);
    }
     * The real staging TopK message: a controlled "[analytics_backend_datafusion] Failed to allocate N bytes
            "avg_row_bytes" }) {
        assertEquals(4096L, ((CircuitBreakingException) result).getBytesWanted());
        assertTrue(result instanceof OpenSearchStatusException);
        RuntimeException deepest = new RuntimeException(
        }
    /**
        assertTrue(result instanceof IllegalArgumentException);
            + "— 0 available out of 27673548029 limit";
        RuntimeException withNullMsg = new RuntimeException((String) null);
    }
        Exception result = NativeErrorConverter.convert(original);
        // Simulates what the coordinator sees after Flight transport: the controlled
    }
    public void testControlledRecursionMessageConvertsOnCoordinator() {
        Exception result = NativeErrorConverter.convert(transportException);
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());
        StringBuilder sb = new StringBuilder();
import org.opensearch.core.common.breaker.CircuitBreakingException;
        String message = "Failed to allocate 2048 bytes for sort (1024 already reserved) " + "— 0 available out of 1073741824 limit";
    }
    public void testMalformedPoolLimitMessageFallsThrough() {
        assertTrue(result.getMessage().contains("too deeply nested"));
    }
            + "— 0 available out of 4294967296 limit";
        assertTrue(result instanceof CircuitBreakingException);
        // pool limit message produced by the data node's NativeErrorConverter.
            "already reserved",
     * numeric message and NOT echo the consumer breakdown anywhere in its rendered chain.
        // Contains the key phrase but wrong format
import org.opensearch.core.rest.RestStatus;
        Exception result = NativeErrorConverter.convert(cbe);
    }
        assertTrue(result instanceof CircuitBreakingException);
        Exception result = NativeErrorConverter.convert(original);
    /** Asserts the rendered exception (message + cause chain) carries no raw native allocator internals. */
        assertEquals("[analytics_backend_datafusion] Failed to allocate 307848 bytes (limit: 27673548029)", result.getMessage());
     * (limit: L)" with the verbose native allocator dump appended. The converted exception must keep the clean
        RuntimeException wrapper = new RuntimeException("Query execution failed", inner);
        Exception result = NativeErrorConverter.convert(wrapper);
        String message = "Failed to allocate lots of bytes for something";
 * compatible open source license.
    public void testAlreadyConvertedStatusExceptionNotReConverted() {
    public void testTopKConsumerDumpIsSanitized() {
        assertNotNull(result);
 * this file be licensed under the Apache-2.0 license or a
        // happens with very small datafusion.memory_pool_limit_bytes before our own try_grow path runs.
        assertNoNativeLeak(cbe);
        CircuitBreakingException cbe = (CircuitBreakingException) result;
        RuntimeException original = new RuntimeException(message);
 *
    }
        String controlledMessage = "Native query admission rejected: insufficient memory budget available";
        String controlledMessage = "[analytics_backend_datafusion] Failed to allocate 1048576 bytes (limit: 4294967296)";
        String message = "failed to decode Protobuf message: recursion limit reached";
        String message = "Failed to allocate 1048576 bytes for hash_agg (524288 already reserved) "
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
        Exception result = NativeErrorConverter.convert(chain);
        CircuitBreakingException cbe = new CircuitBreakingException("already converted", 100, 200, CircuitBreaker.Durability.TRANSIENT);
        assertEquals(1048576L, cbe.getBytesWanted());
        RuntimeException original = new RuntimeException(message);
            + "(across reservations) as:\n  query_untracked(partitions=4,batch=8192)#49492(can spill: true) consumed 20.7 MB, "
        CircuitBreakingException cbe = (CircuitBreakingException) result;
        Exception result = NativeErrorConverter.convert((Exception) current);
    }
        RuntimeException original = new RuntimeException(message);
        assertNoNativeLeak(cbe);
 */
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("[analytics_backend_datafusion] Failed to allocate 1048576 bytes (limit: 4294967296)", cbe.getMessage());
    }
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());
        Exception result = NativeErrorConverter.convert(original);
        assertSame(original, result);
    public void testUnrecognizedErrorPassedThrough() {
        );
        assertSame(current, result);
        assertEquals(4294967296L, cbe.getByteLimit());
        RuntimeException chain = new RuntimeException(null, new RuntimeException(null, inner));
        String message = "Cannot reserve untracked memory budget: 67108864 bytes required "
        // Simulates what the coordinator sees after Flight transport: StreamException wrapping
        Exception result = NativeErrorConverter.convert(original);
        String message = "Resources exhausted: Memory Exhausted while SpillPool (DiskManager is disabled)";
            + "supported by the execution engine. Simplify the query by reducing nested function calls.";
        RuntimeException transportException = new RuntimeException(controlledMessage);
    public void testPoolLimitExceededConvertsToCircuitBreakingException() {
import org.opensearch.test.OpenSearchTestCase;
        // Cause intentionally omitted to prevent leaking native error details in REST responses.
    public void testControlledPoolLimitMessageConvertsOnCoordinator() {
    }
     */
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchStatusException) result).status());
    }
            + "— 0 available out of 4294967296 limit. "
        for (int i = 0; i < 15; i++) {
        RuntimeException original = new RuntimeException("Some unknown error from native code");
}
            + "Query cancelled: native memory RSS exceeds critical threshold (95% of pool limit).";
        // Key phrase matched but regex didn't parse → returns original
        RuntimeException original = new RuntimeException(message);
        RuntimeException inner = new RuntimeException(poolMessage);
        for (String leak : new String[] {
        Exception result = NativeErrorConverter.convert(transportException);
    public void testDeeplyNestedCauseRespectDepthLimit() {
        OpenSearchStatusException statusEx = new OpenSearchStatusException("already rejected", RestStatus.TOO_MANY_REQUESTS);
        // The pattern is at depth > 10, so it should NOT be matched
        }
        assertEquals(1048576L, cbe.getBytesWanted());
        Exception result = NativeErrorConverter.convert(original);
    }
        String message = "Failed to allocate 65536 bytes for hash_agg (1048576 already reserved) "
        RuntimeException original = new RuntimeException(message);
        // The raw native error (with allocator internals) must NOT be attached as the user-facing cause.
    }
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());
        RuntimeException transportException = new RuntimeException(controlledMessage);
        assertSame(cbe, result);
        assertEquals(controlledMessage, result.getMessage());
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", result.getCause());
    }
        assertTrue(result instanceof CircuitBreakingException);
        assertTrue(result instanceof IllegalArgumentException);
    public void testCriticalPressureCancellationConvertsToCircuitBreakingException() {
        assertNoNativeLeak(result);
            "Failed to allocate 512 bytes for agg (256 already reserved) — 0 available out of 1024 limit"
        String rendered = sb.toString();
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());
        String controlledMessage = "Query too deeply nested: the expression exceeds the maximum nesting depth "
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());
        RuntimeException inner = new RuntimeException(poolMessage);
    }
        assertNull(result.getCause());
import org.opensearch.core.common.breaker.CircuitBreaker;
        RuntimeException transportException = new RuntimeException(controlledMessage);
        assertTrue(result instanceof CircuitBreakingException);
    public void testControlledAdmissionMessageConvertsOnCoordinator() {
            "batch_size",
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
        assertNoNativeLeak(cbe);
            assertFalse("must not leak native detail '" + leak + "' to the user, got: " + rendered, rendered.contains(leak));
    }
        assertTrue(result instanceof CircuitBreakingException);
    public void testNestedCauseChainIsWalked() {
            "RepartitionExec",
    public void testSpillPoolExhaustedConvertsToCircuitBreakingException() {
    public void testPoolLimitExceededUsesControlledMessage() {
            + "peak 20.7 MB.\nError: Failed to allocate 307848 bytes for TopK[0] (0 already reserved) "
            "top memory consumers",
        Exception result = NativeErrorConverter.convert(original);
        RuntimeException original = new RuntimeException(message);
        assertTrue(result instanceof CircuitBreakingException);
        RuntimeException original = new RuntimeException(message);
            "can spill",
        Exception result = NativeErrorConverter.convert(original);
 * The OpenSearch Contributors require contributions made to
        String message = "[analytics_backend_datafusion] Failed to allocate 307848 bytes (limit: 27673548029)\n"
    public void testAlreadyConvertedCircuitBreakingExceptionNotReConverted() {
    }
            + "Execution error: Resources exhausted: Additional allocation failed for TopK[0] with top memory consumers "
            "query_untracked",
        assertTrue(result.getMessage().contains("too deeply nested"));
        assertTrue(result instanceof OpenSearchStatusException);
        String poolMessage = "Failed to allocate 1024 bytes for test (512 already reserved) — 0 available out of 2048 limit";
        assertEquals(RestStatus.TOO_MANY_REQUESTS, statusEx.status());
            current = new RuntimeException("wrapper " + i, current);
        assertEquals("[analytics_backend_datafusion] Failed to allocate 2048 bytes (limit: 1073741824)", result.getMessage());
        CircuitBreakingException cbe = (CircuitBreakingException) result;
        Exception result = NativeErrorConverter.convert(transportException);
        CircuitBreakingException cbe = (CircuitBreakingException) result;
import org.opensearch.OpenSearchStatusException;
public class NativeErrorConverterTests extends OpenSearchTestCase {
    }
        assertNotNull(result);
        // Raw prost decoder error seen at the FFM boundary for deeply nested Substrait plans.
        assertNoNativeLeak(result);
            "GroupedHashAggregateStream",
        assertEquals(4294967296L, cbe.getByteLimit());
        String poolMessage = "Failed to allocate 4096 bytes for coalesce (2048 already reserved) — 0 available out of 8589934592 limit";
        assertEquals(65536L, cbe.getBytesWanted());
        assertEquals(4294967296L, cbe.getByteLimit());
        Exception current = deepest;
        // DataFusion emits this when an operator can't allocate and DiskManager is disabled —
        RuntimeException original = new RuntimeException(message);
        assertTrue(result instanceof CircuitBreakingException);
        Exception result = NativeErrorConverter.convert(statusEx);
            + "at minimum parallelism (partitions=1, batch_size=1024). Pool capacity exhausted.";
        assertSame(statusEx, result);
        }
