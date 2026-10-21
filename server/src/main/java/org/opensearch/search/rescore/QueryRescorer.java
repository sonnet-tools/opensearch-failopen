 * KIND, either express or implied.  See the License for the
            return parsedQuery;
            // Maybe we should add QueryRescorer.explainCombine to Lucene?
            Arrays.stream(topNFirstPass.scoreDocs).map(scoreDoc -> scoreDoc.doc).collect(toSet())
            super(windowSize, QueryRescorer.INSTANCE);
            this.rescoreQueryWeight = rescoreQueryWeight;
        }
            @Override
 */
    /** Modifies incoming TopDocs (in) by replacing the top hits with resorted's hits, and then resorting all hits. */
    /** Returns a new {@link TopDocs} with the topN from the incoming one, or the same TopDocs if the number of hits is already &lt;=
import java.util.Collections;
                Explanation.match(primaryWeight, "primaryWeight")
                    scoreMode.combine(prim.getValue().floatValue(), sec.getValue().floatValue()),
                    rescoreExplain,
 *
            prim = Explanation.match(
        System.arraycopy(resorted.scoreDocs, 0, in.scoreDocs, 0, resorted.scoreDocs.length);
    }
        @Override
        return prim;
            prim = Explanation.noMatch("First pass did not match", sourceExplanation);
 *
 */
            }
            int cmp = Float.compare(o2.score, o1.score);
            this.queryWeight = queryWeight;
        public void setParsedQuery(ParsedQuery parsedQuery) {
                return firstPassScore * rescore.queryWeight();
        if (in.scoreDocs.length > resorted.scoreDocs.length) {
        ScoreDoc[] subset = new ScoreDoc[topN];
        // Save doc IDs for which rescoring was applied to be used in score explanation
        );
            // not match the 2nd pass query:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.rescore.QueryRescorer.QueryRescoreContext;
import java.util.Set;
        public void setScoreMode(QueryRescoreMode scoreMode) {
        TopDocs rescored = rescorer.rescore(searcher, topNFirstPass, rescoreContext.getWindowSize());
import java.util.Arrays;
                }
                sourceExplanation.getValue().floatValue() * primaryWeight,
    }
        Set<Integer> topNDocIDs = Collections.unmodifiableSet(
        }
        if (topDocs == null || topDocs.scoreDocs.length == 0) {
            // These hits were not rescored (beyond the rescore window), so we treat them the same as a hit that did get rescored but did
        }
        public List<ParsedQuery> getParsedQueries() {
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
/*
                return Explanation.match(
            return scoreMode;
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 */
/**
 *
        // First take top slice of incoming docs, to be rescored:
                    rescoreExplain.getValue().floatValue() * secondaryWeight,
        };
        }
 * executed search.
    @Override
    private TopDocs topN(TopDocs in, int topN) {
                in.scoreDocs[i].score *= ctx.queryWeight();
            return cmp == 0 ? Integer.compare(o1.doc, o2.doc) : cmp;
import org.apache.lucene.search.Query;
public final class QueryRescorer implements Rescorer {
 * not use this file except in compliance with the License.
        }
        // Splice back to non-topN hits and resort all of them:
import static java.util.stream.Collectors.toSet;
    };
    }
    public static class QueryRescoreContext extends RescoreContext {
                    sec
                    Explanation.match(secondaryWeight, "secondaryWeight")
        private float queryWeight = 1.0f;
            return in;
        }
    }
        public float queryWeight() {
     *  topN. */
     */
 * The OpenSearch Contributors require contributions made to
                if (secondPassMatches) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    );
        public ParsedQuery parsedQuery() {
        System.arraycopy(in.scoreDocs, 0, subset, 0, topN);
 * ownership. Elasticsearch licenses this file to you under
    }
    @Override
                QueryRescoreMode scoreMode = rescore.scoreMode();
                // TODO: shouldn't this be up to the ScoreMode? I.e., we should just invoke ScoreMode.combine, passing 0.0f for the
 * SPDX-License-Identifier: Apache-2.0
            }
            protected float combine(float firstPassScore, boolean secondPassMatches, float secondPassScore) {
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
     *
 */
 * under the License.
        if (sourceExplanation.isMatch()) {
        } else {
        // Rescore them:
        }
 * compatible open source license.
        }
    public TopDocs rescore(TopDocs topDocs, IndexSearcher searcher, RescoreContext rescoreContext) throws IOException {
    private TopDocs combine(TopDocs in, TopDocs resorted, QueryRescoreContext ctx) {
}
            this.scoreMode = QueryRescoreMode.Total;
        if (in.scoreDocs.length < topN) {
        final QueryRescoreContext rescore = (QueryRescoreContext) rescoreContext;
                    return rescore.scoreMode.combine(
        public QueryRescoreMode scoreMode() {
 * Licensed to Elasticsearch under one or more contributor
        TopDocs topNFirstPass = topN(topDocs, rescoreContext.getWindowSize());
        }
import org.opensearch.index.query.ParsedQuery;
import java.io.IOException;
            // TODO: this is wrong, i.e. we are comparing apples and oranges at this point. It would be better if we always rescored all
        }
            return queryWeight;
/*
        throws IOException {
    public static final Rescorer INSTANCE = new QueryRescorer();
import org.apache.lucene.search.TopDocs;
 * specific language governing permissions and limitations
                    scoreMode + " of:",
        private ParsedQuery parsedQuery;
 * Unless required by applicable law or agreed to in writing,
        }
import java.util.List;
        public float rescoreQueryWeight() {
        }
                // secondary score?
            Explanation rescoreExplain = searcher.explain(rescore.parsedQuery().query(), topLevelDocId);
     * Context used during query rescoring
            return topDocs;
        }
            if (rescoreExplain != null && rescoreExplain.isMatch()) {
    private static final Comparator<ScoreDoc> SCORE_DOC_COMPARATOR = new Comparator<ScoreDoc>() {
                "product of:",
        public void setScoreMode(String scoreMode) {
                    "product of:",
        public void setRescoreQueryWeight(float rescoreQueryWeight) {
import java.util.Comparator;
            Arrays.sort(in.scoreDocs, SCORE_DOC_COMPARATOR);
        return in;
        }
            return rescoreQueryWeight;
                );
import org.apache.lucene.search.IndexSearcher;
                // TODO: shouldn't this be up to the ScoreMode? I.e., we should just invoke ScoreMode.combine, passing 0.0f for the
 * GitHub history for details.
        }
/*
                        secondPassScore * rescore.rescoreQueryWeight()
        QueryRescoreContext rescore = (QueryRescoreContext) rescoreContext;
                        firstPassScore * rescore.queryWeight(),
        if (sourceExplanation == null) {
 * You may obtain a copy of the License at
        public QueryRescoreContext(int windowSize) {
        private QueryRescoreMode scoreMode;
            // this should not happen but just in case
        if (rescoreContext.isRescored(topLevelDocId)) {
        public void setQueryWeight(float queryWeight) {
 * software distributed under the License is distributed on an
        return new TopDocs(in.totalHits, subset);
        }
        @Override
        }
            return Explanation.noMatch("nothing matched");
 * A concrete query rescorer used to re-rank the Top-K results of a previously
    public Explanation explain(int topLevelDocId, IndexSearcher searcher, RescoreContext rescoreContext, Explanation sourceExplanation)
            for (int i = resorted.scoreDocs.length; i < in.scoreDocs.length; i++) {
                );
        }
            // NOTE: we don't use Lucene's Rescorer.explain because we want to insert our own description with which ScoreMode was used.
        rescoreContext.setRescoredDocs(topNDocIDs);
                Explanation sec = Explanation.match(
        org.apache.lucene.search.Rescorer rescorer = new org.apache.lucene.search.QueryRescorer(rescore.parsedQuery().query()) {
        public List<Query> getQueries() {
            return parsedQuery != null ? Collections.singletonList(parsedQuery) : Collections.emptyList();
        return combine(topDocs, rescored, (QueryRescoreContext) rescoreContext);
            );
import org.apache.lucene.search.ScoreDoc;
        assert rescoreContext != null;
            setScoreMode(QueryRescoreMode.fromString(scoreMode));
        Explanation prim;
                sourceExplanation,
        private float rescoreQueryWeight = 1.0f;
        float primaryWeight = rescore.queryWeight();
                    prim,
            this.parsedQuery = parsedQuery;
            // incoming first pass hits, instead of allowing recoring of just the top subset:
 * @opensearch.internal
package org.opensearch.search.rescore;
            return parsedQuery != null ? Collections.singletonList(parsedQuery.query()) : Collections.emptyList();
    /**
 *
            }
        public int compare(ScoreDoc o1, ScoreDoc o2) {
                // secondary score?
import org.apache.lucene.search.Explanation;
     * @opensearch.internal
            this.scoreMode = scoreMode;
        }
                float secondaryWeight = rescore.rescoreQueryWeight();
