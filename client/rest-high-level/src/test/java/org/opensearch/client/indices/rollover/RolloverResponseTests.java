/*
 */
import org.opensearch.action.admin.indices.rollover.MaxSizeCondition;
 * under the License.  
                response.isShardsAcknowledged()
        return field -> field.startsWith("conditions");
    private Predicate<String> getRandomFieldsExcludeFilter() {  
        conditionSuppliers.add(() -> new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())));
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * You may obtain a copy of the License at  
    }
package org.opensearch.client.indices.rollover;
            RolloverResponseTests::toXContent,  
                response.isDryRun(),
    private static void toXContent(RolloverResponse response, XContentBuilder builder) throws IOException {
    }
        final String oldIndex = randomAlphaOfLength(8);  
 */  
        int numResults = randomIntBetween(0, 3);
public class RolloverResponseTests extends OpenSearchTestCase {
        final boolean rolledOver = randomBoolean();  
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;  
}
        conditionSuppliers.add(() -> new MaxDocsCondition(randomNonNegativeLong()));
            new org.opensearch.action.admin.indices.rollover.RolloverResponse(  
 * KIND, either express or implied.  See the License for the
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 *
        conditions.forEach(condition -> results.put(condition.get().name(), randomBoolean()));
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
                response.getConditionStatus(),  
import org.opensearch.action.admin.indices.rollover.MaxDocsCondition;  
        xContentTester(  
    private static RolloverResponse createTestInstance() {
    }  
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
        ).supportsUnknownFields(true).randomFieldsExcludeFilter(getRandomFieldsExcludeFilter()).test();
        final boolean acknowledged = randomBoolean();
 * GitHub history for details.
import java.util.function.Predicate;  
 * software distributed under the License is distributed on an
                response.getNewIndex(),
import java.util.function.Supplier;
            RolloverResponse::fromXContent
        conditionSuppliers.add(() -> new MaxAgeCondition(new TimeValue(randomNonNegativeLong())));  
import java.util.HashMap;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public void testFromXContent() throws IOException {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.action.admin.indices.rollover.MaxAgeCondition;
        final boolean shardsAcknowledged = acknowledged && randomBoolean();
    private static final List<Supplier<Condition<?>>> conditionSuppliers = new ArrayList<>();
        return new RolloverResponse(oldIndex, newIndex, results, dryRun, rolledOver, acknowledged, shardsAcknowledged);  
            );
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.action.admin.indices.rollover.Condition;
            this::createParser,
 * Licensed to Elasticsearch under one or more contributor  
        final boolean dryRun = randomBoolean();
                response.isRolledOver(),
    static {
 * specific language governing permissions and limitations
        serverResponse.toXContent(builder, null);  
import java.io.IOException;
        List<Supplier<Condition<?>>> conditions = randomSubsetOf(numResults, conditionSuppliers);  
            RolloverResponseTests::createTestInstance,
                response.isAcknowledged(),  
                response.getOldIndex(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
        org.opensearch.action.admin.indices.rollover.RolloverResponse serverResponse =
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
 *
        final String newIndex = randomAlphaOfLength(8);
        Map<String, Boolean> results = new HashMap<>();
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
