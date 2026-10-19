     */  
    public SpanCreationContext attributes(Attributes attributes) {  
        this.parent = parent;
        return this;  
     * Returns the span attributes.  
     */
     * @return parent.
        return spanCreationContext;
     * @return spankind.  
        return attributes;
     * Sets the parent for span  
        return spanName;
    public static SpanCreationContext client() {
     * @param parent parent span context
    public String getSpanName() {
        spanCreationContext.spanKind = SpanKind.SERVER;  
        SpanCreationContext spanCreationContext = new SpanCreationContext();  
    }
    }
        return spanCreationContext;  
    /**  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
    /**  
     * Sets the span type to server.
    /**  
 */  
     * Returns the parent span
     */  
 *  
    public SpanContext getParent() {
 *
     * @return spanCreationContext  
}
@ExperimentalApi  
     * @return spanCreationContext
        SpanCreationContext spanCreationContext = new SpanCreationContext();
        spanCreationContext.spanKind = SpanKind.CLIENT;
        return spanKind;  
        return this;
        return this;
     */
        return parent;
    }
    public static SpanCreationContext internal() {  
 * Context for span details.
    /**  
     * @return spanCreationContext
     */
    /**
 * @opensearch.experimental
     * @return spanCreationContext
    }
        this.spanName = spanName;  
    /**
     */
     * @return attributes.
     * Sets the span attributes.
     * Returns the span name.
    }
import org.opensearch.telemetry.tracing.attributes.Attributes;
     * Constructor.
        this.attributes = attributes;
    }
    private SpanCreationContext() {}
     */  
     */
    public static SpanCreationContext server() {
 * SPDX-License-Identifier: Apache-2.0
     * Returns the span kind.
    private SpanContext parent;
     * Sets the span type to internal.  
     * @param attributes attributes.  
 */
     * Sets the span type to client.
    private String spanName;
/*  
    private SpanKind spanKind = SpanKind.INTERNAL;
    public SpanCreationContext parent(SpanContext parent) {
    /**
    }  
        SpanCreationContext spanCreationContext = new SpanCreationContext();
public final class SpanCreationContext {
     */  
    public Attributes getAttributes() {  
    }  
    public SpanKind getSpanKind() {
     */
     * @return spanCreationContext  
package org.opensearch.telemetry.tracing;
/**
    }  
    }  
    /**
    private Attributes attributes;  
    /**
    /**
     * @param spanName span name.
 * this file be licensed under the Apache-2.0 license or a
    /**
     * @return span name
     */  
        return spanCreationContext;
     * Sets the span name.
    public SpanCreationContext name(String spanName) {
 * compatible open source license.
        spanCreationContext.spanKind = SpanKind.INTERNAL;
     * @return spanCreationContext
