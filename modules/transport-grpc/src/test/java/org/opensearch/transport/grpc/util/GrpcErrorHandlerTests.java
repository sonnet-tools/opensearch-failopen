        // Test that root_cause analysis is included like HTTP responses  
 * compatible open source license.
            @Override
import org.opensearch.test.OpenSearchTestCase;  
        JsonParseException exception = new JsonParseException("Unexpected character");
        assertFalse(result.getMessage().contains("details="));
    public void testIllegalStateExceptionConversion() {  
    public void testJsonParseExceptionConversion() {  
        assertTrue(result.getMessage().contains("java.io.IOException: I/O error"));
        OpenSearchException wrappedException = new OpenSearchException("Wrapper exception", rootCause) {
        // Should include phase information in XContent
    public void testCircuitBreakingExceptionInCleanMessage() {
        // InterruptedException -> CANCELLED via direct gRPC mapping
            new org.opensearch.action.search.ShardSearchFailure[0]  
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
    public void testOpenSearchExceptionConversion() {
 * SPDX-License-Identifier: Apache-2.0
        // SecurityException -> PERMISSION_DENIED via direct gRPC mapping
        assertEquals(Status.NOT_FOUND.getCode(), result.getStatus().getCode());
        IllegalStateException exception = new IllegalStateException("Invalid state");
        );
    public void testSecurityExceptionConversion() {
        assertTrue(result.getMessage().contains("java.lang.InterruptedException"));
        assertTrue(result.getMessage().contains("details="));
                return RestStatus.BAD_REQUEST;
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
    }
        assertTrue(result.getMessage().contains("Root cause"));
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
 *
            "Search failed",
        assertTrue(result.getMessage().contains("Thread pool full"));  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
                org.opensearch.core.xcontent.ToXContent.Params params
        };
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
    }
    }
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
/*  
                return RestStatus.BAD_REQUEST;
        assertTrue(result.getMessage().contains("details="));  
    }
        assertTrue(result.getMessage().contains("SearchPhaseExecutionException[Search failed]"));
    public void testIllegalArgumentExceptionConversion() {
        assertTrue(result.getMessage().contains("\"type\":\"exception\""));
                return RestStatus.NOT_FOUND;
        assertTrue(result.getMessage().contains("\"test_key\":\"test_value\""));
        // RuntimeException -> INTERNAL via fallback (unknown exception type)  
    public void testInputCoercionExceptionConversion() {  
        assertTrue(result.getMessage().contains("java.lang.IllegalStateException: Invalid state"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    }
    }  
                // Simulate XContent failure  
            "query",
    }  
        InputCoercionException exception = new InputCoercionException("Cannot coerce string to number");
        // InputCoercionException -> INVALID_ARGUMENT via direct gRPC mapping
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(wrappedException);  
        assertTrue(result.getMessage().contains("OpenSearchException[null]"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(null);  
        // NOT_FOUND -> NOT_FOUND via RestToGrpcStatusConverter
        };  
        OpenSearchException exception = new OpenSearchException("Test exception") {
    public void testNullExceptionConversion() {
        OpenSearchException exception = new OpenSearchException("Test exception") {  
        assertEquals("INTERNAL: Unexpected null exception", result.getMessage());
            @Override
    public void testTimeoutExceptionConversion() {
        assertTrue(result.getMessage().contains("details="));
 * Validates that exceptions are properly converted to appropriate gRPC StatusRuntimeException  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
import org.opensearch.core.common.breaker.CircuitBreakingException;  
    }  
import java.util.concurrent.TimeoutException;
        OpenSearchException exception = new OpenSearchException((String) null) {
            }
    public void testInterruptedExceptionConversion() {  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
        // IllegalArgumentException -> INVALID_ARGUMENT via direct gRPC mapping  
        // Should not contain details when extraction fails
import org.opensearch.tools.jackson.core.JsonParseException;
        assertTrue(result.getMessage().contains("OpenSearchException[Test exception]"));  
 */
import org.opensearch.action.search.SearchPhaseExecutionException;
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
            @Override
public class GrpcErrorHandlerTests extends OpenSearchTestCase {  
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertEquals(Status.UNAVAILABLE.getCode(), result.getStatus().getCode());  
        assertTrue(result.getMessage().contains("OpenSearchRejectedExecutionException"));
                return RestStatus.BAD_REQUEST;
        assertTrue(result.getMessage().contains("Wrapper exception"));
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging  
        OpenSearchException exception = new OpenSearchException("Test with metadata") {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
        assertEquals(Status.RESOURCE_EXHAUSTED.getCode(), result.getStatus().getCode());  
        assertTrue(result.getMessage().contains("java.lang.IllegalArgumentException: Invalid parameter"));  
        // SearchPhaseExecutionException extends OpenSearchException with SERVICE_UNAVAILABLE -> UNAVAILABLE
            public RestStatus status() {
            @Override
        // Should include metadata in JSON details
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging  
            public RestStatus status() {  
        assertTrue(result.getMessage().contains("java.util.concurrent.TimeoutException: Operation timed out"));  
        // TimeoutException -> DEADLINE_EXCEEDED via direct gRPC mapping  
        IOException exception = new IOException("I/O error");  
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());  
        // Uses ExceptionsHelper.summaryMessage() format + XContent details
    }  
        assertEquals(Status.FAILED_PRECONDITION.getCode(), result.getStatus().getCode());  
        CircuitBreakingException exception = new CircuitBreakingException("Memory circuit breaker", 100, 90, null);  
        assertTrue(result.getMessage().contains("java.lang.SecurityException: Access denied"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
package org.opensearch.transport.grpc.util;
import java.io.IOException;
    }  
        assertEquals(Status.DEADLINE_EXCEEDED.getCode(), result.getStatus().getCode());
    public void testSearchPhaseExecutionExceptionInCleanMessage() {
        RuntimeException exception = new RuntimeException("Unknown error");
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
            }
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
    public void testXContentMetadataExtractionSuccess() {
 */  
 * The OpenSearch Contributors require contributions made to  
        };  
        // Uses ExceptionsHelper.summaryMessage() format + XContent details for OpenSearchException
    }
        exception.addMetadata("opensearch.test_key", "test_value");
        // Test graceful handling when XContent extraction fails  
import org.opensearch.tools.jackson.core.InputCoercionException;
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
            }
        assertTrue(result.getMessage().contains("root_cause"));  
        // IllegalStateException -> FAILED_PRECONDITION via direct gRPC mapping
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());  
        assertTrue(result.getMessage().contains("\"status\":400"));
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());  
        OpenSearchException rootCause = new OpenSearchException("Root cause") {
        assertTrue(result.getMessage().contains("\"reason\":\"Test exception\""));  
}  
            @Override
                return RestStatus.BAD_REQUEST;  
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertTrue(result.getMessage().contains("OpenSearchException[Test exception]"));  
        SecurityException exception = new SecurityException("Access denied");  
            public RestStatus status() {  
        assertEquals(Status.CANCELLED.getCode(), result.getStatus().getCode());  
            public RestStatus status() {  
    public void testUnknownExceptionConversion() {
        assertTrue(result.getMessage().contains("CircuitBreakingException[Memory circuit breaker]"));
        assertEquals(Status.RESOURCE_EXHAUSTED.getCode(), result.getStatus().getCode());
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchRejectedExecutionException exception = new OpenSearchRejectedExecutionException("Thread pool full");
    public void testXContentMetadataExtractionFailure() {
        };  
            @Override
 * Tests for GrpcErrorHandler utility.
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
    public void testOpenSearchRejectedExecutionExceptionConversion() {  
        // OpenSearchRejectedExecutionException -> RESOURCE_EXHAUSTED via direct gRPC mapping
        assertTrue(result.getMessage().contains("java.lang.RuntimeException: Unknown error"));  
import org.opensearch.core.rest.RestStatus;
        // BAD_REQUEST -> INVALID_ARGUMENT via RestToGrpcStatusConverter  
        assertTrue(result.getMessage().contains("Unexpected character"));  
        // Uses ExceptionsHelper.summaryMessage() format + XContent details for OpenSearchException  
        IllegalArgumentException exception = new IllegalArgumentException("Invalid parameter");
        assertTrue(result.getMessage().contains("Cannot coerce string to number"));  
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
    }  
        // null -> INTERNAL via case null handling
        InterruptedException exception = new InterruptedException();
        // JsonParseException -> INVALID_ARGUMENT via direct gRPC mapping
        // Uses ExceptionsHelper.summaryMessage() format + XContent details  
        assertEquals(Status.PERMISSION_DENIED.getCode(), result.getStatus().getCode());
    }  
import org.opensearch.OpenSearchException;
            }  
            }
        assertTrue(result.getMessage().contains("details="));
            }
        assertTrue(result.getMessage().contains("InputCoercionException"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    public void testIOExceptionConversion() {
    }  
        // Should fall back to base description when XContent extraction fails
            public void metadataToXContent(
            }
        assertTrue(result.getMessage().contains("details="));  
    public void testOpenSearchExceptionWithNullMessage() {  
        assertTrue(result.getMessage().contains("\"phase\":\"query\""));
    }
        // Should include root_cause array like HTTP responses
    public void testRootCauseAnalysis() {
        // Test that XContent metadata extraction works for OpenSearchException  
            public RestStatus status() {  
                return RestStatus.INTERNAL_SERVER_ERROR;
        TimeoutException exception = new TimeoutException("Operation timed out");
        };
        // CircuitBreakingException extends OpenSearchException with TOO_MANY_REQUESTS -> RESOURCE_EXHAUSTED
            @Override  
    }
        };  
        // IOException -> INTERNAL via direct gRPC mapping
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);  
 * using ExceptionsHelper.summaryMessage() and RestToGrpcStatusConverter for HTTP parity.
                throw new IOException("XContent failure");
    }
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(  
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
                org.opensearch.core.xcontent.XContentBuilder builder,  
        assertTrue(result.getMessage().contains("JsonParseException"));
            ) throws java.io.IOException {
import io.grpc.StatusRuntimeException;
import io.grpc.Status;
/**
            public RestStatus status() {
        assertTrue(result.getMessage().contains("\"status\":400"));
    }
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
