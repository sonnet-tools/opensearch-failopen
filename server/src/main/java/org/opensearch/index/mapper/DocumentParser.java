    /**
            }
                                parentMapper.fullPath()
 * specific language governing permissions and limitations
        final String[] resolvedPaths = paths != null ? paths : splitAndValidatePath(fieldName);
 * Licensed to Elasticsearch under one or more contributor
    }
        Mapping mapping,
                    Mapper fieldMapper = mapper.getMapper(currentFieldName);
    private static boolean parsesArrayValue(Mapper mapper) {
            throw new IllegalArgumentException("Cannot write to a field alias [" + mapper.name() + "].");
        // If a dynamic_property matches this field, use it without updating the index mapping (no cluster state update;
                context.path().remove();
            } finally {
            } else {
    }
        ObjectMapper.Dynamic dynamic,
        return false;
    ) {
        throws IOException {
                    // This is the single convergence point where we know the field name, the
                break;
        ParseContext.Document nestedDoc = context.doc();
        String[] nameParts,
            processDynamicMappingForDisableObjects(context, parentMapper, fieldName, token);
                copyAction.accept(copyToContext, field);
                            parseArray(context, mapper, currentFieldName, paths);
        }
    }
            ObjectMapper objectMapper = parentMapperTuple.v2();
                throw new MapperParsingException("No mapper found for extra field [" + fullPath + "]");
                        continue;
import java.util.Locale;
        Mapper cached = context.lookupDynamicPropertyMapper(fullPath);
            }
            }
                    }
        List<ObjectMapper> parentMappers = new ArrayList<>();
                    return handleNoTemplateFound(dynamic, () -> newFloatBuilder(currentFieldName, context.indexSettings().getSettings()));
        Mapper.Builder<?> builder = typeParser.parse(resolvedFieldName, inferredFieldMapping, parserContext);
            // Object mode: use existing nested object parsing logic
        XContentParser originalParser = context.parser();
    private static Tuple<Integer, ObjectMapper> getDynamicParentMapper(
        XContentParser.Token token
                    case STRICT:
                                context,
        }
                    + MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey()
        if (efv.isEmpty()) {
        }
        if (mapping.root.isEnabled() == false) {
                for (int i = 0; i < added; i++) {
                    + dynamicProperty.getPattern()
    }
    }
                }
            boolean parseableAsDouble = false;
                // These cases are handled below
                    + dynamicProperty.getPattern()
            parser.skipChildren();
        }
                    + fullPath
        }
        Mapper mapper = context.docMapper().mappers().getMapper(field);
                        context.addDynamicMapper(mapper);
        if (token != null) {
        // This can happen when intermediate object mappers are created during dynamic mapping
    private static void parseDisableObjectsFields(ParseContext context, ObjectMapper mapper) throws IOException {
    }
                    processFieldWithDisableObjects(context, mapper, currentFieldName, fieldMapper, token);
        // Only fire for dynamic=TRUE / STRICT_ALLOW_TEMPLATES / FALSE_ALLOW_TEMPLATES
            case START_OBJECT:
            parseCopyFields(context, fieldMapper.copyTo().copyToFields());
                    if (parsesArrayValue(mapper)) {
        DynamicFieldTypeInferencer claimingInferencer = null;
            } else if (token == XContentParser.Token.START_ARRAY) {
                XContentParser innerParser = parser.contentType()
                    + " no field associated with it, current value ["
                if (builder == null) {
        }
                        "object field starting or ending with a [.] makes object resolution ambiguous: [" + fullFieldPath + "]"
        ObjectMapper.Dynamic dynamic,
        return builderSupplier.get();
     * all funnel through {@link #parseNonDynamicArray}. The only array route that bypasses it is a
            context.seqID(),
        if (mapper.isEnabled() == false) {
        for (int i = 0; i < paths.length - 1; i++) {
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();
                templateMatchedType = entry.getKey();
                throw new IllegalArgumentException("Cannot copy to a field alias [" + mapper.name() + "].");
        if (context.indexSettings().isPluggableDataFormatEnabled() == false) {
                if (Strings.hasText(part) == false) {
    }
        // the type of the nested doc starts with __, so we can identify that its a nested one in filters
            }
            // For example, if we processed a.b, followed by an object mapper a.c.d, and now are adding a.c.d.e
            return null;
        Mapper.TypeParser typeParser = parserContext.typeParser(type);
    }
        String fieldName,
    private static void parseNonDynamicArray(ParseContext context, ObjectMapper mapper, final String lastFieldName, String arrayFieldName)
        ParseContext.InternalParseContext context,
            } else if (numberType == XContentParser.NumberType.FLOAT
            parseCopyFields(context, fieldMapper.copyTo().copyToFields(), childBytes);
                    + "] in dynamic_property pattern ["
            context.docs(),
        // Check if root has disable_objects=true
                    "Dynamic field type inferencer [{}] returned type [{}] for field [{}] outside its declared supportedTypes(); ignoring the claim",
                                    "object mapping for ["
        final ParseContext context,
                                currentFieldName,
        ParseContext.Document parentDoc = nestedDoc.getParent();
        String[] paths
            if (parts.length == 0) {
                parseableAsDouble = true;
                    break;
        ObjectMapper mapper,
            return null;
                    switch (token) {
    }
     * limit, caches the mapper, and parses the field value.
    }
                return true;
        if (claimingInferencerSupportedTypes.contains(inferredType) == false) {
    /**
        );
                    for (int i = 0; i < parentMapperTuple.v1(); i++) {
        // Step 3: No template — use inferencer result directly.
                logger.warn(
import org.opensearch.core.common.Strings;
    private static void validateEnd(XContentParser parser) throws IOException {
        }
     * Adds a mapper as an update into the last mapper. If merge is true, the new mapper
            nestedDoc.add(new Field(IdFieldMapper.NAME, idField.binaryValue(), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
        } finally {
            if (om != null && om.nested().isNested()) {
        if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
    }
                token = parser.nextToken();
        if (context.docMapper() != null && context.docMapper().mappers() != null) {
                if (mapper != null) {
        final Mapping mapping = docMapper.mapping();
                            dynamic,
 * The OpenSearch Contributors require contributions made to
            throw new MapperParsingException(
     * Offers an unmapped field to all registered plugin inferencers and plugin-registered dynamic template types
                assert targetDoc != null;
    ) throws IOException {
            for (String part : parts) {
            }
                ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);
            update = pathMappers.get(i).mappingUpdate(update);
                        objectMapper = builder.build(builderContext);
                default:
     * @param name          the simple field name being parsed (last path component)
            objToken = xParser.nextToken();
            updateParentName = lastParent.name() + '.' + nameParts[i];
                                parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
            }
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), fieldFullPath, name);
import java.util.ArrayList;
            mapper = objectMapper.getMapper(subfields[i]);
        // Step 2: No template matched — run the inferencers as the auto-detection fallback.
            metadataMapper.postParse(context);
     * {@code _source} is later reconstructed from the columns. Registering an empty list lets the
        }
        Map<String, Object> inferredFieldMapping = null;
                    case FALSE_ALLOW_TEMPLATES:
                    }
        Map<String, DynamicTemplateTypeHandler> templateTypes
                    "object mapping for ["
    private static ParseContext nestedContext(ParseContext context, ObjectMapper mapper) {
            // fields which are updated, we cannot simply add the existing mappers to the stack, since they
                parseCopy(field, parserSwitchedContext);
                        + "] with array for ["
        }
                        }
                assert token.isValue();
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.BINARY, dynamic, fullPath);
            token = parser.nextToken();
        // block array values for composite index fields
        }
                Double.parseDouble(text);
                        );
        Mapper mapper = context.docMapper().mapping().getMetadataMapper(fieldPath);
    ) throws IOException {
            Mapper newMapper = dynamicMapperItr.next();
                                return new Tuple<>(pathsAdded, parent);
        Mapper mapper = getMapper(context, parentMapper, lastFieldName, paths);
            context.path().add(currentFieldName);
            innerParseObject(context, mapper, parser, currentFieldName, token);
                                arrayFieldName
            // Parse the field using a fresh parser over the captured bytes.
    private static String[] splitAndValidatePath(String fullFieldPath) {
        }
                ParseContext.Document targetDoc = null;
                            mapper.fullPath(),
        }
            throw new IllegalStateException(
            default:
        // not the nested Lucene documents! Besides the fact that we would have zombie Lucene documents, the ordering of
                }
     * Adds mappers from the end of the stack that exist as updates within those mappers.
        }
    ) throws IOException {
        String pluginType = entry.getKey();
        try (
        List<ObjectMapper> parentMappers,
        Mapper newMapper
            if (field.name().equals(nestedPathFieldName) == false) {
        int pathsAdded = 0;
        }
            throw new MapperParsingException(
        ParseContext context,
            // For example, if the first mapper processed was a.b.c, and we now have a.d, the stack will contain
import org.opensearch.core.xcontent.MediaType;
                                context.parser().skipChildren();
                    case STRICT_ALLOW_TEMPLATES:
                // A buggy inferencer must not break document parsing, but the failure must be visible:
                            throw new StrictDynamicMappingException(
        if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
        String[] fullNameParts = splitAndValidatePath(newMapper.name());
        final String[] paths,
                            + claimingInferencer.getClass().getName()
                    throw new MapperParsingException(
                                dynamic.name().toLowerCase(Locale.ROOT),
                );
                }
            assert intermediate != null : "Field " + previousIntermediate.name() + " does not have a subfield " + nameParts[i];
        Mapper.Builder templateBuilder = null;
                                context.indexSettings().getSettings()
    private static ObjectMapper createUpdate(ObjectMapper parent, String[] nameParts, int i, Mapper mapper) {
        } else {
     *   <li>No inferencers registered ({@code inferencers.isEmpty()}) — zero overhead.</li>
        return mapper instanceof FieldMapper fieldMapper && fieldMapper.parsesArrayValue();
                                parseValue(context, mapper, currentFieldName, token, paths);
                parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
            context.decrementFieldCurrentDepth();
    /**
        if (mapper.disableObjects()) {
        } else {
     * a {@code multi_value} {@link FieldMapper}, so stock indexing is unaffected.
                parseObjectOrField(context, cached);
        byte[] rawContent;
            case START_ARRAY:
 * GitHub history for details.
                        case FALSE:
                                parentMapper.fullPath(),
     * Returns the next unprocessed index from nameParts.
        Mapper leaf = getMapper(context, mapper, lastFieldName, paths);
            return null;
        if (mapper != null) {
                for (DateFormatter dateTimeFormatter : context.root().dynamicDateTimeFormatters()) {
                    parseNullValue(replayContext, parentMapper, fieldName, replayPaths);
     * otherwise it is merged into the existing root entry.
        String remainingPath = context.path().pathAsText("");
                if (templateBuilder != null) {
                )
            } else if (parseableAsLong == false && parseableAsDouble == false && context.root().dateDetection()) {
            // This means the ObjectMapper is receiving a concrete value instead of an object
        ObjectMapper updateParent = docMapper.objectMappers().get(updateParentName);
     * before the normal token-type branching takes place in {@link #innerParseObject}.
            if (existingFieldMapper != null) {
        if (shouldHandleAsDisableObjects(docMapper, firstNameParts)) {
        if (remainingPath.isEmpty() == false) {
        Mapper.Builder builder = context.root().findTemplateBuilder(context, name, dateFormat);
                context.parser().skipChildren();
     * are present when the mapper is constructed. Handlers whose config is already complete never call
     */
        return parent.mappingUpdate(mapper);
    }
                            );
                    // switch below via the early-return inside tryPluginInference.
            // We first need the stack to only contain mappers in common with the previously processed mapper
                    + "], expected ["
    }
                    copyToContext = context.switchDoc(targetDoc);
                }
        switch (existingMapper) {
                break;
        popMappers(parentMappers, 1, true);
            return;
            throw new MapperParsingException("failed to find type parsed [" + mappingType + "] for [" + name + "]");
                        parseObjectOrField(context, mapper);
                            if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
            && ((isNested == false && context.mapperService().isFieldPartOfCompositeIndex(arrayFieldName))
                // Instead, treat the remaining path as a flat field name and add the mapper directly
        } else if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
        // then arrays in nested/nested.nested1 and nested.nested1.status fields should be blocked
            if (child instanceof ObjectMapper om) {
                            } else if (token.isValue()) {
    private static ObjectMapper createExistingMapperUpdate(
                ObjectMapper parent = docMapper.objectMappers().get(parentPath);
                            + "]. Expected format: an object containing flat dotted field names with their values."
                    currentFieldName = parser.currentName();
     * @param fieldValueParser produces a fresh parser over the buffered field bytes
    private static void processFlattenedTokenForDisableObjects(
            // from the existing mappings. In order to maintain the invariant that the stack only contains
                entry,
                        if (builder == null) {
                fieldMapper.parse(innerContext);
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
            return mapper;
        DateFormatter dateFormat,
        // pre-deserialized object. Core stays free of any representation contract: each plugin streams
                    mapper.name(),
        Map<DynamicFieldTypeInferencer, Set<String>> inferencers = context.mapperService().getDynamicFieldTypeInferencers();
    }
        int keepBefore = 1;
                    throw new MapperParsingException(
                    + "] index setting or reduce the number of distinct dynamic fields."
    private static void parseObjectOrField(ParseContext context, Mapper mapper) throws IOException {
                    case FALSE:
        String fieldFullPath
        if (dynamicMappers.isEmpty()) {
        // but will throw a JSON exception if the extra tokens is not valid JSON (this will be handled by the catch)
            case FieldMapper fm -> {
        return createUpdate(updateParent, nameParts, i + 1, newMapper);
     * mapper with {@link FieldMapper#parsesArrayValue()} true (geo/completion), which no
        }
                    + "] as object, but found a concrete value"
                                    context.parser().skipChildren();
        // Check if the first mapper should be handled as a disable_objects literal field
        ParseContext context,
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();
                            builder = new ObjectMapper.Builder(paths[i]).enabled(true);
            context.documentInput().addField(fieldMapper.fieldType(), List.of());
    }
                                        + "] as object, but got EOF, has a concrete value been provided to it?"
        // off the stack, merging them upwards into the existing mappers.
            String[] paths = null;
        return i;
        try {
        MetadataFieldMapper[] metadataFieldsMappers,
                return builder;
                .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), rawContent)
            // to maintain proper JSON parsing state
        // Check nested object mappers
            parentMappers.add(createUpdate(mapping.root(), firstNameParts, 0, firstUpdate));
            if (parseableAsLong && context.root().numericDetection()) {
                    }
        // threshold. Template matching is already scoped by the user's match/path_match patterns
        String fullPath
        }
    /**
                    + "] matched field ["
                    disableObjectsIndex = k;
                addFields(indexVersion, nestedDoc, rootDoc);
                            } else {
        if (idField != null) {
                    // corrupt for subsequent fields in the same document.
            return false;
                    + "]. Expected a field mapper or object mapper."
                token = parser.nextToken();
        return objectMapper.getMapper(subfields[subfields.length - 1]);
                parseNullValue(context, mapper, lastFieldName, paths);
        ExtraFieldValues efv = context.sourceToParse().extraFieldValues();
                            throw new MapperParsingException(
                return ObjectMapper.Dynamic.TRUE;
        ObjectMapper parentMapper,
        } finally {
    private static Mapper.Builder findTemplateBuilder(
        final boolean emptyDoc = isEmptyDoc(mapping, parser);
        return new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.LONG, settings);
                .xContent()
        if (mapper.isEnabled() == false) {
                parseNonDynamicArray(context, parentMapper, fieldName, fieldName);
                fieldMapper.parse(context);
                for (ParseContext.Document doc = context.doc(); doc != null; doc = doc.getParent()) {
                token = parser.nextToken();
        }
        while (objToken != XContentParser.Token.END_OBJECT) {
                } else {
            parentMappers.add(last);
                    + fullPath
    ) throws IOException {
import java.util.Map;
        if (!docMapper.root().disableObjects()) {
            if (token == XContentParser.Token.END_OBJECT) {
                    return handleNoTemplateFound(dynamic, () -> newLongBuilder(currentFieldName, context.indexSettings().getSettings()));
                } else {
    private static void addFields(Version indexVersion, ParseContext.Document nestedDoc, ParseContext.Document rootDoc) {
                        throw new StrictDynamicMappingException(
                            break;
    private static Mapper.Builder<?> newFloatBuilder(String name, Settings settings) {
    private static void parseCopyFieldsInternal(
            parentMappers.add(update);
                    + "]"
                                if (parsesArrayValue(mapper)) {
    ) {
            replayParser.nextToken(); // position at value start
                                DateFieldMapper.Resolution.MILLISECONDS,
        boolean isNested = path.contains(".") || context.mapperService().isCompositeIndexFieldNestedField(path);
    /** Creates an copy of the current field with given field name and boost */
        ParseContext context,
                return true;
     * mapper. This runs before TypeParser so that parameters that can only be inferred from the data
    private static Mapper.Builder<?> handleNoTemplateFound(
        }
        if (builder == null && dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
                                    context.path().remove();
                    currentPath,
                            + "]; the inferred type is ambiguous"
            addToLastMapper(parentMappers, mapper, false);
    private static void processDynamicMappingForDisableObjects(
                                    + context.path().pathAsText(paths[i])
            );
            } else {
        // Normal traversal with disable_objects check
import static org.opensearch.index.mapper.FieldMapper.IGNORE_MALFORMED_SETTING;
    private static java.util.function.Supplier<Mapper.Builder<?>> builderSupplierForText(String fieldName, ParseContext context) {
                    currentFieldName = parser.currentName();
        }
                                ignoreMalformed,
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.STRING, dynamic, fullPath);
            } else {
            // may have other subfields which will not be updated. Instead, we pull the mapper from the existing
                                    + "]) through `copy_to` or dots in field names"
            throw new MapperParsingException(
        parseObjectOrField(context, mapper);
            context.addDynamicMapper(templateMapper);
            if (builder == null) {
        handler.adjustMappingConfig(mappingConfig, fieldValueParser);
            parseObjectOrField(context, mapper);
                        targetDoc = doc;
        return builder;
    // Throws exception if no dynamic templates found but `dynamic` is set to strict_allow_templates
        XContentParser parser = context.parser();
    ) {
import java.util.HashMap;
        // Root ObjectMapper#fullPath is the internal mapping-type name "_doc", which must not prefix index field names.
        for (int i = 0; i < subfields.length - 1; ++i) {
        final String resolvedFieldName = resolvedPaths[resolvedPaths.length - 1];
        // params) before the TypeParser builds the mapper.
            metadataMapper.preParse(context);
                        dateTimeFormatter.parse(text);
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parentMapper.fullPath(), currentFieldName);
            );
import org.apache.lucene.document.Field;
     */
                throw new MapperParsingException("Field [" + fullPath + "] does not support extra field ingestion");
                newMapper.merge(previousMapper);
                String.format(
        if (token == XContentParser.Token.VALUE_NULL) {
        if (merge) {
        // Traverse from root to the disable_objects parent
            }
            );
                    if (builder == null) {
            }
            }
        }
            for (String field : copyToFields) {
        ) {
                            + mapper.name()
        }
                "dynamic_property pattern ["
     * {@code multi_value} type currently is; if that ever changes, that route needs equivalent
            }
        ObjectMapper.Dynamic dynamic = parentMapper.dynamic();
        boolean sawElement = false;
                );
     * Handles existing mapper processing for disable_objects mode.
                    );
    ) {
        Map<String, DynamicTemplateTypeHandler> templateTypes = context.mapperService().getDynamicTemplateTypes();
            if (mapper == null) {
     */
        ObjectMapper update = disableObjectsParent.mappingUpdate(newMapper);
        parentMappers.set(lastIndex, withNewMapper);
                );
            return;
                    }
        assert updateParent != null : updateParentName + " doesn't exist";
            }
        }
            final String[] parts = splitAndValidatePath(fullPath);
    private static void popMappers(List<ObjectMapper> parentMappers, int keepBefore, boolean merge) {
     * Handles dynamic mapping for new fields in disable_objects mode.
            }
        }
                        token = parser.nextToken();
            )
            parseDynamicValue(context, parentMapper, currentFieldName, token);
                return null;
            } else {
        }
                            if (builder == null) {
                        .map(field -> groupingCriteriaParams.get(field).toString())
        // Handle null values
                    if (containsDisabledObjectMapper(mapper, paths)) {
    private static void parseCopyFields(ParseContext context, List<String> copyToFields, byte[] sourceBytes) throws IOException {
            } else if (token == null) {
        String fieldName,
                    break;
        }
        int i,
        try (
                if (token == XContentParser.Token.FIELD_NAME) {
                        case STRICT:
        // Hand plugins a factory that produces a fresh parser over the buffered bytes rather than a
    private static void validateNoNestedParents(ParseContext context, String fullPath, String[] parts) {
            }
    }
            parseDynamicValue(context, mapper, mapper.fullPath(), token);
    }
                context,
     */
                }
     * written null — collapsing the distinction between {@code []} and a missing field when
        ObjectMapper resolvedParent,
            }
     * released by the caller's {@code finally}, so this method only manages the field-name slot it adds
                context.documentInput().endNestedElement();
            objectMapper = objMapper;
    }
                    } catch (OpenSearchParseException | DateTimeParseException | IllegalArgumentException e) {
    @SuppressWarnings("rawtypes")
     */
            Mapper intermediate = previousIntermediate.getMapper(nameParts[i]);
                            + resolvedFieldName
                    + limit
        }
     * <ul>
                    + "] tried to parse field ["
                // finally so the pairing holds even when parsing the element fails midway.
                            context.indexSettings().getSettings(),
                ParseContext replayContext = context.switchParser(replayParser);
                            dynamic,
        context.rememberDynamicPropertyMapper(fullPath, mapper);
        for (int i = 1; i < parts.length; i++) {
            }
        token = parser.nextToken();
     * with a factory that produces a fresh parser over the buffered field bytes, so the handler can
                                        + "] tried to parse field ["
                    "Cannot add a value for field [" + fullPath + "] since one of the intermediate objects is nested: [" + parent + "]"
                }
    }
        Mapper existingMapper,
            Mapper existingFieldMapper = context.docMapper().mappers().getMapper(currentPath);
package org.opensearch.index.mapper;
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), mapper.fullPath(), fieldName);
        // Check if mapper is a metadata mapper first
                mediaType
            parseDynamicValue(context, objectMapper, fieldName, context.parser().currentToken());
    }
        if (objectMapper.nested().isNested() && context.indexSettings().isPluggableDataFormatEnabled()) {
        XContentParser.Token token
                            context.indexSettings().getSettings(),
                // One mapping is missing, check if we are allowed to create a dynamic one.
        String fieldFullPath
                    case FALSE:
            }
            Mapper newLast = last.getMapper(nameParts[i]);
            if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
        return keepBefore - 1;
        List<ObjectMapper> pathMappers = new ArrayList<>();
        ObjectMapper mapper = currentParent == null ? context.root() : currentParent;
                fieldMapper.addMultiValueMappingUpdate(context);
            if (!(mapper instanceof FieldMapper fm) || !fm.supportsExtraFieldValues()) {
                throw new IllegalArgumentException("field name cannot contain only the character [.]");
                innerParser.nextToken();
            builder.copyCurrentStructure(parser);
                    + currentFieldName
            XContentParser parser = copyToContext.parser();
                return builder;
            );
                inferredFieldMapping = claim;
            try {
            throw new IllegalArgumentException("Malformed content, found extra data after parsing: " + token);
            case VALUE_BOOLEAN:
    ) {
                            context,
        // This is the path for fields with no user-defined template: each inferencer checks whether
                            builder = new ObjectMapper.Builder(currentFieldName).enabled(true);
                        case START_OBJECT:
                    break;
import org.apache.lucene.index.IndexableField;
                    if (Strings.isEmpty(part) == false) {
        final Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
                if (parent != null && parent.disableObjects()) {
        } else if (mapper instanceof FieldAliasMapper) {
        } else if (leaf instanceof FieldMapper fieldMapper && fieldMapper.fieldType().isMultiValued()) {
        }
            // a.b, and we want to merge b back into the stack so it just contains a
                context.path().remove();
        int disableObjectsIndex = 0;
                        context.path().remove();
        return new MapperParsingException("failed to parse", e);
            // Subsequent mapper — merge with existing root update
            );
                    + "] but its mapping has no [type]"
                    .xContent()
            throw wrapInMapperParsingException(source, e);
     * making the SPI genuinely generic rather than array-specific.
                parseValue(context, mapper, lastFieldName, token, paths);
    private static void parseCopyFields(ParseContext context, List<String> copyToFields) throws IOException {
        Collections.sort(dynamicMappers, (Mapper o1, Mapper o2) -> o1.name().compareTo(o2.name()));
        }
     * {@code get()}, so no parsing happens for fully-specified templates.
        // try to parse the next token, this should be null if the object is ended properly
            );
                    // we serialize the array components
                            return new DateFieldMapper.Builder(
            for (int i = 0; i < parentMapperTuple.v1(); i++) {
            }
                if (inferredFieldMapping != null) {
        return new ParsedDocument(
        for (; i < nameParts.length - 1; ++i) {
    private static Mapper getMapper(final ParseContext context, ObjectMapper objectMapper, String fieldName, String[] subfields) {
            for (int i = 0; i < parentPathSlots; i++) {
                    lastFieldName = arrayFieldName;
        try {
                        + fieldName
                case START_OBJECT:
            if (i < nameParts.length - 1) {
            String[] parts = fullFieldPath.split("\\.");
        String currentFieldName,
            return;
                        + mapper.name()
 * this work for additional information regarding copyright
    /** Creates an update for intermediate object mappers that are not on the stack, but parents of newMapper. */
                            // TODO: shouldn't this skip, not parse?
        }
                    () -> new ParameterizedMessage(
        }
        String fieldName,
                        case FALSE_ALLOW_TEMPLATES:
                ParseContext parserSwitchedContext = copyToContext.switchParser(innerParser);
        popMappers(parentMappers, keepBefore, true);
        throws IOException {
            popMappers(parentMappers, 1, false);
    }
                break;
        } else {
                            parent.fullPath()
            final Mapper mapper = context.docMapper().mappers().getMapper(ContextAwareGroupingFieldMapper.CONTENT_TYPE);
            documentInput
        return true;
        try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {
                    try {
        // documents inside the Lucene index (document blocks) will be incorrect, as nested documents of different root
        );
        }
import org.opensearch.OpenSearchParseException;
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(mapper, context);
        if (builder == null && dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
                LoggingDeprecationHandler.INSTANCE,
            // then the stack will only have a on it because we will have already merged a.c.d into the stack.
        Map<String, Object> mappingConfig = dynamicTemplate.mappingForName(name, pluginType);
            if (!(mapper instanceof ObjectMapper objMapper)) {
        String currentFieldName,
        }
        } else {
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.LONG, dynamic, fullPath);
            }
            logger.warn(
                        flatFieldName.append(".");
     * this the field would be absent from the document input and its LIST column cell would be
                                if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
                parseObjectOrNested(context, om);
            parseObjectOrField(context, mapper);
                    + dynamicProperty.getPattern()
            validateNoNestedParents(context, fullPath, parts); // nested docs not supported
                Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, mapper);
            update,
        XContentParser.Token token;// only check for end of tokens if we created the parser here
    }
            String parentPath = String.join(".", java.util.Arrays.copyOf(nameParts, k));
                // not a double number
    }
                parseFieldWithCopyTo(context, fm);
            // In disable_objects mode, we should treat this as a field with the mapper's full name
    }
                    "Could not dynamically add mapping for field [{}]. Existing mapping for [{}] must be of type object but found [{}].",
                        "Document structure incompatibility: Unexpected end of document while parsing field ["
     * writer emit a zero-length, non-null list instead.
            XContentParser replayParser = contentType.xContent()
        // and inner hits to fail or yield incorrect results.
            case VALUE_NULL:
                    + "]"
                }
        }
                            break;
            case END_OBJECT:
import org.opensearch.core.common.bytes.BytesReference;
            // delete it when the root document is deleted too.
                subfields = new String[] { flatFieldName.toString() };
                        return handleNoTemplateFound(dynamic, () -> {
 *
    }
        // if its already a mapper parsing exception, no need to wrap it...
            }
        try {
            }
                source.source(),
                        resolvedFieldName
            }
    }
            // Handle both disable_objects and object modes internally based on parentMapper's disable_objects setting
        return parsedDocument(source, context, createDynamicUpdate(mapping, docMapper, context.getDynamicMappers()), documentInput);
        SourceToParse source,
        // documents are then aligned with other root documents. This will lead tothe nested query, sorting, aggregations
                    }
        if (inferredFieldMapping == null) {
                rootDoc.add(field);
        // Throw a more meaningful message if the document is empty.
        return new Tuple<>(pathsAdded, mapper);
    }
        Object typeNode = config.get("type");
                        );
        ObjectMapper.Dynamic dynamic,
                        .stream()
                if (builder == null) {
import java.time.format.DateTimeParseException;
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.LONG, dynamic, fullPath);
                    + "]"
            if (builder == null) {
        ObjectMapper.Nested nested = mapper.nested();
                continue;
        } finally {
            // After parseChildToBytes, the original parser has consumed the full structure.
            rawContent
    }
            try {
        }
                newMapper = createExistingMapperUpdate(parentMappers, nameParts, i, docMapper, newMapper);
        MediaType contentType = parser.contentType();
    private static void registerEmptyMultiValueArray(ParseContext context, ObjectMapper mapper, String lastFieldName, String[] paths) {
                        "Skipping dynamic field type inferencer [{}]: it threw while inspecting field [{}]",
            assert token == XContentParser.Token.FIELD_NAME || token == XContentParser.Token.END_OBJECT;
            XContentParser.NumberType numberType = context.parser().numberType();
        while (keepBefore < parentMappers.size() && parentMappers.get(keepBefore).simpleName().equals(nameParts[keepBefore - 1])) {
                        .collect(Collectors.joining("-"));
                    }
                        case START_ARRAY:
        // then we should add the field directly to the last parent instead of trying to create intermediate objects
    }
 * A parser for documents, given mappings from a DocumentMapper
            "Can't handle serializing a dynamic type with content token [" + token + "] and field name [" + currentFieldName + "]"
            context.sourceToParse().id(),
                        parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
        XContentParser.Token token
        return builder;
            registerEmptyMultiValueArray(context, mapper, lastFieldName, paths);
                                    break;
                // Object mode: use existing object array parsing logic
                    );
/*
            } catch (NumberFormatException e) {
 * the Apache License, Version 2.0 (the "License"); you may
        Map.Entry<String, DynamicTemplateTypeHandler> entry,
     * Enforces the per-shard Lucene field-count limit for {@code dynamic_properties}. A field is
        // The handler completes the config (injects its own type when omitted, and any data-derived
        }
                    switch (dynamic) {
        }
                    // fires for unmapped fields; if the field has a mapper we skip directly to the
                break;
                        );
        final ObjectMapper lastParent = parentMappers.get(parentMappers.size() - 1);
     *
    static Mapping createDynamicUpdate(Mapping mapping, DocumentMapper docMapper, List<Mapper> dynamicMappers) {
        while (i < nameParts.length - 1 && last.getMapper(nameParts[i]) != null) {
            if (candidate != null) {
                    } else {
                    doc.setGroupingCriteria(criteria);
        }
     */
            context.path().add(paths[i]);
            default -> throw new MapperParsingException(
                context.path().add(resolvedFieldName);
            }
                        "field ["
        // We build a mapping by first sorting the mappers, so that all mappers containing a common prefix
    }
        if (dynamic == null) {
        this.docMapper = docMapper;
     */
        for (Map.Entry<DynamicFieldTypeInferencer, Set<String>> entry : inferencers.entrySet()) {
                    // expects an array, if so we pass the context straight to the mapper and if not
                        );
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
        Iterator<Mapper> dynamicMapperItr = dynamicMappers.iterator();
                StringBuilder flatFieldName = new StringBuilder();
                    // Before branching by token type, offer the field to plugin inferencers.
                    }
        // Replay buffered content through the new mapper
        String currentFieldName,
        String parent = parts[0];
        // so ContentPath is not left corrupt for subsequent fields in the same document.
                            + "] in object ["
        }
                    parseObjectOrField(replayContext, templateMapper);
        if (cached != null) {
                ObjectMapper parentMapper = parentMapperTuple.v2();
                            + "] was claimed by more than one dynamic field type inferencer: ["
}
        }
            }
        if (updateParent == null && lastParent.disableObjects()) {
        }
                        if (mapper.nested() != ObjectMapper.Nested.NO) {
                        return handleNoTemplateFound(
     * Handles flat field mapping by adding the mapper directly to the disable_objects parent.
    ) throws IOException {
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);
            final Mapper mapper = context.docMapper().mappers().getMapper(fullPath);
     * Determines if a field should be handled as a flat field based on disable_objects settings.
                                    context.indexSettings().getSettings(),
     */
    private static byte[] parseChildToBytes(ParseContext context) throws IOException {
        if (dynamicTemplate == null) {
                docMapperParser.getXContentRegistry(),
    }
                break;
            // The path of the dest field might be completely different from the current one so we need to reset it
        } finally {
    }
        flattenObjectFields(context, mapper, currentFieldName);
            );
        String[] firstNameParts = splitAndValidatePath(firstUpdate.name());
        // We evaluate ALL registered template types rather than stopping at the first match: if two
            context.checkFieldArrayDepthLimit();
                } finally {
                break;
        // Buffer the complete field value — needed for replay regardless of whether
        for (Map.Entry<String, DynamicTemplateTypeHandler> entry : templateTypes.entrySet()) {
            context = nestedContext(context, mapper);
                }
                    + context.parser().textOrNull()
        // Handle dynamic mapping for new fields
                }
        Mapper mapper = getMapper(context, parentMapper, currentFieldName, paths);
                fm.parse(externalCtx);
        ParseContext.Document nestedDoc = context.doc();
            } else if (token == XContentParser.Token.VALUE_NULL) {
        if (token == XContentParser.Token.END_OBJECT) {
            return true;
        }
                    paths = resolvePathForParsing(mapper, currentFieldName);
                    case TRUE:
        if (typeParser == null) {
    }
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
        ObjectMapper last = parentMappers.get(parentMappers.size() - 1);
                        inferencer.getClass().getName(),
    /**
                    arrayFieldName = paths[paths.length - 1];
     * This method is shared between object and array flattening operations.
                for (int i = 0; i < parentMapperTuple.v1(); i++) {
                    throw new IllegalArgumentException(
     *         content was replayed through the existing path); {@code false} to fall through to the normal
            }
        XContentParser.Token objToken = xParser.nextToken(); // Move to first field or END_OBJECT
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
                )
            throw new IllegalStateException("found leftover path elements: " + remainingPath);
            } else if (parseableAsDouble && context.root().numericDetection()) {
        throws IOException {
                        context.path().add(currentFieldName);
        String fullPath,
                    String criteria = groupingFieldMapper.fieldType()
            // mappings, and build an update with only the new mapper and its parents. This then becomes our
                // Success path only, so a failure here cannot mask the original parse exception.
                    parseObject(replayContext, parentMapper, fieldName, replayPaths);
            }
        return context;
        }
            processNullValueForDisableObjects(context, mapper, fieldName);
            ObjectMapper existingParent = docMapper.objectMappers().get(parentPath);
    private static void parseFieldWithCopyTo(ParseContext context, FieldMapper fieldMapper) throws IOException {
        XContentParser.Token token = context.parser().currentToken();
            // don't add it twice, if its included in parent, and we are handling the cluster-manager doc...
        throws IOException {
            if (nested.isNested()) {
                            context.path()
        for (IndexableField field : nestedDoc.getFields()) {
    }
        // case 2 : if nested.nested1.status is part of composite index and status is not part of composite index,
            throw new MapperParsingException(
        } else {
        }
            case START_OBJECT:
                    return builder;
                "The provided mapper [" + mapper.name() + "] has an unrecognized type [" + mapper.getClass().getSimpleName() + "]."
     * Only FieldMappers are added; ObjectMappers are skipped as they conflict with disable_objects.
        throw new IllegalStateException(
                            + currentFieldName
        return false;
                    "Unexpected token [" + objToken + "] while flattening object for field [" + fieldName + "]"
            return true;
            if (fieldMapper.fieldType().isMultiValued() == false) {
                case VALUE_NULL:
                return handleNoTemplateFound(dynamic, () -> new BinaryFieldMapper.Builder(currentFieldName));
    private static void parseNullValue(ParseContext context, ObjectMapper parentMapper, String lastFieldName, String[] paths)
        }
            context = new ParseContext.InternalParseContext(indexSettings, docMapperParser, docMapper, source, parser, documentInput);
            i = expandCommonMappers(parentMappers, nameParts, i);
            if (previousIntermediate.disableObjects()) {
                        context.parser().skipChildren();
        // Fast path: field is already mapped — let the normal path handle it
    private static void parseObjectForDisabledObjects(ParseContext context, ObjectMapper mapper, String currentFieldName)
            parseDisableObjectsFields(context, objectMapper);
        }
            try {
            } else if (token != XContentParser.Token.FIELD_NAME) {
            last = (ObjectMapper) newLast;
    }
    }
        if (token != XContentParser.Token.START_OBJECT) {
            final ObjectMapper om = context.docMapper().objectMappers().get(parent);
                if (token == XContentParser.Token.FIELD_NAME) {
    /**
            XContentParser parser = XContentHelper.createParser(
                throw new IllegalArgumentException("field name cannot be an empty string");
        ObjectMapper currentParent
        long limit = context.indexSettings().getMappingDynamicPropertiesLuceneFieldLimit();
        IndexableField idField = parentDoc.getField(IdFieldMapper.NAME);
import org.opensearch.core.xcontent.XContentBuilder;
        ) {
        if (token == XContentParser.Token.START_OBJECT) {
    private static void parseObject(final ParseContext context, ObjectMapper mapper, String currentFieldName, String[] paths)
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        } else {
        if (typeParser == null) {
                // Even with disable_objects, we can have nested ObjectMappers for explicitly defined sub-objects
        }
            Mapper child = current.getMapper(fullNameParts[i]);
            }
        );
            case FIELD_NAME:
    private static void validateStart(XContentParser parser) throws IOException {
                    + type
                                );
                            }
            }
        }
            context.incrementFieldCurrentDepth();
import java.util.Iterator;
    DocumentParser(IndexSettings indexSettings, DocumentMapperParser docMapperParser, DocumentMapper docMapper) {
            if (i == parts.length - 1) break;
                            parseNullValue(context, mapper, currentFieldName, paths);
        context = context.createNestedContext(mapper.fullPath());
    /**
                    break;
        XContentParser parser = context.parser();
                }
        context.addDynamicMapper(mapper);
                "dynamic_property pattern ["
            return true;
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);
            }
            if (!(mapper instanceof ObjectMapper objMapper)) {
        String fieldFullPath,
                handleDisableObjectsMapping(parentMappers, newMapper, docMapper, mapping);
        assert keepBefore >= 1; // never remove the root mapper
     * <p>Fast-path exits (no buffering, no deserialization):
        if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES && builder == null) {
    private static MapperParsingException wrapInMapperParsingException(SourceToParse source, Exception e) {
                context.path().remove();
        }
            } finally {
                final ContextAwareGroupingFieldMapper groupingFieldMapper = (ContextAwareGroupingFieldMapper) mapper;
                throw new MapperParsingException(
                templateBuilder = candidate;
            if (numberType == XContentParser.NumberType.INT
        assert currentFieldName != null;
                currentFieldName = paths[paths.length - 1];
            parseObjectOrNested(context, objectMapper);
    }
        for (MetadataFieldMapper metadataMapper : metadataFieldsMappers) {
        if (templateBuilder != null) {
                ParseContext innerContext = context.switchParser(innerParser);
     * Attempts to find a plugin-registered dynamic template whose {@code match_mapping_type} equals
        if (nested.isNested()) {
        }
                        case STRICT_ALLOW_TEMPLATES:
                parseArray(context, mapper, lastFieldName, paths);
            return;
            return builder;
                    }
        if (mapping.root.isEnabled()) {
        }
                parseObjectOrField(context, objectMapper);
                // Use parseNonDynamicArray which handles disable_objects mode properly
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;
        }
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
                                throw new MapperParsingException(
    @SuppressWarnings("rawtypes")
                ParseContext externalCtx = context.createExternalValueContext(value);
            XContentParser replayParser = originalParser.contentType()
        if (nested.isIncludeInParent()) {
            if (mapper instanceof FieldMapper fieldMapper) {
            );
     * This method consolidates the logic for field processing in disable_objects mode.
                "object mapping ["
                            }
                                        + currentFieldName
            try {
                        Mapper.Builder builder = findTemplateBuilder(
        } else {
            parseObjectOrField(context, mapper);
        if (existingMapper != null) {
        XContentParser.Token token = parser.currentToken();
                        context.addDynamicMapper(objectMapper);
        }
            parser.getDeprecationHandler(),
 * compatible open source license.
     *
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), sourceBytes)
            case VALUE_EMBEDDED_OBJECT:
        // on the DynamicTemplate, so it only fires for fields the user intended.
     */
                    case FALSE_ALLOW_TEMPLATES:
        } else if (objectMapper.disableObjects()) {
                                        + mapper.name()
        if ((token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT)
        // pop off parent mappers not needed by the current mapper,
            ParseContext replayContext = context.switchParser(replayParser);
    private static Mapper.Builder<?> createBuilderFromDynamicValue(
                    token = parser.nextToken();
    private static boolean attemptPluginInference(
     * Processes a field when disable_objects is enabled, handling both existing mappers and dynamic mapping.
        if (context.indexSettings().isCompositeIndex()
            }
        // Use ContentPath + leaf so the dotted name matches FieldMapper#name (built via pathAsText in FieldMapper.Builder).
/*
            context.documentInput().startNestedElement(mapper.fullPath());
        // ignore the claim and fall through to the existing dynamic-mapping path.
        ObjectMapper withNewMapper = parentMappers.get(lastIndex).mappingUpdate(mapper);
 *
        }
        // In disable_objects mode, we only want FieldMappers with dotted names
    private static void addToLastMapper(List<ObjectMapper> parentMappers, Mapper mapper, boolean merge) {
                                }
                break;
                        parser.skipChildren();
        // will be processed in a contiguous block. When the prefix is no longer seen, we pop the extra elements
        String mappingType = dynamicTemplate.mappingType(pluginType);
        Mapping update,
        String name,
        try {
            context.path().add(fieldName);
    }
     */
        Mapper newMapper,
    private static void flattenObjectFields(ParseContext context, ObjectMapper mapper, String fieldName) throws IOException {
 */
        if (dynamic == ObjectMapper.Dynamic.STRICT) {
                // corrupt for subsequent fields in the same document.
            }
        // Work backwards to root, wrapping each update
    /** Creates instances of the fields that the current field should be copied to */
        // If the mapper is an ObjectMapper, we cannot add it to a disable_objects parent
            generateGroupingCriteria(context);
                    case TRUE:
                            );
            context = context.overridePath(new ContentPath(0));
    private static void parseCopy(String field, ParseContext context) throws IOException {
        }
        if (typeNode == null) {
        final MediaType mediaType = source.getMediaType();
        }
                        + "] tried to parse as array, but got EOF, is there a mismatch in types for the same field?"
        if (currentFieldName == null) {
        if (docMapper.root().disableObjects()) {
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.DOUBLE, dynamic, fullPath);
    /**
    }
            for (int i = 0; i < parentPathSlots; i++) {
        List<String> copyToFields,
            }
        if (existingMapper != null) {
        // Handle concrete values - when disable_objects=true, we should treat the field name as a literal
            }
                    () -> new BooleanFieldMapper.Builder(currentFieldName, context.indexSettings().getSettings())
        String currentFieldName,
        throws IOException {
            parent = mapper;
            }
                    ),
                    Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.DOUBLE, dynamic, fullPath);
                );
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(resolvedParent, context);
            Mapper objectMapper = getMapper(context, mapper, currentFieldName, paths);
        ObjectMapper parentMapper,
                        parseValue(replayContext, parentMapper, fieldName, replayToken, replayPaths);
     *
            // If there are still parents of the new mapper which are not on the stack, we need to pull them
        final ParseContext context,
                // which document the field should go to
import java.util.Set;
                }
                    doc.setGroupingCriteria(script.execute(doc.getGroupingCriteriaParams()));
                    );
        DocumentInput documentInput
    @SuppressWarnings({ "rawtypes", "unchecked" })
                throw new MapperParsingException(
        Map<DynamicFieldTypeInferencer, Set<String>> inferencers,
                // foo did not yet exist. This will create 2 copies in dynamic mappings, which should be identical.
            }
            return;
            if (dynamicTemplate.matchesPluginType(pathAsString, name, pluginType)) {
            handleDisableObjectsMapping(parentMappers, firstUpdate, docMapper, mapping);
                );
                "Document structure incompatibility: Cannot parse field ["
    }
            addToLastMapper(parentMappers, parentMappers.remove(i), merge);
        // type strings its own plugin registered, so it may only produce a type it owns.
            } else if (mapper instanceof FieldAliasMapper) {
     * Handles existing field mapper parsing with proper path management.
            && !fieldMapper.copyTo().copyToFields().isEmpty()) {
            context.sourceToParse().source(),
        return false;
            );
    }
import org.opensearch.cluster.metadata.IndexMetadata;
     * Handles flattening of object tokens by iterating through fields and building dotted field names.
    /** Creates a Mapping containing any dynamically added fields, or returns null if there were no dynamic mappings. */
                );
                    case STRICT:
        }
            }
                    }
            }
        }
            parseDynamicValue(context, mapper, fieldName, token);
                        }
            if (builder == null) {
            } finally {
            }
    }
            } else {
        }
        ) {
            }
                    null,
                            () -> newFloatBuilder(currentFieldName, context.indexSettings().getSettings())
                            paths[i],
        if (typeParser == null) {
            }
        Mapper inferredMapper = builder.build(builderContext);
                for (int j = i + 1; j < subfields.length; j++) {
            } else {
            ) {
import org.apache.logging.log4j.Logger;
            case VALUE_NUMBER:
        parseCopyFieldsInternal(context, copyToFields, (copyToContext, field) -> parseCopy(field, copyToContext));
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.STRING, dynamic, fullPath);
            }
            // TODO: passing null to an object seems bogus?
                    .xContent()
    }
        // a plugin claims the field or not (streaming parser can only be read once)
                                }
     * <p>If a matching template is found, calls {@link DynamicTemplateTypeHandler#adjustMappingConfig}
                                    parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
            }
            contentType,
 *
        }
                    parseArray(replayContext, parentMapper, fieldName, replayPaths);
        context.postParse();
                    }
    }
     * the incoming token type, and the parser position are all known simultaneously — before the code fans
            addFields(indexVersion, nestedDoc, parentDoc);
     */
            context.decrementFieldCurrentDepth();
            // So we need to pull a.c, followed by a.c.d, onto the stack so e can be added to the end.
        }
        ObjectMapper mapper,
        throws IOException {
            // TODO: EFV is only allowed if JSON is absent (validation)
        return new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.FLOAT, settings);
        Mapper.Builder builder = context.root().findTemplateBuilder(context, name, matchType);
            return createUpdate(lastParent, nameParts, i, newMapper);
        }
     * Body of the plugin-inference attempt. Path slots added by {@code getDynamicParentMapper} are
 */
    private static Mapper.Builder<?> newLongBuilder(String name, Settings settings) {
            // No template and no inferencer claimed this field — fall through to existing path
            while (token != XContentParser.Token.END_OBJECT) {
                    context.path().remove();
                }
                                    context.path()
                new KeywordFieldMapper.Builder("keyword").ignoreAbove(256)
            XContentParser parser = context.parser();
                    context.path().remove();
            try {
            final String rejectedType = inferredType;
                            boolean ignoreMalformed = IGNORE_MALFORMED_SETTING.get(context.indexSettings().getSettings());
        assert parentMappers.size() >= 1;
 * Unless required by applicable law or agreed to in writing,
        return typeParser.parse(name, mappingConfig, parserContext);
        checkDynamicPropertiesLuceneFieldLimit(context, fullPath);
        FieldInfos fieldInfos = context.mapperService().getLuceneFieldTracker().getFieldInfos();
     * Returns the next unprocessed index from nameParts.
     * Processes a token during flattening, handling different token types appropriately.
                continue;
        // triage) rather than letting plugin load order silently pick a winner.
                        + "]"
        Version indexVersion = context.indexSettings().getIndexVersionCreated();
     * <p>When buffering does occur, the content is kept for replay: if no plugin claims the field, the
                switch (dynamic) {
            context.checkFieldDepthLimit();
    private static void nested(ParseContext context, ObjectMapper.Nested nested) {
    private static void internalParseDocument(
            objectMapper = objMapper;
final class DocumentParser {
                    // objects, and scalars rather than requiring three separate hooks. The hook only
            source.routing(),
    }
        // will result in START_OBJECT
            while (token != XContentParser.Token.END_OBJECT) {
    private static void parseDynamicPropertyValue(
            // Check for disable_objects and handle flattening
            throw new IllegalStateException("The root document of a nested document should have an _id field");
            context.incrementFieldArrayDepth();
            // Advance past START_OBJECT to get to the first field name
    private static final Logger logger = LogManager.getLogger(DocumentParser.class);
        ObjectMapper parentMapper,
        } else if (token.isValue()) {
    private static boolean shouldHandleAsDisableObjects(DocumentMapper docMapper, String[] nameParts) {
            // We just need to store the id as indexed field, so that IndexWriter#deleteDocuments(term) can then
import org.apache.lucene.index.FieldInfos;
            // add the new mapper to the stack, and pop down to the original parent level
                parseObject(context, mapper, lastFieldName, paths);
        }
    private static void parseExistingFieldMapper(ParseContext context, String fieldName, Mapper existingMapper) throws IOException {
                return true;
            parseObjectForDisabledObjects(context, mapper, currentFieldName);
    ) throws IOException {
                objToken = xParser.nextToken(); // Move to the value
    private static void parseDynamicValue(
    private static void parseArray(ParseContext context, ObjectMapper parentMapper, String lastFieldName, String[] paths)
            } finally {
     * Flattens nested objects into dotted field names.
        DynamicProperty dynamicProperty = context.root().findDynamicProperty(fullPath);
    // looks up a child mapper, but takes into account field names that expand to objects
            return BytesReference.toBytes(BytesReference.bytes(builder));
                String dottedFieldName = fieldName.isEmpty() ? nestedFieldName : fieldName + "." + nestedFieldName;
    }
        }
import org.opensearch.script.ContextAwareGroupingScript;
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), childBytes)
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), fieldFullPath, name);
                throw new MapperParsingException(
        ParseContext.InternalParseContext context,
                    + fieldName
            return;
        if (dynamic == ObjectMapper.Dynamic.FALSE) {
                    "Malformed content, after first object, either the type field" + " or the actual properties should exist"
     * "new" when it is absent from the last-refreshed {@link FieldInfos} snapshot; existing fields
        if (fullPath.equals(mapper.name()) == false) {
                }
                            }
            // "new mapper", and can be added to the stack.
        XContentParser.Token token;
                        "field ["
                } else {
     * Parses an object (disable_objects=true).
            try (
        try (
        }
     * This method treats dotted field names (e.g., "user.name", "metrics.cpu.usage")
            context.parser().skipChildren();
            // disable_objects mode: incorporate object flattening logic directly
    }
                    throw new MapperParsingException(
            }
                }
        Set<String> claimingInferencerSupportedTypes = null;
    }
                    .createParser(context.parser().getXContentRegistry(), context.parser().getDeprecationHandler(), rawContent)
        ObjectMapper.Dynamic dynamic,
                    + mapper.name()
 */
     *
        XContentParser.Token token = parser.nextToken();
            parentMappers.set(0, parentMappers.get(0).merge(update));
            if (nested.isNested() && context.indexSettings().isPluggableDataFormatEnabled()) {
                claim = inferencer.inferFieldType(fieldValueParser);
        XContentParser.Token token = parser.currentToken();
        // Step 1: Check plugin-registered dynamic templates first — explicit user intent beats
        ObjectMapper resolvedParent = parentMapperTuple.v2();
            parseExistingFieldMapper(context, fieldName, existingMapper);
        }
        if (!context.isWithinCopyTo() && copyToFields.isEmpty() == false) {
        if (existingMapper != null) {
                return handleNoTemplateFound(dynamic, builderSupplierForText(currentFieldName, context));
import org.opensearch.index.engine.dataformat.DocumentInput;
                            dynamic.name().toLowerCase(Locale.ROOT),
                context.path().remove();
            return true;
        final FieldValueParserSupplier fieldValueParser = new FieldValueParserSupplier(
    static void parseObjectOrNested(ParseContext context, ObjectMapper mapper) throws IOException {
            }
                // Build the full dotted field name by combining fieldName with current field name
            case END_ARRAY:
        if (context.indexSettings().isPluggableDataFormatEnabled()) {
        Mapping mapping
     */
    /** Scans dynamic templates on the root mapper for one whose {@code match_mapping_type} equals {@code pluginType} and whose path/name patterns match. */
     * out into {@code parseObject} / {@code parseArray} / {@code parseValue}. Placing the hook here means
                XContentParser innerParser = parser.contentType()
    private static int removeUncommonMappers(List<ObjectMapper> parentMappers, String[] nameParts) {
import org.opensearch.common.CheckedBiConsumer;
                // Release the field-name slot even if replay throws, so ContentPath is not left
                                IndexMetadata.indexCreated(context.indexSettings().getSettings()),
        // the tokens it needs. Plugins whose config is already complete never call get(), so no parsing
        return mapping.mappingUpdate(parentMappers.get(0));
            boolean parseableAsLong = false;
                    "object mapping for [%s] with array for [%s] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                context.path().remove();
    }
        }
        return dynamic;
                ParseContext.Document doc = context.doc();
    /**
    }
            context = context.createCopyToContext();
                } else if (token == null) {
 * ownership. Elasticsearch licenses this file to you under
    /**
        }
        ObjectMapper previousIntermediate = parent;
                            Mapper.Builder builder = findTemplateBuilder(
        final ParseContext context,
            return;
            try (
                String nestedFieldName = xParser.currentName();
        XContentParser parser
            ParseContext.Document rootDoc = context.rootDoc();
                        context.path().remove();
            XContentParser.Token replayToken = replayParser.currentToken();
     * Handles null value processing for disable_objects mode.
        }
                ParseContext copyToContext;
            return;
import java.io.IOException;
                claimingInferencerSupportedTypes = entry.getValue();
            if (previousMapper != null && newMapper.name().equals(previousMapper.name())) {
            if (shouldHandleAsDisableObjects(docMapper, nameParts)) {
                            if (token == null) {
    private static DynamicTemplate findPluginTemplate(RootObjectMapper root, ContentPath path, String name, String pluginType) {
            final XContentParser.Token token = parser.nextToken();
            throw new MapperParsingException(
 *
            context.version(),
            if (lastDotNdx == -1) {
        if (newMapper instanceof ObjectMapper) {
        } else if (emptyDoc == false) {
            return false;
    /**
    private static void parseObjectMapper(ParseContext context, ObjectMapper objectMapper) throws IOException {
import org.opensearch.common.collect.Tuple;
    ) {
        ObjectMapper parent = mapper;
            bufferBuilder.copyCurrentStructure(parser);
        }
        }
            }
                        + mapper.name()
import org.opensearch.common.time.DateFormatter;
                innerParser.nextToken();
     * This is shared logic used by multiple methods that need to flatten objects in disable_objects mode.
            return true;
        for (MetadataFieldMapper metadataMapper : metadataFieldsMappers) {
                }
     *   <li>Dynamic mapping is {@code STRICT} or {@code FALSE} on the parent object — existing behavior applies.</li>
                            mapper.fullPath()
        }
        if (parts.length <= 1) return;
                    }
            }
    }
        ObjectMapper disableObjectsParent = pathMappers.get(pathMappers.size() - 1);
        applyExtraFieldValues(context);
        }
                || numberType == XContentParser.NumberType.BIG_INTEGER) {
        // but arrays in status should not be blocked
            String arrayFieldName = lastFieldName;
     */
                    Locale.ROOT,
                pathMappers.add(om);
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
        if (fullFieldPath.contains(".")) {
                    existingFieldMapper.typeName()
            context.documentInput().addField(fieldMapper.fieldType(), List.of());
            previousMapper = newMapper;
            token = parser.nextToken();
            fieldMapper.parse(context);
            return attemptPluginInference(context, dynamic, resolvedParent, resolvedPaths, inferencers, templateTypes);
        this.docMapperParser = docMapperParser;
                        }
        DynamicTemplate dynamicTemplate = findPluginTemplate(context.root(), context.path(), name, pluginType);
        String name,
                // With disable_objects=true, we should not traverse further into the path
        // owned by a different plugin, or a type a sibling inferencer in the same plugin owns. Otherwise,
                        throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parent.fullPath(), paths[i]);
        }
            Map<String, Object> claim;
            }
                parseObjectOrField(replayContext, inferredMapper);
                        default:
    /**
     * @param entry         the plugin type string and its handler
            // the object is null ("obj1" : null), simply bail
                "The number of Lucene fields created by dynamic_properties has reached the limit ["
        // Build the update from the disable_objects parent back up to root
        // plugin types both match the same field, that is an ambiguous configuration and we fail
            Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, null);
     * Records an empty array ({@code "field": []}) for a pluggable-data-format field mapped with
        if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.FALSE) {
                        // failure to parse this, continue
        Map<String, Object> config = new HashMap<>(dynamicProperty.mappingForName(currentFieldName));
                    // Process different token types during object parsing
/*
            }
     * empty-array handling or {@code []} would collapse to an absent field there.
                }
                            + entry.getKey()
        String templateMatchedType = null;
            int added = 0;
        if (dynamicProperty != null) {
                        });
        }
            // For FALSE_ALLOW_TEMPLATES, if no template matches, we still need to consume the token
            // brackets exactly the element's fields. fullPath() (not nestedTypePath(), "__"-prefixed
            return () -> new TextFieldMapper.Builder(fieldName, context.mapperService().getIndexAnalyzers());
                            currentFieldName,
            if (claim != null) {
                    // incoming token type, and paths — before the code fans out to parseObject /
                || (isNested && context.mapperService().isCompositeIndexFieldNestedField(path)))) {
            parseObjectOrNested(context, objectMapper);
    /**
            }
    private final DocumentMapperParser docMapperParser;
        }
            currentFieldName = paths[paths.length - 1];
            );
                final ExtraFieldValue value = e.getValue();
                parseDynamicValue(context, parentMapper, fieldName, token);
        } else if (mapper instanceof FieldMapper fieldMapper) {
        ObjectMapper parentMapper,
 * Modifications Copyright OpenSearch Contributors. See
                throw new MapperParsingException(
        // loudly (per OpenSearch triage) rather than silently letting registration order decide.
                        + arrayFieldName
        ParseContext context,
            if (objectMapper.isEnabled() == false) {
    private static void handleDisableObjectsMapping(
            sawElement = true;
            }
                    + "] produced mapper with name ["
     *
            parentMapper = context.docMapper().objectMappers().get(parentName);
            case ObjectMapper om -> {
    ) throws IOException {
                    Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, dateTimeFormatter, dynamic, fullPath);
    private static ParsedDocument parsedDocument(
    }
    @SuppressWarnings("rawtypes")
        int lastIndex = parentMappers.size() - 1;
                "No handler for type ["
                    + "] with mapper type ["
        }
            String[] replayPaths = splitAndValidatePath(fieldName);
                            XContentFieldType.OBJECT,
        for (int i = parentMappers.size() - 1; i >= keepBefore; --i) {
                }
                parseableAsLong = true;
                || numberType == XContentParser.NumberType.DOUBLE
        }
            try {
                // but parentMappers needs an entry for subsequent merges.
            if (token == XContentParser.Token.START_OBJECT) {
 * You may obtain a copy of the License at
            final String[] paths = splitAndValidatePath(field);
                            + inferencer.getClass().getName()
     * @return {@code true} if this method consumed the parser (either a plugin claimed the field or the
    private static Mapper.Builder findPluginTemplateBuilder(
                    dynamic,
        }
     * Replays raw-buffered field content through the normal unmapped-field logic — dynamic
                        );
    }
        ObjectMapper.Dynamic dynamic = parentMapper.dynamic();
        } else {
            return;
    }
                            + resolvedFieldName
            if (objToken == XContentParser.Token.FIELD_NAME) {
                added++;
        }
        ParseContext context,
        }
    private static ObjectMapper.Dynamic dynamicOrDefault(ObjectMapper parentMapper, ParseContext context) {
        if (parentMappers.isEmpty()) {
                    "The provided mapper [" + mapper.name() + "] has an unrecognized type [" + mapper.getClass().getSimpleName() + "]."
            ParseContext replayContext = context.switchParser(replayParser);
            final String fieldName = paths[paths.length - 1];
                continue; // Skip the normal processing for this mapper
            switch (replayToken) {
            internalParseDocument(mapping, metadataFieldsMappers, context, parser);
            ) {
        // Handle object structures - advance past START_OBJECT to get to field parsing
 * this file be licensed under the Apache-2.0 license or a
        }
            context.decrementFieldArrayDepth();
        String currentFieldName = parser.currentName();
                replayParser.nextToken();
        if (context.indexSettings().isPluggableDataFormatEnabled()) {
        if (token == XContentParser.Token.VALUE_NULL) {
        if (nested.isIncludeInRoot()) {
            if (parentMapper.disableObjects()) {
            // Pluggable formats need the per-element scope even with disable_objects set; vanilla keeps
        return null;
                    return handleNoTemplateFound(dynamic, () -> newLongBuilder(currentFieldName, context.indexSettings().getSettings()));
        return parseDocument(source, metadataFieldsMappers, null);
        // We need to add the uid or id to this nested Lucene document too,
     * </ul>
                // We can see the same mapper more than once, for example, if we had foo.bar and foo.baz, where
                    flatFieldName.append(subfields[j]);
     * {@code multi_value: true}. The element loop above never fires for an empty array, so without
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            // First mapper — add directly
        XContentParser parser = context.parser();
                            dynamic,
            return new MapperParsingException("failed to parse, document is empty");
                                mapper = builder.build(builderContext);
            // Unknown type — fall through to existing path rather than failing
        }
        } finally {
                final ContextAwareGroupingScript script = groupingFieldMapper.fieldType().compiledScript();
        // happens for them.
        String nestedPathFieldName = NestedPathFieldMapper.name(indexVersion);
                    String.join(".", paths),
    private static boolean isEmptyDoc(Mapping mapping, XContentParser parser) throws IOException {
     * templates, parseDynamicValue, parseNonDynamicArray — as if the buffer had never been created.
        XContentParser parser = context.parser();
                                break;
        XContentParser parser = context.parser();
        }
    }
            String currentPath = context.path().pathAsText(paths[i]);
        this.indexSettings = indexSettings;
                fieldMapper.parse(context);
     * reuse their Lucene slot and are not counted again. Throws {@link MapperParsingException} if
        Mapper.Builder<?> builder = typeParser.parse(currentFieldName, config, parserContext);
            if (token == XContentParser.Token.START_OBJECT) {
                            parseObject(context, mapper, currentFieldName, paths);
        XContentParser.Token token,
                    claimingInferencerName,
        ParseContext context,
                    context.path().remove();
    /**
                            XContentFieldType.OBJECT,
    private static void replayThroughExistingPath(ParseContext context, ObjectMapper parentMapper, String fieldName, byte[] rawContent)
        Mapper existingMapper = getMapper(context, parentMapper, fieldName, paths);
     */
    ) {
            final String fullPath = e.getKey();
                // Here we just skip over the duplicates, but we merge them to ensure there are no conflicts.
        if (e instanceof MapperParsingException mapperParsingException) {
        // case 1 : if status is part of composite index and nested.nested1.status is not part of composite index,
        }
                );
            return;
                if (script != null) {
            return new String[] { fullFieldPath };
                return builder;
    private static Mapper.Builder findTemplateBuilder(
                .createParser(originalParser.getXContentRegistry(), originalParser.getDeprecationHandler(), rawContent)
                    ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);
                        break;
     * rather than expanding them into nested object hierarchies.
            } catch (Exception e) {
                }
                // If parentMapper is ever null, it means the parent of the current mapper was dynamically created.
            previousIntermediate = (ObjectMapper) intermediate;
    }
                // Use parseNonDynamicArray which now handles disable_objects mode
            for (int i = 0; i < parts.length - 1; i++) {
                        break;
                                XContentFieldType.OBJECT,
    private static void innerParseObject(
                    + mapper.name()
        } else {
        }
        throws IOException {
            // if we are at the end of the previous object, advance
                    rejectedType,
                        case VALUE_NULL:
            // Then we need to add back mappers that may already exist within the stack, but are not on it.
                }
                }
                    Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, parentMapper);
                || numberType == XContentParser.NumberType.BIG_DECIMAL) {
        context.path().add(currentFieldName);
        }
                    if (j > i + 1) {
                        continue;
                        // since this is much more space-efficient and should be enough most of
 * SPDX-License-Identifier: Apache-2.0
    /**
        String[] resolvedPaths,
        if (mapper != null) {
                processFlattenedTokenForDisableObjects(context, mapper, dottedFieldName, objToken);
     *         token-type switch in {@code innerParseObject}.
     * <p>Reached from every scalar-leaf array route — top-level, nested, and disable_objects arrays
        java.util.function.Supplier<Mapper.Builder<?>> builderSupplier
                flattenObjectFields(context, parentMapper, fieldName);
        for (DynamicTemplate dynamicTemplate : root.dynamicTemplates()) {
            }
                                } else {
        Mapper previousMapper = null;
            context.path().remove();
            }
        Mapper existingMapper = mapper.getMapper(fieldName);
                    arrayFieldName
     */
                        );
            processExistingMapperForDisableObjects(context, fieldName, existingMapper);
        }
            pathsAdded++;
        DynamicProperty dynamicProperty
                    "Cannot add a value for field ["
                    );
        }
     * Removes mappers that exist on the stack, but are not part of the path of the current nameParts,
            );
 * under the License.
        } else {
     */
                if (targetDoc == context.doc()) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }
    /**
            withNewMapper = parentMappers.get(lastIndex).merge(withNewMapper);
        // note, we don't prefix it with the type of the doc since it allows us to execute a nested query
    // find what the dynamic setting is given the current parse context and parent
        final int parentPathSlots = parentMapperTuple.v1();
        String updateParentName = nameParts[i];
                    if (builder == null) {
                ObjectMapper.Dynamic dynamic = dynamicOrDefault(parent, context);
            }
                Mapper mapper = getMapper(context, parentMapper, lastFieldName, paths);
                    resolvedFieldName
                        Mapper.Builder builder = findTemplateBuilder(
        if (token.isValue()) {
     * one method handles arrays, objects, and scalars without requiring separate hooks per token type,
                // `epoch_millis` or `YYYY`
                // empty doc, we can handle it...
                            + "] and ["
    }
     * replayed through the existing path.
     * inject any required parameters before the {@link Mapper.TypeParser} builds the
        if (source.source() != null && source.source().length() == 0) {
    private static boolean containsDisabledObjectMapper(ObjectMapper objectMapper, String[] subfields) {
        if (mapper != null) {
            }
                flattenObjectFields(context, mapper, fieldName);
            if (parentMappers.isEmpty()) {
    ParsedDocument parseDocument(SourceToParse source, MetadataFieldMapper[] metadataFieldsMappers, DocumentInput documentInput)
        for (int i = 0; i < disableObjectsIndex; i++) {
                // log it rather than swallowing silently, then move on to the next inferencer.
            return false;
import java.util.List;
            }
                // disable_objects mode: use parseNonDynamicArray which will delegate to our enhanced parsing methods
            } catch (NumberFormatException e) {
    }
                                dateTimeFormatter,
                            context,
                    if (tryPluginInference(context, mapper, currentFieldName, paths)) {
        }
            final String claimingInferencerName = claimingInferencer.getClass().getName();
     * Handles ObjectMapper parsing with disable_objects logic.
                        .fields()
    }
    }
            parseObjectMapper(context, objectMapper);
     * <p>Strictly gated: no-op unless the pluggable data format is enabled and the resolved leaf is
                return;
                            }
                context.path().remove();
        for (var e : efv.values().entrySet()) {
                    // Release the field-name slot even if replay throws, so ContentPath is not left
                    // parseArray / parseValue. Placing the hook here means one method covers arrays,
        String inferredType = (String) inferredFieldMapping.get("type");
                // ObjectMappers are skipped under disable_objects (their leaf FieldMappers handle it),
        XContentParser xParser = context.parser();
            return;
                token = parser.nextToken();
        ObjectMapper.Dynamic dynamic,
        List<ObjectMapper> parentMappers,
            context.sourceToParse().getMediaType(),
        }
        }
                                assert mapper != null;
                    + fullPath
            // Pluggable data format: signal the per-element boundary explicitly on the DocumentInput.
            }
            parentMappers.add((ObjectMapper) intermediate);
     */
            int i = removeUncommonMappers(parentMappers, nameParts);
                            break;
                    copyToContext = context;
            parent = parent + "." + parts[i];
        Mapper mapper = builder.build(builderContext);
                    + "] for field ["
                        // the time
     *
            ) {
    private final DocumentMapper docMapper;
                            + "] matched more than one dynamic template plugin type: ["
            // Pluggable data formats write _id to the DocumentInput, so it is only required here on vanilla indices.
        // Handle both flat and nested modes internally based on mapper's disable_objects setting
            return context.root().dynamic() == null ? ObjectMapper.Dynamic.TRUE : context.root().dynamic();
            assert intermediate instanceof ObjectMapper;
 */
    /**
        }
        while (dynamicMapperItr.hasNext()) {
            if (existingParent != null && existingParent.disableObjects()) {
        } catch (Exception e) {
                throw new MapperParsingException(
        ObjectMapper current = docMapper.root();
        }
        });
        } else {
                parentMappers.add(objectMapper);
            parseFieldWithCopyTo(context, fieldMapper);
                        mapper = (ObjectMapper) builder.build(builderContext);
            }
            // entire type is disabled
            return mapperParsingException;
                return builder;
                parseCopyFields(externalCtx, fm.copyTo().copyToFields());
                    case STRICT_ALLOW_TEMPLATES:
        DocumentMapper docMapper,
            String[] nameParts = splitAndValidatePath(newMapper.name());
            ++i;
                parseNonDynamicArray(context, mapper, fieldName, fieldName);
            // the original ordering, where disable_objects flattens the array.
                "object mapping for ["
import org.opensearch.Version;
                claimingInferencer = inferencer;
/**
            }
        String fieldPath = context.path().pathAsText(fieldName);
        if (existingMapper instanceof FieldMapper fieldMapper) {
        if (mapper != null) {
                // But in order to be created dynamically, the dynamic setting of that parent was necessarily true
        CheckedBiConsumer<ParseContext, String, IOException> copyAction
        ParseContext context,
                    if (field.startsWith(doc.getPrefix())) {
        String type = typeNode.toString();
        } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
                // if we are just starting an OBJECT, advance, this is the object we are parsing, we need the name first
                        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
            // Check if the current parent has disable_objects=true
        } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
                    return builder;
                || numberType == XContentParser.NumberType.LONG
        switch (token) {
        Mapper.TypeParser typeParser = parserContext.typeParser(inferredType);
                        break;
            parseDynamicPropertyValue(context, currentFieldName, fullPath, dynamicProperty);
            Mapper templateMapper = templateBuilder.build(templateBuilderContext);
            if (objectMapper.nested().isNested()) {
    }
        for (int k = 1; k < nameParts.length; k++) {
        // This stops an inferencer from emitting a core built-in type (e.g. keyword, date, long), a type
    private static String[] resolvePathForParsing(ObjectMapper mapper, String fieldName) {
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();
        nestedDoc.add(NestedPathFieldMapper.field(context.indexSettings().getIndexVersionCreated(), mapper.nestedTypePath()));
                // For the first mapper case, seed with a root that contains just this ObjectMapper.
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
        XContentFieldType matchType,
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
    private final IndexSettings indexSettings;
            if (!nested.isIncludeInParent() || parentDoc != rootDoc) {
                    e
                    + "] for field ["
            try {
                        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
        }
    // Throws exception if no dynamic templates found but `dynamic` is set to strict_allow_templates
        // merging them backwards since they are immutable
                                "It is forbidden to create dynamic nested objects (["
                if (builder == null) {
                            parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
        } finally {
        //
        ObjectMapper.Dynamic dynamic,
                            + "] and ["
                        return new Tuple<>(pathsAdded, parent);
        // TODO how do we identify dynamically that its a binary value?
        ParseContext context,
                Long.parseLong(text);
        if (token == XContentParser.Token.VALUE_STRING) {
    /** Build an update for the parent which will contain the given mapper and any intermediate fields. */
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
        context.addDynamicMapper(inferredMapper);
        }
    private static void checkDynamicPropertiesLuceneFieldLimit(ParseContext context, String fullPath) {
            // Release path-slots added by getDynamicParentMapper before returning
                context.path().add(currentFieldName);
            }
        String fullPath = context.path().pathAsText(currentFieldName);
        String name,
        if (mapper instanceof ObjectMapper objectMapper) {
     * @param parentMapper the parent object mapper with disable_objects enabled
        DocumentMapper docMapper,
        if (token != null && token.isValue()) {
            try (
                        if (builder == null) {
                context.path().add(parts[i]);
            return;
        }
    ParsedDocument parseDocument(SourceToParse source, MetadataFieldMapper[] metadataFieldsMappers) throws MapperParsingException {
        Mapper mapper = builder.build(builderContext);
        if (inferredType == null) {
                                    parseObjectOrField(context, mapper);
        Mapper firstUpdate = dynamicMapperItr.next();
        if (inferencers.isEmpty() && templateTypes.isEmpty()) {
            replayParser.nextToken(); // position at the start of the value
                // Handle primitive values with dynamic mapping - reuse existing parseDynamicValue
    private static void applyExtraFieldValues(ParseContext context) throws IOException {
                        // no templates are defined, we use float by default instead of double
                XContentParser replayParser = contentType.xContent()
    ) throws IOException {
        XContentParser parser,
    /**
            if (mapper == null) {
                return;
import org.opensearch.index.IndexSettings;
            Mapper.Builder candidate = findPluginTemplateBuilder(
            }
     * {@code pluginType} and whose path/name patterns match the field being parsed.
     * <p>This is called at the single convergence point in {@code innerParseObject} where the field name,
                                Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
        pathMappers.add(current);
        parseCopyFieldsInternal(context, copyToFields, (copyToContext, field) -> {
    private static int expandCommonMappers(List<ObjectMapper> parentMappers, String[] nameParts, int i) {
            ++keepBefore;
            }
        }
                    // There is a concrete mapper for this field already. Need to check if the mapper
        XContentParser.Token token,
        } else if (token == XContentParser.Token.VALUE_NUMBER) {
        // Handle structured tokens (objects and arrays) with recursive flattening
    private static void processFieldWithDisableObjects(
        if (parentMappers.isEmpty() == false) {
                    Map<String, Object> groupingCriteriaParams = doc.getGroupingCriteriaParams();
        final ParseContext.InternalParseContext context;
            if (builder != null) {
                // We refuse to match pure numbers, which are too likely to be
 * KIND, either express or implied.  See the License for the
            context.parser().skipChildren();
        // If we do not do this then when a document gets deleted only the root Lucene document gets deleted and
        for (int i = 0; i < subfields.length - 1; ++i) {
import org.opensearch.core.xcontent.XContentParser;
        // An inferencer may only produce a type it declared via supportedTypes() (validated at startup
    ) throws IOException {
                    parentMapper = parentMapperTuple.v2();
    }
        // We consult ALL registered inferencers rather than stopping at the first claim: if two
        Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, resolvedPaths, parentMapper);
    /**
    }
                );
    }
        throws MapperParsingException {
     *
            if (Strings.isEmpty(fullFieldPath)) {
        // inferencers both claim the same field, that is ambiguous and we fail loudly (per OpenSearch
            return () -> new TextFieldMapper.Builder(fieldName, context.mapperService().getIndexAnalyzers()).addMultiField(
    }
        // we can only handle null values if we have mappings for them
                String parentPath = String.join(".", java.util.Arrays.copyOf(fullNameParts, k));
        switch (token) {
        final String[] paths = resolvePathForParsing(mapper, lastFieldName);
                nested(context, nested);
        String currentFieldName = parser.currentName();
        }
                context.path().remove();
            throw new MapperParsingException("Malformed content, must start with an object");
     */
                                    context.addDynamicMapper(mapper);
        XContentParser.Token token
                                dynamic,
            return builder;
    private static void generateGroupingCriteria(ParseContext context) {
    }
    }
            }
                // not a long number
            String parentName = parentMapper.name().substring(0, lastDotNdx);
    private static void processExistingMapperForDisableObjects(ParseContext context, String fieldName, Mapper existingMapper)
        }
            validateStart(parser);
    }
                throw new IllegalStateException(
     * will be merged in with other child mappers of the last parent, otherwise it will be a new update.
                return dynamicTemplate;
                fieldValueParser
                    + existingMapper.getClass().getSimpleName()
        List<ObjectMapper> parentMappers = new ArrayList<>();
        while (dynamic == null) {
        XContentParser.Token token
            byte[] childBytes = parseChildToBytes(context);
                context.path().remove();
        // the field looks like a plugin-managed type (e.g. numeric array >= 128 elements).
            case VALUE_STRING:
     * Handles a field that matches a {@link DynamicProperty} pattern: reuses a cached mapper if
        // Assume original index has 2 fields - status , nested.nested1.status
            if (objectMapper.disableObjects()) {
            return parts;
            return builder;
        throws IOException {
    private static void parseValue(
        // has declared their intent; we must not reject it because it falls below an inferencer
        // For null values in disable_objects mode, we typically don't create mappers
        // Handle value tokens (null and primitive values)
        try (XContentBuilder bufferBuilder = XContentBuilder.builder(contentType.xContent())) {
            dynamic = parentMapper.dynamic();
            // The matching endNestedElement() is emitted by parseObjectOrNested's finally, so the pair
            }
import java.util.stream.Collectors;
                () -> new ParameterizedMessage(
     */
            context.checkFieldDepthLimit();
                    }
            return true;
            context.incrementFieldCurrentDepth();
            parentMapper = parentMapperTuple.v2();
                            );
                        throw new IllegalArgumentException("object field cannot contain only whitespace: ['" + fullFieldPath + "']");
 * software distributed under the License is distributed on an
    ) throws IOException {
    /**
        ParseContext context,
                            context.path()
                switch (dynamic) {
            for (int k = 1; k < fullNameParts.length; k++) {
        // Fast path: no plugins registered — zero overhead. Each inferencer is bound to the set of
                                    context.path().add(arrayFieldName);
                        parseObjectOrField(context, objectMapper);
            // on pre-2.0 indices) keeps the signalled path a clean dotted path.
    ) throws IOException {
            if (token == XContentParser.Token.END_OBJECT) {
        String currentFieldName,
        // Find the disable_objects parent index
     */
                try {
                // Close the element opened by startNestedElement in nestedContext. Emitted from a
        // then nested.nested1.status/nested.nested1/nested array should not be blocked
                        parser.nextToken();
    private static void processNullValueForDisableObjects(ParseContext context, ObjectMapper mapper, String fieldName) throws IOException {
                dynamic,
                            );
        }
        if (leaf instanceof ParametrizedFieldMapper fieldMapper && fieldMapper.fieldType().isMultiValueSupported()) {
                            + "]; the mapping is ambiguous"
        FieldValueParserSupplier fieldValueParser
            }
            for (int i = 0; i < parentMapperTuple.v1(); i++) {
        }
import org.opensearch.common.xcontent.XContentHelper;
        }
            mapper = parentMappers.get(0);
                current = om;
    /**
                addToLastMapper(parentMappers, newMapper, true);
        }
            Mapper mapper = objectMapper.getMapper(subfields[i]);
                resolvedFieldName,
        }
     */
            if (objectMapper != null) {
        // Handle disable_objects case: if the intermediate mapper doesn't exist and the last parent has disable_objects=true,
            throw new MapperParsingException(
        // getDynamicParentMapper added parentPathSlots to context.path(); release them on every exit
                                arrayFieldName,
     * the limit is exceeded by a genuinely new field.
        //
            rawContent = BytesReference.toBytes(BytesReference.bytes(bufferBuilder));
        ParseContext context,
        if (limit > 0 && fieldInfos.size() >= limit && fieldInfos.fieldInfo(fullPath) == null) {
                    }
                break;
                } else {
 * @opensearch.internal
                }
            case START_ARRAY:
                    + parentMapper.name()
            validateEnd(parser);
        }
                    if (replayToken != null && replayToken.isValue()) {
        ParseContext context,
     *
     * for replay. Returns {@code true} if a plugin claimed the field (template or inferencer) or it was
        ParseContext.Document parentDoc = nestedDoc.getParent();
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parentMapper.fullPath(), lastFieldName);
    /**
            }
        if (parentMappers.size() > 1) {
        // (including an exception, e.g. buffering failure or an ambiguous-claim MapperParsingException)
        }
        }
                );
                parentMappers.add(createUpdate(mapping.root(), splitAndValidatePath(newMapper.name()), 0, newMapper));
        if (token == XContentParser.Token.VALUE_NULL) {
                // In case of a hierarchy of nested documents, we need to figure out
            parseObjectOrNested(context, mapping.root);
            throw new MapperParsingException(
                            break;
            DynamicFieldTypeInferencer inferencer = entry.getKey();
                            // Try template matching with OBJECT type (existing behavior).
     * available, otherwise builds one from the pattern config, enforces the Lucene field-count
                    + "] trying to serialize a value with"
                            currentFieldName
        } else {
            // Check if this field should be handled as literal field
        // to be registered by its own plugin's getMappers()). The returned type must be in that set.
        }
                        // Should not dynamically create any more mappers so return the last mapper
            if (newMapper instanceof ObjectMapper objectMapper) {
            context.path().add(resolvedFieldName);
                case START_ARRAY:
            String text = context.parser().text();
            }
        }
    }
        String path = context.path().pathAsText(arrayFieldName);
                        // not dynamic, read everything up to end object
            int lastDotNdx = parentMapper.name().lastIndexOf('.');
            return; // Early exit for null objects
            Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, parentMapper);
            } else {
                    // check if the field name contains only whitespace
    }
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.BOOLEAN, dynamic, fullPath);
            );
                            + templateMatchedType
     *   <li>Field is already mapped ({@code getMapper()} returns non-null) — delegate to normal path.</li>
                return handleNoTemplateFound(
        try {
        return mapper.disableObjects() ? new String[] { fieldName } : splitAndValidatePath(fieldName);
                    + fullPath
     */
            Mapper.BuilderContext templateBuilderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
    ) throws IOException {
     * same bytes are replayed through the normal unmapped-field logic so existing behavior is preserved.
            // only prefix with parent mapper if the parent mapper isn't the root (which has a fake name)
        } else if (context.indexSettings().isPluggableDataFormatEnabled() == false) {
        if (sawElement == false) {
        final Mapper.Builder<?> builder = createBuilderFromDynamicValue(context, token, currentFieldName, dynamic, parentMapper.fullPath());
                // no dot means we the parent is the root, so just delegate to the default outside the loop
            }
        DynamicTemplateTypeHandler handler = entry.getValue();
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    private static boolean tryPluginInference(ParseContext context, ObjectMapper parentMapper, String fieldName, String[] paths)
        // auto-inference. A user who writes a plugin-typed match_mapping_type with explicit params
            mapper = context.docMapper().objectMappers().get(currentPath);
                        case TRUE:
                            if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
                // false positives with date formats that include eg.
import org.opensearch.common.settings.Settings;
                                );
            if (parentMapper == null) {
            assert newLast instanceof ObjectMapper;
     * @return a {@link Mapper.Builder} ready to build the mapper, or {@code null} if no template matched
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     * If parentMappers is empty (first mapper case), the update is added directly;
            if (mapper != null) {
        }
        }
                    + "]. Increase the ["
                break;
            }
        assert parentMappers.size() == 1;
        final String pathAsString = path.pathAsText(name);
                resolvedParent.fullPath(),
        // across types (for example, with similar nested objects)
                        + "] since one of the intermediate objects is mapped as a nested object: ["
                throw new MapperParsingException(
        for (int i = pathMappers.size() - 2; i >= 0; i--) {
        try {
