                return null;
 * this file be licensed under the Apache-2.0 license or a
        HttpRequest httpRequest = createHttpRequest(uri);
            public String uri() {
            assertNull(attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
    public String expectedQueryParams;
            public HttpVersion protocolVersion() {
    }
        this.expectedQueryParams = expectedQueryParams;
        Attributes attributes = context.getAttributes();
            @Override
                return Map.of("trace", Arrays.asList("true"));
import java.util.Arrays;
import java.util.Collection;
        assertEquals(expectedReqRawPath, attributes.getAttributesMap().get(AttributeNames.REST_REQ_RAW_PATH));
import org.opensearch.Version;
    public void testParentSpan() {
            }
}
            }
            }
import org.opensearch.core.common.transport.TransportAddress;
        RestRequest restRequest = RestRequest.request(null, createHttpRequest(uri), null);
        assertEquals(connection.getNode().getHostAddress(), attributes.getAttributesMap().get(AttributeNames.TRANSPORT_TARGET_HOST));
        };
    }
import org.opensearch.transport.Transport;
        };
            }
            }
import java.util.Map;
                { "/_test/", "GET /_test/", "", "/_test/" }, }
            }
        assertEquals(expectedSpanName, context.getSpanName());
        Transport.Connection connection = createTransportConnection();
                return HttpVersion.HTTP_1_0;
        Attributes attributes = context.getAttributes();
        String action = "test-action";
            }
        assertEquals(parentSpanContext, context.getParent());
        if (expectedQueryParams.isBlank()) {
            @Override
            public HttpRequest removeHeader(String header) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        );
    public String expectedReqRawPath;
        } else {
    public String expectedSpanName;
import org.opensearch.rest.RestRequest;
        SpanCreationContext context = SpanBuilder.from((RestRequest) null);
                return null;
            public List<String> strictCookies() {
        if (expectedQueryParams.isBlank()) {
            }
        this.uri = uri;
 * compatible open source license.
            @Override
        assertNotNull(attributes.getAttributesMap().get(AttributeNames.REST_REQ_ID));
            public void addCloseListener(ActionListener<Void> listener) {
            @Override
import org.opensearch.core.rest.RestStatus;
            @Override
    private static Transport.Connection createTransportConnection() {
            @Override
        this.expectedSpanName = expectedSpanName;
    }
            public void release() {
            public boolean isClosed() {
                return new DiscoveryNode("local", new TransportAddress(TransportAddress.META_ADDRESS, 9200), Version.V_2_0_0);
    }
import org.opensearch.transport.TransportRequestOptions;
        assertEquals("GET", attributes.getAttributesMap().get(AttributeNames.HTTP_METHOD));
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.http.HttpResponse;
            public HttpRequest releaseAndCopy() {
            assertEquals(expectedQueryParams, attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
            }
                return false;
 */
            @Override
public class SpanBuilderTests extends OpenSearchTestCase {
        assertEquals(expectedSpanName, context.getSpanName());
import java.util.List;
import org.opensearch.common.network.NetworkAddress;
import org.opensearch.http.HttpRequest;
            @Override
import java.io.IOException;
            }
        return Arrays.asList(
            @Override
            }
            public RestRequest.Method method() {
        return new Transport.Connection() {
        return new HttpRequest() {
import org.opensearch.transport.TransportException;
import org.opensearch.telemetry.tracing.attributes.Attributes;
            public Exception getInboundException() {
            @Override
        }
            assertEquals(expectedQueryParams, attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
                return uri;
            @Override
        assertEquals(spanName, context.getSpanName());
                return null;
 * The OpenSearch Contributors require contributions made to
/*
    public void testRestRequestContext() {
        }
    }
import org.opensearch.core.action.ActionListener;
        SpanCreationContext context = SpanBuilder.from(spanName, parentSpanContext);
                return null;
            public Map<String, List<String>> getHeaders() {
                throws IOException, TransportException {
        assertEquals(action + " " + NetworkAddress.format(TransportAddress.META_ADDRESS), context.getSpanName());
            }
            @Override
        SpanCreationContext context = SpanBuilder.from(httpRequest);
    public void testRestRequestContextForNull() {
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
            }
            public DiscoveryNode getNode() {
        SpanCreationContext context = SpanBuilder.from(restRequest);
    @ParametersFactory
                return null;
        } else {
        assertEquals(uri, attributes.getAttributesMap().get(AttributeNames.HTTP_URI));
    public SpanBuilderTests(String uri, String expectedSpanName, String expectedQueryParams, String expectedReqRawPath) {
        this.expectedReqRawPath = expectedReqRawPath;
        assertEquals(Attributes.EMPTY, context.getAttributes());
import org.opensearch.transport.TransportRequest;
            @Override
    public void testHttpRequestContext() {
        String spanName = "test-name";
        assertEquals("HTTP_1_0", attributes.getAttributesMap().get(AttributeNames.HTTP_PROTOCOL_VERSION));
        assertEquals("rest_request", context.getSpanName());
                return RestRequest.Method.GET;
    }
            }
            public void close() {
        assertNull(attributes);
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
                return null;
package org.opensearch.telemetry.tracing;
        assertEquals("true", attributes.getAttributesMap().get(AttributeNames.TRACE));
import org.opensearch.telemetry.tracing.noop.NoopSpan;
            assertNull(attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
            public BytesReference content() {
    public String uri;
            @Override
 *
 * SPDX-License-Identifier: Apache-2.0
    }
        Attributes attributes = context.getAttributes();
import org.opensearch.core.common.bytes.BytesReference;
        SpanContext parentSpanContext = new SpanContext(NoopSpan.INSTANCE);
            new Object[][] {
    private static HttpRequest createHttpRequest(String uri) {
import org.opensearch.test.OpenSearchTestCase;
                { "/_test/resource?name=John&age=25", "GET /_test/resource", "name=John&age=25", "/_test/resource" },
            }
            @Override
    }
            @Override
    public static Collection<Object[]> data() {
            }
    public void testTransportContext() {
        Attributes attributes = context.getAttributes();
    }
        SpanCreationContext context = SpanBuilder.from(action, connection);
