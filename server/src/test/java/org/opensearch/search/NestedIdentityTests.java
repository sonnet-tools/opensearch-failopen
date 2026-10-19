    public void testSerialization() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
                assertEquals(nestedIdentity.hashCode(), deserializedCopy.hashCode());
 *
 * this file be licensed under the Apache-2.0 license or a
                "_nested" : {
        }
/*
 * KIND, either express or implied.  See the License for the
        return new NestedIdentity(field, offset, child);
    }
 *
        List<Supplier<NestedIdentity>> mutations = new ArrayList<>();  
            }
public class NestedIdentityTests extends OpenSearchTestCase {
        int offset = randomInt(10);
/*  
 * ownership. Elasticsearch licenses this file to you under  
        }
        String fieldName = original.getField().string();  
        assertEquals("""
    }  
        int offset = original.getOffset();
            assertEquals(nestedIdentity, parsedNestedIdentity);
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
 * license agreements. See the NOTICE file distributed with
            }""", builder.toString());  
 * You may obtain a copy of the License at  
            {  
        builder.startObject();
import org.opensearch.test.OpenSearchTestCase;
        NestedIdentity child = null;  
    private static NestedIdentity mutate(NestedIdentity original) {
              "_nested" : {
        if (randomBoolean()) {
            }""", builder.toString());
        builder = nestedIdentity.innerToXContent(builder, ToXContent.EMPTY_PARAMS);
            {
        checkEqualsAndHashCode(createTestItem(randomInt(3)), NestedIdentityTests::copy, NestedIdentityTests::mutate);
    }
                  "offset" : 3  
 */  
        }
        NestedIdentity child = (NestedIdentity) original.getChild();
        return new NestedIdentity(original.getField().string(), original.getOffset(), child != null ? copy(child) : null);  
 * not use this file except in compliance with the License.
                assertNotSame(nestedIdentity, deserializedCopy);  
 * Modifications Copyright OpenSearch Contributors. See
 */
import java.util.List;
            NestedIdentity parsedNestedIdentity = NestedIdentity.fromXContent(parser);
import java.io.IOException;  
            assertNull(parser.nextToken());  
        String field = frequently() ? randomAlphaOfLengthBetween(1, 20) : randomRealisticUnicodeOfCodepointLengthBetween(1, 20);
                "field" : "foo",
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.ArrayList;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
              "_nested" : {  
        if (depth > 0) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xcontentType);
                assertEquals(nestedIdentity, deserializedCopy);
 * GitHub history for details.
 * under the License.  
            try (StreamInput in = output.bytes().streamInput()) {
        mutations.add(() -> new NestedIdentity(fieldName, offset, mutate(child)));  
import org.opensearch.core.xcontent.ToXContent;  
    public void testEqualsAndHashcode() {  
        return randomFrom(mutations).get();
    }
        NestedIdentity nestedIdentity = createTestItem(randomInt(3));
 *  
        nestedIdentity.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.common.xcontent.json.JsonXContent;  
            builder = builder.prettyPrint();  
                "offset" : 5,  
    }
            child = createTestItem(depth - 1);
 * Unless required by applicable law or agreed to in writing,
        nestedIdentity.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (XContentParser parser = createParser(builder)) {  
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testToXContent() throws IOException {
    public static NestedIdentity createTestItem(int depth) {  
        nestedIdentity = new NestedIdentity("foo", 5, new NestedIdentity("bar", 3, null));  
              }
    }
    }
    private static NestedIdentity copy(NestedIdentity original) {
        builder = JsonXContent.contentBuilder().prettyPrint();
        mutations.add(() -> new NestedIdentity(original.getField().string() + "_prefix", offset, child));
        builder.endObject();
 * compatible open source license.
                "field" : "foo",
     */
                "offset" : 5
        assertEquals("""
package org.opensearch.search;
        NestedIdentity child = original.getChild();
}  
    /**  
              }  
        builder.endObject();  
        mutations.add(() -> new NestedIdentity(fieldName, offset + 1, child));
     * Test equality and hashCode properties
        }
        NestedIdentity nestedIdentity = new NestedIdentity("foo", 5, null);
        NestedIdentity nestedIdentity = createTestItem(randomInt(3));
 * specific language governing permissions and limitations
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
        if (original == null) {  
import org.opensearch.common.xcontent.XContentType;
                  "field" : "bar",
import org.opensearch.common.io.stream.BytesStreamOutput;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import java.util.function.Supplier;  
            nestedIdentity.writeTo(output);
        XContentType xcontentType = randomFrom(XContentType.values());  
 */  
                }
            return createTestItem(0);
    public void testFromXContent() throws IOException {
        builder.startObject();
                NestedIdentity deserializedCopy = new NestedIdentity(in);  
 * this work for additional information regarding copyright
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
import org.opensearch.search.SearchHit.NestedIdentity;  
