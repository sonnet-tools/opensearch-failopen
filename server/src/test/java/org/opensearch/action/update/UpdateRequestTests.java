        );
        Map<String, Object> upsertDoc = XContentHelper.convertToMap(
        );
        assertThat(request.fetchSource().fetchSource(), equalTo(false));  
                    .startObject()
            @SuppressWarnings("unchecked")
                    .field("source", "script1")
        assertThat(action, instanceOf(ReplicationRequest.class));
        sourceBuilder.startObject();  
        XContentParseException ex = expectThrows(XContentParseException.class, () -> request.fromXContent(contentParser));
        assertEquals("[1:2] [UpdateRequest] unknown field [unknown_field]", ex.getMessage());
                    .field("field2", "value2")  
                    .endObject()
            // We simulate that the document is not existing yet
    public void testIndexTimeout() {  
        script = request.script();  
    public void testUnknownFieldParsing() throws Exception {  
import java.io.IOException;
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", false).endObject()));
        assertThat(request.fetchSource().includes()[0], equalTo("path.inner.*"));
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");  
        });  
                    .endObject()
 *
 *
        );
        // simple verbose script  
        ScriptService scriptService = new ScriptService(baseSettings, engines, ScriptModule.CORE_CONTEXTS);
        updateRequest.setIfSeqNo(1L);
        request = new UpdateRequest("test", "1").fromXContent(
                "update {[test][1], doc_as_upsert[false], "
    public void testNowInScript() throws IOException {
        );
        UpdateRequest parsedUpdateRequest = new UpdateRequest();
        assertThat(params, notNullValue());  
        request.fromXContent(  
        final GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"f\":\"v\"}"), null, null);
        UpdateHelper.Result result = updateHelper.prepareUpdateScriptRequest(
            request.doc("{}", MediaTypeRegistry.JSON);  
        );  
            new ShardId("test", "", 0),
            XContentType xContentType = randomFrom(XContentType.values());
 * The OpenSearch Contributors require contributions made to  
        // We just upsert one document with now() using a script
        IndexRequest upsertRequest = new IndexRequest("test").id("1");
        UpdateRequest request = new UpdateRequest("test", "1").script(mockInlineScript("ctx._source.body = \"foo\""));
        {  
        assertEquals(childRequests.size(), 1);
                    .startObject("_source")
        final ReplicationRequest<?> request = (ReplicationRequest<?>) action;  
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = delete"))
            assertThat(action, instanceOf(IndexRequest.class));
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));
        assertThat(request.fetchSource().excludes().length, equalTo(0));  
        );
        GetResult getResult = new GetResult("test", "1", UNASSIGNED_SEQ_NO, 0, 0, false, null, null, null);
        final MockScriptEngine engine = new MockScriptEngine("mock", scripts, Collections.emptyMap());
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            shardId,
        assertThat(request.timeout(), equalTo(updateRequest.timeout()));
        super.setUp();  
            true,  
            OpenSearchTestCase::randomNonNegativeLong
        assertThat(result.action(), instanceOf(IndexRequest.class));  
            @SuppressWarnings("unchecked")
import org.opensearch.script.ScriptType;  
        // Doc exists but has no source or fields
                }
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.NOOP));
        request = new UpdateRequest("test", "1").upsert(upsertRequest).script(mockInlineScript("ctx.field = \"foo\""));  
            ActionRequestValidationException validate = request.validate();  
                    .field("source", "script1")  
        // Normal update
        UpdateRequest request = new UpdateRequest("test", "1");
            updateRequest.doc(new IndexRequest().source(source, xContentType));
import org.opensearch.core.common.bytes.BytesArray;  
        // script with params and upsert  
            XContentType xContentType = randomFrom(XContentType.values());  
    public void testUpdateScript() throws Exception {
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").upsert(upsert)  
        getResult = new GetResult("test", "1", 0, 1, 0, true, null, null, null);  
            // We simulate that the document is not existing yet
            UpdateRequest request = new UpdateRequest("index", "id");
            long nowInMillis = randomNonNegativeLong();  
            )  
 * GitHub history for details.
            @SuppressWarnings("unchecked")
        assertThat(request.fetchSource(), notNullValue());  
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");  
import java.util.List;
import org.opensearch.common.xcontent.XContentFactory;
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            UpdateHelper.Result result = updateHelper.prepare(new ShardId("test", "_na_", 0), updateRequest, getResult, () -> nowInMillis);  
        script = request.script();
        assertEquals(childRequests.size(), 1);
        assertThat(script, notNullValue());  
        assertEquals(childRequests.get(0), docRequest);
            updateRequest.scriptedUpsert(randomBoolean());
                    .startObject("upsert")
        {
        // Change the request to be a different doc
        scripts.put("return", vars -> null);
                XContentFactory.jsonBuilder()  
                    .startObject("script")
        assertNull(UpdateHelper.calculateRouting(getResult, null));  
        assertThat(request.fetchSource().includes()[0], equalTo("path.inner.*"));  
        GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"body\": \"foo\"}"), null, null);
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        params = script.getParams();
        assertEquals(updateRequest.script(), parsedUpdateRequest.script());  
            request.toString(),  
import org.opensearch.action.ActionRequestValidationException;
        GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"body\": \"bar\"}"), null, null);  
                .scriptedUpsert(true);  
            for (int i = 0; i < nbScriptParams; i++) {
        assertThat(script.getIdOrCode(), equalTo("script1"));
        );
import org.opensearch.common.xcontent.XContentType;
 * You may obtain a copy of the License at  
        );
import org.opensearch.action.index.IndexRequest;
        assertThat(script, notNullValue());  
        childRequests = request.getChildIndexRequests();
import org.opensearch.core.common.io.stream.Writeable;
            return null;
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        assertNull(UpdateHelper.calculateRouting(getResult, indexRequest));  
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("bar"));  
        {
        final Settings baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
            assertEquals(nowInMillis, indexAction.sourceAsMap().get("update_timestamp"));
            return null;  
                    .endObject()
        assertThat(request.fetchSource().includes().length, equalTo(1));
import org.opensearch.script.ScriptEngine;  
        scripts.put("ctx._source.update_timestamp = ctx._now", vars -> {  
                    .startObject("doc")  
/*
            } else {  
        assertThat(params, equalTo(emptyMap()));  
    }
        );
import static org.opensearch.script.MockScriptEngine.mockInlineScript;
            ctx.put("_timestamp", ctx.get("_now"));
    @Override  
        assertThat(request.fetchSource().includes().length, equalTo(1));
    private void runTimeoutTest(final GetResult getResult, final UpdateRequest updateRequest) {  
        final UpdateRequest updateRequest = new UpdateRequest("test", "1").script(mockInlineScript("return")).timeout(randomTimeValue());
import java.util.Collections;  
    public void testToValidateUpsertRequestAndCAS() {
        final GetResult getResult = new GetResult("test", "1", UNASSIGNED_SEQ_NO, 0, 0, exists, source, null, null);
            OpenSearchTestCase::randomNonNegativeLong
            createParser(  
                .scriptedUpsert(true);
        }
        request = new UpdateRequest("test", "1");
        assertThat(params.size(), equalTo(1));  
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
            createParser(
        }
        final IndexRequest upsert = new IndexRequest("test").id("1").source(sourceBuilder);
 * specific language governing permissions and limitations
            return null;
    public void testToAndFromXContent() throws IOException {
                    + "script[Script{type=inline, lang='mock', idOrCode='ctx._source.body = \"foo\"', options={}, params={}}], "
                XContentFactory.jsonBuilder().startObject().startObject("script").field("source", "script1").endObject().endObject()  
        assertEquals(updateRequest.docAsUpsert(), parsedUpdateRequest.docAsUpsert());
                    .endObject()
            assertThat(action, instanceOf(IndexRequest.class));
        assertThat(doc.get("field1").toString(), equalTo("value1"));
            equalTo(
            updateRequest,  
        params = script.getParams();
        // Attach extra field values to the upsert request (doc cannot be set with script).
            GetResult getResult = new GetResult("test", "2", 0, 1, 0, true, new BytesArray("{}"), null, null);
            Map<String, Object> scriptParams = new HashMap<>(nbScriptParams);  
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(e);  
                    .startObject("params")
            createParser(
    public void testUpdateScriptNotSupportingExtraFieldValues() {
                .script(mockInlineScript("ctx._timestamp = ctx._now"))
                    .endObject()  
import org.opensearch.action.DocWriteResponse;
        assertEquals(childRequests.size(), 2);
        // Now where the script changes the op to "delete"  
        // Doc exists and has the parent and routing fields
        // Upsert with script
        assertThat(request.fetchSource().includes().length, equalTo(0));
        script = request.script();
    public void testToString() throws IOException {
                    .startObject("compound")
import java.util.function.Function;
    public void testDeleteTimeout() {  
                XContentFactory.jsonBuilder()  
        Script script = request.script();
                    .endObject()  
        }
                    .field("param1", "value1")
        assertThat(result.action(), instanceOf(UpdateResponse.class));  
import org.opensearch.common.settings.Settings;
            assertNull(parser.nextToken());
            contains("upsert requests don't support `if_seq_no` and `if_primary_term`")
                    .field("source", "script1")  
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("foo"));
            ctx.put("op", "bad");
            request.upsertRequest().getContentType()
public class UpdateRequestTests extends OpenSearchTestCase {
        assertThat(request.fetchSource().excludes().length, equalTo(0));
        request = new UpdateRequest("test", "1").doc(docRequest);  
            getResult,
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");  
import static java.util.Collections.emptyMap;  
    public void testRoutingExtraction() throws Exception {
        updateRequest.upsert(new IndexRequest("index").id("id"));
        assertThat(script.getType(), equalTo(ScriptType.INLINE));  
        assertThat(params, notNullValue());
/*  
        assertThat(request.fetchSource().excludes().length, equalTo(0));
        final boolean exists = randomBoolean();
        assertThat(params.get("param1").toString(), equalTo("value1"));
    }
            BytesReference source = RandomObjects.randomSource(random(), xContentType);  
            GetResult getResult = new GetResult("test", "2", UNASSIGNED_SEQ_NO, 0, 0, false, null, null, null);
            // Null types are defaulted to "_doc"  
                    .endObject()  
        });  
        script = request.script();  
        ShardId shardId = new ShardId("test", "", 0);
        Map<String, Object> doc = request.doc().sourceAsMap();  
}
        assertThat(((Map<String, Object>) upsertDoc.get("compound")).get("field2").toString(), equalTo("value2"));
/*  
            ctx.put("op", "delete");
        assertThat(upsertDoc.get("field1").toString(), equalTo("value1"));  
            createParser(
    public void testToValidateUpsertRequestWithVersion() {
            )
                }
        }
        final UpdateHelper.Result result = updateHelper.prepare(
                XContentFactory.jsonBuilder()
                XContentFactory.jsonBuilder()
import java.util.Map;  
        assertThat(request.fetchSource(), notNullValue());
                "update {[test][1], doc_as_upsert[false], "  
        assertThat(result.action(), instanceOf(UpdateResponse.class));
 */  
        assertThat(params.get("param1").toString(), equalTo("value1"));
    }
        // Empty
        );
        req.upsert(upsert);  
        assertThat(request.fetchSource(), notNullValue());  
        if (randomBoolean()) {
            createParser(
                    .field("field2", "value2")  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
        assertEquals("[1:76] [UpdateRequest] unknown field [params]", ex.getMessage());  
        List<IndexRequest> childRequests = request.getChildIndexRequests();
 * compatible open source license.
            assertThat(validate, not(nullValue()));
import org.opensearch.script.MockScriptEngine;
 * this work for additional information regarding copyright
        // Normal upsert
        );  
        assertEquals(childRequests.get(0), upsertRequest);  
                .startObject()
import org.opensearch.common.xcontent.XContentHelper;  
        assertEquals(childRequests.get(0), docRequest);  
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
package org.opensearch.action.update;
        // Update with script
                    .field("param1", "value1")
            .timeout(randomTimeValue());  
        {
            updateRequest.upsert(new IndexRequest().source(source, xContentType));
        if (randomBoolean()) {
            return null;
        assertThat(params, notNullValue());
            }  
        ex = expectThrows(XContentParseException.class, () -> request2.fromXContent(unknownObject));
        request.fromXContent(
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
            UpdateRequest request = new UpdateRequest("index", null);
        scripts.put("ctx._timestamp = ctx._now", vars -> {
                    excludes[i] = randomAlphaOfLength(5);
        assertThat(script, notNullValue());
                    .startObject()
import org.opensearch.core.xcontent.XContentBuilder;  
            parsedUpdateRequest.fromXContent(parser);  
            createParser(  
                    .field("field1", "value1")  
        assertThat(((Map<String, Object>) doc.get("compound")).get("field2").toString(), equalTo("value2"));  
        assertThat(request.fetchSource().fetchSource(), equalTo(true));
        assertThat(request.fetchSource().excludes().length, equalTo(1));
                .endObject()  
        runTimeoutTest(getResult, updateRequest);
        assertThat(
import static org.hamcrest.CoreMatchers.hasItems;  
                XContentFactory.jsonBuilder()  
            )
        request = new UpdateRequest("test", "1").doc(docRequest).upsert(upsertRequest);
                    includes[i] = randomAlphaOfLength(5);  
            }
    }
        assertThat(  
        final GetResult getResult = new GetResult("test", "1", 0, 1, 0, true, new BytesArray("{\"f\":\"v\"}"), null, null);
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));  
    }
import org.opensearch.core.xcontent.XContentParseException;
 * ownership. Elasticsearch licenses this file to you under  
                    .startObject()
        UpdateRequest updateRequest = new UpdateRequest();
        IndexRequest docRequest = new IndexRequest("test").id("1");
import static org.hamcrest.CoreMatchers.not;
        childRequests = request.getChildIndexRequests();
    }
        req.script(mockInlineScript("return"));  
        getResult = new GetResult("test", "1", 0, 1, 0, true, null, fields, null);  
        }  
                    .endObject()
        // There is no routing and parent the indexing request
        childRequests = request.getChildIndexRequests();  
            assertThat(validate.validationErrors(), hasItems("id is missing"));  
        request = new UpdateRequest("test", "1");  
        }
            @SuppressWarnings("unchecked")
                    .endObject()
            ActionRequestValidationException validate = request.validate();
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", "path.inner.*").endObject()));
                    .startObject()
            @SuppressWarnings("unchecked")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        fields.put("_routing", new DocumentField("_routing", Collections.singletonList("routing1")));  
        assertEquals(childRequests.get(1), upsertRequest);  
            request,  
        assertThat(script, notNullValue());  
        assertThat(request.fetchSource().fetchSource(), equalTo(true));  
        request.fromXContent(
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.DELETED));  
        // There is no routing and parent on either request
    }  
    private UpdateHelper updateHelper;
 */  
        request = new UpdateRequest("test", "1").doc(docRequest).docAsUpsert(true);  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(result.action(), instanceOf(DeleteRequest.class));
        request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.field = \"foo\""));  
        assertThat(script.getIdOrCode(), equalTo("script1"));
        assertThat(params.size(), equalTo(1));  
                if (randomBoolean()) {  
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("script", "script1").endObject()));  
        assertThat(request.fetchSource().excludes()[0], equalTo("another.inner.*"));
                    .endObject()
        assertThat(request.doc().index(), equalTo("test"));
                    .endObject()
        assertThat(request.fetchSource(), notNullValue());  
        if (randomBoolean()) {
                    .startObject()
            int nbScriptParams = randomIntBetween(0, 5);
        request.fromXContent(createParser(XContentFactory.jsonBuilder().startObject().field("_source", true).endObject()));
        UpdateRequest request = new UpdateRequest("test", "1");
            assertThat(validate, nullValue());  
            .script(mockInlineScript("return"))
 * license agreements. See the NOTICE file distributed with
        if (goodNoop) {
        result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, false);
        boolean goodNoop = randomBoolean();  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(updateRequest.validate().validationErrors(), contains("can't provide version in upsert request"));  
import org.opensearch.common.document.DocumentField;  
                    .startObject("params")
            createParser(
                    .field("param1", "value1")
        UpdateRequest updateRequest = new UpdateRequest("index", "id");  
    }
            updateRequest.docAsUpsert(randomBoolean());  
        }  
        UpdateRequest request2 = new UpdateRequest("test", "1");
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
import static org.hamcrest.Matchers.contains;  
                    .field("field2", "value2")
 * not use this file except in compliance with the License.
            )  
        assertThat(script.getType(), equalTo(ScriptType.INLINE));  
import org.opensearch.test.RandomObjects;
            return null;
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");  
                    .endObject()
            IndexRequest indexAction = (IndexRequest) action;  
import static org.hamcrest.Matchers.instanceOf;
        Map<String, Object> params = script.getParams();  
    }  
        // Doc as upsert
        final Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            @SuppressWarnings("unchecked")
        result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, true);
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"foo\"}}"))
import org.opensearch.script.ScriptModule;
        assertThat(result.action(), instanceOf(IndexRequest.class));
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
    @SuppressWarnings("unchecked")
            updateRequest.script(new Script(scriptType, scriptLang, scriptIdOrCode, scriptParams));
        }
    }
        assertEquals(childRequests.get(0), docRequest);  
import org.opensearch.common.xcontent.json.JsonXContent;
        result = updateHelper.prepareUpdateScriptRequest(shardId, request, getResult, OpenSearchTestCase::randomNonNegativeLong);  
                updateRequest.fetchSource(randomBoolean());
        assertThat(script, notNullValue());
            UpdateHelper.Result result = updateHelper.prepare(new ShardId("test", "_na_", 0), updateRequest, getResult, () -> 42L);  
        scripts.put("ctx._source.body = \"foo\"", vars -> {
        assertNull(UpdateHelper.calculateRouting(getResult, indexRequest));  
import java.util.HashMap;
        }
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;  
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));  
        assertEquals(childRequests.size(), 0);  
            sourceBuilder.field("f", "v");
        UpdateRequest req = new UpdateRequest("index", "id");
        if (randomBoolean()) {  
import org.opensearch.script.Script;
        UpdateRequest updateRequest = new UpdateRequest("index", "id");  
                    + "doc[index {[test][null], source[{\"body\":\"bar\"}]}], scripted_upsert[false], detect_noop[true]}"  
        // There is no routing and parent because the document doesn't exist
import static org.hamcrest.Matchers.equalTo;
        assertEquals(updateRequest.detectNoop(), parsedUpdateRequest.detectNoop());
        UpdateRequest request = new UpdateRequest("test", "1");
    }
        request = new UpdateRequest("test", "1");  
        assertThat(params, notNullValue());
        });
        assertThat(
                    .startObject("params")  
        assertThat(params.get("param1").toString(), equalTo("value1"));
 *  
            ctx.put("op", "none");
        );
                    .startObject("script")
        assertThat(params, equalTo(emptyMap()));
        ).v2();
        Map<String, DocumentField> fields = new HashMap<>();
    }  
    }
        assertThat(params.size(), equalTo(1));
            )  
                    .endObject()  
            @SuppressWarnings("unchecked")  
    @Before
 * Unless required by applicable law or agreed to in writing,
            )
                .field("count", 1)
    }
        // script with params
        // Try again, with detectNoop turned off
        request.fromXContent(
 * this file be licensed under the Apache-2.0 license or a
                .script(mockInlineScript("ctx._source.update_timestamp = ctx._now"))
                    + "scripted_upsert[false], detect_noop[true]}"
        updateRequest.detectNoop(randomBoolean());  
        } else {
            .timeout(randomTimeValue());
import org.junit.Before;  
        params = script.getParams();
        params = script.getParams();
            String scriptLang = (scriptType != ScriptType.STORED) ? randomAlphaOfLength(10) : null;  
    }
            Writeable action = result.action();
            getResult,
        assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
                    .field("field1", "value1")
            UpdateRequest updateRequest = new UpdateRequest("test", "2").upsert(indexRequest)
            String scriptIdOrCode = randomAlphaOfLength(10);
            equalTo(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(result.updatedSourceAsMap().get("body").toString(), equalTo("foo"));
                    .startObject("script")  
        runTimeoutTest(getResult, updateRequest);  
        request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = delete"));
                    .startObject()  
        params = script.getParams();
    }
                for (int i = 0; i < excludes.length; i++) {  
            request.doc("{}", MediaTypeRegistry.JSON);
        assertEquals(updateRequest.scriptedUpsert(), parsedUpdateRequest.scriptedUpsert());
        result = updateHelper.prepareUpdateScriptRequest(shardId, request, getResult, OpenSearchTestCase::randomNonNegativeLong);
        });  
        assertThat(script, notNullValue());
                    .field("param1", "value1")
        childRequests = request.getChildIndexRequests();
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        assertThat(UpdateHelper.calculateRouting(getResult, indexRequest), equalTo("routing1"));  
        assertThat(upsertDoc.get("field1").toString(), equalTo("value1"));  
        UpdateRequest request = new UpdateRequest("test", "1").script(mockInlineScript("ctx._source.body = \"foo\""));
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));
    public void testValidate() {  
        request.fromXContent(
        boolean humanReadable = randomBoolean();
 * under the License.  
    public void testFromXContent() throws Exception {  
                    .field("includes", "path.inner.*")
            final Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
        final XContentBuilder sourceBuilder = jsonBuilder();
        request.fromXContent(
import org.opensearch.index.mapper.extrasource.BytesValue;
            )  
    public void setUp() throws Exception {
        } else {  
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"bar\"}}"))  
                    .startObject("params")  
import org.opensearch.script.ScriptService;
                    .endObject()
        updateRequest.setIfPrimaryTerm(1L);
            }  
            UpdateRequest updateRequest = new UpdateRequest("test", "2").upsert(indexRequest)  
            updateRequest.validate().validationErrors(),  
import org.opensearch.action.delete.DeleteRequest;  
            )
        childRequests = request.getChildIndexRequests();
        BytesReference originalBytes = toShuffledXContent(updateRequest, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
import org.opensearch.action.support.replication.ReplicationRequest;
    public void testFetchSourceParsing() throws Exception {  
        );  
                .endObject()
    public void testGetChildIndexRequests() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        runTimeoutTest(getResult, updateRequest);  
            XContentFactory.jsonBuilder()  
            createParser(JsonXContent.jsonXContent, new BytesArray("{\"doc\": {\"body\": \"bar\"}}"))  
    public void testUpsertTimeout() throws IOException {
        request.fromXContent(
        Map<String, ScriptEngine> engines = Collections.singletonMap(engine.getType(), engine);  
        updateRequest.doc("{}", MediaTypeRegistry.JSON);
import org.opensearch.core.xcontent.ToXContent;
                    .endObject()  
    }  
            source.put("body", "foo");
        updateRequest.doc("{}", MediaTypeRegistry.JSON);  
import org.opensearch.test.OpenSearchTestCase;
        // script with doc  
                .field("script", "ctx.op = ctx._source.views == params.count ? 'delete' : 'none'")
        updateRequest.upsert(new IndexRequest("index").id("1").version(1L));
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.NOOP));
        }  
            return null;
import org.opensearch.index.get.GetResult;
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));  
            request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = bad"));
                scriptParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        assertThat(e.validationErrors(), contains("ExtraFieldValues are not supported with scripted updates"));
            ScriptType scriptType = randomFrom(ScriptType.values());
        updateHelper = new UpdateHelper(scriptService);
                    .endObject()
        upsertDoc = XContentHelper.convertToMap(request.upsertRequest().source(), true, request.upsertRequest().getContentType()).v2();
import org.opensearch.core.index.shard.ShardId;  
                    .endObject()
                    .field("source", "script1")  
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;  
                String[] excludes = new String[randomIntBetween(0, 5)];
        upsert.extraFieldValues(new ExtraFieldValues(Map.of("k", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 })))));
 * the Apache License, Version 2.0 (the "License"); you may
                for (int i = 0; i < includes.length; i++) {
        final Writeable action = result.action();
                    .endObject()
            final Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        XContentType xContentType = randomFrom(XContentType.values());  
            final Map<String, Object> source = (Map<String, Object>) ctx.get("_source");  
        );
                    .endObject()
        // We treat everything else as a No-op
        assertThat(script.getType(), equalTo(ScriptType.INLINE));
        IndexRequest indexRequest = new IndexRequest("test").id("2").source(jsonBuilder().startObject().field("foo", "bar").endObject());  
        // Use the get result parent and routing
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        final BytesReference source = exists ? new BytesArray("{\"f\":\"v\"}") : null;  
                    .startObject("compound")
        XContentParser unknownObject = createParser(
                    .startObject("upsert")  
        XContentParser contentParser = createParser(XContentFactory.jsonBuilder().startObject().field("unknown_field", "test").endObject());
        ShardId shardId = new ShardId("test", "", 0);
            )  
        assertEquals(childRequests.size(), 0);
                    .endObject()
        IndexRequest indexRequest = new IndexRequest("test").id("1");  
                    .field("excludes", "another.inner.*")  
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));  
        assertThat(result.action(), instanceOf(IndexRequest.class));
import org.opensearch.env.Environment;  
        UpdateRequest request = new UpdateRequest("test", "1");  
    }
        scripts.put("ctx.op = none", vars -> {
        assertThat(((Map<String, Object>) upsertDoc.get("compound")).get("field2").toString(), equalTo("value2"));
        request = new UpdateRequest("test", "1").fromXContent(
        assertThat(request.fetchSource().includes().length, equalTo(0));
                .startObject("params")  
        {
        request = new UpdateRequest("test", "1");  
        assertThat(params.get("param1").toString(), equalTo("value1"));
    }
        request = new UpdateRequest("test", "1");
            request.toString(),
        assertThat(script.getIdOrCode(), equalTo("script1"));
            source.put("update_timestamp", ctx.get("_now"));
        assertThat(script.getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        UpdateHelper.Result result = updateHelper.prepareUpdateIndexRequest(shardId, request, getResult, true);
            request.upsertRequest().source(),
        BytesReference finalBytes = toXContent(parsedUpdateRequest, xContentType, humanReadable);
        );
    public void testNoopDetection() throws Exception {  
        );
        assertThat(script.getIdOrCode(), equalTo("script1"));  
                XContentFactory.jsonBuilder()
                    .endObject()
 * SPDX-License-Identifier: Apache-2.0
        sourceBuilder.endObject();
                    .startObject("compound")
        scripts.put("ctx.op = bad", vars -> {
        assertThat(request.fetchSource().fetchSource(), equalTo(true));  
        IndexRequest upsert = new IndexRequest("index").id("id").source("{\"f\":\"v\"}", MediaTypeRegistry.JSON);  
        assertThat(script.getIdOrCode(), equalTo("script1"));
        });  
                    .field("field1", "value1")
        assertThat(script.getIdOrCode(), equalTo("script1"));
                }
                    updateRequest.fetchSource(includes, excludes);
            request = new UpdateRequest("test", "1").script(mockInlineScript("ctx.op = none"));
            if (randomBoolean()) {
        // simple script
        assertEquals(childRequests.size(), 1);
import org.opensearch.core.xcontent.XContentParser;
        script = request.script();
        UpdateRequest request = new UpdateRequest("test", "1").fromXContent(
            Writeable action = result.action();
        }
        assertThat(request.upsertRequest().index(), equalTo("test"));  
                String[] includes = new String[randomIntBetween(0, 5)];
            @SuppressWarnings("unchecked")
        scripts.put("ctx.op = delete", vars -> {
        ActionRequestValidationException e = req.validate();
        assertThat(params.size(), equalTo(1));  
                    .startObject("script")
        });  
        assertThat(result.getResponseResult(), equalTo(DocWriteResponse.Result.UPDATED));  
