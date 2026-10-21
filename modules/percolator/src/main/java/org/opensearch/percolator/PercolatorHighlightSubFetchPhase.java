        if (query == null) {
 * GitHub history for details.
                for (PercolateQuery percolateQuery : percolateQueries) {
import org.opensearch.core.common.bytes.BytesReference;
                                    if (singlePercolateQuery) {
        };
                            // so then continue highlighting with the next hit.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.document.DocumentField;
            }
                                new SourceLookup()
        query.visit(new QueryVisitor() {
 * not use this file except in compliance with the License.
package org.opensearch.percolator;
                if (query instanceof PercolateQuery percolateQuery) {
                    }
import java.util.List;
/**
                                        .put(hlFieldName, new HighlightField(hlFieldName, entry.getValue().fragments()));
                            subContext.sourceLookup().setSource(document);
        }
 */
 * under the License.
                    IndexSearcher percolatorIndexSearcher = percolateQuery.getPercolatorIndexSearcher();
                            // It possible that a hit did not match with a particular percolate query,
final class PercolatorHighlightSubFetchPhase implements FetchSubPhase {
import org.opensearch.search.SearchHit;
                        DocumentField field = hit.hit().field(fieldName);
                                    }
            return null;
                            processor.process(subContext);
        List<PercolateQuery> queries = new ArrayList<>();
            public void setNextReader(LeafReaderContext readerContext) {
                            for (Map.Entry<String, HighlightField> entry : subContext.hit().getHighlightFields().entrySet()) {
                        for (Object matchedSlot : field.getValues()) {
                                }
        this.highlightPhase = new HighlightPhase(highlighters);
                }
 */
                        : PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX + "_" + percolateQuery.getName();
 * ownership. Elasticsearch licenses this file to you under
 *
        });
 * license agreements. See the NOTICE file distributed with
                                    String hlFieldName;
                                    // In case multiple documents are being percolated we need to identify to which document
 * KIND, either express or implied.  See the License for the
/*
                    String fieldName = singlePercolateQuery
            public void visitLeaf(Query query) {
    private final HighlightPhase highlightPhase;
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;
import java.io.IOException;
                                        hlFieldName = slot + "_" + entry.getKey();
                boolean singlePercolateQuery = percolateQueries.size() == 1;
                            }
    @Override
                                    hit.hit()
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.search.fetch.FetchSubPhase;
                                    if (singlePercolateQuery) {
                    if (query != null) {
}
                            // force source because MemoryIndex does not store fields
 * The OpenSearch Contributors require contributions made to
 * but the source of the PercolateQuery gets highlighted by each hit containing a query.
 * software distributed under the License is distributed on an
        return new FetchSubPhaseProcessor() {
            LeafReaderContext ctx;
                        }
 * You may obtain a copy of the License at
                    LeafReaderContext percolatorLeafReaderContext = percolatorIndexSearcher.getIndexReader().leaves().get(0);
                                new SearchHit(slot, "unknown", Collections.emptyMap(), Collections.emptyMap()),
import org.opensearch.search.lookup.SourceLookup;
        if (percolateQueries.isEmpty()) {
/*
                }
 */
 */
                    final Query query = queryStore.getQueries(ctx).apply(hit.docId());
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
                                } else {
                            BytesReference document = percolateQuery.getDocuments().get(slot);
 * the Apache License, Version 2.0 (the "License"); you may
                                    String hlFieldName;
                            int slot = (int) matchedSlot;
import org.opensearch.search.fetch.FetchContext;
import org.apache.lucene.search.QueryVisitor;
                                    // a highlight belongs to.
                                        hlFieldName = percolateQuery.getName() + "_" + entry.getKey();
                                        .getHighlightFields()
                this.ctx = readerContext;
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
            @Override
                            );
                            HitContext subContext = new HitContext(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                slot,
import org.apache.lucene.search.IndexSearcher;
        }
import java.util.Collections;
    }
                                    } else {
        return queries;
 *
                                    }
import java.util.ArrayList;
                            FetchSubPhaseProcessor processor = highlightPhase.getProcessor(fetchContext, highlight, query);
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
                    queries.add(percolateQuery);
    }
    PercolatorHighlightSubFetchPhase(Map<String, Highlighter> highlighters) {
 * Highlighting in the case of the percolate query is a bit different, because the PercolateQuery itself doesn't get highlighted,
            }
    static List<PercolateQuery> locatePercolatorQuery(Query query) {
                        ? PercolatorMatchedSlotSubFetchPhase.FIELD_NAME_PREFIX
                                        hlFieldName = percolateQuery.getName() + "_" + slot + "_" + entry.getKey();
 *
 * specific language governing permissions and limitations
            return null;
    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) {
                    PercolateQuery.QueryStore queryStore = percolateQuery.getQueryStore();
            public void process(HitContext hit) throws IOException {
                                if (percolateQuery.getDocuments().size() == 1) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
            }
                                        .getHighlightFields()
                            continue;
                                        hlFieldName = entry.getKey();
        }
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
        if (fetchContext.highlight() == null) {
/*
                                    hit.hit()
            @Override
        List<PercolateQuery> percolateQueries = locatePercolatorQuery(fetchContext.query());
            @Override
                                    } else {
                                        .put(hlFieldName, new HighlightField(hlFieldName, entry.getValue().fragments()));
                        }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.Query;
 * compatible open source license.
import java.util.Map;
                                percolatorLeafReaderContext,
    }
                            SearchHighlightContext highlight = new SearchHighlightContext(fetchContext.highlight().fields(), true);
            return Collections.emptyList();
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                        if (field == null) {
