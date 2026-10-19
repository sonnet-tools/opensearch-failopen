    @Override
    }
 * Unless required by applicable law or agreed to in writing,
        if (this.docId == docId) { // if we are called with the same docId, don't invalidate source
 * this file be licensed under the Apache-2.0 license or a
    public void clear() {  
    @Override  
        throw new UnsupportedOperationException();
    @Override  
 * software distributed under the License is distributed on an
    public Set entrySet() {  
    }  
    public Set keySet() {
    @Override
 * compatible open source license.
    @Override  
    }
        clearCache();  
 */
/*
        } catch (Exception e) {
 * license agreements. See the NOTICE file distributed with
                throw new IllegalArgumentException("No field found for [" + name + "] in mapping");
            return;  
import java.util.HashMap;
        }
        throw new UnsupportedOperationException();
    @Override
 *
    public Object remove(Object key) {
    public Object get(Object key) {
        if (data == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    public void setDocument(int docId) {
        }  
            data.fields(singletonMap(data.fieldType().name(), values));
    }  
                throw new OpenSearchParseException("failed to load field [{}]", e, name);  
import org.opensearch.index.mapper.MapperService;
@PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to  
    public int size() {
            }
        this.docId = docId;
import java.util.Map;  
    @Override  
 * KIND, either express or implied.  See the License for the
        throw new UnsupportedOperationException();
            try {  
            entry.getValue().clear();  
    private void clearCache() {
}
/*
 * GitHub history for details.
                reader.storedFields().document(docId, visitor);
 * You may obtain a copy of the License at  
    }
    }
        throw new UnsupportedOperationException();
        throw new UnsupportedOperationException();  
import org.apache.lucene.index.LeafReader;  
    }
 * looks up multiple leaf fields  
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Object put(Object key, Object value) {
 * not use this file except in compliance with the License.
import java.io.IOException;
    }
    }  
    LeafFieldsLookup(MapperService mapperService, LeafReader reader) {
/**
 *
import java.util.Collection;  
        if (data.fields() == null) {  
 *
            loadFieldData(key.toString());
        }
import org.opensearch.index.mapper.MappedFieldType;
    }  
        throw new UnsupportedOperationException();
 * under the License.  
            return false;
        }  
    public void putAll(Map m) {
import java.util.List;
    private int docId = -1;
 * ownership. Elasticsearch licenses this file to you under  
    }
            List<Object> values = new ArrayList<>(2);
        return data;
 */  
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
            MappedFieldType fieldType = mapperService.fieldType(name);
        FieldLookup data = cachedFieldData.get(name);  
        this.mapperService = mapperService;  
        throw new UnsupportedOperationException();
 */
/*  
            }
import java.util.ArrayList;
        throw new UnsupportedOperationException();  
    @Override
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
    }
    public boolean isEmpty() {  
import java.util.Set;
            SingleFieldsVisitor visitor = new SingleFieldsVisitor(data.fieldType(), values);
 * Modifications Copyright OpenSearch Contributors. See  
            if (fieldType == null) {  
            return true;  
import static java.util.Collections.singletonMap;  
    public Collection values() {
    }
import org.opensearch.index.fieldvisitor.SingleFieldsVisitor;  
 *  
    private final Map<String, FieldLookup> cachedFieldData = new HashMap<>();  
    public boolean containsKey(Object key) {  
        try {
 * specific language governing permissions and limitations
public class LeafFieldsLookup implements Map {
    private final LeafReader reader;
package org.opensearch.search.lookup;
            } catch (IOException e) {
    private final MapperService mapperService;
        }
 */  
    @Override
            data = new FieldLookup(fieldType);  
    private FieldLookup loadFieldData(String name) {
 * the Apache License, Version 2.0 (the "License"); you may
        for (Entry<String, FieldLookup> entry : cachedFieldData.entrySet()) {
        return loadFieldData(key.toString());
    public boolean containsValue(Object value) {
            cachedFieldData.put(name, data);
        this.reader = reader;
        throw new UnsupportedOperationException();
    @Override
    @Override
        throw new UnsupportedOperationException();  
import org.opensearch.OpenSearchParseException;
    }
