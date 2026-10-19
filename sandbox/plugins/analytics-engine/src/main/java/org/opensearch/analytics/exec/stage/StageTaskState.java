 */
    RUNNING,  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
    CANCELLED,  
 *
    /** Terminal failure — the task itself errored or its response stream faulted. */  
/**
    /** Terminal cancellation — the task was cancelled by the parent query or stage. */
    FINISHED,
    /** Task descriptor created, not yet dispatched. */  
    }  
        return this == FINISHED || this == FAILED || this == CANCELLED || this == SKIPPED;
package org.opensearch.analytics.exec.stage;
    /** Terminal success — task finished and its output was handed to the downstream sink. */
 *
    FAILED,
public enum StageTaskState {
 * tracked per-partition so the scheduler can reason about partial progress, retry  
 * Lifecycle of a single {@link StageTask}. Mirrors the stage's own state machine but
 * eligibility, and stage readiness.
 * SPDX-License-Identifier: Apache-2.0
    SKIPPED;
/*  
    CREATED,
 * this file be licensed under the Apache-2.0 license or a
    /** Terminal skip — never sent, because the task provably could not contribute to the result. */
 * @opensearch.internal  
    public boolean isTerminal() {
    /** Dispatched to a data node; awaiting first response or completion. */
}
