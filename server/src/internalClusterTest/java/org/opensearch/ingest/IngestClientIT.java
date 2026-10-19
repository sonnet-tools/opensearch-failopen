        assertThat(doc.get("processed"), equalTo(true));  
 * license agreements. See the NOTICE file distributed with
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();  
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
        BulkRequest bulkRequest = new BulkRequest();
    public void testPipelineProcessorOnFailure() throws Exception {  
        assertThat(getResponse.isFound(), is(false));
        MatcherAssert.assertThat(results.keySet(), containsInAnyOrder("_fail", "_success", "_drop"));
        assertThat(successDoc.get("processed"), equalTo(true));  
                .startObject()
        assertThat(ingestException.getHeader("pipeline_origin"), equalTo(Arrays.asList("3", "2", "1")));  
            jsonBuilder().startObject()
                })
                source.endArray();
        assertNull(results.get("_drop").getFailure());
        assertThat(getResponse.isFound(), is(false));
        );
}
 * specific language governing permissions and limitations
        // cleanup
        Map<String, BulkItemResponse> results = Arrays.stream(response.getItems())
        BytesReference bytes = BytesReference.bytes(  
            .get();
import org.opensearch.ExceptionsHelper;  
                source.endObject();
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("3", BytesReference.bytes(source), MediaTypeRegistry.JSON);  
                .startObject("test")  
                .endObject()  
            client().admin().cluster().putPipeline(putPipelineRequest).get();
                .endObject()
                source.endArray();  
    @ParametersFactory  
        assertThat(response.isAcknowledged(), is(true));
        BytesReference source = BytesReference.bytes(
            source.endObject();  
import org.opensearch.action.index.IndexRequest;
                "onfailure_processor",  
        createIndex("index");
            () -> client().admin().cluster().putPipeline(putPipelineRequest).actionGet()
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("3", BytesReference.bytes(source), MediaTypeRegistry.JSON);
                .endObject()
    protected Settings nodeSettings(int nodeOrdinal) {  
                .endObject()
        assertThat(upserted.get("processed"), equalTo(true));
        // verify field of successful doc
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.ingest;
                {  
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));  
        assertThat(getResponse.isFound(), is(true));
            }
                .field("unused", ":sad_face:")
        createIndex("index");
        );
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(getResponse.pipelines().size(), equalTo(0));  
                .endObject()
        assertThat(response.getResults().get(0), instanceOf(SimulateDocumentBaseResult.class));
                .endObject()
        // verify dropped doc not in index
        assertThat(response.getResults().size(), equalTo(1));  
    public IngestClientIT(Settings settings) {
                assertThat(successDoc.get("processed"), equalTo(true));  
                .endObject()
                .field("_index", "index")
                source.endObject();
                .startObject()  
        );
                .endArray()
                assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        assertThat(getResponse.pipelines().size(), equalTo(1));
        BulkRequest bulkRequest = new BulkRequest();  
                .startObject("_source")  
            .setPipeline("_id")  
            jsonBuilder().startObject()
                source.endObject();
                {
            XContentBuilder source = jsonBuilder().startObject();
    public void test() throws Exception {
                // verify field of successful doc
        Exception e = expectThrows(
                source.startObject();
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();  
 * compatible open source license.
                .endObject()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                assertThat(compoundProcessorException.getRootCause().getMessage(), equalTo("test processor failed"));  
            source.endObject();
            jsonBuilder().startObject()  
    }  
                .field("description", "my_pipeline")  
                    source.endObject();
                assertThat(  
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
        bulkRequest.add(
                source.startArray("on_failure");  
import org.opensearch.action.ingest.GetPipelineResponse;
                assertThat(indexResponse.getId(), equalTo(Integer.toString(i)));  
import org.opensearch.action.ingest.SimulatePipelineRequest;
        super(settings);  
import org.opensearch.action.index.IndexResponse;
        assertFalse(response.isFound());  
        createIndex("index");
        client().prepareBulk()
            .add(client().prepareIndex("test").setSource("field", "value2", "drop", true).setPipeline("_id"))
            request.setId("_id");
    }
                    source.endObject();  
                .endObject()
public class IngestClientIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                .endObject()
        Map<String, Object> successDoc = client().prepareGet("index", "_success").get().getSourceAsMap();
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).setPipeline("1").get();
        source.put("foo", "bar");
        Map<String, Object> doc = client().prepareGet("test", "1").get().getSourceAsMap();
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
        assertTrue(deletePipelineResponse.isAcknowledged());
import static org.hamcrest.Matchers.notNullValue;
    }
import org.opensearch.OpenSearchException;
                (processorFactories, tag, description, config) -> new TestProcessor(tag, "fail", description, document -> {
        bulkRequest.add(indexRequest);  
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
            return factories;  
        );  
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);  
                source.startObject();
            );
                .startObject("test")  
                    source.endObject();
import static org.hamcrest.Matchers.instanceOf;  
        BytesReference pipelineSource = BytesReference.bytes(
            response = client().admin().cluster().simulatePipeline(request).get();
        }  
                .endObject()  
                .field("foo", "bar")
import org.hamcrest.MatcherAssert;
            jsonBuilder().startObject()
    public void testWithDedicatedClusterManager() throws Exception {  
        assertThat(getResponse.isFound(), is(true));
                .startObject()
            {
 * KIND, either express or implied.  See the License for the
            new IndexRequest("index").id("_drop").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "drop", true)
            IndexRequest indexRequest = new IndexRequest("index").id(Integer.toString(i)).setPipeline("_id");  
                .startArray("processors")
            response = client().admin().cluster().prepareSimulatePipeline(bytes, MediaTypeRegistry.JSON).setId("_id").get();
                .endObject()
        SimulatePipelineResponse response;
                .endArray()  
                .startArray("processors")  
                .startArray("processors")
                .field("description", "my_pipeline")  
                }
                .endObject()
    @Override
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);  
import org.opensearch.action.bulk.BulkRequest;
        UpdateRequest updateRequest = new UpdateRequest("index", "2");
        assertThat(ingestException.getHeader("processor_type"), equalTo(Collections.singletonList("fail")));
                "fail",
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id2", source, MediaTypeRegistry.JSON);
        if (nodeOrdinal % 2 == 0) {
    public static Collection<Object[]> parameters() {
                (processorFactories, tag, description, config) -> new TestProcessor(tag, "fail", description, new RuntimeException())  
                Map<String, Object> successDoc = client().prepareGet("index", indexResponse.getId()).get().getSourceAsMap();
            {  
                .startObject("test")  
        BulkResponse response = client().bulk(bulkRequest).actionGet();
            if (i % 2 == 0) {  
        if (randomBoolean()) {  
        @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
            IllegalArgumentException.class,
import org.opensearch.OpenSearchParseException;
        );  
import org.opensearch.action.update.UpdateRequest;
                IndexResponse indexResponse = itemResponse.getResponse();
                );
    }  
                source.startArray("processors");  
            factories.put(
        client().admin().cluster().putPipeline(putPipelineRequest).get();
                    source.startObject("onfailure_processor");  
    public void testPipelineOriginHeader() throws Exception {  
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");
            client().admin().cluster().putPipeline(putPipelineRequest).get();  
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);  
/*
        BulkItemResponse item = client(clusterManagerOnlyNode).prepareBulk()
        assertThat(getResponse.pipelines().size(), equalTo(1));
        {
        assertThat(getResponse.pipelines().size(), equalTo(0));
        assertThat(inserted.get("field1"), equalTo("val1"));
                .endObject()
        for (int i = 0; i < bulkRequest.requests().size(); i++) {
import org.opensearch.common.settings.Settings;  
                .startObject("test")
                .startArray("processors")
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();
            );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.ingest.GetPipelineRequest;
        MatcherAssert.assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));  
        assertThat(response.isAcknowledged(), is(true));
                source.startObject();
        Map<String, Object> upserted = client().prepareGet("index", "2").get().getSourceAsMap();  
                source.endArray();
                .endObject()  
 * You may obtain a copy of the License at  
                source.startArray("processors");
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();  
    public void testSingleDocIngestFailure() throws Exception {
        assertThat(getResponse.isFound(), is(true));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ingest.SimulatePipelineResponse;  
                {
                source.endObject();
                source.endArray();  
 * not use this file except in compliance with the License.
                source.startObject();
                    source.field("name", "3");
                source.startArray("processors");
                .setPipeline("_id")
            SimulatePipelineRequest request = new SimulatePipelineRequest(bytes, MediaTypeRegistry.JSON);  
        GetPipelineResponse response = client().admin().cluster().prepareGetPipeline("_id2").get();
                .startObject()
        assertThat(getResponse.isFound(), is(true));  
                .startObject("test")
                .startObject("test")  
        doc = client().prepareGet("test", "2").get().getSourceAsMap();
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("1", BytesReference.bytes(source), MediaTypeRegistry.JSON);
        BytesReference source = BytesReference.bytes(
            source.endObject();  
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();
                source.endArray();
                .field("description", "my_pipeline")
        updateRequest.upsert("{\"field1\":\"upserted_val\"}", MediaTypeRegistry.JSON).upsertRequest().setPipeline("_id");  
            }
            }
            Map<String, Processor.Factory> factories = new HashMap<>(super.getProcessors(parameters));
            indexRequest.source("{}", MediaTypeRegistry.JSON);  
            } else {
        assertThat(e.getMessage(), equalTo("processor [test] doesn't support one or more provided configuration parameters [unused]"));  
            client().index(indexRequest).get();
 * this file be licensed under the Apache-2.0 license or a
    public static class ExtendedIngestTestPlugin extends IngestTestPlugin {
                .startObject("test")  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertTrue(deletePipelineResponse.isAcknowledged());
                .endArray()  
                .field("fail", false)
                .endArray()  
            {  
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);  
        BytesReference source = BytesReference.bytes(
        updateRequest.doc("{}", Requests.INDEX_CONTENT_TYPE);
                source.startArray("processors");  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.ingest.SimulateDocumentBaseResult;
        assertThat(response.getPipelineId(), equalTo("_id"));
    }
                source.startArray("processors");
        Map<String, Object> doc = client().prepareGet("test", "1").get().getSourceAsMap();
        Map<String, Object> inserted = client().prepareGet("test", "1").get().getSourceAsMap();  
    }
            XContentBuilder source = jsonBuilder().startObject();
                .endObject()  
        assertThat(inserted.get("processed"), equalTo(true));
import static org.opensearch.test.NodeRoles.nonIngestNode;  
                source.endObject();  
                {
                .field("description", "my_pipeline")  
    public void testBulkWithUpsert() throws Exception {
        Map<String, Object> source = new HashMap<>();  
            {  
                    source.endObject();  
import java.util.stream.Collectors;  
                    source.field("name", "3");
    }
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");  
        bulkRequest.add(updateRequest);
            indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", i % 2 == 0);
                .endObject()
                .endObject()
            new IndexRequest("index").id("_success").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", false)
        BulkResponse response = client().bulk(bulkRequest).actionGet();
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");
 * SPDX-License-Identifier: Apache-2.0
                source.endObject();
            jsonBuilder().startObject()
        );  
            new IndexRequest("index").id("_fail").setPipeline("_id").source(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", true)
                .endObject()
                    document.setFieldValue("readme", "pipeline with id [" + onFailurePipeline + "] is a bad pipeline");  
        createIndex("test");  
        DeletePipelineRequest deletePipelineRequest = new DeletePipelineRequest("_id");  
        {
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");
        assertThat(getResponse.pipelines().size(), equalTo(1));  
import org.opensearch.core.common.bytes.BytesReference;
        );
        assertThat(doc.get("field"), equalTo("value2"));  
                .endObject()
        BytesReference source = BytesReference.bytes(  
        // cleanup
                }
        {  
                .startObject()  
        client().admin().cluster().putPipeline(putPipelineRequest).get();  
 * under the License.  
    }
    }
        bulkRequest.add(
                .startArray("processors")
            () -> client().prepareIndex("test")
        );
            .setId("1")
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();
                source.startObject();
        assertNotNull(results.get("_fail").getFailure());  
            jsonBuilder().startObject()  
                .endObject()
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, source);
import java.util.Collections;  
import static org.hamcrest.core.Is.is;  
import org.opensearch.action.ingest.PutPipelineRequest;  
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("1", BytesReference.bytes(source), MediaTypeRegistry.JSON);  
        }
    }
            factories.put(PipelineProcessor.TYPE, new PipelineProcessor.Factory(parameters.ingestService));  
            }  
import java.util.Collection;
                .startObject()
                source.endArray();  
        );
                {
            client().admin().cluster().putPipeline(putPipelineRequest).get();
import java.util.Arrays;
    }
            indexRequest.setPipeline("1");
        );
        );  
        GetPipelineRequest getPipelineRequest = new GetPipelineRequest("_id");  
        AcknowledgedResponse response = client().admin().cluster().deletePipeline(deletePipelineRequest).get();  
import static org.hamcrest.Matchers.nullValue;
                .get()  
        assertThat(getResponse.pipelines().size(), equalTo(1));  
                .endObject()  
        }  
        GetPipelineResponse getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
            IndexRequest indexRequest = new IndexRequest("test");
 * Licensed to Elasticsearch under one or more contributor  
                .endObject()
            .getItems()[0];
        }  
        } else {
                source.endArray();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        BytesReference source = BytesReference.bytes(
        assertThat(inserted.get("readme"), equalTo("pipeline with id [3] is a bad pipeline"));
        }
                    source.startObject("pipeline");  
        }
                BulkItemResponse.Failure failure = itemResponse.getFailure();
                .field("description", "my_pipeline")  
                    itemResponse.isFailed(),
    }
 * Modifications Copyright OpenSearch Contributors. See
                .field("description", "my_pipeline")
        );
        int numRequests = scaledRandomIntBetween(32, 128);  
        assertThat(response.isVerbose(), equalTo(false));
                    source.field("name", "2");
        assertFalse(item.isFailed());
                .endArray()
                }  
        }
        }  
                .endObject()
        assertThat(getResponse.pipelines().size(), equalTo(0));  
import org.opensearch.transport.client.Requests;
        return super.nodeSettings(nodeOrdinal);
                }
            return Settings.builder().put(nonIngestNode()).put(super.nodeSettings(nodeOrdinal)).build();
        client().admin().cluster().putPipeline(putPipelineRequest).get();
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("2", BytesReference.bytes(source), MediaTypeRegistry.JSON);  
 *
            {
        assertNull(doc);  
                .setSource(Requests.INDEX_CONTENT_TYPE, "field", "value", "fail", true)
        assertThat(response.getItems().length, equalTo(bulkRequest.requests().size()));
        assertThat(simulateDocumentBaseResult.getIngestDocument().getSourceAndMetadata(), equalTo(ingestDocument.getSourceAndMetadata()));
                .startObject()
            XContentBuilder source = jsonBuilder().startObject();
                .startObject("test")  
                    source.endObject();
                .endArray()  
                .field("description", "my_pipeline")
                    source.field("name", "2");
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));  
        }
        assertTrue(deletePipelineResponse.isAcknowledged());
            }
                .startArray("docs")
        assertThat(doc.get("processed"), equalTo(true));
        assertThat(getResponse.pipelines().get(0).getId(), equalTo("_id"));
            BulkItemResponse itemResponse = response.getItems()[i];
        return Collections.singleton(ExtendedIngestTestPlugin.class);  
                    String onFailurePipeline = document.getFieldValue("_ingest.on_failure_pipeline", String.class);
                    source.startObject("fail");
                    source.endObject();  
/*  
        });  
/*  
                .field("description", "my_pipeline")  
        BulkResponse response = client().bulk(bulkRequest).actionGet();  
    public void testSingleDocIngestDrop() throws Exception {  
            }
            source.endObject();
    public void testBulkWithIngestFailures() throws Exception {
            jsonBuilder().startObject()
            client().admin().cluster().putPipeline(putPipelineRequest).get();
        assertEquals(DocWriteResponse.Result.NOOP, indexResponse.getResult());  
 * software distributed under the License is distributed on an
                {  
                .endObject()
 * GitHub history for details.
        return replicationSettings;
    @Override
                source.startObject();
        Map<String, Object> inserted = client().prepareGet("index", "1").get().getSourceAsMap();  
    }
            client().admin().cluster().putPipeline(putPipelineRequest).get();
        for (int i = 0; i < numRequests; i++) {
                .endArray()
                .endObject()
        client().admin().cluster().preparePutPipeline("_id", pipelineSource, MediaTypeRegistry.JSON).get();  
        assertNull(client().prepareGet("index", "_drop").get().getSourceAsMap());
import org.opensearch.action.bulk.BulkResponse;  
                }
                source.startArray("processors");
        indexRequest.source(Requests.INDEX_CONTENT_TYPE, "field1", "val1");
 * this work for additional information regarding copyright
            bulkRequest.add(indexRequest);
                    source.startObject("pipeline");
import org.opensearch.action.bulk.BulkItemResponse;
            XContentBuilder source = jsonBuilder().startObject();  
        {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertThat(indexResponse, notNullValue());
    }
                    source.endObject();  
            .add(client().prepareIndex("test").setId("2").setSource("field", "value2", "fail", false).setPipeline("_id"))  
        createIndex("test");
                .field("description", "my_pipeline")  
 * ownership. Elasticsearch licenses this file to you under  
                .endObject()
        client().admin().cluster().putPipeline(putPipelineRequest).get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        BulkRequest bulkRequest = new BulkRequest();  
    }  
        source.put("processed", true);  
        assertEquals("auto-generated", item.getResponse().getId());  
            jsonBuilder().startObject()
                }
 */
        AcknowledgedResponse deletePipelineResponse = client().admin().cluster().prepareDeletePipeline("_id").get();  
        client().admin().cluster().putPipeline(putPipelineRequest).get();
                }
 */  
    public void testBulkWithIngestFailuresAndDropBatch() throws Exception {
            .get();
                    source.startObject("fail");  
        assertThat(getResponse.isFound(), is(false));
import org.opensearch.core.xcontent.XContentBuilder;  
        IngestProcessorException ingestException = (IngestProcessorException) ExceptionsHelper.unwrap(e, IngestProcessorException.class);
                .endObject()
import java.util.HashMap;
            XContentBuilder source = jsonBuilder().startObject();
                .endObject()  
                .endArray()
            source.endObject();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            }
            {
        getResponse = client().admin().cluster().prepareGetPipeline("_id").get();
                .startArray("processors")
        assertThat(upserted.get("field1"), equalTo("upserted_val"));
            .setSource(Requests.INDEX_CONTENT_TYPE, "field", "value", "drop", true)
        {
                .endArray()  
import org.opensearch.action.DocWriteResponse;  
                .startArray("processors")
                    is(false)  
        assertThat(response.isAcknowledged(), is(true));
                .endArray()
                    "Expected a successful response but found failure [" + itemResponse.getFailure() + "].",
            PutPipelineRequest putPipelineRequest = new PutPipelineRequest("2", BytesReference.bytes(source), MediaTypeRegistry.JSON);
        }  
import org.opensearch.plugins.Plugin;
            .collect(Collectors.toMap(BulkItemResponse::getId, r -> r));  
import java.util.Map;
        bulkRequest.add(
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
        BytesReference source = BytesReference.bytes(
            }
        {  
 */  
            jsonBuilder().startObject()
            {
                source.startObject();  
                .setId("1")  
            .get()  
            source.endObject();
                .startObject()
                .startObject()  
        );  
                .startObject()
                source.endObject();  
 *
        PutPipelineRequest putPipelineRequest = new PutPipelineRequest("_id", source, MediaTypeRegistry.JSON);
        String clusterManagerOnlyNode = internalCluster().startClusterManagerOnlyNode();
        IndexRequest indexRequest = new IndexRequest("index").id("1").setPipeline("_id");
        assertThat(doc.get("field"), equalTo("value"));
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();  
        );  
            client().admin().cluster().putPipeline(putPipelineRequest).get();
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertThrows(  
import org.opensearch.action.ingest.DeletePipelineRequest;  
                .startObject("test")
                    source.startObject("pipeline");
        DocWriteResponse indexResponse = client().prepareIndex("test")
                    source.startObject("pipeline");
        // cleanup
        }  
 *  
                {  
        assertNull(results.get("_success").getFailure());
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());  
        BytesReference source = BytesReference.bytes(
            XContentBuilder source = jsonBuilder().startObject();
                .startArray("processors")
        );
        client().admin().cluster().putPipeline(putPipelineRequest).get();
    }
    public void testSimulate() throws Exception {  
        client().admin().cluster().putPipeline(putPipelineRequest).get();
        client().prepareIndex("test").setId("1").setPipeline("_id").setSource("field", "value", "fail", false).get();
                OpenSearchException compoundProcessorException = (OpenSearchException) failure.getCause();
        source.put("fail", false);
        BytesReference source = BytesReference.bytes(
                .endObject()  
            factories.put(
            OpenSearchParseException.class,  
            jsonBuilder().startObject()
        GetPipelineResponse getResponse = client().admin().cluster().getPipeline(getPipelineRequest).get();
                .startArray("processors")
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) response.getResults().get(0);
        Exception e = expectThrows(Exception.class, () -> {
    public void testPutWithPipelineFactoryError() throws Exception {  
                .field("_id", "id")
