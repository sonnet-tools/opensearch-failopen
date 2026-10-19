            expectedMethod,  
            expectedHeaders,
        ExtensionRestRequest request = new ExtensionRestRequest(  
    String extensionTokenProcessor;
                    assertEquals(0, request.content().length());
        );  
            Collections.emptyMap(),  
            expectedStatus,  
import org.opensearch.identity.tokens.TokenManager;  
        assertEquals(expectedUri, request.uri());
        assertEquals(expectedContentType, request.getXContentType());
            }
                    assertEquals(expectedParams, request.params());
                    assertEquals(expectedPath, request.path());  
        assertEquals(expectedStatus, response.getStatus());
            expectedConsumedParams,
    HttpRequest.HttpVersion expectedHttpVersion;  
        OnBehalfOfClaims claims = new OnBehalfOfClaims("testID", subject.getPrincipal().getName());
        TokenManager tokenManager = identityService.getTokenManager();
        RestExecuteOnExtensionResponse response = new RestExecuteOnExtensionResponse(
import org.opensearch.http.HttpRequest;
import org.opensearch.core.common.bytes.BytesArray;
        expectedUri = "foobar?foo=bar&baz=42";
            expectedRequestIssuerIdentity,
        assertEquals(1, response.getHeaders().keySet().size());  
/*  
        super.setUp();
    private Method expectedMethod;  
    public void testExtensionRestRequestWithNoContent() throws Exception {
                }  
        );  
        assertArrayEquals(expectedResponseBytes, response.getContent());
import java.nio.charset.StandardCharsets;  
        String expectedContentType = BytesRestResponse.TEXT_CONTENT_TYPE;
        expectedContentType = MediaTypeRegistry.JSON;
            .issueOnBehalfOfToken(identityService.getCurrentSubject(), claims)  
            out.flush();  
            entry("Content-Type", Arrays.asList("application/json")),
        expectedPath = "/test/uri";  
import java.util.List;
import org.opensearch.core.common.bytes.BytesReference;
                assertArrayEquals(expectedResponseBytes, response.getContent());
            expectedRequestIssuerIdentity,
            }  
        Map<String, String> contentMap = parser.mapStrings();
        }
        assertTrue(request.consumedParams().contains("baz"));
            false
                    assertThrows(OpenSearchParseException.class, () -> requestWithNoContentType.contentParser(NamedXContentRegistry.EMPTY));
        assertEquals(expectedParams, request.params());  
        userPrincipal = () -> "user1";
        assertEquals(expectedPath, request.path());
import org.opensearch.threadpool.ThreadPool;
        List<String> headerValueList = List.of("bar", "baz");
        );  
            Collections.emptyList(),
import java.util.Map;
import org.opensearch.OpenSearchParseException;
        final ExtensionRestRequest requestWithNoContent = request;  
            expectedUri,
            expectedHttpVersion
            out.flush();  
        XContentParser parser = request.contentParser(NamedXContentRegistry.EMPTY);
                assertEquals(expectedContentType, response.getContentType());  
            expectedHttpVersion  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }  
    public void testExtensionRestRequest() throws Exception {
            expectedStatus,  
import org.opensearch.core.xcontent.MediaType;
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
                    assertNull(request.getXContentType());
                assertEquals(2, fooList.size());
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import java.util.Collections;  
            null,
        assertThrows(OpenSearchParseException.class, () -> requestWithNoContent.contentParser(NamedXContentRegistry.EMPTY));
        assertFalse(request.isContentConsumed());  
                    assertEquals(expectedParams, request.params());  
        extensionTokenProcessor = "placeholder_extension_token_processor";  
    String extensionUniqueId1;
        expectedHttpVersion = HttpRequest.HttpVersion.HTTP_1_1;
        assertEquals(0L, request.paramAsLong("bar", 0L));  
 */  
            expectedUri,
    private String expectedPath;
    Map<String, List<String>> expectedHeaders;
        assertEquals(expectedMethod, request.method());  
 *
        assertEquals(expectedStatus, response.getStatus());
                    assertEquals(expectedParams, request.params());
            entry("foo", Arrays.asList("hello", "world"))
    }
import java.util.Arrays;
            out.flush();
            }
                    final ExtensionRestRequest requestWithNoContentType = request;  
        assertEquals(expectedParams, request.params());
 * this file be licensed under the Apache-2.0 license or a
            expectedContentType,
        assertEquals(expectedPath, request.path());
    String expectedRequestIssuerIdentity;
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
            expectedMethod,
        List<String> expectedConsumedParams = List.of("foo", "bar");  
                    assertEquals(expectedMethod, request.method());  
                assertTrue(response.isContentConsumed());  
                    assertEquals(expectedContent, request.content());  
        assertEquals(expectedHeaders, request.headers());  
                    request = new ExtensionRestRequest(nameWritableAwareIn);  
import java.security.Principal;
            expectedPath,  
        expectedRequestIssuerIdentity = identityService.getTokenManager()
        expectedMethod = Method.GET;
        assertTrue(request.isContentConsumed());
        String headerKey = "foo";  
        assertEquals(Collections.emptyList(), request.consumedParams());  
import org.opensearch.core.common.io.stream.BytesStreamInput;  
import org.opensearch.test.OpenSearchTestCase;  
            expectedResponseBytes,
 * compatible open source license.
        assertEquals(expectedContentType, response.getContentType());  
            null,  
                assertTrue(fooList.containsAll(headerValueList));
        assertEquals("bar", request.param("foo"));  
 * The OpenSearch Contributors require contributions made to  
        Map<String, List<String>> expectedHeaders = Map.of(headerKey, headerValueList);
import org.opensearch.rest.RestRequest.Method;
            expectedContentType,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(2, fooList.size());
        assertTrue(response.getHeaders().containsKey(headerKey));
        assertEquals(expectedContent, request.content());
    private IdentityService identityService;
                    request = new ExtensionRestRequest(nameWritableAwareIn);
        assertTrue(fooList.containsAll(headerValueList));
            out.flush();
import org.opensearch.common.settings.Settings;  
        }
        assertTrue(request.hasParam("foo"));
        assertArrayEquals(expectedResponseBytes, response.getContent());
                    assertEquals(expectedMethod, request.method());
                response = new RestExecuteOnExtensionResponse(in);  
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
        assertEquals("value", contentMap.get("key"));  
        BytesReference expectedText = new BytesArray("Plain text");
        assertEquals(expectedHttpVersion, request.protocolVersion());
        List<String> fooList = response.getHeaders().get(headerKey);  
    public void setUp() throws Exception {  
            expectedContent,  
        assertEquals(0, request.content().length());
        assertEquals(expectedHttpVersion, request.protocolVersion());
        assertEquals(2, response.getConsumedParams().size());
        byte[] expectedResponseBytes = expectedResponse.getBytes(StandardCharsets.UTF_8);  
                    assertEquals(expectedHttpVersion, request.protocolVersion());
                assertEquals(2, response.getConsumedParams().size());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            true
import org.opensearch.core.xcontent.XContentParser;
        assertNull(request.getXContentType());
                    assertEquals(expectedPath, request.path());  
    public void testRestExecuteOnExtensionResponse() throws Exception {
        );
import org.opensearch.identity.IdentityService;  
        assertEquals(expectedMethod, request.method());
            expectedResponseBytes,
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        RestStatus expectedStatus = RestStatus.OK;  
        expectedParams = Map.ofEntries(entry("foo", "bar"), entry("baz", "42"));
            response.writeTo(out);  
        assertEquals(expectedText, request.content());  
                assertEquals(1, response.getHeaders().keySet().size());  
            request.writeTo(out);
            expectedMethod,
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());  
                    assertEquals(expectedMethod, request.method());
        assertEquals(expectedPath, request.path());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(expectedMethod, request.method());
        );  
        response = new RestExecuteOnExtensionResponse(
        }
            expectedHeaders,  
        identityService = new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of());
public class ExtensionRestRequestTests extends OpenSearchTestCase {
        assertEquals(expectedParams, request.params());
                assertTrue(response.getConsumedParams().containsAll(expectedConsumedParams));
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        assertEquals(expectedHttpVersion, request.protocolVersion());
import static org.mockito.Mockito.mock;
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
    public void testExtensionRestRequestWithPlainTextContent() throws Exception {
        assertFalse(request.hasParam("bar"));
package org.opensearch.extensions.rest;
        assertEquals(expectedUri, request.uri());  
    }
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
            expectedRequestIssuerIdentity,  
            expectedPath,
                }
        assertEquals(expectedContentType, response.getContentType());  
                }  
            expectedPath,
        extensionUniqueId1 = "ext_1";  
        assertEquals(42L, request.paramAsLong("baz", 0L));
            expectedHeaders,  
        String expectedResponse = "Test response";
            expectedHeaders,
        assertTrue(response.getConsumedParams().containsAll(expectedConsumedParams));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
        assertEquals(0, response.getHeaders().size());
                    assertNull(request.getXContentType());
                assertEquals(expectedStatus, response.getStatus());
            request.writeTo(out);
}
                    assertEquals(expectedHttpVersion, request.protocolVersion());
    Map<String, String> expectedParams;  
                    assertEquals(expectedUri, request.uri());
            expectedParams,
            request.writeTo(out);
                    assertEquals(expectedPath, request.path());
            expectedParams,  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    BytesReference expectedContent;  
    NamedWriteableRegistry registry;  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals("baz", request.param("bar", "baz"));
        expectedHeaders = Map.ofEntries(  
    MediaType expectedContentType;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.core.rest.RestStatus;  
            expectedText,
    }  
                    assertEquals(expectedText, request.content());  
    private String expectedUri;
        assertNull(request.getXContentType());
        assertTrue(request.hasContent());
                    request = new ExtensionRestRequest(nameWritableAwareIn);  
        assertTrue(request.consumedParams().contains("foo"));
                assertTrue(response.getHeaders().containsKey(headerKey));
import org.opensearch.identity.Subject;
            .asAuthHeaderValue();
            new BytesArray(new byte[0]),
        Subject subject = this.identityService.getCurrentSubject();  
            }
                fooList = response.getHeaders().get(headerKey);  
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
        assertFalse(response.isContentConsumed());
        }
    }  
            expectedContentType,
        expectedContent = new BytesArray("{\"key\": \"value\"}".getBytes(StandardCharsets.UTF_8));
            expectedHttpVersion
    Principal userPrincipal;
                    assertEquals(expectedUri, request.uri());
        ExtensionRestRequest request = new ExtensionRestRequest(
        assertEquals(0, response.getConsumedParams().size());  
                    assertEquals(expectedUri, request.uri());
import org.opensearch.identity.tokens.OnBehalfOfClaims;
        assertTrue(response.isContentConsumed());  
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());  
        ExtensionRestRequest request = new ExtensionRestRequest(
                    assertEquals(expectedHttpVersion, request.protocolVersion());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(expectedHeaders, request.headers());
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
            expectedUri,  
            expectedParams,
import static java.util.Map.entry;
