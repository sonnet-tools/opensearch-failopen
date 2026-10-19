        ObjectMap params = ObjectMap.newBuilder()
                        ScriptLanguage.newBuilder()
        assertEquals("Script language should be painless", "painless", script.getLang());
        assertTrue("Script params should be empty", script.getParams().isEmpty());
                    .setLang(
        assertEquals("Script id should match", "my-stored-script", script.getIdOrCode());
                InlineScript.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testParseFromProtoRequestWithNoScriptType() {
            script.getOptions().get("content_type")
import org.opensearch.protobufs.InlineScript;
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
 */
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            .build();
            .setInline(
        assertNotNull("Script should not be null", script);
            .putFields("name", ObjectMap.Value.newBuilder().setString("test").build())
                    )
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
        assertNotNull("Script should not be null", script);
            "application/json",
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        assertEquals("Script language should be painless", "painless", script.getLang());
            .build();
/*
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder().build();
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .putAllOptions(options)
        assertTrue("Script params should be empty", script.getParams().isEmpty());
                InlineScript.newBuilder()
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
        assertNotNull("Script should not be null", script);
                    .build()
    }
                    .putAllOptions(options)
    }
        Map<String, String> options = new HashMap<>();
        assertEquals("Script params should have 2 entries", 2, script.getParams().size());
        assertEquals("Script param 'factor' should be 2.5", 2.5, script.getParams().get("factor"));
            .setInline(
                    )
                    .setSource("doc['field'].value * 2")
        assertEquals("Script language should be expression", "expression", script.getLang());
            )
                    .setSource("doc['field'].value * 2")
        assertEquals("Script param 'name' should be 'test'", "test", script.getParams().get("name"));
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
 *
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_UNSPECIFIED)
        assertNull("Script language should be null for stored scripts", script.getLang());
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        assertNull("Script options should be null for stored scripts", script.getOptions());
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        assertEquals("Script language should be java", "java", script.getLang());
    public void testParseScriptLanguageWithMustacheLanguage() {
                InlineScript.newBuilder()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
 * compatible open source license.
                    )
            .putFields("factor", ObjectMap.Value.newBuilder().setDouble(2.5).build())
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_MUSTACHE)
    public void testParseScriptLanguageWithExpressionLanguage() {
            .build();
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
            .setStored(StoredScriptId.newBuilder().setId("my-stored-script").setParams(params).build())
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
            .build();
            .setInline(
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                    .setLang(
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                    .build()
    }
                    .setSource("doc['field'].value * 2")
                    .build()
            .build();
        assertNull("Script language should be null for stored scripts", script.getLang());
        assertNotNull("Script should not be null", script);
                    )
    public void testParseFromProtoRequestWithInlineScriptAndCustomLanguage() {
        assertNotNull("Script should not be null", script);
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
                    .setLang(
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
    }
                    .setSource("doc['field'].value * 2")
    }
        assertEquals("Script language should be custom_lang", "custom_lang", script.getLang());
    }
            )
public class ScriptProtoUtilsTests extends OpenSearchTestCase {
            "Script option 'content_type' should be 'application/json'",
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
    }
    public void testParseScriptLanguageWithUnspecifiedLanguage() {
import org.opensearch.protobufs.ScriptLanguage;
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        assertNotNull("Script should not be null", script);
                        ScriptLanguage.newBuilder()
            .build();
        assertEquals("Script source should match", "doc['field'].value * params.factor", script.getIdOrCode());
    public void testParseFromProtoRequestWithInlineScript() {
                InlineScript.newBuilder()
                    .setParams(params)
                    .build()
                        ScriptLanguage.newBuilder()
    public void testParseScriptLanguageWithJavaLanguage() {
}
import java.util.HashMap;
import org.opensearch.protobufs.ObjectMap;
                InlineScript.newBuilder()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_EXPRESSION)
        assertEquals("Script param 'factor' should be 2.5", 2.5, script.getParams().get("factor"));
                    .setSource("doc['field'].value * 2")
        assertTrue("Script params should be empty", script.getParams().isEmpty());
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
                    .setSource("doc['field'].value * params.factor")
            )
            )
            )
            .setInline(
            .build();
                    .setLang(
        options.put("content_type", "application/json");
            .build();
            .build();
            .setInline(
        assertEquals("Script source should match", "doc['field'].value * 2", script.getIdOrCode());
        assertNotNull("Script should not be null", script);
            .putFields("factor", ObjectMap.Value.newBuilder().setDouble(2.5).build())
    }
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
            .build();
            )
                    .setLang(
                    .setLang(ScriptLanguage.newBuilder().setCustom("custom_lang"))
            )
        assertNotNull("Script should not be null", script);
                InlineScript.newBuilder()
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        Map<String, String> options = new HashMap<>();
                        ScriptLanguage.newBuilder()
import org.opensearch.script.Script;
import org.opensearch.script.ScriptType;
            )
        assertNotNull("Script should not be null", script);
    public void testParseFromProtoRequestWithInlineScriptAndParams() {
    public void testParseFromProtoRequestWithStoredScriptAndParams() {
                    .build()
                    .setLang(
        assertEquals("uses default language", DEFAULT_SCRIPT_LANG, ScriptProtoUtils.parseFromProtoRequest(protoScript).getLang());
        assertEquals("Script type should be STORED", ScriptType.STORED, script.getType());
            .build();
        expectThrows(IllegalArgumentException.class, () -> ScriptProtoUtils.parseFromProtoRequest(protoScript));
            .putFields("name", ObjectMap.Value.newBuilder().setString("test").build())
        options.put("invalid_option", "value");
    public void testParseFromProtoRequestWithInlineScriptAndInvalidOptions() {
    }
        ObjectMap params = ObjectMap.newBuilder()
    }
                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
                    )
    public void testParseFromProtoRequestWithStoredScript() {
    public void testParseFromProtoRequestWithInlineScriptAndOptions() {
                        ScriptLanguage.newBuilder()
                    .build()
                    .build()
                    .setSource("doc['field'].value * 2")
    }
                InlineScript.newBuilder()
import org.opensearch.protobufs.StoredScriptId;
            .setInline(
        assertEquals(
package org.opensearch.transport.grpc.proto.request.common;
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
        expectThrows(UnsupportedOperationException.class, () -> ScriptProtoUtils.parseFromProtoRequest(protoScript));
import java.util.Map;
            .setInline(
        assertEquals("Script param 'name' should be 'test'", "test", script.getParams().get("name"));
                    .setSource("doc['field'].value * 2")
 * The OpenSearch Contributors require contributions made to
            .setStored(StoredScriptId.newBuilder().setId("my-stored-script").build())
                InlineScript.newBuilder()
            .setInline(
                    .setSource("doc['field'].value * 2")
                        ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_JAVA)
                    .setLang(
                    )
                        ScriptLanguage.newBuilder()
            .build();
        assertEquals("Script id should match", "my-stored-script", script.getIdOrCode());
        assertEquals("Script params should have 2 entries", 2, script.getParams().size());
        assertEquals("Script language should be painless", "painless", script.getLang());
                    )
        assertEquals("Script options should have 1 entry", 1, script.getOptions().size());
            )
        assertEquals("Script language should be mustache", "mustache", script.getLang());
        assertEquals("Script type should be INLINE", ScriptType.INLINE, script.getType());
                    )
                    .setLang(
            .setInline(
        );
                        ScriptLanguage.newBuilder()
                    .build()
 * SPDX-License-Identifier: Apache-2.0
                InlineScript.newBuilder()
                    .build()
            .build();
import static org.opensearch.script.Script.DEFAULT_SCRIPT_LANG;
        org.opensearch.protobufs.Script protoScript = org.opensearch.protobufs.Script.newBuilder()
        Script script = ScriptProtoUtils.parseFromProtoRequest(protoScript);
        assertEquals("Script type should be STORED", ScriptType.STORED, script.getType());
        options.put("content_type", "application/json");
