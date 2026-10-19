 * stage is started. Registration after {@code start()} is unsupported.
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.exec.stage;
 * implementations must be non-blocking and exception-safe.
     * @param to   the new state
    void onStateChange(StageExecution.State from, StageExecution.State to);
     */  
public interface StageStateListener {
 * SPDX-License-Identifier: Apache-2.0
/**
 * Observer for {@link StageExecution} state transitions. Fired synchronously
 * <p>Listeners are registered during the walker's setup phase, before any  
    /**
 *
 * from within the execution's {@code transitionTo(...)} helper; listener  
 */  
     * Called when a {@link StageExecution} transitions from one state to another.
 * compatible open source license.
 */
/*  
 * The OpenSearch Contributors require contributions made to  
 *
}
     * @param from the previous state
     *  
 * @opensearch.internal  
