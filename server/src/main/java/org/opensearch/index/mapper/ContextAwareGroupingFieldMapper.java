     * generation.
            if (fields.size() > 1) {  
                .collect(Collectors.toSet());  
import org.opensearch.script.Script;
    private final ContextAwareGroupingScript compiledScript;  
         * Creates a new Builder with a field name
    /**
        @Override
        public ParametrizedFieldMapper build(BuilderContext context) {
    public void canDeriveSource() {}
     *
            throw new IllegalStateException("ContextAwareGroupingFieldMapper needs objbuilder to validate node");  
     * @param simpleName
        private final Parameter<List<String>> fields = new Parameter<>("fields", true, Collections::emptyList, (n, c, o) -> {
    @Override
         *
            }
    private static class TypeParser implements Mapper.TypeParser {
    }
    }  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            this.script.setValue(script);  
            }  
         */
    }
import java.util.Map;  
     */
        ContextAwareGroupingFieldMapper.Builder builder  
        protected Builder(String name, List<String> fields, Script script, ContextAwareGroupingScript contextAwareGroupingScript) {  
        @Override  
                throw new MapperParsingException("Currently [fields] in context_aware_grouping does not support multiple values");
        private static ContextAwareGroupingFieldMapper toType(FieldMapper in) {
            return fields;
            }
            this.compiledScript = contextAwareGroupingScript;
}  
import java.util.Set;
                    "[fields] should be from properties: [" + propertyFieldNames + "] but found [" + builder.fields.getValue() + "]"
                this.compiledScript
        throw new MapperParsingException("context_aware_grouping cannot be ingested in the document");
import org.opensearch.script.ContextAwareGroupingScript;  
 */
import static org.opensearch.script.Script.DEFAULT_SCRIPT_LANG;
        }
    @Override  
        protected List<Parameter<?>> getParameters() {
            super(name);
            throws MapperParsingException {
                builder.compiledScript = factory.newInstance();  
import java.util.List;
     */
 * The OpenSearch Contributors require contributions made to  
     */  
            Builder builder = new Builder(name);  
                throw new MapperParsingException("Expected [fields] to be a list of strings but got [" + o + "]");
import org.apache.lucene.index.LeafReader;
     * Builder for this field mapper
            Script s = Script.parse(o);  
    /**
    public static final String CONTENT_TYPE = "context_aware_grouping";
import java.io.IOException;  
        return (ContextAwareGroupingFieldType) mappedFieldType;  
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context) throws MapperParsingException {
     * @param mappedFieldType  
        ContextAwareGroupingFieldType mappedFieldType,
                this.fields.getValue(),  
    @Override
     *
            if (builder.fields.isConfigured() == false) {  
/*  
            return (ContextAwareGroupingFieldMapper) in;
         * @param name  
    public Builder getMergeBuilder() {  
        }, m -> toType(m).script).acceptsNull();
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {}
    /**  
                throw new MapperParsingException(  
/**  
        protected Builder(String name) {
            }
            if (s != null) {  
            if (!s.getLang().equals(DEFAULT_SCRIPT_LANG)) {
        @Override
    public static final Mapper.TypeParser PARSER = new TypeParser();  
        /**  
    public ContextAwareGroupingFieldType fieldType() {
        }
    private final Script script;
            return List.of(fields, script);  
    @Override  
    /**  
        }
    protected ContextAwareGroupingFieldMapper(  
            }
        }  
                throw new MapperParsingException("Expected [fields] in context_aware_grouping to have one value");  
                ContextAwareGroupingScript.Factory factory = context.scriptService()
            this.fields.setValue(fields);
    }
        }  
    protected String contentType() {
    @Override
            builder.parse(name, context, node);
    @Override  
     */
        @Override  
 * @opensearch.internal  
                throw new MapperParsingException("context_aware_grouping only supports painless script");
 * A field mapper to specify context aware grouping mapper creation
            if (o == null) {
        private final Parameter<Script> script = new Parameter<>("script", true, () -> null, (n, c, o) -> {
 * this file be licensed under the Apache-2.0 license or a
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context, ObjectMapper.Builder objBuilder)
     * Creates a new ParametrizedFieldMapper  
        return new Builder(CONTENT_TYPE, this.fields, this.script, this.compiledScript);
    protected void parseCreateField(ParseContext context) throws IOException {
     * @opensearch.internal  
                throw new MapperParsingException("[fields] in context_aware_grouping is required");
            Set<String> propertyFieldNames = (Set<String>) objBuilder.mappersBuilders.stream()
    public static class Builder extends ParametrizedFieldMapper.Builder {
    }  
 *
                );
        private ContextAwareGroupingScript compiledScript;
    }
        }, m -> toType(m).fields);
    ) {
     * Context Aware Segment field is not a part of an ingested document, so omitting it from Context Aware Segment
        this.script = builder.script.getValue();
            }
import java.util.stream.Collectors;
 * compatible open source license.
 */  
            final Script s = builder.script.getValue();
        return CONTENT_TYPE;
            );
 * SPDX-License-Identifier: Apache-2.0
            }  
                return null;  
            final ContextAwareGroupingFieldType contextAwareGroupingFieldType = new ContextAwareGroupingFieldType(
        this.compiledScript = builder.compiledScript;
import java.util.Collections;
            return builder;
 *
    private final List<String> fields;
     * @param builder
        this.fields = builder.fields.getValue();  
        super(simpleName, mappedFieldType, MultiFields.empty(), CopyTo.empty());
            if (propertyFieldNames.containsAll(builder.fields.getValue()) == false) {
     * Context Aware Segment field is not a part of an ingested document, so omitting it from Context Aware Segment  
            return new ContextAwareGroupingFieldMapper(name, contextAwareGroupingFieldType, this);  
        }
            List<String> fields = (List<String>) o;
            if (!(o instanceof List)) {  
            return s;
        throw new MapperParsingException("context_aware_grouping cannot be ingested in the document");  
    }
            if (fields.isEmpty()) {
import org.opensearch.core.xcontent.XContentBuilder;
                .map(b -> ((Mapper.Builder) b).name())
public class ContextAwareGroupingFieldMapper extends ParametrizedFieldMapper {
     * validation.
        }
    }  
            }
            super(name);  
                    .compile(builder.script.get(), ContextAwareGroupingScript.CONTEXT);
package org.opensearch.index.mapper;
        String simpleName,
