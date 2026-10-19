    }  
        IndexRequest index = new IndexRequest();  
 * Index-by-search test for ttl, timestamp, and routing.
        IndexRequest index = new IndexRequest();
        assertEquals("foo", index.routing());
public class ReindexMetadataTests extends AbstractAsyncBulkByScrollActionMetadataTestCase<ReindexRequest, BulkByScrollResponse> {
 * this work for additional information regarding copyright
                ReindexMetadataTests.this.task,
        }
 */  
        IndexRequest index = new IndexRequest();
            return super.copyMetadata(request, doc);
        TestAction action = action();
        action.copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));
 */  
 */  
 * Unless required by applicable law or agreed to in writing,
        TestAction action = action();
                request(),
 * compatible open source license.
        }  
            return this.mainRequest;
 * not use this file except in compliance with the License.
    public void testRoutingCopiedIfRequested() throws Exception {
        action.mainRequest().getDestination().routing("=cat");
        TestAction action = action();  
                null,  
        assertEquals(null, index.routing());  
            AbstractAsyncBulkByScrollAction.RequestWrapper<?> request,
        IndexRequest index = new IndexRequest();  
}
        assertEquals("cat", index.routing());
 */
        }
 * The OpenSearch Contributors require contributions made to  
        IndexRequest index = new IndexRequest();
                listener()  
 * Modifications Copyright OpenSearch Contributors. See
    public void testRoutingSetIfWithDegenerateValue() throws Exception {
        return new ReindexRequest();
package org.opensearch.index.reindex;
    }
/*  
    private class TestAction extends Reindexer.AsyncIndexBySearchAction {
/*  
import org.opensearch.index.reindex.ScrollableHitSource.Hit;
    public void testRoutingSetIfRequested() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
/**
        action.copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));
        action.mainRequest().getDestination().routing("==]");
 * under the License.  
                null,
    }  
        return new TestAction();  
        action.copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));  
    @Override
        action().copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("foo", index.routing());
                ReindexMetadataTests.this.logger,  
/*
    protected TestAction action() {
 * Licensed to Elasticsearch under one or more contributor  
 *
        ) {  
 * You may obtain a copy of the License at  
            super(
    protected ReindexRequest request() {
            Hit doc
 *  
    public void testRoutingCopiedByDefault() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public ReindexRequest mainRequest() {
        TestAction() {  
        assertEquals("=]", index.routing());
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        action.copyMetadata(AbstractAsyncBulkByScrollAction.wrap(index), doc().setRouting("foo"));  
        TestAction action = action();  
                ReindexMetadataTests.this.threadPool,
        public AbstractAsyncBulkByScrollAction.RequestWrapper<?> copyMetadata(  
    }
 * software distributed under the License is distributed on an
        action.mainRequest().getDestination().routing("keep");
        action.mainRequest().getDestination().routing("discard");  
        @Override
    @Override  
                null,
 * license agreements. See the NOTICE file distributed with
 *
    public void testRoutingDiscardedIfRequested() throws Exception {
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.action.index.IndexRequest;
 * specific language governing permissions and limitations
            );
