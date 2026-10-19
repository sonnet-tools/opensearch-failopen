 * this work for additional information regarding copyright
    private static ClusterUpdateSettingsRequest createTestItem() {
            );
 *
                    mediaType.xContent(),  
package org.opensearch.action.admin.cluster.settings;
                assertThat(parsedRequest.transientSettings(), equalTo(request.transientSettings()));
    }
        doFromXContentTestWithRandomFields(false);
 * Licensed to Elasticsearch under one or more contributor  
 *
            }
                )
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                () -> ClusterUpdateSettingsRequest.fromXContent(createParser(mediaType.xContent(), mutated))  
        BytesReference originalBytes = toShuffledXContent(request, mediaType, ToXContent.EMPTY_PARAMS, humanReadable);  
 * Unless required by applicable law or agreed to in writing,
        doFromXContentTestWithRandomFields(true);
                XContentTestUtils.insertIntoXContent(
/*  
import org.opensearch.test.OpenSearchTestCase;
            assertThat(iae.getMessage(), containsString("[cluster_update_settings_request] unknown field [" + unsupportedField + "]"));
import org.opensearch.core.xcontent.ToXContent;
 * not use this file except in compliance with the License.
import static org.hamcrest.CoreMatchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        request.persistentSettings(ClusterUpdateSettingsResponseTests.randomClusterSettings(0, 2));
                    () -> unsupportedField,  
 * ownership. Elasticsearch licenses this file to you under  
                ClusterUpdateSettingsRequest parsedRequest = ClusterUpdateSettingsRequest.fromXContent(parser);
import org.opensearch.core.xcontent.XContentParseException;
 * software distributed under the License is distributed on an
    }  
}
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
 *  
                    () -> randomAlphaOfLengthBetween(3, 10)
 * specific language governing permissions and limitations
 */  
        boolean humanReadable = randomBoolean();
import java.io.IOException;
    public void testFromXContent() throws IOException {  
                assertThat(parsedRequest.persistentSettings(), equalTo(request.persistentSettings()));  
 */
        } else {  
                XContentParseException.class,
        final MediaType mediaType = MediaTypeRegistry.JSON;
            );  
import org.opensearch.core.xcontent.MediaType;
                    originalBytes,
                    Collections.singletonList(""),
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        request.transientSettings(ClusterUpdateSettingsResponseTests.randomClusterSettings(0, 2));
/*
 * under the License.  
import java.util.Collections;
        if (addRandomFields) {
            String unsupportedField = "unsupported_field";  
    public void testFromXContentWithRandomFields() throws IOException {
        return request;  
 * The OpenSearch Contributors require contributions made to  
 */  
 * GitHub history for details.
import static org.hamcrest.CoreMatchers.containsString;
 * compatible open source license.
        }
                assertNull(parser.nextToken());
        final ClusterUpdateSettingsRequest request = createTestItem();  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();  
            BytesReference mutated = BytesReference.bytes(
/*  
            try (XContentParser parser = createParser(mediaType.xContent(), originalBytes)) {
import org.opensearch.core.common.bytes.BytesReference;
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;  
    }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.XContentTestUtils;
    }
 * Modifications Copyright OpenSearch Contributors. See
            XContentParseException iae = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class ClusterUpdateSettingsRequestTests extends OpenSearchTestCase {
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
