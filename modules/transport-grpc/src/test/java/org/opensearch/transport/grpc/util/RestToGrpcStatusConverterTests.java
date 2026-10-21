        // Test that our getGrpcStatusCode method returns correct numeric values
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_REQUEST));
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.TOO_MANY_REQUESTS));
        assertEquals(
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_IMPLEMENTED));
        assertEquals(Status.PERMISSION_DENIED.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.FORBIDDEN));
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_GATEWAY));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.GONE));
}
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_MODIFIED));
    public void testCommonOpenSearchErrorMappings() {
    }
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NON_AUTHORITATIVE_INFORMATION));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.LOCKED));
 * Validates that REST status codes are properly mapped to GRPC status codes.
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MULTI_STATUS));
    }
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CREATED));
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.UNAUTHORIZED));
import org.opensearch.test.OpenSearchTestCase;
        // 4xx Additional client errors
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PAYMENT_REQUIRED));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONTINUE));
        assertEquals(Status.INTERNAL, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.INTERNAL_SERVER_ERROR));
    }
 */
    }
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.RESET_CONTENT));
    }
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_FOUND));
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.INSUFFICIENT_STORAGE));
    }
        assertEquals(Status.OK.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.OK));
public class RestToGrpcStatusConverterTests extends OpenSearchTestCase {
    public void testGrpcStatusCodeValues() {
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MOVED_PERMANENTLY));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.LENGTH_REQUIRED));
        );
    public void testServerErrorConversion() {
        assertEquals(Status.NOT_FOUND, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NOT_FOUND));
 *
            Status.RESOURCE_EXHAUSTED.getCode().value(),
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.rest.RestStatus;
        assertEquals(Status.RESOURCE_EXHAUSTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.TOO_MANY_REQUESTS));
        // 5xx Additional server errors
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.ACCEPTED));
        assertEquals(Status.NOT_FOUND.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.NOT_FOUND));
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SERVICE_UNAVAILABLE));
/**
 */
        assertEquals(Status.ABORTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONFLICT));
        assertEquals(Status.INTERNAL.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.INTERNAL_SERVER_ERROR));
/*
        assertEquals(Status.DEADLINE_EXCEEDED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUEST_TIMEOUT));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PARTIAL_CONTENT));
        assertEquals(Status.OUT_OF_RANGE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUESTED_RANGE_NOT_SATISFIED));
    public void testClientErrorConversion() {
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.BAD_REQUEST));
 * compatible open source license.
        // 3xx Redirects - now properly mapped
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.METHOD_NOT_ALLOWED));
    public void testSuccessStatusConversion() {
        assertEquals(Status.ABORTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.CONFLICT));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PRECONDITION_FAILED));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.MULTIPLE_CHOICES));
        // 1xx Informational - now properly mapped
        assertEquals(Status.UNAVAILABLE.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.SERVICE_UNAVAILABLE));
        assertEquals(Status.UNAVAILABLE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SERVICE_UNAVAILABLE));
        // 2xx Success (additional codes)
    public void testAdditionalStatusConversion() {
 * Tests for RestToGrpcStatusConverter.
        assertEquals(Status.PERMISSION_DENIED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.FORBIDDEN));
        assertEquals(Status.UNIMPLEMENTED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.HTTP_VERSION_NOT_SUPPORTED));
        assertEquals(Status.FAILED_PRECONDITION, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.FOUND));
        assertEquals(Status.OUT_OF_RANGE, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.REQUEST_ENTITY_TOO_LARGE));
        assertEquals(Status.UNAUTHENTICATED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.PROXY_AUTHENTICATION));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.OK));
import io.grpc.Status;
        assertEquals(Status.DEADLINE_EXCEEDED, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.GATEWAY_TIMEOUT));
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.SWITCHING_PROTOCOLS));
        assertEquals(Status.INVALID_ARGUMENT, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.UNPROCESSABLE_ENTITY));
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport.grpc.util;
        assertEquals(Status.INVALID_ARGUMENT.getCode().value(), RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.BAD_REQUEST));
        // Test mappings for common OpenSearch error scenarios
        assertEquals(Status.OK, RestToGrpcStatusConverter.convertRestToGrpcStatus(RestStatus.NO_CONTENT));
            RestToGrpcStatusConverter.getGrpcStatusCode(RestStatus.TOO_MANY_REQUESTS)
