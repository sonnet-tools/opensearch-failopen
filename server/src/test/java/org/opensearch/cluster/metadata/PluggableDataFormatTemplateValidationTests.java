            .put(super.nodeSettings())  
    private static ComposableIndexTemplate composableTemplate(Settings settings, String mapping) throws Exception {
import org.opensearch.plugins.Plugin;
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    }
        MetadataIndexTemplateService service = templateService();
    @Override  
import org.opensearch.action.admin.indices.template.post.TransportSimulateIndexTemplateAction;
            () -> service.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "it", composableTemplate(Settings.EMPTY, INDEX_TRUE))
import java.util.ArrayList;
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
 * Validates that, when a pluggable data format is the cluster-wide default
     */
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));
        ClusterState state = service.addIndexTemplateV2(
            .metadata(Metadata.builder().put("it", composableTemplate(Settings.EMPTY, INDEX_TRUE)))  
    /** A template with index: false resolves cleanly through the simulate path. */  
 * it to false are accepted, and a template that explicitly opts out of the pluggable data format
import java.util.Collection;
            Collections.singletonList("pdf-*"),
    protected Settings featureFlagSettings() {
        // Stage the template directly in metadata, bypassing put-time validation, to exercise the  
        return plugins;
        // resolve/simulate path in isolation.
    /**
    public void testComponentTemplateAcceptsIndexOmitted() throws Exception {
    }
        ClusterState state = service.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "it", composableTemplate(optOut, INDEX_TRUE));
package org.opensearch.cluster.metadata;
                state,
        // doc-values-backed types) so the capability path rejects index:true.
            composableTemplate(Settings.EMPTY, INDEX_FALSE)
    protected Collection<Class<? extends Plugin>> getPlugins() {  
                xContentRegistry(),
            true,  
        return new ComposableIndexTemplate(  
            false,  
    }
        assertNotNull(resolved);  
    }
    }
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true).build();  
import org.opensearch.cluster.ClusterState;
import org.opensearch.indices.IndicesService;  
            ClusterState.EMPTY_STATE,
     * must not report success for a template that could never create an index.  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
import org.opensearch.common.util.FeatureFlags;
        return getInstanceFromNode(MetadataIndexTemplateService.class);
        return sb.toString();
                MockDocValuesDataFormatPlugin.FORMAT_NAME  
    public void testComposableTemplateWithExplicitOptOutAcceptsIndexTrue() throws Exception {
    /**  
                "it",
import org.opensearch.index.IndexSettings;  
 * compatible open source license.
        Exception e = expectThrows(  
    protected Settings nodeSettings() {
    public void testComponentTemplateRejectsIndexTrue() throws Exception {
    @Override
import java.util.HashMap;
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));
            .build();  
            null,
    }
        }  
            new Template(settings, new CompressedXContent(mapping), null),
        );
        }  
        MetadataIndexTemplateService service = templateService();  
            null  
            )
        );
        assertNotNull(state.metadata().templatesV2().get("it"));
import java.util.List;
        Exception e = expectThrows(
        // EngineConfigFactory permits exactly one committer factory per node; when the sandbox stack is  
        if (shouldInstallSandboxStack() == false) {
 * (producing vanilla indices) may still set {@code index: true}.  
        // MockDocValuesDataFormatPlugin registers the "mock-dv" data format (columnar storage only for
        return Settings.builder()
    public void testComposableTemplateAcceptsIndexFalse() throws Exception {
            Exception.class,
        MetadataIndexTemplateService service = templateService();
    }
    private MetadataIndexTemplateService templateService() {  
 * every index (including rollovers) the template creates. Templates that omit {@code index} or set
 * SPDX-License-Identifier: Apache-2.0
        return new ComponentTemplate(new Template(Settings.EMPTY, new CompressedXContent(mapping), null), 1L, new HashMap<>());
    }
            Exception.class,  
            .metadata(Metadata.builder().put("it", composableTemplate(Settings.EMPTY, INDEX_FALSE)))  
            "it",
        assertNotNull(state.metadata().templatesV2().get("it"));  
     */
 * on a doc-values-backed field are rejected at template-creation time — so they cannot later fail  
     * index: true is valid — so it must be accepted even while the cluster default is on.  
 */
 * The OpenSearch Contributors require contributions made to  
        // installed, its LucenePlugin supplies the real committer, so the in-memory mock committer is only
public class PluggableDataFormatTemplateValidationTests extends OpenSearchSingleNodeTestCase {
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
    }
            sb.append(cur.getMessage()).append('\n');
import org.opensearch.common.compress.CompressedXContent;  
        MetadataIndexTemplateService service = templateService();
        ClusterState state = service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_FALSE));  
/**  
                new AliasValidator(),
            MockDocValuesDataFormatPlugin.FORMAT_NAME
    @Override
                getInstanceFromNode(IndicesService.class),  
        Exception e = expectThrows(  
        StringBuilder sb = new StringBuilder();  
 *
        ClusterState state = service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_OMITTED));  
    public void testSimulateResolveTemplateAcceptsIndexFalse() throws Exception {
        MetadataIndexTemplateService service = templateService();  
        MetadataIndexTemplateService service = templateService();
 * ({@code cluster.pluggable.dataformat.enabled}), templates carrying an explicit {@code index: true}
    }
    public void testSimulateResolveTemplateRejectsIndexTrue() throws Exception {
        List<Class<? extends Plugin>> plugins = new ArrayList<>(List.of(MockDocValuesDataFormatPlugin.class));  
            .build();
            new AliasValidator(),
            () -> TransportSimulateIndexTemplateAction.resolveTemplate(
}
/*  
        );  
    /** Concatenates the message of a throwable and its full cause chain, for order-independent matching. */
 */  
        // registered in the plugin-free run.
        );  
    private static ComponentTemplate componentTemplate(String mapping) throws Exception {
    private static String fullMessage(Throwable t) {
            null,  
                "pdf-1",  
            state,
     * a template with index: true is rejected the same way real index creation would be — the preview
    public void testComposableTemplateRejectsIndexTrue() throws Exception {
    }  
        Settings optOut = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false).build();
    }  
            null,
    private static final String INDEX_OMITTED = "{\"properties\":{\"n\":{\"type\":\"long\"}}}";  
        assertNotNull(state.metadata().componentTemplates().get("ct"));
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {
                true,
            () -> service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_TRUE))
import org.opensearch.common.settings.Settings;
            getInstanceFromNode(IndicesService.class),
            "it",  
     * The simulate API resolves the composed template against a dummy pluggable index, so a preview of
    private static final String INDEX_FALSE = "{\"properties\":{\"n\":{\"type\":\"long\",\"index\":false}}}";
        );  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            xContentRegistry(),  
    }
    public void testComponentTemplateAcceptsIndexFalse() throws Exception {
        // The composable path wraps the mapper rejection; assert on the full cause chain.
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
import static org.hamcrest.Matchers.containsString;
        Template resolved = TransportSimulateIndexTemplateAction.resolveTemplate(
            plugins.add(MockCommitterEnginePlugin.class);
            .build();
        );
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.Collections;  
     * A template that explicitly opts out of the pluggable data format produces vanilla indices, where
            Exception.class,
    private static final String INDEX_TRUE = "{\"properties\":{\"n\":{\"type\":\"long\",\"index\":true}}}";
            "pdf-1",
    }
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), MockDocValuesDataFormatPlugin.FORMAT_NAME)
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));  
        assertNotNull(state.metadata().componentTemplates().get("ct"));
