            }
            switch (type) {
                parserContext.indexVersionCreated(),
import org.opensearch.common.settings.Settings;
                    String realFieldName = fieldNameParts[fieldNameParts.length - 1];
    }
        }
                        throw new MapperParsingException("No handler for type [" + type + "] declared on field [" + fieldName + "]");
        if (this.disableObjects() && newMapper instanceof ObjectMapper) {
            .stream()
            if (Boolean.TRUE.equals(disableObjects.value())) {
            }
                if (mergeWith.includeInRoot.explicit()) {
                    throw new MapperParsingException(
                    compositeField = fieldNode;
    /**
     * Type parser for object field mapper
 * Unless required by applicable law or agreed to in writing,
            if (fieldNode != null) {
        public static boolean isParent(ObjectMapper parentObjectMapper, ObjectMapper childObjectMapper, MapperService mapperService) {
    public Query nestedTypeFilter() {
     * @param newMapper The new mapper being added
        return this.enabled.value();
            }
                if (entry.getValue() instanceof Map) {
        }
 * specific language governing permissions and limitations
                Mapper mapper = builder.build(context);
package org.opensearch.index.mapper;
            builder.endObject();
            // Validate flat field compatibility during build
    /**
    @Override
                );
                );
            Iterator<Map.Entry<String, Object>> iterator = propsNode.entrySet().iterator();
                    objBuilder.add(fieldBuilder);
                        intermediate.add(fieldBuilder);
     * Validates that no nested object definitions exist when disable_objects is enabled.
     * @opensearch.api
            mapper.canDeriveSource();
        public static Nested newNested() {
        }
            return parentObjectMapper == parent;
    public void canDeriveSource() {
                }
            }
            this.builder = (T) this;
            }
                // user can't provide an empty Map. (PHP for example)
         * Contains logic to parse 'composite' section of mappings. This should be called only after
                return true;
                    "[include_in_all] is deprecated, the _all field have been removed in this version"
                builder.nested = Nested.newNested(nestedIncludeInParent, nestedIncludeInRoot);
                    @SuppressWarnings("unchecked")
            .toArray(size -> new Mapper[size]);
                }
        }
                    throw new MapperParsingException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.Nullable;
                            // (usually, setting enabled to false to not index
    public ObjectMapper merge(Mapper mergeWith, MergeReason reason) {
    /**
            }
                        Mapper.Builder<?> fieldBuilder = typeParser.parse(realFieldName, propNode, parserContext);
    public Mapper getMapper(String field) {
        ObjectMapper mappingUpdate = clone();
        STRICT,
        private static Mapper.TypeParser getSupportedCompositeTypeParser(String type, ParserContext parserContext) {
            String name,
                    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                } else {
    }
        Explicit<Boolean> enabled,
            Explicit<Boolean> nestedIncludeInParent = new Explicit<>(false, false);
                        "Set '%s' as true as part of index settings to use star tree index",
            ObjectMapper.Builder builder,
                builder.startObject("derived");
 * Licensed to Elasticsearch under one or more contributor
            throw new IllegalArgumentException("can't merge a non object mapping [" + mergeWith.name() + "] with an object mapping");
            mapperService
            Explicit<Boolean> disableObjects,
        public boolean isIncludeInRoot() {
        if (this.disableObjectsExplicit().explicit() && mergeWith.disableObjectsExplicit().explicit()) {
                }
                disableObjects,
                    throw new MapperParsingException(
                Map.Entry<String, Object> entry = iterator.next();
                    parseDerived(builder, (Map<String, Object>) fieldNode, parserContext);
        if (this.nested.isNested() && this.pluggableDataFormatEnabled == false) {
        public static final Explicit<Boolean> DISABLE_OBJECTS = new Explicit<>(false, false);
                    builder.dynamic(Dynamic.STRICT);
                        + "] to ["
    @Override
            while (iterator.hasNext()) {
        FALSE,
            Map<String, Object> compositeNode,
            if (nested.isIncludeInRoot()) {
                        StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey()
                    String[] fieldNameParts = fieldName.split("\\.");
        merged.doMerge(mergeWithObject, reason);
    public static final String NESTED_CONTENT_TYPE = "nested";
                    if (childMapper instanceof ObjectMapper) {
        public boolean isNested() {
                    Mapper.TypeParser typeParser = getSupportedCompositeTypeParser(type, parserContext);
        this.fullPath = fullPath;
            Explicit<Boolean> nestedIncludeInRoot = new Explicit<>(false, false);
            context.path().remove();
                            // if there is a single property with the enabled
            @Override
            }
 *
     * Build a mapping update with the provided sub mapping update.
            return new Nested(true, new Explicit<>(false, false), new Explicit<>(false, false));
        return merged;
                        "Field mapping conflict: Cannot add nested object field ["
                return true;
 * under the License.
    }
            Map<String, Mapper> mappers,
                    Map<String, Object> propNode = (Map<String, Object>) entry.getValue();
        mappers = mappers.copyAndPut(mapper.simpleName(), mapper);
                    includeInParent = mergeWith.includeInParent;
            this.includeInParent = includeInParent;
    @Override
                // Should accept empty arrays, as a work around for when the
            ParserContext parserContext
        }
                "DocType mapping definition has unsupported parameters: "
        if (reason == MergeReason.INDEX_TEMPLATE) {
                    if (fieldNameParts.length < 1) {
            clone = (ObjectMapper) super.clone();
     */
    }
                merged = mergeWithMapper;
                    + name()
    public static class Nested {
            Object fieldNode = node.get("type");
                } else {
                    iterator.remove();
        public T disableObjects(boolean disableObjects) {
    }
                    }
                    throw new MapperParsingException(
        }
        }
 * SPDX-License-Identifier: Apache-2.0
        ) {
        Arrays.sort(sortedMappers, new Comparator<Mapper>() {
        int count = 0;
            return this.builder;
                parserContext.indexVersionCreated(),
                }
            }
                        e
        for (Mapper mapper : this.mappers.values()) {
 */
import org.opensearch.index.mapper.MapperService.MergeReason;
                    if (parseObjectOrDocumentTypeProperties(fieldName, fieldNode, parserContext, builder)) {
        protected static void parseDerived(ObjectMapper.Builder objBuilder, Map<String, Object> derivedNode, ParserContext parserContext) {
        protected static void parseNested(
    public String nestedTypePath() {
        public T add(Mapper.Builder builder) {
        builder.endObject();
    private volatile CopyOnWriteHashMap<String, Mapper> mappers;
                            + "] when disable_objects is enabled for ["
                    for (int i = fieldNameParts.length - 2; i >= 0; --i) {
         */
    /**
        }
                        IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
            DocumentMapperParser.checkNoRemainingFields(
     * Provides clear indication of flat vs nested conflict with field name.
        // sort the mappers so we get consistent serialization format
                    builder.nested = Nested.NO;
                builder.field("include_in_root", true);
                String fieldName = entry.getKey();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    parseProperties(builder, (Map<String, Object>) fieldNode, parserContext);
        public boolean isIncludeInParent() {
            throw new RuntimeException(e);
         * parsing normal properties as this checks if the given fields are also source fields of the index.
                    + "]. With disable_objects=true, all fields must use flat field notation (e.g., 'field.name' as a single field) "
                } else if (isEmptyList) {
                boolean includeInParent = XContentMapValues.nodeBooleanValue(fieldNode, name + ".include_in_parent");
            ObjectMapper parent = childObjectMapper.getParentObjectMapper(mapperService);
            .stream()
    public ObjectMapper merge(Mapper mergeWith) {
            if (fieldNode != null) {
                return true;
                    if (typeParser == null) {
            if (compositeField != null) {
        this.enabled = enabled;
     * Returns the parent {@link ObjectMapper} instance of the specified object mapper or <code>null</code> if there
     * Dynamic field mapping specification
        } else if (mappers.isEmpty() && custom == null) {
        public T dynamic(Dynamic dynamic) {
 * KIND, either express or implied.  See the License for the
    }
                        "Configuration error: Parameter [disable_objects] must be a boolean value (true or false), but got ["
     * @throws MapperParsingException if nested objects are found when disable_objects=true
                String fieldName = entry.getKey();
                    );
import java.util.ArrayList;
                    String realFieldName = fieldNameParts[fieldNameParts.length - 1];
            Nested nested,
            }
            .filter(m -> !(m instanceof DerivedFieldMapper || m instanceof ContextAwareGroupingFieldMapper))
        protected static boolean parseObjectOrDocumentTypeProperties(
    public Iterator<Mapper> iterator() {
        super(name);
        }
                }
                    }
        private Explicit<Boolean> includeInParent;
            custom.toXContent(builder, params);
                return o1.name().compareTo(o2.name());
                // user can't provide an empty Map. (PHP for example)
    public void validate(MappingLookup mappers) {
            if (mergeIntoMapper == null) {
                parseCompositeField(builder, (Map<String, Object>) compositeField, parserContext);
        // Pluggable formats derive nested source natively; vanilla deriveSource() does not read nested child docs.
        }
    @SuppressWarnings("rawtypes")
        } else {
                            + "rather than nested object structures."
            .filter(m -> m instanceof DerivedFieldMapper)
            includeInRoot = new Explicit<>(value, true);
            if (nested) {
    @PublicApi(since = "1.0.0")
     */
                    includeInRoot = mergeWith.includeInRoot;
    }
                if (type.equals(CONTENT_TYPE)) {
            String parentNestObjectPath = fullPath().substring(0, indexOfLastDot);
            } else if (mergeIntoMapper instanceof ObjectMapper objectMapper) {
    public boolean parentObjectMapperAreNested(MapperService mapperService) {
                    DocumentMapperParser.checkNoRemainingFields(fieldName, propNode, parserContext.indexVersionCreated());
        if (name.isEmpty()) {
                    }
     * Provides descriptive error message including the field name and attempted change.
        return this.fullPath;
            this.nestedTypePath = "__" + fullPath;
                    iterator.remove();
        }
        Map<String, Mapper> mappers,
                    throw new IllegalArgumentException(
            this.nested = nested;
                        "can't merge a non object mapping [" + mergeWithMapper.name() + "] with an object mapping"
            throw new MapperException(
                        + "]. The disable_objects setting is immutable after index creation."
                    Mapper.Builder<?> fieldBuilder = typeParser.parse(realFieldName, node, parserContext);
            String name,
            }
    protected ObjectMapper clone() {
            }
            );
    public enum Dynamic {
                        + name()
                }
        if (version.before(Version.V_2_0_0)) {
    private final boolean pluggableDataFormatEnabled;
            return builder;
 * ownership. Elasticsearch licenses this file to you under
        }
            }
                } else if (!(fieldNode instanceof Map)) {
        }
 * this work for additional information regarding copyright
                            // any type, including core values, which
     *
            String fieldName,
                }
            this.dynamic = mergeWith.dynamic;
                return true;
            String fullPath,
        public void merge(Nested mergeWith, MergeReason reason) {
import org.opensearch.common.Explicit;
            return null;
                        fieldBuilder = intermediate;
            for (Mapper.Builder builder : mappersBuilders) {
                    Mapper.TypeParser typeParser = parserContext.typeParser(DerivedFieldMapper.CONTENT_TYPE);
                context.indexSettings()
                            ObjectMapper.Builder<?> intermediate = new ObjectMapper.Builder<>(fieldNameParts[i]);
    private final Query nestedTypeFilter;
                        }
     * Validates that disable_objects parameter is not being modified after index creation.
     * Parameter defaults
                        throw new MapperParsingException("Invalid field name " + fieldName);
        Settings settings
                        Mapper.Builder<?> fieldBuilder = typeParser.parse(fieldName, propNode, parserContext);
            );
            this.nestedTypePath = fullPath;
        return dynamic;
        public static final Nested NO = new Nested(false, new Explicit<>(false, false), new Explicit<>(false, false));
     * This is called during index creation to ensure compatibility.
                    Object typeNode = propNode.get("type");
        ) {
    }
                propsNode,
            }
                        ObjectMapper.Builder<?> intermediate = new ObjectMapper.Builder<>(fieldNameParts[i]);
    }
                    String.format(
            Dynamic dynamic,
import org.opensearch.common.collect.CopyOnWriteHashMap;
                if (childMapper instanceof ObjectMapper) {
     *
            fieldNode = node.get("include_in_parent");
                } else {
        }
        )) {
            } else if (fieldName.equals("enabled")) {
                    }
            Nested nested,
import java.util.Map;
                mappers,
        if (custom != null) {
                    throw new IllegalArgumentException("cannot change object mapping from non-nested to nested");
                        throw new MapperParsingException(
                if (fieldName.equals("composite")) {
        }
                } else if (type.equals(NESTED_CONTENT_TYPE)) {
            }
            // Validate disable_objects immutability (except for MAPPING_RECOVERY)
 * Field mapper for object field types
     */
            }
        }
            // Important : Composite field is made up of 2 or more source fields of the index, so this must be called
                    iterator.remove();
            if (compositeNode.size() > StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING.get(parserContext.getSettings())) {
                if (existing != null) {
        for (Mapper mapper : sortedMappers) {
        @Deprecated
                        throw new MapperParsingException("No handler for type [" + type + "] declared on field [" + fieldName + "]");
                    } else {
 * license agreements. See the NOTICE file distributed with
        if (nested.isNested()) {
 *
                    }
                    Map<String, Object> propNode = (Map<String, Object>) entry.getValue();
 * The OpenSearch Contributors require contributions made to
                nested,
        private final boolean nested;
                        "Expected map for property [fields] on field [" + fieldName + "] but got a " + fieldName.getClass()
        for (ObjectMapper parent = getParentObjectMapper(mapperService); parent != null; parent = parent.getParentObjectMapper(
                    );
            } else if (fieldName.equals("include_in_all")) {
                    validateNestedObjectRejection(mergeWithMapper);
                        // Standard behavior: split dotted names and create intermediate object mappers
            }
        this.disableObjects = disableObjects;
            ObjectMapper.Builder builder
        });
            }
        }
                    throw new MapperParsingException(
    private final String fullPath;
    }
            // literal names and will incorrectly split them into intermediate object mappers.
import java.util.Comparator;
                    }
import org.opensearch.common.annotation.PublicApi;
     * @opensearch.api
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
    /**
                    // and don't create intermediate object mappers
            contextAwareGroupingMapper.toXContent(builder, params);
            // after parsing all other properties
import org.opensearch.common.xcontent.support.XContentMapValues;
            if (parentObjectMapper == null || childObjectMapper == null) {
     * @opensearch.internal
                builder.field("include_in_parent", true);
                    String.format(
            Iterator<Map.Entry<String, Object>> iterator = derivedNode.entrySet().iterator();
            DocumentMapperParser.checkNoRemainingFields(
                    merged = mergeIntoMapper.merge(mergeWithMapper);
        } else {
    public String typeName() {
        if (mergeWith.dynamic != null) {
 * this file be licensed under the Apache-2.0 license or a
            this.includeInRoot = includeInRoot;
                    propNode.remove("type");
        if (count > 0) {
import org.apache.lucene.index.LeafReader;
    }
        builder.startObject(simpleName());
import java.io.IOException;
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
            if (mergeWith.enabled.explicit()) {
                    if (typeNode != null) {
    private void validateNestedObjectRejection(Mapper newMapper) {
                }
            mappersBuilders.add(builder);
            @Nullable Settings settings
                    objBuilder.add(fieldBuilder);
            }
            return includeInRoot.value();
                    throw new MapperException("the [include_in_root] parameter can't be updated on a nested object mapping");
                        "Expected map for property [derived_fields] on field [" + fieldName + "] but got a " + fieldName.getClass()
                if (entry.getValue() instanceof Map) {
            if (!(mapper instanceof MetadataFieldMapper)) {
            );
    private Explicit<Boolean> enabled;
    public Nested nested() {
        STRICT_ALLOW_TEMPLATES,
                    // nothing to do here, empty (to support "properties: []" case)
        }
            @Override
        }
                        type = typeNode.toString();
        }
            }
import org.opensearch.core.xcontent.ToXContent;
                            type = ObjectMapper.CONTENT_TYPE;
                dynamic,
    public static class Builder<T extends Builder> extends Mapper.Builder<T> {
        private Nested(boolean nested, Explicit<Boolean> includeInParent, Explicit<Boolean> includeInRoot) {
        }
                        "Expected map for property [fields] on field [" + fieldName + "] but got a " + fieldName.getClass()
     * @throws MapperException if disable_objects is being changed
                    // When disable_objects is enabled, treat dotted field names as literal field names
import java.util.Arrays;
    @Override
                if (reason == MergeReason.INDEX_TEMPLATE) {
    public static class TypeParser implements Mapper.TypeParser {
        this.nestedTypeFilter = NestedPathFieldMapper.filter(version, nestedTypePath);
            @Nullable Settings settings
                    } else {
        ) {
                                + "]. With disable_objects=true, all fields must use flat field notation (e.g., 'field.name' as a single field) "
            }
        FALSE_ALLOW_TEMPLATES
                    )
                node.remove("include_in_parent");
                    }
    @PublicApi(since = "1.0.0")
        if (count > 0) {
                        } else if (propNode.size() == 1 && propNode.get("enabled") != null) {
        }
            }
            return builder;
        protected static void parseProperties(ObjectMapper.Builder objBuilder, Map<String, Object> propsNode, ParserContext parserContext) {
        builder.endObject();
                String type = fieldNode.toString();
                Object fieldNode = entry.getValue();
            if (IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.get(parserContext.getSettings()) == false) {
                validateDisableObjectsImmutability(mergeWith, reason);
                    String[] fieldNameParts = fieldName.split("\\.");
     */
        }
                );
                // user can't provide an empty Map. (PHP for example)
            // Parse disable_objects first so it's available when parseProperties is called.
            ParserContext parserContext,
                    builder.disableObjects(XContentMapValues.nodeBooleanValue(fieldNode, fieldName + ".disable_objects"));
                } else {
        }
            } else {
                "Field mapping conflict: Cannot add nested object field ["
     * @throws MapperException if attempting to add nested object when disable_objects=true
                if (entry.getValue() instanceof Map) {
     */
                parserContext.indexVersionCreated(),
            builder.field("enabled", enabled.value());
                throw new MapperException(
    }
        public static Nested newNested(Explicit<Boolean> includeInParent, Explicit<Boolean> includeInRoot) {
            }
                }
    }
    private void validateFlatFieldCompatibility() {
    @PublicApi(since = "1.0.0")
        Version version = IndexMetadata.indexCreated(settings);
                            type = ObjectMapper.CONTENT_TYPE;
                    );
                        fieldBuilder = intermediate;
                "DocType mapping definition has unsupported parameters: "
            this.mappers = new CopyOnWriteHashMap<>();
/*
                boolean isEmptyList = entry.getValue() instanceof List && ((List<?>) entry.getValue()).isEmpty();
        /**
            Mapper merged;
            }
    @Override
            }
        }
                }
                compositeNode,
        String fullPath,
                this.disableObjects = mergeWith.disableObjectsExplicit();
                                + name
            }
     * @opensearch.internal
                }
    public String name() {
 * the Apache License, Version 2.0 (the "License"); you may
            String fullPath,
            // only write the object content type if there are no properties, otherwise, it is automatically detected
                    builder.dynamic(Dynamic.FALSE_ALLOW_TEMPLATES);
        public void setIncludeInParent(boolean value) {
                if (includeInRoot.value() != mergeWith.includeInRoot.value()) {
                    throw new IllegalArgumentException("cannot change object mapping from nested to non-nested");
                        + "] for object mapping ["
                        // field name is just ".", which is invalid
import java.util.Iterator;
    /**
        }
                            + "]. With disable_objects=true, all fields must use flat field notation (e.g., 'field.name' as a single field) "
    }
            if (disableObjectsNode != null) {
            this.disableObjects = new Explicit<>(disableObjects, true);
            return createMapper(name, fullPath, enabled, nested, dynamic, Defaults.DISABLE_OBJECTS, mappers, settings);
                    if (Boolean.TRUE.equals(objBuilder.disableObjects.value())) {
     */
            if (parent.nested().isNested() == false) {
                            + fieldNode
            Object fieldNode,
                    } else {
        if (!(mergeWith instanceof ObjectMapper mergeWithObject)) {
                    Map<String, Object> node = (Map<String, Object>) entry.getValue();
        return nestedTypePath;
        }
                    builder.dynamic(dynamic ? Dynamic.TRUE : Dynamic.FALSE);
        ObjectMapper merged = clone();
                            + e.getMessage(),
                    )
                                + "rather than nested object structures."
        try {
    /**
                throw new MapperException("the [enabled] parameter can't be updated for the object mapping [" + name() + "]");
            builder.field("type", NESTED_CONTENT_TYPE);
        if (contextAwareGroupingMapper != null) {
        return this.fullPath;
                    // field name is just ".", which is invalid
                } catch (IllegalArgumentException e) {
    public void toXContent(XContentBuilder builder, Params params, ToXContent custom) throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
                } else {
        for (Mapper mergeWithMapper : mergeWith) {
                        objBuilder.add(fieldBuilder);
                if (reason != MergeReason.INDEX_TEMPLATE && reason != MergeReason.MAPPING_RECOVERY) {
     * @opensearch.internal
            builder.field("dynamic", dynamic.name().toLowerCase(Locale.ROOT));
        this.nested = nested;
            if (fieldNode != null) {
     * @param reason The reason for the merge
@PublicApi(since = "1.0.0")
                    }
                    String.format(
            return builder;
        public T enabled(boolean enabled) {
                        // lets see if we can derive this...
            mapper.validate(mappers);
                        }
    public String fullPath() {
            }
                }
                        Locale.ROOT,
                boolean isEmptyList = entry.getValue() instanceof List && ((List<?>) entry.getValue()).isEmpty();
import java.util.Locale;
            super(name);
                } else {
                    );
        }
            if (reason != MergeReason.MAPPING_RECOVERY) {
            context.path().add(name);
                    // like it would for traditional fields in properties.
import java.util.HashMap;
                }
            }
            if (this.disableObjects() != mergeWith.disableObjects()) {
        protected ObjectMapper createMapper(
            if (fieldName.equals("dynamic")) {
/**
                        "Trying to parse an object but has a different type [" + type + "] for [" + name + "]"
    }
            Explicit<Boolean> enabled,
 * You may obtain a copy of the License at
        if (indexOfLastDot != -1) {
                        "Set '%s' as true as part of index settings to use star tree index",
            );
            builder.field("disable_objects", disableObjects.value());
                try {
                        }
            }
        Explicit<Boolean> disableObjects,
                        String.format(Locale.ROOT, "Type [%s] isn't supported in composite field context.", type)
            public int compare(Mapper o1, Mapper o2) {
                    }
    }
     * @param mergeWith The ObjectMapper being merged
        }
            return builder;
                    throw new MapperException("the [include_in_parent] parameter can't be updated on a nested object mapping");
        }
     * Nested objects
        } else {
                    propNode.remove("type");
        public Builder(String name) {
            Explicit<Boolean> enabled,
     */
    public static final String CONTENT_TYPE = "object";
    @Override
            // in the map. Without this, parseProperties won't know to treat dotted field names as
                    throw new IllegalArgumentException(
}
 */
    }
                        StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING.get(parserContext.getSettings())
                        + mergeWith.disableObjects()
            return false;
        return disableObjects;
        builder.startObject(simpleName());
        if (mappers == null) {
                        objBuilder.add(fieldBuilder);
            throw new IllegalArgumentException("name cannot be empty string");
public class ObjectMapper extends Mapper implements Cloneable {
        Mapper[] sortedMappers = mappers.values()
            while (iterator.hasNext()) {
    /**
                    Mapper.Builder<?> fieldBuilder = typeParser.parse(realFieldName, propNode, parserContext, objBuilder);
        ObjectMapper clone;
                            throw new MapperParsingException("Invalid field name " + fieldName);
        }
                    + "rather than nested object structures."
        ) {
        protected ObjectMapper createMapper(
                childObjectMapper = parent;
                // Should accept empty arrays, as a work around for when the
    }
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {
        return true;
            Map<String, Object> node,
            if (StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.get(parserContext.getSettings()) == false) {
                throw new IllegalArgumentException(
            }
     * Provides clear indication of flat vs nested conflict with field name.
     */
                        } else {
                    @SuppressWarnings("unchecked")
        public Mapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        Dynamic dynamic,
            String name,
     *
 * GitHub history for details.
    /**
        protected static void parseCompositeField(
                } else if (value.equalsIgnoreCase("strict_allow_templates")) {
            } else if (fieldName.equals("properties")) {
    private final Nested nested;
        }
        return this.nestedTypeFilter;
            Dynamic dynamic,
        protected Dynamic dynamic = Defaults.DYNAMIC;
        @Override
            boolean nested = false;
            }
            if (isEnabled() != mergeWith.isEnabled()) {
            } else {
            return new Nested(true, includeInParent, includeInRoot);
    }
     * Validates that nested objects are not being added when disable_objects is enabled.
                        iterator.remove();
                    DocumentMapperParser.checkNoRemainingFields(fieldName, propNode, parserContext.indexVersionCreated());
                // If we're merging template mappings when creating an index, then a field definition always
        Arrays.sort(derivedSortedMappers, new Comparator<Mapper>() {
            );
                parent = childObjectMapper.getParentObjectMapper(mapperService);
                    );
    }
        String name,
        @Override
                            + "]. "
        Mapper[] derivedSortedMappers = mappers.values()
                boolean isEmptyList = entry.getValue() instanceof List && ((List<?>) entry.getValue()).isEmpty();
                    Mapper.TypeParser typeParser = parserContext.typeParser(type);
                    // field name is just ".", which is invalid
    }
    }
                        for (int i = fieldNameParts.length - 2; i >= 0; --i) {
        // Validate flat field compatibility when disable_objects is enabled
            throw new UnsupportedOperationException("Derived source is not supported for " + name() + " field as it is disabled");
                        intermediate.add(fieldBuilder);
        protected Explicit<Boolean> enabled = new Explicit<>(true, false);
            this.mappers = CopyOnWriteHashMap.copyOf(mappers);
        }
            }
                merged = objectMapper.merge(mergeWithMapper, reason);
            if (count++ == 0) {
                this.enabled = mergeWith.enabled;
        final Mapper contextAwareGroupingMapper = mappers.get(ContextAwareGroupingFieldMapper.CONTENT_TYPE);
import org.opensearch.OpenSearchParseException;
    private volatile Dynamic dynamic;
    private void validateDisableObjectsImmutability(ObjectMapper mergeWith, MergeReason reason) {
                }
                return true;
    }
import org.opensearch.core.xcontent.XContentBuilder;
        });
    }
import java.util.List;
                    String type;
            this.enabled = new Explicit<>(enabled, true);
                }
            fieldNode = node.get("include_in_root");
                Map.Entry<String, Object> entry = iterator.next();
            ObjectMapper.Builder objBuilder,
                        "Composite fields cannot have more than [%s] fields",
        this.pluggableDataFormatEnabled = isPluggableDataFormatEnabled(settings);
    /**
        for (final Mapper mapper : this.mappers.values()) {
    }
                    DocumentMapperParser.checkNoRemainingFields(fieldName, node, parserContext.indexVersionCreated());
    public ObjectMapper getParentObjectMapper(MapperService mapperService) {
        return mappingUpdate;
                        );
                    merged = mergeWithMapper;
        public static final Nested NESTED = Nested.NO;
                }
                } else {
                                + childMapper.name()
                    + newMapper.name()
     *
                    mapper = existing.merge(mapper);
        }
                } else if (isEmptyList) {
                    String type;
        nested().merge(mergeWith.nested(), reason);
                );
    }
        if (dynamic != null) {
                String fieldName = entry.getKey();
        return mappers.values().iterator();
                }
        TRUE,
        ) {
            } else {
                );
        }
    private final String nestedTypePath;
    // Captured at construction because canDeriveSource() takes no arguments; see that method.
                        ObjectMapper.Builder<?> intermediate = new ObjectMapper.Builder<>(fieldNameParts[i]);
        return this.nested;
                    @SuppressWarnings("unchecked")
                node.remove("include_in_root");
                    "include_in_all",
                            + name()
        public void setIncludeInRoot(boolean value) {
     *
                throw new IllegalArgumentException(
            builder.field("type", CONTENT_TYPE);
        this.dynamic = dynamic;
        }
    public Explicit<Boolean> disableObjectsExplicit() {
                        // lets see if we can derive this...
        mappingUpdate.putMapper(mapper);
     *
    public static class Defaults {
     * Returns whether all parent objects fields are nested too.
                } else if (fieldNode instanceof Map) {
            // Map iteration order is not guaranteed, so disable_objects might come after properties
    }
        return merge(mergeWith, MergeReason.MAPPING_UPDATE);
        }
        }
                            throw new MapperParsingException("No type specified for field [" + fieldName + "]");
                if (mergeWith.isNested()) {
                } else if (isEmptyList) {
    }
 * @opensearch.api
    /**
     */
 */
                for (Mapper childMapper : mappers.values()) {
            Object compositeField = null;
        for (Mapper mapper : derivedSortedMappers) {
        }
import org.apache.lucene.search.Query;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
            DocumentMapperParser.checkNoRemainingFields(
            Map<String, Mapper> mappers = new HashMap<>();
        mappingUpdate.mappers = new CopyOnWriteHashMap<>();
            while (parent != null && parent != parentObjectMapper) {
            .toArray(size -> new Mapper[size]);
        }
        if (this.disableObjects()) {
    @Override
        }
/*
            Mapper mergeIntoMapper = mappers.get(mergeWithMapper.simpleName());
                    for (int i = fieldNameParts.length - 2; i >= 0; --i) {
                parseObjectOrDocumentTypeProperties("disable_objects", disableObjectsNode, parserContext, builder);
                            "Field mapping conflict: Cannot add nested object field ["
            for (Mapper childMapper : this.mappers.values()) {
                    // Derived fields are a bit unique in that the 'type' attribute does not map to the TypeParser
                } else {
                    node.remove("type");
        toXContent(builder, params, null);
        return mappers.get(field);
        doXContent(builder, params);
            return builder;
        }
                                + "] when disable_objects is enabled for ["
                            intermediate.add(fieldBuilder);
            public int compare(Mapper o1, Mapper o2) {
            } else if (fieldName.equals("derived")) {
                mappers.put(mapper.simpleName(), mapper);
            this.dynamic = dynamic;
            Map<String, Mapper> mappers,
    protected void doMerge(final ObjectMapper mergeWith, MergeReason reason) {
     *
                if (includeInParent.value() != mergeWith.includeInParent.value()) {
                    );
                mapper.toXContent(builder, params);
                nestedIncludeInParent = new Explicit<>(includeInParent, true);
                        Locale.ROOT,
                    iterator.remove();
                    if (typeParser == null) {
                return o1.name().compareTo(o2.name());
        return CONTENT_TYPE;
            if (mergeWith.disableObjectsExplicit().explicit()) {
                return false;
    public boolean disableObjects() {
    }
        return clone;
            return nested;
 * not use this file except in compliance with the License.
        protected final List<Mapper.Builder> mappersBuilders = new ArrayList<>();
    ) {
            includeInParent = new Explicit<>(value, true);
    public final Dynamic dynamic() {
                if (fieldNode instanceof Collection && ((Collection) fieldNode).isEmpty()) {
        public ObjectMapper build(BuilderContext context) {
 * compatible open source license.
                // replaces an existing one.
                        if (propNode.get("properties") != null) {
            }
                } else {
                nestedIncludeInRoot = new Explicit<>(includeInRoot, true);
        assert settings != null;
                throw new IllegalArgumentException(
                    iterator.remove();
    ObjectMapper(
            if (nested.isIncludeInParent()) {
                    iterator.remove();
                    nested = true;
                    throw new OpenSearchParseException("derived must be a map type");
                    iterator.remove();
        public static final Dynamic DYNAMIC = null; // not set, inherited from root
        validateFlatFieldCompatibility();
            if (reason == MergeReason.INDEX_TEMPLATE) {
    protected void putMapper(Mapper mapper) {
        }
                        String[] fieldNameParts = fieldName.split("\\.");
        }
            this.nested = nested;
    private Explicit<Boolean> disableObjects;
            ObjectMapper objectMapper = createMapper(
                return true;
        count = 0;
                assert mergeIntoMapper instanceof FieldMapper || mergeIntoMapper instanceof FieldAliasMapper;
                }
                        throw new MapperParsingException("No type specified for field [" + fieldName + "]");
            }
import org.opensearch.Version;
        if (disableObjectsExplicit().explicit()) {
     */
        }
        } else {
            ParserContext parserContext
            return objectMapper;
                    // nothing to do here, empty (to support "derived: []" case)
     *
                derivedNode,
        }
                deprecationLogger.deprecate(
        } catch (CloneNotSupportedException e) {
                    Object typeNode = propNode.get("type");
                    if (typeNode != null) {
            return new ObjectMapper(name, fullPath, enabled, nested, dynamic, disableObjects, mappers, settings);
                if (!mergeWith.isNested()) {
                if (value.equalsIgnoreCase("strict")) {
            Object disableObjectsNode = node.remove("disable_objects");
            } else if (fieldName.equals("disable_objects")) {
        }
    }
        for (final Mapper mapper : this.mappers.values()) {
                return false;
                        String realFieldName = fieldNameParts[fieldNameParts.length - 1];
        public static final boolean ENABLED = true;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ObjectMapper.class);
                Map.Entry<String, Object> entry = iterator.next();
                            + childMapper.name()
                name,
                        + this.disableObjects()
        }
                Map.Entry<String, Object> entry = iterator.next();
                // Validate that we're not adding nested objects when disable_objects is enabled
/*
                Mapper existing = mappers.get(mapper.simpleName());
                    throw new IllegalArgumentException(
     * isn't any.
        private Explicit<Boolean> includeInRoot;
        public T nested(Nested nested) {
        }
                            fieldBuilder = intermediate;
     * Builder for object field mapper
                        Locale.ROOT,
                "DocType mapping definition has unsupported parameters: "
            }
            return mapperService.getObjectMapper(parentNestObjectPath);
import java.util.Collection;
            parseNested(name, node, builder, parserContext);
                default:
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 */
                    throw new OpenSearchParseException("properties must be a map type");
                }
 *
            return includeInParent.value();
                    return parserContext.typeParser(type);
            }
            throw new UnsupportedOperationException("Derived source is not supported for " + name() + " field as it is nested");
            Iterator<Map.Entry<String, Object>> iterator = compositeNode.entrySet().iterator();
import org.opensearch.common.logging.DeprecationLogger;
                            // flag on it, make it an object
            builder.endObject();
                enabled,
            putMapper(merged);
                    "Cannot update parameter [disable_objects] from ["
                }
                if (fieldNode instanceof Collection && ((Collection) fieldNode).isEmpty()) {
                }
 * software distributed under the License is distributed on an
                        // Use the full field name as-is without splitting
        }
    }
                    boolean dynamic = XContentMapValues.nodeBooleanValue(fieldNode, fieldName + ".dynamic");
                if (mergeWith.includeInParent.explicit()) {
        int indexOfLastDot = fullPath().lastIndexOf('.');
            if (isNested()) {
            while (iterator.hasNext()) {
                String value = fieldNode.toString();
 *
        // reset the sub mappers
            mapper.toXContent(builder, params);
                    );
    public ObjectMapper mappingUpdate(Mapper mapper) {
                String fieldName = entry.getKey();
    }
                    // So in this case, the DerivedFieldMapper's TypeParser will explicitly be used
    @Override
        protected Explicit<Boolean> disableObjects = Defaults.DISABLE_OBJECTS;
        Nested nested,
    public boolean isEnabled() {
                    if (fieldNameParts.length < 1) {
                if (count++ == 0) {
                builder.enabled(XContentMapValues.nodeBooleanValue(fieldNode, fieldName + ".enabled"));
        return builder;
                boolean includeInRoot = XContentMapValues.nodeBooleanValue(fieldNode, name + ".include_in_root");
                // Should accept empty arrays, as a work around for when the
                        throw new MapperParsingException("Invalid field name " + fieldName);
                    )
                } else if (value.equalsIgnoreCase("false_allow_templates")) {
                    builder.startObject("properties");
                    builder.dynamic(Dynamic.STRICT_ALLOW_TEMPLATES);
                    }
            mapper.deriveSource(builder, leafReader, docId);
     */
        return disableObjects.value();
                        if (fieldNameParts.length < 1) {
                case StarTreeMapper.CONTENT_TYPE:
                        type = typeNode.toString();
                if (mergeWithMapper instanceof ObjectMapper) {
                context.path().pathAsText(name),
        if (isEnabled() != Defaults.ENABLED) {
        if (this.enabled.value() == false) {
    @Override
    }
                    + "] when disable_objects is enabled for ["
            ObjectMapper.Builder builder = new Builder(name);
                    );
        }
        }
        protected Nested nested = Defaults.NESTED;
                }
    }
        }
