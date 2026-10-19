        }
            builder.filter("{\"term\":{\"year\":2016}}");
import java.io.IOException;
            .searchRouting("trim,tw , ltw , lw")
        if (randomBoolean()) {  
            .writeIndex(randomBoolean() ? null : randomBoolean())  
    @Override  
}
            builder.indexRouting(randomAlphaOfLengthBetween(3, 10));
        }
        builder.writeIndex(randomBoolean());  
                .build();
 * compatible open source license.
package org.opensearch.cluster.metadata;
    protected AliasMetadata doParseInstance(XContentParser parser) throws IOException {
                .writeIndex(randomBoolean() ? null : randomBoolean())
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * specific language governing permissions and limitations
        if (randomBoolean()) {  
            builder.isHidden(randomBoolean());  
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {  
import org.opensearch.core.common.io.stream.StreamInput;
            .isHidden(randomBoolean() ? null : randomBoolean())
            .build();
 */  
        return p -> p.equals("") // do not add elements at the top-level as any element at this level is parsed as a new alias
        before.writeTo(out);
            builder.routing(randomAlphaOfLengthBetween(3, 10));
            builder.searchRouting(randomAlphaOfLengthBetween(3, 10));
 * this work for additional information regarding copyright
    @Override  
    protected boolean supportsUnknownFields() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSerialization() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
/*  
/*  
        assertEquals(expectedInstance, newInstance);  
                .searchRouting(expectedInstance.searchRouting())
 */  
        return aliasMetadata;
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(after, equalTo(before));  
        assertThat(before.searchRoutingValues(), equalTo(Sets.newHashSet("trim", "tw ", " ltw ", " lw")));
        assertEquals(XContentParser.Token.FIELD_NAME, parser.currentToken());
 *
            .indexRouting("indexRouting")  
    }
 * under the License.  
 *
 * GitHub history for details.
        if (randomBoolean()) {  
        if (expectedInstance.writeIndex() == null) {  
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return builder.build();
            .routing("routing")
 * license agreements. See the NOTICE file distributed with
                .indexRouting(expectedInstance.indexRouting())  
        }
                .filter(expectedInstance.filter())
        return true;
        }
        return createTestItem();  
 * not use this file except in compliance with the License.
        AliasMetadata aliasMetadata = AliasMetadata.Builder.fromXContent(parser);  
import org.opensearch.cluster.metadata.AliasMetadata.Builder;
import org.opensearch.core.xcontent.XContentParser;
        }
            expectedInstance = AliasMetadata.builder(expectedInstance.alias())
    private static AliasMetadata createTestItem() {
        }
    }  
import org.opensearch.test.AbstractXContentTestCase;  
    protected AliasMetadata createTestInstance() {
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at  
        final BytesStreamOutput out = new BytesStreamOutput();  
import java.util.function.Predicate;  
                .isHidden(randomBoolean() ? null : randomBoolean())  
            parser.nextToken();  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
            || p.contains(".filter"); // do not insert random data into AliasMetadata#filter  
import org.opensearch.common.util.set.Sets;  
    }
        }
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {
 */
        final AliasMetadata after = new AliasMetadata(in);
    }  
 * software distributed under the License is distributed on an
public class AliasMetadataTests extends AbstractXContentTestCase<AliasMetadata> {
/*
    protected void assertEqualInstances(AliasMetadata expectedInstance, AliasMetadata newInstance) {
    }
    }
            .filter("{ \"term\": \"foo\"}")
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
        if (randomBoolean()) {
        assertNotSame(newInstance, expectedInstance);
        final AliasMetadata before = AliasMetadata.builder("alias")
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 *  
 * The OpenSearch Contributors require contributions made to  
        Builder builder = AliasMetadata.builder(randomAlphaOfLengthBetween(3, 10));
        final StreamInput in = out.bytes().streamInput();  
