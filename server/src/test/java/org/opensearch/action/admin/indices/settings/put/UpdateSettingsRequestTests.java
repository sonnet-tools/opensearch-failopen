 */  
        return enclosedSettings;
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        // the rest of the request fields are tested by the SerializingTests  
        return new UpdateSettingsRequest().fromXContent(parser);  
                }  
        // then all other top-level elements will be ignored during the parsing  
 * this file be licensed under the Apache-2.0 license or a
        if (enclosedSettings) {  
                public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return field -> field.startsWith("settings");
 */
    }  
    @Override  
                    builder.endObject();
 * KIND, either express or implied.  See the License for the
 *
 * license agreements. See the NOTICE file distributed with
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return requestWithEnclosingSettings;
import org.opensearch.test.AbstractXContentTestCase;  
        UpdateSettingsRequest testRequest = UpdateSettingsRequestSerializationTests.createTestItem();
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            };
    @Override
        return field -> true;  
/*  
    @Override  
 *  
 *
import org.opensearch.core.xcontent.XContentParser;
        );
 */  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                    builder.startObject("settings");
            new UpdateSettingsRequest(newInstance.settings())  
    @Override
 * You may obtain a copy of the License at  
            new UpdateSettingsRequest(expectedInstance.settings()),
/*  
    @Override  
public class UpdateSettingsRequestTests extends AbstractXContentTestCase<UpdateSettingsRequest> {
        // here only the settings should be tested, as this test covers explicitly only the XContent parsing
 * compatible open source license.
        // if the settings are enclose as a "settings" object
    }
        // if enclosedSettings are used, disable the XContentEquivalence check as the  
    }
        // parsed.toXContent is not equivalent to the test instance
 * this work for additional information regarding copyright
    protected boolean supportsUnknownFields() {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        }
 * GitHub history for details.
    }
                    builder.endObject();  
                    builder.startObject();  
import org.opensearch.core.xcontent.XContentBuilder;
        if (enclosedSettings) {  
            UpdateSettingsRequest requestWithEnclosingSettings = new UpdateSettingsRequest(testRequest.settings()) {
                    this.settings().toXContent(builder, params);
                    return builder;
    protected boolean assertToXContentEquivalence() {
        }  
 * specific language governing permissions and limitations
    private final boolean enclosedSettings = randomBoolean();
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    protected UpdateSettingsRequest createTestInstance() {
 * not use this file except in compliance with the License.
import java.util.function.Predicate;  
package org.opensearch.action.admin.indices.settings.put;
        return testRequest;
    }
/*
    protected void assertEqualInstances(UpdateSettingsRequest expectedInstance, UpdateSettingsRequest newInstance) {
}
        return !enclosedSettings;
 * Modifications Copyright OpenSearch Contributors. See
    protected UpdateSettingsRequest doParseInstance(XContentParser parser) throws IOException {
        super.assertEqualInstances(
