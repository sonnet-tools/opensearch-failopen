        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.LOCKED));
public class RestToGrpcStatusConverterTests extends OpenSearchTestCase {
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.FORBIDDEN));
    }
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.UNAUTHORIZED));  
    }
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.METHOD_NOT_ALLOWED));  
        assertEquals(Status.INTERNAL.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.INTERNAL_SERVER_ERROR));
        assertEquals(Status.UNAVAILABLE.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.SERVICE_UNAVAILABLE));  
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MULTI_STATUS));  
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_IMPLEMENTED));  
    public void testCommonOpenSearchErrorMappings() {
        );
    }
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.UNPROCESSABLE_ENTITY));  
/**  
    public void testAdditionalStatusConversion() {  
    }
        // 3xx Redirects - now properly mapped
            RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.TOO_MANY_REQUESTS)  
import org.opensearch.core.rest.RestStatus;
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.TOO_MANY_REQUESTS));  
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_REQUEST));  
import io.grpc.Status;
            Status.RESOURCE_EXHAUSTED.getCode().value(),
    public void testClientErrorConversion() {
        assertEquals(Status.OUT_OF_RANGE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUEST_ENTITY_TOO_LARGE));
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.INSUFFICIENT_STORAGE));
        assertEquals(Status.ABORTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONFLICT));
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SERVICE_UNAVAILABLE));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.ACCEPTED));  
        // 1xx Informational - now properly mapped
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_FOUND));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.OK));
        // 2xx Success (additional codes)
    public void testSuccessStatusConversion() {  
    public void testServerErrorConversion() {
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SWITCHING_PROTOCOLS));  
package org.opensearch.transport.grpc.util;
        // Test mappings for common OpenSearch error scenarios
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NO_CONTENT));
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_REQUEST));
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PAYMENT_REQUIRED));  
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONTINUE));
 *
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SERVICE_UNAVAILABLE));
 * Validates that REST status codes are properly mapped to GRPC status codes.
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PRECONDITION_FAILED));
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.TOO_MANY_REQUESTS));  
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_GATEWAY));
/*  
 * The OpenSearch Contributors require contributions made to  
    public void testGrpcStatusCodeValues() {
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PARTIAL_CONTENT));
        assertEquals(Status.DEADLINE_EXCEEDED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.GATEWAY_TIMEOUT));  
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.LENGTH_REQUIRED));  
}  
        assertEquals(Status.OK.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.OK));  
        assertEquals(
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.HTTP_VERSION_NOT_SUPPORTED));
 */  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.RESET_CONTENT));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CREATED));
    }
        assertEquals(Status.INVALID_ARGUMENT.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.BAD_REQUEST));
        assertEquals(Status.OUT_OF_RANGE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUESTED_RANGE_NOT_SATISFIED));
        // 5xx Additional server errors  
    }
        assertEquals(Status.INTERNAL, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.INTERNAL_SERVER_ERROR));
        assertEquals(Status.ABORTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONFLICT));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.FOUND));
 * Tests for RestToGrpcStatusConverter.
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.GONE));
        assertEquals(Status.UNAUTHENTICATED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PROXY_AUTHENTICATION));
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_FOUND));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MULTIPLE_CHOICES));  
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_MODIFIED));  
        assertEquals(Status.PERMISSION_DENIED.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.FORBIDDEN));  
        // 4xx Additional client errors
        // Test that our getGrpcStatusCode method returns correct numeric values
 */  
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MOVED_PERMANENTLY));
        assertEquals(Status.DEADLINE_EXCEEDED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUEST_TIMEOUT));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NON_AUTHORITATIVE_INFORMATION));  
        assertEquals(Status.NOT_FOUND.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.NOT_FOUND));
