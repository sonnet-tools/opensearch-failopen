            out.writeOptionalVInt(maxNumTerms);
                } else if (currentFieldName.equals("max_word_length")) {
 * GitHub history for details.
            this.maxNumTerms = maxNumTerms;  
        if (filterSettings != null) {
 * Unless required by applicable law or agreed to in writing,
    public MediaType xContentType() {  
        ActionRequestValidationException validationException = super.validateNonNullIndex();
    private static final ParseField POSITIONS = new ParseField("positions");
        setFlag(Flag.FieldStatistics, fieldStatistics);
    /**
/*  
import org.opensearch.core.xcontent.MediaType;  
     */  
                    termVectorsRequest.positions(parser.booleanValue());  
                }
    @Override  
    /**  
    public static final class FilterSettings {
import org.opensearch.core.common.io.stream.StreamOutput;
            this.minTermFreq = minTermFreq;
    /**
    /**
                mediaType.writeTo(out);
    private static final ParseField VERSION = new ParseField("version");  
            @Nullable Integer minDocFreq,
 * SPDX-License-Identifier: Apache-2.0
     */
            minTermFreq = in.readOptionalVInt();
            this.maxTermFreq = maxTermFreq;
                    settings.minWordLength = parser.intValue();
 */
            }
    /**  
     * from the provided index. Use {@link #id(String)} to specify the document to load.  
            out.writeOptionalVInt(maxDocFreq);  
                if (currentFieldName.equals("max_num_terms")) {
     */  
    @Override  
 * under the License.  
                    throw new OpenSearchParseException("failed to parse term vectors request. unknown field [{}]", currentFieldName);
        if (perFieldAnalyzer != null) {
            maxWordLength = in.readOptionalVInt();
        return validationException;  
    public TermVectorsRequest id(String id) {  
        return this;  
        return mapStrStr;  
 * Note, the {@link #index()}, and {@link #id(String)} are
        this.version = version;
     * Return the payloads for each term or skip.  
        return routing;
            filterSettings.writeTo(out);  
    /**
    }
        this.realtime = other.realtime();  
    public TermVectorsRequest doc(BytesReference doc, boolean generateRandomId) {
            // types no longer supported; send "_doc" for bwc
        this.id = item.id();
     * from the provided index. Use {@link #id(String)} to specify the document to load.  
            this.maxWordLength = maxWordLength;  
import org.opensearch.action.ValidateActions;
            this.selectedFields = new HashSet<>(other.selectedFields);
                } else if (DOC.match(currentFieldName, parser.getDeprecationHandler())) {
            filterSettings.readFrom(in);  
        }  
    /**  
    public TermVectorsRequest routing(String routing) {
        id = in.readString();
import org.opensearch.action.support.single.shard.SingleShardRequest;
                        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
import org.opensearch.core.xcontent.XContentParser;  
                    throw new OpenSearchParseException(
        }  
        }
    /**  
     * Return the start and stop offsets for each term if they were stored or
     * requests.
                flagsEnum.add(flag);  
    }  
    }  
    private Map<String, String> perFieldAnalyzer;
     * @return <code>true</code> if term payloads should be returned. Otherwise
        }
        return this;  
    public TermVectorsRequest payloads(boolean payloads) {
        return id;  
                }
                } else {  
                    // the following is important for multi request parsing.
     */  
                );  
    public TermVectorsRequest(MultiGetRequest.Item item) {  
    }
        out.writeOptionalString(preference);
import org.opensearch.core.ParseField;
    private String id;
        return settings;
                    termVectorsRequest.versionType = VersionType.fromString(parser.text());
                        );  
     * @return Returns if the positions for each term should be returned if
import org.opensearch.core.xcontent.XContentBuilder;
     */  
        this.perFieldAnalyzer = perFieldAnalyzer != null && perFieldAnalyzer.size() != 0 ? new HashMap<>(perFieldAnalyzer) : null;
                        }
            validationException = ValidateActions.addValidationError("id or doc is missing", validationException);
     * <code>false</code>
    private MediaType mediaType;
        return this;  
        Map<String, String> mapStrStr = new HashMap<>();  
            // types no longer supported; ignore for BWC
            minDocFreq = in.readOptionalVInt();
                        throw new OpenSearchParseException(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            out.writeVInt(0);
    /**
     */
    public String routing() {  
    /**
        if (selectedFields != null) {
     * Otherwise <code>false</code>
        }  
                } else if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
    public boolean realtime() {
    /**
        }
     * Otherwise <code>false</code>  
 * specific language governing permissions and limitations
 */  
        if (in.readBoolean()) {
                } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
        return doc;  
        return this;
     * Return the settings for filtering out terms.
        this.id = other.id();
        if (numSelectedFields > 0) {
        }  
    @Deprecated  
        this.filterSettings = other.filterSettings();  
     */
        setFlag(Flag.TermStatistics, termStatistics);
     */
    public TermVectorsRequest version(long version) {
    private static final AtomicInteger randomInt = new AtomicInteger(0);  
        return flagsEnum.contains(Flag.Positions);  
import java.util.Map;
            }  
    }
            @Nullable Integer minTermFreq,
    }
    /**
import java.util.EnumSet;  
    }  
        return this.doc(BytesReference.bytes(documentBuilder), true, documentBuilder.contentType());
            flagsEnum.add(flag);
    }
        ) {
     * @return The routing for this request.
        this.doc = doc;
     */  
                    settings.maxTermFreq = parser.intValue();
    public void writeTo(StreamOutput out) throws IOException {
            @Nullable Integer minWordLength,  
        return versionType;
            filterSettings = new FilterSettings();
    }
    public TermVectorsRequest preference(String preference) {
    }
    @Override  
                            fields.add(parser.text());
                    if (token == XContentParser.Token.START_ARRAY) {
                } else {
     */
    public TermVectorsRequest positions(boolean positions) {
        XContentParser.Token token;
    }  
        setFlag(Flag.Payloads, payloads);  
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
        Payloads,  
    public TermVectorsRequest(String index, String id) {
    public boolean offsets() {
     */
            } else if (currentFieldName != null) {
        routing = in.readOptionalString();
            this.maxDocFreq = maxDocFreq;
    }  
            this.minWordLength = minWordLength;
    }
        return this;  
    private static final ParseField DOC = new ParseField("doc");
     */
        return this;  
     */
        if (doc != null) {
            } else {
     * The flags.
    public static void parseRequest(TermVectorsRequest termVectorsRequest, XContentParser parser) throws IOException {
     * @opensearch.api
        return selectedFields;
    /**
    }  
    public Map<String, String> perFieldAnalyzer() {  
    public TermVectorsRequest realtime(boolean realtime) {
    public enum Flag {
                selectedFields.add(in.readString());
     */
            out.writeOptionalVInt(maxTermFreq);
    }
        if (in.readBoolean()) {
    private static final ParseField OFFSETS = new ParseField("offsets");  
                        throw new OpenSearchParseException(  
     * Sets the settings for filtering out terms.
    }  
            out.writeOptionalVInt(minWordLength);
        public FilterSettings() {
        }
     * shards. Can be set to {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,  
                            + "the field [{}] is not valid for filter parameter for term vector request",
    /**
 */  
        }  
            assert (!flagsEnum.contains(flag));
        return flagsEnum.contains(Flag.TermStatistics);  
        if (other.doc != null) {
    }
    }
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
                    }
        out.writeOptionalString(routing);  
            maxDocFreq = in.readOptionalVInt();
                        "failed to parse term vectors request. "  
    public TermVectorsRequest doc(XContentBuilder documentBuilder) {
        this.preference = other.preference();
            for (int i = 0; i < numSelectedFields; i++) {  
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        preference = in.readOptionalString();  
    }  
    private static final ParseField ROUTING = new ParseField("routing");
     */
     * populates a request object (pre-populated with defaults) based on a parser.  
    }
    protected String preference;
            out.writeOptionalVInt(maxWordLength);
        }
 *  
    TermVectorsRequest(StreamInput in) throws IOException {
                currentFieldName = parser.currentName();  
                    termVectorsRequest.doc(jsonBuilder().copyCurrentStructure(parser));
            } else if (currentFieldName != null) {  
        for (Flag flag : Flag.values()) {
            } else {
    }
                    termVectorsRequest.filterSettings(readFilterSettings(parser));  
        long longFlags = 0;
    }  
        if (in.getVersion().before(Version.V_2_0_0)) {  
        return this.realtime;  
 */  
    public ActionRequestValidationException validate() {
            out.writeOptionalVInt(minTermFreq);  
            longFlags |= (1 << flag.ordinal());
            if (e.getValue() instanceof String) {
        flagsEnum.clear();  
            selectedFields = new HashSet<>();
        public Integer minDocFreq;  
            out.writeGenericValue(perFieldAnalyzer);
    public BytesReference doc() {
    }
            @Nullable Integer maxNumTerms,
     * Sets an artificial document from which term vectors are requested for.  
package org.opensearch.action.termvectors;
    public boolean fieldStatistics() {  
     * vectors for all fields if selectedFields == null
    private long version = Versions.MATCH_ANY;
    public TermVectorsRequest offsets(boolean offsets) {
            out.writeStringCollection(selectedFields);
                            "failed to parse term vectors request. " + "either [id] or [doc] can be specified, but not both!"
        return this;
    /**  
     * Constructs a new term vector request for a document that will be fetch
    private EnumSet<Flag> flagsEnum = EnumSet.of(Flag.Positions, Flag.Offsets, Flag.Payloads, Flag.FieldStatistics);  
@PublicApi(since = "1.0.0")
                mapStrStr.put(e.getKey(), (String) e.getValue());  
            if ((flags & (1 << flag.ordinal())) != 0) {
            maxTermFreq = in.readOptionalVInt();  
    public EnumSet<Flag> getFlags() {
                    termVectorsRequest.fieldStatistics(parser.booleanValue());  
import org.opensearch.OpenSearchParseException;
     * @return <code>true</code> if term offsets should be returned. Otherwise
     * @deprecated use {@link #doc(BytesReference, boolean, MediaType)} to avoid content auto detection
    /**  
    }
 *
        if (other.selectedFields != null) {  
     */  
     * Return the positions for each term if stored or skip.  
        return flagsEnum.contains(Flag.FieldStatistics);
    /**
     *
                } else if (currentFieldName.equals("min_doc_freq")) {
    }
import java.util.concurrent.atomic.AtomicInteger;  
     */
    private Set<String> selectedFields;  
                } else if (FILTER.match(currentFieldName, parser.getDeprecationHandler())) {
/**
    public TermVectorsRequest doc(BytesReference doc, boolean generateRandomId, MediaType mediaType) {
                    "expecting the analyzer at [{}] to be a String, but found [{}] instead",  
            this.id(String.valueOf(randomInt.getAndAdd(1)));
    private static final ParseField FILTER = new ParseField("filter");
            @Nullable Integer maxTermFreq,  
    }
        }
import org.opensearch.common.annotation.PublicApi;  
     * Sets the preference to execute the search. Defaults to randomize across
        } else if (!set) {  
        setFlag(Flag.Offsets, offsets);
        out.writeString(id);
        this.version = other.version();
 * The OpenSearch Contributors require contributions made to  
                    if (termVectorsRequest.id != null) {  
        return flagsEnum;
import org.opensearch.core.common.bytes.BytesReference;  
    /**
                } else if (DFS.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {  
     * skip offsets.
        super.writeTo(out);
        // assign a random id to this artificial document, for routing  
    public static Map<String, String> readPerFieldAnalyzer(Map<String, Object> map) {
     */
 *
            this.doc = new BytesArray(other.doc().toBytesRef(), true);  
    }
                    termVectorsRequest.offsets(parser.booleanValue());
}  
     * Return the field statistics for each term in the shard or skip.
                    termVectorsRequest.version = parser.longValue();  
        public Integer maxTermFreq;
import org.opensearch.common.Nullable;
        this.routing = routing;
    /**
 * Licensed to Elasticsearch under one or more contributor  
        out.writeBoolean(filterSettings != null);
                } else if (currentFieldName.equals("max_term_freq")) {  
    }
     */
    /**  
    public boolean payloads() {
        }  
     */
        if (other.perFieldAnalyzer != null) {  
 * ownership. Elasticsearch licenses this file to you under  
                    settings.maxDocFreq = parser.intValue();
        // Do not change the order of these flags we use
                    } else {  
 * not use this file except in compliance with the License.
     * Return only term vectors for special selected fields. Returns for term
        long flags = in.readVLong();
        public FilterSettings(  
 * software distributed under the License is distributed on an
        out.writeByte(versionType.getValue());  
            } else {
 * this file be licensed under the Apache-2.0 license or a
        this.versionType = versionType;
     */  
    public FilterSettings filterSettings() {  
                    termVectorsRequest.payloads(parser.booleanValue());
    private VersionType versionType = VersionType.INTERNAL;  
        }
    public TermVectorsRequest filterSettings(FilterSettings settings) {
    /**
        }
    }
    }
        return flagsEnum.contains(Flag.Payloads);
    /**  
                out.writeEnum((XContentType) mediaType);  
    public String preference() {  
                    );  
            String[] fieldsAsArray = new String[fields.size()];  
        return this.doc(doc, generateRandomId, MediaTypeRegistry.xContentType(doc));
     * Return whether term vectors should be generated real-time (default to true).  
    }  
        }
            this.mediaType = other.mediaType;
    }
                            "failed to parse term vectors request. " + "either [id] or [doc] can be specified, but not both!"
     * <code>false</code>
        if (set && !flagsEnum.contains(flag)) {
    }
        }
        return mediaType;
import org.opensearch.common.lucene.uid.Versions;
    private FilterSettings filterSettings;  
        public Integer minWordLength;
import org.opensearch.action.RealtimeRequest;
/*
        List<String> fields = new ArrayList<>();
                } else if (currentFieldName.equals("min_word_length")) {  
                if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
 * license agreements. See the NOTICE file distributed with
     * Sets an artificial document from which term vectors are requested for.
    public Set<String> selectedFields() {
            out.writeBytesReference(doc);
        }  
            }
    }
import org.opensearch.index.VersionType;
 * this work for additional information regarding copyright
    }
        Positions,
                    termVectorsRequest.termStatistics(parser.booleanValue());
        }
     */
    public TermVectorsRequest perFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
        Offsets,
        this.mediaType = mediaType;
                    settings.maxNumTerms = parser.intValue();  
        return this;
import org.opensearch.core.common.io.stream.StreamInput;
        public void writeTo(StreamOutput out) throws IOException {
                } else if (currentFieldName.equals("per_field_analyzer") || currentFieldName.equals("perFieldAnalyzer")) {  
        for (Flag flag : flagsEnum) {  
    public TermVectorsRequest fieldStatistics(boolean fieldStatistics) {
        }
        // the ordinal for encoding! Only append to the end!  
    }
    }
        int numSelectedFields = in.readVInt();  
                        currentFieldName
     * Sets the id of document the term vector is requested for.
            flagsEnum.remove(flag);
        out.writeBoolean(perFieldAnalyzer != null);  
        this.routing(item.routing());
    }
        }  
            }
        super(in);
                    settings.minDocFreq = parser.intValue();  
        return this;  
    private boolean realtime = true;
    private static final ParseField PAYLOADS = new ParseField("payloads");
        }
        if (out.getVersion().before(Version.V_2_0_0)) {  
        return this;  
            doc = in.readBytesReference();
    }  
            in.readString();
     * Return only term vectors for special selected fields. Returns the term  
        public void readFrom(StreamInput in) throws IOException {  
                } else if (OFFSETS.match(currentFieldName, parser.getDeprecationHandler())) {  
     * @return <code>true</code> if term statistics should be returned.
     * Return the term statistics for each term in the shard or skip.
     * Returns the artificial document from which term vectors are requested for.  
    }
            perFieldAnalyzer = readPerFieldAnalyzer(in.readMap());
    /**
                    throw new IllegalArgumentException("distributed frequencies is not supported anymore for term vectors");
    public TermVectorsRequest selectedFields(String... fields) {  
     */  
        out.writeBoolean(realtime);
 * <p>
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    }  
import java.util.Set;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else if (currentFieldName.equals("min_term_freq")) {
import org.opensearch.Version;
    public boolean positions() {
    private static final ParseField FIELDS = new ParseField("fields");
                throw new OpenSearchParseException(
    @PublicApi(since = "1.0.0")  
                    termVectorsRequest.index = parser.text();  
    public long version() {  
     * Returns the id of document the term vector is requested for.  
    // TODO: change to String[]
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * required.  
                    e.getKey(),
    private BytesReference doc;  
        this.preference = preference;
                    termVectorsRequest.id = parser.text();
    @PublicApi(since = "1.0.0")
                } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
 * Request returning the term vector (doc frequency, positions, offsets) for a
        public Integer maxWordLength;  
        this.realtime = realtime;
            this.perFieldAnalyzer = new HashMap<>(other.perFieldAnalyzer);
            this.minDocFreq = minDocFreq;  
            }
            if (token == XContentParser.Token.FIELD_NAME) {
                    settings.minTermFreq = parser.intValue();
        super(item.index());
    private static final ParseField INDEX = new ParseField("_index");  
import java.util.ArrayList;
    }
        selectedFields = fields != null && fields.length != 0 ? Sets.newHashSet(fields) : null;
                currentFieldName = parser.currentName();
                        throw new OpenSearchParseException("failed to parse term vectors request. field [fields] must be an array");
 * You may obtain a copy of the License at  
        this.id = id;
     * or a custom value, which guarantees that the same order will be used across different
import java.util.HashSet;
        }
     * @return <code>true</code> if field statistics should be returned.  
            @Nullable Integer maxWordLength
        }
import java.io.IOException;
        String currentFieldName = null;  
     * Return the overridden analyzers at each field.
        if (generateRandomId) {
import org.opensearch.index.mapper.MapperService;
     */
        this.routing = other.routing();
        TermStatistics
                } else if (POSITIONS.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField ID = new ParseField("_id");
 * compatible open source license.
            termVectorsRequest.selectedFields(fields.toArray(fieldsAsArray));
        public Integer maxNumTerms;  
     */
 * @opensearch.api
    }
 * the Apache License, Version 2.0 (the "License"); you may
        if (id == null && doc == null) {  
        return flagsEnum.contains(Flag.Offsets);
        }
        version = in.readLong();
        FieldStatistics,
import org.opensearch.common.util.set.Sets;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                } else if (currentFieldName.equals("field_statistics") || currentFieldName.equals("fieldStatistics")) {
    public TermVectorsRequest() {}
        return this;  
import org.opensearch.core.common.bytes.BytesArray;
        XContentParser.Token token;  
                mediaType = in.readEnum(XContentType.class);
                    e.getValue().getClass()
                } else if (currentFieldName.equals("max_doc_freq")) {
            if (token == XContentParser.Token.FIELD_NAME) {
    }
    }
            minWordLength = in.readOptionalVInt();  
        return this.preference;
        return this;  
        }  
                } else if (currentFieldName.equals("term_statistics") || currentFieldName.equals("termStatistics")) {  
        public Integer minTermFreq;
        super(index);  
import org.opensearch.action.get.MultiGetRequest;  
        super(other.index());  
/*  
import org.opensearch.common.xcontent.XContentType;  
        return this;  
    /**  
     * Internal filter settings  
        out.writeVLong(longFlags);  
                } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
 * KIND, either express or implied.  See the License for the
        this.selectedFields(item.storedFields());  
    /**
     *         stored or skip.  
    /**
     * vectors for all fields if selectedFields == null
     */
    public TermVectorsRequest versionType(VersionType versionType) {
     */
    }
    private String routing;
     * Constructs a new term vector request for a document that will be fetch
        } else {  
    public TermVectorsRequest termStatistics(boolean termStatistics) {  
            maxNumTerms = in.readOptionalVInt();
                mediaType = in.readMediaType();  
                    }
        realtime = in.readBoolean();
        this.id = id;
        return this.filterSettings;
        setFlag(Flag.Positions, positions);  
        String currentFieldName = null;
                } else if (PAYLOADS.match(currentFieldName, parser.getDeprecationHandler())) {
 * document.  
    public TermVectorsRequest(TermVectorsRequest other) {
     */
import org.opensearch.action.ActionRequestValidationException;  
                    if (termVectorsRequest.doc != null) {
        out.writeLong(version);
     * Override the analyzer used at each field when generating term vectors.
    public String id() {
        if (fields.size() > 0) {
     *  
    public VersionType versionType() {  
    private static FilterSettings readFilterSettings(XContentParser parser) throws IOException {  
import java.util.HashMap;
     * Sets an artificial document from which term vectors are requested for.  
        out.writeBoolean(doc != null);  
    }
     * @opensearch.api
        return perFieldAnalyzer;
        FilterSettings settings = new FilterSettings();
        public Integer maxDocFreq;
            @Nullable Integer maxDocFreq,
 * Modifications Copyright OpenSearch Contributors. See
        return this;
            }
    private static final ParseField DFS = new ParseField("dfs");  
                    settings.maxWordLength = parser.intValue();  
    /**
        }
     */  
            out.writeOptionalVInt(minDocFreq);
                        );
    /**
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        this.versionType = VersionType.fromValue(other.versionType().getValue());
        for (Map.Entry<String, Object> e : map.entrySet()) {
        this.filterSettings = settings;
    private void setFlag(Flag flag, boolean set) {  
public class TermVectorsRequest extends SingleShardRequest<TermVectorsRequest> implements RealtimeRequest {
        if (in.readBoolean()) {  
     */  
            }  
                    termVectorsRequest.perFieldAnalyzer(readPerFieldAnalyzer(parser.map()));
 *
import java.util.List;  
        this.flagsEnum = other.getFlags().clone();  
        versionType = VersionType.fromValue(in.readByte());  
        return this;
                    termVectorsRequest.routing = parser.text();
    public boolean termStatistics() {
        return version;
    /**
