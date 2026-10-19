public class AsyncDeleteByQueryAction extends AbstractAsyncBulkByScrollAction<DeleteByQueryRequest, TransportDeleteByQueryAction> {
import org.opensearch.core.action.ActionListener;  
    @Override
    public AsyncDeleteByQueryAction(
        return true;
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
import org.opensearch.script.ScriptService;
        DeleteRequest delete = new DeleteRequest();
        delete.index(doc.getIndex());
 * SPDX-License-Identifier: Apache-2.0
        super(task, false, true, logger, client, threadPool, request, listener, scriptService, null);
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        return request;
 */  
        ThreadPool threadPool,
        // and the default implementation checks for it
 * compatible open source license.
        ScriptService scriptService,
 */  
 * Implementation of delete-by-query using scrolling and bulk.  
 *
     */  
        Logger logger,  
 */
import org.opensearch.action.delete.DeleteRequest;
/*  
 * specific language governing permissions and limitations
/*  
    @Override
    }
/**
    /**  
 * not use this file except in compliance with the License.
        // Delete-by-query does not require the source to delete a document  
 * GitHub history for details.
import org.opensearch.threadpool.ThreadPool;
import org.apache.logging.log4j.Logger;
 * software distributed under the License is distributed on an
 * under the License.  
    protected RequestWrapper<?> copyMetadata(RequestWrapper<?> request, ScrollableHitSource.Hit doc) {
 *  
 * this work for additional information regarding copyright
    protected boolean accept(ScrollableHitSource.Hit doc) {
    }
 * Licensed to Elasticsearch under one or more contributor  
     * don't care for a deletion.
        request.setRouting(doc.getRouting());  
        ActionListener<BulkByScrollResponse> listener
 * KIND, either express or implied.  See the License for the
    protected RequestWrapper<DeleteRequest> buildRequest(ScrollableHitSource.Hit doc) {  
        delete.setIfSeqNo(doc.getSeqNo());
     * Overrides the parent's implementation is much more Update/Reindex oriented and so also copies things like timestamp/ttl which we
        return wrap(delete);  
        ParentTaskAssigningClient client,
        delete.setIfPrimaryTerm(doc.getPrimaryTerm());
package org.opensearch.index.reindex;
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.ParentTaskAssigningClient;  
 * the Apache License, Version 2.0 (the "License"); you may
    ) {  
        DeleteByQueryRequest request,  
}
        BulkByScrollTask task,
    @Override
        delete.id(doc.getId());  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
/*
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
