            rangeQuery.queryName(queryName);
        if (dateRangeQuery.hasTo()) {
        if (dateRangeQuery.hasLt()) {
import org.opensearch.protobufs.NumberRangeQuery;
            } else if (toObj.hasNullValue()) {  
 *
            to = dateRangeQuery.getLt();
     * Converts a Protocol Buffer RangeQuery to an OpenSearch RangeQueryBuilder.
 * This class provides methods to transform Protocol Buffer representations of range queries
import org.opensearch.index.query.AbstractQueryBuilder;  
        rangeQuery.boost(boost);
            throw new IllegalArgumentException("Field name cannot be null or empty for range query");
            includeLower = true;
            NumberRangeQueryAllOfFrom fromObj = numberRangeQuery.getFrom();
        if (dateRangeQuery.hasFrom()) {
        if (numberRangeQuery.hasRelation()) {  
     *
     * Similar to {@link RangeQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method  
     */  
/*  
        if (rangeRelation == null) {  
import org.opensearch.index.query.RangeQueryBuilder;
        Object from = null;
 * into their corresponding OpenSearch RangeQueryBuilder implementations for search operations.
     * @param rangeQueryProto The Protocol Buffer RangeQuery object
        if (dateRangeQuery.hasRelation()) {  
        }
        if (numberRangeQuery.hasGte()) {  
 * SPDX-License-Identifier: Apache-2.0
        }  
        String format = dateRangeQuery.hasFormat() ? dateRangeQuery.getFormat() : null;
            includeLower = numberRangeQuery.getIncludeLower();  
        rangeQuery.includeUpper(includeUpper);
        if (numberRangeQuery.hasLt()) {
            if (toObj.hasString()) {  
            from = dateRangeQuery.getGte();  
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
     *
        } else {  
            includeUpper = true;
    }
        float boost = dateRangeQuery.hasBoost() ? dateRangeQuery.getBoost() : AbstractQueryBuilder.DEFAULT_BOOST;  
                to = null;
            relation = parseRangeRelation(numberRangeQuery.getRelation());
    private RangeQueryBuilderProtoUtils() {  
            } else if (fromObj.hasString()) {
        if (dateRangeQuery.hasIncludeUpper()) {
        if (from != null) {
        String fieldName = dateRangeQuery.getField();
            } else if (fromObj.hasNullValue()) {
            }
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;  
        }  
        if (dateRangeQuery.hasLte()) {  
        }  
        Object to = null;
            rangeQuery.to(to);  
        if (numberRangeQuery.hasTo()) {  
            case RANGE_RELATION_CONTAINS:
            }
            includeLower = false;  
    /**
        }
        }  
    private static RangeQueryBuilder fromNumberRangeQuery(NumberRangeQuery numberRangeQuery) {
                from = null;
        if (from != null) {
            throw new IllegalArgumentException("RangeQuery cannot be null");
            rangeQuery.format(format);
        if (dateRangeQuery.hasGt()) {  
            includeUpper = dateRangeQuery.getIncludeUpper();  
            includeUpper = true;
            includeLower = dateRangeQuery.getIncludeLower();
            }
        }
        }  
            NumberRangeQueryAllOfTo toObj = numberRangeQuery.getTo();
                to = toObj.getString();
        }
                from = fromObj.getString();
        }  
            default:
     */
            } else if (fromObj.hasNullValue()) {
        String fieldName = numberRangeQuery.getField();  
            to = numberRangeQuery.getLte();
                return "INTERSECTS";
     * @return A configured RangeQueryBuilder instance  
        String queryName = numberRangeQuery.hasXName() ? numberRangeQuery.getXName() : null;
import org.opensearch.protobufs.RangeRelation;  
        if (numberRangeQuery.hasLte()) {  
                return "WITHIN";
        }  
        }
        float boost = numberRangeQuery.hasBoost() ? numberRangeQuery.getBoost() : AbstractQueryBuilder.DEFAULT_BOOST;
    /**
    static RangeQueryBuilder fromProto(RangeQuery rangeQueryProto) {  
}  
        String relation = null;  
            return null;
        if (numberRangeQuery.hasFrom()) {
            throw new IllegalArgumentException("Field name cannot be null or empty for range query");  
        if (dateRangeQuery.hasGte()) {
import org.opensearch.protobufs.DateRangeQuery;
        if (numberRangeQuery.hasGt()) {
            if (fromObj.hasDouble()) {  
        // Extract field name from the protobuf
            rangeQuery.relation(relation);
        if (relation != null) {  
 */  
            case RANGE_RELATION_WITHIN:  
        // Extract field name from the protobuf  
        return rangeQuery;
        boolean includeUpper = RangeQueryBuilder.DEFAULT_INCLUDE_UPPER;  
        String timeZone = dateRangeQuery.getTimeZone().isEmpty() ? null : dateRangeQuery.getTimeZone();
        }
    }  
        if (numberRangeQuery.hasIncludeUpper()) {  
     * Converts a NumberRangeQuery to a RangeQueryBuilder.
            from = numberRangeQuery.getGt();
        if (rangeQueryProto.hasDateRangeQuery()) {
     * Converts a DateRangeQuery to a RangeQueryBuilder.  
            rangeQuery.relation(relation);
        if (format != null) {
            if (toObj.hasDouble()) {
            to = dateRangeQuery.getLte();
                to = null;  
        }
                return "CONTAINS";  
        switch (rangeRelation) {
 * The OpenSearch Contributors require contributions made to  
        rangeQuery.boost(boost);
            } else if (toObj.hasNullValue()) {
/**
    }  
     * parses the Protocol Buffer representation and creates a properly configured
        }
            rangeQuery.from(from);  
     * @return The corresponding string representation, or null if unsupported  
        }
        }
import org.opensearch.protobufs.DateRangeQueryAllOfTo;
        if (rangeQueryProto == null) {
 * compatible open source license.
        }
            if (fromObj.hasString()) {  
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);  
        // Utility class, no instances
        }
        }
            } else if (toObj.hasString()) {
import org.opensearch.protobufs.DateRangeQueryAllOfFrom;  
        }
            rangeQuery.queryName(queryName);
        }
        }
        return rangeQuery;
        }
        }
            includeLower = false;
            case RANGE_RELATION_INTERSECTS:
        if (to != null) {
        boolean includeLower = RangeQueryBuilder.DEFAULT_INCLUDE_LOWER;
        boolean includeUpper = RangeQueryBuilder.DEFAULT_INCLUDE_UPPER;  
        }
            DateRangeQueryAllOfFrom fromObj = dateRangeQuery.getFrom();
 * this file be licensed under the Apache-2.0 license or a
            includeUpper = false;
        if (dateRangeQuery.hasIncludeLower()) {
        }
            DateRangeQueryAllOfTo toObj = dateRangeQuery.getTo();
     */
            includeLower = true;
                to = toObj.getString();
     * Parses RangeRelation enum to string.  
            includeUpper = numberRangeQuery.getIncludeUpper();
            return fromNumberRangeQuery(rangeQueryProto.getNumberRangeQuery());
        boolean includeLower = RangeQueryBuilder.DEFAULT_INCLUDE_LOWER;
        if (numberRangeQuery.hasIncludeLower()) {
import org.opensearch.protobufs.RangeQuery;
            from = numberRangeQuery.getGte();
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);
    /**
        } else if (rangeQueryProto.hasNumberRangeQuery()) {
     */
     * @throws IllegalArgumentException if no valid range query is found
class RangeQueryBuilderProtoUtils {
        rangeQuery.includeLower(includeLower);  
     * @param rangeRelation The RangeRelation enum value
        String relation = null;  
                from = null;  
    /**
        Object from = null;
                from = fromObj.getString();  
                from = fromObj.getDouble();
package org.opensearch.transport.grpc.proto.request.search.query;
            throw new IllegalArgumentException("RangeQuery must contain either DateRangeQuery or NumberRangeQuery");
            to = numberRangeQuery.getLt();  
    private static String parseRangeRelation(RangeRelation rangeRelation) {
            includeUpper = false;  
                to = toObj.getDouble();  
    private static RangeQueryBuilder fromDateRangeQuery(DateRangeQuery dateRangeQuery) {
        Object to = null;
        String queryName = dateRangeQuery.hasXName() ? dateRangeQuery.getXName() : null;
            from = dateRangeQuery.getGt();
        }  
            rangeQuery.to(to);  
        }
        }  
     * relation, boost, and query name.  
        rangeQuery.includeLower(includeLower);  
            rangeQuery.timeZone(timeZone);  
        if (to != null) {
 * Utility class for converting RangeQuery Protocol Buffers to OpenSearch objects.  
        }
        }
    }
            rangeQuery.from(from);  
                return null;  
        if (fieldName.isEmpty()) {
        }  
        if (queryName != null) {  
        if (queryName != null) {
    }
            relation = parseRangeRelation(dateRangeQuery.getRelation());
 */  
        if (timeZone != null) {
        if (relation != null) {
            }  
     * RangeQueryBuilder with the appropriate range parameters, format, time zone,
        if (fieldName.isEmpty()) {
        }  
        rangeQuery.includeUpper(includeUpper);
            return fromDateRangeQuery(rangeQueryProto.getDateRangeQuery());  
