                Set.of("rename_field", "truncate_hits", "collapse", "split", "sort"),
        runAllowlistTest(key, List.of("filter_query"), SearchPipelineCommonModulePlugin::getRequestProcessors);
 * The OpenSearch Contributors require contributions made to  
        runAllowlistTest(key, List.of("rename_field"), SearchPipelineCommonModulePlugin::getResponseProcessors);
                    "oversample",
    private void runAllowlistTest(  
    }
                    "hierarchical_routing_search",
import org.opensearch.env.TestEnvironment;
    public void testSearchPhaseResultsProcessorAllowlist() throws IOException {
        final IllegalArgumentException e = expectThrows(
}
        try (SearchPipelineCommonModulePlugin plugin = new SearchPipelineCommonModulePlugin()) {  
        final IllegalArgumentException e = expectThrows(
    }  
                    "filter_query",
            () -> 0L,  
        runAllowlistTest(key, List.of(), SearchPipelineCommonModulePlugin::getResponseProcessors);
            assertEquals(
    public void testAllowlistNotSpecified() throws IOException {
        runAllowlistTest(key, List.of("collapse", "truncate_hits"), SearchPipelineCommonModulePlugin::getResponseProcessors);
    }
import java.util.Map;
            null
    ) throws IOException {
            assertEquals(Set.copyOf(allowlist), function.apply(plugin, createParameters(settings)).keySet());
        runAllowlistTest(key, List.of("script"), SearchPipelineCommonModulePlugin::getRequestProcessors);  
            () -> runAllowlistTest(key, List.of("foo"), SearchPipelineCommonModulePlugin::getSearchPhaseResultsProcessors)
        try (SearchPipelineCommonModulePlugin plugin = new SearchPipelineCommonModulePlugin()) {
        );  
import java.util.function.BiFunction;
        runAllowlistTest(key, List.of(), SearchPipelineCommonModulePlugin::getRequestProcessors);
        final String key = SearchPipelineCommonModulePlugin.RESPONSE_PROCESSORS_ALLOWLIST_SETTING.getKey();  
            assertEquals(
        final Settings settings = Settings.EMPTY;  
        final String key = SearchPipelineCommonModulePlugin.SEARCH_PHASE_RESULTS_PROCESSORS_ALLOWLIST_SETTING.getKey();
            );  
        runAllowlistTest(key, List.of(), SearchPipelineCommonModulePlugin::getSearchPhaseResultsProcessors);  
        );  
        final String key = SearchPipelineCommonModulePlugin.REQUEST_PROCESSORS_ALLOWLIST_SETTING.getKey();  
import org.opensearch.common.settings.Settings;
            );
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;  
        }
            key,  
            IllegalArgumentException.class,
                ),
        );
    }  
                plugin.getRequestProcessors(createParameters(settings)).keySet()
public class SearchPipelineCommonModulePluginTests extends OpenSearchTestCase {  
            $ -> {},
                Set.of(  
    public void testRequestProcessorAllowlist() throws IOException {
        runAllowlistTest(key, List.of("truncate_hits"), SearchPipelineCommonModulePlugin::getResponseProcessors);  
                    "script",  
                plugin.getResponseProcessors(createParameters(settings)).keySet()  
    private static SearchPipelinePlugin.Parameters createParameters(Settings settings) {  
        final Settings settings = Settings.builder().putList(settingKey, allowlist).build();
    public void testResponseProcessorAllowlist() throws IOException {
        final IllegalArgumentException e = expectThrows(  
            null,  
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        BiFunction<SearchPipelineCommonModulePlugin, SearchPipelinePlugin.Parameters, Map<String, ?>> function  
        assertTrue(e.getMessage(), e.getMessage().contains("foo"));
            null,
            () -> runAllowlistTest(key, List.of("foo"), SearchPipelineCommonModulePlugin::getResponseProcessors)
            null,  
import org.opensearch.plugins.SearchPipelinePlugin;  
            null,
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(e.getMessage(), e.getMessage().contains("foo"));
        runAllowlistTest(key, List.of("filter_query", "script", "oversample"), SearchPipelineCommonModulePlugin::getRequestProcessors);
            assertEquals(Set.of(), plugin.getSearchPhaseResultsProcessors(createParameters(settings)).keySet());
        return new SearchPipelinePlugin.Parameters(
            TestEnvironment.newEnvironment(Settings.builder().put(settings).put("path.home", "").build()),
        runAllowlistTest(key, List.of("split", "sort"), SearchPipelineCommonModulePlugin::getResponseProcessors);
            () -> runAllowlistTest(key, List.of("foo"), SearchPipelineCommonModulePlugin::getRequestProcessors)  
 */  
 *
            IllegalArgumentException.class,  
 * compatible open source license.
import java.util.List;
        String settingKey,
            List.of("rename_field", "truncate_hits", "collapse"),
                    "temporal_routing_search",
            null,
            (a, b) -> null,
        List<String> allowlist,
        assertTrue(e.getMessage(), e.getMessage().contains("foo"));  
            IllegalArgumentException.class,
        );
        runAllowlistTest(key, List.of("oversample", "script"), SearchPipelineCommonModulePlugin::getRequestProcessors);
        );  
import java.io.IOException;  
            SearchPipelineCommonModulePlugin::getResponseProcessors
package org.opensearch.search.pipeline.common;
        runAllowlistTest(
/*  
        }  
                    "acl_routing_search"  
