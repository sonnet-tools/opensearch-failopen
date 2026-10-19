    /**  
     */  
        long childRequestBytes = 0;  
            docBuilder.copyCurrentStructure(parser);
    }
                    LoggingDeprecationHandler.INSTANCE,
        return this.upsertRequest;  
     * Sets the doc to use for updates when a script is not specified, the doc provided
            childIndexRequests.add(upsertRequest);
        }
     *            the returned _source
        super.writeTo(out);  
        );  
    }  
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        scriptedUpsert = in.readBoolean();  
     */
        safeDoc().source(source);
    public UpdateRequest setIfSeqNo(long seqNo) {
        out.writeBoolean(docAsUpsert);  
        out.writeVLong(ifPrimaryTerm);
        refreshPolicy.writeTo(out);
     *
     * "include" and/or "exclude" set which can include simple wildcard
/*  
    }  
        return this;
    public Map<String, Object> scriptParams() {  
     */
        return this;
    }  
        this.script = new Script(scriptType, Script.DEFAULT_SCRIPT_LANG, script, scriptParams);  
    }  
    @Override
    }
    @Deprecated
    @Override
            upsertRequest = new IndexRequest(shardId, in);  
     * @param scriptLang
     */
 * specific language governing permissions and limitations
        if (doc == null) {  
    }
     */  
package org.opensearch.action.update;
    @Deprecated
            }  
        updateOrCreateScript(null, null, null, scriptParams);  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            validationException = addValidationError("can't provide version in upsert request", validationException);
    public String scriptString() {
            }
    /**  
        return this.waitForActiveShards;
    private static final ParseField DOC_FIELD = new ParseField("doc");  
        res.append(", scripted_upsert[").append(scriptedUpsert).append("]");
        this.script = new Script(scriptType, scriptLang, script, scriptParams);  
     * The order is deterministic.  
import org.opensearch.core.index.shard.ShardId;
     * If the document last modification was assigned a different term a
     * includes field and value pairs.  
        DocWriteRequest<UpdateRequest>,
    public UpdateRequest routing(String routing) {
     */  
            } else {
        return VersionType.INTERNAL;
            res.append(", doc[").append(doc).append("]");  
        if (hasScript) {
        boolean hasScript = script != null;
        List<IndexRequest> childIndexRequests = new ArrayList<>();
     */  
        return res.append("}").toString();
     * times and instead use script params if possible with the same
        String script,
     */
     * Sets the number of shard copies that must be active before proceeding with the write.
                XContentParser parser = XContentHelper.createParser(
    }
    /**  
                    NamedXContentRegistry.EMPTY,
    }
            (parser, context) -> Script.parse(parser),
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
        }  
                updateOrCreateScript(null, null, null, scriptParams);  
        }  
        this.fetchSourceContext = new FetchSourceContext(context.fetchSource(), includes, excludes);
        return this;
    private IndexRequest safeUpsertRequest() {  
    @Override
            MediaType mediaType = upsertRequest.getContentType();
    }
     *
import org.opensearch.action.index.IndexRequest;
import java.util.ArrayList;
     * @deprecated Use {@link #script()} instead  
        }  
        if (ifSeqNo != UNASSIGNED_SEQ_NO) {
 *  
     */
        }, UPSERT_FIELD);
import org.opensearch.common.Nullable;
        if (script == null) {  
    }
        super.writeThin(out);  
     * Sets the id of the indexed document.
     * @param includes
     * @deprecated Use {@link #script()} instead  
                    validationException
        throw new UnsupportedOperationException("update requests do not support versioning");
        out.writeBoolean(requireAlias);
        return ifSeqNo;
            script = new Script(type == null ? ScriptType.INLINE : type, lang, scriptContent == null ? "" : scriptContent, params);
        return this.doc;  
    @Override
        return this;  
    /**
    public UpdateRequest setIfPrimaryTerm(long term) {
                    NamedXContentRegistry.EMPTY,  
     * Explicitly set the fetch source context for this request
    }
        return this;  
    /**
import java.io.IOException;
        } else {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * You may obtain a copy of the License at  
    /**
        return id;
    public UpdateRequest upsert(MediaType mediaType, Object... source) {
    @Override
     * The script to execute. Note, make sure not to send different script each
     * @param excludes
     * The id of the indexed document.  
            }  
    }  
        }
    public UpdateRequest upsert(String source, MediaType mediaType) {
    @Deprecated  
    }
     * use script params if possible with the same (automatically compiled) script.  
    public UpdateRequest doc(MediaType mediaType, Object... source) {
        PARSER.declareField(
    @Override  
    @Override
        }
        PARSER.declareBoolean(UpdateRequest::scriptedUpsert, SCRIPTED_UPSERT_FIELD);  
            ObjectParser.ValueType.OBJECT_ARRAY_BOOLEAN_OR_STRING
    public UpdateRequest script(String script, ScriptType scriptType, @Nullable Map<String, Object> scriptParams) {
     * If the document last modification was assigned a different term a
        return this.script == null ? null : this.script.getType();
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
        requireAlias = in.readBoolean();
    }
     */
    private static final ParseField SOURCE_FIELD = new ParseField("_source");  
    private IndexRequest safeDoc() {  
            throw new IllegalArgumentException("primary term must be non negative. got [" + term + "]");
 * ownership. Elasticsearch licenses this file to you under  
                || (upsertRequest != null && !upsertRequest.extraFieldValues().isEmpty())) {
    public UpdateRequest script(  
        PARSER.declareBoolean(UpdateRequest::detectNoop, DETECT_NOOP_FIELD);  
    private static final ParseField IF_PRIMARY_TERM = new ParseField("if_primary_term");
    public UpdateRequest fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {  
     * Sets the doc to use for updates when a script is not specified.
 * Licensed to Elasticsearch under one or more contributor  
        retryOnConflict = in.readVInt();
    }
            SCRIPT_FIELD,  
        if (in.readBoolean()) {
                doc.writeThin(out);
     */
     */
        }  
        return this;  
        res.append(", detect_noop[").append(detectNoop).append("]");  
        }, DOC_FIELD);
            if ((doc != null && !doc.extraFieldValues().isEmpty())  
    public UpdateRequest doc(Map<String, Object> source, MediaType mediaType) {
     *  
    }
    public UpdateRequest() {}
     * @deprecated Use {@link #script(Script)} instead
    public UpdateRequest upsert(IndexRequest upsertRequest) {
    @Deprecated  
    }
    /**  
        if (doc != null) {
    }
    }
     */
        builder.endObject();  
                builder.copyCurrentStructure(parser);  
    private boolean detectNoop = true;
        return this;  
        if (upsertRequest == null) {
        return this;  
    /**
        );
    }
    private boolean docAsUpsert = false;
        this.docAsUpsert = shouldUpsertDoc;
     * getting it and updating it. Defaults to 0.  
/*  
        if (seqNo < 0 && seqNo != UNASSIGNED_SEQ_NO) {  
        if (script != null) {
            if (docAsUpsert) {
    public ActionRequestValidationException validate() {
        }
        if (term < 0) {  
    @Deprecated
        this.fetchSourceContext = context;
    public UpdateRequest scriptParams(Map<String, Object> scriptParams) {
     * @param exclude  
            if (scriptParams == null) {  
     * @deprecated Use {@link #script(Script)} instead  
    /**  
        res.append(", doc_as_upsert[").append(docAsUpsert).append("]");
        safeDoc().source(source);
    }
    }  
            HashMap<String, Object> scriptParams = new HashMap<>();
    }
            ) {
 * Unless required by applicable law or agreed to in writing,
    }
            MediaType mediaType = doc.getContentType();  
    public UpdateRequest upsertExtraFieldValues(ExtraFieldValues values) {  
        safeDoc().source(mediaType, source);
        out.writeBoolean(hasScript);  
    @Deprecated  
        this.requireAlias = requireAlias;  
    /**
            String type = in.readString();  
    public long version() {
        return upsertRequest;
    public UpdateRequest script(String script, ScriptType scriptType) {  
        return validationException;
        return this;
 */  
        safeDoc().source(source, mediaType);  
     *            filter the returned _source
     * Should this update attempt to detect if it is a noop? Defaults to true.
import org.opensearch.action.DocWriteRequest;
            if (thin) {
    }
    public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
    public UpdateRequest fetchSource(@Nullable String include, @Nullable String exclude) {
    public UpdateRequest scriptedUpsert(boolean scriptedUpsert) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
     */
            ObjectParser.ValueType.OBJECT_OR_STRING
    public VersionType versionType() {  
     * If set, only perform this update request if the document was last modification was assigned this primary term.
    /**
        safeUpsertRequest().source(source, mediaType);
 * under the License.  
            } else {
        return this;  
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
            ) {
     *
     * {@code null} clears the values and resets to {@link ExtraFieldValues#EMPTY}.
import org.opensearch.action.support.ActiveShardCount;  
    }
        return this;  
    @Override
        return childIndexRequests;  
    private String routing;
 * not use this file except in compliance with the License.
    }
                    mediaType
     * (automatically compiled) script.
        updateOrCreateScript(script, scriptType, null, null);
        }  
            } else {  
     * Should this update attempt to detect if it is a noop? Defaults to true.
        safeDoc().source(source);  
        return this;
        this.doc = doc;
    public UpdateRequest doc(XContentBuilder source) {  
    }
        return this.scriptedUpsert;
     * <p>
    public UpdateRequest(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
 *
    }
            scriptParams.put(name, value);
        routing = in.readOptionalString();
        // ExtraFieldValues not supported for scripted updates for now
        return this;
    /**
    }
    }
        ScriptType scriptType,  
     * {@link org.opensearch.index.engine.DocumentMissingException} is thrown.  
            doc = new IndexRequest(shardId, in);
        return PARSER.parse(parser, this, null);  
    /**
                builder.field("doc");  
        safeUpsertRequest().source(source);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ShardId getShardId() {
        if (doc != null) {
        }
    /**
     * elements.
     *            An optional include (optionally wildcarded) pattern to filter
        PARSER.declareField(  
     * to get the ActiveShardCount.
    public UpdateRequest detectNoop(boolean detectNoop) {
    public UpdateRequest upsert(XContentBuilder source) {
import org.opensearch.index.mapper.MapperService;
    public UpdateRequest doc(IndexRequest doc) {
import org.opensearch.core.common.Strings;
        return this;
                scriptParams.put(name, value);
    public UpdateRequest docExtraFieldValues(ExtraFieldValues values) {  
                )  
        } else {
        return this;
    @Deprecated
    }
     */
     * Controls the shard routing of the request. Using this value to hash the shard  
     */
     * The script to execute. Note, make sure not to send different script each  
        } else {
    public UpdateRequest setRefreshPolicy(RefreshPolicy refreshPolicy) {
    }
    /**  
            if (upsertRequest != null) {
 * @opensearch.api
    public UpdateRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
            out.writeBoolean(false);  
    private IndexRequest upsertRequest;
    private static final ParseField SCRIPTED_UPSERT_FIELD = new ParseField("scripted_upsert");
        if (docAsUpsert) {
    /**  
    }
     */
        return OpType.UPDATE;
     * elements.  
    @Override
        out.writeOptionalString(routing);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
    }  
    }
 * Transport request for updating an index  
        }
    /**
        return this;
     * Indicate that _source should be returned, with an
            // make sure the basics are set
        return this;
    }
     * Indicates whether the response should contain the updated _source.
    /**
    public UpdateRequest id(String id) {
    /**  
            builder.field("_source", fetchSourceContext);
    @Deprecated
                    doc.source(),
        if (doc != null) {  
     * Sets the doc to use for updates when a script is not specified.  
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(UpdateRequest.class);
        String[] includes = include == null ? Strings.EMPTY_ARRAY : new String[] { include };  
     */
            validationException = addValidationError("doc must be specified if doc_as_upsert is enabled", validationException);
     * {@code null} clears the values and resets to {@link ExtraFieldValues#EMPTY}.
        return this;
            (request, script) -> request.script = script,
}
            builder.field("script", script);
        this.script = script;  
     *
        }
        return this.script;
     * @return a list of index requests
     */
    /**
        return SHALLOW_SIZE + RamUsageEstimator.sizeOf(id) + childRequestBytes;
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
     * only performs this update request if the document's last modification was assigned the given
    public UpdateRequest versionType(VersionType versionType) {
    /**
        return fetchSourceContext;
     * includes field and value pairs.  
    @Nullable  
import org.opensearch.core.xcontent.MediaType;
            builder.field("detect_noop", detectNoop);
    public String routing() {
    public UpdateRequest script(String script) {
    public UpdateRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
        }
    }
     * primary term. Must be used in combination with {@link #setIfSeqNo(long)}  
            validationException = addValidationError("id is missing", validationException);
    private IndexRequest doc;  
    }
 * Modifications Copyright OpenSearch Contributors. See
     * Sets the doc to use for updates when a script is not specified.
     * be fetched.
    }  
            if (retryOnConflict > 0) {
        }
        if (upsertRequest != null && upsertRequest.version() != Versions.MATCH_ANY) {  
        }
    }  
    public UpdateRequest waitForActiveShards(final int waitForActiveShards) {  
import org.opensearch.core.ParseField;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        this.retryOnConflict = retryOnConflict;  
     *
        builder.startObject();
            doc.id(id);  
     * Controls the shard routing of the request. Using this value to hash the shard
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(parser.contentType());
    public String id() {  
    @Override
     * @deprecated Use {@link #script(Script)} instead  
        docAsUpsert = in.readBoolean();
    public UpdateRequest doc(Map<String, Object> source) {
    }
        safeUpsertRequest().source(source, offset, length, mediaType);  
     */  
    }
        if (upsertRequest == null) {
     * Sets the doc source of the update request to be used when the document does not exists.
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
    private boolean requireAlias = false;  
        }
    @Override  
import org.opensearch.common.lucene.uid.Versions;  
     * @param script  
        PARSER.declareLong(UpdateRequest::setIfSeqNo, IF_SEQ_NO);
     */  
    private void doWrite(StreamOutput out, boolean thin) throws IOException {
            validationException = addValidationError("script or doc is missing", validationException);
    /**  
        if (doc != null) {
        if (routing != null && routing.length() == 0) {  
    private static final ParseField UPSERT_FIELD = new ParseField("upsert");
                    upsertRequest.source(),
        }
import org.opensearch.script.ScriptType;
                scriptParams.put(name, value);
    }  
        return Versions.MATCH_ANY;  
        out.writeString(id);  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        safeUpsertRequest().source(source, mediaType);  
                scriptParams = new HashMap<>();
    private void updateOrCreateScript(String scriptContent, ScriptType type, String lang, Map<String, Object> params) {
 * KIND, either express or implied.  See the License for the
     * If set, only perform this update request if the document was last modification was assigned this sequence number.
     */
     *
     */
        return this;
     * Sets the script parameters to use with the script.  
     * Sets the doc source of the update request to be used when the document does not exists.
     */
    /**
        StringBuilder res = new StringBuilder().append("update {[").append(index).append("][").append(id).append("]");  
        this.fetchSourceContext = new FetchSourceContext(context.fetchSource(), includes, excludes);
     * Sets the doc source of the update request to be used when the document does not exists. The doc
            childRequestBytes += upsertRequest.ramBytesUsed();
        return script == null ? null : script.getLang();
        this.waitForActiveShards = waitForActiveShards;  
    public UpdateRequest doc(Object... source) {
    /**
 * The OpenSearch Contributors require contributions made to  
    @Override
        return this;
     * Gets the {@link FetchSourceContext} which defines how the _source should  
        PARSER = new ObjectParser<>(UpdateRequest.class.getSimpleName());
        return this.script == null ? null : this.script.getIdOrCode();  
     */  
    public UpdateRequest retryOnConflict(int retryOnConflict) {
     * Sets the doc source of the update request to be used when the document does not exists.  
import org.opensearch.action.ActionRequestValidationException;  
        if (upsertRequest != null) {
        return this;  
 *
    }
     * Sets the doc to use for updates when a script is not specified.
        } else {
        } else {
        }  
        if (upsertRequest != null) {
        return this;
/**
        safeUpsertRequest().source(source);
        return this.retryOnConflict;
    }
        Script script = script();
            this.routing = routing;  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
    /**  
     */
        ifPrimaryTerm = term;  
    /**  
    @Override
        String[] excludes = exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude };
    /**
        ifSeqNo = seqNo;  
        if (doc == null && docAsUpsert) {
    /**
        safeDoc().extraFieldValues(values);
        }
        ActionRequestValidationException validationException = super.validate();
    }
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean docAsUpsert() {  
    public UpdateRequest fetchSource(boolean fetchSource) {  
    }
        return this;
            String newScriptContent = scriptContent == null ? script.getIdOrCode() : scriptContent;  
    private static final ParseField DOC_AS_UPSERT_FIELD = new ParseField("doc_as_upsert");
     * The script to execute. Note, make sure not to send different script each
     */
                XContentParser parser = XContentHelper.createParser(
        if (doc == null) {
        }
        PARSER.declareObject((request, builder) -> request.safeUpsertRequest().source(builder), (parser, context) -> {
    /**
        PARSER.declareBoolean(UpdateRequest::docAsUpsert, DOC_AS_UPSERT_FIELD);
    }
    public boolean detectNoop() {
    @Deprecated
        return this.script == null ? null : this.script.getParams();
        if (script != null && doc != null) {
            if (thin) {  
            }  
        if (script != null) {
     * (automatically compiled) script.
     *            The script type
        return this;
    }  
    public UpdateRequest upsert(Map<String, Object> source, MediaType mediaType) {
     * @deprecated Use {@link #script()} instead
        out.writeOptionalWriteable(fetchSourceContext);
     * @param scriptParams  
    public UpdateRequest addScriptParam(String name, Object value) {
import org.opensearch.Version;
    public UpdateRequest fromXContent(XContentParser parser) throws IOException {
    Script script;
    /**
     * Sets the doc to use for updates when a script is not specified.  
    public List<IndexRequest> getChildIndexRequests() {
     * Sets the doc source of the update request to be used when the document does not exists.  
     *            The script language  
        return detectNoop;
     * <p>  
        return this;  
import org.opensearch.common.xcontent.XContentHelper;
     */
        this.refreshPolicy = refreshPolicy;  
     */
        WriteRequest<UpdateRequest>,
     * If the document last modification was assigned a different sequence number a  
    public boolean scriptedUpsert() {  
    public UpdateRequest scriptLang(String scriptLang) {  
     *
        safeDoc().source(source, offset, length, mediaType);
     * @deprecated Use {@link #script(Script)} instead
    private long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
     *            An optional exclude (optionally wildcarded) pattern to filter
            // make sure the basics are set  
            String newScriptLang = lang == null ? script.getLang() : lang;
    public UpdateRequest upsert(byte[] source, int offset, int length, MediaType mediaType) {
     */
    /**  
    public UpdateRequest upsert(Object... source) {
        if (script == null && doc == null) {
     */  
        PARSER.declareLong(UpdateRequest::setIfPrimaryTerm, IF_PRIMARY_TERM);
    private boolean scriptedUpsert = false;  
     * sequence number. Must be used in combination with {@link #setIfPrimaryTerm(long)}  
    /**
            }
        if (upsertRequest != null) {
            doc.index(index);
 * compatible open source license.
            childRequestBytes += doc.ramBytesUsed();
        safeUpsertRequest().source(source, mediaType);
        updateOrCreateScript(null, null, scriptLang, null);
    }
        this.id = id;
     *  
     *            An optional list of include (optionally wildcarded) pattern to  
            updateOrCreateScript(null, null, null, scriptParams);  
    }  
    }  
    public UpdateRequest version(long version) {  
     * @param scriptType
    /**
     *
     * Sets the number of retries of a version conflict occurs because the document was updated between
    }
        safeUpsertRequest().extraFieldValues(values);
    public UpdateRequest upsert(Map<String, Object> source) {  
import org.apache.lucene.util.RamUsageEstimator;
import java.util.List;
     * times and instead use script params if possible with the same  
    public UpdateRequest upsert(byte[] source, MediaType mediaType) {  
        return this;
        ToXContentObject {  
            try (
    public RefreshPolicy getRefreshPolicy() {
     * The script to execute. Note, make sure not to send different script each times and instead
            builder.field(IF_SEQ_NO.getPreferredName(), ifSeqNo);  
 * this file be licensed under the Apache-2.0 license or a
     * Gets all valid child index requests for the update request.
    @Nullable  
        @Nullable String scriptLang,
/*
import java.util.Map;
            ScriptType newScriptType = type == null ? script.getType() : type;
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
        validationException = DocWriteRequest.validateDocIdLength(id, validationException);  
    public ScriptType scriptType() {
            try (  
                    LoggingDeprecationHandler.INSTANCE,  
        this.upsertRequest = upsertRequest;  
        super(index);
     * Sets the index request to be used if the document does not exists. Otherwise, a
    }  
        }
import org.opensearch.common.annotation.PublicApi;
    /**  
    /**
    /**
        return this;
                builder.field("upsert");
    }
        }
        detectNoop = in.readBoolean();
     */
            out.writeBoolean(false);
            res.append(", script[").append(script).append("]");  
    public OpType opType() {  
                    mediaType  
    @Override  
            UpdateRequest::fetchSource,
import org.opensearch.script.Script;  
     */
    }
     * @param include  
        return this;  
    private static final ParseField DETECT_NOOP_FIELD = new ParseField("detect_noop");
    public UpdateRequest setRequireAlias(boolean requireAlias) {
            builder.field("doc_as_upsert", docAsUpsert);  
 * license agreements. See the NOTICE file distributed with
            builder.field(IF_PRIMARY_TERM.getPreferredName(), ifPrimaryTerm);
                upsertRequest.writeThin(out);
 */  
        }
    /**
     * times and instead use script params if possible with the same  
@PublicApi(since = "1.0.0")
    private int retryOnConflict = 0;
            childIndexRequests.add(doc);
     * Sets extra field values for the upsert document ({@code upsert}).
     * The language of the script to execute.
    @Nullable
    private long ifSeqNo = UNASSIGNED_SEQ_NO;  
    }
        if (fetchSourceContext != null) {  
    public IndexRequest doc() {
            }
     *
    }  
    /**
     *            the returned _source
    }  
    public String scriptLang() {  
    private static final ParseField SCRIPT_FIELD = new ParseField("script");  
public class UpdateRequest extends InstanceShardOperationRequest<UpdateRequest>
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
    /**
     */  
    /**
        return this;
        this(null, in);
        }
        }  
    /**
     *
        }  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }  
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
    }  
import org.opensearch.core.xcontent.XContentParser;
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.  
     * Sets the doc to use for updates when a script is not specified.
        FetchSourceContext context = this.fetchSourceContext == null ? FetchSourceContext.FETCH_SOURCE : this.fetchSourceContext;
        Script script = script();
     */
            doc = new IndexRequest(index);
            return docBuilder;  
    }
            builder.copyCurrentStructure(parser);  
    static {
            script = new Script(newScriptType, newScriptLang, newScriptContent, newScriptParams);
                validationException = addValidationError(  
 *
    public UpdateRequest doc(String source, MediaType mediaType) {  
            validationException = addValidationError("can't provide both script and doc", validationException);
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
    public UpdateRequest docAsUpsert(boolean shouldUpsertDoc) {
     * Sets the doc source of the update request to be used when the document does not exists.
 */
                doc.writeTo(out);
        }
            }
            this.routing = null;
     */
    }
                validationException = addValidationError("compare and write operations can not be retried", validationException);
     * @deprecated Use {@link #script(Script)} instead
     * is a field and value pairs.
import org.opensearch.action.support.replication.ReplicationRequest;
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
     * Sets the doc to use for updates when a script is not specified.
        script(script);  
    public void writeThin(StreamOutput out) throws IOException {
            SOURCE_FIELD,
            builder.field("scripted_upsert", scriptedUpsert);
        out.writeBoolean(scriptedUpsert);
    }
     */
    }  
    public String toString() {
    private FetchSourceContext fetchSourceContext;  
import org.opensearch.core.xcontent.ToXContentObject;  
        refreshPolicy = RefreshPolicy.readFrom(in);  
        @Nullable Map<String, Object> scriptParams
    /**
    }
        if (upsertRequest != null) {  
        return builder;
        return this.shardId;  
    public UpdateRequest fetchSource(FetchSourceContext context) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (Strings.isEmpty(id)) {  
        PARSER.declareObject((request, builder) -> request.safeDoc().source(builder), (parser, context) -> {  
    }  
    }
        if (script == null) {  
        return requireAlias;
            Map<String, Object> newScriptParams = params == null ? script.getParams() : params;  
    /**
        waitForActiveShards.writeTo(out);
    }
    /**
        doWrite(out, true);
    @Override
     *            The script parameters
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        return this.routing;
     * Indicate that _source should be returned with every hit, with an
        return this;
            upsertRequest.id(id);
     *            An optional list of exclude (optionally wildcarded) pattern to  
        return this;
     */
        safeUpsertRequest().source(mediaType, source);  
    public UpdateRequest doc(byte[] source, int offset, int length, MediaType mediaType) {
     * @deprecated Use {@link #script(Script)} instead  
            XContentBuilder docBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
     */  
 * GitHub history for details.
     * If the document last modification was assigned a different sequence number a
                    "upsert requests don't support `if_seq_no` and `if_primary_term`",
import static org.opensearch.action.ValidateActions.addValidationError;
        this.detectNoop = detectNoop;  
        this.fetchSourceContext = new FetchSourceContext(fetchSource, context.includes(), context.excludes());
     * (automatically compiled) script.  
        return this;
     * only perform this update request if the document's modification was assigned the given
     * These values are applied only when the update is executed using {@code doc} (i.e., no script).  
        validationException = DocWriteRequest.validateSeqNoBasedCASParams(this, validationException);
    }
        safeUpsertRequest().source(source);
    public UpdateRequest doc(byte[] source, MediaType mediaType) {
     */  
                )
     */  
     */
        return this;
            script.writeTo(out);
        doWrite(out, false);
    }
    /**
        out.writeZLong(ifSeqNo);
    public UpdateRequest(String index, String id) {
    /**  
        }
     */  
import org.opensearch.core.xcontent.ObjectParser;
     */  
    private RefreshPolicy refreshPolicy = RefreshPolicy.NONE;  
     */
        ifPrimaryTerm = in.readVLong();
        }
        return this;
        return this;
        if (ifSeqNo != UNASSIGNED_SEQ_NO) {  
            out.writeBoolean(true);
    }
        return this;
        return doc;
        }  
        if (scriptedUpsert) {  
        if (out.getVersion().before(Version.V_2_0_0)) {  
     * {@link org.opensearch.index.engine.VersionConflictEngineException} will be thrown.
            upsertRequest = new IndexRequest(index);
    public long ramBytesUsed() {
    }
    private static final ParseField IF_SEQ_NO = new ParseField("if_seq_no");
    public boolean isRequireAlias() {
        return this;  
        if (script != null) {
        throw new UnsupportedOperationException("update requests do not support versioning");
     * (automatically compiled) script.
import org.opensearch.action.support.WriteRequest;
     * <p>  
    /**
        if (detectNoop == false) {  
import java.util.HashMap;  
        out.writeBoolean(detectNoop);  
     * Add a script parameter.
    private static ObjectParser<UpdateRequest, Void> PARSER;
     * "include" and/or "exclude" set which can include simple wildcard  
    public IndexRequest upsertRequest() {
     * @deprecated Use {@link #script()} instead
    }
        return ifPrimaryTerm;
    public FetchSourceContext fetchSource() {  
        return refreshPolicy;  
                );  
        waitForActiveShards = ActiveShardCount.readFrom(in);
    /**
    implements  
        }  
    }
        safeDoc().source(source, mediaType);
     * Sets extra field values for the partial document update ({@code doc}).
     * The script to execute. Note, make sure not to send different script each
        return this.docAsUpsert;
    }
    }  
    public Script script() {  
        return this;  
import org.opensearch.action.support.single.instance.InstanceShardOperationRequest;  
        }
     *            filter the returned _source
     * and not the id.
            assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected [_doc] but received [" + type + "]";
     */
     * @deprecated Use {@link #script(Script)} instead
import org.opensearch.index.VersionType;  
    }
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
    public long ifPrimaryTerm() {
     * Sets the doc source of the update request to be used when the document does not exists.
        this.id = id;  
    /**
            script = new Script(in);  
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.  
     */
    public UpdateRequest script(Script script) {
                validationException = addValidationError("ExtraFieldValues are not supported with scripted updates", validationException);
     */
            (parser, context) -> FetchSourceContext.fromXContent(parser),  
        }  
        super(shardId, in);  
        return this;  
     * Sets the doc source of the update request to be used when the document does not exists. The doc
        return this;  
    private String id;
    @Deprecated
    @Override  
    /**
            upsertRequest.index(index);
    @Deprecated
        if (in.readBoolean()) {
    @Override
                validationException = addValidationError("compare and write operations can not be used with upsert", validationException);  
    }
        out.writeVInt(retryOnConflict);
            throw new IllegalArgumentException("sequence numbers must be non negative. got [" + seqNo + "].");
     */  
    public long ifSeqNo() {  
        return this;
        id = in.readString();  
    }  
        }
    ) {
     *            The script to execute
            }
    }
     * Sets the doc to use for updates when a script is not specified, the doc provided
        if (in.readBoolean()) {
        }
 */  
     * times and instead use script params if possible with the same
    public ActiveShardCount waitForActiveShards() {  
            Map<String, Object> scriptParams = script.getParams();
                upsertRequest.writeTo(out);  
    /**
        this.scriptedUpsert = scriptedUpsert;
     */
        }
     *
 * SPDX-License-Identifier: Apache-2.0
            }
     * @return this for chaining  
        safeDoc().source(source, mediaType);
        updateOrCreateScript(script, ScriptType.INLINE, null, null);
            res.append(", upsert[").append(upsertRequest).append("]");  
            out.writeBoolean(true);  
     * is a field and value pairs.
                builder.copyCurrentStructure(parser);
        ifSeqNo = in.readZLong();  
     * and not the id.
            return builder;
        return this;
    public int retryOnConflict() {
     */  
