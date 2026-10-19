     * Processes incoming headers from the Arrow Flight server response.
        try {
 */  
}  
    public void onCallCompleted(CallStatus status) {}
import org.opensearch.transport.Header;
        public ClientHeaderMiddleware onCallStarted(CallInfo callInfo) {
                    "Incompatible version: " + header.getVersion() + ", current: " + Version.CURRENT
     * @param incomingHeaders The headers received from the Arrow Flight server
 *
         * @param version The OpenSearch version for compatibility checking  
            // Store the header in context for later retrieval
import java.util.Base64;  
import org.opensearch.core.common.bytes.BytesArray;  
import org.apache.arrow.flight.FlightClientMiddleware;
    static final String CORRELATION_ID_KEY = "correlation-id";  
            BytesReference headerRef = new BytesArray(headerBuffer);
     * @param version The OpenSearch version for compatibility checking  
        }  
     *
    /**
import org.opensearch.core.common.bytes.BytesReference;
     * @throws StreamException if headers are missing, invalid, or incompatible  
    }
        String encodedHeader = incomingHeaders.get(RAW_HEADER_KEY);
     */
    ClientHeaderMiddleware(HeaderContext context, Version version) {
            context.setHeader(Long.parseLong(correlationId), header);
 * from Arrow Flight server responses, extracts transport headers, and stores them in the HeaderContext
 *
        @Override
            throw new StreamException(StreamErrorCode.INVALID_ARGUMENT, "Missing required header: " + RAW_HEADER_KEY);
    public static class Factory implements FlightClientMiddleware.Factory {
/**  
        }
        }
            throw new StreamException(StreamErrorCode.INVALID_ARGUMENT, "Missing required header: " + CORRELATION_ID_KEY);
    }
 */  
            if (!Version.CURRENT.isCompatible(header.getVersion())) {
                throw new StreamException(  
import org.apache.arrow.flight.CallHeaders;
 * The OpenSearch Contributors require contributions made to  
            this.context = Objects.requireNonNull(context, "HeaderContext must not be null");  
        } catch (NumberFormatException e) {
import org.opensearch.Version;
        String correlationId = incomingHeaders.get(CORRELATION_ID_KEY);
import org.apache.arrow.flight.CallStatus;  
import java.io.IOException;
        this.context = Objects.requireNonNull(context, "HeaderContext must not be null");  
        if (encodedHeader == null) {
 * @opensearch.internal
    /**
    public void onHeadersReceived(CallHeaders incomingHeaders) {  
     * Creates a new ClientHeaderMiddleware instance.  
            Header header = InboundDecoder.readHeader(version, headerRef.length(), headerRef);  
    @Override
     * Factory for creating ClientHeaderMiddleware instances.
     *
/*  
            }
     * Extracts, decodes, and validates the transport header, then stores it in the context.  
     * @param context The header context for storing extracted headers
     */
         */
import org.apache.arrow.flight.CallInfo;
            byte[] headerBuffer = Base64.getDecoder().decode(encodedHeader);  
            throw new StreamException(StreamErrorCode.INVALID_ARGUMENT, "Invalid request ID format: " + correlationId, e);  
    }
         * Creates a new Factory instance.  
import org.opensearch.transport.InboundDecoder;  
         * @param context The header context for storing extracted headers
    private final Version version;  
import java.util.Objects;
        }  
        Factory(HeaderContext context, Version version) {
         *
        } catch (IOException e) {  
            throw new StreamException(StreamErrorCode.INTERNAL, "Failed to decode header", e);
class ClientHeaderMiddleware implements FlightClientMiddleware {
        private final HeaderContext context;  
    public void onBeforeSendingHeaders(CallHeaders outgoingHeaders) {}
import org.opensearch.transport.stream.StreamErrorCode;
            }
        /**
                );  
        this.version = Objects.requireNonNull(version, "Version must not be null");
        if (correlationId == null) {
    @Override
            if (TransportStatus.isError(header.getStatus())) {  
            return new ClientHeaderMiddleware(context, version);  
        }
                throw new StreamException(StreamErrorCode.INTERNAL, "Received error response with status: " + header.getStatus());
 * for later retrieval.  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                    StreamErrorCode.UNAVAILABLE,
import org.opensearch.transport.stream.StreamException;  
    private final HeaderContext context;
        private final Version version;
    /**
     */  
import org.opensearch.transport.TransportStatus;
    static final String RAW_HEADER_KEY = "raw-header";
    @Override
package org.opensearch.arrow.flight.transport;
 * compatible open source license.
            this.version = Objects.requireNonNull(version, "Version must not be null");
 * Client middleware for handling Arrow Flight headers. This middleware processes incoming headers
