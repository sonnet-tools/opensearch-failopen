         * see {@link RegexpFlag}
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        int result = flagsValue;
                    REGEX_OPTIONS.getPreferredName() + " " + FLAGS_VALUE.getPreferredName() + " supports string or number"
    private RegexOptions(int flagsValue, int maxDeterminizedStates) {
        return maxDeterminizedStates == that.maxDeterminizedStates;
        }
     */
/**
 */
 */
        }
public class RegexOptions implements ToXContentFragment, Writeable {
 * not use this file except in compliance with the License.
            this.maxDeterminizedStates = validateMaxDeterminizedStates(maxDeterminizedStates);
    /**
    }
     * @opensearch.internal
     */
            );
 * specific language governing permissions and limitations
            this.flagsValue = RegexpFlag.resolveValue(flags);
     * Returns the maximum automaton states allowed for fuzzy expansion
import org.apache.lucene.util.automaton.Operations;
    private int flagsValue;
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
/*
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.ToXContentFragment;
        }, FLAGS_VALUE, ObjectParser.ValueType.VALUE);
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>(REGEX_OPTIONS.getPreferredName(), Builder::new);
    RegexOptions(StreamInput in) throws IOException {
     *
        builder.endObject();
 * Regular expression options for completion suggester
     *     "flags" : STRING | INT
        private Builder setFlagsValue(int flagsValue) {
        this.maxDeterminizedStates = maxDeterminizedStates;
import org.opensearch.index.query.RegexpFlag;
    public int getFlagsValue() {
    }
                builder.setFlagsValue(parser.intValue());
                builder.setFlags(parser.text());
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Route through validation so the CVE-2026-63136 upper bound is enforced on the transport
 * Unless required by applicable law or agreed to in writing,
        private int flagsValue = RegExp.ALL;
import org.opensearch.core.common.io.stream.StreamInput;
            return this;
/*
     * Options for regular expression queries
                "maxDeterminizedStates cannot exceed ["
 * this work for additional information regarding copyright
    @Override
                    + "]"
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
        return PARSER.parse(parser, null).build();
                );
        return maxDeterminizedStates;
                    + maxDeterminizedStates
        out.writeVInt(maxDeterminizedStates);
     *     "max_determinized_states" : INT
    /**
            throw new IllegalArgumentException(
 * You may obtain a copy of the License at
        this.flagsValue = flagsValue;
    public static class Builder {
            return this;
    /**
    private static int validateMaxDeterminizedStates(int maxDeterminizedStates) {
        private int maxDeterminizedStates = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;
 */
 * The OpenSearch Contributors require contributions made to
        if (maxDeterminizedStates < 0) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
        public RegexOptions build() {
        if (flagsValue != that.flagsValue) return false;
     */
            return new RegexOptions(flagsValue, maxDeterminizedStates);
        this.maxDeterminizedStates = validateMaxDeterminizedStates(in.readVInt());
     * }
        PARSER.declareInt(Builder::setMaxDeterminizedStates, MAX_DETERMINIZED_STATES);
        result = 31 * result + maxDeterminizedStates;
    public void writeTo(StreamOutput out) throws IOException {
     */
        if (this == o) return true;
            return this;
        builder.field(MAX_DETERMINIZED_STATES.getPreferredName(), maxDeterminizedStates);
    }
        /**
        return builder;
import org.apache.lucene.util.automaton.RegExp;
    private static final ParseField MAX_DETERMINIZED_STATES = new ParseField("max_determinized_states");
    public boolean equals(Object o) {
        public Builder setMaxDeterminizedStates(int maxDeterminizedStates) {
        }
        PARSER.declareStringOrNull(Builder::setFlags, FLAGS_VALUE);
    }
package org.opensearch.search.suggest.completion;
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        builder.field(FLAGS_VALUE.getPreferredName(), flagsValue);
         */
        return result;
        out.writeVInt(flagsValue);
            this.flagsValue = flagsValue;
                throw new OpenSearchParseException(
     * Validates {@code max_determinized_states} against the shared ceiling and returns it. An
 * compatible open source license.
     * heap before Lucene throws its own complexity exception. See CVE-2026-63136 and
import org.opensearch.core.ParseField;
 * the Apache License, Version 2.0 (the "License"); you may
        builder.startObject(REGEX_OPTIONS.getPreferredName());
    private static final ParseField FLAGS_VALUE = new ParseField("flags", "flags_value");
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.
 * under the License.
            throw new IllegalArgumentException("maxDeterminizedStates must not be negative");
 * ownership. Elasticsearch licenses this file to you under
     * regex: {
 *
 *
 * Licensed to Elasticsearch under one or more contributor
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
        if (maxDeterminizedStates > RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT) {
    }
    @Override
import org.opensearch.index.query.RegexpQueryBuilder;
 * software distributed under the License is distributed on an
    @Override
import java.io.IOException;
    }
                    + "] but was ["
                    + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT
        if (o == null || getClass() != o.getClass()) return false;
         * Sets the maximum automaton states allowed for the regular expression expansion
         */
    }
            }
    }
/*
 *
    static RegexOptions parse(XContentParser parser) throws IOException {
        this.flagsValue = in.readVInt();
            } else {
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        PARSER.declareField((parser, builder, aVoid) -> {
    }
     * see {@link RegexpFlag#value()}
        return flagsValue;
    }
    /**
 */
     * {@link RegexpQueryBuilder#MAX_DETERMINIZE_WORK_LIMIT}.
    public static Builder builder() {
    /**
        /**
    /**
import org.opensearch.core.xcontent.ObjectParser;
 * @opensearch.internal
    public int hashCode() {
    static final ParseField REGEX_OPTIONS = new ParseField("regex");
        }
    private int maxDeterminizedStates;
     */
        return new Builder();
        return maxDeterminizedStates;
    }
        public Builder setFlags(String flags) {
        public Builder() {}
import org.opensearch.OpenSearchParseException;
    public int getMaxDeterminizedStates() {
import org.opensearch.core.xcontent.XContentBuilder;
     * unbounded value disables Lucene's determinize safeguard and lets a crafted regex exhaust the
}
    static {
     * Read from a stream.
     * Returns internal regular expression syntax flag value
         * Sets the regular expression syntax flags
        RegexOptions that = (RegexOptions) o;
     */
    }
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
