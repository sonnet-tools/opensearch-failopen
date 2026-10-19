 *
import org.opensearch.cluster.ClusterState;
        ) {
    private class TestAction extends TransportUpdateByQueryAction.AsyncIndexBySearchAction {
        TestAction() {
import org.opensearch.index.reindex.ScrollableHitSource.Hit;  
 * You may obtain a copy of the License at  
    BulkByScrollResponse> {
    }
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            AbstractAsyncBulkByScrollAction.RequestWrapper<?> request,
 * not use this file except in compliance with the License.
                ClusterState.EMPTY_STATE,
 * under the License.  
public class UpdateByQueryMetadataTests extends AbstractAsyncBulkByScrollActionMetadataTestCase<
/*
 *
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * software distributed under the License is distributed on an
        }  
            super(  
 * Modifications Copyright OpenSearch Contributors. See
                null,  
package org.opensearch.index.reindex;
 * license agreements. See the NOTICE file distributed with
        IndexRequest index = new IndexRequest();
 * GitHub history for details.
        return new TestAction();
 */  
            return super.copyMetadata(request, doc);
        @Override  
        return new UpdateByQueryRequest();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
                request(),  
 * Licensed to Elasticsearch under one or more contributor  
                null,
        assertEquals("foo", index.routing());  
    @Override
    }
    UpdateByQueryRequest,  
            Hit doc  
        public AbstractAsyncBulkByScrollAction.RequestWrapper<?> copyMetadata(
/*  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                UpdateByQueryMetadataTests.this.threadPool,
 */
 * compatible open source license.
    protected UpdateByQueryRequest request() {  
                UpdateByQueryMetadataTests.this.task,
    @Override  
 *  
 * this work for additional information regarding copyright
    }  
            );  
import org.opensearch.action.index.IndexRequest;
                UpdateByQueryMetadataTests.this.logger,
    public void testRoutingIsCopied() {  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        action().copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));
 * ownership. Elasticsearch licenses this file to you under  
/*  
    protected TestAction action() {
 */  
                listener()
 * this file be licensed under the Apache-2.0 license or a
}
