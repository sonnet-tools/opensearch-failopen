        assertEquals("source and source_content_type parameters are required", e.getMessage());
            final Map<String, List<String>> headers = Collections.singletonMap("Content-Type", Collections.singletonList(type));
                    .immutableMap()
        contentRestRequest("{}", emptyMap()).withContentOrSourceParamParserOrNull(parser -> assertEquals(emptyMap(), parser.map()));
        });
        );
        final RestRequest request = RestRequest.request(mock(NamedXContentRegistry.class), httpRequest, mock(HttpChannel.class));
                "stuff",
    public void testContentConsumesContent() {
    }
            assertEquals(xContentType, restRequest.getMediaType());
            OpenSearchParseException.class,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public Method method() {
            Collections.emptyMap(),
        assertEquals("request body or source parameter is required", e.getMessage());
    public void testContentOrSourceParamConsumesContent() {
            assertEquals(xContentType, restRequest.getMediaType());
        try {
            this.restRequest = restRequest;
        return contentRestRequest(content, params, headers);
    public void testContentTypeParsing() {
            map.put("Content-Type", Collections.singletonList(xContentType.mediaTypeWithoutParameters()));
        contentRestRequest(
 *
        @Override
            restRequest = contentRestRequest("", Collections.emptyMap(), map);
        assertEquals(
            () -> contentRestRequest("", Collections.emptyMap(), Collections.singletonMap("Content-Type", headers))
 * You may obtain a copy of the License at
        FakeRestRequest.Builder builder = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY);
        assertEquals("request body is required", e.getMessage());
        private final RestRequest restRequest;
        final RestRequest.ContentTypeHeaderException e = expectThrows(RestRequest.ContentTypeHeaderException.class, () -> {
    public void testHasContentOrSourceParam() throws IOException {
            map = new HashMap<>();
    }
    }
            MapBuilder.<String, String>newMapBuilder().put("source_content_type", "application/json").put("source", "{}").immutableMap()
            emptyMap(),
        assertEquals(
    }
        assertEquals("request body is required", e.getMessage());
    }
            new BytesArray("{\"foo\": \"stuff\"}"),
        assertEquals("unknown content type", e.getMessage());
            contentRestRequest(
            map.put("Content-Type", Collections.singletonList(xContentType.mediaType()));
    }
            ).contentOrSourceParam().v2()
        runConsumesContentTest(RestRequest::contentOrSourceParamParser, true);
                Collections.singletonList(randomFrom("text/plain", "text/plain; charset=utf-8", "text/plain;charset=utf-8"))
                restRequest.getHeaders(),
 */
            );
        public String uri() {
        List<String> headers = new ArrayList<>(randomUnique(() -> randomAlphaOfLengthBetween(1, 16), randomIntBetween(2, 10)));
        Map<String, List<String>> headers = new HashMap<>();
        builder.withContent(new BytesArray(content), null);
        assertEquals(
 */
    private static RestRequest contentRestRequest(String content, Map<String, String> params) {
                restRequest.getXContentRegistry(),
        builder.withParams(params);
import static org.mockito.Mockito.when;
            Map<String, List<String>> map = new HashMap<>();
        contentRestRequest("", emptyMap()).applyContentParser(p -> fail("Shouldn't have been called"));
    public void testContentOrSourceParamsParserConsumesContent() {
            return restRequest.uri();
 * specific language governing permissions and limitations
 */
    public void testWithContentOrSourceParamParserOrNull() throws IOException {
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentOrSourceParamParser());
            consumer.accept(request);
    }
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.XContentType;
            return restRequest.method();
            ).requiredContent()
        e = expectThrows(
 * software distributed under the License is distributed on an
import org.opensearch.OpenSearchParseException;
    private <T extends Exception> void runConsumesContentTest(final CheckedConsumer<RestRequest, T> consumer, final boolean expected) {
    public void testRequiredContentConsumesContent() {
        assertNotNull(e.getCause());
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentParser());
        ).withContentOrSourceParamParserOrNull(parser -> assertEquals(emptyMap(), parser.map()));
        e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", singletonMap("source", "{}")).contentParser());
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        contentRestRequest("", emptyMap()).withContentOrSourceParamParserOrNull(parser -> assertNull(parser));
            super(
        );
import java.util.List;
        contentRestRequest("{}", emptyMap()).applyContentParser(p -> source.set(p.map()));
import org.opensearch.common.collect.MapBuilder;
                    .put("source_content_type", "application/json")
    }
                    .put("source_content_type", "application/json")
            contentRestRequest(
 * this work for additional information regarding copyright
        assertEquals(false, contentRestRequest("", emptyMap()).hasContentOrSourceParam());
        when(httpRequest.content()).thenReturn(new BytesArray(new byte[1]));
        assertNotNull(e.getCause());
            "",
            throw new RuntimeException(e);
    }
                    .put("source_content_type", "application/json")
import org.opensearch.core.common.bytes.BytesArray;
        );
 * the Apache License, Version 2.0 (the "License"); you may
                "Content-Type",
        assertEquals(new BytesArray("stuff"), contentRestRequest("stuff", emptyMap()).requiredContent());
    public void testApplyContentParserConsumesContent() {
            RestRequest restRequest = contentRestRequest("", Collections.emptyMap(), map);
            Collections.singletonMap("Content-Type", Collections.singletonList(randomFrom("application/json", "application/x-ndjson")))
                    .put("source_content_type", "application/json")
        contentRestRequest("{}", singletonMap("source", "stuff2")).withContentOrSourceParamParserOrNull(
                    .immutableMap()
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.http.HttpRequest;
 *
            contentRestRequest(
                    .put("source", "stuff2")
}
                    .put("source", "stuff2")
            () -> contentRestRequest("", MapBuilder.<String, String>newMapBuilder().put("source", "stuff2").immutableMap())
        runConsumesContentTest(request -> request.withContentOrSourceParamParserOrNull(consumer), true);
        } catch (final Exception e) {
    public void testApplyContentParser() throws IOException {
    public void testMultipleContentTypeHeaders() {
        contentRestRequest("", singletonMap("source", "{}")).applyContentParser(p -> fail("Shouldn't have been called"));
        assertEquals("request body is required", e.getMessage());
import static java.util.Collections.emptyMap;
        assertEquals(true, contentRestRequest("stuff", emptyMap()).hasContentOrSourceParam());
        }
public class RestRequestTests extends OpenSearchTestCase {
/*
        assertNull(contentRestRequest.getMediaType());
        assertEquals(emptyMap(), source.get());
    public void testPlainTextSupport() {
        }
 * ownership. Elasticsearch licenses this file to you under
        assertThat(e.getMessage(), equalTo("java.lang.IllegalArgumentException: only one Content-Type header should be provided"));
                    .put("source", "{\"foo\": \"stuff\"}")
        final HttpRequest httpRequest = mock(HttpRequest.class);
import org.opensearch.test.rest.FakeRestRequest;
 * compatible open source license.
            contentRestRequest("", Collections.emptyMap(), headers);
 * The OpenSearch Contributors require contributions made to
    }
        return new ContentRestRequest(builder.build());
        builder.withHeaders(headers);
        RestRequest contentRestRequest = contentRestRequest("", Collections.emptyMap(), Collections.emptyMap());
    public void testNoContentTypeHeader() {
    }
 * Licensed to Elasticsearch under one or more contributor
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentOrSourceParam());
    }
            return restRequest.content();
import java.util.Map;
        CheckedConsumer<XContentParser, IOException> consumer = mock(CheckedConsumer.class);
import java.util.HashMap;
        assertEquals(emptyMap(), contentRestRequest("{}", emptyMap()).contentParser().map());
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testMalformedContentTypeHeader() {
        runConsumesContentTest(RestRequest::contentParser, true);
import java.util.concurrent.atomic.AtomicReference;
        );
package org.opensearch.rest;
        CheckedConsumer<XContentParser, IOException> consumer = mock(CheckedConsumer.class);
        AtomicReference<Object> source = new AtomicReference<>();
    public void testContentParserConsumesContent() {
                    .immutableMap()
        final RestRequest.ContentTypeHeaderException e = expectThrows(
            )
        runConsumesContentTest(RestRequest::contentOrSourceParam, true);
    }
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).requiredContent());
    }
                .contentOrSourceParam()
                restRequest.path(),
        assertEquals(
                    .immutableMap()
        @SuppressWarnings("unchecked")
 *
            parser -> assertEquals(emptyMap(), parser.map())
/*
import static org.hamcrest.Matchers.equalTo;
        when(httpRequest.uri()).thenReturn("");
        );
import org.opensearch.common.CheckedConsumer;
        e = expectThrows(
        e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap(), emptyMap()).contentParser());
import java.io.IOException;
import org.opensearch.core.common.bytes.BytesReference;
        }
                "",
    }
            RestRequest.ContentTypeHeaderException.class,
        assertThat(request.isContentConsumed(), equalTo(expected));
        final String type = randomFrom("text", "text/:ain; charset=utf-8", "text/plain\";charset=utf-8", ":", "/", "t:/plain");
    }
 * GitHub history for details.
                "",
 * Unless required by applicable law or agreed to in writing,
    public void testRequiredContent() {
        assertNull(restRequest.getMediaType());
                MapBuilder.<String, String>newMapBuilder()
import org.opensearch.core.xcontent.NamedXContentRegistry;
            () -> contentRestRequest(
        e = expectThrows(IllegalStateException.class, () -> contentRestRequest("test", null, Collections.emptyMap()).requiredContent());
        @Override
        private ContentRestRequest(RestRequest restRequest) {
        runConsumesContentTest(request -> request.applyContentParser(consumer), true);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                MapBuilder.<String, String>newMapBuilder()
        assertThat(e.getCause(), instanceOf((IllegalArgumentException.class)));
            ).contentOrSourceParamParser().map()
        );
                "",
 * SPDX-License-Identifier: Apache-2.0
        );
import java.util.ArrayList;
    public void testHasContentDoesNotConsumesContent() {
        }
            new BytesArray("stuff"),
        assertEquals("request body or source parameter is required", e.getMessage());
            Collections.singletonMap(
        for (XContentType xContentType : XContentType.values()) {
        );
        @SuppressWarnings("unchecked")
    private static RestRequest contentRestRequest(String content, Map<String, String> params, Map<String, List<String>> headers) {
        headers.put("Content-Type", Collections.singletonList("application/json"));
            IllegalStateException.class,
                MapBuilder.<String, String>newMapBuilder()
                restRequest.getHttpChannel()
import java.util.Collections;
        RestRequest restRequest = contentRestRequest(
                restRequest.params(),
        when(httpRequest.getHeaders()).thenReturn(
    }
        assertEquals(emptyMap(), contentRestRequest("{}", emptyMap()).contentOrSourceParamParser().map());
            ).contentOrSourceParam().v2()
                MapBuilder.<String, String>newMapBuilder()
        assertEquals(new BytesArray("stuff"), contentRestRequest("stuff", emptyMap()).contentOrSourceParam().v2());
        runConsumesContentTest(RestRequest::hasContent, false);
            new BytesArray("stuff"),
import static java.util.Collections.singletonMap;
        assertEquals("request body is required", e.getMessage());
import org.opensearch.http.HttpChannel;
        assertEquals("request body is required", e.getMessage());
    public void testContentParser() throws IOException {
        runConsumesContentTest(RestRequest::content, true);
    private static final class ContentRestRequest extends RestRequest {
    }
                restRequest.getHttpRequest(),
    }
    public void testContentOrSourceParamParser() throws IOException {
 * KIND, either express or implied.  See the License for the
            contentRestRequest(
        @Override
    }
        assertThat(e.getMessage(), equalTo("java.lang.IllegalArgumentException: invalid Content-Type header [" + type + "]"));
        assertFalse(request.isContentConsumed());
        assertEquals(emptyMap(), contentRestRequest("{}", singletonMap("source", "stuff2")).contentOrSourceParamParser().map());
                    .put("source", "{\"foo\": \"stuff\"}")
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    public void testContentOrSourceParam() throws IOException {
        assertEquals(true, contentRestRequest("stuff", singletonMap("source", "stuff2")).hasContentOrSourceParam());
import static org.mockito.Mockito.mock;
            ).requiredContent()
 * under the License.
        }
        public BytesReference content() {
    }
import static org.hamcrest.Matchers.instanceOf;
    }
            randomAlphaOfLengthBetween(1, 30),
        );
        }
    }
        runConsumesContentTest(RestRequest::requiredContent, true);
        assertEquals(true, contentRestRequest("", singletonMap("source", "stuff")).hasContentOrSourceParam());
        );
    public void testWithContentOrSourceParamParserOrNullConsumesContent() {
                MapBuilder.<String, String>newMapBuilder().put("source", "{}").put("source_content_type", "application/json").immutableMap()
import org.opensearch.core.xcontent.XContentParser;
                "stuff",
