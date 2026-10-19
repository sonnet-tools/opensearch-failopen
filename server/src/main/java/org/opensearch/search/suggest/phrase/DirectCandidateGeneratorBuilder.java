     * based on Damerau-Levenshtein algorithm.
     */
        return Objects.equals(field, other.field)
     * </ol>
     */
        TYPE,
        this.minDocFreq = minDocFreq;
 * Builder for a phrase candidate directly retrieved from an IndexReader
        return maxInspections;
        minWordLength = in.readOptionalVInt();
    /**  
    String suggestMode() {  
        return this;
     * <li><code>popular</code> - Only suggest terms that occur in more docs
    /**  
    }
        transferIfNotNull(this.minDocFreq, generator::minDocFreq);
     * document frequency and then the term itself.
     * Sets how to sort the suggest terms per suggest text token. Two
    }
        outputFieldIfNotNull(preFilter, PREFILTER_FIELD, builder);
            throw new IllegalArgumentException("Illegal max_edits value " + generator.maxEdits());
        if ("missing".equals(suggestMode)) {
import java.util.Locale;  
    }
     * The minimum length a suggest text term must have in order to be
        this.stringDistance = stringDistance;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public final class DirectCandidateGeneratorBuilder implements CandidateGenerator {  
    }
            return new JaroWinklerDistance();  
        this.postFilter = postFilter;  
    }  
    }
     * <li><code>frequency</code> - Sort should first be based on document  
    @Override
    }
     * n-grams.
     * of this. This also improves the suggest performance.
import org.opensearch.common.xcontent.XContentFactory;
        suggestMode = suggestMode.toLowerCase(Locale.US);  
import org.apache.lucene.search.spell.DirectSpellChecker;
        this.maxTermFreq = maxTermFreq;
import org.apache.lucene.util.automaton.LevenshteinAutomata;
     * Default is {@code 0.5}
        builder.startObject();  
    Integer prefixLength() {
        }
    }  
        this.size = size;
     * suggested. High frequency terms are usually spelled correctly on top  
        minDocFreq = in.readOptionalFloat();  
        outputFieldIfNotNull(prefixLength, PREFIX_LENGTH_FIELD, builder);  
        maxTermFreq = in.readOptionalFloat();  
        }
     * more candidate suggestions. Can improve accuracy at the cost of
    Integer maxEdits() {
    public static final ParseField SIZE_FIELD = new ParseField("size");
            return false;
            generator.suggestMode(resolveSuggestMode(this.suggestMode));  
import org.apache.lucene.search.spell.JaroWinklerDistance;
    }  
    }  
     * <li><code>jaro_winkler</code> - String distance algorithm based on
    public DirectCandidateGeneratorBuilder minDocFreq(float minDocFreq) {  
     * <ol>
        PARSER.declareString(DirectCandidateGeneratorBuilder::suggestMode, SUGGESTMODE_FIELD);
     * tokens in the suggest text.
    }  
        return suggestMode;
     * <p>  
    }
        return postFilter;
 *
        this.maxInspections = maxInspections;
        return prefixLength;  
        maxEdits = in.readOptionalVInt();
    public static final ParseField POSTFILTER_FIELD = new ParseField("post_filter");
    }
     * possible values:
        out.writeOptionalVInt(maxEdits);
                throw new IllegalArgumentException("Analyzer [" + this.preFilter + "] doesn't exists");
    public static final ParseField DIRECT_GENERATOR_FIELD = new ParseField(TYPE);
            return new LuceneLevenshteinDistance();
        out.writeOptionalString(sort);
            toXContent(builder, EMPTY_PARAMS);
     * before they are passed to the actual phrase scorer.  
     * </ol>  
            generator.sort(SortBy.resolve(this.sort));  
        } else if ("jaro_winkler".equals(distanceVal)) {
        outputFieldIfNotNull(field, FIELDNAME_FIELD, builder);
    /**
        distanceVal = distanceVal.toLowerCase(Locale.ROOT);
            throw new IllegalArgumentException("Size must be positive");
    }
    public String toString() {  
        }
    public static final ParseField MAX_TERM_FREQ_FIELD = new ParseField("max_term_freq");
 * software distributed under the License is distributed on an
import org.opensearch.search.suggest.SortBy;
    /**
        return minWordLength;
    private Float minDocFreq;  
 * Licensed to Elasticsearch under one or more contributor  
    /**
        outputFieldIfNotNull(minWordLength, MIN_WORD_LENGTH_FIELD, builder);  
        maxInspections = in.readOptionalVInt();
            sort,
    String sort() {
            && Objects.equals(minWordLength, other.minWordLength)
        transferIfNotNull(this.minWordLength, generator::minWordLength);  
     * performance. Defaults to {@code 5}.
            postFilter,
    private String suggestMode;
        return generator;
            maxInspections,
    }
            generator.preFilter(mapperService.getNamedAnalyzer(this.preFilter));
    public static final ParseField ACCURACY_FIELD = new ParseField("accuracy");
        return this;
     * the original suggest text tokens. A value between 0 and 1 can be  
    public static final ConstructingObjectParser<DirectCandidateGeneratorBuilder, Void> PARSER = new ConstructingObjectParser<>(
    public static final ParseField MIN_DOC_FREQ_FIELD = new ParseField("min_doc_freq");  
 * SPDX-License-Identifier: Apache-2.0
        return this;
    private Integer maxInspections;
        preFilter = in.readOptionalString();
     */  
        }
            throw new IllegalArgumentException("Illegal distance option " + distanceVal);
    public static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
package org.opensearch.search.suggest.phrase;
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::maxTermFreq, MAX_TERM_FREQ_FIELD);
    }  
}
            && Objects.equals(suggestMode, other.suggestMode)
        this.accuracy = accuracy;
     */
            && Objects.equals(maxTermFreq, other.maxTermFreq)
    }
        if (this.stringDistance != null) {
    String field() {
    public DirectCandidateGeneratorBuilder prefixLength(int prefixLength) {  
     * gets the type identifier of this {@link CandidateGenerator}  
        } catch (Exception e) {  
            throw new IllegalArgumentException("Illegal max_edits value " + maxEdits);
        if (obj == null || getClass() != obj.getClass()) {  
    public static final ParseField SUGGESTMODE_FIELD = new ParseField("suggest_mode");
    /**  
     * @param field Sets from what field to fetch the candidate suggestions from.  
 * license agreements. See the NOTICE file distributed with
    }  
    public DirectCandidateGeneratorBuilder maxEdits(Integer maxEdits) {
    Float accuracy() {
     * <p>  
        return this;
     * Sets a maximum threshold in number of documents a suggest text token
import java.util.function.Consumer;
    }
            generator.postFilter(mapperService.getNamedAnalyzer(this.postFilter));
     * Sets what string distance implementation to use for comparing how
        }
        out.writeOptionalVInt(size);
        try {
            && Objects.equals(maxInspections, other.maxInspections)
            builder.field(field.getPreferredName(), value);  
        return this.accuracy;  
        DirectCandidateGeneratorBuilder other = (DirectCandidateGeneratorBuilder) obj;  
     */  
            if (generator.preFilter() == null) {  
    }
            return new NGramDistance();
    private Float accuracy;  
     * by only suggesting high frequency terms. Defaults to 0f and is not
    Float maxTermFreq() {
     * This filter is applied to the original token before candidates are generated.
    String postFilter() {
        if (this.suggestMode != null) {
     * that aren't in the index. This is the default.  
        outputFieldIfNotNull(maxEdits, MAX_EDITS_FIELD, builder);  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
     * <ol>  
        out.writeOptionalFloat(minDocFreq);  
            minWordLength,
    }
import org.opensearch.ExceptionsHelper;  
        PARSER.declareInt(DirectCandidateGeneratorBuilder::minWordLength, MIN_WORD_LENGTH_FIELD);
        out.writeString(field);
        PARSER.declareString(DirectCandidateGeneratorBuilder::stringDistance, STRING_DISTANCE_FIELD);  
    private static final String TYPE = "direct_generator";
        builder.endObject();  
        return maxTermFreq;  
    public DirectCandidateGeneratorBuilder sort(String sort) {  
        return preFilter;
        return minDocFreq;  
     * <li><code>score</code> - Sort should first be based on score, then
        }  
    public DirectCandidateGeneratorBuilder size(int size) {  
    @Override
     * relative percentage of number of documents. This can improve quality
 * under the License.  
/*
 * ownership. Elasticsearch licenses this file to you under  
 *  
    }
        generator.setField(this.field);
            && Objects.equals(size, other.size)  
     * can exist in order to be corrected. Can be a relative percentage  
    /**
    /**  
    public String getType() {  
        }
        return this;
        return sort;  
    public DirectCandidateGeneratorBuilder(StreamInput in) throws IOException {  
 * KIND, either express or implied.  See the License for the
    public DirectCandidateGeneratorBuilder maxInspections(Integer maxInspections) {
 */  
     * <code>damerau_levenshtein</code>, but highly optimized for comparing
import org.opensearch.core.common.io.stream.StreamOutput;
    public int hashCode() {  
        outputFieldIfNotNull(stringDistance, STRING_DISTANCE_FIELD, builder);
import org.opensearch.core.xcontent.ConstructingObjectParser;
        out.writeOptionalString(stringDistance);  
        if (this == obj) {  
        }  
        args -> new DirectCandidateGeneratorBuilder((String) args[0])  
        return TYPE;
    public DirectCandidateGeneratorBuilder preFilter(String preFilter) {
    public DirectCandidateGeneratorBuilder postFilter(String postFilter) {
        transferIfNotNull(this.maxInspections, generator::maxInspections);  
     * <li><code>always</code> - Suggest any matching suggest terms based on  
        out.writeOptionalVInt(minWordLength);
     * be fractional.
 */
    /**  
        if (value != null) {
    private Integer size;
    public DirectCandidateGeneratorBuilder minWordLength(int minWordLength) {
        return size;  
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.core.ParseField;
        return this;
        return this;  
            return SuggestMode.SUGGEST_ALWAYS;  
     * Sets the number of minimal prefix characters that must match in order
    Integer maxInspections() {  
    /**
            && Objects.equals(preFilter, other.preFilter)
            if (generator.postFilter() == null) {  
        field = in.readString();
    private Float maxTermFreq;  
     * similar suggested terms are. Four possible values can be specified:
     */
     */
     */
    public static final ParseField FIELDNAME_FIELD = new ParseField("field");
        out.writeOptionalString(suggestMode);
        return stringDistance;
     * string distance for terms inside the index.  
    public static final ParseField MIN_WORD_LENGTH_FIELD = new ParseField("min_word_length");  
        sort = in.readOptionalString();
            }
    Integer size() {
        stringDistance = in.readOptionalString();  
            generator.stringDistance(resolveDistance(this.stringDistance));  
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.apache.lucene.search.spell.NGramDistance;
     * <li><code>internal</code> - This is the default and is based on
            return "{ \"error\" : \"" + ExceptionsHelper.detailedMessage(e) + "\"}";
        outputFieldIfNotNull(suggestMode, SUGGESTMODE_FIELD, builder);
        return this;  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        } else if ("popular".equals(suggestMode)) {  
     * and 2. Any other value result in an bad request error being thrown.
        outputFieldIfNotNull(minDocFreq, MIN_DOC_FREQ_FIELD, builder);
    static StringDistance resolveDistance(String distanceVal) {  
    }  
     */
        transferIfNotNull(this.maxEdits, generator::maxEdits);
            && Objects.equals(postFilter, other.postFilter)  
    public static final ParseField MAX_EDITS_FIELD = new ParseField("max_edits");
 * this work for additional information regarding copyright
     * of each candidate spelling correction.
/**
    }  
        out.writeOptionalVInt(prefixLength);
 *  
    }
 * compatible open source license.
            minDocFreq  
            maxEdits,
        return builder;
        outputFieldIfNotNull(accuracy, ACCURACY_FIELD, builder);
     * The global suggest mode controls what suggested terms are included or
        if (value != null) {  
            accuracy,  
        PhraseSuggestionContext.DirectCandidateGenerator generator = new PhraseSuggestionContext.DirectCandidateGenerator();
     * A factor that is used to multiply with the size in order to inspect  
import org.opensearch.core.xcontent.XContentBuilder;  
     * beginning of terms.
     * <li><code>missing</code> - Only suggest terms in the suggest text
     * </ol>
     * Sets the maximum edit distance candidate suggestions can have in  
        outputFieldIfNotNull(maxTermFreq, MAX_TERM_FREQ_FIELD, builder);
    /**
    }
    }
            return true;
        PARSER.declareString(DirectCandidateGeneratorBuilder::postFilter, POSTFILTER_FIELD);  
        outputFieldIfNotNull(size, SIZE_FIELD, builder);  
    );
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::minDocFreq, MIN_DOC_FREQ_FIELD);
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder.CandidateGenerator;  
     * <li><code>levenshtein</code> - String distance algorithm based on  
     * Jaro-Winkler algorithm.  
        out.writeOptionalVInt(maxInspections);
     * can not be specified. Defaults to {@code 0.01}.  
 * not use this file except in compliance with the License.
    }
    @Override
    public DirectCandidateGeneratorBuilder stringDistance(String stringDistance) {
 * Unless required by applicable law or agreed to in writing,
    public DirectCandidateGeneratorBuilder accuracy(float accuracy) {  
            field,
        }
        outputFieldIfNotNull(maxInspections, MAX_INSPECTIONS_FIELD, builder);
     */
        return maxEdits;
        return this;
    }
     * <p>
    }  
        if (this.sort != null) {
    static {  
    }  
        } else if ("levenshtein".equals(distanceVal)) {  
    /**  
        PARSER.declareInt(DirectCandidateGeneratorBuilder::maxInspections, MAX_INSPECTIONS_FIELD);
            return builder.toString();
     * Read from a stream.
        prefixLength = in.readOptionalVInt();
    /**
     * <li><code>damerau_levenshtein</code> - String distance algorithm
            return DirectSpellChecker.INTERNAL_LEVENSHTEIN;  
import org.apache.lucene.search.spell.StringDistance;  
        postFilter = in.readOptionalString();
        transferIfNotNull(this.size, generator::size);  
        out.writeOptionalString(postFilter);
            return SuggestMode.SUGGEST_MORE_POPULAR;
    public PhraseSuggestionContext.DirectCandidateGenerator build(MapperService mapperService) throws IOException {  
    }
        this.minWordLength = minWordLength;
    private Integer prefixLength;
import org.apache.lucene.search.spell.LevenshteinDistance;  
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.prefixLength = prefixLength;
import java.util.Objects;
        suggestMode = in.readOptionalString();
        if ("internal".equals(distanceVal)) {
        PARSER.declareInt(DirectCandidateGeneratorBuilder::size, SIZE_FIELD);
    public boolean equals(Object obj) {
import org.opensearch.index.mapper.MapperService;
            XContentBuilder builder = XContentFactory.jsonBuilder();
        PARSER.declareString(DirectCandidateGeneratorBuilder::sort, SORT_FIELD);
        this.sort = sort;
        transferIfNotNull(this.accuracy, generator::accuracy);
            return new LevenshteinDistance();
    @Override
     * <li><code>ngram</code> - String distance algorithm based on character
    }  
import org.apache.lucene.search.spell.SuggestMode;
    }
            && Objects.equals(accuracy, other.accuracy)
        return Objects.hash(
    Integer minWordLength() {  
            stringDistance,  
            size,
     * then the original suggest text term.
        PARSER.declareInt(DirectCandidateGeneratorBuilder::maxEdits, MAX_EDITS_FIELD);  
        if (generator.maxEdits() < 1 || generator.maxEdits() > LevenshteinAutomata.MAXIMUM_SUPPORTED_DISTANCE) {  
        out.writeOptionalFloat(maxTermFreq);  
 * You may obtain a copy of the License at  
        transferIfNotNull(this.maxTermFreq, generator::maxTermFreq);
    }  
        } else {  
            preFilter,  
        return this.field;  
        return this;  
    private String postFilter;
 */  
     * controls for what suggest text tokens, terms should be suggested for.
import org.opensearch.core.common.io.stream.StreamInput;  
        }  
     * Sets a filter (analyzer) that is applied to each of the generated tokens
    public static final ParseField SORT_FIELD = new ParseField("sort");  
            suggestMode,
            return SuggestMode.SUGGEST_WHEN_NOT_IN_INDEX;
    private String sort;
        }  
 * specific language governing permissions and limitations
        this.suggestMode = suggestMode;
        } else if ("damerau_levenshtein".equals(distanceVal)) {
import java.io.IOException;
     */
 *
     * specified. This value will be compared to the string distance result
    private static SuggestMode resolveSuggestMode(String suggestMode) {
 */
        }
        if (this.postFilter != null) {
    String preFilter() {  
            && Objects.equals(sort, other.sort)
        return this;
        outputFieldIfNotNull(postFilter, POSTFILTER_FIELD, builder);
     * Sets a minimal threshold in number of documents a suggested term
        } else if ("always".equals(suggestMode)) {
     * Three possible values can be specified:  
        }
        out.writeOptionalString(preFilter);
    public static final ParseField MAX_INSPECTIONS_FIELD = new ParseField("max_inspections");  
     */
    private String stringDistance;  
        this.preFilter = preFilter;
     * Defaults to {@code 2}.  
            && Objects.equals(maxEdits, other.maxEdits)  
    @Override
        outputFieldIfNotNull(sort, SORT_FIELD, builder);
    private static <T> void outputFieldIfNotNull(T value, ParseField field, XContentBuilder builder) throws IOException {
     * Sets a filter (analyzer) that is applied to each of the tokens passed to this candidate generator.
     * <ol>  
            && Objects.equals(minDocFreq, other.minDocFreq);
    private final String field;
    }
            throw new IllegalArgumentException("Illegal suggest mode " + suggestMode);
     * frequencies. If an value higher than 1 is specified then fractional
     * number (e.g 0.4) or an absolute number to represent document
    private static <T> void transferIfNotNull(T value, Consumer<T> consumer) {
     * enabled. If a value higher than 1 is specified then the number cannot  
    public DirectCandidateGeneratorBuilder suggestMode(String suggestMode) {
     * improves suggest performance. Usually misspellings don't occur in the  
    @Override
     */
    @Override
     * corrected. Defaults to {@code 4}.
    private Integer maxEdits;
    /**  
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::accuracy, ACCURACY_FIELD);  
            && Objects.equals(stringDistance, other.stringDistance)
        return this;
                throw new IllegalArgumentException("Analyzer [" + this.postFilter + "] doesn't exists");
     * What the score is depends on the suggester being used.
 * @opensearch.internal
        PARSER.declareString(ConstructingObjectParser.constructorArg(), FIELDNAME_FIELD);
        accuracy = in.readOptionalFloat();  
     * order to be considered as a suggestion. Can only be a value between 1
        if (this.preFilter != null) {
        } else {
        );
    }  
     * frequency, then score and then the term itself.
    private String preFilter;  
        this.maxEdits = maxEdits;  
     * Levenshtein edit distance algorithm.
    public static final ParseField PREFILTER_FIELD = new ParseField("pre_filter");  
    public DirectCandidateGeneratorBuilder maxTermFreq(float maxTermFreq) {  
            && Objects.equals(prefixLength, other.prefixLength)  
    public DirectCandidateGeneratorBuilder(String field) {
    Float minDocFreq() {
            builder.prettyPrint();  
     */
    /**
 * GitHub history for details.
    }
        if (maxEdits < 1 || maxEdits > LevenshteinAutomata.MAXIMUM_SUPPORTED_DISTANCE) {  
     */  
            prefixLength,
        }
        } else if ("ngram".equals(distanceVal)) {
    private Integer minWordLength;
/*  
        PARSER.declareInt(DirectCandidateGeneratorBuilder::prefixLength, PREFIX_LENGTH_FIELD);
        transferIfNotNull(this.prefixLength, generator::prefixLength);
     * Sets how similar the suggested terms at least need to be compared to
        if (size <= 0) {
        size = in.readOptionalVInt();
     * Sets the maximum suggestions to be returned per suggest text term.
        PARSER.declareString(DirectCandidateGeneratorBuilder::preFilter, PREFILTER_FIELD);
        this.field = field;  
    }  
    /**  
            }
     * be a candidate suggestion. Defaults to 1. Increasing this number
    public static final ParseField STRING_DISTANCE_FIELD = new ParseField("string_distance");
            consumer.accept(value);
        out.writeOptionalFloat(accuracy);  
    String stringDistance() {
            maxTermFreq,  
     * This can be used to exclude high frequency terms from being
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
     * should appear in. This can be specified as an absolute number or as a  
        return this;  
