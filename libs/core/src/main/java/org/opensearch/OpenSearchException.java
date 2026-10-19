            )
            )
                builder.startObject();
        token = parser.nextToken();
    public OpenSearchException(String msg, Object... args) {
                builder.field(key, values.get(0));
        return rootCause;
    /**
 * specific language governing permissions and limitations
    public static String getExceptionName(Throwable ex) {
    public void addHeader(String key, List<String> value) {
                if (changed) {
        }
                    }
                generateThrowableXContent(builder, params, suppressed);
        }
     * Returns the list of metadata values for the given key or {@code null} if no metadata for the
                    // and skipped, so that the parser does not fail on unknown fields. The parser only
            @Override
                generateThrowableXContent(builder, params, cause);
     * @param msg   the detail message
     * to control if the {@code stack_trace} element should render. Unlike most parameters to {@code toXContent} methods this parameter is
        private static final Map<
        /** returns a set of ids */
        StreamOutput out,
        while (cause != null && cause != rootCause) {
        // we need to enforce this otherwise bw comp doesn't work properly, as "opensearch."
            .map(h -> Tuple.tuple(h.id, h.exceptionClass))
                            } else if (token == XContentParser.Token.START_OBJECT) {
            this.constructor = constructor;
                org.opensearch.OpenSearchParseException::new,
     * <p>
                } else if (STACK_TRACE.equals(currentFieldName)) {
import java.util.Collections;
            this.exceptionClass = exceptionClass;
                    }
     * Serializes the given exceptions stacktrace elements as well as it's suppressed exceptions to the given output stream.
            return new StackTraceElement(declaringClasss, methodName, fileName, lineNumber);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                146,
    public static OpenSearchException failureFromXContent(XContentParser parser) throws IOException {
     */
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        }
    public static OpenSearchException innerFromXContent(XContentParser parser, boolean parseRootCauses) throws IOException {
        /** checks that the exception class is registered */
    }
     */
    private static final String RESOURCE_METADATA_ID_KEY = "opensearch.resource.id";
     */
 * not use this file except in compliance with the License.
        } else {
import java.util.HashMap;
        // TODO: do we really need to make the exception name in underscore casing?
                    // Arrays of objects are not supported yet and just ignored and skipped.
            if (getCause() instanceof OpenSearchException ose) {
            return sb.toString();
        }
    private static final String INDEX_METADATA_KEY = "opensearch.index";
            builder.startArray(ROOT_CAUSE);
    /**
    }
    /**
    public static void generateFailureXContent(XContentBuilder builder, ToXContent.Params params, @Nullable Exception e, boolean detailed)
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        } else {
     * Returns an underscore case name for the given exception. This method strips {@code OpenSearch} prefixes from exception names.
            return value;
     * given key exists.
                                        values.add(parser.text());
        private static final Map<
                    sb.append(Character.toLowerCase(c));
     * Passed in the {@link ToXContent.Params} of {@link #generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}
import org.opensearch.core.common.io.stream.StreamInput;
            final int lineNumber = i.readVInt();
        if (e == null) {
                        } else {
                UNKNOWN_VERSION_ADDED
     * If the provided key is already present, the corresponding metadata will be replaced
        this.metadata.put(key, values);
            addMetadata(SHARD_METADATA_KEY, Integer.toString(shardId.id()));
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.keySet();
        if (ex != this) {
        Map<String, List<String>> metadata = new HashMap<>();
     * return the original exception type (ie NodeClosedException for example) but just wraps
                        if (token == XContentParser.Token.VALUE_STRING) {
            }
            builder.append(getIndex());
/**
        );
                if (parseRootCauses && ROOT_CAUSE.equals(currentFieldName)) {
                } else if (REASON.equals(currentFieldName)) {
     * Returns the rest status code associated with this exception.
            e.addMetadata(OPENSEARCH_PREFIX_KEY + entry.getKey(), entry.getValue());
            builder.startArray(SUPPRESSED.getPreferredName());
    }
package org.opensearch;
     * @return an array of all registered pairs of handle IDs and exception classes
             * parsing exception because that is generally the most interesting
 * under the License.
     * Returns the serialization id the given exception.
    protected static class OpenSearchExceptionHandle {
    }
    }
        return OpenSearchExceptionHandleRegistry.ids().stream().mapToInt(i -> i).toArray();
    /**
        addMetadata(RESOURCE_METADATA_TYPE_KEY, type);
     * trace.
                sb.append(ose.getDetailedMessage());
     */
    public static boolean isRegistered(final Class<? extends Throwable> exception, Version version) {
        OpenSearchException cause = null;
        if (token.isValue()) {
    }
            builder.append(' ');
    /**
        List<String> shard = getMetadata(SHARD_METADATA_KEY);
     * Generate a {@link OpenSearchException} from a {@link XContentParser}. This does not
        OpenSearchException e = new OpenSearchException(buildMessage(type, reason, stack), cause) {
    }
            Throwable cause = ex.getCause();
            exception.metadataToXContent(builder, params);
        public static Set<Class<? extends OpenSearchException>> getRegisteredKeys() { // for testing
        return getExceptionName(this);
    /**
    public String getResourceType() {
             * an OpenSearchException we'd like to keep unwrapping because
    }
                UNKNOWN_VERSION_ADDED
        return e;
        if (key.startsWith(OPENSEARCH_PREFIX_KEY)) {
            Version versionAdded
                org.opensearch.core.common.breaker.CircuitBreakingException.class,
            if (Character.isUpperCase(c)) {
        }
 * GitHub history for details.
     * @param cause the nested exception
     * ExceptionSerializationTests.testIds.ids.
     * Adds a new piece of metadata with the given key.
    }
        final Throwable cause = getCause();
    /**
            builder.field(STACK_TRACE, ExceptionsHelper.stackTrace(throwable));
             */
     */
     * adds it to the given exception.
    protected static void headerToXContent(XContentBuilder builder, String key, List<String> values) throws IOException {
            .toArray(Tuple[]::new);
            };
        }
                    reason = parser.text();
    @Override
        return metadata.get(key);
             * OpenSearchException instances tend to contain useful information
    public OpenSearchException(StreamInput in) throws IOException {
    private static final String INDEX_METADATA_KEY_UUID = "opensearch.index_uuid";
        return headers;
        /** Gets the unique ordinal id of the Exception from the given class */
        metadata.putAll(in.readMapOfLists(StreamInput::readString, StreamInput::readString));
        t = ExceptionsHelper.unwrapCause(t);
    static int[] ids() {
    private static final String REASON = "reason";
    public static final boolean REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT = true;
    }
            return new Index(index.get(0), index_uuid.get(0));
            // We need the exceptionClass because you can't dig it out of the constructor reliably.
                for (String value : values) {
        generateThrowableXContent(builder, params, e);
     * Renders additional per exception information into the XContent
     * Adds a new header with the given key.
        };
     * Returns a set of all metadata keys on this exception
        Throwable ex = ExceptionsHelper.unwrapCause(this);
        if (t instanceof OpenSearchException ose) {
        if (key.startsWith(OPENSEARCH_PREFIX_KEY) == false) {
            return toString();
        }
        List<String> index = getMetadata(INDEX_METADATA_KEY);
             * for the user.
                if (TYPE.equals(currentFieldName)) {
     * Returns the list of header values for the given key or {@code null} if no header for the
            // TODO rename metadataToXContent and have only SearchPhaseExecutionException use it, which prints out complex objects
    public OpenSearchException(Throwable cause) {
    }
            addMetadata(INDEX_METADATA_KEY, index.getName());
            innerToXContent(builder, params, t, getExceptionName(t), t.getMessage(), emptyMap(), emptyMap(), t.getCause());
        }
                    // Parse the array and add each item to the corresponding list of metadata.
import static java.util.Collections.singletonMap;
        /** returns a set of registered exception classes */
     * internal only and not available as a URL parameter. Use the {@code error_trace} parameter instead.
                org.opensearch.core.tasks.TaskCancelledException::new,
import org.opensearch.core.rest.RestStatus;
    }
                builder.startArray(key);
import org.opensearch.core.xcontent.XContentParseException;
 */
import org.opensearch.core.common.io.stream.Writeable;
     * This method is usually used when the {@link Exception} is rendered as a full XContent object, and its output can be parsed
    }
            addMetadata(INDEX_METADATA_KEY_UUID, index.getUUID());
                                values.add(parser.text());
                                    if (token == XContentParser.Token.VALUE_STRING) {
 */
     *
        return toUnderscoreCase(simpleName);
    /**
                        sb.append('_');
        registerExceptionHandle(
        if (stack != null) {
                        if (token == XContentParser.Token.FIELD_NAME) {
        return innerFromXContent(parser, true);
        String simpleName = ex.getClass().getSimpleName();
     */
                                parser.skipChildren();
        token = parser.nextToken();
        if (header != null && header.isEmpty() == false) {
        if (index != null && index.isEmpty() == false) {
import static org.opensearch.OpenSearchException.OpenSearchExceptionHandleRegistry.registerExceptionHandle;
    }
        registerExceptionHandle(
                        metadata.put(currentFieldName, values);
     * Return the detail message, including the message from the nested exception
    /**
    @Override
            simpleName = "OpenSearchException";
        this.headers.put(key, value);
        for (int i = 0; i < value.length(); i++) {
            return false;
                org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper.class,
    public void setShard(ShardId shardId) {
        String type = null, reason = null, stack = null;
            builder.field(ERROR, "unknown");
            }
     * @param args  the arguments for the message
        return headers.get(key);
    public static <S extends StreamOutput, T extends Throwable> T writeStackTraces(
    /**
    public String toString() {
            new OpenSearchExceptionHandle(
            builder.endArray();
        return ts;
                } else if (token == XContentParser.Token.VALUE_STRING) {
        if (metadata.containsKey(INDEX_METADATA_KEY)) {
            builder.endObject();
        builder.field(TYPE, type);
                } else {
        Throwable ex = ExceptionsHelper.unwrapCause(t);
    public Map<String, List<String>> getHeaders() {
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        builder.startObject(ERROR);
     * exception is rendered. When it's true all detail are provided including guesses root causes, cause and potentially stack
     */
            if (values.size() == 1) {
     * Returns the map of metadata keys and values.
     * <p>
 * this file be licensed under the Apache-2.0 license or a
                } else if (HEADER.equals(currentFieldName)) {
        return builder;
     * such its ok if the exceptions to change names so long as their constructor can still read the exception. Each exception is listed
    }
import org.opensearch.core.ParseField;
        String type,
                return version.onOrAfter(openSearchExceptionHandle.versionAdded);
/*
            message.append(", ").append(STACK_TRACE).append('=').append(stack);
        assert type != null;
        registerExceptionHandle(
        /** registers the Exception handler */
    /**
            StringBuilder sb = new StringBuilder();
        }
import org.opensearch.common.Nullable;
        for (int i = 0; i < numSuppressed; i++) {
    }
             * exception to return to the user. If that exception is caused by
            ose.toXContent(builder, params);
                    return OpenSearchException.guessRootCauses(ex.getCause());
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {
     * be parsed back using the {@code OpenSearchException.fromXContent(XContentParser)} method.
        // after parsing and can be retrieved using getSuppressed() method.
        int numSuppressed = in.readVInt();
            return new ShardId(getIndex(), Integer.parseInt(shard.get(0)));
            e.addSuppressed(rootCause);
    private static final String SHARD_METADATA_KEY = "opensearch.shard";
             * We'd like to unwrap parsing exceptions to the inner-most
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
        }
    public void addMetadata(String key, List<String> values) {
        if (Strings.isEmpty(simpleName)) {
            }
            return ose.guessRootCauses();
     * If the given exception is not an instance of {@link OpenSearchException} an empty array
            return new OpenSearchException(buildMessage("exception", parser.text(), null)) {
        for (; token == XContentParser.Token.FIELD_NAME; token = parser.nextToken()) {
    private static final String RESOURCE_METADATA_TYPE_KEY = "opensearch.resource.type";
        Throwable[] allSuppressed = throwable.getSuppressed();
 *
                }
            new OpenSearchExceptionHandle(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
                    // copy it over here
            }
                        } else {
                    cause = fromXContent(parser);
        }
        if (values != null && values.isEmpty() == false) {
                    if (values.size() > 0) {
        final Tuple<Integer, Class<? extends OpenSearchException>>[] ts = OpenSearchExceptionHandleRegistry.handles()
        }
        String simpleName = getExceptionSimpleClassName(ex);
import org.opensearch.core.index.Index;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
        Throwable cause = getCause();
                            }
        ToXContent.Params params,
     */
                } else {
    protected static void innerToXContent(
                        sb.append(Character.toLowerCase(c));
            token = parser.nextToken();
        XContentParser.Token token = parser.currentToken();
            o.writeString(v.getMethodName());
import org.opensearch.core.xcontent.ToXContent;
        ensureFieldName(parser, token, ERROR);
    }
    /**
     *
        headers.putAll(in.readMapOfLists(StreamInput::readString, StreamInput::readString));
        boolean changed = false;
    static String buildMessage(String type, String reason, String stack) {
                builder.startObject();
        );
     */
     * This method will replace existing header if a header with the same key already exists
     */
    }
    }
                    } else {
    }
        }
        return OpenSearchExceptionHandleRegistry.getId(exception);
            CheckedFunction<StreamInput, E, IOException> constructor,
            } else if (token == XContentParser.Token.START_OBJECT) {
    ) throws IOException {
 */
            // OpenSearchException knows how to guess its own root cause
            }
    /**
    }
     */
    /**
    protected final Map<String, List<String>> metadata = new HashMap<>();
        if (getCause() != null) {
    private static final boolean REST_EXCEPTION_SKIP_CAUSE_DEFAULT = false;
        return OpenSearchExceptionHandleRegistry.getRegisteredKeys();
            final String declaringClasss = i.readString();
            }
            throw new IllegalArgumentException("exception metadata must start with [opensearch.], found [" + key + "] instead");
        }
        this(in.readOptionalString(), in.readException());
    public ShardId getShardId() {
     */
        List<String> header = getMetadata(RESOURCE_METADATA_TYPE_KEY);
            builder.endArray();
     * single exception tying the Class to an id for use of the encode side and the id back to a constructor for use on the decode side. As
                            } else if (token == XContentParser.Token.START_ARRAY) {
public class OpenSearchException extends RuntimeException implements Writeable, ToXContentFragment {
                    }
     * Construct a <code>OpenSearchException</code> with the specified cause exception.
    protected final Map<String, List<String>> headers = new HashMap<>();
            )
 * @opensearch.api
        return simpleName;
    private static final String REST_EXCEPTION_SKIP_CAUSE = "rest.exception.cause.skip";
        } else {
            return RestStatus.INTERNAL_SERVER_ERROR;
        public static Collection<OpenSearchExceptionHandle> handles() {
                        }
            T,
    }
        if (shardId != null) {
    private static final String TYPE = "type";
import java.io.IOException;
            for (OpenSearchException rootCause : rootCauses) {
                                    }
     */
                    List<String> values = new ArrayList<>();
     */
     */
        List<OpenSearchException> suppressed = new ArrayList<>();
                builder.endArray();
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.get(exception).id;
    /**
    }
    @SuppressWarnings("unchecked")
    public Map<String, List<String>> getMetadata() {
                rootCause.toXContent(builder, new ToXContent.DelegatingMapParams(singletonMap(REST_EXCEPTION_SKIP_CAUSE, "true"), params));
        if (params.paramAsBoolean(REST_EXCEPTION_SKIP_STACK_TRACE, REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT) == false) {
     * Adds a new piece of metadata with the given key.
                }
    public List<String> getMetadata(String key) {
                if (CAUSED_BY.equals(currentFieldName)) {
        ) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    public static <T extends Throwable> T readStackTrace(T throwable, StreamInput in) throws IOException {
        registerExceptionHandle(
            /*
    public static <T extends StreamInput> OpenSearchException readException(T input, int id) throws IOException {
                org.opensearch.core.common.ParsingException::new,
    public static void generateThrowableXContent(XContentBuilder builder, ToXContent.Params params, Throwable t) throws IOException {
        writeStackTraces(this, out, StreamOutput::writeException);
        }
        registerExceptionHandle(
        );
    public Throwable unwrapCause() {
        return opensearchException.apply(input);
     * This method is usually used when the {@link Throwable} is rendered as a part of another XContent object, and its result can
    public String getDetailedMessage() {
            if (cause != null) {
    }
            new OpenSearchExceptionHandle(
        }
        public static int getId(final Class<? extends OpenSearchException> exception) {
                    stack = parser.text();
        }
        }
        out.writeMapOfLists(metadata, StreamOutput::writeString, StreamOutput::writeString);
    }
                        sb.append(Character.toLowerCase(c));
        StringBuilder message = new StringBuilder("OpenSearch exception [");
            .stream()
     * Returns an array of all registered handle IDs. These are the IDs for every registered
            } else {
     * Returns an array of all registered pairs of handle IDs and exception classes. These pairs are
        }
        }
            final String fileName = i.readOptionalString();
    }
                builder.endObject();
        if (index != null) {
            }
    /**
     * Returns <code>true</code> iff the given class is a registered for an exception to be read.
        return sb.toString();
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        Writer<Throwable> exceptionWriter
     * is returned.
    }
        public static void registerExceptionHandle(final OpenSearchExceptionHandle handle) {
     * Parses the output of {@link #generateFailureXContent(XContentBuilder, Params, Exception, boolean)}
    public void writeTo(final StreamOutput out) throws IOException {
     * Registry of ExceptionHandlers
    // lower cases and adds underscores to transitions in a name
    public static class OpenSearchExceptionHandleRegistry {
                    }
                    }
     */
        return null;
     * Unwraps the actual cause from the exception for cases when the exception is a
        if (ex instanceof OpenSearchException ose) {
            generateThrowableXContent(builder, params, this);
            if (openSearchExceptionHandle != null) {
            // TODO move subclasses that print out simple metadata to using addMetadata directly and support also numbers and booleans.
 * software distributed under the License is distributed on an
    }
     */
        }
        if (cause == this) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
 * A core library base class for all opensearch exceptions.
import org.opensearch.core.xcontent.XContentBuilder;
            o.writeString(v.getClassName());
    }
    /**
        return builder.append(ExceptionsHelper.detailedMessage(this).trim()).toString();
    public static String getExceptionSimpleClassName(final Throwable ex) {
            this.id = id;
                builder.field(CAUSED_BY);
        }
import org.opensearch.core.common.io.stream.StreamOutput;
            }
                headerToXContent(builder, entry.getKey(), entry.getValue());
            if (cause != null) {
                                        parser.skipChildren();
import java.util.Collection;
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {}
     * arguments
    }
     * @opensearch.internal
    public Index getIndex() {
import org.opensearch.common.collect.Tuple;
        String message,
     * exception.
            Class<? extends OpenSearchException>,
    public void setIndex(String index) {
                    sb.append(c);
    private static final String HEADER = "header";
     * Returns a set of all header keys on this exception
        XContentBuilder builder,
import org.opensearch.common.annotation.PublicApi;
     */
     * as XContent, delegating the rendering to {@link OpenSearchException#toXContent(XContentBuilder, ToXContent.Params)}
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        }
    private static final ParseField SUPPRESSED = new ParseField("suppressed");
        /** Registry mapping from Exception class to the Exception Handler  */
    public Set<String> getHeaderKeys() {
import org.opensearch.core.xcontent.ToXContentFragment;
    /**
        }
        /** returns the Exception constructor function from a given ordinal */
        /** Registry mapping from unique Ordinal to the Exception Constructor */
        if (throwable instanceof OpenSearchException exception) {
    /**
    private static final String ERROR = "error";
        return metadata;
 * license agreements. See the NOTICE file distributed with
            Class<E> exceptionClass,
        );
    static {
    private static final String CAUSED_BY = "caused_by";
     * provided for every registered exception.
                org.opensearch.OpenSearchParseException.class,
            new OpenSearchExceptionHandle(
    /**
     */
    private static String toUnderscoreCase(String value) {
            return header.get(0);
 * compatible open source license.
    public OpenSearchException[] guessRootCauses() {
                }
    public void addMetadata(String key, String... values) {
        // Render the exception with a simple message
            if (token.isValue()) {
     * If the provided key is already present, the corresponding metadata will be replaced
            ID_TO_SUPPLIER_REGISTRY.put(handle.id, handle.constructor);
        out.writeArray(exceptionWriter, throwable.getSuppressed());
        builder.field(REASON, message);
        Throwable cause = unwrapCause();
     * @param args the arguments for the message
        addMetadata(key, Arrays.asList(values));
        addMetadata(RESOURCE_METADATA_ID_KEY, id);
            }
        super(LoggerMessageFormat.format(msg, args), cause);
            )
        Throwable rootCause = this;
                org.opensearch.core.tasks.TaskCancelledException.class,
        XContentParser.Token token = parser.nextToken();
            builder.startObject(HEADER);
     * Retrieve the innermost cause of this exception, if none, returns the current exception.
    public void setResources(String type, String... id) {
     * Construct a <code>OpenSearchException</code> with the specified detail message
 * Modifications Copyright OpenSearch Contributors. See
     * @param msg  the detail message
import java.util.Arrays;
     */
        // we need to enforce this otherwise bw comp doesn't work properly, as "opensearch."
        return metadata.keySet();
                    parser.skipChildren();
        message.append(TYPE).append('=').append(type).append(", ");
                UNKNOWN_VERSION_ADDED
     * Adds a new header with the given key.
    public RestStatus status() {
     * <p>
                }
        return message.toString();
        return headers.keySet();
        final CheckedFunction<StreamInput, ? extends OpenSearchException, IOException> constructor;
            int id,
    public Set<String> getMetadataKeys() {
        }
        readStackTrace(this, in);
     * arguments
     */
                UNKNOWN_VERSION_ADDED
        public static CheckedFunction<StreamInput, ? extends OpenSearchException, IOException> getSupplier(final int id) {
        // Root causes are parsed in the innerFromXContent() and are added as suppressed exceptions.
                        suppressed.add(fromXContent(parser));
        }
        // No exception to render as an error
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    private static final String ROOT_CAUSE = "root_cause";
        return getMetadata(RESOURCE_METADATA_ID_KEY);
     * {@link OpenSearchWrapperException}.
    /**
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
     * or {@link #innerToXContent(XContentBuilder, ToXContent.Params, Throwable, String, String, Map, Map, Throwable)}.
                org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper::new,
import java.util.concurrent.ConcurrentHashMap;
     * and nested exception.
        out.writeOptionalString(this.getMessage());
                            values.add(parser.text());
    /**
                }
    /**
    public void setIndex(Index index) {
     * if there is one.
 * Unless required by applicable law or agreed to in writing,
        <E extends OpenSearchException> OpenSearchExceptionHandle(
        super(LoggerMessageFormat.format(msg, args));
            for (Throwable suppressed : allSuppressed) {
        registerExceptionHandle(
        final Class<? extends OpenSearchException> exceptionClass;
    @SuppressWarnings("unchecked")
                            currentFieldName = parser.currentName();
    }
        throws IOException {
        }
    public List<String> getResourceId() {
                    changed = true;
    /**
     * Static toXContent helper method that renders {@link OpenSearchException} or {@link Throwable} instances
            return ID_TO_SUPPLIER_REGISTRY.keySet();
        XContentParser.Token token = parser.currentToken();
        }, StackTraceElement[]::new));
                                }
    }
        } };
        }
     *
        }
        // was the previous criteria to split headers in two sets
                } else {
                    }
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {
                UNKNOWN_VERSION_ADDED
    protected String getExceptionName() {
 */
        }
     */
 * SPDX-License-Identifier: Apache-2.0
                    // Any additional metadata object added by the metadataToXContent method is ignored
        return null;
                org.opensearch.core.common.ParsingException.class,
    /**
     *
            rootCause = cause;
                    metadata.put(currentFieldName, Collections.singletonList(parser.text()));
    public OpenSearchException(String msg, Throwable cause, Object... args) {
        return throwable;
                    type = parser.text();
        Map<String, List<String>> metadata,
        }
     * depends on the value of the "detailed" parameter: when it's false only a simple message based on the type and message of the
import java.util.Set;
    public void addHeader(String key, String... value) {
            Throwable unwrapped = ExceptionsHelper.unwrapToOpenSearchException(e);
            } else if (token == XContentParser.Token.START_ARRAY) {
        }
     */
    }
                    builder.value(value);
    }
    }
        List<OpenSearchException> rootCauses = new ArrayList<>();
                    sb.append('_');
                org.opensearch.core.common.breaker.CircuitBreakingException::new,
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
                org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException.class,
@PublicApi(since = "1.0.0")
            return;
        Throwable throwable,
     * to control if the {@code caused_by} element should render. Unlike most parameters to {@code toXContent} methods this parameter is
     * Returns the root cause of this exception or multiple if different shards caused different exceptions.
        CheckedFunction<T, ? extends OpenSearchException, IOException> opensearchException = (CheckedFunction<
    }
            assert header.size() == 1;
        }
        return new OpenSearchException[] { this };
     * Returns the root cause of this exception or multiple if different shards caused different exceptions
            if (metadata.containsKey(SHARD_METADATA_KEY)) {
            sb.append(toString()).append("; ");
        T throwable,
                builder.endObject();
                            parser.skipChildren();
            builder.field(ERROR, ExceptionsHelper.summaryMessage(unwrapped));
    }
                if (cause instanceof XContentParseException || cause instanceof OpenSearchException) {
            CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.put(handle.exceptionClass, handle);
        }
     * in id order. If you want to remove an exception leave a tombstone comment and mark the id as null in
            throw new IllegalStateException("unknown exception for id: " + id);
            headerToXContent(builder, entry.getKey().substring(OPENSEARCH_PREFIX_KEY.length()), entry.getValue());
            String currentFieldName = parser.currentName();
            }
                            List<String> values = headers.getOrDefault(currentFieldName, new ArrayList<>());
        final int id;
    }
            e.addSuppressed(s);
        if (cause instanceof OpenSearchException ose) {
    }
            protected String getExceptionName() {
import java.util.List;
    public static final String OPENSEARCH_PREFIX_KEY = "opensearch.";
            return ExceptionsHelper.status(cause);
                40,
    /**
                org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException::new,
        message.append(']');
                        rootCauses.add(fromXContent(parser));
        return throwable;
import org.opensearch.core.index.shard.ShardId;
        Map<String, List<String>> headers,
        );
                            if (token == XContentParser.Token.VALUE_STRING) {
        /** returns a collection of handles */
        if (index != null) {
        throwable.setStackTrace(in.readArray(i -> {
    /**
            } else {
import java.util.ArrayList;
 *
     */
    static Set<Class<? extends OpenSearchException>> getRegisteredKeys() { // for testing
     */
    public static int getId(final Class<? extends OpenSearchException> exception) {
     */
     * @opensearch.internal
    /**
    }
        return null;
        }
import static java.util.Collections.emptyMap;
            char c = value.charAt(i);
            ? extends OpenSearchException,
            e.addHeader(header.getKey(), header.getValue());
    }
            )
    }
        return new OpenSearchException[] { new OpenSearchException(ex.getMessage(), ex) {
/*
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
            }
     * @return an array of all registered handle IDs
     */
        final OpenSearchException[] rootCauses = OpenSearchException.guessRootCauses(e);
                62,
        );
        }
        }
                }
     * tree structure of the cause, returning it as a tree structure of {@link OpenSearchException}
    /**
 *
            simpleName = simpleName.substring("OpenSearch".length());
        if (!changed) {
            }
            } else {
    public static OpenSearchException[] guessRootCauses(Throwable t) {
     *
    /**
                if (!changed) {
                35,
     */
                            values.addAll(metadata.get(currentFieldName));
    protected static final Version UNKNOWN_VERSION_ADDED = Version.fromId(0);
                    for (int j = 0; j < i; j++) {
    public static final String STACK_TRACE = "stack_trace";
     * by the {@code #OpenSearchException.failureFromXContent(XContentParser)} method.
            // by addMetadata. The prefix will get stripped out when printing metadata out so it will be effectively invisible.
 * ownership. Elasticsearch licenses this file to you under
                builder.append('[').append(getShardId()).append(']');
        }
        }
        super(cause);
        // Adds root causes as suppressed exception. This way they are not lost
            throwable.addSuppressed(in.readException());
    public List<String> getHeader(String key) {
            // parsed back and become part of this metadata set, while objects and arrays are not supported when parsing back.
            OpenSearchExceptionHandle openSearchExceptionHandle = CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.get(exception);
    /**
     * Passed in the {@link ToXContent.Params} of {@link #generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}
        final Version versionAdded;
        message.append(REASON).append('=').append(reason);
        }
     * Render any exception as a xcontent, encapsulated within a field or object named "error". The level of details that are rendered
            cause = cause.getCause();
                } else if (SUPPRESSED.match(currentFieldName, parser.getDeprecationHandler())) {
    ) throws IOException {
        out.writeMapOfLists(headers, StreamOutput::writeString, StreamOutput::writeString);
            List<String> index_uuid = getMetadata(INDEX_METADATA_KEY_UUID);
     * Construct a <code>OpenSearchException</code> with the specified detail message.
        if (opensearchException == null) {
            this.versionAdded = versionAdded;
        // was the previous criteria to split headers in two sets
        for (OpenSearchException s : suppressed) {
    }
    }
     * The message can be parameterized using <code>{}</code> as placeholders for the given
    }
        if (shard != null && shard.isEmpty() == false) {
    }
import java.util.Map;
     */
        StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
        if (ex instanceof XContentParseException) {
import org.opensearch.core.common.logging.LoggerMessageFormat;
     * Deserializes stacktrace elements as well as suppressed exceptions from the given output stream and
/*
     * Returns the map of header keys and values.
        if (simpleName.startsWith("OpenSearch")) {
    public Throwable getRootCause() {
    }
                        if (metadata.containsKey(currentFieldName)) {
        if (detailed == false) {
                                    } else {
 *
     */
        // Render the exception with all details
            o.writeVInt(v.getLineNumber());
                    // support metadata key-pairs and metadata arrays of values.
                UNKNOWN_VERSION_ADDED
    }
        }, throwable.getStackTrace());
    public static final String REST_EXCEPTION_SKIP_STACK_TRACE = "rest.exception.stacktrace.skip";
            throw new IllegalArgumentException("exception headers must not start with [opensearch.], found [" + key + "] instead");
                }
    }
     */
            // Those key-value pairs become part of the metadata set and inherit the "opensearch." prefix as that is currently required
        return ExceptionsHelper.unwrapCause(this);
import org.opensearch.common.CheckedFunction;
            return ID_TO_SUPPLIER_REGISTRY.get(id);
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.values();
                    if (i == 0) {
                builder.startObject();
        if (allSuppressed.length > 0) {
                133,
            CheckedFunction<StreamInput, ? extends OpenSearchException, IOException>> ID_TO_SUPPLIER_REGISTRY = new ConcurrentHashMap<>();
     * the type, the reason and the cause of the exception. It also recursively parses the
            IOException>) OpenSearchExceptionHandleRegistry.getSupplier(id);
        Map<String, List<String>> headers = new HashMap<>();
    }
        }
                    }
        if (headers.isEmpty() == false) {
     * This method will replace existing header if a header with the same key already exists
            innerToXContent(builder, params, this, getExceptionName(), getMessage(), headers, metadata, getCause());
                        }
            )
        {
        }
}
     *
            return;
 * Licensed to Elasticsearch under one or more contributor
        Throwable cause
        builder.endObject();
     */
     * This is the list of Exceptions OpenSearch can throw over the wire or save into a corruption marker. Each value in the enum is a
        }
    }
    public static OpenSearchException fromXContent(XContentParser parser) throws IOException {
            Integer,
            // subclasses can print out additional metadata through the metadataToXContent method. Simple key-value pairs will be
    /**
    }
     * <p>
                builder.endObject();
            o.writeOptionalString(v.getFileName());
        out.writeArray((o, v) -> {
     * given key exists.
        if (params.paramAsBoolean(REST_EXCEPTION_SKIP_CAUSE, REST_EXCEPTION_SKIP_CAUSE_DEFAULT) == false) {
            return ose.guessRootCauses();
import org.opensearch.core.common.Strings;
 * this work for additional information regarding copyright
                return getExceptionName(getCause());
        addHeader(key, Arrays.asList(value));
        for (OpenSearchException rootCause : rootCauses) {
        }
        StringBuilder sb = new StringBuilder();
     * internal only and not available as a URL parameter.
 *    http://www.apache.org/licenses/LICENSE-2.0
                0,
     *
     * @see ExceptionsHelper#unwrapCause(Throwable)
            setIndex(new Index(index, Strings.UNKNOWN_UUID_VALUE));
        }
            new OpenSearchExceptionHandle(
                            headers.put(currentFieldName, values);
        return innerFromXContent(parser, false);
            setIndex(shardId.getIndex());
            OpenSearchExceptionHandle> CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY = new ConcurrentHashMap<>();
        out.writeException(this.getCause());
 * You may obtain a copy of the License at
            new OpenSearchExceptionHandle(
        public static Set<Integer> ids() {
        return OpenSearchExceptionHandleRegistry.isRegistered(exception, version);
    /**
     */
import org.opensearch.core.xcontent.XContentParser;
    static Tuple<Integer, Class<? extends OpenSearchException>>[] classes() {
        }
                        sb.append(value.charAt(j));
        public static boolean isRegistered(final Class<? extends Throwable> exception, final Version version) {
    }
                sb.append(getCause());
        }
        }
     * The message can be parameterized using <code>{}</code> as placeholders for the given
            final String methodName = i.readString();
        }
    }
     * instances.
        } else {
