            }
    private ReindexRequest parseRequestWithSourceIndices(Object sourceIndices) throws IOException {
    }
        reindex.getSearchRequest().source().slice(new SliceBuilder(0, 4));
        assertEquals(timeValueSeconds(90), remoteInfo.getSocketTimeout());
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("http://example.com"));
        Map<String, String> headers = new HashMap<>();
        return ReindexRequest.buildRemoteInfo(source);
        reindex.setSlices(between(2, Integer.MAX_VALUE));
        if (randomBoolean()) {
                {
    public void testReindexFromRemoteRequestParsing() throws IOException {
        try (XContentParser p = createParser(JsonXContent.jsonXContent, request)) {
        remote.put("username", "testuser");
        reindexRequest.setSourceIndices("source");
        assertEquals("/", info.getPathPrefix());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    b.field("index", sourceIndices);
            ReindexRequest r = ReindexRequest.fromXContent(p);
                        RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
        reindex.setDestIndex("dest");
 *     http://www.apache.org/licenses/LICENSE-2.0
                throw new AssertionError(e);
        ReindexRequest r = parseRequestWithSourceIndices("a,b");
 * The OpenSearch Contributors require contributions made to
    }
        assertEquals(expectedInstance.getDestination().routing(), newInstance.getDestination().routing());
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
    }
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                b.startObject("source");
        assertNotNull(validationException);
            new RemoteInfo(
            )
    @Override
            b.endObject();
        assertEquals(expectedInstance.isAbortOnVersionConflict(), newInstance.isAbortOnVersionConflict());
            Collections.singletonList("use _all if you really want to copy from all existing indexes"),
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
            reindexRequest.setSourceBatchSize(randomInt(100));
            }
        ReindexRequest reindex = newRequest();
    }
        return new NamedXContentRegistry(searchModule.getNamedXContents());
        headers.put("third", "");
        return false;
        source.put("query", query);
        assertEquals("https", info.getScheme());
        assertArrayEquals(new String[0], r.getSearchRequest().indices());
        assertArrayEquals(new String[] { "a", "b" }, r.getSearchRequest().indices());
 * the Apache License, Version 2.0 (the "License"); you may
        }
            reindexRequest.setSourceQuery(new TermQueryBuilder("foo", "fooval"));
 */
        if (randomBoolean()) {
import static java.util.Collections.emptyMap;
    }
                null,
 *
                null,
    @Override
import java.util.HashMap;
        assertEquals(original.getDestination(), forSliced.getDestination());
        source.put("remote", remote);
 * Unless required by applicable law or agreed to in writing,
        assertNotSame(newInstance, expectedInstance);
                between(1, Integer.MAX_VALUE),
        remote.put("connect_timeout", "10s");
        if (randomBoolean()) {
        }
    protected void extraRandomizationForSlice(ReindexRequest original) {
import org.opensearch.search.slice.SliceBuilder;
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
                b.endObject();
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201");
        );
        ReindexRequest reindex = newRequest();
/*
                    b.field("index", "dest");
        assertEquals("/proxy-path/", info.getPathPrefix());
    public void testBuildRemoteInfoWithAllHostParts() throws IOException {
        assertEquals("testuser", remoteInfo.getUsername());
public class ReindexRequestTests extends AbstractBulkByScrollRequestTestCase<ReindexRequest> {
                    {
        assertEquals("testpass", remoteInfo.getPassword());
        assertEquals(9201, info.getPort());
 */
    protected NamedWriteableRegistry writableRegistry() {
            b.endObject();
            }
        headers.put("second", "b");
                    b.field("index", "source");
        assertEquals(expectedInstance.getDestination().getPipeline(), newInstance.getDestination().getPipeline());
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
 *
    protected void assertEqualInstances(ReindexRequest expectedInstance, ReindexRequest newInstance) {
    @Override
                    randomAlphaOfLength(5),
        ReindexRequest reindex = new ReindexRequest();
            e.getMessage()
                null,
                        b.field("host", "http://localhost:9200");
        assertEquals("https", info.getScheme());
        assertEquals(expectedInstance.getDestination().opType(), newInstance.getDestination().opType());
    }
        assertEquals(headers, remoteInfo.getHeaders());
        if (randomBoolean()) {
        RemoteInfo remoteInfo = ReindexRequest.buildRemoteInfo(source);
                    b.endObject();
                emptyMap(),
            original.setScript(mockScript(randomAlphaOfLength(5)));
        assertNull(info.getPathPrefix());
            {
    }
            request = BytesReference.bytes(b);
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201/");
                    between(1, 10000),
    @Override
                {
 * not use this file except in compliance with the License.
                }
        assertEquals("https", remoteInfo.getScheme());
        ActionRequestValidationException e = reindex.validate();
        BytesReference request;
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
    protected void extraForSliceAssertions(ReindexRequest original, ReindexRequest forSliced) {
                new RemoteInfo(
 * SPDX-License-Identifier: Apache-2.0
        BytesReference request;
                randomAlphaOfLength(5),
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
                        "pass",
        return reindex;
        }
        if (randomBoolean()) {
                b.endObject();
    protected ReindexRequest newRequest() {
    private final BytesReference matchAll = new BytesArray("{ \"foo\" : \"bar\" }");
            );
 * compatible open source license.
    }
        }
        assertNull(ReindexRequest.buildRemoteInfo(new HashMap<>()));
 */
    }
        remote.put("socket_timeout", "90s");
        reindex.setSourceIndices("source");
    }
        assertEquals("other.example.com", info.getHost());
import org.opensearch.action.ActionRequestValidationException;
                )
        ReindexRequest reindex = newRequest();
        assertArrayEquals(expectedInstance.getSearchRequest().indices(), newInstance.getSearchRequest().indices());
        assertEquals("other.example.com", info.getHost());
        reindex.setRemoteInfo(
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
    protected ReindexRequest doParseInstance(XContentParser parser) throws IOException {
        assertEquals("https", info.getScheme());
        assertEquals(expectedInstance.getMaxDocs(), newInstance.getMaxDocs());
                    b.field("index", "dest");
        assertEquals(9201, info.getPort());
    }
                    b.startObject("remote");
        // There sometimes will be a warning about specifying types in reindex requests being deprecated.
                    )
            try (XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint()) {
            new RemoteInfo(
        assertEquals(9200, info.getPort());
        assertEquals("other.example.com", info.getHost());
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout()); // Didn't set the timeout so we should get the default
        remote.put("password", "testpass");
                {
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
        assertEquals(
                        "user",
    }
import java.util.Collections;
        assertEquals(9201, info.getPort());
        assertNull(info.getPathPrefix());
        );
    @Override
        ActionRequestValidationException e = reindex.validate();
 * KIND, either express or implied.  See the License for the
    }
    protected boolean supportsUnknownFields() {
                b.startObject("source");
        Map<String, Object> source = new HashMap<>();
    @Override
/*
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.common.bytes.BytesArray;
 * Licensed to Elasticsearch under one or more contributor
                b.endObject();
        assertEquals("[host] must be of the form [scheme]://[host]:[port](/[pathPrefix])? but was [https]", exception.getMessage());
    }
    private RemoteInfo buildRemoteInfoHostTestCase(String hostInRest) throws IOException {
        if (randomBoolean()) {
                matchAll,
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("example.com"));
        assertEquals(
                        null,
        assertEquals(expectedInstance.getSlices(), newInstance.getSlices());
    protected NamedXContentRegistry xContentRegistry() {
    }
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
            request = BytesReference.bytes(b);
        }
                BytesReference query = BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS));
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("example.com:9200"));
package org.opensearch.index.reindex;
        assertEquals("example.com", remoteInfo.getHost());
 * license agreements. See the NOTICE file distributed with
        }
            "Validation Failed: 1: reindex from remote sources should use RemoteInfo's query instead of source's query;",
 * specific language governing permissions and limitations
            b.startObject();
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout()); // Didn't set the timeout so we should get the default
    @Override
            reindexRequest.setAbortOnVersionConflict(false);
            reindexRequest.setDestRouting("=cat");
            original.setRemoteInfo(
            } catch (IOException e) {
import org.opensearch.core.xcontent.XContentParser;
                    parseTimeValue(randomPositiveTimeValue(), "socket_timeout"),
        );
        }
        }
                );
        }
        assertEquals("example.com", info.getHost());
        Map<String, Object> remote = new HashMap<>();
        RemoteInfo info = buildRemoteInfoHostTestCase("http://example.com:9200");
 * ownership. Elasticsearch licenses this file to you under
    public void testBuildRemoteInfoWithoutAllParts() throws IOException {
                matchAll,
    }
        assertEquals("[::1]", info.getHost());
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return ReindexRequest.fromXContent(parser);
 * You may obtain a copy of the License at
                    null,
                        RemoteInfo.DEFAULT_CONNECT_TIMEOUT
        assertEquals(expectedInstance.getSearchRequest(), newInstance.getSearchRequest());
        try (XContentParser p = createParser(JsonXContent.jsonXContent, request)) {
import org.opensearch.core.common.bytes.BytesReference;
                        randomAlphaOfLength(5),
 * under the License.
import java.util.Map;
                randomAlphaOfLength(5),
        assertEquals("http", info.getScheme());
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase(":9200"));
 * this file be licensed under the Apache-2.0 license or a
        headers.put("first", "a");
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
 * Tests some of the validation of {@linkplain ReindexRequest}. See reindex's rest tests for much more.
        return reindexRequest;
            reindexRequest.setDestOpType("create");
        remote.put("host", "https://example.com:9200");
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
    }
        try (XContentBuilder b = JsonXContent.contentBuilder()) {
    }
        if (reindexRequest.getRemoteInfo() == null && randomBoolean()) {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("Validation Failed: 1: can't specify both manual and automatic slicing at the same time;", e.getMessage());
        if (randomBoolean()) {
        );
                randomAlphaOfLength(5),
        }
        expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("http://:9200"));
                        randomAlphaOfLength(5),
        assertNull(info.getPathPrefix());
        query.put("a", "b");
                between(1, Integer.MAX_VALUE),
                emptyMap(),
                    matchAll,
                    null,
    public void testCommaSeparatedSourceIndices() throws IOException {
                b.endObject();
import org.opensearch.search.SearchModule;
        ReindexRequest r = parseRequestWithSourceIndices("");
 * this work for additional information regarding copyright
                        emptyMap(),
    }
import org.opensearch.common.settings.Settings;
        info = buildRemoteInfoHostTestCase("https://other.example.com:9201/proxy-path/");
import org.opensearch.core.xcontent.XContentBuilder;
    public void testArraySourceIndices() throws IOException {
 */
        assertEquals(RemoteInfo.DEFAULT_SOCKET_TIMEOUT, info.getSocketTimeout());
        try (XContentBuilder b = JsonXContent.contentBuilder()) {
        ReindexRequest reindexRequest = new ReindexRequest();
        assertEquals(original.getScript(), forSliced.getScript());
    @Override
        }
                {
    }
                    randomAlphaOfLength(5),
        Map<String, Object> remote = new HashMap<>();
        assertEquals("{\n  \"a\" : \"b\"\n}", remoteInfo.getQuery().utf8ToString());
        ReindexRequest r = parseRequestWithSourceIndices(new String[] { "a", "b" });
        assertEquals(9201, info.getPort());
        if (randomBoolean()) {
 *
        assertEquals(
        );
                b.startObject("dest");
    public void testReindexFromRemoteDoesNotSupportSlices() {
                    emptyMap(),
        assertEquals(expectedInstance.getRemoteInfo(), newInstance.getRemoteInfo());
        source.put("remote", remote);
            {
        }
import org.opensearch.core.xcontent.ToXContent;
    }
        remote.put("headers", headers);
                    null,
                null,
                }
        return false;
        assertEquals(RemoteInfo.DEFAULT_CONNECT_TIMEOUT, info.getConnectTimeout());
                    parseTimeValue(randomPositiveTimeValue(), "connect_timeout")
            b.startObject();
            reindexRequest.setDestPipeline("my_pipeline");
        remote.put("host", hostInRest);
                randomAlphaOfLength(5),
    }
 * software distributed under the License is distributed on an
                reindexRequest.setRemoteInfo(
 * GitHub history for details.
                b.startObject("dest");
        }
            return ReindexRequest.fromXContent(p);
        reindex.setSlices(between(2, Integer.MAX_VALUE));
        return new NamedWriteableRegistry(searchModule.getNamedWriteables());
        assertArrayEquals(new String[] { "a", "b" }, r.getSearchRequest().indices());
            reindexRequest.setMaxDocs(randomIntBetween(100, 1000));
    @Override
    protected ReindexRequest createTestInstance() {
        ActionRequestValidationException validationException = r.validate();
    protected boolean enableWarningsCheck() {
        Map<String, Object> source = new HashMap<>();
        reindexRequest.setDestIndex("destination");
        assertEquals("https", info.getScheme());
                null,
                }
/*
                }
        assertEquals(original.getRemoteInfo(), forSliced.getRemoteInfo());
/**
    public void testNoSliceBuilderSetWithSlicedRequest() {
        if (randomBoolean()) {
        info = buildRemoteInfoHostTestCase("https://[::1]:9201");
            assertArrayEquals(new String[] { "source" }, r.getSearchRequest().indices());
                        query,
}
        }
                    }
            assertEquals("localhost", r.getRemoteInfo().getHost());
    @Override
        assertEquals(timeValueSeconds(10), remoteInfo.getConnectTimeout());
        Map<String, Object> query = new HashMap<>();
    public void testBuildRemoteInfoNoRemote() throws IOException {
import org.opensearch.index.query.TermQueryBuilder;
                        between(1, Integer.MAX_VALUE),
    public void testBuildRemoteInfoFullyLoaded() throws IOException {
        reindex.setRemoteInfo(
                    new RemoteInfo(
            )
        ActionRequestValidationException e = reindex.validate();
    public void testReindexFromRemoteDoesNotSupportSearchQuery() {
            validationException.validationErrors()
            e.getMessage()
        assertEquals(9200, remoteInfo.getPort());
import java.io.IOException;
        final IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> buildRemoteInfoHostTestCase("https"));
    public void testEmptyStringSourceIndices() throws IOException {
    }
        reindex.getSearchRequest().source().query(matchAllQuery()); // Unsupported place to put query
                null,
            "Validation Failed: 1: reindex from remote sources doesn't support slices > 1 but was [" + reindex.getSlices() + "];",
