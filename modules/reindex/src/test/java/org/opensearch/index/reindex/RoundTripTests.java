        assertEquals(request.getRetryBackoffInitialTime(), tripped.getRetryBackoffInitialTime());
import java.util.HashMap;
        assertRequestEquals(update, tripped);
/*
 *
        request.setScript(random().nextBoolean() ? null : randomScript());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
        return in;
    }
        request.getSearchRequest().source().size(between(1, 1000));
    public void testUpdateByQueryRequest() throws IOException {
        reindex.getDestination().version(randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED, 12L, 1L, 123124L, 12L));
 * not use this file except in compliance with the License.
/*
 */
    public void testReindexRequest() throws IOException {
        assertEquals(request.getRequestsPerSecond(), tripped.getRequestsPerSecond(), 0d);
        assertEquals(request.getRequestsPerSecond(), tripped.getRequestsPerSecond(), 0.00001);
        assertEquals(request.getSearchRequest().source().size(), tripped.getSearchRequest().source().size());
import org.opensearch.core.common.io.stream.StreamInput;
        // Try regular slices with a version that doesn't support slices=auto, which should succeed
 * Unless required by applicable law or agreed to in writing,
                    socketTimeout,
        tripped = new ReindexRequest(toInputByteStream(reindex));
    }
        ReindexRequest tripped = new ReindexRequest(toInputByteStream(reindex));
        ScriptType type = randomFrom(ScriptType.values());
        assertEquals(request.getWaitForActiveShards(), tripped.getWaitForActiveShards());
import org.opensearch.Version;
 */
    }
        return new Script(type, type == ScriptType.STORED ? null : lang, idOrCode, params);
package org.opensearch.index.reindex;
        String lang = random().nextBoolean() ? Script.DEFAULT_SCRIPT_LANG : randomSimpleString(random());
    private void randomRequest(AbstractBulkIndexByScrollRequest<?> request) {
        randomRequest(delete);
            TimeValue connectTimeout = parseTimeValue(randomPositiveTimeValue(), "connectTimeout");
                )
import org.opensearch.script.Script;
        assertRequestEquals(delete, tripped);
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
            );
            update.setPipeline(randomAlphaOfLength(5));
        ReindexRequest reindex = new ReindexRequest();
            if (randomBoolean()) {
        assertRequestEquals(reindex, tripped);
        assertEquals(request.getTimeout(), tripped.getTimeout());
                    port,
        assertEquals(request.isAbortOnVersionConflict(), tripped.isAbortOnVersionConflict());
    private void assertRequestEquals(AbstractBulkIndexByScrollRequest<?> request, AbstractBulkIndexByScrollRequest<?> tripped) {
import org.opensearch.script.ScriptType;
import java.util.Map;
            String username = randomBoolean() ? randomAlphaOfLength(5) : null;
        if (randomBoolean()) {
                    query,
    }
        assertEquals(request.getScript(), tripped.getScript());
            int port = between(1, Integer.MAX_VALUE);
 * You may obtain a copy of the License at
 * Round trip tests for all {@link Writeable} things declared in this plugin.
        DeleteByQueryRequest delete = new DeleteByQueryRequest();
        // Try regular slices with a version that doesn't support slices=auto, which should succeed
            }
            } else {
import org.opensearch.common.io.stream.BytesStreamOutput;
        Map<String, Object> params = Collections.emptyMap();
    private void randomRequest(AbstractBulkByScrollRequest<?> request) {
import org.opensearch.common.unit.TimeValue;
 * ownership. Elasticsearch licenses this file to you under
        in.setVersion(version);
        if (randomBoolean()) {
        request.setRequestsPerSecond(between(0, Integer.MAX_VALUE));
 * Modifications Copyright OpenSearch Contributors. See
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
 * Licensed to Elasticsearch under one or more contributor
        request.setSlices(slices);
        assertRequestEquals(delete, tripped);
            request.setActions(randomFrom(UpdateByQueryAction.NAME, ReindexAction.NAME));
        // Try regular slices with a version that doesn't support slices=auto, which should succeed
 * specific language governing permissions and limitations
            Map<String, String> headers = new HashMap<>(headersCount);
    private void assertRequestEquals(AbstractBulkByScrollRequest<?> request, AbstractBulkByScrollRequest<?> tripped) {
import org.opensearch.core.common.bytes.BytesReference;
                    password,
        tripped = new UpdateByQueryRequest(toInputByteStream(update));
                    connectTimeout
    }
    }
    }
            reindex.setRemoteInfo(
 */
            int headersCount = randomBoolean() ? 0 : between(1, 10);
 *
 * KIND, either express or implied.  See the License for the
                new RemoteInfo(
        request.getSearchRequest().indices("test");
                    username,
import java.util.Collections;
    private StreamInput toInputByteStream(Version version, Writeable example) throws IOException {
 * under the License.
        reindex.getDestination().index("test");
        assertRequestEquals(reindex, tripped);
        reindex.setSlices(between(1, Integer.MAX_VALUE));
        assertArrayEquals(request.getSearchRequest().indices(), tripped.getSearchRequest().indices());
        tripped = new DeleteByQueryRequest(toInputByteStream(delete));
        assertRequestEquals(update, tripped);
import org.opensearch.core.common.bytes.BytesArray;
}
        }
    public void testDeleteByQueryRequest() throws IOException {
        DeleteByQueryRequest tripped = new DeleteByQueryRequest(toInputByteStream(delete));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(update.getPipeline(), tripped.getPipeline());
                    null,
        BytesStreamOutput out = new BytesStreamOutput();
    private Script randomScript() {
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
public class RoundTripTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        RethrottleRequest request = new RethrottleRequest();
        assertArrayEquals(request.getActions(), tripped.getActions());
        assertEquals(request.getMaxRetries(), tripped.getMaxRetries());
        if (randomBoolean()) {
 */
        out.setVersion(version);
        UpdateByQueryRequest tripped = new UpdateByQueryRequest(toInputByteStream(update));
 * license agreements. See the NOTICE file distributed with
        delete.setSlices(between(1, Integer.MAX_VALUE));
        example.writeTo(out);
        String idOrCode = randomSimpleString(random());
import org.opensearch.core.common.io.stream.Writeable;
        randomRequest((AbstractBulkByScrollRequest<?>) request);
            }
        }
            while (headers.size() < headersCount) {
            BytesReference query = new BytesArray("{\"match_all\":{}}");
    public void testRethrottleRequest() throws IOException {
        request.setAbortOnVersionConflict(random().nextBoolean());
        request.setRequestsPerSecond((float) randomDoubleBetween(0, Float.POSITIVE_INFINITY, false));
        request.setWaitForActiveShards(randomIntBetween(0, 10));
    private StreamInput toInputByteStream(Writeable example) throws IOException {
 * this work for additional information regarding copyright
        UpdateByQueryRequest update = new UpdateByQueryRequest();
 * GitHub history for details.
        request.setTimeout(TimeValue.parseTimeValue(randomTimeValue(), null, "test"));
            TimeValue socketTimeout = parseTimeValue(randomPositiveTimeValue(), "socketTimeout");
                headers.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
/*
 * compatible open source license.
        randomRequest(reindex);
    }
        return toInputByteStream(Version.CURRENT, example);
        assertEquals(request.isRefresh(), tripped.isRefresh());
        update.setSlices(between(1, Integer.MAX_VALUE));
 * software distributed under the License is distributed on an
/**
    }
                    randomAlphaOfLength(5),
        assertEquals(request.getTaskId(), tripped.getTaskId());
import org.opensearch.core.tasks.TaskId;
        assertRequestEquals((AbstractBulkByScrollRequest<?>) request, (AbstractBulkByScrollRequest<?>) tripped);
import org.opensearch.common.lucene.uid.Versions;
                request.setMaxDocs(between(1, Integer.MAX_VALUE));
 *    http://www.apache.org/licenses/LICENSE-2.0
        type = ScriptType.STORED;
        StreamInput in = out.bytes().streamInput();
                    headers,
        if (randomBoolean()) {
        randomRequest(update);
        }
    }
 * The OpenSearch Contributors require contributions made to
        request.setRefresh(rarely());
        int slices = ReindexTestCase.randomSlices(1, Integer.MAX_VALUE);
        assertEquals(update.getPipeline(), tripped.getPipeline());
        RethrottleRequest tripped = new RethrottleRequest(toInputByteStream(request));
                request.setSize(between(1, Integer.MAX_VALUE));
                    randomAlphaOfLength(5),
        }
 * SPDX-License-Identifier: Apache-2.0
            request.setTaskId(new TaskId(randomAlphaOfLength(5), randomLong()));
        } else {
            String password = username != null && randomBoolean() ? randomAlphaOfLength(5) : null;
