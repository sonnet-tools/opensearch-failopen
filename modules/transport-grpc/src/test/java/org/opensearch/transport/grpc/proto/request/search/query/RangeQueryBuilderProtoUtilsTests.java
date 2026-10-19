    }
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(50.0).build())
            .build();
        assertEquals("Field name should match", "minimal_date_field", result.fieldName());
            .build();
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        assertEquals("Field name should match", "within_number_field", result.fieldName());
        assertEquals("From should be string", "10.5", result.from());
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
        RangeQuery rangeQuery = RangeQuery.newBuilder().build();
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
    }
            .setLt(90.0)
    }
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)
            // Note: No .setRelation() call - relation will be null/unset
            .setField("number_field")
        assertEquals("Field name should match", "string_number_field", result.fieldName());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
    }
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .setIncludeLower(true)
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
    }
    public void testFromProtoWithDateRangeQueryMinimalFields() {
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
            .setTimeZone("UTC")
            .build();
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
    public void testFromProtoWithNumberRangeQueryEmptyField() {
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
 *
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertEquals("Field name should match", "no_relation_number_field", result.fieldName());
        // Test NumberRangeQuery without relation field set to cover null relation case
        assertNull("From should be null (unbounded)", rangeQueryBuilder.from());
        );
        assertEquals("To should be string", "100.5", result.to());
            .setField("double_field")
            .setField("date_field")
        assertEquals("Field name should match", "score", result.fieldName());
    }
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
    public void testFromProtoWithNumberRangeQueryAllOptionalFields() {
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setField("mixed_field")
            .setField("unspecified_relation_field")
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder().setField("number_field").setFrom(fromObj).setTo(toObj).build();
    public void testFromProtoWithNumberRangeQueryWithinRelation() {
    public void testFromProtoWithNumberRangeQueryMixedStringDouble() {
        );
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
import org.opensearch.protobufs.RangeQuery;
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())
    public void testFromProtoWithNumberRangeQueryUnspecifiedRelation() {
        assertNull("Query name should be null", result.queryName());
    }
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "unspecified_relation_field", result.fieldName());
            .setLte("2023-10-30") // Should override 'lt'
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        assertEquals("Field name should match", "mixed_field", result.fieldName());
        DateRangeQueryAllOfTo toObj = DateRangeQueryAllOfTo.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build();
            .build();
            .setField("") // Empty field name
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "no_relation_field", result.fieldName());
    }
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
            .setField("no_relation_number_field")
        assertNotNull("RangeQueryBuilder should not be null", result);
        );
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Field name should match", "timestamp", result.fieldName());
        assertEquals("Boost should match", 2.5f, result.boost(), 0.001f);
            .build();
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        assertEquals("From should match", 10.0, rangeQueryBuilder.from());
            .build();
    // ========== DateRangeQuery Tests ==========
package org.opensearch.transport.grpc.proto.request.search.query;
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        assertEquals("Field name should match", "unspecified_number_field", result.fieldName());
            .setField("timestamp")
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        assertEquals("To should match", "2023-12-31", rangeQueryBuilder.to());
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        assertNotNull("RangeQueryBuilder should not be null", result);
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
import org.opensearch.protobufs.NumberRangeQuery;
            .setField("score")
        assertEquals("Field name should match", "number_field", rangeQueryBuilder.fieldName());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("date_field").setFrom(fromObj).setTo(toObj).build();
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .build();
        assertEquals("Time zone should match", "UTC", result.timeZone());
    public void testFromProtoWithNumberRangeQuery() {
            .setIncludeUpper(false)
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
 */
    }
    }
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        assertEquals("Field name should match", "number_field", result.fieldName());
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setString("5.0").build())
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
public class RangeQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.protobufs.DateRangeQueryAllOfFrom;
import org.opensearch.protobufs.DateRangeQuery;
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setField("date_field")
            .build();
            .setIncludeLower(false)  // Should be overridden by gte
    public void testFromProtoWithNumberRangeQueryWithRelation() {
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build())
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
    // ========== Additional NumberRangeQuery Coverage Tests ==========
import org.opensearch.protobufs.DateRangeQueryAllOfTo;
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
            IllegalArgumentException.class,
    }
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01T00:00:00Z").build())
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .setField("unspecified_number_field")
            exception.getMessage().contains("Field name cannot be null or empty")
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        // Test DateRangeQuery with RANGE_RELATION_UNSPECIFIED to trigger default case in parseRangeRelation
            "Exception should mention field name requirement",
        assertNotNull("RangeQueryBuilder should not be null", result);
            .setGte(10.0)
            exception.getMessage().contains("Field name cannot be null or empty")
        assertEquals("Format should match", "yyyy-MM-dd'T'HH:mm:ss'Z'", result.format());
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(50.0).build())
        // Test NumberRangeQuery with RANGE_RELATION_UNSPECIFIED to trigger default case
            .build();
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setGte("2023-03-01") // Should override 'gt'
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
    public void testFromProtoWithDateRangeQueryWithinRelation() {
    public void testFromProtoWithDateRangeQueryLtLteOverrides() {
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
        assertEquals("From should be double", 50.0, result.from());
        // Test NumberRangeQuery with double values in oneof from/to fields
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
    public void testFromProtoWithDateRangeQueryNullFromTo() {
        DateRangeQueryAllOfFrom fromObj = DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build();
    }
        assertEquals("From should be from gte (final precedence)", "2023-03-01", result.from());
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
            .build();
    }
    }
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)
            .setGt("2023-01-02")
    public void testFromProtoWithDateRangeQueryNoRelation() {
        assertEquals("Field name should match", "date_field", result.fieldName());
        assertTrue("Should include upper when using lte", result.includeUpper());
        assertEquals("Boost should match", 1.8f, result.boost(), 0.001f);
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("minimal_date_field").build(); // Only field name set
        assertNotNull("RangeQueryBuilder should not be null", result);
            .build();
    }
            .setLte("2023-12-31")    // Should set to and set includeUpper=true
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    public void testFromProtoWithNumberRangeQueryNoRelation() {
    }
    public void testFromProtoWithDateRangeQueryAllOptionalFields() {
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setField("") // Empty field name
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
        assertEquals("To should be double", 150.0, result.to());
            .setField("null_range_field")
    }
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setRelation(RangeRelation.RANGE_RELATION_WITHIN)
        assertNotNull("RangeQueryBuilder should not be null", result);
            .setLt("2023-11-30") // Should override 'to'
            .setXName("comprehensive_number_range")
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31T23:59:59Z").build())
/*
            .setField("date_field")
        assertEquals("Query name should match", "comprehensive_date_range", result.queryName());
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.5).build())
            .build();
        assertTrue(
    public void testFromProtoWithNullRangeQuery() {
            .setRelation(RangeRelation.RANGE_RELATION_UNSPECIFIED)
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());
            .setBoost(2.5f)
    public void testFromProtoWithDateRangeQueryWithRelation() {
            .setRelation(RangeRelation.RANGE_RELATION_WITHIN)
        assertNotNull("RangeQueryBuilder should not be null", result);
    public void testFromProtoWithDateRangeQueryEmptyField() {
        assertEquals("To should be double", 50.0, result.to());
        // Test NumberRangeQuery with mixed string and double values
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(150.0).build())
            .setGt("2023-02-01") // Should override 'from'
            .build();
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .setField("date_field")
            .setField("string_number_field")
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        assertEquals("RangeQuery cannot be null", exception.getMessage());
            .build();
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
            IllegalArgumentException.class,
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;
        assertEquals("Query name should match", "comprehensive_number_range", result.queryName());
            .build();
        DateRangeQueryAllOfFrom fromObj = DateRangeQueryAllOfFrom.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build();
    }
        // Test DateRangeQuery with null enum values in oneof from/to fields
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())
    }
            .setGt(5.0)
        assertEquals("To should be from lte", "2023-12-31", rangeQueryBuilder.to());
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setIncludeLower(false)
        assertTrue("includeLower should be true (from gte)", rangeQueryBuilder.includeLower());
    public void testFromProtoWithEmptyRangeQuery() {
        // Test NumberRangeQuery with string values to cover hasString() branches
        IllegalArgumentException exception = expectThrows(
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        IllegalArgumentException exception = expectThrows(
        );
        assertEquals("To should match", 100.0, rangeQueryBuilder.to());
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());
        assertEquals("Field name should match", "null_range_field", result.fieldName());
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
        // Test DateRangeQuery without relation field set to cover null relation case
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setString("100.5").build())
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .build();
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        assertEquals("From should be string", "5.0", result.from());
            .setField("no_relation_field")
            .setGte("2023-06-01")    // Should override from and set includeLower=true
        assertNotNull("RangeQueryBuilder should not be null", result);
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        assertEquals("From should be from gte", "2023-06-01", rangeQueryBuilder.from());
            .build();
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build()) // Should be overridden
            // Note: No .setRelation() call - relation will be null/unset
            .setLte(85.0)
    // ========== Error Cases ==========
    // ========== Precedence Tests (gt/gte/lt/lte override from/to) ==========
            .setLt("2023-12-31")
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setBoost(1.8f)
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        assertEquals("RangeQuery must contain either DateRangeQuery or NumberRangeQuery", exception.getMessage());
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)
        assertEquals("Default boost should be applied", 1.0f, result.boost(), 0.001f);
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build()) // Should be overridden
        NumberRangeQueryAllOfTo toObj = NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build();
        assertTrue(
        );
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    }
    public void testGteLteOverridesFromToAndIncludeFlags() {
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
    // ========== NumberRangeQuery Tests ==========
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build())
        assertTrue("includeUpper should be true (from lte)", rangeQueryBuilder.includeUpper());
    public void testFromProtoWithNumberRangeQueryDoubleValues() {
    public void testFromProtoWithDateRangeQueryUnspecifiedRelation() {
        // Note: The relation should be set but we can't easily test it without accessing private fields
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("date_field").setFrom(fromObj).setTo(toObj).build();
            .build();
        assertNotNull("RangeQueryBuilder should not be null", result);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setRelation(RangeRelation.RANGE_RELATION_INTERSECTS)
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertNotNull("RangeQueryBuilder should not be null", result);
        IllegalArgumentException exception = expectThrows(
        DateRangeQueryAllOfTo toObj = DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build();
    // ========== Missing Coverage Tests ==========
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
            IllegalArgumentException.class,
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());
        // Create a protobuf DateRangeQuery with all parameters
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setString("10.5").build())
        assertEquals("To should be from lte (final precedence)", "2023-10-30", result.to());
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertEquals("Field name should match", "date_field", result.fieldName());
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
            .setIncludeUpper(false)  // Should be overridden by lte
        assertNull("To should be null (unbounded)", rangeQueryBuilder.to());
            .setField("date_field")
            IllegalArgumentException.class,
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        );
        assertNotNull("RangeQueryBuilder should not be null", result);
            "Exception should mention field name requirement",
    }
    public void testFromProtoWithNumberRangeQueryNullValues() {
}
        // Test DateRangeQuery with RANGE_RELATION_WITHIN to cover missing parseRangeRelation case
    }
        // Test NumberRangeQuery with RANGE_RELATION_WITHIN
import org.opensearch.protobufs.RangeRelation;
    // ========== Additional DateRangeQuery Coverage Tests ==========
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
    public void testFromProtoWithDateRangeQueryGtGteOverrides() {
    }
            .setIncludeUpper(true)
            .setField("within_number_field")
    public void testFromProtoWithNumberRangeQueryStringValues() {
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertNull("To should be null", result.to());
            .setRelation(RangeRelation.RANGE_RELATION_CONTAINS)
    }
            () -> RangeQueryBuilderProtoUtils.fromProto(null)
            .build();
    public void testFromProtoWithDateRangeQuery() {
        NumberRangeQueryAllOfFrom fromObj = NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build();
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
        assertNull("From should be null", result.from());
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
            .setGte("2023-01-01")
            .setLte("2023-12-30")
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should include lower when using gte", result.includeLower());
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
import org.opensearch.index.query.RangeQueryBuilder;
        // Test that gte/lte fields override from/to and include_lower/include_upper
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertEquals("From should match", "2023-01-01", rangeQueryBuilder.from());
import org.opensearch.protobufs.NullValue;
            .setXName("comprehensive_date_range")
            .setFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        IllegalArgumentException exception = expectThrows(
            .setRelation(RangeRelation.RANGE_RELATION_UNSPECIFIED)
        assertNotNull("RangeQueryBuilder should not be null", result);
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "double_field", result.fieldName());
