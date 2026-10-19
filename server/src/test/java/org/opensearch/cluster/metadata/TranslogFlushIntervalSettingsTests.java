            .build();  
        Settings requestSettings = Settings.builder()
        Settings requestSettings = Settings.builder()
        Settings requestSettings = Settings.builder()  
        Settings requestSettings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
            indexSettings
    }  
        MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings);
/*  
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            () -> MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings)
        Settings indexSettings = Settings.builder()
        // This should not throw an exception
        // This should not throw an exception
        Settings requestSettings = Settings.builder()
            MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(
            .build();
            IllegalArgumentException.class,  
        Settings indexSettings = Settings.builder()  
        // This should not throw an exception  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        );  
        Optional<String> err = MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            ).isEmpty()
            IllegalArgumentException.class,
 * Tests for translog flush interval settings update with and without composite index
                indexSettings
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
    }
        );
        assertTrue(err.isPresent());  
 */  
        .build();
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
        Settings indexSettings = Settings.builder().build();  
 * The OpenSearch Contributors require contributions made to  
        Settings requestSettings = Settings.builder()
public class TranslogFlushIntervalSettingsTests extends OpenSearchTestCase {
        );
            clusterSettings,  
    Settings settings = Settings.builder()  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "130mb")
                clusterSettings,  
    }
        Settings requestSettings = Settings.builder()  
        );
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", ex.getMessage());
    }
/**
        assertTrue(  
        // This should not throw an exception
            MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(
 * this file be licensed under the Apache-2.0 license or a
                requestSettings,
 */  
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            .build();
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            () -> MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings)  
    }
    public void testUpdateIndexThresholdFlushSize() {
    }
        Settings requestSettings = Settings.builder()
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "50mb")
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "100mb")  
    public void testMissingCompositeIndexSetting() {  
import org.opensearch.index.IndexSettings;  
    public void testValidSettings() {
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
        );
            .build();  
 *
    public void testNullTranslogFlushSetting() {  
    ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        // This should not throw an exception
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
                requestSettings,
import java.util.Optional;
        Settings requestSettings = Settings.builder()
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
    public void testDefaultTranslogFlushSetting() {
            .build();
                clusterSettings,  
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertTrue(  
import org.opensearch.common.settings.Settings;
        IllegalArgumentException ex = expectThrows(
    }
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "150mb")
        IllegalArgumentException ex = expectThrows(
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "50mb")
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "131mb")
            () -> MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings)
import org.opensearch.common.settings.ClusterSettings;
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        // This should not throw an exception  
        MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings);
    public void testExceedingMaxFlushSize() {  
import org.opensearch.test.OpenSearchTestCase;  
    }
    public void testUpdateFlushSizeAboveThresholdWithoutCompositeIndex() {
            .build();
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", ex.getMessage());  
                indexSettings
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
            ).isEmpty()
    public void testUpdateFlushSizeAboveThresholdWithCompositeIndex() {  
}
        MetadataCreateIndexService.validateTranslogFlushIntervalSettingsForCompositeIndex(requestSettings, clusterSettings);  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", err.get());
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            .build();
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", ex.getMessage());  
        // This should not throw an exception
            .build();
            .putNull(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey())
 * compatible open source license.
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "131mb")  
            IllegalArgumentException.class,  
            requestSettings,
            .build();
            .build();
        );  
    }
    public void testEqualToMaxFlushSize() {
            .build();  
package org.opensearch.cluster.metadata;
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "100mb")
        IllegalArgumentException ex = expectThrows(
