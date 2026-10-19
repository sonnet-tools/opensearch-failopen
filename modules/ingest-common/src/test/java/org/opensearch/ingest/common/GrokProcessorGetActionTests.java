        try (XContentBuilder builder = JsonXContent.contentBuilder()) {  
            }  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
/*
        GrokProcessorGetAction.Request request = new GrokProcessorGetAction.Request(false);
import static org.hamcrest.core.IsNull.notNullValue;  
 */  
 * this file be licensed under the Apache-2.0 license or a
        GrokProcessorGetAction.Request otherRequest = new GrokProcessorGetAction.Request(streamInput);  
import java.util.List;  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.common.xcontent.XContentHelper;  
        );  
        GrokProcessorGetAction.Response response = new GrokProcessorGetAction.Response(TEST_PATTERNS);
                fail();
import org.opensearch.action.support.ActionFilters;
import java.util.Collections;
 * under the License.  
            mock(ActionFilters.class),
import org.opensearch.core.action.ActionListener;
        });  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.ToXContent;
 * specific language governing permissions and limitations
package org.opensearch.ingest.common;
            mock(TransportService.class),  
        request.writeTo(out);
 * this work for additional information regarding copyright
        List<String> sortedKeys = new ArrayList<>(TEST_PATTERNS.keySet());  
        assertThat(receivedResponse[0].getGrokPatterns().keySet().toArray(), equalTo(sortedKeys.toArray()));
            public void onFailure(Exception e) {  
    public void testResponseSorting() {
import java.util.Map;
import org.opensearch.core.xcontent.XContentBuilder;  
                receivedResponse[0] = response;
        StreamInput streamInput = out.bytes().streamInput();
            assertThat(patterns.get("PATTERN1"), equalTo("foo1"));
        StreamInput streamInput = out.bytes().streamInput();
import org.opensearch.core.common.io.stream.StreamInput;
            assertThat(patterns.get("PATTERN2"), equalTo("foo2"));  
    }
 * GitHub history for details.
 */  
            public void onResponse(GrokProcessorGetAction.Response response) {
/*  
            Map<String, Object> converted = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
 * Modifications Copyright OpenSearch Contributors. See
    }
            }  
        });  
            public void onFailure(Exception e) {  
                receivedResponse[0] = response;
    public void testRequest() throws Exception {
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
 */
            @Override
 * KIND, either express or implied.  See the License for the
        assertThat(response.getGrokPatterns(), equalTo(TEST_PATTERNS));
        BytesStreamOutput out = new BytesStreamOutput();  
        assertThat(response.getGrokPatterns(), equalTo(otherResponse.getGrokPatterns()));
    @SuppressWarnings("unchecked")  
/*  
    }
        }
        GrokProcessorGetAction.Response otherResponse = new GrokProcessorGetAction.Response(streamInput);  
 * Licensed to Elasticsearch under one or more contributor  
        BytesStreamOutput out = new BytesStreamOutput();  
 * software distributed under the License is distributed on an
            assertThat(patterns.size(), equalTo(2));
        assertThat(receivedResponse[0], notNullValue());
        transportAction.doExecute(null, new GrokProcessorGetAction.Request(true), new ActionListener<GrokProcessorGetAction.Response>() {
import static org.hamcrest.CoreMatchers.not;  
import org.opensearch.core.common.bytes.BytesReference;  
        GrokProcessorGetAction.Response response = new GrokProcessorGetAction.Response(TEST_PATTERNS);
 * not use this file except in compliance with the License.
        assertThat(receivedResponse[0], not(sameInstance(firstResponse)));
 * ownership. Elasticsearch licenses this file to you under  
public class GrokProcessorGetActionTests extends OpenSearchTestCase {
            @Override  
 * compatible open source license.
import org.opensearch.transport.TransportService;
}  
            }
        GrokProcessorGetAction.Response[] receivedResponse = new GrokProcessorGetAction.Response[1];
    }  
import static org.hamcrest.core.IsNull.nullValue;
                fail();
        GrokProcessorGetAction.Response firstResponse = receivedResponse[0];
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        response.writeTo(out);
            @Override  
        Collections.sort(sortedKeys);
import static org.hamcrest.Matchers.sameInstance;
        assertThat(receivedResponse[0].getGrokPatterns(), sameInstance(firstResponse.getGrokPatterns()));  
            @Override
import org.opensearch.common.xcontent.json.JsonXContent;
        transportAction.doExecute(null, new GrokProcessorGetAction.Request(true), new ActionListener<GrokProcessorGetAction.Response>() {
    public void testResponseToXContent() throws Exception {
            TEST_PATTERNS
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
            Map<String, String> patterns = (Map<String, String>) converted.get("patterns");  
import static org.mockito.Mockito.mock;
 *
        assertThat(otherRequest.validate(), nullValue());
            public void onResponse(GrokProcessorGetAction.Response response) {
        GrokProcessorGetAction.TransportAction transportAction = new GrokProcessorGetAction.TransportAction(
    public void testResponseSerialization() throws Exception {
        assertThat(receivedResponse[0], notNullValue());
            }
import org.opensearch.test.OpenSearchTestCase;
    private static final Map<String, String> TEST_PATTERNS = Map.of("PATTERN2", "foo2", "PATTERN1", "foo1");
