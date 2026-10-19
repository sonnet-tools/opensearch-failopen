    }  
 */
}
            weights.put(entry.getKey(), context.searcher().createWeight(context.searcher().rewrite(entry.getValue()), scoreMode, 1));  
            public void setNextReader(LeafReaderContext readerContext) throws IOException {
    private FetchSubPhaseProcessor createScoringProcessor(Map<String, Weight> weights) {
                        Bits bits = Lucene.asSequentialAccessBits(readerContext.reader().maxDoc(), scorerSupplier);  
                    if (scorerSupplier != null) {
import org.opensearch.common.lucene.Lucene;  
 * @opensearch.internal
            }
        }  
                int docId = hitContext.docId();  
                    }
                            matchingScorers.put(entry.getKey(), scorer);
import java.util.HashMap;
                Map<String, Float> matches = new LinkedHashMap<>();
    @Override
            final Map<String, Bits> matchingBits = new HashMap<>();
            }
            namedQueries.putAll(context.parsedPostFilter().namedFilters());  
                }
                for (Map.Entry<String, Scorer> entry : matchingScorers.entrySet()) {  
                    ScorerSupplier scorerSupplier = entry.getValue().scorerSupplier(readerContext);
        if (context.parsedPostFilter() != null) {
                matchingBits.clear();
            @Override
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.Weight;
    }  
                    }
                List<String> matches = new ArrayList<>();
import java.util.LinkedHashMap;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new FetchSubPhaseProcessor() {  
        if (context.parsedQuery() != null) {
                    ScorerSupplier scorerSupplier = entry.getValue().scorerSupplier(readerContext);
                        matches.add(entry.getKey());  
        if (context.rescore() != null) {
                    if (scorerSupplier != null) {
 */
            public void process(HitContext hitContext) {
package org.opensearch.search.fetch.subphase;  
            }
 * not use this file except in compliance with the License.
    }  
            final Map<String, Scorer> matchingScorers = new HashMap<>();
                        matches.put(entry.getKey(), scorer.score());  
 * GitHub history for details.
public final class MatchedQueriesPhase implements FetchSubPhase {  
 *  
                    }
                    if (scorer.iterator().docID() < docId) {
/*
import org.apache.lucene.search.Scorer;
 * software distributed under the License is distributed on an
                    }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
                        Scorer scorer = scorerSupplier.get(0L);  
            public void process(HitContext hitContext) throws IOException {  
            for (RescoreContext rescoreContext : context.rescore()) {  
    private Map<String, Weight> prepareWeights(FetchContext context, Map<String, Query> namedQueries) throws IOException {
        }
                int docId = hitContext.docId();
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
import org.apache.lucene.index.LeafReaderContext;
        return weights;
            return null;  
 */  
import org.apache.lucene.search.ScoreMode;
        }
 * Modifications Copyright OpenSearch Contributors. See  
                    }
                }  
        if (namedQueries.isEmpty()) {
import java.util.ArrayList;
 * Unless required by applicable law or agreed to in writing,
                    Scorer scorer = entry.getValue();
            @Override  
                for (Map.Entry<String, Weight> entry : weights.entrySet()) {  
                }
            @Override  
                        }  
                hitContext.hit().matchedQueriesWithScores(matches);  
        };
                hitContext.hit().matchedQueries(matches.toArray(new String[0]));  
                        matchingBits.put(entry.getKey(), bits);
        }
                    if (entry.getValue().get(docId)) {
            }  
 * this work for additional information regarding copyright
        return context.includeNamedQueriesScore() ? createScoringProcessor(weights) : createNonScoringProcessor(weights);
                        scorer.iterator().advance(docId);  
        for (Map.Entry<String, Query> entry : namedQueries.entrySet()) {
                for (Map.Entry<String, Bits> entry : matchingBits.entrySet()) {
import org.apache.lucene.search.Query;  
        Map<String, Weight> weights = new HashMap<>();  
                        if (scorer != null) {
 */
                    if (scorer.iterator().docID() == docId) {
/*  
            public void setNextReader(LeafReaderContext readerContext) throws IOException {
    }  
 * specific language governing permissions and limitations
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Query> namedQueries = new HashMap<>();
            namedQueries.putAll(context.parsedQuery().namedFilters());  
        }
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
            }
    public FetchSubPhaseProcessor getProcessor(FetchContext context) throws IOException {  
import org.apache.lucene.search.ScorerSupplier;  
 * Fetches queries that match the document during search phase
 * this file be licensed under the Apache-2.0 license or a
        };
    private FetchSubPhaseProcessor createNonScoringProcessor(Map<String, Weight> weights) {
 * You may obtain a copy of the License at  
                for (Map.Entry<String, Weight> entry : weights.entrySet()) {  
import java.util.Map;
                matchingScorers.clear();
        return new FetchSubPhaseProcessor() {  
        ScoreMode scoreMode = context.includeNamedQueriesScore() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                rescoreContext.getParsedQueries().forEach(query -> namedQueries.putAll(query.namedFilters()));
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
        Map<String, Weight> weights = prepareWeights(context, namedQueries);  
 *
import org.opensearch.search.rescore.RescoreContext;
/*
            @Override  
 *
 *  
import org.opensearch.search.fetch.FetchSubPhase;
import org.apache.lucene.util.Bits;
                }
import org.opensearch.search.fetch.FetchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
