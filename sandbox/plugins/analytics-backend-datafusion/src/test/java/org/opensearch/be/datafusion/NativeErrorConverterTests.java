        // Simulates what the coordinator sees after Flight transport: the controlled
        RuntimeException original = new RuntimeException(message);
        OpenSearchStatusException statusEx = (OpenSearchStatusException) result;
    }
        RuntimeException original = new RuntimeException("Some unknown error from native code");  
    }
        // Contains the key phrase but wrong format
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());  
    public void testNullMessageInCauseChainHandledGracefully() {  
        }  
        Exception result = NativeErrorConverter.convert(original);  
        String controlledMessage = "Query too deeply nested: the expression exceeds the maximum nesting depth "
        assertEquals(65536L, cbe.getBytesWanted());
    public void testDeeplyNestedCauseRespectDepthLimit() {
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchStatusException) result).status());
    public void testPoolLimitExceededConvertsToCircuitBreakingException() {  
        Exception result = NativeErrorConverter.convert(transportException);
        // happens with very small datafusion.memory_pool_limit_bytes before our own try_grow path runs.
        String rendered = sb.toString();
        CircuitBreakingException cbe = (CircuitBreakingException) result;  
    }  
public class NativeErrorConverterTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        Exception result = NativeErrorConverter.convert(cbe);
        RuntimeException inner = new RuntimeException(poolMessage);
        assertNoNativeLeak(cbe);
 * SPDX-License-Identifier: Apache-2.0
        String message = "Failed to allocate 2048 bytes for sort (1024 already reserved) " + "— 0 available out of 1073741824 limit";
        assertTrue(result.getMessage().contains("too deeply nested"));
        RuntimeException original = new RuntimeException(message);
        Exception result = NativeErrorConverter.convert(original);  
import org.opensearch.OpenSearchStatusException;
            "GroupedHashAggregateStream",
 */  
        assertTrue(result instanceof OpenSearchStatusException);  
        Exception current = deepest;  
        RuntimeException original = new RuntimeException(message);  
        assertEquals("Native query admission rejected: insufficient memory budget available", result.getMessage());  
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", result.getCause());
        assertSame(original, result);
            "already reserved",  
        assertTrue(result instanceof CircuitBreakingException);
        CircuitBreakingException cbe = (CircuitBreakingException) result;
    }
            assertFalse("must not leak native detail '" + leak + "' to the user, got: " + rendered, rendered.contains(leak));
        RuntimeException original = new RuntimeException(message);
        RuntimeException original = new RuntimeException(message);
        Exception result = NativeErrorConverter.convert(original);
    public void testCriticalPressureCancellationConvertsToCircuitBreakingException() {
        assertSame(cbe, result);  
    }  
        String poolMessage = "Failed to allocate 1024 bytes for test (512 already reserved) — 0 available out of 2048 limit";
     * (limit: L)" with the verbose native allocator dump appended. The converted exception must keep the clean
        String controlledMessage = "Native query admission rejected: insufficient memory budget available";
        RuntimeException original = new RuntimeException(message);  
        RuntimeException inner = new RuntimeException(poolMessage);  
        assertNotNull(result);
        assertEquals(1048576L, cbe.getBytesWanted());
    }
        assertSame(statusEx, result);
        // Raw prost decoder error seen at the FFM boundary for deeply nested Substrait plans.
        // the controlled message produced by the data node's NativeErrorConverter.
            + "— 0 available out of 27673548029 limit";  
            "RepartitionExec",
    }  
        assertEquals(4096L, ((CircuitBreakingException) result).getBytesWanted());
            "avg_row_bytes" }) {
    private static void assertNoNativeLeak(Throwable t) {
            + "— 0 available out of 4294967296 limit";
        assertTrue(result instanceof IllegalArgumentException);
    public void testRawRecursionLimitConvertsToIllegalArgumentException() {
 *
        Exception result = NativeErrorConverter.convert(chain);  
package org.opensearch.be.datafusion;
        );
        for (String leak : new String[] {
    }  
    }  
            + "— 0 available out of 4294967296 limit. "
        // pool limit message produced by the data node's NativeErrorConverter.
        assertTrue(result instanceof OpenSearchStatusException);
    }
}
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());  
        Exception result = NativeErrorConverter.convert(original);
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());  
        String message = "Resources exhausted: Memory Exhausted while SpillPool (DiskManager is disabled)";
        StringBuilder sb = new StringBuilder();  
        RuntimeException chain = new RuntimeException(null, new RuntimeException(null, inner));
    public void testControlledAdmissionMessageConvertsOnCoordinator() {
        assertEquals(controlledMessage, result.getMessage());  
        assertTrue(result instanceof CircuitBreakingException);
        Exception result = NativeErrorConverter.convert(original);
import org.opensearch.core.rest.RestStatus;
        Exception result = NativeErrorConverter.convert(original);  
    }
        String message = "Failed to allocate 1048576 bytes for hash_agg (524288 already reserved) "
    }
        for (int i = 0; i < 15; i++) {
        // The pattern is at depth > 10, so it should NOT be matched
    }
        assertNoNativeLeak(result);
        Exception result = NativeErrorConverter.convert(transportException);  
        CircuitBreakingException cbe = (CircuitBreakingException) result;  
        String controlledMessage = "[analytics_backend_datafusion] Failed to allocate 1048576 bytes (limit: 4294967296)";  
        assertEquals(4294967296L, cbe.getByteLimit());
/*  
     */  
    }  
    public void testPoolLimitExceededUsesControlledMessage() {  
        Exception result = NativeErrorConverter.convert(original);
import org.opensearch.test.OpenSearchTestCase;
        assertSame(current, result);
    public void testAlreadyConvertedStatusExceptionNotReConverted() {  
        RuntimeException transportException = new RuntimeException(controlledMessage);  
        // Cause intentionally omitted to prevent leaking native error details in REST responses.
        RuntimeException deepest = new RuntimeException(  
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());
        assertTrue(result instanceof CircuitBreakingException);
        assertTrue(result instanceof CircuitBreakingException);
    public void testTopKConsumerDumpIsSanitized() {
    /** Asserts the rendered exception (message + cause chain) carries no raw native allocator internals. */
            current = new RuntimeException("wrapper " + i, current);
        // Build a chain deeper than 10
        String message = "Failed to allocate 65536 bytes for hash_agg (1048576 already reserved) "  
        RuntimeException original = new RuntimeException(message);
        assertSame(original, result);  
        Exception result = NativeErrorConverter.convert(transportException);
    public void testAlreadyConvertedCircuitBreakingExceptionNotReConverted() {
        assertTrue(result instanceof CircuitBreakingException);  
        RuntimeException wrapper = new RuntimeException("Query execution failed", inner);
        for (Throwable c = t; c != null && c != c.getCause(); c = c.getCause()) {
            "Failed to allocate 512 bytes for agg (256 already reserved) — 0 available out of 1024 limit"
        assertTrue(result.getMessage().contains("too deeply nested"));  
            "can spill",
            "batch_size",  
        assertEquals(RestStatus.TOO_MANY_REQUESTS, statusEx.status());
 * compatible open source license.
            + "(across reservations) as:\n  query_untracked(partitions=4,batch=8192)#49492(can spill: true) consumed 20.7 MB, "
        assertTrue(result instanceof IllegalArgumentException);
        RuntimeException transportException = new RuntimeException(controlledMessage);  
        // Simulates what the coordinator sees after Flight transport: StreamException wrapping  
        }  
            + "Execution error: Resources exhausted: Additional allocation failed for TopK[0] with top memory consumers "  
        assertEquals(CircuitBreaker.Durability.TRANSIENT, cbe.getDurability());  
    public void testNestedCauseChainIsWalked() {
    /**
        assertNotNull(result);
        assertTrue(result instanceof CircuitBreakingException);
    }  
    public void testSpillPoolExhaustedConvertsToCircuitBreakingException() {
        assertNull("converted exception must carry no cause (raw native detail stays server-side)", cbe.getCause());
    public void testAdmissionRejectionConvertsToStatusException() {
        assertNoNativeLeak(cbe);
        String message = "Failed to allocate lots of bytes for something";  
        assertTrue(result instanceof CircuitBreakingException);
        Exception result = NativeErrorConverter.convert(original);  
        assertNoNativeLeak(cbe);
        // Key phrase matched but regex didn't parse → returns original
        assertNull(result.getCause());
        String message = "Cannot reserve untracked memory budget: 67108864 bytes required "
            + "peak 20.7 MB.\nError: Failed to allocate 307848 bytes for TopK[0] (0 already reserved) "
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        Exception result = NativeErrorConverter.convert(statusEx);  
        assertEquals("[analytics_backend_datafusion] Failed to allocate 2048 bytes (limit: 1073741824)", result.getMessage());
        // DataFusion emits this when an operator can't allocate and DiskManager is disabled —  
        RuntimeException withNullMsg = new RuntimeException((String) null);
        RuntimeException original = new RuntimeException(message);  
     * numeric message and NOT echo the consumer breakdown anywhere in its rendered chain.
        CircuitBreakingException cbe = (CircuitBreakingException) result;  
        assertEquals("[analytics_backend_datafusion] Failed to allocate 307848 bytes (limit: 27673548029)", result.getMessage());  
import org.opensearch.core.common.breaker.CircuitBreaker;
    public void testControlledPoolLimitMessageConvertsOnCoordinator() {  
        // Coordinator-side safety net: the controlled message arriving via StreamException.  
        OpenSearchStatusException statusEx = new OpenSearchStatusException("already rejected", RestStatus.TOO_MANY_REQUESTS);
        Exception result = NativeErrorConverter.convert(wrapper);
    public void testUnrecognizedErrorPassedThrough() {
        }  
        assertEquals(1048576L, cbe.getBytesWanted());
        // The raw native error (with allocator internals) must NOT be attached as the user-facing cause.
        assertNoNativeLeak(result);
        assertEquals(4294967296L, cbe.getByteLimit());
            + "supported by the execution engine. Simplify the query by reducing nested function calls.";
            + "Query cancelled: native memory RSS exceeds critical threshold (95% of pool limit).";
    }
        assertTrue(result instanceof CircuitBreakingException);  
    }
        Exception result = NativeErrorConverter.convert((Exception) current);  
            "top memory consumers",  
        RuntimeException transportException = new RuntimeException(controlledMessage);
        String poolMessage = "Failed to allocate 4096 bytes for coalesce (2048 already reserved) — 0 available out of 8589934592 limit";  
        String message = "[analytics_backend_datafusion] Failed to allocate 307848 bytes (limit: 27673548029)\n"
        assertEquals("[analytics_backend_datafusion] Failed to allocate 1048576 bytes (limit: 4294967296)", cbe.getMessage());
        assertNotNull(result);
            sb.append(c.getClass().getName()).append(':').append(c.getMessage()).append('\n');
     * The real staging TopK message: a controlled "[analytics_backend_datafusion] Failed to allocate N bytes  
        CircuitBreakingException cbe = new CircuitBreakingException("already converted", 100, 200, CircuitBreaker.Durability.TRANSIENT);
        String message = "failed to decode Protobuf message: recursion limit reached";  
 * The OpenSearch Contributors require contributions made to  
            "query_untracked",
    public void testMalformedPoolLimitMessageFallsThrough() {
    }  
    public void testControlledRecursionMessageConvertsOnCoordinator() {
        assertEquals(4294967296L, cbe.getByteLimit());
        Exception result = NativeErrorConverter.convert(original);
            + "at minimum parallelism (partitions=1, batch_size=1024). Pool capacity exhausted.";  
