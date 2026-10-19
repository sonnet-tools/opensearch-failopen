 * Implemented by {@link StageExecution} types whose accumulated results can
}  
import org.opensearch.analytics.spi.DataConsumer;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*  
 * SPDX-License-Identifier: Apache-2.0
    /**
     */
     * Returns the read-side source for consuming this stage's output.  
 * @opensearch.internal
 *
import org.opensearch.analytics.backend.ExchangeSource;
 * @see DataConsumer for the complementary input-side contract  
package org.opensearch.analytics.exec.stage;
 * listener for the root stage).
 *
 */
 */  
/**
    ExchangeSource outputSource();
public interface DataProducer {  
 * be read by a downstream consumer (parent stage, or the walker's completion  
