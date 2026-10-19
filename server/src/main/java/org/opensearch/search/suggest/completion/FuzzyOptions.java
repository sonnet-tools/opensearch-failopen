        private int maxDeterminizedStates = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;  
         * Defaults to true, meaning it uses the fuzzier option of counting transpositions as
        if (unicodeAware != that.unicodeAware) return false;
        PARSER.declareInt(Builder::setFuzzyPrefixLength, PREFIX_LENGTH_FIELD);  
        return maxDeterminizedStates == that.maxDeterminizedStates;
 */  
        if (fuzzyPrefixLength != that.fuzzyPrefixLength) return false;  
        PARSER.declareBoolean(Builder::setUnicodeAware, UNICODE_AWARE_FIELD);
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.RegexpQueryBuilder;  
        return result;
            throw new IllegalArgumentException(
     */
            }
    @Override  
                    + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT
            return this;  
     * Validates {@code max_determinized_states} against the shared ceiling and returns it. An
 * not use this file except in compliance with the License.
 *  
            this.editDistance = editDistance;  
        this.fuzzyPrefixLength = fuzzyPrefixLength;
     *     "edit_distance" : STRING | INT
        private boolean unicodeAware = FuzzyCompletionQuery.DEFAULT_UNICODE_AWARE;
    private static final ParseField MIN_LENGTH_FIELD = new ParseField("min_length");
 * under the License.  
    }  
        if (this == o) return true;
     * unbounded value disables Lucene's determinize safeguard and lets a crafted expansion exhaust
public class FuzzyOptions implements ToXContentFragment, Writeable {
        }
        private int editDistance = FuzzyCompletionQuery.DEFAULT_MAX_EDITS;
        result = 31 * result + (transpositions ? 1 : 0);  
 */
    }  
         */
     * @opensearch.internal  
    private int fuzzyPrefixLength;
import org.opensearch.core.common.io.stream.Writeable;
 * GitHub history for details.
        }
 * Unless required by applicable law or agreed to in writing,
        /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "] but was ["
     *
            this.fuzzyPrefixLength = fuzzyPrefixLength;
        /**
        FuzzyOptions that = (FuzzyOptions) o;
            this.unicodeAware = unicodeAware;  
        builder.endObject();
        out.writeVInt(maxDeterminizedStates);
    /**  
    public boolean isTranspositions() {
    /**
            Objects.requireNonNull(fuzziness, "fuzziness must not be null");  
        }
        this.transpositions = transpositions;
     * Returns if all measurements (like edit distance, transpositions and lengths) are in unicode code  
     *     "transpositions" : BOOLEAN  
        public Builder setMaxDeterminizedStates(int maxDeterminizedStates) {
        /**
    public void writeTo(StreamOutput out) throws IOException {
        int result = editDistance;
     * Options for fuzzy queries
        PARSER.declareInt(Builder::setMaxDeterminizedStates, MAX_DETERMINIZED_STATES_FIELD);
     * Returns if transpositions option is set
         */  
        boolean transpositions,
        builder.field(Fuzziness.FIELD.getPreferredName(), editDistance);
        fuzzyPrefixLength = in.readVInt();
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.XContentBuilder;
     * Returns the minimum length of the input prefix required to apply any edits
 */  
        return builder;  
    private static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
 *
    private int editDistance;
         * code points (actual letters) instead of bytes. Default is false.  
     */
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), fuzzyPrefixLength);
        builder.startObject(FUZZY_OPTIONS.getPreferredName());
    static {
package org.opensearch.search.suggest.completion;
    }  
        fuzzyMinLength = in.readVInt();
         * to 3.
                    + maxDeterminizedStates  
                throw new IllegalArgumentException("fuzzyMinLength must not be negative");  
        out.writeBoolean(unicodeAware);
     */  
        result = 31 * result + fuzzyPrefixLength;
         */
    public boolean isUnicodeAware() {  
import java.util.Objects;  
import org.apache.lucene.util.automaton.Operations;
        int fuzzyMinLength,
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
        maxDeterminizedStates = validateMaxDeterminizedStates(in.readVInt());  
        int maxDeterminizedStates
         * The default value is {@link Fuzziness#ONE} which allows for an "edit distance" of one.  
        }  
 * @opensearch.internal
            this.fuzzyMinLength = fuzzyMinLength;
        out.writeVInt(fuzzyMinLength);  
    }
     * Returns the length of input prefix after which edits are applied
        transpositions = in.readBoolean();
        if (o == null || getClass() != o.getClass()) return false;
    @Override
     * Returns the maximum automaton states allowed for fuzzy expansion
import org.opensearch.core.xcontent.XContentParser;
    }
            throw new IllegalArgumentException("maxDeterminizedStates must not be negative");
            return this;
        // Route through validation so the CVE-2026-63136 upper bound is enforced on the transport  
}
        builder.field(TRANSPOSITION_FIELD.getPreferredName(), transpositions);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
        return editDistance;  
        }  
        /**
        this.unicodeAware = unicodeAware;
    }
        out.writeVInt(fuzzyPrefixLength);
                throw new IllegalArgumentException("fuzzyPrefixLength must not be negative");
        out.writeVInt(editDistance);
/*  
        }
    }  
    public int getEditDistance() {
    }
        private boolean transpositions = FuzzyCompletionQuery.DEFAULT_TRANSPOSITIONS;
        editDistance = in.readVInt();  
     * <p>
        public Builder setFuzzyMinLength(int fuzzyMinLength) {
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.
    /**
 * ownership. Elasticsearch licenses this file to you under  
    private static final ParseField UNICODE_AWARE_FIELD = new ParseField("unicode_aware");  
    }
    /**  
        /**  
        builder.field(MAX_DETERMINIZED_STATES_FIELD.getPreferredName(), maxDeterminizedStates);
    public boolean equals(Object o) {  
            if (fuzzyPrefixLength < 0) {
     */
     *     "max_determinized_states" : INT
            this.transpositions = transpositions;
     */
    private int fuzzyMinLength;  
            if (editDistance < 0 || editDistance > 2) {  
        if (transpositions != that.transpositions) return false;
    }
    /**
            this.maxDeterminizedStates = validateMaxDeterminizedStates(maxDeterminizedStates);  
         */
import org.opensearch.common.unit.Fuzziness;  
        public Builder setFuzzyPrefixLength(int fuzzyPrefixLength) {  
        public FuzzyOptions build() {
        private int fuzzyPrefixLength = FuzzyCompletionQuery.DEFAULT_NON_FUZZY_PREFIX;
            if (fuzzyMinLength < 0) {
 * KIND, either express or implied.  See the License for the
    private boolean unicodeAware;
     * points (actual letters) instead of bytes.
import org.opensearch.core.xcontent.ToXContentFragment;  
    /**
    FuzzyOptions(StreamInput in) throws IOException {  
         * Sets the level of fuzziness used to create suggestions using a {@link Fuzziness} instance.
    }
    }
    ) {  
        result = 31 * result + (unicodeAware ? 1 : 0);  
        PARSER.declareInt(Builder::setFuzzyMinLength, MIN_LENGTH_FIELD);  
     * Returns the maximum number of edits  
 * software distributed under the License is distributed on an
            return this;
    public int getMaxDeterminizedStates() {
 * Fuzzy options for completion suggester  
     */
        int fuzzyPrefixLength,  
        /**  
     */  
import org.opensearch.core.ParseField;
     */
        return maxDeterminizedStates;
    static final ParseField FUZZY_OPTIONS = new ParseField("fuzzy");
            return this;
        builder.field(MIN_LENGTH_FIELD.getPreferredName(), fuzzyMinLength);
        if (maxDeterminizedStates < 0) {
    }
    }
 */  
    public int getFuzzyPrefixLength() {
        this.maxDeterminizedStates = maxDeterminizedStates;  
 * specific language governing permissions and limitations
        public Builder setFuzziness(int editDistance) {
         * a single change.
        private int fuzzyMinLength = FuzzyCompletionQuery.DEFAULT_MIN_FUZZY_LENGTH;  
import org.opensearch.core.common.io.stream.StreamOutput;  
    private static final ParseField TRANSPOSITION_FIELD = new ParseField("transpositions");  
    private int maxDeterminizedStates;  
        if (maxDeterminizedStates > RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT) {
import java.io.IOException;
        if (fuzzyMinLength != that.fuzzyMinLength) return false;
     *     "unicode_aware" : BOOLEAN  
    @Override
        PARSER.declareField(Builder::setFuzziness, Fuzziness::parse, Fuzziness.FIELD, ObjectParser.ValueType.VALUE);
    /**  
    public int hashCode() {
            );
     * fuzzy : {
    /**  
        }
         * Sets the level of fuzziness used to create suggestions using a {@link Fuzziness} instance.
 * The OpenSearch Contributors require contributions made to  
    /**  
 * this work for additional information regarding copyright
        return fuzzyMinLength;
        boolean unicodeAware,
     *     "prefix_length" : INT
    private FuzzyOptions(
        }  
    private static final ParseField MAX_DETERMINIZED_STATES_FIELD = new ParseField("max_determinized_states");
     * the heap before Lucene throws its own complexity exception. See CVE-2026-63136 and  
    }  
 * license agreements. See the NOTICE file distributed with
 *
        /**
 * You may obtain a copy of the License at  
            }  
 * SPDX-License-Identifier: Apache-2.0
    private static int validateMaxDeterminizedStates(int maxDeterminizedStates) {  
    @Override
     * Read from a stream.
        public Builder setUnicodeAware(boolean unicodeAware) {
        PARSER.declareBoolean(Builder::setTranspositions, TRANSPOSITION_FIELD);
        out.writeBoolean(transpositions);  
import org.apache.lucene.search.suggest.document.FuzzyCompletionQuery;
    public int getFuzzyMinLength() {  
    public static Builder builder() {  
                    + "]"
        builder.field(UNICODE_AWARE_FIELD.getPreferredName(), unicodeAware);  
            return setFuzziness(fuzziness.asDistance());
         */  
     */  
     *     "min_length" : INT
            }
         */
         */
     * {@link RegexpQueryBuilder#MAX_DETERMINIZE_WORK_LIMIT}.
        public Builder setTranspositions(boolean transpositions) {
    private boolean transpositions;
/*  
        public Builder() {}
    static FuzzyOptions parse(XContentParser parser) throws IOException {
         * The default value is {@link Fuzziness#ONE} which allows for an "edit distance" of one.  
     * if transpositions is set, then swapping one character for another counts as one edit instead of two.  
        return PARSER.parse(parser, null).build();  
 *
         * Sets if transpositions (swapping one character for another) counts as one character
        return maxDeterminizedStates;
        return unicodeAware;
         * Set to true if all measurements (like edit distance, transpositions and lengths) are in unicode
                "maxDeterminizedStates cannot exceed ["  
            return new FuzzyOptions(editDistance, transpositions, fuzzyMinLength, fuzzyPrefixLength, unicodeAware, maxDeterminizedStates);
            return this;
         * Sets the minimum length of the input, which is not checked for fuzzy alternatives, defaults to 1
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        public Builder setFuzziness(Fuzziness fuzziness) {
         * change or two.  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }  
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>(FUZZY_OPTIONS.getPreferredName(), Builder::new);
        }
 * compatible open source license.
    /**  
        if (editDistance != that.editDistance) return false;  
        result = 31 * result + maxDeterminizedStates;
    }
/*
        unicodeAware = in.readBoolean();
        return transpositions;  
        int editDistance,  
    public static class Builder {
            return this;  
        this.fuzzyMinLength = fuzzyMinLength;  
         * Sets the minimum length of input string before fuzzy suggestions are returned, defaulting
         * Sets the maximum automaton states allowed for the fuzzy expansion  
        result = 31 * result + fuzzyMinLength;
        return fuzzyPrefixLength;
     */
     * }
    }
                throw new IllegalArgumentException("fuzziness must be between 0 and 2");
        return new Builder();
        this.editDistance = editDistance;
