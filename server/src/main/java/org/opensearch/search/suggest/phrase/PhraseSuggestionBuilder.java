import org.opensearch.core.ParseField;  
            collateParams,
     * corrections with at most 1 misspelled term are returned.
                            );
        out.writeFloat(confidence);
    }
    protected static final ParseField MAXERRORS_FIELD = new ParseField("max_errors");
    }  
                    suggestionContext.setGramSize(shingleFilterFactory.getMaxShingleSize());
    @Override  
            throw new IllegalArgumentException("confidence must be >= 0.0");  
        out.writeOptionalNamedWriteable(model);  
        separator = in.separator;  
                    String preTag = null;  
        }
    }
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");  
        }  
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_PARAMS.match(currentFieldName, parser.getDeprecationHandler())) {
            int numberOfGenerators = in.readVInt();
import org.opensearch.core.xcontent.XContentParser.Token;
        }
        Objects.requireNonNull(separator, "separator cannot be set to null");
        }  
     * default value is {@code 1} corresponding to {@code unigrams}. Use  
                } else if (PhraseSuggestionBuilder.RWE_LIKELIHOOD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                parser.getTokenLocation(),  
import org.opensearch.index.mapper.MapperService;
     */
                                "suggester[phrase][collate] doesn't support field [" + currentFieldName + "]"
    }  
                DirectCandidateGeneratorBuilder generator = new DirectCandidateGeneratorBuilder(in);
            for (int g = 0; g < numberOfGenerators; g++) {
     */  
    public Float realWordErrorLikelihood() {  
        suggestionContext.setRealWordErrorLikelihood(this.realWordErrorLikelihood);
     * Sets the maximum percentage of the terms that at most considered to be
import org.opensearch.common.lucene.BytesRefs;
        return this;
                    return shingleTokenFilterFactory.getInnerFactory();  
     * Adds a {@link CandidateGenerator} to this suggester. The
    }
            && Objects.equals(separator, other.separator)
        return this;
     * is returned with suggestions wrapping changed tokens with preTag and postTag.
                    throw new ParsingException(
        return Objects.equals(maxErrors, other.maxErrors)
            builder.startObject(SMOOTHING_MODEL_FIELD.getPreferredName());
                    );
                            Script template = Script.parse(parser, Script.DEFAULT_TEMPLATE_LANG);  
                    && suggestionContext.getRequireUnigram()) {
    public interface CandidateGenerator extends Writeable, ToXContentObject {  
    }
 */
    /**  
            for (CandidateGenerator generator : generatorsList) {
     * {@code 2} for {@code bigrams} and {@code 3} for {@code trigrams}.
                } else {
            && Objects.equals(forceUnigrams, other.forceUnigrams)
                    tmpSuggestion.maxErrors(parser.floatValue());  
            && Objects.equals(realWordErrorLikelihood, other.realWordErrorLikelihood)  
     */
            final TokenFilterFactory[] tokenFilters = analyzerComponentsProvider.getComponents().getTokenFilters();  
            forceUnigrams,  
import java.util.Map;  
                            }  
            && Objects.equals(collateQuery, other.collateQuery)  
    }
     * produces ngrams. the default it <code>true</code>.  
 * license agreements. See the NOTICE file distributed with
        if (list == null) {
 * specific language governing permissions and limitations
        model = in.readOptionalNamedWriteable(SmoothingModel.class);  
     * gets the query used for filtering out suggested phrases (collation).
                    tmpSuggestion.tokenLimit(parser.intValue());  
        if (suggestion.smoothingModel() != null) {
        list.add(generator);  
        out.writeOptionalVInt(gramSize);
     */
     */  
                }  
    protected static final ParseField POST_TAG_FIELD = new ParseField("post_tag");  
    @Override
                        parser.getTokenLocation(),  
    public String getWriteableName() {
        return this;
                }  
                suggestionContext.addGenerator(generator);
    public Boolean collatePrune() {  
    }
                        );  
            out.writeBoolean(true);
            } else if (token == Token.START_OBJECT) {
    protected static final ParseField COLLATE_QUERY_PARAMS = new ParseField("params");  
        if (analyzer instanceof AnalyzerComponentsProvider analyzerComponentsProvider) {
     * Read from a stream.
     * get the maxErrors setting  
    public static final String SUGGESTION_NAME = "phrase";  
                            currentFieldName = parser.currentName();
                    tmpSuggestion.gramSize(parser.intValue());
            generators,  
    public SuggestionContext build(QueryShardContext context) throws IOException {  
        }
        out.writeString(separator);
                        }
            builder.field(GRAMSIZE_FIELD.getPreferredName(), gramSize);
            }  
    }
    private String postTag;  
            builder.startObject(COLLATE_FIELD.getPreferredName());
            TemplateScript.Factory scriptFactory = context.compile(this.collateQuery, TemplateScript.CONTEXT);  
 * The OpenSearch Contributors require contributions made to  
        confidence = in.readFloat();
 * this file be licensed under the Apache-2.0 license or a
     * {@link StupidBackoff}.
            builder.startObject(HIGHLIGHT_FIELD.getPreferredName());
        }
                            if (PhraseSuggestionBuilder.PRE_TAG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    private Script collateQuery;
        return this;
                            throw new ParsingException(
                                    parser.getTokenLocation(),  
            for (TokenFilterFactory tokenFilterFactory : tokenFilters) {
                }
    /**
        postTag = in.postTag;
        }  
            if (collateParams != null) {  
    protected static final ParseField COLLATE_FIELD = new ParseField("collate");
     */  
            collateQuery = new Script(in);
import java.util.Set;  
                // try to detect the shingle size
        this.collateParams = new HashMap<>(collateParams);
        }  
 */  
            separator,  
        }
    public PhraseSuggestionBuilder gramSize(int gramSize) {  
 *  
            if (this.gramSize == null) {
        return this;  
    }  
                } else {
    // gramSize needs to be optional although there is a default, if unset parser try to detect and use shingle size
    public String preTag() {
     * threshold for other suggest candidates. Only candidates that score higher
                    tmpSuggestion.smoothingModel(SmoothingModel.fromXContent(parser));
                    tmpSuggestion.analyzer(parser.text());
        List<CandidateGenerator> list = this.generators.get(generator.getType());
        if (model != null) {
        XContentParser.Token token;
/*  
        generators.putAll(in.generators);  
        MapperService mapperService = context.getMapperService();
 */  
import org.opensearch.index.analysis.ShingleTokenFilterFactory;
                            + "] since it doesn't emit unigrams. "  
 *
            model,
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                                postTag = parser.text();  
                        && shingleFilterFactory.getMinShingleSize() > 1  
        super(field);
        }  
        if (this.collateQuery != null) {
    public PhraseSuggestionBuilder(String field) {
    /**
    private float maxErrors = PhraseSuggestionContext.DEFAULT_MAX_ERRORS;  
        return null;  
    }
                } else if (SuggestionBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * <p>
                builder.field(COLLATE_QUERY_PARAMS.getPreferredName(), collateParams);
            collateQuery.writeTo(out);
    protected static final ParseField HIGHLIGHT_FIELD = new ParseField("highlight");
    protected static final ParseField SEPARATOR_FIELD = new ParseField("separator");
    }
                            } else {
        for (int i = 0; i < generatorsEntries; i++) {  
public class PhraseSuggestionBuilder extends SuggestionBuilder<PhraseSuggestionBuilder> {
            builder.field(POST_TAG_FIELD.getPreferredName(), postTag);  
     * Setup highlighting for suggestions.  If this is called a highlight field
/**
    /**  
        return this.collateParams;
        this.confidence = confidence;
    public PhraseSuggestionBuilder clearCandidateGenerators() {
 * this work for additional information regarding copyright
        builder.field(SEPARATOR_FIELD.getPreferredName(), separator);
        tokenLimit = in.tokenLimit;
                            }  
    /**  
                } else if (PhraseSuggestionBuilder.HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.gramSize = gramSize;
                } else if (SuggestionBuilder.FIELDNAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
            for (Entry<String, List<CandidateGenerator>> entry : entrySet) {
                if (SuggestionBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        collatePrune = in.collatePrune;
        return this;  
import org.opensearch.index.analysis.NamedAnalyzer;
            Set<Entry<String, List<CandidateGenerator>>> entrySet = generators.entrySet();
        return this.gramSize;  
                    && shingleFilterFactory.getMinShingleSize() > 1  
                } else if (SuggestionBuilder.SHARDSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                        parser.getTokenLocation(),  
     * value in the range [0..1) as a fraction of the actual query terms a  
import org.opensearch.core.common.io.stream.Writeable;
        if ((preTag == null) != (postTag == null)) {
                    && !shingleFilterFactory.getOutputUnigrams()
    /**
 *
    }  
    /**  
     * {@link CandidateGenerator} interface.
        return Objects.hash(
        this.generators.clear();
                generator.setField(suggestionContext.getField());  
                suggestionContext.setCollateScriptParams(this.collateParams);  
        // copy over common settings to each suggestion builder  
     * higher than the input phrase. If set to {@code 0.0} the top N candidates
    public PhraseSuggestionBuilder collateQuery(Script collateQueryTemplate) {
        String getType();
                builder.startArray(entry.getKey());  
    @Override
     * get the {@link #tokenLimit(int)} parameter  
                        "suggester[phrase] doesn't support field [" + currentFieldName + "]"
                                );
        preTag = in.preTag;  
    private int tokenLimit = NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT;
    public PhraseSuggestionBuilder collateParams(Map<String, Object> collateParams) {  
     * number {@code &gt;=1} as an absolute number of query terms.
        Objects.requireNonNull(collateParams, "collate parameters cannot be null.");
                        } else if (token.isValue()) {
                } else if (PhraseSuggestionBuilder.GRAMSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            } else {
    protected static final ParseField CONFIDENCE_FIELD = new ParseField("confidence");
     */
        if (collateQuery != null) {  
                    throw new ParsingException(  
        this.collatePrune = collatePrune;
                } else if (PhraseSuggestionBuilder.SEPARATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        super(fieldname, in);
        if (in.readBoolean()) {  
        if (fieldname == null) {
import java.io.IOException;
    private SmoothingModel model;
        return this.preTag;
                    throw new IllegalArgumentException(  
    @Override  
import org.opensearch.script.ScriptType;
                            } else {
            out.writeVInt(generatorsList.size());  
                        } else {
    /**  
                if (shingleFilterFactory != null) {  
            postTag,  
        maxErrors = in.readFloat();
 */
        }
        PhraseSuggestionBuilder tmpSuggestion = new PhraseSuggestionBuilder("_na_");
     * Sets an explicit smoothing model used for this suggester. The default is  
        String currentFieldName = null;  
    protected static final ParseField COLLATE_QUERY_FIELD = new ParseField("query");
                // use a default generator on the same field
                } else if (PhraseSuggestionBuilder.CONFIDENCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private Map<String, Object> collateParams;
            for (CandidateGenerator candidateGenerator : candidateGenerators) {
        this.collateQuery = collateQueryTemplate;  
 * SPDX-License-Identifier: Apache-2.0
    public PhraseSuggestionBuilder highlight(String preTag, String postTag) {
    public String postTag() {
        return this;  
            out.writeString(entry.getKey());
            && Objects.equals(gramSize, other.gramSize)  
    }
        out.writeMapWithConsistentOrder(collateParams);  
        out.writeOptionalBoolean(collatePrune);
            builder.field(PRE_TAG_FIELD.getPreferredName(), preTag);
                } else if (tokenFilterFactory instanceof ShingleTokenFilterFactory.Factory factory) {
    public Map<String, Object> collateParams() {  
     * Adds additional parameters for collate scripts. Previously added parameters on the  
        return builder;  
import org.opensearch.search.suggest.SuggestionBuilder;  
import java.util.Collections;  
            if (suggestionContext.generators().isEmpty()) {
        return this;
    Map<String, List<CandidateGenerator>> getCandidateGenerators() {  
import org.opensearch.index.analysis.TokenFilterFactory;  
            confidence,
        if (this.model != null) {
        for (List<CandidateGenerator> candidateGenerators : this.generators.values()) {
    }
            builder.field(COLLATE_QUERY_FIELD.getPreferredName(), collateQuery);
     * gets additional params for collate script
     */
                    throw new ParsingException(
        return this;  
                    if (suggestionContext.getAnalyzer() == null
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (collateQuery != null) {  
        if (preTag != null) {  
        }
                } else if (PhraseSuggestionBuilder.TOKEN_LIMIT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * are returned. The default is {@code 1.0}
            }
                }
 * GitHub history for details.
    public static PhraseSuggestionBuilder fromXContent(XContentParser parser) throws IOException {  
    private boolean collatePrune = PhraseSuggestionContext.DEFAULT_COLLATE_PRUNE;  
        if (confidence < 0.0) {
    }
     */  
            && Objects.equals(collateParams, other.collateParams)
    protected static final ParseField PRE_TAG_FIELD = new ParseField("pre_tag");
        }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private String separator = PhraseSuggestionContext.DEFAULT_SEPARATOR;
    }
     */
    }
 * Licensed to Elasticsearch under one or more contributor  
        this.separator = separator;  
        return this.forceUnigrams;
            builder.endObject();
    /**
            realWordErrorLikelihood,
    }  
     */
     */  
     * phrase term before the candidates are scored.
            this.generators.put(generator.getType(), list);
        realWordErrorLikelihood = in.readFloat();  
                } else {
import org.opensearch.core.common.io.stream.StreamOutput;  
                            if (parser.isBooleanValue()) {
                            + suggestionContext.getField()
                                + suggestionContext.getField()
        }
        return SUGGESTION_NAME;
        }
            String type = in.readString();
    }
            }
                if (shingleFilterFactory != null
            List<CandidateGenerator> generatorsList = new ArrayList<>(numberOfGenerators);  
        model = in.model;
            }  
    /**  
     * Sets whether to prune suggestions after collation
                    tmpSuggestion.shardSize(parser.intValue());
     */
                    generator.toXContent(builder, params);
        this.tokenLimit = tokenLimit;
    public PhraseSuggestionBuilder tokenLimit(int tokenLimit) {  
        int generatorsEntries = in.readVInt();
                    tmpSuggestion.confidence(parser.floatValue());
 *
                                throw new ParsingException(
                if (PhraseSuggestionBuilder.SMOOTHING_MODEL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        forceUnigrams = in.readBoolean();
                    tmpSuggestion.highlight(preTag, postTag);  
        out.writeVInt(this.generators.size());
            && Objects.equals(collatePrune, other.collatePrune);
    /**  
                } else if (PhraseSuggestionBuilder.MAXERRORS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        collateParams = in.readMap();  
    }  
     * the real words are misspelled.
        return this.postTag;  
        builder.field(CONFIDENCE_FIELD.getPreferredName(), confidence);
        preTag = in.readOptionalString();  
import org.opensearch.core.xcontent.ToXContentObject;
     */
        }
            }
                } else if (PhraseSuggestionBuilder.COLLATE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
     * {@link CandidateGenerator} is used to draw candidates for each individual  
        return this.confidence;
        suggestionContext.setRequireUnigram(this.forceUnigrams);
     */
    private Integer gramSize;
    /**
     * misspellings in order to form a correction. This method accepts a float
     */  
    protected boolean doEquals(PhraseSuggestionBuilder other) {  
        return this.generators;
            }
                    );
    }
    public Float maxErrors() {
     * The default is set to {@code 1.0} which corresponds to that only  
                }  
    public PhraseSuggestionBuilder collatePrune(boolean collatePrune) {
            suggestionContext.setGramSize(this.gramSize);
     * not set the whitespace character is used as a separator.
            throw new IllegalArgumentException("max_error must be > 0.0");
        return this;
import java.util.HashMap;
            throw new IllegalArgumentException("real_word_error_likelihood must be > 0.0");  
    }  
    protected static final ParseField SMOOTHING_MODEL_FIELD = new ParseField("smoothing");
                    while ((token = parser.nextToken()) == Token.START_OBJECT) {
    /**
 * Modifications Copyright OpenSearch Contributors. See  
        return this.collateQuery;
        out.writeOptionalString(preTag);  
    /**
        suggestionContext.setPreTag(BytesRefs.toBytesRef(this.preTag));  
        if (gramSize != null) {
    public Script collateQuery() {
            analyzer = namedAnalyzer.analyzer();  
                        "suggester[phrase]  doesn't support array field [" + currentFieldName + "]"
     */
        return this.model;  
     * defines a factor applied to the input phrases score which is used as a  
        gramSize = in.readOptionalVInt();
    /**
    /**  
        this.preTag = preTag;
    protected static final ParseField FORCE_UNIGRAM_FIELD = new ParseField("force_unigrams");
        return this.collatePrune;
    }
            throw new IllegalArgumentException("Pre and post tag must both be null or both not be null.");  
        if (!generators.isEmpty()) {  
        this.model = model;
        this.collateQuery = new Script(ScriptType.INLINE, "mustache", collateQuery, Collections.emptyMap());
    private PhraseSuggestionBuilder(String fieldname, PhraseSuggestionBuilder in) {  
        if (realWordErrorLikelihood <= 0.0) {
            }
    public PhraseSuggestionBuilder separator(String separator) {
    /**  
            && Objects.equals(preTag, other.preTag)
        }  
     * in the dictionary. The default it {@code 0.95} corresponding to 5% or
 * KIND, either express or implied.  See the License for the
            builder.endObject();
                                    "suggester[phrase][collate] query already set, doesn't support additional [" + currentFieldName + "]"  
                                    "suggester[phrase][collate] prune must be either 'true' or 'false'"
        if (maxErrors <= 0.0) {
    private float confidence = PhraseSuggestionContext.DEFAULT_CONFIDENCE;  
import org.opensearch.core.xcontent.XContentParser;
            && Objects.equals(confidence, other.confidence)
                            "The default analyzer for field: ["  
        out.writeFloat(realWordErrorLikelihood);  
     * get the {@link #confidence()} parameter
    public PhraseSuggestionBuilder collateQuery(String collateQuery) {  
                    );  
        }  
        gramSize = in.gramSize;  
    }
        tokenLimit = in.readVInt();
            model.toXContent(builder, params);  
        builder.field(TOKEN_LIMIT_FIELD.getPreferredName(), tokenLimit);
        String fieldname = null;
     * get the post-tag for the highlighter set with {@link #highlight(String, String)}  
                currentFieldName = parser.currentName();
        return this.realWordErrorLikelihood;
        suggestionContext.setPostTag(BytesRefs.toBytesRef(this.postTag));
     */
        out.writeOptionalString(postTag);
    /**
            final ShingleTokenFilterFactory.Factory shingleFilterFactory = getShingleFilterFactory(suggestionContext.getAnalyzer());  
            throw new IllegalArgumentException("token_limit must be >= 1");
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }  
    protected static final ParseField RWE_LIKELIHOOD_FIELD = new ParseField("real_word_error_likelihood");  
        out.writeBoolean(forceUnigrams);
                        }  
     * Sets the separator that is used to separate terms in the bigram field. If
                    tmpSuggestion.separator(parser.text());
            throw new IllegalArgumentException("gramSize must be >= 1");
    }
 * compatible open source license.
    /**
        this.postTag = postTag;  
        builder.field(MAXERRORS_FIELD.getPreferredName(), maxErrors);  
        out.writeVInt(tokenLimit);
import org.opensearch.script.TemplateScript;
    /**
        return this.maxErrors;  
     * Gets the {@link SmoothingModel}  
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        suggestionContext.setConfidence(this.confidence);
            maxErrors,
                            tmpSuggestion.collateParams(parser.map());  
            && Objects.equals(generators, other.generators)
                        tmpSuggestion.addCandidateGenerator(DirectCandidateGeneratorBuilder.PARSER.apply(parser, null));
    /**
        }
     * @opensearch.internal
        maxErrors = in.maxErrors;
                            + "If this is intentional try to set the candidate generator field explicitly"
     * Sets the gram size for the n-gram model used for this suggester. The
        this.forceUnigrams = forceUnigrams;  
        this.realWordErrorLikelihood = realWordErrorLikelihood;
        suggestionContext.setMaxErrors(this.maxErrors);  
     * If set to <code>true</code> the phrase suggester will fail if the analyzer only
                    ensureNoSmoothing(tmpSuggestion);  
    public PhraseSuggestionBuilder forceUnigrams(boolean forceUnigrams) {
     */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                                throw new ParsingException(
    }
        }  
    /**
    }
                                    parser.getTokenLocation(),
        realWordErrorLikelihood = in.realWordErrorLikelihood;
 * not use this file except in compliance with the License.
     */
        return this;
/*
     */  
    /**
                } else if (PhraseSuggestionBuilder.FORCE_UNIGRAM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        this.maxErrors = maxErrors;
                if (tokenFilterFactory instanceof ShingleTokenFilterFactory shingleTokenFilterFactory) {
     */
     */
import org.opensearch.OpenSearchParseException;
    }
                                preTag = parser.text();
            }
    @Override
        super(in);
    public Boolean forceUnigrams() {
        PhraseSuggestionContext.DirectCandidateGenerator build(MapperService mapperService) throws IOException;  
import org.apache.lucene.analysis.Analyzer;  
    }  
                }  
        return suggestionContext;
    public PhraseSuggestionBuilder smoothingModel(SmoothingModel model) {  
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */  
            gramSize,
                            currentFieldName = parser.currentName();
    private static void ensureNoSmoothing(PhraseSuggestionBuilder suggestion) {  
        if (gramSize < 1) {
                                );
        }
import org.opensearch.index.analysis.AnalyzerComponentsProvider;  
 * Defines the actual suggest command for phrase suggestions ( {@code phrase}).  
        } else {  
                if (DirectCandidateGeneratorBuilder.DIRECT_GENERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
            collatePrune  
                    tmpSuggestion.forceUnigrams(parser.booleanValue());
    public void doWriteTo(StreamOutput out) throws IOException {
        postTag = in.readOptionalString();
        populateCommonFields(mapperService, suggestionContext);
    public Float confidence() {  
    /**
    }  
        PhraseSuggestionContext suggestionContext = new PhraseSuggestionContext(context);
import org.opensearch.search.suggest.phrase.PhraseSuggestionContext.DirectCandidateGenerator;
     * internal copy constructor that copies over all class fields except for the field which is  
            suggestionContext.setModel(this.model.buildWordScorerFactory());
            throw new IllegalArgumentException("only one smoothing model supported");
     * get the setting for {@link #forceUnigrams()}
    private boolean forceUnigrams = PhraseSuggestionContext.DEFAULT_REQUIRE_UNIGRAM;  
                    );
    }  
        builder.field(FORCE_UNIGRAM_FIELD.getPreferredName(), forceUnigrams);
                generator.writeTo(out);
            list = new ArrayList<>();  
        out.writeFloat(maxErrors);
     * confidence level of {@code 1.0} will only return suggestions that score  
        confidence = in.confidence;
     */
            } else if (token.isValue()) {
            List<CandidateGenerator> generatorsList = entry.getValue();
                                    "suggester[phrase][highlight] doesn't support field [" + currentFieldName + "]"
     * get the {@link #gramSize(int)} parameter  
        if (this.gramSize == null || suggestionContext.generators().isEmpty()) {
            collateQuery,
                    }
     * get the separator that is used to separate terms in the bigram field.
                    tmpSuggestion.realWordErrorLikelihood(parser.floatValue());  
     * Clear the candidate generators.
    protected static final ParseField GRAMSIZE_FIELD = new ParseField("gram_size");  
 * under the License.  
                builder.endArray();
     */  
     * Sets a query used for filtering out suggested phrases (collation).
            && Objects.equals(postTag, other.postTag)
        return this;  
    /**
            if (token == XContentParser.Token.FIELD_NAME) {  
                        "The default candidate generator for phrase suggest can't operate on field: ["
     */
                            } else if (PhraseSuggestionBuilder.POST_TAG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
    /**
     */
                throw new ParsingException(parser.getTokenLocation(), "suggester[phrase] doesn't support field [" + currentFieldName + "]");  
     * set to the one provided in the first argument
     * Sets a query used for filtering out suggested phrases (collation).  
        if (this.gramSize != null) {  
            builder.endObject();
        collateQuery = in.collateQuery;
    protected static final ParseField COLLATE_QUERY_PRUNE = new ParseField("prune");
            suggestionContext.setCollatePrune(this.collatePrune);
    }
                                + "] doesn't emit unigrams. If this is intentional try to set the analyzer explicitly"
                }  
                                tmpSuggestion.collatePrune(parser.booleanValue());  
                    String postTag = null;
     */
        }  
     * than the threshold will be included in the result. For instance a
import java.util.ArrayList;
        for (Entry<String, List<CandidateGenerator>> entry : this.generators.entrySet()) {  
 * You may obtain a copy of the License at  
    public Integer gramSize() {
    public PhraseSuggestionBuilder confidence(float confidence) {
            out.writeBoolean(false);
                        if (token == XContentParser.Token.FIELD_NAME) {  
 * Unless required by applicable law or agreed to in writing,
                        if (token == XContentParser.Token.FIELD_NAME) {  
            preTag,
                                );
        }
    private final Map<String, List<CandidateGenerator>> generators = new HashMap<>();
                    // for now we only have a single type of generators  
    protected static final ParseField TOKEN_LIMIT_FIELD = new ParseField("token_limit");  
    }
    /**  
     * Sets the likelihood of a term being a misspelled even if the term exists  
            && Objects.equals(model, other.model)
    }
                            tmpSuggestion.collateQuery(template);
package org.opensearch.search.suggest.phrase;
        return new PhraseSuggestionBuilder(fieldname, tmpSuggestion);
    public PhraseSuggestionBuilder realWordErrorLikelihood(float realWordErrorLikelihood) {
                    fieldname = parser.text();  
import org.opensearch.core.common.ParsingException;
                    }
            && Objects.equals(tokenLimit, other.tokenLimit)  
    private static ShingleTokenFilterFactory.Factory getShingleFilterFactory(Analyzer analyzer) {
import java.util.Objects;
                generatorsList.add(generator);  
     */  
     * Sets the confidence level for this suggester. The confidence level
                                    parser.getTokenLocation(),  
import org.opensearch.core.xcontent.XContentBuilder;  
import java.util.Map.Entry;
}
import org.opensearch.index.query.QueryShardContext;
        }  
                suggestionContext.addGenerator(candidateGenerator.build(mapperService));  
     * Gets whether to prune suggestions after collation
        suggestionContext.setSeparator(BytesRefs.toBytesRef(this.separator));  
                            if (tmpSuggestion.collateQuery() != null) {  
        suggestionContext.setTokenLimit(this.tokenLimit);
    public Integer tokenLimit() {
            }
    @Override
                                throw new ParsingException(
                        throw new IllegalArgumentException(
     * get the pre-tag for the highlighter set with {@link #highlight(String, String)}
    public PhraseSuggestionBuilder addCandidateGenerator(CandidateGenerator generator) {  
                    }
    public PhraseSuggestionBuilder maxErrors(float maxErrors) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        collateParams = in.collateParams;  
        return this;
        // now we should have field name, check and copy fields over to the suggestion builder we return
     * same builder will be overwritten.
import org.opensearch.core.common.io.stream.StreamInput;
        }
        if (analyzer instanceof NamedAnalyzer namedAnalyzer) {
        return this.tokenLimit;  
                DirectCandidateGenerator generator = new DirectCandidateGenerator();
                        "suggester[phrase]  doesn't support array field [" + currentFieldName + "]"
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            tokenLimit,
        forceUnigrams = in.forceUnigrams;
     * get the {@link #realWordErrorLikelihood(float)} parameter
            }
    public SmoothingModel smoothingModel() {
        if (tokenLimit <= 0) {
import org.opensearch.script.Script;  
        );
        return this.separator;
                        && !shingleFilterFactory.getOutputUnigrams()) {
            generators.put(type, generatorsList);
    public PhraseSuggestionBuilder(StreamInput in) throws IOException {  
     * get the candidate generators.
                    tmpSuggestion.size(parser.intValue());
    }  
     *  
        collatePrune = in.readOptionalBoolean();
                for (CandidateGenerator generator : entry.getValue()) {
                            }
                        } else if (PhraseSuggestionBuilder.COLLATE_QUERY_PRUNE.match(currentFieldName, parser.getDeprecationHandler())) {
            } else if (token == Token.START_ARRAY) {
                        parser.getTokenLocation(),
    private String preTag;
        }
    /**
    protected int doHashCode() {  
            suggestionContext.setCollateQueryScript(scriptFactory);
                    return factory;
        return this;
    public String separator() {
            builder.field(COLLATE_QUERY_PRUNE.getPreferredName(), collatePrune);  
    private float realWordErrorLikelihood = PhraseSuggestionContext.DEFAULT_RWE_ERRORLIKELIHOOD;
        separator = in.readString();
 * @opensearch.internal
        return this;
        builder.field(RWE_LIKELIHOOD_FIELD.getPreferredName(), realWordErrorLikelihood);  
            if (this.collateParams != null) {
    }
                    }  
     */
    /**
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
