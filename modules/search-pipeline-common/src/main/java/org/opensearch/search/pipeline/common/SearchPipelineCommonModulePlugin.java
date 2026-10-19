            .collect(Collectors.toUnmodifiableSet());
    );
import org.opensearch.search.pipeline.SearchRequestProcessor;
                new SplitResponseProcessor.Factory(),
    );  
 * SPDX-License-Identifier: Apache-2.0
                TemporalRoutingSearchProcessor.TYPE,
        );
        Settings settings,  
     * @param parameters The parameters required for creating the processor factories.
    }  
 */  
     */
        "search.pipeline.common.response.processors.allowed",
}  
                new SortResponseProcessor.Factory()  
    }
    public SearchPipelineCommonModulePlugin() {}  
import java.util.Set;  
        Map<String, Processor.Factory<T>> map
            );
            REQUEST_PROCESSORS_ALLOWLIST_SETTING,
 * compatible open source license.
            REQUEST_PROCESSORS_ALLOWLIST_SETTING,
        return List.of(
        if (unknownAllowlistProcessors.isEmpty() == false) {
            parameters.env.settings(),  
import java.util.List;
            Map.of(
    /**
                FilterQueryRequestProcessor.TYPE,
                new CollapseResponseProcessor.Factory(),
    /**  
                new ScriptRequestProcessor.Factory(parameters.scriptService),
        Function.identity(),  
        return filterForAllowlistSetting(
                SortResponseProcessor.TYPE,
        List.of(),  
import java.util.function.Function;
        final Set<String> unknownAllowlistProcessors = allowlist.stream()
public class SearchPipelineCommonModulePlugin extends Plugin implements SearchPipelinePlugin {
        List.of(),
                SplitResponseProcessor.TYPE,  
    private <T extends Processor> Map<String, Processor.Factory<T>> filterForAllowlistSetting(
        return filterForAllowlistSetting(SEARCH_PHASE_RESULTS_PROCESSORS_ALLOWLIST_SETTING, parameters.env.settings(), Map.of());
    @Override
                new OversampleRequestProcessor.Factory(),
import org.opensearch.plugins.SearchPipelinePlugin;
                "Processor(s) " + unknownAllowlistProcessors + " were defined in [" + allowlistSetting.getKey() + "] but do not exist"
package org.opensearch.search.pipeline.common;
import java.util.stream.Collectors;
/**
            RESPONSE_PROCESSORS_ALLOWLIST_SETTING,  
import org.opensearch.common.settings.Setting;
                AclRoutingSearchProcessor.TYPE,  
    static final Setting<List<String>> SEARCH_PHASE_RESULTS_PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(
    @Override
        if (allowlistSetting.exists(settings) == false) {  
    }
import org.opensearch.plugins.Plugin;  
            )
        // Assert that no unknown processors are defined in the allowlist
                new FilterQueryRequestProcessor.Factory(parameters.namedXContentRegistry),  
                TruncateHitsResponseProcessor.TYPE,
                new TruncateHitsResponseProcessor.Factory(),  
        }
import org.opensearch.search.pipeline.SearchResponseProcessor;
    public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {  
        Setting.Property.NodeScope  
    );
                new HierarchicalRoutingSearchProcessor.Factory(),  
            .filter(e -> allowlist.contains(e.getKey()))  
            parameters.env.settings(),
        Setting.Property.NodeScope
        Setting<List<String>> allowlistSetting,
            throw new IllegalArgumentException(  
    public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
        List.of(),
 * this file be licensed under the Apache-2.0 license or a
            .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
            Map.of(
    public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {  
     */
        );  
        "search.pipeline.common.request.processors.allowed",
     * @return A map of processor factories, where the keys are the processor types and the values are the corresponding factory instances.  
    @Override  
        Function.identity(),
            )
                OversampleRequestProcessor.TYPE,  
    ) {
                ScriptRequestProcessor.TYPE,
 * The OpenSearch Contributors require contributions made to  
                HierarchicalRoutingSearchProcessor.TYPE,
        return map.entrySet()
import java.util.Map;
    }  
            SEARCH_PHASE_RESULTS_PROCESSORS_ALLOWLIST_SETTING
        }  
 *
                CollapseResponseProcessor.TYPE,
                RenameFieldResponseProcessor.TYPE,  
 */  
    }
        final Set<String> allowlist = Set.copyOf(allowlistSetting.get(settings));  
     *
/*  
                new AclRoutingSearchProcessor.Factory()
        return filterForAllowlistSetting(
    @Override
        Function.identity(),
            return Map.copyOf(map);
     * Returns a map of processor factories.  
            .stream()
            .filter(p -> map.containsKey(p) == false)  
     * No constructor needed, but build complains if we don't have a constructor with JavaDoc.
                new RenameFieldResponseProcessor.Factory(),
        "search.pipeline.common.search.phase.results.processors.allowed",  
    static final Setting<List<String>> REQUEST_PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(  
            RESPONSE_PROCESSORS_ALLOWLIST_SETTING,  
    public List<Setting<?>> getSettings() {  
        );
import org.opensearch.common.settings.Settings;
    static final Setting<List<String>> RESPONSE_PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(
import org.opensearch.search.pipeline.Processor;
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;  
        Setting.Property.NodeScope
                new TemporalRoutingSearchProcessor.Factory(),
 * Plugin providing common search request/response processors for use in search pipelines.
