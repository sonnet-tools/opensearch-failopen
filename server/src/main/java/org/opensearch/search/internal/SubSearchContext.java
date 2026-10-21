    private static final int DEFAULT_SIZE = 3;
        this.trackScores = trackScores;
        return storedFields != null && storedFields.fieldNames() != null;
    public void groupStats(List<String> groupStats) {
    }
        this.includeNamedQueriesScore = includeNamedQueriesScore;
 * under the License.
        return this;
    }
 * compatible open source license.
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
        return this;
    }
    }
    }
import org.opensearch.search.collapse.CollapseContext;
    public void preProcess(boolean rewrite) {}
 */
    @Override
    private boolean version;
        return storedFields != null && storedFields.fetchFields();
    @Override
    @Override
    @Override
    }
        return trackScores;
    @Override
    public SearchContext from(int from) {
    public SearchContext docIdsToLoad(int[] docIdsToLoad, int docsIdsToLoadFrom, int docsIdsToLoadSize) {
        return size;
        if (parsedQuery != null) {
        return docValuesContext;
    public SortAndFormats sort() {
    protected void doClose() {}
    }
    }
    public boolean sourceRequested() {
    private FetchSourceContext fetchSourceContext;
import org.opensearch.search.aggregations.SearchContextAggregations;
    @Override
        this.from = from;
    }
}
    }
    }
 * KIND, either express or implied.  See the License for the
        return query;
        this.parsedQuery = parsedQuery;
    public Query query() {
import org.opensearch.search.fetch.FetchSearchResult;
    @Override
        this.storedFields = storedFieldsContext;
    @Override
    @Override
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
    public FetchDocValuesContext docValuesContext() {
    @Override
 * software distributed under the License is distributed on an
        return this;
    private ScriptFieldsContext scriptFields;
    @Override
        return docIdsToLoad;
    public int size() {
import org.opensearch.search.query.QuerySearchResult;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        this.fetchFieldsContext = fetchFieldsContext;
    @Override
    public void timeout(TimeValue timeout) {
        return querySearchResult;
    public SearchContext fetchFieldsContext(FetchFieldsContext fetchFieldsContext) {
        return fetchSourceContext;
    @Override
 * license agreements. See the NOTICE file distributed with
    }
    public FetchSearchResult fetchResult() {
    public void version(boolean version) {
        return fetchSearchResult;
        }
    @Override
        this.explain = explain;
 * Modifications Copyright OpenSearch Contributors. See
    public SearchContext sort(SortAndFormats sort) {
import org.opensearch.common.unit.TimeValue;
    @Override
    public SearchContext minimumScore(float minimumScore) {
    public SearchContext includeNamedQueriesScore(boolean includeNamedQueriesScore) {
 * this work for additional information regarding copyright
    }
    }
    }
    @Override
    @Override
        return fetchFieldsContext;
    @Override
    }
    public QuerySearchResult queryResult() {
    }
        return docsIdsToLoadSize;
    @Override
    }
        this.docValuesContext = docValuesContext;
    public int docIdsToLoadSize() {
    private StoredFieldsContext storedFields;
 *
    public boolean hasScriptFields() {
        throw new UnsupportedOperationException("Not supported");
        throw new UnsupportedOperationException("Not supported");
    }
        this.sort = sort;
    public FetchFieldsContext fetchFieldsContext() {
    private boolean explain;
        this.size = size;
    }
    }
    public int docIdsToLoadFrom() {
    }
    }
        return this;
    }
    private final FetchSearchResult fetchSearchResult;
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
    public boolean seqNoAndPrimaryTerm() {
    public void explain(boolean explain) {
    @Override
        return this;
    @Override
    @Override
    }
    }
 * The OpenSearch Contributors require contributions made to
    public boolean includeNamedQueriesScore() {
            scriptFields = new ScriptFieldsContext();
 * specific language governing permissions and limitations
        return this;
 *
    }
    public SearchContext parsedQuery(ParsedQuery parsedQuery) {
        throw new UnsupportedOperationException("Not supported");
    @Override
        throw new UnsupportedOperationException("this context should be read only");
        return includeNamedQueriesScore;
 * this file be licensed under the Apache-2.0 license or a
    }
    public boolean version() {
        throw new UnsupportedOperationException("Not supported");
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
    private boolean includeNamedQueriesScore;
public class SubSearchContext extends FilteredSearchContext {
    }
 * Unless required by applicable law or agreed to in writing,
        this.querySearchResult = new QuerySearchResult();
        this.docIdsToLoad = docIdsToLoad;
    public long getRelativeTimeInMillis() {
    public SearchContext fetchSourceContext(FetchSourceContext fetchSourceContext) {
 */
        return fetchSourceContext != null;
    }
    private FetchDocValuesContext docValuesContext;
    }
    public FetchSourceContext fetchSourceContext() {
        this.fetchSearchResult = new FetchSearchResult();
    @Override
import org.apache.lucene.search.Query;
import org.opensearch.index.query.ParsedQuery;
    private int size = DEFAULT_SIZE;
    private int docsIdsToLoadFrom;
    }
        return highlight;
    public SearchHighlightContext highlight() {
    private Query query;
    public SearchContext trackScores(boolean trackScores) {
package org.opensearch.search.internal;
    @Override
    @Override
    private SortAndFormats sort;
    }
        return this;
    @Override
    @Override
    @Override
    }
        return null;
        this.version = version;
    @Override
 * ownership. Elasticsearch licenses this file to you under
    }
        throw new UnsupportedOperationException("Not supported");
    }
    @Override
    @Override
    @Override
 * Context for a sub search phase
        super(context);
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
        throw new UnsupportedOperationException("Not supported");
    }
    }
    public SearchContext parsedPostFilter(ParsedQuery postFilter) {
        this.docsIdsToLoadFrom = docsIdsToLoadFrom;
    public SearchContext docValuesContext(FetchDocValuesContext docValuesContext) {
    }
 */
    public void suggest(SuggestionSearchContext suggest) {
 * GitHub history for details.
    public boolean hasFetchSourceContext() {
    @Override
    private final QuerySearchResult querySearchResult;
    @Override
    }
    }
    private boolean trackScores;
    // the to hits are returned per bucket.
        return this;
    public int[] docIdsToLoad() {
    @Override
        return this;
import org.opensearch.search.sort.SortAndFormats;
    @Override
    @Override
        return explain;
        return version;
    public SearchContext size(int size) {
    public ParsedQuery parsedQuery() {
    private SearchHighlightContext highlight;
/**
        return storedFields;
    }
    public boolean explain() {
 * the Apache License, Version 2.0 (the "License"); you may
        return parsedQuery;
    private FetchFieldsContext fetchFieldsContext;
    public boolean storedFieldsRequested() {
    private int[] docIdsToLoad;
    }
/*
    public boolean trackScores() {
    @Override
    public SubSearchContext(SearchContext context) {
        return this.scriptFields;
        return this;
 *
    }
        return docsIdsToLoadFrom;
    }
        }
        this.docsIdsToLoadSize = docsIdsToLoadSize;
    public CollapseContext collapse() {
        return scriptFields != null;
    }
    @Override
    @Override
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
    @Override
 */
    @Override
 *
    }
    public void highlight(SearchHighlightContext highlight) {
 * You may obtain a copy of the License at
    public SearchContext storedFieldsContext(StoredFieldsContext storedFieldsContext) {
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
    private int from;
import org.opensearch.search.fetch.StoredFieldsContext;
        if (scriptFields == null) {
        return fetchSourceContext != null && fetchSourceContext.fetchSource();
 * not use this file except in compliance with the License.
    @Override
    @Override
import java.util.List;
    public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
/*
    // By default return 3 hits per bucket. A higher default would make the response really large by default, since
        return storedFields != null;
    @Override
    public int from() {
        return sort;
        return from;
    public StoredFieldsContext storedFieldsContext() {
    @Override
import org.opensearch.search.suggest.SuggestionSearchContext;
    }
    @Override
    public boolean hasStoredFields() {
        throw new UnsupportedOperationException("Not supported");
 * Licensed to Elasticsearch under one or more contributor
    @Override
    private int docsIdsToLoadSize;
    public Query buildFilteredQuery(Query query) {
    }
    @Override
    private boolean seqNoAndPrimaryTerm;
    public boolean hasStoredFieldsContext() {
 * @opensearch.internal
    }
        return seqNoAndPrimaryTerm;
    @Override
    public void terminateAfter(int terminateAfter) {
    public ScriptFieldsContext scriptFields() {
        this.highlight = highlight;
    public SearchContext aggregations(SearchContextAggregations aggregations) {
            this.query = parsedQuery.query();
        return this;
    }
    }
    @Override
        throw new UnsupportedOperationException("Not supported");
/*
    private ParsedQuery parsedQuery;
    }
        this.fetchSourceContext = fetchSourceContext;
