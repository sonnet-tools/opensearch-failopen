        BytesReference pipelineBody = new BytesArray("{\"processors\": [{\"test-async\": {}, \"test\": {}}]}");
/**
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.threadpool.ThreadPool;
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            });  
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();  
            NamedWriteableRegistry namedWriteableRegistry,  
 *
 * In this test two test processor are defined that basically do the same operation, but a single processor  
        @Override
            return processors;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
                        String id = (String) ingestDocument.getSourceAndMetadata().get("_id");
            // The expected result of sync test processor:
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {  
 */  
                        return ingestDocument;
                    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.ingest.Processor;
        @Override
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.watcher.ResourceWatcherService;  
                            String id = (String) ingestDocument.getSourceAndMetadata().get("_id");
                    @Override
import org.opensearch.script.ScriptService;
        }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * specific language governing permissions and limitations
            assertThat(getResponse.getSource().get("foo"), equalTo("bar-" + id));
                    public String getType() {
    }  
            ResourceWatcherService resourceWatcherService,
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * Modifications Copyright OpenSearch Contributors. See  
                    }  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.env.Environment;  
import java.util.function.Supplier;
    public void testAsyncProcessorImplementation() {
                            handler.accept(ingestDocument, null);
import org.opensearch.action.get.GetResponse;  
                        threadPool.generic().execute(() -> {
                    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
            GetResponse getResponse = client().get(new GetRequest("foobar", id)).actionGet();
                return new AbstractProcessor(tag, description) {  
    protected Collection<Class<? extends Plugin>> getPlugins() {
                        return "test-async";  
 * SPDX-License-Identifier: Apache-2.0
 * the expected result is the same as if the same operation happens synchronously.
                    }
            processors.put("test", (processorFactories, tag, description, config) -> {
                    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {  
 * GitHub history for details.
 *
 * <p>
 * The purpose of this test is to verify that when a processor executes an operation asynchronously that  
        public Collection<Object> createComponents(  
import java.util.Collections;  
                    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            this.threadPool = threadPool;
import java.util.Collection;
        assertThat(bulkResponse.getItems().length, equalTo(numDocs));
            Client client,
        private ThreadPool threadPool;  
                    }
 * bulk responses are returned should be the same as how the corresponding index requests were defined.
        }
import java.util.HashMap;
import org.opensearch.repositories.RepositoriesService;
                };
        client().admin().cluster().putPipeline(new PutPipelineRequest("_id", pipelineBody, MediaTypeRegistry.JSON)).actionGet();
 * compatible open source license.
            IndexNameExpressionResolver expressionResolver,
import org.opensearch.action.index.IndexRequest;
    }  
                };
                        ingestDocument.setFieldValue("bar", "baz-" + id);  
            NamedXContentRegistry xContentRegistry,  
            Map<String, Processor.Factory> processors = new HashMap<>();
                    public String getType() {
                            ingestDocument.setFieldValue("foo", "bar-" + id);  
import org.opensearch.core.common.bytes.BytesArray;
import static org.hamcrest.Matchers.equalTo;  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numDocs; i++) {  
        }
import java.util.Map;
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
                    @Override  
/*
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.ingest.AbstractProcessor;
package org.opensearch.action.ingest;
 * ownership. Elasticsearch licenses this file to you under  
        int numDocs = randomIntBetween(8, 256);
                    @Override
            ThreadPool threadPool,  
            Supplier<RepositoriesService> repositoriesServiceSupplier
                    @Override
                        throw new UnsupportedOperationException();
import java.util.function.BiConsumer;  
            assertThat(bulkResponse.getItems()[i].getId(), equalTo(id));
import org.opensearch.cluster.service.ClusterService;  
            });  
import org.opensearch.action.bulk.BulkRequest;  
            processors.put("test-async", (factories, tag, description, config) -> {
                return new AbstractProcessor(tag, description) {
    @Override  
 */
            return Collections.emptyList();
}
            // The expected result of async test processor:  
        ) {  
import org.opensearch.plugins.Plugin;  
 * You may obtain a copy of the License at  
                        return "test";  
        return Collections.singleton(TestPlugin.class);
            Environment environment,
            ClusterService clusterService,
                    @Override
import org.opensearch.transport.client.Client;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.get.GetRequest;
            String id = Integer.toString(i);  
            assertThat(getResponse.getSource().get("bar"), equalTo("baz-" + id));  
import org.opensearch.ingest.IngestDocument;  
import org.opensearch.env.NodeEnvironment;
            bulkRequest.add(new IndexRequest("foobar").id(Integer.toString(i)).source("{}", MediaTypeRegistry.JSON).setPipeline("_id"));
import org.opensearch.action.bulk.BulkResponse;
        for (int i = 0; i < numDocs; i++) {
        BulkRequest bulkRequest = new BulkRequest();
            ScriptService scriptService,
public class AsyncIngestProcessorIT extends OpenSearchSingleNodeTestCase {
 * The OpenSearch Contributors require contributions made to  
        // A pipeline with 2 processors: the test async processor and sync test processor.  
 *  
import org.opensearch.plugins.IngestPlugin;
/*  
 * executes asynchronously. The result of the operation should be the same and also the order in which the
 * under the License.  
        }
                        });
            NodeEnvironment nodeEnvironment,
 * software distributed under the License is distributed on an
import org.opensearch.core.common.bytes.BytesReference;
    public static class TestPlugin extends Plugin implements IngestPlugin {
