/*  
    void onBeginProcessing(List<? extends TaskBatcher.BatchedTask> tasks);  
    void onBeginSubmit(List<? extends TaskBatcher.BatchedTask> tasks);
 *
     */
     * @param tasks list of tasks which will be executed.
    /**
    /**
     * @param tasks list of tasks which will be executed.
 * Listener class for callback on various events of TaskBatcher.
 */
     * @param tasks list of tasks which will be submitted.  
     * for e.g. failing due to duplicate tasks.  
    /**
     * Callback called if tasks submission due to any reason
    /**
    void onSubmitFailure(List<? extends TaskBatcher.BatchedTask> tasks);  
     */
     * Callback called before submitting tasks.
     */
 * The OpenSearch Contributors require contributions made to  
public interface TaskBatcherListener {  
 * this file be licensed under the Apache-2.0 license or a
     * Callback called when tasks are timed out.  
import java.util.List;
     * Callback called before processing any tasks.  
     * @param tasks list of tasks which was failed to submit.
 * SPDX-License-Identifier: Apache-2.0
}
/**  
    void onTimeout(List<? extends TaskBatcher.BatchedTask> tasks);  
     */
package org.opensearch.cluster.service;
 */  
 * compatible open source license.
