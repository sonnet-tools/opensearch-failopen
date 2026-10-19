    public void testConverterInterface() {
        // Test getHandledQueryCase
            // Handle different field value types
import org.opensearch.index.query.QueryBuilder;  
        QueryBuilder result1 = converter1.fromProto(queryContainer);
        assertThat(result2, instanceOf(TermQueryBuilder.class));
                    .setValue(
            .build();
     * Test implementation of QueryBuilderProtoConverter for TERM queries  
        QueryContainer queryContainer = createMockTermQueryContainer();
                } else if (number.hasInt32Value()) {
                } else if (number.hasInt64Value()) {
        public QueryContainer.QueryContainerCase getHandledQueryCase() {
        }  
    public void testConverterWithInvalidQueryContainer() {  
        TestQueryConverter converter2 = new TestQueryConverter();
        QueryBuilder result2 = converter2.fromProto(queryContainer);
        @Override  
        QueryContainer queryContainer = createMockTermQueryContainer();
                org.opensearch.protobufs.GeneralNumber number = fieldValue.getGeneralNumber();  
        assertThat(result, instanceOf(TermQueryBuilder.class));
     * Helper method to create a mock term query container  
        QueryContainer queryContainer = createMockNumericTermQueryContainer();
            return new TermQueryBuilder(field, value);  
                    .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build())
        assertThat(termQuery.fieldName(), equalTo("numeric_field"));
                throw new IllegalArgumentException("QueryContainer does not contain a Term query");
        public QueryBuilder fromProto(QueryContainer queryContainer) {  
    /**
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));  
    /**
                }
        assertEquals(termQuery1.value(), termQuery2.value());
        // Both should handle the same query case
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.transport.grpc.spi;
        return QueryContainer.newBuilder()  
        // Both should produce equivalent results
    }
                value = fieldValue.getString();
    }
    public void testConverterWithComplexFieldValue() {
        assertThat(termQuery.fieldName(), equalTo("test_field"));
    private QueryContainer createMockTermQueryContainer() {
                org.opensearch.protobufs.TermQuery.newBuilder()
    }  
                    .setField("test_field")  
                            .build()
        TestQueryConverter converter1 = new TestQueryConverter();
                    value = number.getDoubleValue();
                    value = number.getInt64Value();
    }  
import org.opensearch.protobufs.QueryContainer;
                            .setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.5f).build())  
        QueryBuilder result = converter.fromProto(queryContainer);
            )
    public void testMultipleConverterInstances() {  
    }
                if (number.hasFloatValue()) {
 * The OpenSearch Contributors require contributions made to  
    private static class TestQueryConverter implements QueryBuilderProtoConverter {
                    value = number.getFloatValue();
                    .setField("numeric_field")  
        assertEquals(termQuery1.fieldName(), termQuery2.fieldName());
                        org.opensearch.protobufs.FieldValue.newBuilder()
        // Create a query container without a term query  
                    value = number.getInt32Value();  
 *
        TestQueryConverter converter = new TestQueryConverter();
                } else {  
public class QueryBuilderProtoConverterTests extends OpenSearchTestCase {
        @Override
        return QueryContainer.newBuilder().setRange(org.opensearch.protobufs.RangeQuery.newBuilder().build()).build();
            .build();
        TermQueryBuilder termQuery1 = (TermQueryBuilder) result1;
                } else if (number.hasDoubleValue()) {  
import static org.hamcrest.Matchers.equalTo;
    private QueryContainer createMockRangeQueryContainer() {
                    .build()
        assertEquals(converter1.getHandledQueryCase(), converter2.getHandledQueryCase());
        assertThat(result1, instanceOf(TermQueryBuilder.class));
 * compatible open source license.
import org.opensearch.index.query.TermQueryBuilder;
            String field = termQuery.getField();  
    }
        return QueryContainer.newBuilder()  
        TestQueryConverter converter = new TestQueryConverter();
        TermQueryBuilder termQuery = (TermQueryBuilder) result;
 * this file be licensed under the Apache-2.0 license or a
            }  
        TermQueryBuilder termQuery2 = (TermQueryBuilder) result2;
            } else if (fieldValue.hasBool()) {  
    /**
                    throw new IllegalArgumentException("Unsupported number type in TermQuery");
        assertEquals(QueryContainer.QueryContainerCase.TERM, converter.getHandledQueryCase());
        assertTrue(exception.getMessage().contains("QueryContainer does not contain a Term query"));
/*  
            return QueryContainer.QueryContainerCase.TERM;
            .setTerm(
        TestQueryConverter converter = new TestQueryConverter();
import org.opensearch.test.OpenSearchTestCase;  
                    )
            .setTerm(
        TermQueryBuilder termQuery = (TermQueryBuilder) result;
import static org.hamcrest.Matchers.instanceOf;  
    /**
                org.opensearch.protobufs.TermQuery.newBuilder()
     * Helper method to create a mock numeric term query container  
            if (fieldValue.hasString()) {  
            } else {
     * Helper method to create a mock range query container
        // Test fromProto
            org.opensearch.protobufs.FieldValue fieldValue = termQuery.getValue();  
            } else if (fieldValue.hasGeneralNumber()) {
            }
                value = fieldValue.getBool();
            )  
        QueryContainer queryContainer = createMockRangeQueryContainer();
 */  
        assertThat(termQuery.value(), equalTo("test_value"));  
     */
            org.opensearch.protobufs.TermQuery termQuery = queryContainer.getTerm();
            Object value;
     */
        assertThat(result, instanceOf(TermQueryBuilder.class));
}  
    }  
        QueryBuilder result = converter.fromProto(queryContainer);
     */  
        // Test with different field value types
        assertThat(termQuery.value(), equalTo(42.5f));  
     */
            if (!queryContainer.hasTerm()) {
                    .build()  
    }
        }
    private QueryContainer createMockNumericTermQueryContainer() {
                throw new IllegalArgumentException("Unsupported field value type in TermQuery");  
