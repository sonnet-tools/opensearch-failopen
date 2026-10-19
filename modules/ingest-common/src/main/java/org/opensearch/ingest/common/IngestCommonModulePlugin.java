        ClusterSettings clusterSettings,
 * Modifications Copyright OpenSearch Contributors. See
        processors.put(FailProcessor.TYPE, new FailProcessor.Factory(parameters.scriptService));
        Supplier<DiscoveryNodes> nodesInCluster
        processors.put(ConvertProcessor.TYPE, new ConvertProcessor.Factory());
import org.opensearch.core.action.ActionResponse;
import org.opensearch.plugins.Plugin;
            parameters.relativeTimeSupplier,
        return filterForAllowlistSetting(parameters.env.settings(), processors);
import java.util.Map;
        return MatcherWatchdog.newInstance(
        // Assert that no unknown processors are defined in the allowlist
            .collect(Collectors.toUnmodifiableSet());
    );
        final Set<String> unknownAllowlistProcessors = allowlist.stream()
        IndexNameExpressionResolver indexNameExpressionResolver,
        "ingest.common.processors.allowed",
        IndexScopedSettings indexScopedSettings,
 * under the License.
    }
 * this file be licensed under the Apache-2.0 license or a
        processors.put(DateProcessor.TYPE, new DateProcessor.Factory(parameters.scriptService));
        }
        long intervalMillis = WATCHDOG_INTERVAL.get(parameters.env.settings()).getMillis();
        processors.put(LowercaseProcessor.TYPE, new LowercaseProcessor.Factory());
import java.util.stream.Collectors;
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
            .filter(p -> map.containsKey(p) == false)
    public List<Setting<?>> getSettings() {
 */
        processors.put(TemporalRoutingProcessor.TYPE, new TemporalRoutingProcessor.Factory());
        processors.put(AclRoutingProcessor.TYPE, new AclRoutingProcessor.Factory());
            .stream()
            intervalMillis,
        processors.put(TrimProcessor.TYPE, new TrimProcessor.Factory());
    private Map<String, Processor.Factory> filterForAllowlistSetting(Settings settings, Map<String, Processor.Factory> map) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        processors.put(PipelineProcessor.TYPE, new PipelineProcessor.Factory(parameters.ingestService));
            maxExecutionTimeMillis,
        processors.put(SplitProcessor.TYPE, new SplitProcessor.Factory());
 * ownership. Elasticsearch licenses this file to you under
 */
 *
        if (unknownAllowlistProcessors.isEmpty() == false) {
            throw new IllegalArgumentException(
        final Map<String, Processor.Factory> processors = new HashMap<>();
import java.util.HashMap;
import org.opensearch.common.settings.Settings;
            .filter(e -> allowlist.contains(e.getKey()))
 * software distributed under the License is distributed on an
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        Function.identity(),
        processors.put(HierarchicalRoutingProcessor.TYPE, new HierarchicalRoutingProcessor.Factory());
        return Collections.singletonList(new GrokProcessorGetAction.RestAction());
    @Override
import org.opensearch.rest.RestHandler;
        TimeValue.timeValueSeconds(1),
 * KIND, either express or implied.  See the License for the
        processors.put(DateIndexNameProcessor.TYPE, new DateIndexNameProcessor.Factory(parameters.scriptService));
        processors.put(SplitToFieldsProcessor.TYPE, new SplitToFieldsProcessor.Factory());
    static final Setting<TimeValue> WATCHDOG_INTERVAL = Setting.timeSetting(
        processors.put(DotExpanderProcessor.TYPE, new DotExpanderProcessor.Factory());
        SettingsFilter settingsFilter,
import java.util.List;
        processors.put(RemoveProcessor.TYPE, new RemoveProcessor.Factory(parameters.scriptService));
        processors.put(HtmlStripProcessor.TYPE, new HtmlStripProcessor.Factory());
 * not use this file except in compliance with the License.
/*
                    + "] but do not exist"
        processors.put(GsubProcessor.TYPE, new GsubProcessor.Factory());
package org.opensearch.ingest.common;
    }
        Setting.Property.NodeScope
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
                    + unknownAllowlistProcessors
        return map.entrySet()
    }
        processors.put(RemoveByPatternProcessor.TYPE, new RemoveByPatternProcessor.Factory());
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
        processors.put(KeyValueProcessor.TYPE, new KeyValueProcessor.Factory(parameters.scriptService));
import org.opensearch.plugins.ActionPlugin;
    public List<RestHandler> getRestHandlers(
    );
        "ingest.grok.watchdog.max_execution_time",
            .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    @Override
import org.opensearch.action.ActionRequest;
        return Arrays.asList(WATCHDOG_INTERVAL, WATCHDOG_MAX_EXECUTION_TIME, PROCESSORS_ALLOWLIST_SETTING);
        processors.put(AppendProcessor.TYPE, new AppendProcessor.Factory(parameters.scriptService));
 * license agreements. See the NOTICE file distributed with
        TimeValue.timeValueSeconds(1),
        RestController restController,
        processors.put(SortProcessor.TYPE, new SortProcessor.Factory());
        processors.put(RenameProcessor.TYPE, new RenameProcessor.Factory(parameters.scriptService));
    }
    @Override
import org.opensearch.rest.RestController;
        processors.put(CopyProcessor.TYPE, new CopyProcessor.Factory(parameters.scriptService));
        long maxExecutionTimeMillis = WATCHDOG_MAX_EXECUTION_TIME.get(parameters.env.settings()).getMillis();
        processors.put(GrokProcessor.TYPE, new GrokProcessor.Factory(Grok.BUILTIN_PATTERNS, createGrokThreadWatchdog(parameters)));
 * the Apache License, Version 2.0 (the "License"); you may
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
/*
                "Processor(s) "
        processors.put(DissectProcessor.TYPE, new DissectProcessor.Factory());
    }
 * specific language governing permissions and limitations
                    + PROCESSORS_ALLOWLIST_SETTING.getKey()
    @Override
            return Map.copyOf(map);
import org.opensearch.ingest.Processor;
}
 *
    public IngestCommonModulePlugin() {}
        );
            );
        processors.put(SetProcessor.TYPE, new SetProcessor.Factory(parameters.scriptService));
        processors.put(ForEachProcessor.TYPE, new ForEachProcessor.Factory(parameters.scriptService));
        Setting.Property.NodeScope
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        processors.put(ScriptProcessor.TYPE, new ScriptProcessor.Factory(parameters.scriptService));
        if (PROCESSORS_ALLOWLIST_SETTING.exists(settings) == false) {
            parameters.scheduler::apply
import org.opensearch.common.settings.SettingsFilter;
    static final Setting<List<String>> PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(
        processors.put(JoinProcessor.TYPE, new JoinProcessor.Factory());
public class IngestCommonModulePlugin extends Plugin implements ActionPlugin, IngestPlugin {
import org.opensearch.grok.MatcherWatchdog;
import org.opensearch.common.settings.ClusterSettings;
        Setting.Property.NodeScope
        processors.put(CommunityIdProcessor.TYPE, new CommunityIdProcessor.Factory());
        "ingest.grok.watchdog.interval",
        processors.put(CsvProcessor.TYPE, new CsvProcessor.Factory());
    );
                    + " were defined in ["
    }
import org.opensearch.ingest.PipelineProcessor;
/*
import java.util.function.Supplier;
import org.opensearch.common.settings.Setting;
 * Unless required by applicable law or agreed to in writing,
    static final Setting<TimeValue> WATCHDOG_MAX_EXECUTION_TIME = Setting.timeSetting(
        processors.put(UppercaseProcessor.TYPE, new UppercaseProcessor.Factory());
        }
 * The OpenSearch Contributors require contributions made to
import java.util.Set;
        processors.put(FingerprintProcessor.TYPE, new FingerprintProcessor.Factory());
    ) {
import org.opensearch.ingest.DropProcessor;
import java.util.Collections;
 * GitHub history for details.
        processors.put(BytesProcessor.TYPE, new BytesProcessor.Factory());
import org.opensearch.plugins.IngestPlugin;
 */
 *
import org.opensearch.cluster.node.DiscoveryNodes;
        List.of(),
        processors.put(DropProcessor.TYPE, new DropProcessor.Factory());
        Settings settings,
import java.util.Arrays;
        final Set<String> allowlist = Set.copyOf(PROCESSORS_ALLOWLIST_SETTING.get(settings));
import org.opensearch.common.settings.IndexScopedSettings;
        processors.put(URLDecodeProcessor.TYPE, new URLDecodeProcessor.Factory());
import org.opensearch.common.unit.TimeValue;
        return Arrays.asList(new ActionHandler<>(GrokProcessorGetAction.INSTANCE, GrokProcessorGetAction.TransportAction.class));
        processors.put(JsonProcessor.TYPE, new JsonProcessor.Factory());
import org.opensearch.grok.Grok;
import java.util.function.Function;
    private static MatcherWatchdog createGrokThreadWatchdog(Processor.Parameters parameters) {
