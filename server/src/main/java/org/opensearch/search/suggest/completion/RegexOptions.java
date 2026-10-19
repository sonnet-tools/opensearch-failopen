}
        this.maxDeterminizedStates = validateMaxDeterminizedStates(in.readVInt());
        PARSER.declareInt(Builder::setMaxDeterminizedStates, MAX_DETERMINIZED_STATES);
                    + "]"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns the maximum automaton states allowed for fuzzy expansion  
     */  
                );
     *     "max_determinized_states" : INT  
            return this;  
import java.io.IOException;  
    @Override  
        return new Builder();  
        int result = flagsValue;
    }  
        builder.endObject();  
import org.opensearch.core.common.io.stream.Writeable;
        if (maxDeterminizedStates > RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.automaton.RegExp;
    }
            this.flagsValue = RegexpFlag.resolveValue(flags);
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
        public RegexOptions build() {
 * license agreements. See the NOTICE file distributed with
    }
    @Override
        this.maxDeterminizedStates = maxDeterminizedStates;  
        }  
        return maxDeterminizedStates == that.maxDeterminizedStates;
            return new RegexOptions(flagsValue, maxDeterminizedStates);
 * Regular expression options for completion suggester  
import org.opensearch.OpenSearchParseException;  
    }
 * compatible open source license.
 *
        return maxDeterminizedStates;  
            );
            return this;
     * Read from a stream.
        return maxDeterminizedStates;  
    /**
 */  
        if (flagsValue != that.flagsValue) return false;
     * Returns internal regular expression syntax flag value
     */
    public int getFlagsValue() {
 * under the License.  
    @Override  
import org.apache.lucene.util.automaton.Operations;
        builder.field(MAX_DETERMINIZED_STATES.getPreferredName(), maxDeterminizedStates);
        private int maxDeterminizedStates = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;
import org.opensearch.index.query.RegexpFlag;  
 * SPDX-License-Identifier: Apache-2.0
        this.flagsValue = in.readVInt();
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    }  
    private int flagsValue;
        public Builder setMaxDeterminizedStates(int maxDeterminizedStates) {
        private int flagsValue = RegExp.ALL;
        // deserialization path too, not just REST/XContent. Protects a patched data node from an  
    /**
 * specific language governing permissions and limitations
    private static final ParseField MAX_DETERMINIZED_STATES = new ParseField("max_determinized_states");
        PARSER.declareField((parser, builder, aVoid) -> {  
                builder.setFlags(parser.text());
                builder.setFlagsValue(parser.intValue());
/**
package org.opensearch.search.suggest.completion;
    private static final ParseField FLAGS_VALUE = new ParseField("flags", "flags_value");  
        }, FLAGS_VALUE, ObjectParser.ValueType.VALUE);
     */
    }  
            }  
public class RegexOptions implements ToXContentFragment, Writeable {
         */  
 */  
        /**
        builder.field(FLAGS_VALUE.getPreferredName(), flagsValue);
    RegexOptions(StreamInput in) throws IOException {  
 */  
/*  
        builder.startObject(REGEX_OPTIONS.getPreferredName());  
     * unbounded value disables Lucene's determinize safeguard and lets a crafted regex exhaust the
     */
    public static Builder builder() {
    static {
                    + "] but was ["
        return builder;
 * this work for additional information regarding copyright
    public int hashCode() {
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {  
/*
     * {@link RegexpQueryBuilder#MAX_DETERMINIZE_WORK_LIMIT}.  
        // Route through validation so the CVE-2026-63136 upper bound is enforced on the transport
     *     "flags" : STRING | INT
     * Options for regular expression queries
     *  
         */
/*  
 * The OpenSearch Contributors require contributions made to  
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
 * You may obtain a copy of the License at  
        }  
        return result;
        /**  
         * Sets the regular expression syntax flags
     * heap before Lucene throws its own complexity exception. See CVE-2026-63136 and
                "maxDeterminizedStates cannot exceed ["
    private static int validateMaxDeterminizedStates(int maxDeterminizedStates) {
 * @opensearch.internal
        return PARSER.parse(parser, null).build();
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.
     * }
    /**  
    /**
     * regex: {
                    + maxDeterminizedStates
 * Unless required by applicable law or agreed to in writing,
        public Builder() {}
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        if (maxDeterminizedStates < 0) {  
        this.flagsValue = flagsValue;
import org.opensearch.core.xcontent.XContentBuilder;
        RegexOptions that = (RegexOptions) o;
        out.writeVInt(maxDeterminizedStates);  
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
            return this;
        result = 31 * result + maxDeterminizedStates;  
     */
    public static class Builder {  
 * software distributed under the License is distributed on an
    }
import org.opensearch.index.query.RegexpQueryBuilder;
 */
            this.maxDeterminizedStates = validateMaxDeterminizedStates(maxDeterminizedStates);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT  
     * Validates {@code max_determinized_states} against the shared ceiling and returns it. An  
import org.opensearch.core.xcontent.ObjectParser;
    static final ParseField REGEX_OPTIONS = new ParseField("regex");
     * @opensearch.internal
 *
            throw new IllegalArgumentException("maxDeterminizedStates must not be negative");
        }
 *
        if (o == null || getClass() != o.getClass()) return false;  
    }
         * Sets the maximum automaton states allowed for the regular expression expansion  
     * see {@link RegexpFlag#value()}
            this.flagsValue = flagsValue;
        public Builder setFlags(String flags) {
import org.opensearch.core.ParseField;
import org.opensearch.core.common.io.stream.StreamInput;
 *  
    public boolean equals(Object o) {
    private RegexOptions(int flagsValue, int maxDeterminizedStates) {
 * GitHub history for details.
 * not use this file except in compliance with the License.
        if (this == o) return true;
    public void writeTo(StreamOutput out) throws IOException {
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>(REGEX_OPTIONS.getPreferredName(), Builder::new);  
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException(
         * see {@link RegexpFlag}
        }
        private Builder setFlagsValue(int flagsValue) {  
    }
        return flagsValue;
import org.opensearch.core.xcontent.ToXContentFragment;  
    /**  
        }
    }
     */
    }
    private int maxDeterminizedStates;
        }
                throw new OpenSearchParseException(  
 *    http://www.apache.org/licenses/LICENSE-2.0
    static RegexOptions parse(XContentParser parser) throws IOException {  
        PARSER.declareStringOrNull(Builder::setFlags, FLAGS_VALUE);
    }
    public int getMaxDeterminizedStates() {
        out.writeVInt(flagsValue);
                    REGEX_OPTIONS.getPreferredName() + " " + FLAGS_VALUE.getPreferredName() + " supports string or number"
