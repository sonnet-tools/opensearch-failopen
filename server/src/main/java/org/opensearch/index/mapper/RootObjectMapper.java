        Automaton a1 = Regex.simpleMatchToAutomaton(pattern1);
                if (dp.matches(path)) {
    }
                    throw new MapperParsingException(
                    DynamicTemplate template = DynamicTemplate.parse(
            types = new XContentFieldType[] { dynamicTemplate.getXContentFieldType() };
 * Unless required by applicable law or agreed to in writing,
                } else {
        }
        Explicit<DateFormatter[]> dynamicDateTimeFormatters,
                            + "] because it is matched by dynamic_property pattern ["
                    if (pattern.contains("*") == false) {
                disableObjects,
        protected static void parseContextAwareGroupingField(
            }
    public DateFormatter[] dynamicDateTimeFormatters() {
            }
 */
        if (mergeWithObject.numericDetection.explicit()) {
 * @opensearch.api
            }
        // Reject any pair of patterns whose glob languages overlap (same field name can match both).
        return dynamicProperties.value();
     * Patterns are checked in declaration / merge order (first match wins).
                    throw new MapperParsingException(
                validateDynamicProperties(dynamicProperties);
                continue;
    private static MapperParsingException multiValueNotSupported(String templateName, Set<String> types) {
                    dummyBuilder.build(builderContext);
    private Explicit<Boolean> dateDetection;
            paths.add(mapper.name());
     * Paths use each mapper's {@link Mapper#name()}, which is already the full dotted path from the
            } catch (Exception e) {
                    + MAX_DYNAMIC_PROPERTIES
        }
            String mappingType = dynamicTemplate.mappingType(defaultDynamicType);
        if (mappingConfig.containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER)
 *
        }
            }
                        templateName,
     * between any two remaining patterns is not allowed (automaton intersection). The total number of patterns
                    multiValueRejectingTypes.add(mappingType);
            Object disableObjectsNode = node.remove("disable_objects");
/*
            return this;
                Object fieldNode = entry.getValue();
     *
            // rather than failing index creation — but log it so the contract violation is visible.
    }
                continue;
        }
        return probe.containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER) == false;
            String fullPath,
    /**
        this.numericDetection = numericDetection;
            return;
        if (handler.isConfigComplete(fieldTypeConfig) == false) {
    public Mapper.Builder findTemplateBuilder(ParseContext context, String name, XContentFieldType matchType) {
        // Uses the same automaton construction as Regex.simpleMatch / Glob.globMatch (see Regex.simpleMatchToAutomaton).
            // No parser to validate against — defer to document-parse time, which reports the error.
            }
    }
 */
            builder.endObject();
        }
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
    public static class Builder extends ObjectMapper.Builder<Builder> {
        return builder;
            }
     * <p>Plugin templates are allowed to be intentionally incomplete: a parameter may be derived from
     * Find a template. Returns {@code null} if no template could be found.
     */
        public static final DateFormatter[] DYNAMIC_DATE_TIME_FORMATTERS = new DateFormatter[] {
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RootObjectMapper.class);
        this.dynamicTemplates = dynamicTemplates;
     * fields on the root mapper when {@code isIncludeInRoot} is {@code true} for a node that is
            for (DynamicProperty dp : dynamicProperties.value()) {
                        + "normalizing a config it reported as complete",
            return;
        Exception lastError = null;
 * Licensed to Elasticsearch under one or more contributor
        Automaton a2 = Regex.simpleMatchToAutomaton(pattern2);
        // set everything to they implicit default value so that they are not
 * SPDX-License-Identifier: Apache-2.0
                        throw new MapperParsingException("A dynamic template must be defined with a name");
                }
            if (dynamicTemplate.getPluginMatchType() == null && dynamicTemplate.match(pathAsString, name, matchType)) {
            if (value instanceof Map) {
        Explicit<DynamicProperty[]> dynamicProperties,
                }
    protected void doMerge(ObjectMapper mergeWith, MergeReason reason) {
        DynamicTemplate dynamicTemplate = findTemplate(context.path(), name, matchType);
                        "dynamic_properties patterns ["
            );
            ObjectMapper.Builder objBuilder,
        Explicit<Boolean> numericDetection,
        probe.put(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER, fieldTypeConfig.get(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER));
        update.dynamicTemplates = new Explicit<>(new DynamicTemplate[0], false);
            return;
            for (DynamicProperty dp : dynamicProperties.value()) {
                    builder.dynamicDateTimeFormatter(formatters);
    }
            // Parse disable_objects first so it's available when parseProperties is called.
                    }
                boolean isNested = nested.isNested();
        }
 * ownership. Elasticsearch licenses this file to you under
        protected Explicit<Boolean> numericDetection = new Explicit<>(Defaults.NUMERIC_DETECTION, false);
    /**
                // }
            } else if (fieldName.equals("dynamic_templates")) {
                dynamic,
                }
                dynamicDateTimeFormatters,
     * plugin reports — via {@link DynamicTemplateTypeHandler#isConfigComplete} — that the config is
            );
                this.dynamicTemplates = new Explicit<>(mergedTemplates, true);
                    @SuppressWarnings("unchecked")
    public DynamicProperty findDynamicProperty(String fullFieldName) {
            Map<String, Mapper> mappers,
        }
        // static mapping. On other indices multi_value is just an unknown key and keeps the deprecation warning.
                    }
import org.opensearch.common.Explicit;
                "dynamic template [%s] has invalid content [%s]",
            throw multiValueNotSupported(dynamicTemplate.getName(), multiValueRejectingTypes);
        super(name, name, enabled, Nested.NO, dynamic, disableObjects, mappers, settings);
     * {@code isIncludeInParent} returning {@code true}.
        protected ObjectMapper createMapper(
        // Config is fully specified. Let the handler normalize it (e.g. inject its own type when the
                Map<String, Object> dynPropsNode = (Map<String, Object>) fieldNode;
                    BuilderContext builderContext = new BuilderContext(indexSettings, new ContentPath(1));
                    compositeField = fieldNode;
    public static final int MAX_DYNAMIC_PROPERTIES = 50;
        }
    /**
                    dynamicTemplateInvalid = false;
     */
        return null;
    public RootObjectMapper merge(Mapper mergeWith, MergeReason reason) {
        protected Explicit<DynamicTemplate[]> dynamicTemplates = new Explicit<>(new DynamicTemplate[0], false);
            }
                    lastError = new IllegalArgumentException("Unused mapping attributes [" + fieldTypeConfig + "]");
            builder.endArray();
                    dynamicProperties.add(new DynamicProperty(pattern, mapping));
            // No document is available at index creation, so the supplier's get() throws. A complete
     */
        // On a pluggable data format index, multi_value on a type that does not support it is an error, as in a
                @SuppressWarnings("unchecked")
            "dynamic template ["
                List<?> tmplNodes = (List<?>) fieldNode;
        String dynamicType = matchType.defaultMappingType();
                ContextAwareGroupingFieldMapper.CONTENT_TYPE,
            Nested nested,
                if (dynamicPropertyPatternsOverlap(p1.getPattern(), p2.getPattern())) {
                            "No handler for type [" + type + "] declared for dynamic_property pattern [" + pattern + "]"
            if (contextAwareGoupingField != null) {
                    Map.Entry<String, Object> entry = tmpl.entrySet().iterator().next();
                Mapper.Builder<?> dummyBuilder = typeParser.parse(templateName, fieldTypeConfig, parserContext);
 *
        Mapper.TypeParser.ParserContext parserContext
            throw new MapperParsingException("failed to find type parsed [" + mappingType + "] for [" + name + "]");
     * True iff some field name matches both glob patterns (same semantics as {@link Regex#simpleMatch}).
            }
                    Mapper.TypeParser typeParser = parserContext.typeParser(type);
                    String pattern = entry.getKey();
        return Operations.isEmpty(Operations.intersection(a1, a2)) == false;
        // The plugin type was validated against the registry at parse time, so a handler is always present.
                if (fieldName.equals("composite")) {
                    break;
    public BytesReference deriveSource(LeafReader leafReader, int docId) throws IOException {
            types = XContentFieldType.values();
                }
import org.opensearch.common.settings.Settings;
                        );
                } else {
                }
            // config never reads the field value, so this is a no-op normalization (e.g. type injection).
import org.apache.lucene.index.LeafReader;
            if (checkMultiValue) {
        for (DynamicProperty dp : dynamicProperties.value()) {
import java.util.Set;
        @Override
            builder.startObject("dynamic_properties");
import java.util.TreeMap;
            if (reason == MergeReason.MAPPING_RECOVERY) {
        }
     * throws on it. Probing alone keeps an unrelated invalid parameter from being reported as a multi_value error.
public class RootObjectMapper extends ObjectMapper {
     * at index-creation time.
        if (dynamicTemplateInvalid) {
        }
    private static boolean containsSnippet(List<?> list, String snippet) {
                if ((fieldNode instanceof List) == false) {
                dynamicTemplates,
                            "dynamic_properties pattern [*] is not allowed; use a more specific pattern that still contains [*]. "
                + "] maps to type "
import org.opensearch.index.mapper.MapperService.MergeReason;
            // existing patterns (same as INDEX_TEMPLATE). Recovery applies persisted mapping as-is.
            }
        public Mapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
     */
            @Nullable Settings settings
            String defaultDynamicType = contentFieldType.defaultMappingType();
    }
import org.apache.lucene.util.automaton.Automaton;
            Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);
    @Override
                parserContext,
            if (typeParser == null) {
            if (fieldName.equals("date_formats") || fieldName.equals("dynamic_date_formats")) {
                return dynamicTemplate;
            RootObjectMapper.Builder builder = new Builder(name);
                    builder.dynamicDateTimeFormatter(Collections.emptyList());
        }
    public DynamicTemplate[] dynamicTemplates() {
        @Override
    }
            && Mapper.isPluggableDataFormatEnabled(parserContext.getSettings())) {
                    + dynamicProperties.size()
        super.doMerge(mergeWith, reason);
        return dynamicDateTimeFormatters.value();
            // violates that contract, treat it as non-fatal and defer validation to document-parse time
                    builder.dynamicDateTimeFormatter(Collections.singleton(parseDateTimeFormatter(fieldNode)));
        }
        // builtin path does.
/*
    }
    }
    }
    }
                for (Map.Entry<String, Object> entry : dynPropsNode.entrySet()) {
import org.opensearch.OpenSearchException;
                if (fieldTypeConfig.isEmpty()) {
                return true;
                        if (formatter.toString().startsWith("epoch_")) {
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);
                collectFullPaths(child, paths);
            Explicit<Boolean> disableObjects,
        if (dynamicProperties.size() > MAX_DYNAMIC_PROPERTIES) {
    private Explicit<DynamicTemplate[]> dynamicTemplates;
        String mappingType = dynamicTemplate.mappingType(pluginType);
        return false;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
                Nested nested = child.nested();
    RootObjectMapper(
        }
        update.dynamicProperties = new Explicit<>(new DynamicProperty[0], false);
    }
    /**
     */
                List<DynamicProperty> merged = new ArrayList<>(byPattern.values());
        }
     * fully specified. In that case we hand the config to the plugin's {@link Mapper.TypeParser}, and
import org.opensearch.core.xcontent.ToXContent;
        RootObjectMapper mergeWithObject = (RootObjectMapper) mergeWith;
        Map<String, Object> probe = new HashMap<>();
        }
     * Validates that no explicitly mapped field path is matched by any dynamic_property pattern.
            } else {
    private static final String DYNAMIC_TEMPLATE_NAME_PREFIX = "__dynamic__";
 * license agreements. See the NOTICE file distributed with
                // "match" : "*_test",
            super(name);
                Strings.toString(MediaTypeRegistry.JSON, dynamicTemplate)
        }
 * this work for additional information regarding copyright
                for (Object tmplNode : tmplNodes) {
            if (mapper instanceof ObjectMapper) {
 */
    private static boolean typeAcceptsMultiValue(
 *
            objBuilder.add(mapperBuilder);
        if (dateDetection.explicit() || includeDefaults) {
import org.opensearch.core.common.bytes.BytesReference;
                    throw new MapperParsingException("Dynamic template syntax error. An array of named objects is expected.");
                if (containsSnippet((Map<?, ?>) value, snippet)) {
        if (mergeWithObject.dynamicTemplates.explicit()) {
        }
        );
    /**
    }
                String valueString = (String) value;
            return;
                if (typeAcceptsMultiValue(typeParser, templateName, fieldTypeConfig, parserContext)) {
            Object value = entry.getValue();
            builder.startArray("dynamic_templates");
        }
import java.util.List;
                if (includeInRootViaParent && includedInRoot) {
    private static boolean dynamicPropertyPatternsOverlap(String pattern1, String pattern2) {
        public Builder(String name) {
 * specific language governing permissions and limitations
                builder.value(dateTimeFormatter.pattern());
                        throw new MapperParsingException(
    private Mapper.Builder findTemplateBuilder(ParseContext context, String name, XContentFieldType matchType, DateFormatter dateFormat) {
                if (fieldNode instanceof List) {
                    + "] exceeds the maximum allowed ["
                builder.startObject();
        try {
                    byPattern.put(dp.getPattern(), dp);
        }
    @Override
        if (typeParser == null) {
        return false;
    private Explicit<DynamicProperty[]> dynamicProperties;
            return;
    }
    }
            }
        Mapper.TypeParser typeParser,
        final XContentFieldType[] types;
            // Important : Composite field is made up of 2 or more source properties of the index, so this must be called
                deprecationMessage = String.format(Locale.ROOT, "%s, caused by [%s]", message, lastError.getMessage());
            RootObjectMapper root = (RootObjectMapper) super.build(context);
                }
        }
                + "]"
                Map<String, DynamicProperty> byPattern = new LinkedHashMap<>();
                lastError = new IllegalArgumentException("No mapper found for type [" + mappingType + "]");
     */
                    return true;
                builder.dynamicProperties(dynamicProperties);
 * The root object mapper for a document
        Explicit<DynamicTemplate[]> dynamicTemplates,
        public Builder dynamicDateTimeFormatter(Collection<DateFormatter> dateTimeFormatters) {
                    contextAwareGoupingField = fieldNode;
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
                this.dynamicProperties = new Explicit<>(merged.toArray(new DynamicProperty[0]), true);
                    nested.setIncludeInRoot(false);
        if (dynamicTemplate == null) {
@PublicApi(since = "1.0.0")
            validateNoExplicitFieldMatchesDynamicProperty();
                            + path
        }
        }
        this.dateDetection = dateDetection;
     */
                settings
    }
import org.apache.logging.log4j.Logger;
}
                // }
                }
                + ParametrizedFieldMapper.MULTI_VALUE_PARAMETER
    public static class TypeParser extends ObjectMapper.TypeParser {
        return (RootObjectMapper) super.merge(mergeWith, reason);
        String name,
                fieldTypeConfig.remove("type");
        boolean multiValueAccepted = false;
            throw new OpenSearchException("Failed to derive source for doc id [" + docId + "]", e);
    private Explicit<Boolean> numericDetection;
            String name,
            // after parsing all other properties
            this.dynamicDateTimeFormatters = new Explicit<>(dateTimeFormatters.toArray(new DateFormatter[0]), true);
            throw multiValueNotSupported(dynamicTemplate.getName(), Set.of(mappingType));
                for (DynamicProperty dp : this.dynamicProperties.value()) {
            Map<String, Object> fieldTypeConfig = dynamicTemplate.mappingForName(templateName, defaultDynamicType);
        Map<String, Object> mappingConfig = dynamicTemplate.mappingForName(name, dynamicType);
        update.numericDetection = new Explicit<>(Defaults.NUMERIC_DETECTION, false);
 * not use this file except in compliance with the License.
                }
                enabled,
                numericDetection,
                }
import java.util.Iterator;
            }
            this.dynamicProperties = new Explicit<>(dynamicProperties.toArray(new DynamicProperty[0]), true);
    private static void fixRedundantIncludes(ObjectMapper objectMapper, boolean parentIncluded) {
                builder.dateDetection = new Explicit<>(nodeBooleanValue(fieldNode, "date_detection"), true);
        }
        this.dynamicProperties = dynamicProperties;
                // ]
                parseObjectOrDocumentTypeProperties("disable_objects", disableObjectsNode, parserContext, builder);
        }
        return dynamicTemplates.value();
    private static boolean containsSnippet(Map<?, ?> map, String snippet) {
        for (String path : explicitPaths) {
                            + p1.getPattern()
            ParserContext parserContext
        for (Mapper mapper : objectMapper) {
                    return true;
                    templates.add(template);
    private static void collectFullPaths(ObjectMapper obj, List<String> paths) {
            return this;
            return false;
            String templateName = DYNAMIC_TEMPLATE_NAME_PREFIX + dynamicTemplate.name();
                if (valueString.contains(snippet)) {
        update.dynamicDateTimeFormatters = new Explicit<>(Defaults.DYNAMIC_DATE_TIME_FORMATTERS, false);
            root.validateNoExplicitFieldMatchesDynamicProperty();
            String message = String.format(
                if (containsSnippet((List<?>) value, snippet)) {
            while (mappers.hasNext()) {
            } else if (value instanceof String) {
                    return true;
import org.opensearch.common.xcontent.XContentFactory;
            builder.field("date_detection", dateDetection.value());
    private static void validateDynamicTemplate(Mapper.TypeParser.ParserContext parserContext, DynamicTemplate dynamicTemplate) {
                + templateName
                    Map<String, Object> tmpl = (Map<String, Object>) tmplNode;
                ),
                return true;
            Object compositeField = null;
                    templatesByKey.put(template.name(), template);
    }
            if (disableObjectsNode != null) {
                    Map<String, Object> templateParams = (Map<String, Object>) entry.getValue();
            }
    }
import java.util.Collections;
                }
     *
                    for (Object formatter : (List<?>) fieldNode) {
 *
    /**
import org.apache.lucene.util.automaton.Operations;
            // not a leaf segment; prefix + name() would incorrectly produce parent.parent.child.
 * You may obtain a copy of the License at
import org.opensearch.common.logging.DeprecationLogger;
            // Can't validate template, because field names can't be guessed up front.
                return true;
                // "dynamic_templates" : [
            // Config relies on data-derived parameters; it can only be validated once a document is seen.
                                + "To apply one default mapping to all unknown field names, use dynamic_templates instead."
                    }
            }
import java.util.LinkedHashMap;
        protected Explicit<DynamicProperty[]> dynamicProperties = new Explicit<>(new DynamicProperty[0], false);
        public Builder dynamicProperties(Collection<DynamicProperty> dynamicProperties) {
     * @return a mapper builder, or null if there is no template for such a field
                    iterator.remove();
     * @param matchType   the type of the field in the json document or null if unknown
                + ", which does not support ["
                    byPattern.put(dp.getPattern(), dp);
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.util.Locale;
        }
            }
            }
        collectFullPaths(this, explicitPaths);
        return findTemplateBuilder(context, name, matchType, null);
            probe.put("type", fieldTypeConfig.get("type"));
            if (dp.matches(fullFieldName)) {
        final String pathAsString = path.pathAsText(name);
            this.dynamicDateTimeFormatters = mergeWithObject.dynamicDateTimeFormatters;
            // A complete config performs no I/O and must not read the field value. If a handler
                dynamicTemplate.getName(),
        if (mergeWithObject.dynamicDateTimeFormatters.explicit()) {
                    List<DateFormatter> formatters = new ArrayList<>();
    /**
                List<DynamicProperty> dynamicProperties = new ArrayList<>();
    }
    private static void validatePluginDynamicTemplate(Mapper.TypeParser.ParserContext parserContext, DynamicTemplate dynamicTemplate) {
        }
    /**
            Mapper.TypeParser typeParser = parserContext.typeParser(ContextAwareGroupingFieldMapper.CONTENT_TYPE);
        for (int i = 0; i < dynamicProperties.size(); i++) {
    public DynamicTemplate findTemplate(ContentPath path, String name, XContentFieldType matchType) {
            builder.field("numeric_detection", numericDetection.value());
        for (XContentFieldType contentFieldType : types) {
            if (reason == MergeReason.INDEX_TEMPLATE) {
    @Override
import org.apache.logging.log4j.LogManager;
                dateDetection,
        @Override
            }
            }
            builder.startArray("dynamic_date_formats");
                        "Cannot add explicit property ["
                DynamicTemplate[] mergedTemplates = templatesByKey.values().toArray(new DynamicTemplate[0]);
     * field mapping of the same type. Otherwise validation is deferred to document-parse time.
            && Mapper.isPluggableDataFormatEnabled(parserContext.getSettings());
            return;
            this.builder = this;
            if (lastError != null) {
                deprecationMessage = message;
            }
        List<String> explicitPaths = new ArrayList<>();
            if (value instanceof Map) {
            return;
            builder.endArray();
                    return true;
        // {name} placeholders can't be resolved until a concrete field name is known — skip, as the
        }
     * @param dateFormat  a dateformatter to use if the type is a date, null if not a date or is using the default format
 * KIND, either express or implied.  See the License for the
        } catch (Exception e) {
        String templateName,
        if (reason != MergeReason.MAPPING_RECOVERY) {
        protected Explicit<DateFormatter[]> dynamicDateTimeFormatters = new Explicit<>(Defaults.DYNAMIC_DATE_TIME_FORMATTERS, false);
                fixRedundantIncludes(child, includeInRootViaParent || includedInRoot);
import org.opensearch.common.Nullable;
        }
        Map<String, Object> fieldTypeConfig = dynamicTemplate.mappingForName(templateName, pluginType);
                return dp;
                String fieldName = entry.getKey();
        if (numericDetection.explicit() || includeDefaults) {
     * the type parser (not core) reports any invalid content, exactly as it would for an explicit
        public static final boolean DATE_DETECTION = true;
        Mapper.Builder builder = typeParser.parse(name, mappingConfig, parserContext);
            );
                    dynamicTemplate.getName()
        } else {
            while (iterator.hasNext()) {
import org.opensearch.common.time.DateFormatter;
            DynamicProperty p1 = dynamicProperties.get(i);
                            + dp.getPattern()
     * Removes redundant root includes in {@link ObjectMapper.Nested} trees to avoid duplicate
                }
                    if (typeNode == null) {
     * template. Such templates cannot be validated up front, so we only validate eagerly when the
                } else if ("none".equals(fieldNode.toString())) {
            for (int j = i + 1; j < dynamicProperties.size(); j++) {
                dynamicProperties,
     * mapping root (same as field names in queries), not simpleName + manual prefix concatenation.
 * The OpenSearch Contributors require contributions made to
     * the first indexed document rather than declared in the
                    }
import java.util.TreeSet;
                            + p2.getPattern()
     * Parses only {@code type} and {@code multi_value} with the type's own parser. A parser removes each key it
                    if (template.getPluginMatchType() == null) {
            }
        this.dynamicDateTimeFormatters = dynamicDateTimeFormatters;
import java.io.IOException;
        if (dynamicTemplates.explicit() || includeDefaults) {
            } else if (value instanceof List) {
    private Explicit<DateFormatter[]> dynamicDateTimeFormatters;
        return this.dateDetection.value();
        if (dynamicProperties.value().length == 0) {
    }
 * under the License.
                }
    public ObjectMapper mappingUpdate(Mapper mapper) {
            } else if (fieldName.equals("dynamic_properties")) {
import java.util.ArrayList;
                        throw new MapperParsingException("dynamic_properties pattern [" + pattern + "] must contain a wildcard [*].");
                Map<String, DynamicTemplate> templatesByKey = new LinkedHashMap<>();
        // for dynamic updates, no need to carry root-specific options, we just
            return root;
     * Returns the first dynamic property that matches the given field name, or null.
    @SuppressWarnings("rawtypes")
        if (checkMultiValue && multiValueAccepted == false && multiValueRejectingTypes.isEmpty() == false) {
                name,
            // Merge by pattern key for live mapping updates and templates so a partial PUT does not drop
                } else {
                contextAwareGroupingNode,
    public boolean numericDetection() {
                            + "] and ["
     */
                    }
                }
                if (valueString.contains(snippet)) {
            } else {
                    }
            }
        }
                builder.field(dp.getPattern(), dp.getMapping());
                String valueString = (String) value;
        return update;
            }
    public static class Defaults {
                            throw new MapperParsingException("Epoch [" + formatter + "] is not supported as dynamic date format");
                    "Deferring index-creation validation of dynamic template [{}]: its handler threw while "
                }
 * GitHub history for details.
        Settings settings
        String mappingType = dynamicTemplate.mappingType(dynamicType);
        // content and reports any invalid config.
        try {
/**
        }
    }
        DynamicTemplateTypeHandler handler = parserContext.mapperService().getDynamicTemplateTypes().get(pluginType);
                return true;
        fixRedundantIncludes(this, true);
    protected void doXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
            return this;
                    return true;
                    Object typeNode = mapping.get("type");
        Map<String, Object> fieldTypeConfig,
        }
                    if ((entry.getValue() instanceof Map) == false) {
        protected boolean processField(RootObjectMapper.Builder builder, String fieldName, Object fieldNode, ParserContext parserContext) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else if (value instanceof List) {
        if (dynamicProperties.explicit() || includeDefaults) {
    public Mapper.Builder findTemplateBuilder(ParseContext context, String name, DateFormatter dateFormatter) {
        return BytesReference.bytes(builder);
        if (fieldTypeConfig.containsKey("type")) {
        String pluginType = dynamicTemplate.getPluginMatchType();
            } else if (fieldName.equals("date_detection")) {
 */
            this.dateDetection = mergeWithObject.dateDetection;
            assert !nested.isNested();
        return null;
            DateFieldMapper.getDefaultDateTimeFormatter(),
                parseCompositeField(builder, (Map<String, Object>) compositeField, parserContext);
                () -> new ParameterizedMessage(
                }
                return true;
                    );
        }
            }
    ) {
                    return true;
                        templateParams,
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext(dateFormat);
     * itself included into a parent node, for which either {@code isIncludeInRoot} is
        Explicit<Boolean> disableObjects,
        }
        Explicit<Boolean> dateDetection,
                        throw new MapperParsingException("No type specified for dynamic_property pattern [" + pattern + "]");
                    String type = typeNode.toString();
            try {
        } finally {
    public boolean dateDetection() {
                if ((fieldNode instanceof Map) == false) {
        // covers templates that could not be checked when they were created, such as those using {name}.
            for (DynamicTemplate dynamicTemplate : dynamicTemplates.value()) {
            logger.warn(
                    );
    }
            }
            } else if (fieldName.equals("numeric_detection")) {
                // "mapping" : { "type" : "keyword", "store" : "yes" }
            Dynamic dynamic,
                    nested.setIncludeInParent(true);
                builder.dynamicTemplates(templates);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            handler.adjustMappingConfig(fieldTypeConfig, FieldValueParserSupplier.withoutValue());
                // {
     * Type parser for the root object
    private void validateNoExplicitFieldMatchesDynamicProperty() {
                for (DynamicTemplate template : mergeWithObject.dynamicTemplates.value()) {
                List<DynamicTemplate> templates = new ArrayList<>();
                    if (parseObjectOrDocumentTypeProperties(fieldName, fieldNode, parserContext, builder)
                boolean includeInRootViaParent = parentIncluded && isNested && nested.isIncludeInParent();
                        throw new MapperParsingException("dynamic_properties entry [" + pattern + "] must have a mapping object as value.");
                    } else {
        // A parser removes each key it consumes, so a leftover multi_value means the type ignored it. This also
            } else {
                + new TreeSet<>(types)
        }
    }
     * Default parameters for root object
            String key = entry.getKey().toString();
    }
        for (DynamicTemplate dynamicTemplate : dynamicTemplates.value()) {
                }
                validateDynamicProperties(merged);
                    );
    /**
import java.util.Map;
    }
        if (dynamicDateTimeFormatters.explicit() || includeDefaults) {
                for (DynamicTemplate template : this.dynamicTemplates.value()) {
import org.opensearch.core.xcontent.XContentBuilder;
                            + "]. Explicit fields cannot overlap with dynamic_properties."
        }
            return null;
        return new MapperParsingException(
     * @opensearch.internal
        }
                this.dynamicTemplates = mergeWithObject.dynamicTemplates;
        return this.numericDetection.value();
            if (mapper instanceof ObjectMapper child) {
     */
import org.opensearch.common.regex.Regex;
                DynamicProperty p2 = dynamicProperties.get(j);
        for (Object value : list) {
                lastError = e;
                } else if (fieldName.equals(ContextAwareGroupingFieldMapper.CONTENT_TYPE)) {
        public Builder dynamicTemplates(Collection<DynamicTemplate> templates) {
                    templatesByKey.put(template.name(), template);
                parseContextAwareGroupingField(builder, (Map<String, Object>) contextAwareGoupingField, parserContext);
    }
    ) {
        } catch (IllegalStateException | IOException e) {
        Explicit<Boolean> enabled,
                }
                objBuilder
            Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator();
        boolean checkMultiValue = dynamicTemplate.getMapping().containsKey(ParametrizedFieldMapper.MULTI_VALUE_PARAMETER)
     * {@code true} or which is transitively included in root by a chain of nodes with
     * is also capped at {@link #MAX_DYNAMIC_PROPERTIES} to bound the O(n²) overlap-detection cost.
                    throw new MapperParsingException(
                Locale.ROOT,
                if (containsSnippet((Map<?, ?>) value, snippet)) {
            }
        }
import java.util.HashMap;
                // "template_1" : {
        for (Mapper mapper : obj) {
/*
        try {
            );
                        validatePluginDynamicTemplate(parserContext, template);
     * @opensearch.internal
                builder.numericDetection = new Explicit<>(nodeBooleanValue(fieldNode, "numeric_detection"), true);
        }
                    }
                for (DynamicProperty dp : mergeWithObject.dynamicProperties.value()) {
        protected Explicit<Boolean> dateDetection = new Explicit<>(Defaults.DATE_DETECTION, false);
            Iterator<Mapper> mappers = this.iterator();
     * @opensearch.internal
                    + "]."
            throw new MapperParsingException(
            // ObjectMapper.name() and FieldMapper.name() both return the full path (e.g. parent.child),
            DateFormatter.forPattern("yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis") };
     */
     * consumes, so the key is left behind when the type does not support it, whether the parser ignores it or
    public DynamicProperty[] dynamicProperties() {
                }
            DEPRECATION_LOGGER.deprecate("invalid_dynamic_template_" + dynamicTemplate.getName(), deprecationMessage);
import java.util.Collection;
    /**
                }
        }
        if (mergeWithObject.dynamicProperties.explicit()) {
                Mapper mapper = mappers.next();
        public static final boolean NUMERIC_DETECTION = false;
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
            // Only the leftover key decides; e.g. scaled_float consumes multi_value, then fails on its missing scaling_factor.
                    Settings indexSettings = parserContext.mapperService().getIndexSettings().getSettings();
        return findTemplateBuilder(context, name, XContentFieldType.DATE, dateFormatter);
    /**
            }
     * @param name        the field name
            Explicit<Boolean> enabled,
                }
            builder.endObject();
                        validateDynamicTemplate(parserContext, template);
     * Validates {@code dynamic_properties}. The bare pattern {@code *} is rejected at parse time; overlap
     * Per the dynamic_properties contract, explicit properties cannot overlap with dynamic patterns.
            return new RootObjectMapper(
     * Validates a dynamic template whose {@code match_mapping_type} is a plugin-registered type
                    String templateName = entry.getKey();
                        throw new MapperParsingException(
                builder.field(dynamicTemplate.name(), dynamicTemplate);
    }
                        parserContext.mapperService().getDynamicTemplateTypes()
                        iterator.remove();
    private static final Logger logger = LogManager.getLogger(RootObjectMapper.class);
                        "dynamic_properties must be an object with pattern keys and mapping objects as values."
                mappers,
                "The number of dynamic_properties patterns ["
    }
package org.opensearch.index.mapper;
                    iterator.remove();
 * software distributed under the License is distributed on an
        if (typeParser == null) {
                Map.Entry<String, Object> entry = iterator.next();
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
     * Maximum number of {@code dynamic_properties} patterns allowed in a single mapping. Kept low by default
     * because overlap detection is O(n²) in the number of patterns; raising this limit also raises that cost.
            Map<String, Object> contextAwareGroupingNode,
        }
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);
        Set<String> multiValueRejectingTypes = new TreeSet<>();
        }
    @Override
 * this file be licensed under the Apache-2.0 license or a
                    if ("*".equals(pattern)) {
                    multiValueAccepted = true;
            Object contextAwareGoupingField = null;
                        );
     */
                    if (tmpl.size() != 1) {
import org.opensearch.common.annotation.PublicApi;
        Map<String, Mapper> mappers,
    @SuppressWarnings("rawtypes")
        } catch (Exception e) {
        if (containsSnippet(dynamicTemplate.getMapping(), "{name}")) {
        ) {
        }
                ObjectMapper child = (ObjectMapper) mapper;
        // template omitted it) — a complete config never reads the field value, so the supplier is
 * compatible open source license.
                // "match_mapping_type" : "string",
                builder.endObject();
                if (containsSnippet((List<?>) value, snippet)) {
        final boolean includeDefaults = params.paramAsBoolean("include_defaults", false);
            } else if (value instanceof String) {
            Mapper.Builder<?> mapperBuilder = typeParser.parse(
                e
    private static void validateDynamicProperties(List<DynamicProperty> dynamicProperties) {
        RootObjectMapper update = (RootObjectMapper) super.mappingUpdate(mapper);
        if (containsSnippet(dynamicTemplate.getMapping(), "{name}")) {
import org.apache.logging.log4j.message.ParameterizedMessage;
                return true;
                            + "] overlap (both can match the same field name)."
            this.dynamicTemplates = new Explicit<>(templates.toArray(new DynamicTemplate[0]), true);
            );
    }
                mapper.deriveSource(builder, leafReader, docId);
        if (dynamicProperties.isEmpty()) {
                        formatters.add(parseDateTimeFormatter(formatter));
        if (mergeWithObject.dateDetection.explicit()) {
                        || processField(builder, fieldName, fieldNode, parserContext)) {
                    }
        // applied at merge time
                    if (typeParser == null) {
            return builder;
        // never invoked at index-creation time. Then hand it to the type parser, which validates the
                    Map<String, Object> mapping = new TreeMap<>((Map<String, Object>) entry.getValue());
        }
                    );
                }
            if (compositeField != null) {
        typeParser.parse(templateName, fieldTypeConfig, parserContext);
    /**
            final String deprecationMessage;
        public RootObjectMapper build(BuilderContext context) {
     *
            typeParser.parse(templateName, probe, parserContext);
        update.dateDetection = new Explicit<>(Defaults.DATE_DETECTION, false);
                } else {
            if (key.contains(snippet)) {
            for (DateFormatter dateTimeFormatter : dynamicDateTimeFormatters.value()) {
        boolean dynamicTemplateInvalid = true;
        }
                this.dynamicProperties = mergeWithObject.dynamicProperties;
                        }
        }
                boolean includedInRoot = isNested && nested.isIncludeInRoot();
    }
        if (dynamicTemplate.getXContentFieldType() != null) {
    }
        Dynamic dynamic,
            this.numericDetection = mergeWithObject.numericDetection;
import static org.opensearch.index.mapper.TypeParsers.parseDateTimeFormatter;
                    }
            if (path.isEmpty()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        ) {
        String templateName = DYNAMIC_TEMPLATE_NAME_PREFIX + dynamicTemplate.getName();
     *
     * Builder for the root object
    public void fixRedundantIncludes() {
