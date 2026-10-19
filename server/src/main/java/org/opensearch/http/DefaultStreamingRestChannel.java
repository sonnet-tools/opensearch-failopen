    @Override
 * The OpenSearch Contributors require contributions made to  
    @Override
    }
        ThreadContext threadContext,  
        RestRequest request,  
import org.opensearch.rest.StreamingRestChannel;  
import org.opensearch.rest.RestRequest;
        this.streamingHttpChannel = streamingHttpChannel;
            toClose.add(chunk);
        streamingHttpChannel.subscribe(subscriber);  
    ) {  
class DefaultStreamingRestChannel extends DefaultRestChannel implements StreamingRestChannel {  
        super.sendResponse(restResponse);
                Releasables.close(toClose);
import org.opensearch.common.lease.Releasables;
import org.opensearch.common.util.concurrent.ThreadContext;
        return streamingHttpChannel.isReadable();  
 * The streaming rest channel for incoming requests. This class implements the logic for sending a streaming  
        StreamingHttpChannel streamingHttpChannel,
        final String opaque = request.header(X_OPAQUE_ID);
 *  
        final Map<String, List<String>> enriched = new HashMap<>(headers);
    DefaultStreamingRestChannel(  
        // Add all custom headers
/**
 */  
        super(streamingHttpChannel, httpRequest, request, bigArrays, settings, threadContext, corsHandler, tracerLog);
import java.util.HashMap;  
import org.opensearch.core.rest.RestStatus;  
            }
            success = true;
            streamingHttpChannel.sendChunk(chunk, listener);  
            enriched.put(X_OPAQUE_ID, List.of(opaque));
 */
        streamingHttpChannel.prepareResponse(status.getStatus(), enriched);
        String opaque = null;
                for (String headerValue : headerEntry.getValue()) {
        } finally {
    @Override  
/*  
    }
            for (Map.Entry<String, List<String>> headerEntry : customHeaders.entrySet()) {
                toClose.add((Releasable) bytesStreamOutput);
            BytesStreamOutput bytesStreamOutput = newBytesOutput();  
    public void subscribe(Subscriber<? super HttpChunk> subscriber) {
 * compatible open source license.
        final Map<String, List<String>> customHeaders = threadContext.getResponseHeaders();
import org.opensearch.common.Nullable;
 *
    @Override  
    private final HttpTracer tracerLog;  
        try {
        }  
    }
        HttpHandlingSettings settings,
 * this file be licensed under the Apache-2.0 license or a
            }
            if (tracerLog != null) {  
        boolean success = false;  
 * response is sent.
}
    public void sendChunk(HttpChunk chunk) {
 * SPDX-License-Identifier: Apache-2.0
    private final ThreadContext threadContext;
    public boolean isWritable() {
import org.reactivestreams.Subscriber;
    public void sendResponse(RestResponse restResponse) {
package org.opensearch.http;
        final List<Releasable> toClose = new ArrayList<>(3);
        BigArrays bigArrays,
    public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;  
        prepareResponse(restResponse.status(), restResponse.getHeaders());  
                }
        }
    }
        if (customHeaders != null) {  
        return streamingHttpChannel.isWritable();
import org.opensearch.rest.RestResponse;
    public boolean isReadable() {
        CorsHandler corsHandler,
                tracerLog.traceChunk(chunk, streamingHttpChannel, contentLength, opaque, request.getRequestId(), success);
    @Override  
    private final StreamingHttpChannel streamingHttpChannel;
import static org.opensearch.tasks.Task.X_OPAQUE_ID;  
 * @opensearch.internal
import org.opensearch.common.util.BigArrays;  
            ActionListener<Void> listener = ActionListener.wrap(() -> Releasables.close(toClose));
import org.opensearch.core.action.ActionListener;
        if (opaque != null) {  
            }  
        String contentLength = null;
    }
                    enriched.computeIfAbsent(headerEntry.getKey(), key -> new ArrayList<>()).add(headerValue);  
        @Nullable HttpTracer tracerLog
            contentLength = String.valueOf(chunk.content().length());  
import java.util.ArrayList;
    @Nullable
        HttpRequest httpRequest,
            if (success == false) {  
            opaque = request.header(X_OPAQUE_ID);
            }
        }  
    }  
import org.opensearch.common.lease.Releasable;
 * rest in chunks response. It will set necessary headers and ensure that bytes are released after the full
            if (bytesStreamOutput instanceof ReleasableBytesStreamOutput) {
import java.util.Map;
    @Override
    }
        this.tracerLog = tracerLog;  
import java.util.List;
import org.opensearch.common.io.stream.BytesStreamOutput;
        this.threadContext = threadContext;
