    // at first use). Revisit if this surfaces as a real cost — needs revisiting.
                    DocIdSetIterator iterator = preFiltered ? handle.liveIntersection : handle.scorer.iterator();
        CatalogSnapshot catalogSnapshot,
                long lo = (startWord + i < srcWords.length) ? srcWords[startWord + i] >>> bitOffset : 0L;
            return -1;
        liveDocsProviderKeys.clear();
    @Override
            // Keep only what collectDocs reads: a pre-filtered (dense-delete) leaf walks liveIntersection
     * longs (set bit == live), without scorer iteration. No deletions ({@code liveDocs == null}) emits
            return -1;
            boolean matchAllProvider = liveDocsProviderKeys.contains(providerKey);
    }
import org.apache.lucene.index.DirectoryReader;
            }
 * this file be licensed under the Apache-2.0 license or a
    private SegmentReader unwrapSegmentReader(LeafReader reader) {
    public void close() {
                // built from an _exists_ clause (PPL `search field!=value`) would throw at rewrite().
                StreamInput input = new NamedWriteableAwareStreamInput(rawInput, registry);
        }
        assert luceneReader != null : "luceneReader must not be null";
 *
        return isCancelledSupplier != null && isCancelledSupplier.getAsBoolean();
        }
import org.apache.lucene.search.ConjunctionUtils;
        if (trailing != 0) {
 * into Lucene Queries, creates Weights on demand, and produces bitsets via Scorers.
import org.apache.logging.log4j.Logger;
     * trailing mask below clears it.
    }
            }
                }
                queries.put(expr.getAnnotationId(), query);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
}
            if (scanFrom < scanTo) {
        int wordCount = (span + 63) >>> 6;
            this.matchAllProvider = matchAllProvider;
                    LOGGER.warn("IOException during collectDocs, returning partial bitset", exception);
            }
            + ") exceeds leaf maxDoc="
    private final BooleanSupplier isCancelledSupplier;
        }
        // entry; no Weight is created unless the id is actually used.
    /**
        MemorySegment.copy(words, 0, out, ValueLayout.JAVA_LONG, 0, wordCount);
        liveDocsProviderKeys.remove(providerKey);
                "createCollector failed for providerKey=" + providerKey + ", writerGeneration=" + writerGeneration + ", segment=" + segName,
    private static void fillLiveDocsWords(Bits liveDocs, int minDoc, int span, int wordCount, MemorySegment out) {
    public void releaseCollector(int collectorKey) {
     * <p>Over-copy is safe without per-word clearing: bits past {@code fbs.length()} are 0
                minDoc,
    }
    private static Map<Integer, Query> compileQueries(
            Scorer scorer = matchAllProvider ? null : weight.scorer(leaf);
import java.util.HashMap;
        if (query == null) {
        if (liveBits != null) {
            LOGGER.error(
import org.apache.lucene.index.LeafReaderContext;
            LOGGER.debug("[scf] createProvider annotationId={} → providerKey={}", annotationId, providerKey);
                        while (docId != DocIdSetIterator.NO_MORE_DOCS && docId < scanTo) {
import org.apache.lucene.search.Weight;
    ) {
 * <p>Segments are resolved by <b>writer generation</b>. The mapping
 */
        scorersByCollectorKey.remove(collectorKey);
import org.opensearch.index.query.QueryShardContext;
                nextDoc = handle.currentDoc;
        try {
            current = flr.getDelegate();
        }
                new ScorerHandle(
    public boolean isCancelled() {
    }
                    maxDoc,
                collectorKey,
        }
import java.io.IOException;
        final boolean matchAllProvider;
            Scorer scorer,
        long[] words = bits.getBits();
     */
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            }
        // IndicesQueryCache wired in, so repeated delegated predicates populate + hit the shard query
     * Intersect the scorer with live docs for dense-delete leaves ({@code DenseLiveDocs}, which expose a
            );
        if (handle.scorer != null || handle.liveIntersection != null) {
                );
        }
                    // Dense-delete leaves walk the scorer ∩ live-docs conjunction (already excludes deleted);
            LOGGER.warn("IOException during fillLiveDocsWords, returning partial live-docs bitset", e);
            // liveDocs for the fast path.
import org.apache.lucene.search.IndexSearcher;
            + segName
        FixedBitSet bits = new FixedBitSet(span);
        /** Persistent scorer ∩ live-docs conjunction for dense-delete leaves; {@code null} → walk the raw scorer + liveDocs.get. */
import java.lang.foreign.MemorySegment;
import java.util.concurrent.atomic.AtomicInteger;
        // directoryReader — the same reader whose leaves we score against in createCollector
        LeafReaderContext leaf = null;
            + minDoc
            fillLiveDocsWords(handle.liveDocs, minDoc, span, wordCount, out);
                    liveIntersection == null ? liveDocs : null,
        // old queryShardContext.searcher(), threw the fatal-under-`-ea` "top-reader used to create
            return -1;
        }
    LuceneFilterDelegationHandle(
        /** True for the reserved match-all provider: collectDocs emits live docs directly via fillLiveDocsWords. */
        int leafMaxDoc = leaf.reader().maxDoc();
            Bits liveDocs = leaf.reader().getLiveDocs();
    }
import org.apache.lucene.util.LiveDocs;
            // Dense deletions: word-copy the backing live FixedBitSet.
                    }
            if (liveBits != null) {
            DocIdSetIterator liveIntersection = matchAllProvider ? null : liveIntersection(scorer, liveDocs);
                    boolean preFiltered = handle.liveIntersection != null;
    private static DocIdSetIterator liveIntersection(Scorer scorer, Bits liveDocs) {
                );
            } else {
        }
        /** The predicate scorer for the raw-scorer path; {@code null} for match-all and dense-delete (pre-filtered) collectors, which don't walk it. */
import org.apache.lucene.util.BitSetIterator;
                writerGeneration,
        int trailing = span & 63;
import java.util.List;
        if (maxDoc <= minDoc) {
                // Rewrite FieldExistsQuery → a postings-only equivalent: the lucene-secondary segment
            );
import java.util.function.BooleanSupplier;
            // Match-all provider: emit the live docs directly (see fillLiveDocsWords). Match-all never
            return collectorKey;
    @Override
final class LuceneFilterDelegationHandle implements FilterDelegationHandle {
                long cur = out.getAtIndex(ValueLayout.JAVA_LONG, w);
            boolean matchAllProvider,
/**
        QueryShardContext queryShardContext,
    public int createProvider(int annotationId) {
            + ","
                out.setAtIndex(ValueLayout.JAVA_LONG, w, 0L);
    }
            );
    private final Map<Long, String> generationToSegmentName;
        BooleanSupplier isCancelledSupplier
                    // which would make callers skip all subsequent RGs for this leaf.
                    exception
            // Segment has no deletions — every doc is live (all-ones, trailing word masked).
                providerKey,
import java.util.concurrent.ConcurrentHashMap;
        QueryShardContext context,
     * all-alive then clear the O(deletions) deleted bits. Caller guarantees {@code span > 0} and that a
import org.apache.lucene.index.LeafReader;
            + "): partition ["
                maxDoc,
     * Pack the LIVE-docs slice {@code [minDoc, minDoc+span)} into {@code out} as {@code wordCount} LSB-first
            int scanTo = Math.min(maxDoc, handle.partitionMaxDoc);
     * raw scorer and drops deleted docs per-doc via {@code liveDocs.get}.
                providerKey,
            for (int w = copyWords; w < wordCount; w++) {
            try {
            int providerKey = nextProviderKey.getAndIncrement();
                            if (preFiltered || handle.liveDocs == null || handle.liveDocs.get(docId)) {
                    liveIntersection
        // the IndicesQueryCache wrapper's assertion holds (a searcher over a DIFFERENT reader, e.g. the
        return null;
        int currentDoc = -1;
            LOGGER.error("createProvider failed for annotationId=" + annotationId, exception);
                    // Report maxDoc conservatively so later RGs are still probed.
                        if (docId < scanFrom) {
                throw new IllegalStateException(
    @Override
                )
    /** Provider keys created from {@link #LIVE_DOCS_MATCH_ALL_ANNOTATION_ID} — collectDocs takes the live-docs fast path. */
        long[] srcWords = fbs.getBits();
                writerGeneration,
    }
            int copyWords = Math.min(wordCount, availWords);
    private static final Logger LOGGER = LogManager.getLogger(LuceneFilterDelegationHandle.class);
            );
                nextDoc
                collectorKey
        try {
     * {@link FixedBitSet} into {@code out} as {@code wordCount} packed longs (set bit == live).
        this.directoryReader = luceneReader.directoryReader();
        // (weight.scorer(leaf)) — so the Weight's top-reader matches the scored leaf's top-reader and
        } catch (IOException e) {
        // Weight is not the same as the current reader's top-reader" AssertionError). Reusing this
        /** Live docs for the fast path / per-doc {@code get}; {@code null} when unused (dense-delete predicate) or when the segment has no deletions. */
     * skips the deleted majority. Returns {@code null} when there's nothing to pre-filter — no scorer,
                        }
            scorersByCollectorKey.put(
        // (LuceneAnalyticsBackendPlugin#getFilterDelegationHandle passes the cache + policy); later
                collectorKey,
        }
    /**
            return -1;
            DocIdSetIterator deleted = ld.deletedDocsIterator();
    // every delegated expression is compiled (QueryBuilder → Lucene Query) at
    private static void copyLiveWords(FixedBitSet fbs, MemorySegment out, int effectiveMinDoc, int span, int wordCount) {
                            docId = iterator.advance(scanFrom);
        return ((long) nextDoc << 32) | (wordCount & 0xFFFFFFFFL);
            }
                int w = rel >>> 6;
import org.apache.logging.log4j.LogManager;
import org.apache.lucene.search.ScoreMode;
     *
    private static final class ScorerHandle {
    private static void fillAllAliveWords(MemorySegment out, int span, int wordCount) {
                    minDoc,
        scorersByCollectorKey.clear();
        }
        // Deleted-doc filtering: always register the reserved match-all query (even when
    private final List<LeafReaderContext> leaves;
                bits.cardinality(),
                    int docId = handle.currentDoc;
            int doc = deleted.advance(minDoc);
                    matchAllProvider,
            long lastWord = out.getAtIndex(ValueLayout.JAVA_LONG, wordCount - 1);
        Map<Integer, Query> queries = new HashMap<>();
import org.apache.lucene.search.DocIdSetIterator;
        } catch (IOException exception) {
        int trailing = span & 63;
        this.leaves = directoryReader.leaves();
        }
            if (unwrapSegmentReader(lrc.reader()).getSegmentInfo().info.name.equals(segName)) {
        List<DelegatedExpression> expressions,
        if (liveDocs == null) {
        this.generationToSegmentName = luceneReader.generationToSegmentName();
    }
     */
        }
            + " -> segment="
            LOGGER.error(
            out.setAtIndex(ValueLayout.JAVA_LONG, w, -1L);
            LOGGER.debug(
                leaf = lrc;
     * non-null {@code liveDocs} is a {@link LiveDocs} (the codec contract for a segment with deletions).
        } catch (IOException exception) {
                "createCollector: segment name [{}] not found in leaves (writerGeneration={}, providerKey={})",
            this.partitionMaxDoc = partitionMaxDoc;
            return;
                    List.of(new BitSetIterator(liveBits, liveBits.cardinality()), scorer.iterator())
        List<DelegatedExpression> expressions,
                return ConjunctionUtils.intersectIterators(
    @Override
 * built once at refresh time in {@link LuceneReaderManager}.
 * compatible open source license.
        int nextDoc = Integer.MAX_VALUE;
        this.searcher = luceneReader.searcher(null, null);
        }
import org.apache.lucene.util.Bits;
        assert minDoc >= 0 && minDoc <= maxDoc && maxDoc <= leafMaxDoc : "createCollector(providerKey="
        final Bits liveDocs;
        final DocIdSetIterator liveIntersection;
                "[scf] collectDocs collectorKey={} range=[{},{}) → cardinality={} words={} nextDoc={}",
     * backing {@link FixedBitSet} of live docs): lead a conjunction with it so {@link ConjunctionUtils}
     * all-ones; dense segments word-copy the backing {@link FixedBitSet} (O(words)); sparse segments fill
import org.opensearch.core.common.io.stream.StreamInput;
            Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
            return providerKey;
    }
        FixedBitSet liveBits = org.apache.lucene.util.BitSetIterator.getFixedBitSetOrNull(ld.liveDocsIterator());
        if (scorer != null && liveDocs instanceof LiveDocs ld) {
                wordCount,
            if (annotationId == LIVE_DOCS_MATCH_ALL_ANNOTATION_ID) {
            int partitionMinDoc,
    // TODO: lazy query compilation for performance-delegated predicates. Today
                try {
                minDoc,
            FixedBitSet liveBits = BitSetIterator.getFixedBitSetOrNull(ld.liveDocsIterator());
     * every doc in range is live — so no liveDocs lookup is needed.
        LeafReader current = reader;
            weightsByProviderKey.put(providerKey, weight);
    }
            int collectorKey = nextCollectorKey.getAndIncrement();
        if (bitOffset == 0) {
        if (LOGGER.isDebugEnabled()) {
    public void releaseProvider(int providerKey) {
package org.opensearch.be.lucene;
            return 0;
        }
     * Write {@code span} all-alive bits (all-ones, trailing partial word masked to {@code span & 63})
                StreamInput rawInput = StreamInput.wrap(expr.getExpressionBytes());
                            docId = iterator.nextDoc();
            return -1;
    private final ConcurrentHashMap<Integer, Weight> weightsByProviderKey = new ConcurrentHashMap<>();
                segName,
                Query query = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(queryBuilder.toQuery(context));
import org.apache.lucene.search.Query;
                int rel = doc - minDoc;
     * Copy the LIVE-docs slice {@code [effectiveMinDoc, effectiveMinDoc + span)} of a
                maxDoc,
                    if (docId != DocIdSetIterator.NO_MORE_DOCS) {
                    // otherwise walk the raw scorer and drop deleted docs per-doc via liveDocs.get below.
        Weight weight = weightsByProviderKey.get(providerKey);
        for (int w = 0; w < wordCount; w++) {
        // `expressions` is empty) so its collector can emit the segment's live docs. A single map
                MemorySegment.copy(srcWords, startWord, out, ValueLayout.JAVA_LONG, 0L, copyWords);
            // Match-all uses the fast path, so no liveIntersection iterator is required.
import java.util.Map;
        return queries;
            out.setAtIndex(ValueLayout.JAVA_LONG, wordCount - 1, lastWord & ((1L << trailing) - 1));
        if (handle == null) {
        if (leaf == null) {
        for (LeafReaderContext lrc : leaves) {
    public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
        }
 */
        }
        int startWord = effectiveMinDoc >>> 6;
        String segName = generationToSegmentName.get(writerGeneration);
        final int partitionMinDoc;
            );
        try {
        if (weight == null) {
            out.setAtIndex(ValueLayout.JAVA_LONG, wordCount - 1, (1L << trailing) - 1);
import java.lang.foreign.ValueLayout;
            while (doc != DocIdSetIterator.NO_MORE_DOCS && doc < maxDoc) {
        }
                break;
            // Match-all provider: collectDocs emits the segment's live docs directly via fast path (fillLiveDocsWords).
        // searcher (vs a fresh plain IndexSearcher, which has no query cache) keeps the node
    @Override
        fillAllAliveWords(out, span, wordCount);
    private final AtomicInteger nextCollectorKey = new AtomicInteger(1);
            copyLiveWords(liveBits, out, minDoc, span, wordCount);
            for (int i = 0; i < wordCount; i++) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    @Override
    // semantics for compile-failure timing (eager = fail at ctor, lazy = fail
        this.isCancelledSupplier = isCancelledSupplier;
        LiveDocs ld = (LiveDocs) liveDocs;
        weightsByProviderKey.remove(providerKey);
    ) {
            this.liveIntersection = liveIntersection;
                    nextDoc = maxDoc;
            LOGGER.debug(
 * @opensearch.internal
                long hi = (startWord + i + 1 < srcWords.length) ? srcWords[startWord + i + 1] << (64 - bitOffset) : 0L;
        return (SegmentReader) current;
            + maxDoc
    // the two kinds (e.g. add a kind field on DelegatedExpression) and clear
            return ((long) maxDoc << 32) | (wordCount & 0xFFFFFFFFL);
            DocIdSetIterator liveIntersection
    private final java.util.Set<Integer> liveDocsProviderKeys = ConcurrentHashMap.newKeySet();
        if (segName == null) {
    /**
import org.apache.lucene.index.SegmentReader;
        queries.put(LIVE_DOCS_MATCH_ALL_ANNOTATION_ID, new MatchAllDocsQuery());
        int span = maxDoc - minDoc;
     * (FixedBitSet invariant), and only the final word can hold bits beyond {@code span} — the
        this.queriesByAnnotationId = compileQueries(expressions, queryShardContext, namedWriteableRegistry);
        // cache (QueryCacheIT). The shared instance was already built cache-enabled by the caller
            int partitionMaxDoc,
        }
        if (trailing != 0) {
                            }
        Query query = queriesByAnnotationId.get(annotationId);
import org.opensearch.analytics.spi.DelegatedExpression;
        ) {
    private final IndexSearcher searcher;
            Bits liveDocs,
            int scanFrom = Math.max(minDoc, handle.partitionMinDoc);
        ScorerHandle(
            );
            + writerGeneration
     * no deletions, or sparse deletions with no FixedBitSet backing — in which case collectDocs uses the
        } else {
            if (copyWords > 0) {
        }
                        handle.currentDoc = docId;
import org.apache.lucene.util.FixedBitSet;
            LOGGER.error(
    private final DirectoryReader directoryReader;
     */
            return -1;
    }
            this.scorer = scorer;
            this.liveDocs = liveDocs;
    public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
            // exhausts, so nextDoc = maxDoc.
import org.apache.lucene.index.FilterLeafReader;
        }
            return -1;
    // fine. For performance-delegated predicates that DF page-pruning may never
    @Override
    // consult, the compile cost is wasted. Deferring needs a way to distinguish
    }
    private final Map<Integer, Query> queriesByAnnotationId;
                QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
            } catch (IOException exception) {
        for (DelegatedExpression expr : expressions) {
                out.setAtIndex(ValueLayout.JAVA_LONG, i, lo | hi);
 * Lucene implementation of {@link FilterDelegationHandle}. Compiles delegated expressions
                    liveIntersection == null ? scorer : null,
            }
/*
        NamedWriteableRegistry registry
        // Use the shared per-reader searcher (LuceneReader#searcher). It is built over THIS
    }
import org.apache.lucene.search.Scorer;
            int availWords = Math.max(0, srcWords.length - startWord);
    private final ConcurrentHashMap<Integer, ScorerHandle> scorersByCollectorKey = new ConcurrentHashMap<>();
                                bits.set(docId - minDoc);
                generationToSegmentName.keySet()
                        }
import org.opensearch.index.query.QueryBuilder;
                    "Failed to deserialize delegated expression for annotationId=" + expr.getAnnotationId(),
        final int partitionMaxDoc;
        }
        }
    private final AtomicInteger nextProviderKey = new AtomicInteger(1);
        final Scorer scorer;
 *
                doc = deleted.nextDoc();
                    // Iteration is only partial — don't signal exhaustion (MAX_VALUE),
            + leafMaxDoc;
            this.partitionMinDoc = partitionMinDoc;
                liveDocsProviderKeys.add(providerKey);
            + ", writerGeneration="
            return;
                providerKey
    }
            }
                exception
            }
            // alone, so drop the scorer and liveDocs; the raw-scorer path keeps both, and match-all keeps
                } catch (IOException exception) {
        ScorerHandle handle = scorersByCollectorKey.get(collectorKey);
        }
    }
        // calls return that instance and ignore the args.
            }
                out.setAtIndex(ValueLayout.JAVA_LONG, w, cur & ~(1L << (rel & 63)));
 * The OpenSearch Contributors require contributions made to
     */
        int bitOffset = effectiveMinDoc & 63;
                    nextDoc = handle.currentDoc;
        if (handle.matchAllProvider) {
        while (current instanceof FilterLeafReader flr) {
import org.apache.lucene.search.MatchAllDocsQuery;
        NamedWriteableRegistry namedWriteableRegistry,
        int maxDoc = minDoc + span;
    /**
            + providerKey
        LuceneReader luceneReader,
                writerGeneration,
 * {@code generation → Lucene leaf index} is provided by {@link LuceneReader}, which is
    // ctor time. For correctness-delegated predicates (always called) this is
        // Sparse deletions: fill all-alive, then clear the O(deletions) deleted bits.
 *
        assert catalogSnapshot != null : "catalogSnapshot must not be null";
                "createCollector: no Lucene segment for writer_generation={} (providerKey={}). Known generations: {}",
            fillAllAliveWords(out, span, wordCount);
        weightsByProviderKey.clear();
 * SPDX-License-Identifier: Apache-2.0
                // has no doc_values/norms (they live in the parquet primary), so a FieldExistsQuery
                "[scf] createCollector providerKey={} writerGeneration={} range=[{},{}) → collectorKey={}",
     * into {@code out} as {@code wordCount} LSB-first longs. Used when a segment has no deletions —
import org.opensearch.analytics.spi.FilterDelegationHandle;
