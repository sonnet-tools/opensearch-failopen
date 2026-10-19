     */
            @Override
     */
    private QueryBuilderProtoConverterSpiRegistry registry;  
        registry.registerConverter(converter1);  
        registry.registerConverter(termConverter);  
    }
        registry.registerConverter(converter2);
    }  
                return QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET;  
    public void testFromProtoWithRegisteredConverter() {
            return new TermQueryBuilder(field, value);
        TestRangeQueryConverter rangeConverter = new TestRangeQueryConverter();
        assertEquals(0, registry.size());  
    }  
import org.opensearch.index.query.QueryBuilder;  
        QueryBuilderProtoConverter converter = new QueryBuilderProtoConverter() {  
        QueryBuilder rangeResult = registry.fromProto(rangeContainer);  
    /**
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
    private QueryContainer createMockTermQueryContainer() {
                    .build()
        // Test range query
        registry.registerConverter(converter);
                throw new IllegalArgumentException("QueryContainer does not contain a Range query");  
        }
                    .setField("test_field")
        public QueryBuilder fromProto(QueryContainer queryContainer) {
        return QueryContainer.newBuilder()
/*  
    }
        TestQueryConverter termConverter = new TestQueryConverter();  
    public void testFromProtoWithNullQueryContainer() {
    public void setUp() throws Exception {  
    }
        assertThat(exception.getMessage(), containsString("Converter cannot be null"));  
        assertThat(termResult, instanceOf(TermQueryBuilder.class));
    }
        @Override
        QueryContainer queryContainer = createMockTermQueryContainer();  
public class QueryBuilderProtoConverterSpiRegistryTests extends OpenSearchTestCase {
 *
            }
        assertThat(result, instanceOf(TermQueryBuilder.class));
    public void testFromProtoWithUnregisteredQueryType() {  
import org.opensearch.index.query.TermQueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
            public QueryBuilder fromProto(QueryContainer queryContainer) {
    /**  
            @Override
    }  
        QueryBuilder termResult = registry.fromProto(termContainer);
                org.opensearch.protobufs.TermQuery.newBuilder()
        // Verify the second converter is used
        QueryBuilder result = registry.fromProto(queryContainer);
            @Override  
            public QueryContainer.QueryContainerCase getHandledQueryCase() {  
            org.opensearch.protobufs.TermQuery termQuery = queryContainer.getTerm();
        return QueryContainer.newBuilder().setRange(org.opensearch.protobufs.RangeQuery.newBuilder().build()).build();
        };
        assertEquals(1, registry.size());
        registry.registerConverter(converter);  
        assertThat(termQuery.value(), equalTo("test_value"));
        TestQueryConverter converter1 = new TestQueryConverter();  
            .build();  
            return new TermQueryBuilder("mock_field", "mock_value");
        assertThat(exception.getMessage(), containsString("Handled query case cannot be null"));
    }  
import static org.hamcrest.Matchers.equalTo;
package org.opensearch.transport.grpc.proto.request.search.query;
    }
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));
    private static class TestRangeQueryConverter implements QueryBuilderProtoConverter {  
            )
            return QueryContainer.QueryContainerCase.RANGE;  
 * The OpenSearch Contributors require contributions made to  
            String field = termQuery.getField();
        @Override
     * Test converter implementation for TERM queries
        QueryBuilderProtoConverter converter = new QueryBuilderProtoConverter() {
        assertThat(exception.getMessage(), containsString("TERM"));
 * compatible open source license.
}
    public void testRegisterNullConverter() {
        }
            String value = termQuery.getValue().getString();  
        QueryContainer rangeContainer = createMockRangeQueryContainer();
    public void testMultipleConvertersForDifferentQueryTypes() {
     */  
        registry.registerConverter(rangeConverter);
import org.opensearch.test.OpenSearchTestCase;  
            .setTerm(  
        TestQueryConverter converter = new TestQueryConverter();
    public void testRegisterConverter() {  
    /**  
                return null;
 */  
        public QueryBuilder fromProto(QueryContainer queryContainer) {
        // Register second converter for same query case - should replace  
    /**
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(queryContainer));  
        super.setUp();
                throw new IllegalArgumentException("QueryContainer does not contain a Term query");
    }  
        assertNotNull(rangeResult); // TestRangeQueryConverter returns a mock QueryBuilder
            @Override
        assertEquals(1, registry.size());
import static org.hamcrest.Matchers.containsString;  
        TestQueryConverter converter = new TestQueryConverter();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));  
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
        TestQueryConverter converter2 = new TestQueryConverter();
                    .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build())  
     */  
     * Test converter implementation for RANGE queries
    private static class TestQueryConverter implements QueryBuilderProtoConverter {
        // Test term query
    }
    public void testRegisterConverterWithNotSetQueryCase() {
    private QueryContainer createMockRangeQueryContainer() {  
                return null;
        assertEquals(1, registry.size());
    public void testReplaceExistingConverter() {
        }
        assertThat(exception.getMessage(), containsString("Unsupported query type in container"));
            }
        // Create a mock query container that the test converter can handle
        public QueryContainer.QueryContainerCase getHandledQueryCase() {
     * Helper method to create a mock term query container
    }
            }  
            }
        }  
            }
    public void testEmptyRegistry() {
        };
import org.opensearch.protobufs.QueryContainer;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null));
        registry = new QueryBuilderProtoConverterSpiRegistry();
    public void testRegisterConverterWithNullQueryCase() {  
            if (!queryContainer.hasRange()) {
        QueryContainer queryContainer = createMockTermQueryContainer();
            }
            if (!queryContainer.hasTerm()) {  
        public QueryContainer.QueryContainerCase getHandledQueryCase() {  
        @Override
        QueryBuilder result = registry.fromProto(queryContainer);
        @Override  
        TermQueryBuilder termQuery = (TermQueryBuilder) result;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        assertEquals(2, registry.size());  
    }
import static org.hamcrest.Matchers.instanceOf;
        QueryContainer termContainer = createMockTermQueryContainer();  
        assertThat(exception.getMessage(), containsString("Cannot register converter for QUERYCONTAINER_NOT_SET case"));
        assertThat(result, instanceOf(TermQueryBuilder.class));  
    }
     * Helper method to create a mock range query container
        QueryContainer queryContainer = createMockTermQueryContainer();
        assertThat(exception.getMessage(), containsString("Query container cannot be null"));  
                return null;  
            // Return a simple mock QueryBuilder for testing  
            return QueryContainer.QueryContainerCase.TERM;
        assertThat(termQuery.fieldName(), equalTo("test_field"));  
