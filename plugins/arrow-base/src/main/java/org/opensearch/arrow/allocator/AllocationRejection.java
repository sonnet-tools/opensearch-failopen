 *
     * into {@link OpenSearchRejectedExecutionException}. Use this overload for
 *
     *         attached as the cause
     *                pool or operation name; e.g. "query-pool", "ingest-vsr")
        } catch (OutOfMemoryException e) {  
            "native memory allocation rejected at [" + context + "]: " + cause.getMessage()
 * SPDX-License-Identifier: Apache-2.0
 * (Too Many Requests) and is the framework's standard rejection signal.
     *
 * is not recognized by OpenSearch's REST layer, so it surfaces to clients as a
 * a parent's {@code allocationLimit}. This is a per-request, recoverable
     * @param <T>     return type of {@code body}
     * @param context short label included in the rejection message (typically the
 * </ul>  
/**  
 *       {@code ArrowBufferPool.createChildAllocator}</li>
     */
     * @param context short label included in the rejection message (typically the
 * back-pressure signal — they should propagate as the original exception.  
 *  
 *   <li>request-handler-side allocations in transport/RPC layers</li>
        try {
    public static void wrap(String context, Runnable body) {  
public final class AllocationRejection {
    }
package org.opensearch.arrow.allocator;
     * Runs {@code body} and translates any Arrow {@link OutOfMemoryException}
 *   <li>per-query child allocator creation in
     * @param body    the allocation site to invoke
 * <p><strong>Do not</strong> wrap startup-time / lifetime-of-component
 * this file be licensed under the Apache-2.0 license or a
     *                pool or operation name; e.g. "query-pool", "ingest-vsr")  
            body.run();
     *         {@link OutOfMemoryException}; the original Arrow exception is  
    }
 * {@link OpenSearchRejectedExecutionException} at allocation boundaries.
            throw rejection(context, e);
    private AllocationRejection() {}
     *         attached as the cause
 * condition — the caller should back off and retry — but Arrow's exception type  
 */  
        return rejection;
 * The OpenSearch Contributors require contributions made to  
 *
    /**  
 * compatible open source license.
        OpenSearchRejectedExecutionException rejection = new OpenSearchRejectedExecutionException(  
     * void allocation sites.  
        );
        }
 *       {@code DefaultPlanExecutor.executeInternal}</li>
 * generic 500. {@link OpenSearchRejectedExecutionException} (a subclass of
    }  
     * @throws OpenSearchRejectedExecutionException if {@code body} throws
import org.apache.arrow.memory.OutOfMemoryException;
            return body.get();  
     * into {@link OpenSearchRejectedExecutionException}.
    private static OpenSearchRejectedExecutionException rejection(String context, OutOfMemoryException cause) {
 * {@code doStart}, service-level allocators created in plugin constructors).
 * <p>Apply this wrapper at <em>per-request</em> allocation sites — places where  
 * Translates Arrow's {@link OutOfMemoryException} into OpenSearch's standard
     * @param body    the allocation site to invoke  
 * {@link java.util.concurrent.RejectedExecutionException}) maps to HTTP 429  
 * <ul>  
 */
        try {
 * <p>Arrow throws {@code OutOfMemoryException} when an allocation would exceed
     */  
     * @throws OpenSearchRejectedExecutionException if {@code body} throws  
            throw rejection(context, e);
     *  
 * Those failing during node init is a configuration error, not a per-request
 *   <li>per-VSR child allocator creation in  
/*  
}  
    public static <T> T wrap(String context, Supplier<T> body) {
import java.util.function.Supplier;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        } catch (OutOfMemoryException e) {
     *         {@link OutOfMemoryException}; the original Arrow exception is
 * a failure represents "this request didn't fit" rather than "the framework
 * allocations (e.g. transport server/client allocators created in  
 * failed to start". Examples:
    /**  
        }  
     * Runs {@code body} and translates any Arrow {@link OutOfMemoryException}
     * @return whatever {@code body} returns on success
        rejection.initCause(cause);  
