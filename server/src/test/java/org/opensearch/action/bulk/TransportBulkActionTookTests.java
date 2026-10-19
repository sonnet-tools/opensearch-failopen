    // test unit conversion with a controlled clock  
    }
import org.opensearch.cluster.node.DiscoveryNode;
                resolver,
        if (Constants.WINDOWS) {
                System::nanoTime
import org.opensearch.action.IndicesRequest;
        );
            threadPool,
                null,
                actionFilters,
        threadPool = null;
    }  
        transportService.start();
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
    public static void afterClass() {  
                null,  
        }  
        boolean needToCheck() {
                    BulkRequest bulkRequest,
import org.opensearch.test.OpenSearchTestCase;
import static java.util.Collections.emptyMap;
/*
import org.opensearch.common.util.concurrent.AtomicArray;  
        runTestTook(true);
 *
    public void tearDown() throws Exception {
        IndexNameExpressionResolver resolver = new Resolver();
                @Override
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    expected.set(1000000);
            return request.indices();
                ) {  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
                    Task task,  
                ActionType<Response> action,
                    Map<String, IndexNotFoundException> indicesThatCannotBeCreated  
                null,
        }  
                }
import java.util.function.LongSupplier;
 * specific language governing permissions and limitations
import java.util.Collections;  
        }
            };
import org.opensearch.action.ActionRequest;  
import org.opensearch.cluster.service.ClusterService;
        NodeClient client = new NodeClient(Settings.EMPTY, threadPool) {
import org.junit.BeforeClass;  
                    AtomicArray<BulkItemResponse> responses,
                NoopTracer.INSTANCE  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.bulk;
 * SPDX-License-Identifier: Apache-2.0
        }
 * ownership. Elasticsearch licenses this file to you under  
}  
                ActionListener<Response> listener  
            OpenSearchTestCase.buildNewFakeTransportAddress(),
import org.opensearch.Version;
    public void testTookWithRealClock() throws Exception {  
import org.junit.AfterClass;
        @Override  
import org.opensearch.action.support.ActionFilters;
                indexNameExpressionResolver,  
import org.opensearch.core.action.ActionResponse;  
            );
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
                client,  
        } else {  
        action.doExecute(null, bulkRequest, new ActionListener<BulkResponse>() {
            ) {
import org.opensearch.action.support.AutoCreateIndex;
        }
                ) {
            bulkAction = Strings.replace(bulkAction, "\r\n", "\n");
import static org.hamcrest.CoreMatchers.equalTo;
    public void testTookWithControlledClock() throws Exception {
import org.opensearch.threadpool.TestThreadPool;
                @Override
                    );  
            TransportService transportService,
                resolver,  
            return randomBoolean();
                }  
            TransportShardBulkAction shardBulkAction,  
 * the Apache License, Version 2.0 (the "License"); you may
            super(new ThreadContext(Settings.EMPTY));  
import org.opensearch.test.transport.CapturingTransport;
    }
import org.opensearch.test.VersionUtils;  
import org.opensearch.index.IndexingPressureService;
    }
    }  
        };
            AutoCreateIndex autoCreateIndex,
                actionFilters,
                    Task task,
                new IndexingPressureService(Settings.EMPTY, clusterService),
 */  
 */
    public static void beforeClass() {
                clusterService,
            ) {
                Request request,
            NoopTracer.INSTANCE  
 * The OpenSearch Contributors require contributions made to  
                    ActionListener<BulkResponse> listener,
        super.tearDown();
                        bulkItemResponses.getTook().getMillis(),
                listener.onResponse((Response) new CreateIndexResponse(false, false, null));
    @BeforeClass  
        AtomicLong expected = new AtomicLong();  
                    expected.set(elapsed);
                void executeBulk(  
    }  
            }
                expected::get
            @Override
                        greaterThanOrEqualTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)
            ClusterService clusterService,
            IndexNameExpressionResolver indexNameExpressionResolver,  
    }
                    super.executeBulk(task, bulkRequest, startTimeNanos, listener, responses, indicesThatCannotBeCreated);  
                    Map<String, IndexNotFoundException> indicesThatCannotBeCreated
            @Override  
import org.junit.After;  
                relativeTimeProvider,
                        bulkItemResponses.getTook().getMillis(),  
        clusterService.close();  
        ) {  
                threadPool,  
    private void runTestTook(boolean controlled) throws Exception {
 */  
import org.opensearch.core.common.Strings;
import org.apache.lucene.util.Constants;
 *
                    assertThat(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                null,  
        Resolver() {
        TransportService transportService = capturingTransport.createTransportService(
import org.opensearch.indices.SystemIndices;
import java.util.concurrent.TimeUnit;  
import org.opensearch.threadpool.ThreadPool;  
                threadPool,
/*  
                clusterService,
                transportService,  
import org.opensearch.cluster.ClusterState;  
                    super.executeBulk(task, bulkRequest, startTimeNanos, listener, responses, indicesThatCannotBeCreated);  
            LongSupplier relativeTimeProvider
            return randomBoolean();  
    public void setUp() throws Exception {  
        ActionFilters actionFilters = new ActionFilters(new HashSet<>());
    }
        boolean shouldAutoCreate(String index, ClusterState state) {
            super(
    private ClusterService clusterService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ThreadPool threadPool,  
            public void onFailure(Exception e) {
            boundAddress -> clusterService.localNode(),  
        // translate Windows line endings (\r\n) to standard ones (\n)  
            ) {  
    private static ThreadPool threadPool;  
                    assertThat(  
            return new TestTransportBulkAction(
                    long startTimeNanos,  
    @After  
 * Licensed to Elasticsearch under one or more contributor  
                } else {
                    );
 *  
        DiscoveryNode discoveryNode = new DiscoveryNode(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        BulkRequest bulkRequest = new BulkRequest();
            };
    @AfterClass
                    long elapsed = spinForAtLeastOneMillisecond();
        }  
        super.setUp();
import org.opensearch.core.action.ActionListener;
        });
        transportService.acceptIncomingRequests();  
            null,
        @Override
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.opensearch.transport.TransportService;
    }
                        equalTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            "node",  
 * Unless required by applicable law or agreed to in writing,
            }  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
                null,
        threadPool = new TestThreadPool("TransportBulkActionTookTests");
public class TransportBulkActionTookTests extends OpenSearchTestCase {
            ActionFilters actionFilters,
            @Override  
                if (controlled) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            public void onResponse(BulkResponse bulkItemResponses) {
                }
        CapturingTransport capturingTransport = new CapturingTransport();
                shardBulkAction,  
    @Before
                client,
import java.nio.charset.StandardCharsets;
                void executeBulk(
        if (controlled) {  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
                new SystemIndices(emptyMap()),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
                    long startTimeNanos,
import org.opensearch.transport.client.node.NodeClient;
    static class TestTransportBulkAction extends TransportBulkAction {  
            emptyMap(),
import org.opensearch.common.settings.Settings;
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(  
 * not use this file except in compliance with the License.
        TransportBulkAction action = createAction(controlled, expected);
                null,  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                autoCreateIndex,
                transportService,
import java.util.HashSet;
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            }  
    static class Resolver extends IndexNameExpressionResolver {
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            return new TestTransportBulkAction(
                    BulkRequest bulkRequest,
                    ActionListener<BulkResponse> listener,  
 * license agreements. See the NOTICE file distributed with
import org.junit.Before;
 * software distributed under the License is distributed on an
    private TransportBulkAction createAction(boolean controlled, AtomicLong expected) {  
        runTestTook(false);
        TestTransportBulkAction(
    // test took advances with System#nanoTime
 * this work for additional information regarding copyright
                transportService,  
    }
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        clusterService = createClusterService(threadPool, discoveryNode);  
 * GitHub history for details.
import org.opensearch.tasks.Task;  
        }  
                client,
                actionFilters,
            Collections.emptySet(),
        @Override  
                clusterService,
                threadPool,
import org.opensearch.action.ActionType;
import java.util.concurrent.atomic.AtomicLong;
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    AtomicArray<BulkItemResponse> responses,
            clusterService.getSettings(),  
import org.opensearch.common.util.concurrent.ThreadContext;
/*  
import org.opensearch.index.IndexNotFoundException;  
            NodeClient client,
