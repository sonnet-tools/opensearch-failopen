                );
        return response;
package org.opensearch.search.suggest.phrase;
        spare.copyUTF8Bytes(query);
     *   - add ability to build different error models maybe based on a confusion matrix?
                    wordScorer,
            final boolean collatePrune = (scriptFactory != null) && suggestion.collatePrune();
/**
                        generator.postFilter(),
                boolean collateMatch = true;
import org.opensearch.search.suggest.Suggester;
            try (TokenStream stream = tokenStream(suggestion.getAnalyzer(), suggestion.getText(), spare, suggestion.getField())) {
 * Phrase suggestion implementation
                }
 * The OpenSearch Contributors require contributions made to
    private static final String SUGGESTION_TEMPLATE_VAR_NAME = "suggestion";
import org.apache.lucene.util.BytesRefBuilder;
     */
 * license agreements. See the NOTICE file distributed with
/*
                        collateMatch = Lucene.exists(searcher, parsedQuery.query());
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.index.MultiTerms;
import org.apache.lucene.analysis.TokenStream;
                        indexReader,
import org.apache.lucene.index.IndexReader;
                    // Checks if the template query collateScript yields any documents
                if (!collateMatch && !collatePrune) {
import org.opensearch.index.query.QueryBuilder;
                );
                    final String querySource = scriptFactory.newInstance(vars).execute();
    /*
import org.opensearch.index.query.ParsedQuery;
    @Override
 * under the License.
    private PhraseSuggester() {}
        spare.copyUTF8Bytes(suggestion.getText());
            final BytesRef separator = suggestion.separator();
            final BytesRefBuilder byteSpare = new BytesRefBuilder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (collatePrune) {
            response.addTerm(resultEntry);
    public static final PhraseSuggester INSTANCE = new PhraseSuggester();
        spare.copyUTF8Bytes(suggestion.getText());
                        generator.field(),
import org.opensearch.script.TemplateScript;
                        generator.preFilter(),
 *
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
    }
import org.apache.lucene.index.Terms;
                    try (
        String name,
import org.apache.lucene.search.spell.DirectSpellChecker;
    @Override
 * this work for additional information regarding copyright
     *      - for this to work we need some way to defined the position length of a candidate
                    suggestion.confidence(),
public final class PhraseSuggester extends Suggester<PhraseSuggestionContext> {
                    resultEntry.addOption(new PhraseSuggestion.Entry.Option(phrase, highlighted, (float) (correction.score), collateMatch));
    private static TokenStream tokenStream(Analyzer analyzer, BytesRef query, CharsRefBuilder spare, String field) throws IOException {
                checkerResult = checker.getCorrections(
 * ownership. Elasticsearch licenses this file to you under
        final List<CandidateGenerator> gens = new ArrayList<>(generators.size());
     *   - add ability to find whitespace problems -> we can build a poor mans decompounder with our index based on a automaton?
import java.io.IOException;
                if (scriptFactory != null) {
            final TemplateScript.Factory scriptFactory = suggestion.getCollateQueryScript();
                    highlighted = new Text(spare.toString());
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
                .newScorer(indexReader, suggestTerms, suggestField, realWordErrorLikelihood, separator);
        PhraseSuggestion phraseSuggestion = new PhraseSuggestion(name, suggestion.getSize());
 * this file be licensed under the Apache-2.0 license or a
    }
    ) throws IOException {
            Result checkerResult;
        String name,
    ) throws IOException {
                Text phrase = new Text(spare.toString());
     *   - try to combine a token with its subsequent token to find / detect word splits (optional)
 *
        return analyzer.tokenStream(field, new CharArrayReader(spare.chars(), 0, spare.length()));
                    resultEntry.addOption(new PhraseSuggestion.Entry.Option(phrase, highlighted, (float) (correction.score)));
                    QueryShardContext shardContext = suggestion.getShardContext();
        return new PhraseSuggestion.Entry(new Text(spare.toString()), 0, spare.length(), cutoffScore);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
import org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.Result;
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.index.query.AbstractQueryBuilder;
                    )
                        realWordErrorLikelihood,
            WordScorer wordScorer = suggestion.model()
 * You may obtain a copy of the License at
 */
 * KIND, either express or implied.  See the License for the
                } else {
 *
        IndexSearcher searcher,
                suggestion.getRequireUnigram(),
                if (suggestion.getPreTag() != null) {
            for (int i = 0; i < checkerResult.corrections.length; i++) {
                suggestion.getTokenLimit()
            Terms terms = MultiTerms.getTerms(indexReader, generator.field());
                        XContentParser parser = MediaTypeRegistry.xContent(querySource)
                        directSpellChecker,
        final PhraseSuggestion response = new PhraseSuggestion(name, suggestion.getSize());
                            .xContent()
                Correction correction = checkerResult.corrections[i];
import org.opensearch.core.xcontent.XContentParser;
                }
 * software distributed under the License is distributed on an
            }
                    ) {
 */
                Text highlighted = null;
import java.util.ArrayList;
import org.opensearch.index.query.QueryShardContext;
            response.addTerm(buildResultEntry(suggestion, spare, Double.MIN_VALUE));
            }
 *
                        generator.size(),
        final int numGenerators = generators.size();
            PhraseSuggestionContext.DirectCandidateGenerator generator = generators.get(i);
        List<PhraseSuggestionContext.DirectCandidateGenerator> generators = suggestion.generators();
            final NoisyChannelSpellChecker checker = new NoisyChannelSpellChecker(
            PhraseSuggestion.Entry resultEntry = buildResultEntry(suggestion, spare, checkerResult.cutoffScore);
                    suggestion.gramSize()
        CharsRefBuilder spare
                realWordErrorLikelihood,
        for (int i = 0; i < numGenerators; i++) {
                        generator.suggestMode(),
import org.apache.lucene.util.CharsRefBuilder;
/*
     *   - phonetic filters could be interesting here too for candidate selection
                    suggestion.getShardSize(),
        double realWordErrorLikelihood = suggestion.realworldErrorLikelihood();
                        final ParsedQuery parsedQuery = shardContext.toQuery(innerQueryBuilder);
                    stream,
                    suggestion.maxErrors(),
        return phraseSuggestion;
import java.util.Map;
                }
                    new DirectCandidateGenerator(
 * compatible open source license.
    public Suggestion<? extends Entry<? extends Option>> innerExecute(
 */
                            .createParser(shardContext.getXContentRegistry(), LoggingDeprecationHandler.INSTANCE, querySource)
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.common.text.Text;
                        QueryBuilder innerQueryBuilder = AbstractQueryBuilder.parseInnerQueryBuilder(parser);
                    // from the index for a correction, collateMatch is updated
                spare.copyUTF8Bytes(correction.join(SEPARATOR, byteSpare, null, null));
        PhraseSuggestionContext suggestion,
        phraseSuggestion.addTerm(new PhraseSuggestion.Entry(new Text(spare.toString()), 0, spare.length()));
        final String suggestField = suggestion.getField();
        }
        }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import java.util.List;
                    spare.copyUTF8Bytes(correction.join(SEPARATOR, byteSpare, suggestion.getPreTag(), suggestion.getPostTag()));
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
    }
            if (terms != null) {
        PhraseSuggestionContext suggestion,
}
            );
        final Terms suggestTerms = MultiTerms.getTerms(indexReader, suggestField);
                }
    private final BytesRef SEPARATOR = new BytesRef(" ");
        if (gens.size() > 0 && suggestTerms != null) {
 */
 * specific language governing permissions and limitations
 * GitHub history for details.
                gens.add(
import org.opensearch.common.lucene.Lucene;
                    new MultiCandidateGeneratorWrapper(suggestion.getShardSize(), gens.toArray(new CandidateGenerator[0])),
    private static PhraseSuggestion.Entry buildResultEntry(SuggestionContext suggestion, CharsRefBuilder spare, double cutoffScore) {
                    final Map<String, Object> vars = suggestion.getCollateScriptParams();
    protected Suggestion<? extends Entry<? extends Option>> emptySuggestion(
/*
     * More Ideas:
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.Analyzer;
import java.io.CharArrayReader;
import org.opensearch.search.suggest.Suggest.Suggestion;
                        terms
import org.apache.lucene.search.IndexSearcher;
        } else {
        CharsRefBuilder spare
                    continue;
        final IndexReader indexReader = searcher.getIndexReader();
                    vars.put(SUGGESTION_TEMPLATE_VAR_NAME, spare.toString());
                    }
            DirectSpellChecker directSpellChecker = generator.createDirectSpellChecker();
