        return true;
            context.queryResult()
 * GitHub history for details.
                topDocs = ctx.rescorer().rescore(topDocs, context.searcher(), ctx);
        for (int i = 1; i < topDocs.scoreDocs.length; i++) {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
                // here we only assert that this condition is met.
}
        }
 * @opensearch.internal  
            if (Float.compare(doc.score, lastScore) > 0) {  
public class RescoreProcessor {
        TopDocs topDocs = context.queryResult().topDocs().topDocs;
 */
        }
                .topDocs(new TopDocsAndMaxScore(topDocs, topDocs.scoreDocs[0].score), context.queryResult().sortValueFormats());
            return;
            }  
/*  
                assert context.sort() == null && topDocsSortedByScore(topDocs) : "topdocs should be sorted after rescore";
import org.opensearch.OpenSearchException;  
 * Unless required by applicable law or agreed to in writing,
    }  
 * specific language governing permissions and limitations
 */  
        }
    private boolean topDocsSortedByScore(TopDocs topDocs) {
 * license agreements. See the NOTICE file distributed with
 */  
        } catch (IOException e) {  
 *
/*  
            }
            for (RescoreContext ctx : context.rescore()) {
import java.io.IOException;
        try {  
    }  
 * this work for additional information regarding copyright
        float lastScore = topDocs.scoreDocs[0].score;  
        }
 */
/*
 * RescoreProcessor of a search request, used to run potentially expensive scoring models against the top matching documents.
package org.opensearch.search.rescore;
 * The OpenSearch Contributors require contributions made to  
 *
                // It is the responsibility of the rescorer to sort the resulted top docs,  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    public void process(SearchContext context) {
import org.apache.lucene.search.TopDocs;
                return false;
 * compatible open source license.
 * under the License.  
            lastScore = doc.score;  
 *  
        if (topDocs.scoreDocs.length == 0) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns true if the provided docs are sorted by score.  
 * software distributed under the License is distributed on an
     */
        if (topDocs == null || topDocs.scoreDocs == null || topDocs.scoreDocs.length < 2) {  
 * not use this file except in compliance with the License.
            throw new OpenSearchException("Rescore Phase Failed", e);
/**  
            return true;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            ScoreDoc doc = topDocs.scoreDocs[i];
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.search.ScoreDoc;
 * Modifications Copyright OpenSearch Contributors. See
