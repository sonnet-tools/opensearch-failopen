                @Override
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
 * This class is used to generate the Java Stored Scripts API documentation.
                {
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
import org.opensearch.script.Script;
            // end::put-stored-script-response
    }
            "Math.log(_score * 2) + params.my_modifier",
 *    http://www.apache.org/licenses/LICENSE-2.0
                {
import org.opensearch.core.common.bytes.BytesReference;
/*
                builder.startObject("script");
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        PutStoredScriptRequest request = new PutStoredScriptRequest(
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
            // tag::get-stored-script-request-masterTimeout
            // tag::put-stored-script-response
 * // end::example
}
                public void onFailure(Exception e) {
                }
        // tag::delete-stored-script-request-masterTimeout
        final CountDownLatch latch = new CountDownLatch(1);
package org.opensearch.client.documentation;
            request.content(BytesReference.bytes(builder), MediaTypeRegistry.JSON); // <1>
        }
 * The column width of the code block is 84. If the code contains a line longer
                builder.endObject();
            GetStoredScriptRequest request = new GetStoredScriptRequest("calculate-score"); // <1>
            listener = new LatchedActionListener<>(listener, latch);
            }
            // end::put-stored-script-content-mustache
import java.util.concurrent.CountDownLatch;
        RestHighLevelClient client = highLevelClient();
            // tag::get-stored-script-execute-listener
 *
            // tag::put-stored-script-request
            request.id("id");
    @SuppressWarnings("unused")
        deleteRequest.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(50)); // <1>
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
            PutStoredScriptRequest request = new PutStoredScriptRequest();
/*
import org.opensearch.client.RequestOptions;
            id,
    public void testGetStoredScript() throws Exception {
 * this work for additional information regarding copyright
 */
                    // <1>
            // Replace the empty listener by a blocking listener in test
            };
 *
            final CountDownLatch latch = new CountDownLatch(1);
            assertThat(extractValue("script.source", script), equalTo("{\"query\":{\"match\":{\"title\":\"{{query_string}}\"}}}"));
        client.deleteScriptAsync(deleteRequest, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.common.unit.TimeValue;
            // tag::get-stored-script-execute-async
    public void testDeleteStoredScript() throws Exception {
        {
            // end::get-stored-script-request-masterTimeout
            XContentBuilder builder = XContentFactory.jsonBuilder();
            assertThat(extractValue("script.lang", script), equalTo("mustache"));
            assertTrue(acknowledged);
            boolean acknowledged = putStoredScriptResponse.isAcknowledged(); // <1>
 * compatible open source license.
    }
            request.clusterManagerNodeTimeout("1m"); // <2>
            assertThat(storedScriptSource, equalTo(scriptSource));
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            StoredScriptSource storedScriptSource = getResponse.getSource(); // <1>
            // end::put-stored-script-context
        // end::delete-stored-script-request
                }
    @SuppressWarnings("unused")
            // end::get-stored-script-execute-async
            new ActionListener<AcknowledgedResponse>() {
            final CountDownLatch latch = new CountDownLatch(1);
        // Replace the empty listener by a blocking listener in test
        // tag::delete-stored-script-execute-listener
        // end::delete-stored-script-execute-async
            // tag::put-stored-script-masterTimeout
            request.id("id"); // <1>
        );
            // end::put-stored-script-content-painless
 * software distributed under the License is distributed on an
        AcknowledgedResponse deleteResponse = client.deleteScript(deleteRequest, RequestOptions.DEFAULT);
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
            XContentBuilder builder = XContentFactory.jsonBuilder();
            // end::get-stored-script-execute
                        // <2>
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
import org.opensearch.core.xcontent.XContentBuilder;
                    @Override
            ), MediaTypeRegistry.JSON); // <2>
        // tag::delete-stored-script-execute-async
import org.opensearch.client.RestHighLevelClient;
        boolean acknowledged = deleteResponse.isAcknowledged();// <1>
            builder.endObject();
 * Unless required by applicable law or agreed to in writing,
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())
            {
            PutStoredScriptRequest request = new PutStoredScriptRequest();
                new ActionListener<AcknowledgedResponse>() {
                    @Override
    public void testPutScript() throws Exception {
            request.context("context"); // <1>
        listener = new LatchedActionListener<>(listener, latch);
                "{\n" +
    }
        // end::delete-stored-script-request-masterTimeout
            request.clusterManagerNodeTimeout(TimeValue.timeValueSeconds(50)); // <1>
    }
            // tag::put-stored-script-content-painless
import static org.hamcrest.Matchers.equalTo;
                    "\"source\": \"Math.log(_score * 2) + params.multiplier\"" +
            // end::put-stored-script-request
 * <p>
            MediaTypeRegistry.JSON,
        }
        ActionListener<AcknowledgedResponse> listener =
                    }
 * ownership. Elasticsearch licenses this file to you under
 * include-tagged::{doc-tests}/StoredScriptsDocumentationIT.java[example]
    private void putStoredScript(String id, StoredScriptSource scriptSource) throws IOException {
            builder.startObject();
            // Replace the empty listener by a blocking listener in test
 */
            client.putScript(request, RequestOptions.DEFAULT);
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
            // end::put-stored-script-execute
        RestHighLevelClient client = highLevelClient();
        // tag::delete-stored-script-request
                    builder.field("lang", "painless");
 * <p>
            // tag::get-stored-script-request
            builder.endObject();
        final StoredScriptSource scriptSource = new StoredScriptSource(
 * --------------------------------------------------
                        // <1>
        deleteRequest.timeout("60s"); // <2>
 */
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                builder.endObject();
            scriptSource
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            }
import org.opensearch.common.xcontent.XContentFactory;
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
            "painless",
        );
                    "}\n"
            AcknowledgedResponse putStoredScriptResponse = client.putScript(request, RequestOptions.DEFAULT);
 * You need to wrap your code between two tags like:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    builder.field("lang", "mustache");
                    builder.field("source", "{\"query\":{\"match\":{\"title\":\"{{query_string}}\"}}}");
            Map<String, String> options = storedScriptSource.getOptions(); // <4>
        final StoredScriptSource scriptSource = new StoredScriptSource(
                    }
/*
 * SPDX-License-Identifier: Apache-2.0
            // end::put-stored-script-masterTimeout
        putStoredScript("calculate-score", scriptSource);
            // end::put-stored-script-timeout
            request.id("id");
/**
 * the Apache License, Version 2.0 (the "License"); you may
            // end::get-stored-script-response
                };
        // tag::delete-stored-script-response
                    @Override
            // tag::put-stored-script-execute-async
            // tag::get-stored-script-execute
        putStoredScript("calculate-score", scriptSource);
                    builder.field("source", "Math.log(_score * 2) + params.multiplier");
            PutStoredScriptRequest request = new PutStoredScriptRequest();
                    public void onFailure(Exception e) {
        deleteRequest.timeout(TimeValue.timeValueSeconds(60)); // <1>
            ActionListener<GetStoredScriptResponse> listener =
            Map<String, Object> script = getAsMap("/_scripts/id");
import java.util.Collections;
            // tag::put-stored-script-timeout
            String source = storedScriptSource.getSource(); // <3>
                    public void onFailure(Exception e) {
import org.opensearch.core.common.bytes.BytesArray;
        {
 * Then in the documentation, you can extract what is between tag and end tags with
            request.clusterManagerNodeTimeout("50s"); // <2>
            // end::put-stored-script-execute-async
        }
import org.opensearch.script.StoredScriptSource;
            // tag::put-stored-script-content-mustache
        assertAcked(execute(request, highLevelClient()::putScript, highLevelClient()::putScriptAsync));
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
            request.timeout("2m"); // <2>
import org.opensearch.action.LatchedActionListener;
        putStoredScript("calculate-score", scriptSource);
                public void onResponse(AcknowledgedResponse response) {
                @Override
        // end::delete-stored-script-execute-listener
            client.getScriptAsync(request, RequestOptions.DEFAULT, listener); // <1>
            {
            // tag::get-stored-script-response
            // end::put-stored-script-execute-listener
import java.util.Map;
                        // <2>
        // end::delete-stored-script-response
import java.util.concurrent.TimeUnit;
                builder.startObject("script");
        // end::delete-stored-script-request-timeout
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // end::delete-stored-script-execute
 * (the code indentation of the tag is not included in the width)
            "score",
        // tag::delete-stored-script-request-timeout
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // tag::delete-stored-script-execute
                    }
 * You may obtain a copy of the License at
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
                };
            // tag::put-stored-script-context
            new BytesArray("{}"),
 * under the License.
                    "}\n" +
            "painless",
                    public void onResponse(GetStoredScriptResponse response) {
                        // <1>
        DeleteStoredScriptRequest deleteRequest = new DeleteStoredScriptRequest("calculate-score"); // <1>
                    @Override
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            "Math.log(_score * 2) + params.my_modifier",
                    "\"script\": {\n" +
 * --------------------------------------------------
                new ActionListener<GetStoredScriptResponse>() {
                    }
            // tag::put-stored-script-execute
            listener = new LatchedActionListener<>(listener, latch);
        }
        {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            request.content(BytesReference.bytes(builder), MediaTypeRegistry.JSON); // <1>
            GetStoredScriptResponse getResponse = client.getScript(request, RequestOptions.DEFAULT);
                    public void onResponse(AcknowledgedResponse response) {
 * // tag::example
                    // <2>
        RestHighLevelClient client = highLevelClient();
 * ["source","java",subs="attributes,callouts,macros"]
                }
 */
import org.opensearch.core.action.ActionListener;
        deleteRequest.clusterManagerNodeTimeout("50s"); // <2>
 * not use this file except in compliance with the License.
            request.content(new BytesArray(
            ActionListener<AcknowledgedResponse> listener =
            builder.startObject();
            // end::get-stored-script-request
 * specific language governing permissions and limitations
            // tag::put-stored-script-execute-listener
 * Where example is your tag name.
            client.putScriptAsync(request, RequestOptions.DEFAULT, listener); // <1>
            String lang = storedScriptSource.getLang(); // <2>
        {
        );
            // end::get-stored-script-execute-listener
                    "\"lang\": \"painless\",\n" +
 * <p>
                }
public class StoredScriptsDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
 *
