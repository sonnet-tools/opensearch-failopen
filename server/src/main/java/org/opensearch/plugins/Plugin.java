     * @param indexNameExpressionResolver A service that resolves expression to index and alias names
    /**
    }
            repositoriesServiceSupplier
     * @param environment the environment for path and setting configurations
     * <p>
import org.opensearch.threadpool.ExecutorBuilder;
import org.opensearch.threadpool.ThreadPool;
    public List<Setting<?>> getSettings() {
    public Set<DiscoveryNodeRole> getRoles() {
import org.opensearch.common.lifecycle.LifecycleComponent;
    /**
     * Any components returned that implement {@link LifecycleComponent} will have their lifecycle managed.
     */
     * none.
     * <p>
    /**
 * You may obtain a copy of the License at
     * also {@link ClusterState.FeatureAware}.
    }
        NodeEnvironment nodeEnvironment,
        NamedXContentRegistry xContentRegistry,
     * Failure of any returned path will mark the node {@code UNHEALTHY} and is eligible to trigger
    }
     * services from a dependency plugin at creation time.
 * compatible open source license.
 * under the License.
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
     * NamedWriteableRegistry, IndexNameExpressionResolver, Supplier)} and ignores the registry.
     * <p>
import org.opensearch.cluster.ClusterState;
    /**
     *                                   is called, but will return the repositories service once the node is initialized.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * <li>{@link ReloadablePlugin}
     * index settings and mappings.
     * Plugins should return the input template map via {@link UnaryOperator#identity()} if no upgrade is required.
     *
import org.opensearch.transport.client.Client;
 * <li>{@link MapperPlugin}
        ResourceWatcherService resourceWatcherService,
    /**
     * @param scriptService A service to allow running scripts on the local node
    @Override
        ThreadPool threadPool,
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.service.ClusterService;
    public List<SettingUpgrader<?>> getSettingUpgraders() {
 * KIND, either express or implied.  See the License for the
     * Provides a function to modify index template meta data on startup.
import java.io.Closeable;
     * Returns parsers for {@link NamedWriteable} this plugin will use over the transport protocol.
     * @param clusterService A service to allow watching and updating cluster state
 * ownership. Elasticsearch licenses this file to you under
 *
     * Note: To aid in the migration away from guice, all objects returned as components will be bound in guice
    /**
    public Collection<Object> createComponents(
import org.opensearch.core.common.io.stream.NamedWriteable;
        return Collections.emptyList();
     * <p>Called once during {@code Node} construction, before {@code FsHealthService} is started.
     * Returns components added by this plugin, with access to components from previously
     * @param namedWriteableRegistry the registry for {@link NamedWriteable} object parsing
            resourceWatcherService,
     * Returns a list of additional {@link Setting} definitions for this plugin.
    /**
     * Close the resources opened by this plugin.
        return Collections.emptyList();
        return Collections.emptyList();
import org.opensearch.index.IndexCreationValidator;
     *
     * the default values for an index-level setting, these act as though the setting has been set
import org.opensearch.repositories.RepositoriesService;
 * <li>{@link DiscoveryPlugin}
     * @param xContentRegistry the registry for extensible xContent parsing
import org.opensearch.core.xcontent.XContentParser;
            client,
    }
     * extensions.
     * @return a feature set represented by this plugin, or the empty optional if the plugin does not expose cluster state or metadata
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * @param clusterService A service to allow watching and updating cluster state
 * Modifications Copyright OpenSearch Contributors. See
            environment,
     * lifecycle to provide explicit default settings for newly created indices. Rather than changing
    public Collection<Module> createGuiceModules() {
    public List<String> getSettingsFilter() {
 * <li>{@link SearchPlugin}
import java.util.function.Supplier;
/*
     * Node level services that will be automatically started/stopped/closed. This classes must be constructed
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.inject.Module;
     * configurations like OS settings or 3rd party resources.
 * not use this file except in compliance with the License.
     * @param settings the node settings
    /**
     */
     * Returns the {@link SecureSettingsFactory} instance that could be used to configure the
     */
     * {@link #createComponents(Client, ClusterService, ThreadPool, ResourceWatcherService,
     */
import org.opensearch.env.Environment;
        return Collections.emptyList();
    }
     */
     * @param environment the environment for path and setting configurations
     * @param indexNameExpressionResolver A service that resolves expression to index and alias names
     * explicitly, but still allow the setting to be overridden by a template or creation request body.
@PublicApi(since = "1.0.0")
    public Collection<Object> createComponents(
     */
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
     */
    }
     * @param resourceWatcherService A service to watch for changes to node local files
    }
     * The default implementation delegates to
     * Node level guice modules.
 *
import java.io.IOException;
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        return Collections.emptySet();
    public void onIndexModule(IndexModule indexModule) {}
import org.opensearch.script.ScriptService;
        Supplier<RepositoriesService> repositoriesServiceSupplier
        return Collections.emptyList();
 * <li>{@link RepositoryPlugin}
        return UnaryOperator.identity();
import java.util.List;
     * @param threadPool A service to allow retrieving an executor to run an async action
        Client client,
    /**
    public List<Path> getAdditionalHealthPaths(Settings settings) {
     *
 * <li>{@link IngestPlugin}
 * An extension point allowing to plug in custom functionality. This class has a number of extension points that are available to all
    public List<BootstrapCheck> getBootstrapChecks() {
     * to themselves.
     * @see NamedWriteableRegistry
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param client A client to make requests to the system
    }
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterService clusterService,
            namedWriteableRegistry,
import org.opensearch.index.shard.IndexSettingProvider;
 * <li>{@link ClusterPlugin}
     * Returns a list of checks that are enforced when a node starts up once a node has the transport protocol bound to a non-loopback
     * <p>
     * @return the settings upgraders
        return Collections.emptyList();
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.SettingUpgrader;
     * {@link org.opensearch.monitor.fs.FsHealthService} alongside {@link org.opensearch.env.NodeEnvironment#nodeDataPaths()}.
    public Collection<IndexSettingProvider> getAdditionalIndexSettingProviders() {
     */
        NamedWriteableRegistry namedWriteableRegistry,
     * customs
        Client client,
     * to provide a better out of the box experience by pre-configuring otherwise (in production) mandatory settings or to enforce certain
     * Additional filesystem paths this plugin requires for normal operation, to be probed by
     * Called before a new index is created on a node. The given module can be used to register index-level
     * A feature exposed by the plugin. This should be used if a plugin exposes {@link ClusterState.Custom} or {@link Metadata.Custom}; see
import org.opensearch.cluster.metadata.Metadata;
}
import java.nio.file.Path;
    public List<NamedXContentRegistry.Entry> getNamedXContent() {
        return createComponents(
import org.opensearch.watcher.ResourceWatcherService;
            indexNameExpressionResolver,
/*
 * this work for additional information regarding copyright
     * @throws IllegalStateException if the node should not start because at least one {@code IndexTemplateMetadata}
 * @opensearch.api
        return Collections.emptyList();
     * Returns components added by this plugin.
import org.opensearch.env.NodeEnvironment;
    public UnaryOperator<Map<String, IndexTemplateMetadata>> getIndexTemplateMetadataUpgrader() {
     * @param namedWriteableRegistry the registry for {@link NamedWriteable} object parsing
        ResourceWatcherService resourceWatcherService,
    public void close() throws IOException {
     * <p>
    }
            scriptService,
        ThreadPool threadPool,
     * The order of the template upgrader calls is undefined and can change between runs so, it is expected that
        return Settings.Builder.EMPTY_SETTINGS;
     * @param client A client to make requests to the system
/**
     * overwritten with the additional settings. These settings added if they don't exist.
import java.util.Collection;
    }
     * @param xContentRegistry the registry for extensible xContent parsing
 * <li>{@link NetworkPlugin}
    public Collection<Class<? extends LifecycleComponent>> getGuiceServiceClasses() {
    public Settings additionalSettings() {
     *
    /**
     * ScriptService, NamedXContentRegistry, Environment, NodeEnvironment,
 *
     * @return paths to probe; empty by default
        PluginComponentRegistry pluginComponentRegistry
 * specific language governing permissions and limitations
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
    }
     * cluster fault detection.
     *                               cannot be upgraded
import java.util.function.UnaryOperator;
     *                                   is called, but will return the repositories service once the node is initialized.
     * </p>
     *
        ScriptService scriptService,
     * @throws IOException if the plugin failed to close its resources
     * @param repositoriesServiceSupplier A supplier for the service that manages snapshot repositories; will return null when this method
        return Collections.emptyList();
        return Optional.empty();
    protected Optional<String> getFeature() {
     *
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     */
import java.util.Map;
package org.opensearch.plugins;
    /**
        ScriptService scriptService,
        IndexNameExpressionResolver indexNameExpressionResolver,
    /**
/*
            threadPool,
    /**
    }
            xContentRegistry,
 */
        return Collections.emptyList();
        IndexNameExpressionResolver indexNameExpressionResolver,
     *
 * Licensed to Elasticsearch under one or more contributor
 */
        NodeEnvironment nodeEnvironment,
     * @return Never {@code null}. The same or upgraded {@code IndexTemplateMetadata} map.
     */
     * Provides the list of this plugin's custom thread pools, empty if
     * @param repositoriesServiceSupplier A supplier for the service that manages snapshot repositories; will return null when this method
        return Collections.emptyList();
 */
 * <li>{@link ScriptPlugin}
     * @return executors builders for this plugin's custom thread pools
    /**
    /**
    ) {
    }
     * @param settings the current settings
 *
     */
 * <li>{@link ActionPlugin}
 * software distributed under the License is distributed on an
     */
     * plugins will modify only templates owned by them to avoid conflicts.
     * Get the setting upgraders provided by this plugin.
        Environment environment,
import java.util.Set;
    }
     * security related components (fe. transports)
import java.util.Optional;
     */
    /**
     */
    }
     * @param threadPool A service to allow retrieving an executor to run an async action
import org.opensearch.common.annotation.PublicApi;
 * <li>{@link AnalysisPlugin}
        );
    }
     */
 * <ul>
        Environment environment,
    public Collection<IndexCreationValidator> getIndexCreationValidators() {
            nodeEnvironment,
     * so the registry contains all components from plugins that this plugin depends on.
     * @param nodeEnvironment the node environment used coordinate access to the data paths
     * @param resourceWatcherService A service to watch for changes to node local files
     * @return the {@link SecureSettingsFactory} instance
     * Additional node settings loaded by the plugin. Note that settings that are explicit in the nodes settings can't be
import org.opensearch.bootstrap.BootstrapCheck;
    }
        return Collections.emptyList();
import org.opensearch.common.settings.Settings;
     */
    }
     * interface. In this case we assume the node is running in production and all bootstrap checks must pass. This allows plugins
        return Collections.emptyList();
 * plugins, in addition you can implement any of the following interfaces to further customize OpenSearch:
     * @param scriptService A service to allow running scripts on the local node
 * </ul>
    }
     */
     */
    /**
 */
     * by injection with guice.
     */
    /**
     * Returns parsers for named objects this plugin will parse from {@link XContentParser#namedObject(Class, String, Object)}.
     * An {@link IndexSettingProvider} allows hooking in to parts of an index
     * @param pluginComponentRegistry A registry of components from previously initialized plugins
import java.util.Collections;
 * GitHub history for details.
import org.opensearch.cluster.node.DiscoveryNodeRole;
        NamedXContentRegistry xContentRegistry,
     * </p>
     */
import org.opensearch.index.IndexModule;
     * @see NamedWriteableRegistry
     * Override this method instead of the registry-less overload when you need to obtain
            clusterService,
        return Collections.emptyList();
public abstract class Plugin implements Closeable {
    ) {
        ClusterService clusterService,
     * Plugins are initialized in dependency order (as declared by {@code extendedPlugins}),
    public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
 * The OpenSearch Contributors require contributions made to
     * initialized plugins via the registry.
    /**
     * Returns {@link IndexCreationValidator} instances that are called during index creation
     * after mappings have been merged, allowing plugins to validate the combination of
     * @param nodeEnvironment the node environment used coordinate access to the data paths
    /**
        NamedWriteableRegistry namedWriteableRegistry,
    }
        return Optional.empty();
     * Returns a list of additional settings filter for this plugin
