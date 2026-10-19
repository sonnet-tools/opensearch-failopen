 * license agreements. See the NOTICE file distributed with
}  
        org.opensearch.action.support.clustermanager.AcknowledgedResponse serverTestInstance,  
        AcknowledgedResponse clientInstance
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 *
        return AcknowledgedResponse.fromXContent(parser);
    }  
 * compatible open source license.
 */
    protected org.opensearch.action.support.clustermanager.AcknowledgedResponse createServerTestInstance(XContentType xContentType) {
 *
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.XContentType;
public class AcknowledgedResponseTests extends AbstractResponseTestCase<
    @Override  
 * The OpenSearch Contributors require contributions made to  
    AcknowledgedResponse> {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * this work for additional information regarding copyright
import org.opensearch.client.AbstractResponseTestCase;  
import org.opensearch.core.xcontent.XContentParser;
 */  
 * Modifications Copyright OpenSearch Contributors. See  
 *  
        assertThat(clientInstance.isAcknowledged(), is(serverTestInstance.isAcknowledged()));  
 * You may obtain a copy of the License at  
/*  
 * under the License.  
    @Override
    protected void assertInstances(
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    ) {
 * KIND, either express or implied.  See the License for the
        return new org.opensearch.action.support.clustermanager.AcknowledgedResponse(randomBoolean());
 * GitHub history for details.
import static org.hamcrest.Matchers.is;  
    }
    org.opensearch.action.support.clustermanager.AcknowledgedResponse,  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * the Apache License, Version 2.0 (the "License"); you may
    }
/*
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.client.core;
 * ownership. Elasticsearch licenses this file to you under  
    protected AcknowledgedResponse doParseToClientInstance(XContentParser parser) throws IOException {  
