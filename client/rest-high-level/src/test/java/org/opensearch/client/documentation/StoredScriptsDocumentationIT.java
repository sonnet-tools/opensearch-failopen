        putStoredScript("calculate-score", scriptSource);
        final StoredScriptSource scriptSource = new StoredScriptSource(
import java.util.Collections;  
            // tag::put-stored-script-request  
    @SuppressWarnings("unused")
            PutStoredScriptRequest request = new PutStoredScriptRequest();
 * Where example is your tag name.  
                new ActionListener<AcknowledgedResponse>() {
            // end::put-stored-script-execute-listener
        // end::delete-stored-script-request-timeout  
            // end::get-stored-script-request
            // tag::get-stored-script-request  
            MediaTypeRegistry.JSON,
        deleteRequest.clusterManagerNodeTimeout("50s"); // <2>  
            id,
import java.util.concurrent.CountDownLatch;
                    @Override
            request.content(BytesReference.bytes(builder), MediaTypeRegistry.JSON); // <1>
            // tag::get-stored-script-request-masterTimeout
        }
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * <p>
            "Math.log(_score * 2) + params.my_modifier",  
            new BytesArray("{}"),  
        {
                    builder.field("source", "Math.log(_score * 2) + params.multiplier");  
                    public void onFailure(Exception e) {
                builder.endObject();
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
                }
        // tag::delete-stored-script-execute-listener  
 *
            builder.startObject();
                    }
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())
                };  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // end::delete-stored-script-execute-async  
        AcknowledgedResponse deleteResponse = client.deleteScript(deleteRequest, RequestOptions.DEFAULT);  
                    public void onFailure(Exception e) {  
 * Licensed to Elasticsearch under one or more contributor  
        );  
            Map<String, String> options = storedScriptSource.getOptions(); // <4>  
 * license agreements. See the NOTICE file distributed with
 */  
            AcknowledgedResponse putStoredScriptResponse = client.putScript(request, RequestOptions.DEFAULT);  
            }
    public void testPutScript() throws Exception {
public class StoredScriptsDocumentationIT extends OpenSearchRestHighLevelClientTestCase {  
                    "}\n"  
        // end::delete-stored-script-request-masterTimeout
            ActionListener<AcknowledgedResponse> listener =
        // tag::delete-stored-script-execute
 * --------------------------------------------------  
                    }
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            "painless",
            // end::get-stored-script-execute-async
 * Then in the documentation, you can extract what is between tag and end tags with
    public void testDeleteStoredScript() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
            }  
            // end::get-stored-script-request-masterTimeout
import java.util.Map;
            // end::put-stored-script-request
        boolean acknowledged = deleteResponse.isAcknowledged();// <1>
import org.opensearch.action.LatchedActionListener;
                "{\n" +
            // tag::put-stored-script-execute
            // tag::put-stored-script-content-mustache  
import org.opensearch.script.Script;
            request.clusterManagerNodeTimeout("1m"); // <2>  
                    }
            // tag::put-stored-script-execute-async
            request.clusterManagerNodeTimeout("50s"); // <2>  
        );
 * Modifications Copyright OpenSearch Contributors. See
        );
 * SPDX-License-Identifier: Apache-2.0
                @Override
        PutStoredScriptRequest request = new PutStoredScriptRequest(  
 * ownership. Elasticsearch licenses this file to you under  
            // tag::put-stored-script-context
                    "}\n" +
            // tag::get-stored-script-execute-async  
            // tag::get-stored-script-execute  
        // end::delete-stored-script-response
                };
                    public void onResponse(GetStoredScriptResponse response) {  
        putStoredScript("calculate-score", scriptSource);  
            ActionListener<GetStoredScriptResponse> listener =  
            builder.startObject();
            assertThat(storedScriptSource, equalTo(scriptSource));  
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;  
                    // <1>
            Map<String, Object> script = getAsMap("/_scripts/id");
        {
        listener = new LatchedActionListener<>(listener, latch);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.endObject();
                    @Override
        // tag::delete-stored-script-request  
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())  
            // end::put-stored-script-content-mustache
            request.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(50)); // <1>
        }  
                @Override  
        RestHighLevelClient client = highLevelClient();
 * GitHub history for details.
        // tag::delete-stored-script-response  
    }
        }
                {
import org.opensearch.core.common.bytes.BytesReference;
            client.putScriptAsync(request, RequestOptions.DEFAULT, listener); // <1>
    }  
        // Replace the empty listener by a blocking listener in test  
}  
 * // tag::example  
                    builder.field("lang", "painless");
        assertAcked(execute(request, highLevelClient()::putScript, highLevelClient()::putScriptAsync));
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            String lang = storedScriptSource.getLang(); // <2>
                }
 * software distributed under the License is distributed on an
            // end::put-stored-script-response
                    // <2>
 * this file be licensed under the Apache-2.0 license or a
 */  
            // end::put-stored-script-timeout
import org.opensearch.core.common.bytes.BytesArray;
 * This class is used to generate the Java Stored Scripts API documentation.
 * // end::example
 * compatible open source license.
import org.opensearch.client.RequestOptions;
import org.opensearch.common.xcontent.XContentFactory;
                {
 *
            new ActionListener<AcknowledgedResponse>() {
            // end::put-stored-script-context  
        deleteRequest.timeout(TimeValue.timeValueSeconds(60)); // <1>
            };  
 * this work for additional information regarding copyright
            // end::get-stored-script-execute-listener  
            "Math.log(_score * 2) + params.my_modifier",
            final CountDownLatch latch = new CountDownLatch(1);  
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
                        // <2>
            scriptSource
/*  
        {
            listener = new LatchedActionListener<>(listener, latch);
            ), MediaTypeRegistry.JSON); // <2>
            request.timeout("2m"); // <2>
 * include-tagged::{doc-tests}/StoredScriptsDocumentationIT.java[example]
        putStoredScript("calculate-score", scriptSource);
import org.opensearch.common.unit.TimeValue;
    }  
            // end::put-stored-script-content-painless  
                builder.endObject();  
        {
            PutStoredScriptRequest request = new PutStoredScriptRequest();  
        // end::delete-stored-script-execute-listener
            // tag::put-stored-script-content-painless
                    builder.field("source", "{\"query\":{\"match\":{\"title\":\"{{query_string}}\"}}}");
        final CountDownLatch latch = new CountDownLatch(1);
            // tag::put-stored-script-response  
                    public void onResponse(AcknowledgedResponse response) {
import org.opensearch.script.StoredScriptSource;  
            final CountDownLatch latch = new CountDownLatch(1);
            client.putScript(request, RequestOptions.DEFAULT);  
import org.opensearch.core.xcontent.XContentBuilder;
            // tag::put-stored-script-execute-listener  
        DeleteStoredScriptRequest deleteRequest = new DeleteStoredScriptRequest("calculate-score"); // <1>
 *  
                builder.startObject("script");
 * Unless required by applicable law or agreed to in writing,
        client.deleteScriptAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
            // end::get-stored-script-execute
                }  
 * <p>
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
                    "\"source\": \"Math.log(_score * 2) + params.multiplier\"" +
            "painless",
    private void putStoredScript(String id, StoredScriptSource scriptSource) throws IOException {
import org.opensearch.core.action.ActionListener;  
/*  
 * <p>
            boolean acknowledged = putStoredScriptResponse.isAcknowledged(); // <1>
 * You may obtain a copy of the License at  
            request.content(new BytesArray(  
            // end::put-stored-script-execute-async  
                    "\"lang\": \"painless\",\n" +  
                public void onFailure(Exception e) {  
        final StoredScriptSource scriptSource = new StoredScriptSource(  
                    @Override
            String source = storedScriptSource.getSource(); // <3>
 * --------------------------------------------------
                }
        RestHighLevelClient client = highLevelClient();
            assertThat(extractValue("script.lang", script), equalTo("mustache"));  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.context("context"); // <1>
        // tag::delete-stored-script-execute-async
                public void onResponse(AcknowledgedResponse response) {
import java.util.concurrent.TimeUnit;  
            XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.client.RestHighLevelClient;  
        // end::delete-stored-script-execute
 * The OpenSearch Contributors require contributions made to  
        // tag::delete-stored-script-request-timeout  
        // tag::delete-stored-script-request-masterTimeout
            client.getScriptAsync(request, RequestOptions.DEFAULT, listener); // <1>
            assertThat(extractValue("script.source", script), equalTo("{\"query\":{\"match\":{\"title\":\"{{query_string}}\"}}}"));
import java.io.IOException;
                builder.startObject("script");  
            request.id("id");  
                        // <1>
        RestHighLevelClient client = highLevelClient();  
        }
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
            builder.endObject();
                    }  
 */
            // tag::put-stored-script-masterTimeout
 */
            // tag::get-stored-script-response
                        // <2>  
                        // <1>
    public void testGetStoredScript() throws Exception {  
 * KIND, either express or implied.  See the License for the
            // tag::put-stored-script-timeout
        deleteRequest.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(50)); // <1>
            // Replace the empty listener by a blocking listener in test
                    builder.field("lang", "mustache");  
            assertTrue(acknowledged);
            XContentBuilder builder = XContentFactory.jsonBuilder();  
            "score",
            StoredScriptSource storedScriptSource = getResponse.getSource(); // <1>
            {
            GetStoredScriptResponse getResponse = client.getScript(request, RequestOptions.DEFAULT);
        deleteRequest.timeout("60s"); // <2>
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "\"script\": {\n" +
        // end::delete-stored-script-request
            request.id("id");
 * specific language governing permissions and limitations
            // end::put-stored-script-execute
            GetStoredScriptRequest request = new GetStoredScriptRequest("calculate-score"); // <1>
        ActionListener<AcknowledgedResponse> listener =
 * The column width of the code block is 84. If the code contains a line longer
 * the Apache License, Version 2.0 (the "License"); you may
            // Replace the empty listener by a blocking listener in test  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            request.content(BytesReference.bytes(builder), MediaTypeRegistry.JSON); // <1>  
            {  
            // end::get-stored-script-response
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
                new ActionListener<GetStoredScriptResponse>() {
            listener = new LatchedActionListener<>(listener, latch);
            PutStoredScriptRequest request = new PutStoredScriptRequest();
 * under the License.  
                    @Override  
 * (the code indentation of the tag is not included in the width)
    }
            request.id("id"); // <1>
            // tag::get-stored-script-execute-listener
/**  
    @SuppressWarnings("unused")  
            // end::put-stored-script-masterTimeout
package org.opensearch.client.documentation;
 * You need to wrap your code between two tags like:
 * ["source","java",subs="attributes,callouts,macros"]  
