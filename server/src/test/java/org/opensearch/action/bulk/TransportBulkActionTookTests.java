            Collections.emptySet(),
                }
                void executeBulk(
                ActionListener<Response> listener
import org.opensearch.index.IndexNotFoundException;
/*
    // test unit conversion with a controlled clock
                @Override
    public static void beforeClass() {
import org.opensearch.index.IndexingPressureService;
        CapturingTransport capturingTransport = new CapturingTransport();
        transportService.acceptIncomingRequests();
                ActionType<Response> action,
        Resolver() {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                null,
                    long elapsed = spinForAtLeastOneMillisecond();
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
import java.nio.charset.StandardCharsets;
/*
                    );
                    assertThat(
    static class TestTransportBulkAction extends TransportBulkAction {
    @Before
 * compatible open source license.
 *
        ) {
            return randomBoolean();
        });
 * SPDX-License-Identifier: Apache-2.0
        @Override
                resolver,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.transport.client.node.NodeClient;
                clusterService,
                Request request,
 * license agreements. See the NOTICE file distributed with
                    long startTimeNanos,
            ) {
                indexNameExpressionResolver,
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
public class TransportBulkActionTookTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.common.util.concurrent.ThreadContext;
import org.junit.BeforeClass;
            "node",
    private static ThreadPool threadPool;
    public static void afterClass() {
                    AtomicArray<BulkItemResponse> responses,
import org.opensearch.action.ActionRequest;
                ) {
                null,
            }
                        bulkItemResponses.getTook().getMillis(),
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
                null,
            };
    }
import org.opensearch.action.support.ActionFilters;
        }
                    AtomicArray<BulkItemResponse> responses,
                clusterService,
            };
            AutoCreateIndex autoCreateIndex,
            boundAddress -> clusterService.localNode(),
        );
import org.opensearch.action.IndicesRequest;
            super(new ThreadContext(Settings.EMPTY));
            bulkAction = Strings.replace(bulkAction, "\r\n", "\n");
import org.opensearch.Version;
                actionFilters,
    @After
 * Licensed to Elasticsearch under one or more contributor
                    assertThat(
                new IndexingPressureService(Settings.EMPTY, clusterService),
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
            super(
        DiscoveryNode discoveryNode = new DiscoveryNode(
 * this work for additional information regarding copyright
                    Map<String, IndexNotFoundException> indicesThatCannotBeCreated
            ) {
import org.opensearch.cluster.node.DiscoveryNode;
        @Override
import java.util.function.LongSupplier;
            );
                null,
    }
import org.opensearch.core.action.ActionResponse;
 * ownership. Elasticsearch licenses this file to you under
    public void testTookWithRealClock() throws Exception {
        }
                ) {
        runTestTook(true);
 * the Apache License, Version 2.0 (the "License"); you may
        clusterService.close();
    public void testTookWithControlledClock() throws Exception {
 * KIND, either express or implied.  See the License for the
        ActionFilters actionFilters = new ActionFilters(new HashSet<>());
        runTestTook(false);
import org.junit.AfterClass;
            public void onResponse(BulkResponse bulkItemResponses) {
    @AfterClass
        @Override
                }
                client,
        TransportBulkAction action = createAction(controlled, expected);
 * not use this file except in compliance with the License.
        );
        action.doExecute(null, bulkRequest, new ActionListener<BulkResponse>() {
                }
import org.opensearch.action.ActionType;
            emptyMap(),
                resolver,
import org.apache.lucene.util.Constants;
                actionFilters,
import org.opensearch.common.util.concurrent.AtomicArray;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        NodeClient client = new NodeClient(Settings.EMPTY, threadPool) {
                threadPool,
import org.opensearch.cluster.node.DiscoveryNodeRole;
            VersionUtils.randomCompatibleVersion(random(), Version.CURRENT)
        TransportService transportService = capturingTransport.createTransportService(
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
            @Override
import java.util.HashSet;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 */
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
 * GitHub history for details.
}
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.bulk;
                autoCreateIndex,
    }
    }
        };
                        bulkItemResponses.getTook().getMillis(),
                null,
                    expected.set(elapsed);
                    BulkRequest bulkRequest,
            ActionFilters actionFilters,
                    ActionListener<BulkResponse> listener,
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.core.common.Strings;
import org.opensearch.tasks.Task;
import static java.util.Collections.emptyMap;
import org.opensearch.transport.TransportService;
                System::nanoTime
            }
            threadPool,
                    ActionListener<BulkResponse> listener,
            null,
                listener.onResponse((Response) new CreateIndexResponse(false, false, null));
                threadPool,
 * under the License.
    }
                actionFilters,
 */
import org.opensearch.core.action.ActionListener;
                    expected.set(1000000);
    }
                threadPool,
                NoopTracer.INSTANCE
    private TransportBulkAction createAction(boolean controlled, AtomicLong expected) {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            LongSupplier relativeTimeProvider
                void executeBulk(
    static class Resolver extends IndexNameExpressionResolver {
                null,
                if (controlled) {
                expected::get
                client,
import org.junit.Before;
        boolean needToCheck() {
            OpenSearchTestCase.buildNewFakeTransportAddress(),
        }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                    Map<String, IndexNotFoundException> indicesThatCannotBeCreated
        }
        super.setUp();
 * specific language governing permissions and limitations
            ) {
            @Override
        AtomicLong expected = new AtomicLong();
import java.util.concurrent.TimeUnit;
                    super.executeBulk(task, bulkRequest, startTimeNanos, listener, responses, indicesThatCannotBeCreated);
    private void runTestTook(boolean controlled) throws Exception {
                @Override
        }
            clusterService.getSettings(),
        threadPool = new TestThreadPool("TransportBulkActionTookTests");
import java.util.Collections;
import org.opensearch.cluster.ClusterState;
                    Task task,
            public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
            return request.indices();
        } else {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        if (controlled) {
                        greaterThanOrEqualTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))
        }
        super.tearDown();
            ClusterService clusterService,
        threadPool = null;
    }
 *
    @BeforeClass
            return new TestTransportBulkAction(
    // test took advances with System#nanoTime
 * You may obtain a copy of the License at
import org.opensearch.cluster.service.ClusterService;
 *
            @Override
                    Task task,
                    long startTimeNanos,
                relativeTimeProvider,
import static org.hamcrest.CoreMatchers.equalTo;
                shardBulkAction,
            IndexNameExpressionResolver indexNameExpressionResolver,
            return new TestTransportBulkAction(
            NoopTracer.INSTANCE
    }
        if (Constants.WINDOWS) {
            TransportService transportService,
import org.opensearch.test.VersionUtils;
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
    public void setUp() throws Exception {
                client,
            NodeClient client,
import org.opensearch.action.support.AutoCreateIndex;
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        boolean shouldAutoCreate(String index, ClusterState state) {
        }
    }
                clusterService,
    private ClusterService clusterService;
                    super.executeBulk(task, bulkRequest, startTimeNanos, listener, responses, indicesThatCannotBeCreated);
            ThreadPool threadPool,
 */
                    BulkRequest bulkRequest,
 * The OpenSearch Contributors require contributions made to
                transportService,
                } else {
        transportService.start();
import org.opensearch.indices.SystemIndices;
import org.junit.After;
                new SystemIndices(emptyMap()),
                        equalTo(TimeUnit.MILLISECONDS.convert(expected.get(), TimeUnit.NANOSECONDS))
import org.opensearch.test.transport.CapturingTransport;
                    );
/*
    public void tearDown() throws Exception {
            TransportShardBulkAction shardBulkAction,
            return randomBoolean();
        IndexNameExpressionResolver resolver = new Resolver();
        // translate Windows line endings (\r\n) to standard ones (\n)
import org.opensearch.common.settings.Settings;
                transportService,
        clusterService = createClusterService(threadPool, discoveryNode);
                transportService,
    }
        TestTransportBulkAction(
