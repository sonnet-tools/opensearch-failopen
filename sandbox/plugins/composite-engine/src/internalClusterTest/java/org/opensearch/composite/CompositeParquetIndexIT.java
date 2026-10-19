import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        Settings actual = settingsResponse.getIndexToSettings().get(indexName);
            .indices()
        for (int i = 0; i < 10; i++) {
        );
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
        CreateIndexResponse response = client().admin()
import org.opensearch.common.settings.Settings;
import org.opensearch.index.engine.CommitStats;
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(indexName).get();
            .setTransientSettings(
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
            .prepareStats(indexName)
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        }
            .clear()
        CreateIndexResponse response = client().admin()
        return Arrays.asList(
        );
        Settings actual = settingsResponse.getIndexToSettings().get(INDEX_NAME);
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
/**
            .setDocs(true)
        );
                .setIndex(indexName)
                .get();
            )
        assertTrue(commitStats.getUserData().containsKey(CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY));
            .setDocs(true)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
        CommitStats commitStats = shardStats.getCommitStats();
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).get();
 *   --tests "*.CompositeParquetIndexIT" \
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            .put("index.pluggable.dataformat", "composite")
            .put("index.pluggable.dataformat.enabled", true)
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
import org.opensearch.action.admin.indices.stats.ShardStats;
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
        assertEquals(0, refreshResponse.getShardFailures().length);
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
        assertNotNull(commitStats.getUserData());
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
                    .putNull(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey())
        assertNotNull(commitStats);
        assertTrue(commitStats.getUserData().containsKey(CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY));
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());
            .putList("index.composite.secondary_data_formats")
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());
                .get();
        assertTrue(actual.getAsList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()).isEmpty());
        assertEquals(1, refreshResponse.getSuccessfulShards());
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", 10)
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
        Settings indexSettings = Settings.builder()
        for (int i = 0; i < 10; i++) {
        ensureGreen(indexName);
                "type=integer"
 * Requires JDK 25 and sandbox enabled. Run with:
        // Verify segment count and that each segment has files for both formats
    }
        assertNotNull(commitStats);
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        client().admin()
        // ParquetDataFormatPlugin sources its allocator from the unified native-allocator
            .cluster()
            .putList("index.composite.secondary_data_formats")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
        IndicesStatsResponse statsResponse = client().admin()
            .prepareUpdateSettings()
 */
        CreateIndexResponse response = client().admin()
            .get();
        ensureGreen(indexName);
        String indexName = "test-composite-request-override";
import java.util.Collection;
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(indexName).get();
                .get();
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
import org.opensearch.be.lucene.LucenePlugin;
        // framework's ingest pool, so the framework plugin must be installed.
            .clear()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .get();
            Function.identity()
            .put("index.composite.primary_data_format", "parquet")
            .setRefresh(true)
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
    }
            .cluster()
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
    @Override
            )
                "field_keyword",
            .setStore(true)
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());
        assertEquals("parquet", actual.get("index.composite.primary_data_format"));
        // Index documents with text, keyword, and integer fields
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
            .indices()
            .prepareCreate(indexName)
            .put("index.composite.primary_data_format", "parquet")
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Function.identity()
            .put("index.pluggable.dataformat.enabled", true)
        assertEquals(0, flushResponse.getShardFailures().length);
            .build();
        IndicesStatsResponse statsResponse = client().admin()
        );
            .get();
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        assertEquals(1, flushResponse.getSuccessfulShards());
        assertEquals(1, flushResponse.getTotalShards());
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
            Function.identity()
            )
            )
            .indices()
                    .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
            .indices()
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .get();
            LucenePlugin.class,
            .setRefresh(true)
 *
            .putList("index.composite.secondary_data_formats", "lucene")
 * SPDX-License-Identifier: Apache-2.0
}
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .setRefresh(true)
            .put("index.pluggable.dataformat", "composite")
            .setRefresh(true)
 *
            IndexResponse indexResponse = client().prepareIndex()
            .setDocs(true)
                Settings.builder()
/*
                    .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "parquet")
                Settings.builder()
            .setStore(true)
                .setIndex(indexName)
import org.opensearch.common.util.FeatureFlags;
            .setIndexing(true)
        IndicesStatsResponse statsResponse = client().admin()
            .put(super.nodeSettings(nodeOrdinal))
 * The OpenSearch Contributors require contributions made to
        }
        assertNotNull(commitStats.getUserData());
            .build();
        // Deserialize the catalog snapshot and verify it contains BOTH parquet AND lucene data formats
        assertEquals(0, flushResponse.getShardFailures().length);
 * can be created and its settings are correctly persisted.
        assertEquals("0", actual.get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));
    public void testCompositeIndexRequestOverrideBeatsClusterDefault() throws IOException {
 * ./gradlew :sandbox:plugins:composite-engine:test \
            .cluster()
            .setSettings(indexSettings)
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
import org.opensearch.action.admin.indices.flush.FlushResponse;
            .indices()
        ensureGreen(indexName);
        assertEquals(0, refreshResponse.getShardFailures().length);
            .setIndexing(true)
        client().admin()
        assertEquals("parquet", actual.get(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));
public class CompositeParquetIndexIT extends OpenSearchIntegTestCase {
            .prepareCreate(indexName)
            .indices()
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
        return Settings.builder()
        ShardStats shardStats = statsResponse.getIndex(INDEX_NAME).getShards()[0];
            assertTrue("Each segment should have lucene files", segment.dfGroupedSearchableFiles().containsKey("lucene"));
            .get();
            .setStore(true)
            .prepareUpdateSettings()
                    .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "lucene")
import java.util.function.Function;
            .put("index.composite.primary_data_format", "parquet")
            .setIndexing(true)
            assertEquals(RestStatus.CREATED, indexResponse.status());
        assertEquals("parquet", actual.get(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));
            .setTransientSettings(
        ensureGreen(INDEX_NAME);
import java.io.IOException;
            .indices()
                "field_text",
            IndexResponse indexResponse = client().prepareIndex()
        IndicesStatsResponse statsResponse = client().admin()
    public void testCompositeParquetWithLuceneSecondary() throws IOException {
            .clear()
        assertFalse("Snapshot should have segments", snapshot.getSegments().isEmpty());
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")
            .setSettings(indexSettings)
        assertNotNull(commitStats);
            .get();
                .setIndex(INDEX_NAME)
            assertTrue("Each segment should have parquet files", segment.dfGroupedSearchableFiles().containsKey("parquet"));
        assertEquals(1, flushResponse.getTotalShards());
        assertEquals(RestStatus.OK, client().admin().indices().prepareRefresh(indexName).get().getStatus());
        assertEquals("true", actual.get("index.pluggable.dataformat.enabled"));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .put("index.pluggable.dataformat.enabled", true)
            .prepareStats(indexName)
            .build();
        Settings indexSettings = Settings.builder()
            assertEquals(RestStatus.CREATED, indexResponse.status());
        assertEquals(1, flushResponse.getSuccessfulShards());
    public void testCompositeIndexUsesClusterDefaultFormatsWhenOverridesAbsent() throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
            .get();
        FlushResponse flushResponse = client().admin().indices().prepareFlush(indexName).get();
            .build();
        assertEquals(RestStatus.OK, client().admin().indices().prepareFlush(indexName).get().getStatus());
        ensureGreen(INDEX_NAME);
            assertEquals(RestStatus.CREATED, indexResponse.status());
                    .putNull(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey())
            .prepareCreate(INDEX_NAME)
        Settings indexSettings = Settings.builder()
    }
        assertEquals(RestStatus.OK, flushResponse.getStatus());
import org.opensearch.plugins.Plugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .setTransientSettings(
package org.opensearch.composite;
 * this file be licensed under the Apache-2.0 license or a
            .put("index.pluggable.dataformat", "composite")
        assertEquals(RestStatus.OK, flushResponse.getStatus());
            IndexResponse indexResponse = client().prepareIndex()
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
            .get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.metadata.IndexMetadata;
            .cluster()
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
import org.opensearch.be.datafusion.DataFusionPlugin;
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
                "type=keyword,index=false",
            .prepareStats(indexName)
 * Integration test that validates a composite index with parquet as the primary data format
    }
                "type=text,index=false,store=true",
        assertEquals("lucene", actual.getAsList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()).get(0));
            .setIndexing(true)
    @Override
            .put("index.pluggable.dataformat.enabled", true)
            DataFusionPlugin.class
        CommitStats commitStats = shardStats.getCommitStats();
    }
        assertEquals("1", actual.get(IndexMetadata.SETTING_NUMBER_OF_SHARDS));
        client().admin()
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
        );
                    .putNull(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey())
        assertEquals(1, refreshResponse.getSuccessfulShards());
            .clear()
import java.util.Arrays;
            .prepareCreate(indexName)
            .setDocs(true)
            assertEquals(RestStatus.CREATED, indexResponse.status());
        assertEquals(RestStatus.OK, client().admin().indices().prepareRefresh(indexName).get().getStatus());
        ensureGreen(indexName);
        String indexName = "test-composite-cluster-default";
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
            .get();
        assertEquals(1, refreshResponse.getTotalShards());
        ensureGreen(INDEX_NAME);
        assertEquals(RestStatus.OK, client().admin().indices().prepareFlush(indexName).get().getStatus());
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.test.OpenSearchIntegTestCase;
            .get();
                .setIndex(indexName)
            .put("index.pluggable.dataformat", "composite")
        }
            .indices()
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(indexName).get();
        CreateIndexResponse response = client().admin()
        ensureGreen(indexName);
            .get();
import org.opensearch.core.rest.RestStatus;
        CommitStats commitStats = shardStats.getCommitStats();
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")
            .setStore(true)
            .prepareUpdateSettings()
        // Verify commit stats contain a catalog snapshot
            ParquetOnlyDataFormatPlugin.class,
        Settings actual = settingsResponse.getIndexToSettings().get(indexName);
        client().admin()
                Settings.builder()
        ensureGreen(INDEX_NAME);
            .get();
import java.util.Set;
    }
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
        CommitStats commitStats = shardStats.getCommitStats();
    public void testCreateCompositeParquetIndex() throws IOException {
            .setTransientSettings(
            )
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
            .setSettings(indexSettings)
        // Flush
                Settings.builder()
 */
        // Refresh
                    .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "lucene")
        Settings indexSettings = Settings.builder()
                    .putNull(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey())
import org.opensearch.action.index.IndexResponse;
            CompositeDataFormatPlugin.class,
 * compatible open source license.
        ensureGreen(indexName);
        }
    private static final String INDEX_NAME = "test-composite-parquet";
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")
        for (int i = 0; i < 10; i++) {
            ArrowBasePlugin.class,
        assertEquals(1, refreshResponse.getTotalShards());
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
            .build();
        for (int i = 0; i < 10; i++) {
            .setMapping(
        assertNotNull(commitStats);
        for (org.opensearch.index.engine.exec.Segment segment : snapshot.getSegments()) {
        String indexName = "test-composite-parquet-lucene";
        ensureGreen(indexName);
                "field_number",
            .get();
            .prepareStats(INDEX_NAME)
            IndexResponse indexResponse = client().prepareIndex()
            Function.identity()
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
 *   -Dsandbox.enabled=true
    protected Settings nodeSettings(int nodeOrdinal) {
        ensureGreen(indexName);
            .prepareUpdateSettings()
            .setSettings(indexSettings)
