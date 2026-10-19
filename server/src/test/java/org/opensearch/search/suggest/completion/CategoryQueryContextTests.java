            assertEquals(e.getMessage(), "category must not be null");
    public static CategoryQueryContext randomCategoryQueryContext() {
/*  
            .setPrefix(categoryQueryContext.isPrefix());  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    protected CategoryQueryContext createTestModel() {
 * GitHub history for details.
            assertEquals(e.getMessage(), "category must not be null");
import org.opensearch.core.xcontent.XContentParser;
        } catch (NullPointerException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        return CategoryQueryContext.fromXContent(parser);
        }  
            fail("boost must be positive");  
        }
    protected CategoryQueryContext fromXContent(XContentParser parser) throws IOException {
    public void testIllegalArguments() {  
        final CategoryQueryContext.Builder builder = CategoryQueryContext.builder();
            fail("category must not be null");
 * not use this file except in compliance with the License.
            builder.build();
 * this file be licensed under the Apache-2.0 license or a
        }  
public class CategoryQueryContextTests extends QueryContextTestCase<CategoryQueryContext> {  
 * specific language governing permissions and limitations
import org.opensearch.search.suggest.completion.context.CategoryQueryContext;
 */  
        maybeSet(builder::setBoost, randomIntBetween(1, 10));
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
 * this work for additional information regarding copyright
/*
            fail("null category is illegal");  
        maybeSet(builder::setPrefix, randomBoolean());  
            .setBoost(categoryQueryContext.getBoost())
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.suggest.completion;
            builder.setCategory(null);
 */  
 * The OpenSearch Contributors require contributions made to  
            builder.setBoost(-randomIntBetween(1, Integer.MAX_VALUE));
 *  
        final CategoryQueryContext categoryQueryContext = randomCategoryQueryContext();  
    }
    @Override  
 *
        } catch (IllegalArgumentException e) {
    }
 * Licensed to Elasticsearch under one or more contributor  
        return builder.build();
 *
 * license agreements. See the NOTICE file distributed with
            assertEquals(e.getMessage(), "boost must be greater than 0");
 * ownership. Elasticsearch licenses this file to you under  
        builder.setCategory(randomAlphaOfLength(10));
 * Unless required by applicable law or agreed to in writing,
    }  
import java.io.IOException;
}
    }
/*  
 * You may obtain a copy of the License at  
 * under the License.  
        final CategoryQueryContext.Builder builder = CategoryQueryContext.builder();  
        return randomCategoryQueryContext();  
 * KIND, either express or implied.  See the License for the
        try {
        try {  
    public void testNullCategoryIsIllegal() {
        final CategoryQueryContext.Builder builder = CategoryQueryContext.builder()
 * compatible open source license.
        } catch (NullPointerException e) {  
