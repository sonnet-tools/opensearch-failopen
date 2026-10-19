        assertNull(derivedField.getFormat());
 */  
        // Verify optional fields are null/default
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['count'])").build()).build())
        assertEquals("dd-MM-yyyy", derivedField.getFormat());
            .setType("keyword")
        assertEquals("painless", derivedField.getScript().getLang());
    }
        assertEquals("yyyy-MM-dd", derivedField.getFormat());  
        assertEquals("prefilter", derivedField.getPrefilterField());
        assertEquals("rest_parity_field", derivedField.getName());
            .build();
                    )
            .build();
                    .setInline(
            .putFields("field2", ObjectMap.Value.newBuilder().setString("keyword").build())
        assertNull(derivedField.getProperties());  
        assertNotNull(derivedField.getProperties());
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
 * compatible open source license.
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['test'])").build()).build())
            .build();
        assertNull(derivedField.getFormat());
        assertEquals("long", props.get("field3"));
        assertEquals("format", derivedField.getFormat());  
        // Verify ignoreMalformed is set
            .build();
        assertTrue(derivedField.getIgnoreMalformed());  
        assertEquals("keyword", props.get("sub_field2"));
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
        assertEquals("emit(doc['test'])", derivedField.getScript().getIdOrCode());
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("complex_field", proto);
            .putFields("field3", ObjectMap.Value.newBuilder().setString("long").build())  
    }  
        // Verify optional fields were set via setters  
        assertNull(derivedField.getProperties());  
/*  
            .setFormat("dd-MM-yyyy")  
    public void testFromProtoWithPrefilterFieldOnly() {
        ObjectMap properties = ObjectMap.newBuilder()
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("test_field", proto);  
        // (name, type, script) + conditional setters for optional fields
            .setType("object")
        assertNull(derivedField.getProperties());
        assertEquals("indexed_field", derivedField.getPrefilterField());  
        assertFalse(derivedField.getIgnoreMalformed());
        // Verify script with language
            .setIgnoreMalformed(false)  
            .setType("keyword")
    public void testFromProtoWithIgnoreMalformedFalse() {
        // Verify the object was created with simple constructor pattern  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.ScriptLanguage;  
            .setType("long")
            .setType("object")
        assertNull(derivedField.getFormat());
        assertFalse(derivedField.getIgnoreMalformed());  
        // Verify other optional fields are null/default
        // Verify required fields
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['text'])").build()).build())
    public void testFromProtoWithScriptLanguage() {  
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("date_field", proto);  
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("complex_object", proto);  
        assertNull(derivedField.getPrefilterField());  
            .setPrefilterField("indexed_field")  
        assertEquals(3, props.size());
        assertFalse(derivedField.getIgnoreMalformed());
            .putFields("nested_field", ObjectMap.Value.newBuilder().setString("long").build())
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['count'])").build()).build())
            .setType("object")
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
import java.util.Map;  
        // Verify prefilter field is set
                            .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS).build())
        assertEquals("keyword", derivedField.getType());
        assertEquals("emit(doc['message'])", derivedField.getScript().getIdOrCode());
 * The OpenSearch Contributors require contributions made to  
        // Verify other optional fields are null/default
 * this file be licensed under the Apache-2.0 license or a
            .putFields("field1", ObjectMap.Value.newBuilder().setString("text").build())
        assertTrue(derivedField.getIgnoreMalformed());
            .build();
    }  
            .setFormat("yyyy-MM-dd")  
public class DerivedFieldProtoUtilsTests extends OpenSearchTestCase {
            )  
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("scripted_field", proto);  
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
                Script.newBuilder()
    }  
            .setIgnoreMalformed(true)
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
        assertNull(derivedField.getPrefilterField());
        assertEquals("object", derivedField.getType());  
            .setProperties(properties)
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
 *
import org.opensearch.protobufs.ObjectMap;
        Map<String, Object> props = derivedField.getProperties();  
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['complex'])").build()).build())
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
    }  
            .setType("long")
        // Convert to OpenSearch DerivedField
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("numeric_field", proto);  
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("strict_field", proto);  
            .build();
import org.opensearch.protobufs.BuiltinScriptLanguage;
        ObjectMap properties = ObjectMap.newBuilder()
                        InlineScript.newBuilder()  
        assertNull(derivedField.getPrefilterField());  
    }
    public void testFromProtoWithRequiredFieldsOnly() {
    public void testFromProtoMatchesRESTSidePattern() {
        // Create a minimal DerivedField proto with only required fields
        assertEquals("source_field", derivedField.getPrefilterField());  
    }
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['message'])").build()).build())  
            .build();
            .build();  
        // which uses: simple constructor + conditional setters  
                    .build()
    }  
        assertNull(derivedField.getFormat());
            .setPrefilterField("prefilter")
    public void testFromProtoWithPropertiesOnly() {
        assertNotNull(derivedField.getProperties());
    public void testFromProtoWithFormatOnly() {
            .build();
            .setProperties(properties)
            .build();
        Map<String, Object> props = derivedField.getProperties();
        assertEquals("test_field", derivedField.getName());  
        assertEquals("text", props.get("field1"));
        assertEquals("object", derivedField.getType());  
        // This test verifies that the pattern matches DerivedFieldMapper.Builder.build()
            .setFormat("format")  
        assertEquals("text", props.get("sub_field1"));  
        // Create properties map  
        ObjectMap properties = ObjectMap.newBuilder()  
        // Convert to OpenSearch DerivedField
        // Verify ignoreMalformed is false (explicitly set)
        assertEquals("long", derivedField.getProperties().get("nested_field"));  
            .setType("date")
            .setProperties(properties)
    }  
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['data'])").build()).build())
        assertNotNull(derivedField.getScript());
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("filtered_field", proto);  
    public void testFromProtoWithComplexProperties() {
        // Create a DerivedField proto with all optional fields  
    public void testFromProtoWithAllOptionalFields() {
            .build();  
import org.opensearch.protobufs.InlineScript;  
            .build();  
        // Verify other optional fields are null/default
        // Verify format is set
            .putFields("sub_field1", ObjectMap.Value.newBuilder().setString("text").build())
        assertEquals("keyword", props.get("field2"));  
        ObjectMap properties = ObjectMap.newBuilder().putFields("sub", ObjectMap.Value.newBuilder().setString("text").build()).build();
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("rest_parity_field", proto);
        assertFalse(derivedField.getIgnoreMalformed());
        assertTrue(derivedField.getIgnoreMalformed());
                            .setSource("emit(doc['field'])")
            .setProperties(properties)  
        assertFalse(derivedField.getIgnoreMalformed());
        // Verify all properties
        // Verify properties are set
        // Verify required fields
            .setIgnoreMalformed(true)  
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
        assertNull(derivedField.getProperties());  
            .setType("object")  
import org.opensearch.protobufs.Script;
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()  
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("field_with_props", proto);
        // Verify other optional fields are null/default
        assertNull(derivedField.getPrefilterField());
        // Create nested properties
    }
        assertNotNull(derivedField.getProperties());
            .setScript(  
}  
            .setPrefilterField("source_field")
import org.opensearch.test.OpenSearchTestCase;
                            .build()  
        assertEquals("emit(doc['field'])", derivedField.getScript().getIdOrCode());  
            .setIgnoreMalformed(true)
import org.opensearch.index.mapper.DerivedField;
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['timestamp'])").build()).build())
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['test'])").build()).build())  
        // Verify optional fields are set  
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
package org.opensearch.transport.grpc.proto.request.search;
            .setType("keyword")
        assertEquals("complex_field", derivedField.getName());
            .build();
        // Create properties map  
    public void testFromProtoWithIgnoreMalformedOnly() {
            .putFields("sub_field2", ObjectMap.Value.newBuilder().setString("keyword").build())  
