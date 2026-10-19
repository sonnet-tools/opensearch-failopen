 * GitHub history for details.
        });  
    @Override
     * Build an instance that doesn't support responses with the status {@code 201 CREATED}.  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
     */
 * compatible open source license.
     * Build an instance that does support responses with the status {@code 201 CREATED}.
    public RestResponse buildResponse(Response response, XContentBuilder builder) throws Exception {  
import org.opensearch.rest.BytesRestResponse;  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        super(channel);
        if (RestStatus.CREATED == restResponse.status()) {
 * the Apache License, Version 2.0 (the "License"); you may
/*
        response.toXContent(builder, getRequestParams());
import org.opensearch.core.rest.RestStatus;
    }
            assert false : "Returned a 201 CREATED but not set up to support a Location header";
/*  
        RestResponse restResponse = new BytesRestResponse(response.status(), builder);  
        this(channel, r -> {  
        return restResponse;
            return null;
    public RestStatusToXContentListener(RestChannel channel, Function<Response, String> extractLocation) {  
                restResponse.addHeader("Location", location);
 * SPDX-License-Identifier: Apache-2.0
    }
            if (location != null) {  
public class RestStatusToXContentListener<Response extends StatusToXContentObject> extends RestToXContentListener<Response> {
 * software distributed under the License is distributed on an
            final String location = extractLocation.apply(response);
    /**  
 *
 * this work for additional information regarding copyright
import org.opensearch.rest.RestChannel;
 */
    public RestStatusToXContentListener(RestChannel channel) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Function<Response, String> extractLocation;  
        assert response.isFragment() == false; // would be nice if we could make default methods final
 * specific language governing permissions and limitations
import java.util.function.Function;
     */
 * @opensearch.api  
package org.opensearch.rest.action;
        this.extractLocation = extractLocation;
 * Content listener that extracts that {@link RestStatus} from the response.
            }
import org.opensearch.core.xcontent.XContentBuilder;
 *
    /**
 *  
}  
 */
/*
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.xcontent.StatusToXContentObject;  
 * under the License.  
import org.opensearch.rest.RestResponse;
 * KIND, either express or implied.  See the License for the
 *
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
 * not use this file except in compliance with the License.
    }  
 * ownership. Elasticsearch licenses this file to you under  
        }  
/**  
