    private static void validateDynamicProperties(List<DynamicProperty> dynamicProperties) {
        super.doMerge(mergeWith, reason);
            this.dynamicTemplates = new Explicit<>(templates.toArray(new DynamicTemplate[0]), true);
                    throw new MapperParsingException(
            // Can't validate template, because field names can't be guessed up front.
    }  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
                return true;  
 */  
                    );
            }
            String message = String.format(
            if (value instanceof Map) {
        return Operations.isEmpty(Operations.intersection(a1, a2)) == false;
        protected ObjectMapper createMapper(
                validateDynamicProperties(merged);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                }
/*
            }
            // violates that contract, treat it as non-fatal and defer validation to document-parse time
                validateDynamicProperties(dynamicProperties);
            return;  
            while (mappers.hasNext()) {
                if ((fieldNode instanceof Map) == false) {  
        public Builder(String name) {  
            }  
        RootObjectMapper update = (RootObjectMapper) super.mappingUpdate(mapper);
    @Override  
        public static final boolean DATE_DETECTION = true;
     */
                if (fieldName.equals("composite")) {
            Iterator<Mapper> mappers = this.iterator();
        protected Explicit<Boolean> dateDetection = new Explicit<>(Defaults.DATE_DETECTION, false);  
 * You may obtain a copy of the License at  
            throw new OpenSearchException("Failed to derive source for doc id [" + docId + "]", e);
        update.dynamicTemplates = new Explicit<>(new DynamicTemplate[0], false);  
                    builder.dynamicDateTimeFormatter(formatters);  
     */  
                        );
            } else if (fieldName.equals("dynamic_templates")) {
                        "dynamic_properties must be an object with pattern keys and mapping objects as values."
    private void validateNoExplicitFieldMatchesDynamicProperty() {
            }
     * @param matchType   the type of the field in the json document or null if unknown
        if (typeParser == null) {
    public DynamicProperty findDynamicProperty(String fullFieldName) {
     * @opensearch.internal
        }
                Map<String, DynamicTemplate> templatesByKey = new LinkedHashMap<>();  
     * Removes redundant root includes in {@link ObjectMapper.Nested} trees to avoid duplicate
                + new TreeSet<>(types)
                    throw new MapperParsingException(
            throw multiValueNotSupported(dynamicTemplate.getName(), multiValueRejectingTypes);  
    }
                if (dp.matches(path)) {  
        Explicit<DateFormatter[]> dynamicDateTimeFormatters,  
                    nested.setIncludeInParent(true);  
    private Mapper.Builder findTemplateBuilder(ParseContext context, String name, XContentFieldType matchType, DateFormatter dateFormat) {
            String templateName = DYNAMIC_TEMPLATE_NAME_PREFIX + dynamicTemplate.name();  
import org.apache.logging.log4j.message.ParameterizedMessage;  
import org.opensearch.index.mapper.MapperService.MergeReason;
            Object disableObjectsNode = node.remove("disable_objects");
/*  
        if (dynamicProperties.explicit() || includeDefaults) {  
    private static void collectFullPaths(ObjectMapper obj, List<String> paths) {
    public DynamicTemplate findTemplate(ContentPath path, String name, XContentFieldType matchType) {  
            // after parsing all other properties  
                ),  
    /**
                dynamicProperties,
    /**
        }  
            }
        String name,
            DateFormatter.forPattern("yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis") };  
            this.numericDetection = mergeWithObject.numericDetection;
            // rather than failing index creation — but log it so the contract violation is visible.  
            builder.field("numeric_detection", numericDetection.value());  
            String key = entry.getKey().toString();
    }  
                    BuilderContext builderContext = new BuilderContext(indexSettings, new ContentPath(1));
        if (dynamicDateTimeFormatters.explicit() || includeDefaults) {  
            return this;  
import org.opensearch.common.annotation.PublicApi;
                }
        public Builder dynamicProperties(Collection<DynamicProperty> dynamicProperties) {  
                } else if ("none".equals(fieldNode.toString())) {
        Set<String> multiValueRejectingTypes = new TreeSet<>();
                parseCompositeField(builder, (Map<String, Object>) compositeField, parserContext);
            if (lastError != null) {  
 * license agreements. See the NOTICE file distributed with
                if (valueString.contains(snippet)) {
            if (value instanceof Map) {
        for (Object value : list) {  
                    if ("*".equals(pattern)) {
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext(dateFormat);
        // A parser removes each key it consumes, so a leftover multi_value means the type ignored it. This also  
            types = XContentFieldType.values();  
 * KIND, either express or implied.  See the License for the
                @SuppressWarnings("unchecked")
        }  
                        }  
    }
        Exception lastError = null;  
            } else if (value instanceof String) {  
                    dynamicProperties.add(new DynamicProperty(pattern, mapping));
        protected boolean processField(RootObjectMapper.Builder builder, String fieldName, Object fieldNode, ParserContext parserContext) {
    }  
                    Map.Entry<String, Object> entry = tmpl.entrySet().iterator().next();  
        final boolean includeDefaults = params.paramAsBoolean("include_defaults", false);
 * software distributed under the License is distributed on an
            return;
                return true;  
        for (String path : explicitPaths) {
                } else if (fieldName.equals(ContextAwareGroupingFieldMapper.CONTENT_TYPE)) {
                Map.Entry<String, Object> entry = iterator.next();
                }
                builder.startObject();
                settings
            logger.warn(
            if (disableObjectsNode != null) {  
     * mapping root (same as field names in queries), not simpleName + manual prefix concatenation.
            } else {
                        iterator.remove();
                ContextAwareGroupingFieldMapper.CONTENT_TYPE,  
    private static final String DYNAMIC_TEMPLATE_NAME_PREFIX = "__dynamic__";
            builder.endObject();  
        }  
        if (mergeWithObject.numericDetection.explicit()) {
        // static mapping. On other indices multi_value is just an unknown key and keeps the deprecation warning.  
                        parserContext.mapperService().getDynamicTemplateTypes()  
    }
            return null;
        boolean multiValueAccepted = false;  
            if (typeParser == null) {
            RootObjectMapper.Builder builder = new Builder(name);  
            builder.startArray("dynamic_templates");  
            }
        for (XContentFieldType contentFieldType : types) {  
 */
                builder.numericDetection = new Explicit<>(nodeBooleanValue(fieldNode, "numeric_detection"), true);
            throw multiValueNotSupported(dynamicTemplate.getName(), Set.of(mappingType));
        for (Map.Entry<?, ?> entry : map.entrySet()) {  
                } else {
                        throw new MapperParsingException("dynamic_properties entry [" + pattern + "] must have a mapping object as value.");
            // ObjectMapper.name() and FieldMapper.name() both return the full path (e.g. parent.child),  
                } else {  
        update.numericDetection = new Explicit<>(Defaults.NUMERIC_DETECTION, false);
    }
                            + "] overlap (both can match the same field name)."  
            // Important : Composite field is made up of 2 or more source properties of the index, so this must be called
            );
     * Parses only {@code type} and {@code multi_value} with the type's own parser. A parser removes each key it  
     * {@code isIncludeInParent} returning {@code true}.  
                }
        public static final boolean NUMERIC_DETECTION = false;
    RootObjectMapper(  
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> mappingConfig = dynamicTemplate.mappingForName(name, dynamicType);
                for (Object tmplNode : tmplNodes) {
                Object fieldNode = entry.getValue();  
    }  
            return false;
                        throw new MapperParsingException(
     */
import org.opensearch.OpenSearchException;
    /**  
            this.dynamicProperties = new Explicit<>(dynamicProperties.toArray(new DynamicProperty[0]), true);
        }  
 *
        }  
     * is also capped at {@link #MAX_DYNAMIC_PROPERTIES} to bound the O(n²) overlap-detection cost.  
                        templateParams,
                    }
        protected Explicit<DynamicProperty[]> dynamicProperties = new Explicit<>(new DynamicProperty[0], false);
                    String type = typeNode.toString();
            if (reason == MergeReason.INDEX_TEMPLATE) {
            }
                    }
import java.util.Set;
        }
    @SuppressWarnings("rawtypes")  
 */  
            // not a leaf segment; prefix + name() would incorrectly produce parent.parent.child.
        }
        return dynamicDateTimeFormatters.value();
                dynamicTemplate.getName(),
                            "No handler for type [" + type + "] declared for dynamic_property pattern [" + pattern + "]"
        }
     * at index-creation time.
 * this file be licensed under the Apache-2.0 license or a
/*  
            }
            Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);  
            for (int j = i + 1; j < dynamicProperties.size(); j++) {
                    if (pattern.contains("*") == false) {
    @Override
                            + p1.getPattern()  
            for (DynamicProperty dp : dynamicProperties.value()) {
        protected Explicit<Boolean> numericDetection = new Explicit<>(Defaults.NUMERIC_DETECTION, false);
    ) {  
        List<String> explicitPaths = new ArrayList<>();
                    builder.dynamicDateTimeFormatter(Collections.singleton(parseDateTimeFormatter(fieldNode)));
                Map<String, Object> dynPropsNode = (Map<String, Object>) fieldNode;  
 * Licensed to Elasticsearch under one or more contributor  
                            + dp.getPattern()
        Map<String, Object> fieldTypeConfig,
        @Override  
            if (reason == MergeReason.MAPPING_RECOVERY) {  
                    } else {
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;  
                String valueString = (String) value;
        // The plugin type was validated against the registry at parse time, so a handler is always present.
/**
import org.apache.logging.log4j.Logger;
            if (dp.matches(fullFieldName)) {
}
                    return true;  
package org.opensearch.index.mapper;
                boolean includeInRootViaParent = parentIncluded && isNested && nested.isIncludeInParent();  
        for (DynamicProperty dp : dynamicProperties.value()) {  
        return update;
                ObjectMapper child = (ObjectMapper) mapper;  
                if (fieldNode instanceof List) {
                    throw new MapperParsingException(
        }
                this.dynamicProperties = new Explicit<>(merged.toArray(new DynamicProperty[0]), true);  
                List<?> tmplNodes = (List<?>) fieldNode;
            // existing patterns (same as INDEX_TEMPLATE). Recovery applies persisted mapping as-is.
        DynamicTemplateTypeHandler handler = parserContext.mapperService().getDynamicTemplateTypes().get(pluginType);  
        // Config is fully specified. Let the handler normalize it (e.g. inject its own type when the
            && Mapper.isPluggableDataFormatEnabled(parserContext.getSettings());
            DEPRECATION_LOGGER.deprecate("invalid_dynamic_template_" + dynamicTemplate.getName(), deprecationMessage);
    /**  
            // config never reads the field value, so this is a no-op normalization (e.g. type injection).
                    dummyBuilder.build(builderContext);  
        }
     * {@code true} or which is transitively included in root by a chain of nodes with
                deprecationMessage = String.format(Locale.ROOT, "%s, caused by [%s]", message, lastError.getMessage());
    private static MapperParsingException multiValueNotSupported(String templateName, Set<String> types) {
    }  
            }
                if (valueString.contains(snippet)) {
            } catch (Exception e) {  
     * fields on the root mapper when {@code isIncludeInRoot} is {@code true} for a node that is  
                    String pattern = entry.getKey();  
                    throw new MapperParsingException("Dynamic template syntax error. An array of named objects is expected.");  
        }  
        protected static void parseContextAwareGroupingField(
     * consumes, so the key is left behind when the type does not support it, whether the parser ignores it or
                for (DynamicProperty dp : mergeWithObject.dynamicProperties.value()) {
                builder.dynamicTemplates(templates);  
     * Builder for the root object  
        Map<String, Object> fieldTypeConfig = dynamicTemplate.mappingForName(templateName, pluginType);
            String name,
                    multiValueRejectingTypes.add(mappingType);  
    }
    }
 * under the License.  
                    Settings indexSettings = parserContext.mapperService().getIndexSettings().getSettings();
            } else if (fieldName.equals("dynamic_properties")) {
                    if (template.getPluginMatchType() == null) {
            if (key.contains(snippet)) {
                e
     *  
        boolean checkMultiValue = dynamicTemplate.getMapping().containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER)
import org.apache.lucene.util.automaton.Operations;  
                    dynamicTemplate.getName()
            } else if (value instanceof List) {
                    String templateName = entry.getKey();
                }  
                    multiValueAccepted = true;
                if (containsSnippet((Map<?, ?>) value, snippet)) {
                Map<String, DynamicProperty> byPattern = new LinkedHashMap<>();  
 * GitHub history for details.
            Object contextAwareGoupingField = null;
            return;
        if (mergeWithObject.dateDetection.explicit()) {
                // "match_mapping_type" : "string",  
        Settings settings
        Dynamic dynamic,  
        Explicit<DynamicProperty[]> dynamicProperties,
    /**  
                + "] maps to type "  
    }
        for (DynamicTemplate dynamicTemplate : dynamicTemplates.value()) {
                        || processField(builder, fieldName, fieldNode, parserContext)) {  
                return dynamicTemplate;
        String pluginType = dynamicTemplate.getPluginMatchType();
        for (Mapper mapper : obj) {
            String mappingType = dynamicTemplate.mappingType(defaultDynamicType);
            } else if (value instanceof String) {  
            // Merge by pattern key for live mapping updates and templates so a partial PUT does not drop
                                + "To apply one default mapping to all unknown field names, use dynamic_templates instead."
        final String pathAsString = path.pathAsText(name);
        return findTemplateBuilder(context, name, matchType, null);
                Mapper mapper = mappers.next();  
        update.dynamicDateTimeFormatters = new Explicit<>(Defaults.DYNAMIC_DATE_TIME_FORMATTERS, false);
            String defaultDynamicType = contentFieldType.defaultMappingType();
        return false;
        if (checkMultiValue && multiValueAccepted == false && multiValueRejectingTypes.isEmpty() == false) {
     * @return a mapper builder, or null if there is no template for such a field
import org.opensearch.common.xcontent.XContentFactory;  
     * Validates {@code dynamic_properties}. The bare pattern {@code *} is rejected at parse time; overlap
            } else {
     * Paths use each mapper's {@link Mapper#name()}, which is already the full dotted path from the
            }  
                "dynamic template [%s] has invalid content [%s]",  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }
    private Explicit<DynamicTemplate[]> dynamicTemplates;  
     * the first indexed document rather than declared in the
                            + "]. Explicit fields cannot overlap with dynamic_properties."  
        ) {  
        }
                // {  
                for (Map.Entry<String, Object> entry : dynPropsNode.entrySet()) {
    /**
        // applied at merge time
                List<DynamicTemplate> templates = new ArrayList<>();  
        }
    }  
        Automaton a2 = Regex.simpleMatchToAutomaton(pattern2);  
                // "match" : "*_test",
    }  
    public boolean numericDetection() {  
        }  
        if (dynamicTemplates.explicit() || includeDefaults) {
        public RootObjectMapper build(BuilderContext context) {  
 *  
                }  
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Locale;
    public static class Builder extends ObjectMapper.Builder<Builder> {
            } else if (fieldName.equals("numeric_detection")) {
                if (typeAcceptsMultiValue(typeParser, templateName, fieldTypeConfig, parserContext)) {  
        Explicit<Boolean> disableObjects,
        }  
                }  
                // "mapping" : { "type" : "keyword", "store" : "yes" }
        return dynamicProperties.value();
        try {  
        if (containsSnippet(dynamicTemplate.getMapping(), "{name}")) {  
            } else {
        if (mergeWithObject.dynamicDateTimeFormatters.explicit()) {  
                }
        }
            Mapper.TypeParser typeParser = parserContext.typeParser(ContextAwareGroupingFieldMapper.CONTENT_TYPE);
    private Explicit<DateFormatter[]> dynamicDateTimeFormatters;  
        update.dynamicProperties = new Explicit<>(new DynamicProperty[0], false);
        }
        }
                builder.value(dateTimeFormatter.pattern());  
        for (Mapper mapper : objectMapper) {
    public void fixRedundantIncludes() {
        }
    }
                + templateName
                    );
                // ]
     * itself included into a parent node, for which either {@code isIncludeInRoot} is
                lastError = new IllegalArgumentException("No mapper found for type [" + mappingType + "]");
                return true;  
            if (mapper instanceof ObjectMapper) {
import java.util.Map;  
            return;
                    DynamicTemplate template = DynamicTemplate.parse(  
                }  
    }
                objBuilder  
                    "Deferring index-creation validation of dynamic template [{}]: its handler threw while "  
    /**
     * @param name        the field name
                    byPattern.put(dp.getPattern(), dp);
     * the type parser (not core) reports any invalid content, exactly as it would for an explicit  
        public Builder dynamicTemplates(Collection<DynamicTemplate> templates) {
        if (handler.isConfigComplete(fieldTypeConfig) == false) {
        DynamicTemplate dynamicTemplate = findTemplate(context.path(), name, matchType);
                    );  
        }
    }
        }  
        return null;
                    + MAX_DYNAMIC_PROPERTIES
    /**
        Explicit<Boolean> enabled,
            ObjectMapper.Builder objBuilder,  
import org.opensearch.common.time.DateFormatter;
            Explicit<Boolean> disableObjects,
            }
                if (containsSnippet((List<?>) value, snippet)) {  
                    templates.add(template);
     */
                    return true;  
        return builder;  
                }
     * fully specified. In that case we hand the config to the plugin's {@link Mapper.TypeParser}, and
    @Override
        } catch (IllegalStateException | IOException e) {  
                    Map<String, Object> tmpl = (Map<String, Object>) tmplNode;
        final XContentFieldType[] types;
            if (fieldName.equals("date_formats") || fieldName.equals("dynamic_date_formats")) {  
                    if (typeParser == null) {  
public class RootObjectMapper extends ObjectMapper {
                for (DynamicTemplate template : mergeWithObject.dynamicTemplates.value()) {
                        throw new MapperParsingException("dynamic_properties pattern [" + pattern + "] must contain a wildcard [*].");
            Explicit<Boolean> enabled,
        if (mergeWithObject.dynamicTemplates.explicit()) {
                }
     */
        return findTemplateBuilder(context, name, XContentFieldType.DATE, dateFormatter);
            Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator();  
                    );
     * <p>Plugin templates are allowed to be intentionally incomplete: a parameter may be derived from
                    builder.dynamicDateTimeFormatter(Collections.emptyList());
        }
     * @opensearch.internal
        if (containsSnippet(dynamicTemplate.getMapping(), "{name}")) {  
import org.opensearch.common.settings.Settings;
            "dynamic template ["
                    templatesByKey.put(template.name(), template);
            super(name);
                }  
                deprecationMessage = message;  
     */
    public ObjectMapper mappingUpdate(Mapper mapper) {
 *
import org.opensearch.core.xcontent.XContentBuilder;
            while (iterator.hasNext()) {  
    }
        this.dateDetection = dateDetection;
     */  
    ) {  
        fixRedundantIncludes(this, true);  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
 * Unless required by applicable law or agreed to in writing,
                    lastError = new IllegalArgumentException("Unused mapping attributes [" + fieldTypeConfig + "]");
        String templateName = DYNAMIC_TEMPLATE_NAME_PREFIX + dynamicTemplate.getName();  
                    Mapper.TypeParser typeParser = parserContext.typeParser(type);
        } finally {
                        validateDynamicTemplate(parserContext, template);  
        // for dynamic updates, no need to carry root-specific options, we just  
            }
    /**
            } else if (fieldName.equals("date_detection")) {
                dynamicTemplates,
            DateFieldMapper.getDefaultDateTimeFormatter(),
                return true;
                for (DynamicTemplate template : this.dynamicTemplates.value()) {
            builder.startArray("dynamic_date_formats");
    private static boolean containsSnippet(Map<?, ?> map, String snippet) {
    protected void doMerge(ObjectMapper mergeWith, MergeReason reason) {
    public DynamicTemplate[] dynamicTemplates() {
            }
        }  
     * Patterns are checked in declaration / merge order (first match wins).  
        String templateName,  
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);  
     * @opensearch.internal
            }
        // Reject any pair of patterns whose glob languages overlap (same field name can match both).  
     * @param dateFormat  a dateformatter to use if the type is a date, null if not a date or is using the default format  
        }
        }
                } else {
        }
                    }  
        public static final DateFormatter[] DYNAMIC_DATE_TIME_FORMATTERS = new DateFormatter[] {
            this.dateDetection = mergeWithObject.dateDetection;  
        if (dynamicProperties.value().length == 0) {
            builder.endObject();
                        validatePluginDynamicTemplate(parserContext, template);
                boolean isNested = nested.isNested();
        boolean dynamicTemplateInvalid = true;
                List<DynamicProperty> dynamicProperties = new ArrayList<>();
            Map<String, Mapper> mappers,
                    byPattern.put(dp.getPattern(), dp);
                String valueString = (String) value;
                boolean includedInRoot = isNested && nested.isIncludeInRoot();
        Explicit<Boolean> numericDetection,
            return;  
        String mappingType = dynamicTemplate.mappingType(pluginType);
                + "]"
            // Config relies on data-derived parameters; it can only be validated once a document is seen.  
        public Builder dynamicDateTimeFormatter(Collection<DateFormatter> dateTimeFormatters) {
        // content and reports any invalid config.
            }
 * ownership. Elasticsearch licenses this file to you under  
        }
    }
        return BytesReference.bytes(builder);
    protected void doXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        if (dynamicTemplate.getXContentFieldType() != null) {  
        }
    }
    /**
        if (numericDetection.explicit() || includeDefaults) {
                    List<DateFormatter> formatters = new ArrayList<>();
import java.util.List;
import static org.opensearch.index.mapper.TypeParsers.parseDateTimeFormatter;  
        ) {
        }  
                    templatesByKey.put(template.name(), template);
        // On a pluggable data format index, multi_value on a type that does not support it is an error, as in a
                if (dynamicPropertyPatternsOverlap(p1.getPattern(), p2.getPattern())) {  
     */  
                            + path  
        if (dynamicTemplate == null) {  
        // {name} placeholders can't be resolved until a concrete field name is known — skip, as the
        }
    }
        }
    public BytesReference deriveSource(LeafReader leafReader, int docId) throws IOException {
                // "dynamic_templates" : [
            this.dynamicDateTimeFormatters = new Explicit<>(dateTimeFormatters.toArray(new DateFormatter[0]), true);  
     *  
        // set everything to they implicit default value so that they are not
    }  
                + ParametrizedFieldMapper.MULTI_VALUE_PARAMETER  
                    for (Object formatter : (List<?>) fieldNode) {  
                    contextAwareGoupingField = fieldNode;
        if (dateDetection.explicit() || includeDefaults) {
        if (reason != MergeReason.MAPPING_RECOVERY) {  
                enabled,
 * this work for additional information regarding copyright
     * plugin reports — via {@link DynamicTemplateTypeHandler#isConfigComplete} — that the config is
                    }  
            // Parse disable_objects first so it's available when parseProperties is called.
    /**
            String fullPath,  
                            "dynamic_properties pattern [*] is not allowed; use a more specific pattern that still contains [*]. "  
import org.opensearch.common.Explicit;
                        throw new MapperParsingException(
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                    if ((entry.getValue() instanceof Map) == false) {
     */  
                        formatters.add(parseDateTimeFormatter(formatter));
                // }  
                        );  
                    nested.setIncludeInRoot(false);
     * field mapping of the same type. Otherwise validation is deferred to document-parse time.
 * The root object mapper for a document  
            }  
        Mapper.TypeParser typeParser,
                contextAwareGroupingNode,
 * @opensearch.api
                parseContextAwareGroupingField(builder, (Map<String, Object>) contextAwareGoupingField, parserContext);  
        }
            this.dynamicDateTimeFormatters = mergeWithObject.dynamicDateTimeFormatters;
            );
import org.opensearch.common.Nullable;  
import org.opensearch.core.common.Strings;
                builder.dynamicProperties(dynamicProperties);
        if (dynamicProperties.size() > MAX_DYNAMIC_PROPERTIES) {  
            Nested nested,
            for (DynamicTemplate dynamicTemplate : dynamicTemplates.value()) {
        try {
                        "dynamic_properties patterns ["
        this.dynamicTemplates = dynamicTemplates;
        Explicit<DynamicTemplate[]> dynamicTemplates,
     * throws on it. Probing alone keeps an unrelated invalid parameter from being reported as a multi_value error.
                        templateName,
        }
                dynamicDateTimeFormatters,  
                builder.dateDetection = new Explicit<>(nodeBooleanValue(fieldNode, "date_detection"), true);
            Object compositeField = null;
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);  
                } else {  
        String dynamicType = matchType.defaultMappingType();  
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
        }
import org.opensearch.core.xcontent.ToXContent;
            assert !nested.isNested();
                }
                    return true;  
            }  
 * The OpenSearch Contributors require contributions made to  
            Map<String, Object> fieldTypeConfig = dynamicTemplate.mappingForName(templateName, defaultDynamicType);
    }  
     * between any two remaining patterns is not allowed (automaton intersection). The total number of patterns
    /**
            for (DynamicProperty dp : dynamicProperties.value()) {
            paths.add(mapper.name());
        @Override
    }  
            Object value = entry.getValue();  
            validateNoExplicitFieldMatchesDynamicProperty();
                + ", which does not support ["
                    dynamicTemplateInvalid = false;
     * Maximum number of {@code dynamic_properties} patterns allowed in a single mapping. Kept low by default
                lastError = e;
    public static final int MAX_DYNAMIC_PROPERTIES = 50;
        probe.put(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER, fieldTypeConfig.get(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER));
        Map<String, Mapper> mappers,
                // }
                this.dynamicTemplates = new Explicit<>(mergedTemplates, true);  
     */
        }  
import java.util.Collection;
            types = new XContentFieldType[] { dynamicTemplate.getXContentFieldType() };
    }
            );
    private static void validateDynamicTemplate(Mapper.TypeParser.ParserContext parserContext, DynamicTemplate dynamicTemplate) {
                // "template_1" : {
        // never invoked at index-creation time. Then hand it to the type parser, which validates the  
        }
            }
    private static boolean dynamicPropertyPatternsOverlap(String pattern1, String pattern2) {
                continue;  
    private Explicit<Boolean> dateDetection;
            DynamicProperty p1 = dynamicProperties.get(i);  
        }
        @Override  
        Explicit<Boolean> dateDetection,  
            // A complete config performs no I/O and must not read the field value. If a handler
    }
        return null;
                        + "normalizing a config it reported as complete",
        // template omitted it) — a complete config never reads the field value, so the supplier is
                fieldTypeConfig.remove("type");
        return dynamicTemplates.value();  
     */  
        Automaton a1 = Regex.simpleMatchToAutomaton(pattern1);
            // No parser to validate against — defer to document-parse time, which reports the error.
            throw new MapperParsingException("failed to find type parsed [" + mappingType + "] for [" + name + "]");
                "The number of dynamic_properties patterns ["
                if ((fieldNode instanceof List) == false) {
                parserContext,
            }
    public DynamicProperty[] dynamicProperties() {  
            if (mapper instanceof ObjectMapper child) {  
                    if (tmpl.size() != 1) {  
                builder.endObject();
                    iterator.remove();  
                Nested nested = child.nested();
     * template. Such templates cannot be validated up front, so we only validate eagerly when the  
            probe.put("type", fieldTypeConfig.get("type"));  
                        throw new MapperParsingException("A dynamic template must be defined with a name");
    public DateFormatter[] dynamicDateTimeFormatters() {
import java.util.ArrayList;
            builder.field("date_detection", dateDetection.value());  
 * not use this file except in compliance with the License.
    private static boolean typeAcceptsMultiValue(
                () -> new ParameterizedMessage(
     * Validates that no explicitly mapped field path is matched by any dynamic_property pattern.
     * Default parameters for root object
        return this.numericDetection.value();
@PublicApi(since = "1.0.0")
                    break;
import org.apache.lucene.util.automaton.Automaton;
    }  
    private static void fixRedundantIncludes(ObjectMapper objectMapper, boolean parentIncluded) {  
        } catch (Exception e) {  
                }
                Mapper.Builder<?> dummyBuilder = typeParser.parse(templateName, fieldTypeConfig, parserContext);
            @Nullable Settings settings  
 */  
                name,
import org.apache.lucene.index.LeafReader;
                mappers,
                    Map<String, Object> templateParams = (Map<String, Object>) entry.getValue();
        RootObjectMapper mergeWithObject = (RootObjectMapper) mergeWith;  
        }
        return false;
    public static class TypeParser extends ObjectMapper.TypeParser {
            }
            return new RootObjectMapper(  
                }
                disableObjects,
     */  
        this.numericDetection = numericDetection;  
        // Uses the same automaton construction as Regex.simpleMatch / Glob.globMatch (see Regex.simpleMatchToAutomaton).
                fixRedundantIncludes(child, includeInRootViaParent || includedInRoot);  
        typeParser.parse(templateName, fieldTypeConfig, parserContext);
            if (compositeField != null) {
            try {  
            throw new MapperParsingException(
                            + p2.getPattern()
    public boolean dateDetection() {
        }  
        } catch (Exception e) {
        }  
        if (dynamicProperties.isEmpty()) {  
            }  
    private static boolean containsSnippet(List<?> list, String snippet) {
            this.builder = this;
            root.validateNoExplicitFieldMatchesDynamicProperty();
            Map<String, Object> contextAwareGroupingNode,
            Dynamic dynamic,  
     *
                }
    private Explicit<Boolean> numericDetection;
                return true;  
        // covers templates that could not be checked when they were created, such as those using {name}.
                dynamic,  
                    return true;
                    Object typeNode = mapping.get("type");  
import java.util.TreeSet;  
 *
            } else if (value instanceof List) {
                parseObjectOrDocumentTypeProperties("disable_objects", disableObjectsNode, parserContext, builder);
    public Mapper.Builder findTemplateBuilder(ParseContext context, String name, XContentFieldType matchType) {  
        }
                if (fieldTypeConfig.isEmpty()) {  
     * Find a template. Returns {@code null} if no template could be found.  
                            + "] because it is matched by dynamic_property pattern ["
        protected Explicit<DateFormatter[]> dynamicDateTimeFormatters = new Explicit<>(Defaults.DYNAMIC_DATE_TIME_FORMATTERS, false);
            builder.endArray();  
            }
            handler.adjustMappingConfig(fieldTypeConfig, FieldValueParserSupplier.withoutValue());
                    if (typeNode == null) {
            // Only the leftover key decides; e.g. scaled_float consumes multi_value, then fails on its missing scaling_factor.  
                    Map<String, Object> mapping = new TreeMap<>((Map<String, Object>) entry.getValue());
            final String deprecationMessage;
                }  
                if (includeInRootViaParent && includedInRoot) {
            );  
        return new MapperParsingException(  
                }
            return;  
            && Mapper.isPluggableDataFormatEnabled(parserContext.getSettings())) {  
                mapper.deriveSource(builder, leafReader, docId);
            if (contextAwareGoupingField != null) {
                            throw new MapperParsingException("Epoch [" + formatter + "] is not supported as dynamic date format");
        public Mapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        Mapper.TypeParser.ParserContext parserContext
import org.opensearch.common.regex.Regex;  
        if (typeParser == null) {
            }
    private static void validatePluginDynamicTemplate(Mapper.TypeParser.ParserContext parserContext, DynamicTemplate dynamicTemplate) {  
            for (DateFormatter dateTimeFormatter : dynamicDateTimeFormatters.value()) {
import java.io.IOException;  
import java.util.HashMap;
     * because overlap detection is O(n²) in the number of patterns; raising this limit also raises that cost.
                }
                    iterator.remove();  
    public static class Defaults {  
            RootObjectMapper root = (RootObjectMapper) super.build(context);
    @SuppressWarnings("rawtypes")
        if (mergeWithObject.dynamicProperties.explicit()) {  
            builder.startObject("dynamic_properties");
            return root;  
    @Override  
            if (dynamicTemplate.getPluginMatchType() == null && dynamicTemplate.match(pathAsString, name, matchType)) {  
        this.dynamicProperties = dynamicProperties;
    public Mapper.Builder findTemplateBuilder(ParseContext context, String name, DateFormatter dateFormatter) {
                    }  
                for (DynamicProperty dp : this.dynamicProperties.value()) {
    public RootObjectMapper merge(Mapper mergeWith, MergeReason reason) {
        if (fieldTypeConfig.containsKey("type")) {
                    }  
        String mappingType = dynamicTemplate.mappingType(dynamicType);
                this.dynamicProperties = mergeWithObject.dynamicProperties;
                Locale.ROOT,
                    @SuppressWarnings("unchecked")
            return builder;
                    compositeField = fieldNode;
                return true;  
                    }
        if (dynamicTemplateInvalid) {  
     * Returns the first dynamic property that matches the given field name, or null.
                }
            if (checkMultiValue) {
    }
                    + "]."  
        protected Explicit<DynamicTemplate[]> dynamicTemplates = new Explicit<>(new DynamicTemplate[0], false);  
            // No document is available at index creation, so the supplier's get() throws. A complete  
    private static final Logger logger = LogManager.getLogger(RootObjectMapper.class);
                dateDetection,  
        return (RootObjectMapper) super.merge(mergeWith, reason);  
import java.util.Iterator;
        }  
                if (containsSnippet((List<?>) value, snippet)) {  
            if (path.isEmpty()) {
        );
        for (int i = 0; i < dynamicProperties.size(); i++) {
                    + "] exceeds the maximum allowed ["
        if (mappingConfig.containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER)
                    }
                        "Cannot add explicit property ["
        return this.dateDetection.value();  
                            + "] and ["
                Strings.toString(MediaTypeRegistry.JSON, dynamicTemplate)
                        throw new MapperParsingException("No type specified for dynamic_property pattern [" + pattern + "]");
                    }  
import java.util.LinkedHashMap;  
            objBuilder.add(mapperBuilder);
import org.opensearch.common.logging.DeprecationLogger;
     * Type parser for the root object  
                if (containsSnippet((Map<?, ?>) value, snippet)) {
        super(name, name, enabled, Nested.NO, dynamic, disableObjects, mappers, settings);
                builder.field(dynamicTemplate.name(), dynamicTemplate);  
                        if (formatter.toString().startsWith("epoch_")) {
import java.util.TreeMap;
                    return true;
            ParserContext parserContext
        }
                numericDetection,
                DynamicTemplate[] mergedTemplates = templatesByKey.values().toArray(new DynamicTemplate[0]);
        } else {
        // builtin path does.
                String fieldName = entry.getKey();
     * Validates a dynamic template whose {@code match_mapping_type} is a plugin-registered type
     * Per the dynamic_properties contract, explicit properties cannot overlap with dynamic patterns.  
                return dp;
        try {  
     * True iff some field name matches both glob patterns (same semantics as {@link Regex#simpleMatch}).
                    + dynamicProperties.size()  
                collectFullPaths(child, paths);
                    return true;  
                    if (parseObjectOrDocumentTypeProperties(fieldName, fieldNode, parserContext, builder)
 * specific language governing permissions and limitations
        collectFullPaths(this, explicitPaths);  
        }
    }
                builder.field(dp.getPattern(), dp.getMapping());  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        this.dynamicDateTimeFormatters = dynamicDateTimeFormatters;  
            typeParser.parse(templateName, probe, parserContext);
            return;
        return probe.containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER) == false;
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RootObjectMapper.class);  
            return this;
            Mapper.Builder<?> mapperBuilder = typeParser.parse(
            builder.endArray();
        Map<String, Object> probe = new HashMap<>();
                this.dynamicTemplates = mergeWithObject.dynamicTemplates;
                continue;  
            return this;
        Mapper.Builder builder = typeParser.parse(name, mappingConfig, parserContext);
        update.dateDetection = new Explicit<>(Defaults.DATE_DETECTION, false);  
     *
                List<DynamicProperty> merged = new ArrayList<>(byPattern.values());
                DynamicProperty p2 = dynamicProperties.get(j);
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
    private Explicit<DynamicProperty[]> dynamicProperties;
            );  
            }
