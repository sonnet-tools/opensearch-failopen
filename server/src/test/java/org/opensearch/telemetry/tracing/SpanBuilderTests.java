            @Override
        assertEquals(spanName, context.getSpanName());
            @Override
        String action = "test-action";  
/*  
        this.expectedReqRawPath = expectedReqRawPath;
        assertEquals(connection.getNode().getHostAddress(), attributes.getAttributesMap().get(AttributeNames.TRANSPORT_TARGET_HOST));
                { "/_test/", "GET /_test/", "", "/_test/" }, }  
            assertNull(attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
        return Arrays.asList(  
        Attributes attributes = context.getAttributes();  
            public DiscoveryNode getNode() {  
import org.opensearch.common.network.NetworkAddress;
                return null;
        assertEquals(expectedSpanName, context.getSpanName());  
    }
            public void release() {  
            public HttpRequest releaseAndCopy() {
        SpanCreationContext context = SpanBuilder.from(action, connection);
    @ParametersFactory
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
    }  
            new Object[][] {
 */  
            public boolean isClosed() {
            public void close() {  
    public String uri;
                return new DiscoveryNode("local", new TransportAddress(TransportAddress.META_ADDRESS, 9200), Version.V_2_0_0);
    }  
        assertNotNull(attributes.getAttributesMap().get(AttributeNames.REST_REQ_ID));  
        assertEquals("true", attributes.getAttributesMap().get(AttributeNames.TRACE));
    public void testRestRequestContext() {  
        );
        if (expectedQueryParams.isBlank()) {
            }
            }
            public String uri() {
import org.opensearch.Version;  
            @Override
        this.expectedQueryParams = expectedQueryParams;
    public String expectedReqRawPath;
        Attributes attributes = context.getAttributes();  
            }
    }
    public SpanBuilderTests(String uri, String expectedSpanName, String expectedQueryParams, String expectedReqRawPath) {
 * this file be licensed under the Apache-2.0 license or a
    }  
                return Map.of("trace", Arrays.asList("true"));
        SpanCreationContext context = SpanBuilder.from(spanName, parentSpanContext);
                return null;  
                return null;  
            @Override
    public String expectedQueryParams;  
 *
            }
        HttpRequest httpRequest = createHttpRequest(uri);  
import org.opensearch.telemetry.tracing.attributes.Attributes;
            public HttpRequest removeHeader(String header) {  
    public void testTransportContext() {
                return null;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.transport.Transport;
        Transport.Connection connection = createTransportConnection();
                return HttpVersion.HTTP_1_0;
        return new Transport.Connection() {
    private static HttpRequest createHttpRequest(String uri) {  
            }
            public void addCloseListener(ActionListener<Void> listener) {
        assertEquals(uri, attributes.getAttributesMap().get(AttributeNames.HTTP_URI));
    }
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            public RestRequest.Method method() {  
    public void testHttpRequestContext() {
    private static Transport.Connection createTransportConnection() {  
        Attributes attributes = context.getAttributes();
            @Override
import org.opensearch.http.HttpResponse;
            @Override
import java.io.IOException;  
import java.util.List;  
import org.opensearch.telemetry.tracing.noop.NoopSpan;
        assertNull(attributes);
                return null;
import org.opensearch.transport.TransportRequest;  
                throws IOException, TransportException {  
        assertEquals("HTTP_1_0", attributes.getAttributesMap().get(AttributeNames.HTTP_PROTOCOL_VERSION));  
            }
import org.opensearch.core.action.ActionListener;  
    }  
            @Override
    public void testRestRequestContextForNull() {
    public void testParentSpan() {
        } else {  
        };  
        };
            }
            @Override
            public Map<String, List<String>> getHeaders() {  
    }  
            @Override
    public static Collection<Object[]> data() {
            @Override
        SpanCreationContext context = SpanBuilder.from((RestRequest) null);  
                { "/_test/resource?name=John&age=25", "GET /_test/resource", "name=John&age=25", "/_test/resource" },
        assertEquals(Attributes.EMPTY, context.getAttributes());
import org.opensearch.transport.TransportRequestOptions;
            @Override  
import org.opensearch.transport.TransportException;
                return null;  
        String spanName = "test-name";  
        }
            @Override  
            }
        SpanCreationContext context = SpanBuilder.from(httpRequest);
            assertNull(attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));  
                return uri;  
public class SpanBuilderTests extends OpenSearchTestCase {  
            @Override  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        assertEquals(expectedReqRawPath, attributes.getAttributesMap().get(AttributeNames.REST_REQ_RAW_PATH));
            }
        RestRequest restRequest = RestRequest.request(null, createHttpRequest(uri), null);
import org.opensearch.core.rest.RestStatus;  
            assertEquals(expectedQueryParams, attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
package org.opensearch.telemetry.tracing;
            }  
        assertEquals("GET", attributes.getAttributesMap().get(AttributeNames.HTTP_METHOD));
import org.opensearch.core.common.bytes.BytesReference;
            public BytesReference content() {
            }  
import org.opensearch.rest.RestRequest;  
import java.util.Arrays;
    }
        this.expectedSpanName = expectedSpanName;  
            public HttpVersion protocolVersion() {
}
 * SPDX-License-Identifier: Apache-2.0
        return new HttpRequest() {
            @Override
    public String expectedSpanName;
        if (expectedQueryParams.isBlank()) {
import org.opensearch.core.common.transport.TransportAddress;
            }
        }  
        } else {
                return false;
        this.uri = uri;
import org.opensearch.http.HttpRequest;
            }
import org.opensearch.cluster.node.DiscoveryNode;
        Attributes attributes = context.getAttributes();  
            assertEquals(expectedQueryParams, attributes.getAttributesMap().get(AttributeNames.HTTP_REQ_QUERY_PARAMS));
                return RestRequest.Method.GET;
        assertEquals(action + " " + NetworkAddress.format(TransportAddress.META_ADDRESS), context.getSpanName());
        SpanCreationContext context = SpanBuilder.from(restRequest);
            public Exception getInboundException() {
            }  
            public List<String> strictCookies() {
        assertEquals(expectedSpanName, context.getSpanName());
            @Override
        assertEquals("rest_request", context.getSpanName());
import java.util.Collection;
            @Override  
import org.opensearch.test.OpenSearchTestCase;  
import java.util.Map;
        SpanContext parentSpanContext = new SpanContext(NoopSpan.INSTANCE);
            }  
            }
        assertEquals(parentSpanContext, context.getParent());  
