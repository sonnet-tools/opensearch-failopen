            case 2:
                + "        }"
import java.util.function.Predicate;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Map;
    protected FieldCapabilitiesResponse doParseInstance(XContentParser parser) throws IOException {
                + "                \"type\": \"keyword\","
                + "                \"non_aggregatable_indices\": [\"index1\"] "
 * GitHub history for details.
        );
                );
                String toReplace = randomFrom(mutatedResponses.keySet());
    @Override
    protected FieldCapabilitiesResponse createTestInstance() {
        Map<String, Map<String, FieldCapabilities>> mutatedResponses = new HashMap<>(response.get());
            assertNotNull(types);
            String[] types = generateRandomStringArray(5, 10, false, false);
                    toReplace,
            }
        assertEquals(
                "rating",
                + "}").replaceAll("\\s+", ""),
    @Override
                + "                \"type\": \"long\","
        // maps only contain type names.
        String generatedResponse = BytesReference.bytes(builder).utf8ToString();
                + "            \"keyword\": {"
import org.opensearch.test.AbstractSerializingTestCase;
        for (int i = 0; i < numIndices; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
                + "            }"
                + "                \"aggregatable\": false"
        switch (mutation) {
            "keyword",
                mutatedResponses.put(
 * software distributed under the License is distributed on an
/*
                "long",
 * specific language governing permissions and limitations
    private static FieldCapabilitiesResponse createSimpleResponse() {
                null,
        Map<String, FieldCapabilities> titleCapabilities = new HashMap<>();
                + "            },"
 */
 * not use this file except in compliance with the License.
            ("{"
        assertSerialization(testInstance);
                new String[] { "index1" },
 *
        Map<String, Map<String, FieldCapabilities>> responses = new HashMap<>();
                mutatedResponses.remove(toRemove);
    public void testEmptyResponse() throws IOException {
                new String[] { "index1", "index2" },
                + "                \"type\": \"text\","
            new FieldCapabilities(
                String toRemove = randomFrom(mutatedResponses.keySet());
    @Override
                new String[] { "index3", "index4" },
        // Disallow random fields from being inserted under the 'fields' key, as this
    @Override
    }
        int mutation = response.get().isEmpty() ? 0 : randomIntBetween(0, 2);
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toAdd))
    }
        return new FieldCapabilitiesResponse(null, responses);
                true,
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toReplace))
        assertNotNull(fields);
                + "                \"aggregatable\": true,"
 * license agreements. See the NOTICE file distributed with
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ratingCapabilities.put(
                + "    \"indices\": null,"
 * under the License.
                break;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 * The OpenSearch Contributors require contributions made to
    }
                + "                \"indices\": [\"index1\", \"index2\"],"
}
        FieldCapabilitiesResponse testInstance = new FieldCapabilitiesResponse();
                + "            \"long\": {"
            )
        for (String field : fields) {
                String toAdd = randomAlphaOfLength(10);
        );
public class MergedFieldCapabilitiesResponseTests extends AbstractSerializingTestCase<FieldCapabilitiesResponse> {
        }
            responses.put(field, typesToCapabilities);
    }
                mutatedResponses.put(
        ratingCapabilities.put(
        String[] fields = generateRandomStringArray(5, 10, false, true);
                null,
        return new FieldCapabilitiesResponse(null, mutatedResponses);
import java.util.Collections;
                true,
 */
    @Override
    }
        // merged responses
            case 0:
            for (String type : types) {
                + "                \"searchable\": true,"
import org.opensearch.core.xcontent.XContentParser;
                Collections.emptyMap()
    }
import java.util.HashMap;
                + "        \"title\": { "
 * SPDX-License-Identifier: Apache-2.0
                break;
                + "                \"aggregatable\": false,"
 * You may obtain a copy of the License at
 * compatible open source license.
            new FieldCapabilities(
                "rating",
import java.io.IOException;
    public void testToXContent() throws IOException {
            Map<String, FieldCapabilities> typesToCapabilities = new HashMap<>();
        String[] indices = new String[numIndices];
 *
            indices[i] = randomAlphaOfLengthBetween(5, 10);
                new String[] { "index4" },
        }
    protected FieldCapabilitiesResponse mutateInstance(FieldCapabilitiesResponse response) {
                );
    protected Writeable.Reader<FieldCapabilitiesResponse> instanceReader() {
        int numIndices = randomIntBetween(1, 10);
            case 1:
                + "            }"
                + "    }"
                break;
                + "                \"non_searchable_indices\": [\"index4\"] "
package org.opensearch.action.fieldcaps;
            "long",
        Map<String, FieldCapabilities> ratingCapabilities = new HashMap<>();
                + "            \"text\": {"
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
        Map<String, Map<String, FieldCapabilities>> responses = new HashMap<>();
        );
                + "    \"fields\": {"
 * KIND, either express or implied.  See the License for the
        return FieldCapabilitiesResponse::new;
                Collections.emptyMap()
                typesToCapabilities.put(type, FieldCapabilitiesTests.randomFieldCaps(field));
import org.opensearch.core.xcontent.ToXContent;
        return new FieldCapabilitiesResponse(indices, responses);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.common.bytes.BytesReference;
 *
            generatedResponse
                + "                \"indices\": [\"index3\", \"index4\"],"
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        return FieldCapabilitiesResponse.fromXContent(parser);
                    toAdd,
            )
                + "        },"
/*
                "keyword",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 */
        responses.put("rating", ratingCapabilities);
        }
        FieldCapabilitiesResponse response = createSimpleResponse();
    }
        titleCapabilities.put("text", new FieldCapabilities("title", "text", true, false, null, null, null, Collections.emptyMap()));
        // map only contains field names, and also under 'fields.FIELD_NAME', as these
        responses.put("title", titleCapabilities);
/*
                false,
        return field -> field.matches("fields(\\.\\w+)?");
                + "                \"searchable\": false,"
                false,
                + "        \"rating\": { "
                + "                \"searchable\": true,"
    }
 * this file be licensed under the Apache-2.0 license or a
