import java.util.ArrayList;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;  
 * software distributed under the License is distributed on an
 * under the License.  
     * Sole constructor
        }
            contexts.add(context);  
 * The OpenSearch Contributors require contributions made to  
    /**
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <p>  
    TopSuggestGroupDocsCollector(int num, boolean skipDuplicates) {
 */
 * KIND, either express or implied.  See the License for the
     * Returns the contexts associated with the provided <code>doc</code>.  
     * with corresponding document and weight
class TopSuggestGroupDocsCollector extends TopSuggestDocsCollector {
        return docContexts.getOrDefault(doc, Collections.emptyList());  
 * license agreements. See the NOTICE file distributed with
        int globalDoc = docID + docBase;
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * or surface form together. When different contexts or surface forms match the same suggestion form only
import org.apache.lucene.search.suggest.document.TopSuggestDocsCollector;  
    @Override  
 * not use this file except in compliance with the License.
        }
}  
import java.util.Map;
 */  
    /**
     * <p>  
 * @opensearch.internal
package org.opensearch.search.suggest.completion;
        List<CharSequence> contexts = docContexts.computeIfAbsent(globalDoc, k -> new ArrayList<>());
 *
 * GitHub history for details.
 *
        super(num, skipDuplicates);
     */  
            super.collect(docID, key, context, score);  
import java.util.Collections;
    }  
 * This collector groups suggestions coming from the same document but matching different contexts
 **/  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
/*
     * Collects at most <code>num</code> completions
        if (context != null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * Extension of the {@link TopSuggestDocsCollector} that returns top documents from the completion suggester.
/**  
     */
 *  
        if (isNewDoc) {
    List<CharSequence> getContexts(int doc) {
    }
 * Unless required by applicable law or agreed to in writing,
    public void collect(int docID, CharSequence key, CharSequence context, float score) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
    private Map<Integer, List<CharSequence>> docContexts = new HashMap<>();
import java.util.HashMap;
/*  
/*
 *
 */
 * this file be licensed under the Apache-2.0 license or a
 * the best one per document (sorted by weight) is kept.  
        boolean isNewDoc = docContexts.containsKey(globalDoc) == false;  
