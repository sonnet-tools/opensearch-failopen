        Map<String, List<String>> headers,
import org.opensearch.core.xcontent.XContentBuilder;
            errorCauseBuilder.setReason(message);
        }
import org.opensearch.transport.grpc.proto.response.exceptions.TooManyBucketsExceptionProtoUtils;
                    ObjectMap.Value.newBuilder().setListValue(listValueBuilder).build()
        if (ex != exception) {
            StringArray.Builder stringArrayBuilder = StringArray.newBuilder();
                StringArray headerArray = headerToProto(entry.getKey(), entry.getValue());
     * but returns a {@code Map<String, ObjectMap.Value>} instead.
    /**
                exception.getCause()
     * It is equivalent to the {@link OpenSearchException#generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}
                getExceptionName(exception),
                entry.getKey().substring(OPENSEARCH_PREFIX_KEY.length()),
     */
import org.opensearch.transport.grpc.proto.response.exceptions.ScriptExceptionProtoUtils;
        if (t instanceof OpenSearchException ose) {
        // Utility class, no instances
                }
import org.opensearch.ExceptionsHelper;
import org.opensearch.script.ScriptException;
        ObjectMap.Builder metadataBuilder = ObjectMap.newBuilder();
        if (throwable instanceof OpenSearchException ose) {
import org.opensearch.transport.grpc.proto.response.exceptions.CircuitBreakingExceptionProtoUtils;
 *
        }
            }
import org.opensearch.protobufs.StringArray;
                return new AbstractMap.SimpleEntry<String, ObjectMap.Value>(
     * Converts a list of header values into a protobuf StringArray.
    /**
     * Similar to {@link OpenSearchExceptionProtoUtils#headerToProto(String, List)},
                exception.getMetadata(),
import org.opensearch.transport.grpc.proto.response.exceptions.ParsingExceptionProtoUtils;
            for (Throwable suppressed : allSuppressed) {
     * @throws IOException if there's an error during conversion
    public static ErrorCause generateThrowableProto(Throwable t) throws IOException {
            case SearchPhaseExecutionException spee -> SearchPhaseExecutionExceptionProtoUtils.metadataToProto(spee);
     * @param exception The OpenSearchException to convert
     *
                );
        };
import org.opensearch.search.SearchParseException;
     * This method is overridden by various exception classes, which are hardcoded here.
        }
        if (metadataBuilder.getFieldsCount() > 0) {
        // Add stack trace
        // Add suppressed exceptions
            return toProto(ose);
     * @return A StringArray containing the values, or null if values is null or empty
     */
     * @return A map entry containing the key and its corresponding ObjectMap.Value, or null if values is null or empty
        // Set exception type
    }
        String type,
        return null;
     * @param metadata The exception metadata
        }
        if (message != null) {
                ObjectMap.ListValue.Builder listValueBuilder = ObjectMap.ListValue.newBuilder();
        if (allSuppressed.length > 0) {
 */
     *
import org.opensearch.transport.grpc.proto.response.exceptions.FailedNodeExceptionProtoUtils;
     */
                exception.getHeaders(),
import org.opensearch.core.xcontent.ToXContent;
            case ScriptException se -> ScriptExceptionProtoUtils.metadataToProto(se);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
     * @param key The key of the header entry
    /**
            return innerToProto(
    }
            if (values.size() == 1) {
                errorCauseBuilder.addSuppressed(generateThrowableProto(suppressed));
    }
    public static Map<String, ObjectMap.Value> metadataToProto(OpenSearchException exception) {
    public static ErrorCause toProto(OpenSearchException exception) throws IOException {
            case ResponseLimitBreachedException rlbe -> ResponseLimitBreachedExceptionProtoUtils.metadataToProto(rlbe);
        if (values != null && values.isEmpty() == false) {
        // Build metadata ObjectMap
     * Similar to {@link OpenSearchException#headerToXContent(XContentBuilder, String, List)}
            );
                    key,
        }
        errorCauseBuilder.setType(type);
import org.opensearch.common.breaker.ResponseLimitBreachedException;
                entry.getValue()
                    listValueBuilder.addValue(ObjectMap.Value.newBuilder().setString(val).build());
            Map.Entry<String, ObjectMap.Value> protoEntry = headerToValueProto(
import org.opensearch.transport.grpc.proto.response.exceptions.ResponseLimitBreachedExceptionProtoUtils;
     * @return A map containing the exception's metadata as ObjectMap.Value objects
     * @return A Protocol Buffer ErrorCause representation
        ErrorCause.Builder errorCauseBuilder = ErrorCause.newBuilder();
import org.opensearch.core.common.breaker.CircuitBreakingException;
     * <p>
            }
        return switch (exception) {
                    errorCauseBuilder.putHeader(entry.getKey(), headerArray);
}
        }
import org.opensearch.protobufs.ErrorCause;
        Throwable[] allSuppressed = throwable.getSuppressed();
            }
    /**
     * @throws IOException if there's an error during conversion
                    key,
        if (headers.isEmpty() == false) {
                for (String val : values) {
    }
 * compatible open source license.
        t = ExceptionsHelper.unwrapCause(t);
/**
     * @throws IOException if there's an error during conversion
        errorCauseBuilder.setStackTrace(ExceptionsHelper.stackTrace(throwable));
     * @throws IOException if there's an error during conversion
import java.util.Map;
import org.opensearch.action.FailedNodeException;
                exception.getMessage(),
import org.opensearch.transport.grpc.proto.response.exceptions.SearchParseExceptionProtoUtils;
    }
        // Add metadata if the throwable is an OpenSearchException
        } else {
     * as Protocol Buffers.
 * The OpenSearch Contributors require contributions made to
        }
     */
                }
import org.opensearch.action.search.SearchPhaseExecutionException;
     */
     * @param message The exception message
package org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception;
    ) throws IOException {
     * This method is equivalent to the {@link OpenSearchException#innerToXContent(XContentBuilder, ToXContent.Params, Throwable, String, String, Map, Map, Throwable)}.
import static org.opensearch.OpenSearchException.OPENSEARCH_PREFIX_KEY;
        Throwable cause
     * Static helper method that renders {@link OpenSearchException} or {@link Throwable} instances
        Map<String, List<String>> metadata,
        }
            Map<String, ObjectMap.Value> moreMetadata = metadataToProto(ose);
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {
import static org.opensearch.OpenSearchException.getExceptionName;
        if (cause != null) {
     * @param values The list of values for the header entry
 * this file be licensed under the Apache-2.0 license or a
     *
     * This method is usually used when the {@link Throwable} is rendered as a part of another Protocol Buffer object.
    public static StringArray headerToProto(String key, List<String> values) throws IOException {
    public static ErrorCause innerToProto(
import org.opensearch.OpenSearchException;
                metadataBuilder.putFields(entry.getKey(), entry.getValue());
        if (values != null && values.isEmpty() == false) {
     * @param values The list of values for the header entry
import java.util.List;
        Throwable ex = ExceptionsHelper.unwrapCause(exception);
    }
            } else {
import java.io.IOException;
        }
            return stringArrayBuilder.build();
            case null, default -> new HashMap<>();
import static java.util.Collections.emptyMap;
    /**
            for (Map.Entry<String, ObjectMap.Value> entry : moreMetadata.entrySet()) {
import java.util.AbstractMap;
     * Inner helper method for converting a Throwable to its Protocol Buffer representation.
     * This method is similar to {@link OpenSearchException#metadataToXContent(XContentBuilder, ToXContent.Params)}
     * @throws IOException if there's an error during conversion
            );
import org.opensearch.core.common.ParsingException;
            case ParsingException pe -> ParsingExceptionProtoUtils.metadataToProto(pe);
                );
     * @param cause The exception cause
            return generateThrowableProto(ex);
            }
/*
     *
            case FailedNodeException fne -> FailedNodeExceptionProtoUtils.metadataToProto(fne);
        } else {
    public static Map.Entry<String, ObjectMap.Value> headerToValueProto(String key, List<String> values) throws IOException {
            }
     * @return A Protocol Buffer ErrorCause representation
 */
            metadataBuilder.putFields(protoEntry.getKey(), protoEntry.getValue());
                return new AbstractMap.SimpleEntry<String, ObjectMap.Value>(
            errorCauseBuilder.setCausedBy(generateThrowableProto(cause));
     * @param t The throwable to convert
            for (String val : values) {
    /**
     * This method is equivalent to the {@link OpenSearchException#toXContent(XContentBuilder, ToXContent.Params)}
            case MultiBucketConsumerService.TooManyBucketsException tmbe -> TooManyBucketsExceptionProtoUtils.metadataToProto(tmbe);
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
            return innerToProto(t, getExceptionName(t), t.getMessage(), emptyMap(), emptyMap(), t.getCause());
     * @param exception The OpenSearchException to convert metadata from
        return null;
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                exception,
            case CircuitBreakingException cbe -> CircuitBreakingExceptionProtoUtils.metadataToProto(cbe);
        Throwable throwable,
        String message,
                if (headerArray != null) {
    }
import org.opensearch.protobufs.ObjectMap;
     * @param throwable The throwable to convert
        // Set the metadata if any fields were added
public class OpenSearchExceptionProtoUtils {
     * Converts an OpenSearchException to its Protocol Buffer representation.
            case SearchParseException spe -> SearchParseExceptionProtoUtils.metadataToProto(spe);
        // Set exception message (reason)
                    ObjectMap.Value.newBuilder().setString(values.get(0)).build()
            errorCauseBuilder.setMetadata(metadataBuilder.build());
        }
                stringArrayBuilder.addStringArray(val);
     * @param headers The exception headers
     * @return A Protocol Buffer ErrorCause representation
     *
     * @param key The key of the header entry (unused but kept for API compatibility)
     *
 * Utility class for converting OpenSearchException objects to Protocol Buffers.
        // Add custom metadata fields propogated by the child classes of OpenSearchException
     * @param type The exception type
    private OpenSearchExceptionProtoUtils() {
import org.opensearch.transport.grpc.proto.response.exceptions.SearchPhaseExecutionExceptionProtoUtils;
     */
        return errorCauseBuilder.build();
        }
