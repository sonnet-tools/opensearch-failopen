        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
 */
        Settings actual = settingsResponse.getIndexToSettings().get(indexName);
        ensureGreen(indexName);
import java.util.Arrays;
        // framework's ingest pool, so the framework plugin must be installed.  
        ensureGreen(indexName);
        ensureGreen(indexName);  
        client().admin()
        assertEquals(1, refreshResponse.getSuccessfulShards());
        assertTrue(commitStats.getUserData().containsKey(CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY));
            ParquetOnlyDataFormatPlugin.class,  
            .setSettings(indexSettings)  
 * Integration test that validates a composite index with parquet as the primary data format
        assertEquals(1, refreshResponse.getTotalShards());
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")  
    }
            .put("index.pluggable.dataformat", "composite")
            .setIndexing(true)
        Settings indexSettings = Settings.builder()  
            .build();  
 * this file be licensed under the Apache-2.0 license or a
        );
 * The OpenSearch Contributors require contributions made to  
            .get();  
            )  
                "type=integer"
            .prepareUpdateSettings()
            .setStore(true)  
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
 * can be created and its settings are correctly persisted.
    }
        assertEquals(1, flushResponse.getSuccessfulShards());  
        assertEquals("true", actual.get("index.pluggable.dataformat.enabled"));
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertNotNull(commitStats.getUserData());  
        return Arrays.asList(
        assertEquals(0, flushResponse.getShardFailures().length);
        assertEquals(RestStatus.OK, client().admin().indices().prepareRefresh(indexName).get().getStatus());
        assertEquals(0, refreshResponse.getShardFailures().length);
            .setDocs(true)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            assertEquals(RestStatus.CREATED, indexResponse.status());
        assertEquals(1, flushResponse.getTotalShards());
        CommitStats commitStats = shardStats.getCommitStats();  
        CreateIndexResponse response = client().admin()
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            .setStore(true)
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .setRefresh(true)  
    @Override  
                    .putNull(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey())
        for (int i = 0; i < 10; i++) {
                .get();  
            .put("index.pluggable.dataformat.enabled", true)
        CommitStats commitStats = shardStats.getCommitStats();
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));  
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
    public void testCreateCompositeParquetIndex() throws IOException {  
/*  
            assertEquals(RestStatus.CREATED, indexResponse.status());
        client().admin()  
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
        CreateIndexResponse response = client().admin()  
        IndicesStatsResponse statsResponse = client().admin()
        assertNotNull(commitStats);
        String indexName = "test-composite-parquet-lucene";
            .setDocs(true)
        }
    public void testCompositeIndexRequestOverrideBeatsClusterDefault() throws IOException {  
        );
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", 10)
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
            .get();
        CreateIndexResponse response = client().admin()
            .setIndexing(true)
            .get();  
        assertEquals(RestStatus.OK, client().admin().indices().prepareRefresh(indexName).get().getStatus());
            IndexResponse indexResponse = client().prepareIndex()  
            .build();
            .putList("index.composite.secondary_data_formats")
            .indices()
    }
                    .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "lucene")
        assertEquals(0, flushResponse.getShardFailures().length);
        // Verify commit stats contain a catalog snapshot
                .get();  
        Settings indexSettings = Settings.builder()
            .cluster()
            )
        // Deserialize the catalog snapshot and verify it contains BOTH parquet AND lucene data formats
 *  
                Settings.builder()
            Function.identity()
 * ./gradlew :sandbox:plugins:composite-engine:test \
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .setIndex(INDEX_NAME)  
            .indices()  
        for (int i = 0; i < 10; i++) {
            assertEquals(RestStatus.CREATED, indexResponse.status());  
            .cluster()
                "field_text",  
        return Settings.builder()  
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
            .build();
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
        Settings indexSettings = Settings.builder()
            .putList("index.composite.secondary_data_formats", "lucene")  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                    .putNull(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey())
            .put("index.pluggable.dataformat.enabled", true)  
            assertEquals(RestStatus.CREATED, indexResponse.status());
            .put("index.composite.primary_data_format", "parquet")  
            .build();
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(INDEX_NAME).get();  
import java.io.IOException;  
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),  
        CommitStats commitStats = shardStats.getCommitStats();
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),  
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),  
            .setSettings(indexSettings)
/**  
        for (int i = 0; i < 10; i++) {
        assertEquals("1", actual.get(IndexMetadata.SETTING_NUMBER_OF_SHARDS));
            .setTransientSettings(
            .putList("index.composite.secondary_data_formats")
import java.util.Collection;
        ensureGreen(indexName);
            .put(super.nodeSettings(nodeOrdinal))
            Function.identity()
        ensureGreen(INDEX_NAME);  
                .setIndex(indexName)
    public void testCompositeIndexUsesClusterDefaultFormatsWhenOverridesAbsent() throws IOException {  
                    .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "lucene")  
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).get();
            IndexResponse indexResponse = client().prepareIndex()
package org.opensearch.composite;
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];  
    }
            .prepareCreate(indexName)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
        Settings actual = settingsResponse.getIndexToSettings().get(indexName);
        );
        // Flush  
            .prepareStats(indexName)  
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(indexName).get();
            .get();
            .get();
                .setIndex(indexName)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
            )
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));  
import org.opensearch.common.util.FeatureFlags;  
            .setSettings(indexSettings)
 * SPDX-License-Identifier: Apache-2.0
                "type=text,index=false,store=true",
        String indexName = "test-composite-cluster-default";
            .clear()
            .prepareCreate(indexName)
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")
        assertEquals(1, refreshResponse.getTotalShards());
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
            Function.identity()
            .setRefresh(true)  
        assertNotNull(commitStats);
        IndicesStatsResponse statsResponse = client().admin()
            )
            .indices()
                .get();  
            .setIndexing(true)
import org.opensearch.common.settings.Settings;
            .get();  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
            .setStore(true)
            .prepareUpdateSettings()
    @Override
            .prepareCreate(indexName)  
            .get();  
            .setIndexing(true)  
        );  
        IndicesStatsResponse statsResponse = client().admin()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
}
 * compatible open source license.
            .prepareUpdateSettings()  
    private static final String INDEX_NAME = "test-composite-parquet";
        assertTrue(actual.getAsList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()).isEmpty());  
        ensureGreen(indexName);
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
            assertTrue("Each segment should have lucene files", segment.dfGroupedSearchableFiles().containsKey("lucene"));  
import org.opensearch.be.lucene.LucenePlugin;  
            .put("index.pluggable.dataformat", "composite")
            .setDocs(true)
            .indices()  
            .indices()
        }
            .setTransientSettings(
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
            .put("index.composite.primary_data_format", "parquet")
        ensureGreen(INDEX_NAME);  
                    .putNull(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey())  
 *   -Dsandbox.enabled=true
            .put("index.pluggable.dataformat.enabled", true)
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());  
            IndexResponse indexResponse = client().prepareIndex()  
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
            .setRefresh(true)
            .setDocs(true)
import org.opensearch.cluster.metadata.IndexMetadata;
            .clear()
            .cluster()
        assertEquals("parquet", actual.get(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));
import java.util.Set;  
            ArrowBasePlugin.class,
            .prepareCreate(INDEX_NAME)  
            assertTrue("Each segment should have parquet files", segment.dfGroupedSearchableFiles().containsKey("parquet"));
 *
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
        assertTrue("Index creation should be acknowledged", response.isAcknowledged());
        assertEquals("lucene", actual.getAsList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey()).get(0));  
public class CompositeParquetIndexIT extends OpenSearchIntegTestCase {
            .setRefresh(true)  
        );
import org.opensearch.action.index.IndexResponse;  
            .get();  
        // ParquetDataFormatPlugin sources its allocator from the unified native-allocator
            .setMapping("field_text", "type=text,index=false", "field_keyword", "type=keyword,index=false", "field_number", "type=integer")
        ensureGreen(indexName);
        // Refresh  
            .put("index.pluggable.dataformat", "composite")
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals(0, refreshResponse.getShardFailures().length);  
                    .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "parquet")  
        client().admin()
        assertEquals(1, flushResponse.getSuccessfulShards());  
    protected Settings nodeSettings(int nodeOrdinal) {
                "type=keyword,index=false",  
            .prepareUpdateSettings()  
import org.opensearch.index.engine.CommitStats;  
            .cluster()
        for (org.opensearch.index.engine.exec.Segment segment : snapshot.getSegments()) {
                "field_keyword",
        IndicesStatsResponse statsResponse = client().admin()
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
            .get();  
                Settings.builder()
        ensureGreen(indexName);
        // Index documents with text, keyword, and integer fields
        CommitStats commitStats = shardStats.getCommitStats();
                .get();
            .prepareStats(indexName)  
            .get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings actual = settingsResponse.getIndexToSettings().get(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
            .indices()
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertEquals(1, flushResponse.getTotalShards());
    }
                Settings.builder()
            .indices()
        assertNotNull(commitStats.getUserData());
            .setMapping(
        assertEquals("parquet", actual.get("index.composite.primary_data_format"));
        DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(  
import java.util.function.Function;
            Function.identity()
            .put("index.pluggable.dataformat.enabled", true)
            .setTransientSettings(  
        }
        assertTrue(commitStats.getUserData().containsKey(CatalogSnapshot.LAST_COMPOSITE_WRITER_GEN_KEY));
            CompositeDataFormatPlugin.class,
            .clear()
        CreateIndexResponse response = client().admin()
        client().admin()  
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());  
 * Requires JDK 25 and sandbox enabled. Run with:
        String indexName = "test-composite-request-override";
    public void testCompositeParquetWithLuceneSecondary() throws IOException {  
        }
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());
                    .putNull(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey())  
        // Verify segment count and that each segment has files for both formats
        assertEquals(RestStatus.OK, flushResponse.getStatus());
            .indices()
        assertEquals(RestStatus.OK, flushResponse.getStatus());
 *   --tests "*.CompositeParquetIndexIT" \  
        assertEquals(1, refreshResponse.getSuccessfulShards());  
            IndexResponse indexResponse = client().prepareIndex()  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(indexName).get();  
                .setIndex(indexName)
        Settings indexSettings = Settings.builder()
        ensureGreen(INDEX_NAME);
        for (int i = 0; i < 10; i++) {
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
        ShardStats shardStats = statsResponse.getIndex(INDEX_NAME).getShards()[0];
import org.opensearch.action.admin.indices.stats.ShardStats;
            .setTransientSettings(  
            .put("index.pluggable.dataformat", "composite")
        assertEquals(RestStatus.OK, client().admin().indices().prepareFlush(indexName).get().getStatus());
import org.opensearch.test.OpenSearchIntegTestCase;
            LucenePlugin.class,
            .get();
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());  
        assertEquals(RestStatus.OK, client().admin().indices().prepareFlush(indexName).get().getStatus());
        FlushResponse flushResponse = client().admin().indices().prepareFlush(indexName).get();
            )
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .setSettings(indexSettings)
            .put("index.composite.primary_data_format", "parquet")  
        assertEquals(10, shardStats.getStats().indexing.getTotal().getIndexCount());
import org.opensearch.core.rest.RestStatus;
            .build();  
        ensureGreen(indexName);
            .prepareStats(indexName)
        assertEquals("0", actual.get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));  
                    .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
                Settings.builder()
            .setStore(true)
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", randomInt(100))
            .get();
        assertFalse("Snapshot should have segments", snapshot.getSegments().isEmpty());  
import org.opensearch.action.admin.indices.flush.FlushResponse;
            .prepareStats(INDEX_NAME)  
 */  
                "field_number",
        assertEquals("parquet", actual.get(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey()));
        assertNotNull(commitStats);
            .clear()
import org.opensearch.plugins.Plugin;  
        assertNotNull(commitStats);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            DataFusionPlugin.class  
        }
        assertEquals(RestStatus.OK, refreshResponse.getStatus());  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(indexName).get();  
