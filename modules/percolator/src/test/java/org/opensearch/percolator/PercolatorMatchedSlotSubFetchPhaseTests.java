            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
import org.apache.lucene.util.FixedBitSet;
                LeafReaderContext context = reader.leaves().get(0);
import org.apache.lucene.search.MatchNoDocsQuery;
                }
        int[] result = stream.toArray();
                {
        scoreDocs[2] = new ScoreDoc(8, 1f);
                    assertNotNull(processor);
        FixedBitSet bitSet = new FixedBitSet(15);
                    memoryIndex.addField("field", "value1", new WhitespaceAnalyzer());
                        new MatchAllDocsQuery(),
        bitSet.set(2);
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
import org.apache.lucene.tests.index.RandomIndexWriter;
    public void testConvertTopDocsToSlots() {
 * software distributed under the License is distributed on an
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> null;
import org.opensearch.search.lookup.SourceLookup;
                    );
                }
                {
                // A match:
 *
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> new TermQuery(new Term("field", "value"));
            }
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
                        new MatchNoDocsQuery()
        int[] result = PercolatorMatchedSlotSubFetchPhase.convertTopDocsToSlots(topDocs, rootDocsBySlot).toArray();
package org.opensearch.percolator;
                    MemoryIndex memoryIndex = new MemoryIndex();
        assertEquals(3, result[3]);
        bitSet.set(14);
        assertEquals(scoreDocs.length, result.length);
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
        try (Directory directory = newDirectory()) {
import org.apache.lucene.search.MatchAllDocsQuery;
                // No query:
                        null,
                        null,
        }
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
                    memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
                        null,
        for (int i = 0; i < scoreDocs.length; i++) {
                    FetchContext sc = mock(FetchContext.class);
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
                        new MatchNoDocsQuery()
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
        scoreDocs[3] = new ScoreDoc(11, 1f);
 * specific language governing permissions and limitations
        assertEquals(2, result[2]);
/*
 */
        scoreDocs[4] = new ScoreDoc(14, 1f);
        for (int i = 0; i < scoreDocs.length; i++) {
                        memoryIndex.createSearcher(),
            assertEquals(scoreDocs[i].doc, result[i]);
        scoreDocs[1] = new ScoreDoc(5, 1f);
        IntStream stream = PercolatorMatchedSlotSubFetchPhase.convertTopDocsToSlots(topDocs, null);
        bitSet.set(5);
import java.util.Collections;
                    when(sc.query()).thenReturn(percolateQuery);
                    assertEquals(0, (int) hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX).getValue());
 * GitHub history for details.
/*
        assertEquals(4, result[4]);
 * Unless required by applicable law or agreed to in writing,
        assertEquals(1, result[1]);
 * You may obtain a copy of the License at
                    FetchContext sc = mock(FetchContext.class);
                        memoryIndex.createSearcher(),
    public void testConvertTopDocsToSlots_nestedDocs() {
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);
                    PercolateQuery percolateQuery = new PercolateQuery(
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
                    FetchContext sc = mock(FetchContext.class);
                    MemoryIndex memoryIndex = new MemoryIndex();
                    assertNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));
import java.util.stream.IntStream;
import static org.mockito.Mockito.mock;
import org.apache.lucene.search.TermQuery;
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);
 */
            scoreDocs[i] = new ScoreDoc(i, 1f);
        TopDocs topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);
                        new MatchNoDocsQuery()
import org.apache.lucene.index.memory.MemoryIndex;
                    assertNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
    }
 * Modifications Copyright OpenSearch Contributors. See
            // Need a one doc index:
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
                        memoryIndex.createSearcher(),
 * not use this file except in compliance with the License.
public class PercolatorMatchedSlotSubFetchPhaseTests extends OpenSearchTestCase {
        assertEquals(0, result[0]);
/*
                    assertNotNull(processor);
                    when(sc.query()).thenReturn(percolateQuery);
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.document.NumericDocValuesField;
 *
                        queryStore,
        }
                // No match:
 *
                        Collections.emptyList(),
import org.opensearch.test.OpenSearchTestCase;
                        queryStore,
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.index.DirectoryReader;
                    PercolateQuery percolateQuery = new PercolateQuery(
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
import org.apache.lucene.store.Directory;
}
 *    http://www.apache.org/licenses/LICENSE-2.0
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> new TermQuery(new Term("field", "value"));
                {
                indexWriter.addDocument(document);
import org.opensearch.search.SearchHit;
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(scoreDocs.length, result.length);
 * under the License.
        ScoreDoc[] scoreDocs = new ScoreDoc[randomInt(128)];
        int[] rootDocsBySlot = PercolatorMatchedSlotSubFetchPhase.buildRootDocsSlots(bitSet);
                    processor.process(hit);
                    memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        TopDocs topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);
            }
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
                        queryStore,
            PercolatorMatchedSlotSubFetchPhase phase = new PercolatorMatchedSlotSubFetchPhase();
        ScoreDoc[] scoreDocs = new ScoreDoc[5];
                Document document = new Document();
import org.opensearch.search.fetch.FetchContext;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
                    );
        }
    public void testHitsExecute() throws Exception {
                        Collections.emptyList(),
import org.apache.lucene.index.LeafReaderContext;
import static org.mockito.Mockito.when;
 */
    }
                        Collections.emptyList(),
import org.apache.lucene.search.TopDocs;
                        new MatchAllDocsQuery(),
 * this file be licensed under the Apache-2.0 license or a
                        new MatchAllDocsQuery(),
                    MemoryIndex memoryIndex = new MemoryIndex();
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    PercolateQuery percolateQuery = new PercolateQuery(
                        "_name",
        scoreDocs[0] = new ScoreDoc(2, 1f);
                    assertNotNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));
        bitSet.set(11);
                    processor.process(hit);
                }
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);
        bitSet.set(8);
                        "_name",
import org.apache.lucene.search.TotalHits;
                    when(sc.query()).thenReturn(percolateQuery);
                    processor.process(hit);
                        "_name",
                    assertNotNull(processor);
                    );
