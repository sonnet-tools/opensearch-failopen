        internalCluster().startDataOnlyNode(nodeSettings(true));  
import org.opensearch.test.OpenSearchIntegTestCase;
            message.contains(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey())
import org.opensearch.common.settings.Settings;
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testAcceptsMatchingOverrideWhenRestrictIsTrue() {
        CreateIndexResponse response = client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
                + "] but was ["
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                + message
        ensureGreen(INDEX_NAME);
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            LucenePlugin.class,  
 * The OpenSearch Contributors require contributions made to  
 * settings bag.
 * enforcement. The setting is {@code Property.Final}, so each test starts nodes with its own  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
            CompositeDataFormatPlugin.class,
            .setSettings(Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet"))  
        IllegalArgumentException thrown = expectThrows(
    }
            .build();  
}
    }  
            .preparePutTemplate("permissive-composite-template")  
    }
 * Integration tests for {@link CompositeDataFormatPlugin#CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING}
        internalCluster().startClusterManagerOnlyNode(nodeSettings(false));
            .get();
    public void testAllowsTemplateOverrideWhenRestrictIsFalse() {  
            .setPatterns(Collections.singletonList(INDEX_NAME + "*"))
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .put(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey(), restrict)
            .setSettings(Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet"))
        AcknowledgedResponse putTemplate = client().admin()
        String message = thrown.getMessage();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            () -> client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get()
            IllegalArgumentException.class,  
import java.util.Collection;
            () -> client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get()  
        assertTrue(putTemplate.isAcknowledged());
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .build();  
    }
            .build();  
        Settings indexSettings = Settings.builder()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
package org.opensearch.composite;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 */
        );
            DataFusionPlugin.class
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().startClusterManagerOnlyNode(nodeSettings(false));
 * compatible open source license.
        internalCluster().startDataOnlyNode(nodeSettings(true));  
        internalCluster().startDataOnlyNode(nodeSettings(false));
        assertTrue(putTemplate.isAcknowledged());  
        internalCluster().startDataOnlyNode(nodeSettings(true));  
        createIndex(INDEX_NAME);
    public void testAllowsOverrideWhenRestrictIsFalse() {
        IllegalArgumentException thrown = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME));
        assertTrue(  
import org.opensearch.cluster.metadata.IndexMetadata;  
            message.contains(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey())  
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")
        );
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                + message
    }
                + "]",  
        return Arrays.asList(
            .setPatterns(Collections.singletonList(INDEX_NAME + "*"))
                + CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()  
import java.util.Arrays;
            "expected validation error to mention restrict setting but was [" + message + "]",
    }
import org.opensearch.plugins.Plugin;
            .preparePutTemplate("restrict-composite-template")
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
    private static final String INDEX_NAME = "test-composite-restrict";  
        AcknowledgedResponse putTemplate = client().admin()
        internalCluster().startDataOnlyNode(nodeSettings(false));  
        Settings indexSettings = Settings.builder()
    public void testRejectsTemplateOverrideWhenRestrictIsTrue() {
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            .indices()  
        Settings indexSettings = Settings.builder()
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertTrue(thrown.getMessage().contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));  
            ArrowBasePlugin.class,  
import static org.opensearch.composite.CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING;
    private static final String CLUSTER_DEFAULT_PRIMARY = "lucene";
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.FeatureFlags;
            .get();
    }
            .build();
            .build();
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), CLUSTER_DEFAULT_PRIMARY)
                + CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                + "]",
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        assertTrue(
        Settings indexSettings = Settings.builder()
            "expected validation error to mention ["
        );  
import java.util.Collections;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .indices()
        ensureGreen(INDEX_NAME);
            ParquetDataFormatPlugin.class,
public class RestrictCompositeDataFormatOverrideIT extends OpenSearchIntegTestCase {
    private Settings nodeSettings(boolean restrict) {
            message.contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey())
        assertTrue(response.isAcknowledged());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "expected validation error to mention ["
        ensureGreen(INDEX_NAME);
import org.opensearch.be.lucene.LucenePlugin;
            .setOrder(0)
    public void testRejectsSecondaryOverrideWhenRestrictIsTrue() {  
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
            IllegalArgumentException.class,
        assertTrue(response.isAcknowledged());  
        internalCluster().startDataOnlyNode(nodeSettings(true));
        assertTrue(  
/*  
        String message = thrown.getMessage();
 *
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), CLUSTER_DEFAULT_PRIMARY)  
        IllegalArgumentException thrown = expectThrows(
        return Settings.builder()  
                + "] but was ["  
    public void testRejectsPrimaryOverrideWhenRestrictIsTrue() {
    @Override  
/**
        CreateIndexResponse response = client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
        );
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            .setOrder(0)  
 */  
