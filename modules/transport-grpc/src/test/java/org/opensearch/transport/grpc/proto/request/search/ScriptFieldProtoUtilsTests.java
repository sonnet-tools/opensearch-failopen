        assertEquals("Field name should match", "test_script_with_params", result.fieldName());
    }
        // Call the method under test  
        Map<String, Object> expectedParams = new HashMap<>();  
import org.opensearch.protobufs.ScriptLanguage;
import org.opensearch.protobufs.StoredScriptId;
        assertNotNull("ScriptField should not be null", result);
        InlineScript inlineScript = InlineScript.newBuilder()
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(  
        // Verify the result
        assertNotNull("Script should not be null", resultScript);  
            .setSource("doc['field'].value * 2")  
            .build();  
            "test_custom_lang",
            "test_script_with_params",
            )  
            IllegalArgumentException.class,
        assertEquals("Script id should match", "my_stored_script", resultScript.getIdOrCode());
            scriptField
        assertFalse("IgnoreFailure should be false by default", result.ignoreFailure());  
                    .build()
            "Exception message should mention illegal compiler options",  
    public void testFromProtoWithInlineScript() throws IOException {  
                ScriptLanguage.newBuilder()
        // Create a map of script parameters
            scriptField  
        }
        expectedParams.put("factor", "2");
        // Create a protobuf ScriptField with inline script
 * The OpenSearch Contributors require contributions made to  
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        // Create a protobuf ScriptField with stored script
            scriptField  
        assertEquals("Script params should match", expectedParams, resultScript.getParams());  
            .build();
        // Call the method under test, should throw IllegalArgumentException
        Script resultScript = result.script();
                ScriptLanguage.newBuilder()
            () -> SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto("test_invalid_options", scriptField)
public class ScriptFieldProtoUtilsTests extends OpenSearchTestCase {
            .build();
package org.opensearch.transport.grpc.proto.request.search;
                    .build()  
        );
        assertEquals("Field name should match", "test_script_field", result.fieldName());
        StoredScriptId storedScriptId = StoredScriptId.newBuilder().setId("my_stored_script").build();  
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
            scriptField  
    }  
        // Verify the result  
        Script resultScript = result.script();
        // Call the method under test
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        optionsMap.put("content_type", "application/json");
        assertEquals("Script type should be INLINE", ScriptType.INLINE, resultScript.getType());
    }
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();  
        InlineScript inlineScript = InlineScript.newBuilder()
        );  
import org.opensearch.test.OpenSearchTestCase;  
            .setLang(  
        IllegalArgumentException exception = expectThrows(  
        assertEquals("Script source should match", "doc[params.field].value * params.factor", resultScript.getIdOrCode());
        paramsMap.put("field", "price");
/*  
            )
        );
        );
        // Create a protobuf ScriptField with inline script and options  
        assertTrue(
        assertNotNull("Script should not be null", resultScript);  
        // Create a protobuf ScriptField with custom language
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).setIgnoreFailure(true).build();
        // Verify the result  
        assertTrue("IgnoreFailure should be true", result.ignoreFailure());  
    public void testFromProtoWithScriptOptions() throws IOException {
            .setSource("custom script code")  
}
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(  
        optionsMap.put("invalid_option", "value");  
import org.opensearch.script.ScriptType;
            .setLang(ScriptLanguage.newBuilder().setCustom("mylang").build())
import org.opensearch.protobufs.ObjectMap;
        // Verify the result  
import java.util.Map;
import org.opensearch.script.Script;  
        InlineScript inlineScript = InlineScript.newBuilder()
import org.opensearch.protobufs.ScriptField;  
            .setSource("doc['field'].value")
    public void testFromProtoWithInvalidScriptOptions() throws IOException {
import org.opensearch.protobufs.InlineScript;
        );  
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
        InlineScript inlineScript = InlineScript.newBuilder()
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.search.builder.SearchSourceBuilder;
        // Create a map of invalid script options (more than just content_type)  
        // Call the method under test
        Script resultScript = result.script();
            .setSource("doc['field'].value")
    }
            "test_stored_script",
            .putAllOptions(optionsMap)
        // Create ObjectMap for script parameters  
        assertNotNull("Script should not be null", resultScript);  
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        Map<String, String> paramsMap = new HashMap<>();
            "test_script_field",
        // Create a map of script options
            .setLang(ScriptLanguage.newBuilder().setCustom("painless").build())  
                ScriptLanguage.newBuilder()  
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            exception.getMessage().contains("illegal compiler options")
        Script resultScript = result.script();  
        assertEquals("Script type should be STORED", ScriptType.STORED, resultScript.getType());
        // Verify the result
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
        assertEquals("Script options should match", optionsMap, resultScript.getOptions());
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();  
            .setParams(objectMapBuilder.build())
            )
            .setLang(
    public void testFromProtoWithCustomLanguage() throws IOException {  
        // Call the method under test  
        assertEquals("Script language should be painless", "painless", resultScript.getLang());  
    public void testFromProtoWithStoredScript() throws IOException {
            .build();
                    .build()
    }  
        // Create a protobuf ScriptField with inline script and invalid options
        assertEquals("Script params should be empty", Collections.emptyMap(), resultScript.getParams());  
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
        Map<String, String> optionsMap = new HashMap<>();
        Script resultScript = result.script();  
        assertEquals("Field name should match", "test_stored_script", result.fieldName());
            .setLang(
        assertNotNull("ScriptField should not be null", result);  
            scriptField
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
            .putAllOptions(optionsMap)
        // Call the method under test  
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript).build();
 *
import java.io.IOException;
        // Create a protobuf ScriptField with inline script and parameters  
        assertNotNull("ScriptField should not be null", result);
        assertEquals("Script language should match custom language", "mylang", resultScript.getLang());
        assertEquals("Script language should be painless", "painless", resultScript.getLang());
 */  
            "test_script_options",
        assertNotNull("ScriptField should not be null", result);
        assertNotNull("ScriptField should not be null", result);  
        assertEquals("Script source should match", "doc['field'].value * 2", resultScript.getIdOrCode());  
        paramsMap.put("factor", "2");  
        SearchSourceBuilder.ScriptField result = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
        Map<String, String> optionsMap = new HashMap<>();  
import java.util.Collections;  
        assertNotNull("Script should not be null", resultScript);
        org.opensearch.protobufs.Script script = org.opensearch.protobufs.Script.newBuilder().setStored(storedScriptId).build();
    public void testFromProtoWithScriptParams() throws IOException {  
        assertEquals("Script params should be empty", Collections.emptyMap(), resultScript.getParams());
    }
        ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
import java.util.HashMap;
        optionsMap.put("content_type", "application/json");
        );
            .setSource("doc[params.field].value * params.factor")
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();  
        ScriptField scriptField = ScriptField.newBuilder().setScript(script).build();
        );  
        expectedParams.put("field", "price");
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            objectMapBuilder.putFields(entry.getKey(), ObjectMap.Value.newBuilder().setString(entry.getValue()).build());  
        assertNotNull("Script should not be null", resultScript);
            .build();  
        assertEquals("Script type should be INLINE", ScriptType.INLINE, resultScript.getType());
        InlineScript inlineScript = InlineScript.newBuilder()  
