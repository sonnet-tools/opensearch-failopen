        assertThat(fieldMapper.typeName(), equalTo("long"));
        NO_TYPE,      // returns a config map without a "type" key — falls through  
            }
                default: {  
    public void testInferredConfigWithoutTypeFallsThrough() throws IOException {
        // Register DUMMY_TYPE so the inferencer's declared supportedTypes() passes startup validation.  
 * compatible open source license.
    }  
                return new MockFieldMapper.Builder(name);  
import java.util.Set;
        @Override
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
        public Map<String, Object> inferFieldType(FieldValueParserSupplier fieldValueParser) throws IOException {
            this.behavior = behavior;
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));  
            return Collections.singletonList(new ConfigurableInferencer(behavior));  
        return Collections.singletonList(new EdgeCasePlugin(behavior));
    // Set by each test before createDocumentMapper() is called; consumed by getPlugins().
        behavior = Behavior.UNKNOWN_TYPE;
 * <p>Each test installs a plugin with a single inferencer of a fixed behavior — no shared mutable
                case NO_TYPE: {  
        assertNotNull(fieldMapper);  
    }  
            });
        @Override
                    config.put("type", "no_such_registered_type");
                if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) return null;
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));
        }  
 * Exercises the error/edge branches of the inferencer path in {@code DocumentParser.tryPluginInference}:
    /** A config with no "type" key is ignored; the field falls through to normal inference. */  
                    Map<String, Object> config = new HashMap<>();
    @Override
import java.util.Collection;  
        assertThat(fieldMapper.typeName(), equalTo("long"));  
    }
        assertNotNull(doc.dynamicMappingsUpdate());
 * this file be licensed under the Apache-2.0 license or a
    /** A config whose "type" has no registered TypeParser is ignored; the field falls through. */
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");
                    throw new RuntimeException("boom from inferencer");
    }
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");  
        assertNotNull(fieldMapper);
        public Set<String> supportedTypes() {  
 *
import java.util.List;  
                }
import org.opensearch.plugins.MapperPlugin;
    private static class ConfigurableInferencer implements DynamicFieldTypeInferencer {
        ParsedDocument doc = mapper.parse(source(b -> b.field("n", 5)));
                    return config;  
import org.opensearch.plugins.Plugin;  
import java.io.IOException;
}  
import org.opensearch.core.xcontent.XContentParser;
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));
import static org.hamcrest.Matchers.equalTo;
        @Override
import java.util.Map;
        }  
 */
        assertThat(fieldMapper.typeName(), equalTo("long"));
    /** A throwing inferencer must not break parsing; the field falls through to normal inference (long). */
            return Collections.singletonMap(DUMMY_TYPE, (name, node, parserContext) -> {
    public void testThrowingInferencerIsCaughtAndFieldFallsThrough() throws IOException {
            }
        private final Behavior behavior;
 */  
    /** Claims numeric scalars, then behaves per its fixed {@link Behavior}. Immutable, no shared state. */  
        private final Behavior behavior;
                case THROW:
                node.remove("type");
    private Behavior behavior;  
        }
 * {@code type}, or an unknown {@code type}, falls through to the normal path instead of failing.  
public class PluginInferencerEdgeCaseTests extends MapperServiceTestCase {
                case UNKNOWN_TYPE:
    private static class EdgeCasePlugin extends Plugin implements MapperPlugin {  
    }
        // The edge behaviors never successfully produce DUMMY_TYPE, so this parser is never exercised.
        public Map<String, Mapper.TypeParser> getMappers() {  
 *
                    Map<String, Object> config = new HashMap<>();
    enum Behavior {
package org.opensearch.index.mapper;
 * The OpenSearch Contributors require contributions made to  
    public void testInferredUnknownTypeFallsThrough() throws IOException {  
        behavior = Behavior.NO_TYPE;
    private static final String DUMMY_TYPE = "dummy_type";
        THROW,        // inferencer throws — must be caught, field falls through to normal path
 * a buggy inferencer that throws is caught and skipped; an inferencer that returns a config with no
        }
import java.util.Collections;
/**  
            return Collections.singleton(DUMMY_TYPE);
    protected Collection<? extends Plugin> getPlugins() {  
        @Override
        assertNotNull(fieldMapper);
                    return config;  
    }
        behavior = Behavior.THROW;  
        EdgeCasePlugin(Behavior behavior) {  
        UNKNOWN_TYPE  // returns a config with a type no TypeParser is registered for — falls through
        ConfigurableInferencer(Behavior behavior) {
        assertNotNull(doc.dynamicMappingsUpdate());  
                    config.put("some_param", "x"); // deliberately no "type"
/*  
    }
        public List<DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
            try (XContentParser parser = fieldValueParser.get()) {  
            switch (behavior) {  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {}));  
 * state — so the tests are independent and safe under any execution order.  
        assertNotNull(doc.dynamicMappingsUpdate());
 * SPDX-License-Identifier: Apache-2.0
            this.behavior = behavior;
import java.util.HashMap;
        Mapper fieldMapper = doc.dynamicMappingsUpdate().root().getMapper("n");
        }
        }
