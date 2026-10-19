        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                    .setSource("doc['field'].value * 2")
            "application/json",
        assertEquals("Script options should have 1 entry", 1, script.getOptions().size());
                    .setLang(ScriptLanguage.newBuilder().setCustom("custom_lang"))
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()  
            .build();  
                        ScriptLanguage.newBuilder()
            )
        assertEquals("Script param 'name' should be 'test'", "test", script.getParams().get("name"));
        assertEquals("Script language should be java", "java", script.getLang());
                    .build()
            .setInline(
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()  
            .build();  
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_EXPRESSION)
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Script id should match", "my-stored-script", script.getIdOrCode());
                InlineScript.newBuilder()
            .setInline(
        expectThrows(IllegalArgumentException.class, () -> ScriptProtoUtils.parseFromProtoRequest(protoScript));
    public void testParseScriptLanguageWithExpressionLanguage() {
                    )
                    .build()
            )
                        ScriptLanguage.newBuilder()
    public void testParseScriptLanguageWithJavaLanguage() {
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
        assertEquals("Script type should be STORED", ScriptType.STORED, script.getType());
                    .setSource("doc['field'].value * 2")  
        assertNotNull("Script should not be null", script);
        assertEquals(  
        Map<String, String> options = new HashMap<>();
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
        assertEquals("Script type should be STORED", ScriptType.STORED, script.getType());  
                        ScriptLanguage.newBuilder()  
        assertEquals("Script language should be painless", "painless", script.getLang());
        assertEquals("Script source should match", "doc['field'].value * params.factor", script.getIdOrCode());  
 *
                InlineScript.newBuilder()
                    .setLang(
            .setStored(StoredScriptId.newBuilder().setId("my-stored-script").setParams(params).build())
        assertEquals("Script language should be expression", "expression", script.getLang());
        assertEquals("Script language should be custom_lang", "custom_lang", script.getLang());
        assertNull("Script language should be null for stored scripts", script.getLang());
            )
                    .setLang(
                    .setSource("doc['field'].value * 2")  
import org.opensearch.protobufs.ScriptLanguage;  
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                    .build()
        ObjectMap params = ObjectMap.newBuilder()
        assertEquals("Script param 'factor' should be 2.5", 2.5, script.getParams().get("factor"));  
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
        assertNotNull("Script should not be null", script);
            .setInline(  
            .build();
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.common;
    public void testParseFromProtoRequestWithInlineScriptAndCustomLanguage() {
    public void testParseScriptLanguageWithUnspecifiedLanguage() {  
        assertNotNull("Script should not be null", script);
                    .build()
    public void testParseFromProtoRequestWithInlineScriptAndInvalidOptions() {
                    )
    }
        assertNull("Script language should be null for stored scripts", script.getLang());  
                    )  
/*  
            .putFields("factor", ObjectMap.Value.newBuilder().setDouble(2.5).build())  
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
            )
                        ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_JAVA)
            .setInline(
        assertNotNull("Script should not be null", script);
import static org.opensearch.script.Script.DEFAULT_SCRIPT_LANG;  
            .putFields("name", ObjectMap.Value.newBuilder().setString("test").build())  
import org.opensearch.protobufs.StoredScriptId;
            )
        assertEquals("Script param 'name' should be 'test'", "test", script.getParams().get("name"));  
import org.opensearch.script.ScriptType;  
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_MUSTACHE)  
            .build();  
                    )  
                    .setLang(
                    )  
            )
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
                InlineScript.newBuilder()
            .build();
        expectThrows(UnsupportedOperationException.class, () -> ScriptProtoUtils.parseFromProtoRequest(protoScript));
 */  
                    .setLang(
                InlineScript.newBuilder()
        assertNotNull("Script should not be null", script);
    public void testParseFromProtoRequestWithInlineScriptAndOptions() {  
        assertEquals("Script params should have 2 entries", 2, script.getParams().size());
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()  
                    .build()
                    )
            .putFields("name", ObjectMap.Value.newBuilder().setString("test").build())
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()  
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder().build();
    }
                    .setLang(
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
        options.put("content_type", "application/json");
                InlineScript.newBuilder()  
        assertTrue("Script params should be empty", script.getParams().isEmpty());  
                        ScriptLanguage.newBuilder()  
        );
                InlineScript.newBuilder()
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
                    )
    }  
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
    public void testParseFromProtoRequestWithInlineScriptAndParams() {  
            .setInline(
            )  
        ObjectMap params = ObjectMap.newBuilder()
            .build();
                    .setLang(  
        assertNotNull("Script should not be null", script);  
        Map<String, String> options = new HashMap<>();
        assertTrue("Script params should be empty", script.getParams().isEmpty());  
                    .setSource("doc['field'].value * 2")
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .putAllOptions(options)
                    .setSource("doc['field'].value * 2")  
                    .putAllOptions(options)  
    }
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
import org.opensearch.script.Script;
                    .setSource("doc['field'].value * params.factor")  
            .setInline(
                        ScriptLanguage.newBuilder()
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
    }
            .build();
                    )
                InlineScript.newBuilder()
                InlineScript.newBuilder()
                    .setSource("doc['field'].value * 2")  
        assertEquals("Script language should be mustache", "mustache", script.getLang());  
            .build();  
    }
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .build()  
            .build();
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
    }
    public void testParseScriptLanguageWithMustacheLanguage() {
            .setInline(
        assertNotNull("Script should not be null", script);
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
            .putFields("factor", ObjectMap.Value.newBuilder().setDouble(2.5).build())
        assertNotNull("Script should not be null", script);
        assertEquals("uses default language", DEFAULT_SCRIPT_LANG, ScriptProtoUtils.parseFromProtoRequest(protoScript).getLang());
                    .build()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);  
            script.getOptions().get("content_type")  
                    .setLang(  
import java.util.Map;
    public void testParseFromProtoRequestWithStoredScriptAndParams() {
        assertTrue("Script params should be empty", script.getParams().isEmpty());
    }  
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .setParams(params)
                    .build()  
    }  
        assertEquals("Script language should be painless", "painless", script.getLang());  
import org.opensearch.protobufs.InlineScript;
import org.opensearch.test.OpenSearchTestCase;
            .setInline(
 * this file be licensed under the Apache-2.0 license or a
            )  
        assertNull("Script options should be null for stored scripts", script.getOptions());
                        ScriptLanguage.newBuilder()
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());  
        assertEquals("Script id should match", "my-stored-script", script.getIdOrCode());
        options.put("content_type", "application/json");  
import org.opensearch.protobufs.ObjectMap;
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
}  
            .build();
    }
    public void testParseFromProtoRequestWithNoScriptType() {
import java.util.HashMap;  
            .build();
            "Script option 'content_type' should be 'application/json'",
                    .build()  
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);  
    public void testParseFromProtoRequestWithStoredScript() {
 * The OpenSearch Contributors require contributions made to  
    }
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .setLang(
        assertEquals("Script language should be painless", "painless", script.getLang());  
                    .setSource("doc['field'].value * 2")
            )
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
public class ScriptProtoUtilsTests extends OpenSearchTestCase {
        options.put("invalid_option", "value");
                        ScriptLanguage.newBuilder()
    public void testParseFromProtoRequestWithInlineScript() {
        assertNotNull("Script should not be null", script);
                    .setSource("doc['field'].value * 2")
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()  
    }
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_UNSPECIFIED)
        assertEquals("Script param 'factor' should be 2.5", 2.5, script.getParams().get("factor"));
        assertEquals("Script params should have 2 entries", 2, script.getParams().size());
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            .build();  
            .setInline(  
            .build();
                InlineScript.newBuilder()  
            .setStored(StoredScriptId.newBuilder().setId("my-stored-script").build())  
