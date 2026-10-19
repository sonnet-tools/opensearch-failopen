 * The OpenSearch Contributors require contributions made to  
 * both accept child input and produce output (root gather, local compute).
public interface SinkProvidingStageExecution extends StageExecution, DataConsumer, DataProducer {}
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecution;
 */  
import org.opensearch.analytics.exec.stage.coordinator.PassThroughStageExecution;
 * Combines {@link DataConsumer} and {@link DataProducer} for stages that  
 *
package org.opensearch.analytics.exec.stage;
 * routing (like {@link ReduceStageExecution}) delegate both methods to the  
 *
 * {@link DataProducer#outputSource()}. Stages with backend-provided per-child
 * this file be licensed under the Apache-2.0 license or a
/*  
 * backend's fragment executor.
 * SPDX-License-Identifier: Apache-2.0
 *
 * @opensearch.internal  
import org.opensearch.analytics.spi.DataConsumer;  
 */
 * compatible open source license.
 * return the same object for both {@link DataConsumer#inputSink(int)} and
/**
 * <p>Stages that own a single shared sink (like {@link PassThroughStageExecution})  
