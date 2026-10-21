 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
            case 7:
/*
            meta
            default:
                    newMeta = Collections.singletonMap("foo", Collections.singleton("bar"));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.io.stream.Writeable;
    }
            assertThat(cap1.isAggregatable(), equalTo(false));
            assertThat(cap1.isSearchable(), equalTo(false));
            assertThat(cap2.indices().length, equalTo(3));
            assertThat(cap1.isAggregatable(), equalTo(false));
                if (meta.isEmpty()) {
            FieldCapabilities cap1 = builder.build(false);
            assertThat(cap2.nonAggregatableIndices(), equalTo(new String[] { "index2", "index3" }));
            assertThat(cap2.indices().length, equalTo(3));
            }
        String[] indices = instance.indices();
            case 3:
package org.opensearch.action.fieldcaps;
                }
    }
            randomAlphaOfLengthBetween(5, 20),
            assertNull(cap2.nonAggregatableIndices());
        String[] nonSearchableIndices = instance.nonSearchableIndices();
                    startNonAggregatablePos = nonAggregatableIndices.length;
        return FieldCapabilities.fromXContent(FIELD_NAME, parser);
    }
    protected FieldCapabilities mutateInstance(FieldCapabilities instance) {
        }
        FieldCapabilities.Builder builder = new FieldCapabilities.Builder("field", "type");
                isSearchable = isSearchable == false;
                    newNonAggregatableIndices = new String[between(1, 10)];
        {
                break;
            nonSearchableIndices = new String[randomIntBetween(0, 5)];
                    newNonSearchableIndices = new String[between(1, 10)];
            assertThat(cap2.isSearchable(), equalTo(true));
            FieldCapabilities cap1 = builder.build(false);
    private static final String FIELD_NAME = "field";
 *
        switch (between(0, 7)) {
            indices = new String[randomIntBetween(1, 5)];
            FieldCapabilities cap1 = builder.build(false);
 * Licensed to Elasticsearch under one or more contributor
        );
 */
            assertThat(cap1.nonAggregatableIndices(), equalTo(new String[] { "index2", "index3" }));
                break;
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));
                }
        {
            nonAggregatableIndices,
                if (nonSearchableIndices == null) {
                String[] newNonSearchableIndices;
                }
import java.util.Set;
            assertThat(cap2.isAggregatable(), equalTo(false));
            }
                break;
 * software distributed under the License is distributed on an
            assertEquals(Collections.emptyMap(), cap2.meta());
        builder.add("index2", true, true, Collections.singletonMap("foo", "bar"));
                int startNonAggregatablePos = 0;
 * You may obtain a copy of the License at
        Map<String, Set<String>> meta = instance.meta();
 * KIND, either express or implied.  See the License for the
        builder.add("index3", true, false, Collections.emptyMap());
/*
    protected Writeable.Reader<FieldCapabilities> instanceReader() {
                meta = Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "baz")));
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;
                name += randomAlphaOfLengthBetween(1, 10);
                    newIndices = Arrays.copyOf(indices, indices.length + between(1, 10));
            assertNull(cap1.indices());
                }
                if (nonAggregatableIndices == null) {
            case 6:
}
            case 5:
            assertNull(cap1.nonAggregatableIndices());
                Map<String, Set<String>> newMeta;
    }
 * compatible open source license.
        boolean isAggregatable = instance.isAggregatable();
            case 0:
            case 4:
                    newNonSearchableIndices = Arrays.copyOf(nonSearchableIndices, nonSearchableIndices.length + between(1, 10));
                } else {
            }
            FieldCapabilities cap2 = builder.build(true);
        if (randomBoolean()) {
                    newNonAggregatableIndices[i] = randomAlphaOfLengthBetween(5, 20);
            fieldName,
                    newIndices[i] = randomAlphaOfLengthBetween(5, 20);
                for (int i = startNonAggregatablePos; i < newNonAggregatableIndices.length; i++) {
                nonSearchableIndices[i] = randomAlphaOfLengthBetween(5, 20);
                    newNonAggregatableIndices = Arrays.copyOf(nonAggregatableIndices, nonAggregatableIndices.length + between(1, 10));
import java.util.Arrays;
        return new FieldCapabilities(name, type, isSearchable, isAggregatable, indices, nonSearchableIndices, nonAggregatableIndices, meta);
        }
    @Override
                } else {
import java.io.IOException;
        return FieldCapabilities::new;
import org.opensearch.test.AbstractSerializingTestCase;
            for (int i = 0; i < nonAggregatableIndices.length; i++) {
            assertNull(cap2.nonAggregatableIndices());
import java.util.Collections;
                }
                nonSearchableIndices = newNonSearchableIndices;
    public void testBuilder() {
        if (randomBoolean()) {
        builder = new FieldCapabilities.Builder("field", "type");
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
                break;
        }
            randomBoolean(),
                break;
    }
import java.util.Map;
        builder.add("index3", false, false, Collections.emptyMap());
        switch (randomInt(2)) {
                    newMeta = Collections.emptyMap();
                throw new AssertionError();
 * The OpenSearch Contributors require contributions made to
                } else {
        }
        builder.add("index2", true, false, Collections.emptyMap());
            assertEquals(Collections.emptyMap(), cap1.meta());
        String type = instance.getType();
            case 1:
            case 2:
    @Override
            default:
                    newNonSearchableIndices[i] = randomAlphaOfLengthBetween(5, 20);
        Map<String, Set<String>> meta;
                meta = Collections.emptyMap();
 * not use this file except in compliance with the License.
            assertThat(cap2.indices().length, equalTo(3));
                break;
            assertThat(cap1.nonSearchableIndices(), equalTo(new String[] { "index1", "index3" }));
/*
                isAggregatable = isAggregatable == false;
            case 0:
                break;
            assertThat(cap1.isSearchable(), equalTo(true));
        String[] nonSearchableIndices = null;
            assertThat(cap2.isSearchable(), equalTo(true));
                } else {
 * specific language governing permissions and limitations
    @Override
            assertThat(cap2.nonSearchableIndices(), equalTo(new String[] { "index1", "index3" }));
            assertThat(cap1.isSearchable(), equalTo(true));
        String name = instance.getName();
        }
                meta = Collections.singletonMap("foo", Collections.singleton("bar"));
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));
            assertEquals(Collections.emptyMap(), cap2.meta());
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));
            randomBoolean(),
            indices,
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.add("index2", true, false, Collections.emptyMap());
        builder.add("index3", true, true, Collections.singletonMap("foo", "quux"));
                if (indices == null) {
        String[] nonAggregatableIndices = null;
                }
                nonAggregatableIndices = newNonAggregatableIndices;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                String[] newNonAggregatableIndices;
            FieldCapabilities cap2 = builder.build(true);
                break;
                    newIndices = new String[between(1, 10)];
            assertNull(cap2.nonSearchableIndices());
            assertEquals(Collections.emptyMap(), cap1.meta());
            nonSearchableIndices,
        builder.add("index1", true, true, Collections.emptyMap());
        {
                meta = newMeta;
    static FieldCapabilities randomFieldCaps(String fieldName) {
                String[] newIndices;
        String[] nonAggregatableIndices = instance.nonAggregatableIndices();
        boolean isSearchable = instance.isSearchable();
                    startIndicesPos = indices.length;
                for (int i = startNonSearchablePos; i < newNonSearchableIndices.length; i++) {
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        return new FieldCapabilities(
        return randomFieldCaps(FIELD_NAME);
            for (int i = 0; i < nonSearchableIndices.length; i++) {
                    startNonSearchablePos = nonSearchableIndices.length;
        String[] indices = null;
                }
public class FieldCapabilitiesTests extends AbstractSerializingTestCase<FieldCapabilities> {
                for (int i = startIndicesPos; i < newIndices.length; i++) {
                int startNonSearchablePos = 0;
                type += randomAlphaOfLengthBetween(1, 10);
        builder = new FieldCapabilities.Builder("field", "type");
            nonAggregatableIndices = new String[randomIntBetween(0, 5)];
            assertEquals(Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "quux"))), cap2.meta());
                nonAggregatableIndices[i] = randomAlphaOfLengthBetween(5, 20);
                indices[i] = randomAlphaOfLengthBetween(5, 20);
                break;
            assertThat(cap1.isAggregatable(), equalTo(true));
    }
                break;
    protected FieldCapabilities createTestInstance() {
            assertThat(cap2.isAggregatable(), equalTo(false));
                indices = newIndices;
            assertNull(cap1.indices());
        }
    @Override
 * SPDX-License-Identifier: Apache-2.0
            assertNull(cap1.nonAggregatableIndices());
 *
            FieldCapabilities cap2 = builder.build(true);
        builder.add("index1", false, true, Collections.emptyMap());
                int startIndicesPos = 0;
            assertThat(cap2.isAggregatable(), equalTo(true));
            case 1:
 * Unless required by applicable law or agreed to in writing,
        }
    protected FieldCapabilities doParseInstance(XContentParser parser) throws IOException {
            assertNull(cap1.nonSearchableIndices());
            for (int i = 0; i < indices.length; i++) {
            assertNull(cap1.nonSearchableIndices());
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(cap2.isSearchable(), equalTo(false));
 *
            assertNull(cap2.nonSearchableIndices());
        }
        builder.add("index1", true, false, Collections.emptyMap());
            assertNull(cap1.indices());
                break;
 */
            assertEquals(Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "quux"))), cap1.meta());
