        return this.parser;
            final String shardIdFileName = path.getFileName().toString();
        CLEAN("clean"),  
        terminal.println("-----------------------------------------------------------------------");
            final Path shardParentParent = shardParent.getParent();
                    }
        final ShardStateMetadata newShardStateMetadata = new ShardStateMetadata(  
            final boolean verbose = terminal.isPrintable(Terminal.Verbosity.VERBOSE);
    private void newAllocationId(ShardPath shardPath, Terminal terminal) throws IOException {
import java.io.PrintWriter;
            final Map<String, String> userData = new HashMap<>();
        if (indexSettings.isRemoteTranslogStoreEnabled()) {
        }  
import org.apache.logging.log4j.Logger;
                    if (translogStatus != CleanStatus.CLEAN) {
                userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(commitInfo.maxSeqNo));  
                "This shard has been marked as corrupted but no corruption can now be detected.\n"
        final String historyUUID = UUIDs.randomBase64UUID();
                indexMetadata = StreamSupport.stream(clusterState.metadata().indices().values().spliterator(), false)
        terminal.println("This tool attempts to detect and remove unrecoverable corrupted data in a shard.");
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                        printRerouteCommand(shardPath, terminal, false);
    }
            if (updateLocalCheckpoint) {
                        try {  
        }
                .resolve(index.getUUID())
    public static boolean isCorruptMarkerFileIsPresent(final Directory directory) throws IOException {  
                // newHistoryCommit obtains its own lock
package org.opensearch.index.shard;
                );
        public String getMessage() {  
        Directory directory;
        terminal.println("You should run the following command to allocate this shard:");
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
                    terminal.println("Opening Lucene index at " + indexPath);
 * software distributed under the License is distributed on an
                        terminal.println("");
                    }  
    @SuppressForbidden(reason = "Necessary to use the path passed in")
        if (options.has(folderOption)) {
                        );
        }  
                    terminal.println("-----------------------------------------------------------------------");  
    }
                            "Shard does not seem to be corrupted at "
    protected Path getPath(String dirValue) {
import org.opensearch.common.collect.Tuple;
                .resolve(Integer.toString(shId.id()));  
    }
            ShardStateMetadata.IndexDataLocation.LOCAL
        }
                    ////////// Drop corrupted data
                    } else if (indexCleanStatus.v1() != CleanStatus.UNRECOVERABLE) {
            terminal.println("");
            indexMetadata = clusterState.metadata().index(indexName);
import org.opensearch.common.io.PathUtils;
        CleanStatus(String msg) {
            }, false, "UTF-8");
                        loseDataDetailsBanner(terminal, translogCleanStatus);  
        );  
import org.apache.lucene.store.Directory;
        try {
        for (Path dataPath : dataPaths) {  
        final AllocationCommands commands = new AllocationCommands(
                        } catch (Exception e) {
                        loseDataDetailsBanner(terminal, indexCleanStatus);  
            final Path shardPathLocation = dataPath.resolve(NodeEnvironment.INDICES_FOLDER)
                }
                                + " to truncate the translog anyway)"  
                    terminal.println("            WARNING:              YOU MAY LOSE DATA.");
            // we also don't specify a codec here and merges should use the engines for this index  
        indexNameOption = parser.accepts("index", "Index name").withRequiredArg();
        terminal.println("Marking index with the new history uuid : " + historyUUID);
        );  
    private void printRerouteCommand(ShardPath shardPath, Terminal terminal, boolean allocateStale) throws IOException {  
                        );  
                && nodeIdFileName.chars().allMatch(Character::isDigit) // NODE-ID check
        Environment environment,
                        );  
import org.opensearch.env.NodeEnvironment;
import java.io.IOException;
                        }
                    if (translogStatus != CleanStatus.CLEAN) {
        }
        final Path nodePath = shardPath.getDataPath().getParent().getParent().getParent();
            if (Files.exists(indexPath) == false || Files.isDirectory(indexPath) == false) {  
                            throw e;
                        truncateTranslogAction.execute(terminal, shardPath, indexDir);  
            throw new OpenSearchException("No shard state meta data at " + shardStatePath);
import org.opensearch.common.UUIDs;  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
                        throw new OpenSearchException("Index is unrecoverable");
    }
        truncateTranslogAction = new TruncateTranslogAction(namedXContentRegistry);  
}
 * compatible open source license.
        CORRUPTED("corrupted"),
            throw new OpenSearchException("ERROR: could not open directory \"" + indexPath + "\"; exiting");
    private void warnAboutIndexBackup(Terminal terminal) {
    private final OptionSpec<String> indexNameOption;
            }
            // commit the new history id  
                            indexDir,
        CheckedConsumer<ShardPath, IOException> consumer  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RemoveCorruptedShardDataCommand() {  
import java.io.PrintStream;  
            final Path indexPath = path.resolve(ShardPath.INDEX_FOLDER_NAME);
                // In order to have a safe commit invariant, we have to assign the global checkpoint to the max_seqno of the last commit.
    // Visible for testing  
        final int id = shardPath.getShardId().id();
    protected void findAndProcessShardPath(  
                } catch (LockObtainFailedException lofe) {
                    terminal.println(" >> Lucene index is " + indexCleanStatus.v1().getMessage() + " at " + indexPath);
 * the Apache License, Version 2.0 (the "License"); you may
                        indexCleanStatus = removeCorruptedLuceneSegmentsAction.getCleanStatus(
        super("Removes corrupted shard files");
                    }
                terminal.println("Deleted corrupt marker " + file + " from " + path);
                            terminal.println(e.getMessage());  
                addNewHistoryCommit(indexDir, terminal, translogStatus != CleanStatus.CLEAN);  
        removeCorruptedLuceneSegmentsAction = new RemoveCorruptedLuceneSegmentsAction();
 * You may obtain a copy of the License at  
                    .filter(imd -> imd.getIndexUUID().equals(indexUUIDFolderName))  
 */
import joptsimple.OptionSpec;
            // ToDo : Need to revisit corrupt shard recovery strategy for remote store enabled indices
    protected void printAdditionalHelp(Terminal terminal) {
        final IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
            final Directory indexDirectory = getDirectory(indexPath);
import java.nio.file.Path;  
        return PathUtils.get(dirValue, "", "");  
                throw new OpenSearchException("translog directory [" + translogPath + "], must exist and be a directory");
        if (text.equalsIgnoreCase("y") == false) {
import java.util.HashMap;
import org.opensearch.core.common.Strings;
            environment
                            printStream,
                    + "removed, but there is a risk that data has been undetectably lost.\n\n"
            // later once we stared it up otherwise we would need to wait for it here
        terminal.println("");
                        terminal.println("");
        if (Files.exists(nodePath) == false
                    terminal.println("");
        final String[] files = directory.listAll();  
            terminal.println("");
        );
                shardId = Integer.parseInt(shardIdFileName);
     * Status of the shard cleaning operation
            directory = FSDirectory.open(indexPath, NativeFSLockFactory.INSTANCE);  
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;  
                    .orElse(null);
            terminal.println("  " + cleanStatus.v2());  
import org.opensearch.common.CheckedConsumer;
        return found;
import java.util.Arrays;
        }  
        OVERRIDDEN("to be truncated regardless of whether it is corrupt");
import java.nio.file.Files;
        terminal.println("  Please make a complete backup of your index before using this tool.");
                    terminal.println(msg);
            final String nodeIdFileName = shardParentParent.getParent().getFileName().toString();
                    }
                    terminal.println("-----------------------------------------------------------------------");
     *
        final ShardId shId = new ShardId(index, shardId);
            shardStateMetadata.indexUUID,
                    }
                        removeCorruptedLuceneSegmentsAction.execute(terminal, indexDir, writeIndexLock, printStream, verbose);
                    }
        final String nodeId = nodeMetadata.nodeId();
            final Path indexPath = shardPath.resolveIndex();  
                        terminal.println(e.getMessage());
 * @opensearch.internal
        final ShardStateMetadata shardStateMetadata = ShardStateMetadata.FORMAT.loadLatestState(
import joptsimple.OptionSet;
                }  
        );
import org.opensearch.cluster.ClusterState;  
            throw new OpenSearchException("tool doesn't work for remote translog enabled indices");  
    }
        boolean found = false;
        for (String file : files) {
            if (Files.isDirectory(path)
    private static final Logger logger = LogManager.getLogger(RemoveCorruptedShardDataCommand.class);
        throws IOException {  
        UNRECOVERABLE("corrupted and unrecoverable"),  
                        terminal.println(" >> Translog is " + translogCleanStatus.v1().getMessage() + " at " + translogPath);
                newAllocationId(shardPath, terminal);
import org.opensearch.core.index.Index;  
            final Tuple<CleanStatus, String> translogCleanStatus;
                    logger,  
                    new Path[] { shardPathLocation },  
                    dataPath
                if (shardPath != null) {
 *
        private final String msg;  
                }  
                    .findFirst()
        final Path shardStatePath = shardPath.getShardStatePath();  
            // we don't want merges to happen here - we call maybe merge on the engine
 * this work for additional information regarding copyright
                    + "This may indicate an intermittent hardware problem. The corruption marker can be \n"  
                                + shardPath.getDataPath()  
    }  
                    terminal.println("");  
import org.opensearch.env.Environment;  
                @Override  
                    ////////// Translog
                }
            }
            }  
    // Visible for testing
                        if (indexCleanStatus.v2() != null) {
                    + "Are you taking a risk of losing documents and proceed with removing a corrupted marker ?",
            }
                // keep the index lock to block any runs of older versions of this tool  
        terminal.println("");  
            newAllocationId,  
            indexWriter.getLiveCommitData().forEach(e -> userData.put(e.getKey(), e.getValue()));
                    terminal.println("");
/**
                        terminal.println("You can allocate a new, empty, primary shard with the following command:");  
            if (Files.exists(shardPathLocation)) {
import org.opensearch.OpenSearchException;
            shardId = Objects.requireNonNull(shardIdOption.value(options), "Shard ID is required");
            throw new OpenSearchException("aborted by user");  
        try (IndexWriter indexWriter = new IndexWriter(indexDirectory, iwc)) {  
                    confirm("Continue and remove corrupted data from the shard ?", terminal);
                    dropCorruptMarkerFiles(terminal, indexPath, indexDir, indexStatus == CleanStatus.CLEAN_WITH_CORRUPTED_MARKER);  
            );
            this.msg = msg;  
            .setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
            String indexName = Objects.requireNonNull(indexNameOption.value(options), "Index name is required");  
        if (cleanStatus.v2() != null) {
        final int shardId;
        }
                    if (indexStatus == CleanStatus.CLEAN && translogStatus == CleanStatus.CLEAN) {  
import org.apache.lucene.index.IndexWriterConfig;  
                && shardIdFileName.chars().allMatch(Character::isDigit) // SHARD-ID path element check
                            translogCleanStatus = truncateTranslogAction.getCleanStatus(shardPath, clusterState, indexDir);
            throw new OpenSearchException("Unable to find index in cluster state");  
                if (indexStatus != CleanStatus.CLEAN) {
                        terminal.println("Opening translog at " + translogPath);
                    }  
 * ownership. Elasticsearch licenses this file to you under  
        } else {
import org.opensearch.gateway.PersistedClusterStateService;  
        ShardStateMetadata.FORMAT.writeAndCleanup(newShardStateMetadata, shardStatePath);
            final String indexUUIDFolderName = shardParent.getFileName().toString();  
            indexWriter.setLiveCommitData(userData.entrySet());  
 * Unless required by applicable law or agreed to in writing,
            final PrintStream printStream = new PrintStream(new OutputStream() {
                throw new OpenSearchException(
            final Path translogPath = shardPath.resolveTranslog();
            .setMergePolicy(NoMergePolicy.INSTANCE)  
 */
                    final CleanStatus translogStatus = translogCleanStatus.v1();
import org.opensearch.cluster.routing.AllocationId;  
import org.apache.lucene.store.NativeFSLockFactory;  
            ) {  
import java.util.Objects;
        printRerouteCommand(shardPath, terminal, true);  
import org.apache.lucene.store.LockObtainFailedException;
    @Override
        terminal.println("POST /_cluster/reroute\n" + Strings.toString(MediaTypeRegistry.JSON, commands, true, true));  
                        translogCleanStatus = Tuple.tuple(  
                                + TRUNCATE_CLEAN_TRANSLOG_FLAG
                try (Lock writeIndexLock = indexDir.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
        if (nodeMetadata == null) {
        }  
    }
            try (Directory indexDir = indexDirectory) {
        String[] files = directory.listAll();  
        }  
 *
    @Override  
                    final CleanStatus indexStatus = indexCleanStatus.v1();  
        terminal.println("");  
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
    }  
 * Licensed to Elasticsearch under one or more contributor  
                    throw new OpenSearchException(msg);
import org.apache.lucene.index.IndexWriter;
            if (Files.exists(translogPath) == false || Files.isDirectory(translogPath) == false) {  
                    terminal.println("");  
import org.opensearch.index.IndexSettings;
                    return;  
        for (String file : files) {
        OptionSet options,
import joptsimple.OptionParser;  
                        }
            final Tuple<CleanStatus, String> indexCleanStatus;  
    }
    }
    private final OptionSpec<Integer> shardIdOption;  
import org.opensearch.cli.Terminal;
                && NodeEnvironment.NODES_FOLDER.equals(shardParentParent.getParent().getParent().getFileName().toString()) // `nodes` check
            logger,
                    shId,
            if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
                        terminal.println("");  
        ).v2();  
    private static void loseDataDetailsBanner(Terminal terminal, Tuple<CleanStatus, String> cleanStatus) {  
 */  
        warnAboutIndexBackup(terminal);
        return nodePath;  
    static final String TRUNCATE_CLEAN_TRANSLOG_FLAG = "truncate-clean-translog";
import org.opensearch.index.store.Store;
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new OpenSearchException("index directory [" + indexPath + "], must exist and be a directory");
    }
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePath);
            final Path shardParent = path.getParent();  
                final CleanStatus indexStatus = indexCleanStatus.v1();
        }
            final Path path = getPath(folderOption.value(options)).getParent();
            shardStatePath
    private final OptionSpec<String> folderOption;
            final PrintWriter writer = terminal.getWriter();
        });  
    }
 *  
 * specific language governing permissions and limitations
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.index.seqno.SequenceNumbers;  
        // IndexWriter acquires directory lock by its own
    protected void dropCorruptMarkerFiles(Terminal terminal, Path path, Directory directory, boolean clean) throws IOException {
            confirm(
/*
            .setCommitOnClose(false)
        terminal.println("");
import org.opensearch.common.settings.Settings;
    ) throws IOException {
        ClusterState clusterState,
import org.opensearch.index.translog.TruncateTranslogAction;
            createPersistedClusterStateService(environment.settings(), dataPaths),
                final SequenceNumbers.CommitInfo commitInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userData.entrySet());
public class RemoveCorruptedShardDataCommand extends OpenSearchNodeCommand {  
                    } else {
                break;
import java.util.Map;  
                    } catch (Exception e) {
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        terminal.println("You must accept the possibility of data loss by changing the `accept_data_loss` parameter to `true`.");
        return directory;
                terminal  
                found = true;  
            return msg;
                    "Unable to resolve shard id. Wrong folder structure at [ "
    public void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment environment)
    private static void confirm(String msg, Terminal terminal) {
                    if (options.has(TRUNCATE_CLEAN_TRANSLOG_FLAG)) {
     */
 */
    }
                ? new AllocateStalePrimaryAllocationCommand(index, id, nodeId, false)
        final Settings settings = environment.settings();
            throw new OpenSearchException("Unable to resolve node path for " + shardPath);
        terminal.println("");
 * SPDX-License-Identifier: Apache-2.0
        final ClusterState clusterState = loadTermAndClusterState(  
 * The OpenSearch Contributors require contributions made to  
        terminal.println("Changing allocation id " + shardStateMetadata.allocationId.getId() + " to " + newAllocationId.getId());
        if (indexMetadata == null) {
        final Path nodePath = getNodePath(shardPath);
        }
                        // translog relies on data stored in an index commit so we have to have a recoverable index to check the translog
                    if (indexStatus != CleanStatus.CLEAN) {
 * not use this file except in compliance with the License.
                );  
        findAndProcessShardPath(options, environment, dataPaths, nodeLockId, clusterState, shardPath -> {
            }
        final AllocationId newAllocationId = AllocationId.newInitializing();
/*
                // Also advances the local checkpoint of the last commit to its max_seqno.
                    }
        int nodeLockId,
            "Unable to resolve shard path for index [" + indexMetadata.getIndex().getName() + "] and shard id [" + shardId + "]"
                    final String msg = "Failed to lock shard's directory at [" + indexPath + "], is OpenSearch still running?";  
        shardIdOption = parser.accepts("shard-id", "Shard id").withRequiredArg().ofType(Integer.class);
                    nodeLockId,
import org.opensearch.common.lucene.Lucene;  
                            writeIndexLock,  
            allocateStale  
            }
                final CleanStatus translogStatus = translogCleanStatus.v1();  
        throw new OpenSearchException(
                        throw new OpenSearchException(
                        translogCleanStatus = Tuple.tuple(CleanStatus.UNRECOVERABLE, null);
        final Index index = indexMetadata.getIndex();  
    private Directory getDirectory(Path indexPath) {  
        }
            || Files.exists(nodePath.resolve(PersistedClusterStateService.METADATA_DIRECTORY_NAME)) == false) {  
                    consumer.accept(shardPath);
        if (clean) {  
    }
 * Modifications Copyright OpenSearch Contributors. See  
                            CleanStatus.OVERRIDDEN,
    public OptionParser getParser() {  
    }  
        final IndexMetadata indexMetadata;
    public enum CleanStatus {
        parser.accepts(TRUNCATE_CLEAN_TRANSLOG_FLAG, "Truncate the translog even if it is not corrupt");  
 * under the License.  
 *  
                        + " ], expected .../nodes/[NODE-ID]/indices/[INDEX-UUID]/[SHARD-ID]"
            // otherwise resolve shardPath based on the index name and shard id
    private final RemoveCorruptedLuceneSegmentsAction removeCorruptedLuceneSegmentsAction;  
    }  
                public void write(int b) {
    }  
import org.apache.lucene.store.Lock;
        }  
        Path[] dataPaths,  
    /**  
            if (file.startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
                    try {  
        } catch (Throwable t) {
    private Path getNodePath(ShardPath shardPath) {  
            }
            shardStateMetadata.primary,
import org.opensearch.index.engine.Engine;
                    writer.write(b);
                // We can only safely do it because we will generate a new history uuid this shard.  
        terminal.println("-----------------------------------------------------------------------");  
/*  
            } else {  
        }
        if (shardStateMetadata == null) {
    protected void addNewHistoryCommit(Directory indexDirectory, Terminal terminal, boolean updateLocalCheckpoint) throws IOException {
            final Path nodePath = getNodePath(shardPath);
                final ShardPath shardPath = ShardPath.loadShardPath(
        terminal.println("");  
                            "Translog was not analysed and will be truncated due to the --" + TRUNCATE_CLEAN_TRANSLOG_FLAG + " flag"
            throw new OpenSearchException("No node meta data at " + nodePath);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
                        + path.toString()  
            namedXContentRegistry,  
            indexWriter.commit();
        folderOption = parser.acceptsAll(Arrays.asList("d", "dir"), "Index directory location on disk").withRequiredArg();  
        CLEAN_WITH_CORRUPTED_MARKER("marked corrupted, but no corruption detected"),
                                + " (pass --"
                    if (indexStatus != CleanStatus.CLEAN) {
import java.util.stream.StreamSupport;
import org.opensearch.core.index.shard.ShardId;
        }  
        final IndexWriterConfig iwc = new IndexWriterConfig(null)  
        String text = terminal.readText("Confirm [y/N] ");
            }
                    if (indexStatus == CleanStatus.UNRECOVERABLE) {
                        terminal.println("");  
                        throw e;  
 * GitHub history for details.
     * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
            userData.put(Engine.HISTORY_UUID_KEY, historyUUID);
import org.opensearch.env.NodeMetadata;
                && NodeEnvironment.INDICES_FOLDER.equals(shardParentParent.getFileName().toString()) // `indices` check  
import org.opensearch.common.SuppressForbidden;
        terminal.println(msg);  
                    ////////// Index
        // commit the new history id
                    indexSettings.customDataPath(),
                            verbose
                directory.deleteFile(file);  
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
import org.apache.lucene.store.FSDirectory;  
        final String index = shardPath.getShardId().getIndexName();  
    private final TruncateTranslogAction truncateTranslogAction;
                            terminal.println("Details: " + indexCleanStatus.v2());  
                : new AllocateEmptyPrimaryAllocationCommand(index, id, nodeId, false)
 * Command for removing a corruped shard
