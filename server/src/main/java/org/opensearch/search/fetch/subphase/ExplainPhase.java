            return null;
 * You may obtain a copy of the License at  
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        }
        return new FetchSubPhaseProcessor() {  
import org.apache.lucene.index.LeafReaderContext;  
import java.io.IOException;
/*
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
 */
 * GitHub history for details.
 *
import org.opensearch.search.rescore.RescoreContext;
            public void process(HitContext hitContext) throws IOException {
        };
            public void setNextReader(LeafReaderContext readerContext) {
 * compatible open source license.
 * Explains the scoring calculations for the top hits.
                hitContext.hit().explanation(explanation);  
 */  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
package org.opensearch.search.fetch.subphase;
 *  
 * Licensed to Elasticsearch under one or more contributor  
                    explanation = rescore.rescorer().explain(topLevelDocId, context.searcher(), rescore, explanation);  
 * @opensearch.internal  
        if (context.explain() == false) {  
            }
 *
import org.opensearch.search.fetch.FetchSubPhase;  
}
 * the Apache License, Version 2.0 (the "License"); you may
 *
            @Override
import org.apache.lucene.search.Explanation;
 * KIND, either express or implied.  See the License for the
 */
    @Override
                // we use the top level doc id, since we work with the top level searcher
public final class ExplainPhase implements FetchSubPhase {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
 */
                }
 * license agreements. See the NOTICE file distributed with
                final int topLevelDocId = hitContext.hit().docId();
/*
    }  
 * under the License.  
 * software distributed under the License is distributed on an
                Explanation explanation = context.searcher().explain(context.query(), topLevelDocId);  
import org.opensearch.search.fetch.FetchContext;
                for (RescoreContext rescore : context.rescore()) {
