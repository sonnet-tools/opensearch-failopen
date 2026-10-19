 * The OpenSearch Contributors require contributions made to  
     */
        int maxRows = 5;  
    private void assertSettingValue(String key, String expected) {  
        assertTotalParquetRows(INDEX_NAME, totalDocs);
     */
        refreshIndex(INDEX_NAME);
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        long maxBytes = new ByteSizeValue(1, ByteSizeUnit.MB).getBytes();
    // ── Tests ──────────────────────────────────────────────────────────────
    }
    public void testRowGroupMaxRowsOfOneProducesValidFile() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
     */  
        long totalRowGroups = 0;
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
            assertNotNull("Segment should have parquet files", wfs);
    private void assertTotalParquetRows(String indexName, int expectedTotal) throws IOException {  
            .put("index.composite.primary_data_format", "parquet")
    }
        ensureGreen(indexName);  
import org.opensearch.core.common.unit.ByteSizeUnit;
        int totalDocs = 10;
            .put("index.pluggable.dataformat", "composite")
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull("Segment should have parquet files", wfs);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings.Builder builder = Settings.builder()  
    /**  
            .put("index.pluggable.dataformat.enabled", true)  
import java.nio.file.Files;  
import java.nio.file.Path;
                Path filePath = parquetDir.resolve(file);  
    }
        indexDocs(INDEX_NAME, totalDocs, 0);
    /**
 *
                ParquetFileMetadata meta = RustBridge.getFileMetadata(filePath.toString());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * Verifies that {@code index.parquet.row_group_max_rows} is persisted in index
 * {@code index.parquet.row_group_max_bytes} settings are accepted, persisted, and
import org.opensearch.parquet.bridge.ParquetFileMetadata;
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
        assertTotalRowGroups(INDEX_NAME, totalDocs);  
import org.opensearch.common.settings.Settings;  
 * honoured by the native Parquet writer.  
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), 1).build());
    private void createCompositeIndex(String indexName, Settings extraSettings) {
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), String.valueOf(maxRows));
        flushIndex(INDEX_NAME);
     * Verifies that {@code index.parquet.row_group_max_bytes} is persisted in index
import org.opensearch.core.common.unit.ByteSizeValue;
    private void assertTotalRowGroups(String indexName, int expectedTotal) throws IOException {  
            .putList("index.composite.secondary_data_formats", "lucene")  
     * settings and that the index operates correctly with a small byte limit.
        int maxRows = 3;  
        refreshIndex(INDEX_NAME);
                Path filePath = parquetDir.resolve(file);  
        indexDocs(INDEX_NAME, totalDocs, 0);  
            .prepareCreate(indexName)
            .indices()
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), maxRows).build());  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        int totalDocs = 20;  
        long maxBytes = new ByteSizeValue(512, ByteSizeUnit.KB).getBytes();
    /**  
import java.io.IOException;
/*  
            Settings.builder()  
                .put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), maxRows)
            .setMapping("name", "type=keyword", "value", "type=integer")
        int totalDocs = 5;  
        }
        }
        flushIndex(INDEX_NAME);  
 */  
    }
        for (Segment segment : snapshot.getSegments()) {
import org.opensearch.index.engine.exec.WriterFileSet;
        refreshIndex(INDEX_NAME);
package org.opensearch.composite;
        long totalRows = 0;
        assertEquals("Total rows across all parquet files should match indexed docs", expectedTotal, totalRows);  
        indexDocs(INDEX_NAME, totalDocs, 0);  
import org.opensearch.parquet.ParquetSettings;  
        assertTotalParquetRows(INDEX_NAME, totalDocs);
    private static final String INDEX_NAME = "test-row-group-settings";
     * Verifies that with {@code row_group_max_rows=1} and 5 docs indexed,
     * each parquet file has exactly 1 row group per row — i.e. total row groups == total docs.  
 */
/**  
public class CompositeParquetRowGroupSettingsIT extends AbstractCompositeEngineIT {  
        indexDocs(INDEX_NAME, totalDocs, 0);
                .put(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b")
                ParquetFileMetadata meta = RustBridge.getFileMetadata(filePath.toString());
    }
            for (String file : wfs.files()) {
    }
 * compatible open source license.
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
            .put(extraSettings);
        flushIndex(INDEX_NAME);  
            .setSettings(builder)  
import org.opensearch.index.engine.exec.Segment;  
        flushIndex(INDEX_NAME);
                totalRowGroups += meta.numRowGroups();  
            INDEX_NAME,
     */
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b").build());
        int totalDocs = 15;
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), String.valueOf(maxRows));  
        refreshIndex(INDEX_NAME);
            .get();
    public void testRowGroupMaxBytesSettingIsApplied() throws IOException {
    public void testRowGroupMaxRowsSettingIsApplied() throws IOException {
 * Integration tests verifying that {@code index.parquet.row_group_max_rows} and
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
        assertEquals("Total row groups should equal total docs when max_rows=1", expectedTotal, totalRowGroups);  
     * settings and that the written parquet file contains exactly the expected number
        client().admin()  
        assertTotalParquetRows(INDEX_NAME, totalDocs);
    }
            }
        Settings actual = resp.getIndexToSettings().get(INDEX_NAME);
        for (Segment segment : snapshot.getSegments()) {
        assertTotalParquetRows(INDEX_NAME, totalDocs);  
    // ── Helpers ────────────────────────────────────────────────────────────  
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
}
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertEquals("Setting " + key + " should be persisted", expected, actual.get(key));  
                totalRows += meta.numRows();  
        GetSettingsResponse resp = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b");
    public void testRowGroupMaxRowsAndBytesSetTogether() throws IOException {
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
import org.opensearch.test.OpenSearchIntegTestCase;  
     * functions correctly with both limits active.  
            }
import org.opensearch.parquet.bridge.RustBridge;
        createCompositeIndex(
                .build()  
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b");
            for (String file : wfs.files()) {
    }
     * Verifies that both row group settings can be set together and the index
        // All rows must be present across the written parquet files
     * of rows (i.e. the writer did not silently discard data).  
    /**
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
import org.opensearch.cluster.metadata.IndexMetadata;
