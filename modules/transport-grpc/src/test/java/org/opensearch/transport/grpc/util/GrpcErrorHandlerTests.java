            public RestStatus status() {
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
        // IllegalArgumentException -> INVALID_ARGUMENT via direct gRPC mapping
        };
        // SearchPhaseExecutionException extends OpenSearchException with SERVICE_UNAVAILABLE -> UNAVAILABLE
            public RestStatus status() {
import java.io.IOException;
        OpenSearchException rootCause = new OpenSearchException("Root cause") {
            ) throws java.io.IOException {
        // Uses ExceptionsHelper.summaryMessage() format + XContent details for OpenSearchException
 * this file be licensed under the Apache-2.0 license or a
 * Tests for GrpcErrorHandler utility.
    }
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
                org.opensearch.core.xcontent.XContentBuilder builder,
import org.opensearch.tools.jackson.core.JsonParseException;
 * compatible open source license.
        OpenSearchRejectedExecutionException exception = new OpenSearchRejectedExecutionException("Thread pool full");
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    public void testJsonParseExceptionConversion() {
    }
        // Should fall back to base description when XContent extraction fails
        assertEquals(Status.CANCELLED.getCode(), result.getStatus().getCode());
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        IllegalStateException exception = new IllegalStateException("Invalid state");
            }
    }
            new org.opensearch.action.search.ShardSearchFailure[0]
                return RestStatus.BAD_REQUEST;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());
    public void testOpenSearchRejectedExecutionExceptionConversion() {
        // Uses ExceptionsHelper.summaryMessage() format + XContent details
        OpenSearchException wrappedException = new OpenSearchException("Wrapper exception", rootCause) {
        // TimeoutException -> DEADLINE_EXCEEDED via direct gRPC mapping
    }
import io.grpc.StatusRuntimeException;
        RuntimeException exception = new RuntimeException("Unknown error");
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
        assertTrue(result.getMessage().contains("\"status\":400"));
    public void testNullExceptionConversion() {
    public void testOpenSearchExceptionWithNullMessage() {
        assertTrue(result.getMessage().contains("OpenSearchException[Test exception]"));
            }
        assertTrue(result.getMessage().contains("root_cause"));
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
        assertTrue(result.getMessage().contains("OpenSearchException[Test exception]"));
        };
    }
        assertEquals(Status.UNAVAILABLE.getCode(), result.getStatus().getCode());
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        assertTrue(result.getMessage().contains("Thread pool full"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    }
        assertTrue(result.getMessage().contains("details="));
/*
        assertTrue(result.getMessage().contains("SearchPhaseExecutionException[Search failed]"));
}
    public void testXContentMetadataExtractionFailure() {
            public RestStatus status() {
        assertTrue(result.getMessage().contains("details="));
        // Uses ExceptionsHelper.summaryMessage() format + XContent details
        SecurityException exception = new SecurityException("Access denied");
public class GrpcErrorHandlerTests extends OpenSearchTestCase {
        // Should include phase information in XContent
                return RestStatus.NOT_FOUND;
        IllegalArgumentException exception = new IllegalArgumentException("Invalid parameter");
        // null -> INTERNAL via case null handling
import org.opensearch.tools.jackson.core.InputCoercionException;
            }
        exception.addMetadata("opensearch.test_key", "test_value");
    public void testUnknownExceptionConversion() {
import io.grpc.Status;
                throw new IOException("XContent failure");
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    }
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertTrue(result.getMessage().contains("java.lang.InterruptedException"));
            @Override
        assertEquals(Status.INVALID_ARGUMENT.getCode(), result.getStatus().getCode());
        assertTrue(result.getMessage().contains("JsonParseException"));
        };
        assertTrue(result.getMessage().contains("java.io.IOException: I/O error"));
        assertFalse(result.getMessage().contains("details="));
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());
        InputCoercionException exception = new InputCoercionException("Cannot coerce string to number");
 */
    }
 * Validates that exceptions are properly converted to appropriate gRPC StatusRuntimeException
            public RestStatus status() {
    }
        assertTrue(result.getMessage().contains("\"status\":400"));
        assertEquals(Status.DEADLINE_EXCEEDED.getCode(), result.getStatus().getCode());
        assertTrue(result.getMessage().contains("details="));
    }
        assertTrue(result.getMessage().contains("details="));
                return RestStatus.BAD_REQUEST;
                // Simulate XContent failure
import org.opensearch.core.common.breaker.CircuitBreakingException;
        OpenSearchException exception = new OpenSearchException("Test exception") {
        // IOException -> INTERNAL via direct gRPC mapping
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        // RuntimeException -> INTERNAL via fallback (unknown exception type)
 * SPDX-License-Identifier: Apache-2.0
                return RestStatus.BAD_REQUEST;
    }
        assertTrue(result.getMessage().contains("Unexpected character"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
package org.opensearch.transport.grpc.util;
    }
    public void testIllegalStateExceptionConversion() {
        // Test that XContent metadata extraction works for OpenSearchException
    public void testCircuitBreakingExceptionInCleanMessage() {
            public RestStatus status() {
    }
import org.opensearch.test.OpenSearchTestCase;
    }
        // InterruptedException -> CANCELLED via direct gRPC mapping
        assertEquals(Status.RESOURCE_EXHAUSTED.getCode(), result.getStatus().getCode());
        // CircuitBreakingException extends OpenSearchException with TOO_MANY_REQUESTS -> RESOURCE_EXHAUSTED
    public void testIOExceptionConversion() {
        // Should include root_cause array like HTTP responses
        // JsonParseException -> INVALID_ARGUMENT via direct gRPC mapping
            public RestStatus status() {
        assertTrue(result.getMessage().contains("\"type\":\"exception\""));
            @Override
 * using ExceptionsHelper.summaryMessage() and RestToGrpcStatusConverter for HTTP parity.
import org.opensearch.core.rest.RestStatus;
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
            "query",
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        InterruptedException exception = new InterruptedException();
 */
        assertEquals(Status.NOT_FOUND.getCode(), result.getStatus().getCode());
            @Override
        assertEquals(Status.RESOURCE_EXHAUSTED.getCode(), result.getStatus().getCode());
        assertTrue(result.getMessage().contains("OpenSearchRejectedExecutionException"));
            }
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
    public void testTimeoutExceptionConversion() {
    }
            @Override
    }
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertTrue(result.getMessage().contains("java.util.concurrent.TimeoutException: Operation timed out"));
        OpenSearchException exception = new OpenSearchException("Test with metadata") {
        // SecurityException -> PERMISSION_DENIED via direct gRPC mapping
        assertTrue(result.getMessage().contains("java.lang.IllegalStateException: Invalid state"));
                org.opensearch.core.xcontent.ToXContent.Params params
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
    public void testSearchPhaseExecutionExceptionInCleanMessage() {
            @Override
    }
    public void testInputCoercionExceptionConversion() {
/**
        TimeoutException exception = new TimeoutException("Operation timed out");
        // Uses ExceptionsHelper.summaryMessage() format + XContent details for OpenSearchException
    public void testOpenSearchExceptionConversion() {
        assertEquals("INTERNAL: Unexpected null exception", result.getMessage());
 * The OpenSearch Contributors require contributions made to
        assertTrue(result.getMessage().contains("Root cause"));
        JsonParseException exception = new JsonParseException("Unexpected character");
        assertTrue(result.getMessage().contains("java.lang.SecurityException: Access denied"));
        // Should include metadata in JSON details
        assertTrue(result.getMessage().contains("\"reason\":\"Test exception\""));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        CircuitBreakingException exception = new CircuitBreakingException("Memory circuit breaker", 100, 90, null);
        // OpenSearchRejectedExecutionException -> RESOURCE_EXHAUSTED via direct gRPC mapping
        OpenSearchException exception = new OpenSearchException((String) null) {
        IOException exception = new IOException("I/O error");
        assertTrue(result.getMessage().contains("\"test_key\":\"test_value\""));
    }
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        // Test graceful handling when XContent extraction fails
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        // Should not contain details when extraction fails
        assertTrue(result.getMessage().contains("\"phase\":\"query\""));
        };
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertTrue(result.getMessage().contains("OpenSearchException[null]"));
        assertTrue(result.getMessage().contains("java.lang.IllegalArgumentException: Invalid parameter"));
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        // NOT_FOUND -> NOT_FOUND via RestToGrpcStatusConverter
            @Override
        assertTrue(result.getMessage().contains("java.lang.RuntimeException: Unknown error"));
        // BAD_REQUEST -> INVALID_ARGUMENT via RestToGrpcStatusConverter
        assertEquals(Status.FAILED_PRECONDITION.getCode(), result.getStatus().getCode());
        OpenSearchException exception = new OpenSearchException("Test exception") {
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        assertTrue(result.getMessage().contains("Wrapper exception"));
        // IllegalStateException -> FAILED_PRECONDITION via direct gRPC mapping
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    public void testXContentMetadataExtractionSuccess() {
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        );
 *
            @Override
            }
        assertTrue(result.getMessage().contains("CircuitBreakingException[Memory circuit breaker]"));
        // Test that root_cause analysis is included like HTTP responses
        };
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(
            public void metadataToXContent(
    public void testIllegalArgumentExceptionConversion() {
import org.opensearch.OpenSearchException;
        assertTrue(result.getMessage().contains("InputCoercionException"));
import org.opensearch.action.search.SearchPhaseExecutionException;
        };
            "Search failed",
        assertEquals(Status.INTERNAL.getCode(), result.getStatus().getCode());
            }
        assertTrue(result.getMessage().contains("Cannot coerce string to number"));
            }
        assertEquals(Status.PERMISSION_DENIED.getCode(), result.getStatus().getCode());
                return RestStatus.BAD_REQUEST;
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
    public void testInterruptedExceptionConversion() {
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(exception);
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(wrappedException);
import java.util.concurrent.TimeoutException;
        StatusRuntimeException result = GrpcErrorHandler.convertToGrpcError(null);
        // Uses ExceptionsHelper.stackTrace() - includes full stack trace for debugging
        // InputCoercionException -> INVALID_ARGUMENT via direct gRPC mapping
        assertTrue(result.getMessage().contains("details="));
                return RestStatus.INTERNAL_SERVER_ERROR;
    public void testSecurityExceptionConversion() {
    public void testRootCauseAnalysis() {
