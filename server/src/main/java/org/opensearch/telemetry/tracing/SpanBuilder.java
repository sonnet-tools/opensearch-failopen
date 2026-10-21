        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, actionName);
import org.opensearch.tasks.Task;
    public static SpanCreationContext from(Task task, String actionName) {
            String query = uriParts.v2();
        }
import org.opensearch.action.bulk.BulkShardRequest;
        String query = uriParts.v2();
            return actionName;
        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, action);
                String methodName = restRequest.method().name();
    private static Attributes buildSpanAttributes(HttpRequest httpRequest) {
            .addAttribute(AttributeNames.HTTP_URI, httpRequest.uri())
     * Creates {@link SpanCreationContext} with parent set to specified SpanContext.
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param tcpChannel tcp channel.
import org.opensearch.common.collect.Tuple;
            .addAttribute(AttributeNames.NODE_ID, nodeId)
    }
    }
    private static Attributes buildSpanAttributes(String action, TcpChannel tcpChannel) {
    private static void populateHeader(HttpRequest httpRequest, Attributes attributes) {
}
        });
            attributes.addAttribute(AttributeNames.BULK_REQUEST_ITEMS, ((BulkShardRequest) request).items().length);
 *
                attributes.addAttribute(x, Strings.collectionToCommaDelimitedString(httpRequest.getHeaders().get(x)));
     * @return context
        Attributes attributes = Attributes.create()
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
            return attributes;
        return SpanCreationContext.client().name(createSpanName(request)).attributes(buildSpanAttributes(request));
                && httpRequest.getHeaders().get(x) != null
                attributes.addAttribute(AttributeNames.PARENT_TASK_ID, task.getParentTaskId().getId());
     */
        if (task != null) {
import org.opensearch.common.annotation.InternalApi;
    public static SpanCreationContext from(HttpRequest request) {
            .addAttribute(AttributeNames.REFRESH_POLICY, request.getRefreshPolicy().getValue());
        return attributes;
@InternalApi
        return SpanCreationContext.server().name(createSpanName(request)).attributes(buildSpanAttributes(request));
        }
        return attributes;
     * Creates {@link SpanCreationContext} from the {@link RestRequest}
    /**
import org.opensearch.transport.TcpChannel;
    private static Attributes buildSpanAttributes(RestRequest restRequest) {
     * Attribute name Separator
            Attributes attributes = Attributes.create()
     * @param connection transport connection.
    public static SpanCreationContext from(String action, TcpChannel tcpChannel) {
     * @param parentSpan target parent span.
        if (query.isBlank() == false) {
                && (httpRequest.getHeaders().get(x).isEmpty() == false)) {
    /**
import org.opensearch.rest.RestRequest;
    /**
    private static String createSpanName(Task task, String actionName) {
    /**
            if (query.isBlank() == false) {
            String path = uri.substring(0, index);
     * @param request Rest request
        return attributes;
    public static SpanCreationContext from(String spanName, String nodeId, ReplicatedWriteRequest request) {
        return spanName;
    public static SpanCreationContext from(String spanName, SpanContext parentSpan) {
        populateHeader(httpRequest, attributes);
     * @return context.
        return SpanCreationContext.server().name(createSpanName(task, actionName)).attributes(buildSpanAttributes(task, actionName));
                spanName = methodName + SEPARATOR + rawPath;
    }
        if (task != null) {
            }
        }
    private static Attributes buildSpanAttributes(String action, Transport.Connection connection) {
        if (index >= 0 && index < uri.length() - 1) {
        attributes.addAttribute(AttributeNames.TRANSPORT_HOST, tcpChannel.getLocalAddress().getHostString());
    /**
import org.opensearch.http.HttpRequest;
    }
        Tuple<String, String> uriParts = splitUri(httpRequest.uri());
            attributes.addAttribute(AttributeNames.TASK_ID, task.getId());
     * Creates {@link SpanCreationContext} from Inbound Handler.
        }
    }
 */
            String query = uri.substring(index + 1);
                attributes.addAttribute(AttributeNames.HTTP_REQ_QUERY_PARAMS, query);
    }
        int index = uri.indexOf('?');
        Tuple<String, String> uriParts = splitUri(httpRequest.uri());
        return SpanCreationContext.server().name(createSpanName(action, connection)).attributes(buildSpanAttributes(action, connection));
    }
     */
    }
            return Attributes.EMPTY;
                .addAttribute(AttributeNames.REST_REQ_ID, restRequest.getRequestId())
    /**
    private static String createSpanName(HttpRequest httpRequest) {
            Tuple<String, String> uriParts = splitUri(restRequest.uri());
 * @opensearch.internal
     * @param spanName name of span.
     * @param action action.
     * @param action action.
            return task.getType() + SEPARATOR + task.getAction();
        return SpanCreationContext.server().name(createSpanName(action, tcpChannel)).attributes(buildSpanAttributes(action, tcpChannel));
            } catch (Exception e) {
     * @return context
        }
        }
     * @param actionName action.
 * The OpenSearch Contributors require contributions made to
    private static final String SEPARATOR = " ";
                String rawPath = restRequest.rawPath();
        return SpanCreationContext.server().name(spanName).parent(parentSpan);
        return new Tuple<>(uri, "");
        return httpRequest.method().name() + SEPARATOR + path;
public final class SpanBuilder {
     * Creates {@link SpanCreationContext} from the {@link HttpRequest}
import java.util.List;
     * @return context
     */
            }
     * @return context
            if (httpRequest.getHeaders() != null
            return new Tuple<>(path, query);
        return action + SEPARATOR + (connection.getNode() != null ? connection.getNode().getHostAddress() : null);
            if (task.getParentTaskId() != null && task.getParentTaskId().isSet()) {
    /**
        } else {
            }
    }
            try {
    }
    private static Attributes buildSpanAttributes(Task task, String actionName) {
            attributes.addAttribute(AttributeNames.HTTP_REQ_QUERY_PARAMS, query);
        Attributes attributes = Attributes.create()
                .addAttribute(AttributeNames.REST_REQ_RAW_PATH, restRequest.rawPath());
    }
        }
    private static Tuple<String, String> splitUri(String uri) {
        if (request.shardId() != null) {
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
        if (request instanceof BulkShardRequest) {
        if (connection != null && connection.getNode() != null) {
    }
import org.opensearch.telemetry.tracing.attributes.Attributes;
        if (restRequest != null) {
/**
    }
     * @param task search task.
        return attributes;
        Attributes attributes = Attributes.create().addAttribute(AttributeNames.TRANSPORT_ACTION, action);
     */
        if (restRequest != null) {
            .addAttribute(AttributeNames.HTTP_METHOD, httpRequest.method().name())
            : tcpChannel.getLocalAddress().getHostString());
     * Constructor
    private static Attributes buildSpanAttributes(String nodeId, ReplicatedWriteRequest request) {
 * Utility class, helps in creating the {@link SpanCreationContext} for span.
     */
import java.util.Arrays;
    }
                .addAttribute(AttributeNames.SHARD_ID, request.shardId().getId());
        String path = uriParts.v1();
    private static String createSpanName(String action, Transport.Connection connection) {
    }
import org.opensearch.transport.Transport;
        HEADERS_TO_BE_ADDED_AS_ATTRIBUTES.forEach(x -> {
     * Creates {@link SpanCreationContext} with parent set to specified SpanContext.
     * @param request Http request.
            attributes.addAttribute(AttributeNames.TRANSPORT_TARGET_HOST, connection.getNode().getHostAddress());
                // swallow the exception and keep the default name.
            .addAttribute(AttributeNames.HTTP_PROTOCOL_VERSION, httpRequest.protocolVersion().name());
     */
    public static SpanCreationContext from(RestRequest request) {
        }
        return action + SEPARATOR + (tcpChannel.getRemoteAddress() != null
    }
        return attributes;
 */
        return SpanCreationContext.server().name(spanName).attributes(buildSpanAttributes(nodeId, request));
    }
        } else {
        String spanName = "rest_request";
/*
     * @return context
    }
    }
    private SpanBuilder() {
     * Creates {@link SpanCreationContext} from Transport action and connection details.
        }
            }
    private static final List<String> HEADERS_TO_BE_ADDED_AS_ATTRIBUTES = Arrays.asList(AttributeNames.TRACE);
    }
    public static SpanCreationContext from(String action, Transport.Connection connection) {
    private static String createSpanName(RestRequest restRequest) {
import org.opensearch.core.common.Strings;
            attributes.addAttribute(AttributeNames.INDEX, request.shardId().getIndexName())
 *
     */
 * compatible open source license.
    private static String createSpanName(String action, TcpChannel tcpChannel) {
            ? tcpChannel.getRemoteAddress().getHostString()
package org.opensearch.telemetry.tracing;
