                expected.setIndex("_index");  
            assertNull(parser.nextToken());  
 * Licensed to Elasticsearch under one or more contributor  
    }
                  "line": 1,
        RestChannel channel = new SimpleExceptionRestChannel(request);  
        request.params().put("error_trace", "true");
            OpenSearchStatusException.class,
                }
        String reason;  
                    type = "illegal_argument_exception";  
        ShardSearchFailure failure1 = new ShardSearchFailure(
                status = RestStatus.NOT_FOUND;
        assertThat(exception.getMessage(), containsString("UTF16 string length"));  
                String resourceType = randomAlphaOfLength(5);
public class BytesRestResponseTests extends OpenSearchTestCase {
 */  
        assertThat(text, not(containsString("FileNotFoundException[/foo/bar]")));  
        String text = response.content().utf8ToString();
 * the Apache License, Version 2.0 (the "License"); you may
        String type = "exception";
        assertNotNull(response.content());
        }
        OpenSearchException cause = null;
            assertThat(text, containsString("{\"root_cause\":[{\"type\":\"file_not_found_exception\",\"reason\":\"/foo/bar\"}]"));
import static org.hamcrest.Matchers.notNullValue;  
    public void testNullThrowable() throws Exception {
                      "type": "parsing_exception",  
        assertThat(response.getHeaders().get("n2"), notNullValue());  
        BytesRestResponse response = new BytesRestResponse(channel, t);
                TransportAddress address = buildNewFakeTransportAddress();
                    new ResourceAlreadyExistsException("OpenSearchWrapperException with a cause that has a custom status")
                );  
                    "remote",
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;
                builder.field("status", randomFrom(RestStatus.values()).getStatus());
        assertEquals(2, response.getHeaders().size());  
            case 4:
        assertEquals(expected.trim(), text.trim());
                "root_cause": [  
 * The OpenSearch Contributors require contributions made to  
        SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
                if (detailed) {
                    reason = "OpenSearchWrapperException with a cause that has a custom status";  
            default:
        BytesRestResponse response = new BytesRestResponse(channel, null);  
                    type = "exception";
    }  
        assertThat(text, not(containsString("error_trace")));
        DetailedExceptionRestChannel(RestRequest request) {
        );  
/*  
    }
    }
        final RestChannel channel = new DetailedExceptionRestChannel(request);
    public void testNonOpenSearchExceptionIsNotShownAsSimpleMessage() throws Exception {
 *  
    }
        RestChannel channel = new DetailedExceptionRestChannel(request);
                throw new UnsupportedOperationException("Failed to generate random exception");  
        final BytesRestResponse response = new BytesRestResponse(channel, new OpenSearchException("simulated"));  
        RestRequest request = new FakeRestRequest();
        assertThat(content, containsString("\"reason\":\"simulated\""));
                    addHeadersOrMetadata = randomBoolean();
        assertThat(response.getHeaders().get("n1"), contains("v11", "v12"));
                    "OpenSearchWrapperException with a cause that has a special treatment",
            Exception e = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
import org.opensearch.OpenSearchStatusException;  
        RestStatus status = RestStatus.INTERNAL_SERVER_ERROR;
        assertEquals(RestStatus.GATEWAY_TIMEOUT, response.status());  
                original = new OpenSearchStatusException("OpenSearchStatusException with random status", status);
import org.opensearch.action.search.ShardSearchFailure;  
        assertEquals(RestStatus.REQUEST_ENTITY_TOO_LARGE, exception.status());
    private static class DetailedExceptionRestChannel extends AbstractRestChannel {  
                "phase": "search",
                    "node": "node_1",
    public void testStringConstructorMapsOversizedContentToRequestEntityTooLarge() {  
import org.opensearch.search.SearchShardTarget;
                    type = "resource_already_exists_exception";
import org.opensearch.action.OriginalIndices;
        assertThat(text, not(containsString("error_trace")));  
        assertTrue(stackTrace.contains("Caused by: ParsingException[foobar]"));
                ],  
                    "shard": 1,
import org.opensearch.ResourceNotFoundException;  
        assertThat(text, containsString("\"error\":\"unknown\""));
import static org.hamcrest.Matchers.containsString;
        String text = response.content().utf8ToString();
    public void testResponseWhenTimeoutException() throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
            String text = response.content().utf8ToString();  
 * SPDX-License-Identifier: Apache-2.0
                original = new OpenSearchException("OpenSearchException without cause");
            new ParsingException(1, 2, "foobar", null),
            this.addHeader("n1", "v11", "v12");
            }  
    class UnknownException extends Exception {
/*  
                builder.endObject();  
                    new IllegalArgumentException("wrong")
                    reason = "RemoteTransportException[[remote][" + address.toString() + "][action]]";
        assertDeepEquals(expected, parsedError);
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(path).build();  
    }  
                    reason = "OpenSearchStatusException[OpenSearchStatusException with random status]";
                } else {
                    reason = "wrong";
 * compatible open source license.
                } else {
                }  
        final String oversized = "a".repeat(overflowingLength);
            BytesRestResponse response = new BytesRestResponse(channel, e);
        SimpleExceptionRestChannel(RestRequest request) {
            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)  
        public void sendResponse(RestResponse response) {}  
import java.io.FileNotFoundException;  
                  }  
                  {
                    addHeadersOrMetadata = randomBoolean();  
import org.opensearch.ResourceAlreadyExistsException;
    public void testNoErrorFromXContent() throws IOException {
        RestRequest request = new FakeRestRequest();
     * throws before {@code BytesRef} allocates its {@code maxUTF8Length} byte array.
                break;
        assertThat(text, containsString("\"stack_trace\":\"OpenSearchException[an error occurred reading data]"));  
            String text = response.content().utf8ToString();  
    }
                    type = "status_exception";
                originalException.addHeader("foo", "bar", "baz");  
    }
        // if we try to decode the path, this will throw an IllegalArgumentException again  
            Exception e = new FileNotFoundException("/foo/bar");
        final RestChannel channel = new DetailedExceptionRestChannel(request);
import java.io.IOException;
        String text = response.content().utf8ToString();
    public static class WithHeadersException extends OpenSearchException {
        {  
     * Drives an oversized string through the public constructor, so this fails if the guard is ever unwired from
                    "action",  
import java.util.Collections;
        @Override  
 * license agreements. See the NOTICE file distributed with
        assertThat(exception.getMessage(), containsString(String.valueOf(overflowingLength)));
import org.opensearch.core.common.ParsingException;  
                    "reason": "foobar",  
import org.opensearch.action.search.SearchPhaseExecutionException;
            super(request, true);  
                    "line": 1,
            if (randomBoolean()) {
        assertThat(content, containsString("\"status\":" + 500));
            }
                } else {
                    "type": "parsing_exception",
 * Unless required by applicable law or agreed to in writing,
                } else {
import org.opensearch.core.rest.RestStatus;
        OpenSearchException parsedError;  
                }  
        RestChannel channel = randomBoolean() ? new DetailedExceptionRestChannel(request) : new SimpleExceptionRestChannel(request);  
        final XContentType xContentType = randomFrom(XContentType.values());
import static org.hamcrest.Matchers.contains;  
        assertThat(text, containsString("\"error\":\"Internal failure\""));
        assertThat(text, not(containsString("FileNotFoundException")));  
package org.opensearch.rest;
                originalException.addMetadata("opensearch.metadata_0", "0");
    /**
                } else {  
import java.util.Map;  
        final BytesRestResponse response = new BytesRestResponse(channel, new OpenSearchTimeoutException("simulated timeout"));
                expected.addHeader("foo", "bar", "baz");
                    cause = new OpenSearchException("OpenSearch exception [type=file_not_found_exception, reason=missing]");  
                      "line": 1,
        assertThat(text, containsString("{\"type\":\"file_not_found_exception\",\"reason\":\"/foo/bar\"}"));
        final String path = "%a";
        String expected = XContentHelper.stripWhitespace("""  
        assertThat(content, containsString("\"type\":\"exception\""));  
                }  
                original = new ResourceNotFoundException("OpenSearchException with custom status");  
        BytesRestResponse response = new BytesRestResponse(channel, t);  
                  "col": 2
        }
                "grouped": true,
            case 0:  
     * {@code -Dtests.heap.size}, which the same assignment overrides. Only the string has to fit, because the guard  
     */
    }
            parsedError = BytesRestResponse.errorFromXContent(parser);
            case 2:
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> RestUtils.decodeComponent(request.rawPath()));
     * 715,827,883 chars - roughly 683 MiB as a Latin-1 compact string. That fits comfortably in the test heap, which  
        assumeTrue("needs ~683MiB of heap to build the oversized string", Runtime.getRuntime().maxMemory() >= 1_500_000_000L);
        Exception t = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));  
    }
 *
        assertThat(content, containsString("\"type\":\"illegal_argument_exception\""));
                    reason = "OpenSearchException[OpenSearchException without cause]";  
            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
                originalException.setIndex("_index");
import org.opensearch.core.index.shard.ShardId;  
        BytesRestResponse response = new BytesRestResponse(channel, new RemoteTransportException("foo", ex));
                "caused_by": {
                    addHeadersOrMetadata = randomBoolean();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void sendResponse(RestResponse response) {}
        final int overflowingLength = (Integer.MAX_VALUE / 3) + 1;
        final String content = response.content().utf8ToString();
import org.opensearch.core.common.transport.TransportAddress;
    public void testWithHeaders() throws Exception {
import org.opensearch.OpenSearchException;
 * this file be licensed under the Apache-2.0 license or a
        try (XContentParser parser = createParser(xContentType.xContent(), response.content())) {
import org.opensearch.test.OpenSearchTestCase;
        String text = response.content().utf8ToString();  
            if (randomBoolean()) {  
        RestChannel channel = new DetailedExceptionRestChannel(request);
        assertThat(response.getHeaders().get("n2"), contains("v21", "v22"));
                break;
            this.addMetadata("opensearch.test", "value1", "value2");
        assertThat(text, not(containsString("error_trace")));
              },
 * You may obtain a copy of the License at  
        );
                    }
        Exception t = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
        RestRequest request = new FakeRestRequest();  
import org.opensearch.OpenSearchTimeoutException;
                if (detailed) {  
 * GitHub history for details.
                    reason = "OpenSearchException with custom status";
        assertThat(content, containsString("\"status\":" + 400));  
        assertThat(text, containsString("{\"type\":\"file_not_found_exception\""));
        BytesRestResponse response = new BytesRestResponse(channel, original);
        OpenSearchStatusException expected = new OpenSearchStatusException(message, status, cause);
            "all shards failed",
            super("");
        WithHeadersException() {  
    }  
        RestChannel channel = detailed ? new DetailedExceptionRestChannel(request) : new SimpleExceptionRestChannel(request);
    public void testSimpleExceptionMessage() throws Exception {
        );  
                if (detailed) {
import org.opensearch.core.common.bytes.BytesReference;
            if (randomBoolean()) {
    }  
                original = new RemoteTransportException(  
        switch (randomIntBetween(0, 5)) {
        final String content = response.content().utf8ToString();
    public void testResponseWhenPathContainsEncodingError() throws IOException {
        if (addHeadersOrMetadata) {  
        RestChannel channel = new DetailedExceptionRestChannel(request);
     * <p>
        RestRequest request = new FakeRestRequest();  
        BytesRestResponse response = new BytesRestResponse(channel, t);  
                expected.addMetadata("opensearch.metadata_0", "0");
                  "reason": "foobar",  
                    address,
 * KIND, either express or implied.  See the License for the
                      "col": 2  
                status = RestStatus.BAD_REQUEST;
        final RestRequest request = new FakeRestRequest();
                if (detailed) {
                    type = "resource_not_found_exception";
        @Override
                original = new OpenSearchException("OpenSearchException with a cause", new FileNotFoundException("missing"));
        RestChannel channel = new SimpleExceptionRestChannel(request);  
        assertEquals("Failed to parse opensearch status exception: no exception was found", e.getMessage());
            new ParsingException(1, 2, "foobar", null),
import org.opensearch.core.xcontent.XContentBuilder;
                    reason = "OpenSearchException with a cause";
        assertThat(text, containsString("OpenSearchException[an error occurred reading data]"));
                );
            () -> new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, oversized)
              "error": {
        ShardSearchFailure failure = new ShardSearchFailure(  
                expected.setResources(resourceType, resourceId);
            super(message, cause);  
import org.opensearch.ExceptionsHelper;
                if (detailed) {
            case 3:
                "type": "search_phase_execution_exception",
 * Modifications Copyright OpenSearch Contributors. See
    }
        final RestRequest request = new FakeRestRequest();  
/*
        Map<String, String> params = Collections.singletonMap("format", xContentType.format());  
                if (detailed) {
import static org.hamcrest.Matchers.not;
                String resourceId = randomAlphaOfLength(5);  
                } else {
    }
                builder.startObject();
        assertThat(content, containsString("\"status\":" + 504));
    public void testDetailedExceptionMessage() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case 1:  
        });  
            {
        assertNotNull(response.content());
        RestRequest request = new FakeRestRequest();  
        String text = response.content().utf8ToString();
     * {@link BytesRestResponse#BytesRestResponse(RestStatus, String, String)}.  
              "status": 400
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        RestChannel channel = new SimpleExceptionRestChannel(request);
        OpenSearchStatusException exception = expectThrows(  
                    reason = "ResourceNotFoundException[OpenSearchException with custom status]";
        RestRequest request = new FakeRestRequest();
                    "index": "foo",  
                "reason": "all shards failed",  
     * assumption below is insurance in case that value is ever lowered; it is not reachable through
        RestChannel channel = new DetailedExceptionRestChannel(request);
                    reason = "OpenSearchException without cause";
            this.addHeader("n2", "v21", "v22");  
        Exception original;
                  }
            }
 *
                  "type": "parsing_exception",
    public void testGuessRootCause() throws IOException {  
        assertThat(response.getHeaders().get("n1"), notNullValue());
        final String content = response.content().utf8ToString();  
        assertThat(content, containsString("\"reason\":\"simulated timeout\""));  
    }
                      "reason": "foobar",
        assertThat(text, not(containsString("UnknownException[an error occurred reading data]")));
                break;
        assertThat(text, containsString("\"type\":\"unknown_exception\",\"reason\":\"an error occurred reading data\""));
        String stackTrace = ExceptionsHelper.stackTrace(ex);  
        Exception t = new UnknownException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
        final boolean detailed = randomBoolean();
                "failed_shards": [  
        final BytesRestResponse response = new BytesRestResponse(channel, e);
        {  
            try (XContentBuilder builder = XContentBuilder.builder(randomFrom(XContentType.values()).xContent())) {  
        }
    }
                }  
            if (randomBoolean()) {
import org.opensearch.common.xcontent.XContentHelper;
                break;
        String text = response.content().utf8ToString();
        assertThat(text, not(containsString("/foo/bar")));
        }
 */
import org.opensearch.common.xcontent.XContentType;
            new ShardSearchFailure[] { failure, failure1 }
     * The guard trips above {@code Integer.MAX_VALUE / 3} UTF-16 chars, so the smallest string that reaches it is
                    "col": 2
        UnknownException(final String message, final Throwable cause) {
                try (XContentParser parser = createParser(builder.contentType().xContent(), BytesReference.bytes(builder))) {
        String message = "OpenSearch exception [type=" + type + ", reason=" + reason + "]";  
            OpenSearchException originalException = ((OpenSearchException) original);
            "search",  
                originalException.setResources(resourceType, resourceId);
            }  
        }
        assertThat(text, containsString("{\"type\":\"exception\",\"reason\":\"an error occurred reading data\"}"));  
                    addHeadersOrMetadata = randomBoolean();  
                status = randomFrom(RestStatus.values());
 * specific language governing permissions and limitations
                status = RestStatus.BAD_REQUEST;  
        RestRequest request = new FakeRestRequest();
            case 5:  
                break;
        final RestChannel channel = new DetailedExceptionRestChannel(request);
}  
    private static class SimpleExceptionRestChannel extends AbstractRestChannel {
        );  
 * this work for additional information regarding copyright
        }
    }
    public void testErrorTrace() throws Exception {
        assertNotNull(response.content());
        assertThat(content, containsString("\"reason\":\"partial escape sequence at end of string: %a\""));
                }
        RestRequest request = new FakeRestRequest();
        BytesRestResponse response = new BytesRestResponse(channel, t);
 * ownership. Elasticsearch licenses this file to you under  
        BytesRestResponse response = new BytesRestResponse(channel, new WithHeadersException());
            """);
        }  
    public void testConvert() throws IOException {  
                    reason = "OpenSearchStatusException with random status";  
 * not use this file except in compliance with the License.
                break;  
            }  
        assertEquals(expected.status(), parsedError.status());  
                    reason = "RemoteTransportException[[OpenSearchWrapperException with a cause that has a special treatment]]";  
        }
        Exception t = new UnknownException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
                ],
        boolean addHeadersOrMetadata = false;  
        }
 * software distributed under the License is distributed on an
    }  
    public void testResponseWhenInternalServerError() throws IOException {  
    public void testErrorToAndFromXContent() throws IOException {
 * under the License.  
            }
import org.opensearch.transport.RemoteTransportException;
 */  
                }
            BytesRestResponse response = new BytesRestResponse(channel, e);
            super(request, false);
                original = new RemoteTransportException(  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
                    BytesRestResponse.errorFromXContent(parser);  
                  {
                    "reason": {
     * {@code build.gradle} fixes at {@code options.forkOptions.memoryMaximumSize} (3g) for every forked test JVM. The
                    reason = "OpenSearchException[OpenSearchException with a cause]";
            assertThat(text, containsString("{\"root_cause\":[{\"type\":\"exception\",\"reason\":\"an error occurred reading data\"}]"));
                }
import org.opensearch.test.rest.FakeRestRequest;  
