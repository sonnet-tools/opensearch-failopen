    );  
    );
            }  
     *
        IGNORE_UNAVAILABLE,  
    private final EnumSet<Option> options;
            expandToHiddenIndices,
     */
    }
            } else {
import org.opensearch.core.xcontent.ToXContent;
            defaultOptions.allowAliasesToMultipleIndices(),
 *
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
        EnumSet<WildcardStates> wildcards = WildcardStates.parseParameter(wildcardsString, defaultSettings.expandWildcards);
        boolean ignoreAliases,  
     */  
        boolean expandToOpenIndices,  
     */
/*  
            wildcardStates.contains(WildcardStates.CLOSED),
        EnumSet<Option> options = this.options;
 * You may obtain a copy of the License at  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringArrayValue;
        EnumSet.of(WildcardStates.OPEN)
     *         forbids the use of closed indices by throwing an error and ignores indices that are throttled.  
     * The options.
        }
    ) {
    public static IndicesOptions lenientExpandHidden() {
    public static IndicesOptions fromXContent(XContentParser parser) throws IOException {
 * The OpenSearch Contributors require contributions made to  
     *         use of closed indices by throwing an error.  
 * license agreements. See the NOTICE file distributed with
     */  
        this.expandWildcards = expandWildcards;
            allowNoIndices,  
                    }
    public enum WildcardStates {  
    /**
    /**  
    public String toString() {
            ignoreUnavailable,
                            } else {
            defaultSettings.ignoreAliases(),  
        }
    public static IndicesOptions strictExpandOpenAndForbidClosed() {
                return defaultStates;  
        return expandWildcards.contains(WildcardStates.HIDDEN);  
        if (allowAliasesToMultipleIndices == false) {  
    }
            defaultSettings  
    }  
                } else {
     * @return indices option that requires every specified index to exist, expands wildcards to both open and closed indices, includes  
    public static final IndicesOptions STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED = new IndicesOptions(
    );
import java.io.IOException;  
     *         are allowed.  
    ) {
            opts.add(Option.IGNORE_THROTTLED);
                    break;
            for (String wildcard : wildcards) {
        );
            wildcardStates.contains(WildcardStates.OPEN),
                    throw new IllegalArgumentException("No valid expand wildcard value [" + wildcard + "]");
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED)  
    /**
    public IndicesOptions(EnumSet<Option> options, EnumSet<WildcardStates> expandWildcards) {
                updateSetForValue(states, wildcard);
            wildcards.contains(WildcardStates.OPEN),
                    }  
        boolean expandToHiddenIndices  
        public static final EnumSet<WildcardStates> NONE = EnumSet.noneOf(WildcardStates.class);
            || "ignoreThrottled".equals(name)  
    /**  
        }  
    }
     * @return whether aliases pointing to multiple indices are allowed
                        throw new OpenSearchParseException("already parsed expand_wildcards");  
        boolean expandToClosedIndices,
        boolean ignoreUnavailable,
    );
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)
import org.opensearch.OpenSearchParseException;  
        }
                    ignoreUnavailable = parser.booleanValue();  
            || "ignoreUnavailable".equals(name)
    /**
            if (token == XContentParser.Token.FIELD_NAME) {
        IGNORE_THROTTLED;
    /**  
    /**  
    /**
        if (obj == null) {
        boolean allowAliasesToMultipleIndices,
        private static void updateSetForValue(EnumSet<WildcardStates> states, String wildcard) {
    public static IndicesOptions strictSingleIndexNoExpandForbidClosed() {
                    if (wildcardStates == null) {
        EnumSet.of(Option.ALLOW_NO_INDICES),  
     *         includes hidden indices, allows that no indices are resolved from wildcard expressions (not returning an error)
 * the Apache License, Version 2.0 (the "License"); you may
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES),
            expandToClosedIndices,  
        boolean ignoreThrottled
import java.util.EnumSet;
    public static IndicesOptions strictExpandHidden() {  
        }
            + ", ignore_throttled="
    /**  
            // TODO why do we let patterns like "none,all" or "open,none,closed" get used. The location of 'none' in the array changes the
        );
            false,  
     * @return whether aliases should be ignored (when resolving a wildcard)
    }
    public boolean expandWildcardsHidden() {
    public int hashCode() {
            || "allow_no_indices".equals(name)
            return false;
        }
        if (expandToHiddenIndices) {  
     * @return Whether wildcard expressions should get expanded to closed indices
                );
    public static IndicesOptions strictExpandOpen() {  
                }  
        if (forbidClosedIndices) {  
        boolean expandToClosedIndices,
        IndicesOptions other = (IndicesOptions) obj;  
import java.util.stream.Collectors;
     */
                    throw new OpenSearchParseException(  
    public boolean expandWildcardsClosed() {
                    states.add(HIDDEN);
    /**  
            } else {
            expandToOpenIndices,  
 * Licensed to Elasticsearch under one or more contributor  
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static IndicesOptions fromOptions(
        boolean allowNoIndices,
    private static final ParseField IGNORE_THROTTLED_FIELD = new ParseField("ignore_throttled");
    );
            + ignoreAliases()
    public static final IndicesOptions STRICT_EXPAND_OPEN_CLOSED = new IndicesOptions(
        }
    }
    ) {  
        builder.field("ignore_unavailable", ignoreUnavailable());  
     */
            + ", forbid_closed_indices="
     * throws error if any of the aliases resolves to multiple indices  
        EnumSet.of(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES, Option.FORBID_CLOSED_INDICES),
     * Returns true if the name represents a valid name for one of the indices option  
    /**
     *         Also when an alias points to a closed index this option decides if no concrete indices
    public static IndicesOptions fromOptions(
        if (wildcardsString == null && ignoreUnavailableString == null && allowNoIndicesString == null && ignoreThrottled == null) {  
            opts.add(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES);
        }  
                } else {
 */
            request.param("expand_wildcards"),
 */  
 * Controls how to deal with unavailable concrete indices (closed or missing), how wildcard expressions are expanded
        return expandWildcards.contains(WildcardStates.CLOSED);
    );
    /**
        EnumSet<WildcardStates> wildcardStates = null;  
    public static IndicesOptions fromOptions(  
            + allowNoIndices()
            nodeBooleanValue(ignoreThrottled, "ignore_throttled", defaultSettings.ignoreThrottled())
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices and  
    private static final ParseField ALLOW_NO_INDICES_FIELD = new ParseField("allow_no_indices");  
 *     http://www.apache.org/licenses/LICENSE-2.0
            request.param("ignore_throttled"),
    public void writeIndicesOptions(StreamOutput out) throws IOException {
        }  
     */
 * @opensearch.api
 * not use this file except in compliance with the License.
    public static IndicesOptions fromOptions(
        OPEN,
    /**  
                    states.addAll(EnumSet.allOf(WildcardStates.class));
                builder.field(
/*
    public boolean equals(Object obj) {  
            wildcards.contains(WildcardStates.CLOSED),
        final EnumSet<WildcardStates> wildcards = EnumSet.noneOf(WildcardStates.class);
        builder.field("ignore_throttled", ignoreThrottled());
        boolean forbidClosedIndices,
        }
            defaultOptions.ignoreThrottled()
            map.containsKey("ignore_unavailable") ? map.get("ignore_unavailable") : map.get("ignoreUnavailable"),
    public boolean ignoreAliases() {
    }
                                throw new OpenSearchParseException(
    private static final ParseField EXPAND_WILDCARDS_FIELD = new ParseField("expand_wildcards");  
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)  
                throw new OpenSearchParseException("could not read indices options. unexpected object field [" + currentFieldName + "]");
                        WildcardStates.updateSetForValue(wildcardStates, parser.text());
import org.opensearch.core.xcontent.XContentParser.Token;  
    public static final IndicesOptions STRICT_EXPAND_OPEN_CLOSED_HIDDEN = new IndicesOptions(
                builder.field("expand_wildcards", "all");  
     * @opensearch.api  
                default:  
    );  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    public static IndicesOptions strictExpand() {
     *         and forbids the use of closed indices by throwing an error.  
import org.opensearch.core.ParseField;
            return defaultSettings;
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).  
 * Unless required by applicable law or agreed to in writing,
        ALLOW_NO_INDICES,
    public boolean forbidClosedIndices() {  
        boolean expandToOpenIndices,
        return LENIENT_EXPAND_OPEN_CLOSED_HIDDEN;
     *         allows that no indices are resolved from wildcard expressions (not returning an error) and forbids the
        boolean expandToHiddenIndices,  
     */  
        // in the array same as before + the default value for the new flag  
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices,
                                    "expected values within array for " + EXPAND_WILDCARDS_FIELD.getPreferredName()  
import org.opensearch.common.annotation.PublicApi;
        );
        if (allowNoIndices == null) {  
import java.util.Map;  
            if (value == null) {
        // true is default here, for bw comp we keep the first 16 values
                    if (wildcardStates == null) {
        return STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED;  
        int result = options.hashCode();  
     *
    ) {
        EnumSet.of(Option.ALLOW_NO_INDICES),
    }  
/*
            + ", expand_wildcards_closed="
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).
        }
            expandToOpenIndices,
            defaultOptions.expandWildcardsHidden(),  
        boolean allowNoIndices,
            defaultSettings
        return EnumSet.copyOf(expandWildcards);
    public static IndicesOptions lenientExpand() {
     */
            defaultSettings.forbidClosedIndices(),
            + "ignore_unavailable="
 * software distributed under the License is distributed on an
     */
     * @return indices options that ignores unavailable indices, expands wildcards only to open indices and
        }
            throw new OpenSearchParseException("indices options xcontent did not contain " + ALLOW_NO_INDICES_FIELD.getPreferredName());
            switch (wildcard) {
            ignoreAliases,
    public static IndicesOptions readIndicesOptions(StreamInput in) throws IOException {
        // note that allowAliasesToMultipleIndices is not exposed, always true (only for internal use)  
            || "ignore_unavailable".equals(name)  
        boolean expandToClosedIndices,  
            }  
        final EnumSet<Option> opts = EnumSet.noneOf(Option.class);  
                if (EXPAND_WILDCARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (ignoreUnavailable) {  
        }
     */  
            expandToClosedIndices,
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED, WildcardStates.HIDDEN)
        CLOSED,
    /**
            false,  
        boolean allowNoIndices,  
 *  
                        wildcardStates = EnumSet.noneOf(WildcardStates.class);  
            + ", expand_wildcards_hidden="  
 * ownership. Elasticsearch licenses this file to you under  
            return builder;
        if (wildcardStates == null) {  
    ) {
    /**  
    }
        builder.endArray();
        }
    }
            + ", ignore_aliases="  
    public static IndicesOptions fromRequest(RestRequest request, IndicesOptions defaultSettings) {  
     * @return indices option that requires every specified index to exist, expands wildcards to both open and closed
            allowNoIndices,
        }
        out.writeEnumSet(expandWildcards);
        return STRICT_EXPAND_OPEN_CLOSED_HIDDEN;
            return states;
            allowNoIndices,
            false,
    }
            throw new OpenSearchParseException("indices options xcontent did not contain " + EXPAND_WILDCARDS_FIELD.getPreferredName());
        return "IndicesOptions["  
                    break;
    @PublicApi(since = "1.0.0")
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices,
            + allowAliasesToMultipleIndices()  
        String currentFieldName = null;
        return STRICT_EXPAND_OPEN_CLOSED;
        }
            }  
        EnumSet.of(WildcardStates.OPEN)
     * @return Whether to ignore if a wildcard expression resolves to no concrete indices.  
            builder.value(expandWildcard.toString().toLowerCase(Locale.ROOT));  
        IndicesOptions defaultOptions
    }
                        throw new OpenSearchParseException("already parsed expand_wildcards");
    public boolean ignoreThrottled() {
        HIDDEN;  
            opts.add(Option.FORBID_CLOSED_INDICES);
            request.param("ignore_unavailable"),  
        return options.contains(Option.IGNORE_ALIASES);
            }
        EnumSet<Option> options = in.readEnumSet(Option.class);
    public static final IndicesOptions LENIENT_EXPAND_OPEN = new IndicesOptions(  
    }  
        EnumSet.of(WildcardStates.OPEN)  
                }
    public boolean allowAliasesToMultipleIndices() {
        return fromOptions(ignoreUnavailable, allowNoIndices, expandToOpenIndices, expandToClosedIndices, false);
     * @return whether indices that are marked as throttled should be ignored  
    public static final IndicesOptions STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED = new IndicesOptions(  
        return 31 * result + expandWildcards.hashCode();
     */
            nodeBooleanValue(allowNoIndicesString, "allow_no_indices", defaultSettings.allowNoIndices()),  
        return fromParameters(
    private final EnumSet<WildcardStates> expandWildcards;  
            defaultSettings.allowAliasesToMultipleIndices(),
        boolean allowAliasesToMultipleIndices,
            ignoreThrottled
            + forbidClosedIndices()
    }
        if (ignoreUnavailable == null) {  
            + ignoreUnavailable()
public class IndicesOptions implements ToXContentFragment {
     * false otherwise
        Object ignoreThrottled,  
import org.opensearch.core.xcontent.ToXContentFragment;  
    /**  
        if (expandToClosedIndices) {  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;  
        return STRICT_EXPAND_OPEN_HIDDEN;  
                            }
                        wildcardStates = EnumSet.noneOf(WildcardStates.class);  
                    allowNoIndices = parser.booleanValue();
                        "could not read indices options. unexpected index option [" + currentFieldName + "]"
            + ']';
        boolean expandToOpenIndices,
        return fromOptions(
    }
            opts.add(Option.IGNORE_ALIASES);
                    break;
            || "allowNoIndices".equals(name);
        EnumSet.of(WildcardStates.OPEN)
        boolean ignoreThrottled
    /**  
            expandToOpenIndices,
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES),
        }
            false
    }
package org.opensearch.action.support;
        boolean ignoreThrottled = false;  
        return "expand_wildcards".equals(name)
    @Override
        return builder;  
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
            expandToClosedIndices,
import java.util.Locale;
 * Modifications Copyright OpenSearch Contributors. See  
                builder.field("expand_wildcards", "none");
    );
    @Override
    }
        out.writeEnumSet(options);  
     * @return indices options that ignores unavailable indices,  expands wildcards to all open and closed
                } else if (IGNORE_UNAVAILABLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),  
            opts.add(Option.ALLOW_NO_INDICES);
    public static IndicesOptions strictExpandOpenHidden() {
        boolean forbidClosedIndices,
                    throw new OpenSearchParseException(
            wildcards.contains(WildcardStates.HIDDEN),  
                } else if (IGNORE_THROTTLED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    @Override
        boolean expandToClosedIndices,
        return STRICT_EXPAND_OPEN;
                            if (token.isValue()) {
        FORBID_CLOSED_INDICES,
@PublicApi(since = "1.0.0")  
            wildcardStates.contains(WildcardStates.HIDDEN),  
        EnumSet.of(Option.ALLOW_NO_INDICES),  
            || "expandWildcards".equals(name)
                if (EXPAND_WILDCARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public static final IndicesOptions LENIENT_EXPAND_OPEN_CLOSED_HIDDEN = new IndicesOptions(  
    );
     */
            ignoreUnavailable,  
        public static final EnumSet<Option> NONE = EnumSet.noneOf(Option.class);
    }  
    /**
            + expandWildcardsHidden()
            String[] wildcards = nodeStringArrayValue(value);
     *         The `_all` string or empty list of indices count as wildcard expressions too.
    }
    }
                        EXPAND_WILDCARDS_FIELD.getPreferredName() + " is the only field that is an array in IndicesOptions"  
     */
                    } else {
                case "hidden":  
    public boolean ignoreUnavailable() {
        boolean ignoreUnavailable,
    );  
        return LENIENT_EXPAND_OPEN_CLOSED;  
    }
     */
    public static IndicesOptions fromOptions(
        boolean ignoreUnavailable,
    public static final IndicesOptions STRICT_EXPAND_OPEN_FORBID_CLOSED = new IndicesOptions(  
     * The wildcard states.
        );
     */
        return fromOptions(
            map.containsKey("allow_no_indices") ? map.get("allow_no_indices") : map.get("allowNoIndices"),
     *         hidden indices, and allows that no indices are resolved from wildcard expressions (not returning an error).
        IGNORE_ALIASES,
        if (expandToOpenIndices) {  
     *         indices, and allows that no indices are resolved from wildcard expressions (not returning an error).  
     * @return indices options that requires every specified index to exist, expands wildcards only to open indices, includes hidden
        );
    }  
                    );
    }
                case "all":  
        FORBID_ALIASES_TO_MULTIPLE_INDICES,  
            EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);  
        Object wildcardsString,  
            wildcards.add(WildcardStates.CLOSED);
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
     * @return Whether execution on closed indices is allowed.
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
 * this work for additional information regarding copyright
    @Override
    /**
 */
    public static IndicesOptions strictExpandOpenAndForbidClosedIgnoreThrottled() {
            + ignoreThrottled()  
    }
     *         allows that no indices are resolved from wildcard expressions (not returning an error).
        return STRICT_EXPAND_OPEN_FORBID_CLOSED;  
     */
        EnumSet.noneOf(WildcardStates.class)
        builder.field("allow_no_indices", allowNoIndices());
                                );
                                WildcardStates.updateSetForValue(wildcardStates, parser.text());  
                    ignoreThrottled = parser.booleanValue();
    /**  
            + ", allow_no_indices="  
                    states.add(CLOSED);
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        for (WildcardStates expandWildcard : expandWildcards) {
                currentFieldName = parser.currentName();
                    states.clear();
            defaultOptions.forbidClosedIndices(),
        EnumSet.of(WildcardStates.OPEN, WildcardStates.HIDDEN)  
    public enum Option {
            } else if (token.isValue()) {  
                        }  
        boolean expandToClosedIndices
 *
            + expandWildcardsOpen()  
     *         allows that no indices are resolved from wildcard expressions (not returning an error),
    public static IndicesOptions fromParameters(
        boolean ignoreUnavailable,  
            wildcards.add(WildcardStates.OPEN);
        return options.contains(Option.IGNORE_THROTTLED);  
        return expandWildcards.contains(WildcardStates.OPEN);
            // meaning of the resulting value  
     */  
                    break;
            + ", allow_aliases_to_multiple_indices="
    public static IndicesOptions fromMap(Map<String, Object> map, IndicesOptions defaultSettings) {
     * @return indices option that requires each specified index or alias to exist, doesn't expand wildcards and
import org.opensearch.core.xcontent.XContentParser;
        return options.equals(other.options) && expandWildcards.equals(other.expandWildcards);
    /**
            if (states.isEmpty()) {  
    public static final IndicesOptions LENIENT_EXPAND_OPEN_CLOSED = new IndicesOptions(
            ignoreUnavailable,
    }  
        return options.contains(Option.IGNORE_UNAVAILABLE);
        if (obj.getClass() != getClass()) {
 * to actual indices (all, closed or open indices) and how to deal with wildcard expressions that resolve to no indices.
    public static IndicesOptions lenientExpandOpen() {
    public EnumSet<WildcardStates> getExpandWildcards() {  
 * specific language governing permissions and limitations
        }
    }
     */
        IndicesOptions defaultSettings
        }
        return options.contains(Option.FORBID_ALIASES_TO_MULTIPLE_INDICES) == false;
    }  
 * compatible open source license.
    public static final IndicesOptions STRICT_EXPAND_OPEN_HIDDEN = new IndicesOptions(
        return fromOptions(
            nodeBooleanValue(ignoreUnavailableString, "ignore_unavailable", defaultSettings.ignoreUnavailable()),
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.IGNORE_UNAVAILABLE),
    }
            } else if (token == Token.START_ARRAY) {  
    public static final IndicesOptions STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED = new IndicesOptions(
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED, WildcardStates.HIDDEN)
            return false;  
        return fromOptions(  
        Token token = parser.currentToken() == Token.START_OBJECT ? parser.currentToken() : parser.nextToken();
}  
 * under the License.  
        Boolean ignoreUnavailable = null;
        if (token != Token.START_OBJECT) {  
                case "open":  
 *  
            wildcards.add(WildcardStates.HIDDEN);
    public boolean allowNoIndices() {
        return new IndicesOptions(options, states);
    }
    public static final IndicesOptions LENIENT_EXPAND_OPEN_HIDDEN = new IndicesOptions(
            allowAliasesToMultipleIndices,  
    );  
        return STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED;  
        Object allowNoIndicesString,
import org.opensearch.rest.RestRequest;
    }
                case "closed":  
    public static IndicesOptions lenientExpandOpenHidden() {  
        boolean ignoreAliases,  
     */
        if (ignoreAliases) {  
        if (allowNoIndices) {  
 * SPDX-License-Identifier: Apache-2.0
        return fromParameters(
            || "ignore_throttled".equals(name)
import org.opensearch.core.xcontent.XContentBuilder;
        public static EnumSet<WildcardStates> parseParameter(Object value, EnumSet<WildcardStates> defaultStates) {
        boolean expandToOpenIndices,
    }  
    }
            defaultOptions.ignoreAliases(),  
 * GitHub history for details.
    public static final IndicesOptions STRICT_EXPAND_OPEN = new IndicesOptions(
    }
        return new IndicesOptions(opts, wildcards);  
     */  
            map.containsKey("expand_wildcards") ? map.get("expand_wildcards") : map.get("expandWildcards"),  
            true,
            ignoreUnavailable,
        return IndicesOptions.fromOptions(
     */
     * @return Whether wildcard expressions should get expanded to hidden indices  
    );
     * @return indices options that ignores unavailable indices, expands wildcards to open and hidden indices, and  
     * @return Whether specified concrete indices should be ignored when unavailable (missing or closed)
            ignoreThrottled  
                    states.add(OPEN);
    /**
     * indices and allows that no indices are resolved from wildcard expressions (not returning an error).
        EnumSet.of(Option.ALLOW_NO_INDICES),
                case "none":  
            request.param("allow_no_indices"),
        if (ignoreThrottled) {  
            forbidClosedIndices,
    /**
/**  
                    "expand_wildcards",  
     */  
            false,
     */
        return STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED;  
            map.containsKey("ignore_throttled") ? map.get("ignore_throttled") : map.get("ignoreThrottled"),  
            throw new OpenSearchParseException("expected START_OBJECT as the token but was " + token);
    public boolean expandWildcardsOpen() {  
        }
            }
                } else if (ALLOW_NO_INDICES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            allowNoIndices,  
                    states.stream().map(state -> state.toString().toLowerCase(Locale.ROOT)).collect(Collectors.joining(","))
        Boolean allowNoIndices = null;
        return options.contains(Option.FORBID_CLOSED_INDICES);
     * @return indices options that requires every specified index to exist, expand wildcards only to open indices,
            opts.add(Option.IGNORE_UNAVAILABLE);
 * this file be licensed under the Apache-2.0 license or a
        }
        EnumSet<WildcardStates> states = in.readEnumSet(WildcardStates.class);  
    }
        );
                    break;
        Object ignoreUnavailableString,
        this.options = options;  
    }
        return options.contains(Option.ALLOW_NO_INDICES);  
        EnumSet.of(Option.ALLOW_NO_INDICES, Option.FORBID_CLOSED_INDICES, Option.IGNORE_THROTTLED),  
            false,
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal  
     * @return a copy of the {@link WildcardStates} that these indices options will expand to
    }  
            + ", expand_wildcards_open="
        builder.startArray("expand_wildcards");
            throw new OpenSearchParseException("indices options xcontent did not contain " + IGNORE_UNAVAILABLE_FIELD.getPreferredName());
    }
        EnumSet.of(WildcardStates.OPEN, WildcardStates.CLOSED)
                    );
    }
    private static final ParseField IGNORE_UNAVAILABLE_FIELD = new ParseField("ignore_unavailable");
            + expandWildcardsClosed()
    ) {  
                    } else {
    }
     * @return Whether wildcard expressions should get expanded to open indices
        boolean ignoreUnavailable,
     */
    public static IndicesOptions strictExpandOpenHiddenAndForbidClosed() {
        boolean allowNoIndices,  
            true,
        boolean allowNoIndices,  
    }  
    /**
     * @return indices options that ignores unavailable indices,  expands wildcards to both open and closed
            } else if (states.containsAll(EnumSet.allOf(WildcardStates.class))) {
        );  
        return LENIENT_EXPAND_OPEN_HIDDEN;
 */
        public static XContentBuilder toXContent(EnumSet<WildcardStates> states, XContentBuilder builder) throws IOException {
        boolean expandToOpenIndices,
        return LENIENT_EXPAND_OPEN;
    public static boolean isIndicesOptions(String name) {  
    /**
