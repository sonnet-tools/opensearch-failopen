                        if (prevName != null && currName != null) {  
                ) {
    @Override
                        NamedXContentRegistry.EMPTY,
            for (String file : wfs.files()) {
        }
        assertEquals(RestStatus.CREATED, response.status());
                }
        String[] sortOrders,
    @Override
                        json  
                                + doc,
        }
                        if (prevName != null && currName == null) continue;
                    assertEquals(
     * <p>  
    /**
            for (String file : wfs.files()) {
                        parquetRows.add(row);
                    if (prevAge == null && currAge == null) continue;
        Path luceneDir = getLuceneDir();  
import org.opensearch.index.IndexService;
        // Reconstruct per-doc keyword field values from Lucene's inverted index
            int doc;
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
    /**
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
    /**
                            + " should be sequential, expected "  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
                                "name should be ASC but found '" + prevName + "' before '" + currName + "' at row " + i + " in " + file,
        }  
                    }  
                    }
import org.opensearch.parquet.bridge.ParquetFileMetadata;
     */
    }
                    );
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
                    // nulls first for age  
import org.opensearch.common.SuppressForbidden;  
    protected void indexDoc(String name, int age) {
                    Object prevAge = rows.get(i - 1).get("age");  
     * the single-segment index, matches the given expected sequence. Used by
                        Map<String, Object> m = (Map<String, Object>) o;
            boolean isAsc = "asc".equals(sortOrders[f]);  
                List<Map<String, Object>> rows;
                    );
                if (rowIdDV == null) continue;
     */
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
        return shard.shardPath().getDataPath().resolve("parquet");
    }  
import org.opensearch.index.engine.exec.WriterFileSet;  
        assertTrue("Lucene directory should exist", Files.exists(luceneDir));
                            // both null — ok
    @SuppressForbidden(reason = "JSON parsing for row ID verification")  
     * Asserts that the {@code name} keyword field, read in Lucene doc order from  
            }
            commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY),
     */  
                    }).toList();
                totalRows += metadata.numRows();
        }  
                    XContentParser parser = JsonXContent.jsonXContent.createParser(  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
                            );
        org.apache.lucene.index.Terms terms = leaf.terms(fieldName);  
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));  
    }
                Path filePath = parquetDir.resolve(file);
    }
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));  
        Path luceneDir = getLuceneDir();  
import java.nio.file.Files;  
                            fail("name nulls should be last at row " + i + " in " + file);
            return nullsFirst ? -1 : 1;
                        assertEquals(
                Path filePath = parquetDir.resolve(file);  
        return new String[] { "name", "type=keyword", "age", "type=integer", "tag", "type=keyword" };
            return nullsFirst ? 1 : -1;  
        String[] sortMissing
    protected void verifyLuceneDocCount(int expectedTotalDocs) throws IOException {  
        if (prev == null) {  
                                + " at doc "
                values[doc] = value;  
     */  
        DataformatAwareCatalogSnapshot snapshot,
     * (age DESC nulls first). Reads age from sorted numeric doc values.  
                ParquetFileMetadata metadata = RustBridge.getFileMetadata(filePath.toString());
            String[] luceneTags = readKeywordValuesPerDoc(leaf, "tag");  
                }
import org.opensearch.indices.IndicesService;  
     * Compares two rows by the multi-field sort key. Returns negative if prev comes before curr
                for (int i = 1; i < rows.size(); i++) {
                        expectedRowId++;  
                        @SuppressWarnings("unchecked")
import org.apache.lucene.index.SortedNumericDocValues;  
    protected void flushAndRefresh() {
                try (
    }
        long totalRows = 0;  
                }  
        Path parquetDir = getParquetDir();
     * Verifies Parquet sort order for a dynamic set of integer sort fields.  
    public void tearDown() throws Exception {
                            assertTrue("age should be DESC at doc " + doc + ", got " + prevAge + " before " + age, prevAge >= age);
                    if (doc > 0) {
     * values), so we read them via TermsEnum/postings and reconstruct the per-doc
        IndexShard shard = getPrimaryShard();
            while ((doc = postings.nextDoc()) != org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS) {
        }
                ) {
                        }  
                        );
                    if (ageDV != null && ageDV.advanceExact(doc)) {
        int prevInt = ((Number) prev).intValue();
            org.apache.lucene.index.LeafReader leaf = reader.leaves().get(0).reader();  
        return getClusterState().nodes().get(nodeId).getName();
                        DocumentInput.ROW_ID_FIELD
        );  
        String[] sortOrders,  
        CommitStats commitStats = shard.commitStats();
                int maxDoc = leaf.maxDoc();
        Path parquetDir = getParquetDir();
        return shard.shardPath().resolveIndex();
                            rowId
                        DocumentInput.ROW_ID_FIELD + " should be present in parquet row " + expectedRowId + " in " + file,  
     * field. Returns an array indexed by Lucene doc ID.
        String[] fieldNames,  
        Map<String, Object> prev,  
    }  
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name).get();
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
     * Returns negative if in correct order, zero if equal, positive if violated.
    }  
        }  
    protected void verifyParquetRowIdSequential(DataformatAwareCatalogSnapshot snapshot) throws Exception {
        for (Segment segment : snapshot.getSegments()) {
    }
        IndexShard shard = getPrimaryShard();  
import org.opensearch.common.util.FeatureFlags;
        }
import org.apache.lucene.store.Directory;
                    if (rowIdDV.advanceExact(doc)) {
                    )
    }
                long expectedRowId = 0;
                    rows = parser.list().stream().map(o -> {
                        rowId
                    }
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
        }  
    }
        Path parquetDir = getParquetDir();
                    }  
 * SPDX-License-Identifier: Apache-2.0
    // ══════════════════════════════════════════════════════════════════════
    @SuppressForbidden(reason = "JSON parsing for sort order verification")
                }
                assertEquals("name at lucene docId " + i, expectedNames[i], actual[i]);  
import org.opensearch.action.index.IndexResponse;
    protected void indexDocNullAge(String name) {  
                    }  
            String value = term.utf8ToString();
     * <p>
                        "Sort order violated at row " + i + " in " + file + ": prev=" + rows.get(i - 1) + " curr=" + rows.get(i),
                    for (Object obj : parser.list()) {
                            expectedRowId,  
                        } else {
            String[] actual = readKeywordValuesPerDoc(leaf, "name");  
                assertEquals("name mismatch at position " + i, pqName, luceneNames[i]);
                        if (prevName == null && currName != null) {  
                Path filePath = parquetDir.resolve(file);
            int cmp = compareValues(prevVal, currVal, isAsc, nullsFirst);  
                        @SuppressWarnings("unchecked")
            .put(super.nodeSettings(nodeOrdinal))
     */
        return indexService.getShard(0);
                    }
    protected void indexDoc(String name, int age, String tag) {
            // curr is null: violation if nullsFirst, correct if nullsLast
public class AbstractSortedRefreshIT extends OpenSearchIntegTestCase {
                    assertNotNull(
                    // When age is equal, verify name ASC (nulls last)  
            }
    @SuppressForbidden(reason = "JSON parsing for sort order verification")  
                    if (prevAgeVal == currAgeVal) {
     * Parquet row i and Lucene doc i agree on keyword fields ({@code name} and  
            }  
     * unsorted-path tests to confirm insertion order is preserved end-to-end.
        assertEquals("Total rows should match ingested docs", expectedTotalDocs, totalRows);
 * The OpenSearch Contributors require contributions made to  
                        "age should be DESC but found " + prevAgeVal + " before " + currAgeVal + " at row " + i + " in " + file,
                    XContentParser parser = JsonXContent.jsonXContent.createParser(  
        assertEquals(RestStatus.CREATED, response.status());  
     * Reconstructs the per-doc keyword value for the given field by iterating  
package org.opensearch.composite;
                List<Map<String, Object>> rows;
    @SuppressForbidden(reason = "JSON parsing for cross-format row alignment")
    }  
                        return m;  
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);  
        }  
                    Object currAge = rows.get(i).get("age");
                            + file,
            Object currVal = curr.get(fieldNames[f]);
                                ((String) prevName).compareTo((String) currName) <= 0  
 */  
        return values;  
                        @SuppressWarnings("unchecked")  
    }
        }
                String pqTag = (String) pq.get("tag");
    // ══════════════════════════════════════════════════════════════════════
    }
    }  
                try (  
                    rows = parser.list().stream().map(o -> {  
import org.opensearch.core.rest.RestStatus;
                        rowIdObj
            }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
 * compatible open source license.
    protected DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
                Long prevAge = null;  
        int currInt = ((Number) curr).intValue();  
                String json = RustBridge.readAsJson(filePath.toString());  
            Object prevVal = prev.get(fieldNames[f]);
        return isAsc ? natural : -natural;
     * The Lucene secondary writer only persists text/keyword fields (in the inverted  
                for (int doc = 0; doc < maxDoc; doc++) {
                try (
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                            assertTrue(
            for (int i = 0; i < parquetRows.size(); i++) {
            for (String file : wfs.files()) {
    protected void verifyParquetSortOrderMultiField(
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
                String pqName = (String) pq.get("name");  
    }  
                                + " but got "
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
                Map<String, Object> pq = parquetRows.get(i);
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            .build();
        List<Map<String, Object>> parquetRows = new ArrayList<>();
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        return Settings.builder()
        String nodeName = getNodeName();
                List<Map<String, Object>> rows;
            // prev is null: correct if nullsFirst, violation if nullsLast
        }
                for (Map<String, Object> row : rows) {  
    }
            client().admin().indices().prepareDelete(INDEX_NAME).get();
import org.opensearch.index.engine.CommitStats;  
    protected void verifyLuceneSortOrder() throws IOException {
import java.util.function.Function;
            }
                    )
                    int currAgeVal = ((Number) currAge).intValue();
                String json = RustBridge.readAsJson(filePath.toString());  
     * single-shard, single-segment index and asserts that at every position i,
                    if (prevAge == null) continue;
import java.nio.file.Path;
            for (LeafReaderContext ctx : reader.leaves()) {
                String json = RustBridge.readAsJson(filePath.toString());
                            fail("null age at doc " + doc + " came after non-null (expected nulls first)");  
        Path luceneDir = getLuceneDir();  
        for (Segment segment : snapshot.getSegments()) {  
        Path luceneDir = getLuceneDir();
                        return m;
                assertEquals("tag mismatch at position " + i, pqTag, luceneTags[i]);  
                long expectedRowId = 0;  
                    );
}  
                        age = ageDV.nextValue();
        }
            assertEquals("Test assumes a single Lucene leaf for sequential alignment", 1, reader.leaves().size());
import org.opensearch.action.admin.indices.flush.FlushResponse;  
     */  
                        json  
    }
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                for (int i = 1; i < rows.size(); i++) {
                    }).toList();
        org.apache.lucene.util.BytesRef term;  
                ) {
                        long rowId = rowIdDV.nextValue();  
                        } else if (prevAgeNull) {  
                        Map<String, Object> m = (Map<String, Object>) o;  
                        cmp <= 0  
        for (int f = 0; f < fieldNames.length; f++) {  
import org.apache.lucene.index.LeafReaderContext;
    // ══════════════════════════════════════════════════════════════════════  
     * (correct order), zero if equal, positive if prev comes after curr (violation).  
                        if (prevAgeNull && age == null) {
     * Supports any combination of ASC/DESC with configurable null placement.
    protected void verifyLuceneNamesInOrder(String[] expectedNames) throws IOException {
                    }).toList();
    protected Path getLuceneDir() {
            for (LeafReaderContext ctx : reader.leaves()) {
    protected int compareRowsByMultiField(
        assertNotNull("Lucene index should have field '" + fieldName + "' in inverted index", terms);
    }
                        Map<String, Object> row = (Map<String, Object>) obj;
        String[] fieldNames,
    /**  
    protected void verifyParquetAndLuceneRowsAlignedSequentially(DataformatAwareCatalogSnapshot snapshot) throws Exception {
                        NamedXContentRegistry.EMPTY,
                        json
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            assertEquals("Lucene doc count should match expected sequence length", expectedNames.length, actual.length);
                if (rows.size() <= 1) continue;  
    protected String[] getMapping() {
                    )
import org.opensearch.test.OpenSearchIntegTestCase;  
            assertNotNull("Segment should have parquet files", wfs);  
        return DataformatAwareCatalogSnapshot.deserializeFromString(  
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();  
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
    /**  
                }
                boolean prevAgeNull = true;
                        NamedXContentRegistry.EMPTY,  
import java.io.IOException;
            assertEquals("Test assumes a single Lucene leaf for sequential alignment", 1, reader.leaves().size());
                            // prev was null, current is non-null — ok (nulls first)
    protected Settings nodeSettings(int nodeOrdinal) {  
                }
            }
                    assertTrue(
import org.apache.lucene.index.DirectoryReader;
        assertEquals(RestStatus.OK, flushResponse.getStatus());  
            for (int i = 0; i < expectedNames.length; i++) {
            assertEquals("Parquet and Lucene must have same row count", parquetRows.size(), luceneNames.length);
            // index may not exist  
            for (String file : wfs.files()) {
                        // age DESC nulls first  
    }  
            org.apache.lucene.index.LeafReader leaf = reader.leaves().get(0).reader();
                        Object prevName = rows.get(i - 1).get("name");
        assertEquals(RestStatus.CREATED, response.status());
        assertNotNull(commitStats);  
     * value.
            boolean nullsFirst = "_first".equals(sortMissing[f]);
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
    // Helpers: verification
    /**
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(getMapping()).get();  
    protected String[] readKeywordValuesPerDoc(org.apache.lucene.index.LeafReader leaf, String fieldName) throws IOException {
import org.opensearch.index.shard.IndexShard;
/*  
        } catch (Exception e) {
    /**
                            + " in "
                        } else if (age == null) {
     */  
                        json
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);  
    protected IndexShard getPrimaryShard() {
        super.tearDown();
                                + expectedRowId
                }
    }  
                                + " should be sequential, expected "  
import java.util.List;  
            String[] luceneNames = readKeywordValuesPerDoc(leaf, "name");
        String[] sortMissing
        try {  
import org.opensearch.core.xcontent.DeprecationHandler;
            Function.identity()
            for (String file : wfs.files()) {
     * row ID rewrite correctly co-locates non-sort fields across formats too.
import java.util.Map;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, getNodeName());
    protected static final String INDEX_NAME = "test-composite-refresh-sorted";  
        Map<String, Object> curr,
 * this file be licensed under the Apache-2.0 license or a
     * {@code tag}).
        String[] values = new String[leaf.maxDoc()];
                try (
        assertTrue(commitStats.getUserData().containsKey(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY));
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {  
    protected String getNodeName() {
                        fail("age null should come before non-null at row " + i);
import org.opensearch.common.xcontent.json.JsonXContent;  
                    )  
                    prevAgeNull = (age == null);  
    protected void createIndex(Settings settings) {
                    assertTrue(
     * the inverted index. Each doc is expected to have at most one term for the
        Path parquetDir = getParquetDir();
        Path luceneDir = getLuceneDir();
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
            if (cmp != 0) return cmp;
                        Map<String, Object> m = (Map<String, Object>) o;
                        expectedRowId,  
                if (maxDoc <= 1) continue;
        assertNotNull(commitStats.getUserData());
                }
    protected void verifyParquetRowCount(DataformatAwareCatalogSnapshot snapshot, int expectedTotalDocs) throws IOException {
                        NamedXContentRegistry.EMPTY,
import org.opensearch.parquet.bridge.RustBridge;
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name, "age", age, "tag", tag).get();
 *
                Path filePath = parquetDir.resolve(file);
import org.opensearch.index.engine.dataformat.DocumentInput;
import java.util.ArrayList;
                    rows = parser.list().stream().map(o -> {  
                            DocumentInput.ROW_ID_FIELD
     * Compares two nullable integer values according to sort direction and null placement.
     * index) and {@code __row_id__} (as doc values). Numeric fields like {@code age}
                    long rowId = ((Number) rowIdObj).longValue();  
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        while ((term = it.next()) != null) {
                    Object rowIdObj = row.get(DocumentInput.ROW_ID_FIELD);
        }
                        }
    protected void verifyParquetSortOrder(DataformatAwareCatalogSnapshot snapshot) throws Exception {  
                    if (currAge == null) {  
    protected int compareValues(Object prev, Object curr, boolean isAsc, boolean nullsFirst) {
import org.apache.lucene.store.NIOFSDirectory;
        return 0;  
                        return m;  
                if (rows.size() <= 1) continue;  
                    );
    // Helpers: accessors
        ensureGreen(INDEX_NAME);
                    expectedRowId++;  
                ) {  
                String json = RustBridge.readAsJson(parquetDir.resolve(file).toString());  
        org.apache.lucene.index.TermsEnum it = terms.iterator();
            }
     * are intentionally NOT stored in the Lucene secondary — they live only in
            org.apache.lucene.index.PostingsEnum postings = it.postings(null);  
        int natural = Integer.compare(prevInt, currInt);
                            + expectedRowId
    ) throws Exception {  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
    }
        if (prev == null && curr == null) return 0;
                            + " but got "
    }
                    Long age = null;  
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        // Read Parquet rows in physical order  
                    prevAge = age;
    protected void verifyLuceneRowIdSequential() throws IOException {
        for (Segment segment : snapshot.getSegments()) {  
    }
import org.opensearch.index.engine.exec.Segment;
                }
        IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", name, "age", age).get();  
        for (Segment segment : snapshot.getSegments()) {
        for (Segment segment : snapshot.getSegments()) {
import org.opensearch.common.settings.Settings;
                            + rowId  
        if (curr == null) {
                        }
    }  
import org.opensearch.core.xcontent.XContentParser;
                        @SuppressWarnings("unchecked")
                org.apache.lucene.index.LeafReader leaf = ctx.reader();  
            }  
                SortedNumericDocValues ageDV = leaf.getSortedNumericDocValues("age");
    // ══════════════════════════════════════════════════════════════════════  
    protected Path getParquetDir() {  
     * Parquet. Keyword fields are also stored only in the inverted index (no doc  
            }  
        }
                        Object currName = rows.get(i).get("name");  
     * The {@code tag} field is NOT part of the sort key — verifying it confirms the
                                + rowId  
            assertEquals("Lucene doc count should match", expectedTotalDocs, reader.numDocs());
            }
    ) {
        Path parquetDir = getParquetDir();
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {  
     * Verifies that the Lucene segment is physically sorted by the configured IndexSort
                    int cmp = compareRowsByMultiField(rows.get(i - 1), rows.get(i), fieldNames, sortOrders, sortMissing);  
        }
    }  
     * Reads Parquet rows and Lucene documents in physical (storage) order from the
                    int prevAgeVal = ((Number) prevAge).intValue();
        IndexShard shard = indexService.getShard(0);
                        prevAgeVal >= currAgeVal  
