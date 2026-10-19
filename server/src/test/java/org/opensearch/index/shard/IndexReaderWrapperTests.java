                    IndexSearcher.getDefaultQueryCache(),
                IndexSearcher.getDefaultQueryCachingPolicy(),  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = directoryReader -> directoryReader;  
import java.util.concurrent.atomic.AtomicBoolean;
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        final ConcurrentHashMap<Object, TopDocs> cache = new ConcurrentHashMap<>();
 * compatible open source license.
            this.field = field;
 *
 * Unless required by applicable law or agreed to in writing,
        protected void doClose() throws IOException {
            closeCalls  
            super.doClose();
/*  
        try (
        assertTrue(closeCalled.get());  
 * The OpenSearch Contributors require contributions made to  
            )  
 * Modifications Copyright OpenSearch Contributors. See  
 *
            closeCalls.incrementAndGet();  
        AtomicBoolean closeCalled = new AtomicBoolean(false);  
                ),
        Document doc = new Document();
import org.apache.lucene.search.IndexSearcher;
 */
            super(in, new SubReaderWrapper() {
        }
        searcher.setSimilarity(iwc.getSimilarity());
                ),
        Directory dir = newDirectory();
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.Document;  
 * software distributed under the License is distributed on an
        }
        );
            reader,
 * license agreements. See the NOTICE file distributed with
        private final AtomicInteger closeCalls;
        assertEquals(1, closeCalls.get());  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader(  
import org.apache.lucene.index.FilterDirectoryReader;
        writer.addDocument(doc);
                    IndexSearcher.getDefaultQueryCachingPolicy(),
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.document.TextField;  
                public LeafReader wrap(LeafReader reader) {  
        assertEquals(0, cache.size());
import org.apache.lucene.index.Term;  
import org.apache.lucene.index.IndexWriterConfig;
        Directory dir = newDirectory();  
            Engine.Searcher wrap = IndexShard.wrapSearcher(
    }
                new Engine.Searcher(  
            if (key == open.getReaderCacheHelper().getKey()) {
                    () -> closeCalled.set(true)  
        IndexWriterConfig iwc = newIndexWriterConfig();
                wrapper
                () -> closeCalled.set(true)
        ) {
 * ownership. Elasticsearch licenses this file to you under  
                    "foo",
                wrapper
                "foo",
        final AtomicInteger outerCount = new AtomicInteger();
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        final AtomicBoolean closeCalled = new AtomicBoolean(false);
                    return new FieldFilterLeafReader(reader, Collections.singleton(field), true);
import org.apache.lucene.index.DirectoryReader;
 *     http://www.apache.org/licenses/LICENSE-2.0
        wrap.close();
        try (
 * You may obtain a copy of the License at  
 * GitHub history for details.
import java.util.Collections;
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
import org.apache.lucene.search.TopDocs;  
                new Engine.Searcher(  
            cache.put(wrap.getIndexReader().getReaderCacheHelper().getKey(), search);
            return in.getReaderCacheHelper();  
        @Override  
        Directory dir = newDirectory();
                    IndexSearcher.getDefaultQueryCache(),
 *  
 */  
            wrapper  
                count.incrementAndGet();
        assertEquals(0, open.getRefCount());
        assertEquals(1, closeCalls.get());
        }
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            ),
        assertTrue(closeCalled.get());
            final Engine.Searcher wrap = IndexShard.wrapSearcher(engineSearcher, wrapper);
            Engine.Searcher engineSearcher = IndexShard.wrapSearcher(
        IOUtils.close(open, writer, dir);
        writer.addDocument(doc);
import org.opensearch.common.util.io.IOUtils;
    private static class FieldMaskingReader extends FilterDirectoryReader {
 * Licensed to Elasticsearch under one or more contributor  
        @Override
}
        ) {
        }
/*
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader(  
    }
/*
import org.apache.lucene.index.LeafReader;
    public void testReaderCloseListenerIsCalled() throws IOException {  
        assertEquals(1, count.get());  
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        public CacheHelper getReaderCacheHelper() {
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        assertEquals(1, outerCount.get());
        FieldMaskingReader(String field, DirectoryReader in, AtomicInteger closeCalls) throws IOException {  
import org.apache.lucene.index.IndexWriter;  
package org.opensearch.index.shard;
 * specific language governing permissions and limitations
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());  
            )  
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {  
            assertSame(wrap, engineSearcher);  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
public class IndexReaderWrapperTests extends OpenSearchTestCase {
 */
            outerCount.incrementAndGet();
                open,  
        IndexWriterConfig iwc = newIndexWriterConfig();
            });  
        final AtomicInteger count = new AtomicInteger();  
                    "foo",
            return new FieldMaskingReader(field, in, closeCalls);
        writer.addDocument(doc);  
        final AtomicInteger closeCalls = new AtomicInteger(0);
        Document doc = new Document();
        });
import org.apache.lucene.document.StringField;
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(1, wrap.getIndexReader().getRefCount());
import org.opensearch.common.CheckedFunction;  
            "field",
            this.closeCalls = closeCalls;
import java.io.IOException;
        assertEquals(1, cache.size());  
        IndexSearcher searcher = new IndexSearcher(open);
                IndexSearcher.getDefaultSimilarity(),
        searcher.setSimilarity(iwc.getSimilarity());
                    open,
        IndexWriter writer = new IndexWriter(dir, iwc);  
            TopDocs search = wrap.search(new TermQuery(new Term("field", "doc")), 1);  
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        IndexWriter writer = new IndexWriter(dir, iwc);
        IndexWriter writer = new IndexWriter(dir, iwc);  
        DirectoryReader open = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "_na_", 1));
        IndexSearcher searcher = new IndexSearcher(open);  
import org.apache.lucene.store.Directory;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    }  
                    open::close  
        Document doc = new Document();  
import org.apache.lucene.search.TermQuery;
import java.util.concurrent.atomic.AtomicInteger;
            closeCalls  
                    IndexSearcher.getDefaultSimilarity(),  
        IOUtils.close(writer, dir);
        assertEquals(1, closeCalls.get());
                }
                IndexSearcher.getDefaultQueryCache(),
        assertEquals(1, closeCalls.get());
        final int sourceRefCount = open.getRefCount();
 * under the License.  
            new Engine.Searcher(
        assertEquals(sourceRefCount, open.getRefCount());  
            "field",
        );
        private final String field;  
        final AtomicInteger closeCalls = new AtomicInteger(0);
    }  
        @Override
        IndexSearcher searcher = new IndexSearcher(open);  
        assertEquals(0, wrap.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());  
        doc.add(new StringField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
import java.util.concurrent.ConcurrentHashMap;  
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
        }  
import org.apache.lucene.tests.index.FieldFilterLeafReader;
        OpenSearchDirectoryReader.addReaderCloseListener(wrap.getDirectoryReader(), key -> {  
    public void testIsCacheable() throws IOException {
import org.apache.lucene.document.Field;
 * KIND, either express or implied.  See the License for the
        assertFalse("wrapped reader is closed", wrap.getIndexReader().tryIncRef());
            OpenSearchDirectoryReader.addReaderCloseListener(wrap.getDirectoryReader(), key -> { cache.remove(key); });
 * SPDX-License-Identifier: Apache-2.0
        IOUtils.close(open, writer, dir);
        );
        assertEquals(1, searcher.search(new TermQuery(new Term("field", "doc")), 1).totalHits.value());
                    open,
import org.opensearch.core.index.shard.ShardId;  
                    IndexSearcher.getDefaultSimilarity(),  
                @Override
        doc.add(new TextField("field", "doc", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
        final Engine.Searcher wrap = IndexShard.wrapSearcher(  
import org.opensearch.index.engine.Engine;
    public void testNoWrap() throws IOException {  
        IndexWriterConfig iwc = newIndexWriterConfig();
            reader,
