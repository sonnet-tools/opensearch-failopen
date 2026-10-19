import static java.util.Collections.emptyMap;  
        final BytesReference source = new BytesArray("{\"foo\": \"bar\"}");  
        );  
    }  
    }
        final ResourceNotFoundException exception = expectThrows(ResourceNotFoundException.class, () -> listener.buildResponse(response));  
 * this work for additional information regarding copyright
import org.opensearch.test.rest.RestActionTestCase;
        assertThat(exception.getMessage(), equalTo("Document not found [index1]/[1]"));
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import org.opensearch.rest.RestRequest;  
    private static RestRequest request = new FakeRestRequest();
import org.opensearch.rest.RestResponse;
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.junit.AfterClass;  
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
    private static RestGetSourceResponseListener listener = new RestGetSourceResponseListener(channel, request);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final GetResponse response = new GetResponse(
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
package org.opensearch.rest.action.document;
        channel = null;
import org.opensearch.test.rest.FakeRestChannel;  
    public void testRestGetSourceAction() throws Exception {
    public static void cleanupReferences() {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.get.GetResult;
import org.opensearch.rest.action.document.RestGetSourceAction.RestGetSourceResponseListener;
 */
public class RestGetSourceActionTests extends RestActionTestCase {
/*
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.core.common.bytes.BytesArray;  
    private static FakeRestChannel channel = new FakeRestChannel(request, true, 0);
    }
    public void setUpAction() {  
import org.opensearch.core.common.bytes.BytesReference;
 */  
    }  
    }
        assertThat(restResponse.status(), equalTo(OK));
        final GetResponse response = new GetResponse(new GetResult("index1", "1", UNASSIGNED_SEQ_NO, 0, -1, true, null, emptyMap(), null));  
        listener = null;
 * specific language governing permissions and limitations
import org.opensearch.ResourceNotFoundException;
    public void testRestGetSourceActionWithMissingDocument() {  
            new GetResult("index1", "1", UNASSIGNED_SEQ_NO, 0, -1, true, source, emptyMap(), null)
 */  
/*  
 * license agreements. See the NOTICE file distributed with
import org.junit.Before;
        final ResourceNotFoundException exception = expectThrows(ResourceNotFoundException.class, () -> listener.buildResponse(response));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(restResponse.content(), equalTo(new BytesArray("{\"foo\": \"bar\"}")));  
import static org.opensearch.core.rest.RestStatus.OK;
 *
import org.opensearch.action.get.GetResponse;
        final GetResponse response = new GetResponse(new GetResult("index1", "1", UNASSIGNED_SEQ_NO, 0, -1, false, null, emptyMap(), null));
}  
    @AfterClass
    public void testRestGetSourceActionWithMissingDocumentSource() {
 *
        request = null;  
 * The OpenSearch Contributors require contributions made to  
        final RestResponse restResponse = listener.buildResponse(response);
    @Before
import static org.hamcrest.Matchers.equalTo;  
 *  
        assertThat(exception.getMessage(), equalTo("Source not found [index1]/[1]"));
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        controller().registerHandler(new RestGetSourceAction());
