 * runnable is associated to.  
 * SPDX-License-Identifier: Apache-2.0
}
    void taskExecutionFinishedOnThread(long taskId, long threadId);
 *
 * Listener for events when a runnable execution starts or finishes on a thread and is aware of the task for which the
     * @param taskId of task which has started
    void taskExecutionStartedOnThread(long taskId, long threadId);
 * this file be licensed under the Apache-2.0 license or a
     * @param threadId of thread which is executing the task
 * The OpenSearch Contributors require contributions made to  
 */  
    /**
public interface RunnableTaskExecutionListener {
     * @param taskId of task which has finished
     * Sends an update when task execution finishes on a thread
 */
     *  
     *  
 * compatible open source license.
     */  
    /**  
/**
     * Sends an update when ever a task's execution start on a thread
     * @param threadId of thread which executed the task
package org.opensearch.threadpool;
     *
     */  
/*  
