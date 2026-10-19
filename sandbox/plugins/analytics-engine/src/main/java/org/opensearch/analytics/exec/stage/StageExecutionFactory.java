    /**  
/**
     * Creates a stage execution for the given stage, writing output into
import org.opensearch.analytics.spi.ExchangeSink;  
    StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config);
 * registry keyed by {@link org.opensearch.analytics.planner.dag.StageExecutionType}.
import org.opensearch.analytics.planner.dag.Stage;
 * this file be licensed under the Apache-2.0 license or a
 * Factory for creating {@link StageExecution} instances for a specific  
     */  
}
 */
 *  
     * the provided sink.
 *
 * The OpenSearch Contributors require contributions made to  
/*  
 * @opensearch.internal
package org.opensearch.analytics.exec.stage;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.analytics.exec.QueryContext;
public interface StageExecutionFactory {
 */  
 * stage execution type. Registered in {@link StageExecutionBuilder}'s factory
@FunctionalInterface  
