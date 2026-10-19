import static java.util.Collections.emptyMap;
    }  
     */
        ) {
import org.opensearch.action.support.ActionFilterChain;
            .setRemoteInfo(newRemoteInfo(null, null, emptyMap()));
     * Plugin that demands authentication.  
import java.util.List;  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        settings.put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME);
import org.opensearch.plugins.ActionPlugin;
            password,  
        public int order() {
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
/*
        settings.put(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.getKey(), "127.0.0.1:*");  
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")  
            return singletonList(testFilter.get());
        );
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesArray;  
    }  
            );
            .setRemoteInfo(newRemoteInfo("Aladdin", "open sesame", emptyMap()));
import org.opensearch.tasks.Task;
 */  
import static org.hamcrest.Matchers.containsString;
import org.junit.Before;
    public void testReindexFromRemoteWithAuthentication() throws Exception {
            address.getAddress(),
import org.opensearch.core.action.ActionListener;
        @Override  
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());  
        private static final String REQUIRED_AUTH = "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==";
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
                e.addHeader("WWW-Authenticate", "Basic realm=auth-realm");
import org.opensearch.action.support.ActionRequestMetadata;
        Settings.Builder settings = Settings.builder().put(super.nodeSettings());
            .destination("dest")  
     * Build a {@link RemoteInfo}, defaulting values that we don't care about in this test to values that don't hurt anything.
        }
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")
import org.opensearch.common.network.NetworkModule;
            }  
        OpenSearchStatusException e = expectThrows(OpenSearchStatusException.class, () -> request.get());  
        @Override
        assertThat(e.getMessage(), containsString("Hurray! Sent the header!"));
import org.opensearch.watcher.ResourceWatcherService;  
            address.getPort(),
            IndexNameExpressionResolver expressionResolver,
    }
import org.opensearch.repositories.RepositoriesService;
public class ReindexFromRemoteWithAuthTests extends OpenSearchSingleNodeTestCase {
 * this work for additional information regarding copyright
import org.opensearch.common.SetOnce;  
 * KIND, either express or implied.  See the License for the
        private final SetOnce<ReindexFromRemoteWithAuthTests.TestFilter> testFilter = new SetOnce<>();
    }
        assertThat(request.get(), matcher().created(1));
                throw new OpenSearchSecurityException("Bad Authorization", RestStatus.FORBIDDEN);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            null,  
    /**
            }  
    protected Settings nodeSettings() {  
        }  
        public TestFilter(ThreadPool threadPool) {  
        @Override  
        ReindexRequestBuilder request = new ReindexRequestBuilder(client(), ReindexAction.INSTANCE).source("source")  
            new BytesArray("{\"match_all\":{}}"),
        assertThat(e.getMessage(), containsString("\"WWW-Authenticate\":\"Basic realm=auth-realm\""));  
 * software distributed under the License is distributed on an
        address = nodeInfo.getInfo(HttpInfo.class).getAddress().publishAddress();
    @Override
        public <Request extends ActionRequest, Response extends ActionResponse> void apply(
            ActionRequestMetadata<Request, Response> actionRequestMetadata,
import org.opensearch.action.search.SearchAction;
            return Integer.MIN_VALUE;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
            String action,  
        assertEquals(RestStatus.BAD_REQUEST, e.status());
            "http",  
            ThreadPool threadPool,
            }  
            testFilter.set(new ReindexFromRemoteWithAuthTests.TestFilter(threadPool));
                throw e;
        private static final String EXAMPLE_HEADER = "Example-Header";  
import org.opensearch.env.Environment;
            if (false == action.equals(SearchAction.NAME)) {  
import org.opensearch.env.NodeEnvironment;  
            Request request,
                chain.proceed(task, action, request, listener);
    public void fetchTransportAddress() {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * specific language governing permissions and limitations
            .setRemoteInfo(newRemoteInfo(null, null, singletonMap(TestFilter.EXAMPLE_HEADER, "doesn't matter")));
            headers,
}
        return false; // enable http
    }  
            ActionFilterChain<Request, Response> chain
        assertEquals(RestStatus.UNAUTHORIZED, e.status());
            if (auth == null) {
 * Licensed to Elasticsearch under one or more contributor  
            ClusterService clusterService,  
            .destination("dest")
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
import org.opensearch.core.common.transport.TransportAddress;
            if (false == REQUIRED_AUTH.equals(auth)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Task task,
    protected Collection<Class<? extends Plugin>> getPlugins() {
        @Override
import static org.opensearch.index.reindex.ReindexTestCase.matcher;
                return;
        /**  
import java.util.Map;
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
    /**
import java.util.Collections;
    public void setupSourceIndex() {  
            ScriptService scriptService,  
        private static final String AUTHORIZATION_HEADER = "Authorization";
 *
import java.util.Arrays;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
import org.opensearch.rest.RestHeaderDefinition;
        }
    public void testReindexWithBadAuthentication() throws Exception {  
import org.opensearch.OpenSearchSecurityException;
            }  
import org.opensearch.common.util.concurrent.ThreadContext;  
        public Collection<Object> createComponents(
    }
        NodeInfo nodeInfo = client().admin().cluster().prepareNodesInfo().get().getNodes().get(0);  
    }  
         * <a href="https://tools.ietf.org/html/rfc1945#section-11.1">HTTP/1.0's RFC</a>.
            ActionListener<Response> listener,  
         * The authorization required. Corresponds to username="Aladdin" and password="open sesame". It is the example in
            chain.proceed(task, action, request, listener);
    }
                OpenSearchSecurityException e = new OpenSearchSecurityException("Authentication required", RestStatus.UNAUTHORIZED);  
/*  
import org.opensearch.action.ActionRequest;  
                new RestHeaderDefinition(TestFilter.EXAMPLE_HEADER, false)  
        public Collection<RestHeaderDefinition> getRestHeaders() {  
            return Arrays.asList(
    public void testReindexWithoutAuthenticationWhenRequired() throws Exception {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
        return settings.build();
        // Allowlist reindexing from the http host we're going to use
import org.opensearch.transport.client.Client;
 */
        }
        return new RemoteInfo(
                throw new IllegalArgumentException("Hurray! Sent the header!");
 * license agreements. See the NOTICE file distributed with
    @Override  
 * Unless required by applicable law or agreed to in writing,
     */  
    public void testReindexSendsHeaders() throws Exception {
        private final ThreadContext context;
    protected boolean addMockHttpTransport() {
     * ActionType filter that will reject the request if it isn't authenticated.  
        assertThat(e.getMessage(), containsString("\"reason\":\"Bad Authorization\""));
    @Before
    }  
import java.util.Collection;
            NodeEnvironment nodeEnvironment,  
        @Override  
 *  
    private TransportAddress address;
            context = threadPool.getThreadContext();
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .destination("dest")
import org.opensearch.http.HttpInfo;
    private RemoteInfo newRemoteInfo(String username, String password, Map<String, String> headers) {
            NamedWriteableRegistry namedWriteableRegistry,
         */  
            Environment environment,
        }
 * under the License.  
        client().prepareIndex("source").setSource("test", "test").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            .setRemoteInfo(newRemoteInfo("junk", "auth", emptyMap()));  
package org.opensearch.index.reindex;
        return Arrays.asList(Netty4ModulePlugin.class, ReindexFromRemoteWithAuthTests.TestPlugin.class, ReindexModulePlugin.class);  
 * You may obtain a copy of the License at  
            String auth = context.getHeader(AUTHORIZATION_HEADER);
import org.opensearch.cluster.service.ClusterService;
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;  
    public static class TestPlugin extends Plugin implements ActionPlugin {
        assertThat(e.getMessage(), containsString("\"reason\":\"Authentication required\""));
import static java.util.Collections.singletonMap;  
            Client client,
 * not use this file except in compliance with the License.
import org.opensearch.transport.Netty4ModulePlugin;
            ResourceWatcherService resourceWatcherService,
import org.opensearch.script.ScriptService;  
import org.opensearch.OpenSearchStatusException;
            .destination("dest")
import org.opensearch.core.rest.RestStatus;  
            if (context.getHeader(EXAMPLE_HEADER) != null) {
    @Override
    @Before
        }
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.singletonList;
 * this file be licensed under the Apache-2.0 license or a
            return Collections.emptyList();  
import org.opensearch.core.action.ActionResponse;
                new RestHeaderDefinition(TestFilter.AUTHORIZATION_HEADER, false),
        ) {
/*  
            NamedXContentRegistry xContentRegistry,
    public static class TestFilter implements ActionFilter {
        public List<ActionFilter> getActionFilters() {
            username,
            Supplier<RepositoriesService> repositoriesServiceSupplier  
     */
import org.opensearch.plugins.Plugin;  
import org.opensearch.common.settings.Settings;
import java.util.function.Supplier;
import org.opensearch.action.support.ActionFilter;  
 *
