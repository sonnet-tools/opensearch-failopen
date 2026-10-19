import java.nio.file.Path;
import org.opensearch.core.xcontent.DeprecationHandler;
                if (row % 2 == 0) {
     * Every merged row must keep its own LIST values in source order after the k-way merge
import org.apache.arrow.vector.VarCharVector;
import java.util.HashMap;
            }
import org.apache.arrow.vector.types.pojo.ArrowType;
        }
            .putList("index.sort.missing", missing);
            List<List<String>> secondRows = new ArrayList<>();
            )
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(ids.length, tags.size());
    /**
            RustBridge.removeSettings(INDEX_NAME);
            String first = writeSortedFile(dir.resolve("first.parquet"), sortConfig, toLongArray(firstIds), firstRows);
                    tagsVector.setNull(row);
    private static final String INDEX_NAME = "list-sort-mode-it";
    public void tearDown() throws Exception {
                NamedXContentRegistry.EMPTY,
            RustBridge.mergeParquetFilesInRust(List.of(Path.of(first), Path.of(second)), null, merged, INDEX_NAME, 1L);
 * SPDX-License-Identifier: Apache-2.0
                    secondIds.add((long) row + 1);
        schema = new Schema(
        super.setUp();
import java.util.List;
    private long[] toLongArray(List<Long> values) {
        assertEquals(List.of("four"), tagsOf(merged.get(2)));
            writer.initialize(INDEX_NAME, schemaExport.getSchemaAddress(), sortConfig, 0L);
    }
        }
import org.apache.arrow.memory.RootAllocator;
        allocator = new RootAllocator();
    }
        String json = RustBridge.readAsJson(parquetFile);
            List.of("four"),           // id 4, min "four"
    private String writeSortedFile(Path path, ParquetSortConfig sortConfig, long[] ids, List<List<String>> tags) throws Exception {
        assertEquals(List.of("two", "ii", "2"), tagsOf(merged.get(0)));
    /**
            return new ArrowExport(array, arrowSchema);
        List<Long> ids = writeMergeAndReadIds(sortConfig("desc", "max", "_last"), nullLikeRows());
     * tags attached to the wrong id. This is the Java/CI-visible counterpart of the Rust
import java.util.Set;
    @SuppressWarnings("unchecked")
    private ParquetSortConfig sortConfig(String order, String mode, String missing) {
    }
            List<Long> secondIds = new ArrayList<>();
    private ArrowExport exportData(long[] ids, List<List<String>> tags) {
    }
     */
    }
            NativeParquetWriter writer = new NativeParquetWriter(file);
    }
 */
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .putList("index.sort.field", "tags")
/*
                    firstRows.add(rows.get(row));
    }
    }
import java.util.Map;
            String second = writeSortedFile(dir.resolve("second.parquet"), sortConfig, toLongArray(secondIds), secondRows);
            for (int row = 0; row < rows.size(); row++) {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        assertEquals(5, byId.size());
    @Override
        );
            List<List<String>> firstRows = new ArrayList<>();
        if (order != null) {
        return values.stream().mapToLong(Long::longValue).toArray();
    private List<Long> writeMergeAndReadIds(ParquetSortConfig sortConfig, List<List<String>> rows) throws Exception {
        assertNull("null list must stay null", byId.get(2L));
                new Field("id", FieldType.nullable(new ArrowType.Int(64, true)), null),
        super.tearDown();
            assertEquals(rows.size(), RustBridge.getFileMetadata(merged).numRows());
                Map<String, Object> values = (Map<String, Object>) row;
    private List<String> tagsOf(Map<String, Object> row) {
import java.util.HashSet;
        allocator.close();
            ArrowArray array = ArrowArray.allocateNew(allocator);
                    "tags",
                        values.setSafe(childIndex, value.getBytes(StandardCharsets.UTF_8));
        );
        }
            for (int row = 0; row < ids.length; row++) {
            }
 * End-to-end LIST index-sort tests across the Java settings layer, FFM writer bridge,
        RustBridge.onSettingsUpdate(NativeSettings.builder().indexName(INDEX_NAME).build());
        assertEquals(List.of(1L, 3L, 2L), writeMergeAndReadIds(sortConfig("asc", "min", "_last"), DISTINCT_MODE_ROWS));
    private BufferAllocator allocator;
                for (String value : rowValues) {
    }
                idVector.setSafe(row, ids[row]);
    }
 * native per-file sort, native multi-file merge, and persisted Parquet row order.
import org.opensearch.Version;
                new Field(
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
                } else {
import org.apache.arrow.vector.BigIntVector;
    }
    }
    public void setUp() throws Exception {
    }
public class ParquetListSortModeIntegrationTests extends OpenSearchTestCase {
import java.nio.charset.StandardCharsets;
    }
        List<List<String>> rows = List.of(
        return new ParquetSortConfig(indexSettings);
import org.opensearch.test.IndexSettingsModule;
import org.apache.arrow.vector.types.pojo.Schema;
        }
    public void testDefaultAscendingUsesMin() throws Exception {
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.types.pojo.Field;
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    public void testDefaultDescendingUsesMax() throws Exception {
/**
            writer.flush();
                    if (value == null) {
     */
            BigIntVector idVector = (BigIntVector) root.getVector("id");
        assertEquals(Set.of(2L, 3L, 4L), new HashSet<>(ids.subList(0, 3)));
            )
        return rows.stream().map(row -> ((Number) row.get("id")).longValue()).toList();
        assertEquals(List.of("b", "d"), byId.get(1L));
        List<Map<String, Object>> merged = writeMergeAndReadRows(sortConfig("asc", "min", "_last"), nullLikeRows());
                }
import org.apache.arrow.c.ArrowSchema;
        assertEquals(List.of(5L, 1L), ids.subList(0, 2));
        Data.exportSchema(allocator, schema, null, arrowSchema);
    private static final List<List<String>> DISTINCT_MODE_ROWS = List.of(List.of("a", "z"), List.of("m", "n"), List.of("b"));
        assertEquals(List.of("one"), tagsOf(merged.get(4)));
    }
        assertEquals(List.of(5L, 1L), ids.subList(3, 5));
    }
        assertEquals(List.of("a", "z"), byId.get(5L));
        for (Map<String, Object> row : merged) {
            byId.put(((Number) row.get("id")).longValue(), tagsOf(row));
        return idsOf(writeMergeAndReadRows(sortConfig, rows));
        Settings.Builder settings = Settings.builder()
            root.setRowCount(ids.length);
            List.of(
            List.of("one"),            // id 1, min "one"
        return file;
        assertEquals(Set.of(2L, 3L, 4L), new HashSet<>(ids.subList(2, 5)));
        assertEquals(List.of("five"), tagsOf(merged.get(1)));
    private List<Long> idsOf(List<Map<String, Object>> rows) {
        List<Map<String, Object>> merged = writeMergeAndReadRows(sortConfig("asc", "min", "_last"), rows);
     * value that detached from its row (a row-vs-value confusion in the merge) would surface as
import org.opensearch.test.OpenSearchTestCase;
                    FieldType.nullable(ArrowType.List.INSTANCE),
        assertEquals(List.of("three", "iii"), tagsOf(merged.get(3)));
                }
import org.opensearch.common.settings.Settings;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
 */
        } finally {
            return readRows(merged);
                )
                }
    }
import org.apache.arrow.vector.VectorSchemaRoot;
                    firstIds.add((long) row + 1);
    @SuppressForbidden(reason = "JSON parsing for persisted physical row order verification")
            settings.putList("index.sort.order", order);
    }
     * The merge must preserve the null-vs-empty-vs-null-child distinctions exactly: a null list
            root.allocateNew();
        assertEquals("null children must be preserved", java.util.Arrays.asList(null, null), byId.get(4L));
            Path dir = createTempDir();
    }
                if (rowValues == null) {
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(List.of(1L, 2L, 3L), writeMergeAndReadIds(sortConfig("desc", null, "_last"), DISTINCT_MODE_ROWS));
        return (List<String>) row.get("tags");
import org.opensearch.common.SuppressForbidden;
            String merged = dir.resolve("merged.parquet").toString();
        RustBridge.removeSettings(INDEX_NAME);
    public void testExplicitMaxAscendingOverridesDefault() throws Exception {
     * nulls. The null-like rows share a null sort key so their relative order is unspecified;
        assertEquals(List.of(2L, 5L, 4L, 3L, 1L), idsOf(merged));
import org.apache.arrow.vector.types.pojo.FieldType;
                int childIndex = tagsVector.startNewValue(row);
        }
    public void testExplicitMinAscending() throws Exception {
                return values;
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    private List<List<String>> nullLikeRows() {
                writer.write(data.getArrayAddress(), data.getSchemaAddress());
                    childIndex++;
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        return new ArrowExport(null, arrowSchema);
}
                    continue;
import org.opensearch.nativebridge.spi.ArrowExport;
 * The OpenSearch Contributors require contributions made to
        Map<Long, List<String>> byId = new HashMap<>();
import org.opensearch.index.IndexSettings;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(List.of(1L, 3L, 2L), writeMergeAndReadIds(sortConfig(null, null, "_last"), DISTINCT_MODE_ROWS));
    public void testMergePreservesNullEmptyAndNullChildrenExactly() throws Exception {
                    }
        RustBridge.initLogger();
    public void testExplicitMinDescendingOverridesDefault() throws Exception {
            }).toList();
    }
    public void testNullEmptyAndAllNullListsSortLast() throws Exception {
            List.of("five")            // id 5, min "five"
import org.apache.arrow.c.ArrowArray;
        }
        try (ArrowExport schemaExport = exportSchema()) {
                json
        try {
            try (ArrowExport data = exportData(ids, tags)) {
            return parser.list().stream().map(row -> {
    }
    public void testSortedMergePreservesListValuesPerRow() throws Exception {
package org.opensearch.parquet.bridge;
            settings.putList("index.sort.mode", mode);
        List<Long> ids = writeMergeAndReadIds(sortConfig("asc", "min", "_first"), nullLikeRows());
import org.opensearch.core.xcontent.XContentParser;
     * crosses file boundaries. Distinct minimum elements give a deterministic row order, so a
                    secondRows.add(rows.get(row));
        // Row order by id: id1 ["b","d"], id2 null, id3 [], id4 [null,null], id5 ["a","z"].
                    List.of(new Field("item", FieldType.nullable(new ArrowType.Utf8()), null))
    }
            VarCharVector values = (VarCharVector) tagsVector.getDataVector();
import org.apache.arrow.vector.complex.ListVector;
    public void testExplicitMaxDescending() throws Exception {
    @Override
                        values.setNull(childIndex);
 *
        assertEquals(List.of(1L, 2L, 3L), writeMergeAndReadIds(sortConfig("desc", "max", "_last"), DISTINCT_MODE_ROWS));
        ) {
 * compatible open source license.
        assertEquals(List.of(3L, 2L, 1L), writeMergeAndReadIds(sortConfig("asc", "max", "_last"), DISTINCT_MODE_ROWS));
            List.of("two", "ii", "2"), // id 2, min "2"
                List<String> rowValues = tags.get(row);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(INDEX_NAME, settings.build());
    private List<Map<String, Object>> writeMergeAndReadRows(ParquetSortConfig sortConfig, List<List<String>> rows) throws Exception {
import org.opensearch.common.xcontent.json.JsonXContent;
        String file = path.toString();
                tagsVector.endValue(row, rowValues.size());
        try (
                    } else {
        if (mode != null) {
     * merge_list_column_tests; the Rust unit tests do not run in the sandbox check.
            ListVector tagsVector = (ListVector) root.getVector("tags");
            List.of("three", "iii"),   // id 3, min "iii"
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            }
        assertEquals("empty list must stay empty and distinct from null", List.of(), byId.get(3L));
import org.apache.arrow.c.Data;
    private ArrowExport exportSchema() {
    private Schema schema;
import java.util.ArrayList;
    }
    private List<Map<String, Object>> readRows(String parquetFile) throws Exception {
        assertEquals(List.of(2L, 3L, 1L), writeMergeAndReadIds(sortConfig("desc", "min", "_last"), DISTINCT_MODE_ROWS));
        return java.util.Arrays.asList(List.of("b", "d"), null, List.of(), java.util.Arrays.asList(null, null), List.of("a", "z"));
     * stays null, an empty list stays empty (not null), and a list of null children keeps its
    public void testNullEmptyAndAllNullListsSortFirst() throws Exception {
     * assertions are keyed by id rather than position.
                @SuppressWarnings("unchecked")
            List<Long> firstIds = new ArrayList<>();
