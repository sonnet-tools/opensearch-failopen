        .put("word2vecsynonym", Void.class)
import static java.util.Collections.emptyMap;
        return plugin;
import java.util.Locale;
        .put("greeklowercase", MovedToAnalysisCommon.class)
     * specific analysis components.
    protected static final class MovedToAnalysisCommon {
    protected AnalysisPlugin getAnalysisPlugin() {
        // capitalizes tokens
        // TODO: these charfilters are not yet exposed: useful?
        .put("limittokencount", MovedToAnalysisCommon.class)
        .immutableMap();
        missing.addAll(
     * after installing this plugin. The map is from the name of the token
        .put("scandinavianfolding", MovedToAnalysisCommon.class)
        .put("delimitedpayload", MovedToAnalysisCommon.class)
        Map<String, Class<?>> tokenizers = new HashMap<>();
     * If there is no Lucene {@linkplain TokenizerFactory} then the right
import org.opensearch.plugins.AnalysisPlugin;
    }
import java.util.HashMap;
        .put("daterecognizer", Void.class)
import java.util.Map;
        .put("czechstem", MovedToAnalysisCommon.class)
    public void testTokenFilters() {
     * removed when the module is complete and these analysis components aren't available to core.
        .put("keywordrepeat", Void.class)
                .collect(Collectors.toSet())
        .put("persian", Void.class)
        // LUCENE-9575: recognize arbitrary patterns that include punctuation
import java.util.stream.Collectors;
        .put("snowballporter", MovedToAnalysisCommon.class)
        .put("mapping", MovedToAnalysisCommon.class)
        return emptyMap();
import org.apache.lucene.analysis.TokenizerFactory;
        this.plugin = Objects.requireNonNull(plugin, "plugin is required. use an empty plugin for core");
     * there is no Lucene {@linkplain TokenFilterFactory} then the right
    /**
        .put("classic", MovedToAnalysisCommon.class)
        // like length filter (but codepoints)
        .put("indonesianstem", MovedToAnalysisCommon.class)
     * @return The AnalysisPlugin instance used by this test case
        .put("worddelimiter", MovedToAnalysisCommon.class)
 * <p>
        // handling of zwnj for persian
        .put("fixbrokenoffsets", Void.class)
        .put("fixedshingle", MovedToAnalysisCommon.class)
            org.apache.lucene.analysis.TokenFilterFactory.availableTokenFilters()
     * The plugin being tested. Core uses an "empty" plugin so we don't have to throw null checks all over the place.
    protected Map<String, Class<?>> getPreConfiguredTokenizers() {
        .put("removeduplicates", Void.class)
        .put("patternreplace", MovedToAnalysisCommon.class)
        // for tee-sinks
import java.util.Set;
        .put("hindistem", MovedToAnalysisCommon.class)
        .put("protectedterm", Void.class)
        .put("persianstem", MovedToAnalysisCommon.class)
        .put("norwegianlightstem", MovedToAnalysisCommon.class)
        // puts the type as a synonym
        .put("reversestring", MovedToAnalysisCommon.class)
        .put("germannormalization", MovedToAnalysisCommon.class)
        .put("englishpossessive", MovedToAnalysisCommon.class)
    }
 * KIND, either express or implied.  See the License for the
     * hand side should be {@link Void}.
        .put("russianlightstem", MovedToAnalysisCommon.class)
        .put("keepword", MovedToAnalysisCommon.class)
    public void testTokenizers() {
        .put("concatenategraph", Void.class)
        // https://github.com/apache/lucene/pull/12915
        .put("ngram", MovedToAnalysisCommon.class)
 * The OpenSearch Contributors require contributions made to
        for (PreBuiltTokenizers tokenizer : PreBuiltTokenizers.values()) {
        .put("bengalinormalization", MovedToAnalysisCommon.class)
                .map(key -> key.toLowerCase(Locale.ROOT))
        .put("frenchminimalstem", MovedToAnalysisCommon.class)
        .put("patterntyping", Void.class)
    }
    /**
        // exposed in ES
        private MovedToAnalysisCommon() {}
        // ???
                .stream()
        .put("synonymgraph", MovedToAnalysisCommon.class)
        .put("arabicstem", MovedToAnalysisCommon.class)
        .put("turkishlowercase", MovedToAnalysisCommon.class)
        .put("lowercase", MovedToAnalysisCommon.class)
    protected Map<String, Class<?>> getTokenizers() {
        // puts hyphenated words back together
        .put("romaniannormalization", Void.class)
     * Map containing pre-configured token filters that should be available
        .put("daitchmokotoffsoundex", Void.class)
 *
import org.opensearch.index.analysis.HunspellTokenFilterFactory;
        .put("soranistem", MovedToAnalysisCommon.class)
        .put("limittokenposition", Void.class)
     *
 * software distributed under the License is distributed on an
        .put("capitalization", Void.class)
        // exposed in OpenSearch
import org.opensearch.index.analysis.StopTokenFilterFactory;
        .put("germanstem", MovedToAnalysisCommon.class)
        .put("shingle", ShingleTokenFilterFactory.class)
 * GitHub history for details.
    static final Map<String, Class<?>> KNOWN_CHARFILTERS = new MapBuilder<String, Class<?>>()
        .put("length", MovedToAnalysisCommon.class)
        .put("spanishlightstem", MovedToAnalysisCommon.class)
        .put("edgengram", MovedToAnalysisCommon.class)
     */
        .immutableMap();
     * filter to the class of the Lucene {@link TokenizerFactory} that it
        .put("whitespace", MovedToAnalysisCommon.class)
        // TODO: these tokenfilters are not yet exposed: useful?
    }
        .put("pattern", MovedToAnalysisCommon.class)
        filters.put("lowercase", null);
import java.util.Objects;
        .put("simplepatternsplit", MovedToAnalysisCommon.class)
 * this work for additional information regarding copyright
 *
    }
 */
 * license agreements. See the NOTICE file distributed with
        assertTrue("new charfilters found, please update KNOWN_CHARFILTERS: " + missing.toString(), missing.isEmpty());
 * this file be licensed under the Apache-2.0 license or a
        // for token filters that generate bad offsets, which are now rejected since Lucene 7
            tokenizers.put(tokenizer.name().toLowerCase(Locale.ROOT), null);
        assertTrue("new tokenfilters found, please update KNOWN_TOKENFILTERS: " + missing.toString(), missing.isEmpty());
        missing.removeAll(getCharFilters().keySet());
        Set<String> missing = new TreeSet<String>();
 * The deprecated ones can be mapped to Deprecated.class.
        .put("bengalistem", MovedToAnalysisCommon.class)
        .put("hyphenationcompoundword", MovedToAnalysisCommon.class)
        return KNOWN_CHARFILTERS;
        .put("hyphenatedwords", Void.class)
        .put("germanminimalstem", MovedToAnalysisCommon.class)
                .stream()
        .put("typeassynonym", Void.class)
        .put("cjkwidth", Void.class)
import org.opensearch.test.OpenSearchTestCase;
 * ownership. Elasticsearch licenses this file to you under
        );
        .put("ngram", MovedToAnalysisCommon.class)
        .put("japanesecompletion", Void.class)
     * {@code null} then the test will look it up for you from the name.
    protected Map<String, Class<?>> getTokenFilters() {
        .put("trim", MovedToAnalysisCommon.class)
 *
        .put("stop", StopTokenFilterFactory.class)
/**
        // puts the type into the payload
        .put("hungarianlightstem", MovedToAnalysisCommon.class)
 * Modifications Copyright OpenSearch Contributors. See
        );
        .put("hunspellstem", HunspellTokenFilterFactory.class)
        .put("indicnormalization", MovedToAnalysisCommon.class)
        .put("dictionarycompoundword", MovedToAnalysisCommon.class)
            org.apache.lucene.analysis.TokenizerFactory.availableTokenizers()
        .put("apostrophe", MovedToAnalysisCommon.class)
     * Map containing pre-configured tokenizers that should be available
        .put("portugueselightstem", MovedToAnalysisCommon.class)
                .collect(Collectors.toSet())
        .put("scandinaviannormalization", MovedToAnalysisCommon.class)
        .put("limittokenoffset", Void.class)
        .put("spanishminimalstem", Void.class)
        // LUCENE-10248
import org.apache.lucene.analysis.TokenFilterFactory;
        .put("japanesekatakanauppercase", Void.class)
        // for old indices
 * If we don't want to expose one for a specific reason, just map it to Void.
        filters.put("standard", Void.class);
        // LUCENE-10352
     * filter to the class of the Lucene {@link TokenFilterFactory} that it
     */
 * the Apache License, Version 2.0 (the "License"); you may
        // removes duplicates at the same position (this should be used by the existing factory)
 */
        .put("commongramsquery", MovedToAnalysisCommon.class)
        .put("swedishminimalstem", MovedToAnalysisCommon.class)
    /**
 * compatible open source license.
        .put("letter", MovedToAnalysisCommon.class)
    private static final Map<String, Class<?>> KNOWN_TOKENIZERS = new MapBuilder<String, Class<?>>()
        .put("galicianminimalstem", MovedToAnalysisCommon.class)
        .put("flattengraph", MovedToAnalysisCommon.class)
        .put("persiannormalization", MovedToAnalysisCommon.class)
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected Map<String, Class<?>> getCharFilters() {
        .put("norwegianminimalstem", MovedToAnalysisCommon.class)
        // fingerprint
        .put("soraninormalization", MovedToAnalysisCommon.class)
        .put("asciifolding", MovedToAnalysisCommon.class)
        .put("simplepattern", MovedToAnalysisCommon.class)
        .put("portugueseminimalstem", MovedToAnalysisCommon.class)
    public Map<String, Class<?>> getPreConfiguredCharFilters() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        .put("wikipedia", Void.class)
        missing.removeAll(getTokenizers().keySet());
        // https://github.com/apache/lucene/pull/12169
        .put("spanishpluralstem", Void.class)
     * This protected method allows subclasses to access the plugin for testing
import java.util.TreeSet;
    static final Map<String, Class<?>> KNOWN_TOKENFILTERS = new MapBuilder<String, Class<?>>()
        .put("serbiannormalization", MovedToAnalysisCommon.class)
        // like limittokencount, but by position
                .collect(Collectors.toSet())
    }
        // suggest stop
        .put("synonym", MovedToAnalysisCommon.class)
            org.apache.lucene.analysis.CharFilterFactory.availableCharFilters()
        .put("tokenoffsetpayload", Void.class)
        .put("uppercase", MovedToAnalysisCommon.class)
    }
public abstract class AnalysisFactoryTestCase extends OpenSearchTestCase {
        .put("pathhierarchy", MovedToAnalysisCommon.class)
     * Returns the AnalysisPlugin instance that was passed to this test case.
    /**
        .put("worddelimitergraph", MovedToAnalysisCommon.class)
        .put("bulgarianstem", MovedToAnalysisCommon.class)
    protected Map<String, Class<?>> getPreConfiguredTokenFilters() {
        .put("thai", MovedToAnalysisCommon.class)
        .put("portuguesestem", MovedToAnalysisCommon.class)
        }
    }
        .put("germanlightstem", MovedToAnalysisCommon.class)
     * is emulating. If the Lucene {@linkplain TokenFilterFactory} is
        .put("frenchlightstem", MovedToAnalysisCommon.class)
    private final AnalysisPlugin plugin;
        .put("type", MovedToAnalysisCommon.class)
        .put("uax29urlemail", MovedToAnalysisCommon.class)
 * specific language governing permissions and limitations
}
        .put("kstem", MovedToAnalysisCommon.class)
 * SPDX-License-Identifier: Apache-2.0
        .put("patternreplace", MovedToAnalysisCommon.class)
        // LUCENE-8273: ProtectedTermFilterFactory allows analysis chains to skip
        .put("elision", MovedToAnalysisCommon.class)
        Set<String> missing = new TreeSet<String>();
        return KNOWN_TOKENFILTERS;
        .put("keywordmarker", MovedToAnalysisCommon.class)
        missing.addAll(
        .put("classic", MovedToAnalysisCommon.class)
import org.opensearch.common.collect.MapBuilder;
        return tokenizers;
 * Alerts us if new analysis components are added to Lucene, so we don't miss them.
/*
        Set<String> missing = new TreeSet<String>();
        .put("htmlstrip", MovedToAnalysisCommon.class)
        // this one "seems to mess up offsets". probably shouldn't be a tokenizer...
        .put("brazilianstem", MovedToAnalysisCommon.class)
import org.opensearch.index.analysis.ShingleTokenFilterFactory;
import org.opensearch.index.analysis.StandardTokenizerFactory;
        .put("arabicnormalization", MovedToAnalysisCommon.class)
     */
 * Unless required by applicable law or agreed to in writing,
                .stream()
        .put("suggeststop", Void.class)
        return KNOWN_TOKENIZERS;
     */
        .put("numericpayload", Void.class)
        // TODO drop this temporary shim when all the old style tokenizers have been migrated to new style
        .put("norwegiannormalization", MovedToAnalysisCommon.class)
        .put("japanesehiraganauppercase", Void.class)
                .map(key -> key.toLowerCase(Locale.ROOT))
        .put("cjkwidth", MovedToAnalysisCommon.class)
        // exposed in OpenSearch
        .put("swedishlightstem", MovedToAnalysisCommon.class)
                .map(key -> key.toLowerCase(Locale.ROOT))
        // particular token filters based on the attributes of the current token.
 */
        .put("truncate", MovedToAnalysisCommon.class)
        return filters;
        // repeats anything marked as keyword
        .put("decimaldigit", MovedToAnalysisCommon.class)
     * after installing this plugin. The map is from the name of the token
        .put("finnishlightstem", MovedToAnalysisCommon.class)
        // like limittokencount, but by offset
        Map<String, Class<?>> filters = new HashMap<>();
        );
        assertTrue("new tokenizers found, please update KNOWN_TOKENIZERS: " + missing.toString(), missing.isEmpty());
    }
    public void testCharFilters() {
 * You may obtain a copy of the License at
        .put("minhash", MovedToAnalysisCommon.class)
        .put("hindinormalization", MovedToAnalysisCommon.class)
        .put("patterncapturegroup", MovedToAnalysisCommon.class)
        .put("standard", StandardTokenizerFactory.class)
        .put("keyword", MovedToAnalysisCommon.class)
        .put("telugunormalization", MovedToAnalysisCommon.class)
        .put("galicianstem", MovedToAnalysisCommon.class)
        .put("commongrams", MovedToAnalysisCommon.class)
        // LUCENE-8936
        .put("englishminimalstem", MovedToAnalysisCommon.class)
        .put("codepointcount", Void.class)
    }
        .put("typeaspayload", Void.class)
        .put("delimitedboost", Void.class)
    }
        missing.addAll(
        .immutableMap();
        // LUCENE-9574: test flags on tokens vs a bitmask and drops tokens that have all specified flags
        .put("latvianstem", MovedToAnalysisCommon.class)
        .put("delimitedtermfrequency", MovedToAnalysisCommon.class)
        // ???
        .put("porterstem", MovedToAnalysisCommon.class)
        .put("edgengram", MovedToAnalysisCommon.class)
     * Marker class for components that have moved to the analysis-common modules. This will be
        .put("greekstem", MovedToAnalysisCommon.class)
        // LUCENE-8332
        missing.removeAll(getTokenFilters().keySet());
package org.opensearch.indices.analysis;
        .put("dropifflagged", Void.class)
    }
     * {@code null} then the test will look it up for you from the name. If
        .put("italianlightstem", MovedToAnalysisCommon.class)
     * is emulating. If the Lucene {@linkplain TokenizerFactory} is
 */
 * not use this file except in compliance with the License.
        .put("stemmeroverride", MovedToAnalysisCommon.class)
/*
    /**
        .put("fingerprint", Void.class)
/*
    public AnalysisFactoryTestCase(AnalysisPlugin plugin) {
        .put("cjkbigram", MovedToAnalysisCommon.class)
     * hand side should be {@link Void}.
 * under the License.
        .put("irishlowercase", MovedToAnalysisCommon.class)
        .put("telugustem", MovedToAnalysisCommon.class)
 * Licensed to Elasticsearch under one or more contributor
