        }
                to = toObj.getDouble();
/**
import org.opensearch.protobufs.DateRangeQueryAllOfFrom;
import org.opensearch.protobufs.RangeRelation;
     *
                return "WITHIN";
        if (relation != null) {
                from = null;
    static RangeQueryBuilder fromProto(RangeQuery rangeQueryProto) {
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);
            includeLower = true;
        // Extract field name from the protobuf
    }
        // Utility class, no instances
        }
     * @return A configured RangeQueryBuilder instance
            includeUpper = true;
        }
            includeUpper = numberRangeQuery.getIncludeUpper();
        if (from != null) {
        }
            includeLower = numberRangeQuery.getIncludeLower();
            if (toObj.hasString()) {
            }
        }
        }
        Object from = null;
    /**
                to = null;
        Object to = null;
        rangeQuery.includeLower(includeLower);
        if (timeZone != null) {
    private static RangeQueryBuilder fromNumberRangeQuery(NumberRangeQuery numberRangeQuery) {
        }
        }
        }
            throw new IllegalArgumentException("RangeQuery must contain either DateRangeQuery or NumberRangeQuery");
            throw new IllegalArgumentException("RangeQuery cannot be null");
            from = numberRangeQuery.getGte();
        String format = dateRangeQuery.hasFormat() ? dateRangeQuery.getFormat() : null;
        if (numberRangeQuery.hasLt()) {
        if (format != null) {
        if (dateRangeQuery.hasTo()) {
 * This class provides methods to transform Protocol Buffer representations of range queries
            throw new IllegalArgumentException("Field name cannot be null or empty for range query");
                from = fromObj.getString();
            includeUpper = false;
        String fieldName = numberRangeQuery.getField();
        if (to != null) {
            case RANGE_RELATION_WITHIN:
     * @throws IllegalArgumentException if no valid range query is found
                from = fromObj.getDouble();
import org.opensearch.protobufs.NumberRangeQuery;
        }
        }
        String fieldName = dateRangeQuery.getField();
        if (rangeQueryProto.hasDateRangeQuery()) {
        }
        if (numberRangeQuery.hasRelation()) {
        }
     * Similar to {@link RangeQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
     * Converts a NumberRangeQuery to a RangeQueryBuilder.
        if (queryName != null) {
        if (numberRangeQuery.hasIncludeLower()) {
        rangeQuery.boost(boost);
        if (fieldName.isEmpty()) {
        String relation = null;
        String timeZone = dateRangeQuery.getTimeZone().isEmpty() ? null : dateRangeQuery.getTimeZone();
import org.opensearch.protobufs.DateRangeQueryAllOfTo;
        boolean includeLower = RangeQueryBuilder.DEFAULT_INCLUDE_LOWER;
 * compatible open source license.
                to = toObj.getString();
import org.opensearch.index.query.RangeQueryBuilder;
        if (from != null) {
    /**
    private RangeQueryBuilderProtoUtils() {
import org.opensearch.index.query.AbstractQueryBuilder;
            from = dateRangeQuery.getGte();
            rangeQuery.from(from);
        if (numberRangeQuery.hasGte()) {
        switch (rangeRelation) {
    }
import org.opensearch.protobufs.DateRangeQuery;
            rangeQuery.queryName(queryName);
        if (rangeRelation == null) {
        if (numberRangeQuery.hasIncludeUpper()) {
            includeLower = dateRangeQuery.getIncludeLower();
            default:
            throw new IllegalArgumentException("Field name cannot be null or empty for range query");
        }
        }
        return rangeQuery;
        if (dateRangeQuery.hasIncludeUpper()) {
        }
            DateRangeQueryAllOfTo toObj = dateRangeQuery.getTo();
            to = numberRangeQuery.getLte();
            NumberRangeQueryAllOfTo toObj = numberRangeQuery.getTo();
            }
 */
            DateRangeQueryAllOfFrom fromObj = dateRangeQuery.getFrom();
 * into their corresponding OpenSearch RangeQueryBuilder implementations for search operations.
        if (numberRangeQuery.hasTo()) {
     * Converts a Protocol Buffer RangeQuery to an OpenSearch RangeQueryBuilder.
        }
            from = dateRangeQuery.getGt();
class RangeQueryBuilderProtoUtils {
                return "INTERSECTS";
            } else if (toObj.hasNullValue()) {
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;
            NumberRangeQueryAllOfFrom fromObj = numberRangeQuery.getFrom();
        rangeQuery.includeUpper(includeUpper);
            return null;
}
        if (dateRangeQuery.hasLt()) {
            } else if (toObj.hasNullValue()) {
        }
            if (fromObj.hasString()) {
        boolean includeUpper = RangeQueryBuilder.DEFAULT_INCLUDE_UPPER;
            includeLower = false;
        }
        String queryName = numberRangeQuery.hasXName() ? numberRangeQuery.getXName() : null;
        }
        boolean includeLower = RangeQueryBuilder.DEFAULT_INCLUDE_LOWER;
        }
            to = dateRangeQuery.getLt();
            rangeQuery.queryName(queryName);
 *
/*
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder(fieldName);
        }
            to = dateRangeQuery.getLte();
        } else {
                from = null;
        if (dateRangeQuery.hasGte()) {
        }
     * @param rangeRelation The RangeRelation enum value
            if (fromObj.hasDouble()) {
                to = toObj.getString();
            rangeQuery.format(format);
        if (numberRangeQuery.hasFrom()) {
        if (dateRangeQuery.hasGt()) {
    /**
     * Converts a DateRangeQuery to a RangeQueryBuilder.
    }
     *
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
            relation = parseRangeRelation(dateRangeQuery.getRelation());
     * RangeQueryBuilder with the appropriate range parameters, format, time zone,
        Object from = null;
        if (dateRangeQuery.hasLte()) {
        }
        if (queryName != null) {
        if (to != null) {
 * SPDX-License-Identifier: Apache-2.0
            } else if (fromObj.hasString()) {
     */
                return "CONTAINS";
        if (dateRangeQuery.hasIncludeLower()) {
                return null;
     */
        }
        if (fieldName.isEmpty()) {
        if (dateRangeQuery.hasRelation()) {
     * relation, boost, and query name.
        }
     */
            } else if (fromObj.hasNullValue()) {
        boolean includeUpper = RangeQueryBuilder.DEFAULT_INCLUDE_UPPER;
    private static String parseRangeRelation(RangeRelation rangeRelation) {
        }
            rangeQuery.to(to);
            }
     */
        }
    }
     * parses the Protocol Buffer representation and creates a properly configured
        rangeQuery.includeUpper(includeUpper);
        Object to = null;
        if (rangeQueryProto == null) {
            return fromDateRangeQuery(rangeQueryProto.getDateRangeQuery());
     * @return The corresponding string representation, or null if unsupported
        }
     * @param rangeQueryProto The Protocol Buffer RangeQuery object
            includeLower = true;
                from = fromObj.getString();
            return fromNumberRangeQuery(rangeQueryProto.getNumberRangeQuery());
            includeUpper = true;
        return rangeQuery;
        // Extract field name from the protobuf
        if (numberRangeQuery.hasLte()) {
        }
        }
        if (relation != null) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.protobufs.RangeQuery;
        if (dateRangeQuery.hasFrom()) {
    private static RangeQueryBuilder fromDateRangeQuery(DateRangeQuery dateRangeQuery) {
                to = null;
    }
            relation = parseRangeRelation(numberRangeQuery.getRelation());
package org.opensearch.transport.grpc.proto.request.search.query;
            to = numberRangeQuery.getLt();
        } else if (rangeQueryProto.hasNumberRangeQuery()) {
            case RANGE_RELATION_CONTAINS:
            from = numberRangeQuery.getGt();
            includeUpper = dateRangeQuery.getIncludeUpper();
        String relation = null;
        rangeQuery.boost(boost);
            rangeQuery.relation(relation);
            } else if (toObj.hasString()) {
            includeLower = false;
            case RANGE_RELATION_INTERSECTS:
            includeUpper = false;
            rangeQuery.to(to);
        rangeQuery.includeLower(includeLower);
            if (toObj.hasDouble()) {
            rangeQuery.timeZone(timeZone);
 */
        String queryName = dateRangeQuery.hasXName() ? dateRangeQuery.getXName() : null;
            }
            } else if (fromObj.hasNullValue()) {
     * Parses RangeRelation enum to string.
    /**
        }
 * this file be licensed under the Apache-2.0 license or a
            rangeQuery.relation(relation);
 * Utility class for converting RangeQuery Protocol Buffers to OpenSearch objects.
        float boost = dateRangeQuery.hasBoost() ? dateRangeQuery.getBoost() : AbstractQueryBuilder.DEFAULT_BOOST;
        }
        float boost = numberRangeQuery.hasBoost() ? numberRangeQuery.getBoost() : AbstractQueryBuilder.DEFAULT_BOOST;
        if (numberRangeQuery.hasGt()) {
        }
            rangeQuery.from(from);
