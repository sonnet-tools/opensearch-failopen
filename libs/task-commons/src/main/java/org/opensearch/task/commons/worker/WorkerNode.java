        return ip;
    /**
     * @return The IP address of the worker node.
import java.util.Objects;
    }  
     * @return The ID of the worker node.
    public String getName() {
     *
    /**  
     * The unique identifier of the worker node.
 *
     */
 */  
     * @param ip The IP address of the worker node.
     * Creates a new worker node with the given ID, name, and IP address.  
    @Override
        this.ip = ip;
    /**
        return Objects.hash(id, name, ip);  
    @Override
     * @param ip The IP address of the worker node.  
/*  
     * @param id The unique identifier of the worker node.
     * Creates a new worker node with the given ID, name, and IP address.
     * @param name The name of the worker node.
     * Returns the name of the worker node.  
        return id;
    }  
     */
     *
    }  
        if (o == null || getClass() != o.getClass()) return false;
     * Returns the IP address of the worker node.  
    private final String id;
    private final String ip;
     * The IP address of the worker node.  
    /**
     * @param name The name of the worker node.  
        this.name = name;
     */  
     * @return The created worker node.
     * The name of the worker node.
     * @return The name of the worker node.
     */
    public String getIp() {
 * Represents a worker node in the fleet
    /**
        return name;
 * SPDX-License-Identifier: Apache-2.0
public class WorkerNode {  
    public static WorkerNode createWorkerNode(String id, String name, String ip) {
    public boolean equals(Object o) {  
    private final String name;  
/**  
     *
    /**
     */  
    public int hashCode() {
     * @param id The unique identifier of the worker node.
        if (this == o) return true;
    /**
    }  
    }  
        this.id = id;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.task.commons.worker;
     * Returns the unique identifier of the worker node.  
     *
 * this file be licensed under the Apache-2.0 license or a
    private WorkerNode(String id, String name, String ip) {
    /**
     *  
    }
 */
 * compatible open source license.
    }
        WorkerNode that = (WorkerNode) o;  
     */  
}
    public String getId() {
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ip, that.ip);
     */  
        return new WorkerNode(id, name, ip);
     */  
