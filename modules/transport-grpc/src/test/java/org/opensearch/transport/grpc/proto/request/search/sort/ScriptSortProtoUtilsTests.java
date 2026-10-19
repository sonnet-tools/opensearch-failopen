        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
import org.opensearch.test.OpenSearchTestCase;  
    public void testFromProto_NullInput() {  
                ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
 * Tests for {@link ScriptSortProtoUtils}.
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("ScriptSort must have a type", exception.getMessage());
                ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
/**
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
 * SPDX-License-Identifier: Apache-2.0
            .setOrder(SortOrder.SORT_ORDER_DESC)  
            .build();
        assertNotNull(result);
        ScriptSort scriptSort = ScriptSort.newBuilder().setScript(script).setType(ScriptSortType.SCRIPT_SORT_TYPE_NUMBER).build();
 */  
            .build();
        super.setUp();
        assertEquals(org.opensearch.search.sort.SortOrder.ASC, result.order());  
    public void testFromProto_WithRequiredFields() {
        assertEquals(ScriptSortBuilder.ScriptSortType.NUMBER, result.type());  
            .setSource("doc['price'].value")
        assertNotNull(result.getNestedSort());
        IllegalArgumentException exception = expectThrows(
            .setSource("doc['price'].value")
        InlineScript inlineScript = InlineScript.newBuilder()
    private QueryBuilderProtoConverterRegistry registry;  
        ScriptSortBuilder result = ScriptSortProtoUtils.fromProto(scriptSort, registry);
/*  
        ScriptSort scriptSort = ScriptSort.newBuilder().setType(ScriptSortType.SCRIPT_SORT_TYPE_NUMBER).build();  
            .setLang(  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
    }  
        registry = new QueryBuilderProtoConverterRegistryImpl();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
        assertNotNull(result);
    @Override
import org.opensearch.protobufs.SortOrder;
    public void setUp() throws Exception {  
            .setLang(
    }
        });
        InlineScript inlineScript = InlineScript.newBuilder()  
    }  
        Script script = Script.newBuilder().setInline(inlineScript).build();
    }
import org.opensearch.protobufs.InlineScript;  
        assertNull(result.sortMode());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
import org.opensearch.protobufs.ScriptSortType;
        NestedSortValue nestedSort = NestedSortValue.newBuilder().setPath("nested.field").build();
 *
import org.opensearch.protobufs.NestedSortValue;
 * compatible open source license.
            .setSource("doc['price'].value * params.factor")
        ScriptSortBuilder result = ScriptSortProtoUtils.fromProto(scriptSort, registry);
        Script script = Script.newBuilder().setInline(inlineScript).build();
        assertEquals("nested.field", result.getNestedSort().getPath());  
import org.opensearch.protobufs.ScriptLanguage;  
        ScriptSort scriptSort = ScriptSort.newBuilder()  
    public void testFromProto_MissingType() {
        ScriptSort scriptSort = ScriptSort.newBuilder().setScript(script).setType(ScriptSortType.SCRIPT_SORT_TYPE_UNSPECIFIED).build();  
        Script script = Script.newBuilder().setInline(inlineScript).build();
            .build();  
            )
    public void testFromProto_MissingScript() {
            () -> { ScriptSortProtoUtils.fromProto(null, registry); }  
    }  
                ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
        // Default order should be ASC (ScriptSortBuilder default)
import org.opensearch.protobufs.Script;
import org.opensearch.protobufs.SortMode;  
        InlineScript inlineScript = InlineScript.newBuilder()  
            )
            .setLang(
        assertEquals(org.opensearch.search.sort.SortMode.MIN, result.sortMode());
        assertEquals(org.opensearch.search.sort.SortOrder.DESC, result.order());  
        );
                ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
        assertNull(result.getNestedSort());
        InlineScript inlineScript = InlineScript.newBuilder()  
        assertNotNull(result.script());
    }  
            .setScript(script)
 */  
            .setLang(
            .setLang(
    }  
        assertEquals("ScriptSortType must be specified", exception.getMessage());
        // Create nested sort  
        ScriptSort scriptSort = ScriptSort.newBuilder().setScript(script).build();  
import org.opensearch.search.sort.ScriptSortBuilder;
        assertEquals("ScriptSort must have a script", exception.getMessage());
        assertNotNull(result);
            .setType(ScriptSortType.SCRIPT_SORT_TYPE_STRING)
        assertEquals("ScriptSort cannot be null", exception.getMessage());
            .setMode(SortMode.SORT_MODE_MIN)
            ScriptSortProtoUtils.fromProto(scriptSort, registry);  
        Script script = Script.newBuilder().setInline(inlineScript).build();
            .setSource("Math.random()")
        InlineScript inlineScript = InlineScript.newBuilder()  
package org.opensearch.transport.grpc.proto.request.search.sort;
        });
}
            .build();  
            )
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
    }  
import org.opensearch.protobufs.ScriptSort;
        Script script = Script.newBuilder().setInline(inlineScript).build();
    public void testFromProto_UnspecifiedType() {
    public void testFromProto_WithAllFields() {
            ScriptSortProtoUtils.fromProto(scriptSort, registry);  
            .build();
            )
        });
            .build();
public class ScriptSortProtoUtilsTests extends OpenSearchTestCase {
            .setNested(nestedSort)
            )
        ScriptSort scriptSort = ScriptSort.newBuilder().setScript(script).setType(ScriptSortType.SCRIPT_SORT_TYPE_NUMBER).build();  
        assertEquals(ScriptSortBuilder.ScriptSortType.STRING, result.type());
        // Create a simple inline script
    public void testFromProto_WithDefaultOrder() {
            .setSource("doc['title'].value")
        ScriptSortBuilder result = ScriptSortProtoUtils.fromProto(scriptSort, registry);  
            ScriptSortProtoUtils.fromProto(scriptSort, registry);  
                ScriptLanguage.newBuilder().setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        // Create a simple inline script  
