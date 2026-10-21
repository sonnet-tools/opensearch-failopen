    }
    public <IFD extends IndexFieldData<?>> IFD getForField(String fieldName) {
    }
        return getForField(type, fieldName, hasDocValues());
            topLevelReader.close();
    protected DirectoryReader topLevelReader = null;
                    assertThat(current, not(sameInstance(previous)));
/*
import org.opensearch.plugins.Plugin;
 * GitHub history for details.
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.BYTE, false, true).docValues(docValues)
            if (docValues) {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        return false;
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.DOUBLE, false, true).docValues(docValues)
 * compatible open source license.
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
 * under the License.
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    protected MapperService mapperService;
        }
/*
                .fieldType();
        } else if (type.equals("long")) {
        } else if (type.equals("short")) {
    public void setup() throws Exception {
    protected Nested createNested(IndexSearcher searcher, Query parentFilter, Query childFilter) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
        }
                .build(context)
        } else if (type.equals("double")) {
import org.opensearch.index.mapper.ContentPath;
            new ByteBuffersDirectory(),
import org.opensearch.common.settings.Settings;
    public void testEmpty() throws Exception {
import org.opensearch.indices.IndicesService;
import org.opensearch.index.mapper.Mapper.BuilderContext;
            LeafFieldData previous = null;
 */
        );
import org.apache.lucene.index.DirectoryReader;
 * KIND, either express or implied.  See the License for the
            fieldType = new GeoPointFieldMapper.Builder(fieldName).docValues(docValues).build(context).fieldType();
        if (topLevelReader != null) {
        }
        } else if (type.equals("flat_object")) {
import org.opensearch.index.mapper.TextFieldMapper;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.IndexWriter;
 * Licensed to Elasticsearch under one or more contributor
        } else if (type.equals("int")) {
        BitsetFilterCache s = indexService.cache().bitsetFilterCache();
import org.apache.lucene.store.ByteBuffersDirectory;
        int max = randomInt(7);
        d.add(new StringField("field", "value", Field.Store.NO));
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
                .build(context)
import org.opensearch.index.IndexService;
    protected boolean hasDocValues() {
import java.io.IOException;
        indexService = createIndex("test", Settings.builder().build());
 * ownership. Elasticsearch licenses this file to you under
        return getForField(getFieldDataType(), fieldName, hasDocValues());
    }
        return shardContext.getForField(fieldType);
        readerContexts = topLevelReader.leaves();
                .fieldType();
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
    protected Collection<Class<? extends Plugin>> getPlugins() {
        final MappedFieldType fieldType;
        }
    }
import org.opensearch.index.mapper.MapperService;
                .fieldType();
                if (previous != null) {
    @Before
                previous = current;
    protected abstract String getFieldDataType();
 */
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        if (type.equals("string")) {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.apache.lucene.search.IndexSearcher;
 * You may obtain a copy of the License at
        IndexFieldData<?> fieldData = getForField("non_existing_field");
import org.opensearch.test.InternalSettingsPlugin;
 * this file be licensed under the Apache-2.0 license or a
            fieldType = new BinaryFieldMapper.Builder(fieldName, docValues).build(context).fieldType();
                fieldType = new KeywordFieldMapper.Builder(fieldName).build(context).fieldType();
        refreshReader();
                .build(context)
            fieldType = new FlatObjectFieldMapper.Builder(fieldName).docValues(docValues).build(context).fieldType();
        if (readerContexts != null && topLevelReader != null) {
        writer.close();
 * license agreements. See the NOTICE file distributed with
public abstract class AbstractFieldDataTestCase extends OpenSearchSingleNodeTestCase {
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.SHORT, false, true).docValues(docValues)
                fieldType = new TextFieldMapper.Builder(fieldName, createDefaultIndexAnalyzers()).fielddata(true)
    }
    @Override
    protected Settings nodeSettings() {
        } else {
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriterConfig;
    protected QueryShardContext shardContext;
import org.apache.lucene.document.StringField;
import static org.hamcrest.Matchers.sameInstance;
            for (int i = 0; i < max; i++) {
import org.opensearch.index.mapper.FlatObjectFieldMapper;
            .build();
                    .build(context)
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.INTEGER, false, true).docValues(docValues)
                .fieldType();
 *
import java.util.Collection;
        shardContext = null;
        return readerContexts;
            .put(super.nodeSettings())
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    }
        super.tearDown();
import static org.hamcrest.Matchers.not;
            }
                .fieldType();
                    .fieldType();
    }
        } else if (type.equals("byte")) {
    protected final List<LeafReaderContext> refreshReader() throws Exception {
 * specific language governing permissions and limitations
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 *
    protected IndicesFieldDataCache indicesFieldDataCache;
import org.opensearch.index.mapper.KeywordFieldMapper;
            }
import org.apache.lucene.index.LeafReaderContext;
        topLevelReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
    public <IFD extends IndexFieldData<?>> IFD getForField(String type, String fieldName, boolean docValues) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */
                .build(context)
                }
        shardContext = indexService.newQueryShardContext(0, null, () -> 0, null);
    }
        indicesFieldDataCache = getInstanceFromNode(IndicesService.class).getIndicesFieldDataCache();
            throw new UnsupportedOperationException(type);
        } else if (type.equals("geo_point")) {
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.BinaryFieldMapper;
import static org.hamcrest.Matchers.equalTo;
    @Override
        final BuilderContext context = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
import org.junit.After;
    protected IndexWriter writer;
        for (LeafReaderContext readerContext : readerContexts) {
}
import org.opensearch.index.mapper.GeoPointFieldMapper;
    public <IFD extends IndexFieldData<?>> IFD getForField(String type, String fieldName) {
    @Override
    }
    }
        return pluginList(InternalSettingsPlugin.class);
import org.junit.Before;
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.LONG, false, true).docValues(docValues)
        return new Nested(s.getBitSetProducer(parentFilter), childFilter, null, searcher);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        mapperService = indexService.mapperService();
    protected IndexService indexService;
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            } else {
import org.apache.lucene.document.Document;
                assertThat(current.ramBytesUsed(), equalTo(0L));
import org.apache.lucene.index.LogByteSizeMergePolicy;
/*
 * The OpenSearch Contributors require contributions made to
    public void tearDown() throws Exception {
import org.opensearch.core.index.shard.ShardId;
    @After
            fieldType = new NumberFieldMapper.Builder(fieldName, NumberFieldMapper.NumberType.FLOAT, false, true).docValues(docValues)
        return Settings.builder()
        writer = new IndexWriter(
    }
                LeafFieldData current = fieldData.load(readerContext);
    protected List<LeafReaderContext> readerContexts = null;
import java.util.List;
        } else if (type.equals("binary")) {
        Document d = new Document();
            topLevelReader.close();
                .build(context)
                .fieldType();
                .build(context)
        // LogByteSizeMP to preserve doc ID order
        } else if (type.equals("float")) {
 * software distributed under the License is distributed on an
        writer.addDocument(d);
import org.apache.lucene.search.Query;
package org.opensearch.index.fielddata;
