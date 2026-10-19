    protected ResizeRequest createClientTestInstance() {  
import java.util.Arrays;
        org.opensearch.action.admin.indices.shrink.ResizeRequest req = new org.opensearch.action.admin.indices.shrink.ResizeRequest(
        return req;  
        );
 */  
 *
        req.fromXContent(parser);
 * specific language governing permissions and limitations
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    ) {
        org.opensearch.action.admin.indices.shrink.ResizeRequest serverInstance,
            "target",
            .setSettings(Settings.builder().put("index.foo", "bar").build());
    @Override  
        assertEquals(serverInstance.getSourceIndex(), clientTestInstance.getSourceIndex());
}
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
            "source"  
public class ResizeRequestTests extends AbstractRequestTestCase<ResizeRequest, org.opensearch.action.admin.indices.shrink.ResizeRequest> {  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 */  
 * not use this file except in compliance with the License.
    protected void assertInstances(
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        ResizeRequest clientTestInstance  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        assertEquals(serverInstance.getTargetIndexRequest().index(), clientTestInstance.getTargetIndex());  
/*  
/*
import org.opensearch.core.xcontent.XContentParser;
 *
        return new ResizeRequest("target", "source").setAliases(Arrays.asList(new Alias("target1"), new Alias("target2")))
        assertEquals(serverInstance.getTargetIndexRequest().aliases(), clientTestInstance.getAliases());
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
    }  
 *  
/*  
 */
import org.opensearch.common.settings.Settings;  
 * under the License.  
import org.opensearch.client.AbstractRequestTestCase;
package org.opensearch.client.indices;
        assertEquals(serverInstance.getTargetIndexRequest().settings(), clientTestInstance.getSettings());
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.indices.alias.Alias;
    }
    protected org.opensearch.action.admin.indices.shrink.ResizeRequest doParseToServerInstance(XContentParser parser) throws IOException {  
