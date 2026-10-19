 */  
                SearchHit hit = hitContext.hit();  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
    private void hitExecute(Map<String, InnerHitsContext.InnerHitSubContext> innerHits, SearchHit hit, SourceLookup rootLookup)
 * SPDX-License-Identifier: Apache-2.0
                if (scoreDoc instanceof FieldDoc fieldDoc) {  
 * Gets the inner hits of a document during search
        };
 * GitHub history for details.
import org.apache.lucene.index.LeafReaderContext;
 *
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
import org.opensearch.search.fetch.FetchSubPhase;
            int[] docIdsToLoad = new int[topDoc.topDocs.scoreDocs.length];  
    }
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        this.fetchPhase = fetchPhase;
/**  
                docIdsToLoad[j] = topDoc.topDocs.scoreDocs[j].doc;
                }
import org.opensearch.search.fetch.FetchPhase;
            if (results == null) {
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
            }
                searchHitFields.score(scoreDoc.score);
import org.opensearch.search.SearchHits;  
            innerHitsContext.setRootLookup(rootLookup);  
 */
public final class InnerHitsPhase implements FetchSubPhase {
        }
 * Unless required by applicable law or agreed to in writing,
            public void process(HitContext hitContext) throws IOException {
            FetchSearchResult fetchResult = innerHitsContext.fetchResult();  
import org.opensearch.search.lookup.SourceLookup;  
            fetchPhase.execute(innerHitsContext, "fetch_inner_hits[" + entry.getKey() + "]");
            Map<String, SearchHits> results = hit.getInnerHits();
import org.opensearch.search.fetch.FetchSearchResult;  
 */  
    private final FetchPhase fetchPhase;
            }
 *
                hitExecute(innerHits, hit, rootLookup);
                SearchHit searchHitFields = internalHits[j];
import org.apache.lucene.search.FieldDoc;
        return new FetchSubPhaseProcessor() {
import org.opensearch.search.fetch.FetchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    public FetchSubPhaseProcessor getProcessor(FetchContext searchContext) {
 *  
                ScoreDoc scoreDoc = topDoc.topDocs.scoreDocs[j];  
 *
        for (Map.Entry<String, InnerHitsContext.InnerHitSubContext> entry : innerHits.entrySet()) {  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            @Override
            @Override
 * You may obtain a copy of the License at  
            TopDocsAndMaxScore topDoc = innerHitsContext.topDocs(hit);
            for (int j = 0; j < internalHits.length; j++) {
            innerHitsContext.queryResult().topDocs(topDoc, innerHitsContext.sort() == null ? null : innerHitsContext.sort().formats);
                SourceLookup rootLookup = searchContext.getRootSourceLookup(hitContext);
    }
            results.put(entry.getKey(), fetchResult.hits());
 * KIND, either express or implied.  See the License for the
/*
            innerHitsContext.docIdsToLoad(docIdsToLoad, 0, docIdsToLoad.length);
        throws IOException {
    }  
    @Override
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
            return null;
                hit.setInnerHits(results = new HashMap<>());  
import java.util.HashMap;  
 * this work for additional information regarding copyright
import org.opensearch.search.SearchHit;
        if (searchContext.innerHits() == null || searchContext.innerHits().getInnerHits().isEmpty()) {  
            SearchHit[] internalHits = fetchResult.fetchResult().hits().getHits();
            }  
}
 */
            }  
                    searchHitFields.sortValues(fieldDoc.fields, innerHitsContext.sort().formats);
 * specific language governing permissions and limitations
            public void setNextReader(LeafReaderContext readerContext) {  
import org.apache.lucene.search.ScoreDoc;  
    public InnerHitsPhase(FetchPhase fetchPhase) {  
import java.util.Map;
/*  
        Map<String, InnerHitsContext.InnerHitSubContext> innerHits = searchContext.innerHits().getInnerHits();  
import java.io.IOException;
package org.opensearch.search.fetch.subphase;
            }  
 * under the License.  
            InnerHitsContext.InnerHitSubContext innerHitsContext = entry.getValue();
        }
            innerHitsContext.setId(hit.getId());
 * compatible open source license.
            for (int j = 0; j < topDoc.topDocs.scoreDocs.length; j++) {
