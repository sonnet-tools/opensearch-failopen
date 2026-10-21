        // Test NONE score mode
public class NestedQueryBuilderProtoConverterTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to
            .setQuery(innerQueryContainer)
            .build();
        NestedQuery sumQuery = NestedQuery.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        converter.setRegistry(registry);
        NestedQuery avgQuery = NestedQuery.newBuilder()
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
            .setValue(FieldValue.newBuilder().setString("john").build())
    public void setUp() throws Exception {
    private NestedQueryBuilderProtoConverter converter;
 *
        NestedQueryBuilder sumResult = (NestedQueryBuilder) converter.fromProto(sumContainer);
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        QueryBuilder result = converter.fromProto(queryContainer);
        QueryBuilder result = converter.fromProto(queryContainer);
            .setPath("user")
            .build();
        QueryContainer avgContainer = QueryContainer.newBuilder().setNested(avgQuery).build();
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
    @Override
            .build();
import org.opensearch.protobufs.QueryContainer;
        assertEquals("Query name should match", "test_nested_query", nestedQueryBuilder.queryName());
        assertNotNull("Result should not be null", result);
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_SUM)
        TermQuery termQuery = TermQuery.newBuilder()
            .setQuery(innerQueryContainer)
    }
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
            .setValue(FieldValue.newBuilder().setString("active").build())
                FieldValue.newBuilder()
        NestedQueryBuilder minResult = (NestedQueryBuilder) converter.fromProto(minContainer);
        // Set up the registry with all built-in converters
            .setIgnoreUnmapped(false)
        // Create a nested query with term query as inner query
        assertNotNull("Result should not be null", result);
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
        converter = new NestedQueryBuilderProtoConverter();
    public void testFromProtoWithWrongQueryType() {
        NestedQuery noneQuery = NestedQuery.newBuilder()
            .setField("user.email")
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).build();
            .build();
package org.opensearch.transport.grpc.proto.request.search.query;
    }
            .setQuery(innerQueryContainer)
}
        assertEquals("Boost should match", 1.5f, nestedQueryBuilder.boost(), 0.001f);
        assertEquals("Inner hits size should match", 10, nestedQueryBuilder.innerHit().getSize());
            .setValue(
 */
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
    public void testFromProtoWithMinimalNestedQuery() {
        super.setUp();
        assertEquals("Path should match", "user", nestedQueryBuilder.path());
            .setQuery(innerQueryContainer)
                    .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt32Value(25).build())
        NestedQuery nestedQuery = NestedQuery.newBuilder()
    public void testFromProtoWithInnerHits() {
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
        // Test MIN score mode
            .setPath("user.profile.settings")
        QueryContainer noneContainer = QueryContainer.newBuilder().setNested(noneQuery).build();
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());
            .setPath("user")
            .build();
            .setField("user.name")
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_UNSPECIFIED)
        InnerHits innerHits = InnerHits.newBuilder().setName("user_inner_hits").setSize(10).setFrom(0).build();
import org.opensearch.protobufs.ChildScoreMode;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        QueryBuilder result = converter.fromProto(queryContainer);
        NestedQuery nestedQuery = NestedQuery.newBuilder().setPath("user").setQuery(innerQueryContainer).setInnerHits(innerHits).build();
        assertTrue("Ignore unmapped should be true", nestedQueryBuilder.ignoreUnmapped());
    }
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        // Test SUM score mode (maps to Total in Lucene)
            .setXName("complex_nested_query")
    public void testFromProtoWithValidNestedQuery() {
        // Create a term query instead of nested query
        QueryBuilder result = converter.fromProto(queryContainer);
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
        // Test AVG score mode
    public void testFromProtoWithNullQueryContainer() {
            .setBoost(2.5f)
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
        assertEquals("Query name should match", "complex_nested_query", nestedQueryBuilder.queryName());
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
        TermQuery termQuery = TermQuery.newBuilder()
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
            .setQuery(innerQueryContainer)
            .setPath("user")
 * compatible open source license.
            .build();
            .setPath("user")
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
        assertEquals("Score mode should be Avg", ScoreMode.Avg, avgResult.scoreMode());
        assertEquals("Path should match", "user", nestedQueryBuilder.path());
/*
            .setField("user.name")
        assertEquals("Converter should handle NESTED case", QueryContainer.QueryContainerCase.NESTED, converter.getHandledQueryCase());
        NestedQueryBuilder noneResult = (NestedQueryBuilder) converter.fromProto(noneContainer);
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_NONE)
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());
    }
        assertNotNull("Result should not be null", result);
    }
        assertEquals("Score mode should be Max", ScoreMode.Max, nestedQueryBuilder.scoreMode());
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
            .setValue(FieldValue.newBuilder().setString("john").build())
import org.apache.lucene.search.join.ScoreMode;
    public void testFromProtoWithUnspecifiedScoreMode() {
import org.opensearch.protobufs.TermQuery;
        QueryContainer queryContainer = QueryContainer.newBuilder().setNested(nestedQuery).build();
 * SPDX-License-Identifier: Apache-2.0
            .build();
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_AVG)
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MAX)
            .setValue(FieldValue.newBuilder().setString("test@example.com").build())
        NestedQuery nestedQuery = NestedQuery.newBuilder()
            .setScoreMode(ChildScoreMode.CHILD_SCORE_MODE_MIN)
        assertEquals("Boost should match", 2.5f, nestedQueryBuilder.boost(), 0.001f);
        // Test that the converter returns the correct QueryContainerCase
        assertEquals("Default boost should be 1.0", 1.0f, nestedQueryBuilder.boost(), 0.001f);
        assertEquals("Path should match", "user.profile.settings", nestedQueryBuilder.path());
            .setXName("test_nested_query")
        assertEquals("Path should match", "user", nestedQueryBuilder.path());
        TermQuery termQuery = TermQuery.newBuilder()
        TermQuery termQuery = TermQuery.newBuilder()
            .setField("user.profile.settings.theme")
            .setIgnoreUnmapped(true)
        QueryContainer sumContainer = QueryContainer.newBuilder().setNested(sumQuery).build();
            .build();
        assertEquals("Score mode should be None", ScoreMode.None, noneResult.scoreMode());
    }
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
            .setField("user.age")
        assertNull("Query name should be null by default", nestedQueryBuilder.queryName());
        assertNotNull("Result should not be null", result);
        assertFalse("Ignore unmapped should be false", nestedQueryBuilder.ignoreUnmapped());
        TermQuery termQuery = TermQuery.newBuilder()
            .setValue(FieldValue.newBuilder().setString("admin").build())
            .setBoost(1.5f)
        assertEquals("Inner hits name should match", "user_inner_hits", nestedQueryBuilder.innerHit().getName());
        assertEquals("Exception message should match", "QueryContainer must contain a NestedQuery", exception.getMessage());
        assertEquals("Score mode should be Min", ScoreMode.Min, minResult.scoreMode());
            .setField("user.status")
        assertEquals("Default score mode should be Avg for unspecified", ScoreMode.Avg, nestedQueryBuilder.scoreMode());
    public void testFromProtoWithComplexNestedPath() {
        NestedQuery minQuery = NestedQuery.newBuilder()
        NestedQueryBuilder avgResult = (NestedQueryBuilder) converter.fromProto(avgContainer);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        QueryContainer minContainer = QueryContainer.newBuilder().setNested(minQuery).build();
    }
                    .build()
        assertEquals("Score mode should be Total", ScoreMode.Total, sumResult.scoreMode());
        TermQuery termQuery = TermQuery.newBuilder()
            .setValue(FieldValue.newBuilder().setString("dark").build())
        // Create inner hits
            .build();
        assertEquals("Score mode should be Max", ScoreMode.Max, nestedQueryBuilder.scoreMode());
        assertFalse("Ignore unmapped should be false by default", nestedQueryBuilder.ignoreUnmapped());
            .build();
import org.opensearch.protobufs.FieldValue;
        assertEquals("Default score mode should be Avg", ScoreMode.Avg, nestedQueryBuilder.scoreMode());
        NestedQuery nestedQuery = NestedQuery.newBuilder()
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.protobufs.NestedQuery;
        NestedQueryBuilder nestedQueryBuilder = (NestedQueryBuilder) result;
        assertNotNull("Inner hits should not be null", nestedQueryBuilder.innerHit());
        assertTrue("Result should be NestedQueryBuilder", result instanceof NestedQueryBuilder);
            .build();
    public void testFromProtoWithDifferentScoreModes() {
    }
            .build();
        QueryBuilder result = converter.fromProto(queryContainer);
            )
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
 * this file be licensed under the Apache-2.0 license or a
    }
        assertNotNull("Result should not be null", result);
    public void testFromProtoWithEmptyQueryContainer() {
    public void testGetHandledQueryCase() {
import org.opensearch.index.query.NestedQueryBuilder;
            .build();
            .setQuery(innerQueryContainer)
    }
            .setQuery(innerQueryContainer)
            .setPath("user")
        QueryContainer innerQueryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setField("user.role")
    }
            .setPath("user")
import org.opensearch.protobufs.InnerHits;
