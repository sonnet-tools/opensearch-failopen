        }
        final List<Query> queries;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public Query parse(MultiMatchQueryBuilder.Type type, Map<String, Float> fieldNames, Object value, String minimumShouldMatch)
                    if (boost != 1f && query instanceof MatchNoDocsQuery == false) {
            }
    }
            // best effort: add clauses that are not term queries so that they have an opportunity to match  
import java.util.Objects;
            this.tieBreaker = tieBreaker;  
            }
 */
        return queries;
            terms = Arrays.copyOf(terms, i);
        protected Query newPrefixQuery(Term term) {  
        boolean hasMappedField = fieldNames.keySet().stream().anyMatch(k -> context.fieldMapper(k) != null);
import org.opensearch.index.query.MultiMatchQueryBuilder;
            List<Query> disjunctions = new ArrayList<>();
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {
import org.apache.lucene.search.BoostQuery;
                    query = bq.getQuery();  
        if (groupQuery.size() == 1) {
        List<FieldAndBoost> blendedFields  
 * Licensed to Elasticsearch under one or more contributor  
                    groups.put(actualAnalyzer, new ArrayList<>());
        MultiMatchQueryBuilder.Type type,  
            if (query != null && boostValue != AbstractQueryBuilder.DEFAULT_BOOST && query instanceof MatchNoDocsQuery == false) {
        Map<String, Float> fieldNames,  
             * We have to pick some field to pass through the superclass so
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.index.query.AbstractQueryBuilder;  
    ) {
                    group.getKey(),
    public void setTieBreaker(float tieBreaker) {
                if (fieldType.boost != 1f) {
import java.util.List;  
                    query = new BoostQuery(query, fieldType.boost);
                    if (boost != AbstractQueryBuilder.DEFAULT_BOOST) {  
/*  
            for (FieldAndBoost fieldType : blendedFields) {  
        this.groupTieBreaker = tieBreaker;
                    }
            List<Query> disjunctions = new ArrayList<>();  
    ) throws IOException {
 */  
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);
        return new DisjunctionMaxQuery(groupQuery, tieBreaker);
 * ownership. Elasticsearch licenses this file to you under  
        FieldAndBoost(MappedFieldType fieldType, float boost) {
        Map<String, Float> fieldNames,
                    group.getKey(),  
    }
        @Override
            float boostValue = fieldNames.getOrDefault(fieldName, 1.0f);
        private final float tieBreaker;
            }
        protected Query newSynonymQuery(String field, TermAndBoost[] terms) {
/**  
        int i = 0;  
    private List<Query> buildFieldQueries(
    private Query combineGrouped(List<Query> groupQuery, float tieBreaker) {  
            case CROSS_FIELDS:
        MultiMatchQueryBuilder.Type type,
            }
     * Holder for a field and it's boost value  
        return blendTerms(context, new BytesRef[] { value }, commonTermsCutoff, tieBreaker, lenient, blendedFields);  
            this.blendedFields = blendedFields;
            /*  
                float boost = entry.getValue() == null ? 1.0f : entry.getValue();
 * Foundation multi match query
        }
                } catch (RuntimeException e) {  
            BytesRef[] values = new BytesRef[terms.length];
            for (FieldAndBoost fieldType : blendedFields) {
                    autoGenerateSynonymsPhraseQuery
        }
        }
 */  
    /**
 * under the License.  
                queries = buildCrossFieldQuery(type, fieldNames, value, minimumShouldMatch, tieBreaker);  
                queries.add(query);
    public MultiMatchQuery(QueryShardContext context) {  
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);  
        protected Query newTermQuery(Term term, float boost) {
                Query query = fieldType.fieldType.prefixQuery(term.text(), null, context);  
        float tieBreaker,
import java.io.IOException;
                break;  
                    enablePositionIncrements,
                }
        ) {  
            return new DisjunctionMaxQuery(disjunctions, tieBreaker);
                }  
        }
                    query = new BoostQuery(query, fieldType.boost);
            float tieBreaker,  
        switch (type) {
        if (queries.size() == 1) {  
        boolean lenient,
                    } else {  
                        query = newLenientFieldQuery(ft.fieldType.name(), e);
                queries.add(BlendedTermQuery.dismaxBlendedQuery(terms, blendedBoost, tieBreaker));  
     */  
            case BOOL_PREFIX:
            } else {
    static Query blendTerm(  
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
            case MOST_FIELDS:  
        List<Query> queries = new ArrayList<>();  
                if (!groups.containsKey(actualAnalyzer)) {
import java.util.Map;
             * we just pick the first field. It shouldn't matter because
}
import org.apache.lucene.analysis.Analyzer;
 * specific language governing permissions and limitations
                    i++;  
    }  
        private final List<FieldAndBoost> blendedFields;  
                while (query instanceof BoostQuery bq) {
                        throw e;
            }  
            String name = entry.getKey();  
                    enablePositionIncrements,
            return queries.get(0);
        BytesRef[] values,
            // all query fields are unmapped  
            if (fieldType != null) {
                Analyzer actualAnalyzer = getAnalyzer(fieldType, type == MultiMatchQueryBuilder.Type.PHRASE);  
            }
                builder = new BlendedQueryBuilder(  
            String representativeField = group.getValue().get(0).fieldType.name();
        float[] blendedBoost = new float[blendedFields.size() * values.length];
            }  
        return combineGrouped(queries, tieBreaker);  
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.MatchNoDocsQuery;  
        throws IOException {  
            if (query != null) {
 * GitHub history for details.
        }  
            }
            if (group.getValue().size() == 1) {
import org.opensearch.index.query.QueryShardContext;
                builder = new MatchQueryBuilder(
    }  
                queries.add(BlendedTermQuery.commonTermsBlendedQuery(terms, blendedBoost, commonTermsCutoff));
    }  
import org.opensearch.lucene.queries.BlendedTermQuery;  
        }
            // however their score contribution will be different
                queries.add(query);
                queries = buildFieldQueries(type, fieldNames, value, minimumShouldMatch);
                    }
 * The OpenSearch Contributors require contributions made to  
    private Float groupTieBreaker = null;
            }  
                    // apply the field boost to groups that contain a single field
                    group.getValue().get(0).fieldType,
import java.util.ArrayList;  
        final float boost;  
        Float commonTermsCutoff,  
    }
                    autoGenerateSynonymsPhraseQuery  
    ) {
            return groupQuery.get(0);
                values[i] = terms[i].term();
                    query = new BoostQuery(query, fieldType.boost);  
             * fields are already grouped by their analyzers/types.  
                if (fieldType.boost != 1f) {  
            return zeroTermsQuery();
            final MatchQueryBuilder builder;  
        }  
        }  
            }
        super(context);
 *  
 *
            default:  
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
 * @opensearch.internal  
        }
import org.apache.lucene.index.Term;  
 * not use this file except in compliance with the License.
                }  
        protected Query analyzeMultiPhrase(String field, TokenStream stream, int slop) throws IOException {
                disjunctions.add(query);
                break;
import org.apache.lucene.search.DisjunctionMaxQuery;
public class MultiMatchQuery extends MatchQuery {
        BytesRef value,
        for (String fieldName : fieldNames.keySet()) {
    private class BlendedQueryBuilder extends MatchQueryBuilder {
                );
        for (FieldAndBoost ft : blendedFields) {
                );  
    }  
            return Queries.newUnmappedFieldsQuery(fieldNames.keySet());
            this.boost = boost;
                        query = new BoostQuery(query, boost);
        float tieBreaker,
        for (Map.Entry<String, Float> entry : fieldNames.entrySet()) {
        }  
            return blendTerm(context, term.bytes(), commonTermsCutoff, tieBreaker, lenient, blendedFields);
                }
                Query query = fieldType.fieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
                }
import org.apache.lucene.search.Query;
            return blendTerms(context, values, commonTermsCutoff, tieBreaker, lenient, blendedFields);  
            case PHRASE_PREFIX:
                    queries.add(query);
/*
     *
        }
        return queries;
                Query query;  
 *
            query = Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
        final MappedFieldType fieldType;
        }
    static final class FieldAndBoost {
            if (commonTermsCutoff != null) {  
                continue;
    }
            Query query = parse(type.matchQueryType(), fieldName, value);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BytesRef;  
        Term[] terms = new Term[blendedFields.size() * values.length];
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lucene.search.Queries;
            Query query = parseInternal(type.matchQueryType(), representativeField, builder, value);  
    }
        List<Query> queries = new ArrayList<>();
                    float boost = group.getValue().get(0).boost;
import java.util.Arrays;
    static Query blendTerms(  
        }
            this.fieldType = Objects.requireNonNull(fieldType);  
                try {
    private List<Query> buildCrossFieldQuery(
                } else {
        @Override  
                if (query.getClass() == TermQuery.class) {  
                }  
        List<FieldAndBoost> blendedFields  
import org.opensearch.index.mapper.MappedFieldType;
        float tieBreaker
            List<FieldAndBoost> blendedFields,
        @Override
        @Override  
                query = new BoostQuery(query, boostValue);
 */
            for (FieldAndBoost fieldType : blendedFields) {
package org.opensearch.index.search;
        QueryShardContext context,
        String minimumShouldMatch
            query = Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);  
            boolean enablePositionIncrements,
                disjunctions.add(query);  
        @Override  
 * this work for additional information regarding copyright
        }
            for (BytesRef term : values) {
        final float tieBreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;  
        Map<Analyzer, List<FieldAndBoost>> groups = new HashMap<>();  
                        query = new BoostQuery(query, boost);  
        }  
                if (group.getValue().size() == 1) {  
            MappedFieldType fieldType = context.fieldMapper(name);
import java.util.HashMap;
            return new DisjunctionMaxQuery(queries, tieBreaker);
            case PHRASE:  
                }  
            }  
             */
                Query query = fieldType.fieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
        boolean lenient,
        if (hasMappedField == false) {
                    boost *= bq.getBoost();
        } else {
                if (fieldType.boost != 1f) {
        List<Query> queries = new ArrayList<>();
                // ignore unmapped fields
            Analyzer analyzer,
                    if (lenient) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (query != null) {
                disjunctions.add(query);
        if (i > 0) {  
                }  
    ) throws IOException {  
                    tieBreaker,  
                    group.getValue(),
            boolean autoGenerateSynonymsPhraseQuery
        BlendedQueryBuilder(  
        QueryShardContext context,
            }  
            for (int i = 0; i < terms.length; i++) {  
                float boost = ft.boost;
        Object value,
        String minimumShouldMatch,  
                throw new IllegalStateException("No such type: " + type);
                    query = ft.fieldType.termQuery(term, context);
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
            blendedBoost = Arrays.copyOf(blendedBoost, i);
                    }
            } else {
 * compatible open source license.
                    terms[i] = ((TermQuery) query).getTerm();
 * software distributed under the License is distributed on an
        if (groupQuery.isEmpty()) {
        Object value,
/*  
        Float commonTermsCutoff,  
            // TODO: can we improve this?
        for (Map.Entry<Analyzer, List<FieldAndBoost>> group : groups.entrySet()) {
    }  
            super(analyzer, blendedFields.get(0).fieldType, enablePositionIncrements, autoGenerateSynonymsPhraseQuery);
 * Unless required by applicable law or agreed to in writing,
                groups.get(actualAnalyzer).add(new FieldAndBoost(fieldType, boost));
                    blendedBoost[i] = boost;
            List<Query> disjunctions = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
            case BEST_FIELDS:
import org.apache.lucene.search.TermQuery;
            if (context.fieldMapper(fieldName) == null) {  
