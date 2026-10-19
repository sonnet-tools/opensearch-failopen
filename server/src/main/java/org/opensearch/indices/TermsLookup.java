    private String id;
    }
        builder.field("index", index);
import org.opensearch.index.query.AbstractQueryBuilder;
    }
    public QueryBuilder query() {  
    @Override
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");  
            return true;  
 *  
    public boolean store() {  
    }
        // Validation: Either id or query must be present, but not both  
/*
            builder.field("store", true);
     * Read from a stream.
        PARSER.declareString(constructorArg(), new ParseField("index")); // Required  
    @Override
        }  
        QueryBuilder query = (QueryBuilder) args[3]; // Optional id or query but not both
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
        String id = (String) args[1]; // Optional id or query but not both
        }
        String index = (String) args[0];
        if (id != null && query != null) {
 */
 * software distributed under the License is distributed on an
        return builder;
        return this;  
    private final String path;  
        path = in.readString();
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
        this.id = id;
import java.io.IOException;  
    }
    }  
            && Objects.equals(query, other.query);
    public void setQuery(QueryBuilder query) {  
import org.opensearch.core.xcontent.XContentBuilder;
        }
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] path cannot be null or empty for TermsLookup");
        routing = in.readOptionalString();
        if (this == obj) {
    public static TermsLookup parseTermsLookup(XContentParser parser) throws IOException {
 * compatible open source license.
        }
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");
/**  
        this.store = store;
        }  
    private boolean store;
        return index;
        return this;  
 * Licensed to Elasticsearch under one or more contributor  
        PARSER.declareBoolean(TermsLookup::store, new ParseField("store")); // Optional
 * KIND, either express or implied.  See the License for the
    public TermsLookup routing(String routing) {
        this.routing = routing;  
            in.readOptionalString();
        }  
public class TermsLookup implements Writeable, ToXContentFragment {
import org.opensearch.core.xcontent.XContentParser;  
    private static final ConstructingObjectParser<TermsLookup, Void> PARSER = new ConstructingObjectParser<>("terms_lookup", args -> {  
    public String id() {
}
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryBuilder;  
        }
        PARSER.declareString(optionalConstructorArg(), new ParseField("id")); // Optional
import org.opensearch.index.mapper.MapperService;
 * The OpenSearch Contributors require contributions made to  
            try {
    }  
    @Override  
    public TermsLookup(String index, String id, String path) {
    private QueryBuilder query;
            && Objects.equals(store, other.store)
    }
        return this;
     */
    private String routing;
        if (store) {
            } catch (IOException e) {  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        index = in.readString();  
        }
        this.query = query;
    public TermsLookup id(String id) {
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] query lookup element cannot specify both id and query.");  
        id = in.readString();
        if (index == null) {  
 * ownership. Elasticsearch licenses this file to you under  
        if (id != null) {
                return AbstractQueryBuilder.parseInnerQueryBuilder(parser); // Parse query if provided
        if (routing != null) {  
            out.writeBoolean(store);
        this.query = query;
        builder.field("path", path);
    @Override
            builder.field("id", id);  
 * this work for additional information regarding copyright
        String path = (String) args[2];  
        return PARSER.parse(parser, null);  
        PARSER.declareString(constructorArg(), new ParseField("path")); // Required
        return path;
            && Objects.equals(id, other.id)
            builder.field("routing", routing);
    public TermsLookup store(boolean store) {
    public TermsLookup query(QueryBuilder query) {
    }  
        }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
            out.writeOptionalWriteable(query);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeString(id);  
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
    public String index() {
            }
    }
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        PARSER.declareObject(optionalConstructorArg(), (parser, context) -> {  
        this.id = id;
        this.index = index;
import org.opensearch.core.common.io.stream.Writeable;
        if (this.query != null && id != null) {
            store = in.readBoolean();  
        TermsLookup other = (TermsLookup) obj;
    }
            query.toXContent(builder, params);
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;
        }
package org.opensearch.indices;
        out.writeOptionalString(routing);  
                throw new RuntimeException("Error parsing inner query builder", e);
        return query;
        }
            query = in.readOptionalWriteable(inStream -> inStream.readNamedWriteable(QueryBuilder.class));  
    });
    public int hashCode() {
        }  
/*  
    }
        if (id == null && query == null) {  
    public TermsLookup(StreamInput in) throws IOException {  
    public String routing() {
            );
            throw new IllegalArgumentException("[" + TermsQueryBuilder.NAME + "] index cannot be null or empty for TermsLookup");
    }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    }
import java.util.Objects;
            );  
                "[" + TermsQueryBuilder.NAME + "] query lookup element requires specifying either the id or the query."
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
                "[" + TermsQueryBuilder.NAME + "] query lookup element requires specifying either the id or the query."  
    }  
    /**  
        return Objects.hash(index, id, path, routing, store, query);  
    }
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
 *
        return index + "/" + id + "/" + path;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return false;  
    public boolean equals(Object obj) {
    public TermsLookup(String index, String id, String path, QueryBuilder query) {
        if (id != null && query != null) {  
 * Encapsulates the parameters needed to fetch terms.
 * specific language governing permissions and limitations
import org.opensearch.index.query.TermsQueryBuilder;
            && Objects.equals(routing, other.routing)  
        if (query != null) {  
            throw new IllegalArgumentException(
        }  
    private final String index;
        return store;
    }
 *
        if (path == null) {  
            throw new IllegalArgumentException(
            builder.field("query");
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        out.writeString(path);
        }
        }
        if (out.getVersion().before(Version.V_2_0_0)) {  
        return Objects.equals(index, other.index)  
        }
 * under the License.  
 */
    }
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
 */  
    static {
        }
        }  
        this(index, id, path, null);
 * SPDX-License-Identifier: Apache-2.0
        return this;  
        return routing;
        this.query = query;
        this.path = path;  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
import org.opensearch.Version;
 * You may obtain a copy of the License at  
        PARSER.declareString(TermsLookup::routing, new ParseField("routing")); // Optional
        return id;  
        out.writeString(index);
 * the Apache License, Version 2.0 (the "License"); you may
    public String path() {  
            && Objects.equals(path, other.path)
        return new TermsLookup(index, id, path, query);  
    }  
        }
 * Modifications Copyright OpenSearch Contributors. See
/*  
        if (id == null && query == null) {
 * @opensearch.internal  
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
 * not use this file except in compliance with the License.
    public String toString() {
    @Override  
        if (this.id != null && query != null) {
        if (obj == null || getClass() != obj.getClass()) {
 * this file be licensed under the Apache-2.0 license or a
        }, new ParseField("query")); // Optional  
 */  
