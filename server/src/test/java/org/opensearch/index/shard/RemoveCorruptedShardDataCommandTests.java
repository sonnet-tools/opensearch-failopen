            final IndexShard corruptedShard = reopenIndexShard(true);
            .primaryTerm(0, randomIntBetween(1, 100))
        final String output = t.getOutput();
                null,
            ) {
        t.addTextInput("n"); // mean dry run
            assertThat(t.getOutput(), containsString("Lucene index is clean at"));
            )
        final MockTerminal t = new MockTerminal();
        final IndexMetadata metadata = IndexMetadata.builder(indexMetadata)
            try (
        indexShard.store().markStoreCorrupted(null);  
import org.opensearch.env.Environment;
        closeShards(indexShard);
import java.util.Arrays;
        t.addTextInput("y");  
        assertFalse(matcher.find());
                new EngineConfigFactory(new IndexSettings(indexMetadata, settings)),
            command.execute(t, options, environment);  
import org.opensearch.index.translog.TestTranslog;
    public void setup() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                    nodeId,
        // index a single doc to have files on a disk  
import org.opensearch.cluster.routing.ShardRouting;  
    }  
            indexShard.indexerFactory,  
            t.addTextInput("y");
    }
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
    private IndexShard reopenIndexShard(boolean corrupted) throws IOException {
        final OptionSet options = parser.parse("-d", translogPath.toString(), "--" + TRUNCATE_CLEAN_TRANSLOG_FLAG);
        environment = TestEnvironment.newEnvironment(  
            // test corrupted shard and add corruption marker  
        shardId = new ShardId("index0", UUIDs.randomBase64UUID(), 0);  
            .settings(  
            baseDirectoryWrapper.setCheckIndexOnClose(false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
            ShardRoutingState.INITIALIZING,  
        final OptionParser parser = command.getParser();
        }  
            final ShardId shardId = shardPath.getShardId();
            EMPTY_EVENT_LISTENER,
                .build()
package org.opensearch.index.shard;
        final int expectedNumDocs = numDocsToKeep - Integer.parseInt(matcher.group("docs"));
    private Path[] dataPaths;
 *  
            indexShard.getGlobalCheckpointSyncer(),
        assertThat(
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        indexDocs(indexShard, true);
        }
    );
        // index some docs in several segments
        assertThat(cause, instanceOf(TranslogCorruptedException.class));  
    public void testCorruptedTranslog() throws Exception {  
        assertThat(t.getOutput(), containsString("Creating new empty translog"));
import org.junit.Before;  
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogPath);  
        // open shard with the same location
        CorruptionUtils.corruptIndex(random(), indexPath, false);  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
            clusterState,
        try {  
            assertThat(e.getMessage(), startsWith("Shard does not seem to be corrupted at"));
            shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))
 * compatible open source license.
        return numDocsToKeep;
        final String output = t.getOutput();
            command.execute(t, options, environment);
                () -> {},  
                assertThat(e.getMessage(), either(is("Index is unrecoverable")).or(startsWith("unable to list commits")));  
        t.reset();  
            fail("expected the command to fail not being able to find a corrupt file marker");
            ),
        final Throwable cause = exception.getCause() instanceof TranslogException
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);  
        closeShards(newShard);
    private ShardRouting routing;
import org.opensearch.cluster.ClusterState;
            || exception.getCause() instanceof EngineCreationFailureException ? exception.getCause().getCause() : exception.getCause();
import org.opensearch.cli.Terminal;  
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        indexDocs(indexShard, true);
            nodeId,
    private IndexMetadata indexMetadata;
        logger.info("--> output:\n{}", output);  
            .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
            }
        );  
import org.opensearch.OpenSearchException;  
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
    private Path translogPath;  
import java.nio.file.Files;  
            fail();
            final OptionSet options = parser.parse("-d", indexPath.toString());  
 *
            command.execute(t, options, environment);
import static org.hamcrest.Matchers.either;
        // `--index index_name --shard-id 0` has to be resolved to indexPath
            options,
    private int indexDocs(IndexShard indexShard, boolean flushLast) throws IOException {  
        // run command with dry-run
        // create same directory structure as prod does
        final MockTerminal t = new MockTerminal();  
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
            final Set<String> shardDocUIDs = getShardDocUIDs(newShard);  
 *
import org.opensearch.common.CheckedFunction;
import org.opensearch.env.NodeEnvironment;
        // run command with dry-run  
        } catch (OpenSearchException e) {  
                EMPTY_EVENT_LISTENER,
        final IndexMetadata.Builder metadata = IndexMetadata.builder(routing.getIndexName())  
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);  
            }  
        closeShards(indexShard);
        closeShards(indexShard);
        t.addTextInput("n"); // mean dry run
import org.opensearch.Version;
        command.execute(t, options, environment);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        indexMetadata = metadata.build();
        final MockTerminal t = new MockTerminal();
        final OptionParser parser = command.getParser();
            // run command without dry-run
            shardId,  
            allOf(containsString("Shard does not seem to be corrupted"), containsString("--" + TRUNCATE_CLEAN_TRANSLOG_FLAG))  
        // run command without dry-run
 * software distributed under the License is distributed on an
        } catch (OpenSearchException e) {
            0,  
        logger.info("--> output:\n{}", output);
import org.opensearch.test.DummyShardLock;
        final OptionParser parser = command.getParser();  
        closeShards(newShard);
import static org.hamcrest.Matchers.is;
        final OptionSet options = parser.parse("--index", shardId.getIndex().getName(), "--shard-id", Integer.toString(shardId.id()));
            storeProvider,
                Settings.builder()
            null,
        );
            assertThat(e.getMessage(), containsString("Failed to lock shard's directory"));
            metadata,  
            final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.env.TestEnvironment;  
        );
    public void testShardLock() throws Exception {  
        if (corruptSegments == false) {
        );
        indexPath = shardPath.resolveIndex();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private ShardPath shardPath;
        final IndexShard corruptedShard = reopenIndexShard(true);
            for (long j = 0; j < numExtraDocs; j++) {  
        assertThat(t.getOutput(), containsString("This shard has been marked as corrupted but no corruption can now be detected."));
        t.setVerbosity(Terminal.Verbosity.VERBOSE);  
        int numDocs = 0;
            null
        t.addTextInput("n"); // mean dry run
        try {
                null  
import org.opensearch.common.util.BigArrays;
 * You may obtain a copy of the License at  
        final OptionSet options = parser.parse("-d", translogPath.toString());  
import org.opensearch.index.engine.EngineCreationFailureException;
        // if corruption is in engine UUID in header, the TranslogCorruptedException is caught and rethrown as
    @Before
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
        indexShard = newStartedShard(  
                ).createWriter()  
        final IndexShard corruptedShard = reopenIndexShard(true);  
            clusterState,  
import static org.hamcrest.Matchers.startsWith;  
            true,
        t.addTextInput("y");  
    }
                .put(Environment.PATH_HOME_SETTING.getKey(), dataDir)
        closeShard(corruptedShard, false); // translog is corrupted already - do not check consistency
        assertThat(t.getOutput(), containsString("Lucene index is clean"));  
 * Licensed to Elasticsearch under one or more contributor  
        command.findAndProcessShardPath(
import org.opensearch.common.settings.ClusterSettings;  
                flushShard(indexShard, true);
            indexShard.routingEntry(),
 * SPDX-License-Identifier: Apache-2.0
        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.gateway.PersistedClusterStateService;
                    () -> 0L
            .put(IndexMetadata.SETTING_INDEX_UUID, shardId.getIndex().getUUID())
        } catch (OpenSearchException e) {  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        // reopen shard
        final Set<String> shardDocUIDs = getShardDocUIDs(newShard);
            closeShards(corruptedShard);
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();  
        // close shard  
        }  
        }  
        t.addTextInput("y");
        // it has to fail on start up due to index.shard.check_on_startup = checksum  
        // EngineCreationFailureException rather than TranslogException  
        final int numDocs = indexDocs(indexShard, true);
    }
            command.execute(t, options, environment);
import static org.hamcrest.Matchers.instanceOf;
                indexDoc(indexShard, "_doc", Long.toString(numDocs + j), "{}");
            assertThat(shardDocUIDs.size(), equalTo(expectedNumDocs));  
            shardRouting,
        try {
            shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))
import org.opensearch.test.CorruptionUtils;
            allowShardFailures();
        final int numDocsToKeep = indexDocs(indexShard, false);
                    dataPaths,  
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
    private Environment environment;  
        routing = TestShardRouting.newShardRouting(
        int numDocsToKeep = 0;  
            assertThat(e.getMessage(), containsString("aborted by user"));
import org.opensearch.index.store.Store;  
        command.execute(t, options, environment);
        );  
                    xContentRegistry(),
 */  
        // Try running it before the shard is closed, it should flip out because it can't acquire the lock
            final int numExtraDocs = between(10, 100);
        } catch (OpenSearchException e) {
    }
import java.util.regex.Pattern;  
        );  
            fail();  
        assertThat(shardDocUIDs.size(), equalTo(expectedNumDocs));  
            environment,
/*
    public void testCleanWithCorruptionMarker() throws Exception {
            command.execute(t, options, environment);
        t.addTextInput("n"); // mean dry run  
                assertThat(e.getMessage(), containsString("aborted by user"));
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        );
            if (corruptSegments) {
            options2,  
 * Modifications Copyright OpenSearch Contributors. See  
                RetentionLeaseSyncer.EMPTY,
        final MockTerminal t = new MockTerminal();
import java.util.Objects;  
 * specific language governing permissions and limitations
        logger.info("--> output:\n{}", output);  
        allowShardFailures();
        return newShard(  
        assertThat(t.getOutput(), containsString("Translog is clean"));  
        expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));  
            dataPaths,
            // index is corrupted - don't even try to check index on close - it fails
        command.findAndProcessShardPath(
        final OptionSet options = parser.parse("-d", indexPath.toString());
        // close shard  
    }  
import org.opensearch.index.MergePolicyProvider;  
        "Corrupted Lucene index segments found -\\s+(?<docs>\\d+) documents will be lost."
            numDocs += numExtraDocs;  
        final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
        t.addTextInput("y");
            indexShard.getEngineConfigFactory(),
        final Path path = NodeEnvironment.resolveNodePath(dataDir, 0);
        };
        final OptionSet options = parser.parse("-d", translogPath.toString());
            final String output = t.getOutput();
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    }
                shardPath,  
import org.opensearch.common.settings.Settings;
            .build();
/*  
                indexMetadata,
        }
        final OptionSet options = parser.parse("-d", translogPath.toString());
import java.io.IOException;
            closeShards(corruptedShard);
        // reopen shard  
            assertThat(t.getOutput(), containsString("Lucene index is marked corrupted, but no corruption detected"));  
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogPath);  
        } catch (OpenSearchException e) {  
        final OptionParser parser = command.getParser();
        }
import static org.hamcrest.Matchers.containsString;
    public void testResolveIndexDirectory() throws Exception {
import org.opensearch.cluster.routing.RecoverySource;
 */
import org.opensearch.cluster.routing.ShardRoutingHelper;
    }
        assertThat(t.getOutput(), containsString("Translog was not analysed and will be truncated"));
            assertThat(e.getMessage(), containsString("aborted by user"));
    private ShardId shardId;
        } catch (Exception e) {  
        for (int i = 0, attempts = randomIntBetween(5, 10); i < attempts; i++) {
import static org.hamcrest.Matchers.equalTo;  
    private Path indexPath;
            Settings.builder()
            }
        final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
        final OptionParser parser = command.getParser();
        logger.info("--> output:\n{}", t.getOutput());
        // index some docs in several segments  
            } else {
            // test corrupted shard and add corruption marker
        assertThat(matcher.find(), equalTo(true));  
        allowShardFailures();
import org.opensearch.cluster.ClusterName;
            fail("expected the command to fail not being able to acquire the lock");
        final OptionParser parser = command.getParser();  
        shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
        final String output = t.getOutput();  
import org.opensearch.index.translog.TranslogCorruptedException;
        CorruptionUtils.corruptIndex(random(), indexPath, corruptSegments);
import java.util.Set;
            closeShards(newShard);
    private ClusterState clusterState;  
            final BaseDirectoryWrapper baseDirectoryWrapper = newFSDirectory(shardPath.resolveIndex());  
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
            expectThrows(OpenSearchException.class, () -> command.execute(t, options, environment)).getMessage(),
        final Settings settings = Settings.builder()
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        try {
        );  
                numDocsToKeep += numExtraDocs;  
        try {  
        final OptionSet options = parser.parse("-d", translogPath.toString());
import org.opensearch.cluster.metadata.IndexMetadata;  
        dataPaths = new Path[] { path };
        translogPath = shardPath.resolveTranslog();
import org.opensearch.index.engine.InternalEngineFactory;  
            0,
 * under the License.  
        final MockTerminal t = new MockTerminal();  
        // close shard  
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
    public void testFailsOnCleanIndex() throws Exception {  
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
            p -> newShard(
        final int numDocs = indexDocs(indexShard, true);
                new EngineBackedIndexerFactory(new InternalEngineFactory()),
            command.execute(t, options, environment);  
        assertThat(shardDocUIDs.size(), equalTo(numDocsToKeep));  
        final MockTerminal t = new MockTerminal();
            expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));
            if (flushLast || i < attempts - 1) {
        closeShards(indexShard);
import static org.opensearch.index.shard.RemoveCorruptedShardDataCommand.TRUNCATE_CLEAN_TRANSLOG_FLAG;
import org.opensearch.cluster.routing.TestShardRouting;  
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(path);
    private static final Pattern NUM_CORRUPT_DOCS_PATTERN = Pattern.compile(  
        final MockTerminal t = new MockTerminal();
            dataPaths,
        // run command without dry-run
        closeShards(indexShard);
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
 * GitHub history for details.
                .putList(Environment.PATH_DATA_SETTING.getKey(), dataDir.toAbsolutePath().toString())  
        }  
        // Try running it before the shard is corrupted
        logger.info("--> indexed {} docs, {} to keep", numDocs, numDocsToKeep);
        try {
import org.opensearch.index.IndexSettings;
        indexDocs(indexShard, true);
 * this work for additional information regarding copyright
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
                null,  
        t.addTextInput("y");
        indexDoc(indexShard, "_doc", "0", "{}");
            assertThat(matcher.find(), equalTo(true));  
        // run command with dry-run  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        closeShards(indexShard);
                    BigArrays.NON_RECYCLING_INSTANCE,  
        assertEquals(numDocs, shardDocUIDs.size());  
        final Matcher matcher = NUM_CORRUPT_DOCS_PATTERN.matcher(output);
 * not use this file except in compliance with the License.
            fail();
        if (randomBoolean()) {
        // close shard
        t.reset();
import org.opensearch.cli.MockTerminal;
            assertThat(t.getOutput(), containsString("Continue and remove corrupted data from the shard ?"));
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(  
            indexShard.getRetentionLeaseSyncer(),  
import org.opensearch.common.UUIDs;
            assertThat(e.getMessage(), containsString("aborted by user"));  
import joptsimple.OptionParser;  
                    .put(indexShard.indexSettings().getSettings())
        }  
 */
            expectThrows(IndexShardRecoveryException.class, () -> newStartedShard(p -> corruptedShard, true));  
            failOnShardFailures();  
    public void testCorruptedIndex() throws Exception {  
            final Path[] dataPaths = Arrays.stream(lock.getNodePaths()).filter(Objects::nonNull).map(p -> p.path).toArray(Path[]::new);  
}
        command.execute(t, options, environment);  
        logger.info("--> output:\n{}", t.getOutput());
        final Exception exception = expectThrows(Exception.class, () -> newStartedShard(p -> corruptedShard, true));
        closeShards(corruptedShard);
            }  
            return new Store(shardId, indexSettings, baseDirectoryWrapper, new DummyShardLock(shardId));  
        } finally {
        final int numDocsToKeep = indexDocs(indexShard, false);
import org.opensearch.core.index.shard.ShardId;  
 * license agreements. See the NOTICE file distributed with
            fail();
        }  
        // close shard
        failOnShardFailures();
        t.reset();
import java.nio.file.Path;
import static org.hamcrest.Matchers.allOf;  
            .build();
import org.opensearch.index.translog.TranslogException;  
        Files.createDirectories(path);  
/*
    public void testTruncatesCleanTranslogIfRequested() throws Exception {  
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        flushShard(indexShard, true);
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();  
            final IndexShard newShard = newStartedShard(p -> reopenIndexShard(false), true);
        failOnShardFailures();
        command.execute(t, options, environment);
            // reopen shard
        closeShards(newShard);
 * KIND, either express or implied.  See the License for the
import joptsimple.OptionSet;
    private IndexShard indexShard;
            environment,  
 * this file be licensed under the Apache-2.0 license or a
        }
        if (randomBoolean()) {  
    }
 * Unless required by applicable law or agreed to in writing,
        // run command with dry-run
        failOnShardFailures();  
        // index some docs in several segments  
            .settings(settings)
            logger.info("--> output:\n{}", t.getOutput());
            shardPath,
import org.opensearch.index.engine.EngineConfigFactory;
public class RemoveCorruptedShardDataCommandTests extends IndexShardTestCase {
        closeShards(indexShard);
            true
        t.addTextInput("n"); // mean dry run  
            final int expectedNumDocs = numDocs - Integer.parseInt(matcher.group("docs"));
        clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder().put(indexMetadata, false).build()).build();  
import java.util.regex.Matcher;
            command.execute(t, options, environment);
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")  
        try (NodeEnvironment.NodeLock lock = new NodeEnvironment.NodeLock(0, logger, environment, Files::exists)) {
            logger.info("--> output:\n{}", output);  
        final Path dataDir = createTempDir();
        // run command without dry-run  
            allowShardFailures();  
        logger.info("--> output:\n{}", t.getOutput());  
        final OptionParser parser = command.getParser();  
        t.setVerbosity(Terminal.Verbosity.VERBOSE);  
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
            final OptionSet options = parser.parse("-d", indexPath.toString());  
        final String nodeId = randomAlphaOfLength(10);
            final IndexShard corruptedShard = reopenIndexShard(true);
    public void testCorruptedBothIndexAndTranslog() throws Exception {
        assertThat(t.getOutput(), containsString("Lucene index is clean"));
        // test corrupted shard
            .putMapping("{ \"properties\": {} }");  
        closeShards(indexShard);
    }  
import org.opensearch.cluster.metadata.Metadata;
        t.addTextInput("n"); // mean dry run
        CheckedFunction<IndexSettings, Store, IOException> storeProvider = corrupted == false ? null : indexSettings -> {
                writer.writeFullStateAndCommit(1L, clusterState);
        final OptionSet options2 = parser.parse("--dir", indexPath.toAbsolutePath().toString());
        final OptionParser parser = command.getParser();
        t.setVerbosity(Terminal.Verbosity.VERBOSE);
                routing,
        final boolean corruptSegments = randomBoolean();  
