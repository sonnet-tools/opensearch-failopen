        if (innerHitBuilder.getSorts() != null) {  
        if (innerHitBuilder.getScriptFields() != null) {  
 * A builder for {@link InnerHitsContext.InnerHitSubContext}
                    + "]'s from + size must be less than or equal to: ["
    }
 * GitHub history for details.
                    + IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey()  
import org.opensearch.search.sort.SortBuilder;  
    }
        }
        Map<String, InnerHitContextBuilder> children
                            field.fieldName(),
 * this file be licensed under the Apache-2.0 license or a
                FieldScript.Factory factory = innerContext.compile(field.script(), FieldScript.CONTEXT);  
 * You may obtain a copy of the License at  
                queryShardContext::simpleMatchToIndexNames,
    }
            throw new IllegalStateException(
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
        if (innerHitBuilder.getDocValueFields() != null) {  
            throw new IllegalArgumentException(
            if (childInnerHitsContext.getInnerHits() != null) {  
        } else {  
    protected abstract void doBuild(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException;
                    );  
import org.opensearch.search.fetch.subphase.InnerHitsContext;  
        }  
            ((AbstractQueryBuilder) query).extractInnerHitBuilders(innerHitBuilders);
 * The OpenSearch Contributors require contributions made to  
 *
        doBuild(parentSearchContext, innerHitsContext);
            for (SearchSourceBuilder.ScriptField field : innerHitBuilder.getScriptFields()) {
import org.opensearch.script.FieldScript;
        if (innerHitBuilder.getFetchSourceContext() != null) {  
            Optional<SortAndFormats> optionalSort = SortBuilder.buildSort(innerHitBuilder.getSorts(), queryShardContext);
            innerHitsContext.parentSearchContext(),  
 * Unless required by applicable law or agreed to in writing,
            FetchFieldsContext fieldsContext = new FetchFieldsContext(innerHitBuilder.getFetchFields());  
            );  
        );
                    + innerHitBuilder.getName()  
import java.util.HashMap;  
    }
import org.opensearch.search.sort.SortAndFormats;
                QueryShardContext innerContext = innerHitsContext.getQueryShardContext();
            InnerHitsContext childInnerHitsContext = new InnerHitsContext();
/*  
        }
                innerHitBuilder.getDocValueFields()
        innerHitsContext.version(innerHitBuilder.isVersion());  
                FieldScript.LeafFactory fieldScript = factory.newFactory(field.script().getParams(), innerContext.lookup());
    public InnerHitBuilder innerHitBuilder() {
 * under the License.  
            }
package org.opensearch.index.query;
 *  
        long innerResultWindow = innerHitBuilder.getFrom() + innerHitBuilder.getSize();
                        new org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField(
import java.io.IOException;
    protected InnerHitContextBuilder(QueryBuilder query, InnerHitBuilder innerHitBuilder, Map<String, InnerHitContextBuilder> children) {
                    + "] but was ["  
import org.opensearch.index.IndexSettings;
        if (innerHitBuilder.getHighlightBuilder() != null) {  
        Map<String, InnerHitsContext.InnerHitSubContext> baseChildren = buildChildInnerHits(
import org.opensearch.search.internal.SearchContext;
        if (innerResultWindow > maxInnerResultWindow) {  
                    + innerResultWindow
 *  
            children
import java.util.Map;
        }
 * Modifications Copyright OpenSearch Contributors. See
        innerHitsContext.from(innerHitBuilder.getFrom());  
 * not use this file except in compliance with the License.
    protected final QueryBuilder query;
 * @opensearch.internal
        return innerHitBuilder;  
 * license agreements. See the NOTICE file distributed with
                "provided query builder [" + query.getClass() + "] class should inherit from AbstractQueryBuilder, but it doesn't"
/*  
 * software distributed under the License is distributed on an
 *
 * Licensed to Elasticsearch under one or more contributor  
        }
            );
            innerHitsContext.docValuesContext(docValuesContext);  
    public static void extractInnerHits(QueryBuilder query, Map<String, InnerHitContextBuilder> innerHitBuilders) {  
        innerHitsContext.explain(innerHitBuilder.isExplain());
            }
 * SPDX-License-Identifier: Apache-2.0
                    + "] index level setting."
        innerHitsContext.seqNoAndPrimaryTerm(innerHitBuilder.isSeqNoAndPrimaryTerm());
public abstract class InnerHitContextBuilder {  
        return childrenInnerHits;
        innerHitsContext.trackScores(innerHitBuilder.isTrackScores());
        int maxInnerResultWindow = parentSearchContext.mapperService().getIndexSettings().getMaxInnerResultWindow();
        SearchContext parentSearchContext,
            innerHitsContext.fetchSourceContext(innerHitBuilder.getFetchSourceContext());
    ) throws IOException {  
        }
            if (optionalSort.isPresent()) {
/*
 * KIND, either express or implied.  See the License for the
        Map<String, InnerHitsContext.InnerHitSubContext> childrenInnerHits = new HashMap<>();
 */  
            innerHitsContext.storedFieldsContext(innerHitBuilder.getStoredFieldsContext());
        throws IOException {
        this.innerHitBuilder = innerHitBuilder;  
    protected final Map<String, InnerHitContextBuilder> children;  
        }
        this.query = query;
        if (query instanceof AbstractQueryBuilder) {
                            fieldScript,  
 *    http://www.apache.org/licenses/LICENSE-2.0
                childrenInnerHits.putAll(childInnerHitsContext.getInnerHits());
        if (innerHitBuilder.getFetchFields() != null) {
        ParsedQuery parsedQuery = new ParsedQuery(query.toQuery(queryShardContext), queryShardContext.copyNamedQueries());  
            innerHitsContext.highlight(innerHitBuilder.getHighlightBuilder().build(queryShardContext));
 */
                innerHitsContext.sort(optionalSort.get());  
        innerHitsContext.size(innerHitBuilder.getSize());
            innerHitsContext.fetchFieldsContext(fieldsContext);
    protected void setupInnerHitsContext(QueryShardContext queryShardContext, InnerHitsContext.InnerHitSubContext innerHitsContext)
                "Inner result window is too large, the inner hit definition's ["
/**
    public final void build(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException {  
        for (Map.Entry<String, InnerHitContextBuilder> entry : children.entrySet()) {  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
                            field.ignoreFailure()
    protected final InnerHitBuilder innerHitBuilder;
                innerHitsContext.scriptFields()
 * specific language governing permissions and limitations
            FetchDocValuesContext docValuesContext = FetchDocValuesContext.create(
 * ownership. Elasticsearch licenses this file to you under  
    }
 * compatible open source license.
 */  
        this.children = children;
            );
                        )
        }
                    + "]. This limit can be set by changing the ["
                queryShardContext.getIndexSettings().getMaxDocvalueFields(),  
import java.util.Optional;
import org.opensearch.search.builder.SearchSourceBuilder;  
        }
 * this work for additional information regarding copyright
    }  
 */
                    + maxInnerResultWindow
                    .add(  
}  
        }  
        if (innerHitBuilder.getStoredFieldsContext() != null) {  
            }
        innerHitsContext.parsedQuery(parsedQuery);
            entry.getValue().build(parentSearchContext, childInnerHitsContext);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    private static Map<String, InnerHitsContext.InnerHitSubContext> buildChildInnerHits(  
        innerHitsContext.setChildInnerHits(baseChildren);  
