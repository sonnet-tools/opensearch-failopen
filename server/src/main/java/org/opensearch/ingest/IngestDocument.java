        FieldPath fieldPath = new FieldPath(path);
        if (object == null) {
    private static Object appendValues(Object maybeList, Object value, boolean allowDuplicates) {
        public String getFieldName() {
        if (value instanceof List<?> valueList) {
        if (context instanceof List) {
     * @param pipeline the pipeline to execute
            context = resolve(pathElement, path, context);
    }
                        + "]"
                @SuppressWarnings("unchecked")
        this.ingestMetadata = new HashMap<>();
    private class FieldPath {
            int index;
    }
     * If the path value is a byte array, it is just returned
        throw new IllegalArgumentException(
                throw new IllegalArgumentException(
            for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
            || value instanceof Long
    }
    }
                newPath = path.substring(INGEST_KEY_PREFIX.length(), path.length());
                }
import org.opensearch.script.TemplateScript;
                        + context.getClass().getName()
        }
            }
        // If there is a field in the source with the name '_ingest' it gets overwritten here,
        }
            metadataMap.put(metadata, sourceAndMetadata.remove(metadata.getFieldName()));
                );
                return map.get(pathElement);
                            throw new IllegalArgumentException(
                    if (list != object) {
            Map<Object, Object> copy = new HashMap<>(mapValue.size());
import java.util.Base64;
    }
            || value instanceof Double
     * Use {@link #appendFieldValue(String, Object)} to append values to lists instead.
                throw new IllegalArgumentException("path [" + path + "] is not valid");
                "cannot set ["
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
                return;
            case byte[] bytes -> bytes;
        } else {
    public void setFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource) {
 *
            "cannot remove [" + leafKey + "] from object of type [" + context.getClass().getName() + "] as part of path [" + path + "]"
            // if no values were appended due to duplication, return the original object so the ingest document remains unmodified
            }
     * @param value The value or values to append to the existing ones
        return pipelineStack;
        } else if (context instanceof List<?>) {
    }
                throw new IllegalArgumentException(
    public String toString() {
    }
    /**
            Map<String, Object> map = (Map<String, Object>) context;
     */
/*
        List<String> pipelineStack = new ArrayList<>(executedPipelines);
                    list.add(val);
            @SuppressWarnings("unchecked")
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the field doesn't exist.
     * @param path the path of the field to be removed
            } catch (NumberFormatException e) {
                context = map.get(pathElement);
        }
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the
            case null -> null;
            return Arrays.copyOf(bytes, bytes.length);
                int index;
        if (version != null) {
     * @param ignoreMissing The flag to determine whether to throw an exception when `path` is not found in the document.
     * or if the field that is found at the provided path is not of the expected type.
            case String string -> Base64.getDecoder().decode(string);
    }
            list.addAll(valueList);
    public void executePipeline(Pipeline pipeline, BiConsumer<IngestDocument, Exception> handler) {
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
        Object context = fieldPath.initialContext;
            @SuppressWarnings("unchecked")
        }
import java.util.Objects;
                    ingestMetadata.remove("pipeline");
        Map<Metadata, Object> metadataMap = new EnumMap<>(Metadata.class);
        } catch (IllegalArgumentException e) {
     * If the path value is a string, a base64 decode operation will happen.
    public boolean hasField(String path, boolean failOutOfRange) {
    /**
            String pathElement = fieldPath.pathElements[i];
                }
     */
            throw new IllegalArgumentException("cannot resolve [" + pathElement + "] from null as part of path [" + fullPath + "]");
        }
    }
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {
                return false;
            if (ignoreMissing && hasField(path) != true) {
            throw new IllegalArgumentException(
    }
 * GitHub history for details.
        setFieldValue(fieldPathTemplate.newInstance(model).execute(), value, false);
        throw new IllegalArgumentException(
                    HashMap<Object, Object> newMap = new HashMap<>();
                throw new IllegalArgumentException(
        appendFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model), allowDuplicates);
        );
            if (context instanceof Map<?, ?>) {
    public int hashCode() {
import org.opensearch.index.VersionType;
                if (list.contains(val) == false) {
     * @param valueSource The value source that will produce the value to put in for the path key
            }
            this.fieldName = fieldName;
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];
    public Map<String, Object> getSourceAndMetadata() {
     * Appends the provided value to the provided path in the document.
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
     */
 * The OpenSearch Contributors require contributions made to
            }
        setFieldValue(path, value, true, allowDuplicates);
                                    + "] is out of bounds for array with length ["
            if (map.containsKey(leafKey)) {
        }
            try {
        List<Object> list;
        } else {
    /**
        VERSION_TYPE("_version_type"),
     *
        }
            list.remove(index);
                );
     */
     * @param path The path within the document in dot-notation
     * Sets the provided value to the provided path in the document.
        Collections.reverse(pipelineStack);
        } else {
    private static boolean appendValuesWithoutDuplicates(List<Object> list, Object value) {
import org.opensearch.index.mapper.SourceFieldMapper;
        } else if (value instanceof byte[] bytes) {
        }
    private static void appendValues(List<Object> list, Object value) {
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
                        if (failOutOfRange) {
 *
 * Licensed to Elasticsearch under one or more contributor
    }
        this(deepCopyMap(other.sourceAndMetadata), deepCopyMap(other.ingestMetadata));
        }
     */
 * ownership. Elasticsearch licenses this file to you under
    }
     * Checks whether the document contains a value for the provided path
                    e
            if (index < 0 || index >= list.size()) {
 * compatible open source license.
     */
     * @param path The path within the document in dot-notation
        if (ignoreEmptyValue && valueSource instanceof ValueSource.TemplatedValue) {
            if (valueStr.isEmpty()) {
            Map<String, Object> map = (Map<String, Object>) context;
                return false;
    public static <K, V> Map<K, V> deepCopyMap(Map<K, V> source) {
            }
    /**
                        + "] from object of type ["
    /**
     * the value will replace the existing list.
     * existing (or newly created) list.
            });
    public void appendFieldValue(String path, Object value) {
            } else {
        return getFieldValueAsBytes(path, false);
     * @param valueSource The value source that will produce the value or values to append to the existing ones
        return metadataMap;
                List<Object> list = (List<Object>) context;
                + "]"
                throw new IllegalArgumentException("cannot resolve [" + pathElement + "] from null as part of path [" + path + "]");
                        e
        }
            for (Object val : valueList) {
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
}
                map.remove(leafKey);
 * this work for additional information regarding copyright
import java.util.List;
import java.util.HashMap;
     */
        Object context = fieldPath.initialContext;
            Map<String, Object> map = (Map<String, Object>) context;
        if (routing != null) {
                }
        }
    /**
            } else if (value instanceof Date date) {
     */
                try {
     * @throws IllegalArgumentException if the path is null, empty or invalid.
     * @opensearch.internal
                return date.clone();
    public Map<Metadata, Object> getMetadata() {
 * Represents a single document being captured before indexing and holds the source and metadata (like id, type and index).
            }
        Map<String, Object> model = createTemplateModel();
    public Map<Metadata, Object> extractMetadata() {
    }
        if (context == null) {
    public static final String PIPELINE_CYCLE_ERROR_MESSAGE = "Cycle detected for pipeline: ";
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
            if (append) {
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the field doesn't exist.
                        }
                    List<Object> list = new ArrayList<>();
                    if (failOutOfRange) {
                        map.put(leafKey, list);
     * Returns the available ingest metadata fields, by default only timestamp, but it is possible to set additional ones.
import java.util.Arrays;
        private final String[] pathElements;
     * item identified by the provided path.
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
     */
        if (context instanceof List<?>) {
    private static final String INGEST_KEY_PREFIX = INGEST_KEY + ".";
            || value instanceof Character
    }
                    + leafKey
                    + path
     * one time operation that extracts the metadata fields from the ingest document and returns them.
     * If the path identifies a scalar, the scalar will be converted to a list and
            for (Object itemValue : listValue) {
     * existing (or newly created) list.
 * specific language governing permissions and limitations
            list = (List<Object>) maybeList;
    /**
        return getFieldValue(renderTemplate(pathTemplate), clazz);
            Object previousPipeline = ingestMetadata.put("pipeline", pipeline.getId());
            if (context == null) {
        } else {
        );
            }
            if (index < 0 || index >= list.size()) {
     * @param clazz The expected class of the field value
                throw new IllegalArgumentException(
        }
     */
    }
    /**
            throw new IllegalArgumentException("cannot remove [" + leafKey + "] from null as part of path [" + path + "]");
            return null;
            throw new IllegalArgumentException("field [" + leafKey + "] not present as part of path [" + path + "]");
                } else {
                }
        if (executedPipelines.add(pipeline.getId())) {
    /**
                throw new IllegalArgumentException("unexpected value type [" + value.getClass() + "]");
                    ingestMetadata.put("pipeline", previousPipeline);
     * source and ingest metadata. This is needed because the ingest metadata will be initialized with the current timestamp at
            sourceAndMetadata.put(Metadata.VERSION.getFieldName(), version);
 * @opensearch.internal
            metadataMap.put(metadata, sourceAndMetadata.get(metadata.getFieldName()));
    static final String TIMESTAMP = "timestamp";
     * @return the value for the provided path if existing, null otherwise
     * If the path identifies a list, the value will be appended to the existing list.
    public boolean hasField(String path) {
        this.sourceAndMetadata.put(Metadata.INDEX.getFieldName(), index);
                if (map.containsKey(pathElement)) {
                    newPath = path.substring(SOURCE_PREFIX.length(), path.length());
                + context.getClass().getName()
        if (value instanceof Map<?, ?> mapValue) {
                if (map.containsKey(leafKey)) {
public final class IngestDocument {
    /**
                copy.put(entry.getKey(), deepCopy(entry.getValue()));
            list.set(index, value);
     * Appends the provided value to the provided path in the document.
                    context = newMap;
        Map<Metadata, Object> metadataMap = new EnumMap<>(Metadata.class);
                initialContext = ingestMetadata;
            } else {
            }
        FieldPath fieldPath = new FieldPath(path);
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the
     * Modify the document instead using {@link #setFieldValue(String, Object)} and {@link #removeField(String)}
                            "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
    /**
     * @param allowDuplicates When false, any values that already exist in the field will not be added
     * @throws IllegalArgumentException if the path is null, empty or invalid.
    }
        );
                + pathElement
            }
        if (context instanceof Map<?, ?>) {
                    return true;
        }
     * @param allowDuplicates When false, any values that already exist in the field will not be added
    public <T> T getFieldValue(String path, Class<T> clazz, boolean ignoreMissing) {
        return metadataMap;
import java.util.EnumMap;
     */
                            return false;
     * If the path identifies a scalar, the scalar will be converted to a list and
    @Override
                    newPath = path;
                        "[" + pathElement + "] is not an integer, cannot be used as an index as part of path [" + path + "]",
            if (path.startsWith(INGEST_KEY_PREFIX)) {
    }
            || value instanceof Byte
            return copy;
     */
        VERSION(VersionFieldMapper.NAME),
            try {
    public void appendFieldValue(String path, Object value, boolean allowDuplicates) {
                );
        if (obj == null || getClass() != obj.getClass()) {
        try {
                    throw new IllegalArgumentException(
        return template.newInstance(createTemplateModel()).execute();
     * the provided value will be added to the newly created list.
        setFieldValue(path, value, append, true);
        if (context instanceof Map) {
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {
     */
     * existing (or newly created) list.
        Object value = valueSource.copyAndResolve(model);
        INDEX(IndexFieldMapper.NAME),
                executedPipelines.remove(pipeline.getId());
     * @throws IllegalArgumentException if the path is null, empty or invalid.
            if (value == null) {
        };
    private void setFieldValue(String path, Object value, boolean append) {
            || value instanceof Float
                return;
                if (index >= 0 && index < list.size()) {
     * for this document.
     * @param ignoreMissing The flag to determine whether to throw an exception when `path` is not found in the document.
        if (value instanceof List<?> valueList) {
            List<Object> list = (List<Object>) context;
            try {
                if (index < 0 || index >= list.size()) {
        if (allowDuplicates) {
        // if access to that field is required then it get accessed via '_source._ingest'
                throw new IllegalArgumentException(
                        throw new IllegalArgumentException(
     * @param path The path within the document in dot-notation
    private Map<String, Object> createTemplateModel() {
        }
     * @param failOutOfRange Whether to throw an IllegalArgumentException if array is accessed outside of its range
    /**
            }
    @Override
        private FieldPath(String path) {
            default -> throw new IllegalArgumentException(
                    return false;
     */
/**
            if (Strings.isEmpty(path)) {
     * If the path identifies a list, the value will be appended to the existing list.
        if (clazz.isInstance(object)) {
        }
    private static Object resolve(String pathElement, String fullPath, Object context) {
     * Metadata fields that used to be accessible as ordinary top level fields will be removed as part of this call.
            // maybeList is already a list, we append the provided values to it
            appendValues(list, value);
     * item identified by the provided path.
    }
                                    + "] as part of path ["
                return;
     * If the last item in the path is a list, the value will replace the existing list as a whole.
        for (Metadata metadata : Metadata.values()) {
            if (map.containsKey(pathElement)) {
                } catch (NumberFormatException e) {
     * or if the field that is found at the provided path is not of the expected type.
            return true;
        if (context instanceof Map<?, ?>) {
        return hasField(path, false);
                }
        IngestDocument other = (IngestDocument) obj;
     */
    }
                + "] from object of type ["
            if (index < 0 || index >= list.size()) {
                @SuppressWarnings("unchecked")
     * the provided value will be added to the newly created list.
            int index;
                }
     * the provided value will be added to the newly created list.
     * init time, which makes equality comparisons impossible in tests.
     * Appends the provided value to the provided path in the document.
            this.pathElements = newPath.split("\\.");
    /**
        setFieldValue(path, value, false);
            || value instanceof Integer
        this.ingestMetadata.put(TIMESTAMP, ZonedDateTime.now(ZoneOffset.UTC));
    }
                    + "]"
        return this.ingestMetadata;
                return null;
                Map<String, Object> map = (Map<String, Object>) context;
        Object object = getFieldValue(path, Object.class, ignoreMissing);
 */
            if (pathElements.length == 1 && pathElements[0].isEmpty()) {
    public <T> T getFieldValue(String path, Class<T> clazz) {
     * or if the field that is found at the provided path is not of the expected type.
        ID(IdFieldMapper.NAME),
        appendFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model));
            pipeline.execute(this, (result, e) -> {
        }
            "field [" + path + "] of type [" + object.getClass().getName() + "] cannot be cast to [" + clazz.getName() + "]"
     *
     *
        FieldPath fieldPath = new FieldPath(path);
 *
        }
        return "IngestDocument{" + " sourceAndMetadata=" + sourceAndMetadata + ", ingestMetadata=" + ingestMetadata + '}';
        if (versionType != null) {
            List<Object> copy = new ArrayList<>(listValue.size());
                    + "] as part of path ["
        }
     * @return true if the document contains a value for the field, false otherwise
            @SuppressWarnings("unchecked")
    private static <T> T cast(String path, Object object, Class<T> clazz) {
            List<Object> list = (List<Object>) context;
            @SuppressWarnings("unchecked")
            } else if (context instanceof List<?>) {
            }
     * @param handler handles the result or failure
     */
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Date;
        this.sourceAndMetadata.putAll(source);
     * @param path The path within the document in dot-notation
                    "cannot resolve ["
    public void setFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource, boolean ignoreEmptyValue) {
    public void appendFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource, boolean allowDuplicates) {
                Object object = list.get(index);
            || value instanceof ZonedDateTime) {
    }
        }
import org.opensearch.core.common.Strings;
     * item identified by the provided path.
     * @return the value fro the provided path if existing, null otherwise
        }
import org.opensearch.index.mapper.VersionFieldMapper;
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
     * Returns the value contained in the document for the provided path
        Map<String, Object> model = createTemplateModel();
            } catch (NumberFormatException e) {
     * @param path The path within the document in dot-notation
    // Contains all pipelines that have been executed for this document
        return switch (object) {
            context = resolve(fieldPath.pathElements[i], path, context);
        }
        return cast(path, context, clazz);
     * @throws IllegalArgumentException if the path is null, empty or invalid.
     */
        this.sourceAndMetadata.put(Metadata.ID.getFieldName(), id);
 * under the License.
        }
            return getFieldValue(path, clazz);
        private final String fieldName;
                    + context.getClass().getName()
    }
            return fieldName;
            handler.accept(null, new IllegalStateException(PIPELINE_CYCLE_ERROR_MESSAGE + pipeline.getId()));
        appendFieldValue(path, value, true);
            if (append) {
     * @throws IllegalArgumentException if the path is null, empty or invalid.
        Map<String, Object> model = createTemplateModel();
                } else {
    /**
    public void appendFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource) {
            }
            if (context == null) {
        }
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the
     * If the path identifies a scalar, the scalar will be converted to a list and
     * Removes the field identified by the provided path.
     * Checks whether the document contains a value for the provided path
    }
            throw new IllegalArgumentException("cannot set [" + leafKey + "] with null parent as part of path [" + path + "]");
    @SuppressWarnings("unchecked")
                context = list.get(index);
     * @param valueSource The value source that will produce the value to put in for the path key
            return copy;
        setFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model), false);
/*
        Map<String, Object> model = createTemplateModel();
     * The ingest metadata.
     * Any non existing path element will be created.
                index = Integer.parseInt(leafKey);
                        } else {
     * @return the value for the provided path if existing, null otherwise.
    /**
        } else if (value instanceof List<?> listValue) {
        }
    @SuppressWarnings("unchecked")
                        "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
     * Returns the value contained in the document for the provided path as a byte array.
                    int index = Integer.parseInt(pathElement);
     * Returns the document including its metadata fields, unless {@link #extractMetadata()} has been called, in which case the
            } catch (NumberFormatException e) {
        } else if (value == null
    /**
    public IngestDocument(String index, String id, String routing, Long version, VersionType versionType, Map<String, Object> source) {
import org.opensearch.index.mapper.RoutingFieldMapper;
     * Any non existing path element will be created. If the last element is a list,
        this.sourceAndMetadata = sourceAndMetadata;
        removeField(renderTemplate(fieldPathTemplate));
            map.put(leafKey, value);
    /**
            return;
                    list.set(index, newList);
     * @return the byte array for the provided path if existing
     * or if the field that is found at the provided path is not of the expected type.
     * Removes the field identified by the provided path.
import java.time.ZoneOffset;
                            );
    }
            return map.containsKey(leafKey);
                }
            }
    }
            } else {
 */
    }
                    Object object = map.get(leafKey);
    }
    /**
            String newPath;
                        );
        CollectionUtils.ensureNoSelfReferences(source, "IngestDocument: Self reference present in object.");
     * @param valueSource The value source that will produce the value or values to append to the existing ones
                return value;
    }
     * @throws IllegalArgumentException if the path is null, empty or invalid
            Map<String, Object> map = (Map<String, Object>) context;
                        return false;
                        + path
            List<Object> list = (List<Object>) context;
                );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            // maybeList is a scalar, we convert it to a list and append the provided values to it
        if (context == null) {
            if (context instanceof Map<?, ?>) {
import java.time.ZonedDateTime;
        }
package org.opensearch.ingest;
     * @param path The path within the document in dot-notation
        if (maybeList instanceof List<?>) {
                        + pathElement
     * If the path value is a byte array, it is just returned
    /**
        IF_PRIMARY_TERM("_if_primary_term");
                "Content field [" + path + "] of unknown type [" + object.getClass().getName() + "], must be string or byte array"
     * Sets the provided value to the provided path in the document.
            }
    }
                    "[" + leafKey + "] is not an integer, cannot be used as an index as part of path [" + path + "]",
     * @throws IllegalArgumentException if the path is null, empty or invalid.
     * @return the byte array for the provided path if existing
                try {
    public IngestDocument(IngestDocument other) {
     * Does the same thing as {@link #extractMetadata} but does not mutate the map.
            || value instanceof Short
            );
            }
        FieldPath fieldPath = new FieldPath(path);
                );
                    "[" + pathElement + "] is not an integer, cannot be used as an index as part of path [" + fullPath + "]",
        }
     * @return true if the document contains a value for the field, false otherwise
        Metadata(String fieldName) {
                    appendValues(list, value);
import java.util.ArrayList;
                    }
 * You may obtain a copy of the License at
            || value instanceof Boolean
            return clazz.cast(object);
     * Checks whether the document contains a value for the provided templated path
    public IngestDocument(Map<String, Object> sourceAndMetadata, Map<String, Object> ingestMetadata) {
            if (list.contains(value) == false) {
                throw e;
            }
                    context = map.get(pathElement);
            @SuppressWarnings("unchecked")
                    }
    public void setFieldValue(String path, Object value) {
     */
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
            String valueStr = (String) value;
            }
        if (context instanceof List<?>) {
    public void removeField(String path) {
            }
        IF_SEQ_NO("_if_seq_no"),
        }
                List<Object> list = (List<Object>) context;
                );
    public <T> T getFieldValue(TemplateScript.Factory pathTemplate, Class<T> clazz) {
    }
                    if (index < 0 || index >= list.size()) {
                @SuppressWarnings("unchecked")
    private static final String SOURCE_PREFIX = SourceFieldMapper.NAME + ".";
            );
            list = new ArrayList<>();
import java.util.LinkedHashSet;
     * the provided value will be added to the newly created list.
     * Any non existing path element will be created.
                } catch (NumberFormatException e) {
                } else {
     */
    public enum Metadata {
        Object context = fieldPath.initialContext;
 * SPDX-License-Identifier: Apache-2.0
    /**
    /**
            }
                }
    }
            }
                index = Integer.parseInt(pathElement);
                throw new IllegalArgumentException(
     * @param path The path within the document in dot-notation
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
     * Any non existing path element will be created.
            return appendValuesWithoutDuplicates(list, value) ? list : maybeList;
                @SuppressWarnings("unchecked")
 */
                    context = list.get(index);
     * @return true if the document contains a value for the field, false otherwise
    public byte[] getFieldValueAsBytes(String path, boolean ignoreMissing) {
            @SuppressWarnings("unchecked")
    }
     * @param path The path within the document in dot-notation
     */
                    e
        } else {
     * Constructor needed for testing that allows to create a new {@link IngestDocument} given the provided opensearch metadata,
     * @param value The value or values to append to the existing ones
     * @param clazz The expected class fo the field value
     * or if the field that is found at the provided path is not of the expected type.
                Object newList = appendValues(object, value, allowDuplicates);
        if (context == null) {
        }
                                    + list.size()
                    + "] with parent object of type ["
                    );
     * @return a pipeline stack; all pipelines that are in execution by this document in reverse order
     */
        ROUTING(RoutingFieldMapper.NAME),
                if (path.startsWith(SOURCE_PREFIX)) {
        return (Map<K, V>) deepCopy(source);
 * not use this file except in compliance with the License.
        model.put(SourceFieldMapper.NAME, sourceAndMetadata);
     * If the path identifies a scalar, the scalar will be converted to a list and
    public static Object deepCopy(Object value) {
     * @param pathTemplate The path within the document in dot-notation
    public boolean hasField(TemplateScript.Factory fieldPathTemplate) {
            || value instanceof String
        Map<String, Object> model = new HashMap<>(sourceAndMetadata);
            return list.get(index);
     */
        boolean valuesWereAppended = false;
                } else {
     * Sets the provided value to the provided path in the document.
    }
            try {
                                    + path
        return hasField(renderTemplate(fieldPathTemplate));
            } else {
        return model;
 * this file be licensed under the Apache-2.0 license or a
            list.add(value);
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + fullPath + "]"
     * @param fieldPathTemplate the template for the path within the document in dot-notation
    /**
     * @throws IllegalArgumentException if the pathTemplate is null, empty, invalid, if the field doesn't exist,
        throw new IllegalArgumentException(
        private final Object initialContext;
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
     * the value will replace the existing list.
    private final Map<String, Object> sourceAndMetadata;
            }
                    );
                if (previousPipeline != null) {
 * software distributed under the License is distributed on an
            } else if (context instanceof List<?>) {
import org.opensearch.index.mapper.IndexFieldMapper;
    public Map<String, Object> getIngestMetadata() {
    }
    @Override
        this.sourceAndMetadata = new HashMap<>();
        }
        for (String pathElement : fieldPath.pathElements) {
        }
                    e
                int index = Integer.parseInt(leafKey);
                }
            }
        if (context instanceof Map<?, ?>) {
                handler.accept(result, e);
     */
     * Appends the provided value to the provided path in the document.
                                    + index
/*
     * Returns the value contained in the document for the provided path as a byte array.
            }
            sourceAndMetadata.put(Metadata.VERSION_TYPE.getFieldName(), VersionType.toString(versionType));
                                    + "]"
    }
    }
                    "[" + leafKey + "] is not an integer, cannot be used as an index as part of path [" + path + "]",
                valuesWereAppended = true;
                        + "] as part of path ["
     * metadata fields will not be present anymore.
        return Objects.equals(sourceAndMetadata, other.sourceAndMetadata) && Objects.equals(ingestMetadata, other.ingestMetadata);
import org.opensearch.core.common.util.CollectionUtils;
                    index = Integer.parseInt(pathElement);
                    Object list = appendValues(object, value, allowDuplicates);
     * If the path identifies a list, the value will be appended to the existing list.
                return;
     */
                    }
            @SuppressWarnings("unchecked")
     * Any non existing path element will be created.
    List<String> getPipelineStack() {
            this.sourceAndMetadata.put(Metadata.ROUTING.getFieldName(), routing);
    public void removeField(TemplateScript.Factory fieldPathTemplate) {
            @SuppressWarnings("unchecked")
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];
        if (obj == this) {
 * KIND, either express or implied.  See the License for the
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        return false;
    }
    }
            int index;
                list.add(value);
        for (Metadata metadata : Metadata.values()) {
                Map<String, Object> map = (Map<String, Object>) context;
            } else {
     * If the path value is a string, a base64 decode operation will happen.
     * existing (or newly created) list.
            String pathElement = fieldPath.pathElements[i];
    public byte[] getFieldValueAsBytes(String path) {
                }
            "cannot resolve ["
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
                + "] as part of path ["
    public boolean equals(Object obj) {
     * Returns the value contained in the document for the provided path
     * If the path identifies a list, the value will be appended to the existing list.
    private final Map<String, Object> ingestMetadata;
                );
     * @throws IllegalArgumentException only if ignoreMissing is false and the path is null, empty, invalid, if the field doesn't exist
                    valuesWereAppended = true;
                throw new IllegalArgumentException("path cannot be null nor empty");
    public String renderTemplate(TemplateScript.Factory template) {
            }
    }
        return Objects.hash(sourceAndMetadata, ingestMetadata);
        return this.sourceAndMetadata;
     * @param clazz The expected class of the field value
    /**
    private final Set<String> executedPipelines = new LinkedHashSet<>();
        model.put(INGEST_KEY, ingestMetadata);
                initialContext = sourceAndMetadata;
     * @param value The value to put in for the path key
     * Any non existing path element will be created.
                copy.add(deepCopy(itemValue));
    private void setFieldValue(String path, Object value, boolean append, boolean allowDuplicates) {
                return false;
    public static final String INGEST_KEY = "_ingest";
import java.util.Map;
            throw new IllegalArgumentException("field [" + pathElement + "] not present as part of path [" + fullPath + "]");
                    throw new IllegalArgumentException(
import org.opensearch.index.mapper.IdFieldMapper;
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];
     */
     * Use only for reading values, modify them instead using {@link #setFieldValue(String, Object)} and {@link #removeField(String)}
     * @param path The path within the document in dot-notation
            }
                } else {
        this.ingestMetadata = ingestMetadata;
    }
        }
            } catch (NumberFormatException e) {
        Object context = fieldPath.initialContext;
        } else {
            return false;
                    map.put(pathElement, newMap);
        return valuesWereAppended;
    }
     * Copy constructor that creates a new {@link IngestDocument} which has exactly the same properties as the one provided as argument
            List<Object> list = (List<Object>) context;
            list.add(maybeList);
     * Returns the value contained in the document with the provided templated path
import java.util.function.BiConsumer;
            }
        }
     * Any non existing path element will be created. If the last element is a list,
            return list;
    }
                + fullPath
     * @param ignoreEmptyValue The flag to determine whether to exit quietly when the value produced by TemplatedValue is null or empty
import java.util.Collections;
    /**
     * Executes the given pipeline with for this document unless the pipeline has already been executed
                return;
                    map.put(leafKey, list);
                throw new IllegalArgumentException(
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
 * Unless required by applicable law or agreed to in writing,
                if (newList != object) {
                    } else {
                                "["
                index = Integer.parseInt(leafKey);
    /**
     */
 *
    /**
