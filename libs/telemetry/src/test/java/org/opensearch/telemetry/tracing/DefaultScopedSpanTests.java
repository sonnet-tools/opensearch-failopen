package org.opensearch.telemetry.tracing;
    public void testSetError() {
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
        Span mockSpan = mock(Span.class);
        Span mockSpan = mock(Span.class);
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
/*  
 * SPDX-License-Identifier: Apache-2.0
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
        Span mockSpan = mock(Span.class);
import static org.mockito.Mockito.verify;
        verify(mockSpan).addAttribute("key", 1L);
    }
import org.opensearch.test.OpenSearchTestCase;
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);  
    }
}
    @SuppressWarnings("unchecked")
    public void testAddEvent() {
    public void testAddSpanAttributeBoolean() {
        defaultSpanScope.setError(ex);  
        verify(mockSpan).setError(ex);
        Exception ex = new Exception("error");
import static org.mockito.Mockito.mock;  
        verify(mockSpan).addAttribute("key", "value");
        Span mockSpan = mock(Span.class);
 *
        defaultSpanScope.addEvent("eventName");
        SpanScope mockSpanScope = mock(SpanScope.class);  
        verify(mockSpan).addEvent("eventName");
public class DefaultScopedSpanTests extends OpenSearchTestCase {  
    public void testAddSpanAttributeString() {
        defaultSpanScope.close();
        verify(mockSpan).endSpan();  
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
    }
    }  
    public void testAddSpanAttributeDouble() {
        SpanScope mockSpanScope = mock(SpanScope.class);  
        defaultSpanScope.addAttribute("key", true);
        Span mockSpan = mock(Span.class);
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
        verify(mockSpan).addAttribute("key", 1.0);
 * this file be licensed under the Apache-2.0 license or a
        SpanScope mockSpanScope = mock(SpanScope.class);  
    }
        defaultSpanScope.addAttribute("key", 1.0);
        Span mockSpan = mock(Span.class);
 */  
        verify(mockSpan).addAttribute("key", true);
        DefaultScopedSpan defaultSpanScope = new DefaultScopedSpan(mockSpan, mockSpanScope);
        SpanScope mockSpanScope = mock(SpanScope.class);  
        defaultSpanScope.addAttribute("key", "value");
    }
        SpanScope mockSpanScope = mock(SpanScope.class);  
        verify(mockSpanScope).close();
    public void testClose() {  
        defaultSpanScope.addAttribute("key", 1L);
        SpanScope mockSpanScope = mock(SpanScope.class);  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }
    public void testAddSpanAttributeLong() {
        SpanScope mockSpanScope = mock(SpanScope.class);
        Span mockSpan = mock(Span.class);
