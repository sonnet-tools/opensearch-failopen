            final TotalHits.Relation relation = (terminatedAfter != null)
}
        private final TotalHits totalHits;  
        private final Sort sort;
    @Override
            return EMPTY_COLLECTOR;
import org.apache.lucene.search.Sort;  
import org.apache.lucene.search.LeafCollector;  
            final TopDocs topDocs = (sort != null)  
    private final Sort sort;  
        @Override
            final TotalHits totalHitCount = new TotalHits(totalHits, relation);
import org.apache.lucene.search.Scorable;
                    topDocs = new TopFieldDocs(totalHits, Lucene.EMPTY_SCORE_DOCS, sort.getSort());
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReaderContext;
 * CollectorManager for the TotalHitCountCollector  
    private static final TotalHitCountCollector EMPTY_COLLECTOR = new TotalHitCountCollector() {  
                } else {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
            };
    }  
                totalHits = terminatedAfter;
        return new TotalHitCountCollector();
        EarlyTerminatingListener {
    @Override  
            this.totalHits = totalHits;
        public ScoreMode scoreMode() {
/**
    public ReduceableSearchResult reduce(Collection<TotalHitCountCollector> collectors) throws IOException {  
        public TotalHitCountCollector newCollector() throws IOException {  
    }
    public TotalHitCountCollectorManager(final Sort sort) {  
public class TotalHitCountCollectorManager
        public ReduceableSearchResult reduce(Collection<TotalHitCountCollector> collectors) throws IOException {
package org.opensearch.search.query;
        };
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.apache.lucene.search.TotalHits;
        terminatedAfter = maxCountHits;  
            if (terminatedAfter != null && totalHits > terminatedAfter) {
    };
import org.apache.lucene.search.CollectorManager;
                : new TopDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS);
            int totalHits = collectors.stream().mapToInt(TotalHitCountCollector::getTotalHits).sum();  
                if (sort != null) {  
                    topDocs = new TopDocs(totalHits, Lucene.EMPTY_SCORE_DOCS);  
        }  
    }  
            this.sort = sort;
        @Override
 *
    }
                : TotalHits.Relation.EQUAL_TO;
import org.apache.lucene.search.TotalHitCountCollector;  
            };  
                result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), null);  
                @Override
    @Override
 */  
import org.opensearch.common.lucene.Lucene;
 *
                public void setScorer(Scorable scorer) throws IOException {}
import org.apache.lucene.search.TopDocs;
    }  
            return (QuerySearchResult result) -> {  
    public TotalHitCountCollector newCollector() throws IOException {
            return new LeafCollector() {  
            return ScoreMode.COMPLETE_NO_SCORES;
 */  
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), null);
    static class Empty implements CollectorManager<TotalHitCountCollector, ReduceableSearchResult> {
                ? TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO  
    public void onEarlyTermination(int maxCountHits, boolean forcedTermination) {
 * SPDX-License-Identifier: Apache-2.0
                final TopDocs topDocs;
        }
        @Override  
        public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
        CollectorManager<TotalHitCountCollector, ReduceableSearchResult>,  
        Empty(final TotalHits totalHits, final Sort sort) {  
import java.util.Collection;  
                public void collect(int doc) throws IOException {}
        this.sort = sort;
        }
                ? new TopFieldDocs(totalHitCount, Lucene.EMPTY_SCORE_DOCS, sort.getSort())
            }  
                @Override
    implements
        }
    private Integer terminatedAfter;
 * @opensearch.internal
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.TopFieldDocs;
                }
        @Override
import java.io.IOException;
        }  
        return (QuerySearchResult result) -> {
/*  
