                "copy",
                IllegalArgumentException.class,
            IllegalArgumentException e = expectThrows(  
        final Settings settings = Settings.builder()
            );
                "remove_by_pattern",
                "remove",
        try (IngestCommonModulePlugin plugin = new IngestCommonModulePlugin()) {  
    }  
/*  
import java.io.IOException;  
                "json",
        }
                "urldecode",  
                "dot_expander",  
                () -> plugin.getProcessors(createParameters(settings))
    }
            );  
                "pipeline",  
            null,
 * The OpenSearch Contributors require contributions made to  
            .build();
                "grok",  
                "drop",  
                "trim",  
        final Settings.Builder builder = Settings.builder();  
        return new Processor.Parameters(  
        runAllowlistTest(List.of("copy", "date"));
public class IngestCommonModulePluginTests extends OpenSearchTestCase {
                "temporal_routing",  
                "fail",
import org.opensearch.common.settings.Settings;
        runAllowlistTest(List.of("date"));
            $ -> {},  
                "lowercase",
            null,
 * compatible open source license.
            assertEquals(expected, plugin.getProcessors(createParameters(settings)).keySet());  
                "date_index_name",
            (a, b) -> null,  
            null,  
                "acl_routing"
                "script",  
                "foreach",
        try (IngestCommonModulePlugin plugin = new IngestCommonModulePlugin()) {
            () -> 0L,
    public void testAllowlist() throws IOException {  
import org.opensearch.test.OpenSearchTestCase;
        );
                "sort",
                "set",
                "kv",  
            final Set<String> expected = Set.of(
 */  
            .putList(IngestCommonModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), allowlist)
 * this file be licensed under the Apache-2.0 license or a
        try (IngestCommonModulePlugin plugin = new IngestCommonModulePlugin()) {  
                "split_to_fields",
    }  
            assertEquals(Set.copyOf(allowlist), plugin.getProcessors(createParameters(settings)).keySet());
            null,
    private static Processor.Parameters createParameters(Settings settings) {
                "split",  
                "rename",
        runAllowlistTest(List.of());
                "uppercase",
    private void runAllowlistTest(List<String> allowlist) throws IOException {
                "append",
        final Settings settings = builder.build();
                "join",
    public void testAllowlistNotSpecified() throws IOException {
import java.util.List;
                "community_id",
        }
            assertTrue(e.getMessage(), e.getMessage().contains("threeve"));
                "hierarchical_routing",
            null,
                "date",
    }  
            .putList(IngestCommonModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), List.of("threeve"))  
                "convert",  
                "bytes",
                "gsub",
            .build();
        final Settings settings = Settings.builder()  
                "html_strip",  
import org.opensearch.ingest.Processor;  
 *
        }
                "fingerprint",
        builder.remove(IngestCommonModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey());
    public void testAllowlistHasNonexistentProcessors() throws IOException {
                "csv",
import org.opensearch.env.TestEnvironment;
    }  
                "dissect",
        runAllowlistTest(List.of("set"));  
package org.opensearch.ingest.common;
            TestEnvironment.newEnvironment(Settings.builder().put(settings).put("path.home", "").build()),
        runAllowlistTest(List.of("date", "set", "copy"));
}
            null
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
