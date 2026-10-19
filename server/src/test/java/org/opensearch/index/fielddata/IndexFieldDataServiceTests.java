import org.apache.lucene.index.IndexReader;
            IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED,
                threadPool
            indexService.mapperService(),
        loadField2.close();
            indicesService.getIndicesFieldDataCache(),
        waitUntil(() -> onRemovalCalled.get() == 2);
 */
        final AtomicInteger onRemovalCalled = new AtomicInteger();
        assertSame(searchLookup, searchLookupSetOnce.get().get());
 */
            );
import org.opensearch.common.SetOnce;
                null,
        fd = ifdService.getForField(floatMapper, "test", () -> { throw new UnsupportedOperationException(); });
        // copy the ifdService since we can set the listener only once.
    public void testRequireDocValuesOnLongs() {
import org.apache.lucene.util.Accountable;
            }
            @Override
import java.util.concurrent.atomic.AtomicInteger;
        // Ensure cache fully cleared before other tests in the suite begin
        assertEquals(1, onCacheCalled.get());
        );
        final MappedFieldType mapper2 = new TextFieldMapper.Builder("field_2", createDefaultIndexAnalyzers()).fielddata(true)
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            );
        doc.add(new StringField("field_2", "thisisanotherstring", Store.NO));
            );
                } else {
                onCacheCalled.incrementAndGet();
        indicesService.getIndicesFieldDataCache().close();
        doc.add(new StringField("s", "thisisastring", Store.NO));
                onRemovalCalled.incrementAndGet();
                Collections.emptyMap()
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.index.LeafReaderContext;
            indicesService.getCircuitBreakerService(),
        indicesService.getIndicesFieldDataCache().close();
            @Override
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
                }
    public void testSetCacheListenerTwice() {
        final AtomicInteger onCacheCalled = new AtomicInteger();
import java.util.Arrays;
                IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        // Ensure cache fully cleared before other tests in the suite begin
        writer.addDocument(doc2);
                false,
            .fieldType();
        }
        assertEquals(2, reader.getContext().leaves().size()); // Equivalent to asserting 2 segments made
        );
        final IndexFieldDataService shardPrivateService = new IndexFieldDataService(
        loadField2.getBytesValues();
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(fd instanceof SortedNumericIndexFieldData);
import java.util.List;
        Document doc2 = new Document();
        writer.close();
        try {
        for (LeafFieldData loadField : loadFields) {
            expectThrows(IllegalArgumentException.class, () -> ifds.setShardIdentityResolver(null));
            Supplier<SearchLookup> searchLookup = (Supplier<SearchLookup>) invocationOnMock.getArguments()[1];
            assertTrue(fd instanceof SortedNumericIndexFieldData);
                null,
                false,
        MappedFieldType ft = mock(MappedFieldType.class);
        final IndexFieldDataService ifdService = new IndexFieldDataService(
        writer.addDocument(doc);
            indexService.mapperService(),
            indexService.mapperService(),
import org.apache.lucene.index.DirectoryReader;
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)
        ifdService.clear();
        assertEquals(0, onRemovalCalled.get());
            indicesService.getCircuitBreakerService(),
            .fieldType();
        doTestRequireDocValues(
        List<LeafFieldData> loadFields = new ArrayList<>();
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)
        );
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
                cache,
        indicesService.removeIndex(
            new NumberFieldMapper.NumberFieldType(
        assertEquals(0, onRemovalCalled.get());
import org.apache.lucene.index.IndexWriterConfig;
            "Please delete!"
    }
                false,
        Document doc = new Document();
        writer.addDocument(doc1);
        final IndexService indexService = createIndex("test", settings);
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
    }
        IndexFieldData<?> ifd2 = ifdService.getForField(mapper2, "test", () -> { throw new UnsupportedOperationException(); });
            }
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
import org.opensearch.index.IndexService;
                Settings.EMPTY,
                public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        doTestRequireDocValues(new BooleanFieldMapper.BooleanFieldType("field"));
        indicesService.getIndicesFieldDataCache().close();
        loadField1.getBytesValues();
        indicesService.getIndicesFieldDataCache().close();
            indicesService.getIndicesFieldDataCache(),
                    throw new UnsupportedOperationException();
        final IndexService indexService = createIndex("test");
    }
        IndexReader reader = DirectoryReader.open(writer);
        doTestRequireDocValues(new BooleanFieldMapper.BooleanFieldType("field", true, false, false, null, Collections.emptyMap()));
        reader = DirectoryReader.open(writer);
            )
 * under the License.
        final IndexService indexService = createIndex("test");
        reader.close();
import org.apache.lucene.store.ByteBuffersDirectory;
                if (wrap) {
        assertTrue(fd instanceof SortedSetOrdinalsIndexFieldData);
    }
        ifdService.clearField("field_2");
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
 */
                threadPool
                null,
            // all well
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
            )
        final MappedFieldType floatMapper = new NumberFieldMapper.Builder("float", NumberFieldMapper.NumberType.FLOAT, false, true).build(
                false,
        // Merge, assert both entries are gone after segments close
        } finally {
        reader.close();
        final AtomicInteger onRemovalCalled = new AtomicInteger();
        LeafFieldData loadField2 = ifd2.load(leafReaderContext);
            fd = ifdService.getForField(mapper, "test", () -> { throw new UnsupportedOperationException(); });
                assertThat(e.getMessage(), containsString("doc values"));
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG));
        try {
                Collections.emptyMap()
            .build(ctx)
        // copy the ifdService since we can set the listener only once.
            )
        doc2.add(new StringField("field_1", "stringstring", Store.NO));
            }
        SearchLookup searchLookup = new SearchLookup(null, null, shardId);
 * Licensed to Elasticsearch under one or more contributor
    }
            .fieldType();
                }
            indexService.getIndexSettings(),
        }
        ThreadPool threadPool = new TestThreadPool("test_set_resolver_null");
        ifdService.clearField("field_1");
        writer.addDocument(doc);
    public void testClearField() throws Exception {
                false,
                null,
        // Ensure cache fully cleared before other tests in the suite begin
            .build(ctx)
import org.opensearch.index.mapper.BooleanFieldMapper;
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
            indexService.mapperService(),
            fail("listener already set");
        loadField2.close();
        indicesService.getIndicesFieldDataCache().close();
        // Close and reopen reader so changes are visible, this calls onClosed() hook invalidating key
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
        });
    public void testGetForFieldDefaults() {
        ThreadPool threadPool = new TestThreadPool("random_threadpool_name");
        IndexFieldData<?> ifd1 = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });
            }
import org.opensearch.common.unit.TimeValue;
        }
            indexService.getThreadPool()
            indexService.getThreadPool()
        writer.flush();
        reader.close();
        writer.close();
        )) {
                threadPool
                IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ifds.getForField(ft, "test", () -> {
        when(ft.fielddataBuilder(Mockito.any(), Mockito.any())).thenAnswer(invocationOnMock -> {
            indexService.getIndexSettings(),
            indicesService.getIndicesFieldDataCache(),
 * software distributed under the License is distributed on an
 *
        shardPrivateService.setListener(new IndexFieldDataCache.Listener() {
            indexService.getThreadPool()
        LeafReaderContext leafReaderContext = reader.getContext().leaves().get(0);
import org.opensearch.indices.cluster.IndicesClusterStateService;
import java.io.IOException;
                false,
        ifdService.getForField(ft, "qualified", () -> searchLookup);
import org.mockito.Mockito;
        assertEquals(2, onCacheCalled.get());
            indexService.getThreadPool()
import org.opensearch.index.mapper.Mapper.BuilderContext;
        // copy the ifdService since we can set the listener only once.
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertBusy(() -> assertEquals(1, onRemovalCalled.get()));
            indexService.getThreadPool()
                    assertEquals(new ShardId("test", "_na_", 1), shardId);
import java.util.Collections;
            if (ft.hasDocValues()) {
                cache,
                    assertNull(shardId);
        writer.forceMerge(1);
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("field_1", createDefaultIndexAnalyzers()).fielddata(true)
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        final MappedFieldType mapper2 = new TextFieldMapper.Builder("field_2", createDefaultIndexAnalyzers()).fielddata(true)
            indicesService.getIndicesFieldDataCache(),
        assertTrue(fd instanceof SortedNumericIndexFieldData);
            }
        Document doc = new Document();
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            .build(ctx)
import org.opensearch.index.mapper.TextFieldMapper;
        IndexFieldData<?> ifd = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });
                if (wrap) {
        assertEquals(2, indicesService.getIndicesFieldDataCache().getCache().count());
            assertEquals(searchLookup.get().shardId(), shardId);
import org.opensearch.indices.IndicesService;
            .fieldType();
        }
        LeafFieldData loadField1 = ifd1.load(leafReaderContext);
        // now set it again and make sure we fail
        ifdService.clear();
        for (MappedFieldType mapper : Arrays.asList(
    }
        final IndexReader reader = wrap ? OpenSearchDirectoryReader.wrap(open, new ShardId("test", "_na_", 1)) : open;
                null,
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.SHORT, false, true).build(ctx).fieldType(),
            indicesService.getIndicesFieldDataCache(),
        final IndexFieldDataService ifdService = new IndexFieldDataService(
        );
                }
        final IndexFieldDataService ifdService = new IndexFieldDataService(
            threadPool.shutdown();
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
        writer.addDocument(doc);
            indexService.mapperService(),
                null,
                ifds.getForField(ft, "test", () -> { throw new UnsupportedOperationException(); }); // no exception
        );
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.BYTE, false, true).build(ctx).fieldType(),
            indexService.getThreadPool()
                @Override
 * KIND, either express or implied.  See the License for the
                }
        waitUntil(() -> onRemovalCalled.get() == 1);
 * the Apache License, Version 2.0 (the "License"); you may
        ).fieldType();
import java.util.function.Supplier;
                "field",
        try {
            @Override
                true,
import org.opensearch.index.mapper.ContentPath;
            new NumberFieldMapper.NumberFieldType(
        reader.close();
            );
        ifdService.clear();
            @Override
                false,
        }
                false,
        // Ensure cache fully cleared before other tests in the suite begin
            indexService.mapperService(),
            indicesService.getCircuitBreakerService(),
import static org.mockito.Mockito.mock;
        DirectoryReader open = DirectoryReader.open(writer);
 *
                false,
            indexService.getIndexSettings(),
        final IndexService indexService = createIndex("test");
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
            ifdService.clear();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
/*
    protected Settings nodeSettings() {
        IndexFieldData<?> fd = ifdService.getForField(stringMapper, "test", () -> { throw new UnsupportedOperationException(); });
        Document doc = new Document();
import org.apache.lucene.document.Document;
        doTestRequireDocValues(
                IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            indexService.getThreadPool()
 * You may obtain a copy of the License at
                getInstanceFromNode(ClusterService.class),
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
            @SuppressWarnings("unchecked")
        assertEquals(2, onCacheCalled.get());
            @Override
        } catch (IllegalStateException ex) {
                @Override
        indicesService.getIndicesFieldDataCache().close();
    public void testSetShardIdentityResolverRejectsNull() {
    }
        });
        final IndexFieldDataService ifdService = new IndexFieldDataService(
    public void testClosingSegmentInvalidatesEntries() throws Exception {
        // Force materialization so both hit the shared cache
 * not use this file except in compliance with the License.
        ifdService.setListener(new IndexFieldDataCache.Listener() {
            indexService.mapperService(),
                    assertNull(shardId);
                Settings.EMPTY,
        writer.flush();
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
            .fieldType();
        writer.close();
 * The OpenSearch Contributors require contributions made to
            IndexFieldDataService ifds = new IndexFieldDataService(
        indicesService.getIndicesFieldDataCache().close();
import org.opensearch.index.mapper.NumberFieldMapper;
        ifdService.setListener(new IndexFieldDataCache.Listener() {
import org.opensearch.core.index.shard.ShardId;
        final IndexFieldDataService ifdService = new IndexFieldDataService(
        final AtomicInteger onCacheCalled = new AtomicInteger();
    @Override
        final IndexService indexService = createIndex("test");
        // Ensure cache fully cleared before other tests in the suite begin
        writer.close();
                onCacheCalled.incrementAndGet();
            }
        );
        final SetOnce<Supplier<SearchLookup>> searchLookupSetOnce = new SetOnce<>();
import org.opensearch.threadpool.ThreadPool;
        Document doc1 = new Document();
            indicesService.getCircuitBreakerService(),
import java.util.ArrayList;
            @Override
        final MappedFieldType doubleMapper = new NumberFieldMapper.Builder("double", NumberFieldMapper.NumberType.DOUBLE, false, true)
    }
            .fieldType();
        return Settings.builder().put(super.nodeSettings()).put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1s").build();
 * GitHub history for details.
        for (LeafReaderContext lrContext : reader.getContext().leaves()) {
            indicesService.getCircuitBreakerService(),
            loadField.close();
        waitUntil(() -> indicesService.getIndicesFieldDataCache().getCache().count() == 0);
        assertEquals(2, onCacheCalled.get());
        ifdService.clear();
                null,
import org.apache.lucene.document.StringField;
                onRemovalCalled.incrementAndGet();
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {}
import org.opensearch.common.settings.Settings;
            indexService.getIndexSettings(),
            .fieldType();
import org.apache.lucene.document.Field.Store;
package org.opensearch.index.fielddata;
    @Override
    public void testFieldDataCacheListener() throws Exception {
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
 * license agreements. See the NOTICE file distributed with
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        Settings settings = Settings.builder()
                true,
import org.opensearch.index.mapper.KeywordFieldMapper;
        // Ensure cache fully cleared before other tests in the suite begin
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
        assertEquals(1, onCacheCalled.get());
                false,
        final IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(new KeywordAnalyzer()));
import org.opensearch.index.IndexSettings;
import org.opensearch.plugins.Plugin;
        doc1.add(new StringField("field_1", "thisisastring", Store.NO));
        return pluginList(InternalSettingsPlugin.class);
                } else {
    public void testGetForFieldRuntimeField() {
        ifdService.setListener(new IndexFieldDataCache.Listener() {
        IndexFieldData<?> ifd1 = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });
        final AtomicInteger onRemovalCalled = new AtomicInteger();
        final IndexService indexService = createIndex("test");
/*
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
            indicesService.getCircuitBreakerService(),
    }
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG));
            indexService.index(),
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {}
        );
                getInstanceFromNode(ClusterService.class),
            @Override
            });
        loadField1.close();
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
                null,
        fd = ifdService.getForField(doubleMapper, "test", () -> { throw new UnsupportedOperationException(); });
            @Override
        );
            .build(ctx)
        load.close();
            indicesService.getIndicesFieldDataCache(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Collections.emptyMap()
        // Remove index
 * SPDX-License-Identifier: Apache-2.0
            loadFields.add(ifd.load(lrContext));
            new NumberFieldMapper.NumberFieldType(
            .build();
        });
            new NumberFieldMapper.Builder("long", NumberFieldMapper.NumberType.LONG, false, true).build(ctx).fieldType()
        LeafFieldData loadField1 = ifd1.load(leafReaderContext);
    protected Collection<Class<? extends Plugin>> getPlugins() {
        });
                false,
        doc.add(new StringField("field_2", "thisisanotherstring", Store.NO));
import static org.hamcrest.Matchers.containsString;
        final MappedFieldType stringMapper = new KeywordFieldMapper.Builder("string").build(ctx).fieldType();
import org.opensearch.index.mapper.MappedFieldType;
        // Ensure cache fully cleared before other tests in the suite begin
        doc.add(new StringField("field_1", "thisisastring", Store.NO));
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                null,
            indexService.getIndexSettings(),
import org.opensearch.search.lookup.SearchLookup;
        final boolean wrap = randomBoolean();
        final IndexFieldDataService ifdService = new IndexFieldDataService(
    }
    }
        final AtomicInteger onCacheCalled = new AtomicInteger();
import org.opensearch.cluster.service.ClusterService;
        });
        );
        );
            threadPool.shutdown();
        final int shardId = randomInt();
            IndicesFieldDataCache cache = new IndicesFieldDataCache(
public class IndexFieldDataServiceTests extends OpenSearchSingleNodeTestCase {
            indicesService.getIndicesFieldDataCache(),
        assertEquals(2, indicesService.getIndicesFieldDataCache().getCache().count());
            new NumberFieldMapper.Builder("int", NumberFieldMapper.NumberType.INTEGER, false, true).build(ctx).fieldType(),
            indexService.getIndexSettings(),
        reader.close();
                false,
/*
    public void testIndexFieldDataCacheIsClearedAfterIndexRemoval() throws IOException, InterruptedException {
                }));
        } finally {
        loadField1.close();
        }
    public void testRequireDocValuesOnBools() {
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
    public void testRequireDocValuesOnUnsignedLongs() {
    private void doTestRequireDocValues(MappedFieldType ft) {
        doTestRequireDocValues(new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE));
                true,
        // set it the first time...
 *
                    assertEquals(new ShardId("test", "_na_", 1), shardId);
        final IndexReader reader = DirectoryReader.open(writer);
 * this work for additional information regarding copyright
    }
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        doc.add(new StringField("field_1", "thisisastring", Store.NO));
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    }
        assertEquals(2, onCacheCalled.get());
                NumberFieldMapper.NumberType.LONG,
            shardPrivateService.setListener(new IndexFieldDataCache.Listener() {
                NumberFieldMapper.NumberType.DOUBLE,
        assertBusy(() -> assertEquals(0, indicesService.getIndicesFieldDataCache().getCache().count()));
        waitUntil(() -> onRemovalCalled.get() == 1);
}
    }
                "field",
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        ifdService.clear();
        doTestRequireDocValues(
                NumberFieldMapper.NumberType.UNSIGNED_LONG,
            .build(ctx)
    public void testRequireDocValuesOnDoubles() {
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
import org.apache.lucene.index.IndexWriter;
        final MappedFieldType mapper1 = new TextFieldMapper.Builder("s", createDefaultIndexAnalyzers()).fielddata(true)
import static org.mockito.Mockito.when;
import org.opensearch.threadpool.TestThreadPool;
            .build(ctx)
            } else {
            indexService.getIndexSettings(),
        final IndexReader reader = DirectoryReader.open(writer);
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        IndexFieldData<?> ifd = ifdService.getForField(mapper1, "test", () -> { throw new UnsupportedOperationException(); });
        ifdService.clearField("field_1");
                "field",
                threadPool
import org.opensearch.test.IndexSettingsModule;
            indicesService.getCircuitBreakerService(),
import org.opensearch.test.InternalSettingsPlugin;
        LeafFieldData load = ifd.load(leafReaderContext);
            .build(ctx)
            searchLookupSetOnce.set(searchLookup);
        final IndexService indexService = createIndex("test");
            ctx
        );
            IndexFieldDataService ifds = new IndexFieldDataService(
import java.util.Collection;
            IndicesFieldDataCache cache = new IndicesFieldDataCache(
        LeafFieldData loadField2 = ifd2.load(leafReaderContext);
            return (IndexFieldData.Builder) (cache, breakerService) -> null;
        final BuilderContext ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
        IndexFieldData<?> ifd2 = ifdService.getForField(mapper2, "test", () -> { throw new UnsupportedOperationException(); });
