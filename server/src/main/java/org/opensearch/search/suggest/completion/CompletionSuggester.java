                // collect contexts  
 * The completion suggester implementation
                }
        completionSuggestion.addTerm(completionSuggestEntry);  
import org.apache.lucene.search.DocIdSetIterator;  
}  
                    );
 *  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.suggest.Suggester;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(  
    }
import java.util.Collections;
 */
        CharsRefBuilder spare
                LeafCollector leafCollector = null;
            }
 * The OpenSearch Contributors require contributions made to  
    private static void suggest(IndexSearcher searcher, CompletionQuery query, TopSuggestDocsCollector collector) throws IOException {
import org.apache.lucene.search.Weight;  
            if (scorer != null) {  
                    List<CharSequence> rawContexts = collector.getContexts(suggestDoc.doc);  
                if (leafCollector != null) {
import org.apache.lucene.search.LeafCollector;
 * specific language governing permissions and limitations
                        suggestDoc.doc,
            for (TopSuggestDocs.SuggestScoreDoc suggestDoc : collector.get().scoreLookupDocs()) {
public class CompletionSuggester extends Suggester<CompletionSuggestionContext> {  
                    // collection was terminated prematurely  
 */
import org.apache.lucene.index.LeafReaderContext;  
            CompletionSuggestion completionSuggestion = emptySuggestion(name, suggestionContext, spare);  
import java.util.Set;
package org.opensearch.search.suggest.completion;
                if (numResult++ < suggestionContext.getSize()) {
 * SPDX-License-Identifier: Apache-2.0
        throws IOException {
        CompletionSuggestion.Entry completionSuggestEntry = new CompletionSuggestion.Entry(new Text(spare.toString()), 0, spare.length());
        if (suggestionContext.getFieldType() != null) {
    ) throws IOException {  
        final CompletionSuggestionContext suggestionContext,  
 * under the License.  
        String name,
                        contexts
 * software distributed under the License is distributed on an
import org.apache.lucene.util.CharsRefBuilder;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.suggest.document.TopSuggestDocsCollector;  
import org.apache.lucene.search.BulkScorer;
    protected CompletionSuggestion emptySuggestion(String name, CompletionSuggestionContext suggestion, CharsRefBuilder spare)
        }  
 * Licensed to Elasticsearch under one or more contributor  
            suggest(searcher, suggestionContext.toQuery(), collector);  
                // CollectionTerminatedException and TimeExceededException, but no other exception.
        CompletionSuggestion completionSuggestion = new CompletionSuggestion(name, suggestion.getSize(), suggestion.isSkipDuplicates());  
                        new Text(suggestDoc.key.toString()),
import org.apache.lucene.search.suggest.document.CompletionQuery;
            return completionSuggestion;
 * You may obtain a copy of the License at  
import org.opensearch.search.suggest.Suggest;
                    completionSuggestion.getEntries().get(0).addOption(option);  
                }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        return completionSuggestion;
                    if (rawContexts.size() > 0) {
                Map<String, Set<String>> contexts = Collections.emptyMap();
 *
import org.apache.lucene.search.CollectionTerminatedException;
        Weight weight = query.createWeight(searcher, collector.scoreMode(), 1f);  
/**
                try {
        spare.copyUTF8Bytes(suggestion.getText());
                    scorer.score(leafCollector, context.reader().getLiveDocs(), 0, DocIdSetIterator.NO_MORE_DOCS);
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                        suggestDoc.score,  
 *
 * compatible open source license.
        query = (CompletionQuery) query.rewrite(searcher);
            int shardSize = suggestionContext.getShardSize() != null ? suggestionContext.getShardSize() : suggestionContext.getSize();
 * GitHub history for details.
    }
import org.opensearch.index.mapper.CompletionFieldMapper;  
                }
 * @opensearch.internal
        final IndexSearcher searcher,
            int numResult = 0;
                    leafCollector = collector.getLeafCollector(context);  
    @Override  
import java.util.Map;
                    }  
/*
                }
            }
    public static final CompletionSuggester INSTANCE = new CompletionSuggester();
                } catch (CollectionTerminatedException e) {
                        contexts = fieldType.getContextMappings().getNamedContexts(rawContexts);
import org.apache.lucene.search.IndexSearcher;
/*  
    protected Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> innerExecute(
/*
import org.opensearch.core.common.text.Text;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    // continue with the following leaf
    private CompletionSuggester() {}
 *  
            BulkScorer scorer = weight.bulkScorer(context);
                    break;
        return null;
import java.io.IOException;
import org.apache.lucene.search.suggest.document.TopSuggestDocs;
import java.util.List;  
            TopSuggestGroupDocsCollector collector = new TopSuggestGroupDocsCollector(shardSize, suggestionContext.isSkipDuplicates());
 */
        }  
                } else {
                if (fieldType.hasContextMappings()) {
 */  
    @Override  
 * not use this file except in compliance with the License.
            final CompletionFieldMapper.CompletionFieldType fieldType = suggestionContext.getFieldType();
 * ownership. Elasticsearch licenses this file to you under  
                // Note: this is called if collection ran successfully, including the above special cases of  
        for (LeafReaderContext context : searcher.getIndexReader().leaves()) {
    }
                    leafCollector.finish();  
 * KIND, either express or implied.  See the License for the
