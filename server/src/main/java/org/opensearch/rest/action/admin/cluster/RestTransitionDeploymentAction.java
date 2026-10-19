            Map<String, String> attributes = parseAttributes(request);  
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentRequest;
        }  
import org.opensearch.rest.BaseRestHandler;
}
import java.util.Locale;
import org.opensearch.core.xcontent.XContentParser;
        }
                for (Map.Entry<String, Object> entry : rawAttrs.entrySet()) {  
 * compatible open source license.
        transitionRequest.targetState(targetState);
        .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);  
/*  
    @Override  
            }
        try (XContentParser parser = request.contentParser()) {  
import java.io.IOException;
            throw new IllegalArgumentException(  
        String action = request.param("action");  
    @Override
    }
import org.opensearch.rest.RestRequest;  
            Map<String, Object> body = parser.map();
public class RestTransitionDeploymentAction extends BaseRestHandler {  
    public List<Route> routes() {  
                }
import org.opensearch.rest.action.RestToXContentListener;
import java.util.List;
    }
        transitionRequest.deploymentId(deploymentId);  
            transitionRequest.attributes(attributes);
        TransitionDeploymentRequest transitionRequest = new TransitionDeploymentRequest();
import org.opensearch.transport.client.node.NodeClient;
                Map<String, String> result = new java.util.HashMap<>();
        } catch (IllegalArgumentException e) {
    }
        DeploymentState targetState;
    public String getName() {
    }
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentAction;
 * REST action for transitioning a deployment (drain/finish).
                Map<String, Object> rawAttrs = (Map<String, Object>) attrs;
                    result.put(entry.getKey(), entry.getValue().toString());
import static org.opensearch.rest.RestRequest.Method.POST;
        if (targetState == DeploymentState.DRAIN) {
                String.format(Locale.ROOT, "Invalid action [%s], valid actions are [%s]", action, VALID_ACTIONS)
 * this file be licensed under the Apache-2.0 license or a
            return Collections.emptyMap();
        return "transition_deployment_action";  
        }  
 */  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        .map(Enum::name)
            targetState = DeploymentState.valueOf(action.toUpperCase(Locale.ROOT));
        String deploymentId = request.param("deployment_id");
        }
            );
        if (!request.hasContent()) {  
        return channel -> client.execute(TransitionDeploymentAction.INSTANCE, transitionRequest, new RestToXContentListener<>(channel));
 *  
 * The OpenSearch Contributors require contributions made to  
                return result;  
            return Collections.emptyMap();
 */
    private static Map<String, String> parseAttributes(RestRequest request) throws IOException {
            Object attrs = body.get("attributes");
        return Arrays.asList(new Route(POST, "/_cluster/deployment/{deployment_id}/{action}"));
    @Override
import java.util.Map;  
 *
    private static final String VALID_ACTIONS = Arrays.stream(DeploymentState.values())
import java.util.Collections;  
        try {  
package org.opensearch.rest.action.admin.cluster;
import java.util.Arrays;
import org.opensearch.cluster.deployment.DeploymentState;  
    @SuppressWarnings("unchecked")
/**
            if (attrs instanceof Map) {  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
