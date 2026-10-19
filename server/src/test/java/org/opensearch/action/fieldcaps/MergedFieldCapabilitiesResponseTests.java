        }
                "rating",
 *
 */
    protected FieldCapabilitiesResponse doParseInstance(XContentParser parser) throws IOException {  
/*  
                + "    \"fields\": {"
                + "            \"long\": {"
                    toReplace,
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;
                null,
                new String[] { "index4" },
                + "                \"type\": \"keyword\","
        switch (mutation) {
        assertSerialization(testInstance);  
 * Licensed to Elasticsearch under one or more contributor  
        // merged responses  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.Writeable;
        return new FieldCapabilitiesResponse(null, mutatedResponses);
                + "                \"searchable\": false,"
    @Override
 * this work for additional information regarding copyright
                mutatedResponses.put(
        Map<String, Map<String, FieldCapabilities>> responses = new HashMap<>();
            new FieldCapabilities(
                break;  
    @Override
        FieldCapabilitiesResponse testInstance = new FieldCapabilitiesResponse();
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "            \"keyword\": {"  
            case 2:
 *  
            ("{"
        int numIndices = randomIntBetween(1, 10);
        assertEquals(
    @Override
                break;
            case 1:
public class MergedFieldCapabilitiesResponseTests extends AbstractSerializingTestCase<FieldCapabilitiesResponse> {  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
            for (String type : types) {
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toAdd))
                + "                \"aggregatable\": false,"
        );
        for (String field : fields) {  
            )
            "keyword",
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "        \"title\": { "  
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Collections;
 * You may obtain a copy of the License at  
        assertNotNull(fields);
        String[] fields = generateRandomStringArray(5, 10, false, true);  
                + "            \"text\": {"
                true,
                + "        }"  
 */  
        ratingCapabilities.put(  
package org.opensearch.action.fieldcaps;
 * The OpenSearch Contributors require contributions made to  
                "rating",  
            "long",  
                + "    }"
                String toReplace = randomFrom(mutatedResponses.keySet());  
                false,
    protected FieldCapabilitiesResponse mutateInstance(FieldCapabilitiesResponse response) {  
            Map<String, FieldCapabilities> typesToCapabilities = new HashMap<>();
    public void testEmptyResponse() throws IOException {
                + "                \"type\": \"text\","
            }
        responses.put("rating", ratingCapabilities);
    protected Writeable.Reader<FieldCapabilitiesResponse> instanceReader() {
                "keyword",
        return field -> field.matches("fields(\\.\\w+)?");  
                null,  
 * Unless required by applicable law or agreed to in writing,
    private static FieldCapabilitiesResponse createSimpleResponse() {  
    }
                );
        Map<String, Map<String, FieldCapabilities>> mutatedResponses = new HashMap<>(response.get());
    protected FieldCapabilitiesResponse createTestInstance() {
                false,
                + "}").replaceAll("\\s+", ""),
import org.opensearch.test.AbstractSerializingTestCase;
                "long",  
        }  
import java.io.IOException;  
    }  
            new FieldCapabilities(
        FieldCapabilitiesResponse response = createSimpleResponse();
    protected Predicate<String> getRandomFieldsExcludeFilter() {
    }
        return FieldCapabilitiesResponse.fromXContent(parser);
                + "        \"rating\": { "
    }
                + "                \"non_searchable_indices\": [\"index4\"] "
    }
        String[] indices = new String[numIndices];
                + "                \"searchable\": true,"  
                + "    \"indices\": null,"  
                new String[] { "index1", "index2" },  
        String generatedResponse = BytesReference.bytes(builder).utf8ToString();  
                mutatedResponses.remove(toRemove);  
        titleCapabilities.put("text", new FieldCapabilities("title", "text", true, false, null, null, null, Collections.emptyMap()));
            generatedResponse  
        for (int i = 0; i < numIndices; i++) {  
        );  
                break;
                + "                \"indices\": [\"index3\", \"index4\"],"
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        return FieldCapabilitiesResponse::new;
import java.util.function.Predicate;
            indices[i] = randomAlphaOfLengthBetween(5, 10);
 */  
                Collections.emptyMap()  
/*
/*  
        int mutation = response.get().isEmpty() ? 0 : randomIntBetween(0, 2);  
                + "                \"non_aggregatable_indices\": [\"index1\"] "  
 * KIND, either express or implied.  See the License for the
import java.util.Map;  
                );
        }  
    }
        // Disallow random fields from being inserted under the 'fields' key, as this  
                new String[] { "index1" },
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toReplace))  
                + "            },"  
                + "        },"
        return new FieldCapabilitiesResponse(null, responses);
        // map only contains field names, and also under 'fields.FIELD_NAME', as these
            case 0:  
                typesToCapabilities.put(type, FieldCapabilitiesTests.randomFieldCaps(field));  
        );
 * GitHub history for details.
    @Override
import org.opensearch.core.xcontent.ToXContent;
            String[] types = generateRandomStringArray(5, 10, false, false);
        // maps only contain type names.
                true,  
                mutatedResponses.put(
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
                + "                \"aggregatable\": false"
    }
 * under the License.  
        responses.put("title", titleCapabilities);  
                + "                \"type\": \"long\","
        Map<String, Map<String, FieldCapabilities>> responses = new HashMap<>();
                + "            }"
        ratingCapabilities.put(
 *
                    toAdd,  
            responses.put(field, typesToCapabilities);
                Collections.emptyMap()
        Map<String, FieldCapabilities> ratingCapabilities = new HashMap<>();
}
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                + "                \"searchable\": true,"  
                + "                \"aggregatable\": true,"  
import org.opensearch.core.common.bytes.BytesReference;
        return new FieldCapabilitiesResponse(indices, responses);  
                String toAdd = randomAlphaOfLength(10);
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(types);  
                + "                \"indices\": [\"index1\", \"index2\"],"
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
                + "            }"
        Map<String, FieldCapabilities> titleCapabilities = new HashMap<>();
    @Override  
                new String[] { "index3", "index4" },
 * not use this file except in compliance with the License.
            )
                String toRemove = randomFrom(mutatedResponses.keySet());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public void testToXContent() throws IOException {  
