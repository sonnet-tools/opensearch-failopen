            b.endObject();
        createMapperService(topMapping(b -> {
        DynamicTemplate template = parseWithRegistry("t", conf);
        assertFalse(template.matchesPluginType("other.field", "field", MOCK_TYPE));
            config.put("required_param", "present");
    }
        return Collections.singletonList(new MockMapperPlugin());
                parser.currentToken();
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {
        // First doc triggers inference
            b.endObject();
     */
    static class MockInferredTemplateTypeHandler implements DynamicTemplateTypeHandler {
            DynamicTemplate template = DynamicTemplate.parse("t_" + t, conf);
        DynamicTemplate template = DynamicTemplate.parse("t", conf);
    }
            b.field("type", MOCK_THROWING_TYPE);
 *   (scalars are safe — Long mapper handles them without parsesArrayValue issues)
        assertNotNull(doc.dynamicMappingsUpdate());
            b.endObject();
 *
            b.startObject();
        MapperService mapperService = new MapperServiceTestCase() {
    public void testNoPluginsNormalPathRuns() throws IOException {
package org.opensearch.index.mapper;
        assertNull("explicit mapping must beat inferencer", doc.dynamicMappingsUpdate());
        @Override
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
        public Map<String, Mapper.TypeParser> getMappers() {
            b.startObject("properties");
     * not register — so a test can assert core rejects an unregistered inferred type.
    }
            try (XContentParser parser = fieldValueParser.get()) {
            conf.put("mapping", Collections.singletonMap("type", "keyword"));
    }
import org.opensearch.plugins.MapperPlugin;
            conf.put("match_mapping_type", t.toString());
        assertNull("already mapped field must not re-trigger inference", second.dynamicMappingsUpdate());
        assertNotNull(fieldMapper);
            b.endObject();
        // Plugin registers template type but no inferencer.
        conf.put("unmatch", "excluded_*");
        @Override
}
            b.field("type", MOCK_INFERRED_TYPE);
            b.field("type", "keyword");
            b.field("match_mapping_type", MOCK_TYPE);
import java.util.Set;
        registry.put(MOCK_THROWING_TYPE, new ThrowingTemplateTypeHandler());
            b.startObject("mapping");
        assertNotNull(first.dynamicMappingsUpdate());
            b.startObject("mapping");
    public void testUnregisteredPluginTypeThrowsAtIndexCreation() throws IOException {
        }
            protected Collection<? extends Plugin> getPlugins() {
    }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
            b.startObject("mapping");
    }
        MapperService mapperService = createMapperService(topMapping(b -> {
        });
        public Set<String> supportedTypes() {
            b.startObject();
        ContentPath path = new ContentPath();
        createMapperService(topMapping(b -> {
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
    /**
            b.endObject();
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {
            b.endArray();
    // DynamicTemplate unit tests
    }
    /** No-op handler — template config used as-is. Reports its config as always complete. */
        conf.put("match_mapping_type", "string");
                value = parser.doubleValue();
    }
            mappers.put(MOCK_THROWING_TYPE, new RequiresParamTypeParser());
        ParsedDocument first = mapper.parse(source(b -> b.field("big_number", 200)));
            b.field("type", MOCK_TYPE);
            b.startObject("string_template");
            b.startArray("dynamic_templates");
     * Using scalars (not arrays) avoids needing a parsesArrayValue mapper in core tests.
        // {name} can't be resolved up front, so validation is skipped even though required_param is missing.
        // tryPluginInference must NOT fast-exit — template types alone are enough to proceed.
        }
            b.startObject();
        DynamicTemplate template = parseWithRegistry("t", conf);
            b.startObject("mapping");
        // Handler opens no parser (complete config) and the type parser is satisfied → index creation succeeds.
            return handlers;
        // value. Core must ignore the claim and let the normal dynamic-mapping path map it as long.
    }
        @Override
    @Override
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {}
        ParsedDocument doc = mapper.parse(source(b -> b.field("bool_field", true)));
        assertNotNull(doc.dynamicMappingsUpdate());
        @Override
        Map<String, Object> conf = new HashMap<>();
            b.endObject();
                return Collections.singletonList(new TemplateOnlyPlugin());
    }
            b.startObject("mapping");
            b.field("type", MOCK_TYPE);
            b.endObject();
        // Explicit keyword mapping — inference must not fire even for value >= 100
        });
    }
        assertTrue(template.matchesPluginType("big_field", "big_field", MOCK_TYPE));
                return Collections.emptyList();
    public void testAlreadyInferredFieldSkipsInferenceOnSecondDoc() throws IOException {
            b.startObject("typo_template");
        @Override
    private static final String MOCK_TYPE = "mock_type";
            b.startObject();
        Map<String, Object> conf = new HashMap<>();
            b.field("match_mapping_type", "string");
        }
    public void testInferencerDoesNotClaimSmallNumericScalar() throws IOException {
        }
public class PluginDynamicTemplateTests extends MapperServiceTestCase {
            b.endObject();
        });
        }));
    }
        RootObjectMapper root = mapperService.documentMapper().mapping().root();
    }
            handlers.put(MOCK_INFERRED_TYPE, new MockInferredTemplateTypeHandler());
            b.field("type", "keyword");
    // A numeric value the inferencer maps to the core type "long" (a type it does not register),
            config.put("type", MOCK_TYPE);
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // The handler reports its config complete but throws from adjustMappingConfig. Core must treat
     * a mapping with no {@code dimension}. Used to prove eager index-creation-time validation throws.
    // =====================================================================
        }
        assertNotNull(doc.dynamicMappingsUpdate());
        Map<String, Object> conf = new HashMap<>();
        // The inferencer returns the core type "long" (which it does not register) for the sentinel
        assertFalse(template.matchesPluginType("field", "field", "other_type"));
            b.startArray("dynamic_templates");
        ParsedDocument doc = mapper.parse(source(b -> b.field("big_number", 200)));
        }));
    static class ThrowingTemplateTypeHandler implements DynamicTemplateTypeHandler {
 * Tests for plugin-extensible dynamic template types (match_mapping_type SPI)
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        assertNotNull(fieldMapper);
import java.util.Map;
     * adjustMappingConfig — a handler-contract violation. Core must treat this as non-fatal and defer.
        Map<String, Object> conf = new HashMap<>();
        }
        conf.put("match_mapping_type", MOCK_TYPE);
        conf.put("match", "big_*");
import static org.hamcrest.Matchers.containsString;
        DynamicTemplate template = parseWithRegistry("t", conf);
        assertNotNull(fieldMapper);
    public void testAllBuiltinTypesNotStoredAsPlugin() {
            b.endObject();
            }
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    public void testMatchesPluginTypeWithUnmatch() {
        assertThat(e.getMessage(), containsString(MOCK_TYPE));
            double value;
        registry.put(MOCK_TYPE, new MockTemplateTypeHandler());
            mappers.put(MOCK_INFERRED_TYPE, new RequiresParamTypeParser());
        // Simulate mapping update applied — second doc should not re-infer
    public void testBuiltinMatchTypeNotStoredAsPlugin() {
        assertNotNull(mapperService.documentMapper());
            b.field("type", "long");
import java.util.Collections;
        assertThat(e.getMessage(), containsString(MOCK_TYPE));
        ParsedDocument doc = noPluginService.documentMapper().parse(source(b -> b.field("my_field", "hello")));
        // 200 >= 100 threshold — MockInferencer claims it as the plugin-registered MOCK_TYPE
        XContentBuilder mapping = topMapping(b -> {
        for (XContentFieldType t : XContentFieldType.values()) {
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
            b.endObject();
    }
            b.startArray("dynamic_templates");
        for (XContentFieldType t : XContentFieldType.values()) {
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
        DynamicTemplate template = parseWithRegistry("t", conf);
    }
            b.endObject();
            b.endArray();
            b.startObject("mapping");
 * - Registers "mock_type" as a plugin match_mapping_type
     * {@link #CORE_TYPE_SENTINEL} value, which it claims as the core type "long" — a type it does
        }));
        ParsedDocument doc = mapper.parse(source(b -> b.field("str_field", "hello")));
            b.startObject();
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
    // A plugin type whose handler reports its config complete but throws when normalizing it — used to
    public void testInferencerDoesNotClaimBoolean() throws IOException {
        Map<String, Object> conf = new HashMap<>();
    // =====================================================================
            Map<String, DynamicTemplateTypeHandler> handlers = new HashMap<>();
                if (value < 100) return null;
            b.endObject();
        assertNotNull(doc.dynamicMappingsUpdate());
        Map<String, Object> conf = new HashMap<>();
    private static DynamicTemplate parseWithRegistry(String name, Map<String, Object> conf) {
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
        }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
        assertNull(template.getXContentFieldType());
        DynamicTemplate template = parseWithRegistry("t", conf);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    // parameters and therefore cannot be validated at index-creation time.
            b.endObject();
            b.endObject();
        assertThat(e.getMessage(), containsString("mock_typo"));
            assertEquals(t, template.getXContentFieldType());
        ParsedDocument doc = mapper.parse(source(b -> b.field("small_number", 50)));
                return config;
            b.endArray();
            }
            @Override
        }));
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    public void testInferencerDoesNotClaimString() throws IOException {
        conf.put("match_mapping_type", MOCK_TYPE);
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        ParsedDocument doc = mapper.parse(source(b -> b.field("big_number", CORE_TYPE_SENTINEL)));
import java.util.List;
            if (value == CORE_TYPE_SENTINEL) {
                throw new MapperParsingException("required_param missing for field [" + name + "]");
    }
    // Index creation validation tests
    }
        }));
        @Override
        assertNotNull(doc.dynamicMappingsUpdate());
 * - Registers an inferencer that claims numeric scalars >= 100 as "long"
    public void testWildcardNotStoredAsPlugin() {
 * The OpenSearch Contributors require contributions made to
            b.startObject("named_template");
        assertThat(fieldMapper.typeName(), equalTo("long"));
            b.field("match_mapping_type", "string");
        conf.put("match_mapping_type", MOCK_TYPE);
        conf.put("match", "big_*");
import org.opensearch.plugins.Plugin;
            }
        @Override
    }
    }
import java.util.HashMap;
    static class TemplateOnlyPlugin extends Plugin implements MapperPlugin {
            b.startObject("mock_template");
    }
import org.opensearch.core.xcontent.XContentBuilder;
        Map<String, Object> conf = new HashMap<>();
            b.field("type", "keyword");
            b.startObject("mapping");
            return new MockFieldMapper.Builder(name);
        DynamicTemplate template = parseWithRegistry("t", conf);
            b.endArray();
            b.field("required_param", "present");
        assertThat(fieldMapper.typeName(), equalTo("boolean"));
    }
    public void testBuiltinTypeStillWorksAlongsidePluginType() throws IOException {
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        }));
    // =====================================================================
            return mappers;
            return Collections.singletonList(new MockInferencer());
import org.opensearch.core.xcontent.XContentParser;
        // String — MockInferencer returns null (not a Number), normal path maps as text
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
            assertNull("builtin type " + t + " must not be stored as pluginMatchType", template.getPluginMatchType());
            protected Collection<? extends Plugin> getPlugins() {
    public void testBuiltinMatchNeverReturnsPluginTemplate() throws IOException {
    public void testInferencerReturningCoreTypeIsRejected() throws IOException {
            b.endObject();
        assertThat(fieldMapper.typeName(), equalTo("long"));
            b.endObject();
        return DynamicTemplate.parse(name, conf, registry);
            b.endObject();
        assertNotNull(fieldMapper);
    public void testRegisteredPluginTypeAcceptedAtIndexCreation() throws IOException {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
        conf.put("match_mapping_type", "*");
            b.field("type", "keyword");
    }
        }
            b.field("match_mapping_type", MOCK_TYPE);
    public void testInferencerClaimsLargeNumericScalar() throws IOException {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        conf.put("match_mapping_type", MOCK_TYPE);
    }
        @Override
    private static final String MOCK_INFERRED_TYPE = "mock_inferred_type";
            b.endArray();
import org.opensearch.common.xcontent.json.JsonXContent;
            b.field("required_param", "present");
        }
    public void testMatchesPluginTypeFalseWrongType() {
    private static final String MOCK_THROWING_TYPE = "mock_throwing_type";
    static class RequiresParamTypeParser implements Mapper.TypeParser {
            b.endObject();
        conf.put("match_mapping_type", MOCK_TYPE);
            b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.field("my_field", 200)));
            b.startObject("mock_template");
            b.startObject("mapping");
    }
            b.field("match_mapping_type", MOCK_THROWING_TYPE);
 * and field type inferencers (DynamicFieldTypeInferencer SPI).
            b.field("type", "keyword");
        Map<String, Object> conf = new HashMap<>();
            b.endObject();
            b.startObject("strings_as_keyword");
        @Override
        }));
        // Without plugins, tryPluginInference returns false immediately
            Map<String, Mapper.TypeParser> mappers = new HashMap<>();
    public void testCompletePluginTemplateWithValidConfigAccepted() throws IOException {
            b.endObject();
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {
            b.field("type", "keyword");
        assertThat(e.getMessage(), containsString("long"));
    // Document indexing — inferencer tests
            b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
            return config;
    private static final int CORE_TYPE_SENTINEL = 999;
    /** Plugin that registers only a template type handler — no inferencer */
            }
            b.endObject();
    static class MockMapperPlugin extends Plugin implements MapperPlugin {
 * this file be licensed under the Apache-2.0 license or a
            b.startObject();
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("str_field");
            handlers.put(MOCK_TYPE, new MockTemplateTypeHandler());
            b.startArray("dynamic_templates");
            b.field("match_mapping_type", "unregistered_type");
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {
        // The handler for this type always opens the parser (data-derived config), so even though
            b.startArray("dynamic_templates");
            b.startObject("properties");
        assertThat(fieldMapper.typeName(), equalTo("faketype"));
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("small_number");
            b.endObject();
            try (XContentParser parser = fieldValueParser.get()) {
            b.startObject("throwing_template");
    }
        assertThat(fieldMapper.typeName(), equalTo("text"));
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("big_number");
            b.startObject("mock_template");
        // Builtin string → keyword template still fires when inferencer doesn't claim
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("big_number");
            b.field("match_mapping_type", MOCK_TYPE);
        }));
        // Complete config (handler opens no parser) but required_param is missing → the type parser
        assertThat(e.getMessage(), containsString("required_param missing"));
    // =====================================================================
            b.endArray();
import java.util.Collection;
        }));
 * SPDX-License-Identifier: Apache-2.0
        }
        MapperService mapperService = createMapperService(topMapping(b -> {
            b.endObject();
            handlers.put(MOCK_THROWING_TYPE, new ThrowingTemplateTypeHandler());
 */
        XContentBuilder builder = JsonXContent.contentBuilder();
    }
        XContentBuilder mapping = topMapping(b -> {
            b.startObject("big_number");
    public void testPluginTemplateWithNamePlaceholderSkipsEagerValidation() throws IOException {
        createMapperService(topMapping(b -> {
        assertThat(builder.toString(), containsString("\"match_mapping_type\":\"" + MOCK_TYPE + "\""));
            b.startObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
    public void testBuiltinTemplateFallbackWhenInferencerDoesNotClaim() throws IOException {
            b.endArray();
            throw new IllegalStateException("handler contract violation");
            b.endObject();
            b.startObject("bad_template");
        // 50 < 100 threshold — MockInferencer returns null, normal path maps as long
            b.field("field_name", "{name}");
        assertNull(template.getXContentFieldType());
    }
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    /** Parses a template with the mock plugin registry, so a plugin match_mapping_type is accepted. */
        // throws at index creation instead of silently accepting the broken template.
            node.remove("required_param");
    protected Collection<? extends Plugin> getPlugins() {
    }
        // findTemplate() on RootObjectMapper must skip plugin templates
     * TypeParser for a plugin field type that requires a {@code required_param} and throws a
            b.startObject();
            b.startObject("mapping");
/*
        createMapperService(topMapping(b -> {
        assertFalse(template.matchesPluginType("excluded_field", "excluded_field", MOCK_TYPE));
            b.startObject("mock_template");
        ParsedDocument second = mapperService.documentMapper().parse(source(b -> b.field("big_number", 300)));
        }.createMapperService(topMapping(b -> {
        }
            }
import java.io.IOException;
        }));
            return Collections.singleton(MOCK_TYPE);
            b.field("type", "keyword");
            b.endObject();
    }
            b.endObject();
            b.endObject();
    public void testExplicitMappingBeatsInference() throws IOException {
        assertEquals(XContentFieldType.STRING, template.getXContentFieldType());
    // used to prove core rejects an inferred type no plugin owns.
            b.endObject();
    public void testInferredPluginTemplateWithIncompleteConfigNotValidatedAtIndexCreation() throws IOException {
        @Override
    // =====================================================================
            b.field("type", "keyword");
        conf.put("match_mapping_type", MOCK_TYPE);
            b.startObject("mapping");
        XContentBuilder mapping = topMapping(b -> {
    // verify eager index-creation validation treats a handler contract violation as non-fatal (defer).
    static class MockInferencer implements DynamicFieldTypeInferencer {
        conf.put("match_mapping_type", MOCK_TYPE);
            b.field("match_mapping_type", MOCK_TYPE);
            b.startObject("my_field");
            b.startObject("inferred_template");
        DynamicTemplate template = DynamicTemplate.parse("t", conf);
            b.field("match_mapping_type", MOCK_TYPE);
            b.startArray("dynamic_templates");
            assertNull("findTemplate must not return plugin template for builtin type " + t, root.findTemplate(path, "any_field", t));
            b.startArray("dynamic_templates");
    }
        assertNull(template.getPluginMatchType());
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
            b.endObject();
 * compatible open source license.
    // =====================================================================
    /**
 */
    }
        assertNull(template.getPluginMatchType());
            b.field("match_mapping_type", "mock_typo");
import static org.hamcrest.Matchers.equalTo;
            b.endObject();
            b.endObject();
        assertThat(fieldMapper.typeName(), equalTo("text"));
            b.startObject();
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("bool_field");
    }
            b.field("type", "keyword");
     * {@link MapperParsingException} when it is missing — mirroring how the knn_vector parser rejects
            b.startObject("mock_template");
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) throws IOException {
    public void testPluginMatchTypeStoredOnParse() {
        MapperService noPluginService = new MapperServiceTestCase() {
        DynamicTemplate template = parseWithRegistry("t", conf);
    }
            return true;
        assertThat(e.getMessage(), containsString("No field type matched on [unregistered_type]"));
        Map<String, Object> conf = new HashMap<>();
    public void testFastPathNotExitedWhenOnlyTemplateTypesRegistered() throws IOException {
import org.opensearch.core.xcontent.ToXContent;
        }
    /** Handler for a data-derived type: config is never complete, so validation is deferred. */
            Map<String, Object> config = new HashMap<>();
        assertNotNull(fieldMapper);
            b.startArray("dynamic_templates");
        assertNotNull(doc.dynamicMappingsUpdate());
        // this contract violation as non-fatal (log + defer) rather than failing index creation.
     */
            node.remove("type");
    public void testHandlerThrowingDuringEagerValidationIsNonFatal() throws IOException {
    // A plugin type whose handler always reads the field value, i.e. it depends on data-derived
            b.endObject();
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
            b.endObject();
            b.endArray();
    public void testCompletePluginTemplateWithInvalidConfigThrowsAtIndexCreation() throws IOException {
            b.startObject("mapping");
/**
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("my_field");
            b.startArray("dynamic_templates");
        createMapperService(topMapping(b -> {
            b.endArray();
        assertThat(fieldMapper.typeName(), equalTo("keyword"));
            mappers.put(MOCK_TYPE, new RequiresParamTypeParser());
        assertNotNull(fieldMapper);
    public void testTypoInPluginTypeThrowsWithFullList() throws IOException {
        }));
            b.field("type", MOCK_TYPE);
            b.endObject();
        assertNotNull(fieldMapper);
            b.field("match_mapping_type", MOCK_TYPE);
        createMapperService(topMapping(b -> {
     * Reports its config as complete (so index-creation validation runs eagerly) but throws from
            return Collections.singletonMap(MOCK_TYPE, new MockTemplateTypeHandler());
    }
            b.startArray("dynamic_templates");
        ParsedDocument doc = mapper.parse(source(b -> b.field("my_field", "hello")));
    public void testMatchesPluginTypeFalseNamePatternMismatch() {
        assertTrue(template.matchesPluginType("big_field", "big_field", MOCK_TYPE));
            b.startObject();
     */
            b.startObject();
            Map<String, Object> conf = new HashMap<>();
        @Override
            return true;
            return false;
    }
            b.endObject();
        }.createMapperService(topMapping(b -> {}));
        assertNotNull(doc.dynamicMappingsUpdate());
        // required_param is absent the template must NOT be validated/rejected at index creation.
    /**
    // =====================================================================
            b.endObject();
    public void testMatchesPluginTypeTrue() {
        assertEquals(MOCK_TYPE, template.getPluginMatchType());
    }
        assertTrue(template.matchesPluginType("obj.field", "field", MOCK_TYPE));
            b.field("match_mapping_type", MOCK_TYPE);
                config.put("type", "long");
            b.endObject();
            b.startArray("dynamic_templates");
    }
        registry.put(MOCK_INFERRED_TYPE, new MockInferredTemplateTypeHandler());
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("my_field");
            b.endArray();
    // =====================================================================
            b.endObject();
        assertFalse(template.matchesPluginType("small_field", "small_field", MOCK_TYPE));
 *
            b.field("match_mapping_type", MOCK_INFERRED_TYPE);
            b.startObject("mapping");
            b.startObject("mock_template");
        assertThat(e.getMessage(), containsString("string"));
        conf.put("path_match", "obj.*");
            b.endObject();
    // Eager plugin-template validation at index creation
        @Override
 * Uses a minimal stub plugin:
    public void testPluginTemplateSerializesMatchMappingType() throws Exception {
            b.startObject();
            b.startObject("mapping");
            b.startObject();
        Map<String, DynamicTemplateTypeHandler> registry = new HashMap<>();
            b.endArray();
        }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
            b.startArray("dynamic_templates");
            b.endObject();
        @Override
            b.endArray();
            }
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
        }
            b.endObject();
            if (node.containsKey("required_param") == false) {
            @Override
    static class MockTemplateTypeHandler implements DynamicTemplateTypeHandler {
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
     * Claims numeric scalars >= 100 as the plugin-registered {@link #MOCK_TYPE}, except for the
    public void testMatchesPluginTypeWithPathMatch() {
