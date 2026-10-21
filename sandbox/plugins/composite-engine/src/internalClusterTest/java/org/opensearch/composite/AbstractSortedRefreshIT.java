                    }).toList();
import org.opensearch.index.IndexService;
            Function.identity()
                        if (prevName != null && currName == null) continue;
     * <p>
        return shard.shardPath().getDataPath().resolve("parquet");
    protected void verifyLuceneDocCount(int expectedTotalDocs) throws IOException {
    }
    }
            org.apache.lucene.index.LeafReader leaf = reader.leaves().get(0).reader();
                try (
        // Reconstruct per-doc keyword field values from Lucene's inverted index
package org.opensearch.composite;
                        NamedXContentRegistry.EMPTY,
     * Compares two nullable integer values according to sort direction and null placement.
    }
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
        }
                            fail("null age at doc " + doc + " came after non-null (expected nulls first)");
                        @SuppressWarnings("unchecked")
                int maxDoc = leaf.maxDoc();
            int cmp = compareValues(prevVal, currVal, isAsc, nullsFirst);
    }
 * The OpenSearch Contributors require contributions made to
                SortedNumericDocValues ageDV = leaf.getSortedNumericDocValues("age");
    }
    }
                        rowId
            // prev is null: correct if nullsFirst, violation if nullsLast
        }
                Path filePath = parquetDir.resolve(file);
                            rowId
                        Map<String, Object> row = (Map<String, Object>) obj;
                            // both null — ok
                }
    /**
            for (String file : wfs.files()) {
                        json
        Path parquetDir = getParquetDir();
        IndexShard shard = getPrimaryShard();
import org.opensearch.common.xcontent.json.JsonXContent;
            for (String file : wfs.files()) {
            }
                    Long age = null;
                        if (prevName != null && currName != null) {
        }
        }
                    }).toList();
                    rows = parser.list().stream().map(o -> {
import org.opensearch.test.OpenSearchIntegTestCase;
        Path luceneDir = getLuceneDir();
            // index may not exist
                    );
     * Parquet. Keyword fields are also stored only in the inverted index (no doc
    protected IndexShard getPrimaryShard() {
        org.apache.lucene.util.BytesRef term;
     */
    }
        IndexShard shard = indexService.getShard(0);
                String json = RustBridge.readAsJson(filePath.toString());
                        Map<String, Object> m = (Map<String, Object>) o;
    @Override
            assertEquals("Test assumes a single Lucene leaf for sequential alignment", 1, reader.leaves().size());
                if (rowIdDV == null) continue;
 * this file be licensed under the Apache-2.0 license or a
        }
        String[] sortOrders,
                            + rowId
 */
    protected DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
    }
                            + file,
import org.opensearch.parquet.bridge.RustBridge;
        }
     * index) and {@code __row_id__} (as doc values). Numeric fields like {@code age}
     */
import org.opensearch.common.util.FeatureFlags;
                        "age should be DESC but found " + prevAgeVal + " before " + currAgeVal + " at row " + i + " in " + file,
            }
    protected void verifyParquetAndLuceneRowsAlignedSequentially(DataformatAwareCatalogSnapshot snapshot) throws Exception {
import org.opensearch.common.SuppressForbidden;
                if (rows.size() <= 1) continue;
                    if (currAge == null) {
                    }
                List<Map<String, Object>> rows;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(getMapping()).get();
                    if (ageDV != null && ageDV.advanceExact(doc)) {
        assertEquals(RestStatus.CREATED, response.status());
                        }
                        Object currName = rows.get(i).get("name");
}
                    Object rowIdObj = row.get(DocumentInput.ROW_ID_FIELD);
        String[] values = new String[leaf.maxDoc()];
                                + " but got "
    protected static final String INDEX_NAME = "test-composite-refresh-sorted";
        return shard.shardPath().resolveIndex();
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
        return getClusterState().nodes().get(nodeId).getName();
            client().admin().indices().prepareDelete(INDEX_NAME).get();
                        return m;
import java.util.function.Function;
                        expectedRowId,
                    if (prevAgeVal == currAgeVal) {
import org.opensearch.common.settings.Settings;
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
                for (Map<String, Object> row : rows) {
        Path luceneDir = getLuceneDir();
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
                        json
        for (Segment segment : snapshot.getSegments()) {
            for (int i = 0; i < expectedNames.length; i++) {
        List<Map<String, Object>> parquetRows = new ArrayList<>();
                    int prevAgeVal = ((Number) prevAge).intValue();
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
            for (String file : wfs.files()) {
                ) {
        if (prev == null && curr == null) return 0;
        }
                    )
     * Returns negative if in correct order, zero if equal, positive if violated.
                long expectedRowId = 0;
        } catch (Exception e) {
import org.opensearch.index.engine.dataformat.DocumentInput;
            for (int i = 0; i < parquetRows.size(); i++) {
                    int cmp = compareRowsByMultiField(rows.get(i - 1), rows.get(i), fieldNames, sortOrders, sortMissing);
                try (
                    if (prevAge == null) continue;
                ) {
                        age = ageDV.nextValue();
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
    protected void verifyParquetRowIdSequential(DataformatAwareCatalogSnapshot snapshot) throws Exception {
import org.apache.lucene.index.SortedNumericDocValues;
                    int currAgeVal = ((Number) currAge).intValue();
                        return m;
                        // age DESC nulls first
            String[] luceneTags = readKeywordValuesPerDoc(leaf, "tag");
        // Read Parquet rows in physical order
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
    }
                long expectedRowId = 0;
    // Helpers: verification
                            + " should be sequential, expected "
            String value = term.utf8ToString();
                String pqTag = (String) pq.get("tag");
    }
     * (age DESC nulls first). Reads age from sorted numeric doc values.
            return nullsFirst ? -1 : 1;
                    );
 *
     */
        String[] fieldNames,
        String[] sortMissing
        return Settings.builder()
            Object currVal = curr.get(fieldNames[f]);
    @SuppressForbidden(reason = "JSON parsing for sort order verification")
     * Compares two rows by the multi-field sort key. Returns negative if prev comes before curr
                        assertEquals(
                    )
        if (prev == null) {
            assertNotNull("Segment should have parquet files", wfs);
        String[] sortOrders,
            }
                values[doc] = value;
        CommitStats commitStats = shard.commitStats();
    /**
    }
/*
        return DataformatAwareCatalogSnapshot.deserializeFromString(
        return indexService.getShard(0);
                        @SuppressWarnings("unchecked")
    public void tearDown() throws Exception {
        try {
        }
                            + " in "
                        }
     * the inverted index. Each doc is expected to have at most one term for the
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        for (Segment segment : snapshot.getSegments()) {
                String pqName = (String) pq.get("name");
            assertEquals("Lucene doc count should match", expectedTotalDocs, reader.numDocs());
            }
    }
            for (LeafReaderContext ctx : reader.leaves()) {
                    );
    }
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        assertNotNull(commitStats);
                        @SuppressWarnings("unchecked")
                        prevAgeVal >= currAgeVal
                Long prevAge = null;
                    prevAgeNull = (age == null);
                        json
                    for (Object obj : parser.list()) {
        );
 * compatible open source license.
                        DocumentInput.ROW_ID_FIELD
    }
                    expectedRowId++;
                        if (prevName == null && currName != null) {
        }
     * Reads Parquet rows and Lucene documents in physical (storage) order from the
            }
        while ((term = it.next()) != null) {
        Path parquetDir = getParquetDir();
                }
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
    }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        for (Segment segment : snapshot.getSegments()) {
                                + rowId
        Path luceneDir = getLuceneDir();
    }
    @SuppressForbidden(reason = "JSON parsing for cross-format row alignment")
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                if (rows.size() <= 1) continue;
                assertEquals("name mismatch at position " + i, pqName, luceneNames[i]);
        int prevInt = ((Number) prev).intValue();
            }
        assertNotNull(commitStats.getUserData());
                                + doc,
                }
                Path filePath = parquetDir.resolve(file);
     * The {@code tag} field is NOT part of the sort key — verifying it confirms the
                String json = RustBridge.readAsJson(filePath.toString());
                List<Map<String, Object>> rows;
                            + " but got "
                            DocumentInput.ROW_ID_FIELD
    protected void verifyParquetSortOrder(DataformatAwareCatalogSnapshot snapshot) throws Exception {
    }
            boolean nullsFirst = "_first".equals(sortMissing[f]);
import org.opensearch.core.xcontent.XContentParser;
    protected void verifyLuceneSortOrder() throws IOException {
                }
                        NamedXContentRegistry.EMPTY,
                    rows = parser.list().stream().map(o -> {
    }
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name).get();
    protected int compareRowsByMultiField(
            for (String file : wfs.files()) {
                try (
                try (
        Path luceneDir = getLuceneDir();
        String[] fieldNames,
    protected String[] getMapping() {
            String[] luceneNames = readKeywordValuesPerDoc(leaf, "name");
            return nullsFirst ? 1 : -1;
            org.apache.lucene.index.PostingsEnum postings = it.postings(null);
        Map<String, Object> prev,
import java.util.Map;
                    );
                            assertTrue(
            assertEquals("Lucene doc count should match expected sequence length", expectedNames.length, actual.length);
                    rows = parser.list().stream().map(o -> {
                        fail("age null should come before non-null at row " + i);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
                            // prev was null, current is non-null — ok (nulls first)
                        expectedRowId++;
import org.apache.lucene.index.LeafReaderContext;
                        @SuppressWarnings("unchecked")
        return new String[] { "name", "type=keyword", "age", "type=integer", "tag", "type=keyword" };
     * Asserts that the {@code name} keyword field, read in Lucene doc order from
                        }
    }
                    }
                        if (prevAgeNull && age == null) {
                        DocumentInput.ROW_ID_FIELD + " should be present in parquet row " + expectedRowId + " in " + file,
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
    protected Path getParquetDir() {
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name, "age", age).get();
    @Override
        assertNotNull("Lucene index should have field '" + fieldName + "' in inverted index", terms);
                for (int i = 1; i < rows.size(); i++) {
    ) throws Exception {
    protected void createIndex(Settings settings) {
        }
        return 0;
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
     * {@code tag}).
    // ══════════════════════════════════════════════════════════════════════
import org.opensearch.core.rest.RestStatus;
import java.util.List;
    protected int compareValues(Object prev, Object curr, boolean isAsc, boolean nullsFirst) {
            .put(super.nodeSettings(nodeOrdinal))
                for (int i = 1; i < rows.size(); i++) {
     * Supports any combination of ASC/DESC with configurable null placement.
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        Path luceneDir = getLuceneDir();
        long totalRows = 0;
        assertEquals(RestStatus.OK, flushResponse.getStatus());
                ) {
                    Object prevAge = rows.get(i - 1).get("age");
import java.util.ArrayList;
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name, "age", age, "tag", tag).get();
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        return values;
     * values), so we read them via TermsEnum/postings and reconstruct the per-doc
                ) {
                    }
                        rowIdObj
     */
                            assertTrue("age should be DESC at doc " + doc + ", got " + prevAge + " before " + age, prevAge >= age);
        }
            assertEquals("Test assumes a single Lucene leaf for sequential alignment", 1, reader.leaves().size());
    @SuppressForbidden(reason = "JSON parsing for row ID verification")
                    prevAge = age;
    }
import java.io.IOException;
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
                ParquetFileMetadata metadata = RustBridge.getFileMetadata(filePath.toString());
            }
                            fail("name nulls should be last at row " + i + " in " + file);
                for (int doc = 0; doc < maxDoc; doc++) {
import org.opensearch.index.engine.exec.WriterFileSet;
     * Parquet row i and Lucene doc i agree on keyword fields ({@code name} and
    /**
    // ══════════════════════════════════════════════════════════════════════
                Path filePath = parquetDir.resolve(file);
                    }
    /**
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
                }
import org.opensearch.parquet.bridge.ParquetFileMetadata;
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
     * are intentionally NOT stored in the Lucene secondary — they live only in
            // curr is null: violation if nullsFirst, correct if nullsLast
            for (LeafReaderContext ctx : reader.leaves()) {
     */
                }
                Path filePath = parquetDir.resolve(file);
import org.opensearch.index.engine.CommitStats;
            .build();
    }
        assertEquals(RestStatus.CREATED, response.status());
                        return m;
        for (int f = 0; f < fieldNames.length; f++) {
import org.opensearch.action.admin.indices.flush.FlushResponse;
    protected void verifyLuceneRowIdSequential() throws IOException {
import org.opensearch.core.xcontent.DeprecationHandler;
        String nodeName = getNodeName();
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
        IndexShard shard = getPrimaryShard();
        org.apache.lucene.index.Terms terms = leaf.terms(fieldName);
            while ((doc = postings.nextDoc()) != org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS) {
     * The Lucene secondary writer only persists text/keyword fields (in the inverted
import org.opensearch.indices.IndicesService;
            }
    /**
    protected void flushAndRefresh() {
                        Map<String, Object> m = (Map<String, Object>) o;
import org.opensearch.action.index.IndexResponse;
                        } else if (prevAgeNull) {
import java.nio.file.Files;
        assertEquals(RestStatus.CREATED, response.status());
                    long rowId = ((Number) rowIdObj).longValue();
     * Verifies that the Lucene segment is physically sorted by the configured IndexSort
                        NamedXContentRegistry.EMPTY,
        return isAsc ? natural : -natural;
        for (Segment segment : snapshot.getSegments()) {
                Map<String, Object> pq = parquetRows.get(i);
                    if (doc > 0) {
     * value.
        super.tearDown();
        }
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
    }
    protected void indexDoc(String name, int age, String tag) {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, getNodeName());
            }
    }
    /**
                    )
                            );
        }
        Path parquetDir = getParquetDir();
     * Reconstructs the per-doc keyword value for the given field by iterating
import org.apache.lucene.index.DirectoryReader;
                }
        for (Segment segment : snapshot.getSegments()) {
    // ══════════════════════════════════════════════════════════════════════
                    )
                }
     * field. Returns an array indexed by Lucene doc ID.
        DataformatAwareCatalogSnapshot snapshot,
import org.opensearch.index.engine.exec.Segment;
     * single-shard, single-segment index and asserts that at every position i,
        }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     */
public class AbstractSortedRefreshIT extends OpenSearchIntegTestCase {
                    }
     */
                assertEquals("tag mismatch at position " + i, pqTag, luceneTags[i]);
     * the single-segment index, matches the given expected sequence. Used by
            Object prevVal = prev.get(fieldNames[f]);
                totalRows += metadata.numRows();
                    assertTrue(
            }
                    if (rowIdDV.advanceExact(doc)) {
            boolean isAsc = "asc".equals(sortOrders[f]);
                String json = RustBridge.readAsJson(filePath.toString());
    protected void verifyLuceneNamesInOrder(String[] expectedNames) throws IOException {
                        Object prevName = rows.get(i - 1).get("name");
        Map<String, Object> curr,
                    }
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
                                + " at doc "
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
     * Verifies Parquet sort order for a dynamic set of integer sort fields.
                    // When age is equal, verify name ASC (nulls last)
                                ((String) prevName).compareTo((String) currName) <= 0
                    if (prevAge == null && currAge == null) continue;
            int doc;
        assertTrue("Lucene directory should exist", Files.exists(luceneDir));
            assertEquals("Parquet and Lucene must have same row count", parquetRows.size(), luceneNames.length);
    }
                        NamedXContentRegistry.EMPTY,
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     * unsorted-path tests to confirm insertion order is preserved end-to-end.
                        Map<String, Object> m = (Map<String, Object>) o;
                    assertEquals(
        assertEquals("Total rows should match ingested docs", expectedTotalDocs, totalRows);
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
            if (cmp != 0) return cmp;
    }
import org.apache.lucene.store.NIOFSDirectory;
    // Helpers: accessors
        if (curr == null) {
    protected String[] readKeywordValuesPerDoc(org.apache.lucene.index.LeafReader leaf, String fieldName) throws IOException {
import org.opensearch.index.shard.IndexShard;
                    assertNotNull(
                }
    // ══════════════════════════════════════════════════════════════════════
                    }).toList();
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
                        cmp <= 0
        String[] sortMissing
                                + " should be sequential, expected "
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
                                "name should be ASC but found '" + prevName + "' before '" + currName + "' at row " + i + " in " + file,
    protected Settings nodeSettings(int nodeOrdinal) {
    protected Path getLuceneDir() {
                        json
                    // nulls first for age
        ensureGreen(INDEX_NAME);
                        );
    protected void indexDoc(String name, int age) {
                List<Map<String, Object>> rows;
    protected void verifyParquetRowCount(DataformatAwareCatalogSnapshot snapshot, int expectedTotalDocs) throws IOException {
        Path parquetDir = getParquetDir();
                String json = RustBridge.readAsJson(parquetDir.resolve(file).toString());
                    Object currAge = rows.get(i).get("age");
    protected String getNodeName() {
                    assertTrue(
    protected void indexDocNullAge(String name) {
                            expectedRowId,
                assertEquals("name at lucene docId " + i, expectedNames[i], actual[i]);
                org.apache.lucene.index.LeafReader leaf = ctx.reader();
                        parquetRows.add(row);
                        long rowId = rowIdDV.nextValue();
            for (String file : wfs.files()) {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
                        "Sort order violated at row " + i + " in " + file + ": prev=" + rows.get(i - 1) + " curr=" + rows.get(i),
    /**
        int natural = Integer.compare(prevInt, currInt);
    protected void verifyParquetSortOrderMultiField(
                            + expectedRowId
     * <p>
        org.apache.lucene.index.TermsEnum it = terms.iterator();
            String[] actual = readKeywordValuesPerDoc(leaf, "name");
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
            org.apache.lucene.index.LeafReader leaf = reader.leaves().get(0).reader();
                boolean prevAgeNull = true;
import java.nio.file.Path;
import org.apache.lucene.store.Directory;
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
 * SPDX-License-Identifier: Apache-2.0
                                + expectedRowId
        Path parquetDir = getParquetDir();
                        } else {
     * row ID rewrite correctly co-locates non-sort fields across formats too.
    ) {
                        } else if (age == null) {
    @SuppressForbidden(reason = "JSON parsing for sort order verification")
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
                if (maxDoc <= 1) continue;
     * (correct order), zero if equal, positive if prev comes after curr (violation).
        int currInt = ((Number) curr).intValue();
