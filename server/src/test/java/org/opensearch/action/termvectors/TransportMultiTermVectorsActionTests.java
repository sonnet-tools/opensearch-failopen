                ActionListener<MultiTermVectorsShardResponse> listener
            transportService,
            new Resolver()
            shardAction,
import org.opensearch.Version;
                                    true,
import static org.hamcrest.Matchers.equalTo;
                                        .field("required", false)
import org.opensearch.common.xcontent.XContentFactory;
            "transport",
            threadPool,
            protected void doExecute(
import org.opensearch.common.util.concurrent.AtomicArray;
 * ownership. Elasticsearch licenses this file to you under
        transportService = new TransportService(
import org.opensearch.cluster.service.ClusterService;
                                MediaTypeRegistry.JSON
    private static ThreadPool threadPool;
import static org.hamcrest.Matchers.instanceOf;
            clusterService,
import org.junit.BeforeClass;
                                        .startObject()
                                .put("index.number_of_replicas", 1)
            new ActionFilters(emptySet()),
    private static TransportMultiTermVectorsAction transportAction;
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
        when(
import static java.util.Collections.emptySet;
        when(operationRouting.shardId(eq(clusterState), eq(index1.getName()), nullable(String.class), nullable(String.class))).thenReturn(
                                            .startObject("_routing")
        @Override
        @Override
                                            .endObject()
                                            .startObject("_doc")
import org.opensearch.tasks.Task;
        final ShardIterator index1ShardIterator = mock(ShardIterator.class);
    private static ClusterService clusterService;
            ),
                assertEquals(2, responses.length());
            transportService,
 * You may obtain a copy of the License at
import org.opensearch.cluster.node.DiscoveryNode;
            NoopTracer.INSTANCE
                final ActionListener<MultiTermVectorsResponse> listener,
            ) {
        when(operationRouting.shardId(eq(clusterState), eq(index2.getName()), nullable(String.class), nullable(String.class))).thenReturn(
public class TransportMultiTermVectorsActionTests extends OpenSearchTestCase {
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    .put(
        );
        ) {
 * SPDX-License-Identifier: Apache-2.0
        return new Task(
                assertNull(responses.get(0));
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
 * compatible open source license.
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.common.xcontent.XContentHelper;
 * Modifications Copyright OpenSearch Contributors. See
                        )
                            .putMapping(
                            XContentHelper.convertToJson(
    public void testTransportMultiGetAction_withMissingRouting() {
        ) {
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.core.index.Index;
            threadPool,
 * Licensed to Elasticsearch under one or more contributor
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        };
                final Map<ShardId, MultiTermVectorsShardRequest> shardRequests
                boundAddress.publishAddress(),
        shardAction = null;
                        .putMapping(
                                            .endObject()
    @AfterClass
        @Override
                                .put("index.number_of_shards", 1)
                                        .startObject("_routing")
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
    static class ActionListenerAdapter implements ActionListener<MultiTermVectorsResponse> {
import static org.mockito.Mockito.mock;
import org.opensearch.core.common.bytes.BytesReference;
    public static void afterClass() {
            .metadata(
            return new Index("index1", randomBase64UUID());
        final OperationRouting operationRouting = mock(OperationRouting.class);
                        Settings.builder()
    private static TransportShardMultiTermsVectorAction shardAction;
                assertThat(responses.get(1).getFailure().getCause().getMessage(), equalTo("routing is required for [index1]/[type2]/[2]"));
        request.add(new TermVectorsRequest("index2", "1").routing("1"));
    static class Resolver extends IndexNameExpressionResolver {
                                            .startObject()
}
 *
            operationRouting.getShards(eq(clusterState), eq(index1.getName()), anyString(), nullable(String.class), nullable(String.class))
        final Index index1 = new Index("index1", randomBase64UUID());
                                true,
        threadPool = new TestThreadPool(TransportMultiGetActionTests.class.getSimpleName());
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.ActionFilters;
                                        .startObject("_doc")
                                    BytesReference.bytes(
        final Task task = createTask();
            @Override
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.ClusterState;
                                    MediaTypeRegistry.JSON
                new Metadata.Builder().put(
import org.opensearch.cluster.ClusterName;
    }
            new ActionFilters(emptySet()),
                Task task,
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
        when(index1ShardIterator.shardId()).thenReturn(new ShardId(index1, randomInt()));
            @Override
            super(new ThreadContext(Settings.EMPTY));
                final ActionListener<MultiTermVectorsResponse> listener,
                            Settings.builder()
                                        .endObject()
        shardAction = new TransportShardMultiTermsVectorAction(
        };
                                .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
    }
                                XContentHelper.convertToJson(
            emptyMap()
            mock(Transport.class),
        final ClusterState clusterState = ClusterState.builder(new ClusterName(TransportMultiGetActionTests.class.getSimpleName()))
                final AtomicArray<MultiTermVectorsItemResponse> responses,
 * GitHub history for details.
import org.opensearch.core.index.shard.ShardId;
                            )
            protected void executeShardAction(
            }
        final MultiTermVectorsRequestBuilder request = new MultiTermVectorsRequestBuilder(client, MultiTermVectorsAction.INSTANCE);
            "description",
                Settings.builder().put("node.name", "node1").build(),
    private static TransportService transportService;
            operationRouting.getShards(eq(clusterState), eq(index2.getName()), anyString(), nullable(String.class), nullable(String.class))
            }
                        )
        when(
import org.opensearch.common.util.concurrent.ThreadContext;
        final MultiTermVectorsRequestBuilder request = new MultiTermVectorsRequestBuilder(client, MultiTermVectorsAction.INSTANCE);
                            .put("index.number_of_shards", 1)
            new ShardId(index1, randomInt())
                shardActionInvoked.set(true);
import static java.util.Collections.emptyMap;
 * under the License.
        threadPool = null;
        when(clusterService.localNode()).thenReturn(transportService.getLocalNode());
 */
            }
            new ActionFilters(emptySet()),
                final AtomicArray<MultiTermVectorsItemResponse> responses,
        }
                MultiTermVectorsShardRequest request,
            ) {
        request.add(new TermVectorsRequest("index1", "1"));
                                .put("index.version.created", Version.CURRENT)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            emptySet(),
        public void onFailure(Exception e) {}
        clusterService = mock(ClusterService.class);
        Resolver() {
        ).thenReturn(index2ShardIterator);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.Metadata;
        transportService = null;
                                        .endObject()
                                            .field("required", true)
            @Override
import java.util.Map;
            MultiTermVectorsAction.NAME,
                                BytesReference.bytes(
        };
        request.add(new TermVectorsRequest("index2", "2"));
import org.opensearch.action.RoutingMissingException;
        final Index index2 = new Index("index2", randomBase64UUID());
import org.opensearch.action.IndicesRequest;
                        new IndexMetadata.Builder(index2.getName()).settings(
 * specific language governing permissions and limitations
            protected void executeShardAction(
import org.opensearch.core.xcontent.MediaTypeRegistry;
        };
                assertNull(responses.get(1));
            Settings.EMPTY,
        ) {
                            )
    public static void beforeClass() throws Exception {
            shardAction,
            randomLong(),
 *
            null,
        transportAction = null;
                assertEquals(2, responses.length());
                                        .endObject()
    }
        assertTrue(shardActionInvoked.get());
 */
    }
                )
        transportAction = new TransportMultiTermVectorsAction(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            @Override
 * not use this file except in compliance with the License.
        final Task task = createTask();
        assertTrue(shardActionInvoked.get());
            new TaskId(randomLong() + ":" + randomLong()),
    @BeforeClass
            new Resolver()
/*
                                ),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
            )
            new ShardId(index2, randomInt())
import static org.mockito.Mockito.eq;
import static org.opensearch.common.UUIDs.randomBase64UUID;
import org.opensearch.common.settings.Settings;
    public void testTransportMultiGetAction() {
import static org.mockito.Mockito.anyString;
            public TaskManager getTaskManager() {
    private static Task createTask() {
    }
        when(index2ShardIterator.shardId()).thenReturn(new ShardId(index2, randomInt()));
                    new IndexMetadata.Builder(index1.getName()).settings(
                    )
 * The OpenSearch Contributors require contributions made to
                    )
import org.opensearch.cluster.routing.OperationRouting;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.transport.Transport;
            ) {}
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
import org.junit.AfterClass;
                randomBase64UUID()
            boundAddress -> DiscoveryNode.createLocal(
    }
            new Resolver()
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
                                )
            clusterService,
                            .put("index.version.created", Version.CURRENT)
        );
                assertNull(responses.get(0));
/*
        );
        request.add(new TermVectorsRequest("index2", "2"));
import org.opensearch.test.OpenSearchTestCase;
        ) {
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
 *
import org.opensearch.transport.client.node.NodeClient;
import static org.mockito.Mockito.when;
        ).thenReturn(index1ShardIterator);
import static org.mockito.Mockito.nullable;
        when(clusterService.operationRouting()).thenReturn(operationRouting);
import org.opensearch.core.tasks.TaskId;
                                        XContentFactory.jsonBuilder()
 * Unless required by applicable law or agreed to in writing,
            .build();
import org.opensearch.action.get.TransportMultiGetActionTests;
                return taskManager;
 */
        clusterService = null;
                final Map<ShardId, MultiTermVectorsShardRequest> shardRequests
        final ShardIterator index2ShardIterator = mock(ShardIterator.class);
import java.util.concurrent.atomic.AtomicBoolean;
        }
                            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
                assertThat(responses.get(1).getFailure().getCause(), instanceOf(RoutingMissingException.class));
            transportService,
import org.opensearch.tasks.TaskManager;
            clusterService,
        transportAction = new TransportMultiTermVectorsAction(
                            .put("index.number_of_replicas", 1)
package org.opensearch.action.termvectors;
                                            .endObject()
import org.opensearch.cluster.routing.ShardIterator;
/*
import org.opensearch.transport.TransportService;
                                    XContentFactory.jsonBuilder()
                shardActionInvoked.set(true);
            mock(IndicesService.class),
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
                                    ),
        public void onResponse(MultiTermVectorsResponse response) {}
import org.opensearch.indices.IndicesService;
