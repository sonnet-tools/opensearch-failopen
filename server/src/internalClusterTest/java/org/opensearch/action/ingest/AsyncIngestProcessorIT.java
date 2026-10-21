        @Override
 *
import java.util.function.BiConsumer;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.ingest.AbstractProcessor;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.repositories.RepositoriesService;
            assertThat(getResponse.getSource().get("bar"), equalTo("baz-" + id));
        public Collection<Object> createComponents(
                    }
                    public String getType() {
            Supplier<RepositoriesService> repositoriesServiceSupplier
                        });
            bulkRequest.add(new IndexRequest("foobar").id(Integer.toString(i)).source("{}", MediaTypeRegistry.JSON).setPipeline("_id"));
 * KIND, either express or implied.  See the License for the
/**
/*
            processors.put("test-async", (factories, tag, description, config) -> {
                    }
                    }
            });
            return Collections.emptyList();
        }
import org.opensearch.threadpool.ThreadPool;
        int numDocs = randomIntBetween(8, 256);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        // A pipeline with 2 processors: the test async processor and sync test processor.
import org.opensearch.ingest.Processor;
            });
                return new AbstractProcessor(tag, description) {
        client().admin().cluster().putPipeline(new PutPipelineRequest("_id", pipelineBody, MediaTypeRegistry.JSON)).actionGet();
}
 * software distributed under the License is distributed on an
import java.util.function.Supplier;
import org.opensearch.env.Environment;
 * <p>
            NodeEnvironment nodeEnvironment,
        @Override
                    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
import org.opensearch.plugins.Plugin;
import org.opensearch.core.common.bytes.BytesReference;
 */
            Environment environment,
import java.util.Collection;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.common.bytes.BytesArray;
        }
    public void testAsyncProcessorImplementation() {
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
            IndexNameExpressionResolver expressionResolver,
 * In this test two test processor are defined that basically do the same operation, but a single processor
            assertThat(bulkResponse.getItems()[i].getId(), equalTo(id));
                            ingestDocument.setFieldValue("foo", "bar-" + id);
    }
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
 * executes asynchronously. The result of the operation should be the same and also the order in which the
 *
            Client client,
                    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            processors.put("test", (processorFactories, tag, description, config) -> {
import java.util.HashMap;
public class AsyncIngestProcessorIT extends OpenSearchSingleNodeTestCase {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * specific language governing permissions and limitations
 * the expected result is the same as if the same operation happens synchronously.
                        return ingestDocument;
 *
                    @Override
                };
        BulkRequest bulkRequest = new BulkRequest();
/*
                        throw new UnsupportedOperationException();
    }
                    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        return Collections.singleton(TestPlugin.class);
import org.opensearch.env.NodeEnvironment;
            String id = Integer.toString(i);
                        String id = (String) ingestDocument.getSourceAndMetadata().get("_id");
            // The expected result of sync test processor:
                            String id = (String) ingestDocument.getSourceAndMetadata().get("_id");
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.get.GetRequest;
                return new AbstractProcessor(tag, description) {
import org.opensearch.action.bulk.BulkRequest;
 * The OpenSearch Contributors require contributions made to
                        ingestDocument.setFieldValue("bar", "baz-" + id);
    @Override
import org.opensearch.plugins.IngestPlugin;
 * You may obtain a copy of the License at
 * bulk responses are returned should be the same as how the corresponding index requests were defined.
            Map<String, Processor.Factory> processors = new HashMap<>();
            // The expected result of async test processor:
        }
import org.opensearch.action.bulk.BulkResponse;
        public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
    }
            ThreadPool threadPool,
        BytesReference pipelineBody = new BytesArray("{\"processors\": [{\"test-async\": {}, \"test\": {}}]}");
 * GitHub history for details.
import org.opensearch.script.ScriptService;
            ResourceWatcherService resourceWatcherService,
 * The purpose of this test is to verify that when a processor executes an operation asynchronously that
import org.opensearch.transport.client.Client;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numDocs; i++) {
 * license agreements. See the NOTICE file distributed with
        }
        assertThat(bulkResponse.getItems().length, equalTo(numDocs));
                    @Override
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.ingest.IngestDocument;
 * ownership. Elasticsearch licenses this file to you under
            GetResponse getResponse = client().get(new GetRequest("foobar", id)).actionGet();
                            handler.accept(ingestDocument, null);
package org.opensearch.action.ingest;
            return processors;
            NamedWriteableRegistry namedWriteableRegistry,
        ) {
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < numDocs; i++) {
            this.threadPool = threadPool;
        private ThreadPool threadPool;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.action.index.IndexRequest;
 * compatible open source license.
                        return "test";
import java.util.Collections;
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this work for additional information regarding copyright
                    public String getType() {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
            ClusterService clusterService,
 */
                    }
 */
            NamedXContentRegistry xContentRegistry,
 */
import org.opensearch.watcher.ResourceWatcherService;
                    @Override
import org.opensearch.cluster.service.ClusterService;
    protected Collection<Class<? extends Plugin>> getPlugins() {
                    @Override
                };
    public static class TestPlugin extends Plugin implements IngestPlugin {
                        return "test-async";
                        threadPool.generic().execute(() -> {
                    @Override
                    }
import org.opensearch.action.get.GetResponse;
            assertThat(getResponse.getSource().get("foo"), equalTo("bar-" + id));
            ScriptService scriptService,
