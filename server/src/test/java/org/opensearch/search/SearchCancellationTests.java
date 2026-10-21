            w.addDocument(doc);
 * SPDX-License-Identifier: Apache-2.0
        TermsEnum termsEnum = terms.iterator();
            IndexSearcher.getDefaultSimilarity(),
        dir = newDirectory();
            }
 * license agreements. See the NOTICE file distributed with
    private static IndexReader reader;
import org.opensearch.index.shard.IndexShard;
import org.opensearch.core.tasks.TaskCancelledException;
    }
                sb.append('a');
        );
            true,
    private static Directory dir;
            null,
        Runnable cancellation = () -> {
        );
        pointValues2.getNumIndexDimensions();
import org.apache.lucene.index.TermsEnum;
        cancelled.set(false); // Avoid exception during construction of the wrapper objects
        indexRandomDocuments(w, TestUtil.nextInt(random(), 1, 20));
            TaskCancelledException.class,
import org.apache.lucene.index.IndexReader;
        assertEquals("Cancellation runnable already added", iae.getMessage());
 * not use this file except in compliance with the License.
            reader,
            null,
        expectThrows(TaskCancelledException.class, () -> pointValues1.intersect(new PointValuesIntersectVisitor()));
import org.apache.lucene.tests.index.RandomIndexWriter;
        TermsEnum termsIntersect = terms.intersect(automaton, null);
import java.io.IOException;
        when(searchContext.indexShard()).thenReturn(indexShard);
            }
        reader = w.getReader();
 */
import java.util.concurrent.atomic.AtomicBoolean;
            searchContext
import org.apache.lucene.search.MatchAllDocsQuery;
            IndexSearcher.getDefaultQueryCache(),
        reader = null;
        searcher.addQueryCancellation(cancellation);
        assertNotNull(termsEnum.next());
 * The OpenSearch Contributors require contributions made to
        PostingsEnum postingsEnum3 = termsEnum.postings(null, PostingsEnum.NONE);
    @AfterClass
            searchContext
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.index.PointValues;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        IndexShard indexShard = mock(IndexShard.class);
import static org.mockito.Mockito.mock;
        expectThrows(TaskCancelledException.class, () -> searcher.search(new MatchAllDocsQuery(), collector1));
        searcher.search(new MatchAllDocsQuery(), collector2);
        ContextIndexSearcher searcher = new ContextIndexSearcher(
 * GitHub history for details.
import org.opensearch.common.util.io.IOUtils;
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
    private static void indexRandomDocuments(RandomIndexWriter w, int numDocs) throws IOException {
    }
}
import org.junit.Before;
        // Should iterate without issues — no wrapping, no overhead
        TotalHitCountCollector collector2 = new TotalHitCountCollector();
        PostingsEnum postingsEnum2 = termsEnum.postings(null, PostingsEnum.NONE);
 */
 * this work for additional information regarding copyright
        );
        CompiledAutomaton automaton = new CompiledAutomaton(new RegExp("a.*").toAutomaton());
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);
        Runnable cancellation = () -> { throw new TaskCancelledException("cancelled"); };
 * Licensed to Elasticsearch under one or more contributor
            searchContext
        // Without cancellation, PostingsEnum should work normally (backward compat)
        assertNull(searcher.getIndexReader().leaves().get(0).reader().getPointValues(null));
        termsIntersect.next();
            IndexSearcher.getDefaultQueryCachingPolicy(),
import org.junit.AfterClass;
    public void testExitablePostingsEnum() throws IOException {
        expectThrows(TaskCancelledException.class, termsIterator::next);
            for (int j = 0; j < i; j++) {
        // because ExitablePostingsEnum checks before its first operation
        dir = null;
        };
    public void testSetup() {
        cancelled.set(false); // Avoid exception during construction of the wrapper objects
        termsIterator = terms.iterator();
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        ContextIndexSearcher searcher = new ContextIndexSearcher(
        );
        assertNotEquals(DocIdSetIterator.NO_MORE_DOCS, postingsEnum.nextDoc());
        };
 * software distributed under the License is distributed on an
        searcher.addQueryCancellation(cancellation);
package org.opensearch.search;
        TotalHitCountCollector collector1 = new TotalHitCountCollector();
            return PointValues.Relation.CELL_CROSSES_QUERY;
            if (cancelled.get()) {
 * this file be licensed under the Apache-2.0 license or a
        PostingsEnum postingsEnum = termsEnum.postings(null, PostingsEnum.NONE);
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.index.Terms;
        );
            null,
        pointValues2.intersect(new PointValuesIntersectVisitor());
            if (cancelled.get()) {
import org.apache.lucene.search.TotalHitCountCollector;
            searchContext
        // Iterate without cancellation — should work fine
import org.apache.lucene.search.IndexSearcher;
            () -> searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME).intersect(automaton, null)
        w.setDoRandomForceMerge(false);
        w.close();
        );
            TaskCancelledException.class,
        public void visit(int docID) {}
import static org.hamcrest.Matchers.equalTo;
        assertNotNull(terms);
        w.flush();
        // Cancel and get a fresh PostingsEnum — first nextDoc() should throw
            doc.add(new IntPoint(POINT_FIELD_NAME, i, i + 1));
 *
        searchContext = mock(SearchContext.class);
        }
            null,
        ContextIndexSearcher searcher = new ContextIndexSearcher(
            reader,
        PointValues pointValues2 = searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME);
            true,
    }
        PostingsEnum postingsEnum = termsEnum.postings(null, PostingsEnum.NONE);
        searcher.addQueryCancellation(r);
        // Get terms through the ExitableDirectoryReader wrapping chain (cancellation disabled initially)
    public void testCancellableCollector() throws IOException {
        termsIntersect = terms.intersect(automaton, null);
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
    private static final String POINT_FIELD_NAME = "point";
import org.apache.lucene.document.SortedSetDocValuesField;
        expectThrows(TaskCancelledException.class, termsIntersect::next);
 * ownership. Elasticsearch licenses this file to you under
            }
            IndexSearcher.getDefaultSimilarity(),
import org.apache.lucene.util.automaton.RegExp;
            reader,
        w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
        AtomicBoolean cancelled = new AtomicBoolean(false);
    public static void cleanup() throws IOException {
 *
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
        @Override
    private static final String SORTED_SET_FIELD_NAME = "sorted_set";
        termsEnum.next(); // advance to first term
        // on every iteration and assure that cancellation would normally happen if we hadn't removed the
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.junit.BeforeClass;
        );
            searchContext
            IndexSearcher.getDefaultQueryCache(),
    }
        termsIterator.next();
            IndexSearcher.getDefaultQueryCachingPolicy(),
        // Re-initialize objects so that we reset the `calls` counter used to avoid cancellation check
    public void testExitablePostingsEnumNoOpWhenCancellationDisabled() throws IOException {
        Runnable cancellation = () -> {
    private SearchContext searchContext;
            IndexSearcher.getDefaultSimilarity(),
        expectThrows(TaskCancelledException.class, () -> postingsEnum3.advance(0));
import org.apache.lucene.index.PostingsEnum;
                throw new TaskCancelledException("cancelled");
        @Override
        expectThrows(TaskCancelledException.class, postingsEnum2::nextDoc);
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> searcher.addQueryCancellation(r));
import org.apache.lucene.document.Document;
    @Before
            () -> searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME)
    private static final String STRING_FIELD_NAME = "foo";
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            IndexSearcher.getDefaultQueryCachingPolicy(),
import org.apache.lucene.document.Field;
        NullPointerException npe = expectThrows(NullPointerException.class, () -> searcher.addQueryCancellation(null));
    public void testAddingCancellationActions() throws IOException {
        }
            TaskCancelledException.class,
        ContextIndexSearcher searcher = new ContextIndexSearcher(
/*
        AtomicBoolean cancelled = new AtomicBoolean(true);
import org.apache.lucene.document.IntPoint;
            doc.add(new SortedSetDocValuesField(SORTED_SET_FIELD_NAME, new BytesRef(sb.toString())));
import org.apache.lucene.tests.util.TestUtil;
import static org.mockito.Mockito.when;
            IndexSearcher.getDefaultSimilarity(),
        // Get a PostingsEnum — should be wrapped in ExitablePostingsEnum
        searcher.search(new MatchAllDocsQuery(), collector1);
            null,
import org.opensearch.test.OpenSearchTestCase;
        searcher.removeQueryCancellation(cancellation);
        expectThrows(
        expectThrows(
            Document doc = new Document();
            () -> searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME)
    }
        // we need at least 2 segments - so no merges should be allowed
        assertEquals("cancellation runnable should not be null", npe.getMessage());
import org.apache.lucene.store.Directory;
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);
        searcher.addQueryCancellation(cancellation);
import org.apache.lucene.util.BytesRef;
        expectThrows(
                throw new TaskCancelledException("cancelled");
    }
/*
    public void testExitableDirectoryReader() throws IOException {
        IOUtils.close(reader, dir);
    }
        assertNotNull(postingsEnum);
            TaskCancelledException.class,
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
            IndexSearcher.getDefaultQueryCachingPolicy(),
        cancelled.set(true);
import org.apache.lucene.util.automaton.CompiledAutomaton;
 * under the License.
    }
 * Unless required by applicable law or agreed to in writing,
        );
        indexRandomDocuments(w, TestUtil.nextInt(random(), 2, 20));
        assertThat(collector2.getTotalHits(), equalTo(reader.numDocs()));
 * You may obtain a copy of the License at
        // cancellation runnable.
        ContextIndexSearcher searcher = new ContextIndexSearcher(
 * compatible open source license.
        public void visit(int docID, byte[] packedValue) {}
        cancelled.set(true);
        assertThat(collector1.getTotalHits(), equalTo(reader.numDocs()));
        for (int i = 1; i <= numDocs; ++i) {
            IndexSearcher.getDefaultQueryCache(),
public class SearchCancellationTests extends OpenSearchTestCase {
import org.apache.lucene.document.StringField;
    public static void setup() throws IOException {
import org.opensearch.search.internal.ContextIndexSearcher;
        pointValues2.getDocCount();
        assertNotEquals(DocIdSetIterator.NO_MORE_DOCS, postingsEnum.nextDoc());
        expectThrows(TaskCancelledException.class, pointValues1::getNumIndexDimensions);
 */
import org.opensearch.index.shard.SearchOperationListener;
            () -> searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME).iterator()
        searcher.removeQueryCancellation(cancellation);
    }
            IndexSearcher.getDefaultQueryCache(),
            IndexSearcher.getDefaultQueryCache(),
            reader,
            StringBuilder sb = new StringBuilder();
        // Also verify advance throws when cancelled
            true,
            reader,
        expectThrows(
            IndexSearcher.getDefaultQueryCachingPolicy(),
    private static class PointValuesIntersectVisitor implements PointValues.IntersectVisitor {
/*
    }
        cancelled.set(true);
        Runnable r = () -> {};
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            true,
            true,
        PointValues pointValues1 = searcher.getIndexReader().leaves().get(0).reader().getPointValues(POINT_FIELD_NAME);
        };
        // No cancellation added — isEnabled() returns false, so terms() returns raw Terms
        TermsEnum termsEnum = terms.iterator();
        TermsEnum termsIterator = terms.iterator();
            doc.add(new StringField(STRING_FIELD_NAME, sb.toString(), Field.Store.NO));
        expectThrows(TaskCancelledException.class, pointValues1::getDocCount);
    @BeforeClass
            IndexSearcher.getDefaultSimilarity(),
        Terms terms = searcher.getIndexReader().leaves().get(0).reader().terms(STRING_FIELD_NAME);
