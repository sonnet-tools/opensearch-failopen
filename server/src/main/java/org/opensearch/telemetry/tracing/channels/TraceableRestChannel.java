    public boolean detailedErrorStackTraceEnabled() {
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.rest.StreamingRestChannel;
        return delegate.request();
    /**
    protected final Tracer tracer;
        return delegate.newBuilder(mediaType, responseContentType, useFiltering);
        } finally {
import org.opensearch.telemetry.tracing.Span;
            return new TraceableRestChannel<>(delegate, span, tracer);
            span.endSpan();
import java.util.Objects;
    }  
     * @param delegate delegate
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.RestChannel;
}
        return delegate.newErrorBuilder();  
 * compatible open source license.
import java.io.IOException;  
        return delegate.newBuilder(mediaType, useFiltering);
import org.opensearch.core.xcontent.MediaType;
                return new TraceableStreamingRestChannel(streamingRestChannel, span, tracer);  
 * SPDX-License-Identifier: Apache-2.0
 */  
     */
 * Tracer wrapped {@link RestChannel}
    protected final Span span;  
    }  
    public XContentBuilder newBuilder(MediaType mediaType, boolean useFiltering) throws IOException {
        } else {  
     * @return rest channel
    }
    @Override  
    public XContentBuilder newBuilder() throws IOException {  
    @Override
     */
     *  
import org.opensearch.telemetry.tracing.SpanScope;  
    /**
    }
    @Override  
        return delegate.newBuilder();
        }  
    public RestRequest request() {
        this.span = Objects.requireNonNull(span);  
        return delegate.detailedErrorsEnabled();
            }
/**  
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override
    }
    public XContentBuilder newErrorBuilder() throws IOException {
    public boolean detailedErrorsEnabled() {  
     * @param span span
        }
import org.opensearch.core.xcontent.XContentBuilder;  
        this.delegate = Objects.requireNonNull(delegate);
     * @param delegate delegate
        return delegate.detailedErrorStackTraceEnabled();  
     * @param tracer tracer  
     * Constructor.
    public XContentBuilder newBuilder(MediaType mediaType, MediaType responseContentType, boolean useFiltering) throws IOException {  
    }  
    @Override
    }  
            return delegate;
    protected final T delegate;
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    }
import org.opensearch.telemetry.tracing.Tracer;
public class TraceableRestChannel<T extends RestChannel> implements RestChannel {  
     * @param span span
    public BytesStreamOutput bytesOutput() {
    }
            delegate.sendResponse(response);  
     * Factory method.  
        this.tracer = Objects.requireNonNull(tracer);
        return delegate.bytesOutput();  
    public void sendResponse(RestResponse response) {
import org.opensearch.rest.RestRequest;
package org.opensearch.telemetry.tracing.channels;
    }
 *
    @Override
    public static RestChannel create(RestChannel delegate, Span span, Tracer tracer) {  
    @Override  
            if (delegate instanceof StreamingRestChannel streamingRestChannel) {
    protected TraceableRestChannel(T delegate, Span span, Tracer tracer) {
import org.opensearch.rest.RestResponse;  
     * @param tracer tracer  
    @Override
        if (tracer.isRecording() == true) {
    @Override
