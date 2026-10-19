 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithNullScriptScoreFunction() {
public class ScriptScoreFunctionProtoUtilsTests extends OpenSearchTestCase {
    }
import org.opensearch.protobufs.ObjectMap.Value;
            .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS).build())  
            UnsupportedOperationException.class,  
        assertThat(result, instanceOf(ScriptScoreFunctionBuilder.class));
        );
        Script script = Script.newBuilder().build();
        IllegalArgumentException exception = expectThrows(
import org.opensearch.test.OpenSearchTestCase;
        ScriptScoreFunctionBuilder scriptFunction = (ScriptScoreFunctionBuilder) result;
    }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
        );
    public void testFromProtoWithNullScript() {  
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.opensearch.protobufs.InlineScript;
 * this file be licensed under the Apache-2.0 license or a
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setScriptScore(scriptScoreFunction).setWeight(1.5f).build();  
    public void testFromProtoWithoutScript() {  
import org.opensearch.protobufs.ObjectMap;  
import static org.hamcrest.Matchers.instanceOf;
            () -> ScriptScoreFunctionProtoUtils.fromProto(scriptScoreFunction)
        ScoreFunctionBuilder<?> result = ScriptScoreFunctionProtoUtils.fromProto(scriptScoreFunction);
import org.opensearch.protobufs.ScriptLanguage;  
import org.opensearch.protobufs.BuiltinScriptLanguage;  
            () -> ScriptScoreFunction.newBuilder().setScript((org.opensearch.protobufs.Script) null)
        assertEquals("doc['score'].value * params.factor", openSearchScript.getIdOrCode());  
        InlineScript inlineScript = InlineScript.newBuilder()
        ScriptScoreFunction scriptScoreFunction = ScriptScoreFunction.newBuilder().setScript(script).build();
        org.opensearch.script.Script openSearchScript = scriptFunction.getScript();  
import org.opensearch.protobufs.Script;
        Script script = Script.newBuilder().setInline(inlineScript).build();
        // This is expected behavior - protobuf doesn't allow null values  
            () -> ScriptScoreFunctionProtoUtils.fromProto(null)
import org.opensearch.protobufs.ScriptScoreFunction;
        UnsupportedOperationException exception = expectThrows(
        assertThat(exception.getMessage(), containsString("No valid script type detected"));  
            .build();
        );  
            () -> ScriptScoreFunctionProtoUtils.fromProto(scriptScoreFunction)
        assertThat(exception.getMessage(), containsString("ScriptScoreFunction cannot be null"));  
    public void testFromProtoWithEmptyScript() {  
            IllegalArgumentException.class,  
 */  
        assertEquals("painless", openSearchScript.getLang());
        NullPointerException exception = expectThrows(
            .setParams(ObjectMap.newBuilder().putFields("factor", Value.newBuilder().setDouble(2.0).build()).build())
}  
        ScriptScoreFunction scriptScoreFunction = ScriptScoreFunction.newBuilder().build();
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
        );
        IllegalArgumentException exception = expectThrows(  
/*  
 *
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        ScriptScoreFunction scriptScoreFunction = ScriptScoreFunction.newBuilder().setScript(script).build();
    }
        assertEquals(2.0, openSearchScript.getParams().get("factor"));
        assertEquals(org.opensearch.script.ScriptType.INLINE, openSearchScript.getType());
            IllegalArgumentException.class,
        assertThat(exception.getMessage(), containsString("ScriptScoreFunction must have a script"));
            .setSource("doc['score'].value * params.factor")
        // Test that setting null script throws NullPointerException at protobuf level
    public void testFromProtoWithScript() {  
        FunctionScoreContainer container = FunctionScoreContainer.newBuilder().setScriptScore(scriptScoreFunction).build();  
import org.opensearch.protobufs.FunctionScoreContainer;
    }
    }
            NullPointerException.class,  
 * compatible open source license.
