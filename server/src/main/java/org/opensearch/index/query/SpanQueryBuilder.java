 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                        queryName
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.query;
 *    http://www.apache.org/licenses/LICENSE-2.0
                            + "] "
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal
}
     */  
            try {
                    throw new ParsingException(  
 * not use this file except in compliance with the License.
                        parser.getTokenLocation(),
                if (clause.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
 *  
 *  
                    );  
 *
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        }
 */
    class SpanQueryBuilderUtil {
         *
 * Licensed to Elasticsearch under one or more contributor  
                            + "]"
 * Marker interface for a specific type of {@link QueryBuilder} that allows to build span queries.
     *
        }
import org.opensearch.core.common.ParsingException;
        static void checkNoBoost(String queryName, String fieldName, XContentParser parser, SpanQueryBuilder clause) {  
 * software distributed under the License is distributed on an
 *
public interface SpanQueryBuilder extends QueryBuilder {  
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
            } catch (UnsupportedOperationException ignored) {
 * You may obtain a copy of the License at  
                            + " ["  
        private SpanQueryBuilderUtil() {
 * specific language governing permissions and limitations
         * @param parser    a parser
         * @param queryName a query name  
 * GitHub history for details.
    /**
 * KIND, either express or implied.  See the License for the
/*
     * Utility for span query builders  
         * @param fieldName a field name
                            + "as a nested span clause can't have non-default boost value ["  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        /**  
 * The OpenSearch Contributors require contributions made to  
                }
 */  
 * SPDX-License-Identifier: Apache-2.0
/**
                            + clause.boost()
         * @param clause    a span query builder  
                            + fieldName
 */  
            }
                // if boost is unsupported it can't have been set  
         * @throws ParsingException if query boost value isn't equal to {@link AbstractQueryBuilder#DEFAULT_BOOST}
         * Checks boost value of a nested span clause is equal to {@link AbstractQueryBuilder#DEFAULT_BOOST}.
            // utility class  
         */
/*  
 */
