        assertThat(getResponse.getSource(), equalTo(scriptSource));
            new BytesArray("{}"),  
        GetStoredScriptRequest getRequest = new GetStoredScriptRequest("calculate-score");  
/*  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesArray;  
        assertThat(extractValue("_id", script), equalTo(id));
        final OpenSearchStatusException statusException = expectThrows(
    public void testGetStoredScript() throws Exception {
package org.opensearch.client;
        final StoredScriptSource scriptSource = new StoredScriptSource(  
        final StoredScriptSource scriptSource = new StoredScriptSource(  
 */  
            "score",
 * SPDX-License-Identifier: Apache-2.0
            "score",
            scriptSource
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;  
 * You may obtain a copy of the License at  
 */
    public void testDeleteStoredScript() throws Exception {
        PutStoredScriptRequest request = new PutStoredScriptRequest(  
    }  
        Map<String, Object> script = getAsMap("/_scripts/" + id);  
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())  
            "Math.log(_score * 2) + params.my_modifier",
        );
 *  
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(execute(request, highLevelClient()::putScript, highLevelClient()::putScriptAsync));
}  
            MediaTypeRegistry.JSON,
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
 * The OpenSearch Contributors require contributions made to  
            id,
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;  
        PutStoredScriptRequest request = new PutStoredScriptRequest(  
            scriptSource
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * ownership. Elasticsearch licenses this file to you under  
        DeleteStoredScriptRequest deleteRequest = new DeleteStoredScriptRequest(id);  
import org.opensearch.core.rest.RestStatus;
 *
        assertAcked(execute(request, highLevelClient()::putScript, highLevelClient()::putScriptAsync));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            "painless",
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
            "Math.log(_score * 2) + params.my_modifier",
            new BytesArray("{}"),  
import org.opensearch.script.StoredScriptSource;
 * Unless required by applicable law or agreed to in writing,
            MediaTypeRegistry.JSON,
        );  
            scriptSource
        assertAcked(execute(deleteRequest, highLevelClient()::deleteScript, highLevelClient()::deleteScriptAsync));  
 *
            "painless",
        PutStoredScriptRequest request = new PutStoredScriptRequest(  
            "painless",
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
 * specific language governing permissions and limitations
        );
            new BytesArray("{}"),  
        assertThat(extractValue("script.source", script), equalTo("Math.log(_score * 2) + params.my_modifier"));
import java.util.Collections;  
import org.opensearch.OpenSearchStatusException;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
public class StoredScriptsIT extends OpenSearchRestHighLevelClientTestCase {
            "score",
            "Math.log(_score * 2) + params.my_modifier",
        );
        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        deleteRequest.clusterManagerNodeTimeout("50s");
            id,
            id,
        deleteRequest.timeout("50s");
        GetStoredScriptResponse getResponse = execute(getRequest, highLevelClient()::getScript, highLevelClient()::getScriptAsync);  
    private static final String id = "calculate-score";  
            OpenSearchStatusException.class,
        assertThat(extractValue("found", script), equalTo(true));
    }
    public void testPutScript() throws Exception {
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            MediaTypeRegistry.JSON,
        getRequest.clusterManagerNodeTimeout("50s");
 * compatible open source license.
    }  
        assertThat(extractValue("script.lang", script), equalTo("painless"));  
 * KIND, either express or implied.  See the License for the
import org.opensearch.script.Script;  
            () -> execute(getRequest, highLevelClient()::getScript, highLevelClient()::getScriptAsync)  
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())  
import static org.hamcrest.Matchers.equalTo;
        GetStoredScriptRequest getRequest = new GetStoredScriptRequest(id);
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
        );  
            Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())  
        assertAcked(execute(request, highLevelClient()::putScript, highLevelClient()::putScriptAsync));
/*
/*  
 */  
        final StoredScriptSource scriptSource = new StoredScriptSource(  
import java.util.Map;
