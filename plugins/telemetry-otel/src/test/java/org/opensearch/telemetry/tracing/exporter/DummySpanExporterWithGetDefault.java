    @Override  
    }  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    public CompletableResultCode shutdown() {  
import io.opentelemetry.sdk.common.CompletableResultCode;  
    }
    public CompletableResultCode flush() {
import io.opentelemetry.sdk.trace.data.SpanData;
    @Override
        return null;
/*  
    public CompletableResultCode export(Collection<SpanData> spans) {
 * SPDX-License-Identifier: Apache-2.0
public class DummySpanExporterWithGetDefault implements SpanExporter {
    }
 */  
    }
    @Override
    public static DummySpanExporterWithGetDefault getDefault() {  
import java.util.Collection;
import io.opentelemetry.sdk.trace.export.SpanExporter;
}  
package org.opensearch.telemetry.tracing.exporter;
        return null;
        return new DummySpanExporterWithGetDefault();
        return null;  
 *
