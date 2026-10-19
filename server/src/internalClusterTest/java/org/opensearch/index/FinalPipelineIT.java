            .build();  
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {  
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertEquals(RestStatus.CREATED, indexResponse.status());
import org.opensearch.action.ingest.DeletePipelineRequest;
                    @Override
            .cluster()
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
                        return "final";
import org.opensearch.action.index.IndexRequestBuilder;  
            .get();
                public String getType() {
    }
    public void testFinalPipeline() {
import org.opensearch.action.ingest.GetPipelineResponse;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            .putPipeline(new PutPipelineRequest("request_pipeline", requestPipelineBody, MediaTypeRegistry.JSON))  
        createIndex("target", settings);
 * You may obtain a copy of the License at  
        createIndex("index", settings);
        Settings settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build();  
                        ingestDocument.setFieldValue("final", true);
    }  
            .setSource(Collections.singletonMap("field", "value"))
            IllegalArgumentException.class,
            .build();  
 *
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");  
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
            .setSource(Collections.singletonMap("field", "value"))
    }  
        client().admin()
        client().admin()
            client().admin().cluster().deletePipeline(new DeletePipelineRequest(pipeline.getId())).actionGet();
        final GetRequestBuilder get = client().prepareGet("index", "1");  
 *  
            .setId("1")
        assertThat(e, hasToString(containsString("pipeline with id [high_order_final_pipeline] does not exist")));
        final IndexResponse response = index.get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {}}]}");  
                @Override  
            .preparePutTemplate("low_order")
        assertThat(source, hasKey("final"));  
import org.opensearch.env.Environment;
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.action.index.IndexResponse;
import org.opensearch.watcher.ResourceWatcherService;  
                @Override  
        client().admin()
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))  
            map.put("changing_dest", (processorFactories, tag, description, config) -> new AbstractProcessor(tag, description) {
            .cluster()
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");
                    return "default";  
        admin().indices()
        }  
        final IllegalArgumentException e = expectThrows(
 * KIND, either express or implied.  See the License for the
    }
    public void cleanUpPipelines() {
        final GetRequestBuilder get = client().prepareGet("index", "1");
        final BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"default\": {}}]}");
            final NodeEnvironment nodeEnvironment,  
                    public String getType() {  
        final IllegalStateException e = expectThrows(
 * Unless required by applicable law or agreed to in writing,
            return map;  
                    }
        assertThat(source, hasKey("request"));
                    return ingestDocument;  
/*  
                    @Override  
 * The OpenSearch Contributors require contributions made to  
            .actionGet();
            .setOrder(finalPipelineOrder)
import org.opensearch.ingest.IngestDocument;
    public void testDefaultPipelineOfNewDestinationIsNotInvoked() {
        assertTrue(getResponse.isExists());  
import java.util.Collections;
        final IndexResponse response = index.get();
            .setPatterns(Collections.singletonList("index*"))
                }
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))  
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()
import org.opensearch.ingest.AbstractProcessor;
import org.opensearch.env.NodeEnvironment;  
            .cluster()
        final IndexResponse response = index.get();
/*  
import java.util.function.Supplier;
        assertTrue((boolean) source.get("final"));
                            }
    }
        IndexResponse indexResponse = client().prepareIndex("index")  
                    public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
                                );
        }  
        index.setSource(Collections.singletonMap("field", "value"));
import org.opensearch.core.rest.RestStatus;
import static org.hamcrest.Matchers.hasKey;  
    }
        assertFalse(target.getHits().getAt(0).getSourceAsMap().containsKey("final"));
        assertEquals(1, target.getHits().getTotalHits().value());
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        @Override  
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline")
 * this file be licensed under the Apache-2.0 license or a
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"default\"}}]}");
 * the Apache License, Version 2.0 (the "License"); you may
            .build();  
                    }  
        );  
            .cluster()
            final ScriptService scriptService,  
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"request\"}}]}");
            .get();  
        assertThat(source, hasKey("default"));
            return Collections.emptyList();
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
            .actionGet();
 * compatible open source license.
            .get();  
 * under the License.  
                    return "request";
            map.put("request", (processorFactories, tag, description, config) -> new AbstractProcessor(tag, description) {
            .cluster()
                }
        admin().indices()
            .setPatterns(Collections.singletonList("index*"))  
    public static class TestPlugin extends Plugin implements IngestPlugin {
            .cluster()
                public String getType() {
    public void testFinalPipelineCantChangeDestination() {  
        assertThat(source, hasKey("default"));
}
            defaultPipelineOrder = lowOrder;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        SearchResponse target = client().prepareSearch("target").get();  
        final GetResponse getResponse = get.get();
        final Settings highOrderFinalPipelineSettings = Settings.builder()
                    return ingestDocument;  
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
import org.opensearch.ingest.Processor;
                            if (ingestDocument.getSourceAndMetadata().containsKey(exists) == false) {
package org.opensearch.index;
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
import java.io.IOException;  
            .setId("1")
        client().admin()
        assertThat(response.status(), equalTo(RestStatus.CREATED));
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");  
 */
            });
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.plugins.Plugin;  
            .get();
        return Collections.singletonList(TestPlugin.class);
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        assertThat(source, hasKey("final"));
    }
        for (final PipelineConfiguration pipeline : response.pipelines()) {
        final Map<String, Object> source = getResponse.getSourceAsMap();
        client().admin()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexResponse indexResponse = client().prepareIndex("index")  
        assertTrue(getResponse.isExists());
        @Override
        final GetPipelineResponse response = client().admin()  
                }  
                        // this asserts that this pipeline is the final pipeline executed
import static org.hamcrest.Matchers.containsString;
        Settings settings = Settings.builder()  
        );
            .getPipeline(new GetPipelineRequest("default_pipeline", "final_pipeline", "request_pipeline"))
import org.opensearch.action.get.GetResponse;
        assertTrue(getResponse.isExists());
            IllegalStateException.class,
            .setPatterns(Collections.singletonList("index*"))  
            });
            .setSettings(finalPipelineSettings)
            final ClusterService clusterService,  
            .preparePutTemplate("default")
        final int lowOrder = randomIntBetween(0, Integer.MAX_VALUE - 1);
            final NamedXContentRegistry xContentRegistry,
        final BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"default\": {}}]}");  
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline")
    public void testHighOrderFinalPipelinePreferred() throws IOException {
import org.opensearch.repositories.RepositoriesService;
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;  
                    return ingestDocument;
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
                @Override  
 */  
        // this asserts that the final_pipeline was used, without us having to actually create the pipeline etc.  
public class FinalPipelineIT extends OpenSearchIntegTestCase {  
                    return "changing_dest";
        settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();  
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
            .cluster()
import org.junit.After;
    }  
        final GetResponse getResponse = get.get();
        final BytesReference requestPipelineBody = new BytesArray("{\"processors\": [{\"request\": {}}]}");  
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "high_order_final_pipeline")
    @Override
        final int lowOrder = randomIntBetween(0, Integer.MAX_VALUE - 1);
            .setId("1")
        final int defaultPipelineOrder;
    }  
                        return ingestDocument;
        assertTrue((boolean) source.get("default"));  
        final GetRequestBuilder get = client().prepareGet("index", "1");  
        client().admin()
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))  
        createIndex("index", settings);
import org.opensearch.action.get.GetRequestBuilder;
        index.setPipeline("request_pipeline");
        admin().indices()  
            .get();
        assertThat(e, hasToString(containsString("pipeline with id [final_pipeline] does not exist")));
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))  
    public void testFinalPipelineOfOldDestinationIsNotInvoked() {
 */  
    @After
import org.opensearch.script.ScriptService;
        final Settings settings = Settings.builder()  
            });
        assertEquals(true, target.getHits().getAt(0).getSourceAsMap().get("final"));
        BytesReference targetPipeline = new BytesArray("{\"processors\": [{\"final\": {}}]}");  
            finalPipelineOrder = highOrder;
            .build();  
                        if (exists != null) {  
                        }  
    public void testDefaultAndFinalPipelineFromTemplates() {
        assertEquals(RestStatus.CREATED, indexResponse.status());
            .actionGet();
/*
            .get();  
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
        // this asserts that the high_order_final_pipeline was selected, without us having to actually create the pipeline etc.
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        createIndex("index", settings);
import org.opensearch.cluster.service.ClusterService;  
                public String getType() {
        final int highOrder = randomIntBetween(lowOrder + 1, Integer.MAX_VALUE);  
        createIndex("index", settings);
 * software distributed under the License is distributed on an
            final Environment environment,
        assertThat(response.status(), equalTo(RestStatus.CREATED));  
        final GetResponse getResponse = get.get();
        }
            .cluster()  
 * ownership. Elasticsearch licenses this file to you under  
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");
        assertThat(response.status(), equalTo(RestStatus.CREATED));
                    ingestDocument.setFieldValue(IngestDocument.Metadata.INDEX.getFieldName(), "target");
        client().admin()
import org.opensearch.action.ingest.PutPipelineRequest;
            .actionGet();
            defaultPipelineOrder = highOrder;  
        final int finalPipelineOrder;  
        index.setSource(Collections.singletonMap("field", "value"));
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
            .putPipeline(new PutPipelineRequest("target_default_pipeline", targetPipeline, MediaTypeRegistry.JSON))  
                }
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");  
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();  
        createIndex("index", settings);
            .actionGet();
                                throw new AssertionError(
 * specific language governing permissions and limitations
        final int highOrder = randomIntBetween(lowOrder + 1, Integer.MAX_VALUE);
            finalPipelineOrder = lowOrder;
    public void testFinalPipelineOfNewDestinationIsInvoked() {
import org.opensearch.action.search.SearchResponse;  
import java.util.Collection;
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
    }  
                @Override  
        assertThat(e, hasToString(containsString("FINAL pipeline [final_pipeline] can't change the target index")));
                    ingestDocument.setFieldValue("default", true);  
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))  
                }  
            final HashMap<String, Processor.Factory> map = new HashMap<>(3);
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))  
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
        final Settings lowOrderFinalPipelineSettings = Settings.builder()
            .setSource(Collections.singletonMap("field", "value"))
import org.opensearch.plugins.IngestPlugin;
 * Licensed to Elasticsearch under one or more contributor  
                @Override
        final IllegalArgumentException e = expectThrows(  
                };  
            map.put("final", (processorFactories, tag, description, config) -> {  
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .actionGet();
            .cluster()
            .actionGet();
    }
            .cluster()
            .cluster()  
import org.opensearch.transport.client.Client;
        assertEquals(RestStatus.CREATED, indexResponse.status());
            .setPatterns(Collections.singletonList("index*"))  
            .build();
            .preparePutTemplate("final")
            .setOrder(lowOrder)
        assertTrue((boolean) source.get("final"));
    public void testDefaultAndFinalPipeline() {
                @Override
        client().admin()  
import org.opensearch.action.support.WriteRequest;
 *
        client().admin()
        createIndex("target", settings);
            .cluster()
                    ingestDocument.setFieldValue("request", true);
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
        index.setSource(Collections.singletonMap("field", "value"));  
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");  
            IllegalArgumentException.class,
                return new AbstractProcessor(tag, description) {
        client().admin()
            .actionGet();
        ) {
            final ThreadPool threadPool,
        final Settings defaultPipelineSettings = Settings.builder()  
        BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"no_such_field\"}}]}");  
            .actionGet();  
        SearchResponse target = client().prepareSearch("target").get();  
        assertTrue((boolean) source.get("final"));
 * license agreements. See the NOTICE file distributed with
        final Map<String, Object> source = getResponse.getSourceAsMap();  
            .preparePutTemplate("high_order")
    }  
            .setSettings(highOrderFinalPipelineSettings)
            .actionGet();
            final NamedWriteableRegistry namedWriteableRegistry,
            .cluster()
            final ResourceWatcherService resourceWatcherService,
        admin().indices()
            .actionGet();  
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()  
            .actionGet();  
            .setSettings(defaultPipelineSettings)
            .cluster()
            .setOrder(highOrder)
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
            .actionGet();  
 * SPDX-License-Identifier: Apache-2.0
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"default\"}}]}");
        createIndex("index", settings);
                                    "expected document to contain [" + exists + "] but was [" + ingestDocument.getSourceAndMetadata()  
            .setOrder(defaultPipelineOrder)  
            map.put("default", (factories, tag, description, config) -> new AbstractProcessor(tag, description) {
        assertThat(source, hasKey("final"));  
        assertEquals(1, target.getHits().getTotalHits().value());
        Settings settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build();  
            });
        assertTrue((boolean) source.get("default"));
        IndexResponse indexResponse = client().prepareIndex("index")  
        assertTrue((boolean) source.get("request"));
import java.util.HashMap;  
import org.opensearch.action.ingest.GetPipelineRequest;  
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "low_order_final_pipeline")
            final IndexNameExpressionResolver expressionResolver,
        SearchResponse target = client().prepareSearch("target").get();  
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
        final Map<String, Object> source = getResponse.getSourceAsMap();  
            final Client client,
import org.opensearch.core.common.bytes.BytesArray;
                }
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
            .actionGet();
    public void testRequestPipelineAndFinalPipeline() {
        assertFalse(target.getHits().getAt(0).getSourceAsMap().containsKey("final"));
        }
import static org.hamcrest.Matchers.equalTo;
            .setSettings(lowOrderFinalPipelineSettings)
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()  
 * not use this file except in compliance with the License.
        final Settings finalPipelineSettings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();  
        public Collection<Object> createComponents(
import org.opensearch.core.xcontent.NamedXContentRegistry;
                final String exists = (String) config.remove("exists");
        client().admin()
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
import org.opensearch.ingest.PipelineConfiguration;  
        client().admin()  
        client().admin()
        settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "target_default_pipeline").build();  
        createIndex("index", settings);
            final Supplier<RepositoriesService> repositoriesServiceSupplier  
import java.util.Map;
        } else {
import static org.hamcrest.Matchers.hasToString;
        assertEquals(1, target.getHits().getTotalHits().value());
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");
