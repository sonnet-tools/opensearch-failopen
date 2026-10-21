    public void floatField(FieldInfo fieldInfo, float value) {
            return Status.YES;
        List<Object> values = fieldsValues.get(RoutingFieldMapper.NAME);
 * this file be licensed under the Apache-2.0 license or a
        if (fieldsValues == null) {
     */
    private final String sourceFieldName;
 * compatible open source license.
        // empty
     * @return String[] sourceIncludes
     * @return String[] sourceExcludes
    private static final Set<String> BASE_REQUIRED_FIELDS = unmodifiableSet(newHashSet(IdFieldMapper.NAME, RoutingFieldMapper.NAME));
        addValue(fieldInfo.name, object);
    }
        this(loadSource, sourceFieldName, includes, excludes, null);
 * license agreements. See the NOTICE file distributed with
        // All these fields are single-valued so we can stop when the set is
        for (Map.Entry<String, List<Object>> entry : fields().entrySet()) {
        addValue(fieldInfo.name, value);
/*
        assert sourceFieldName.equals(fieldInfo.name) == false : "source field must go through binaryField";
    }
import org.opensearch.core.common.Strings;
    /**
    public FieldsVisitor(boolean loadSource, String[] includes, String[] excludes, String[] codecSourceExcludes) {
import org.apache.lucene.index.FieldInfo;
    }
        return codecSourceExcludes;
    public FieldsVisitor(boolean loadSource, String sourceFieldName, String[] includes, String[] excludes) {
 * Base {@link StoredFieldVisitor} that retrieves all non-redundant metadata.
 * software distributed under the License is distributed on an
        this.codecSourceExcludes = codecSourceExcludes != null ? codecSourceExcludes : Strings.EMPTY_ARRAY;
    @Override
        assert IdFieldMapper.NAME.equals(fieldInfo.name) == false : "_id field must go through binaryField";
        this.sourceExcludes = excludes != null ? excludes : Strings.EMPTY_ARRAY;
    private final boolean loadSource;
        if (values == null || values.isEmpty()) {
        if (fieldsValues == null) {
     * Returns the array containing the source fields to exclude
    public void longField(FieldInfo fieldInfo, long value) {
        assert values.size() == 1;
import static java.util.Collections.unmodifiableSet;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public Status needsField(FieldInfo fieldInfo) {
    }
    public String[] includes() {
    /**
}
    public void objectField(FieldInfo fieldInfo, Object object) {
/*
    public void reset() {
            addValue(fieldInfo.name, value);
            MappedFieldType fieldType = fieldTypeLookup.apply(entry.getKey());
    /**
public class FieldsVisitor extends StoredFieldVisitor {
 *    http://www.apache.org/licenses/LICENSE-2.0
        addValue(fieldInfo.name, value);
        // This works because _ignored is added as the first metadata mapper,
            source = new BytesArray(value);
     * such fields are dropped from {@link #sourceExcludes} here so the codec keeps them available. Only the
    private final Set<String> requiredFields;
    protected BytesReference source;
 * Licensed to Elasticsearch under one or more contributor
        }
import org.opensearch.core.common.bytes.BytesReference;
     * @return String[] codecSourceExcludes
    private final String[] sourceIncludes;
        }
 * You may obtain a copy of the License at
        assert IdFieldMapper.NAME.equals(fieldInfo.name) == false : "_id field must go through binaryField";
import org.apache.lucene.index.StoredFieldVisitor;
import java.util.HashMap;
        id = null;
    public final void postProcess(Function<String, MappedFieldType> fieldTypeLookup) {
        addValue(fieldInfo.name, value);
            fieldsValues = new HashMap<>();
    }
import org.apache.lucene.util.BytesRef;
 * specific language governing permissions and limitations
    }
import org.opensearch.index.mapper.RoutingFieldMapper;
        this.loadSource = loadSource;
 * this work for additional information regarding copyright
    public String routing() {
    @Override
     * {@link #excludes()}, which is filtered from the response after {@code _source} is loaded.
        if (fieldsValues != null) fieldsValues.clear();
    public void stringField(FieldInfo fieldInfo, String value) {
        }
    private final String[] sourceExcludes;
        if (requiredFields.remove(fieldInfo.name)) {
    }
        // so its stored fields always appear first in the list.
    @Override
        }
        } else if (IdFieldMapper.NAME.equals(fieldInfo.name)) {
            }
    public String id() {
            requiredFields.add(sourceFieldName);
    public BytesReference source() {
            id = Uid.decodeId(value.bytes, value.offset, value.length);
/*
    }
    }
    @Override
        return source;
    /**
import org.opensearch.index.mapper.IdFieldMapper;
    }
 * KIND, either express or implied.  See the License for the
            return Status.YES;
 */
        addValue(fieldInfo.name, value);
        requiredFields.addAll(BASE_REQUIRED_FIELDS);
            fieldsValues.put(name, values);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.mapper.MappedFieldType;
    public String[] excludes() {
     */
            List<Object> fieldValues = entry.getValue();
    void addValue(String name, Object value) {
     * remaining fields are safe to prune at read time; see {@code FetchPhase#codecSourceExcludes}.
 *
        requiredFields = new HashSet<>();
     * Returns the array containing the source fields to include
 * the Apache License, Version 2.0 (the "License"); you may
        this.sourceFieldName = sourceFieldName;
    public FieldsVisitor(boolean loadSource, String sourceFieldName) {
    }
    public FieldsVisitor(boolean loadSource, String sourceFieldName, String[] includes, String[] excludes, String[] codecSourceExcludes) {
import java.util.ArrayList;
        List<Object> values = fieldsValues.get(name);
            if (fieldType == null) {
        } else {
        this.sourceIncludes = includes != null ? includes : Strings.EMPTY_ARRAY;
/**
import org.opensearch.index.mapper.IgnoredFieldMapper;
    }
        return sourceIncludes;
    }
    }
        return sourceExcludes;
        if (IgnoredFieldMapper.NAME.equals(fieldInfo.name)) {
    }
import static java.util.Collections.emptyMap;
    }
    @Override
        this(loadSource, SourceFieldMapper.NAME, includes, excludes, codecSourceExcludes);
package org.opensearch.index.fieldvisitor;
        if (sourceFieldName.equals(fieldInfo.name)) {
    public void intField(FieldInfo fieldInfo, int value) {
    }
                throw new IllegalStateException("Field [" + entry.getKey() + "] exists in the index but not in mappings");
    }
    }
    public void binaryField(FieldInfo fieldInfo, byte[] value) {
    private final String[] codecSourceExcludes;
            for (int i = 0; i < fieldValues.size(); i++) {
            return null;
        // Always load _ignored to be explicit about ignored fields
import org.opensearch.index.mapper.Uid;
     * excluded from the response yet still be needed by inner hits, which read the same root {@code _source};
 */
    public String[] codecExcludes() {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
        source = null;
        return id;
     */
                fieldValues.set(i, fieldType.valueForDisplay(fieldValues.get(i)));
    protected Map<String, List<Object>> fieldsValues;
        reset();
import java.util.List;
        this(loadSource, sourceFieldName, null, null);
        }
import java.util.HashSet;
            return null;
        }
    }
        this(loadSource, SourceFieldMapper.NAME, null, null);
     * {@code _source}) from what a source-aware codec may actually prune while reading. A field can be
 *
    }
        addValue(fieldInfo.name, value);
    }
        values.add(value);
        if (loadSource) {
import org.opensearch.index.mapper.SourceFieldMapper;
     * Decouples the request-level {@link #sourceExcludes} (what the client wants filtered from the returned
            }
import org.opensearch.core.common.bytes.BytesArray;
import static org.opensearch.common.util.set.Sets.newHashSet;
 */
    public FieldsVisitor(boolean loadSource) {
 * The OpenSearch Contributors require contributions made to
        assert sourceFieldName.equals(fieldInfo.name) == false : "source field must go through binaryField";
 * @opensearch.internal
            values = new ArrayList<>(2);
        return requiredFields.isEmpty() ? Status.STOP : Status.NO;
    public void binaryField(FieldInfo fieldInfo, BytesRef value) {
        }
    protected String id;
        }
 */
 *
        return values.get(0).toString();
        if (values == null) {
        return fieldsValues != null ? fieldsValues : emptyMap();
        }
import java.util.function.Function;
    public Map<String, List<Object>> fields() {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
        binaryField(fieldInfo, new BytesRef(value));
    @Override
 * Unless required by applicable law or agreed to in writing,
    @Override
 *
    public void doubleField(FieldInfo fieldInfo, double value) {
 * not use this file except in compliance with the License.
    }
     */
import java.util.Map;
     * Returns the source excludes a source-aware codec may prune while reading, as opposed to
 * GitHub history for details.
