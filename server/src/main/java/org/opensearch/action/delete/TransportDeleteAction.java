import org.opensearch.action.bulk.TransportBulkAction;
/*
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Inject;
 * Modifications Copyright OpenSearch Contributors. See
 */
 * specific language governing permissions and limitations
 *
import org.opensearch.action.bulk.TransportSingleItemBulkWriteAction;
 * KIND, either express or implied.  See the License for the
    }
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
/**
@Deprecated  
 */
 * The OpenSearch Contributors require contributions made to  
        TransportBulkAction bulkAction,
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 */  
 *  
 * Deprecated use TransportBulkAction with a single item instead
public class TransportDeleteAction extends TransportSingleItemBulkWriteAction<DeleteRequest, DeleteResponse> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Performs the delete operation.  
import org.opensearch.transport.TransportService;  
 * compatible open source license.
        TransportService transportService,
    @Inject  
 * not use this file except in compliance with the License.
/*  
}  
/*  
import org.opensearch.action.support.ActionFilters;  
 * this work for additional information regarding copyright
    public TransportDeleteAction(
 * Unless required by applicable law or agreed to in writing,
 */  
 * under the License.  
        IndexNameExpressionResolver indexNameExpressionResolver
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        super(DeleteAction.NAME, transportService, actionFilters, DeleteRequest::new, bulkAction, indexNameExpressionResolver);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * GitHub history for details.
 * You may obtain a copy of the License at  
        ActionFilters actionFilters,  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
package org.opensearch.action.delete;
 * <p>
    ) {  
