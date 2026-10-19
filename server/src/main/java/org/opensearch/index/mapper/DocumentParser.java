        // note, we don't prefix it with the type of the doc since it allows us to execute a nested query
                                }
            boolean parseableAsDouble = false;  
                XContentParser innerParser = parser.contentType()
                    e
     * with a factory that produces a fresh parser over the buffered field bytes, so the handler can
    /**  
            try {
    /** Creates instances of the fields that the current field should be copied to */
    private static void registerEmptyMultiValueArray(ParseContext context, ObjectMapper mapper, String lastFieldName, String[] paths) {
                for (ParseContext.Document doc = context.doc(); doc != null; doc = doc.getParent()) {  
                        Mapper.Builder builder = findTemplateBuilder(
        return parseDocument(source, metadataFieldsMappers, null);
        // Handle both flat and nested modes internally based on mapper's disable_objects setting
            // from the existing mappings. In order to maintain the invariant that the stack only contains  
        Mapper.TypeParser typeParser = parserContext.typeParser(type);
                assert token.isValue();  
    }
        List<String> copyToFields,  
        final String pathAsString = path.pathAsText(name);
            String text = context.parser().text();
                    claimingInferencerName,
            Mapper newLast = last.getMapper(nameParts[i]);
                    "Could not dynamically add mapping for field [{}]. Existing mapping for [{}] must be of type object but found [{}].",
        //
    /**
                break;
    /**
            final Mapper mapper = context.docMapper().mappers().getMapper(fullPath);
     */  
        ObjectMapper parent = mapper;
                // `epoch_millis` or `YYYY`
        if (claimingInferencerSupportedTypes.contains(inferredType) == false) {
import org.opensearch.common.settings.Settings;  
            }
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parentMapper.fullPath(), lastFieldName);  
        XContentParser.Token token = parser.currentToken();
            sawElement = true;
        ObjectMapper currentParent
        Mapper newMapper,
        }
                    String criteria = groupingFieldMapper.fieldType()
                            dynamic,  
    private static void parseObjectOrField(ParseContext context, Mapper mapper) throws IOException {
        if (dynamicMappers.isEmpty()) {  
    private static Mapper.Builder<?> createBuilderFromDynamicValue(  
            builder.copyCurrentStructure(parser);
        }
                String parentPath = String.join(".", java.util.Arrays.copyOf(fullNameParts, k));
        }  
        for (MetadataFieldMapper metadataMapper : metadataFieldsMappers) {
                // corrupt for subsequent fields in the same document.
                        // no templates are defined, we use float by default instead of double
            metadataMapper.preParse(context);
            return new MapperParsingException("failed to parse, document is empty");
                        objectMapper = builder.build(builderContext);  
                try {  
            Mapper intermediate = previousIntermediate.getMapper(nameParts[i]);
                        "Document structure incompatibility: Unexpected end of document while parsing field ["
                            context.path()
                            parent.fullPath()
        if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
            parseObjectOrField(context, mapper);  
        // merging them backwards since they are immutable  
            if (builder == null) {
            for (int i = 0; i < parts.length - 1; i++) {
            // TODO: passing null to an object seems bogus?  
 * not use this file except in compliance with the License.
        // Use ContentPath + leaf so the dotted name matches FieldMapper#name (built via pathAsText in FieldMapper.Builder).
            if (!(mapper instanceof ObjectMapper objMapper)) {  
                            + claimingInferencer.getClass().getName()  
            ++keepBefore;  
        return parent.mappingUpdate(mapper);
            validateStart(parser);
            }  
                    );
        Mapper leaf = getMapper(context, mapper, lastFieldName, paths);  
                            () -> newFloatBuilder(currentFieldName, context.indexSettings().getSettings())  
    }
            Mapper mapper = objectMapper.getMapper(subfields[i]);
        // so ContentPath is not left corrupt for subsequent fields in the same document.
                    case FALSE_ALLOW_TEMPLATES:
            // don't add it twice, if its included in parent, and we are handling the cluster-manager doc...
            logger.warn(
                            + resolvedFieldName
import org.apache.lucene.index.FieldInfos;
                if (builder == null) {
            }
        }
import org.apache.logging.log4j.LogManager;
                    arrayFieldName
        int disableObjectsIndex = 0;
                        }
            for (int i = 0; i < parentMapperTuple.v1(); i++) {
                    + "] as object, but found a concrete value"
                        throw new StrictDynamicMappingException(  
            }
                "The number of Lucene fields created by dynamic_properties has reached the limit ["
                        "field ["  
                            break;
                    + context.parser().textOrNull()  
            context.incrementFieldArrayDepth();  
        }
            parseObjectOrNested(context, mapping.root);  
        while (dynamic == null) {  
                // which document the field should go to
                            // TODO: shouldn't this skip, not parse?  
            if (builder != null) {
     * reuse their Lucene slot and are not counted again. Throws {@link MapperParsingException} if  
    /** Build an update for the parent which will contain the given mapper and any intermediate fields. */
 */  
                        parser.skipChildren();
                context.parser().skipChildren();  
            if (objectMapper.disableObjects()) {  
     * written null — collapsing the distinction between {@code []} and a missing field when
                parseableAsDouble = true;  
        // a plugin claims the field or not (streaming parser can only be read once)  
            if (Strings.isEmpty(fullFieldPath)) {  
    ) throws IOException {
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("field name cannot contain only the character [.]");  
    private static final Logger logger = LogManager.getLogger(DocumentParser.class);
        final Mapper.Builder<?> builder = createBuilderFromDynamicValue(context, token, currentFieldName, dynamic, parentMapper.fullPath());
        final ParseContext context,
            }
        context.addDynamicMapper(inferredMapper);
            parentMapper = parentMapperTuple.v2();
        }
            if (mapper instanceof FieldMapper fieldMapper) {
            rawContent = BytesReference.toBytes(BytesReference.bytes(bufferBuilder));
        // Step 2: No template matched — run the inferencers as the auto-detection fallback.
            if (parentMappers.isEmpty()) {
            if (parts.length == 0) {
                    parentMapper = parentMapperTuple.v2();  
        if (nested.isIncludeInRoot()) {  
/*
        // then arrays in nested/nested.nested1 and nested.nested1.status fields should be blocked  
                );  
        final String resolvedFieldName = resolvedPaths[resolvedPaths.length - 1];
    }
        return context;
                context.path().add(resolvedFieldName);
                parseObjectOrField(replayContext, inferredMapper);
import org.apache.lucene.document.Field;
    }  
            // Unknown type — fall through to existing path rather than failing  
    }
        }
                                    break;  
            if (existingParent != null && existingParent.disableObjects()) {
    private static void parseDynamicValue(
                }
                        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(  
                        case STRICT_ALLOW_TEMPLATES:
            parent = parent + "." + parts[i];  
        ParseContext context,
        if (inferencers.isEmpty() && templateTypes.isEmpty()) {
            if (builder == null) {  
        }
        XContentParser parser = context.parser();  
                break;
                throw new IllegalStateException(  
                    // corrupt for subsequent fields in the same document.
                if (script != null) {
                            break;
    }
        if (context.docMapper() != null && context.docMapper().mappers() != null) {
                // Object mode: use existing object array parsing logic
            }  
     * Handles flat field mapping by adding the mapper directly to the disable_objects parent.
        } catch (Exception e) {
     * @return {@code true} if this method consumed the parser (either a plugin claimed the field or the
    }
            ) {
    }
                    case FALSE:  
                        parser.nextToken();  
                // A buggy inferencer must not break document parsing, but the failure must be visible:  
        DynamicTemplateTypeHandler handler = entry.getValue();
                    }
import org.opensearch.core.xcontent.XContentParser;
                    processFieldWithDisableObjects(context, mapper, currentFieldName, fieldMapper, token);
            // If there are still parents of the new mapper which are not on the stack, we need to pull them
        }
        throws IOException {  
            if (shouldHandleAsDisableObjects(docMapper, nameParts)) {
                parseDynamicValue(context, parentMapper, fieldName, token);
import static org.opensearch.index.mapper.FieldMapper.IGNORE_MALFORMED_SETTING;
                fieldMapper.addMultiValueMappingUpdate(context);  
        if (nested.isIncludeInParent()) {  
                    + fullPath
            } else {
        if (updateParent == null && lastParent.disableObjects()) {
        }
        // Check if mapper is a metadata mapper first  
        });  
                    ),
                        .collect(Collectors.joining("-"));  
        ExtraFieldValues efv = context.sourceToParse().extraFieldValues();
    private static void parseCopyFields(ParseContext context, List<String> copyToFields, byte[] sourceBytes) throws IOException {  
                        case STRICT:
                            }  
        final ParseContext context,  
                handleDisableObjectsMapping(parentMappers, newMapper, docMapper, mapping);
        }
            // This means the ObjectMapper is receiving a concrete value instead of an object
                        // the time  
        }  
    @SuppressWarnings({ "rawtypes", "unchecked" })
            } else {
                            XContentFieldType.OBJECT,
        for (int k = 1; k < nameParts.length; k++) {
                }
            context = new ParseContext.InternalParseContext(indexSettings, docMapperParser, docMapper, source, parser, documentInput);
    }
                        }
        } finally {
            // brackets exactly the element's fields. fullPath() (not nestedTypePath(), "__"-prefixed
            return;
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;  
                }  
     * Handles flattening of object tokens by iterating through fields and building dotted field names.  
            addToLastMapper(parentMappers, parentMappers.remove(i), merge);
            }
    /**
        return false;
                                    parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
                        case FALSE:
                Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, mapper);  
        }
            context.documentInput().addField(fieldMapper.fieldType(), List.of());
        return null;
            context.addDynamicMapper(templateMapper);
        }
            try {
        }  
        // We consult ALL registered inferencers rather than stopping at the first claim: if two  
                                mapper = builder.build(builderContext);
                        "field ["  
    }
            }  
        // An inferencer may only produce a type it declared via supportedTypes() (validated at startup  
                // no dot means we the parent is the root, so just delegate to the default outside the loop  
        if (mapper.disableObjects()) {  
                            if (builder == null) {  
        // Fast path: field is already mapped — let the normal path handle it  
        if (mapper.isEnabled() == false) {
 * license agreements. See the NOTICE file distributed with
            if (lastDotNdx == -1) {
            throw new MapperParsingException(  
                    // This is the single convergence point where we know the field name, the
        Map<String, DynamicTemplateTypeHandler> templateTypes = context.mapperService().getDynamicTemplateTypes();
    /**  
                    ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);
        while (keepBefore < parentMappers.size() && parentMappers.get(keepBefore).simpleName().equals(nameParts[keepBefore - 1])) {
                token = parser.nextToken();  
                                dynamic,  
        Mapper existingMapper,  
     * for replay. Returns {@code true} if a plugin claimed the field (template or inferencer) or it was
        if (mapper instanceof ObjectMapper objectMapper) {  
        }  
                    }
                        + fieldName  
            if (parentMapper == null) {
        // The handler completes the config (injects its own type when omitted, and any data-derived
                token = parser.nextToken();
                case START_ARRAY:
            } finally {
            }
                String.format(  
                    case STRICT_ALLOW_TEMPLATES:  
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
        }
                                ignoreMalformed,  
            token = parser.nextToken();
                    + "] in dynamic_property pattern ["  
                        case FALSE_ALLOW_TEMPLATES:  
        }
                parseObjectOrNested(context, om);  
                case VALUE_NULL:
 * @opensearch.internal  
                        context.path().remove();
        // Handle structured tokens (objects and arrays) with recursive flattening
            XContentParser parser = copyToContext.parser();
            if (token == XContentParser.Token.START_OBJECT) {
        while (objToken != XContentParser.Token.END_OBJECT) {
            mapper = parentMappers.get(0);
        Map<String, Object> inferredFieldMapping = null;  
            String[] paths = null;
        // Buffer the complete field value — needed for replay regardless of whether
                }  
            ++i;
                resolvedParent.fullPath(),  
                                dynamic.name().toLowerCase(Locale.ROOT),  
                ParseContext replayContext = context.switchParser(replayParser);
                    dynamic,  
                        context.parser().skipChildren();
                        }
    private final DocumentMapper docMapper;
        if (existingMapper != null) {
        // If a dynamic_property matches this field, use it without updating the index mapping (no cluster state update;  
                    Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, dateTimeFormatter, dynamic, fullPath);
        // owned by a different plugin, or a type a sibling inferencer in the same plugin owns. Otherwise,  
            if (token == XContentParser.Token.START_OBJECT) {  
            // to maintain proper JSON parsing state
                }  
    }  
                                    + "]) through `copy_to` or dots in field names"  
                            }
        // Fast path: no plugins registered — zero overhead. Each inferencer is bound to the set of
                for (int j = i + 1; j < subfields.length; j++) {
                                );
        return objectMapper.getMapper(subfields[subfields.length - 1]);
                            );  
                    if (builder == null) {
    }
                    // Release the field-name slot even if replay throws, so ContentPath is not left  
     * mapper with {@link FieldMapper#parsesArrayValue()} true (geo/completion), which no
                            // Try template matching with OBJECT type (existing behavior).
        if (mapper != null) {
            if (mapper == null) {
                return;
     *   <li>No inferencers registered ({@code inferencers.isEmpty()}) — zero overhead.</li>
        handler.adjustMappingConfig(mappingConfig, fieldValueParser);
                    throw new MapperParsingException(
            } else if (numberType == XContentParser.NumberType.FLOAT
        List<ObjectMapper> parentMappers,
                "No handler for type ["
                final ContextAwareGroupingScript script = groupingFieldMapper.fieldType().compiledScript();
                        + mapper.name()
        } finally {
    private static void flattenObjectFields(ParseContext context, ObjectMapper mapper, String fieldName) throws IOException {  
        // Traverse from root to the disable_objects parent
                    } else {
        ParseContext context,
            return; // Early exit for null objects  
                        case START_OBJECT:
        );
                switch (dynamic) {
            for (String part : parts) {
            if (dynamicTemplate.matchesPluginType(pathAsString, name, pluginType)) {  
                    // objects, and scalars rather than requiring three separate hooks. The hook only
        String name,
                // Use parseNonDynamicArray which now handles disable_objects mode
                        case VALUE_NULL:
 */
    private static void processExistingMapperForDisableObjects(ParseContext context, String fieldName, Mapper existingMapper)
        }
                    + " no field associated with it, current value ["
        if (typeNode == null) {
                        // since this is much more space-efficient and should be enough most of
        ObjectMapper parentMapper,
 *
        }
        Map<String, Object> mappingConfig = dynamicTemplate.mappingForName(name, pluginType);
        } else {  
                    + "]"
        }  
            } catch (NumberFormatException e) {
        } else {
        final Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
            // Parse the field using a fresh parser over the captured bytes.  
                                        + "] tried to parse field ["
        final Mapping mapping = docMapper.mapping();
        // TODO how do we identify dynamically that its a binary value?
     * Removes mappers that exist on the stack, but are not part of the path of the current nameParts,  
                        parseObjectOrField(context, objectMapper);  
            // fields which are updated, we cannot simply add the existing mappers to the stack, since they
    }
        long limit = context.indexSettings().getMappingDynamicPropertiesLuceneFieldLimit();
        }  
    }
            if (!(mapper instanceof ObjectMapper objMapper)) {  
        if (mapping.root.isEnabled() == false) {
        String fullPath
            if (om != null && om.nested().isNested()) {  
            }
    }
                    } catch (OpenSearchParseException | DateTimeParseException | IllegalArgumentException e) {  
     * {@code _source} is later reconstructed from the columns. Registering an empty list lets the
    }
            fieldMapper.parse(context);
                                arrayFieldName
        if (dynamic == ObjectMapper.Dynamic.STRICT) {
     * <p>Reached from every scalar-leaf array route — top-level, nested, and disable_objects arrays
                        context.path().remove();
                            + mapper.name()
                                break;
            context.path().add(resolvedFieldName);
        // Check if the first mapper should be handled as a disable_objects literal field
            try {  
                    "Cannot add a value for field ["
        // will be processed in a contiguous block. When the prefix is no longer seen, we pop the extra elements
     *
                // disable_objects mode: use parseNonDynamicArray which will delegate to our enhanced parsing methods
            if (token == XContentParser.Token.END_OBJECT) {
                            + "]; the mapping is ambiguous"  
                            Mapper.Builder builder = findTemplateBuilder(
        ParseContext.InternalParseContext context,
            );
        return mapper instanceof FieldMapper fieldMapper && fieldMapper.parsesArrayValue();
                // false positives with date formats that include eg.
    /**  
            return false;  
     */  
import org.opensearch.common.xcontent.XContentHelper;  
                                    context.path().remove();
        DynamicProperty dynamicProperty = context.root().findDynamicProperty(fullPath);
            }
        try (XContentBuilder bufferBuilder = XContentBuilder.builder(contentType.xContent())) {
                logger.warn(
 * GitHub history for details.
        } else if (leaf instanceof FieldMapper fieldMapper && fieldMapper.fieldType().isMultiValued()) {  
     */
            context.documentInput().startNestedElement(mapper.fullPath());  
                context.path().remove();
                claimingInferencerSupportedTypes = entry.getValue();
                    if (parsesArrayValue(mapper)) {
        boolean isNested = path.contains(".") || context.mapperService().isCompositeIndexFieldNestedField(path);  
        }  
 * this file be licensed under the Apache-2.0 license or a
            // After parseChildToBytes, the original parser has consumed the full structure.
            return true;
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.BINARY, dynamic, fullPath);  
        for (var e : efv.values().entrySet()) {
     * Handles dynamic mapping for new fields in disable_objects mode.
                String dottedFieldName = fieldName.isEmpty() ? nestedFieldName : fieldName + "." + nestedFieldName;
                source.source(),  
    private final DocumentMapperParser docMapperParser;
        }  
        if (token == XContentParser.Token.VALUE_NULL) {
                }  
     * Offers an unmapped field to all registered plugin inferencers and plugin-registered dynamic template types  
        MetadataFieldMapper[] metadataFieldsMappers,
        switch (token) {  
            int i = removeUncommonMappers(parentMappers, nameParts);  
            while (token != XContentParser.Token.END_OBJECT) {  
        Mapper firstUpdate = dynamicMapperItr.next();  
                innerParser.nextToken();
                        flatFieldName.append(".");
                context.documentInput().endNestedElement();
        DynamicFieldTypeInferencer claimingInferencer = null;
     * Flattens nested objects into dotted field names.
                                throw new MapperParsingException(
        // off the stack, merging them upwards into the existing mappers.
            return parts;
            ObjectMapper objectMapper = parentMapperTuple.v2();
    private static void parseObjectForDisabledObjects(ParseContext context, ObjectMapper mapper, String currentFieldName)  
        // Check if root has disable_objects=true
        }  
    ) {
            }
    }
                        + mapper.name()  
                ParseContext innerContext = context.switchParser(innerParser);
                    + currentFieldName
                    currentPath,
            );
        // If the mapper is an ObjectMapper, we cannot add it to a disable_objects parent  
     */
        return parsedDocument(source, context, createDynamicUpdate(mapping, docMapper, context.getDynamicMappers()), documentInput);  
                            );
        if (context.indexSettings().isPluggableDataFormatEnabled() == false) {  
                ObjectMapper parentMapper = parentMapperTuple.v2();
            context.path().add(fieldName);  
            last = (ObjectMapper) newLast;  
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.STRING, dynamic, fullPath);
            // The matching endNestedElement() is emitted by parseObjectOrNested's finally, so the pair  
                                parentMapper.fullPath(),
    }
        } else {
        }
            }
        try {
                        case START_ARRAY:
            return;
        return builder;  
            return true;
     * making the SPI genuinely generic rather than array-specific.
            return;  
        try (
     * <ul>
        while (i < nameParts.length - 1 && last.getMapper(nameParts[i]) != null) {  
            for (int i = 0; i < parentPathSlots; i++) {
                    + "]. Expected a field mapper or object mapper."
                    }
                // One mapping is missing, check if we are allowed to create a dynamic one.
                LoggingDeprecationHandler.INSTANCE,
    /**
                        parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
                // Close the element opened by startNestedElement in nestedContext. Emitted from a  
            contentType,  
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        ParseContext.Document nestedDoc = context.doc();  
            }
        Mapper mapper = context.docMapper().mappers().getMapper(field);
     *
        switch (existingMapper) {  
                            parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
 * this work for additional information regarding copyright
                    + "]. Increase the ["
                    + "] with mapper type ["
        // Throw a more meaningful message if the document is empty.
                ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);  
        throws IOException {  
                            + currentFieldName  
                // log it rather than swallowing silently, then move on to the next inferencer.
            if (token == XContentParser.Token.END_OBJECT) {
                        );
        IndexableField idField = parentDoc.getField(IdFieldMapper.NAME);
        }
        if (cached != null) {
        parseCopyFieldsInternal(context, copyToFields, (copyToContext, field) -> {
     */
        assert parentMappers.size() == 1;
    DocumentParser(IndexSettings indexSettings, DocumentMapperParser docMapperParser, DocumentMapper docMapper) {
                // Here we just skip over the duplicates, but we merge them to ensure there are no conflicts.
            );  
        Iterator<Mapper> dynamicMapperItr = dynamicMappers.iterator();
            handleDisableObjectsMapping(parentMappers, firstUpdate, docMapper, mapping);
    /**
            // entire type is disabled  
            final Mapper mapper = context.docMapper().mappers().getMapper(ContextAwareGroupingFieldMapper.CONTENT_TYPE);
                claimingInferencer = inferencer;
        String mappingType = dynamicTemplate.mappingType(pluginType);
     * Adds a mapper as an update into the last mapper. If merge is true, the new mapper
        ParseContext context,  
                if (token == XContentParser.Token.FIELD_NAME) {
    }
                            builder = new ObjectMapper.Builder(currentFieldName).enabled(true);  
                ParseContext externalCtx = context.createExternalValueContext(value);
                        parseObjectOrField(context, mapper);  
        if (parentMappers.size() > 1) {
                                    + context.path().pathAsText(paths[i])
            );
        } else {
                                    context.path()  
        DocumentMapper docMapper,  
        final String[] resolvedPaths = paths != null ? paths : splitAndValidatePath(fieldName);
                        + "] since one of the intermediate objects is mapped as a nested object: ["
            // only prefix with parent mapper if the parent mapper isn't the root (which has a fake name)  
                // empty doc, we can handle it...
            if (nested.isNested() && context.indexSettings().isPluggableDataFormatEnabled()) {
                    return handleNoTemplateFound(dynamic, () -> newLongBuilder(currentFieldName, context.indexSettings().getSettings()));
                templateBuilder = candidate;  
    private static void parseDynamicPropertyValue(
        }  
                            context.indexSettings().getSettings(),  
import org.opensearch.common.time.DateFormatter;
        String currentFieldName,  
        if (dynamicTemplate == null) {
        if (mapper.isEnabled() == false) {
    }  
                rootDoc.add(field);
                    );
        ParseContext context,
                        targetDoc = doc;
            parseDynamicValue(context, parentMapper, currentFieldName, token);
                final ExtraFieldValue value = e.getValue();  
                token = parser.nextToken();  
                            );  
        int pathsAdded = 0;
        Map.Entry<String, DynamicTemplateTypeHandler> entry,
            // the original ordering, where disable_objects flattens the array.
        return false;
                    + "] trying to serialize a value with"
        String inferredType = (String) inferredFieldMapping.get("type");  
            XContentParser.Token replayToken = replayParser.currentToken();
                            + entry.getKey()
                    copyToContext = context;  
     * templates, parseDynamicValue, parseNonDynamicArray — as if the buffer had never been created.
                            + templateMatchedType  
        Mapper newMapper
        if (idField != null) {  
            previousIntermediate = (ObjectMapper) intermediate;
            if (newMapper instanceof ObjectMapper objectMapper) {  
                )
     * writer emit a zero-length, non-null list instead.  
    private static void processDynamicMappingForDisableObjects(  
    ) throws IOException {  
            Mapper objectMapper = getMapper(context, mapper, currentFieldName, paths);
                        resolvedFieldName  
        ParseContext.Document parentDoc = nestedDoc.getParent();  
            parseObjectForDisabledObjects(context, mapper, currentFieldName);
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), childBytes)
            }
        token = parser.nextToken();
            // the object is null ("obj1" : null), simply bail  
            try {  
        if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.FALSE) {  
        String parent = parts[0];  
        XContentParser.Token token;
                        "Skipping dynamic field type inferencer [{}]: it threw while inspecting field [{}]",
        XContentParser parser = context.parser();
                );
            processDynamicMappingForDisableObjects(context, parentMapper, fieldName, token);  
        // will result in START_OBJECT
                    "Malformed content, after first object, either the type field" + " or the actual properties should exist"  
            )
            if (field.name().equals(nestedPathFieldName) == false) {  
        }  
                    mapper.name(),  
    }
                                DateFieldMapper.Resolution.MILLISECONDS,
                default:
 * the Apache License, Version 2.0 (the "License"); you may
                            if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
                    if (tryPluginInference(context, mapper, currentFieldName, paths)) {
            parseDynamicValue(context, objectMapper, fieldName, context.parser().currentToken());  
        return i;
        ObjectMapper last = parentMappers.get(parentMappers.size() - 1);
     * This method consolidates the logic for field processing in disable_objects mode.
            return true;
        if (shouldHandleAsDisableObjects(docMapper, firstNameParts)) {  
            if (child instanceof ObjectMapper om) {
                    parseObjectOrField(replayContext, templateMapper);
                    String.join(".", paths),
            ) {  
                    + dynamicProperty.getPattern()
            } else {  
        } else if (token == XContentParser.Token.VALUE_NUMBER) {
        if (mapper != null) {  
                parseCopy(field, parserSwitchedContext);
    }  
        if (existingMapper != null) {  
                    currentFieldName = parser.currentName();
            return context.root().dynamic() == null ? ObjectMapper.Dynamic.TRUE : context.root().dynamic();
        return new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.LONG, settings);
        for (Map.Entry<DynamicFieldTypeInferencer, Set<String>> entry : inferencers.entrySet()) {  
        throws IOException {
                throw new IllegalArgumentException("Cannot copy to a field alias [" + mapper.name() + "].");
        int keepBefore = 1;
                );  
                    + "], expected ["  
                break;
    private static String[] resolvePathForParsing(ObjectMapper mapper, String fieldName) {
                    return handleNoTemplateFound(dynamic, () -> newLongBuilder(currentFieldName, context.indexSettings().getSettings()));
        // documents inside the Lucene index (document blocks) will be incorrect, as nested documents of different root
     */
    private static void parseArray(ParseContext context, ObjectMapper parentMapper, String lastFieldName, String[] paths)
            context.seqID(),  
    private static boolean shouldHandleAsDisableObjects(DocumentMapper docMapper, String[] nameParts) {
        }
            parseObjectMapper(context, objectMapper);
        }
            }
     *   <li>Field is already mapped ({@code getMapper()} returns non-null) — delegate to normal path.</li>  
            case START_ARRAY:
                    lastFieldName = arrayFieldName;  
     * will be merged in with other child mappers of the last parent, otherwise it will be a new update.
            // Handle both disable_objects and object modes internally based on parentMapper's disable_objects setting  
            // if we are at the end of the previous object, advance  
            // We just need to store the id as indexed field, so that IndexWriter#deleteDocuments(term) can then
        if (sawElement == false) {
                parentMappers.add(objectMapper);
            throw new IllegalStateException(
            throw new MapperParsingException("failed to find type parsed [" + mappingType + "] for [" + name + "]");
        try {
    }
     * replayed through the existing path.  
            }
                    throw new MapperParsingException(
                    case STRICT:  
            parentMappers.add((ObjectMapper) intermediate);
    /**
        // threshold. Template matching is already scoped by the user's match/path_match patterns
     * all funnel through {@link #parseNonDynamicArray}. The only array route that bypasses it is a  
        // Root ObjectMapper#fullPath is the internal mapping-type name "_doc", which must not prefix index field names.
            throw new IllegalArgumentException("Cannot write to a field alias [" + mapper.name() + "].");
                context.path().remove();  
                if (parent != null && parent.disableObjects()) {  
    private static void handleDisableObjectsMapping(  
    }
                            + "] matched more than one dynamic template plugin type: ["
                                return new Tuple<>(pathsAdded, parent);
    private static void parseCopyFieldsInternal(
            objectMapper = objMapper;  
                        dateTimeFormatter.parse(text);
        }
            byte[] childBytes = parseChildToBytes(context);
                        + "]"  
                        mapper = (ObjectMapper) builder.build(builderContext);
 * SPDX-License-Identifier: Apache-2.0
            return;
            Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, parentMapper);  
        // to be registered by its own plugin's getMappers()). The returned type must be in that set.
            case VALUE_STRING:  
            // For example, if we processed a.b, followed by an object mapper a.c.d, and now are adding a.c.d.e  
                    parseNullValue(replayContext, parentMapper, fieldName, replayPaths);
        throws IOException {
    private static boolean attemptPluginInference(  
                    }
        if (fullPath.equals(mapper.name()) == false) {
                    + "] but its mapping has no [type]"
                // Release the field-name slot even if replay throws, so ContentPath is not left  
            context.path().remove();
        if (docMapper.root().disableObjects()) {  
        }
            } else if (parseableAsLong == false && parseableAsDouble == false && context.root().dateDetection()) {
                // These cases are handled below
            }
import java.util.Map;  
                () -> new ParameterizedMessage(  
            throw new MapperParsingException("Malformed content, must start with an object");
        String fieldFullPath  
                            } else if (token.isValue()) {
        }
            }
        String fieldPath = context.path().pathAsText(fieldName);
    /**  
                XContentParser replayParser = contentType.xContent()  
        // ignore the claim and fall through to the existing dynamic-mapping path.
        try {
                flattenObjectFields(context, mapper, fieldName);
                // We refuse to match pure numbers, which are too likely to be  
        // not the nested Lucene documents! Besides the fact that we would have zombie Lucene documents, the ordering of
 *
/*  
                    if (replayToken != null && replayToken.isValue()) {
        }  
        }
        for (; i < nameParts.length - 1; ++i) {
            metadataMapper.postParse(context);  
                context,
                    for (int i = 0; i < parentMapperTuple.v1(); i++) {  
                context.path().remove();
                }
            ParseContext replayContext = context.switchParser(replayParser);
        XContentParser.Token token  
                        context.path().add(currentFieldName);
                context.path().remove();
        XContentParser xParser = context.parser();
        // block array values for composite index fields
                addFields(indexVersion, nestedDoc, rootDoc);
                        return new Tuple<>(pathsAdded, parent);
    private static ObjectMapper createExistingMapperUpdate(
            parentMappers.add(createUpdate(mapping.root(), firstNameParts, 0, firstUpdate));  
        ObjectMapper.Dynamic dynamic = parentMapper.dynamic();
    /**
            throw new IllegalArgumentException("Malformed content, found extra data after parsing: " + token);  
        for (int i = pathMappers.size() - 2; i >= 0; i--) {  
        ObjectMapper parentMapper,  
        for (Map.Entry<String, DynamicTemplateTypeHandler> entry : templateTypes.entrySet()) {  
                    rejectedType,  
        } finally {
        DynamicTemplate dynamicTemplate = findPluginTemplate(context.root(), context.path(), name, pluginType);  
     */
        XContentParser originalParser = context.parser();
            if (token == XContentParser.Token.START_OBJECT || token == XContentParser.Token.START_ARRAY) {
     * released by the caller's {@code finally}, so this method only manages the field-name slot it adds
     *  
                    }  
        Object typeNode = config.get("type");
            XContentParser parser = XContentHelper.createParser(  
                                context.parser().skipChildren();  
     * the limit is exceeded by a genuinely new field.
                                dateTimeFormatter,
                );
        for (int i = 0; i < subfields.length - 1; ++i) {
        if (e instanceof MapperParsingException mapperParsingException) {
        String currentFieldName,
                if (mapper != null) {
            final String fullPath = e.getKey();
                    + type
        }
        Mapper.Builder builder = context.root().findTemplateBuilder(context, name, matchType);  
                throw new MapperParsingException(
            return;
     * are present when the mapper is constructed. Handlers whose config is already complete never call
                // In case of a hierarchy of nested documents, we need to figure out  
     * @param name          the simple field name being parsed (last path component)
        } else {
     * Handles null value processing for disable_objects mode.
        String currentFieldName,
                parseObject(context, mapper, lastFieldName, paths);
                ParseContext.Document targetDoc = null;
                nested(context, nested);
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), mapper.fullPath(), fieldName);  
        throws IOException {
    /**
    private final IndexSettings indexSettings;  
            case START_OBJECT:
                                parentMapper.fullPath()
    private static void parseDisableObjectsFields(ParseContext context, ObjectMapper mapper) throws IOException {  
    }
        // but arrays in status should not be blocked
                            mapper.fullPath(),
            switch (replayToken) {  
            context.checkFieldDepthLimit();
                // Success path only, so a failure here cannot mask the original parse exception.
    private static ParsedDocument parsedDocument(
import java.util.stream.Collectors;
        FieldValueParserSupplier fieldValueParser
        if (context.indexSettings().isCompositeIndex()
            processNullValueForDisableObjects(context, mapper, fieldName);
                            parseNullValue(context, mapper, currentFieldName, paths);  
    private static Mapper.Builder findTemplateBuilder(
        String fieldFullPath
                final ContextAwareGroupingFieldMapper groupingFieldMapper = (ContextAwareGroupingFieldMapper) mapper;
            return () -> new TextFieldMapper.Builder(fieldName, context.mapperService().getIndexAnalyzers()).addMultiField(  
            Map<String, Object> claim;
            }
        }
        boolean sawElement = false;  
                    doc.setGroupingCriteria(script.execute(doc.getGroupingCriteriaParams()));
        String updateParentName = nameParts[i];  
        try {
    private static void generateGroupingCriteria(ParseContext context) {  
        }  
    private static void parseObjectMapper(ParseContext context, ObjectMapper objectMapper) throws IOException {
        // if its already a mapper parsing exception, no need to wrap it...  
        } else if (context.indexSettings().isPluggableDataFormatEnabled() == false) {
        }  
            // The path of the dest field might be completely different from the current one so we need to reset it
        if (remainingPath.isEmpty() == false) {  
        }
            // We first need the stack to only contain mappers in common with the previously processed mapper  
        String[] firstNameParts = splitAndValidatePath(firstUpdate.name());
                    switch (token) {
        // Handle value tokens (null and primitive values)
     * empty-array handling or {@code []} would collapse to an absent field there.  
                            builder = new ObjectMapper.Builder(paths[i]).enabled(true);
            case START_ARRAY:
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
    ) {
     * the incoming token type, and the parser position are all known simultaneously — before the code fans
                    case FALSE:
            return true;  
                        continue;
        checkDynamicPropertiesLuceneFieldLimit(context, fullPath);
        ParseContext.Document nestedDoc = context.doc();
        return new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.FLOAT, settings);  
    }
    private static void parseObject(final ParseContext context, ObjectMapper mapper, String currentFieldName, String[] paths)
        MediaType contentType = parser.contentType();  
}  
                                    context.indexSettings().getSettings(),
        if (fullFieldPath.contains(".")) {  
                // With disable_objects=true, we should not traverse further into the path
                            break;
                return dynamicTemplate;
     * Handles a field that matches a {@link DynamicProperty} pattern: reuses a cached mapper if  
            case END_OBJECT:
        }
                    // fires for unmapped fields; if the field has a mapper we skip directly to the  
                } else {  
        XContentParser.Token token,
                            currentFieldName,
            // For example, if the first mapper processed was a.b.c, and we now have a.d, the stack will contain
import org.opensearch.core.xcontent.XContentBuilder;
            try {
    }  
                innerParser.nextToken();
                            throw new MapperParsingException(  
            Mapper newMapper = dynamicMapperItr.next();
                || numberType == XContentParser.NumberType.DOUBLE  
    private static void parseNullValue(ParseContext context, ObjectMapper parentMapper, String lastFieldName, String[] paths)  
        Mapper mapper = builder.build(builderContext);
    private static String[] splitAndValidatePath(String fullFieldPath) {
                // finally so the pairing holds even when parsing the element fails midway.
            innerParseObject(context, mapper, parser, currentFieldName, token);
import org.apache.lucene.index.IndexableField;  
        throws IOException {
            XContentParser replayParser = contentType.xContent()  
        }  
        XContentParser.Token objToken = xParser.nextToken(); // Move to first field or END_OBJECT
        }
            return builder;
    /**
            throw new MapperParsingException(
                return builder;
            case VALUE_BOOLEAN:
        return new Tuple<>(pathsAdded, mapper);  
    }
        return typeParser.parse(name, mappingConfig, parserContext);
                resolvedFieldName,  
            return true;  
                        default:
                return null;
    private static void processFieldWithDisableObjects(
        assert keepBefore >= 1; // never remove the root mapper
                    Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, parentMapper);
            return;
     */
        for (DynamicTemplate dynamicTemplate : root.dynamicTemplates()) {
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(resolvedParent, context);
 * Unless required by applicable law or agreed to in writing,
    }  
                    // check if the field name contains only whitespace
        );  
        Mapping mapping
            }
            if (mapper != null) {  
     * Processes a token during flattening, handling different token types appropriately.
                parseObjectOrField(context, cached);
            }
    ) throws IOException {  
            if (parentMapper.disableObjects()) {
                    + fullPath  
        String fieldName,
import org.opensearch.index.IndexSettings;  
                objToken = xParser.nextToken(); // Move to the value  
import org.opensearch.common.collect.Tuple;
                parseValue(context, mapper, lastFieldName, token, paths);
                context.path().remove();  
            return;
    }
        ParseContext context,
     * available, otherwise builds one from the pattern config, enforces the Lucene field-count
    }  
            }
        List<ObjectMapper> parentMappers,  
     *  
            }  
            } else if (token == XContentParser.Token.VALUE_NULL) {
     * {@code multi_value: true}. The element loop above never fires for an empty array, so without
 * specific language governing permissions and limitations
                    );
                    + "] for field ["
                continue; // Skip the normal processing for this mapper  
            if (!(mapper instanceof FieldMapper fm) || !fm.supportsExtraFieldValues()) {
    private static Mapper.Builder<?> newLongBuilder(String name, Settings settings) {
                .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), rawContent)
        }  
            registerEmptyMultiValueArray(context, mapper, lastFieldName, paths);
            // For FALSE_ALLOW_TEMPLATES, if no template matches, we still need to consume the token  
                parseFieldWithCopyTo(context, fm);
    private static void applyExtraFieldValues(ParseContext context) throws IOException {
     * This method is shared between object and array flattening operations.
        context = context.createNestedContext(mapper.fullPath());
            parseDynamicValue(context, mapper, mapper.fullPath(), token);
        }  
            case END_ARRAY:
        }  
        } else if (mapper instanceof FieldMapper fieldMapper) {
        Map<String, DynamicTemplateTypeHandler> templateTypes  
                        break;
            // Check if this field should be handled as literal field  
                                    context.parser().skipChildren();
                        if (builder == null) {
        if (token.isValue()) {
                    + parentMapper.name()  
import org.opensearch.common.CheckedBiConsumer;
                    () -> new ParameterizedMessage(  
    private static int removeUncommonMappers(List<ObjectMapper> parentMappers, String[] nameParts) {  
    ) {
            }  
            }
        // params) before the TypeParser builds the mapper.  
        if (parts.length <= 1) return;
        flattenObjectFields(context, mapper, currentFieldName);
        this.docMapperParser = docMapperParser;  
    /**  
        }  
     * Adds mappers from the end of the stack that exist as updates within those mappers.
            ObjectMapper existingParent = docMapper.objectMappers().get(parentPath);
                            }  
                    if (j > i + 1) {  
/*  
     */  
    private static ObjectMapper.Dynamic dynamicOrDefault(ObjectMapper parentMapper, ParseContext context) {
        Mapper.Builder<?> builder = typeParser.parse(resolvedFieldName, inferredFieldMapping, parserContext);
                flattenObjectFields(context, parentMapper, fieldName);
        } else if (emptyDoc == false) {
        } else {
                Mapper mapper = getMapper(context, parentMapper, lastFieldName, paths);  
        // we can only handle null values if we have mappings for them
    }  
        ObjectMapper.Dynamic dynamic,  
    ) {
                );
        if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES && builder == null) {
            parent = mapper;
    ) {
                }  
        // but will throw a JSON exception if the extra tokens is not valid JSON (this will be handled by the catch)  
        if (context.indexSettings().isPluggableDataFormatEnabled()) {  
        for (int i = 0; i < subfields.length - 1; ++i) {
 */
    ) throws IOException {
            } else {
                new KeywordFieldMapper.Builder("keyword").ignoreAbove(256)
            parentMappers.add(update);  
                    token = parser.nextToken();
            // Check if the current parent has disable_objects=true  
 */  
        context.addDynamicMapper(mapper);  
        // getDynamicParentMapper added parentPathSlots to context.path(); release them on every exit
     * Attempts to find a plugin-registered dynamic template whose {@code match_mapping_type} equals
        }  
                        token = parser.nextToken();  
        XContentParser parser = context.parser();  
            context.checkFieldArrayDepthLimit();
        final ParseContext.InternalParseContext context;
        } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
                        .map(field -> groupingCriteriaParams.get(field).toString())
                                context.indexSettings().getSettings()
            case START_OBJECT:
                pathMappers.add(om);  
    // find what the dynamic setting is given the current parse context and parent  
            }  
                XContentParser innerParser = parser.contentType()  
            context.decrementFieldCurrentDepth();
final class DocumentParser {
        try {
                    );
     * a {@code multi_value} {@link FieldMapper}, so stock indexing is unaffected.  
            final ObjectMapper om = context.docMapper().objectMappers().get(parent);
        if (templateBuilder != null) {
        context.rememberDynamicPropertyMapper(fullPath, mapper);  
            if (mapper == null) {
            mapper = objectMapper.getMapper(subfields[i]);
        String[] nameParts,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Work backwards to root, wrapping each update
        Mapping mapping,  
        popMappers(parentMappers, keepBefore, true);
        try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {  
                token = parser.nextToken();
    private static void addFields(Version indexVersion, ParseContext.Document nestedDoc, ParseContext.Document rootDoc) {  
        }  
        for (IndexableField field : nestedDoc.getFields()) {
            case VALUE_NUMBER:
     * {@code pluginType} and whose path/name patterns match the field being parsed.
        ParseContext.InternalParseContext context,  
        Mapper.TypeParser typeParser = parserContext.typeParser(mappingType);  
                            mapper.fullPath()
import java.util.Collections;
                                if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
                    .xContent()
        String name,
        throw new IllegalStateException(  
                }
            String parentPath = String.join(".", java.util.Arrays.copyOf(nameParts, k));  
        }
                                context,  
        if (token == XContentParser.Token.END_OBJECT) {  
            if (claim != null) {  
            replayParser.nextToken(); // position at value start
            if (previousIntermediate.disableObjects()) {
                    // There is a concrete mapper for this field already. Need to check if the mapper
        ParseContext context,
            context.incrementFieldCurrentDepth();  
                if (token == XContentParser.Token.FIELD_NAME) {
    }  
        DateFormatter dateFormat,
            objToken = xParser.nextToken();
        );
        return builderSupplier.get();
        if (dynamicProperty != null) {
        if (context.indexSettings().isPluggableDataFormatEnabled()) {
                        inferencer.getClass().getName(),
            parseFieldWithCopyTo(context, fieldMapper);  
    }  
        return new MapperParsingException("failed to parse", e);
                    // expects an array, if so we pass the context straight to the mapper and if not  
            String[] nameParts = splitAndValidatePath(newMapper.name());
                            + resolvedFieldName
                }  
                );
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.DOUBLE, dynamic, fullPath);  
     * <p>This is called at the single convergence point in {@code innerParseObject} where the field name,  
                    "The provided mapper [" + mapper.name() + "] has an unrecognized type [" + mapper.getClass().getSimpleName() + "]."
                            );
        String type = typeNode.toString();
     * <p>Fast-path exits (no buffering, no deserialization):  
                    + fieldName
        }
        } finally {
    private static ParseContext nestedContext(ParseContext context, ObjectMapper mapper) {  
        for (MetadataFieldMapper metadataMapper : metadataFieldsMappers) {
                            parseArray(context, mapper, currentFieldName, paths);  
            }
        if (typeParser == null) {
            for (int k = 1; k < fullNameParts.length; k++) {  
            Mapper.Builder candidate = findPluginTemplateBuilder(
    private static Mapper.Builder findTemplateBuilder(
            return null;
    private static void popMappers(List<ObjectMapper> parentMappers, int keepBefore, boolean merge) {  
                    if (Strings.isEmpty(part) == false) {
                } else if (token == null) {  
        if (token == XContentParser.Token.VALUE_NULL) {
            }
            assert intermediate != null : "Field " + previousIntermediate.name() + " does not have a subfield " + nameParts[i];
            }  
    }  
        String[] paths
                }
        // the field looks like a plugin-managed type (e.g. numeric array >= 128 elements).
                }
        String fullPath,
            }
                mediaType
                replayParser.nextToken();  
                    // switch below via the early-return inside tryPluginInference.
                    // Process different token types during object parsing  
        XContentParser.Token token = parser.currentToken();
                throw new MapperParsingException("Field [" + fullPath + "] does not support extra field ingestion");  
import org.apache.logging.log4j.Logger;
            final String claimingInferencerName = claimingInferencer.getClass().getName();  
            int lastDotNdx = parentMapper.name().lastIndexOf('.');
            context.path().add(currentFieldName);  
                            + "] and ["
        }
        }  
                    context.path().remove();  
            parentMappers.add(last);
            // TODO: EFV is only allowed if JSON is absent (validation)  
                context.path().add(currentFieldName);
        } finally {
                throw new MapperParsingException(
 *
                    + "] index setting or reduce the number of distinct dynamic fields."  
                    if (containsDisabledObjectMapper(mapper, paths)) {
        // Assume original index has 2 fields - status , nested.nested1.status
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.LONG, dynamic, fullPath);  
                        // Should not dynamically create any more mappers so return the last mapper  
        ObjectMapper resolvedParent,  
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
        if (token != null && token.isValue()) {
        this.indexSettings = indexSettings;
        // Check nested object mappers
                );  
        // case 2 : if nested.nested1.status is part of composite index and status is not part of composite index,
                throw new MapperParsingException(
        XContentParser.Token token;// only check for end of tokens if we created the parser here
            }
            // In disable_objects mode, we should treat this as a field with the mapper's full name  
                throw new MapperParsingException(
     * otherwise it is merged into the existing root entry.
        ) {
        context.postParse();
        int i,
            documentInput
                    if (builder == null) {  
            if (parseableAsLong && context.root().numericDetection()) {
                    + limit  
            }  
    ) throws IOException {
        }  
    private static void checkDynamicPropertiesLuceneFieldLimit(ParseContext context, String fullPath) {  
                ParseContext parserSwitchedContext = copyToContext.switchParser(innerParser);  
                    doc.setGroupingCriteria(criteria);
                // if we are just starting an OBJECT, advance, this is the object we are parsing, we need the name first
        nestedDoc.add(NestedPathFieldMapper.field(context.indexSettings().getIndexVersionCreated(), mapper.nestedTypePath()));  
        List<ObjectMapper> parentMappers = new ArrayList<>();
                            context,  
        if (typeParser == null) {
    }  
            // Pluggable formats need the per-element scope even with disable_objects set; vanilla keeps
                    switch (dynamic) {  
    private static void nested(ParseContext context, ObjectMapper.Nested nested) {
 * KIND, either express or implied.  See the License for the
            throw new MapperParsingException(  
            throw new IllegalStateException("The root document of a nested document should have an _id field");  
            for (String field : copyToFields) {
     */
                    + fullPath  
        final String[] paths,  
                parseObjectOrField(context, objectMapper);
            validateNoNestedParents(context, fullPath, parts); // nested docs not supported
        throws MapperParsingException {  
            while (token != XContentParser.Token.END_OBJECT) {
        // Only fire for dynamic=TRUE / STRICT_ALLOW_TEMPLATES / FALSE_ALLOW_TEMPLATES  
                );
            context.version(),
                break;
            // Subsequent mapper — merge with existing root update
            // Then we need to add back mappers that may already exist within the stack, but are not on it.
            return false;  
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), fieldFullPath, name);
 *  
            return BytesReference.toBytes(BytesReference.bytes(builder));
        // auto-inference. A user who writes a plugin-typed match_mapping_type with explicit params
                parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);  
import org.opensearch.index.engine.dataformat.DocumentInput;
        if (parentMappers.isEmpty() == false) {
    static Mapping createDynamicUpdate(Mapping mapping, DocumentMapper docMapper, List<Mapper> dynamicMappers) {
        String fullPath = context.path().pathAsText(currentFieldName);  
            }
                    + "] matched field ["  
            Mapper templateMapper = templateBuilder.build(templateBuilderContext);  
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(mapper, context);
        }  
            }
     *
    }
            parseExistingFieldMapper(context, fieldName, existingMapper);
        // In disable_objects mode, we only want FieldMappers with dotted names
        }
                                    "object mapping for ["
                        if (mapper.nested() != ObjectMapper.Nested.NO) {
        Map<DynamicFieldTypeInferencer, Set<String>> inferencers,
        Mapping update,
     * Records an empty array ({@code "field": []}) for a pluggable-data-format field mapped with
                context.path().add(parts[i]);
     * Returns the next unprocessed index from nameParts.
    /**  
                "dynamic_property pattern ["  
                } finally {
                    arrayFieldName = paths[paths.length - 1];
        try (  
        // across types (for example, with similar nested objects)
            update,  
            try (
                            break;
        XContentParser.Token token,  
        List<ObjectMapper> parentMappers = new ArrayList<>();  
     */  
     *         token-type switch in {@code innerParseObject}.  
        }
    private static java.util.function.Supplier<Mapper.Builder<?>> builderSupplierForText(String fieldName, ParseContext context) {
                    + mapper.name()
        // plugin types both match the same field, that is an ambiguous configuration and we fail
        }  
            if (fieldMapper.fieldType().isMultiValued() == false) {
            Mapper existingFieldMapper = context.docMapper().mappers().getMapper(currentPath);
        String fieldFullPath,
                    parseObject(replayContext, parentMapper, fieldName, replayPaths);
        // documents are then aligned with other root documents. This will lead tothe nested query, sorting, aggregations  
            throw new MapperParsingException(
        }
        // try to parse the next token, this should be null if the object is ended properly
            context.decrementFieldArrayDepth();  
        }
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());  
    private static void validateEnd(XContentParser parser) throws IOException {  
                    flatFieldName.append(subfields[j]);  
                    + dynamicProperty.getPattern()
                // but parentMappers needs an entry for subsequent merges.
        FieldInfos fieldInfos = context.mapperService().getLuceneFieldTracker().getFieldInfos();
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
        } else if (dynamic == ObjectMapper.Dynamic.STRICT || dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
        ObjectMapper parentMapper,
        // the type of the nested doc starts with __, so we can identify that its a nested one in filters  
     * Only FieldMappers are added; ObjectMappers are skipped as they conflict with disable_objects.
        // Handle object structures - advance past START_OBJECT to get to field parsing
        }
    private static Mapper.Builder<?> handleNoTemplateFound(  
 * ownership. Elasticsearch licenses this file to you under  
        String remainingPath = context.path().pathAsText("");
        ParseContext context,
                parseNonDynamicArray(context, parentMapper, fieldName, fieldName);  
                return builder;
        }
        if (builder == null && dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {  
     * <p>If a matching template is found, calls {@link DynamicTemplateTypeHandler#adjustMappingConfig}
            if (numberType == XContentParser.NumberType.INT  
        if (typeParser == null) {
                    Map<String, Object> groupingCriteriaParams = doc.getGroupingCriteriaParams();
            // First mapper — add directly
            );
    private static void validateNoNestedParents(ParseContext context, String fullPath, String[] parts) {  
        XContentParser.Token token
                }  
                    break;  
                // not a long number  
                if (builder == null) {
        if (mapping.root.isEnabled()) {
                    return builder;  
        // happens for them.
        if (currentFieldName == null) {  
    private static void parseFieldWithCopyTo(ParseContext context, FieldMapper fieldMapper) throws IOException {  
            if (candidate != null) {  
import org.opensearch.core.xcontent.MediaType;  
        }
            context.checkFieldDepthLimit();  
            try (  
        byte[] rawContent;
        parentMappers.set(lastIndex, withNewMapper);
        }
        return keepBefore - 1;  
    }
        ObjectMapper mapper,  
        final boolean emptyDoc = isEmptyDoc(mapping, parser);
            if (builder == null) {
        }
        String currentFieldName = parser.currentName();
                ObjectMapper.Dynamic dynamic = dynamicOrDefault(parent, context);  
                    parseArray(replayContext, parentMapper, fieldName, replayPaths);
        while (dynamicMapperItr.hasNext()) {  
                    return handleNoTemplateFound(dynamic, () -> newFloatBuilder(currentFieldName, context.indexSettings().getSettings()));
            final String[] paths = splitAndValidatePath(field);
                        );  
            return mapper;  
            parseDynamicPropertyValue(context, currentFieldName, fullPath, dynamicProperty);  
        ObjectMapper.Nested nested = mapper.nested();  
                            + "]; the inferred type is ambiguous"  
    }
                break;  
 * compatible open source license.
                }  
                inferredFieldMapping = claim;  
                ParseContext copyToContext;
            context = context.overridePath(new ContentPath(0));  
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            && ((isNested == false && context.mapperService().isFieldPartOfCompositeIndex(arrayFieldName))  
                        // failure to parse this, continue
            nestedDoc.add(new Field(IdFieldMapper.NAME, idField.binaryValue(), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
        return mapper.disableObjects() ? new String[] { fieldName } : splitAndValidatePath(fieldName);
        String currentFieldName,  
    private static int expandCommonMappers(List<ObjectMapper> parentMappers, String[] nameParts, int i) {
            if (objToken == XContentParser.Token.FIELD_NAME) {
                            currentFieldName  
        // Handle dynamic mapping for new fields  
        }
        }  
                if (targetDoc == context.doc()) {
                .xContent()
    }
                    null,  
                            }
                    // we serialize the array components
        }
            }
            }  
        switch (token) {  
import java.util.Iterator;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            updateParentName = lastParent.name() + '.' + nameParts[i];
    }
            assert token == XContentParser.Token.FIELD_NAME || token == XContentParser.Token.END_OBJECT;  
    ) throws IOException {
            "Can't handle serializing a dynamic type with content token [" + token + "] and field name [" + currentFieldName + "]"
     */  
            token = parser.nextToken();
                    break;  
    // Throws exception if no dynamic templates found but `dynamic` is set to strict_allow_templates
    }
        if (inferredType == null) {
        }
     */  
                        .fields()  
            } else if (token == XContentParser.Token.START_ARRAY) {
                    break;
                return true;
        ObjectMapper.Dynamic dynamic,
import org.opensearch.core.common.bytes.BytesReference;
     * one method handles arrays, objects, and scalars without requiring separate hooks per token type,  
            return createUpdate(lastParent, nameParts, i, newMapper);  
        java.util.function.Supplier<Mapper.Builder<?>> builderSupplier
        Mapper.Builder<?> builder = typeParser.parse(currentFieldName, config, parserContext);
/**  
                            dynamic,
                continue;
        // on the DynamicTemplate, so it only fires for fields the user intended.
        }  
                parentMappers.add(createUpdate(mapping.root(), splitAndValidatePath(newMapper.name()), 0, newMapper));
        if (merge) {
                // We can see the same mapper more than once, for example, if we had foo.bar and foo.baz, where  
            } else if (mapper instanceof FieldAliasMapper) {  
        }  
            context.incrementFieldCurrentDepth();
        Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, resolvedPaths, parentMapper);
        ObjectMapper.Dynamic dynamic,
            }
        }
            context.parser().skipChildren();  
                        if (builder == null) {  
            }
            addToLastMapper(parentMappers, mapper, false);  
    private static boolean tryPluginInference(ParseContext context, ObjectMapper parentMapper, String fieldName, String[] paths)
    ) {  
        // case 1 : if status is part of composite index and nested.nested1.status is not part of composite index,  
                            context,  
        // This can happen when intermediate object mappers are created during dynamic mapping
                    context.path().remove();
        //  
        // We build a mapping by first sorting the mappers, so that all mappers containing a common prefix  
        for (int i = 1; i < parts.length; i++) {
            parseObjectOrNested(context, objectMapper);
                            boolean ignoreMalformed = IGNORE_MALFORMED_SETTING.get(context.indexSettings().getSettings());
        return builder;
        ObjectMapper update = disableObjectsParent.mappingUpdate(newMapper);  
                        });
                } else {
            // Check for disable_objects and handle flattening
        } else if (token.isValue()) {  
        ObjectMapper parentMapper,
            return;  
        }  
        final String[] paths = resolvePathForParsing(mapper, lastFieldName);
                    "object mapping for [%s] with array for [%s] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                    + mapper.name()
                    }
                )
                templateMatchedType = entry.getKey();
            // So we need to pull a.c, followed by a.c.d, onto the stack so e can be added to the end.
    ) {  
            source.routing(),
        ParseContext context,  
        }
                    currentFieldName = parser.currentName();  
        // pop off parent mappers not needed by the current mapper,
            return;  
                parseArray(context, mapper, lastFieldName, paths);  
        Mapper mapper = getMapper(context, parentMapper, currentFieldName, paths);
        int lastIndex = parentMappers.size() - 1;  
                    + "] tried to parse field ["  
        try {
    }
                    case TRUE:
            if (nested.isNested()) {  
        } else {
            parentMapper = context.docMapper().objectMappers().get(parentName);
        if (nested.isNested()) {
     * Enforces the per-shard Lucene field-count limit for {@code dynamic_properties}. A field is
        ObjectMapper updateParent = docMapper.objectMappers().get(updateParentName);
        // For null values in disable_objects mode, we typically don't create mappers
        String[] resolvedPaths,
        }  
    }  
            );
        // loudly (per OpenSearch triage) rather than silently letting registration order decide.  
            } else if (parseableAsDouble && context.root().numericDetection()) {
                        );
        if (existingMapper instanceof FieldMapper fieldMapper) {
    /** Creates a Mapping containing any dynamically added fields, or returns null if there were no dynamic mappings. */
    private static Mapper getMapper(final ParseContext context, ObjectMapper objectMapper, String fieldName, String[] subfields) {
                            + "] in object ["
        final ParseContext context,
            replayParser.nextToken(); // position at the start of the value  
            withNewMapper = parentMappers.get(lastIndex).merge(withNewMapper);  
     * If parentMappers is empty (first mapper case), the update is added directly;  
                    }
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();
            popMappers(parentMappers, 1, false);
                // But in order to be created dynamically, the dynamic setting of that parent was necessarily true
            return builder;
    }
        String currentFieldName,
    /**  
                String nestedFieldName = xParser.currentName();  
     * This is shared logic used by multiple methods that need to flatten objects in disable_objects mode.
        // inferencers both claim the same field, that is ambiguous and we fail loudly (per OpenSearch
        return new ParsedDocument(
        }
                                arrayFieldName,
                || numberType == XContentParser.NumberType.BIG_DECIMAL) {
import java.util.List;
        // triage) rather than letting plugin load order silently pick a winner.
        this.docMapper = docMapper;
        Collections.sort(dynamicMappers, (Mapper o1, Mapper o2) -> o1.name().compareTo(o2.name()));  
            String parentName = parentMapper.name().substring(0, lastDotNdx);  
        assert updateParent != null : updateParentName + " doesn't exist";  
 * under the License.  
        }  
        // Step 1: Check plugin-registered dynamic templates first — explicit user intent beats
        ObjectMapper previousIntermediate = parent;
 * You may obtain a copy of the License at  
                Double.parseDouble(text);
        String name,  
    ) throws IOException {
    ) throws IOException {  
            } else if (token == null) {  
            currentFieldName = paths[paths.length - 1];
            return attemptPluginInference(context, dynamic, resolvedParent, resolvedPaths, inferencers, templateTypes);  
            previousMapper = newMapper;  
                            if (token == null) {  
                for (DateFormatter dateTimeFormatter : context.root().dynamicDateTimeFormatters()) {  
        } else {  
                parseNullValue(context, mapper, lastFieldName, paths);
    private static void processNullValueForDisableObjects(ParseContext context, ObjectMapper mapper, String fieldName) throws IOException {  
    private static MapperParsingException wrapInMapperParsingException(SourceToParse source, Exception e) {
        ObjectMapper mapper,  
        ) {  
                }
                }  
        XContentParser parser,
            } finally {
            context = nestedContext(context, mapper);
            }  
                break;
                    + "]"
        if (limit > 0 && fieldInfos.size() >= limit && fieldInfos.fieldInfo(fullPath) == null) {  
                    existingFieldMapper.typeName()  
        throws IOException {
     */
        if (builder == null && dynamic == ObjectMapper.Dynamic.STRICT_ALLOW_TEMPLATES) {
            try {
        String fieldName,
    /** Creates an copy of the current field with given field name and boost */  
            update = pathMappers.get(i).mappingUpdate(update);
                            dynamic.name().toLowerCase(Locale.ROOT),
     * rather than expanding them into nested object hierarchies.  
        DynamicProperty dynamicProperty
            if (previousMapper != null && newMapper.name().equals(previousMapper.name())) {
                ObjectMapper parent = docMapper.objectMappers().get(parentPath);
                fieldValueParser
        // Step 3: No template — use inferencer result directly.
    }
        }
            }
        }  
        // Handle disable_objects case: if the intermediate mapper doesn't exist and the last parent has disable_objects=true,  
                if (Strings.hasText(part) == false) {  
            parseObjectOrField(context, mapper);
                                } else {  
            String[] parts = fullFieldPath.split("\\.");
        // We evaluate ALL registered template types rather than stopping at the first match: if two
        String path = context.path().pathAsText(arrayFieldName);
            parentMappers.set(0, parentMappers.get(0).merge(update));  
            // mappings, and build an update with only the new mapper and its parents. This then becomes our  
    private static void internalParseDocument(
            assert newLast instanceof ObjectMapper;
            if (objectMapper.isEnabled() == false) {
                fieldMapper.parse(context);
    private static void addToLastMapper(List<ObjectMapper> parentMappers, Mapper mapper, boolean merge) {
            String[] replayPaths = splitAndValidatePath(fieldName);
                subfields = new String[] { flatFieldName.toString() };
        }
        }
        Map<DynamicFieldTypeInferencer, Set<String>> inferencers = context.mapperService().getDynamicFieldTypeInferencers();  
        XContentParser.Token token
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.Locale;
                        "object field starting or ending with a [.] makes object resolution ambiguous: [" + fullFieldPath + "]"  
            ParseContext replayContext = context.switchParser(replayParser);  
    private static Mapper.Builder<?> newFloatBuilder(String name, Settings settings) {
     * Body of the plugin-inference attempt. Path slots added by {@code getDynamicParentMapper} are  
            return builder;  
            case VALUE_NULL:
                Long.parseLong(text);  
        XContentParser.Token token
            } else {
            );  
                            paths[i],
        XContentParser.Token token = parser.nextToken();  
            final String[] parts = splitAndValidatePath(fullPath);
                    case STRICT_ALLOW_TEMPLATES:  
            parseDisableObjectsFields(context, objectMapper);
    }
                } else {
import org.opensearch.OpenSearchParseException;
                "object mapping ["
            for (int i = 0; i < parentPathSlots; i++) {
    }
            } else {
     *
        assert parentMappers.size() >= 1;
                    + existingMapper.getClass().getSimpleName()  
        } else {
            String arrayFieldName = lastFieldName;
            throw new MapperParsingException(
    ) throws IOException {  
                    throw new MapperParsingException(
        ObjectMapper.Dynamic dynamic = dynamicOrDefault(parentMapper, context);
                // ObjectMappers are skipped under disable_objects (their leaf FieldMappers handle it),  
            replayThroughExistingPath(context, resolvedParent, resolvedFieldName, rawContent);
        XContentParser parser  
            }
                            } else {  
            }  
                fm.parse(externalCtx);
        // Normal traversal with disable_objects check  
                entry,
            addFields(indexVersion, nestedDoc, parentDoc);
                    }  
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parentMapper.fullPath(), currentFieldName);  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    "object mapping for ["
        }
        SourceToParse source,
package org.opensearch.index.mapper;
    private static void parseCopyFields(ParseContext context, List<String> copyToFields) throws IOException {  
                context.path().remove();  
                        );
        ObjectMapper.Dynamic dynamic,  
        try (
                    + "] produced mapper with name ["
    }
                                        + currentFieldName
                continue;
                        parseValue(replayContext, parentMapper, fieldName, replayToken, replayPaths);  
                            + "]. Expected format: an object containing flat dotted field names with their values."  
                if (templateBuilder != null) {
                        Mapper.Builder builder = findTemplateBuilder(
            } finally {  
        // pre-deserialized object. Core stays free of any representation contract: each plugin streams
    private static boolean containsDisabledObjectMapper(ObjectMapper objectMapper, String[] subfields) {  
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();  
    private static void parseValue(
                    try {
        if (mapper != null) {
                processFlattenedTokenForDisableObjects(context, mapper, dottedFieldName, objToken);
                    }
            );  
        ObjectMapper mapper = currentParent == null ? context.root() : currentParent;  
            // Release path-slots added by getDynamicParentMapper before returning
 * Licensed to Elasticsearch under one or more contributor  
            Mapper.BuilderContext templateBuilderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
            // add the new mapper to the stack, and pop down to the original parent level
                    + "] for field ["
            i = expandCommonMappers(parentMappers, nameParts, i);  
        if (inferredFieldMapping == null) {  
            parseObjectOrField(context, mapper);  
        }
        XContentParser parser = context.parser();  
    /**  
                    }
    }  
                        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
                return true;  
    }
            }  
            }
    }
        if ((token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT)
        ObjectMapper resolvedParent = parentMapperTuple.v2();  
                                    parseObjectOrField(context, mapper);
        }
            return null;
                return builder;
        }
    // Throws exception if no dynamic templates found but `dynamic` is set to strict_allow_templates  
import org.opensearch.core.common.Strings;
            rawContent
                // not a double number
    }
                        .stream()
        }
    ) throws IOException {  
        return createUpdate(updateParent, nameParts, i + 1, newMapper);
            }
                // Build the full dotted field name by combining fieldName with current field name
                .createParser(originalParser.getXContentRegistry(), originalParser.getDeprecationHandler(), rawContent)  
                added++;  
import java.time.format.DateTimeParseException;
            ) {
    }  
        Set<String> claimingInferencerSupportedTypes = null;
                    () -> new BooleanFieldMapper.Builder(currentFieldName, context.indexSettings().getSettings())
                                    context.path().add(arrayFieldName);  
            dynamic = parentMapper.dynamic();
                // Instead, treat the remaining path as a flat field name and add the mapper directly  
            }  
    private static void validateStart(XContentParser parser) throws IOException {
                    // incoming token type, and paths — before the code fans out to parseObject /  
        }
        for (int i = parentMappers.size() - 1; i >= keepBefore; --i) {
            pathsAdded++;  
                // Handle primitive values with dynamic mapping - reuse existing parseDynamicValue  
                    // Before branching by token type, offer the field to plugin inferencers.
                                );
     * Determines if a field should be handled as a flat field based on disable_objects settings.
                throw new IllegalArgumentException("field name cannot be an empty string");
        ParseContext context,
        ObjectMapper withNewMapper = parentMappers.get(lastIndex).mappingUpdate(mapper);
                // For the first mapper case, seed with a root that contains just this ObjectMapper.
                        break;  
        if (token != null) {
        // This stops an inferencer from emitting a core built-in type (e.g. keyword, date, long), a type
                parseNonDynamicArray(context, mapper, fieldName, fieldName);  
     * same bytes are replayed through the normal unmapped-field logic so existing behavior is preserved.
                        context.addDynamicMapper(objectMapper);
        ParseContext.Document parentDoc = nestedDoc.getParent();
        if (existingMapper != null) {
        if (source.source() != null && source.source().length() == 0) {  
                currentFieldName = paths[paths.length - 1];
        final MediaType mediaType = source.getMediaType();  
            }
                            if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
            generateGroupingCriteria(context);  
                throw new MapperParsingException(
            // Object mode: use existing nested object parsing logic
        for (int i = 0; i < paths.length - 1; i++) {  
                addToLastMapper(parentMappers, newMapper, true);  
        Mapper mapper = builder.build(builderContext);  
                dynamic,
            }
            final String fieldName = paths[paths.length - 1];  
        }
     * {@code multi_value} type currently is; if that ever changes, that route needs equivalent
                return handleNoTemplateFound(dynamic, builderSupplierForText(currentFieldName, context));
                    }
            );  
     *  
    private static ObjectMapper createUpdate(ObjectMapper parent, String[] nameParts, int i, Mapper mapper) {
     * "new" when it is absent from the last-refreshed {@link FieldInfos} snapshot; existing fields
        Version indexVersion = context.indexSettings().getIndexVersionCreated();
                            + inferencer.getClass().getName()
            );  
                        throw new IllegalArgumentException("object field cannot contain only whitespace: ['" + fullFieldPath + "']");  
        ObjectMapper disableObjectsParent = pathMappers.get(pathMappers.size() - 1);
                context.path().remove();
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.STRING, dynamic, fullPath);  
            Tuple<Integer, ObjectMapper> parentMapperTuple = getDynamicParentMapper(context, paths, null);
        throws IOException {
        }
            try (
     * {@code get()}, so no parsing happens for fully-specified templates.  
            Mapper child = current.getMapper(fullNameParts[i]);
    ) throws IOException {
            }
     * @param entry         the plugin type string and its handler  
        // the tokens it needs. Plugins whose config is already complete never call get(), so no parsing  
        }
                                parseValue(context, mapper, currentFieldName, token, paths);  
            assert intermediate instanceof ObjectMapper;  
        Mapper inferredMapper = builder.build(builderContext);
        context.path().add(currentFieldName);
     * This method treats dotted field names (e.g., "user.name", "metrics.cpu.usage")
                            throw new StrictDynamicMappingException(
                    .createParser(context.parser().getXContentRegistry(), context.parser().getDeprecationHandler(), rawContent)
        return mapping.mappingUpdate(parentMappers.get(0));  
    private static boolean isEmptyDoc(Mapping mapping, XContentParser parser) throws IOException {
                switch (dynamic) {
                );
                copyAction.accept(copyToContext, field);
                || (isNested && context.mapperService().isCompositeIndexFieldNestedField(path)))) {
                }  
                            + "] was claimed by more than one dynamic field type inferencer: ["
     * </ul>
            }  
import org.opensearch.script.ContextAwareGroupingScript;
                                "It is forbidden to create dynamic nested objects (["
 * software distributed under the License is distributed on an
            context.path().add(paths[i]);
                        );
                        + "] with array for ["
    }  
     */
                            + "] and ["
                || numberType == XContentParser.NumberType.LONG
        // has declared their intent; we must not reject it because it falls below an inferencer  
    /**
                throw new MapperParsingException(
        Mapper.TypeParser.ParserContext parserContext = context.docMapperParser().parserContext();  
            case ObjectMapper om -> {
                Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.LONG, dynamic, fullPath);  
                "Document structure incompatibility: Cannot parse field ["  
                    copyToContext = context.switchDoc(targetDoc);
                                IndexMetadata.indexCreated(context.indexSettings().getSettings()),
            processExistingMapperForDisableObjects(context, fieldName, existingMapper);
        Mapper existingMapper = getMapper(context, parentMapper, fieldName, paths);
    private static DynamicTemplate findPluginTemplate(RootObjectMapper root, ContentPath path, String name, String pluginType) {  
                // Use parseNonDynamicArray which handles disable_objects mode properly
                                Mapper.BuilderContext builderContext = new Mapper.BuilderContext(
    private static void parseCopy(String field, ParseContext context) throws IOException {
        // We need to add the uid or id to this nested Lucene document too,
        } else {  
        String currentFieldName = parser.currentName();
        if (token == XContentParser.Token.VALUE_STRING) {
                break;  
        ParseContext context,  
            }  
        XContentParser.Token token
        // (including an exception, e.g. buffering failure or an ambiguous-claim MapperParsingException)  
     * @param parentMapper the parent object mapper with disable_objects enabled  
            parseObjectOrNested(context, objectMapper);  
     * before the normal token-type branching takes place in {@link #innerParseObject}.
                }
        // Find the disable_objects parent index  
        Mapper previousMapper = null;
        // Replay buffered content through the new mapper
                        return handleNoTemplateFound(
    @SuppressWarnings("rawtypes")
                throw new MapperParsingException("No mapper found for extra field [" + fullPath + "]");  
        // and inner hits to fail or yield incorrect results.
            XContentParser.NumberType numberType = context.parser().numberType();
            // "new mapper", and can be added to the stack.
        } finally {
                                assert mapper != null;  
        if (objectMapper.nested().isNested() && context.indexSettings().isPluggableDataFormatEnabled()) {  
            context.sourceToParse().source(),
            parseDynamicValue(context, mapper, fieldName, token);
                if (inferredFieldMapping != null) {
                if (builder == null) {
        if (!docMapper.root().disableObjects()) {
     */
    @SuppressWarnings("rawtypes")  
            case VALUE_EMBEDDED_OBJECT:  
                        throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), parent.fullPath(), paths[i]);
            throw new StrictDynamicMappingException(dynamic.name().toLowerCase(Locale.ROOT), fieldFullPath, name);
    }
            Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.BOOLEAN, dynamic, fullPath);  
        // type strings its own plugin registered, so it may only produce a type it owns.
import org.opensearch.Version;
        CheckedBiConsumer<ParseContext, String, IOException> copyAction
                assert targetDoc != null;  
            objectMapper = objMapper;  
                    Mapper fieldMapper = mapper.getMapper(currentFieldName);  
        final ObjectMapper lastParent = parentMappers.get(parentMappers.size() - 1);
    }
                    case FALSE_ALLOW_TEMPLATES:
            }  
                        break;
            if (i == parts.length - 1) break;
        }
        String pluginType = entry.getKey();
        ParseContext context,
                        + arrayFieldName
                for (int i = 0; i < added; i++) {
import java.util.ArrayList;  
    private static byte[] parseChildToBytes(ParseContext context) throws IOException {
            ParseContext.Document rootDoc = context.rootDoc();
        }  
                return builder;
            context.decrementFieldCurrentDepth();  
        if (token == XContentParser.Token.VALUE_NULL) {
                docMapperParser.getXContentRegistry(),
        String[] fullNameParts = splitAndValidatePath(newMapper.name());
        DocumentInput documentInput
            // Advance past START_OBJECT to get to the first field name
            boolean parseableAsLong = false;
            mapper = context.docMapper().objectMappers().get(currentPath);  
                        + "] tried to parse as array, but got EOF, is there a mismatch in types for the same field?"  
        // Hand plugins a factory that produces a fresh parser over the buffered bytes rather than a
        for (int i = 0; i < disableObjectsIndex; i++) {  
            } else if (token != XContentParser.Token.FIELD_NAME) {
     * out into {@code parseObject} / {@code parseArray} / {@code parseValue}. Placing the hook here means
        }  
                // Even with disable_objects, we can have nested ObjectMappers for explicitly defined sub-objects
    private static Tuple<Integer, ObjectMapper> getDynamicParentMapper(
import java.util.HashMap;
        ObjectMapper.Dynamic dynamic,
            }
        }  
            // may have other subfields which will not be updated. Instead, we pull the mapper from the existing
        // then nested.nested1.status/nested.nested1/nested array should not be blocked
        DocumentMapper docMapper,  
        return false;  
            // Pluggable data format: signal the per-element boundary explicitly on the DocumentInput.
        }  
                claim = inferencer.inferFieldType(fieldValueParser);
                return handleNoTemplateFound(
            );
    /**
    }  
            int added = 0;  
        Map<String, Object> config = new HashMap<>(dynamicProperty.mappingForName(currentFieldName));  
    }
            } finally {  
            context.sourceToParse().id(),
        // This is the path for fields with no user-defined template: each inferencer checks whether  
        }
            DynamicFieldTypeInferencer inferencer = entry.getKey();
    /** Scans dynamic templates on the root mapper for one whose {@code match_mapping_type} equals {@code pluginType} and whose path/name patterns match. */
    }
 * The OpenSearch Contributors require contributions made to  
                return;  
                        return handleNoTemplateFound(dynamic, () -> {  
            if (existingFieldMapper != null) {  
     */  
    }
        Mapper existingMapper = mapper.getMapper(fieldName);  
        }  
        if (!context.isWithinCopyTo() && copyToFields.isEmpty() == false) {  
                        // not dynamic, read everything up to end object
                fieldMapper.parse(innerContext);  
            parseCopyFields(context, fieldMapper.copyTo().copyToFields(), childBytes);
        } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
                parseableAsLong = true;
                return handleNoTemplateFound(dynamic, () -> new BinaryFieldMapper.Builder(currentFieldName));
            final String rejectedType = inferredType;
            }
                "object mapping for ["
        return true;
        String nestedPathFieldName = NestedPathFieldMapper.name(indexVersion);
            }  
        }  
                        context.addDynamicMapper(mapper);  
        String templateMatchedType = null;
        }
            context.docs(),  
        if (dynamic == ObjectMapper.Dynamic.FALSE_ALLOW_TEMPLATES) {
     * Handles ObjectMapper parsing with disable_objects logic.  
            // disable_objects mode: incorporate object flattening logic directly
    /**  
    // looks up a child mapper, but takes into account field names that expand to objects  
        }
        } else if (mapper instanceof FieldAliasMapper) {
        pathMappers.add(current);
     * Processes a field when disable_objects is enabled, handling both existing mappers and dynamic mapping.
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
                } else {  
    }
            return;
                                    context.addDynamicMapper(mapper);
            } catch (Exception e) {
        }  
     * Handles existing field mapper parsing with proper path management.
        } else {
    }
    }  
        ObjectMapper.Dynamic dynamic,
            // then the stack will only have a on it because we will have already merged a.c.d into the stack.
        }
                    throw new IllegalArgumentException(
            parseCopyFields(context, fieldMapper.copyTo().copyToFields());
                for (int i = 0; i < parentMapperTuple.v1(); i++) {
        final FieldValueParserSupplier fieldValueParser = new FieldValueParserSupplier(
                return true;  
            context.sourceToParse().getMediaType(),
     * this the field would be absent from the document input and its LIST column cell would be  
                "The provided mapper [" + mapper.name() + "] has an unrecognized type [" + mapper.getClass().getSimpleName() + "]."
        if (token != XContentParser.Token.START_OBJECT) {
                    Locale.ROOT,
        }  
     */
            throw new MapperParsingException(  
                    context.path().remove();
     * @param fieldValueParser produces a fresh parser over the buffered field bytes
import org.apache.logging.log4j.message.ParameterizedMessage;  
            default -> throw new MapperParsingException(
        assert currentFieldName != null;  
        ) {
        // then we should add the field directly to the last parent instead of trying to create intermediate objects
                                }
        parseObjectOrField(context, mapper);
        }  
                    // parseArray / parseValue. Placing the hook here means one method covers arrays,
            }
            context = context.createCopyToContext();
                }  
                    "Unexpected token [" + objToken + "] while flattening object for field [" + fieldName + "]"
            return true;
            context.documentInput().addField(fieldMapper.fieldType(), List.of());
                    }
            parser.getDeprecationHandler(),
        Mapper cached = context.lookupDynamicPropertyMapper(fullPath);
    }  
        // Handle null values
    /**  
        }
                    .xContent()
                    return builder;  
        } else if (objectMapper.disableObjects()) {
        ObjectMapper current = docMapper.root();
    ParsedDocument parseDocument(SourceToParse source, MetadataFieldMapper[] metadataFieldsMappers, DocumentInput documentInput)
        if (dynamic == null) {  
        popMappers(parentMappers, 1, true);  
                    + MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey()
                            XContentFieldType.OBJECT,
                current = om;
    private static void parseNonDynamicArray(ParseContext context, ObjectMapper mapper, final String lastFieldName, String arrayFieldName)  
    private static boolean parsesArrayValue(Mapper mapper) {
            } else {
        XContentParser parser = context.parser();
                parseCopyFields(externalCtx, fm.copyTo().copyToFields());  
                    Mapper.Builder builder = findTemplateBuilder(context, currentFieldName, XContentFieldType.DOUBLE, dynamic, fullPath);
                                currentFieldName,  
            return;
                            dynamic,  
                }
                StringBuilder flatFieldName = new StringBuilder();
                    }
            for (int i = 0; i < parentMapperTuple.v1(); i++) {  
            return new String[] { fullFieldPath };  
            }  
     */
            context.parser().skipChildren();
                        );
     * Replays raw-buffered field content through the normal unmapped-field logic — dynamic  
                        continue;
            bufferBuilder.copyCurrentStructure(parser);  
     * Parses an object (disable_objects=true).  
    private static void processFlattenedTokenForDisableObjects(
    }
     *         content was replayed through the existing path); {@code false} to fall through to the normal
            return mapperParsingException;
     */
    ParsedDocument parseDocument(SourceToParse source, MetadataFieldMapper[] metadataFieldsMappers) throws MapperParsingException {
    private static void replayThroughExistingPath(ParseContext context, ObjectMapper parentMapper, String fieldName, byte[] rawContent)  
     * Handles existing mapper processing for disable_objects mode.
                }
        ObjectMapper.Dynamic dynamic = parentMapper.dynamic();
    ) throws IOException {
            }
            case FIELD_NAME:  
            }
        Mapper mapper = context.docMapper().mapping().getMetadataMapper(fieldPath);
                    resolvedFieldName
     *   <li>Dynamic mapping is {@code STRICT} or {@code FALSE} on the parent object — existing behavior applies.</li>
            // delete it when the root document is deleted too.
        }
                    break;  
                                parseNonDynamicArray(context, parentMapper, lastFieldName, arrayFieldName);
        if (token == XContentParser.Token.START_OBJECT) {  
        }
 * Modifications Copyright OpenSearch Contributors. See
    }  
                            context.indexSettings().getSettings(),
            if (i < nameParts.length - 1) {
        }
            && !fieldMapper.copyTo().copyToFields().isEmpty()) {  
                    + fullPath
        // Build the update from the disable_objects parent back up to root
        Mapper.TypeParser typeParser = parserContext.typeParser(inferredType);
            );  
                                        + "] as object, but got EOF, has a concrete value been provided to it?"  
                ParseContext.Document doc = context.doc();  
                // If parentMapper is ever null, it means the parent of the current mapper was dynamically created.  
                                if (parsesArrayValue(mapper)) {
                break;
                            parseObject(context, mapper, currentFieldName, paths);  
            internalParseDocument(mapping, metadataFieldsMappers, context, parser);  
            }
            }
            default:
            try {
            if (objectMapper != null) {  
 * A parser for documents, given mappings from a DocumentMapper
            // a.b, and we want to merge b back into the stack so it just contains a
                newMapper = createExistingMapperUpdate(parentMappers, nameParts, i, docMapper, newMapper);  
    }
            }
                "dynamic_property pattern ["
            throw new MapperParsingException(
                    case STRICT:
            return false;
                return ObjectMapper.Dynamic.TRUE;
                    if (field.startsWith(doc.getPrefix())) {
                case START_OBJECT:
            throw wrapInMapperParsingException(source, e);  
    }  
            }
            String currentPath = context.path().pathAsText(paths[i]);
        return dynamic;  
        if (dynamic == ObjectMapper.Dynamic.FALSE) {
        XContentParser.Token token = context.parser().currentToken();
            // on pre-2.0 indices) keeps the signalled path a clean dotted path.
    private static Mapper.Builder findPluginTemplateBuilder(
        }  
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), sourceBytes)  
            // No template and no inferencer claimed this field — fall through to existing path
        Mapper.Builder templateBuilder = null;
                // foo did not yet exist. This will create 2 copies in dynamic mappings, which should be identical.
                newMapper.merge(previousMapper);  
     * limit, caches the mapper, and parses the field value.
            }
    /** Creates an update for intermediate object mappers that are not on the stack, but parents of newMapper. */
    }
            }
            }
        if (newMapper instanceof ObjectMapper) {  
            if (objectMapper.nested().isNested()) {  
            XContentParser parser = context.parser();
    /**
            return () -> new TextFieldMapper.Builder(fieldName, context.mapperService().getIndexAnalyzers());
        // Handle concrete values - when disable_objects=true, we should treat the field name as a literal  
                                        + mapper.name()  
            return null;
        applyExtraFieldValues(context);  
    private static void innerParseObject(
                    "Cannot add a value for field [" + fullPath + "] since one of the intermediate objects is nested: [" + parent + "]"
        if (parentMappers.isEmpty()) {
import java.io.IOException;
                || numberType == XContentParser.NumberType.BIG_INTEGER) {
                            context.path()
        }
     * <p>When buffering does occur, the content is kept for replay: if no plugin claims the field, the
            final XContentParser.Token token = parser.nextToken();  
                    disableObjectsIndex = k;
        } else {  
                    "Dynamic field type inferencer [{}] returned type [{}] for field [{}] outside its declared supportedTypes(); ignoring the claim",
        XContentFieldType matchType,
            }
import java.util.Set;
        Mapper mapper = getMapper(context, parentMapper, lastFieldName, paths);  
    static void parseObjectOrNested(ParseContext context, ObjectMapper mapper) throws IOException {
        String fieldName,  
                fieldMapper.parse(context);
            parser.skipChildren();
                    case TRUE:
            validateEnd(parser);
        if (mapper != null) {
        if (efv.isEmpty()) {  
    private static void parseExistingFieldMapper(ParseContext context, String fieldName, Mapper existingMapper) throws IOException {
        List<ObjectMapper> pathMappers = new ArrayList<>();  
                    + "]"
     */
        Mapper.Builder builder = context.root().findTemplateBuilder(context, name, dateFormat);
        // If we do not do this then when a document gets deleted only the root Lucene document gets deleted and  
     * @return a {@link Mapper.Builder} ready to build the mapper, or {@code null} if no template matched
     */  
                    paths = resolvePathForParsing(mapper, currentFieldName);
        }  
     *
                        case TRUE:
                break;  
            throw new IllegalStateException("found leftover path elements: " + remainingPath);
                    + dynamicProperty.getPattern()
            // Pluggable data formats write _id to the DocumentInput, so it is only required here on vanilla indices.
     * <p>Strictly gated: no-op unless the pluggable data format is enabled and the resolved leaf is
                            return new DateFieldMapper.Builder(
        }
            if (!nested.isIncludeInParent() || parentDoc != rootDoc) {  
            case FieldMapper fm -> {
     * inject any required parameters before the {@link Mapper.TypeParser} builds the  
    @SuppressWarnings("rawtypes")
     * Returns the next unprocessed index from nameParts.
            return;  
    }
        if (leaf instanceof ParametrizedFieldMapper fieldMapper && fieldMapper.fieldType().isMultiValueSupported()) {
     * mapper. This runs before TypeParser so that parameters that can only be inferred from the data
                                XContentFieldType.OBJECT,
        parseCopyFieldsInternal(context, copyToFields, (copyToContext, field) -> parseCopy(field, copyToContext));
            XContentParser replayParser = originalParser.contentType()
        final int parentPathSlots = parentMapperTuple.v1();
                context.path().remove();
