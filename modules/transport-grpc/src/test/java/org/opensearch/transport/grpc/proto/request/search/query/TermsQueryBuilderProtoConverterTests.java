        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNotNull("Query should be set", termsQueryBuilder.termsLookup().query());
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());
        assertEquals("Query field should match", "color", ((TermQueryBuilder) termsQueryBuilder.termsLookup().query()).fieldName());
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("lookup_field", termsQueryField).build();
            .setId2("lookup_id")
        TermsQuery termsQuery = TermsQuery.newBuilder()
        converter.setRegistry(new QueryBuilderProtoConverterRegistryImpl());
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
 */
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
    }
    }
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("v1").build();
        assertEquals("Query name should be set", "lookup_query", termsQueryBuilder.queryName());
    public void testFromProtoWithEmptyTermsMap() {
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
    }
 * The OpenSearch Contributors require contributions made to
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
        assertEquals("Routing should match", "test_routing", termsQueryBuilder.termsLookup().routing());
        TermsQuery termsQuery = TermsQuery.newBuilder()
                                                                                                                             // {1,2}
        assertEquals("Field name should match", "lookup_field", termsQueryBuilder.fieldName());
    public void testGetHandledQueryCase() {
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.transport.grpc.proto.request.search.query;
        TermsQuery termsQuery = TermsQuery.newBuilder().build();
            .build();
        assertEquals("Boost should be set", 2.5f, termsQueryBuilder.boost(), 0.0f);
        assertEquals("ID should come from id_2", "lookup_id", termsQueryBuilder.termsLookup().id());
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            .setBoost(2.5f)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();
            .putTerms("test_field", termsQueryField)
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());
 *
import org.opensearch.protobufs.TermsQuery;
import org.opensearch.index.query.TermsQueryBuilder;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertTrue(
        assertTrue("Query name should be null", termsQueryBuilder.queryName() == null);
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
    }
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());
        assertTrue(
 * compatible open source license.
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, termsQueryBuilder.valueType());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
            .setPath("test_path")
            exception.getMessage().contains("does not contain a Terms query")
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        // The converter delegates to utils, which will handle the validation
            .putTerms("lookup_field", termsQueryField)
        assertTrue("Exception message should mention 'exactly one field'", exception.getMessage().contains("exactly one field"));
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    public void testFromProtoWithTermsLookup() {
        assertEquals("Field name should match", "test_field", termsQueryBuilder.fieldName());
        );
            .build();
    }
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        // The converter delegates to utils, which will handle the validation
        Map<String, TermsQueryField> termsMap = new HashMap<>();
    private TermsQueryBuilderProtoConverter converter;
            .build();
        termsMap.put("field2", field2);
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
    }
            .build();
        // Create a QueryContainer with a different query type
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
import org.opensearch.protobufs.QueryContainer;
            .build();
        assertEquals("Boost should be default", 1.0f, termsQueryBuilder.boost(), 0.0f);
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
import org.opensearch.protobufs.TermsQueryField;
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("lookup_field", termsQueryField).build();
        assertNull("Query name should be null", termsQueryBuilder.queryName());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
            .setQuery(innerQuery)
    }
            "Exception message should mention 'does not contain a Terms query'",
        assertEquals("Boost should be set", 1.5f, termsQueryBuilder.boost(), 0.0f);
        converter = new TermsQueryBuilderProtoConverter();
        assertEquals("Field name should match map key", "test-field", termsQueryBuilder.fieldName());
/*
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
        assertEquals("Value type should be BITMAP", TermsQueryBuilder.ValueType.BITMAP, termsQueryBuilder.valueType());
    }
        assertEquals("Index should match", "test_index", termsQueryBuilder.termsLookup().index());
        TermsQuery termsQuery = TermsQuery.newBuilder()
public class TermsQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());
import org.opensearch.index.query.QueryBuilder;
        assertNotNull("QueryBuilder should not be null", queryBuilder);
import static org.junit.Assert.assertNull;
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());
            .setPath("test_path")
    }
        assertEquals("First value should match", "test_value", termsQueryBuilder.values().get(0));
    public void testFromProtoWithTermsLookupByQuery() {
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
    public void testFromProto() {
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
            .build();
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
            .setXName("lookup_query")
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
            .setPath("test_path")
        assertNull("ID should not be set for a query-based lookup", termsQueryBuilder.termsLookup().id());
}
            .setIndex("test_index")
import org.opensearch.protobufs.FieldValue;
        assertEquals("First value should match", "v1", termsQueryBuilder.values().get(0));
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        assertEquals("First value should match", "default_value", termsQueryBuilder.values().get(0));
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        assertEquals("Boost should be default", 1.0f, termsQueryBuilder.boost(), 0.0f);
        assertEquals("ID should match", "test_id", termsQueryBuilder.termsLookup().id());
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        TermsQueryField field1 = TermsQueryField.newBuilder().build();
    public void testFromProtoWithBoostAndQueryName() {
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("default_field", termsQueryField).build();
            .putTerms("bitmap_field", termsQueryField)
        assertTrue("Query should be a TermQueryBuilder", termsQueryBuilder.termsLookup().query() instanceof TermQueryBuilder);
        assertEquals("Field name should match", "bitmap_field", termsQueryBuilder.fieldName());
        // protobufs 1.7.0: a lookup can identify the document via the id_2 field
    }
        assertEquals("Field name should match", "default_field", termsQueryBuilder.fieldName());
    public void testFromProtoWithInvalidContainer() {
        termsMap.put("test-field", termsQueryField);
            .setId("test_id")
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        // Test that the converter throws an exception for basic validation
    }
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build(); // base64 for
        assertNull("Query should not be set", termsQueryBuilder.termsLookup().query());
    }
import static org.junit.Assert.assertTrue;
        assertEquals("Converter should handle TERMS case", QueryContainer.QueryContainerCase.TERMS, converter.getHandledQueryCase());
            exception.getMessage().contains("does not contain a Terms query")
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
            .setIndex("test_index")
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
            .setXName("test_query_name")
    public void testFromProtoWithValueType() {
        TermsQuery termsQuery = TermsQuery.newBuilder().putAllTerms(termsMap).build();
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertNotNull("QueryBuilder should not be null", queryBuilder);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, termsQueryBuilder.valueType());
import static org.junit.Assert.assertNotNull;
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
    public void testFromProtoWithNullContainer() {
            .setRouting("test_routing")
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("test-field", termsQueryField).build();
        // protobufs 1.7.0: a lookup can identify documents via a nested query instead of an id
    public void testFromProtoWithTermsLookupById2() {
        // Provide a registry so query-based terms lookups can convert their inner query
 * this file be licensed under the Apache-2.0 license or a
        TermsQueryField field2 = TermsQueryField.newBuilder().build();
    public void testFromProtoWithDefaultValues() {
        assertTrue("Exception message should mention 'exactly one field'", exception.getMessage().contains("exactly one field"));
        );
        Map<String, TermsQueryField> termsMap = new HashMap<>();
        termsMap.put("field1", field1);
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        assertEquals("Query name should be set", "test_query_name", termsQueryBuilder.queryName());
        assertNotNull("QueryBuilder should not be null", queryBuilder);
    public void testFromProtoWithMultipleFields() {
        // Test that the converter returns the correct QueryContainerCase
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.protobufs.TermQuery;
            "Exception message should mention 'does not contain a Terms query'",
        assertTrue("Value should be BytesArray", termsQueryBuilder.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("default_value").build();
            .setIndex("test_index")
    @Override
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();
        // Verify the exception message
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
import java.util.Map;
    public void setUp() throws Exception {
        super.setUp();
            .setBoost(1.5f)
