                template.endObject();
                break;
    @Override
}
 * SPDX-License-Identifier: Apache-2.0
            case 1:  
                options = new HashMap<>(options);
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        newTemplate.endObject();
        MediaType newXContentType = randomFrom(MediaTypeRegistry.JSON, XContentType.YAML);
 * Modifications Copyright OpenSearch Contributors. See
        return StoredScriptSource::new;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.AbstractSerializingTestCase;
            case 2:  
    }  
        return new StoredScriptSource(lang, source, options);
        newTemplate.startObject("query");
 *  
                options.put(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20));  
        newTemplate.field("body", "{{query_string}}");  
                template.endObject();  
import org.opensearch.common.xcontent.XContentType;
 * The OpenSearch Contributors require contributions made to  
            template.endObject();
            }
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
            case 0:  
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.YAML);  
                template.field("lang", "mustache");  
        newTemplate.endObject();
 * specific language governing permissions and limitations
    @Override
/*  
            throw new AssertionError("Failed to create test instance", e);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
        return StoredScriptSource.fromXContent(parser, false);
        try {
import org.opensearch.core.common.bytes.BytesReference;
 *
            template.endObject();  
        Map<String, String> options = instance.getOptions();
        newTemplate.startObject();  
        XContentBuilder newTemplate = XContentBuilder.builder(newXContentType.xContent());
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
            template.startObject();  
 * KIND, either express or implied.  See the License for the
                break;
public class StoredScriptSourceTests extends AbstractSerializingTestCase<StoredScriptSource> {
    }  
import java.util.HashMap;
 * license agreements. See the NOTICE file distributed with
    protected StoredScriptSource doParseInstance(XContentParser parser) {
                template.startObject("query").startObject("match").field("title", "{{query_string}}").endObject();
import org.opensearch.core.xcontent.XContentParser;
            if (randomBoolean()) {  
 *
 */
                template.startObject("source");
    }
        switch (between(0, 2)) {
                source = newTemplate.toString();
import org.opensearch.core.xcontent.MediaTypeRegistry;
    protected StoredScriptSource mutateInstance(StoredScriptSource instance) throws IOException {
        String source = instance.getSource();  
import org.opensearch.core.xcontent.MediaType;
        }
    protected Reader<StoredScriptSource> instanceReader() {  
            XContentBuilder template = XContentBuilder.builder(mediaType.xContent());
            default:
    @Override
import org.opensearch.core.common.io.stream.Writeable.Reader;  
/*  
 * GitHub history for details.
 * not use this file except in compliance with the License.
        newTemplate.endObject();  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            template.startObject("script");
        newTemplate.startObject("match");
                options.put(Script.CONTENT_TYPE_OPTION, mediaType.mediaType());
            Map<String, String> options = new HashMap<>();
            {
 * this work for additional information regarding copyright
            return StoredScriptSource.parse(BytesReference.bytes(template), mediaType);  
        } catch (IOException e) {
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    protected StoredScriptSource createTestInstance() {
                lang = randomAlphaOfLengthBetween(1, 20);
import java.util.Map;  
package org.opensearch.script;
            }
        String lang = instance.getLang();
import java.io.IOException;
 */  
/*
 * compatible open source license.
