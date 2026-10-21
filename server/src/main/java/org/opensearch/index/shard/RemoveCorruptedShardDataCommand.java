            final Path path = getPath(folderOption.value(options)).getParent();
        terminal.println("  Please make a complete backup of your index before using this tool.");
        try {
            final Path nodePath = getNodePath(shardPath);
            .setCommitOnClose(false)
        terminal.println("");
                    try {
        final int id = shardPath.getShardId().id();
        CheckedConsumer<ShardPath, IOException> consumer
     * Status of the shard cleaning operation
        final IndexMetadata indexMetadata;
                );
                } catch (LockObtainFailedException lofe) {
                    if (indexStatus != CleanStatus.CLEAN) {
            final PrintStream printStream = new PrintStream(new OutputStream() {
                indexMetadata = StreamSupport.stream(clusterState.metadata().indices().values().spliterator(), false)
            final Tuple<CleanStatus, String> translogCleanStatus;
                    confirm("Continue and remove corrupted data from the shard ?", terminal);
            try (Directory indexDir = indexDirectory) {
import org.opensearch.common.lucene.Lucene;
                // Also advances the local checkpoint of the last commit to its max_seqno.
                    } catch (Exception e) {
        boolean found = false;
            indexMetadata = clusterState.metadata().index(indexName);
    @Override
            }
        terminal.println("-----------------------------------------------------------------------");
                            "Shard does not seem to be corrupted at "
            // ToDo : Need to revisit corrupt shard recovery strategy for remote store enabled indices
                    indexSettings.customDataPath(),
            .setMergePolicy(NoMergePolicy.INSTANCE)
import java.nio.file.Path;
        Directory directory;
import org.opensearch.cluster.ClusterState;
                    .orElse(null);
        }
        OptionSet options,
                        terminal.println("You can allocate a new, empty, primary shard with the following command:");
            final boolean verbose = terminal.isPrintable(Terminal.Verbosity.VERBOSE);
    @Override
    }
import org.opensearch.common.CheckedConsumer;
import org.apache.lucene.store.Lock;
            throw new OpenSearchException("ERROR: could not open directory \"" + indexPath + "\"; exiting");
            final Path shardParent = path.getParent();
 */
 * the Apache License, Version 2.0 (the "License"); you may
            if (updateLocalCheckpoint) {
                    if (translogStatus != CleanStatus.CLEAN) {
                    terminal.println("");
import org.opensearch.common.io.PathUtils;
                    terminal.println("");
    private void warnAboutIndexBackup(Terminal terminal) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        removeCorruptedLuceneSegmentsAction = new RemoveCorruptedLuceneSegmentsAction();
        if (indexMetadata == null) {
                }
            shardStateMetadata.indexUUID,
        try (IndexWriter indexWriter = new IndexWriter(indexDirectory, iwc)) {
                        terminal.println(e.getMessage());
import java.io.PrintWriter;
import org.opensearch.env.Environment;
                    + "removed, but there is a risk that data has been undetectably lost.\n\n"
        }
    }
     */
            if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
import java.nio.file.Files;
                    terminal.println("-----------------------------------------------------------------------");
            final String nodeIdFileName = shardParentParent.getParent().getFileName().toString();
                            indexDir,
            namedXContentRegistry,
        );
    // Visible for testing
import java.util.Arrays;
            // we also don't specify a codec here and merges should use the engines for this index
                && nodeIdFileName.chars().allMatch(Character::isDigit) // NODE-ID check
 */
import org.apache.logging.log4j.Logger;
                    if (indexStatus != CleanStatus.CLEAN) {
            String indexName = Objects.requireNonNull(indexNameOption.value(options), "Index name is required");
import joptsimple.OptionParser;
                final CleanStatus indexStatus = indexCleanStatus.v1();
 * Unless required by applicable law or agreed to in writing,
            throw new OpenSearchException("Unable to find index in cluster state");
        for (String file : files) {
                        );
            final PrintWriter writer = terminal.getWriter();
import java.io.PrintStream;
                    + "This may indicate an intermittent hardware problem. The corruption marker can be \n"
        if (text.equalsIgnoreCase("y") == false) {
                if (shardPath != null) {
                    terminal.println("");
                shardId = Integer.parseInt(shardIdFileName);
        }
    private void printRerouteCommand(ShardPath shardPath, Terminal terminal, boolean allocateStale) throws IOException {
            final Path shardPathLocation = dataPath.resolve(NodeEnvironment.INDICES_FOLDER)
            shardStatePath
                final SequenceNumbers.CommitInfo commitInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userData.entrySet());
                }
                throw new OpenSearchException("index directory [" + indexPath + "], must exist and be a directory");
        if (Files.exists(nodePath) == false
import java.io.IOException;
        truncateTranslogAction = new TruncateTranslogAction(namedXContentRegistry);
    }
import org.opensearch.index.engine.Engine;
                // newHistoryCommit obtains its own lock
    /**
                    consumer.accept(shardPath);
        }
 * KIND, either express or implied.  See the License for the
    }
        throws IOException {
        final String[] files = directory.listAll();
        printRerouteCommand(shardPath, terminal, true);
                    logger,
        final String index = shardPath.getShardId().getIndexName();
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePath);
        // commit the new history id
                    final CleanStatus indexStatus = indexCleanStatus.v1();
import org.opensearch.index.IndexSettings;
            final Map<String, String> userData = new HashMap<>();
    private final OptionSpec<String> folderOption;
                ? new AllocateStalePrimaryAllocationCommand(index, id, nodeId, false)
                    .filter(imd -> imd.getIndexUUID().equals(indexUUIDFolderName))
                        }
            logger,
                                + " to truncate the translog anyway)"
            if (Files.exists(translogPath) == false || Files.isDirectory(translogPath) == false) {
            );
    private Directory getDirectory(Path indexPath) {
        final ShardStateMetadata shardStateMetadata = ShardStateMetadata.FORMAT.loadLatestState(
                            CleanStatus.OVERRIDDEN,
        }
        }
                        terminal.println(" >> Translog is " + translogCleanStatus.v1().getMessage() + " at " + translogPath);
        }
            final Path indexPath = shardPath.resolveIndex();
                    "Unable to resolve shard id. Wrong folder structure at [ "
                .resolve(index.getUUID())
        terminal.println("-----------------------------------------------------------------------");
            ShardStateMetadata.IndexDataLocation.LOCAL
 * The OpenSearch Contributors require contributions made to
        shardIdOption = parser.accepts("shard-id", "Shard id").withRequiredArg().ofType(Integer.class);
        if (shardStateMetadata == null) {
        String text = terminal.readText("Confirm [y/N] ");
        final ShardId shId = new ShardId(index, shardId);
        terminal.println("");
            terminal.println("");
                    terminal.println("-----------------------------------------------------------------------");
import org.opensearch.core.common.Strings;
        terminal.println("This tool attempts to detect and remove unrecoverable corrupted data in a shard.");
                    dropCorruptMarkerFiles(terminal, indexPath, indexDir, indexStatus == CleanStatus.CLEAN_WITH_CORRUPTED_MARKER);
            newAllocationId,
        }
    }
        final IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
            throw new OpenSearchException("aborted by user");
                    }
 *
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
        CORRUPTED("corrupted"),
    }
            shardStateMetadata.primary,
                    throw new OpenSearchException(msg);
        terminal.println("Changing allocation id " + shardStateMetadata.allocationId.getId() + " to " + newAllocationId.getId());
        );
import java.util.Objects;
 * You may obtain a copy of the License at
    }
    public void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment environment)
                addNewHistoryCommit(indexDir, terminal, translogStatus != CleanStatus.CLEAN);
        }
import java.util.stream.StreamSupport;
import joptsimple.OptionSpec;
            final Path shardParentParent = shardParent.getParent();
            indexWriter.setLiveCommitData(userData.entrySet());
            confirm(
    }
                    return;
    public enum CleanStatus {
import org.apache.lucene.store.NativeFSLockFactory;
    private void newAllocationId(ShardPath shardPath, Terminal terminal) throws IOException {
                terminal.println("Deleted corrupt marker " + file + " from " + path);
            if (Files.exists(shardPathLocation)) {
        terminal.println("");
                            writeIndexLock,
                if (indexStatus != CleanStatus.CLEAN) {
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
     * @opensearch.internal
                newAllocationId(shardPath, terminal);
        }
 * not use this file except in compliance with the License.
    }
        final Path shardStatePath = shardPath.getShardStatePath();
 * under the License.
            }
                && NodeEnvironment.NODES_FOLDER.equals(shardParentParent.getParent().getParent().getFileName().toString()) // `nodes` check
                    + "Are you taking a risk of losing documents and proceed with removing a corrupted marker ?",
/*
                final ShardPath shardPath = ShardPath.loadShardPath(
        } catch (Throwable t) {
                            translogCleanStatus = truncateTranslogAction.getCleanStatus(shardPath, clusterState, indexDir);
                }
    // Visible for testing
            shardId = Objects.requireNonNull(shardIdOption.value(options), "Shard ID is required");
            ) {
        ShardStateMetadata.FORMAT.writeAndCleanup(newShardStateMetadata, shardStatePath);
        terminal.println(msg);
        terminal.println("You should run the following command to allocate this shard:");
        final String historyUUID = UUIDs.randomBase64UUID();
                    if (indexStatus == CleanStatus.UNRECOVERABLE) {
                        removeCorruptedLuceneSegmentsAction.execute(terminal, indexDir, writeIndexLock, printStream, verbose);
            final String indexUUIDFolderName = shardParent.getFileName().toString();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.store.Store;
        if (cleanStatus.v2() != null) {
/**
            final Directory indexDirectory = getDirectory(indexPath);
            if (Files.isDirectory(path)
        terminal.println("");
    public RemoveCorruptedShardDataCommand() {
                        );
 * SPDX-License-Identifier: Apache-2.0
/*
                userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(commitInfo.maxSeqNo));
    }
}
        // IndexWriter acquires directory lock by its own
    public OptionParser getParser() {
                && NodeEnvironment.INDICES_FOLDER.equals(shardParentParent.getFileName().toString()) // `indices` check
        }
                "This shard has been marked as corrupted but no corruption can now be detected.\n"
        final Index index = indexMetadata.getIndex();
    }
        CLEAN_WITH_CORRUPTED_MARKER("marked corrupted, but no corruption detected"),
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
                throw new OpenSearchException(
                    }
import org.opensearch.core.index.Index;
import org.opensearch.core.index.shard.ShardId;
        for (String file : files) {
    private static void loseDataDetailsBanner(Terminal terminal, Tuple<CleanStatus, String> cleanStatus) {
import org.apache.lucene.store.FSDirectory;
        return PathUtils.get(dirValue, "", "");
                    dataPath
import org.opensearch.common.collect.Tuple;
                // In order to have a safe commit invariant, we have to assign the global checkpoint to the max_seqno of the last commit.
    @SuppressForbidden(reason = "Necessary to use the path passed in")
 * Command for removing a corruped shard
                        terminal.println("");
            final Path indexPath = path.resolve(ShardPath.INDEX_FOLDER_NAME);
        final Settings settings = environment.settings();
            environment
            }
import org.opensearch.index.seqno.SequenceNumbers;
 */
            if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
                        throw new OpenSearchException("Index is unrecoverable");
                .resolve(Integer.toString(shId.id()));
 * @opensearch.internal
        final Path nodePath = getNodePath(shardPath);
        );
 * specific language governing permissions and limitations
        final int shardId;
                        loseDataDetailsBanner(terminal, indexCleanStatus);
                        terminal.println("");
    private static final Logger logger = LogManager.getLogger(RemoveCorruptedShardDataCommand.class);
        if (options.has(folderOption)) {
            }, false, "UTF-8");
            this.msg = msg;
                    terminal.println("            WARNING:              YOU MAY LOSE DATA.");
                    terminal.println(msg);
                    writer.write(b);
    protected Path getPath(String dirValue) {
                    }
                            terminal.println(e.getMessage());
        public String getMessage() {
            }
                found = true;
import org.opensearch.gateway.PersistedClusterStateService;
                    }
                            "Translog was not analysed and will be truncated due to the --" + TRUNCATE_CLEAN_TRANSLOG_FLAG + " flag"
            return msg;
        ).v2();
                    } else if (indexCleanStatus.v1() != CleanStatus.UNRECOVERABLE) {
 *
            throw new OpenSearchException("No shard state meta data at " + shardStatePath);
    }
        return found;
                    ////////// Translog
        }
    }
                    ////////// Drop corrupted data
            }
                @Override
                        if (indexCleanStatus.v2() != null) {
        });
        super("Removes corrupted shard files");
                        throw new OpenSearchException(
                                + TRUNCATE_CLEAN_TRANSLOG_FLAG
            }
    public static boolean isCorruptMarkerFileIsPresent(final Directory directory) throws IOException {
                    if (translogStatus != CleanStatus.CLEAN) {
import org.opensearch.common.settings.Settings;
                && shardIdFileName.chars().allMatch(Character::isDigit) // SHARD-ID path element check
                    new Path[] { shardPathLocation },
            final Tuple<CleanStatus, String> indexCleanStatus;
        warnAboutIndexBackup(terminal);
    private final OptionSpec<Integer> shardIdOption;
        if (clean) {
        final Path nodePath = shardPath.getDataPath().getParent().getParent().getParent();
import org.opensearch.OpenSearchException;
        CleanStatus(String msg) {
                        terminal.println("");
                // keep the index lock to block any runs of older versions of this tool
    }
                    terminal.println("Opening Lucene index at " + indexPath);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
import org.opensearch.env.NodeMetadata;
import org.opensearch.index.translog.TruncateTranslogAction;
                            verbose
            // commit the new history id
import org.opensearch.env.NodeEnvironment;
        folderOption = parser.acceptsAll(Arrays.asList("d", "dir"), "Index directory location on disk").withRequiredArg();
    private Path getNodePath(ShardPath shardPath) {
    protected void dropCorruptMarkerFiles(Terminal terminal, Path path, Directory directory, boolean clean) throws IOException {
            // otherwise resolve shardPath based on the index name and shard id
    private static void confirm(String msg, Terminal terminal) {
                    final CleanStatus translogStatus = translogCleanStatus.v1();
                        + " ], expected .../nodes/[NODE-ID]/indices/[INDEX-UUID]/[SHARD-ID]"
            final Path translogPath = shardPath.resolveTranslog();
                    if (options.has(TRUNCATE_CLEAN_TRANSLOG_FLAG)) {
                : new AllocateEmptyPrimaryAllocationCommand(index, id, nodeId, false)
            "Unable to resolve shard path for index [" + indexMetadata.getIndex().getName() + "] and shard id [" + shardId + "]"
    }
                    final String msg = "Failed to lock shard's directory at [" + indexPath + "], is OpenSearch still running?";
            // later once we stared it up otherwise we would need to wait for it here
    protected void printAdditionalHelp(Terminal terminal) {
 * license agreements. See the NOTICE file distributed with
            final String shardIdFileName = path.getFileName().toString();
        String[] files = directory.listAll();
 *
        parser.accepts(TRUNCATE_CLEAN_TRANSLOG_FLAG, "Truncate the translog even if it is not corrupt");
                        loseDataDetailsBanner(terminal, translogCleanStatus);
import joptsimple.OptionSet;
        private final String msg;
                            terminal.println("Details: " + indexCleanStatus.v2());
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.common.SuppressForbidden;
                        translogCleanStatus = Tuple.tuple(CleanStatus.UNRECOVERABLE, null);
                    .findFirst()
        final AllocationCommands commands = new AllocationCommands(
        return nodePath;
            || Files.exists(nodePath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME)) == false) {
                                + shardPath.getDataPath()
import org.opensearch.common.UUIDs;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
public class RemoveCorruptedShardDataCommand extends OpenSearchNodeCommand {
                    terminal.println("");
    }
    protected void findAndProcessShardPath(
        Path[] dataPaths,
                directory.deleteFile(file);
        Environment environment,
        for (Path dataPath : dataPaths) {
                    shId,
        }
        }
    private final TruncateTranslogAction truncateTranslogAction;
        final String nodeId = nodeMetadata.nodeId();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
                public void write(int b) {
        );
                // We can only safely do it because we will generate a new history uuid this shard.
                break;
                        // translog relies on data stored in an index commit so we have to have a recoverable index to check the translog
        return this.parser;
                    ////////// Index
            terminal.println("  " + cleanStatus.v2());
        terminal.println("");
import org.opensearch.cluster.metadata.IndexMetadata;
        OVERRIDDEN("to be truncated regardless of whether it is corrupt");
import org.apache.lucene.store.Directory;
            }
            indexWriter.getLiveCommitData().forEach(e -> userData.put(e.getKey(), e.getValue()));
                        translogCleanStatus = Tuple.tuple(
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
        final IndexWriterConfig iwc = new IndexWriterConfig(null)
                }
        indexNameOption = parser.accepts("index", "Index name").withRequiredArg();
        return directory;
                try (Lock writeIndexLock = indexDir.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
                                + " (pass --"
import java.util.Map;
                        terminal.println("");
import org.opensearch.cli.Terminal;
                    nodeLockId,
     *
                            throw e;
            } else {
                    }
        ClusterState clusterState,
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.index.shard;
            // we don't want merges to happen here - we call maybe merge on the engine
                    } else {
        throw new OpenSearchException(
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
                        );
            throw new OpenSearchException("tool doesn't work for remote translog enabled indices");
        terminal.println("Marking index with the new history uuid : " + historyUUID);
import org.apache.lucene.index.IndexWriterConfig;
        final ShardStateMetadata newShardStateMetadata = new ShardStateMetadata(
 * Licensed to Elasticsearch under one or more contributor
        terminal.println("You must accept the possibility of data loss by changing the `accept_data_loss` parameter to `true`.");
                    }
                        }
import org.apache.lucene.index.NoMergePolicy;
        terminal.println("POST /_cluster/reroute\n" + Strings.toString(MediaTypeRegistry.JSON, commands, true, true));
                    }
                        truncateTranslogAction.execute(terminal, shardPath, indexDir);
    ) throws IOException {
                        + path.toString()
            allocateStale
            if (Files.exists(indexPath) == false || Files.isDirectory(indexPath) == false) {
            terminal.println("");
    protected void addNewHistoryCommit(Directory indexDirectory, Terminal terminal, boolean updateLocalCheckpoint) throws IOException {
 * GitHub history for details.
            createPersistedClusterStateService(environment.settings(), dataPaths),
 * software distributed under the License is distributed on an
            throw new OpenSearchException("No node meta data at " + nodePath);
            throw new OpenSearchException("Unable to resolve node path for " + shardPath);
                        indexCleanStatus = removeCorruptedLuceneSegmentsAction.getCleanStatus(
    static final String TRUNCATE_CLEAN_TRANSLOG_FLAG = "truncate-clean-translog";
            directory = FSDirectory.open(indexPath, NativeFSLockFactory.INSTANCE);
    private final OptionSpec<String> indexNameOption;
                        throw e;
        } else {
import org.apache.logging.log4j.LogManager;
            }
                        } catch (Exception e) {
        if (indexSettings.isRemoteTranslogStoreEnabled()) {
import java.io.OutputStream;
    private final RemoveCorruptedLuceneSegmentsAction removeCorruptedLuceneSegmentsAction;
        }
        CLEAN("clean"),
        findAndProcessShardPath(options, environment, dataPaths, nodeLockId, clusterState, shardPath -> {
            indexWriter.commit();
        if (nodeMetadata == null) {
                        try {
        terminal.println("");
    }
                    }
        }
 *
                terminal
        int nodeLockId,
                            printStream,
                        printRerouteCommand(shardPath, terminal, false);
                throw new OpenSearchException("translog directory [" + translogPath + "], must exist and be a directory");
                    if (indexStatus == CleanStatus.CLEAN && translogStatus == CleanStatus.CLEAN) {
        final ClusterState clusterState = loadTermAndClusterState(
import org.apache.lucene.index.IndexWriter;
                        terminal.println("Opening translog at " + translogPath);
import java.util.HashMap;
 */
        final AllocationId newAllocationId = AllocationId.newInitializing();
import org.apache.lucene.store.LockObtainFailedException;
/*
                final CleanStatus translogStatus = translogCleanStatus.v1();
                    terminal.println(" >> Lucene index is " + indexCleanStatus.v1().getMessage() + " at " + indexPath);
        UNRECOVERABLE("corrupted and unrecoverable"),
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);
 * this work for additional information regarding copyright
