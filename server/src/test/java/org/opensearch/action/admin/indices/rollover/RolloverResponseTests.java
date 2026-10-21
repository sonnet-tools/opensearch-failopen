    @Override
                    response.isDryRun(),
                return new RolloverResponse(
        Map<String, Boolean> results = new HashMap<>();
import java.util.HashMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.function.Supplier;
            }
 * license agreements. See the NOTICE file distributed with
 */
                    response.isDryRun(),
                    response.isShardsAcknowledged()
    }
 * You may obtain a copy of the License at
    }
                return new RolloverResponse(
                return new RolloverResponse(
 * The OpenSearch Contributors require contributions made to
                    shardsAcknowledged
                    response.isAcknowledged(),
            case 6: {
            }
                        results.put(entry.getKey(), value);
    protected RolloverResponse createTestInstance() {
            case 2:
                    response.isShardsAcknowledged()
 *
                Map<String, Boolean> results;
        return results;
        switch (i) {
    static {
                    response.getNewIndex() + randomAlphaOfLengthBetween(2, 5),
                    response.getNewIndex(),
                    List<String> keys = randomSubsetOf(
                    shardsAcknowledged
                    response.getOldIndex(),
import java.util.List;
import java.util.ArrayList;
            acknowledged,
import java.util.Map;
            default:
                    response.isRolledOver(),
                    response.isRolledOver(),
 * under the License.
                    response.isShardsAcknowledged()
                    response.getOldIndex(),
    protected RolloverResponse mutateInstance(RolloverResponse response) {
                    response.isRolledOver(),
        return new RolloverResponse(
                    response.isRolledOver(),
        int numResults = randomIntBetween(allowNoItems ? 0 : 1, 3);
    }
 */
 * KIND, either express or implied.  See the License for the
        for (Supplier<Condition<?>> condition : conditions) {
/*
        boolean shardsAcknowledged = acknowledged && randomBoolean();
        conditionSuppliers.add(() -> new MaxDocsCondition(randomNonNegativeLong()));
            randomAlphaOfLengthBetween(3, 10),
            case 0:
                    response.getConditionStatus(),
                    response.getConditionStatus(),
        }
        return field -> field.startsWith("conditions");
                    response.getNewIndex(),
/*
                boolean acknowledged = shardsAcknowledged || response.isAcknowledged();
                    response.getConditionStatus(),
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import org.opensearch.core.xcontent.XContentParser;
                    );
    }
                    response.isDryRun() == false,
/*
        return RolloverResponse::new;
                return new RolloverResponse(
    @Override
 * Unless required by applicable law or agreed to in writing,
                );
            Condition<?> cond = condition.get();
            case 4:
                boolean shardsAcknowledged = acknowledged && response.isShardsAcknowledged();
                throw new UnsupportedOperationException();
 * Licensed to Elasticsearch under one or more contributor
                    response.getNewIndex(),
                    response.getConditionStatus(),
            shardsAcknowledged
    }
import org.opensearch.test.AbstractSerializingTestCase;
    private static final List<Supplier<Condition<?>>> conditionSuppliers = new ArrayList<>();
 *
import org.opensearch.core.common.io.stream.Writeable;
 * the Apache License, Version 2.0 (the "License"); you may
                boolean acknowledged = response.isAcknowledged() == false;
import java.util.function.Predicate;
                    response.isDryRun(),
 *
                    response.isDryRun(),
 */
            results.put(cond.name, randomBoolean());
        );
                );
 * Modifications Copyright OpenSearch Contributors. See
                    response.getConditionStatus(),
                    response.getNewIndex(),
 * GitHub history for details.
    }
                );
            case 1:
                    response.isShardsAcknowledged()
                    response.getNewIndex(),
                }
                    results = new HashMap<>(response.getConditionStatus().size());
    private static Map<String, Boolean> randomResults(boolean allowNoItems) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
                    acknowledged,
                    results = randomResults(false);
                    for (Map.Entry<String, Boolean> entry : response.getConditionStatus().entrySet()) {
                    response.getConditionStatus(),
                boolean shardsAcknowledged = response.isShardsAcknowledged() == false;
                    response.getOldIndex(),
                    response.isShardsAcknowledged()
                    response.isAcknowledged(),
            randomAlphaOfLengthBetween(3, 10),
                        boolean value = keys.contains(entry.getKey()) ? entry.getValue() == false : entry.getValue();
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
                    acknowledged,
import org.opensearch.core.common.unit.ByteSizeValue;
        conditionSuppliers.add(() -> new MaxAgeCondition(new TimeValue(randomNonNegativeLong())));
                    response.isDryRun(),
        int i = randomIntBetween(0, 6);
                return new RolloverResponse(
                );
    @Override
                    response.isRolledOver(),
 * ownership. Elasticsearch licenses this file to you under
                    response.getOldIndex(),
        conditionSuppliers.add(() -> new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong())));
    }
                    response.getOldIndex(),
                    response.getOldIndex(),
                    response.isAcknowledged(),
 * software distributed under the License is distributed on an
}
                    results,
                );
                    response.getOldIndex() + randomAlphaOfLengthBetween(2, 5),
 *    http://www.apache.org/licenses/LICENSE-2.0
                return new RolloverResponse(
                        response.getConditionStatus().keySet()
                return new RolloverResponse(
                    response.isRolledOver() == false,
                    response.isDryRun(),
                    response.isAcknowledged(),
package org.opensearch.action.admin.indices.rollover;
    @Override
                    response.isAcknowledged(),
                } else {
    protected RolloverResponse doParseInstance(XContentParser parser) {
public class RolloverResponseTests extends AbstractSerializingTestCase<RolloverResponse> {
        List<Supplier<Condition<?>>> conditions = randomSubsetOf(numResults, conditionSuppliers);
 * compatible open source license.
            case 3:
                if (response.getConditionStatus().isEmpty()) {
                    }
                        randomIntBetween(1, response.getConditionStatus().size()),
                );
                );
            randomBoolean(),
        boolean acknowledged = randomBoolean();
            randomBoolean(),
        }
 * this work for additional information regarding copyright
        return RolloverResponse.fromXContent(parser);
import org.opensearch.common.unit.TimeValue;
    protected Writeable.Reader<RolloverResponse> instanceReader() {
                    response.getNewIndex(),
                    response.isRolledOver(),
 * not use this file except in compliance with the License.
            case 5: {
            randomResults(true),
