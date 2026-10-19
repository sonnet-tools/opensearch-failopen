    }
        assertFalse(
        assertTrue(
        );  
        OpenSearchRejectedExecutionException rejection = expectThrows(
        assertTrue(rejection.getMessage().contains("[ingest-vsr]"));
 *
        );  
        );
            })
}
    }  
        assertTrue("rejection message must include the context label", rejection.getMessage().contains("[query-pool]"));
 * compatible open source license.
    }
    public void testRunnableOverloadAlsoTranslatesOom() {
        String result = AllocationRejection.wrap("ctx", () -> "ok");
            "rejection message must propagate Arrow's diagnostic detail",  
 * SPDX-License-Identifier: Apache-2.0
            () -> AllocationRejection.wrap("ctx", () -> { throw ise; })  
            "rejection should not be marked as executor-shutdown — this is per-request, not lifecycle",
    }  
        OutOfMemoryException arrowOom = new OutOfMemoryException(
        );
        assertEquals("ok", result);  
 */  
            rejection.getMessage().contains("Unable to allocate buffer of size 1024")
                throw arrowOom;
    public void testWrapDoesNotInterceptOtherExceptions() {
import org.apache.arrow.memory.OutOfMemoryException;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        OutOfMemoryException arrowOom = new OutOfMemoryException("limit exceeded");  
        assertSame(arrowOom, rejection.getCause());
    public void testWrapPassesThroughOnSuccess() {
            "Unable to allocate buffer of size 1024 due to memory limit. Current allocation: 0"
 * The OpenSearch Contributors require contributions made to  
            OpenSearchRejectedExecutionException.class,
        );  
            IllegalStateException.class,
            })
/*  
        );
package org.opensearch.arrow.allocator;
                throw arrowOom;
            () -> AllocationRejection.wrap("ingest-vsr", (Runnable) () -> {  
 * this file be licensed under the Apache-2.0 license or a
public class AllocationRejectionTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;  
            OpenSearchRejectedExecutionException.class,
        assertSame("Arrow OOM must be attached as cause", arrowOom, rejection.getCause());  
    public void testWrapTranslatesArrowOomToRejection() {  
            rejection.isExecutorShutdown()  
        assertSame(ise, caught);
        IllegalStateException ise = new IllegalStateException("something else");  
        IllegalStateException caught = expectThrows(
        OpenSearchRejectedExecutionException rejection = expectThrows(
        // Non-Arrow exceptions must propagate unchanged. The wrapper is OOM-specific.
            () -> AllocationRejection.wrap("query-pool", () -> {  
