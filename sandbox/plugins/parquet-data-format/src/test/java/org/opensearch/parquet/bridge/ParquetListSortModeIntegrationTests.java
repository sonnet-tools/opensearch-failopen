        assertEquals("null children must be preserved", java.util.Arrays.asList(null, null), byId.get(4L));
            root.setRowCount(ids.length);
            ListVector tagsVector = (ListVector) root.getVector("tags");  
    public void testNullEmptyAndAllNullListsSortFirst() throws Exception {  
                idVector.setSafe(row, ids[row]);
import org.opensearch.Version;
        assertNull("null list must stay null", byId.get(2L));  
import org.opensearch.core.xcontent.XContentParser;
        if (order != null) {  
        List<Long> ids = writeMergeAndReadIds(sortConfig("asc", "min", "_first"), nullLikeRows());
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {  
    @SuppressWarnings("unchecked")  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        assertEquals(List.of(2L, 3L, 1L), writeMergeAndReadIds(sortConfig("desc", "min", "_last"), DISTINCT_MODE_ROWS));
        if (mode != null) {  
     * stays null, an empty list stays empty (not null), and a list of null children keeps its  
    }
import java.util.ArrayList;
     * crosses file boundaries. Distinct minimum elements give a deterministic row order, so a
            writer.initialize(INDEX_NAME, schemaExport.getSchemaAddress(), sortConfig, 0L);
            List.of("one"),            // id 1, min "one"  
     * value that detached from its row (a row-vs-value confusion in the merge) would surface as  
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
                    secondRows.add(rows.get(row));
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
                new Field("id", FieldType.nullable(new ArrowType.Int(64, true)), null),
            List.of("four"),           // id 4, min "four"  
        assertEquals(List.of(5L, 1L), ids.subList(0, 2));
        );
                NamedXContentRegistry.EMPTY,  
        allocator.close();
            String second = writeSortedFile(dir.resolve("second.parquet"), sortConfig, toLongArray(secondIds), secondRows);
        assertEquals(List.of("one"), tagsOf(merged.get(4)));
        ) {
            List<Long> secondIds = new ArrayList<>();  
import org.apache.arrow.vector.BigIntVector;
    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
                    "tags",  
    public void testExplicitMinAscending() throws Exception {
        }
import org.apache.arrow.c.Data;
    }
 * The OpenSearch Contributors require contributions made to  
    private String writeSortedFile(Path path, ParquetSortConfig sortConfig, long[] ids, List<List<String>> tags) throws Exception {  
        assertEquals(5, byId.size());
            }
                @SuppressWarnings("unchecked")  
import org.apache.arrow.vector.types.pojo.ArrowType;  
import org.apache.arrow.vector.VectorSchemaRoot;
        Data.exportSchema(allocator, schema, null, arrowSchema);  
            List.of("two", "ii", "2"), // id 2, min "2"
                json
                writer.write(data.getArrayAddress(), data.getSchemaAddress());  
import org.apache.arrow.memory.BufferAllocator;  
    }
            ArrowArray array = ArrowArray.allocateNew(allocator);  
            RustBridge.removeSettings(INDEX_NAME);  
        // Row order by id: id1 ["b","d"], id2 null, id3 [], id4 [null,null], id5 ["a","z"].
                    List.of(new Field("item", FieldType.nullable(new ArrowType.Utf8()), null))
                if (rowValues == null) {  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        List<Map<String, Object>> merged = writeMergeAndReadRows(sortConfig("asc", "min", "_last"), nullLikeRows());  
import java.util.Map;
import org.apache.arrow.vector.types.pojo.Field;
public class ParquetListSortModeIntegrationTests extends OpenSearchTestCase {
    /**
import org.opensearch.nativebridge.spi.ArrowExport;
            VarCharVector values = (VarCharVector) tagsVector.getDataVector();
        try (
        return rows.stream().map(row -> ((Number) row.get("id")).longValue()).toList();  
 */
import java.util.Set;  
    }  
/*  
                return values;
package org.opensearch.parquet.bridge;
                for (String value : rowValues) {  
        RustBridge.removeSettings(INDEX_NAME);
                )  
        List<List<String>> rows = List.of(
            .putList("index.sort.field", "tags")
        assertEquals(List.of(2L, 5L, 4L, 3L, 1L), idsOf(merged));
import org.apache.arrow.vector.types.pojo.Schema;  
import org.opensearch.test.IndexSettingsModule;
        assertEquals(List.of("b", "d"), byId.get(1L));
        }
                int childIndex = tagsVector.startNewValue(row);
    public void testDefaultDescendingUsesMax() throws Exception {
        assertEquals(List.of(1L, 3L, 2L), writeMergeAndReadIds(sortConfig(null, null, "_last"), DISTINCT_MODE_ROWS));
            Path dir = createTempDir();  
            BigIntVector idVector = (BigIntVector) root.getVector("id");
                    } else {  
            for (int row = 0; row < rows.size(); row++) {
        return file;
import org.apache.arrow.vector.types.pojo.FieldType;
    private List<Map<String, Object>> writeMergeAndReadRows(ParquetSortConfig sortConfig, List<List<String>> rows) throws Exception {
    private long[] toLongArray(List<Long> values) {
        assertEquals(List.of("three", "iii"), tagsOf(merged.get(3)));  
        String json = RustBridge.readAsJson(parquetFile);  
                } else {  
     * tags attached to the wrong id. This is the Java/CI-visible counterpart of the Rust
        );
            assertEquals(rows.size(), RustBridge.getFileMetadata(merged).numRows());  
    }
    }  
                        values.setNull(childIndex);
    }
    private List<String> tagsOf(Map<String, Object> row) {
 *
    private Schema schema;
                new Field(
        assertEquals(List.of("four"), tagsOf(merged.get(2)));
        assertEquals(List.of("two", "ii", "2"), tagsOf(merged.get(0)));  
import java.util.HashSet;  
    }  
    public void tearDown() throws Exception {  
                Map<String, Object> values = (Map<String, Object>) row;
        try {  
     * nulls. The null-like rows share a null sort key so their relative order is unspecified;
import org.apache.arrow.vector.VarCharVector;  
        assertEquals(List.of("a", "z"), byId.get(5L));  
    }
    private List<Map<String, Object>> readRows(String parquetFile) throws Exception {
            )
    }
     */  
            List<Long> firstIds = new ArrayList<>();
        schema = new Schema(
                    tagsVector.setNull(row);
    /**  
import org.apache.arrow.c.ArrowArray;  
        super.setUp();
    private ArrowExport exportSchema() {
            }  
    private static final String INDEX_NAME = "list-sort-mode-it";  
    }
            List.of("three", "iii"),   // id 3, min "iii"
    }
            for (int row = 0; row < ids.length; row++) {  
        try (ArrowExport schemaExport = exportSchema()) {
            List<List<String>> firstRows = new ArrayList<>();
    public void testSortedMergePreservesListValuesPerRow() throws Exception {
        super.tearDown();  
        for (Map<String, Object> row : merged) {  
    public void testMergePreservesNullEmptyAndNullChildrenExactly() throws Exception {
        assertEquals("empty list must stay empty and distinct from null", List.of(), byId.get(3L));
    private ParquetSortConfig sortConfig(String order, String mode, String missing) {
    public void testDefaultAscendingUsesMin() throws Exception {  
        assertEquals(Set.of(2L, 3L, 4L), new HashSet<>(ids.subList(2, 5)));  
        assertEquals(Set.of(2L, 3L, 4L), new HashSet<>(ids.subList(0, 3)));
        } finally {
            )  
            List<List<String>> secondRows = new ArrayList<>();
                    continue;
            root.allocateNew();
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
 */  
                }  
        return new ArrowExport(null, arrowSchema);
     * Every merged row must keep its own LIST values in source order after the k-way merge
    private ArrowExport exportData(long[] ids, List<List<String>> tags) {
                if (row % 2 == 0) {  
import org.apache.arrow.c.ArrowSchema;
    }
        return values.stream().mapToLong(Long::longValue).toArray();  
    public void testExplicitMaxAscendingOverridesDefault() throws Exception {  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        assertEquals(List.of("five"), tagsOf(merged.get(1)));
                    }
            settings.putList("index.sort.order", order);
    private static final List<List<String>> DISTINCT_MODE_ROWS = List.of(List.of("a", "z"), List.of("m", "n"), List.of("b"));
    }  
        List<Long> ids = writeMergeAndReadIds(sortConfig("desc", "max", "_last"), nullLikeRows());
            }
        return new ParquetSortConfig(indexSettings);
import org.apache.arrow.vector.complex.ListVector;
    private List<Long> writeMergeAndReadIds(ParquetSortConfig sortConfig, List<List<String>> rows) throws Exception {
        assertEquals(List.of(1L, 2L, 3L), writeMergeAndReadIds(sortConfig("desc", null, "_last"), DISTINCT_MODE_ROWS));
    @Override
            String first = writeSortedFile(dir.resolve("first.parquet"), sortConfig, toLongArray(firstIds), firstRows);
            RustBridge.mergeParquetFilesInRust(List.of(Path.of(first), Path.of(second)), null, merged, INDEX_NAME, 1L);
/**
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
 * compatible open source license.
                tagsVector.endValue(row, rowValues.size());
    }
    }
        return (List<String>) row.get("tags");
     * The merge must preserve the null-vs-empty-vs-null-child distinctions exactly: a null list
    private List<Long> idsOf(List<Map<String, Object>> rows) {
            .putList("index.sort.missing", missing);
        assertEquals(ids.length, tags.size());
    }  
    private List<List<String>> nullLikeRows() {  
        assertEquals(List.of(1L, 2L, 3L), writeMergeAndReadIds(sortConfig("desc", "max", "_last"), DISTINCT_MODE_ROWS));  
    public void testExplicitMaxDescending() throws Exception {
import java.nio.charset.StandardCharsets;
    @SuppressForbidden(reason = "JSON parsing for persisted physical row order verification")
                }
import java.nio.file.Path;  
                    FieldType.nullable(ArrowType.List.INSTANCE),
            List.of("five")            // id 5, min "five"
import java.util.HashMap;
    }
        allocator = new RootAllocator();
    }
        }
            settings.putList("index.sort.mode", mode);
}  
        }  
                List<String> rowValues = tags.get(row);
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.List;
        }
                    firstRows.add(rows.get(row));
import org.opensearch.index.IndexSettings;  
        String file = path.toString();
        assertEquals(List.of(5L, 1L), ids.subList(3, 5));  
        RustBridge.onSettingsUpdate(NativeSettings.builder().indexName(INDEX_NAME).build());
    }
        }
import org.opensearch.common.settings.Settings;
        Settings.Builder settings = Settings.builder()
        assertEquals(List.of(1L, 3L, 2L), writeMergeAndReadIds(sortConfig("asc", "min", "_last"), DISTINCT_MODE_ROWS));  
    private BufferAllocator allocator;  
import org.opensearch.core.xcontent.DeprecationHandler;  
                    if (value == null) {
            NativeParquetWriter writer = new NativeParquetWriter(file);  
                    childIndex++;  
    public void testExplicitMinDescendingOverridesDefault() throws Exception {
            List.of(  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.common.xcontent.json.JsonXContent;
            }).toList();  
import org.opensearch.common.SuppressForbidden;  
 * End-to-end LIST index-sort tests across the Java settings layer, FFM writer bridge,  
     */  
            return parser.list().stream().map(row -> {
                    secondIds.add((long) row + 1);
    public void setUp() throws Exception {
        RustBridge.initLogger();  
import org.apache.arrow.memory.RootAllocator;
    }
        List<Map<String, Object>> merged = writeMergeAndReadRows(sortConfig("asc", "min", "_last"), rows);  
     * assertions are keyed by id rather than position.
import org.opensearch.cluster.metadata.IndexMetadata;
        return idsOf(writeMergeAndReadRows(sortConfig, rows));
                        values.setSafe(childIndex, value.getBytes(StandardCharsets.UTF_8));
            writer.flush();
    @Override  
                }  
     * merge_list_column_tests; the Rust unit tests do not run in the sandbox check.
            return new ArrowExport(array, arrowSchema);  
        }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(INDEX_NAME, settings.build());  
            byId.put(((Number) row.get("id")).longValue(), tagsOf(row));
            try (ArrowExport data = exportData(ids, tags)) {
            String merged = dir.resolve("merged.parquet").toString();
    public void testNullEmptyAndAllNullListsSortLast() throws Exception {  
        return java.util.Arrays.asList(List.of("b", "d"), null, List.of(), java.util.Arrays.asList(null, null), List.of("a", "z"));
        assertEquals(List.of(3L, 2L, 1L), writeMergeAndReadIds(sortConfig("asc", "max", "_last"), DISTINCT_MODE_ROWS));
 * native per-file sort, native multi-file merge, and persisted Parquet row order.
 * SPDX-License-Identifier: Apache-2.0
        Map<Long, List<String>> byId = new HashMap<>();
                    firstIds.add((long) row + 1);
            return readRows(merged);
    }
