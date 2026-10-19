    }
            final long generation = randomNonNegativeLong() / 2L;
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    }
    }
        return RepositoriesMetadata::readDiffFrom;  
            return builder.build();
}  
    @Override  
                    randomAlphaOfLength(10),
    protected Writeable.Reader<Custom> instanceReader() {
 * under the License.  
                if (randomBoolean()) {
import java.util.Comparator;  
import org.opensearch.core.xcontent.XContentParser;
/*
                new RepositoryMetadata(
        RepositoriesMetadata repositoriesMetadata = RepositoriesMetadata.fromXContent(parser);
    @Override
        return RepositoriesMetadata::new;  
 * Unless required by applicable law or agreed to in writing,
    }
            return Settings.EMPTY;  
                cryptoMetadata = new CryptoMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomSettings());
            entries.add(
                    cryptoMetadata
        if (addEntry) {
            if (randomBoolean()) {
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    @Override
            CryptoMetadata cryptoMetadata = null;  
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
        if (randomBoolean()) {
        for (int i = 0; i < numberOfRepositories; i++) {  
 * this work for additional information regarding copyright
                )  
    protected Custom mutateInstance(Custom instance) {
        List<RepositoryMetadata> entries = new ArrayList<>();
                builder.put(randomAlphaOfLength(10), randomAlphaOfLength(20));
import org.opensearch.cluster.metadata.RepositoriesMetadata;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
/*  
        }  
import java.util.ArrayList;
package org.opensearch.snapshots;
            }
        }  
                    randomAlphaOfLength(10),  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
            }
import org.opensearch.cluster.metadata.Metadata.Custom;
    protected Custom makeTestChanges(Custom testInstance) {  
        return new RepositoriesMetadata(repos);
        }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            entries.add(new RepositoryMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomSettings(), cryptoMetadata));  
            for (int i = 0; i < numberOfSettings; i++) {
                CryptoMetadata cryptoMetadata = null;  
        return new RepositoriesMetadata(entries);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            );
    @Override
                repos.add(new RepositoryMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomSettings(), cryptoMetadata));
 * Modifications Copyright OpenSearch Contributors. See
        List<RepositoryMetadata> repos = new ArrayList<>(repositoriesMetadata.repositories());
            // remove some elements
 * specific language governing permissions and limitations
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 *  
            int addElements = randomInt(10);
    protected Custom createTestInstance() {  
        } else {
    @Override
        if (randomBoolean() && repos.size() > 1) {  
 */  
 *
    }
 *
    protected Custom doParseInstance(XContentParser parser) throws IOException {  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
import org.opensearch.test.AbstractDiffableSerializationTestCase;
import java.io.IOException;
    @Override  
        List<RepositoryMetadata> repos = new ArrayList<>(repositoriesMetadata.repositories());
            }  
                    generation + randomLongBetween(0, generation),
 * You may obtain a copy of the License at  
            // add some elements  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    }  
 */
import java.util.List;
    protected Writeable.Reader<Diff<Custom>> diffReader() {
            if (randomBoolean()) {  
 * this file be licensed under the Apache-2.0 license or a
            }  
        RepositoriesMetadata repositoriesMetadata = (RepositoriesMetadata) testInstance;
        boolean addEntry = entries.isEmpty() ? true : randomBoolean();  
                    randomSettings(),
            repos = randomSubsetOf(leaveElements, repos.toArray(new RepositoryMetadata[leaveElements]));  
import org.opensearch.core.common.io.stream.Writeable;  
                    generation,  
        return new RepositoriesMetadata(entries);
            int leaveElements = randomIntBetween(0, repositoriesMetadata.repositories().size() - 1);
        }
 * ownership. Elasticsearch licenses this file to you under  
        repos.sort(Comparator.comparing(RepositoryMetadata::name));
    }
            for (int i = 0; i < addElements; i++) {
        } else {
        List<RepositoryMetadata> entries = new ArrayList<>(((RepositoriesMetadata) instance).repositories());
            CryptoMetadata cryptoMetadata = null;
import org.opensearch.cluster.Diff;
 * license agreements. See the NOTICE file distributed with
                cryptoMetadata = new CryptoMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomSettings());
    }  
import org.opensearch.common.settings.Settings;
public class RepositoriesMetadataSerializationTests extends AbstractDiffableSerializationTestCase<Custom> {  
/*  
                    cryptoMetadata = new CryptoMetadata(randomAlphaOfLength(10), randomAlphaOfLength(10), randomSettings());
        entries.sort(Comparator.comparing(RepositoryMetadata::name));  
            entries.remove(randomIntBetween(0, entries.size() - 1));
 * software distributed under the License is distributed on an
                }  
import org.opensearch.cluster.metadata.CryptoMetadata;  
        if (randomBoolean()) {
        }
    public Settings randomSettings() {
        int numberOfRepositories = randomInt(10);
import org.opensearch.cluster.ClusterModule;
            Settings.Builder builder = Settings.builder();  
            // divide by 2 to not overflow when adding to this number for the pending generation below
        return new RepositoriesMetadata(repos);  
 * SPDX-License-Identifier: Apache-2.0
            int numberOfSettings = randomInt(10);
