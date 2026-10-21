            INDEX_NAME,
        // All rows must be present across the written parquet files
    }
        assertEquals("Total row groups should equal total docs when max_rows=1", expectedTotal, totalRowGroups);
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b");
        for (Segment segment : snapshot.getSegments()) {
     */
            }
                Path filePath = parquetDir.resolve(file);
    }
            .get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    // ── Tests ──────────────────────────────────────────────────────────────
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
     */
import org.opensearch.common.settings.Settings;
            .prepareCreate(indexName)
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
            assertNotNull("Segment should have parquet files", wfs);
import org.opensearch.test.OpenSearchIntegTestCase;
public class CompositeParquetRowGroupSettingsIT extends AbstractCompositeEngineIT {
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
            .put(extraSettings);
        long totalRowGroups = 0;
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b");
                totalRowGroups += meta.numRowGroups();
            .indices()
        assertEquals("Setting " + key + " should be persisted", expected, actual.get(key));
import org.opensearch.parquet.bridge.RustBridge;
     * settings and that the index operates correctly with a small byte limit.
 * Integration tests verifying that {@code index.parquet.row_group_max_rows} and
    private void assertSettingValue(String key, String expected) {
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        assertTotalParquetRows(INDEX_NAME, totalDocs);
        indexDocs(INDEX_NAME, totalDocs, 0);
import org.opensearch.core.common.unit.ByteSizeValue;
        Settings actual = resp.getIndexToSettings().get(INDEX_NAME);
    private void assertTotalRowGroups(String indexName, int expectedTotal) throws IOException {
     * Verifies that {@code index.parquet.row_group_max_rows} is persisted in index
    }
                .build()
        long totalRows = 0;
            .setMapping("name", "type=keyword", "value", "type=integer")
    private void createCompositeIndex(String indexName, Settings extraSettings) {
     * functions correctly with both limits active.
 * compatible open source license.
        assertTotalRowGroups(INDEX_NAME, totalDocs);
        Settings.Builder builder = Settings.builder()
        client().admin()
import java.io.IOException;
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), 1).build());
 */
        refreshIndex(INDEX_NAME);
/*
/**
        int maxRows = 3;
        );
import org.opensearch.index.engine.exec.WriterFileSet;
 * this file be licensed under the Apache-2.0 license or a
    }
            Settings.builder()
 */
        GetSettingsResponse resp = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
     * Verifies that with {@code row_group_max_rows=1} and 5 docs indexed,
 * honoured by the native Parquet writer.
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), String.valueOf(maxRows));
import org.opensearch.parquet.ParquetSettings;
        int maxRows = 5;
            .put("index.pluggable.dataformat", "composite")
 * {@code index.parquet.row_group_max_bytes} settings are accepted, persisted, and
        int totalDocs = 10;
        refreshIndex(INDEX_NAME);
    /**
        createCompositeIndex(
     */
    /**
        assertTotalParquetRows(INDEX_NAME, totalDocs);
    }
        for (Segment segment : snapshot.getSegments()) {
        flushIndex(INDEX_NAME);
            .put("index.composite.primary_data_format", "parquet")
        refreshIndex(INDEX_NAME);
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
import java.nio.file.Path;
                ParquetFileMetadata meta = RustBridge.getFileMetadata(filePath.toString());
 * The OpenSearch Contributors require contributions made to
     * Verifies that both row group settings can be set together and the index
    public void testRowGroupMaxBytesSettingIsApplied() throws IOException {
        assertSettingValue(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), String.valueOf(maxRows));
import org.opensearch.parquet.bridge.ParquetFileMetadata;
    public void testRowGroupMaxRowsOfOneProducesValidFile() throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        int totalDocs = 15;
package org.opensearch.composite;
        refreshIndex(INDEX_NAME);
        flushIndex(INDEX_NAME);
    // ── Helpers ────────────────────────────────────────────────────────────
            .setSettings(builder)
        assertEquals("Total rows across all parquet files should match indexed docs", expectedTotal, totalRows);
     * of rows (i.e. the writer did not silently discard data).
    /**
            .putList("index.composite.secondary_data_formats", "lucene")
     */
     * each parquet file has exactly 1 row group per row — i.e. total row groups == total docs.
        }
        indexDocs(INDEX_NAME, totalDocs, 0);
        assertTotalParquetRows(INDEX_NAME, totalDocs);
    public void testRowGroupMaxRowsSettingIsApplied() throws IOException {
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b").build());
            }
                .put(ParquetSettings.ROW_GROUP_MAX_BYTES.getKey(), maxBytes + "b")
            for (String file : wfs.files()) {
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
        assertTotalParquetRows(INDEX_NAME, totalDocs);
    private static final String INDEX_NAME = "test-row-group-settings";
    public void testRowGroupMaxRowsAndBytesSetTogether() throws IOException {
    private void assertTotalParquetRows(String indexName, int expectedTotal) throws IOException {
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
            .put("index.pluggable.dataformat.enabled", true)
                ParquetFileMetadata meta = RustBridge.getFileMetadata(filePath.toString());
     * settings and that the written parquet file contains exactly the expected number
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import java.nio.file.Files;
 *
            assertNotNull("Segment should have parquet files", wfs);
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
        indexDocs(INDEX_NAME, totalDocs, 0);
            for (String file : wfs.files()) {
                totalRows += meta.numRows();
    }
                Path filePath = parquetDir.resolve(file);
        int totalDocs = 20;
    /**
        flushIndex(INDEX_NAME);
        int totalDocs = 5;
        long maxBytes = new ByteSizeValue(1, ByteSizeUnit.MB).getBytes();
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
                .put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), maxRows)
import org.opensearch.index.engine.exec.Segment;
        indexDocs(INDEX_NAME, totalDocs, 0);
import org.opensearch.cluster.metadata.IndexMetadata;
        createCompositeIndex(INDEX_NAME, Settings.builder().put(ParquetSettings.ROW_GROUP_MAX_ROWS.getKey(), maxRows).build());
        flushIndex(INDEX_NAME);
        long maxBytes = new ByteSizeValue(512, ByteSizeUnit.KB).getBytes();
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
}
        }
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(indexName);
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
     * Verifies that {@code index.parquet.row_group_max_bytes} is persisted in index
