        getResponse = client().prepareGet().setIndex("test").setId("6").execute().actionGet();  
        }
        bulkResponse = client().prepareBulk()
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op = \"delete\"", Collections.emptyMap()))
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.get.GetResponse;
            .add(new UpdateRequest("bulkindex2", "2").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))
 */  
            )
        final BulkResponse[] responses = new BulkResponse[30];
        assertHitCount(countResponse, numDocs);
                .setId(Integer.toString(i))  
            .add(client().prepareUpdate("test", "1").setIfSeqNo(2L).setIfPrimaryTerm(1).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "3"))
        }
    public void testThatInvalidIndexNamesShouldNotBreakCompleteBulkRequest() {
            .add(new IndexRequest("test").id("5").source("{ \"title\" : \"Great Title of doc 5\" }", MediaTypeRegistry.JSON))  
            .add(new DeleteRequest("test", "6"))  
            assertThat(response.getItems()[i].getVersion(), equalTo(1L));
        for (BulkItemResponse bulkItemResponse : bulkResponse) {
        assertThat(bulkResponse.hasFailures(), is(true));
            .add(client().prepareUpdate("test", "2").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2"))
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest().indices(indexName).indexing(true);
                );
    public void testBulkUpdateSimple() throws Exception {
            threads[i].join();
            scripts.put("ctx._source.counter += 1", vars -> srcScript(vars, source -> {  
                assertThat(((Number) getResponse.getSource().get("counter")).longValue(), equalTo(1L));
            .add(client().prepareIndex("test").setId("e1").setSource("field", "2").setVersion(12).setVersionType(VersionType.EXTERNAL))  
                            Collections.emptyMap()
        }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));  
            .add(client().prepareUpdate("test", "e1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "3").setIfSeqNo(20L).setIfPrimaryTerm(1))  
            for (int j = 0; j < 5; j++) {  
        assertThat(bulkResponse.getItems()[0].getResponse().getSeqNo(), equalTo(0L));
            }
            .add(new IndexRequest("test").id("1").source("{ \"title\" : \"Great Title of doc 1\" }", MediaTypeRegistry.JSON))
        assertThat(bulkResponse.hasFailures(), is(true));  
        assertThat(response.getItems().length, equalTo(numDocs));
            if (i >= (numDocs / 2)) {
        assertThat(bulkResponse.getItems()[2].getResponse().getIndex(), equalTo("test"));  
            .get();
        BulkItemResponse[] responseItems = bulkResponse.getItems();
 * this work for additional information regarding copyright
        bulkRequest2.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))
 */
            .add(new UpdateRequest().index(indexName).id("1").detectNoop(true).doc("user", "xyz")) // noop update
            .add(new UpdateRequest().index(indexName).id("2").docAsUpsert(false).doc("f", "v")) // not_found update  
}  
            equalTo(2)
        assertThat(getResponse.isExists(), equalTo(true));  
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
        ensureGreen();
            if (!response.hasFailures()) {
            .add(client().prepareIndex().setIndex("INVALID.NAME").setId("1").setSource(Requests.INDEX_CONTENT_TYPE, "field", 1))
    }  
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
            .add(new UpdateRequest("bulkindex1", "1").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))
                return source.replace("counter", counter + 1);
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));  
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(responses.length);  
            .add(client().prepareIndex().setIndex("test").setId("2").setSource("field", 1))
            assertThat(itemResponse.getFailure(), nullValue());  
        assertThat(bulkResponse.getItems()[2].getFailure().getId(), equalTo("3"));
import org.opensearch.action.delete.DeleteRequest;  
                    .setFetchSource("field", null)
import org.opensearch.action.index.IndexResponse;  
        assertBusy(() -> assertAcked(client().admin().indices().prepareClose("bulkindex2")));
        assertThat(bulkResponse.getItems()[2].getResponse().getSeqNo(), equalTo(4L));
            .add(client().prepareIndex().setIndex("test").setId("3").setSource("field", 1))
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[0].getResponse().getResult());  
            }
            }  
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));  
        assertThat(response.getItems().length, equalTo(numDocs));
        }
    private static String indexOrAlias() {
        }  
                assertThat(response.getItems()[i].getVersion(), equalTo(3L));  
                            "throw script exception on unknown var",
            }));
        }
                Integer counter = (Integer) source.get("counter");
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));
import org.opensearch.transport.client.Requests;
                    .setScript(script)
                return source.replace("field", field + 1);  
        assertThat(bulkItemResponse.getItems()[5].getOpType(), is(OpType.DELETE));
            badIndexNames.add("INVALID.NAME" + i);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .actionGet();  
                assertThat(getResponse.isExists(), equalTo(false));
        }
            .get();  
        assertThat(bulkResponse.getItems().length, equalTo(3));
        for (int i = 0; i < responses.length; i++) {  
            assertThat(itemResponse.getId(), equalTo(Integer.toString(i)));  
        bulkResponse = client().prepareBulk()  
        final BulkItemResponse noopUpdate = bulkResponse.getItems()[0];
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
            .actionGet();
            )
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
            builder.add(updateBuilder);
        assertThat(response.hasFailures(), equalTo(false));  
        BulkResponse bulkResponse = builder.get();
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[0].getResponse().getResult());
                assertThat(getResponse.isExists(), equalTo(true));
        int maxDocs = numDocs / 2 + numDocs;
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("1").setSource("field", 1))  
import org.opensearch.common.settings.Settings;
        assertEquals(DocWriteResponse.Result.UPDATED, bulkResponse.getItems()[2].getResponse().getResult());
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));
import org.opensearch.indices.IndexClosedException;
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);  
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        for (int i = (numDocs / 2); i < maxDocs; i++) {
    }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
 * compatible open source license.
import org.opensearch.index.VersionType;
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
        }  
            BulkResponse response = builder.get();
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("5").setSource("field", 5))
        }  
import java.util.HashMap;
                    .setIndex(indexOrAlias())  
            .add(new IndexRequest("bulkindex2").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(2L));
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));
            assertThat(itemResponse.getIndex(), equalTo("test"));
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap());
        BulkResponse bulkResponse = client().prepareBulk()
        BulkRequestBuilder builder = client().prepareBulk();  
        final BulkItemResponse notFoundDelete = bulkResponse.getItems()[2];
        BulkRequestBuilder builder = client().prepareBulk();  
            });  
    public void testThatFailedUpdateRequestReturnsCorrectType() throws Exception {
        IndexResponse doc = index(indexName, "_doc", "1", Collections.singletonMap("user", "xyz"));
        builder = client().prepareBulk();
            .add(client().prepareIndex("test").setId("e1").setSource("field", "1").setVersion(10).setVersionType(VersionType.EXTERNAL))
            scripts.put("ctx.op = \"none\"", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "none"));
        int numDocs = scaledRandomIntBetween(100, 5000);  
            .get();
    public void testFailingVersionedUpdatedOnBulk() throws Exception {
        assertThat(response.getItems().length, equalTo(numDocs));
        assertThat(bulkResponse.getItems()[1].getResponse().getSeqNo(), equalTo(1L));
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertThat(bulkResponse.getItems()[1].getFailure().getMessage(), containsString("document missing"));
import static org.hamcrest.Matchers.equalTo;  
                updateBuilder.setDoc(jsonBuilder().startObject().field("counter", 2).endObject());
import static org.hamcrest.Matchers.is;
        assertThat(bulkResponse.getItems()[1].getFailure().getId(), equalTo("7"));  
                Integer field = (Integer) source.get("field");
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script).setRetryOnConflict(3))  
                    .setId("3")
    }
                responses[threadID] = requestBuilder.get();  
        assertThat(responseItems.length, is(3));
        String indexName = "test";
        assertThat(responseItems[2].getOpType(), is(OpType.DELETE));
                client().prepareUpdate()
            Strings.toString(MediaTypeRegistry.JSON, noopUpdate),
        for (int i = 0; i < bulkEntryCount; i++) {
            scripts.put("ctx._source.field2 = 'value2'", vars -> srcScript(vars, source -> source.replace("field2", "value2")));
package org.opensearch.action.bulk;
        response = builder.execute().actionGet();  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            }));  
                assertThat(response.getItems()[i].getFailure().getId(), equalTo(Integer.toString(id)));
        assertThat(bulkResponse.getItems()[1].getFailure().getIndex(), equalTo("test"));
            .add(new IndexRequest("bulkindex2").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op = \"none\"", Collections.emptyMap()))  
        createIndex("test");  
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap()))
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(2L));  
            }  
        assertThat(getResponse.isExists(), equalTo(true));  
        getResponse = client().prepareGet().setIndex("test").setId("7").execute().actionGet();
    // issue 6410
            .add(client().prepareIndex("test").setId("1").setSource("field", "2"))
        bulkRequest.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))
        BulkRequest bulkRequest = new BulkRequest();
                client().prepareUpdate()
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        assertThat(indicesStatsResponse.getIndex(indexName).getTotal().indexing.getTotal().getNoopUpdateCount(), equalTo(1L));
        for (int i = 0; i < numDocs; i++) {
    public void testBulkUpdateWithScriptedUpsertAndDynamicMappingUpdate() throws Exception {
                client().prepareUpdate()
import java.util.Arrays;
import org.opensearch.action.DocWriteResponse;
import java.util.ArrayList;  
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("2").setSource("field", 2).setCreate(true))
            .add(new DeleteRequest("bulkindex2", "3"))
                            ScriptType.INLINE,
        assertThat(bulkResponse.getItems()[0].getOpType(), is(OpType.INDEX));
    public void testThatMissingIndexDoesNotAbortFullBulkRequest() throws Exception {  
            } else {
            .get();
                GetResponse getResponse = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
                    .setScript(  
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(bulkResponse.getItems()[1].getResponse().getSeqNo(), equalTo(3L));  
            assertThat(response.getItems()[i].getItemId(), equalTo(i));
import static org.hamcrest.Matchers.nullValue;  
                builder.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("val", i));
        assertThat(bulkResponse.getItems()[2].getOpType(), is(OpType.DELETE));  
        int bulkEntryCount = randomIntBetween(10, 50);
import org.opensearch.action.update.UpdateRequestBuilder;
        assertThat(bulkItemResponse.getItems()[0].getOpType(), is(OpType.INDEX));
        assertThat(bulkResponse.getItems().length, is(3));  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
            .get();
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_replicas", replica)));
            assertThat(itemResponse.getItemId(), equalTo(i));
                            Collections.emptyMap()
                GetResponse getResponse = client().prepareGet("test", Integer.toString(i)).get();
            scripts.put("ctx._source.field += 1", vars -> srcScript(vars, source -> {
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("1").setScript(script))
        assertThat(getResponse.getVersion(), equalTo(1L));  
    }
        BulkResponse indexBulkItemResponse = client().prepareBulk()  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    }  
        assertThat(response.hasFailures(), equalTo(false));
/*  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);
import org.opensearch.action.admin.indices.alias.Alias;  
    // issue 4987  
            .add(
            .add(client().prepareUpdate().setIndex("INVALID.NAME").setId("1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", randomInt()))  
            assertThat(response.getItems()[i].getResponse().getId(), equalTo(Integer.toString(i)));
            for (int j = 0; j < 5; j++) {  
    public void testBulkIndexingWhileInitializing() throws Exception {
import org.opensearch.script.MockScriptPlugin;
                successes++;
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));
        BulkResponse bulkResponse = client().prepareBulk()
        for (int i = 0; i < numDocs; i++) {
        BulkResponse bulkResponse = client().bulk(bulkRequest).get();
                throw new ScriptException("message", null, Collections.emptyList(), "exception on unknown var", CustomScriptPlugin.NAME);
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));  
                BulkRequestBuilder requestBuilder = client().prepareBulk();
                    cyclicBarrier.await();
            return scripts;
        );
        assertThat(bulkResponse.getItems().length, equalTo(3));
            if (i % 3 == 0) {
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(3L));
        for (BulkItemResponse bulkItemResponse : bulkResponse) {  
        @Override
        assertThat(getResponse.isExists(), equalTo(false));  
        assertThat(bulkItemResponse.getItems()[4].getOpType(), is(OpType.DELETE));  
/*  
    }
        boolean[] expectedFailures = new boolean[bulkEntryCount];
                    .setIndex("test")
                client().prepareUpdate()  
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.script.ScriptType;
 * Unless required by applicable law or agreed to in writing,
        assertThat(bulkResponse.getItems().length, is(5));
                    .setScript(script)
            .add(new DeleteRequest("bulkindex1", "1"));  
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("3").setSource("field", 3))
        assertThat(bulkResponse.hasFailures(), is(expectFailure));  
                        .setIfPrimaryTerm(1)  
        assertThat(bulkResponse.getItems()[1].getResponse(), nullValue());
        createIndex("test");
            .execute()  
        assertThat(bulkItemResponse.getItems()[3].getOpType(), is(OpType.UPDATE));
    }  
        response = builder.execute().actionGet();
        assertThat(indicesStatsResponse.getIndex(indexName).getPrimaries().indexing.getTotal().getNoopUpdateCount(), equalTo(1L));
            scripts.put("throw script exception on unknown var", vars -> {
                    .setFetchSource("field", null)
        int bulk = scaledRandomIntBetween(1, 99);
        assertThat(response.getItems().length, equalTo(numDocs));
        BulkResponse response = builder.get();  
 *  
        Thread[] threads = new Thread[responses.length];
            .add(client().prepareUpdate("test", "1").setIfSeqNo(40L).setIfPrimaryTerm(20).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2"))  
        client().bulk(bulkRequest).get();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            Map<?, ?> ctx = (Map<?, ?>) vars.get("ctx");  
        assertHitCount(searchResponse, 3);  
        final BulkResponse bulkResponse = client().prepareBulk()
            );
        logger.info(bulkResponse.buildFailureMessage());
        refresh();
import org.opensearch.core.common.Strings;
            } else {  
            .add(new IndexRequest("bulkindex2").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
        BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.index.IndexRequest;
        assertThat(getResponse.isExists(), equalTo(true));
        bulkResponse = client().prepareBulk()
import org.opensearch.script.Script;
        SearchResponse searchResponse = client().prepareSearch("bulkindex*").get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }  
            .add(new IndexRequest("test").id("6").source("{ \"title\" : \"Great Title of doc 6\" }", MediaTypeRegistry.JSON))
        @SuppressWarnings("unchecked")
        index("test", "type", "1", "field", "1");
 * Modifications Copyright OpenSearch Contributors. See
            .add(
        assertThat(bulkResponse.hasFailures(), equalTo(false));  
        }
        assertThat(getResponse.getVersion(), equalTo(2L));
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(10L));  
            .add(new UpdateRequest("test", "3").doc("{ \"date\" : \"2014-01-30T23:59:57\"}", MediaTypeRegistry.JSON))  
                client().prepareUpdate().setIndex(indexOrAlias()).setId("1").setScript(script).setScriptedUpsert(true).setUpsert("field", 1)
        assertThat(bulkResponse.getItems()[0].getFailure().getId(), equalTo("1"));
            .get();
        }
        for (int i = 0; i < numDocs; i++) {
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));
        assertThat(bulkResponse.getItems()[1].getFailureMessage(), containsString("version conflict"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertThat(response.getItems()[i].getIndex(), equalTo("test"));
            }  
            .add(
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));  
                assertThat(response.getItems()[i].getFailure().getMessage(), containsString("document missing"));  
                    .setId(Integer.toString(i))  
            .get();  
        assertThat(doc.getShardInfo().getSuccessful(), equalTo(2));  
            }  
        response = builder.execute().actionGet();
        assertThat(getResponse.getVersion(), equalTo(2L));
        int successes = 0;
                    )
import static org.hamcrest.Matchers.containsString;
    // issue 9821
        assertThat(response.hasFailures(), equalTo(true));  
    public void testBulkWithCAS() throws Exception {
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build());
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        static Object srcScript(Map<String, Object> vars, Function<Map<String, Object>, Object> f) {
        assertThat(bulkResponse.getItems()[2].getResponse().getId(), equalTo("3"));  
            .add(new UpdateRequest("test", "4").doc("{ \"date\" : \"2014-13-30T23:59:57\"}", MediaTypeRegistry.JSON))
        assertThat(getResponse.getVersion(), equalTo(2L));  
                    .setFetchSource("field", null)
                }
            logger.info("bulk indexing {}-{}", i - bulk, i - 1);
            builder.add(
            )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
        response = builder.execute().actionGet();
        assertThat(response.hasFailures(), equalTo(false));
            .execute()
        assertNotNull(notFoundUpdate.getFailure());
        }  
        internalCluster().ensureAtLeastNumDataNodes(1 + replica);
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(0L));  
 * specific language governing permissions and limitations
        assertThat(bulkResponse.getItems()[2].getResponse(), nullValue());
        client().prepareIndex("bulkindex1").setId("1").setSource("text", "test").get();  
        assertThat(  
        BulkRequest bulkRequest2 = new BulkRequest();
import static org.hamcrest.Matchers.arrayWithSize;
        ensureGreen();  
        }
        assertThat(((UpdateResponse) bulkResponse.getItems()[1].getResponse()).getGetResult().sourceAsMap().get("field"), equalTo(2));
        GetResponse getResponse = client().prepareGet().setIndex("test").setId("1").execute().actionGet();
            }  
            });
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
        }
            .add(client().prepareIndex("test").setId("e2").setSource("field", "1").setVersion(10).setVersionType(VersionType.EXTERNAL))
                name = randomFrom(badIndexNames);
            );  
        ensureGreen(indexName);
        return randomBoolean() ? "test" : "alias";
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));
            .add(new IndexRequest("test").id("4").source("{ \"title\" : \"Great Title of doc 4\" }", MediaTypeRegistry.JSON))
        assertThat(getResponse.getVersion(), equalTo(1L));
                .setIndex("test")
            expectFailure |= expectedFailures[i] = randomBoolean();
        );
            assertThat(((UpdateResponse) response.getItems()[i].getResponse()).getGetResult().sourceAsMap().get("counter"), equalTo(1));
            )  
            } else {
            final BulkRequestBuilder builder = client().prepareBulk();  
                            CustomScriptPlugin.NAME,  
                name = "test";
public class BulkWithUpdatesIT extends OpenSearchIntegTestCase {
        assertThat(bulkResponse.getItems()[1].getFailure(), nullValue());  
        BulkResponse bulkItemResponse = client().prepareBulk()  
                client().prepareUpdate()
                    .setIndex("test")  
        assertThat(bulkResponse.getItems()[2].getResponse().getSeqNo(), equalTo(2L));  
    public void testFailedRequestsOnClosedIndex() throws Exception {  
 * GitHub history for details.
import java.util.Map;
                    .setId("2")  
        assertThat(getResponse.isExists(), equalTo(true));  
            .add(new DeleteRequest("test", "5"))
        assertThat(getResponse.getVersion(), equalTo(3L));
    public void testNoopUpdate() {  
        getResponse = client().prepareGet().setIndex("test").setId("3").execute().actionGet();
 * Licensed to Elasticsearch under one or more contributor  
            .get();  
            builder.add(client().prepareUpdate().setIndex("test").setId(Integer.toString(i)).setScript(script));  
import static org.hamcrest.Matchers.instanceOf;
    }
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));
            .actionGet();
            int id = i + (numDocs / 2);  
            scripts.put("ctx.op = \"delete\"", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));  
        bulkResponse = client().prepareBulk()  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bulkResponse.getItems().length, is(bulkEntryCount));
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);
        for (int i = randomIntBetween(1, 5); i > 0; i--) {  
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(10L));
            .add(new IndexRequest("test").id("2").source("{ \"title\" : \"Great Title of doc 2\" }", MediaTypeRegistry.JSON))
            final BulkItemResponse itemResponse = response.getItems()[i];
            assertThat(response.getItems()[i].getResponse().getVersion(), equalTo(1L));  
            assertThat(response.getItems()[i].getResponse().getVersion(), equalTo(2L));
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));
                    .setId("1")
            numDocs++; // this test needs an even num of docs
                    .setDoc(jsonBuilder().startObject().field("field1", "test").endObject())
                        .setDoc(Requests.INDEX_CONTENT_TYPE, "field", threadID)
        assertNoFailures(indexBulkItemResponse);
            )
import org.opensearch.action.DocWriteRequest.OpType;
 */  
            .add(  
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));  
                        new Script(
            assertThat(itemResponse.isFailed(), equalTo(false));
            noopUpdate.getResponse().getShardInfo().getSuccessful(),  
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        assertThat(noopUpdate.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOOP));  
        // test noop_update_total metric in stats changed
        }
        ensureGreen();  
                    client().prepareUpdate("test", "1")
        assertThat(bulkResponse.hasFailures(), equalTo(true));  
            .get();
        for (BulkResponse response : responses) {  
                    .setIndex("test")
            Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
                    .setUpsert(jsonBuilder().startObject().field("field", 0).endObject())  
        assertThat(getResponse.getVersion(), equalTo(1L));
        BulkResponse bulkResponse = client().prepareBulk()
 * The OpenSearch Contributors require contributions made to  
            .add(new UpdateRequest("bulkindex2", "2").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))  
                        .setIfSeqNo(0L)
        if (numDocs % 2 == 1) {  
        assertThat("expected no failures but got: " + response.buildFailureMessage(), response.hasFailures(), equalTo(false));
            assertThat(itemResponse.getOpType(), equalTo(OpType.UPDATE));
        assertThat(
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("6"));
        assertNoFailures(indexBulkItemResponse);  
        int numDocs = scaledRandomIntBetween(100, 2000);
    }  
import org.opensearch.plugins.Plugin;  
            .get();
 * license agreements. See the NOTICE file distributed with
                    .setUpsert(jsonBuilder().startObject().field("counter", 1).endObject())
                client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script).setScriptedUpsert(true).setUpsert("field", 1)
 *
import org.opensearch.script.ScriptException;  
import org.opensearch.action.update.UpdateResponse;
            UpdateRequestBuilder updateBuilder = client().prepareUpdate()
                client().prepareUpdate()
        for (int i = 0; i < threads.length; i++) {
            if (expectedFailures[i]) {
        assertThat(bulkItemResponse.getItems().length, is(6));
                    .setFetchSource("counter", null)  
    }
            );
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
        assertBusy(() -> assertAcked(client().admin().indices().prepareClose("bulkindex1")));
        assertThat(bulkResponse.getItems()[2].getResponse().getId(), equalTo("2"));
            .add(
        for (int i = 0; i < numDocs;) {
        builder = client().prepareBulk();  
                    .setIndex("test")  
                assertThat(getResponse.getVersion(), equalTo(1L));  
        }  
            builder.add(client().prepareIndex().setIndex(name).setId("1").setSource("field", 1));  
        BulkResponse bulkResponse = client().prepareBulk()
                    )
        assertThat(bulkResponse.getItems().length, equalTo(2));
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(12L));
        }
 * under the License.  
        for (BulkItemResponse bulkItemResponse : bulkResponse) {
        assertThat(bulkResponse.getItems()[0].getFailureMessage(), containsString("version conflict"));
            .add(  
            .execute()  
        for (int i = 0; i < numDocs; i++) {  
        assertThat(bulkResponse.getItems().length, equalTo(5));  
    }
    @Override
        assertThat(bulkResponse.getItems(), arrayWithSize(3));  
 * software distributed under the License is distributed on an
            .add(client().prepareUpdate("test", "e1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2").setIfSeqNo(10L).setIfPrimaryTerm(1))
                        )  
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));  
    }  
        assertThat(bulkItemResponse.getItems()[2].getOpType(), is(OpType.UPDATE));
            .get();
        ArrayList<String> badIndexNames = new ArrayList<>();
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script))  
        assertThat(bulkResponse.hasFailures(), equalTo(false));  
            .add(new DeleteRequest("bulkindex2", "3"))  
        assertThat(getResponse.isExists(), equalTo(true));
        boolean expectFailure = false;  
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
        assertThat(notFoundDelete.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOT_FOUND));
import java.util.Collections;  
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));  
    }  
        builder = client().prepareBulk();
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[1].getResponse().getResult());  
            .add(client().prepareIndex().setIndex("test").setId("1").setSource("field", 1))  
                        )  
                    .setId(Integer.toString(i))
import org.opensearch.test.InternalSettingsPlugin;
        bulkResponse = client().prepareBulk()
        assertThat(getResponse.getSource().get("field1").toString(), equalTo("test"));
        bulkRequest.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))  
                try {  
        for (int i = 0; i < numDocs; i++) {  
            .add(client().prepareDelete().setIndex("INVALID.NAME").setId("1"))
                            CustomScriptPlugin.NAME,  
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));  
    public void testBulkUpdateLargerVolume() throws Exception {
            assertThat(response.getItems()[i].getVersion(), equalTo(2L));
        createIndex("bulkindex1", "bulkindex2");
        assertThat(responseItems[2].getFailure().getCause(), instanceOf(IndexClosedException.class));
                    .setScript(  
        assertThat(getResponse.isExists(), equalTo(true));
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
        assertThat(getResponse.isExists(), equalTo(true));
        for (int i = 0; i < bulkEntryCount; i++) {
            .add(client().prepareIndex("test").setId("2").setCreate(true).setSource("field", "1"))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        createIndex("test");
            .add(new DeleteRequest().index(indexName).id("2")) // not_found delete
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            )  
                    .setId(Integer.toString(i))
        for (int i = 0; i < numDocs; i++) {  
        @SuppressWarnings("unchecked")  
                    .setId("6")
import java.util.concurrent.CyclicBarrier;  
                assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(id)));
    }
            return f.apply(source);  
                    .setId("3")
        }
        assertThat(bulkResponse.getItems().length, equalTo(3));
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[1].getResponse().getResult());
            builder.add(  
            equalTo(2)  
        GetResponse getResponse = client().prepareGet().setIndex("test").setId("1").execute().actionGet();  
        internalCluster().ensureAtLeastNumDataNodes(2);  
                            "throw script exception on unknown var",
                updateBuilder.setRetryOnConflict(3);
        assertThat(responseItems[0].getOpType(), is(OpType.INDEX));  
        builder = client().prepareBulk();  
        bulkResponse = client().prepareBulk()  
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.counter += 1", Collections.emptyMap());
            if (i % 2 == 0) {
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
        }
        assertThat(responseItems[0].getFailure().getCause(), instanceOf(IndexClosedException.class));
        assertThat(bulkResponse.getItems()[0].getFailure().getMessage(), containsString("failed to execute script"));  
                    return;  
import java.util.function.Function;
/*
                        new Script(
                    .setIndex("test")
            .add(  
                    .setIndex(indexOrAlias())  
                            ScriptType.INLINE,
            assertThat(((UpdateResponse) response.getItems()[i].getResponse()).getGetResult().sourceAsMap().get("counter"), equalTo(2));  
        assertThat(successes, equalTo(1));  
    public void testBulkUpdateMalformedScripts() throws Exception {
            threads[threadID].start();  
    public void testInvalidIndexNamesCorrectOpType() {  
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap());  
                    .setIndex("test")
                fail(response.buildFailureMessage());
        BulkResponse bulkResponse = client().bulk(bulkRequest2).get();  
        for (int i = 0; i < numDocs; i++) {
    }
            notFoundDelete.getResponse().getShardInfo().getSuccessful(),
    // issue 6630
            assertThat(bulkResponse.getItems()[i].isFailed(), is(expectedFailures[i]));  
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(3L));
    // issue 9821
                assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
        assertThat(responseItems[1].getOpType(), is(OpType.UPDATE));
        assertEquals(DocWriteResponse.Result.UPDATED, bulkResponse.getItems()[2].getResponse().getResult());
import org.opensearch.action.search.SearchResponse;
            assertThat(response.getItems()[i].getResponse().getId(), equalTo(Integer.toString(i)));
        ensureGreen();  
            }  
        assertThat(bulkResponse.getItems()[1].getOpType(), is(OpType.UPDATE));
        assertThat(bulkResponse.getItems()[0].getResponse(), nullValue());
                requestBuilder.add(  
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("4").setSource("field", 4))  
                updateBuilder.setScript(script);  
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("7").setScript(script))
            Strings.toString(MediaTypeRegistry.JSON, notFoundDelete),
        final IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).actionGet();  
        assertThat(response.buildFailureMessage(), response.hasFailures(), equalTo(false));
            )
        int replica = randomInt(2);  
        assertThat(bulkResponse.getItems().length, equalTo(3));
        assertThat(bulkResponse.getItems()[2].getFailure().getMessage(), containsString("failed to execute script"));  
        final BulkItemResponse notFoundUpdate = bulkResponse.getItems()[1];
 *
            for (int j = 0; j < bulk && i < numDocs; j++, i++) {
                } catch (Exception e) {
                .setFetchSource("counter", null);
        assertThat(bulkResponse.hasFailures(), equalTo(true));  
        assertThat(response.getItems().length, equalTo(numDocs));  
            threads[threadID] = new Thread(() -> {
import org.opensearch.action.update.UpdateRequest;  
            String name;  
                client().prepareUpdate()
import java.util.Collection;
            builder.add(
        assertThat(bulkResponse.getItems()[0].getFailureMessage(), containsString("version conflict"));  
        createIndex("bulkindex1");
 * not use this file except in compliance with the License.
            .add(new IndexRequest("bulkindex2").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))  
            final int threadID = i;
                client().prepareUpdate()  
        BulkResponse bulkResponse = client().prepareBulk()
        }
        }
        assertThat(bulkItemResponse.getItems()[1].getOpType(), is(OpType.INDEX));  
            .add(new IndexRequest("test").id("3").source("{ \"title\" : \"Great Title of doc 3\" }", MediaTypeRegistry.JSON))
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(1L));  
            .add(client().prepareIndex("test").setId("1").setCreate(true).setSource("field", "1"))
        ensureGreen();  
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(4L));
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));  
            if (response.hasFailures()) {  
            }
        assertThat(responseItems[1].getFailure().getCause(), instanceOf(IndexClosedException.class));  
