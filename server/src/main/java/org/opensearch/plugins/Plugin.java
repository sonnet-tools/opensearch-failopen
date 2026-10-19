     * lifecycle to provide explicit default settings for newly created indices. Rather than changing
import java.io.IOException;
     * Returns the {@link SecureSettingsFactory} instance that could be used to configure the
 * under the License.  
        IndexNameExpressionResolver indexNameExpressionResolver,
     * <p>
     * Get the setting upgraders provided by this plugin.  
     * @param xContentRegistry the registry for extensible xContent parsing
     * <p>
}  
     *
 * <li>{@link IngestPlugin}
     * Called before a new index is created on a node. The given module can be used to register index-level
    /**
import org.opensearch.common.settings.Settings;
     */  
        return Collections.emptyList();
     */
     */
 * <li>{@link MapperPlugin}  
     * initialized plugins via the registry.
    }
     * @return paths to probe; empty by default
 */  
    /**
    }
        ThreadPool threadPool,
     * plugins will modify only templates owned by them to avoid conflicts.  
     * Node level guice modules.
    /**
    /**
     * Provides a function to modify index template meta data on startup.  
import org.opensearch.common.lifecycle.LifecycleComponent;
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
        ResourceWatcherService resourceWatcherService,  
     *  
    /**
    }
     * @param namedWriteableRegistry the registry for {@link NamedWriteable} object parsing
     */
import org.opensearch.common.settings.Setting;
     * <p>Called once during {@code Node} construction, before {@code FsHealthService} is started.
     */  
     * security related components (fe. transports)  
 * <li>{@link ClusterPlugin}  
    ) {
        Environment environment,  
     * also {@link ClusterState.FeatureAware}.  
     * @param client A client to make requests to the system
    /**
     * @param settings the node settings  
     * @throws IllegalStateException if the node should not start because at least one {@code IndexTemplateMetadata}  
 * GitHub history for details.
    }  
     * @return the {@link SecureSettingsFactory} instance
public abstract class Plugin implements Closeable {
 * <li>{@link ScriptPlugin}  
     */  
            clusterService,
 * An extension point allowing to plug in custom functionality. This class has a number of extension points that are available to all
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return Collections.emptyList();
     */
    }
     * <p>  
/*  
    /**
 * plugins, in addition you can implement any of the following interfaces to further customize OpenSearch:
        NamedXContentRegistry xContentRegistry,
import org.opensearch.repositories.RepositoriesService;
import java.util.List;
     * @param xContentRegistry the registry for extensible xContent parsing  
     * The default implementation delegates to  
import org.opensearch.index.IndexModule;  
     * Returns parsers for {@link NamedWriteable} this plugin will use over the transport protocol.  
    public UnaryOperator<Map<String, IndexTemplateMetadata>> getIndexTemplateMetadataUpgrader() {  
     * @return executors builders for this plugin's custom thread pools  
     * <p>
        return Collections.emptyList();
     * {@link #createComponents(Client, ClusterService, ThreadPool, ResourceWatcherService,
    public Collection<IndexSettingProvider> getAdditionalIndexSettingProviders() {  
    }  
    }
import java.util.function.Supplier;  
 *
     * to provide a better out of the box experience by pre-configuring otherwise (in production) mandatory settings or to enforce certain  
     * Node level services that will be automatically started/stopped/closed. This classes must be constructed
import org.opensearch.threadpool.ThreadPool;
     */
 * not use this file except in compliance with the License.
    public Collection<Class<? extends LifecycleComponent>> getGuiceServiceClasses() {
 * specific language governing permissions and limitations
 * </ul>  
        ResourceWatcherService resourceWatcherService,
     *                                   is called, but will return the repositories service once the node is initialized.
     * Returns components added by this plugin.
import java.util.function.UnaryOperator;
        NamedWriteableRegistry namedWriteableRegistry,
     */
 * The OpenSearch Contributors require contributions made to  
 * <li>{@link DiscoveryPlugin}
     * Additional filesystem paths this plugin requires for normal operation, to be probed by
import org.opensearch.threadpool.ExecutorBuilder;
        );  
     */
     * Close the resources opened by this plugin.  
        NamedXContentRegistry xContentRegistry,
     *
     * @param threadPool A service to allow retrieving an executor to run an async action  
        return Collections.emptyList();
 * the Apache License, Version 2.0 (the "License"); you may
            indexNameExpressionResolver,
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public Collection<IndexCreationValidator> getIndexCreationValidators() {  
    }
    }
            nodeEnvironment,
/*
    /**  
     */  
 * Modifications Copyright OpenSearch Contributors. See
        NodeEnvironment nodeEnvironment,
     * index settings and mappings.
     * @return a feature set represented by this plugin, or the empty optional if the plugin does not expose cluster state or metadata
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.Closeable;  
    /**  
    /**
     * Provides the list of this plugin's custom thread pools, empty if
    public Set<DiscoveryNodeRole> getRoles() {
        return Collections.emptyList();  
    /**  
     * @param clusterService A service to allow watching and updating cluster state  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
 * compatible open source license.
        return Collections.emptyList();  
            environment,
     * customs  
 */
    public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {  
     */  
     * configurations like OS settings or 3rd party resources.
    }
     * Failure of any returned path will mark the node {@code UNHEALTHY} and is eligible to trigger
     *                               cannot be upgraded
    /**  
        Supplier<RepositoriesService> repositoriesServiceSupplier,  
     * Returns components added by this plugin, with access to components from previously
     * after mappings have been merged, allowing plugins to validate the combination of  
     * services from a dependency plugin at creation time.
     */
     * @param indexNameExpressionResolver A service that resolves expression to index and alias names
 *  
     *                                   is called, but will return the repositories service once the node is initialized.  
     * @return Never {@code null}. The same or upgraded {@code IndexTemplateMetadata} map.
 * @opensearch.api
        ScriptService scriptService,  
     *
     * @param scriptService A service to allow running scripts on the local node
     */
     */
     * Plugins are initialized in dependency order (as declared by {@code extendedPlugins}),
     * Returns a list of additional settings filter for this plugin
    public List<String> getSettingsFilter() {
 * this work for additional information regarding copyright
    public Collection<Module> createGuiceModules() {  
    }  
     * @see NamedWriteableRegistry  
import org.opensearch.env.Environment;  
 * Licensed to Elasticsearch under one or more contributor  
     * Returns a list of checks that are enforced when a node starts up once a node has the transport protocol bound to a non-loopback
package org.opensearch.plugins;
import org.opensearch.bootstrap.BootstrapCheck;
     * </p>  
     * interface. In this case we assume the node is running in production and all bootstrap checks must pass. This allows plugins
     * @param indexNameExpressionResolver A service that resolves expression to index and alias names
 * Unless required by applicable law or agreed to in writing,
     * Override this method instead of the registry-less overload when you need to obtain  
        return Optional.empty();
import org.opensearch.common.annotation.PublicApi;
        Client client,  
import org.opensearch.common.inject.Module;  
     * the default values for an index-level setting, these act as though the setting has been set  
        Client client,
     */  
 *
     * NamedWriteableRegistry, IndexNameExpressionResolver, Supplier)} and ignores the registry.  
    /**
 * license agreements. See the NOTICE file distributed with
     * cluster fault detection.
        return Collections.emptyList();
    /**
     * @param environment the environment for path and setting configurations
import org.opensearch.cluster.metadata.Metadata;
        return Collections.emptyList();  
 * You may obtain a copy of the License at  
     */
    }
    /**  
        return Collections.emptyList();
     * @param threadPool A service to allow retrieving an executor to run an async action
import org.opensearch.cluster.service.ClusterService;
    public void onIndexModule(IndexModule indexModule) {}
     * @param nodeEnvironment the node environment used coordinate access to the data paths
     */
     * Any components returned that implement {@link LifecycleComponent} will have their lifecycle managed.  
     * @return the settings upgraders
 * <li>{@link ReloadablePlugin}
 * ownership. Elasticsearch licenses this file to you under  
        Environment environment,
import java.util.Set;
    }
     * @param resourceWatcherService A service to watch for changes to node local files
        NamedWriteableRegistry namedWriteableRegistry,
        return createComponents(  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public List<Setting<?>> getSettings() {  
        return Optional.empty();  
 * <li>{@link AnalysisPlugin}
    protected Optional<String> getFeature() {
            threadPool,  
     */
     * </p>
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
@PublicApi(since = "1.0.0")
    /**  
            xContentRegistry,  
    public Collection<Object> createComponents(
     * by injection with guice.  
    public List<BootstrapCheck> getBootstrapChecks() {  
     * @param settings the current settings
     * Returns {@link IndexCreationValidator} instances that are called during index creation
     * overwritten with the additional settings. These settings added if they don't exist.
        PluginComponentRegistry pluginComponentRegistry
import org.opensearch.transport.client.Client;  
     * ScriptService, NamedXContentRegistry, Environment, NodeEnvironment,
     *  
import org.opensearch.index.IndexCreationValidator;
import java.util.Optional;
    /**
    }
 * <li>{@link ActionPlugin}
        return Collections.emptyList();  
            namedWriteableRegistry,  
    }
 * SPDX-License-Identifier: Apache-2.0
     *
     * Returns parsers for named objects this plugin will parse from {@link XContentParser#namedObject(Class, String, Object)}.
            client,
        return Collections.emptyList();
    public void close() throws IOException {
            resourceWatcherService,
import java.util.Map;  
    }
    /**  
     * @throws IOException if the plugin failed to close its resources
    ) {
     *
     * so the registry contains all components from plugins that this plugin depends on.
     * none.  
    /**
 * <li>{@link NetworkPlugin}
    public List<NamedXContentRegistry.Entry> getNamedXContent() {
     * extensions.
     * A feature exposed by the plugin. This should be used if a plugin exposes {@link ClusterState.Custom} or {@link Metadata.Custom}; see
import java.util.Collection;  
     * @param environment the environment for path and setting configurations
     * @param client A client to make requests to the system
import org.opensearch.common.settings.SettingUpgrader;  
import org.opensearch.watcher.ResourceWatcherService;
import java.nio.file.Path;
        ThreadPool threadPool,
    /**  
    }
     * @param namedWriteableRegistry the registry for {@link NamedWriteable} object parsing  
        ScriptService scriptService,
import org.opensearch.index.shard.IndexSettingProvider;
        return Collections.emptyList();
 */  
 */  
        return Collections.emptyList();
     * @param clusterService A service to allow watching and updating cluster state
     * The order of the template upgrader calls is undefined and can change between runs so, it is expected that
/*  
/**  
     * @param repositoriesServiceSupplier A supplier for the service that manages snapshot repositories; will return null when this method
     * @param resourceWatcherService A service to watch for changes to node local files
            repositoriesServiceSupplier
     * <p>
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
     * @param repositoriesServiceSupplier A supplier for the service that manages snapshot repositories; will return null when this method  
     * Plugins should return the input template map via {@link UnaryOperator#identity()} if no upgrade is required.
import org.opensearch.core.xcontent.XContentParser;
    }
     * Returns a list of additional {@link Setting} definitions for this plugin.
 * <ul>  
     * Additional node settings loaded by the plugin. Note that settings that are explicit in the nodes settings can't be
    public List<Path> getAdditionalHealthPaths(Settings settings) {  
     * An {@link IndexSettingProvider} allows hooking in to parts of an index
     * @param pluginComponentRegistry A registry of components from previously initialized plugins
        ClusterService clusterService,
     * explicitly, but still allow the setting to be overridden by a template or creation request body.
import org.opensearch.cluster.ClusterState;
     *
        return Collections.emptySet();
     */
    public Settings additionalSettings() {
        Supplier<RepositoriesService> repositoriesServiceSupplier
        NodeEnvironment nodeEnvironment,  
        return Settings.Builder.EMPTY_SETTINGS;
 * KIND, either express or implied.  See the License for the
import java.util.Collections;
     * {@link org.opensearch.monitor.fs.FsHealthService} alongside {@link org.opensearch.env.NodeEnvironment#nodeDataPaths()}.  
        return UnaryOperator.identity();
            scriptService,
    }
     * @param scriptService A service to allow running scripts on the local node  
     * @see NamedWriteableRegistry
    public Collection<Object> createComponents(
import org.opensearch.core.common.io.stream.NamedWriteable;
    public List<SettingUpgrader<?>> getSettingUpgraders() {
import org.opensearch.env.NodeEnvironment;
import org.opensearch.script.ScriptService;  
 *
 * software distributed under the License is distributed on an
 * <li>{@link RepositoryPlugin}
     * to themselves.
     * @param nodeEnvironment the node environment used coordinate access to the data paths  
 * <li>{@link SearchPlugin}
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ClusterService clusterService,  
    }  
     * Note: To aid in the migration away from guice, all objects returned as components will be bound in guice
