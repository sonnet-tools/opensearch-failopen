        @Override
     */
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {}  
        assertNotNull(doc.dynamicMappingsUpdate());
 * The OpenSearch Contributors require contributions made to  
    private String pluginAClaimedType;
     * validation rejects this: an inferencer may only declare types its own plugin registers via
        }
            return config;
        @Override
        @Override  
 * <p>Two plugins are installed: plugin B registers the type {@code type_b}, and plugin A ships an
    }
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
import org.opensearch.plugins.Plugin;  
import java.util.Collection;
        assertNotNull(fieldMapper);
            return Collections.singletonMap(TYPE_A, new MockTypeParser());
import static org.hamcrest.Matchers.equalTo;  
     * to the mapper registry, not to {@link MapperPlugin#getDynamicTemplateTypes()} — a pure  
        @Override
     * An inferencer producing a type it declared and its OWN plugin registered (as a mapper type only,  
        public Map<String, Mapper.TypeParser> getMappers() {
    static class ClaimsTypeInferencer implements DynamicFieldTypeInferencer {
            return new MockFieldMapper.Builder(name);
        public Map<String, Mapper.TypeParser> getMappers() {
    }
    public void testInferencerClaimingTypeOutsideSupportedTypesIsRejected() throws IOException {  
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
            return Collections.singletonMap(TYPE_B, new NoopHandler());
public class PluginInferencerTypeOwnershipTests extends MapperServiceTestCase {
import static org.hamcrest.Matchers.containsString;
import java.util.Arrays;  
    /**
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) {
    }
 * own — core rejects the claim and falls through to normal dynamic mapping, even though {@code type_b}
        assertThat(e.getMessage(), containsString("does not register via getMappers()"));
import java.util.Collections;
        assertNotNull(doc.dynamicMappingsUpdate());
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
    public void testInferencerDeclaringAnotherPluginsTypeFailsAtStartup() {
 * inferencer whose claimed type is chosen per-test. When A claims {@code type_b} — a type it does not  
        }
    }
        @Override
    private String pluginASupportedType;  
     * getMappers(). This catches a cross-plugin type grab at node startup rather than at index time.  
    /**  
}  
    @Override
    static class PluginB extends Plugin implements MapperPlugin {
    /**  
import org.opensearch.core.xcontent.XContentParser;
            this.claimedType = claimedType;
     * dynamic mapping (a numeric scalar maps as long). This is the runtime half of the contract.
     */
 *
     * instead of {@code getMappers()}, this valid claim would be silently rejected.  
     */
    /**
     * claim outside the declared supportedTypes().  
            return Collections.singletonMap(TYPE_B, new MockTypeParser());  
        pluginASupportedType = TYPE_B;  
    }  
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
    }
     */
        @Override
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
        }  
 * is a validly-registered type globally. When A claims its own {@code type_a}, the claim is accepted.
    // Set by each test before createDocumentMapper() is called; consumed by getPlugins() to decide
import java.util.Set;  
 *
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));
     * inferencer declares {@link #pluginASupportedType} and claims {@link #pluginAClaimedType}.
        pluginAClaimedType = TYPE_B;
     * Plugin A validly declares supportedTypes() = TYPE_A but its inferencer claims TYPE_B at runtime
        pluginASupportedType = TYPE_A;  
 * Verifies that a dynamic field type inferencer may only produce a type its OWN plugin registered.  
     * Plugin A: registers and owns TYPE_A as a mapper type ONLY (no dynamic-template type). Its  
     * Registering the type solely via {@link MapperPlugin#getMappers()} also proves ownership is bound
 * compatible open source license.
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");  
        assertThat("claim outside supportedTypes() must be rejected; field falls through to long", fieldMapper.typeName(), equalTo("long"));
        pluginAClaimedType = TYPE_A;
    static class NoopHandler implements DynamicTemplateTypeHandler {
        assertThat("own declared+registered type must be accepted", fieldMapper.typeName(), equalTo("faketype"));
            return Collections.singleton(supportedType);
            try (XContentParser parser = fieldValueParser.get()) {  
/**
/*  
     * same in normal use; a test can set them differently to exercise the runtime check that rejects a
    /** Builds a MockFieldMapper (no required params). */
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
     * covers a pure auto-inference plugin: if ownership were bound to {@code getDynamicTemplateTypes()}
        }
        pluginASupportedType = TYPE_A;
    }  
    /** No-op handler; its config is always complete so no field read happens. */  
        @Override
        }
        private final String claimedType;
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {  
            Map<String, Object> config = new HashMap<>();  
            }
        assertThat(e.getMessage(), containsString("declares supported type [" + TYPE_B + "]"));  
import java.util.Map;
 */  
     * with NO dynamic-template type) is accepted. Guards against the binding being too strict and
    }  
    public void testInferencerCanProduceOwnPluginType() throws IOException {
            config.put("type", claimedType);
    // what type plugin A's inferencer declares (supportedTypes) and what type it actually claims.
    class PluginA extends Plugin implements MapperPlugin {  
        return Arrays.asList(new PluginA(), new PluginB());  
import java.util.HashMap;  
    protected Collection<? extends Plugin> getPlugins() {
        }  
        pluginAClaimedType = TYPE_B;
     * Declares {@code supportedType} and claims numeric scalars as {@code claimedType}. The two are the
            node.remove("type");  
        public Set<String> supportedTypes() {  
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));  
     * (a type outside its declared set). The claim is rejected and the field falls through to normal  
    private static final String TYPE_B = "type_b";
    }
 */
     */
        @Override
import org.opensearch.plugins.MapperPlugin;
    /** Plugin B: registers and owns TYPE_B. Has no inferencer. */  
        }  
 * This is the gap the coarse "is it any plugin-registered type" check did not cover.  
        @Override
        }
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");
    private static final String TYPE_A = "type_a";
        assertNotNull(fieldMapper);  
package org.opensearch.index.mapper;
     * auto-inference plugin must still work.
 * this file be licensed under the Apache-2.0 license or a
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {  
            this.supportedType = supportedType;
    static class MockTypeParser implements Mapper.TypeParser {  
     * Plugin A declares supportedTypes() = TYPE_B, a type registered by plugin B, not A. Startup
            return Collections.singletonList(new ClaimsTypeInferencer(pluginASupportedType, pluginAClaimedType));  
import java.io.IOException;
            return true;
        ClaimsTypeInferencer(String supportedType, String claimedType) {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(topMapping(b -> {})));
import java.util.List;
        private final String supportedType;  
