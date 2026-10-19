 *  
public interface BackendExecutionState {}  
 * Marker interface for backend-specific execution state that flows between
 * The OpenSearch Contributors require contributions made to  
 * <p>Each backend defines its own concrete implementation (e.g.,
 */  
 * upon the previous handler's output.
 * {@code null} and bootstraps the state; subsequent handlers receive and build
 * SPDX-License-Identifier: Apache-2.0
 *  
/**
/*  
 */
 *
 * @opensearch.internal
package org.opensearch.analytics.spi;
 * compatible open source license.
 * successive instruction handler calls. The first handler in the chain receives  
 * this file be licensed under the Apache-2.0 license or a
 * {@code DataFusionSessionState} holding a native SessionContext handle).
