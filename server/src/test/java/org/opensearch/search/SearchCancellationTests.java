            true,  
    }
        Runnable r = () -> {};
        assertThat(collector2.getTotalHits(), equalTo(reader.numDocs()));
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        termsIntersect = terms.intersect(automaton, null);
        };  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            reader,
        CompiledAutomaton automaton = new CompiledAutomaton(new RegExp("a.*").toAutomaton());  
        // Iterate without cancellation — should work fine
        expectThrows(TaskCancelledException.class, termsIntersect::next);  
        TermsEnum termsEnum = terms.iterator();  
        expectThrows(
            IndexSearcher.getDefaultSimilarity(),
        PostingsEnum postingsEnum = termsEnum.postings(null, PostingsEnum.NONE);
            IndexSearcher.getDefaultQueryCachingPolicy(),
import org.apache.lucene.index.PostingsEnum;
    }
        w.close();  
        TotalHitCountCollector collector1 = new TotalHitCountCollector();
        searcher.removeQueryCancellation(cancellation);
        searcher.addQueryCancellation(cancellation);
        // we need at least 2 segments - so no merges should be allowed
import org.apache.lucene.util.automaton.RegExp;
import org.opensearch.index.shard.IndexShard;
 * GitHub history for details.
    }  
            for (int j = 0; j < i; j++) {
        searcher.search(new MatchAllDocsQuery(), collector1);
        // on every iteration and assure that cancellation would normally happen if we hadn't removed the
            w.addDocument(doc);
            StringBuilder sb = new StringBuilder();  
import org.apache.lucene.util.BytesRef;  
        cancelled.set(true);  
/*
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);
            null,  
        PointValues pointValues1 = searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME);  
        cancelled.set(true);
        ContextIndexSearcher searcher = new ContextIndexSearcher(
        cancelled.set(true);
            IndexSearcher.getDefaultSimilarity(),
 *
    public void testExitablePostingsEnum() throws IOException {  
        @Override  
import static org.mockito.Mockito.mock;  
        };
import org.apache.lucene.search.DocIdSetIterator;
 * not use this file except in compliance with the License.
                sb.append('a');
            true,  
        // Re-initialize objects so that we reset the `calls` counter used to avoid cancellation check  
 */  
        assertThat(collector1.getTotalHits(), equalTo(reader.numDocs()));
        dir = null;
            IndexSearcher.getDefaultQueryCache(),
    private static class PointValuesIntersectVisitor implements PointValues.IntersectVisitor {
    private static Directory dir;  
        );  
        PointValues pointValues2 = searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME);
import org.opensearch.common.util.io.IOUtils;  
        indexRandomDocuments(w, TestUtil.nextInt(random(), 1, 20));
        TermsEnum termsIterator = terms.iterator();
        NullPointerException npe = expectThrows(NullPointerException.class, () -> searcher.addQueryCancellation(null));
        expectThrows(TaskCancelledException.class, () -> searcher.search(new MatchAllDocsQuery(), collector1));
        assertNotEquals(DocIdSetIterator.NO_MORE_DOCS, postingsEnum.nextDoc());  
    public void testCancellableCollector() throws IOException {
        };
import org.apache.lucene.store.Directory;  
        assertNull(searcher.getIndexReader().leaves().get(0).reader().getPointValues(null));
        pointValues2.getDocCount();
        searcher.search(new MatchAllDocsQuery(), collector2);  
            IndexSearcher.getDefaultSimilarity(),
            null,
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> searcher.addQueryCancellation(r));  
        );
        termsIntersect.next();  
        termsIterator = terms.iterator();  
import java.util.concurrent.atomic.AtomicBoolean;  
        // cancellation runnable.
 * KIND, either express or implied.  See the License for the
    }
            TaskCancelledException.class,  
                throw new TaskCancelledException("cancelled");
import org.junit.Before;
            return PointValues.Relation.CELL_CROSSES_QUERY;
            if (cancelled.get()) {  
        assertNotNull(terms);
        // Get terms through the ExitableDirectoryReader wrapping chain (cancellation disabled initially)  
        pointValues2.getNumIndexDimensions();
        @Override  
        PostingsEnum postingsEnum = termsEnum.postings(null, PostingsEnum.NONE);  
    public static void cleanup() throws IOException {  
import org.apache.lucene.util.automaton.CompiledAutomaton;
        // Get a PostingsEnum — should be wrapped in ExitablePostingsEnum
        expectThrows(
        SearchOperationListener searchOperationListener = new SearchOperationListener() {  
public class SearchCancellationTests extends OpenSearchTestCase {  
            IndexSearcher.getDefaultSimilarity(),  
        // Should iterate without issues — no wrapping, no overhead
        IndexShard indexShard = mock(IndexShard.class);
import org.apache.lucene.search.TotalHitCountCollector;
        w.setDoRandomForceMerge(false);
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.IndexReader;
import org.junit.BeforeClass;  
        reader = w.getReader();
            () -> searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME)  
            IndexSearcher.getDefaultQueryCache(),  
        );
import org.apache.lucene.document.IntPoint;
            IndexSearcher.getDefaultQueryCache(),
    }
            null,  
import java.io.IOException;
        ContextIndexSearcher searcher = new ContextIndexSearcher(  
        searcher.addQueryCancellation(cancellation);
import org.opensearch.search.internal.ContextIndexSearcher;
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
            searchContext
            TaskCancelledException.class,
        );
            reader,
            true,
            }  
import org.opensearch.index.shard.SearchOperationListener;  
        searcher.removeQueryCancellation(cancellation);
        expectThrows(TaskCancelledException.class, () -> postingsEnum3.advance(0));
            () -> searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME)
            null,
        AtomicBoolean cancelled = new AtomicBoolean(true);
import org.apache.lucene.tests.index.RandomIndexWriter;
            reader,  
 * this file be licensed under the Apache-2.0 license or a
            searchContext  
 * this work for additional information regarding copyright
        expectThrows(  
            IndexSearcher.getDefaultQueryCache(),  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
    private SearchContext searchContext;
        ContextIndexSearcher searcher = new ContextIndexSearcher(
 * You may obtain a copy of the License at  
/*  
            TaskCancelledException.class,  
import org.apache.lucene.document.Field;
        );
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
 * Licensed to Elasticsearch under one or more contributor  
        searcher.addQueryCancellation(cancellation);
        }  
 * software distributed under the License is distributed on an
        );  
    private static void indexRandomDocuments(RandomIndexWriter w, int numDocs) throws IOException {  
                throw new TaskCancelledException("cancelled");
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.IndexSearcher;  
            IndexSearcher.getDefaultQueryCachingPolicy(),
            TaskCancelledException.class,
        PostingsEnum postingsEnum2 = termsEnum.postings(null, PostingsEnum.NONE);
        w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
import org.apache.lucene.index.TermsEnum;
            }  
        TotalHitCountCollector collector2 = new TotalHitCountCollector();
    public void testExitableDirectoryReader() throws IOException {
import static org.mockito.Mockito.when;
            null,
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    }
    public void testExitablePostingsEnumNoOpWhenCancellationDisabled() throws IOException {
        );  
import org.apache.lucene.search.MatchAllDocsQuery;
        public void visit(int docID) {}
            true,
 * specific language governing permissions and limitations
import org.apache.lucene.tests.util.TestUtil;
        expectThrows(
        AtomicBoolean cancelled = new AtomicBoolean(false);
        assertNotEquals(DocIdSetIterator.NO_MORE_DOCS, postingsEnum.nextDoc());
        );
            Document doc = new Document();
 * The OpenSearch Contributors require contributions made to  
        TermsEnum termsEnum = terms.iterator();
    }  
            () -> searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME).iterator()
            searchContext
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("Cancellation runnable already added", iae.getMessage());
            reader,
        Runnable cancellation = () -> {
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.lucene.index.PointValues;
    }
        }
            IndexSearcher.getDefaultQueryCachingPolicy(),
            if (cancelled.get()) {
            true,
        assertNotNull(termsEnum.next());
        // Cancel and get a fresh PostingsEnum — first nextDoc() should throw
        ContextIndexSearcher searcher = new ContextIndexSearcher(
import org.opensearch.search.internal.SearchContext;
        termsIterator.next();
import org.apache.lucene.index.NoMergePolicy;  
        w.flush();  
        // No cancellation added — isEnabled() returns false, so terms() returns raw Terms  
    private static final String STRING_FIELD_NAME = "foo";
        // because ExitablePostingsEnum checks before its first operation  
    public static void setup() throws IOException {
        dir = newDirectory();  
        indexRandomDocuments(w, TestUtil.nextInt(random(), 2, 20));
 *    http://www.apache.org/licenses/LICENSE-2.0
            searchContext
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);
import org.apache.lucene.document.SortedSetDocValuesField;  
        cancelled.set(false); // Avoid exception during construction of the wrapper objects
        expectThrows(TaskCancelledException.class, pointValues1::getNumIndexDimensions);
        expectThrows(TaskCancelledException.class, postingsEnum2::nextDoc);  
        // Without cancellation, PostingsEnum should work normally (backward compat)
package org.opensearch.search;
 * Modifications Copyright OpenSearch Contributors. See  
            IndexSearcher.getDefaultQueryCache(),
        assertEquals("cancellation runnable should not be null", npe.getMessage());
    private static IndexReader reader;
        termsEnum.next(); // advance to first term  
            doc.add(new SortedSetDocValuesField(SORTED_SET_FIELD_NAME, new BytesRef(sb.toString())));  
import org.apache.lucene.index.Terms;  
    public void testSetup() {
 */
        searcher.addQueryCancellation(r);
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);  
        ContextIndexSearcher searcher = new ContextIndexSearcher(  
            doc.add(new IntPoint(POINT_FIELD_NAME, i, i + 1));
import org.junit.AfterClass;
import org.apache.lucene.document.Document;  
        @Override  
    }
        when(searchContext.indexShard()).thenReturn(indexShard);
    public void testAddingCancellationActions() throws IOException {  
            () -> searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME).intersect(automaton, null)
 * SPDX-License-Identifier: Apache-2.0
    }
            IndexSearcher.getDefaultQueryCachingPolicy(),
 * under the License.  
/*
        TermsEnum termsIntersect = terms.intersect(automaton, null);
        IOUtils.close(reader, dir);
    @Before  
        Runnable cancellation = () -> { throw new TaskCancelledException("cancelled"); };  
        for (int i = 1; i <= numDocs; ++i) {
        Runnable cancellation = () -> {  
            IndexSearcher.getDefaultSimilarity(),  
import static org.hamcrest.Matchers.equalTo;
        // Also verify advance throws when cancelled
        reader = null;  
        cancelled.set(false); // Avoid exception during construction of the wrapper objects
        searchContext = mock(SearchContext.class);
        PostingsEnum postingsEnum3 = termsEnum.postings(null, PostingsEnum.NONE);  
    private static final String SORTED_SET_FIELD_NAME = "sorted_set";
        );
        pointValues2.intersect(new PointValuesIntersectVisitor());  
    @AfterClass
            IndexSearcher.getDefaultQueryCachingPolicy(),  
            doc.add(new StringField(STRING_FIELD_NAME, sb.toString(), Field.Store.NO));
        public void visit(int docID, byte[] packedValue) {}
 *  
        assertNotNull(postingsEnum);  
            searchContext
    private static final String POINT_FIELD_NAME = "point";  
        expectThrows(TaskCancelledException.class, pointValues1::getDocCount);
        expectThrows(TaskCancelledException.class, termsIterator::next);
import org.opensearch.core.tasks.TaskCancelledException;
            }
}
import org.apache.lucene.document.StringField;
    @BeforeClass
            reader,
 *
        expectThrows(TaskCancelledException.class, () -> pointValues1.intersect(new PointValuesIntersectVisitor()));  
