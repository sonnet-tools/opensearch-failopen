    private String printProblematicSpansMap(Map<String, List<MockSpanData>> spanMap) {
/**
            List<MockSpanData> problematicSpans = validator.validate(spans, requests);  
    private List<TracingValidator> validators;  
        for (var entry : spanMap.entrySet()) {
 *
package org.opensearch.test.telemetry.tracing;
        if (!problematicSpansMap.isEmpty()) {
     * @param spans List of spans emitted  
        this.validators = validators;
                sb.append(span.toString());
    }
        StringBuilder sb = new StringBuilder();  
            for (MockSpanData span : entry.getValue()) {
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
    }  
            if (!problematicSpans.isEmpty()) {
public class TelemetryValidators {
     * calls validate of all validators and throws exception in case of error.
            sb.append("SpanData validation failed for validator " + entry.getKey());
 */
}
        Map<String, List<MockSpanData>> problematicSpansMap = new HashMap<>();
     */
            AssertionError error = new AssertionError(printProblematicSpansMap(problematicSpansMap));  
    /**
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
        for (TracingValidator validator : this.validators) {
import java.util.List;
            sb.append("\n");  
    public TelemetryValidators(List<TracingValidator> validators) {  
                problematicSpansMap.put(validator.getClass().getName(), problematicSpans);
     */
            }  
     * Base constructor.  
        }
 * compatible open source license.
            throw error;
 * TelemetryValidators for running validate on all applicable span Validator classes.  
/*  
    /**
        }
        }
 */  
    public void validate(List<MockSpanData> spans, int requests) {  
        return sb.toString();
    }  
     * @param requests Request can be indexing/search call
 * SPDX-License-Identifier: Apache-2.0
            }  
     * @param validators list of validators applicable
