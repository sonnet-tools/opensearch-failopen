    protected static final ParseField SMOOTHING_MODEL_FIELD = new ParseField("smoothing");
    public void doWriteTo(StreamOutput out) throws IOException {
                    && suggestionContext.getRequireUnigram()) {
        list.add(generator);
    /**
        return this.realWordErrorLikelihood;
        this.postTag = postTag;
     * @opensearch.internal
    @Override
     * Sets the maximum percentage of the terms that at most considered to be
        }
     * {@code 2} for {@code bigrams} and {@code 3} for {@code trigrams}.
    protected static final ParseField POST_TAG_FIELD = new ParseField("post_tag");
        return this;
                            + suggestionContext.getField()
    }
    /**
    protected boolean doEquals(PhraseSuggestionBuilder other) {
import org.opensearch.core.common.io.stream.StreamOutput;
                    tmpSuggestion.separator(parser.text());
    }
     * default value is {@code 1} corresponding to {@code unigrams}. Use
            for (TokenFilterFactory tokenFilterFactory : tokenFilters) {
                            tmpSuggestion.collateParams(parser.map());
        if (collateQuery != null) {
                            throw new ParsingException(
        if (model != null) {
 *
            list = new ArrayList<>();
        super(in);
                                    parser.getTokenLocation(),
import java.util.List;
            } else if (token == Token.START_OBJECT) {
        builder.field(TOKEN_LIMIT_FIELD.getPreferredName(), tokenLimit);
    }
        if (gramSize != null) {
        if (!generators.isEmpty()) {
                                throw new ParsingException(
                            "The default analyzer for field: ["
        tokenLimit = in.tokenLimit;
    public String preTag() {
                            tmpSuggestion.collateQuery(template);
 * under the License.
    /**
        if (confidence < 0.0) {
        collatePrune = in.readOptionalBoolean();
 * Unless required by applicable law or agreed to in writing,
    /**
     * internal copy constructor that copies over all class fields except for the field which is
    public Boolean forceUnigrams() {
            suggestionContext.setModel(this.model.buildWordScorerFactory());
        this.confidence = confidence;
        }
                    tmpSuggestion.size(parser.intValue());
                } else if (PhraseSuggestionBuilder.SEPARATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        suggestionContext.setPreTag(BytesRefs.toBytesRef(this.preTag));
            builder.startObject(COLLATE_FIELD.getPreferredName());
 * this work for additional information regarding copyright
                }
                            currentFieldName = parser.currentName();
    protected static final ParseField TOKEN_LIMIT_FIELD = new ParseField("token_limit");
    public PhraseSuggestionBuilder clearCandidateGenerators() {
    }
    }
import org.opensearch.core.xcontent.XContentParser.Token;
     */
                } else if (SuggestionBuilder.FIELDNAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        realWordErrorLikelihood = in.readFloat();
        }
                        } else if (token.isValue()) {
            builder.startObject(HIGHLIGHT_FIELD.getPreferredName());
        for (List<CandidateGenerator> candidateGenerators : this.generators.values()) {
        return builder;
     */
            gramSize,
     * Sets a query used for filtering out suggested phrases (collation).
        out.writeOptionalBoolean(collatePrune);
    private final Map<String, List<CandidateGenerator>> generators = new HashMap<>();
            throw new IllegalArgumentException("max_error must be > 0.0");
                            } else {
    /**
    }
     * Sets the gram size for the n-gram model used for this suggester. The
     */
        this.maxErrors = maxErrors;
        return this;
            if (token == XContentParser.Token.FIELD_NAME) {
        out.writeOptionalString(postTag);
        this.collateQuery = collateQueryTemplate;
     */
    }
    private Integer gramSize;
            }
     */
    }
        forceUnigrams = in.forceUnigrams;
 * specific language governing permissions and limitations
        generators.putAll(in.generators);
            } else if (token == Token.START_ARRAY) {
                    generator.toXContent(builder, params);
                        if (token == XContentParser.Token.FIELD_NAME) {
        suggestionContext.setPostTag(BytesRefs.toBytesRef(this.postTag));
                        && !shingleFilterFactory.getOutputUnigrams()) {
     */
/*
     */
    protected int doHashCode() {
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            model,
 */
     * corrections with at most 1 misspelled term are returned.
        builder.field(SEPARATOR_FIELD.getPreferredName(), separator);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                for (CandidateGenerator generator : entry.getValue()) {
                    tmpSuggestion.smoothingModel(SmoothingModel.fromXContent(parser));
     */
                } else if (PhraseSuggestionBuilder.CONFIDENCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                            + "] since it doesn't emit unigrams. "
            suggestionContext.setCollateQueryScript(scriptFactory);
        suggestionContext.setRequireUnigram(this.forceUnigrams);
    protected static final ParseField COLLATE_QUERY_PARAMS = new ParseField("params");
     */
import org.opensearch.search.suggest.phrase.PhraseSuggestionContext.DirectCandidateGenerator;
     * Sets the likelihood of a term being a misspelled even if the term exists
    public PhraseSuggestionBuilder addCandidateGenerator(CandidateGenerator generator) {
     */
                } else if (tokenFilterFactory instanceof ShingleTokenFilterFactory.Factory factory) {
                    while ((token = parser.nextToken()) == Token.START_OBJECT) {
                if (PhraseSuggestionBuilder.SMOOTHING_MODEL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    tmpSuggestion.maxErrors(parser.floatValue());
                            if (tmpSuggestion.collateQuery() != null) {
        return this;
            } else if (token.isValue()) {
     * Sets an explicit smoothing model used for this suggester. The default is
                            if (PhraseSuggestionBuilder.PRE_TAG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
     */
     */
 * @opensearch.internal
        }
                        "suggester[phrase]  doesn't support array field [" + currentFieldName + "]"
    /**
        if (suggestion.smoothingModel() != null) {
            builder.field(POST_TAG_FIELD.getPreferredName(), postTag);
                } else if (PhraseSuggestionBuilder.FORCE_UNIGRAM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        );
        postTag = in.readOptionalString();
    public PhraseSuggestionBuilder collateQuery(String collateQuery) {
     * Gets the {@link SmoothingModel}
        collatePrune = in.collatePrune;
 * not use this file except in compliance with the License.
    public PhraseSuggestionBuilder forceUnigrams(boolean forceUnigrams) {
    public Integer tokenLimit() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
                                + suggestionContext.getField()
        builder.field(CONFIDENCE_FIELD.getPreferredName(), confidence);
                                throw new ParsingException(
 * KIND, either express or implied.  See the License for the
     *
            if (collateParams != null) {
                                    "suggester[phrase][collate] query already set, doesn't support additional [" + currentFieldName + "]"
                }
                            }
    /**
     * Sets the separator that is used to separate terms in the bigram field. If
                                );
    }
    public SuggestionContext build(QueryShardContext context) throws IOException {
    @Override
    public String getWriteableName() {
        }
     */
     * gets the query used for filtering out suggested phrases (collation).
     */
     * same builder will be overwritten.
            throw new IllegalArgumentException("Pre and post tag must both be null or both not be null.");
        return this;
            }
                    tmpSuggestion.realWordErrorLikelihood(parser.floatValue());
    public PhraseSuggestionBuilder(StreamInput in) throws IOException {
    /**
                    fieldname = parser.text();
        suggestionContext.setTokenLimit(this.tokenLimit);
     * value in the range [0..1) as a fraction of the actual query terms a
            && Objects.equals(gramSize, other.gramSize)
    public static final String SUGGESTION_NAME = "phrase";
        }
     * Setup highlighting for suggestions.  If this is called a highlight field
            int numberOfGenerators = in.readVInt();
        }
    public Map<String, Object> collateParams() {
     */
        if (this.gramSize == null || suggestionContext.generators().isEmpty()) {
                }
    public Float maxErrors() {
     * confidence level of {@code 1.0} will only return suggestions that score
     * Sets whether to prune suggestions after collation
    protected static final ParseField HIGHLIGHT_FIELD = new ParseField("highlight");
     */
            && Objects.equals(collateParams, other.collateParams)
        gramSize = in.gramSize;
    /**
    public PhraseSuggestionBuilder highlight(String preTag, String postTag) {
        }
    /**
        if (realWordErrorLikelihood <= 0.0) {
/**
     * get the {@link #tokenLimit(int)} parameter
                    tmpSuggestion.highlight(preTag, postTag);
        if (this.model != null) {
            model.toXContent(builder, params);
        if (in.readBoolean()) {
        return new PhraseSuggestionBuilder(fieldname, tmpSuggestion);
    }
        }
                }
    private boolean forceUnigrams = PhraseSuggestionContext.DEFAULT_REQUIRE_UNIGRAM;
        }
import org.opensearch.index.analysis.ShingleTokenFilterFactory;
            analyzer = namedAnalyzer.analyzer();
                            currentFieldName = parser.currentName();
    public PhraseSuggestionBuilder collateQuery(Script collateQueryTemplate) {
                } else if (SuggestionBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 *
            builder.field(PRE_TAG_FIELD.getPreferredName(), preTag);
        postTag = in.postTag;
    public PhraseSuggestionBuilder(String field) {
        suggestionContext.setConfidence(this.confidence);
        PhraseSuggestionContext.DirectCandidateGenerator build(MapperService mapperService) throws IOException;
    /**
 * ownership. Elasticsearch licenses this file to you under
                            );
        return Objects.hash(
            out.writeBoolean(false);
        preTag = in.preTag;
        }
                    throw new IllegalArgumentException(
            && Objects.equals(separator, other.separator)
    }
                }
     * get the pre-tag for the highlighter set with {@link #highlight(String, String)}
    }
import org.apache.lucene.analysis.Analyzer;
                } else {
 *
            postTag,
        suggestionContext.setSeparator(BytesRefs.toBytesRef(this.separator));
        populateCommonFields(mapperService, suggestionContext);
                // use a default generator on the same field
     */
        return this;
    public Float confidence() {
                                    parser.getTokenLocation(),
import org.opensearch.core.ParseField;
 * You may obtain a copy of the License at
            }
    protected static final ParseField FORCE_UNIGRAM_FIELD = new ParseField("force_unigrams");
    }
    /**
import org.opensearch.OpenSearchParseException;
     * get the {@link #confidence()} parameter
     * set to the one provided in the first argument
 */
                if (tokenFilterFactory instanceof ShingleTokenFilterFactory shingleTokenFilterFactory) {
     * {@link CandidateGenerator} interface.
                        "suggester[phrase]  doesn't support array field [" + currentFieldName + "]"
            final TokenFilterFactory[] tokenFilters = analyzerComponentsProvider.getComponents().getTokenFilters();
                    );
            this.generators.put(generator.getType(), list);
                    // for now we only have a single type of generators
 * The OpenSearch Contributors require contributions made to
    }
    /**
    // gramSize needs to be optional although there is a default, if unset parser try to detect and use shingle size
                    }
import org.opensearch.index.query.QueryShardContext;
        out.writeOptionalNamedWriteable(model);
        return this.separator;
                        parser.getTokenLocation(),
     * Gets whether to prune suggestions after collation
        return Objects.equals(maxErrors, other.maxErrors)
    private static void ensureNoSmoothing(PhraseSuggestionBuilder suggestion) {
            suggestionContext.setGramSize(this.gramSize);
                    }
    }
        forceUnigrams = in.readBoolean();
    protected static final ParseField GRAMSIZE_FIELD = new ParseField("gram_size");
                } else if (PhraseSuggestionBuilder.HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * get the candidate generators.
            && Objects.equals(preTag, other.preTag)
            collateParams,
    private float maxErrors = PhraseSuggestionContext.DEFAULT_MAX_ERRORS;
    private PhraseSuggestionBuilder(String fieldname, PhraseSuggestionBuilder in) {
                    String postTag = null;
        return this.collateQuery;
     */
        return this;
            }
        confidence = in.confidence;
            List<CandidateGenerator> generatorsList = entry.getValue();
                        && shingleFilterFactory.getMinShingleSize() > 1
                                + "] doesn't emit unigrams. If this is intentional try to set the analyzer explicitly"
        builder.field(FORCE_UNIGRAM_FIELD.getPreferredName(), forceUnigrams);
            tokenLimit,
        return this.gramSize;
    }
    public Script collateQuery() {
                            }
                        if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.common.lucene.BytesRefs;
            collateQuery,
                                );
        for (int i = 0; i < generatorsEntries; i++) {
     */
                generatorsList.add(generator);
     * get the {@link #gramSize(int)} parameter
                builder.startArray(entry.getKey());
        super(field);
     * get the maxErrors setting
    public interface CandidateGenerator extends Writeable, ToXContentObject {
            collateQuery = new Script(in);
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_PRUNE.match(currentFieldName, parser.getDeprecationHandler())) {
/*
                                );
    }
        model = in.readOptionalNamedWriteable(SmoothingModel.class);
    }
        }
    private SmoothingModel model;
        // now we should have field name, check and copy fields over to the suggestion builder we return
     * Adds additional parameters for collate scripts. Previously added parameters on the
import java.util.Objects;
    /**
    public Boolean collatePrune() {
    protected static final ParseField COLLATE_QUERY_FIELD = new ParseField("query");
                } else {
                } else if (PhraseSuggestionBuilder.GRAMSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            List<CandidateGenerator> generatorsList = new ArrayList<>(numberOfGenerators);
        MapperService mapperService = context.getMapperService();
     */
                    );
            && Objects.equals(postTag, other.postTag)
                }
        if (gramSize < 1) {
        }
                DirectCandidateGenerator generator = new DirectCandidateGenerator();
    }
    public PhraseSuggestionBuilder tokenLimit(int tokenLimit) {
                                postTag = parser.text();
                        }
        String currentFieldName = null;
                    tmpSuggestion.analyzer(parser.text());
            collateQuery.writeTo(out);
            TemplateScript.Factory scriptFactory = context.compile(this.collateQuery, TemplateScript.CONTEXT);
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_PARAMS.match(currentFieldName, parser.getDeprecationHandler())) {
    protected static final ParseField RWE_LIKELIHOOD_FIELD = new ParseField("real_word_error_likelihood");
        out.writeString(separator);
     * The default is set to {@code 1.0} which corresponds to that only
        if (tokenLimit <= 0) {
            builder.endObject();
        out.writeOptionalString(preTag);
    public PhraseSuggestionBuilder confidence(float confidence) {
 *
                    suggestionContext.setGramSize(shingleFilterFactory.getMaxShingleSize());
                    if (suggestionContext.getAnalyzer() == null
        if (list == null) {
            builder.field(COLLATE_QUERY_PRUNE.getPreferredName(), collatePrune);
                    String preTag = null;
import org.opensearch.core.xcontent.XContentBuilder;
                        );
        return this.preTag;
        }
            throw new IllegalArgumentException("only one smoothing model supported");
    private String postTag;
                    );
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        return this;
        this.preTag = preTag;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        tmpSuggestion.addCandidateGenerator(DirectCandidateGeneratorBuilder.PARSER.apply(parser, null));
            if (this.collateParams != null) {
/*
                } else if (PhraseSuggestionBuilder.TOKEN_LIMIT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            if (parser.isBooleanValue()) {
     * <p>
                } else if (PhraseSuggestionBuilder.COLLATE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.startObject(SMOOTHING_MODEL_FIELD.getPreferredName());
                                    parser.getTokenLocation(),
    }
            final ShingleTokenFilterFactory.Factory shingleFilterFactory = getShingleFilterFactory(suggestionContext.getAnalyzer());
import org.opensearch.core.common.io.stream.Writeable;
                    return factory;
        this.gramSize = gramSize;
    private float realWordErrorLikelihood = PhraseSuggestionContext.DEFAULT_RWE_ERRORLIKELIHOOD;
     * {@link CandidateGenerator} is used to draw candidates for each individual
        maxErrors = in.readFloat();
    }
            out.writeString(entry.getKey());
import java.util.HashMap;
     * {@link StupidBackoff}.
                                preTag = parser.text();
            && Objects.equals(forceUnigrams, other.forceUnigrams)
            throw new IllegalArgumentException("gramSize must be >= 1");
    private Script collateQuery;
        out.writeVInt(tokenLimit);
            builder.endObject();
                    throw new ParsingException(
    public PhraseSuggestionBuilder maxErrors(float maxErrors) {
                            } else if (PhraseSuggestionBuilder.POST_TAG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
 * SPDX-License-Identifier: Apache-2.0
        return this;
        if (analyzer instanceof AnalyzerComponentsProvider analyzerComponentsProvider) {
import java.util.Set;
            }
            separator,
        out.writeBoolean(forceUnigrams);
        return this.postTag;
        suggestionContext.setMaxErrors(this.maxErrors);
 * this file be licensed under the Apache-2.0 license or a
    public PhraseSuggestionBuilder smoothingModel(SmoothingModel model) {
            }
        preTag = in.readOptionalString();
            if (this.gramSize == null) {
    /**
        collateQuery = in.collateQuery;
                    tmpSuggestion.forceUnigrams(parser.booleanValue());
            suggestionContext.setCollatePrune(this.collatePrune);
    /**
        }
                            + "If this is intentional try to set the candidate generator field explicitly"
        return suggestionContext;
        if (collateQuery != null) {
import org.opensearch.index.analysis.AnalyzerComponentsProvider;
                        "The default candidate generator for phrase suggest can't operate on field: ["
 * Defines the actual suggest command for phrase suggestions ( {@code phrase}).
            forceUnigrams,
        } else {
import java.util.Collections;
                            }
 * GitHub history for details.
                if (shingleFilterFactory != null) {
import org.opensearch.index.mapper.MapperService;
        out.writeOptionalVInt(gramSize);
        return this.model;
    private static ShingleTokenFilterFactory.Factory getShingleFilterFactory(Analyzer analyzer) {
    }
        this.realWordErrorLikelihood = realWordErrorLikelihood;
import java.util.ArrayList;
import java.util.Map;
        return this.forceUnigrams;
        return this.collatePrune;
                    ensureNoSmoothing(tmpSuggestion);
                throw new ParsingException(parser.getTokenLocation(), "suggester[phrase] doesn't support field [" + currentFieldName + "]");
        this.collateQuery = new Script(ScriptType.INLINE, "mustache", collateQuery, Collections.emptyMap());
                DirectCandidateGeneratorBuilder generator = new DirectCandidateGeneratorBuilder(in);
        XContentParser.Token token;
    public static PhraseSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
            throw new IllegalArgumentException("real_word_error_likelihood must be > 0.0");
            throw new IllegalArgumentException("token_limit must be >= 1");
        out.writeFloat(confidence);
        return this.collateParams;
    }
     */
            && Objects.equals(realWordErrorLikelihood, other.realWordErrorLikelihood)
    public PhraseSuggestionBuilder realWordErrorLikelihood(float realWordErrorLikelihood) {
            preTag,
                if (shingleFilterFactory != null
    }
        return this.confidence;
    }
        this.collatePrune = collatePrune;
     * not set the whitespace character is used as a separator.
    }
                                parser.getTokenLocation(),
        realWordErrorLikelihood = in.realWordErrorLikelihood;
        String fieldname = null;
    @Override
     * the real words are misspelled.
    }
        this.collateParams = new HashMap<>(collateParams);
        return this;
     * is returned with suggestions wrapping changed tokens with preTag and postTag.
                    return shingleTokenFilterFactory.getInnerFactory();
                // try to detect the shingle size
import org.opensearch.index.analysis.NamedAnalyzer;
    }
        return this;
        }
    private Map<String, Object> collateParams;
     * If set to <code>true</code> the phrase suggester will fail if the analyzer only
    private String preTag;
                } else if (PhraseSuggestionBuilder.MAXERRORS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                suggestionContext.setCollateScriptParams(this.collateParams);
            for (CandidateGenerator candidateGenerator : candidateGenerators) {
            out.writeVInt(generatorsList.size());
    public Integer gramSize() {
            builder.field(GRAMSIZE_FIELD.getPreferredName(), gramSize);
     * phrase term before the candidates are scored.
    }
import org.opensearch.index.analysis.TokenFilterFactory;
    public PhraseSuggestionBuilder gramSize(int gramSize) {
                } else if (SuggestionBuilder.SHARDSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
        }
    private float confidence = PhraseSuggestionContext.DEFAULT_CONFIDENCE;
     */
                    && !shingleFilterFactory.getOutputUnigrams()
        if (this.collateQuery != null) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        Objects.requireNonNull(separator, "separator cannot be set to null");
        separator = in.separator;
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");
import org.opensearch.core.xcontent.ToXContentObject;
            confidence,
            for (int g = 0; g < numberOfGenerators; g++) {
                    }
        if (maxErrors <= 0.0) {
        model = in.model;
 */
        out.writeFloat(maxErrors);
     * higher than the input phrase. If set to {@code 0.0} the top N candidates
        this.separator = separator;
    /**
     */
    Map<String, List<CandidateGenerator>> getCandidateGenerators() {
            && Objects.equals(collateQuery, other.collateQuery)
 * Modifications Copyright OpenSearch Contributors. See
    /**
                                throw new ParsingException(
                                    "suggester[phrase][collate] prune must be either 'true' or 'false'"
            realWordErrorLikelihood,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected static final ParseField SEPARATOR_FIELD = new ParseField("separator");
 */
        out.writeFloat(realWordErrorLikelihood);
        this.generators.clear();
    }
                    throw new ParsingException(
     * Clear the candidate generators.
    /**
    public PhraseSuggestionBuilder collateParams(Map<String, Object> collateParams) {
            maxErrors,
        if (preTag != null) {
        collateParams = in.collateParams;
                if (DirectCandidateGeneratorBuilder.DIRECT_GENERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                if (SuggestionBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        PhraseSuggestionBuilder tmpSuggestion = new PhraseSuggestionBuilder("_na_");
     * get the setting for {@link #forceUnigrams()}
        this.model = model;
                } else {
            }
     */
}
        }
        PhraseSuggestionContext suggestionContext = new PhraseSuggestionContext(context);
        separator = in.readString();
    }
import org.opensearch.script.TemplateScript;
    }
    /**
        }
    }
                        }
     * threshold for other suggest candidates. Only candidates that score higher
                    );
     */
     * produces ngrams. the default it <code>true</code>.
import org.opensearch.script.Script;
                        parser.getTokenLocation(),
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            if (suggestionContext.generators().isEmpty()) {
     * Sets a query used for filtering out suggested phrases (collation).
        out.writeVInt(this.generators.size());
        }
        this.forceUnigrams = forceUnigrams;
        return this.tokenLimit;
            }
     * Read from a stream.
        confidence = in.readFloat();
    protected static final ParseField PRE_TAG_FIELD = new ParseField("pre_tag");
        builder.field(MAXERRORS_FIELD.getPreferredName(), maxErrors);
        out.writeMapWithConsistentOrder(collateParams);
    }
                    }
                    throw new ParsingException(
        String getType();
    @Override
    public SmoothingModel smoothingModel() {
     * in the dictionary. The default it {@code 0.95} corresponding to 5% or
            generators.put(type, generatorsList);
                }
    /**
        return this.maxErrors;
    private String separator = PhraseSuggestionContext.DEFAULT_SEPARATOR;
            && Objects.equals(collatePrune, other.collatePrune);
    /**
    @Override
            builder.field(COLLATE_QUERY_FIELD.getPreferredName(), collateQuery);
                    && shingleFilterFactory.getMinShingleSize() > 1
        return this;
     */
                        throw new IllegalArgumentException(
import org.opensearch.script.ScriptType;
        return this;
        }
     * get the post-tag for the highlighter set with {@link #highlight(String, String)}
    /**
    public PhraseSuggestionBuilder collatePrune(boolean collatePrune) {
    }
import java.util.Map.Entry;
 * Licensed to Elasticsearch under one or more contributor
        for (Entry<String, List<CandidateGenerator>> entry : this.generators.entrySet()) {
    /**
                builder.endArray();
                generator.writeTo(out);
public class PhraseSuggestionBuilder extends SuggestionBuilder<PhraseSuggestionBuilder> {
            builder.endObject();
        }
        if (analyzer instanceof NamedAnalyzer namedAnalyzer) {
     * than the threshold will be included in the result. For instance a
    public String postTag() {
                    tmpSuggestion.tokenLimit(parser.intValue());
            generators,
     * defines a factor applied to the input phrases score which is used as a
        return this;
        gramSize = in.readOptionalVInt();
            } else {
            String type = in.readString();
                        } else {
                    tmpSuggestion.confidence(parser.floatValue());
                suggestionContext.addGenerator(generator);
                                    "suggester[phrase][highlight] doesn't support field [" + currentFieldName + "]"
     * Adds a {@link CandidateGenerator} to this suggester. The
        builder.field(RWE_LIKELIHOOD_FIELD.getPreferredName(), realWordErrorLikelihood);
                            } else {
        }
    /**
    protected static final ParseField CONFIDENCE_FIELD = new ParseField("confidence");
            for (Entry<String, List<CandidateGenerator>> entry : entrySet) {
     * gets additional params for collate script
        collateParams = in.readMap();
import org.opensearch.core.xcontent.XContentParser;
    protected static final ParseField COLLATE_QUERY_PRUNE = new ParseField("prune");
     */
    }
    public String separator() {
    }
                suggestionContext.addGenerator(candidateGenerator.build(mapperService));
     * number {@code &gt;=1} as an absolute number of query terms.
        Objects.requireNonNull(collateParams, "collate parameters cannot be null.");
            collatePrune
    private int tokenLimit = NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT;
        return SUGGESTION_NAME;
        return this;
                builder.field(COLLATE_QUERY_PARAMS.getPreferredName(), collateParams);
        maxErrors = in.maxErrors;
    /**
 * license agreements. See the NOTICE file distributed with
     */
    private boolean collatePrune = PhraseSuggestionContext.DEFAULT_COLLATE_PRUNE;
                        parser.getTokenLocation(),
        this.tokenLimit = tokenLimit;
        List<CandidateGenerator> list = this.generators.get(generator.getType());
 * compatible open source license.
import org.opensearch.search.suggest.SuggestionBuilder;
    }
                    tmpSuggestion.gramSize(parser.intValue());
        // copy over common settings to each suggestion builder
                                "suggester[phrase][collate] doesn't support field [" + currentFieldName + "]"
        return this;
        }
        super(fieldname, in);
            && Objects.equals(tokenLimit, other.tokenLimit)
import org.opensearch.core.common.ParsingException;
        return null;
    }
     * get the {@link #realWordErrorLikelihood(float)} parameter
    /**
package org.opensearch.search.suggest.phrase;
            Set<Entry<String, List<CandidateGenerator>>> entrySet = generators.entrySet();
     */
            throw new IllegalArgumentException("confidence must be >= 0.0");
                                tmpSuggestion.collatePrune(parser.booleanValue());
        return this.generators;
    @Override
    public PhraseSuggestionBuilder separator(String separator) {
     */
        int generatorsEntries = in.readVInt();
    protected static final ParseField COLLATE_FIELD = new ParseField("collate");
     * misspellings in order to form a correction. This method accepts a float
 * software distributed under the License is distributed on an
            && Objects.equals(model, other.model)
                    tmpSuggestion.shardSize(parser.intValue());
    public Float realWordErrorLikelihood() {
            && Objects.equals(generators, other.generators)
    /**
            out.writeBoolean(true);
import java.io.IOException;
    protected static final ParseField MAXERRORS_FIELD = new ParseField("max_errors");
        if ((preTag == null) != (postTag == null)) {
        }
     * are returned. The default is {@code 1.0}
        tokenLimit = in.readVInt();
     * Sets the confidence level for this suggester. The confidence level
            && Objects.equals(confidence, other.confidence)
        if (this.gramSize != null) {
            }
     */
    /**
        suggestionContext.setRealWordErrorLikelihood(this.realWordErrorLikelihood);
import org.opensearch.core.common.io.stream.StreamInput;
                            Script template = Script.parse(parser, Script.DEFAULT_TEMPLATE_LANG);
    }
                currentFieldName = parser.currentName();
            }
     * get the separator that is used to separate terms in the bigram field.
            for (CandidateGenerator generator : generatorsList) {
                        "suggester[phrase] doesn't support field [" + currentFieldName + "]"
                } else if (PhraseSuggestionBuilder.RWE_LIKELIHOOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                generator.setField(suggestionContext.getField());
        if (fieldname == null) {
        }
