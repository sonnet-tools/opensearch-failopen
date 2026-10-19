import java.lang.foreign.MemorySegment;  
        scorersByCollectorKey.clear();  
        int span = maxDoc - minDoc;
    }  
                "[scf] createCollector providerKey={} writerGeneration={} range=[{},{}) → collectorKey={}",  
        long[] words = bits.getBits();  
            LOGGER.debug(  
     * non-null {@code liveDocs} is a {@link LiveDocs} (the codec contract for a segment with deletions).
import org.apache.lucene.search.IndexSearcher;
        if (query == null) {
        // Deleted-doc filtering: always register the reserved match-all query (even when
        if (segName == null) {  
                try {
                minDoc,  
import java.io.IOException;
            + maxDoc  
        // IndicesQueryCache wired in, so repeated delegated predicates populate + hit the shard query  
            + ", writerGeneration="
    LuceneFilterDelegationHandle(  
     * raw scorer and drops deleted docs per-doc via {@code liveDocs.get}.
                "createCollector: segment name [{}] not found in leaves (writerGeneration={}, providerKey={})",  
     * Copy the LIVE-docs slice {@code [effectiveMinDoc, effectiveMinDoc + span)} of a  
    @Override
            scorersByCollectorKey.put(  
import org.apache.lucene.search.ScoreMode;
        String segName = generationToSegmentName.get(writerGeneration);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
    private final ConcurrentHashMap<Integer, ScorerHandle> scorersByCollectorKey = new ConcurrentHashMap<>();  
                long hi = (startWord + i + 1 < srcWords.length) ? srcWords[startWord + i + 1] << (64 - bitOffset) : 0L;  
import org.apache.lucene.util.FixedBitSet;  
                    // which would make callers skip all subsequent RGs for this leaf.  
                nextDoc = handle.currentDoc;
            LOGGER.error(
            return -1;  
            + ") exceeds leaf maxDoc="
            LOGGER.debug("[scf] createProvider annotationId={} → providerKey={}", annotationId, providerKey);  
    }
                liveDocsProviderKeys.add(providerKey);
                    matchAllProvider,
                queries.put(expr.getAnnotationId(), query);
        }
        LiveDocs ld = (LiveDocs) liveDocs;
 */  
                    liveIntersection == null ? scorer : null,  
            // liveDocs for the fast path.
     *
                    List.of(new BitSetIterator(liveBits, liveBits.cardinality()), scorer.iterator())
import java.util.concurrent.ConcurrentHashMap;
 * The OpenSearch Contributors require contributions made to  
    // every delegated expression is compiled (QueryBuilder → Lucene Query) at  
     * (FixedBitSet invariant), and only the final word can hold bits beyond {@code span} — the
        ) {
/*  
            + minDoc
            if (scanFrom < scanTo) {
        final int partitionMinDoc;
        QueryShardContext context,
        ScorerHandle(  
            this.partitionMinDoc = partitionMinDoc;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
    ) {  
    // fine. For performance-delegated predicates that DF page-pruning may never
        final boolean matchAllProvider;
                            docId = iterator.nextDoc();
                QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);  
            return 0;  
            + leafMaxDoc;
        long[] srcWords = fbs.getBits();
                        while (docId != DocIdSetIterator.NO_MORE_DOCS && docId < scanTo) {  
        LeafReader current = reader;
        this.searcher = luceneReader.searcher(null, null);
import org.opensearch.analytics.spi.FilterDelegationHandle;  
        FixedBitSet bits = new FixedBitSet(span);
     * skips the deleted majority. Returns {@code null} when there's nothing to pre-filter — no scorer,
                    exception  
        /** Persistent scorer ∩ live-docs conjunction for dense-delete leaves; {@code null} → walk the raw scorer + liveDocs.get. */
    public void releaseProvider(int providerKey) {
                writerGeneration,  
            LOGGER.error(  
    }  
        } catch (IOException exception) {
        }  
                exception
    /**
 *
        // (LuceneAnalyticsBackendPlugin#getFilterDelegationHandle passes the cache + policy); later
     * <p>Over-copy is safe without per-word clearing: bits past {@code fbs.length()} are 0  
    }
        }
            // exhausts, so nextDoc = maxDoc.  
 * {@code generation → Lucene leaf index} is provided by {@link LuceneReader}, which is
        } else {  
            while (doc != DocIdSetIterator.NO_MORE_DOCS && doc < maxDoc) {
            );  
    ) {
    /** Provider keys created from {@link #LIVE_DOCS_MATCH_ALL_ANNOTATION_ID} — collectDocs takes the live-docs fast path. */
                out.setAtIndex(ValueLayout.JAVA_LONG, w, cur & ~(1L << (rel & 63)));  
                    if (docId != DocIdSetIterator.NO_MORE_DOCS) {
        fillAllAliveWords(out, span, wordCount);  
        if (leaf == null) {
                    "Failed to deserialize delegated expression for annotationId=" + expr.getAnnotationId(),
    public boolean isCancelled() {
        }
        // `expressions` is empty) so its collector can emit the segment's live docs. A single map
        // searcher (vs a fresh plain IndexSearcher, which has no query cache) keeps the node
        LuceneReader luceneReader,  
            Scorer scorer = matchAllProvider ? null : weight.scorer(leaf);
            + "): partition ["  
import org.apache.lucene.index.LeafReader;
            );  
            return -1;  
    /**
import org.apache.lucene.util.Bits;
        int startWord = effectiveMinDoc >>> 6;  
import org.opensearch.analytics.spi.DelegatedExpression;
                providerKey  
                    DocIdSetIterator iterator = preFiltered ? handle.liveIntersection : handle.scorer.iterator();  
        return isCancelledSupplier != null && isCancelledSupplier.getAsBoolean();
import org.apache.lucene.search.Query;  
    }  
            // Keep only what collectDocs reads: a pre-filtered (dense-delete) leaf walks liveIntersection  
        // the IndicesQueryCache wrapper's assertion holds (a searcher over a DIFFERENT reader, e.g. the
                    minDoc,
                segName,
                    int docId = handle.currentDoc;
            if (copyWords > 0) {  
        if (maxDoc <= minDoc) {
                    liveIntersection
        }  
    }  
        final Bits liveDocs;
        // (weight.scorer(leaf)) — so the Weight's top-reader matches the scored leaf's top-reader and
        for (int w = 0; w < wordCount; w++) {  
        int nextDoc = Integer.MAX_VALUE;
                throw new IllegalStateException(
            }
            Bits liveDocs,
            if (unwrapSegmentReader(lrc.reader()).getSegmentInfo().info.name.equals(segName)) {
                out.setAtIndex(ValueLayout.JAVA_LONG, i, lo | hi);
 * built once at refresh time in {@link LuceneReaderManager}.  
    }  
        final int partitionMaxDoc;  
        queries.put(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID, new MatchAllDocsQuery());
    @Override
        CatalogSnapshot catalogSnapshot,
    private final AtomicInteger nextCollectorKey = new AtomicInteger(1);
            int scanFrom = Math.max(minDoc, handle.partitionMinDoc);
        BooleanSupplier isCancelledSupplier  
    private SegmentReader unwrapSegmentReader(LeafReader reader) {  
            + segName
        }
        for (LeafReaderContext lrc : leaves) {
            int providerKey = nextProviderKey.getAndIncrement();
import org.opensearch.index.query.QueryBuilder;
        liveDocsProviderKeys.remove(providerKey);  
final class LuceneFilterDelegationHandle implements FilterDelegationHandle {
    private static void fillAllAliveWords(MemorySegment out, int span, int wordCount) {
                )  
    public int createProvider(int annotationId) {  
    private final java.util.Set<Integer> liveDocsProviderKeys = ConcurrentHashMap.newKeySet();
        if (liveBits != null) {  
            return -1;
/**  
        int wordCount = (span + 63) >>> 6;  
        // Weight is not the same as the current reader's top-reader" AssertionError). Reusing this
 * Lucene implementation of {@link FilterDelegationHandle}. Compiles delegated expressions
                    nextDoc = maxDoc;
}
                "createCollector: no Lucene segment for writer_generation={} (providerKey={}). Known generations: {}",
import org.apache.lucene.search.MatchAllDocsQuery;
            this.partitionMaxDoc = partitionMaxDoc;
     */  
        return (SegmentReader) current;
            Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
     * Write {@code span} all-alive bits (all-ones, trailing partial word masked to {@code span & 63})
        try {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                        }
        assert minDoc >= 0 && minDoc <= maxDoc && maxDoc <= leafMaxDoc : "createCollector(providerKey="  
        int currentDoc = -1;
                out.setAtIndex(ValueLayout.JAVA_LONG, w, 0L);
                return ConjunctionUtils.intersectIterators(
                );
            LOGGER.error(
                    }
        try {
            this.liveIntersection = liveIntersection;
                } catch (IOException exception) {  
                collectorKey,
 * @opensearch.internal
        List<DelegatedExpression> expressions,  
            return collectorKey;
    }
import java.util.concurrent.atomic.AtomicInteger;  
    public void close() {  
            FixedBitSet liveBits = BitSetIterator.getFixedBitSetOrNull(ld.liveDocsIterator());
import java.lang.foreign.ValueLayout;
            );  
        scorersByCollectorKey.remove(collectorKey);  
            }
        this.generationToSegmentName = luceneReader.generationToSegmentName();  
            return -1;
     * no deletions, or sparse deletions with no FixedBitSet backing — in which case collectDocs uses the  
            if (liveBits != null) {  
            return ((long) maxDoc << 32) | (wordCount & 0xFFFFFFFFL);
        if (handle == null) {
import org.apache.lucene.search.Scorer;
            return -1;
import org.apache.lucene.index.DirectoryReader;  
        try {
    @Override
            for (int w = copyWords; w < wordCount; w++) {  
        LeafReaderContext leaf = null;  
    private final Map<Long, String> generationToSegmentName;  
    // semantics for compile-failure timing (eager = fail at ctor, lazy = fail
        if (LOGGER.isDebugEnabled()) {
        }
        } catch (IOException exception) {
                StreamInput input = new NamedWriteableAwareStreamInput(rawInput, registry);
     * trailing mask below clears it.
                "[scf] collectDocs collectorKey={} range=[{},{}) → cardinality={} words={} nextDoc={}",
            LOGGER.warn("IOException during fillLiveDocsWords, returning partial live-docs bitset", e);
    }
        if (scorer != null && liveDocs instanceof LiveDocs ld) {
            // alone, so drop the scorer and liveDocs; the raw-scorer path keeps both, and match-all keeps
    // the two kinds (e.g. add a kind field on DelegatedExpression) and clear
            DocIdSetIterator liveIntersection  
     * every doc in range is live — so no liveDocs lookup is needed.  
            return;  
            // Match-all uses the fast path, so no liveIntersection iterator is required.  
                    // Dense-delete leaves walk the scorer ∩ live-docs conjunction (already excludes deleted);  
import java.util.HashMap;
            + " -> segment="
            + providerKey
            fillLiveDocsWords(handle.liveDocs, minDoc, span, wordCount, out);
            // Match-all provider: emit the live docs directly (see fillLiveDocsWords). Match-all never
        weightsByProviderKey.remove(providerKey);
        }
import org.apache.lucene.index.FilterLeafReader;
                    LOGGER.warn("IOException during collectDocs, returning partial bitset", exception);
        this.isCancelledSupplier = isCancelledSupplier;
    private final IndexSearcher searcher;  
                // has no doc_values/norms (they live in the parquet primary), so a FieldExistsQuery
        }  
    // TODO: lazy query compilation for performance-delegated predicates. Today
                                bits.set(docId - minDoc);
        }
    // at first use). Revisit if this surfaces as a real cost — needs revisiting.  
        int bitOffset = effectiveMinDoc & 63;
                long lo = (startWord + i < srcWords.length) ? srcWords[startWord + i] >>> bitOffset : 0L;
    }  
                    nextDoc = handle.currentDoc;
        }
            );
    private static DocIdSetIterator liveIntersection(Scorer scorer, Bits liveDocs) {  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        if (trailing != 0) {
        QueryShardContext queryShardContext,
        NamedWriteableRegistry namedWriteableRegistry,
        ScorerHandle handle = scorersByCollectorKey.get(collectorKey);
            );
import java.util.Map;
    private static void fillLiveDocsWords(Bits liveDocs, int minDoc, int span, int wordCount, MemorySegment out) {
                collectorKey
            out.setAtIndex(ValueLayout.JAVA_LONG, wordCount - 1, lastWord & ((1L << trailing) - 1));
    /**  
        }
                // Rewrite FieldExistsQuery → a postings-only equivalent: the lucene-secondary segment
import org.opensearch.index.query.QueryShardContext;  
        }
package org.opensearch.be.lucene;
    public void releaseCollector(int collectorKey) {
 * SPDX-License-Identifier: Apache-2.0
        }
                    maxDoc,
        Query query = queriesByAnnotationId.get(annotationId);
                    // Report maxDoc conservatively so later RGs are still probed.
            + writerGeneration  
    @Override
                int rel = doc - minDoc;  
            Scorer scorer,
        // Sparse deletions: fill all-alive, then clear the O(deletions) deleted bits.
import org.apache.lucene.util.LiveDocs;
import org.apache.logging.log4j.LogManager;
        assert catalogSnapshot != null : "catalogSnapshot must not be null";  
            try {  
     * Pack the LIVE-docs slice {@code [minDoc, minDoc+span)} into {@code out} as {@code wordCount} LSB-first
                    boolean preFiltered = handle.liveIntersection != null;
        }
            this.liveDocs = liveDocs;
        }  
            }
import org.opensearch.core.common.io.stream.StreamInput;  
            return -1;  
                minDoc,  
        // Use the shared per-reader searcher (LuceneReader#searcher). It is built over THIS
                    liveIntersection == null ? liveDocs : null,  
        MemorySegment.copy(words, 0, out, ValueLayout.JAVA_LONG, 0, wordCount);
            int availWords = Math.max(0, srcWords.length - startWord);
                new ScorerHandle(
        }  
            current = flr.getDelegate();  
                            docId = iterator.advance(scanFrom);
        }
            }
import org.apache.lucene.search.ConjunctionUtils;
        return queries;
            int scanTo = Math.min(maxDoc, handle.partitionMaxDoc);
                        handle.currentDoc = docId;  
     */
            );
                "createCollector failed for providerKey=" + providerKey + ", writerGeneration=" + writerGeneration + ", segment=" + segName,
            this.scorer = scorer;
                    // Iteration is only partial — don't signal exhaustion (MAX_VALUE),
    // ctor time. For correctness-delegated predicates (always called) this is
            this.matchAllProvider = matchAllProvider;  
                collectorKey,
    @Override
import org.apache.lucene.index.LeafReaderContext;  
        int trailing = span & 63;
        }  
    private final DirectoryReader directoryReader;
        return ((long) nextDoc << 32) | (wordCount & 0xFFFFFFFFL);
        }
            return -1;
        while (current instanceof FilterLeafReader flr) {
            int collectorKey = nextCollectorKey.getAndIncrement();
        FixedBitSet liveBits = org.apache.lucene.util.BitSetIterator.getFixedBitSetOrNull(ld.liveDocsIterator());
        final DocIdSetIterator liveIntersection;  
        return null;  
import org.apache.lucene.util.BitSetIterator;
                Query query = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(queryBuilder.toQuery(context));
                nextDoc
                break;
            }
        this.queriesByAnnotationId = compileQueries(expressions, queryShardContext, namedWriteableRegistry);
        if (handle.matchAllProvider) {
                providerKey,
import org.apache.lucene.search.Weight;  
            if (annotationId == LIVE_DOCS_MATCH_ALL_ANNOTATION_ID) {  
            // Segment has no deletions — every doc is live (all-ones, trailing word masked).  
    private final BooleanSupplier isCancelledSupplier;
            } catch (IOException exception) {  
                generationToSegmentName.keySet()
        NamedWriteableRegistry registry
    // consult, the compile cost is wasted. Deferring needs a way to distinguish  
        if (liveDocs == null) {
 *  
        this.leaves = directoryReader.leaves();
    private static void copyLiveWords(FixedBitSet fbs, MemorySegment out, int effectiveMinDoc, int span, int wordCount) {
            + ","
        /** True for the reserved match-all provider: collectDocs emits live docs directly via fillLiveDocsWords. */  
    }  
        if (handle.scorer != null || handle.liveIntersection != null) {  
            long lastWord = out.getAtIndex(ValueLayout.JAVA_LONG, wordCount - 1);  
            LOGGER.debug(
    private static final Logger LOGGER = LogManager.getLogger(LuceneFilterDelegationHandle.class);  
    }
        // cache (QueryCacheIT). The shared instance was already built cache-enabled by the caller
     * into {@code out} as {@code wordCount} LSB-first longs. Used when a segment has no deletions —
                leaf = lrc;  
 * into Lucene Queries, creates Weights on demand, and produces bitsets via Scorers.
                writerGeneration,
        if (bitOffset == 0) {  
                maxDoc,
     */  
            int copyWords = Math.min(wordCount, availWords);
                            if (preFiltered || handle.liveDocs == null || handle.liveDocs.get(docId)) {
        liveDocsProviderKeys.clear();
        // directoryReader — the same reader whose leaves we score against in createCollector  
            DocIdSetIterator liveIntersection = matchAllProvider ? null : liveIntersection(scorer, liveDocs);
    }  
                        if (docId < scanFrom) {  
        }  
            Bits liveDocs = leaf.reader().getLiveDocs();
                            }  
        assert luceneReader != null : "luceneReader must not be null";
                        }
        final Scorer scorer;
            boolean matchAllProvider = liveDocsProviderKeys.contains(providerKey);
            int partitionMinDoc,
            return;
            boolean matchAllProvider,
            DocIdSetIterator deleted = ld.deletedDocsIterator();  
        // calls return that instance and ignore the args.  
            // Match-all provider: collectDocs emits the segment's live docs directly via fast path (fillLiveDocsWords).  
        Map<Integer, Query> queries = new HashMap<>();
 * <p>Segments are resolved by <b>writer generation</b>. The mapping
        } catch (IOException e) {  
                MemorySegment.copy(srcWords, startWord, out, ValueLayout.JAVA_LONG, 0L, copyWords);
            }  
     * longs (set bit == live), without scorer iteration. No deletions ({@code liveDocs == null}) emits
        /** Live docs for the fast path / per-doc {@code get}; {@code null} when unused (dense-delete predicate) or when the segment has no deletions. */
                wordCount,  
        }
    public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {  
     */
            copyLiveWords(liveBits, out, minDoc, span, wordCount);
            for (int i = 0; i < wordCount; i++) {
    }  
            fillAllAliveWords(out, span, wordCount);
                }  
    public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {  
            // Dense deletions: word-copy the backing live FixedBitSet.
     * all-alive then clear the O(deletions) deleted bits. Caller guarantees {@code span > 0} and that a
            out.setAtIndex(ValueLayout.JAVA_LONG, wordCount - 1, (1L << trailing) - 1);
     * Intersect the scorer with live docs for dense-delete leaves ({@code DenseLiveDocs}, which expose a  
                doc = deleted.nextDoc();
                );  
            int doc = deleted.advance(minDoc);
    private final List<LeafReaderContext> leaves;
    @Override  
            }
        List<DelegatedExpression> expressions,
        // old queryShardContext.searcher(), threw the fatal-under-`-ea` "top-reader used to create  
            } else {
        /** The predicate scorer for the raw-scorer path; {@code null} for match-all and dense-delete (pre-filtered) collectors, which don't walk it. */  
 */  
                // built from an _exists_ clause (PPL `search field!=value`) would throw at rewrite().  
 * compatible open source license.
    /**  
        this.directoryReader = luceneReader.directoryReader();
                maxDoc,
        // entry; no Weight is created unless the id is actually used.  
            LOGGER.error("createProvider failed for annotationId=" + annotationId, exception);  
                bits.cardinality(),
import org.apache.logging.log4j.Logger;
import org.apache.lucene.index.SegmentReader;
                writerGeneration,
            return providerKey;
            weightsByProviderKey.put(providerKey, weight);
        Weight weight = weightsByProviderKey.get(providerKey);
                int w = rel >>> 6;
            int partitionMaxDoc,  
    @Override  
        for (DelegatedExpression expr : expressions) {
import org.apache.lucene.search.DocIdSetIterator;  
    private static final class ScorerHandle {
            }
            }
        if (weight == null) {
 *
        int maxDoc = minDoc + span;
import java.util.function.BooleanSupplier;
                StreamInput rawInput = StreamInput.wrap(expr.getExpressionBytes());
    private final ConcurrentHashMap<Integer, Weight> weightsByProviderKey = new ConcurrentHashMap<>();
    private final AtomicInteger nextProviderKey = new AtomicInteger(1);  
        if (trailing != 0) {
     * backing {@link FixedBitSet} of live docs): lead a conjunction with it so {@link ConjunctionUtils}
     * {@link FixedBitSet} into {@code out} as {@code wordCount} packed longs (set bit == live).
    private final Map<Integer, Query> queriesByAnnotationId;
                long cur = out.getAtIndex(ValueLayout.JAVA_LONG, w);
        }  
            out.setAtIndex(ValueLayout.JAVA_LONG, w, -1L);
    }
    private static Map<Integer, Query> compileQueries(
                providerKey,
        int trailing = span & 63;  
                    // otherwise walk the raw scorer and drop deleted docs per-doc via liveDocs.get below.
        weightsByProviderKey.clear();
     * all-ones; dense segments word-copy the backing {@link FixedBitSet} (O(words)); sparse segments fill  
        int leafMaxDoc = leaf.reader().maxDoc();
