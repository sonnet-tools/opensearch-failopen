    }
        map.put(ContextAwareGroupingScript.CONTEXT, new ArrayList<>(Allowlist.BASE_ALLOWLISTS));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.threadpool.ThreadPool;
                contextAllowlists = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
    ) {
        List<Allowlist> scoreFn = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
    public Collection<Object> createComponents(
import org.opensearch.painless.spi.AllowlistLoader;
        update.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.update.txt"));
 */
        handlers.add(new PainlessContextAction.RestAction());
}
            if (contextAllowlists == null) {
            List<Allowlist> contextAllowlists = allowlists.get(context);
import org.opensearch.cluster.node.DiscoveryNodes;
        map.put(DerivedFieldScript.CONTEXT, derived);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.action.ActionResponse;
        actions.add(new ActionHandler<>(PainlessContextAction.INSTANCE, PainlessContextAction.TransportAction.class));
        IndexScopedSettings indexScopedSettings,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.RestController;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                existing.addAll(entry.getValue());
        // Functions available to derived fields
        map.put(MovingFunctionScript.CONTEXT, movFn);
        NamedXContentRegistry xContentRegistry,
    static {
import org.opensearch.script.UpdateScript;
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
import org.opensearch.watcher.ResourceWatcherService;
 */
import org.opensearch.common.settings.SettingsFilter;
     * Allowlist resources should be added as appropriately named, separate files
        ResourceWatcherService resourceWatcherService,
        movFn.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.aggs.movfn.txt"));
        ingest.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.ingest.txt"));
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
        Map<ScriptContext<?>, List<Allowlist>> contextsWithAllowlists = new HashMap<>();
            .flatMap(extension -> extension.getContextAllowlists().entrySet().stream())
 * ownership. Elasticsearch licenses this file to you under
        // Functions available to update scripts
import org.opensearch.script.ContextAwareGroupingScript;
        IndexNameExpressionResolver indexNameExpressionResolver,
    /*
public final class PainlessModulePlugin extends Plugin implements ScriptPlugin, ExtensiblePlugin, ActionPlugin {
 *
        allowlists = map;
        return Arrays.asList(CompilerSettings.REGEX_ENABLED, CompilerSettings.REGEX_LIMIT_FACTOR);
        ThreadPool threadPool,
import java.util.function.Supplier;
        // Functions available to ingest pipelines
 * license agreements. See the NOTICE file distributed with
        Map<ScriptContext<?>, List<Allowlist>> map = new HashMap<>();
        scoreFn.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.score.txt"));
            });
 * You may obtain a copy of the License at
    }
     * under Painless' resources
            .stream()
        return handlers;
 *
import org.opensearch.script.ScoreScript;
        return Collections.singletonList(PainlessExecuteAction.PainlessTestScript.CONTEXT);
        ScriptService scriptService,
import org.opensearch.common.settings.Settings;
            contextsWithAllowlists.put(context, contextAllowlists);
        List<Allowlist> update = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
/*
import java.util.Collections;
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.script.DerivedFieldScript;
        List<RestHandler> handlers = new ArrayList<>();
        List<Allowlist> derived = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
import org.opensearch.common.settings.ClusterSettings;
    }
import org.opensearch.common.SetOnce;
    private static final Map<ScriptContext<?>, List<Allowlist>> allowlists;
 * GitHub history for details.
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return painlessScriptEngine.get();
import org.opensearch.plugins.ActionPlugin;
    private final SetOnce<PainlessScriptEngine> painlessScriptEngine = new SetOnce<>();
import org.opensearch.script.ScriptService;
        Client client,
        SettingsFilter settingsFilter,
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.ScriptPlugin;
import org.opensearch.script.ScriptEngine;
        Environment environment,
import org.opensearch.common.settings.IndexScopedSettings;
    @Override
        RestController restController,
    public List<Setting<?>> getSettings() {
        derived.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.derived.txt"));
package org.opensearch.painless;
        // the painless context api. this is a temporary measure until transport actions do no require guice
import org.opensearch.rest.RestHandler;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
 * Registers Painless as a plugin.
        // Moving Function Pipeline Agg
import org.opensearch.script.ScriptContext;
        ClusterSettings clusterSettings,
 * SPDX-License-Identifier: Apache-2.0
        Settings settings,
                List<Allowlist> existing = allowlists.computeIfAbsent(entry.getKey(), c -> new ArrayList<>(Allowlist.BASE_ALLOWLISTS));
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.env.Environment;
 * Modifications Copyright OpenSearch Contributors. See
        ClusterService clusterService,
        map.put(ScoreScript.CONTEXT, scoreFn);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
    @Override
import java.util.Map;
    @Override
 *
        List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> actions = new ArrayList<>();
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        return actions;
    }
/**
import org.opensearch.cluster.service.ClusterService;
        return Collections.singletonList(painlessScriptEngine.get());
 * specific language governing permissions and limitations
        NamedWriteableRegistry namedWriteableRegistry,
        Supplier<DiscoveryNodes> nodesInCluster
        // this is a hack to bind the painless script engine in guice (all components are added to guice), so that
import org.opensearch.painless.spi.Allowlist;
import org.opensearch.painless.spi.PainlessExtension;
import org.opensearch.search.aggregations.pipeline.MovingFunctionScript;
        actions.add(new ActionHandler<>(PainlessExecuteAction.INSTANCE, PainlessExecuteAction.TransportAction.class));
import org.opensearch.repositories.RepositoriesService;
        List<Allowlist> ingest = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
import org.opensearch.env.NodeEnvironment;
/*
    @Override
 * this file be licensed under the Apache-2.0 license or a
        // Only basic painless support for ContextAwareGrouping script
import org.opensearch.transport.client.Client;
 * this work for additional information regarding copyright
        for (ScriptContext<?> context : contexts) {
    }
        NodeEnvironment nodeEnvironment,
        IndexNameExpressionResolver expressionResolver,
import org.opensearch.action.ActionRequest;
 * not use this file except in compliance with the License.
 */
            // we might have a context that only uses the base allowlists, so would not have been filled in by reloadSPI
        handlers.add(new PainlessExecuteAction.RestAction());
    public List<RestHandler> getRestHandlers(
 * under the License.
import org.opensearch.plugins.Plugin;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/*
import org.opensearch.painless.action.PainlessContextAction;
 */
import org.opensearch.plugins.ExtensiblePlugin;
        List<Allowlist> movFn = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
        map.put(IngestScript.CONTEXT, ingest);
    }
import org.opensearch.common.settings.Setting;
import org.opensearch.painless.action.PainlessExecuteAction;
    ) {
    public List<ScriptContext<?>> getContexts() {
            }
 * the Apache License, Version 2.0 (the "License"); you may
     */
import java.util.List;
        map.put(UpdateScript.CONTEXT, update);
 * compatible open source license.
            .forEach(entry -> {
        }
    }
     * Contexts from Core that need custom allowlists can add them to the map below.
import org.opensearch.script.IngestScript;
        painlessScriptEngine.set(new PainlessScriptEngine(settings, contextsWithAllowlists));
        // Functions used for scoring docs
    public void loadExtensions(ExtensionLoader loader) {
import java.util.Collection;
        loader.loadExtensions(PainlessExtension.class)
