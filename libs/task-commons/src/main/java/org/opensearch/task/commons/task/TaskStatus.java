 * SPDX-License-Identifier: Apache-2.0
    /**  
 */
 * The OpenSearch Contributors require contributions made to  
    FAILED,  
    /**
     * TaskStatus of a finished Task
     */
    /**
     * TaskStatus of a cancelled Task  
     * TaskStatus of a Task which failed in 1 or more attempts
    CANCELLED
    /**
/**  
     * TaskStatus of a Task which is not yet assigned to or picked up by a worker
    SUCCESS,
    UNASSIGNED,  
public enum TaskStatus {
 * compatible open source license.
     */  
 */  
     * TaskStatus of an in progress Task  
}  
package org.opensearch.task.commons.task;
 *
    ACTIVE,
 * Task status enum
@ExperimentalApi  
     */
     * This status confirms that a worker will execute this task and no other worker should pick it up.
import org.opensearch.common.annotation.ExperimentalApi;
     * TaskStatus of a Task which is assigned to or picked up by a worker but hasn't started execution yet.  
    ASSIGNED,  
/*  
    /**
     */
     */
     */
 * this file be licensed under the Apache-2.0 license or a
    /**  
