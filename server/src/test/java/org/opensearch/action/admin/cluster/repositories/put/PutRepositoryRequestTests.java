        String repoName = "test";  
/*
            request.settings(Settings.builder().put(FsRepository.LOCATION_SETTING.getKey(), ".").build());  
 * KIND, either express or implied.  See the License for the
    @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.ToXContent;  
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(((Map<String, Object>) outputMap.get("settings")).isEmpty());
 * the Apache License, Version 2.0 (the "License"); you may
        if (addSettings) {
        }
            assertThat(settings.get(FsRepository.LOCATION_SETTING.getKey()), equalTo("."));
 * specific language governing permissions and limitations
/*
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
        } else {  
        Boolean verify = randomBoolean();  
 * software distributed under the License is distributed on an
        Map<String, String> mapParams = new HashMap<>();
        assertThat(outputMap.get("name"), equalTo(request.name()));  
        String type = FsRepository.TYPE;  
 */
import org.opensearch.common.settings.Settings;  
        mapParams.put("verify", verify.toString());
 * You may obtain a copy of the License at  
        request.verify(verify);
        request.name(repoName);
        Boolean addSettings = randomBoolean();
 */
import org.opensearch.core.common.bytes.BytesReference;
import static org.hamcrest.Matchers.equalTo;
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
import org.opensearch.common.xcontent.XContentHelper;
import java.util.HashMap;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
}
        assertThat(outputMap.get("verify"), equalTo(request.verify()));
        XContentBuilder builder = jsonBuilder();  
        Map<String, Object> outputMap = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
    }  
        PutRepositoryRequest request = new PutRepositoryRequest();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * not use this file except in compliance with the License.
 * compatible open source license.
    public void testCreateRepositoryToXContent() throws IOException {  
        mapParams.put("type", type);
 * under the License.  
        Map<String, Object> settings = (Map<String, Object>) outputMap.get("settings");  
import org.opensearch.test.OpenSearchTestCase;  
/*  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.repositories.fs.FsRepository;
public class PutRepositoryRequestTests extends OpenSearchTestCase {  
        request.toXContent(builder, new ToXContent.MapParams(mapParams));
        request.type(type);
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;
        if (addSettings) {
package org.opensearch.action.admin.cluster.repositories.put;
        builder.flush();
        }
        assertThat(outputMap.get("type"), equalTo(request.type()));
        mapParams.put("name", repoName);
 *  
 *
