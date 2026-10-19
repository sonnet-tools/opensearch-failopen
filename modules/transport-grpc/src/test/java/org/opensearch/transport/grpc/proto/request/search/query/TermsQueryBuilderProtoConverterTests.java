        termsMap.put("field2", field2);
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();
        // The converter delegates to utils, which will handle the validation
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .putTerms("test_field", termsQueryField)  
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        // Test that the converter returns the correct QueryContainerCase
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("test-field", termsQueryField).build();
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());  
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
        TermsQuery termsQuery = TermsQuery.newBuilder().putAllTerms(termsMap).build();  
        // Provide a registry so query-based terms lookups can convert their inner query
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        assertEquals("First value should match", "default_value", termsQueryBuilder.values().get(0));
    public void testGetHandledQueryCase() {  
        super.setUp();  
            exception.getMessage().contains("does not contain a Terms query")
import java.util.HashMap;
        assertNull("ID should not be set for a query-based lookup", termsQueryBuilder.termsLookup().id());
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("v1").build();  
                                                                                                                             // {1,2}
 * SPDX-License-Identifier: Apache-2.0
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        // protobufs 1.7.0: a lookup can identify documents via a nested query instead of an id  
        assertEquals("First value should match", "v1", termsQueryBuilder.values().get(0));
            .putTerms("lookup_field", termsQueryField)
import org.opensearch.protobufs.QueryContainer;
        assertTrue("Exception message should mention 'exactly one field'", exception.getMessage().contains("exactly one field"));  
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());
    }  
/*  
            .setBoost(1.5f)  
        assertTrue("Query should be a TermQueryBuilder", termsQueryBuilder.termsLookup().query() instanceof TermQueryBuilder);
            .build();
            .setPath("test_path")  
        // The converter delegates to utils, which will handle the validation
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();  
        assertEquals("Query name should be set", "lookup_query", termsQueryBuilder.queryName());
        assertEquals("ID should match", "test_id", termsQueryBuilder.termsLookup().id());
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, termsQueryBuilder.valueType());
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();  
import org.opensearch.protobufs.FieldValue;  
        assertNotNull("QueryBuilder should not be null", queryBuilder);
            .setIndex("test_index")
        assertEquals("First value should match", "test_value", termsQueryBuilder.values().get(0));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();  
        assertNotNull("Query should be set", termsQueryBuilder.termsLookup().query());  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);  
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;  
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(emptyContainer));  
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("default_value").build();  
        TermsQuery termsQuery = TermsQuery.newBuilder()
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        assertEquals("Boost should be default", 1.0f, termsQueryBuilder.boost(), 0.0f);
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());  
        // Create a QueryContainer with a different query type
        TermsQueryField field2 = TermsQueryField.newBuilder().build();  
        assertNull("Query should not be set", termsQueryBuilder.termsLookup().query());
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
    public void setUp() throws Exception {
            exception.getMessage().contains("does not contain a Terms query")
            .setPath("test_path")
        assertNotNull("QueryBuilder should not be null", queryBuilder);  
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("default_field", termsQueryField).build();
        assertEquals("Routing should match", "test_routing", termsQueryBuilder.termsLookup().routing());
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
        TermsQuery termsQuery = TermsQuery.newBuilder()
package org.opensearch.transport.grpc.proto.request.search.query;
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("lookup_field", termsQueryField).build();
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        assertEquals("Field name should match map key", "test-field", termsQueryBuilder.fieldName());
            .setPath("test_path")  
    public void testFromProtoWithTermsLookupById2() {
        // protobufs 1.7.0: a lookup can identify the document via the id_2 field
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);  
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    public void testFromProtoWithBoostAndQueryName() {  
        Map<String, TermsQueryField> termsMap = new HashMap<>();  
            .setId("test_id")  
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();  
        QueryContainer emptyContainer = QueryContainer.newBuilder().build();  
    }
            "Exception message should mention 'does not contain a Terms query'",  
import static org.junit.Assert.assertNull;  
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();
            .setRouting("test_routing")
        TermsQueryField field1 = TermsQueryField.newBuilder().build();
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
            .setQuery(innerQuery)
import org.opensearch.protobufs.TermsQueryField;
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();  
        );
    }
            "Exception message should mention 'does not contain a Terms query'",
        TermsQuery termsQuery = TermsQuery.newBuilder()
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
        assertEquals("Boost should be set", 2.5f, termsQueryBuilder.boost(), 0.0f);
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertEquals("Field name should match", "lookup_field", termsQueryBuilder.fieldName());  
        assertEquals("Field name should match", "bitmap_field", termsQueryBuilder.fieldName());  
import org.opensearch.protobufs.TermsQuery;  
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());
            .build();
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerms(termsQuery).build();
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();  
        assertEquals("Query field should match", "color", ((TermQueryBuilder) termsQueryBuilder.termsLookup().query()).fieldName());
        converter.setRegistry(new QueryBuilderProtoConverterRegistryImpl());  
 *
    }  
        assertEquals("Value type should be BITMAP", TermsQueryBuilder.ValueType.BITMAP, termsQueryBuilder.valueType());
    }
        assertEquals("Field name should match", "test_field", termsQueryBuilder.fieldName());
        assertTrue(
    public void testFromProtoWithDefaultValues() {
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertNull("Query name should be null", termsQueryBuilder.queryName());
    }
    }  
            .build();
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
    }
 */  
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);  
 * compatible open source license.
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
    }
        Map<String, TermsQueryField> termsMap = new HashMap<>();
        assertEquals("Query name should be set", "test_query_name", termsQueryBuilder.queryName());  
        assertEquals("Converter should handle TERMS case", QueryContainer.QueryContainerCase.TERMS, converter.getHandledQueryCase());
    @Override
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());  
        assertEquals("Path should match", "test_path", termsQueryBuilder.termsLookup().path());  
        assertTrue(  
            .build();  
import org.opensearch.index.query.TermsQueryBuilder;
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
            .build();  
        assertEquals("Field name should match", "default_field", termsQueryBuilder.fieldName());
        assertEquals("Boost should be default", 1.0f, termsQueryBuilder.boost(), 0.0f);  
    }
import static org.junit.Assert.assertEquals;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        termsMap.put("test-field", termsQueryField);
        // Test that the converter throws an exception for basic validation
        termsMap.put("field1", field1);  
        // Verify the exception message
}
            .setXName("test_query_name")
        assertNotNull("QueryBuilder should not be null", queryBuilder);
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, termsQueryBuilder.valueType());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    }
        assertEquals("Boost should be set", 1.5f, termsQueryBuilder.boost(), 0.0f);
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
import static org.junit.Assert.assertTrue;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("ID should come from id_2", "lookup_id", termsQueryBuilder.termsLookup().id());  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
    private TermsQueryBuilderProtoConverter converter;
            .setId2("lookup_id")
        assertTrue("Value should be BytesArray", termsQueryBuilder.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);  
    public void testFromProtoWithEmptyTermsMap() {  
    public void testFromProto() {
    public void testFromProtoWithInvalidContainer() {
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;  
            .putTerms("bitmap_field", termsQueryField)  
        TermsQuery termsQuery = TermsQuery.newBuilder().putTerms("lookup_field", termsQueryField).build();
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build(); // base64 for  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
    public void testFromProtoWithNullContainer() {  
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.protobufs.TermQuery;
        assertTrue("Exception message should mention 'exactly one field'", exception.getMessage().contains("exactly one field"));  
import static org.junit.Assert.assertNotNull;
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);  
        );  
    public void testFromProtoWithMultipleFields() {
        assertEquals("Index should match", "test_index", termsQueryBuilder.termsLookup().index());
    public void testFromProtoWithValueType() {
            .setBoost(2.5f)
            .setIndex("test_index")
import org.opensearch.index.query.QueryBuilder;  
    public void testFromProtoWithTermsLookup() {  
        assertTrue("Query name should be null", termsQueryBuilder.queryName() == null);  
    }  
import java.util.Map;
        TermsQueryBuilder termsQueryBuilder = (TermsQueryBuilder) queryBuilder;
    public void testFromProtoWithTermsLookupByQuery() {
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
        TermsQuery termsQuery = TermsQuery.newBuilder().build();
            .setXName("lookup_query")
        assertEquals("Values should have 1 entry", 1, termsQueryBuilder.values().size());
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()  
            .build();
        assertNotNull("TermsLookup should be set", termsQueryBuilder.termsLookup());  
public class TermsQueryBuilderProtoConverterTests extends OpenSearchTestCase {  
        QueryBuilder queryBuilder = converter.fromProto(queryContainer);
            .setIndex("test_index")
        converter = new TermsQueryBuilderProtoConverter();
        assertTrue("QueryBuilder should be a TermsQueryBuilder", queryBuilder instanceof TermsQueryBuilder);
