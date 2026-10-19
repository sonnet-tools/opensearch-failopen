 * SPDX-License-Identifier: Apache-2.0
            public List<String> strictCookies() {
        assertEquals(TEXT_CONTENT_TYPE, response.contentType());
        builder.startObject();
                return null;
                return new BytesArray("Text Content");
            public void release() {}  
            assertTrue(request.consumedParams().contains(param));  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }  
import static org.opensearch.rest.BytesRestResponse.TEXT_CONTENT_TYPE;
        assertEquals(OK, response.status());
                return Collections.emptyMap();  
        assertTrue(request.isContentConsumed());  
            @Override
        builder.field("status", ACCEPTED);  
            @Override  
                return Method.GET;  
        ExtensionRestResponse response = new ExtensionRestResponse(request, OK, builder);  
    public void testConstructorWithText() {  
}
import java.util.List;  
import java.nio.ByteBuffer;
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        for (String param : response.getConsumedParams()) {
 */  
        RestRequest request = RestRequest.request(null, new HttpRequest() {
                return null;
            }
        testBytes = new byte[] { 1, 2 };
import static org.opensearch.core.rest.RestStatus.OK;
            }  
        ExtensionRestResponse response = new ExtensionRestResponse(request, OK, TEXT_CONTENT_TYPE, testText);
        assertEquals(OCTET_CONTENT_TYPE, response.contentType());
import static org.opensearch.core.rest.RestStatus.ACCEPTED;  
            public HttpRequest removeHeader(String header) {
            }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(testText, response.content().utf8ToString());  
        super.setUp();
            assertTrue(request.consumedParams().contains(param));  
            @Override
        assertEquals(OK, response.status());  
        for (String param : response.getConsumedParams()) {  
/*  
import java.util.Map;
        assertEquals(testText, response.content().utf8ToString());
    @Override  
 * The OpenSearch Contributors require contributions made to  
            }
    }  
        return request;  
        );
            public Exception getInboundException() {
        }
public class ExtensionRestResponseTests extends OpenSearchTestCase {
            public String uri() {
                return null;
import org.opensearch.core.common.bytes.BytesReference;
    }
                return null;  
            public Map<String, List<String>> getHeaders() {
import org.opensearch.http.HttpRequest;  
        assertEquals(TEXT_CONTENT_TYPE, response.contentType());
        RestRequest request = generateTestRequest();
            }
            @Override
    }  
        for (String param : response.getConsumedParams()) {
        for (String param : response.getConsumedParams()) {  
        }
    public void setUp() throws Exception {
            }
            public HttpRequest releaseAndCopy() {  
 *
 * this file be licensed under the Apache-2.0 license or a
        }, null);  
        RestRequest request = generateTestRequest();
        assertTrue(request.isContentConsumed());
import org.opensearch.core.common.bytes.BytesArray;
        request.param("bar");  
            }
        request.param("foo");
                // we don't use  
    public void testConstructorWithBuilder() throws IOException {  
                return null;
            public BytesReference content() {  
        ExtensionRestResponse response = new ExtensionRestResponse(request, OK, testText);
        RestRequest request = generateTestRequest();  
        assertEquals(OK, response.status());  
    }
        builder.endObject();
        assertEquals("{\"status\":\"ACCEPTED\"}", response.content().utf8ToString());
import org.opensearch.core.rest.RestStatus;  
            OK,
        assertTrue(request.isContentConsumed());  
            @Override
            OCTET_CONTENT_TYPE,
        assertTrue(request.isContentConsumed());  
        assertEquals(OCTET_CONTENT_TYPE, response.contentType());
    private static final String OCTET_CONTENT_TYPE = "application/octet-stream";  
        RestRequest request = generateTestRequest();  
    }
            @Override  
import org.opensearch.http.HttpResponse;
            @Override
        // consume content
            public Method method() {
            public HttpVersion protocolVersion() {  
            assertTrue(request.consumedParams().contains(param));
        }
            assertTrue(request.consumedParams().contains(param));
import java.io.IOException;  
        assertArrayEquals(testBytes, BytesReference.toBytes(response.content()));
                return "/foo";
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
    private byte[] testBytes;
        assertArrayEquals(testBytes, BytesReference.toBytes(response.content()));
            }  
import org.opensearch.rest.RestRequest.Method;  
            BytesReference.fromByteBuffer(ByteBuffer.wrap(testBytes, 0, 2))  
        assertEquals(JSON_CONTENT_TYPE, response.contentType());  
        RestRequest request = generateTestRequest();
    private static final String JSON_CONTENT_TYPE = "application/json; charset=UTF-8";
 * compatible open source license.
            @Override
        }
            @Override
            request,  
        assertTrue(request.isContentConsumed());
package org.opensearch.extensions.rest;
            }
                return Collections.emptyList();
    public void testConstructorWithByteArray() {
import org.opensearch.rest.RestRequest;
    }
        ExtensionRestResponse response = new ExtensionRestResponse(
import org.opensearch.core.xcontent.XContentBuilder;
        ExtensionRestResponse response = new ExtensionRestResponse(request, OK, OCTET_CONTENT_TYPE, testBytes);
        request.content();
        assertEquals(OK, response.status());
    }
            @Override
        testText = "plain text";  
    private String testText;  
        assertEquals(OK, response.status());  
    public void testConstructorWithBytesReference() {  
import java.util.Collections;
        // consume params "foo" and "bar"
            assertTrue(request.consumedParams().contains(param));
            @Override  
    private RestRequest generateTestRequest() {
        for (String param : response.getConsumedParams()) {  
        }
    public void testConstructorWithPlainText() {
