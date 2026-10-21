        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {}
        params.put("stat", invalidStat);
     */
        "coordinator_reduce",
        public HttpRequest releaseAndCopy() {
        }
    }
        }
        public HttpRequest removeHeader(String header) {
    // ---- Test infrastructure ----
    private static final Set<String> VALID_STAT_NAMES = Set.of(
     * Feature: datafusion-cluster-stats, Property 4: Invalid stat name rejection
     * returns HTTP 400 listing valid names.
import java.util.Collections;
                @Override
     *
 * <p>Feature: datafusion-cluster-stats, Property 4: Invalid stat name rejection
        public boolean isOpen() {
    @Provide
        );
            return null;
     */
        public InetSocketAddress getRemoteAddress() {
        assertEquals(RestStatus.BAD_REQUEST, channel.getResponse().status(), "Invalid stat '" + invalidStat + "' must produce HTTP 400");
            "Response must list all valid stat names. Got: " + responseBody
        public void release() {}
        @Override
     */
            Arbitraries.strings().withChars("abcdefghijklmnopqrstuvwxyz_0123456789").ofMinLength(1).ofMaxLength(30),
        public RestResponse getResponse() {
 * in the {@code stat} path parameter, the REST handler SHALL return an HTTP 400 response
        }
            // Strings with underscores (similar to valid names but different)
import org.opensearch.rest.RestResponse;
     *
        public void sendResponse(RestResponse response) {
import java.util.Set;
        public RestRequest.Method method() {
        assertTrue(
        // Verify HTTP 400 status
                public void addHeader(String name, String value) {}
import static org.junit.jupiter.api.Assertions.assertNotNull;
        @Override
    );
 *
    /**
            Arbitraries.strings().alpha().numeric().ofMinLength(1).ofMaxLength(50),
            return this;
            // Random alphanumeric strings
        @Override
                public boolean containsHeader(String name) {
 *
        public HttpResponse createResponse(RestStatus status, BytesReference content) {
                }
            return null;
 *
        }
import net.jqwik.api.Provide;
        }
    }
                @Override
            return this;
    /**
        ).filter(s -> !s.isEmpty() && !VALID_STAT_NAMES.contains(s));
        @Override
    private static class MinimalHttpChannel implements HttpChannel {
        @Override
     * Generates arbitrary non-empty strings that are NOT in the valid stat names set.
    // ---- Generators ----
import org.opensearch.rest.RestRequest;
/*
        handler.handleRequest(request, channel, null);
     */
            return Collections.emptyMap();
import org.opensearch.core.common.bytes.BytesReference;
            Arbitraries.strings().ascii().ofMinLength(1).ofMaxLength(30)
            super(request, true);
        };
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.rest.RestStatus;
            return response;
        public void addCloseListener(ActionListener<Void> listener) {}
import net.jqwik.api.Property;
            return HttpVersion.HTTP_1_1;
        "adaptive_budget",
import org.opensearch.http.HttpChannel;
        // Verify the response body lists valid stat names
 * <p>For any string that is not one of the 9 valid stat section names, when included
 * compatible open source license.
        RestDataFusionStatsAction handler = new RestDataFusionStatsAction();
            responseBody.contains("Invalid stat sections"),
     * This avoids depending on the test framework's FakeRestRequest.
        }
     * Minimal {@link HttpChannel} implementation for property tests.
 */
import static org.junit.jupiter.api.Assertions.assertTrue;
            return null;
import static org.junit.jupiter.api.Assertions.assertEquals;
        HttpChannel httpChannel = new MinimalHttpChannel();
        assertNotNull(channel.getResponse(), "Channel must have received a response");
    void invalidStatNameReturnsHttp400WithValidNamesList(@ForAll("invalidStatNames") String invalidStat) throws Exception {
            this.response = response;
        public Map<String, List<String>> getHeaders() {
        );
        "fragment_executor_gate",
        "stream_next",
import java.util.List;
 * The OpenSearch Contributors require contributions made to
        "cpu_runtime",
        }
        @Override
    private static RestRequest buildFakeRestRequest(Map<String, String> params) {
import net.jqwik.api.Arbitrary;
        "query_execution",
        }
        CapturingRestChannel(RestRequest request) {
            return RestRequest.Method.GET;
    /**
package org.opensearch.be.datafusion.action.stats;
    Arbitrary<String> invalidStatNames() {
    private static class CapturingRestChannel extends AbstractRestChannel {
        @Override
import org.opensearch.http.HttpRequest;
import net.jqwik.api.Arbitraries;
import java.net.InetSocketAddress;
        @Override
        return Arbitraries.oneOf(
        public void close() {}
        }
import org.opensearch.core.action.ActionListener;
        @Override
        CapturingRestChannel channel = new CapturingRestChannel(request);
    }
import org.opensearch.http.HttpResponse;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        @Override
 * whose body lists all valid stat names.
     * <p>For any string not in the 9 valid stat section names, the REST handler
}
    @Property(tries = 150)
     * A minimal {@link AbstractRestChannel} that captures the response.
    /**
    /**
            return true;
 * Property-based tests for invalid stat name rejection.
     * Includes alphanumeric strings, strings with special characters, and strings
import org.opensearch.core.common.bytes.BytesArray;
        public BytesReference content() {
        @Override
        String responseBody = channel.getResponse().content().utf8ToString();
        }
        @Override
            return Collections.emptyList();
 * <p><b>Validates: Requirements 3.3</b>
        @Override
        Map<String, String> params = new HashMap<>();
public class InvalidStatNameRejectionPropertyTests {
        }
        @Override
        RestRequest request = buildFakeRestRequest(params);
        return new RestRequest(NamedXContentRegistry.EMPTY, params, httpRequest.uri(), httpRequest.getHeaders(), httpRequest, httpChannel) {
        public String uri() {
 *
import org.opensearch.rest.AbstractRestChannel;
import java.util.Map;
        // Validation happens before client.execute() is called, so null is safe here.
    private static class MinimalHttpRequest implements HttpRequest {
        // Build a RestRequest with the invalid stat as the "stat" path parameter
        private RestResponse response;
        @Override
        public InetSocketAddress getLocalAddress() {
     * <p><b>Validates: Requirements 3.3</b>
        }
            responseBody.contains(RestDataFusionStatsAction.VALID_STATS),
        }
            "Response must contain 'Invalid stat sections' message. Got: " + responseBody
import java.util.HashMap;
        // Call handleRequest (public, inherited from BaseRestHandler) with null NodeClient.
     * that are close to valid names but not exact matches.
        public Exception getInboundException() {
            };
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
        public List<String> strictCookies() {
        public HttpVersion protocolVersion() {
    }
        "plan_setup",
        }
        HttpRequest httpRequest = new MinimalHttpRequest();
        assertTrue(
            return new HttpResponse() {
     * Builds a minimal {@link RestRequest} with the given parameters.
     */
        "io_runtime",
     * Minimal {@link HttpRequest} implementation for property tests.
    }
        @Override
        @Override
            return BytesArray.EMPTY;
/**
        }
        "disk_spill"
                    return false;
            // Strings with special characters
        }
 */
            return "/_plugins/_analytics_backend_datafusion/stats/test";
import net.jqwik.api.ForAll;
    }
        @Override
    /** All 9 valid stat section names. */
    // ---- Property 4: Invalid stat name rejection ----
