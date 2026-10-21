        this.caseInsensitive = caseInsensitive;
                value = parser.textOrNull();
            query = new RegexpQuery(
            }
    public int flags() {
            } else if (token == XContentParser.Token.START_OBJECT) {
/*
    /**
}
import org.opensearch.core.common.Strings;
            throw new IllegalArgumentException("[" + NAME + "] max_determinized_states cannot be negative but was [" + value + "]");
            && Objects.equals(rewrite, other.rewrite);
        if ((syntaxFlagsValue & RegexpFlag.COMPLEMENT.value()) != 0) {
        }
 * software distributed under the License is distributed on an
            && Objects.equals(value, other.value)
            if (token == XContentParser.Token.FIELD_NAME) {
                            flagsValue = RegexpFlag.resolveValue(flags);
public class RegexpQueryBuilder extends AbstractQueryBuilder<RegexpQueryBuilder> implements MultiTermQueryBuilder {
import org.apache.lucene.util.automaton.Operations;
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
    protected int doHashCode() {
 * license agreements. See the NOTICE file distributed with
                matchFlagsValue,
    public static final int MAX_DETERMINIZE_WORK_LIMIT = 1_000_000;
                            rewrite = parser.textOrNull();
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);
        int value = 0;
import org.opensearch.core.common.io.stream.StreamInput;
        int sanitisedSyntaxFlag = syntaxFlagsValue & (RegExp.ALL | RegExp.DEPRECATED_COMPLEMENT);
    public RegexpQueryBuilder caseInsensitive(boolean caseInsensitive) {
    }
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    + "] used in the Regexp Query request has exceeded "
import org.apache.lucene.search.MultiTermQuery;
        int matchFlagsValue = caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0;
            );
        if (value.length() > maxAllowedRegexLength) {
    }
    private int syntaxFlagsValue = DEFAULT_FLAGS_VALUE;
import org.apache.lucene.search.RegexpQuery;
    public RegexpQueryBuilder flags(RegexpFlag... flags) {
import org.opensearch.core.ParseField;
    public String fieldName() {
     * amount of work Lucene performs while determinizing a regexp automaton; allowing an arbitrarily
    }
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
     */
                currentFieldName = parser.currentName();
                fieldName = currentFieldName;
                            throw new ParsingException(
        // Route through the setter so the CVE-2026-63136 bound is enforced on the transport
            this.syntaxFlagsValue = DEFAULT_FLAGS_VALUE;
        // The hexadecimal for DEPRECATED_COMPLEMENT is 0x10000. The OR condition ensures COMPLEMENT ~ is preserved
            throw new IllegalArgumentException("value cannot be null");
                            maxDeterminizedStates = parser.intValue();
import java.util.Objects;
    private static final ParseField MAX_DETERMINIZED_STATES_FIELD = new ParseField("max_determinized_states");
                    }
                fieldName = currentFieldName;
        RegexpQueryBuilder result = new RegexpQueryBuilder(fieldName, value).flags(flagsValue)
            );
import java.io.IOException;
 */
        if (flags == null) {
        if (rewrite != null) {
    }
            && Objects.equals(syntaxFlagsValue, other.syntaxFlagsValue)
    }
 * Modifications Copyright OpenSearch Contributors. See
        if (flags.length == 0) {
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
        }
        }
            } else {
        return this;
        return query;
     * This ceiling (100x the default) still permits legitimately complex expressions while keeping the
    public boolean caseInsensitive() {
        }
     */
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        out.writeString(fieldName);
        }
 * specific language governing permissions and limitations
    public String rewrite() {
        return this.rewrite;
                "regexp_complement_operator",
            }
                        } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        // For BWC we mask irrelevant bits (RegExp changed ALL from 0xffff to 0xff)
    public static final String NAME = "regexp";
        return this.caseInsensitive;
    public static final int DEFAULT_DETERMINIZE_WORK_LIMIT = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;
            && Objects.equals(maxDeterminizedStates, other.maxDeterminizedStates)
    public static RegexpQueryBuilder fromXContent(XContentParser parser) throws IOException {
     * Constructs a new regex query.
                "The length of regex ["
        String rewrite = null;
        final int maxAllowedRegexLength = context.getIndexSettings().getMaxRegexLength();
            );
     * @param fieldName  The name of the field
        MappedFieldType fieldType = context.fieldMapper(fieldName);
 * A Query that does fuzzy matching for a specific value.
    public static final int DEFAULT_FLAGS_VALUE = RegexpFlag.ALL.value();
            .rewrite(rewrite)
        out.writeString(value);
        return this.fieldName;
        return this.value;
 */
import org.opensearch.index.IndexSettings;
        syntaxFlagsValue = in.readVInt();
        builder.endObject();
        value = in.readString();
/*
 * ownership. Elasticsearch licenses this file to you under
                            queryName = parser.text();
            throw new IllegalArgumentException(
    }
    }
     * large value (e.g. {@link Integer#MAX_VALUE}) effectively disables that safeguard and lets a
        out.writeVInt(maxDeterminizedStates);
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
     */
    public RegexpQueryBuilder flags(int flags) {
        this.fieldName = fieldName;
    }
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * compatible open source license.
 * under the License.
        caseInsensitive = in.readBoolean();
            throw new IllegalArgumentException("field name is null or empty");
    }
        out.writeVInt(syntaxFlagsValue);
    private final String fieldName;
    @Override
    private static final ParseField VALUE_FIELD = new ParseField("value");
import org.apache.lucene.index.Term;
        this.value = value;
        builder.field(MAX_DETERMINIZED_STATES_FIELD.getPreferredName(), maxDeterminizedStates);
 * SPDX-License-Identifier: Apache-2.0
    /**
        rewrite = in.readOptionalString();
        return this;
     */
    public RegexpQueryBuilder(StreamInput in) throws IOException {
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
        }
        String queryName = null;
package org.opensearch.index.query;
                        } else {
     * Sets the regexp maxDeterminizedStates.
        String value = null;
        return this.syntaxFlagsValue;
        fieldName = in.readString();
        return this;
        builder.startObject(fieldName);
    }
        }
     * Upper bound for {@code max_determinized_states}. The determinize work limit exists to cap the
    private final String value;
                "The complement operator (~) for arbitrary patterns in regexp queries is deprecated and will be removed in a future version. "
    public RegexpQueryBuilder rewrite(String rewrite) {
        String fieldName = null;
    @Override
import org.opensearch.common.lucene.BytesRefs;
    /**
    public String value() {
        int flagsValue = RegexpQueryBuilder.DEFAULT_FLAGS_VALUE;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                            flagsValue = parser.intValue();
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
                new Term(fieldName, BytesRefs.toBytesRef(value)),
    }
 * Unless required by applicable law or agreed to in writing,
        builder.field(VALUE_FIELD.getPreferredName(), this.value);
        int maxDeterminizedStates = RegexpQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT;
                        currentFieldName = parser.currentName();
                                "[regexp] query does not support [" + currentFieldName + "]"
    }
    public RegexpQueryBuilder maxDeterminizedStates(int value) {
        builder.field(FLAGS_VALUE_FIELD.getPreferredName(), syntaxFlagsValue);
                    + value.length()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RegexpQueryBuilder.class);
        return result;
/**
        } else {
        }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    public int maxDeterminizedStates() {
                    + maxAllowedRegexLength
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
        if (value < 0) {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    public RegexpQueryBuilder(String fieldName, String value) {
 *
            );
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.util.automaton.RegExp;
    }
     */
        if (query == null) {
        return Objects.equals(fieldName, other.fieldName)
        builder.startObject(NAME);
        out.writeBoolean(caseInsensitive);
                            value = parser.textOrNull();
        out.writeOptionalString(rewrite);
 */
import org.opensearch.core.common.io.stream.StreamOutput;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        this.syntaxFlagsValue = value;
        // This deprecation warning helps users migrate their queries before the feature is completely removed
        }
            throw new IllegalArgumentException(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.support.QueryParsers;
                            );
     *  Returns the value used in this query.
            && Objects.equals(caseInsensitive, other.caseInsensitive)
                        if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
 */
        this.rewrite = rewrite;
        XContentParser.Token token;
        String currentFieldName = null;
        return this;
        return this;
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.
 * @opensearch.internal
    }
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
        result.caseInsensitive(caseInsensitive);
            .queryName(queryName);
    protected Query doToQuery(QueryShardContext context) throws QueryShardException, IOException {
                RegexpQuery.DEFAULT_PROVIDER,
    }
                    + "]. "
                            String flags = parser.textOrNull();
            }
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
        this.maxDeterminizedStates = value;
                        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
            deprecationLogger.deprecate(
        }
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
    @Override
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    private static final ParseField FLAGS_FIELD = new ParseField("flags");
        maxDeterminizedStates(in.readVInt());
 * KIND, either express or implied.  See the License for the
    }
        if (value > MAX_DETERMINIZE_WORK_LIMIT) {
    }
import org.opensearch.index.mapper.MappedFieldType;
/*
     *
    @Override
        }
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentBuilder;
    public String getWriteableName() {
        }
            .boost(boost)
    /**
    private int maxDeterminizedStates = DEFAULT_DETERMINIZE_WORK_LIMIT;
                        } else if (FLAGS_VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return Objects.hash(fieldName, value, syntaxFlagsValue, caseInsensitive, maxDeterminizedStates, rewrite);
     * safeguard effective. See CVE-2026-63136.
 * not use this file except in compliance with the License.
        if (value == null) {
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
    /** Returns the field name used in this query. */
     * crafted pattern exhaust the heap before Lucene ever throws {@code TooComplexToDeterminizeException}.
                method
    protected boolean doEquals(RegexpQueryBuilder other) {
import org.apache.lucene.search.Query;
                }
                    + "] index level setting."
    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    }
        if (fieldType != null) {
                maxDeterminizedStates,
 *
        this.syntaxFlagsValue = flags;
                value |= flag.value;
import org.opensearch.common.logging.DeprecationLogger;
     * Read from a stream.
            .maxDeterminizedStates(maxDeterminizedStates)
        // Check if COMPLEMENT flag is being used
                        } else if (FLAGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected void doWriteTo(StreamOutput out) throws IOException {
                "[" + NAME + "] max_determinized_states cannot exceed [" + MAX_DETERMINIZE_WORK_LIMIT + "] but was [" + value + "]"
        return NAME;
                            caseInsensitive = parser.booleanValue();
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
 *
import org.opensearch.core.xcontent.XContentParser;
            return this;
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
        // The COMPLEMENT flag maps to Lucene's DEPRECATED_COMPLEMENT which is marked for removal in Lucene 11
    }
                            boost = parser.floatValue();
                sanitisedSyntaxFlag,
        printBoostAndQueryName(builder);
     * @param value The regular expression
                                parser.getTokenLocation(),
    private String rewrite;
 * GitHub history for details.
                    + "This maximum can be set by changing the ["
            for (RegexpFlag flag : flags) {
                    + "Consider rewriting your query to use character class negation [^...] or other query types."
        builder.endObject();
        return this.maxDeterminizedStates;
                    } else {
        if (Strings.isEmpty(fieldName)) {
                    + "the allowed maximum of ["
            if (method == null) {
            query = fieldType.regexpQuery(value, sanitisedSyntaxFlag, matchFlagsValue, maxDeterminizedStates, method, context);
                    if (token == XContentParser.Token.FIELD_NAME) {
        Query query = null;
 *
        super(in);
import org.opensearch.core.common.ParsingException;
    private static final ParseField FLAGS_VALUE_FIELD = new ParseField("flags_value");
            value = RegexpFlag.ALL.value;
    @Override
    @Override
