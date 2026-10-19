        final AtomicInteger onCacheCalled = new AtomicInteger();
            }
                threadPool  
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)  
        writer.close();
        loadField2.close();
 */
        doc.add(new StringField("field_2", "thisisanotherstring", Store.NO));  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            indexService.mapperService(),
public class IndexFieldDataServiceTests extends OpenSearchSingleNodeTestCase {
        writer.addDocument(doc);
        final MappedFieldType stringMapper = new KeywordFieldMapper.Builder("string").build(ctx).fieldType();
        ifdService.clearField("field_1");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        reader = DirectoryReader.open(writer);
            indicesService.getCircuitBreakerService(),
        ifdService.clearField("field_2");
            .fieldType();
        final IndexFieldDataService ifdService = new IndexFieldDataService(
                }));
 *
 * this work for additional information regarding copyright
    }
        Document doc = new Document();
        IndexFieldData<?> ifd2 = ifdService.getForField(mapper2, "test", () -> { throw new UnsupportedOperationException(); });
        ThreadPool threadPool = new TestThreadPool("random_threadpool_name");  
                } else {
        );
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
import java.util.Arrays;  
            indicesService.getCircuitBreakerService(),  
        } finally {
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
            .build(ctx)  
        final IndexFieldDataService ifdService = new IndexFieldDataService(
            ifdService.clear();
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
            expectThrows(IllegalArgumentException.class, () -> ifds.setShardIdentityResolver(null));
    protected Settings nodeSettings() {  
            indexService.getIndexSettings(),
                onRemovalCalled.incrementAndGet();
        } finally {
        indicesService.getIndicesFieldDataCache().close();
        // Remove index  
            indexService.getThreadPool()
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
            @Override  
        indicesService.getIndicesFieldDataCache().close();
import org.apache.lucene.store.ByteBuffersDirectory;
        IndexFieldData<?> ifd = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });  
        IndexFieldData<?> fd = ifdService.getForField(stringMapper, "test", () -> { throw new UnsupportedOperationException(); });
            .fieldType();
                null,
import org.opensearch.threadpool.TestThreadPool;
                null,  
import java.util.function.Supplier;
        ifdService.getForField(ft, "qualified", () -> searchLookup);
import org.apache.lucene.index.IndexReader;  
        );
        // copy the ifdService since we can set the listener only once.  
            }
        );
            .fieldType();  
    public void testClosingSegmentInvalidatesEntries() throws Exception {
 *
import org.apache.lucene.document.Document;
        doc.add(new StringField("field_2", "thisisanotherstring", Store.NO));
            }
            } else {
}  
            .build(ctx)
        writer.addDocument(doc);  
/*
    }  
        fd = ifdService.getForField(doubleMapper, "test", () -> { throw new UnsupportedOperationException(); });
        });
        DirectoryReader open = DirectoryReader.open(writer);
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
                true,
            loadField.close();  
        for (LeafFieldData loadField : loadFields) {
            indexService.getThreadPool()
                Collections.emptyMap()  
import org.opensearch.test.InternalSettingsPlugin;
            indexService.getThreadPool()
        );  
        indicesService.getIndicesFieldDataCache().close();  
        writer.close();
        MappedFieldType ft = mock(MappedFieldType.class);  
import org.apache.lucene.index.IndexWriter;
        LeafFieldData loadField2 = ifd2.load(leafReaderContext);
            indicesService.getIndicesFieldDataCache(),  
 * Modifications Copyright OpenSearch Contributors. See
            new NumberFieldMapper.Builder("long", NumberFieldMapper.NumberType.LONG, false, true).build(ctx).fieldType()
        assertTrue(fd instanceof SortedSetOrdinalsIndexFieldData);
        ifdService.setListener(new IndexFieldDataCache.Listener() {
        final IndexService indexService = createIndex("test");
        writer.close();  
    public void testGetForFieldDefaults() {  
        }
                null,  
        final AtomicInteger onRemovalCalled = new AtomicInteger();  
    public void testGetForFieldRuntimeField() {
            threadPool.shutdown();  
import org.opensearch.common.SetOnce;
            indicesService.getCircuitBreakerService(),
import org.apache.lucene.document.StringField;
    }
            indexService.getIndexSettings(),  
                false,
        final AtomicInteger onRemovalCalled = new AtomicInteger();  
            if (ft.hasDocValues()) {  
        writer.addDocument(doc);
    }
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
        load.close();
import org.apache.lucene.document.Field.Store;  
        );  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {}
                cache,
import org.opensearch.index.mapper.MappedFieldType;
    }
        writer.flush();  
            .build(ctx)  
            indexService.getIndexSettings(),
        assertEquals(2, indicesService.getIndicesFieldDataCache().getCache().count());
        ThreadPool threadPool = new TestThreadPool("test_set_resolver_null");
        // copy the ifdService since we can set the listener only once.
        } catch (IllegalStateException ex) {
        LeafFieldData loadField1 = ifd1.load(leafReaderContext);  
        final IndexFieldDataService ifdService = new IndexFieldDataService(
            new NumberFieldMapper.NumberFieldType(
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));  
                Settings.EMPTY,
                    assertEquals(new ShardId("test", "_na_", 1), shardId);
import org.opensearch.indices.IndicesService;
        assertEquals(1, onCacheCalled.get());
            IndicesFieldDataCache cache = new IndicesFieldDataCache(
            indexService.mapperService(),
    }
/*  
        ifdService.setListener(new IndexFieldDataCache.Listener() {
    public void testIndexFieldDataCacheIsClearedAfterIndexRemoval() throws IOException, InterruptedException {
        final MappedFieldType mapper2 = new TextFieldMapper.Builder("field_2", createDefaultIndexAnalyzers()).fielddata(true)  
        doTestRequireDocValues(
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));  
            indexService.mapperService(),
        reader.close();  
        ifdService.clear();  
        indicesService.getIndicesFieldDataCache().close();
                }
    }  
            indexService.getThreadPool()
            indexService.getThreadPool()  
        shardPrivateService.setListener(new IndexFieldDataCache.Listener() {  
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
            indicesService.getIndicesFieldDataCache(),
                getInstanceFromNode(ClusterService.class),  
        return Settings.builder().put(super.nodeSettings()).put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1s").build();
        final AtomicInteger onCacheCalled = new AtomicInteger();
            .fieldType();
import org.opensearch.index.mapper.ContentPath;
                getInstanceFromNode(ClusterService.class),
import org.opensearch.index.IndexService;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.BooleanFieldMapper;
                "field",
        ifdService.clear();
 * specific language governing permissions and limitations
                }
        );
        waitUntil(() -> onRemovalCalled.get() == 2);
    public void testRequireDocValuesOnLongs() {
        Document doc = new Document();
            ctx
            indexService.getIndexSettings(),
        });
        doTestRequireDocValues(
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
            @Override  
        final IndexService indexService = createIndex("test");
                    throw new UnsupportedOperationException();
        );
        doc.add(new StringField("field_1", "thisisastring", Store.NO));
                false,
    }  
import org.opensearch.index.mapper.KeywordFieldMapper;  
        // now set it again and make sure we fail
                false,
            .build(ctx)
        // Ensure cache fully cleared before other tests in the suite begin
/*  
            fail("listener already set");  
        assertSame(searchLookup, searchLookupSetOnce.get().get());
        Document doc = new Document();  
            indexService.getIndexSettings(),  
        assertTrue(fd instanceof SortedNumericIndexFieldData);
import static org.mockito.Mockito.mock;
            indicesService.getIndicesFieldDataCache(),
import java.util.ArrayList;
        assertBusy(() -> assertEquals(0, indicesService.getIndicesFieldDataCache().getCache().count()));
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        }
            Supplier<SearchLookup> searchLookup = (Supplier<SearchLookup>) invocationOnMock.getArguments()[1];
    }
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
        assertTrue(fd instanceof SortedNumericIndexFieldData);  
        IndexFieldData<?> ifd2 = ifdService.getForField(mapper2, "test", () -> { throw new UnsupportedOperationException(); });
        assertEquals(0, onRemovalCalled.get());
        assertEquals(2, onCacheCalled.get());
        assertEquals(1, onCacheCalled.get());  
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.INTEGER, false, true).build(ctx).fieldType(),
        assertEquals(2, reader.getContext().leaves().size()); // Equivalent to asserting 2 segments made
                    assertNull(shardId);
            indicesService.getCircuitBreakerService(),
 * compatible open source license.
        final MappedFieldType floatMapper = new NumberFieldMapper.Builder("float", NumberFieldMapper.NumberType.FLOAT, false, true).build(  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
                false,  
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.BYTE, false, true).build(ctx).fieldType(),
                Collections.emptyMap()
        reader.close();  
            IndexFieldDataService ifds = new IndexFieldDataService(
                ifds.getForField(ft, "test", () -> { throw new UnsupportedOperationException(); }); // no exception
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        });
        // Force materialization so both hit the shared cache  
            loadFields.add(ifd.load(lrContext));  
            indicesService.getCircuitBreakerService(),
    public void testRequireDocValuesOnUnsignedLongs() {
        final IndexFieldDataService shardPrivateService = new IndexFieldDataService(
                true,
                null,
        loadField2.getBytesValues();
                null,
            }
    }
        doc1.add(new StringField("field_1", "thisisastring", Store.NO));
    }
                public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
                false,
        // Merge, assert both entries are gone after segments close
                NumberFieldMapper.NumberType.LONG,  
        try {  
    }
        doc.add(new StringField("s", "thisisastring", Store.NO));  
        reader.close();  
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG));  
import org.opensearch.index.IndexSettings;
        // copy the ifdService since we can set the listener only once.
        IndexFieldData<?> ifd1 = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });  
            IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED,  
 * license agreements. See the NOTICE file distributed with
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                }  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
            .build(ctx)
                threadPool
                onRemovalCalled.incrementAndGet();  
        assertEquals(2, indicesService.getIndicesFieldDataCache().getCache().count());  
                onCacheCalled.incrementAndGet();
        }  
        // Ensure cache fully cleared before other tests in the suite begin  
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)
        );
        ifdService.setListener(new IndexFieldDataCache.Listener() {
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
        // Ensure cache fully cleared before other tests in the suite begin  
        indicesService.removeIndex(
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            @SuppressWarnings("unchecked")  
            }  
                assertThat(e.getMessage(), containsString("doc values"));  
package org.opensearch.index.fielddata;
    public void testSetCacheListenerTwice() {
        final IndexService indexService = createIndex("test", settings);  
            searchLookupSetOnce.set(searchLookup);
        indicesService.getIndicesFieldDataCache().close();
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
                    assertEquals(new ShardId("test", "_na_", 1), shardId);  
        doTestRequireDocValues(new BooleanFieldMapper.BooleanFieldType("field", true, false, false, null, Collections.emptyMap()));  
            .build(ctx)  
            );
            new NumberFieldMapper.NumberFieldType(  
        final IndexService indexService = createIndex("test");
            IndicesFieldDataCache cache = new IndicesFieldDataCache(  
        waitUntil(() -> onRemovalCalled.get() == 1);  
        ).fieldType();
        loadField1.close();
        ifdService.clear();
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {}
            "Please delete!"
                }
                } else {  
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                false,
            @Override
        LeafFieldData load = ifd.load(leafReaderContext);  
            fd = ifdService.getForField(mapper, "test", () -> { throw new UnsupportedOperationException(); });
            indicesService.getCircuitBreakerService(),
                if (wrap) {
import java.util.concurrent.atomic.AtomicInteger;
import static org.hamcrest.Matchers.containsString;  
import java.util.Collections;
        final int shardId = randomInt();
            assertEquals(searchLookup.get().shardId(), shardId);  
            threadPool.shutdown();  
        when(ft.fielddataBuilder(Mockito.any(), Mockito.any())).thenAnswer(invocationOnMock -> {
 */  
        final boolean wrap = randomBoolean();  
        final SetOnce<Supplier<SearchLookup>> searchLookupSetOnce = new SetOnce<>();
            shardPrivateService.setListener(new IndexFieldDataCache.Listener() {
            new NumberFieldMapper.NumberFieldType(
        doc2.add(new StringField("field_1", "stringstring", Store.NO));
    public void testSetShardIdentityResolverRejectsNull() {  
import org.apache.lucene.index.IndexWriterConfig;
 * You may obtain a copy of the License at  
        IndexReader reader = DirectoryReader.open(writer);
                true,  
        IndexFieldData<?> ifd1 = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });  
 *  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        final IndexFieldDataService ifdService = new IndexFieldDataService(  
    public void testRequireDocValuesOnBools() {
    }  
            .fieldType();
                IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ifds.getForField(ft, "test", () -> {  
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
                null,
            }
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
        SearchLookup searchLookup = new SearchLookup(null, null, shardId);  
        fd = ifdService.getForField(floatMapper, "test", () -> { throw new UnsupportedOperationException(); });
import java.io.IOException;
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("s", createDefaultIndexAnalyzers()).fielddata(true)
            .fieldType();  
                false,  
import org.opensearch.common.settings.Settings;  
                false,
import org.opensearch.index.mapper.Mapper.BuilderContext;
                NumberFieldMapper.NumberType.DOUBLE,
            indicesService.getIndicesFieldDataCache(),  
import org.opensearch.common.unit.TimeValue;
        final MappedFieldType mapper2 = new TextFieldMapper.Builder("field_2", createDefaultIndexAnalyzers()).fielddata(true)
            indexService.mapperService(),
        // Ensure cache fully cleared before other tests in the suite begin
            )  
        writer.close();  
            indicesService.getIndicesFieldDataCache(),
    public void testClearField() throws Exception {
        loadField1.getBytesValues();
            .build(ctx)
import org.mockito.Mockito;
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        // Ensure cache fully cleared before other tests in the suite begin  
        for (LeafReaderContext lrContext : reader.getContext().leaves()) {
        });  
 */  
                false,  
            // all well
                IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
 * software distributed under the License is distributed on an
                null,
import org.apache.lucene.util.Accountable;
        ifdService.clear();  
 * this file be licensed under the Apache-2.0 license or a
        LeafFieldData loadField1 = ifd1.load(leafReaderContext);  
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG));
                "field",  
import org.opensearch.indices.cluster.IndicesClusterStateService;  
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.SHORT, false, true).build(ctx).fieldType(),  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
            )
        writer.forceMerge(1);  
        );
            assertTrue(fd instanceof SortedNumericIndexFieldData);  
        final IndexFieldDataService ifdService = new IndexFieldDataService(  
        assertEquals(2, onCacheCalled.get());
                @Override
 * The OpenSearch Contributors require contributions made to  
        final IndexService indexService = createIndex("test");
import static org.mockito.Mockito.when;
                if (wrap) {
        final AtomicInteger onRemovalCalled = new AtomicInteger();
                public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        List<LeafFieldData> loadFields = new ArrayList<>();
 * not use this file except in compliance with the License.
            IndexFieldDataService ifds = new IndexFieldDataService(  
                    assertNull(shardId);
            .fieldType();
        final IndexReader reader = DirectoryReader.open(writer);
import org.opensearch.plugins.Plugin;
            indexService.mapperService(),  
import org.apache.lucene.index.DirectoryReader;
        doTestRequireDocValues(  
            indexService.mapperService(),  
        waitUntil(() -> indicesService.getIndicesFieldDataCache().getCache().count() == 0);
        );
            indexService.mapperService(),
    @Override
    public void testRequireDocValuesOnDoubles() {  
        ifdService.clear();
        final AtomicInteger onCacheCalled = new AtomicInteger();  
        waitUntil(() -> onRemovalCalled.get() == 1);
            indexService.index(),
    }
 * ownership. Elasticsearch licenses this file to you under  
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)
            @Override  
            }
        IndexFieldData<?> ifd = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });
        indicesService.getIndicesFieldDataCache().close();
import org.opensearch.index.mapper.NumberFieldMapper;  
                null,  
            @Override  
        assertEquals(2, onCacheCalled.get());  
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));  
                NumberFieldMapper.NumberType.UNSIGNED_LONG,
    public void testFieldDataCacheListener() throws Exception {  
        )) {  
                threadPool
        }
 * Unless required by applicable law or agreed to in writing,
                false,
        indicesService.getIndicesFieldDataCache().close();
        final IndexService indexService = createIndex("test");
import org.opensearch.test.IndexSettingsModule;
                cache,
 * KIND, either express or implied.  See the License for the
        writer.addDocument(doc2);
import org.opensearch.threadpool.ThreadPool;
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.core.index.shard.ShardId;
            );  
        );  
        }
        final MappedFieldType doubleMapper = new NumberFieldMapper.Builder("double", NumberFieldMapper.NumberType.DOUBLE, false, true)
    }
        });
        Document doc1 = new Document();
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
        assertBusy(() -> assertEquals(1, onRemovalCalled.get()));
import org.opensearch.cluster.service.ClusterService;  
 * under the License.  
                IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),  
        reader.close();
            indexService.getThreadPool()  
        assertEquals(0, onRemovalCalled.get());
        loadField2.close();
        // Close and reopen reader so changes are visible, this calls onClosed() hook invalidating key
            indicesService.getIndicesFieldDataCache(),
                Collections.emptyMap()
 * GitHub history for details.
        Settings settings = Settings.builder()  
            indicesService.getIndicesFieldDataCache(),  
import org.opensearch.search.lookup.SearchLookup;  
        loadField1.close();
        writer.addDocument(doc1);  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
            });
            @Override
        for (MappedFieldType mapper : Arrays.asList(
            indexService.getIndexSettings(),
        doc.add(new StringField("field_1", "thisisastring", Store.NO));
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
        LeafFieldData loadField2 = ifd2.load(leafReaderContext);
                null,
        final IndexFieldDataService ifdService = new IndexFieldDataService(
        assertEquals(2, onCacheCalled.get());  
            return (IndexFieldData.Builder) (cache, breakerService) -> null;
                threadPool
                onCacheCalled.incrementAndGet();  
        try {
        ifdService.clearField("field_1");  
    @Override
                Settings.EMPTY,  
        reader.close();  
        final IndexReader reader = DirectoryReader.open(writer);
        // set it the first time...
import org.opensearch.index.mapper.TextFieldMapper;
        return pluginList(InternalSettingsPlugin.class);  
import org.apache.lucene.index.LeafReaderContext;  
                "field",
            )
            indexService.getThreadPool()  
            indexService.getIndexSettings(),
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collection;
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE));
        // Ensure cache fully cleared before other tests in the suite begin
        try {
            @Override
        final IndexService indexService = createIndex("test");  
                false,
    private void doTestRequireDocValues(MappedFieldType ft) {
            );
        final IndexReader reader = wrap ? OpenSearchDirectoryReader.wrap(open, new ShardId("test", "_na_", 1)) : open;
            indicesService.getCircuitBreakerService(),  
        Document doc2 = new Document();  
        writer.flush();
        }
        doTestRequireDocValues(new BooleanFieldMapper.BooleanFieldType("field"));
        // Ensure cache fully cleared before other tests in the suite begin
                false,  
                @Override
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
