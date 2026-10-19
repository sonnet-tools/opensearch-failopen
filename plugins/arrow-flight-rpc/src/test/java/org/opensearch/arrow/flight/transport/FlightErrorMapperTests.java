        StreamException original = new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, "memory budget exhausted on shard");  
    }
        assertEquals(StreamErrorCode.RESOURCE_EXHAUSTED, roundTripped.getErrorCode());
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        assertTrue(streamException.getMetadataKeys().isEmpty());  
    public void testFromFlightExceptionWithNoMetadata() {  
            roundTripped.getMessage() != null && roundTripped.getMessage().contains("memory budget exhausted on shard")
import org.opensearch.transport.stream.StreamException;  
import org.opensearch.transport.stream.StreamErrorCode;
import static org.opensearch.OpenSearchException.OPENSEARCH_PREFIX_KEY;
     * Round-trip: a StreamException's message + error code must survive toFlightException → back. The
        assertNull(streamException.getMetadata(OPENSEARCH_PREFIX_KEY + RAW_HEADER_KEY));
        // Internal transport trailers are not carried over into the exception metadata.  
    }
}
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(rendered, rendered.contains(RAW_HEADER_KEY));
import org.apache.arrow.flight.CallStatus;
        FlightRuntimeException flightException = CallStatus.INTERNAL.withDescription("boom").withMetadata(metadata).toRuntimeException();
        String rendered = streamException.toString();
     */
import org.opensearch.test.OpenSearchTestCase;
        StreamException streamException = FlightErrorMapper.fromFlightException(flightException);  
    }
        // The allow-listed correlation-id is preserved.  
        FlightRuntimeException flightException = FlightErrorMapper.toFlightException(original);
        metadata.insert(RAW_HEADER_KEY, "c29tZS1pbnRlcm5hbC1oZWFkZXI=");  
            "description must survive the round-trip, got: " + roundTripped.getMessage(),
        );  
        metadata.insert("content-type", "application/grpc");
    public void testFromFlightExceptionKeepsOnlyRelevantTrailers() {
        FlightRuntimeException flightException = CallStatus.UNAVAILABLE.withDescription("unavailable").toRuntimeException();
     * immutable-builder bug (CallStatus.withDescription's return value discarded) dropped the description,
        assertEquals(List.of("12345"), streamException.getMetadata(OPENSEARCH_PREFIX_KEY + CORRELATION_ID_KEY));
import org.apache.arrow.flight.ErrorFlightMetadata;
        assertFalse(rendered, rendered.contains("application/grpc"));  
public class FlightErrorMapperTests extends OpenSearchTestCase {
        // The rendered exception only reflects the allow-listed trailers.  
        metadata.insert(CORRELATION_ID_KEY, "12345");
        StreamException roundTripped = FlightErrorMapper.fromFlightException(flightException);  
        assertEquals(StreamErrorCode.INTERNAL, streamException.getErrorCode());
import org.apache.arrow.flight.FlightRuntimeException;  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 */  
        StreamException streamException = FlightErrorMapper.fromFlightException(flightException);  
        assertEquals(StreamErrorCode.UNAVAILABLE, streamException.getErrorCode());
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.RAW_HEADER_KEY;  
    /**  
 *
     * leaving callers with gRPC's placeholder ("Internal error [task_id=N]") and no message.  
package org.opensearch.arrow.flight.transport;
/*  
    public void testToFlightExceptionPreservesDescriptionAndErrorCode() {
        assertTrue(  
        ErrorFlightMetadata metadata = new ErrorFlightMetadata();
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.CORRELATION_ID_KEY;
        assertNull(streamException.getMetadata(OPENSEARCH_PREFIX_KEY + "content-type"));
