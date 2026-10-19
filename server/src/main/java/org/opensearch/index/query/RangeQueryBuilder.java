        Boolean includeLower = null;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.common.geo.ShapeRelation;
        String format = null;  
     */
                        currentFieldName = parser.currentName();
    }  
            && Objects.equals(timeZone, other.timeZone)
     * @param fieldName The field name  
        if (timeZone == null) {
     * Gets the lower range value for this query.  
    }  
                    newRangeQuery.from(null);
            if (shardContext.getIndexReader() == null) {
    /**
 * GitHub history for details.
        }  
        }  
     * In case of format field, we can parse the from/to fields using this time format  
 *  
        return format;
    /**  
        }
        this.includeLower = includeLower;  
        if (relation != null) {
                timeZone,
                } else {  
                return MappedFieldType.Relation.INTERSECTS;  
            rangeQuery.includeUpper(includeUpper);  
        this.includeUpper = includeUpper;
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
    public RangeQueryBuilder(String fieldName) {
                    return newRangeQuery;
                currentFieldName = parser.currentName();
    /**
        return this;
    }  
     */
        if (from != null) {
    public RangeQueryBuilder(StreamInput in) throws IOException {  
        if (relationString != null) {
        }  
    private Object from;
             */
        if (!isRelationAllowed(this.relation)) {
            throw new IllegalArgumentException("relation cannot be null");
 */
        builder.field(FROM_FIELD.getPreferredName(), maybeConvertToString(this.from));  
            && Objects.equals(includeUpper, other.includeUpper)  
            case INTERSECTS:  
            builder.field(RELATION_FIELD.getPreferredName(), relation.getRelationName());
        rangeQuery.queryName(queryName);  
            rangeQuery.includeLower(includeLower);  
    }
    }  
        super(in);
        return from(from, true);
            throw new IllegalArgumentException("timezone cannot be null");
        builder.field(INCLUDE_UPPER_FIELD.getPreferredName(), includeUpper);  
        builder.startObject(fieldName);
import org.opensearch.core.xcontent.XContentParser;
        return timeZone;
 * KIND, either express or implied.  See the License for the
            // For validation, always assume that there is an intersection
        String queryName = null;
     */
        }  
 * You may obtain a copy of the License at  
            aboveRange.from(to);
    }
            if (fieldNamesFieldType == null) {
    public RangeQueryBuilder timeZone(String timeZone) {  
        this.relation = ShapeRelation.getRelationByName(relation);
                    newRangeQuery.timeZone = null;
        return null;
import java.util.ArrayList;  
import org.opensearch.core.common.Strings;  
        builder.startObject(NAME);
        String timeZone = null;  
    }
        }  
        String currentFieldName = null;  
        if (includeUpper != null) {
     */
            RangeQueryBuilder belowRange = new RangeQueryBuilder(fieldName);  
import org.opensearch.index.mapper.MappedFieldType;
                        queryName = parser.text();
        timeZone = in.readOptionalZoneId();
    /**
    ZoneId getDateTimeZone() { // for testing
                    newRangeQuery.format = null;  
    public RangeQueryBuilder includeLower(boolean includeLower) {  
        if (format == null) {  
    }  
    /**
                    DeprecationHandler depHandler = parser.getDeprecationHandler();
                    } else if (INCLUDE_LOWER_FIELD.match(currentFieldName, depHandler)) {  
import org.opensearch.core.ParseField;
    public String fieldName() {  
    }
 * specific language governing permissions and limitations
            }
            return null;
     */  
        this.to = maybeConvertToBytesRef(to);  
    public RangeQueryBuilder from(Object from) {
    public RangeQueryBuilder format(String format) {
        if (includeLower != null) {
    private Object to;
                    RangeQueryBuilder newRangeQuery = new RangeQueryBuilder(fieldName);  
            belowRange.includeUpper(!includeLower);
 * A Query that matches documents within a range of terms.
import java.time.DateTimeException;
     */
                    return this;
     */
        switch (relation) {
    protected boolean doEquals(RangeQueryBuilder other) {  
     * Gets the upper range value for this query.
                }
 * this file be licensed under the Apache-2.0 license or a
        return to(to, this.includeUpper);  
        try {
    /**
        if (shardContext != null) {  
package org.opensearch.index.query;
                        }  
        if (timeZone != null) {
              Open bounds on both side, we can rewrite to an exists query
     */  
                return MappedFieldType.Relation.INTERSECTS;
import org.apache.lucene.util.BytesRef;  
     * In case lower bound is assigned to a string, we internally convert it to a {@link BytesRef} because  
        }  
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);
        Object from = null;
        }
     */
import org.apache.lucene.search.Query;
        DateMathParser forcedDateParser = getForceDateParser();
        format = in.readOptionalString();
                dateMathParser,  
        String fieldName = null;
                includeLower,  
                includeUpper,
    /**
    public RangeQueryBuilder lt(Object to) {
 * compatible open source license.
                }
        printBoostAndQueryName(builder);
            throw new IllegalArgumentException(relation + " is not a valid relation");  
    private final String fieldName;  
            builder.field(FORMAT_FIELD.getPreferredName(), format);
    private boolean includeLower = DEFAULT_INCLUDE_LOWER;
            throw new IllegalStateException("Rewrite first");  
    }  
                        }  
 * the Apache License, Version 2.0 (the "License"); you may
    public List<? extends QueryBuilder> getComplement(QueryShardContext context) {
                        throw new ParsingException(parser.getTokenLocation(), "[range] query does not support [" + currentFieldName + "]");  
import org.opensearch.core.common.ParsingException;
        } catch (DateTimeException e) {  
     * Get the field name for this query.  
        final MappedFieldType.Relation relation = getRelation(queryRewriteContext);  
        return rangeQuery;
        out.writeString(this.fieldName);  
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);
     * The from part of the range query. Null indicates unbounded.
     */
 *  
            throw new IllegalArgumentException(e);
        }
            }  
    }
        }
     */
        return relation == ShapeRelation.INTERSECTS || relation == ShapeRelation.CONTAINS || relation == ShapeRelation.WITHIN;
                .fieldType(FieldNamesFieldMapper.NAME);
     * In case upper bound is assigned to a string, we internally convert it to a {@link BytesRef} because
    }
    @Override
        XContentParser.Token token;
        return this;
    public static final ParseField GTE_FIELD = new ParseField("gte");
            return DateFormatter.forPattern(this.format).toDateMathParser();  
                        }
        List<RangeQueryBuilder> complement = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor  
        if (Strings.hasText(format)) {
    /**
    implements
/*  
import java.time.ZoneId;
            }
        return Objects.hash(fieldName, from, to, timeZone, includeLower, includeUpper, format);
     * Should the lower bound be included or not. Defaults to {@code true}.
        return this;
            if (relation != null && !isRelationAllowed(relation)) {  
        if (from == null && to == null) {  
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
    /**
     * Gets the includeLower flag for this query.  
    private boolean isRelationAllowed(ShapeRelation relation) {  
        return mapper.rangeQuery(from, to, includeLower, includeUpper, relation, timeZone, forcedDateParser, context);  
     * Should the upper bound be included or not. Defaults to {@code true}.
    public String format() {  
                    } else if (TO_FIELD.match(currentFieldName, depHandler)) {
        if (relation == null) {
        }
        if (relation != null) {
                    } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, depHandler)) {
    private static final ParseField FORMAT_FIELD = new ParseField("format");  
            rangeQuery.timeZone(timeZone);  
        return this;  
     * of query to be equal regardless of whether it was created from XContent or via Java API.
    @Override
                        relation = parser.text();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        if (from != null) {  
                    } else if (TIME_ZONE_FIELD.match(currentFieldName, depHandler)) {  
        MappedFieldType mapper = context.fieldMapper(this.fieldName);
                throw new ParsingException(parser.getTokenLocation(), "[range] query does not support [" + currentFieldName + "]");
        }  
     * A Query that matches documents within an range of terms.
 * this work for additional information regarding copyright
    }
        return this.relation;  
            final MappedFieldType.Relation relation = fieldType.isFieldWithinQuery(
        return this.timeZone == null ? null : this.timeZone.getId();
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
                .getMapperService()  
     */
                rq.format(format);  
 * SPDX-License-Identifier: Apache-2.0
        Boolean includeUpper = null;
        this.includeLower = includeLower;
    }
    }
        String relation = null;
        this.includeUpper = includeUpper;
    public static final boolean DEFAULT_INCLUDE_LOWER = true;
                throw new AssertionError();  
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);  
    public RangeQueryBuilder to(Object to, boolean includeUpper) {
     * The to part of the range query. Null indicates unbounded.  
        to = in.readGenericValue();
        QueryShardContext shardContext = queryRewriteContext.convertToShardContext();
        if (relation != null && relation != ShapeRelation.INTERSECTS) {
        return from(from, this.includeLower);
     */
    public RangeQueryBuilder from(Object from, boolean includeLower) {
    private static final ParseField INCLUDE_LOWER_FIELD = new ParseField("include_lower");
        out.writeOptionalString(format);  
            }
                        format = parser.text();  
        }
        builder.field(TO_FIELD.getPreferredName(), maybeConvertToString(this.to));
        }
    }
     * The to part of the range query. Null indicates unbounded.
    }
                        continue; // only field name is required in this iteration
     * The to part of the range query. Null indicates unbounded.  
    }
        return NAME;  
    /**
                        includeUpper = LTE_FIELD.match(currentFieldName, depHandler);
        return this.fieldName;
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean includeLower() {
        // Not on the shard, we have no way to know what the relation is.  
    @Override
    @Override
                        to = maybeConvertToBytesRef(parser.objectBytes());
                    } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, depHandler)) {  
 * @opensearch.internal
            } else if (token.isValue()) {  
            }
    private boolean includeUpper = DEFAULT_INCLUDE_UPPER;
        if (Strings.hasText(format)) {
            belowRange.to(from);
    }
import java.util.List;
            throw new IllegalArgumentException("[range] query does not support relation [" + relation + "]");  
    /**  
            relation = ShapeRelation.getRelationByName(relationString);
            aboveRange.includeLower(!includeUpper);  
                throw new IllegalArgumentException("[range] query does not support relation [" + relationString + "]");
    @Override
            }
            }
     * of query to be equal regardless of whether it was created from XContent or via Java API.
            for (RangeQueryBuilder rq : complement) {
            );
    @Override
            default:
    private ShapeRelation relation;
        return maybeConvertToString(this.to);
    public RangeQueryBuilder lte(Object to) {
            && Objects.equals(format, other.format);
        if (mapper == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("format cannot be null");
    /**  
                        if (to != null || includeUpper != null) {
        this.fieldName = fieldName;  
            DateMathParser dateMathParser = getForceDateParser();
import org.apache.lucene.search.MatchNoDocsQuery;
        from = in.readGenericValue();  
        fieldName = in.readString();
        includeLower = in.readBoolean();
                return ExistsQueryBuilder.newFilter(context, fieldName, false);
    protected Query doToQuery(QueryShardContext context) throws IOException {
            case DISJOINT:
            return relation;  
 * not use this file except in compliance with the License.
                from,
    protected void doWriteTo(StreamOutput out) throws IOException {
    }  
    }
    private static final ParseField INCLUDE_UPPER_FIELD = new ParseField("include_upper");
                return MappedFieldType.Relation.DISJOINT;  
    public ShapeRelation relation() {
    private static final String INVALID_UPPER_BOUND_MESSAGE = "invalid upper bound for [range] query";
    /**  
/*  
    public RangeQueryBuilder gt(Object from) {  
    public static final ParseField LTE_FIELD = new ParseField("lte");  
                    newRangeQuery.to(null);
     * In case of date field, gets the from/to fields timezone adjustment
        }
            relationString = this.relation.getRelationName();  
        return complement;  
     */  
        return to(to, false);
                    if (FROM_FIELD.match(currentFieldName, depHandler)) {
                    } else {
        this.format = format;
    private static final ParseField RELATION_FIELD = new ParseField("relation");
            if (relation == MappedFieldType.Relation.DISJOINT && shardContext.validate()) {
        return this;
        rangeQuery.to(to);
                        timeZone = parser.text();
        out.writeGenericValue(this.to);
        }
     *
    @Override
        if (format != null) {
     * In case of date field, we can adjust the from/to fields using a timezone
        if (format != null) {
                        boost = parser.floatValue();
                        from = maybeConvertToBytesRef(parser.objectBytes());
                fieldName = currentFieldName;
                        includeLower = parser.booleanValue();
                    if (token == XContentParser.Token.FIELD_NAME) {  
        }  
        }
        }
                        includeLower = GTE_FIELD.match(currentFieldName, depHandler);
        return Objects.equals(fieldName, other.fieldName)
        }
                    } else if (GT_FIELD.match(currentFieldName, depHandler) || GTE_FIELD.match(currentFieldName, depHandler)) {  
        return to(to, true);  
    public RangeQueryBuilder gte(Object from) {
     */
        if (Strings.isEmpty(fieldName)) {  
            if (fieldNamesFieldType.isEnabled()) {  
 *
                return new MatchNoDocsQuery("No mappings yet");  
                        }
    // Overridable for testing only  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        out.writeBoolean(this.includeLower);  
            throw new IllegalArgumentException("field name is null or empty");
import org.opensearch.common.time.DateMathParser;  
    }  
 * license agreements. See the NOTICE file distributed with
            this.timeZone = ZoneId.of(timeZone);
    /**  
                        to = maybeConvertToBytesRef(parser.objectBytes());
        }
        DateFormatter.forPattern(format);
    }  
                rq.timeZone = timeZone;
                        if (includeLower != null) {
     */  
    private static final ParseField TIME_ZONE_FIELD = new ParseField("time_zone");
        Object to = null;  
        rangeQuery.boost(boost);
            complement.add(aboveRange);
            final MappedFieldType fieldType = shardContext.fieldMapper(fieldName);
import org.opensearch.core.xcontent.DeprecationHandler;  
            // Exists query would fail if the fieldNames field is disabled.
                shardContext.getIndexReader(),  
                    }
    }
    public boolean includeUpper() {
     * in {@link RangeQueryBuilder} field are later parsed as {@link BytesRef} and we need internal representation  
/*
        }
}
    }
        return this.includeLower;  
        builder.endObject();  
     */
     * The from part of the range query. Null indicates unbounded.
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
    public RangeQueryBuilder to(Object to) {
    public Object from() {
        return maybeConvertToString(this.from);  
        out.writeGenericValue(this.from);
 */  
        builder.field(INCLUDE_LOWER_FIELD.getPreferredName(), includeLower);
    }
        out.writeOptionalZoneId(timeZone);
        }  
                        from = maybeConvertToBytesRef(parser.objectBytes());  
     * Gets the format field to parse the from/to fields
    private ZoneId timeZone;  
    public static final boolean DEFAULT_INCLUDE_UPPER = true;  
                    } else if (LT_FIELD.match(currentFieldName, depHandler) || LTE_FIELD.match(currentFieldName, depHandler)) {  
            final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
     */
     * The from part of the range query. Null indicates unbounded.
        }
            } else if (token == XContentParser.Token.START_OBJECT) {
                        if (to != null) {
        builder.endObject();
            && Objects.equals(to, other.to)  
    @Override
    public RangeQueryBuilder includeUpper(boolean includeUpper) {  
        if (this.relation == null) {
 */  
                to,
    }
    }
                    } else if (FORMAT_FIELD.match(currentFieldName, depHandler)) {
    DateMathParser getForceDateParser() { // pkg private for testing
        if (timeZone != null) {
/**
        // This implementation doesn't need info from QueryShardContext  
 * The OpenSearch Contributors require contributions made to  
                    }  
    }
    }
            case WITHIN:
    /**  
 */
 *
        }
        return this;  
        this.from = maybeConvertToBytesRef(from);
                if (from != null || to != null || format != null || timeZone != null) {
    /**
    /**
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
    public String getWriteableName() {
    public RangeQueryBuilder relation(String relation) {  
        MultiTermQueryBuilder,
                        if (includeUpper != null) {  
    }
    public Object to() {  
    public static final ParseField LT_FIELD = new ParseField("lt");
    }
    private static final String INVALID_LOWER_BOUND_MESSAGE = "invalid lower bound for [range] query";  
        includeUpper = in.readBoolean();  
    /**  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    /**  
                return this;
                        }
            }
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);  
import java.io.IOException;  
              if the {@link FieldNamesFieldMapper} is enabled.  
        if (to != null) {  
            complement.add(belowRange);  
                queryRewriteContext
    }  
        if (timeZone != null) {  
        }  
 * Unless required by applicable law or agreed to in writing,
        out.writeOptionalString(relationString);
        }  
            /*
 * under the License.  
        ComplementAwareQueryBuilder {  
                        if (from != null || includeLower != null) {
import java.util.Objects;
        return MappedFieldType.Relation.INTERSECTS;
            && Objects.equals(includeLower, other.includeLower)
     * in {@link RangeQueryBuilder} field are later parsed as {@link BytesRef} and we need internal representation
     */
            }
        out.writeBoolean(this.includeUpper);
    public static final ParseField TO_FIELD = new ParseField("to");  
        return this.includeUpper;  
        rangeQuery.from(from);  
                        includeUpper = parser.booleanValue();  
                    } else if (INCLUDE_UPPER_FIELD.match(currentFieldName, depHandler)) {
            RangeQueryBuilder aboveRange = new RangeQueryBuilder(fieldName);
            && Objects.equals(from, other.from)
    protected int doHashCode() {
            rangeQuery.format(format);
    private String format;  
    }
    public String timeZone() {  
import org.opensearch.core.common.io.stream.StreamInput;
    }
     * Gets the includeUpper flag for this query.  
        if (this.relation != null) {
 * Modifications Copyright OpenSearch Contributors. See
    public static final ParseField FROM_FIELD = new ParseField("from");
import org.opensearch.common.time.DateFormatter;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
            builder.field(TIME_ZONE_FIELD.getPreferredName(), timeZone.getId());
            if (token == XContentParser.Token.FIELD_NAME) {  
                return new MatchNoneQueryBuilder();  
        String relationString = null;
 * ownership. Elasticsearch licenses this file to you under  
    public static RangeQueryBuilder fromXContent(XContentParser parser) throws IOException {  
    protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) throws IOException {
public class RangeQueryBuilder extends AbstractQueryBuilder<RangeQueryBuilder>  
    /**  
    public static final String NAME = "range";
    public static final ParseField GT_FIELD = new ParseField("gt");  
     */
     * The from part of the range query. Null indicates unbounded.
            if (fieldType == null) {
    }  
            for (RangeQueryBuilder rq : complement) {
     * Read from a stream.
        return this;
                        }  
     * The to part of the range query. Null indicates unbounded.  
    @Override  
                            throw new ParsingException(parser.getTokenLocation(), INVALID_LOWER_BOUND_MESSAGE);
                    } else if (RELATION_FIELD.match(currentFieldName, depHandler)) {
                // No reader, this may happen e.g. for percolator queries.  
        return from(from, false);
    /**
                            throw new ParsingException(parser.getTokenLocation(), INVALID_UPPER_BOUND_MESSAGE);
     */
            rangeQuery.relation(relation);
        // this just ensure that the pattern is actually valid, no need to keep it here  
        String relationString = in.readOptionalString();  
