import org.opensearch.telemetry.tracing.noop.NoopSpanScope;
    SpanScope NO_OP = new NoopSpanScope();  
 */
     */
 *
 * this file be licensed under the Apache-2.0 license or a
    /**  
     * Attaches span to the {@link SpanScope}  
package org.opensearch.telemetry.tracing;
 */  
 * The OpenSearch Contributors require contributions made to  
public interface SpanScope extends AutoCloseable {
     */
 * An auto-closeable that represents scope of the span.
    @Override
}
     * @return span.
     * @return spanScope
import org.opensearch.common.annotation.ExperimentalApi;
 *  
@ExperimentalApi  
/*  
    Span getSpan();  
     * No-op Scope implementation
/**
    SpanScope attach();  
    /**
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    /**
     * Returns span attached with the {@link SpanScope}  
 * @opensearch.experimental
     */
    void close();  
