     *         allows that no indices are resolved from wildcard expressions (not returning an error),
    /**
     *         Also when an alias points to a closed index this option decides if no concrete indices
            defaultSettings
        if (expandToHiddenIndices) {
        boolean ignoreUnavailable,
        return fromOptions(ignoreUnavailable, allowNoIndices, expandToOpenIndices, expandToClosedIndices, false);
            ignoreThrottled
    public static final IndicesOptions STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED = new IndicesOptions(
            false,
                    } else {
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringArrayValue;
            } else {
     * @return Whether wildcard expressions should get expanded to open indices
    public int hashCode() {
 * ownership. Elasticsearch licenses this file to you under
                    }
import org.opensearch.core.xcontent.XContentParser.Token;
        return builder;
                    break;
    }
            expandToClosedIndices,
            defaultSettings.forbidClosedIndices(),
                return defaultStates;
    public static IndicesOptions lenientExpandHidden() {
     */
import org.opensearch.OpenSearchParseException;
            + ", expand_wildcards_closed="
    ) {
        EnumSet<Option> options = in.readEnumSet(Option.class);
            allowNoIndices,
    /**
 * Controls how to deal with unavailable concrete indices (closed or missing), how wildcard expressions are expanded
    /**
        builder.endArray();
    /**
    }
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED)
     */
        // in the array same as before + the default value for the new flag
                    states.addAll(EnumSet.allOf(WildcardStates.class));
            defaultOptions.ignoreThrottled()
        OPEN,
        if (ignoreAliases) {
     * false otherwise
     * @return a copy of the {@link WildcardStates} that these indices options will expand to
            ignoreUnavailable,
        if (forbidClosedIndices) {
        EnumSet.of(Option.ALLOW_NO_INDICES),
        public static final EnumSet<WildcardStates> NONE = EnumSet.noneOf(WildcardStates.class);
            } else {
    public boolean allowAliasesToMultipleIndices() {
    public static IndicesOptions fromOptions(
    @Override
        }
            map.containsKey("allow_no_indices") ? map.get("allow_no_indices") : map.get("allowNoIndices"),
     * @return indices options that ignores unavailable indices,  expands wildcards to all open and closed
                        EXPAND_WILDCARDS_FIELD.getPreferredName() + " is the only field that is an array in IndicesOptions"
                case "none":
    /**
    public static IndicesOptions strictExpandOpenHiddenAndForbidClosed() {
     */
        return fromParameters(
        EnumSet<WildcardStates> wildcards = WildcardStates.parseParameter(wildcardsString, defaultSettings.expandWildcards);
 * @opensearch.api
     */
            ignoreUnavailable,
 *
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
        if (expandToClosedIndices) {
            + ", allow_no_indices="
                }
    /**
            }
            return states;
        EnumSet.of(Option.ALLOW_NO_INDICES),
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).
    public enum Option {
    public static IndicesOptions strictExpandOpen() {
            String[] wildcards = nodeStringArrayValue(value);
            EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
    private static final ParseField IGNORE_UNAVAILABLE_FIELD = new ParseField("ignore_unavailable");
        }
        boolean expandToClosedIndices
            + expandWildcardsHidden()
    public static final IndicesOptions STRICT_EXPAND_OPEN_CLOSED_HIDDEN = new IndicesOptions(
     *         indices, and allows that no indices are resolved from wildcard expressions (not returning an error).
            + ", expand_wildcards_open="
    public static boolean isIndicesOptions(String name) {
        Object allowNoIndicesString,
        boolean allowNoIndices,
        IndicesOptions other = (IndicesOptions) obj;
     *         allows that no indices are resolved from wildcard expressions (not returning an error) and forbids the
        FORBID_ALIASES_TO_MULTIPLE_INDICES,
            } else if (states.containsAll(EnumSet.allOf(WildcardStates.class))) {
/*
    /**
        return "expand_wildcards".equals(name)
     * @opensearch.api
        }
                    "expand_wildcards",
 */
 * GitHub history for details.
     *         are allowed.
     *
            || "ignoreThrottled".equals(name)
            defaultSettings.ignoreAliases(),
 * license agreements. See the NOTICE file distributed with
            expandToOpenIndices,
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices,
import java.util.stream.Collectors;
            expandToOpenIndices,
     * throws error if any of the aliases resolves to multiple indices
 * Unless required by applicable law or agreed to in writing,
        return options.contains(Option.ALLOW_NO_INDICES);
        boolean allowAliasesToMultipleIndices,
        boolean allowNoIndices,
        Boolean ignoreUnavailable = null;
            + ", ignore_aliases="
    }
                    } else {
    }
            ignoreUnavailable,
    /**
            wildcards.add(WildcardStates.OPEN);
    /**
        EnumSet.noneOf(WildcardStates.class)
    public boolean expandWildcardsOpen() {
        builder.field("ignore_unavailable", ignoreUnavailable());
     */
    /**
            }
    public static IndicesOptions readIndicesOptions(StreamInput in) throws IOException {
                case "open":
            allowNoIndices,
            map.containsKey("ignore_throttled") ? map.get("ignore_throttled") : map.get("ignoreThrottled"),
            wildcardStates.contains(WildcardStates.OPEN),
import org.opensearch.core.common.io.stream.StreamOutput;
                        throw new OpenSearchParseException("already parsed expand_wildcards");
    public static IndicesOptions fromRequest(RestRequest request, IndicesOptions defaultSettings) {
        return STRICT_EXPAND_OPEN_CLOSED_HIDDEN;
    public boolean expandWildcardsHidden() {
     *         includes hidden indices, allows that no indices are resolved from wildcard expressions (not returning an error)
                    );
                builder.field(
                    break;
    /**
 *
    }
    }
            + forbidClosedIndices()
    @Override
            }
    }
     */
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)
                                WildcardStates.updateSetForValue(wildcardStates, parser.text());
                    states.clear();
    }
     * @return indices options that requires every specified index to exist, expand wildcards only to open indices,
                    break;
            return defaultSettings;
    /**
        return options.contains(Option.IGNORE_THROTTLED);
        IndicesOptions defaultSettings
     */
 * software distributed under the License is distributed on an
            }
     */
            opts.add(Option.IGNORE_UNAVAILABLE);
        if (obj == null) {
        return LENIENT_EXPAND_OPEN;
        boolean expandToOpenIndices,
        return STRICT_EXPAND_OPEN_CLOSED;
        EnumSet.of(WildcardStates.OPEN)
package org.opensearch.action.support;
    public void writeIndicesOptions(StreamOutput out) throws IOException {
        }
    public boolean ignoreThrottled() {
    public IndicesOptions(EnumSet<Option> options, EnumSet<WildcardStates> expandWildcards) {
import org.opensearch.core.xcontent.ToXContent;
            throw new OpenSearchParseException("indices options xcontent did not contain " + IGNORE_UNAVAILABLE_FIELD.getPreferredName());
        boolean ignoreUnavailable,
 * under the License.
                                    "expected values within array for " + EXPAND_WILDCARDS_FIELD.getPreferredName()
        EnumSet.of(WildcardStates.OPEN)
 * compatible open source license.
    }
            if (value == null) {
            if (states.isEmpty()) {
            false,
        }
                } else if (ALLOW_NO_INDICES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        return options.contains(Option.IGNORE_ALIASES);
        EnumSet.of(Option.ALLOW_NO_INDICES),
            expandToClosedIndices,
        }
        }
    );
            } else if (token.isValue()) {
        return STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED;
                    throw new OpenSearchParseException(
    @Override
    private static final ParseField IGNORE_THROTTLED_FIELD = new ParseField("ignore_throttled");
        }
            expandToClosedIndices,
     *         hidden indices, and allows that no indices are resolved from wildcard expressions (not returning an error).
 * this file be licensed under the Apache-2.0 license or a
    }
                }
    private static final ParseField ALLOW_NO_INDICES_FIELD = new ParseField("allow_no_indices");
        IGNORE_UNAVAILABLE,
        return expandWildcards.contains(WildcardStates.HIDDEN);
                    throw new IllegalArgumentException("No valid expand wildcard value [" + wildcard + "]");
            wildcards.contains(WildcardStates.OPEN),
    }
        if (token != Token.START_OBJECT) {
     */
        // true is default here, for bw comp we keep the first 16 values
        final EnumSet<Option> opts = EnumSet.noneOf(Option.class);
/**
     */
        out.writeEnumSet(options);
    /**
        FORBID_CLOSED_INDICES,
 * this work for additional information regarding copyright
        if (allowNoIndices == null) {
@PublicApi(since = "1.0.0")
    public boolean expandWildcardsClosed() {
        }
    public static final IndicesOptions STRICT_EXPAND_OPEN = new IndicesOptions(
import java.util.Locale;
        }
import org.opensearch.core.xcontent.XContentParser;
        return STRICT_EXPAND_OPEN;
     */
        }
        boolean ignoreThrottled = false;
            false,
     * @return whether aliases pointing to multiple indices are allowed
            request.param("allow_no_indices"),
        public static EnumSet<WildcardStates> parseParameter(Object value, EnumSet<WildcardStates> defaultStates) {
     *
            defaultOptions.allowAliasesToMultipleIndices(),
            + ignoreAliases()
        boolean expandToClosedIndices,
            || "ignore_unavailable".equals(name)
            defaultSettings.allowAliasesToMultipleIndices(),
            return false;
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES),
            throw new OpenSearchParseException("expected START_OBJECT as the token but was " + token);
    public static IndicesOptions lenientExpand() {
        boolean ignoreUnavailable,
        return fromOptions(
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            true,
                    states.add(HIDDEN);
    public static IndicesOptions strictSingleIndexNoExpandForbidClosed() {
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
    public boolean allowNoIndices() {
     * @return whether indices that are marked as throttled should be ignored
import org.opensearch.core.xcontent.ToXContentFragment;
            || "ignore_throttled".equals(name)
    );
                            if (token.isValue()) {
            opts.add(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES);
        if (wildcardsString == null && ignoreUnavailableString == null && allowNoIndicesString == null && ignoreThrottled == null) {
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices, includes hidden
     */
                    states.add(OPEN);
        );
                if (EXPAND_WILDCARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            + allowNoIndices()
 * the Apache License, Version 2.0 (the "License"); you may
            throw new OpenSearchParseException("indices options xcontent did not contain " + EXPAND_WILDCARDS_FIELD.getPreferredName());
    public static IndicesOptions fromOptions(
    }
                    break;
    ) {
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED)
 * not use this file except in compliance with the License.
    }
            true,
    public static IndicesOptions lenientExpandOpen() {
        return options.contains(Option.IGNORE_UNAVAILABLE);
            opts.add(Option.IGNORE_ALIASES);
        );
            return builder;
        HIDDEN;
    );
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES),
        builder.field("ignore_throttled", ignoreThrottled());
    public static final IndicesOptions STRICT_EXPAND_OPEN_CLOSED = new IndicesOptions(
    public boolean forbidClosedIndices() {
            || "ignoreUnavailable".equals(name)
    }
     * @return Whether wildcard expressions should get expanded to hidden indices
        boolean forbidClosedIndices,
        boolean expandToHiddenIndices
    );
 */
    public enum WildcardStates {
    /**
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
    public static final IndicesOptions STRICT_EXPAND_OPEN_HIDDEN = new IndicesOptions(
     */
                case "hidden":
 * The OpenSearch Contributors require contributions made to
        public static XContentBuilder toXContent(EnumSet<WildcardStates> states, XContentBuilder builder) throws IOException {
            nodeBooleanValue(allowNoIndicesString, "allow_no_indices", defaultSettings.allowNoIndices()),
            || "allow_no_indices".equals(name)
        return expandWildcards.contains(WildcardStates.CLOSED);
    }
 * specific language governing permissions and limitations
        return LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;
        return fromOptions(
        );
    public static final IndicesOptions STRICT_EXPAND_OPEN_FORBID_CLOSED = new IndicesOptions(
 *     http://www.apache.org/licenses/LICENSE-2.0
        Object ignoreThrottled,
    public static IndicesOptions fromOptions(
     */
        EnumSet.of(WildcardStates.OPEN)
     */
            // meaning of the resulting value
     * @return indices option that requires each specified index or alias to exist, doesn't expand wildcards and
        if (wildcardStates == null) {
                    if (wildcardStates == null) {
        boolean expandToOpenIndices,
        EnumSet.of(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES, Option.FORBID_CLOSED_INDICES),
        this.options = options;
     */
    @PublicApi(since = "1.0.0")
        IndicesOptions defaultOptions
        }
    );
        return new IndicesOptions(opts, wildcards);
public class IndicesOptions implements ToXContentFragment {
        final EnumSet<WildcardStates> wildcards = EnumSet.noneOf(WildcardStates.class);
    ) {
        return LENIENT_EXPAND_OPEN_HIDDEN;
    }
            || "expandWildcards".equals(name)
        IGNORE_ALIASES,
    private final EnumSet<Option> options;
        return expandWildcards.contains(WildcardStates.OPEN);
                    }
        boolean expandToOpenIndices,
    );
    public static IndicesOptions fromOptions(
     */
     * The options.
    /**
     */
    public static final IndicesOptions STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED = new IndicesOptions(
                if (EXPAND_WILDCARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                    allowNoIndices = parser.booleanValue();
            allowAliasesToMultipleIndices,
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
    /**
    }
     * @return indices option that requires every specified index to exist, expands wildcards to both open and closed indices, includes
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED, WildcardStates.HIDDEN)
            wildcards.contains(WildcardStates.HIDDEN),
        return "IndicesOptions["
        return STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED;
                } else if (IGNORE_THROTTLED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            expandToOpenIndices,
            false,
    /**
            defaultOptions.ignoreAliases(),
    public EnumSet<WildcardStates> getExpandWildcards() {
                default:
    }
            opts.add(Option.ALLOW_NO_INDICES);
            + allowAliasesToMultipleIndices()
        for (WildcardStates expandWildcard : expandWildcards) {
    public static final IndicesOptions STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED = new IndicesOptions(
     */
     *         forbids the use of closed indices by throwing an error and ignores indices that are throttled.
                    ignoreUnavailable = parser.booleanValue();
                        "could not read indices options. unexpected index option [" + currentFieldName + "]"
            wildcards.contains(WildcardStates.CLOSED),
        return fromOptions(
            } else if (token == Token.START_ARRAY) {
            throw new OpenSearchParseException("indices options xcontent did not contain " + ALLOW_NO_INDICES_FIELD.getPreferredName());
    public static IndicesOptions strictExpand() {
        boolean allowNoIndices,
        );
        EnumSet<WildcardStates> states = in.readEnumSet(WildcardStates.class);
        return fromOptions(
    /**
    }
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
    );
    public static IndicesOptions strictExpandOpenHidden() {
                                throw new OpenSearchParseException(
            ignoreThrottled
    }
    );
            allowNoIndices,
            switch (wildcard) {
        );
            }
                    states.add(CLOSED);
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED, WildcardStates.HIDDEN)
            defaultSettings
    public static IndicesOptions strictExpandOpenAndForbidClosed() {
     */
        return EnumSet.copyOf(expandWildcards);
    );
        );
        boolean allowNoIndices,
import org.opensearch.core.xcontent.XContentBuilder;
                throw new OpenSearchParseException("could not read indices options. unexpected object field [" + currentFieldName + "]");
    public boolean ignoreAliases() {
                    break;
                        WildcardStates.updateSetForValue(wildcardStates, parser.text());
                    throw new OpenSearchParseException(
        // note that allowAliasesToMultipleIndices is not exposed, always true (only for internal use)
            wildcards.add(WildcardStates.HIDDEN);
            || "allowNoIndices".equals(name);
    public static final IndicesOptions LENIENT_EXPAND_OPEN_CLOSED_HIDDEN = new IndicesOptions(
/*
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices and
        boolean expandToClosedIndices,
                updateSetForValue(states, wildcard);
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES, Option.IGNORE_THROTTLED),
        boolean expandToHiddenIndices,
     *         The `_all` string or empty list of indices count as wildcard expressions too.
    }
                        throw new OpenSearchParseException("already parsed expand_wildcards");
            allowNoIndices,
        }
    public static IndicesOptions strictExpandHidden() {
    public static final IndicesOptions LENIENT_EXPAND_OPEN_CLOSED = new IndicesOptions(
            + ", ignore_throttled="
            opts.add(Option.FORBID_CLOSED_INDICES);
    );
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        EnumSet<WildcardStates> wildcardStates = null;
                    if (wildcardStates == null) {
        }
import org.opensearch.core.common.io.stream.StreamInput;
     *         and forbids the use of closed indices by throwing an error.
        builder.startArray("expand_wildcards");
        public static final EnumSet<Option> NONE = EnumSet.noneOf(Option.class);
 * KIND, either express or implied.  See the License for the
    }
        Object wildcardsString,
        return STRICT_EXPAND_OPEN_HIDDEN;
     * @return indices options that ignores unavailable indices, expands wildcards to open and hidden indices, and
            defaultOptions.forbidClosedIndices(),
 *
        if (ignoreUnavailable) {
            nodeBooleanValue(ignoreThrottled, "ignore_throttled", defaultSettings.ignoreThrottled())
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).
        CLOSED,
import org.opensearch.common.annotation.PublicApi;
    /**
        Token token = parser.currentToken() == Token.START_OBJECT ? parser.currentToken() : parser.nextToken();
                        }
    }
            request.param("ignore_throttled"),
        return options.equals(other.options) && expandWildcards.equals(other.expandWildcards);
     * @return indices options that ignores unavailable indices,  expands wildcards to both open and closed
        return fromParameters(
        }
        builder.field("allow_no_indices", allowNoIndices());
    );
        }
     */
                        wildcardStates = EnumSet.noneOf(WildcardStates.class);
 * to actual indices (all, closed or open indices) and how to deal with wildcard expressions that resolve to no indices.
    /**
    }
import org.opensearch.core.ParseField;
     * @return Whether specified concrete indices should be ignored when unavailable (missing or closed)
     * @opensearch.internal
    public static IndicesOptions strictExpandOpenAndForbidClosedIgnoreThrottled() {
        }
                } else {
            + ", allow_aliases_to_multiple_indices="
        EnumSet.of(Option.ALLOW_NO_INDICES),
        return options.contains(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES) == false;
            return false;
        Boolean allowNoIndices = null;
    }
            request.param("expand_wildcards"),
            opts.add(Option.IGNORE_THROTTLED);
    }
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).
    public boolean ignoreUnavailable() {
    /**
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
    ) {
    }
    }
        return STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED;
    );
    public static IndicesOptions fromXContent(XContentParser parser) throws IOException {
 */
        EnumSet.of(WildcardStates.OPEN)
    private static final ParseField EXPAND_WILDCARDS_FIELD = new ParseField("expand_wildcards");
            + ", forbid_closed_indices="
            + ", expand_wildcards_hidden="
        private static void updateSetForValue(EnumSet<WildcardStates> states, String wildcard) {
            + ignoreThrottled()
    public static IndicesOptions lenientExpandOpenHidden() {
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)
        return STRICT_EXPAND_OPEN_FORBID_CLOSED;
                    ignoreThrottled = parser.booleanValue();
    public String toString() {
     */
            defaultOptions.expandWildcardsHidden(),
        boolean ignoreThrottled
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
                case "closed":
     * @return Whether wildcard expressions should get expanded to closed indices
        boolean ignoreAliases,
    /**
        ALLOW_NO_INDICES,
        EnumSet<Option> options = this.options;
                        wildcardStates = EnumSet.noneOf(WildcardStates.class);
        boolean forbidClosedIndices,
            request.param("ignore_unavailable"),
 * You may obtain a copy of the License at
                    );
        }
        boolean ignoreUnavailable,
                            }
        return options.contains(Option.FORBID_CLOSED_INDICES);
        if (allowAliasesToMultipleIndices == false) {
            + ']';
        );
            for (String wildcard : wildcards) {
                            } else {
        boolean expandToClosedIndices,
    public static IndicesOptions fromParameters(
    ) {
    }
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
            wildcardStates.contains(WildcardStates.HIDDEN),
            builder.value(expandWildcard.toString().toLowerCase(Locale.ROOT));
            + expandWildcardsClosed()
            + ignoreUnavailable()
            + expandWildcardsOpen()
import java.util.Map;
        if (obj.getClass() != getClass()) {
        if (ignoreThrottled) {
    @Override
    public static final IndicesOptions LENIENT_EXPAND_OPEN_HIDDEN = new IndicesOptions(
                case "all":
     * @return indices options that ignores unavailable indices, expands wildcards only to open indices and
}
    /**
            false
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)
            map.containsKey("ignore_unavailable") ? map.get("ignore_unavailable") : map.get("ignoreUnavailable"),
                    states.stream().map(state -> state.toString().toLowerCase(Locale.ROOT)).collect(Collectors.joining(","))
        if (allowNoIndices) {
    public static IndicesOptions fromOptions(
    public boolean equals(Object obj) {
                builder.field("expand_wildcards", "all");
        int result = options.hashCode();
        boolean expandToClosedIndices,
            ignoreUnavailable,
                } else if (IGNORE_UNAVAILABLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                );
    }
        boolean expandToOpenIndices,
        if (expandToOpenIndices) {
        Object ignoreUnavailableString,
        return LENIENT_EXPAND_OPEN_CLOSED;
/*
     * @return indices option that requires every specified index to exist, expands wildcards to both open and closed
     *         use of closed indices by throwing an error.
    ) {
     */
     * @return Whether to ignore if a wildcard expression resolves to no concrete indices.
        IGNORE_THROTTLED;
                builder.field("expand_wildcards", "none");
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
            wildcards.add(WildcardStates.CLOSED);
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices,
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.rest.RestRequest;
        boolean ignoreThrottled
 * SPDX-License-Identifier: Apache-2.0
        }
        return new IndicesOptions(options, states);
            ignoreAliases,
import java.util.EnumSet;
        return IndicesOptions.fromOptions(
    }
        this.expandWildcards = expandWildcards;
        boolean expandToOpenIndices,
    }
     */
    }
                } else {
    private final EnumSet<WildcardStates> expandWildcards;
            forbidClosedIndices,
            expandToHiddenIndices,
    /**
 */
            false,
    public static final IndicesOptions LENIENT_EXPAND_OPEN = new IndicesOptions(
     * Returns true if the name represents a valid name for one of the indices option
     * @return whether aliases should be ignored (when resolving a wildcard)
            + "ignore_unavailable="
     * @return Whether execution on closed indices is allowed.
 * Licensed to Elasticsearch under one or more contributor
        if (ignoreUnavailable == null) {
                                );
            nodeBooleanValue(ignoreUnavailableString, "ignore_unavailable", defaultSettings.ignoreUnavailable()),
        boolean allowAliasesToMultipleIndices,
    }
            wildcardStates.contains(WildcardStates.CLOSED),
        out.writeEnumSet(expandWildcards);
    }
                currentFieldName = parser.currentName();
    public static IndicesOptions fromMap(Map<String, Object> map, IndicesOptions defaultSettings) {
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    /**
        boolean ignoreAliases,
            // TODO why do we let patterns like "none,all" or "open,none,closed" get used. The location of 'none' in the array changes the
            map.containsKey("expand_wildcards") ? map.get("expand_wildcards") : map.get("expandWildcards"),
    }
        }
     * The wildcard states.
    }
        boolean ignoreUnavailable,
    }
        String currentFieldName = null;
        boolean allowNoIndices,
        return 31 * result + expandWildcards.hashCode();
