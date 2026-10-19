        QueryContainer queryContainer = QueryContainer.newBuilder().setFuzzy(fuzzyQuery).build();
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
import org.opensearch.protobufs.QueryContainer;
 * compatible open source license.
        );
        assertEquals("Field name should match", "test-field", fuzzyQueryBuilder.fieldName());
        converter = new FuzzyQueryBuilderProtoConverter();
            .setField("test-field")  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testGetHandledQueryCase() {
import org.opensearch.protobufs.FieldValue;
        assertTrue(
            .setValue(fieldValue)
    }
    }  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
            exception.getMessage().contains("does not contain a Fuzzy query")  
 * The OpenSearch Contributors require contributions made to  
    }
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
    @Override
import org.opensearch.protobufs.FuzzyQuery;  
    public void testFromProto() {  
 * this file be licensed under the Apache-2.0 license or a
    private FuzzyQueryBuilderProtoConverter converter;  
    public void testFromProtoWithInvalidContainer() {
        );
        assertTrue("QueryBuilder should be a FuzzyQueryBuilder", queryBuilder instanceof FuzzyQueryBuilder);  
 * SPDX-License-Identifier: Apache-2.0
    }  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
    public void testFromProtoWithNullContainer() {
/*  
import org.opensearch.index.query.QueryBuilder;
        assertEquals("Boost should match", 2.0f, fuzzyQueryBuilder.boost(), 0.0f);
            .setRewrite("constant_score")
            .setTranspositions(true)
    public void setUp() throws Exception {  
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build())
            "Exception message should mention 'does not contain a Fuzzy query'",
        assertEquals("Value should match", "test-value", fuzzyQueryBuilder.value());  
            .setMaxExpansions(100)  
        FuzzyQueryBuilder fuzzyQueryBuilder = (FuzzyQueryBuilder) queryBuilder;
        assertEquals("Query name should match", "test_query", fuzzyQueryBuilder.queryName());
            .setXName("test_query")  
            "Exception message should mention 'does not contain a Fuzzy query'",
    }
        assertEquals("Converter should handle FUZZY case", QueryContainer.QueryContainerCase.FUZZY, converter.getHandledQueryCase());  
package org.opensearch.transport.grpc.proto.request.search.query;
        FieldValue fieldValue = FieldValue.newBuilder().setString("test-value").build();
            .setBoost(2.0f)
 */  
        FuzzyQuery fuzzyQuery = FuzzyQuery.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
public class FuzzyQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        super.setUp();
            .build();  
 *
            exception.getMessage().contains("does not contain a Fuzzy query")  
            .setPrefixLength(2)
        assertTrue(
import org.opensearch.index.query.FuzzyQueryBuilder;  
}  
