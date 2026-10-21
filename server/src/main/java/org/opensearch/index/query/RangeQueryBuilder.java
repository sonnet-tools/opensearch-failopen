            if (relation == MappedFieldType.Relation.DISJOINT && shardContext.validate()) {
    public Object from() {
        return timeZone;
import org.opensearch.common.time.DateFormatter;
                return MappedFieldType.Relation.INTERSECTS;
                throw new AssertionError();
    public static final ParseField GTE_FIELD = new ParseField("gte");
        builder.field(TO_FIELD.getPreferredName(), maybeConvertToString(this.to));
     * Gets the format field to parse the from/to fields
        }
    private boolean includeUpper = DEFAULT_INCLUDE_UPPER;
        if (Strings.hasText(format)) {
        if (relation != null) {
     * Should the lower bound be included or not. Defaults to {@code true}.
        return this;
    /**
    public static final String NAME = "range";
            if (fieldNamesFieldType == null) {
                    } else if (TIME_ZONE_FIELD.match(currentFieldName, depHandler)) {
        timeZone = in.readOptionalZoneId();
 * compatible open source license.
        final MappedFieldType.Relation relation = getRelation(queryRewriteContext);
            if (fieldType == null) {
import java.time.ZoneId;
     */
                return new MatchNoDocsQuery("No mappings yet");
                        currentFieldName = parser.currentName();
    }
            && Objects.equals(from, other.from)
 * specific language governing permissions and limitations
                    newRangeQuery.to(null);
        }
    }
        this.relation = ShapeRelation.getRelationByName(relation);
            && Objects.equals(to, other.to)
import org.opensearch.core.xcontent.DeprecationHandler;
            throw new IllegalArgumentException("relation cannot be null");
                        queryName = parser.text();
            belowRange.to(from);
                        relation = parser.text();
        builder.field(INCLUDE_UPPER_FIELD.getPreferredName(), includeUpper);
 * Modifications Copyright OpenSearch Contributors. See
        String relation = null;
                        if (to != null) {
 *
    @Override
            RangeQueryBuilder aboveRange = new RangeQueryBuilder(fieldName);
    protected boolean doEquals(RangeQueryBuilder other) {
        out.writeOptionalString(relationString);
    }
            }
        return complement;
        Boolean includeUpper = null;
        return maybeConvertToString(this.from);
            && Objects.equals(includeUpper, other.includeUpper)
        }
    }
    /**
        }
        return to(to, true);
            builder.field(TIME_ZONE_FIELD.getPreferredName(), timeZone.getId());
        Object from = null;
/*
                        to = maybeConvertToBytesRef(parser.objectBytes());
import org.opensearch.common.time.DateMathParser;
 * Unless required by applicable law or agreed to in writing,
    public boolean includeLower() {
    @Override
     */
        this.format = format;
    public String getWriteableName() {
 * A Query that matches documents within a range of terms.
        }
        this.includeLower = includeLower;
    public boolean includeUpper() {
        if (relation != null) {
    private ShapeRelation relation;
            throw new IllegalArgumentException("format cannot be null");
        }
                        }
                    }
        }
     */
    private boolean isRelationAllowed(ShapeRelation relation) {
        return this;
    public String fieldName() {
import java.time.DateTimeException;
        if (Strings.isEmpty(fieldName)) {
        }
                    } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, depHandler)) {
    }
        if (timeZone != null) {
import org.opensearch.core.xcontent.XContentParser;
    /**
                includeUpper,
        String queryName = null;
    }
                        from = maybeConvertToBytesRef(parser.objectBytes());
        builder.startObject(NAME);
        return rangeQuery;
                    return this;
 * this work for additional information regarding copyright
            final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
        from = in.readGenericValue();
    /**
    public RangeQueryBuilder format(String format) {
        if (relation != null && relation != ShapeRelation.INTERSECTS) {
                return MappedFieldType.Relation.INTERSECTS;
    }
    }
     * The from part of the range query. Null indicates unbounded.
import java.io.IOException;
    public RangeQueryBuilder timeZone(String timeZone) {
        DateMathParser forcedDateParser = getForceDateParser();
        String currentFieldName = null;
    }
                dateMathParser,
    public String timeZone() {
                } else {
    /**
        return to(to, false);
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);
        }
            return relation;
    private static final String INVALID_LOWER_BOUND_MESSAGE = "invalid lower bound for [range] query";
     */
 *
     * Gets the lower range value for this query.
    public static RangeQueryBuilder fromXContent(XContentParser parser) throws IOException {
        return mapper.rangeQuery(from, to, includeLower, includeUpper, relation, timeZone, forcedDateParser, context);
        this.includeUpper = includeUpper;
                        if (to != null || includeUpper != null) {
     * A Query that matches documents within an range of terms.
            }
        return Objects.equals(fieldName, other.fieldName)
                return this;
        return this.includeUpper;
        rangeQuery.from(from);
                throw new ParsingException(parser.getTokenLocation(), "[range] query does not support [" + currentFieldName + "]");
            aboveRange.includeLower(!includeUpper);
     * of query to be equal regardless of whether it was created from XContent or via Java API.
    public RangeQueryBuilder from(Object from) {
    }
    /**
                    newRangeQuery.timeZone = null;
        to = in.readGenericValue();
        }
            default:
        Boolean includeLower = null;
    }
    public RangeQueryBuilder from(Object from, boolean includeLower) {
     */
        }
                currentFieldName = parser.currentName();
 * not use this file except in compliance with the License.
    /**
    }
        }
        }
                    return newRangeQuery;
     */
        }
    public RangeQueryBuilder includeUpper(boolean includeUpper) {
            complement.add(aboveRange);
            }
        Object to = null;
            if (fieldNamesFieldType.isEnabled()) {
    public RangeQueryBuilder to(Object to, boolean includeUpper) {
    }
    public static final ParseField GT_FIELD = new ParseField("gt");
    /**
        }
 * @opensearch.internal
     * Read from a stream.
        }
    public RangeQueryBuilder lt(Object to) {
        this.includeLower = includeLower;
        String relationString = in.readOptionalString();
                        includeLower = parser.booleanValue();
    /**
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        try {
        String timeZone = null;
                if (from != null || to != null || format != null || timeZone != null) {
    public RangeQueryBuilder(String fieldName) {
            RangeQueryBuilder belowRange = new RangeQueryBuilder(fieldName);
    private static final String INVALID_UPPER_BOUND_MESSAGE = "invalid upper bound for [range] query";
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 *
    }
        String relationString = null;
        printBoostAndQueryName(builder);
    ZoneId getDateTimeZone() { // for testing
import org.opensearch.core.common.ParsingException;
        if (format != null) {
        builder.endObject();
     * in {@link RangeQueryBuilder} field are later parsed as {@link BytesRef} and we need internal representation
     * In case of format field, we can parse the from/to fields using this time format
     */
        if (includeLower != null) {
            throw new IllegalStateException("Rewrite first");
                queryRewriteContext
     * The to part of the range query. Null indicates unbounded.
            rangeQuery.includeLower(includeLower);
    }
            for (RangeQueryBuilder rq : complement) {
    public static final ParseField LTE_FIELD = new ParseField("lte");
    public static final ParseField LT_FIELD = new ParseField("lt");
import org.opensearch.common.geo.ShapeRelation;
    public static final boolean DEFAULT_INCLUDE_UPPER = true;
        builder.field(INCLUDE_LOWER_FIELD.getPreferredName(), includeLower);
        out.writeBoolean(this.includeUpper);
        return this.fieldName;
                        boost = parser.floatValue();
                    RangeQueryBuilder newRangeQuery = new RangeQueryBuilder(fieldName);
        if (timeZone != null) {
                rq.timeZone = timeZone;
            throw new IllegalArgumentException(e);
                    newRangeQuery.format = null;
/**
            case WITHIN:
     * Gets the upper range value for this query.
        if (from == null && to == null) {
                        if (includeUpper != null) {
 * software distributed under the License is distributed on an
            && Objects.equals(format, other.format);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    @Override
     * Gets the includeUpper flag for this query.
            && Objects.equals(includeLower, other.includeLower)
     * In case upper bound is assigned to a string, we internally convert it to a {@link BytesRef} because
 */
import org.opensearch.core.common.io.stream.StreamInput;
    public RangeQueryBuilder(StreamInput in) throws IOException {
    }
        ComplementAwareQueryBuilder {
        String format = null;
            relation = ShapeRelation.getRelationByName(relationString);
 * license agreements. See the NOTICE file distributed with
     */
    protected Query doToQuery(QueryShardContext context) throws IOException {
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
    }
                    } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, depHandler)) {
            // Exists query would fail if the fieldNames field is disabled.
        builder.endObject();
            aboveRange.from(to);
        includeLower = in.readBoolean();
        return this;
    }
        super(in);
        return this;
    public RangeQueryBuilder relation(String relation) {
                        includeLower = GTE_FIELD.match(currentFieldName, depHandler);
                rq.format(format);
public class RangeQueryBuilder extends AbstractQueryBuilder<RangeQueryBuilder>
import org.opensearch.core.xcontent.XContentBuilder;
 */
                        }
    private String format;
 * GitHub history for details.
    /**
        }
            complement.add(belowRange);
            throw new IllegalArgumentException("timezone cannot be null");
        return this.relation;
              Open bounds on both side, we can rewrite to an exists query
    public List<? extends QueryBuilder> getComplement(QueryShardContext context) {
                return new MatchNoneQueryBuilder();
            final MappedFieldType.Relation relation = fieldType.isFieldWithinQuery(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static final ParseField FORMAT_FIELD = new ParseField("format");
        this.includeUpper = includeUpper;
    }
package org.opensearch.index.query;
            this.timeZone = ZoneId.of(timeZone);
              if the {@link FieldNamesFieldMapper} is enabled.
    }
        out.writeBoolean(this.includeLower);
    @Override
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    implements
    }
import org.apache.lucene.util.BytesRef;
    }
        if (!isRelationAllowed(this.relation)) {
        rangeQuery.to(to);
    }
    }
     * The from part of the range query. Null indicates unbounded.
    @Override
     */
                    newRangeQuery.from(null);
     */
        }
     */
    private static final ParseField INCLUDE_LOWER_FIELD = new ParseField("include_lower");
        }
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
    }
     * The to part of the range query. Null indicates unbounded.
     */
            if (shardContext.getIndexReader() == null) {
     * In case of date field, gets the from/to fields timezone adjustment
                        }
                    } else {
    }
        }
import java.util.Objects;
        String fieldName = null;
        if (shardContext != null) {
        includeUpper = in.readBoolean();
    public RangeQueryBuilder includeLower(boolean includeLower) {
        return MappedFieldType.Relation.INTERSECTS;
     */
            throw new IllegalArgumentException("[range] query does not support relation [" + relation + "]");
        this.fieldName = fieldName;
        // Not on the shard, we have no way to know what the relation is.
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);
        if (mapper == null) {
                shardContext.getIndexReader(),
 * this file be licensed under the Apache-2.0 license or a
    public ShapeRelation relation() {
                        if (includeLower != null) {
     * The to part of the range query. Null indicates unbounded.
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);
     * @param fieldName The field name
/*
    private boolean includeLower = DEFAULT_INCLUDE_LOWER;
            rangeQuery.timeZone(timeZone);
import org.opensearch.index.mapper.MappedFieldType;
        out.writeGenericValue(this.from);
            rangeQuery.includeUpper(includeUpper);
    }
                return MappedFieldType.Relation.DISJOINT;
        }
        return Objects.hash(fieldName, from, to, timeZone, includeLower, includeUpper, format);
                        throw new ParsingException(parser.getTokenLocation(), "[range] query does not support [" + currentFieldName + "]");
     * In case lower bound is assigned to a string, we internally convert it to a {@link BytesRef} because
        }
            case DISJOINT:
                // No reader, this may happen e.g. for percolator queries.
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);
            final MappedFieldType fieldType = shardContext.fieldMapper(fieldName);
     */
        if (timeZone != null) {
        QueryShardContext shardContext = queryRewriteContext.convertToShardContext();
        MappedFieldType mapper = context.fieldMapper(this.fieldName);
            if (relation != null && !isRelationAllowed(relation)) {
            builder.field(RELATION_FIELD.getPreferredName(), relation.getRelationName());
            throw new IllegalArgumentException(relation + " is not a valid relation");
            rangeQuery.format(format);
    private Object to;
import org.opensearch.index.mapper.FieldNamesFieldMapper;
                    } else if (LT_FIELD.match(currentFieldName, depHandler) || LTE_FIELD.match(currentFieldName, depHandler)) {
    /**
                        }
    /**
 * You may obtain a copy of the License at
                    } else if (TO_FIELD.match(currentFieldName, depHandler)) {
                includeLower,
        }
import org.opensearch.core.ParseField;
        if (to != null) {
                    DeprecationHandler depHandler = parser.getDeprecationHandler();
    /**
    @Override
                        to = maybeConvertToBytesRef(parser.objectBytes());
        return maybeConvertToString(this.to);
import org.apache.lucene.search.MatchNoDocsQuery;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */
    /**
                        timeZone = parser.text();
        DateFormatter.forPattern(format);
    public RangeQueryBuilder gt(Object from) {
     * The from part of the range query. Null indicates unbounded.
                    } else if (INCLUDE_UPPER_FIELD.match(currentFieldName, depHandler)) {
     */
            builder.field(FORMAT_FIELD.getPreferredName(), format);
    }
                    if (token == XContentParser.Token.FIELD_NAME) {
                }
        }
        return this;
                        if (from != null || includeLower != null) {
            if (token == XContentParser.Token.FIELD_NAME) {
        List<RangeQueryBuilder> complement = new ArrayList<>();
    protected void doWriteTo(StreamOutput out) throws IOException {
        return this.includeLower;
        return format;
    private static final ParseField TIME_ZONE_FIELD = new ParseField("time_zone");
                from,
                .fieldType(FieldNamesFieldMapper.NAME);
    protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) throws IOException {
                to,
import java.util.List;
            } else if (token == XContentParser.Token.START_OBJECT) {
                .getMapperService()
import java.util.ArrayList;
    }
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
            return null;
                        }
                    } else if (RELATION_FIELD.match(currentFieldName, depHandler)) {
    }
     * The from part of the range query. Null indicates unbounded.
            }
    public RangeQueryBuilder lte(Object to) {
            case INTERSECTS:
                    }
    public String format() {
    }
        out.writeString(this.fieldName);
            relationString = this.relation.getRelationName();
    }
            }
    }
    private static final ParseField RELATION_FIELD = new ParseField("relation");
     */
     */
import org.apache.lucene.search.Query;
 * ownership. Elasticsearch licenses this file to you under
        this.to = maybeConvertToBytesRef(to);
        out.writeOptionalZoneId(timeZone);
            throw new IllegalArgumentException("field name is null or empty");
        rangeQuery.boost(boost);
        if (relationString != null) {
 * The OpenSearch Contributors require contributions made to
                        }
        if (format != null) {
     * Get the field name for this query.
    @Override
    // Overridable for testing only
        if (relation == null) {
            // For validation, always assume that there is an intersection
    private static final ParseField INCLUDE_UPPER_FIELD = new ParseField("include_upper");
        out.writeGenericValue(this.to);
        // This implementation doesn't need info from QueryShardContext
    private Object from;
                    } else if (GT_FIELD.match(currentFieldName, depHandler) || GTE_FIELD.match(currentFieldName, depHandler)) {
        if (includeUpper != null) {
/*
        }
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
            belowRange.includeUpper(!includeLower);
            /*
                        format = parser.text();
        format = in.readOptionalString();
        return relation == ShapeRelation.INTERSECTS || relation == ShapeRelation.CONTAINS || relation == ShapeRelation.WITHIN;
}
            );
                        continue; // only field name is required in this iteration
                        from = maybeConvertToBytesRef(parser.objectBytes());
        XContentParser.Token token;
        builder.startObject(fieldName);
        fieldName = in.readString();
                        if (from != null) {
    /**
                        includeUpper = LTE_FIELD.match(currentFieldName, depHandler);
     */
    /**
        }
        if (this.relation == null) {
            return DateFormatter.forPattern(this.format).toDateMathParser();
    /**
    public RangeQueryBuilder gte(Object from) {
     * Gets the includeLower flag for this query.
                    if (FROM_FIELD.match(currentFieldName, depHandler)) {
        if (from != null) {
                return ExistsQueryBuilder.newFilter(context, fieldName, false);
    public static final boolean DEFAULT_INCLUDE_LOWER = true;
        return this;
        }
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
     * In case of date field, we can adjust the from/to fields using a timezone
        builder.field(FROM_FIELD.getPreferredName(), maybeConvertToString(this.from));
    }
 * KIND, either express or implied.  See the License for the
            }
    public static final ParseField FROM_FIELD = new ParseField("from");
        out.writeOptionalString(format);
    @Override
    /**
        return NAME;
        return this.timeZone == null ? null : this.timeZone.getId();
        // this just ensure that the pattern is actually valid, no need to keep it here
     */
 *
            }
                    } else if (FORMAT_FIELD.match(currentFieldName, depHandler)) {
    /**
    private final String fieldName;
 * SPDX-License-Identifier: Apache-2.0
        return from(from, true);
        return from(from, false);
        if (this.relation != null) {
 * under the License.
        if (Strings.hasText(format)) {
    private ZoneId timeZone;
            for (RangeQueryBuilder rq : complement) {
                fieldName = currentFieldName;
        }
 * the Apache License, Version 2.0 (the "License"); you may
     * The to part of the range query. Null indicates unbounded.
            DateMathParser dateMathParser = getForceDateParser();
            } else if (token.isValue()) {
        this.from = maybeConvertToBytesRef(from);
    @Override
        return from(from, this.includeLower);
    public Object to() {
    /**
            }
    DateMathParser getForceDateParser() { // pkg private for testing
             */
import org.opensearch.core.common.Strings;
                        includeUpper = parser.booleanValue();
     */
     * of query to be equal regardless of whether it was created from XContent or via Java API.
    public RangeQueryBuilder to(Object to) {
                }
 * Licensed to Elasticsearch under one or more contributor
    }
        rangeQuery.queryName(queryName);
        return to(to, this.includeUpper);
        return null;
    protected int doHashCode() {
 */
            rangeQuery.relation(relation);
     * Should the upper bound be included or not. Defaults to {@code true}.
        } catch (DateTimeException e) {
                timeZone,
            }
        return this;
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
     *
                    } else if (INCLUDE_LOWER_FIELD.match(currentFieldName, depHandler)) {
    public static final ParseField TO_FIELD = new ParseField("to");
        MultiTermQueryBuilder,
                throw new IllegalArgumentException("[range] query does not support relation [" + relationString + "]");
     */
        if (format == null) {
            && Objects.equals(timeZone, other.timeZone)
        switch (relation) {
        if (timeZone == null) {
     * in {@link RangeQueryBuilder} field are later parsed as {@link BytesRef} and we need internal representation
