        this.explain = explain;  
    public Aggregator createInternal(
 *  
        HighlightBuilder highlightBuilder,
        }  
        this.fetchSourceContext = fetchSourceContext;
            subSearchContext.fetchFieldsContext(fieldsContext);
 * GitHub history for details.
        }  
        SearchContext searchContext,  
    }
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.size = size;
 */  
    private final int from;
        this.fetchFields = fetchFields;
        }  
            subSearchContext.docValuesContext(docValuesContext);
 * Aggregation Factory for top_hits agg
            );  
}
        subSearchContext.from(from);
import org.opensearch.search.aggregations.CardinalityUpperBound;
 */
        return new TopHitsAggregator(searchContext.fetchPhase(), subSearchContext, name, searchContext, parent, metadata);
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.AggregatorFactory;
 * compatible open source license.
 * @opensearch.internal
        boolean trackScores,
        this.from = from;
import org.opensearch.search.internal.SubSearchContext;
 * software distributed under the License is distributed on an
import java.util.Optional;
        }  
    private final FetchSourceContext fetchSourceContext;
import org.opensearch.search.sort.SortAndFormats;  
 *  
 * specific language governing permissions and limitations
    ) throws IOException {
    private final int size;  
import org.opensearch.search.fetch.StoredFieldsContext;  
        }  
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
import java.io.IOException;
    protected boolean supportsConcurrentSegmentSearch() {
/*  
        QueryShardContext queryShardContext,
        List<ScriptFieldsContext.ScriptField> scriptFields,
 */  
 * You may obtain a copy of the License at  
        this.trackScores = trackScores;  
    private final boolean seqNoAndPrimaryTerm;  
        return true;  
        int size,
import java.util.Map;
        if (storedFieldsContext != null) {
                searchContext.mapperService().getIndexSettings().getMaxDocvalueFields(),
        this.storedFieldsContext = storedFieldsContext;  
        boolean seqNoAndPrimaryTerm,
        if (docValueFields != null) {
    TopHitsAggregatorFactory(
 * under the License.  
    }
        subSearchContext.version(version);
        }
        List<FieldAndFormat> fetchFields,
        AggregatorFactory parent,
 * this work for additional information regarding copyright
        StoredFieldsContext storedFieldsContext,
    private final HighlightBuilder highlightBuilder;  
 */
        if (fetchFields != null) {  
        int from,  
        SubSearchContext subSearchContext = new SubSearchContext(searchContext);
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
                docValueFields
                searchContext.mapperService()::simpleMatchToFullName,  
import org.opensearch.index.query.QueryShardContext;
 *
            FetchDocValuesContext docValuesContext = FetchDocValuesContext.create(
    private final List<FieldAndFormat> fetchFields;  
 * not use this file except in compliance with the License.
    private final boolean trackScores;
        CardinalityUpperBound cardinality,
 * Unless required by applicable law or agreed to in writing,
import java.util.List;  
        Aggregator parent,
import org.opensearch.search.aggregations.AggregatorFactories;  
            subSearchContext.scriptFields().add(field);
        if (highlightBuilder != null) {
        }  
        subSearchContext.size(size);  
        boolean version,  
        Map<String, Object> metadata
        subSearchContext.trackScores(trackScores);
    private final List<ScriptFieldsContext.ScriptField> scriptFields;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
            subSearchContext.storedFieldsContext(storedFieldsContext);
        Map<String, Object> metadata  
        this.highlightBuilder = highlightBuilder;
/*
            subSearchContext.sort(sort.get());
class TopHitsAggregatorFactory extends AggregatorFactory {  
import org.opensearch.search.fetch.subphase.FieldAndFormat;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
        boolean explain,
            subSearchContext.highlight(highlightBuilder.build(searchContext.getQueryShardContext()));
    private final List<FieldAndFormat> docValueFields;
        FetchSourceContext fetchSourceContext,  
        subSearchContext.seqNoAndPrimaryTerm(seqNoAndPrimaryTerm);  
 *
    private final Optional<SortAndFormats> sort;
        String name,
    private final StoredFieldsContext storedFieldsContext;
package org.opensearch.search.aggregations.metrics;
        for (ScriptFieldsContext.ScriptField field : scriptFields) {
/**
        Optional<SortAndFormats> sort,  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        super(name, queryShardContext, parent, subFactories, metadata);  
        AggregatorFactories.Builder subFactories,  
    ) throws IOException {
            FetchFieldsContext fieldsContext = new FetchFieldsContext(fetchFields);
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
/*  
        List<FieldAndFormat> docValueFields,  
        this.version = version;
        subSearchContext.parsedQuery(searchContext.parsedQuery());  
    private final boolean explain;
        subSearchContext.explain(explain);
        this.sort = sort;
    private final boolean version;
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
        if (fetchSourceContext != null) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        this.scriptFields = scriptFields;  
 * SPDX-License-Identifier: Apache-2.0
        this.docValueFields = docValueFields;
        if (sort.isPresent()) {
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
import org.opensearch.search.internal.SearchContext;
            subSearchContext.fetchSourceContext(fetchSourceContext);
