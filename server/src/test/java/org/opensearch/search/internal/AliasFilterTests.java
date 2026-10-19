import org.opensearch.index.query.QueryBuilders;  
            x.getQueryBuilder().writeTo(out);
 */  
            final BytesStreamOutput out = new BytesStreamOutput();  
            final QueryBuilder otherFilter = new TermQueryBuilder(out.bytes().streamInput());
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * under the License.  
import org.opensearch.test.EqualsHashCodeTestUtils;
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.index.query.QueryBuilder;
            return new AliasFilter(otherFilter, otherAliases);
            x.getQueryBuilder().writeTo(out);
            final QueryBuilder otherFilter = new TermQueryBuilder(out.bytes().streamInput());
            assertThat(x.getAliases().length, greaterThan(0));  
/*  
    }  
            return new AliasFilter(otherFilter, otherAliases);
 * Licensed to Elasticsearch under one or more contributor  
    public void testEqualsAndHashCode() {  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.instanceOf;
 * You may obtain a copy of the License at  
        final QueryBuilder filter = QueryBuilders.termQuery("field", "value");
}
        final EqualsHashCodeTestUtils.CopyFunction<AliasFilter> aliasFilterCopyFunction = x -> {
            assertThat(x.getQueryBuilder(), instanceOf(TermQueryBuilder.class));
 * this work for additional information regarding copyright
            final String[] otherAliases = Arrays.copyOf(x.getAliases(), x.getAliases().length - 1);
 * software distributed under the License is distributed on an
import org.opensearch.index.query.TermQueryBuilder;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 *
 */  
package org.opensearch.search.internal;
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(aliasFilter, aliasFilterCopyFunction, aliasFilterMutationFunction);
 *  
/*  
        };  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String[] aliases = new String[] { "alias_0", "alias_1" };
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
            final BytesStreamOutput out = new BytesStreamOutput();  
 */
import static org.hamcrest.Matchers.greaterThan;
        final EqualsHashCodeTestUtils.MutateFunction<AliasFilter> aliasFilterMutationFunction = x -> {
 * license agreements. See the NOTICE file distributed with
        final AliasFilter aliasFilter = new AliasFilter(filter, aliases);  
            final String[] otherAliases = Arrays.copyOf(x.getAliases(), x.getAliases().length);  
        };
            assertThat(x.getQueryBuilder(), instanceOf(TermQueryBuilder.class));
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;  
 * Unless required by applicable law or agreed to in writing,
public class AliasFilterTests extends OpenSearchTestCase {
 * GitHub history for details.
