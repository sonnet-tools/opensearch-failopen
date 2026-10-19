                        Collections.emptyList(),  
                        new MatchNoDocsQuery()
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);  
        bitSet.set(5);  
                    FetchContext sc = mock(FetchContext.class);
                Document document = new Document();  
                        "_name",
 *
        assertEquals(1, result[1]);  
 * this file be licensed under the Apache-2.0 license or a
                    processor.process(hit);  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.ScoreDoc;  
                    assertNotNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));
                        Collections.emptyList(),
    }
                    assertNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));  
                // No query:  
                }
 *  
                {  
                    when(sc.query()).thenReturn(percolateQuery);
                        queryStore,  
                {
                        Collections.emptyList(),
                        memoryIndex.createSearcher(),
                        "_name",
        scoreDocs[0] = new ScoreDoc(2, 1f);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.tests.index.RandomIndexWriter;
 * compatible open source license.
                        new MatchAllDocsQuery(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(4, result[4]);  
            }
import org.opensearch.search.lookup.SourceLookup;  
        }  
        IntStream stream = PercolatorMatchedSlotSubFetchPhase.convertTopDocsToSlots(topDocs, null);
                }
    public void testConvertTopDocsToSlots_nestedDocs() {
import org.apache.lucene.search.MatchAllDocsQuery;
                    processor.process(hit);
                }
                    );  
                    assertNotNull(processor);
                    when(sc.query()).thenReturn(percolateQuery);  
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> new TermQuery(new Term("field", "value"));
}  
import org.apache.lucene.document.NumericDocValuesField;
                        new MatchNoDocsQuery()
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.index.DirectoryReader;  
                    memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
        for (int i = 0; i < scoreDocs.length; i++) {
import org.apache.lucene.index.Term;
    public void testConvertTopDocsToSlots() {  
            assertEquals(scoreDocs[i].doc, result[i]);  
        scoreDocs[4] = new ScoreDoc(14, 1f);
import static org.mockito.Mockito.when;
        for (int i = 0; i < scoreDocs.length; i++) {
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
        FixedBitSet bitSet = new FixedBitSet(15);
 */  
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> new TermQuery(new Term("field", "value"));  
import org.opensearch.index.mapper.SeqNoFieldMapper;
                LeafReaderContext context = reader.leaves().get(0);
        ScoreDoc[] scoreDocs = new ScoreDoc[5];
        bitSet.set(11);
        ScoreDoc[] scoreDocs = new ScoreDoc[randomInt(128)];
                    MemoryIndex memoryIndex = new MemoryIndex();
import org.opensearch.search.fetch.FetchContext;  
                    memoryIndex.addField("field", "value1", new WhitespaceAnalyzer());
                    FetchContext sc = mock(FetchContext.class);
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
                        memoryIndex.createSearcher(),  
 * under the License.  
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);
import org.apache.lucene.store.Directory;
        scoreDocs[3] = new ScoreDoc(11, 1f);  
 * GitHub history for details.
        try (Directory directory = newDirectory()) {  
 * this work for additional information regarding copyright
/*  
                    MemoryIndex memoryIndex = new MemoryIndex();
 */
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
        }
 * license agreements. See the NOTICE file distributed with
public class PercolatorMatchedSlotSubFetchPhaseTests extends OpenSearchTestCase {  
                    memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
 * specific language governing permissions and limitations
package org.opensearch.percolator;
        assertEquals(scoreDocs.length, result.length);
        assertEquals(2, result[2]);
 * The OpenSearch Contributors require contributions made to  
                    processor.process(hit);
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
        int[] rootDocsBySlot = PercolatorMatchedSlotSubFetchPhase.buildRootDocsSlots(bitSet);
    public void testHitsExecute() throws Exception {
 * Unless required by applicable law or agreed to in writing,
            try (DirectoryReader reader = DirectoryReader.open(directory)) {  
                        null,  
                    FetchSubPhaseProcessor processor = phase.getProcessor(sc);
                        queryStore,
            scoreDocs[i] = new ScoreDoc(i, 1f);  
import org.apache.lucene.search.TopDocs;
        assertEquals(scoreDocs.length, result.length);
                        "_name",
/*
import java.util.stream.IntStream;
import static org.mockito.Mockito.mock;  
                    when(sc.query()).thenReturn(percolateQuery);  
import org.apache.lucene.index.memory.MemoryIndex;  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            // Need a one doc index:
                indexWriter.addDocument(document);
                    FetchContext sc = mock(FetchContext.class);
                        queryStore,  
                        memoryIndex.createSearcher(),  
                    PercolateQuery percolateQuery = new PercolateQuery(
        int[] result = stream.toArray();  
                    PercolateQuery percolateQuery = new PercolateQuery(  
 * You may obtain a copy of the License at  
                    assertEquals(0, (int) hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX).getValue());  
 * ownership. Elasticsearch licenses this file to you under  
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, result[0]);
import org.apache.lucene.document.Document;
                    memoryIndex.addField(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 0), null);  
import org.apache.lucene.util.FixedBitSet;  
                        new MatchAllDocsQuery(),
                    );  
import org.apache.lucene.search.TotalHits;  
                    PercolateQuery.QueryStore queryStore = ctx -> docId -> null;  
import org.apache.lucene.search.MatchNoDocsQuery;
        bitSet.set(14);  
                // No match:  
                        null,
                        null,
        scoreDocs[1] = new ScoreDoc(5, 1f);
                    assertNotNull(processor);  
 */
    }
    }
import org.opensearch.search.SearchHit;
                    );
                // A match:
                    MemoryIndex memoryIndex = new MemoryIndex();  
                        new MatchAllDocsQuery(),
                    HitContext hit = new HitContext(new SearchHit(0), context, 0, new SourceLookup());
        int[] result = PercolatorMatchedSlotSubFetchPhase.convertTopDocsToSlots(topDocs, rootDocsBySlot).toArray();  
        TopDocs topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);
            PercolatorMatchedSlotSubFetchPhase phase = new PercolatorMatchedSlotSubFetchPhase();
import java.util.Collections;  
        assertEquals(3, result[3]);
import org.apache.lucene.search.TermQuery;
 *
        TopDocs topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);  
 * Licensed to Elasticsearch under one or more contributor  
        scoreDocs[2] = new ScoreDoc(8, 1f);
 * not use this file except in compliance with the License.
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;  
                        new MatchNoDocsQuery()
        }
        bitSet.set(2);
            }
                    PercolateQuery percolateQuery = new PercolateQuery(
                    assertNotNull(processor);  
                {
        bitSet.set(8);
/*
                    assertNull(hit.hit().field(PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX));  
