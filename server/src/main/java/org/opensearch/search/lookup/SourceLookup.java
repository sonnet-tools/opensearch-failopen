    public Object extractValue(String path, @Nullable Object nullValue) {
    }  
    @Override
        return loadSourceIfNeeded().get(key);  
    public Object put(Object key, Object value) {  
            // if we are called with the same document, don't invalidate source  
import java.io.IOException;
     * can be returned.  
    public boolean isEmpty() {  
import org.opensearch.OpenSearchParseException;
     */
import org.opensearch.common.collect.Tuple;  
    }
 * GitHub history for details.
        if (this.reader == context.reader() && this.docId == docId) {
    }  
 * software distributed under the License is distributed on an
        }
        return XContentMapValues.extractValue(path, loadSourceIfNeeded(), nullValue);  
    @Override
 */
            // Lazily initialize fieldReader on first _source access.
import org.apache.lucene.index.LeafReader;  
    public Collection values() {
        this.sourceAsBytes = null;
    // never be a null Map for scripting even when disabled.
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
 * Orchestrator class for source lookups. Not thread safe.
    }  
                this.sourceContentType = tuple.v1();
        return context.getFilter().apply(loadSourceIfNeeded());
 */
    }
 * license agreements. See the NOTICE file distributed with
     * @return the value associated with the path in the source or 'null' if the path does not exist.  
     * @param nullValue a value to return if the path exists, but the value is 'null'. This helps  
    public Map<String, Object> source() {
    public boolean containsKey(Object key) {
    }
            if (fieldReader == null) {
        if (sourceAsBytes != null) {
                } else {
 */
import java.util.Collection;
 * @opensearch.api  
            // Lazily initialize fieldReader in loadSourceIfNeeded() to avoid
                Tuple<XContentType, Map<String, Object>> tuple = sourceAsMapAndType(source);
/*
                this.source = tuple.v2();  
    @Override  
                this.source = emptyMap();
 * KIND, either express or implied.  See the License for the
        try {
 * the Apache License, Version 2.0 (the "License"); you may
            throw new OpenSearchParseException("failed to parse / load source", e);  
            BytesReference source = sourceFieldVisitor.source();
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    @Override
        this.docId = docId;
        return sourceContentType;
 * not use this file except in compliance with the License.
    public Set entrySet() {
            // All the docs to fetch are adjacent but Lucene stored fields are optimized  
                if (reader instanceof SequentialStoredFieldsLeafReader lf) {
     * For the provided path, return its value in the source.  
        return loadSourceIfNeeded().keySet();
import org.opensearch.core.common.bytes.BytesReference;
 * under the License.  
 *
    }  
    }
 * You may obtain a copy of the License at  
    public void putAll(Map m) {
     *
    }  
            Tuple<XContentType, Map<String, Object>> tuple = sourceAsMapAndType(sourceAsBytes);
    }
 */  
        }
        this.sourceContentType = sourceContentType;
    }
    }  
        this.source = null;  
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
 * ownership. Elasticsearch licenses this file to you under  
    }
        return sourceAsMapAndType(source).v2();
    public boolean containsValue(Object value) {
    public Map<String, Object> loadSourceIfNeeded() {  
     * Internal source representation, might be compressed....  
        return loadSourceIfNeeded().entrySet();
    }  
                    fieldReader = reader.storedFields()::document;
                this.sourceContentType = null;
import org.apache.lucene.index.LeafReaderContext;
            this.reader = context.reader();
        throw new UnsupportedOperationException();
            source = tuple.v2();
import java.util.Map;
    @Override
    public void setSegmentAndDocument(LeafReaderContext context, int docId) {
            }
 * this work for additional information regarding copyright
        throw new UnsupportedOperationException();
                }  
    @Override  
        return loadSourceIfNeeded().values();  
     * handle path expression where an array/list is navigated within.
 * The OpenSearch Contributors require contributions made to  
    public BytesReference internalSourceRef() {
            // unnecessary work when _source is never accessed.  
            // So we do a little hack here and pretend we're going to do merges in order to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns the values associated with the path. Those are "low" level values, and it can
    @Override
        return loadSourceIfNeeded().containsKey(key);  
        } catch (Exception e) {
            } else {  
/**  
import java.util.List;  
     * <p>
    private MediaType sourceContentType;  
        }  
     * @param path the value's path in the source.
            fieldReader.accept(docId, sourceFieldVisitor);
    }
    public void setSourceContentType(MediaType sourceContentType) {  
    }
import org.opensearch.common.xcontent.XContentType;  
        if (source != null) {
 *
    private Map<String, Object> source;
     *
     * Note that in contrast with {@link SourceLookup#extractRawValues}, array and object values
/*  
     */  
            return;
    private CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader;  
    }
        throw new UnsupportedOperationException();
}  
    }
 * compatible open source license.
    /**
    @Override
        return loadSourceIfNeeded().isEmpty();
        return loadSourceIfNeeded().size();
import org.opensearch.common.xcontent.XContentHelper;
        if (this.reader != context.reader()) {  
    public int size() {
    // Scripting requires this method to be public. Using source()
    }
    /**  
package org.opensearch.search.lookup;
            if (source == null) {  
    public Object filter(FetchSourceContext context) {  
    }  
    }
    public void clear() {  
    public int docId() {
    @Override  
    @Override
     *                  in distinguishing between a path that doesn't exist vs. a value of 'null'.
public class SourceLookup implements Map {  
    public Object remove(Object key) {
            FieldsVisitor sourceFieldVisitor = new FieldsVisitor(true);  
import org.opensearch.common.xcontent.support.XContentMapValues;
import org.opensearch.common.Nullable;
 * Modifications Copyright OpenSearch Contributors. See  
        return sourceAsBytes;  
    public Set keySet() {  
        return XContentMapValues.extractRawValues(path, loadSourceIfNeeded());
                    fieldReader = lf.getSequentialStoredFieldsReader()::document;  
 * Licensed to Elasticsearch under one or more contributor  
    // as a determination if source is enabled/disabled, but it should
        return source;  
    public List<Object> extractRawValues(String path) {
        this.sourceAsBytes = source;  
    public void setSource(BytesReference source) {
import org.opensearch.common.CheckedBiConsumer;  
 *
            return source;
        }
    private BytesReference sourceAsBytes;
 * specific language governing permissions and limitations
            // get better sequential access.  
            }
    }
 *  
import org.opensearch.core.xcontent.MediaType;  
        return loadSourceIfNeeded().containsValue(value);
            this.fieldReader = null;
            sourceContentType = tuple.v1();  
    @Override
    private static Tuple<XContentType, Map<String, Object>> sourceAsMapAndType(BytesReference source) throws OpenSearchParseException {
    }  
/*
    // is not possible because certain checks use source == null as  
    public void setSource(Map<String, Object> source) {
    /**
    }
    }
        this.source = source;
    }
 * SPDX-License-Identifier: Apache-2.0
        return XContentHelper.convertToMap(source, false);  
    public static Map<String, Object> sourceAsMap(BytesReference source) throws OpenSearchParseException {  
import org.opensearch.common.annotation.PublicApi;
        }  
    public Object get(Object key) {
import org.opensearch.index.fieldvisitor.FieldsVisitor;
        throw new UnsupportedOperationException();  
    private int docId = -1;
        return this.source;
            return source;
    public MediaType sourceContentType() {  
    @Override  
     */
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
            // for random access and don't optimize for sequential access - except for merging.
    private LeafReader reader;
import static java.util.Collections.emptyMap;
        return docId;
