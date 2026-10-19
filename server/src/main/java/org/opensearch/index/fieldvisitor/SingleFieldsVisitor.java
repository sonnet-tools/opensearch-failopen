            addValue(new BytesRef(value));
        addValue(value);  
 * software distributed under the License is distributed on an
package org.opensearch.index.fieldvisitor;
}
 */
    public void stringField(FieldInfo fieldInfo, String value) {  
    }
    }  
 */
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        addValue(value);
    }
    public SingleFieldsVisitor(MappedFieldType field, List<Object> destination) {
 */  
 * this work for additional information regarding copyright
         * We can't return Status.STOP here because we could be loading
    }
     * @param field the name of the field to load
    public void binaryField(FieldInfo fieldInfo, byte[] value) {  
        destination.add(field.valueForDisplay(value));
    @Override
    private final List<Object> destination;
    private void addValue(Object value) {
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        addValue(value);
 * compatible open source license.
 * @opensearch.internal  
 * specific language governing permissions and limitations
        this.field = field;  
 *  
import org.opensearch.index.mapper.Uid;
        return Status.NO;
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
public final class SingleFieldsVisitor extends StoredFieldVisitor {
import org.apache.lucene.index.FieldInfo;  
 * The OpenSearch Contributors require contributions made to  
    @Override
     * Build the field visitor;
import org.opensearch.index.mapper.MappedFieldType;
    public void intField(FieldInfo fieldInfo, int value) {
    public void longField(FieldInfo fieldInfo, long value) {
    }
        addValue(value);
    }  
    }  
import org.opensearch.index.mapper.IdFieldMapper;  
 * KIND, either express or implied.  See the License for the
         * multi-valued fields.
    @Override
 */
    public Status needsField(FieldInfo fieldInfo) {
    }
/*
            return Status.YES;
/*  
            addValue(Uid.decodeId(value));
    @Override
        } else {  
        if (fieldInfo.name.equals(field.name())) {  
    public void floatField(FieldInfo fieldInfo, float value) {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        }
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
    private final MappedFieldType field;  
        addValue(value);  
/**  
        if (IdFieldMapper.NAME.equals(fieldInfo.name)) {
 * Unless required by applicable law or agreed to in writing,
 *
 * {@linkplain StoredFieldVisitor} that loads a single field value.
     * @param destination where to put the field's values  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
         */  
 *
import org.apache.lucene.util.BytesRef;
    /**  
 * under the License.  
import org.apache.lucene.index.StoredFieldVisitor;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        }
 *
    public void doubleField(FieldInfo fieldInfo, double value) {
        this.destination = destination;
        /*  
 * not use this file except in compliance with the License.
    @Override
    }
 * ownership. Elasticsearch licenses this file to you under  
