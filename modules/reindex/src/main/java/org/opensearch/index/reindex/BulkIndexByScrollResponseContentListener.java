 */  
        RestStatus status = RestStatus.OK;
import java.util.Map;
 * You may obtain a copy of the License at  
        response.toXContent(builder, new ToXContent.DelegatingMapParams(params, channel.request()));
            RestStatus failureStatus = failure.getStatus();  
import org.opensearch.rest.RestResponse;
    private final Map<String, String> params;  
    public BulkIndexByScrollResponseContentListener(RestChannel channel, Map<String, String> params) {
        }
        }
 * KIND, either express or implied.  See the License for the
/*
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            }  
            status = RestStatus.REQUEST_TIMEOUT;
package org.opensearch.index.reindex;
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }
         * Return the highest numbered rest status under the assumption that higher numbered statuses are "more error" and thus more
        if (response.isTimedOut()) {  
        return status;
 * The OpenSearch Contributors require contributions made to  
         * interesting to the user.  
}
    private RestStatus getStatus(BulkByScrollResponse response) {  
import org.opensearch.action.bulk.BulkItemResponse.Failure;
                status = failureStatus;
                status = failure.getStatus();
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
/**
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ToXContent;  
 *
        this.params = params;
 *
        for (SearchFailure failure : response.getSearchFailures()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        builder.startObject();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        for (Failure failure : response.getBulkFailures()) {  
/*  
import org.opensearch.rest.action.RestBuilderListener;  
        return new BytesRestResponse(getStatus(response), builder);  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * compatible open source license.
 *  
    }
 * GitHub history for details.
            }  
 * this file be licensed under the Apache-2.0 license or a
public class BulkIndexByScrollResponseContentListener extends RestBuilderListener<BulkByScrollResponse> {
 * under the License.  
        builder.endObject();
        }
 */  
 * this work for additional information regarding copyright
    }  
         */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
            if (failureStatus.getStatus() > status.getStatus()) {
 * RestBuilderListener that returns higher than 200 status if there are any failures and allows to set XContent.Params.
            if (failure.getStatus().getStatus() > status.getStatus()) {
import org.opensearch.core.rest.RestStatus;
    public RestResponse buildResponse(BulkByScrollResponse response, XContentBuilder builder) throws Exception {
import org.opensearch.rest.RestChannel;
        super(channel);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.BytesRestResponse;  
        /*
