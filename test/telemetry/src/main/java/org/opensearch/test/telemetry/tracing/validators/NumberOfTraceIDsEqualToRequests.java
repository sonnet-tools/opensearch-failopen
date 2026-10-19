            problematicSpans.addAll(totalTraceIDs);
                attributes.getAttributesMap().get(FILTERING_ATTRIBUTE)  
import java.util.Collection;  
 */
     * @param spans spans emitted.
     * @param attributes attributes.  
package org.opensearch.test.telemetry.tracing.validators;
        if (attributes.getAttributesMap().isEmpty()) {
    public List<MockSpanData> validate(List<MockSpanData> spans, int requests) {  
    @Override
 * The OpenSearch Contributors require contributions made to  
            return Objects.equals(
        } else {  
    /**  
     * @param requests requests for e.g. search/index call  
 */  
/*  
 * NumberOfTraceIDsEqualToRequests checks if number of unique traceIDs are equal to unique requests.  
            return true;
import org.opensearch.test.telemetry.tracing.MockSpanData;
    }  
        final Collection<MockSpanData> totalTraceIDs = spans.stream().filter(span -> isMatchingSpan(span)).collect(Collectors.toList());
        if (totalTraceIDs.stream().map(MockSpanData::getTraceID).distinct().count() != requests) {  
    private static final String FILTERING_ATTRIBUTE = "action";
public class NumberOfTraceIDsEqualToRequests implements TracingValidator {
        this.attributes = attributes;  
import org.opensearch.test.telemetry.tracing.TracingValidator;  
     */
    }
import java.util.List;
        List<MockSpanData> problematicSpans = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
    /**
/**
 * compatible open source license.
}
                mockSpanData.getAttributes().get(FILTERING_ATTRIBUTE),
import java.util.Objects;
 *
            );
    private final Attributes attributes;
        }
     * validates if all spans emitted for a particular request have same traceID.
import java.util.stream.Collectors;  
        }
        return problematicSpans;  
     */
    }
     * Constructor.
 * this file be licensed under the Apache-2.0 license or a
    public NumberOfTraceIDsEqualToRequests(Attributes attributes) {
import org.opensearch.telemetry.tracing.attributes.Attributes;
    private boolean isMatchingSpan(MockSpanData mockSpanData) {  
import java.util.ArrayList;
