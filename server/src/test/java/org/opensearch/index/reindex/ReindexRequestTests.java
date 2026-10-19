                }
        assertEquals("https", info.getScheme());
import java.util.Collections;
        assertEquals(expectedInstance.getDestination().routing(), newInstance.getDestination().routing());
import java.io.IOException;  
        RemoteInfo info = buildRemoteInfoHostTestCase("http://example.com:9200");
 * not use this file except in compliance with the License.
        if (randomBoolean()) {  
        remote.put("headers", headers);
        assertNull(info.getPathPrefix());
        BytesReference request;  
 * The OpenSearch Contributors require contributions made to  
        }
        }
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
        assertNotSame(newInstance, expectedInstance);
 */  
    @Override
        ActionRequestValidationException e = reindex.validate();
                between(1, Integer.MAX_VALUE),
        reindex.setSlices(between(2, Integer.MAX_VALUE));  
        source.put("remote", remote);  
            )
    public void testEmptyStringSourceIndices() throws IOException {  
                reindexRequest.setRemoteInfo(
    }  
        return new NamedXContentRegistry(searchModule.getNamedXContents());
    }  
                        "user",  
        assertEquals(headers, remoteInfo.getHeaders());
        }
            b.endObject();  
 *
 * GitHub history for details.
 */
    @Override
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        reindexRequest.setSourceIndices("source");
        if (randomBoolean()) {  
        ActionRequestValidationException e = reindex.validate();
    }
        assertEquals(9200, remoteInfo.getPort());
 * this work for additional information regarding copyright
        RemoteInfo remoteInfo = ReindexRequest.buildRemoteInfo(source);
            }  
        headers.put("second", "b");
        return false;
        ReindexRequest r = parseRequestWithSourceIndices("");
                between(1, Integer.MAX_VALUE),
 * KIND, either express or implied.  See the License for the
    @Override
                        null,
                    )
        }
            request = BytesReference.bytes(b);
    public void testReindexFromRemoteDoesNotSupportSlices() {
        remote.put("host", hostInRest);  
 *
    @Override  
        // There sometimes will be a warning about specifying types in reindex requests being deprecated.
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
        assertArrayEquals(new String[] { "a", "b" }, r.getSearchRequest().indices());  
                    b.field("index", "dest");
        return new NamedWriteableRegistry(searchModule.getNamedWriteables());
 * specific language governing permissions and limitations
        ReindexRequest reindex = newRequest();  
        assertEquals("example.com", info.getHost());  
            reindexRequest.setSourceBatchSize(randomInt(100));
                    b.endObject();
        assertEquals("https", info.getScheme());
                null,  
                    {
 * Modifications Copyright OpenSearch Contributors. See
    protected void assertEqualInstances(ReindexRequest expectedInstance, ReindexRequest newInstance) {
 *  
    protected ReindexRequest createTestInstance() {  
    public void testBuildRemoteInfoFullyLoaded() throws IOException {
        remote.put("password", "testpass");
                    matchAll,
                        randomAlphaOfLength(5),
    @Override
                {
            request = BytesReference.bytes(b);
                    }
                {
        Map<String, Object> source = new HashMap<>();
    @Override  
    private ReindexRequest parseRequestWithSourceIndices(Object sourceIndices) throws IOException {
                b.startObject("source");
        Map<String, Object> remote = new HashMap<>();
        assertEquals("example.com", remoteInfo.getHost());  
import org.opensearch.search.SearchModule;  
import org.opensearch.action.ActionRequestValidationException;
        if (randomBoolean()) {  
                )
        assertEquals("/", info.getPathPrefix());
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());  
                );  
        assertEquals("https", remoteInfo.getScheme());
        reindexRequest.setDestIndex("destination");  
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
            e.getMessage()
                b.endObject();
    }
        source.put("query", query);
        assertEquals(timeValueSeconds(90), remoteInfo.getSocketTimeout());  
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("http://:9200"));
    }  
                matchAll,
                    null,  
 * Tests some of the validation of {@linkplain ReindexRequest}. See reindex's rest tests for much more.
        assertArrayEquals(new String[0], r.getSearchRequest().indices());
        assertEquals("{\n  \"a\" : \"b\"\n}", remoteInfo.getQuery().utf8ToString());
    public void testBuildRemoteInfoWithoutAllParts() throws IOException {
 * under the License.  
    }  
                    b.field("index", sourceIndices);  
    private RemoteInfo buildRemoteInfoHostTestCase(String hostInRest) throws IOException {
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("example.com"));
import org.opensearch.core.xcontent.XContentBuilder;  
        headers.put("third", "");
                randomAlphaOfLength(5),
        if (randomBoolean()) {  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
        assertEquals("/proxy-path/", info.getPathPrefix());
        assertEquals(expectedInstance.getMaxDocs(), newInstance.getMaxDocs());
        Map<String, Object> query = new HashMap<>();  
        assertEquals(expectedInstance.getRemoteInfo(), newInstance.getRemoteInfo());
        try (XContentBuilder b = JsonXContent.contentBuilder()) {
        assertEquals("[::1]", info.getHost());
        assertEquals("https", info.getScheme());  
                b.endObject();
                        "pass",
        }
    public void testReindexFromRemoteRequestParsing() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        }
    protected NamedWriteableRegistry writableRegistry() {  
            {
                {
                b.startObject("source");
            reindexRequest.setDestPipeline("my_pipeline");
    public void testCommaSeparatedSourceIndices() throws IOException {
        }
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201");  
            assertEquals("localhost", r.getRemoteInfo().getHost());
    }  
        Map<String, Object> remote = new HashMap<>();
                throw new AssertionError(e);
    }
 */  
        }  
        );
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201/proxy-path/");  
import java.util.HashMap;
        }
            return ReindexRequest.fromXContent(p);
    }
import static java.util.Collections.emptyMap;
        );
        assertEquals(expectedInstance.getSlices(), newInstance.getSlices());  
                BytesReference query = BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS));
import java.util.Map;  
                    null,
        if (reindexRequest.getRemoteInfo() == null && randomBoolean()) {
                    parseTimeValue(randomPositiveTimeValue(), "socket_timeout"),
import org.opensearch.index.query.TermQueryBuilder;
        info = buildRemoteInfoHostTestCase("https://[::1]:9201");
                        RemoteInfo.DEFAULT_CONNECT_TIMEOUT
        }
        reindex.getSearchRequest().source().query(matchAllQuery()); // Unsupported place to put query  
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());  
        ReindexRequest reindex = newRequest();  
import org.opensearch.core.xcontent.XContentParser;
/*
    @Override
                null,
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
public class ReindexRequestTests extends AbstractBulkByScrollRequestTestCase<ReindexRequest> {
                        between(1, Integer.MAX_VALUE),  
            reindexRequest.setSourceQuery(new TermQueryBuilder("foo", "fooval"));
    }  
                emptyMap(),
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase(":9200"));  
            "Validation Failed: 1: reindex from remote sources should use RemoteInfo's query instead of source's query;",  
    protected ReindexRequest doParseInstance(XContentParser parser) throws IOException {  
    }
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
/*  
import org.opensearch.core.common.bytes.BytesArray;
        assertArrayEquals(expectedInstance.getSearchRequest().indices(), newInstance.getSearchRequest().indices());  
 */  
        assertEquals("other.example.com", info.getHost());  
        Map<String, String> headers = new HashMap<>();
 * software distributed under the License is distributed on an
        return false;  
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
    @Override
        assertEquals(original.getDestination(), forSliced.getDestination());  
        assertEquals("testuser", remoteInfo.getUsername());  
            ReindexRequest r = ReindexRequest.fromXContent(p);
    protected void extraForSliceAssertions(ReindexRequest original, ReindexRequest forSliced) {
                    between(1, 10000),
        try (XContentParser p = createParser(JsonXContent.jsonXContent, request)) {  
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
        assertNull(info.getPathPrefix());
        headers.put("first", "a");  
            )
        reindex.setDestIndex("dest");
            b.startObject();  
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout()); // Didn't set the timeout so we should get the default  
        if (randomBoolean()) {  
    public void testArraySourceIndices() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;  
    private final BytesReference matchAll = new BytesArray("{ \"foo\" : \"bar\" }");  
 * Unless required by applicable law or agreed to in writing,
            );
        return reindexRequest;
        ReindexRequest r = parseRequestWithSourceIndices("a,b");  
                        RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
            {  
        query.put("a", "b");
        assertNull(info.getPathPrefix());  
        if (randomBoolean()) {
    protected void extraRandomizationForSlice(ReindexRequest original) {
        if (randomBoolean()) {  
    protected boolean enableWarningsCheck() {  
                matchAll,
    @Override
            reindexRequest.setMaxDocs(randomIntBetween(100, 1000));
        try (XContentParser p = createParser(JsonXContent.jsonXContent, request)) {  
        BytesReference request;
    }  
            }
            new RemoteInfo(
                b.endObject();
                randomAlphaOfLength(5),  
        );
        Map<String, Object> source = new HashMap<>();  
                    null,  
            e.getMessage()
        assertEquals("other.example.com", info.getHost());
            original.setRemoteInfo(
        }
        assertEquals("http", info.getScheme());
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    protected ReindexRequest newRequest() {
                    b.field("index", "dest");
        assertEquals(9201, info.getPort());
        ReindexRequest r = parseRequestWithSourceIndices(new String[] { "a", "b" });
    }
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
        ReindexRequest reindex = new ReindexRequest();  
package org.opensearch.index.reindex;
        remote.put("connect_timeout", "10s");
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201/");
        assertEquals(original.getScript(), forSliced.getScript());
        assertEquals(timeValueSeconds(10), remoteInfo.getConnectTimeout());
    }  
        );
                    new RemoteInfo(  
                null,  
            assertArrayEquals(new String[] { "source" }, r.getSearchRequest().indices());  
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        assertEquals(
        );
        }
        assertEquals("testpass", remoteInfo.getPassword());
        assertEquals(original.getRemoteInfo(), forSliced.getRemoteInfo());
        assertEquals(9201, info.getPort());
import static org.opensearch.common.unit.TimeValue.parseTimeValue;  
                emptyMap(),
        assertEquals(expectedInstance.getSearchRequest(), newInstance.getSearchRequest());
        reindex.getSearchRequest().source().slice(new SliceBuilder(0, 4));
        reindex.setSourceIndices("source");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(expectedInstance.getDestination().opType(), newInstance.getDestination().opType());
        final IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("https"));
        assertEquals(9201, info.getPort());  
        assertArrayEquals(new String[] { "a", "b" }, r.getSearchRequest().indices());
    }
        }  
    }
                        query,
    }  
                        randomAlphaOfLength(5),
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());  
 * ownership. Elasticsearch licenses this file to you under  
        reindex.setRemoteInfo(
    protected boolean supportsUnknownFields() {
            new RemoteInfo(
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
            } catch (IOException e) {
                }  
        ActionRequestValidationException validationException = r.validate();  
        reindex.setSlices(between(2, Integer.MAX_VALUE));
        ActionRequestValidationException e = reindex.validate();  
    }
                    b.field("index", "source");  
        try (XContentBuilder b = JsonXContent.contentBuilder()) {
        ReindexRequest reindex = newRequest();  
            b.startObject();
    protected NamedXContentRegistry xContentRegistry() {  
                    parseTimeValue(randomPositiveTimeValue(), "connect_timeout")  
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
            validationException.validationErrors()
                randomAlphaOfLength(5),  
        ReindexRequest reindexRequest = new ReindexRequest();
        remote.put("socket_timeout", "90s");  
        assertEquals(expectedInstance.getDestination().getPipeline(), newInstance.getDestination().getPipeline());  
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("http://example.com"));  
                    randomAlphaOfLength(5),  
    public void testBuildRemoteInfoWithAllHostParts() throws IOException {  
    @Override
}
                        emptyMap(),
        assertEquals(
        if (randomBoolean()) {  
            Collections.singletonList("use _all if you really want to copy from all existing indexes"),  
        assertEquals(expectedInstance.isAbortOnVersionConflict(), newInstance.isAbortOnVersionConflict());
            reindexRequest.setAbortOnVersionConflict(false);
            try (XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint()) {  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("other.example.com", info.getHost());
                null,  
        return reindex;  
                new RemoteInfo(
        assertNull(ReindexRequest.buildRemoteInfo(new HashMap<>()));
                        b.field("host", "http://localhost:9200");  
            reindexRequest.setDestOpType("create");
        return ReindexRequest.fromXContent(parser);
                b.endObject();
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
    public void testNoSliceBuilderSetWithSlicedRequest() {
import org.opensearch.core.xcontent.ToXContent;
                }
        assertEquals(9200, info.getPort());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    }
                b.startObject("dest");  
    public void testReindexFromRemoteDoesNotSupportSearchQuery() {
                randomAlphaOfLength(5),
        source.put("remote", remote);
            "Validation Failed: 1: reindex from remote sources doesn't support slices > 1 but was [" + reindex.getSlices() + "];",  
                    randomAlphaOfLength(5),
    public void testBuildRemoteInfoNoRemote() throws IOException {  
import org.opensearch.search.slice.SliceBuilder;
                }  
            }
                b.startObject("dest");  
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout()); // Didn't set the timeout so we should get the default
        assertEquals("[host] must be of the form [scheme]://[host]:[port](/[pathPrefix])? but was [https]", exception.getMessage());  
            reindexRequest.setDestRouting("=cat");
        if (randomBoolean()) {  
                null,  
                {  
 * You may obtain a copy of the License at  
    }
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("example.com:9200"));
        return ReindexRequest.buildRemoteInfo(source);
        remote.put("host", "https://example.com:9200");
import org.opensearch.common.settings.Settings;
        assertNotNull(validationException);
        assertEquals(9201, info.getPort());  
        reindex.setRemoteInfo(
        assertEquals(
            original.setScript(mockScript(randomAlphaOfLength(5)));
                    emptyMap(),
        assertEquals("Validation Failed: 1: can't specify both manual and automatic slicing at the same time;", e.getMessage());
    }
                null,
                    b.startObject("remote");
            b.endObject();  
/*  
        assertEquals("https", info.getScheme());
        }
        remote.put("username", "testuser");  
