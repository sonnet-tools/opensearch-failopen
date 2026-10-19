 * </ul>
 *
 * <ul>  
 * into more efficient forms while maintaining semantic equivalence.  
 * <p>This package contains various query rewriters that transform queries
 * compatible open source license.
 *       Removes redundant match_all queries from boolean clauses</li>
 *       Flattens nested boolean queries with single clauses</li>
 *
 *
 * SPDX-License-Identifier: Apache-2.0
 *   <li>{@link org.opensearch.search.query.rewriters.BooleanFlatteningRewriter} -
 * Query rewriting optimizations for improving search performance.  
 *       Merges multiple term queries on the same field into a single terms query</li>  
 * this file be licensed under the Apache-2.0 license or a
 *       Transforms must_not queries to should queries for better performance</li>
package org.opensearch.search.query.rewriters;  
 *   <li>{@link org.opensearch.search.query.rewriters.MustToFilterRewriter} -  
 *   <li>{@link org.opensearch.search.query.rewriters.TermsMergingRewriter} -
 *   <li>{@link org.opensearch.search.query.rewriters.MustNotToShouldRewriter} -
 * <p>The rewriters include:
 *       Moves scoring-irrelevant queries from must to filter clauses</li>
 * The OpenSearch Contributors require contributions made to  
/**
 */
 *   <li>{@link org.opensearch.search.query.rewriters.MatchAllRemovalRewriter} -  
/*  
 * @opensearch.internal
 */  
 *  
