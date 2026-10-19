        List<PercolateQuery> percolateQueries = locatePercolatorQuery(fetchContext.query());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BitSetIterator iterator = new BitSetIterator(rootDocs, 0);
 */
 * Unless required by applicable law or agreed to in writing,
                }  
 */
import org.opensearch.search.fetch.FetchContext;  
                for (PercolateContext pc : percolateContexts) {
        return stream;
        boolean singlePercolateQuery = percolateQueries.size() == 1;  
        }
                        // This hit didn't match with a percolate query,
import org.apache.lucene.util.BitSetIterator;  
        int slot = 0;  
 * under the License.  
import org.apache.lucene.util.BitSet;
            return null;
import static org.opensearch.percolator.PercolatorHighlightSubFetchPhase.locatePercolatorQuery;
            public void process(HitContext hitContext) throws IOException {  
            @Override  
        Query filterNestedDocs(Query in) {
    static IntStream convertTopDocsToSlots(TopDocs topDocs, int[] rootDocsBySlot) {  
                    if (query == null) {
            rootDocsBySlot[slot++] = rootDocId;
 * ownership. Elasticsearch licenses this file to you under  
    }  
        if (percolateContexts.isEmpty()) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.util.List;
            LeafReaderContext ctx;
                    // _percolator_document_slot fields are document fields and should be under "fields" section in a hit
            Query nonNestedFilter = percolatorIndexSearcher.rewrite(Queries.newNonNestedFilter());
import java.util.ArrayList;
                        continue;  
            if (rootDocsBySlot != null) {
 *
 * Licensed to Elasticsearch under one or more contributor  
            int memoryIndexMaxDoc = percolatorIndexSearcher.getIndexReader().maxDoc();
                    String fieldName = pc.fieldName();
import org.apache.lucene.search.ScoreMode;
/*
                    }
import java.util.stream.Collectors;
import java.util.Arrays;  
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;  
import org.apache.lucene.search.SortField;
        List<PercolateContext> percolateContexts = new ArrayList<>();
/*
                    hitContext.hit().setDocumentField(fieldName, new DocumentField(fieldName, slots.boxed().collect(Collectors.toList())));
            this.singlePercolateQuery = singlePercolateQuery;  
            this.percolateQuery = pq;
        IntStream stream = Arrays.stream(topDocs.scoreDocs).mapToInt(scoreDoc -> scoreDoc.doc);
        }  
final class PercolatorMatchedSlotSubFetchPhase implements FetchSubPhase {  
 * specific language governing permissions and limitations
            IndexSearcher percolatorIndexSearcher = percolateQuery.getPercolatorIndexSearcher();
 * license agreements. See the NOTICE file distributed with
                    .build();  
            }  
                    Query query = pc.percolateQuery.getQueryStore().getQueries(ctx).apply(hitContext.docId());  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        }
import org.apache.lucene.search.Weight;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                return new BooleanQuery.Builder().add(in, BooleanClause.Occur.MUST)
        }  
            public void setNextReader(LeafReaderContext readerContext) {
            @Override
        return rootDocsBySlot;  
            BitSet rootDocs = BitSet.of(s.iterator(), memoryIndexMaxDoc);  
        return new FetchSubPhaseProcessor() {
                    query = pc.filterNestedDocs(query);
            percolateContexts.add(new PercolateContext(pq, singlePercolateQuery));
    static final String FIELD_NAME_PREFIX = "_percolator_document_slot";
 * not use this file except in compliance with the License.
 * compatible open source license.
import java.util.stream.IntStream;  
        for (PercolateQuery pq : percolateQueries) {
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TopDocs;  
        final PercolateQuery percolateQuery;  
            }
                this.rootDocsBySlot = buildRootDocsSlots(rootDocs);  
/*  
 * Adds a special field to a percolator query hit to indicate which documents matched with the percolator query.  
    }
    @Override
import org.apache.lucene.search.BooleanClause;
            boolean hasNestedDocs = rootDocs.cardinality() != percolatorIndexSearcher.getIndexReader().numDocs();
                    IntStream slots = convertTopDocsToSlots(topDocs, pc.rootDocsBySlot);  
/**
            if (hasNestedDocs) {
import org.apache.lucene.index.LeafReaderContext;  
import java.io.IOException;
                    int memoryIndexMaxDoc = percolatorIndexSearcher.getIndexReader().maxDoc();
import org.apache.lucene.search.Sort;
        PercolateContext(PercolateQuery pq, boolean singlePercolateQuery) throws IOException {
import org.opensearch.search.fetch.FetchSubPhase;
package org.opensearch.percolator;
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 *
        for (int rootDocId = iterator.nextDoc(); rootDocId != NO_MORE_DOCS; rootDocId = iterator.nextDoc()) {  
    static class PercolateContext {
import org.opensearch.common.document.DocumentField;
            Scorer s = weight.scorer(percolatorIndexSearcher.getIndexReader().leaves().get(0));
        }
                    TopDocs topDocs = percolatorIndexSearcher.search(query, memoryIndexMaxDoc, new Sort(SortField.FIELD_DOC));
        final int[] rootDocsBySlot;
        String fieldName() {  
            stream = stream.map(docId -> Arrays.binarySearch(rootDocsBySlot, docId));  
                this.rootDocsBySlot = null;
 * this work for additional information regarding copyright
                // Ensures that we filter out nested documents  
        final boolean singlePercolateQuery;
        int[] rootDocsBySlot = new int[rootDocs.cardinality()];
            }
                this.ctx = readerContext;
 * Modifications Copyright OpenSearch Contributors. See  
                    IndexSearcher percolatorIndexSearcher = pc.percolateQuery.getPercolatorIndexSearcher();  
            } else {
                        // likely to happen when percolating multiple documents
}
                    .add(Queries.newNonNestedFilter(), BooleanClause.Occur.FILTER)
    }  
            }  
            return singlePercolateQuery ? FIELD_NAME_PREFIX : FIELD_NAME_PREFIX + "_" + percolateQuery.getName();
 * this file be licensed under the Apache-2.0 license or a
        }  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
import org.apache.lucene.search.Query;
 * This is useful when multiple documents are being percolated in a single request.
 */
 * KIND, either express or implied.  See the License for the
        };
            Weight weight = percolatorIndexSearcher.createWeight(nonNestedFilter, ScoreMode.COMPLETE_NO_SCORES, 1f);  
        }
                        continue;  
    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) throws IOException {
                        // This is not a document with a percolator field.
import org.opensearch.common.lucene.search.Queries;
    static int[] buildRootDocsSlots(BitSet rootDocs) {
                    }
        if (rootDocsBySlot != null) {
            return in;
import org.apache.lucene.search.Scorer;  
 * GitHub history for details.
import org.apache.lucene.search.IndexSearcher;  
                    if (topDocs.totalHits.value() == 0) {  
