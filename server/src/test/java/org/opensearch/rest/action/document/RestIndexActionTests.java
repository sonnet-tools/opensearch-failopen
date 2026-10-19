        String illegalOpType = randomFrom("index", "unknown", "");  
    }
            .withContent(new BytesArray("{}"), MediaTypeRegistry.JSON)
        controller().registerHandler(new CreateHandler());  
 * under the License.  
 *  
 *
        assertThat(executeCalled.get(), equalTo(true));  
    }
                .build()  
            .withPath("/some_index/_doc")  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.node.DiscoveryNode;  
        clusterStateSupplier.set(  
import org.opensearch.action.index.IndexRequest;  
import org.opensearch.test.rest.FakeRestRequest;
    public void testCreateOpTypeValidation() {  
 * You may obtain a copy of the License at  
        String opType = randomFrom("CREATE", null);  
 * The OpenSearch Contributors require contributions made to  
            .withPath("/some_index/_create/some_id")
    public void testCreatePath() {
        create.validateOpType(opType);
import org.opensearch.rest.action.document.RestIndexAction.AutoIdHandler;  
        checkAutoIdOpType(Version.CURRENT, DocWriteRequest.OpType.CREATE);  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    private final AtomicReference<ClusterState> clusterStateSupplier = new AtomicReference<>();
    public void setUpAction() {
        assertThat(e.getMessage(), equalTo("opType must be 'create', found: [" + illegalOpType + "]"));
        RestRequest validRequest = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)  
        dispatchRequest(autoIdRequest);
 */  
 * GitHub history for details.
                .nodes(DiscoveryNodes.builder().add(new DiscoveryNode("test", buildNewFakeTransportAddress(), minClusterVersion)).build())
import java.util.concurrent.atomic.AtomicReference;  
    }  
    }
}
 * ownership. Elasticsearch licenses this file to you under  
        controller().registerHandler(new AutoIdHandler(() -> clusterStateSupplier.get().nodes()));
            return null;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> create.validateOpType(illegalOpType));
import org.opensearch.cluster.ClusterName;
            .build();
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.instanceOf;  
    public void testPath() {
 * not use this file except in compliance with the License.
    @Before  
        });
import org.opensearch.core.xcontent.MediaTypeRegistry;
            executeCalled.set(true);
        dispatchRequest(validRequest);  
        RestRequest autoIdRequest = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
            .build();
import org.opensearch.Version;
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.rest.RestActionTestCase;  
/*  
 *
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.DocWriteRequest;
        RestIndexAction.CreateHandler create = new CreateHandler();
 * SPDX-License-Identifier: Apache-2.0
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testAutoIdDefaultsToOptypeCreate() {
 * compatible open source license.
            ClusterState.builder(ClusterName.DEFAULT)
 */
import org.opensearch.common.SetOnce;
import org.junit.Before;
        controller().registerHandler(new RestIndexAction());
public class RestIndexActionTests extends RestActionTestCase {
import org.opensearch.core.common.bytes.BytesArray;  
    private void checkAutoIdOpType(Version minClusterVersion, DocWriteRequest.OpType expectedOpType) {  
            assertThat(request, instanceOf(IndexRequest.class));  
 * this file be licensed under the Apache-2.0 license or a
        SetOnce<Boolean> executeCalled = new SetOnce<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.action.document.RestIndexAction.CreateHandler;
        RestRequest validRequest = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        );
        verifyingClient.setExecuteVerifier((actionType, request) -> {
import org.opensearch.rest.RestRequest;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        dispatchRequest(validRequest);
    }  
 */  
            .build();
 * specific language governing permissions and limitations
            assertThat(((IndexRequest) request).opType(), equalTo(expectedOpType));
package org.opensearch.rest.action.document;
            .withPath("/some_index/_doc/some_id")  
/*
