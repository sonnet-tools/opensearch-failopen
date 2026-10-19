                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt32Value(25).build())
        // Test that the converter returns the correct QueryContainerCase
            .setPath("user")  
            .setQuery(innerQueryContainer)
        TermQuery termQuery = TermQuery.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()  
    }  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
    }
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;  
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
            .build();
            .build();
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
        assertNotNull("Result should not be null", result);
    public void testFromProtoWithNullQueryContainer() {
            .setValue(
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();
            .build();
    public void testFromProtoWithUnspecifiedScoreMode() {  
package org.opensearch.transport.grpc.proto.request.search.query;
        assertNotNull("Result should not be null", result);  
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);  
            .setField("user.profile.settings.theme")  
            .setField("user.role")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        assertEquals("Boost should match", 2.5f, nestedQueryBuilder.boost(), 0.001f);
        TermQuery termQuery = TermQuery.newBuilder()
        assertNotNull("Result should not be null", result);  
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());
            .build();
        assertNotNull("Inner hits should not be null", nestedQueryBuilder.innerHit());
        assertFalse("Ignore unmapped should be false by default", nestedQueryBuilder.ignoreUnmapped());
            .build();
            .setPath("user")  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)  
    }  
            .build();
            .setValue(FieldValue.newBuilder().setString("admin").build())  
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
            .setPath("user")
import org.opensearch.protobufs.TermQuery;
        QueryContainer minContainer = QueryContainer.newBuilder().setNested(minQuery).build();
        InnerHits innerHits = InnerHits.newBuilder().setName("user_inner_hits").setSize(10).setFrom(0).build();
    }
            .setBoost(1.5f)
        // Create inner hits  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
        // Test NONE score mode  
            .setBoost(2.5f)
            .build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));  
    private NestedQueryBuilderProtoConverter converter;
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setInnerHits(innerHits).build();
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
        assertNull("Query name should be null by default", nestedQueryBuilder.queryName());
        assertTrue("Ignore unmapped should be true", nestedQueryBuilder.ignoreUnmapped());  
            .setPath("user")
                    .build()
        QueryBuilder result = converter.fromProto(queryContainer);
    }
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
import org.opensearch.test.OpenSearchTestCase;  
            .build();
        // Create a nested query with term query as inner query  
    }
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());  
            .build();
        assertEquals("Path should match", "user", nestedQueryBuilder.path());
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_UNSPECIFIED)
 * compatible open source license.
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
import org.opensearch.protobufs.InnerHits;
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        TermQuery termQuery = TermQuery.newBuilder()
        // Test AVG score mode
    public void testFromProtoWithInnerHits() {
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();  
        NestedQueryBuilder noneResult = (NestedQueryBuilder) converter.fromProto(noneContainer);
            .setField("user.status")
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
        assertEquals("Inner hits size should match", 10, nestedQueryBuilder.innerHit().getSize());  
            .setQuery(innerQueryContainer)  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)
    }
    public void testGetHandledQueryCase() {  
        assertNotNull("Result should not be null", result);
    }  
    }
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        TermQuery termQuery = TermQuery.newBuilder()
        assertEquals("Default boost should be 1.0", 1.0f, nestedQueryBuilder.boost(), 0.001f);  
        converter = new NestedQueryBuilderProtoConverter();  
            .build();  
        assertEquals("Score mode should be Avg", ScoreMode.Avg, avgResult.scoreMode());
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)  
            .setValue(FieldValue.newBuilder().setString("john").build())  
    public void testFromProtoWithEmptyQueryContainer() {
        assertEquals("Score mode should be None", ScoreMode.None, noneResult.scoreMode());  
        TermQuery termQuery = TermQuery.newBuilder()  
        // Test MIN score mode
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
 * The OpenSearch Contributors require contributions made to  
        QueryContainer sumContainer = QueryContainer.newBuilder().setNested(sumQuery).build();  
        assertEquals("Score mode should be Max", ScoreMode.Max, nestedQueryBuilder.scoreMode());
        NestedQuery sumQuery = NestedQuery.newBuilder()  
        assertEquals("Converter should handle NESTED case", QueryContainer.QueryContainerCase.NESTED, converter.getHandledQueryCase());
        TermQuery termQuery = TermQuery.newBuilder()
        QueryBuilder result = converter.fromProto(queryContainer);  
        assertNotNull("Result should not be null", result);
        QueryContainer noneContainer = QueryContainer.newBuilder().setNested(noneQuery).build();
            .setPath("user")
public class NestedQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        // Set up the registry with all built-in converters
            )  
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setQuery(innerQueryContainer)
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
    public void setUp() throws Exception {
    }  
        assertEquals("Inner hits name should match", "user_inner_hits", nestedQueryBuilder.innerHit().getName());
 */  
        NestedQuery avgQuery = NestedQuery.newBuilder()  
            .setValue(FieldValue.newBuilder().setString("test@example.com").build())  
        assertEquals("Path should match", "user.profile.settings", nestedQueryBuilder.path());
            .setQuery(innerQueryContainer)
        NestedQuery nestedQuery = NestedQuery.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        assertEquals("Query name should match", "test_nested_query", nestedQueryBuilder.queryName());
import org.opensearch.protobufs.ChildScoreMode;  
import org.opensearch.index.query.QueryBuilder;
            .setIgnoreUnmapped(true)  
        super.setUp();
        assertEquals("Path should match", "user", nestedQueryBuilder.path());  
        assertEquals("Query name should match", "complex_nested_query", nestedQueryBuilder.queryName());  
        converter.setRegistry(registry);  
            .build();  
        NestedQueryBuilder avgResult = (NestedQueryBuilder) converter.fromProto(avgContainer);
            .setIgnoreUnmapped(false)
        QueryBuilder result = converter.fromProto(queryContainer);
        assertEquals("Boost should match", 1.5f, nestedQueryBuilder.boost(), 0.001f);
 * this file be licensed under the Apache-2.0 license or a
    public void testFromProtoWithWrongQueryType() {
            .setPath("user.profile.settings")
        // Test SUM score mode (maps to Total in Lucene)
    public void testFromProtoWithComplexNestedPath() {
        NestedQuery minQuery = NestedQuery.newBuilder()
        QueryBuilder result = converter.fromProto(queryContainer);  
            .setField("user.name")
            .setField("user.age")
            .setQuery(innerQueryContainer)
        NestedQueryBuilder minResult = (NestedQueryBuilder) converter.fromProto(minContainer);  
            .setValue(FieldValue.newBuilder().setString("john").build())
        assertFalse("Ignore unmapped should be false", nestedQueryBuilder.ignoreUnmapped());
        assertEquals("Score mode should be Min", ScoreMode.Min, minResult.scoreMode());
            .build();  
        assertEquals("Path should match", "user", nestedQueryBuilder.path());  
                FieldValue.newBuilder()  
        NestedQueryBuilder sumResult = (NestedQueryBuilder) converter.fromProto(sumContainer);
        assertEquals("Default score mode should be Avg for unspecified", ScoreMode.Avg, nestedQueryBuilder.scoreMode());
 * SPDX-License-Identifier: Apache-2.0
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
        NestedQuery noneQuery = NestedQuery.newBuilder()
/*  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;  
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
        // Create a term query instead of nested query
    public void testFromProtoWithDifferentScoreModes() {  
            .build();
            .setField("user.name")
            .setValue(FieldValue.newBuilder().setString("dark").build())
            .build();  
            .setPath("user")  
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, nestedQueryBuilder.scoreMode());
            .setField("user.email")
            .setQuery(innerQueryContainer)
import org.opensearch.protobufs.NestedQuery;  
            .setValue(FieldValue.newBuilder().setString("active").build())  
    }
            .setQuery(innerQueryContainer)
        QueryBuilder result = converter.fromProto(queryContainer);
        NestedQuery nestedQuery = NestedQuery.newBuilder()  
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)  
 *
        QueryContainer avgContainer = QueryContainer.newBuilder().setNested(avgQuery).build();  
    @Override  
import org.apache.lucene.search.join.ScoreMode;  
    public void testFromProtoWithMinimalNestedQuery() {  
        assertEquals("Score mode should be Total", ScoreMode.Total, sumResult.scoreMode());
        QueryContainer queryContainer = QueryContainer.newBuilder().build();  
    public void testFromProtoWithValidNestedQuery() {
import org.opensearch.protobufs.FieldValue;
}  
            .setXName("test_nested_query")
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());
import org.opensearch.index.query.NestedQueryBuilder;
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);  
            .setXName("complex_nested_query")  
import org.opensearch.protobufs.QueryContainer;
        assertEquals("Score mode should be Max", ScoreMode.Max, nestedQueryBuilder.scoreMode());  
