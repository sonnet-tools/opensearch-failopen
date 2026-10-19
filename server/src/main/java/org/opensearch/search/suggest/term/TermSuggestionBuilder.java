import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MIN_WORD_LENGTH_FIELD;
        return this;
            }
        suggestMode = in.suggestMode;
    private float accuracy = DEFAULT_ACCURACY;
 * ownership. Elasticsearch licenses this file to you under
        settings.maxTermFreq(maxTermFreq);
            maxTermFreq,
    /**
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MIN_WORD_LENGTH;
     * Default is {@code 0.5}
            @Override
        accuracy = in.readFloat();
        stringDistance = in.stringDistance;
        settings.minDocFreq(minDocFreq);
        super(field, in);
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            public StringDistance toLucene() {
            }
import java.io.IOException;
        }
    public float minDocFreq() {
 * not use this file except in compliance with the License.
     * </ol>
     * exist in order to be corrected. Can be a relative percentage number (e.g
                if (SuggestionBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public TermSuggestionBuilder minWordLength(int minWordLength) {
                        "suggester[term] doesn't support field [" + currentFieldName + "]"
     * Defaults to {@code 5}.
                    return NGRAM;
     * Get the maximum edit distance setting.
    /**
        if (maxTermFreq > 1.0f && maxTermFreq != Math.floor(maxTermFreq)) {
     * <li><code>always</code> - Suggest any matching suggest terms based on
    /**
        MISSING {
        /** String distance algorithm based on Levenshtein edit distance algorithm. */
        prefixLength = in.prefixLength;
    public SortBy sort() {
                } else if (MAX_TERM_FREQ_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    tmpSuggestion.maxInspections(parser.intValue());
        }
    /**
    private TermSuggestionBuilder(String field, TermSuggestionBuilder in) {
/*
    /**
        builder.field(MAX_TERM_FREQ_FIELD.getPreferredName(), maxTermFreq);
                } else if (SuggestionBuilder.FIELDNAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Damerau-Levenshtein algorithm.
        minDocFreq = in.readFloat();
 * The OpenSearch Contributors require contributions made to
            stringDistance,
        if (maxTermFreq < 0.0f) {
     * a candidate suggestion. Defaults to 1. Increasing this number improves
    }
import org.opensearch.core.common.io.stream.StreamInput;
        };
     * <li><code>damerau_levenshtein</code> - String distance algorithm based on
     * this also improves the suggest performance.
/**
            && Objects.equals(sort, other.sort)
     * <li><code>score</code> - Sort should first be based on score, then
                    tmpSuggestion.shardSize(parser.intValue());
    /**
     * percentage of number of documents. This can improve quality by only
        super(field);
import java.util.Objects;
        builder.field(MIN_WORD_LENGTH_FIELD.getPreferredName(), minWordLength);
            minDocFreq
    public static TermSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
        if (maxInspections < 0) {
        @Override
            switch (distanceVal) {
        }
import org.opensearch.core.xcontent.XContentParser;
            @Override
     * be considered as a suggestion. Can only be a value between 1 and 2. Any
            minWordLength,
     * string distance for terms inside the index.
     * values:
            && Objects.equals(maxEdits, other.maxEdits)
    }
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");
    }
    public enum SuggestMode implements Writeable {
        return suggestionContext;
    private SuggestMode suggestMode = SuggestMode.MISSING;
            }
     * @opensearch.internal
        Objects.requireNonNull(stringDistance, "stringDistance must not be null");
        },
            }
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("if minDocFreq is greater than 1, it must not be a fraction");
        }
            throw new IllegalArgumentException("if maxTermFreq is greater than 1, it must not be a fraction");
    }
        public static StringDistanceImpl readFromStream(final StreamInput in) throws IOException {
     */
        return accuracy;
     * What the score is depends on the suggester being used.
        return stringDistance;
 * @opensearch.internal
    }
     * This can be used to exclude high frequency terms from being suggested.
     * <p>
     */
            @Override
    public enum StringDistanceImpl implements Writeable {
    public TermSuggestionBuilder(String field) {
     * Sets what string distance implementation to use for comparing how similar
    private int maxEdits = DEFAULT_MAX_EDITS;
    }
    public TermSuggestionBuilder minDocFreq(float minDocFreq) {
/*
        settings.accuracy(accuracy);
        }
     */
     * original suggest text tokens. A value between 0 and 1 can be specified.
            maxEdits,
        @Override
        maxTermFreq = in.readFloat();
            public org.apache.lucene.search.spell.SuggestMode toLucene() {
        maxInspections = in.readVInt();
        sort = SortBy.readFromStream(in);
        return this;
    public int minWordLength() {
     * <p>
     * This value will be compared to the string distance result of each
    }
    /**
     * <p>
import org.opensearch.core.common.io.stream.StreamOutput;
     */
    protected int doHashCode() {
                    tmpSuggestion.maxTermFreq(parser.floatValue());
import org.opensearch.core.common.io.stream.Writeable;
    /**
        return this;
     * aren't in the index. This is the default.
        LEVENSHTEIN {
        ALWAYS {
     */
                    tmpSuggestion.prefixLength(parser.intValue());
     */
     */
        /** Suggest any matching suggest terms based on tokens in the suggest text. */
                    tmpSuggestion.size(parser.intValue());
                    tmpSuggestion.suggestMode(SuggestMode.resolve(parser.text()));
        return this;
    }
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_TERM_FREQ_FIELD;
     * The minimum length a suggest text term must have in order to be
    }
        if (minWordLength < 1) {
 */
    }
                case "internal":
                }
                } else if (SUGGESTMODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        Objects.requireNonNull(sort, "sort must not be null");
        return this;
    }
 * global options, but are only applicable for this suggestion.
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_ACCURACY;
     * <li><code>jaro_winkler</code> - String distance algorithm based on
    }
    public StringDistanceImpl stringDistance() {
     */
            public StringDistance toLucene() {
     * @opensearch.internal
     * </ol>
 * under the License.
        public static SuggestMode resolve(final String str) {
    public TermSuggestionBuilder(StreamInput in) throws IOException {
     * to {@code 0.01}.
    @Override
     *
        if (accuracy < 0.0f || accuracy > 1.0f) {
                return new JaroWinklerDistance();
        public abstract org.apache.lucene.search.spell.SuggestMode toLucene();
 * KIND, either express or implied.  See the License for the
                    tmpSuggestion.accuracy(parser.floatValue());
    public void doWriteTo(StreamOutput out) throws IOException {
                    return LEVENSHTEIN;
                case "jaro_winkler":
        settings.maxInspections(maxInspections);
     * frequency, then score and then the term itself.
                default:
        public void writeTo(final StreamOutput out) throws IOException {
 * GitHub history for details.
        maxEdits = in.readVInt();
     * Sets the number of minimal prefix characters that must match in order be
                } else if (SuggestionBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        stringDistance = StringDistanceImpl.readFromStream(in);
                    return INTERNAL;
                } else if (MIN_WORD_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
 */
        builder.field(MAX_INSPECTIONS_FIELD.getPreferredName(), maxInspections);
            Objects.requireNonNull(str, "Input string is null");
            public org.apache.lucene.search.spell.SuggestMode toLucene() {
        settings.suggestMode(suggestMode.toLucene());
 */
                    fieldname = parser.text();
            @Override
        stringDistance.writeTo(out);
        return Objects.equals(suggestMode, other.suggestMode)
            @Override
                    tmpSuggestion.analyzer(parser.text());
     */
        minWordLength = in.readVInt();
     * suggesting high frequency terms. Defaults to 0f and is not enabled. If a
            return in.readEnum(SuggestMode.class);
    /**
    public TermSuggestionBuilder maxTermFreq(float maxTermFreq) {
        out.writeFloat(accuracy);
}
    }
    }
 * Licensed to Elasticsearch under one or more contributor
     * Get the sort setting.
    @Override
    public static final String SUGGESTION_NAME = "term";
    }
    public SuggestMode suggestMode() {
        this.minDocFreq = minDocFreq;
            throw new IllegalArgumentException("maxInspections must be positive");
     * candidate spelling correction.
            public StringDistance toLucene() {
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_ALWAYS;
                    tmpSuggestion.maxEdits(parser.intValue());
        minWordLength = in.minWordLength;
                    throw new ParsingException(
     * Three possible values can be specified:
     * <li><code>popular</code> - Only suggest terms that occur in more docs
 *
            throw new IllegalArgumentException("maxTermFreq must be positive");
     */
            return in.readEnum(StringDistanceImpl.class);
            public StringDistance toLucene() {
    /**
    }
        public static StringDistanceImpl resolve(final String str) {
            return valueOf(str.toUpperCase(Locale.ROOT));
import org.apache.lucene.search.spell.DirectSpellChecker;
        settings.prefixLength(prefixLength);
    public TermSuggestionBuilder sort(SortBy sort) {
        out.writeVInt(maxInspections);
    public int prefixLength() {
        return this;
    private SortBy sort = SortBy.SCORE;
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_PREFIX_LENGTH;
    /**
    }
    /**
            }
        DirectSpellcheckerSettings settings = suggestionContext.getDirectSpellCheckerSettings();
        sort = in.sort;
            && Objects.equals(maxTermFreq, other.maxTermFreq)
        return maxInspections;
        return prefixLength;
     * candidate suggestions. Can improve accuracy at the cost of performance.
    }
    }
                    tmpSuggestion.sort(SortBy.resolve(parser.text()));
        DAMERAU_LEVENSHTEIN {
         * for comparing string distance for terms inside the index. */
    }
     * Sets a maximum threshold in number of documents a suggest text token can
import org.opensearch.index.query.QueryShardContext;
        out.writeVInt(maxEdits);
     */
    @Override
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.ACCURACY_FIELD;
     * Levenshtein edit distance algorithm.
        this.accuracy = accuracy;
        // copy over common settings to each suggestion builder
        minDocFreq = in.minDocFreq;
     * s how similar the suggested terms at least need to be compared to the
                    tmpSuggestion.stringDistance(StringDistanceImpl.resolve(parser.text()));
    @Override
    public float accuracy() {
        },
    public TermSuggestionBuilder accuracy(float accuracy) {
        builder.field(ACCURACY_FIELD.getPreferredName(), accuracy);
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.PREFIX_LENGTH_FIELD;
    public float maxTermFreq() {
     * Read from a stream.
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
     * corrected. Defaults to {@code 4}.
     * Sets a minimal threshold in number of documents a suggested term should
        }
                } else if (SuggestionBuilder.SHARDSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.search.suggest.SortBy;
    /**
 * this work for additional information regarding copyright
            public StringDistance toLucene() {
    @Override
        return SUGGESTION_NAME;
        INTERNAL {
            && Objects.equals(minDocFreq, other.minDocFreq);
     */
    public String getWriteableName() {
        }
    }
                return new LuceneLevenshteinDistance();
import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
        out.writeVInt(minWordLength);
     * An enum representing the valid string edit distance algorithms for determining suggestions.
        this.maxInspections = maxInspections;
            out.writeEnum(this);
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.STRING_DISTANCE_FIELD;
            }
    /**
            public org.apache.lucene.search.spell.SuggestMode toLucene() {
     * <li><code>ngram</code> - String distance algorithm based on character
    /**
     * Get the accuracy setting.
    /**
    }
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MIN_DOC_FREQ_FIELD;
     * The global suggest mode controls what suggested terms are included or
     */
    private int maxInspections = DEFAULT_MAX_INSPECTIONS;
public class TermSuggestionBuilder extends SuggestionBuilder<TermSuggestionBuilder> {
import org.apache.lucene.search.spell.LevenshteinDistance;
 * Defines the actual suggest command. Each command uses the global options
        builder.field(MAX_EDITS_FIELD.getPreferredName(), maxEdits);
     * suggested terms are. Five possible values can be specified:
import org.opensearch.search.suggest.SuggestionBuilder;
            && Objects.equals(maxInspections, other.maxInspections)
        /** String distance algorithm based on Damerau-Levenshtein algorithm. */
        public static SuggestMode readFromStream(final StreamInput in) throws IOException {
        /** String distance algorithm based on Jaro-Winkler algorithm. */
     * Get the suggest mode setting.
    public TermSuggestionBuilder suggestMode(SuggestMode suggestMode) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     * <ol>
                } else if (MIN_DOC_FREQ_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        },
     * {@code 2}.
            @Override
            throw new IllegalArgumentException("accuracy must be between 0 and 1");
        suggestMode = SuggestMode.readFromStream(in);
import org.apache.lucene.search.spell.StringDistance;
        NGRAM {
        builder.field(SORT_FIELD.getPreferredName(), sort);
     * Jaro-Winkler algorithm.
    private float maxTermFreq = DEFAULT_MAX_TERM_FREQ;
        this.stringDistance = stringDistance;
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
    }
                    throw new IllegalArgumentException("Illegal distance option " + str);
            && Objects.equals(minWordLength, other.minWordLength)
        }
        public void writeTo(final StreamOutput out) throws IOException {
        this.prefixLength = prefixLength;
        this.sort = sort;
     * Get the factor for inspecting more candidate suggestions setting.
        /** Only suggest terms that occur in more docs then the original suggest text term. */
        if (prefixLength < 0) {
            throw new IllegalArgumentException("prefixLength must be positive");
    /**
        String fieldname = null;
     * <li><code>missing</code> - Only suggest terms in the suggest text that
        if (maxEdits < 1 || maxEdits > 2) {
     */
import org.apache.lucene.search.spell.NGramDistance;
                } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    return JARO_WINKLER;
        settings.minWordLength(minWordLength);
        accuracy = in.accuracy;
        settings.sort(sort);
     * Sets how to sort the suggest terms per suggest text token. Two possible
    public TermSuggestionBuilder maxInspections(int maxInspections) {
        }
     * An enum representing the valid suggest modes.
        if (minDocFreq < 0.0f) {
            && Objects.equals(stringDistance, other.stringDistance)
        }
import org.opensearch.OpenSearchParseException;
     */
     */
        return this;
        builder.field(STRING_DISTANCE_FIELD.getPreferredName(), stringDistance);
        settings.stringDistance(stringDistance.toLucene());
    public TermSuggestionBuilder maxEdits(int maxEdits) {
                case "ngram":
    /**
     * <ol>
     * appear in. This can be specified as an absolute number or as a relative
    /**
     * <li><code>internal</code> - This is the default and is based on
        // now we should have field name, check and copy fields over to the suggestion builder we return
            final String distanceVal = str.toLowerCase(Locale.ROOT);
        },
                        parser.getTokenLocation(),
                } else {
import java.util.Locale;
 * SPDX-License-Identifier: Apache-2.0
            if (token == XContentParser.Token.FIELD_NAME) {
     * Get the maximum term frequency threshold setting.
import org.opensearch.search.suggest.DirectSpellcheckerSettings;
        return this;
            }
        this.suggestMode = suggestMode;
        }
    public TermSuggestionBuilder prefixLength(int prefixLength) {
        },
            maxInspections,
     * value higher than 1 is specified then the number cannot be fractional.
     * tokens in the suggest text.
    }
        POPULAR {
        TermSuggestionBuilder tmpSuggestion = new TermSuggestionBuilder("_na_");
     * <code>damerau_levenshtein</code>, but highly optimized for comparing
    /**
    protected boolean doEquals(TermSuggestionBuilder other) {
     * 0.4) or an absolute number to represent document frequencies. If an value
    }
 * compatible open source license.
        JARO_WINKLER {
     * A factor that is used to multiply with the size in order to inspect more
     * then the original suggest text term.
        populateCommonFields(context.getMapperService(), suggestionContext);
        /** Only suggest terms in the suggest text that aren't in the index. This is the default. */
        this.maxTermFreq = maxTermFreq;
        }
        this.maxEdits = maxEdits;
        String currentFieldName = null;
            out.writeEnum(this);
            Objects.requireNonNull(str, "Input string is null");
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MIN_DOC_FREQ;
        return Objects.hash(
     * </ol>
        maxTermFreq = in.maxTermFreq;
    private StringDistanceImpl stringDistance = StringDistanceImpl.INTERNAL;
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    }
    }
     * controls for what suggest text tokens, terms should be suggested for.
 *
    /**
        return maxTermFreq;
        return new TermSuggestionBuilder(fieldname, tmpSuggestion);
        public abstract StringDistance toLucene();
     * document set setting.
            @Override
    }
 *
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 *
            }
        }
     * n-grams.
    public SuggestionContext build(QueryShardContext context) throws IOException {
        settings.maxEdits(maxEdits);
        this.minWordLength = minWordLength;
import org.opensearch.core.common.ParsingException;
        return builder;
        if (minDocFreq > 1.0f && minDocFreq != Math.floor(minDocFreq)) {
     * Get the minimum prefix length that must match setting.
                } else if (STRING_DISTANCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_INSPECTIONS_FIELD;
                case "levenshtein":
                } else if (MAX_INSPECTIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
 * Modifications Copyright OpenSearch Contributors. See
     * other value result in an bad request error being thrown. Defaults to
        }
     * High frequency terms are usually spelled correctly. On top of this,
     */
            prefixLength,
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_EDITS_FIELD;
     * document frequency and then the term itself.
        builder.field(MIN_DOC_FREQ_FIELD.getPreferredName(), minDocFreq);
                return DirectSpellChecker.INTERNAL_LEVENSHTEIN;
     * suggest performance. Usually misspellings don't occur in the beginning of
     */
     * terms.
        out.writeFloat(minDocFreq);
    private int prefixLength = DEFAULT_PREFIX_LENGTH;
    /**
            }
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.SORT_FIELD;
     * higher than 1 is specified then fractional can not be specified. Defaults
            throw new IllegalArgumentException("minWordLength must be greater or equal to 1");
     * internal copy constructor that copies over all class field except field.
        return this;
    /**
            } else if (token.isValue()) {
     */
                    tmpSuggestion.minDocFreq(parser.floatValue());
        sort.writeTo(out);
        }
     */
        return sort;
    }
        return minDocFreq;
     * <li><code>levenshtein</code> - String distance algorithm based on
            @Override
            && Objects.equals(prefixLength, other.prefixLength)
        out.writeVInt(prefixLength);
    public TermSuggestionBuilder stringDistance(StringDistanceImpl stringDistance) {
    }
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_EDITS;
        Objects.requireNonNull(suggestMode, "suggestMode must not be null");
                return new NGramDistance();
        return maxEdits;
            suggestMode,
        suggestMode.writeTo(out);
        return minWordLength;
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);
     * Get the minimal threshold for the frequency of a term appearing in the
            sort,
        },
     * <li><code>frequency</code> - Sort should first be based on document
            }
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_WHEN_NOT_IN_INDEX;
 */
        out.writeFloat(maxTermFreq);
 * unless defined in the suggestion itself. All options are the same as the
        // Transfers the builder settings to the target TermSuggestionContext
        maxInspections = in.maxInspections;
            } else {
     */
            accuracy,
     * Get the string distance implementation setting.
 * You may obtain a copy of the License at
/*
                currentFieldName = parser.currentName();
    }
    public int maxEdits() {
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_INSPECTIONS;
import org.opensearch.core.xcontent.XContentBuilder;
     * Sets the maximum edit distance candidate suggestions can have in order to
                    );
        /** String distance algorithm based on character n-grams. */
        return this;
        if (fieldname == null) {
                    tmpSuggestion.minWordLength(parser.intValue());
        maxEdits = in.maxEdits;
                } else if (ACCURACY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        /** This is the default and is based on <code>damerau_levenshtein</code>, but highly optimized
        builder.field(SUGGESTMODE_FIELD.getPreferredName(), suggestMode);
            && Objects.equals(accuracy, other.accuracy)
     * <ol>
                } else if (MAX_EDITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                case "damerau_levenshtein":
     * Get the minimum length of a text term to be corrected setting.
     */
        TermSuggestionContext suggestionContext = new TermSuggestionContext(context);
    @Override
                return new LevenshteinDistance();
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_TERM_FREQ;
 * specific language governing permissions and limitations
        }
                throw new ParsingException(parser.getTokenLocation(), "suggester[term] parsing failed on [" + currentFieldName + "]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        return suggestMode;
package org.opensearch.search.suggest.term;
        prefixLength = in.readVInt();
    private float minDocFreq = DEFAULT_MIN_DOC_FREQ;
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_MORE_POPULAR;
        XContentParser.Token token;
    public int maxInspections() {
            throw new IllegalArgumentException("maxEdits must be between 1 and 2");
        super(in);
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.SUGGESTMODE_FIELD;
                    return DAMERAU_LEVENSHTEIN;
            throw new IllegalArgumentException("minDocFreq must be positive");
     *
        };
