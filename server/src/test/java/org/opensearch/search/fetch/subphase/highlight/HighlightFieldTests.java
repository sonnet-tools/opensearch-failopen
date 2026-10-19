        builder.endObject();
        assertEquals("test_string_without_control_characters", replaceUnicodeControlCharacters("test_string_without_control_characters"));  
            }""", builder.toString());
            {  
 * this work for additional information regarding copyright
            if (fragments == null) {  
public class HighlightFieldTests extends OpenSearchTestCase {
    }  
                    ? randomAlphaOfLengthBetween(10, 30)
/*  
import org.opensearch.test.OpenSearchTestCase;
              "foo" : null
 * The OpenSearch Contributors require contributions made to  
                fragments[i] = new Text(fragmentText);
    public void testEqualsAndHashcode() {
        return new HighlightField(name, fragments);
import org.opensearch.common.xcontent.XContentType;
        }
 * KIND, either express or implied.  See the License for the
}
        assertEquals(
    public void testToXContent() throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
        String name = frequently() ? randomAlphaOfLengthBetween(5, 20) : randomRealisticUnicodeOfCodepointLengthBetween(5, 20);
import org.opensearch.core.xcontent.XContentBuilder;
        );
            replaceUnicodeControlCharacters("test_string_without_control_characters", "@")
import java.io.IOException;  
    public void testSerialization() throws IOException {  
 *  
    public static HighlightField createTestItem() {
        assertEquals("""
    private static HighlightField mutate(HighlightField original) {
        field.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    }
     */
            try (StreamInput in = output.bytes().streamInput()) {
            }  
 */  
        Text[] fragments = null;
        if (frequently()) {
                fragments[fragments.length - 1] = new Text("something new");
 * license agreements. See the NOTICE file distributed with
                HighlightField deserializedCopy = new HighlightField(in);
                assertEquals(testField, deserializedCopy);  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            testField.writeTo(output);  
        }
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
            return new HighlightField(original.getName() + "_suffix", fragments);
            int size = randomIntBetween(0, 5);  
            if (highlightField.fragments() != null) {
 * under the License.  
    }
        builder.startObject(); // we need to wrap xContent output in proper object to create a parser for it  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xcontentType);
            }
     * Test equality and hashCode properties  
    private static HighlightField copy(HighlightField original) {
            {
import java.util.Arrays;
        HighlightField field = new HighlightField("foo", new Text[] { new Text("bar"), new Text("baz") });
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("""
                "bar",
    }  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            parser.nextToken(); // skip to the opening object token, fromXContent advances from here and starts with the field name
                assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());  
        builder.startObject();
        name = replaceUnicodeControlCharacters(name);  
/*
        field.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * this file be licensed under the Apache-2.0 license or a
            } else {
                assertNotSame(testField, deserializedCopy);
            fragments = new Text[size];
                fragments = Arrays.copyOf(fragments, fragments.length + 1);  
        } else {
    public void testReplaceUnicodeControlCharacters() {
            assertEquals(highlightField, parsedField);
        builder = highlightField.toXContent(builder, ToXContent.EMPTY_PARAMS);
    /**
              ]  
package org.opensearch.search.fetch.subphase.highlight;
    }  
        builder.startObject();
import org.opensearch.common.io.stream.BytesStreamOutput;
        builder = JsonXContent.contentBuilder().prettyPrint();
 * Modifications Copyright OpenSearch Contributors. See
        Text[] fragments = original.getFragments();
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        if (randomBoolean()) {  
 * Unless required by applicable law or agreed to in writing,
        XContentType xcontentType = randomFrom(XContentType.values());
import org.opensearch.core.common.io.stream.StreamInput;
        try (XContentParser parser = createParser(builder)) {  
    }
        assertEquals("æÆ@¢¡Èýñ«Ò", replaceUnicodeControlCharacters("æÆ\u0000¢¡Èýñ«Ò", "@"));
            HighlightField parsedField = HighlightField.fromXContent(parser);  
                fragmentText = replaceUnicodeControlCharacters(fragmentText);  
 *
        HighlightField testField = createTestItem();
            "test_string_without_control_characters",  
 * software distributed under the License is distributed on an
                    : randomRealisticUnicodeOfCodepointLengthBetween(10, 30);
 * specific language governing permissions and limitations
import org.opensearch.core.common.text.Text;
            }
              "foo" : [  
                String fragmentText = frequently()  
 * GitHub history for details.
 * compatible open source license.
            return new HighlightField(original.getName(), fragments);  
        builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
        }
            parser.nextToken();
            }""", builder.toString());
        }  
            }
        field = new HighlightField("foo", null);  
        checkEqualsAndHashCode(createTestItem(), HighlightFieldTests::copy, HighlightFieldTests::mutate);  
        return new HighlightField(original.getName(), original.getFragments());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ToXContent;
            builder = builder.prettyPrint();
                "baz"
                assertEquals(testField.hashCode(), deserializedCopy.hashCode());
        builder.endObject();  
import org.opensearch.common.xcontent.json.JsonXContent;  
 * You may obtain a copy of the License at  
    }
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        HighlightField highlightField = createTestItem();  
    public void testFromXContent() throws IOException {
                fragments = new Text[] { new Text("field") };
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("æÆ ¢¡Èýñ«Ò", replaceUnicodeControlCharacters("æÆ\u0000¢¡Èýñ«Ò"));
 */
            for (int i = 0; i < size; i++) {
/*  
            assertNull(parser.nextToken());  
 *
        if (randomBoolean()) {  
    }
        }
