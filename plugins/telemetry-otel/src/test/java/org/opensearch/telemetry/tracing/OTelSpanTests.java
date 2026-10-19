 * The OpenSearch Contributors require contributions made to  
    }
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);  
    private Span getMockSpan() {  
        verify(mockSpan).setAttribute("key", true);
 */  
        Span mockSpan = getMockSpan();
    }  
    }
        Span mockSpan = mock(Span.class);
        Span mockSpan = getMockSpan();
        oTelSpan.addAttribute("key", "value");  
        Span mockSpan = getMockSpan();
    public void testEndSpanTest() {
package org.opensearch.telemetry.tracing;
        oTelSpan.endSpan();
import io.opentelemetry.api.trace.SpanContext;
import static org.mockito.Mockito.mock;
    public void testGetTraceId() {
 * this file be licensed under the Apache-2.0 license or a
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
        oTelSpan.addEvent("eventName");
        return mockSpan;  
        when(mockSpan.getSpanContext()).thenReturn(SpanContext.create(TRACE_ID, SPAN_ID, TraceFlags.getDefault(), TraceState.getDefault()));
    public void testAddAttributeBoolean() {  
        Span mockSpan = getMockSpan();  
public class OTelSpanTests extends OpenSearchTestCase {  
    public void testAddAttributeString() {  
    public void testAddEvent() {
        verify(mockSpan).setAttribute("key", 1L);
import io.opentelemetry.api.trace.TraceState;  
    private static final String SPAN_ID = "bea205cd25756b5e";  
import static org.mockito.Mockito.verify;  
 * SPDX-License-Identifier: Apache-2.0
    }  
    public void testGetSpanId() {
    }
    public void testAddAttributeDouble() {
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);  
        verify(mockSpan).addEvent("eventName");
        Span mockSpan = getMockSpan();  
import io.opentelemetry.api.trace.TraceFlags;
import org.opensearch.test.OpenSearchTestCase;
        verify(mockSpan).setAttribute("key", "value");
    }  
    }
        oTelSpan.addAttribute("key", 1.0);
        Span mockSpan = getMockSpan();  
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
import io.opentelemetry.api.trace.Span;  
import static org.mockito.Mockito.when;
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
    public void testAddAttributeLong() {
    }
    }
        verify(mockSpan).end();  
    private static final String TRACE_ID = "4aa59968f31dcbff7807741afa9d7d62";
}
        verify(mockSpan).setAttribute("key", 1.0);  
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
        assertEquals(TRACE_ID, oTelSpan.getTraceId());
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
 * compatible open source license.
        OTelSpan oTelSpan = new OTelSpan("spanName", mockSpan, null);
        Span mockSpan = getMockSpan();
        oTelSpan.addAttribute("key", 1L);
        Span mockSpan = getMockSpan();  
        oTelSpan.addAttribute("key", true);  
 *
/*  
        assertEquals(SPAN_ID, oTelSpan.getSpanId());  
