 * SPDX-License-Identifier: Apache-2.0
 * More details in https://github.com/opensearch-project/OpenSearch/pull/14464
 * <p>
 * The OpenSearch Contributors require contributions made to  
 * <li> figure out the "ranges" from the aggregation </li>
 */
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * </ul>  
 * The idea is to
package org.opensearch.search.aggregations.bucket.filterrewrite;  
/*  
/**
 *
 */  
 * <li> leverage the ranges and bkd index to get the result of each range bucket quickly </li>
 * <ul>  
 * This package contains filter rewrite optimization for range-type aggregations  
