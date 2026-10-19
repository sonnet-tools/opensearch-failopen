            .setBoost(2.5f)  
            .build();  
        IllegalArgumentException exception = expectThrows(
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Default boost should be applied", 1.0f, result.boost(), 0.001f);
        assertEquals("Field name should match", "number_field", rangeQueryBuilder.fieldName());
        assertEquals("Field name should match", "no_relation_number_field", result.fieldName());
    }
            .build();
import org.opensearch.protobufs.DateRangeQueryAllOfFrom;  
        assertEquals("Query name should match", "comprehensive_number_range", result.queryName());
            .setRelation(RangeRelation.RANGE_RELATION_CONTAINS)  
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())  
    public void testGteLteOverridesFromToAndIncludeFlags() {  
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01T00:00:00Z").build())
        assertEquals("Query name should match", "comprehensive_date_range", result.queryName());  
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()  
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)
import org.opensearch.protobufs.RangeQuery;  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertTrue("Should include upper when using lte", result.includeUpper());
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()  
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())  
 *
            .setField("within_number_field")
            .setGt("2023-02-01") // Should override 'from'
            IllegalArgumentException.class,  
        DateRangeQueryAllOfFrom fromObj = DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build();
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        assertEquals("Field name should match", "double_field", result.fieldName());
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
            .setGt("2023-01-02")
        );  
    public void testFromProtoWithDateRangeQueryEmptyField() {  
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
            // Note: No .setRelation() call - relation will be null/unset  
            .setField("date_field")
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
            .setTimeZone("UTC")
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .setLte(85.0)
        assertEquals("To should be double", 50.0, result.to());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
        // Test DateRangeQuery with RANGE_RELATION_WITHIN to cover missing parseRangeRelation case
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
        assertEquals("To should be double", 150.0, result.to());
        assertEquals("Field name should match", "score", result.fieldName());  
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()  
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
        IllegalArgumentException exception = expectThrows(
        assertNotNull("RangeQueryBuilder should not be null", result);
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(50.0).build())  
        assertEquals("To should match", "2023-12-31", rangeQueryBuilder.to());
    public void testFromProtoWithNumberRangeQueryWithRelation() {
            .setField("double_field")
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("minimal_date_field").build(); // Only field name set
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());  
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    }  
            .build();
            .setIncludeLower(false)  // Should be overridden by gte  
import org.opensearch.protobufs.DateRangeQuery;
            .setIncludeLower(true)
            IllegalArgumentException.class,
    }  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build())  
        assertEquals("To should be string", "100.5", result.to());
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(150.0).build())
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(50.0).build())
 * compatible open source license.
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
/*  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();  
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setString("5.0").build())  
 * this file be licensed under the Apache-2.0 license or a
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        // Test DateRangeQuery with RANGE_RELATION_UNSPECIFIED to trigger default case in parseRangeRelation
            .setLt(90.0)  
        assertEquals("Field name should match", "unspecified_number_field", result.fieldName());
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());  
        assertEquals("Time zone should match", "UTC", result.timeZone());  
        );
        DateRangeQueryAllOfFrom fromObj = DateRangeQueryAllOfFrom.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build();
        assertEquals("Field name should match", "within_number_field", result.fieldName());  
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setString("100.5").build())
import org.opensearch.protobufs.NullValue;
        assertEquals("Field name should match", "no_relation_field", result.fieldName());  
    // ========== Additional NumberRangeQuery Coverage Tests ==========  
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31T23:59:59Z").build())  
            .build();
        assertNull("Query name should be null", result.queryName());  
    }
        NumberRangeQueryAllOfFrom fromObj = NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build();  
        assertTrue("includeLower should be true (from gte)", rangeQueryBuilder.includeLower());  
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
            .setLte("2023-10-30") // Should override 'lt'  
    public void testFromProtoWithNumberRangeQueryAllOptionalFields() {
            .setRelation(RangeRelation.RANGE_RELATION_INTERSECTS)
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build()) // Should be overridden  
            .build();  
        assertNull("To should be null", result.to());  
    public void testFromProtoWithDateRangeQueryWithinRelation() {
    }
        );
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
    public void testFromProtoWithNumberRangeQueryEmptyField() {
            .setXName("comprehensive_date_range")
        assertEquals("Format should match", "yyyy-MM-dd'T'HH:mm:ss'Z'", result.format());
    }
        assertNotNull("RangeQueryBuilder should not be null", result);  
        // Note: The relation should be set but we can't easily test it without accessing private fields  
    }  
        DateRangeQueryAllOfTo toObj = DateRangeQueryAllOfTo.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build();  
        assertEquals("To should match", 100.0, rangeQueryBuilder.to());
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build()) // Should be overridden
        IllegalArgumentException exception = expectThrows(
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setIncludeUpper(false)  // Should be overridden by lte
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()  
    // ========== Missing Coverage Tests ==========
            .build();
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
        assertEquals("Field name should match", "date_field", rangeQueryBuilder.fieldName());  
            "Exception should mention field name requirement",
            .setGte("2023-01-01")
        );
            .setGte(10.0)
    }  
            .setField("date_field")
        assertEquals("Field name should match", "unspecified_relation_field", result.fieldName());
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)  
 * The OpenSearch Contributors require contributions made to  
            .setGt(5.0)
    public void testFromProtoWithNullRangeQuery() {  
        NumberRangeQueryAllOfTo toObj = NumberRangeQueryAllOfTo.newBuilder().setDouble(100.0).build();
        assertEquals("From should match", 10.0, rangeQueryBuilder.from());  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        IllegalArgumentException exception = expectThrows(
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .setLte("2023-12-31")    // Should set to and set includeUpper=true
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
}
            .setField("") // Empty field name
    }
    }
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();  
    }
        assertEquals("Field name should match", "minimal_date_field", result.fieldName());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
            .build();
            .setGte("2023-03-01") // Should override 'gt'
        assertEquals("Field name should match", "mixed_field", result.fieldName());
            exception.getMessage().contains("Field name cannot be null or empty")
        assertEquals("From should match", "2023-01-01", rangeQueryBuilder.from());
        assertNotNull("RangeQueryBuilder should not be null", result);  
            .setFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    public void testFromProtoWithDateRangeQueryNullFromTo() {
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
            .build();
        RangeQuery rangeQuery = RangeQuery.newBuilder().build();  
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()  
        assertNotNull("RangeQueryBuilder should not be null", result);
import org.opensearch.test.OpenSearchTestCase;
            () -> RangeQueryBuilderProtoUtils.fromProto(rangeQuery)
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.5).build())
    }
        assertEquals("Field name should match", "date_field", result.fieldName());
        // Test NumberRangeQuery with RANGE_RELATION_WITHIN  
            .setField("score")
    }
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();  
            .setField("number_field")  
            .setIncludeUpper(false)  
        assertNotNull("RangeQueryBuilder should not be null", result);
    }
    public void testFromProtoWithNumberRangeQueryStringValues() {  
        assertEquals("Boost should match", 1.8f, result.boost(), 0.001f);
import org.opensearch.index.query.RangeQueryBuilder;
import org.opensearch.protobufs.NumberRangeQueryAllOfTo;
    public void testFromProtoWithNumberRangeQueryNullValues() {
    public void testFromProtoWithDateRangeQueryUnspecifiedRelation() {  
            .build();  
            .build();  
        assertNull("To should be null (unbounded)", rangeQueryBuilder.to());
            .setLt("2023-12-31")  
        assertNotNull("RangeQueryBuilder should not be null", result);
        assertEquals("Field name should match", "null_range_field", result.fieldName());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()
    public void testFromProtoWithNumberRangeQueryNoRelation() {  
    }
package org.opensearch.transport.grpc.proto.request.search.query;
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(10.0).build())
        assertEquals("To should be from lte", "2023-12-31", rangeQueryBuilder.to());
        );
    // ========== DateRangeQuery Tests ==========  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        // Test NumberRangeQuery with RANGE_RELATION_UNSPECIFIED to trigger default case
            .build();
    public void testFromProtoWithNumberRangeQueryMixedStringDouble() {
        );
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setField("date_field")  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
        assertNotNull("RangeQueryBuilder should not be null", result);  
            .setField("no_relation_field")
            .setXName("comprehensive_number_range")
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
    // ========== NumberRangeQuery Tests ==========
    }
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    public void testFromProtoWithDateRangeQueryWithRelation() {
        assertEquals("Field name should match", "timestamp", result.fieldName());
        assertEquals("Field name should match", "number_field", result.fieldName());
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("date_field").setFrom(fromObj).setTo(toObj).build();
import org.opensearch.protobufs.NumberRangeQuery;  
            .setField("unspecified_relation_field")  
            .setIncludeUpper(true)  
    public void testFromProtoWithNumberRangeQueryWithinRelation() {
        assertTrue(  
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())  
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    public void testFromProtoWithNumberRangeQuery() {
        assertEquals("Field name should match", "date_field", result.fieldName());
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
            "Exception should mention field name requirement",  
            IllegalArgumentException.class,  
        assertNotNull("RangeQueryBuilder should not be null", result);
            .setBoost(1.8f)
            .setField("no_relation_number_field")  
    // ========== Precedence Tests (gt/gte/lt/lte override from/to) ==========
    public void testFromProtoWithDateRangeQuery() {
            .setField("date_field")
        assertEquals("From should be string", "5.0", result.from());  
    public void testFromProtoWithNumberRangeQueryDoubleValues() {  
        // Test NumberRangeQuery with mixed string and double values  
        assertNotNull("RangeQueryBuilder should not be null", result);
            // Note: No .setRelation() call - relation will be null/unset
        assertEquals("RangeQuery must contain either DateRangeQuery or NumberRangeQuery", exception.getMessage());  
        DateRangeQueryAllOfTo toObj = DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build();  
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
            .build();
        // Test DateRangeQuery without relation field set to cover null relation case  
            .setField("null_range_field")
            .setField("date_field")  
    }  
        assertNotNull("RangeQueryBuilder should not be null", result);
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("date_field").setFrom(fromObj).setTo(toObj).build();
            .build();
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
import org.opensearch.protobufs.NumberRangeQueryAllOfFrom;
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
            .setField("timestamp")
        // Test NumberRangeQuery with string values to cover hasString() branches
public class RangeQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("To should be from lte (final precedence)", "2023-10-30", result.to());
        assertTrue("Should include lower when using gte", result.includeLower());
            .setGte("2023-06-01")    // Should override from and set includeLower=true
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);  
 */  
    // ========== Additional DateRangeQuery Coverage Tests ==========  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
import org.opensearch.protobufs.DateRangeQueryAllOfTo;
            .setLte("2023-12-30")
        assertNotNull("RangeQueryBuilder should not be null", result);  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
        assertEquals("From should be from gte (final precedence)", "2023-03-01", result.from());  
            .setField("string_number_field")  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();  
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())
        assertNull("From should be null", result.from());
    // ========== Error Cases ==========
        // Test DateRangeQuery with null enum values in oneof from/to fields  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()  
    }  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())  
        RangeQueryBuilder result = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
        // Create a protobuf DateRangeQuery with all parameters  
    }  
    }
            .build();
        assertNotNull("RangeQueryBuilder should not be null", rangeQueryBuilder);
            .setRelation(RangeRelation.RANGE_RELATION_WITHIN)
        // Test that gte/lte fields override from/to and include_lower/include_upper
        assertEquals("From should be string", "10.5", result.from());
        assertTrue(
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setDouble(1.0).build())
        RangeQueryBuilder rangeQueryBuilder = RangeQueryBuilderProtoUtils.fromProto(rangeQuery);
    }
    public void testFromProtoWithDateRangeQueryNoRelation() {
            .build();
    public void testFromProtoWithDateRangeQueryAllOptionalFields() {
    public void testFromProtoWithDateRangeQueryGtGteOverrides() {  
        assertTrue("includeUpper should be true (from lte)", rangeQueryBuilder.includeUpper());
    }
        assertNotNull("RangeQueryBuilder should not be null", result);  
            .setField("") // Empty field name
        assertEquals("Boost should match", 2.5f, result.boost(), 0.001f);
            .setRelation(RangeRelation.RANGE_RELATION_UNSPECIFIED)
            IllegalArgumentException.class,
    }
 * SPDX-License-Identifier: Apache-2.0
            .setFrom(DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build())  
        assertNotNull("RangeQueryBuilder should not be null", result);
    public void testFromProtoWithDateRangeQueryMinimalFields() {  
            .setIncludeLower(false)
        RangeQuery rangeQuery = RangeQuery.newBuilder().setNumberRangeQuery(numberRangeQuery).build();
        assertEquals("From should be double", 50.0, result.from());  
        assertEquals("Field name should match", "string_number_field", result.fieldName());  
    public void testFromProtoWithEmptyRangeQuery() {
        assertEquals("RangeQuery cannot be null", exception.getMessage());
            .build();  
            exception.getMessage().contains("Field name cannot be null or empty")
        // Test NumberRangeQuery without relation field set to cover null relation case
            .build();
            .setLt("2023-11-30") // Should override 'to'
        assertNotNull("RangeQueryBuilder should not be null", result);
    }  
            .setField("mixed_field")
            .setFrom(NumberRangeQueryAllOfFrom.newBuilder().setString("10.5").build())
            .setTo(DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build())
    public void testFromProtoWithDateRangeQueryLtLteOverrides() {
            .setRelation(RangeRelation.RANGE_RELATION_WITHIN)
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder().setField("number_field").setFrom(fromObj).setTo(toObj).build();
import org.opensearch.protobufs.RangeRelation;
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setDouble(10.0).build())
            .build();
        // Test NumberRangeQuery with double values in oneof from/to fields
            .setRelation(RangeRelation.RANGE_RELATION_UNSPECIFIED)  
        NumberRangeQuery numberRangeQuery = NumberRangeQuery.newBuilder()
    public void testFromProtoWithNumberRangeQueryUnspecifiedRelation() {
    }  
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder()  
        assertNull("From should be null (unbounded)", rangeQueryBuilder.from());
            () -> RangeQueryBuilderProtoUtils.fromProto(null)  
        assertEquals("From should be from gte", "2023-06-01", rangeQueryBuilder.from());
            .setField("unspecified_number_field")
            .setTo(NumberRangeQueryAllOfTo.newBuilder().setNullValue(NullValue.NULL_VALUE_NULL).build())  
            .build();  
        assertNotNull("RangeQueryBuilder should not be null", result);  
