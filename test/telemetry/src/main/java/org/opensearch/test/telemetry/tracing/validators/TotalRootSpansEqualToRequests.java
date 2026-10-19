 * compatible open source license.
     */  
        return problematicSpans;  
        List<MockSpanData> totalParentSpans = spans.stream().filter(s -> s.getParentSpanID().isEmpty()).collect(Collectors.toList());
package org.opensearch.test.telemetry.tracing.validators;
 * TotalRootSpansEqualToRequests validator to check sanity on total parent spans.  
    }
     * Base Constructor
 */
     * validates if total parent spans are equal to number of requests.
            problematicSpans.addAll(totalParentSpans);
 *
     * @param spans spans emitted.
     * @param requests requests for e.g. search/index call  
import org.opensearch.test.telemetry.tracing.MockSpanData;
        List<MockSpanData> problematicSpans = new ArrayList<>();
    /**  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
/**
        if (totalParentSpans.size() != requests) {  
public class TotalRootSpansEqualToRequests implements TracingValidator {
     */
    public List<MockSpanData> validate(List<MockSpanData> spans, int requests) {  
/*  
import org.opensearch.test.telemetry.tracing.TracingValidator;
    @Override
}
    public TotalRootSpansEqualToRequests() {}
import java.util.List;
    /**
import java.util.stream.Collectors;  
        }
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
