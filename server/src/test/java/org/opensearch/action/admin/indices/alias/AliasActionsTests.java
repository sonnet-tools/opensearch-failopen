            }
        }
        try (XContentParser parser = createParser(b)) {
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases("test", ""));
            assertEquals(Objects.toString(indexRouting, null), action.indexRouting());
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
            assertEquals(isHidden, action.isHidden());
        assertNull(removeAliasAction.mustExist());
                }
            b.startObject("add");
                } else {
        e = expectThrows(IllegalArgumentException.class, () -> action.searchRouting("test"));
/*
        b.endObject();
 * ownership. Elasticsearch licenses this file to you under
            {
                AliasActions read = new AliasActions(in);
                if (indexRouting != null && false == indexRouting.equals(searchRouting)) {
            }
                assertThat(action.mustExist(), equalTo(true));
        removeAliasAction.mustExist(mustExist);
        AliasActions.Type type = randomValueOtherThan(AliasActions.Type.REMOVE_INDEX, () -> randomFrom(AliasActions.Type.values()));
            Exception e = expectThrows(XContentParseException.class, () -> AliasActions.PARSER.apply(parser, null));
            }
 * this work for additional information regarding copyright
        }
 * under the License.
            b.startObject("add");
        String[] aliases = generateRandomStringArray(10, 5, false, false);
            e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).index(randomAlphaOfLength(5)).validate());
        e = expectThrows(IllegalArgumentException.class, () -> action.indexRouting("test"));
            b.endObject();
        }
            assertThat(parsedAction, equalTo(action));
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
                if (mustExist) {
        }
        assertEquals("[indices] can't be empty", e.getMessage());
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomMap;
        } else {
import static org.hamcrest.Matchers.arrayWithSize;
 */
            b.startObject(randomFrom("add", "remove"));
                    b.array("indices", indices);
        assertEquals("[alias] can't be empty string", e.getMessage());
        try (XContentParser parser = createParser(b)) {
                    b.field("search_routing", searchRouting);
        assertEquals("[filter] is unsupported for [" + action.actionType() + "]", e.getMessage());
            assertEquals(AliasActions.Type.REMOVE_INDEX, action.actionType());
            assertThat(action.aliases(), arrayWithSize(0));
        e = expectThrows(
        }
 * Licensed to Elasticsearch under one or more contributor
        Object indexRouting = randomRouting();
                assertEquals(MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).map(filter).toString(), action.filter());
            AliasActions action = AliasActions.PARSER.apply(parser, null);
        assertEquals(mustExist, removeAliasAction.mustExist());
    public void testValidate() {
            assertThat(action.aliases(), equalTo(aliases));
                    b.field("index", indices[0]);
    public void testMustExistOption() {
                b.array("indices", generateRandomStringArray(10, 5, false, false));
        boolean isHidden = randomBoolean();
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.mustExist(mustExist));
        assertEquals("[aliases] can't contain empty string", e.getMessage());
        Object searchRouting = randomRouting();
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices((String[]) null)
        assertEquals("[aliases] can't be empty", e.getMessage());
        }
                action.aliases(generateRandomStringArray(5, 5, false, false));
                } else {
        }
            {
        final boolean mustExist = randomBoolean();
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals("[indices] can't contain empty string", e.getMessage());
        AliasActions.Type type = randomFrom(AliasActions.Type.values());
import java.util.Map;
        e = expectThrows(
                    b.field("must_exist", true);
                b.array("aliases", generateRandomStringArray(10, 5, false, false));
                    b.field("alias", aliases[0]);
        String index = randomAlphaOfLength(5);
                }
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomAliasAction;
        assertEquals("[indices] can't contain empty string", e.getMessage());
            }
            if (filter == null || filter.isEmpty()) {
            action.index(randomAlphaOfLength(5));
import org.opensearch.core.xcontent.XContentParser;
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases((String[]) null));
            }
        {
        b.endObject();
        );
        {
import org.opensearch.core.common.io.stream.StreamInput;
        {
 */
                b.field("is_hidden", isHidden);
    public void testParseAdd() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            assertThat(e.getCause().getCause().getMessage(), containsString("Only one of [index] and [indices] is supported"));
        b.endObject();
                assertNull(action.filter());
        }
            assertThat(action.indices(), equalTo(indices));
            IllegalArgumentException.class,
            {
                assertEquals(action, read);
 *
import static org.hamcrest.CoreMatchers.equalTo;
        b = shuffleXContent(b);
        if (randomBoolean()) {
            } else {
                b.field("index", randomAlphaOfLength(5));
                    }
                    } else {
        }
        Object searchRouting = randomBoolean() ? randomRouting() : null;
            }
        }
    }
        {
                if (randomBoolean()) {
            }
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
        b.endObject();
                    action.indexRouting(randomAlphaOfLength(5));
        }
        assertEquals("[routing] is unsupported for [" + action.actionType() + "]", e.getMessage());
            assertEquals("One of [alias] or [aliases] is required", e.getMessage());
        try (XContentParser parser = createParser(b)) {
    public void testFromToXContent() throws IOException {
            assertEquals(Objects.toString(searchRouting, null), action.searchRouting());
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
            }
import org.opensearch.core.xcontent.XContentBuilder;
        try (XContentParser parser = createParser(b)) {
                    b.field("filter", filter);
        String[] aliases = generateRandomStringArray(10, 5, false, false);
            AliasActions action = AliasActions.PARSER.apply(parser, null);
            assertEquals(writeIndex, action.writeIndex());
    public void testParseIndexAndIndicesThrowsError() throws IOException {
            assertEquals(AliasActions.Type.ADD, action.actionType());
        String alias = randomAlphaOfLength(5);
 * license agreements. See the NOTICE file distributed with
    }
            if (randomBoolean()) {
        String[] indices = generateRandomStringArray(10, 5, false, false);
            }
        boolean writeIndex = randomBoolean();
        assertEquals("[index_routing] is unsupported for [" + action.actionType() + "]", e.getMessage());
                }
            BytesReference shuffled = toShuffledXContent(action, xContentType, ToXContent.EMPTY_PARAMS, false, "filter");
            action.indices(generateRandomStringArray(5, 5, false, false));
                    b.field("routing", indexRouting);
            assertEquals("One of [index] or [indices] is required", e.getMessage());
            b.startObject("remove");
                b.field("alias", randomAlphaOfLength(5));
                action.alias(randomAlphaOfLength(5));
 * the Apache License, Version 2.0 (the "License"); you may
                assertNull(parser.nextToken());
                b.field("is_write_index", writeIndex);
 * Unless required by applicable law or agreed to in writing,
            b.endObject();
        if (action.actionType() != AliasActions.Type.REMOVE_INDEX) {
 * KIND, either express or implied.  See the License for the
            AliasActions parsedAction;
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).alias(""));
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).index(null)
        Object indexRouting = randomBoolean() ? randomBoolean() ? searchRouting : randomRouting() : null;
        Exception e = expectThrows(
            assertArrayEquals(indices, action.indices());
        if (type == AliasActions.Type.REMOVE_INDEX) {
        assertEquals("[must_exist] is unsupported for [" + action.actionType() + "]", e.getMessage());
            assertThat(action.indices(), arrayContaining(index));
            Exception e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).validate());
        assertEquals("[index] can't be empty string", e.getMessage());
                    action.routing(randomAlphaOfLength(5));
        assertEquals("[search_routing] is unsupported for [" + action.actionType() + "]", e.getMessage());
                } else {
                        b.field("search_routing", searchRouting);
            Exception e = expectThrows(XContentParseException.class, () -> AliasActions.PARSER.apply(parser, null));
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases("test", null));
 *
            Exception e = expectThrows(
            assertEquals(indexRouting.toString(), action.indexRouting());
import org.opensearch.test.OpenSearchTestCase;
            AliasActions action = randomAliasAction();
 * not use this file except in compliance with the License.
        b = shuffleXContent(b);
        b.startObject();
            AliasActions action = AliasActions.PARSER.apply(parser, null);
 */
import java.util.Objects;
                    b.field("alias", aliases[0]);
 * specific language governing permissions and limitations
                }
    }
                if (indices.length > 1 || randomBoolean()) {
                        b.field("routing", searchRouting);
 * compatible open source license.
            if (mustExist) {
        b.endObject();
        AliasActions action = randomBoolean() ? AliasActions.add() : AliasActions.removeIndex();
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.routing("test"));
        b.startObject();
        AliasActions action = new AliasActions(randomFrom(AliasActions.Type.values()));
    }
}
            b.endObject();
        }
                }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                }
        assertEquals("[aliases] can't be empty", e.getMessage());
    public void testEmptyIndex() {
            {
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.arrayContaining;
                    b.field("index", indices[0]);
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
        b = shuffleXContent(b);
import org.opensearch.core.xcontent.ToXContent;
        }
            action.writeTo(out);
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases(new String[0]));
        {
            assertEquals(searchRouting.toString(), action.searchRouting());
        assertEquals("[index] can't be empty string", e.getMessage());
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            b.endObject();
    }
        String[] indices = randomBoolean() ? new String[] { randomAlphaOfLength(5) } : generateRandomStringArray(10, 5, false, false);
/*
            IllegalArgumentException.class,
                    b.array("indices", indices);
        b = shuffleXContent(b, "filter");
        b.startObject();
        b.startObject();
                }
                    b.field("index_routing", indexRouting);
            assertThat(action.aliases(), equalTo(aliases));
    public void testParseRemoveIndex() throws IOException {
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomRouting;
    public void testParseAddDefaultRouting() throws IOException {
import org.opensearch.common.xcontent.XContentType;
    }
            IllegalArgumentException.class,
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(randomFrom(AliasActions.Type.values())).index(""));
            b.endObject();
            {
        for (int runs = 0; runs < 20; runs++) {
            assertEquals("One of [index] or [indices] is required", e.getMessage());
    }
        e = expectThrows(
 * Modifications Copyright OpenSearch Contributors. See
                } else {
import java.io.IOException;
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices("test", "")
        assertEquals("[indices] can't be empty", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> action.filter("test"));
                }
        assertEquals("[alias] can't be empty string", e.getMessage());
import static org.hamcrest.Matchers.containsString;
                }
                } else {
 * You may obtain a copy of the License at
                action.filter(randomAlphaOfLength(10));
                if (searchRouting != null) {
                }
        boolean mustExist = randomBoolean();
    }
            b.startObject("remove_index");
 * SPDX-License-Identifier: Apache-2.0
            }
            AliasActions action = AliasActions.PARSER.apply(parser, null);
                    b.array("indices", indices);
        String[] indices = generateRandomStringArray(10, 5, false, false);
import org.opensearch.core.xcontent.XContentParseException;
    public void testBadOptionsInNonIndex() {
                    b.field("index", indices[0]);
        try (XContentParser parser = createParser(b)) {
        );
        try (XContentParser parser = createParser(b)) {
            assertEquals(AliasActions.Type.REMOVE, action.actionType());
        );
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices(new String[0])
 *
        }
            }
        assertEquals("[aliases] can't contain empty string", e.getMessage());
                b.field("alias", randomAlphaOfLength(5));
        }
            assertThat(action.aliases(), arrayContaining(alias));
            } else {
            try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {
            b.endObject();
import static org.hamcrest.Matchers.instanceOf;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (filter != null) {
        Exception e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).alias(null));
        }
    }
            assertEquals(AliasActions.Type.ADD, action.actionType());
 * GitHub history for details.
                if (indices.length > 1 || randomBoolean()) {
                parsedAction = AliasActions.fromXContent(parser);
            if (randomBoolean()) {
            IllegalArgumentException.class,
            );
    }
            IllegalArgumentException.class,
                    b.field("index_routing", indexRouting);
                    if (searchRouting.equals(indexRouting)) {
                    b.array("aliases", aliases);
                } else {
    public void testRoundTrip() throws IOException {
 * software distributed under the License is distributed on an
            XContentType xContentType = randomFrom(XContentType.values());
        }
    public void testParseAliasAndAliasesThrowsError() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                () -> new AliasActions(type).alias(randomAlphaOfLength(5)).validate()
            try (StreamInput in = out.bytes().streamInput()) {
            }
        );
        }
                } else {
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices("test", null)
    }
    }
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
        } else {
public class AliasActionsTests extends OpenSearchTestCase {
package org.opensearch.action.admin.indices.alias;
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
        {
                b.field("index", index);
        e = expectThrows(
                if (indices.length > 1 || randomBoolean()) {
                    action.searchRouting(randomAlphaOfLength(5));
            b.startObject(randomFrom("add", "remove"));
/*
            }
        AliasActions action = randomBoolean() ? AliasActions.remove() : AliasActions.removeIndex();
    public void testEmptyAlias() {
                    b.field("routing", searchRouting);
                if (randomBoolean()) {
                b.field("index", randomAlphaOfLength(5));
        Map<String, Object> filter = randomBoolean() ? randomMap(5) : null;
        );
                    b.array("aliases", aliases);
        b.startObject();
            if (randomBoolean()) {
    }
        b.startObject();
                }
                b.field("alias", alias);
        b.endObject();
            assertThat(e.getCause().getCause().getMessage(), containsString("Only one of [alias] and [aliases] is supported"));
                if (aliases.length > 1 || randomBoolean()) {
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
    public void testParseRemove() throws IOException {
        if (action.actionType() == AliasActions.Type.ADD) {
                IllegalArgumentException.class,
        AliasActions removeAliasAction = AliasActions.remove();
                if (aliases.length > 1 || randomBoolean()) {
            {
            assertThat(action.indices(), equalTo(indices));
