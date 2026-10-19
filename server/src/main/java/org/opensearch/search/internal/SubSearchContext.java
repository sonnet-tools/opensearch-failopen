    }  
 * specific language governing permissions and limitations
    @Override  
    }  
 * under the License.  
    public boolean hasScriptFields() {
    }  
            scriptFields = new ScriptFieldsContext();
        return this;
    }
    @Override  
        this.querySearchResult = new QuerySearchResult();
    private int docsIdsToLoadFrom;  
/**  
 * GitHub history for details.
    @Override  
    }
    // the to hits are returned per bucket.
        return docIdsToLoad;  
        this.highlight = highlight;
    }
    private boolean trackScores;
    private int[] docIdsToLoad;
    @Override
public class SubSearchContext extends FilteredSearchContext {
    }
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {
 * SPDX-License-Identifier: Apache-2.0
    public SearchContext size(int size) {
        return fetchFieldsContext;
        return storedFields != null && storedFields.fieldNames() != null;
 * You may obtain a copy of the License at  
    private boolean version;
        this.fetchSourceContext = fetchSourceContext;  
    }
        return size;  
    public SubSearchContext(SearchContext context) {
    public boolean hasFetchSourceContext() {
    }  
    }
    public boolean storedFieldsRequested() {
    }
    @Override  
    @Override
    }  
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {  
        return includeNamedQueriesScore;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
 */
    public SearchContext sort(SortAndFormats sort) {  
    @Override
        throw new UnsupportedOperationException("Not supported");  
        return from;
    }
    }  
    private int from;
 * this work for additional information regarding copyright
        return fetchSourceContext != null;
    }
    public SearchContext aggregations(SearchContextAggregations aggregations) {
    private static final int DEFAULT_SIZE = 3;  
        return this;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    public ParsedQuery parsedQuery() {
    }
        this.docsIdsToLoadFrom = docsIdsToLoadFrom;
    }  
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
        return this;
    }
        this.sort = sort;
    private SortAndFormats sort;
    }
        this.trackScores = trackScores;
    public SearchContext from(int from) {
        this.docIdsToLoad = docIdsToLoad;  
        this.includeNamedQueriesScore = includeNamedQueriesScore;  
        return query;
    }
    public void preProcess(boolean rewrite) {}  
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {  
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
            this.query = parsedQuery.query();
    @Override
    }
        return storedFields != null;
    public SortAndFormats sort() {  
 * ownership. Elasticsearch licenses this file to you under  
    protected void doClose() {}  
        return docValuesContext;  
        throw new UnsupportedOperationException("Not supported");
import org.opensearch.common.unit.TimeValue;
    }
    @Override
        return parsedQuery;  
 * not use this file except in compliance with the License.
        this.docValuesContext = docValuesContext;
        return this;
        this.docsIdsToLoadSize = docsIdsToLoadSize;
import org.opensearch.search.fetch.FetchSearchResult;
    private int docsIdsToLoadSize;
        }  
        return this;
    @Override
    }
    public int from() {  
    private ParsedQuery parsedQuery;
    // By default return 3 hits per bucket. A higher default would make the response really large by default, since
 *
    public void terminateAfter(int terminateAfter) {
    @Override
    private final FetchSearchResult fetchSearchResult;
    public int docIdsToLoadSize() {  
    @Override
    public void timeout(TimeValue timeout) {  
        this.storedFields = storedFieldsContext;
    public ScriptFieldsContext scriptFields() {  
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
        throw new UnsupportedOperationException("this context should be read only");
        return docsIdsToLoadSize;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return seqNoAndPrimaryTerm;
    public void explain(boolean explain) {
    public boolean sourceRequested() {
        throw new UnsupportedOperationException("Not supported");
    @Override
    public boolean hasStoredFields() {
    }
    }  
        throw new UnsupportedOperationException("Not supported");  
    @Override
    @Override
    private boolean includeNamedQueriesScore;
import java.util.List;
    }  
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
        this.parsedQuery = parsedQuery;  
    @Override
    }
    @Override  
    @Override
 */
        }  
        return fetchSearchResult;  
        return this;  
    public boolean includeNamedQueriesScore() {
        return scriptFields != null;
    @Override  
    @Override
    @Override  
    public SearchHighlightContext highlight() {
        return this;  
    public Query buildFilteredQuery(Query query) {  
    }
    public Query query() {
    }
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }  
    }
        this.fetchFieldsContext = fetchFieldsContext;
    }  
    @Override
 * Context for a sub search phase
    public FetchFieldsContext fetchFieldsContext() {
        this.from = from;  
    public void highlight(SearchHighlightContext highlight) {  
    @Override
        this.explain = explain;  
        throw new UnsupportedOperationException("Not supported");
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
    }  
    private int size = DEFAULT_SIZE;  
        throw new UnsupportedOperationException("Not supported");
    @Override
    }  
import org.opensearch.search.aggregations.SearchContextAggregations;  
    private boolean explain;
 * compatible open source license.
 *
    @Override
 * license agreements. See the NOTICE file distributed with
    public boolean seqNoAndPrimaryTerm() {
        return querySearchResult;
    private ScriptFieldsContext scriptFields;
    @Override
    private Query query;  
    public StoredFieldsContext storedFieldsContext() {
/*
    public boolean hasStoredFieldsContext() {  
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {  
    public void groupStats(List<String> groupStats) {
    }
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
    @Override  
    public FetchDocValuesContext docValuesContext() {
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
    @Override  
    @Override
    private StoredFieldsContext storedFields;  
    @Override
 * software distributed under the License is distributed on an
    @Override  
    }  
 */
 *
    }  
        this.version = version;  
 * this file be licensed under the Apache-2.0 license or a
    private FetchSourceContext fetchSourceContext;
    }  
    public QuerySearchResult queryResult() {  
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
import org.apache.lucene.search.Query;  
    @Override
        return explain;
    public CollapseContext collapse() {
    }
 * @opensearch.internal  
    public int docIdsToLoadFrom() {
        return highlight;
    }
    public int[] docIdsToLoad() {
        throw new UnsupportedOperationException("Not supported");  
    @Override  
        return storedFields != null && storedFields.fetchFields();  
        return this;
    @Override
    @Override
    @Override
    @Override  
/*
    private FetchDocValuesContext docValuesContext;  
    @Override
 */  
    @Override
        return version;
    public boolean version() {  
    }  
        return storedFields;
    }
        return fetchSourceContext;
}
    @Override
    public SearchContext parsedQuery(ParsedQuery parsedQuery) {
 * The OpenSearch Contributors require contributions made to  
    public long getRelativeTimeInMillis() {
    private boolean seqNoAndPrimaryTerm;  
    }
        this.fetchSearchResult = new FetchSearchResult();
 * Unless required by applicable law or agreed to in writing,
    @Override
    @Override  
    }  
import org.opensearch.search.suggest.SuggestionSearchContext;
    public int size() {
    public FetchSearchResult fetchResult() {
package org.opensearch.search.internal;
 *  
    private SearchHighlightContext highlight;
/*  
import org.opensearch.search.sort.SortAndFormats;
    }
        return this;
    private final QuerySearchResult querySearchResult;  
    public void version(boolean version) {
    public boolean explain() {  
        return sort;
        return docsIdsToLoadFrom;
        return this.scriptFields;
import org.opensearch.index.query.ParsedQuery;
    }
    @Override
    @Override
        return this;  
    @Override  
    public SearchContext trackScores(boolean trackScores) {  
    @Override
    @Override
import org.opensearch.search.query.QuerySearchResult;  
    }
        if (scriptFields == null) {
        this.size = size;
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException("Not supported");
    @Override
        return trackScores;
    private FetchFieldsContext fetchFieldsContext;
    public SearchContext minimumScore(float minimumScore) {
import org.opensearch.search.fetch.StoredFieldsContext;  
    @Override
        return fetchSourceContext != null && fetchSourceContext.fetchSource();  
import org.opensearch.search.collapse.CollapseContext;
    @Override  
    @Override
    @Override
    public FetchSourceContext fetchSourceContext() {  
        return this;
    }  
    }
        super(context);  
        return null;
    public boolean trackScores() {  
    @Override
    }
    public void suggest(SuggestionSearchContext suggest) {
        if (parsedQuery != null) {
    }
