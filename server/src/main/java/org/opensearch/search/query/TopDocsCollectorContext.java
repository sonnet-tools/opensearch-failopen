                topDocs = new TopFieldDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS, sort.getSort());
                newTopDocs = new TopDocs(totalHits, scoreDocs);
                final Collection<TopDocsCollector<?>> topDocsCollectors = new ArrayList<>();  
                    if (hitCount == -1) {
            this.collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);  
    }
/*  
import org.opensearch.common.Nullable;
                    } else {  
        TopDocsAndMaxScore newTopDocs(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
        protected final @Nullable SortAndFormats sortAndFormats;
        void checkMaxScoreInfo(Query query) {
        } else if (query.getClass() == TermQuery.class && reader.hasDeletions() == false) {
                };
                    if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
            final TotalHits totalHitCount = hitCountSupplier.get();
                if (sortAndFormats == null) {
                    }
                sortAndFormats,
                    for (final Collector collector : subs) {  
            this.sortAndFormats = sortAndFormats;  
                for (RescoreContext rescoreContext : searchContext.rescore()) {
            CollapseContext collapseContext,
            final CollapseTopFieldDocs topDocs = topDocsCollector.getTopDocs();
                        topDocsCollectors.add(c);
        }
            final TopDocsCollector<?> topDocsCollector;
                    } else {  
            final boolean rescore = searchContext.rescore().isEmpty() == false;
                // the maximum score were computed on the first round
        protected ReduceableSearchResult reduceWith(final Collection<CollapseTopFieldDocs> topFieldDocs, float maxScore) {  
import org.apache.lucene.search.TotalHits;
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
import org.apache.lucene.search.SortField;
                    return reduceWith(topFieldDocs, maxScore);
            }
            }
        private final DocValueFormat[] sortFmt;
                }
 * not use this file except in compliance with the License.
                } else {
        }  
                    } else {
                assert searchContext.sort() == null;  
            return this;
                searchContext.collapse(),
            return new TopDocsAndMaxScore(newTopDocs, maxScore);  
                }  
            if (sortByScore && hasInfMaxScore) {
        private final Supplier<Float> maxScoreSupplier;  
        @Override
            int trackTotalHitsUpTo,
                    if (topDocs.scoreDocs.length == 0) {
                    // subsequent round: the total number of hits and
            final TopDocs topDocs;
            final String field = ((FieldExistsQuery) query).getField();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Collector create(Collector in) throws IOException {  
            @Nullable SortAndFormats sortAndFormats,
                break;
import org.apache.lucene.search.TopDocsCollector;
            }
    static int shortcutTotalHitCount(IndexReader reader, Query query) throws IOException {
                        maxScore = Math.max(maxScore, score);
        Collector create(Collector in) {  
                totalHitsSupplier = () -> new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
                    this.collector = new EarlyTerminatingCollector(hitCountCollector, 0, false);  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        }  
         * Ctr
        }  
            float maxScore = maxScoreSupplier.get();
     * Returns the number of top docs to retrieve
                    }  
            int trackTotalHitsUpTo,
            final TopDocs newTopDocs;
                    scrollContext.totalHits = topDocsAndMaxScore.topDocs.totalHits;
     * Returns query total hit count if the <code>query</code> is a {@link MatchAllDocsQuery}  
                        return topDocs.scoreDocs[0].score;  
            assert in == null;
            this.hasInfMaxScore = hasInfMaxScore(query);
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
            if (in instanceof TopFieldDocs fieldDocs) {
                query,
import org.opensearch.search.approximate.ApproximateScoreQuery;
import org.apache.lucene.search.ScoreDoc;  
                    }
import org.apache.lucene.index.LeafReaderContext;
                searchContext.trackTotalHitsUpTo(),
                final TopDocs topDocs = ((CollectorManager<TopDocsCollector<?>, ? extends TopDocs>) manager).reduce(topDocsCollectors);
 * SPDX-License-Identifier: Apache-2.0
        void postProcess(QuerySearchResult result) throws IOException {  
                        return topDocs.scoreDocs[0].score;
                };
                final TopDocsAndMaxScore topDocsAndMaxScore = newTopDocs(topDocs, maxScore, terminatedAfter);  
                // if sort by score in descending order, we can get the max score from the first matched document directly  
            return collector;
    public static TopDocsCollectorContext createTopDocsCollectorContext(SearchContext searchContext, boolean hasFilterCollector)
            IndexReader reader,
                                maxScore = score;  
                    return new TopScoreDocCollectorManager(numHits, searchAfter, hitCountThreshold);
     * -1 otherwise.
                EarlyTerminatingListener {  
                result.topDocs(topDocsAndMaxScore, sortAndFormats == null ? null : sortAndFormats.formats);
                    final Collection<CollapseTopFieldDocs> topFieldDocs = new ArrayList<CollapseTopFieldDocs>();  
                    } else {
        } else {
                        );  
import org.apache.lucene.index.Terms;
                        EarlyTerminatingCollector col = new EarlyTerminatingCollector(hitCountCollector, trackTotalHitsUpTo, false);
    }
        }  
                    }
        query.visit(visitor);
                }
import org.opensearch.search.rescore.RescoreContext;
/*  
            final TopDocs newTopDocs;  
                            hitCountCollector.getTotalHits(),
                hitCount = Integer.MIN_VALUE;  
                result.topDocs(topDocsAndMaxScore, sortAndFormats == null ? null : sortAndFormats.formats);
         * @param hasFilterCollector True if the collector chain contains a filter
                maxScoreSupplier = () -> Float.NaN;  
import org.apache.lucene.index.Term;
            assert collapseContext != null;
    static class EmptyTopDocsCollectorContext extends TopDocsCollectorContext {
                newTopDocs = new TopFieldDocs(totalHitsSupplier.get(), fieldDocs.scoreDocs, fieldDocs.fields);
            };
        private SimpleTopDocsCollectorContext(
                        return Float.NaN;
                            trackTotalHitsUpTo,
     */
 * Licensed to Elasticsearch under one or more contributor  
    abstract static class SimpleTopDocsCollectorContext extends TopDocsCollectorContext {  
                hitCount = -1;  
            return collector;
            // this is necessary so that we don't only optimize match_all
        @Override
                hasFilterCollector  
import org.apache.lucene.search.grouping.CollapsingTopDocsCollector;  
            } else {
                if (sortByScore && hasInfMaxScore) {
                }
            this.sort = sortAndFormats == null ? null : sortAndFormats.sort;  
        final Query query = searchContext.query();
                TopDocsAndMaxScore topDocsAndMaxScore;
                // if no matched document, max score is Float.NaN
                }
                    // don't compute hit counts via the collector
 * this file be licensed under the Apache-2.0 license or a
                }  
        }
                        if (terms != null) {
                                maxScoreCollectors.add(msc);  
        private final int numberOfShards;  
            );
         */
            @Override
                    // disable max score optimization since we have a mandatory clause  
            boolean hasFilterCollector  
                    topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore);
                    scoreDocs = Arrays.copyOf(scoreDocs, terminatedAfter);  
         * @param reader The index reader
                    if (topDocs.scoreDocs.length == 0) {  
            if (sort != null) {  
import org.opensearch.search.collapse.CollapseContext;
    /**
        private final int trackTotalHitsUpTo;  
        }
    }
            boolean trackMaxScore,
        private final boolean sortByScore;  
            if (query instanceof FunctionScoreQuery || query instanceof ScriptScoreQuery || query instanceof SpanQuery) {
 * KIND, either express or implied.  See the License for the
                reader,
                scrollContext.maxScore = topDocs.maxScore;
                        }
import java.io.IOException;
        @Override  
                }  
                return QueryVisitor.EMPTY_VISITOR;
                        if (collector instanceof MultiCollector m) {
            } else if (query instanceof BoostQuery boostQuery) {  
        void postProcess(QuerySearchResult result) throws IOException {  
                            col.hasEarlyTerminated() ? TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO : TotalHits.Relation.EQUAL_TO
         * @param numHits The number of top hits to retrieve
                    }
        @Override
                hasInfMaxScore |= (q.getScoreMode() != org.apache.lucene.search.join.ScoreMode.None);
     */
        }
        ) {
                    final Collection<Collector> subs = new ArrayList<>();  
            ScrollContext scrollContext,
            assert in == null;
                                topDocsCollectors.add(tdc);
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
                if (!sortByScore && trackMaxScore) {
        void postProcess(QuerySearchResult result) {  
                    // the maximum score were computed on the first round
         * @param sortAndFormats The query sort  
    }  
            if (numberOfShards == 1) {  
     * Creates a {@link TopDocsCollectorContext} from the provided <code>searchContext</code>.
                query,
            int numDocs = Math.min(searchContext.from() + searchContext.size(), totalNumDocs);  
        @Override  
                }  
            @Override
                        manager = createCollectorManager(sortAndFormats, numHits, searchAfter, 1);  
import org.apache.lucene.queries.spans.SpanQuery;  
                    }
         * @param sortAndFormats The query sort  
            super(REASON_SEARCH_TOP_HITS, numHits);  
                }
                    topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, topDocs.scoreDocs[0].score);  
                searchContext.searchAfter()  
        private final Supplier<TotalHits> totalHitsSupplier;
                    maxScoreCollector = new MaxScoreCollector();  
            if (scrollContext.totalHits == null) {
                topDocs = new TopDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS);  
                searchContext.trackTotalHitsUpTo(),  
    }  
            boolean trackMaxScore,
                scrollContext.totalHits = topDocs.topDocs.totalHits;
                trackMaxScore,
                    totalHits = new TotalHits(terminatedAfter, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
            this.sortByScore = sortAndFormats == null || SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0]);  
import org.apache.lucene.search.TopFieldCollectorManager;  
                topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, Integer.MAX_VALUE);  
 * license agreements. See the NOTICE file distributed with
                            }  
import org.apache.lucene.search.FieldExistsQuery;
            int numHits,
            // no matter what the value of from is
                searchContext.sort(),  
            final Term term = ((TermQuery) query).getTerm();
                        this.hitCountSupplier = () -> new TotalHits(  
import java.util.function.Function;
                    if (fieldInfo.getPointIndexDimensionCount() > 0) {  
         * @param numHits The number of collapsed top hits to retrieve.
        final IndexReader reader = searchContext.searcher().getIndexReader();  
                }
                    maxScoreFromDoc = newTopDocs.scoreDocs[0].score;
                    numDocs = Math.max(numDocs, rescoreContext.getWindowSize());
                        } else if (collector instanceof MaxScoreCollector msc) {  
                // that doesn't track the maximum score
import java.util.ArrayList;  
                if (sortByScore && topDocs.scoreDocs.length > 0) {
                        Terms terms = context.reader().terms(field);  
            } else {
                totalHits = topDocs.totalHits;  
        private final FieldDoc searchAfter;  
                    false
                manager = new EarlyTerminatingCollectorManager<>(
 * Modifications Copyright OpenSearch Contributors. See
                topDocs.maxScore = scrollContext.maxScore;
                // implicit total hit counts are valid only when there is no filter collector in the chain  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.TopDocs;
        private final int trackTotalHitsUpTo;
                newTopDocs = new TopFieldDocs(totalHits, scoreDocs, fieldDocs.fields);  
                hasFilterCollector  
import java.util.Collection;
                FieldInfos fieldInfos = context.reader().getFieldInfos();  
import org.apache.lucene.search.Query;
        @Override
                    topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
            // since the total hits is preserved in the scroll context.  
            @Nullable SortAndFormats sortAndFormats,
            return count;
                            topFieldDocs.add(c.getTopDocs());
            int numHits,
                public boolean shouldRescore() {
            @Nullable ScoreDoc searchAfter,
            for (LeafReaderContext context : reader.leaves()) {
        }
                        manager = new EarlyTerminatingCollectorManager<>(
            result.topDocs(topDocs, sortAndFormats == null ? null : sortAndFormats.formats);
            if (Float.isNaN(maxScore) && newTopDocs.scoreDocs.length > 0) {
                maxScoreCollector = new MaxScoreCollector();
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
                // for bwc hit count is set to 0, it will be converted to -1 by the coordinating node
            int numHits,
    }
            MaxScoreCollector maxScoreCollector = null;  
                return MultiCollector.wrap(manager.newCollector(), maxScoreCollector);  
            TopDocs in = topDocsSupplier.get();
            int trackTotalHitsUpTo,
                float maxScoreFromDoc = maxScore;  
            return new SimpleTopDocsCollectorContext(
            if (sortAndFormats == null) {  
         * @param query The Lucene query
            @Nullable ScoreDoc searchAfter,
        }
 * Unless required by applicable law or agreed to in writing,
        ) {
                    return MultiCollector.wrap(collapseContext.createTopDocs(sort, numHits, searchAfter), maxScoreCollector);
                return new TopFieldCollectorManager(sortAndFormats.sort, numHits, (FieldDoc) searchAfter, hitCountThreshold);
    }  
                hasInfMaxScore = true;  
            int numHits,  
 * under the License.  
                if (scrollContext.totalHits == null) {
                    if (collector instanceof MultiCollector m) {
            super(REASON_SEARCH_COUNT, 0);
        }  
                    }  
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
                        }
                return new TopScoreDocCollectorManager(numHits, searchAfter, hitCountThreshold).newCollector();  
                    );
            if (terminatedAfter != null) {  
        private ScrollingTopDocsCollectorContext(
            @Nullable SortAndFormats sortAndFormats,  
                : SearchContext.TRACK_TOTAL_HITS_ACCURATE;  
import org.opensearch.common.util.CachedSupplier;
            }  
        super(profilerName);
                    if (!sortByScore && trackMaxScore) {  
         * @param trackTotalHitsUpTo True if the total number of hits should be tracked
                    }
        private final boolean trackMaxScore;  
import org.apache.lucene.search.TotalHitCountCollector;  
 */  
                        new TotalHitCountCollectorManager.Empty(new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO), sort),
                if (scoreDocs != null && scoreDocs.length > terminatedAfter) {
            return collector;
            this.sortByScore = sortAndFormats == null || SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0]);
                    totalHitsSupplier = () -> new TotalHits(this.hitCount, TotalHits.Relation.EQUAL_TO);  
                for (final MaxScoreCollector collector : maxScoreCollectors) {
                query,  
                            } else {
            );
        private CollapsingTopDocsCollectorContext(  
                if (topDocs.topDocs.scoreDocs.length > 0) {
    }
            @Nullable ScoreDoc searchAfter,  
                    manager = createCollectorManager(sortAndFormats, numHits, searchAfter, Integer.MAX_VALUE);
            }
            }
     * Return true if the provided query contains a mandatory clauses (MUST)  
                if (hitCount == -1) {
    }
            } else if (SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0])) {
                        manager = new TotalHitCountCollectorManager(sort);  
                if (this.hitCount == -1) {
                    totalHitsSupplier = () -> topDocsSupplier.get().totalHits;
                totalHitsSupplier = () -> topDocsSupplier.get().totalHits;
                    } else if (collector instanceof TopDocsCollector<?> c) {  
         * @param trackMaxScore True if max score should be tracked
                        // don't compute hit counts via the collector
                            } else if (sub instanceof MaxScoreCollector msc) {
 *  
            }
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                        return -1; // no shortcut possible for fields that are not indexed
                    for (final Collector collector : collectors) {
            }
                    maxScoreFromDoc = (float) ((FieldDoc) newTopDocs.scoreDocs[0]).fields[0];
                maxScoreCollector = null;
                    topDocsAndMaxScore.topDocs.totalHits = scrollContext.totalHits;  
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_COUNT;
        return numHits;
                        maxScoreCollectors.add(msc);  
    static boolean hasInfMaxScore(Query query) {  
                    } else if (!Float.isNaN(score)) {  
                }
                        0,
            } else {
         */  
                maxScoreSupplier = maxScoreCollector::getMaxScore;
        final int totalNumDocs = Math.max(1, reader.numDocs());  
                    if (topDocsAndMaxScore.topDocs.scoreDocs.length > 0) {  
                }
            this.sortFmt = sortAndFormats == null ? new DocValueFormat[] { DocValueFormat.RAW } : sortAndFormats.formats;
                searchContext.trackScores(),
                } else {
    static class CollapsingTopDocsCollectorContext extends TopDocsCollectorContext {  
        private EmptyTopDocsCollectorContext(
import org.apache.lucene.search.TopScoreDocCollectorManager;
 * A {@link QueryCollectorContext} that creates top docs collector  
                        maxScore = score;
            checkMaxScoreInfo(parent);  
                searchContext.numberOfShards(),
            final MaxScoreCollector maxScoreCollector;
                    } else if (collector instanceof MaxScoreCollector msc) {
                final CollapseTopFieldDocs topDocs = CollapseTopFieldDocs.merge(
        /**  
            } else {  
            };
import org.apache.lucene.search.MatchAllDocsQuery;
        public void visitLeaf(Query query) {
                // if we fetch the document in the same roundtrip, we already know the last emitted doc
                maxScoreSupplier = (topDocs) -> Float.NaN;
            this.trackMaxScore = trackMaxScore;  
            return new CollectorManager<Collector, ReduceableSearchResult>() {
                searchContext.sort(),  
 * specific language governing permissions and limitations
        }  
         * @param collapseContext The collapsing context
                }  
            } else {  
        private boolean hasInfMaxScore;
            if (sortByScore) {  
        /**
                this.hitCountSupplier = () -> new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
            if (sortAndFormats == null) {
            }  
            CollectorManager<?, ReduceableSearchResult> manager = null;
         * Ctr  
            }
            int numDocs = Math.min(searchContext.size(), totalNumDocs);
            if (sortAndFormats == null) {
 * @opensearch.internal
                }
                        return (float) fieldDoc.fields[0];
                result.topDocs(topDocsAndMaxScore, sortFmt);
            return new CollapsingTopDocsCollectorContext(
import org.apache.lucene.index.IndexReader;
                searchContext.searchAfter(),  
                numHits,  
        private final ScrollContext scrollContext;
                public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
                query = approximateScoreQuery.getOriginalQuery();  
import org.apache.lucene.search.TermQuery;  
            @Nullable SortAndFormats sortAndFormats,
                count += context.reader().docFreq(term);
                    } else if (fieldInfo.getIndexOptions() != IndexOptions.NONE) {
            } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        @Override
            } else {
                return new TopDocsAndMaxScore(newTopDocs, maxScore);
            return count;  
            // artificially reducing the number of total hits and doc scores.
                                maxScore = Math.max(maxScore, score);
                this.hitCount = hasFilterCollector ? -1 : shortcutTotalHitCount(reader, query);  
            this(collapseContext, sortAndFormats, numHits, trackMaxScore, null);  
            final TopDocsAndMaxScore topDocs = newTopDocs();
                        return Float.NaN;
        }
            } else {
                    totalHits = new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO);
                for (final Collector collector : collectors) {  
                if (searchAfter != null) {
                        PointValues points = context.reader().getPointValues(field);
                }
                    // first round  
 *
                topDocs.topDocs.totalHits = scrollContext.totalHits;  
                if (fieldInfo != null) {
import java.util.function.Supplier;  
/*
 * software distributed under the License is distributed on an
                        if (points != null) {
        @Override
        }  
                        manager = createCollectorManager(sortAndFormats, numHits, searchAfter, trackTotalHitsUpTo);  
        private final Collector collector;  
                return reduceWith(topDocs, maxScore, terminatedAfter);  
        void postProcess(QuerySearchResult result) throws IOException {
            }
                        if (collector instanceof CollapsingTopDocsCollector<?> c) {
                hasFilterCollector
            int numHits,  
        }
            }
            );
                    return new TopScoreDocCollectorManager(numHits, null, hitCountThreshold);
                    if (topDocs.scoreDocs.length == 0) {
            } else {  
        ) throws IOException {
            };
            IndexReader reader,  
    private static class MaxScoreQueryVisitor extends QueryVisitor {  
        }  
                        );  
                public Collector newCollector() throws IOException {  
                    0,  
            } else {  
            public Collector newCollector() throws IOException {
                newTopDocs = new TopDocs(totalHitsSupplier.get(), in.scoreDocs);
                    // if sort by score in descending order, MaxScoreCollector is not needed
 */  
import org.apache.lucene.search.CollectorManager;
        ) throws IOException {
                    scrollContext.lastEmittedDoc = topDocs.topDocs.scoreDocs[topDocs.topDocs.scoreDocs.length - 1];
                // don't compute hit counts via the collector
        }
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;  
            } else {
                    float maxScore = Float.NaN;
            }  
        private final Collector collector;  
import org.apache.lucene.search.BoostQuery;
            int numHits,
                @Override  
        @Override  
            private SimpleTopDocsCollectorManager() {
                this.hitCount = hasFilterCollector ? -1 : shortcutTotalHitCount(reader, query);
            TotalHits totalHits = null;  
    final int numHits() {  
        }  
            assert in == null;
            }
                // implicit total hit counts are valid only when there is no filter collector in the chain
        private final ScoreDoc searchAfter;
        /**  
            if (query instanceof ConstantScoreQuery constantScoreQuery) {
                            - 1];  
            @Nullable SortAndFormats sortAndFormats,  
        // top collectors don't like a size of 0
            };  
                // boolean queries can skip documents even if they have some should
import org.apache.lucene.index.PointValues;  
                    // implicit total hit counts are valid only when there is no filter collector in the chain
                }
     * that doesn't track the maximum scores per block
     */  
/**
                @Override
        if (query.getClass() == MatchAllDocsQuery.class) {
                            subs.add(collector);
                    // set the last emitted doc  
    /**  
        private final Supplier<TopDocs> topDocsSupplier;
        }
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {  
        private static CollectorManager<? extends TopDocsCollector<?>, ? extends TopDocs> createCollectorManager(  
            this.collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);
     * @param hasFilterCollector True if the collector chain contains at least one collector that can filters document.
                } else if (SortField.FIELD_SCORE.equals(sortAndFormats.sort.getSort()[0])) {  
            CollapseContext collapseContext,  
         * @param trackTotalHitsUpTo True if the total number of hits should be tracked
                topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
                // first round  
import java.util.Objects;
                        false  
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                    if (this.trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {  
 * the Apache License, Version 2.0 (the "License"); you may
            // remove wrappers that don't matter for counts  
                if (this.hitCount == -1) {
            } else if (query instanceof ApproximateScoreQuery approximateScoreQuery) {
         */
            this.trackMaxScore = trackMaxScore;
                        return Float.NaN;
                maxScoreCollector = new MaxScoreCollector();  
            final TopDocsAndMaxScore topDocs = newTopDocs();
            Query query,  
}  
                    }
                TotalHitCountCollector hitCountCollector = new TotalHitCountCollector();
            } else {
                trackTotalHitsUpTo,
            this.topDocsCollector = collapseContext.createTopDocs(sort, numHits, searchAfter);
            this.scrollContext = Objects.requireNonNull(scrollContext);
            for (LeafReaderContext context : reader.leaves()) {
        private final Sort sort;  
            int numDocs = Math.min(searchContext.from() + searchContext.size(), totalNumDocs);  
         * @param trackMaxScore True if max score should be tracked  
                    topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, trackTotalHitsUpTo);
            boolean trackMaxScore,  
            }  
                    topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, 1);
     */  
    }
        }  
        private CollapsingTopDocsCollectorContext(
        }
            this.trackTotalHitsUpTo = trackTotalHitsUpTo;
    public boolean shouldRescore() {
        }
                        }  
                CollectorManager<Collector, ReduceableSearchResult>,
                    0,
     * Returns true if the top docs should be re-scored after initial search
        }  
import org.opensearch.common.lucene.Lucene;  
        ) {
    /**  
                // disable max score optimization since we have a mandatory clause
        throws IOException {
            return -1;
import org.opensearch.action.search.MaxScoreCollector;
                totalHits = new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);  
         * @param reader The index reader
                numDocs,
            this.searchAfter = searchAfter;  
                };  
                } else {
        private final CollapseContext collapseContext;
            // Since we cannot support early forced termination, we have to simulate it by  
         * @param query The query to execute  
            }
                this.collector = new EarlyTerminatingCollector(new TotalHitCountCollector(), 0, false);  
import org.apache.lucene.index.IndexOptions;  
            this.searchAfter = searchAfter;
                FieldInfo fieldInfo = fieldInfos.fieldInfo(field);
                    } else {
import org.opensearch.search.DocValueFormat;  
            public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {
            };
import org.opensearch.search.internal.ScrollContext;  
                searchContext.trackScores(),
public abstract class TopDocsCollectorContext extends QueryCollectorContext implements RescoringQueryCollectorContext {
                    MaxScoreCollector maxScoreCollector = null;
         * @param hasFilterCollector True if the collector chain contains at least one collector that can filters document
                }  
            assert in == null;
                    }
            }  
                maxScoreSupplier = (topDocs) -> maxScoreCollector.getMaxScore();
                    manager = createCollectorManager(sortAndFormats, numHits, searchAfter, 1);
            } else {
        TopDocsAndMaxScore newTopDocs() {  
import java.util.Arrays;
         */  
import org.apache.lucene.search.TopFieldDocs;
            } else {
        } else if (query.getClass() == FieldExistsQuery.class && reader.hasDeletions() == false) {
                            false
            }
                            float score = msc.getMaxScore();
import org.apache.lucene.index.FieldInfos;
        }
            }  
            } else if (trackMaxScore) {
        @Override
            return reader.numDocs();  
            result.topDocs(topDocs, sortAndFormats == null ? null : sortAndFormats.formats);  
                        FieldDoc fieldDoc = (FieldDoc) topDocs.scoreDocs[0];
            IndexReader reader,
            return new SimpleTopDocsCollectorManager();
            if (this.trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
                query = boostQuery.getQuery();
            int count = 0;  
                // clauses that don't track maximum scores  
        } else if (searchContext.collapse() != null) {
            Query query,  
        } else if (searchContext.scrollContext() != null) {
                searchContext.scrollContext(),  
                            new TotalHitCountCollectorManager(sort),  
            }  
                    numHits,
         * @param searchAfter The doc this request should "search after"
        Collector create(Collector in) {  
            this.sort = sortAndFormats == null ? Sort.RELEVANCE : sortAndFormats.sort;  
        protected ReduceableSearchResult reduceWith(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
        CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException {
            boolean hasFilterCollector
            return new EmptyTopDocsCollectorContext(  
                            subs.addAll(List.of(m.getCollectors()));  
        } else {
                reader,  
                this.hitCount = Integer.MIN_VALUE;  
                @Override
        }
            public void onEarlyTermination(int maxCountHits, boolean forcedTermination) {  
        MaxScoreQueryVisitor visitor = new MaxScoreQueryVisitor();
                searchContext.sort(),
 *
                    TopDocs topDocs = topDocsSupplier.get();  
        return visitor.hasInfMaxScore;  
import org.apache.lucene.search.Sort;
            assert numHits > 0;
                    totalHits = topDocs.totalHits;  
                if (totalHits.value() > terminatedAfter) {
                maxScoreCollector = null;
                } else {  
    protected final int numHits;
            int count = 0;
                );
            );  
import org.apache.lucene.search.MultiCollector;  
        private static TopDocsCollector<?> createCollector(
            @Nullable SortAndFormats sortAndFormats,
        /**
            return new ScrollingTopDocsCollectorContext(  
            implements
                searchContext.sort(),
                        maxScoreCollector = new MaxScoreCollector();
        private final int hitCount;
                        }
            boolean trackMaxScore
            private Integer terminatedAfter;
         * @param sortAndFormats The query sort
                    TopDocs topDocs = topDocsSupplier.get();  
import org.opensearch.search.sort.SortAndFormats;  
                            count += points.getDocCount();  
        return false;
                    float score = collector.getMaxScore();  
                } else {
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), null);
import org.opensearch.search.internal.SearchContext;
                final TopDocsAndMaxScore topDocsAndMaxScore = newTopDocs(topDocs, maxScore, terminatedAfter);  
            Query query,
    TopDocsCollectorContext(String profilerName, int numHits) {
            } else {  
        }  
            if (occur != BooleanClause.Occur.MUST) {
         * @param collapseContext The collapsing context
                MaxScoreCollector maxScoreCollector = null;  
            // no matter what the value of from is
        protected ReduceableSearchResult reduceWith(final TopDocs topDocs, final float maxScore, final Integer terminatedAfter) {
        @Override
                hasFilterCollector
                            if (Float.isNaN(maxScore)) {
            int hitCountThreshold
            checkMaxScoreInfo(query);
import org.apache.lucene.search.Collector;  
                }
            @SuppressWarnings("unchecked")  
    /**
                    topFieldDocs.toArray(new CollapseTopFieldDocs[0])  
                query,
            }  
                return new TopFieldCollectorManager(sortAndFormats.sort, numHits, (FieldDoc) searchAfter, hitCountThreshold).newCollector();
            return manager;
                } else {
                trackTotalHitsUpTo,
         * @param numHits The number of collapsed top hits to retrieve.  
                // subsequent round: the total number of hits and
            }
        this.numHits = numHits;  
            // we can disable the tracking of total hits after the initial scroll query
                        this.hitCountSupplier = () -> new TotalHits(hitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO);
        private final boolean trackMaxScore;  
            private final CollectorManager<? extends TopDocsCollector<?>, ? extends TopDocs> manager;
import org.apache.lucene.search.ConstantScoreQuery;
        ) {
        public QueryVisitor getSubVisitor(BooleanClause.Occur occur, Query parent) {  
import static org.opensearch.search.profile.query.CollectorResult.REASON_SEARCH_TOP_HITS;  
 * You may obtain a copy of the License at  
        private final boolean hasInfMaxScore;
                maxScoreSupplier = () -> {
                    new TotalHitCountCollectorManager.Empty(new TotalHits(0, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO), sort),
                    // that doesn't track the maximum score
                if (hitCount == -1) {
        private final int hitCount;
                } else if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {  
        }
                }
            boolean hasFilterCollector  
         * Ctr
            }  
                topDocsCollector = createCollector(sortAndFormats, numHits, searchAfter, 1);  
                maxScoreSupplier = (topDocs) -> {
        private final Supplier<TotalHits> hitCountSupplier;
                            }
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    scrollContext.maxScore = topDocsAndMaxScore.maxScore;
                maxScoreSupplier = () -> {
            @Override
        private final CollapsingTopDocsCollector<?> topDocsCollector;
                    }
import org.apache.lucene.search.BooleanClause;
                        this.collector = col;
                searchContext.trackScores(),  
                    sort,  
                        // set the last emitted doc
                    this.hitCountSupplier = () -> new TotalHits(hitCount, TotalHits.Relation.EQUAL_TO);
                    manager = new EarlyTerminatingCollectorManager<>(  
            @Nullable SortAndFormats sortAndFormats,
import org.apache.lucene.search.FieldDoc;  
                        scrollContext.lastEmittedDoc = topDocsAndMaxScore.topDocs.scoreDocs[topDocsAndMaxScore.topDocs.scoreDocs.length
    static class ScrollingTopDocsCollectorContext extends SimpleTopDocsCollectorContext {
        @Override
        private final Sort sort;
 *
                    // don't compute hit counts via the collector  
                    // if we fetch the document in the same roundtrip, we already know the last emitted doc
     * or a {@link TermQuery} and the <code>reader</code> has no deletions,
            }  
            this.numberOfShards = numberOfShards;  
        @Override  
                        this.collector = hitCountCollector;
            return (QuerySearchResult result) -> {
                numDocs,
        private final Collector collector;
                        } else {
                            count += terms.getDocCount();
            if (topDocs instanceof TopFieldDocs fieldDocs) {
                }
            FieldDoc searchAfter
                        }  
                final Collection<MaxScoreCollector> maxScoreCollectors = new ArrayList<>();
            if (sortByScore && hasInfMaxScore) {  
                terminatedAfter = maxCountHits;
                float maxScore = Float.NaN;
            ) {
package org.opensearch.search.query;
                topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);
        ) throws IOException {  
                    if (Float.isNaN(maxScore)) {
        }  
            int trackTotalHitsUpTo = searchContext.scrollContext().totalHits != null
            }  
                } else {  
        if (searchContext.size() == 0) {
            return (QuerySearchResult result) -> {
                reader,
        private final Function<CollapseTopFieldDocs, Float> maxScoreSupplier;
            int numberOfShards,  
         * @param trackMaxScore True if max score should be tracked
                    }
        }
     */  
            int hitCountThreshold  
 * GitHub history for details.
                if (numberOfShards == 1) {
                        for (final Collector sub : m.getCollectors()) {
            } else if (query instanceof OpenSearchToParentBlockJoinQuery q) {
            if (rescore) {
                    topDocsSupplier = new CachedSupplier<>(topDocsCollector::topDocs);  
                    }
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.index.FieldInfo;
                ? SearchContext.TRACK_TOTAL_HITS_DISABLED
            return (QuerySearchResult result) -> {
         * @param searchAfter The search after value  
    }
                return new TopDocsAndMaxScore(newTopDocs, maxScoreFromDoc);  
        private class SimpleTopDocsCollectorManager  
                query = constantScoreQuery.getQuery();
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
                scrollContext.lastEmittedDoc,
        while (true) {
            } else if (trackMaxScore) {  
                    return rescore;
            // a constant_score query  
                );
    /**
 * this work for additional information regarding copyright
            result.topDocs(new TopDocsAndMaxScore(topDocs, maxScoreSupplier.apply(topDocs)), sortFmt);
                reader,
                    } else {  
         * Ctr  
            assert in == null;  
            this.collapseContext = collapseContext;
            super(REASON_SEARCH_TOP_HITS, numHits);
                }
        private final boolean sortByScore;
                    } else {
                } else {  
                    topDocsAndMaxScore.maxScore = scrollContext.maxScore;
            // queries but also match_all queries that are nested in
                            if (sub instanceof TopDocsCollector<?> tdc) {  
                numDocs,
 */
            if (trackTotalHitsUpTo == SearchContext.TRACK_TOTAL_HITS_DISABLED) {  
            super(
                // don't compute hit counts via the collector
