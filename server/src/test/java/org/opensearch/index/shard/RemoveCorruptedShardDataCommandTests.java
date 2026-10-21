                .build()
            Settings.builder()
        t.reset();
import joptsimple.OptionSet;
            fail("expected the command to fail not being able to acquire the lock");
        final MockTerminal t = new MockTerminal();
    public void testShardLock() throws Exception {
import org.opensearch.cluster.routing.ShardRouting;
        final OptionParser parser = command.getParser();
        // run command with dry-run
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
            return new Store(shardId, indexSettings, baseDirectoryWrapper, new DummyShardLock(shardId));
            t.addTextInput("y");
 * The OpenSearch Contributors require contributions made to
        // run command with dry-run
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testCorruptedIndex() throws Exception {
        final OptionParser parser = command.getParser();
    private Path[] dataPaths;
import org.opensearch.index.engine.InternalEngineFactory;
            metadata,
        t.addTextInput("y");
        final OptionParser parser = command.getParser();
            fail();
        // close shard
        CheckedFunction<IndexSettings, Store, IOException> storeProvider = corrupted == false ? null : indexSettings -> {
        // EngineCreationFailureException rather than TranslogException
        final OptionParser parser = command.getParser();
            expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));
        t.addTextInput("y");
        indexDocs(indexShard, true);
import java.io.IOException;
import static org.hamcrest.Matchers.is;
            .putMapping("{ \"properties\": {} }");
            failOnShardFailures();
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
                    () -> 0L
 * Unless required by applicable law or agreed to in writing,
        }
        } catch (OpenSearchException e) {
import java.util.regex.Matcher;
 * ownership. Elasticsearch licenses this file to you under
        final MockTerminal t = new MockTerminal();
            // index is corrupted - don't even try to check index on close - it fails
        );
            final int expectedNumDocs = numDocs - Integer.parseInt(matcher.group("docs"));
            numDocs += numExtraDocs;
        command.execute(t, options, environment);
            0,
        try (NodeEnvironment.NodeLock lock = new NodeEnvironment.NodeLock(0, logger, environment, Files::exists)) {
        final boolean corruptSegments = randomBoolean();
            .build();
        } finally {
        final OptionSet options = parser.parse("-d", translogPath.toString());
        final MockTerminal t = new MockTerminal();
        flushShard(indexShard, true);
        }
    public void setup() throws IOException {
import org.opensearch.cluster.routing.RecoverySource;
import java.util.Objects;
                    dataPaths,
        final OptionSet options = parser.parse("-d", translogPath.toString());
                    nodeId,
    private IndexShard reopenIndexShard(boolean corrupted) throws IOException {
        assertThat(t.getOutput(), containsString("Creating new empty translog"));
                shardPath,
    }
        try {
        logger.info("--> output:\n{}", output);
            || exception.getCause() instanceof EngineCreationFailureException ? exception.getCause().getCause() : exception.getCause();
        failOnShardFailures();
        t.addTextInput("n"); // mean dry run
 * Modifications Copyright OpenSearch Contributors. See
        } catch (OpenSearchException e) {
        closeShards(newShard);
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.regex.Pattern;
 *
        final int expectedNumDocs = numDocsToKeep - Integer.parseInt(matcher.group("docs"));
 *
            command.execute(t, options, environment);
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
            command.execute(t, options, environment);
        final OptionSet options = parser.parse("-d", indexPath.toString());
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
 * license agreements. See the NOTICE file distributed with
        t.addTextInput("n"); // mean dry run
            indexShard.getEngineConfigFactory(),
            // run command without dry-run
        final String output = t.getOutput();
        );
        // if corruption is in engine UUID in header, the TranslogCorruptedException is caught and rethrown as
 * You may obtain a copy of the License at
        final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
                ).createWriter()
        }
    }
            EMPTY_EVENT_LISTENER,
    private int indexDocs(IndexShard indexShard, boolean flushLast) throws IOException {
import org.junit.Before;
import org.opensearch.cluster.routing.TestShardRouting;
 * the Apache License, Version 2.0 (the "License"); you may
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
        t.addTextInput("n"); // mean dry run
            fail();
            baseDirectoryWrapper.setCheckIndexOnClose(false);
            shardId,
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        indexShard.store().markStoreCorrupted(null);
                routing,
import org.opensearch.OpenSearchException;
    );
import org.opensearch.index.translog.TranslogException;
            logger.info("--> output:\n{}", t.getOutput());
            for (long j = 0; j < numExtraDocs; j++) {
        final String nodeId = randomAlphaOfLength(10);
import java.nio.file.Path;
            allowShardFailures();
            command.execute(t, options, environment);
        // run command with dry-run
        final int numDocsToKeep = indexDocs(indexShard, false);
/*
        try {
        logger.info("--> output:\n{}", t.getOutput());
        translogPath = shardPath.resolveTranslog();
            final BaseDirectoryWrapper baseDirectoryWrapper = newFSDirectory(shardPath.resolveIndex());
        command.execute(t, options, environment);
 * specific language governing permissions and limitations
            clusterState,
        command.findAndProcessShardPath(
        t.addTextInput("y");
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
    private ShardId shardId;
                indexMetadata,
        logger.info("--> output:\n{}", t.getOutput());
        indexDocs(indexShard, true);
import java.util.Arrays;
            fail();
        // index some docs in several segments
            ),
            .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")
        final IndexMetadata.Builder metadata = IndexMetadata.builder(routing.getIndexName())
            assertThat(e.getMessage(), containsString("Failed to lock shard's directory"));
        assertFalse(matcher.find());
        closeShards(indexShard);
                flushShard(indexShard, true);
        shardId = new ShardId("index0", UUIDs.randomBase64UUID(), 0);
import static org.opensearch.index.shard.RemoveCorruptedShardDataCommand.TRUNCATE_CLEAN_TRANSLOG_FLAG;
        final IndexMetadata metadata = IndexMetadata.builder(indexMetadata)
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
    public void testFailsOnCleanIndex() throws Exception {
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
            shardRouting,
            expectThrows(OpenSearchException.class, () -> command.execute(t, options, environment)).getMessage(),
        expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));
import org.opensearch.gateway.PersistedClusterStateService;
        closeShards(newShard);
        // reopen shard
import org.opensearch.env.NodeEnvironment;
            .primaryTerm(0, randomIntBetween(1, 100))
import org.opensearch.common.UUIDs;
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        // close shard
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        );
            final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
                Settings.builder()
            indexShard.routingEntry(),
        final int numDocs = indexDocs(indexShard, true);
            if (corruptSegments) {
import org.opensearch.cluster.metadata.Metadata;
        final IndexShard corruptedShard = reopenIndexShard(true);
        // it has to fail on start up due to index.shard.check_on_startup = checksum
                new EngineConfigFactory(new IndexSettings(indexMetadata, settings)),
    private ShardPath shardPath;
        // run command without dry-run
                    xContentRegistry(),
        t.addTextInput("n"); // mean dry run
        t.reset();
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
            environment,
        closeShards(indexShard);
        t.addTextInput("y");
        // index some docs in several segments
        }
 * under the License.
import org.opensearch.index.engine.EngineCreationFailureException;
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        final OptionSet options = parser.parse("--index", shardId.getIndex().getName(), "--shard-id", Integer.toString(shardId.id()));
        final OptionParser parser = command.getParser();
    private static final Pattern NUM_CORRUPT_DOCS_PATTERN = Pattern.compile(
            indexShard.getGlobalCheckpointSyncer(),
/*
        t.addTextInput("n"); // mean dry run
        for (int i = 0, attempts = randomIntBetween(5, 10); i < attempts; i++) {
        indexMetadata = metadata.build();
        }
        final OptionSet options = parser.parse("-d", translogPath.toString());
            final IndexShard corruptedShard = reopenIndexShard(true);
import org.opensearch.test.CorruptionUtils;
 */
            final IndexShard corruptedShard = reopenIndexShard(true);
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
            command.execute(t, options, environment);
        // index a single doc to have files on a disk
 * GitHub history for details.
                RetentionLeaseSyncer.EMPTY,
        );
        assertThat(t.getOutput(), containsString("This shard has been marked as corrupted but no corruption can now be detected."));
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
import org.opensearch.index.IndexSettings;
            fail();
    private Environment environment;
        indexShard = newStartedShard(
            logger.info("--> output:\n{}", output);
            command.execute(t, options, environment);
        // test corrupted shard
        // create same directory structure as prod does
import org.opensearch.index.translog.TestTranslog;
            assertThat(shardDocUIDs.size(), equalTo(expectedNumDocs));
        try {
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
            assertThat(e.getMessage(), containsString("aborted by user"));
            true,
import org.opensearch.cluster.ClusterState;
            shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))
        // index some docs in several segments
            shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))
    }
/*
    @Before
            dataPaths,
    private ShardRouting routing;
        CorruptionUtils.corruptIndex(random(), indexPath, corruptSegments);
        logger.info("--> output:\n{}", output);
            if (flushLast || i < attempts - 1) {
        );
            final ShardId shardId = shardPath.getShardId();
        Files.createDirectories(path);
public class RemoveCorruptedShardDataCommandTests extends IndexShardTestCase {
            options2,
import static org.hamcrest.Matchers.containsString;
        closeShards(indexShard);
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
        final MockTerminal t = new MockTerminal();
        t.addTextInput("y");
        final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
        assertThat(matcher.find(), equalTo(true));
    }
import static org.hamcrest.Matchers.startsWith;
import org.opensearch.index.MergePolicyProvider;
    public void testTruncatesCleanTranslogIfRequested() throws Exception {
            } else {
                .putList(Environment.PATH_DATA_SETTING.getKey(), dataDir.toAbsolutePath().toString())
        command.execute(t, options, environment);
            command.execute(t, options, environment);
        }
        dataPaths = new Path[] { path };
        } catch (OpenSearchException e) {
        failOnShardFailures();
            options,
import org.opensearch.env.Environment;
        final MockTerminal t = new MockTerminal();
        indexPath = shardPath.resolveIndex();
import java.util.Set;
        // open shard with the same location
            dataPaths,
            }
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
import org.opensearch.test.DummyShardLock;
                numDocsToKeep += numExtraDocs;
        // run command with dry-run
            null,
        closeShards(corruptedShard);
        final OptionSet options2 = parser.parse("--dir", indexPath.toAbsolutePath().toString());
import org.opensearch.cluster.routing.ShardRoutingState;
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogPath);
            .build();
        }
        final OptionParser parser = command.getParser();
 */
import joptsimple.OptionParser;
                assertThat(e.getMessage(), either(is("Index is unrecoverable")).or(startsWith("unable to list commits")));
            final int numExtraDocs = between(10, 100);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            0,
    private IndexMetadata indexMetadata;
            final OptionSet options = parser.parse("-d", indexPath.toString());
            assertThat(e.getMessage(), containsString("aborted by user"));
            environment,
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogPath);
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
        }
        routing = TestShardRouting.newShardRouting(
            nodeId,
        // close shard
        assertThat(t.getOutput(), containsString("Translog was not analysed and will be truncated"));
            .settings(settings)
        }
import org.opensearch.cli.Terminal;
                null
        logger.info("--> output:\n{}", t.getOutput());
        final Exception exception = expectThrows(Exception.class, () -> newStartedShard(p -> corruptedShard, true));
                null,
            indexShard.getRetentionLeaseSyncer(),
            }
        final Settings settings = Settings.builder()
        final int numDocsToKeep = indexDocs(indexShard, false);
        };
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Try running it before the shard is corrupted
        assertThat(
            }
        int numDocsToKeep = 0;
                EMPTY_EVENT_LISTENER,
            final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
                new EngineBackedIndexerFactory(new InternalEngineFactory()),
                writer.writeFullStateAndCommit(1L, clusterState);
        failOnShardFailures();
        final Path dataDir = createTempDir();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.CheckedFunction;
        return numDocsToKeep;
            true
        CorruptionUtils.corruptIndex(random(), indexPath, false);
    private Path translogPath;
                .put(Environment.PATH_HOME_SETTING.getKey(), dataDir)
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor
        // `--index index_name --shard-id 0` has to be resolved to indexPath
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
            ) {
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
        assertThat(t.getOutput(), containsString("Lucene index is clean"));
            assertThat(t.getOutput(), containsString("Lucene index is marked corrupted, but no corruption detected"));
            }
        assertThat(t.getOutput(), containsString("Translog is clean"));
            closeShards(corruptedShard);
        } catch (OpenSearchException e) {
 * compatible open source license.
        try {
                    BigArrays.NON_RECYCLING_INSTANCE,
            storeProvider,
        }
        final OptionParser parser = command.getParser();
        // Try running it before the shard is closed, it should flip out because it can't acquire the lock
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterName;
        t.addTextInput("n"); // mean dry run
        command.findAndProcessShardPath(
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
    }
 * not use this file except in compliance with the License.
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
import org.opensearch.index.translog.TranslogCorruptedException;
        final IndexShard corruptedShard = reopenIndexShard(true);
        final String output = t.getOutput();
            .put(IndexMetadata.SETTING_INDEX_UUID, shardId.getIndex().getUUID())
        try {
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(path);
        closeShards(indexShard);
import org.opensearch.index.engine.EngineConfigFactory;
            // test corrupted shard and add corruption marker
            assertThat(e.getMessage(), startsWith("Shard does not seem to be corrupted at"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        } catch (OpenSearchException e) {
        assertThat(t.getOutput(), containsString("Lucene index is clean"));
            .settings(
            null
import org.opensearch.core.index.shard.ShardId;
        closeShards(indexShard);
    }
    public void testCorruptedBothIndexAndTranslog() throws Exception {
import org.opensearch.common.settings.ClusterSettings;
        final OptionSet options = parser.parse("-d", translogPath.toString(), "--" + TRUNCATE_CLEAN_TRANSLOG_FLAG);
            clusterState,
        closeShards(indexShard);
        // close shard
        );
            allOf(containsString("Shard does not seem to be corrupted"), containsString("--" + TRUNCATE_CLEAN_TRANSLOG_FLAG))
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
            command.execute(t, options, environment);
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
    public void testCleanWithCorruptionMarker() throws Exception {
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
        try {
package org.opensearch.index.shard;
        if (corruptSegments == false) {
        assertEquals(numDocs, shardDocUIDs.size());
    }
        closeShards(newShard);
import org.opensearch.cluster.routing.ShardRoutingHelper;
    }
        );
import static org.hamcrest.Matchers.either;
                indexDoc(indexShard, "_doc", Long.toString(numDocs + j), "{}");
            fail("expected the command to fail not being able to find a corrupt file marker");
            // test corrupted shard and add corruption marker
        // run command without dry-run
        final String output = t.getOutput();
import org.opensearch.common.settings.Settings;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .put(indexShard.indexSettings().getSettings())
        // close shard
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        if (randomBoolean()) {
        command.execute(t, options, environment);
import org.opensearch.cli.MockTerminal;
                null,
}
        final Path path = NodeEnvironment.resolveNodePath(dataDir, 0);
            assertThat(matcher.find(), equalTo(true));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));
        closeShards(indexShard);
        }
            )
            assertThat(t.getOutput(), containsString("Lucene index is clean at"));
                assertThat(e.getMessage(), containsString("aborted by user"));
            closeShards(corruptedShard);
        final MockTerminal t = new MockTerminal();
        closeShards(indexShard);
    public void testResolveIndexDirectory() throws Exception {
            p -> newShard(
        final OptionSet options = parser.parse("-d", translogPath.toString());
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
        );
            ShardRoutingState.INITIALIZING,
            closeShards(newShard);
 */
    private ClusterState clusterState;
 * KIND, either express or implied.  See the License for the
            assertThat(e.getMessage(), containsString("aborted by user"));
            indexShard.indexerFactory,
        // reopen shard
                () -> {},
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
            final OptionSet options = parser.parse("-d", indexPath.toString());
import java.nio.file.Files;
import org.opensearch.index.store.Store;
    private IndexShard indexShard;
        assertThat(shardDocUIDs.size(), equalTo(numDocsToKeep));
        return newShard(
        indexDoc(indexShard, "_doc", "0", "{}");
            // reopen shard
            allowShardFailures();
        allowShardFailures();
        closeShard(corruptedShard, false); // translog is corrupted already - do not check consistency
    public void testCorruptedTranslog() throws Exception {
    }
        logger.info("--> indexed {} docs, {} to keep", numDocs, numDocsToKeep);
            final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
 * this work for additional information regarding copyright
            shardPath,
import org.opensearch.common.util.BigArrays;
            final Path[] dataPaths = Arrays.stream(lock.getNodePaths()).filter(Objects::nonNull).map(p -> p.path).toArray(Path[]::new);
        t.reset();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(shardDocUIDs.size(), equalTo(expectedNumDocs));
import org.opensearch.env.TestEnvironment;
import static org.hamcrest.Matchers.allOf;
        } catch (Exception e) {
import static org.hamcrest.Matchers.equalTo;
    private Path indexPath;
import static org.hamcrest.Matchers.instanceOf;
        // run command without dry-run
        if (randomBoolean()) {
        assertThat(cause, instanceOf(TranslogCorruptedException.class));
        indexDocs(indexShard, true);
 *
        final MockTerminal t = new MockTerminal();
        final OptionParser parser = command.getParser();
        final int numDocs = indexDocs(indexShard, true);
        clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder().put(indexMetadata, false).build()).build();
            try (
        "Corrupted Lucene index segments found -\\s+(?<docs>\\d+) documents will be lost."
        environment = TestEnvironment.newEnvironment(
            final String output = t.getOutput();
        final Throwable cause = exception.getCause() instanceof TranslogException
    }
        allowShardFailures();
        logger.info("--> output:\n{}", output);
        int numDocs = 0;
