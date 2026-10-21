        this.path = path;
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
        return Objects.hash(index, id, path, routing, store, query);
 * Modifications Copyright OpenSearch Contributors. See
            && Objects.equals(routing, other.routing)
            && Objects.equals(path, other.path)
        }
            } catch (IOException e) {
        String path = (String) args[2];
            store = in.readBoolean();
            }
        this.id = id;
        }
    private String routing;
            && Objects.equals(query, other.query);
        return index;
    public String index() {
            builder.field("query");
    @Override
        index = in.readString();
        return this;
        id = in.readString();
        if (id != null && query != null) {
    public TermsLookup id(String id) {
    public String routing() {
    public boolean equals(Object obj) {
        return store;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    public TermsLookup store(boolean store) {
        String index = (String) args[0];
            out.writeOptionalWriteable(query);
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
            try {
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] index cannot be null or empty for TermsLookup");
        return new TermsLookup(index, id, path, query);
    }
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
    public static TermsLookup parseTermsLookup(XContentParser parser) throws IOException {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        }
        if (id == null && query == null) {
        out.writeString(index);
 * Encapsulates the parameters needed to fetch terms.
                "[" + TermsQueryBuilder.NAME + "] query lookup element requires specifying either the id or the query."
        this.routing = routing;
        builder.field("path", path);
import org.opensearch.Version;
            throw new IllegalArgumentException(
    public TermsLookup(String index, String id, String path, QueryBuilder query) {
    public String path() {
import org.opensearch.index.query.AbstractQueryBuilder;
    }
    }
/*
 * not use this file except in compliance with the License.
    public String toString() {
    }
    static {
        PARSER.declareString(constructorArg(), new ParseField("path")); // Required
        QueryBuilder query = (QueryBuilder) args[3]; // Optional id or query but not both
            query = in.readOptionalWriteable(inStream -> inStream.readNamedWriteable(QueryBuilder.class));
        }
        }
        if (id == null && query == null) {
        return PARSER.parse(parser, null);
        }
        }
        PARSER.declareString(constructorArg(), new ParseField("index")); // Required
        this.query = query;
    }
            query.toXContent(builder, params);
        this.id = id;
    public TermsLookup routing(String routing) {
            builder.field("routing", routing);
    }
import org.opensearch.index.mapper.MapperService;
        if (in.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.index.query.QueryBuilder;
 * Unless required by applicable law or agreed to in writing,
        return this;
        }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
                "[" + TermsQueryBuilder.NAME + "] query lookup element requires specifying either the id or the query."
    public void setQuery(QueryBuilder query) {
import java.io.IOException;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            return true;
    private static final ConstructingObjectParser<TermsLookup, Void> PARSER = new ConstructingObjectParser<>("terms_lookup", args -> {
            );
 * GitHub history for details.
        TermsLookup other = (TermsLookup) obj;
    public TermsLookup(StreamInput in) throws IOException {
    }
        if (obj == null || getClass() != obj.getClass()) {
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
    }
            out.writeBoolean(store);
    @Override
    /**
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.XContentParser;
        }, new ParseField("query")); // Optional
        if (index == null) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        }
    private String id;
                return AbstractQueryBuilder.parseInnerQueryBuilder(parser); // Parse query if provided
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] path cannot be null or empty for TermsLookup");
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
    }
    private final String index;
        PARSER.declareBoolean(TermsLookup::store, new ParseField("store")); // Optional
        }
    public boolean store() {
        // Validation: Either id or query must be present, but not both
        String id = (String) args[1]; // Optional id or query but not both
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field("index", index);
        }
import org.opensearch.core.xcontent.XContentBuilder;
        if (routing != null) {
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException(
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
                throw new RuntimeException("Error parsing inner query builder", e);
            );
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public TermsLookup(String index, String id, String path) {
    }
    }
import org.opensearch.index.query.TermsQueryBuilder;
import org.opensearch.core.common.io.stream.Writeable;
    }
 *
    public void writeTo(StreamOutput out) throws IOException {
        if (id != null) {
/*
        this.query = query;
 * compatible open source license.
    }
    private boolean store;
    });
/**
        return query;
}
        if (path == null) {
 * Licensed to Elasticsearch under one or more contributor
 */
            return false;
        this(index, id, path, null);
        }
    public int hashCode() {
import java.util.Objects;
     */
        }
    public QueryBuilder query() {
    private QueryBuilder query;
        }
        PARSER.declareString(optionalConstructorArg(), new ParseField("id")); // Optional
        this.index = index;
    @Override
 * @opensearch.internal
        if (this.query != null && id != null) {
        path = in.readString();
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return path;
 */
public class TermsLookup implements Writeable, ToXContentFragment {
    @Override
        }
        if (id != null && query != null) {
 * under the License.
import org.opensearch.core.ParseField;
        out.writeString(path);
    public TermsLookup query(QueryBuilder query) {
            in.readOptionalString();
 */
        if (out.getVersion().before(Version.V_2_0_0)) {
    public String id() {
 *
 *
        this.store = store;
            builder.field("store", true);
            && Objects.equals(store, other.store)
 *
        }
 * license agreements. See the NOTICE file distributed with
        if (this.id != null && query != null) {
    }
    }
        if (store) {
        out.writeOptionalString(routing);
/*
        }
        this.query = query;
    @Override
    }
        return id;
 * SPDX-License-Identifier: Apache-2.0
        return Objects.equals(index, other.index)
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
        if (query != null) {
    }
        return this;
        return routing;
        out.writeString(id);
            && Objects.equals(id, other.id)
        PARSER.declareString(TermsLookup::routing, new ParseField("routing")); // Optional
        }
    private final String path;
package org.opensearch.indices;
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
    }
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under
        PARSER.declareObject(optionalConstructorArg(), (parser, context) -> {
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
import org.opensearch.core.common.io.stream.StreamInput;
        return builder;
        routing = in.readOptionalString();
            builder.field("id", id);
 */
        return index + "/" + id + "/" + path;
    }
        if (this == obj) {
