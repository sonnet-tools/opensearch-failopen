            .build();  
            () -> TermsQueryBuilderProtoUtils.fromProto(  
    public void testFromProtoWithDefaultBehavior() {
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, builder.valueType());
        assertEquals("Query name should be set", "lookup_query", result.queryName());  
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();  
            .setValue(fva)  
        assertThrows(
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()  
        assertNotNull("Result should not be null", result);
    public void testFromProtoNewOverloadWithFieldValueArray() {  
    }  
    }
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();  
    public void testFromProtoWithValueTypeField() {
        );
        assertNotNull("TermsLookup should be set", result.termsLookup());
        // base64 for bytes {1,2}
            .build();  
            .putTerms("lookup_field", termsQueryField)
        assertTrue(builder.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);  
            () -> TermsQueryBuilderProtoUtils.fromProto(
        assertEquals("Boost should be set", 1.5f, result.boost(), 0.0f);
        // Test without setting store (should default to false)
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
        assertEquals("Boost should be set", 2.0f, result.boost(), 0.0f);
            .addFieldValueArray(fv2)
 * SPDX-License-Identifier: Apache-2.0
            .build();
        // Test the fromProto(TermsQuery) method with UNSPECIFIED value type (should default to DEFAULT)
        assertThrows(
package org.opensearch.transport.grpc.proto.request.search.query;
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_UNSPECIFIED)
            termsQueryField,
            .setValue(fva)
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()  
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
        assertEquals("Field name should match", "default_field", result.fieldName());
        );  
            .setIndex("idx")  
            .build();
                TermsQueryField.newBuilder().build(),
        assertEquals("Index should match", "test_index", result.termsLookup().index());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();  
        String fieldName = "tags";
            .setValue(fva)
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
            termsQueryField,
    public void testFromProtoWithNullInput() {
            termsQueryField,
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
            .build();  
            fieldName,
        assertEquals("r", builder.termsLookup().routing());  
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
            .addFieldValueArray(fv2)  
        assertNotNull(builder);
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .build();
        assertTrue("Value should be BytesArray", result.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);
            .build();
    }
            .addFieldValueArray(fv1)  
            .setPath("tags")
        assertThrows(IllegalArgumentException.class, () -> TermsQueryBuilderProtoUtils.fromProto(termsQuery));  
        );  
    public void testFromProtoWithTermsQueryNullValueType() {
    }
            TermsQueryBuilder.ValueType.DEFAULT,  
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
                termsQueryField,  
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();  
            .setId("1")
import org.opensearch.index.query.TermsQueryBuilder;
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        assertEquals("1", builder.termsLookup().id());
        assertEquals(true, builder.values().get(1));
            .addFieldValueArray(fv1)
        assertEquals("tags", builder.termsLookup().path());
                                                                                                                             // {1,2}
        assertNotNull(builder);
    }  
        // Test the fromProto(TermsQuery) method with null value type (should default to DEFAULT)
    public void testFromProtoWithTermsQueryNullInput() {
        assertEquals("Routing should match", "test_routing", result.termsLookup().routing());
            .build();
            IllegalArgumentException.class,
            .build();
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()  
        );
        assertNotNull("Result should not be null", result);
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(
import org.opensearch.test.OpenSearchTestCase;  
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
public class TermsQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        );  
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertEquals("Value type should be DEFAULT", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());  
            .putTerms("test_field", termsQueryField)
            "field",  
        assertNotNull("Result should not be null", result);  
        assertEquals(
                fieldName,  
        assertEquals(fieldName, builder.fieldName());
        assertNotNull("Result should not be null", result);  
    public void testFromProtoWithTermsQueryEmptyMap() {  
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertEquals("Field name should match", "test_field", result.fieldName());  
    }  
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT  
        assertEquals(2, builder.values().size());
            .setValue(fva)  
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        assertEquals("Field name should match", "lookup_field", result.fieldName());
    public void testFromProtoWithTermsQueryLookup() {  
        assertEquals("field", result.fieldName());  
        assertThrows(
    }
            .build();
        assertNotNull(builder);  
 */  
import static org.junit.Assert.assertNotNull;  
        );  
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
            termsQueryField,  
        assertEquals(1, builder.values().size());
        assertEquals("Boost should be default", 1.0f, result.boost(), 0.0f);  
    }
            IllegalArgumentException.class,
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(
            .build();  
            .build();  
            IllegalArgumentException.class,
            TermsQueryBuilder.ValueType.DEFAULT,
        );  
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT  
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().build();  
            .build();
            .build();  
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(
            .setStore(true)
        // Test the fromProto(TermsQuery) method with lookup
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
            .addFieldValueArray(fv1)
        assertNotNull("Result should not be null", result);
            .setLookup(lookup)
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(fieldName, termsQueryField, vt);
        );  
            .setRouting("test_routing")  
    public void testFromProtoWithTermsQueryMultipleFields() {  
import static org.junit.Assert.assertTrue;  
            .setXName("test_query")  
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_UNSPECIFIED)
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();  
            .setValue(fva)  
            .build();
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder().build();
            .setXName("lookup_query")
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()  
            .putTerms("default_field", termsQueryField)
    }
        assertNotNull("termsLookup should be set for lookup path", builder.termsLookup());
    public void testFromProtoWithTermsQueryBitmapInvalidMultipleValues() {
        assertEquals("Value type should default to DEFAULT", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
            "field",
        assertEquals("field", termsQueryBuilder.fieldName());  
            () -> TermsQueryBuilderProtoUtils.fromProto(  
        assertNotNull("termsLookup should be set for lookup path", builder.termsLookup());
    public void testParseValueTypeTermsQueryValueTypeMapping() {
            .setPath("p")  
            TermsQueryBuilder.ValueType.BITMAP,
        assertEquals("Field name should match", "bitmap_field", result.fieldName());
            .build();
        assertNull("Query name should be null", result.queryName());
    }  
            .build();  
            .setIndex("idx")  
        org.opensearch.protobufs.FieldValueArray fva2 = org.opensearch.protobufs.FieldValueArray.newBuilder()  
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("value2").build();
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
 * this file be licensed under the Apache-2.0 license or a
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT  
    }  
            .setValue(fva)  
    }
                "field",
            () -> TermsQueryBuilderProtoUtils.fromProto(  
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertThrows(  
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);  
        assertEquals("Value type should default to DEFAULT for UNSPECIFIED", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("a").build();  
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
            .build();
            termsQueryField,
                "",
        assertFalse("store should default to false", builder.termsLookup().store());
            .addFieldValueArray(fv2)
                termsQueryField,
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .build();
        assertThrows(IllegalArgumentException.class, () -> TermsQueryBuilderProtoUtils.fromProto(termsQuery));  
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT)  
        );
            .build();
            )
                fieldName,
                termsQueryField,
        assertNotNull(builder);  
        assertEquals(
        );
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("value1").build();
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
    }  
/*  
    }  
    public void testFromProtoWithLookupStoreDefaultFalse() {
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(
        String fieldName = "bitmap_field";  
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();  
            fieldName,  
    public void testFromProtoWithTermsQueryUnspecifiedValueType() {
        String fieldName = "bitmap_field";  
        TermsQueryBuilder termsQueryBuilder = TermsQueryBuilderProtoUtils.fromProto(  
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("v").build();  
        assertNotNull("Result should not be null", result);
            .putTerms("bitmap_field", termsQueryField)  
import static org.junit.Assert.assertEquals;
            .putTerms("field2", org.opensearch.protobufs.TermsQueryField.newBuilder().setValue(fva2).build())  
    public void testFromProtoNewOverloadMissingValuesAndLookup() {
        assertEquals(TermsQueryBuilder.ValueType.BITMAP, builder.valueType());
        );
        assertNotNull("Result should not be null", result);
        );
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()  
            .putTerms("test_field", termsQueryField)
            .setBoost(2.0f)
        // Test the fromProto(TermsQuery) method with bitmap value type  
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();  
            .build();
 * compatible open source license.
            .setValue(fva)
            .addFieldValueArray(fv2)
            .setRouting("r")  
        org.opensearch.protobufs.FieldValueArray fva1 = org.opensearch.protobufs.FieldValueArray.newBuilder()  
    public void testFromProtoWithTermsQueryBitmapValueType() {
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
        assertEquals(fieldName, builder.fieldName());  
    }
        String fieldName = "test-field";
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder().build();  
            .build();
            IllegalArgumentException.class,  
        assertEquals("ID should match", "test_id", result.termsLookup().id());  
        assertEquals("Values should have 1 entry", 1, result.values().size());
        String fieldName = "tags";  
        assertEquals(  
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setBool(true).build();
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .setId("1")
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build(); // base64 for
            .addFieldValueArray(fv1)
            )
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
    public void testFromProtoNewOverloadBitmapInvalidMultipleValues() {  
        assertEquals("idx", builder.termsLookup().index());  
        assertTrue("store should be true", builder.termsLookup().store());
    }  
            .setValue(fva)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("default_value").build();
        assertThrows(  
    }
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()
        assertEquals("a", builder.values().get(0));  
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(  
    }  
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    public void testFromProtoWithTermsQueryDefaultValues() {
            .build();  
            .build();
import static org.junit.Assert.assertThrows;
            .build();
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()
 * The OpenSearch Contributors require contributions made to  
        assertThrows(
            )  
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
        assertEquals("Values should have 1 entry", 1, result.values().size());  
    public void testFromProtoWithTermsQuery() {
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
    }  
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
        String fieldName = "f";
            .build();
            IllegalArgumentException.class,
            .setId("test_id")
import static org.junit.Assert.assertNull;
            .putTerms("field1", org.opensearch.protobufs.TermsQueryField.newBuilder().setValue(fva1).build())
            .build();  
        assertEquals("Path should match", "test_path", result.termsLookup().path());
        );
        assertEquals(fieldName, builder.fieldName());  
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()  
            .setLookup(lookup)
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("x").build();
        assertNotNull(termsQueryBuilder);
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
            termsQueryField,
import org.opensearch.protobufs.TermsQueryField;
            IllegalArgumentException.class,
        assertEquals("field", result.fieldName());
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
            )
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
            fieldName,  
            .setIndex("test_index")  
            .setLookup(lookup)  
    public void testFromProtoWithTermsLookupField() {
        );
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()  
        assertNotNull("Result should not be null", result);  
            .putTerms("test_field", termsQueryField)
            )
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, builder.valueType());
            .setValue(fva)
            .setPath("test_path")
            .setPath("tags")
        assertEquals("Query name should be set", "test_query", result.queryName());
            .setIndex("i")
            .build();
    }  
            () -> TermsQueryBuilderProtoUtils.fromProto(
            .setBoost(1.5f)  
    public void testFromProtoNewOverloadBitmapDecoding() {
 *
    public void testFromProtoNewOverloadWithLookup() {
        // Test the fromProto(TermsQuery) method with default values  
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT  
        assertEquals("v", termsQueryBuilder.values().get(0));
        String fieldName = "bitmap_field";
        assertEquals("First value should match", "test_value", result.values().get(0));
    }  
                termsQueryField,
                fieldName,
    }
            () -> TermsQueryBuilderProtoUtils.fromProto((org.opensearch.protobufs.TermsQuery) null)
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT  
            .setId("1")
        org.opensearch.protobufs.TermsQueryValueType vt = org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT;
        );
}  
        assertEquals(1, termsQueryBuilder.values().size());
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
    public void testFromProtoWithEmptyTermsQueryField() {
        assertEquals("Value type should be BITMAP", TermsQueryBuilder.ValueType.BITMAP, result.valueType());
            "field",
