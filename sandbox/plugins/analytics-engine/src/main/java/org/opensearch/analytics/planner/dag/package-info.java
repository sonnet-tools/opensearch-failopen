 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
 */  
 * compatible open source license.
package org.opensearch.analytics.planner.dag;
/*  
/**
 * Converts a marked RelNode tree into a {@link org.opensearch.analytics.planner.dag.QueryDAG}
 */
 * DAG construction, plan forking, and fragment conversion for the Analytics Plugin planner.  
 * with per-stage plan alternatives, then strips annotations and dispatches to backend
 * {@link org.opensearch.analytics.spi.FragmentConvertor} implementations.  
