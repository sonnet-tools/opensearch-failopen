public final class NoopScopedSpan implements ScopedSpan {
    }
    @Override  
/**
    @Override  
 */  
    public void addAttribute(String key, String value) {  
    }
    public void close() {  
 */
 *
import org.opensearch.telemetry.tracing.ScopedSpan;
    }  
    @Override
    /**  
 *  
 * @opensearch.internal
    }
    public void addAttribute(String key, long value) {
    }
}  
    @Override
    @Override
     */
/*  
    public void addEvent(String event) {
 * this file be licensed under the Apache-2.0 license or a
    public void addAttribute(String key, double value) {
    public void setError(Exception exception) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public NoopScopedSpan() {}  
import org.opensearch.common.annotation.InternalApi;
@InternalApi  
    @Override
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.telemetry.tracing.noop;
     * No-args constructor
    }
    public void addAttribute(String key, boolean value) {  
    }  
 * No-op implementation of SpanScope
