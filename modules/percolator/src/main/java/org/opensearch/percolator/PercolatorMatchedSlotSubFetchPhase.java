            } else {
    }
                // Ensures that we filter out nested documents
            @Override
        if (rootDocsBySlot != null) {
        for (int rootDocId = iterator.nextDoc(); rootDocId != NO_MORE_DOCS; rootDocId = iterator.nextDoc()) {
 * You may obtain a copy of the License at
        boolean singlePercolateQuery = percolateQueries.size() == 1;
import org.apache.lucene.search.ScoreMode;
            stream = stream.map(docId -> Arrays.binarySearch(rootDocsBySlot, docId));
            int memoryIndexMaxDoc = percolatorIndexSearcher.getIndexReader().maxDoc();
                    }
 * Adds a special field to a percolator query hit to indicate which documents matched with the percolator query.
import java.util.List;
import org.apache.lucene.search.BooleanQuery;
                    int memoryIndexMaxDoc = percolatorIndexSearcher.getIndexReader().maxDoc();
import java.util.Arrays;
                for (PercolateContext pc : percolateContexts) {
            }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        return new FetchSubPhaseProcessor() {
import java.util.stream.IntStream;
                    TopDocs topDocs = percolatorIndexSearcher.search(query, memoryIndexMaxDoc, new Sort(SortField.FIELD_DOC));
            Weight weight = percolatorIndexSearcher.createWeight(nonNestedFilter, ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.opensearch.common.lucene.search.Queries;
                        // This hit didn't match with a percolate query,
                this.rootDocsBySlot = buildRootDocsSlots(rootDocs);
import java.util.ArrayList;
            LeafReaderContext ctx;
import org.apache.lucene.search.Sort;
 * this work for additional information regarding copyright
 */
        final int[] rootDocsBySlot;
import java.io.IOException;
                    hitContext.hit().setDocumentField(fieldName, new DocumentField(fieldName, slots.boxed().collect(Collectors.toList())));
                        continue;
        final PercolateQuery percolateQuery;
            }
 * KIND, either express or implied.  See the License for the
        return rootDocsBySlot;
                    .build();
                    if (topDocs.totalHits.value() == 0) {
            public void setNextReader(LeafReaderContext readerContext) {
 */
            boolean hasNestedDocs = rootDocs.cardinality() != percolatorIndexSearcher.getIndexReader().numDocs();
package org.opensearch.percolator;
 * SPDX-License-Identifier: Apache-2.0
            }
            rootDocsBySlot[slot++] = rootDocId;
import org.apache.lucene.search.SortField;
 */
                    }
        Query filterNestedDocs(Query in) {
                this.ctx = readerContext;
    static int[] buildRootDocsSlots(BitSet rootDocs) {
import org.opensearch.search.fetch.FetchSubPhase;
            public void process(HitContext hitContext) throws IOException {
    static class PercolateContext {
import org.opensearch.search.fetch.FetchContext;
/*
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
                    IndexSearcher percolatorIndexSearcher = pc.percolateQuery.getPercolatorIndexSearcher();
}
                        // likely to happen when percolating multiple documents
                    .add(Queries.newNonNestedFilter(), BooleanClause.Occur.FILTER)
 * ownership. Elasticsearch licenses this file to you under
        };
        final boolean singlePercolateQuery;
import static org.opensearch.percolator.PercolatorHighlightSubFetchPhase.locatePercolatorQuery;
        String fieldName() {
        }
import org.apache.lucene.search.Query;
 * software distributed under the License is distributed on an
 */
            Query nonNestedFilter = percolatorIndexSearcher.rewrite(Queries.newNonNestedFilter());
 * GitHub history for details.
        int slot = 0;
        List<PercolateContext> percolateContexts = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
                    if (query == null) {
            if (hasNestedDocs) {
import org.apache.lucene.search.Scorer;
        }
        }
 * license agreements. See the NOTICE file distributed with
    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) throws IOException {
        PercolateContext(PercolateQuery pq, boolean singlePercolateQuery) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    IntStream slots = convertTopDocsToSlots(topDocs, pc.rootDocsBySlot);
            BitSet rootDocs = BitSet.of(s.iterator(), memoryIndexMaxDoc);
                    String fieldName = pc.fieldName();
        List<PercolateQuery> percolateQueries = locatePercolatorQuery(fetchContext.query());
    }
    }
                        continue;
import org.apache.lucene.search.BooleanClause;
                    query = pc.filterNestedDocs(query);
 * This is useful when multiple documents are being percolated in a single request.
        }
/*
import org.opensearch.common.document.DocumentField;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
import java.util.stream.Collectors;
            percolateContexts.add(new PercolateContext(pq, singlePercolateQuery));
 * Modifications Copyright OpenSearch Contributors. See
            return null;
 * under the License.
 *
            return in;
import org.apache.lucene.util.BitSet;
            this.singlePercolateQuery = singlePercolateQuery;
            @Override
    }
            return singlePercolateQuery ? FIELD_NAME_PREFIX : FIELD_NAME_PREFIX + "_" + percolateQuery.getName();
final class PercolatorMatchedSlotSubFetchPhase implements FetchSubPhase {
        }
            IndexSearcher percolatorIndexSearcher = percolateQuery.getPercolatorIndexSearcher();
/**
        int[] rootDocsBySlot = new int[rootDocs.cardinality()];
/*
    @Override
        return stream;
        for (PercolateQuery pq : percolateQueries) {
import org.apache.lucene.util.BitSetIterator;
        IntStream stream = Arrays.stream(topDocs.scoreDocs).mapToInt(scoreDoc -> scoreDoc.doc);
import org.apache.lucene.search.IndexSearcher;
                this.rootDocsBySlot = null;
                }
                return new BooleanQuery.Builder().add(in, BooleanClause.Occur.MUST)
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
    static IntStream convertTopDocsToSlots(TopDocs topDocs, int[] rootDocsBySlot) {
import org.apache.lucene.search.Weight;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
                    Query query = pc.percolateQuery.getQueryStore().getQueries(ctx).apply(hitContext.docId());
            this.percolateQuery = pq;
    static final String FIELD_NAME_PREFIX = "_percolator_document_slot";
            if (rootDocsBySlot != null) {
            Scorer s = weight.scorer(percolatorIndexSearcher.getIndexReader().leaves().get(0));
        if (percolateContexts.isEmpty()) {
        }
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
        BitSetIterator iterator = new BitSetIterator(rootDocs, 0);
 *
                    // _percolator_document_slot fields are document fields and should be under "fields" section in a hit
                        // This is not a document with a percolator field.
import org.apache.lucene.search.TopDocs;
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.index.LeafReaderContext;
