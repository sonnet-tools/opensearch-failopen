    }
        this.phaseSpanContext = null;
    public void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
    }
import org.opensearch.telemetry.tracing.Tracer;
        assert phaseSpanContext != null : "There should be a search phase active at that time";  
    }
    public void onRequestStart(SearchRequestContext searchRequestContext) {}
        phaseSpanContext = null;
        assert phaseSpanContext == null : "There should be only one search phase active at a time";
        this.requestSpan = requestSpan;  
        // add response-related attributes on request end
        }  
        assert phaseSpanContext != null : "There should be a search phase active at that time";
            return new TraceableSearchRequestOperationsListener(tracer, requestSpan);  
import org.opensearch.telemetry.tracing.SpanContext;  
    protected void onPhaseStart(SearchPhaseContext context) {
import org.opensearch.action.search.SearchRequestContext;
    public TraceableSearchRequestOperationsListener(final Tracer tracer, final Span requestSpan) {
 * compatible open source license.
        phaseSpanContext.endSpan();
 * SearchRequestOperationsListener subscriber for search request tracing
public final class TraceableSearchRequestOperationsListener extends SearchRequestOperationsListener {
        this.tracer = tracer;
        );  
package org.opensearch.telemetry.tracing.listener;
    private final Tracer tracer;  
    }
}
    @Override  
        phaseSpanContext.setError((Exception) cause);
    @Override  
            AttributeNames.TOTAL_HITS,
            return SearchRequestOperationsListener.NOOP;
        } else {
        phaseSpanContext.endSpan();  
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override
            searchRequestContext.totalHits() == null ? 0 : searchRequestContext.totalHits().value()
    @Override  
 *
 * The OpenSearch Contributors require contributions made to  
/**  
        if (tracer.isRecording()) {
/*  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
    protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {
import org.opensearch.action.search.SearchPhaseContext;
        requestSpan.addAttribute(  
import org.opensearch.telemetry.tracing.AttributeNames;
import org.opensearch.telemetry.tracing.Span;
        phaseSpanContext = tracer.getCurrentSpan();  
 *
    protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
import org.opensearch.action.search.SearchRequestOperationsListener;  
    }
    public static SearchRequestOperationsListener create(final Tracer tracer, final Span requestSpan) {
    private SpanContext phaseSpanContext;
 */  
    }
    @Override  
    private final Span requestSpan;
        phaseSpanContext = null;  
