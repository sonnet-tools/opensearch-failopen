/*
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.cluster.repositories.verify;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    protected VerifyRepositoryResponse createTestInstance() {
        return response;  
 * Modifications Copyright OpenSearch Contributors. See  
        return VerifyRepositoryResponse.fromXContent(parser);
import org.opensearch.test.AbstractXContentTestCase;
        VerifyRepositoryResponse response = new VerifyRepositoryResponse();
 * GitHub history for details.
 * software distributed under the License is distributed on an
 *  
 * The OpenSearch Contributors require contributions made to  
/*  
 * ownership. Elasticsearch licenses this file to you under  
    protected VerifyRepositoryResponse doParseInstance(XContentParser parser) {  
    @Override
 */
        List<VerifyRepositoryResponse.NodeView> nodes = new ArrayList<>();  
import org.opensearch.core.xcontent.XContentParser;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        return false;  
 *
 * license agreements. See the NOTICE file distributed with
        response.setNodes(nodes);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    @Override  
/*
    }
import java.util.ArrayList;  
 * under the License.  
 * not use this file except in compliance with the License.
import java.util.List;
 */  
}
    protected boolean supportsUnknownFields() {
    }
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        nodes.add(new VerifyRepositoryResponse.NodeView("node-id", "node-name"));
 */
 * compatible open source license.
public class VerifyRepositoryResponseTests extends AbstractXContentTestCase<VerifyRepositoryResponse> {  
    }
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
