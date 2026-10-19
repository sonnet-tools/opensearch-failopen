        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
                RegexOptions::new
                new NamedWriteableRegistry(Collections.emptyList()),  
                );  
            RegexOptions testOptions = randomRegexOptions();  
                        + "]",
        builder.setMaxDeterminizedStates(randomValueOtherThan(original.getMaxDeterminizedStates(), () -> randomIntBetween(1, 10)));  
                testOptions,
            assertEquals(testOptions.hashCode(), deserializedModel.hashCode());
 * Licensed to Elasticsearch under one or more contributor  
        int aboveLimit = RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT + 1;
    }
 * software distributed under the License is distributed on an
        assertEquals(500, builder.setMaxDeterminizedStates(500).build().getMaxDeterminizedStates());  
            try (StreamInput in = out.bytes().streamInput()) {  
        maybeSet(builder::setMaxDeterminizedStates, randomIntBetween(1, 1000));
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public void testMaxDeterminizedStatesFromStreamIsBounded() throws IOException {
                        + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT
                    e.getMessage()
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    private static final int NUMBER_OF_RUNS = 20;
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            out.writeVInt(0); // flagsValue
        assertEquals(
        int aboveLimit = RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT + 1;  
 * license agreements. See the NOTICE file distributed with
/*
            assertEquals(e.getMessage(), "maxDeterminizedStates must not be negative");  
            out.writeVInt(aboveLimit); // maxDeterminizedStates
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.RegexpFlag;
    public void testMaxDeterminizedStatesIsBounded() {
                        + aboveLimit  
            assertEquals(testOptions, deserializedModel);  
        } catch (IllegalArgumentException e) {
     * A legitimately-built RegexOptions cannot carry an out-of-bounds value, so hand-craft the wire
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
    }
 * You may obtain a copy of the License at  
            builder.setMaxDeterminizedStates(RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT).build().getMaxDeterminizedStates()
import org.opensearch.core.common.io.stream.StreamInput;  
        // the ceiling and typical values are accepted
        final RegexOptions.Builder builder = RegexOptions.builder();
                    sb.append("|");
            fail("max determinized state must be positive");
     */  
 *
 * this file be licensed under the Apache-2.0 license or a
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT,  
                IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RegexOptions(in));
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        }  
        }
 * not use this file except in compliance with the License.
            assertNotSame(testOptions, deserializedModel);
        final RegexOptions.Builder builder = RegexOptions.builder();
                assertEquals(
 * KIND, either express or implied.  See the License for the
}
/*  
        for (RegexpFlag regexpFlag : RegexpFlag.values()) {
    }  
 * Unless required by applicable law or agreed to in writing,
    /**  
 */  
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.setMaxDeterminizedStates(aboveLimit));
                if (sb.length() != 0) {  
 * this work for additional information regarding copyright
        return builder.build();
        maybeSet(builder::setFlags, sb.toString());  
    }
     * bytes to prove the transport deserialization path enforces the bound too (mixed-version cluster).
public class RegexOptionsTests extends OpenSearchTestCase {
        StringBuilder sb = new StringBuilder();  
     * Test serialization and deserialization
        assertEquals(
                sb.append(regexpFlag.name());  
                    "maxDeterminizedStates cannot exceed ["  
            }
    }
import java.util.Collections;  
import org.opensearch.index.query.RegexpQueryBuilder;
 */
            }
            e.getMessage()
        try {
 * under the License.  
            "maxDeterminizedStates cannot exceed [" + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT + "] but was [" + aboveLimit + "]",  
        }
                        + "] but was ["
import org.opensearch.test.OpenSearchTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSerialization() throws IOException {
     */  
            RegexOptions deserializedModel = copyWriteable(
        expectThrows(IllegalArgumentException.class, () -> builder.setMaxDeterminizedStates(Integer.MAX_VALUE));  
        final RegexOptions.Builder builder = RegexOptions.builder();
        // anything above the ceiling is rejected
        final RegexOptions.Builder builder = RegexOptions.builder();
        );
    protected RegexOptions createMutation(RegexOptions original) throws IOException {
 *
    public static RegexOptions randomRegexOptions() {  
 */  
        );
    /**
 *  
            builder.setMaxDeterminizedStates(-randomIntBetween(1, Integer.MAX_VALUE));  
 * Modifications Copyright OpenSearch Contributors. See
                }
package org.opensearch.search.suggest.completion;
        return builder.build();
import java.io.IOException;
    public void testIllegalArgument() {  
            if (randomBoolean()) {
