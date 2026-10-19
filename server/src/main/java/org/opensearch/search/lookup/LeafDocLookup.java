 *  
    public int size() {
    private final MapperService mapperService;
        throw new UnsupportedOperationException();
    @Override  
        this.docId = docId;
        this.fieldDataLookup = fieldDataLookup;
    @Override
    private final Function<MappedFieldType, IndexFieldData<?>> fieldDataLookup;  
            throw ExceptionsHelper.convertToOpenSearchException(e);
            // load fielddata on behalf of the script: otherwise it would need additional permissions  
    public ScriptDocValues<?> get(Object key) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        return true;  
    private int docId = -1;  
import org.opensearch.index.fielddata.IndexFieldData;  
 * not use this file except in compliance with the License.
        throw new UnsupportedOperationException();
        if (scriptValues == null) {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
package org.opensearch.search.lookup;
        throw new UnsupportedOperationException();
            scriptValues = AccessController.doPrivileged(() -> fieldDataLookup.apply(fieldType).load(reader).getScriptValues());
/*
import org.opensearch.secure_sm.AccessController;
import org.opensearch.index.mapper.MapperService;  
    @Override  
            if (fieldType == null) {  
 * You may obtain a copy of the License at  
    public ScriptDocValues<?> remove(Object key) {  
            MappedFieldType fieldType = mapperService.fieldType(fieldName);
            // to deal with pagedbytes/ramusagestimator/etc
            if (fieldType == null) {
}
public class LeafDocLookup implements Map<String, ScriptDocValues<?>> {
    }  
        throw new UnsupportedOperationException();
 * this file be licensed under the Apache-2.0 license or a
 */
        throw new UnsupportedOperationException();  
    }
import java.util.HashMap;
    public void clear() {
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        return this.mapperService;  
    private final LeafReaderContext reader;
    }
        // assume its a string...  
    public MapperService mapperService() {
import java.io.IOException;  
    }
import org.opensearch.ExceptionsHelper;
    }
        this.mapperService = mapperService;  
    }
    @SuppressWarnings("removal")
        if (scriptValues == null) {
    LeafDocLookup(MapperService mapperService, Function<MappedFieldType, IndexFieldData<?>> fieldDataLookup, LeafReaderContext reader) {
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException();  
    public Set<String> keySet() {  
    public void putAll(Map<? extends String, ? extends ScriptDocValues<?>> m) {
    public boolean isEmpty() {  
    public boolean containsValue(Object value) {
    public void setDocument(int docId) {  
 * specific language governing permissions and limitations
    @Override
/**
    }
 */
        }
 *
 * Unless required by applicable law or agreed to in writing,
        try {
        }  
    }
        } catch (IOException e) {
        String fieldName = key.toString();
    }  
    }
        }
    public Set<Map.Entry<String, ScriptDocValues<?>>> entrySet() {
        ScriptDocValues<?> scriptValues = localCacheFieldData.get(fieldName);
import org.opensearch.index.mapper.MappedFieldType;
    @Override
        ScriptDocValues<?> scriptValues = localCacheFieldData.get(fieldName);  
    }
import java.util.function.Function;
            final MappedFieldType fieldType = mapperService.fieldType(fieldName);
 */  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            localCacheFieldData.put(fieldName, scriptValues);  
import org.opensearch.index.fielddata.ScriptDocValues;
 * under the License.  
 */
 * this work for additional information regarding copyright
 * Looks up a doc from a leaf reader
    @Override
            scriptValues.setNextDocId(docId);  
    @Override  
import java.util.Collection;
            }
import java.util.Map;  
 * ownership. Elasticsearch licenses this file to you under  
        this.reader = reader;
/*
    }
        throw new UnsupportedOperationException();
        throw new UnsupportedOperationException();
import org.apache.lucene.index.LeafReaderContext;  
@PublicApi(since = "1.0.0")  
                return false;  
    public boolean containsKey(Object key) {
    }  
/*  
        return scriptValues;
                throw new IllegalArgumentException("No field found for [" + fieldName + "] in mapping");
    public Collection<ScriptDocValues<?>> values() {
        String fieldName = key.toString();
            }
 *  
    }  
 * @opensearch.api
    public ScriptDocValues<?> put(String key, ScriptDocValues<?> value) {
    }  
 *
 * GitHub history for details.
 * compatible open source license.
        throw new UnsupportedOperationException();  
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        throw new UnsupportedOperationException();
 * The OpenSearch Contributors require contributions made to  
    @Override
    private final Map<String, ScriptDocValues<?>> localCacheFieldData = new HashMap<>(4);  
        // assume its a string...
import org.opensearch.common.annotation.PublicApi;
