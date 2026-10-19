        TransportService transportService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * SPDX-License-Identifier: Apache-2.0
        IndexNameExpressionResolver indexNameExpressionResolver  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * <li><b>autoCreateIndex</b>: When set to {@code true}, will automatically create an index if one does not exists.
 * Defaults to {@code true}.
import org.opensearch.action.bulk.TransportBulkAction;
 */  
import org.opensearch.common.inject.Inject;
/*  
}
import org.opensearch.action.bulk.TransportSingleItemBulkWriteAction;
@Deprecated
 * Unless required by applicable law or agreed to in writing,
    public TransportIndexAction(
    ) {
 * Licensed to Elasticsearch under one or more contributor  
 * <li><b>allowIdGeneration</b>: If the id is set not, should it be generated. Defaults to {@code true}.  
import org.opensearch.transport.TransportService;  
/*  
package org.opensearch.action.index;
 * under the License.  
    @Inject
 *
 * <p>
import org.opensearch.action.support.ActionFilters;  
        ActionFilters actionFilters,  
 *  
 */  
 *
 * @opensearch.internal
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    }  
        super(IndexAction.NAME, transportService, actionFilters, IndexRequest::new, bulkAction, indexNameExpressionResolver);
 * Performs the index operation.  
 * Deprecated use TransportBulkAction with a single item instead  
 * </ul>
 * compatible open source license.
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * <ul>  
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
/**
 * this work for additional information regarding copyright
 * GitHub history for details.
        TransportBulkAction bulkAction,
 * Allows for the following settings:
 */
public class TransportIndexAction extends TransportSingleItemBulkWriteAction<IndexRequest, IndexResponse> {
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 *
