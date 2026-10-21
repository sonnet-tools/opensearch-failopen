        return getInstanceFromNode(MetadataIndexTemplateService.class);
            .build();
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), MockDocValuesDataFormatPlugin.FORMAT_NAME)
    }
    protected Collection<Class<? extends Plugin>> getPlugins() {
    /** A template with index: false resolves cleanly through the simulate path. */
    }
 * it to false are accepted, and a template that explicitly opts out of the pluggable data format
                new AliasValidator(),
    /** Concatenates the message of a throwable and its full cause chain, for order-independent matching. */
        MetadataIndexTemplateService service = templateService();
        MetadataIndexTemplateService service = templateService();
        // Stage the template directly in metadata, bypassing put-time validation, to exercise the
            Exception.class,
        // EngineConfigFactory permits exactly one committer factory per node; when the sandbox stack is
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    protected Settings featureFlagSettings() {
    public void testComposableTemplateAcceptsIndexFalse() throws Exception {
    public void testSimulateResolveTemplateAcceptsIndexFalse() throws Exception {
                state,
    }
package org.opensearch.cluster.metadata;
        );
import org.opensearch.common.settings.Settings;
    }
        assertNotNull(state.metadata().componentTemplates().get("ct"));
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));
        // registered in the plugin-free run.
            Exception.class,
            true,
        MetadataIndexTemplateService service = templateService();
            () -> TransportSimulateIndexTemplateAction.resolveTemplate(
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
        );
    @Override
import java.util.ArrayList;
            false,
        );
    }
    }
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {
            Collections.singletonList("pdf-*"),
 * Validates that, when a pluggable data format is the cluster-wide default
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));
        );
        if (shouldInstallSandboxStack() == false) {
    private static String fullMessage(Throwable t) {
    public void testComposableTemplateWithExplicitOptOutAcceptsIndexTrue() throws Exception {
        Exception e = expectThrows(
        ClusterState state = service.addIndexTemplateV2(
            null,
            xContentRegistry(),
 * every index (including rollovers) the template creates. Templates that omit {@code index} or set
            new AliasValidator(),
    private static final String INDEX_TRUE = "{\"properties\":{\"n\":{\"type\":\"long\",\"index\":true}}}";
            state,
            sb.append(cur.getMessage()).append('\n');
        assertNotNull(resolved);
        // installed, its LucenePlugin supplies the real committer, so the in-memory mock committer is only
    }
        Exception e = expectThrows(
    }
            ClusterState.EMPTY_STATE,
    private static final String INDEX_FALSE = "{\"properties\":{\"n\":{\"type\":\"long\",\"index\":false}}}";
                "it",
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true).build();
        return sb.toString();
            MockDocValuesDataFormatPlugin.FORMAT_NAME
                "pdf-1",
        assertNotNull(state.metadata().templatesV2().get("it"));
        Settings optOut = Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false).build();
        }
                MockDocValuesDataFormatPlugin.FORMAT_NAME
            new Template(settings, new CompressedXContent(mapping), null),
import java.util.List;
import java.util.HashMap;
            "it",
        ClusterState state = service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_FALSE));
import org.opensearch.action.admin.indices.template.post.TransportSimulateIndexTemplateAction;
            null,
        );
        return new ComponentTemplate(new Template(Settings.EMPTY, new CompressedXContent(mapping), null), 1L, new HashMap<>());
                true,
    @Override
 * The OpenSearch Contributors require contributions made to
 *
import org.opensearch.cluster.ClusterState;
            .build();
            getInstanceFromNode(IndicesService.class),
                xContentRegistry(),
 */
public class PluggableDataFormatTemplateValidationTests extends OpenSearchSingleNodeTestCase {
    public void testComponentTemplateAcceptsIndexOmitted() throws Exception {
            null,
     */
        }
            "pdf-1",
        List<Class<? extends Plugin>> plugins = new ArrayList<>(List.of(MockDocValuesDataFormatPlugin.class));
     */
        assertNotNull(state.metadata().componentTemplates().get("ct"));
    public void testSimulateResolveTemplateRejectsIndexTrue() throws Exception {
/*
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
    @Override
    private MetadataIndexTemplateService templateService() {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            plugins.add(MockCommitterEnginePlugin.class);
 */
        Exception e = expectThrows(
        // doc-values-backed types) so the capability path rejects index:true.
    public void testComposableTemplateRejectsIndexTrue() throws Exception {
            composableTemplate(Settings.EMPTY, INDEX_FALSE)
    private static ComponentTemplate componentTemplate(String mapping) throws Exception {
    }
     * must not report success for a template that could never create an index.
}
    /**
     * index: true is valid — so it must be accepted even while the cluster default is on.
    }
        MetadataIndexTemplateService service = templateService();
    protected Settings nodeSettings() {
            .metadata(Metadata.builder().put("it", composableTemplate(Settings.EMPTY, INDEX_FALSE)))
import static org.hamcrest.Matchers.containsString;
 * ({@code cluster.pluggable.dataformat.enabled}), templates carrying an explicit {@code index: true}
    private static final String INDEX_OMITTED = "{\"properties\":{\"n\":{\"type\":\"long\"}}}";
    }
 * (producing vanilla indices) may still set {@code index: true}.
        return new ComposableIndexTemplate(
            null
        MetadataIndexTemplateService service = templateService();
     * The simulate API resolves the composed template against a dummy pluggable index, so a preview of
import org.opensearch.index.IndexSettings;
        ClusterState state = service.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "it", composableTemplate(optOut, INDEX_TRUE));
    }
 * compatible open source license.
 * on a doc-values-backed field are rejected at template-creation time — so they cannot later fail
        assertThat(fullMessage(e), containsString("cannot cover: [POINT_RANGE]"));
    }
        // resolve/simulate path in isolation.
    }
    /**
        return plugins;
        MetadataIndexTemplateService service = templateService();
            "it",
        assertNotNull(state.metadata().templatesV2().get("it"));
        StringBuilder sb = new StringBuilder();
            .build();
            () -> service.addIndexTemplateV2(ClusterState.EMPTY_STATE, false, "it", composableTemplate(Settings.EMPTY, INDEX_TRUE))
            )
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
        ClusterState state = service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_OMITTED));
        // MockDocValuesDataFormatPlugin registers the "mock-dv" data format (columnar storage only for
import java.util.Collection;
        );
import org.opensearch.plugins.Plugin;
            Exception.class,
import org.opensearch.common.util.FeatureFlags;
        // The composable path wraps the mapper rejection; assert on the full cause chain.
    public void testComponentTemplateAcceptsIndexFalse() throws Exception {
            .metadata(Metadata.builder().put("it", composableTemplate(Settings.EMPTY, INDEX_TRUE)))
 * this file be licensed under the Apache-2.0 license or a
            () -> service.addComponentTemplate(ClusterState.EMPTY_STATE, false, "ct", componentTemplate(INDEX_TRUE))
import org.opensearch.indices.IndicesService;
        return Settings.builder()
import org.opensearch.common.compress.CompressedXContent;
        Template resolved = TransportSimulateIndexTemplateAction.resolveTemplate(
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
    private static ComposableIndexTemplate composableTemplate(Settings settings, String mapping) throws Exception {
            .put(super.nodeSettings())
     * a template with index: true is rejected the same way real index creation would be — the preview
     * A template that explicitly opts out of the pluggable data format produces vanilla indices, where
                getInstanceFromNode(IndicesService.class),
/**
    public void testComponentTemplateRejectsIndexTrue() throws Exception {
            .put(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    }
