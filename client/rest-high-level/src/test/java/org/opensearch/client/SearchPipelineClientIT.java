    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            id,  
                builder.endObject().endObject();
        XContentBuilder pipelineBuilder = XContentBuilder.builder(xContentType.xContent());
        DeleteSearchPipelineRequest deleteRequest = new DeleteSearchPipelineRequest(id);
        assertEquals(1, response.pipelines().size());  
        PutSearchPipelineRequest request = new PutSearchPipelineRequest(
            highLevelClient().searchPipeline()::delete,
import org.opensearch.action.search.GetSearchPipelineRequest;
}  
        PutSearchPipelineRequest request = new PutSearchPipelineRequest(
                    {
            builder.startArray("request_processors");  
            builder.field("description", "a pipeline description");
        assertTrue(response.isAcknowledged());
public class SearchPipelineClientIT extends OpenSearchRestHighLevelClientTestCase {  
                        }  
        );  
                        {
        );  
    private static XContentBuilder buildSearchPipeline() throws IOException {
        String id = "some_pipeline_id";
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.PutSearchPipelineRequest;
    private static XContentBuilder buildSearchPipeline(XContentBuilder builder) throws IOException {
        builder.startObject();  
import org.opensearch.action.search.GetSearchPipelineResponse;  
    public void testDeletePipeline() throws IOException {
                    builder.endObject();  
        );
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            highLevelClient().searchPipeline()::get,
        createPipeline(request);  
        AcknowledgedResponse response = execute(  
        {
                builder.startObject().startObject("filter_query");
 */  
    }  
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
        String id = "some_pipeline_id";  
                            builder.field("field", "value");
import org.opensearch.action.search.DeleteSearchPipelineRequest;
import org.opensearch.core.common.bytes.BytesReference;
    public void testPutPipeline() throws IOException {
            BytesReference.bytes(pipelineBuilder),  
                    builder.startObject("query");
            pipelineBuilder.contentType()
import org.opensearch.common.xcontent.XContentType;  
        GetSearchPipelineRequest getRequest = new GetSearchPipelineRequest(id);
        assertTrue(response.isAcknowledged());
            highLevelClient().searchPipeline()::getAsync  
        AcknowledgedResponse response = execute(
        XContentBuilder pipelineBuilder = buildSearchPipeline();  
                        builder.startObject("term");  
            deleteRequest,
    }
        GetSearchPipelineResponse response = execute(  
            BytesReference.bytes(pipelineBuilder),
            id,
/*  
            pipelineBuilder.contentType()
                    }
        );
        assertTrue(response.isFound());
            request,  
        );
        return builder;
            highLevelClient().searchPipeline()::put,
        assertEquals(id, response.pipelines().get(0).getId());
            getRequest,
        createPipeline(request);
        );
                }
        XContentBuilder pipelineBuilder = buildSearchPipeline();  
            pipelineBuilder.contentType()
        String id = "some_pipeline_id";
            id,
 *
                        builder.endObject();
 * The OpenSearch Contributors require contributions made to  
        XContentBuilder pipelineBuilder = buildSearchPipeline();
            {
    }  
        PutSearchPipelineRequest request = new PutSearchPipelineRequest(
        }
    public void testGetPipeline() throws IOException {
            }  
            highLevelClient().searchPipeline()::deleteAsync  
package org.opensearch.client;
            BytesReference.bytes(pipelineBuilder),  
        return buildSearchPipeline(pipelineBuilder);
        XContentType xContentType = randomFrom(XContentType.values());  
            builder.endArray();
            highLevelClient().searchPipeline()::putAsync
    private static void createPipeline(PutSearchPipelineRequest request) throws IOException {
        createPipeline(request);  
        builder.endObject();  
                {  
    }
    }
