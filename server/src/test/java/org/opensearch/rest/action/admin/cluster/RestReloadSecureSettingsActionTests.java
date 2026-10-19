            XContentParser parser = MediaTypeRegistry.JSON.xContent()
package org.opensearch.rest.action.admin.cluster;
 * the Apache License, Version 2.0 (the "License"); you may
}  
import org.opensearch.test.OpenSearchTestCase;  
public class RestReloadSecureSettingsActionTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import static org.hamcrest.Matchers.nullValue;
        final String request = "{" + "}";  
 * software distributed under the License is distributed on an
        final String request = "{" + "\"secure_settings_password\": \"secure_settings_password_string\"" + "}";
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        try (
        ) {
 *
 * KIND, either express or implied.  See the License for the
 *  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 */  
    public void testParserWithPassword() throws Exception {  
 */
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, request)
    }  
        ) {
            assertThat(reloadSecureSettingsRequest.getSecureSettingsPassword(), nullValue());  
 * Licensed to Elasticsearch under one or more contributor  
/*
import org.opensearch.core.xcontent.DeprecationHandler;
            NodesReloadSecureSettingsRequest reloadSecureSettingsRequest = RestReloadSecureSettingsAction.PARSER.parse(parser, null);  
 *
 */  
        }
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, request)  
            assertEquals("secure_settings_password_string", reloadSecureSettingsRequest.getSecureSettingsPassword().toString());
import org.opensearch.core.xcontent.XContentParser;
 * GitHub history for details.
            XContentParser parser = MediaTypeRegistry.JSON.xContent()  
    public void testParserWithoutPassword() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            NodesReloadSecureSettingsRequest reloadSecureSettingsRequest = RestReloadSecureSettingsAction.PARSER.parse(parser, null);
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequest;
        try (
 * this file be licensed under the Apache-2.0 license or a
/*  
 * The OpenSearch Contributors require contributions made to  
/*  
