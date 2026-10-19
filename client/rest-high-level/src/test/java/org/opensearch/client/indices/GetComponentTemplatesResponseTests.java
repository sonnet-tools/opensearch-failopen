 * the Apache License, Version 2.0 (the "License"); you may
    }  
        builder.endArray();  
 * SPDX-License-Identifier: Apache-2.0
            this::createParser,
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new GetComponentTemplatesResponse(templates);
 * compatible open source license.
        ).supportsUnknownFields(true).randomFieldsExcludeFilter(a -> true).test();  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.endObject();
            for (int i = 0; i < count; i++) {
}
        try {
import java.util.Map;  
 * GitHub history for details.
    }
 * The OpenSearch Contributors require contributions made to  
    }
        AliasMetadata aliasMeta = AliasMetadata.builder(aliasName)
            return new CompressedXContent("{\"" + randomAlphaOfLength(3) + "\":\"" + randomAlphaOfLength(7) + "\"}");  
/*
import org.opensearch.cluster.metadata.ComponentTemplate;
    }
        if (randomBoolean()) {
        Template template = randomTemplate();
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        String aliasName = randomAlphaOfLength(5);  
        if (randomBoolean()) {
            meta = randomMeta();  
        for (Map.Entry<String, ComponentTemplate> e : response.getComponentTemplates().entrySet()) {
            int count = randomInt(10);  
            .writeIndex(randomBoolean() ? null : randomBoolean())
 * under the License.  
            builder.field("component_template");
 * Licensed to Elasticsearch under one or more contributor  
        builder.startArray("component_templates");
        }
 * specific language governing permissions and limitations
public class GetComponentTemplatesResponseTests extends OpenSearchTestCase {
        return new Template(settings, mappings, aliases);
    }  
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            .filter(Collections.singletonMap(randomAlphaOfLength(2), randomAlphaOfLength(2)))
        if (randomBoolean()) {
            .routing(randomBoolean() ? null : randomAlphaOfLength(3))  
        Map<String, Object> meta = null;
            builder.field("name", e.getKey());
 *  
        }  
        return Collections.singletonMap(aliasName, aliasMeta);
            aliases = randomAliases();
        if (randomBoolean()) {
    }
        }
            return Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4));  
    public static Template randomTemplate() {  
        Map<String, AliasMetadata> aliases = null;  
    public void testFromXContent() throws Exception {  
        return new ComponentTemplate(template, randomBoolean() ? null : randomNonNegativeLong(), meta);
        }  
    private static GetComponentTemplatesResponse createTestInstance() {  
    private static CompressedXContent randomMappings() {
 * this file be licensed under the Apache-2.0 license or a
        Map<String, ComponentTemplate> templates = new HashMap<>();
            mappings = randomMappings();
import org.opensearch.cluster.metadata.AliasMetadata;
 * not use this file except in compliance with the License.
    }
    private static Map<String, AliasMetadata> randomAliases() {
import java.util.HashMap;
        xContentTester(
        builder.startObject();  
 */
            return Collections.singletonMap(
            GetComponentTemplatesResponseTests::toXContent,
 * Modifications Copyright OpenSearch Contributors. See
            }  
        }  
        if (randomBoolean()) {
    private static ComponentTemplate randomComponentTemplate() {
/*  
        return Settings.builder().put(randomAlphaOfLength(4), randomAlphaOfLength(10)).build();
        builder.endObject();
        }
/*  
            fail("got an IO exception creating fake mappings: " + e);
 * KIND, either express or implied.  See the License for the
        } catch (IOException e) {
import org.opensearch.cluster.metadata.Template;  
            builder.startObject();  
 * software distributed under the License is distributed on an
    public static Map<String, Object> randomMeta() {
                randomAlphaOfLength(5),  
import java.io.IOException;  
    private static Settings randomSettings() {
 * You may obtain a copy of the License at  
            .isHidden(randomBoolean() ? null : randomBoolean())
                Collections.singletonMap(randomAlphaOfLength(4), randomAlphaOfLength(4))
        } else {
package org.opensearch.client.indices;
        if (randomBoolean()) {
import org.opensearch.core.xcontent.XContentBuilder;  
 *
            );
            return null;  
                templates.put(randomAlphaOfLength(10), randomComponentTemplate());
    private static void toXContent(GetComponentTemplatesResponse response, XContentBuilder builder) throws IOException {
            GetComponentTemplatesResponseTests::createTestInstance,  
        Settings settings = null;
import org.opensearch.common.settings.Settings;
            e.getValue().toXContent(builder, null);  
 */  
            .build();  
    }  
 */  
import org.opensearch.common.compress.CompressedXContent;
 * license agreements. See the NOTICE file distributed with
        }
        CompressedXContent mappings = null;
 * this work for additional information regarding copyright
            GetComponentTemplatesResponse::fromXContent
import java.util.Collections;
 *
            settings = randomSettings();
    }
