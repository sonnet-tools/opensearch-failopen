     * @return id
    @Override
public class TaskId {  
        return this.id.equals(other.id);
    }  
 *
    public String getValue() {
    }
     * Constructor to initialize TaskId
    public boolean equals(Object obj) {  
    /**
 */  
     * @param id String value of Task id  
 * Class encapsulating Task identifier  
    public TaskId(String id) {
        }  
        return id;
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
        TaskId other = (TaskId) obj;
        this.id = id;  
    /**
@ExperimentalApi
     */  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     * Get id value
        return Objects.hash(id);
/**
     */
import org.opensearch.common.annotation.ExperimentalApi;
            return false;
    private final String id;
 */
import java.util.Objects;  
package org.opensearch.task.commons.task;
    /**  
    }  
     * Identified of the Task  
    public int hashCode() {  
     */
/*  
        if (obj == null || getClass() != obj.getClass()) {
}  
