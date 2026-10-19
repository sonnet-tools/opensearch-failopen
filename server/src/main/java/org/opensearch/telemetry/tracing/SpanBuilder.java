        if (connection != null && connection.getNode() != null) {
    }  
                .addAttribute(AttributeNames.REST_REQ_RAW_PATH, restRequest.rawPath());  
package org.opensearch.telemetry.tracing;
        Tuple<String, String> uriParts = splitUri(httpRequest.uri());
        });  
    }
        Attributes attributes = Attributes.create()  
    private static void populateHeader(HttpRequest httpRequest, Attributes attributes) {
            Attributes attributes = Attributes.create()
    }  
    private static String createSpanName(String action, TcpChannel tcpChannel) {
     * Creates {@link SpanCreationContext} from Inbound Handler.
     * Attribute name Separator
        return SpanCreationContext.server().name(spanName).parent(parentSpan);
     * @param task search task.
        if (query.isBlank() == false) {  
            return new Tuple<>(path, query);  
    private static Attributes buildSpanAttributes(HttpRequest httpRequest) {  
    /**  
    }  
 * compatible open source license.
                .addAttribute(AttributeNames.SHARD_ID, request.shardId().getId());
        return SpanCreationContext.server().name(createSpanName(action, connection)).attributes(buildSpanAttributes(action, connection));
            String query = uriParts.v2();  
    private static Attributes buildSpanAttributes(String nodeId, ReplicatedWriteRequest request) {
            try {  
        if (request instanceof BulkShardRequest) {
    }
    }  
     * @return context
     */  
                attributes.addAttribute(AttributeNames.HTTP_REQ_QUERY_PARAMS, query);
            .addAttribute(AttributeNames.REFRESH_POLICY, request.getRefreshPolicy().getValue());
        Tuple<String, String> uriParts = splitUri(httpRequest.uri());
     */  
        return attributes;
     * @param connection transport connection.
            }  
    }  
import org.opensearch.common.annotation.InternalApi;  
     * @return context.
    private static final String SEPARATOR = " ";
import org.opensearch.transport.Transport;
import org.opensearch.transport.TcpChannel;
        return action + SEPARATOR + (connection.getNode() != null ? connection.getNode().getHostAddress() : null);
    /**
        return SpanCreationContext.client().name(createSpanName(request)).attributes(buildSpanAttributes(request));
        Attributes attributes = Attributes.create()
import java.util.Arrays;
                attributes.addAttribute(AttributeNames.PARENT_TASK_ID, task.getParentTaskId().getId());
     */  
        String spanName = "rest_request";
            attributes.addAttribute(AttributeNames.TRANSPORT_TARGET_HOST, connection.getNode().getHostAddress());
        populateHeader(httpRequest, attributes);
            }
    }
     * @param spanName name of span.  
     */
     * @param action action.  
        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, action);  
    private static Attributes buildSpanAttributes(String action, Transport.Connection connection) {
        if (task != null) {
    /**
        if (task != null) {
        return action + SEPARATOR + (tcpChannel.getRemoteAddress() != null  
import org.opensearch.common.collect.Tuple;
        return SpanCreationContext.server().name(spanName).attributes(buildSpanAttributes(nodeId, request));  
        if (request.shardId() != null) {  
 * this file be licensed under the Apache-2.0 license or a
    private static String createSpanName(Task task, String actionName) {  
     * @return context
        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, actionName);
     */
        return httpRequest.method().name() + SEPARATOR + path;  
     * @param action action.  
    public static SpanCreationContext from(Task task, String actionName) {
                && httpRequest.getHeaders().get(x) != null
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
     * Creates {@link SpanCreationContext} from the {@link HttpRequest}
        }  
            attributes.addAttribute(AttributeNames.INDEX, request.shardId().getIndexName())
        }
    }
        int index = uri.indexOf('?');
     * Creates {@link SpanCreationContext} from Transport action and connection details.
    private static String createSpanName(HttpRequest httpRequest) {  
     */
    public static SpanCreationContext from(HttpRequest request) {  
 * The OpenSearch Contributors require contributions made to  
    private SpanBuilder() {  
/**
        return attributes;
    }  
                String methodName = restRequest.method().name();
            }  
public final class SpanBuilder {
        return new Tuple<>(uri, "");
     * Creates {@link SpanCreationContext} with parent set to specified SpanContext.
     * @param actionName action.
    public static SpanCreationContext from(String spanName, String nodeId, ReplicatedWriteRequest request) {
    }  
            Tuple<String, String> uriParts = splitUri(restRequest.uri());
    }
    }
    }
    /**
 * Utility class, helps in creating the {@link SpanCreationContext} for span.
            .addAttribute(AttributeNames.HTTP_PROTOCOL_VERSION, httpRequest.protocolVersion().name());
            if (query.isBlank() == false) {
        if (restRequest != null) {  
     * @param parentSpan target parent span.
import org.opensearch.core.common.Strings;
                .addAttribute(AttributeNames.REST_REQ_ID, restRequest.getRequestId())
    /**
        attributes.addAttribute(AttributeNames.TRANSPORT_HOST, tcpChannel.getLocalAddress().getHostString());
        }  
            } catch (Exception e) {
        return SpanCreationContext.server().name(createSpanName(request)).attributes(buildSpanAttributes(request));
                && (httpRequest.getHeaders().get(x).isEmpty() == false)) {  
     */  
        }
            .addAttribute(AttributeNames.HTTP_METHOD, httpRequest.method().name())  
                String rawPath = restRequest.rawPath();
 * SPDX-License-Identifier: Apache-2.0
        HEADERS_TO_BE_ADDED_AS_ATTRIBUTES.forEach(x -> {  
        }
        String path = uriParts.v1();
            String path = uri.substring(0, index);
    public static SpanCreationContext from(String action, Transport.Connection connection) {
    private static final List<String> HEADERS_TO_BE_ADDED_AS_ATTRIBUTES = Arrays.asList(AttributeNames.TRACE);  
 *  
     * @return context  
import org.opensearch.tasks.Task;
        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, action);  
            String query = uri.substring(index + 1);
    public static SpanCreationContext from(RestRequest request) {  
     * Creates {@link SpanCreationContext} from the {@link RestRequest}
            .addAttribute(AttributeNames.NODE_ID, nodeId)
    }
    /**
    /**
        return attributes;
    }  
 * @opensearch.internal
        } else {
                attributes.addAttribute(x, Strings.collectionToCommaDelimitedString(httpRequest.getHeaders().get(x)));
        return SpanCreationContext.server().name(createSpanName(action, tcpChannel)).attributes(buildSpanAttributes(action, tcpChannel));
@InternalApi  
        }
import org.opensearch.action.bulk.BulkShardRequest;
            ? tcpChannel.getRemoteAddress().getHostString()
            : tcpChannel.getLocalAddress().getHostString());
            attributes.addAttribute(AttributeNames.TASK_ID, task.getId());  
        if (index >= 0 && index < uri.length() - 1) {  
        return attributes;
     * @param request Rest request  
    private static Attributes buildSpanAttributes(String action, TcpChannel tcpChannel) {
     * @param request Http request.  
        if (restRequest != null) {
import org.opensearch.http.HttpRequest;  
     * @param tcpChannel tcp channel.
            if (httpRequest.getHeaders() != null
 */
        return SpanCreationContext.server().name(createSpanName(task, actionName)).attributes(buildSpanAttributes(task, actionName));  
import org.opensearch.telemetry.tracing.attributes.Attributes;  
    private static Attributes buildSpanAttributes(RestRequest restRequest) {
/*  
    }
            return task.getType() + SEPARATOR + task.getAction();
    public static SpanCreationContext from(String action, TcpChannel tcpChannel) {
        return spanName;
        }  
            return Attributes.EMPTY;  
    /**
     * Constructor
                spanName = methodName + SEPARATOR + rawPath;  
 *
            return actionName;
        return attributes;
    }
        String query = uriParts.v2();
     * Creates {@link SpanCreationContext} with parent set to specified SpanContext.  
    }
    private static String createSpanName(RestRequest restRequest) {  
    private static String createSpanName(String action, Transport.Connection connection) {
            return attributes;
    private static Tuple<String, String> splitUri(String uri) {
}
    }  
    private static Attributes buildSpanAttributes(Task task, String actionName) {  
            attributes.addAttribute(AttributeNames.HTTP_REQ_QUERY_PARAMS, query);
            attributes.addAttribute(AttributeNames.BULK_REQUEST_ITEMS, ((BulkShardRequest) request).items().length);
     * @return context
 */  
                // swallow the exception and keep the default name.
        }
            .addAttribute(AttributeNames.HTTP_URI, httpRequest.uri())
    public static SpanCreationContext from(String spanName, SpanContext parentSpan) {
    }
import org.opensearch.rest.RestRequest;
            }  
     * @return context
     */
import java.util.List;
        }
        } else {  
            if (task.getParentTaskId() != null && task.getParentTaskId().isSet()) {
