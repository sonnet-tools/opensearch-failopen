 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            return out;
        );
    class TestTransportGetIndexAction extends TransportGetIndexAction {
            return ResolvedIndices.Local.Concrete.of(concreteIndices(state, request));
        super.tearDown();
package org.opensearch.action.admin.indices.get;
        clusterService = getInstanceFromNode(ClusterService.class);  
                ),
            null,  
            contextIndexRequest,  
            GetIndexRequest request,  
        }  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            for (int x = 0; x < out.length; x++) {
import org.opensearch.indices.IndicesService;
                new GetIndexActionTests.Resolver(),
        GetIndexRequest defaultsRequest = new GetIndexRequest().indices(indexName).includeDefaults(true);
import org.opensearch.test.transport.CapturingTransport;
                exception -> {  
import org.opensearch.cluster.ClusterState;
        }
import org.opensearch.action.IndicesRequest;
            boundAddress -> clusterService.localNode(),
            emptySet(),  
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        protected void doClusterManagerOperation(
}
            }
public class GetIndexActionTests extends OpenSearchSingleNodeTestCase {
        CapturingTransport capturingTransport = new CapturingTransport();
                ),
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.service.ClusterService;
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
                GetIndexActionTests.this.threadPool,
 * Modifications Copyright OpenSearch Contributors. See
                GetIndexActionTests.this.transportService,
        getIndexAction.execute(
                    throw new AssertionError(exception);
 * You may obtain a copy of the License at  
    public void testIncludeDefaults() {
            clusterService.getSettings(),
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            super(new ThreadContext(Settings.EMPTY));  
                    defaultsResponse.getSetting(indexName, "index.refresh_interval")  
    }  
        );
 * this file be licensed under the Apache-2.0 license or a
        @Override
/*  
    private IndicesService indicesService;
            ActionListener.wrap(  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    }
        }
                    noDefaultsResponse.getSetting(indexName, "index.refresh_interval")
        GetIndexRequest contextIndexRequest = new GetIndexRequest().indices(indexName);  
        }  
    }  
 * KIND, either express or implied.  See the License for the
                exception -> {
        );  
                    "index.refresh_interval should be set as we are including defaults",
            noDefaultsRequest,
 * The OpenSearch Contributors require contributions made to  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
 * compatible open source license.
import org.opensearch.common.util.concurrent.ThreadContext;
        transportService.acceptIncomingRequests();
import org.opensearch.common.settings.SettingsFilter;
                indicesService,
                    "index context should be present as it was set",  
 */
    public void testDoNotIncludeDefaults() {  
 * not use this file except in compliance with the License.
            super(
                ),  
            ActionListener.wrap(
 * this work for additional information regarding copyright
 *
    private ClusterService clusterService;
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
import org.junit.Before;  
        }
                    resp.contexts().get(indexName) != null && resp.contexts().get(indexName).equals(context)
            ClusterState state,
                settingsFilter,
        @Override  
                    throw new AssertionError(exception);  
            null,
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS  
                GetIndexActionTests.this.clusterService,  
    private final String indexName = "test_index";
                }
 * software distributed under the License is distributed on an
                    "index.refresh_interval should be null as it was never set",
        ) {
            Index[] out = new Index[request.indices().length];
import org.junit.After;
        public Index[] concreteIndices(ClusterState state, IndicesRequest request) {  
        @Override
            );
import org.opensearch.cluster.metadata.Context;
            threadPool,
    public void tearDown() throws Exception {
import org.opensearch.transport.TransportService;
                resp -> assertTrue(
                    throw new AssertionError(exception);
        threadPool = null;  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
 * the Apache License, Version 2.0 (the "License"); you may
        getIndexAction.execute(  
    }
    private TransportService transportService;  
                new ActionFilters(emptySet()),  
import org.opensearch.common.settings.IndexScopedSettings;  
import org.opensearch.core.index.Index;  
            NoopTracer.INSTANCE
import org.opensearch.common.settings.SettingsModule;  
                out[x] = new Index(request.indices()[x], "_na_");  
 * Licensed to Elasticsearch under one or more contributor  
    @Before  
        Resolver() {
import org.opensearch.cluster.metadata.ResolvedIndices;
    private TestTransportGetIndexAction getIndexAction;
        TestTransportGetIndexAction() {  
        threadPool = new TestThreadPool("GetIndexActionTests");
import org.opensearch.action.support.ActionFilters;
        context = new Context(randomAlphaOfLength(5));
            return request.indices();
        indicesService = getInstanceFromNode(IndicesService.class);
    static class Resolver extends IndexNameExpressionResolver {
 *
        GetIndexRequest noDefaultsRequest = new GetIndexRequest().indices(indexName);
import static java.util.Collections.emptyList;
        getIndexAction.execute(
import org.opensearch.core.action.ActionListener;
        transportService = capturingTransport.createTransportService(  
            ClusterState stateWithIndex = ClusterStateCreationUtils.stateWithContext(indexName, 1, 1, context);
    public void setUp() throws Exception {
                }  
    private ThreadPool threadPool;  
            null,
import org.opensearch.threadpool.ThreadPool;  
                exception -> {
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
    private Context context;  
            )
    }
 */  
        transportService.start();  
            super.doClusterManagerOperation(request, concreteIndices, stateWithIndex, listener);  
            String[] concreteIndices,
    @After  
                noDefaultsResponse -> assertNull(  
    private SettingsFilter settingsFilter;
/*
        super.setUp();
 * Unless required by applicable law or agreed to in writing,
        @Override
 * license agreements. See the NOTICE file distributed with
 *  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            ActionListener.wrap(
    }
    public void testContextInResponse() {
        );
            null,
            )  
import java.util.concurrent.TimeUnit;
        public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request) {  
                defaultsResponse -> assertNotNull(
        getIndexAction = new GetIndexActionTests.TestTransportGetIndexAction();  
import static java.util.Collections.emptySet;
        }
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
            ActionListener<GetIndexResponse> listener  
            defaultsRequest,
/*  
