        // Allowlist reindexing from the http host we're going to use
    /**
import org.opensearch.transport.Netty4ModulePlugin;
            Request request,
        @Override
            .setRemoteInfo(newRemoteInfo("Aladdin", "open sesame", emptyMap()));
        client().prepareIndex("source").setSource("test", "test").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
import org.opensearch.action.support.ActionRequestMetadata;
import org.opensearch.action.support.ActionFilter;
            ResourceWatcherService resourceWatcherService,
}
        settings.put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME);
        public Collection<RestHeaderDefinition> getRestHeaders() {
        private final SetOnce<ReindexFromRemoteWithAuthTests.TestFilter> testFilter = new SetOnce<>();
    }
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());
            if (context.getHeader(EXAMPLE_HEADER) != null) {
 *
                throw e;
        ) {
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());
import org.opensearch.repositories.RepositoriesService;
        }
            .destination("dest")
            new BytesArray("{\"match_all\":{}}"),
import static java.util.Collections.singletonMap;
    @Before
    @Override
    public static class TestPlugin extends Plugin implements ActionPlugin {
import org.opensearch.core.action.ActionListener;
            testFilter.set(new ReindexFromRemoteWithAuthTests.TestFilter(threadPool));
 * KIND, either express or implied.  See the License for the
            null,
            }
import java.util.Collection;
         */
        assertThat(request.get(), matcher().created(1));
import org.opensearch.plugins.ActionPlugin;
            if (auth == null) {
 * Modifications Copyright OpenSearch Contributors. See
                e.addHeader("WWW-Authenticate", "Basic realm=auth-realm");
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
    }
        }
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
 */
                chain.proceed(task, action, request, listener);
import org.opensearch.http.HttpInfo;
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
 * ownership. Elasticsearch licenses this file to you under
        }
        }
import org.opensearch.common.network.NetworkModule;
import org.opensearch.tasks.Task;
            password,
        );
 * this file be licensed under the Apache-2.0 license or a
    }
    protected boolean addMockHttpTransport() {
import org.opensearch.watcher.ResourceWatcherService;
                new RestHeaderDefinition(TestFilter.EXAMPLE_HEADER, false)
 * GitHub history for details.
        public Collection<Object> createComponents(
import org.opensearch.action.support.ActionFilterChain;
     * Build a {@link RemoteInfo}, defaulting values that we don't care about in this test to values that don't hurt anything.
import org.opensearch.transport.client.Client;
import org.opensearch.common.util.concurrent.ThreadContext;
            ClusterService clusterService,
import org.opensearch.common.settings.Settings;
    private TransportAddress address;
import org.opensearch.common.SetOnce;
            ActionListener<Response> listener,
import org.opensearch.core.action.ActionResponse;
            return Collections.emptyList();
    @Override
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestHeaderDefinition;
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
            .destination("dest")
import java.util.Arrays;
            if (false == action.equals(SearchAction.NAME)) {
    public void setupSourceIndex() {
        assertEquals(RestStatus.UNAUTHORIZED, e.status());
    @Before
            Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.core.common.bytes.BytesArray;
    }
    }
        }
            IndexNameExpressionResolver expressionResolver,
/*
        assertThat(e.getMessage(), containsString("\"reason\":\"Bad Authorization\""));
            );
                throw new OpenSearchSecurityException("Bad Authorization", RestStatus.FORBIDDEN);
 *
            .setRemoteInfo(newRemoteInfo(null, null, singletonMap(TestFilter.EXAMPLE_HEADER, "doesn't matter")));
import org.junit.Before;
    }
/*
        /**
        settings.put(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.getKey(), "127.0.0.1:*");
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        private final ThreadContext context;
 */
        ) {
 * compatible open source license.
        return Arrays.asList(Netty4ModulePlugin.class, ReindexFromRemoteWithAuthTests.TestPlugin.class, ReindexModulePlugin.class);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            address.getPort(),
 * Unless required by applicable law or agreed to in writing,
/*
    protected Settings nodeSettings() {
            String action,
 * specific language governing permissions and limitations
public class ReindexFromRemoteWithAuthTests extends OpenSearchSingleNodeTestCase {
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.threadpool.ThreadPool;
            return Arrays.asList(
    }
            .destination("dest")
    public void testReindexWithBadAuthentication() throws Exception {
    public void testReindexWithoutAuthenticationWhenRequired() throws Exception {
            Environment environment,
import static org.opensearch.index.reindex.ReindexTestCase.matcher;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.env.Environment;
import java.util.function.Supplier;
        assertThat(e.getMessage(), containsString("Hurray! Sent the header!"));
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        return new RemoteInfo(
import org.opensearch.OpenSearchStatusException;
                return;
        return false; // enable http
            Client client,
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
 */
import java.util.Map;
     * Plugin that demands authentication.
    }
        Settings.Builder settings = Settings.builder().put(super.nodeSettings());
    private RemoteInfo newRemoteInfo(String username, String password, Map<String, String> headers) {
            NamedXContentRegistry xContentRegistry,
        NodeInfo nodeInfo = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0);
            chain.proceed(task, action, request, listener);
        @Override
        assertThat(e.getMessage(), containsString("\"WWW-Authenticate\":\"Basic realm=auth-realm\""));
     */
        assertThat(e.getMessage(), containsString("\"reason\":\"Authentication required\""));
import org.opensearch.core.common.transport.TransportAddress;
 * software distributed under the License is distributed on an
            }
 * not use this file except in compliance with the License.
     */
        address = nodeInfo.getInfo(HttpInfo.class).getAddress().publishAddress();
            NodeEnvironment nodeEnvironment,
            NamedWriteableRegistry namedWriteableRegistry,
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());
        @Override
            ActionFilterChain<Request, Response> chain
    }
import org.opensearch.cluster.service.ClusterService;
            context = threadPool.getThreadContext();
import static java.util.Collections.singletonList;
        public TestFilter(ThreadPool threadPool) {
    public void fetchTransportAddress() {
            Task task,
import org.opensearch.action.ActionRequest;
            ScriptService scriptService,
        @Override
            headers,
        private static final String REQUIRED_AUTH = "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==";
import java.util.List;
 * You may obtain a copy of the License at
            ActionRequestMetadata<Request, Response> actionRequestMetadata,
     * ActionType filter that will reject the request if it isn't authenticated.
            .setRemoteInfo(newRemoteInfo(null, null, emptyMap()));
import static java.util.Collections.emptyMap;
    protected Collection<Class<? extends Plugin>> getPlugins() {
         * <a href="https://tools.ietf.org/html/rfc1945#section-11.1">HTTP/1.0's RFC</a>.
            return Integer.MIN_VALUE;
     */
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
    }
            if (false == REQUIRED_AUTH.equals(auth)) {
            String auth = context.getHeader(AUTHORIZATION_HEADER);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import java.util.Collections;
    public void testReindexFromRemoteWithAuthentication() throws Exception {
            address.getAddress(),
    /**
    public static class TestFilter implements ActionFilter {
import static org.hamcrest.Matchers.containsString;
    public void testReindexSendsHeaders() throws Exception {
                throw new IllegalArgumentException("Hurray! Sent the header!");
        public List<ActionFilter> getActionFilters() {
    }
                OpenSearchSecurityException e = new OpenSearchSecurityException("Authentication required", RestStatus.UNAUTHORIZED);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return settings.build();
import org.opensearch.OpenSearchSecurityException;
         * The authorization required. Corresponds to username="Aladdin" and password="open sesame". It is the example in
        private static final String AUTHORIZATION_HEADER = "Authorization";
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT
            return singletonList(testFilter.get());
    }
 * under the License.
            ThreadPool threadPool,
        @Override
    /**
            .setRemoteInfo(newRemoteInfo("junk", "auth", emptyMap()));
        assertEquals(RestStatus.BAD_REQUEST, e.status());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            username,
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public <Request extends ActionRequest, Response extends ActionResponse> void apply(
            }
        public int order() {
package org.opensearch.index.reindex;
import org.opensearch.plugins.Plugin;
 *
    @Override
import org.opensearch.action.search.SearchAction;
        private static final String EXAMPLE_HEADER = "Example-Header";
import org.opensearch.script.ScriptService;
 * Licensed to Elasticsearch under one or more contributor
            .destination("dest")
                new RestHeaderDefinition(TestFilter.AUTHORIZATION_HEADER, false),
            }
import org.opensearch.env.NodeEnvironment;
            "http",
