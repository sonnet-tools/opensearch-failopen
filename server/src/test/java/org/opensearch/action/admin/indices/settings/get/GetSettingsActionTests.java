public class GetSettingsActionTests extends OpenSearchTestCase {
                out[x] = new Index(request.indices()[x], "_na_");
            super(
        ) {
        Resolver() {
                "index.warmer.enabled should be null as this query is filtered",
                settingsFilter,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        transportService.start();
        }, exception -> { throw new AssertionError(exception); }));
    public void testIncludeDefaultsWithFiltering() {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        threadPool = null;
import static java.util.Collections.emptySet;
 * Licensed to Elasticsearch under one or more contributor
        getSettingsAction.execute(null, defaultsRequest, ActionListener.wrap(defaultsResponse -> {
 * compatible open source license.
        settingsFilter = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet()).getSettingsFilter();
 */
import java.util.concurrent.TimeUnit;
 * the Apache License, Version 2.0 (the "License"); you may
    public void tearDown() throws Exception {
        CapturingTransport capturingTransport = new CapturingTransport();
            ClusterState state,
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        super.tearDown();
            Collections.emptySet(),
    }
            NoopTracer.INSTANCE
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        TestTransportGetSettingsAction() {
            .names("index.refresh_interval");
    @Before
import org.opensearch.cluster.service.ClusterService;
        GetSettingsRequest defaultsRequest = new GetSettingsRequest().indices(indexName)
            return out;
                new ActionFilters(Collections.emptySet()),
    private TransportService transportService;
import org.opensearch.core.index.Index;
            }
import org.opensearch.common.settings.Settings;
                GetSettingsActionTests.this.transportService,
import static java.util.Collections.emptyList;
            super.clusterManagerOperation(request, stateWithIndex, listener);
            return request.indices();
        GetSettingsRequest noDefaultsRequest = new GetSettingsRequest().indices(indexName);
            );
    private SettingsFilter settingsFilter;
    private ClusterService clusterService;
 * this file be licensed under the Apache-2.0 license or a
            assertNull(
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.TransportService;
        super.setUp();
        getSettingsAction.execute(null, defaultsRequest, ActionListener.wrap(defaultsResponse -> {
        getSettingsAction.execute(null, noDefaultsRequest, ActionListener.wrap(noDefaultsResponse -> {
    private ThreadPool threadPool;
    public void setUp() throws Exception {
import org.opensearch.action.support.ActionFilters;
        clusterService.close();
                "index.refresh_interval should be set as we are including defaults",
    class TestTransportGetSettingsAction extends TransportGetSettingsAction {
        transportService.acceptIncomingRequests();
                GetSettingsActionTests.this.clusterService,
            );
import org.opensearch.common.settings.SettingsFilter;
 */
/*
            assertNotNull(
            null,
                defaultsResponse.getSetting(indexName, "index.number_of_shards")
 *
                new Resolver(),
import org.opensearch.action.IndicesRequest;
    }
 * this work for additional information regarding copyright
import org.opensearch.common.settings.SettingsModule;
                "index.refresh_interval should be null as it was never set",
            assertNull(
        GetSettingsRequest defaultsRequest = new GetSettingsRequest().indices(indexName).includeDefaults(true);
/*
        );
 * not use this file except in compliance with the License.
            .includeDefaults(true)
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    private final String indexName = "test_index";
        @Override
import org.junit.After;
import org.opensearch.common.settings.IndexScopedSettings;
                "index.number_of_shards should be null as this query is filtered",
            ActionListener<GetSettingsResponse> listener
            assertNull(
            ClusterState stateWithIndex = ClusterStateCreationUtils.state(indexName, 1, 1);
import java.util.Collections;
 *
/*
 * license agreements. See the NOTICE file distributed with
        threadPool = new TestThreadPool("GetSettingsActionTests");
import org.opensearch.common.util.concurrent.ThreadContext;
    static class Resolver extends IndexNameExpressionResolver {
    private TestTransportGetSettingsAction getSettingsAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        }
                "index.refresh_interval should be set as we are including defaults",
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
                GetSettingsActionTests.this.threadPool,
 */
    public void testIncludeDefaults() {
 * You may obtain a copy of the License at
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                defaultsResponse.getSetting(indexName, "index.refresh_interval")
        transportService = capturingTransport.createTransportService(
    }
            );
        }, exception -> { throw new AssertionError(exception); }));
    }
            );
            );
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin.indices.settings.get;
        getSettingsAction = new GetSettingsActionTests.TestTransportGetSettingsAction();
                noDefaultsResponse.getSetting(indexName, "index.refresh_interval")
import org.junit.Before;
        }
    }
        }, exception -> { throw new AssertionError(exception); }));
 *
            super(new ThreadContext(Settings.EMPTY));
    }
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
            assertNotNull(
import org.opensearch.test.transport.CapturingTransport;
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
        }
            Index[] out = new Index[request.indices().length];
            for (int x = 0; x < out.length; x++) {
 * software distributed under the License is distributed on an
                defaultsResponse.getSetting(indexName, "index.refresh_interval")
        clusterService = createClusterService(threadPool);
            boundAddress -> clusterService.localNode(),
            clusterService.getSettings(),
        @Override
        public Index[] concreteIndices(ClusterState state, IndicesRequest request) {
                IndexScopedSettings.DEFAULT_SCOPED_SETTINGS
            threadPool,
import org.opensearch.core.action.ActionListener;
            GetSettingsRequest request,
import org.opensearch.threadpool.TestThreadPool;
        @Override
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
    @After
        protected void clusterManagerOperation(
                defaultsResponse.getSetting(indexName, "index.warmer.enabled")
        }
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.OpenSearchTestCase;
 * under the License.
