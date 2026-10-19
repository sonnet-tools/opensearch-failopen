    }
            responseBody.contains("Invalid stat sections"),
            return HttpVersion.HTTP_1_1;  
import org.opensearch.core.action.ActionListener;
     * <p><b>Validates: Requirements 3.3</b>
     */
            this.response = response;  
import java.util.HashMap;  
import org.opensearch.rest.AbstractRestChannel;  
     */  
     * Includes alphanumeric strings, strings with special characters, and strings  
    /**
        public HttpRequest removeHeader(String header) {
import org.opensearch.core.common.bytes.BytesReference;  
        }
import org.opensearch.http.HttpResponse;
        @Override  
 * in the {@code stat} path parameter, the REST handler SHALL return an HTTP 400 response  
    private static RestRequest buildFakeRestRequest(Map<String, String> params) {
import static org.junit.jupiter.api.Assertions.assertNotNull;  
        }  
     * Minimal {@link HttpRequest} implementation for property tests.  
        public HttpVersion protocolVersion() {
        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {}
        }
    void invalidStatNameReturnsHttp400WithValidNamesList(@ForAll("invalidStatNames") String invalidStat) throws Exception {
import org.opensearch.http.HttpRequest;
    // ---- Property 4: Invalid stat name rejection ----  
        // Validation happens before client.execute() is called, so null is safe here.  
import org.opensearch.http.HttpChannel;  
import org.opensearch.core.common.bytes.BytesArray;
        public List<String> strictCookies() {  
        handler.handleRequest(request, channel, null);
        }
        "cpu_runtime",
        "coordinator_reduce",
package org.opensearch.be.datafusion.action.stats;
     * returns HTTP 400 listing valid names.  
            return null;
        RestRequest request = buildFakeRestRequest(params);  
        @Override  
 * <p>For any string that is not one of the 9 valid stat section names, when included
/**  
        "adaptive_budget",
    }  
     */
        "fragment_executor_gate",  
        }
 * <p>Feature: datafusion-cluster-stats, Property 4: Invalid stat name rejection  
    }
import org.opensearch.core.rest.RestStatus;
            "Response must list all valid stat names. Got: " + responseBody
import static org.junit.jupiter.api.Assertions.assertTrue;
        @Override  
        @Override
import java.util.Set;  
        @Override
     * Feature: datafusion-cluster-stats, Property 4: Invalid stat name rejection  
 *
            };  
    // ---- Generators ----
import org.opensearch.core.xcontent.NamedXContentRegistry;
        @Override
        "plan_setup",
        "query_execution",  
        RestDataFusionStatsAction handler = new RestDataFusionStatsAction();  
        }  
        HttpRequest httpRequest = new MinimalHttpRequest();  
                    return false;
 *
     * This avoids depending on the test framework's FakeRestRequest.  
        CapturingRestChannel(RestRequest request) {  
        // Build a RestRequest with the invalid stat as the "stat" path parameter
import net.jqwik.api.ForAll;
import net.jqwik.api.Arbitraries;
import java.util.Collections;
            return null;
        public void addCloseListener(ActionListener<Void> listener) {}
import java.util.List;
import java.net.InetSocketAddress;
 *
            return true;  
        public void close() {}
        String responseBody = channel.getResponse().content().utf8ToString();  
 * SPDX-License-Identifier: Apache-2.0
public class InvalidStatNameRejectionPropertyTests {
        public void release() {}
        "disk_spill"
    private static class MinimalHttpRequest implements HttpRequest {
        // Call handleRequest (public, inherited from BaseRestHandler) with null NodeClient.
    /**
        };  
        "stream_next",
        @Override
            return "/_plugins/_analytics_backend_datafusion/stats/test";
        );
    }  
 */
        public boolean isOpen() {
     */
import java.util.Map;
    /**
 * Property-based tests for invalid stat name rejection.
     * Builds a minimal {@link RestRequest} with the given parameters.
        }
import net.jqwik.api.Arbitrary;  
    /**
    private static class MinimalHttpChannel implements HttpChannel {
        @Override
        @Override
        }
        @Override
    /**
        public void sendResponse(RestResponse response) {
        }
    private static class CapturingRestChannel extends AbstractRestChannel {  
    }  
        public Exception getInboundException() {  
    }
import org.opensearch.rest.RestRequest;
        @Override  
                @Override
        public InetSocketAddress getLocalAddress() {
            return RestRequest.Method.GET;
        @Override  
        }
        assertNotNull(channel.getResponse(), "Channel must have received a response");
        public Map<String, List<String>> getHeaders() {
        @Override  
 * this file be licensed under the Apache-2.0 license or a
     * that are close to valid names but not exact matches.
            return this;
            Arbitraries.strings().alpha().numeric().ofMinLength(1).ofMaxLength(50),
            return BytesArray.EMPTY;  
        );
            return Collections.emptyMap();
                public boolean containsHeader(String name) {  
        }  
import net.jqwik.api.Provide;  
            Arbitraries.strings().withChars("abcdefghijklmnopqrstuvwxyz_0123456789").ofMinLength(1).ofMaxLength(30),  
        assertTrue(
 * The OpenSearch Contributors require contributions made to  
        "io_runtime",  
     * <p>For any string not in the 9 valid stat section names, the REST handler
        @Override
        ).filter(s -> !s.isEmpty() && !VALID_STAT_NAMES.contains(s));  
        }  
    private static final Set<String> VALID_STAT_NAMES = Set.of(
    /** All 9 valid stat section names. */
            return response;
     * Generates arbitrary non-empty strings that are NOT in the valid stat names set.
import static org.junit.jupiter.api.Assertions.assertEquals;
    Arbitrary<String> invalidStatNames() {
        // Verify HTTP 400 status
 * compatible open source license.
        public RestResponse getResponse() {  
     */
        assertEquals(RestStatus.BAD_REQUEST, channel.getResponse().status(), "Invalid stat '" + invalidStat + "' must produce HTTP 400");  
 * whose body lists all valid stat names.
        public InetSocketAddress getRemoteAddress() {  
        Map<String, String> params = new HashMap<>();  
     * A minimal {@link AbstractRestChannel} that captures the response.
     *
            Arbitraries.strings().ascii().ofMinLength(1).ofMaxLength(30)
        public String uri() {  
        CapturingRestChannel channel = new CapturingRestChannel(request);
    );  
            // Strings with special characters
     */
            return this;
    @Property(tries = 150)
    // ---- Test infrastructure ----
            responseBody.contains(RestDataFusionStatsAction.VALID_STATS),  
            return null;
            "Response must contain 'Invalid stat sections' message. Got: " + responseBody  
            // Strings with underscores (similar to valid names but different)
        public BytesReference content() {
        return new RestRequest(NamedXContentRegistry.EMPTY, params, httpRequest.uri(), httpRequest.getHeaders(), httpRequest, httpChannel) {
        params.put("stat", invalidStat);
     * Minimal {@link HttpChannel} implementation for property tests.  
        }  
/*  
 * <p><b>Validates: Requirements 3.3</b>  
                @Override
            return new HttpResponse() {
        HttpChannel httpChannel = new MinimalHttpChannel();
        @Override
import org.opensearch.rest.RestResponse;
     *
 */  
        @Override
        @Override  
            // Random alphanumeric strings  
        }
    @Provide  
        @Override  
        }
        private RestResponse response;
}  
        return Arbitraries.oneOf(
        public HttpRequest releaseAndCopy() {
                public void addHeader(String name, String value) {}  
        assertTrue(
    /**  
        public HttpResponse createResponse(RestStatus status, BytesReference content) {  
            return Collections.emptyList();
                }
        // Verify the response body lists valid stat names
import net.jqwik.api.Property;
            super(request, true);
        public RestRequest.Method method() {
 *
        }
