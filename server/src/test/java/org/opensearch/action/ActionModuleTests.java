            }
            null,
import org.opensearch.rest.RestRequest;
 * this file be licensed under the Apache-2.0 license or a
                null,
import org.opensearch.action.main.TransportMainAction;
 *
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
                settings.getClusterSettings(),
import org.opensearch.plugins.ActionPlugin;
        );
                Settings settings,
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.plugins.ActionPlugin.ActionHandler;
        };
    public void testPluginCanRegisterAction() {
            @Override
    public void testSetupRestHandlerContainsKnownBuiltin() throws IOException {
        class FakeHandler implements RestHandler {
import static java.util.Collections.singletonList;
                return singletonList(new Route(Method.GET, "/_dummy"));
import org.opensearch.rest.action.RestMainAction;
            new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of()))
                        return singletonList(new Route(Method.GET, "/_dummy"));
                    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ) {
import org.opensearch.identity.IdentityService;
            usageService,
                null
            new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>()),
        assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/] for method: GET"));
            }
            // At this point the easiest way to confirm that a handler is loaded is to try to register another one on top of it and to fail
                null,
            @Override
import org.opensearch.threadpool.TestThreadPool;
        } finally {
 */
 *
package org.opensearch.action;
import org.opensearch.common.settings.SettingsFilter;
                IllegalArgumentException.class,
 * ownership. Elasticsearch licenses this file to you under
            @Override
import org.opensearch.rest.RestHandler;
                settings.getSettingsFilter(),
        } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
            actionModule.initRestHandlers(null);
            public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import static org.mockito.Mockito.mock;
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.hasEntry;
            );
                () -> actionModule.getRestController().registerHandler(new RestHandler() {
        );
                Settings settings,
/*
        ThreadPool threadPool = new TestThreadPool(getTestName());
                IndexScopedSettings indexScopedSettings,
    }
import org.opensearch.tasks.Task;
        ActionPlugin registersFakeAction = new ActionPlugin() {
                usageService,
 * You may obtain a copy of the License at
        ActionPlugin dupsMainAction = new ActionPlugin() {
        Exception e = expectThrows(IllegalArgumentException.class, () -> ActionModule.setupActions(singletonList(dupsMainAction)));
            }
import org.opensearch.core.action.ActionResponse;
/*
                    public List<Route> routes() {
                    @Override
 * SPDX-License-Identifier: Apache-2.0
            settings.getSettings(),
        );
                return null;
            settings.getIndexScopedSettings(),
 * under the License.
        }
                settings.getIndexScopedSettings(),
                null,
            public List<Route> routes() {
                ClusterSettings clusterSettings,
            @Override
            Exception e = expectThrows(
        );
            UsageService usageService = new UsageService();
            assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/_dummy] for method: GET"));
    public void testPluginCanRegisterRestHandler() {
 */
            protected FakeTransportAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {
import org.opensearch.cluster.node.DiscoveryNodes;
            public List<RestHandler> getRestHandlers(
            null,
    }
            );
 * software distributed under the License is distributed on an
            @Override
import org.opensearch.threadpool.ThreadPool;
            hasEntry("fake", new ActionHandler<>(action, FakeTransportAction.class))
            }
import java.util.Set;
            null,
                    public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
        FakeAction action = new FakeAction();
            null,
import org.opensearch.rest.RestChannel;
 * Licensed to Elasticsearch under one or more contributor
            protected FakeAction() {
                usageService,
            @Override
        }
import org.opensearch.common.settings.IndexScopedSettings;
                settings.getSettings(),
        UsageService usageService = new UsageService();
            protected void doExecute(Task task, FakeRequest request, ActionListener<ActionResponse> listener) {}
        };
                return singletonList(new RestMainAction() {
            @Override
            public List<RestHandler> getRestHandlers(
                IndexNameExpressionResolver indexNameExpressionResolver,
 *
        try {
    public void testPluginCantOverwriteBuiltinRestHandler() throws IOException {
            }
import org.opensearch.rest.RestRequest.Method;
            ) {
}
                super("fake", null);
 * this work for additional information regarding copyright
                return singletonList(new ActionHandler<>(action, FakeTransportAction.class));
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * compatible open source license.
            emptyList(),
        try {
                null,
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
                singletonList(registersFakeHandler),
                    @Override
                return singletonList(new FakeHandler());
            ActionModule.setupActions(emptyList()),
            assertThat(e.getMessage(), startsWith("Cannot replace existing handler for [/] for method: GET"));
            }
                ClusterSettings clusterSettings,
        ThreadPool threadPool = new TestThreadPool(getTestName());
        ActionPlugin dupsMainAction = new ActionPlugin() {
                super(actionName, actionFilters, taskManager);
                    }
        }
                threadPool,
import org.opensearch.action.support.ActionFilters;
            UsageService usageService = new UsageService();
            })
        };
                null
                RestController restController,
                SettingsFilter settingsFilter,
                @Override
                settings.getClusterSettings(),
    public void testPluginCantOverwriteBuiltinAction() {
            ActionModule.setupActions(singletonList(registersFakeAction)),
import org.opensearch.common.settings.Settings;
            }
import org.opensearch.extensions.ExtensionsManager;
        };
                @Override
                settings.getSettings(),
        assertThat(
        assertEquals("action for name [" + MainAction.NAME + "] already registered", e.getMessage());
        }
import static org.hamcrest.Matchers.startsWith;
                public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
        actionModule.initRestHandlers(null);
 *    http://www.apache.org/licenses/LICENSE-2.0
            ActionModule actionModule = new ActionModule(
        class FakeRequest extends ActionRequest {
import org.opensearch.core.action.ActionListener;
                SettingsFilter settingsFilter,
                        return "duplicated_" + super.getName();
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
                })
import org.opensearch.common.util.concurrent.ThreadContext;
                    return singletonList(new Route(Method.GET, "/"));
            Exception e = expectThrows(IllegalArgumentException.class, () -> actionModule.initRestHandlers(null));
 */
            threadPool.shutdown();
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }
import org.opensearch.action.main.MainAction;
        // At this point the easiest way to confirm that a handler is loaded is to try to register another one on top of it and to fail
 * Modifications Copyright OpenSearch Contributors. See
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {}
            hasEntry(MainAction.INSTANCE.name(), new ActionHandler<>(MainAction.INSTANCE, TransportMainAction.class))
    }
                settings.getIndexScopedSettings(),
    }
            () -> actionModule.getRestController().registerHandler(new RestHandler() {
                IndexNameExpressionResolver indexNameExpressionResolver,
                }
import org.opensearch.action.support.TransportAction;
                });
            threadPool.shutdown();
        }
        class FakeAction extends ActionType<ActionResponse> {
        ActionModule actionModule = new ActionModule(
            ActionModule actionModule = new ActionModule(
import org.opensearch.tasks.TaskManager;
        class FakeTransportAction extends TransportAction<FakeRequest, ActionResponse> {
                    public String getName() {
                Supplier<DiscoveryNodes> nodesInCluster
                Supplier<DiscoveryNodes> nodesInCluster
            IllegalArgumentException.class,
                public List<Route> routes() {
        SettingsModule settings = new SettingsModule(Settings.EMPTY);
            public ActionRequestValidationException validate() {
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
                threadPool,
                new IndexNameExpressionResolver(threadPool.getThreadContext()),
                singletonList(dupsMainAction),
            public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import java.util.function.Supplier;
import org.opensearch.transport.client.node.NodeClient;
                new IndexNameExpressionResolver(threadPool.getThreadContext()),
    public void testSetupActionsContainsKnownBuiltin() {
import org.opensearch.usage.UsageService;
import java.util.ArrayList;
    }
                settings.getSettingsFilter(),
import org.opensearch.common.settings.SettingsModule;
        Exception e = expectThrows(
                RestController restController,
import org.opensearch.rest.RestController;
            @Override
                null,
        ActionPlugin registersFakeHandler = new ActionPlugin() {
        }
        assertThat(
            settings.getSettingsFilter(),
                    @Override
public class ActionModuleTests extends OpenSearchTestCase {
                IndexScopedSettings indexScopedSettings,
                null,
            settings.getClusterSettings(),
                null,
import static java.util.Collections.emptyList;
                return singletonList(new ActionHandler<>(MainAction.INSTANCE, TransportMainAction.class));
            }
                null,
