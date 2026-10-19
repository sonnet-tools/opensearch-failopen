 * this file be licensed under the Apache-2.0 license or a
            .add(
        assertThat(((UpdateResponse) bulkResponse.getItems()[1].getResponse()).getGetResult().sourceAsMap().get("field"), equalTo(2));
                GetResponse getResponse = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
        }
            if (i % 3 == 0) {
            .add(new IndexRequest("bulkindex2").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
        for (int i = (numDocs / 2); i < maxDocs; i++) {
        assertThat(bulkResponse.hasFailures(), is(expectFailure));
import java.util.Collections;
        getResponse = client().prepareGet().setIndex("test").setId("3").execute().actionGet();
            threads[threadID].start();
        assertHitCount(countResponse, numDocs);
        }
                client().prepareUpdate()
        }
            builder.add(
/*
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));
        assertHitCount(searchResponse, 3);
    // issue 9821
        assertThat(getResponse.isExists(), equalTo(true));
                    .setIndex("test")
            .add(client().prepareUpdate("test", "e1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "3").setIfSeqNo(20L).setIfPrimaryTerm(1))
        assertThat(getResponse.getVersion(), equalTo(3L));
        }
            .add(new UpdateRequest("bulkindex1", "1").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))
                    .setFetchSource("counter", null)
            builder.add(client().prepareIndex().setIndex(name).setId("1").setSource("field", 1));
                assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
import java.util.Collection;
    }
            assertThat(itemResponse.getItemId(), equalTo(i));
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));
            final int threadID = i;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        )
            .add(new IndexRequest("bulkindex2").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
        ensureGreen();
import org.opensearch.script.ScriptException;
            .add(new DeleteRequest("bulkindex1", "1"));
        assertThat(bulkResponse.getItems().length, equalTo(3));
        for (BulkItemResponse bulkItemResponse : bulkResponse) {
            assertThat(response.getItems()[i].getResponse().getVersion(), equalTo(1L));
        for (int i = 0; i < numDocs; i++) {
        bulkRequest.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))
                    .setIndex("test")
                updateBuilder.setScript(script);
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);
        }
                    cyclicBarrier.await();
            .add(
            )
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));
        }
            }
    public void testFailedRequestsOnClosedIndex() throws Exception {
    // issue 9821
            .add(
            noopUpdate.getResponse().getShardInfo().getSuccessful(),
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
            .add(new IndexRequest("test").id("1").source("{ \"title\" : \"Great Title of doc 1\" }", MediaTypeRegistry.JSON))
                    .setFetchSource("field", null)
            .actionGet();
                name = "test";
            Map<?, ?> ctx = (Map<?, ?>) vars.get("ctx");
        assertThat(bulkItemResponse.getItems().length, is(6));
 *
            scripts.put("ctx._source.counter += 1", vars -> srcScript(vars, source -> {
        ArrayList<String> badIndexNames = new ArrayList<>();
        assertThat(getResponse.isExists(), equalTo(true));
            scripts.put("ctx._source.field += 1", vars -> srcScript(vars, source -> {
            .get();
                Integer counter = (Integer) source.get("counter");
    public void testBulkWithCAS() throws Exception {
                    .setScript(
        }
        assertThat(bulkItemResponse.getItems()[5].getOpType(), is(OpType.DELETE));
    public void testInvalidIndexNamesCorrectOpType() {
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.counter += 1", Collections.emptyMap());
        for (int i = 0; i < bulkEntryCount; i++) {
            }
        for (int i = randomIntBetween(1, 5); i > 0; i--) {
        bulkResponse = client().prepareBulk()
        assertEquals(DocWriteResponse.Result.UPDATED, bulkResponse.getItems()[2].getResponse().getResult());
        assertThat(bulkResponse.getItems()[0].getFailureMessage(), containsString("version conflict"));
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));
                assertThat(response.getItems()[i].getIndex(), equalTo("test"));
        assertThat(bulkResponse.hasFailures(), equalTo(true));
        }
        int numDocs = scaledRandomIntBetween(100, 2000);
        createIndex("bulkindex1");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            assertThat(response.getItems()[i].getResponse().getId(), equalTo(Integer.toString(i)));
        BulkRequest bulkRequest2 = new BulkRequest();
        bulkResponse = client().prepareBulk()
                client().prepareUpdate()
        BulkResponse bulkResponse = client().prepareBulk()
    }
        final BulkItemResponse noopUpdate = bulkResponse.getItems()[0];
            );
                    .setId("1")
            .add(client().prepareIndex("test").setId("1").setSource("field", "2"))
    }
        assertThat(bulkResponse.getItems()[2].getResponse().getIndex(), equalTo("test"));
        assertThat(bulkItemResponse.getItems()[1].getOpType(), is(OpType.INDEX));
        assertThat(responseItems[0].getFailure().getCause(), instanceOf(IndexClosedException.class));
        }
            builder.add(updateBuilder);
        assertThat(response.getItems().length, equalTo(numDocs));
        assertThat(bulkResponse.getItems()[2].getOpType(), is(OpType.DELETE));
        getResponse = client().prepareGet().setIndex("test").setId("7").execute().actionGet();
                );
        assertThat(bulkResponse.getItems()[2].getResponse().getSeqNo(), equalTo(4L));
        assertThat(bulkResponse.getItems()[1].getFailure().getId(), equalTo("7"));
import org.opensearch.action.index.IndexRequest;
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE);
 * The OpenSearch Contributors require contributions made to
        assertThat(response.getItems().length, equalTo(numDocs));
            .add(client().prepareUpdate("test", "1").setIfSeqNo(40L).setIfPrimaryTerm(20).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2"))
        createIndex("test");
                Integer field = (Integer) source.get("field");
                    .setId(Integer.toString(i))
        builder = client().prepareBulk();
        for (int i = 0; i < numDocs; i++) {
    }
            .add(new IndexRequest("bulkindex2").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
 * SPDX-License-Identifier: Apache-2.0
            badIndexNames.add("INVALID.NAME" + i);
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));
                assertThat(response.getItems()[i].getFailure().getMessage(), containsString("document missing"));
                            CustomScriptPlugin.NAME,
            .add(client().prepareIndex("test").setId("e2").setSource("field", "1").setVersion(10).setVersionType(VersionType.EXTERNAL))
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
            .add(new IndexRequest("test").id("6").source("{ \"title\" : \"Great Title of doc 6\" }", MediaTypeRegistry.JSON))
        assertThat(successes, equalTo(1));
    public void testThatMissingIndexDoesNotAbortFullBulkRequest() throws Exception {
    }
        assertThat(bulkResponse.getItems()[2].getResponse().getId(), equalTo("3"));
            String name;
                client().prepareUpdate()
        for (BulkResponse response : responses) {
import java.util.Map;
        final BulkItemResponse notFoundUpdate = bulkResponse.getItems()[1];
        internalCluster().ensureAtLeastNumDataNodes(2);
        boolean expectFailure = false;
import static org.hamcrest.Matchers.is;
        int bulkEntryCount = randomIntBetween(10, 50);
    public void testBulkUpdateSimple() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(getResponse.getVersion(), equalTo(2L));
        BulkItemResponse[] responseItems = bulkResponse.getItems();
            numDocs++; // this test needs an even num of docs
                    .setId("3")
                assertThat(getResponse.getVersion(), equalTo(1L));
    }
        assertThat(bulkResponse.getItems()[0].getFailureMessage(), containsString("version conflict"));
            .add(new IndexRequest("test").id("2").source("{ \"title\" : \"Great Title of doc 2\" }", MediaTypeRegistry.JSON))
        IndexResponse doc = index(indexName, "_doc", "1", Collections.singletonMap("user", "xyz"));
                    .setScript(
import org.opensearch.test.InternalSettingsPlugin;
                return source.replace("counter", counter + 1);
        assertThat(
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));
            builder.add(
        @SuppressWarnings("unchecked")
                        .setIfPrimaryTerm(1)
        if (numDocs % 2 == 1) {
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
            final BulkRequestBuilder builder = client().prepareBulk();
                client().prepareUpdate().setIndex(indexOrAlias()).setId("1").setScript(script).setScriptedUpsert(true).setUpsert("field", 1)
                client().prepareUpdate()
 */
            if (i >= (numDocs / 2)) {
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[1].getResponse().getResult());
        assertBusy(() -> assertAcked(client().admin().indices().prepareClose("bulkindex2")));
            )
                requestBuilder.add(
            assertThat(response.getItems()[i].getItemId(), equalTo(i));
        assertThat(indicesStatsResponse.getIndex(indexName).getTotal().indexing.getTotal().getNoopUpdateCount(), equalTo(1L));
        for (int i = 0; i < numDocs; i++) {
            );
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[0].getResponse().getResult());
            threads[threadID] = new Thread(() -> {
import java.util.HashMap;
        assertThat(bulkResponse.getItems()[0].getFailure().getMessage(), containsString("failed to execute script"));
        assertThat(bulkResponse.getItems().length, equalTo(3));
import org.opensearch.action.search.SearchResponse;
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
 *
            .actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
                .setFetchSource("counter", null);
            .get();
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (int i = 0; i < numDocs; i++) {
                assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(id)));
            scripts.put("ctx.op = \"none\"", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "none"));
        assertThat(bulkResponse.getItems()[2].getResponse(), nullValue());
        }
    // issue 4987
import org.opensearch.cluster.metadata.IndexMetadata;
            assertThat(response.getItems()[i].getResponse().getVersion(), equalTo(2L));
            .add(
        assertThat(bulkResponse.hasFailures(), equalTo(false));
            } else {
        assertThat(bulkResponse.getItems()[2].getResponse().getSeqNo(), equalTo(2L));
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(bulkItemResponse.getItems()[2].getOpType(), is(OpType.UPDATE));
            assertThat(response.getItems()[i].getVersion(), equalTo(1L));
                .setId(Integer.toString(i))
        final IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).actionGet();
        assertThat(notFoundDelete.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOT_FOUND));
        bulkResponse = client().prepareBulk()
                return source.replace("field", field + 1);
        assertThat(bulkResponse.getItems()[2].getFailure().getMessage(), containsString("failed to execute script"));
        final BulkItemResponse notFoundDelete = bulkResponse.getItems()[2];
                        .setDoc(Requests.INDEX_CONTENT_TYPE, "field", threadID)
        for (int i = 0; i < numDocs; i++) {
        client().bulk(bulkRequest).get();
            scripts.put("ctx._source.field2 = 'value2'", vars -> srcScript(vars, source -> source.replace("field2", "value2")));
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
                    client().prepareUpdate("test", "1")
            .add(client().prepareIndex().setIndex("INVALID.NAME").setId("1").setSource(Requests.INDEX_CONTENT_TYPE, "field", 1))
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(bulkResponse.hasFailures(), is(true));
        assertThat(bulkResponse.getItems()[1].getFailure().getIndex(), equalTo("test"));
 * GitHub history for details.
                assertThat(((Number) getResponse.getSource().get("counter")).longValue(), equalTo(1L));
import java.util.function.Function;
}
        assertThat(bulkResponse.getItems()[1].getFailureMessage(), containsString("version conflict"));
            scripts.put("throw script exception on unknown var", vars -> {
                GetResponse getResponse = client().prepareGet("test", Integer.toString(i)).get();
import static org.hamcrest.Matchers.nullValue;
        assertThat(response.hasFailures(), equalTo(false));
            .add(client().prepareUpdate().setIndex("INVALID.NAME").setId("1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", randomInt()))
        for (int i = 0; i < numDocs; i++) {
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(10L));
        assertThat(responseItems[0].getOpType(), is(OpType.INDEX));
        assertThat(bulkResponse.getItems(), arrayWithSize(3));
                            "throw script exception on unknown var",
            equalTo(2)
                            Collections.emptyMap()
            .add(
                responses[threadID] = requestBuilder.get();
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap());
        assertEquals(DocWriteResponse.Result.UPDATED, bulkResponse.getItems()[2].getResponse().getResult());
                client().prepareUpdate()
            .add(client().prepareUpdate("test", "2").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2"))
            if (expectedFailures[i]) {
        static Object srcScript(Map<String, Object> vars, Function<Map<String, Object>, Object> f) {
 * Licensed to Elasticsearch under one or more contributor
        assertNoFailures(indexBulkItemResponse);
                            ScriptType.INLINE,
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(responseItems[1].getFailure().getCause(), instanceOf(IndexClosedException.class));
        bulkResponse = client().prepareBulk()
                        new Script(
 *
        getResponse = client().prepareGet().setIndex("test").setId("6").execute().actionGet();
                builder.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("val", i));
        }
import static org.hamcrest.Matchers.containsString;
    public void testFailingVersionedUpdatedOnBulk() throws Exception {
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
            .add(new UpdateRequest("test", "3").doc("{ \"date\" : \"2014-01-30T23:59:57\"}", MediaTypeRegistry.JSON))
                client().prepareUpdate()
                    .setFetchSource("field", null)
    public void testBulkUpdateMalformedScripts() throws Exception {
import org.opensearch.action.index.IndexResponse;
        BulkResponse bulkItemResponse = client().prepareBulk()
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_replicas", replica)));
import org.opensearch.action.get.GetResponse;
        assertThat(bulkResponse.getItems().length, is(5));
                            Collections.emptyMap()
            }
            return scripts;
        GetResponse getResponse = client().prepareGet().setIndex("test").setId("1").execute().actionGet();
        }
        }
    public void testBulkUpdateWithScriptedUpsertAndDynamicMappingUpdate() throws Exception {
            .add(new UpdateRequest().index(indexName).id("1").detectNoop(true).doc("user", "xyz")) // noop update
            UpdateRequestBuilder updateBuilder = client().prepareUpdate()
        BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(RefreshPolicy.IMMEDIATE);
 * ownership. Elasticsearch licenses this file to you under
        final Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap());
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[0].getResponse().getResult());
            .add(new UpdateRequest("bulkindex2", "2").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))
            .add(new DeleteRequest("test", "6"))
    }
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op = \"none\"", Collections.emptyMap()))
                } catch (Exception e) {
    }
        assertThat(response.getItems().length, equalTo(numDocs));
 */
            .add(new UpdateRequest("test", "4").doc("{ \"date\" : \"2014-13-30T23:59:57\"}", MediaTypeRegistry.JSON))
                    )
            BulkResponse response = builder.get();
        final BulkResponse bulkResponse = client().prepareBulk()
                    .setId("6")
                    .setIndex("test")
            expectFailure |= expectedFailures[i] = randomBoolean();
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("2").setSource("field", 2).setCreate(true))
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(0L));
        assertThat(responseItems[2].getOpType(), is(OpType.DELETE));
                    .setId(Integer.toString(i))
        assertThat(getResponse.isExists(), equalTo(true));
        internalCluster().ensureAtLeastNumDataNodes(1 + replica);
                client().prepareUpdate()
            }
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        response = builder.execute().actionGet();
    public void testBulkUpdateLargerVolume() throws Exception {
        response = builder.execute().actionGet();
            .add(
        assertThat(bulkResponse.getItems().length, equalTo(2));
        builder = client().prepareBulk();
            .add(new UpdateRequest().index(indexName).id("2").docAsUpsert(false).doc("f", "v")) // not_found update
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));
        assertThat(response.hasFailures(), equalTo(false));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertThat(itemResponse.getId(), equalTo(Integer.toString(i)));
                    .setIndex(indexOrAlias())
        assertThat(bulkResponse.getItems()[1].getResponse(), nullValue());
        }
/*
                            ScriptType.INLINE,
        assertThat(bulkResponse.getItems()[1].getFailure().getMessage(), containsString("document missing"));
            }));
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
            .add(client().prepareIndex().setIndex("test").setId("3").setSource("field", 1))
        bulkResponse = client().prepareBulk()
        }
        return randomBoolean() ? "test" : "alias";
        builder = client().prepareBulk();
 * Unless required by applicable law or agreed to in writing,
        assertThat(bulkResponse.getItems()[2].getFailure().getId(), equalTo("3"));
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.transport.client.Requests;
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx._source.field += 1", Collections.emptyMap()))
                        new Script(
            });
            }
 * compatible open source license.
                assertThat(response.getItems()[i].getFailure().getId(), equalTo(Integer.toString(id)));
                        .setIfSeqNo(0L)
        assertThat(getResponse.getVersion(), equalTo(1L));
            });
    }
            assertThat(response.getItems()[i].getOpType(), equalTo(OpType.UPDATE));
        GetResponse getResponse = client().prepareGet().setIndex("test").setId("1").execute().actionGet();
            )
            if (!response.hasFailures()) {
        assertThat(bulkItemResponse.getItems()[3].getOpType(), is(OpType.UPDATE));
        assertThat(bulkResponse.getItems().length, equalTo(3));
        int numDocs = scaledRandomIntBetween(100, 5000);
            assertThat(itemResponse.isFailed(), equalTo(false));
        @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.arrayWithSize;
        assertThat(
        assertThat(getResponse.getVersion(), equalTo(2L));
                successes++;
        builder = client().prepareBulk();
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(3L));
                    .setUpsert(jsonBuilder().startObject().field("counter", 1).endObject())
        index("test", "type", "1", "field", "1");
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(responses.length);
 */
            assertThat(response.getItems()[i].getResponse().getId(), equalTo(Integer.toString(i)));
        }
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        assertNoFailures(indexBulkItemResponse);
        for (int i = 0; i < threads.length; i++) {
    public void testBulkIndexingWhileInitializing() throws Exception {
            .add(client().prepareIndex().setIndex("test").setId("2").setSource("field", 1))
        assertEquals(DocWriteResponse.Result.CREATED, bulkResponse.getItems()[1].getResponse().getResult());
        String indexName = "test";
    }
            .execute()
        assertThat(getResponse.getVersion(), equalTo(1L));
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script))
            .add(new IndexRequest("test").id("5").source("{ \"title\" : \"Great Title of doc 5\" }", MediaTypeRegistry.JSON))
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            .execute()
            assertThat(itemResponse.getIndex(), equalTo("test"));
            }
    @Override
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
    }
        }
            assertThat(response.getItems()[i].getIndex(), equalTo("test"));
                        )
        createIndex("test");
        assertThat(responseItems[1].getOpType(), is(OpType.UPDATE));
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("2"));
            Strings.toString(MediaTypeRegistry.JSON, notFoundDelete),
import org.opensearch.core.common.Strings;
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));
                    .setIndex("test")
                }
        BulkRequestBuilder builder = client().prepareBulk();
        assertThat(getResponse.getVersion(), equalTo(2L));
import static org.hamcrest.Matchers.equalTo;
                    )
        assertThat(bulkResponse.getItems()[1].getResponse().getSeqNo(), equalTo(1L));
        for (int i = 0; i < numDocs; i++) {
            .add(new DeleteRequest().index(indexName).id("2")) // not_found delete
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("6"));
                    .setDoc(jsonBuilder().startObject().field("field1", "test").endObject())
            .get();
            .actionGet();
        boolean[] expectedFailures = new boolean[bulkEntryCount];
        BulkResponse bulkResponse = client().prepareBulk()
            equalTo(2)
        assertNotNull(notFoundUpdate.getFailure());
        @Override
            assertThat(((UpdateResponse) response.getItems()[i].getResponse()).getGetResult().sourceAsMap().get("counter"), equalTo(2));
            .execute()
            .add(new IndexRequest("bulkindex2").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo2"))
        final BulkResponse[] responses = new BulkResponse[30];
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script).setRetryOnConflict(3))
            builder.add(client().prepareUpdate().setIndex("test").setId(Integer.toString(i)).setScript(script));
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(10L));
        assertThat(bulkResponse.getItems()[0].getResponse().getSeqNo(), equalTo(0L));
    }
            .add(client().prepareIndex("test").setId("e1").setSource("field", "1").setVersion(10).setVersionType(VersionType.EXTERNAL))
                            CustomScriptPlugin.NAME,
            for (int j = 0; j < bulk && i < numDocs; j++, i++) {
            .add(client().prepareIndex("test").setId("2").setCreate(true).setSource("field", "1"))
            Strings.toString(MediaTypeRegistry.JSON, noopUpdate),
            assertThat(bulkResponse.getItems()[i].isFailed(), is(expectedFailures[i]));
import org.opensearch.action.update.UpdateRequest;
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("1").setScript(script))
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));
                    .setScript(script)
            }
            if (i % 2 == 0) {
            assertThat(itemResponse.getOpType(), equalTo(OpType.UPDATE));
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("5").setSource("field", 5))
        assertBusy(() -> assertAcked(client().admin().indices().prepareClose("bulkindex1")));
        Thread[] threads = new Thread[responses.length];
            .add(client().prepareDelete().setIndex("INVALID.NAME").setId("1"))
import org.opensearch.common.settings.Settings;
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest().indices(indexName).indexing(true);
        for (int i = 0; i < responses.length; i++) {
            assertThat(response.getItems()[i].getVersion(), equalTo(2L));
        );
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        ensureGreen();
import org.opensearch.script.MockScriptPlugin;
    private static String indexOrAlias() {
                    .setScript(script)
            logger.info("bulk indexing {}-{}", i - bulk, i - 1);
/*
        assertThat(bulkResponse.hasFailures(), equalTo(true));
            .add(
    // issue 6630
            }
    // issue 6410
                    .setIndex(indexOrAlias())
                BulkRequestBuilder requestBuilder = client().prepareBulk();
            } else {
        response = builder.execute().actionGet();
            .add(new DeleteRequest("test", "5"))
            }));
 * not use this file except in compliance with the License.
package org.opensearch.action.bulk;
    public static class CustomScriptPlugin extends MockScriptPlugin {
import org.opensearch.action.update.UpdateRequestBuilder;
            for (int j = 0; j < 5; j++) {
import org.opensearch.index.VersionType;
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("3").setSource("field", 3))
                try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        bulkRequest2.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(2L));
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .add(new IndexRequest("test").id("3").source("{ \"title\" : \"Great Title of doc 3\" }", MediaTypeRegistry.JSON))
                fail(response.buildFailureMessage());
        assertThat(bulkResponse.getItems().length, is(3));
        assertThat(bulkResponse.getItems()[1].getOpType(), is(OpType.UPDATE));
 * this work for additional information regarding copyright
            notFoundDelete.getResponse().getShardInfo().getSuccessful(),
                client().prepareUpdate().setIndex(indexOrAlias()).setId("2").setScript(script).setScriptedUpsert(true).setUpsert("field", 1)
        BulkRequestBuilder builder = client().prepareBulk();
import org.opensearch.indices.IndexClosedException;
                    .setUpsert(jsonBuilder().startObject().field("field", 0).endObject())
            .get();
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(1L));
                    .setFetchSource("field", null)
        assertThat(getResponse.isExists(), equalTo(true));
        assertThat(response.buildFailureMessage(), response.hasFailures(), equalTo(false));
        response = builder.execute().actionGet();
                assertThat(getResponse.isExists(), equalTo(false));
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("1").setSource("field", 1))
        for (BulkItemResponse bulkItemResponse : bulkResponse) {
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));
        createIndex("bulkindex1", "bulkindex2");
        assertThat(bulkResponse.getItems()[0].getFailure().getId(), equalTo("1"));
        assertThat(getResponse.getVersion(), equalTo(1L));
public class BulkWithUpdatesIT extends OpenSearchIntegTestCase {
            )
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
        assertThat(getResponse.isExists(), equalTo(true));
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
            )
                            "throw script exception on unknown var",
        for (BulkItemResponse bulkItemResponse : bulkResponse) {
    public void testThatFailedUpdateRequestReturnsCorrectType() throws Exception {
                assertThat(response.getItems()[i].getVersion(), equalTo(3L));
                    .setId("2")
    }
                    .setIndex("test")
                .setIndex("test")
import org.opensearch.action.update.UpdateResponse;
                updateBuilder.setDoc(jsonBuilder().startObject().field("counter", 2).endObject());
        assertThat(indicesStatsResponse.getIndex(indexName).getPrimaries().indexing.getTotal().getNoopUpdateCount(), equalTo(1L));
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.indices.alias.Alias;
        }
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(2L));
        BulkResponse response = builder.get();
            .add(client().prepareIndex().setIndex("test").setId("1").setSource("field", 1))
    public void testThatInvalidIndexNamesShouldNotBreakCompleteBulkRequest() {
            int id = i + (numDocs / 2);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        ensureGreen();
        BulkResponse bulkResponse = client().bulk(bulkRequest).get();
        }
        for (int i = 0; i < numDocs; i++) {
 * specific language governing permissions and limitations
        getResponse = client().prepareGet().setIndex("test").setId("2").execute().actionGet();
        assertThat(bulkResponse.getItems()[2].getResponse().getVersion(), equalTo(12L));
                    return;
            )
            );
    }
            return f.apply(source);
        client().prepareIndex("bulkindex1").setId("1").setSource("text", "test").get();
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);
            .add(new UpdateRequest("bulkindex2", "2").doc(Requests.INDEX_CONTENT_TYPE, "foo", "bar"))
        }
        assertThat(bulkResponse.getItems().length, is(bulkEntryCount));
        assertThat(bulkResponse.hasFailures(), is(true));
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
                    .setId("3")
        assertThat(bulkItemResponse.getItems()[0].getOpType(), is(OpType.INDEX));
        int maxDocs = numDocs / 2 + numDocs;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .setScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op = \"delete\"", Collections.emptyMap()))
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build());
import org.opensearch.action.DocWriteRequest.OpType;
            threads[i].join();
            .add(client().prepareUpdate("test", "1").setIfSeqNo(2L).setIfPrimaryTerm(1).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "3"))
            assertThat(itemResponse.getFailure(), nullValue());
            .get();
import java.util.Arrays;
            scripts.put("ctx.op = \"delete\"", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        assertThat(bulkItemResponse.getItems()[4].getOpType(), is(OpType.DELETE));
        createIndex("test");
        assertThat("expected no failures but got: " + response.buildFailureMessage(), response.hasFailures(), equalTo(false));
        assertThat(response.hasFailures(), equalTo(true));
        assertThat(responseItems[2].getFailure().getCause(), instanceOf(IndexClosedException.class));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
import org.opensearch.script.Script;
                name = randomFrom(badIndexNames);
        BulkResponse bulkResponse = client().bulk(bulkRequest2).get();
        BulkResponse bulkResponse = client().prepareBulk()
        ensureGreen();
        int replica = randomInt(2);
                throw new ScriptException("message", null, Collections.emptyList(), "exception on unknown var", CustomScriptPlugin.NAME);
            .get();
        assertThat(bulkResponse.getItems()[2].getResponse().getId(), equalTo("2"));
        }
        assertThat(bulkResponse.getItems()[1].getResponse().getSeqNo(), equalTo(3L));
    public void testNoopUpdate() {
        int successes = 0;
            Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
            .add(client().prepareUpdate("test", "e1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "2").setIfSeqNo(10L).setIfPrimaryTerm(1))
        assertThat(getResponse.isExists(), equalTo(false));
        assertThat(response.hasFailures(), equalTo(false));
        assertThat(responseItems.length, is(3));
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(3L));
import org.opensearch.plugins.Plugin;
        assertThat(doc.getShardInfo().getSuccessful(), equalTo(2));
        }
            .add(new DeleteRequest("bulkindex2", "3"))
        for (int i = 0; i < numDocs;) {
        assertThat(getResponse.getSource().get("field1").toString(), equalTo("test"));
    }
            .get();
            assertThat(((UpdateResponse) response.getItems()[i].getResponse()).getGetResult().sourceAsMap().get("counter"), equalTo(1));
        BulkResponse bulkResponse = client().prepareBulk()
 * under the License.
            .add(client().prepareIndex("test").setId("1").setCreate(true).setSource("field", "1"))
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));
            builder.add(
        ensureGreen();
        logger.info(bulkResponse.buildFailureMessage());
        assertThat(bulkResponse.getItems()[0].getOpType(), is(OpType.INDEX));
                    .setId(Integer.toString(i))
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        bulkRequest.add(new IndexRequest("bulkindex1").id("1").source(Requests.INDEX_CONTENT_TYPE, "text", "hallo1"))
            if (response.hasFailures()) {
            assertThat(response.getItems()[i].getId(), equalTo(Integer.toString(i)));
            .add(client().prepareIndex().setIndex(indexOrAlias()).setId("4").setSource("field", 4))
        ensureGreen(indexName);
import org.opensearch.action.DocWriteResponse;
        BulkResponse bulkResponse = builder.get();
        assertThat(((Number) getResponse.getSource().get("field")).longValue(), equalTo(4L));
        for (int i = 0; i < bulkEntryCount; i++) {
            .add(client().prepareUpdate().setIndex(indexOrAlias()).setId("7").setScript(script))
            .add(new DeleteRequest("bulkindex2", "3"))
        assertThat(response.getItems().length, equalTo(numDocs));
                assertThat(getResponse.isExists(), equalTo(true));
            .get();
        );
    }
            .get();
        assertThat(bulkResponse.getItems()[1].getFailure(), nullValue());
        BulkResponse bulkResponse = client().prepareBulk()
        assertThat(noopUpdate.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOOP));
        assertThat(response.getItems().length, equalTo(numDocs));
        // test noop_update_total metric in stats changed
            for (int j = 0; j < 5; j++) {
            .get();
                    .setIndex("test")
        int bulk = scaledRandomIntBetween(1, 99);
        BulkResponse indexBulkItemResponse = client().prepareBulk()
import org.opensearch.script.ScriptType;
        for (int i = 0; i < numDocs; i++) {
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        assertThat(bulkResponse.getItems().length, equalTo(3));
                client().prepareUpdate()
        refresh();
        assertThat(bulkResponse.getItems().length, equalTo(5));
            final BulkItemResponse itemResponse = response.getItems()[i];
            .add(new IndexRequest("test").id("4").source("{ \"title\" : \"Great Title of doc 4\" }", MediaTypeRegistry.JSON))
            .add(client().prepareIndex("test").setId("e1").setSource("field", "2").setVersion(12).setVersionType(VersionType.EXTERNAL))
        assertThat(bulkResponse.getItems()[0].getResponse(), nullValue());
            .get();
        bulkResponse = client().prepareBulk()
            }
                updateBuilder.setRetryOnConflict(3);
        SearchResponse searchResponse = client().prepareSearch("bulkindex*").get();
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(2L));
            )
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
