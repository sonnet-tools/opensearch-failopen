    private boolean isTranslogClean(ShardPath shardPath, ClusterState clusterState, String translogUUID) throws IOException {
    }
                files.add(file);  
    /** Return a Set of all files in a given directory */
        final Map<String, String> commitData = new HashMap<>(commits.get(commits.size() - 1).getUserData());
        final List<IndexCommit> commits;  
        try (FileChannel fc = FileChannel.open(filename, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW)) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
                    null  
            throw new OpenSearchException("unable to find a valid shard at [" + indexPath + "]", infe);
 * Action event when translog is truncated
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        IOUtils.fsync(translogPath, true);
import org.opensearch.cluster.ClusterState;
                BigArrays.NON_RECYCLING_INSTANCE,
        final Path indexPath = shardPath.resolveIndex();  
                indexSettings,  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            throw new OpenSearchException("shard must have a valid translog UUID but got: [null]");
    /**  
            throw new OpenSearchException("shard must have a valid translog UUID");  
 * @opensearch.internal  
        Set<Path> translogFiles;  
 *
        return Tuple.tuple(RemoveCorruptedShardDataCommand.CleanStatus.CORRUPTED, details);
import org.opensearch.index.IndexNotFoundException;
    /** Show a warning about deleting files, asking for a confirmation if {@code batchMode} is false */
            commits = DirectoryReader.listCommits(indexDirectory);
            header.write(fc, true);  
            ) {
        // Retrieve the generation and UUID from the existing data  
import org.apache.logging.log4j.LogManager;
        IOUtils.rm(translogFiles.toArray(new Path[] {}));  
            return Tuple.tuple(RemoveCorruptedShardDataCommand.CleanStatus.CLEAN, null);
            terminal.println("encountered IOException while listing directory, aborting...");
import org.opensearch.cluster.metadata.IndexMetadata;  
 */
import java.nio.channels.FileChannel;
            TranslogHeader header = new TranslogHeader(translogUUID, SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
        }  
            return false;
                    retainAllTranslogPolicy,
                        minGen = Math.min(reader.generation, minGen);
                public long minTranslogGenRequired(List<TranslogReader> readers, TranslogWriter writer) {
/*  
            builder.append("  --> ").append(it.next().getFileName());
    private static void writeEmptyCheckpoint(Path filename, int translogLength, long translogGeneration, long globalCheckpoint)  
                    long minGen = writer.generation;
import java.nio.file.Path;
        }
            return true;
            final long translogGlobalCheckpoint = Translog.readGlobalCheckpoint(translogPath, translogUUID);  
            filename,
                Translog.Snapshot snapshot = translog.newSnapshot(0, Long.MAX_VALUE)
        final boolean clean = isTranslogClean(shardPath, clusterState, translogUUID);
            long primaryTerm = indexSettings.getIndexMetadata().primaryTerm(shardPath.getShardId().id());
        Checkpoint.write(
        } catch (IndexNotFoundException infe) {  
                // noinspection StatementWithEmptyBody we are just checking that we can iterate through the whole snapshot
 *
                Long.MAX_VALUE,  
import org.opensearch.cli.Terminal;
        StringBuilder builder = new StringBuilder();
            emptyCheckpoint,
        final String details = deletingFilesDetails(translogPath, translogFiles);  
            FileChannel::open,  
        List<IndexCommit> commits;  
        } catch (IOException e) {  
            throw new OpenSearchException("failed to find existing translog files", e);
        }  
        writeEmptyCheckpoint(tempEmptyCheckpoint, translogLen, gen, globalCheckpoint);  
        try {
        } catch (IndexNotFoundException infe) {
     * Write a translog containing the given translog UUID to the given location. Returns the number of bytes written.
        }  
            throw new OpenSearchException("unable to find a valid shard at [" + indexPath + "]", infe);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
            translogGeneration,
                    translogConfig,
            .append("\n\n");  
            final IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        }
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
            translogFiles = filesInDirectory(translogPath);  
                builder.append("\n");
        terminal.println("Removing existing translog files");
 */  
            ? Long.parseLong(commitData.get(SequenceNumbers.MAX_SEQ_NO))
import org.opensearch.common.UUIDs;
 * Licensed to Elasticsearch under one or more contributor  
/*  
                "",
        Files.move(tempEmptyTranslog, realEmptyTranslog, StandardCopyOption.ATOMIC_MOVE);
        final Path indexPath = shardPath.resolveIndex();
            if (it.hasNext()) {  
                    seqNo -> {},
        terminal.println("History UUID       : " + historyUUID);
            StandardOpenOption.CREATE_NEW
                false  
                    () -> translogGlobalCheckpoint,
import org.opensearch.index.IndexSettings;
import java.io.IOException;
                Translog translog = new LocalTranslog(
                    translogUUID,  
            StandardOpenOption.WRITE,  
    private final NamedXContentRegistry namedXContentRegistry;
                );
        }
        final long globalCheckpoint = commitData.containsKey(SequenceNumbers.MAX_SEQ_NO)  
        try {
 *  
        }
            : SequenceNumbers.UNASSIGNED_SEQ_NO;
    }  
        if (clean) {
                    () -> primaryTerm,  
        final String translogUUID = commitData.get(Translog.TRANSLOG_UUID_KEY);
        Directory indexDirectory
        if (translogUUID == null) {
            return header.sizeInBytes();
    }  
    }  
import java.nio.file.StandardCopyOption;  
import java.util.HashMap;
            globalCheckpoint,
        Set<Path> files = new TreeSet<>();  
                }  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                while (snapshot.next() != null) {
        try {
            commits = DirectoryReader.listCommits(indexDirectory);  
            final Path translogPath = shardPath.resolveTranslog();
 * under the License.  
 */
            }
                    TranslogOperationHelper.DEFAULT,
                Integer.MAX_VALUE
            translogLength,  
                shardPath.getShardId(),
        // Retrieve the generation and UUID from the existing data
            };
    }
        return builder.toString();
    }  
        try {
        Files.move(tempEmptyCheckpoint, realEmptyCheckpoint, StandardCopyOption.ATOMIC_MOVE);  
            }
import org.opensearch.common.settings.Settings;  
 * Unless required by applicable law or agreed to in writing,
/**  
            .append("  The following files will be DELETED at ")
        ShardPath shardPath,  
            final TranslogDeletionPolicy retainAllTranslogPolicy = new DefaultTranslogDeletionPolicy(
        }
        terminal.println("Creating new empty checkpoint at [" + realEmptyCheckpoint + "]");
        Checkpoint emptyCheckpoint = Checkpoint.emptyTranslogCheckpoint(
    /** Write a checkpoint file to the given location with the given generation */
            final TranslogConfig translogConfig = new TranslogConfig(  
            throw new OpenSearchException("failed to find existing translog files", e);  
        int translogLen = writeEmptyTranslog(tempEmptyTranslog, translogUUID);
        );  
 */  
            for (Path file : stream) {
 * license agreements. See the NOTICE file distributed with
                @Override  
        final Path translogPath = shardPath.resolveTranslog();
                Long.MAX_VALUE,
 *
    public void execute(Terminal terminal, ShardPath shardPath, Directory indexDirectory) throws IOException {
        final Map<String, String> commitData;
        } catch (TranslogCorruptedException e) {  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.io.IOUtils;
 * this file be licensed under the Apache-2.0 license or a
    }
        }
public class TruncateTranslogAction {
        Set<Path> translogFiles;  
import java.nio.file.DirectoryStream;  
            ) {  
        for (Iterator<Path> it = files.iterator(); it.hasNext();) {
        }  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        Path realEmptyTranslog = translogPath.resolve(Translog.TRANSLOG_FILE_PREFIX + gen + Translog.TRANSLOG_FILE_SUFFIX);
            .append(translogPath)
}  
    public Tuple<RemoveCorruptedShardDataCommand.CleanStatus, String> getCleanStatus(
                    for (TranslogReader reader : readers) {  
import java.nio.file.StandardOpenOption;
import org.opensearch.index.shard.ShardPath;
 * not use this file except in compliance with the License.
import org.opensearch.index.seqno.SequenceNumbers;  
        try {
        terminal.println("Translog UUID      : " + translogUUID);
import java.util.List;
            translogFiles = filesInDirectory(translogPath);
    private String deletingFilesDetails(Path translogPath, Set<Path> files) {  
        final String historyUUID = UUIDs.randomBase64UUID();  
        // Write empty checkpoint and translog to empty files
 * the Apache License, Version 2.0 (the "License"); you may
            StandardOpenOption.READ,
import org.apache.lucene.index.IndexCommit;
            terminal.println("Reading translog UUID information from Lucene commit from shard at [" + indexPath + "]");
        // Hold the lock open for the duration of the tool running
        builder.append("Documents inside of translog files will be lost.\n")  
            }
     */
        );
        throws IOException {
        // Fsync the translog directory after rename
        Path realEmptyCheckpoint = translogPath.resolve(Translog.CHECKPOINT_FILE_NAME);
/*
import org.opensearch.OpenSearchException;  
import java.util.Map;
        final String translogUUID = commitData.get(Translog.TRANSLOG_UUID_KEY);
        }
        terminal.println("Creating new empty translog at [" + realEmptyTranslog + "]");
import org.opensearch.common.util.BigArrays;
    private static int writeEmptyTranslog(Path filename, String translogUUID) throws IOException {  
        } catch (IOException e) {
    protected static final Logger logger = LogManager.getLogger(TruncateTranslogAction.class);
                translogPath,
        if (translogUUID == null) {
            // We open translog to check for corruption, do not clean anything.  
import org.apache.lucene.index.DirectoryReader;  
import org.apache.logging.log4j.Logger;
    public TruncateTranslogAction(NamedXContentRegistry namedXContentRegistry) {
        Path tempEmptyCheckpoint = translogPath.resolve("temp-" + Translog.CHECKPOINT_FILE_NAME);
                    }
            );
    private static Set<Path> filesInDirectory(Path directory) throws IOException {
            try (  
        final Path translogPath = shardPath.resolveTranslog();
            terminal.println("Checking existing translog files");
import java.util.Iterator;  
 * SPDX-License-Identifier: Apache-2.0
    ) throws IOException {  
import org.opensearch.index.shard.RemoveCorruptedShardDataCommand;
import java.nio.file.Files;
            throw new OpenSearchException("unable to list commits at [" + indexPath + "]", e);  
import java.util.Set;  
        // Hold the lock open for the duration of the tool running
            translogGeneration  
        commitData = commits.get(commits.size() - 1).getUserData();  
import org.opensearch.common.collect.Tuple;
        Path tempEmptyTranslog = translogPath.resolve("temp-" + Translog.TRANSLOG_FILE_PREFIX + gen + Translog.TRANSLOG_FILE_SUFFIX);
        return files;  
package org.opensearch.index.translog;
 *    http://www.apache.org/licenses/LICENSE-2.0
        } catch (IOException e) {
                    return minGen;  
        final long gen = 1;  
 * specific language governing permissions and limitations
            final IndexMetadata indexMetadata = clusterState.metadata().getIndexSafe(shardPath.getShardId().getIndex());
import java.util.TreeSet;
        ClusterState clusterState,
        // perform clean check of translog instead of corrupted marker file  
        this.namedXContentRegistry = namedXContentRegistry;
 * GitHub history for details.
import org.apache.lucene.store.Directory;
