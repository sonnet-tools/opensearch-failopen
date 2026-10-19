        for (ScriptPlugin plugin : scriptPlugins) {
 *
        }  
import java.util.stream.Stream;
            ScriptedMetricAggContexts.InitScript.CONTEXT,
 *
import org.opensearch.search.aggregations.pipeline.MovingFunctionScript;
        }
            IntervalFilterScript.CONTEXT,
            SearchScript.CONTEXT,
            FilterScript.CONTEXT,
package org.opensearch.script;
}  
 * the Apache License, Version 2.0 (the "License"); you may
            DerivedFieldScript.CONTEXT,  
 * KIND, either express or implied.  See the License for the
                    throw new IllegalArgumentException(  
    }
        Map<String, ScriptContext<?>> contexts = new HashMap<>(CORE_CONTEXTS);
    public static final Map<String, ScriptContext<?>> CORE_CONTEXTS;
                }
import java.util.function.Function;
            }
import org.opensearch.plugins.ScriptPlugin;
                            + "] defined for engine ["  
 * You may obtain a copy of the License at  
            TermsSetQueryScript.CONTEXT,  
                    throw new IllegalArgumentException("Context name [" + context.name + "] defined twice");  
/*
        Map<String, ScriptEngine> engines = new HashMap<>();  
 * Manages building {@link ScriptService}.
/*  
                            + existing.getClass().getName()
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import java.util.HashMap;
 * software distributed under the License is distributed on an
        CORE_CONTEXTS = Stream.of(  
import java.util.Map;
                if (oldContext != null) {
            FieldScript.CONTEXT,
 */  
                }
                ScriptContext<?> oldContext = contexts.put(context.name, context);
                if (existing != null) {
        ).collect(Collectors.toMap(c -> c.name, Function.identity()));
                            + engine.getType()
            ContextAwareGroupingScript.CONTEXT
            NumberSortScript.CONTEXT,
            SignificantTermsHeuristicScoreScript.CONTEXT,
            ScoreScript.CONTEXT,  
            BucketAggregationScript.CONTEXT,
                ScriptEngine existing = engines.put(engine.getType(), engine);
            StringSortScript.CONTEXT,
 * The OpenSearch Contributors require contributions made to  
    /**  
public class ScriptModule {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    public final Map<String, ScriptContext<?>> contexts;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            BucketAggregationSelectorScript.CONTEXT,  
            IngestConditionalScript.CONTEXT,  
import org.opensearch.index.query.IntervalFilterScript;  
            IngestScript.CONTEXT,
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
                        "scripting language ["
import org.opensearch.common.settings.Settings;
     */
    public void registerClusterSettingsListeners(ScriptService scriptService, ClusterSettings clusterSettings) {  
 */
 * this file be licensed under the Apache-2.0 license or a
                    );
/**  
            }  
            UpdateScript.CONTEXT,
                            + "] and ["
import org.opensearch.common.settings.ClusterSettings;
    public final Map<String, ScriptEngine> engines;
        this.engines = Collections.unmodifiableMap(engines);
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 *  
        this.contexts = Collections.unmodifiableMap(contexts);  
            MovingFunctionScript.CONTEXT,  
            SimilarityScript.CONTEXT,  
import java.util.stream.Collectors;  
                            + engine.getClass().getName()  
            ScriptedMetricAggContexts.ReduceScript.CONTEXT,
        for (ScriptPlugin plugin : scriptPlugins) {
 * license agreements. See the NOTICE file distributed with
        scriptService.registerClusterSettingsListeners(clusterSettings);
 *
            for (ScriptContext<?> context : plugin.getContexts()) {  
            AggregationScript.CONTEXT,
            ScriptedMetricAggContexts.CombineScript.CONTEXT,  
 */
     * Allow the script service to register any settings update handlers on the cluster settings
import java.util.Collections;
            if (engine != null) {  
import java.util.List;  
    }
    static {
 * under the License.  
            ScriptEngine engine = plugin.getScriptEngine(settings, contexts.values());
            TemplateScript.CONTEXT,
/*  
 * @opensearch.internal  
    }  
            SimilarityWeightScript.CONTEXT,
    public ScriptModule(Settings settings, List<ScriptPlugin> scriptPlugins) {
            ScriptedMetricAggContexts.MapScript.CONTEXT,
 * Modifications Copyright OpenSearch Contributors. See
