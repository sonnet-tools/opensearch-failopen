            assertThat(cap1.isAggregatable(), equalTo(true));  
        }
                meta = Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "baz")));
            assertEquals(Collections.emptyMap(), cap1.meta());
import java.util.HashSet;
            case 4:
        switch (randomInt(2)) {
        builder.add("index2", true, false, Collections.emptyMap());
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            case 2:
            }
            assertThat(cap2.isAggregatable(), equalTo(true));
        String[] nonAggregatableIndices = instance.nonAggregatableIndices();
                int startNonAggregatablePos = 0;
        builder.add("index2", true, false, Collections.emptyMap());
            FieldCapabilities cap1 = builder.build(false);
            assertNull(cap1.nonSearchableIndices());
 */
                isAggregatable = isAggregatable == false;
                if (indices == null) {
                break;  
        FieldCapabilities.Builder builder = new FieldCapabilities.Builder("field", "type");  
            assertThat(cap1.isSearchable(), equalTo(true));
            for (int i = 0; i < indices.length; i++) {  
            case 5:  
                } else {
 * license agreements. See the NOTICE file distributed with
        builder = new FieldCapabilities.Builder("field", "type");  
                break;
            randomBoolean(),  
 * the Apache License, Version 2.0 (the "License"); you may
                for (int i = startNonAggregatablePos; i < newNonAggregatableIndices.length; i++) {
 *
            assertThat(cap1.nonAggregatableIndices(), equalTo(new String[] { "index2", "index3" }));
    }
    }
                break;  
    protected FieldCapabilities createTestInstance() {
            nonSearchableIndices,
                int startIndicesPos = 0;  
            for (int i = 0; i < nonSearchableIndices.length; i++) {
            assertNull(cap2.nonAggregatableIndices());  
        );
            assertThat(cap1.isSearchable(), equalTo(true));
import java.util.Set;
import java.io.IOException;
                    newNonSearchableIndices = new String[between(1, 10)];
        }  
            assertNull(cap1.nonAggregatableIndices());  
            case 7:
                    startNonAggregatablePos = nonAggregatableIndices.length;  
        }
    protected Writeable.Reader<FieldCapabilities> instanceReader() {
        builder = new FieldCapabilities.Builder("field", "type");
                    newIndices = Arrays.copyOf(indices, indices.length + between(1, 10));
                for (int i = startNonSearchablePos; i < newNonSearchableIndices.length; i++) {  
        if (randomBoolean()) {
        return randomFieldCaps(FIELD_NAME);  
                break;
            FieldCapabilities cap1 = builder.build(false);  
 * Licensed to Elasticsearch under one or more contributor  
                nonAggregatableIndices = newNonAggregatableIndices;
                break;  
import java.util.Collections;
            assertNull(cap2.nonSearchableIndices());
                meta = Collections.singletonMap("foo", Collections.singleton("bar"));
                    startNonSearchablePos = nonSearchableIndices.length;
        if (randomBoolean()) {  
                isSearchable = isSearchable == false;
                for (int i = startIndicesPos; i < newIndices.length; i++) {
 * Modifications Copyright OpenSearch Contributors. See
        builder.add("index1", true, false, Collections.emptyMap());
                break;  
 * not use this file except in compliance with the License.
            assertNull(cap1.indices());
                }
                }
                    newNonSearchableIndices = Arrays.copyOf(nonSearchableIndices, nonSearchableIndices.length + between(1, 10));  
                indices = newIndices;
        switch (between(0, 7)) {  
            assertThat(cap1.isAggregatable(), equalTo(false));
import java.util.Arrays;  
                if (nonSearchableIndices == null) {  
                }  
            assertEquals(Collections.emptyMap(), cap2.meta());  
 * The OpenSearch Contributors require contributions made to  
                    newMeta = Collections.singletonMap("foo", Collections.singleton("bar"));
    protected FieldCapabilities doParseInstance(XContentParser parser) throws IOException {  
 * under the License.  
 */  
        String[] indices = null;  
        Map<String, Set<String>> meta = instance.meta();
 * Unless required by applicable law or agreed to in writing,
                String[] newNonAggregatableIndices;  
            assertThat(cap2.isSearchable(), equalTo(true));  
        String[] indices = instance.indices();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(cap2.isAggregatable(), equalTo(false));
        return new FieldCapabilities(
            assertNull(cap1.indices());  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;  
                break;
            assertEquals(Collections.emptyMap(), cap1.meta());  
            assertThat(cap2.nonSearchableIndices(), equalTo(new String[] { "index1", "index3" }));  
 *
                } else {
                } else {  
            fieldName,  
        return FieldCapabilities::new;
 * specific language governing permissions and limitations
        builder.add("index3", true, false, Collections.emptyMap());  
            FieldCapabilities cap2 = builder.build(true);
                nonAggregatableIndices[i] = randomAlphaOfLengthBetween(5, 20);  
        String type = instance.getType();
            assertThat(cap2.indices().length, equalTo(3));
        }  
            assertEquals(Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "quux"))), cap1.meta());
                }
                break;  
                    newIndices = new String[between(1, 10)];
    }  
import org.opensearch.core.common.io.stream.Writeable;
                int startNonSearchablePos = 0;
            assertThat(cap2.indices().length, equalTo(3));  
            assertThat(cap1.isSearchable(), equalTo(false));  
        builder.add("index3", false, false, Collections.emptyMap());  
        String[] nonSearchableIndices = instance.nonSearchableIndices();  
            indices = new String[randomIntBetween(1, 5)];
import org.opensearch.core.xcontent.XContentParser;
    }  
                    newNonAggregatableIndices = Arrays.copyOf(nonAggregatableIndices, nonAggregatableIndices.length + between(1, 10));
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        String[] nonAggregatableIndices = null;
                throw new AssertionError();
                if (nonAggregatableIndices == null) {
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));  
 * GitHub history for details.
            FieldCapabilities cap2 = builder.build(true);  
        {
            nonSearchableIndices = new String[randomIntBetween(0, 5)];  
        }  
        String[] nonSearchableIndices = null;
                } else {
 *  
            assertThat(cap2.nonAggregatableIndices(), equalTo(new String[] { "index2", "index3" }));
 */  
public class FieldCapabilitiesTests extends AbstractSerializingTestCase<FieldCapabilities> {
            randomBoolean(),
                    startIndicesPos = indices.length;
/*  
            assertNull(cap2.nonAggregatableIndices());
 * SPDX-License-Identifier: Apache-2.0
                break;
            assertEquals(Collections.emptyMap(), cap2.meta());
 * ownership. Elasticsearch licenses this file to you under  
    @Override
            assertThat(cap2.isSearchable(), equalTo(false));
import org.opensearch.test.AbstractSerializingTestCase;  
        {  
                String[] newNonSearchableIndices;
    @Override  
        }  
import java.util.Map;  
                }
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));
    @Override
                meta = Collections.emptyMap();
            }  
                    newNonAggregatableIndices[i] = randomAlphaOfLengthBetween(5, 20);  
    public void testBuilder() {
            assertThat(cap2.indices().length, equalTo(3));
    protected FieldCapabilities mutateInstance(FieldCapabilities instance) {  
            assertThat(cap2.isAggregatable(), equalTo(false));  
                indices[i] = randomAlphaOfLengthBetween(5, 20);
        {
            assertThat(cap1.isAggregatable(), equalTo(false));
                meta = newMeta;
                type += randomAlphaOfLengthBetween(1, 10);
                nonSearchableIndices = newNonSearchableIndices;  
        if (randomBoolean()) {
        builder.add("index1", true, true, Collections.emptyMap());  
                break;  
                Map<String, Set<String>> newMeta;
            nonAggregatableIndices,  
    private static final String FIELD_NAME = "field";  
        }
                if (meta.isEmpty()) {  
    @Override
                nonSearchableIndices[i] = randomAlphaOfLengthBetween(5, 20);
            assertThat(cap1.nonSearchableIndices(), equalTo(new String[] { "index1", "index3" }));  
            case 6:
        Map<String, Set<String>> meta;
}  
package org.opensearch.action.fieldcaps;
 * KIND, either express or implied.  See the License for the
    }
                }
                break;
            FieldCapabilities cap1 = builder.build(false);
        return FieldCapabilities.fromXContent(FIELD_NAME, parser);
        return new FieldCapabilities(name, type, isSearchable, isAggregatable, indices, nonSearchableIndices, nonAggregatableIndices, meta);
            indices,
                }  
            meta
            FieldCapabilities cap2 = builder.build(true);
            assertThat(cap2.indices(), equalTo(new String[] { "index1", "index2", "index3" }));
            assertNull(cap1.nonAggregatableIndices());
            case 1:
            case 3:
                String[] newIndices;
            assertNull(cap2.nonSearchableIndices());
        }
            assertThat(cap2.isSearchable(), equalTo(true));
            for (int i = 0; i < nonAggregatableIndices.length; i++) {
            nonAggregatableIndices = new String[randomIntBetween(0, 5)];
            assertEquals(Collections.singletonMap("foo", new HashSet<>(Arrays.asList("bar", "quux"))), cap2.meta());
            default:
        boolean isSearchable = instance.isSearchable();  
            randomAlphaOfLengthBetween(5, 20),
        builder.add("index1", false, true, Collections.emptyMap());
 * compatible open source license.
            assertNull(cap1.indices());
                    newIndices[i] = randomAlphaOfLengthBetween(5, 20);
                    newMeta = Collections.emptyMap();  
    static FieldCapabilities randomFieldCaps(String fieldName) {
                name += randomAlphaOfLengthBetween(1, 10);
        builder.add("index2", true, true, Collections.singletonMap("foo", "bar"));
        String name = instance.getName();
                    newNonSearchableIndices[i] = randomAlphaOfLengthBetween(5, 20);
            default:  
            assertNull(cap1.nonSearchableIndices());
 * You may obtain a copy of the License at  
            case 1:  
            case 0:  
/*  
        builder.add("index3", true, true, Collections.singletonMap("foo", "quux"));
            case 0:
/*
                    newNonAggregatableIndices = new String[between(1, 10)];  
        boolean isAggregatable = instance.isAggregatable();
