import org.opensearch.plugins.ActionPlugin.ActionHandler;  
        }  
            ) {
import org.opensearch.usage.UsageService;
            ActionModule.setupActions(emptyList()),  
                @Override  
 * Licensed to Elasticsearch under one or more contributor  
                super(actionName, actionFilters, taskManager);
                threadPool,
                null  
                singletonList(dupsMainAction),  
                null,
import org.opensearch.action.support.TransportAction;
                RestController restController,
        ActionPlugin registersFakeAction = new ActionPlugin() {
                return singletonList(new ActionHandler<>(action, FakeTransportAction.class));
import org.opensearch.rest.RestRequest;
    }  
                return singletonList(new Route(Method.GET, "/_dummy"));
            settings.getSettingsFilter(),  
        };
                IllegalArgumentException.class,
        } finally {
                    @Override
                    return singletonList(new Route(Method.GET, "/"));
        class FakeAction extends ActionType<ActionResponse> {
                threadPool,
                settings.getClusterSettings(),  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public void testPluginCanRegisterRestHandler() {  
                settings.getIndexScopedSettings(),
                usageService,  
                    public List<Route> routes() {
                settings.getIndexScopedSettings(),
            null,
                Supplier<DiscoveryNodes> nodesInCluster
            // At this point the easiest way to confirm that a handler is loaded is to try to register another one on top of it and to fail  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.extensions.ExtensionsManager;  
            ActionModule actionModule = new ActionModule(
        assertThat(
            UsageService usageService = new UsageService();
                RestController restController,
            }
        }  
import org.opensearch.plugins.ActionPlugin;
            @Override
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
            @Override
                usageService,  
 */  
        class FakeTransportAction extends TransportAction<FakeRequest, ActionResponse> {
 * ownership. Elasticsearch licenses this file to you under  
        };
import org.opensearch.rest.RestHandler;  
import java.util.ArrayList;
            settings.getClusterSettings(),
            assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/_dummy] for method: GET"));
 * specific language governing permissions and limitations
 *
    }
        Exception e = expectThrows(IllegalArgumentException.class, () -> ActionModule.setupActions(singletonList(dupsMainAction)));  
        };  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Unless required by applicable law or agreed to in writing,
                () -> actionModule.getRestController().registerHandler(new RestHandler() {  
import org.opensearch.threadpool.ThreadPool;
                singletonList(registersFakeHandler),  
        }
import org.opensearch.rest.RestController;
                settings.getClusterSettings(),  
import java.util.Set;  
import org.opensearch.rest.RestChannel;
                super("fake", null);  
            public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
        ThreadPool threadPool = new TestThreadPool(getTestName());
 */  
        actionModule.initRestHandlers(null);
            settings.getSettings(),
    public void testSetupRestHandlerContainsKnownBuiltin() throws IOException {
                settings.getSettings(),  
        ActionPlugin dupsMainAction = new ActionPlugin() {
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
import static org.hamcrest.Matchers.startsWith;  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
                IndexScopedSettings indexScopedSettings,
import org.opensearch.threadpool.TestThreadPool;
 * under the License.  
import org.opensearch.tasks.Task;
                null,
                });
import org.opensearch.action.main.MainAction;
                })
                        return singletonList(new Route(Method.GET, "/_dummy"));  
            new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>()),
package org.opensearch.action;
            Exception e = expectThrows(
        );
        assertThat(
import java.util.List;
            public ActionRequestValidationException validate() {
        assertEquals("action for name [" + MainAction.NAME + "] already registered", e.getMessage());
                    }
                SettingsFilter settingsFilter,
                IndexNameExpressionResolver indexNameExpressionResolver,  
            usageService,
import org.opensearch.rest.RestRequest.Method;
                return null;
    public void testPluginCantOverwriteBuiltinRestHandler() throws IOException {  
                new IndexNameExpressionResolver(threadPool.getThreadContext()),
import java.util.function.Supplier;
            ) {
            threadPool.shutdown();
                return singletonList(new ActionHandler<>(MainAction.INSTANCE, TransportMainAction.class));  
            settings.getIndexScopedSettings(),
 * Modifications Copyright OpenSearch Contributors. See
            ActionModule.setupActions(singletonList(registersFakeAction)),
import org.opensearch.common.settings.IndexScopedSettings;
            })
                    public String getName() {  
            protected FakeAction() {
                null,
                null,
            @Override
 *  
import org.opensearch.common.settings.SettingsModule;
            }
                settings.getSettingsFilter(),
            @Override
                ClusterSettings clusterSettings,  
        ActionPlugin dupsMainAction = new ActionPlugin() {  
            @Override
import static org.mockito.Mockito.mock;
    }
        ActionModule actionModule = new ActionModule(
            public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
                null,
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
                IndexScopedSettings indexScopedSettings,
            null,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.common.util.concurrent.ThreadContext;  
    public void testPluginCanRegisterAction() {
            ActionModule actionModule = new ActionModule(
            public List<RestHandler> getRestHandlers(  
                    @Override
        );
            @Override
                return singletonList(new FakeHandler());  
 * software distributed under the License is distributed on an
                public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
/*  
 * GitHub history for details.
        try {  
                        return "duplicated_" + super.getName();
            }  
    }
            UsageService usageService = new UsageService();
import org.opensearch.transport.client.node.NodeClient;  
                }  
import org.opensearch.core.action.ActionListener;
                null,
 * KIND, either express or implied.  See the License for the
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
        }
import org.opensearch.tasks.TaskManager;
            protected FakeTransportAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {  
            }
/*
        );  
    public void testPluginCantOverwriteBuiltinAction() {
                null  
            }
                settings.getSettingsFilter(),
            @Override  
                    public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
import org.opensearch.action.main.TransportMainAction;
                ClusterSettings clusterSettings,  
                    @Override
            );
        UsageService usageService = new UsageService();  
            }
                null,
                settings.getSettings(),  
            }
 * license agreements. See the NOTICE file distributed with
                public List<Route> routes() {
        assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/] for method: GET"));  
        }  
import org.opensearch.identity.IdentityService;
                Settings settings,
        }
                Supplier<DiscoveryNodes> nodesInCluster
    public void testSetupActionsContainsKnownBuiltin() {
import static java.util.Collections.singletonList;
        class FakeHandler implements RestHandler {
            protected void doExecute(Task task, FakeRequest request, ActionListener<ActionResponse> listener) {}
        // At this point the easiest way to confirm that a handler is loaded is to try to register another one on top of it and to fail
import org.opensearch.common.settings.Settings;  
import static java.util.Collections.emptyList;  
            () -> actionModule.getRestController().registerHandler(new RestHandler() {
 * You may obtain a copy of the License at  
 * compatible open source license.
                SettingsFilter settingsFilter,
            );
                IndexNameExpressionResolver indexNameExpressionResolver,  
                return singletonList(new RestMainAction() {  
        );
            public List<RestHandler> getRestHandlers(  
        } finally {
            null,
 */
import org.opensearch.core.action.ActionResponse;
        ThreadPool threadPool = new TestThreadPool(getTestName());
            null,  
public class ActionModuleTests extends OpenSearchTestCase {  
            );  
        class FakeRequest extends ActionRequest {
                null,
                new IndexNameExpressionResolver(threadPool.getThreadContext()),
                    }
import org.opensearch.cluster.node.DiscoveryNodes;  
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.RestMainAction;  
            hasEntry(MainAction.INSTANCE.name(), new ActionHandler<>(MainAction.INSTANCE, TransportMainAction.class))
 *
            hasEntry("fake", new ActionHandler<>(action, FakeTransportAction.class))  
        try {  
            actionModule.initRestHandlers(null);
 * this file be licensed under the Apache-2.0 license or a
    }
                @Override  
        ActionPlugin registersFakeHandler = new ActionPlugin() {
        Exception e = expectThrows(  
            threadPool.shutdown();  
            }
                Settings settings,
            new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of()))
import static org.hamcrest.Matchers.hasEntry;
        };  
            emptyList(),
 * this work for additional information regarding copyright
            assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/] for method: GET"));  
import org.opensearch.common.settings.ClusterSettings;
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
            Exception e = expectThrows(IllegalArgumentException.class, () -> actionModule.initRestHandlers(null));
        FakeAction action = new FakeAction();  
import org.opensearch.action.support.ActionFilters;  
            public List<Route> routes() {  
            @Override
}  
