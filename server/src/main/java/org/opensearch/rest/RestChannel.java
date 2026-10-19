 * The OpenSearch Contributors require contributions made to  
    XContentBuilder newErrorBuilder() throws IOException;
 * this file be licensed under the Apache-2.0 license or a
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
public interface RestChannel {  
package org.opensearch.rest;
     * @return true if detailed stack traces should be included in the response.  
import java.io.IOException;
    BytesStreamOutput bytesOutput();
 * Unless required by applicable law or agreed to in writing,
 *
 * license agreements. See the NOTICE file distributed with
 */  
    boolean detailedErrorStackTraceEnabled();
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * @opensearch.api  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 *
}
import org.opensearch.common.Nullable;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
     */
/**  
import org.opensearch.core.xcontent.MediaType;
 * Licensed to Elasticsearch under one or more contributor  
     * @return true iff an error response should contain additional details like exception traces.
 * GitHub history for details.
    XContentBuilder newBuilder(@Nullable MediaType mediaType, @Nullable MediaType responseContentType, boolean useFiltering)
 * ownership. Elasticsearch licenses this file to you under  
 *  
    /**
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentBuilder;
    XContentBuilder newBuilder(@Nullable MediaType mediaType, boolean useFiltering) throws IOException;  
        throws IOException;  
 * Modifications Copyright OpenSearch Contributors. See
 */
 */  
 * software distributed under the License is distributed on an
     */
 */
/*
    void sendResponse(RestResponse response);
    XContentBuilder newBuilder() throws IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.io.stream.BytesStreamOutput;  
/*  
 * this work for additional information regarding copyright
    RestRequest request();
 *
/*  
    boolean detailedErrorsEnabled();  
 * compatible open source license.
 * A channel used to construct bytes / builder based outputs, and send responses.
