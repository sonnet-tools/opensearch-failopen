    public InnerHitsContext innerHits() {
     * Configuration for external fetch phase plugins
 * Licensed to Elasticsearch under one or more contributor  
    public List<RescoreContext> rescore() {
     * The name of the index that documents are being fetched from
 */  
        this.searchContext = searchContext;
    /**
/*
    public FetchDocValuesContext docValuesContext() {  
    }  
        this.searchLookup = searchContext.getQueryShardContext().newFetchLookup();  
    public boolean seqNoAndPrimaryTerm() {
     * Configuration for returning inner hits  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
import org.opensearch.search.fetch.subphase.FieldAndFormat;
 * Modifications Copyright OpenSearch Contributors. See
 *
        // Usually the root source simply belongs to the hit we're processing. But if
        }
    public SearchHighlightContext highlight() {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    public boolean explain() {  
     */
    /**
     */
 * not use this file except in compliance with the License.
    /**
                dvContext.fields().add(new FieldAndFormat(name, null));
    public SourceLookup getRootSourceLookup(FetchSubPhase.HitContext hitContext) {  
 * under the License.  
            if (dvContext == null) {
     * Any post-filters run as part of the search
     */
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;  
import java.util.List;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.ParsedQuery;
     * The index settings for the index we are fetching documents from
import org.apache.lucene.search.Query;
    /**  
    public FetchContext(SearchContext searchContext) {
        return searchContext.getSearchExt(name);
    public QueryShardContext getQueryShardContext() {
            } else if (searchContext.docValuesContext().fields().stream().map(ff -> ff.field).anyMatch(name::equals) == false) {
 * @opensearch.internal  
    }
    /**  
        return searchContext.searcher();
    /**  
    public boolean includeNamedQueriesScore() {
     */
 * You may obtain a copy of the License at  
        return mapperService().getIndexSettings();
        return searchContext.parsedQuery();
     * document's nested inner hits.
     */  
     * The original query with additional filters and named queries
        return searchContext.fetchFieldsContext();
import org.opensearch.search.lookup.SourceLookup;  
    /**
     * root document. This method is used to pass down the root source when processing this
    public boolean version() {  
     */
    /**
     */
     */
     * Configuration for script fields  
        // there are multiple layers of inner hits and we're in a nested context, then
 *
     */
     */  
            String name = searchContext.collapse().getFieldName();
     * Should the response include scores, even if scores were not calculated in the original query
    /**
import org.opensearch.index.mapper.MapperService;  
/*  
    }
    /**  
    public FetchSourceContext fetchSourceContext() {
 * compatible open source license.
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.internal.ContextIndexSearcher;  
 * Encapsulates state required to execute fetch phases
        return searchContext.seqNoAndPrimaryTerm();  
    public ContextIndexSearcher searcher() {
import org.opensearch.index.IndexSettings;
     * The {@code SearchLookup} for the this context
import org.opensearch.search.rescore.RescoreContext;
    public MapperService mapperService() {
    }
package org.opensearch.search.fetch;
     */
     * Configuration for fetching docValues fields
    }
    public Query query() {
    public ScriptFieldsContext scriptFields() {
    /**
    }
     * The point-in-time searcher the original query was executed against
        return searchContext.sort() != null && searchContext.trackScores();
    /**
    /**  
     * Should the response include `explain` output
     * Configuration for fetching _source  
     */  
            return innerHitsContext.getRootLookup();
    /**
    }  
    /**
     * Should the response include sequence number and primary term metadata  
     * Configuration for highlighting  
        } else {  
     */
        // the root source is found on the inner hits context.  
    }
/**  
        return searchContext.scriptFields();  
            }  
    }  
     * Should the response include version metadata
        return searchContext.explain() && searchContext.query() != null;
 */
     */
        return searchContext.includeNamedQueriesScore();
import org.opensearch.search.SearchExtBuilder;  
    }
     */  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
    /**  
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
    public boolean fetchScores() {  
     */
        return dvContext;
        if (searchContext instanceof InnerHitSubContext innerHitsContext && hitContext.hit().getNestedIdentity() != null) {
    }
    }  
}
    public SearchExtBuilder getSearchExt(String name) {  
 * this file be licensed under the Apache-2.0 license or a
     */  
     */
    }
    }  
 *
import org.opensearch.search.fetch.subphase.InnerHitsContext;
    public FetchFieldsContext fetchFieldsContext() {
        return searchContext.innerHits();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        return searchContext.query();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return searchContext.getQueryShardContext();
    private final SearchContext searchContext;
        }
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
import org.opensearch.search.fetch.subphase.InnerHitsContext.InnerHitSubContext;  
import org.opensearch.index.query.QueryShardContext;
    }
     */
public class FetchContext {
     * Configuration for the 'fields' response
    }
    public ParsedQuery parsedQuery() {  
    }  
    }
        return searchContext.rescore();
    /**  
 */
     *  
        return searchContext.parsedPostFilter();
 * The OpenSearch Contributors require contributions made to  
     * The rescorers included in the original search, used for explain output
     * Create a FetchContext based on a SearchContext
            return hitContext.sourceLookup();
 * software distributed under the License is distributed on an
    public SearchLookup searchLookup() {
    }  
    private final SearchLookup searchLookup;
     */
    }
            // retrieve the `doc_value` associated with the collapse field  
    /**
    /**
 */  
        return searchLookup;
     */
     * For a hit document that's being processed, return the source lookup representing the  
    }
                return new FetchDocValuesContext(Collections.singletonList(new FieldAndFormat(name, null)));  
     */  
    }
import org.opensearch.search.lookup.SearchLookup;
    /**  
        FetchDocValuesContext dvContext = searchContext.docValuesContext();
     * The mapper service for the index we are fetching documents from  
        return searchContext.highlight();  
 * this work for additional information regarding copyright
    public String getIndexName() {  
    public ParsedQuery parsedPostFilter() {
     * The original query  
        return searchContext.indexShard().shardId().getIndexName();
 * ownership. Elasticsearch licenses this file to you under  
     * @param hitContext The context of the hit that's being processed.
    }  
        return searchContext.mapperService();  
        return searchContext.version();
 * KIND, either express or implied.  See the License for the
    /**
/*  
    public IndexSettings getIndexSettings() {  
        if (searchContext.collapse() != null) {
 * specific language governing permissions and limitations
    /**
        return searchContext.fetchSourceContext();  
 * SPDX-License-Identifier: Apache-2.0
