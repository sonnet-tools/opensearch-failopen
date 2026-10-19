 * software distributed under the License is distributed on an
            assertNull(parser.nextToken());
                    address,
                original = new RemoteTransportException(
                if (detailed) {
        RestChannel channel = new DetailedExceptionRestChannel(request);
        assertDeepEquals(expected, parsedError);
        BytesRestResponse response = new BytesRestResponse(channel, t);
        }
 *
        final String oversized = "a".repeat(overflowingLength);
     * {@link BytesRestResponse#BytesRestResponse(RestStatus, String, String)}.
              "status": 400
        assertThat(content, containsString("\"reason\":\"partial escape sequence at end of string: %a\""));
                break;
        // if we try to decode the path, this will throw an IllegalArgumentException again
import org.opensearch.core.common.bytes.BytesReference;
        );
                expected.setIndex("_index");
            super(request, false);
 * specific language governing permissions and limitations
        BytesRestResponse response = new BytesRestResponse(channel, t);
    }
                }
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
    }
        String message = "OpenSearch exception [type=" + type + ", reason=" + reason + "]";
        String text = response.content().utf8ToString();
                break;
     * Drives an oversized string through the public constructor, so this fails if the guard is ever unwired from
 * not use this file except in compliance with the License.
                  "line": 1,
        final String content = response.content().utf8ToString();
        final RestRequest request = new FakeRestRequest();
                    "index": "foo",
        public void sendResponse(RestResponse response) {}
    }
        assertThat(content, containsString("\"status\":" + 504));
        assertNotNull(response.content());
                  }
            }
    public void testResponseWhenTimeoutException() throws IOException {
        assertThat(text, not(containsString("FileNotFoundException")));
        ShardSearchFailure failure1 = new ShardSearchFailure(
                original = new OpenSearchException("OpenSearchException with a cause", new FileNotFoundException("missing"));
        assertThat(text, not(containsString("FileNotFoundException[/foo/bar]")));
 * license agreements. See the NOTICE file distributed with
    }
                    "reason": {
                "caused_by": {
        final RestChannel channel = new DetailedExceptionRestChannel(request);
            }
                    "action",
import org.opensearch.common.xcontent.XContentHelper;
    class UnknownException extends Exception {
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.rest.RestStatus;
        RestRequest request = new FakeRestRequest();
     * assumption below is insurance in case that value is ever lowered; it is not reachable through
            case 0:
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(path).build();
                expected.addHeader("foo", "bar", "baz");
        String stackTrace = ExceptionsHelper.stackTrace(ex);
            {
    public void testConvert() throws IOException {
    /**
                    reason = "OpenSearchException[OpenSearchException with a cause]";
                originalException.addMetadata("opensearch.metadata_0", "0");
    public void testNullThrowable() throws Exception {
        assertThat(text, not(containsString("UnknownException[an error occurred reading data]")));
        assertEquals(RestStatus.GATEWAY_TIMEOUT, response.status());
                  {
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;
            }
                    reason = "RemoteTransportException[[remote][" + address.toString() + "][action]]";
                try (XContentParser parser = createParser(builder.contentType().xContent(), BytesReference.bytes(builder))) {
        assertThat(exception.getMessage(), containsString(String.valueOf(overflowingLength)));
                    "line": 1,
                    type = "status_exception";
        final RestRequest request = new FakeRestRequest();
/*
        SimpleExceptionRestChannel(RestRequest request) {
                  "col": 2
                    new ResourceAlreadyExistsException("OpenSearchWrapperException with a cause that has a custom status")
        assertThat(text, not(containsString("/foo/bar")));
                      "col": 2
    public void testGuessRootCause() throws IOException {
                    "col": 2
                "grouped": true,
                    reason = "OpenSearchException without cause";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
            }
        if (addHeadersOrMetadata) {
            case 1:
        assertThat(content, containsString("\"type\":\"illegal_argument_exception\""));
        Exception t = new UnknownException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
                    type = "resource_not_found_exception";
                }
        );
                break;
 */
        assertThat(text, containsString("\"error\":\"Internal failure\""));
    }
                "type": "search_phase_execution_exception",
        assertThat(content, containsString("\"reason\":\"simulated timeout\""));
                } else {
            this.addHeader("n1", "v11", "v12");
        assertNotNull(response.content());
        }
 * KIND, either express or implied.  See the License for the
                    reason = "OpenSearchException[OpenSearchException without cause]";
            OpenSearchStatusException.class,
        OpenSearchStatusException exception = expectThrows(
        RestStatus status = RestStatus.INTERNAL_SERVER_ERROR;
        RestRequest request = new FakeRestRequest();
    }
            case 5:
                    reason = "OpenSearchStatusException with random status";
            """);
     * <p>
            BytesRestResponse response = new BytesRestResponse(channel, e);
import static org.hamcrest.Matchers.containsString;
                if (detailed) {
            super(message, cause);
        RestChannel channel = new SimpleExceptionRestChannel(request);
        BytesRestResponse response = new BytesRestResponse(channel, t);
                    reason = "OpenSearchWrapperException with a cause that has a custom status";
        }
                originalException.setIndex("_index");
                    BytesRestResponse.errorFromXContent(parser);
            try (XContentBuilder builder = XContentBuilder.builder(randomFrom(XContentType.values()).xContent())) {
import org.opensearch.action.search.SearchPhaseExecutionException;
import static org.hamcrest.Matchers.not;
                    "node": "node_1",
 * SPDX-License-Identifier: Apache-2.0
        assertThat(text, not(containsString("error_trace")));
            assertThat(text, containsString("{\"root_cause\":[{\"type\":\"file_not_found_exception\",\"reason\":\"/foo/bar\"}]"));
            new ShardSearchFailure[] { failure, failure1 }
    public static class WithHeadersException extends OpenSearchException {
import org.opensearch.test.OpenSearchTestCase;
            super(request, true);
        RestChannel channel = new DetailedExceptionRestChannel(request);
                expected.setResources(resourceType, resourceId);
import java.util.Collections;
}
        assertEquals("Failed to parse opensearch status exception: no exception was found", e.getMessage());
import org.opensearch.OpenSearchException;
                    addHeadersOrMetadata = randomBoolean();
                status = RestStatus.BAD_REQUEST;
                    "remote",
     * {@code build.gradle} fixes at {@code options.forkOptions.memoryMaximumSize} (3g) for every forked test JVM. The
        {
            case 4:
    }
        assertThat(text, containsString("{\"type\":\"file_not_found_exception\",\"reason\":\"/foo/bar\"}"));
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            OpenSearchException originalException = ((OpenSearchException) original);
    public void testDetailedExceptionMessage() throws Exception {
        String reason;
                TransportAddress address = buildNewFakeTransportAddress();
    }
        assertNotNull(response.content());
        BytesRestResponse response = new BytesRestResponse(channel, original);
                    addHeadersOrMetadata = randomBoolean();
                }
            this.addHeader("n2", "v21", "v22");
import org.opensearch.action.search.ShardSearchFailure;
 */
        assumeTrue("needs ~683MiB of heap to build the oversized string", Runtime.getRuntime().maxMemory() >= 1_500_000_000L);
        OpenSearchException parsedError;
        RestRequest request = new FakeRestRequest();
                    addHeadersOrMetadata = randomBoolean();
        boolean addHeadersOrMetadata = false;
    }
        ShardSearchFailure failure = new ShardSearchFailure(
import org.opensearch.ExceptionsHelper;
        @Override
                "reason": "all shards failed",
        Exception t = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
        String text = response.content().utf8ToString();
import org.opensearch.action.OriginalIndices;
                    reason = "RemoteTransportException[[OpenSearchWrapperException with a cause that has a special treatment]]";
            () -> new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, oversized)
    private static class DetailedExceptionRestChannel extends AbstractRestChannel {
     * throws before {@code BytesRef} allocates its {@code maxUTF8Length} byte array.
        RestRequest request = new FakeRestRequest();
                      "line": 1,
        assertEquals(2, response.getHeaders().size());
 * GitHub history for details.
                if (detailed) {
        });
import org.opensearch.OpenSearchStatusException;
        OpenSearchException cause = null;
                  "type": "parsing_exception",
import org.opensearch.common.xcontent.XContentType;
        RestRequest request = new FakeRestRequest();
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
    public void testErrorTrace() throws Exception {
import java.io.IOException;
     */
     * 715,827,883 chars - roughly 683 MiB as a Latin-1 compact string. That fits comfortably in the test heap, which
        assertEquals(RestStatus.REQUEST_ENTITY_TOO_LARGE, exception.status());
        RestChannel channel = new SimpleExceptionRestChannel(request);
import org.opensearch.core.xcontent.XContentParser;
        UnknownException(final String message, final Throwable cause) {
            "all shards failed",
            this.addMetadata("opensearch.test", "value1", "value2");
                } else {
import org.opensearch.test.rest.FakeRestRequest;
    public void testNoErrorFromXContent() throws IOException {
                status = RestStatus.NOT_FOUND;
        assertThat(content, containsString("\"status\":" + 500));
                    reason = "wrong";
        );
            new ParsingException(1, 2, "foobar", null),
        final String path = "%a";
        assertThat(text, not(containsString("error_trace")));
import static org.hamcrest.Matchers.contains;
    }
        assertThat(exception.getMessage(), containsString("UTF16 string length"));
 * Licensed to Elasticsearch under one or more contributor
    }
                original = new RemoteTransportException(
    }
                ],
        final int overflowingLength = (Integer.MAX_VALUE / 3) + 1;
        RestRequest request = new FakeRestRequest();
        OpenSearchStatusException expected = new OpenSearchStatusException(message, status, cause);
        BytesRestResponse response = new BytesRestResponse(channel, new RemoteTransportException("foo", ex));
        assertThat(text, containsString("\"type\":\"unknown_exception\",\"reason\":\"an error occurred reading data\""));
            new ParsingException(1, 2, "foobar", null),
 * You may obtain a copy of the License at
        }
        RestRequest request = new FakeRestRequest();
            if (randomBoolean()) {
            assertThat(text, containsString("{\"root_cause\":[{\"type\":\"exception\",\"reason\":\"an error occurred reading data\"}]"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testErrorToAndFromXContent() throws IOException {
                      "reason": "foobar",
        final RestChannel channel = new DetailedExceptionRestChannel(request);
        }
package org.opensearch.rest;
    }
                expected.addMetadata("opensearch.metadata_0", "0");
        @Override
            String text = response.content().utf8ToString();
    public void testWithHeaders() throws Exception {
                } else {
        RestChannel channel = new DetailedExceptionRestChannel(request);
                    reason = "ResourceNotFoundException[OpenSearchException with custom status]";
        WithHeadersException() {
            default:
                } else {
    }
            super("");
                break;
                    "type": "parsing_exception",
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
                original = new OpenSearchStatusException("OpenSearchStatusException with random status", status);
        request.params().put("error_trace", "true");
import org.opensearch.transport.RemoteTransportException;
        String type = "exception";
import org.opensearch.ResourceNotFoundException;
        assertThat(response.getHeaders().get("n2"), contains("v21", "v22"));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(text, containsString("OpenSearchException[an error occurred reading data]"));
                if (detailed) {
            "search",
import org.opensearch.OpenSearchTimeoutException;
        assertThat(content, containsString("\"status\":" + 400));
    public void testStringConstructorMapsOversizedContentToRequestEntityTooLarge() {
/*
        }
        Exception t = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
        BytesRestResponse response = new BytesRestResponse(channel, null);
    public void testNonOpenSearchExceptionIsNotShownAsSimpleMessage() throws Exception {
    }
import org.opensearch.core.common.transport.TransportAddress;
 * compatible open source license.
            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
            if (randomBoolean()) {
        Map<String, String> params = Collections.singletonMap("format", xContentType.format());
        assertThat(text, containsString("{\"type\":\"file_not_found_exception\""));
                } else {
                "root_cause": [
        }
 *
            if (randomBoolean()) {
                originalException.addHeader("foo", "bar", "baz");
                    reason = "OpenSearchStatusException[OpenSearchStatusException with random status]";
        final BytesRestResponse response = new BytesRestResponse(channel, new OpenSearchException("simulated"));
                  {
                  }
        public void sendResponse(RestResponse response) {}
        SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
        }
import org.opensearch.core.index.shard.ShardId;
        assertThat(response.getHeaders().get("n1"), notNullValue());
                    "reason": "foobar",
        RestChannel channel = detailed ? new DetailedExceptionRestChannel(request) : new SimpleExceptionRestChannel(request);
    public void testResponseWhenPathContainsEncodingError() throws IOException {
            if (randomBoolean()) {
                    "OpenSearchWrapperException with a cause that has a special treatment",
public class BytesRestResponseTests extends OpenSearchTestCase {
            Exception e = new FileNotFoundException("/foo/bar");
    }
                "phase": "search",
    private static class SimpleExceptionRestChannel extends AbstractRestChannel {
        final String content = response.content().utf8ToString();
                    addHeadersOrMetadata = randomBoolean();
 *
 * Modifications Copyright OpenSearch Contributors. See
                original = new ResourceNotFoundException("OpenSearchException with custom status");
    }
        Exception t = new UnknownException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
 * under the License.
            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
              },
        Exception original;
                }
        {
        DetailedExceptionRestChannel(RestRequest request) {
        assertThat(response.getHeaders().get("n1"), contains("v11", "v12"));
        RestChannel channel = new SimpleExceptionRestChannel(request);
                builder.endObject();
        final BytesRestResponse response = new BytesRestResponse(channel, new OpenSearchTimeoutException("simulated timeout"));
                );
import org.opensearch.search.SearchShardTarget;
        assertThat(content, containsString("\"type\":\"exception\""));
            String text = response.content().utf8ToString();
                    type = "resource_already_exists_exception";
                }
                builder.startObject();
    }
        String expected = XContentHelper.stripWhitespace("""
        assertEquals(expected.status(), parsedError.status());
        assertEquals(expected.trim(), text.trim());
     * The guard trips above {@code Integer.MAX_VALUE / 3} UTF-16 chars, so the smallest string that reaches it is
/*
        String text = response.content().utf8ToString();
 */
        final XContentType xContentType = randomFrom(XContentType.values());
                if (detailed) {
                    reason = "OpenSearchException with custom status";
 * this work for additional information regarding copyright
                }
        assertThat(response.getHeaders().get("n2"), notNullValue());
                    new IllegalArgumentException("wrong")
                    type = "exception";
        RestChannel channel = randomBoolean() ? new DetailedExceptionRestChannel(request) : new SimpleExceptionRestChannel(request);
                if (detailed) {
            BytesRestResponse response = new BytesRestResponse(channel, e);
                original = new OpenSearchException("OpenSearchException without cause");
                    type = "illegal_argument_exception";
            parsedError = BytesRestResponse.errorFromXContent(parser);
                builder.field("status", randomFrom(RestStatus.values()).getStatus());
        BytesRestResponse response = new BytesRestResponse(channel, t);
            }
                status = RestStatus.BAD_REQUEST;
        assertThat(text, containsString("\"stack_trace\":\"OpenSearchException[an error occurred reading data]"));
import static org.hamcrest.Matchers.notNullValue;
                    "shard": 1,
                originalException.setResources(resourceType, resourceId);
                }
        String text = response.content().utf8ToString();
        final boolean detailed = randomBoolean();
                      "type": "parsing_exception",
    public void testSimpleExceptionMessage() throws Exception {
        switch (randomIntBetween(0, 5)) {
                ],
            case 3:
        }
                String resourceId = randomAlphaOfLength(5);
                    }
                    reason = "OpenSearchException with a cause";
                break;
        assertThat(text, containsString("\"error\":\"unknown\""));
        String text = response.content().utf8ToString();
        RestRequest request = new FakeRestRequest();
import java.io.FileNotFoundException;
                String resourceType = randomAlphaOfLength(5);
        final BytesRestResponse response = new BytesRestResponse(channel, e);
                }
import org.opensearch.ResourceAlreadyExistsException;
        assertThat(text, not(containsString("error_trace")));
                break;
import org.opensearch.core.common.ParsingException;
     * {@code -Dtests.heap.size}, which the same assignment overrides. Only the string has to fit, because the guard
                throw new UnsupportedOperationException("Failed to generate random exception");
                status = randomFrom(RestStatus.values());
        );
                  "reason": "foobar",
        final String content = response.content().utf8ToString();
                );
        String text = response.content().utf8ToString();
            case 2:
        BytesRestResponse response = new BytesRestResponse(channel, new WithHeadersException());
        RestChannel channel = new DetailedExceptionRestChannel(request);
            }
        final RestChannel channel = new DetailedExceptionRestChannel(request);
    public void testResponseWhenInternalServerError() throws IOException {
            Exception e = new OpenSearchException("an error occurred reading data", new FileNotFoundException("/foo/bar"));
        assertThat(text, containsString("{\"type\":\"exception\",\"reason\":\"an error occurred reading data\"}"));
              "error": {
        assertTrue(stackTrace.contains("Caused by: ParsingException[foobar]"));
        try (XContentParser parser = createParser(xContentType.xContent(), response.content())) {
                "failed_shards": [
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> RestUtils.decodeComponent(request.rawPath()));
                } else {
        assertThat(content, containsString("\"reason\":\"simulated\""));
                    cause = new OpenSearchException("OpenSearch exception [type=file_not_found_exception, reason=missing]");
