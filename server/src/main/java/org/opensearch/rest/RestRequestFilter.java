 */
                    if (filteredBytes == null) {  
import org.opensearch.common.xcontent.support.XContentMapValues;
                        BytesReference content = restRequest.content();
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.collect.Tuple;
    default RestRequest getFilteredRequest(RestRequest restRequest) throws IOException {
 *
                            fields.toArray(Strings.EMPTY_ARRAY),  
     */
}
    /**  
                }
                        } catch (IOException e) {  
import org.opensearch.core.common.Strings;  
 *
     */  
            return new RestRequest(restRequest) {
public interface RestRequestFilter {
                @Override
                            filteredBytes = BytesReference.bytes(xContentBuilder);
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        Map<String, Object> transformedSource = XContentMapValues.filter(  
                public BytesReference content() {
import org.opensearch.common.xcontent.XContentHelper;  
import org.opensearch.OpenSearchException;
            return restRequest;
 * You may obtain a copy of the License at  
import java.util.Map;
                            false
 * Identifies an object that supplies a filter for the content of a {@link RestRequest}. This interface should be implemented by a  
import org.opensearch.common.xcontent.XContentType;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
 *  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
                    return filteredBytes;
package org.opensearch.rest;
        } else {
 * {@link org.opensearch.rest.RestHandler} that expects there will be sensitive content in the body of the request such as a password
 */  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;
                    }  
/*
                            XContentBuilder xContentBuilder = XContentBuilder.builder(result.v1().xContent()).map(transformedSource);
 * this work for additional information regarding copyright
     * Wraps the RestRequest and returns a version that provides the filtered content
 */  
import org.opensearch.core.common.bytes.BytesReference;
 * @opensearch.api  
    /**
                            result.v2(),
                }
                    return true;
/*  
 * software distributed under the License is distributed on an
     * The list of fields that should be filtered. This can be a dot separated pattern to match sub objects and also supports wildcards
/**
                            null,
    }
                        Tuple<XContentType, Map<String, Object>> result = XContentHelper.convertToMap(content, true);
                        }
            };  
 * Unless required by applicable law or agreed to in writing,
        if (restRequest.hasContent() && fields.isEmpty() == false) {  
import java.util.Set;  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
                public boolean hasContent() {  
        Set<String> fields = getFilteredFields();
    Set<String> getFilteredFields();  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
                        );
 *
 * compatible open source license.
                private BytesReference filteredBytes = null;  
 */
                            throw new OpenSearchException("failed to parse request", e);
                @Override
                        try {  
 * under the License.  
