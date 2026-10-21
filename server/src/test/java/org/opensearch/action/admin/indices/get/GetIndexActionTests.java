        getIndexAction.execute(
    private SettingsFilter settingsFilter;
import org.opensearch.cluster.service.ClusterService;
            null,
                exception -> {
        threadPool = null;
            ActionListener.wrap(
        super.setUp();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/*
                    "index context should be present as it was set",
                new ActionFilters(emptySet()),
        );
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
 * You may obtain a copy of the License at
                noDefaultsResponse -> assertNull(
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
        Resolver() {
 * SPDX-License-Identifier: Apache-2.0
    private TransportService transportService;
    class TestTransportGetIndexAction extends TransportGetIndexAction {
            GetIndexRequest request,
                ),
 * compatible open source license.
        );
        ) {
import org.opensearch.common.util.concurrent.ThreadContext;
        }
                    "index.refresh_interval should be set as we are including defaults",
    static class Resolver extends IndexNameExpressionResolver {
            null,
    private Context context;
 * the Apache License, Version 2.0 (the "License"); you may
                defaultsResponse -> assertNotNull(
            String[] concreteIndices,
import java.util.concurrent.TimeUnit;
    }
            ClusterState stateWithIndex = ClusterStateCreationUtils.stateWithContext(indexName, 1, 1, context);
        GetIndexRequest contextIndexRequest = new GetIndexRequest().indices(indexName);
import org.opensearch.common.settings.SettingsModule;
}
        transportService.acceptIncomingRequests();
        context = new Context(randomAlphaOfLength(5));
            NoopTracer.INSTANCE
 * this file be licensed under the Apache-2.0 license or a
            return request.indices();
            contextIndexRequest,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            for (int x = 0; x < out.length; x++) {
    private final String indexName = "test_index";
            threadPool,
 * license agreements. See the NOTICE file distributed with
    private ClusterService clusterService;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.core.action.ActionListener;
            noDefaultsRequest,
        @Override
 * not use this file except in compliance with the License.
            )
                exception -> {
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS
        GetIndexRequest noDefaultsRequest = new GetIndexRequest().indices(indexName);
    }
import org.junit.Before;
        }
                ),
            null,
 *
            ActionListener<GetIndexResponse> listener
            boundAddress -> clusterService.localNode(),
import org.opensearch.transport.TransportService;
        }
    private ThreadPool threadPool;
import org.opensearch.threadpool.TestThreadPool;
        @Override
        clusterService = getInstanceFromNode(ClusterService.class);
 */
import org.opensearch.cluster.metadata.ResolvedIndices;
public class GetIndexActionTests extends OpenSearchSingleNodeTestCase {
                indicesService,
        indicesService = getInstanceFromNode(IndicesService.class);
        transportService = capturingTransport.createTransportService(
    private TestTransportGetIndexAction getIndexAction;
 */
            null,
                settingsFilter,
/*
 */
/*
        super.tearDown();
    @Before
 *
package org.opensearch.action.admin.indices.get;
            ClusterState state,
import org.junit.After;
    }
 * The OpenSearch Contributors require contributions made to
                GetIndexActionTests.this.transportService,
        CapturingTransport capturingTransport = new CapturingTransport();
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.index.Index;
import org.opensearch.cluster.metadata.Context;
            super(new ThreadContext(Settings.EMPTY));
                ),
                    throw new AssertionError(exception);
    public void testContextInResponse() {
        public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request) {
            Index[] out = new Index[request.indices().length];
        getIndexAction.execute(
        }
            ActionListener.wrap(
        transportService.start();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
            defaultsRequest,
            }
                    throw new AssertionError(exception);
    }
        protected void doClusterManagerOperation(
        getIndexAction.execute(
        getIndexAction = new GetIndexActionTests.TestTransportGetIndexAction();
                }
    @After
                    "index.refresh_interval should be null as it was never set",
            super.doClusterManagerOperation(request, concreteIndices, stateWithIndex, listener);
                }
        public Index[] concreteIndices(ClusterState state, IndicesRequest request) {
                    noDefaultsResponse.getSetting(indexName, "index.refresh_interval")
    public void tearDown() throws Exception {
 * this work for additional information regarding copyright
            )
                exception -> {
        TestTransportGetIndexAction() {
                    resp.contexts().get(indexName) != null && resp.contexts().get(indexName).equals(context)
    public void testDoNotIncludeDefaults() {
            return ResolvedIndices.Local.Concrete.of(concreteIndices(state, request));
import org.opensearch.common.settings.Settings;
            ActionListener.wrap(
        @Override
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
                new GetIndexActionTests.Resolver(),
import org.opensearch.action.IndicesRequest;
import org.opensearch.cluster.ClusterState;
    }
    public void setUp() throws Exception {
    }
                resp -> assertTrue(
            return out;
 *
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            clusterService.getSettings(),
 * under the License.
    private IndicesService indicesService;
            emptySet(),
import static java.util.Collections.emptyList;
                out[x] = new Index(request.indices()[x], "_na_");
        threadPool = new TestThreadPool("GetIndexActionTests");
import org.opensearch.test.transport.CapturingTransport;
        }
        );
import static java.util.Collections.emptySet;
            )
        );
import org.opensearch.common.settings.IndexScopedSettings;
 * GitHub history for details.
            super(
                GetIndexActionTests.this.threadPool,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.settings.SettingsFilter;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
 * ownership. Elasticsearch licenses this file to you under
                    throw new AssertionError(exception);
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.IndicesService;
                    defaultsResponse.getSetting(indexName, "index.refresh_interval")
                GetIndexActionTests.this.clusterService,
    public void testIncludeDefaults() {
            );
        GetIndexRequest defaultsRequest = new GetIndexRequest().indices(indexName).includeDefaults(true);
