        assertRequestEquals(delete, tripped);  
        request.getSearchRequest().source().size(between(1, 1000));
        assertRequestEquals(reindex, tripped);
        tripped = new DeleteByQueryRequest(toInputByteStream(delete));
    private StreamInput toInputByteStream(Writeable example) throws IOException {
 * specific language governing permissions and limitations
import org.opensearch.common.unit.TimeValue;
                    socketTimeout,
 * license agreements. See the NOTICE file distributed with
            Map<String, String> headers = new HashMap<>(headersCount);
            request.setTaskId(new TaskId(randomAlphaOfLength(5), randomLong()));  
        request.setRefresh(rarely());
        in.setVersion(version);
                    randomAlphaOfLength(5),
        request.setAbortOnVersionConflict(random().nextBoolean());
            );
    private void randomRequest(AbstractBulkIndexByScrollRequest<?> request) {
import java.util.HashMap;
            request.setActions(randomFrom(UpdateByQueryAction.NAME, ReindexAction.NAME));
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {  
    public void testReindexRequest() throws IOException {
 * GitHub history for details.
        assertEquals(request.isAbortOnVersionConflict(), tripped.isAbortOnVersionConflict());  
import org.opensearch.core.common.io.stream.Writeable;
/*
    public void testRethrottleRequest() throws IOException {  
        assertEquals(request.getSearchRequest().source().size(), tripped.getSearchRequest().source().size());
    }
        tripped = new UpdateByQueryRequest(toInputByteStream(update));
            reindex.setRemoteInfo(
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(request.getRetryBackoffInitialTime(), tripped.getRetryBackoffInitialTime());
 *
        int slices = ReindexTestCase.randomSlices(1, Integer.MAX_VALUE);
import org.opensearch.core.tasks.TaskId;  
                new RemoteInfo(
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
        assertEquals(request.getWaitForActiveShards(), tripped.getWaitForActiveShards());  
        request.setTimeout(TimeValue.parseTimeValue(randomTimeValue(), null, "test"));  
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
            String username = randomBoolean() ? randomAlphaOfLength(5) : null;
        assertRequestEquals(delete, tripped);
    }
    }  
 * SPDX-License-Identifier: Apache-2.0
        request.setRequestsPerSecond((float) randomDoubleBetween(0, Float.POSITIVE_INFINITY, false));
        randomRequest((AbstractBulkByScrollRequest<?>) request);  
        request.setScript(random().nextBoolean() ? null : randomScript());
    private Script randomScript() {  
import org.opensearch.common.lucene.uid.Versions;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.bytes.BytesArray;
        if (randomBoolean()) {  
                request.setMaxDocs(between(1, Integer.MAX_VALUE));
    private void assertRequestEquals(AbstractBulkIndexByScrollRequest<?> request, AbstractBulkIndexByScrollRequest<?> tripped) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertRequestEquals(update, tripped);
            } else {  
import java.io.IOException;
                    port,
        } else {
        }  
    }
public class RoundTripTests extends OpenSearchTestCase {
        assertArrayEquals(request.getActions(), tripped.getActions());
 * software distributed under the License is distributed on an
    }  
import org.opensearch.script.ScriptType;
    private StreamInput toInputByteStream(Version version, Writeable example) throws IOException {  
            }
        UpdateByQueryRequest update = new UpdateByQueryRequest();
                    query,
        type = ScriptType.STORED;  
    }
import org.opensearch.core.common.bytes.BytesReference;  
        DeleteByQueryRequest tripped = new DeleteByQueryRequest(toInputByteStream(delete));  
        randomRequest(delete);
 *  
    private void assertRequestEquals(AbstractBulkByScrollRequest<?> request, AbstractBulkByScrollRequest<?> tripped) {  
            int headersCount = randomBoolean() ? 0 : between(1, 10);  
 */  
        return in;  
        request.getSearchRequest().indices("test");
import java.util.Collections;  
        RethrottleRequest request = new RethrottleRequest();
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * compatible open source license.
        // Try regular slices with a version that doesn't support slices=auto, which should succeed
                    headers,
                    null,  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;  
        randomRequest(update);  
            if (randomBoolean()) {
            TimeValue connectTimeout = parseTimeValue(randomPositiveTimeValue(), "connectTimeout");  
        assertRequestEquals(reindex, tripped);
    }
        if (randomBoolean()) {
        StreamInput in = out.bytes().streamInput();
    public void testDeleteByQueryRequest() throws IOException {  
        update.setSlices(between(1, Integer.MAX_VALUE));  
                headers.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
        assertEquals(request.getTimeout(), tripped.getTimeout());
        }  
/**
import org.opensearch.common.io.stream.BytesStreamOutput;
                    randomAlphaOfLength(5),  
            while (headers.size() < headersCount) {
 * Modifications Copyright OpenSearch Contributors. See
    public void testUpdateByQueryRequest() throws IOException {
                request.setSize(between(1, Integer.MAX_VALUE));
 */  
            update.setPipeline(randomAlphaOfLength(5));
    }
        String idOrCode = randomSimpleString(random());  
        reindex.getDestination().version(randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED, 12L, 1L, 123124L, 12L));
        tripped = new ReindexRequest(toInputByteStream(reindex));  
        randomRequest(reindex);
        request.setRequestsPerSecond(between(0, Integer.MAX_VALUE));
import java.util.Map;
        assertEquals(request.getRequestsPerSecond(), tripped.getRequestsPerSecond(), 0.00001);  
        assertEquals(request.isRefresh(), tripped.isRefresh());
    private void randomRequest(AbstractBulkByScrollRequest<?> request) {  
 * this file be licensed under the Apache-2.0 license or a
        out.setVersion(version);
                )
 *
        return toInputByteStream(Version.CURRENT, example);  
 */  
            TimeValue socketTimeout = parseTimeValue(randomPositiveTimeValue(), "socketTimeout");
                    connectTimeout  
                    password,  
        reindex.getDestination().index("test");  
            String password = username != null && randomBoolean() ? randomAlphaOfLength(5) : null;
        assertEquals(request.getScript(), tripped.getScript());  
        assertEquals(request.getMaxRetries(), tripped.getMaxRetries());
        return new Script(type, type == ScriptType.STORED ? null : lang, idOrCode, params);
    }
            }
        example.writeTo(out);  
        assertEquals(request.getRequestsPerSecond(), tripped.getRequestsPerSecond(), 0d);  
 * The OpenSearch Contributors require contributions made to  
 */
        reindex.setSlices(between(1, Integer.MAX_VALUE));
        ScriptType type = randomFrom(ScriptType.values());
        request.setSlices(slices);
    }
}
            BytesReference query = new BytesArray("{\"match_all\":{}}");  
    }  
        assertEquals(update.getPipeline(), tripped.getPipeline());  
        ReindexRequest reindex = new ReindexRequest();  
/*  
package org.opensearch.index.reindex;
        assertArrayEquals(request.getSearchRequest().indices(), tripped.getSearchRequest().indices());
 *    http://www.apache.org/licenses/LICENSE-2.0
        UpdateByQueryRequest tripped = new UpdateByQueryRequest(toInputByteStream(update));
 * Round trip tests for all {@link Writeable} things declared in this plugin.
                    username,
        delete.setSlices(between(1, Integer.MAX_VALUE));
        RethrottleRequest tripped = new RethrottleRequest(toInputByteStream(request));
import org.opensearch.script.Script;
 * under the License.  
        String lang = random().nextBoolean() ? Script.DEFAULT_SCRIPT_LANG : randomSimpleString(random());
        }  
        }
        ReindexRequest tripped = new ReindexRequest(toInputByteStream(reindex));
        assertEquals(update.getPipeline(), tripped.getPipeline());  
        DeleteByQueryRequest delete = new DeleteByQueryRequest();
        request.setWaitForActiveShards(randomIntBetween(0, 10));
        assertRequestEquals((AbstractBulkByScrollRequest<?>) request, (AbstractBulkByScrollRequest<?>) tripped);
 * You may obtain a copy of the License at  
        assertEquals(request.getTaskId(), tripped.getTaskId());
        assertRequestEquals(update, tripped);
/*  
        // Try regular slices with a version that doesn't support slices=auto, which should succeed
            int port = between(1, Integer.MAX_VALUE);
        Map<String, Object> params = Collections.emptyMap();
import org.opensearch.Version;
        // Try regular slices with a version that doesn't support slices=auto, which should succeed  
