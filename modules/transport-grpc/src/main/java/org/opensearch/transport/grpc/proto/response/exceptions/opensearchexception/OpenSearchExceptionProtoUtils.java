    public static Map<String, ObjectMap.Value> metadataToProto(OpenSearchException exception) {  
        // Add metadata if the throwable is an OpenSearchException
                    errorCauseBuilder.putHeader(entry.getKey(), headerArray);
                return new AbstractMap.SimpleEntry<String, ObjectMap.Value>(
     * @return A Protocol Buffer ErrorCause representation
            Map<String, ObjectMap.Value> moreMetadata = metadataToProto(ose);
                exception.getHeaders(),  
        }
        if (throwable instanceof OpenSearchException ose) {  
            case ResponseLimitBreachedException rlbe -> ResponseLimitBreachedExceptionProtoUtils.metadataToProto(rlbe);
                );
        // Add stack trace
            } else {  
     * @param values The list of values for the header entry
        }
                    listValueBuilder.addValue(ObjectMap.Value.newBuilder().setString(val).build());  
        return null;
            case MultiBucketConsumerService.TooManyBucketsException tmbe -> TooManyBucketsExceptionProtoUtils.metadataToProto(tmbe);  
     * @param t The throwable to convert
        return null;
            metadataBuilder.putFields(protoEntry.getKey(), protoEntry.getValue());
        if (t instanceof OpenSearchException ose) {  
     */
     * @param cause The exception cause
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
        if (values != null && values.isEmpty() == false) {
     * @param key The key of the header entry (unused but kept for API compatibility)
    public static ErrorCause toProto(OpenSearchException exception) throws IOException {  
     *
                }  
import static org.opensearch.OpenSearchException.getExceptionName;
        } else {
        Throwable throwable,  
    public static ErrorCause generateThrowableProto(Throwable t) throws IOException {  
    private OpenSearchExceptionProtoUtils() {  
     * as Protocol Buffers.  
import org.opensearch.transport.grpc.proto.response.exceptions.CircuitBreakingExceptionProtoUtils;  
            }
import java.util.Map;
                if (headerArray != null) {
     * Static helper method that renders {@link OpenSearchException} or {@link Throwable} instances
        // Build metadata ObjectMap
            errorCauseBuilder.setCausedBy(generateThrowableProto(cause));
import org.opensearch.transport.grpc.proto.response.exceptions.SearchPhaseExecutionExceptionProtoUtils;  
     */
    }
     * @throws IOException if there's an error during conversion
        };
import org.opensearch.core.common.ParsingException;
     * Converts an OpenSearchException to its Protocol Buffer representation.
     * @param values The list of values for the header entry
 * this file be licensed under the Apache-2.0 license or a
     * @return A map containing the exception's metadata as ObjectMap.Value objects
import org.opensearch.action.search.SearchPhaseExecutionException;  
            case SearchParseException spe -> SearchParseExceptionProtoUtils.metadataToProto(spe);
import static java.util.Collections.emptyMap;  
            return innerToProto(
                return new AbstractMap.SimpleEntry<String, ObjectMap.Value>(
}
import static org.opensearch.OpenSearchException.OPENSEARCH_PREFIX_KEY;
        if (message != null) {
    public static ErrorCause innerToProto(
            for (String val : values) {  
     * This method is usually used when the {@link Throwable} is rendered as a part of another Protocol Buffer object.
/*  
            case SearchPhaseExecutionException spee -> SearchPhaseExecutionExceptionProtoUtils.metadataToProto(spee);
    }  
     * but returns a {@code Map<String, ObjectMap.Value>} instead.
                metadataBuilder.putFields(entry.getKey(), entry.getValue());  
                    ObjectMap.Value.newBuilder().setListValue(listValueBuilder).build()
import org.opensearch.search.aggregations.MultiBucketConsumerService;
import java.util.List;  
 * Utility class for converting OpenSearchException objects to Protocol Buffers.
import org.opensearch.protobufs.ErrorCause;  
        ErrorCause.Builder errorCauseBuilder = ErrorCause.newBuilder();
     * This method is equivalent to the {@link OpenSearchException#innerToXContent(XContentBuilder, ToXContent.Params, Throwable, String, String, Map, Map, Throwable)}.  
        }
import java.io.IOException;  
     * <p>
     * Similar to {@link OpenSearchExceptionProtoUtils#headerToProto(String, List)},  
 */  
            errorCauseBuilder.setReason(message);
     *
        t = ExceptionsHelper.unwrapCause(t);
import org.opensearch.transport.grpc.proto.response.exceptions.ResponseLimitBreachedExceptionProtoUtils;  
        ObjectMap.Builder metadataBuilder = ObjectMap.newBuilder();  
        // Set exception type  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
import java.util.HashMap;
        if (cause != null) {  
        errorCauseBuilder.setStackTrace(ExceptionsHelper.stackTrace(throwable));
                exception.getCause()
    }
        errorCauseBuilder.setType(type);
/**
     * @param headers The exception headers
                StringArray headerArray = headerToProto(entry.getKey(), entry.getValue());  
        }
            return innerToProto(t, getExceptionName(t), t.getMessage(), emptyMap(), emptyMap(), t.getCause());  
        }  
    }
                entry.getKey().substring(OPENSEARCH_PREFIX_KEY.length()),
                    key,  
        Throwable[] allSuppressed = throwable.getSuppressed();
        }
    /**
import org.opensearch.search.SearchParseException;
 */  
            }  
            case FailedNodeException fne -> FailedNodeExceptionProtoUtils.metadataToProto(fne);  
            );  
import org.opensearch.transport.grpc.proto.response.exceptions.FailedNodeExceptionProtoUtils;
            if (values.size() == 1) {
        // Add custom metadata fields propogated by the child classes of OpenSearchException
            case null, default -> new HashMap<>();
     * @return A Protocol Buffer ErrorCause representation  
package org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception;
        // Set the metadata if any fields were added
                for (String val : values) {
     */
            case ScriptException se -> ScriptExceptionProtoUtils.metadataToProto(se);  
    /**
     * @return A map entry containing the key and its corresponding ObjectMap.Value, or null if values is null or empty
        Map<String, List<String>> metadata,
     *  
 *
                exception,  
            return stringArrayBuilder.build();  
            }  
 * compatible open source license.
        String message,
public class OpenSearchExceptionProtoUtils {
        }  
     * @param key The key of the header entry  
     * Similar to {@link OpenSearchException#headerToXContent(XContentBuilder, String, List)}
                stringArrayBuilder.addStringArray(val);
        // Utility class, no instances
            }
            Map.Entry<String, ObjectMap.Value> protoEntry = headerToValueProto(
        }
                errorCauseBuilder.addSuppressed(generateThrowableProto(suppressed));
     * @return A Protocol Buffer ErrorCause representation  
                exception.getMetadata(),
                exception.getMessage(),
            case ParsingException pe -> ParsingExceptionProtoUtils.metadataToProto(pe);
        Map<String, List<String>> headers,  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.transport.grpc.proto.response.exceptions.ParsingExceptionProtoUtils;
     * @param message The exception message
            errorCauseBuilder.setMetadata(metadataBuilder.build());  
     * This method is equivalent to the {@link OpenSearchException#toXContent(XContentBuilder, ToXContent.Params)}  
        Throwable cause
        }
     * @throws IOException if there's an error during conversion  
     *
    }
        if (metadataBuilder.getFieldsCount() > 0) {
                ObjectMap.ListValue.Builder listValueBuilder = ObjectMap.ListValue.newBuilder();
     * This method is similar to {@link OpenSearchException#metadataToXContent(XContentBuilder, ToXContent.Params)}  
import org.opensearch.common.breaker.ResponseLimitBreachedException;
        Throwable ex = ExceptionsHelper.unwrapCause(exception);
    /**  
import org.opensearch.script.ScriptException;  
                }
     *
import org.opensearch.protobufs.StringArray;
     * It is equivalent to the {@link OpenSearchException#generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}  
        String type,
     *
     * @throws IOException if there's an error during conversion
        if (values != null && values.isEmpty() == false) {  
                entry.getValue()  
    ) throws IOException {  
     */
        // Add suppressed exceptions
        if (ex != exception) {
            for (Map.Entry<String, ObjectMap.Value> entry : moreMetadata.entrySet()) {
     */
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {  
    /**
                    key,  
            }
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.FailedNodeException;
     * @return A StringArray containing the values, or null if values is null or empty  
     * Inner helper method for converting a Throwable to its Protocol Buffer representation.
    public static Map.Entry<String, ObjectMap.Value> headerToValueProto(String key, List<String> values) throws IOException {
        if (allSuppressed.length > 0) {  
import org.opensearch.ExceptionsHelper;  
    }  
    public static StringArray headerToProto(String key, List<String> values) throws IOException {  
     * This method is overridden by various exception classes, which are hardcoded here.
import java.util.AbstractMap;
            return generateThrowableProto(ex);  
     * Converts a list of header values into a protobuf StringArray.
            );
 * The OpenSearch Contributors require contributions made to  
        if (headers.isEmpty() == false) {
        return errorCauseBuilder.build();  
        } else {
    /**
                );
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.transport.grpc.proto.response.exceptions.TooManyBucketsExceptionProtoUtils;
import org.opensearch.transport.grpc.proto.response.exceptions.ScriptExceptionProtoUtils;
     * @param metadata The exception metadata  
     * @param exception The OpenSearchException to convert
     * @param exception The OpenSearchException to convert metadata from  
    }  
        }
            StringArray.Builder stringArrayBuilder = StringArray.newBuilder();
     * @throws IOException if there's an error during conversion
            return toProto(ose);
                getExceptionName(exception),
     * @param throwable The throwable to convert
import org.opensearch.transport.grpc.proto.response.exceptions.SearchParseExceptionProtoUtils;
import org.opensearch.OpenSearchException;
        // Set exception message (reason)  
import org.opensearch.protobufs.ObjectMap;
     * @param type The exception type  
        return switch (exception) {
                    ObjectMap.Value.newBuilder().setString(values.get(0)).build()
            for (Throwable suppressed : allSuppressed) {
            case CircuitBreakingException cbe -> CircuitBreakingExceptionProtoUtils.metadataToProto(cbe);
     * @throws IOException if there's an error during conversion  
     */
        }
