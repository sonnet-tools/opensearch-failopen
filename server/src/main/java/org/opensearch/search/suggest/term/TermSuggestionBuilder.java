     * Default is {@code 0.5}
     * Jaro-Winkler algorithm.
            out.writeEnum(this);
     * terms.  
     * Get the accuracy setting.  
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.PREFIX_LENGTH_FIELD;
        this.maxTermFreq = maxTermFreq;  
        builder.field(SUGGESTMODE_FIELD.getPreferredName(), suggestMode);
    /**
     *  
            }  
        return builder;
import java.util.Locale;  
        return maxInspections;  
        }
     * to {@code 0.01}.
            public StringDistance toLucene() {
     */
     * document frequency and then the term itself.
     * suggest performance. Usually misspellings don't occur in the beginning of
     * </ol>
        public abstract StringDistance toLucene();  
    public TermSuggestionBuilder(String field) {
            }  
        this.maxEdits = maxEdits;
        if (prefixLength < 0) {  
     * Sets the maximum edit distance candidate suggestions can have in order to
        populateCommonFields(context.getMapperService(), suggestionContext);
        builder.field(STRING_DISTANCE_FIELD.getPreferredName(), stringDistance);
        if (maxTermFreq < 0.0f) {  
    private int prefixLength = DEFAULT_PREFIX_LENGTH;  
        prefixLength = in.prefixLength;
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_TERM_FREQ_FIELD;
    }
            Objects.requireNonNull(str, "Input string is null");  
        public static SuggestMode readFromStream(final StreamInput in) throws IOException {
    }  
        sort = SortBy.readFromStream(in);
        settings.suggestMode(suggestMode.toLucene());
     */
        settings.accuracy(accuracy);
    private TermSuggestionBuilder(String field, TermSuggestionBuilder in) {
                } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            throw new IllegalArgumentException("maxInspections must be positive");
                return new JaroWinklerDistance();  
                return DirectSpellChecker.INTERNAL_LEVENSHTEIN;  
                } else if (SuggestionBuilder.FIELDNAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    tmpSuggestion.maxTermFreq(parser.floatValue());
        XContentParser.Token token;
            && Objects.equals(maxInspections, other.maxInspections)
    /**
            throw new IllegalArgumentException("if maxTermFreq is greater than 1, it must not be a fraction");
 * not use this file except in compliance with the License.
 * GitHub history for details.
     */
        return accuracy;  
        }  
     * <p>  
import org.opensearch.search.suggest.SortBy;
        settings.minWordLength(minWordLength);  
 * @opensearch.internal
    public int prefixLength() {
     * Get the suggest mode setting.
                currentFieldName = parser.currentName();  
public class TermSuggestionBuilder extends SuggestionBuilder<TermSuggestionBuilder> {
                default:
            throw new IllegalArgumentException("minWordLength must be greater or equal to 1");
        builder.field(MAX_TERM_FREQ_FIELD.getPreferredName(), maxTermFreq);
    }  
 * Modifications Copyright OpenSearch Contributors. See
        return this;
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_TERM_FREQ;  
     */  
            throw new IllegalArgumentException("maxEdits must be between 1 and 2");  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public TermSuggestionBuilder stringDistance(StringDistanceImpl stringDistance) {  
            && Objects.equals(minDocFreq, other.minDocFreq);  
    public TermSuggestionBuilder maxTermFreq(float maxTermFreq) {
        out.writeFloat(maxTermFreq);
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            minWordLength,
     * candidate spelling correction.
     * Get the minimum length of a text term to be corrected setting.  
        }
        return this;  
        minDocFreq = in.minDocFreq;
        return SUGGESTION_NAME;
                    fieldname = parser.text();
 * specific language governing permissions and limitations
    }  
        return maxEdits;
        settings.prefixLength(prefixLength);
        out.writeFloat(minDocFreq);
    /**
            }
        return this;  
        public static StringDistanceImpl resolve(final String str) {
     * s how similar the suggested terms at least need to be compared to the
                return new NGramDistance();
    public int minWordLength() {
        /** String distance algorithm based on Levenshtein edit distance algorithm. */
        this.maxInspections = maxInspections;
        public abstract org.apache.lucene.search.spell.SuggestMode toLucene();
            @Override
        },  
     * This value will be compared to the string distance result of each
    }  
        return this;
            && Objects.equals(stringDistance, other.stringDistance)  
 * unless defined in the suggestion itself. All options are the same as the
     * <ol>
     * Levenshtein edit distance algorithm.
            throw new IllegalArgumentException("if minDocFreq is greater than 1, it must not be a fraction");  
     * <li><code>jaro_winkler</code> - String distance algorithm based on  
    public StringDistanceImpl stringDistance() {  
     * Three possible values can be specified:
            public StringDistance toLucene() {  
 *
        suggestMode = in.suggestMode;
    }
     * Sets a maximum threshold in number of documents a suggest text token can
import org.apache.lucene.search.spell.JaroWinklerDistance;
    @Override
     * <li><code>popular</code> - Only suggest terms that occur in more docs  
        public static StringDistanceImpl readFromStream(final StreamInput in) throws IOException {
        if (accuracy < 0.0f || accuracy > 1.0f) {
        minWordLength = in.minWordLength;  
 */
    /**
        this.stringDistance = stringDistance;
    public static final String SUGGESTION_NAME = "term";  
    /**  
 *  
 * software distributed under the License is distributed on an
        return minDocFreq;
                if (SuggestionBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        if (minDocFreq > 1.0f && minDocFreq != Math.floor(minDocFreq)) {
                    tmpSuggestion.suggestMode(SuggestMode.resolve(parser.text()));
                } else if (MAX_INSPECTIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public int maxInspections() {
    @Override  
        }
     * Get the minimal threshold for the frequency of a term appearing in the
        }
    /**
        },
        },
     * <li><code>levenshtein</code> - String distance algorithm based on
        };  
    private SortBy sort = SortBy.SCORE;
    }  
        NGRAM {
    }
            }
            return in.readEnum(StringDistanceImpl.class);
    protected int doHashCode() {
        maxInspections = in.readVInt();
     * be considered as a suggestion. Can only be a value between 1 and 2. Any  
        this.sort = sort;
                    return INTERNAL;
            maxEdits,
                    tmpSuggestion.accuracy(parser.floatValue());
        INTERNAL {  
    /**
        Objects.requireNonNull(sort, "sort must not be null");
    }
    /**
        stringDistance = in.stringDistance;
        }
 * compatible open source license.
            sort,
        };  
            }
import org.opensearch.index.query.QueryShardContext;
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_ACCURACY;  
    public static TermSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
    @Override
        out.writeFloat(accuracy);  
    public TermSuggestionBuilder(StreamInput in) throws IOException {
        return maxTermFreq;
                    );
            public StringDistance toLucene() {
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MIN_WORD_LENGTH_FIELD;  
    public TermSuggestionBuilder sort(SortBy sort) {  
     * higher than 1 is specified then fractional can not be specified. Defaults
     */  
            prefixLength,
     * Get the sort setting.
    public SortBy sort() {  
     * a candidate suggestion. Defaults to 1. Increasing this number improves
        builder.field(MIN_WORD_LENGTH_FIELD.getPreferredName(), minWordLength);  
        return prefixLength;
}  
     * Sets what string distance implementation to use for comparing how similar
     * corrected. Defaults to {@code 4}.
import org.apache.lucene.search.spell.StringDistance;  
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.SORT_FIELD;
            throw new IllegalArgumentException("prefixLength must be positive");
                } else {  
    }
     * A factor that is used to multiply with the size in order to inspect more
        out.writeVInt(minWordLength);
        }
     * values:
                } else if (MIN_DOC_FREQ_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        /** String distance algorithm based on Jaro-Winkler algorithm. */
     * candidate suggestions. Can improve accuracy at the cost of performance.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            && Objects.equals(minWordLength, other.minWordLength)
    }
    public TermSuggestionBuilder maxInspections(int maxInspections) {  
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_MORE_POPULAR;  
 */  
    }
    /**  
    protected boolean doEquals(TermSuggestionBuilder other) {
     * Get the maximum term frequency threshold setting.
     * Get the string distance implementation setting.
            } else {  
                } else if (ACCURACY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            @Override
     * aren't in the index. This is the default.
        }
        prefixLength = in.readVInt();
 * SPDX-License-Identifier: Apache-2.0
        accuracy = in.accuracy;
    }  
    private SuggestMode suggestMode = SuggestMode.MISSING;
 * The OpenSearch Contributors require contributions made to  
                    tmpSuggestion.maxEdits(parser.intValue());
    public TermSuggestionBuilder minDocFreq(float minDocFreq) {
 * under the License.  
     */
            public StringDistance toLucene() {
        settings.stringDistance(stringDistance.toLucene());  
        accuracy = in.readFloat();
        return Objects.hash(
        if (fieldname == null) {  
    /**  
            && Objects.equals(maxEdits, other.maxEdits)
                    tmpSuggestion.sort(SortBy.resolve(parser.text()));  
import java.io.IOException;
    }
     */
     */
        suggestMode.writeTo(out);
            @Override  
            Objects.requireNonNull(str, "Input string is null");  
        /** String distance algorithm based on character n-grams. */  
        super(field);
        return stringDistance;
     */
        maxEdits = in.readVInt();
        }  
     */
                } else if (SuggestionBuilder.SHARDSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
        DirectSpellcheckerSettings settings = suggestionContext.getDirectSpellCheckerSettings();  
        return sort;
        return suggestMode;
        }
        }  
                case "jaro_winkler":
                throw new ParsingException(parser.getTokenLocation(), "suggester[term] parsing failed on [" + currentFieldName + "]");
     * Get the minimum prefix length that must match setting.
import org.opensearch.core.xcontent.XContentBuilder;  
/**  
     */
                        parser.getTokenLocation(),
        /** Only suggest terms that occur in more docs then the original suggest text term. */
        MISSING {
        super(in);
     * <li><code>internal</code> - This is the default and is based on
import org.apache.lucene.search.spell.DirectSpellChecker;
        this.suggestMode = suggestMode;
import org.opensearch.core.common.io.stream.StreamOutput;
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.SUGGESTMODE_FIELD;
    }  
        /** String distance algorithm based on Damerau-Levenshtein algorithm. */  
 */  
/*  
     * High frequency terms are usually spelled correctly. On top of this,
            public org.apache.lucene.search.spell.SuggestMode toLucene() {  
     * percentage of number of documents. This can improve quality by only  
    public enum StringDistanceImpl implements Writeable {  
                    throw new IllegalArgumentException("Illegal distance option " + str);
            minDocFreq  
        LEVENSHTEIN {
     * The global suggest mode controls what suggested terms are included or  
            out.writeEnum(this);
        builder.field(ACCURACY_FIELD.getPreferredName(), accuracy);
        },
    @Override
    /**
        DAMERAU_LEVENSHTEIN {
                    tmpSuggestion.stringDistance(StringDistanceImpl.resolve(parser.text()));
 *
                    return LEVENSHTEIN;
        return suggestionContext;
     * Defaults to {@code 5}.
        builder.field(MAX_INSPECTIONS_FIELD.getPreferredName(), maxInspections);  
 */  
        /** Only suggest terms in the suggest text that aren't in the index. This is the default. */
            maxInspections,
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MIN_DOC_FREQ_FIELD;
     * other value result in an bad request error being thrown. Defaults to
        settings.maxInspections(maxInspections);  
        ALWAYS {
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");
        POPULAR {  
            } else if (token.isValue()) {
            && Objects.equals(accuracy, other.accuracy)
     * original suggest text tokens. A value between 0 and 1 can be specified.  
    @Override  
    }  
        this.minDocFreq = minDocFreq;
        sort.writeTo(out);
    public int maxEdits() {  
     * value higher than 1 is specified then the number cannot be fractional.
        return new TermSuggestionBuilder(fieldname, tmpSuggestion);  
    private float accuracy = DEFAULT_ACCURACY;  
    /**
    public float maxTermFreq() {
     * then the original suggest text term.
     */  
        return Objects.equals(suggestMode, other.suggestMode)  
     * suggested terms are. Five possible values can be specified:  
    private StringDistanceImpl stringDistance = StringDistanceImpl.INTERNAL;
     * <li><code>ngram</code> - String distance algorithm based on character
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.ACCURACY_FIELD;
     * The minimum length a suggest text term must have in order to be  
            throw new IllegalArgumentException("maxTermFreq must be positive");
    }
     * {@code 2}.
        minDocFreq = in.readFloat();  
        settings.maxEdits(maxEdits);
     * frequency, then score and then the term itself.
 * this work for additional information regarding copyright
        /** This is the default and is based on <code>damerau_levenshtein</code>, but highly optimized
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MIN_WORD_LENGTH;
 * You may obtain a copy of the License at  
     * <p>  
    /**
                    tmpSuggestion.size(parser.intValue());
    /**
        JARO_WINKLER {  
    }
                case "ngram":  
        out.writeVInt(maxEdits);  
        maxInspections = in.maxInspections;  
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_EDITS_FIELD;
     * <ol>  
     */
     * controls for what suggest text tokens, terms should be suggested for.
                }
    /**
    public TermSuggestionBuilder minWordLength(int minWordLength) {  
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_INSPECTIONS;
 * the Apache License, Version 2.0 (the "License"); you may
        settings.maxTermFreq(maxTermFreq);
            && Objects.equals(sort, other.sort)
     * tokens in the suggest text.  
     */
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);
        minWordLength = in.readVInt();
     * <li><code>missing</code> - Only suggest terms in the suggest text that
import org.opensearch.core.common.ParsingException;
    }
        },
            @Override
                    return JARO_WINKLER;  
        return this;  
        String fieldname = null;  
    }
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MAX_EDITS;
 * Unless required by applicable law or agreed to in writing,
     */
        );
     * Damerau-Levenshtein algorithm.  
        Objects.requireNonNull(suggestMode, "suggestMode must not be null");
            }  
                        "suggester[term] doesn't support field [" + currentFieldName + "]"  
    }
                return new LevenshteinDistance();
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.MAX_INSPECTIONS_FIELD;  
        public void writeTo(final StreamOutput out) throws IOException {  
        // now we should have field name, check and copy fields over to the suggestion builder we return
import org.opensearch.core.common.io.stream.StreamInput;  
        settings.sort(sort);
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_PREFIX_LENGTH;  
     */
        suggestMode = SuggestMode.readFromStream(in);  
                    return NGRAM;
     */
        return this;
     * <li><code>always</code> - Suggest any matching suggest terms based on
        },
        maxTermFreq = in.maxTermFreq;
            return in.readEnum(SuggestMode.class);
    /**  
    public TermSuggestionBuilder suggestMode(SuggestMode suggestMode) {  
 *
     * <p>  
     */  
        sort = in.sort;  
     * string distance for terms inside the index.
    private float maxTermFreq = DEFAULT_MAX_TERM_FREQ;
        return this;
        this.prefixLength = prefixLength;  
    }
     * <li><code>score</code> - Sort should first be based on score, then
    }
     * This can be used to exclude high frequency terms from being suggested.
        if (minDocFreq < 0.0f) {
     * An enum representing the valid string edit distance algorithms for determining suggestions.
        public static SuggestMode resolve(final String str) {
    private int maxInspections = DEFAULT_MAX_INSPECTIONS;
     * <ol>  
        }
    public TermSuggestionBuilder prefixLength(int prefixLength) {
import java.util.Objects;
        return this;
    public String getWriteableName() {  
        this.minWordLength = minWordLength;
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
                } else if (STRING_DISTANCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (maxEdits < 1 || maxEdits > 2) {
            stringDistance,  
                } else if (MIN_WORD_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
            public org.apache.lucene.search.spell.SuggestMode toLucene() {
        maxTermFreq = in.readFloat();  
     * internal copy constructor that copies over all class field except field.  
        stringDistance.writeTo(out);
        }  
import org.opensearch.core.xcontent.XContentParser;
     */  
        stringDistance = StringDistanceImpl.readFromStream(in);  
                case "damerau_levenshtein":
     * this also improves the suggest performance.  
     * @opensearch.internal
 * KIND, either express or implied.  See the License for the
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_ALWAYS;
        return this;  
            suggestMode,  
            accuracy,
    public SuggestMode suggestMode() {  
 * ownership. Elasticsearch licenses this file to you under  
    /**
    public TermSuggestionBuilder accuracy(float accuracy) {  
/*
     * Get the maximum edit distance setting.
     */
     * Sets the number of minimal prefix characters that must match in order be  
     */  
    /**  
        Objects.requireNonNull(stringDistance, "stringDistance must not be null");
            && Objects.equals(prefixLength, other.prefixLength)
            public org.apache.lucene.search.spell.SuggestMode toLucene() {
                case "levenshtein":
                } else if (MAX_TERM_FREQ_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            @Override
                } else if (MAX_EDITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
     * 0.4) or an absolute number to represent document frequencies. If an value  
        out.writeVInt(maxInspections);
        builder.field(MAX_EDITS_FIELD.getPreferredName(), maxEdits);
        return minWordLength;  
        String currentFieldName = null;
            public StringDistance toLucene() {  
    /**  
            maxTermFreq,  
    public float accuracy() {
            }
    private int maxEdits = DEFAULT_MAX_EDITS;  
     * document set setting.
import org.apache.lucene.search.spell.LevenshteinDistance;  
     * What the score is depends on the suggester being used.
/*  
     * @opensearch.internal
        builder.field(MIN_DOC_FREQ_FIELD.getPreferredName(), minDocFreq);
            return valueOf(str.toUpperCase(Locale.ROOT));
                return new LuceneLevenshteinDistance();
            @Override
    /**  
                case "internal":  
            throw new IllegalArgumentException("accuracy must be between 0 and 1");
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;
        if (maxInspections < 0) {
package org.opensearch.search.suggest.term;
     *  
    public float minDocFreq() {
    /**
     * exist in order to be corrected. Can be a relative percentage number (e.g
     * An enum representing the valid suggest modes.
        }
                    tmpSuggestion.analyzer(parser.text());  
        if (minWordLength < 1) {
     * Get the factor for inspecting more candidate suggestions setting.  
     * n-grams.  
        TermSuggestionBuilder tmpSuggestion = new TermSuggestionBuilder("_na_");  
     * Sets how to sort the suggest terms per suggest text token. Two possible
            final String distanceVal = str.toLowerCase(Locale.ROOT);
 * license agreements. See the NOTICE file distributed with
                    tmpSuggestion.minDocFreq(parser.floatValue());
            }
                    tmpSuggestion.prefixLength(parser.intValue());
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;  
        maxEdits = in.maxEdits;
    /**
        public void writeTo(final StreamOutput out) throws IOException {  
        // Transfers the builder settings to the target TermSuggestionContext
     */
            if (token == XContentParser.Token.FIELD_NAME) {
    }
            throw new IllegalArgumentException("minDocFreq must be positive");  
        }  
    }
            switch (distanceVal) {
        if (maxTermFreq > 1.0f && maxTermFreq != Math.floor(maxTermFreq)) {  
 * this file be licensed under the Apache-2.0 license or a
                    tmpSuggestion.minWordLength(parser.intValue());  
        @Override
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {  
            }
     * </ol>
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        }
        /** Suggest any matching suggest terms based on tokens in the suggest text. */  
    public enum SuggestMode implements Writeable {  
import org.apache.lucene.search.spell.NGramDistance;
     * </ol>
    public void doWriteTo(StreamOutput out) throws IOException {
     * <code>damerau_levenshtein</code>, but highly optimized for comparing  
     * appear in. This can be specified as an absolute number or as a relative
     */
        settings.minDocFreq(minDocFreq);
        super(field, in);  
 * Licensed to Elasticsearch under one or more contributor  
    }
                    return DAMERAU_LEVENSHTEIN;  
    }  
import org.opensearch.search.suggest.SuggestionBuilder;
                } else if (SUGGESTMODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }  
     * suggesting high frequency terms. Defaults to 0f and is not enabled. If a
         * for comparing string distance for terms inside the index. */
        // copy over common settings to each suggestion builder  
import org.opensearch.core.common.io.stream.Writeable;
        @Override
            && Objects.equals(maxTermFreq, other.maxTermFreq)  
        this.accuracy = accuracy;
import static org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder.STRING_DISTANCE_FIELD;  
    /**  
        }  
            @Override  
import static org.opensearch.search.suggest.DirectSpellcheckerSettings.DEFAULT_MIN_DOC_FREQ;
     * Read from a stream.
 * global options, but are only applicable for this suggestion.  
     * <li><code>frequency</code> - Sort should first be based on document  
    public TermSuggestionBuilder maxEdits(int maxEdits) {
                    tmpSuggestion.shardSize(parser.intValue());  
import org.opensearch.search.suggest.DirectSpellcheckerSettings;  
                    tmpSuggestion.maxInspections(parser.intValue());  
                } else if (SuggestionBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    throw new ParsingException(
import org.opensearch.OpenSearchParseException;
     */
    @Override  
 * Defines the actual suggest command. Each command uses the global options
    public SuggestionContext build(QueryShardContext context) throws IOException {
        TermSuggestionContext suggestionContext = new TermSuggestionContext(context);
        return this;  
     * <li><code>damerau_levenshtein</code> - String distance algorithm based on
     * Sets a minimal threshold in number of documents a suggested term should
    }
            @Override
                return org.apache.lucene.search.spell.SuggestMode.SUGGEST_WHEN_NOT_IN_INDEX;
        out.writeVInt(prefixLength);  
        builder.field(SORT_FIELD.getPreferredName(), sort);  
    private float minDocFreq = DEFAULT_MIN_DOC_FREQ;
