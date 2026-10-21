        );
import org.opensearch.action.ingest.DeletePipelineRequest;
                source.startArray("processors");
        BulkRequest bulkRequest = new BulkRequest();
/*
 * Modifications Copyright OpenSearch Contributors. See
                }
        assertThat(response.isAcknowledged(), is(true));
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
import org.hamcrest.MatcherAssert;
            XContentBuilder source = jsonBuilder().startObject();
import static org.hamcrest.Matchers.nullValue;
                .startObject()
 * software distributed under the License is distributed on an
        assertThat(getResponse.pipelines().size(), equalTo(0));
            IndexRequest indexRequest = new IndexRequest("test");
                .endObject()
import org.opensearch.action.bulk.BulkItemResponse;
import org.opensearch.action.bulk.BulkRequest;
                .startObject()
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();
                source.endArray();
                {
import org.opensearch.action.index.IndexRequest;
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");
        assertNull(doc);
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
                source.startArray("processors");
            () -> client().prepareIndex("test")
            {
        );
        assertThat(response.isAcknowledged(), is(true));
        assertThat(getResponse.isFound(), is(true));
                }
                source.endArray();
        assertNull(client().prepareGet("index", "_drop").get().getSourceAsMap());
import org.opensearch.action.bulk.BulkResponse;
                {
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
        Map<String, Object> source = new HashMap<>();
                (processorFactories, tag, description, config) -> new TestProcessor(tag, "fail", description, new RuntimeException())
        );
            jsonBuilder().startObject()
        bulkRequest.add(
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();
        Map<String, Object> inserted = client().prepareGet("index", "1").get().getSourceAsMap();
        BytesReference pipelineSource = BytesReference.bytes(
        super(settings);
                .startObject("test")
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
            client().admin().cluster().putPipeline(putPipelineRequest).get();
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
                }
                .endObject()
        assertThat(response.getPipelineId(), equalTo("_id"));
            }
        MatcherAssert.assertThat(results.keySet(), containsInAnyOrder("_fail", "_success", "_drop"));
        assertThat(getResponse.isFound(), is(true));
import java.util.stream.Collectors;
                .startArray("processors")
        if (randomBoolean()) {
                    source.startObject("pipeline");
        );
                assertThat(indexResponse.getId(), equalTo(Integer.toString(i)));
                    source.startObject("pipeline");
            {
 */
        createIndex("test");
    }
import java.util.HashMap;
        IndexRequest indexRequest = new IndexRequest("index").id("1").setPipeline("_id");
                source.startObject();
            jsonBuilder().startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ingest.SimulatePipelineResponse;
            new IndexRequest("index").id("_drop").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "drop", true)
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.Matchers.equalTo;
                .field("description", "my_pipeline")
    public void testPipelineOriginHeader() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .endObject()
        {
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();
import org.opensearch.action.index.IndexResponse;
                .endObject()
            source.endObject();
                source.startObject();
            request.setId("_id");
    public void testSimulate() throws Exception {
            }
            OpenSearchParseException.class,
        {
 * the Apache License, Version 2.0 (the "License"); you may
            jsonBuilder().startObject()
                source.endObject();
        BytesReference source = BytesReference.bytes(
        Map<String, Object> inserted = client().prepareGet("test", "1").get().getSourceAsMap();
import org.opensearch.action.DocWriteResponse;
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
 * this work for additional information regarding copyright
                    source.field("name", "3");
                .endArray()
        assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));
            client().index(indexRequest).get();
                .endObject()
                source.startArray("on_failure");
                .field("fail", false)
        createIndex("index");
            factories.put(
import java.util.Map;
                    source.endObject();
        );
        // verify dropped doc not in index
                .startObject("test")
                {
        assertNull(results.get("_success").getFailure());
    public void test() throws Exception {
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) response.getResults().get(0);
        // cleanup
        assertThat(response.getResults().size(), equalTo(1));
        assertFalse(item.isFailed());
                source.startObject();
                .endObject()
        );
        assertThat(upserted.get("field1"), equalTo("upserted_val"));
    @Override
        {
            );
            SimulatePipelineRequest request = new SimulatePipelineRequest(bytes, MediaTypeRegistry.JSON);
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", i % 2 == 0);
 * You may obtain a copy of the License at
                source.startObject();
            }
            XContentBuilder source = jsonBuilder().startObject();
                .endObject()
        assertTrue(deletePipelineResponse.isAcknowledged());
            .setSource(Requests.INDEX_CONTENT_TYPE, "field", "value", "drop", true)
                    is(false)
                }
            jsonBuilder().startObject()
        assertThat(getResponse.pipelines().size(), equalTo(1));
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.opensearch.action.ingest.GetPipelineRequest;
            jsonBuilder().startObject()
                source.endObject();
                    source.endObject();
                IndexResponse indexResponse = itemResponse.getResponse();
                .field("description", "my_pipeline")
                OpenSearchException compoundProcessorException = (OpenSearchException) failure.getCause();
import org.opensearch.core.common.bytes.BytesReference;
            client().admin().cluster().putPipeline(putPipelineRequest).get();
            XContentBuilder source = jsonBuilder().startObject();
                .endObject()
 * GitHub history for details.
        assertThat(doc.get("field"), equalTo("value"));
        assertThat(upserted.get("processed"), equalTo(true));
                    String onFailurePipeline = document.getFieldValue("_ingest.on_failure_pipeline", String.class);
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
                }
import org.opensearch.ExceptionsHelper;
        }
                assertThat(indexResponse, notNullValue());
                .endObject()
 * not use this file except in compliance with the License.
    protected Settings nodeSettings(int nodeOrdinal) {
        GetPipelineResponse getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
                    itemResponse.isFailed(),
        client().prepareBulk()
                .endObject()
            {
        assertThat(ingestException.getHeader("pipeline_origin"), equalTo(Arrays.asList("3", "2", "1")));
 * SPDX-License-Identifier: Apache-2.0
    public static Collection<Object[]> parameters() {
 *
                source.endObject();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .endObject()
        assertThat(simulateDocumentBaseResult.getIngestDocument().getSourceAndMetadata(), equalTo(ingestDocument.getSourceAndMetadata()));
        }
                .endArray()
                source.endObject();
        client().admin().cluster().putPipeline(putPipelineRequest).get();
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
import org.opensearch.action.ingest.SimulatePipelineRequest;
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
                .startObject()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            {
                .startObject()
                source.startArray("processors");
        bulkRequest.add(indexRequest);
        );
import org.opensearch.test.OpenSearchIntegTestCase;
        }
                .endObject()
        BytesReference bytes = BytesReference.bytes(
        SimulatePipelineResponse response;
        for (int i = 0; i < bulkRequest.requests().size(); i++) {
                    source.startObject("pipeline");
            }
    }
                .startArray("processors")
        bulkRequest.add(
            response = client().admin().cluster().prepareSimulatePipeline(bytes, MediaTypeRegistry.JSON).setId("_id").get();
                source.endObject();
        BytesReference source = BytesReference.bytes(
    public void testPutWithPipelineFactoryError() throws Exception {
                .setPipeline("_id")
                .get()
        doc = client().prepareGet("test", "2").get().getSourceAsMap();
import static org.opensearch.test.NodeRoles.nonIngestNode;
            new IndexRequest("index").id("_fail").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", true)
                .startObject("_source")
                source.startArray("processors");
    }
        assertThat(getResponse.pipelines().size(), equalTo(1));
 * under the License.
import org.opensearch.action.ingest.GetPipelineResponse;
    }
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
    @ParametersFactory
        );
        }
        assertThat(getResponse.isFound(), is(false));
            jsonBuilder().startObject()
        );
        {
                })
            BulkItemResponse itemResponse = response.getItems()[i];
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");
                .startObject("test")
import org.opensearch.action.ingest.SimulateDocumentBaseResult;
                .endObject()
                assertThat(successDoc.get("processed"), equalTo(true));
        assertThat(getResponse.pipelines().size(), equalTo(1));
        assertThat(response.getResults().get(0), instanceOf(SimulateDocumentBaseResult.class));
    }
            response = client().admin().cluster().simulatePipeline(request).get();
            return factories;
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
                {
        String clusterManagerOnlyNode = internalCluster().startClusterManagerOnlyNode();
                .endObject()
        // cleanup
            .add(client().prepareIndex("test").setId("2").setSource("field", "value2", "fail", false).setPipeline("_id"))
                    source.startObject("fail");
            }
            .get();
        assertEquals("auto-generated", item.getResponse().getId());
                );
                "fail",
                }
    public void testWithDedicatedClusterManager() throws Exception {
            }
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();
            if (i % 2 == 0) {
        assertThat(getResponse.isFound(), is(false));
                source.startObject();
            source.endObject();
        assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));
        // cleanup
                .endObject()
        Exception e = expectThrows(Exception.class, () -> {
 * compatible open source license.
                Map<String, Object> successDoc = client().prepareGet("index", indexResponse.getId()).get().getSourceAsMap();
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
        assertThat(response.isAcknowledged(), is(true));
                    source.field("name", "3");
                .setId("1")
        BytesReference source = BytesReference.bytes(
            client().admin().cluster().putPipeline(putPipelineRequest).get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testPipelineProcessorOnFailure() throws Exception {
                .endObject()
                .endObject()
        source.put("foo", "bar");
        Exception e = expectThrows(
            () -> client().admin().cluster().putPipeline(putPipelineRequest).actionGet()
        client().admin().cluster().putPipeline(putPipelineRequest).get();
                }
        );
            source.endObject();
                .endArray()
        assertThat(ingestException.getHeader("processor_type"), equalTo(Collections.singletonList("fail")));
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
                .endObject()
    }
            .get()
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
        assertThrows(
        assertTrue(deletePipelineResponse.isAcknowledged());
                .field("foo", "bar")
            }
        );
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
        client().admin().cluster().putPipeline(putPipelineRequest).get();
            IndexRequest indexRequest = new IndexRequest("index").id(Integer.toString(i)).setPipeline("_id");
                // verify field of successful doc
                .endObject()
                .startObject()
        client().admin().cluster().putPipeline(putPipelineRequest).get();
import org.opensearch.action.ingest.PutPipelineRequest;
                .startObject("test")
import org.opensearch.action.update.UpdateRequest;
        return Collections.singleton(ExtendedIngestTestPlugin.class);
                .endArray()
import static org.hamcrest.Matchers.instanceOf;
        BulkResponse response = client().bulk(bulkRequest).actionGet();
            .setId("1")
            client().admin().cluster().putPipeline(putPipelineRequest).get();
            XContentBuilder source = jsonBuilder().startObject();
        assertThat(getResponse.isFound(), is(true));
                    source.endObject();
                {
        {
    }
            IllegalArgumentException.class,
        // verify field of successful doc
                {
        BytesReference source = BytesReference.bytes(
            jsonBuilder().startObject()
                .endObject()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .endArray()
        assertThat(getResponse.pipelines().size(), equalTo(1));
                .field("_id", "id")
                .endObject()
        }
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("1", BytesReference.bytes(source), MediaTypeRegistry.JSON);
                    source.endObject();
        BytesReference source = BytesReference.bytes(
 * license agreements. See the NOTICE file distributed with
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, source);
                source.startArray("processors");
        for (int i = 0; i < numRequests; i++) {
        assertThat(doc.get("processed"), equalTo(true));
        Map<String, BulkItemResponse> results = Arrays.stream(response.getItems())
                .endObject()
import static org.hamcrest.Matchers.notNullValue;
            source.endObject();
        client().admin().cluster().preparePutPipeline("_id", pipelineSource, MediaTypeRegistry.JSON).get();
                    source.field("name", "2");
            jsonBuilder().startObject()
import org.opensearch.plugins.Plugin;
        createIndex("index");
    public void testBulkWithUpsert() throws Exception {
            source.endObject();
                .startArray("processors")
        assertThat(inserted.get("processed"), equalTo(true));
        }
        IngestProcessorException ingestException = (IngestProcessorException) ExceptionsHelper.unwrap(e, IngestProcessorException.class);
            client().admin().cluster().putPipeline(putPipelineRequest).get();
    }
            .setPipeline("_id")
        source.put("fail", false);
            indexRequest.setPipeline("1");
        if (nodeOrdinal % 2 == 0) {
            jsonBuilder().startObject()
                source.endArray();
        BulkRequest bulkRequest = new BulkRequest();
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");
        }
            {
        assertThat(getResponse.pipelines().size(), equalTo(0));
                "onfailure_processor",
        {
        BulkResponse response = client().bulk(bulkRequest).actionGet();
                    source.startObject("onfailure_processor");
import org.opensearch.OpenSearchParseException;
        createIndex("index");
        assertThat(getResponse.isFound(), is(false));
 *
/*
    }
                .setSource(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", true)
            .add(client().prepareIndex("test").setSource("field", "value2", "drop", true).setPipeline("_id"))
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("2", BytesReference.bytes(source), MediaTypeRegistry.JSON);
            jsonBuilder().startObject()
                .field("description", "my_pipeline")
        assertEquals(DocWriteResponse.Result.NOOP, indexResponse.getResult());
                .startObject()
                .field("description", "my_pipeline")
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("3", BytesReference.bytes(source), MediaTypeRegistry.JSON);
 * Unless required by applicable law or agreed to in writing,
        assertTrue(deletePipelineResponse.isAcknowledged());
                    source.endObject();
        } else {
import org.opensearch.core.xcontent.XContentBuilder;
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();
        Map<String, Object> doc = client().prepareGet("test", "1").get().getSourceAsMap();
                source.endArray();
        assertThat(getResponse.isFound(), is(true));
                    source.startObject("pipeline");
import java.util.Arrays;
        }
                .endArray()
        client().prepareIndex("test").setId("1").setPipeline("_id").setSource("field", "value", "fail", false).get();
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();
                .endObject()
        MatcherAssert.assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));
        Map<String, Object> upserted = client().prepareGet("index", "2").get().getSourceAsMap();
        assertThat(doc.get("processed"), equalTo(true));
            XContentBuilder source = jsonBuilder().startObject();
                .startObject("test")
        assertNotNull(results.get("_fail").getFailure());
                .endObject()
                .endObject()
import org.opensearch.common.settings.Settings;
        );
                source.startObject();
        source.put("processed", true);
                .endArray()
                source.endObject();
                .field("description", "my_pipeline")
    public IngestClientIT(Settings settings) {
                .field("description", "my_pipeline")
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).setPipeline("1").get();
                .endArray()
                .startArray("processors")
import java.util.Collection;
                assertThat(
 *
                .startObject("test")
/*
    }
}
import org.opensearch.OpenSearchException;
        client().admin().cluster().putPipeline(putPipelineRequest).get();
            .collect(Collectors.toMap(BulkItemResponse::getId, r -> r));
        });
                (processorFactories, tag, description, config) -> new TestProcessor(tag, "fail", description, document -> {
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
    }
                .startArray("processors")
                .field("description", "my_pipeline")
        }
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
        assertThat(e.getMessage(), equalTo("processor [test] doesn't support one or more provided configuration parameters [unused]"));
    }
                .field("description", "my_pipeline")
                .startArray("processors")
                assertThat(compoundProcessorException.getRootCause().getMessage(), equalTo("test processor failed"));
                .startArray("docs")
                source.startObject();
        return super.nodeSettings(nodeOrdinal);
        int numRequests = scaledRandomIntBetween(32, 128);
                .field("description", "my_pipeline")
                .endObject()
    public void testBulkWithIngestFailures() throws Exception {
        BulkItemResponse item = client(clusterManagerOnlyNode).prepareBulk()
        BytesReference source = BytesReference.bytes(
        assertThat(successDoc.get("processed"), equalTo(true));
                    source.endObject();
        );
        bulkRequest.add(
        );
                .endObject()
            indexRequest.source("{}", MediaTypeRegistry.JSON);
        Map<String, Object> successDoc = client().prepareGet("index", "_success").get().getSourceAsMap();
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");
            Map<String, Processor.Factory> factories = new HashMap<>(super.getProcessors(parameters));
        createIndex("test");
        return replicationSettings;
        assertFalse(response.isFound());
                assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("2", BytesReference.bytes(source), MediaTypeRegistry.JSON);
        assertThat(inserted.get("readme"), equalTo("pipeline with id [3] is a bad pipeline"));
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();
        assertThat(doc.get("field"), equalTo("value2"));
                source.endArray();
            bulkRequest.add(indexRequest);
 * KIND, either express or implied.  See the License for the
            client().admin().cluster().putPipeline(putPipelineRequest).get();
                .field("unused", ":sad_face:")
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id2", source, MediaTypeRegistry.JSON);
    }
            new IndexRequest("index").id("_success").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", false)
            factories.put(PipelineProcessor.TYPE, new PipelineProcessor.Factory(parameters.ingestService));
                source.endObject();
        indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field1", "val1");
                source.endArray();
 * this file be licensed under the Apache-2.0 license or a
                .startArray("processors")
                    document.setFieldValue("readme", "pipeline with id [" + onFailurePipeline + "] is a bad pipeline");
                .endArray()
        assertThat(getResponse.pipelines().size(), equalTo(0));
 */
            source.endObject();
                    source.startObject("fail");
                source.startArray("processors");
        Map<String, Object> doc = client().prepareGet("test", "1").get().getSourceAsMap();
            {
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();
                    source.field("name", "2");
                .endObject()
 * Licensed to Elasticsearch under one or more contributor
                source.endArray();
                .startObject("test")
    public void testSingleDocIngestFailure() throws Exception {
        assertNull(results.get("_drop").getFailure());
                .startArray("processors")
                BulkItemResponse.Failure failure = itemResponse.getFailure();
                .endObject()
import org.opensearch.transport.client.Requests;
                    "Expected a successful response but found failure [" + itemResponse.getFailure() + "].",
        GetPipelineResponse response = client().admin().cluster().prepareGetPipeline("_id2").get();
    public static class ExtendedIngestTestPlugin extends IngestTestPlugin {
 * specific language governing permissions and limitations
        BulkRequest bulkRequest = new BulkRequest();
                .startObject()
        }
                    source.endObject();
        assertThat(response.isVerbose(), equalTo(false));
                {
                .startObject()
            );
            factories.put(
    }
        client().admin().cluster().putPipeline(putPipelineRequest).get();
            }
package org.opensearch.ingest;
        BytesReference source = BytesReference.bytes(
    public void testBulkWithIngestFailuresAndDropBatch() throws Exception {
        updateRequest.upsert("{\"field1\":\"upserted_val\"}", MediaTypeRegistry.JSON).upsertRequest().setPipeline("_id");
            } else {
    @Override
        updateRequest.doc("{}", Requests.INDEX_CONTENT_TYPE);
                .field("_index", "index")
        assertThat(inserted.get("field1"), equalTo("val1"));
        UpdateRequest updateRequest = new UpdateRequest("index", "2");
public class IngestClientIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.hamcrest.core.Is.is;
            {
        @Override
                .endObject()
                .startObject("test")
    public void testSingleDocIngestDrop() throws Exception {
            .get();
 * The OpenSearch Contributors require contributions made to
                .startArray("processors")
        BytesReference source = BytesReference.bytes(
            .getItems()[0];
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");
import java.util.Collections;
    }
        BulkResponse response = client().bulk(bulkRequest).actionGet();
                .endArray()
            return Settings.builder().put(nonIngestNode()).put(super.nodeSettings(nodeOrdinal)).build();
            XContentBuilder source = jsonBuilder().startObject();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("3", BytesReference.bytes(source), MediaTypeRegistry.JSON);
                .startObject()
        }
 */
                .startObject("test")
        bulkRequest.add(updateRequest);
    }
        DocWriteResponse indexResponse = client().prepareIndex("test")
                .startObject()
        client().admin().cluster().putPipeline(putPipelineRequest).get();
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("1", BytesReference.bytes(source), MediaTypeRegistry.JSON);
