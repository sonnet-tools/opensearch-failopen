        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .build();
            .build();
        assertNotNull("Result should not be null", result);
            .build();
            .putTerms("field1", org.opensearch.protobufs.TermsQueryField.newBuilder().setValue(fva1).build())
        String fieldName = "bitmap_field";
    public void testFromProtoNewOverloadWithLookup() {
            .addFieldValueArray(fv2)
    public void testFromProtoWithLookupStoreDefaultFalse() {
        assertEquals(2, builder.values().size());
        assertEquals(fieldName, builder.fieldName());
            .setIndex("idx")
        );
public class TermsQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setPath("test_path")
        );
            .putTerms("field2", org.opensearch.protobufs.TermsQueryField.newBuilder().setValue(fva2).build())
            "field",
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertEquals("Field name should match", "default_field", result.fieldName());
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_UNSPECIFIED)
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
            () -> TermsQueryBuilderProtoUtils.fromProto(
            )
            .addFieldValueArray(fv2)
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder().build();
        assertTrue("Value should be BytesArray", result.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);
            IllegalArgumentException.class,
        assertTrue("store should be true", builder.termsLookup().store());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()
import static org.junit.Assert.assertTrue;
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    public void testFromProtoWithTermsLookupField() {
        );
        );
import static org.junit.Assert.assertEquals;
    }
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
            termsQueryField,
            .putTerms("test_field", termsQueryField)
            .setValue(fva)
    }
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
        assertEquals("Value type should default to DEFAULT for UNSPECIFIED", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
    public void testFromProtoNewOverloadMissingValuesAndLookup() {
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        // Test without setting store (should default to false)
import org.opensearch.protobufs.TermsQueryField;
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("a").build();
    public void testFromProtoNewOverloadBitmapInvalidMultipleValues() {
    }
        assertTrue(builder.values().get(0) instanceof org.opensearch.core.common.bytes.BytesArray);
            .putTerms("bitmap_field", termsQueryField)
            .build();
            .setXName("test_query")
            "field",
            .setValue(fva)
        assertEquals("Value type should be BITMAP", TermsQueryBuilder.ValueType.BITMAP, result.valueType());
            .setBoost(1.5f)
        assertNotNull("termsLookup should be set for lookup path", builder.termsLookup());
        assertNotNull(builder);
 *
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("x").build();
            .build();
 * compatible open source license.
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .setXName("lookup_query")
import org.opensearch.index.query.TermsQueryBuilder;
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        assertThrows(
            IllegalArgumentException.class,
    }
        assertEquals("Query name should be set", "test_query", result.queryName());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
            .build();
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        String fieldName = "tags";
        assertEquals("1", builder.termsLookup().id());
        );
            termsQueryField,
            .putTerms("test_field", termsQueryField)
                fieldName,
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
    public void testFromProtoWithTermsQueryLookup() {
            TermsQueryBuilder.ValueType.DEFAULT,
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, builder.valueType());
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        assertEquals("r", builder.termsLookup().routing());
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
                TermsQueryField.newBuilder().build(),
    }
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder()
        org.opensearch.protobufs.FieldValueArray fva2 = org.opensearch.protobufs.FieldValueArray.newBuilder()
        String fieldName = "bitmap_field";
        assertEquals(
        assertNotNull("TermsLookup should be set", result.termsLookup());
            IllegalArgumentException.class,
    public void testFromProtoWithEmptyTermsQueryField() {
        assertNotNull("Result should not be null", result);
            termsQueryField,
        assertEquals(fieldName, builder.fieldName());
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, builder.valueType());
        assertEquals("Value type should be default", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
            .build();
            .setValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull("Result should not be null", result);
            .build();
            .setPath("tags")
            .setLookup(lookup)
            .build();
                termsQueryField,
            .build();
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
            .addFieldValueArray(fv1)
        assertFalse("store should default to false", builder.termsLookup().store());
            .putTerms("lookup_field", termsQueryField)
        assertNotNull("Result should not be null", result);
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder().build();
            .setIndex("test_index")
            () -> TermsQueryBuilderProtoUtils.fromProto(
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_UNSPECIFIED)
        assertNull("Query name should be null", result.queryName());
            .setValue(fva)
    public void testFromProtoNewOverloadBitmapDecoding() {
            .addFieldValueArray(fv2)
        // Test the fromProto(TermsQuery) method with UNSPECIFIED value type (should default to DEFAULT)
    public void testFromProtoWithDefaultBehavior() {
    }
        assertEquals("field", result.fieldName());
        assertEquals(true, builder.values().get(1));
    }
        assertNotNull("Result should not be null", result);
        assertEquals("Routing should match", "test_routing", result.termsLookup().routing());
    public void testFromProtoWithValueTypeField() {
        assertEquals("field", termsQueryBuilder.fieldName());
        assertEquals(fieldName, builder.fieldName());
    }
        assertNotNull(builder);
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        String fieldName = "test-field";
        assertEquals("Index should match", "test_index", result.termsLookup().index());
        assertEquals("Boost should be set", 2.0f, result.boost(), 0.0f);
            .build();
            .build();
        String fieldName = "tags";
    }
        assertEquals("Values should have 1 entry", 1, result.values().size());
 * The OpenSearch Contributors require contributions made to
/*
            .setPath("p")
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build(); // base64 for
        assertEquals("Query name should be set", "lookup_query", result.queryName());
    }
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP)
    public void testFromProtoWithTermsQueryBitmapValueType() {
        assertThrows(
    }
        );
        );
        assertEquals("Field name should match", "bitmap_field", result.fieldName());
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(
        assertNotNull(termsQueryBuilder);
    }
                "field",
    }
            .build();
            termsQueryField,
        assertEquals("First value should match", "test_value", result.values().get(0));
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
            () -> TermsQueryBuilderProtoUtils.fromProto((org.opensearch.protobufs.TermsQuery) null)
        // Test the fromProto(TermsQuery) method with bitmap value type
                fieldName,
        assertEquals("Boost should be set", 1.5f, result.boost(), 0.0f);
        assertNotNull(builder);
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
            .setIndex("i")
        assertEquals(
            fieldName,
            .setValue(fva)
                fieldName,
            .build();
            .setRouting("r")
            TermsQueryBuilderProtoUtils.parseValueType(org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT)
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
            )
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().build();
                "",
            .build();
        assertNotNull(builder);
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
            .addFieldValueArray(fv1)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();
        assertEquals("Path should match", "test_path", result.termsLookup().path());
            .setValue(fva)
        );
            termsQueryField,
            .setIndex("idx")
        assertEquals("v", termsQueryBuilder.values().get(0));
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(
        assertEquals(1, termsQueryBuilder.values().size());
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setBool(true).build();
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setLookup(lookup).build();
            .addFieldValueArray(fv1)
        );
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .setId("test_id")
            .build();
            .putTerms("test_field", termsQueryField)
            TermsQueryBuilder.ValueType.DEFAULT,
            .build();
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
        // Test the fromProto(TermsQuery) method with lookup
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .build();
    public void testFromProtoWithTermsQueryEmptyMap() {
    public void testFromProtoWithTermsQueryDefaultValues() {
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();
        assertEquals("Field name should match", "test_field", result.fieldName());
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
package org.opensearch.transport.grpc.proto.request.search.query;
            .setValue(fva)
        assertEquals(
            TermsQueryBuilder.ValueType.BITMAP,
import static org.junit.Assert.assertThrows;
            .build();
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            )
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(termsQuery);
        );
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
        );
            .build();
                termsQueryField,
        assertEquals("Values should have 1 entry", 1, result.values().size());
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
    }
            .setId("1")
        assertThrows(
            )
            IllegalArgumentException.class,
        org.opensearch.protobufs.FieldValueArray fva1 = org.opensearch.protobufs.FieldValueArray.newBuilder()
            fieldName,
        assertNotNull("Result should not be null", result);
        TermsQueryBuilder termsQueryBuilder = TermsQueryBuilderProtoUtils.fromProto(
    }
            .build();
            .setId("1")
            .build();
    public void testFromProtoNewOverloadWithFieldValueArray() {
        assertEquals("Field name should match", "lookup_field", result.fieldName());
            .setValue(fva)
        assertNotNull("termsLookup should be set for lookup path", builder.termsLookup());
}
    public void testFromProtoWithTermsQueryBitmapInvalidMultipleValues() {
        assertEquals("Value type should default to DEFAULT", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
        assertThrows(
import static org.junit.Assert.assertNull;
        );
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("value2").build();
    }
            .build();
            .setId("1")
        org.opensearch.protobufs.FieldValueArray fva = org.opensearch.protobufs.FieldValueArray.newBuilder().addFieldValueArray(fv).build();
        assertEquals("tags", builder.termsLookup().path());
            .build();
            )
        assertEquals(TermsQueryBuilder.ValueType.BITMAP, builder.valueType());
        TermsQueryBuilder result = TermsQueryBuilderProtoUtils.fromProto(
        assertEquals("Boost should be default", 1.0f, result.boost(), 0.0f);
    public void testFromProtoWithTermsQueryNullValueType() {
        );
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
 */
        assertNotNull("Result should not be null", result);
            () -> TermsQueryBuilderProtoUtils.fromProto(
            .setLookup(lookup)
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(
        assertEquals("Value type should be DEFAULT", TermsQueryBuilder.ValueType.DEFAULT, result.valueType());
        org.opensearch.protobufs.TermsQueryValueType vt = org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT;
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("default_value").build();
        String fieldName = "f";
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
        TermsQueryBuilder builder = TermsQueryBuilderProtoUtils.fromProto(fieldName, termsQueryField, vt);
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("value1").build();
            .setLookup(lookup)
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
        // base64 for bytes {1,2}
            .addFieldValueArray(fv2)
        String fieldName = "bitmap_field";
        TermsQueryField termsQueryField = TermsQueryField.newBuilder().setValue(fva).build();
        assertNotNull("Result should not be null", result);
    }
            org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
        assertThrows(
    public void testFromProtoWithTermsQueryMultipleFields() {
            .build();
    }
    public void testFromProtoWithTermsQueryNullInput() {
        assertThrows(IllegalArgumentException.class, () -> TermsQueryBuilderProtoUtils.fromProto(termsQuery));
        assertThrows(IllegalArgumentException.class, () -> TermsQueryBuilderProtoUtils.fromProto(termsQuery));
    public void testFromProtoWithTermsQueryUnspecifiedValueType() {
        assertEquals(1, builder.values().size());
            "field",
                org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_BITMAP
            .setRouting("test_routing")
                termsQueryField,
        );
            IllegalArgumentException.class,
        assertEquals("a", builder.values().get(0));
        assertEquals("ID should match", "test_id", result.termsLookup().id());
            termsQueryField,
    }
        org.opensearch.protobufs.TermsLookup lookup = org.opensearch.protobufs.TermsLookup.newBuilder()
    }
import static org.junit.Assert.assertNotNull;
    public void testFromProtoWithTermsQuery() {
            fieldName,
            .setValue(fva)
            .setValue(fva)
        assertThrows(
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build();
            .setPath("tags")
 * this file be licensed under the Apache-2.0 license or a
                termsQueryField,
            .addFieldValueArray(fv1)
        org.opensearch.protobufs.FieldValue fv2 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
        org.opensearch.protobufs.FieldValue fv1 = org.opensearch.protobufs.FieldValue.newBuilder().setString("AQI=").build();
        // Test the fromProto(TermsQuery) method with default values
            () -> TermsQueryBuilderProtoUtils.fromProto(
            () -> TermsQueryBuilderProtoUtils.fromProto(
        // Test the fromProto(TermsQuery) method with null value type (should default to DEFAULT)
        assertEquals("idx", builder.termsLookup().index());
            IllegalArgumentException.class,
            .setBoost(2.0f)
        assertEquals("field", result.fieldName());
            .build();
            .setStore(true)
        org.opensearch.protobufs.TermsQueryField termsQueryField = org.opensearch.protobufs.TermsQueryField.newBuilder()
            .build();
    }
    public void testFromProtoWithNullInput() {
    }
    public void testParseValueTypeTermsQueryValueTypeMapping() {
            .build();
            .putTerms("default_field", termsQueryField)
        org.opensearch.protobufs.FieldValue fv = org.opensearch.protobufs.FieldValue.newBuilder().setString("v").build();
 * SPDX-License-Identifier: Apache-2.0
        );
        org.opensearch.protobufs.TermsQuery termsQuery = org.opensearch.protobufs.TermsQuery.newBuilder()
                                                                                                                             // {1,2}
