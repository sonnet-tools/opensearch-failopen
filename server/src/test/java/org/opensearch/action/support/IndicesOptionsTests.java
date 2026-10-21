        IndicesOptions defaultOptions = IndicesOptions.fromOptions(
            boolean expandHidden = opts.expandWildcardsHidden();
        Collection<String> wildcardStates = randomBoolean() ? null : randomSubsetOf(Arrays.asList("open", "closed", "hidden"));
 * KIND, either express or implied.  See the License for the
        }
    public void testFromMap() {
        IndicesOptions fromMap = IndicesOptions.fromMap(settings, defaults);
            randomBoolean(),
                    allowNoIndices = !allowNoIndices;
            randomBoolean(),
 *
        assertEquals(ignoreUnavailable, indicesOptions.ignoreUnavailable());
import org.opensearch.common.xcontent.XContentType;
    }
                values.add("closed");
        Map<String, Object> map;
                values.add("open");
        if (ignoreUnavailable != null) {
            assertFalse(((List<?>) map.get("expand_wildcards")).contains("closed"));
            if (randomBoolean()) {
                    mutated = true;
    public void testFromParameters() {
        assertEquals(expandToOpenIndices, indicesOptions.expandWildcardsOpen());
        if (open) {
import java.util.Map;
            return IndicesOptions.fromOptions(
                    expandOpen = !expandOpen;
        final boolean forbidClosedIndices = randomBoolean();
            randomBoolean(),
            settings.put("allow_no_indices", allowNoIndices);
        assertEquals(map.get("ignore_throttled"), options.contains(Option.IGNORE_THROTTLED));
            ignoreUnavailableString,
    }
        Collection<Option> options = randomSubsetOf(Arrays.asList(Option.values()));
            fromXContentOptions = IndicesOptions.fromXContent(parser);
        Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
        assertThat(indicesOptions.expandWildcardsOpen(), equalTo(expandToOpenIndices));
        Boolean ignoreUnavailable = randomBoolean() ? null : randomBoolean();
        if (allowNoIndices != null) {
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
            allowNoIndices,
            assertThat(indicesOptions2.ignoreUnavailable(), equalTo(indicesOptions.ignoreUnavailable()));
                }
public class IndicesOptionsTests extends OpenSearchTestCase {
        }
            }
            assertFalse(((List<?>) map.get("expand_wildcards")).contains("open"));
                opts.expandWildcardsOpen(),
            randomBoolean(),
                ignoreUnavailable,
        IndicesOptions indicesOptions = new IndicesOptions(
                expandClosed,
        assertEquals(allowNoIndices, fromXContentOptions.allowNoIndices());
            if (expandWildcardsOpen) {
    public void testToXContent() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                    expandHidden = !expandHidden;
                    mutated = true;
            boolean ignoreThrottled = opts.ignoreThrottled();
        final boolean ignoreAliases = randomBoolean();
                opts.ignoreThrottled()
        assertEquals(defaultOptions.expandWildcardsHidden(), indicesOptions.expandWildcardsHidden());
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
        assertFalse(fromXContentOptions.expandWildcardsOpen());
 * not use this file except in compliance with the License.
        assertEquals(defaultOptions.ignoreAliases(), indicesOptions.ignoreAliases());
 * this work for additional information regarding copyright
        final boolean ignoreThrottled = randomBoolean();
            builder.field("expand_wildcards", "none");
        boolean closed = wildcardStates != null ? wildcardStates.contains("closed") : defaults.expandWildcardsClosed();
        final boolean allowNoIndices = randomBoolean();
        );
        assertEquals(ignoreAliases, indicesOptions.ignoreAliases());
        assertTrue(fromXContentOptions.expandWildcardsHidden());
            randomBoolean(),
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.IndicesOptions.Option;
            options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),
        assertThat(indicesOptions.ignoreUnavailable(), equalTo(ignoreUnavailable));
            builder.endObject();
    private BytesReference toXContentBytes(IndicesOptions indicesOptions, XContentType type) throws IOException {
            ignoreThrottled
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
            }
}
        String ignoreUnavailableString = Boolean.toString(ignoreUnavailable);
        assertEquals(ignoreThrottled == null ? defaults.ignoreThrottled() : ignoreThrottled, fromMap.ignoreThrottled());
            expandToClosedIndices,
            return BytesReference.bytes(builder);
            ignoreUnavailable,
        assertEquals(allowNoIndices, updatedOptions.allowNoIndices());
            randomBoolean(),
            xContentBytes = BytesReference.bytes(builder);
            randomBoolean(),
            );
        assertEquals(allowNoIndices, fromXContentOptions.allowNoIndices());
/*
        );
        assertEquals(ignoreUnavailable == null ? defaults.ignoreUnavailable() : ignoreUnavailable, fromMap.ignoreUnavailable());
        assertEquals(indicesOptions.expandWildcardsHidden(), fromXContentOptions.expandWildcardsHidden());
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(indicesOptions, opts -> {
            assertThat(indicesOptions2.allowAliasesToMultipleIndices(), equalTo(indicesOptions.allowAliasesToMultipleIndices()));
            } else {
        assertEquals(expandWildcardsHidden, updatedOptions.expandWildcardsHidden());
        final boolean expandToClosedIndices = randomBoolean();
            randomBoolean(),
            expandToHiddenIndices,
            ignoreUnavailable,
import org.opensearch.common.io.stream.BytesStreamOutput;
        IndicesOptions fromXContentOptions;
            fromXContentOptions = IndicesOptions.fromXContent(parser);
        final boolean allowNoIndices = randomBoolean();
                opts.expandWildcardsHidden(),
            fromXContentOptions = IndicesOptions.fromXContent(parser);
                    forbidClosed = !forbidClosed;
    }
        }
                    mutated = true;
 * specific language governing permissions and limitations
        IndicesOptions updatedOptions = IndicesOptions.fromParameters(
        final boolean expandWildcardsHidden = randomBoolean();
        assertEquals(indicesOptions.allowNoIndices(), fromXContentOptions.allowNoIndices());
        Collection<Option> options = randomSubsetOf(Arrays.asList(Option.values()));
        );
        assertEquals(indicesOptions.expandWildcardsClosed(), fromXContentOptions.expandWildcardsClosed());
        assertEquals(defaultOptions.allowAliasesToMultipleIndices(), updatedOptions.allowAliasesToMultipleIndices());
                randomBoolean(),
            randomBoolean()
                randomBoolean(),
        boolean expandToOpenIndices = randomBoolean();
            if (expandWildcardsHidden) {
        final boolean expandWildcardsClosed = randomBoolean();
        );
    public void testFromOptionsWithDefaultOptions() {
        if (ignoreThrottled != null) {
        IndicesOptions defaultOptions = IndicesOptions.fromOptions(
        }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
            randomBoolean(),
        int iterations = randomIntBetween(5, 20);
        assertEquals(expandWildcardsOpen, updatedOptions.expandWildcardsOpen());
                allowNoIndices,
        XContentType type = randomFrom(XContentType.values());
        }
 * software distributed under the License is distributed on an
        Boolean allowNoIndices = randomBoolean() ? null : randomBoolean();
        assertEquals(allowNoIndices, indicesOptions.allowNoIndices());
        boolean open = wildcardStates.contains(WildcardStates.OPEN);
        assertEquals(allowNoIndices == null ? defaults.allowNoIndices() : allowNoIndices, fromMap.allowNoIndices());
import org.opensearch.test.EqualsHashCodeTestUtils;
        assertThat(indicesOptions.allowNoIndices(), equalTo(allowNoIndices));
            randomBoolean(),
        assertEquals(defaultOptions.forbidClosedIndices(), indicesOptions.forbidClosedIndices());
            streamInput.setVersion(version);
        assertEquals(expandToClosedIndices, indicesOptions.expandWildcardsClosed());
        for (int i = 0; i < iterations; i++) {
                }
            map = parser.mapOrdered();
            assertTrue(((List<?>) map.get("expand_wildcards")).contains("closed"));
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.EnumSet;
                values.add("hidden");
            allowNoIndicesString,
            expandToOpenIndices,
import static org.opensearch.test.VersionUtils.randomVersionBetween;
        }
        assertEquals(wildcardStates.contains(WildcardStates.HIDDEN), ((List<?>) map.get("expand_wildcards")).contains("hidden"));
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
                    mutated = true;
            allowAliasesToMultipleIndices,
        boolean expandToClosedIndices = randomBoolean();
            wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)
    }
            List<String> values = new ArrayList<>();
            defaultOptions
        Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
        final boolean expandToHiddenIndices = randomBoolean();
            expandToClosedIndices,
        }
            );
            options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),
            assertThat(indicesOptions2.forbidClosedIndices(), equalTo(indicesOptions.forbidClosedIndices()));
            defaultOptions
    public void testFromXContentWithWildcardSpecialValues() throws IOException {
            }
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
            randomBoolean(),
                opts.expandWildcardsClosed(),
            assertThat(indicesOptions2.expandWildcardsHidden(), equalTo(indicesOptions.expandWildcardsHidden()));
                }
    public void testFromOptions() {
            );
                randomBoolean(),
                    mutated = true;
        assertEquals(hidden, fromMap.expandWildcardsHidden());
            ignoreAliases,
            assertThat(indicesOptions2.expandWildcardsClosed(), equalTo(indicesOptions.expandWildcardsClosed()));
            randomBoolean(),
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(open, fromMap.expandWildcardsOpen());
        BytesReference xContentBytes;
        final String expandWildcardsString;
            builder.endObject();
            builder.field("allow_no_indices", allowNoIndices);
 *
                    ignoreThrottled = !ignoreThrottled;
        }
                if (randomBoolean()) {
        );
        assertEquals(ignoreUnavailable, fromXContentOptions.ignoreUnavailable());
        assertTrue(fromXContentOptions.expandWildcardsOpen());
    }
            randomBoolean(),
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
import java.util.ArrayList;
        );
            builder.field("expand_wildcards", "all");
import org.opensearch.core.xcontent.XContentParser;
 *
            StreamInput streamInput = output.bytes().streamInput();
            ignoreThrottled,
            builder.field("ignore_unavailable", ignoreUnavailable);
            randomBoolean(),
import org.opensearch.core.xcontent.MediaTypeRegistry;
        boolean open = wildcardStates != null ? wildcardStates.contains("open") : defaults.expandWildcardsOpen();
                expandWildcardsString = "open,closed,hidden";
                randomBoolean(),
        final boolean ignoreUnavailable = randomBoolean();
 * compatible open source license.
 */
        assertThat(indicesOptions.expandWildcardsHidden(), equalTo(expandToHiddenIndices));
import java.util.Collections;
        boolean ignoreUnavailable = randomBoolean();
        }
        boolean allowNoIndices = randomBoolean();
            xContentBytes = BytesReference.bytes(builder);
        final boolean expandWildcardsOpen = randomBoolean();
            randomBoolean(),
import org.opensearch.test.OpenSearchTestCase;
            output.setVersion(version);
        }
    }
        boolean closed = wildcardStates.contains(WildcardStates.CLOSED);
        boolean allowNoIndices = randomBoolean();
            builder.startObject();
 */
        Boolean ignoreThrottled = randomBoolean() ? null : randomBoolean();
                randomBoolean(),
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
                if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
package org.opensearch.action.support;
        boolean ignoreThrottled = randomBoolean();
        } else {
            randomBoolean()
        BytesReference xContentBytes = toXContentBytes(indicesOptions, type);
            randomBoolean(),
                    allowAliasesToMulti = !allowAliasesToMulti;
                if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See
        if (wildcardStates != null) {
            randomBoolean(),
            BytesStreamOutput output = new BytesStreamOutput();
            builder.startObject();
            }
                    mutated = true;
            boolean ignoreUnavailable = opts.ignoreUnavailable();
            randomBoolean(),
            Version version = randomVersionBetween(random(), Version.V_2_0_0, null);
            assertTrue(((List<?>) map.get("expand_wildcards")).contains("open"));
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor
 * GitHub history for details.
import java.util.Collection;
import org.opensearch.action.support.IndicesOptions.WildcardStates;
import org.opensearch.core.common.io.stream.StreamInput;
                    expandClosed = !expandClosed;
                expandHidden,
            randomBoolean(),
            builder.field("ignore_unavailable", ignoreUnavailable);
import java.util.List;
            randomBoolean(),
        assertThat(indicesOptions.expandWildcardsClosed(), equalTo(expandToClosedIndices));
                opts.ignoreAliases(),
    }
import org.opensearch.core.common.bytes.BytesReference;
            boolean ignoreAliases = opts.ignoreAliases();
            IndicesOptions indicesOptions2 = IndicesOptions.readIndicesOptions(streamInput);
                expandOpen,
        assertEquals(map.get("ignore_unavailable"), options.contains(Option.IGNORE_UNAVAILABLE));
            boolean expandOpen = opts.expandWildcardsOpen();
        String allowNoIndicesString = Boolean.toString(allowNoIndices);
        IndicesOptions defaults = IndicesOptions.strictExpandOpen();
/*
        assertEquals(defaultOptions.forbidClosedIndices(), updatedOptions.forbidClosedIndices());
        BytesReference xContentBytes = toXContentBytes(indicesOptions, type);
    public void testFromXContent() throws IOException {
        assertEquals(defaultOptions.allowAliasesToMultipleIndices(), indicesOptions.allowAliasesToMultipleIndices());
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
        });
            boolean expandClosed = opts.expandWildcardsClosed();
            allowNoIndices,
        if (expandWildcardsOpen && expandWildcardsClosed && expandWildcardsHidden) {
        assertEquals(ignoreUnavailable, updatedOptions.ignoreUnavailable());
import java.util.Arrays;
            expandWildcardsString,
        assertThat(indicesOptions.allowAliasesToMultipleIndices(), equalTo(allowAliasesToMultipleIndices));
            indicesOptions.writeIndicesOptions(output);
            settings.put("ignore_throttled", ignoreThrottled);
 * under the License.
            boolean allowAliasesToMulti = opts.allowAliasesToMultipleIndices();
        assertTrue(fromXContentOptions.expandWildcardsClosed());
                opts.forbidClosedIndices(),
                }
        boolean ignoreUnavailable = randomBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        XContentType type = randomFrom(XContentType.values());
        }
        assertEquals(indicesOptions.expandWildcardsOpen(), fromXContentOptions.expandWildcardsOpen());
        }
            assertThat(indicesOptions2.expandWildcardsOpen(), equalTo(indicesOptions.expandWildcardsOpen()));
    }
/*
            if (values.isEmpty() && randomBoolean()) {
                }
        }
            randomBoolean()
        assertFalse(fromXContentOptions.expandWildcardsClosed());
        } else {
            boolean allowNoIndices = opts.allowNoIndices();
        XContentType type = randomFrom(XContentType.values());
    }
        if (closed) {
import java.io.IOException;
        IndicesOptions fromXContentOptions;
                    mutated = true;
            if (expandWildcardsClosed) {
    public void testEqualityAndHashCode() {
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
                }
                randomBoolean(),
        assertEquals(ignoreUnavailable, fromXContentOptions.ignoreUnavailable());
        final boolean expandToOpenIndices = randomBoolean();
                ignoreThrottled
            while (mutated == false) {
                randomBoolean(),
        IndicesOptions indicesOptions = new IndicesOptions(
            builder.startObject();
                opts.ignoreUnavailable(),
        assertThat(indicesOptions.forbidClosedIndices(), equalTo(forbidClosedIndices));
        );
    public void testSerialization() throws Exception {
            }
 * the Apache License, Version 2.0 (the "License"); you may
        final boolean allowAliasesToMultipleIndices = randomBoolean();
        Map<String, Object> settings = new HashMap<>();
            settings.put("expand_wildcards", wildcardStates);
        }, opts -> {
            assertThat(indicesOptions2.allowNoIndices(), equalTo(indicesOptions.allowNoIndices()));
            randomBoolean(),
                if (randomBoolean()) {
            IndicesOptions indicesOptions = IndicesOptions.fromOptions(
                }
                }
        boolean hidden = wildcardStates != null ? wildcardStates.contains("hidden") : defaults.expandWildcardsHidden();
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
            settings.put("ignore_unavailable", ignoreUnavailable);
            randomBoolean(),
                values.add("none");
                randomBoolean()
            forbidClosedIndices,
        } else {
            randomBoolean(),
            boolean forbidClosed = opts.forbidClosedIndices();
                allowAliasesToMulti,
                    ignoreUnavailable = !ignoreUnavailable;
        assertFalse(fromXContentOptions.expandWildcardsHidden());
                randomBoolean(),
                expandWildcardsString = "all";
        assertEquals(indicesOptions.ignoreThrottled(), fromXContentOptions.ignoreThrottled());
import org.opensearch.core.xcontent.ToXContent.MapParams;
 */
    }
                if (randomBoolean()) {
                opts.allowAliasesToMultipleIndices(),
                    mutated = true;
            }
        assertEquals(defaultOptions.ignoreAliases(), updatedOptions.ignoreAliases());
                    ignoreAliases = !ignoreAliases;
 * Unless required by applicable law or agreed to in writing,
        assertEquals(closed, fromMap.expandWildcardsClosed());
        final boolean ignoreUnavailable = randomBoolean();
            builder.endObject();
            indicesOptions.toXContent(builder, new MapParams(Collections.emptyMap()));
                if (randomBoolean()) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            randomBoolean(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(map.get("allow_no_indices"), options.contains(Option.ALLOW_NO_INDICES));
                }
        assertThat(indicesOptions.allowAliasesToMultipleIndices(), equalTo(allowAliasesToMultipleIndices));
                forbidClosed,
            return IndicesOptions.fromOptions(
                if (randomBoolean()) {
        assertEquals(expandWildcardsClosed, updatedOptions.expandWildcardsClosed());
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
                opts.allowNoIndices(),
        assertEquals(ignoreThrottled, indicesOptions.ignoreThrottled());
            boolean mutated = false;
            expandWildcardsString = String.join(",", values);
            wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)
            builder.field("allow_no_indices", allowNoIndices);
                if (randomBoolean()) {
        assertEquals(indicesOptions.ignoreUnavailable(), fromXContentOptions.ignoreUnavailable());
            assertEquals(indicesOptions2.ignoreAliases(), indicesOptions.ignoreAliases());
                if (randomBoolean()) {
        );
                ignoreAliases,
            expandToOpenIndices,
        }
                    mutated = true;
