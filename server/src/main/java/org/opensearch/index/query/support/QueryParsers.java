 * You may obtain a copy of the License at  
 * GitHub history for details.
            if (Character.isDigit(rewriteMethod.charAt(i))) {
        @Nullable String rewriteMethod,  
 *
 *
/*
            if (TOP_TERMS_BOOST.match(rewriteMethodName, deprecationHandler)) {
 */  
        }
            }
    }
        }  
 */
                return new MultiTermQuery.TopTermsBlendedFreqScoringRewrite(size);  
    public static final ParseField TOP_TERMS_BOOST = new ParseField("top_terms_boost_");  
    public static final ParseField TOP_TERMS_BLENDED_FREQS = new ParseField("top_terms_blended_freqs_");
        for (int i = 0; i < rewriteMethod.length(); ++i) {  
            return MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
                return new MultiTermQuery.TopTermsBoostOnlyBooleanQueryRewrite(size);  
        if (firstDigit >= 0) {
        if (SCORING_BOOLEAN.match(rewriteMethod, deprecationHandler)) {
        int firstDigit = -1;
            if (TOP_TERMS.match(rewriteMethodName, deprecationHandler)) {
            return MultiTermQuery.CONSTANT_SCORE_REWRITE;
/*  
    }  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
            final int size = Integer.parseInt(rewriteMethod.substring(firstDigit));
package org.opensearch.index.query.support;
 * @opensearch.internal  
        @Nullable MultiTermQuery.RewriteMethod defaultRewriteMethod,
        }
 * Licensed to Elasticsearch under one or more contributor  
 */  
        if (CONSTANT_SCORE_BLENDED.match(rewriteMethod, deprecationHandler)) {
            return MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE;
        }  
        }  
 *  
    public static final ParseField SCORING_BOOLEAN = new ParseField("scoring_boolean");  
            return defaultRewriteMethod;
 * under the License.  
        DeprecationHandler deprecationHandler
            String rewriteMethodName = rewriteMethod.substring(0, firstDigit);  
    ) {  
 * ownership. Elasticsearch licenses this file to you under  
    public static final ParseField TOP_TERMS = new ParseField("top_terms_");
        if (CONSTANT_SCORE.match(rewriteMethod, deprecationHandler)) {
public final class QueryParsers {
 * SPDX-License-Identifier: Apache-2.0
    public static final ParseField CONSTANT_SCORE = new ParseField("constant_score");
        if (rewriteMethod == null) {
 * KIND, either express or implied.  See the License for the
                return new MultiTermQuery.TopTermsScoringBooleanQueryRewrite(size);  
                firstDigit = i;
 *
        }  
import org.apache.lucene.search.MultiTermQuery;
                break;  
    public static final ParseField CONSTANT_SCORE_BLENDED = new ParseField("constant_score_blended");
        return parseRewriteMethod(rewriteMethod, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, deprecationHandler);
 * software distributed under the License is distributed on an
    public static MultiTermQuery.RewriteMethod parseRewriteMethod(
import org.opensearch.core.ParseField;  
/**  
/*  
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.common.Nullable;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Utility class for Query Parsers
 * Unless required by applicable law or agreed to in writing,
        }  
            }
    public static MultiTermQuery.RewriteMethod parseRewriteMethod(@Nullable String rewriteMethod, DeprecationHandler deprecationHandler) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    private QueryParsers() {  
 * compatible open source license.
            if (TOP_TERMS_BLENDED_FREQS.match(rewriteMethodName, deprecationHandler)) {
}  
 * The OpenSearch Contributors require contributions made to  
        throw new IllegalArgumentException("Failed to parse rewrite_method [" + rewriteMethod + "]");
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            }
    }
        if (CONSTANT_SCORE_BOOLEAN.match(rewriteMethod, deprecationHandler)) {
    public static final ParseField CONSTANT_SCORE_BOOLEAN = new ParseField("constant_score_boolean");
            return MultiTermQuery.SCORING_BOOLEAN_REWRITE;
            }
 * this work for additional information regarding copyright
