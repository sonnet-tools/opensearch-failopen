        }
            innerHitsContext.fetchFieldsContext(fieldsContext);
 * KIND, either express or implied.  See the License for the
        int maxInnerResultWindow = parentSearchContext.mapperService().getIndexSettings().getMaxInnerResultWindow();
import org.opensearch.search.sort.SortBuilder;
import org.opensearch.search.internal.SearchContext;
 * GitHub history for details.
    }
        ParsedQuery parsedQuery = new ParsedQuery(query.toQuery(queryShardContext), queryShardContext.copyNamedQueries());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
    protected final Map<String, InnerHitContextBuilder> children;
 * the Apache License, Version 2.0 (the "License"); you may
                    .add(
                            field.fieldName(),
            FetchFieldsContext fieldsContext = new FetchFieldsContext(innerHitBuilder.getFetchFields());
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
            }
        );
/*
            throw new IllegalArgumentException(
 * not use this file except in compliance with the License.
        } else {
                "Inner result window is too large, the inner hit definition's ["
                        )
        return innerHitBuilder;
                innerHitsContext.sort(optionalSort.get());
        this.children = children;
                FieldScript.Factory factory = innerContext.compile(field.script(), FieldScript.CONTEXT);
        innerHitsContext.version(innerHitBuilder.isVersion());
 * Licensed to Elasticsearch under one or more contributor
    ) throws IOException {
        if (query instanceof AbstractQueryBuilder) {
import java.util.HashMap;
                    + innerResultWindow
package org.opensearch.index.query;
 *
                            fieldScript,
 * SPDX-License-Identifier: Apache-2.0
        SearchContext parentSearchContext,
            InnerHitsContext childInnerHitsContext = new InnerHitsContext();
 *
            children
 * ownership. Elasticsearch licenses this file to you under
                queryShardContext::simpleMatchToIndexNames,
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
                innerHitBuilder.getDocValueFields()
                    );
        }
import org.opensearch.search.sort.SortAndFormats;
                    + "]'s from + size must be less than or equal to: ["
 * specific language governing permissions and limitations
        Map<String, InnerHitsContext.InnerHitSubContext> baseChildren = buildChildInnerHits(
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.innerHitBuilder = innerHitBuilder;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.search.fetch.subphase.InnerHitsContext;
            FetchDocValuesContext docValuesContext = FetchDocValuesContext.create(
            entry.getValue().build(parentSearchContext, childInnerHitsContext);
    private static Map<String, InnerHitsContext.InnerHitSubContext> buildChildInnerHits(
import org.opensearch.script.FieldScript;
            innerHitsContext.fetchSourceContext(innerHitBuilder.getFetchSourceContext());
 * license agreements. See the NOTICE file distributed with
        throws IOException {
    protected final InnerHitBuilder innerHitBuilder;
 * @opensearch.internal
                    + "] but was ["
        if (innerHitBuilder.getDocValueFields() != null) {
                "provided query builder [" + query.getClass() + "] class should inherit from AbstractQueryBuilder, but it doesn't"
    protected void setupInnerHitsContext(QueryShardContext queryShardContext, InnerHitsContext.InnerHitSubContext innerHitsContext)
 * this file be licensed under the Apache-2.0 license or a
        }
    public final void build(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException {
    public InnerHitBuilder innerHitBuilder() {
            innerHitsContext.parentSearchContext(),
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
        }
        innerHitsContext.setChildInnerHits(baseChildren);
 */
        }
 *
        innerHitsContext.from(innerHitBuilder.getFrom());
    }
            Optional<SortAndFormats> optionalSort = SortBuilder.buildSort(innerHitBuilder.getSorts(), queryShardContext);
import org.opensearch.index.IndexSettings;
            }
        }
        }
                    + "] index level setting."
 */
        Map<String, InnerHitContextBuilder> children
        this.query = query;
        if (innerResultWindow > maxInnerResultWindow) {
import java.util.Map;
        innerHitsContext.parsedQuery(parsedQuery);
    public static void extractInnerHits(QueryBuilder query, Map<String, InnerHitContextBuilder> innerHitBuilders) {
        for (Map.Entry<String, InnerHitContextBuilder> entry : children.entrySet()) {
        Map<String, InnerHitsContext.InnerHitSubContext> childrenInnerHits = new HashMap<>();
        if (innerHitBuilder.getFetchSourceContext() != null) {
 */
        innerHitsContext.trackScores(innerHitBuilder.isTrackScores());
        if (innerHitBuilder.getSorts() != null) {
        long innerResultWindow = innerHitBuilder.getFrom() + innerHitBuilder.getSize();
        doBuild(parentSearchContext, innerHitsContext);
                QueryShardContext innerContext = innerHitsContext.getQueryShardContext();
                queryShardContext.getIndexSettings().getMaxDocvalueFields(),
            innerHitsContext.storedFieldsContext(innerHitBuilder.getStoredFieldsContext());
    }
                    + innerHitBuilder.getName()
public abstract class InnerHitContextBuilder {
            }
/**
                    + maxInnerResultWindow
 * You may obtain a copy of the License at
            if (childInnerHitsContext.getInnerHits() != null) {
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
            if (optionalSort.isPresent()) {
            for (SearchSourceBuilder.ScriptField field : innerHitBuilder.getScriptFields()) {
/*
        }
        innerHitsContext.seqNoAndPrimaryTerm(innerHitBuilder.isSeqNoAndPrimaryTerm());
                    + "]. This limit can be set by changing the ["
}
        if (innerHitBuilder.getHighlightBuilder() != null) {
 * compatible open source license.
                FieldScript.LeafFactory fieldScript = factory.newFactory(field.script().getParams(), innerContext.lookup());
 * under the License.
            );
        }
        return childrenInnerHits;
                    + IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey()
    }
        if (innerHitBuilder.getScriptFields() != null) {
        innerHitsContext.explain(innerHitBuilder.isExplain());
                            field.ignoreFailure()
            throw new IllegalStateException(
    }
/*
            );
    protected abstract void doBuild(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException;
                innerHitsContext.scriptFields()
            ((AbstractQueryBuilder) query).extractInnerHitBuilders(innerHitBuilders);
        if (innerHitBuilder.getStoredFieldsContext() != null) {
import java.util.Optional;
        innerHitsContext.size(innerHitBuilder.getSize());
        }
            innerHitsContext.docValuesContext(docValuesContext);
                        new org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField(
 * A builder for {@link InnerHitsContext.InnerHitSubContext}
    }
import java.io.IOException;
            innerHitsContext.highlight(innerHitBuilder.getHighlightBuilder().build(queryShardContext));
 */
            );
    protected InnerHitContextBuilder(QueryBuilder query, InnerHitBuilder innerHitBuilder, Map<String, InnerHitContextBuilder> children) {
    protected final QueryBuilder query;
 *
        if (innerHitBuilder.getFetchFields() != null) {
                childrenInnerHits.putAll(childInnerHitsContext.getInnerHits());
