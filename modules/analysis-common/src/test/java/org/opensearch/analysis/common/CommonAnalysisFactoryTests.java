        // tokenizers.put("lowercase", XLowerCaseTokenizerFactory.class);  
        tokenizers.put("letter", LetterTokenizerFactory.class);
        filters.put("french_stem", SnowballPorterFilterFactory.class);
    }
        filters.put("telugustem", TeluguStemFilterFactory.class);
        assertTrue("Should contain basic filters", filters.containsKey("lowercase"));
        filters.put("ngram", NGramTokenFilterFactory.class);
        tokenizers.put("edgeNGram", tokenizers.get("edge_ngram"));
import org.opensearch.indices.analysis.AnalysisModule;
        filters.put("stemmeroverride", StemmerOverrideTokenFilterFactory.class);
        filters.put("brazilian_stem", null);  
        filters.put("irishlowercase", LowerCaseTokenFilterFactory.class);
        filters.put("word_delimiter_graph", null);
        markedTestCase("char filter", getTokenizers());  
    /**  
        filters.put("hindistem", StemmerTokenFilterFactory.class);
        filters.put("trim", TrimTokenFilterFactory.class);
    public void testAllCharFiltersMarked() {
        filters.put("german_normalization", null);
        return filters;
        filters.put("fixedshingle", Void.class);  
        filters.put("worddelimiter", WordDelimiterTokenFilterFactory.class);
        filters.put("unique", Void.class);
 * Licensed to Elasticsearch under one or more contributor  
     */
    /**  
        Map<String, Class<?>> filters = new TreeMap<>(super.getPreConfiguredCharFilters());
 * under the License.  
import java.util.TreeMap;
 * compatible open source license.
    @Override
    public CommonAnalysisFactoryTests() {
        tokenizers.put("pathhierarchy", PathHierarchyTokenizerFactory.class);
        filters.put("finnishlightstem", StemmerTokenFilterFactory.class);
    protected Map<String, Class<?>> getCharFilters() {
 */
    private void markedTestCase(String name, Map<String, Class<?>> map) {
        filters.put("shingle", null);
package org.opensearch.analysis.common;
        filters.put("czech_stem", null);
        filters.put("hindinormalization", HindiNormalizationFilterFactory.class);
            .sorted()  
    @Override
        filters.put("type_as_payload", null);  
        filters.put("dutch_stem", SnowballPorterFilterFactory.class);
        CommonAnalysisModulePlugin plugin = (CommonAnalysisModulePlugin) getAnalysisPlugin();
        filters.put("patternreplace", PatternReplaceTokenFilterFactory.class);
        filters.put("htmlstrip", HtmlStripCharFilterFactory.class);
    }
        filters.put("word_delimiter", null);  
        filters.put("persian", Void.class);
    private AnalysisModule analysisModule;  
import static java.util.Collections.emptyList;  
    }
 *
        // this filter is not exposed and should only be used internally
/*  
 *
        filters.put("galicianstem", StemmerTokenFilterFactory.class);  
        filters.put("length", null);  
        filters.put("soraninormalization", SoraniNormalizationFilterFactory.class);  
        filters.put("frenchminimalstem", StemmerTokenFilterFactory.class);
import org.apache.lucene.analysis.reverse.ReverseStringFilterFactory;
        filters.put("scandinavian_folding", null);
import java.util.List;  
        List<String> unmarked = map.entrySet()
        tokenizers.put("path_hierarchy", null);  
        filters.put("keyword_repeat", null);
     * Tests the getTokenFilters(AnalysisModule) method to verify:
        return tokenizers;  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.te.TeluguNormalizationFilterFactory;  
        filters.put("stemmer", PorterStemFilterFactory.class);
        filters.put("indicnormalization", IndicNormalizationFilterFactory.class);
        filters.put("edgeNGram", null);  
            .map(Map.Entry::getKey)
}
        filters.put("classic", ClassicFilterFactory.class);
        filters.put("flattengraph", FlattenGraphTokenFilterFactory.class);
        filters.put("englishpossessive", StemmerTokenFilterFactory.class);
        filters.put("arabicstem", ArabicStemTokenFilterFactory.class);
        filters.put("cjk_width", null);
        filters.put("patternreplace", PatternReplaceCharFilterFactory.class);  
     * 2. Basic filters remain available  
     */
    }  
        filters.put("portuguesestem", StemmerTokenFilterFactory.class);  
        filters.put("russianlightstem", StemmerTokenFilterFactory.class);  
        filters.put("edge_ngram", null);
        filters.put("uppercase", null);
    public void testAllTokenizersMarked() {
    protected Map<String, Class<?>> getTokenFilters() {
            unmarked
        filters.put("nGram", null);  
        assertEquals(
     * 3. Synonym filters remain available when AnalysisModule is provided
        filters.put("swedishlightstem", StemmerTokenFilterFactory.class);  
        filters.put("asciifolding", ASCIIFoldingTokenFilterFactory.class);  
        return filters;
    /**
    protected Map<String, Class<?>> getTokenizers() {  
        filters.put("length", LengthTokenFilterFactory.class);
        tokenizers.put("keyword", null);
 * this work for additional information regarding copyright
     */  
 * not use this file except in compliance with the License.
        filters.put("indonesianstem", StemmerTokenFilterFactory.class);  
        filters.put("snowballporter", SnowballTokenFilterFactory.class);  
        filters.put("indic_normalization", null);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        filters.put("hindi_normalization", null);
    protected Map<String, Class<?>> getPreConfiguredTokenFilters() {
        filters.put("dictionarycompoundword", DictionaryCompoundWordTokenFilterFactory.class);  
        filters.put("delimited_payload", org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilterFactory.class);
     * 1. All token filters are properly loaded
        filters.put("decimal_digit", null);  
        filters.put("delimitedpayload", DelimitedPayloadTokenFilterFactory.class);  
    public Map<String, Class<?>> getPreConfiguredCharFilters() {  
        filters.put("kstem", KStemTokenFilterFactory.class);  
     * hasn't been marked in this class with its proper factory.
        tokenizers.put("classic", ClassicTokenizerFactory.class);
    public void testGetTokenFiltersWithAnalysisModule() {  
        filters.put("stop", null);  
        filters.put("reversestring", ReverseTokenFilterFactory.class);
        return tokenizers;
     * Fails if a char filter is marked in the superclass with {@link MovedToAnalysisCommon} but
    @Override
        tokenizers.put("keyword", KeywordTokenizerFactory.class);
        filters.put("worddelimitergraph", WordDelimiterGraphTokenFilterFactory.class);  
            name + " marked in AnalysisFactoryTestCase as moved to analysis-common " + "but not mapped here",  
        assertTrue("Should contain synonym_graph filter", filters.containsKey("synonym_graph"));  
        filters.put("swedishminimalstem", Void.class);
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;  
        tokenizers.put("thai", null);  
    @Mock
        filters.put("keywordmarker", KeywordMarkerTokenFilterFactory.class);
        filters.put("spanishlightstem", StemmerTokenFilterFactory.class);
        filters.put("englishminimalstem", StemmerTokenFilterFactory.class);  
        filters.put("snowball", SnowballPorterFilterFactory.class);  
        tokenizers.put("classic", null);
    @Override
 * specific language governing permissions and limitations
        filters.put("portugueseminimalstem", StemmerTokenFilterFactory.class);
import org.apache.lucene.analysis.miscellaneous.LimitTokenCountFilterFactory;  
        filters.put("norwegianlightstem", StemmerTokenFilterFactory.class);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * hasn't been marked in this class with its proper factory.
        filters.put("portugueselightstem", StemmerTokenFilterFactory.class);
 */  
        filters.put("arabic_normalization", null);
        filters.put("sorani_normalization", null);
    /**
        tokenizers.put("simplepatternsplit", SimplePatternSplitTokenizerFactory.class);  
import static java.util.stream.Collectors.toList;
     */
        filters.put("arabicnormalization", ArabicNormalizationFilterFactory.class);
        filters.put("delimited_term_freq", org.apache.lucene.analysis.miscellaneous.DelimitedTermFrequencyTokenFilterFactory.class);  
        filters.put("htmlStrip", HTMLStripCharFilterFactory.class);  
        filters.put("reverse", ReverseStringFilterFactory.class);
        filters.put("ngram", null);
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
        filters.put("bengalinormalization", BengaliNormalizationFilterFactory.class);
        filters.put("persian_stem", null);
        filters.put("html_strip", HTMLStripCharFilterFactory.class);
        filters.put("limittokencount", LimitTokenCountFilterFactory.class);
        filters.put("limit", LimitTokenCountFilterFactory.class);
        filters.put("elision", null);
        filters.put("persiannormalization", PersianNormalizationFilterFactory.class);  
        filters.put("decimaldigit", DecimalDigitFilterFactory.class);  
        tokenizers.put("uax29urlemail", UAX29URLEmailTokenizerFactory.class);  
        tokenizers.put("pattern", null);
        filters.put("soranistem", StemmerTokenFilterFactory.class);
        filters.put("latvianstem", StemmerTokenFilterFactory.class);
        filters.put("brazilianstem", BrazilianStemTokenFilterFactory.class);
        tokenizers.put("lowercase", Void.class);  
        filters.put("galicianminimalstem", StemmerTokenFilterFactory.class);
        tokenizers.put("ngram", NGramTokenizerFactory.class);
    public void testAllTokenFiltersMarked() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        tokenizers.put("nGram", tokenizers.get("ngram"));  
        filters.put("asciifolding", null);
        filters.put("arabic_stem", null);  
        filters.put("hungarianlightstem", StemmerTokenFilterFactory.class);
        filters.put("truncate", null);
        filters.put("delimitedtermfrequency", DelimitedTermFrequencyTokenFilterFactory.class);
        filters.put("german_stem", null);  
    }  
        filters.put("edgengram", EdgeNGramTokenFilterFactory.class);  
        filters.put("norwegiannormalization", Void.class);
        filters.put("telugunormalization", TeluguNormalizationFilterFactory.class);  
        filters.put("serbiannormalization", SerbianNormalizationFilterFactory.class);
        Map<String, Class<?>> filters = new TreeMap<>(super.getTokenFilters());
        filters.put("germannormalization", GermanNormalizationFilterFactory.class);  
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> filters = plugin.getTokenFilters(analysisModule);
        tokenizers.put("uax_url_email", org.apache.lucene.analysis.email.UAX29URLEmailTokenizerFactory.class);
        filters.put("synonym", SynonymTokenFilterFactory.class);
        tokenizers.put("letter", null);
        filters.put("patterncapturegroup", PatternCaptureGroupTokenFilterFactory.class);  
        filters.put("apostrophe", ApostropheFilterFactory.class);
        filters.put("norwegianminimalstem", StemmerTokenFilterFactory.class);
        filters.put("type", KeepTypesFilterFactory.class);  
        filters.put("germanminimalstem", StemmerTokenFilterFactory.class);
        filters.put("keepword", KeepWordFilterFactory.class);
 * GitHub history for details.
        tokenizers.put("thai", ThaiTokenizerFactory.class);
        filters.put("greekstem", StemmerTokenFilterFactory.class);  
        filters.put("minhash", MinHashTokenFilterFactory.class);
        Map<String, Class<?>> tokenizers = new TreeMap<>(super.getPreConfiguredTokenizers());
        filters.put("bengali_normalization", null);
        filters.put("turkishlowercase", LowerCaseTokenFilterFactory.class);  
    }  
        filters.put("bulgarianstem", StemmerTokenFilterFactory.class);
        filters.put("bengalistem", StemmerTokenFilterFactory.class);
        filters.put("scandinavianfolding", ScandinavianFoldingFilterFactory.class);  
import org.apache.lucene.analysis.en.PorterStemFilterFactory;
        tokenizers.put("simplepattern", SimplePatternTokenizerFactory.class);
        filters.put("lowercase", LowerCaseTokenFilterFactory.class);
        filters.put("kstem", null);
        // handling of zwnj for persian  
        filters.put("frenchlightstem", StemmerTokenFilterFactory.class);  
        filters.put("trim", null);
/*
        filters.put("greeklowercase", LowerCaseTokenFilterFactory.class);  
        Map<String, Class<?>> filters = new TreeMap<>(super.getPreConfiguredTokenFilters());  
     * Fails if a char filter is marked in the superclass with {@link MovedToAnalysisCommon} but  
        assertTrue("Should contain synonym filter", filters.containsKey("synonym"));
    @Override  
 * The OpenSearch Contributors require contributions made to  
        filters.put("cjk_bigram", null);
     * hasn't been marked in this class with its proper factory.  
        filters.put("germanlightstem", StemmerTokenFilterFactory.class);
public class CommonAnalysisFactoryTests extends AnalysisFactoryTestCase {  
        super(new CommonAnalysisModulePlugin());
        filters.put("delimited_payload_filter", org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilterFactory.class);
        filters.put("truncate", TruncateTokenFilterFactory.class);
        return filters;
        filters.put("common_grams", null);
        filters.put("germanstem", GermanStemTokenFilterFactory.class);
/*  
import org.opensearch.index.analysis.TokenFilterFactory;
    }
        filters.put("czechstem", CzechStemTokenFilterFactory.class);  
        filters.put("commongrams", CommonGramsTokenFilterFactory.class);  
        tokenizers.put("ngram", null);  
        tokenizers.put("whitespace", WhitespaceTokenizerFactory.class);
        tokenizers.put("whitespace", null);
 * this file be licensed under the Apache-2.0 license or a
    }
        filters.put("commongramsquery", CommonGramsTokenFilterFactory.class);
import java.util.Map;
    protected Map<String, Class<?>> getPreConfiguredTokenizers() {  
            .collect(toList());
        filters.put("cjkbigram", CJKBigramFilterFactory.class);
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Class<?>> filters = new TreeMap<>(super.getCharFilters());  
     * Fails if a tokenizer is marked in the superclass with {@link MovedToAnalysisCommon} but
 * KIND, either express or implied.  See the License for the
        tokenizers.put("PathHierarchy", tokenizers.get("path_hierarchy"));
        filters.put("synonymgraph", SynonymGraphTokenFilterFactory.class);
    }  
        filters.put("persianstem", PersianStemTokenFilterFactory.class);
            .stream()  
        // TODO: these charfilters are not yet exposed: useful?
        assertNotNull("Token filters should not be null", filters);  
        tokenizers.put("pattern", PatternTokenizerFactory.class);
        filters.put("scandinaviannormalization", ScandinavianNormalizationFilterFactory.class);
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        filters.put("fingerprint", FingerprintTokenFilterFactory.class);
        // TODO drop aliases once they are moved to module
        filters.put("elision", ElisionTokenFilterFactory.class);  
    }
    @Override
        filters.put("persian_normalization", null);
        filters.put("classic", null);  
 * software distributed under the License is distributed on an
        filters.put("apostrophe", null);
        filters.put("italianlightstem", StemmerTokenFilterFactory.class);
        filters.put("russian_stem", SnowballPorterFilterFactory.class);
        );  
            .filter(e -> e.getValue() == MovedToAnalysisCommon.class)
            emptyList(),
        tokenizers.put("edgengram", EdgeNGramTokenizerFactory.class);  
    }
        filters.put("scandinavian_normalization", null);  
        Map<String, Class<?>> tokenizers = new TreeMap<>(super.getTokenizers());
 * You may obtain a copy of the License at  
        filters.put("porterstem", PorterStemTokenFilterFactory.class);
import org.apache.lucene.analysis.te.TeluguStemFilterFactory;
import org.mockito.Mock;
        markedTestCase("token filter", getTokenFilters());
        tokenizers.put("edge_ngram", null);
        filters.put("cjkwidth", CJKWidthFilterFactory.class);
        filters.put("porter_stem", null);  
 */  
        filters.put("uppercase", UpperCaseTokenFilterFactory.class);
 * Unless required by applicable law or agreed to in writing,
        filters.put("mapping", MappingCharFilterFactory.class);
 *  
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
        markedTestCase("char filter", getCharFilters());
        filters.put("hyphenationcompoundword", HyphenationCompoundWordTokenFilterFactory.class);
        return filters;
