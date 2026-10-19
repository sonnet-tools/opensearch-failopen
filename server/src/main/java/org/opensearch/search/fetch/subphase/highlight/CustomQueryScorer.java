            }  
 * @opensearch.internal
            if (terms.isEmpty()) {
/*
 *
            } else if (query instanceof IndexOrDocValuesQuery indexOrDocValuesQuery) {
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
                extractWeightedTerms(terms, query, 1F);
package org.opensearch.search.fetch.subphase.highlight;
    }  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            super(defaultField);
        @Override
        super(query, reader, field);
 */  
    protected WeightedSpanTermExtractor newTermExtractor(String defaultField) {  
 * SPDX-License-Identifier: Apache-2.0
        CustomWeightedSpanTermExtractor() {  
            } else {
    public CustomQueryScorer(Query query, String field) {
            } else if (query instanceof OpenSearchToParentBlockJoinQuery openSearchToParentBlockJoinQuery) {  
        protected void extractUnknownQuery(Query query, Map<String, WeightedSpanTerm> terms) throws IOException {  
        super(weightedTerms);
         */
 *  
        private static boolean isChildOrParentQuery(Class<?> clazz) {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.IndexReader;
                super.extract(indexOrDocValuesQuery.getIndexQuery(), boost, terms);  
 * GitHub history for details.
    public CustomQueryScorer(Query query, IndexReader reader, String field, String defaultField) {
            super();
public final class CustomQueryScorer extends QueryScorer {  
        CustomWeightedSpanTermExtractor(String defaultField) {
    @Override
 * specific language governing permissions and limitations
            return clazz.getName().endsWith(PARENT_CHILD_QUERY_NAME);  
        }
                super.extract(query, boost, terms);
        super(query, field);  
        private static final String PARENT_CHILD_QUERY_NAME = "HasChildQueryBuilder$LateParsingQuery";  
            } else if (query instanceof FunctionScoreQuery functionScoreQuery) {
 * You may obtain a copy of the License at  
import org.apache.lucene.search.highlight.WeightedSpanTerm;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
/**
import org.apache.lucene.search.Query;  
 */  
        }
 * Licensed to Elasticsearch under one or more contributor  
    public CustomQueryScorer(WeightedSpanTerm[] weightedTerms) {
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import org.apache.lucene.search.highlight.WeightedSpanTermExtractor;  
 *  
    private static class CustomWeightedSpanTermExtractor extends WeightedSpanTermExtractor {
        super(query, field, defaultField);
                return;  
import java.io.IOException;
    }
    }
import org.apache.lucene.search.IndexOrDocValuesQuery;
    }
}  
 * ownership. Elasticsearch licenses this file to you under  
            }  
            if (isChildOrParentQuery(query.getClass())) {
        }  
        }
        /**  
         * Workaround to detect parent/child query
                super.extract(functionScoreQuery.getSubQuery(), boost, terms);
    }  
    }
    public CustomQueryScorer(Query query, String field, String defaultField) {
 * Modifications Copyright OpenSearch Contributors. See
                // skip has_child or has_parent queries, see: https://github.com/elastic/elasticsearch/issues/14999
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
        protected void extract(Query query, float boost, Map<String, WeightedSpanTerm> terms) throws IOException {  
    }
    public CustomQueryScorer(Query query, IndexReader reader, String field) {  
 * KIND, either express or implied.  See the License for the
    public CustomQueryScorer(Query query) {  
/*  
import org.apache.lucene.search.highlight.QueryScorer;
        }
        super(query, reader, field, defaultField);  
                super.extract(openSearchToParentBlockJoinQuery.getChildQuery(), boost, terms);
        return defaultField == null ? new CustomWeightedSpanTermExtractor() : new CustomWeightedSpanTermExtractor(defaultField);
        super(query);
 */
 * Internally used for custom scoring
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
