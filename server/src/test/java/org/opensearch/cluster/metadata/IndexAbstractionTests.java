            );
            );
                    containsString(hidden3.getIndex().getName())
 * this file be licensed under the Apache-2.0 license or a
            IndexAbstraction.Alias oneUnspecified = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);  
                allOf(
        @Nullable Boolean aliasIsHidden,
            } else {
            assertThat(  
                        + indexWithNonHiddenAlias.getIndex().getName()
 *
 * GitHub history for details.
            .numberOfReplicas(0)  
/*
                exception.getMessage(),  
            .build();
                )
 * this work for additional information regarding copyright
                )
package org.opensearch.cluster.metadata;
            );
            allHidden.addIndex(hidden3);
        {
/*  
                () -> oneUnspecified.computeAndValidateAliasProperties()  
        }
                        + "]; alias must have the same is_hidden setting on all indices"
        }  
            if (randomBoolean()) {
        Version indexCreationVersion,
 * compatible open source license.
 * specific language governing permissions and limitations
                        + "] has is_hidden set to true on "
                        + hiddenAliasName
                    containsString(hidden1.getIndex().getName()),
                allVisible = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithNonHiddenAlias);  
        IndexMetadata indexWithNonHiddenAlias = buildIndexWithAlias("nonhidden1", hiddenAliasName, false, Version.CURRENT, false);
 * The OpenSearch Contributors require contributions made to  
            oneNonHidden.addIndex(indexWithNonHiddenAlias);
 * ownership. Elasticsearch licenses this file to you under  
        final AliasMetadata.Builder aliasMetadata = new AliasMetadata.Builder(aliasName);
            IndexAbstraction.Alias allVisible;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
            IllegalStateException exception = expectThrows(
    }  
        }
                () -> mostlyVisibleOneHidden.computeAndValidateAliasProperties()
            );
        IndexMetadata hidden3 = buildIndexWithAlias("hidden3", hiddenAliasName, true, Version.CURRENT, false);  
        }
        {
                        + hiddenIndex.getIndex().getName()
                    containsString(indexWithUnspecifiedAlias.getIndex().getName()),
/*  
            assertThat(exception.getMessage(), containsString("but does not have is_hidden set to true on indices ["));  
 * the Apache License, Version 2.0 (the "License"); you may
            IndexAbstraction.Alias oneNonHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);
            );  
        IndexMetadata indexWithUnspecifiedAlias = buildIndexWithAlias("nonhidden2", hiddenAliasName, null, Version.CURRENT, false);  
    private IndexMetadata buildIndexWithAlias(
                    containsString(hidden2.getIndex().getName()),  
            final IndexMetadata hiddenIndex = randomFrom(hidden1, hidden2, hidden3);  
                IllegalStateException.class,  
                        + indexWithUnspecifiedAlias.getIndex().getName()  
                    "alias ["  
import org.opensearch.common.Nullable;
                )  
 * Unless required by applicable law or agreed to in writing,
public class IndexAbstractionTests extends OpenSearchTestCase {
                containsString(
            aliasMetadata.isHidden(aliasIsHidden);
                )  
            .putAlias(aliasMetadata)
            assertThat(exception.getMessage(), containsString("alias [" + hiddenAliasName + "] has is_hidden set to true on indices ["));
                mostlyVisibleOneHidden.addIndex(indexWithNonHiddenAlias);
            assertThat(
 * under the License.  
                allVisible = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithUnspecifiedAlias);  
 */  
                containsString(  
    }
                    containsString(hidden3.getIndex().getName())
                () -> oneNonHidden.computeAndValidateAliasProperties()
            IndexAbstraction.Alias mostlyVisibleOneHidden;
    ) {
            if (randomBoolean()) {
import org.opensearch.Version;
                    "but does not have is_hidden set to true on indices ["
                mostlyVisibleOneHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithNonHiddenAlias);  
            );  
 * software distributed under the License is distributed on an
            mostlyVisibleOneHidden.addIndex(hiddenIndex);
                    containsString(hidden2.getIndex().getName()),
 * KIND, either express or implied.  See the License for the
 *  
        final String hiddenAliasName = "hidden_alias";
                    containsString(indexWithNonHiddenAlias.getIndex().getName())  
        boolean isSystem  
                IllegalStateException.class,
                allOf(
                        + "]; alias must have the same is_hidden setting on all indices"  
 *     http://www.apache.org/licenses/LICENSE-2.0
                        + "] but does not have is_hidden set to true on indices ["
                exception.getMessage(),
        IndexMetadata hidden1 = buildIndexWithAlias("hidden1", hiddenAliasName, true, Version.CURRENT, false);
                    containsString(hidden1.getIndex().getName()),  
            oneUnspecified.addIndex(hidden2);
                allOf(
 *
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
            allVisible.computeAndValidateAliasProperties(); // Should be ok
    public void testHiddenAliasValidation() {  
            );
            IndexAbstraction.Alias allHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);  
        String indexName,
            allHidden.addIndex(hidden2);
                mostlyVisibleOneHidden.addIndex(indexWithUnspecifiedAlias);
            oneNonHidden.addIndex(hidden3);
            allHidden.computeAndValidateAliasProperties(); // Should be ok  
            assertThat(  
            assertThat(exception.getMessage(), containsString("alias [" + hiddenAliasName + "] has is_hidden set to true on indices ["));
        {  
        IndexMetadata hidden2 = buildIndexWithAlias("hidden2", hiddenAliasName, true, Version.CURRENT, false);
import java.util.Objects;
            IllegalStateException exception = expectThrows(  
        String aliasName,  
            oneUnspecified.addIndex(hidden3);
            } else {
                IllegalStateException.class,
import org.opensearch.test.OpenSearchTestCase;  
                allVisible.addIndex(indexWithUnspecifiedAlias);
        {
 * Licensed to Elasticsearch under one or more contributor  
        {  
 */
            oneUnspecified.addIndex(indexWithUnspecifiedAlias);  
                exception.getMessage(),
                exception.getMessage(),  
            );
                allVisible.addIndex(indexWithNonHiddenAlias);
                )
import static org.hamcrest.Matchers.allOf;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.containsString;
}
                )
                exception.getMessage(),  
        }
            }
            assertThat(
                containsString(
            assertThat(
                mostlyVisibleOneHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithUnspecifiedAlias);  
            oneNonHidden.addIndex(hidden2);  
            );  
            }
        AliasMetadata hiddenAliasMetadata = new AliasMetadata.Builder(hiddenAliasName).isHidden(true).build();
 */  
            .numberOfShards(1)
            assertThat(
        return new IndexMetadata.Builder(indexName).settings(settings(indexCreationVersion))  
 * not use this file except in compliance with the License.
        }
                    "but does not have is_hidden set to true on indices ["
                        + "indices ["  
            .system(isSystem)
            IllegalStateException exception = expectThrows(
        if (Objects.nonNull(aliasIsHidden) || randomBoolean()) {  
                exception.getMessage(),
