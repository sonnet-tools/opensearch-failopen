import org.apache.lucene.util.BytesRef;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            spare  
                suggestion.getShardSize(),
        List<Token> tokens = queryTerms(suggestion, spare);
            this.startOffset = startOffset;
import java.util.ArrayList;  
            for (SuggestWord suggestWord : suggestedWords) {
    public static final TermSuggester INSTANCE = new TermSuggester();
    }
 * software distributed under the License is distributed on an
            TermSuggestion.Entry resultEntry = new TermSuggestion.Entry(key, token.startOffset, token.endOffset - token.startOffset);  
 * compatible open source license.
            // TODO: Extend DirectSpellChecker in 4.1, to get the raw suggested words as BytesRef
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
    }
 * @opensearch.internal  
    @Override
                @Override  
                indexReader,
 */  
            suggestion.getAnalyzer(),
                Text word = new Text(suggestWord.string);
import org.apache.lucene.search.IndexSearcher;
                suggestion.getDirectSpellCheckerSettings().suggestMode()  
import org.opensearch.search.suggest.phrase.DirectCandidateGenerator;  
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (Token token : tokens) {
        TermSuggestion termSuggestion = new TermSuggestion(name, suggestion.getSize(), suggestion.getDirectSpellCheckerSettings().sort());  
            termSuggestion.addTerm(resultEntry);
 * GitHub history for details.
            );
        }  
 * You may obtain a copy of the License at  
/**  
            response.addTerm(resultEntry);
import org.apache.lucene.util.BytesRefBuilder;  
            this.term = term;  
    @Override
            Text key = new Text(new BytesArray(token.term.bytes()));  
 * The OpenSearch Contributors require contributions made to  
        DirectCandidateGenerator.analyze(
 * license agreements. See the NOTICE file distributed with
        DirectSpellChecker directSpellChecker = suggestion.getDirectSpellCheckerSettings().createDirectSpellChecker();
            Text key = new Text(new BytesArray(token.term.bytes()));
        );
 * SPDX-License-Identifier: Apache-2.0
 *  
}  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        final String field = suggestion.getField();  
                token.term,  
    private static class Token {
            field,
 */
            TermSuggestion.Entry resultEntry = new TermSuggestion.Entry(key, token.startOffset, token.endOffset - token.startOffset);
 * Unless required by applicable law or agreed to in writing,
        TermSuggestion response = new TermSuggestion(name, suggestion.getSize(), suggestion.getDirectSpellCheckerSettings().sort());
public final class TermSuggester extends Suggester<TermSuggestionContext> {
        return result;
            SuggestWord[] suggestedWords = directSpellChecker.suggestSimilar(
import java.util.List;
 * KIND, either express or implied.  See the License for the
    protected TermSuggestion emptySuggestion(String name, TermSuggestionContext suggestion, CharsRefBuilder spare) throws IOException {
    }  
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesArray;
                resultEntry.addOption(new TermSuggestion.Entry.Option(word, suggestWord.freq, suggestWord.score));  
        }  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    private TermSuggester() {}  
 * ownership. Elasticsearch licenses this file to you under  
        final List<Token> result = new ArrayList<>();
import org.apache.lucene.util.CharsRefBuilder;
        return response;
 * under the License.  
        for (Token token : tokens) {  
import org.opensearch.search.suggest.Suggester;
package org.opensearch.search.suggest.term;
            },
    public TermSuggestion innerExecute(String name, TermSuggestionContext suggestion, IndexSearcher searcher, CharsRefBuilder spare)  
 * this file be licensed under the Apache-2.0 license or a
            suggestion.getText(),  
            }
            new DirectCandidateGenerator.TokenConsumer() {
import org.apache.lucene.index.Term;
 * Modifications Copyright OpenSearch Contributors. See  
 *
/*
            this.endOffset = endOffset;
        public final Term term;
import org.apache.lucene.search.spell.SuggestWord;
 *
        public final int endOffset;  
import org.apache.lucene.index.IndexReader;  
    private static List<Token> queryTerms(SuggestionContext suggestion, CharsRefBuilder spare) throws IOException {
        final IndexReader indexReader = searcher.getIndexReader();  
                public void nextToken() {
        List<Token> tokens = queryTerms(suggestion, spare);
        private Token(Term term, int startOffset, int endOffset) {
import org.opensearch.core.common.text.Text;  
                }
 * the Apache License, Version 2.0 (the "License"); you may
 * The Term Suggester implementation
                    Term term = new Term(field, BytesRef.deepCopyOf(fillBytesRef(new BytesRefBuilder())));
                    result.add(new Token(term, offsetAttr.startOffset(), offsetAttr.endOffset()));  
/*
        public final int startOffset;
        }  
import org.apache.lucene.search.spell.DirectSpellChecker;  
 */
        return termSuggestion;
 */
 *
import java.io.IOException;
