    public String getTag() {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    public String getDescription() {  
 * compatible open source license.
    public boolean isIgnoreFailure() {
        this.tag = tag;
    private final String tag;
    @Override
    @Override
public abstract class AbstractProcessor implements Processor {
 * Base class for common processor behavior.
        return ignoreFailure;  
 */  
    }
 */  
        return description;
    protected AbstractProcessor(String tag, String description, boolean ignoreFailure) {  
        return tag;
}
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        this.description = description;
    }  
        this.ignoreFailure = ignoreFailure;  
    }
    }
 *
    private final boolean ignoreFailure;
package org.opensearch.search.pipeline;
/**
/*  
    private final String description;  
