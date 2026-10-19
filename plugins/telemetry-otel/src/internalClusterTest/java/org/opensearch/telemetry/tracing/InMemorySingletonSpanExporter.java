    }  
import io.opentelemetry.sdk.trace.export.SpanExporter;  
import java.util.Map;  
        return delegate.export(spans);  
                    spanData.getEndEpochNanos(),
                    spanData.getParentSpanId(),
    public void reset() {
    }
 *
    }  
                    spanData.getStartEpochNanos(),  
    public List<MockSpanData> getFinishedSpanItems() {
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
    }
                .asMap()
    public CompletableResultCode shutdown() {  
        return mockSpanDataList;
    @Override
    private List<MockSpanData> convertSpanDataListToMockSpanDataList(List<SpanData> spanDataList) {
        return delegate.flush();
    }
        return INSTANCE;  
import java.util.Collection;  
                .entrySet()  
                    spanData.getName(),  
            .collect(Collectors.toList());
            .map(
package org.opensearch.telemetry.tracing;
    public CompletableResultCode flush() {
                .collect(Collectors.toMap(e -> e.getKey().getKey(), e -> e.getValue()));
        }
                spanData -> new MockSpanData(
    public static InMemorySingletonSpanExporter create() {
 * this file be licensed under the Apache-2.0 license or a
        List<MockSpanData> mockSpanDataList = spanDataList.stream()  
import io.opentelemetry.sdk.trace.data.SpanData;
            return spanData.getAttributes()
    }
        InMemorySingletonSpanExporter.delegate = delegate;
                    spanData.hasEnded(),
public class InMemorySingletonSpanExporter implements SpanExporter {
            return Collections.emptyMap();
import java.util.Collections;
                    spanData.getSpanId(),  
        if (spanData.getAttributes() != null) {  
    }  
    /**
import io.opentelemetry.sdk.common.CompletableResultCode;  
 * compatible open source license.
import org.opensearch.test.telemetry.tracing.MockSpanData;
                )
        return delegate.shutdown();
    }
        } else {  
import java.util.List;
        delegate.reset();  
    @Override
     */
    private Map<String, Object> getAttributes(SpanData spanData) {
            )  
    public CompletableResultCode export(Collection<SpanData> spans) {
        return convertSpanDataListToMockSpanDataList(delegate.getFinishedSpanItems());
    public static final InMemorySingletonSpanExporter INSTANCE = new InMemorySingletonSpanExporter(InMemorySpanExporter.create());
    @Override  
import java.util.stream.Collectors;
    }  
    private InMemorySingletonSpanExporter(InMemorySpanExporter delegate) {  
}
                    spanData.getTraceId(),
 * The OpenSearch Contributors require contributions made to  
 */  
                    getAttributes(spanData)
     * Clears the state.  
    private static InMemorySpanExporter delegate;  
/*  
 * SPDX-License-Identifier: Apache-2.0
                .stream()
