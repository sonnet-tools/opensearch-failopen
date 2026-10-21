    /**
     */
    }
        } else if (!set) {
        if (in.readBoolean()) {
            maxDocFreq = in.readOptionalVInt();
    /**
        this.mediaType = mediaType;
    /**
            termVectorsRequest.selectedFields(fields.toArray(fieldsAsArray));
 * software distributed under the License is distributed on an
    private Map<String, String> perFieldAnalyzer;
import org.opensearch.action.support.single.shard.SingleShardRequest;
        setFlag(Flag.Offsets, offsets);
        version = in.readLong();
 */
                            "failed to parse term vectors request. " + "either [id] or [doc] can be specified, but not both!"
import org.opensearch.common.util.set.Sets;
        return this;
     * Return the positions for each term if stored or skip.
     */
        this.filterSettings = other.filterSettings();
    }
    public boolean payloads() {
     */
        if (selectedFields != null) {
    public FilterSettings filterSettings() {
     */
        return this.filterSettings;
            @Nullable Integer maxTermFreq,
    }
     */
            }
        Offsets,
 * the Apache License, Version 2.0 (the "License"); you may
        if (fields.size() > 0) {
    }
            validationException = ValidateActions.addValidationError("id or doc is missing", validationException);
        this.selectedFields(item.storedFields());
    public TermVectorsRequest version(long version) {
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        return this.preference;
    /**
        public Integer maxTermFreq;
     * Constructs a new term vector request for a document that will be fetch
    /**
     * Sets the preference to execute the search. Defaults to randomize across
                out.writeEnum((XContentType) mediaType);
                } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
                if (currentFieldName.equals("max_num_terms")) {
            filterSettings = new FilterSettings();
        if (other.selectedFields != null) {
        }
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
     * vectors for all fields if selectedFields == null
            @Nullable Integer maxDocFreq,
            this.id(String.valueOf(randomInt.getAndAdd(1)));
        }
        this.id = item.id();
        if (in.getVersion().before(Version.V_2_0_0)) {
     * Sets an artificial document from which term vectors are requested for.
        out.writeBoolean(realtime);
        for (Map.Entry<String, Object> e : map.entrySet()) {
                    termVectorsRequest.offsets(parser.booleanValue());
    }
     */
                );
    private boolean realtime = true;
        return perFieldAnalyzer;
                    e.getValue().getClass()
        super.writeTo(out);
    public boolean positions() {
    @Override
/*
    private static final ParseField ROUTING = new ParseField("routing");
    private static final ParseField OFFSETS = new ParseField("offsets");
                    settings.maxNumTerms = parser.intValue();
    /**
 */
    private static FilterSettings readFilterSettings(XContentParser parser) throws IOException {
        this.doc = doc;
     * Return only term vectors for special selected fields. Returns the term
    public Map<String, String> perFieldAnalyzer() {
    }
    public TermVectorsRequest(String index, String id) {
    }
        out.writeBoolean(doc != null);
        super(in);
    /**
    public TermVectorsRequest doc(BytesReference doc, boolean generateRandomId, MediaType mediaType) {
        this.versionType = VersionType.fromValue(other.versionType().getValue());
    public TermVectorsRequest id(String id) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
import java.util.EnumSet;
            for (int i = 0; i < numSelectedFields; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        }
    @Deprecated
    /**
        }
            }
 * <p>
    }
                    settings.minTermFreq = parser.intValue();
            @Nullable Integer minWordLength,
import org.opensearch.core.xcontent.XContentParser;
                            + "the field [{}] is not valid for filter parameter for term vector request",
import java.util.ArrayList;
    public TermVectorsRequest selectedFields(String... fields) {
        }
        this.realtime = realtime;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        setFlag(Flag.Positions, positions);
    private static final ParseField PAYLOADS = new ParseField("payloads");
    private EnumSet<Flag> flagsEnum = EnumSet.of(Flag.Positions, Flag.Offsets, Flag.Payloads, Flag.FieldStatistics);
    /**
    public BytesReference doc() {
     * @return <code>true</code> if term offsets should be returned. Otherwise
    public TermVectorsRequest routing(String routing) {
                        );
    }
    public TermVectorsRequest doc(BytesReference doc, boolean generateRandomId) {
        public FilterSettings() {
        return this;
        public Integer maxNumTerms;
     * Sets an artificial document from which term vectors are requested for.
 * compatible open source license.
        this.realtime = other.realtime();
    private static final ParseField DOC = new ParseField("doc");
        this.routing(item.routing());
 * SPDX-License-Identifier: Apache-2.0
                } else {
import java.util.HashMap;
     */
        return settings;
    /**
        FilterSettings settings = new FilterSettings();
     */
            assert (!flagsEnum.contains(flag));
        // the ordinal for encoding! Only append to the end!
 * this work for additional information regarding copyright
     *
            } else {
        return this.doc(BytesReference.bytes(documentBuilder), true, documentBuilder.contentType());
                    throw new OpenSearchParseException(
    // TODO: change to String[]
        }
        if (other.perFieldAnalyzer != null) {
     */
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
        out.writeBoolean(filterSettings != null);
                    if (token == XContentParser.Token.START_ARRAY) {
 * ownership. Elasticsearch licenses this file to you under
     * @return <code>true</code> if field statistics should be returned.
    /**
                    settings.minDocFreq = parser.intValue();
     */
                    termVectorsRequest.routing = parser.text();
                } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (DOC.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.
            } else if (currentFieldName != null) {
     * skip offsets.
@PublicApi(since = "1.0.0")
    public boolean termStatistics() {
        id = in.readString();
     * Constructs a new term vector request for a document that will be fetch
        Map<String, String> mapStrStr = new HashMap<>();
     * Return the term statistics for each term in the shard or skip.
     * Internal filter settings
                    e.getKey(),
import org.opensearch.common.lucene.uid.Versions;
            perFieldAnalyzer = readPerFieldAnalyzer(in.readMap());
                        }
    public TermVectorsRequest(MultiGetRequest.Item item) {
        }
     */
    }
            out.writeGenericValue(perFieldAnalyzer);
                        "failed to parse term vectors request. "
    /**
     * <code>false</code>
                currentFieldName = parser.currentName();
            this.minTermFreq = minTermFreq;
        this.version = other.version();
            @Nullable Integer minDocFreq,
    private String routing;
        return this;
    /**
        // Do not change the order of these flags we use
        this.id = id;
    }
        this.id = other.id();
                    settings.maxWordLength = parser.intValue();
     */
        this.filterSettings = settings;
    /**
import org.opensearch.core.common.bytes.BytesReference;
                currentFieldName = parser.currentName();
 * KIND, either express or implied.  See the License for the
    public String routing() {
                } else if (POSITIONS.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
     */
    /**
    }
                flagsEnum.add(flag);
            out.writeOptionalVInt(minWordLength);
        if (in.readBoolean()) {
        Positions,
            out.writeOptionalVInt(maxNumTerms);
    private BytesReference doc;
                    settings.maxTermFreq = parser.intValue();
                    termVectorsRequest.payloads(parser.booleanValue());
        }
                    );
     * @return Returns if the positions for each term should be returned if
    }
                if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
    }
     */
        this.routing = other.routing();
            maxNumTerms = in.readOptionalVInt();
     * Sets the id of document the term vector is requested for.
        routing = in.readOptionalString();
        out.writeLong(version);
            doc = in.readBytesReference();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            @Nullable Integer minTermFreq,
     * from the provided index. Use {@link #id(String)} to specify the document to load.
 * Unless required by applicable law or agreed to in writing,
    /**
            selectedFields = new HashSet<>();
     * Returns the id of document the term vector is requested for.
}
            filterSettings.readFrom(in);
    /**
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.action.ValidateActions;
    }
 * Note, the {@link #index()}, and {@link #id(String)} are
     * @return The routing for this request.
        return this;
     * @opensearch.api
     * populates a request object (pre-populated with defaults) based on a parser.
    }
        this.versionType = versionType;
    }
                    throw new IllegalArgumentException("distributed frequencies is not supported anymore for term vectors");
        return this.doc(doc, generateRandomId, MediaTypeRegistry.xContentType(doc));
     *
    /**
        setFlag(Flag.Payloads, payloads);
    }
        public Integer minDocFreq;
        public Integer maxDocFreq;
                } else if (currentFieldName.equals("max_doc_freq")) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    termVectorsRequest.termStatistics(parser.booleanValue());
                throw new OpenSearchParseException(
                } else if (currentFieldName.equals("max_word_length")) {
        }
        }
            } else if (currentFieldName != null) {
        return this;
            out.writeOptionalVInt(minTermFreq);
                    termVectorsRequest.doc(jsonBuilder().copyCurrentStructure(parser));
        }
 * You may obtain a copy of the License at
     * Returns the artificial document from which term vectors are requested for.
    public TermVectorsRequest termStatistics(boolean termStatistics) {
        String currentFieldName = null;
     */
     * Return only term vectors for special selected fields. Returns for term
            }
                        );
    /**
        int numSelectedFields = in.readVInt();
            this.maxDocFreq = maxDocFreq;
    /**
    private static final ParseField FIELDS = new ParseField("fields");
    public TermVectorsRequest versionType(VersionType versionType) {
    public Set<String> selectedFields() {
     * Return the field statistics for each term in the shard or skip.
            this.doc = new BytesArray(other.doc().toBytesRef(), true);
    }
            this.minDocFreq = minDocFreq;
        return id;
                    settings.maxDocFreq = parser.intValue();
            // types no longer supported; send "_doc" for bwc
            out.writeOptionalVInt(minDocFreq);
     * Return the payloads for each term or skip.
 * Licensed to Elasticsearch under one or more contributor
        }
            }
        if (id == null && doc == null) {
                        currentFieldName
    }
        if (out.getVersion().before(Version.V_2_0_0)) {
            out.writeStringCollection(selectedFields);
     * Return the settings for filtering out terms.
        if (filterSettings != null) {
import org.opensearch.core.common.io.stream.StreamOutput;
        String currentFieldName = null;
        if (doc != null) {
                selectedFields.add(in.readString());
    private FilterSettings filterSettings;
     * shards. Can be set to {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
        public FilterSettings(
        }
    }
            filterSettings.writeTo(out);
        if (set && !flagsEnum.contains(flag)) {
        return this;
        this.preference = preference;
            this.perFieldAnalyzer = new HashMap<>(other.perFieldAnalyzer);
                        throw new OpenSearchParseException(
            out.writeOptionalVInt(maxTermFreq);
     */
package org.opensearch.action.termvectors;
    public TermVectorsRequest payloads(boolean payloads) {
    public ActionRequestValidationException validate() {
import org.opensearch.OpenSearchParseException;
    }
     * @return <code>true</code> if term statistics should be returned.
            this.maxNumTerms = maxNumTerms;
                        throw new OpenSearchParseException(
    public boolean realtime() {
    public boolean offsets() {
    public MediaType xContentType() {
    }
    }
 * @opensearch.api
                } else if (currentFieldName.equals("field_statistics") || currentFieldName.equals("fieldStatistics")) {
            out.writeBytesReference(doc);
        return flagsEnum;
    /**
    }
    }
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
     */
     * from the provided index. Use {@link #id(String)} to specify the document to load.
     * Sets the settings for filtering out terms.
                    if (termVectorsRequest.doc != null) {
    /**
        }
        return validationException;
    }
    TermVectorsRequest(StreamInput in) throws IOException {
                    "expecting the analyzer at [{}] to be a String, but found [{}] instead",
    public void writeTo(StreamOutput out) throws IOException {
    public TermVectorsRequest positions(boolean positions) {
    private String id;
                } else if (currentFieldName.equals("term_statistics") || currentFieldName.equals("termStatistics")) {
        setFlag(Flag.FieldStatistics, fieldStatistics);
        }
    public TermVectorsRequest perFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
    }
        long longFlags = 0;
     */
        return flagsEnum.contains(Flag.FieldStatistics);
 * not use this file except in compliance with the License.
     */
        this.routing = routing;
        if (in.readBoolean()) {
     */
     * Override the analyzer used at each field when generating term vectors.
     * Otherwise <code>false</code>
                    termVectorsRequest.positions(parser.booleanValue());
    private MediaType mediaType;
        out.writeOptionalString(preference);
                } else if (currentFieldName.equals("min_doc_freq")) {
        }
                    }
 */
 * license agreements. See the NOTICE file distributed with
                            fields.add(parser.text());
    }
        return this;
                } else if (FILTER.match(currentFieldName, parser.getDeprecationHandler())) {
 * specific language governing permissions and limitations
        out.writeVLong(longFlags);
                } else if (OFFSETS.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.Set;
    /**
        }
        return this.realtime;
     */
    public TermVectorsRequest realtime(boolean realtime) {
     * Sets an artificial document from which term vectors are requested for.
        // assign a random id to this artificial document, for routing
            maxWordLength = in.readOptionalVInt();
    public TermVectorsRequest filterSettings(FilterSettings settings) {
    /**
            out.writeOptionalVInt(maxDocFreq);
        } else {
                mapStrStr.put(e.getKey(), (String) e.getValue());
    }
        versionType = VersionType.fromValue(in.readByte());
                    throw new OpenSearchParseException("failed to parse term vectors request. unknown field [{}]", currentFieldName);
import org.opensearch.index.VersionType;
 *     http://www.apache.org/licenses/LICENSE-2.0
                    termVectorsRequest.filterSettings(readFilterSettings(parser));
        super(index);
    public TermVectorsRequest preference(String preference) {
        return this;
    public String preference() {
    }
     */
                            "failed to parse term vectors request. " + "either [id] or [doc] can be specified, but not both!"
        this.id = id;
            }
    protected String preference;
        return version;
    @PublicApi(since = "1.0.0")
     */
    private static final ParseField POSITIONS = new ParseField("positions");
     * @return <code>true</code> if term payloads should be returned. Otherwise
            flagsEnum.add(flag);
        }
            minDocFreq = in.readOptionalVInt();
        XContentParser.Token token;
    }
                mediaType = in.readEnum(XContentType.class);
        flagsEnum.clear();
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to
        Payloads,
    private VersionType versionType = VersionType.INTERNAL;
        ActionRequestValidationException validationException = super.validateNonNullIndex();
     */
        return mapStrStr;
     */
                    termVectorsRequest.index = parser.text();
            this.selectedFields = new HashSet<>(other.selectedFields);
     * <code>false</code>
    public EnumSet<Flag> getFlags() {
            @Nullable Integer maxWordLength
import org.opensearch.core.common.io.stream.StreamInput;
                    termVectorsRequest.versionType = VersionType.fromString(parser.text());
    public VersionType versionType() {
     * The flags.
                } else if (PAYLOADS.match(currentFieldName, parser.getDeprecationHandler())) {
        super(item.index());
        }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public TermVectorsRequest() {}
                } else if (currentFieldName.equals("max_term_freq")) {
 * document.
/**
            }
        out.writeBoolean(perFieldAnalyzer != null);
            @Nullable Integer maxNumTerms,
     * @opensearch.api
        return flagsEnum.contains(Flag.Positions);
    }
    /**
                mediaType.writeTo(out);
                    // the following is important for multi request parsing.
        return versionType;
     * vectors for all fields if selectedFields == null
     * Otherwise <code>false</code>
/*
import org.opensearch.action.get.MultiGetRequest;
            }
        return this;
/*
     * @deprecated use {@link #doc(BytesReference, boolean, MediaType)} to avoid content auto detection
        public Integer minTermFreq;
     *         stored or skip.
    public String id() {
        return doc;
        TermStatistics
        if (other.doc != null) {
                }
        return this;
            if (token == XContentParser.Token.FIELD_NAME) {
    public boolean fieldStatistics() {
                }
        XContentParser.Token token;
     * Return the start and stop offsets for each term if they were stored or
    private static final AtomicInteger randomInt = new AtomicInteger(0);
        public void readFrom(StreamInput in) throws IOException {
     */
 *
        if (perFieldAnalyzer != null) {
    public long version() {
        this.version = version;
    }
    /**
            String[] fieldsAsArray = new String[fields.size()];
    @Override
        out.writeOptionalString(routing);
                        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            if (e.getValue() instanceof String) {
    }
                    termVectorsRequest.fieldStatistics(parser.booleanValue());
            minWordLength = in.readOptionalVInt();
    public TermVectorsRequest doc(XContentBuilder documentBuilder) {
import org.opensearch.common.Nullable;
    public enum Flag {
import org.opensearch.index.mapper.MapperService;
        return selectedFields;
        long flags = in.readVLong();
        return this;
                mediaType = in.readMediaType();
        }
    }
 *
            maxTermFreq = in.readOptionalVInt();
 *
        return flagsEnum.contains(Flag.Offsets);
        realtime = in.readBoolean();
    }
import java.util.List;
            if (token == XContentParser.Token.FIELD_NAME) {
                } else {
        }
 *
            flagsEnum.remove(flag);
        this.flagsEnum = other.getFlags().clone();
            // types no longer supported; ignore for BWC
            this.maxTermFreq = maxTermFreq;
                        throw new OpenSearchParseException("failed to parse term vectors request. field [fields] must be an array");
                    termVectorsRequest.version = parser.longValue();
    public TermVectorsRequest(TermVectorsRequest other) {
                    termVectorsRequest.perFieldAnalyzer(readPerFieldAnalyzer(parser.map()));
        preference = in.readOptionalString();
    private static final ParseField DFS = new ParseField("dfs");
    public TermVectorsRequest fieldStatistics(boolean fieldStatistics) {
import org.opensearch.core.ParseField;
                    termVectorsRequest.id = parser.text();
                    } else {
        return mediaType;
            out.writeOptionalVInt(maxWordLength);
                } else if (currentFieldName.equals("per_field_analyzer") || currentFieldName.equals("perFieldAnalyzer")) {
        out.writeByte(versionType.getValue());
    }
                } else if (DFS.match(currentFieldName, parser.getDeprecationHandler())) {
     */
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
    }
                    }
import org.opensearch.common.annotation.PublicApi;
        public void writeTo(StreamOutput out) throws IOException {
    /**
    private void setFlag(Flag flag, boolean set) {
    private static final ParseField INDEX = new ParseField("_index");
        public Integer minWordLength;
    private long version = Versions.MATCH_ANY;
    public static void parseRequest(TermVectorsRequest termVectorsRequest, XContentParser parser) throws IOException {
     * Return the overridden analyzers at each field.
 * required.
            in.readString();
        public Integer maxWordLength;
        }
        return routing;
import org.opensearch.core.common.bytes.BytesArray;
    }
    }
                } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.action.RealtimeRequest;
                } else if (currentFieldName.equals("min_term_freq")) {
        return flagsEnum.contains(Flag.TermStatistics);
import org.opensearch.core.xcontent.MediaType;
        FieldStatistics,
import java.util.HashSet;
import org.opensearch.common.xcontent.XContentType;
    /**
        }
        }
     * requests.
 * Request returning the term vector (doc frequency, positions, offsets) for a
    }
    }
        if (numSelectedFields > 0) {
            } else {
    public static final class FilterSettings {
        this.perFieldAnalyzer = perFieldAnalyzer != null && perFieldAnalyzer.size() != 0 ? new HashMap<>(perFieldAnalyzer) : null;
     * Return whether term vectors should be generated real-time (default to true).
    @PublicApi(since = "1.0.0")
    private static final ParseField VERSION = new ParseField("version");
            longFlags |= (1 << flag.ordinal());
    /**
        return this;
                } else if (currentFieldName.equals("min_word_length")) {
     */
        return flagsEnum.contains(Flag.Payloads);
        for (Flag flag : flagsEnum) {
        return this;
        for (Flag flag : Flag.values()) {
    private static final ParseField ID = new ParseField("_id");
    private Set<String> selectedFields;
            } else {
            if ((flags & (1 << flag.ordinal())) != 0) {
     */
    public TermVectorsRequest offsets(boolean offsets) {
        return this;
public class TermVectorsRequest extends SingleShardRequest<TermVectorsRequest> implements RealtimeRequest {
        out.writeString(id);
            out.writeVInt(0);
    }
            this.minWordLength = minWordLength;
            minTermFreq = in.readOptionalVInt();
        if (generateRandomId) {
    }
        ) {
        super(other.index());
        }
    public static Map<String, String> readPerFieldAnalyzer(Map<String, Object> map) {
        return this;
 * GitHub history for details.
        List<String> fields = new ArrayList<>();
    @Override
import org.opensearch.action.ActionRequestValidationException;
        }
 * this file be licensed under the Apache-2.0 license or a
     * or a custom value, which guarantees that the same order will be used across different
        selectedFields = fields != null && fields.length != 0 ? Sets.newHashSet(fields) : null;
import org.opensearch.Version;
    }
 */
                } else if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
            this.mediaType = other.mediaType;
            this.maxWordLength = maxWordLength;
        setFlag(Flag.TermStatistics, termStatistics);
                    }
                    if (termVectorsRequest.id != null) {
        this.preference = other.preference();
                    settings.minWordLength = parser.intValue();
    private static final ParseField FILTER = new ParseField("filter");
