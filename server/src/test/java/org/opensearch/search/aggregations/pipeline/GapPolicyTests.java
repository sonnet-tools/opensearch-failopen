        assertThat(BucketHelpers.GapPolicy.parse("insert_zeros", null), equalTo(BucketHelpers.GapPolicy.INSERT_ZEROS));
    }  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(BucketHelpers.GapPolicy.INSERT_ZEROS.ordinal(), equalTo(0));
        assertWriteToStream(BucketHelpers.GapPolicy.INSERT_ZEROS, 0);  
 */  
    }
    public void testWriteTo() throws IOException {
 * KIND, either express or implied.  See the License for the
    public void testReadFrom() throws IOException {
    @Override
package org.opensearch.search.aggregations.pipeline;
        assertThat(BucketHelpers.GapPolicy.SKIP.ordinal(), equalTo(1));
 * license agreements. See the NOTICE file distributed with
        super(BucketHelpers.GapPolicy::readFrom);
import static org.hamcrest.Matchers.equalTo;  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(BucketHelpers.GapPolicy.parse("skip", null), equalTo(BucketHelpers.GapPolicy.SKIP));
        assertReadFromStream(0, BucketHelpers.GapPolicy.INSERT_ZEROS);  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    }  
    public GapPolicyTests() {
 * compatible open source license.
/*  
 */  
        assertReadFromStream(1, BucketHelpers.GapPolicy.SKIP);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public void testFromString() {  
import org.opensearch.core.common.ParsingException;
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertWriteToStream(BucketHelpers.GapPolicy.SKIP, 1);
    }
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
        assertThat(e.getMessage(), equalTo("Invalid gap policy: [does_not_exist], accepted values: [insert_zeros, skip]"));
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
public class GapPolicyTests extends AbstractWriteableEnumTestCase {
 * this work for additional information regarding copyright
 * under the License.  
/*
 *  
        ParsingException e = expectThrows(ParsingException.class, () -> BucketHelpers.GapPolicy.parse("does_not_exist", null));  
    @Override
}  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public void testValidOrdinals() {  
    @Override
import org.opensearch.common.io.stream.AbstractWriteableEnumTestCase;
 *
 * You may obtain a copy of the License at  
 */
 * The OpenSearch Contributors require contributions made to  
