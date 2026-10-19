    public Object remove(Object key) {
    public int docId() {
            return;
    private CheckedBiConsumer<Integer, FieldsVisitor, IOException> fieldReader;
    private Map<String, Object> source;
        try {
    public Object filter(FetchSourceContext context) {
import org.opensearch.OpenSearchParseException;
     * @return the value associated with the path in the source or 'null' if the path does not exist.
     * For the provided path, return its value in the source.
 * SPDX-License-Identifier: Apache-2.0
        if (sourceAsBytes != null) {
import org.opensearch.common.collect.Tuple;
    @Override
 * @opensearch.api
     *                  in distinguishing between a path that doesn't exist vs. a value of 'null'.
            if (source == null) {
    }
        return loadSourceIfNeeded().containsKey(key);
    private MediaType sourceContentType;
import org.opensearch.common.annotation.PublicApi;
            // if we are called with the same document, don't invalidate source
/**
import org.opensearch.common.Nullable;
 * Orchestrator class for source lookups. Not thread safe.
    @Override
        return XContentMapValues.extractValue(path, loadSourceIfNeeded(), nullValue);
        throw new UnsupportedOperationException();
    }
}
import org.opensearch.common.xcontent.XContentHelper;
    }
                this.source = tuple.v2();
public class SourceLookup implements Map {
        return loadSourceIfNeeded().entrySet();
 * You may obtain a copy of the License at
    // as a determination if source is enabled/disabled, but it should
        } catch (Exception e) {
    private static Tuple<XContentType, Map<String, Object>> sourceAsMapAndType(BytesReference source) throws OpenSearchParseException {
    public void setSourceContentType(MediaType sourceContentType) {
 * GitHub history for details.
            return source;
                    fieldReader = lf.getSequentialStoredFieldsReader()::document;
     * <p>
                } else {
        }
import org.opensearch.core.common.bytes.BytesReference;
/*
        return loadSourceIfNeeded().size();
            }
import org.opensearch.common.CheckedBiConsumer;
     */
    @Override
        return this.source;
    public boolean isEmpty() {
        return XContentMapValues.extractRawValues(path, loadSourceIfNeeded());
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            FieldsVisitor sourceFieldVisitor = new FieldsVisitor(true);
     *
    public MediaType sourceContentType() {
        return sourceAsBytes;
import org.apache.lucene.index.LeafReader;
        return loadSourceIfNeeded().containsValue(value);
    @Override
    private LeafReader reader;
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns the values associated with the path. Those are "low" level values, and it can
            BytesReference source = sourceFieldVisitor.source();
 */
    public Set keySet() {
    }
 * license agreements. See the NOTICE file distributed with
    // Scripting requires this method to be public. Using source()
        return context.getFilter().apply(loadSourceIfNeeded());
            throw new OpenSearchParseException("failed to parse / load source", e);
 * KIND, either express or implied.  See the License for the
                this.source = emptyMap();
    @Override
    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        this.sourceAsBytes = null;
    private int docId = -1;
@PublicApi(since = "1.0.0")
        throw new UnsupportedOperationException();
    }
 * not use this file except in compliance with the License.
    public void setSource(BytesReference source) {
            // Lazily initialize fieldReader in loadSourceIfNeeded() to avoid
     * @param nullValue a value to return if the path exists, but the value is 'null'. This helps
    public void clear() {
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
     *
    @Override
 * software distributed under the License is distributed on an
 */
    }
 * this work for additional information regarding copyright
        this.sourceContentType = sourceContentType;
        return loadSourceIfNeeded().get(key);
    public Object put(Object key, Object value) {
            this.reader = context.reader();
        }
            sourceContentType = tuple.v1();
package org.opensearch.search.lookup;
 *
    public Set entrySet() {
    public Object get(Object key) {
        return source;
        }
    public boolean containsKey(Object key) {
import java.io.IOException;
    }
            // All the docs to fetch are adjacent but Lucene stored fields are optimized
    public static Map<String, Object> sourceAsMap(BytesReference source) throws OpenSearchParseException {
    @Override
    }
                }
        return sourceAsMapAndType(source).v2();
        return loadSourceIfNeeded().isEmpty();
                    fieldReader = reader.storedFields()::document;
        if (source != null) {
    @Override
        if (this.reader != context.reader()) {
    public Collection values() {
    private BytesReference sourceAsBytes;
    }
        }
        this.docId = docId;
    }
    }
    }
    public Object extractValue(String path, @Nullable Object nullValue) {
    }
    /**
            // So we do a little hack here and pretend we're going to do merges in order to
 *
     * Note that in contrast with {@link SourceLookup#extractRawValues}, array and object values
    @Override
                Tuple<XContentType, Map<String, Object>> tuple = sourceAsMapAndType(source);
 */
     * handle path expression where an array/list is navigated within.
            } else {
    }
    }
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
            fieldReader.accept(docId, sourceFieldVisitor);
    @Override
    /**
import static java.util.Collections.emptyMap;
            this.fieldReader = null;
        throw new UnsupportedOperationException();
        throw new UnsupportedOperationException();
import java.util.Set;
import org.opensearch.core.xcontent.MediaType;
            if (fieldReader == null) {
        this.source = null;
        this.sourceAsBytes = source;
    }
    public int size() {
    public Map<String, Object> loadSourceIfNeeded() {
    public void setSegmentAndDocument(LeafReaderContext context, int docId) {
 * specific language governing permissions and limitations
import java.util.Collection;
    public Map<String, Object> source() {
        return loadSourceIfNeeded().keySet();
            Tuple<XContentType, Map<String, Object>> tuple = sourceAsMapAndType(sourceAsBytes);
    public BytesReference internalSourceRef() {
        return loadSourceIfNeeded().values();
    /**
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
        return sourceContentType;
    }
            source = tuple.v2();
    }
            // get better sequential access.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        return docId;
                this.sourceContentType = tuple.v1();
    }
            // unnecessary work when _source is never accessed.
    public boolean containsValue(Object value) {
    }
        }
            // Lazily initialize fieldReader on first _source access.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * Internal source representation, might be compressed....
/*
import org.opensearch.index.fieldvisitor.FieldsVisitor;
import org.opensearch.common.xcontent.support.XContentMapValues;
import java.util.List;
     */
import org.opensearch.common.xcontent.XContentType;
     * @param path the value's path in the source.
 * Unless required by applicable law or agreed to in writing,
                if (reader instanceof SequentialStoredFieldsLeafReader lf) {
import java.util.Map;
     */
 * Modifications Copyright OpenSearch Contributors. See
    }
    @Override
        if (this.reader == context.reader() && this.docId == docId) {
    public void setSource(Map<String, Object> source) {
            }
            return source;
    }
                this.sourceContentType = null;
     * can be returned.
    public void putAll(Map m) {
 */
import org.apache.lucene.index.LeafReaderContext;
 * The OpenSearch Contributors require contributions made to
    public List<Object> extractRawValues(String path) {
        return XContentHelper.convertToMap(source, false);
            // for random access and don't optimize for sequential access - except for merging.
 *
    // is not possible because certain checks use source == null as
    // never be a null Map for scripting even when disabled.
/*
        this.source = source;
