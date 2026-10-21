        assertThat(result, instanceOf(TermQueryBuilder.class));
        assertEquals(1, registry.size());
        };
        return QueryContainer.newBuilder().setRange(org.opensearch.protobufs.RangeQuery.newBuilder().build()).build();
        assertThat(exception.getMessage(), containsString("Query container cannot be null"));
        QueryContainer rangeContainer = createMockRangeQueryContainer();
 */
 *
        registry = new QueryBuilderProtoConverterSpiRegistry();
        registry.registerConverter(converter);
        registry.registerConverter(converter2);
        // Test term query
        }
    public void testRegisterConverterWithNotSetQueryCase() {
     * Helper method to create a mock term query container
        TestQueryConverter converter = new TestQueryConverter();
    public void testRegisterConverter() {
        registry.registerConverter(rangeConverter);
        public QueryContainer.QueryContainerCase getHandledQueryCase() {
    private QueryContainer createMockRangeQueryContainer() {
import org.opensearch.index.query.TermQueryBuilder;
        }
 * compatible open source license.
                    .build()
        assertThat(exception.getMessage(), containsString("Converter cannot be null"));
    public void setUp() throws Exception {
    @Override
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));
/*
     */
    }
            .build();
    }
        assertThat(termQuery.fieldName(), equalTo("test_field"));
    }
        // Register second converter for same query case - should replace
        QueryContainer queryContainer = createMockTermQueryContainer();
                org.opensearch.protobufs.TermQuery.newBuilder()
        // Verify the second converter is used
}
        assertEquals(2, registry.size());
        QueryBuilder result = registry.fromProto(queryContainer);
            }
        registry.registerConverter(converter1);
    /**
    public void testFromProtoWithNullQueryContainer() {
            return QueryContainer.QueryContainerCase.RANGE;
        TestQueryConverter termConverter = new TestQueryConverter();
    }
                    .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build())
        public QueryBuilder fromProto(QueryContainer queryContainer) {
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
        public QueryContainer.QueryContainerCase getHandledQueryCase() {
    }
        assertThat(termQuery.value(), equalTo("test_value"));
            if (!queryContainer.hasRange()) {
    }
        TestQueryConverter converter = new TestQueryConverter();
                return null;
                throw new IllegalArgumentException("QueryContainer does not contain a Range query");
        TestRangeQueryConverter rangeConverter = new TestRangeQueryConverter();
        QueryContainer termContainer = createMockTermQueryContainer();
import org.opensearch.test.OpenSearchTestCase;
        public QueryBuilder fromProto(QueryContainer queryContainer) {
            return new TermQueryBuilder("mock_field", "mock_value");
            @Override
            // Return a simple mock QueryBuilder for testing
    public void testReplaceExistingConverter() {
        assertEquals(0, registry.size());
        TermQueryBuilder termQuery = (TermQueryBuilder) result;
    }
    private QueryBuilderProtoConverterSpiRegistry registry;
        registry.registerConverter(converter);
        QueryContainer queryContainer = createMockTermQueryContainer();
        TestQueryConverter converter1 = new TestQueryConverter();
 * this file be licensed under the Apache-2.0 license or a
            }
        assertThat(exception.getMessage(), containsString("Cannot register converter for QUERYCONTAINER_NOT_SET case"));
            }
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
        registry.registerConverter(termConverter);
import static org.hamcrest.Matchers.containsString;
        assertNotNull(rangeResult); // TestRangeQueryConverter returns a mock QueryBuilder
    /**
    public void testEmptyRegistry() {
    public void testFromProtoWithUnregisteredQueryType() {
    public void testFromProtoWithRegisteredConverter() {
            String field = termQuery.getField();
import org.opensearch.index.query.QueryBuilder;
    private QueryContainer createMockTermQueryContainer() {
    }
            public QueryBuilder fromProto(QueryContainer queryContainer) {
    /**
        QueryContainer queryContainer = createMockTermQueryContainer();
    /**
 * The OpenSearch Contributors require contributions made to
        QueryBuilder termResult = registry.fromProto(termContainer);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(null));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(queryContainer));
            public QueryContainer.QueryContainerCase getHandledQueryCase() {
    }
            @Override
                return null;
                return QueryContainer.QueryContainerCase.QUERYCONTAINER_NOT_SET;
    public void testRegisterNullConverter() {
package org.opensearch.transport.grpc.proto.request.search.query;
    }
        assertEquals(1, registry.size());
            }
    }
        assertThat(termResult, instanceOf(TermQueryBuilder.class));
        }
            public QueryBuilder fromProto(QueryContainer queryContainer) {
        assertThat(exception.getMessage(), containsString("TERM"));
        @Override
        @Override
            @Override
     * Test converter implementation for TERM queries
    public void testMultipleConvertersForDifferentQueryTypes() {
    private static class TestQueryConverter implements QueryBuilderProtoConverter {
        QueryBuilderProtoConverter converter = new QueryBuilderProtoConverter() {
        };
            )
    }
            if (!queryContainer.hasTerm()) {
    }
        assertThat(exception.getMessage(), containsString("Unsupported query type in container"));
            return new TermQueryBuilder(field, value);
        @Override
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.protobufs.QueryContainer;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.fromProto(null));
        QueryBuilder rangeResult = registry.fromProto(rangeContainer);
        }
    }
     */
            String value = termQuery.getValue().getString();
            org.opensearch.protobufs.TermQuery termQuery = queryContainer.getTerm();
            }
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException("QueryContainer does not contain a Term query");
        assertThat(result, instanceOf(TermQueryBuilder.class));
        // Create a mock query container that the test converter can handle
        QueryBuilderProtoConverter converter = new QueryBuilderProtoConverter() {
        // Test range query
    public void testRegisterConverterWithNullQueryCase() {
            @Override
                    .setField("test_field")
        assertThat(exception.getMessage(), containsString("Handled query case cannot be null"));
        @Override
        QueryBuilder result = registry.fromProto(queryContainer);
            }
            return QueryContainer.QueryContainerCase.TERM;
            .setTerm(
     * Test converter implementation for RANGE queries
        TestQueryConverter converter2 = new TestQueryConverter();
                return null;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> registry.registerConverter(converter));
    }
        assertEquals(1, registry.size());
import static org.hamcrest.Matchers.equalTo;
    private static class TestRangeQueryConverter implements QueryBuilderProtoConverter {
     * Helper method to create a mock range query container
     */
        return QueryContainer.newBuilder()
        super.setUp();
public class QueryBuilderProtoConverterSpiRegistryTests extends OpenSearchTestCase {
     */
