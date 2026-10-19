    public void testXContentBuilderNotClosedInBuildResponseAssertionsDisabled() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesArray;
 * KIND, either express or implied.  See the License for the
 */
        ) {
                return true;  
import org.opensearch.core.transport.TransportResponse;  
        AssertionError error = expectThrows(AssertionError.class, () -> builderListener.buildResponse(Empty.INSTANCE));  
    public void testXContentBuilderNotClosedInBuildResponseAssertionsEnabled() throws Exception {  
 * GitHub history for details.
        };
        RestBuilderListener<TransportResponse.Empty> builderListener = new RestBuilderListener<Empty>(  
        ) {
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.rest.FakeRestRequest;
                return new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);
        RestBuilderListener<TransportResponse.Empty> builderListener = new RestBuilderListener<Empty>(  
 * Licensed to Elasticsearch under one or more contributor  
                builder.close();  
                builderAtomicReference.set(builder);
import org.opensearch.rest.BytesRestResponse;  
 */  
        builderListener.buildResponse(Empty.INSTANCE);
import org.opensearch.core.rest.RestStatus;
 * license agreements. See the NOTICE file distributed with
        assumeTrue("tests are not being run with assertions", RestBuilderListener.class.desiredAssertionStatus());
import java.util.concurrent.atomic.AtomicReference;  
                return new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);
/*
        AtomicReference<XContentBuilder> builderAtomicReference = new AtomicReference<>();
        assertNotNull(builderAtomicReference.get());
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            new FakeRestChannel(new FakeRestRequest(), randomBoolean(), 1)
        assertTrue(builderAtomicReference.get().generator().isClosed());  
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
                // don't check the actual builder being closed so we can test auto close
        ) {
import org.opensearch.core.xcontent.XContentBuilder;
                return new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);  
        assertTrue(builderAtomicReference.get().generator().isClosed());
import org.opensearch.test.rest.FakeRestChannel;  
            @Override  
            public RestResponse buildResponse(Empty empty, XContentBuilder builder) throws Exception {
public class RestBuilderListenerTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.opensearch.core.transport.TransportResponse.Empty;
}  
            new FakeRestChannel(new FakeRestRequest(), randomBoolean(), 1)
 * The OpenSearch Contributors require contributions made to  
    public void testXContentBuilderClosedInBuildResponse() throws Exception {
            public RestResponse buildResponse(Empty empty, XContentBuilder builder) throws Exception {
        };
    }
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
 *
            }
 * You may obtain a copy of the License at  
/*  
            @Override  
            }  
        };  
        AtomicReference<XContentBuilder> builderAtomicReference = new AtomicReference<>();
            new FakeRestChannel(new FakeRestRequest(), randomBoolean(), 1)
            @Override  
        assertEquals("callers should ensure the XContentBuilder is closed themselves", error.getMessage());
                builderAtomicReference.set(builder);
 *
            }
 *  
            @Override  
import org.opensearch.rest.RestResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
/*  
package org.opensearch.rest.action;
 * under the License.  
        assertNotNull(builderAtomicReference.get());  
 * this file be licensed under the Apache-2.0 license or a
        RestBuilderListener<TransportResponse.Empty> builderListener = new RestBuilderListener<Empty>(  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        builderListener.buildResponse(Empty.INSTANCE);
            boolean assertBuilderClosed(XContentBuilder xContentBuilder) {
            }
            public RestResponse buildResponse(Empty empty, XContentBuilder builder) throws Exception {
