                files.add(stateFilePath);
     * @return maximum id of state file or -1 if no such files are found
public abstract class MetadataStateFormat<T> {
                final XContentType xContentType = XContentType.values()[indexInput.readInt()];
        }
        try (Directory dir = newDirectory(file.getParent())) {
    public final long writeAndCleanup(final T state, final Path... locations) throws WriteStateException {
            );
     * Subclasses need to implement this class for theirs specific state.
    }
 * Unless required by applicable law or agreed to in writing,
                }
    private static final int STATE_FILE_VERSION = 1;
/*
        }
            deleteFileIfExists(stateLocation, directory, fileName);
     * @param logger a logger instance.
            }
                CodecUtil.checkHeader(indexInput, STATE_FILE_CODEC, MIN_COMPATIBLE_STATE_FILE_VERSION, STATE_FILE_VERSION);
        for (int i = 0; i < dataLocations.length; i++) {
    /**
        final String tmpFileName = fileName + ".tmp";
    }
            }
     * @param locations         state paths.
import org.apache.lucene.store.IOContext;
 * under the License.
    /**
            Path stateLocation = location.resolve(STATE_DIR_NAME);
        } catch (IOException e) {
        return newGenerationId;
import java.util.regex.Pattern;
     * Clean ups all state files not matching passed generation.
        Directory srcStateDir = stateDirs.get(0).v2();
        Path[] stateDirectories = new Path[dataLocations.length];
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(resolve, prefix + "*")) {
    /**
            throw new IllegalArgumentException("One or more locations required");
                }
                                namedXContentRegistry,
        } catch (Exception e) {
     * it.<br>
 * XContent based files to one or more directories in a standardized directory structure.
import org.opensearch.common.util.io.IOUtils;
            throw new WriteStateException(
    private static final int MIN_COMPATIBLE_STATE_FILE_VERSION = 1;
 * license agreements. See the NOTICE file distributed with
    private static final String STATE_FILE_CODEC = "state";
package org.opensearch.gateway;
import org.opensearch.core.xcontent.XContentParser;
            for (Tuple<Path, Directory> pathAndDirectory : directories) {
import java.util.Collections;
        for (Path stateFile : stateFiles) {
     * @param state     the state object to write
                    }
     * After transaction is finished use {@link #cleanupOldFiles(long, Path[])} for the clean-up.
/**
        }
 * not use this file except in compliance with the License.
     * state directory ({@value #STATE_DIR_NAME}) underneath each of the given file locations and is created if it
 * GitHub history for details.
        return prefix + generation + STATE_FILE_EXTENSION;
            logger.trace("clean up failed {}", stateLocation.resolve(fileName));
                    + generation
            Path extraStateLocation = extraStatePathAndDir.v1();
        final String fileName = getStateFileName(generation);
                try (IndexInput slice = indexInput.slice("state_xcontent", filePointer, contentSize)) {
        final long oldGenerationId, newGenerationId;
                        deleteFileIgnoreExceptions(stateLocation, stateDir, file);
            try (IndexOutput out = EndiannessReverserUtil.createOutput(stateDir, tmpFileName, IOContext.READONCE)) {
            }
    public abstract T fromXContent(XContentParser parser) throws IOException;
            throw new IllegalStateException(
    private static void performStateDirectoriesFsync(List<Tuple<Path, Directory>> stateDirectories) throws WriteStateException {
import org.opensearch.common.collect.Tuple;
            cleanupOldFiles(newGenerationId, locations);
        final String fileNameToKeep = getStateFileName(currentGeneration);
    private final String prefix;
     *
                    + " returned by findMaxGenerationId function, in data folders ["
        }
    }
        try {
        }
        try {
            stateDirectories[i] = dataLocations[i].resolve(STATE_DIR_NAME);
    }
                    try (
     * Deletes all meta state directories recursively for the given data locations
 * ownership. Elasticsearch licenses this file to you under
        return write(state, false, locations);
     * Reads a new instance of the state from the given XContentParser
    private final Pattern stateFilePattern;
        try {
        try {
            logger.trace("cleanupOldFiles: cleaning up {}", location);
    }
        if (stateFiles.size() > 0) {
                    for (Path stateFile : stream) {
    /**
import org.apache.logging.log4j.LogManager;
     *
        } catch (WriteStateException e) {
                            final long id = Long.parseLong(matcher.group(1));
    }
     */
        if (generation > -1 && state == null) {
            } catch (Exception e) {
     *
 */
     * @return the latest state or <code>null</code> if no state was found.
     * @return the state of asked generation or <code>null</code> if no state was found.
     */
                throw new CorruptStateException(ex);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                "Could not find a state file to recover from among "
 *
            throw new WriteStateException(
        long generation = findMaxGenerationId(prefix, dataLocations);
import java.util.regex.Matcher;
 * compatible open source license.
            }
            throw e;
import org.apache.lucene.store.IndexOutput;
        return Tuple.tuple(state, generation);
                    directories.add(new Tuple<>(location, newDirectory(stateLocation)));
            }
                    + "], concurrent writes?"
        return null;
                IOUtils.closeWhileHandlingException(pathAndDirectory.v2());
     * If this method fails with an exception, it performs cleanup of newly created state file.
        throws WriteStateException {
     * Subclasses need to implement this class for theirs specific state.
     */
     * Tries to load the latest state from the given data-locations.
                long contentSize = indexInput.length() - CodecUtil.footerLength() - filePointer;
    }
        }
     * @param logger        a logger instance.
import java.nio.file.Path;
                "failed to rename tmp file to final name in the first state location " + stateDirectories.get(0).v1().resolve(tmpFileName),
            if (Files.exists(stateFilePath)) {
            stateDir.sync(Collections.singleton(tmpFileName));
                    }
    }
import java.util.Arrays;
import org.opensearch.core.xcontent.XContentBuilder;
     */
        return write(state, true, locations);
        // if we reach this something went wrong
                try (XContentBuilder builder = newXContentBuilder(FORMAT, new IndexOutputOutputStream(out) {
    protected MetadataStateFormat(String prefix) {
            }
    }
}
        return maxId;
    protected Directory newDirectory(Path dir) throws IOException {
                }
import java.nio.file.Files;
 * The OpenSearch Contributors require contributions made to
     *
import org.opensearch.ExceptionsHelper;
    /**
    }
            } catch (Exception e) {
    }
                throw new WriteStateException(false, "failed to copy tmp state file to extra location " + extraStateLocation, e);
        }
    /**
    public String getStateFileName(long generation) {
                    throw new WriteStateException(false, "failed to open state directory " + stateLocation, e);
     * Writes the given state to the given directories and performs cleanup of old state files if the write succeeds or
        Directory firstStateDirectory = stateDirectories.get(0).v2();
    /**
     * But if this method succeeds, it does not perform cleanup of old state files.
    private static void copyStateToExtraLocations(List<Tuple<Path, Directory>> stateDirs, String tmpFileName) throws WriteStateException {
                throw new WriteStateException(
 * You may obtain a copy of the License at
        throws WriteStateException {
        }
            if (Files.exists(resolve)) {
            try {
     * If this write is not a part of bigger transaction, consider using {@link #writeAndCleanup(Object, Path...)} method instead.
        for (Path dataLocation : locations) {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    private long write(final T state, boolean cleanup, final Path... locations) throws WriteStateException {
        }
                e
import org.apache.lucene.store.IndexInput;
    }
     */
                return state;
    }
        long maxId = -1;
     * the state.
import org.opensearch.common.lucene.store.InputStreamIndexInput;
            try (IndexInput indexInput = EndiannessReverserUtil.openInput(dir, file.getFileName().toString(), IOContext.READONCE)) {
                    }
            if (cleanup) {
                Path stateLocation = location.resolve(STATE_DIR_NAME);
            }
        if (cleanup) {
import java.nio.file.DirectoryStream;
                extraStateDir.copyFrom(srcStateDir, tmpFileName, tmpFileName, IOContext.READONCE);
 */
        for (Path location : locations) {
     */
    public static final String STATE_FILE_EXTENSION = ".st";
            try (Directory stateDir = newDirectory(stateLocation)) {
 *
                    toXContent(builder, state);
 * specific language governing permissions and limitations
     * This method always performs cleanup of temporary files regardless whether it succeeds or fails. Cleanup logic for state files is
import org.opensearch.common.lucene.store.IndexOutputOutputStream;
     * @return generation of newly written state.
    /**
            }
        }
            throw new IllegalArgumentException("Locations must not be null");
        List<Path> stateFiles = findStateFilesByGeneration(generation, dataLocations);
            firstStateDirectory.rename(tmpFileName, fileName);
                    builder.startObject();
                            )
                throw new WriteStateException(true, "meta data directory fsync has failed " + stateDirectories.get(i).v1(), e);
     * it's target filename of the pattern {@code {prefix}{version}.st}.
    }
import java.io.IOException;
        } catch (IOException e) {
 * Licensed to Elasticsearch under one or more contributor
                    @Override
                } catch (IOException e) {
        IOUtils.rm(stateDirectories);
                            maxId = Math.max(maxId, id);
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        // in order to write the footer we need to prevent closing the actual index input.
                "failed to write state to the first location tmp file " + stateLocation.resolve(tmpFileName),
        for (int i = 1; i < stateDirectories.size(); i++) {
                }
import org.apache.lucene.index.IndexFormatTooOldException;
     * @return tuple of the latest state and generation. (null, -1) if no state is found.
     * See also {@link #write(Object, Path...)} and {@link #cleanupOldFiles(long, Path[])}.
 * SPDX-License-Identifier: Apache-2.0
        final String fileName = getStateFileName(newGenerationId);
                }
        try {
    private static final Logger logger = LogManager.getLogger(MetadataStateFormat.class);
                stateDirectories.get(i).v2().syncMetaData();
    public Tuple<T, Long> loadLatestStateWithGeneration(Logger logger, NamedXContentRegistry namedXContentRegistry, Path... dataLocations)
    }
                out.writeInt(FORMAT.index());
import org.apache.lucene.codecs.CodecUtil;
                            .createParser(
    public T loadLatestState(Logger logger, NamedXContentRegistry namedXContentRegistry, Path... dataLocations) throws IOException {
                long filePointer = indexInput.getFilePointer();
import org.opensearch.common.xcontent.XContentType;
     */
    public void cleanupOldFiles(final long currentGeneration, Path[] locations) {
                exceptions.add(new IOException("failed to read " + stateFile, e));
    private static void deleteFileIgnoreExceptions(Path stateLocation, Directory directory, String fileName) {
        return MediaTypeRegistry.contentBuilder(type, stream);
            Tuple<Path, Directory> extraStatePathAndDir = stateDirs.get(i);
                logger.trace("clean up failed for state location {}", stateLocation);
     */
                deleteFileIfExists(extraStateLocation, extraStateDir, tmpFileName);
        for (int i = 1; i < stateDirs.size(); i++) {
            copyStateToExtraLocations(directories, tmpFileName);
     * @param dataLocations the data location to delete
                // We checksum the entire file before we even go and parse it. If it's corrupted we barf right here.
     * more involved.
     * Tries to load the latest state from the given data-locations.
            );
        this.prefix = prefix;
import java.util.stream.Collectors;
     * Tries to load the state of particular generation from the given data-locations. If any of data locations contain state files with
                );
/*
        }
                        // this is important since some of the XContentBuilders write bytes on close.
     */
     * If this method returns without exception there is a guarantee that state is persisted to the disk and loadLatestState will return
     * Reads the state from a given file and compares the expected version against the actual version of
            final Path stateFilePath = dataLocation.resolve(STATE_DIR_NAME).resolve(fileName);
    /**
        try {
        }
                        XContentParser parser = FORMAT.xContent()
            }
import org.apache.lucene.index.IndexFormatTooNewException;
     * @param currentGeneration state generation to keep.
     * If this write succeeds, but some further write fails, you may want to rollback the transaction and keep old file around.
        if (locations == null) {
            newGenerationId = oldGenerationId + 1;
/*
     * @param dataLocations the data-locations to try.
 *
                "unable to find state files with generation id "
                false,
        }
                    e
 * the Apache License, Version 2.0 (the "License"); you may
                    builder.endObject();
     * @param logger        a logger instance.
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
    public final T read(NamedXContentRegistry namedXContentRegistry, Path file) throws IOException {
     *
                cleanupOldFiles(oldGenerationId, locations);
        }
     * @param locations - paths to directories with state folder
    }
                    ) {
     */
        }
import java.io.FileNotFoundException;
                false,
        final List<Throwable> exceptions = new ArrayList<>();
    /**
            throw new IllegalStateException(
        }
     * given generation, state will be loaded from these state files.
                        final Matcher matcher = stateFilePattern.matcher(stateFile.getFileName().toString());
                logger.trace("found state file: {}", stateFilePath);
            return files;
    /**
    private static void performRenames(String tmpFileName, String fileName, final List<Tuple<Path, Directory>> stateDirectories)
        } finally {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * @throws WriteStateException if some exception during writing state occurs. See also {@link WriteStateException#isDirty()}.
import org.apache.lucene.store.Directory;
        List<Path> files = new ArrayList<>();
        return files;
        return prefix;
        }
        assert newGenerationId >= 0 : "newGenerationId must be positive but was: [" + oldGenerationId + "]";
                if (xContentType != FORMAT) {
import java.nio.file.NoSuchFileException;
            }
            } catch (IOException e) {
    public T loadGeneration(Logger logger, NamedXContentRegistry namedXContentRegistry, long generation, Path... dataLocations) {
            }
 * this work for additional information regarding copyright
        }
     */
    /**
     * newly created state file if write fails.
     * @param dataLocations the data-locations to try.
        throws IOException {
 * MetadataStateFormat is a base class to write checksummed
    public static void deleteMetaState(Path... dataLocations) throws IOException {
    }
                CodecUtil.writeHeader(out, STATE_FILE_CODEC, STATE_FILE_VERSION);
    }
            } catch (Exception e) {
import org.apache.lucene.store.NIOFSDirectory;
     * @throws IOException if IOException occurs
     * Writes the given state to the given directories. The state is written to a
    private long findMaxGenerationId(final String prefix, Path... locations) throws IOException {
            Directory extraStateDirectory = stateDirectories.get(i).v2();
                    "failed to rename tmp file to final name in extra state location " + stateDirectories.get(i).v1().resolve(tmpFileName),
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
                        return fromXContent(parser);
            Directory extraStateDir = extraStatePathAndDir.v2();
    }
            );
                deleteFileIgnoreExceptions(pathAndDirectory.v1(), pathAndDirectory.v2(), tmpFileName);
        T state = loadGeneration(logger, namedXContentRegistry, generation, dataLocations);
        }
    public String getPrefix() {
        for (int i = 0; i < stateDirectories.size(); i++) {
     * @param prefix    - filename prefix
            final Path resolve = dataLocation.resolve(STATE_DIR_NAME);
     */
     * Finds state file with maximum id.
    public abstract void toXContent(XContentBuilder builder, T state) throws IOException;
            writeStateToFirstLocation(state, directories.get(0).v1(), directories.get(0).v2(), tmpFileName);
                try {
 * software distributed under the License is distributed on an
            oldGenerationId = findMaxGenerationId(prefix, locations);
        List<Tuple<Path, Directory>> directories = new ArrayList<>();
        }
import org.apache.logging.log4j.Logger;
        if (generation == -1) {
        }
import java.io.OutputStream;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new WriteStateException(false, "exception during looking up new generation id", e);
     * Creates a new {@link MetadataStateFormat} instance
                logger.debug(() -> new ParameterizedMessage("{}: failed to read [{}], ignoring...", stateFile, prefix), e);
                extraStateDirectory.rename(tmpFileName, fileName);
 * Modifications Copyright OpenSearch Contributors. See
            performStateDirectoriesFsync(directories);
import org.apache.logging.log4j.message.ParameterizedMessage;
     * @param generation the generation to be loaded.
     * Writes the given state to the given XContentBuilder
            // We have some state files but none of them gave us a usable state
                                LoggingDeprecationHandler.INSTANCE,
    }
            deleteFileIfExists(stateLocation, stateDir, tmpFileName);
            );
                T state = read(namedXContentRegistry, stateFile);
 * @param <T> the type of the XContent base data-structure
     * @param dataLocations the data-locations to try.
                        if (matcher.matches()) {
                // we trick this into a dedicated exception with the original stacktrace
 *
     *
        logger.trace("cleaned up {}", stateLocation.resolve(fileName));
        if (locations.length <= 0) {
    protected XContentBuilder newXContentBuilder(XContentType type, OutputStream stream) throws IOException {
        return new NIOFSDirectory(dir);
            directory.deleteFile(fileName);
                    true,
    }
    public static final String STATE_DIR_NAME = "_state";
    public final long write(final T state, final Path... locations) throws WriteStateException {
            try {
                                new InputStreamIndexInput(slice, contentSize)
            } catch (IOException e) {
        this.stateFilePattern = Pattern.compile(Pattern.quote(prefix) + "(\\d+)(" + MetadataStateFormat.STATE_FILE_EXTENSION + ")?");
                e
                    throw new IllegalStateException("expected state in " + file + " to be " + FORMAT + " format but was " + xContentType);
            } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException ex) {
 * @opensearch.internal
        for (Path dataLocation : locations) {
                }
            for (Path location : locations) {
                    + Arrays.stream(dataLocations).map(Object::toString).collect(Collectors.joining(", "))
    private List<Path> findStateFilesByGeneration(final long generation, Path... locations) {
                CodecUtil.checksumEntireFile(indexInput);
        return loadLatestStateWithGeneration(logger, namedXContentRegistry, dataLocations).v1();
            performRenames(tmpFileName, fileName, directories);
    public static final XContentType FORMAT = XContentType.SMILE;
                        }
import java.util.ArrayList;
            try {
                    public void close() {
 */
 */
        } catch (FileNotFoundException | NoSuchFileException ignored) {
     * @param locations the locations where the state should be written to.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                })) {
                    if (file.startsWith(prefix) && file.equals(fileNameToKeep) == false) {
            try {
                    }
                for (String file : stateDir.listAll()) {
                extraStateDir.sync(Collections.singleton(tmpFileName));
                CodecUtil.writeFooter(out);
import org.apache.lucene.index.CorruptIndexException;
                logger.trace("generation id [{}] read from [{}]", generation, stateFile.getFileName());
    private void writeStateToFirstLocation(final T state, Path stateLocation, Directory stateDir, String tmpFileName)
     * doesn't exist. The state is serialized to a temporary file in that directory and is then atomically moved to
                    + stateFiles.stream().map(Object::toString).collect(Collectors.joining(", "))
    private static void deleteFileIfExists(Path stateLocation, Directory directory, String fileName) throws IOException {
import java.util.List;
        } catch (Exception e) {
