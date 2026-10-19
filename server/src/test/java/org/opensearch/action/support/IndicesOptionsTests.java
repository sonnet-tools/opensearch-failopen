        Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
        XContentType type = randomFrom(XContentType.values());
            boolean forbidClosed = opts.forbidClosedIndices();
            expandToClosedIndices,  
            randomBoolean(),
            randomBoolean(),
        Map<String, Object> settings = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
            } else {
        boolean ignoreThrottled = randomBoolean();
    public void testFromParameters() {
        if (ignoreUnavailable != null) {
        Boolean ignoreThrottled = randomBoolean() ? null : randomBoolean();
/*  
                if (randomBoolean()) {
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
            if (values.isEmpty() && randomBoolean()) {  
            }  
        final boolean allowNoIndices = randomBoolean();
}
 * GitHub history for details.
            List<String> values = new ArrayList<>();
        );  
                randomBoolean(),  
        IndicesOptions indicesOptions = new IndicesOptions(
        boolean expandToOpenIndices = randomBoolean();
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {  
            options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),  
            boolean expandHidden = opts.expandWildcardsHidden();  
        }
        assertEquals(hidden, fromMap.expandWildcardsHidden());
    }
    public void testFromOptions() {  
        assertFalse(fromXContentOptions.expandWildcardsClosed());
            randomBoolean()  
 *  
        final boolean ignoreThrottled = randomBoolean();  
        assertEquals(indicesOptions.expandWildcardsHidden(), fromXContentOptions.expandWildcardsHidden());  
        if (wildcardStates != null) {  
        boolean hidden = wildcardStates != null ? wildcardStates.contains("hidden") : defaults.expandWildcardsHidden();
import org.opensearch.core.xcontent.XContentParser;  
 */  
        assertFalse(fromXContentOptions.expandWildcardsHidden());
 * SPDX-License-Identifier: Apache-2.0
        IndicesOptions fromXContentOptions;  
    }  
        boolean expandToClosedIndices = randomBoolean();  
            map = parser.mapOrdered();
        boolean closed = wildcardStates.contains(WildcardStates.CLOSED);
        IndicesOptions indicesOptions = new IndicesOptions(
        assertEquals(map.get("ignore_throttled"), options.contains(Option.IGNORE_THROTTLED));
        final boolean ignoreUnavailable = randomBoolean();  
        assertThat(indicesOptions.forbidClosedIndices(), equalTo(forbidClosedIndices));  
            ignoreThrottled
    public void testFromXContentWithWildcardSpecialValues() throws IOException {
        }  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
        assertThat(indicesOptions.expandWildcardsClosed(), equalTo(expandToClosedIndices));
                if (randomBoolean()) {
import java.util.ArrayList;
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
        assertEquals(ignoreUnavailable, fromXContentOptions.ignoreUnavailable());
        assertEquals(defaultOptions.allowAliasesToMultipleIndices(), updatedOptions.allowAliasesToMultipleIndices());  
            xContentBytes = BytesReference.bytes(builder);
        assertEquals(defaultOptions.ignoreAliases(), indicesOptions.ignoreAliases());
        assertEquals(map.get("allow_no_indices"), options.contains(Option.ALLOW_NO_INDICES));  
    public void testSerialization() throws Exception {
            randomBoolean(),
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
            streamInput.setVersion(version);
            return IndicesOptions.fromOptions(
                opts.expandWildcardsOpen(),
        boolean ignoreUnavailable = randomBoolean();
                expandClosed,
                if (randomBoolean()) {  
            assertThat(indicesOptions2.ignoreUnavailable(), equalTo(indicesOptions.ignoreUnavailable()));
        XContentType type = randomFrom(XContentType.values());
                expandWildcardsString = "all";
            randomBoolean(),  
    private BytesReference toXContentBytes(IndicesOptions indicesOptions, XContentType type) throws IOException {  
            ignoreAliases,
import org.opensearch.core.xcontent.XContentBuilder;
                opts.ignoreAliases(),  
                randomBoolean(),  
                    mutated = true;
            randomBoolean(),  
                    forbidClosed = !forbidClosed;
        String ignoreUnavailableString = Boolean.toString(ignoreUnavailable);  
        BytesReference xContentBytes = toXContentBytes(indicesOptions, type);
 * You may obtain a copy of the License at  
        assertEquals(allowNoIndices, fromXContentOptions.allowNoIndices());  
    }
            fromXContentOptions = IndicesOptions.fromXContent(parser);  
import static org.hamcrest.CoreMatchers.equalTo;  
        );
                    mutated = true;  
        boolean open = wildcardStates != null ? wildcardStates.contains("open") : defaults.expandWildcardsOpen();  
        assertEquals(indicesOptions.ignoreUnavailable(), fromXContentOptions.ignoreUnavailable());
 */  
            builder.field("ignore_unavailable", ignoreUnavailable);
            builder.startObject();
            );
                    mutated = true;  
        }  
import java.util.Collection;
import static org.opensearch.test.VersionUtils.randomVersionBetween;
        boolean allowNoIndices = randomBoolean();
import java.util.Arrays;  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
        }
                randomBoolean(),
import org.opensearch.Version;
            randomBoolean(),  
        Collection<WildcardStates> wildcardStates = randomSubsetOf(Arrays.asList(WildcardStates.values()));
            }
            randomBoolean(),
    }
        );
        assertEquals(allowNoIndices, indicesOptions.allowNoIndices());
 * license agreements. See the NOTICE file distributed with
                if (randomBoolean()) {
        assertFalse(fromXContentOptions.expandWildcardsOpen());  
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(  
        boolean closed = wildcardStates != null ? wildcardStates.contains("closed") : defaults.expandWildcardsClosed();
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
            randomBoolean()
                    mutated = true;
        assertEquals(indicesOptions.expandWildcardsClosed(), fromXContentOptions.expandWildcardsClosed());
            builder.field("expand_wildcards", "all");  
            if (expandWildcardsOpen) {  
        final boolean ignoreUnavailable = randomBoolean();
            assertEquals(indicesOptions2.ignoreAliases(), indicesOptions.ignoreAliases());
            assertFalse(((List<?>) map.get("expand_wildcards")).contains("open"));
        assertEquals(allowNoIndices, updatedOptions.allowNoIndices());
        Map<String, Object> map;
            settings.put("ignore_throttled", ignoreThrottled);
            settings.put("ignore_unavailable", ignoreUnavailable);
                opts.forbidClosedIndices(),
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
public class IndicesOptionsTests extends OpenSearchTestCase {
            StreamInput streamInput = output.bytes().streamInput();  
        assertEquals(expandWildcardsClosed, updatedOptions.expandWildcardsClosed());
                values.add("closed");
    }
            indicesOptions.writeIndicesOptions(output);
            if (randomBoolean()) {
        assertEquals(allowNoIndices, fromXContentOptions.allowNoIndices());  
        assertEquals(expandWildcardsHidden, updatedOptions.expandWildcardsHidden());  
        if (open) {
 * software distributed under the License is distributed on an
import java.util.HashMap;
    }  
        assertEquals(expandToClosedIndices, indicesOptions.expandWildcardsClosed());
        assertEquals(ignoreUnavailable, fromXContentOptions.ignoreUnavailable());
        assertThat(indicesOptions.ignoreUnavailable(), equalTo(ignoreUnavailable));
    public void testFromOptionsWithDefaultOptions() {
                }  
            randomBoolean(),  
            builder.field("ignore_unavailable", ignoreUnavailable);
            builder.endObject();  
        assertEquals(map.get("ignore_unavailable"), options.contains(Option.IGNORE_UNAVAILABLE));
            expandToOpenIndices,
            randomBoolean(),
            expandToHiddenIndices,
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.util.Map;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                }
            randomBoolean(),  
                values.add("none");
        }, opts -> {  
        IndicesOptions updatedOptions = IndicesOptions.fromParameters(
    public void testToXContent() throws IOException {  
            randomBoolean(),
        assertThat(indicesOptions.allowAliasesToMultipleIndices(), equalTo(allowAliasesToMultipleIndices));
 * this file be licensed under the Apache-2.0 license or a
                values.add("open");
            builder.startObject();
        if (allowNoIndices != null) {
    public void testFromMap() {  
                if (randomBoolean()) {  
                    expandHidden = !expandHidden;
                    mutated = true;
            expandWildcardsString,  
            options.isEmpty() ? Option.NONE : EnumSet.copyOf(options),
        assertEquals(ignoreUnavailable, updatedOptions.ignoreUnavailable());
                }  
        } else {
        );
        } else {
 *
                allowAliasesToMulti,
        assertEquals(expandToOpenIndices, indicesOptions.expandWildcardsOpen());  
        assertEquals(ignoreAliases, indicesOptions.ignoreAliases());
        assertThat(indicesOptions.expandWildcardsOpen(), equalTo(expandToOpenIndices));
    public void testFromXContent() throws IOException {
        if (expandWildcardsOpen && expandWildcardsClosed && expandWildcardsHidden) {
                }
                opts.allowAliasesToMultipleIndices(),
                opts.allowNoIndices(),  
        assertTrue(fromXContentOptions.expandWildcardsClosed());
        } else {
                    expandOpen = !expandOpen;  
        assertEquals(ignoreThrottled == null ? defaults.ignoreThrottled() : ignoreThrottled, fromMap.ignoreThrottled());  
            expandToClosedIndices,  
        final boolean allowAliasesToMultipleIndices = randomBoolean();  
    }
        boolean open = wildcardStates.contains(WildcardStates.OPEN);
        if (closed) {
            assertTrue(((List<?>) map.get("expand_wildcards")).contains("closed"));  
        assertEquals(indicesOptions.expandWildcardsOpen(), fromXContentOptions.expandWildcardsOpen());
 * compatible open source license.
            ignoreThrottled,  
            wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)  
                opts.ignoreUnavailable(),
            randomBoolean()
        assertEquals(closed, fromMap.expandWildcardsClosed());  
                    mutated = true;
        final boolean expandWildcardsOpen = randomBoolean();  
            boolean ignoreThrottled = opts.ignoreThrottled();
            ignoreUnavailable,  
            allowNoIndicesString,
            randomBoolean(),
    }  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(type)) {
                if (randomBoolean()) {
        XContentType type = randomFrom(XContentType.values());  
        assertThat(indicesOptions.expandWildcardsHidden(), equalTo(expandToHiddenIndices));  
                ignoreUnavailable,
        assertTrue(fromXContentOptions.expandWildcardsOpen());  
            boolean allowNoIndices = opts.allowNoIndices();  
        Boolean ignoreUnavailable = randomBoolean() ? null : randomBoolean();  
        final boolean expandToHiddenIndices = randomBoolean();
        String allowNoIndicesString = Boolean.toString(allowNoIndices);  
        final boolean forbidClosedIndices = randomBoolean();
            }  
            assertThat(indicesOptions2.forbidClosedIndices(), equalTo(indicesOptions.forbidClosedIndices()));  
import org.opensearch.core.common.bytes.BytesReference;  
            builder.field("allow_no_indices", allowNoIndices);  
        assertEquals(ignoreUnavailable == null ? defaults.ignoreUnavailable() : ignoreUnavailable, fromMap.ignoreUnavailable());
            assertFalse(((List<?>) map.get("expand_wildcards")).contains("closed"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(indicesOptions.allowNoIndices(), fromXContentOptions.allowNoIndices());  
        assertEquals(defaultOptions.forbidClosedIndices(), updatedOptions.forbidClosedIndices());
                randomBoolean(),
        }
            boolean mutated = false;
            return IndicesOptions.fromOptions(
                    ignoreUnavailable = !ignoreUnavailable;
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(indicesOptions, opts -> {  
            allowNoIndices,
            builder.field("expand_wildcards", "none");
            }
            );  
            defaultOptions
            assertTrue(((List<?>) map.get("expand_wildcards")).contains("open"));  
    }
            boolean expandOpen = opts.expandWildcardsOpen();
                randomBoolean(),
            settings.put("allow_no_indices", allowNoIndices);  
import org.opensearch.action.support.IndicesOptions.WildcardStates;  
                    mutated = true;
            boolean ignoreUnavailable = opts.ignoreUnavailable();
        Collection<Option> options = randomSubsetOf(Arrays.asList(Option.values()));  
        IndicesOptions defaultOptions = IndicesOptions.fromOptions(
        BytesReference xContentBytes = toXContentBytes(indicesOptions, type);
                randomBoolean(),
        assertEquals(ignoreThrottled, indicesOptions.ignoreThrottled());
                    mutated = true;  
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
        final String expandWildcardsString;  
import org.opensearch.core.xcontent.ToXContent.MapParams;
        boolean allowNoIndices = randomBoolean();
        assertThat(indicesOptions.allowAliasesToMultipleIndices(), equalTo(allowAliasesToMultipleIndices));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(defaultOptions.expandWildcardsHidden(), indicesOptions.expandWildcardsHidden());
                randomBoolean()
        boolean ignoreUnavailable = randomBoolean();  
            defaultOptions
        }
            Version version = randomVersionBetween(random(), Version.V_2_0_0, null);
        }
            if (expandWildcardsHidden) {  
        BytesReference xContentBytes;  
import java.util.Collections;
            randomBoolean(),  
            ignoreUnavailable,  
            IndicesOptions indicesOptions2 = IndicesOptions.readIndicesOptions(streamInput);
                    ignoreAliases = !ignoreAliases;
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (randomBoolean()) {
        assertEquals(expandWildcardsOpen, updatedOptions.expandWildcardsOpen());
            randomBoolean(),
            );
        for (int i = 0; i < iterations; i++) {  
                expandWildcardsString = "open,closed,hidden";  
                ignoreThrottled
        }  
        assertEquals(open, fromMap.expandWildcardsOpen());
                if (randomBoolean()) {
                }
            randomBoolean(),  
            output.setVersion(version);  
                if (randomBoolean()) {  
            BytesStreamOutput output = new BytesStreamOutput();
 *
            expandWildcardsString = String.join(",", values);  
            fromXContentOptions = IndicesOptions.fromXContent(parser);
        Boolean allowNoIndices = randomBoolean() ? null : randomBoolean();
 * not use this file except in compliance with the License.
            builder.startObject();  
        assertTrue(fromXContentOptions.expandWildcardsHidden());
 * this work for additional information regarding copyright
/*
                values.add("hidden");
                    ignoreThrottled = !ignoreThrottled;  
        );
        assertEquals(ignoreUnavailable, indicesOptions.ignoreUnavailable());
                allowNoIndices,  
            xContentBytes = BytesReference.bytes(builder);
        );
        final boolean expandWildcardsClosed = randomBoolean();
            boolean allowAliasesToMulti = opts.allowAliasesToMultipleIndices();
            builder.field("allow_no_indices", allowNoIndices);
        assertEquals(defaultOptions.ignoreAliases(), updatedOptions.ignoreAliases());
                    allowNoIndices = !allowNoIndices;
        try (XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY, null, xContentBytes.streamInput())) {
            allowNoIndices,
            }
import org.opensearch.action.support.IndicesOptions.Option;
            return BytesReference.bytes(builder);
 * under the License.  
        final boolean expandToClosedIndices = randomBoolean();
            randomBoolean(),
        }  
            boolean ignoreAliases = opts.ignoreAliases();  
        }  
            randomBoolean(),
        final boolean expandToOpenIndices = randomBoolean();  
        Collection<Option> options = randomSubsetOf(Arrays.asList(Option.values()));
        }  
            assertThat(indicesOptions2.expandWildcardsHidden(), equalTo(indicesOptions.expandWildcardsHidden()));
        assertEquals(indicesOptions.ignoreThrottled(), fromXContentOptions.ignoreThrottled());
                    expandClosed = !expandClosed;
    public void testEqualityAndHashCode() {
            assertThat(indicesOptions2.expandWildcardsOpen(), equalTo(indicesOptions.expandWildcardsOpen()));  
        }
        assertEquals(defaultOptions.allowAliasesToMultipleIndices(), indicesOptions.allowAliasesToMultipleIndices());  
            if (expandWildcardsClosed) {  
                opts.expandWildcardsHidden(),  
            randomBoolean(),
import org.opensearch.core.common.io.stream.StreamInput;
        );  
        }
                expandOpen,
 * the Apache License, Version 2.0 (the "License"); you may
            settings.put("expand_wildcards", wildcardStates);
        IndicesOptions fromMap = IndicesOptions.fromMap(settings, defaults);
 * specific language governing permissions and limitations
        assertEquals(allowNoIndices == null ? defaults.allowNoIndices() : allowNoIndices, fromMap.allowNoIndices());
            boolean expandClosed = opts.expandWildcardsClosed();
 * KIND, either express or implied.  See the License for the
        }  
            assertThat(indicesOptions2.allowNoIndices(), equalTo(indicesOptions.allowNoIndices()));
import java.util.EnumSet;  
 */
        final boolean allowNoIndices = randomBoolean();
            builder.endObject();
            builder.endObject();
        final boolean ignoreAliases = randomBoolean();
        IndicesOptions fromXContentOptions;
import java.util.List;
    }
import org.opensearch.common.xcontent.XContentType;
                }
            randomBoolean(),
            indicesOptions.toXContent(builder, new MapParams(Collections.emptyMap()));  
        });  
            fromXContentOptions = IndicesOptions.fromXContent(parser);  
import org.opensearch.test.EqualsHashCodeTestUtils;
            while (mutated == false) {
            assertThat(indicesOptions2.allowAliasesToMultipleIndices(), equalTo(indicesOptions.allowAliasesToMultipleIndices()));
            randomBoolean(),
            forbidClosedIndices,  
        assertThat(indicesOptions.allowNoIndices(), equalTo(allowNoIndices));  
                    allowAliasesToMulti = !allowAliasesToMulti;  
                forbidClosed,
            IndicesOptions indicesOptions = IndicesOptions.fromOptions(
        Collection<String> wildcardStates = randomBoolean() ? null : randomSubsetOf(Arrays.asList("open", "closed", "hidden"));
            ignoreUnavailableString,
            }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            allowAliasesToMultipleIndices,
/*  
            wildcardStates.isEmpty() ? WildcardStates.NONE : EnumSet.copyOf(wildcardStates)
                opts.expandWildcardsClosed(),
        assertEquals(wildcardStates.contains(WildcardStates.HIDDEN), ((List<?>) map.get("expand_wildcards")).contains("hidden"));
                }  
        assertEquals(defaultOptions.forbidClosedIndices(), indicesOptions.forbidClosedIndices());
            expandToOpenIndices,
                ignoreAliases,  
        }
        if (ignoreThrottled != null) {  
        );  
            randomBoolean(),
import org.opensearch.test.OpenSearchTestCase;
                randomBoolean(),  
            randomBoolean(),
        int iterations = randomIntBetween(5, 20);
        final boolean expandWildcardsHidden = randomBoolean();
                opts.ignoreThrottled()
        IndicesOptions defaultOptions = IndicesOptions.fromOptions(
            assertThat(indicesOptions2.expandWildcardsClosed(), equalTo(indicesOptions.expandWildcardsClosed()));
            randomBoolean(),
 * Licensed to Elasticsearch under one or more contributor  
                expandHidden,  
            randomBoolean(),  
                    mutated = true;
                randomBoolean(),
package org.opensearch.action.support;
        IndicesOptions defaults = IndicesOptions.strictExpandOpen();
