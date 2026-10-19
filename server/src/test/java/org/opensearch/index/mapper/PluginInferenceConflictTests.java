    }
import static org.hamcrest.Matchers.containsString;
    public void testTwoInferencersClaimSameFieldThrows() throws IOException {
        public Map<String, Mapper.TypeParser> getMappers() {  
        @Override
        assertNotNull(doc.dynamicMappingsUpdate());
 * Tests that core fails loudly when more than one plugin mechanism claims the same unmapped field —
 * this file be licensed under the Apache-2.0 license or a
        @Override
        return Collections.singletonList(new ConflictingPlugin());
    private static final String TYPE_B = "type_b";
            b.field("match_mapping_type", TYPE_A);
/*  
            b.field("match_mapping_type", TYPE_A);
        assertThat(e.getMessage(), containsString("matched more than one dynamic template plugin type"));
    }  
            b.field("match", "v_*");  
            b.startObject("only_a");  
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
    }  
        }
            b.startObject("mapping").field("type", TYPE_A).endObject();
        }  
     * both match any field — so a single unmapped field is claimed by two mechanisms of each kind.
    static class NoopHandler implements DynamicTemplateTypeHandler {
 */  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
            b.startObject("mapping").field("type", TYPE_B).endObject();
            b.endObject();
            return Arrays.asList(new AlwaysClaimsNumberInferencer(TYPE_A), new AlwaysClaimsNumberInferencer(TYPE_B));  
            b.endObject();
        @Override
        // "only_field" is a string, so the numeric inferencers don't fire; only template t_a matches.
        // Sanity: with only ONE plugin template matching (a name pattern no other template shares),
            b.field("match", "only_*");
    public void testTwoPluginTemplatesMatchSameFieldThrows() throws IOException {
import java.util.Arrays;  
        @Override
        }  
    /** An inferencer that claims every numeric scalar as {@code claimedType}. */  
            mappers.put(TYPE_A, new MockTypeParser());
import org.opensearch.core.xcontent.XContentParser;
            handlers.put(TYPE_B, new NoopHandler());
            b.startObject();  
    public void testSingleTemplateMatchDoesNotThrow() throws IOException {  
        assertThat(e.getMessage(), containsString("v_x"));  
            config.put("type", claimedType);
        public Map<String, DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
        @Override
        public void adjustMappingConfig(Map<String, Object> mappingConfig, FieldValueParserSupplier fieldValueParser) {}  
        assertNotNull("single-matching template must map the field, not throw", doc.dynamicMappingsUpdate().root().getMapper("only_field"));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("n", 5))));  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("v_x", 5))));
    }  
            }
import java.util.Collection;
 * compatible open source license.
    static class ConflictingPlugin extends Plugin implements MapperPlugin {  
            return handlers;
        private final String claimedType;
            b.startObject();
        @Override  
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
        @Override
 * order silently pick a winner.
import java.io.IOException;
import org.opensearch.plugins.MapperPlugin;
            b.startObject("t_a");
 * SPDX-License-Identifier: Apache-2.0
            return mappers;
public class PluginInferenceConflictTests extends MapperServiceTestCase {
    }
        }
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) {
    static class AlwaysClaimsNumberInferencer implements DynamicFieldTypeInferencer {
    private static final String TYPE_A = "type_a";  
            b.field("match", "v_*");
     * Registers two inferencers that both claim numeric scalars, and two plugin template types that  
}
        assertThat(e.getMessage(), containsString("n"));
import java.util.List;
import java.util.HashMap;  
import java.util.Map;
        @Override
            this.claimedType = claimedType;
        }));
            Map<String, Mapper.TypeParser> mappers = new HashMap<>();
            Map<String, Object> config = new HashMap<>();  
            node.remove("type");  
package org.opensearch.index.mapper;
        public boolean isConfigComplete(Map<String, Object> mappingConfig) {  
        assertThat(e.getMessage(), containsString("claimed by more than one dynamic field type inferencer"));
            b.endArray();
    @Override
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            Map<String, DynamicTemplateTypeHandler> handlers = new HashMap<>();
 * two inferencers both claiming, or two plugin template types both matching. Per OpenSearch triage  
     */
        // there is no ambiguity — the field is claimed and mapped without a conflict exception.
            b.startObject();
            b.endArray();  
            mappers.put(TYPE_B, new MockTypeParser());  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
import org.opensearch.plugins.Plugin;  
        }));  
    }  
            b.endObject();  
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;  
 *
            b.endObject();
    /** A no-op template handler whose config is always complete (validated eagerly, no field read). */  
    /**
    static class MockTypeParser implements Mapper.TypeParser {  
            b.startObject("t_b");
            try (XContentParser parser = fieldValueParser.get()) {  
/**
            return true;
    /** Builds a MockFieldMapper for a mock plugin type (no required params). */
        }
            b.startArray("dynamic_templates");
 */  
            return config;
            b.endObject();  
    protected Collection<? extends Plugin> getPlugins() {  
    }
            b.endObject();
import java.util.Collections;
        }  
            return new MockFieldMapper.Builder(name);
            b.field("match_mapping_type", TYPE_B);  
 * (Froh): loop through all claimants and throw on ambiguity rather than letting registration/load
            return Collections.singleton(claimedType);
            b.startObject("mapping").field("type", TYPE_A).endObject();  
        // Two templates, each targeting a different plugin type but the same field name pattern.  
        AlwaysClaimsNumberInferencer(String claimedType) {
            handlers.put(TYPE_A, new NoopHandler());  
        }
        ParsedDocument doc = mapper.parse(source(b -> b.field("only_field", "text-value")));  
        }
            b.startArray("dynamic_templates");
    }  
        public Set<String> supportedTypes() {  
