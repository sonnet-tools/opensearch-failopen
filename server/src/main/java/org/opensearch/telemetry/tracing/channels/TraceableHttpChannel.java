     * @param delegate delegate  
    }  
    }
            return delegate;  
    @Override
import org.opensearch.telemetry.tracing.Tracer;
    public void addCloseListener(ActionListener<Void> listener) {
    @Override  
    @Override  
        this.tracer = Objects.requireNonNull(tracer);  
     *
     * Factory method.
        delegate.addCloseListener(listener);  
import org.opensearch.core.action.ActionListener;
    public void sendResponse(HttpResponse response, ActionListener<Void> listener) {  
import org.opensearch.http.HttpChannel;
        return delegate.isOpen();
     */
    public InetSocketAddress getRemoteAddress() {
    }
 * compatible open source license.
    public <T> Optional<T> get(String name, Class<T> clazz) {  
import java.net.InetSocketAddress;
    private final Span span;
        } else {
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;  
        this.delegate = Objects.requireNonNull(delegate);
import java.util.Objects;  
    }
     * @param delegate delegate
    private TraceableHttpChannel(HttpChannel delegate, Span span, Tracer tracer) {  
    @Override
        span.setError(ex);
import org.opensearch.telemetry.tracing.Span;
    }  
    }
 */
 * The OpenSearch Contributors require contributions made to  
    private final HttpChannel delegate;
    @Override
/**  
public class TraceableHttpChannel implements HttpChannel {  
    public void close() {  
    }
        return delegate.get(name, clazz);
    private final Tracer tracer;  
    /**  
    }
     *
        span.addEvent("The HttpChannel was closed without sending the response");  
    public static HttpChannel create(HttpChannel delegate, Span span, Tracer tracer) {
package org.opensearch.telemetry.tracing.channels;
        return delegate.getLocalAddress();  
    }
            return new TraceableHttpChannel(delegate, span, tracer);
        delegate.close();
        span.endSpan();
     * @param span     span  
 * SPDX-License-Identifier: Apache-2.0
     * @param span     span
    public InetSocketAddress getLocalAddress() {
        return delegate.getRemoteAddress();
     * @param tracer tracer
import java.util.Optional;
    public boolean isOpen() {
    @Override
    @Override
 */  
    /**
    @Override
     */
}  
 * Tracer wrapped {@link HttpChannel}
 * this file be licensed under the Apache-2.0 license or a
        if (tracer.isRecording() == true) {  
     * @param tracer tracer
        }
        this.span = Objects.requireNonNull(span);
 *
        delegate.sendResponse(response, TraceableActionListener.create(listener, span, tracer));
     * Constructor.  
    public void handleException(Exception ex) {
    }  
     * @return http channel  
/*  
import org.opensearch.http.HttpResponse;  
