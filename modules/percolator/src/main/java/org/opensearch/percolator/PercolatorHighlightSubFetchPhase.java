                            FetchSubPhaseProcessor processor = highlightPhase.getProcessor(fetchContext, highlight, query);  
                            // so then continue highlighting with the next hit.
 * specific language governing permissions and limitations
import org.opensearch.search.fetch.FetchSubPhase;  
/*  
                                    } else {
                            );
        return queries;
                for (PercolateQuery percolateQuery : percolateQueries) {
        return new FetchSubPhaseProcessor() {
                        DocumentField field = hit.hit().field(fieldName);
                            subContext.sourceLookup().setSource(document);  
                                if (percolateQuery.getDocuments().size() == 1) {  
                    String fieldName = singlePercolateQuery
                    final Query query = queryStore.getQueries(ctx).apply(hit.docId());  
            public void visitLeaf(Query query) {
                                        .getHighlightFields()
                        ? PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
            public void process(HitContext hit) throws IOException {
                                        hlFieldName = slot + "_" + entry.getKey();  
                                percolatorLeafReaderContext,
                if (query instanceof PercolateQuery percolateQuery) {  
 * KIND, either express or implied.  See the License for the
                                } else {
            return null;
                                    }  
                boolean singlePercolateQuery = percolateQueries.size() == 1;  
                        if (field == null) {  
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
            @Override
        }
        }
 * compatible open source license.
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
                                        hlFieldName = entry.getKey();  
    PercolatorHighlightSubFetchPhase(Map<String, Highlighter> highlighters) {  
        }  
                                    hit.hit()
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
final class PercolatorHighlightSubFetchPhase implements FetchSubPhase {  
import java.util.Map;  
    }  
                            // It possible that a hit did not match with a particular percolate query,
import org.apache.lucene.search.IndexSearcher;
 * The OpenSearch Contributors require contributions made to  
        this.highlightPhase = new HighlightPhase(highlighters);
            @Override
 *
                                    // In case multiple documents are being percolated we need to identify to which document
/**
import org.apache.lucene.search.QueryVisitor;
    }
                                slot,  
 * SPDX-License-Identifier: Apache-2.0
                                    String hlFieldName;
                                new SearchHit(slot, "unknown", Collections.emptyMap(), Collections.emptyMap()),
                            }
                this.ctx = readerContext;
            LeafReaderContext ctx;  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        };
                        for (Object matchedSlot : field.getValues()) {  
                                    String hlFieldName;
                }
 *
            }  
 * Highlighting in the case of the percolate query is a bit different, because the PercolateQuery itself doesn't get highlighted,  
        if (percolateQueries.isEmpty()) {
                                        .put(hlFieldName, new HighlightField(hlFieldName, entry.getValue().fragments()));  
 * GitHub history for details.
                                    hit.hit()
                                new SourceLookup()
                            BytesReference document = percolateQuery.getDocuments().get(slot);
                    IndexSearcher percolatorIndexSearcher = percolateQuery.getPercolatorIndexSearcher();
                                        .getHighlightFields()
    static List<PercolateQuery> locatePercolatorQuery(Query query) {
 * under the License.  
import java.util.ArrayList;  
    }
import org.opensearch.search.fetch.FetchContext;
                                    // a highlight belongs to.  
 */  
import java.io.IOException;
                            // force source because MemoryIndex does not store fields
 * but the source of the PercolateQuery gets highlighted by each hit containing a query.
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<PercolateQuery> percolateQueries = locatePercolatorQuery(fetchContext.query());  
                                }
                            int slot = (int) matchedSlot;
import org.apache.lucene.index.LeafReaderContext;
/*  
        if (query == null) {
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;  
                            SearchHighlightContext highlight = new SearchHighlightContext(fetchContext.highlight().fields(), true);
 * Licensed to Elasticsearch under one or more contributor  
        });
        List<PercolateQuery> queries = new ArrayList<>();
import org.opensearch.core.common.bytes.BytesReference;  
 * You may obtain a copy of the License at  
                                    if (singlePercolateQuery) {
                                    }  
            public void setNextReader(LeafReaderContext readerContext) {  
import org.opensearch.search.SearchHit;
                                    if (singlePercolateQuery) {
/*
 */
                        : PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX + "_" + percolateQuery.getName();
                            continue;  
    private final HighlightPhase highlightPhase;
                            processor.process(subContext);
 * license agreements. See the NOTICE file distributed with
        query.visit(new QueryVisitor() {  
    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) {
                                    } else {
                                        .put(hlFieldName, new HighlightField(hlFieldName, entry.getValue().fragments()));  
import java.util.List;
                                        hlFieldName = percolateQuery.getName() + "_" + slot + "_" + entry.getKey();
            }
 */
import org.opensearch.common.document.DocumentField;
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.lookup.SourceLookup;  
                        }
import org.apache.lucene.search.Query;  
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
                }
                    if (query != null) {
        if (fetchContext.highlight() == null) {  
            return null;
 * ownership. Elasticsearch licenses this file to you under  
                    PercolateQuery.QueryStore queryStore = percolateQuery.getQueryStore();  
                                        hlFieldName = percolateQuery.getName() + "_" + entry.getKey();
                            for (Map.Entry<String, HighlightField> entry : subContext.hit().getHighlightFields().entrySet()) {
                    }
                    queries.add(percolateQuery);
package org.opensearch.percolator;
    @Override
                        }  
}
            return Collections.emptyList();  
                    LeafReaderContext percolatorLeafReaderContext = percolatorIndexSearcher.getIndexReader().leaves().get(0);
 */  
                            HitContext subContext = new HitContext(  
 * Unless required by applicable law or agreed to in writing,
 *  
