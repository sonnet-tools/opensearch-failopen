        final Settings lowOrderFinalPipelineSettings = Settings.builder()
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");
            .cluster()
    public void testFinalPipelineOfOldDestinationIsNotInvoked() {
        client().admin()
            .actionGet();
                    ingestDocument.setFieldValue(IngestDocument.Metadata.INDEX.getFieldName(), "target");
        final GetRequestBuilder get = client().prepareGet("index", "1");
/*
            });
        client().admin()
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
            .setSettings(lowOrderFinalPipelineSettings)
import static org.hamcrest.Matchers.hasToString;
        assertEquals(1, target.getHits().getTotalHits().value());
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import org.opensearch.core.xcontent.NamedXContentRegistry;
            final NamedWriteableRegistry namedWriteableRegistry,
            .setSettings(highOrderFinalPipelineSettings)
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        }
import org.opensearch.action.get.GetRequestBuilder;
        client().admin()
        assertThat(source, hasKey("final"));
            .setOrder(lowOrder)
        createIndex("index", settings);
        } else {
        assertThat(response.status(), equalTo(RestStatus.CREATED));
                }
            });
 * license agreements. See the NOTICE file distributed with
                public String getType() {
            final Client client,
            .cluster()
        final Settings defaultPipelineSettings = Settings.builder()
    public static class TestPlugin extends Plugin implements IngestPlugin {
        @Override
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()
        client().admin()
            .setPatterns(Collections.singletonList("index*"))
            finalPipelineOrder = lowOrder;
        admin().indices()
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            final NamedXContentRegistry xContentRegistry,
                    return "request";
                public String getType() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "target_default_pipeline").build();
        SearchResponse target = client().prepareSearch("target").get();
        final int finalPipelineOrder;
        final IllegalArgumentException e = expectThrows(
                    @Override
            .get();
    }
            .cluster()
import org.opensearch.action.ingest.DeletePipelineRequest;
        createIndex("index", settings);
/*
            .getPipeline(new GetPipelineRequest("default_pipeline", "final_pipeline", "request_pipeline"))
    public void testHighOrderFinalPipelinePreferred() throws IOException {
            .actionGet();
 * SPDX-License-Identifier: Apache-2.0
        final int highOrder = randomIntBetween(lowOrder + 1, Integer.MAX_VALUE);
        ) {
            });
    }
            .cluster()
            .get();
            .actionGet();
import org.opensearch.threadpool.ThreadPool;
    public void testFinalPipelineOfNewDestinationIsInvoked() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
 * GitHub history for details.
        assertEquals(1, target.getHits().getTotalHits().value());
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
            .build();
import static org.hamcrest.Matchers.hasKey;
                        return ingestDocument;
            .cluster()
    @After
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final int highOrder = randomIntBetween(lowOrder + 1, Integer.MAX_VALUE);
        admin().indices()
import org.opensearch.common.settings.Settings;
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                @Override
 * specific language governing permissions and limitations
        assertThat(e, hasToString(containsString("pipeline with id [final_pipeline] does not exist")));
    public void testFinalPipeline() {
 *
                    ingestDocument.setFieldValue("request", true);
import org.opensearch.env.Environment;
        assertTrue(getResponse.isExists());
        final GetResponse getResponse = get.get();
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
        final Settings settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
import org.opensearch.script.ScriptService;
package org.opensearch.index;
import org.opensearch.core.rest.RestStatus;
        client().admin()
        final IndexResponse response = index.get();
                                throw new AssertionError(
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
    }
import java.util.Collections;
            .cluster()
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        client().admin()
        client().admin()
                    return ingestDocument;
            .setOrder(finalPipelineOrder)
        index.setSource(Collections.singletonMap("field", "value"));
 */
            .putPipeline(new PutPipelineRequest("request_pipeline", requestPipelineBody, MediaTypeRegistry.JSON))
                @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        return "final";
        index.setPipeline("request_pipeline");
            .actionGet();
        final GetRequestBuilder get = client().prepareGet("index", "1");
        assertTrue((boolean) source.get("final"));
 * ownership. Elasticsearch licenses this file to you under
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
        assertTrue((boolean) source.get("default"));
        final int defaultPipelineOrder;
        assertThat(source, hasKey("request"));
import org.opensearch.ingest.PipelineConfiguration;
            final ClusterService clusterService,
        final GetRequestBuilder get = client().prepareGet("index", "1");
            map.put("request", (processorFactories, tag, description, config) -> new AbstractProcessor(tag, description) {
import org.opensearch.test.OpenSearchIntegTestCase;
        final GetResponse getResponse = get.get();
        );
            final Supplier<RepositoriesService> repositoriesServiceSupplier
            .cluster()
import java.util.Collection;
import org.opensearch.action.index.IndexResponse;
                        }
            .actionGet();
        assertThat(source, hasKey("default"));
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
            .get();
        if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
        BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {}}]}");
            final HashMap<String, Processor.Factory> map = new HashMap<>(3);
 *
        assertEquals(true, target.getHits().getAt(0).getSourceAsMap().get("final"));
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
import org.opensearch.repositories.RepositoriesService;
                            }
 * this file be licensed under the Apache-2.0 license or a
                        // this asserts that this pipeline is the final pipeline executed
            .actionGet();
            finalPipelineOrder = highOrder;
        assertThat(source, hasKey("final"));
            .setId("1")
        final Settings highOrderFinalPipelineSettings = Settings.builder()
        client().admin()
        assertFalse(target.getHits().getAt(0).getSourceAsMap().containsKey("final"));
        final BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"default\": {}}]}");
            .preparePutTemplate("default")
        createIndex("index", settings);
        final Settings finalPipelineSettings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
                    @Override
                }
            .preparePutTemplate("high_order")
        Settings settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build();
        }
    @Override
            .get();
                    }
        assertThat(source, hasKey("default"));
                @Override
        // this asserts that the final_pipeline was used, without us having to actually create the pipeline etc.
            .actionGet();
                    return ingestDocument;
            .get();
        Settings settings = Settings.builder()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            client().admin().cluster().deletePipeline(new DeletePipelineRequest(pipeline.getId())).actionGet();
    public void testFinalPipelineCantChangeDestination() {
            IllegalArgumentException.class,
import org.opensearch.action.ingest.PutPipelineRequest;
        assertEquals(RestStatus.CREATED, indexResponse.status());
            .cluster()
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()
            .actionGet();
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");
            .get();
        final Settings settings = Settings.builder()
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"request\"}}]}");
            .cluster()
        assertTrue((boolean) source.get("default"));
                        if (exists != null) {
        admin().indices()
                    }
        admin().indices()
        public Collection<Object> createComponents(
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
            final ScriptService scriptService,
            .putPipeline(new PutPipelineRequest("target_default_pipeline", targetPipeline, MediaTypeRegistry.JSON))
            .get();
        // this asserts that the high_order_final_pipeline was selected, without us having to actually create the pipeline etc.
            .build();
        index.setSource(Collections.singletonMap("field", "value"));
            defaultPipelineOrder = lowOrder;
import org.opensearch.action.ingest.GetPipelineRequest;
            .actionGet();
            .setId("1")
        createIndex("index", settings);
        SearchResponse target = client().prepareSearch("target").get();
 * Modifications Copyright OpenSearch Contributors. See
}
                @Override
import org.opensearch.ingest.IngestDocument;
            .actionGet();
                }
    }
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");
import org.opensearch.plugins.IngestPlugin;
            .setPatterns(Collections.singletonList("index*"))
 * not use this file except in compliance with the License.
            IllegalArgumentException.class,
    }
            .put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline")
        final int lowOrder = randomIntBetween(0, Integer.MAX_VALUE - 1);
import org.opensearch.env.NodeEnvironment;
        client().admin()
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
    }
        }
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"default\"}}]}");
    }
        client().admin()
            .setPatterns(Collections.singletonList("index*"))
import static org.hamcrest.Matchers.containsString;
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
            final Environment environment,
        createIndex("index", settings);
import org.opensearch.ingest.Processor;
            .actionGet();
        createIndex("target", settings);
 * this work for additional information regarding copyright
                    return ingestDocument;
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
    }
            .cluster()
 * KIND, either express or implied.  See the License for the
        final BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"default\": {}}]}");
    public void testDefaultPipelineOfNewDestinationIsNotInvoked() {
            .cluster()
import org.opensearch.cluster.service.ClusterService;
 *
        client().admin()
    }
            .actionGet();
        SearchResponse target = client().prepareSearch("target").get();
            .setSource(Collections.singletonMap("field", "value"))
        assertEquals(1, target.getHits().getTotalHits().value());
                @Override
            return map;
    }
import org.opensearch.action.ingest.GetPipelineResponse;
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "high_order_final_pipeline")
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
import org.junit.After;
 * Unless required by applicable law or agreed to in writing,
        );
        IndexResponse indexResponse = client().prepareIndex("index")
        assertThat(e, hasToString(containsString("FINAL pipeline [final_pipeline] can't change the target index")));
            .setSource(Collections.singletonMap("field", "value"))
        assertThat(source, hasKey("final"));
    public void testDefaultAndFinalPipelineFromTemplates() {
                }
                }
            defaultPipelineOrder = highOrder;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
        }
        final IndexResponse response = index.get();
        assertThat(response.status(), equalTo(RestStatus.CREATED));
            .setId("1")
            .preparePutTemplate("final")
import org.opensearch.action.search.SearchResponse;
        IndexResponse indexResponse = client().prepareIndex("index")
/*
                    public String getType() {
        final GetResponse getResponse = get.get();
        createIndex("index", settings);
            final IndexNameExpressionResolver expressionResolver,
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");
            map.put("changing_dest", (processorFactories, tag, description, config) -> new AbstractProcessor(tag, description) {
        assertEquals(RestStatus.CREATED, indexResponse.status());
            .setOrder(defaultPipelineOrder)
        index.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        assertTrue(getResponse.isExists());
        final Map<String, Object> source = getResponse.getSourceAsMap();
        final BytesReference requestPipelineBody = new BytesArray("{\"processors\": [{\"request\": {}}]}");
        createIndex("index", settings);
            .cluster()
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline")
        settings = Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline").build();
            final ThreadPool threadPool,
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "low_order_final_pipeline")
 * compatible open source license.
                            if (ingestDocument.getSourceAndMetadata().containsKey(exists) == false) {
import java.util.HashMap;
import org.opensearch.core.common.bytes.BytesReference;
                    return "changing_dest";
        assertEquals(RestStatus.CREATED, indexResponse.status());
    }
        BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"no_such_field\"}}]}");
import org.opensearch.transport.client.Client;
import org.opensearch.watcher.ResourceWatcherService;
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.action.index.IndexRequestBuilder;
            .build();
        @Override
        final Map<String, Object> source = getResponse.getSourceAsMap();
        return Collections.singletonList(TestPlugin.class);
                    return "default";
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
            () -> client().prepareIndex("index").setId("1").setSource(Collections.singletonMap("field", "value")).get()
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
 * You may obtain a copy of the License at
            final NodeEnvironment nodeEnvironment,
                public String getType() {
        assertThat(response.status(), equalTo(RestStatus.CREATED));
        final IndexResponse response = index.get();
import org.opensearch.action.get.GetResponse;
 * software distributed under the License is distributed on an
                    public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
            map.put("default", (factories, tag, description, config) -> new AbstractProcessor(tag, description) {
import java.util.function.Supplier;
            .build();
                    ingestDocument.setFieldValue("default", true);
            .actionGet();
                @Override
    }
        assertTrue((boolean) source.get("final"));
            .setPatterns(Collections.singletonList("index*"))
            .putPipeline(new PutPipelineRequest("default_pipeline", defaultPipelineBody, MediaTypeRegistry.JSON))
            .put(IndexSettings.FINAL_PIPELINE.getKey(), "final_pipeline")
        assertTrue(getResponse.isExists());
        assertThat(e, hasToString(containsString("pipeline with id [high_order_final_pipeline] does not exist")));
                                    "expected document to contain [" + exists + "] but was [" + ingestDocument.getSourceAndMetadata()
                        ingestDocument.setFieldValue("final", true);
    public void cleanUpPipelines() {
 * The OpenSearch Contributors require contributions made to
    public void testRequestPipelineAndFinalPipeline() {
            .setSource(Collections.singletonMap("field", "value"))
        IndexResponse indexResponse = client().prepareIndex("index")
public class FinalPipelineIT extends OpenSearchIntegTestCase {
            final ResourceWatcherService resourceWatcherService,
                };
        assertFalse(target.getHits().getAt(0).getSourceAsMap().containsKey("final"));
 * under the License.
        index.setSource(Collections.singletonMap("field", "value"));
            .preparePutTemplate("low_order")
                return new AbstractProcessor(tag, description) {
        assertTrue((boolean) source.get("request"));
    public void testDefaultAndFinalPipeline() {
        for (final PipelineConfiguration pipeline : response.pipelines()) {
                final String exists = (String) config.remove("exists");
        client().admin()
import java.util.Map;
        final IllegalArgumentException e = expectThrows(
            .setOrder(highOrder)
import org.opensearch.action.support.WriteRequest;
        final BytesReference finalPipelineBody = new BytesArray("{\"processors\": [{\"final\": {\"exists\":\"default\"}}]}");
                }
        final IllegalStateException e = expectThrows(
        BytesReference defaultPipelineBody = new BytesArray("{\"processors\": [{\"changing_dest\": {}}]}");
import org.opensearch.plugins.Plugin;
 */
            .cluster()
            return Collections.emptyList();
            .cluster()
            IllegalStateException.class,
 * Licensed to Elasticsearch under one or more contributor
        BytesReference targetPipeline = new BytesArray("{\"processors\": [{\"final\": {}}]}");
            .setSettings(finalPipelineSettings)
            .build();
        assertTrue((boolean) source.get("final"));
            .actionGet();
        final GetPipelineResponse response = client().admin()
        client().admin()
            .putPipeline(new PutPipelineRequest("final_pipeline", finalPipelineBody, MediaTypeRegistry.JSON))
                                );
        );
            });
        Settings settings = Settings.builder().put(IndexSettings.DEFAULT_PIPELINE.getKey(), "default_pipeline").build();
        final Map<String, Object> source = getResponse.getSourceAsMap();
        final IndexRequestBuilder index = client().prepareIndex("index").setId("1");
 */
        final int lowOrder = randomIntBetween(0, Integer.MAX_VALUE - 1);
            map.put("final", (processorFactories, tag, description, config) -> {
import org.opensearch.ingest.AbstractProcessor;
        createIndex("target", settings);
            .setSettings(defaultPipelineSettings)
