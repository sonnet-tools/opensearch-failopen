        .put("letter", MovedToAnalysisCommon.class)
    public void testTokenFilters() {
        // like limittokencount, but by position
        }
        missing.addAll(  
        .put("mapping", MovedToAnalysisCommon.class)
        .put("germannormalization", MovedToAnalysisCommon.class)
import java.util.Locale;  
        .put("swedishminimalstem", MovedToAnalysisCommon.class)
        // suggest stop
 * <p>
        // LUCENE-8332
     * filter to the class of the Lucene {@link TokenFilterFactory} that it
        .put("standard", StandardTokenizerFactory.class)
 */
     * Returns the AnalysisPlugin instance that was passed to this test case.  
    }
 * If we don't want to expose one for a specific reason, just map it to Void.  
        // puts the type as a synonym
 * specific language governing permissions and limitations
        // puts hyphenated words back together
        .put("numericpayload", Void.class)
        missing.addAll(  
 * this file be licensed under the Apache-2.0 license or a
        .put("elision", MovedToAnalysisCommon.class)
        .put("reversestring", MovedToAnalysisCommon.class)
        // ???  
import java.util.stream.Collectors;
 * not use this file except in compliance with the License.
 * GitHub history for details.
        .put("delimitedboost", Void.class)
     * specific analysis components.
        .immutableMap();  
        .put("brazilianstem", MovedToAnalysisCommon.class)  
        .put("synonym", MovedToAnalysisCommon.class)
        // ???
        .put("flattengraph", MovedToAnalysisCommon.class)
     * there is no Lucene {@linkplain TokenFilterFactory} then the right
     * Map containing pre-configured token filters that should be available
        return KNOWN_CHARFILTERS;
    private final AnalysisPlugin plugin;
        .put("germanstem", MovedToAnalysisCommon.class)
        .put("synonymgraph", MovedToAnalysisCommon.class)  
        .put("asciifolding", MovedToAnalysisCommon.class)  
        .put("ngram", MovedToAnalysisCommon.class)
        // puts the type into the payload  
        // exposed in ES  
     * after installing this plugin. The map is from the name of the token
        .put("ngram", MovedToAnalysisCommon.class)
 */
        // capitalizes tokens  
        .put("decimaldigit", MovedToAnalysisCommon.class)
        .put("length", MovedToAnalysisCommon.class)
 *     http://www.apache.org/licenses/LICENSE-2.0
        .put("pattern", MovedToAnalysisCommon.class)
    protected Map<String, Class<?>> getTokenFilters() {
/*  
 * You may obtain a copy of the License at  
        .put("fixedshingle", MovedToAnalysisCommon.class)
        .put("fingerprint", Void.class)
     * @return The AnalysisPlugin instance used by this test case
 * SPDX-License-Identifier: Apache-2.0
    public void testTokenizers() {
    /**
}
    protected AnalysisPlugin getAnalysisPlugin() {  
        .put("czechstem", MovedToAnalysisCommon.class)
        .put("norwegianminimalstem", MovedToAnalysisCommon.class)
        .put("typeaspayload", Void.class)
        .put("typeassynonym", Void.class)  
 * software distributed under the License is distributed on an
        // LUCENE-8936  
                .collect(Collectors.toSet())
        .put("thai", MovedToAnalysisCommon.class)
        .put("pathhierarchy", MovedToAnalysisCommon.class)  
        Set<String> missing = new TreeSet<String>();
    protected Map<String, Class<?>> getPreConfiguredTokenFilters() {
        .put("bulgarianstem", MovedToAnalysisCommon.class)
    /**
        // LUCENE-8273: ProtectedTermFilterFactory allows analysis chains to skip
    /**  
        .put("greeklowercase", MovedToAnalysisCommon.class)
        // fingerprint
        missing.removeAll(getCharFilters().keySet());  
    public AnalysisFactoryTestCase(AnalysisPlugin plugin) {
 *  
        .put("soranistem", MovedToAnalysisCommon.class)
        // for old indices
        .put("simplepattern", MovedToAnalysisCommon.class)
        .put("greekstem", MovedToAnalysisCommon.class)  
import java.util.HashMap;
        .put("keyword", MovedToAnalysisCommon.class)  
        .put("removeduplicates", Void.class)  
        // LUCENE-10248
        // particular token filters based on the attributes of the current token.
        .put("htmlstrip", MovedToAnalysisCommon.class)
        return KNOWN_TOKENFILTERS;  
        .put("indonesianstem", MovedToAnalysisCommon.class)
        .put("cjkbigram", MovedToAnalysisCommon.class)
        return KNOWN_TOKENIZERS;
        .put("scandinavianfolding", MovedToAnalysisCommon.class)
 * Licensed to Elasticsearch under one or more contributor  
        .put("englishpossessive", MovedToAnalysisCommon.class)  
                .collect(Collectors.toSet())
    }
        .put("lowercase", MovedToAnalysisCommon.class)
 * The OpenSearch Contributors require contributions made to  
        .put("suggeststop", Void.class)
     * If there is no Lucene {@linkplain TokenizerFactory} then the right  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Class<?>> filters = new HashMap<>();
        );
    }  
        .put("romaniannormalization", Void.class)
        // LUCENE-10352
public abstract class AnalysisFactoryTestCase extends OpenSearchTestCase {  
        assertTrue("new charfilters found, please update KNOWN_CHARFILTERS: " + missing.toString(), missing.isEmpty());
        private MovedToAnalysisCommon() {}  
        .put("galicianstem", MovedToAnalysisCommon.class)  
     */
     *  
    protected Map<String, Class<?>> getPreConfiguredTokenizers() {  
import org.apache.lucene.analysis.TokenFilterFactory;
    protected Map<String, Class<?>> getCharFilters() {
        .put("commongrams", MovedToAnalysisCommon.class)
    }
import org.apache.lucene.analysis.TokenizerFactory;
        .put("arabicnormalization", MovedToAnalysisCommon.class)
        .put("patterntyping", Void.class)
        .put("delimitedtermfrequency", MovedToAnalysisCommon.class)
        this.plugin = Objects.requireNonNull(plugin, "plugin is required. use an empty plugin for core");
        .put("delimitedpayload", MovedToAnalysisCommon.class)  
        .put("persianstem", MovedToAnalysisCommon.class)  
        .put("scandinaviannormalization", MovedToAnalysisCommon.class)
        .put("patterncapturegroup", MovedToAnalysisCommon.class)  
        .put("daterecognizer", Void.class)
        // TODO: these charfilters are not yet exposed: useful?
        .put("type", MovedToAnalysisCommon.class)  
 */  
        .put("apostrophe", MovedToAnalysisCommon.class)  
        .put("portugueseminimalstem", MovedToAnalysisCommon.class)
        .put("hyphenationcompoundword", MovedToAnalysisCommon.class)
/*  
        .put("limittokencount", MovedToAnalysisCommon.class)  
        .put("worddelimitergraph", MovedToAnalysisCommon.class)  
     * removed when the module is complete and these analysis components aren't available to core.  
        .put("persian", Void.class)
        .put("commongramsquery", MovedToAnalysisCommon.class)  
        // exposed in OpenSearch  
        .put("latvianstem", MovedToAnalysisCommon.class)
        // for tee-sinks  
        .put("telugunormalization", MovedToAnalysisCommon.class)
                .stream()
/**  
        .put("uppercase", MovedToAnalysisCommon.class)
        .put("truncate", MovedToAnalysisCommon.class)
 */  
                .collect(Collectors.toSet())
        .put("telugustem", MovedToAnalysisCommon.class)
    }
        // handling of zwnj for persian  
        .put("bengalistem", MovedToAnalysisCommon.class)
    }
        .put("patternreplace", MovedToAnalysisCommon.class)
        .put("patternreplace", MovedToAnalysisCommon.class)  
            org.apache.lucene.analysis.TokenizerFactory.availableTokenizers()
 * ownership. Elasticsearch licenses this file to you under  
            org.apache.lucene.analysis.TokenFilterFactory.availableTokenFilters()
package org.opensearch.indices.analysis;
        // repeats anything marked as keyword  
        missing.removeAll(getTokenizers().keySet());  
    }
        filters.put("lowercase", null);  
                .stream()
    protected Map<String, Class<?>> getTokenizers() {  
        .put("frenchlightstem", MovedToAnalysisCommon.class)  
        return plugin;
    }
        .put("wikipedia", Void.class)
        .put("daitchmokotoffsoundex", Void.class)
        .put("indicnormalization", MovedToAnalysisCommon.class)  
     * hand side should be {@link Void}.
                .map(key -> key.toLowerCase(Locale.ROOT))  
            org.apache.lucene.analysis.CharFilterFactory.availableCharFilters()
        .put("capitalization", Void.class)
        .put("englishminimalstem", MovedToAnalysisCommon.class)
 * Modifications Copyright OpenSearch Contributors. See
        .put("stemmeroverride", MovedToAnalysisCommon.class)
        // LUCENE-9575: recognize arbitrary patterns that include punctuation  
 *
        // exposed in OpenSearch
import org.opensearch.common.collect.MapBuilder;  
            tokenizers.put(tokenizer.name().toLowerCase(Locale.ROOT), null);
import org.opensearch.index.analysis.StopTokenFilterFactory;
    public void testCharFilters() {
    /**
     * is emulating. If the Lucene {@linkplain TokenizerFactory} is
import org.opensearch.plugins.AnalysisPlugin;
        .put("portugueselightstem", MovedToAnalysisCommon.class)  
    public Map<String, Class<?>> getPreConfiguredCharFilters() {  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
     * {@code null} then the test will look it up for you from the name. If  
        Set<String> missing = new TreeSet<String>();
import java.util.TreeSet;
        .put("uax29urlemail", MovedToAnalysisCommon.class)  
        .put("trim", MovedToAnalysisCommon.class)  
        .put("bengalinormalization", MovedToAnalysisCommon.class)
        .put("finnishlightstem", MovedToAnalysisCommon.class)
        .put("codepointcount", Void.class)  
    static final Map<String, Class<?>> KNOWN_TOKENFILTERS = new MapBuilder<String, Class<?>>()
        .put("arabicstem", MovedToAnalysisCommon.class)
        assertTrue("new tokenfilters found, please update KNOWN_TOKENFILTERS: " + missing.toString(), missing.isEmpty());
        .put("spanishlightstem", MovedToAnalysisCommon.class)  
        return filters;  
        .put("stop", StopTokenFilterFactory.class)
        .put("soraninormalization", MovedToAnalysisCommon.class)
        Set<String> missing = new TreeSet<String>();
    }
import org.opensearch.test.OpenSearchTestCase;  
        .put("whitespace", MovedToAnalysisCommon.class)
    private static final Map<String, Class<?>> KNOWN_TOKENIZERS = new MapBuilder<String, Class<?>>()
import static java.util.Collections.emptyMap;
        .put("hungarianlightstem", MovedToAnalysisCommon.class)  
        .immutableMap();
 * Unless required by applicable law or agreed to in writing,
        .put("japanesecompletion", Void.class)
     * filter to the class of the Lucene {@link TokenizerFactory} that it  
        .put("word2vecsynonym", Void.class)
        .put("shingle", ShingleTokenFilterFactory.class)
        .put("worddelimiter", MovedToAnalysisCommon.class)
        .put("germanlightstem", MovedToAnalysisCommon.class)
        .put("cjkwidth", MovedToAnalysisCommon.class)  
        .put("porterstem", MovedToAnalysisCommon.class)
     * Marker class for components that have moved to the analysis-common modules. This will be
     * is emulating. If the Lucene {@linkplain TokenFilterFactory} is
import java.util.Map;
import org.opensearch.index.analysis.ShingleTokenFilterFactory;
        .put("japanesehiraganauppercase", Void.class)  
 *
        .put("spanishpluralstem", Void.class)  
        .put("keywordmarker", MovedToAnalysisCommon.class)
        .put("germanminimalstem", MovedToAnalysisCommon.class)  
        );
        .put("edgengram", MovedToAnalysisCommon.class)
     * hand side should be {@link Void}.
 * Alerts us if new analysis components are added to Lucene, so we don't miss them.
        // removes duplicates at the same position (this should be used by the existing factory)
        .put("galicianminimalstem", MovedToAnalysisCommon.class)
        .put("serbiannormalization", MovedToAnalysisCommon.class)  
        .put("italianlightstem", MovedToAnalysisCommon.class)  
        .put("simplepatternsplit", MovedToAnalysisCommon.class)  
 * compatible open source license.
        .put("swedishlightstem", MovedToAnalysisCommon.class)  
        );
     */
        Map<String, Class<?>> tokenizers = new HashMap<>();
        .put("hindinormalization", MovedToAnalysisCommon.class)
    }
     * The plugin being tested. Core uses an "empty" plugin so we don't have to throw null checks all over the place.  
        missing.removeAll(getTokenFilters().keySet());  
        // like limittokencount, but by offset
        .put("limittokenposition", Void.class)
        .put("edgengram", MovedToAnalysisCommon.class)  
        // LUCENE-9574: test flags on tokens vs a bitmask and drops tokens that have all specified flags  
        .put("spanishminimalstem", Void.class)
        for (PreBuiltTokenizers tokenizer : PreBuiltTokenizers.values()) {  
 * The deprecated ones can be mapped to Deprecated.class.
/*
        .put("protectedterm", Void.class)  
        assertTrue("new tokenizers found, please update KNOWN_TOKENIZERS: " + missing.toString(), missing.isEmpty());
     * This protected method allows subclasses to access the plugin for testing
        .put("classic", MovedToAnalysisCommon.class)
     */  
        .put("japanesekatakanauppercase", Void.class)
     * after installing this plugin. The map is from the name of the token  
     */
        .put("russianlightstem", MovedToAnalysisCommon.class)  
        // like length filter (but codepoints)
        .put("fixbrokenoffsets", Void.class)  
                .map(key -> key.toLowerCase(Locale.ROOT))  
        return tokenizers;  
        .put("persiannormalization", MovedToAnalysisCommon.class)
        .put("norwegiannormalization", MovedToAnalysisCommon.class)
        .put("minhash", MovedToAnalysisCommon.class)
     */
        .put("norwegianlightstem", MovedToAnalysisCommon.class)  
     * Map containing pre-configured tokenizers that should be available
        .put("snowballporter", MovedToAnalysisCommon.class)  
import org.opensearch.index.analysis.HunspellTokenFilterFactory;
        .put("concatenategraph", Void.class)
        .put("irishlowercase", MovedToAnalysisCommon.class)
     * {@code null} then the test will look it up for you from the name.
        .put("portuguesestem", MovedToAnalysisCommon.class)
    }  
    static final Map<String, Class<?>> KNOWN_CHARFILTERS = new MapBuilder<String, Class<?>>()
        .put("tokenoffsetpayload", Void.class)
        .put("classic", MovedToAnalysisCommon.class)
        // TODO drop this temporary shim when all the old style tokenizers have been migrated to new style
        .put("hunspellstem", HunspellTokenFilterFactory.class)
        .put("keepword", MovedToAnalysisCommon.class)
        .put("cjkwidth", Void.class)
        .put("dictionarycompoundword", MovedToAnalysisCommon.class)
        .put("hindistem", MovedToAnalysisCommon.class)
        // for token filters that generate bad offsets, which are now rejected since Lucene 7
        .put("dropifflagged", Void.class)
import java.util.Objects;
import java.util.Set;  
 * license agreements. See the NOTICE file distributed with
        .put("frenchminimalstem", MovedToAnalysisCommon.class)
        .put("kstem", MovedToAnalysisCommon.class)  
    }
        // TODO: these tokenfilters are not yet exposed: useful?  
        return emptyMap();
        // https://github.com/apache/lucene/pull/12169  
        .immutableMap();  
                .map(key -> key.toLowerCase(Locale.ROOT))  
    /**
        filters.put("standard", Void.class);
        // https://github.com/apache/lucene/pull/12915
        missing.addAll(  
        // this one "seems to mess up offsets". probably shouldn't be a tokenizer...  
        .put("hyphenatedwords", Void.class)
        .put("keywordrepeat", Void.class)
import org.opensearch.index.analysis.StandardTokenizerFactory;  
 * the Apache License, Version 2.0 (the "License"); you may
        .put("limittokenoffset", Void.class)  
                .stream()
 * under the License.  
        .put("turkishlowercase", MovedToAnalysisCommon.class)
    protected static final class MovedToAnalysisCommon {
