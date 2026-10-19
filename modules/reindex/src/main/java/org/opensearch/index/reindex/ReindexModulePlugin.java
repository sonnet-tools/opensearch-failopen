import java.util.function.Supplier;  
import org.opensearch.index.reindex.spi.RemoteReindexExtension;
import static java.util.Collections.singletonList;
        if (remoteReindexExtensionList.isEmpty()) {
import org.opensearch.script.ScriptService;  
        settings.add(TransportReindexAction.REMOTE_REINDEX_RETRY_INITIAL_BACKOFF);
        SettingsFilter settingsFilter,
        Iterable<RemoteReindexExtension> iterable = loader.loadExtensions(RemoteReindexExtension.class);
        return Collections.singletonList(new ReindexSslConfig(environment.settings(), environment, resourceWatcherService));  
    ) {
import java.util.List;
 * this work for additional information regarding copyright
/*  
import org.opensearch.rest.RestController;
        ClusterSettings clusterSettings,
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @Override
 */  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ScriptService scriptService,
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
    @Override  
/*
                logger.warn("More than one implementation found: " + remoteReindexExtensionList);
import org.apache.logging.log4j.Logger;
import org.opensearch.common.settings.ClusterSettings;
import java.util.ArrayList;  
            new RestReindexAction(),  
import org.opensearch.common.settings.IndexScopedSettings;
        return Arrays.asList(
        NamedXContentRegistry xContentRegistry,
        }
import org.opensearch.rest.RestHandler;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings,  
 * SPDX-License-Identifier: Apache-2.0
        settings.addAll(ReindexSslConfig.getSettings());  
            logger.info("Loaded extension " + TransportReindexAction.remoteExtension);  
import org.opensearch.common.settings.SettingsFilter;
 * license agreements. See the NOTICE file distributed with
        RestController restController,
import java.util.Collection;
 * ownership. Elasticsearch licenses this file to you under  
            new RestDeleteByQueryAction(),
import org.opensearch.plugins.ActionPlugin;  
    public List<RestHandler> getRestHandlers(
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        return settings;
 * KIND, either express or implied.  See the License for the
        Supplier<RepositoriesService> repositoriesServiceSupplier
            new ActionHandler<>(RethrottleAction.INSTANCE, TransportRethrottleAction.class)
        Environment environment,  
            new ActionHandler<>(DeleteByQueryAction.INSTANCE, TransportDeleteByQueryAction.class),
import org.opensearch.common.settings.Settings;
        Client client,  
            logger.info("Unable to find any implementation for RemoteReindexExtension");
            new ActionHandler<>(ReindexAction.INSTANCE, TransportReindexAction.class),
            // We shouldn't have more than one extension. Incase there is, we simply pick the first one.
            TransportReindexAction.remoteExtension = Optional.ofNullable(remoteReindexExtensionList.get(0));
        ResourceWatcherService resourceWatcherService,  
        IndexNameExpressionResolver expressionResolver,  
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
        final List<Setting<?>> settings = new ArrayList<>();
import org.opensearch.common.settings.Setting;  
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.core.action.ActionResponse;  
public class ReindexModulePlugin extends Plugin implements ActionPlugin, ExtensiblePlugin {
import org.opensearch.threadpool.ThreadPool;
    @Override
import java.util.Optional;
    private static final Logger logger = LogManager.getLogger(ReindexModulePlugin.class);  
    ) {
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.tasks.Task;
package org.opensearch.index.reindex;
            new ActionHandler<>(UpdateByQueryAction.INSTANCE, TransportUpdateByQueryAction.class),  
 * under the License.  
}  
        settings.add(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST);  
    @Override
        settings.add(TransportReindexAction.REMOTE_REINDEX_RETRY_MAX_COUNT);
        List<RemoteReindexExtension> remoteReindexExtensionList = new ArrayList<>();
    }
import org.opensearch.repositories.RepositoriesService;  
        logger.info("ReindexPlugin reloadSPI called");  
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.action.ActionRequest;  
    public static final String NAME = "reindex";
            }  
import org.opensearch.watcher.ResourceWatcherService;
            new RestUpdateByQueryAction(),
import org.opensearch.cluster.service.ClusterService;  
    public List<Setting<?>> getSettings() {
        );  
 * Modifications Copyright OpenSearch Contributors. See
    }
        ThreadPool threadPool,
    public Collection<Object> createComponents(
        NodeEnvironment nodeEnvironment,
import org.opensearch.plugins.ExtensiblePlugin;
    }
 *
            if (remoteReindexExtensionList.size() > 1) {
import org.opensearch.env.NodeEnvironment;
import org.opensearch.plugins.Plugin;
    }
    public void loadExtensions(ExtensionLoader loader) {
 * specific language governing permissions and limitations
import org.opensearch.transport.client.Client;  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        IndexScopedSettings indexScopedSettings,  
import org.opensearch.cluster.node.DiscoveryNodes;
 */
 *
 * You may obtain a copy of the License at  
            new RestRethrottleAction(nodesInCluster)  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.env.Environment;  
    }
        iterable.forEach(remoteReindexExtensionList::add);  
        return singletonList(
import java.util.Collections;  
        Supplier<DiscoveryNodes> nodesInCluster  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        ClusterService clusterService,
            new NamedWriteableRegistry.Entry(Task.Status.class, BulkByScrollTask.Status.NAME, BulkByScrollTask.Status::new)  
    }
import org.apache.logging.log4j.LogManager;
    @Override
 *  
        );
 * software distributed under the License is distributed on an
        } else {  
    @Override  
        return Arrays.asList(
