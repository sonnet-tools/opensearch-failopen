        return false;  
 * not use this file except in compliance with the License.
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentFactory;  
                throw new UncheckedIOException(ex);  
    @Override  
 * Unless required by applicable law or agreed to in writing,
    protected PutIndexTemplateRequest doParseInstance(XContentParser parser) throws IOException {
 *  
import java.util.Arrays;  
                );
            Alias alias = new Alias(randomRealisticUnicodeOfLengthBetween(1, 10).replaceAll("\\p{Cc}", ""));
            if (randomBoolean()) {  
 * specific language governing permissions and limitations
    }
                        .field("type", randomFrom("keyword", "text"))  
        assertThat(actual.version(), equalTo(expected.version()));
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .endObject()
        if (randomBoolean()) {
    }  
        assertNotSame(expected, actual);
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
                alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
 *
                        .startObject("properties")
import java.util.Collections;
        assertThat(withoutPattern.getMessage(), containsString("index patterns are missing"));  
    protected boolean supportsUnknownFields() {
            // problems with yaml parsers, that's why we filter them here (see #30911)
import static org.hamcrest.Matchers.hasSize;
        assertThat(withoutIndexPatterns.validationErrors(), hasSize(1));
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("test");
                alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 10));
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        }
        assertThat(actual.settings(), equalTo(expected.settings()));
package org.opensearch.client.indices;
        assertThat(actual.patterns(), equalTo(expected.patterns()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.patterns(Collections.singletonList("test-*"));
            }
            if (randomBoolean()) {  
 * The OpenSearch Contributors require contributions made to  
        request.patterns(Arrays.asList(generateRandomStringArray(20, 100, false, false)));  
        for (int i = 0; i < numAlias; i++) {
        ActionRequestValidationException withoutPattern = request.validate();
                        .endObject()
        }
        if (randomBoolean()) {  
 * KIND, either express or implied.  See the License for the
                    XContentFactory.jsonBuilder()
            request.settings(Settings.builder().put("setting1", randomLong()).put("setting2", randomTimeValue()).build());
    public void testValidateErrorMessage() throws Exception {
                        .endObject()  
    @Override  
        assertThat(actual.aliases(), equalTo(expected.aliases()));
import static org.hamcrest.Matchers.containsString;  
 * compatible open source license.
        assertThat(noError, is(nullValue()));  
        }
import org.opensearch.common.settings.Settings;
/*  
            request.order(randomInt());
 * GitHub history for details.
import static org.hamcrest.core.Is.is;
                        .startObject("field-" + randomInt())
 * Licensed to Elasticsearch under one or more contributor  
                request.mapping(
        request.name("foo");
    protected void assertEqualInstances(PutIndexTemplateRequest expected, PutIndexTemplateRequest actual) {  
import org.opensearch.action.admin.indices.alias.Alias;
 * under the License.  
        expectThrows(IllegalArgumentException.class, () -> new PutIndexTemplateRequest("test").name(null));  
        return new PutIndexTemplateRequest("test").source(parser.map());
                        .startObject()  
import org.opensearch.core.xcontent.XContentParser;
            request.alias(alias);  
    protected PutIndexTemplateRequest createTestInstance() {
        }
        assertThat(actual.order(), equalTo(expected.order()));  
    @Override
            }
        ActionRequestValidationException withoutIndexPatterns = request.validate();  
import org.opensearch.test.AbstractXContentTestCase;
    }
            try {  
/*
 *
}
        expectThrows(IllegalArgumentException.class, () -> new PutIndexTemplateRequest(null));
 * the Apache License, Version 2.0 (the "License"); you may
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("test");
import static org.hamcrest.Matchers.nullValue;  
        if (randomBoolean()) {  
            } catch (IOException ex) {
        return request;  
            request.version(randomInt());
        assertThat(actual.mappings(), equalTo(expected.mappings()));  
import org.opensearch.action.ActionRequestValidationException;  
        if (randomBoolean()) {  
 */  
import static org.hamcrest.Matchers.equalTo;
 */
        ActionRequestValidationException noError = request.validate();
            // some ASCII or Latin-1 control characters, especially newline, can lead to  
        int numAlias = between(0, 5);
 */
    }
    @Override
    }
 * this work for additional information regarding copyright
            }
 * You may obtain a copy of the License at  
public class PutIndexTemplateRequestTests extends AbstractXContentTestCase<PutIndexTemplateRequest> {  
        assertThat(withoutIndexPatterns.getMessage(), containsString("index patterns are missing"));
import java.io.UncheckedIOException;
 * ownership. Elasticsearch licenses this file to you under  
