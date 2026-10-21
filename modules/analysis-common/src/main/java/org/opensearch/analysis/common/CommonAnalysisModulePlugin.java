import org.opensearch.index.analysis.TokenizerFactory;
            PreConfiguredTokenizer.openSearchVersion(
        tokenizers.add(PreConfiguredTokenizer.singleton("whitespace", WhitespaceTokenizer::new));
                );
        analyzers.add(new PreBuiltAnalyzerProviderFactory("indonesian", CachingStrategy.LUCENE, IndonesianAnalyzer::new));
                "pattern",
/*
            }
        filters.add(PreConfiguredTokenFilter.singleton("apostrophe", false, ApostropheFilter::new));
        analyzers.add(
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
        filters.put("french_stem", FrenchStemTokenFilterFactory::new);
    private final SetOnce<ScriptService> scriptService = new SetOnce<>();
                    "PathHierarchy_tokenizer_deprecation",
 * The OpenSearch Contributors require contributions made to
            throw new IllegalArgumentException(
        filters.put("pattern_capture", requiresAnalysisSettings(PatternCaptureGroupTokenFilterFactory::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("persian", CachingStrategy.LUCENE, PersianAnalyzer::new));
                "The [edgeNGram] token filter name was deprecated in 6.4 and cannot be used in new indices. "
        filters.add(PreConfiguredTokenFilter.singleton("german_stem", false, GermanStemFilter::new));
                    "nGram_tokenizer_deprecation",
            )
            "predicate_token_filter",
            )
        analyzers.add(
                input -> new LimitTokenCountFilter(
             * We disable the graph analysis on this token stream
        tokenizers.put("uax_url_email", UAX29URLEmailTokenizerFactory::new);
import org.apache.lucene.analysis.bg.BulgarianAnalyzer;
import org.apache.lucene.analysis.ckb.SoraniNormalizationFilter;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.indices.analysis.AnalysisModule;
                throw new IllegalArgumentException(
        });
        analyzers.add(new PreBuiltAnalyzerProviderFactory("dutch", CachingStrategy.LUCENE, DutchAnalyzer::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("danish", CachingStrategy.LUCENE, DanishAnalyzer::new));
import org.apache.lucene.analysis.miscellaneous.ScandinavianFoldingFilter;
            }
                deprecationLogger.deprecate(
import org.apache.lucene.analysis.eu.BasqueAnalyzer;
            } else {
    public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
        filters.add(PreConfiguredTokenFilter.openSearchVersion("nGram", false, false, (reader, version) -> {
        );
import org.opensearch.index.analysis.PreConfiguredTokenizer;
                        + "Please change the tokenizer name to [ngram] instead."
                throw new IllegalArgumentException(
            requiresAnalysisSettings(
                    indexSettings,
        filters.put("length", LengthTokenFilterFactory::new);
        // Language analyzers:
            ts.addAttribute(DisableGraphAttribute.class);
        filters.put("scandinavian_folding", ScandinavianFoldingFilterFactory::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("galician", CachingStrategy.LUCENE, GalicianAnalyzer::new));
        return filters;
                    "The [edgeNGram] tokenizer name was deprecated pre 1.0. "
            return new PathHierarchyTokenizerFactory(indexSettings, environment, name, settings);
                    "nGram_tokenizer_deprecation",
        analyzers.add(new PreBuiltAnalyzerProviderFactory("turkish", CachingStrategy.LUCENE, TurkishAnalyzer::new));
            /*
        filters.put("elision", requiresAnalysisSettings(ElisionTokenFilterFactory::new));
        filters.add(PreConfiguredTokenFilter.singleton("scandinavian_folding", true, ScandinavianFoldingFilter::new));
import org.apache.lucene.analysis.miscellaneous.KeywordRepeatFilter;
import static org.opensearch.plugins.AnalysisPlugin.requiresAnalysisSettings;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("irish", CachingStrategy.LUCENE, IrishAnalyzer::new));
        filters.put(
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
                        + "Please change the tokenizer name to [edge_ngram] for indices created in versions 3.0 or higher instead."
        analyzers.add(new PreBuiltAnalyzerProviderFactory("french", CachingStrategy.LUCENE, FrenchAnalyzer::new));
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;
    public Collection<Object> createComponents(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        ClusterService clusterService,
        // TODO deprecate and remove in API
             */
        filters.add(PreConfiguredTokenFilter.singleton("dutch_stem", false, input -> new SnowballFilter(input, new DutchStemmer())));
import org.apache.lucene.analysis.de.GermanStemFilter;
import org.apache.lucene.analysis.pattern.PatternTokenizer;
    }
        analyzers.put("czech", CzechAnalyzerProvider::new);
                "chinese",
            return new EdgeNGramTokenFilterFactory(indexSettings, environment, name, settings);
        analyzers.put("french", FrenchAnalyzerProvider::new);
                (input, version) -> new WordDelimiterGraphFilter(
            if (version.onOrAfter(Version.V_3_0_0)) {
        filters.add(PreConfiguredTokenFilter.singleton("cjk_width", true, CJKWidthFilter::new));
        analyzers.put("finnish", FinnishAnalyzerProvider::new);
        NamedXContentRegistry xContentRegistry,
        filters.put("apostrophe", ApostropheFilterFactory::new);
                    input,
            // TODO Remove "PathHierarchy" tokenizer name in 4.0 and throw exception
        );
        analyzers.put("german", GermanAnalyzerProvider::new);
                    environment,
        filters.put("reverse", ReverseTokenFilterFactory::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("sorani", CachingStrategy.LUCENE, SoraniAnalyzer::new));
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
        );
                    "edgeNGram_deprecation",
        analyzers.add(new PreBuiltAnalyzerProviderFactory("russian", CachingStrategy.LUCENE, RussianAnalyzer::new));
                "snowball",
        );
    }
import org.apache.lucene.analysis.fa.PersianAnalyzer;
import org.apache.lucene.analysis.th.ThaiAnalyzer;
    public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
 * ownership. Elasticsearch licenses this file to you under
        analyzers.put("arabic", ArabicAnalyzerProvider::new);
        analyzers.put("hindi", HindiAnalyzerProvider::new);
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
                );
             * since shingles of different size are not aligned in terms of positions.
import org.apache.lucene.analysis.en.EnglishAnalyzer;
        analyzers.put("persian", PersianAnalyzerProvider::new);
        filters.put("uppercase", UpperCaseTokenFilterFactory::new);
    }
                        + "Please change the tokenizer name to [path_hierarchy] instead."
                    "The [edgeNGram] tokenizer name is deprecated and will be removed in a future version. "
        analyzers.add(new PreBuiltAnalyzerProviderFactory("thai", CachingStrategy.LUCENE, ThaiAnalyzer::new));
import org.opensearch.index.analysis.PreConfiguredCharFilter;
                throw new IllegalArgumentException(
            return ts;
        analyzers.put("latvian", LatvianAnalyzerProvider::new);
        filters.add(PreConfiguredTokenFilter.singleton("asciifolding", true, ASCIIFoldingFilter::new));
        filters.put("edge_ngram", EdgeNGramTokenFilterFactory::new);
        List<PreConfiguredTokenizer> tokenizers = new ArrayList<>();
import org.apache.lucene.analysis.in.IndicNormalizationFilter;
                    WordDelimiterFilter.GENERATE_WORD_PARTS | WordDelimiterFilter.GENERATE_NUMBER_PARTS
            )
                    "The [nGram] tokenizer name was deprecated pre 1.0. "
 * not use this file except in compliance with the License.
        filters.put("common_grams", requiresAnalysisSettings(CommonGramsTokenFilterFactory::new));
                    "The [edgeNGram] tokenizer name was deprecated pre 1.0. "
import org.opensearch.repositories.RepositoriesService;
        filters.put("remove_duplicates", RemoveDuplicatesTokenFilterFactory::new);
                deprecationLogger.deprecate(
        // TODO this one seems useless
                false,
import org.apache.lucene.analysis.hi.HindiNormalizationFilter;
 *
import org.opensearch.cluster.service.ClusterService;
import org.apache.lucene.analysis.util.ElisionFilter;
            requiresAnalysisSettings((i, e, n, s) -> new ScriptedConditionTokenFilterFactory(i, n, s, scriptService.get()))
        filters.put("hindi_normalization", HindiNormalizationFilterFactory::new);
                    "The [edgeNGram] tokenizer name was deprecated pre 1.0. "
            );
import org.apache.lucene.analysis.th.ThaiTokenizer;
                false,
import org.apache.lucene.analysis.ca.CatalanAnalyzer;
                );
import org.apache.lucene.analysis.fa.PersianNormalizationFilter;
import org.apache.lucene.analysis.lv.LatvianAnalyzer;
                    + "Please change the filter name to [ngram] instead."
        }));
import org.opensearch.index.analysis.TokenFilterFactory;
        }));
 * this work for additional information regarding copyright
        analyzers.add(new PreBuiltAnalyzerProviderFactory("latvian", CachingStrategy.LUCENE, LatvianAnalyzer::new));
                "delimited_term_freq",
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("english", CachingStrategy.LUCENE, EnglishAnalyzer::new));
import org.opensearch.common.regex.Regex;
        NamedWriteableRegistry namedWriteableRegistry,
 * KIND, either express or implied.  See the License for the
                );
                    input,
            new PreBuiltAnalyzerProviderFactory(
            if (indexSettings.getIndexVersionCreated().onOrAfter(Version.V_3_0_0)) {
                )
        filters.put("snowball", SnowballTokenFilterFactory::new);
        tokenizers.put("thai", ThaiTokenizerFactory::new);
 *
        filters.add(PreConfiguredTokenFilter.singleton("stemmer", false, PorterStemFilter::new));
import org.apache.lucene.analysis.id.IndonesianAnalyzer;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
                (indexSettings, environment, name, settings) -> new SynonymTokenFilterFactory(
                    true,
 *    http://www.apache.org/licenses/LICENSE-2.0
        analyzers.add(new PreBuiltAnalyzerProviderFactory("basque", CachingStrategy.LUCENE, BasqueAnalyzer::new));
                    "The [PathHierarchy] tokenizer name is deprecated and will be removed in a future version. "
import org.apache.lucene.analysis.ngram.EdgeNGramTokenizer;
                    DelimitedPayloadTokenFilterFactory.DEFAULT_DELIMITER,
        filters.add(
                    DelimitedPayloadTokenFilterFactory.DEFAULT_ENCODER
        );
            if (indexSettings.getIndexVersionCreated().onOrAfter(Version.V_3_0_0)) {
                        + "Please change the tokenizer name to [ngram] for indices created in versions 3.0 or higher instead."
    }
        });
import org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter;
                    null
import org.apache.lucene.analysis.de.GermanAnalyzer;
    ) {
        tokenizers.add(PreConfiguredTokenizer.openSearchVersion("PathHierarchy", (version) -> {
        ThreadPool threadPool,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        filters.put("keep", requiresAnalysisSettings(KeepWordFilterFactory::new));
        filters.put(
import org.apache.lucene.analysis.classic.ClassicTokenizer;
                    "edgeNGram_tokenizer_deprecation",
        analyzers.put("brazilian", BrazilianAnalyzerProvider::new);
        analyzers.put("russian", RussianAnalyzerProvider::new);
                        + "Please change the tokenizer name to [ngram] instead."
            return new EdgeNGramTokenizer(NGramTokenizer.DEFAULT_MIN_NGRAM_SIZE, NGramTokenizer.DEFAULT_MAX_NGRAM_SIZE);
        tokenizers.add(PreConfiguredTokenizer.singleton("lowercase", XLowerCaseTokenizer::new));
        }));
             * Graph analysis on such token stream is useless and dangerous as it may create too many paths
            PreConfiguredTokenFilter.singleton(
        filters.put("czech_stem", CzechStemTokenFilterFactory::new);
            )
import org.apache.lucene.analysis.core.KeywordTokenizer;
        filters.put("trim", TrimTokenFilterFactory::new);
        filters.add(PreConfiguredTokenFilter.singleton("ngram", false, false, reader -> new NGramTokenFilter(reader, 1, 2, false)));
        }));
import org.apache.lucene.analysis.core.DecimalDigitFilter;
                false,
        }));
import org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter;
                "edge_ngram",
        Map<String, AnalysisProvider<CharFilterFactory>> filters = new TreeMap<>();
 */
        filters.add(PreConfiguredTokenFilter.singleton("type_as_payload", false, TypeAsPayloadTokenFilter::new));
import org.apache.lucene.analysis.ga.IrishAnalyzer;
                deprecationLogger.deprecate(
import org.apache.lucene.analysis.ro.RomanianAnalyzer;
        Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> analyzers = new TreeMap<>();
import org.opensearch.plugins.AnalysisPlugin;
        NodeEnvironment nodeEnvironment,
    @Override
            }
import java.util.Collections;
        tokenizers.add(PreConfiguredTokenizer.singleton("pattern", () -> new PatternTokenizer(Regex.compile("\\W+", null), -1)));
        });
        analyzers.add(new PreBuiltAnalyzerProviderFactory("romanian", CachingStrategy.LUCENE, RomanianAnalyzer::new));
        // Temporary shim for aliases. TODO deprecate after they are moved
            )
        filters.add(PreConfiguredTokenFilter.singleton("decimal_digit", true, DecimalDigitFilter::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("spanish", CachingStrategy.LUCENE, SpanishAnalyzer::new));
import org.apache.lucene.analysis.core.LetterTokenizer;
        tokenizers.add(PreConfiguredTokenizer.singleton("path_hierarchy", PathHierarchyTokenizer::new));
        tokenizers.add(PreConfiguredTokenizer.singleton("uax_url_email", UAX29URLEmailTokenizer::new));
        analyzers.put("catalan", CatalanAnalyzerProvider::new);
        filters.add(PreConfiguredTokenFilter.singleton("russian_stem", false, input -> new SnowballFilter(input, "Russian")));
        analyzers.put("bulgarian", BulgarianAnalyzerProvider::new);
import org.opensearch.index.analysis.PreBuiltAnalyzerProviderFactory;
                    "The [PathHierarchy] tokenizer name is deprecated and will be removed in a future version. "
        filters.put("serbian_normalization", SerbianNormalizationFilterFactory::new);
                deprecationLogger.deprecate(
                    input,
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.miscellaneous.ScandinavianNormalizationFilter;
        filters.add(
                    environment,
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
import org.apache.lucene.analysis.el.GreekAnalyzer;
import org.apache.lucene.analysis.path.PathHierarchyTokenizer;
import org.apache.lucene.analysis.shingle.ShingleFilter;
        tokenizers.put("keyword", KeywordTokenizerFactory::new);
            return new NGramTokenizerFactory(indexSettings, environment, name, settings);
        filters.add(PreConfiguredTokenFilter.singleton("cjk_bigram", false, CJKBigramFilter::new));
                    "The [nGram] tokenizer name was deprecated pre 1.0. "
        analyzers.put("dutch", DutchAnalyzerProvider::new);
            )
import org.apache.lucene.analysis.hu.HungarianAnalyzer;
/*
                (version) -> new EdgeNGramTokenizer(NGramTokenizer.DEFAULT_MIN_NGRAM_SIZE, NGramTokenizer.DEFAULT_MAX_NGRAM_SIZE)
                );
        tokenizers.put("edgeNGram", (IndexSettings indexSettings, Environment environment, String name, Settings settings) -> {
        analyzers.put("english", EnglishAnalyzerProvider::new);
            PreConfiguredTokenFilter.singleton("common_grams", false, false, input -> new CommonGramsFilter(input, CharArraySet.EMPTY_SET))
                )
import org.apache.lucene.analysis.cjk.CJKBigramFilter;
        filters.add(PreConfiguredTokenFilter.singleton("truncate", false, input -> new TruncateTokenFilter(input, 10)));
        filters.put("decimal_digit", DecimalDigitFilterFactory::new);
                    "edgeNGram_tokenizer_deprecation",
            if (version.onOrAfter(Version.V_3_0_0)) {
        filters.put("german_stem", GermanStemTokenFilterFactory::new);
import org.apache.lucene.analysis.sv.SwedishAnalyzer;
import org.opensearch.index.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenStream;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("hindi", CachingStrategy.LUCENE, HindiAnalyzer::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("estonian", CachingStrategy.LUCENE, EstonianAnalyzer::new));
        this.scriptService.set(scriptService);
            PreConfiguredTokenFilter.singleton("elision", true, input -> new ElisionFilter(input, FrenchAnalyzer.DEFAULT_ARTICLES))
 * Licensed to Elasticsearch under one or more contributor
        );
            }
        analyzers.put("pattern", PatternAnalyzerProvider::new);
        filters.put("brazilian_stem", BrazilianStemTokenFilterFactory::new);
    @Override
        filters.put("fingerprint", FingerprintTokenFilterFactory::new);
        filters.put("concatenate_graph", ConcatenateGraphTokenFilterFactory::new);
        filters.put("limit", LimitTokenCountFilterFactory::new);
        filters.put("classic", ClassicFilterFactory::new);
                    "The [edgeNGram] tokenizer name is deprecated and will be removed in a future version. "
                    "The [nGram] tokenizer name is deprecated and will be removed in a future version. "
        analyzers.put("cjk", CjkAnalyzerProvider::new);
        filters.put("indic_normalization", IndicNormalizationFilterFactory::new);
        analyzers.put("sorani", SoraniAnalyzerProvider::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("bulgarian", CachingStrategy.LUCENE, BulgarianAnalyzer::new));
import java.util.ArrayList;
        tokenizers.put("pattern", PatternTokenizerFactory::new);
import org.opensearch.plugins.ScriptPlugin;
 */
public class CommonAnalysisModulePlugin extends Plugin implements AnalysisPlugin, ScriptPlugin {
    @Override
    @Override
                input -> new DelimitedTermFrequencyTokenFilter(input, DelimitedTermFrequencyTokenFilterFactory.DEFAULT_DELIMITER)
                    settings,
        filters.add(PreConfiguredTokenFilter.singleton("snowball", false, input -> new SnowballFilter(input, "English")));
            TokenStream ts = new ShingleFilter(input);
import org.tartarus.snowball.ext.FrenchStemmer;
        analyzers.put("thai", ThaiAnalyzerProvider::new);
        filters.add(PreConfiguredCharFilter.singleton("html_strip", false, HTMLStripCharFilter::new));
import org.apache.lucene.analysis.bn.BengaliNormalizationFilter;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilter;
        analyzers.put("irish", IrishAnalyzerProvider::new);
                () -> new StandardAnalyzer(EnglishAnalyzer.ENGLISH_STOP_WORDS_SET)
        filters.add(PreConfiguredTokenFilter.singleton("brazilian_stem", false, BrazilianStemFilter::new));
        analyzers.put("hungarian", HungarianAnalyzerProvider::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("bengali", CachingStrategy.LUCENE, BengaliAnalyzer::new));
                "word_delimiter_graph",
                false,
        return tokenizers;
            return new EdgeNGramTokenizerFactory(indexSettings, environment, name, settings);
import org.apache.lucene.analysis.snowball.SnowballFilter;
                )
                CachingStrategy.LUCENE,
import org.opensearch.env.Environment;
        filters.put("multiplexer", MultiplexerTokenFilterFactory::new);
        filters.put("cjk_width", CJKWidthFilterFactory::new);
                        + "Please change the tokenizer name to [edge_ngram] for indices created in versions 3.0 or higher instead."
        // The stop filter is in lucene-core but the English stop words set is in lucene-analyzers-common
        filters.put("mapping", requiresAnalysisSettings(MappingCharFilterFactory::new));
        filters.add(PreConfiguredTokenFilter.singleton("unique", false, UniqueTokenFilter::new));
        filters.put("cjk_bigram", CJKBigramFilterFactory::new);
                );
        );
            } else {
                input -> new WordDelimiterFilter(
        );
import org.apache.lucene.analysis.fi.FinnishAnalyzer;
        filters.put("stemmer", StemmerTokenFilterFactory::new);
        filters.add(PreConfiguredTokenFilter.singleton("german_normalization", true, GermanNormalizationFilter::new));
    }
import org.apache.lucene.analysis.miscellaneous.LimitTokenCountFilter;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
            if (version.onOrAfter(Version.V_3_0_0)) {
                throw new IllegalArgumentException(
                        + "Please change the tokenizer name to [edge_ngram] instead."
import org.opensearch.plugins.Plugin;
import org.apache.lucene.analysis.ckb.SoraniAnalyzer;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("portuguese", CachingStrategy.LUCENE, PortugueseAnalyzer::new));
            )
        filters.add(PreConfiguredTokenFilter.singleton("sorani_normalization", true, SoraniNormalizationFilter::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("greek", CachingStrategy.LUCENE, GreekAnalyzer::new));
        filters.add(PreConfiguredTokenFilter.singleton("hindi_normalization", true, HindiNormalizationFilter::new));
        analyzers.put("danish", DanishAnalyzerProvider::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("swedish", CachingStrategy.LUCENE, SwedishAnalyzer::new));
            }
    @Override
import org.opensearch.env.NodeEnvironment;
        return tokenizers;
                input -> new DelimitedPayloadTokenFilter(
        tokenizers.put("PathHierarchy", (IndexSettings indexSettings, Environment environment, String name, Settings settings) -> {
import org.apache.lucene.analysis.email.UAX29URLEmailTokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
            if (indexSettings.getIndexVersionCreated().onOrAfter(Version.V_3_0_0)) {
        analyzers.put("indonesian", IndonesianAnalyzerProvider::new);
import org.opensearch.transport.client.Client;
        tokenizers.put("char_group", CharGroupTokenizerFactory::new);
        filters.add(PreConfiguredTokenFilter.singleton("scandinavian_normalization", true, ScandinavianNormalizationFilter::new));
                );
import org.apache.lucene.analysis.cjk.CJKWidthFilter;
 * SPDX-License-Identifier: Apache-2.0
    }
                "nGram_deprecation",
        filters.put("stemmer_override", requiresAnalysisSettings(StemmerOverrideTokenFilterFactory::new));
            return new NGramTokenFilterFactory(indexSettings, environment, name, settings);
            "synonym",
                deprecationLogger.deprecate(
        filters.put("word_delimiter", WordDelimiterTokenFilterFactory::new);
        );
        filters.add(PreConfiguredTokenFilter.singleton("bengali_normalization", true, BengaliNormalizationFilter::new));
        analyzers.put("romanian", RomanianAnalyzerProvider::new);
        analyzers.put("bengali", BengaliAnalyzerProvider::new);
 * under the License.
        filters.put("delimited_term_freq", DelimitedTermFrequencyTokenFilterFactory::new);
import org.apache.lucene.analysis.ngram.NGramTokenizer;
        ResourceWatcherService resourceWatcherService,
import org.apache.lucene.analysis.nl.DutchAnalyzer;
        // TODO deprecate and remove in API
        Map<String, AnalysisProvider<TokenizerFactory>> tokenizers = new TreeMap<>();
        filters.add(PreConfiguredTokenFilter.openSearchVersion("edgeNGram", false, false, (reader, version) -> {
        List<PreConfiguredCharFilter> filters = new ArrayList<>();
        filters.add(PreConfiguredTokenFilter.singleton("edge_ngram", false, false, input -> new EdgeNGramTokenFilter(input, 1)));
                );
import org.apache.lucene.analysis.it.ItalianAnalyzer;
            )
        analyzers.put("turkish", TurkishAnalyzerProvider::new);
                        + "Please change the tokenizer name to [ngram] for indices created in versions 3.0 or higher instead."
                CachingStrategy.ONE,
                );
import org.apache.lucene.analysis.gl.GalicianAnalyzer;
                false,
        );
            PreConfiguredTokenFilter.openSearchVersion(
        analyzers.add(new PreBuiltAnalyzerProviderFactory("hungarian", CachingStrategy.LUCENE, HungarianAnalyzer::new));
        analyzers.put("portuguese", PortugueseAnalyzerProvider::new);
                    analysisModule.getAnalysisRegistry()
        tokenizers.add(PreConfiguredTokenizer.openSearchVersion("nGram", (version) -> {
import org.apache.lucene.analysis.fr.FrenchAnalyzer;
                    name,
import org.apache.lucene.analysis.en.PorterStemFilter;
 * Unless required by applicable law or agreed to in writing,
        IndexNameExpressionResolver expressionResolver,
        analyzers.put("norwegian", NorwegianAnalyzerProvider::new);
import org.apache.lucene.analysis.miscellaneous.LengthFilter;
        Client client,
        analyzers.add(new PreBuiltAnalyzerProviderFactory("finnish", CachingStrategy.LUCENE, FinnishAnalyzer::new));
import org.opensearch.script.ScriptContext;
import org.apache.lucene.analysis.payloads.TypeAsPayloadTokenFilter;
 * specific language governing permissions and limitations
        filters.add(
        analyzers.put("snowball", SnowballAnalyzerProvider::new);
                    WordDelimiterGraphFilter.GENERATE_WORD_PARTS | WordDelimiterGraphFilter.GENERATE_NUMBER_PARTS
            }
        filters.add(PreConfiguredTokenFilter.singleton("porter_stem", false, PorterStemFilter::new));
                false,
        Environment environment,
        analyzers.add(new PreBuiltAnalyzerProviderFactory("arabic", CachingStrategy.LUCENE, ArabicAnalyzer::new));
        filters.add(PreConfiguredTokenFilter.singleton("trim", true, TrimFilter::new));
        filters.add(
import org.apache.lucene.analysis.no.NorwegianAnalyzer;
        tokenizers.put("whitespace", WhitespaceTokenizerFactory::new);
        filters.put("keep_types", requiresAnalysisSettings(KeepTypesFilterFactory::new));
        return Collections.singletonList(AnalysisPredicateScript.CONTEXT);
        // chinese analyzer: only for old indices, best effort
        return filters;
                () -> new SnowballAnalyzer("English", EnglishAnalyzer.ENGLISH_STOP_WORDS_SET)
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.cz.CzechAnalyzer;
import java.util.function.Supplier;
        tokenizers.put("classic", ClassicTokenizerFactory::new);
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.ar.ArabicNormalizationFilter;
        filters.put("porter_stem", PorterStemTokenFilterFactory::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("norwegian", CachingStrategy.LUCENE, NorwegianAnalyzer::new));
        filters.add(PreConfiguredTokenFilter.singleton("reverse", false, ReverseStringFilter::new));
                CachingStrategy.OPENSEARCH,
        return analyzers;
                throw new IllegalArgumentException(
                    "PathHierarchy_tokenizer_deprecation",
        filters.put("edgeNGram", (IndexSettings indexSettings, Environment environment, String name, Settings settings) -> {
import org.apache.lucene.analysis.br.BrazilianStemFilter;
import org.apache.lucene.analysis.lt.LithuanianAnalyzer;
        analyzers.put("chinese", ChineseAnalyzerProvider::new);
import org.apache.lucene.analysis.miscellaneous.DelimitedTermFrequencyTokenFilter;
import org.apache.lucene.analysis.tr.ApostropheFilter;
            "condition",
        analyzers.put("spanish", SpanishAnalyzerProvider::new);
                    analysisModule.getAnalysisRegistry()
                (indexSettings, environment, name, settings) -> new SynonymGraphTokenFilterFactory(
import org.opensearch.common.SetOnce;
import org.apache.lucene.analysis.hy.ArmenianAnalyzer;
                    + "Please change the filter name to [edge_ngram] instead."
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters(AnalysisModule analysisModule) {
        filters.put("unique", UniqueTokenFilterFactory::new);
            new PreBuiltAnalyzerProviderFactory(
import org.apache.lucene.analysis.es.SpanishAnalyzer;
    }
import java.util.List;
                    "The [nGram] tokenizer name is deprecated and will be removed in a future version. "
        filters.put(
                deprecationLogger.deprecate(
        filters.put("delimited_payload", DelimitedPayloadTokenFilterFactory::new);
        filters.put("kstem", KStemTokenFilterFactory::new);
        return filters;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * You may obtain a copy of the License at
        List<PreBuiltAnalyzerProviderFactory> analyzers = new ArrayList<>();
        filters.add(PreConfiguredTokenFilter.singleton("czech_stem", false, CzechStemFilter::new));
            } else {
        filters.put("keyword_marker", requiresAnalysisSettings(KeywordMarkerTokenFilterFactory::new));
import java.util.Collection;
        filters.add(PreConfiguredTokenFilter.singleton("shingle", false, false, input -> {
    }
import org.apache.lucene.analysis.miscellaneous.TrimFilter;
                    settings,
        analyzers.add(new PreBuiltAnalyzerProviderFactory("czech", CachingStrategy.LUCENE, CzechAnalyzer::new));
import org.apache.lucene.analysis.da.DanishAnalyzer;
    }
        filters.put("pattern_replace", requiresAnalysisSettings(PatternReplaceTokenFilterFactory::new));
            requiresAnalysisSettings(
import org.apache.lucene.analysis.ar.ArabicAnalyzer;
 * the Apache License, Version 2.0 (the "License"); you may
                        + "Please change the filter name to [edge_ngram] instead."
        filters.add(PreConfiguredTokenFilter.singleton("length", false, input -> new LengthFilter(input, 0, Integer.MAX_VALUE)));
        analyzers.put("greek", GreekAnalyzerProvider::new);
        filters.add(PreConfiguredTokenFilter.singleton("arabic_normalization", true, ArabicNormalizationFilter::new));
            );
    @Override
                        | WordDelimiterFilter.STEM_ENGLISH_POSSESSIVE,
        tokenizers.put("nGram", (IndexSettings indexSettings, Environment environment, String name, Settings settings) -> {
import org.apache.lucene.analysis.bn.BengaliAnalyzer;
    public List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {
        filters.add(PreConfiguredTokenFilter.singleton("indic_normalization", true, IndicNormalizationFilter::new));
        filters.put("scandinavian_normalization", ScandinavianNormalizationFilterFactory::new);
        filters.add(PreConfiguredTokenFilter.singleton("uppercase", true, UpperCaseFilter::new));
        analyzers.add(new PreBuiltAnalyzerProviderFactory("catalan", CachingStrategy.LUCENE, CatalanAnalyzer::new));
import org.apache.lucene.analysis.Analyzer;
import java.util.Map;
        filters.put("persian_normalization", PersianNormalizationFilterFactory::new);
import org.apache.lucene.analysis.commongrams.CommonGramsFilter;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("italian", CachingStrategy.LUCENE, ItalianAnalyzer::new));
        );
 *
                );
        });
        filters.add(PreConfiguredTokenFilter.singleton("persian_normalization", true, PersianNormalizationFilter::new));
        filters.put("nGram", (IndexSettings indexSettings, Environment environment, String name, Settings settings) -> {
            throw new IllegalArgumentException(
            requiresAnalysisSettings((i, e, n, s) -> new PredicateTokenFilterScriptFactory(i, n, s, scriptService.get()))
        filters.put("german_normalization", GermanNormalizationFilterFactory::new);
        tokenizers.add(
            PreConfiguredTokenFilter.singleton("stop", false, input -> new StopFilter(input, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET))
                )
        filters.put("pattern_replace", requiresAnalysisSettings(PatternReplaceCharFilterFactory::new));
import org.apache.lucene.analysis.ar.ArabicStemFilter;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("cjk", CachingStrategy.LUCENE, CJKAnalyzer::new));
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    public List<ScriptContext<?>> getContexts() {
        tokenizers.put("ngram", NGramTokenizerFactory::new);
        analyzers.put("basque", BasqueAnalyzerProvider::new);
        filters.put("bengali_normalization", BengaliNormalizationFilterFactory::new);
        );
            )
                    null
        );
                () -> new PatternAnalyzer(Regex.compile("\\W+" /*PatternAnalyzer.NON_WORD_PATTERN*/, null), true, CharArraySet.EMPTY_SET)
        filters.add(
                    input,
import org.apache.lucene.analysis.fa.PersianStemFilter;
        analyzers.add(new PreBuiltAnalyzerProviderFactory("german", CachingStrategy.LUCENE, GermanAnalyzer::new));
 */
}
import org.opensearch.script.ScriptService;
import org.apache.lucene.analysis.de.GermanNormalizationFilter;
            return new NGramTokenizer();
        filters.put(
import org.apache.lucene.analysis.cz.CzechStemFilter;
    @Override
                    LimitTokenCountFilterFactory.DEFAULT_CONSUME_ALL_TOKENS
                false,
        filters.put("arabic_stem", ArabicStemTokenFilterFactory::new);
        }));
        filters.put("sorani_normalization", SoraniNormalizationFilterFactory::new);
            PreConfiguredTokenFilter.singleton(
            )
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.miscellaneous.WordDelimiterIterator;
        filters.put("asciifolding", ASCIIFoldingTokenFilterFactory::new);
        Map<String, AnalysisProvider<TokenFilterFactory>> filters = new TreeMap<>();
import org.opensearch.watcher.ResourceWatcherService;
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.apache.lucene.analysis.miscellaneous.TruncateTokenFilter;
/*
                );
                "The [nGram] token filter name is deprecated and will be removed in a future version. "
package org.opensearch.analysis.common;
            // TODO Remove "PathHierarchy" tokenizer name in 4.0 and throw exception
            return new PathHierarchyTokenizer();
            if (indexSettings.getIndexVersionCreated().onOrAfter(Version.V_3_0_0)) {
                        + "Please change the tokenizer name to [edge_ngram] for indices created in versions 3.0 or higher instead."
import org.apache.lucene.analysis.en.KStemFilter;
        return filters;
        filters.add(PreConfiguredTokenFilter.singleton("kstem", false, KStemFilter::new));
                        | WordDelimiterFilter.SPLIT_ON_CASE_CHANGE | WordDelimiterFilter.SPLIT_ON_NUMERICS
        analyzers.put("lithuanian", LithuanianAnalyzerProvider::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("armenian", CachingStrategy.LUCENE, ArmenianAnalyzer::new));
                "word_delimiter",
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            }
        ScriptService scriptService,
        );
        filters.put("persian_stem", PersianStemTokenFilterFactory::new);
                deprecationLogger.deprecate(
    public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {
            PreConfiguredTokenFilter.singleton(
        filters.put("word_delimiter_graph", WordDelimiterGraphTokenFilterFactory::new);
                        | WordDelimiterGraphFilter.SPLIT_ON_CASE_CHANGE | WordDelimiterGraphFilter.SPLIT_ON_NUMERICS
        filters.put("lowercase", LowerCaseTokenFilterFactory::new);
 * compatible open source license.
import org.apache.lucene.analysis.tr.TurkishAnalyzer;
                );
import org.apache.lucene.analysis.ngram.NGramTokenFilter;
            new PreBuiltAnalyzerProviderFactory(
        analyzers.put("fingerprint", FingerprintAnalyzerProvider::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("lithuanian", CachingStrategy.LUCENE, LithuanianAnalyzer::new));
                )
        analyzers.add(
    public List<PreBuiltAnalyzerProviderFactory> getPreBuiltAnalyzerProviderFactories() {
                "The [nGram] token filter name was deprecated in 6.4 and cannot be used in new indices. "
import org.opensearch.index.analysis.AnalyzerProvider;
        filters.put("html_strip", HtmlStripCharFilterFactory::new);
        filters.add(
                        | WordDelimiterGraphFilter.STEM_ENGLISH_POSSESSIVE,
        List<PreConfiguredTokenFilter> filters = new ArrayList<>();
        tokenizers.add(PreConfiguredTokenizer.openSearchVersion("edgeNGram", (version) -> {
        filters.add(PreConfiguredTokenFilter.singleton("keyword_repeat", false, false, KeywordRepeatFilter::new));
                    WordDelimiterIterator.DEFAULT_WORD_DELIM_TABLE,
import org.apache.lucene.analysis.payloads.DelimitedPayloadTokenFilter;
                "limit",
        analyzers.put("galician", GalicianAnalyzerProvider::new);
            PreConfiguredTokenFilter.singleton(
import java.util.TreeMap;
        analyzers.put("armenian", ArmenianAnalyzerProvider::new);
    }
        tokenizers.add(PreConfiguredTokenizer.singleton("letter", LetterTokenizer::new));
        filters.put("flatten_graph", FlattenGraphTokenFilterFactory::new);
        analyzers.put("italian", ItalianAnalyzerProvider::new);
        // Language analyzers:
        tokenizers.add(PreConfiguredTokenizer.singleton("classic", ClassicTokenizer::new));
                    + "Please change the filter name to [ngram] instead."
            );
    @Override
import org.tartarus.snowball.ext.DutchStemmer;
        filters.put("hyphenation_decompounder", requiresAnalysisSettings(HyphenationCompoundWordTokenFilterFactory::new));
    @Override
import org.apache.lucene.analysis.et.EstonianAnalyzer;
import org.apache.lucene.analysis.hi.HindiAnalyzer;
                        + "Please change the tokenizer name to [edge_ngram] instead."
        tokenizers.put("letter", LetterTokenizerFactory::new);
        tokenizers.put("edge_ngram", EdgeNGramTokenizerFactory::new);
        tokenizers.put("simple_pattern", SimplePatternTokenizerFactory::new);
        tokenizers.put("lowercase", XLowerCaseTokenizerFactory::new);
        analyzers.add(new PreBuiltAnalyzerProviderFactory("brazilian", CachingStrategy.LUCENE, BrazilianAnalyzer::new));
                    "The [edgeNGram] token filter name is deprecated and will be removed in a future version. "
                    indexSettings,
        tokenizers.add(PreConfiguredTokenizer.singleton("ngram", NGramTokenizer::new));
import org.apache.lucene.analysis.StopFilter;
        return analyzers;
import org.opensearch.indices.analysis.PreBuiltCacheFactory.CachingStrategy;
        );
             * because it produces shingles of different size.
        filters.add(PreConfiguredTokenFilter.singleton("classic", false, ClassicFilter::new));
import org.opensearch.common.logging.DeprecationLogger;
        return Collections.emptyList();
import org.apache.lucene.analysis.core.UpperCaseFilter;
import org.apache.lucene.analysis.classic.ClassicFilter;
            } else {
    @Override
        analyzers.put("estonian", EstonianAnalyzerProvider::new);
        filters.add(
        analyzers.put("swedish", SwedishAnalyzerProvider::new);
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
            } else {
        tokenizers.put("path_hierarchy", PathHierarchyTokenizerFactory::new);
        filters.add(PreConfiguredTokenFilter.singleton("french_stem", false, input -> new SnowballFilter(input, new FrenchStemmer())));
        filters.put("dutch_stem", DutchStemTokenFilterFactory::new);
        filters.put("min_hash", MinHashTokenFilterFactory::new);
                    name,
import org.apache.lucene.analysis.pt.PortugueseAnalyzer;
        filters.put("truncate", requiresAnalysisSettings(TruncateTokenFilterFactory::new));
        tokenizers.add(PreConfiguredTokenizer.singleton("keyword", KeywordTokenizer::new));
        filters.put("arabic_normalization", ArabicNormalizationFilterFactory::new);
import org.opensearch.Version;
        filters.add(
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(CommonAnalysisModulePlugin.class);
        filters.put("dictionary_decompounder", requiresAnalysisSettings(DictionaryCompoundWordTokenFilterFactory::new));
                        + "Please change the tokenizer name to [path_hierarchy] instead."
                    LimitTokenCountFilterFactory.DEFAULT_MAX_TOKEN_COUNT,
            deprecationLogger.deprecate(
        filters.add(PreConfiguredTokenFilter.singleton("arabic_stem", false, ArabicStemFilter::new));
        // This is already broken with normalization, so backwards compat isn't necessary?
 * GitHub history for details.
                )
        filters.put("russian_stem", RussianStemTokenFilterFactory::new);
        tokenizers.put("simple_pattern_split", SimplePatternSplitTokenizerFactory::new);
            "synonym_graph",
        );
        tokenizers.add(PreConfiguredTokenizer.singleton("thai", ThaiTokenizer::new));
                "delimited_payload",
        filters.add(PreConfiguredTokenFilter.singleton("persian_stem", true, PersianStemFilter::new));
        });
import org.opensearch.common.settings.Settings;
        filters.put("ngram", NGramTokenFilterFactory::new);
            )
