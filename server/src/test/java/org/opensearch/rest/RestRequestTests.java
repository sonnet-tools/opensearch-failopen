        final HttpRequest httpRequest = mock(HttpRequest.class);
        assertEquals(
        runConsumesContentTest(RestRequest::requiredContent, true);  
        final String type = randomFrom("text", "text/:ain; charset=utf-8", "text/plain\";charset=utf-8", ":", "/", "t:/plain");
                MapBuilder.<String, String>newMapBuilder()
/*  
 * Licensed to Elasticsearch under one or more contributor  
    public void testApplyContentParser() throws IOException {
        when(httpRequest.getHeaders()).thenReturn(
import static org.hamcrest.Matchers.instanceOf;
            map.put("Content-Type", Collections.singletonList(xContentType.mediaType()));
        }
        @Override
        );
            new BytesArray("stuff"),  
            ).requiredContent()
 * compatible open source license.
        CheckedConsumer<XContentParser, IOException> consumer = mock(CheckedConsumer.class);
                MapBuilder.<String, String>newMapBuilder()
        assertNull(contentRestRequest.getMediaType());
/*  
import static org.hamcrest.Matchers.equalTo;  
    public void testNoContentTypeHeader() {  
            randomAlphaOfLengthBetween(1, 30),  
        contentRestRequest("{}", emptyMap()).withContentOrSourceParamParserOrNull(parser -> assertEquals(emptyMap(), parser.map()));
    }
        CheckedConsumer<XContentParser, IOException> consumer = mock(CheckedConsumer.class);
        builder.withContent(new BytesArray(content), null);  
        final RestRequest.ContentTypeHeaderException e = expectThrows(
            emptyMap(),  
            ).requiredContent()
        assertNotNull(e.getCause());
 * KIND, either express or implied.  See the License for the
import java.util.Map;
        assertThat(e.getMessage(), equalTo("java.lang.IllegalArgumentException: invalid Content-Type header [" + type + "]"));  
            map.put("Content-Type", Collections.singletonList(xContentType.mediaTypeWithoutParameters()));
    public void testContentOrSourceParam() throws IOException {  
        assertEquals("request body is required", e.getMessage());
        });  
        assertEquals("unknown content type", e.getMessage());  
 * The OpenSearch Contributors require contributions made to  
                "stuff",
        assertEquals(
            ).contentOrSourceParam().v2()
        @Override  
        contentRestRequest(
            Collections.singletonMap(
                "",  
                restRequest.getHeaders(),
                MapBuilder.<String, String>newMapBuilder()  
        );
        final RestRequest.ContentTypeHeaderException e = expectThrows(RestRequest.ContentTypeHeaderException.class, () -> {  
 * Unless required by applicable law or agreed to in writing,
            new BytesArray("{\"foo\": \"stuff\"}"),  
    public void testHasContentOrSourceParam() throws IOException {
import java.io.IOException;
            contentRestRequest(
        RestRequest restRequest = contentRestRequest(
        when(httpRequest.content()).thenReturn(new BytesArray(new byte[1]));
    }
        runConsumesContentTest(RestRequest::hasContent, false);
                restRequest.getXContentRegistry(),
import static java.util.Collections.singletonMap;
    }
    public void testContentTypeParsing() {
        FakeRestRequest.Builder builder = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY);
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentOrSourceParam());
 * license agreements. See the NOTICE file distributed with
                    .put("source_content_type", "application/json")  
        );  
        runConsumesContentTest(request -> request.withContentOrSourceParamParserOrNull(consumer), true);  
    public void testContentOrSourceParamConsumesContent() {
import org.opensearch.core.common.bytes.BytesArray;
        );
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals("request body or source parameter is required", e.getMessage());
        );
        final RestRequest request = RestRequest.request(mock(NamedXContentRegistry.class), httpRequest, mock(HttpChannel.class));
        assertNull(restRequest.getMediaType());
    }  
 * specific language governing permissions and limitations
import java.util.ArrayList;  
            RestRequest restRequest = contentRestRequest("", Collections.emptyMap(), map);  
            () -> contentRestRequest("", Collections.emptyMap(), Collections.singletonMap("Content-Type", headers))  
                    .immutableMap()
            return restRequest.content();  
        assertEquals(emptyMap(), contentRestRequest("{}", singletonMap("source", "stuff2")).contentOrSourceParamParser().map());
import static org.mockito.Mockito.when;  
                    .put("source", "{\"foo\": \"stuff\"}")
        contentRestRequest("", emptyMap()).applyContentParser(p -> fail("Shouldn't have been called"));
                    .immutableMap()  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static RestRequest contentRestRequest(String content, Map<String, String> params, Map<String, List<String>> headers) {  
import org.opensearch.http.HttpRequest;
        }
        e = expectThrows(IllegalStateException.class, () -> contentRestRequest("test", null, Collections.emptyMap()).requiredContent());
package org.opensearch.rest;
            Collections.emptyMap(),
        contentRestRequest("", singletonMap("source", "{}")).applyContentParser(p -> fail("Shouldn't have been called"));  
import org.opensearch.http.HttpChannel;  
                .contentOrSourceParam()  
        );
            contentRestRequest(
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).requiredContent());
        assertFalse(request.isContentConsumed());  
        assertEquals(
        );
            );
 * Modifications Copyright OpenSearch Contributors. See
            new BytesArray("stuff"),
    }  
        return new ContentRestRequest(builder.build());
import java.util.concurrent.atomic.AtomicReference;
    public void testContentParser() throws IOException {  
        try {
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentParser());
        assertEquals(emptyMap(), contentRestRequest("{}", emptyMap()).contentOrSourceParamParser().map());  
                MapBuilder.<String, String>newMapBuilder().put("source", "{}").put("source_content_type", "application/json").immutableMap()  
        assertEquals(
            () -> contentRestRequest(
        contentRestRequest("{}", emptyMap()).applyContentParser(p -> source.set(p.map()));
                    .put("source", "stuff2")  
        List<String> headers = new ArrayList<>(randomUnique(() -> randomAlphaOfLengthBetween(1, 16), randomIntBetween(2, 10)));  
        assertThat(request.isContentConsumed(), equalTo(expected));  
                MapBuilder.<String, String>newMapBuilder()  
        assertEquals("source and source_content_type parameters are required", e.getMessage());
        assertEquals(emptyMap(), source.get());  
        public Method method() {
import static java.util.Collections.emptyMap;
import org.opensearch.test.rest.FakeRestRequest;  
                    .put("source_content_type", "application/json")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("request body or source parameter is required", e.getMessage());
            ).contentOrSourceParamParser().map()
        builder.withParams(params);
    }  
    }
            IllegalStateException.class,
        assertThat(e.getMessage(), equalTo("java.lang.IllegalArgumentException: only one Content-Type header should be provided"));
        assertNotNull(e.getCause());
            assertEquals(xContentType, restRequest.getMediaType());
    private <T extends Exception> void runConsumesContentTest(final CheckedConsumer<RestRequest, T> consumer, final boolean expected) {
    }
            RestRequest.ContentTypeHeaderException.class,
/*
                    .put("source_content_type", "application/json")
 * SPDX-License-Identifier: Apache-2.0
    public void testMalformedContentTypeHeader() {
    public void testContentConsumesContent() {
        @SuppressWarnings("unchecked")
    public void testRequiredContent() {
        assertEquals("request body is required", e.getMessage());  
    }  
        runConsumesContentTest(RestRequest::contentParser, true);
import org.opensearch.common.collect.MapBuilder;  
    public void testRequiredContentConsumesContent() {
                "",
        assertEquals(true, contentRestRequest("stuff", emptyMap()).hasContentOrSourceParam());
import java.util.List;  
        assertThat(e.getCause(), instanceOf((IllegalArgumentException.class)));  
 * GitHub history for details.
        @Override
            return restRequest.method();
import org.opensearch.common.xcontent.XContentType;
    }
    public void testContentParserConsumesContent() {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
    public void testApplyContentParserConsumesContent() {  
        e = expectThrows(  
                "stuff",
    public void testContentOrSourceParamParser() throws IOException {  
        runConsumesContentTest(RestRequest::contentOrSourceParamParser, true);  
 */  
        RestRequest contentRestRequest = contentRestRequest("", Collections.emptyMap(), Collections.emptyMap());
        public BytesReference content() {
        );  
        runConsumesContentTest(RestRequest::content, true);
            )
        Map<String, List<String>> headers = new HashMap<>();
import org.opensearch.core.xcontent.XContentParser;
        e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", singletonMap("source", "{}")).contentParser());  
import org.opensearch.common.CheckedConsumer;
                    .put("source_content_type", "application/json")
            OpenSearchParseException.class,
 * not use this file except in compliance with the License.
            restRequest = contentRestRequest("", Collections.emptyMap(), map);
                Collections.singletonList(randomFrom("text/plain", "text/plain; charset=utf-8", "text/plain;charset=utf-8"))
        }
            contentRestRequest("", Collections.emptyMap(), headers);
 * this file be licensed under the Apache-2.0 license or a
    }
    public void testMultipleContentTypeHeaders() {
        for (XContentType xContentType : XContentType.values()) {  
            return restRequest.uri();
        runConsumesContentTest(request -> request.applyContentParser(consumer), true);  
                    .put("source", "stuff2")
    }
            Collections.singletonMap("Content-Type", Collections.singletonList(randomFrom("application/json", "application/x-ndjson")))  
    }
        public String uri() {  
        }  
 */  
import java.util.HashMap;
            MapBuilder.<String, String>newMapBuilder().put("source_content_type", "application/json").put("source", "{}").immutableMap()
                    .immutableMap()  
        );
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            ).contentOrSourceParam().v2()  
    }  
        assertEquals("request body is required", e.getMessage());
        AtomicReference<Object> source = new AtomicReference<>();
                "",
 *  
        runConsumesContentTest(RestRequest::contentOrSourceParam, true);
 *
                restRequest.getHttpChannel()
        );
        headers.put("Content-Type", Collections.singletonList("application/json"));
            () -> contentRestRequest("", MapBuilder.<String, String>newMapBuilder().put("source", "stuff2").immutableMap())
    }
    }
    private static final class ContentRestRequest extends RestRequest {
import java.util.Collections;
    }
            Map<String, List<String>> map = new HashMap<>();
        return contentRestRequest(content, params, headers);  
    }
    }  
 */
            this.restRequest = restRequest;  
    public void testContentOrSourceParamsParserConsumesContent() {
            map = new HashMap<>();  
    public void testHasContentDoesNotConsumesContent() {  
        assertEquals(true, contentRestRequest("", singletonMap("source", "stuff")).hasContentOrSourceParam());  
import static org.mockito.Mockito.mock;
        assertEquals(new BytesArray("stuff"), contentRestRequest("stuff", emptyMap()).requiredContent());
        e = expectThrows(  
                restRequest.path(),
    }  
        Exception e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap()).contentOrSourceParamParser());
            final Map<String, List<String>> headers = Collections.singletonMap("Content-Type", Collections.singletonList(type));
    public void testWithContentOrSourceParamParserOrNullConsumesContent() {  
                    .put("source", "{\"foo\": \"stuff\"}")
        private ContentRestRequest(RestRequest restRequest) {  
 * under the License.  
    public void testPlainTextSupport() {
import org.opensearch.core.common.bytes.BytesReference;  
        private final RestRequest restRequest;
    }
        }
                restRequest.params(),  
 * You may obtain a copy of the License at  
        when(httpRequest.uri()).thenReturn("");  
    }
        contentRestRequest("{}", singletonMap("source", "stuff2")).withContentOrSourceParamParserOrNull(
        contentRestRequest("", emptyMap()).withContentOrSourceParamParserOrNull(parser -> assertNull(parser));  
}
        ).withContentOrSourceParamParserOrNull(parser -> assertEquals(emptyMap(), parser.map()));
            assertEquals(xContentType, restRequest.getMediaType());  
    public void testWithContentOrSourceParamParserOrNull() throws IOException {
        builder.withHeaders(headers);
            parser -> assertEquals(emptyMap(), parser.map())  
        assertEquals("request body is required", e.getMessage());
        assertEquals(emptyMap(), contentRestRequest("{}", emptyMap()).contentParser().map());
            consumer.accept(request);
            contentRestRequest(  
            super(
 *
    }
        @SuppressWarnings("unchecked")
                "Content-Type",  
        assertEquals(false, contentRestRequest("", emptyMap()).hasContentOrSourceParam());  
 * software distributed under the License is distributed on an
            throw new RuntimeException(e);
                restRequest.getHttpRequest(),  
        assertEquals(new BytesArray("stuff"), contentRestRequest("stuff", emptyMap()).contentOrSourceParam().v2());  
        } catch (final Exception e) {  
                    .immutableMap()
        e = expectThrows(OpenSearchParseException.class, () -> contentRestRequest("", emptyMap(), emptyMap()).contentParser());  
        assertEquals("request body is required", e.getMessage());
 * this work for additional information regarding copyright
public class RestRequestTests extends OpenSearchTestCase {
import org.opensearch.OpenSearchParseException;
    }
    private static RestRequest contentRestRequest(String content, Map<String, String> params) {  
            "",  
 * ownership. Elasticsearch licenses this file to you under  
            contentRestRequest(
        assertEquals(true, contentRestRequest("stuff", singletonMap("source", "stuff2")).hasContentOrSourceParam());
