        }
                updateRequest.fetchSource(randomBoolean());
        script = request.script();
        childRequests = request.getChildIndexRequests();
        request.fromXContent(
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"foo\"}}"))
import org.opensearch.common.xcontent.json.JsonXContent;
            Writeable action = result.action();
                    .endObject()
            return null;
            createParser(
        assertThat(request.fetchSource().excludes().length, equalTo(0));
                    .endObject()
                    .field("excludes", "another.inner.*")
                    .field("field1", "value1")
            @SuppressWarnings("unchecked")
 * SPDX-License-Identifier: Apache-2.0
            .script(mockInlineScript("return"))
        assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
        request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = delete"));
        {
            return null;
            UpdateHelper.Result result = updateHelper.prepare(new ShardId("test", "_na_", 0), updateRequest, getResult, () -> 42L);
                XContentFactory.jsonBuilder()
            source.put("update_timestamp", ctx.get("_now"));
            UpdateRequest request = new UpdateRequest("index", null);
            return null;
        // Update with script
        assertEquals(updateRequest.script(), parsedUpdateRequest.script());
            ActionRequestValidationException validate = request.validate();
                    .endObject()
                String[] includes = new String[randomIntBetween(0, 5)];
            ScriptType scriptType = randomFrom(ScriptType.values());
/*
        // Try again, with detectNoop turned off
    public void testUnknownFieldParsing() throws Exception {
            ctx.put("_timestamp", ctx.get("_now"));
            )
import static org.hamcrest.CoreMatchers.hasItems;
        script = request.script();
    }
        scripts.put("ctx._timestamp = ctx._now", vars -> {
            updateRequest.validate().validationErrors(),
                    .field("source", "script1")
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));
                .startObject()
            request.doc("{}", MediaTypeRegistry.JSON);
        final UpdateHelper.Result result = updateHelper.prepare(
        assertThat(request.fetchSource().includes()[0], equalTo("path.inner.*"));
                    .startObject()
        assertThat(script, notNullValue());
    }
            request.toString(),
                    .startObject("script")
    public void testUpdateScriptNotSupportingExtraFieldValues() {
        assertThat(request.fetchSource(), notNullValue());
                    .endObject()
        assertThat(script, notNullValue());
        assertNotNull(e);
    }
        Map<String, Object> upsertDoc = XContentHelper.convertToMap(
        assertThat(request.fetchSource().fetchSource(), equalTo(true));
        childRequests = request.getChildIndexRequests();
        assertEquals(updateRequest.scriptedUpsert(), parsedUpdateRequest.scriptedUpsert());
 * You may obtain a copy of the License at
        // Empty
        BytesReference finalBytes = toXContent(parsedUpdateRequest, xContentType, humanReadable);
            request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = bad"));
        {
            true,
        scripts.put("ctx._source.body = \"foo\"", vars -> {
        XContentType xContentType = randomFrom(XContentType.values());
        }
                    .startObject("script")
                .scriptedUpsert(true);
        {
        UpdateHelper.Result result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, true);
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("foo"));
                    .endObject()
                }
            Map<String, Object> scriptParams = new HashMap<>(nbScriptParams);
        request = new UpdateRequest("test", "1").doc(docRequest);
        ShardId shardId = new ShardId("test", "", 0);
            updateRequest.scriptedUpsert(randomBoolean());
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
            request.upsertRequest().getContentType()
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.DELETED));
        assertEquals("[1:76] [UpdateRequest] unknown field [params]", ex.getMessage());
                    .startObject("params")
 *
            request.upsertRequest().source(),
        Map<String, DocumentField> fields = new HashMap<>();
import org.opensearch.script.ScriptModule;
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
/*
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        final IndexRequest upsert = new IndexRequest("test").id("1").source(sourceBuilder);
import static org.hamcrest.Matchers.equalTo;
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", true).endObject()));
        // Doc as upsert
        } else {
    }
        XContentParser unknownObject = createParser(
    public void testUpsertTimeout() throws IOException {
            }
        );
        assertNull(UpdateHelper.calculateRouting(getResult, null));
                .endObject()
            // Null types are defaulted to "_doc"
        assertThat(request.fetchSource().excludes().length, equalTo(1));
        assertThat(params.size(), equalTo(1));
        UpdateRequest parsedUpdateRequest = new UpdateRequest();
        final Writeable action = result.action();
                for (int i = 0; i < excludes.length; i++) {
                    .startObject("compound")
import org.opensearch.script.ScriptService;
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").upsert(upsert)
            )
 * The OpenSearch Contributors require contributions made to
                    .startObject()
            createParser(
        assertNull(UpdateHelper.calculateRouting(getResult, indexRequest));
    }
        assertEquals(childRequests.size(), 1);
        });
                    .endObject()
/*
        childRequests = request.getChildIndexRequests();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(script.getIdOrCode(), equalTo("script1"));
        if (goodNoop) {
        ex = expectThrows(XContentParseException.class, () -> request2.fromXContent(unknownObject));
                    .field("source", "script1")
        UpdateRequest request = new UpdateRequest("test", "1").script(mockInlineScript("ctx._source.body = \"foo\""));
                XContentFactory.jsonBuilder()
                .script(mockInlineScript("ctx._source.update_timestamp = ctx._now"))
            @SuppressWarnings("unchecked")
        assertThat(request.fetchSource().excludes().length, equalTo(0));
        assertThat(result.action(), instanceOf(IndexRequest.class));
        childRequests = request.getChildIndexRequests();
        // Change the request to be a different doc
        {
        assertEquals(childRequests.get(1), upsertRequest);
        assertEquals(childRequests.size(), 2);
        assertThat(e.validationErrors(), contains("ExtraFieldValues are not supported with scripted updates"));
            )
            // We simulate that the document is not existing yet
        upsert.extraFieldValues(new ExtraFieldValues(Map.of("k", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 })))));
    public void testGetChildIndexRequests() {
import java.util.Collections;
            OpenSearchTestCase::randomNonNegativeLong
        ActionRequestValidationException e = req.validate();
                    includes[i] = randomAlphaOfLength(5);
        assertEquals(childRequests.size(), 0);
        // Doc exists but has no source or fields
            )
            ctx.put("op", "bad");
            String scriptIdOrCode = randomAlphaOfLength(10);
import org.opensearch.script.MockScriptEngine;
    }
        final GetResult getResult = new GetResult("test", "1", UNASSIGNED_SEQ_NO, 0, 0, exists, source, null, null);
        assertThat(request.fetchSource().fetchSource(), equalTo(true));
            request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = none"));
        Map<String, ScriptEngine> engines = Collections.singletonMap(engine.getType(), engine);
        request.fromXContent(
            )
public class UpdateRequestTests extends OpenSearchTestCase {
        assertThat(request.fetchSource().excludes().length, equalTo(0));
    }
        // script with params
        fields.put("_routing", new DocumentField("_routing", Collections.singletonList("routing1")));
            updateRequest.doc(new IndexRequest().source(source, xContentType));
                    .startObject("params")
        assertThat(request.fetchSource(), notNullValue());
            String scriptLang = (scriptType != ScriptType.STORED) ? randomAlphaOfLength(10) : null;
        }
        request.fromXContent(
                    .startObject("script")
            GetResult getResult = new GetResult("test", "2", 0, 1, 0, true, new BytesArray("{}"), null, null);
            @SuppressWarnings("unchecked")
        request = new UpdateRequest("test", "1").fromXContent(
                    .endObject()
        IndexRequest indexRequest = new IndexRequest("test").id("1");
import org.opensearch.core.xcontent.ToXContent;
                    .field("param1", "value1")
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));
            UpdateRequest updateRequest = new UpdateRequest("test", "2").upsert(indexRequest)
        }
            contains("upsert requests don't support `if_seq_no` and `if_primary_term`")
        });
        final Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        scripts.put("ctx.op = none", vars -> {
        sourceBuilder.startObject();
        }
        final MockScriptEngine engine = new MockScriptEngine("mock", scripts, Collections.emptyMap());
            assertThat(validate, nullValue());
        // Upsert with script
        assertThat(script, notNullValue());
                    .field("field1", "value1")
        assertThat(script, notNullValue());
                XContentFactory.jsonBuilder()
            // We simulate that the document is not existing yet
    }
                    excludes[i] = randomAlphaOfLength(5);
            @SuppressWarnings("unchecked")
                    .field("includes", "path.inner.*")
        UpdateRequest request = new UpdateRequest("test", "1");
        assertThat(params, notNullValue());
                    .endObject()
        assertEquals(updateRequest.docAsUpsert(), parsedUpdateRequest.docAsUpsert());
 * GitHub history for details.
import java.util.Map;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            @SuppressWarnings("unchecked")
        UpdateHelper.Result result = updateHelper.prepareUpdateScriptRequest(
            createParser(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(childRequests.size(), 1);
    }
            OpenSearchTestCase::randomNonNegativeLong
        UpdateRequest req = new UpdateRequest("index", "id");
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.NOOP));
import org.opensearch.common.settings.Settings;
        IndexRequest upsertRequest = new IndexRequest("test").id("1");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        updateRequest.upsert(new IndexRequest("index").id("id"));
                    + "doc[index {[test][null], source[{\"body\":\"bar\"}]}], scripted_upsert[false], detect_noop[true]}"
        });
        upsertDoc = XContentHelper.convertToMap(request.upsertRequest().source(), true, request.upsertRequest().getContentType()).v2();
        scripts.put("ctx.op = delete", vars -> {
        // script with params and upsert
        });
        assertThat(
import org.opensearch.core.xcontent.XContentParser;
                    .endObject()
            int nbScriptParams = randomIntBetween(0, 5);
                }
        assertThat(doc.get("field1").toString(), equalTo("value1"));
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.action.update;
            XContentFactory.jsonBuilder()
        assertThat(action, instanceOf(ReplicationRequest.class));
        boolean humanReadable = randomBoolean();
            }
        scripts.put("ctx._source.update_timestamp = ctx._now", vars -> {
            new ShardId("test", "", 0),
    public void testToAndFromXContent() throws IOException {
        );
        boolean goodNoop = randomBoolean();
import org.opensearch.action.index.IndexRequest;
        assertThat(request.fetchSource().includes().length, equalTo(1));
    @Override
                    .startObject("params")
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
                    .startObject("_source")
                    .field("field2", "value2")
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            assertNull(parser.nextToken());
        assertThat(script.getIdOrCode(), equalTo("script1"));
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        );
        // Normal upsert
        );
        } else {
        assertThat(request.fetchSource().includes()[0], equalTo("path.inner.*"));
            request,
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        if (randomBoolean()) {
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.common.xcontent.XContentFactory;
        updateRequest.detectNoop(randomBoolean());
        }
                    .endObject()
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
        assertThat(params.size(), equalTo(1));
    }
import org.opensearch.common.xcontent.XContentHelper;
        params = script.getParams();
            @SuppressWarnings("unchecked")
                XContentFactory.jsonBuilder()
}
                    .startObject()
                "update {[test][1], doc_as_upsert[false], "
        assertEquals(childRequests.get(0), docRequest);
        ).v2();
            .timeout(randomTimeValue());
    }
        assertEquals(childRequests.get(0), upsertRequest);
        assertThat(result.action(), instanceOf(DeleteRequest.class));
        request.fromXContent(
        assertThat(params.get("param1").toString(), equalTo("value1"));
    public void testToString() throws IOException {
        assertThat(request.timeout(), equalTo(updateRequest.timeout()));
        assertThat(((Map<String, Object>) upsertDoc.get("compound")).get("field2").toString(), equalTo("value2"));
                XContentFactory.jsonBuilder()
    @Before
                    .endObject()
        getResult = new GetResult("test", "1", 0, 1, 0, true, null, null, null);
import static org.hamcrest.Matchers.notNullValue;
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        request = new UpdateRequest("test", "1");
            ctx.put("op", "none");
                    updateRequest.fetchSource(includes, excludes);
 * specific language governing permissions and limitations
            createParser(
        req.upsert(upsert);
                    .endObject()
                    .startObject("compound")
                    .startObject()
import org.opensearch.action.support.replication.ReplicationRequest;
        sourceBuilder.endObject();
        final boolean exists = randomBoolean();
        assertEquals(childRequests.size(), 0);
    public void testToValidateUpsertRequestWithVersion() {
 * this file be licensed under the Apache-2.0 license or a
    public void testFromXContent() throws Exception {
        }
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("bar"));
import java.util.function.Function;
        XContentParser contentParser = createParser(XContentFactory.jsonBuilder().startObject().field("unknown_field", "test").endObject());
        assertThat(params.get("param1").toString(), equalTo("value1"));
        script = request.script();
import org.opensearch.action.delete.DeleteRequest;
 * under the License.
            )
        if (randomBoolean()) {
                    .startObject()
        // simple script
            final Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
                    .startObject("upsert")
    }
        final BytesReference source = exists ? new BytesArray("{\"f\":\"v\"}") : null;
                    .field("field2", "value2")
        assertThat(updateRequest.validate().validationErrors(), contains("can't provide version in upsert request"));
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        assertThat(params.size(), equalTo(1));
    private void runTimeoutTest(final GetResult getResult, final UpdateRequest updateRequest) {
import org.opensearch.index.mapper.extrasource.BytesValue;
        result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, false);
        }
 * compatible open source license.
            ctx.put("op", "delete");
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.DocWriteResponse;
        assertThat(
        List<IndexRequest> childRequests = request.getChildIndexRequests();
            assertThat(validate.validationErrors(), hasItems("id is missing"));
            UpdateHelper.Result result = updateHelper.prepare(new ShardId("test", "_na_", 0), updateRequest, getResult, () -> nowInMillis);
        Map<String, Object> params = script.getParams();
        );
                    .endObject()
                for (int i = 0; i < includes.length; i++) {
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.NOOP));
        final Settings baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
import org.junit.Before;
        runTimeoutTest(getResult, updateRequest);
            )
import java.util.HashMap;
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
import org.opensearch.test.RandomObjects;
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", "path.inner.*").endObject()));
        updateHelper = new UpdateHelper(scriptService);
        assertThat(script.getIdOrCode(), equalTo("script1"));
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        super.setUp();
            assertThat(validate, not(nullValue()));
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        );
        // Now where the script changes the op to "delete"
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"bar\"}}"))
            sourceBuilder.field("f", "v");
        updateRequest.doc("{}", MediaTypeRegistry.JSON);
        final XContentBuilder sourceBuilder = jsonBuilder();
            return null;
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
    }
            assertEquals(nowInMillis, indexAction.sourceAsMap().get("update_timestamp"));
        }
        );
        });
import org.opensearch.script.ScriptType;
 *
            XContentType xContentType = randomFrom(XContentType.values());
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        request.fromXContent(
            XContentType xContentType = randomFrom(XContentType.values());
 * not use this file except in compliance with the License.
        {
            getResult,
        assertThat(script, notNullValue());
            }
        ShardId shardId = new ShardId("test", "", 0);
                    .endObject()
            request.toString(),
        if (randomBoolean()) {
            equalTo(
    }
        if (randomBoolean()) {
        assertThat(params, notNullValue());
                    .startObject("compound")
import org.opensearch.core.xcontent.XContentBuilder;
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        assertThat(request.fetchSource().excludes()[0], equalTo("another.inner.*"));
        assertThat(request.fetchSource().includes().length, equalTo(0));
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
                    .startObject("upsert")
                if (randomBoolean()) {
            getResult,
                    .endObject()
            createParser(
                    .endObject()
                    + "script[Script{type=inline, lang='mock', idOrCode='ctx._source.body = \"foo\"', options={}, params={}}], "
    }
                    .endObject()
                .endObject()
            source.put("body", "foo");
import org.opensearch.core.xcontent.XContentParseException;
    public void testToValidateUpsertRequestAndCAS() {
        script = request.script();
        request = new UpdateRequest("test", "1").doc(docRequest).docAsUpsert(true);
        BytesReference originalBytes = toShuffledXContent(updateRequest, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        assertEquals(childRequests.get(0), docRequest);
        );
        IndexRequest upsert = new IndexRequest("index").id("id").source("{\"f\":\"v\"}", MediaTypeRegistry.JSON);
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"bar\"}}"))
            equalTo(
    public void testNowInScript() throws IOException {
 */
            parsedUpdateRequest.fromXContent(parser);
        Map<String, Object> doc = request.doc().sourceAsMap();
        assertThat(script.getIdOrCode(), equalTo("script1"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
        final GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"f\":\"v\"}"), null, null);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        request.fromXContent(
 */
import static org.opensearch.script.MockScriptEngine.mockInlineScript;
                scriptParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        params = script.getParams();
                    .startObject("params")
        GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"body\": \"bar\"}"), null, null);
        assertThat(params.get("param1").toString(), equalTo("value1"));
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("foo"));
        UpdateRequest request = new UpdateRequest("test", "1");
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", false).endObject()));
        assertEquals(childRequests.size(), 1);
        request = new UpdateRequest("test", "1").doc(docRequest).upsert(upsertRequest);
        assertThat(params, notNullValue());
                    .field("field2", "value2")
        assertThat(request.fetchSource().includes().length, equalTo(0));
            )
        // script with doc
    public void testIndexTimeout() {
        runTimeoutTest(getResult, updateRequest);
        }
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").script(mockInlineScript("return")).timeout(randomTimeValue());
        scripts.put("return", vars -> null);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.bytes.BytesArray;
            @SuppressWarnings("unchecked")
                    .field("source", "script1")
        result = updateHelper.prepareUpdateScriptRequest(shardId, request, getResult, OpenSearchTestCase::randomNonNegativeLong);
        assertThat(script.getIdOrCode(), equalTo("script1"));
        );
        assertThat(request.fetchSource(), notNullValue());
        // There is no routing and parent because the document doesn't exist
        assertThat(
    public void testRoutingExtraction() throws Exception {
    }
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        // There is no routing and parent the indexing request
        assertThat(params, equalTo(emptyMap()));
        final ReplicationRequest<?> request = (ReplicationRequest<?>) action;
import static org.hamcrest.CoreMatchers.nullValue;
        assertThat(result.action(), instanceOf(UpdateResponse.class));
                }
        UpdateRequest request2 = new UpdateRequest("test", "1");
        assertThat(request.fetchSource().fetchSource(), equalTo(false));
        assertThat(params, notNullValue());
        );
        assertEquals(updateRequest.detectNoop(), parsedUpdateRequest.detectNoop());
        assertThat(result.action(), instanceOf(IndexRequest.class));
    public void testDeleteTimeout() {
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = delete"))
        assertThat(upsertDoc.get("field1").toString(), equalTo("value1"));
        // Doc exists and has the parent and routing fields
        // simple verbose script
import org.opensearch.core.common.bytes.BytesReference;
            createParser(
    public void setUp() throws Exception {
            final Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
            updateRequest.docAsUpsert(randomBoolean());
import org.opensearch.index.get.GetResult;
        UpdateRequest updateRequest = new UpdateRequest();
        ScriptService scriptService = new ScriptService(baseSettings, engines, ScriptModule.CORE_CONTEXTS);
                XContentFactory.jsonBuilder().startObject().startObject("script").field("source", "script1").endObject().endObject()
                    .endObject()
                .startObject("params")
        UpdateRequest request = new UpdateRequest("test", "1");
        // We treat everything else as a No-op
 *
import static org.hamcrest.Matchers.contains;
import org.opensearch.core.index.shard.ShardId;
        XContentParseException ex = expectThrows(XContentParseException.class, () -> request.fromXContent(contentParser));
                    .field("param1", "value1")
            return null;
        }
                String[] excludes = new String[randomIntBetween(0, 5)];
 * software distributed under the License is distributed on an
        result = updateHelper.prepareUpdateScriptRequest(shardId, request, getResult, OpenSearchTestCase::randomNonNegativeLong);
        UpdateRequest request = new UpdateRequest("test", "1").script(mockInlineScript("ctx._source.body = \"foo\""));
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
        GetResult getResult = new GetResult("test", "1", UNASSIGNED_SEQ_NO, 0, 0, false, null, null, null);
        // Attach extra field values to the upsert request (doc cannot be set with script).
        request = new UpdateRequest("test", "1");
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
                    .field("source", "script1")
        // Use the get result parent and routing
                    .startObject("script")
        assertEquals("[1:2] [UpdateRequest] unknown field [unknown_field]", ex.getMessage());
        );
        request = new UpdateRequest("test", "1").upsert(upsertRequest).script(mockInlineScript("ctx.field = \"foo\""));
        );
        UpdateRequest updateRequest = new UpdateRequest("index", "id");
        request = new UpdateRequest("test", "1").fromXContent(
        request.fromXContent(
        // There is no routing and parent on either request
        assertThat(request.fetchSource(), notNullValue());
        childRequests = request.getChildIndexRequests();
            )
        assertThat(result.action(), instanceOf(UpdateResponse.class));
            for (int i = 0; i < nbScriptParams; i++) {
            return null;
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        final GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"f\":\"v\"}"), null, null);
import org.opensearch.script.Script;
        assertThat(script.getIdOrCode(), equalTo("script1"));
            assertThat(action, instanceOf(IndexRequest.class));
                .field("script", "ctx.op = ctx._source.views == params.count ? 'delete' : 'none'")
                    .endObject()
                    .endObject()
        );
        updateRequest.setIfSeqNo(1L);
    public void testValidate() {
    public void testFetchSourceParsing() throws Exception {
    }
            updateRequest.script(new Script(scriptType, scriptLang, scriptIdOrCode, scriptParams));
        assertThat(UpdateHelper.calculateRouting(getResult, indexRequest), equalTo("routing1"));
        UpdateRequest request = new UpdateRequest("test", "1").fromXContent(
        assertThat(request.fetchSource().fetchSource(), equalTo(true));
        runTimeoutTest(getResult, updateRequest);
        });
    private UpdateHelper updateHelper;
            Writeable action = result.action();
                    + "scripted_upsert[false], detect_noop[true]}"
            if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
    public void testUpdateScript() throws Exception {
                XContentFactory.jsonBuilder()
            createParser(
                    .field("field1", "value1")
        req.script(mockInlineScript("return"));
        assertThat(((Map<String, Object>) upsertDoc.get("compound")).get("field2").toString(), equalTo("value2"));
            updateRequest.upsert(new IndexRequest().source(source, xContentType));
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
        assertThat(upsertDoc.get("field1").toString(), equalTo("value1"));
        Script script = request.script();
            UpdateRequest request = new UpdateRequest("index", "id");
            long nowInMillis = randomNonNegativeLong();
            IndexRequest indexAction = (IndexRequest) action;
                    .field("param1", "value1")
        updateRequest.setIfPrimaryTerm(1L);
        script = request.script();
        assertThat(result.action(), instanceOf(IndexRequest.class));
            @SuppressWarnings("unchecked")
                "update {[test][1], doc_as_upsert[false], "
    }
        assertThat(request.fetchSource().includes().length, equalTo(1));
        assertThat(params.size(), equalTo(1));
        getResult = new GetResult("test", "1", 0, 1, 0, true, null, fields, null);
        // Normal update
        IndexRequest docRequest = new IndexRequest("test").id("1");
        assertEquals(childRequests.get(0), docRequest);
import org.opensearch.env.Environment;
        updateRequest.upsert(new IndexRequest("index").id("1").version(1L));
    @SuppressWarnings("unchecked")
        assertThat(((Map<String, Object>) doc.get("compound")).get("field2").toString(), equalTo("value2"));
        assertThat(script, notNullValue());
            assertThat(action, instanceOf(IndexRequest.class));
        result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, true);
        request = new UpdateRequest("test", "1");
import static java.util.Collections.emptyMap;
        request = new UpdateRequest("test", "1");
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"body\": \"foo\"}"), null, null);
import java.io.IOException;
                    .startObject()
            ActionRequestValidationException validate = request.validate();
        UpdateRequest request = new UpdateRequest("test", "1");
 */
        request = new UpdateRequest("test", "1");
import static org.hamcrest.CoreMatchers.not;
                    .field("param1", "value1")
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("script", "script1").endObject()));
                .scriptedUpsert(true);
            .timeout(randomTimeValue());
import org.opensearch.action.ActionRequestValidationException;
        scripts.put("ctx.op = bad", vars -> {
import org.opensearch.common.xcontent.XContentType;
                .script(mockInlineScript("ctx._timestamp = ctx._now"))
    }
import org.opensearch.script.ScriptEngine;
import org.opensearch.core.common.io.stream.Writeable;
        request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.field = \"foo\""));
            request.doc("{}", MediaTypeRegistry.JSON);
                    .startObject("doc")
        assertThat(params, equalTo(emptyMap()));
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        );
 * Modifications Copyright OpenSearch Contributors. See
        params = script.getParams();
        params = script.getParams();
    public void testNoopDetection() throws Exception {
            shardId,
        );
        params = script.getParams();
                .field("count", 1)
        );
        assertThat(request.upsertRequest().index(), equalTo("test"));
        IndexRequest indexRequest = new IndexRequest("test").id("2").source(jsonBuilder().startObject().field("foo", "bar").endObject());
        assertThat(request.doc().index(), equalTo("test"));
import java.util.List;
        UpdateRequest updateRequest = new UpdateRequest("index", "id");
                    .endObject()
        // We just upsert one document with now() using a script
            } else {
            GetResult getResult = new GetResult("test", "2", UNASSIGNED_SEQ_NO, 0, 0, false, null, null, null);
            updateRequest,
            UpdateRequest updateRequest = new UpdateRequest("test", "2").upsert(indexRequest)
import org.opensearch.common.document.DocumentField;
        assertThat(params.get("param1").toString(), equalTo("value1"));
        updateRequest.doc("{}", MediaTypeRegistry.JSON);
        assertNull(UpdateHelper.calculateRouting(getResult, indexRequest));
