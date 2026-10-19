    public void testFromProtoWithAllFields() {
        assertTrue(result.should().get(0) instanceof TermQueryBuilder);  
 * compatible open source license.
        TermQueryBuilder shouldClause2 = (TermQueryBuilder) result.should().get(1);  
        return QueryContainer.newBuilder()
    }
        assertNull(result.queryName());
    }  
        // Verify the result
        assertEquals(1, result.mustNot().size());
            .addShould(createTermQueryContainer("field1", "value1"))
import org.opensearch.protobufs.QueryContainer;
        BoolQuery boolQuery = BoolQuery.newBuilder()
            .build();  
                if (queryContainer.getQueryContainerCase() == QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET) {  
            @Override  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        assertEquals(2.0f, result.boost(), 0.001f);
        assertEquals("value1", shouldClause1.value());  
    }  
            .addMust(createTermQueryContainer("field1", "value1"))
        TermQueryBuilder mustNotClause1 = (TermQueryBuilder) result.mustNot().get(0);  
        assertEquals("field1", mustClause1.fieldName());  
        BoolQuery boolQuery = BoolQuery.newBuilder()  
    }  
        assertTrue(result.filter().get(1) instanceof TermQueryBuilder);  
        TermQueryBuilder mustClause2 = (TermQueryBuilder) result.must().get(1);
        assertTrue("Valid must clause should be TermQueryBuilder", result.must().get(0) instanceof TermQueryBuilder);
        // Call the method under test
}
            .addShould(createTermQueryContainer("field4", "value4"))
            .addMust(createTermQueryContainer("field2", "value2"))  
    }
        // Verify the result
                    return null; // Simulate unsupported query type
    public void testFromProtoWithFilterClauses() {
        // Call the method under test  
        assertTrue(result.must().get(1) instanceof TermQueryBuilder);  
        assertFalse("Adjust pure negative should be false", result.adjustPureNegative());  
        assertTrue(result.should().get(0) instanceof TermQueryBuilder);  
        // Verify the must clauses  
                // Return null for empty query containers to test null handling
        assertEquals("75%", result.minimumShouldMatch());
    }
        BoolQueryBuilder result = fromProto(boolQuery, registry);  
            .addShould(emptyQueryContainer)    // Should return null and be ignored
        // Verify the result
        BoolQueryBuilder result = fromProto(boolQuery, registry);
    }
        BoolQuery boolQuery = BoolQuery.newBuilder().build();
        TermQueryBuilder shouldClause1 = (TermQueryBuilder) result.should().get(0);
            .setTerm(TermQuery.newBuilder().setField(field).setValue(FieldValue.newBuilder().setString(value).build()).build())
        assertEquals("field2", mustNotClause2.fieldName());  
        assertEquals("field2", mustNotClause.fieldName());
    public void testFromProtoWithMinimalFields() {
        return QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
        assertEquals(2, result.filter().size());
    public void testFromProtoWithNullQueryBuilders() {  
        BoolQueryBuilder result = fromProto(boolQuery, registry);
    private QueryContainer createTermQueryContainer(String field, String value) {  
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setInt32(2).build())  
        // Create a protobuf BoolQuery with string minimum_should_match
            .addFilter(createTermQueryContainer("field2", "value2"))  
        BoolQuery boolQuery = BoolQuery.newBuilder()
    private QueryContainer createMatchAllQueryContainer() {  
        // Call the method under test  
        // Create a protobuf BoolQuery with multiple filter clauses  
        assertTrue(result.filter().get(0) instanceof TermQueryBuilder);
        assertEquals("valid_field", termQuery.fieldName());  
package org.opensearch.transport.grpc.proto.request.search.query;
        TermQueryBuilder filterClause1 = (TermQueryBuilder) result.filter().get(0);
        assertEquals("value4", shouldClause2.value());
    public void testFromProtoWithStringMinimumShouldMatch() {
        assertEquals("value2", mustNotClause2.value());
        // Verify the result  
        assertEquals(0, result.filter().size());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.BoolQuery;
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        // Create a protobuf BoolQuery with only required fields  
        assertEquals("value1", mustClause1.value());
        BoolQueryBuilder result = fromProto(boolQuery, mockRegistry);
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        assertEquals("Should have 0 filter clauses (null ones ignored)", 0, result.filter().size());
        assertEquals("field2", shouldClause2.fieldName());
        // Verify the result
        assertTrue(result.mustNot().get(0) instanceof TermQueryBuilder);  
        };
        // Create a protobuf BoolQuery with multiple should clauses
        assertEquals(0, result.must().size());
        // Create a protobuf BoolQuery with all fields
        // Verify the filter clauses  
        // Call the method under test
        // Verify the must_not clauses
    }  
        // Set up the registry with all built-in converters  
            }
    @Override  
            .addFilter(emptyQueryContainer)    // Should return null and be ignored
    public void testFromProtoWithMustClauses() {
import org.opensearch.protobufs.MatchAllQuery;  
        // Verify the must clause
        assertEquals("value1", mustNotClause1.value());
import org.opensearch.protobufs.TermQuery;  
        TermQueryBuilder filterClause2 = (TermQueryBuilder) result.filter().get(1);
        // Create a protobuf BoolQuery with multiple must clauses  
import org.opensearch.protobufs.FieldValue;
    public void testFromProtoWithMinimumShouldMatchDefaultCase() {
        // Verify the result  
        assertEquals("value1", mustClause.value());  
        assertEquals("value2", mustNotClause.value());  
    public void testFromProtoWithShouldClauses() {
        assertEquals("field1", filterClause1.fieldName());  
        assertEquals(1, result.filter().size());  
import org.opensearch.index.query.BoolQueryBuilder;
        assertEquals("test_query", result.queryName());  
        // Create a protobuf BoolQuery with unset minimum_should_match case (MINIMUMSHOULDMATCH_NOT_SET)
        // Verify the result - should not have minimum_should_match set  
    public void setUp() throws Exception {
        assertEquals("Should have 1 must clause (null ones ignored)", 1, result.must().size());
        BoolQueryBuilder result = fromProto(boolQuery, registry);
            .addShould(createTermQueryContainer("field2", "value2"))
        // Verify the should clauses
 * SPDX-License-Identifier: Apache-2.0
        TermQueryBuilder mustClause = (TermQueryBuilder) result.must().get(0);
        // Verify the valid must clause  
        assertEquals(1.0f, result.boost(), 0.001f);
        BoolQuery boolQuery = BoolQuery.newBuilder()  
        TermQueryBuilder mustNotClause2 = (TermQueryBuilder) result.mustNot().get(1);
public class BoolQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .addMustNot(createTermQueryContainer("field2", "value2"))
        assertEquals("Should have 0 should clauses (null ones ignored)", 0, result.should().size());  
            .addMust(emptyQueryContainer)      // Should return null and be ignored
        BoolQuery boolQuery = BoolQuery.newBuilder()
        BoolQuery boolQuery = BoolQuery.newBuilder().setAdjustPureNegative(false).build();  
    }
        // Verify the result - only the valid query should be added  
        BoolQuery boolQuery = BoolQuery.newBuilder()
 */  
        assertEquals(0, result.mustNot().size());
        assertEquals(2, result.must().size());
/*  
        BoolQuery boolQuery = BoolQuery.newBuilder().setMinimumShouldMatch(minimumShouldMatch).build();
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.test.OpenSearchTestCase;
        assertNull("Should not have minimum_should_match for default case", result.minimumShouldMatch());
        // Verify the result  
        // Create a protobuf BoolQuery with adjust_pure_negative = false
        // Call the method under test
        assertEquals(1, result.must().size());  
        assertEquals(2, result.should().size());  
        TermQueryBuilder mustClause1 = (TermQueryBuilder) result.must().get(0);
        // Call the method under test
import org.opensearch.protobufs.MinimumShouldMatch;
import static org.opensearch.transport.grpc.proto.request.search.query.BoolQueryBuilderProtoUtils.fromProto;  
        assertEquals(2, result.should().size());
        BoolQuery boolQuery = BoolQuery.newBuilder()  
            .addMustNot(createTermQueryContainer("field2", "value2"))
        TermQueryBuilder shouldClause2 = (TermQueryBuilder) result.should().get(1);  
        assertEquals("field1", shouldClause1.fieldName());
                return super.fromProto(queryContainer);  
        QueryBuilderProtoConverterRegistryImpl mockRegistry = new QueryBuilderProtoConverterRegistryImpl() {
        // Verify the filter clause
        // Create a protobuf BoolQuery with multiple must_not clauses
        // Call the method under test  
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
            .addFilter(createMatchAllQueryContainer())
        assertEquals("field2", filterClause2.fieldName());
        assertEquals("valid_value", termQuery.value());
            .addMustNot(createTermQueryContainer("field1", "value1"))  
        TermQueryBuilder mustNotClause = (TermQueryBuilder) result.mustNot().get(0);
                }
        assertEquals(0, result.should().size());  
        assertEquals("field1", mustNotClause1.fieldName());
            .addFilter(createTermQueryContainer("field1", "value1"))
        assertEquals("field4", shouldClause2.fieldName());
        assertTrue(result.must().get(0) instanceof TermQueryBuilder);
        assertTrue(result.mustNot().get(1) instanceof TermQueryBuilder);
        assertEquals("value2", filterClause2.value());  
        // Create empty query containers that will return null  
            .build();
 * this file be licensed under the Apache-2.0 license or a
        super.setUp();
        BoolQueryBuilder result = fromProto(boolQuery, registry);  
        BoolQueryBuilder result = fromProto(boolQuery, registry);
            .setXName("test_query")
        assertEquals("field1", mustClause.fieldName());
        assertEquals("2", result.minimumShouldMatch());
            .build();
            .addShould(createTermQueryContainer("field3", "value3"))  
        // Call the method under test  
        assertEquals(2, result.mustNot().size());
        assertEquals("value1", filterClause1.value());
            .build();
    }
        assertEquals("value3", shouldClause1.value());  
        assertTrue(result.should().get(1) instanceof TermQueryBuilder);
 *
        // Verify the should clauses
        assertTrue(result.filter().get(0) instanceof MatchAllQueryBuilder);
        // Create a BoolQuery with all clause types containing null-returning queries  
    }
        BoolQueryBuilder result = fromProto(boolQuery, registry);  
    public void testFromProtoWithAdjustPureNegative() {
        assertTrue(result.mustNot().get(0) instanceof TermQueryBuilder);
        assertTrue(result.must().get(0) instanceof TermQueryBuilder);  
            .addMust(createTermQueryContainer("valid_field", "valid_value"))  // Valid query  
        // Verify the result
            .addMust(createTermQueryContainer("field1", "value1"))
        assertTrue(result.should().get(1) instanceof TermQueryBuilder);
        assertEquals("field2", mustClause2.fieldName());
    private QueryBuilderProtoConverterRegistryImpl registry;
            .setBoost(2.0f)
        // Call the method under test
        // Set up a mock registry that returns null for empty query containers
import org.opensearch.index.query.TermQueryBuilder;  
        assertEquals("Should have 0 mustNot clauses (null ones ignored)", 0, result.mustNot().size());
            .build();  
    }
    }
            .build();
        QueryContainer emptyQueryContainer = QueryContainer.newBuilder().build();
        assertEquals("value2", mustClause2.value());  
        TermQueryBuilder termQuery = (TermQueryBuilder) result.must().get(0);
            .build();  
            .addMustNot(emptyQueryContainer)   // Should return null and be ignored  
    public void testFromProtoWithMustNotClauses() {  
        assertEquals("value2", shouldClause2.value());
        TermQueryBuilder shouldClause1 = (TermQueryBuilder) result.should().get(0);
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())
        assertEquals("field3", shouldClause1.fieldName());
        // Verify the must_not clause
        // Call the method under test  
        MinimumShouldMatch minimumShouldMatch = MinimumShouldMatch.newBuilder().build();  
            .build();
        assertNull(result.minimumShouldMatch());  
