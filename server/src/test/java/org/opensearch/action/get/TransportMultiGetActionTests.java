            }
        ) {
            new Resolver()
        transportService = new TransportService(
                                            .startObject()
 * this file be licensed under the Apache-2.0 license or a
        return new Task(
import org.junit.AfterClass;
            NoopTracer.INSTANCE
                                            .endObject()
            clusterService,
            shardAction,
                                    MediaTypeRegistry.JSON
import static org.mockito.Mockito.mock;
                                    true,
        threadPool = null;
        @Override
            new ActionFilters(emptySet()),
        transportAction = new TransportMultiGetAction(
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
                final AtomicArray<MultiGetItemResponse> responses,
 * specific language governing permissions and limitations
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, Preference.REPLICA.type(), "index1"));
        assertTrue(shardActionInvoked.get());
import org.opensearch.indices.IndicesService;
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, null, "index3"));
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
                            .put("index.number_of_shards", 1)
        }
                                            .startObject("_routing")
import java.util.concurrent.atomic.AtomicBoolean;
package org.opensearch.action.get;
                assertNull(responses.get(0));
        };
                return taskManager;
import org.opensearch.action.support.ActionFilters;
            new ActionFilters(emptySet()),
                assertEquals(2, responses.length());
    public static void beforeClass() throws Exception {
        public void onResponse(MultiGetResponse response) {}
            randomLong(),
 * the Apache License, Version 2.0 (the "License"); you may
                                        .endObject()
        when(
        threadPool = new TestThreadPool(TransportMultiGetActionTests.class.getSimpleName());
        );
        };
 * not use this file except in compliance with the License.
import org.opensearch.tasks.Task;
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.cluster.routing.ShardIterator;
            ) {
                final Map<ShardId, MultiGetShardRequest> shardRequests
            @Override
                        )
                                        .startObject("_doc")
        ) {
            threadPool,
        final Task task = createTask();
        clusterService = null;
            clusterService,
                                        .startObject("_routing")
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        transportAction = null;
        ) {
    private static ClusterService clusterService;
            new Resolver()
import org.opensearch.core.tasks.TaskId;
 * compatible open source license.
                            .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
            boundAddress -> DiscoveryNode.createLocal(
import org.opensearch.transport.TransportService;
                                            .field("required", true)
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        );
                                        .field("required", false)
            protected void executeShardAction(
import org.opensearch.common.xcontent.XContentFactory;
        // should return true since segment replication is enabled
    }
import java.util.Map;
        @Override
 *
import org.opensearch.Version;
                            XContentHelper.convertToJson(
                    .put(
            mock(Transport.class),
                randomBase64UUID()
import java.io.IOException;
import org.opensearch.cluster.service.ClusterService;
            public TaskManager getTaskManager() {
            ) {
            Settings.EMPTY,
                boundAddress.publishAddress(),
                            .put("index.version.created", Version.CURRENT)
                                .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
import org.opensearch.transport.client.node.NodeClient;
            emptySet(),
        when(clusterService.localNode()).thenReturn(transportService.getLocalNode());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.tasks.TaskManager;
            new Resolver()
    }
/*
        // should fail since document replication enabled
                            .putMapping(
import org.opensearch.cluster.ClusterState;
import java.util.concurrent.TimeUnit;
                                        .startObject()
        when(operationRouting.shardId(eq(clusterState), eq(index2.getName()), nullable(String.class), nullable(String.class))).thenReturn(
    }
            "transport",
            .metadata(
                                .put("index.number_of_replicas", 1)
        multiGetRequest.add("index2", "2");
import static java.util.Collections.emptyMap;
        final Task task = createTask();
        shardAction = new TransportShardMultiGetAction(
 */
                                .put("index.version.created", Version.CURRENT)
        ClusterState clusterState = clusterState(randomBoolean() ? ReplicationType.SEGMENT : ReplicationType.DOCUMENT, index1, index2);
        };
 * ownership. Elasticsearch licenses this file to you under
        transportService = null;
        final Index index1 = new Index("index1", randomBase64UUID());
 *
                final ActionListener<MultiGetResponse> listener,
    }
        transportAction = new TransportMultiGetAction(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * under the License.
        return ClusterState.builder(new ClusterName(TransportMultiGetActionTests.class.getSimpleName()))
 * KIND, either express or implied.  See the License for the
            @Override
import org.opensearch.common.util.concurrent.AtomicArray;
            new ShardId(index2, randomInt())
import org.opensearch.indices.replication.common.ReplicationType;
                assertThat(responses.get(1).getFailure().getFailure(), instanceOf(RoutingMissingException.class));
import org.opensearch.core.index.Index;
        @Override
import org.opensearch.action.RoutingMissingException;
import org.opensearch.cluster.ClusterName;
    private static ClusterState clusterState(ReplicationType replicationType, Index index1, Index index2) throws IOException {
    public void testTransportMultiGetAction() {
        metadata = clusterState(ReplicationType.DOCUMENT, index1, index2).getMetadata();
        // should return false since request is not realtime
/*
            @Override
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.transport.Transport;
                assertEquals(2, responses.length());
        multiGetRequest.add("index1", "1");
                shardActionInvoked.set(true);
import org.opensearch.cluster.metadata.ResolvedIndices;
                                            .endObject()
            protected void executeShardAction(
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.threadpool.ThreadPool;
            super(new ThreadContext(Settings.EMPTY));
            transportService,
        }
        ).thenReturn(index2ShardIterator);
import org.opensearch.core.action.ActionListener;
        Resolver() {
                            .put("index.number_of_replicas", 1)
            .build();
            new ShardId(index1, randomInt())
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, false, null, "index2"));
        final MultiGetRequestBuilder request = new MultiGetRequestBuilder(client, MultiGetAction.INSTANCE);
                assertNull(responses.get(1));
        when(index2ShardIterator.shardId()).thenReturn(new ShardId(index2, randomInt()));
 * SPDX-License-Identifier: Apache-2.0
                            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
                                true,
    private static TransportShardMultiGetAction shardAction;
    private static ThreadPool threadPool;
        final ShardIterator index2ShardIterator = mock(ShardIterator.class);
            transportService,
    public void testTransportMultiGetAction_withMissingRouting() {
import static org.mockito.Mockito.anyString;
 * Unless required by applicable law or agreed to in writing,
                                            .startObject("_doc")
            MultiGetAction.NAME,
    static class Resolver extends IndexNameExpressionResolver {
                                ),
            operationRouting.getShards(eq(clusterState), eq(index1.getName()), anyString(), nullable(String.class), nullable(String.class))
        request.add(new MultiGetRequest.Item("index1", "2"));
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        clusterService = mock(ClusterService.class);
                                .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
    public static void afterClass() {
    public void testResolveIndices() {
        request.add(new MultiGetRequest.Item("index1", "1"));
                    new IndexMetadata.Builder(index1.getName()).settings(
        when(index1ShardIterator.shardId()).thenReturn(new ShardId(index1, randomInt()));
        final ShardIterator index1ShardIterator = mock(ShardIterator.class);
                final Map<ShardId, MultiGetShardRequest> shardRequests
        Metadata metadata = clusterState(ReplicationType.SEGMENT, index1, index2).getMetadata();
        final Index index2 = new Index("index2", randomBase64UUID());
 * this work for additional information regarding copyright
                                            .endObject()
    static class ActionListenerAdapter implements ActionListener<MultiGetResponse> {
                        .putMapping(
        // should return false since preference is set for request
    }
                                MediaTypeRegistry.JSON
    @AfterClass
            ),
    private static TransportService transportService;
            clusterService,
/*
                shardActionInvoked.set(true);
import static org.opensearch.common.UUIDs.randomBase64UUID;
                                )
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
                                    ),
                                    BytesReference.bytes(
        shardAction = null;
            shardAction,
        final Index index1 = new Index("index1", randomBase64UUID());
                                        .endObject()
                                    XContentFactory.jsonBuilder()
            transportService,
import org.opensearch.common.settings.Settings;
                        )
            operationRouting.getShards(eq(clusterState), eq(index2.getName()), anyString(), nullable(String.class), nullable(String.class))
import org.opensearch.cluster.node.DiscoveryNode;
    }
                    )
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        when(clusterService.operationRouting()).thenReturn(operationRouting);
 */
}
            @Override
        assertTrue(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));
                        new IndexMetadata.Builder(index2.getName()).settings(
                assertThat(responses.get(1).getFailure().getFailure().getMessage(), equalTo("routing is required for [index2]/[_doc]/[2]"));
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return new Index("index1", randomBase64UUID());
            }
        ) {
 *
                            )
            mock(IndicesService.class),
    private static TransportMultiGetAction transportAction;
import org.opensearch.core.index.shard.ShardId;
            new ActionFilters(emptySet()),
                    )
                                XContentHelper.convertToJson(
            protected void doExecute(Task task, MultiGetShardRequest request, ActionListener<MultiGetShardResponse> listener) {}
    }
                final ActionListener<MultiGetResponse> listener,
    private static Task createTask() {
                assertNull(responses.get(0));
        public void onFailure(Exception e) {}
 * Licensed to Elasticsearch under one or more contributor
                                BytesReference.bytes(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.action.IndicesRequest;
                        Settings.builder()
            "description",
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));
import static java.util.Collections.emptySet;
        request.add(new MultiGetRequest.Item("index2", "1").routing("1"));
public class TransportMultiGetActionTests extends OpenSearchTestCase {
                Settings.builder().put("node.name", "node1").build(),
        final OperationRouting operationRouting = mock(OperationRouting.class);
                new Metadata.Builder().put(
        assertEquals(ResolvedIndices.of("index1", "index2"), transportAction.resolveIndices(multiGetRequest));
        transportAction = new TransportMultiGetAction(
import org.opensearch.cluster.routing.Preference;
import org.opensearch.cluster.metadata.Metadata;
    public void testShouldForcePrimaryRouting() throws IOException {
        when(operationRouting.shardId(eq(clusterState), eq(index1.getName()), nullable(String.class), nullable(String.class))).thenReturn(
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
    }
import org.opensearch.cluster.routing.OperationRouting;
 * You may obtain a copy of the License at
            new ActionFilters(emptySet()),
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
import org.junit.BeforeClass;
            threadPool,
        ).thenReturn(index1ShardIterator);
        assertTrue(shardActionInvoked.get());
        final Index index2 = new Index("index2", randomBase64UUID());
        transportAction.execute(task, request.request(), new ActionListenerAdapter());
        public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
            emptyMap()
            new Resolver()
import static org.mockito.ArgumentMatchers.nullable;
        when(
        );
                final AtomicArray<MultiGetItemResponse> responses,
import org.opensearch.core.common.bytes.BytesReference;
            clusterService,
import org.opensearch.cluster.metadata.IndexMetadata;
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
        // should return false since index doesn't exist
                                        XContentFactory.jsonBuilder()
    @BeforeClass
            }
        );
            null,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            new TaskId(randomLong() + ":" + randomLong()),
            shardAction,
            )
        request.add(new MultiGetRequest.Item("index2", "2"));
        };
                )
            transportService,
                                        .endObject()
 * The OpenSearch Contributors require contributions made to
                            Settings.builder()
    }
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
 * Modifications Copyright OpenSearch Contributors. See
                            )
                                .put("index.number_of_shards", 1)
import org.opensearch.threadpool.TestThreadPool;
import static org.mockito.Mockito.eq;
        final MultiGetRequestBuilder request = new MultiGetRequestBuilder(client, MultiGetAction.INSTANCE);
