                    } else {
            } else {
                reader,
            this(collapseContext, sortAndFormats, numHits, trackMaxScore, null);
        @Override
                    if (hitCount == -1) {
                    }
                    if (topDocs.scoreDocs.length == 0) {
        private final int hitCount;
                searchContext.trackTotalHitsUpTo(),
                topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, Integer.MAX_VALUE);
    }
        }
        }
                hasFilterCollector
                query,
            } else if (SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0])) {
        private final int trackTotalHitsUpTo;
         * @param trackMaxScore True if max score should be tracked
            } else {
            return (QuerySearchResult result) -> {
 * the Apache License, Version 2.0 (the "License"); you may
                }
            if (query instanceof FunctionScoreQuery || query instanceof ScriptScoreQuery || query instanceof SpanQuery) {
         * @param searchAfter The doc this request should "search after"
        private static CollectorManager<? extends TopDocsCollector<?>, ? extends TopDocs> createCollectorManager(
import org.apache.lucene.search.Sort;
            float maxScore = maxScoreSupplier.get();
            };
            Query query,
 * ownership. Elasticsearch licenses this file to you under
                return new TopDocsAndMaxScore(newTopDocs, maxScore);
                    } else {
            final TopDocs newTopDocs;
            int trackTotalHitsUpTo,
/*
        }
            if (this.trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        private CollapsingTopDocsCollectorContext(
            }
                searchContext.sort(),
                    topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore);
                this.collector = new EarlyTerminatingCollector(new TotalHitCountCollector(), 0, false);
            this.sortByScore = sortAndFormats == null || SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0]);
                        }
 *
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
            checkMaxScoreInfo(parent);
                        PointValues points = context.reader().getPointValues(field);
    public boolean shouldRescore() {
        void postProcess(QuerySearchResult result) throws IOException {
                    return rescore;
            CollectorManager<?, ReduceableSearchResult> manager = null;
            };
     */
            assert in == null;
    /**
            final TopDocs topDocs;
            @Override
                FieldInfo fieldInfo = fieldInfos.fieldInfo(field);
                result.topDocs(topDocsAndMaxScore, sortFmt);
 * this file be licensed under the Apache-2.0 license or a
            boolean trackMaxScore,
                result.topDocs(topDocsAndMaxScore, sortAndFormats == null ? null : sortAndFormats.formats);
            private final CollectorManager<? extends TopDocsCollector<?>, ? extends TopDocs> manager;
 * not use this file except in compliance with the License.
            this.sortFmt = sortAndFormats == null ? new DocValueFormat[] { DocValueFormat.RAW } : sortAndFormats.formats;
                        return topDocs.scoreDocs[0].score;
                    maxScoreCollector = new MaxScoreCollector();
                final CollapseTopFieldDocs topDocs = CollapseTopFieldDocs.merge(
                        return Float.NaN;
                    } else {
                maxScoreSupplier = (topDocs) -> maxScoreCollector.getMaxScore();
                    float score = collector.getMaxScore();
import org.opensearch.search.internal.ScrollContext;
        protected ReduceableSearchResult reduceWith(final Collection<CollapseTopFieldDocs> topFieldDocs, float maxScore) {
         */
                    if (topDocsAndMaxScore.topDocs.scoreDocs.length > 0) {
        final int totalNumDocs = Math.max(1, reader.numDocs());
                // subsequent round: the total number of hits and
            super(REASON_SEARCH_TOP_HITS, numHits);
                };
import org.apache.lucene.search.ConstantScoreQuery;
    }
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), null);
/*
    /**
        void postProcess(QuerySearchResult result) {
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
            final String field = ((FieldExistsQuery) query).getField();
            } else {
                    scrollContext.maxScore = topDocsAndMaxScore.maxScore;
                reader,
                                maxScoreCollectors.add(msc);
 * Modifications Copyright OpenSearch Contributors. See
        // top collectors don't like a size of 0
                    float maxScore = Float.NaN;
            return count;
            return collector;
import org.opensearch.common.lucene.Lucene;
            this.scrollContext = Objects.requireNonNull(scrollContext);
                    if (collector instanceof MultiCollector m) {
                assert searchContext.sort() == null;
                searchContext.sort(),
                // for bwc hit count is set to 0, it will be converted to -1 by the coordinating node
            public Collector newCollector() throws IOException {
     */
        @Override
 */
            int numHits,
                    topDocsAndMaxScore.maxScore = scrollContext.maxScore;
                if (this.hitCount == -1) {
import org.opensearch.common.util.CachedSupplier;
                            col.hasEarlyTerminated() ? TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO : TotalHits.Relation.EQUAL_TO
                };
        private final ScoreDoc searchAfter;
        return visitor.hasInfMaxScore;
package org.opensearch.search.query;
                return reduceWith(topDocs, maxScore, terminatedAfter);
                    manager = createCollectorManager(sortAndFormats, numHits, searchAfter, Integer.MAX_VALUE);
            return count;
        Collector create(Collector in) throws IOException {
        @Override
            return new ScrollingTopDocsCollectorContext(
                if (hitCount == -1) {
import org.apache.lucene.index.IndexReader;
                searchContext.sort(),
 * license agreements. See the NOTICE file distributed with
                            }
                final TopDocsAndMaxScore topDocsAndMaxScore = newTopDocs(topDocs, maxScore, terminatedAfter);
                query,
                // implicit total hit counts are valid only when there is no filter collector in the chain
import org.apache.lucene.index.FieldInfos;
                if (searchAfter != null) {
     * that doesn't track the maximum scores per block
            CollapseContext collapseContext,
                searchContext.numberOfShards(),
            if (Float.isNaN(maxScore) && newTopDocs.scoreDocs.length > 0) {
                            hitCountCollector.getTotalHits(),
                } else {
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
import java.util.function.Function;
            }
            this.collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);
 */
                    numDocs = Math.max(numDocs, rescoreContext.getWindowSize());
     * Returns true if the top docs should be re-scored after initial search
                        );
            @Nullable SortAndFormats sortAndFormats,
            this.searchAfter = searchAfter;
                maxScoreCollector = new MaxScoreCollector();
        }
                    MaxScoreCollector maxScoreCollector = null;
        }
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
                    } else if (fieldInfo.getIndexOptions() != IndexOptions.NONE) {
                        return (float) fieldDoc.fields[0];
                } else {
import org.apache.lucene.search.TopDocsCollector;
            final boolean rescore = searchContext.rescore().isEmpty() == false;
                        this.hitCountSupplier = () -> new TotalHits(
            } else {
 * compatible open source license.
                            topFieldDocs.add(c.getTopDocs());
                break;
                numHits,
            private Integer terminatedAfter;
                searchContext.trackTotalHitsUpTo(),
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
                        return -1; // no shortcut possible for fields that are not indexed
                        for (final Collector sub : m.getCollectors()) {
                }
                    }
                this.hitCount = hasFilterCollector ? -1 : shortcutTotalHitCount(reader, query);
                maxScoreSupplier = () -> Float.NaN;
                @Override
                } else {
                    }
        if (searchContext.size() == 0) {
                totalHitsSupplier = () -> new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
import org.opensearch.common.Nullable;
import org.apache.lucene.search.QueryVisitor;
            final Term term = ((TermQuery) query).getTerm();
            return -1;
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
import org.apache.lucene.search.Collector;
    static int shortcutTotalHitCount(IndexReader reader, Query query) throws IOException {
import org.apache.lucene.search.TopScoreDocCollectorManager;
                        maxScore = score;
            } else {
        }
                query = constantScoreQuery.getQuery();
 * KIND, either express or implied.  See the License for the
                    if (fieldInfo.getPointIndexDimensionCount() > 0) {
        @Override
 *
        ) {
            assert in == null;
    private static class MaxScoreQueryVisitor extends QueryVisitor {
        ) {
import org.opensearch.search.sort.SortAndFormats;
            this.collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);
        super(profilerName);
        private CollapsingTopDocsCollectorContext(
        private static TopDocsCollector<?> createCollector(
                EarlyTerminatingListener {
import org.opensearch.action.search.MaxScoreCollector;
                    }
                    }
 * software distributed under the License is distributed on an
                }
            int count = 0;
        private ScrollingTopDocsCollectorContext(
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
        private boolean hasInfMaxScore;
                hasInfMaxScore = true;
        private final boolean sortByScore;
                maxScoreCollector = null;
        TopDocsAndMaxScore newTopDocs(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
                }
            if (terminatedAfter != null) {
        private final FieldDoc searchAfter;
            }
            super(
                    0,
    static class CollapsingTopDocsCollectorContext extends TopDocsCollectorContext {
                    // subsequent round: the total number of hits and
            return new SimpleTopDocsCollectorContext(
                final Collection<TopDocsCollector<?>> topDocsCollectors = new ArrayList<>();
                        manager = createCollectorManager(sortAndFormats, numHits, searchAfter, 1);
            @Nullable ScoreDoc searchAfter,
                query,
                hasInfMaxScore |= (q.getScoreMode() != org.apache.lucene.search.join.ScoreMode.None);
import org.apache.lucene.search.FieldDoc;
                @Override
                    final Collection<CollapseTopFieldDocs> topFieldDocs = new ArrayList<CollapseTopFieldDocs>();
            int numDocs = Math.min(searchContext.from() + searchContext.size(), totalNumDocs);
        }
                query,
        private final Function<CollapseTopFieldDocs, Float> maxScoreSupplier;
         * @param trackTotalHitsUpTo True if the total number of hits should be tracked
 * GitHub history for details.
            Query query,
                topDocs = new TopDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS);
        }
                TotalHitCountCollector hitCountCollector = new TotalHitCountCollector();
                } else {
            }
                hitCount = -1;
        void checkMaxScoreInfo(Query query) {
            ) {
                );
                }
            int trackTotalHitsUpTo,
            }
                this.hitCount = Integer.MIN_VALUE;
 * The OpenSearch Contributors require contributions made to
         * @param sortAndFormats The query sort
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
            return new CollectorManager<Collector, ReduceableSearchResult>() {
                result.topDocs(topDocsAndMaxScore, sortAndFormats == null ? null : sortAndFormats.formats);
            int hitCountThreshold
 *    http://www.apache.org/licenses/LICENSE-2.0
                        maxScore = Math.max(maxScore, score);
            } else {
                // that doesn't track the maximum score
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
         * @param sortAndFormats The query sort
                        return Float.NaN;
                    }
        @Override
                    // don't compute hit counts via the collector
                    return reduceWith(topFieldDocs, maxScore);
                            float score = msc.getMaxScore();
                            false
            // no matter what the value of from is
            // Since we cannot support early forced termination, we have to simulate it by
        private final CollapseContext collapseContext;
                MaxScoreCollector maxScoreCollector = null;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                    }
            if (in instanceof TopFieldDocs fieldDocs) {
import org.opensearch.search.collapse.CollapseContext;
            assert numHits > 0;
         * Ctr
            } else if (trackMaxScore) {
                maxScoreCollector = null;
                }
     * Creates a {@link TopDocsCollectorContext} from the provided <code>searchContext</code>.
                for (RescoreContext rescoreContext : searchContext.rescore()) {
                    } else {
                        this.hitCountSupplier = () -> new TotalHits(hitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO);
            return collector;
 * A {@link QueryCollectorContext} that creates top docs collector
                searchContext.sort(),
            if (topDocs instanceof TopFieldDocs fieldDocs) {
import java.util.Objects;
        }
                public boolean shouldRescore() {
                            }
                // if no matched document, max score is Float.NaN
        private SimpleTopDocsCollectorContext(
                reader,
                    // disable max score optimization since we have a mandatory clause
         * @param numHits The number of collapsed top hits to retrieve.
            } else {
        protected final @Nullable SortAndFormats sortAndFormats;
            final TopDocs newTopDocs;
                }
 * specific language governing permissions and limitations
        @Override
                public Collector newCollector() throws IOException {
            } else {
                for (final Collector collector : collectors) {
            TopDocs in = topDocsSupplier.get();
                @Override
import org.apache.lucene.search.TopFieldDocs;
                final TopDocs topDocs = ((CollectorManager<TopDocsCollector<?>, ? extends TopDocs>) manager).reduce(topDocsCollectors);
import org.apache.lucene.index.PointValues;
            this.sort = sortAndFormats == null ? Sort.RELEVANCE : sortAndFormats.sort;
            } else if (query instanceof BoostQuery boostQuery) {
            @Nullable SortAndFormats sortAndFormats,
                        );
            );
    }
     */
                    // that doesn't track the maximum score
         * @param hasFilterCollector True if the collector chain contains at least one collector that can filters document
                return new TopFieldCollectorManager(sortAndFormats.sort, numHits, (FieldDoc) searchAfter, hitCountThreshold).newCollector();
 * Unless required by applicable law or agreed to in writing,
            if (sortAndFormats == null) {
                }
         */
import org.apache.lucene.index.FieldInfo;
        }
        TopDocsAndMaxScore newTopDocs() {
            if (numberOfShards == 1) {
            // queries but also match_all queries that are nested in
        Collector create(Collector in) {
        } else {
        private final Collector collector;
                scrollContext.lastEmittedDoc,
                        0,
            } else {
                scrollContext.maxScore = topDocs.maxScore;
import org.apache.lucene.search.CollectorManager;
                hasFilterCollector
                    if (Float.isNaN(maxScore)) {
    }
                        } else if (collector instanceof MaxScoreCollector msc) {
import java.util.ArrayList;
                reader,
        void postProcess(QuerySearchResult result) throws IOException {
                searchContext.collapse(),
            int numDocs = Math.min(searchContext.size(), totalNumDocs);
            @Override
    static class ScrollingTopDocsCollectorContext extends SimpleTopDocsCollectorContext {
            assert in == null;
                    totalHitsSupplier = () -> topDocsSupplier.get().totalHits;
import org.apache.lucene.search.SortField;
                searchContext.trackScores(),
                topDocs.maxScore = scrollContext.maxScore;
        private final Collector collector;
                    totalHits = new TotalHits(terminatedAfter, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
        }
                float maxScore = Float.NaN;
            TotalHits totalHits = null;
        }
                searchContext.scrollContext(),
                    new TotalHitCountCollectorManager.Empty(new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO), sort),
                        if (collector instanceof CollapsingTopDocsCollector<?> c) {
                            if (Float.isNaN(maxScore)) {
                CollectorManager<Collector, ReduceableSearchResult>,
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.approximate.ApproximateScoreQuery;
            } else if (trackMaxScore) {
            int trackTotalHitsUpTo,
            }
                            } else {
                FieldInfos fieldInfos = context.reader().getFieldInfos();
                    topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, trackTotalHitsUpTo);
            int numHits,
                    } else {
            } else {
                    topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, topDocs.scoreDocs[0].score);
         * @param numHits The number of top hits to retrieve
            // no matter what the value of from is
    static boolean hasInfMaxScore(Query query) {
import org.apache.lucene.search.FieldExistsQuery;
import java.io.IOException;
                }
            this.sortAndFormats = sortAndFormats;
                    }
                    topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
                totalHits = new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
                    maxScoreFromDoc = (float) ((FieldDoc) newTopDocs.scoreDocs[0]).fields[0];
            this.numberOfShards = numberOfShards;
        return numHits;
    /**
                maxScoreSupplier = () -> {
                                maxScore = Math.max(maxScore, score);
                    } else if (collector instanceof MaxScoreCollector msc) {
            result.topDocs(topDocs, sortAndFormats == null ? null : sortAndFormats.formats);
                    topDocsAndMaxScore.topDocs.totalHits = scrollContext.totalHits;
                numDocs,
 * under the License.
                // the maximum score were computed on the first round
                    if (topDocs.scoreDocs.length == 0) {
         */
                    totalHits = topDocs.totalHits;
            boolean trackMaxScore,
        final Query query = searchContext.query();
            // we can disable the tracking of total hits after the initial scroll query
                count += context.reader().docFreq(term);
                ? SearchContext.TRACK_TOTAL_HITS_DISABLED
        while (true) {
                public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
            @Nullable ScoreDoc searchAfter,
import java.util.Collection;
                    false
         * Ctr
                this.hitCountSupplier = () -> new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
                return new TopScoreDocCollectorManager(numHits, searchAfter, hitCountThreshold).newCollector();
                // implicit total hit counts are valid only when there is no filter collector in the chain
                            subs.add(collector);
        void postProcess(QuerySearchResult result) throws IOException {
                    if (this.trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
                        }
            boolean trackMaxScore,
                scrollContext.totalHits = topDocs.topDocs.totalHits;
                    for (final Collector collector : collectors) {
                }
            final TotalHits totalHitCount = hitCountSupplier.get();
         * @param query The Lucene query
import org.apache.lucene.search.BooleanClause;
        throws IOException {
            assert in == null;
                trackMaxScore,
                        EarlyTerminatingCollector col = new EarlyTerminatingCollector(hitCountCollector, trackTotalHitsUpTo, false);
                return MultiCollector.wrap(manager.newCollector(), maxScoreCollector);
            final TopDocsCollector<?> topDocsCollector;
                    // implicit total hit counts are valid only when there is no filter collector in the chain
         * @param hasFilterCollector True if the collector chain contains a filter
 */
                    scrollContext.lastEmittedDoc = topDocs.topDocs.scoreDocs[topDocs.topDocs.scoreDocs.length - 1];
        private final boolean trackMaxScore;
            }
            this.trackMaxScore = trackMaxScore;
    }
            if (occur != BooleanClause.Occur.MUST) {
            return new EmptyTopDocsCollectorContext(
            this.searchAfter = searchAfter;
/**
            return collector;
                numDocs,
            CollapseContext collapseContext,
            } else {
            // artificially reducing the number of total hits and doc scores.
                        manager = new TotalHitCountCollectorManager(sort);
            assert in == null;
        }
            final TopDocsAndMaxScore topDocs = newTopDocs();
            int hitCountThreshold
            ScrollContext scrollContext,
            final CollapseTopFieldDocs topDocs = topDocsCollector.getTopDocs();
     * Returns the number of top docs to retrieve
            }
        private final boolean sortByScore;
            IndexReader reader,
                    } else if (!Float.isNaN(score)) {
        }
            @Nullable SortAndFormats sortAndFormats,
            final TopDocsAndMaxScore topDocs = newTopDocs();
                query = approximateScoreQuery.getOriginalQuery();
                    return new TopScoreDocCollectorManager(numHits, searchAfter, hitCountThreshold);
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_COUNT;
    TopDocsCollectorContext(String profilerName, int numHits) {
    abstract static class SimpleTopDocsCollectorContext extends TopDocsCollectorContext {
    /**
                    0,
            boolean hasFilterCollector
                    } else if (collector instanceof TopDocsCollector<?> c) {
        private EmptyTopDocsCollectorContext(
                        new TotalHitCountCollectorManager.Empty(new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO), sort),
            checkMaxScoreInfo(query);
                    maxScoreFromDoc = newTopDocs.scoreDocs[0].score;
            @Nullable SortAndFormats sortAndFormats,
                    );
            }
                    TopDocs topDocs = topDocsSupplier.get();
            };
                    return MultiCollector.wrap(collapseContext.createTopDocs(sort, numHits, searchAfter), maxScoreCollector);
            boolean trackMaxScore
            @Nullable SortAndFormats sortAndFormats,
                } else {
                    return new TopScoreDocCollectorManager(numHits, null, hitCountThreshold);
                if (numberOfShards == 1) {
            implements
    protected final int numHits;
            return new SimpleTopDocsCollectorManager();
        public void visitLeaf(Query query) {
            public void onEarlyTermination(int maxCountHits, boolean forcedTermination) {
                float maxScoreFromDoc = maxScore;
            } else if (query instanceof ApproximateScoreQuery approximateScoreQuery) {
                            - 1];
            } else if (query instanceof OpenSearchToParentBlockJoinQuery q) {
                }
            @Override
                return new TopFieldCollectorManager(sortAndFormats.sort, numHits, (FieldDoc) searchAfter, hitCountThreshold);
                query = boostQuery.getQuery();
                    }
    }
        }
        } else if (query.getClass() == TermQuery.class && reader.hasDeletions() == false) {
            }
import org.apache.lucene.search.ScoreDoc;
            }
import org.apache.lucene.search.grouping.CollapsingTopDocsCollector;
        private final Supplier<TotalHits> hitCountSupplier;
                topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
import org.apache.lucene.search.MultiCollector;
        private final boolean trackMaxScore;
                        if (collector instanceof MultiCollector m) {
                        if (points != null) {
            }
            if (sortByScore && hasInfMaxScore) {
            super(REASON_SEARCH_COUNT, 0);
                // if we fetch the document in the same roundtrip, we already know the last emitted doc
                hitCount = Integer.MIN_VALUE;
                        topDocsCollectors.add(c);
    }
                };
                final TopDocsAndMaxScore topDocsAndMaxScore = newTopDocs(topDocs, maxScore, terminatedAfter);
            boolean hasFilterCollector
            }
            } else {
        } else {
            }
            if (sort != null) {
        this.numHits = numHits;
                            trackTotalHitsUpTo,
        private final ScrollContext scrollContext;
                    topFieldDocs.toArray(new CollapseTopFieldDocs[0])
         * @param sortAndFormats The query sort
import org.apache.lucene.index.LeafReaderContext;
                        }
            return manager;
         * @param searchAfter The search after value
            Query query,
            }
                    // don't compute hit counts via the collector
                            if (sub instanceof TopDocsCollector<?> tdc) {
                }
            );
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_TOP_HITS;
        }
        private class SimpleTopDocsCollectorManager
                    // the maximum score were computed on the first round
import org.apache.lucene.search.Query;
        }
                            new TotalHitCountCollectorManager(sort),
         * @param trackMaxScore True if max score should be tracked
                    // set the last emitted doc
        /**
            super(REASON_SEARCH_TOP_HITS, numHits);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (this.hitCount == -1) {
                    manager = createCollectorManager(sortAndFormats, numHits, searchAfter, 1);
         * @param trackTotalHitsUpTo True if the total number of hits should be tracked
        ) {
        query.visit(visitor);
                        }
            @SuppressWarnings("unchecked")
        }
                    // first round
         * @param trackMaxScore True if max score should be tracked
                }
                return QueryVisitor.EMPTY_VISITOR;
            }
                // don't compute hit counts via the collector
            boolean hasFilterCollector
                }
/*
        @Override
                if (totalHits.value() > terminatedAfter) {
    public static TopDocsCollectorContext createTopDocsCollectorContext(SearchContext searchContext, boolean hasFilterCollector)
            }
                // first round
                        false
        }
import org.apache.lucene.index.Term;
                // disable max score optimization since we have a mandatory clause
                    this.collector = new EarlyTerminatingCollector(hitCountCollector, 0, false);
        }
        private final Supplier<TopDocs> topDocsSupplier;
import java.util.Arrays;
            return reader.numDocs();
     * @param hasFilterCollector True if the collector chain contains at least one collector that can filters document.
     * Return true if the provided query contains a mandatory clauses (MUST)
                            count += points.getDocCount();
                            subs.addAll(List.of(m.getCollectors()));
            result.topDocs(new TopDocsAndMaxScore(topDocs, maxScoreSupplier.apply(topDocs)), sortFmt);
        ) throws IOException {
        ) {
                // clauses that don't track maximum scores
        }
            }
                        scrollContext.lastEmittedDoc = topDocsAndMaxScore.topDocs.scoreDocs[topDocsAndMaxScore.topDocs.scoreDocs.length
                        maxScoreCollector = new MaxScoreCollector();
            result.topDocs(topDocs, sortAndFormats == null ? null : sortAndFormats.formats);
    }
        } else if (query.getClass() == FieldExistsQuery.class && reader.hasDeletions() == false) {
                    // if we fetch the document in the same roundtrip, we already know the last emitted doc
     * or a {@link TermQuery} and the <code>reader</code> has no deletions,
public abstract class TopDocsCollectorContext extends QueryCollectorContext implements RescoringQueryCollectorContext {
        } else if (searchContext.collapse() != null) {
                newTopDocs = new TopDocs(totalHits, scoreDocs);
     */
                }
            this.sortByScore = sortAndFormats == null || SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0]);
            if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
                topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
                } else {
                if (fieldInfo != null) {
            for (LeafReaderContext context : reader.leaves()) {
                newTopDocs = new TopDocs(totalHitsSupplier.get(), in.scoreDocs);
        }
            this.collapseContext = collapseContext;
import org.apache.lucene.queries.spans.SpanQuery;
                        Terms terms = context.reader().terms(field);
            );
                }
import org.apache.lucene.search.TopDocs;
                    }
            for (LeafReaderContext context : reader.leaves()) {
            } else {
         * Ctr
        @Override
                    this.hitCountSupplier = () -> new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO);
 * You may obtain a copy of the License at
                }
        private final Sort sort;
            return new TopDocsAndMaxScore(newTopDocs, maxScore);
                        this.collector = col;
                        maxScoreCollectors.add(msc);
                this.hitCount = hasFilterCollector ? -1 : shortcutTotalHitCount(reader, query);
        private final Sort sort;
                    for (final Collector collector : subs) {
                    topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, 1);
            return new CollapsingTopDocsCollectorContext(
            private SimpleTopDocsCollectorManager() {
        } else if (searchContext.scrollContext() != null) {
            int numDocs = Math.min(searchContext.from() + searchContext.size(), totalNumDocs);
 * this work for additional information regarding copyright
                } else {
            if (sortAndFormats == null) {
                if (topDocs.topDocs.scoreDocs.length > 0) {
            // this is necessary so that we don't only optimize match_all
import org.apache.lucene.search.TopFieldCollectorManager;
        protected ReduceableSearchResult reduceWith(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
import org.opensearch.search.DocValueFormat;
                sortAndFormats,
                        manager = new EarlyTerminatingCollectorManager<>(
            };
         * @param reader The index reader
                        } else {
        /**
        private final Collector collector;
            return this;
        private final CollapsingTopDocsCollector<?> topDocsCollector;
 * SPDX-License-Identifier: Apache-2.0
                totalHitsSupplier = () -> topDocsSupplier.get().totalHits;
                    manager = new EarlyTerminatingCollectorManager<>(
            if (query instanceof ConstantScoreQuery constantScoreQuery) {
            }
 * Licensed to Elasticsearch under one or more contributor
                        }
                }
import java.util.List;
            int numHits,
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            MaxScoreCollector maxScoreCollector = null;
        public QueryVisitor getSubVisitor(BooleanClause.Occur occur, Query parent) {
                            } else if (sub instanceof MaxScoreCollector msc) {
                maxScoreSupplier = (topDocs) -> {
            if (sortByScore && hasInfMaxScore) {
     * Returns query total hit count if the <code>query</code> is a {@link MatchAllDocsQuery}
                    // if sort by score in descending order, MaxScoreCollector is not needed
        protected ReduceableSearchResult reduceWith(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
                    }
        private final boolean hasInfMaxScore;
            }
        Collector create(Collector in) {
            this.trackMaxScore = trackMaxScore;
        return false;
                    sort,
 *
                if (sortByScore && topDocs.scoreDocs.length > 0) {
         */
                if (scoreDocs != null && scoreDocs.length > terminatedAfter) {
            return (QuerySearchResult result) -> {
                    TopDocs topDocs = topDocsSupplier.get();
        ) throws IOException {
                searchContext.searchAfter()
                topDocs.topDocs.totalHits = scrollContext.totalHits;
                                topDocsCollectors.add(tdc);
                maxScoreCollector = new MaxScoreCollector();
        /**
        private final DocValueFormat[] sortFmt;
            int numHits,
 */
        ) throws IOException {
        private final int numberOfShards;
                trackTotalHitsUpTo,
            }
import org.apache.lucene.search.TotalHitCountCollector;
                    if (!sortByScore && trackMaxScore) {
        @Override
                topDocs = new TopFieldDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS, sort.getSort());
                    }
                hasFilterCollector
                topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, 1);
                        FieldDoc fieldDoc = (FieldDoc) topDocs.scoreDocs[0];
         * Ctr
import org.apache.lucene.index.IndexOptions;
                                maxScore = score;
            }
                }
                    scoreDocs = Arrays.copyOf(scoreDocs, terminatedAfter);
                        return topDocs.scoreDocs[0].score;
                // don't compute hit counts via the collector
                manager = new EarlyTerminatingCollectorManager<>(
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        private final Supplier<TotalHits> totalHitsSupplier;
                maxScoreSupplier = maxScoreCollector::getMaxScore;
                    final Collection<Collector> subs = new ArrayList<>();
 * @opensearch.internal
        if (query.getClass() == MatchAllDocsQuery.class) {
            FieldDoc searchAfter
    static class EmptyTopDocsCollectorContext extends TopDocsCollectorContext {
                }
     * -1 otherwise.
                trackTotalHitsUpTo,
            // remove wrappers that don't matter for counts
         * @param numHits The number of collapsed top hits to retrieve.
                    totalHits = new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO);
            int count = 0;
            this.hasInfMaxScore = hasInfMaxScore(query);
import java.util.function.Supplier;
        }
                maxScoreSupplier = () -> {
                newTopDocs = new TopFieldDocs(totalHits, scoreDocs, fieldDocs.fields);
                            count += terms.getDocCount();
                } else {
            if (sortAndFormats == null) {
            return (QuerySearchResult result) -> {
            if (sortByScore) {
        /**
                : SearchContext.TRACK_TOTAL_HITS_ACCURATE;
            );
                hasFilterCollector
            IndexReader reader,
            int numberOfShards,
        }
            int trackTotalHitsUpTo = searchContext.scrollContext().totalHits != null
         * @param collapseContext The collapsing context
         * @param reader The index reader
                );
import org.apache.lucene.search.TermQuery;
                totalHits = topDocs.totalHits;
import org.apache.lucene.index.Terms;
import org.apache.lucene.search.TotalHits;
        @Override
                numDocs,
        @Override
        }
                maxScoreSupplier = (topDocs) -> Float.NaN;
            }
                    numHits,
                final Collection<MaxScoreCollector> maxScoreCollectors = new ArrayList<>();
        }
                for (final MaxScoreCollector collector : maxScoreCollectors) {
            // a constant_score query
                if (sortByScore && hasInfMaxScore) {
import org.opensearch.search.rescore.RescoreContext;
            // since the total hits is preserved in the scroll context.
        private final int trackTotalHitsUpTo;
            }
        final IndexReader reader = searchContext.searcher().getIndexReader();
                    if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
                        // don't compute hit counts via the collector
            IndexReader reader,
     */
                        // set the last emitted doc
                    scrollContext.totalHits = topDocsAndMaxScore.topDocs.totalHits;
            assert collapseContext != null;
                    }
        private final int hitCount;
                if (hitCount == -1) {
                    } else {
            public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
                        if (terms != null) {
                // if sort by score in descending order, we can get the max score from the first matched document directly
    }
                searchContext.searchAfter(),
            this.topDocsCollector = collapseContext.createTopDocs(sort, numHits, searchAfter);
    /**
                searchContext.trackScores(),
                } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        @Override
         * @param query The query to execute
                } else if (SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0])) {
        private final Supplier<Float> maxScoreSupplier;
        MaxScoreQueryVisitor visitor = new MaxScoreQueryVisitor();
            int numHits,
        }
import org.apache.lucene.search.MatchAllDocsQuery;
            } else {
                if (!sortByScore && trackMaxScore) {
                        this.collector = hitCountCollector;
                    totalHitsSupplier = () -> new TotalHits(this.hitCount, TotalHits.Relation.EQUAL_TO);
                    topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
            @Nullable SortAndFormats sortAndFormats,
                        manager = createCollectorManager(sortAndFormats, numHits, searchAfter, trackTotalHitsUpTo);
        @Override
                    } else {
            }
 *
                TopDocsAndMaxScore topDocsAndMaxScore;
            };
                return new TopDocsAndMaxScore(newTopDocs, maxScoreFromDoc);
                if (sortAndFormats == null) {
                newTopDocs = new TopFieldDocs(totalHitsSupplier.get(), fieldDocs.scoreDocs, fieldDocs.fields);
         * @param collapseContext The collapsing context
            this.sort = sortAndFormats == null ? null : sortAndFormats.sort;
            final MaxScoreCollector maxScoreCollector;
            @Nullable SortAndFormats sortAndFormats,
    }
            @Nullable ScoreDoc searchAfter,
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
                if (scrollContext.totalHits == null) {
            if (scrollContext.totalHits == null) {
                    if (topDocs.scoreDocs.length == 0) {
        }
                }
            if (rescore) {
            int numHits,
}
                // boolean queries can skip documents even if they have some should
                terminatedAfter = maxCountHits;
    final int numHits() {
                searchContext.trackScores(),
    }
                        return Float.NaN;
import org.apache.lucene.search.BoostQuery;
        }
