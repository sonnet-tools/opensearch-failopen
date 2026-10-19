/*  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.opensearch.plugins.Plugin;
        Settings before = getIndexSettings(indexBefore);
    }
import static org.opensearch.indices.IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING;
    }  
            .setTransientSettings(
    @Override
        return List.of(MockCommitterEnginePlugin.class, MockParquetDataFormatPlugin.class);  
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(after));
    public void testClusterDefaultStampedIntoNewIndexWhenNoOverride() {  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
    public void testClusterDefaultUpdateAppliesToNewIndicesOnly() {  
    protected Settings featureFlagSettings() {  
        ensureGreen(normalIndex);
import org.opensearch.common.settings.FeatureFlagSettings;
import org.opensearch.indices.IndicesService;  
        return Settings.builder()
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(beforeReread));  
        setClusterDefaults(true, "parquet");  
        assertEquals("lucene", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(effective));  
        setClusterDefaults(true, "parquet");  
        ensureGreen(skippedIndex);
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(before));
import java.util.Collection;
            .put(super.nodeSettings(nodeOrdinal))  
        Settings s = resp.getIndexToSettings().get(indexName);
        Settings beforeReread = getIndexSettings(indexBefore);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        builder.put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true);
            .cluster()
            builder.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));  
                Settings.builder()
            .get();  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.indices.IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING;
            )
    }
        createIndex(indexBefore);
public class ClusterDefaultPluggableDataFormatIT extends OpenSearchIntegTestCase {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        String indexAfter = "test-pluggable-after-update";
        );
    }
        return s;
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(before));  
        String normalIndex = "test-pluggable-normal";  
            .putList(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST.getKey(), ".kibana")
        createIndex(
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(skippedSettings));  
        Settings effective = getIndexSettings(indexName);
        String indexName = "test-pluggable-cluster-default";
        // Normal index should have cluster defaults stamped  
import org.opensearch.common.util.FeatureFlags;
        Settings.Builder builder = Settings.builder();
    }
    }
        setClusterDefaults(false, "arrow");  
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(normalSettings));
    protected Settings nodeSettings(int nodeOrdinal) {
                    .put(CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), enabled)  
        // Skipped index should NOT have cluster defaults stamped
        assertEquals("arrow", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(after));  
        ensureGreen(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        return builder.build();  
    }
        createIndex(indexName);
        String indexName = "test-pluggable-request-override";
    public void testExplicitIndexSettingOverridesClusterDefault() {  
        ensureGreen(indexBefore);  
        Settings effective = getIndexSettings(indexName);
    public void testAllowlistBypassesClusterDefaultStamping() {
            Settings.builder()  
        ensureGreen(indexAfter);
        createIndex(skippedIndex);
    }
            .build();
import org.opensearch.common.settings.Setting;  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(beforeReread));
import org.opensearch.index.engine.dataformat.stub.MockParquetDataFormatPlugin;
        createIndex(indexAfter);
        setClusterDefaults(true, "parquet");
        assertFalse(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(effective));
import org.opensearch.index.IndexSettings;  
                .build()  
        Settings after = getIndexSettings(indexAfter);
        String indexBefore = "test-pluggable-before-update";
            .prepareUpdateSettings()  
        GetSettingsResponse resp = client().admin().indices().prepareGetSettings(indexName).get();
        Settings skippedSettings = getIndexSettings(skippedIndex);
        for (Setting<?> builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        createIndex(normalIndex);
import java.util.List;
    private Settings getIndexSettings(String indexName) {  
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(effective));  
        assertTrue(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(effective));
        }
 * compatible open source license.
        assertEquals("", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(skippedSettings));
    }
        client().admin()
}  
    @Override
        Settings normalSettings = getIndexSettings(normalIndex);
                    .put(CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), value)
 */  
    private void setClusterDefaults(boolean enabled, String value) {  
import org.opensearch.common.settings.Settings;
            indexName,
 *
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "lucene")
package org.opensearch.cluster.metadata;
        String skippedIndex = ".kibana-01";
        assertEquals("parquet", IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.get(normalSettings));  
        ensureGreen(indexName);
    @Override  
        setClusterDefaults(true, "parquet");
        assertNotNull(s);  
