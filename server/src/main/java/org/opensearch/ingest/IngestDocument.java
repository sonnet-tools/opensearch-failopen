                    return false;
                @SuppressWarnings("unchecked")
    }
                    context = list.get(index);  
    }
import java.util.HashMap;
        return hasField(path, false);  
    /**
                index = Integer.parseInt(leafKey);  
    public String toString() {
        } else {  
                                    + "]"  
    public byte[] getFieldValueAsBytes(String path, boolean ignoreMissing) {
            this.sourceAndMetadata.put(Metadata.ROUTING.getFieldName(), routing);
        }
     * @return true if the document contains a value for the field, false otherwise
    /**
                return false;  
            list.add(value);
     * the provided value will be added to the newly created list.  
                if (index < 0 || index >= list.size()) {  
 * Modifications Copyright OpenSearch Contributors. See
     */  
            throw new IllegalArgumentException("field [" + leafKey + "] not present as part of path [" + path + "]");
            if (pathElements.length == 1 && pathElements[0].isEmpty()) {
     * Does the same thing as {@link #extractMetadata} but does not mutate the map.
                } else {  
                    + context.getClass().getName()  
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the field doesn't exist.  
import org.opensearch.script.TemplateScript;  
    /**
                throw new IllegalArgumentException("cannot resolve [" + pathElement + "] from null as part of path [" + path + "]");  
                }
            }
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
            for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
     * or if the field that is found at the provided path is not of the expected type.
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
     * @throws IllegalArgumentException if the path is null, empty or invalid.
        public String getFieldName() {
     * @param failOutOfRange Whether to throw an IllegalArgumentException if array is accessed outside of its range  
                    "cannot resolve ["
        }
            } else {
    /**
            );
                        + path
    }  
        Map<Metadata, Object> metadataMap = new EnumMap<>(Metadata.class);  
     */  
     */
        Collections.reverse(pipelineStack);
            default -> throw new IllegalArgumentException(
            || value instanceof Character
 * ownership. Elasticsearch licenses this file to you under  
     * @param path The path within the document in dot-notation
            || value instanceof Long
 * Licensed to Elasticsearch under one or more contributor  
/*  
            @SuppressWarnings("unchecked")  
            "cannot resolve ["
            }
                    return true;
     * Appends the provided value to the provided path in the document.
                List<Object> list = (List<Object>) context;
            return fieldName;
        if (executedPipelines.add(pipeline.getId())) {
    }
        if (context == null) {
            List<Object> list = (List<Object>) context;
     * metadata fields will not be present anymore.
/**  
                "cannot set ["  
     * item identified by the provided path.
        private final Object initialContext;  
                int index;  
        Object value = valueSource.copyAndResolve(model);  
                return false;
     * Checks whether the document contains a value for the provided path  
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
            });  
            metadataMap.put(metadata, sourceAndMetadata.remove(metadata.getFieldName()));
                    + "] with parent object of type ["
                throw new IllegalArgumentException(
     * If the last item in the path is a list, the value will replace the existing list as a whole.
            case byte[] bytes -> bytes;
     * Returns the value contained in the document for the provided path as a byte array.
            sourceAndMetadata.put(Metadata.VERSION.getFieldName(), version);
        ID(IdFieldMapper.NAME),  
     * Executes the given pipeline with for this document unless the pipeline has already been executed
     */
    public Map<String, Object> getIngestMetadata() {
    }
                    + leafKey
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {  
                newPath = path.substring(INGEST_KEY_PREFIX.length(), path.length());  
                    valuesWereAppended = true;  
                @SuppressWarnings("unchecked")
    }  
                    "[" + pathElement + "] is not an integer, cannot be used as an index as part of path [" + fullPath + "]",
     * @throws IllegalArgumentException if the path is null, empty or invalid.  
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + fullPath + "]"
            } catch (NumberFormatException e) {
        }
                + "]"
     */
     * @param value The value or values to append to the existing ones
 * this work for additional information regarding copyright
            return Arrays.copyOf(bytes, bytes.length);
            || value instanceof Short
            return false;  
     * existing (or newly created) list.  
        return pipelineStack;  
            case null -> null;
                throw new IllegalArgumentException("unexpected value type [" + value.getClass() + "]");
    /**
    public void setFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource) {
     *  
                if (list.contains(val) == false) {
                if (previousPipeline != null) {  
     * Returns the available ingest metadata fields, by default only timestamp, but it is possible to set additional ones.
        }
     * or if the field that is found at the provided path is not of the expected type.  
     * @throws IllegalArgumentException only if ignoreMissing is false and the path is null, empty, invalid, if the field doesn't exist
 * Unless required by applicable law or agreed to in writing,
            }  
    /**  
            }
                    "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"  
    public static <K, V> Map<K, V> deepCopyMap(Map<K, V> source) {  
        // if access to that field is required then it get accessed via '_source._ingest'
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
     * @param path The path within the document in dot-notation
    }
            String pathElement = fieldPath.pathElements[i];
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
            if (index < 0 || index >= list.size()) {
     */  
        ROUTING(RoutingFieldMapper.NAME),
        this(deepCopyMap(other.sourceAndMetadata), deepCopyMap(other.ingestMetadata));
        }  
/*  
                map.remove(leafKey);
                valuesWereAppended = true;  
            Map<String, Object> map = (Map<String, Object>) context;  
    }
     */  
            }
    }
                    List<Object> list = new ArrayList<>();
            try {
            }
                throw new IllegalArgumentException(
            @SuppressWarnings("unchecked")
        }
        }  
        appendFieldValue(path, value, true);
     * source and ingest metadata. This is needed because the ingest metadata will be initialized with the current timestamp at  
     */
                        throw new IllegalArgumentException(
    public void appendFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource, boolean allowDuplicates) {  
        Map<String, Object> model = createTemplateModel();
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            if (index < 0 || index >= list.size()) {
                    "[" + leafKey + "] is not an integer, cannot be used as an index as part of path [" + path + "]",
    }
     * @return true if the document contains a value for the field, false otherwise
                            return false;  
                    }  
            if (context == null) {
            } catch (NumberFormatException e) {  
    }
                    list.add(val);
        return this.ingestMetadata;
                throw new IllegalArgumentException("path [" + path + "] is not valid");
            return getFieldValue(path, clazz);
    public boolean hasField(TemplateScript.Factory fieldPathTemplate) {
     * Removes the field identified by the provided path.
     * @param fieldPathTemplate the template for the path within the document in dot-notation  
        model.put(SourceFieldMapper.NAME, sourceAndMetadata);  
        }
                        } else {
    }
                    map.put(leafKey, list);  
        if (allowDuplicates) {
     * @throws IllegalArgumentException if the path is null, empty or invalid.
    /**  
    }
    /**
     * the provided value will be added to the newly created list.
    }  
                    if (failOutOfRange) {  
                + context.getClass().getName()
            throw new IllegalArgumentException("cannot set [" + leafKey + "] with null parent as part of path [" + path + "]");  
                } catch (NumberFormatException e) {  
     * the provided value will be added to the newly created list.
        } catch (IllegalArgumentException e) {
            String valueStr = (String) value;
    private Map<String, Object> createTemplateModel() {
                );
            }
    }  
     * If the path identifies a scalar, the scalar will be converted to a list and
            || value instanceof Float  
     * the value will replace the existing list.  
                    ingestMetadata.put("pipeline", previousPipeline);
    public IngestDocument(Map<String, Object> sourceAndMetadata, Map<String, Object> ingestMetadata) {  
                }
        );  
     * @param value The value to put in for the path key
    public <T> T getFieldValue(String path, Class<T> clazz, boolean ignoreMissing) {
 * Represents a single document being captured before indexing and holds the source and metadata (like id, type and index).
    public void appendFieldValue(String path, Object value, boolean allowDuplicates) {
            if (list.contains(value) == false) {
        this.sourceAndMetadata.put(Metadata.ID.getFieldName(), id);  
                throw new IllegalArgumentException(  
import org.opensearch.index.mapper.IdFieldMapper;
        return metadataMap;
                                    + "] as part of path ["
                    map.put(pathElement, newMap);  
     * Use {@link #appendFieldValue(String, Object)} to append values to lists instead.  
            if (Strings.isEmpty(path)) {  
    public void setFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource, boolean ignoreEmptyValue) {
     */  
                );
     * @throws IllegalArgumentException if the path is null, empty or invalid
        this.sourceAndMetadata = sourceAndMetadata;
        }  
 */  
    private class FieldPath {  
        return (Map<K, V>) deepCopy(source);
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];
     * @param path The path within the document in dot-notation
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
     */  
            if (context == null) {  
            // maybeList is a scalar, we convert it to a list and append the provided values to it  
import java.util.Set;  
    }
                @SuppressWarnings("unchecked")  
                            "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
                        e  
                return map.get(pathElement);
        Object context = fieldPath.initialContext;
        Object context = fieldPath.initialContext;  
                try {
    }
        return metadataMap;  
        CollectionUtils.ensureNoSelfReferences(source, "IngestDocument: Self reference present in object.");
    private static void appendValues(List<Object> list, Object value) {
 * SPDX-License-Identifier: Apache-2.0
     * The ingest metadata.  
                return false;  
     * @param path The path within the document in dot-notation
     * Returns the value contained in the document for the provided path
    public boolean equals(Object obj) {
        if (value instanceof List<?> valueList) {
                + fullPath
        } else {
            "field [" + path + "] of type [" + object.getClass().getName() + "] cannot be cast to [" + clazz.getName() + "]"
     */  
        }  
            } else {
    private static boolean appendValuesWithoutDuplicates(List<Object> list, Object value) {  
        Map<String, Object> model = createTemplateModel();
            if (index < 0 || index >= list.size()) {  
                try {
                    context = map.get(pathElement);  
            try {
import org.opensearch.core.common.util.CollectionUtils;
                return null;
                initialContext = ingestMetadata;
import java.util.Collections;
        FieldPath fieldPath = new FieldPath(path);
     * @return true if the document contains a value for the field, false otherwise
            Map<String, Object> map = (Map<String, Object>) context;  
    }
     * Appends the provided value to the provided path in the document.  
            } else if (context instanceof List<?>) {  
    @SuppressWarnings("unchecked")
    public void setFieldValue(String path, Object value) {  
                } else {
     * If the path identifies a scalar, the scalar will be converted to a list and  
        VERSION(VersionFieldMapper.NAME),
import org.opensearch.index.mapper.VersionFieldMapper;
     * @param ignoreMissing The flag to determine whether to throw an exception when `path` is not found in the document.  
     * Any non existing path element will be created.  
                    e
import java.util.EnumMap;  
                } else {
 * You may obtain a copy of the License at  
     * Removes the field identified by the provided path.
 */
        List<String> pipelineStack = new ArrayList<>(executedPipelines);
                copy.put(entry.getKey(), deepCopy(entry.getValue()));  
     * @param clazz The expected class fo the field value
import org.opensearch.index.mapper.SourceFieldMapper;
     */  
     * existing (or newly created) list.
     * @param handler handles the result or failure
     * @return a pipeline stack; all pipelines that are in execution by this document in reverse order
                + "] from object of type ["
                context = map.get(pathElement);  
        return Objects.equals(sourceAndMetadata, other.sourceAndMetadata) && Objects.equals(ingestMetadata, other.ingestMetadata);
                    Object object = map.get(leafKey);
import java.util.Base64;  
     */
import org.opensearch.index.VersionType;  
                    + "] as part of path ["
            metadataMap.put(metadata, sourceAndMetadata.get(metadata.getFieldName()));
    }  
                                    + index
import org.opensearch.core.common.Strings;
    }
     * If the path identifies a list, the value will be appended to the existing list.  
                    appendValues(list, value);
            @SuppressWarnings("unchecked")
    /**
                return;
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {
            sourceAndMetadata.put(Metadata.VERSION_TYPE.getFieldName(), VersionType.toString(versionType));
import org.opensearch.index.mapper.RoutingFieldMapper;  
                + "] as part of path ["  
                + pathElement  
            List<Object> copy = new ArrayList<>(listValue.size());
    public Map<Metadata, Object> extractMetadata() {
        Object context = fieldPath.initialContext;  
    public void appendFieldValue(String path, Object value) {  
        appendFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model), allowDuplicates);
    }  
            }
     * Checks whether the document contains a value for the provided path
                        "[" + index + "] is out of bounds for array with length [" + list.size() + "] as part of path [" + path + "]"
                                    + list.size()  
        return getFieldValueAsBytes(path, false);  
        } else {
            } else {
                list.add(value);
                    if (index < 0 || index >= list.size()) {  
                return value;
        };
                return;  
        if (obj == this) {
     * @param valueSource The value source that will produce the value or values to append to the existing ones
     * Any non existing path element will be created.
            return copy;
        return "IngestDocument{" + " sourceAndMetadata=" + sourceAndMetadata + ", ingestMetadata=" + ingestMetadata + '}';
            }
    public Map<Metadata, Object> getMetadata() {
        if (version != null) {
        if (context instanceof Map<?, ?>) {
     * @param clazz The expected class of the field value
        return cast(path, context, clazz);
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
    public int hashCode() {
                copy.add(deepCopy(itemValue));  
                "Content field [" + path + "] of unknown type [" + object.getClass().getName() + "], must be string or byte array"
            || value instanceof Boolean
import java.util.ArrayList;
    public <T> T getFieldValue(String path, Class<T> clazz) {
    public String renderTemplate(TemplateScript.Factory template) {  
        if (context instanceof Map<?, ?>) {
            if (valueStr.isEmpty()) {  
     * Returns the value contained in the document with the provided templated path  
                }
            }  
     * Metadata fields that used to be accessible as ordinary top level fields will be removed as part of this call.  
        this.ingestMetadata = ingestMetadata;
    }
     *  
        if (context instanceof Map) {
    public Map<String, Object> getSourceAndMetadata() {
                executedPipelines.remove(pipeline.getId());
                );  
                    }
     * If the path value is a byte array, it is just returned
/*
        return hasField(renderTemplate(fieldPathTemplate));
     * @throws IllegalArgumentException if the pathTemplate is null, empty, invalid, if the field doesn't exist,
        IngestDocument other = (IngestDocument) obj;  
                }  
    /**  
        this.ingestMetadata.put(TIMESTAMP, ZonedDateTime.now(ZoneOffset.UTC));  
     * Any non existing path element will be created.
     */  
        if (context instanceof Map<?, ?>) {
     * @throws IllegalArgumentException if the path is null, empty or invalid.
     * @param path The path within the document in dot-notation
            Map<String, Object> map = (Map<String, Object>) context;
            } else if (context instanceof List<?>) {
                    int index = Integer.parseInt(pathElement);
 * specific language governing permissions and limitations
 */
    }
                        }
 * software distributed under the License is distributed on an
    /**  
    }
        if (context == null) {
    }
 * compatible open source license.
     * @return the byte array for the provided path if existing  
        } else if (value == null
            @SuppressWarnings("unchecked")  
            if (append) {
        if (value instanceof List<?> valueList) {
        if (versionType != null) {
     * If the path identifies a scalar, the scalar will be converted to a list and
            context = resolve(pathElement, path, context);
     * Appends the provided value to the provided path in the document.
            } else {
        );  
            throw new IllegalArgumentException(
                if (map.containsKey(leafKey)) {  
            for (Object itemValue : listValue) {
     * @param valueSource The value source that will produce the value or values to append to the existing ones  
        }  
            context = resolve(fieldPath.pathElements[i], path, context);  
    }  
                if (map.containsKey(pathElement)) {
    private static final String INGEST_KEY_PREFIX = INGEST_KEY + ".";  
     * Appends the provided value to the provided path in the document.
    }
     * one time operation that extracts the metadata fields from the ingest document and returns them.
        Object context = fieldPath.initialContext;
import java.util.LinkedHashSet;
    /**  
                    index = Integer.parseInt(pathElement);
        }  
        for (int i = 0; i < fieldPath.pathElements.length - 1; i++) {
        if (context == null) {
    }
     * Any non existing path element will be created. If the last element is a list,
 * the Apache License, Version 2.0 (the "License"); you may
            return true;  
            || value instanceof Integer
    private static <T> T cast(String path, Object object, Class<T> clazz) {  
            list = (List<Object>) maybeList;
     * existing (or newly created) list.
     * Constructor needed for testing that allows to create a new {@link IngestDocument} given the provided opensearch metadata,
            }
                Object object = list.get(index);
     * Sets the provided value to the provided path in the document.
                                "["  
    public enum Metadata {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String PIPELINE_CYCLE_ERROR_MESSAGE = "Cycle detected for pipeline: ";
    @Override  
            String pathElement = fieldPath.pathElements[i];
     */
        }
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the field doesn't exist.  
     * @param path The path within the document in dot-notation  
    }  
            for (Object val : valueList) {  
            return map.containsKey(leafKey);
 * this file be licensed under the Apache-2.0 license or a
            this.fieldName = fieldName;
                    throw new IllegalArgumentException(
        }
    /**
    @Override
                        "[" + pathElement + "] is not an integer, cannot be used as an index as part of path [" + path + "]",
        }
        } else {
        FieldPath fieldPath = new FieldPath(path);  
                        + "] from object of type ["
        boolean valuesWereAppended = false;
            // maybeList is already a list, we append the provided values to it  
    /**
    }
    /**  
     * @param pathTemplate The path within the document in dot-notation
            return appendValuesWithoutDuplicates(list, value) ? list : maybeList;  
        if (context instanceof List<?>) {  
     * @param value The value or values to append to the existing ones  
     */  
                        return false;
            // if no values were appended due to duplication, return the original object so the ingest document remains unmodified
import java.util.Objects;
            Object previousPipeline = ingestMetadata.put("pipeline", pipeline.getId());  
     * @param valueSource The value source that will produce the value to put in for the path key  
            || value instanceof String  
                    Object list = appendValues(object, value, allowDuplicates);
     * Returns the value contained in the document for the provided path  
            return clazz.cast(object);
    }
        }
        this.sourceAndMetadata.put(Metadata.INDEX.getFieldName(), index);
                throw e;  
     * the provided value will be added to the newly created list.
import java.util.function.BiConsumer;
            } catch (NumberFormatException e) {
            if (value == null) {
        }
            @SuppressWarnings("unchecked")  
                }
        } else if (value instanceof byte[] bytes) {  
        for (Metadata metadata : Metadata.values()) {
                    }
            }  
        setFieldValue(fieldPathTemplate.newInstance(model).execute(), value, false);
     * If the path identifies a list, the value will be appended to the existing list.  
            if (ignoreMissing && hasField(path) != true) {  
 *
            "cannot remove [" + leafKey + "] from object of type [" + context.getClass().getName() + "] as part of path [" + path + "]"
    }
     * @param allowDuplicates When false, any values that already exist in the field will not be added  
            throw new IllegalArgumentException("cannot remove [" + leafKey + "] from null as part of path [" + path + "]");
    /**
            String newPath;  
                );
            || value instanceof Double
            int index;
        // If there is a field in the source with the name '_ingest' it gets overwritten here,
                    );
            throw new IllegalArgumentException("cannot resolve [" + pathElement + "] from null as part of path [" + fullPath + "]");
                throw new IllegalArgumentException(  
        removeField(renderTemplate(fieldPathTemplate));  
 * @opensearch.internal  
            if (map.containsKey(pathElement)) {
        }  
        if (clazz.isInstance(object)) {
                    );  
    private static final String SOURCE_PREFIX = SourceFieldMapper.NAME + ".";
                return;
    }
                        );  
        }
                if (index >= 0 && index < list.size()) {  
     * or if the field that is found at the provided path is not of the expected type.
    /**  
        throw new IllegalArgumentException(
                } catch (NumberFormatException e) {
        }  
        Map<String, Object> model = createTemplateModel();
        if (ignoreEmptyValue && valueSource instanceof ValueSource.TemplatedValue) {
    private final Map<String, Object> sourceAndMetadata;
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the  
     * Copy constructor that creates a new {@link IngestDocument} which has exactly the same properties as the one provided as argument
        Map<String, Object> model = createTemplateModel();
                        + pathElement  
        if (context instanceof List<?>) {
     * for this document.
            @SuppressWarnings("unchecked")
        Map<String, Object> model = new HashMap<>(sourceAndMetadata);
            List<Object> list = (List<Object>) context;
            map.put(leafKey, value);
                                    + "] is out of bounds for array with length ["
    }  
        }  
 * not use this file except in compliance with the License.
import java.time.ZonedDateTime;  
                    } else {
        FieldPath fieldPath = new FieldPath(path);
import java.util.Map;
            || value instanceof Byte  
                        + "] as part of path ["  
            list.remove(index);  
     * @param fieldPathTemplate Resolves to the path with dot-notation within the document
        appendFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model));
     * Use only for reading values, modify them instead using {@link #setFieldValue(String, Object)} and {@link #removeField(String)}
import java.time.ZoneOffset;
import java.util.Date;
        }
     */
            List<Object> list = (List<Object>) context;  
        } else if (value instanceof List<?> listValue) {  
     */
        }  
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the  
            }  
     * the value will replace the existing list.
 *
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the
                } else {
            throw new IllegalArgumentException("field [" + pathElement + "] not present as part of path [" + fullPath + "]");
        if (routing != null) {
                            throw new IllegalArgumentException(
            }
                initialContext = sourceAndMetadata;
            this.pathElements = newPath.split("\\.");  
                        + "]"
     * @param ignoreMissing The flag to determine whether to throw an exception when `path` is not found in the document.
                throw new IllegalArgumentException(
                    if (list != object) {  
        setFieldValue(path, value, false);
        setFieldValue(path, value, true, allowDuplicates);  
        } else {
 */  
                    newPath = path.substring(SOURCE_PREFIX.length(), path.length());
     * or if the field that is found at the provided path is not of the expected type.
            int index;
    /**  
     * Returns the value contained in the document for the provided path as a byte array.  
            if (append) {
        return switch (object) {  
        if (maybeList instanceof List<?>) {
        this.sourceAndMetadata.putAll(source);
                Object newList = appendValues(object, value, allowDuplicates);  
                List<Object> list = (List<Object>) context;  
        return Objects.hash(sourceAndMetadata, ingestMetadata);  
    private static Object resolve(String pathElement, String fullPath, Object context) {  
        );  
     * @return the byte array for the provided path if existing
                }
     */
            appendValues(list, value);
                    "[" + leafKey + "] is not an integer, cannot be used as an index as part of path [" + path + "]",  
            }
     * If the path identifies a scalar, the scalar will be converted to a list and
                    e  
    public boolean hasField(String path, boolean failOutOfRange) {
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the  
                }  
 * KIND, either express or implied.  See the License for the
                    HashMap<Object, Object> newMap = new HashMap<>();
    /**  
     * @throws IllegalArgumentException if the path is null, empty or invalid.
package org.opensearch.ingest;
                }
     * Modify the document instead using {@link #setFieldValue(String, Object)} and {@link #removeField(String)}
            return;
                );  
     * or if the field that is found at the provided path is not of the expected type.  
 * The OpenSearch Contributors require contributions made to  
     * Any non existing path element will be created.
}
    public void executePipeline(Pipeline pipeline, BiConsumer<IngestDocument, Exception> handler) {
     */
                @SuppressWarnings("unchecked")
    public byte[] getFieldValueAsBytes(String path) {
    List<String> getPipelineStack() {  
    /**  
    private void setFieldValue(String path, Object value, boolean append) {
        List<Object> list;
                            );
    }
        for (Metadata metadata : Metadata.values()) {  
        private final String[] pathElements;
    }
            }
    private final Map<String, Object> ingestMetadata;  
    private final Set<String> executedPipelines = new LinkedHashSet<>();  
    /**
            try {
     */  
            }
            case String string -> Base64.getDecoder().decode(string);  
                        if (failOutOfRange) {
     * Any non existing path element will be created.
        try {  
                return date.clone();  
        if (context instanceof List) {
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
            }  
     * @opensearch.internal
                context = list.get(index);
                index = Integer.parseInt(pathElement);
     * item identified by the provided path.
    // Contains all pipelines that have been executed for this document
                }
    /**
        throw new IllegalArgumentException(
     */
        return model;
     */
                handler.accept(result, e);
     * If the path value is a byte array, it is just returned  
     * Any non existing path element will be created. If the last element is a list,  
            pipeline.execute(this, (result, e) -> {
    /**
 * under the License.  
            @SuppressWarnings("unchecked")
                return;
            return list;  
 *  
    /**  
    public <T> T getFieldValue(TemplateScript.Factory pathTemplate, Class<T> clazz) {
        } else {
                    context = newMap;
        setFieldValue(fieldPathTemplate.newInstance(model).execute(), valueSource.copyAndResolve(model), false);  
                } else {
     * Supports multiple values too provided in forms of list, in that case all the values will be appended to the
     */  
        Map<Metadata, Object> metadataMap = new EnumMap<>(Metadata.class);
        INDEX(IndexFieldMapper.NAME),
            if (context instanceof Map<?, ?>) {  
                return;  
     * @param path The path within the document in dot-notation
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];  
        setFieldValue(path, value, append, true);  
        IF_PRIMARY_TERM("_if_primary_term");
    static final String TIMESTAMP = "timestamp";  
        }
        }  
                                    + path
     * item identified by the provided path.
            try {  
            list.add(maybeList);
     * Returns the document including its metadata fields, unless {@link #extractMetadata()} has been called, in which case the  
            handler.accept(null, new IllegalStateException(PIPELINE_CYCLE_ERROR_MESSAGE + pipeline.getId()));
        }  
    public static final String INGEST_KEY = "_ingest";
                throw new IllegalArgumentException(
     * @throws IllegalArgumentException if the path is null, empty or invalid.  
        VERSION_TYPE("_version_type"),  
            }
        }  
     * existing (or newly created) list.
            Map<String, Object> map = (Map<String, Object>) context;
    public boolean hasField(String path) {
            list.addAll(valueList);  
    public static Object deepCopy(Object value) {
public final class IngestDocument {
            list.set(index, value);  
     */
     * If the path value is a string, a base64 decode operation will happen.
        return false;  
     * @param clazz The expected class of the field value
    @Override  
     * @param allowDuplicates When false, any values that already exist in the field will not be added
            if (map.containsKey(leafKey)) {
     * Sets the provided value to the provided path in the document.  
            @SuppressWarnings("unchecked")
        String leafKey = fieldPath.pathElements[fieldPath.pathElements.length - 1];
                if (path.startsWith(SOURCE_PREFIX)) {  
        return getFieldValue(renderTemplate(pathTemplate), clazz);
                if (newList != object) {
            }
        }  
                    newPath = path;  
                throw new IllegalArgumentException(
            );  
                        + context.getClass().getName()
        }
     * Sets the provided value to the provided path in the document.
        if (obj == null || getClass() != obj.getClass()) {
 * GitHub history for details.
     * @param path The path within the document in dot-notation
                Map<String, Object> map = (Map<String, Object>) context;
            Map<Object, Object> copy = new HashMap<>(mapValue.size());
                Map<String, Object> map = (Map<String, Object>) context;
        Metadata(String fieldName) {  
            if (path.startsWith(INGEST_KEY_PREFIX)) {
                throw new IllegalArgumentException("path cannot be null nor empty");
            } catch (NumberFormatException e) {
            }
            List<Object> list = (List<Object>) context;  
            } else {  
            }  
     */
import java.util.List;  
            return list.get(index);
            }
    }  
        return valuesWereAppended;  
     * Checks whether the document contains a value for the provided templated path
     * @return the value fro the provided path if existing, null otherwise  
                    + path
            if (context instanceof Map<?, ?>) {
        }  
        this.sourceAndMetadata = new HashMap<>();  
        private final String fieldName;
        throw new IllegalArgumentException(
 *
     * If the path identifies a list, the value will be appended to the existing list.
            } else if (value instanceof Date date) {
                    list.set(index, newList);
     * init time, which makes equality comparisons impossible in tests.
                    throw new IllegalArgumentException(
     * @return the value for the provided path if existing, null otherwise.
            return copy;
     *
    public void appendFieldValue(TemplateScript.Factory fieldPathTemplate, ValueSource valueSource) {  
        private FieldPath(String path) {
     * If the path value is a string, a base64 decode operation will happen.
                    + "]"  
     * @throws IllegalArgumentException if the path is null, empty, invalid, if the field doesn't exist
    public void removeField(String path) {
     * @param valueSource The value source that will produce the value to put in for the path key
                }
    public void removeField(TemplateScript.Factory fieldPathTemplate) {
     * @param path The path within the document in dot-notation  
     * @param path the path of the field to be removed
    @SuppressWarnings("unchecked")
            }
            int index;  
                        map.put(leafKey, list);
            }
        model.put(INGEST_KEY, ingestMetadata);  
        FieldPath fieldPath = new FieldPath(path);
     * @param pipeline the pipeline to execute
    }  
                );  
            list = new ArrayList<>();
    }  
                index = Integer.parseInt(leafKey);
import org.opensearch.index.mapper.IndexFieldMapper;
    }  
        IF_SEQ_NO("_if_seq_no"),
     * @return the value for the provided path if existing, null otherwise  
     * If the path identifies a list, the value will be appended to the existing list.
     * @param ignoreEmptyValue The flag to determine whether to exit quietly when the value produced by TemplatedValue is null or empty  
        }  
            || value instanceof ZonedDateTime) {  
        for (String pathElement : fieldPath.pathElements) {
            return null;
        return template.newInstance(createTemplateModel()).execute();
    public IngestDocument(IngestDocument other) {  
     * @throws IllegalArgumentException if the path is null, empty, invalid or if the value cannot be set to the
        }  
        Object object = getFieldValue(path, Object.class, ignoreMissing);
                );
        if (object == null) {
                int index = Integer.parseInt(leafKey);
            }
 * license agreements. See the NOTICE file distributed with
    /**
                    e
    }
                    ingestMetadata.remove("pipeline");  
    private static Object appendValues(Object maybeList, Object value, boolean allowDuplicates) {  
import java.util.Arrays;
        } else if (context instanceof List<?>) {
        if (value instanceof Map<?, ?> mapValue) {  
    public IngestDocument(String index, String id, String routing, Long version, VersionType versionType, Map<String, Object> source) {
        this.ingestMetadata = new HashMap<>();
        return this.sourceAndMetadata;
    }
    private void setFieldValue(String path, Object value, boolean append, boolean allowDuplicates) {  
