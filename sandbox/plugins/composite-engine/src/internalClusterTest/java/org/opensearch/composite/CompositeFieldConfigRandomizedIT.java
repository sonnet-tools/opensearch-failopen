                        "kw1_val_" + i,
        // Verify parquet has all columnar fields with data
    public void testColumnarOnlyFieldsIndexAndVerify() throws Exception {
        assertTrue(response.isAcknowledged());
import java.util.ArrayList;
                    .setSource("col_keyword", "value_" + i, "col_long", (long) (i * 10), "col_double", i * 2.5)
        }
    }
        boolean kw2Indexed = randomBoolean();
        String mapping = "{\n"
 */
        // Verify parquet has columnar fields (keyword + numeric always have doc_values)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertFieldInLucene(luceneFields, "f_keyword_1", kw1Indexed);
        boolean kw1Indexed = randomBoolean();
import java.util.List;
        // Verify lucene does NOT have these fields (no FULL_TEXT_SEARCH requested)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .setSettings(dfaSettings())
            + "}";
     * - All fields appear in parquet regardless of index setting
                }
import org.opensearch.common.SuppressForbidden;
        client().admin().indices().prepareRefresh(indexName).get();
 * compatible open source license.
import org.apache.lucene.store.Directory;
        Set<String> luceneFields = getLuceneFields(luceneDir);
            .get();
 * Randomized integration tests for composite field configurations.
        // Index 5 documents
            String finalField = field;
    }
            .putList("index.composite.secondary_data_formats", "lucene")
            + "    \"f_match_only_text\": { \"type\": \"match_only_text\" },\n"
}
        String mapping = "{\n"
import java.nio.file.Path;
            .prepareCreate(indexName)
        return allRows;
                RestStatus.CREATED,
        boolean kw3Indexed = randomBoolean();
        assertFalse("f_double with index=false should NOT be in lucene", luceneFields.contains("f_double"));
            .setSettings(dfaSettings())
    protected Settings nodeSettings(int nodeOrdinal) {
                        (long) (i * 100),
    @SuppressForbidden(reason = "JSON parsing for test verification")
    @Override
        // text/match_only_text are stored in parquet via STORED_FIELDS but may appear differently
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
        // __row_id__ is always present
            + kw1Indexed
        Set<String> allFields = new HashSet<>();
        String indexName = "test-columnar-only";
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            )
            .indices()
            for (LeafReaderContext ctx : reader.leaves()) {
            .get();
import java.io.IOException;
            kw2Indexed,
                    .get()
        CreateIndexResponse response = client().admin()
        // Index 5 documents with values for all fields
        ensureGreen(indexName);
                if (wfs != null) {
 * Verifies that fields with various index/doc_values combinations are correctly
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
        assertFalse("col_long should NOT be in lucene (index=false)", luceneFields.contains("col_long"));
            String finalField = field;
        }
            }
 * this file be licensed under the Apache-2.0 license or a
    // ══════════════════════════════════════════════════════════════════════
                + "f_long.index=false, f_double.index=false, f_text_1.index=true, f_text_2.index=true, "
            "Random config: f_keyword_1.index={}, f_keyword_2.index={}, f_keyword_3.index={}, "
            );
                    .status()
        String indexName = "test-randomized-field-config";
/**
                parquetRows.stream().allMatch(r -> r.containsKey(finalField) && r.get(finalField) != null)
    private void startCluster() {
        Set<String> luceneFields = getLuceneFields(luceneDir);
        // Text fields with index=true should be in lucene
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
import org.apache.lucene.index.DirectoryReader;
                json
import org.opensearch.parquet.bridge.RustBridge;
        // so it can be indexed on a pluggable data format index.
                        "kw3_val_" + i,
import org.opensearch.common.xcontent.json.JsonXContent;
        for (String field : List.of("col_keyword", "col_long", "col_double")) {
        for (String field : List.of("f_text_1", "f_text_2")) {
    private void assertFieldInLucene(Set<String> luceneFields, String fieldName, boolean shouldBePresent) {
            assertEquals(
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
    @SuppressWarnings("unchecked")
            + "    \"f_text_2\": { \"type\": \"text\" },\n"
                        "f_text_1",
                        "text one content " + i,
     * have index=true or index=false. Verifies that:
            String finalField = field;
            .put("index.pluggable.dataformat.enabled", true)
        // therefore always index=false (columnar/doc-values only). Text fields always need index=true.
            + "    \"col_long\": { \"type\": \"long\", \"index\": false, \"doc_values\": true },\n"
 * The OpenSearch Contributors require contributions made to
                    }
            + "}";
        for (String field : List.of("f_keyword_1", "f_keyword_2", "f_keyword_3", "f_long", "f_double")) {
            );
        }
        assertTrue("f_text_2 should be in lucene", luceneFields.contains("f_text_2"));
            .indices()
                    .status()
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
            + kw2Indexed
import org.opensearch.test.OpenSearchIntegTestCase;
            }
            + "    \"f_long\": { \"type\": \"long\", \"index\": false, \"doc_values\": true },\n"
        // Numeric fields cannot request POINT_RANGE on a pluggable data format index — neither the
            + "    \"f_text_1\": { \"type\": \"text\" },\n"
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        client().admin().indices().prepareFlush(indexName).get();
            .put("index.pluggable.dataformat", "composite")
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
    // ══════════════════════════════════════════════════════════════════════
                        allRows.addAll(parseJsonRows(RustBridge.readAsJson(filePath.toString())));
        assertTrue(response.isAcknowledged());
        assertFalse("col_keyword should NOT be in lucene (index=false)", luceneFields.contains("col_keyword"));
import java.util.HashSet;
        // Keyword fields: present in lucene only if indexed
            assertTrue(
            + ", \"doc_values\": true },\n"
                        "f_long",
                        i * 1.5
        }
                    )
            .prepareCreate(indexName)
        Path luceneDir = shard.shardPath().resolveIndex();
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private Set<String> getLuceneFields(Path luceneDir) throws IOException {
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));
import org.opensearch.core.xcontent.XContentParser;
                RestStatus.CREATED,
            + "    \"col_double\": { \"type\": \"double\", \"index\": false, \"doc_values\": true }\n"
 * SPDX-License-Identifier: Apache-2.0
        }
            assertFalse(fieldName + " with index=false should NOT be in lucene", luceneFields.contains(fieldName));
            + ", \"doc_values\": true },\n"
        assertDocCount(indexName, 5);
        startCluster();
        Path luceneDir = shard.shardPath().resolveIndex();
     * Verifies that parquet stores the data (COLUMNAR_STORAGE) while lucene does not
    }
                field + " should be in parquet (COLUMNAR_STORAGE satisfied)",
        // Numeric fields are index=false, so they must NOT appear in lucene FieldInfos
        assertTrue("__row_id__ should always be in lucene", luceneFields.contains("__row_id__"));
        // Verify doc count
        }
import org.opensearch.common.concurrent.GatedCloseable;
            .setMapping(mapping)
    // Private helpers
            + "    \"f_double\": { \"type\": \"double\", \"index\": false, \"doc_values\": true }\n"
     * - __row_id__ is always present in lucene
            + "    \"f_keyword_1\": { \"type\": \"keyword\", \"index\": "
import org.opensearch.core.rest.RestStatus;
                        "match only " + i,
            + "    \"f_keyword_2\": { \"type\": \"keyword\", \"index\": "
import java.nio.file.Files;
    }
        assertFalse("col_double should NOT be in lucene (index=false)", luceneFields.contains("col_double"));
                + "f_match_only_text.index=true",
        List<Map<String, Object>> allRows = new ArrayList<>();
 */
    @SuppressForbidden(reason = "JSON parsing for test verification")
            assertEquals(
        internalCluster().startClusterManagerOnlyNode();
            .build();
            assertTrue(field + " should be present in parquet", parquetRows.stream().anyMatch(r -> r.containsKey(finalField)));
    }
        logger.info(
        } else {
    private List<Map<String, Object>> readAllParquetRows(Path parquetDir, IndexShard shard) throws IOException {
import org.opensearch.core.xcontent.DeprecationHandler;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    }
    /**
            + "  }\n"
import org.opensearch.index.engine.exec.Segment;
                    allFields.add(fi.name);
     * have these fields (no FULL_TEXT_SEARCH requested).
/*
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
        try (
            + "    \"f_keyword_3\": { \"type\": \"keyword\", \"index\": "
            + "  \"properties\": {\n"
        for (int i = 1; i <= 5; i++) {
        // Verify doc count = 5
    }
                        "f_keyword_2",
 * stored in parquet (columnar) and lucene (inverted index) based on their capabilities.
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        startCluster();
    }
import org.apache.lucene.store.NIOFSDirectory;
        // parquet primary nor the lucene secondary backs it — so index=true is rejected. They are
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            .put("index.composite.primary_data_format", "parquet")
        assertEquals(5, parquetRows.size());
                    .get()
        // Randomly decide index=true/false for keyword fields — keyword keeps FULL_TEXT_SEARCH,
        ensureGreen(indexName);
    }
                }
    private void assertDocCount(String indexName, long expectedCount) {
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
        client().admin().indices().prepareFlush(indexName).get();
import java.util.Set;
        return Settings.builder()
import org.opensearch.index.shard.IndexShard;
            );
        // __row_id__ should still be present
    public void testRandomizedFieldConfigIndexingAndVerification() throws Exception {
            + "  \"properties\": {\n"
                NamedXContentRegistry.EMPTY,
        for (int i = 1; i <= 5; i++) {
                    .setSource(
        if (shouldBePresent) {
import org.apache.lucene.index.LeafReaderContext;
        CreateIndexResponse response = client().admin()
        assertTrue("f_text_1 should be in lucene", luceneFields.contains("f_text_1"));
     */
        IndexShard shard = getPrimaryShard(indexName);
                        "kw2_val_" + i,
import org.opensearch.cluster.metadata.IndexMetadata;
    private Settings dfaSettings() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertFalse("f_long with index=false should NOT be in lucene", luceneFields.contains("f_long"));
            );
        // keyword and numeric fields always stored in parquet (COLUMNAR_STORAGE via doc_values)
import org.opensearch.index.engine.exec.WriterFileSet;
     * Tests keyword and numeric fields with index=false, doc_values=true (columnar-only).
        assertTrue("f_match_only_text should be in lucene", luceneFields.contains("f_match_only_text"));
        assertFieldInLucene(luceneFields, "f_keyword_2", kw2Indexed);
     */
     * Tests randomized field configurations where keyword and numeric fields randomly
                        "text two content " + i,
        client().admin().indices().prepareRefresh(indexName).get();
                        "f_keyword_3",
        IndexShard shard = getPrimaryShard(indexName);
            + ", \"doc_values\": true },\n"
                        "f_double",
            for (Segment segment : snapshot.get().getSegments()) {
                        Path filePath = parquetDir.resolve(file);
            kw1Indexed,
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
        ) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        }
            kw3Indexed
        assertEquals(5, parquetRows.size());
        return allFields;
        assertFieldInLucene(luceneFields, "f_keyword_3", kw3Indexed);
package org.opensearch.composite;
        // Verify lucene fields
import org.apache.lucene.index.FieldInfo;
        assertDocCount(indexName, 5);
            assertTrue(
        assertTrue("__row_id__ should always be in lucene", luceneFields.contains("__row_id__"));
                field + " should be present in parquet with non-null values",
                        "f_keyword_1",
import java.util.stream.Collectors;
     * - Only indexed fields appear in lucene FieldInfos
        internalCluster().startDataOnlyNode();
 *
import java.util.Map;
            + "  }\n"
            + "    \"col_keyword\": { \"type\": \"keyword\", \"index\": false, \"doc_values\": true },\n"
        );
            + kw3Indexed
                client().prepareIndex(indexName)
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();
            assertTrue(fieldName + " with index=true should be in lucene", luceneFields.contains(fieldName));
public class CompositeFieldConfigRandomizedIT extends AbstractCompositeEngineIT {
                    for (String file : wfs.files()) {
                        "f_text_2",
                        "f_match_only_text",
            .setMapping(mapping)
import org.opensearch.common.settings.Settings;
                client().prepareIndex(indexName)
        assertEquals(expectedCount, stats.getIndex(indexName).getPrimaries().getDocs().getCount());
    /**
        }
                parquetRows.stream().allMatch(r -> r.containsKey(finalField) && r.get(finalField) != null)
