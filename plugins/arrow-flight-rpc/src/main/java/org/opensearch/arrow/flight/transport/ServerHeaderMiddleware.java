            headerBuffer.get(headerBytes);
 */
    @Override
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.RAW_HEADER_KEY;
/*  
    }  
    private ByteBuffer headerBuffer;
 * this file be licensed under the Apache-2.0 license or a
            outgoingHeaders.insert(RAW_HEADER_KEY, encodedHeader);
import org.apache.arrow.flight.RequestContext;
            outgoingHeaders.insert(CORRELATION_ID_KEY, requestId);  
import org.apache.arrow.flight.FlightServerMiddleware;
    public void onBeforeSendingHeaders(CallHeaders outgoingHeaders) {
        } else {
 * outgoing headers, retrieved from the incoming headers.
    @Override
 * ServerHeaderMiddleware is created per call to handle the response header
        if (headerBuffer != null) {  
    String getCorrelationId() {  
            byte[] headerBytes = new byte[headerBuffer.remaining()];
            String requestId = incomingHeaders.get(CORRELATION_ID_KEY);
        this.requestId = requestId;
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.CORRELATION_ID_KEY;
    @Override
            return new ServerHeaderMiddleware(requestId);
}
            headerBuffer.rewind();  
        }
 * compatible open source license.
    private final String requestId;
import org.apache.arrow.flight.CallHeaders;
 */  
            String encodedHeader = Base64.getEncoder().encodeToString(headerBytes);  
import org.apache.arrow.flight.CallStatus;  
        return requestId;
    }
    public void onCallCompleted(CallStatus status) {}
        this.headerBuffer = headerBuffer;  
class ServerHeaderMiddleware implements FlightServerMiddleware {  
package org.opensearch.arrow.flight.transport;
        @Override
            outgoingHeaders.insert(RAW_HEADER_KEY, "");
 * The OpenSearch Contributors require contributions made to  
import java.nio.ByteBuffer;
    void setHeader(ByteBuffer headerBuffer) {
    ServerHeaderMiddleware(String requestId) {
    public static class Factory implements FlightServerMiddleware.Factory<ServerHeaderMiddleware> {
/**
        public ServerHeaderMiddleware onCallStarted(CallInfo callInfo, CallHeaders incomingHeaders, RequestContext context) {  
        }  
 * and add it to the outgoing headers. It also adds the request ID to the  
    public void onCallErrored(Throwable err) {}
import org.apache.arrow.flight.CallInfo;
            outgoingHeaders.insert(CORRELATION_ID_KEY, requestId);
    }
 *
import java.util.Base64;
    }
    }
