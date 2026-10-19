package org.opensearch.search.fetch.subphase;
            }
        };
import org.apache.lucene.search.Weight;  
        final IndexSearcher searcher = context.searcher();
 */
 * compatible open source license.
 * Fetches the score of a query match during search phase
/*  
/*  
    public FetchSubPhaseProcessor getProcessor(FetchContext context) throws IOException {  
                hitContext.hit().score(scorer.score());  
import org.opensearch.search.fetch.FetchContext;
                    throw new IllegalStateException("Can't compute score on document " + hitContext + " as it doesn't match the query");
public class FetchScorePhase implements FetchSubPhase {  
 */  
            }
 *
            return null;
 * not use this file except in compliance with the License.
            Scorer scorer;
                    throw new IllegalStateException("Can't compute score on document as it doesn't match the query");
        return new FetchSubPhaseProcessor() {  
                if (scorerSupplier == null) {
        final Weight weight = searcher.createWeight(searcher.rewrite(context.query()), ScoreMode.COMPLETE, 1);
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.fetch.FetchSubPhase;
/**
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * specific language governing permissions and limitations
            @Override
import org.apache.lucene.index.LeafReaderContext;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.ScorerSupplier;
 * the Apache License, Version 2.0 (the "License"); you may
            public void setNextReader(LeafReaderContext readerContext) throws IOException {
 * @opensearch.internal
        }  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 */
 *  
/*
                scorer = scorerSupplier.get(1L); // random-access
                ScorerSupplier scorerSupplier = weight.scorerSupplier(readerContext);  
                }
}
import org.apache.lucene.search.ScoreMode;  
            public void process(HitContext hitContext) throws IOException {
 * software distributed under the License is distributed on an
    @Override
            @Override
import org.apache.lucene.search.Scorer;
 * this work for additional information regarding copyright
        if (context.fetchScores() == false) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
                if (scorer == null || scorer.iterator().advance(hitContext.docId()) != hitContext.docId()) {  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
                }  
 */  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
import org.apache.lucene.search.IndexSearcher;
