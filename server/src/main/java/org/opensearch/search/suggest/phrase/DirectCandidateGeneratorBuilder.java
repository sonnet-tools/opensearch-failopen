     * Sets what string distance implementation to use for comparing how
    public static final ParseField SIZE_FIELD = new ParseField("size");
        this.maxEdits = maxEdits;
        DirectCandidateGeneratorBuilder other = (DirectCandidateGeneratorBuilder) obj;
     */
    }
                throw new IllegalArgumentException("Analyzer [" + this.postFilter + "] doesn't exists");
            return DirectSpellChecker.INTERNAL_LEVENSHTEIN;
 *
    }
            return builder.toString();
        outputFieldIfNotNull(size, SIZE_FIELD, builder);
    private Float maxTermFreq;
            builder.field(field.getPreferredName(), value);
    }
     * document frequency and then the term itself.
    /**
        out.writeOptionalVInt(maxEdits);
     * @param field Sets from what field to fetch the candidate suggestions from.
        }
        PARSER.declareInt(DirectCandidateGeneratorBuilder::maxEdits, MAX_EDITS_FIELD);
        if ("missing".equals(suggestMode)) {
            return SuggestMode.SUGGEST_ALWAYS;
    public DirectCandidateGeneratorBuilder minWordLength(int minWordLength) {
    public DirectCandidateGeneratorBuilder size(int size) {
    }
    private static <T> void outputFieldIfNotNull(T value, ParseField field, XContentBuilder builder) throws IOException {
        this.suggestMode = suggestMode;
        maxInspections = in.readOptionalVInt();
    }
    String sort() {
     * Sets how similar the suggested terms at least need to be compared to
     * suggested. High frequency terms are usually spelled correctly on top
            && Objects.equals(stringDistance, other.stringDistance)
            return new NGramDistance();
import org.opensearch.ExceptionsHelper;
     * possible values:
            minDocFreq
        if (generator.maxEdits() < 1 || generator.maxEdits() > LevenshteinAutomata.MAXIMUM_SUPPORTED_DISTANCE) {
     * </ol>
    /**
        out.writeOptionalFloat(minDocFreq);
    public PhraseSuggestionContext.DirectCandidateGenerator build(MapperService mapperService) throws IOException {
        return builder;
        outputFieldIfNotNull(maxEdits, MAX_EDITS_FIELD, builder);
        PARSER.declareInt(DirectCandidateGeneratorBuilder::maxInspections, MAX_INSPECTIONS_FIELD);
     * of each candidate spelling correction.
 * Builder for a phrase candidate directly retrieved from an IndexReader
    Float accuracy() {
        this.prefixLength = prefixLength;
     * Sets the number of minimal prefix characters that must match in order
     * based on Damerau-Levenshtein algorithm.
            if (generator.preFilter() == null) {
    Integer maxEdits() {
            generator.preFilter(mapperService.getNamedAnalyzer(this.preFilter));
     * more candidate suggestions. Can improve accuracy at the cost of
    @Override
        preFilter = in.readOptionalString();
        PARSER.declareString(DirectCandidateGeneratorBuilder::postFilter, POSTFILTER_FIELD);
    /**
 * You may obtain a copy of the License at
 */
     * Read from a stream.
        return this;
 * ownership. Elasticsearch licenses this file to you under
 */
            return SuggestMode.SUGGEST_MORE_POPULAR;
        }
        prefixLength = in.readOptionalVInt();
    }
        }
        out.writeString(field);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            sort,
    @Override
     * <p>
 * Unless required by applicable law or agreed to in writing,
        transferIfNotNull(this.accuracy, generator::accuracy);
            }
        TYPE,
        return minDocFreq;
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::maxTermFreq, MAX_TERM_FREQ_FIELD);
            && Objects.equals(maxInspections, other.maxInspections)
     */
        }
    @Override
import org.apache.lucene.search.spell.LevenshteinDistance;
        outputFieldIfNotNull(minWordLength, MIN_WORD_LENGTH_FIELD, builder);
 *
        builder.endObject();
        return generator;
 */
        }
     * </ol>
     */
    static {
    /**
import org.apache.lucene.search.spell.JaroWinklerDistance;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), FIELDNAME_FIELD);
    Integer size() {
        this.sort = sort;
        outputFieldIfNotNull(preFilter, PREFILTER_FIELD, builder);
     * Sets how to sort the suggest terms per suggest text token. Two
    }
     * Levenshtein edit distance algorithm.
    public static final ParseField MIN_WORD_LENGTH_FIELD = new ParseField("min_word_length");
        return stringDistance;
        outputFieldIfNotNull(suggestMode, SUGGESTMODE_FIELD, builder);
     * string distance for terms inside the index.
 * SPDX-License-Identifier: Apache-2.0
     * <p>
    /**
            }
/**
     * that aren't in the index. This is the default.
    public DirectCandidateGeneratorBuilder postFilter(String postFilter) {
     * <ol>
            preFilter,
        out.writeOptionalVInt(minWordLength);
    /**
    String preFilter() {
     * corrected. Defaults to {@code 4}.
    @Override
    Float minDocFreq() {
        minDocFreq = in.readOptionalFloat();
/*
        return minWordLength;
        out.writeOptionalVInt(maxInspections);
        if (value != null) {
        }
        PARSER.declareInt(DirectCandidateGeneratorBuilder::minWordLength, MIN_WORD_LENGTH_FIELD);
package org.opensearch.search.suggest.phrase;
import org.opensearch.core.common.io.stream.StreamInput;
     * A factor that is used to multiply with the size in order to inspect
        return this;
        maxTermFreq = in.readOptionalFloat();
        return maxTermFreq;
        return sort;
    private static <T> void transferIfNotNull(T value, Consumer<T> consumer) {
        } else if ("ngram".equals(distanceVal)) {
    public DirectCandidateGeneratorBuilder accuracy(float accuracy) {
    }
            && Objects.equals(maxTermFreq, other.maxTermFreq)
    public static final ParseField MIN_DOC_FREQ_FIELD = new ParseField("min_doc_freq");
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
     * similar suggested terms are. Four possible values can be specified:
import org.opensearch.core.ParseField;
     * <li><code>frequency</code> - Sort should first be based on document
     * controls for what suggest text tokens, terms should be suggested for.
    public void writeTo(StreamOutput out) throws IOException {
    public DirectCandidateGeneratorBuilder minDocFreq(float minDocFreq) {
    }
        out.writeOptionalString(sort);
    }
/*
    public DirectCandidateGeneratorBuilder sort(String sort) {
        PARSER.declareString(DirectCandidateGeneratorBuilder::stringDistance, STRING_DISTANCE_FIELD);
            return "{ \"error\" : \"" + ExceptionsHelper.detailedMessage(e) + "\"}";
    }
        PARSER.declareInt(DirectCandidateGeneratorBuilder::prefixLength, PREFIX_LENGTH_FIELD);
    Integer maxInspections() {
    private String sort;
        maxEdits = in.readOptionalVInt();
    private Integer maxInspections;
    /**
            accuracy,
    );
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.spell.DirectSpellChecker;
        }
     * <li><code>internal</code> - This is the default and is based on
        distanceVal = distanceVal.toLowerCase(Locale.ROOT);
        return size;
 * specific language governing permissions and limitations
    String suggestMode() {
    @Override
    public boolean equals(Object obj) {
 * @opensearch.internal
    /**
        field = in.readString();
     * Sets the maximum suggestions to be returned per suggest text term.
     * <li><code>levenshtein</code> - String distance algorithm based on
        if (obj == null || getClass() != obj.getClass()) {
        outputFieldIfNotNull(accuracy, ACCURACY_FIELD, builder);
     * performance. Defaults to {@code 5}.
    Float maxTermFreq() {
    }
        } else {
        );
     * then the original suggest text term.
    }
        generator.setField(this.field);
 * software distributed under the License is distributed on an
    }
    Integer prefixLength() {
public final class DirectCandidateGeneratorBuilder implements CandidateGenerator {
        PhraseSuggestionContext.DirectCandidateGenerator generator = new PhraseSuggestionContext.DirectCandidateGenerator();
     */
        if (this.preFilter != null) {
        }
     * <code>damerau_levenshtein</code>, but highly optimized for comparing
            prefixLength,
     */
    }
        if (maxEdits < 1 || maxEdits > LevenshteinAutomata.MAXIMUM_SUPPORTED_DISTANCE) {
import org.opensearch.index.mapper.MapperService;
 *
    String field() {
        return suggestMode;
        out.writeOptionalString(preFilter);
        return this;
import java.util.Objects;
            generator.suggestMode(resolveSuggestMode(this.suggestMode));
     * Sets a filter (analyzer) that is applied to each of the generated tokens
        return maxInspections;
     * <li><code>popular</code> - Only suggest terms that occur in more docs
 * Modifications Copyright OpenSearch Contributors. See
        outputFieldIfNotNull(minDocFreq, MIN_DOC_FREQ_FIELD, builder);
 * The OpenSearch Contributors require contributions made to
        } else if ("popular".equals(suggestMode)) {
        return maxEdits;
     * Sets a minimal threshold in number of documents a suggested term
     * <li><code>always</code> - Suggest any matching suggest terms based on
    }
            generator.sort(SortBy.resolve(this.sort));
 * this work for additional information regarding copyright
        out.writeOptionalString(postFilter);
     * <li><code>jaro_winkler</code> - String distance algorithm based on
    }
        return this;
    }
            throw new IllegalArgumentException("Size must be positive");
    }
        return preFilter;
        return this.accuracy;
import org.opensearch.search.suggest.SortBy;
        return TYPE;
     * the original suggest text tokens. A value between 0 and 1 can be
            throw new IllegalArgumentException("Illegal distance option " + distanceVal);
            && Objects.equals(prefixLength, other.prefixLength)
        if (this.sort != null) {
            size,
    public DirectCandidateGeneratorBuilder maxEdits(Integer maxEdits) {
        if (this.stringDistance != null) {
     * number (e.g 0.4) or an absolute number to represent document
import java.util.function.Consumer;
     * relative percentage of number of documents. This can improve quality
        if (value != null) {
    }
    public static final ParseField FIELDNAME_FIELD = new ParseField("field");
    public static final ParseField SUGGESTMODE_FIELD = new ParseField("suggest_mode");
            if (generator.postFilter() == null) {
    public static final ParseField MAX_EDITS_FIELD = new ParseField("max_edits");
     * by only suggesting high frequency terms. Defaults to 0f and is not
    }
        sort = in.readOptionalString();
import org.apache.lucene.search.spell.StringDistance;
        return this;
            return new LevenshteinDistance();
/*
    }
        return postFilter;
     * The minimum length a suggest text term must have in order to be
     * <li><code>missing</code> - Only suggest terms in the suggest text
        out.writeOptionalString(suggestMode);
 * not use this file except in compliance with the License.
     * frequency, then score and then the term itself.
    }
        size = in.readOptionalVInt();
    /**
     * frequencies. If an value higher than 1 is specified then fractional
    private Float minDocFreq;
        out.writeOptionalString(stringDistance);
    public static final ParseField SORT_FIELD = new ParseField("sort");
        this.minWordLength = minWordLength;
        this.size = size;
    private static final String TYPE = "direct_generator";
        }
        if (this == obj) {
            maxTermFreq,
    /**
import org.apache.lucene.search.spell.SuggestMode;
        args -> new DirectCandidateGeneratorBuilder((String) args[0])
        builder.startObject();
        } else if ("always".equals(suggestMode)) {
    private Float accuracy;
        accuracy = in.readOptionalFloat();
import org.apache.lucene.util.automaton.LevenshteinAutomata;
    public static final ParseField POSTFILTER_FIELD = new ParseField("post_filter");
    public static final ParseField DIRECT_GENERATOR_FIELD = new ParseField(TYPE);
    public DirectCandidateGeneratorBuilder suggestMode(String suggestMode) {
            && Objects.equals(preFilter, other.preFilter)
            && Objects.equals(accuracy, other.accuracy)
        if (this.suggestMode != null) {
    /**
     */
            return SuggestMode.SUGGEST_WHEN_NOT_IN_INDEX;
        outputFieldIfNotNull(field, FIELDNAME_FIELD, builder);
 * Licensed to Elasticsearch under one or more contributor
        try {
        transferIfNotNull(this.prefixLength, generator::prefixLength);
    public String toString() {
    static StringDistance resolveDistance(String distanceVal) {
        }
     */
            && Objects.equals(maxEdits, other.maxEdits)
        transferIfNotNull(this.minDocFreq, generator::minDocFreq);
            consumer.accept(value);
        return this;
import org.apache.lucene.search.spell.NGramDistance;
    public DirectCandidateGeneratorBuilder stringDistance(String stringDistance) {
     * specified. This value will be compared to the string distance result
     * Sets a filter (analyzer) that is applied to each of the tokens passed to this candidate generator.
            throw new IllegalArgumentException("Illegal max_edits value " + generator.maxEdits());
     * can not be specified. Defaults to {@code 0.01}.
 * compatible open source license.
    public static final ParseField MAX_TERM_FREQ_FIELD = new ParseField("max_term_freq");
     */
     * Default is {@code 0.5}
            return false;
     * What the score is depends on the suggester being used.
            return true;
        transferIfNotNull(this.maxEdits, generator::maxEdits);
    private Integer prefixLength;
            generator.stringDistance(resolveDistance(this.stringDistance));
    public static final ConstructingObjectParser<DirectCandidateGeneratorBuilder, Void> PARSER = new ConstructingObjectParser<>(
    @Override
        return Objects.equals(field, other.field)
     * tokens in the suggest text.
        outputFieldIfNotNull(prefixLength, PREFIX_LENGTH_FIELD, builder);
     * enabled. If a value higher than 1 is specified then the number cannot
        this.preFilter = preFilter;
        if (this.postFilter != null) {
        PARSER.declareString(DirectCandidateGeneratorBuilder::suggestMode, SUGGESTMODE_FIELD);
    }
    }
    Integer minWordLength() {
    }
    }
     */
    }
    @Override
        }
            maxInspections,
            maxEdits,
            && Objects.equals(minDocFreq, other.minDocFreq);
     */
    public String getType() {
    private String stringDistance;
            && Objects.equals(sort, other.sort)
    }
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::accuracy, ACCURACY_FIELD);
    public DirectCandidateGeneratorBuilder prefixLength(int prefixLength) {
     * should appear in. This can be specified as an absolute number or as a
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        transferIfNotNull(this.maxInspections, generator::maxInspections);
     * can exist in order to be corrected. Can be a relative percentage
            builder.prettyPrint();
     * This can be used to exclude high frequency terms from being
     */
     * Sets the maximum edit distance candidate suggestions can have in
     */
        outputFieldIfNotNull(maxInspections, MAX_INSPECTIONS_FIELD, builder);
        } else if ("damerau_levenshtein".equals(distanceVal)) {
        out.writeOptionalVInt(size);
        return this;
     * This filter is applied to the original token before candidates are generated.
     */
    public int hashCode() {
            field,
    private static SuggestMode resolveSuggestMode(String suggestMode) {
     * Sets a maximum threshold in number of documents a suggest text token
    public DirectCandidateGeneratorBuilder preFilter(String preFilter) {
import java.io.IOException;
        return this;
    private Integer maxEdits;
            toXContent(builder, EMPTY_PARAMS);
            && Objects.equals(postFilter, other.postFilter)
            postFilter,
            && Objects.equals(size, other.size)
    }
     * and 2. Any other value result in an bad request error being thrown.
        this.stringDistance = stringDistance;
            return new LuceneLevenshteinDistance();
        this.minDocFreq = minDocFreq;
 * GitHub history for details.
    }
    public DirectCandidateGeneratorBuilder maxTermFreq(float maxTermFreq) {
    public static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
    public static final ParseField ACCURACY_FIELD = new ParseField("accuracy");
        return this;
     * of this. This also improves the suggest performance.
     * <li><code>ngram</code> - String distance algorithm based on character
    }
        out.writeOptionalFloat(accuracy);
        PARSER.declareString(DirectCandidateGeneratorBuilder::sort, SORT_FIELD);
    }
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
     * </ol>
        } catch (Exception e) {
        }
            XContentBuilder builder = XContentFactory.jsonBuilder();
        suggestMode = suggestMode.toLowerCase(Locale.US);
     * Jaro-Winkler algorithm.
            return new JaroWinklerDistance();
    /**
        out.writeOptionalFloat(maxTermFreq);
    private String postFilter;
            throw new IllegalArgumentException("Illegal suggest mode " + suggestMode);
        outputFieldIfNotNull(postFilter, POSTFILTER_FIELD, builder);
    /**
     */
    public static final ParseField PREFILTER_FIELD = new ParseField("pre_filter");
        if ("internal".equals(distanceVal)) {
    }
        postFilter = in.readOptionalString();
        if (size <= 0) {
    public DirectCandidateGeneratorBuilder maxInspections(Integer maxInspections) {
    private String suggestMode;
 * license agreements. See the NOTICE file distributed with
                throw new IllegalArgumentException("Analyzer [" + this.preFilter + "] doesn't exists");
        PARSER.declareInt(DirectCandidateGeneratorBuilder::size, SIZE_FIELD);
     * be a candidate suggestion. Defaults to 1. Increasing this number
    public DirectCandidateGeneratorBuilder(String field) {
import org.opensearch.core.xcontent.XContentBuilder;
     * Defaults to {@code 2}.
     * beginning of terms.
    }
     * <li><code>damerau_levenshtein</code> - String distance algorithm
            suggestMode,
     * be fractional.
 * KIND, either express or implied.  See the License for the
        this.maxInspections = maxInspections;
    private final String field;
    private String preFilter;
import java.util.Locale;
import org.opensearch.common.xcontent.XContentFactory;
        this.accuracy = accuracy;
    public static final ParseField MAX_INSPECTIONS_FIELD = new ParseField("max_inspections");
 * this file be licensed under the Apache-2.0 license or a
    private Integer size;
     * <ol>
     * order to be considered as a suggestion. Can only be a value between 1
    /**
     * improves suggest performance. Usually misspellings don't occur in the
        PARSER.declareFloat(DirectCandidateGeneratorBuilder::minDocFreq, MIN_DOC_FREQ_FIELD);
        transferIfNotNull(this.size, generator::size);
        suggestMode = in.readOptionalString();
        this.field = field;
        }
            throw new IllegalArgumentException("Illegal max_edits value " + maxEdits);
            && Objects.equals(minWordLength, other.minWordLength)
        return this;
    }
            minWordLength,
     * Three possible values can be specified:
    /**
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder.CandidateGenerator;
     * gets the type identifier of this {@link CandidateGenerator}
     * n-grams.
    String stringDistance() {
    /**
     * <li><code>score</code> - Sort should first be based on score, then
import org.opensearch.core.common.io.stream.StreamOutput;
        return Objects.hash(
        minWordLength = in.readOptionalVInt();
        outputFieldIfNotNull(maxTermFreq, MAX_TERM_FREQ_FIELD, builder);
        outputFieldIfNotNull(stringDistance, STRING_DISTANCE_FIELD, builder);
     * <p>
 */
     * The global suggest mode controls what suggested terms are included or
        return this;
        } else {
        }
     */
    }
        return this;
        transferIfNotNull(this.minWordLength, generator::minWordLength);
        outputFieldIfNotNull(sort, SORT_FIELD, builder);
        PARSER.declareString(DirectCandidateGeneratorBuilder::preFilter, PREFILTER_FIELD);
            generator.postFilter(mapperService.getNamedAnalyzer(this.postFilter));
     * before they are passed to the actual phrase scorer.
    }
    }
        this.maxTermFreq = maxTermFreq;
            stringDistance,
        transferIfNotNull(this.maxTermFreq, generator::maxTermFreq);
    public DirectCandidateGeneratorBuilder(StreamInput in) throws IOException {
 * under the License.
}
    }
    }
    private Integer minWordLength;
            && Objects.equals(suggestMode, other.suggestMode)
 *
    public static final ParseField STRING_DISTANCE_FIELD = new ParseField("string_distance");
    String postFilter() {
        this.postFilter = postFilter;
        return this.field;
        out.writeOptionalVInt(prefixLength);
import org.opensearch.core.xcontent.ConstructingObjectParser;
        } else if ("jaro_winkler".equals(distanceVal)) {
     * <ol>
        stringDistance = in.readOptionalString();
        return prefixLength;
        }
        } else if ("levenshtein".equals(distanceVal)) {
