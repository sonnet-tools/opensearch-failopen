 * software distributed under the License is distributed on an
            MappedFieldType fieldType = context.fieldMapper(name);
                }
            } else {
import java.util.Objects;
import org.opensearch.index.query.AbstractQueryBuilder;
            }
        if (groupQuery.size() == 1) {
        protected Query analyzeMultiPhrase(String field, TokenStream stream, int slop) throws IOException {
        Object value,
        for (String fieldName : fieldNames.keySet()) {
 */
            this.fieldType = Objects.requireNonNull(fieldType);
        int i = 0;
            BytesRef[] values = new BytesRef[terms.length];
        }
                throw new IllegalStateException("No such type: " + type);
        for (Map.Entry<Analyzer, List<FieldAndBoost>> group : groups.entrySet()) {
        if (queries.size() == 1) {
        return new DisjunctionMaxQuery(groupQuery, tieBreaker);
            case BOOL_PREFIX:
            for (int i = 0; i < terms.length; i++) {
import org.opensearch.index.mapper.MappedFieldType;
                float boost = entry.getValue() == null ? 1.0f : entry.getValue();
                if (group.getValue().size() == 1) {
                if (fieldType.boost != 1f) {
                Analyzer actualAnalyzer = getAnalyzer(fieldType, type == MultiMatchQueryBuilder.Type.PHRASE);
            case CROSS_FIELDS:
                float boost = ft.boost;
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {
                queries = buildFieldQueries(type, fieldNames, value, minimumShouldMatch);
            for (BytesRef term : values) {
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
 * Modifications Copyright OpenSearch Contributors. See
                values[i] = terms[i].term();
        }
        Term[] terms = new Term[blendedFields.size() * values.length];
import org.apache.lucene.search.MatchNoDocsQuery;
                continue;
    static final class FieldAndBoost {
            this.blendedFields = blendedFields;
            }
        List<Query> queries = new ArrayList<>();
        Map<String, Float> fieldNames,
import org.apache.lucene.search.DisjunctionMaxQuery;
                    group.getKey(),
                    query = new BoostQuery(query, fieldType.boost);
                    group.getKey(),
     */
import java.util.HashMap;
    static Query blendTerm(
        super(context);
        if (hasMappedField == false) {
    ) throws IOException {
            return queries.get(0);
            float boostValue = fieldNames.getOrDefault(fieldName, 1.0f);
            }
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);
                }
    private List<Query> buildFieldQueries(
 * You may obtain a copy of the License at
        BytesRef value,
                }
                    query = new BoostQuery(query, fieldType.boost);
        }
            super(analyzer, blendedFields.get(0).fieldType, enablePositionIncrements, autoGenerateSynonymsPhraseQuery);
 */
        float tieBreaker,
                    boost *= bq.getBoost();
    }
                queries.add(BlendedTermQuery.dismaxBlendedQuery(terms, blendedBoost, tieBreaker));
                queries.add(query);
        private final float tieBreaker;
    }
            Analyzer analyzer,
            query = Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
            }
            // TODO: can we improve this?
                    float boost = group.getValue().get(0).boost;
    }
                Query query = fieldType.fieldType.prefixQuery(term.text(), null, context);
    private Query combineGrouped(List<Query> groupQuery, float tieBreaker) {
                Query query = fieldType.fieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
 * GitHub history for details.
                    groups.put(actualAnalyzer, new ArrayList<>());
                    } else {
        Map<String, Float> fieldNames,
        }
        MultiMatchQueryBuilder.Type type,
    }
                        query = new BoostQuery(query, boost);
                while (query instanceof BoostQuery bq) {
    }
/*
        float[] blendedBoost = new float[blendedFields.size() * values.length];
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);
            case PHRASE_PREFIX:
        BytesRef[] values,
/*
        List<FieldAndBoost> blendedFields
            boolean enablePositionIncrements,
            return groupQuery.get(0);
 * license agreements. See the NOTICE file distributed with
        Float commonTermsCutoff,
        QueryShardContext context,
        List<FieldAndBoost> blendedFields
                    autoGenerateSynonymsPhraseQuery
                queries = buildCrossFieldQuery(type, fieldNames, value, minimumShouldMatch, tieBreaker);
import java.util.List;
            }
        Map<Analyzer, List<FieldAndBoost>> groups = new HashMap<>();
                if (fieldType.boost != 1f) {
            for (FieldAndBoost fieldType : blendedFields) {
 *
        for (Map.Entry<String, Float> entry : fieldNames.entrySet()) {
                );
        }
        MultiMatchQueryBuilder.Type type,
    /**
 * ownership. Elasticsearch licenses this file to you under
        @Override
        }
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);
            List<Query> disjunctions = new ArrayList<>();
 */
                builder = new MatchQueryBuilder(
                );
        protected Query newTermQuery(Term term, float boost) {
            }
    ) {
import org.apache.lucene.analysis.TokenStream;
        }
            float tieBreaker,
            for (FieldAndBoost fieldType : blendedFields) {
                    }
            blendedBoost = Arrays.copyOf(blendedBoost, i);
                } catch (RuntimeException e) {
                    tieBreaker,
            } else {
    private List<Query> buildCrossFieldQuery(
import java.util.Map;
 *
 *
                    enablePositionIncrements,
            case BEST_FIELDS:
            // however their score contribution will be different
                    if (lenient) {
                    queries.add(query);
 * specific language governing permissions and limitations
        this.groupTieBreaker = tieBreaker;
    ) {
public class MultiMatchQuery extends MatchQuery {
import java.util.Arrays;
        @Override
                    autoGenerateSynonymsPhraseQuery
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (query != null) {
import org.apache.lucene.util.BytesRef;
    }
        List<Query> queries = new ArrayList<>();
        }
        }
 * this work for additional information regarding copyright
 */
                if (!groups.containsKey(actualAnalyzer)) {
            if (query != null) {
 * Licensed to Elasticsearch under one or more contributor
        }
     *
        QueryShardContext context,
            if (fieldType != null) {
        boolean hasMappedField = fieldNames.keySet().stream().anyMatch(k -> context.fieldMapper(k) != null);
             */
            /*
 * compatible open source license.
        }
import org.opensearch.index.query.MultiMatchQueryBuilder;
    }
        for (FieldAndBoost ft : blendedFields) {
            }
                    terms[i] = ((TermQuery) query).getTerm();
        float tieBreaker,
            }
            for (FieldAndBoost fieldType : blendedFields) {
        switch (type) {
            // best effort: add clauses that are not term queries so that they have an opportunity to match
import org.opensearch.index.query.QueryShardContext;
        Float commonTermsCutoff,
    private class BlendedQueryBuilder extends MatchQueryBuilder {
import org.opensearch.common.lucene.search.Queries;
        return combineGrouped(queries, tieBreaker);
        final float tieBreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
                builder = new BlendedQueryBuilder(
            case PHRASE:
                if (fieldType.boost != 1f) {
                groups.get(actualAnalyzer).add(new FieldAndBoost(fieldType, boost));
                    query = ft.fieldType.termQuery(term, context);
        @Override
        }
                    blendedBoost[i] = boost;
                }
}
        }
            Query query = parse(type.matchQueryType(), fieldName, value);
            return zeroTermsQuery();
            }
                    // apply the field boost to groups that contain a single field
            final MatchQueryBuilder builder;
        }
            if (group.getValue().size() == 1) {
                        throw e;
            return blendTerms(context, values, commonTermsCutoff, tieBreaker, lenient, blendedFields);
        boolean lenient,
            case MOST_FIELDS:
                    query = new BoostQuery(query, fieldType.boost);
        float tieBreaker
            if (commonTermsCutoff != null) {
/*
        final MappedFieldType fieldType;
    }
import org.apache.lucene.search.Query;
            this.boost = boost;
                disjunctions.add(query);
import org.opensearch.lucene.queries.BlendedTermQuery;
     * @opensearch.internal
        return blendTerms(context, new BytesRef[] { value }, commonTermsCutoff, tieBreaker, lenient, blendedFields);
                }
                queries.add(BlendedTermQuery.commonTermsBlendedQuery(terms, blendedBoost, commonTermsCutoff));
    public MultiMatchQuery(QueryShardContext context) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
                Query query = fieldType.fieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.TermQuery;
                    if (boost != AbstractQueryBuilder.DEFAULT_BOOST) {
    ) throws IOException {
                    query = bq.getQuery();
                    }
        ) {
            }
/**
    private Float groupTieBreaker = null;
 * @opensearch.internal
        }
                Query query;
            String representativeField = group.getValue().get(0).fieldType.name();
                break;
        throws IOException {
     * Holder for a field and it's boost value
            // all query fields are unmapped
             * fields are already grouped by their analyzers/types.
        final List<Query> queries;
import java.util.ArrayList;
                    group.getValue().get(0).fieldType,
        if (groupQuery.isEmpty()) {
                        query = newLenientFieldQuery(ft.fieldType.name(), e);
 * under the License.
                if (query.getClass() == TermQuery.class) {
            String name = entry.getKey();
        String minimumShouldMatch,
                queries.add(query);
                disjunctions.add(query);
            List<FieldAndBoost> blendedFields,
        BlendedQueryBuilder(
        private final List<FieldAndBoost> blendedFields;
        @Override
package org.opensearch.index.search;
                        query = new BoostQuery(query, boost);
            query = Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
            if (context.fieldMapper(fieldName) == null) {
                    if (boost != 1f && query instanceof MatchNoDocsQuery == false) {
        return queries;
            return Queries.newUnmappedFieldsQuery(fieldNames.keySet());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        FieldAndBoost(MappedFieldType fieldType, float boost) {
 * SPDX-License-Identifier: Apache-2.0
            boolean autoGenerateSynonymsPhraseQuery
    static Query blendTerms(
        String minimumShouldMatch
            return new DisjunctionMaxQuery(queries, tieBreaker);
        protected Query newPrefixQuery(Term term) {
                // ignore unmapped fields
import org.apache.lucene.analysis.Analyzer;
        }
        boolean lenient,
        if (i > 0) {
                }
                    }
        Object value,
                    group.getValue(),
             * we just pick the first field. It shouldn't matter because
 * Unless required by applicable law or agreed to in writing,
        List<Query> queries = new ArrayList<>();
 * not use this file except in compliance with the License.
import org.apache.lucene.index.Term;
            default:
            }
        @Override
        return queries;
            List<Query> disjunctions = new ArrayList<>();
        protected Query newSynonymQuery(String field, TermAndBoost[] terms) {
 * KIND, either express or implied.  See the License for the
        final float boost;
 * this file be licensed under the Apache-2.0 license or a
    public void setTieBreaker(float tieBreaker) {
 * Foundation multi match query
            this.tieBreaker = tieBreaker;
                disjunctions.add(query);
    }
                break;
        } else {
    }
                query = new BoostQuery(query, boostValue);
        }
             * We have to pick some field to pass through the superclass so
                    enablePositionIncrements,
                }
                try {
            List<Query> disjunctions = new ArrayList<>();
            Query query = parseInternal(type.matchQueryType(), representativeField, builder, value);
import org.apache.lucene.search.BoostQuery;
                    i++;
            return blendTerm(context, term.bytes(), commonTermsCutoff, tieBreaker, lenient, blendedFields);
                } else {
            terms = Arrays.copyOf(terms, i);
                }
            }
 *
    public Query parse(MultiMatchQueryBuilder.Type type, Map<String, Float> fieldNames, Object value, String minimumShouldMatch)
            if (query != null && boostValue != AbstractQueryBuilder.DEFAULT_BOOST && query instanceof MatchNoDocsQuery == false) {
