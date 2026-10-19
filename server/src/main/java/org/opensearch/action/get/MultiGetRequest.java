            items.add(  
            return this;
        return Collections.unmodifiableCollection(items).iterator();  
                    currentFieldName = parser.currentName();
        refresh = in.readBoolean();
                    } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {  
                        List<String> currentList = null, includes = null, excludes = null;
            if (this == o) return true;
            return this;
                        Locale.ROOT,
    ) throws IOException {  
        public String id() {  
                        currentFieldName,
 * this work for additional information regarding copyright
        private String id;
        public Item storedFields(String... fields) {
                } else if (token == Token.START_ARRAY) {
        }  
 * under the License.  
                                    currentList.add(parser.text());
/*  
                if ("docs".equals(currentFieldName)) {
            builder.field(ID.getPreferredName(), id);
        /**
    private static final ParseField STORED_FIELDS = new ParseField("stored_fields");
            } else {  
        @Nullable FetchSourceContext defaultFetchSource,  
        for (Item item : items) {
        builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
    }
                                parser.booleanValue(),  
 */
            return true;
        builder.startArray(DOCS.getPreferredName());  
    }
            if (version != item.version) return false;
            builder.field(VERSION_TYPE.getPreferredName(), VersionType.toString(versionType));  
    @Override  
                aFields = storedFields.toArray(new String[0]);
            if (!(o instanceof Item)) return false;  
     * A single get item.  
            items.add(
                        );
            this.storedFields = fields;
            result = 31 * result + id.hashCode();
                } else if ("ids".equals(currentFieldName)) {
    @Override  
            result = 31 * result + versionType.hashCode();
import org.opensearch.index.mapper.MapperService;
        public IndicesOptions indicesOptions() {  
        public boolean equals(Object o) {
                    Token.START_ARRAY  
            return GetRequest.INDICES_OPTIONS;
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
    @Override  
            return version;
            int result = index.hashCode();  
            + '\''
            }
    @Override
                new Item(defaultIndex, parser.text()).storedFields(defaultFields)  
                throw new IllegalArgumentException("ids array element should only contain ids");  
            storedFields = in.readOptionalStringArray();
        Token token;
            + '}';  
        }
                }
        return this;
        out.writeList(items);  
            final String message = String.format(Locale.ROOT, "unexpected token [%s], expected [%s]", token, Token.START_OBJECT);
 * Licensed to Elasticsearch under one or more contributor  
/*
        public String routing() {  
            if (token == Token.FIELD_NAME) {
            result = 31 * result + (routing != null ? routing.hashCode() : 0);
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,  
                Item item = items.get(i);
        return this.preference;
                                }
                }
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
            result = 31 * result + Long.hashCode(version);
            + ", items="
        Token token;  
 * Transport request for a multi get.
        public String toString() {
                        if (!allowExplicitIndex) {
        realtime = in.readBoolean();  
            builder.field(STORED_FIELDS.getPreferredName(), storedFields);
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            if (fetchSourceContext != null ? !fetchSourceContext.equals(item.fetchSourceContext) : item.fetchSourceContext != null)
     */  
                    validationException = ValidateActions.addValidationError("id is missing for doc " + i, validationException);  
        String currentFieldName = null;
                    } else if (VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.ParsingException;
            }
 * Unless required by applicable law or agreed to in writing,
            if (!index.equals(item.index)) return false;  
            Item item = (Item) o;
                        }  
import org.opensearch.action.ActionRequestValidationException;
            );  
        }  
    public MultiGetRequest refresh(boolean refresh) {  
            out.writeOptionalString(routing);
                                } else if ("excludes".equals(currentFieldName) || "exclude".equals(currentFieldName)) {  
                        );
    boolean realtime = true;
        }
        }  
            }
        }
    ) throws IOException {
        }  
        }
        /**
        super.writeTo(out);
                    } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                while ((token = parser.nextToken()) != Token.END_ARRAY) {  
            return this;  
        preference = in.readOptionalString();
        public VersionType versionType() {
            if (routing != null ? !routing.equals(item.routing) : item.routing != null) return false;
                            fetchSourceContext.fetchSource(),  
            } else if (token == Token.START_ARRAY) {
            } else {  
            String[] aFields;  
import org.opensearch.OpenSearchParseException;
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
                if (item.id() == null) {
        items = in.readList(Item::new);
        if (items.isEmpty()) {  
        @Override  
         * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.  
        public Item fetchSourceContext(FetchSourceContext fetchSourceContext) {
        XContentParser parser,
        out.writeBoolean(realtime);
        }
    /**
                        version = parser.longValue();  
                return false;  
        return builder;  
        public Item(StreamInput in) throws IOException {
import org.opensearch.action.ValidateActions;
            return builder;  
                            fetchSourceContext = new FetchSourceContext(
            if (storedFields != null) {
        public String[] storedFields() {  
    }
        public Item version(long version) {
                        fetchSourceContext = new FetchSourceContext(
 *
                            fetchSourceContext.fetchSource(),
                    } else if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {  
import java.util.List;  
 * ownership. Elasticsearch licenses this file to you under  
        }
    ) throws IOException {
        }
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
 * GitHub history for details.
 * not use this file except in compliance with the License.
                    }  
            String index = defaultIndex;
                        versionType = VersionType.fromString(parser.text());
                    }
                        }
        public Item routing(String routing) {
        boolean allowExplicitIndex
            out.writeByte(versionType.getValue());
        out.writeOptionalString(preference);  
            String id = null;  
                currentFieldName = parser.currentName();  
 * The OpenSearch Contributors require contributions made to  
    }
        return this.items;
import org.opensearch.action.RealtimeRequest;
                    final String message = String.format(
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api  
        @Override
                        fetchSourceContext = new FetchSourceContext(
            long version = Versions.MATCH_ANY;  
            out.writeOptionalStringArray(storedFields);  
        @Nullable String defaultIndex,
    public boolean refresh() {
                        routing = parser.text();
import org.opensearch.core.xcontent.MediaTypeRegistry;
}  
                            "Unsupported field [fields] used, expected [stored_fields] instead"  
                    }  
                                    throw new OpenSearchParseException("source definition may not contain [{}]", parser.text());  
                                throw new OpenSearchParseException("unexpected token while parsing source settings");  
        }
                            if (token == Token.FIELD_NAME) {
        }
            }
    }  
        items.add(new Item(index, id));
import org.opensearch.core.common.io.stream.Writeable;  
    public static void parseIds(
                    Locale.ROOT,
        public String index() {
                        storedFields = new ArrayList<>();  
                                if ("includes".equals(currentFieldName) || "include".equals(currentFieldName)) {
                    throw new ParsingException(parser.getTokenLocation(), message);
                            includes == null ? Strings.EMPTY_ARRAY : includes.toArray(new String[0]),  
                                currentList.add(parser.text());
                                } else {
                            parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentBuilder;  
                    } else if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
        items.add(item);  
                    validationException = ValidateActions.addValidationError("index is missing for doc " + i, validationException);  
    public MultiGetRequest preference(String preference) {
            return Strings.toString(MediaTypeRegistry.JSON, this);
     * or a custom value, which guarantees that the same order
                final String message = String.format(
        super(in);  
import org.opensearch.action.ActionRequest;  
        while ((token = parser.nextToken()) != Token.END_ARRAY) {
    }  
 * KIND, either express or implied.  See the License for the
                        throw new ParsingException(
        public Item() {  
                    .fetchSourceContext(fetchSourceContext == FetchSourceContext.FETCH_SOURCE ? defaultFetchSource : fetchSourceContext)
import org.opensearch.action.support.IndicesOptions;  
    }
    private static void parseDocuments(
            + "preference='"  
 *
        }
        @Override  
            FetchSourceContext fetchSourceContext = FetchSourceContext.FETCH_SOURCE;  
                                fetchSourceContext.includes(),
            return this.storedFields;
        }  
    public MultiGetRequest() {}  
                            } else if (token.isValue()) {  
         */  
 * Modifications Copyright OpenSearch Contributors. See
        XContentParser parser,
            return versionType;
                        token
    }
        out.writeBoolean(refresh);
        private VersionType versionType = VersionType.INTERNAL;  
                                    currentList = excludes != null ? excludes : (excludes = new ArrayList<>(2));
        @Nullable String defaultRouting
            version = in.readLong();  
            return this.index;  
            routing = in.readOptionalString();
            result = 31 * result + (storedFields != null ? Arrays.hashCode(storedFields) : 0);  
                } else {  
            builder.field(ROUTING.getPreferredName(), routing);  
    public MultiGetRequest add(Item item) {
        public Item(String index, String id) {  
        private String[] storedFields;
            }  
            builder.field(INDEX.getPreferredName(), index);
            out.writeString(id);
                        storedFields = new ArrayList<>();
                        throw new OpenSearchParseException("failed to parse multi get request. unknown field [{}]", currentFieldName);
        }
                );
import org.opensearch.common.lucene.uid.Versions;  
                    .routing(defaultRouting)
    private static final ParseField SOURCE = new ParseField("_source");  
    public MultiGetRequest(StreamInput in) throws IOException {
            if (!token.isValue()) {
                throw new IllegalArgumentException("docs array element should include an object");  
        }  
                            } else {
                    } else if (STORED_FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
            return this.id;
        ToXContentObject {
        return this.realtime;
                            throw new OpenSearchParseException("illegal type for _source: [{}]", token);
                            throw new IllegalArgumentException("explicit index in multi get is not allowed");
    @PublicApi(since = "1.0.0")
        }  
import org.opensearch.core.xcontent.XContentParser;
                            );  
            builder.startObject();  
        List<Item> items,
import java.util.ArrayList;
        return this;  
 *  
    }
            + preference
                } else if (token == Token.START_OBJECT) {  
            List<String> storedFields = null;
        @Nullable String[] defaultFields,  
        } else {
                if (token == Token.FIELD_NAME) {  
            + refresh  
                            parser.getTokenLocation(),
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {  
                    parseIds(parser, this.items, defaultIndex, defaultFields, defaultFetchSource, defaultRouting);
                        index = parser.text();
    /**
            return new String[] { index };
            index = in.readString();
 * compatible open source license.
                            includes.toArray(Strings.EMPTY_ARRAY),
            id = in.readString();  
        XContentParser parser,  
    private static final ParseField ID = new ParseField("_id");  
        private FetchSourceContext fetchSourceContext;
                new Item(index, id).routing(routing)
        Iterable<MultiGetRequest.Item>,
        if ((token = parser.nextToken()) != Token.START_OBJECT) {  
        public void writeTo(StreamOutput out) throws IOException {
        @Override
            VersionType versionType = VersionType.INTERNAL;
    }
                        ArrayList<String> includes = new ArrayList<>();
        }
/**  
    }  
                            storedFields.add(parser.text());
        }
import org.opensearch.core.common.io.stream.StreamInput;
                                new String[] { parser.text() },
        }  
import org.opensearch.core.xcontent.XContentParser.Token;
            if (versionType != item.versionType) return false;
        public String[] indices() {
        private long version = Versions.MATCH_ANY;
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {  
        @Nullable String defaultIndex,
            return this.fetchSourceContext;
                        }
                            fetchSourceContext.excludes()
                            );  
            if (token != Token.START_OBJECT) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    .version(version)  
     *
        builder.startObject();
                } else if (token.isValue()) {
                    } else if (STORED_FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
                                fetchSourceContext.excludes()
        @Override
     * will be used across different requests.
    private static final ParseField VERSION_TYPE = new ParseField("version_type");  
            builder.field(VERSION.getPreferredName(), version);
        return this;
            throw new ParsingException(parser.getTokenLocation(), message);
                    .storedFields(aFields)
    }
            result = 31 * result + (fetchSourceContext != null ? fetchSourceContext.hashCode() : 0);  
import java.io.IOException;
            this.versionType = versionType;  
        }
            fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);  
package org.opensearch.action.get;
                                fetchSourceContext.excludes()
         * The routing associated with this document.
        }
        }
        ActionRequestValidationException validationException = null;
 *
            return this;  
                            includes.add(parser.text());  
        List<Item> items,  
                out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
        this.refresh = refresh;
import org.opensearch.index.VersionType;  
        return validationException;
                            excludes == null ? Strings.EMPTY_ARRAY : excludes.toArray(new String[0])
    private static final ParseField INDEX = new ParseField("_index");
                        while ((token = parser.nextToken()) != Token.END_OBJECT) {
import java.util.Collections;
                    .versionType(versionType)
            builder.value(item);
    }
    public MultiGetRequest add(
        return this;  
        @Override
                        "unknown key [%s] for a %s, expected [docs] or [ids]",  
    private static final ParseField FIELDS = new ParseField("fields");
                        } else if (token == Token.VALUE_STRING) {
        }
public class MultiGetRequest extends ActionRequest  
    public MultiGetRequest realtime(boolean realtime) {  
    public MultiGetRequest add(String index, String id) {
     */  
        String currentFieldName = null;
                    parseDocuments(parser, this.items, defaultIndex, defaultFields, defaultFetchSource, defaultRouting, allowExplicitIndex);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
            validationException = ValidateActions.addValidationError("no documents to get", validationException);
        CompositeIndicesRequest,  
        return "MultiGetRequest{"
            this.version = version;  
    private static final ParseField DOCS = new ParseField("docs");
    }  
import org.opensearch.common.Nullable;
            + ", refresh="
    public String toString() {
                                fetchSourceContext.fetchSource(),  
            if (!Arrays.equals(storedFields, item.storedFields)) return false;
            this.index = index;
            this.fetchSourceContext = fetchSourceContext;  
            return this.routing;
 */  
            return this;
                }
                throw new ParsingException(parser.getTokenLocation(), message);
                        } else {
    }
 * SPDX-License-Identifier: Apache-2.0
        RealtimeRequest,
        builder.endArray();
import java.util.Iterator;
 * license agreements. See the NOTICE file distributed with
 */  
import java.util.Locale;
            out.writeString(index);  
        @Nullable String[] defaultFields,
    private static final ParseField VERSION = new ParseField("version");
            for (int i = 0; i < items.size(); i++) {  
        public long version() {
import org.opensearch.Version;
    @Override
            + realtime
     * @opensearch.api
                    } else if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {  
            if (in.getVersion().before(Version.V_2_0_0)) {  
/*  
            this.id = id;
                in.readOptionalString();
                                currentFieldName = parser.currentName();  
    }
            }
                                }
                        throw new ParsingException(  
            versionType = VersionType.fromValue(in.readByte());
                        }  
 * software distributed under the License is distributed on an
                        storedFields.add(parser.text());
        @Nullable String defaultRouting,
                    token,
                    "unexpected token [%s], expected [%s] or [%s]",  
        @Nullable String defaultRouting,  
                    if (FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
                }
            if (!id.equals(item.id)) return false;
                    .fetchSourceContext(defaultFetchSource)
         */
    }
 */
                    if (SOURCE.match(currentFieldName, parser.getDeprecationHandler())) {
            return this;  
            this.routing = routing;
        return this;
        }
    public static class Item implements Writeable, IndicesRequest, ToXContentObject {
import java.util.Arrays;  
                        if (parser.isBooleanValue()) {
        @Nullable FetchSourceContext defaultFetchSource,
        this.preference = preference;
        @Nullable String[] defaultFields,
                            "Unsupported field [fields] used, expected [stored_fields] instead"
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        boolean allowExplicitIndex  
                                    currentList = includes != null ? includes : (includes = new ArrayList<>(2));
            String routing = defaultRouting;
            builder.field(SOURCE.getPreferredName(), fetchSourceContext);
                            } else if (token == Token.START_ARRAY) {
    public String preference() {  
        return this;
            return result;
            + items
import org.opensearch.core.xcontent.ToXContentObject;
        while ((token = parser.nextToken()) != Token.END_ARRAY) {
        public Item versionType(VersionType versionType) {
    public void writeTo(StreamOutput out) throws IOException {
                    );  
@PublicApi(since = "1.0.0")
    }
            out.writeLong(version);
        }  
import org.opensearch.action.CompositeIndicesRequest;
            out.writeOptionalWriteable(fetchSourceContext);
            }  
import org.opensearch.core.common.io.stream.StreamOutput;
                if (item.index() == null) {
                        }
    private static final ParseField ROUTING = new ParseField("routing");
            }
        @Nullable FetchSourceContext defaultFetchSource,
    boolean refresh;  
    @Override  
import org.opensearch.core.ParseField;
            this.index = index;
                        id = parser.text();  
                aFields = defaultFields;
    public ActionRequestValidationException validate() {
    public List<Item> getItems() {
        public int hashCode() {
    public boolean realtime() {
            + ", realtime="  
        public FetchSourceContext fetchSourceContext() {
                        );  
                            fetchSourceContext = new FetchSourceContext(
            builder.endObject();
                            }
        }
                        );  
        private String routing;  
                    Token.FIELD_NAME,
        return this.refresh;  
    String preference;
    List<Item> items = new ArrayList<>();
        }
import org.opensearch.core.common.Strings;  
        @Nullable String defaultIndex,  
    public Iterator<Item> iterator() {
            );  
        this.realtime = realtime;
        Token token;  
            if (out.getVersion().before(Version.V_2_0_0)) {
    }  
        private String index;
    implements
        public Item index(String index) {
import org.opensearch.action.IndicesRequest;  
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
                    } else if (VERSION_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
