            return format;
    /**
        // computeChecksum would fall back to file scan if not cached — but we can verify
import java.io.IOException;
        long expectedChecksum = 3847291056L;
 *
        }
import static org.mockito.Mockito.mock;
 */
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
     * Verifies that calling createChecksumStrategies() twice returns DIFFERENT
        DataFormatRegistry registry = createRegistry(format);
        assertEquals("Checksum registered by engine must be visible via directory strategy", expectedChecksum, actualChecksum);
import java.nio.file.Path;
        public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
        IndexSettings indexSettingsA = createIndexSettings("index_a");
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
     * This confirms the fix must call it only once per shard.
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), FORMAT_NAME)
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
            return Map.of(FORMAT_NAME, () -> new DataFormatDescriptor(FORMAT_NAME, new PrecomputedChecksumStrategy()));
        @Override
     * Verifies that createChecksumStrategies returns empty map when no pluggable
        Settings settings = Settings.builder()
        PrecomputedChecksumStrategy stratA = (PrecomputedChecksumStrategy) strategiesA.get(FORMAT_NAME);
        IndexSettings indexSettings = createIndexSettings("test_index");
        public DataFormat getDataFormat() {
     * This is the exact bug scenario that was broken before the fix.
import java.util.function.Supplier;
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
    private DataFormatRegistry createRegistry(MockDataFormat format) {
/*
        FormatChecksumStrategy directoryStrategy = directory.getChecksumStrategy(FORMAT_NAME);
        // Simulate directory reading the checksum during upload
    }
        expectThrows(UnsupportedOperationException.class, () -> strategies.put("new_format", new PrecomputedChecksumStrategy()));
        Map<String, FormatChecksumStrategy> strategies = registry.createChecksumStrategies(indexSettings);
    }
    private static final String FORMAT_NAME = "test_format";
        IndexSettings indexSettings = createIndexSettings("test_index");
    }
     * instances (since getFormatDescriptors creates new ones each call).
import org.apache.lucene.store.FSDirectory;
            .build();
        // Register checksum in index A's strategy
        assertTrue(strategies.isEmpty());
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
import org.opensearch.index.IndexSettings;
        }
            // Creates a NEW PrecomputedChecksumStrategy every call — this is the bug pattern
        private final MockDataFormat format;
        DataFormatRegistry registry = createRegistry(format);
import java.util.List;
import org.opensearch.plugins.PluginsService;
        public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings, DataFormatRegistry registry) {
        IndexSettings indexSettings = createIndexSettings("test_index");
    }
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
 * Tests that validate the FormatChecksumStrategy single-instance fix:
        IndexSettings indexSettings = new IndexSettings(IndexMetadata.builder("plain_index").settings(settings).build(), settings);
        strategiesA.get(FORMAT_NAME).registerChecksum("_0.parquet", 12345L, 1L);
 * compatible open source license.
        directory.close();
        // Index settings WITHOUT pluggable_dataformat setting
import org.opensearch.index.store.PrecomputedChecksumStrategy;
        // Single call — same map shared by directory and engine
        DataFormatRegistry registry = createRegistry(format);
        Map<String, FormatChecksumStrategy> strategies = registry.createChecksumStrategies(indexSettings);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.test.OpenSearchTestCase;
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
        StrategyCreatingPlugin(MockDataFormat format) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private static class StrategyCreatingPlugin extends org.opensearch.plugins.Plugin implements DataFormatPlugin {
/**
        Settings settings = Settings.builder()
        Map<String, FormatChecksumStrategy> strategiesA = registry.createChecksumStrategies(indexSettingsA);
        DataFormatRegistry registry = createRegistry(format);
    public void testCreateChecksumStrategiesReturnsSameInstance() {
import org.opensearch.common.settings.Settings;
     */
    public void testChecksumVisibleAcrossSharedStrategy() throws IOException {
    private IndexSettings createIndexSettings(String indexName) {
    }
        PluginsService pluginsService = mock(PluginsService.class);
import java.util.Map;
 * strategies are created once per shard and shared between directory and engine.
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
        DataFormatAwareStoreDirectory directory = new DataFormatAwareStoreDirectory(fsDir, shardPath, strategies);
import java.util.Set;
            this.format = format;
        Path tempDir = createTempDir();
import java.nio.file.Files;
        return new IndexSettings(IndexMetadata.builder(indexName).settings(settings).build(), settings);
    }
        // Simulate engine registering a checksum during write
        Map<String, FormatChecksumStrategy> strategies = registry.createChecksumStrategies(indexSettings);
     * isolated strategy instances — no cross-index contamination.
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        Files.createDirectories(shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME));
import org.opensearch.plugins.SearchBackEndPlugin;
import org.opensearch.index.shard.ShardPath;
        IndexSettings indexSettingsB = createIndexSettings("index_b");
    public void testCreateChecksumStrategiesReturnsUnmodifiableMap() {
     * getFormatDescriptors() call — reproducing the original bug pattern.
    /**
     */
        Map<String, FormatChecksumStrategy> first = registry.createChecksumStrategies(indexSettings);
        assertNotSame(strategiesA.get(FORMAT_NAME), strategiesB.get(FORMAT_NAME));
        assertNotSame(stratA, stratB);
 * The OpenSearch Contributors require contributions made to
 */
    /**
     * Core test: checksum registered via the engine's strategy reference is visible
        PrecomputedChecksumStrategy stratB = (PrecomputedChecksumStrategy) strategiesB.get(FORMAT_NAME);
    public void testMultipleCallsCreateDifferentInstances() {
     * from the directory's strategy reference when they share the same instance.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.store.FormatChecksumStrategy;
     * A DataFormatPlugin that returns a new PrecomputedChecksumStrategy on every
        assertTrue(strategies.get(FORMAT_NAME) instanceof PrecomputedChecksumStrategy);
     * that both the directory and engine would share.
        FSDirectory fsDir = FSDirectory.open(shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME));
    /**
        DataFormatRegistry registry = createRegistry(format);
import static org.mockito.Mockito.when;
        Map<String, FormatChecksumStrategy> second = registry.createChecksumStrategies(indexSettings);
        long actualChecksum = directoryStrategy.computeChecksum(fsDir, "_0_1.parquet");
        assertSame("Directory and engine must share the same strategy instance", sharedStrategy, directoryStrategy);
package org.opensearch.index.engine.dataformat;
     */
        MockDataFormat format = new MockDataFormat(FORMAT_NAME, 100L, Set.of());
        // the cache is empty by checking that a different checksum isn't magically present
     */
        // Different indices get different strategy instances
        return new DataFormatRegistry(pluginsService);
        @Override
        assertNotNull(strategies.get(FORMAT_NAME));
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
 * SPDX-License-Identifier: Apache-2.0
        DataFormatRegistry registry = createRegistry(format);
    }
        IndexSettings indexSettings = createIndexSettings("test_index");
import org.opensearch.core.index.shard.ShardId;
        Map<String, FormatChecksumStrategy> strategiesB = registry.createChecksumStrategies(indexSettingsB);
     * Verifies that createChecksumStrategies() returns the same strategy instance
    /**
        ShardPath shardPath = new ShardPath(false, shardDataPath, shardDataPath, new ShardId("index", "uuid", 0));
     */
     * data format is configured.
        Map<String, FormatChecksumStrategy> strategies = registry.createChecksumStrategies(indexSettings);
        // Index B's strategy should NOT see it
    public void testDifferentIndicesGetIsolatedStrategies() {
            .build();
     * Verifies that the strategies map returned by createChecksumStrategies is unmodifiable.
        }
    /**
        // Verify the checksum registered by the engine is readable from the directory's strategy (O(1) lookup)
        StrategyCreatingPlugin plugin = new StrategyCreatingPlugin(format);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
     */
        sharedStrategy.registerChecksum("_0_1.parquet", expectedChecksum, 1L);
            return null;
public class FormatChecksumStrategySharingTests extends OpenSearchTestCase {
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
     * Verifies that concurrent shard creation for different indices produces
        }
    /**
}
        assertNotSame(first.get(FORMAT_NAME), second.get(FORMAT_NAME));
import org.opensearch.cluster.metadata.IndexMetadata;
        // The directory's strategy IS the same instance
        // Different calls produce different instances — this is WHY we must call it only once
    }
    public void testCreateChecksumStrategiesEmptyWhenNoFormat() {
        Path shardDataPath = tempDir.resolve("uuid").resolve("0");
     */
        FormatChecksumStrategy sharedStrategy = strategies.get(FORMAT_NAME);
        @Override
