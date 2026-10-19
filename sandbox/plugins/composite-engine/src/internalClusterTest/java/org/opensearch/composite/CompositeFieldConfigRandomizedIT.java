import org.opensearch.cluster.metadata.IndexMetadata;
            assertFalse(fieldName + " with index=false should NOT be in lucene", luceneFields.contains(fieldName));  
            assertTrue(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            + "  }\n"  
            + ", \"doc_values\": true },\n"  
        // Keyword fields: present in lucene only if indexed  
                field + " should be present in parquet with non-null values",
            .prepareCreate(indexName)
 * compatible open source license.
                        "kw2_val_" + i,  
import java.util.Map;  
            + "    \"f_match_only_text\": { \"type\": \"match_only_text\" },\n"  
import org.opensearch.core.xcontent.XContentParser;
                    }
        // so it can be indexed on a pluggable data format index.  
                RestStatus.CREATED,  
        // Verify doc count
        client().admin().indices().prepareFlush(indexName).get();  
        assertTrue(response.isAcknowledged());  
        internalCluster().startDataOnlyNode();  
            "Random config: f_keyword_1.index={}, f_keyword_2.index={}, f_keyword_3.index={}, "  
import org.opensearch.common.xcontent.json.JsonXContent;  
import java.io.IOException;  
import org.opensearch.core.xcontent.DeprecationHandler;
        }
            + "}";
                        "f_match_only_text",
 * The OpenSearch Contributors require contributions made to  
            }  
            String finalField = field;  
    }
                        "kw1_val_" + i,
            + "    \"f_text_1\": { \"type\": \"text\" },\n"
        }
            + kw1Indexed
                if (wfs != null) {
        // Index 5 documents with values for all fields  
        } else {
                        "f_text_2",
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
                        (long) (i * 100),
import java.util.Set;
import org.apache.lucene.index.LeafReaderContext;  
 *
        // Randomly decide index=true/false for keyword fields — keyword keeps FULL_TEXT_SEARCH,
            assertTrue(field + " should be present in parquet", parquetRows.stream().anyMatch(r -> r.containsKey(finalField)));  
            assertTrue(fieldName + " with index=true should be in lucene", luceneFields.contains(fieldName));
        // Verify doc count = 5
    // Private helpers
        IndexShard shard = getPrimaryShard(indexName);  
            + "    \"f_keyword_1\": { \"type\": \"keyword\", \"index\": "
            .indices()
        logger.info(
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
            .setSettings(dfaSettings())  
                    .get()
     * have these fields (no FULL_TEXT_SEARCH requested).
/**
import org.opensearch.index.shard.IndexShard;
 * this file be licensed under the Apache-2.0 license or a
        boolean kw3Indexed = randomBoolean();  
        // therefore always index=false (columnar/doc-values only). Text fields always need index=true.
                        "f_text_1",  
import org.opensearch.common.SuppressForbidden;  
            assertEquals(
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
     * have index=true or index=false. Verifies that:
    private List<Map<String, Object>> readAllParquetRows(Path parquetDir, IndexShard shard) throws IOException {
        // keyword and numeric fields always stored in parquet (COLUMNAR_STORAGE via doc_values)
        assertFalse("col_keyword should NOT be in lucene (index=false)", luceneFields.contains("col_keyword"));
            + kw3Indexed
            + ", \"doc_values\": true },\n"  
            kw3Indexed
        // Verify lucene fields  
import org.apache.lucene.index.FieldInfo;
        }
                        "f_long",  
        for (int i = 1; i <= 5; i++) {
        // Numeric fields cannot request POINT_RANGE on a pluggable data format index — neither the
    @Override  
        );  
     * Verifies that parquet stores the data (COLUMNAR_STORAGE) while lucene does not  
        assertDocCount(indexName, 5);
 */
    }  
            .putList("index.composite.secondary_data_formats", "lucene")  
                    .setSource("col_keyword", "value_" + i, "col_long", (long) (i * 10), "col_double", i * 2.5)
     * Tests keyword and numeric fields with index=false, doc_values=true (columnar-only).
    }
        assertFalse("f_long with index=false should NOT be in lucene", luceneFields.contains("f_long"));  
                client().prepareIndex(indexName)
    // ══════════════════════════════════════════════════════════════════════  
    }
                NamedXContentRegistry.EMPTY,
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));
                    .status()
        assertDocCount(indexName, 5);  
     */
import java.nio.file.Files;
        boolean kw1Indexed = randomBoolean();
    }  
        assertFieldInLucene(luceneFields, "f_keyword_2", kw2Indexed);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
    /**
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            + "    \"col_double\": { \"type\": \"double\", \"index\": false, \"doc_values\": true }\n"
            + "    \"f_double\": { \"type\": \"double\", \"index\": false, \"doc_values\": true }\n"
    }
                        "text one content " + i,
        assertTrue("__row_id__ should always be in lucene", luceneFields.contains("__row_id__"));
    // ══════════════════════════════════════════════════════════════════════
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                    .get()  
        assertTrue("f_text_1 should be in lucene", luceneFields.contains("f_text_1"));
            .build();
                parquetRows.stream().allMatch(r -> r.containsKey(finalField) && r.get(finalField) != null)  
                }
                    .setSource(
        CreateIndexResponse response = client().admin()  
            + "}";
        // __row_id__ should still be present  
                    for (String file : wfs.files()) {
            + "    \"f_long\": { \"type\": \"long\", \"index\": false, \"doc_values\": true },\n"
 * Verifies that fields with various index/doc_values combinations are correctly  
        client().admin().indices().prepareRefresh(indexName).get();
            + "    \"f_keyword_3\": { \"type\": \"keyword\", \"index\": "
    public void testColumnarOnlyFieldsIndexAndVerify() throws Exception {  
            for (LeafReaderContext ctx : reader.leaves()) {
            )
        for (String field : List.of("col_keyword", "col_long", "col_double")) {
        return allRows;  
                client().prepareIndex(indexName)
        assertFalse("col_double should NOT be in lucene (index=false)", luceneFields.contains("col_double"));
            String finalField = field;
        assertTrue("f_match_only_text should be in lucene", luceneFields.contains("f_match_only_text"));
        startCluster();
        // Verify parquet has columnar fields (keyword + numeric always have doc_values)
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();
        Set<String> allFields = new HashSet<>();  
    private void assertFieldInLucene(Set<String> luceneFields, String fieldName, boolean shouldBePresent) {
            assertTrue(
        boolean kw2Indexed = randomBoolean();
        // parquet primary nor the lucene secondary backs it — so index=true is rejected. They are  
            assertEquals(
        }
    public void testRandomizedFieldConfigIndexingAndVerification() throws Exception {
                    .status()  
            .prepareCreate(indexName)
        client().admin().indices().prepareRefresh(indexName).get();
import org.apache.lucene.store.Directory;
    private void startCluster() {
import org.opensearch.common.concurrent.GatedCloseable;
                field + " should be in parquet (COLUMNAR_STORAGE satisfied)",
            );
import org.opensearch.index.engine.exec.WriterFileSet;  
        // Numeric fields are index=false, so they must NOT appear in lucene FieldInfos
            + "    \"col_long\": { \"type\": \"long\", \"index\": false, \"doc_values\": true },\n"
        assertFieldInLucene(luceneFields, "f_keyword_3", kw3Indexed);  
        ) {  
     * - Only indexed fields appear in lucene FieldInfos
package org.opensearch.composite;
        ensureGreen(indexName);
        IndexShard shard = getPrimaryShard(indexName);
import org.opensearch.parquet.bridge.RustBridge;  
import org.apache.lucene.index.DirectoryReader;
                }  
            + "    \"f_text_2\": { \"type\": \"text\" },\n"
}
    }
        assertFalse("f_double with index=false should NOT be in lucene", luceneFields.contains("f_double"));
        // __row_id__ is always present
            + kw2Indexed
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
                RestStatus.CREATED,  
            kw2Indexed,
    @SuppressForbidden(reason = "JSON parsing for test verification")
        }
            + "    \"col_keyword\": { \"type\": \"keyword\", \"index\": false, \"doc_values\": true },\n"  
import org.opensearch.common.settings.Settings;
        if (shouldBePresent) {  
    private Set<String> getLuceneFields(Path luceneDir) throws IOException {
        assertEquals(expectedCount, stats.getIndex(indexName).getPrimaries().getDocs().getCount());  
            + "    \"f_keyword_2\": { \"type\": \"keyword\", \"index\": "
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
                        i * 1.5  
 * Randomized integration tests for composite field configurations.
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
        assertFalse("col_long should NOT be in lucene (index=false)", luceneFields.contains("col_long"));  
        // Verify parquet has all columnar fields with data
        for (String field : List.of("f_text_1", "f_text_2")) {
            .setMapping(mapping)
        client().admin().indices().prepareFlush(indexName).get();
        Set<String> luceneFields = getLuceneFields(luceneDir);
                        "f_double",
        assertTrue("f_text_2 should be in lucene", luceneFields.contains("f_text_2"));  
        }
        Path luceneDir = shard.shardPath().resolveIndex();
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {  
     * - All fields appear in parquet regardless of index setting  
            .setSettings(dfaSettings())  
                        "f_keyword_2",
            );
    private Settings dfaSettings() {
import java.util.HashSet;
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
            + ", \"doc_values\": true },\n"  
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
        // Text fields with index=true should be in lucene
        String mapping = "{\n"
        try (  
        String indexName = "test-columnar-only";
     * - __row_id__ is always present in lucene
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        }
    }
        String mapping = "{\n"
        Set<String> luceneFields = getLuceneFields(luceneDir);  
                        "f_keyword_1",  
                        "kw3_val_" + i,
import org.apache.lucene.store.NIOFSDirectory;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    @SuppressWarnings("unchecked")  
    }
        startCluster();
            .get();
public class CompositeFieldConfigRandomizedIT extends AbstractCompositeEngineIT {
            .get();
                + "f_long.index=false, f_double.index=false, f_text_1.index=true, f_text_2.index=true, "
            String finalField = field;  
        // Index 5 documents  
                    allFields.add(fi.name);
        // Verify lucene does NOT have these fields (no FULL_TEXT_SEARCH requested)
                        "text two content " + i,  
        ensureGreen(indexName);
import java.util.ArrayList;  
            .put("index.pluggable.dataformat.enabled", true)  
        String indexName = "test-randomized-field-config";  
     */  
import java.nio.file.Path;
                        "f_keyword_3",
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
            );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
            + "  }\n"  
        assertTrue(response.isAcknowledged());  
            + "  \"properties\": {\n"  
    private void assertDocCount(String indexName, long expectedCount) {
                        Path filePath = parquetDir.resolve(file);  
        Path luceneDir = shard.shardPath().resolveIndex();
        }
    }  
import org.opensearch.core.rest.RestStatus;
            + "  \"properties\": {\n"
import java.util.List;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        for (String field : List.of("f_keyword_1", "f_keyword_2", "f_keyword_3", "f_long", "f_double")) {
        assertFieldInLucene(luceneFields, "f_keyword_1", kw1Indexed);
    @SuppressForbidden(reason = "JSON parsing for test verification")  
/*  
        assertTrue("__row_id__ should always be in lucene", luceneFields.contains("__row_id__"));
import org.opensearch.index.engine.exec.Segment;
        CreateIndexResponse response = client().admin()  
        }  
     * Tests randomized field configurations where keyword and numeric fields randomly
            .indices()
    /**  
        return allFields;
import org.opensearch.test.OpenSearchIntegTestCase;
 */  
        // text/match_only_text are stored in parquet via STORED_FIELDS but may appear differently  
        internalCluster().startClusterManagerOnlyNode();
        for (int i = 1; i <= 5; i++) {
        assertEquals(5, parquetRows.size());  
            );
                json
            kw1Indexed,  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        assertEquals(5, parquetRows.size());
                + "f_match_only_text.index=true",
                        allRows.addAll(parseJsonRows(RustBridge.readAsJson(filePath.toString())));
 * stored in parquet (columnar) and lucene (inverted index) based on their capabilities.
            .put("index.composite.primary_data_format", "parquet")
import java.util.stream.Collectors;
 * SPDX-License-Identifier: Apache-2.0
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");  
                    )
                        "match only " + i,
                parquetRows.stream().allMatch(r -> r.containsKey(finalField) && r.get(finalField) != null)  
    protected Settings nodeSettings(int nodeOrdinal) {
            .setMapping(mapping)
        List<Map<String, Object>> allRows = new ArrayList<>();  
            for (Segment segment : snapshot.get().getSegments()) {
        return Settings.builder()  
            .put("index.pluggable.dataformat", "composite")
