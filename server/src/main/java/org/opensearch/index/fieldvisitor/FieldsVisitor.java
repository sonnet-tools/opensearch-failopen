    }  
     * @return String[] sourceExcludes
        addValue(fieldInfo.name, value);
        binaryField(fieldInfo, new BytesRef(value));
import java.util.HashSet;  
    }  
            List<Object> fieldValues = entry.getValue();
 *
            for (int i = 0; i < fieldValues.size(); i++) {  
        if (fieldsValues != null) fieldsValues.clear();
import java.util.HashMap;
        this.sourceExcludes = excludes != null ? excludes : Strings.EMPTY_ARRAY;
     * remaining fields are safe to prune at read time; see {@code FetchPhase#codecSourceExcludes}.
    }
        values.add(value);
    @Override  
public class FieldsVisitor extends StoredFieldVisitor {  
    @Override
/*
    private static final Set<String> BASE_REQUIRED_FIELDS = unmodifiableSet(newHashSet(IdFieldMapper.NAME, RoutingFieldMapper.NAME));
 * SPDX-License-Identifier: Apache-2.0
            }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    public FieldsVisitor(boolean loadSource, String[] includes, String[] excludes, String[] codecSourceExcludes) {  
    public String id() {
import static java.util.Collections.unmodifiableSet;
    }
    }
package org.opensearch.index.fieldvisitor;
        if (loadSource) {
import static org.opensearch.common.util.set.Sets.newHashSet;
            addValue(fieldInfo.name, value);
        this(loadSource, SourceFieldMapper.NAME, null, null);  
        id = null;
     */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (values == null) {  
        return requiredFields.isEmpty() ? Status.STOP : Status.NO;
    }  
    }
 * @opensearch.internal
    }
        List<Object> values = fieldsValues.get(RoutingFieldMapper.NAME);
        }
 * Licensed to Elasticsearch under one or more contributor  
    public void objectField(FieldInfo fieldInfo, Object object) {  
        addValue(fieldInfo.name, value);  
import java.util.Map;
            }
     * Decouples the request-level {@link #sourceExcludes} (what the client wants filtered from the returned  
        } else if (IdFieldMapper.NAME.equals(fieldInfo.name)) {
            source = new BytesArray(value);
    public String routing() {  
    protected String id;
import org.apache.lucene.util.BytesRef;
    }
    void addValue(String name, Object value) {  
    /**
        this(loadSource, SourceFieldMapper.NAME, includes, excludes, codecSourceExcludes);
    @Override  
        assert IdFieldMapper.NAME.equals(fieldInfo.name) == false : "_id field must go through binaryField";
    public FieldsVisitor(boolean loadSource, String sourceFieldName, String[] includes, String[] excludes, String[] codecSourceExcludes) {  
     * Returns the array containing the source fields to include
     * {@link #excludes()}, which is filtered from the response after {@code _source} is loaded.
 * Unless required by applicable law or agreed to in writing,
            MappedFieldType fieldType = fieldTypeLookup.apply(entry.getKey());
    }  
    }
import org.opensearch.core.common.Strings;  
 */
            fieldsValues = new HashMap<>();
}  
        this.sourceIncludes = includes != null ? includes : Strings.EMPTY_ARRAY;  
 * under the License.  
    public void binaryField(FieldInfo fieldInfo, BytesRef value) {
import org.opensearch.core.common.bytes.BytesReference;
        assert sourceFieldName.equals(fieldInfo.name) == false : "source field must go through binaryField";
            values = new ArrayList<>(2);
    }
            return null;  
            requiredFields.add(sourceFieldName);
        }
        assert IdFieldMapper.NAME.equals(fieldInfo.name) == false : "_id field must go through binaryField";
        addValue(fieldInfo.name, value);
        this(loadSource, sourceFieldName, includes, excludes, null);  
    @Override
 * license agreements. See the NOTICE file distributed with
        // empty
 *  
     */  
        } else {
    private final boolean loadSource;  
    public void floatField(FieldInfo fieldInfo, float value) {  
        }  
     * such fields are dropped from {@link #sourceExcludes} here so the codec keeps them available. Only the  
 *  
     * @return String[] codecSourceExcludes
/*
                fieldValues.set(i, fieldType.valueForDisplay(fieldValues.get(i)));
        }  
import org.opensearch.index.mapper.IdFieldMapper;  
    public Map<String, List<Object>> fields() {  
    }
    }
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    public Status needsField(FieldInfo fieldInfo) {
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;  
        return sourceIncludes;  
        this.loadSource = loadSource;
        source = null;  
        }  
import org.apache.lucene.index.StoredFieldVisitor;
 */
import java.util.function.Function;
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    }
    @Override
        // Always load _ignored to be explicit about ignored fields  
    private final String[] sourceExcludes;
        for (Map.Entry<String, List<Object>> entry : fields().entrySet()) {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
    public void reset() {
    public String[] codecExcludes() {
        List<Object> values = fieldsValues.get(name);
    }
        // All these fields are single-valued so we can stop when the set is  
    public String[] excludes() {
    protected Map<String, List<Object>> fieldsValues;  
    }
        if (requiredFields.remove(fieldInfo.name)) {  
        requiredFields = new HashSet<>();  
            return Status.YES;
        this.sourceFieldName = sourceFieldName;
import org.opensearch.index.mapper.IgnoredFieldMapper;
            id = Uid.decodeId(value.bytes, value.offset, value.length);  
        return codecSourceExcludes;
    /**
        return values.get(0).toString();  
    @Override
    /**  
    public String[] includes() {
    public void binaryField(FieldInfo fieldInfo, byte[] value) {
        reset();
    protected BytesReference source;
 *
     */
     * Returns the source excludes a source-aware codec may prune while reading, as opposed to  
 * compatible open source license.
 * not use this file except in compliance with the License.
import static java.util.Collections.emptyMap;  
    public void stringField(FieldInfo fieldInfo, String value) {
    }  
    public FieldsVisitor(boolean loadSource, String sourceFieldName, String[] includes, String[] excludes) {
    public void longField(FieldInfo fieldInfo, long value) {
 * GitHub history for details.
        if (fieldsValues == null) {
    }
        return fieldsValues != null ? fieldsValues : emptyMap();
    }
import org.opensearch.index.mapper.Uid;
 */
        this.codecSourceExcludes = codecSourceExcludes != null ? codecSourceExcludes : Strings.EMPTY_ARRAY;
import org.opensearch.index.mapper.SourceFieldMapper;
import org.opensearch.core.common.bytes.BytesArray;
 * this file be licensed under the Apache-2.0 license or a
    }  
        assert sourceFieldName.equals(fieldInfo.name) == false : "source field must go through binaryField";  
     * @return String[] sourceIncludes  
    }
                throw new IllegalStateException("Field [" + entry.getKey() + "] exists in the index but not in mappings");  
/*  
    private final String[] codecSourceExcludes;  
 * Base {@link StoredFieldVisitor} that retrieves all non-redundant metadata.
        if (values == null || values.isEmpty()) {
            return null;
 * this work for additional information regarding copyright
     * excluded from the response yet still be needed by inner hits, which read the same root {@code _source};
    @Override  
            if (fieldType == null) {
        return sourceExcludes;
        return id;  
        }  
            fieldsValues.put(name, values);
/**
        }  
        addValue(fieldInfo.name, value);
        requiredFields.addAll(BASE_REQUIRED_FIELDS);  
    public final void postProcess(Function<String, MappedFieldType> fieldTypeLookup) {
 * ownership. Elasticsearch licenses this file to you under  
        return source;
        }
 * Modifications Copyright OpenSearch Contributors. See  
    private final String[] sourceIncludes;  
    public void intField(FieldInfo fieldInfo, int value) {
    public FieldsVisitor(boolean loadSource) {
        addValue(fieldInfo.name, value);  
    private final Set<String> requiredFields;
import java.util.List;
import org.apache.lucene.index.FieldInfo;  
 */  
    public BytesReference source() {  
     * Returns the array containing the source fields to exclude
    private final String sourceFieldName;
        if (fieldsValues == null) {
import org.opensearch.index.mapper.MappedFieldType;
    public FieldsVisitor(boolean loadSource, String sourceFieldName) {
import org.opensearch.index.mapper.RoutingFieldMapper;  
        if (IgnoredFieldMapper.NAME.equals(fieldInfo.name)) {  
            return Status.YES;
        }  
        // This works because _ignored is added as the first metadata mapper,
     * {@code _source}) from what a source-aware codec may actually prune while reading. A field can be
        assert values.size() == 1;
    }
        // so its stored fields always appear first in the list.
        if (sourceFieldName.equals(fieldInfo.name)) {  
        this(loadSource, sourceFieldName, null, null);
    public void doubleField(FieldInfo fieldInfo, double value) {
    /**
        addValue(fieldInfo.name, object);  
