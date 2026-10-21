        assertEquals(expectedPath, request.path());
            Collections.emptyList(),
            request.writeTo(out);
            expectedUri,
        assertEquals(expectedContent, request.content());
import org.opensearch.core.common.bytes.BytesReference;
                    final ExtensionRestRequest requestWithNoContentType = request;
            out.flush();
    String extensionUniqueId1;
        assertTrue(response.getConsumedParams().containsAll(expectedConsumedParams));
        extensionTokenProcessor = "placeholder_extension_token_processor";
        assertEquals(expectedMethod, request.method());
        extensionUniqueId1 = "ext_1";
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.identity.Subject;
    NamedWriteableRegistry registry;
            expectedHttpVersion
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
                }
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals(expectedText, request.content());
                assertEquals(expectedStatus, response.getStatus());
    public void setUp() throws Exception {
    private String expectedPath;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    assertEquals(expectedHttpVersion, request.protocolVersion());
        XContentParser parser = request.contentParser(NamedXContentRegistry.EMPTY);
            expectedHttpVersion
            expectedHeaders,
 */
        );
        assertEquals(2, fooList.size());
    private IdentityService identityService;
        assertEquals(expectedMethod, request.method());
        expectedHeaders = Map.ofEntries(
import java.util.Collections;
            expectedMethod,
                    assertEquals(expectedMethod, request.method());
        }
import org.opensearch.core.xcontent.XContentParser;
                    assertEquals(expectedUri, request.uri());
import java.util.Map;
        response = new RestExecuteOnExtensionResponse(
        assertEquals(expectedStatus, response.getStatus());
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
                fooList = response.getHeaders().get(headerKey);
            expectedResponseBytes,
                assertEquals(2, response.getConsumedParams().size());
        final ExtensionRestRequest requestWithNoContent = request;
        String headerKey = "foo";
        assertFalse(request.hasParam("bar"));
            expectedHeaders,
}
        assertEquals(expectedMethod, request.method());
import org.opensearch.OpenSearchParseException;
    public void testExtensionRestRequest() throws Exception {
        expectedContentType = MediaTypeRegistry.JSON;
        assertEquals("value", contentMap.get("key"));
                    assertEquals(expectedText, request.content());
 * compatible open source license.
            expectedRequestIssuerIdentity,
                    assertEquals(expectedContent, request.content());
            expectedText,
    public void testRestExecuteOnExtensionResponse() throws Exception {
        expectedHttpVersion = HttpRequest.HttpVersion.HTTP_1_1;
            expectedResponseBytes,
        assertArrayEquals(expectedResponseBytes, response.getContent());
    }
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
import org.opensearch.rest.RestRequest.Method;
        expectedPath = "/test/uri";
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals(expectedHttpVersion, request.protocolVersion());
        super.setUp();
                    assertEquals(expectedParams, request.params());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        RestExecuteOnExtensionResponse response = new RestExecuteOnExtensionResponse(
        assertEquals(42L, request.paramAsLong("baz", 0L));
            expectedHttpVersion
        assertEquals(0, response.getHeaders().size());
            expectedHeaders,
        expectedRequestIssuerIdentity = identityService.getTokenManager()
        assertEquals(expectedHttpVersion, request.protocolVersion());
                response = new RestExecuteOnExtensionResponse(in);
        assertEquals(expectedPath, request.path());
                    assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
import java.util.List;
        assertFalse(response.isContentConsumed());
    Principal userPrincipal;
            expectedHeaders,
            .issueOnBehalfOfToken(identityService.getCurrentSubject(), claims)
import org.opensearch.core.common.bytes.BytesArray;
        assertFalse(request.isContentConsumed());
        assertEquals(expectedUri, request.uri());
        assertEquals(expectedParams, request.params());
            }
                    assertEquals(expectedPath, request.path());
            false
        assertEquals(2, response.getConsumedParams().size());
        assertEquals(expectedStatus, response.getStatus());
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            expectedMethod,
            new BytesArray(new byte[0]),
        byte[] expectedResponseBytes = expectedResponse.getBytes(StandardCharsets.UTF_8);
                assertTrue(response.getConsumedParams().containsAll(expectedConsumedParams));
        );
        ExtensionRestRequest request = new ExtensionRestRequest(
        assertTrue(request.consumedParams().contains("baz"));
    }
    BytesReference expectedContent;
import static org.mockito.Mockito.mock;
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.rest.BytesRestResponse;
            request.writeTo(out);
        OnBehalfOfClaims claims = new OnBehalfOfClaims("testID", subject.getPrincipal().getName());
        assertEquals(expectedContentType, response.getContentType());
                assertEquals(expectedContentType, response.getContentType());
import org.opensearch.core.common.io.stream.BytesStreamInput;
            expectedParams,
                    assertEquals(expectedMethod, request.method());
                    request = new ExtensionRestRequest(nameWritableAwareIn);
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
        assertThrows(OpenSearchParseException.class, () -> requestWithNoContent.contentParser(NamedXContentRegistry.EMPTY));
                }
            out.flush();
            request.writeTo(out);
        Map<String, String> contentMap = parser.mapStrings();
import org.opensearch.core.rest.RestStatus;
        String expectedContentType = BytesRestResponse.TEXT_CONTENT_TYPE;
            expectedParams,
        assertTrue(request.isContentConsumed());
        expectedUri = "foobar?foo=bar&baz=42";
        assertEquals("bar", request.param("foo"));
        assertTrue(request.hasParam("foo"));
                    assertEquals(expectedPath, request.path());
        );
        );
        assertEquals(expectedPath, request.path());
            expectedParams,
            expectedMethod,
            expectedPath,
            }
package org.opensearch.extensions.rest;
    }
                assertTrue(fooList.containsAll(headerValueList));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, List<String>> expectedHeaders = Map.of(headerKey, headerValueList);
        assertEquals("baz", request.param("bar", "baz"));
            null,
        assertEquals(expectedParams, request.params());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(expectedHttpVersion, request.protocolVersion());
        identityService = new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of());
                    request = new ExtensionRestRequest(nameWritableAwareIn);
        TokenManager tokenManager = identityService.getTokenManager();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.threadpool.ThreadPool;
            expectedPath,
        assertEquals(expectedRequestIssuerIdentity, request.getRequestIssuerIdentity());
        assertEquals(0L, request.paramAsLong("bar", 0L));
        expectedParams = Map.ofEntries(entry("foo", "bar"), entry("baz", "42"));
/*
import org.opensearch.identity.tokens.TokenManager;
        assertEquals(expectedContentType, request.getXContentType());
        ExtensionRestRequest request = new ExtensionRestRequest(
                    assertEquals(expectedHttpVersion, request.protocolVersion());
        }
            }
 * The OpenSearch Contributors require contributions made to
                assertEquals(2, fooList.size());
                    request = new ExtensionRestRequest(nameWritableAwareIn);
            out.flush();
        assertEquals(1, response.getHeaders().keySet().size());
        userPrincipal = () -> "user1";
    Map<String, List<String>> expectedHeaders;
import java.util.Arrays;
            entry("Content-Type", Arrays.asList("application/json")),
                    assertEquals(expectedUri, request.uri());
            expectedPath,
        }
            null,
import java.security.Principal;
    String expectedRequestIssuerIdentity;
                assertTrue(response.isContentConsumed());
    MediaType expectedContentType;
                    assertEquals(0, request.content().length());
public class ExtensionRestRequestTests extends OpenSearchTestCase {
            response.writeTo(out);
            expectedUri,
        assertEquals(Collections.emptyList(), request.consumedParams());
        assertNull(request.getXContentType());
            out.flush();
        ExtensionRestRequest request = new ExtensionRestRequest(
            expectedContentType,
    public void testExtensionRestRequestWithNoContent() throws Exception {
        expectedContent = new BytesArray("{\"key\": \"value\"}".getBytes(StandardCharsets.UTF_8));
        assertTrue(request.hasContent());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expectedHeaders, request.headers());
                }
            expectedRequestIssuerIdentity,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            expectedContentType,
        expectedMethod = Method.GET;
            expectedContentType,
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.nio.charset.StandardCharsets;
    Map<String, String> expectedParams;
import org.opensearch.common.settings.Settings;
import org.opensearch.identity.tokens.OnBehalfOfClaims;
                assertEquals(1, response.getHeaders().keySet().size());
        assertArrayEquals(expectedResponseBytes, response.getContent());
        assertEquals(0, request.content().length());
import org.opensearch.http.HttpRequest;
                    assertNull(request.getXContentType());
        String expectedResponse = "Test response";
        List<String> fooList = response.getHeaders().get(headerKey);
        assertEquals(expectedContentType, response.getContentType());
            expectedContent,
            expectedUri,
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            Collections.emptyMap(),
        );
                    assertEquals(expectedPath, request.path());
    }
        assertTrue(request.consumedParams().contains("foo"));
        assertTrue(response.isContentConsumed());
                    assertEquals(expectedParams, request.params());
    private Method expectedMethod;
        BytesReference expectedText = new BytesArray("Plain text");
    public void testExtensionRestRequestWithPlainTextContent() throws Exception {
        assertEquals(0, response.getConsumedParams().size());
                assertArrayEquals(expectedResponseBytes, response.getContent());
        );
                    assertEquals(expectedUri, request.uri());
            expectedRequestIssuerIdentity,
        assertTrue(fooList.containsAll(headerValueList));
        assertEquals(expectedUri, request.uri());
            expectedStatus,
 *
                    assertNull(request.getXContentType());
                    assertEquals(expectedHttpVersion, request.protocolVersion());
            entry("foo", Arrays.asList("hello", "world"))
import org.opensearch.identity.IdentityService;
import static java.util.Map.entry;
        assertNull(request.getXContentType());
    String extensionTokenProcessor;
        assertEquals(expectedParams, request.params());
            .asAuthHeaderValue();
        assertTrue(response.getHeaders().containsKey(headerKey));
                assertTrue(response.getHeaders().containsKey(headerKey));
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
        Subject subject = this.identityService.getCurrentSubject();
    HttpRequest.HttpVersion expectedHttpVersion;
        List<String> headerValueList = List.of("bar", "baz");
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            true
            expectedStatus,
                    assertThrows(OpenSearchParseException.class, () -> requestWithNoContentType.contentParser(NamedXContentRegistry.EMPTY));
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        RestStatus expectedStatus = RestStatus.OK;
            }
        List<String> expectedConsumedParams = List.of("foo", "bar");
    private String expectedUri;
                    assertEquals(expectedMethod, request.method());
                    assertEquals(expectedHeaders, request.headers());
                    assertEquals(expectedParams, request.params());
                try (NamedWriteableAwareStreamInput nameWritableAwareIn = new NamedWriteableAwareStreamInput(in, registry)) {
            expectedConsumedParams,
