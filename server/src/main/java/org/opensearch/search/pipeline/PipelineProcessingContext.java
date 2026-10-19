        return Collections.unmodifiableList(processorExecutionDetails);  
     * @return a list of ProcessorExecutionDetails  
    public Object getAttribute(String name) {
     */
     */
 *
     */
/**
    /**  
     * Retrieves a generic attribute value from the state for this request.
     *
     * Add a ProcessorExecutionDetail to the list of execution details.
     * @return the value of the attribute if previously set (and null otherwise)  
        processorExecutionDetails.add(detail);  
 * this file be licensed under the Apache-2.0 license or a
     * @param name the name of the attribute
        return attributes.get(name);  
 */  
 * The OpenSearch Contributors require contributions made to  
    public void addProcessorExecutionDetail(ProcessorExecutionDetail detail) {
import java.util.HashMap;  
     * @param value the value to set on the attributen  
     * Set a generic attribute in the state for this request. Overwrites any existing value.  
    }
     * @param name the name of the attribute to set
import java.util.ArrayList;
     *
    }
     *
    /**  
 */  
    }
    }
    public void setAttribute(String name, Object value) {
    private final Map<String, Object> attributes = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
public class PipelineProcessingContext {
     */
/*  
    public Map<String, Object> getAttributes() {  
    /**
    private final List<ProcessorExecutionDetail> processorExecutionDetails = new ArrayList<>();  
import java.util.List;
        attributes.put(name, value);  
package org.opensearch.search.pipeline;
 * A holder for state that is passed through each processor in the pipeline.
        return attributes;
     * Get all ProcessorExecutionDetails recorded in this context.
     * @param detail the ProcessorExecutionDetail to add  
    /**  
import java.util.Collections;
 * compatible open source license.
}  
    }
    public List<ProcessorExecutionDetail> getProcessorExecutionDetails() {
