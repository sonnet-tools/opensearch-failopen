            exception.getMessage().contains("Failed to convert inner query for NestedQuery")
        );
        assertEquals("Boost should match", 2.0f, queryBuilder.boost(), 0.001f);  
    }
        NestedQuery minQuery = NestedQuery.newBuilder()  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
/*  
        assertEquals("Exception message should match", "Path is required for NestedQuery", exception.getMessage());
    public void testFromProtoWithInvalidInnerHitsConversion() {  
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").build();
    }
        TermQuery termQuery = TermQuery.newBuilder()
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        assertEquals("Exception message should match", "Query is required for NestedQuery", exception.getMessage());
            "Exception message should contain 'Failed to convert inner query'",
import org.opensearch.protobufs.InnerHits;
        // Test AVG score mode
            .setField("user.age")
        TermQuery termQuery = TermQuery.newBuilder()
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setPath("user")
        );
            .setPath("user")
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)  
    public void testParseScoreModeDefaultCase() {
            .build();  
import org.opensearch.protobufs.TermQuery;
                throw new RuntimeException("Simulated conversion failure");  
            .setValue(FieldValue.newBuilder().setString("active").build())
    public void testFromProtoWithOptionalParametersOnly() {
    public void testFromProtoWithInvalidQueryConversion() {  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)  
            .setQuery(innerQueryContainer)  
            .setXName("optional_params_query")
    }
 * SPDX-License-Identifier: Apache-2.0
        TermQuery termQuery = TermQuery.newBuilder()  
            IllegalArgumentException.class,
    }
    }
            .setField("user.name")  
        assertEquals("Inner hits size should match", 5, queryBuilder.innerHit().getSize());
        assertEquals("Score mode should be Total", ScoreMode.Total, sumBuilder.scoreMode());  
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
package org.opensearch.transport.grpc.proto.request.search.query;
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setIgnoreUnmapped(true).build();
        IllegalArgumentException exception = expectThrows(
        // Test NONE score mode  
        NestedQueryBuilder avgBuilder = NestedQueryBuilderProtoUtils.fromProto(avgQuery, registry);
            .setInnerHits(invalidInnerHits)  
            .setValue(FieldValue.newBuilder().setString("admin").build())  
            .build();
            .build();
        NestedQuery sumQuery = NestedQuery.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()
    }
        NestedQuery maxQuery = NestedQuery.newBuilder()
    }
            // No setScoreMode() call - should use default ScoreMode.Avg  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .build();  
            .build();  
        NestedQueryBuilder noneBuilder = NestedQueryBuilderProtoUtils.fromProto(noneQuery, registry);
        assertEquals("Score mode should be Min", ScoreMode.Min, minBuilder.scoreMode());
    public void testFromProtoWithBasicNestedQuery() {  
        TermQuery termQuery = TermQuery.newBuilder()  
            .setInnerHits(innerHits)
            .build();
            public org.opensearch.index.query.QueryBuilder fromProto(QueryContainer queryContainer) {
        assertEquals("Path should match", "user.profile", queryBuilder.path());  
            .build();  
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
        assertEquals("Boost should match", 1.5f, queryBuilder.boost(), 0.001f);
    }
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
            .setField("user.name")  
    }
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_UNSPECIFIED)
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .build();  
    public void testFromProtoWithInnerHitsOnly() {  
        // Test when no score mode is set - should default to ScoreMode.Avg  
        assertEquals("Query name should match", "optional_params_query", queryBuilder.queryName());
        assertFalse("Ignore unmapped should be false", queryBuilder.ignoreUnmapped());  
        assertTrue(
    public void testFromProtoWithAllParameters() {
            .build();
        NestedQuery nestedQuery = NestedQuery.newBuilder()
    @Override
            .build();
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, queryBuilder.scoreMode());  
        TermQuery termQuery = TermQuery.newBuilder()
        // Create a mock registry that throws an exception
        assertEquals("Score mode should be None", ScoreMode.None, noneBuilder.scoreMode());
            .setField("user.name")  
                    .build()
        IllegalArgumentException exception = expectThrows(
        // Create a basic nested query with term query as inner query
        NestedQueryBuilder maxBuilder = NestedQueryBuilderProtoUtils.fromProto(maxQuery, registry);
        NestedQueryBuilder minBuilder = NestedQueryBuilderProtoUtils.fromProto(minQuery, registry);  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
import org.opensearch.protobufs.FieldValue;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
            .setField("user.profile.settings.theme")  
            .setQuery(innerQueryContainer)
        );
        // Create an empty QueryContainer to simulate invalid query conversion
            .setQuery(innerQueryContainer)
            .setField("user.role")
        TermQuery termQuery = TermQuery.newBuilder()
            .setQuery(innerQueryContainer)
import org.opensearch.protobufs.NestedQuery;
            IllegalArgumentException.class,
        // Test all score modes to achieve full coverage of parseScoreMode method
        );
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();  
        // This should throw an exception due to invalid inner hits configuration  
        NestedQuery avgQuery = NestedQuery.newBuilder()
        NestedQuery sumQuery = NestedQuery.newBuilder()
            }
        assertTrue(
        assertTrue(  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
            .setPath("products")
            .setValue(FieldValue.newBuilder().setString("active").build())
        NestedQueryBuilder minBuilder = NestedQueryBuilderProtoUtils.fromProto(minQuery, registry);  
    }
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setValue(FieldValue.newBuilder().setString("john").build())
            .setIgnoreUnmapped(false)  
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("").setQuery(innerQueryContainer).build();
    private QueryBuilderProtoConverterRegistryImpl registry;  
    }
        // Test setting ignoreUnmapped to false
            .setPath("user")
        TermQuery termQuery = TermQuery.newBuilder()  
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
            .setPath("user")  
    public void testFromProtoWithUnspecifiedScoreMode() {  
public class NestedQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        );  
        InnerHits innerHits = InnerHits.newBuilder().setName("user_hits").setSize(10).build();  
        // Create inner hits
        assertTrue("Exception message should contain the cause", exception.getMessage().contains("Simulated conversion failure"));  
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(emptyQueryContainer).build();
        assertEquals("Score mode should be Max", ScoreMode.Max, queryBuilder.scoreMode());
            .build();
    public void testFromProtoWithIgnoreUnmappedTrue() {
        NestedQuery minQuery = NestedQuery.newBuilder()  
            .setValue(FieldValue.newBuilder().setString("test@example.com").build())
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)  
    }
        NestedQuery nestedQuery = NestedQuery.newBuilder()  
            .setField("user.status")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        assertEquals("Path should match", "user", queryBuilder.path());
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt32Value(25).build())
        // Using an invalid size that should trigger an exception in InnerHitsBuilderProtoUtils
            "Exception message should contain 'Failed to convert inner hits'",  
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);  
        // This should throw an exception when trying to convert the inner query
    }
            .setIgnoreUnmapped(true)  
            .setPath("user")
            .build();
    public void setUp() throws Exception {  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            exception.getMessage().contains("Failed to convert inner hits for NestedQuery")
 * compatible open source license.
            .setPath("user")  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
                FieldValue.newBuilder()  
            .setValue(FieldValue.newBuilder().setString("john").build())
        assertEquals("Inner hits name should match", "product_hits", queryBuilder.innerHit().getName());  
            .setQuery(innerQueryContainer)  
            .setQuery(innerQueryContainer)
        // Test exception handling when inner hits conversion fails
 * The OpenSearch Contributors require contributions made to  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setXName("nested_user_query")
            .setSize(-1) // Invalid size - should trigger exception
            "Exception message should contain 'Failed to convert inner query'",  
            .setField("user.status")
            .build();
            .build();
            .setQuery(innerQueryContainer)
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
            .setPath("user")  
        assertEquals("Default score mode should be Avg when not set", ScoreMode.Avg, queryBuilder.scoreMode());
    }
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .build();  
        QueryContainer emptyQueryContainer = QueryContainer.newBuilder().build();  
            IllegalArgumentException.class,
            .build();  
            exception.getMessage().contains("Failed to convert inner hits for NestedQuery")
        NestedQuery nestedQuery = NestedQuery.newBuilder()  
            .setValue(
            () -> NestedQueryBuilderProtoUtils.fromProto(null, registry)  
        // Test setting ignoreUnmapped to true
            .build();
        TermQuery termQuery = TermQuery.newBuilder()  
            .build();
        assertEquals("Exception message should match", "Path is required for NestedQuery", exception.getMessage());  
            .setPath("user")
            .build();
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            IllegalArgumentException.class,
        assertEquals("Exception message should match", "NestedQuery cannot be null", exception.getMessage());
        assertEquals("Score mode should be Max", ScoreMode.Max, maxBuilder.scoreMode());  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        TermQuery termQuery = TermQuery.newBuilder()  
        };
    }  
        TermQuery termQuery = TermQuery.newBuilder()  
        // Test NONE score mode  
        NestedQueryBuilder sumBuilder = NestedQueryBuilderProtoUtils.fromProto(sumQuery, registry);
import org.opensearch.index.query.NestedQueryBuilder;
 */  
    public void testFromProtoWithIgnoreUnmappedFalse() {
            .build();
            .setValue(FieldValue.newBuilder().setString("active").build())  
 * this file be licensed under the Apache-2.0 license or a
        // Create inner hits that will cause conversion to fail  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
            .setField("user.status")
        IllegalArgumentException exception = expectThrows(
        // Create a term query as inner query
            .setValue(FieldValue.newBuilder().setString("john").build())
        NestedQuery nestedQuery = NestedQuery.newBuilder().setQuery(innerQueryContainer).build();  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)
            .setPath("user")  
    public void testFromProtoWithNullNestedQuery() {  
    public void testFromProtoWithNullPath() {
    }  
            .build();
        // Create inner hits with invalid configuration that will cause conversion to fail  
        TermQuery termQuery = TermQuery.newBuilder()  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
            .setSize(-1) // Invalid size - should trigger exception  
            .setField("user.status")
            @Override
    }  
        assertNotNull("Inner hits should not be null", queryBuilder.innerHit());
        assertEquals("Path should match", "products", queryBuilder.path());
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, mockRegistry)  
        IllegalArgumentException exception = expectThrows(  
        IllegalArgumentException exception = expectThrows(
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, queryBuilder.scoreMode());
        assertNotNull("Inner query should not be null", queryBuilder.query());  
import org.apache.lucene.search.join.ScoreMode;  
            .setQuery(innerQueryContainer)  
        );
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setQuery(innerQueryContainer)
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)
        assertFalse("Ignore unmapped should be false", queryBuilder.ignoreUnmapped());
            .setInnerHits(invalidInnerHits)
            .setQuery(innerQueryContainer)
        IllegalArgumentException exception = expectThrows(  
        assertEquals("Score mode should be Total", ScoreMode.Total, sumBuilder.scoreMode());  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
            .setValue(FieldValue.newBuilder().setString("active").build())
    public void testFromProtoWithComplexNestedPath() {
        // Test MIN score mode
            .setField("user.status")
        );  
        assertEquals("Path should match", "user", queryBuilder.path());
        );
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
    }
    public void testFromProtoWithEmptyPath() {
            .build();  
        TermQuery termQuery = TermQuery.newBuilder()
        // Test SUM score mode (maps to Total in Lucene)
        QueryBuilderProtoConverterRegistryImpl mockRegistry = new QueryBuilderProtoConverterRegistryImpl() {  
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setQuery(innerQueryContainer)
            .setValue(FieldValue.newBuilder().setString("active").build())
        );
            .setField("user.email")  
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Score mode should be Min", ScoreMode.Min, minBuilder.scoreMode());
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);  
            .setPath("user")  
            )  
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)  
        assertNotNull("Inner hits should not be null", queryBuilder.innerHit());
            .build();  
        );
            .setQuery(innerQueryContainer)
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        NestedQuery noneQuery = NestedQuery.newBuilder()
            .build();
            .setPath("user")
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)
            .setValue(FieldValue.newBuilder().setString("electronics").build())
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
    }  
        // Set up the registry with all built-in converters
            IllegalArgumentException.class,  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
    public void testFromProtoWithInvalidInnerQuery() {
        // Don't set score mode - this will test the default behavior
            .setPath("user")
        NestedQuery nestedQuery = NestedQuery.newBuilder()
        );  
        IllegalArgumentException exception = expectThrows(
        org.opensearch.protobufs.InnerHits invalidInnerHits = org.opensearch.protobufs.InnerHits.newBuilder()
        NestedQueryBuilder sumBuilder = NestedQueryBuilderProtoUtils.fromProto(sumQuery, registry);
        // Test MIN score mode
            .setName("valid_name")
 *
        assertEquals("Query name should match", "nested_user_query", queryBuilder.queryName());
            .setQuery(innerQueryContainer)
        super.setUp();
        assertEquals("Score mode should be Max", ScoreMode.Max, queryBuilder.scoreMode());
            .setValue(FieldValue.newBuilder().setString("john").build())
        InnerHits innerHits = InnerHits.newBuilder().setName("product_hits").setSize(5).setFrom(0).build();
        // Test exception handling when inner query conversion fails
            .setInnerHits(innerHits)  
        NestedQuery noneQuery = NestedQuery.newBuilder()
            "Exception message should contain 'Failed to convert inner hits'",  
        NestedQuery nestedQuery = NestedQuery.newBuilder()  
}
            IllegalArgumentException.class,
        assertEquals("Score mode should be Avg", ScoreMode.Avg, avgBuilder.scoreMode());  
        InnerHits invalidInnerHits = InnerHits.newBuilder()
            .setBoost(1.5f)
            .setPath("user")  
            .build();  
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setIgnoreUnmapped(false).build();
            .setName("test_inner_hits")  
        assertEquals("Default score mode should be Avg for unspecified", ScoreMode.Avg, queryBuilder.scoreMode());  
    public void testFromProtoWithDifferentScoreModes() {
            .setQuery(innerQueryContainer)
        assertEquals("Path should match", "user", queryBuilder.path());  
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)
        NestedQueryBuilder noneBuilder = NestedQueryBuilderProtoUtils.fromProto(noneQuery, registry);
            .setPath("user")
            .setPath("user.profile")
            IllegalArgumentException.class,  
    public void testFromProtoWithAllScoreModes() {
        NestedQuery nestedQuery = NestedQuery.newBuilder()  
            .setField("user.name")  
            .setField("user.name")
        // Test with invalid inner hits to trigger exception handling
        assertTrue("Ignore unmapped should be true", queryBuilder.ignoreUnmapped());
            .setQuery(innerQueryContainer)
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
        TermQuery termQuery = TermQuery.newBuilder()
            () -> NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry)  
            .build();
        registry = new QueryBuilderProtoConverterRegistryImpl();  
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);  
import org.opensearch.test.OpenSearchTestCase;
            .build();
        assertTrue(
            .setValue(FieldValue.newBuilder().setString("john").build())  
            IllegalArgumentException.class,
            .build();
    public void testFromProtoWithInvalidInnerHits() {  
    public void testFromProtoWithMissingQuery() {  
            .build();
        assertTrue("Ignore unmapped should be true", queryBuilder.ignoreUnmapped());
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
import org.opensearch.protobufs.ChildScoreMode;
            .setValue(FieldValue.newBuilder().setString("john").build())
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .build();
        IllegalArgumentException exception = expectThrows(
            .setField("user.name")
            .setValue(FieldValue.newBuilder().setString("dark").build())
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();
            .setQuery(innerQueryContainer)  
    }
        NestedQueryBuilder queryBuilder = NestedQueryBuilderProtoUtils.fromProto(nestedQuery, registry);  
        );
            .build();
            .setBoost(2.0f)
import org.opensearch.protobufs.QueryContainer;  
            exception.getMessage().contains("Failed to convert inner query for NestedQuery")
        // Test MAX score mode
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setField("products.category")
            .build();  
        // Test SUM score mode (maps to Total in Lucene)
        assertEquals("Score mode should be None", ScoreMode.None, noneBuilder.scoreMode());
            .build();  
