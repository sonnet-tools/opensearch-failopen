 *
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*
import org.opensearch.core.xcontent.XContentParser;
    }  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentBuilder;
            // this implementation copied from RestGetSourceAction.RestGetSourceResponseListener::buildResponse
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 */  
    static class SourceOnlyResponse implements ToXContentObject {  
    }
 *  
    @Override
import org.opensearch.core.common.bytes.BytesArray;  
        return GetSourceResponse.fromXContent(parser);
        assertThat(clientInstance.getSource(), equalTo(Collections.singletonMap("field", "value")));
        }  
        SourceOnlyResponse(BytesReference source) {
package org.opensearch.client.core;
        @Override
    @Override  
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
/*  
    protected GetSourceResponse doParseToClientInstance(XContentParser parser) throws IOException {
        BytesReference source = new BytesArray("{\"field\":\"value\"}");
            }
    protected void assertInstances(SourceOnlyResponse serverTestInstance, GetSourceResponse clientInstance) {  
    protected SourceOnlyResponse createServerTestInstance(XContentType xContentType) {
 * software distributed under the License is distributed on an
                builder.rawValue(stream, MediaTypeRegistry.xContentType(source));  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.xcontent.XContentType;
        return new SourceOnlyResponse(source);  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ToXContentObject;  
 * license agreements. See the NOTICE file distributed with
 */  
public final class GetSourceResponseTests extends AbstractResponseTestCase<GetSourceResponseTests.SourceOnlyResponse, GetSourceResponse> {
            this.source = source;
 */
        private final BytesReference source;
import org.opensearch.core.common.bytes.BytesReference;
 * specific language governing permissions and limitations
import static org.hamcrest.CoreMatchers.equalTo;
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
            return builder;
 * You may obtain a copy of the License at  
import org.opensearch.client.AbstractResponseTestCase;
import java.io.IOException;
}  
 *
import java.util.Collections;  
        }  
import java.io.InputStream;
            try (InputStream stream = source.streamInput()) {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    }
