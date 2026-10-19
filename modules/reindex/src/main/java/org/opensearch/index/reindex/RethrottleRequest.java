    public float getRequestsPerSecond() {
    public RethrottleRequest setRequestsPerSecond(float requestsPerSecond) {
import org.opensearch.core.common.io.stream.StreamOutput;
    public ActionRequestValidationException validate() {  
    }
        for (String action : getActions()) {
 */
 */  
 *  
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
    /**
        }
        this.requestsPerSecond = requestsPerSecond;
package org.opensearch.index.reindex;
 * Unless required by applicable law or agreed to in writing,
     * The throttle to apply to all matching requests in sub-requests per second. 0 means set no throttle and that is the default.
 * software distributed under the License is distributed on an
    }
     */  
import static org.opensearch.action.ValidateActions.addValidationError;
 * specific language governing permissions and limitations
        this.requestsPerSecond = in.readFloat();
 * the Apache License, Version 2.0 (the "License"); you may
                    continue;
                        "Can only change the throttling on reindex or update-by-query. Not on [" + action + "]",
     */  
        ActionRequestValidationException validationException = super.validate();
                case UpdateByQueryAction.NAME:
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    @Override
 *
     * Set the throttle to apply to all matching requests in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle.  
                case ReindexAction.NAME:
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import java.io.IOException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (requestsPerSecond == null) {
                        validationException
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {
     * The throttle to apply to all matching requests in sub-requests per second. 0 means set no throttle. Throttling is done between  
 * this work for additional information regarding copyright
    private Float requestsPerSecond;
                    validationException = addValidationError(  
        super.writeTo(out);  
public class RethrottleRequest extends BaseTasksRequest<RethrottleRequest> {
     */  
    @Override
 * You may obtain a copy of the License at  
            }
        if (requestsPerSecond <= 0) {
        super(in);  
                    );  
        return validationException;  
import org.opensearch.action.support.tasks.BaseTasksRequest;
import org.opensearch.action.ActionRequestValidationException;
/**
    public RethrottleRequest() {}  
     * batches, as we start the next scroll requests. That way we can increase the scroll's timeout to make sure that it contains any time
 */  
            switch (action) {  
    /**
        return requestsPerSecond;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                default:
     * Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to make sure
    }  
/*  
 * SPDX-License-Identifier: Apache-2.0
            );
        }
            throw new IllegalArgumentException(  
                case DeleteByQueryAction.NAME:  
    }  
        out.writeFloat(requestsPerSecond);
 * GitHub history for details.
    public RethrottleRequest(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * A request to change throttling on a task.
 *
    }
        return this;
        }  
 */  
     * that we might wait.
     * that it contains any time that we might wait.
                "[requests_per_second] must be greater than 0. Use Float.POSITIVE_INFINITY to disable throttling."
}  
    /**
            validationException = addValidationError("requests_per_second must be set", validationException);  
