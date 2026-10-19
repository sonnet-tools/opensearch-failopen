        TermQuery termQuery = TermQuery.newBuilder()
            .build();
    public void testFromProtoWithNullNestedQuery() {
        assertEquals("Exception message should match", "Path is required for NestedQuery", exception.getMessage());
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)
        // Test setting ignoreUnmapped to true
    }
        InnerHits innerHits = InnerHits.newBuilder().setName("user_hits").setSize(10).build();
            .setValue(FieldValue.newBuilder().setString("active").build())
import org.opensearch.protobufs.NestedQuery;
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)
            .setValue(FieldValue.newBuilder().setString("active").build())
            .setValue(FieldValue.newBuilder().setString("john").build())
        assertEquals("Query name should match", "optional_params_query", queryBuilder.queryName());
            .setPath("user")
            IllegalArgumentException.class,
            .setQuery(innerQueryContainer)
        TermQuery termQuery = TermQuery.newBuilder()
            .setQuery(innerQueryContainer)
        );
            exception.getMessage().contains("Failed to convert inner query for NestedQuery")
        IllegalArgumentException exception = expectThrows(
            .setPath("user")
import org.opensearch.protobufs.FieldValue;
        assertNotNull("Inner hits should not be null", queryBuilder.innerHit());
import org.opensearch.protobufs.InnerHits;
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();
        assertEquals("Score mode should be Max", ScoreMode.Max, queryBuilder.scoreMode());
        assertEquals("Boost should match", 1.5f, queryBuilder.boost(), 0.001f);
            .setPath("user")
        NestedQuery maxQuery = NestedQuery.newBuilder()
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
            .build();
        assertEquals("Inner hits name should match", "product_hits", queryBuilder.innerHit().getName());
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
        // Test MIN score mode
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            // No setScoreMode() call - should use default ScoreMode.Avg
        InnerHits innerHits = InnerHits.newBuilder().setName("product_hits").setSize(5).setFrom(0).build();
        NestedQueryBuilder minBuilder = NestedQueryBuilderProtoUtils.fromProto(minQuery, registry);
        NestedQuery nestedQuery = NestedQuery.newBuilder()
        );
    private QueryBuilderProtoConverterRegistryImpl registry;
        // Test all score modes to achieve full coverage of parseScoreMode method
    }
        );
            .setPath("user")
    }
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        IllegalArgumentException exception = expectThrows(
        // Test when no score mode is set - should default to ScoreMode.Avg
            .setName("valid_name")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setIgnoreUnmapped(true)
    public void testFromProtoWithInvalidInnerHitsConversion() {
        NestedQueryBuilder noneBuilder = NestedQueryBuilderProtoUtils.fromProto(noneQuery, registry);
            .setXName("optional_params_query")
        // Test setting ignoreUnmapped to false
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        );
    public void testFromProtoWithDifferentScoreModes() {
        assertTrue(
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(emptyQueryContainer).build();
        super.setUp();
            .setQuery(innerQueryContainer)
        NestedQueryBuilder noneBuilder = NestedQueryBuilderProtoUtils.fromProto(noneQuery, registry);
            .setInnerHits(innerHits)
 * The OpenSearch Contributors require contributions made to
            .setField("user.status")
            .setValue(FieldValue.newBuilder().setString("john").build())
            .setPath("user")
            .setField("user.name")
import org.apache.lucene.search.join.ScoreMode;
    public void testFromProtoWithUnspecifiedScoreMode() {
        assertEquals("Score mode should be Avg", ScoreMode.Avg, avgBuilder.scoreMode());
            .build();
            .build();
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
        // Test with invalid inner hits to trigger exception handling
            .setField("user.name")
        TermQuery termQuery = TermQuery.newBuilder()
            }
package org.opensearch.transport.grpc.proto.request.search.query;
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
 * this file be licensed under the Apache-2.0 license or a
            .setValue(FieldValue.newBuilder().setString("test@example.com").build())
                FieldValue.newBuilder()
        assertEquals("Default score mode should be Avg when not set", ScoreMode.Avg, queryBuilder.scoreMode());
            .build();
        IllegalArgumentException exception = expectThrows(
        // Using an invalid size that should trigger an exception in InnerHitsBuilderProtoUtils
            .setQuery(innerQueryContainer)
            .setInnerHits(invalidInnerHits)
        IllegalArgumentException exception = expectThrows(
    }
        );
            .setField("user.name")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .build();
            .build();
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
            .setPath("user.profile")
            .setQuery(innerQueryContainer)
            .build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt32Value(25).build())
    public void testFromProtoWithEmptyPath() {
        assertEquals("Query name should match", "nested_user_query", queryBuilder.queryName());
            .setField("user.status")
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Score mode should be Total", ScoreMode.Total, sumBuilder.scoreMode());
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_UNSPECIFIED)
import org.opensearch.protobufs.ChildScoreMode;
            .setXName("nested_user_query")
            .setField("products.category")
            .setPath("user")
            .setValue(FieldValue.newBuilder().setString("john").build())
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setQuery(innerQueryContainer)
        assertEquals("Exception message should match", "Path is required for NestedQuery", exception.getMessage());
        assertEquals("Path should match", "products", queryBuilder.path());
        NestedQuery nestedQuery = NestedQuery.newBuilder().setQuery(innerQueryContainer).build();
    public void testFromProtoWithAllScoreModes() {
        );
        assertEquals("Score mode should be Max", ScoreMode.Max, queryBuilder.scoreMode());
            .build();
            exception.getMessage().contains("Failed to convert inner hits for NestedQuery")
/*
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();
            IllegalArgumentException.class,
    }
        // Test AVG score mode
            IllegalArgumentException.class,
        assertEquals("Exception message should match", "NestedQuery cannot be null", exception.getMessage());
            .setPath("user")
    @Override
            .build();
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("").setQuery(innerQueryContainer).build();
        assertTrue("Ignore unmapped should be true", queryBuilder.ignoreUnmapped());
        assertEquals("Score mode should be None", ScoreMode.None, noneBuilder.scoreMode());
        // Test exception handling when inner query conversion fails
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
        registry = new QueryBuilderProtoConverterRegistryImpl();
    }
            .setField("user.email")
            .setBoost(1.5f)
            .setQuery(innerQueryContainer)
            .build();
        // This should throw an exception when trying to convert the inner query
            .setValue(FieldValue.newBuilder().setString("admin").build())
            .setQuery(innerQueryContainer)
            .setValue(FieldValue.newBuilder().setString("electronics").build())
        IllegalArgumentException exception = expectThrows(
        assertEquals("Path should match", "user", queryBuilder.path());
    }
        assertFalse("Ignore unmapped should be false", queryBuilder.ignoreUnmapped());
        TermQuery termQuery = TermQuery.newBuilder()
            IllegalArgumentException.class,
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setPath("user")
        );
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .build();
        // Test MAX score mode
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            )
            .setValue(
            .setValue(FieldValue.newBuilder().setString("active").build())
import org.opensearch.protobufs.TermQuery;
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)
        TermQuery termQuery = TermQuery.newBuilder()
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
            "Exception message should contain 'Failed to convert inner hits'",
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
            .build();
            .build();
        // Create inner hits with invalid configuration that will cause conversion to fail
        NestedQueryBuilder minBuilder = NestedQueryBuilderProtoUtils.fromProto(minQuery, registry);
        assertNotNull("Inner hits should not be null", queryBuilder.innerHit());
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setValue(FieldValue.newBuilder().setString("dark").build())
        // Don't set score mode - this will test the default behavior
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, queryBuilder.scoreMode());
        // Set up the registry with all built-in converters
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
        assertEquals("Path should match", "user.profile", queryBuilder.path());
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
            .build();
        assertEquals("Default score mode should be Avg for unspecified", ScoreMode.Avg, queryBuilder.scoreMode());
            .setName("test_inner_hits")
            .setValue(FieldValue.newBuilder().setString("john").build())
}
        NestedQueryBuilder sumBuilder = NestedQueryBuilderProtoUtils.fromProto(sumQuery, registry);
        NestedQuery minQuery = NestedQuery.newBuilder()
        // Test exception handling when inner hits conversion fails
            .setField("user.status")
            IllegalArgumentException.class,
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
        assertEquals("Path should match", "user", queryBuilder.path());
        // Test SUM score mode (maps to Total in Lucene)
            .setField("user.status")
    }
        );
        TermQuery termQuery = TermQuery.newBuilder()
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
            .setValue(FieldValue.newBuilder().setString("john").build())
        IllegalArgumentException exception = expectThrows(
 */
            .setSize(-1) // Invalid size - should trigger exception
        assertEquals("Exception message should match", "Query is required for NestedQuery", exception.getMessage());
            .build();
        IllegalArgumentException exception = expectThrows(
    }
            .build();
            "Exception message should contain 'Failed to convert inner hits'",
            .build();
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        QueryContainer emptyQueryContainer = QueryContainer.newBuilder().build();
        NestedQuery nestedQuery = NestedQuery.newBuilder()
    public void testFromProtoWithOptionalParametersOnly() {
        TermQuery termQuery = TermQuery.newBuilder()
        NestedQuery sumQuery = NestedQuery.newBuilder()
            .setField("user.name")
            .setPath("user")
        assertEquals("Score mode should be None", ScoreMode.None, noneBuilder.scoreMode());
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        // Create an empty QueryContainer to simulate invalid query conversion
        // Create inner hits that will cause conversion to fail
        TermQuery termQuery = TermQuery.newBuilder()
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setQuery(innerQueryContainer)
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        TermQuery termQuery = TermQuery.newBuilder()
            IllegalArgumentException.class,
            .setSize(-1) // Invalid size - should trigger exception
    }
    public void testFromProtoWithIgnoreUnmappedTrue() {
    public void testFromProtoWithNullPath() {
        TermQuery termQuery = TermQuery.newBuilder()
    public void testFromProtoWithMissingQuery() {
            .build();
            .setQuery(innerQueryContainer)
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            "Exception message should contain 'Failed to convert inner query'",
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
            .build();
            .build();
            .setField("user.age")
        QueryBuilderProtoConverterRegistryImpl mockRegistry = new QueryBuilderProtoConverterRegistryImpl() {
    }
        assertNotNull("Inner query should not be null", queryBuilder.query());
        // This should throw an exception due to invalid inner hits configuration
        assertTrue("Exception message should contain the cause", exception.getMessage().contains("Simulated conversion failure"));
public class NestedQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setPath("products")
        assertEquals("Boost should match", 2.0f, queryBuilder.boost(), 0.001f);
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        );
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
        );
        assertEquals("Score mode should be Min", ScoreMode.Min, minBuilder.scoreMode());
            .setIgnoreUnmapped(false)
    public void testFromProtoWithInvalidQueryConversion() {
            .setQuery(innerQueryContainer)
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        IllegalArgumentException exception = expectThrows(
        NestedQuery noneQuery = NestedQuery.newBuilder()
    public void testFromProtoWithComplexNestedPath() {
    public void testFromProtoWithInvalidInnerQuery() {
            "Exception message should contain 'Failed to convert inner query'",
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testFromProtoWithAllParameters() {
            .build();
        NestedQuery noneQuery = NestedQuery.newBuilder()
            exception.getMessage().contains("Failed to convert inner hits for NestedQuery")
    }
        NestedQueryBuilder maxBuilder = NestedQueryBuilderProtoUtils.fromProto(maxQuery, registry);
        assertTrue(
        org.opensearch.protobufs.InnerHits invalidInnerHits = org.opensearch.protobufs.InnerHits.newBuilder()
        // Create a basic nested query with term query as inner query
    public void testFromProtoWithIgnoreUnmappedFalse() {
        assertTrue(
            .setInnerHits(innerHits)
import org.opensearch.index.query.NestedQueryBuilder;
        // Create a term query as inner query
        TermQuery termQuery = TermQuery.newBuilder()
        NestedQuery avgQuery = NestedQuery.newBuilder()
            .build();
    public void testFromProtoWithInnerHitsOnly() {
    }
    }
            .setField("user.profile.settings.theme")
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, mockRegistry)
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .build();
            .build();
            .build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setQuery(innerQueryContainer)
        // Create inner hits
            .setQuery(innerQueryContainer)
        assertEquals("Score mode should be Total", ScoreMode.Total, sumBuilder.scoreMode());
        );
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setIgnoreUnmapped(false).build();
import org.opensearch.protobufs.QueryContainer;
    }
        assertEquals("Score mode should be Max", ScoreMode.Max, maxBuilder.scoreMode());
            .setValue(FieldValue.newBuilder().setString("active").build())
        // Test SUM score mode (maps to Total in Lucene)
            .build();
            .setPath("user")
    public void setUp() throws Exception {
            .build();
        assertTrue(
    }
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
        assertEquals("Inner hits size should match", 5, queryBuilder.innerHit().getSize());
        // Create a mock registry that throws an exception
            .setBoost(2.0f)
            .build();
        NestedQueryBuilder avgBuilder = NestedQueryBuilderProtoUtils.fromProto(avgQuery, registry);
                throw new RuntimeException("Simulated conversion failure");
 * compatible open source license.
        InnerHits invalidInnerHits = InnerHits.newBuilder()
    public void testFromProtoWithBasicNestedQuery() {
            .setPath("user")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        assertEquals("Score mode should be Min", ScoreMode.Min, minBuilder.scoreMode());
        assertTrue("Ignore unmapped should be true", queryBuilder.ignoreUnmapped());
        );
        TermQuery termQuery = TermQuery.newBuilder()
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
            .build();
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            () -> NestedQueryBuilderProtoUtils.fromProto(null, registry)
        // Test MIN score mode
            .setValue(FieldValue.newBuilder().setString("active").build())
            exception.getMessage().contains("Failed to convert inner query for NestedQuery")
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)
        // Test NONE score mode
            .setField("user.role")
            .setField("user.name")
            .setQuery(innerQueryContainer)
            .setPath("user")
            .setField("user.name")
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setQuery(innerQueryContainer)
        // Test NONE score mode
 *
            .build();
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, queryBuilder.scoreMode());
            .setField("user.status")
    public void testFromProtoWithInvalidInnerHits() {
            .build();
            .setValue(FieldValue.newBuilder().setString("john").build())
        TermQuery termQuery = TermQuery.newBuilder()
        assertFalse("Ignore unmapped should be false", queryBuilder.ignoreUnmapped());
            .build();
    }
import org.opensearch.test.OpenSearchTestCase;
                    .build()
    }
        NestedQuery minQuery = NestedQuery.newBuilder()
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").build();
            .setInnerHits(invalidInnerHits)
        NestedQuery sumQuery = NestedQuery.newBuilder()
            .setPath("user")
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setPath("user")
    public void testParseScoreModeDefaultCase() {
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setIgnoreUnmapped(true).build();
        NestedQueryBuilder sumBuilder = NestedQueryBuilderProtoUtils.fromProto(sumQuery, registry);
        assertEquals("Path should match", "user", queryBuilder.path());
        TermQuery termQuery = TermQuery.newBuilder()
            IllegalArgumentException.class,
            @Override
            .setQuery(innerQueryContainer)
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
    }
        };
            IllegalArgumentException.class,
