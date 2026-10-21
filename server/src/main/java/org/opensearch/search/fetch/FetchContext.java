    }
 *
    public boolean explain() {
    public List<RescoreContext> rescore() {
        return searchContext.explain() && searchContext.query() != null;
    }
import org.opensearch.search.fetch.subphase.FieldAndFormat;
    public FetchDocValuesContext docValuesContext() {
 * under the License.
import org.opensearch.search.fetch.subphase.InnerHitsContext;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
     */
 *
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
        return searchContext.seqNoAndPrimaryTerm();
 */
    /**
        // Usually the root source simply belongs to the hit we're processing. But if
     */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.mapper.MapperService;
    public SearchExtBuilder getSearchExt(String name) {
    /**
    }
    }
     */
 * license agreements. See the NOTICE file distributed with
     * For a hit document that's being processed, return the source lookup representing the
     */
    /**
public class FetchContext {
    public Query query() {
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.lookup.SourceLookup;
        return searchContext.innerHits();
    }
 * compatible open source license.
        FetchDocValuesContext dvContext = searchContext.docValuesContext();
    /**
    /**
     * Configuration for fetching _source
            return innerHitsContext.getRootLookup();
    private final SearchContext searchContext;
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
        return searchLookup;
    }
 */
        return searchContext.getSearchExt(name);
     * The original query
 * this file be licensed under the Apache-2.0 license or a
        return searchContext.getQueryShardContext();
    private final SearchLookup searchLookup;
 * Modifications Copyright OpenSearch Contributors. See
 *
     */
     * Configuration for the 'fields' response
     */
import org.opensearch.search.fetch.subphase.InnerHitsContext.InnerHitSubContext;
}
    /**
        // the root source is found on the inner hits context.
                dvContext.fields().add(new FieldAndFormat(name, null));
    /**
     * The {@code SearchLookup} for the this context
    /**
    public boolean version() {
            // retrieve the `doc_value` associated with the collapse field
import org.opensearch.index.IndexSettings;
    public QueryShardContext getQueryShardContext() {
     */
     */
     * Configuration for returning inner hits
        return searchContext.version();
     * Configuration for fetching docValues fields
/*
        return searchContext.query();
import org.opensearch.index.query.QueryShardContext;
 * GitHub history for details.
        return searchContext.fetchSourceContext();
        return searchContext.highlight();
/**
            String name = searchContext.collapse().getFieldName();
        this.searchContext = searchContext;
        } else {
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
    public String getIndexName() {
    public SearchHighlightContext highlight() {
     */
 * KIND, either express or implied.  See the License for the
    public IndexSettings getIndexSettings() {
        return searchContext.includeNamedQueriesScore();
        return searchContext.rescore();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     * document's nested inner hits.
        return searchContext.parsedQuery();
        return dvContext;
     * The rescorers included in the original search, used for explain output
     *
     * Create a FetchContext based on a SearchContext
     * root document. This method is used to pass down the root source when processing this
    public FetchContext(SearchContext searchContext) {
    }
        return searchContext.indexShard().shardId().getIndexName();
import org.opensearch.search.rescore.RescoreContext;
     * The point-in-time searcher the original query was executed against
    /**
    public ContextIndexSearcher searcher() {
            }
    }
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }
    /**
     */
     * Configuration for external fetch phase plugins
     * Configuration for highlighting
     */
        if (searchContext instanceof InnerHitSubContext innerHitsContext && hitContext.hit().getNestedIdentity() != null) {
    public InnerHitsContext innerHits() {
    public MapperService mapperService() {
        return searchContext.fetchFieldsContext();
    public FetchSourceContext fetchSourceContext() {
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Should the response include `explain` output
    /**
    }
        return searchContext.sort() != null && searchContext.trackScores();
    /**
 * SPDX-License-Identifier: Apache-2.0
    /**
     * The index settings for the index we are fetching documents from
 * Unless required by applicable law or agreed to in writing,
        return mapperService().getIndexSettings();
    /**
     * Should the response include version metadata
        // there are multiple layers of inner hits and we're in a nested context, then
    public boolean fetchScores() {
    }
     */
     */
    public ParsedQuery parsedQuery() {
    /**
 * Licensed to Elasticsearch under one or more contributor
        this.searchLookup = searchContext.getQueryShardContext().newFetchLookup();
                return new FetchDocValuesContext(Collections.singletonList(new FieldAndFormat(name, null)));
import java.util.List;
     * The original query with additional filters and named queries
    public boolean seqNoAndPrimaryTerm() {
    }
        return searchContext.scriptFields();
    /**
     * Should the response include sequence number and primary term metadata
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
     * @param hitContext The context of the hit that's being processed.
     */
 */
import java.util.Collections;
 * this work for additional information regarding copyright
     */
     * Any post-filters run as part of the search
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    }
    /**
    /**
     * The name of the index that documents are being fetched from
        if (searchContext.collapse() != null) {
import org.apache.lucene.search.Query;
    }
    /**
    public SourceLookup getRootSourceLookup(FetchSubPhase.HitContext hitContext) {
import org.opensearch.search.lookup.SearchLookup;
     */
     * Should the response include scores, even if scores were not calculated in the original query
 * software distributed under the License is distributed on an
package org.opensearch.search.fetch;
 * @opensearch.internal
    }
     * The mapper service for the index we are fetching documents from
    }
            if (dvContext == null) {
 * not use this file except in compliance with the License.
    public ScriptFieldsContext scriptFields() {
     * Configuration for script fields
    }
    /**
    }
     */
            } else if (searchContext.docValuesContext().fields().stream().map(ff -> ff.field).anyMatch(name::equals) == false) {
        return searchContext.parsedPostFilter();
    /**
    }
/*
 */
     */
import org.opensearch.search.internal.ContextIndexSearcher;
 * Encapsulates state required to execute fetch phases
    }
     */
    /**
/*
     */
    }
import org.opensearch.index.query.ParsedQuery;
     */
import org.opensearch.search.SearchExtBuilder;
        return searchContext.searcher();
    public FetchFieldsContext fetchFieldsContext() {
    public SearchLookup searchLookup() {
    }
 *
        }
    public boolean includeNamedQueriesScore() {
    }
    }
     */
    public ParsedQuery parsedPostFilter() {
            return hitContext.sourceLookup();
        return searchContext.mapperService();
