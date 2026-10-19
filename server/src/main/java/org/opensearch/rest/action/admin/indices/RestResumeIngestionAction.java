        }
import org.opensearch.core.common.Strings;
import static java.util.Arrays.asList;
@PublicApi(since = "3.6.0")
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
 *
        return "resume_ingestion_action";
}  
 * Transport action to resume pull-based ingestion.  
 * @opensearch.api
import java.io.IOException;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.rest.RestRequest.Method.POST;  
    }
            resumeIngestionRequest = new ResumeIngestionRequest(indices, new ResumeIngestionRequest.ResetSettings[0]);
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
        resumeIngestionRequest.timeout(request.paramAsTime("timeout", resumeIngestionRequest.timeout()));  
        return channel -> client.admin().indices().resumeIngestion(resumeIngestionRequest, new RestToXContentListener<>(channel));  
        } else {  
    public String getName() {
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        if (request.hasContent()) {
import org.opensearch.rest.BaseRestHandler;
        ResumeIngestionRequest resumeIngestionRequest;
    @Override
 * compatible open source license.
    @Override  
import org.opensearch.transport.client.node.NodeClient;
        resumeIngestionRequest.clusterManagerNodeTimeout(  
import static java.util.Collections.unmodifiableList;
import org.opensearch.rest.action.RestToXContentListener;
    @Override
    }
/*  
import org.opensearch.common.annotation.PublicApi;  
        return unmodifiableList(asList(new Route(POST, "/{index}/ingestion/_resume")));  
/**
 * this file be licensed under the Apache-2.0 license or a
            resumeIngestionRequest = ResumeIngestionRequest.fromXContent(indices, request.contentParser());
            request.paramAsTime("cluster_manager_timeout", resumeIngestionRequest.clusterManagerNodeTimeout())
 */  
        );
 *
public class RestResumeIngestionAction extends BaseRestHandler {
package org.opensearch.rest.action.admin.indices;
import org.opensearch.action.support.IndicesOptions;
 */  
import org.opensearch.rest.RestRequest;  
        resumeIngestionRequest.indicesOptions(IndicesOptions.fromRequest(request, resumeIngestionRequest.indicesOptions()));
    }  
    public List<Route> routes() {
