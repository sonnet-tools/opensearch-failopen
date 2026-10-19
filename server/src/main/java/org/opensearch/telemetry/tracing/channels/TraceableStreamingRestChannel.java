        // Prepare response within span scope to ensure proper trace context
            span.endSpan();
    public boolean isWritable() {
    @Override
    @Override  
        }
    public boolean isReadable() {  
import org.opensearch.telemetry.tracing.SpanScope;
}
        }  
 *   <li><b>Non-streaming path:</b> sendResponse() called directly for complete responses
    @Override
    public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {
import org.opensearch.telemetry.tracing.Tracer;  
import org.reactivestreams.Subscriber;
import java.util.List;
    }  
    }  
 *
     * Constructor.
    @Override  
        super(delegate, span, tracer);
    public void subscribe(Subscriber<? super HttpChunk> s) {
     * @param delegate delegate  
class TraceableStreamingRestChannel extends TraceableRestChannel<StreamingRestChannel> implements StreamingRestChannel {
     *
/**
import org.opensearch.http.HttpChunk;
        // End the span when the last chunk is sent  
    }
        }
 * this file be licensed under the Apache-2.0 license or a
    /**  
import org.opensearch.core.rest.RestStatus;
    TraceableStreamingRestChannel(StreamingRestChannel delegate, Span span, Tracer tracer) {
 * The OpenSearch Contributors require contributions made to  
    }  
 */  
        delegate.subscribe(s);
        try (SpanScope ignored = tracer.withSpanInScope(span)) {  
 *       that don't require chunk-by-chunk streaming.</li>  
 *   <li><b>Streaming path:</b> prepareResponse() followed by multiple sendChunk() calls.  
import org.opensearch.rest.StreamingRestChannel;  
    @Override
 *  
     * @param span span
package org.opensearch.telemetry.tracing.channels;
     * @param tracer tracer
    public void sendChunk(HttpChunk chunk) {  
            delegate.prepareResponse(status, headers);
 * </ul>
 * Tracer wrapped {@link StreamingRestChannel} for distributed tracing support.
/*  
        return delegate.isReadable();
 * <ul>
 */  
    }
 *
    }
        try (SpanScope ignored = tracer.withSpanInScope(span)) {
        if (chunk.isLast()) {
        return delegate.isWritable();  
        // Each chunk operation executes within the span scope for proper trace context propagation
import org.opensearch.telemetry.tracing.Span;
 * <p>This channel supports two response patterns:
            delegate.sendChunk(chunk);  
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
     */  
 * compatible open source license.
 *       Each chunk is sent within its own span scope for proper trace context propagation.</li>
