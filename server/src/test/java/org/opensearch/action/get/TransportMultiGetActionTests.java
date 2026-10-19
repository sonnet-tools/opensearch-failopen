                                        .endObject()  
 * software distributed under the License is distributed on an
import org.junit.AfterClass;
            new ActionFilters(emptySet()),
                shardActionInvoked.set(true);
                final ActionListener<MultiGetResponse> listener,
            clusterService,
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
                randomBase64UUID()
import org.opensearch.cluster.service.ClusterService;  
                                    ),  
                                        .startObject()  
 * Licensed to Elasticsearch under one or more contributor  
    }
                    )
        transportAction = null;
            new ShardId(index2, randomInt())
        }
    }
        when(clusterService.state()).thenReturn(clusterState);  
        ).thenReturn(index1ShardIterator);
            new Resolver()
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.core.index.Index;
            emptyMap()  
import static java.util.Collections.emptyMap;
                            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())  
                                        .endObject()
                    )
        @Override  
            threadPool,
        ) {
import static org.opensearch.common.UUIDs.randomBase64UUID;  
    public static void beforeClass() throws Exception {
        when(  
            new ActionFilters(emptySet()),
 * GitHub history for details.
            )  
                                        .field("required", false)  
                                        .startObject("_routing")
import org.opensearch.action.support.ActionFilters;
 *
                            .put("index.version.created", Version.CURRENT)
    }
                assertNull(responses.get(1));
                final AtomicArray<MultiGetItemResponse> responses,
 * this file be licensed under the Apache-2.0 license or a
    }
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
import static org.mockito.Mockito.eq;
        }
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;
    public void testTransportMultiGetAction_withMissingRouting() {
        ) {  
import org.opensearch.cluster.metadata.IndexMetadata;
            @Override
            @Override
import static org.hamcrest.Matchers.equalTo;
                                        XContentFactory.jsonBuilder()
import org.opensearch.indices.IndicesService;  
    private static ClusterService clusterService;
            operationRouting.getShards(eq(clusterState), eq(index2.getName()), anyString(), nullable(String.class), nullable(String.class))
    private static Task createTask() {
public class TransportMultiGetActionTests extends OpenSearchTestCase {  
    public void testTransportMultiGetAction() {
import org.opensearch.cluster.routing.ShardIterator;
                            )
            new ShardId(index1, randomInt())
                final Map<ShardId, MultiGetShardRequest> shardRequests  
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        // should return false since index doesn't exist
    @BeforeClass
                                .put("index.number_of_replicas", 1)  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.routing.OperationRouting;  
            MultiGetAction.NAME,  
/*
            ) {
                                        .startObject("_doc")
            "description",
        ) {  
                            Settings.builder()  
 */  
                final AtomicArray<MultiGetItemResponse> responses,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static ClusterState clusterState(ReplicationType replicationType, Index index1, Index index2) throws IOException {
                    new IndexMetadata.Builder(index1.getName()).settings(  
        assertTrue(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));
            @Override
        final Index index1 = new Index("index1", randomBase64UUID());  
        ClusterState clusterState = clusterState(randomBoolean() ? ReplicationType.SEGMENT : ReplicationType.DOCUMENT, index1, index2);  
                final ActionListener<MultiGetResponse> listener,  
    }  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        @Override
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                                .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
        final Index index2 = new Index("index2", randomBase64UUID());
                new Metadata.Builder().put(
/*  
            operationRouting.getShards(eq(clusterState), eq(index1.getName()), anyString(), nullable(String.class), nullable(String.class))
 *  
            shardAction,  
        when(operationRouting.shardId(eq(clusterState), eq(index1.getName()), nullable(String.class), nullable(String.class))).thenReturn(  
            protected void executeShardAction(  
                                .put("index.version.created", Version.CURRENT)
            ),
        final MultiGetRequestBuilder request = new MultiGetRequestBuilder(client, MultiGetAction.INSTANCE);
                                            .field("required", true)
                        .putMapping(
    public static void afterClass() {
    static class Resolver extends IndexNameExpressionResolver {
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);  
            shardAction,
            }
import org.opensearch.threadpool.TestThreadPool;  
            return new Index("index1", randomBase64UUID());  
    private static TransportShardMultiGetAction shardAction;  
        metadata = clusterState(ReplicationType.DOCUMENT, index1, index2).getMetadata();
            Settings.EMPTY,  
        return ClusterState.builder(new ClusterName(TransportMultiGetActionTests.class.getSimpleName()))  
        final OperationRouting operationRouting = mock(OperationRouting.class);
                                            .endObject()
        final MultiGetRequestBuilder request = new MultiGetRequestBuilder(client, MultiGetAction.INSTANCE);
                                    XContentFactory.jsonBuilder()
import org.opensearch.core.tasks.TaskId;
        shardAction = new TransportShardMultiGetAction(  
        };
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, null, "index3"));
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            new ActionFilters(emptySet()),
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, false, null, "index2"));
        };
        assertEquals(ResolvedIndices.of("index1", "index2"), transportAction.resolveIndices(multiGetRequest));
                assertThat(responses.get(1).getFailure().getFailure(), instanceOf(RoutingMissingException.class));
            ) {  
        transportAction.execute(task, request.request(), new ActionListenerAdapter());  
                            .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
import org.opensearch.common.util.concurrent.ThreadContext;  
            }  
                            )
                                            .startObject()
    private static TransportMultiGetAction transportAction;
                                XContentHelper.convertToJson(
import static org.mockito.Mockito.mock;  
import org.opensearch.core.common.bytes.BytesReference;
                        Settings.builder()
        when(clusterService.operationRouting()).thenReturn(operationRouting);
            clusterService,  
                )  
import org.opensearch.action.RoutingMissingException;  
        Resolver() {  
import org.opensearch.cluster.node.DiscoveryNode;
        final Index index1 = new Index("index1", randomBase64UUID());
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
    static class ActionListenerAdapter implements ActionListener<MultiGetResponse> {
 */  
 * not use this file except in compliance with the License.
        final Task task = createTask();  
        // should return false since preference is set for request
        threadPool = new TestThreadPool(TransportMultiGetActionTests.class.getSimpleName());  
import static org.mockito.ArgumentMatchers.nullable;  
        };
                                BytesReference.bytes(
        final Index index2 = new Index("index2", randomBase64UUID());
                                            .startObject("_routing")
            clusterService,
 * license agreements. See the NOTICE file distributed with
            new ActionFilters(emptySet()),
            transportService,
                                    BytesReference.bytes(  
            mock(Transport.class),
import org.opensearch.cluster.routing.Preference;
import org.opensearch.Version;
        assertTrue(shardActionInvoked.get());
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(shardActionInvoked.get());
            threadPool,
        ).thenReturn(index2ShardIterator);
                                            .endObject()
                Settings.builder().put("node.name", "node1").build(),
            transportService,
        final ShardIterator index1ShardIterator = mock(ShardIterator.class);
        threadPool = null;
            NoopTracer.INSTANCE
                                        .endObject()
        when(index2ShardIterator.shardId()).thenReturn(new ShardId(index2, randomInt()));  
                assertNull(responses.get(0));
import static java.util.Collections.emptySet;
                return taskManager;  
            mock(IndicesService.class),  
        transportAction = new TransportMultiGetAction(  
        when(operationRouting.shardId(eq(clusterState), eq(index2.getName()), nullable(String.class), nullable(String.class))).thenReturn(  
        );
    }
            new TaskId(randomLong() + ":" + randomLong()),
    private static ThreadPool threadPool;
/*  
        clusterService = mock(ClusterService.class);
    }  
        when(  
        public void onFailure(Exception e) {}
            emptySet(),
        request.add(new MultiGetRequest.Item("index2", "1").routing("1"));
        assertFalse(TransportMultiGetAction.shouldForcePrimaryRouting(metadata, true, Preference.REPLICA.type(), "index1"));
                            XContentHelper.convertToJson(  
            @Override
                                    MediaTypeRegistry.JSON
import org.opensearch.action.IndicesRequest;
            new Resolver()  
                        )
                                            .startObject("_doc")  
        final Task task = createTask();
                                .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
        final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);  
        request.add(new MultiGetRequest.Item("index2", "2"));  
                assertThat(responses.get(1).getFailure().getFailure().getMessage(), equalTo("routing is required for [index2]/[_doc]/[2]"));
            protected void executeShardAction(
        );
import org.opensearch.transport.Transport;
                        )  
import java.util.Map;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.cluster.metadata.ResolvedIndices;
            null,  
            boundAddress -> DiscoveryNode.createLocal(
                            .putMapping(
        transportAction.execute(task, request.request(), new ActionListenerAdapter());  
                                            .endObject()  
            transportService,
 *
 * under the License.  
import org.opensearch.cluster.ClusterState;  
        };
            }  
        transportAction = new TransportMultiGetAction(  
import org.junit.BeforeClass;  
 * this work for additional information regarding copyright
        final ShardIterator index2ShardIterator = mock(ShardIterator.class);
        Metadata metadata = clusterState(ReplicationType.SEGMENT, index1, index2).getMetadata();
        public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
            clusterService,
        multiGetRequest.add("index2", "2");
            protected void doExecute(Task task, MultiGetShardRequest request, ActionListener<MultiGetShardResponse> listener) {}  
                        new IndexMetadata.Builder(index2.getName()).settings(
import org.opensearch.common.util.concurrent.AtomicArray;
            public TaskManager getTaskManager() {
                shardActionInvoked.set(true);
import static org.mockito.Mockito.when;
        ) {
        );
package org.opensearch.action.get;
                                MediaTypeRegistry.JSON  
            .metadata(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            shardAction,  
                                .put("index.number_of_shards", 1)
            randomLong(),
        clusterService = null;  
    @AfterClass
                assertEquals(2, responses.length());
                final Map<ShardId, MultiGetShardRequest> shardRequests
import java.util.concurrent.atomic.AtomicBoolean;
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));
        // should return false since request is not realtime
                            .put("index.number_of_shards", 1)  
            super(new ThreadContext(Settings.EMPTY));
        // should fail since document replication enabled  
 * SPDX-License-Identifier: Apache-2.0
            transportService,
            .build();
 */
                                ),
        request.add(new MultiGetRequest.Item("index1", "1"));  
            new Resolver()  
                                    true,
        // should return true since segment replication is enabled
    }
                                )  
                            .put("index.number_of_replicas", 1)
 * Unless required by applicable law or agreed to in writing,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
        public void onResponse(MultiGetResponse response) {}
import org.opensearch.indices.replication.common.ReplicationType;
    }
import org.opensearch.common.xcontent.XContentHelper;
 * KIND, either express or implied.  See the License for the
        return new Task(  
                                true,
        when(index1ShardIterator.shardId()).thenReturn(new ShardId(index1, randomInt()));  
        multiGetRequest.add("index1", "1");  
}  
import org.opensearch.tasks.TaskManager;  
        when(clusterService.localNode()).thenReturn(transportService.getLocalNode());
        @Override  
import org.opensearch.cluster.ClusterName;
    public void testShouldForcePrimaryRouting() throws IOException {
 * compatible open source license.
        transportAction = new TransportMultiGetAction(
import org.opensearch.core.action.ActionListener;  
import static org.mockito.Mockito.anyString;
            new Resolver()
import org.opensearch.transport.TransportService;  
import org.opensearch.core.index.shard.ShardId;  
        );  
            "transport",
        transportService = new TransportService(
                assertEquals(2, responses.length());  
        request.add(new MultiGetRequest.Item("index1", "2"));
import org.opensearch.transport.client.node.NodeClient;
        final AtomicBoolean shardActionInvoked = new AtomicBoolean(false);
                assertNull(responses.get(0));  
                    .put(
import org.opensearch.tasks.Task;
import org.opensearch.threadpool.ThreadPool;
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.cluster.metadata.Metadata;  
    public void testResolveIndices() {
import java.util.concurrent.TimeUnit;
                boundAddress.publishAddress(),  
        transportService = null;
    private static TransportService transportService;  
        shardAction = null;
