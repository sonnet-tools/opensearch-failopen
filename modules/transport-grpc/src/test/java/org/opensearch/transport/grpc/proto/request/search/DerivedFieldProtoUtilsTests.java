        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("rest_parity_field", proto);
    }
        assertEquals("rest_parity_field", derivedField.getName());
            .putFields("field1", ObjectMap.Value.newBuilder().setString("text").build())
                            .build()
/*
            .build();
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['message'])").build()).build())
            .setProperties(properties)
        assertEquals("keyword", derivedField.getType());
        assertEquals("keyword", props.get("field2"));
        // Verify optional fields are set
            .setType("long")
            .setIgnoreMalformed(true)
        assertEquals("object", derivedField.getType());
            .setScript(
        assertEquals("long", derivedField.getProperties().get("nested_field"));
        assertFalse(derivedField.getIgnoreMalformed());
        assertTrue(derivedField.getIgnoreMalformed());
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['count'])").build()).build())
                    .build()
            .setPrefilterField("indexed_field")
        // Verify script with language
    public void testFromProtoWithPropertiesOnly() {
                            .setSource("emit(doc['field'])")
    }
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['test'])").build()).build())
        assertNotNull(derivedField.getProperties());
            .putFields("field3", ObjectMap.Value.newBuilder().setString("long").build())
            .build();
        assertEquals("text", props.get("sub_field1"));
            .setType("keyword")
 * this file be licensed under the Apache-2.0 license or a
    public void testFromProtoWithPrefilterFieldOnly() {
import org.opensearch.protobufs.InlineScript;
 */
        // Verify optional fields are null/default
                            .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS).build())
 * The OpenSearch Contributors require contributions made to
        // Verify optional fields were set via setters
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        ObjectMap properties = ObjectMap.newBuilder().putFields("sub", ObjectMap.Value.newBuilder().setString("text").build()).build();
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("complex_field", proto);
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("complex_object", proto);
        // Verify other optional fields are null/default
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        assertEquals("text", props.get("field1"));
            .build();
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
 *
import org.opensearch.test.OpenSearchTestCase;
        ObjectMap properties = ObjectMap.newBuilder()
    public void testFromProtoWithIgnoreMalformedOnly() {
    public void testFromProtoWithComplexProperties() {
        assertEquals("dd-MM-yyyy", derivedField.getFormat());
import org.opensearch.protobufs.BuiltinScriptLanguage;
import org.opensearch.protobufs.ObjectMap;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("complex_field", derivedField.getName());
        // Verify ignoreMalformed is set
            )
            .build();
            .build();
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['count'])").build()).build())
        assertNull(derivedField.getProperties());
        assertEquals("keyword", props.get("sub_field2"));
            .build();
        assertEquals("indexed_field", derivedField.getPrefilterField());
        // Verify required fields
            .putFields("sub_field2", ObjectMap.Value.newBuilder().setString("keyword").build())
            .setType("object")
    }
        assertEquals("emit(doc['message'])", derivedField.getScript().getIdOrCode());
        assertEquals("prefilter", derivedField.getPrefilterField());
            .setPrefilterField("source_field")
        assertFalse(derivedField.getIgnoreMalformed());
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        assertNull(derivedField.getPrefilterField());
            .setProperties(properties)
        // Create a DerivedField proto with all optional fields
        // Verify other optional fields are null/default
        assertEquals("test_field", derivedField.getName());
        assertNull(derivedField.getFormat());
        assertNotNull(derivedField.getScript());
            .setType("keyword")
            .setType("object")
            .putFields("sub_field1", ObjectMap.Value.newBuilder().setString("text").build())
                        InlineScript.newBuilder()
        // Verify other optional fields are null/default
            .build();
        // This test verifies that the pattern matches DerivedFieldMapper.Builder.build()
            .setFormat("dd-MM-yyyy")
            .setIgnoreMalformed(true)
public class DerivedFieldProtoUtilsTests extends OpenSearchTestCase {
        assertNull(derivedField.getFormat());
        // Verify all properties
            .build();
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("field_with_props", proto);
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['complex'])").build()).build())
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        assertNotNull(derivedField.getProperties());
        assertEquals(3, props.size());
            .setType("date")
    public void testFromProtoWithScriptLanguage() {
            .setProperties(properties)
import org.opensearch.protobufs.ScriptLanguage;
            .setType("keyword")
        assertNull(derivedField.getFormat());
            .putFields("field2", ObjectMap.Value.newBuilder().setString("keyword").build())
        assertNull(derivedField.getPrefilterField());
            .build();
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        // Verify prefilter field is set
                Script.newBuilder()
    }
        ObjectMap properties = ObjectMap.newBuilder()
        // Verify properties are set
        // Create a minimal DerivedField proto with only required fields
            .setType("object")
        assertTrue(derivedField.getIgnoreMalformed());
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("date_field", proto);
        Map<String, Object> props = derivedField.getProperties();
        assertNull(derivedField.getPrefilterField());
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['data'])").build()).build())
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("scripted_field", proto);
            .build();
            .setPrefilterField("prefilter")
            .setIgnoreMalformed(false)
    }
        assertEquals("painless", derivedField.getScript().getLang());
        ObjectMap properties = ObjectMap.newBuilder()
        assertNull(derivedField.getProperties());
        assertEquals("format", derivedField.getFormat());
            .setFormat("format")
        // Verify other optional fields are null/default
        assertFalse(derivedField.getIgnoreMalformed());
        // Convert to OpenSearch DerivedField
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("numeric_field", proto);
            .setType("long")
        assertEquals("object", derivedField.getType());
    }
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("strict_field", proto);
            .setType("object")
import java.util.Map;
        Map<String, Object> props = derivedField.getProperties();
        // Create nested properties
        assertNull(derivedField.getPrefilterField());
                    .setInline(
        assertNull(derivedField.getFormat());
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("test_field", proto);
        // Create properties map
            .build();
            .build();
    public void testFromProtoMatchesRESTSidePattern() {
            .setFormat("yyyy-MM-dd")
        // Verify the object was created with simple constructor pattern
        assertEquals("long", props.get("field3"));
}
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['text'])").build()).build())
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        assertTrue(derivedField.getIgnoreMalformed());
        assertEquals("emit(doc['field'])", derivedField.getScript().getIdOrCode());
        assertEquals("yyyy-MM-dd", derivedField.getFormat());
        assertNull(derivedField.getProperties());
    public void testFromProtoWithFormatOnly() {
            .setProperties(properties)
        // Verify format is set
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['timestamp'])").build()).build())
        assertNotNull(derivedField.getProperties());
    public void testFromProtoWithAllOptionalFields() {
    public void testFromProtoWithRequiredFieldsOnly() {
    }
            .putFields("nested_field", ObjectMap.Value.newBuilder().setString("long").build())
                    )
        // Convert to OpenSearch DerivedField
        // Verify required fields
        assertEquals("emit(doc['test'])", derivedField.getScript().getIdOrCode());
        assertNull(derivedField.getProperties());
package org.opensearch.transport.grpc.proto.request.search;
        // (name, type, script) + conditional setters for optional fields
        // Verify ignoreMalformed is false (explicitly set)
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
    }
        // which uses: simple constructor + conditional setters
    public void testFromProtoWithIgnoreMalformedFalse() {
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['test'])").build()).build())
        assertFalse(derivedField.getIgnoreMalformed());
import org.opensearch.protobufs.Script;
        assertFalse(derivedField.getIgnoreMalformed());
import org.opensearch.index.mapper.DerivedField;
    }
            .setIgnoreMalformed(true)
        DerivedField derivedField = DerivedFieldProtoUtils.fromProto("filtered_field", proto);
        org.opensearch.protobufs.DerivedField proto = org.opensearch.protobufs.DerivedField.newBuilder()
        assertEquals("source_field", derivedField.getPrefilterField());
        // Create properties map
 * compatible open source license.
            .build();
    }
