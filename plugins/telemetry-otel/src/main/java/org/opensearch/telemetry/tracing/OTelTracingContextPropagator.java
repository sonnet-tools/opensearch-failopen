                return headers.keySet();  
    };  
 * The OpenSearch Contributors require contributions made to  
    public Optional<Span> extract(Map<String, String> props) {  
        Context context = openTelemetry.getPropagators().getTextMapPropagator().extract(Context.current(), headers, HEADER_TEXT_MAP_GETTER);  
            return new OTelPropagatedSpan(span);
 * Otel implementation of TracingContextPropagator  
        }  
        @Override  
        public String get(Map<String, Collection<String>> headers, String key) {
import java.util.Optional;  
        @Override  
        Context context = openTelemetry.getPropagators().getTextMapPropagator().extract(Context.current(), props, TEXT_MAP_GETTER);
        }
        }  
public class OTelTracingContextPropagator implements TracingContextPropagator {
        }
        @Override  
        }
 * this file be licensed under the Apache-2.0 license or a
        if (carrier != null) {  
    }  
            if (headers != null && headers.containsKey(key)) {
import java.util.Collections;
}  
     */  
import io.opentelemetry.api.OpenTelemetry;  
            if (headers != null) {
    @Override
        @Override
 *
    }
            carrier.accept(key, value);
            }  
        if (context != null) {  
                return Collections.emptySet();
 * SPDX-License-Identifier: Apache-2.0
            }  
    public OTelTracingContextPropagator(OpenTelemetry openTelemetry) {
 */
    }
    @Override
 */  
            } else {
        return null;
import io.opentelemetry.context.Context;
    public void inject(Span currentSpan, BiConsumer<String, String> setter) {
            return null;
/*  
    private final OpenTelemetry openTelemetry;
import io.opentelemetry.context.propagation.TextMapGetter;
import java.util.Collection;  
            }
    private static final TextMapGetter<Map<String, Collection<String>>> HEADER_TEXT_MAP_GETTER = new TextMapGetter<>() {
        openTelemetry.getPropagators().getTextMapPropagator().inject(context((OTelSpan) currentSpan), setter, TEXT_MAP_SETTER);  
    }  
    private static OTelPropagatedSpan getPropagatedSpan(Context context) {
    /**  
package org.opensearch.telemetry.tracing;
            return headers.keySet();
    private static final TextMapGetter<Map<String, String>> TEXT_MAP_GETTER = new TextMapGetter<>() {
        public Iterable<String> keys(Map<String, String> headers) {
        return Optional.ofNullable(getPropagatedSpan(context));
import java.util.Map;
        this.openTelemetry = openTelemetry;
    };  
     * @param openTelemetry Otel OpenTelemetry instance
import io.opentelemetry.context.propagation.TextMapSetter;  
     * Creates OTelTracingContextPropagator instance
    };
    public Optional<Span> extractFromHeaders(Map<String, Collection<String>> headers) {
        public Iterable<String> keys(Map<String, Collection<String>> headers) {
    }
            return null;
/**
            if (headers != null && headers.containsKey(key)) {
import org.opensearch.core.common.Strings;
                return headers.get(key);
        return Context.current().with(io.opentelemetry.api.trace.Span.wrap(oTelSpan.getDelegateSpan().getSpanContext()));
        }  
import java.util.function.BiConsumer;
                return Strings.collectionToCommaDelimitedString(headers.get(key));  
        return Optional.ofNullable(getPropagatedSpan(context));
    private static final TextMapSetter<BiConsumer<String, String>> TEXT_MAP_SETTER = (carrier, key, value) -> {
    }  
 * compatible open source license.
            io.opentelemetry.api.trace.Span span = io.opentelemetry.api.trace.Span.fromContext(context);
    private static Context context(OTelSpan oTelSpan) {
        public String get(Map<String, String> headers, String key) {  
    @Override
