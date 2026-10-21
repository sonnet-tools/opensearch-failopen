     */
 * software distributed under the License is distributed on an
     * elements.
            }
    public UpdateRequest doc(byte[] source, MediaType mediaType) {
     */
     * "include" and/or "exclude" set which can include simple wildcard
     * Sets the doc to use for updates when a script is not specified.
    public IndexRequest doc() {
        if (ifSeqNo != UNASSIGNED_SEQ_NO) {
    public ActionRequestValidationException validate() {
    }
     * @deprecated Use {@link #script()} instead
     * use script params if possible with the same (automatically compiled) script.
     * includes field and value pairs.
 */
     * Sets the doc to use for updates when a script is not specified.
    @Deprecated
     * If the document last modification was assigned a different term a
     */
            }
    }
     */
        return this;
        }
            docBuilder.copyCurrentStructure(parser);
    public UpdateRequest script(String script, ScriptType scriptType) {
 * @opensearch.api
    /**
     * (automatically compiled) script.
        return this.doc;
     * (automatically compiled) script.
     * Sets the number of retries of a version conflict occurs because the document was updated between
    public List<IndexRequest> getChildIndexRequests() {
        PARSER.declareBoolean(UpdateRequest::detectNoop, DETECT_NOOP_FIELD);
        @Nullable Map<String, Object> scriptParams
        if (hasScript) {
        return this.scriptedUpsert;
     * @return this for chaining
        if (script != null && doc != null) {
            res.append(", doc[").append(doc).append("]");
        return this;
    private IndexRequest safeDoc() {
        this.requireAlias = requireAlias;
    @Nullable
     * If the document last modification was assigned a different sequence number a
     */
     */
    private IndexRequest doc;
     * times and instead use script params if possible with the same
    /**
    private static final ParseField SOURCE_FIELD = new ParseField("_source");
        out.writeBoolean(hasScript);
            out.writeBoolean(false);
            if (thin) {
        return this;
                XContentParser parser = XContentHelper.createParser(
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        return SHALLOW_SIZE + RamUsageEstimator.sizeOf(id) + childRequestBytes;
    public UpdateRequest docExtraFieldValues(ExtraFieldValues values) {
    public String id() {
            builder.field("detect_noop", detectNoop);
            res.append(", script[").append(script).append("]");
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }, UPSERT_FIELD);
    private boolean requireAlias = false;
            } else {
     * and not the id.
        out.writeBoolean(scriptedUpsert);
        return this;
     */
    /**
    public UpdateRequest() {}
        return this.script == null ? null : this.script.getParams();
        this.scriptedUpsert = scriptedUpsert;
    public UpdateRequest script(String script) {
        super.writeThin(out);
        routing = in.readOptionalString();
    }
        if (upsertRequest != null) {
     * is a field and value pairs.
     */
     */
import org.opensearch.core.common.io.stream.StreamInput;
    public void writeThin(StreamOutput out) throws IOException {
                    NamedXContentRegistry.EMPTY,
     * Sets the doc to use for updates when a script is not specified.
    @Deprecated
     * Sets the doc to use for updates when a script is not specified.
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}
        DocWriteRequest<UpdateRequest>,
        updateOrCreateScript(script, scriptType, null, null);
    public UpdateRequest upsert(Object... source) {
     * times and instead use script params if possible with the same
     */
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
        safeDoc().source(source, offset, length, mediaType);
     * @deprecated Use {@link #script(Script)} instead
        } else {
            validationException = addValidationError("can't provide both script and doc", validationException);
            // make sure the basics are set
     * Sets the doc source of the update request to be used when the document does not exists.
    private static final ParseField DOC_AS_UPSERT_FIELD = new ParseField("doc_as_upsert");
                    LoggingDeprecationHandler.INSTANCE,
        safeUpsertRequest().source(source);
 * GitHub history for details.
    }
        safeDoc().source(source);
    }
import org.opensearch.core.ParseField;
     * @param scriptType
        return this.script == null ? null : this.script.getType();
        }
    /**
        if (upsertRequest != null) {
        if (script == null && doc == null) {
            } else {
            }
            SOURCE_FIELD,
     */
     */
        }
        refreshPolicy = RefreshPolicy.readFrom(in);
     */
import org.opensearch.action.support.single.instance.InstanceShardOperationRequest;
        return this.shardId;
                    mediaType
    private static final ParseField UPSERT_FIELD = new ParseField("upsert");
        out.writeOptionalWriteable(fetchSourceContext);
    @Override
        safeUpsertRequest().extraFieldValues(values);
 * Modifications Copyright OpenSearch Contributors. See
        PARSER.declareObject((request, builder) -> request.safeDoc().source(builder), (parser, context) -> {
        this.script = new Script(scriptType, scriptLang, script, scriptParams);
import org.opensearch.core.xcontent.XContentBuilder;
    }
     */
     * Sets the doc to use for updates when a script is not specified.
    /**
    private boolean detectNoop = true;
    @Deprecated
 * ownership. Elasticsearch licenses this file to you under
            childRequestBytes += upsertRequest.ramBytesUsed();
     *            An optional list of include (optionally wildcarded) pattern to
     * Sets the doc to use for updates when a script is not specified, the doc provided
    }
import org.opensearch.action.index.IndexRequest;
        safeDoc().extraFieldValues(values);
     * Sets the id of the indexed document.
import org.opensearch.core.common.io.stream.StreamOutput;
     * Add a script parameter.
        res.append(", detect_noop[").append(detectNoop).append("]");
    private long ifSeqNo = UNASSIGNED_SEQ_NO;
        this.fetchSourceContext = context;
        if (script != null) {
    }
    /**
     * (automatically compiled) script.
        if (doc == null) {
     */
            childRequestBytes += doc.ramBytesUsed();
        }
            HashMap<String, Object> scriptParams = new HashMap<>();
        safeUpsertRequest().source(source);
        ScriptType scriptType,
import org.opensearch.script.ScriptType;
     * Gets the {@link FetchSourceContext} which defines how the _source should
            if (docAsUpsert) {
                    mediaType
    }
        long childRequestBytes = 0;
        }
        );
        return this;
     *
                updateOrCreateScript(null, null, null, scriptParams);
        waitForActiveShards = ActiveShardCount.readFrom(in);
     * @deprecated Use {@link #script()} instead
        }
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
                    doc.source(),
    @Deprecated
    }
            doc = new IndexRequest(shardId, in);
     *            filter the returned _source
    /**
    public UpdateRequest upsert(byte[] source, MediaType mediaType) {
     * The script to execute. Note, make sure not to send different script each
        super(index);
     */
    }
        this.script = script;
        out.writeBoolean(requireAlias);
     */
        }
    public ScriptType scriptType() {
        return this;
     * {@link org.opensearch.index.engine.DocumentMissingException} is thrown.
            throw new IllegalArgumentException("sequence numbers must be non negative. got [" + seqNo + "].");
        return this;
                builder.copyCurrentStructure(parser);
        safeUpsertRequest().source(source, offset, length, mediaType);
import org.opensearch.index.mapper.MapperService;
            ObjectParser.ValueType.OBJECT_ARRAY_BOOLEAN_OR_STRING
                builder.field("doc");
        return upsertRequest;
 * Licensed to Elasticsearch under one or more contributor
     * is a field and value pairs.
            builder.copyCurrentStructure(parser);
    }
    public UpdateRequest doc(XContentBuilder source) {
     *            An optional exclude (optionally wildcarded) pattern to filter
        return validationException;
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(UpdateRequest.class);
    @Override
            childIndexRequests.add(upsertRequest);
     *
        // ExtraFieldValues not supported for scripted updates for now
            upsertRequest.index(index);
        this.retryOnConflict = retryOnConflict;
            validationException = addValidationError("id is missing", validationException);
 * Transport request for updating an index
        id = in.readString();
     * {@code null} clears the values and resets to {@link ExtraFieldValues#EMPTY}.
     *            filter the returned _source
    public UpdateRequest scriptedUpsert(boolean scriptedUpsert) {
            scriptParams.put(name, value);
     * includes field and value pairs.
            MediaType mediaType = doc.getContentType();
     * @deprecated Use {@link #script(Script)} instead
     *
    @Override
            upsertRequest = new IndexRequest(index);
    }
    }
        return this;
    }
        this.doc = doc;
     */
            ScriptType newScriptType = type == null ? script.getType() : type;
    @Override
        return this.upsertRequest;
 */
        }
    public ActiveShardCount waitForActiveShards() {
        builder.endObject();
    public UpdateRequest versionType(VersionType versionType) {
                validationException = addValidationError("ExtraFieldValues are not supported with scripted updates", validationException);
 *
     *
        updateOrCreateScript(script, ScriptType.INLINE, null, null);
                scriptParams.put(name, value);
    /**
    @Deprecated
    }
            if (retryOnConflict > 0) {
    public UpdateRequest upsert(byte[] source, int offset, int length, MediaType mediaType) {
            ObjectParser.ValueType.OBJECT_OR_STRING
            out.writeBoolean(true);
import org.opensearch.common.lucene.uid.Versions;
    }
    }
     * Sets the doc source of the update request to be used when the document does not exists.
     *
        return id;
        if (upsertRequest != null) {
        if (Strings.isEmpty(id)) {
            this.routing = routing;
    private RefreshPolicy refreshPolicy = RefreshPolicy.NONE;
    @Deprecated
     */
    /**
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
    public boolean docAsUpsert() {
        return PARSER.parse(parser, this, null);
                XContentParser parser = XContentHelper.createParser(
     * Should this update attempt to detect if it is a noop? Defaults to true.
                )
        this.upsertRequest = upsertRequest;
    /**
     * Sets the doc source of the update request to be used when the document does not exists.
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    /**
            validationException = addValidationError("script or doc is missing", validationException);
        StringBuilder res = new StringBuilder().append("update {[").append(index).append("][").append(id).append("]");
    }
     * Sets extra field values for the upsert document ({@code upsert}).
    public UpdateRequest detectNoop(boolean detectNoop) {
     */
     *
    public UpdateRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
        return script == null ? null : script.getLang();
    @Override
        return VersionType.INTERNAL;
        safeDoc().source(mediaType, source);
        refreshPolicy.writeTo(out);
            UpdateRequest::fetchSource,
        }
 * specific language governing permissions and limitations
                    upsertRequest.source(),
     * Sets the doc source of the update request to be used when the document does not exists.
    public UpdateRequest docAsUpsert(boolean shouldUpsertDoc) {
                scriptParams.put(name, value);
        return this;
        return this;
        this.refreshPolicy = refreshPolicy;
        script(script);
        }
    }
        out.writeBoolean(detectNoop);
        this.fetchSourceContext = new FetchSourceContext(context.fetchSource(), includes, excludes);
        String script,
        return this;
        Script script = script();
     * The script to execute. Note, make sure not to send different script each
     * Sets the doc source of the update request to be used when the document does not exists.
     */
        if (doc != null) {
            builder.field("script", script);
     */
                validationException = addValidationError(
     * elements.
     * @param script
    }
    }
    public UpdateRequest fetchSource(FetchSourceContext context) {
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * <p>
     * @param scriptParams
        if (script == null) {
import org.opensearch.action.support.ActiveShardCount;
    @Override
    }
    public UpdateRequest retryOnConflict(int retryOnConflict) {
    /**
        return this.script == null ? null : this.script.getIdOrCode();
    /**
 */
        PARSER.declareObject((request, builder) -> request.safeUpsertRequest().source(builder), (parser, context) -> {
            ) {
    }
     * Sets the script parameters to use with the script.
            script = new Script(newScriptType, newScriptLang, newScriptContent, newScriptParams);
    }
    }
    public UpdateRequest fetchSource(@Nullable String include, @Nullable String exclude) {
        PARSER.declareBoolean(UpdateRequest::scriptedUpsert, SCRIPTED_UPSERT_FIELD);
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                upsertRequest.writeThin(out);
    public UpdateRequest script(String script, ScriptType scriptType, @Nullable Map<String, Object> scriptParams) {
    @Override
     */
        }
        }
        }
     *
     */
    /**
    public FetchSourceContext fetchSource() {
    }
    /**
     * Indicate that _source should be returned with every hit, with an
    public UpdateRequest setRequireAlias(boolean requireAlias) {
        return this;
    public UpdateRequest setIfPrimaryTerm(long term) {
    public UpdateRequest routing(String routing) {
import org.opensearch.core.xcontent.ObjectParser;
        return this;
 * The OpenSearch Contributors require contributions made to
    private IndexRequest safeUpsertRequest() {
     * The id of the indexed document.
public class UpdateRequest extends InstanceShardOperationRequest<UpdateRequest>
        }
        return this;
    }
    public long ifSeqNo() {
     */
        }
     */
        doWrite(out, true);
     */
import org.opensearch.core.xcontent.XContentParser;
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}
            String newScriptContent = scriptContent == null ? script.getIdOrCode() : scriptContent;
        return this;
        }
     *
     * Indicates whether the response should contain the updated _source.
    /**
        List<IndexRequest> childIndexRequests = new ArrayList<>();
            out.writeBoolean(true);
        return detectNoop;
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
    }
 * Unless required by applicable law or agreed to in writing,
    public VersionType versionType() {
        safeUpsertRequest().source(source, mediaType);
import org.apache.lucene.util.RamUsageEstimator;
        res.append(", doc_as_upsert[").append(docAsUpsert).append("]");
            }
    public UpdateRequest doc(byte[] source, int offset, int length, MediaType mediaType) {
            upsertRequest.id(id);
        this.id = id;
     *
        return this.waitForActiveShards;
    public Map<String, Object> scriptParams() {
     * only performs this update request if the document's last modification was assigned the given
     * and not the id.
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        return this;
    /**
            childIndexRequests.add(doc);
                    "upsert requests don't support `if_seq_no` and `if_primary_term`",
     */
        this.script = new Script(scriptType, Script.DEFAULT_SCRIPT_LANG, script, scriptParams);
        } else {
            if ((doc != null && !doc.extraFieldValues().isEmpty())
 * not use this file except in compliance with the License.
        return this.routing;
     */
    public int retryOnConflict() {
     * If set, only perform this update request if the document was last modification was assigned this primary term.
        if (out.getVersion().before(Version.V_2_0_0)) {
    /**
        return this;
            builder.field("doc_as_upsert", docAsUpsert);
    public long ifPrimaryTerm() {
import org.opensearch.index.VersionType;
        }
        return this;
 * You may obtain a copy of the License at
     *
     * Should this update attempt to detect if it is a noop? Defaults to true.
        validationException = DocWriteRequest.validateSeqNoBasedCASParams(this, validationException);
    public UpdateRequest(String index, String id) {
            validationException = addValidationError("can't provide version in upsert request", validationException);
        requireAlias = in.readBoolean();
    /**
    private String id;
        out.writeZLong(ifSeqNo);
    /**
    public UpdateRequest setIfSeqNo(long seqNo) {
        }
        }
        return this;
import java.io.IOException;
            }
        safeDoc().source(source, mediaType);
     * The order is deterministic.
        if (seqNo < 0 && seqNo != UNASSIGNED_SEQ_NO) {
        return res.append("}").toString();
     * @deprecated Use {@link #script(Script)} instead
    private String routing;
    }
    }
    private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
     */
            doc.id(id);
            script = new Script(in);
 * SPDX-License-Identifier: Apache-2.0
                    NamedXContentRegistry.EMPTY,
    }
    @Nullable
            doc = new IndexRequest(index);
    }
    private boolean scriptedUpsert = false;
        return this.script;
    public UpdateRequest script(
        safeUpsertRequest().source(source, mediaType);
        out.writeBoolean(docAsUpsert);
    public UpdateRequest version(long version) {
            if (scriptParams == null) {
        return this;
        if (in.readBoolean()) {
        }
            String newScriptLang = lang == null ? script.getLang() : lang;
    public UpdateRequest upsert(Map<String, Object> source) {
                );
            }
     */
        }
        }
        safeDoc().source(source);
        return this;
    public UpdateRequest scriptLang(String scriptLang) {
    private static final ParseField SCRIPTED_UPSERT_FIELD = new ParseField("scripted_upsert");
 *
    /**
     * getting it and updating it. Defaults to 0.
     */
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        safeDoc().source(source, mediaType);
        if (doc == null) {
                scriptParams = new HashMap<>();
     */
        if (doc != null) {
        ActionRequestValidationException validationException = super.validate();
        ifSeqNo = in.readZLong();
    public UpdateRequest upsert(XContentBuilder source) {
    public boolean scriptedUpsert() {
        return this;
    /**
    private void updateOrCreateScript(String scriptContent, ScriptType type, String lang, Map<String, Object> params) {
        }
     */
        safeDoc().source(source, mediaType);
    private static final ParseField IF_SEQ_NO = new ParseField("if_seq_no");
        );
    /**
        out.writeVInt(retryOnConflict);
                validationException = addValidationError("compare and write operations can not be used with upsert", validationException);
import org.opensearch.script.Script;
    private void doWrite(StreamOutput out, boolean thin) throws IOException {
    /**
    }
            }
                || (upsertRequest != null && !upsertRequest.extraFieldValues().isEmpty())) {
        return ifPrimaryTerm;
     */
        safeUpsertRequest().source(source);
     * @param scriptLang
@PublicApi(since = "1.0.0")
            out.writeBoolean(false);
    }
     * Gets all valid child index requests for the update request.
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(parser.contentType());
        return this;
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
     */
        Script script = script();
    }
    }
        return this;
import static org.opensearch.action.ValidateActions.addValidationError;
        return this;
    /**
        return this;
    /**
    public UpdateRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    }
     * Explicitly set the fetch source context for this request
     */
    public UpdateRequest id(String id) {
     */
        PARSER.declareField(
        return requireAlias;
            updateOrCreateScript(null, null, null, scriptParams);
        } else {
        WriteRequest<UpdateRequest>,
            if (thin) {
        String[] excludes = exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude };
        if (upsertRequest == null) {
    /**
        @Nullable String scriptLang,
            SCRIPT_FIELD,
}
            } else {
    /**
import org.opensearch.action.ActionRequestValidationException;
        throw new UnsupportedOperationException("update requests do not support versioning");
     * @deprecated Use {@link #script()} instead
        return refreshPolicy;
/*
        this.detectNoop = detectNoop;
            return docBuilder;
        if (ifSeqNo != UNASSIGNED_SEQ_NO) {
            builder.field(IF_PRIMARY_TERM.getPreferredName(), ifPrimaryTerm);
        PARSER.declareField(
        if (doc != null) {
    @Deprecated
        docAsUpsert = in.readBoolean();
    private static final ParseField DOC_FIELD = new ParseField("doc");
    public UpdateRequest doc(Map<String, Object> source) {
            (parser, context) -> Script.parse(parser),
    public UpdateRequest upsertExtraFieldValues(ExtraFieldValues values) {
        if (upsertRequest != null) {
        if (script != null) {
        waitForActiveShards.writeTo(out);
    }
    }
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
        PARSER.declareBoolean(UpdateRequest::docAsUpsert, DOC_AS_UPSERT_FIELD);
     *            The script parameters
    private int retryOnConflict = 0;
     * Sets the index request to be used if the document does not exists. Otherwise, a
    }
    @Override
    @Override
     */
    /**
        } else {
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
    }
     *            The script type
    private static final ParseField SCRIPT_FIELD = new ParseField("script");
    }
    public UpdateRequest script(Script script) {
        if (upsertRequest != null && upsertRequest.version() != Versions.MATCH_ANY) {
        }
        return fetchSourceContext;
import java.util.HashMap;
            throw new IllegalArgumentException("primary term must be non negative. got [" + term + "]");
     */
    /**
import org.opensearch.core.xcontent.MediaType;
    /**
        this.waitForActiveShards = waitForActiveShards;
    /**
        return this;
        ifPrimaryTerm = term;
     * @param includes
        return this;
    public String scriptString() {
            script = new Script(type == null ? ScriptType.INLINE : type, lang, scriptContent == null ? "" : scriptContent, params);
    }
     * @deprecated Use {@link #script()} instead
            builder.field("_source", fetchSourceContext);
    @Nullable
    }
        updateOrCreateScript(null, null, null, scriptParams);
        } else {
    }
    }
    public long ramBytesUsed() {
    @Deprecated
        }
    static {
     *            An optional list of exclude (optionally wildcarded) pattern to
        boolean hasScript = script != null;
        out.writeVLong(ifPrimaryTerm);
    ) {
    Script script;
     * Sets extra field values for the partial document update ({@code doc}).
    }
    public IndexRequest upsertRequest() {
     * @return a list of index requests
    /**
     * Sets the doc to use for updates when a script is not specified.
        ifSeqNo = seqNo;
    }
        PARSER.declareLong(UpdateRequest::setIfSeqNo, IF_SEQ_NO);
     */
        String[] includes = include == null ? Strings.EMPTY_ARRAY : new String[] { include };
        if (upsertRequest == null) {
import org.opensearch.action.DocWriteRequest;
                    LoggingDeprecationHandler.INSTANCE,
            try (
                builder.field("upsert");
    public UpdateRequest(StreamInput in) throws IOException {
    }
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
    public UpdateRequest addScriptParam(String name, Object value) {
     * The script to execute. Note, make sure not to send different script each times and instead
     * The language of the script to execute.
    public void writeTo(StreamOutput out) throws IOException {
    private boolean docAsUpsert = false;
        this(null, in);
        safeUpsertRequest().source(source, mediaType);
     * Indicate that _source should be returned, with an
    }
            upsertRequest = new IndexRequest(shardId, in);
/*
            if (upsertRequest != null) {
        res.append(", scripted_upsert[").append(scriptedUpsert).append("]");
    public UpdateRequest waitForActiveShards(final int waitForActiveShards) {
    @Override
    public ShardId getShardId() {
     * be fetched.
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
        PARSER.declareLong(UpdateRequest::setIfPrimaryTerm, IF_PRIMARY_TERM);
        if (in.readBoolean()) {
     * to get the ActiveShardCount.
        }
        }
        this.fetchSourceContext = new FetchSourceContext(fetchSource, context.includes(), context.excludes());
        return OpType.UPDATE;
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
    }
    /**
    public long version() {
    /**
            doc.index(index);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        retryOnConflict = in.readVInt();
    }
    public String routing() {
    }
        return Versions.MATCH_ANY;
        ToXContentObject {
     * (automatically compiled) script.
        super.writeTo(out);
import java.util.List;
 */
    public OpType opType() {
        return this;
    public UpdateRequest doc(String source, MediaType mediaType) {
        }
    public RefreshPolicy getRefreshPolicy() {
     * Controls the shard routing of the request. Using this value to hash the shard
        }
            (request, script) -> request.script = script,
    private static final ParseField IF_PRIMARY_TERM = new ParseField("if_primary_term");
        if (in.getVersion().before(Version.V_2_0_0)) {
     * Controls the shard routing of the request. Using this value to hash the shard
            }
     *
    private static final ParseField DETECT_NOOP_FIELD = new ParseField("detect_noop");
 * under the License.
        }
    @Deprecated
    }
     *            An optional include (optionally wildcarded) pattern to filter
import java.util.ArrayList;
     * Sets the doc to use for updates when a script is not specified, the doc provided
            Map<String, Object> newScriptParams = params == null ? script.getParams() : params;
    private IndexRequest upsertRequest;
        updateOrCreateScript(null, null, scriptLang, null);
     * @param exclude
    /**
    public UpdateRequest upsert(MediaType mediaType, Object... source) {
        return this;
    /**
    /**
    }
     * @param include
     * <p>
 * license agreements. See the NOTICE file distributed with
     * @param excludes
        return doc;
    public UpdateRequest doc(IndexRequest doc) {
/**
    }
import org.opensearch.Version;
    public String toString() {
    public UpdateRequest doc(Map<String, Object> source, MediaType mediaType) {
import org.opensearch.core.xcontent.ToXContentObject;
     */
    @Override
    public UpdateRequest fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
     * only perform this update request if the document's modification was assigned the given
        return this;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     */
        }
    /**
    /**
                )
     * times and instead use script params if possible with the same
            this.routing = null;
        return this;
    }
        if (detectNoop == false) {
        throw new UnsupportedOperationException("update requests do not support versioning");
 * compatible open source license.
     *
    }
        super(shardId, in);
        doWrite(out, false);
 * this work for additional information regarding copyright
        detectNoop = in.readBoolean();
    }
            XContentBuilder docBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
            script.writeTo(out);
     * @deprecated Use {@link #script(Script)} instead
    /**
    @Override
        if (script != null) {
        return this;
     */
            res.append(", upsert[").append(upsertRequest).append("]");
            return builder;
    }
     */
        }
    /**
    /**
        return this;
        if (doc == null && docAsUpsert) {
    }
     * Sets the number of shard copies that must be active before proceeding with the write.
        PARSER = new ObjectParser<>(UpdateRequest.class.getSimpleName());
    }
    private static ObjectParser<UpdateRequest, Void> PARSER;
import org.opensearch.core.common.Strings;
     * If the document last modification was assigned a different term a
    public UpdateRequest doc(MediaType mediaType, Object... source) {
import org.opensearch.action.support.WriteRequest;
        this.fetchSourceContext = new FetchSourceContext(context.fetchSource(), includes, excludes);
     *            The script to execute
            Map<String, Object> scriptParams = script.getParams();
    /**
            String type = in.readString();
                builder.copyCurrentStructure(parser);
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Nullable;
                doc.writeTo(out);
    }
     */
     */
    public boolean detectNoop() {
    }
    /**
                doc.writeThin(out);
            builder.field("scripted_upsert", scriptedUpsert);
        if (doc != null) {
     * Sets the doc source of the update request to be used when the document does not exists. The doc
    @Override
     * "include" and/or "exclude" set which can include simple wildcard
    }
        return builder;
    public UpdateRequest fetchSource(boolean fetchSource) {
    implements
        out.writeOptionalString(routing);
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
        if (term < 0) {
package org.opensearch.action.update;
                validationException = addValidationError("compare and write operations can not be retried", validationException);
        if (script == null) {
    }
            try (
        scriptedUpsert = in.readBoolean();
     * If the document last modification was assigned a different sequence number a
        builder.startObject();
import java.util.Map;
     *            the returned _source
        return this.retryOnConflict;
    /**
            // make sure the basics are set
        ifPrimaryTerm = in.readVLong();
    }
    public UpdateRequest upsert(String source, MediaType mediaType) {
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     */
    @Override
        safeUpsertRequest().source(mediaType, source);
     * <p>
        }, DOC_FIELD);
    }
     * The script to execute. Note, make sure not to send different script each
    }
                    validationException
        if (docAsUpsert) {
import org.opensearch.action.support.replication.ReplicationRequest;
     */
/*
    }
    }
        this.id = id;
    public boolean isRequireAlias() {
    private FetchSourceContext fetchSourceContext;
                upsertRequest.writeTo(out);
    }
        return this;
    }
    }
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        if (routing != null && routing.length() == 0) {
import org.opensearch.common.xcontent.XContentHelper;
        return childIndexRequests;
        return this;
        }
    public Script script() {
            validationException = addValidationError("doc must be specified if doc_as_upsert is enabled", validationException);
    public UpdateRequest scriptParams(Map<String, Object> scriptParams) {
    /**
    @Deprecated
        return ifSeqNo;
        if (scriptedUpsert) {
     * Sets the doc source of the update request to be used when the document does not exists. The doc
    }
    public UpdateRequest setRefreshPolicy(RefreshPolicy refreshPolicy) {
     * The script to execute. Note, make sure not to send different script each
     *            The script language
    public UpdateRequest fromXContent(XContentParser parser) throws IOException {
     * If set, only perform this update request if the document was last modification was assigned this sequence number.
    @Deprecated
     * times and instead use script params if possible with the same
            (parser, context) -> FetchSourceContext.fromXContent(parser),
    /**
     * @deprecated Use {@link #script(Script)} instead
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
     * {@code null} clears the values and resets to {@link ExtraFieldValues#EMPTY}.
    }
    public UpdateRequest upsert(IndexRequest upsertRequest) {
 *
import org.opensearch.core.index.shard.ShardId;
        }
        return this.docAsUpsert;
    }
        return this;
        return this;
     * Sets the doc to use for updates when a script is not specified.
    }
            builder.field(IF_SEQ_NO.getPreferredName(), ifSeqNo);
        this.docAsUpsert = shouldUpsertDoc;
    /**
    }
     */
        safeDoc().source(source);
    @Override
    @Override
    }
    public UpdateRequest doc(Object... source) {
    public String scriptLang() {
    public UpdateRequest upsert(Map<String, Object> source, MediaType mediaType) {
        validationException = DocWriteRequest.validateDocIdLength(id, validationException);
        return this;
        }
        return this;
     *            the returned _source
        if (in.readBoolean()) {
     *
    @Override
 *
            }
            ) {
    /**
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
    /**
        out.writeString(id);
     * @deprecated Use {@link #script(Script)} instead
        return this;
import org.opensearch.common.annotation.PublicApi;
        return this;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
     * These values are applied only when the update is executed using {@code doc} (i.e., no script).
            MediaType mediaType = upsertRequest.getContentType();
        if (fetchSourceContext != null) {
 * KIND, either express or implied.  See the License for the
        }
     * Sets the doc source of the update request to be used when the document does not exists.
     * @deprecated Use {@link #script(Script)} instead
