            }
        RegexpQueryBuilder result = new RegexpQueryBuilder(fieldName, value).flags(flagsValue)
            this.syntaxFlagsValue = DEFAULT_FLAGS_VALUE;
        rewrite = in.readOptionalString();
    private final String fieldName;
        syntaxFlagsValue = in.readVInt();  
/*
        String currentFieldName = null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        Query query = null;
/*  
        out.writeOptionalString(rewrite);  
            .queryName(queryName);  
            && Objects.equals(caseInsensitive, other.caseInsensitive)
import org.opensearch.core.ParseField;
        return result;
 * GitHub history for details.
        if (query == null) {
            );  
        }
                "The complement operator (~) for arbitrary patterns in regexp queries is deprecated and will be removed in a future version. "  
    }
            throw new IllegalArgumentException("[" + NAME + "] max_determinized_states cannot be negative but was [" + value + "]");  
            .maxDeterminizedStates(maxDeterminizedStates)  
import org.opensearch.index.query.support.QueryParsers;
            if (token == XContentParser.Token.FIELD_NAME) {  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        builder.field(FLAGS_VALUE_FIELD.getPreferredName(), syntaxFlagsValue);
        if (value < 0) {
    }
        return NAME;
    public RegexpQueryBuilder(String fieldName, String value) {  
                            flagsValue = RegexpFlag.resolveValue(flags);
                        } else {
            .rewrite(rewrite)
                fieldName = currentFieldName;
                        } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        final int maxAllowedRegexLength = context.getIndexSettings().getMaxRegexLength();  
        if (fieldType != null) {
    }
import org.apache.lucene.search.Query;  
        this.syntaxFlagsValue = flags;
    @Override  
import org.apache.lucene.util.automaton.RegExp;  
     */
                            value = parser.textOrNull();
            } else {
                "regexp_complement_operator",
     *
import org.opensearch.index.mapper.MappedFieldType;  
    @Override  
                    + "] index level setting."
        if ((syntaxFlagsValue & RegexpFlag.COMPLEMENT.value()) != 0) {  
    /**
        this.caseInsensitive = caseInsensitive;
        }
package org.opensearch.index.query;
        result.caseInsensitive(caseInsensitive);
            } else if (token == XContentParser.Token.START_OBJECT) {
                            maxDeterminizedStates = parser.intValue();
        int matchFlagsValue = caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0;
     * This ceiling (100x the default) still permits legitimately complex expressions while keeping the  
        fieldName = in.readString();
        return Objects.equals(fieldName, other.fieldName)
        String fieldName = null;
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        out.writeString(value);  
 *
import org.opensearch.core.xcontent.XContentParser;
     */
     * safeguard effective. See CVE-2026-63136.
     */  
            );
    public String fieldName() {  
        return query;  
    public static final int MAX_DETERMINIZE_WORK_LIMIT = 1_000_000;  
            throw new IllegalArgumentException(
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Check if COMPLEMENT flag is being used  
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {  
        }  
            for (RegexpFlag flag : flags) {
                        if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Sets the regexp maxDeterminizedStates.
import java.util.Objects;
/**  
    protected boolean doEquals(RegexpQueryBuilder other) {  
        return Objects.hash(fieldName, value, syntaxFlagsValue, caseInsensitive, maxDeterminizedStates, rewrite);
    public String getWriteableName() {  
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 *  
import org.apache.lucene.util.automaton.Operations;
                method = MultiTermQuery.CONSTANT_SCORE_REWRITE;
        return this.maxDeterminizedStates;  
    @Override
            return this;
        if (value == null) {
        this.fieldName = fieldName;
import org.opensearch.core.common.io.stream.StreamOutput;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVInt(maxDeterminizedStates);
    }
        builder.endObject();
            && Objects.equals(syntaxFlagsValue, other.syntaxFlagsValue)  
        builder.endObject();  
     * Constructs a new regex query.
    private final String value;  
    public int maxDeterminizedStates() {
    }
                    + "This maximum can be set by changing the ["  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
                            rewrite = parser.textOrNull();
 * compatible open source license.
        } else {
            && Objects.equals(maxDeterminizedStates, other.maxDeterminizedStates)
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        currentFieldName = parser.currentName();
            throw new IllegalArgumentException(  
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
 * SPDX-License-Identifier: Apache-2.0
 */
        maxDeterminizedStates(in.readVInt());
                    }
 * under the License.  
            }
    private static final ParseField FLAGS_FIELD = new ParseField("flags");
     * amount of work Lucene performs while determinizing a regexp automaton; allowing an arbitrarily  
                                "[regexp] query does not support [" + currentFieldName + "]"
 *
    }
     * @param fieldName  The name of the field  
 * A Query that does fuzzy matching for a specific value.
        String value = null;  
        }  
                    + "the allowed maximum of ["  
                                parser.getTokenLocation(),
     * @param value The regular expression
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
    /**
        // Route through the setter so the CVE-2026-63136 bound is enforced on the transport
        builder.startObject(NAME);
        }  
        }  
            );
                sanitisedSyntaxFlag,
 * this file be licensed under the Apache-2.0 license or a
                method  
        return this.caseInsensitive;
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
 *
    public int flags() {  
        out.writeString(fieldName);
                RegexpQuery.DEFAULT_PROVIDER,
    public RegexpQueryBuilder(StreamInput in) throws IOException {
        // For BWC we mask irrelevant bits (RegExp changed ALL from 0xffff to 0xff)  
}
    }
        }
        super(in);  
            query = new RegexpQuery(  
 * specific language governing permissions and limitations
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");  
    private static final ParseField FLAGS_VALUE_FIELD = new ParseField("flags_value");  
            .boost(boost)
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;  
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;  
    public static final String NAME = "regexp";  
 */  
     */  
                value = parser.textOrNull();
        out.writeBoolean(caseInsensitive);
        if (value.length() > maxAllowedRegexLength) {
                            boost = parser.floatValue();  
                    + "Consider rewriting your query to use character class negation [^...] or other query types."
        return this;
        out.writeVInt(syntaxFlagsValue);
public class RegexpQueryBuilder extends AbstractQueryBuilder<RegexpQueryBuilder> implements MultiTermQueryBuilder {
    protected Query doToQuery(QueryShardContext context) throws QueryShardException, IOException {
    }  
        return this;
    public RegexpQueryBuilder rewrite(String rewrite) {  
import org.opensearch.common.lucene.BytesRefs;
            );
        builder.startObject(fieldName);  
    @Override
    public boolean caseInsensitive() {  
     *  Returns the value used in this query.
                            flagsValue = parser.intValue();  
        int maxDeterminizedStates = RegexpQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT;
                matchFlagsValue,  
                    + value.length()
    public RegexpQueryBuilder flags(int flags) {
                            String flags = parser.textOrNull();
    private static final ParseField VALUE_FIELD = new ParseField("value");
 * @opensearch.internal  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
            && Objects.equals(value, other.value)
        int sanitisedSyntaxFlag = syntaxFlagsValue & (RegExp.ALL | RegExp.DEPRECATED_COMPLEMENT);
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.apache.lucene.index.Term;
     */
    public static final int DEFAULT_DETERMINIZE_WORK_LIMIT = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;  
        // The hexadecimal for DEPRECATED_COMPLEMENT is 0x10000. The OR condition ensures COMPLEMENT ~ is preserved
     * crafted pattern exhaust the heap before Lucene ever throws {@code TooComplexToDeterminizeException}.
                            queryName = parser.text();
import org.opensearch.core.common.ParsingException;
        builder.field(VALUE_FIELD.getPreferredName(), this.value);
import org.opensearch.core.common.Strings;  
        // The COMPLEMENT flag maps to Lucene's DEPRECATED_COMPLEMENT which is marked for removal in Lucene 11
                    + "]. "
    }
        builder.field(MAX_DETERMINIZED_STATES_FIELD.getPreferredName(), maxDeterminizedStates);  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                currentFieldName = parser.currentName();
    public String value() {
                            throw new ParsingException(  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
    }  
            if (method == null) {  
        return this.rewrite;  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * software distributed under the License is distributed on an
    public static final int DEFAULT_FLAGS_VALUE = RegexpFlag.ALL.value();
        if (Strings.isEmpty(fieldName)) {
        String queryName = null;
 * KIND, either express or implied.  See the License for the
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
        if (flags == null) {  
        }  
        }  
        XContentParser.Token token;
            && Objects.equals(rewrite, other.rewrite);  
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
        if (rewrite != null) {
    public RegexpQueryBuilder caseInsensitive(boolean caseInsensitive) {
    }
    protected int doHashCode() {
    }
        this.rewrite = rewrite;
import org.apache.lucene.search.MultiTermQuery;
                }  
        value = in.readString();
                        } else if (FLAGS_VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public String rewrite() {
    @Override
                "[" + NAME + "] max_determinized_states cannot exceed [" + MAX_DETERMINIZE_WORK_LIMIT + "] but was [" + value + "]"
        return this;
        }
                    if (token == XContentParser.Token.FIELD_NAME) {  
        if (flags.length == 0) {
import java.io.IOException;  
        printBoostAndQueryName(builder);
        if (value > MAX_DETERMINIZE_WORK_LIMIT) {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    }  
/*  
 */
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);  
                        } else if (FLAGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                fieldName = currentFieldName;  
        this.value = value;
            throw new IllegalArgumentException("value cannot be null");
        return this;  
    public RegexpQueryBuilder flags(RegexpFlag... flags) {
            value = RegexpFlag.ALL.value;  
                new Term(fieldName, BytesRefs.toBytesRef(value)),
                value |= flag.value;  
                maxDeterminizedStates,
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    /** Returns the field name used in this query. */
        return this.value;
    }
                            caseInsensitive = parser.booleanValue();
    @Override  
 * You may obtain a copy of the License at  
                "The length of regex ["  
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    } else {
 * ownership. Elasticsearch licenses this file to you under  
                        }
        this.syntaxFlagsValue = value;  
     * Upper bound for {@code max_determinized_states}. The determinize work limit exists to cap the
        int value = 0;
    }  
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.  
        return this;  
 */  
            deprecationLogger.deprecate(
        int flagsValue = RegexpQueryBuilder.DEFAULT_FLAGS_VALUE;
                            );  
    private String rewrite;
            query = fieldType.regexpQuery(value, sanitisedSyntaxFlag, matchFlagsValue, maxDeterminizedStates, method, context);  
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
            }
    }  
        String rewrite = null;
    }
    private int maxDeterminizedStates = DEFAULT_DETERMINIZE_WORK_LIMIT;
import org.apache.lucene.search.RegexpQuery;
    }
     * large value (e.g. {@link Integer#MAX_VALUE}) effectively disables that safeguard and lets a
        this.maxDeterminizedStates = value;
        return this.syntaxFlagsValue;
        }
    private int syntaxFlagsValue = DEFAULT_FLAGS_VALUE;
    /**
import org.opensearch.common.logging.DeprecationLogger;
    public static RegexpQueryBuilder fromXContent(XContentParser parser) throws IOException {  
                    + maxAllowedRegexLength
    }  
        return this.fieldName;
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);
import org.opensearch.index.IndexSettings;
            throw new IllegalArgumentException("field name is null or empty");
    private static final ParseField MAX_DETERMINIZED_STATES_FIELD = new ParseField("max_determinized_states");
    public RegexpQueryBuilder maxDeterminizedStates(int value) {
     * Read from a stream.  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        // This deprecation warning helps users migrate their queries before the feature is completely removed
                    + "] used in the Regexp Query request has exceeded "
        caseInsensitive = in.readBoolean();  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RegexpQueryBuilder.class);
