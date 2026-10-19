        assertEquals("field1", mustClause1.fieldName());
        assertEquals(1, result.must().size());
        TermQueryBuilder shouldClause1 = (TermQueryBuilder) result.should().get(0);
        // Verify the filter clause
        // Verify the result
        // Verify the should clauses
        assertTrue(result.filter().get(0) instanceof TermQueryBuilder);
        // Create a protobuf BoolQuery with string minimum_should_match
    }
    public void testFromProtoWithStringMinimumShouldMatch() {
        // Verify the result
        BoolQuery boolQuery = BoolQuery.newBuilder()
    }
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        assertEquals("2", result.minimumShouldMatch());
        // Set up the registry with all built-in converters
    }
            .addMustNot(emptyQueryContainer)   // Should return null and be ignored
            .build();
        assertTrue(result.mustNot().get(1) instanceof TermQueryBuilder);
        assertEquals("value4", shouldClause2.value());
 *
        assertEquals("value3", shouldClause1.value());
            .addMustNot(createTermQueryContainer("field2", "value2"))
                // Return null for empty query containers to test null handling
        assertEquals(1, result.mustNot().size());
        // Verify the result
        TermQueryBuilder filterClause1 = (TermQueryBuilder) result.filter().get(0);
            }
            .addMust(createTermQueryContainer("field1", "value1"))
        // Verify the result
        BoolQueryBuilder result = fromProto(boolQuery, registry);
            .build();
        assertEquals("value2", mustNotClause.value());
        assertEquals("value2", filterClause2.value());
        assertEquals("value1", shouldClause1.value());
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
    public void testFromProtoWithMinimumShouldMatchDefaultCase() {
    }
        assertEquals("field2", shouldClause2.fieldName());
        assertEquals(0, result.filter().size());
        return QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build();
        return QueryContainer.newBuilder()
        assertEquals(2.0f, result.boost(), 0.001f);
    }
        assertTrue(result.must().get(0) instanceof TermQueryBuilder);
        MinimumShouldMatch minimumShouldMatch = MinimumShouldMatch.newBuilder().build();
            .build();
import org.opensearch.protobufs.FieldValue;
        TermQueryBuilder shouldClause2 = (TermQueryBuilder) result.should().get(1);
        BoolQuery boolQuery = BoolQuery.newBuilder()
/*
            .addMustNot(createTermQueryContainer("field1", "value1"))
        assertEquals(0, result.should().size());
        assertTrue("Valid must clause should be TermQueryBuilder", result.must().get(0) instanceof TermQueryBuilder);
 * compatible open source license.
        // Verify the filter clauses
        registry = new QueryBuilderProtoConverterRegistryImpl();
        assertEquals("field2", mustNotClause2.fieldName());
        // Verify the result - only the valid query should be added
        assertEquals(1.0f, result.boost(), 0.001f);
        TermQueryBuilder mustNotClause = (TermQueryBuilder) result.mustNot().get(0);
        BoolQuery boolQuery = BoolQuery.newBuilder().build();
            .addMust(createTermQueryContainer("field2", "value2"))
                return super.fromProto(queryContainer);
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        BoolQuery boolQuery = BoolQuery.newBuilder()
        assertEquals("Should have 0 filter clauses (null ones ignored)", 0, result.filter().size());
        // Create a protobuf BoolQuery with multiple should clauses
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        // Create a protobuf BoolQuery with multiple must_not clauses
        assertTrue(result.mustNot().get(0) instanceof TermQueryBuilder);
            .addShould(createTermQueryContainer("field3", "value3"))
import org.opensearch.protobufs.QueryContainer;
        assertTrue(result.must().get(1) instanceof TermQueryBuilder);
        // Call the method under test
            .setBoost(2.0f)
    public void testFromProtoWithMustClauses() {
        assertEquals("value2", shouldClause2.value());
 * The OpenSearch Contributors require contributions made to
    private QueryContainer createTermQueryContainer(String field, String value) {
        assertEquals("field1", mustNotClause1.fieldName());
            .addShould(createTermQueryContainer("field2", "value2"))
                if (queryContainer.getQueryContainerCase() == QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET) {
        assertEquals("field1", shouldClause1.fieldName());
        // Call the method under test
        assertTrue(result.filter().get(1) instanceof TermQueryBuilder);
        QueryContainer emptyQueryContainer = QueryContainer.newBuilder().build();
    public void testFromProtoWithAdjustPureNegative() {
        // Create a protobuf BoolQuery with unset minimum_should_match case (MINIMUMSHOULDMATCH_NOT_SET)
        super.setUp();
    }
        // Verify the valid must clause
    public void setUp() throws Exception {
        TermQueryBuilder filterClause2 = (TermQueryBuilder) result.filter().get(1);
        assertEquals(0, result.must().size());
            .addFilter(createTermQueryContainer("field2", "value2"))
 * this file be licensed under the Apache-2.0 license or a
        // Verify the result - should not have minimum_should_match set
        TermQueryBuilder mustClause2 = (TermQueryBuilder) result.must().get(1);
        // Create a protobuf BoolQuery with all fields
import org.opensearch.protobufs.MatchAllQuery;
            .addMust(createTermQueryContainer("valid_field", "valid_value"))  // Valid query
                }
    private QueryContainer createMatchAllQueryContainer() {
        // Verify the result
        // Create empty query containers that will return null
        // Verify the should clauses
        assertNull(result.queryName());
        assertEquals("value1", filterClause1.value());
            .build();
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        assertEquals(2, result.mustNot().size());
        assertEquals("75%", result.minimumShouldMatch());
        TermQueryBuilder mustClause1 = (TermQueryBuilder) result.must().get(0);
    public void testFromProtoWithNullQueryBuilders() {
        assertTrue(result.should().get(1) instanceof TermQueryBuilder);
        assertEquals("value2", mustClause2.value());
    }
        BoolQuery boolQuery = BoolQuery.newBuilder()
        BoolQueryBuilder result = fromProto(boolQuery, registry);
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())
            .setTerm(TermQuery.newBuilder().setField(field).setValue(FieldValue.newBuilder().setString(value).build()).build())
            .addFilter(createMatchAllQueryContainer())
        BoolQueryBuilder result = fromProto(boolQuery, mockRegistry);
import org.opensearch.index.query.BoolQueryBuilder;
import org.opensearch.protobufs.MinimumShouldMatch;
            .setXName("test_query")
        assertNull("Should not have minimum_should_match for default case", result.minimumShouldMatch());
package org.opensearch.transport.grpc.proto.request.search.query;
        // Verify the must clauses
        BoolQuery boolQuery = BoolQuery.newBuilder()
        };
    private QueryBuilderProtoConverterRegistryImpl registry;
        assertEquals("valid_field", termQuery.fieldName());
        // Verify the must_not clause
            .addShould(createTermQueryContainer("field1", "value1"))
        TermQueryBuilder shouldClause2 = (TermQueryBuilder) result.should().get(1);
        assertEquals("Should have 1 must clause (null ones ignored)", 1, result.must().size());
            .addMust(emptyQueryContainer)      // Should return null and be ignored
        // Call the method under test
    }
        assertTrue(result.should().get(1) instanceof TermQueryBuilder);
        // Call the method under test
import org.opensearch.protobufs.TermQuery;
        TermQueryBuilder termQuery = (TermQueryBuilder) result.must().get(0);
        BoolQueryBuilder result = fromProto(boolQuery, registry);
    public void testFromProtoWithAllFields() {
        assertEquals(2, result.should().size());
            .addMust(createTermQueryContainer("field1", "value1"))
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals("Should have 0 mustNot clauses (null ones ignored)", 0, result.mustNot().size());
            .addFilter(emptyQueryContainer)    // Should return null and be ignored
        TermQueryBuilder shouldClause1 = (TermQueryBuilder) result.should().get(0);
        assertEquals("value1", mustClause1.value());
        assertTrue(result.should().get(0) instanceof TermQueryBuilder);
        // Create a protobuf BoolQuery with multiple must clauses
        // Call the method under test
        assertTrue(result.should().get(0) instanceof TermQueryBuilder);
        assertEquals("value1", mustNotClause1.value());
            .addShould(emptyQueryContainer)    // Should return null and be ignored
        // Verify the must clause
        TermQueryBuilder mustClause = (TermQueryBuilder) result.must().get(0);
            .addFilter(createTermQueryContainer("field1", "value1"))
    }
            .build();
        BoolQuery boolQuery = BoolQuery.newBuilder().setMinimumShouldMatch(minimumShouldMatch).build();
        assertEquals("field2", mustClause2.fieldName());
        assertEquals(2, result.must().size());
        BoolQuery boolQuery = BoolQuery.newBuilder().setAdjustPureNegative(false).build();
        assertEquals("Should have 0 should clauses (null ones ignored)", 0, result.should().size());
    public void testFromProtoWithShouldClauses() {
        TermQueryBuilder mustNotClause1 = (TermQueryBuilder) result.mustNot().get(0);
        assertTrue(result.mustNot().get(0) instanceof TermQueryBuilder);
        // Call the method under test
            .build();
        assertTrue(result.filter().get(0) instanceof MatchAllQueryBuilder);
            @Override
        assertEquals(2, result.filter().size());
        assertEquals("valid_value", termQuery.value());
        // Call the method under test
        assertEquals("field3", shouldClause1.fieldName());
    public void testFromProtoWithMinimalFields() {
import org.opensearch.index.query.MatchAllQueryBuilder;
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        assertEquals(0, result.mustNot().size());
        // Set up a mock registry that returns null for empty query containers
        assertEquals("field2", filterClause2.fieldName());
        // Verify the result
            .addMustNot(createTermQueryContainer("field2", "value2"))
        assertEquals("field4", shouldClause2.fieldName());
            .addShould(createTermQueryContainer("field4", "value4"))
    }
        // Verify the result
    @Override
        BoolQuery boolQuery = BoolQuery.newBuilder()
        assertFalse("Adjust pure negative should be false", result.adjustPureNegative());
    }
        BoolQueryBuilder result = fromProto(boolQuery, registry);
        assertEquals(1, result.filter().size());
        assertEquals(2, result.should().size());
import static org.opensearch.transport.grpc.proto.request.search.query.BoolQueryBuilderProtoUtils.fromProto;
        assertEquals("field1", filterClause1.fieldName());
    }
        assertEquals("test_query", result.queryName());
        assertTrue(result.must().get(0) instanceof TermQueryBuilder);
        // Create a protobuf BoolQuery with only required fields
        assertNull(result.minimumShouldMatch());
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setInt32(2).build())
        QueryBuilderProtoConverterRegistryImpl mockRegistry = new QueryBuilderProtoConverterRegistryImpl() {
                    return null; // Simulate unsupported query type
        // Create a protobuf BoolQuery with adjust_pure_negative = false
        assertEquals("field1", mustClause.fieldName());
import org.opensearch.test.OpenSearchTestCase;
            .build();
        TermQueryBuilder mustNotClause2 = (TermQueryBuilder) result.mustNot().get(1);
        // Create a protobuf BoolQuery with multiple filter clauses
            .build();
import org.opensearch.protobufs.BoolQuery;
        assertEquals("value2", mustNotClause2.value());
        BoolQuery boolQuery = BoolQuery.newBuilder()
        assertEquals("field2", mustNotClause.fieldName());
 */
        // Call the method under test
        // Call the method under test
    public void testFromProtoWithMustNotClauses() {
        // Call the method under test
public class BoolQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
    }
}
        assertEquals("value1", mustClause.value());
        // Verify the must_not clauses
 * SPDX-License-Identifier: Apache-2.0
    public void testFromProtoWithFilterClauses() {
        // Verify the result
        // Create a BoolQuery with all clause types containing null-returning queries
