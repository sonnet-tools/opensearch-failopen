 * @opensearch.internal  
}
/*  
     * span's parent span
    }
    protected AbstractSpan(String spanName, Span parentSpan) {
    public String getSpanName() {  
    }  
 * Base span
     * @param parentSpan span's parent span
    /**
    @Override
 */
 */  
/**  
import org.opensearch.common.annotation.InternalApi;
    /**  
    private final String spanName;
public abstract class AbstractSpan implements Span {  
    private final Span parentSpan;  
 * SPDX-License-Identifier: Apache-2.0
     * Base constructor  
     * @param spanName name of the span
@InternalApi
 * The OpenSearch Contributors require contributions made to  
        return spanName;
 *
     */  
     */
        this.spanName = spanName;
 * compatible open source license.
        return parentSpan;
    @Override  
    /**
        this.parentSpan = parentSpan;  
    }
 * this file be licensed under the Apache-2.0 license or a
 *
     * name of the span  
     */
    public Span getParentSpan() {
package org.opensearch.telemetry.tracing;
