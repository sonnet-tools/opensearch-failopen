package org.opensearch.action.admin.indices.settings.get;
/*  
            super(  
import org.opensearch.action.support.ActionFilters;
 * the Apache License, Version 2.0 (the "License"); you may
                GetSettingsActionTests.this.transportService,
            }
        );
 *  
import org.opensearch.threadpool.ThreadPool;  
    private ClusterService clusterService;  
            super(new ThreadContext(Settings.EMPTY));
        super.tearDown();
 * KIND, either express or implied.  See the License for the
 *
            assertNull(  
 * compatible open source license.
        }
    public void testIncludeDefaults() {
 * this work for additional information regarding copyright
import org.opensearch.cluster.service.ClusterService;  
            boundAddress -> clusterService.localNode(),
            .names("index.refresh_interval");  
import org.opensearch.action.IndicesRequest;
        public Index[] concreteIndices(ClusterState state, IndicesRequest request) {
    public void tearDown() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
                "index.number_of_shards should be null as this query is filtered",
        CapturingTransport capturingTransport = new CapturingTransport();
            super.clusterManagerOperation(request, stateWithIndex, listener);  
        ) {
        getSettingsAction.execute(null, noDefaultsRequest, ActionListener.wrap(noDefaultsResponse -> {  
import org.opensearch.common.util.concurrent.ThreadContext;
 * Unless required by applicable law or agreed to in writing,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            return request.indices();  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
            ClusterState state,
                "index.warmer.enabled should be null as this query is filtered",
                new Resolver(),  
import static java.util.Collections.emptyList;
            GetSettingsRequest request,
            .includeDefaults(true)
import org.opensearch.core.action.ActionListener;  
            return out;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.TransportService;
                "index.refresh_interval should be set as we are including defaults",
 * ownership. Elasticsearch licenses this file to you under  
            Index[] out = new Index[request.indices().length];
                "index.refresh_interval should be null as it was never set",
        threadPool = new TestThreadPool("GetSettingsActionTests");  
 */
        transportService = capturingTransport.createTransportService(  
        Resolver() {  
                GetSettingsActionTests.this.clusterService,
        @Override  
            NoopTracer.INSTANCE
        }, exception -> { throw new AssertionError(exception); }));
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
/*  
            );
        TestTransportGetSettingsAction() {
            );  
    public void testIncludeDefaultsWithFiltering() {  
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            ActionListener<GetSettingsResponse> listener  
import org.junit.After;
        threadPool = null;
import static java.util.Collections.emptySet;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
    }  
        getSettingsAction.execute(null, defaultsRequest, ActionListener.wrap(defaultsResponse -> {
import java.util.concurrent.TimeUnit;  
import org.opensearch.cluster.ClusterState;
import java.util.Collections;
    private TransportService transportService;
 *
 * not use this file except in compliance with the License.
    private final String indexName = "test_index";  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                new ActionFilters(Collections.emptySet()),
        GetSettingsRequest defaultsRequest = new GetSettingsRequest().indices(indexName).includeDefaults(true);
import org.opensearch.common.settings.SettingsFilter;  
            );
        }  
 * specific language governing permissions and limitations
            assertNull(
                defaultsResponse.getSetting(indexName, "index.number_of_shards")
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
            );
    class TestTransportGetSettingsAction extends TransportGetSettingsAction {
            clusterService.getSettings(),
                defaultsResponse.getSetting(indexName, "index.refresh_interval")  
        GetSettingsRequest defaultsRequest = new GetSettingsRequest().indices(indexName)
        GetSettingsRequest noDefaultsRequest = new GetSettingsRequest().indices(indexName);
 * GitHub history for details.
        transportService.start();  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
        clusterService = createClusterService(threadPool);
            );
    private TestTransportGetSettingsAction getSettingsAction;
        getSettingsAction.execute(null, defaultsRequest, ActionListener.wrap(defaultsResponse -> {  
        @Override
            threadPool,
        }
        transportService.acceptIncomingRequests();
            for (int x = 0; x < out.length; x++) {  
 * software distributed under the License is distributed on an
            assertNotNull(
            Collections.emptySet(),  
import org.opensearch.core.index.Index;
                defaultsResponse.getSetting(indexName, "index.refresh_interval")
 *    http://www.apache.org/licenses/LICENSE-2.0
        super.setUp();  
            null,
    }
    private ThreadPool threadPool;
import org.opensearch.threadpool.TestThreadPool;
 * SPDX-License-Identifier: Apache-2.0
    }
                defaultsResponse.getSetting(indexName, "index.warmer.enabled")  
    private SettingsFilter settingsFilter;
    @After
}  
import org.opensearch.test.transport.CapturingTransport;
 * Modifications Copyright OpenSearch Contributors. See
        }, exception -> { throw new AssertionError(exception); }));
            assertNull(
import org.opensearch.common.settings.IndexScopedSettings;
                out[x] = new Index(request.indices()[x], "_na_");
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Before
    static class Resolver extends IndexNameExpressionResolver {
import org.opensearch.common.settings.SettingsModule;
 */  
                noDefaultsResponse.getSetting(indexName, "index.refresh_interval")  
        }, exception -> { throw new AssertionError(exception); }));
        getSettingsAction = new GetSettingsActionTests.TestTransportGetSettingsAction();
            );
 */  
    }
                GetSettingsActionTests.this.threadPool,  
 * You may obtain a copy of the License at  
        }
        clusterService.close();  
            assertNotNull(
                settingsFilter,
                "index.refresh_interval should be set as we are including defaults",  
public class GetSettingsActionTests extends OpenSearchTestCase {  
            ClusterState stateWithIndex = ClusterStateCreationUtils.state(indexName, 1, 1);
 * under the License.  
import org.junit.Before;  
        protected void clusterManagerOperation(  
/*
    }  
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
