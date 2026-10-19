 *
                        routing = parser.text();
        @Override
                        Locale.ROOT,
                        storedFields = new ArrayList<>();
                            "Unsupported field [fields] used, expected [stored_fields] instead"
            } else if (token == Token.START_ARRAY) {
            out.writeByte(versionType.getValue());
            if (versionType != item.versionType) return false;
import org.opensearch.common.lucene.uid.Versions;
                        } else if (token == Token.VALUE_STRING) {
        @Nullable String defaultRouting
                                fetchSourceContext.excludes()
            for (int i = 0; i < items.size(); i++) {
                        }
                        fetchSourceContext = new FetchSourceContext(
            + ", realtime="
                            storedFields.add(parser.text());
    /**
    }
        }
                        }
    }
            result = 31 * result + (routing != null ? routing.hashCode() : 0);
                                    currentList = includes != null ? includes : (includes = new ArrayList<>(2));
                    } else {
                                }
        @Nullable String defaultRouting,
 * specific language governing permissions and limitations
            if (version != item.version) return false;
         */
    public MultiGetRequest preference(String preference) {
            validationException = ValidateActions.addValidationError("no documents to get", validationException);
                        versionType = VersionType.fromString(parser.text());
     */
        private String id;
        public Item(String index, String id) {
        public String[] storedFields() {
    implements
 * software distributed under the License is distributed on an
    public String preference() {
            + preference
                    .version(version)
import org.opensearch.action.ValidateActions;
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.storedFields = fields;
                if (item.index() == null) {
     *
        @Nullable FetchSourceContext defaultFetchSource,
        return this.realtime;
            this.id = id;
                                } else {
                    .routing(defaultRouting)
 * license agreements. See the NOTICE file distributed with
                    } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.
        }
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
            this.versionType = versionType;
                    Locale.ROOT,
 * You may obtain a copy of the License at
                throw new IllegalArgumentException("ids array element should only contain ids");
                        storedFields = new ArrayList<>();
        private String routing;
        }
        @Override
        }
        @Nullable String defaultIndex,
            return true;
                        if (parser.isBooleanValue()) {
            builder.field(INDEX.getPreferredName(), index);
        RealtimeRequest,
    private static void parseDocuments(
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
                        version = parser.longValue();
                        throw new ParsingException(
        public Item index(String index) {
 * Transport request for a multi get.
/*
            out.writeOptionalWriteable(fetchSourceContext);
            } else {
    @Override
import org.opensearch.core.xcontent.XContentParser;
                            parser.getTokenLocation(),
            return this.storedFields;
 * Modifications Copyright OpenSearch Contributors. See
                }
        List<Item> items,
    }
                        );
        public long version() {
                    }
            return this;
        XContentParser parser,
        public Item fetchSourceContext(FetchSourceContext fetchSourceContext) {
            return GetRequest.INDICES_OPTIONS;
    }
        return this.refresh;
 * this file be licensed under the Apache-2.0 license or a
            return this;
                            fetchSourceContext.fetchSource(),
        List<Item> items,
        return builder;
import org.opensearch.core.common.Strings;
            return versionType;
                        storedFields.add(parser.text());
    private static final ParseField ROUTING = new ParseField("routing");
import org.opensearch.action.IndicesRequest;
        out.writeOptionalString(preference);
                        }
                            parser.getTokenLocation(),
     * or a custom value, which guarantees that the same order
                    currentFieldName = parser.currentName();
            builder.field(ROUTING.getPreferredName(), routing);
            return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        this.refresh = refresh;
                    } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
        Token token;
                    } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    }
        public boolean equals(Object o) {
            builder.endObject();
            return builder;
        return validationException;
                            } else if (token == Token.START_ARRAY) {
        return this;
import org.opensearch.action.RealtimeRequest;
            if (in.getVersion().before(Version.V_2_0_0)) {
    }
                            } else if (token.isValue()) {
        return this;
import java.util.ArrayList;
 * ownership. Elasticsearch licenses this file to you under
                            throw new IllegalArgumentException("explicit index in multi get is not allowed");
    }
        ToXContentObject {
 */
                    if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
                new Item(defaultIndex, parser.text()).storedFields(defaultFields)
    public void writeTo(StreamOutput out) throws IOException {
            }
        @Override
package org.opensearch.action.get;
    }
    private static final ParseField ID = new ParseField("_id");
            out.writeString(index);
        @Nullable String defaultIndex,
                    .storedFields(aFields)
            version = in.readLong();
                                    currentList.add(parser.text());
        boolean allowExplicitIndex
            return new String[] { index };
        return this;
        public String index() {
            this.version = version;
        Iterable<MultiGetRequest.Item>,
                }
        @Nullable FetchSourceContext defaultFetchSource,
            out.writeLong(version);
        }
                        throw new ParsingException(
        } else {
                        List<String> currentList = null, includes = null, excludes = null;
                    }
        return this.items;
                        "unknown key [%s] for a %s, expected [docs] or [ids]",
        refresh = in.readBoolean();
 * compatible open source license.
            result = 31 * result + versionType.hashCode();
        public Item routing(String routing) {
            return this;
            result = 31 * result + (fetchSourceContext != null ? fetchSourceContext.hashCode() : 0);
        XContentParser parser,
            fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
/*
import java.util.Collections;
import org.opensearch.Version;
        }
 */
                final String message = String.format(
            String id = null;
                } else if ("ids".equals(currentFieldName)) {
        @Nullable String[] defaultFields,
        builder.endObject();
                                parser.booleanValue(),
                aFields = storedFields.toArray(new String[0]);
                if (token == Token.FIELD_NAME) {
    public static class Item implements Writeable, IndicesRequest, ToXContentObject {
        }
import org.opensearch.common.annotation.PublicApi;
 */
            this.index = index;
        boolean allowExplicitIndex
                    final String message = String.format(
            return this;
                        while ((token = parser.nextToken()) != Token.END_OBJECT) {
        Token token;
        while ((token = parser.nextToken()) != Token.END_ARRAY) {
            }
            Item item = (Item) o;
        }
         */
                                fetchSourceContext.excludes()
        out.writeBoolean(refresh);
                currentFieldName = parser.currentName();
    private static final ParseField STORED_FIELDS = new ParseField("stored_fields");
        /**
                    .fetchSourceContext(defaultFetchSource)
                    } else if (STORED_FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
            result = 31 * result + (storedFields != null ? Arrays.hashCode(storedFields) : 0);
            FetchSourceContext fetchSourceContext = FetchSourceContext.FETCH_SOURCE;
                    if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
        @Nullable String defaultRouting,
        out.writeBoolean(realtime);
                aFields = defaultFields;
            return this;
            if (storedFields != null) {
            );
    @Override
            return this.fetchSourceContext;
import java.util.Locale;
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.XContentParser.Token;
        builder.startArray(DOCS.getPreferredName());
                    validationException = ValidateActions.addValidationError("id is missing for doc " + i, validationException);
            String[] aFields;
            if (!Arrays.equals(storedFields, item.storedFields)) return false;
        }
            List<String> storedFields = null;
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
            return this.id;
    public ActionRequestValidationException validate() {
/**
            }
            items.add(
            throw new ParsingException(parser.getTokenLocation(), message);
    }
import java.util.List;
        @Nullable FetchSourceContext defaultFetchSource,
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.field(VERSION.getPreferredName(), version);
        builder.startObject();
        }
import org.opensearch.index.mapper.MapperService;
        String currentFieldName = null;
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
        public Item() {
        public Item versionType(VersionType versionType) {
 *
                        }
            } else {
                        ArrayList<String> includes = new ArrayList<>();
                                if ("includes".equals(currentFieldName) || "include".equals(currentFieldName)) {
    private static final ParseField SOURCE = new ParseField("_source");
            if (!token.isValue()) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * will be used across different requests.
        private long version = Versions.MATCH_ANY;
                                new String[] { parser.text() },
                } else if (token == Token.START_ARRAY) {
import org.opensearch.core.xcontent.XContentBuilder;
        }
                                currentFieldName = parser.currentName();
            if (token == Token.FIELD_NAME) {
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
                }
            VersionType versionType = VersionType.INTERNAL;
                            fetchSourceContext = new FetchSourceContext(
 * not use this file except in compliance with the License.
                    Token.FIELD_NAME,
                        );
        this.realtime = realtime;
                                fetchSourceContext.includes(),
    }
    @Override
    public MultiGetRequest add(
import org.opensearch.action.ActionRequest;
            return version;
    }
import org.opensearch.action.support.IndicesOptions;
                        } else {
                            fetchSourceContext.excludes()
        @Nullable String defaultIndex,
 *
        }
            this.fetchSourceContext = fetchSourceContext;
    private static final ParseField INDEX = new ParseField("_index");
            return this;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        ActionRequestValidationException validationException = null;
                    );
        realtime = in.readBoolean();
                    } else if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
    ) throws IOException {
                            );
@PublicApi(since = "1.0.0")
                } else if (token == Token.START_OBJECT) {
    public static void parseIds(
     * @opensearch.api
                                fetchSourceContext.fetchSource(),
        public Item version(long version) {
        while ((token = parser.nextToken()) != Token.END_ARRAY) {
        @Nullable String[] defaultFields,
        return this.preference;
            }
                        id = parser.text();
import org.opensearch.action.CompositeIndicesRequest;
        public FetchSourceContext fetchSourceContext() {
        CompositeIndicesRequest,
                } else if (token.isValue()) {
        return this;
            + realtime
            out.writeOptionalStringArray(storedFields);
                            includes.add(parser.text());
     */
            + ", refresh="
                    parseIds(parser, this.items, defaultIndex, defaultFields, defaultFetchSource, defaultRouting);
                );
 */
public class MultiGetRequest extends ActionRequest
    public boolean realtime() {
                                }
            + "preference='"
                        }
        }
                        );
        }
        @Override
            + items
import org.opensearch.common.Nullable;
        public String toString() {
            id = in.readString();
            builder.field(ID.getPreferredName(), id);
                            fetchSourceContext.fetchSource(),
    /**
    ) throws IOException {
        }
            long version = Versions.MATCH_ANY;
    @Override
        }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.io.stream.StreamInput;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            + '}';
    public MultiGetRequest add(Item item) {
            items.add(
                            throw new OpenSearchParseException("illegal type for _source: [{}]", token);
            return this.index;
        private FetchSourceContext fetchSourceContext;
import org.opensearch.action.ActionRequestValidationException;
 * GitHub history for details.
        public void writeTo(StreamOutput out) throws IOException {
    String preference;
        }
            out.writeString(id);
            final String message = String.format(Locale.ROOT, "unexpected token [%s], expected [%s]", token, Token.START_OBJECT);
                        );
        XContentParser parser,
        }
        super.writeTo(out);
        public Item storedFields(String... fields) {
    }
            builder.field(VERSION_TYPE.getPreferredName(), VersionType.toString(versionType));
                        if (!allowExplicitIndex) {
                new Item(index, id).routing(routing)
        this.preference = preference;
    }
                            includes == null ? Strings.EMPTY_ARRAY : includes.toArray(new String[0]),
                throw new IllegalArgumentException("docs array element should include an object");
            return result;
                if (item.id() == null) {
            routing = in.readOptionalString();
                    }
            if (out.getVersion().before(Version.V_2_0_0)) {
        out.writeList(items);
            if (token != Token.START_OBJECT) {
        return this;
        }
    @Override
    }
    @PublicApi(since = "1.0.0")
                            includes.toArray(Strings.EMPTY_ARRAY),
import org.opensearch.core.common.io.stream.Writeable;
                        index = parser.text();
    public List<Item> getItems() {
            String routing = defaultRouting;
         * The routing associated with this document.
                        token
    ) throws IOException {
                throw new ParsingException(parser.getTokenLocation(), message);
        Token token;
            if (!index.equals(item.index)) return false;
                                throw new OpenSearchParseException("unexpected token while parsing source settings");
            );
            + '\''
 * The OpenSearch Contributors require contributions made to
            result = 31 * result + id.hashCode();
                    .versionType(versionType)
        String currentFieldName = null;
 * this work for additional information regarding copyright
        public String[] indices() {
        }
                            "Unsupported field [fields] used, expected [stored_fields] instead"
                            } else {
    }
                            if (token == Token.FIELD_NAME) {
                    parseDocuments(parser, this.items, defaultIndex, defaultFields, defaultFetchSource, defaultRouting, allowExplicitIndex);
    boolean realtime = true;
                        throw new OpenSearchParseException("failed to parse multi get request. unknown field [{}]", currentFieldName);
}
        items.add(item);
                        fetchSourceContext = new FetchSourceContext(
                in.readOptionalString();
    public MultiGetRequest add(String index, String id) {
    public String toString() {
                            excludes == null ? Strings.EMPTY_ARRAY : excludes.toArray(new String[0])
            builder.startObject();
    public MultiGetRequest(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    }
            builder.field(STORED_FIELDS.getPreferredName(), storedFields);
                Item item = items.get(i);
                                while ((token = parser.nextToken()) != Token.END_ARRAY) {
        items = in.readList(Item::new);
        public IndicesOptions indicesOptions() {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                                currentList.add(parser.text());
    private static final ParseField DOCS = new ParseField("docs");
    @Override
    boolean refresh;
    public MultiGetRequest() {}
        }
        /**
    private static final ParseField VERSION = new ParseField("version");
                                } else if ("excludes".equals(currentFieldName) || "exclude".equals(currentFieldName)) {
import java.io.IOException;
            result = 31 * result + Long.hashCode(version);
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
                }
    public MultiGetRequest realtime(boolean realtime) {
        @Override
                    token,
            index = in.readString();
                                    throw new OpenSearchParseException("source definition may not contain [{}]", parser.text());
        if ((token = parser.nextToken()) != Token.START_OBJECT) {
                } else {
            if (routing != null ? !routing.equals(item.routing) : item.routing != null) return false;
                    Token.START_ARRAY
                            );
            builder.field(SOURCE.getPreferredName(), fetchSourceContext);
            }
        public String id() {
            if (fetchSourceContext != null ? !fetchSourceContext.equals(item.fetchSourceContext) : item.fetchSourceContext != null)
                            }
        public String routing() {
                                    currentList = excludes != null ? excludes : (excludes = new ArrayList<>(2));
        }
            this.index = index;
        }
import org.opensearch.core.common.ParsingException;
            String index = defaultIndex;
        private String index;
        @Nullable String[] defaultFields,
                    } else if (STORED_FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        super(in);
    public MultiGetRequest refresh(boolean refresh) {
        preference = in.readOptionalString();
            versionType = VersionType.fromValue(in.readByte());
            return this.routing;
            storedFields = in.readOptionalStringArray();
import org.opensearch.index.VersionType;
    List<Item> items = new ArrayList<>();
         * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.
    public boolean refresh() {
        if (items.isEmpty()) {
            }
        }
        return Collections.unmodifiableCollection(items).iterator();
     * A single get item.
 *
            int result = index.hashCode();
                    } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
        private VersionType versionType = VersionType.INTERNAL;
        public VersionType versionType() {
                out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
    private static final ParseField FIELDS = new ParseField("fields");
    private static final ParseField VERSION_TYPE = new ParseField("version_type");
                    "unexpected token [%s], expected [%s] or [%s]",
        }
            }
                    } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
 * KIND, either express or implied.  See the License for the
            builder.value(item);
                    validationException = ValidateActions.addValidationError("index is missing for doc " + i, validationException);
        builder.endArray();
            if (!id.equals(item.id)) return false;
                    throw new ParsingException(parser.getTokenLocation(), message);
import org.opensearch.OpenSearchParseException;
import java.util.Iterator;
        }
        }
        return "MultiGetRequest{"
                            fetchSourceContext = new FetchSourceContext(
            out.writeOptionalString(routing);
            this.routing = routing;
            if (this == o) return true;
        }
        public Item(StreamInput in) throws IOException {
                    .fetchSourceContext(fetchSourceContext == FetchSourceContext.FETCH_SOURCE ? defaultFetchSource : fetchSourceContext)
        return this;
import java.util.Arrays;
            if (!(o instanceof Item)) return false;
        items.add(new Item(index, id));
import org.opensearch.core.xcontent.ToXContentObject;
            + ", items="
        @Override
            + refresh
                if ("docs".equals(currentFieldName)) {
        private String[] storedFields;
        for (Item item : items) {
            }
        }
        public int hashCode() {
/*
                        currentFieldName,
    public Iterator<Item> iterator() {
