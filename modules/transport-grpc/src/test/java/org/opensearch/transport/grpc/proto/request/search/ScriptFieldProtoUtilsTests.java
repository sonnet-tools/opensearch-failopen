            "test_script_options",
 * compatible open source license.
    }
        // Verify the result
                ScriptLanguage.newBuilder()
        ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
            .setSource("doc['field'].value")
import org.opensearch.search.builder.SearchSourceBuilder;
    }
        assertEquals("Script type should be STORED", ScriptType.STORED, resultScript.getType());
        Script resultScript = result.script();
        // Call the method under test
        assertEquals("Script params should be empty", Collections.emptyMap(), resultScript.getParams());
/*
        assertEquals("Script options should match", optionsMap, resultScript.getOptions());
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
            scriptField
        // Call the method under test
            .setSource("doc[params.field].value * params.factor")
import org.opensearch.script.ScriptType;
public class ScriptFieldProtoUtilsTests extends OpenSearchTestCase {
import java.util.Collections;
    public void testFromProtoWithCustomLanguage() throws IOException {
        optionsMap.put("content_type", "application/json");
        Map<String, Object> expectedParams = new HashMap<>();
        assertEquals("Field name should match", "test_script_field", result.fieldName());
            "test_stored_script",
        // Verify the result
        Script resultScript = result.script();
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setStored(storedScriptId).build();
            .setLang(ScriptLanguage.newBuilder().setCustom("mylang").build())
            .build();
import org.opensearch.protobufs.StoredScriptId;
        expectedParams.put("factor", "2");
        assertEquals("Field name should match", "test_stored_script", result.fieldName());
            .setSource("doc['field'].value * 2")
    public void testFromProtoWithInvalidScriptOptions() throws IOException {
        // Create a map of script parameters
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
        optionsMap.put("invalid_option", "value");
        );
    public void testFromProtoWithStoredScript() throws IOException {
            .setParams(objectMapBuilder.build())
import org.opensearch.test.OpenSearchTestCase;
            .setSource("custom script code")
        assertEquals("Script type should be INLINE", ScriptType.INLINE, resultScript.getType());
        // Create a protobuf ScriptField with stored script
        Script resultScript = result.script();
        assertEquals("Script source should match", "doc['field'].value * 2", resultScript.getIdOrCode());
            IllegalArgumentException.class,
    public void testFromProtoWithScriptOptions() throws IOException {
            scriptField
        InlineScript inlineScript = InlineScript.newBuilder()
        InlineScript inlineScript = InlineScript.newBuilder()
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
        // Create a protobuf ScriptField with inline script and options
        IllegalArgumentException exception = expectThrows(
            .setLang(
            .setLang(
        // Verify the result
        assertEquals("Script language should be painless", "painless", resultScript.getLang());
import java.util.Map;
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        assertNotNull("ScriptField should not be null", result);
            scriptField
        assertTrue(
        );
            )
        assertEquals("Field name should match", "test_script_with_params", result.fieldName());
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
                    .build()
    public void testFromProtoWithInlineScript() throws IOException {
                    .build()
        // Create a map of script options
            .putAllOptions(optionsMap)
        assertEquals("Script language should match custom language", "mylang", resultScript.getLang());
        assertNotNull("ScriptField should not be null", result);
        optionsMap.put("content_type", "application/json");
 */
    }
        assertEquals("Script id should match", "my_stored_script", resultScript.getIdOrCode());
        assertNotNull("Script should not be null", resultScript);
        assertNotNull("ScriptField should not be null", result);
        assertTrue("IgnoreFailure should be true", result.ignoreFailure());
            )
            .setSource("doc['field'].value")
            exception.getMessage().contains("illegal compiler options")
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        InlineScript inlineScript = InlineScript.newBuilder()
        // Create ObjectMap for script parameters
        assertEquals("Script language should be painless", "painless", resultScript.getLang());
        InlineScript inlineScript = InlineScript.newBuilder()
        // Create a protobuf ScriptField with inline script
        Map<String, String> optionsMap = new HashMap<>();
        );
            "test_script_with_params",
            scriptField
            objectMapBuilder.putFields(entry.getKey(), ObjectMap.Value.newBuilder().setString(entry.getValue()).build());
import org.opensearch.protobufs.ScriptField;
        // Create a protobuf ScriptField with inline script and invalid options
        // Create a protobuf ScriptField with custom language
    }
        assertNotNull("Script should not be null", resultScript);
        assertNotNull("Script should not be null", resultScript);
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        assertEquals("Script params should match", expectedParams, resultScript.getParams());
import org.opensearch.protobufs.ObjectMap;
}
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        );
                ScriptLanguage.newBuilder()
            .build();
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
            "test_script_field",
    public void testFromProtoWithScriptParams() throws IOException {
        // Create a protobuf ScriptField with inline script and parameters
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        // Verify the result
            .build();
        // Call the method under test, should throw IllegalArgumentException
        StoredScriptId storedScriptId = StoredScriptId.newBuilder().setId("my_stored_script").build();
import java.util.HashMap;
 *
                    .build()
        // Call the method under test
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.script.Script;
            .setLang(
            () -> SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto("test_invalid_options", scriptField)
        Map<String, String> paramsMap = new HashMap<>();
        InlineScript inlineScript = InlineScript.newBuilder()
        assertNotNull("Script should not be null", resultScript);
        assertNotNull("ScriptField should not be null", result);
        assertEquals("Script type should be INLINE", ScriptType.INLINE, resultScript.getType());
        Script resultScript = result.script();
        assertNotNull("Script should not be null", resultScript);
            .build();
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        assertNotNull("ScriptField should not be null", result);
        assertEquals("Script params should be empty", Collections.emptyMap(), resultScript.getParams());
 * SPDX-License-Identifier: Apache-2.0
            "test_custom_lang",
            )
            .setLang(ScriptLanguage.newBuilder().setCustom("painless").build())
        Map<String, String> optionsMap = new HashMap<>();
        // Verify the result
package org.opensearch.transport.grpc.proto.request.search;
        );
        paramsMap.put("factor", "2");
            scriptField
            .build();
                ScriptLanguage.newBuilder()
        // Create a map of invalid script options (more than just content_type)
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        Script resultScript = result.script();
        assertFalse("IgnoreFailure should be false by default", result.ignoreFailure());
        );
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
 * The OpenSearch Contributors require contributions made to
        // Call the method under test
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).setIgnoreFailure(true).build();
        expectedParams.put("field", "price");
        paramsMap.put("field", "price");
            "Exception message should mention illegal compiler options",
import org.opensearch.protobufs.ScriptLanguage;
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
import java.io.IOException;
        // Call the method under test
    }
        }
            .putAllOptions(optionsMap)
        assertEquals("Script source should match", "doc[params.field].value * params.factor", resultScript.getIdOrCode());
    }
import org.opensearch.protobufs.InlineScript;
