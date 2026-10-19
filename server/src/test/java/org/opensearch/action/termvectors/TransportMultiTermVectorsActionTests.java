import java.util.concurrent.TimeUnit;
    }  
        threadPool = new TestThreadPool(TransportMultiGetActionTests.class.getSimpleName());
    }
                shardActionInvoked.set(true);
            .build();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.cluster.routing.ShardIterator;
                                .put("index.number_of_replicas", 1)  
            protected void doExecute(  
 * KIND, either express or implied.  See the License for the
                final Map<ShardId, MultiTermVectorsShardRequest> shardRequests  
        clusterService = mock(ClusterService.class);
                randomBase64UUID()
    private static TransportShardMultiTermsVectorAction shardAction;  
        when(clusterService.operationRouting()).thenReturn(operationRouting);
                    new IndexMetadata.Builder(index1.getName()).settings(
            null,
    static class ActionListenerAdapter implements ActionListener<MultiTermVectorsResponse> {
import org.opensearch.threadpool.ThreadPool;
                                true,
                Settings.builder().put("node.name", "node1").build(),  
        };  
            emptySet(),
import org.opensearch.cluster.metadata.IndexMetadata;
        when(index2ShardIterator.shardId()).thenReturn(new ShardId(index2, randomInt()));  
                                        .startObject("_routing")
import org.opensearch.cluster.node.DiscoveryNode;
    }  
 * compatible open source license.
                                        .endObject()  
        ) {
                                            .field("required", true)
        threadPool = null;
            super(new ThreadContext(Settings.EMPTY));
import org.opensearch.cluster.routing.OperationRouting;  
                MultiTermVectorsShardRequest request,
import org.opensearch.action.support.ActionFilters;
    private static Task createTask() {
        when(operationRouting.shardId(eq(clusterState), eq(index1.getName()), nullable(String.class), nullable(String.class))).thenReturn(  
                                ),
        when(clusterService.state()).thenReturn(clusterState);  
                                        .endObject()
        final Task task = createTask();  
            @Override
            protected void executeShardAction(
    private static ThreadPool threadPool;
                                XContentHelper.convertToJson(
import static org.hamcrest.Matchers.instanceOf;
        final ShardIterator index1ShardIterator = mock(ShardIterator.class);
    public static void beforeClass() throws Exception {  
        final Task task = createTask();
            "description",
        );
            transportService,
        assertTrue(shardActionInvoked.get());
                final ActionListener<MultiTermVectorsResponse> listener,
import org.opensearch.threadpool.TestThreadPool;
                )  
            public TaskManager getTaskManager() {  
            NoopTracer.INSTANCE  
            }
                            .put("index.number_of_replicas", 1)
 * not use this file except in compliance with the License.
                final Map<ShardId, MultiTermVectorsShardRequest> shardRequests
                        )
            new Resolver()  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.transport.TransportService;
import org.opensearch.action.RoutingMissingException;  
                                )
            new ShardId(index2, randomInt())
            ) {
        }
/*  
        final MultiTermVectorsRequestBuilder request = new MultiTermVectorsRequestBuilder(client, MultiTermVectorsAction.INSTANCE);
 * software distributed under the License is distributed on an
            new ActionFilters(emptySet()),
        transportAction = new TransportMultiTermVectorsAction(
 * this file be licensed under the Apache-2.0 license or a
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);  
                ActionListener<MultiTermVectorsShardResponse> listener  
import org.opensearch.tasks.Task;  
                assertNull(responses.get(0));
    private static ClusterService clusterService;
                return taskManager;
            Settings.EMPTY,
                    )
                                    BytesReference.bytes(
import org.opensearch.indices.IndicesService;
            )
                            Settings.builder()  
            new ActionFilters(emptySet()),  
 *
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
        final OperationRouting operationRouting = mock(OperationRouting.class);
        Resolver() {  
            mock(IndicesService.class),  
                                            .endObject()
            MultiTermVectorsAction.NAME,  
            return new Index("index1", randomBase64UUID());  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 */  
            new Resolver()
                                        .startObject("_doc")
        request.add(new TermVectorsRequest("index2", "1").routing("1"));  
import org.opensearch.core.common.bytes.BytesReference;  
 *
                assertEquals(2, responses.length());  
import static org.mockito.Mockito.when;
import org.opensearch.action.get.TransportMultiGetActionTests;
                                            .startObject()
 * under the License.  
                                    XContentFactory.jsonBuilder()
            ),  
                final AtomicArray<MultiTermVectorsItemResponse> responses,  
import org.opensearch.action.IndicesRequest;
    @AfterClass
                                            .endObject()
import org.opensearch.cluster.metadata.Metadata;
                assertEquals(2, responses.length());
        shardAction = null;  
            new ShardId(index1, randomInt())
                    )
            "transport",
import static java.util.Collections.emptyMap;
        final Index index1 = new Index("index1", randomBase64UUID());
 */
    public void testTransportMultiGetAction() {  
        assertTrue(shardActionInvoked.get());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        when(operationRouting.shardId(eq(clusterState), eq(index2.getName()), nullable(String.class), nullable(String.class))).thenReturn(  
                shardActionInvoked.set(true);  
                            .put("index.version.created", Version.CURRENT)  
 * specific language governing permissions and limitations
                                BytesReference.bytes(
 *  
        );
        final Index index2 = new Index("index2", randomBase64UUID());  
            new ActionFilters(emptySet()),
        ) {
                                .put("index.number_of_shards", 1)
        when(clusterService.localNode()).thenReturn(transportService.getLocalNode());
    }
                    .put(
        @Override
import org.opensearch.common.util.concurrent.ThreadContext;
        @Override  
                new Metadata.Builder().put(  
                        .putMapping(
    @BeforeClass
    public static void afterClass() {  
                Task task,
        public void onResponse(MultiTermVectorsResponse response) {}
        transportAction = null;
            shardAction,
/*
            randomLong(),
import static org.mockito.Mockito.nullable;  
        final ShardIterator index2ShardIterator = mock(ShardIterator.class);
import org.opensearch.core.index.Index;
import org.opensearch.core.tasks.TaskId;  
import org.opensearch.Version;
                            .put("index.number_of_shards", 1)
                assertNull(responses.get(1));  
import org.opensearch.tasks.TaskManager;
 * GitHub history for details.
                                            .endObject()  
import org.opensearch.cluster.ClusterState;
            shardAction,
        request.add(new TermVectorsRequest("index2", "2"));
                                .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
        when(  
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
                                .put("index.version.created", Version.CURRENT)
import org.opensearch.core.action.ActionListener;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.service.ClusterService;
import static org.mockito.Mockito.eq;
        ).thenReturn(index1ShardIterator);
            transportService,  
            threadPool,  
                            )  
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
        public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
import static java.util.Collections.emptySet;
import org.opensearch.common.util.concurrent.AtomicArray;
        return new Task(  
                                        .startObject()  
public class TransportMultiTermVectorsActionTests extends OpenSearchTestCase {  
                            XContentHelper.convertToJson(  
        );
        public void onFailure(Exception e) {}
    private static TransportMultiTermVectorsAction transportAction;
        clusterService = null;
import org.opensearch.common.xcontent.XContentHelper;
import static org.hamcrest.Matchers.equalTo;
        when(index1ShardIterator.shardId()).thenReturn(new ShardId(index1, randomInt()));  
                                            .startObject("_doc")
                                        .endObject()
            }
            mock(Transport.class),
                        )
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
                                    ),
            ) {
                                        XContentFactory.jsonBuilder()  
                assertNull(responses.get(0));
    }
    private static TransportService transportService;  
            @Override  
                                    MediaTypeRegistry.JSON
            new Resolver()  
                assertThat(responses.get(1).getFailure().getCause(), instanceOf(RoutingMissingException.class));
        when(  
                        new IndexMetadata.Builder(index2.getName()).settings(
            @Override
            operationRouting.getShards(eq(clusterState), eq(index2.getName()), anyString(), nullable(String.class), nullable(String.class))
 * SPDX-License-Identifier: Apache-2.0
    }  
        };
            ) {}
import org.opensearch.transport.Transport;  
            clusterService,  
        transportService = new TransportService(  
        };
import static org.mockito.Mockito.mock;
package org.opensearch.action.termvectors;
                final AtomicArray<MultiTermVectorsItemResponse> responses,
                                        .field("required", false)  
import static org.mockito.Mockito.anyString;  
import org.junit.AfterClass;  
                boundAddress.publishAddress(),
                assertThat(responses.get(1).getFailure().getCause().getMessage(), equalTo("routing is required for [index1]/[type2]/[2]"));  
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
                            )
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
        ) {
/*  
    public void testTransportMultiGetAction_withMissingRouting() {
        @Override  
    }
                final ActionListener<MultiTermVectorsResponse> listener,
 * this work for additional information regarding copyright
import java.util.concurrent.atomic.AtomicBoolean;
                                MediaTypeRegistry.JSON  
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
            boundAddress -> DiscoveryNode.createLocal(
import java.util.Map;  
        shardAction = new TransportShardMultiTermsVectorAction(  
                            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())  
import org.opensearch.cluster.ClusterName;  
                            .putMapping(  
        }
            @Override
                                            .startObject("_routing")  
        final ClusterState clusterState = ClusterState.builder(new ClusterName(TransportMultiGetActionTests.class.getSimpleName()))
}  
    static class Resolver extends IndexNameExpressionResolver {
        final MultiTermVectorsRequestBuilder request = new MultiTermVectorsRequestBuilder(client, MultiTermVectorsAction.INSTANCE);  
import org.opensearch.common.xcontent.XContentFactory;  
                        Settings.builder()
 * Licensed to Elasticsearch under one or more contributor  
        request.add(new TermVectorsRequest("index2", "2"));
import org.opensearch.test.OpenSearchTestCase;  
        ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ).thenReturn(index2ShardIterator);
import org.junit.BeforeClass;
        request.add(new TermVectorsRequest("index1", "1"));
import org.opensearch.core.index.shard.ShardId;
            .metadata(
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        transportAction = new TransportMultiTermVectorsAction(
                                    true,  
import org.opensearch.common.settings.Settings;  
        };
            }
 */  
            operationRouting.getShards(eq(clusterState), eq(index1.getName()), anyString(), nullable(String.class), nullable(String.class))
            emptyMap()  
        transportService = null;  
            threadPool,
 * license agreements. See the NOTICE file distributed with
            transportService,
            new TaskId(randomLong() + ":" + randomLong()),
            clusterService,
            protected void executeShardAction(  
import org.opensearch.transport.client.node.NodeClient;
import static org.opensearch.common.UUIDs.randomBase64UUID;  
            clusterService,
