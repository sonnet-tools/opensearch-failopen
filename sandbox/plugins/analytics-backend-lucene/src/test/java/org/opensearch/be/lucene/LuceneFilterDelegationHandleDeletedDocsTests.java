import java.lang.foreign.ValueLayout;  
import org.opensearch.index.mapper.MappedFieldType;  
    }
    }
        buildIndex(1000, i -> false); // no deletions → raw scorer, liveDocs == null (no per-doc filtering)  
        FixedBitSet fixed = BitSetIterator.getFixedBitSetOrNull(((LiveDocs) liveDocs).liveDocsIterator());
 * compatible open source license.
            mockQueryShardContext(),  
        int wordCount = (span + 63) >>> 6;  
            if (i % 2 == 0 && i % 4 != 0) {  
        return reader.leaves().get(0).reader();
import org.opensearch.index.query.TermQueryBuilder;  
import org.apache.lucene.util.BitSetIterator;
    }  
    // ── match-all provider: fillLiveDocsWords fast path ──  
            if (i % 2 == 0) { // all tag=hello docs match and are live  
            }
import java.util.Map;
            out.writeNamedWriteable(new TermQueryBuilder(field, value));
    }
        buildIndex(1000, deleted::contains);
    private Set<Integer> collectAll(LuceneFilterDelegationHandle handle, int annotationId) {
    private void assertDenseLiveDocs() {
    private Set<Integer> liveDocIds() {
    private static final String PREDICATE_TAG = "hello";
import static org.opensearch.analytics.spi.FilterDelegationHandle.LIVE_DOCS_MATCH_ALL_ANNOTATION_ID;
import org.apache.lucene.index.SegmentReader;  
import static org.mockito.ArgumentMatchers.any;
            directory.close();  
                }
        buildIndex(1000, i -> i % 4 == 0); // dense → copyLiveWords word-copy path
        LuceneFilterDelegationHandle handle = newHandle(List.of());  
import java.util.List;
    public void testPredicateExcludesDeletedDocsForDenseDeletions() throws Exception {  
            }
            List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new))
    }
    /** Run collectDocs for {@code [minDoc, maxDoc)} and return the absolute doc ids it set. */  
                expected.add(i);
        buildIndex(1000, i -> i % 4 == 0); // 25% deleted → dense  
        return new LuceneFilterDelegationHandle(
        return live;  
        LuceneFilterDelegationHandle handle = newHandle(List.of());
import java.util.Set;  
    }
        MappedFieldType fieldType = mock(MappedFieldType.class);
    private static final int PREDICATE_ANNOTATION_ID = 1;  
        if (directory != null) {
            }
        }
    private static DelegatedExpression termExpression(int annotationId, String field, String value) throws IOException {
            if (liveDocs == null || liveDocs.get(i)) {
        assertNull("no deletions should leave liveDocs null", leaf().getLiveDocs());
    }  
        assertDenseLiveDocs();
        int providerKey = handle.createProvider(PREDICATE_ANNOTATION_ID);
 * (createProvider → createCollector → collectDocs) over a real index with deletions:
            if (i % 2 == 0 && i % 4 != 0) { // matches tag=hello and is live
import org.opensearch.test.OpenSearchTestCase;
        LuceneFilterDelegationHandle handle = newHandle(List.of());  
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
        }  
import org.apache.lucene.util.BytesRef;
        FixedBitSet fixed = BitSetIterator.getFixedBitSetOrNull(((LiveDocs) liveDocs).liveDocsIterator());
            reader.close();  
}  
    }
        int half = leaf().maxDoc() / 2;  
    private void buildIndex(int numDocs, IntPredicate deleteIf) throws IOException {  
        assertDenseLiveDocs();
                if ((word & (1L << (rel & 63))) != 0) {
            writer.close();  
    @Override  
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.index.Term;
                writer.deleteDocuments(new Term("id", Integer.toString(i)));
        Set<Integer> expected = new TreeSet<>();
import java.io.IOException;  
    private LuceneFilterDelegationHandle newHandle(List<DelegatedExpression> expressions) {
import org.apache.lucene.index.LeafReader;
    }
        for (int i = 0; i < 1000; i++) {
import org.apache.lucene.document.StringField;  
        writer.commit();
            }  
        NamedWriteableRegistry registry = new NamedWriteableRegistry(
    public void tearDown() throws Exception {
            mock(CatalogSnapshot.class),
        assertEquals(liveDocIds(), collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));
        assertSparseLiveDocs();
import org.opensearch.analytics.spi.DelegatedExpression;
        LuceneFilterDelegationHandle handle = newHandle(List.of());
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
        collected.addAll(collectRange(handle, collectorKey, half, leaf().maxDoc()));
import org.apache.lucene.search.TermQuery;
        String segName = ((SegmentReader) leaf()).getSegmentInfo().info.name;
                expected.add(i);
        }
        buildIndex(300, i -> false);
    // ── predicate provider: scorer path excludes deleted docs ──
    }
            }  
        Set<Integer> deleted = Set.of(2, 6, 10); // even (matching) docs, 0.3% → sparse; raw scorer + per-doc liveDocs.get  
 *       raw scorer with per-doc {@code liveDocs.get} (sparse) — asserting deleted docs are excluded.
        }
        super.tearDown();
        for (int i = 0; i < leaf().maxDoc(); i++) {
 * <p>Deletion density is chosen to force Lucene's live-docs representation: {@code SPARSE_DENSE_THRESHOLD}
import org.apache.lucene.util.FixedBitSet;
            assertTrue("collectDocs signalled an error", ret != -1);
import org.apache.lucene.store.ByteBuffersDirectory;  
import org.apache.lucene.index.IndexWriterConfig;  
public class LuceneFilterDelegationHandleDeletedDocsTests extends OpenSearchTestCase {  
import java.lang.foreign.MemorySegment;
    }
            all.add(i);
        // NoMergePolicy keeps a single segment and prevents a merge from dropping deleted docs, so the
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
        assertSparseLiveDocs();
import static org.mockito.Mockito.mock;  
            doc.add(new StringField("tag", i % 2 == 0 ? PREDICATE_TAG : "goodbye", Field.Store.NO));
            return new DelegatedExpression(annotationId, "lucene", BytesReference.toBytes(out.bytes()));
import org.opensearch.index.query.QueryBuilder;
        );
    private void assertSparseLiveDocs() {
    public void testPredicateWithoutDeletionsCollectsAllMatches() throws Exception {
    }  
import org.apache.lucene.index.IndexWriter;
 *  
        // Two sequential sub-ranges over one collector must together cover the full live match set,
 * Exercises {@link LuceneFilterDelegationHandle}'s deleted-doc filtering through its public API
        Set<Integer> expected = new TreeSet<>();
        // with no doc dropped or double-counted at the boundary (exercises the persisted currentDoc).
        buildIndex(1000, i -> i == 3 || i == 250 || i == 777); // 0.3% deleted → sparse
        int from = 70;  
    private static QueryShardContext mockQueryShardContext() {  
        assertNotNull("dense deletions must expose a FixedBitSet-backed live set", fixed);
import org.opensearch.index.query.QueryShardContext;
        }
        writer = new IndexWriter(directory, new IndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE));
        }  
        for (int i = 0; i < 1000; i++) {  
        for (int i : liveDocIds()) {
        Set<Integer> collected = new TreeSet<>(collectRange(handle, collectorKey, 0, half));
        int span = maxDoc - minDoc;
    private LeafReader leaf() {  
        assertEquals(expected, collectRange(handle, collectorKey, from, leaf().maxDoc()));
            Object value = invocation.getArgument(0);  
    public void testPredicateExcludesDeletedDocsForSparseDeletions() throws Exception {
import java.lang.foreign.Arena;
            BytesRef term = value instanceof BytesRef ref ? ref : new BytesRef(value.toString());
        try (Arena arena = Arena.ofConfined()) {
        // codec's live-docs format, producing the dense/sparse LiveDocs the handle branches on.
import static org.mockito.Mockito.when;
    private DirectoryReader reader;
import org.apache.lucene.util.LiveDocs;  
import org.apache.lucene.store.Directory;
                live.add(i);  
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
            MemorySegment out = arena.allocate((long) wordCount * Long.BYTES);  
    }
        assertNull("sparse deletions must not expose a FixedBitSet-backed live set", fixed);  
        });  
        }
        int providerKey = handle.createProvider(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID);
    }  
        }  
        assertEquals(liveDocIds(), collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));  
        }
        reader = DirectoryReader.open(directory);
        Bits liveDocs = leaf().getLiveDocs();  
    }
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
        assertNull("no deletions should leave liveDocs null", leaf().getLiveDocs());  
            expressions,
    public void testMatchAllCopyLiveWordsHandlesUnalignedOffset() throws Exception {  
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));  
/*  
        Set<Integer> collected = new TreeSet<>();
 *
    public void testMatchAllEmitsLiveDocsForDenseDeletions() throws Exception {
import java.util.TreeSet;
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    /** createProvider + createCollector over the whole leaf, then collectDocs. */
        LuceneReader luceneReader = new LuceneReader(reader, Map.of(1L, segName));  
    /** Docs the segment considers live (all docs when there are no deletions). */  
        Bits liveDocs = leaf().getLiveDocs();  
import java.util.function.IntPredicate;
        Set<Integer> expected = new TreeSet<>();
import org.apache.lucene.document.Field;
    /** Resolves field {@code tag} to a TermQuery, mirroring how a delegated TermQueryBuilder compiles. */
        writer.commit();
 * </ul>  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));  
    }
import org.apache.lucene.util.Bits;  
        // A sub-range starting mid-word (70 & 63 == 6) forces copyLiveWords' bit-shift branch, not the
        buildIndex(1000, i -> i % 4 == 0); // dense
        return collected;
 */  
        assertEquals("test assumes a single segment", 1, reader.leaves().size());  
        assertEquals(expected, collected);
 * is 1%, so &gt;1% deleted yields a {@code FixedBitSet}-backed dense representation (recoverable via  
        QueryShardContext qsc = mock(QueryShardContext.class);
            if (i >= from) {  
        for (int i = 0; i < numDocs; i++) {
        buildIndex(1000, i -> i % 4 == 0); // 25% deleted → dense; docsIterator intersects with the live FixedBitSet
 * {@link BitSetIterator#getFixedBitSetOrNull}) and ≤1% yields a sparse one.
        // reopened reader exposes their liveDocs.  
        assertDenseLiveDocs();
                long word = out.getAtIndex(ValueLayout.JAVA_LONG, rel >>> 6);
            }
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
 * <ul>
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));
        Set<Integer> expected = new TreeSet<>();
            if (deleteIf.test(i)) {
            () -> false
        int providerKey = handle.createProvider(annotationId);  
    public void testPredicateIterationIsStatefulAcrossRanges() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            writer.addDocument(doc);  
        }  
                expected.add(i);
        Set<Integer> all = new TreeSet<>();
        }
        Bits liveDocs = leaf().getLiveDocs();
                expected.add(i);
            long ret = handle.collectDocs(collectorKey, minDoc, maxDoc, out);
            for (int rel = 0; rel < span; rel++) {  
        // aligned fast copy — asserts the shift + trailing mask are correct.
        assertTrue("createProvider failed", providerKey > 0);
        when(qsc.fieldMapper("tag")).thenReturn(fieldType);
        }  
    private Set<Integer> collectRange(LuceneFilterDelegationHandle handle, int collectorKey, int minDoc, int maxDoc) {
            doc.add(new StringField("id", Integer.toString(i), Field.Store.NO));
                    collected.add(minDoc + rel);  
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
        return qsc;
        for (int i = 0; i < numDocs; i++) {  
 *   <li>the reserved match-all provider's live-docs fast path ({@code fillLiveDocsWords}) for dense,
    /** Index {@code numDocs} docs (field {@code tag} = hello for even ids, goodbye otherwise), then delete by id. */
package org.opensearch.be.lucene;
    public void testMatchAllEmitsLiveDocsForSparseDeletions() throws Exception {  
            luceneReader,
                expected.add(i);
        assertTrue("createCollector failed", collectorKey > 0);  
 * this file be licensed under the Apache-2.0 license or a
            }
        return collectRange(handle, collectorKey, 0, leaf().maxDoc());
    private IndexWriter writer;  
        assertTrue("expected a LiveDocs representation", liveDocs instanceof LiveDocs);
        Set<Integer> expected = new TreeSet<>();
 *   <li>a delegated predicate's scorer path — the {@code scorer ∩ liveDocs} intersection (dense) and the
    private Directory directory;
            registry,  
    }
        for (int i = 0; i < 1000; i++) {
    public void testMatchAllEmitsAllDocsWithoutDeletions() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        Set<Integer> live = new TreeSet<>();
            Document doc = new Document();  
 *       sparse, and no-deletion segments, and  
            return new TermQuery(new Term("tag", term));
import org.apache.lucene.index.DirectoryReader;
        assertEquals(all, collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));  
            }  
        if (reader != null) {
        directory = new ByteBuffersDirectory();
        );  
        }
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));  
            if (i % 2 == 0 && deleted.contains(i) == false) {
        // Open from the committed directory (not the writer) so liveDocs are read back through the  
            // The deserialized value arrives as a BytesRef; use it as the term bytes directly rather
        for (int i = 0; i < 1000; i++) {  
 */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        when(fieldType.termQuery(any(), any())).thenAnswer(invocation -> {  
    }  
        if (writer != null) {
        for (int i = 0; i < 300; i++) {  
import org.opensearch.core.common.bytes.BytesReference;  
/**  
    }  
            // than via toString() (which yields the hex form and would never match the indexed term).
        assertTrue("expected a LiveDocs representation", liveDocs instanceof LiveDocs);  
import org.apache.lucene.document.Document;
