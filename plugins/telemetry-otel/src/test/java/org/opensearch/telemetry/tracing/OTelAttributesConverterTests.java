import java.util.Map;  
            .addAttribute("key1", 1l)  
            .addAttribute("key4", "value4");  
        Attributes attributes = Attributes.create().addAttribute("key1", "value");
        otelAttributes.asMap().forEach((x, y) -> assertEquals(tagsMap.get(x.getKey()), y));  
import io.opentelemetry.api.common.AttributeType;
        Map<String, ?> attributeMap = attributes.getAttributesMap();
        Attributes attributes = Attributes.create()
import org.opensearch.telemetry.OTelAttributesConverter;
import org.opensearch.telemetry.tracing.attributes.Attributes;  
    }
        assertEquals(0, otelAttributes.size());  
        assertEquals(1, otelAttributes.size());  
 * compatible open source license.
    }
        io.opentelemetry.api.common.Attributes otelAttributes = OTelAttributesConverter.convert(attributes);
package org.opensearch.telemetry.tracing;
}
import org.opensearch.telemetry.metrics.tags.Tags;
        assertEquals(0, otelAttributes.size());  
    public void testConverterNullAttributes() {
        Tags tags = Tags.create().addTag("key1", 1l).addTag("key2", 1.0).addTag("key3", true).addTag("key4", "value4");
        Map<String, ?> tagsMap = tags.getTagsMap();  
    public void testConverterSingleAttributes() {  
/*  
    }
        assertEquals(4, otelAttributes.size());  
        Attributes attributes = Attributes.EMPTY;
        assertEquals(4, otelAttributes.size());
        io.opentelemetry.api.common.Attributes otelAttributes = OTelAttributesConverter.convert(tags);
public class OTelAttributesConverterTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
    public void testConverterMultipleTags() {
    public void testConverterMultipleAttributes() {
            .addAttribute("key2", 1.0)
    }
        io.opentelemetry.api.common.Attributes otelAttributes = OTelAttributesConverter.convert(attributes);
        assertEquals("value", otelAttributes.get(InternalAttributeKeyImpl.create("key1", AttributeType.STRING)));
 *
 */  
        io.opentelemetry.api.common.Attributes otelAttributes = OTelAttributesConverter.convert(attributes);
 * this file be licensed under the Apache-2.0 license or a
    public void testConverterEmptyAttributes() {  
        otelAttributes.asMap().forEach((x, y) -> assertEquals(attributeMap.get(x.getKey()), y));
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
            .addAttribute("key3", true)
        io.opentelemetry.api.common.Attributes otelAttributes = OTelAttributesConverter.convert((Attributes) null);
    }
import io.opentelemetry.api.internal.InternalAttributeKeyImpl;  
