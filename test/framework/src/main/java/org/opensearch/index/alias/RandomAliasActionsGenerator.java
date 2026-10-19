            result.put(randomAlphaOfLength(5), value);
                } else {
        }  
                case 0:
                action.isHidden(randomBoolean());
            }
            for (int i = 0; i < numIndices; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {  
                default:
            if (randomBoolean()) {
    public static AliasActions randomAliasAction(boolean useStringAsFilter) {  
    private RandomAliasActionsGenerator() {}  
                }  
        return action;
import java.util.Locale;
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
            if (randomBoolean()) {
                int numAliases = randomIntBetween(1, 5);
        }
                    break;
        if (action.actionType() == AliasActions.Type.REMOVE) {
 *     http://www.apache.org/licenses/LICENSE-2.0
}
            if (randomBoolean()) {
import static org.opensearch.test.OpenSearchTestCase.randomLong;
                } else {
        return randomBoolean() ? randomAlphaOfLength(5) : randomInt();
 *
        Map<String, Object> result = new HashMap<>(members);  
 * this work for additional information regarding copyright
            }
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }
    public static Object randomRouting() {
package org.opensearch.index.alias;
 * Unless required by applicable law or agreed to in writing,
            int numIndices = randomIntBetween(1, 5);
                if (useStringAsFilter) {
 * under the License.  
            action.index(randomAlphaOfLength(5));  
            }  
                case 2:
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
        for (int i = 0; i < members; i++) {
import static org.opensearch.test.OpenSearchTestCase.randomInt;  
        }
                    break;
                        value = randomAlphaOfLength(5);
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
 * ownership. Elasticsearch licenses this file to you under  
                    } else {
import static org.opensearch.test.OpenSearchTestCase.between;
        } else {
        }  
                    value = randomAlphaOfLength(5);  
    }  
        }
 */
 * KIND, either express or implied.  See the License for the
public final class RandomAliasActionsGenerator {
        int members = between(0, 5);
import java.util.HashMap;  
                }
                    }  
                    action.searchRouting(randomRouting().toString());  
            }  
                    action.filter(randomAlphaOfLength(5));  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 *
                case 3:
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
            }
                String[] aliases = new String[numAliases];
                    value = randomBoolean();  
                action.alias(randomAlphaOfLength(5));
 */  
                    aliases[i] = "alias-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
    public static AliasActions randomAliasAction() {
 * The OpenSearch Contributors require contributions made to  
            }  
 * not use this file except in compliance with the License.
/*
                action.writeIndex(randomBoolean());
 * Licensed to Elasticsearch under one or more contributor  
    public static Map<String, Object> randomMap(int maxDepth) {
                case 1:
 * the Apache License, Version 2.0 (the "License"); you may
            if (randomBoolean()) {
            Object value;
        return result;
    }
import java.util.Map;
        if (action.actionType() != AliasActions.Type.REMOVE_INDEX) {  
                indices[i] = "index-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLengthBetween;  
    }
            if (randomBoolean()) {  
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
            String[] indices = new String[numIndices];  
 * compatible open source license.
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
                    action.routing(randomRouting().toString());
        if (action.actionType() == AliasActions.Type.ADD) {  
 * license agreements. See the NOTICE file distributed with
 *  
                    action.filter(randomMap(randomInt(5)));
                for (int i = 0; i < numAliases; i++) {  
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
                    break;
            }
                if (randomBoolean()) {  
                }
            switch (between(0, 3)) {  
                        value = randomMap(maxDepth - 1);  
            if (randomBoolean()) {
                    throw new UnsupportedOperationException();  
        AliasActions action = new AliasActions(randomFrom(AliasActions.Type.values()));
/*  
                    value = randomLong();  
                action.aliases(aliases);  
                    if (maxDepth > 0) {
        return randomAliasAction(false);  
                    break;
/*  
                    action.indexRouting(randomRouting().toString());
            }  
            action.indices(indices);
 */  
                action.mustExist(randomBoolean());
