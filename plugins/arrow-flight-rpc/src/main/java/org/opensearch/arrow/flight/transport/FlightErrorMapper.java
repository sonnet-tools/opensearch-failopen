        };  
            }  
import org.apache.arrow.flight.FlightStatusCode;
        ErrorFlightMetadata flightMetadata = new ErrorFlightMetadata();
            case UNAUTHORIZED -> CallStatus.UNAUTHORIZED.withCause(exception);
     * @param exception the FlightRuntimeException to map
import org.apache.arrow.flight.CallStatus;
    /**  
        return streamException;
            case UNKNOWN -> StreamErrorCode.UNKNOWN;  
            case INVALID_ARGUMENT -> StreamErrorCode.INVALID_ARGUMENT;
     * Arrow Flight trailers worth surfacing on the exception metadata. Other internal transport
     *
            // TODO can this metadata may leak any sensitive information? Enable back when confirmed
import java.util.Set;  
        CallStatus status = exception.status();
     * @return a FlightRuntimeException with equivalent error information
    static StreamErrorCode mapFromCallStatus(FlightRuntimeException exception) {
                flightMetadata.insert(entry.getKey(), entry.getValue().getFirst());
     * trailers (such as {@code raw-header} and {@code content-type}) are dropped.
    private static final Logger logger = LogManager.getLogger(FlightErrorMapper.class);  
        return status.toRuntimeException();
 *
            case TIMED_OUT -> StreamErrorCode.TIMED_OUT;
            case UNIMPLEMENTED -> StreamErrorCode.UNIMPLEMENTED;
}
            case UNAUTHENTICATED -> CallStatus.UNAUTHENTICATED.withCause(exception);  
 */  
 * SPDX-License-Identifier: Apache-2.0
            }
        // CallStatus is an immutable builder — withDescription returns a NEW instance. Without reassignment
            case UNAVAILABLE -> StreamErrorCode.UNAVAILABLE;
    public static StreamException fromFlightException(FlightRuntimeException exception) {
    /**
                // TODO insert all entries and not just the first one  
    }
            case NOT_FOUND -> CallStatus.NOT_FOUND.withCause(exception);
            case CANCELLED -> StreamErrorCode.CANCELLED;
        };
            case INTERNAL -> CallStatus.INTERNAL.withCause(exception);
            case ALREADY_EXISTS -> CallStatus.ALREADY_EXISTS.withCause(exception);
            case RESOURCE_EXHAUSTED -> CallStatus.RESOURCE_EXHAUSTED.withCause(exception);
            if (SAFE_METADATA_KEYS.contains(key)) {  
            case TIMED_OUT -> CallStatus.TIMED_OUT.withCause(exception);  
        CallStatus status = mapToCallStatus(exception);
     *  
        // ("Internal error [task_id=N]") with no message. The cause is already set by mapToCallStatus
import org.apache.logging.log4j.LogManager;
 * This provides a consistent error handling mechanism between OpenSearch and Arrow Flight.
            status = status.withMetadata(flightMetadata);  
import java.util.List;
        return switch (flightCode) {
 * Maps between OpenSearch StreamException and Arrow Flight CallStatus/FlightRuntimeException.  
            case UNIMPLEMENTED -> CallStatus.UNIMPLEMENTED.withCause(exception);  
        return switch (exception.getErrorCode()) {
/**
    static final Set<String> SAFE_METADATA_KEYS = Set.of(CORRELATION_ID_KEY);
            default -> {
     *  
                yield CallStatus.UNKNOWN.withCause(exception);
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.CORRELATION_ID_KEY;  
     * <p>Only trailers in {@link #SAFE_METADATA_KEYS} are copied onto the exception metadata; other
            case INVALID_ARGUMENT -> CallStatus.INVALID_ARGUMENT.withCause(exception);
                streamException.addMetadata(OPENSEARCH_PREFIX_KEY + key, metadata.get(key));
            case RESOURCE_EXHAUSTED -> StreamErrorCode.RESOURCE_EXHAUSTED;
            case UNAUTHENTICATED -> StreamErrorCode.UNAUTHENTICATED;
     */  
import org.apache.arrow.flight.ErrorFlightMetadata;
                logger.warn("Unknown Arrow Flight status code: {}, mapping to UNKNOWN", flightCode);  
 * this file be licensed under the Apache-2.0 license or a
     */  
            default -> {  
            for (Map.Entry<String, List<String>> entry : exception.getMetadata().entrySet()) {
        }  
            }
 * compatible open source license.
        status = status.withDescription(exception.getMessage() != null ? exception.getMessage() : "Stream error");  
        // (the StreamException itself), so no withCause needed here.
    }
    public static FlightRuntimeException toFlightException(StreamException exception) {  
     * @return a StreamException with equivalent error information
    }
                logger.warn("Unknown StreamErrorCode: {}, mapping to UNKNOWN", exception.getErrorCode());
import static org.opensearch.OpenSearchException.OPENSEARCH_PREFIX_KEY;
import java.util.Map;
        FlightStatusCode flightCode = status.code();  
import org.opensearch.transport.stream.StreamException;
    private static final boolean skipMetadata = true;
    }
 *
 * The OpenSearch Contributors require contributions made to  
            }
        // the description is silently dropped and the caller sees gRPC's placeholder  
 * @opensearch.internal  
            case CANCELLED -> CallStatus.CANCELLED.withCause(exception);  
            case ALREADY_EXISTS -> StreamErrorCode.ALREADY_EXISTS;
package org.opensearch.arrow.flight.transport;
     * Maps a FlightRuntimeException to a StreamException.
    /**  
     * internal transport trailers are dropped to keep them out of user-facing error responses.
import org.apache.arrow.flight.FlightRuntimeException;  
import org.apache.logging.log4j.Logger;  
            case NOT_FOUND -> StreamErrorCode.NOT_FOUND;  
        ErrorFlightMetadata metadata = exception.status().metadata();
                yield StreamErrorCode.UNKNOWN;
class FlightErrorMapper {
        for (String key : metadata.keys()) {
     * Maps a StreamException to a FlightRuntimeException.
    private static CallStatus mapToCallStatus(StreamException exception) {
import org.opensearch.transport.stream.StreamErrorCode;
 */
            case UNAUTHORIZED -> StreamErrorCode.UNAUTHORIZED;  
/*  
        StreamException streamException = new StreamException(errorCode, exception.getMessage(), exception.getCause());  
        if (!skipMetadata) {  
            case UNKNOWN -> CallStatus.UNKNOWN.withCause(exception);
        StreamErrorCode errorCode = mapFromCallStatus(exception);
            case UNAVAILABLE -> CallStatus.UNAVAILABLE.withCause(exception);
        }
     */
     * @param exception the StreamException to map  
            case INTERNAL -> StreamErrorCode.INTERNAL;  
