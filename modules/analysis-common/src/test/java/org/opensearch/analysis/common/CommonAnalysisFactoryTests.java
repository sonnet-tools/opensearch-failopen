        filters.put("apostrophe", null);
        tokenizers.put("ngram", null);
import java.util.Map;
        filters.put("apostrophe", ApostropheFilterFactory.class);
        filters.put("norwegianminimalstem", StemmerTokenFilterFactory.class);
        tokenizers.put("pattern", PatternTokenizerFactory.class);
        filters.put("brazilian_stem", null);
        tokenizers.put("uax29urlemail", UAX29URLEmailTokenizerFactory.class);
        tokenizers.put("letter", LetterTokenizerFactory.class);
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
    public void testAllTokenizersMarked() {
    private void markedTestCase(String name, Map<String, Class<?>> map) {
        Map<String, Class<?>> filters = new TreeMap<>(super.getPreConfiguredCharFilters());
        tokenizers.put("ngram", NGramTokenizerFactory.class);
import org.opensearch.index.analysis.TokenFilterFactory;
 * software distributed under the License is distributed on an
        filters.put("keepword", KeepWordFilterFactory.class);
 * ownership. Elasticsearch licenses this file to you under
        filters.put("galicianstem", StemmerTokenFilterFactory.class);
        filters.put("common_grams", null);
        filters.put("swedishlightstem", StemmerTokenFilterFactory.class);
    public void testAllCharFiltersMarked() {
        filters.put("delimitedpayload", DelimitedPayloadTokenFilterFactory.class);
    public CommonAnalysisFactoryTests() {
        filters.put("hindinormalization", HindiNormalizationFilterFactory.class);
    /**
    @Override
import java.util.TreeMap;
        filters.put("indonesianstem", StemmerTokenFilterFactory.class);
        filters.put("hindi_normalization", null);
 *
        filters.put("decimal_digit", null);
        tokenizers.put("letter", null);
    }
        filters.put("elision", ElisionTokenFilterFactory.class);
        filters.put("soraninormalization", SoraniNormalizationFilterFactory.class);
        tokenizers.put("keyword", null);
        filters.put("ngram", null);
        filters.put("italianlightstem", StemmerTokenFilterFactory.class);
        filters.put("commongramsquery", CommonGramsTokenFilterFactory.class);
     * hasn't been marked in this class with its proper factory.
        filters.put("truncate", TruncateTokenFilterFactory.class);
        // TODO: these charfilters are not yet exposed: useful?
        filters.put("patternreplace", PatternReplaceTokenFilterFactory.class);
        filters.put("germannormalization", GermanNormalizationFilterFactory.class);
import org.apache.lucene.analysis.te.TeluguStemFilterFactory;
 * Modifications Copyright OpenSearch Contributors. See
    public void testAllTokenFiltersMarked() {
    protected Map<String, Class<?>> getTokenFilters() {
 * Licensed to Elasticsearch under one or more contributor
        filters.put("frenchminimalstem", StemmerTokenFilterFactory.class);
        super(new CommonAnalysisModulePlugin());
        filters.put("persian_stem", null);
        filters.put("cjkwidth", CJKWidthFilterFactory.class);
        filters.put("unique", Void.class);
        filters.put("type_as_payload", null);
    protected Map<String, Class<?>> getPreConfiguredTokenFilters() {
    }
        filters.put("keyword_repeat", null);
        filters.put("germanlightstem", StemmerTokenFilterFactory.class);
        filters.put("kstem", null);
        filters.put("persian", Void.class);
        filters.put("cjkbigram", CJKBigramFilterFactory.class);
        filters.put("html_strip", HTMLStripCharFilterFactory.class);
        filters.put("worddelimiter", WordDelimiterTokenFilterFactory.class);
    @Override
        filters.put("greekstem", StemmerTokenFilterFactory.class);
        filters.put("persianstem", PersianStemTokenFilterFactory.class);
        assertTrue("Should contain synonym filter", filters.containsKey("synonym"));
            .collect(toList());
    }
 *
        // this filter is not exposed and should only be used internally
        filters.put("snowballporter", SnowballTokenFilterFactory.class);
        Map<String, Class<?>> filters = new TreeMap<>(super.getCharFilters());
        filters.put("czechstem", CzechStemTokenFilterFactory.class);
    }
        filters.put("portugueseminimalstem", StemmerTokenFilterFactory.class);
        filters.put("portugueselightstem", StemmerTokenFilterFactory.class);
        markedTestCase("char filter", getCharFilters());
public class CommonAnalysisFactoryTests extends AnalysisFactoryTestCase {
import java.util.List;
        assertTrue("Should contain synonym_graph filter", filters.containsKey("synonym_graph"));
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> filters = plugin.getTokenFilters(analysisModule);
        return filters;
        Map<String, Class<?>> filters = new TreeMap<>(super.getTokenFilters());
        tokenizers.put("path_hierarchy", null);
    @Override
        filters.put("edge_ngram", null);
    }
import static java.util.Collections.emptyList;
        Map<String, Class<?>> tokenizers = new TreeMap<>(super.getTokenizers());
     * Fails if a char filter is marked in the superclass with {@link MovedToAnalysisCommon} but
     * hasn't been marked in this class with its proper factory.
        filters.put("keywordmarker", KeywordMarkerTokenFilterFactory.class);
        filters.put("classic", null);
        filters.put("irishlowercase", LowerCaseTokenFilterFactory.class);
 * the Apache License, Version 2.0 (the "License"); you may
        filters.put("limittokencount", LimitTokenCountFilterFactory.class);
        filters.put("galicianminimalstem", StemmerTokenFilterFactory.class);
        filters.put("htmlStrip", HTMLStripCharFilterFactory.class);
        filters.put("arabicstem", ArabicStemTokenFilterFactory.class);
        filters.put("worddelimitergraph", WordDelimiterGraphTokenFilterFactory.class);
        filters.put("czech_stem", null);
        filters.put("indic_normalization", null);
            .filter(e -> e.getValue() == MovedToAnalysisCommon.class)
        return tokenizers;
        filters.put("bengalistem", StemmerTokenFilterFactory.class);
        filters.put("commongrams", CommonGramsTokenFilterFactory.class);
        filters.put("englishpossessive", StemmerTokenFilterFactory.class);
        tokenizers.put("pathhierarchy", PathHierarchyTokenizerFactory.class);
     */
        filters.put("scandinavian_normalization", null);
        filters.put("reverse", ReverseStringFilterFactory.class);
        filters.put("spanishlightstem", StemmerTokenFilterFactory.class);
        filters.put("arabic_stem", null);
     */
    }
        // TODO drop aliases once they are moved to module
        Map<String, Class<?>> tokenizers = new TreeMap<>(super.getPreConfiguredTokenizers());
        Map<String, Class<?>> filters = new TreeMap<>(super.getPreConfiguredTokenFilters());
            name + " marked in AnalysisFactoryTestCase as moved to analysis-common " + "but not mapped here",
        filters.put("kstem", KStemTokenFilterFactory.class);
        filters.put("elision", null);
 * specific language governing permissions and limitations
 * compatible open source license.
import org.apache.lucene.analysis.te.TeluguNormalizationFilterFactory;
        tokenizers.put("edge_ngram", null);
    public Map<String, Class<?>> getPreConfiguredCharFilters() {
        return filters;
        filters.put("cjk_bigram", null);
        tokenizers.put("lowercase", Void.class);
        filters.put("scandinavian_folding", null);
        filters.put("serbiannormalization", SerbianNormalizationFilterFactory.class);
        tokenizers.put("pattern", null);
        filters.put("decimaldigit", DecimalDigitFilterFactory.class);
 * GitHub history for details.
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
        tokenizers.put("whitespace", WhitespaceTokenizerFactory.class);
        markedTestCase("token filter", getTokenFilters());
     * Fails if a char filter is marked in the superclass with {@link MovedToAnalysisCommon} but
    protected Map<String, Class<?>> getCharFilters() {
        filters.put("soranistem", StemmerTokenFilterFactory.class);
        filters.put("indicnormalization", IndicNormalizationFilterFactory.class);
        filters.put("reversestring", ReverseTokenFilterFactory.class);
        filters.put("arabic_normalization", null);
        return tokenizers;
        filters.put("length", null);
        assertTrue("Should contain basic filters", filters.containsKey("lowercase"));
    protected Map<String, Class<?>> getTokenizers() {
        filters.put("russianlightstem", StemmerTokenFilterFactory.class);
        filters.put("flattengraph", FlattenGraphTokenFilterFactory.class);
 * license agreements. See the NOTICE file distributed with
     * hasn't been marked in this class with its proper factory.
        filters.put("portuguesestem", StemmerTokenFilterFactory.class);
        filters.put("htmlstrip", HtmlStripCharFilterFactory.class);
        filters.put("german_normalization", null);
        filters.put("englishminimalstem", StemmerTokenFilterFactory.class);
/*
        filters.put("classic", ClassicFilterFactory.class);
        filters.put("trim", null);
        return filters;
        assertNotNull("Token filters should not be null", filters);
        tokenizers.put("edgeNGram", tokenizers.get("edge_ngram"));
        filters.put("patterncapturegroup", PatternCaptureGroupTokenFilterFactory.class);
    /**
    public void testGetTokenFiltersWithAnalysisModule() {
        tokenizers.put("nGram", tokenizers.get("ngram"));
        filters.put("word_delimiter_graph", null);
        filters.put("russian_stem", SnowballPorterFilterFactory.class);
        assertEquals(
 */
        filters.put("norwegianlightstem", StemmerTokenFilterFactory.class);
    }
import org.mockito.Mock;
import org.opensearch.indices.analysis.AnalysisModule;
        filters.put("brazilianstem", BrazilianStemTokenFilterFactory.class);
        tokenizers.put("simplepattern", SimplePatternTokenizerFactory.class);
        // tokenizers.put("lowercase", XLowerCaseTokenizerFactory.class);
            .map(Map.Entry::getKey)
        filters.put("hyphenationcompoundword", HyphenationCompoundWordTokenFilterFactory.class);
        tokenizers.put("keyword", KeywordTokenizerFactory.class);
        filters.put("telugustem", TeluguStemFilterFactory.class);
    }
        tokenizers.put("thai", null);
        filters.put("arabicnormalization", ArabicNormalizationFilterFactory.class);
        filters.put("hungarianlightstem", StemmerTokenFilterFactory.class);
        filters.put("asciifolding", ASCIIFoldingTokenFilterFactory.class);
        filters.put("greeklowercase", LowerCaseTokenFilterFactory.class);
        tokenizers.put("classic", null);
        filters.put("swedishminimalstem", Void.class);
        filters.put("mapping", MappingCharFilterFactory.class);
        filters.put("german_stem", null);
        filters.put("dictionarycompoundword", DictionaryCompoundWordTokenFilterFactory.class);
        filters.put("trim", TrimTokenFilterFactory.class);
     * 2. Basic filters remain available
package org.opensearch.analysis.common;
 * You may obtain a copy of the License at
        filters.put("porter_stem", null);
        filters.put("snowball", SnowballPorterFilterFactory.class);
 * KIND, either express or implied.  See the License for the
    protected Map<String, Class<?>> getPreConfiguredTokenizers() {
        filters.put("type", KeepTypesFilterFactory.class);
        tokenizers.put("edgengram", EdgeNGramTokenizerFactory.class);
        tokenizers.put("thai", ThaiTokenizerFactory.class);
        filters.put("asciifolding", null);
    /**
        filters.put("limit", LimitTokenCountFilterFactory.class);
    /**
        filters.put("edgengram", EdgeNGramTokenFilterFactory.class);
        filters.put("persiannormalization", PersianNormalizationFilterFactory.class);
 * this work for additional information regarding copyright
        CommonAnalysisModulePlugin plugin = (CommonAnalysisModulePlugin) getAnalysisPlugin();
import org.apache.lucene.analysis.miscellaneous.LimitTokenCountFilterFactory;
        filters.put("norwegiannormalization", Void.class);
        tokenizers.put("uax_url_email", org.apache.lucene.analysis.email.UAX29URLEmailTokenizerFactory.class);
     * 3. Synonym filters remain available when AnalysisModule is provided
        filters.put("delimitedtermfrequency", DelimitedTermFrequencyTokenFilterFactory.class);
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
        filters.put("truncate", null);
        filters.put("germanminimalstem", StemmerTokenFilterFactory.class);
    }
}
import static java.util.stream.Collectors.toList;
 * under the License.
            .sorted()
        return filters;
        filters.put("porterstem", PorterStemTokenFilterFactory.class);
        // handling of zwnj for persian
            unmarked
    }
        filters.put("fingerprint", FingerprintTokenFilterFactory.class);
        filters.put("length", LengthTokenFilterFactory.class);
    private AnalysisModule analysisModule;
        filters.put("patternreplace", PatternReplaceCharFilterFactory.class);
        tokenizers.put("simplepatternsplit", SimplePatternSplitTokenizerFactory.class);
 * SPDX-License-Identifier: Apache-2.0
        filters.put("stemmer", PorterStemFilterFactory.class);
        filters.put("hindistem", StemmerTokenFilterFactory.class);
        filters.put("scandinaviannormalization", ScandinavianNormalizationFilterFactory.class);
            .stream()
    @Override
        filters.put("word_delimiter", null);
        filters.put("fixedshingle", Void.class);
     */
        filters.put("uppercase", null);
        filters.put("scandinavianfolding", ScandinavianFoldingFilterFactory.class);
        filters.put("turkishlowercase", LowerCaseTokenFilterFactory.class);
        filters.put("minhash", MinHashTokenFilterFactory.class);
        filters.put("synonym", SynonymTokenFilterFactory.class);
    @Mock
        filters.put("germanstem", GermanStemTokenFilterFactory.class);
 * not use this file except in compliance with the License.
        filters.put("bengalinormalization", BengaliNormalizationFilterFactory.class);
        filters.put("stemmeroverride", StemmerOverrideTokenFilterFactory.class);
        filters.put("delimited_term_freq", org.apache.lucene.analysis.miscellaneous.DelimitedTermFrequencyTokenFilterFactory.class);
        filters.put("nGram", null);
        );
        tokenizers.put("PathHierarchy", tokenizers.get("path_hierarchy"));
        List<String> unmarked = map.entrySet()
        filters.put("telugunormalization", TeluguNormalizationFilterFactory.class);
        filters.put("edgeNGram", null);
 */
        filters.put("shingle", null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        filters.put("persian_normalization", null);
        filters.put("uppercase", UpperCaseTokenFilterFactory.class);
        filters.put("stop", null);
        filters.put("synonymgraph", SynonymGraphTokenFilterFactory.class);
        filters.put("bengali_normalization", null);
     * 1. All token filters are properly loaded
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.analysis.en.PorterStemFilterFactory;
        filters.put("finnishlightstem", StemmerTokenFilterFactory.class);
        filters.put("frenchlightstem", StemmerTokenFilterFactory.class);
/*
 * this file be licensed under the Apache-2.0 license or a
        markedTestCase("char filter", getTokenizers());
    }
 * Unless required by applicable law or agreed to in writing,
        filters.put("delimited_payload", org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilterFactory.class);
     * Tests the getTokenFilters(AnalysisModule) method to verify:
     * Fails if a tokenizer is marked in the superclass with {@link MovedToAnalysisCommon} but
/*
        filters.put("bulgarianstem", StemmerTokenFilterFactory.class);
    @Override
        filters.put("lowercase", LowerCaseTokenFilterFactory.class);
        filters.put("delimited_payload_filter", org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilterFactory.class);
     */
    }
        filters.put("latvianstem", StemmerTokenFilterFactory.class);
        filters.put("dutch_stem", SnowballPorterFilterFactory.class);
            emptyList(),
        filters.put("sorani_normalization", null);
    @Override
 */
        tokenizers.put("classic", ClassicTokenizerFactory.class);
import org.apache.lucene.analysis.reverse.ReverseStringFilterFactory;
        tokenizers.put("whitespace", null);
        filters.put("cjk_width", null);
        filters.put("ngram", NGramTokenFilterFactory.class);
        filters.put("french_stem", SnowballPorterFilterFactory.class);
