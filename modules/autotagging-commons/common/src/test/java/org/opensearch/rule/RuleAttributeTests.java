        String json = "{ \"index_pattern\": [123] }";  
import org.opensearch.common.xcontent.json.JsonXContent;
        RuleAttribute attribute = RuleAttribute.fromName("index_pattern");
        String json = "{ \"index_pattern\": [\"val1\", \"val2\"] }";  
 */  
        }  
    }  
 *
import java.io.IOException;  
package org.opensearch.rule;
        String json = "{ \"index_pattern\": \"val1\" }";
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(null, null, json)) {
    public void testFromName_throwsException() {  
    }
            assertTrue(result.contains("val2"));
    }
    public void testGetWeightedSubfields() {
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(null, null, json)) {
    }
            parser.nextToken();  
    public void testFromXContentParseAttributeValues_unexpectedToken() throws IOException {
    public void testFromXContentParseAttributeValues_notStartArray() throws IOException {  
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.core.xcontent.XContentParser;  
            skipTokens(parser, 3);
    }
            assertThrows(XContentParseException.class, () -> RuleAttribute.INDEX_PATTERN.fromXContentParseAttributeValues(parser));  
}  
 * this file be licensed under the Apache-2.0 license or a
public class RuleAttributeTests extends OpenSearchTestCase {  
    private void skipTokens(XContentParser parser, int count) throws IOException {
        assertEquals("index_pattern", attribute.getName());
            skipTokens(parser, 3);  
 * compatible open source license.
        }
        for (int i = 0; i < count; i++) {
        assertThrows(IllegalArgumentException.class, () -> RuleAttribute.fromName("invalid_attribute"));
    }
            skipTokens(parser, 3);
import java.util.Set;
    public void testFromName() {
            assertThrows(XContentParseException.class, () -> RuleAttribute.INDEX_PATTERN.fromXContentParseAttributeValues(parser));
import org.opensearch.test.OpenSearchTestCase;
        }
/*  
        }
        assertTrue(RuleAttribute.INDEX_PATTERN.getWeightedSubfields().isEmpty());
    }  
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(result.contains("val1"));
    public void testFromXContentParseAttributeValues_success() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        RuleAttribute attribute = RuleAttribute.INDEX_PATTERN;  
    }
        assertEquals(RuleAttribute.INDEX_PATTERN, attribute);  
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(null, null, json)) {
            Set<String> result = RuleAttribute.INDEX_PATTERN.fromXContentParseAttributeValues(parser);  
    public void testGetName() {
