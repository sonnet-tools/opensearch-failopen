                    // from the index for a correction, collateMatch is updated  
                suggestion.getRequireUnigram(),
                            .xContent()
                        generator.postFilter(),  
                    )
        }
import org.apache.lucene.util.BytesRefBuilder;
        CharsRefBuilder spare
/**  
                    }
                    suggestion.confidence(),
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
            }
                        indexReader,
import org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.Result;
        return phraseSuggestion;
                    new DirectCandidateGenerator(
 * compatible open source license.
    }
    }
                }
                    QueryShardContext shardContext = suggestion.getShardContext();  
    private static PhraseSuggestion.Entry buildResultEntry(SuggestionContext suggestion, CharsRefBuilder spare, double cutoffScore) {
                            .createParser(shardContext.getXContentRegistry(), LoggingDeprecationHandler.INSTANCE, querySource)
        PhraseSuggestion phraseSuggestion = new PhraseSuggestion(name, suggestion.getSize());
                    suggestion.gramSize()
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
    }
import org.apache.lucene.util.CharsRefBuilder;  
     * More Ideas:
                    new MultiCandidateGeneratorWrapper(suggestion.getShardSize(), gens.toArray(new CandidateGenerator[0])),  
            final NoisyChannelSpellChecker checker = new NoisyChannelSpellChecker(  
    @Override
            );
 * license agreements. See the NOTICE file distributed with
    public Suggestion<? extends Entry<? extends Option>> innerExecute(
                boolean collateMatch = true;  
        for (int i = 0; i < numGenerators; i++) {
            final boolean collatePrune = (scriptFactory != null) && suggestion.collatePrune();
            final BytesRefBuilder byteSpare = new BytesRefBuilder();  
     *   - add ability to build different error models maybe based on a confusion matrix?
import org.opensearch.index.query.ParsedQuery;
import org.opensearch.script.TemplateScript;
import org.apache.lucene.search.IndexSearcher;
                }
     *   - add ability to find whitespace problems -> we can build a poor mans decompounder with our index based on a automaton?  
                        QueryBuilder innerQueryBuilder = AbstractQueryBuilder.parseInnerQueryBuilder(parser);
                    suggestion.getShardSize(),
        }
                );  
import org.opensearch.search.suggest.Suggest.Suggestion;
 * GitHub history for details.
                    continue;
                    suggestion.maxErrors(),
 * SPDX-License-Identifier: Apache-2.0
                realWordErrorLikelihood,
        final PhraseSuggestion response = new PhraseSuggestion(name, suggestion.getSize());
import org.opensearch.search.suggest.Suggester;
                    resultEntry.addOption(new PhraseSuggestion.Entry.Option(phrase, highlighted, (float) (correction.score)));  
        if (gens.size() > 0 && suggestTerms != null) {
                        generator.preFilter(),
        return analyzer.tokenStream(field, new CharArrayReader(spare.chars(), 0, spare.length()));
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.apache.lucene.search.spell.DirectSpellChecker;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import java.util.List;  
            PhraseSuggestionContext.DirectCandidateGenerator generator = generators.get(i);
     *   - try to combine a token with its subsequent token to find / detect word splits (optional)
            final TemplateScript.Factory scriptFactory = suggestion.getCollateQueryScript();
 * Phrase suggestion implementation
        final String suggestField = suggestion.getField();  
                    highlighted = new Text(spare.toString());
    /*
            Terms terms = MultiTerms.getTerms(indexReader, generator.field());
        return new PhraseSuggestion.Entry(new Text(spare.toString()), 0, spare.length(), cutoffScore);
     *      - for this to work we need some way to defined the position length of a candidate  
import org.apache.lucene.util.BytesRef;
                spare.copyUTF8Bytes(correction.join(SEPARATOR, byteSpare, null, null));
                suggestion.getTokenLimit()  
                    final String querySource = scriptFactory.newInstance(vars).execute();
        CharsRefBuilder spare
import java.io.CharArrayReader;  
import org.apache.lucene.index.IndexReader;
package org.opensearch.search.suggest.phrase;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 * the Apache License, Version 2.0 (the "License"); you may
                        XContentParser parser = MediaTypeRegistry.xContent(querySource)  
 *
 * not use this file except in compliance with the License.
 * under the License.  
import org.apache.lucene.index.Terms;
                    try (
 * this file be licensed under the Apache-2.0 license or a
/*
            try (TokenStream stream = tokenStream(suggestion.getAnalyzer(), suggestion.getText(), spare, suggestion.getField())) {  
                gens.add(  
    }  
        List<PhraseSuggestionContext.DirectCandidateGenerator> generators = suggestion.generators();
     */
 *
            }
        PhraseSuggestionContext suggestion,  
 * this work for additional information regarding copyright
        final List<CandidateGenerator> gens = new ArrayList<>(generators.size());  
                        final ParsedQuery parsedQuery = shardContext.toQuery(innerQueryBuilder);
 */  
                Correction correction = checkerResult.corrections[i];
    @Override  
import java.util.Map;
    private PhraseSuggester() {}
 * software distributed under the License is distributed on an
            for (int i = 0; i < checkerResult.corrections.length; i++) {  
        final int numGenerators = generators.size();
    private final BytesRef SEPARATOR = new BytesRef(" ");  
                        realWordErrorLikelihood,  
 *
 * specific language governing permissions and limitations
        } else {  
        return response;  
 */
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;  
        String name,
                if (!collateMatch && !collatePrune) {  
                    wordScorer,  
            if (terms != null) {
import java.io.IOException;
import org.opensearch.core.common.text.Text;  
                        collateMatch = Lucene.exists(searcher, parsedQuery.query());  
 * Licensed to Elasticsearch under one or more contributor  
            DirectSpellChecker directSpellChecker = generator.createDirectSpellChecker();  
                .newScorer(indexReader, suggestTerms, suggestField, realWordErrorLikelihood, separator);
    ) throws IOException {  
}  
            final BytesRef separator = suggestion.separator();
                    stream,
public final class PhraseSuggester extends Suggester<PhraseSuggestionContext> {
        spare.copyUTF8Bytes(query);
        String name,  
            WordScorer wordScorer = suggestion.model()  
                        terms
                        directSpellChecker,
    private static final String SUGGESTION_TEMPLATE_VAR_NAME = "suggestion";
        double realWordErrorLikelihood = suggestion.realworldErrorLikelihood();
        phraseSuggestion.addTerm(new PhraseSuggestion.Entry(new Text(spare.toString()), 0, spare.length()));  
    public static final PhraseSuggester INSTANCE = new PhraseSuggester();  
    protected Suggestion<? extends Entry<? extends Option>> emptySuggestion(
                checkerResult = checker.getCorrections(
                    ) {  
                if (suggestion.getPreTag() != null) {
                if (scriptFactory != null) {
        PhraseSuggestionContext suggestion,
                Text phrase = new Text(spare.toString());  
                    // Checks if the template query collateScript yields any documents
 * Modifications Copyright OpenSearch Contributors. See  
                }
        spare.copyUTF8Bytes(suggestion.getText());
        IndexSearcher searcher,
import org.opensearch.index.query.AbstractQueryBuilder;  
                } else {
            }
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.common.lucene.Lucene;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Result checkerResult;
 */
            response.addTerm(buildResultEntry(suggestion, spare, Double.MIN_VALUE));
import org.apache.lucene.index.MultiTerms;  
            PhraseSuggestion.Entry resultEntry = buildResultEntry(suggestion, spare, checkerResult.cutoffScore);  
                    vars.put(SUGGESTION_TEMPLATE_VAR_NAME, spare.toString());
                    spare.copyUTF8Bytes(correction.join(SEPARATOR, byteSpare, suggestion.getPreTag(), suggestion.getPostTag()));  
     *   - phonetic filters could be interesting here too for candidate selection
                );  
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;  
    ) throws IOException {  
                        generator.suggestMode(),
import org.opensearch.index.query.QueryBuilder;
                        generator.field(),  
 *  
                    final Map<String, Object> vars = suggestion.getCollateScriptParams();
        spare.copyUTF8Bytes(suggestion.getText());  
        final IndexReader indexReader = searcher.getIndexReader();  
                        generator.size(),
 * Unless required by applicable law or agreed to in writing,
 */
 * @opensearch.internal  
import org.apache.lucene.analysis.Analyzer;  
        final Terms suggestTerms = MultiTerms.getTerms(indexReader, suggestField);
                }
    private static TokenStream tokenStream(Analyzer analyzer, BytesRef query, CharsRefBuilder spare, String field) throws IOException {  
                Text highlighted = null;
import org.opensearch.index.query.QueryShardContext;  
 * ownership. Elasticsearch licenses this file to you under  
/*
import java.util.ArrayList;
                    resultEntry.addOption(new PhraseSuggestion.Entry.Option(phrase, highlighted, (float) (correction.score), collateMatch));
            response.addTerm(resultEntry);
                if (collatePrune) {  
import org.apache.lucene.analysis.TokenStream;
