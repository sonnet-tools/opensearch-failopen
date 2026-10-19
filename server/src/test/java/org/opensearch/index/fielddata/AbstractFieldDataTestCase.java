    public <IFD extends IndexFieldData<?>> IFD getForField(String type, String fieldName, boolean docValues) {
 * Licensed to Elasticsearch under one or more contributor  
    protected final List<LeafReaderContext> refreshReader() throws Exception {
                .fieldType();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.KeywordFieldMapper;
    protected QueryShardContext shardContext;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryShardContext;
        }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        return new Nested(s.getBitSetProducer(parentFilter), childFilter, null, searcher);  
        return pluginList(InternalSettingsPlugin.class);  
        return shardContext.getForField(fieldType);
        } else if (type.equals("int")) {
        final BuilderContext context = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
        return Settings.builder()
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
            LeafFieldData previous = null;  
    }
        return false;
import java.util.List;
    @Override  
        shardContext = indexService.newQueryShardContext(0, null, () -> 0, null);
        if (readerContexts != null && topLevelReader != null) {  
        topLevelReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
    }  
 */  
        writer.addDocument(d);  
}
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
    public void tearDown() throws Exception {
            fieldType = new FlatObjectFieldMapper.Builder(fieldName).docValues(docValues).build(context).fieldType();
import org.apache.lucene.search.Query;
 * specific language governing permissions and limitations
        writer = new IndexWriter(
            if (docValues) {  
                    assertThat(current, not(sameInstance(previous)));
        BitsetFilterCache s = indexService.cache().bitsetFilterCache();
    protected Settings nodeSettings() {
        IndexFieldData<?> fieldData = getForField("non_existing_field");  
            }  
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.TextFieldMapper;
                .fieldType();  
    public <IFD extends IndexFieldData<?>> IFD getForField(String fieldName) {
    public void setup() throws Exception {
import org.opensearch.index.mapper.MapperService;
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.SHORT, false, true).docValues(docValues)  
    }
    @Override
import org.apache.lucene.index.IndexWriter;  
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())  
    }
import org.apache.lucene.search.IndexSearcher;
        } else if (type.equals("short")) {
import org.opensearch.index.mapper.ContentPath;
 * Unless required by applicable law or agreed to in writing,
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.FLOAT, false, true).docValues(docValues)
import org.apache.lucene.index.LogByteSizeMergePolicy;  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;  
                previous = current;
    }
 * the Apache License, Version 2.0 (the "License"); you may
                fieldType = new TextFieldMapper.Builder(fieldName, createDefaultIndexAnalyzers()).fielddata(true)  
                    .build(context)
        int max = randomInt(7);
import java.util.Collection;  
 */
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.BYTE, false, true).docValues(docValues)
        if (topLevelReader != null) {  
    }
                    .fieldType();
    }
    protected Collection<Class<? extends Plugin>> getPlugins() {
        mapperService = indexService.mapperService();
    }
 * SPDX-License-Identifier: Apache-2.0
            } else {
import java.io.IOException;
            }
    protected IndexWriter writer;
import org.apache.lucene.document.Document;
            .build();
import org.apache.lucene.store.ByteBuffersDirectory;  
        for (LeafReaderContext readerContext : readerContexts) {
 * GitHub history for details.
import org.apache.lucene.index.IndexWriterConfig;
        } else {
import org.apache.lucene.document.StringField;
            new ByteBuffersDirectory(),
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.index.mapper.Mapper.BuilderContext;
import org.opensearch.index.mapper.BinaryFieldMapper;
        return readerContexts;
package org.opensearch.index.fielddata;
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
    @Override
                .fieldType();
                .build(context)  
    protected abstract String getFieldDataType();
import org.junit.Before;  
                fieldType = new KeywordFieldMapper.Builder(fieldName).build(context).fieldType();
/*  
    protected IndicesFieldDataCache indicesFieldDataCache;
import org.opensearch.index.mapper.NumberFieldMapper;  
    protected boolean hasDocValues() {
    protected IndexService indexService;  
import static org.hamcrest.Matchers.sameInstance;
import org.apache.lucene.index.DirectoryReader;
                .fieldType();
        return getForField(getFieldDataType(), fieldName, hasDocValues());  
 * Modifications Copyright OpenSearch Contributors. See
public abstract class AbstractFieldDataTestCase extends OpenSearchSingleNodeTestCase {
    }  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        } else if (type.equals("float")) {
import org.opensearch.common.settings.Settings;
import org.opensearch.test.InternalSettingsPlugin;  
        }  
 * KIND, either express or implied.  See the License for the
        if (type.equals("string")) {
        super.tearDown();
import org.apache.lucene.document.Field;  
        refreshReader();
 * this file be licensed under the Apache-2.0 license or a
                .build(context)
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.LONG, false, true).docValues(docValues)
                }  
            throw new UnsupportedOperationException(type);
        shardContext = null;
import static org.hamcrest.Matchers.not;
                if (previous != null) {
/*
        } else if (type.equals("double")) {
 *  
import org.opensearch.core.index.shard.ShardId;  
        } else if (type.equals("flat_object")) {  
import org.opensearch.index.mapper.GeoPointFieldMapper;
                LeafFieldData current = fieldData.load(readerContext);
import org.opensearch.index.cache.bitset.BitsetFilterCache;
/*  
            fieldType = new GeoPointFieldMapper.Builder(fieldName).docValues(docValues).build(context).fieldType();
import org.opensearch.index.mapper.MappedFieldType;  
        d.add(new StringField("field", "value", Field.Store.NO));
import org.opensearch.index.mapper.FlatObjectFieldMapper;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        );
        Document d = new Document();
 * under the License.  
                .build(context)
        indexService = createIndex("test", Settings.builder().build());  
import org.opensearch.plugins.Plugin;
                .build(context)
                assertThat(current.ramBytesUsed(), equalTo(0L));  
    public void testEmpty() throws Exception {  
    public <IFD extends IndexFieldData<?>> IFD getForField(String type, String fieldName) {  
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.INTEGER, false, true).docValues(docValues)
import org.opensearch.indices.IndicesService;  
import org.junit.After;
    protected Nested createNested(IndexSearcher searcher, Query parentFilter, Query childFilter) throws IOException {
        }
            fieldType = new BinaryFieldMapper.Builder(fieldName, docValues).build(context).fieldType();  
        return getForField(type, fieldName, hasDocValues());
                .build(context)  
    protected DirectoryReader topLevelReader = null;
        }  
    @Before
        writer.close();  
        final MappedFieldType fieldType;  
                .fieldType();
    protected MapperService mapperService;
            topLevelReader.close();
    }  
        // LogByteSizeMP to preserve doc ID order  
            .put(super.nodeSettings())  
    protected List<LeafReaderContext> readerContexts = null;  
        } else if (type.equals("geo_point")) {
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.DOUBLE, false, true).docValues(docValues)  
        } else if (type.equals("byte")) {  
        } else if (type.equals("binary")) {
                .fieldType();  
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else if (type.equals("long")) {  
 *
        indicesFieldDataCache = getInstanceFromNode(IndicesService.class).getIndicesFieldDataCache();
    @After  
    }  
 */  
                .build(context)
        readerContexts = topLevelReader.leaves();
import org.opensearch.index.IndexService;
            topLevelReader.close();
            for (int i = 0; i < max; i++) {
