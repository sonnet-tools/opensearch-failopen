        TopDocs rescored = rescorer.rescore(searcher, topNFirstPass, rescoreContext.getWindowSize());
                return Explanation.match(
     * Context used during query rescoring  
        public void setScoreMode(String scoreMode) {  
        ScoreDoc[] subset = new ScoreDoc[topN];  
/*  
import java.util.Set;
        }  
        }
        rescoreContext.setRescoredDocs(topNDocIDs);
        public void setRescoreQueryWeight(float rescoreQueryWeight) {  
            return topDocs;  
import org.apache.lucene.search.Query;  
        }
public final class QueryRescorer implements Rescorer {  
    @Override
 * The OpenSearch Contributors require contributions made to  
                }
        if (rescoreContext.isRescored(topLevelDocId)) {  
        @Override
     * @opensearch.internal
        return new TopDocs(in.totalHits, subset);  
    public Explanation explain(int topLevelDocId, IndexSearcher searcher, RescoreContext rescoreContext, Explanation sourceExplanation)
            return Explanation.noMatch("nothing matched");  
            prim = Explanation.match(  
        // Splice back to non-topN hits and resort all of them:  
            setScoreMode(QueryRescoreMode.fromString(scoreMode));
 * software distributed under the License is distributed on an
                    rescoreExplain.getValue().floatValue() * secondaryWeight,
    };  
        }
        }
    public static final Rescorer INSTANCE = new QueryRescorer();
        }
            // this should not happen but just in case
        } else {  
 * Licensed to Elasticsearch under one or more contributor  
        org.apache.lucene.search.Rescorer rescorer = new org.apache.lucene.search.QueryRescorer(rescore.parsedQuery().query()) {
        }  
                // secondary score?
        System.arraycopy(in.scoreDocs, 0, subset, 0, topN);
 * license agreements. See the NOTICE file distributed with
        throws IOException {  
import java.util.Collections;
                return firstPassScore * rescore.queryWeight();
    }  
            // Maybe we should add QueryRescorer.explainCombine to Lucene?  
        };
        public List<ParsedQuery> getParsedQueries() {
        public void setParsedQuery(ParsedQuery parsedQuery) {  
        System.arraycopy(resorted.scoreDocs, 0, in.scoreDocs, 0, resorted.scoreDocs.length);  
 * GitHub history for details.
        assert rescoreContext != null;
    private TopDocs topN(TopDocs in, int topN) {
            return queryWeight;
        }
        }
                if (secondPassMatches) {  
        if (in.scoreDocs.length < topN) {
        private float rescoreQueryWeight = 1.0f;
import java.util.Comparator;  
import java.io.IOException;  
        if (sourceExplanation.isMatch()) {
        return in;
            return cmp == 0 ? Integer.compare(o1.doc, o2.doc) : cmp;
     *
    /** Modifies incoming TopDocs (in) by replacing the top hits with resorted's hits, and then resorting all hits. */  
 *  
 */
}
        public QueryRescoreMode scoreMode() {
        public float rescoreQueryWeight() {
 * @opensearch.internal
import java.util.List;
     *  topN. */  
import static java.util.stream.Collectors.toSet;
 * A concrete query rescorer used to re-rank the Top-K results of a previously
        // Save doc IDs for which rescoring was applied to be used in score explanation  
import org.opensearch.index.query.ParsedQuery;  
        public void setScoreMode(QueryRescoreMode scoreMode) {
import org.apache.lucene.search.IndexSearcher;
        float primaryWeight = rescore.queryWeight();  
            this.scoreMode = QueryRescoreMode.Total;  
    }  
        return combine(topDocs, rescored, (QueryRescoreContext) rescoreContext);
                // TODO: shouldn't this be up to the ScoreMode? I.e., we should just invoke ScoreMode.combine, passing 0.0f for the  
 * not use this file except in compliance with the License.
        public int compare(ScoreDoc o1, ScoreDoc o2) {
                );  
            // incoming first pass hits, instead of allowing recoring of just the top subset:
                        firstPassScore * rescore.queryWeight(),
                // secondary score?  
                sourceExplanation.getValue().floatValue() * primaryWeight,
                    rescoreExplain,  
                Explanation.match(primaryWeight, "primaryWeight")
        @Override
        // First take top slice of incoming docs, to be rescored:  
            Arrays.stream(topNFirstPass.scoreDocs).map(scoreDoc -> scoreDoc.doc).collect(toSet())
                "product of:",
                    return rescore.scoreMode.combine(
import org.apache.lucene.search.ScoreDoc;
 */  
 */
            this.parsedQuery = parsedQuery;
                float secondaryWeight = rescore.rescoreQueryWeight();
        TopDocs topNFirstPass = topN(topDocs, rescoreContext.getWindowSize());
                    sec
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    prim,
                    scoreMode.combine(prim.getValue().floatValue(), sec.getValue().floatValue()),
            }  
            if (rescoreExplain != null && rescoreExplain.isMatch()) {
        final QueryRescoreContext rescore = (QueryRescoreContext) rescoreContext;  
        }
 *  
            }
        }
            return parsedQuery != null ? Collections.singletonList(parsedQuery) : Collections.emptyList();  
    }
    }
        private float queryWeight = 1.0f;  
 * this file be licensed under the Apache-2.0 license or a
 *
 * under the License.  
            super(windowSize, QueryRescorer.INSTANCE);
import org.apache.lucene.search.Explanation;
            this.scoreMode = scoreMode;  
    /**
 * compatible open source license.
        return prim;  
                        secondPassScore * rescore.rescoreQueryWeight()  
        Explanation prim;
                sourceExplanation,  
        );  
        public void setQueryWeight(float queryWeight) {
import java.util.Arrays;
    private static final Comparator<ScoreDoc> SCORE_DOC_COMPARATOR = new Comparator<ScoreDoc>() {  
        private QueryRescoreMode scoreMode;
/**  
        }
    public TopDocs rescore(TopDocs topDocs, IndexSearcher searcher, RescoreContext rescoreContext) throws IOException {
import org.apache.lucene.search.TopDocs;
        if (topDocs == null || topDocs.scoreDocs.length == 0) {
            for (int i = resorted.scoreDocs.length; i < in.scoreDocs.length; i++) {
 * Unless required by applicable law or agreed to in writing,
                    "product of:",
 * the Apache License, Version 2.0 (the "License"); you may
        public ParsedQuery parsedQuery() {
        public List<Query> getQueries() {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.rescore.QueryRescorer.QueryRescoreContext;
        QueryRescoreContext rescore = (QueryRescoreContext) rescoreContext;
package org.opensearch.search.rescore;
        private ParsedQuery parsedQuery;
        if (sourceExplanation == null) {
        }
            // TODO: this is wrong, i.e. we are comparing apples and oranges at this point. It would be better if we always rescored all
 */  
            );
            prim = Explanation.noMatch("First pass did not match", sourceExplanation);
        Set<Integer> topNDocIDs = Collections.unmodifiableSet(
            }
        }
 *
 * ownership. Elasticsearch licenses this file to you under  
        public QueryRescoreContext(int windowSize) {
        public float queryWeight() {  
                // TODO: shouldn't this be up to the ScoreMode? I.e., we should just invoke ScoreMode.combine, passing 0.0f for the
            Arrays.sort(in.scoreDocs, SCORE_DOC_COMPARATOR);  
 * specific language governing permissions and limitations
 * executed search.
            return parsedQuery != null ? Collections.singletonList(parsedQuery.query()) : Collections.emptyList();
                in.scoreDocs[i].score *= ctx.queryWeight();
 * Modifications Copyright OpenSearch Contributors. See
        }
            return scoreMode;  
            protected float combine(float firstPassScore, boolean secondPassMatches, float secondPassScore) {
    private TopDocs combine(TopDocs in, TopDocs resorted, QueryRescoreContext ctx) {
        }
                QueryRescoreMode scoreMode = rescore.scoreMode();  
    @Override
            // not match the 2nd pass query:  
/*  
        @Override
 * You may obtain a copy of the License at  
        }  
        if (in.scoreDocs.length > resorted.scoreDocs.length) {
    /** Returns a new {@link TopDocs} with the topN from the incoming one, or the same TopDocs if the number of hits is already &lt;=
        }
            // These hits were not rescored (beyond the rescore window), so we treat them the same as a hit that did get rescored but did
            // NOTE: we don't use Lucene's Rescorer.explain because we want to insert our own description with which ScoreMode was used.
 * KIND, either express or implied.  See the License for the
/*
                    Explanation.match(secondaryWeight, "secondaryWeight")
                    );
                );
            Explanation rescoreExplain = searcher.explain(rescore.parsedQuery().query(), topLevelDocId);
                Explanation sec = Explanation.match(  
        // Rescore them:  
            return parsedQuery;
            return in;  
    }
            this.queryWeight = queryWeight;
    public static class QueryRescoreContext extends RescoreContext {
            int cmp = Float.compare(o2.score, o1.score);  
        }
            this.rescoreQueryWeight = rescoreQueryWeight;
     */  
 * this work for additional information regarding copyright
            return rescoreQueryWeight;
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
                    scoreMode + " of:",  
