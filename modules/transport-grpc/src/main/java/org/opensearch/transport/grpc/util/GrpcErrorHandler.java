     * Equivalent to: {@code BytesRestResponse.build()} and {@code OpenSearchException.generateThrowableXContent()}
public class GrpcErrorHandler {
            case InterruptedException interruptedException -> {
        String baseDescription = ExceptionsHelper.summaryMessage(unwrapped);
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(notXContentException)).asRuntimeException();
                logger.warn("Unexpected null exception type, treating as INTERNAL error");
     * Equivalent to: {@code OpenSearchException.generateThrowableXContent()} used by HTTP error responses.
                return handleOpenSearchException(ose);
                return Status.INTERNAL.withDescription(ExceptionsHelper.stackTrace(ioException)).asRuntimeException();
     *
     * @param exception The exception to extract metadata from
            }
import org.opensearch.core.compress.NotXContentException;
 * this file be licensed under the Apache-2.0 license or a
                String jsonString = builder.toString();
            case IOException ioException -> {
        String enhancedDescription = enhanceDescriptionWithXContentMetadata(unwrapped, baseDescription);
            // If XContent extraction fails, log and return base description
    private GrpcErrorHandler() {
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(jsonParseException)).asRuntimeException();
                // Wrap in object like HTTP does in BytesRestResponse.build()
import org.apache.logging.log4j.Logger;
     * with enhanced XContent details for OpenSearchExceptions and full stack traces for debugging.
    }
            case NotXContentException notXContentException -> {
                // Add status field like HTTP does
                builder.field("status", restStatus.getStatus());
                return Status.DEADLINE_EXCEEDED.withDescription(ExceptionsHelper.stackTrace(timeoutException)).asRuntimeException();
            case IllegalStateException illegalStateException -> {
        } catch (Exception e) {
    }
                return Status.FAILED_PRECONDITION.withDescription(ExceptionsHelper.stackTrace(illegalStateException)).asRuntimeException();
     * @return StatusRuntimeException with mapped gRPC status and HTTP-identical error message
import io.grpc.StatusRuntimeException;
            case JsonParseException jsonParseException -> {
                // Get the full JSON structure - identical to HTTP error responses
            case InputCoercionException inputCoercionException -> {
import org.apache.logging.log4j.LogManager;
     * This ensures perfect consistency by reusing the identical serialization logic.
            }
            }
            }
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.tools.jackson.core.JsonParseException;
        }
            }
                OpenSearchException.generateFailureXContent(builder, ToXContent.EMPTY_PARAMS, (Exception) exception, true);
    }
            // ========== 4. Standard Java Exceptions ==========
     * @param baseDescription The base description from ExceptionsHelper.summaryMessage()
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(inputCoercionException)).asRuntimeException();
     * @return Enhanced description with full JSON metadata from XContent
import org.opensearch.tools.jackson.core.InputCoercionException;
/*
            default -> {
        // Custom OpenSearch exceptions which extend {@link OpenSearchException}.
    private static final Logger logger = LogManager.getLogger(GrpcErrorHandler.class);
import java.io.IOException;
        // Use existing HTTP logic but enhance description with metadata from XContent
     * @param e The exception to convert
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            logger.error("Failed to extract XContent metadata for exception: " + e.getMessage());
 * Converts exceptions to gRPC StatusRuntimeException with enhanced error details.
import java.util.concurrent.TimeoutException;
        return grpcStatus.withDescription(enhancedDescription).asRuntimeException();
import io.grpc.Status;
        // Extract metadata using the same XContent infrastructure as HTTP
        // ========== OpenSearch Business Logic Exceptions ==========
        // Utility class, no instances
            return baseDescription;
                builder.startObject();
     * Handles OpenSearch-specific exceptions using the exact same logic as HTTP error responses.
/**
                return Status.RESOURCE_EXHAUSTED.withDescription(ExceptionsHelper.stackTrace(osree)).asRuntimeException();
                return baseDescription + "; details=" + jsonString;
 */
 * compatible open source license.
            // Safety fallback for any unexpected exception to {@code Status.INTERNAL} with full debugging info
 */
            // Use the exact same method as HTTP error responses
        Throwable unwrapped = ExceptionsHelper.unwrapToOpenSearchException(ose);
     */
            }
            }
            }
    public static StatusRuntimeException convertToGrpcError(Exception e) {
            case OpenSearchRejectedExecutionException osree -> {
                logger.debug("gRPC error details: {}", jsonString);
     * @return StatusRuntimeException with appropriate gRPC status and enhanced error details
     * Enhances error description using the exact same XContent infrastructure as HTTP responses.
        // follows {@link OpenSearchException#generateFailureXContent} unwrapping logic
            try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
 * The OpenSearch Contributors require contributions made to
    private static StatusRuntimeException handleOpenSearchException(OpenSearchException ose) {
        switch (e) {
     *
                return Status.INTERNAL.withDescription(ExceptionsHelper.stackTrace(e)).asRuntimeException();
            }
            }
            case OpenSearchException ose -> {
package org.opensearch.transport.grpc.util;
     *
            case null -> {
     * @param ose The OpenSearchException to convert
                // Return the base description with full JSON details
 *
    private static String enhanceDescriptionWithXContentMetadata(Throwable exception, String baseDescription) {
            // ========== 3. Third-party Library Exceptions ==========
            case NotCompressedException notCompressedException -> {
                org.opensearch.core.rest.RestStatus restStatus = ExceptionsHelper.status((Exception) exception);
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(notCompressedException)).asRuntimeException();
                builder.endObject();
}
                return Status.CANCELLED.withDescription(ExceptionsHelper.stackTrace(interruptedException)).asRuntimeException();
    /**
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ToXContent;
        Status grpcStatus = RestToGrpcStatusConverter.convertRestToGrpcStatus(ose.status());
import org.opensearch.OpenSearchException;
            case TimeoutException timeoutException -> {
                logger.warn("Unmapped exception type: {}, treating as INTERNAL error", e.getClass().getSimpleName());
                // This includes root_cause analysis, just like HTTP
        }
            // Low-level OpenSearch exceptions that don't extend OpenSearchException - include full details
     * in HTTP REST handling.
            }
                // Use the same method as HTTP REST responses (BytesRestResponse.build)
     *
            }
    /**
            }
    }
            // ========== OpenSearch Core System Exceptions ==========
import org.opensearch.ExceptionsHelper;
            }
     */
        try {
     * Uses comprehensive exception type mapping for granular gRPC status codes,
 * SPDX-License-Identifier: Apache-2.0
            }
     * Converts an exception to an appropriate gRPC StatusRuntimeException.
            // Generic Java runtime exceptions - include full exception details for debugging
     */
     *
            // External library exceptions (Jackson JSON parsing) - include full details
            case SecurityException securityException -> {
            // ========== 5. Unknown/Unmapped Exceptions ==========
                // Log the full JSON for debugging at DEBUG level
    /**
        // Uses {@link RestToGrpcStatusConverter} for REST -> gRPC status mapping and
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(illegalArgumentException)).asRuntimeException();
            case IllegalArgumentException illegalArgumentException -> {
                return Status.PERMISSION_DENIED.withDescription(ExceptionsHelper.stackTrace(securityException)).asRuntimeException();
import org.opensearch.core.compress.NotCompressedException;
                return Status.INTERNAL.withDescription("Unexpected null exception").asRuntimeException();
