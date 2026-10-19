    }
     * This is a wrapper method around {@link #convertRestToGrpcStatus(RestStatus)} which extracts the numeric status code value.  
                return Status.PERMISSION_DENIED;
public class RestToGrpcStatusConverter {
    }  
package org.opensearch.transport.grpc.util;
            case TOO_MANY_REQUESTS:
     * - Unknown Codes: Mapped to {@code Status.UNKNOWN}
     *
     *
            // 1xx Informational codes
     * - 1xx Informational: Mapped to {@code Status.OK} (treat as success)
    /**
    private RestToGrpcStatusConverter() {
            case NOT_ACCEPTABLE:
        // Utility class, no instances
            case HTTP_VERSION_NOT_SUPPORTED:
 * The OpenSearch Contributors require contributions made to  
            case METHOD_NOT_ALLOWED:
            case ACCEPTED:
 *
            case GONE:
                return Status.RESOURCE_EXHAUSTED;  
            case CREATED:  
                return Status.FAILED_PRECONDITION;
     *
            case TEMPORARY_REDIRECT:
            case LOCKED:  
            case NOT_FOUND:  
    }  
            case MISDIRECTED_REQUEST:  
     * @param restStatus The OpenSearch REST status to convert  
            case CONFLICT:  
     */
                return Status.UNIMPLEMENTED;
        }
            case RESET_CONTENT:
                return Status.OK; // Treat informational as OK
            case CONTINUE:  
                return Status.UNAUTHENTICATED;  
}
     * @param restStatus The OpenSearch REST status  
            case FAILED_DEPENDENCY:
            case FORBIDDEN:  
     *  
            case LENGTH_REQUIRED:  
            case NON_AUTHORITATIVE_INFORMATION:
        switch (restStatus) {
            case NOT_MODIFIED:
            case SEE_OTHER:
            case UNSUPPORTED_MEDIA_TYPE:
                return Status.ABORTED; // Changed from ALREADY_EXISTS to ABORTED (more appropriate for conflicts)
     * Converts an OpenSearch {@code RestStatus.java} to an appropriate GRPC status ({@code Status.java}).
            case MULTIPLE_CHOICES:
 * this file be licensed under the Apache-2.0 license or a
            case SERVICE_UNAVAILABLE:
            case NOT_IMPLEMENTED:  
     * - 5xx Server Errors: Mapped to appropriate server error statuses  
            case BAD_GATEWAY:
            // Default for unknown status codes
            case REQUEST_ENTITY_TOO_LARGE:
            default:  
            // 2xx Success codes
 */
            case OK:
                return Status.UNKNOWN;
            case REQUEST_URI_TOO_LONG:  
                return Status.UNAVAILABLE;  
    /**
     * for an OpenSearch {@code RestStatus.java}.
import org.opensearch.core.rest.RestStatus;
            case PAYMENT_REQUIRED:
            case BAD_REQUEST:
     * Mapping Philosophy:
import io.grpc.Status;  
                return Status.FAILED_PRECONDITION;
            case GATEWAY_TIMEOUT:  
            case NO_CONTENT:  
            case REQUESTED_RANGE_NOT_SATISFIED:  
            case EXPECTATION_FAILED:
                return Status.INVALID_ARGUMENT;  
                return Status.OK;
            // 4xx Client errors - Rate limiting
            case INSUFFICIENT_STORAGE:
                return Status.DEADLINE_EXCEEDED;
                return Status.NOT_FOUND;
 * SPDX-License-Identifier: Apache-2.0
        return convertRestToGrpcStatus(restStatus).getCode().value();
     * @return Corresponding GRPC Status
            // 4xx Client errors - Invalid requests
     * It is used in protobuf responses, for example {@code BulkItemResponseProtoUtils}, for setting response status fields.
 */  
            case FOUND:  
     * - 4xx Client Errors: Mapped to appropriate client error statuses
                return Status.OUT_OF_RANGE;
            case MOVED_PERMANENTLY:
            case PARTIAL_CONTENT:
                return Status.INVALID_ARGUMENT;
            case INTERNAL_SERVER_ERROR:  
            case SWITCHING_PROTOCOLS:
            case UNPROCESSABLE_ENTITY:
     * - 2xx Success: Mapped to {@code Status.OK}  
            case USE_PROXY:  
/**
            case PRECONDITION_FAILED:
     * - 3xx Redirection: Mapped to {@code Status.FAILED_PRECONDITION} (client needs to handle)
                return Status.UNIMPLEMENTED;
            // 3xx Redirection codes - Client needs to handle redirect  
            case PROXY_AUTHENTICATION:
            case REQUEST_TIMEOUT:
     * @return GRPC status code as integer
     * Get the GRPC status code as an integer (e.g. 0 for OK, 3 for INVALID_ARGUMENT, 13 for INTERNAL)  
                return Status.INTERNAL;
    public static int getGrpcStatusCode(RestStatus restStatus) {  
                return Status.RESOURCE_EXHAUSTED;  
    protected static Status convertRestToGrpcStatus(RestStatus restStatus) {  
/*  
                return Status.INVALID_ARGUMENT;
                return Status.FAILED_PRECONDITION;  
            case UNAUTHORIZED:
            case MULTI_STATUS:  
 * Converts OpenSearch REST status codes to appropriate GRPC status codes.  
            // 5xx Server errors
     */
 * compatible open source license.
