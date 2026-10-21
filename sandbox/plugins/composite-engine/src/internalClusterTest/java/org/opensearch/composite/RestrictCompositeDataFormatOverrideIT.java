 * Integration tests for {@link CompositeDataFormatPlugin#CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING}
        ensureGreen(INDEX_NAME);
    public void testAllowsOverrideWhenRestrictIsFalse() {
    }
        internalCluster().startDataOnlyNode(nodeSettings(false));
public class RestrictCompositeDataFormatOverrideIT extends OpenSearchIntegTestCase {
package org.opensearch.composite;
            LucenePlugin.class,
    }
            .setSettings(Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet"))
        CreateIndexResponse response = client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
            .indices()
            "expected validation error to mention ["
        assertTrue(
            "expected validation error to mention ["
        return Arrays.asList(
 * enforcement. The setting is {@code Property.Final}, so each test starts nodes with its own
            .put(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey(), restrict)
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        );
    public void testRejectsTemplateOverrideWhenRestrictIsTrue() {
            () -> client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get()
        assertTrue(response.isAcknowledged());
        assertTrue(response.isAcknowledged());
            .setPatterns(Collections.singletonList(INDEX_NAME + "*"))
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), CLUSTER_DEFAULT_PRIMARY)
    private static final String CLUSTER_DEFAULT_PRIMARY = "lucene";
import org.opensearch.plugins.Plugin;
                + message
 */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ensureGreen(INDEX_NAME);
/**
            .build();
        return Settings.builder()
    }
            .get();
import java.util.Collection;
            IllegalArgumentException.class,
            .setOrder(0)
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
            () -> client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get()
        IllegalArgumentException thrown = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertTrue(
        assertTrue(
            ArrowBasePlugin.class,
            .setSettings(Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet"))
            message.contains(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey())
            .build();
        internalCluster().startDataOnlyNode(nodeSettings(true));
import static org.opensearch.composite.CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING;
            .build();
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
 * SPDX-License-Identifier: Apache-2.0
        );
        internalCluster().startClusterManagerOnlyNode(nodeSettings(false));
    public void testAcceptsMatchingOverrideWhenRestrictIsTrue() {
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
        ensureGreen(INDEX_NAME);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")
import java.util.Collections;
                + "] but was ["
            CompositeDataFormatPlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                + CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()
import org.opensearch.test.OpenSearchIntegTestCase;
        AcknowledgedResponse putTemplate = client().admin()
        Settings indexSettings = Settings.builder()
            .build();
            .indices()
import org.opensearch.be.lucene.LucenePlugin;
import java.util.Arrays;
 * settings bag.
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
        AcknowledgedResponse putTemplate = client().admin()
        internalCluster().startClusterManagerOnlyNode(nodeSettings(false));
    public void testRejectsSecondaryOverrideWhenRestrictIsTrue() {
        );
        Settings indexSettings = Settings.builder()
        internalCluster().startClusterManagerOnlyNode(nodeSettings(true));
    }
                + "]",
        );
        assertTrue(putTemplate.isAcknowledged());
        assertTrue(thrown.getMessage().contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));
        createIndex(INDEX_NAME);
        assertTrue(putTemplate.isAcknowledged());
        internalCluster().startDataOnlyNode(nodeSettings(true));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.cluster.metadata.IndexMetadata;
            DataFusionPlugin.class
import org.opensearch.parquet.ParquetDataFormatPlugin;
        String message = thrown.getMessage();
 * this file be licensed under the Apache-2.0 license or a
}
            .preparePutTemplate("restrict-composite-template")
            ParquetDataFormatPlugin.class,
        internalCluster().startDataOnlyNode(nodeSettings(true));
        Settings indexSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String message = thrown.getMessage();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        IllegalArgumentException thrown = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME));
        IllegalArgumentException thrown = expectThrows(
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), CLUSTER_DEFAULT_PRIMARY)
            message.contains(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey())
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 *
 * compatible open source license.
            .setPatterns(Collections.singletonList(INDEX_NAME + "*"))
import org.opensearch.common.util.FeatureFlags;
        );
    private Settings nodeSettings(boolean restrict) {
/*
    }
 * The OpenSearch Contributors require contributions made to
            .preparePutTemplate("permissive-composite-template")
import org.opensearch.common.settings.Settings;
        CreateIndexResponse response = client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
            IllegalArgumentException.class,
        );
    public void testRejectsPrimaryOverrideWhenRestrictIsTrue() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings indexSettings = Settings.builder()
                + message
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testAllowsTemplateOverrideWhenRestrictIsFalse() {
        internalCluster().startDataOnlyNode(nodeSettings(true));
                + "] but was ["
            "expected validation error to mention restrict setting but was [" + message + "]",
                + "]",
            .setOrder(0)
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
            .build();
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
 */
    }
        internalCluster().startDataOnlyNode(nodeSettings(false));
    @Override
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .get();
                + CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()
    }
    private static final String INDEX_NAME = "test-composite-restrict";
            message.contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey())
