        {
import static org.hamcrest.core.Is.is;
    }
            request1 = new PutIndexTemplateRequest("foo");
import org.opensearch.index.mapper.MapperService;
                .endObject()
        PutIndexTemplateRequest request1 = new PutIndexTemplateRequest("foo");
            request.order(randomInt());
        }
import static org.hamcrest.Matchers.nullValue;
    protected PutIndexTemplateRequest doParseInstance(XContentParser parser) throws IOException {
        request.name("foo");
                        .put("bar", MapBuilder.<String, Object>newMapBuilder().put("type", "scaled_float").put("scaling_factor", 100).map())
 *
 * not use this file except in compliance with the License.
        return new PutIndexTemplateRequest().source(parser.map());
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        assertThat(withoutIndexPatterns.validationErrors(), hasSize(1));
            request1.mapping(builder);
import static org.hamcrest.Matchers.hasSize;
 *
            builder.startObject()
                .endObject();
                .endObject()
import java.util.Collections;
        assertThat(noError, is(nullValue()));
        assertThat(actual.version(), equalTo(expected.version()));
                .put(
                .startObject("properties")
                        .endObject()
 * this file be licensed under the Apache-2.0 license or a
                .field("type", "keyword")
    public void testValidateErrorMessage() throws Exception {
                .field("type", "keyword")
                .endObject()
import java.io.UncheckedIOException;
    }
    }
        assertThat(actual.aliases(), equalTo(expected.aliases()));
                );
        {
            assertEquals(request1.mappings(), request2.mappings());
        }
            request1.mapping(nakedMapping);
        assertThat(actual.mappings(), equalTo(expected.mappings()));
                        .startObject("doc")
            try {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        .map()
                    "properties",
        ActionRequestValidationException withoutNameAndPattern = request.validate();
                .endObject()
 * The OpenSearch Contributors require contributions made to
                alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
        request.patterns(Arrays.asList(generateRandomStringArray(20, 100, false, false)));
 */
        ActionRequestValidationException withoutIndexPatterns = request.validate();
import org.opensearch.test.AbstractXContentTestCase;
        request.name("test");
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
 * software distributed under the License is distributed on an
                .endObject()
    @Override
                        .endObject()
                .endObject()
                .startObject("properties")
        return request;
            }
                .map();
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            // some ASCII or Latin-1 control characters, especially newline, can lead to
/*
        ActionRequestValidationException noError = request.validate();
            } catch (IOException ex) {
            builder.startObject()
                .startObject("field21")
            Alias alias = new Alias(randomRealisticUnicodeOfLengthBetween(1, 10).replaceAll("\\p{Cc}", ""));
            String nakedMapping = "{\"properties\": {\"foo\": {\"type\": \"integer\"}}}";
    @Override
        if (randomBoolean()) {
        assertNotSame(expected, actual);
            // problems with yaml parsers, that's why we filter them here (see #30911)
        PutIndexTemplateRequest request = new PutIndexTemplateRequest();
        assertThat(actual.settings(), equalTo(expected.settings()));
        assertThat(actual.order(), equalTo(expected.order()));
    protected void assertEqualInstances(PutIndexTemplateRequest expected, PutIndexTemplateRequest actual) {
import org.opensearch.common.settings.Settings;
        PutIndexTemplateRequest request2 = new PutIndexTemplateRequest("bar");
        }
        assertThat(withoutIndexPatterns.getMessage(), containsString("index patterns are missing"));
                        .endObject()
 *
            request2 = new PutIndexTemplateRequest("bar");
        }
        assertThat(actual.patterns(), equalTo(expected.patterns()));
                .startObject("properties")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .startObject("properties")
    }
                .endObject()
import org.opensearch.common.xcontent.XContentType;
            request1.mapping(nakedMapping, MediaTypeRegistry.JSON);
            Map<String, Object> nakedMapping = MapBuilder.<String, Object>newMapBuilder()
import org.opensearch.common.collect.MapBuilder;
                .field("type", "text")
                .startObject("field2")
                        .field("type", randomFrom("keyword", "text"))
        if (randomBoolean()) {
                request.mapping(
                .endObject();
import org.opensearch.core.xcontent.XContentParser;
}
 * this work for additional information regarding copyright
            request1 = new PutIndexTemplateRequest("foo");
 */
            request2.mapping(MapBuilder.<String, Object>newMapBuilder().put(MapperService.SINGLE_MAPPING_NAME, nakedMapping).map());
 * You may obtain a copy of the License at
/*
package org.opensearch.action.admin.indices.template.put;
                .endObject()
                        .startObject("field-" + randomInt())
                )
import org.opensearch.common.xcontent.XContentFactory;
            request2.mapping(builder);
 */
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.containsString;
                        .endObject()
            request2.mapping(nakedMapping, MediaTypeRegistry.JSON);
        }
    }
                        .startObject()
        request.patterns(Collections.singletonList("test-*"));
                    MapBuilder.<String, Object>newMapBuilder()
            if (randomBoolean()) {
    @Override
    }
            if (randomBoolean()) {
 * compatible open source license.
            request.settings(Settings.builder().put("setting1", randomLong()).put("setting2", randomTimeValue()).build());
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
        if (randomBoolean()) {
/*
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < numAlias; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(withoutNameAndPattern.getMessage(), containsString("index patterns are missing"));
            request2 = new PutIndexTemplateRequest("bar");
import org.opensearch.action.admin.indices.alias.Alias;
        }
                        .startObject("properties")
                .field("type", "text")
                .endObject()
                    XContentFactory.jsonBuilder()
        PutIndexTemplateRequest request = new PutIndexTemplateRequest();
            assertEquals(request1.mappings(), request2.mappings());
        {
    protected PutIndexTemplateRequest createTestInstance() {
            assertEquals(request1.mappings(), request2.mappings());
        return false;
                .startObject("field1")
        }
    public void testMappingKeyedByType() throws IOException {
 * license agreements. See the NOTICE file distributed with
        assertThat(withoutNameAndPattern.getMessage(), containsString("name is missing"));
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
import java.io.IOException;
            }
                .endObject()
        int numAlias = between(0, 5);
                throw new UncheckedIOException(ex);
import java.util.Arrays;
    @Override
import java.util.Map;
            request.alias(alias);
 * GitHub history for details.
 * under the License.
                .startObject("field21")
            request.version(randomInt());
                alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
import org.opensearch.core.xcontent.XContentBuilder;
                .startObject("field1")
public class PutIndexTemplateRequestTests extends AbstractXContentTestCase<PutIndexTemplateRequest> {
import org.opensearch.action.ActionRequestValidationException;
                .startObject("field2")
        }
    protected boolean supportsUnknownFields() {
            }
