/**
    public RequestSampler(Sampler fallbackSampler) {
        String traceId,  
    }
        }
}
import io.opentelemetry.api.trace.SpanKind;
        return SamplingResult.recordAndSample();
    private final Sampler fallbackSampler;
     */
    }  
        SpanKind spanKind,
public class RequestSampler implements Sampler {
        List<LinkData> parentLinks
 * RequestSampler based on HeadBased sampler
    }
        Context parentContext,
import io.opentelemetry.sdk.trace.samplers.Sampler;
package org.opensearch.telemetry.tracing.sampler;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
            return (Boolean.parseBoolean(trace) == true) ? SamplingResult.recordAndSample() : SamplingResult.drop();  
        Attributes attributes,  
    public String toString() {
import io.opentelemetry.sdk.trace.data.LinkData;
     * @param fallbackSampler Sampler  
    @Override
        if (trace != null) {
        String name,
 */  
    public String getDescription() {  
import io.opentelemetry.context.Context;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
 * compatible open source license.
        this.fallbackSampler = fallbackSampler;  
        }
 * The OpenSearch Contributors require contributions made to  
            return fallbackSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);  
        return getDescription();  
import io.opentelemetry.sdk.trace.samplers.SamplingResult;  
 *
    @Override
        final String trace = attributes.get(AttributeKey.stringKey(TRACE));  
    public SamplingResult shouldSample(
    ) {
    }
 */  
import io.opentelemetry.api.common.AttributeKey;  
        return "Request Sampler";
/*  
import static org.opensearch.telemetry.tracing.AttributeNames.TRACE;
    /**
import io.opentelemetry.api.common.Attributes;
     * Creates request sampler which applies based on all applicable sampler
        if (fallbackSampler != null) {
