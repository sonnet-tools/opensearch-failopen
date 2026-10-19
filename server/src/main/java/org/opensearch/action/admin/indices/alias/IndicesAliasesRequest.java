        builder.startArray("actions");
 * Modifications Copyright OpenSearch Contributors. See
    }
            return indices;
        }  
         * Read from a stream.  
        this.origin = Objects.requireNonNull(origin);
                    } else {  
        public AliasActions indexRouting(String indexRouting) {  
            if (type != AliasActions.Type.ADD) {
    }  
        private String[] indices;
                && Objects.equals(searchRouting, other.searchRouting)
                throw new IllegalArgumentException("[alias] can't be empty string");
            this.type = type;
                && Objects.equals(mustExist, other.mustExist);
        public AliasActions(AliasActions.Type type) {
                + Arrays.deepToString(aliases)  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * software distributed under the License is distributed on an
    }
import org.opensearch.action.ActionRequestValidationException;
         * Validate that the action is sane. Called when the action is added to the request because actions can be invalid while being
        origin = in.readOptionalString();
                && Objects.equals(routing, other.routing)  
    /**
                + type
 * under the License.  
            private final byte value;  
                throw new IllegalArgumentException("[" + IS_HIDDEN.getPreferredName() + "] is unsupported for [" + type + "]");
                    throw new IllegalArgumentException("[indices] can't contain empty string");
            this.aliases = new String[] { alias };
         */
}
                filter.toXContent(builder, ToXContent.EMPTY_PARAMS);  
         * built.  
 * SPDX-License-Identifier: Apache-2.0
            return this;
        builder.startObject();  
                && Objects.equals(filter, other.filter)
        @Override
            if (type != Type.REMOVE) {
        out.writeList(allAliasActions);
     * Add the action to this request and validate it.  
                throw new OpenSearchGenerationException("Failed to build json for alias request", e);
        }  
        }  
 * A request to add/remove aliases for one or more indices.
            REMOVE((byte) 1, AliasActions.REMOVE),  
    public IndicesOptions indicesOptions() {  
            }
            if (type != AliasActions.Type.ADD) {
                action.index(index);
            if (type != AliasActions.Type.ADD) {
        public AliasActions mustExist(Boolean mustExist) {  
        }  
            return parser;
            if (type != AliasActions.Type.REMOVE_INDEX && (aliases == null || aliases.length == 0)) {  
            this.aliases = aliases;
            return new AliasActions(AliasActions.Type.REMOVE_INDEX);
            }  
                this.filter = null;
            out.writeByte(type.value());  
                    return parser.mapOrdered();
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (action.indices() != null) {
         * Build a new {@link AliasAction} to add aliases.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Aliases to use with this action.
            routing = in.readOptionalString();
            out.writeOptionalString(filter);  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        /**
                }
 * license agreements. See the NOTICE file distributed with
                    default:
import java.io.IOException;  
        PARSER.declareObjectArray((request, actions) -> {  
 *
import org.opensearch.core.common.io.stream.StreamInput;
 *  
                if (action.aliases() != null && action.aliases().length != 0) {
            if (type != AliasActions.Type.ADD) {
import org.opensearch.core.common.io.stream.Writeable;
        public Boolean mustExist() {
            if (false == Strings.hasLength(alias)) {
        }  
/*
     */
            }  
        private static final ParseField IS_WRITE_INDEX = new ParseField("is_write_index");
     */
                action.indices(indices);
                return value;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                return this;
            if (null != mustExist) {
            return action;
import org.opensearch.core.xcontent.ToXContent;  
            if (false == Strings.isEmpty(routing)) {
import org.opensearch.action.support.IndicesOptions;
            }, FILTER);  
            // remove operations support wildcards among aliases, add operations don't
            return this;
            this.writeIndex = writeIndex;
        public String[] indices() {
import org.opensearch.core.common.bytes.BytesArray;
         */
        }  
 */  
            }
    // indices, don't allow that no indices are resolved from wildcard expressions and resolve the
            this.filter = filter;
                builder.map(filter);  
import org.opensearch.core.xcontent.XContentParser;  
/*  
                } catch (IOException e) {  
 * @opensearch.api
                if (o != null) {  
            }
        public AliasActions isHidden(Boolean isHidden) {  
 * specific language governing permissions and limitations
        if (allAliasActions.isEmpty()) {
            return isHidden;  
            }  
import org.opensearch.action.CompositeIndicesRequest;
        /**  
        }
import org.opensearch.core.xcontent.ToXContentObject;
            for (AliasActions action : actions) {
                action.aliases(aliases);
    }  
                throw new IllegalArgumentException("[alias] is unsupported for [" + type + "]");
            REMOVE_INDEX((byte) 2, AliasActions.REMOVE_INDEX);
                throw new OpenSearchGenerationException("Failed to generate [" + filter + "]", e);
            this.originalAliases = aliases;
        return origin;  
            for (Object o : a) {
 *
import java.util.ArrayList;
            // Take the first action and complain if there are more than one actions  
        }  
        private static final ParseField FILTER = new ParseField("filter");
            if (filter == null) {  
            parser.declareStringArray(fromList(String.class, (action, aliases) -> {
            }  
        }
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
            for (String index : indices) {
        private static final ObjectParser<AliasActions, Void> REMOVE_PARSER = parser(REMOVE.getPreferredName(), AliasActions::remove);
        public AliasActions filter(String filter) {  
                throw new IllegalArgumentException("One of [index] or [indices] is required");
        public Boolean writeIndex() {
            try {
        public AliasActions.Type actionType() {
        return this.allAliasActions;  
            action.toXContent(builder, params);  
        @Override
                + Arrays.toString(indices)
                builder.close();
        public int hashCode() {  
        @Override  
        private static ObjectParser<AliasActions, Void> parser(String name, Supplier<AliasActions> supplier) {
            }  
import org.opensearch.OpenSearchGenerationException;
                builder.field(IS_HIDDEN.getPreferredName(), isHidden);
            this.routing = routing;
    }
        public AliasActions aliases(String... aliases) {
            }), INDICES);  
 * ownership. Elasticsearch licenses this file to you under  
        builder.endObject();  
 * compatible open source license.
import static org.opensearch.core.xcontent.ObjectParser.fromList;
import org.opensearch.core.xcontent.ConstructingObjectParser;
                try {
            out.writeOptionalBoolean(mustExist);
        private String searchRouting;
        }
        }  
        static {
                + mustExist  
                return false;
    }
            }  
                this.fieldName = field.getPreferredName();
            ADD_PARSER.declareObject(AliasActions::filter, (parser, m) -> {  
         */  
            if (type != AliasActions.Type.ADD) {
                + "]";
            return this;
        allAliasActions = in.readList(AliasActions::new);
            writeIndex = in.readOptionalBoolean();
        @Override
        /**  
            ADD_PARSER.declareField(AliasActions::searchRouting, XContentParser::text, SEARCH_ROUTING, ValueType.INT);
            if (type == AliasActions.Type.REMOVE_INDEX) {
        }
import org.opensearch.common.xcontent.XContentFactory;  
        }
import org.opensearch.action.AliasesRequest;  
         * The type of request.
import java.util.Arrays;  
                switch (value) {
                return this;  
                    case 1:
                + ",indexRouting="
            return this;
import org.opensearch.core.ParseField;
        aliasAction.validate();  
            this.indices = new String[] { index };  
                + ",aliases="
                + searchRouting
                return this;
                throw new IllegalArgumentException("[index_routing] is unsupported for [" + type + "]");
                && Arrays.equals(indices, other.indices)  
            return this;  
            ADD_PARSER.declareField(AliasActions::writeIndex, XContentParser::booleanValue, IS_WRITE_INDEX, ValueType.BOOLEAN);
    }  
            out.writeStringArray(aliases);
        /**
    @PublicApi(since = "1.0.0")  
            // Since we need to support numbers AND strings here we have to use ValueType.INT.
                }
            }
            AliasActions action = null;
            }  
        public static AliasActions remove() {  
                }
                        return REMOVE;
            }  
            parser.declareStringArray(fromList(String.class, (action, indices) -> {
                throw new IllegalArgumentException("[indices] can't be empty");  
        }
        super.writeTo(out);  
                + "type="
        return INDICES_OPTIONS;
            }  
     * @opensearch.api
        super(in);  
                throw new IllegalArgumentException("[" + MUST_EXIST.getPreferredName() + "] is unsupported for [" + type + "]");
        public AliasActions filter(Map<String, Object> filter) {
            this.aliases = aliases;
 * not use this file except in compliance with the License.
    }
        public AliasActions index(String index) {
    public static final ObjectParser<IndicesAliasesRequest, Void> PARSER = new ObjectParser<>("aliases", IndicesAliasesRequest::new);
            REMOVE_PARSER.declareField(AliasActions::mustExist, XContentParser::booleanValue, MUST_EXIST, ValueType.BOOLEAN);
        }
                + ",searchRouting="
                        throw new IllegalArgumentException("No type for action [" + value + "]");  
import java.io.InputStream;
        private String filter;
            isHidden = in.readOptionalBoolean();
            builder.endObject();
        private static final ParseField ALIASES = new ParseField("aliases");  
        public String[] aliases() {
 */
                        action = (AliasActions) o;
                && Objects.equals(isHidden, other.isHidden)
        private static final ParseField IS_HIDDEN = new ParseField("is_hidden");  
        });  
                builder.field(SEARCH_ROUTING.getPreferredName(), searchRouting);
import org.opensearch.index.query.QueryBuilder;
        return validationException;
     * Request to take one or more actions on one or more indexes and alias combinations.
            }), ALIASES);  
        @Override
        }
            try {
            public byte value() {
        private static final ParseField ALIAS = new ParseField("alias");
        }
            return searchRouting == null ? routing : searchRouting;  
    private String origin = "";
                + routing
            } catch (IOException e) {
                + indexRouting  
        @Override
        private Boolean writeIndex;  
        public static AliasActions fromXContent(XContentParser parser) throws IOException {  
                this.filter = builder.toString();
        public static AliasActions add() {
        }
 * this work for additional information regarding copyright
        // equals, and hashCode implemented for easy testing of round trip
                    }
        }  
            AliasActions::removeIndex
            if (indices == null) {  
        /**
            searchRouting = in.readOptionalString();
        /**
            }
            indices = in.readStringArray();
            ADD_PARSER.declareField(AliasActions::routing, XContentParser::text, ROUTING, ValueType.INT);
        }
public class IndicesAliasesRequest extends AcknowledgedRequest<IndicesAliasesRequest> implements ToXContentObject, CompositeIndicesRequest {
            return new AliasActions(AliasActions.Type.ADD);  
                throw new IllegalArgumentException("[routing] is unsupported for [" + type + "]");
        out.writeOptionalString(origin);  
                    throw new IllegalArgumentException("Only one of [alias] and [aliases] is supported");  
        public AliasActions indices(String... indices) {
            builder.endObject();
        /**
        }  
            this.indices = indices;
            if (false == Strings.isEmpty(searchRouting)) {
        private static final ParseField REMOVE = new ParseField("remove");
                builder.array(ALIASES.getPreferredName(), aliases);  
 * KIND, either express or implied.  See the License for the
        }
        private static final ParseField ROUTING = new ParseField("routing");
        @Override
            ObjectParser<AliasActions, Void> parser = new ObjectParser<>(name, supplier);  
            REMOVE_INDEX.getPreferredName(),
            if (false == Strings.hasLength(index)) {  
        }  
            if (type == AliasActions.Type.REMOVE_INDEX) {
        }
        }
        private static final ParseField INDEX = new ParseField("index");  
/**
            }  
    public IndicesAliasesRequest addAliasAction(AliasActions aliasAction) {
                + writeIndex
                return this;
        }
        }
                + ",routing="  
        @Override
                if (false == Strings.hasLength(alias)) {  
            return INDICES_OPTIONS;
    @Override
                if (action.indices() != null) {
import org.opensearch.cluster.metadata.AliasAction;
        public AliasActions(StreamInput in) throws IOException {
        return this;
        public String toString() {
            return Objects.equals(type, other.type)
                if (action.aliases() != null && action.aliases().length != 0) {
        public AliasActions routing(String routing) {  
    @Override
         */
        void validate() {
            return addValidationError("Must specify at least one alias action", validationException);
        }
@PublicApi(since = "1.0.0")  
                }  
                throw new IllegalArgumentException("[aliases] is unsupported for [" + type + "]");  
            out.writeOptionalString(routing);
import java.util.Map;
            }, INDEX);  
            }  
         *  
            for (String alias : aliases) {
            if (false == Strings.isEmpty(filter)) {
    public ActionRequestValidationException validate() {
            return new AliasActions(AliasActions.Type.REMOVE);
import java.util.function.Supplier;
        }
        return this;
        /**
            builder.startObject();  
                    throw new IllegalArgumentException("Only one of [index] and [indices] is supported");  
            }  
                }
        @Override  
                builder.array(INDICES.getPreferredName(), indices);  
import java.util.Objects;  
        public IndicesOptions indicesOptions() {  
        private static final ParseField SEARCH_ROUTING = new ParseField("search_routing", "searchRouting", "search-routing");
            return type == Type.REMOVE;  
                + filter
        );  
 * Licensed to Elasticsearch under one or more contributor  
    // indices options that require every specified index to exist, expand wildcards only to open  
        ActionRequestValidationException validationException = null;  
            return type;  
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return PARSER.apply(parser, null);
            return filter;  
                request.addAliasAction(action);
        }
        }
            } catch (IOException e) {  
            }  
         */
        public boolean equals(Object obj) {  
            }  
            indexRouting = in.readOptionalString();  
            out.writeOptionalString(indexRouting);  
    }  
            if (filter == null || filter.isEmpty()) {  
        }
                builder.field(IS_WRITE_INDEX.getPreferredName(), writeIndex);
    public static class AliasActions implements AliasesRequest, Writeable, ToXContentObject {
import org.opensearch.core.common.Strings;  
            }
import org.opensearch.core.common.io.stream.StreamOutput;  
                && Objects.equals(indexRouting, other.indexRouting)
                try (InputStream stream = new BytesArray(filter).streamInput()) {  
    public IndicesAliasesRequest origin(final String origin) {  
        private static final ObjectParser<AliasActions, Void> ADD_PARSER = parser(ADD.getPreferredName(), AliasActions::add);
        private String[] originalAliases = Strings.EMPTY_ARRAY;
        public void replaceAliases(String... aliases) {  
            parser.declareString((action, alias) -> {
            return aliases;
            return indexRouting == null ? routing : indexRouting;  
        @Override  
        }  
            out.writeStringArray(indices);
                action.alias(alias);
 */  
        }  
        @PublicApi(since = "1.0.0")  
                        return ADD;  
    }
            }  
import org.opensearch.core.xcontent.ObjectParser.ValueType;
                    case 2:  
            filter = in.readOptionalString();  
            out.writeStringArray(originalAliases);  
    private static final IndicesOptions INDICES_OPTIONS = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);  
                builder.field(INDEX_ROUTING.getPreferredName(), indexRouting);
         */
        }
            }, ALIAS);  
            }
         * Parser for any one {@link AliasAction}.  
    /**
                    throw new IllegalArgumentException("[aliases] can't contain empty string");
        }, AliasActions.PARSER, new ParseField("actions"));
            return Objects.hash(type, indices, aliases, filter, routing, indexRouting, searchRouting, writeIndex, isHidden, mustExist);
         */
         * Set the default routing.
            return this;
            return this;
                builder.field(MUST_EXIST.getPreferredName(), mustExist);
        }  
            this.searchRouting = searchRouting;
 * You may obtain a copy of the License at  
                this.filter = null;
 *  
    private List<AliasActions> allAliasActions = new ArrayList<>();  
        /**
        }  
        private String routing;  
            }  
import org.opensearch.core.xcontent.XContentBuilder;
            }
            builder.startObject(type.fieldName);
    public String origin() {
        public String searchRouting() {
            return PARSER.apply(parser, null);
 * this file be licensed under the Apache-2.0 license or a
            PARSER.declareObject(optionalConstructorArg(), REMOVE_INDEX_PARSER, REMOVE_INDEX);
        // noinspection StatementWithEmptyBody
        public AliasActions alias(String alias) {  
         */
        private String indexRouting;
        private Boolean isHidden;
        public String filter() {
package org.opensearch.action.admin.indices.alias;
        private static final ParseField MUST_EXIST = new ParseField("must_exist");
        private static final ObjectParser<AliasActions, Void> REMOVE_INDEX_PARSER = parser(  
                + ",writeIndex="  
         * Set the alias this action is operating on.
        private Boolean mustExist;
         */
         * Build a new {@link AliasAction} to remove an index.
    // expressions only against indices
        public static final ConstructingObjectParser<AliasActions, Void> PARSER = new ConstructingObjectParser<>("alias_action", a -> {
                        throw new IllegalArgumentException("Too many operations declared on operation entry");
import org.opensearch.core.xcontent.ObjectParser;
            }  
            out.writeOptionalBoolean(writeIndex);
        /**
        public Boolean isHidden() {
            out.writeOptionalBoolean(isHidden);
            }
            if (type != AliasActions.Type.ADD) {
 * GitHub history for details.
            this.mustExist = mustExist;
        public String[] getOriginalAliases() {
            originalAliases = in.readStringArray();  
            aliases = in.readStringArray();
            ADD_PARSER.declareField(AliasActions::isHidden, XContentParser::booleanValue, IS_HIDDEN, ValueType.BOOLEAN);  
        }
            if (0 != aliases.length) {
        public enum Type {
            this.originalAliases = aliases;
        private final AliasActions.Type type;
        /**  
                throw new IllegalArgumentException("[index] can't be empty string");
            return originalAliases;  
            }  
import java.util.List;
    @Override
        public AliasActions writeIndex(Boolean writeIndex) {  
                    builder.rawField(FILTER.getPreferredName(), stream, MediaTypeRegistry.JSON);
         * Type of the action to perform.  
            PARSER.declareObject(optionalConstructorArg(), ADD_PARSER, ADD);
     *  
        private String[] aliases = Strings.EMPTY_ARRAY;  
            this.indexRouting = indexRouting;
        public AliasActions filter(QueryBuilder filter) {
                throw new IllegalArgumentException("[filter] is unsupported for [" + type + "]");
                XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
    public static IndicesAliasesRequest fromXContent(XContentParser parser) {
            }  
                && Objects.equals(writeIndex, other.writeIndex)  
                this.value = value;
            if (indices == null || indices.length == 0) {
                builder.field(ROUTING.getPreferredName(), routing);
        }  
        public boolean expandAliasesWildcards() {
            return builder;  
                + ",filter="
    public List<AliasActions> getAliasActions() {  
            parser.declareString((action, index) -> {
                this.filter = builder.toString();
                    if (action == null) {
         */
                    throw new IllegalArgumentException("Only one of [index] and [indices] is supported");  
            if (null != indices && 0 != indices.length) {
        private static final ParseField INDEX_ROUTING = new ParseField("index_routing", "indexRouting", "index-routing");  
                    case 0:
            return mustExist;  
                }
                + ",mustExist="
            AliasActions other = (AliasActions) obj;
         */
        @Override
            }
                && Arrays.equals(aliases, other.aliases)
            }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        private static final ParseField ADD = new ParseField("add");  
            return this;
            return this;  
            if (null != writeIndex) {
            this.isHidden = isHidden;
         */  
        public String indexRouting() {
            if (aliases == null || aliases.length == 0) {
        builder.endArray();
        }
    List<AliasActions> aliasActions() {
        public AliasActions searchRouting(String searchRouting) {  
            }
            private final String fieldName;
                }
            }  
        }
        public static AliasActions removeIndex() {
            return this;
         * Set the index this action is operating on.  
            out.writeOptionalString(searchRouting);
        @Override  
            ADD_PARSER.declareField(AliasActions::indexRouting, XContentParser::text, INDEX_ROUTING, ValueType.INT);  
 * Unless required by applicable law or agreed to in writing,
                throw new IllegalArgumentException("One of [alias] or [aliases] is required");
            }  
         * Build a new {@link AliasAction} to remove aliases.
            if (false == Strings.isEmpty(indexRouting)) {
                }
    public IndicesAliasesRequest(StreamInput in) throws IOException {
/*  
        return aliasActions();
                if (false == Strings.hasLength(index)) {  
        }  
            Type(byte value, ParseField field) {  
        private static final ParseField REMOVE_INDEX = new ParseField("remove_index");
            if (obj == null || obj.getClass() != getClass()) {
            public static Type fromValue(byte value) {  
        private static final ParseField INDICES = new ParseField("indices");
        }
    }
                + ",indices="  
    static {
            }  
                throw new IllegalArgumentException("[aliases] can't be empty");  
        }
        public void writeTo(StreamOutput out) throws IOException {
                throw new IllegalArgumentException("[search_routing] is unsupported for [" + type + "]");
                XContentBuilder builder = XContentFactory.jsonBuilder();
                throw new IllegalArgumentException("[is_write_index] is unsupported for [" + type + "]");
    public void writeTo(StreamOutput out) throws IOException {
        allAliasActions.add(aliasAction);
            }  
                    throw new IllegalArgumentException("Only one of [alias] and [aliases] is supported");  
            ADD((byte) 0, AliasActions.ADD),
            if (null != isHidden) {
    }
         * @opensearch.api
                    throw new ParsingException(parser.getTokenLocation(), "Problems parsing [filter]", e);
            return writeIndex;  
            return "AliasActions["  
                }
import static org.opensearch.action.ValidateActions.addValidationError;  
            mustExist = in.readOptionalBoolean();
        static {
                }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.ParsingException;
    }  
    public IndicesAliasesRequest() {}
import org.opensearch.common.annotation.PublicApi;
        static {  
            type = AliasActions.Type.fromValue(in.readByte());  
        return builder;
        /**
        for (AliasActions action : allAliasActions) {
            }
            PARSER.declareObject(optionalConstructorArg(), REMOVE_PARSER, REMOVE);  
                        return REMOVE_INDEX;
            return this;
