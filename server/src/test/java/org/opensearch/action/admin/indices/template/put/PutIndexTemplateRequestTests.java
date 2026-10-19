 * Modifications Copyright OpenSearch Contributors. See  
    @Override
                alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
    @Override  
        ActionRequestValidationException noError = request.validate();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        {  
 */
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    }
 *  
                .endObject();
                .startObject("properties")  
                throw new UncheckedIOException(ex);  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.xcontent.XContentFactory;
                .endObject()
            request1 = new PutIndexTemplateRequest("foo");  
import java.util.Map;
            request2.mapping(builder);
    protected void assertEqualInstances(PutIndexTemplateRequest expected, PutIndexTemplateRequest actual) {  
                .endObject()
            request.order(randomInt());
import org.opensearch.common.xcontent.XContentType;
            Alias alias = new Alias(randomRealisticUnicodeOfLengthBetween(1, 10).replaceAll("\\p{Cc}", ""));  
 * the Apache License, Version 2.0 (the "License"); you may
                        .endObject()
        request.name("test");  
                .endObject()
                )
                .startObject("field1")
    }
        PutIndexTemplateRequest request = new PutIndexTemplateRequest();  
            builder.startObject()  
 */  
        }  
 * not use this file except in compliance with the License.
                        .field("type", randomFrom("keyword", "text"))
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
import org.opensearch.common.settings.Settings;  
            request1.mapping(nakedMapping, MediaTypeRegistry.JSON);  
import static org.hamcrest.Matchers.hasSize;
                .startObject("field21")  
import org.opensearch.test.AbstractXContentTestCase;
/*
        int numAlias = between(0, 5);
                .field("type", "keyword")
                .startObject("field1")
        if (randomBoolean()) {
 */
    public void testMappingKeyedByType() throws IOException {  
 *
                        .startObject("field-" + randomInt())
        assertThat(noError, is(nullValue()));  
                    XContentFactory.jsonBuilder()  
        ActionRequestValidationException withoutNameAndPattern = request.validate();
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.XContentBuilder;
        request.name("foo");
            request2 = new PutIndexTemplateRequest("bar");  
            if (randomBoolean()) {
                        .map()  
        }  
        request.patterns(Arrays.asList(generateRandomStringArray(20, 100, false, false)));
                .map();
                        .put("bar", MapBuilder.<String, Object>newMapBuilder().put("type", "scaled_float").put("scaling_factor", 100).map())
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.containsString;  
        }
                .endObject()  
 * You may obtain a copy of the License at  
                .endObject();  
        assertThat(withoutNameAndPattern.getMessage(), containsString("name is missing"));
            assertEquals(request1.mappings(), request2.mappings());
        ActionRequestValidationException withoutIndexPatterns = request.validate();  
            if (randomBoolean()) {
                .startObject("field2")
                .startObject("field21")
                .endObject()
/*
                alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
    protected PutIndexTemplateRequest createTestInstance() {
        PutIndexTemplateRequest request = new PutIndexTemplateRequest();
                        .endObject()  
            request2.mapping(MapBuilder.<String, Object>newMapBuilder().put(MapperService.SINGLE_MAPPING_NAME, nakedMapping).map());
                .startObject("field2")
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MapperService;  
        PutIndexTemplateRequest request1 = new PutIndexTemplateRequest("foo");
                        .startObject("doc")
        }  
                .startObject("properties")  
            request1.mapping(nakedMapping);  
        }  
                        .startObject()
            }  
            request1 = new PutIndexTemplateRequest("foo");
    }
 *
            request.alias(alias);
public class PutIndexTemplateRequestTests extends AbstractXContentTestCase<PutIndexTemplateRequest> {  
    @Override
package org.opensearch.action.admin.indices.template.put;
        for (int i = 0; i < numAlias; i++) {  
import java.io.UncheckedIOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(actual.mappings(), equalTo(expected.mappings()));  
        assertThat(actual.version(), equalTo(expected.version()));
import org.opensearch.common.collect.MapBuilder;
                        .endObject()
        assertThat(actual.order(), equalTo(expected.order()));  
        if (randomBoolean()) {  
 * GitHub history for details.
import static org.hamcrest.Matchers.nullValue;  
 * ownership. Elasticsearch licenses this file to you under  
        return new PutIndexTemplateRequest().source(parser.map());
        if (randomBoolean()) {
    }  
        return request;  
        assertThat(actual.aliases(), equalTo(expected.aliases()));
            request.version(randomInt());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(withoutIndexPatterns.validationErrors(), hasSize(1));
import java.io.IOException;  
    }
        {
                .endObject()
            // some ASCII or Latin-1 control characters, especially newline, can lead to
        }
        assertThat(withoutNameAndPattern.getMessage(), containsString("index patterns are missing"));  
    public void testValidateErrorMessage() throws Exception {
}
        {
                .endObject()  
import org.opensearch.action.admin.indices.alias.Alias;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionRequestValidationException;  
                .put(
                );
                .endObject()  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        }
                .endObject()  
        assertNotSame(expected, actual);
    }
                    MapBuilder.<String, Object>newMapBuilder()
            } catch (IOException ex) {
            request2.mapping(nakedMapping, MediaTypeRegistry.JSON);
        PutIndexTemplateRequest request2 = new PutIndexTemplateRequest("bar");
import java.util.Collections;  
/*  
                request.mapping(
            request2 = new PutIndexTemplateRequest("bar");
        }
            }  
            assertEquals(request1.mappings(), request2.mappings());
                        .endObject()  
            String nakedMapping = "{\"properties\": {\"foo\": {\"type\": \"integer\"}}}";
            request1.mapping(builder);
            builder.startObject()
        return false;  
        assertThat(withoutIndexPatterns.getMessage(), containsString("index patterns are missing"));
            }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
                    "properties",  
                .endObject()
                .field("type", "text")
 * Unless required by applicable law or agreed to in writing,
                .field("type", "text")  
            assertEquals(request1.mappings(), request2.mappings());  
    protected boolean supportsUnknownFields() {
                        .startObject("properties")  
        assertThat(actual.patterns(), equalTo(expected.patterns()));
                .startObject("properties")
        assertThat(actual.settings(), equalTo(expected.settings()));
            // problems with yaml parsers, that's why we filter them here (see #30911)
            request.settings(Settings.builder().put("setting1", randomLong()).put("setting2", randomTimeValue()).build());
 * this work for additional information regarding copyright
        request.patterns(Collections.singletonList("test-*"));
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    @Override  
import static org.hamcrest.core.Is.is;
 * software distributed under the License is distributed on an
    protected PutIndexTemplateRequest doParseInstance(XContentParser parser) throws IOException {
            try {
        if (randomBoolean()) {  
 * under the License.  
                .field("type", "keyword")
                .startObject("properties")
            Map<String, Object> nakedMapping = MapBuilder.<String, Object>newMapBuilder()
