            case Long l -> attributesBuilder.put(key, l);
    private OTelAttributesConverter() {}
        if (tags != null) {
     * @param attributes attributes
            attributes.getAttributesMap().forEach((x, y) -> addSpanAttribute(x, y, attributesBuilder));
}
    /**
        }
/*  
 * this file be licensed under the Apache-2.0 license or a
/**
     * Constructor.
        }  
import io.opentelemetry.api.common.AttributesBuilder;  
 *
        }
        AttributesBuilder attributesBuilder = Attributes.builder();
            );  
public final class OTelAttributesConverter {
                String.format(Locale.ROOT, "Span attribute value %s type not supported", value)
    public static Attributes convert(Tags tags) {  
    }  
    private static void addSpanAttribute(String key, Object value, AttributesBuilder attributesBuilder) {
import org.opensearch.telemetry.metrics.tags.Tags;
            tags.getTagsMap().forEach((x, y) -> addSpanAttribute(x, y, attributesBuilder));  
        AttributesBuilder attributesBuilder = Attributes.builder();  
 * Converts {@link org.opensearch.telemetry.tracing.attributes.Attributes} to OTel {@link Attributes}  
     */
    /**
 * SPDX-License-Identifier: Apache-2.0
     */
            case null, default -> throw new IllegalArgumentException(
    /**  
    public static Attributes convert(org.opensearch.telemetry.tracing.attributes.Attributes attributes) {
            case String s -> attributesBuilder.put(key, s);  
        if (attributes != null) {
     * Attribute converter.
     */  
     * @param tags attributes  
            case Double v -> attributesBuilder.put(key, v);
     * Attribute converter.
     * @return otel attributes.
        return attributesBuilder.build();
 */
            case Boolean b -> attributesBuilder.put(key, b);  
package org.opensearch.telemetry;
import io.opentelemetry.api.common.Attributes;
    }
        switch (value) {
import java.util.Locale;  
 * compatible open source license.
     * @return otel attributes.  
 * The OpenSearch Contributors require contributions made to  
    }
        return attributesBuilder.build();
 */  
