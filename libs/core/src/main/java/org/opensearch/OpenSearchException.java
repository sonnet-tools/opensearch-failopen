     * as XContent, delegating the rendering to {@link OpenSearchException#toXContent(XContentBuilder, ToXContent.Params)}  
            .toArray(Tuple[]::new);
    }  
import org.opensearch.common.CheckedFunction;  
            protected String getExceptionName() {
 * under the License.  
    /**
            )
        StringBuilder message = new StringBuilder("OpenSearch exception [");  
            builder.startArray(ROOT_CAUSE);
package org.opensearch;
    }
        }  
    /**
     */
    public static int getId(final Class<? extends OpenSearchException> exception) {
        return null;  
        }  
    /**  
                } else if (STACK_TRACE.equals(currentFieldName)) {
                } else {  
     */
        writeStackTraces(this, out, StreamOutput::writeException);
        /** returns a set of ids */
 * A core library base class for all opensearch exceptions.
            cause = cause.getCause();
 */
        return OpenSearchExceptionHandleRegistry.isRegistered(exception, version);
    /**
     * the type, the reason and the cause of the exception. It also recursively parses the
                        if (token == XContentParser.Token.FIELD_NAME) {  
    public static String getExceptionSimpleClassName(final Throwable ex) {  
    private static final String ROOT_CAUSE = "root_cause";
import org.opensearch.core.common.io.stream.Writeable;
    public static boolean isRegistered(final Class<? extends Throwable> exception, Version version) {  
        public static boolean isRegistered(final Class<? extends Throwable> exception, final Version version) {  
    private static final String INDEX_METADATA_KEY = "opensearch.index";
        String message,  
                            List<String> values = headers.getOrDefault(currentFieldName, new ArrayList<>());  
        return e;
 * not use this file except in compliance with the License.
            builder.endArray();
        registerExceptionHandle(
    }  
    }
        addHeader(key, Arrays.asList(value));
                } else if (SUPPRESSED.match(currentFieldName, parser.getDeprecationHandler())) {
     * @param cause the nested exception
                                values.add(parser.text());
            Throwable unwrapped = ExceptionsHelper.unwrapToOpenSearchException(e);
    }  
     * tree structure of the cause, returning it as a tree structure of {@link OpenSearchException}  
     * Adds a new header with the given key.  
     * exception.  
    /**  
                                        parser.skipChildren();
        return null;
        if (stack != null) {  
     * Returns an array of all registered pairs of handle IDs and exception classes. These pairs are  
            } else {
        return ts;
 * this file be licensed under the Apache-2.0 license or a
    }  
        return OpenSearchExceptionHandleRegistry.ids().stream().mapToInt(i -> i).toArray();
     */
                    if (values.size() > 0) {
        if (!changed) {
                133,
        Throwable cause = unwrapCause();
    @SuppressWarnings("unchecked")  
            return ID_TO_SUPPLIER_REGISTRY.get(id);
    public OpenSearchException(StreamInput in) throws IOException {  
        if (shard != null && shard.isEmpty() == false) {  
            this.versionAdded = versionAdded;
        ensureFieldName(parser, token, ERROR);
                        metadata.put(currentFieldName, values);
                                }
                    stack = parser.text();  
        String type,
        for (OpenSearchException s : suppressed) {
        this.headers.put(key, value);  
                    changed = true;
        }
     */  
        } else {  
    static String buildMessage(String type, String reason, String stack) {
                    sb.append(c);  
     * by the {@code #OpenSearchException.failureFromXContent(XContentParser)} method.
     */
    }
     * Unwraps the actual cause from the exception for cases when the exception is a
        }  
            throwable.addSuppressed(in.readException());
        <E extends OpenSearchException> OpenSearchExceptionHandle(
    public OpenSearchException(String msg, Object... args) {
        message.append(']');  
        }  
        // Root causes are parsed in the innerFromXContent() and are added as suppressed exceptions.  
     */
             * for the user.  
        Throwable cause = getCause();
        } else {
    public void setShard(ShardId shardId) {  
        }  
        }
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {
    }
            sb.append(toString()).append("; ");
     */  
        /** returns a set of registered exception classes */
     * Returns the list of metadata values for the given key or {@code null} if no metadata for the  
                } else if (HEADER.equals(currentFieldName)) {
        final CheckedFunction<StreamInput, ? extends OpenSearchException, IOException> constructor;  
                sb.append(getCause());  
 * KIND, either express or implied.  See the License for the
     */
import org.opensearch.core.xcontent.XContentParser;
            throw new IllegalArgumentException("exception headers must not start with [opensearch.], found [" + key + "] instead");
     * This method is usually used when the {@link Throwable} is rendered as a part of another XContent object, and its result can  
        return simpleName;
            generateThrowableXContent(builder, params, this);  
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
                org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper.class,
    }  
        if (key.startsWith(OPENSEARCH_PREFIX_KEY)) {  
                if (cause instanceof XContentParseException || cause instanceof OpenSearchException) {
import static java.util.Collections.singletonMap;
    }  
        if (shardId != null) {
            return new Index(index.get(0), index_uuid.get(0));  
            builder.startObject(HEADER);
        out.writeArray(exceptionWriter, throwable.getSuppressed());  
                                    if (token == XContentParser.Token.VALUE_STRING) {
            OpenSearchExceptionHandle> CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY = new ConcurrentHashMap<>();
    @SuppressWarnings("unchecked")
import java.util.concurrent.ConcurrentHashMap;
            o.writeOptionalString(v.getFileName());
        headers.putAll(in.readMapOfLists(StreamInput::readString, StreamInput::readString));  
            @Override
import org.opensearch.core.xcontent.XContentBuilder;  
import java.util.List;
            builder.endObject();  
     * Registry of ExceptionHandlers
        return innerFromXContent(parser, false);  
        if (getCause() != null) {  
        addMetadata(key, Arrays.asList(values));  
    @Override
    public static <T extends Throwable> T readStackTrace(T throwable, StreamInput in) throws IOException {  
    }
    /**
    /**
     */
    }
    /**
        }
            if (cause != null) {
     * Returns the root cause of this exception or multiple if different shards caused different exceptions
                    // support metadata key-pairs and metadata arrays of values.
     */  
            // TODO move subclasses that print out simple metadata to using addMetadata directly and support also numbers and booleans.  
        }  
     */
        if (index != null && index.isEmpty() == false) {
    public static void generateThrowableXContent(XContentBuilder builder, ToXContent.Params params, Throwable t) throws IOException {  
            List<String> index_uuid = getMetadata(INDEX_METADATA_KEY_UUID);
            return new StackTraceElement(declaringClasss, methodName, fileName, lineNumber);  
                org.opensearch.OpenSearchParseException::new,
                    }  
        readStackTrace(this, in);
            } else if (token == XContentParser.Token.START_OBJECT) {
        return ExceptionsHelper.unwrapCause(this);
                } else {
            if (cause != null) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                    if (i == 0) {  
                }
        };  
    public Index getIndex() {
                builder.field(key, values.get(0));
            simpleName = "OpenSearchException";  
        while (cause != null && cause != rootCause) {
        return builder.append(ExceptionsHelper.detailedMessage(this).trim()).toString();
     * Adds a new piece of metadata with the given key.
public class OpenSearchException extends RuntimeException implements Writeable, ToXContentFragment {  
     * {@link OpenSearchWrapperException}.
        /** returns a collection of handles */  
                org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper::new,
                            values.add(parser.text());
            addMetadata(INDEX_METADATA_KEY_UUID, index.getUUID());  
                    for (int j = 0; j < i; j++) {
        }
            ? extends OpenSearchException,
        if (throwable instanceof OpenSearchException exception) {  
        String simpleName = getExceptionSimpleClassName(ex);
        }
     * arguments  
    public List<String> getResourceId() {
            )  
            }
        }
        Throwable ex = ExceptionsHelper.unwrapCause(t);  
                    // copy it over here
        builder.startObject(ERROR);  
     * @param msg  the detail message
            return;  
        registerExceptionHandle(  
    private static final String TYPE = "type";
        }  
     * to control if the {@code caused_by} element should render. Unlike most parameters to {@code toXContent} methods this parameter is  
    public static final String REST_EXCEPTION_SKIP_STACK_TRACE = "rest.exception.stacktrace.skip";  
     * @param msg   the detail message
        /** returns the Exception constructor function from a given ordinal */  
            } else {
    public ShardId getShardId() {
            e.addSuppressed(s);
            return toString();
            CheckedFunction<StreamInput, ? extends OpenSearchException, IOException>> ID_TO_SUPPLIER_REGISTRY = new ConcurrentHashMap<>();  
    }  
        addMetadata(RESOURCE_METADATA_TYPE_KEY, type);
                                        values.add(parser.text());  
        StringBuilder builder = new StringBuilder();  
    public Throwable getRootCause() {
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.get(exception).id;
        List<String> shard = getMetadata(SHARD_METADATA_KEY);
        }  
        private static final Map<
        /** Gets the unique ordinal id of the Exception from the given class */
        registerExceptionHandle(  
                builder.endObject();  
        t = ExceptionsHelper.unwrapCause(t);
    /**
            if (openSearchExceptionHandle != null) {
 * license agreements. See the NOTICE file distributed with
 */
    public String getResourceType() {
        ) {  
        out.writeMapOfLists(headers, StreamOutput::writeString, StreamOutput::writeString);  
            OpenSearchExceptionHandle openSearchExceptionHandle = CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.get(exception);
     * return the original exception type (ie NodeClosedException for example) but just wraps
                    // and skipped, so that the parser does not fail on unknown fields. The parser only
 *  
    public static OpenSearchException innerFromXContent(XContentParser parser, boolean parseRootCauses) throws IOException {  
     * is returned.  
    public void addHeader(String key, String... value) {
     * or {@link #innerToXContent(XContentBuilder, ToXContent.Params, Throwable, String, String, Map, Map, Throwable)}.
/**  
        out.writeOptionalString(this.getMessage());  
     */
     * Retrieve the innermost cause of this exception, if none, returns the current exception.  
 * Licensed to Elasticsearch under one or more contributor  
            ose.toXContent(builder, params);
                org.opensearch.core.tasks.TaskCancelledException::new,  
                UNKNOWN_VERSION_ADDED
    @Override
     * Returns the list of header values for the given key or {@code null} if no header for the
            return ID_TO_SUPPLIER_REGISTRY.keySet();  
     * Returns a set of all header keys on this exception  
 *
            o.writeVInt(v.getLineNumber());
     * Return the detail message, including the message from the nested exception
                }  
        /** Registry mapping from Exception class to the Exception Handler  */
import static org.opensearch.OpenSearchException.OpenSearchExceptionHandleRegistry.registerExceptionHandle;
        return toUnderscoreCase(simpleName);  
            }
        Map<String, List<String>> headers,
     *  
     * The message can be parameterized using <code>{}</code> as placeholders for the given
    }
                    // Parse the array and add each item to the corresponding list of metadata.  
    static {
            o.writeString(v.getMethodName());  
             * We'd like to unwrap parsing exceptions to the inner-most
        super(cause);
        out.writeArray((o, v) -> {  
        // was the previous criteria to split headers in two sets
            }
        boolean changed = false;
                    metadata.put(currentFieldName, Collections.singletonList(parser.text()));
                generateThrowableXContent(builder, params, suppressed);  
                            parser.skipChildren();
        throws IOException {
        out.writeException(this.getCause());
            }
     * in id order. If you want to remove an exception leave a tombstone comment and mark the id as null in
        if (index != null) {
     * @opensearch.internal  
                        if (metadata.containsKey(currentFieldName)) {
            builder.field(ERROR, ExceptionsHelper.summaryMessage(unwrapped));  
            Version versionAdded
                                    }  
        }
import org.opensearch.core.ParseField;
                    }
    }
     * If the provided key is already present, the corresponding metadata will be replaced  
     *  
        }, throwable.getStackTrace());
    /**  
    }
                    cause = fromXContent(parser);  
    protected static void headerToXContent(XContentBuilder builder, String key, List<String> values) throws IOException {
        StringBuilder sb = new StringBuilder();
     * @see ExceptionsHelper#unwrapCause(Throwable)
        return opensearchException.apply(input);  
    public static final String OPENSEARCH_PREFIX_KEY = "opensearch.";
            return new ShardId(getIndex(), Integer.parseInt(shard.get(0)));
                org.opensearch.core.common.ParsingException::new,  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
            this.id = id;
            return header.get(0);  
     * given key exists.
                    }
 * ownership. Elasticsearch licenses this file to you under  
            if (metadata.containsKey(SHARD_METADATA_KEY)) {  
        }
    /**  
 * SPDX-License-Identifier: Apache-2.0
                    }
                builder.endArray();
    }
        }  
        return headers;  
        final Throwable cause = getCause();
    /**  
     * single exception tying the Class to an id for use of the encode side and the id back to a constructor for use on the decode side. As  
        for (Map.Entry<String, List<String>> entry : metadata.entrySet()) {
            innerToXContent(builder, params, t, getExceptionName(t), t.getMessage(), emptyMap(), emptyMap(), t.getCause());  
    /**  
            if (Character.isUpperCase(c)) {
        // Render the exception with a simple message  
        public static void registerExceptionHandle(final OpenSearchExceptionHandle handle) {  
    /**  
    /**
     */
    }
        }
import org.opensearch.core.index.shard.ShardId;
        return null;  
     */  
     */  
        }
                        }
     */
        generateThrowableXContent(builder, params, e);
    }
        XContentParser.Token token = parser.currentToken();  
                UNKNOWN_VERSION_ADDED
            builder.field(ERROR, "unknown");
        if (t instanceof OpenSearchException ose) {  
        if (metadata.containsKey(INDEX_METADATA_KEY)) {
    /**
            }
        String simpleName = ex.getClass().getSimpleName();
     * Generate a {@link OpenSearchException} from a {@link XContentParser}. This does not  
import org.opensearch.common.collect.Tuple;  
    }
                    }  
/*  
    /**
            this.constructor = constructor;  
                            } else if (token == XContentParser.Token.START_OBJECT) {
        StreamOutput out,  
        } else {
     * Parses the output of {@link #generateFailureXContent(XContentBuilder, Params, Exception, boolean)}  
    ) throws IOException {
     * This method will replace existing header if a header with the same key already exists
        OpenSearchException cause = null;
                }  
     * Returns the map of metadata keys and values.
            return ExceptionsHelper.status(cause);
    /**
     * depends on the value of the "detailed" parameter: when it's false only a simple message based on the type and message of the  
        super(LoggerMessageFormat.format(msg, args), cause);  
    private static final String CAUSED_BY = "caused_by";  
    protected static final Version UNKNOWN_VERSION_ADDED = Version.fromId(0);
                        } else {  
import org.opensearch.core.xcontent.ToXContent;
        OpenSearchException e = new OpenSearchException(buildMessage(type, reason, stack), cause) {
            for (Throwable suppressed : allSuppressed) {
        return throwable;
            }
                        } else {
            Class<E> exceptionClass,
            String currentFieldName = parser.currentName();  
    }
    /**  
        final int id;
    }
                        suppressed.add(fromXContent(parser));  
     */  
            }
            int id,
        Throwable[] allSuppressed = throwable.getSuppressed();
                builder.startArray(key);  
                146,
 *    http://www.apache.org/licenses/LICENSE-2.0
                UNKNOWN_VERSION_ADDED  
        } else {
        if (opensearchException == null) {  
        Map<String, List<String>> metadata = new HashMap<>();  
     * if there is one.  
     * Passed in the {@link ToXContent.Params} of {@link #generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}
                            if (token == XContentParser.Token.VALUE_STRING) {
                35,
        Writer<Throwable> exceptionWriter
    ) throws IOException {
     *
    public static OpenSearchException failureFromXContent(XContentParser parser) throws IOException {
    }  
        return getExceptionName(this);  
                sb.append(ose.getDetailedMessage());
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        final Tuple<Integer, Class<? extends OpenSearchException>>[] ts = OpenSearchExceptionHandleRegistry.handles()
                        sb.append(Character.toLowerCase(c));
            new OpenSearchExceptionHandle(  
                } else if (REASON.equals(currentFieldName)) {  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
                org.opensearch.core.common.ParsingException.class,
            rootCause = cause;  
            for (OpenSearchException rootCause : rootCauses) {  
            return new OpenSearchException(buildMessage("exception", parser.text(), null)) {
 * Modifications Copyright OpenSearch Contributors. See
     * trace.
    }
        // TODO: do we really need to make the exception name in underscore casing?
                org.opensearch.OpenSearchParseException.class,  
/*  
        if (index != null) {
    public Set<String> getMetadataKeys() {
    /**
        addMetadata(RESOURCE_METADATA_ID_KEY, id);  
                if (TYPE.equals(currentFieldName)) {
        public static Set<Integer> ids() {
        message.append(REASON).append('=').append(reason);
            ID_TO_SUPPLIER_REGISTRY.put(handle.id, handle.constructor);
 * the Apache License, Version 2.0 (the "License"); you may
    public static OpenSearchException[] guessRootCauses(Throwable t) {
        }
/*
    private static final String RESOURCE_METADATA_TYPE_KEY = "opensearch.resource.type";  
        if (values != null && values.isEmpty() == false) {
            Throwable cause = ex.getCause();
            // Those key-value pairs become part of the metadata set and inherit the "opensearch." prefix as that is currently required
        builder.field(REASON, message);  
                org.opensearch.core.tasks.TaskCancelledException.class,
        }  
    /**
        return OpenSearchExceptionHandleRegistry.getRegisteredKeys();
                org.opensearch.core.common.breaker.CircuitBreakingException.class,  
            exception.metadataToXContent(builder, params);
                    builder.value(value);
        }, StackTraceElement[]::new));
import org.opensearch.core.index.Index;
                UNKNOWN_VERSION_ADDED  
    /**  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                UNKNOWN_VERSION_ADDED
        // No exception to render as an error  
    /**
        if (detailed == false) {
            Class<? extends OpenSearchException>,  
            return ose.guessRootCauses();
    }
     * @opensearch.internal
     * such its ok if the exceptions to change names so long as their constructor can still read the exception. Each exception is listed
        List<String> header = getMetadata(RESOURCE_METADATA_TYPE_KEY);  
        return OpenSearchExceptionHandleRegistry.getId(exception);  
     * Returns an underscore case name for the given exception. This method strips {@code OpenSearch} prefixes from exception names.
     * exception is rendered. When it's true all detail are provided including guesses root causes, cause and potentially stack
    private static String toUnderscoreCase(String value) {  
        );
            if (getCause() instanceof OpenSearchException ose) {  
        XContentParser.Token token = parser.nextToken();
        public static int getId(final Class<? extends OpenSearchException> exception) {  
    }
    /**
        if (e == null) {
        return headers.keySet();  
                }
        }
     * Construct a <code>OpenSearchException</code> with the specified cause exception.
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        );
    protected String getExceptionName() {
                    sb.append('_');
            T,  
        return rootCause;  
        return new OpenSearchException[] { new OpenSearchException(ex.getMessage(), ex) {  
        }
    }
    }
    /**
        }
        // after parsing and can be retrieved using getSuppressed() method.  
     * ExceptionSerializationTests.testIds.ids.  
    public void addMetadata(String key, List<String> values) {
        {
                if (CAUSED_BY.equals(currentFieldName)) {
                org.opensearch.core.common.breaker.CircuitBreakingException::new,
        if (ex instanceof XContentParseException) {
    }
    private static final String INDEX_METADATA_KEY_UUID = "opensearch.index_uuid";  
        token = parser.nextToken();
            }
        return metadata.get(key);
        return builder;
            setIndex(new Index(index, Strings.UNKNOWN_UUID_VALUE));  
    private static final String HEADER = "header";  
                builder.startObject();
        T throwable,
     * Returns the rest status code associated with this exception.
    // lower cases and adds underscores to transitions in a name
    public static void generateFailureXContent(XContentBuilder builder, ToXContent.Params params, @Nullable Exception e, boolean detailed)
     * This method is usually used when the {@link Exception} is rendered as a full XContent object, and its output can be parsed
    }  
    }
                    }
     * This is the list of Exceptions OpenSearch can throw over the wire or save into a corruption marker. Each value in the enum is a
        }
     * be parsed back using the {@code OpenSearchException.fromXContent(XContentParser)} method.
    public List<String> getMetadata(String key) {  
     * provided for every registered exception.
@PublicApi(since = "1.0.0")
        ToXContent.Params params,  
        }
     */
        Throwable cause  
            e.addMetadata(OPENSEARCH_PREFIX_KEY + entry.getKey(), entry.getValue());
 * software distributed under the License is distributed on an
        Throwable rootCause = this;  
    /**
            e.addSuppressed(rootCause);
                if (parseRootCauses && ROOT_CAUSE.equals(currentFieldName)) {  
            builder.append(getIndex());
        }
 * The OpenSearch Contributors require contributions made to  
        return innerFromXContent(parser, true);
            if (values.size() == 1) {  
        }
 * compatible open source license.
            )
     *
import org.opensearch.core.rest.RestStatus;  
    }
    public Set<String> getHeaderKeys() {
        return metadata;
                    reason = parser.text();
        }  
                UNKNOWN_VERSION_ADDED
    }
    public String getDetailedMessage() {
            final int lineNumber = i.readVInt();
    }  
             * an OpenSearchException we'd like to keep unwrapping because
            )
import org.opensearch.common.annotation.PublicApi;
        for (; token == XContentParser.Token.FIELD_NAME; token = parser.nextToken()) {
    }
        if (ex != this) {
    public OpenSearchException(String msg, Throwable cause, Object... args) {
     */  
     */  
                            currentFieldName = parser.currentName();
                builder.append('[').append(getShardId()).append(']');
import static java.util.Collections.emptyMap;  
     */
import java.io.IOException;
        return headers.get(key);
    private static final String ERROR = "error";
    /**
                0,  
                } else if (token == XContentParser.Token.VALUE_STRING) {
        }
     */
    public void writeTo(final StreamOutput out) throws IOException {
                builder.endObject();
        }  
    }
     * to control if the {@code stack_trace} element should render. Unlike most parameters to {@code toXContent} methods this parameter is  
            throw new IllegalArgumentException("exception metadata must start with [opensearch.], found [" + key + "] instead");
        builder.field(TYPE, type);
    protected final Map<String, List<String>> headers = new HashMap<>();
        if (simpleName.startsWith("OpenSearch")) {
            .stream()
            }
     * Returns the root cause of this exception or multiple if different shards caused different exceptions.
    public OpenSearchException(Throwable cause) {
     * @param args the arguments for the message  
                    // Any additional metadata object added by the metadataToXContent method is ignored  
             * exception to return to the user. If that exception is caused by  
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
     * arguments
    static Tuple<Integer, Class<? extends OpenSearchException>>[] classes() {  
                org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException.class,
                builder.startObject();
import org.opensearch.core.common.logging.LoggerMessageFormat;  
    /**
     * If the provided key is already present, the corresponding metadata will be replaced
                    List<String> values = new ArrayList<>();
            char c = value.charAt(i);
             * OpenSearchException instances tend to contain useful information
            final String methodName = i.readString();
    }  
                            headers.put(currentFieldName, values);
     * Deserializes stacktrace elements as well as suppressed exceptions from the given output stream and  
            new OpenSearchExceptionHandle(
            /*  
                builder.endObject();  
 * @opensearch.api  
import org.opensearch.common.Nullable;
            return RestStatus.INTERNAL_SERVER_ERROR;  
                                    } else {
        public static CheckedFunction<StreamInput, ? extends OpenSearchException, IOException> getSupplier(final int id) {
             */
    /**
    }  
     * adds it to the given exception.
        }
    public Map<String, List<String>> getHeaders() {
        }
     * Construct a <code>OpenSearchException</code> with the specified detail message.  
        }
     * <p>  
 * this work for additional information regarding copyright
            return;
     *
     */  
                if (changed) {
    public Map<String, List<String>> getMetadata() {
        if (params.paramAsBoolean(REST_EXCEPTION_SKIP_CAUSE, REST_EXCEPTION_SKIP_CAUSE_DEFAULT) == false) {
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.values();
 * GitHub history for details.
    }
        }
    public static <T extends StreamInput> OpenSearchException readException(T input, int id) throws IOException {
                    parser.skipChildren();  
        }  
    public static final boolean REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT = true;
    public static <S extends StreamOutput, T extends Throwable> T writeStackTraces(
                    }  
        if (cause == this) {
     * @param args  the arguments for the message  
            CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.put(handle.exceptionClass, handle);
        if (header != null && header.isEmpty() == false) {
            // subclasses can print out additional metadata through the metadataToXContent method. Simple key-value pairs will be
            builder.endArray();  
        builder.endObject();
        /** Registry mapping from unique Ordinal to the Exception Constructor */  
     */
    public Throwable unwrapCause() {  
            new OpenSearchExceptionHandle(
        metadata.putAll(in.readMapOfLists(StreamInput::readString, StreamInput::readString));
    }  
    }
 * You may obtain a copy of the License at  
            builder.field(STACK_TRACE, ExceptionsHelper.stackTrace(throwable));
    public static final String STACK_TRACE = "stack_trace";
import org.opensearch.core.xcontent.ToXContentFragment;
        message.append(TYPE).append('=').append(type).append(", ");
            new OpenSearchExceptionHandle(
            setIndex(shardId.getIndex());
     * Returns an array of all registered handle IDs. These are the IDs for every registered
    }
            return ose.guessRootCauses();  
     * <p>
            )
            builder.append(' ');  
    static Set<Class<? extends OpenSearchException>> getRegisteredKeys() { // for testing
     */
    /**
        // Adds root causes as suppressed exception. This way they are not lost
     * Returns the serialization id the given exception.  
 */  
    }
        // Render the exception with all details
        /** checks that the exception class is registered */
        registerExceptionHandle(
     * If the given exception is not an instance of {@link OpenSearchException} an empty array
            Integer,
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {}  
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {  
                    // Arrays of objects are not supported yet and just ignored and skipped.
                builder.field(CAUSED_BY);  
import java.util.Collections;
        Map<String, List<String>> metadata,
import java.util.Collection;
                if (!changed) {  
    public void addHeader(String key, List<String> value) {  
            new OpenSearchExceptionHandle(
 *
            }
import java.util.HashMap;  
            simpleName = simpleName.substring("OpenSearch".length());  
        private static final Map<
                org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException::new,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
    }
        );
     *
        XContentParser.Token token = parser.currentToken();
     */
import org.opensearch.core.common.Strings;
     * Render any exception as a xcontent, encapsulated within a field or object named "error". The level of details that are rendered
        this(in.readOptionalString(), in.readException());
                                parser.skipChildren();  
        if (headers.isEmpty() == false) {
    /**
     */  
        }  
        }
        for (int i = 0; i < numSuppressed; i++) {
     * Serializes the given exceptions stacktrace elements as well as it's suppressed exceptions to the given output stream.
            IOException>) OpenSearchExceptionHandleRegistry.getSupplier(id);
     * internal only and not available as a URL parameter.
                    type = parser.text();
                builder.startObject();
     * Adds a new header with the given key.
                }
        XContentBuilder builder,
                generateThrowableXContent(builder, params, cause);
                } else {
        registerExceptionHandle(
            }
            )  
            message.append(", ").append(STACK_TRACE).append('=').append(stack);
                            } else if (token == XContentParser.Token.START_ARRAY) {  
                }  
        }
        }  
     * This method will replace existing header if a header with the same key already exists
    }
import org.opensearch.core.xcontent.XContentParseException;
            builder.startArray(SUPPRESSED.getPreferredName());  
        List<OpenSearchException> rootCauses = new ArrayList<>();
     * Adds a new piece of metadata with the given key.
            addMetadata(SHARD_METADATA_KEY, Integer.toString(shardId.id()));  
                                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        }
        public static Set<Class<? extends OpenSearchException>> getRegisteredKeys() { // for testing  
        /** registers the Exception handler */
                        sb.append('_');  
     * Returns the map of header keys and values.  
        } };
                return getExceptionName(getCause());  
        }
import java.util.Set;  
     * instances.
     */
                        }
     *
        Map<String, List<String>> headers = new HashMap<>();
            e.addHeader(header.getKey(), header.getValue());
            token = parser.nextToken();
            return CLASS_TO_OPENSEARCH_EXCEPTION_HANDLE_REGISTRY.keySet();
        );  
                        if (token == XContentParser.Token.VALUE_STRING) {
                    sb.append(Character.toLowerCase(c));
     * Static toXContent helper method that renders {@link OpenSearchException} or {@link Throwable} instances
     * and nested exception.
     * <p>
 * Unless required by applicable law or agreed to in writing,
        }  
    }  
        if (params.paramAsBoolean(REST_EXCEPTION_SKIP_STACK_TRACE, REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT) == false) {  
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            final String declaringClasss = i.readString();
     * Renders additional per exception information into the XContent
                            }
            innerToXContent(builder, params, this, getExceptionName(), getMessage(), headers, metadata, getCause());
    private static final String SHARD_METADATA_KEY = "opensearch.shard";
     * Returns a set of all metadata keys on this exception
            // TODO rename metadataToXContent and have only SearchPhaseExecutionException use it, which prints out complex objects
            }
 * specific language governing permissions and limitations
     */  
        );  
        }
                62,  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
             * parsing exception because that is generally the most interesting
            return sb.toString();
     * @return an array of all registered pairs of handle IDs and exception classes  
        }
     * Passed in the {@link ToXContent.Params} of {@link #generateThrowableXContent(XContentBuilder, ToXContent.Params, Throwable)}
        super(LoggerMessageFormat.format(msg, args));  
    private static final String RESOURCE_METADATA_ID_KEY = "opensearch.resource.id";
 */  
    public void setIndex(String index) {
    public static class OpenSearchExceptionHandleRegistry {
import java.util.Arrays;  
        );
            throw new IllegalStateException("unknown exception for id: " + id);
    /**  
    /**  
        out.writeMapOfLists(metadata, StreamOutput::writeString, StreamOutput::writeString);
        if (token.isValue()) {
        if (key.startsWith(OPENSEARCH_PREFIX_KEY) == false) {
                    } else {
     */
            headerToXContent(builder, entry.getKey().substring(OPENSEARCH_PREFIX_KEY.length()), entry.getValue());  
        return sb.toString();
            // We need the exceptionClass because you can't dig it out of the constructor reliably.
    private static final String REASON = "reason";
        if (ex instanceof OpenSearchException ose) {
import org.opensearch.core.common.io.stream.StreamInput;  
                40,
    }
            CheckedFunction<StreamInput, E, IOException> constructor,  
    /**
        String type = null, reason = null, stack = null;
     * <p>  
        for (int i = 0; i < value.length(); i++) {  
     * The message can be parameterized using <code>{}</code> as placeholders for the given
    protected static class OpenSearchExceptionHandle {
     * Returns <code>true</code> iff the given class is a registered for an exception to be read.
    private static final String REST_EXCEPTION_SKIP_CAUSE = "rest.exception.cause.skip";  
        CheckedFunction<T, ? extends OpenSearchException, IOException> opensearchException = (CheckedFunction<
        assert type != null;
        // was the previous criteria to split headers in two sets  
            assert header.size() == 1;
    private static final ParseField SUPPRESSED = new ParseField("suppressed");
import java.util.ArrayList;
                for (String value : values) {
        for (OpenSearchException rootCause : rootCauses) {
        return message.toString();
                }  
            // parsed back and become part of this metadata set, while objects and arrays are not supported when parsing back.  
    /**
     * given key exists.
    public static OpenSearchException fromXContent(XContentParser parser) throws IOException {  
            final String fileName = i.readOptionalString();  
     * @return an array of all registered handle IDs
                        }  
                        rootCauses.add(fromXContent(parser));
        return metadata.keySet();
 *
        int numSuppressed = in.readVInt();  
                            values.addAll(metadata.get(currentFieldName));  
    private static final boolean REST_EXCEPTION_SKIP_CAUSE_DEFAULT = false;
     */
                rootCause.toXContent(builder, new ToXContent.DelegatingMapParams(singletonMap(REST_EXCEPTION_SKIP_CAUSE, "true"), params));
        Throwable throwable,
            // by addMetadata. The prefix will get stripped out when printing metadata out so it will be effectively invisible.
            .map(h -> Tuple.tuple(h.id, h.exceptionClass))  
            StringBuilder sb = new StringBuilder();
}
        }  
            } else {
     * internal only and not available as a URL parameter. Use the {@code error_trace} parameter instead.
    public static String getExceptionName(Throwable ex) {  
    public OpenSearchException[] guessRootCauses() {
    }
    public void setIndex(Index index) {  
import java.util.Map;
            return false;
     */
        return throwable;
     */
    public RestStatus status() {  
        if (cause instanceof OpenSearchException ose) {  
            if (token.isValue()) {  
    public void setResources(String type, String... id) {
            addMetadata(INDEX_METADATA_KEY, index.getName());
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            this.exceptionClass = exceptionClass;
     */
            return value;
     */
        final OpenSearchException[] rootCauses = OpenSearchException.guessRootCauses(e);
        throwable.setStackTrace(in.readArray(i -> {
    }
        if (Strings.isEmpty(simpleName)) {
    protected static void innerToXContent(
    public String toString() {
        List<OpenSearchException> suppressed = new ArrayList<>();  
        token = parser.nextToken();  
            } else if (token == XContentParser.Token.START_ARRAY) {
        // we need to enforce this otherwise bw comp doesn't work properly, as "opensearch."
    static int[] ids() {
        this.metadata.put(key, values);
                return version.onOrAfter(openSearchExceptionHandle.versionAdded);  
        final Class<? extends OpenSearchException> exceptionClass;
        final Version versionAdded;
            o.writeString(v.getClassName());
    }
    public void addMetadata(String key, String... values) {
        Throwable ex = ExceptionsHelper.unwrapCause(this);
        List<String> index = getMetadata(INDEX_METADATA_KEY);  
        return new OpenSearchException[] { this };  
        public static Collection<OpenSearchExceptionHandle> handles() {
                        sb.append(value.charAt(j));  
        registerExceptionHandle(
    }  
            new OpenSearchExceptionHandle(  
                headerToXContent(builder, entry.getKey(), entry.getValue());
    protected final Map<String, List<String>> metadata = new HashMap<>();
        }  
        // we need to enforce this otherwise bw comp doesn't work properly, as "opensearch."
            };  
        return getMetadata(RESOURCE_METADATA_ID_KEY);
        if (allSuppressed.length > 0) {
     * Construct a <code>OpenSearchException</code> with the specified detail message
            // OpenSearchException knows how to guess its own root cause
    public List<String> getHeader(String key) {
                        sb.append(Character.toLowerCase(c));
                    return OpenSearchException.guessRootCauses(ex.getCause());
