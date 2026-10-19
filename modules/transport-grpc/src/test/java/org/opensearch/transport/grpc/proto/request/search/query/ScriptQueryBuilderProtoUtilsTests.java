        IllegalArgumentException exception = expectThrows(
import org.opensearch.protobufs.ScriptQuery;
                            .build()
            }
        assertNotNull(result.script().getOptions());
            BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_MUSTACHE,
 * SPDX-License-Identifier: Apache-2.0
        ScriptQuery scriptQuery = ScriptQuery.newBuilder()  
            assertEquals(languages[i], result.script().getLang());  
                            .setSource("doc['field'].value > 0")
                Script.newBuilder()
                    )  
 */  
import org.opensearch.protobufs.Script;  
    }  
            scriptQueryBuilder.setScript(Script.newBuilder().setInline(inlineScriptBuilder.build()).build());
import org.opensearch.protobufs.InlineScript;
        assertEquals("true", result.script().getIdOrCode());
                            .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS))  
    }  
            BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_EXPRESSION,  
public class ScriptQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        ScriptQuery scriptQuery = ScriptQuery.newBuilder()  
    public void testFromProtoWithInlineScript() {
            () -> ScriptQueryBuilderProtoUtils.fromProto(scriptQuery)
                    .build()
import org.opensearch.protobufs.BuiltinScriptLanguage;
import org.opensearch.index.query.ScriptQueryBuilder;  
                            .setParams(  
        assertEquals("my_stored_script", result.script().getIdOrCode());
                Script.newBuilder()
            .setScript(
                                    .build()
 * this file be licensed under the Apache-2.0 license or a
                                    .putFields(
                    )
        assertEquals(1.0f, result.boost(), 0.001f);
    }
        ScriptQueryBuilder result = ScriptQueryBuilderProtoUtils.fromProto(scriptQuery);
                            )
package org.opensearch.transport.grpc.proto.request.search.query;
            .setXName("")
        // Test inline script with all features
            ScriptQueryBuilder result = ScriptQueryBuilderProtoUtils.fromProto(scriptQueryBuilder.build());  
    public void testFromProtoWithNullInput() {  
            .setBoost(0.0f)
        ScriptQuery scriptQuery = ScriptQuery.newBuilder().build();  
import org.opensearch.test.OpenSearchTestCase;  
                                    .build()  
            BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_JAVA,
    public void testFromProtoWithMissingScript() {
            null };
        );
            .setBoost(2.0f)
    public void testFromProtoWithDefaults() {
            .setScript(
 *
        ScriptQueryBuilder result = ScriptQueryBuilderProtoUtils.fromProto(scriptQuery);
                inlineScriptBuilder.setLang(ScriptLanguage.newBuilder().setCustom(languages[i]));
        assertNotNull(result.script().getParams());
            InlineScript.Builder inlineScriptBuilder = InlineScript.newBuilder().setSource("test_script_" + i);
        assertEquals(2.0f, result.boost(), 0.001f);  
        assertEquals("painless", result.script().getLang());
 * compatible open source license.
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("true").build()).build())
                                    .putFields("multiplier", org.opensearch.protobufs.ObjectMap.Value.newBuilder().setDouble(2.5).build())  
        ScriptQuery scriptQuery = ScriptQuery.newBuilder()  
            .build();  
 */
    public void testFromProtoWithEdgeCases() {
            BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS,  
        assertEquals("script must be provided with a [script] query", exception.getMessage());  
    public void testFromProtoWithDifferentScriptLanguages() {
            IllegalArgumentException.class,
        assertNotNull(result);
        assertEquals("test_value", result.script().getParams().get("param1"));
                                org.opensearch.protobufs.ObjectMap.newBuilder()
                                org.opensearch.protobufs.ObjectMap.newBuilder()
        BuiltinScriptLanguage[] builtinLangs = {
            assertEquals("test_script_" + i, result.script().getIdOrCode());
                    .setInline(  
        assertNotNull(result.script());  
            .build();
            .build();
        assertNotNull(result.script());
        assertEquals(0.0f, result.boost(), 0.001f);
        assertEquals(2.5, result.script().getParams().get("multiplier"));  
    }  
        assertNull(result.queryName());
            assertNotNull(result);
                                    )
            ScriptQuery.Builder scriptQueryBuilder = ScriptQuery.newBuilder();
        assertNotNull(result);
        );
    public void testFromProtoWithStoredScript() {
        assertEquals("ScriptQuery cannot be null", exception.getMessage());
            () -> ScriptQueryBuilderProtoUtils.fromProto(null)  
            } else {  
                                        org.opensearch.protobufs.ObjectMap.Value.newBuilder().setString("test_value").build()
        IllegalArgumentException exception = expectThrows(
                            .setId("my_stored_script")
        String[] languages = { "painless", "java", "mustache", "expression", "custom_lang" };
            if (builtinLangs[i] != null) {
                        InlineScript.newBuilder()
                    .setStored(  
        for (int i = 0; i < languages.length; i++) {  
        assertNotNull(result.script().getParams());
        assertNotNull(result);  
                            .build()
    }
                    .build()  
            .setXName("test_query")  
/*  
        ScriptQueryBuilder result = ScriptQueryBuilderProtoUtils.fromProto(scriptQuery);
            IllegalArgumentException.class,  
        assertEquals("test_query", result.queryName());
                            )
        assertEquals("doc['field'].value > 0", result.script().getIdOrCode());  
    }
/**
                            .putOptions("content_type", "application/json")  
import org.opensearch.protobufs.ScriptLanguage;
                inlineScriptBuilder.setLang(ScriptLanguage.newBuilder().setBuiltin(builtinLangs[i]));
            )
 * The OpenSearch Contributors require contributions made to  
            .build();  
 * Unit tests for ScriptQueryBuilderProtoUtils.  
        ScriptQueryBuilder result = ScriptQueryBuilderProtoUtils.fromProto(scriptQuery);  
        assertNotNull(result);
        assertEquals("", result.queryName());  
                        org.opensearch.protobufs.StoredScriptId.newBuilder()
            )
        ScriptQuery scriptQuery = ScriptQuery.newBuilder()
        assertNull(result.script().getLang());  
                            .setParams(
        }
                                        "param1",  
        assertEquals("application/json", result.script().getOptions().get("content_type"));
}
        // Test different script languages  
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("true").build()).build())  
    }  
