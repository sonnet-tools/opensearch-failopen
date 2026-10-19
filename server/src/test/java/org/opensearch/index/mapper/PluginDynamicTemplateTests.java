            b.field("match_mapping_type", MOCK_TYPE);
            b.startArray("dynamic_templates");  
import java.util.Map;
        }));
        assertThat(fieldMapper.typeName(), equalTo("keyword"));  
        @Override
        assertThat(fieldMapper.typeName(), equalTo("faketype"));  
        conf.put("match_mapping_type", MOCK_TYPE);
    public void testInferredPluginTemplateWithIncompleteConfigNotValidatedAtIndexCreation() throws IOException {  
            b.field("type", "keyword");  
    }
            b.startObject("mock_template");  
            b.field("type", "keyword");
import org.opensearch.plugins.MapperPlugin;  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("bool_field");
        }));
            b.field("match_mapping_type", MOCK_TYPE);
    }  
            Map<String, DynamicTemplateTypeHandler> handlers = new HashMap<>();
        assertThat(e.getMessage(), containsString(MOCK_TYPE));  
            b.endObject();
        assertNotNull(doc.dynamicMappingsUpdate());  
            b.endArray();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.endObject();
}  
            assertEquals(t, template.getXContentFieldType());  
            assertNull("builtin type " + t + " must not be stored as pluginMatchType", template.getPluginMatchType());
            b.endObject();
            b.endObject();
    public void testPluginTemplateSerializesMatchMappingType() throws Exception {
        assertThat(fieldMapper.typeName(), equalTo("text"));  
    static class TemplateOnlyPlugin extends Plugin implements MapperPlugin {
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    }
    }
import static org.hamcrest.Matchers.containsString;
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("big_number");  
        conf.put("match", "big_*");  
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("my_field");
            b.startArray("dynamic_templates");
        assertThat(fieldMapper.typeName(), equalTo("text"));
        DynamicTemplate template = parseWithRegistry("t", conf);  
            b.startArray("dynamic_templates");
            b.endObject();
    }  
 * Tests for plugin-extensible dynamic template types (match_mapping_type SPI)  
        DynamicTemplate template = parseWithRegistry("t", conf);  
        }
    public void testInferencerDoesNotClaimBoolean() throws IOException {
    // Document indexing — inferencer tests
            b.field("match_mapping_type", MOCK_TYPE);  
    public void testMatchesPluginTypeWithUnmatch() {
            if (node.containsKey("required_param") == false) {
        registry.put(MOCK_THROWING_TYPE, new ThrowingTemplateTypeHandler());
        // Builtin string → keyword template still fires when inferencer doesn't claim
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
import java.util.List;
            b.endObject();
            b.endObject();
            b.startArray("dynamic_templates");  
            b.endArray();  
        createMapperService(topMapping(b -> {
            b.field("type", "keyword");
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("small_number");
        RootObjectMapper root = mapperService.documentMapper().mapping().root();
     * not register — so a test can assert core rejects an unregistered inferred type.
        @Override
    public void testExplicitMappingBeatsInference() throws IOException {
            b.startObject("mock_template");
            conf.put("mapping", Collections.singletonMap("type", "keyword"));  
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    public void testAllBuiltinTypesNotStoredAsPlugin() {
        conf.put("match_mapping_type", MOCK_TYPE);  
        MapperService mapperService = createMapperService(topMapping(b -> {  
        Map<String, DynamicTemplateTypeHandler> registry = new HashMap<>();
        // Simulate mapping update applied — second doc should not re-infer
        DynamicTemplate template = parseWithRegistry("t", conf);
        assertNotNull(doc.dynamicMappingsUpdate());  
    public void testBuiltinMatchTypeNotStoredAsPlugin() {
        }));  
        ParsedDocument doc = noPluginService.documentMapper().parse(source(b -> b.field("my_field", "hello")));
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
            return config;
    static class MockMapperPlugin extends Plugin implements MapperPlugin {
    // parameters and therefore cannot be validated at index-creation time.  
        }));
            handlers.put(MOCK_TYPE, new MockTemplateTypeHandler());
        createMapperService(topMapping(b -> {
            b.startObject("mapping");  
            b.field("match_mapping_type", MOCK_INFERRED_TYPE);
        MapperService mapperService = createMapperService(topMapping(b -> {
            handlers.put(MOCK_INFERRED_TYPE, new MockInferredTemplateTypeHandler());  
            b.endObject();  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
    }  
            Map<String, Mapper.TypeParser> mappers = new HashMap<>();
        ParsedDocument doc = mapper.parse(source(b -> b.field("small_number", 50)));
    }
        }));  
 * and field type inferencers (DynamicFieldTypeInferencer SPI).
        DynamicTemplate template = parseWithRegistry("t", conf);  
            b.startArray("dynamic_templates");  
        DynamicTemplate template = parseWithRegistry("t", conf);
        assertTrue(template.matchesPluginType("big_field", "big_field", MOCK_TYPE));
        assertThat(e.getMessage(), containsString("long"));  
        assertNotNull(doc.dynamicMappingsUpdate());  
    }
            b.startObject("throwing_template");
            b.field("match_mapping_type", MOCK_TYPE);  
            b.startObject("big_number");
            b.field("type", MOCK_INFERRED_TYPE);  
            b.endArray();
            b.startObject("properties");
            return true;
        // throws at index creation instead of silently accepting the broken template.
    public void testUnregisteredPluginTypeThrowsAtIndexCreation() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("bool_field", true)));  
 *   (scalars are safe — Long mapper handles them without parsesArrayValue issues)  
    public void testNoPluginsNormalPathRuns() throws IOException {
            b.endArray();  
        ParsedDocument first = mapper.parse(source(b -> b.field("big_number", 200)));
        assertNotNull(fieldMapper);
            b.endArray();  
     */  
            }  
            b.field("field_name", "{name}");
    public void testTypoInPluginTypeThrowsWithFullList() throws IOException {  
        DynamicTemplate template = DynamicTemplate.parse("t", conf);
    public void testBuiltinTypeStillWorksAlongsidePluginType() throws IOException {  
            mappers.put(MOCK_TYPE, new RequiresParamTypeParser());
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
        Map<String, Object> conf = new HashMap<>();
        // The handler reports its config complete but throws from adjustMappingConfig. Core must treat  
        }
            b.endObject();
    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("my_field", 200)));
            b.startObject();  
     * Using scalars (not arrays) avoids needing a parsesArrayValue mapper in core tests.
            try (XContentParser parser = fieldValueParser.get()) {  
        }.createMapperService(topMapping(b -> {
import java.util.Set;  
        for (XContentFieldType t : XContentFieldType.values()) {  
        assertNull(template.getPluginMatchType());
        }  
        assertThat(e.getMessage(), containsString("required_param missing"));  
    public void testMatchesPluginTypeFalseWrongType() {
    // A plugin type whose handler always reads the field value, i.e. it depends on data-derived
import org.opensearch.core.xcontent.XContentBuilder;  
     * {@link #CORE_TYPE_SENTINEL} value, which it claims as the core type "long" — a type it does  
    /** Plugin that registers only a template type handler — no inferencer */  
            b.endObject();
        }
            b.field("type", MOCK_THROWING_TYPE);
    }  
 * compatible open source license.
    /** Parses a template with the mock plugin registry, so a plugin match_mapping_type is accepted. */
        // First doc triggers inference
 * Uses a minimal stub plugin:  
            return false;
            b.endArray();
        }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
        assertThat(e.getMessage(), containsString(MOCK_TYPE));
            return Collections.singletonList(new MockInferencer());
    // =====================================================================
        conf.put("match_mapping_type", MOCK_TYPE);
    }  
            b.startObject("mock_template");
        assertTrue(template.matchesPluginType("obj.field", "field", MOCK_TYPE));  
        assertNotNull(doc.dynamicMappingsUpdate());
    public void testCompletePluginTemplateWithInvalidConfigThrowsAtIndexCreation() throws IOException {
        assertNull("already mapped field must not re-trigger inference", second.dynamicMappingsUpdate());
            handlers.put(MOCK_THROWING_TYPE, new ThrowingTemplateTypeHandler());
     * Reports its config as complete (so index-creation validation runs eagerly) but throws from  
        assertNotNull(fieldMapper);
            b.endObject();
            b.startObject();
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {  
        createMapperService(topMapping(b -> {
    }
            b.startObject("mapping");
        ParsedDocument doc = mapper.parse(source(b -> b.field("my_field", "hello")));
        assertNotNull(mapperService.documentMapper());
            b.endObject();
            b.startObject();
    // DynamicTemplate unit tests
 * - Registers "mock_type" as a plugin match_mapping_type
import java.util.Collections;
            }
    }  
            b.endObject();
    // Eager plugin-template validation at index creation  
/**
    static class RequiresParamTypeParser implements Mapper.TypeParser {
                return Collections.emptyList();
        assertNotNull(doc.dynamicMappingsUpdate());  
        }
     * a mapping with no {@code dimension}. Used to prove eager index-creation-time validation throws.
            b.field("type", "keyword");
            b.startObject("mapping");
            b.endObject();
        conf.put("mapping", Collections.singletonMap("type", "keyword"));  
        assertThat(fieldMapper.typeName(), equalTo("long"));  
            b.startArray("dynamic_templates");  
            return true;
        }));  
    public void testInferencerReturningCoreTypeIsRejected() throws IOException {  
            b.endObject();
            }
        conf.put("match_mapping_type", MOCK_TYPE);
        }  
            b.endObject();
    }
            b.startObject("properties");
    private static final String MOCK_THROWING_TYPE = "mock_throwing_type";
    // =====================================================================
        }
    }  
            Map<String, Object> config = new HashMap<>();  
     * adjustMappingConfig — a handler-contract violation. Core must treat this as non-fatal and defer.
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
    // =====================================================================
    /** Handler for a data-derived type: config is never complete, so validation is deferred. */
        registry.put(MOCK_TYPE, new MockTemplateTypeHandler());
        // The inferencer returns the core type "long" (which it does not register) for the sentinel
        ContentPath path = new ContentPath();
    // verify eager index-creation validation treats a handler contract violation as non-fatal (defer).  
    }
    }  
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        });
            DynamicTemplate template = DynamicTemplate.parse("t_" + t, conf);
                config.put("type", "long");
        DynamicTemplate template = parseWithRegistry("t", conf);  
        }
            b.startObject("named_template");
    @Override
        Map<String, Object> conf = new HashMap<>();
        conf.put("match_mapping_type", MOCK_TYPE);  
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        @Override
     */
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            b.field("type", "keyword");
    }
            b.endArray();  
        assertFalse(template.matchesPluginType("excluded_field", "excluded_field", MOCK_TYPE));
    public void testMatchesPluginTypeFalseNamePatternMismatch() {  
            b.field("type", "long");  
        }));
            b.startObject("bad_template");
        return Collections.singletonList(new MockMapperPlugin());
        // Explicit keyword mapping — inference must not fire even for value >= 100
        assertEquals(XContentFieldType.STRING, template.getXContentFieldType());
        public Set<String> supportedTypes() {  
        // tryPluginInference must NOT fast-exit — template types alone are enough to proceed.
            @Override
    public void testFastPathNotExitedWhenOnlyTemplateTypesRegistered() throws IOException {
    public void testInferencerDoesNotClaimString() throws IOException {  
        Map<String, Object> conf = new HashMap<>();  
        @Override
    }
        });  
        }  
            b.field("match_mapping_type", MOCK_TYPE);
                throw new MapperParsingException("required_param missing for field [" + name + "]");
        XContentBuilder builder = JsonXContent.contentBuilder();
    // A plugin type whose handler reports its config complete but throws when normalizing it — used to
import java.util.Collection;
        ParsedDocument doc = mapper.parse(source(b -> b.field("big_number", 200)));
package org.opensearch.index.mapper;
            b.endObject();  
        // Plugin registers template type but no inferencer.  
        Map<String, Object> conf = new HashMap<>();
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {}  
            b.startObject("mock_template");
            b.endObject();
    private static DynamicTemplate parseWithRegistry(String name, Map<String, Object> conf) {  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> conf = new HashMap<>();  
        @Override
        conf.put("match_mapping_type", "string");
     * {@link MapperParsingException} when it is missing — mirroring how the knn_vector parser rejects
        // value. Core must ignore the claim and let the normal dynamic-mapping path map it as long.
            b.endObject();  
                return config;  
        assertThat(e.getMessage(), containsString("No field type matched on [unregistered_type]"));  
    /** No-op handler — template config used as-is. Reports its config as always complete. */  
            assertNull("findTemplate must not return plugin template for builtin type " + t, root.findTemplate(path, "any_field", t));
import org.opensearch.core.xcontent.ToXContent;
            b.startObject("mapping");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
        Map<String, Object> conf = new HashMap<>();
    // =====================================================================  
    // A numeric value the inferencer maps to the core type "long" (a type it does not register),  
            b.startArray("dynamic_templates");
                if (value < 100) return null;
            return handlers;
            config.put("type", MOCK_TYPE);
            b.endObject();
            @Override  
            b.endObject();
            b.startObject("mapping");  
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {  
        assertThat(e.getMessage(), containsString("string"));
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("my_field");
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("str_field");
            try (XContentParser parser = fieldValueParser.get()) {
        assertTrue(template.matchesPluginType("big_field", "big_field", MOCK_TYPE));
 */
            b.endObject();
        createMapperService(topMapping(b -> {  
        assertNotNull(fieldMapper);
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
            return Collections.singleton(MOCK_TYPE);
    public void testBuiltinTemplateFallbackWhenInferencerDoesNotClaim() throws IOException {  
        }));
    }  
        Map<String, Object> conf = new HashMap<>();
            b.startArray("dynamic_templates");
        @Override
            b.endObject();  
            b.startObject("mock_template");
    static class MockInferencer implements DynamicFieldTypeInferencer {
            b.startArray("dynamic_templates");
        });
        assertFalse(template.matchesPluginType("other.field", "field", MOCK_TYPE));
    }  
        assertEquals(MOCK_TYPE, template.getPluginMatchType());
        assertThat(e.getMessage(), containsString("mock_typo"));
            b.endObject();
    static class MockInferredTemplateTypeHandler implements DynamicTemplateTypeHandler {  
            b.endObject();  
            b.startArray("dynamic_templates");
            b.endObject();
            b.startObject("inferred_template");  
            b.endObject();
        assertFalse(template.matchesPluginType("field", "field", "other_type"));  
            b.endArray();
            b.endObject();
        XContentBuilder mapping = topMapping(b -> {
        }));  
        }));  
            b.field("type", "keyword");
            }  
                value = parser.doubleValue();  
     * Claims numeric scalars >= 100 as the plugin-registered {@link #MOCK_TYPE}, except for the
 * - Registers an inferencer that claims numeric scalars >= 100 as "long"
        assertNotNull(fieldMapper);
            b.startObject("mapping");  
        }
            b.startObject();  
        assertNull(template.getXContentFieldType());  
 *
            b.endArray();
        // this contract violation as non-fatal (log + defer) rather than failing index creation.
        conf.put("match_mapping_type", MOCK_TYPE);  
            node.remove("type");
        }
        ParsedDocument second = mapperService.documentMapper().parse(source(b -> b.field("big_number", 300)));
        }));
        DynamicTemplate template = parseWithRegistry("t", conf);
            b.startArray("dynamic_templates");
    }
            b.field("match_mapping_type", "mock_typo");
            b.endObject();
            protected Collection<? extends Plugin> getPlugins() {
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {
        conf.put("path_match", "obj.*");  
            b.field("type", MOCK_TYPE);
    private static final String MOCK_INFERRED_TYPE = "mock_inferred_type";
            b.startObject("mapping");
public class PluginDynamicTemplateTests extends MapperServiceTestCase {
    public void testInferencerDoesNotClaimSmallNumericScalar() throws IOException {
            b.startObject();
            b.endObject();
    public void testMatchesPluginTypeWithPathMatch() {  
 */  
        ParsedDocument doc = mapper.parse(source(b -> b.field("big_number", CORE_TYPE_SENTINEL)));
            b.field("required_param", "present");  
            throw new IllegalStateException("handler contract violation");  
            b.endArray();
        createMapperService(topMapping(b -> {
        assertNotNull(doc.dynamicMappingsUpdate());
            b.startObject();
            b.startObject("mapping");  
        assertNotNull(first.dynamicMappingsUpdate());  
        XContentBuilder mapping = topMapping(b -> {
            conf.put("match_mapping_type", t.toString());
import org.opensearch.plugins.Plugin;
        // 50 < 100 threshold — MockInferencer returns null, normal path maps as long
        assertThat(builder.toString(), containsString("\"match_mapping_type\":\"" + MOCK_TYPE + "\""));  
            b.endArray();
    }  
    static class MockTemplateTypeHandler implements DynamicTemplateTypeHandler {
            b.endObject();  
            b.startObject("mapping");
        @Override  
        registry.put(MOCK_INFERRED_TYPE, new MockInferredTemplateTypeHandler());  
                parser.currentToken();
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
    /**
        }
            b.endObject();  
        // Handler opens no parser (complete config) and the type parser is satisfied → index creation succeeds.
        // Complete config (handler opens no parser) but required_param is missing → the type parser  
            b.endObject();
            b.field("type", MOCK_TYPE);
    protected Collection<? extends Plugin> getPlugins() {  
            Map<String, Object> conf = new HashMap<>();
    public void testPluginTemplateWithNamePlaceholderSkipsEagerValidation() throws IOException {
            if (value == CORE_TYPE_SENTINEL) {
        // Without plugins, tryPluginInference returns false immediately  
            b.field("required_param", "present");  
    // =====================================================================
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {  
            b.field("type", "keyword");  
    public void testBuiltinMatchNeverReturnsPluginTemplate() throws IOException {
            b.field("match_mapping_type", "unregistered_type");  
    public void testRegisteredPluginTypeAcceptedAtIndexCreation() throws IOException {  
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
            b.endObject();
            return mappers;
        assertNull(template.getPluginMatchType());
        DynamicTemplate template = DynamicTemplate.parse("t", conf);  
        ParsedDocument doc = mapper.parse(source(b -> b.field("str_field", "hello")));  
        public Map<String, Mapper.TypeParser> getMappers() {  
            b.startObject("mock_template");
        conf.put("match_mapping_type", "*");
        @Override
            b.startObject("string_template");
    }
            }
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {
        // The handler for this type always opens the parser (data-derived config), so even though
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
            b.startObject("typo_template");
        // {name} can't be resolved up front, so validation is skipped even though required_param is missing.  
 *
    // =====================================================================  
            b.startObject();  
        assertNotNull(fieldMapper);  
            b.startObject();  
            b.endObject();  
    }
 * this file be licensed under the Apache-2.0 license or a
            b.startObject("mapping");
        assertNotNull(fieldMapper);  
        assertNotNull(doc.dynamicMappingsUpdate());
        assertFalse(template.matchesPluginType("small_field", "small_field", MOCK_TYPE));  
            b.field("type", MOCK_TYPE);
    /**
        // 200 >= 100 threshold — MockInferencer claims it as the plugin-registered MOCK_TYPE
            b.startObject();
            b.field("match_mapping_type", "string");
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(mapping));
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {  
            double value;  
            b.endObject();  
        assertThat(fieldMapper.typeName(), equalTo("boolean"));
     */  
        conf.put("unmatch", "excluded_*");
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) throws IOException {
            b.endObject();
        assertThat(fieldMapper.typeName(), equalTo("long"));
    // =====================================================================  
            b.startObject("mapping");
        Map<String, Object> conf = new HashMap<>();
import static org.hamcrest.Matchers.equalTo;  
    }  
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {  
            return new MockFieldMapper.Builder(name);  
    private static final String MOCK_TYPE = "mock_type";
        // required_param is absent the template must NOT be validated/rejected at index creation.
    }
    }  
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {  
                return Collections.singletonList(new TemplateOnlyPlugin());
            b.field("match_mapping_type", MOCK_TYPE);
    private static final int CORE_TYPE_SENTINEL = 999;
    }
            b.endObject();  
            b.startObject();  
            b.startObject("mapping");  
import java.util.HashMap;  
import org.opensearch.common.xcontent.json.JsonXContent;
            b.endObject();  
    public void testAlreadyInferredFieldSkipsInferenceOnSecondDoc() throws IOException {
    }  
        assertNotNull(fieldMapper);
        @Override
    }
        MapperService mapperService = new MapperServiceTestCase() {
            b.field("match_mapping_type", MOCK_THROWING_TYPE);  
import java.io.IOException;  
    }  
    public void testCompletePluginTemplateWithValidConfigAccepted() throws IOException {  
            b.field("match_mapping_type", "string");  
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);
            mappers.put(MOCK_INFERRED_TYPE, new RequiresParamTypeParser());  
        MapperService noPluginService = new MapperServiceTestCase() {
        createMapperService(topMapping(b -> {
            }
        }.createMapperService(topMapping(b -> {}));  
 * SPDX-License-Identifier: Apache-2.0
            b.field("type", "keyword");
        XContentBuilder mapping = topMapping(b -> {
            b.endObject();  
    // =====================================================================
        @Override
    static class ThrowingTemplateTypeHandler implements DynamicTemplateTypeHandler {  
    // used to prove core rejects an inferred type no plugin owns.
        @Override
            b.startArray("dynamic_templates");  
    /**
        assertNull(template.getXContentFieldType());
            b.endArray();
        }
    }
            b.endObject();  
        for (XContentFieldType t : XContentFieldType.values()) {  
        return DynamicTemplate.parse(name, conf, registry);
        conf.put("mapping", Collections.singletonMap("type", "keyword"));
            config.put("required_param", "present");  
            b.field("type", "keyword");
    public void testInferencerClaimsLargeNumericScalar() throws IOException {
            b.endObject();
    // Index creation validation tests
        // findTemplate() on RootObjectMapper must skip plugin templates  
     * TypeParser for a plugin field type that requires a {@code required_param} and throws a  
            mappers.put(MOCK_THROWING_TYPE, new RequiresParamTypeParser());
            b.startObject("mapping");  
            return Collections.singletonMap(MOCK_TYPE, new MockTemplateTypeHandler());
        conf.put("match_mapping_type", MOCK_TYPE);
            b.startObject();
        // String — MockInferencer returns null (not a Number), normal path maps as text
/*  
            protected Collection<? extends Plugin> getPlugins() {  
    public void testPluginMatchTypeStoredOnParse() {
    }  
        @Override
            b.startObject();
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("big_number");
import org.opensearch.core.xcontent.XContentParser;
    }
            node.remove("required_param");
        assertNull("explicit mapping must beat inferencer", doc.dynamicMappingsUpdate());
            b.field("match_mapping_type", MOCK_TYPE);
            b.startObject();  
    public void testHandlerThrowingDuringEagerValidationIsNonFatal() throws IOException {
            b.startObject("strings_as_keyword");
    }
    public void testWildcardNotStoredAsPlugin() {  
            b.endObject();
        Map<String, Object> conf = new HashMap<>();  
    }  
        @Override
            b.startObject("my_field");
        conf.put("match", "big_*");
    public void testMatchesPluginTypeTrue() {
