/*
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");
        assertThat("own declared+registered type must be accepted", fieldMapper.typeName(), equalTo("faketype"));
import org.opensearch.core.xcontent.XContentParser;
     * auto-inference plugin must still work.
    public void testInferencerDeclaringAnotherPluginsTypeFailsAtStartup() {
 * Verifies that a dynamic field type inferencer may only produce a type its OWN plugin registered.
        assertNotNull(fieldMapper);
     * instead of {@code getMappers()}, this valid claim would be silently rejected.
    private String pluginASupportedType;
            config.put("type", claimedType);
        pluginASupportedType = TYPE_A;
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
            try (XContentParser parser = fieldValueParser.get()) {
 * is a validly-registered type globally. When A claims its own {@code type_a}, the claim is accepted.
            }
 * inferencer whose claimed type is chosen per-test. When A claims {@code type_b} — a type it does not
        public Set<String> supportedTypes() {
        @Override
        }
        }
import java.util.HashMap;
     */
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
     * An inferencer producing a type it declared and its OWN plugin registered (as a mapper type only,
        assertThat(e.getMessage(), containsString("does not register via getMappers()"));
        }
    /** Plugin B: registers and owns TYPE_B. Has no inferencer. */
     * to the mapper registry, not to {@link MapperPlugin#getDynamicTemplateTypes()} — a pure
import org.opensearch.plugins.Plugin;
public class PluginInferencerTypeOwnershipTests extends MapperServiceTestCase {
    static class MockTypeParser implements Mapper.TypeParser {
        assertNotNull(doc.dynamicMappingsUpdate());
        @Override
        @Override
    // Set by each test before createDocumentMapper() is called; consumed by getPlugins() to decide
    public void testInferencerClaimingTypeOutsideSupportedTypesIsRejected() throws IOException {
            return Collections.singletonMap(TYPE_A, new MockTypeParser());
        }
        @Override
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
    /**
            return Collections.singletonMap(TYPE_B, new MockTypeParser());
            return Collections.singleton(supportedType);
        ClaimsTypeInferencer(String supportedType, String claimedType) {
            Map<String, Object> config = new HashMap<>();
    }
 * This is the gap the coarse "is it any plugin-registered type" check did not cover.
        pluginAClaimedType = TYPE_A;
     */
    /**
import static org.hamcrest.Matchers.containsString;
     * dynamic mapping (a numeric scalar maps as long). This is the runtime half of the contract.
        }
    private String pluginAClaimedType;
 */
     * same in normal use; a test can set them differently to exercise the runtime check that rejects a
        pluginASupportedType = TYPE_B;
    }
        assertThat(e.getMessage(), containsString("declares supported type [" + TYPE_B + "]"));
 *
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
import java.util.Set;
 */
    @Override
     * Registering the type solely via {@link MapperPlugin#getMappers()} also proves ownership is bound
        pluginAClaimedType = TYPE_B;
     * Plugin A validly declares supportedTypes() = TYPE_A but its inferencer claims TYPE_B at runtime
     * (a type outside its declared set). The claim is rejected and the field falls through to normal
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
            node.remove("type");
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {}
        @Override
    static class ClaimsTypeInferencer implements DynamicFieldTypeInferencer {
    /**
    /**
        }
    private static final String TYPE_B = "type_b";
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
    }
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> createDocumentMapper(topMapping(b -> {})));
     * Declares {@code supportedType} and claims numeric scalars as {@code claimedType}. The two are the
            this.supportedType = supportedType;
    }
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
        }
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(new PluginA(), new PluginB());
        @Override
import java.util.Arrays;
import java.util.Map;
     * covers a pure auto-inference plugin: if ownership were bound to {@code getDynamicTemplateTypes()}
     */
            return new MockFieldMapper.Builder(name);
 * own — core rejects the claim and falls through to normal dynamic mapping, even though {@code type_b}
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) {
    }
     */
        public Map<String, Mapper.TypeParser> getMappers() {
package org.opensearch.index.mapper;
     * with NO dynamic-template type) is accepted. Guards against the binding being too strict and
        @Override
import java.io.IOException;
    }
        assertNotNull(fieldMapper);
        private final String supportedType;
    static class PluginB extends Plugin implements MapperPlugin {
        }
            return true;
            this.claimedType = claimedType;
 * <p>Two plugins are installed: plugin B registers the type {@code type_b}, and plugin A ships an
     * claim outside the declared supportedTypes().
     */
     * getMappers(). This catches a cross-plugin type grab at node startup rather than at index time.
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {
    /** No-op handler; its config is always complete so no field read happens. */
    /** Builds a MockFieldMapper (no required params). */
            return config;
    public void testInferencerCanProduceOwnPluginType() throws IOException {
     * Plugin A: registers and owns TYPE_A as a mapper type ONLY (no dynamic-template type). Its
        assertThat("claim outside supportedTypes() must be rejected; field falls through to long", fieldMapper.typeName(), equalTo("long"));
        public Map<String, Mapper.TypeParser> getMappers() {
    }
    static class NoopHandler implements DynamicTemplateTypeHandler {
 * compatible open source license.
    class PluginA extends Plugin implements MapperPlugin {
        assertNotNull(doc.dynamicMappingsUpdate());
     * validation rejects this: an inferencer may only declare types its own plugin registers via
     * Plugin A declares supportedTypes() = TYPE_B, a type registered by plugin B, not A. Startup
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));
        @Override
    private static final String TYPE_A = "type_a";
 *
/**
        pluginAClaimedType = TYPE_B;
     * inferencer declares {@link #pluginASupportedType} and claims {@link #pluginAClaimedType}.
    /**
import java.util.Collection;
    protected Collection<? extends Plugin> getPlugins() {
import java.util.List;
        private final String claimedType;
        @Override
            return Collections.singletonMap(TYPE_B, new NoopHandler());
import org.opensearch.plugins.MapperPlugin;
import java.util.Collections;
}
 * The OpenSearch Contributors require contributions made to
    // what type plugin A's inferencer declares (supportedTypes) and what type it actually claims.
    }
        pluginASupportedType = TYPE_A;
        }
            return Collections.singletonList(new ClaimsTypeInferencer(pluginASupportedType, pluginAClaimedType));
