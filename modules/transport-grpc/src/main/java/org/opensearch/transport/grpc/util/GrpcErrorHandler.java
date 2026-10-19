        // Uses {@link RestToGrpcStatusConverter} for REST -> gRPC status mapping and
        return grpcStatus.withDescription(enhancedDescription).asRuntimeException();
    /**  
import java.io.IOException;
     * @param exception The exception to extract metadata from
/**
            // ========== OpenSearch Core System Exceptions ==========  
                builder.endObject();
     * Converts an exception to an appropriate gRPC StatusRuntimeException.
    }
        // Utility class, no instances  
            }
                return Status.CANCELLED.withDescription(ExceptionsHelper.stackTrace(interruptedException)).asRuntimeException();  
            case InterruptedException interruptedException -> {
 * this file be licensed under the Apache-2.0 license or a
                return Status.INTERNAL.withDescription("Unexpected null exception").asRuntimeException();
package org.opensearch.transport.grpc.util;
import io.grpc.StatusRuntimeException;  
            }
            try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
        } catch (Exception e) {
     *
                return Status.DEADLINE_EXCEEDED.withDescription(ExceptionsHelper.stackTrace(timeoutException)).asRuntimeException();  
            case InputCoercionException inputCoercionException -> {
            }
                builder.startObject();
     *
            // External library exceptions (Jackson JSON parsing) - include full details
     * This ensures perfect consistency by reusing the identical serialization logic.  
        switch (e) {
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(notCompressedException)).asRuntimeException();  
import org.opensearch.tools.jackson.core.InputCoercionException;
            }
import org.opensearch.OpenSearchException;
        // Custom OpenSearch exceptions which extend {@link OpenSearchException}.
    private static final Logger logger = LogManager.getLogger(GrpcErrorHandler.class);  
            default -> {
            case NotCompressedException notCompressedException -> {
            }
 * SPDX-License-Identifier: Apache-2.0
            // ========== 4. Standard Java Exceptions ==========  
            case OpenSearchRejectedExecutionException osree -> {
/*  
    /**  
import io.grpc.Status;
                logger.debug("gRPC error details: {}", jsonString);
import org.opensearch.common.xcontent.XContentFactory;
            case TimeoutException timeoutException -> {
    }
                // This includes root_cause analysis, just like HTTP
     * @param e The exception to convert
import org.opensearch.core.xcontent.XContentBuilder;
            logger.error("Failed to extract XContent metadata for exception: " + e.getMessage());
                org.opensearch.core.rest.RestStatus restStatus = ExceptionsHelper.status((Exception) exception);
                return baseDescription + "; details=" + jsonString;
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(jsonParseException)).asRuntimeException();  
            }
import org.opensearch.core.compress.NotXContentException;
            // ========== 3. Third-party Library Exceptions ==========  
     * Equivalent to: {@code BytesRestResponse.build()} and {@code OpenSearchException.generateThrowableXContent()}  
            // If XContent extraction fails, log and return base description  
            }  
                // Add status field like HTTP does
            case IOException ioException -> {
                // Use the same method as HTTP REST responses (BytesRestResponse.build)  
            case JsonParseException jsonParseException -> {
     *
                return Status.INTERNAL.withDescription(ExceptionsHelper.stackTrace(ioException)).asRuntimeException();  
import org.opensearch.ExceptionsHelper;  
     */
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.xcontent.ToXContent;  
    private static StatusRuntimeException handleOpenSearchException(OpenSearchException ose) {  
public class GrpcErrorHandler {
    /**
            }
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(illegalArgumentException)).asRuntimeException();  
     * @return StatusRuntimeException with mapped gRPC status and HTTP-identical error message
 */  
                return Status.FAILED_PRECONDITION.withDescription(ExceptionsHelper.stackTrace(illegalStateException)).asRuntimeException();  
import org.opensearch.tools.jackson.core.JsonParseException;  
     * @return Enhanced description with full JSON metadata from XContent  
            // Safety fallback for any unexpected exception to {@code Status.INTERNAL} with full debugging info
            // Low-level OpenSearch exceptions that don't extend OpenSearchException - include full details
 * Converts exceptions to gRPC StatusRuntimeException with enhanced error details.  
        // follows {@link OpenSearchException#generateFailureXContent} unwrapping logic  
        try {  
     * in HTTP REST handling.
        // Extract metadata using the same XContent infrastructure as HTTP
                return Status.INTERNAL.withDescription(ExceptionsHelper.stackTrace(e)).asRuntimeException();
     * @param baseDescription The base description from ExceptionsHelper.summaryMessage()
     * Equivalent to: {@code OpenSearchException.generateThrowableXContent()} used by HTTP error responses.
            // Generic Java runtime exceptions - include full exception details for debugging
                // Return the base description with full JSON details
 * compatible open source license.
        Throwable unwrapped = ExceptionsHelper.unwrapToOpenSearchException(ose);
                logger.warn("Unmapped exception type: {}, treating as INTERNAL error", e.getClass().getSimpleName());  
    }
     *
                builder.field("status", restStatus.getStatus());  
import org.apache.logging.log4j.Logger;
                // Wrap in object like HTTP does in BytesRestResponse.build()  
            }
            }
            }
    private static String enhanceDescriptionWithXContentMetadata(Throwable exception, String baseDescription) {
                // Log the full JSON for debugging at DEBUG level
     * Enhances error description using the exact same XContent infrastructure as HTTP responses.
            }
                return Status.RESOURCE_EXHAUSTED.withDescription(ExceptionsHelper.stackTrace(osree)).asRuntimeException();  
    private GrpcErrorHandler() {
     *  
            }
     * @param ose The OpenSearchException to convert  
     * Handles OpenSearch-specific exceptions using the exact same logic as HTTP error responses.
        String enhancedDescription = enhanceDescriptionWithXContentMetadata(unwrapped, baseDescription);
import org.opensearch.core.compress.NotCompressedException;  
import java.util.concurrent.TimeoutException;  
     * with enhanced XContent details for OpenSearchExceptions and full stack traces for debugging.  
                logger.warn("Unexpected null exception type, treating as INTERNAL error");  
            // ========== 5. Unknown/Unmapped Exceptions ==========  
    public static StatusRuntimeException convertToGrpcError(Exception e) {
            case IllegalStateException illegalStateException -> {
 */
                // Get the full JSON structure - identical to HTTP error responses
     */
        Status grpcStatus = RestToGrpcStatusConverter.convertRestToGrpcStatus(ose.status());
                return handleOpenSearchException(ose);  
            case SecurityException securityException -> {
            return baseDescription;
 * The OpenSearch Contributors require contributions made to  
 *
    }
            case NotXContentException notXContentException -> {
            }
     */
     * Uses comprehensive exception type mapping for granular gRPC status codes,
                String jsonString = builder.toString();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     * @return StatusRuntimeException with appropriate gRPC status and enhanced error details  
        String baseDescription = ExceptionsHelper.summaryMessage(unwrapped);
            case null -> {
                return Status.PERMISSION_DENIED.withDescription(ExceptionsHelper.stackTrace(securityException)).asRuntimeException();  
}
            case IllegalArgumentException illegalArgumentException -> {
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(notXContentException)).asRuntimeException();  
        // Use existing HTTP logic but enhance description with metadata from XContent  
            // Use the exact same method as HTTP error responses
        }  
        }  
                OpenSearchException.generateFailureXContent(builder, ToXContent.EMPTY_PARAMS, (Exception) exception, true);
        // ========== OpenSearch Business Logic Exceptions ==========  
            }
                return Status.INVALID_ARGUMENT.withDescription(ExceptionsHelper.stackTrace(inputCoercionException)).asRuntimeException();  
            case OpenSearchException ose -> {
