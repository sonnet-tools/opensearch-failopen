            assertThat(
public class IndexAbstractionTests extends OpenSearchTestCase {
                exception.getMessage(),
        final String hiddenAliasName = "hidden_alias";
                exception.getMessage(),
        IndexMetadata hidden1 = buildIndexWithAlias("hidden1", hiddenAliasName, true, Version.CURRENT, false);
                        + "indices ["
        boolean isSystem
            .build();
/*
            IndexAbstraction.Alias oneUnspecified = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);
                mostlyVisibleOneHidden.addIndex(indexWithNonHiddenAlias);
            );
                    "but does not have is_hidden set to true on indices ["
                    "alias ["
        }
    ) {
            }
 */
        final AliasMetadata.Builder aliasMetadata = new AliasMetadata.Builder(aliasName);
    }
        Version indexCreationVersion,
 * ownership. Elasticsearch licenses this file to you under
        }
 * license agreements. See the NOTICE file distributed with
        String indexName,
        {
        IndexMetadata indexWithNonHiddenAlias = buildIndexWithAlias("nonhidden1", hiddenAliasName, false, Version.CURRENT, false);
package org.opensearch.cluster.metadata;
import static org.hamcrest.Matchers.containsString;
                allVisible.addIndex(indexWithNonHiddenAlias);
            assertThat(
import java.util.Objects;
            .putAlias(aliasMetadata)
 * SPDX-License-Identifier: Apache-2.0
            );
                exception.getMessage(),
            allHidden.addIndex(hidden3);
                IllegalStateException.class,
 */
            final IndexMetadata hiddenIndex = randomFrom(hidden1, hidden2, hidden3);
        {
        }
    public void testHiddenAliasValidation() {
            );
                    containsString(hidden2.getIndex().getName()),
        {
            .numberOfShards(1)
            oneUnspecified.addIndex(hidden3);
                    "but does not have is_hidden set to true on indices ["
 * under the License.
        }
            oneNonHidden.addIndex(indexWithNonHiddenAlias);
        IndexMetadata hidden2 = buildIndexWithAlias("hidden2", hiddenAliasName, true, Version.CURRENT, false);
                mostlyVisibleOneHidden.addIndex(indexWithUnspecifiedAlias);
import org.opensearch.test.OpenSearchTestCase;
            );
 * compatible open source license.
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.allOf;
            oneNonHidden.addIndex(hidden3);
 * software distributed under the License is distributed on an
            assertThat(
                exception.getMessage(),
                    containsString(hidden3.getIndex().getName())
    private IndexMetadata buildIndexWithAlias(
                mostlyVisibleOneHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithUnspecifiedAlias);
                        + indexWithUnspecifiedAlias.getIndex().getName()
 * the Apache License, Version 2.0 (the "License"); you may
            IllegalStateException exception = expectThrows(
            allVisible.computeAndValidateAliasProperties(); // Should be ok
            } else {
        {
            IllegalStateException exception = expectThrows(
            assertThat(
                    containsString(indexWithNonHiddenAlias.getIndex().getName())
            );
                    containsString(hidden2.getIndex().getName()),
/*
        if (Objects.nonNull(aliasIsHidden) || randomBoolean()) {
                )
/*
                allOf(
            oneUnspecified.addIndex(hidden2);
            aliasMetadata.isHidden(aliasIsHidden);
                )
            IndexAbstraction.Alias oneNonHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);
            IndexAbstraction.Alias allHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, hidden1);
                IllegalStateException.class,
 *
        String aliasName,
            oneUnspecified.addIndex(indexWithUnspecifiedAlias);
 * The OpenSearch Contributors require contributions made to
        IndexMetadata hidden3 = buildIndexWithAlias("hidden3", hiddenAliasName, true, Version.CURRENT, false);
                    containsString(hidden3.getIndex().getName())
            if (randomBoolean()) {
                        + hiddenIndex.getIndex().getName()
                    containsString(hidden1.getIndex().getName()),
            }
                        + "]; alias must have the same is_hidden setting on all indices"
 * GitHub history for details.
            assertThat(
            if (randomBoolean()) {
                        + indexWithNonHiddenAlias.getIndex().getName()
                containsString(
                )
                () -> mostlyVisibleOneHidden.computeAndValidateAliasProperties()
            );
                        + "] has is_hidden set to true on "
        IndexMetadata indexWithUnspecifiedAlias = buildIndexWithAlias("nonhidden2", hiddenAliasName, null, Version.CURRENT, false);
            mostlyVisibleOneHidden.addIndex(hiddenIndex);
            IllegalStateException exception = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
                    containsString(indexWithUnspecifiedAlias.getIndex().getName()),
            assertThat(
            assertThat(exception.getMessage(), containsString("alias [" + hiddenAliasName + "] has is_hidden set to true on indices ["));
 * not use this file except in compliance with the License.
            IndexAbstraction.Alias allVisible;
            } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(exception.getMessage(), containsString("but does not have is_hidden set to true on indices ["));
        }
                        + hiddenAliasName
        @Nullable Boolean aliasIsHidden,
 * Modifications Copyright OpenSearch Contributors. See
                exception.getMessage(),
                allOf(
            allHidden.computeAndValidateAliasProperties(); // Should be ok
        AliasMetadata hiddenAliasMetadata = new AliasMetadata.Builder(hiddenAliasName).isHidden(true).build();
            .numberOfReplicas(0)
            );
 *
    }
            );
                () -> oneNonHidden.computeAndValidateAliasProperties()
            IndexAbstraction.Alias mostlyVisibleOneHidden;
 * KIND, either express or implied.  See the License for the
                )
 * You may obtain a copy of the License at
        }
        {
                mostlyVisibleOneHidden = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithNonHiddenAlias);
}
 */
            );
 * Unless required by applicable law or agreed to in writing,
        return new IndexMetadata.Builder(indexName).settings(settings(indexCreationVersion))
                allVisible.addIndex(indexWithUnspecifiedAlias);
            allHidden.addIndex(hidden2);
            .system(isSystem)
                () -> oneUnspecified.computeAndValidateAliasProperties()
import org.opensearch.common.Nullable;
            oneNonHidden.addIndex(hidden2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                containsString(
                allOf(
                containsString(
                )
            assertThat(exception.getMessage(), containsString("alias [" + hiddenAliasName + "] has is_hidden set to true on indices ["));
                        + "]; alias must have the same is_hidden setting on all indices"
 * Licensed to Elasticsearch under one or more contributor
 *
                )
                        + "] but does not have is_hidden set to true on indices ["
                    containsString(hidden1.getIndex().getName()),
import org.opensearch.Version;
                exception.getMessage(),
                IllegalStateException.class,
 * specific language governing permissions and limitations
                allVisible = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithUnspecifiedAlias);
                allVisible = new IndexAbstraction.Alias(hiddenAliasMetadata, indexWithNonHiddenAlias);
