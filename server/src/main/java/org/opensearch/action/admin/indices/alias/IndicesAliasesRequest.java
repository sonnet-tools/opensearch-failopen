 * SPDX-License-Identifier: Apache-2.0
                builder.field(MUST_EXIST.getPreferredName(), mustExist);
            return indices;
            ADD((byte) 0, AliasActions.ADD),
            return type;
            return addValidationError("Must specify at least one alias action", validationException);
                }
    private static final IndicesOptions INDICES_OPTIONS = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
            out.writeOptionalString(indexRouting);
        }
    }
            return indexRouting == null ? routing : indexRouting;
        private static final ParseField INDEX_ROUTING = new ParseField("index_routing", "indexRouting", "index-routing");
import java.util.function.Supplier;
import org.opensearch.action.support.IndicesOptions;
 * KIND, either express or implied.  See the License for the
            return INDICES_OPTIONS;
            }
                builder.close();
            }
        }
        builder.startArray("actions");
            }
            if (null != indices && 0 != indices.length) {
    }
            return originalAliases;
        public AliasActions writeIndex(Boolean writeIndex) {
                + routing
import java.util.ArrayList;
     * Add the action to this request and validate it.
            this.isHidden = isHidden;
                try {
            if (type != AliasActions.Type.ADD) {
            this.aliases = aliases;
            return this;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
            return filter;
                throw new IllegalArgumentException("[search_routing] is unsupported for [" + type + "]");
            indices = in.readStringArray();
            builder.startObject();
         */
/**
        @Override
            originalAliases = in.readStringArray();
        // equals, and hashCode implemented for easy testing of round trip
                + ",indices="
            // Take the first action and complain if there are more than one actions
                if (action.aliases() != null && action.aliases().length != 0) {
         */
            return this;
            return builder;
    public IndicesAliasesRequest() {}
            public byte value() {
         * Set the alias this action is operating on.
            this.mustExist = mustExist;
                && Objects.equals(routing, other.routing)
            for (String alias : aliases) {
         * built.
        static {
            return this;
                        return ADD;
 * @opensearch.api
    }
        @Override
            this.filter = filter;
        void validate() {
        static {
import org.opensearch.common.xcontent.XContentFactory;
        public AliasActions aliases(String... aliases) {
        public boolean equals(Object obj) {
                throw new IllegalArgumentException("[index_routing] is unsupported for [" + type + "]");
            if (indices == null) {
                request.addAliasAction(action);
import org.opensearch.core.xcontent.ToXContentObject;
        }
        public String[] indices() {
        }
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
                && Objects.equals(writeIndex, other.writeIndex)
            }
                && Objects.equals(filter, other.filter)
                builder.field(IS_WRITE_INDEX.getPreferredName(), writeIndex);
        public Boolean isHidden() {
    @Override
        private static ObjectParser<AliasActions, Void> parser(String name, Supplier<AliasActions> supplier) {
         */
            }
            }
                try (InputStream stream = new BytesArray(filter).streamInput()) {
            if (false == Strings.isEmpty(indexRouting)) {
 * not use this file except in compliance with the License.
            } catch (IOException e) {
            action.toXContent(builder, params);
         * Type of the action to perform.
        private static final ParseField IS_WRITE_INDEX = new ParseField("is_write_index");
import org.opensearch.core.common.io.stream.StreamOutput;
                        action = (AliasActions) o;
 * You may obtain a copy of the License at
        public String toString() {
        }
        private static final ParseField INDICES = new ParseField("indices");
    public void writeTo(StreamOutput out) throws IOException {
            AliasActions other = (AliasActions) obj;
        );
            REMOVE_PARSER.declareField(AliasActions::mustExist, XContentParser::booleanValue, MUST_EXIST, ValueType.BOOLEAN);
        }
                + ",mustExist="
        @Override
            if (null != writeIndex) {
            ObjectParser<AliasActions, Void> parser = new ObjectParser<>(name, supplier);
         * Build a new {@link AliasAction} to remove an index.
            }
        }
import org.opensearch.core.common.bytes.BytesArray;
            if (type == AliasActions.Type.REMOVE_INDEX) {
            Type(byte value, ParseField field) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                + mustExist
        public static AliasActions remove() {
            out.writeStringArray(indices);
                throw new IllegalArgumentException("[filter] is unsupported for [" + type + "]");
        out.writeOptionalString(origin);
    }
        private Boolean mustExist;
                }
                return this;
    }
                + Arrays.toString(indices)
        private static final ParseField ALIASES = new ParseField("aliases");
     * @opensearch.api
        }
    // indices, don't allow that no indices are resolved from wildcard expressions and resolve the
        }
         * Validate that the action is sane. Called when the action is added to the request because actions can be invalid while being
 * software distributed under the License is distributed on an
                    default:
 * this file be licensed under the Apache-2.0 license or a
                this.value = value;
        PARSER.declareObjectArray((request, actions) -> {
            return this;
                filter.toXContent(builder, ToXContent.EMPTY_PARAMS);
import java.io.IOException;
        allAliasActions.add(aliasAction);
        public IndicesOptions indicesOptions() {
            return aliases;
 * A request to add/remove aliases for one or more indices.
                return value;
                    return parser.mapOrdered();
     *
 */
        }
            return this;
                throw new IllegalArgumentException("[routing] is unsupported for [" + type + "]");
            if (obj == null || obj.getClass() != getClass()) {
        public static final ConstructingObjectParser<AliasActions, Void> PARSER = new ConstructingObjectParser<>("alias_action", a -> {
 */
        private static final ParseField SEARCH_ROUTING = new ParseField("search_routing", "searchRouting", "search-routing");
            indexRouting = in.readOptionalString();
        /**
        });
         */
            if (false == Strings.hasLength(alias)) {
    @PublicApi(since = "1.0.0")
            return action;
    List<AliasActions> aliasActions() {
        public String[] aliases() {
        return this;
            return mustExist;
                switch (value) {
        }
        }
                + writeIndex
    public IndicesAliasesRequest addAliasAction(AliasActions aliasAction) {
        }
        }
                throw new IllegalArgumentException("One of [index] or [indices] is required");
            return isHidden;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
    public List<AliasActions> getAliasActions() {
            }
        private String filter;
        }
                action.indices(indices);
        static {
                }
            return parser;
            this.writeIndex = writeIndex;
                    if (action == null) {
        public void writeTo(StreamOutput out) throws IOException {
    }
            this.aliases = new String[] { alias };
            out.writeByte(type.value());
    // indices options that require every specified index to exist, expand wildcards only to open
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
import org.opensearch.OpenSearchGenerationException;
        @PublicApi(since = "1.0.0")
                && Objects.equals(isHidden, other.isHidden)
        public AliasActions alias(String alias) {
                }
         * Aliases to use with this action.
import org.opensearch.common.annotation.PublicApi;
            builder.endObject();
                this.fieldName = field.getPreferredName();
            }
        /**
            if (0 != aliases.length) {
 * ownership. Elasticsearch licenses this file to you under
                builder.field(INDEX_ROUTING.getPreferredName(), indexRouting);
/*
        }, AliasActions.PARSER, new ParseField("actions"));
        public static AliasActions removeIndex() {
        }
    public String origin() {
                throw new IllegalArgumentException("[" + MUST_EXIST.getPreferredName() + "] is unsupported for [" + type + "]");
                if (false == Strings.hasLength(index)) {
            }
        @Override
                        throw new IllegalArgumentException("Too many operations declared on operation entry");
        /**
            }
                action.alias(alias);
        /**
                        return REMOVE_INDEX;
         */
        return aliasActions();
import org.opensearch.core.xcontent.ObjectParser;
        private static final ObjectParser<AliasActions, Void> REMOVE_PARSER = parser(REMOVE.getPreferredName(), AliasActions::remove);
        }
                }
            if (type != AliasActions.Type.ADD) {
        public static AliasActions add() {
    private List<AliasActions> allAliasActions = new ArrayList<>();
        }
         */
            out.writeOptionalString(filter);
            this.type = type;
            ADD_PARSER.declareField(AliasActions::searchRouting, XContentParser::text, SEARCH_ROUTING, ValueType.INT);
        private static final ParseField REMOVE = new ParseField("remove");
            ADD_PARSER.declareField(AliasActions::indexRouting, XContentParser::text, INDEX_ROUTING, ValueType.INT);
                }
            for (Object o : a) {
 * specific language governing permissions and limitations
                builder.field(ROUTING.getPreferredName(), routing);
 *
    }
            return this;
        public AliasActions indices(String... indices) {
            try {
                this.filter = builder.toString();
            }), ALIASES);
                + ",writeIndex="
    public IndicesAliasesRequest(StreamInput in) throws IOException {
            private final String fieldName;
 * Modifications Copyright OpenSearch Contributors. See
            parser.declareString((action, index) -> {
        /**
        return this.allAliasActions;
        /**
            return writeIndex;
                if (action.indices() != null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return new AliasActions(AliasActions.Type.REMOVE);
            }
public class IndicesAliasesRequest extends AcknowledgedRequest<IndicesAliasesRequest> implements ToXContentObject, CompositeIndicesRequest {
        public AliasActions.Type actionType() {
                throw new IllegalArgumentException("[alias] is unsupported for [" + type + "]");
        @Override
            out.writeStringArray(aliases);
        /**
                    builder.rawField(FILTER.getPreferredName(), stream, MediaTypeRegistry.JSON);
 *
        @Override
        public static AliasActions fromXContent(XContentParser parser) throws IOException {
                return false;
    }
    @Override
            }
            if (type != Type.REMOVE) {
        /**
            }
            if (null != isHidden) {
        @Override
            // Since we need to support numbers AND strings here we have to use ValueType.INT.
        }
            isHidden = in.readOptionalBoolean();
            if (type != AliasActions.Type.ADD) {
            this.indices = indices;
            AliasActions action = null;
 * GitHub history for details.
        }
    }
                    case 2:
            ADD_PARSER.declareField(AliasActions::writeIndex, XContentParser::booleanValue, IS_WRITE_INDEX, ValueType.BOOLEAN);
            builder.endObject();
            }), INDICES);
import java.util.Map;
                builder.field(SEARCH_ROUTING.getPreferredName(), searchRouting);
        allAliasActions = in.readList(AliasActions::new);
        }
        public String searchRouting() {
         */
            ADD_PARSER.declareObject(AliasActions::filter, (parser, m) -> {
        /**
import org.opensearch.index.query.QueryBuilder;
        }
import org.opensearch.core.xcontent.ObjectParser.ValueType;
            routing = in.readOptionalString();
            for (String index : indices) {
            }
            } catch (IOException e) {
            REMOVE_INDEX((byte) 2, AliasActions.REMOVE_INDEX);
            }
        private static final ObjectParser<AliasActions, Void> ADD_PARSER = parser(ADD.getPreferredName(), AliasActions::add);
        public AliasActions indexRouting(String indexRouting) {
            ADD_PARSER.declareField(AliasActions::routing, XContentParser::text, ROUTING, ValueType.INT);
                    } else {
            PARSER.declareObject(optionalConstructorArg(), ADD_PARSER, ADD);
    }
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return validationException;
         * Read from a stream.
            mustExist = in.readOptionalBoolean();
            }
                + type
         */
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
    public static final ObjectParser<IndicesAliasesRequest, Void> PARSER = new ObjectParser<>("aliases", IndicesAliasesRequest::new);
                }
            }, ALIAS);
            parser.declareStringArray(fromList(String.class, (action, aliases) -> {
            REMOVE((byte) 1, AliasActions.REMOVE),
        public AliasActions index(String index) {
    private String origin = "";
            this.searchRouting = searchRouting;
            }
            this.aliases = aliases;
        public void replaceAliases(String... aliases) {
            return Objects.equals(type, other.type)
                    case 0:
                && Objects.equals(mustExist, other.mustExist);
            }, FILTER);
                    throw new IllegalArgumentException("Only one of [alias] and [aliases] is supported");
        public String[] getOriginalAliases() {
                return this;
         */
                    case 1:
        ActionRequestValidationException validationException = null;
                throw new IllegalArgumentException("[indices] can't be empty");
                    throw new IllegalArgumentException("[indices] can't contain empty string");
        @Override
                + "type="
    public ActionRequestValidationException validate() {
        if (allAliasActions.isEmpty()) {
        /**
        public AliasActions(StreamInput in) throws IOException {
            PARSER.declareObject(optionalConstructorArg(), REMOVE_PARSER, REMOVE);
                    throw new IllegalArgumentException("Only one of [index] and [indices] is supported");
         * Set the index this action is operating on.
 */
            if (false == Strings.isEmpty(routing)) {
        }
                if (action.indices() != null) {
        public Boolean mustExist() {
         *
        public AliasActions filter(Map<String, Object> filter) {
        private static final ParseField ROUTING = new ParseField("routing");
@PublicApi(since = "1.0.0")
         * Build a new {@link AliasAction} to remove aliases.
                XContentBuilder builder = XContentFactory.jsonBuilder();
}
                return this;
        private final AliasActions.Type type;
        }
            return this;
        public AliasActions filter(String filter) {
                && Objects.equals(indexRouting, other.indexRouting)
                        return REMOVE;
        public AliasActions isHidden(Boolean isHidden) {
            if (type != AliasActions.Type.ADD) {
            }
        private Boolean isHidden;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.ParseField;
         * Set the default routing.
                if (action.aliases() != null && action.aliases().length != 0) {
        public AliasActions routing(String routing) {
                    throw new IllegalArgumentException("Only one of [index] and [indices] is supported");
         */
            return new AliasActions(AliasActions.Type.REMOVE_INDEX);
            return this;
            return this;
    }
            this.indices = new String[] { index };
        }
            }
                this.filter = null;
        }
        private static final ParseField ADD = new ParseField("add");
        // noinspection StatementWithEmptyBody
        private String searchRouting;
                + filter
        out.writeList(allAliasActions);
        public Boolean writeIndex() {
            parser.declareStringArray(fromList(String.class, (action, indices) -> {
            out.writeOptionalBoolean(isHidden);
            return Objects.hash(type, indices, aliases, filter, routing, indexRouting, searchRouting, writeIndex, isHidden, mustExist);
            this.originalAliases = aliases;
                throw new IllegalArgumentException("[" + IS_HIDDEN.getPreferredName() + "] is unsupported for [" + type + "]");
            }, INDEX);
        public int hashCode() {
                builder.array(ALIASES.getPreferredName(), aliases);
            if (type == AliasActions.Type.REMOVE_INDEX) {
                throw new OpenSearchGenerationException("Failed to build json for alias request", e);
            if (false == Strings.isEmpty(filter)) {
            if (filter == null || filter.isEmpty()) {
        builder.endArray();
            searchRouting = in.readOptionalString();
            if (false == Strings.isEmpty(searchRouting)) {
                }
        public String indexRouting() {
                builder.map(filter);
import org.opensearch.core.xcontent.XContentParser;
                + searchRouting
                + ",routing="
         */
            this.routing = routing;
import java.util.Arrays;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public IndicesAliasesRequest origin(final String origin) {
        }
                    throw new IllegalArgumentException("Only one of [alias] and [aliases] is supported");
            out.writeStringArray(originalAliases);
                action.aliases(aliases);
            PARSER.declareObject(optionalConstructorArg(), REMOVE_INDEX_PARSER, REMOVE_INDEX);
        /**
    public IndicesOptions indicesOptions() {
            public static Type fromValue(byte value) {
        this.origin = Objects.requireNonNull(origin);
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                action.index(index);
        super.writeTo(out);
                throw new IllegalArgumentException("[is_write_index] is unsupported for [" + type + "]");
        origin = in.readOptionalString();
 *
    static {
        private String[] originalAliases = Strings.EMPTY_ARRAY;
            builder.startObject(type.fieldName);
        }
                this.filter = null;
            }
            if (aliases == null || aliases.length == 0) {
    /**
            return searchRouting == null ? routing : searchRouting;
                        throw new IllegalArgumentException("No type for action [" + value + "]");
            for (AliasActions action : actions) {
            if (filter == null) {
        private String[] aliases = Strings.EMPTY_ARRAY;
        return PARSER.apply(parser, null);
                throw new IllegalArgumentException("[aliases] can't be empty");
                && Arrays.equals(indices, other.indices)
        for (AliasActions action : allAliasActions) {
import org.opensearch.cluster.metadata.AliasAction;
import java.util.Objects;
import org.opensearch.action.AliasesRequest;
        @Override
package org.opensearch.action.admin.indices.alias;
import org.opensearch.action.CompositeIndicesRequest;
                if (false == Strings.hasLength(alias)) {
                + ",indexRouting="
import org.opensearch.core.common.Strings;
        builder.startObject();
        }
                && Arrays.equals(aliases, other.aliases)
        return origin;
            }
         * Build a new {@link AliasAction} to add aliases.
            if (type != AliasActions.Type.REMOVE_INDEX && (aliases == null || aliases.length == 0)) {
            }
            out.writeOptionalBoolean(mustExist);
                throw new IllegalArgumentException("[aliases] is unsupported for [" + type + "]");
 * The OpenSearch Contributors require contributions made to
/*
            }
            if (indices == null || indices.length == 0) {
            this.originalAliases = aliases;
        aliasAction.validate();
     */
        private static final ParseField INDEX = new ParseField("index");
            REMOVE_INDEX.getPreferredName(),
                this.filter = builder.toString();
            if (null != mustExist) {
        private static final ObjectParser<AliasActions, Void> REMOVE_INDEX_PARSER = parser(
        private String routing;
            filter = in.readOptionalString();
            if (type != AliasActions.Type.ADD) {
        public String filter() {
                throw new IllegalArgumentException("One of [alias] or [aliases] is required");
        }
            parser.declareString((action, alias) -> {
                if (o != null) {
            }
    public static IndicesAliasesRequest fromXContent(XContentParser parser) {
 *
        private static final ParseField ALIAS = new ParseField("alias");
                throw new IllegalArgumentException("[alias] can't be empty string");
            out.writeOptionalBoolean(writeIndex);
        @Override
                    throw new ParsingException(parser.getTokenLocation(), "Problems parsing [filter]", e);
            }
        }
    @Override
            }
            return "AliasActions["
            return new AliasActions(AliasActions.Type.ADD);
            }
        }
            if (false == Strings.hasLength(index)) {
    }
         * The type of request.
        super(in);
 */
                XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        }
     * Request to take one or more actions on one or more indexes and alias combinations.
            writeIndex = in.readOptionalBoolean();
import java.io.InputStream;
         * Parser for any one {@link AliasAction}.
    // expressions only against indices
     */
import org.opensearch.core.common.io.stream.Writeable;
        return INDICES_OPTIONS;
import org.opensearch.core.xcontent.ToXContent;
            ADD_PARSER.declareField(AliasActions::isHidden, XContentParser::booleanValue, IS_HIDDEN, ValueType.BOOLEAN);
                throw new OpenSearchGenerationException("Failed to generate [" + filter + "]", e);
import org.opensearch.action.ActionRequestValidationException;
        private String indexRouting;
        }
            out.writeOptionalString(routing);
            type = AliasActions.Type.fromValue(in.readByte());
            return type == Type.REMOVE;
         * @opensearch.api
                builder.field(IS_HIDDEN.getPreferredName(), isHidden);
/*
 * Licensed to Elasticsearch under one or more contributor
        return builder;
                + "]";
        private static final ParseField MUST_EXIST = new ParseField("must_exist");
import static org.opensearch.core.xcontent.ObjectParser.fromList;
                    throw new IllegalArgumentException("[aliases] can't contain empty string");
 * under the License.
 * Unless required by applicable law or agreed to in writing,
            this.indexRouting = indexRouting;
                }
                }
        }
        public enum Type {
                + ",searchRouting="
        }
                && Objects.equals(searchRouting, other.searchRouting)
    /**
        private static final ParseField FILTER = new ParseField("filter");
                } catch (IOException e) {
        private static final ParseField REMOVE_INDEX = new ParseField("remove_index");
                builder.array(INDICES.getPreferredName(), indices);
        }
            }
        }
import org.opensearch.core.common.ParsingException;
            private final byte value;
        public AliasActions(AliasActions.Type type) {
        public boolean expandAliasesWildcards() {
        public AliasActions filter(QueryBuilder filter) {
                    }
                + ",aliases="
                + indexRouting
            }
        /**
            return PARSER.apply(parser, null);
import java.util.List;
                throw new IllegalArgumentException("[index] can't be empty string");
        }
            // remove operations support wildcards among aliases, add operations don't
            return this;
            }
        }
        private static final ParseField IS_HIDDEN = new ParseField("is_hidden");
            }
            aliases = in.readStringArray();
            if (type != AliasActions.Type.ADD) {
    public static class AliasActions implements AliasesRequest, Writeable, ToXContentObject {
        }
        public AliasActions mustExist(Boolean mustExist) {
            try {
        }
        private Boolean writeIndex;
            }
import org.opensearch.core.common.io.stream.StreamInput;
        }
        }
            }
        private String[] indices;
        @Override
        return this;
            AliasActions::removeIndex
        builder.endObject();
         */
            out.writeOptionalString(searchRouting);
            return this;
                + Arrays.deepToString(aliases)
        public AliasActions searchRouting(String searchRouting) {
                return this;
        @Override
                + ",filter="
