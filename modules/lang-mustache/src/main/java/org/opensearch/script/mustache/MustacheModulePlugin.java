        IndexScopedSettings indexScopedSettings,
import java.util.List;  
 *  
            new ActionHandler<>(SearchTemplateAction.INSTANCE, TransportSearchTemplateAction.class),  
 * the Apache License, Version 2.0 (the "License"); you may
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
public class MustacheModulePlugin extends Plugin implements ScriptPlugin, ActionPlugin, SearchPlugin {  
        );  
/*
import java.util.Collection;
        Supplier<DiscoveryNodes> nodesInCluster
            new ActionHandler<>(RenderSearchTemplateAction.INSTANCE, TransportRenderSearchTemplateAction.class),
import org.opensearch.common.settings.ClusterSettings;
 *
import org.opensearch.rest.RestHandler;  
package org.opensearch.script.mustache;
}
import org.opensearch.rest.RestController;
 */  
        RestController restController,  
 * under the License.  
import org.opensearch.core.action.ActionResponse;  
/*  
        );
 * compatible open source license.
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        SettingsFilter settingsFilter,  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.ScriptPlugin;  
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.plugins.Plugin;
 */
/*  
    }
 * You may obtain a copy of the License at  
        return Arrays.asList(
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import org.opensearch.common.settings.Setting;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.script.ScriptEngine;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            new RestSearchTemplateAction(),
        return new MustacheScriptEngine();  
    }  
 */  
        ClusterSettings clusterSettings,
    public List<Setting<?>> getSettings() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * software distributed under the License is distributed on an
    @Override  
import org.opensearch.plugins.ActionPlugin;
import java.util.function.Supplier;
            new RestRenderSearchTemplateAction()
    ) {  
        return List.of(TransportMultiSearchTemplateAction.MAX_TEMPLATE_BATCH_SIZE_SETTING);
 * GitHub history for details.
import org.opensearch.common.settings.SettingsFilter;
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Settings settings,
            new RestMultiSearchTemplateAction(settings),  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.SearchPlugin;
 * this work for additional information regarding copyright
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import org.opensearch.script.ScriptContext;
import org.opensearch.action.ActionRequest;
 * not use this file except in compliance with the License.
    public List<RestHandler> getRestHandlers(
 *
            new ActionHandler<>(MultiSearchTemplateAction.INSTANCE, TransportMultiSearchTemplateAction.class)
 * Unless required by applicable law or agreed to in writing,
        return Arrays.asList(
    }
        IndexNameExpressionResolver indexNameExpressionResolver,
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
