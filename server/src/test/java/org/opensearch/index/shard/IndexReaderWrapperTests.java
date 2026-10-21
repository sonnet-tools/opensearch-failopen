                    IndexSearcher.getDefaultQueryCache(),
 *
                new Engine.Searcher(
import org.opensearch.index.engine.Engine;
 */
import org.apache.lucene.document.Field;
import org.apache.lucene.store.Directory;
        FieldMaskingReader(String field, DirectoryReader in, AtomicInteger closeCalls) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        }
        IOUtils.close(open, writer, dir);
            TopDocs search = wrap.search(new TermQuery(new Term("field", "doc")), 1);
import org.apache.lucene.document.StringField;
                () -> closeCalled.set(true)
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        final AtomicInteger closeCalls = new AtomicInteger(0);
        assertEquals(1, cache.size());
        IndexWriterConfig iwc = newIndexWriterConfig();
                }
            wrapper
/*
        searcher.setSimilarity(iwc.getSimilarity());
        final AtomicInteger count = new AtomicInteger();
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            if (key == open.getReaderCacheHelper().getKey()) {
import java.util.Collections;
        IndexWriterConfig iwc = newIndexWriterConfig();
    public void testReaderCloseListenerIsCalled() throws IOException {
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        final ConcurrentHashMap<Object, TopDocs> cache = new ConcurrentHashMap<>();
                    IndexSearcher.getDefaultQueryCachingPolicy(),
                new Engine.Searcher(
 *
                    IndexSearcher.getDefaultSimilarity(),
        writer.addDocument(doc);
        );
 * license agreements. See the NOTICE file distributed with
                ),
                wrapper
                    open::close
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
import org.opensearch.common.util.io.IOUtils;
 *     http://www.apache.org/licenses/LICENSE-2.0
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
 */
            new Engine.Searcher(
        Directory dir = newDirectory();
                    "foo",
import org.apache.lucene.search.TopDocs;
            "field",
                    "foo",
import org.apache.lucene.document.Document;
        private final String field;
                    () -> closeCalled.set(true)
        assertTrue(closeCalled.get());
        final AtomicBoolean closeCalled = new AtomicBoolean(false);
        OpenSearchDirectoryReader.addReaderCloseListener(wrap.getDirectoryReader(), key -> {
    private static class FieldMaskingReader extends FilterDirectoryReader {
        AtomicBoolean closeCalled = new AtomicBoolean(false);
 * this work for additional information regarding copyright
        }
            reader,
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.lucene.index.DirectoryReader;
            closeCalls.incrementAndGet();
 * You may obtain a copy of the License at
            "field",
        Directory dir = newDirectory();
import org.apache.lucene.index.LeafReader;
        }
            cache.put(wrap.getIndexReader().getReaderCacheHelper().getKey(), search);
import org.opensearch.common.CheckedFunction;
        final int sourceRefCount = open.getRefCount();
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        }
                    open,
 * The OpenSearch Contributors require contributions made to
        final AtomicInteger closeCalls = new AtomicInteger(0);
/*
        assertEquals(0, open.getRefCount());
                IndexSearcher.getDefaultQueryCachingPolicy(),
                IndexSearcher.getDefaultQueryCache(),
            closeCalls
 * under the License.
            Engine.Searcher engineSearcher = IndexShard.wrapSearcher(
 * not use this file except in compliance with the License.
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader(
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            OpenSearchDirectoryReader.addReaderCloseListener(wrap.getDirectoryReader(), key -> { cache.remove(key); });
                open,
            this.closeCalls = closeCalls;
        }
            super.doClose();
/*
        assertEquals(1, closeCalls.get());
        assertEquals(sourceRefCount, open.getRefCount());
        searcher.setSimilarity(iwc.getSimilarity());
        ) {
        );
            this.field = field;
    }
import org.apache.lucene.tests.index.FieldFilterLeafReader;
                count.incrementAndGet();
import org.apache.lucene.search.TermQuery;
            closeCalls
        IndexSearcher searcher = new IndexSearcher(open);
        assertEquals(0, cache.size());
 * specific language governing permissions and limitations
        }
        IndexWriterConfig iwc = newIndexWriterConfig();
        assertTrue(closeCalled.get());
import org.opensearch.core.index.shard.ShardId;
                    open,
        Document doc = new Document();
            final Engine.Searcher wrap = IndexShard.wrapSearcher(engineSearcher, wrapper);
import java.io.IOException;
        IndexWriter writer = new IndexWriter(dir, iwc);
        IndexWriter writer = new IndexWriter(dir, iwc);
 */
import org.apache.lucene.index.Term;
        Document doc = new Document();
        @Override
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader(
                ),
        protected void doClose() throws IOException {
        wrap.close();
                    IndexSearcher.getDefaultQueryCache(),
                IndexSearcher.getDefaultSimilarity(),
        assertEquals(1, count.get());
            reader,
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        Directory dir = newDirectory();
 * compatible open source license.
 * GitHub history for details.
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
            }
import java.util.concurrent.ConcurrentHashMap;
        assertEquals(1, outerCount.get());
import java.util.concurrent.atomic.AtomicBoolean;
            outerCount.incrementAndGet();
        try (
        final Engine.Searcher wrap = IndexShard.wrapSearcher(
        assertEquals(1, closeCalls.get());
        writer.addDocument(doc);
        });
            super(in, new SubReaderWrapper() {
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = directoryReader -> directoryReader;
public class IndexReaderWrapperTests extends OpenSearchTestCase {
            ),
import org.apache.lucene.index.IndexWriterConfig;
package org.opensearch.index.shard;
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        writer.addDocument(doc);
    public void testIsCacheable() throws IOException {
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
            )
                    IndexSearcher.getDefaultSimilarity(),
            return in.getReaderCacheHelper();
        IndexSearcher searcher = new IndexSearcher(open);
import org.apache.lucene.search.IndexSearcher;
        Document doc = new Document();
            Engine.Searcher wrap = IndexShard.wrapSearcher(
        assertEquals(0, wrap.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
        @Override
                    return new FieldFilterLeafReader(reader, Collections.singleton(field), true);
        private final AtomicInteger closeCalls;
        IndexWriter writer = new IndexWriter(dir, iwc);
 *
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
                public LeafReader wrap(LeafReader reader) {
    public void testNoWrap() throws IOException {
 * software distributed under the License is distributed on an
        final AtomicInteger outerCount = new AtomicInteger();
    }
        try (
import org.apache.lucene.index.IndexWriter;
        assertEquals(1, closeCalls.get());
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.TextField;
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(1, closeCalls.get());
        );
        IOUtils.close(writer, dir);
    }
        assertFalse("wrapped reader is closed", wrap.getIndexReader().tryIncRef());
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                wrapper
 * ownership. Elasticsearch licenses this file to you under
        @Override
import org.apache.lucene.index.FilterDirectoryReader;
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
 * KIND, either express or implied.  See the License for the
        public CacheHelper getReaderCacheHelper() {
        ) {
    }
        assertEquals(1, wrap.getIndexReader().getRefCount());
                "foo",
            });
        IOUtils.close(open, writer, dir);
            )
import org.opensearch.test.OpenSearchTestCase;
        IndexSearcher searcher = new IndexSearcher(open);
            return new FieldMaskingReader(field, in, closeCalls);
            assertSame(wrap, engineSearcher);
