 */
 *
            assertTrue("collectDocs signalled an error", ret != -1);
import org.apache.lucene.util.LiveDocs;
        LuceneFilterDelegationHandle handle = newHandle(List.of());
import org.apache.lucene.document.Field;
    public void testMatchAllEmitsLiveDocsForDenseDeletions() throws Exception {
        if (directory != null) {
        for (int i = 0; i < 1000; i++) {
        assertEquals("test assumes a single segment", 1, reader.leaves().size());
            if (deleteIf.test(i)) {
        Bits liveDocs = leaf().getLiveDocs();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.SegmentReader;
                expected.add(i);
        FixedBitSet fixed = BitSetIterator.getFixedBitSetOrNull(((LiveDocs) liveDocs).liveDocsIterator());
        Set<Integer> collected = new TreeSet<>(collectRange(handle, collectorKey, 0, half));
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
    }
                expected.add(i);
        // with no doc dropped or double-counted at the boundary (exercises the persisted currentDoc).
import org.apache.lucene.index.LeafReader;
        assertTrue("expected a LiveDocs representation", liveDocs instanceof LiveDocs);
        QueryShardContext qsc = mock(QueryShardContext.class);
import java.lang.foreign.Arena;
    }
import org.apache.lucene.document.Document;
        Set<Integer> expected = new TreeSet<>();
        FixedBitSet fixed = BitSetIterator.getFixedBitSetOrNull(((LiveDocs) liveDocs).liveDocsIterator());
 * <ul>
    /** Index {@code numDocs} docs (field {@code tag} = hello for even ids, goodbye otherwise), then delete by id. */
                writer.deleteDocuments(new Term("id", Integer.toString(i)));
package org.opensearch.be.lucene;
    }
            doc.add(new StringField("id", Integer.toString(i), Field.Store.NO));
    /** Run collectDocs for {@code [minDoc, maxDoc)} and return the absolute doc ids it set. */
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
            out.writeNamedWriteable(new TermQueryBuilder(field, value));
            reader.close();
 *   <li>a delegated predicate's scorer path — the {@code scorer ∩ liveDocs} intersection (dense) and the
    }
        }
            writer.close();
 *   <li>the reserved match-all provider's live-docs fast path ({@code fillLiveDocsWords}) for dense,
import org.apache.lucene.index.NoMergePolicy;
 *       raw scorer with per-doc {@code liveDocs.get} (sparse) — asserting deleted docs are excluded.
        buildIndex(300, i -> false);
    private static final int PREDICATE_ANNOTATION_ID = 1;
import org.apache.lucene.util.BytesRef;
    private LuceneFilterDelegationHandle newHandle(List<DelegatedExpression> expressions) {
        try (Arena arena = Arena.ofConfined()) {
        buildIndex(1000, i -> false); // no deletions → raw scorer, liveDocs == null (no per-doc filtering)
                live.add(i);
    // ── predicate provider: scorer path excludes deleted docs ──
        }
            directory.close();
    private void assertDenseLiveDocs() {
        for (int i = 0; i < 1000; i++) {
import org.apache.lucene.index.IndexWriter;
        return collected;
                long word = out.getAtIndex(ValueLayout.JAVA_LONG, rel >>> 6);
    private Set<Integer> liveDocIds() {
    private Set<Integer> collectRange(LuceneFilterDelegationHandle handle, int collectorKey, int minDoc, int maxDoc) {
            Document doc = new Document();
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));
 * <p>Deletion density is chosen to force Lucene's live-docs representation: {@code SPARSE_DENSE_THRESHOLD}
        assertEquals(all, collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));
import java.util.TreeSet;
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
    /** Docs the segment considers live (all docs when there are no deletions). */
import org.opensearch.index.query.QueryBuilder;
            long ret = handle.collectDocs(collectorKey, minDoc, maxDoc, out);
            writer.addDocument(doc);
            mockQueryShardContext(),
        Set<Integer> expected = new TreeSet<>();
        assertNull("no deletions should leave liveDocs null", leaf().getLiveDocs());
import org.apache.lucene.index.Term;
            luceneReader,
        buildIndex(1000, i -> i % 4 == 0); // dense
            return new DelegatedExpression(annotationId, "lucene", BytesReference.toBytes(out.bytes()));
    private DirectoryReader reader;
/**
        Set<Integer> expected = new TreeSet<>();
        int span = maxDoc - minDoc;
        }
        when(fieldType.termQuery(any(), any())).thenAnswer(invocation -> {
            List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new))
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));
 *
        for (int i = 0; i < leaf().maxDoc(); i++) {
            () -> false
                    collected.add(minDoc + rel);
import org.apache.lucene.store.Directory;
import org.opensearch.test.OpenSearchTestCase;
        return new LuceneFilterDelegationHandle(
        NamedWriteableRegistry registry = new NamedWriteableRegistry(
            if (i % 2 == 0 && i % 4 != 0) {
        LuceneFilterDelegationHandle handle = newHandle(List.of());
        assertTrue("expected a LiveDocs representation", liveDocs instanceof LiveDocs);
        }
        buildIndex(1000, deleted::contains);
import java.util.Set;
        for (int i = 0; i < 300; i++) {
    }
        );
        LuceneFilterDelegationHandle handle = newHandle(List.of());
        }
    }
        // reopened reader exposes their liveDocs.
        int half = leaf().maxDoc() / 2;
            if (i >= from) {
 * Exercises {@link LuceneFilterDelegationHandle}'s deleted-doc filtering through its public API
    @Override
import static org.mockito.Mockito.when;
        }
import static org.mockito.ArgumentMatchers.any;
        writer.commit();
    }
        int providerKey = handle.createProvider(PREDICATE_ANNOTATION_ID);
 * compatible open source license.
    }
    public void testPredicateWithoutDeletionsCollectsAllMatches() throws Exception {
import java.util.function.IntPredicate;
        for (int i = 0; i < numDocs; i++) {
        }
                expected.add(i);
    public void tearDown() throws Exception {
        // Two sequential sub-ranges over one collector must together cover the full live match set,
        }
        assertTrue("createCollector failed", collectorKey > 0);
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
    private LeafReader leaf() {
}
    private static DelegatedExpression termExpression(int annotationId, String field, String value) throws IOException {
 * is 1%, so &gt;1% deleted yields a {@code FixedBitSet}-backed dense representation (recoverable via
    }
        Set<Integer> expected = new TreeSet<>();
        });
        assertDenseLiveDocs();
    }
        assertSparseLiveDocs();
        }
        return qsc;
import org.apache.lucene.util.BitSetIterator;
        buildIndex(1000, i -> i == 3 || i == 250 || i == 777); // 0.3% deleted → sparse
        when(qsc.fieldMapper("tag")).thenReturn(fieldType);
import java.util.Map;
        assertEquals(liveDocIds(), collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));
        int from = 70;
    }
import org.apache.lucene.util.FixedBitSet;
            }
        assertTrue("createProvider failed", providerKey > 0);
                }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        String segName = ((SegmentReader) leaf()).getSegmentInfo().info.name;
                if ((word & (1L << (rel & 63))) != 0) {
    public void testMatchAllEmitsLiveDocsForSparseDeletions() throws Exception {
            if (i % 2 == 0) { // all tag=hello docs match and are live
        LuceneReader luceneReader = new LuceneReader(reader, Map.of(1L, segName));
            return new TermQuery(new Term("tag", term));
        for (int i : liveDocIds()) {
    // ── match-all provider: fillLiveDocsWords fast path ──
        int providerKey = handle.createProvider(annotationId);
    /** Resolves field {@code tag} to a TermQuery, mirroring how a delegated TermQueryBuilder compiles. */
            }
    public void testMatchAllEmitsAllDocsWithoutDeletions() throws Exception {
import org.apache.lucene.search.TermQuery;
 * The OpenSearch Contributors require contributions made to
        return collectRange(handle, collectorKey, 0, leaf().maxDoc());
            }
        assertEquals(expected, collectRange(handle, collectorKey, from, leaf().maxDoc()));
        buildIndex(1000, i -> i % 4 == 0); // 25% deleted → dense; docsIterator intersects with the live FixedBitSet
    private static QueryShardContext mockQueryShardContext() {
        assertEquals(liveDocIds(), collectAll(handle, LIVE_DOCS_MATCH_ALL_ANNOTATION_ID));
    public void testPredicateExcludesDeletedDocsForDenseDeletions() throws Exception {
import java.util.List;
import org.opensearch.core.common.bytes.BytesReference;
        buildIndex(1000, i -> i % 4 == 0); // dense → copyLiveWords word-copy path
        LuceneFilterDelegationHandle handle = newHandle(List.of());
    public void testPredicateIterationIsStatefulAcrossRanges() throws Exception {
        assertSparseLiveDocs();
        // codec's live-docs format, producing the dense/sparse LiveDocs the handle branches on.
    private void buildIndex(int numDocs, IntPredicate deleteIf) throws IOException {
import org.apache.lucene.index.DirectoryReader;
        }
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            for (int rel = 0; rel < span; rel++) {
            mock(CatalogSnapshot.class),
 *
        }
public class LuceneFilterDelegationHandleDeletedDocsTests extends OpenSearchTestCase {
                expected.add(i);
        Set<Integer> expected = new TreeSet<>();
            // The deserialized value arrives as a BytesRef; use it as the term bytes directly rather
    public void testPredicateExcludesDeletedDocsForSparseDeletions() throws Exception {
        Set<Integer> collected = new TreeSet<>();
import static org.opensearch.analytics.spi.FilterDelegationHandle.LIVE_DOCS_MATCH_ALL_ANNOTATION_ID;
    }
    private IndexWriter writer;
        MappedFieldType fieldType = mock(MappedFieldType.class);
import org.opensearch.index.mapper.MappedFieldType;
        // aligned fast copy — asserts the shift + trailing mask are correct.
        // Open from the committed directory (not the writer) so liveDocs are read back through the
            doc.add(new StringField("tag", i % 2 == 0 ? PREDICATE_TAG : "goodbye", Field.Store.NO));
            MemorySegment out = arena.allocate((long) wordCount * Long.BYTES);
            registry,
        }
    /** createProvider + createCollector over the whole leaf, then collectDocs. */
import org.apache.lucene.util.Bits;
        }
    public void testMatchAllCopyLiveWordsHandlesUnalignedOffset() throws Exception {
            if (i % 2 == 0 && deleted.contains(i) == false) {
import org.apache.lucene.document.StringField;
        int providerKey = handle.createProvider(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID);
    private Directory directory;
        int wordCount = (span + 63) >>> 6;
            }
        Set<Integer> live = new TreeSet<>();
        );
        assertEquals(expected, collected);
import static org.mockito.Mockito.mock;
    private static final String PREDICATE_TAG = "hello";
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.index.query.QueryShardContext;
            }
        assertEquals(expected, collectAll(handle, PREDICATE_ANNOTATION_ID));
            }
        directory = new ByteBuffersDirectory();
        Set<Integer> deleted = Set.of(2, 6, 10); // even (matching) docs, 0.3% → sparse; raw scorer + per-doc liveDocs.get
            all.add(i);
                expected.add(i);
import java.lang.foreign.MemorySegment;
 *       sparse, and no-deletion segments, and
        if (writer != null) {
            if (liveDocs == null || liveDocs.get(i)) {
    }
    private Set<Integer> collectAll(LuceneFilterDelegationHandle handle, int annotationId) {
        reader = DirectoryReader.open(directory);
        Bits liveDocs = leaf().getLiveDocs();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.DelegatedExpression;
        Set<Integer> all = new TreeSet<>();
        return live;
            expressions,
            // than via toString() (which yields the hex form and would never match the indexed term).
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));
        assertNull("no deletions should leave liveDocs null", leaf().getLiveDocs());
            BytesRef term = value instanceof BytesRef ref ? ref : new BytesRef(value.toString());
        assertDenseLiveDocs();
            }
        }
 * (createProvider → createCollector → collectDocs) over a real index with deletions:
 */
        int collectorKey = handle.createCollector(providerKey, 1L, 0, leaf().maxDoc());
        writer = new IndexWriter(directory, new IndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE));
    }
        if (reader != null) {
        for (int i = 0; i < 1000; i++) {
        return reader.leaves().get(0).reader();
    }
        LuceneFilterDelegationHandle handle = newHandle(List.of(termExpression(PREDICATE_ANNOTATION_ID, "tag", PREDICATE_TAG)));
 * </ul>
        buildIndex(1000, i -> i % 4 == 0); // 25% deleted → dense
        // NoMergePolicy keeps a single segment and prevents a merge from dropping deleted docs, so the
import java.io.IOException;
import java.lang.foreign.ValueLayout;
    }
        super.tearDown();
/*
        collected.addAll(collectRange(handle, collectorKey, half, leaf().maxDoc()));
    }
        writer.commit();
    private void assertSparseLiveDocs() {
        assertNotNull("dense deletions must expose a FixedBitSet-backed live set", fixed);
            if (i % 2 == 0 && i % 4 != 0) { // matches tag=hello and is live
 * {@link BitSetIterator#getFixedBitSetOrNull}) and ≤1% yields a sparse one.
import org.apache.lucene.store.ByteBuffersDirectory;
        Bits liveDocs = leaf().getLiveDocs();
    }
        for (int i = 0; i < numDocs; i++) {
            }
    }
        // A sub-range starting mid-word (70 & 63 == 6) forces copyLiveWords' bit-shift branch, not the
            Object value = invocation.getArgument(0);
        assertNull("sparse deletions must not expose a FixedBitSet-backed live set", fixed);
        for (int i = 0; i < 1000; i++) {
        assertDenseLiveDocs();
