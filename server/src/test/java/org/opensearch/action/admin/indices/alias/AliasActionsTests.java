 *
import org.opensearch.core.xcontent.XContentParser;
        e = expectThrows(  
                        b.field("search_routing", searchRouting);
            assertArrayEquals(indices, action.indices());  
                }
        );  
    }
        b.startObject();
            b.endObject();
                b.array("aliases", generateRandomStringArray(10, 5, false, false));  
            if (filter == null || filter.isEmpty()) {
            {
            b.endObject();  
                    b.array("indices", indices);  
            assertEquals(AliasActions.Type.REMOVE, action.actionType());
        Object indexRouting = randomBoolean() ? randomBoolean() ? searchRouting : randomRouting() : null;  
        }  
                } else {
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals("[indices] can't contain empty string", e.getMessage());
                b.field("is_hidden", isHidden);
            BytesReference shuffled = toShuffledXContent(action, xContentType, ToXContent.EMPTY_PARAMS, false, "filter");
        Exception e = expectThrows(
                } else {  
        }  
        AliasActions.Type type = randomFrom(AliasActions.Type.values());
 * software distributed under the License is distributed on an
                b.field("index", index);
 * license agreements. See the NOTICE file distributed with
        }
            }  
        b.startObject();  
        {
            );  
        b.startObject();
                }  
        assertEquals("[indices] can't be empty", e.getMessage());
                b.field("alias", randomAlphaOfLength(5));
            AliasActions action = AliasActions.PARSER.apply(parser, null);  
    }
                }  
        }  
        try (XContentParser parser = createParser(b)) {
            assertEquals(writeIndex, action.writeIndex());
import static org.hamcrest.Matchers.arrayWithSize;
            {
        if (randomBoolean()) {
    }
        assertEquals("[aliases] can't be empty", e.getMessage());
            e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).index(randomAlphaOfLength(5)).validate());
 * the Apache License, Version 2.0 (the "License"); you may
                    action.routing(randomAlphaOfLength(5));
            }
        }
                    b.field("index", indices[0]);
        if (action.actionType() != AliasActions.Type.REMOVE_INDEX) {
        String[] indices = generateRandomStringArray(10, 5, false, false);
        }
        String[] aliases = generateRandomStringArray(10, 5, false, false);  
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices("test", null)  
        AliasActions.Type type = randomValueOtherThan(AliasActions.Type.REMOVE_INDEX, () -> randomFrom(AliasActions.Type.values()));
    public void testBadOptionsInNonIndex() {
        {
 * You may obtain a copy of the License at  
        } else {
        removeAliasAction.mustExist(mustExist);  
            assertThat(action.indices(), equalTo(indices));
                    b.field("index", indices[0]);
            b.endObject();
        for (int runs = 0; runs < 20; runs++) {
                }
    }
                if (randomBoolean()) {
            b.endObject();
            }  
        try (XContentParser parser = createParser(b)) {
            AliasActions action = AliasActions.PARSER.apply(parser, null);
                } else {  
import org.opensearch.core.xcontent.XContentParseException;  
        }
        {
        e = expectThrows(
            action.writeTo(out);
        Exception e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).alias(null));  
            assertEquals("One of [index] or [indices] is required", e.getMessage());
                    b.field("filter", filter);
        }
        if (type == AliasActions.Type.REMOVE_INDEX) {
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.mustExist(mustExist));  
        AliasActions action = randomBoolean() ? AliasActions.add() : AliasActions.removeIndex();
        {
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.routing("test"));
    public void testFromToXContent() throws IOException {  
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
                if (searchRouting != null) {  
            b.endObject();
                }  
                    action.searchRouting(randomAlphaOfLength(5));
/*
            assertEquals(AliasActions.Type.ADD, action.actionType());
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).alias(""));
        );  
                    }
        }  
 * under the License.  
                assertThat(action.mustExist(), equalTo(true));
        String alias = randomAlphaOfLength(5);  
            }  
            AliasActions action = AliasActions.PARSER.apply(parser, null);  
    public void testParseAliasAndAliasesThrowsError() throws IOException {
                } else {
        );
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases("test", null));
        );
 * Unless required by applicable law or agreed to in writing,
        assertEquals("[indices] can't contain empty string", e.getMessage());
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(action.aliases(), equalTo(aliases));  
                if (mustExist) {  
        );
                b.field("is_write_index", writeIndex);
                assertEquals(MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).map(filter).toString(), action.filter());
    }
                    b.field("routing", indexRouting);  
                b.field("alias", alias);  
            Exception e = expectThrows(  
                    b.array("indices", indices);  
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices((String[]) null)
            if (randomBoolean()) {  
                action.aliases(generateRandomStringArray(5, 5, false, false));
        assertEquals("[aliases] can't contain empty string", e.getMessage());  
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
            }
            }
            } else {  
    }  
            action.indices(generateRandomStringArray(5, 5, false, false));
            assertEquals("One of [alias] or [aliases] is required", e.getMessage());  
        if (action.actionType() == AliasActions.Type.ADD) {
            }  
                }
            b.startObject("remove_index");  
                }
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());  
            assertThat(parsedAction, equalTo(action));
            }
                if (indices.length > 1 || randomBoolean()) {
                    b.field("index_routing", indexRouting);
            assertEquals(isHidden, action.isHidden());  
    }  
        }
                    b.field("alias", aliases[0]);
            assertEquals(Objects.toString(searchRouting, null), action.searchRouting());  
                if (randomBoolean()) {
                AliasActions read = new AliasActions(in);  
                IllegalArgumentException.class,
    }  
        assertEquals("[aliases] can't contain empty string", e.getMessage());
            assertEquals("One of [index] or [indices] is required", e.getMessage());
    public void testParseRemoveIndex() throws IOException {
        assertEquals("[search_routing] is unsupported for [" + action.actionType() + "]", e.getMessage());
                }  
            b.startObject("add");  
        try (XContentParser parser = createParser(b)) {
 * Modifications Copyright OpenSearch Contributors. See
        b = shuffleXContent(b);
    }
            assertThat(e.getCause().getCause().getMessage(), containsString("Only one of [index] and [indices] is supported"));  
        b.endObject();
        Map<String, Object> filter = randomBoolean() ? randomMap(5) : null;
        b.startObject();
        b = shuffleXContent(b);  
            if (randomBoolean()) {
            try (StreamInput in = out.bytes().streamInput()) {
                if (indexRouting != null && false == indexRouting.equals(searchRouting)) {
            }
            action.index(randomAlphaOfLength(5));  
            XContentType xContentType = randomFrom(XContentType.values());  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import static org.hamcrest.Matchers.containsString;
                    action.indexRouting(randomAlphaOfLength(5));
        AliasActions action = new AliasActions(randomFrom(AliasActions.Type.values()));
        assertEquals("[aliases] can't be empty", e.getMessage());
 */  
import org.opensearch.common.io.stream.BytesStreamOutput;
            Exception e = expectThrows(XContentParseException.class, () -> AliasActions.PARSER.apply(parser, null));
        e = expectThrows(IllegalArgumentException.class, () -> action.filter("test"));
import static org.hamcrest.CoreMatchers.equalTo;
    }  
        b.startObject();
                } else {
    public void testParseAdd() throws IOException {
            Exception e = expectThrows(XContentParseException.class, () -> AliasActions.PARSER.apply(parser, null));  
        Object searchRouting = randomRouting();
            assertThat(action.indices(), equalTo(indices));
        b.endObject();
            b.startObject("add");  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import java.util.Objects;  
            Exception e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).validate());  
        b.endObject();  
                    b.field("must_exist", true);
            b.endObject();  
        assertEquals("[index] can't be empty string", e.getMessage());  
 * KIND, either express or implied.  See the License for the
            }
            assertEquals(AliasActions.Type.ADD, action.actionType());  
    public void testMustExistOption() {
        b = shuffleXContent(b);
        boolean mustExist = randomBoolean();  
            assertEquals(Objects.toString(indexRouting, null), action.indexRouting());
        b.endObject();
        } else {
/*  
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomRouting;
import org.opensearch.common.xcontent.XContentType;  
        b.startObject();
            if (mustExist) {
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases((String[]) null));
 * not use this file except in compliance with the License.
            IllegalArgumentException.class,
        assertNull(removeAliasAction.mustExist());
            {  
 * specific language governing permissions and limitations
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(randomFrom(AliasActions.Type.values())).index(""));
                b.field("index", randomAlphaOfLength(5));
    public void testParseIndexAndIndicesThrowsError() throws IOException {
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomAliasAction;
            } else {
            if (randomBoolean()) {  
    public void testRoundTrip() throws IOException {  
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases(new String[0]));  
                assertNull(action.filter());
        assertEquals("[index] can't be empty string", e.getMessage());
        AliasActions action = randomBoolean() ? AliasActions.remove() : AliasActions.removeIndex();  
                b.array("indices", generateRandomStringArray(10, 5, false, false));  
import org.opensearch.core.common.io.stream.StreamInput;
            b.startObject(randomFrom("add", "remove"));  
    public void testParseRemove() throws IOException {
        e = expectThrows(  
        String[] aliases = generateRandomStringArray(10, 5, false, false);
 * compatible open source license.
        try (XContentParser parser = createParser(b)) {  
        }
            {
        String[] indices = randomBoolean() ? new String[] { randomAlphaOfLength(5) } : generateRandomStringArray(10, 5, false, false);
public class AliasActionsTests extends OpenSearchTestCase {
            assertThat(action.indices(), arrayContaining(index));
                }  
                parsedAction = AliasActions.fromXContent(parser);
            assertThat(action.aliases(), equalTo(aliases));  
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomMap;  
        {
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());  
        boolean writeIndex = randomBoolean();
                action.alias(randomAlphaOfLength(5));  
        e = expectThrows(IllegalArgumentException.class, () -> action.searchRouting("test"));  
            AliasActions action = AliasActions.PARSER.apply(parser, null);
                }
        try (XContentParser parser = createParser(b)) {  
                }  
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
                if (aliases.length > 1 || randomBoolean()) {
    public void testParseAddDefaultRouting() throws IOException {
import java.util.Map;
 */
            }  
                    b.field("search_routing", searchRouting);
        boolean isHidden = randomBoolean();
        }
                    b.field("index", indices[0]);
            }
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices("test", "")
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * GitHub history for details.
    public void testEmptyIndex() {
        }
        }
            }
        }
                assertNull(parser.nextToken());
                if (indices.length > 1 || randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testEmptyAlias() {
            AliasActions action = randomAliasAction();
 *
        assertEquals("[routing] is unsupported for [" + action.actionType() + "]", e.getMessage());
                        b.field("routing", searchRouting);
}
            assertEquals(AliasActions.Type.REMOVE_INDEX, action.actionType());
                    b.array("aliases", aliases);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("[index_routing] is unsupported for [" + action.actionType() + "]", e.getMessage());  
        b.endObject();  
        e = expectThrows(IllegalArgumentException.class, () -> new AliasActions(type).aliases("test", ""));
            IllegalArgumentException.class,  
                    b.field("alias", aliases[0]);
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).index(null)
import static org.hamcrest.Matchers.instanceOf;  
        final boolean mustExist = randomBoolean();  
        }
            {
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(searchRouting.toString(), action.searchRouting());  
            try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {  
            {
        Object searchRouting = randomBoolean() ? randomRouting() : null;
        XContentBuilder b = XContentBuilder.builder(randomFrom(XContentType.values()).xContent());  
            AliasActions parsedAction;
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
import static org.hamcrest.Matchers.arrayContaining;  
import org.opensearch.test.OpenSearchTestCase;
            () -> new AliasActions(randomFrom(AliasActions.Type.values())).indices(new String[0])
import java.io.IOException;
            IllegalArgumentException.class,
        assertEquals("[must_exist] is unsupported for [" + action.actionType() + "]", e.getMessage());
                if (filter != null) {  
            assertEquals(indexRouting.toString(), action.indexRouting());
                b.field("index", randomAlphaOfLength(5));
                } else {
                if (indices.length > 1 || randomBoolean()) {
        assertEquals(mustExist, removeAliasAction.mustExist());
/*  
 *  
        assertEquals("[alias] can't be empty string", e.getMessage());  
                if (aliases.length > 1 || randomBoolean()) {
        b = shuffleXContent(b, "filter");
        try (XContentParser parser = createParser(b)) {
        e = expectThrows(IllegalArgumentException.class, () -> action.indexRouting("test"));
    }
        b.endObject();
                    if (searchRouting.equals(indexRouting)) {
                    b.array("indices", indices);  
                    } else {  
            b.startObject("remove");  
        Object indexRouting = randomRouting();
 * this work for additional information regarding copyright
 */  
        String[] indices = generateRandomStringArray(10, 5, false, false);  
                () -> new AliasActions(type).alias(randomAlphaOfLength(5)).validate()
        }  
        assertEquals("[alias] can't be empty string", e.getMessage());
    public void testValidate() {  
            b.startObject(randomFrom("add", "remove"));
            IllegalArgumentException.class,
            assertThat(e.getCause().getCause().getMessage(), containsString("Only one of [alias] and [aliases] is supported"));
                    b.field("index_routing", indexRouting);  
            assertThat(action.aliases(), arrayContaining(alias));
            IllegalArgumentException.class,  
                    b.array("aliases", aliases);
        assertEquals("[filter] is unsupported for [" + action.actionType() + "]", e.getMessage());
package org.opensearch.action.admin.indices.alias;
            assertThat(action.aliases(), arrayWithSize(0));
import org.opensearch.core.xcontent.ToXContent;
        e = expectThrows(
        String index = randomAlphaOfLength(5);
        AliasActions removeAliasAction = AliasActions.remove();
        {
        }
                action.filter(randomAlphaOfLength(10));
                    b.field("routing", searchRouting);
    }  
                b.field("alias", randomAlphaOfLength(5));
        assertEquals("[indices] can't be empty", e.getMessage());  
                } else {  
                assertEquals(action, read);
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
