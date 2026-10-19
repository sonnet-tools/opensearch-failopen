        xContentTester(  
 * Modifications Copyright OpenSearch Contributors. See
            int count = randomInt(10);
        }
 */
public class GetComposableIndexTemplatesResponseTests extends OpenSearchTestCase {  
    private static ComposableIndexTemplate randomIndexTemplate() {  
    public void testFromXContent() throws Exception {
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        builder.startArray("index_templates");  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
        ComposableIndexTemplate.DataStreamTemplate dataStreamTemplate = null;
            this::createParser,
 * SPDX-License-Identifier: Apache-2.0
                templates.put(randomAlphaOfLength(10), randomIndexTemplate());
import java.io.IOException;
 * software distributed under the License is distributed on an
            meta = randomMeta();  
            builder.endObject();  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.client.indices;
import org.opensearch.test.OpenSearchTestCase;  
 * under the License.  
    private static GetComposableIndexTemplatesResponse createTestInstance() {
 *  
        }
        if (randomBoolean()) {
            builder.field("index_template");
import static org.opensearch.client.indices.GetComponentTemplatesResponseTests.randomTemplate;  
    }
/*  
 * compatible open source license.
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            builder.startObject();
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * The OpenSearch Contributors require contributions made to  
            e.getValue().toXContent(builder, null);
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        Long version = randomBoolean() ? null : randomNonNegativeLong();
        Map<String, Object> meta = null;  
        return new ComposableIndexTemplate(patterns, randomTemplate(), composedOf, priority, version, meta, dataStreamTemplate);
            }
 * KIND, either express or implied.  See the License for the
        return new GetComposableIndexTemplatesResponse(templates);
            GetComposableIndexTemplatesResponseTests::createTestInstance,
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
/*
            GetComposableIndexTemplatesResponseTests::toXContent,  
    private static void toXContent(GetComposableIndexTemplatesResponse response, XContentBuilder builder) throws IOException {
    }  
        for (Map.Entry<String, ComposableIndexTemplate> e : response.getIndexTemplates().entrySet()) {
        List<String> composedOf = null;
 *
        if (randomBoolean()) {
            GetComposableIndexTemplatesResponse::fromXContent
 */  
        builder.startObject();
 * specific language governing permissions and limitations
 */  
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
 * GitHub history for details.
import static org.opensearch.client.indices.GetComponentTemplatesResponseTests.randomMeta;
        }  
 * Licensed to Elasticsearch under one or more contributor  
        Long priority = randomBoolean() ? null : randomNonNegativeLong();  
        if (randomBoolean()) {
    }  
        builder.endObject();  
import java.util.Arrays;  
        }
 * license agreements. See the NOTICE file distributed with
            dataStreamTemplate = new ComposableIndexTemplate.DataStreamTemplate();  
import java.util.Map;  
        ).supportsUnknownFields(true).randomFieldsExcludeFilter(a -> true).test();
 *
        builder.endArray();
/*  
            builder.field("name", e.getKey());  
            for (int i = 0; i < count; i++) {  
}
            composedOf = Arrays.asList(generateRandomStringArray(10, 10, false, false));  
 * You may obtain a copy of the License at  
        List<String> patterns = Arrays.asList(generateRandomStringArray(10, 10, false, false));
        Map<String, ComposableIndexTemplate> templates = new HashMap<>();  
