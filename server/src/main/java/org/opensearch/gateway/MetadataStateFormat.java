    }
        }
    public String getPrefix() {  
                    builder.startObject();  
     *  
        if (cleanup) {  
        if (generation > -1 && state == null) {
     * @return maximum id of state file or -1 if no such files are found  
    private static void deleteFileIfExists(Path stateLocation, Directory directory, String fileName) throws IOException {
                    builder.endObject();
            }  
     * Tries to load the latest state from the given data-locations.
        return write(state, false, locations);
import org.opensearch.common.lucene.store.IndexOutputOutputStream;  
     * Reads a new instance of the state from the given XContentParser  
    }  
            if (Files.exists(resolve)) {
    /**
import org.apache.lucene.store.IndexOutput;
        final String fileName = getStateFileName(newGenerationId);  
        for (Path stateFile : stateFiles) {  
    }
     * Tries to load the latest state from the given data-locations.
        final long oldGenerationId, newGenerationId;  
        return null;
 * @param <T> the type of the XContent base data-structure
        return prefix + generation + STATE_FILE_EXTENSION;
            }
     * Clean ups all state files not matching passed generation.  
     * @return the latest state or <code>null</code> if no state was found.  
        try {
     * @param dataLocations the data location to delete
 * specific language governing permissions and limitations
import java.io.FileNotFoundException;
        return newGenerationId;
        List<Tuple<Path, Directory>> directories = new ArrayList<>();
import java.util.List;
        return files;
        final List<Throwable> exceptions = new ArrayList<>();
     * But if this method succeeds, it does not perform cleanup of old state files.
 * not use this file except in compliance with the License.
                }  
                final XContentType xContentType = XContentType.values()[indexInput.readInt()];  
     * Subclasses need to implement this class for theirs specific state.
        final String fileNameToKeep = getStateFileName(currentGeneration);  
        return loadLatestStateWithGeneration(logger, namedXContentRegistry, dataLocations).v1();  
    protected Directory newDirectory(Path dir) throws IOException {
    private static void copyStateToExtraLocations(List<Tuple<Path, Directory>> stateDirs, String tmpFileName) throws WriteStateException {
     * newly created state file if write fails.  
        // if we reach this something went wrong
    public abstract T fromXContent(XContentParser parser) throws IOException;  
                logger.trace("generation id [{}] read from [{}]", generation, stateFile.getFileName());  
            try {
 * GitHub history for details.
import org.apache.lucene.store.IndexInput;
            cleanupOldFiles(newGenerationId, locations);
            logger.trace("cleanupOldFiles: cleaning up {}", location);
                throw new CorruptStateException(ex);
                CodecUtil.writeHeader(out, STATE_FILE_CODEC, STATE_FILE_VERSION);  
                stateDirectories.get(i).v2().syncMetaData();  
            deleteFileIfExists(stateLocation, directory, fileName);
import org.apache.lucene.store.NIOFSDirectory;  
 * Unless required by applicable law or agreed to in writing,
    public static final String STATE_FILE_EXTENSION = ".st";
     * If this method fails with an exception, it performs cleanup of newly created state file.
                );
                }  
     * more involved.  
     * Deletes all meta state directories recursively for the given data locations
                    toXContent(builder, state);
        }  
import org.apache.lucene.index.CorruptIndexException;
            );
 *  
            copyStateToExtraLocations(directories, tmpFileName);  
            throw new WriteStateException(false, "exception during looking up new generation id", e);
                    true,
    private static final int MIN_COMPATIBLE_STATE_FILE_VERSION = 1;
                    throw new IllegalStateException("expected state in " + file + " to be " + FORMAT + " format but was " + xContentType);
                extraStateDir.sync(Collections.singleton(tmpFileName));
        this.stateFilePattern = Pattern.compile(Pattern.quote(prefix) + "(\\d+)(" + MetadataStateFormat.STATE_FILE_EXTENSION + ")?");
            // We have some state files but none of them gave us a usable state
                out.writeInt(FORMAT.index());
import org.apache.lucene.index.IndexFormatTooNewException;  
            } catch (IOException e) {
                try (IndexInput slice = indexInput.slice("state_xcontent", filePointer, contentSize)) {  
    }  
        return new NIOFSDirectory(dir);
     */
            newGenerationId = oldGenerationId + 1;  
        }  
                    public void close() {
        } catch (Exception e) {
    public static final XContentType FORMAT = XContentType.SMILE;  
            throw new IllegalStateException(
    }
     * See also {@link #write(Object, Path...)} and {@link #cleanupOldFiles(long, Path[])}.
    private static final int STATE_FILE_VERSION = 1;  
            }  
     * If this write is not a part of bigger transaction, consider using {@link #writeAndCleanup(Object, Path...)} method instead.
    public String getStateFileName(long generation) {
    }
    private void writeStateToFirstLocation(final T state, Path stateLocation, Directory stateDir, String tmpFileName)
                    throw new WriteStateException(false, "failed to open state directory " + stateLocation, e);
     *  
            performRenames(tmpFileName, fileName, directories);
import org.opensearch.common.lucene.store.InputStreamIndexInput;
 */
    public final long write(final T state, final Path... locations) throws WriteStateException {  
        }
 * under the License.  
        if (stateFiles.size() > 0) {  
                CodecUtil.writeFooter(out);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private long write(final T state, boolean cleanup, final Path... locations) throws WriteStateException {
    private static void performStateDirectoriesFsync(List<Tuple<Path, Directory>> stateDirectories) throws WriteStateException {  
        }
 * The OpenSearch Contributors require contributions made to  
    /**  
                    ) {
    }
        return prefix;
     * @return the state of asked generation or <code>null</code> if no state was found.  
            Directory extraStateDir = extraStatePathAndDir.v2();
     *  
    /**
     * Creates a new {@link MetadataStateFormat} instance
        }  
 * license agreements. See the NOTICE file distributed with
     * @return tuple of the latest state and generation. (null, -1) if no state is found.  
    /**
                false,
                "failed to rename tmp file to final name in the first state location " + stateDirectories.get(0).v1().resolve(tmpFileName),
        }
    }
    private List<Path> findStateFilesByGeneration(final long generation, Path... locations) {
     * @param locations         state paths.  
                            )
                e  
        }
                throw new WriteStateException(false, "failed to copy tmp state file to extra location " + extraStateLocation, e);
     * Finds state file with maximum id.
    public Tuple<T, Long> loadLatestStateWithGeneration(Logger logger, NamedXContentRegistry namedXContentRegistry, Path... dataLocations)
            deleteFileIfExists(stateLocation, stateDir, tmpFileName);
import java.io.OutputStream;  
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;  
                    + Arrays.stream(dataLocations).map(Object::toString).collect(Collectors.joining(", "))  
            Path stateLocation = location.resolve(STATE_DIR_NAME);  
import java.util.Collections;
        if (generation == -1) {  
        for (Path location : locations) {
        IOUtils.rm(stateDirectories);  
     */
     * @param locations the locations where the state should be written to.
import org.apache.logging.log4j.LogManager;  
public abstract class MetadataStateFormat<T> {
    /**
                    if (file.startsWith(prefix) && file.equals(fileNameToKeep) == false) {  
        throws WriteStateException {
            );
                cleanupOldFiles(oldGenerationId, locations);
     * This method always performs cleanup of temporary files regardless whether it succeeds or fails. Cleanup logic for state files is
        for (int i = 0; i < dataLocations.length; i++) {  
package org.opensearch.gateway;
     * state directory ({@value #STATE_DIR_NAME}) underneath each of the given file locations and is created if it  
                })) {
            return files;
                    }
            for (Path location : locations) {
import java.nio.file.Path;
    }
     * @param logger        a logger instance.
            try {
                    }  
                        // this is important since some of the XContentBuilders write bytes on close.
            } catch (Exception e) {
import java.nio.file.NoSuchFileException;  
            }
        return maxId;
        } catch (FileNotFoundException | NoSuchFileException ignored) {
            throw new WriteStateException(  
                return state;
import org.opensearch.core.xcontent.XContentParser;
                        final Matcher matcher = stateFilePattern.matcher(stateFile.getFileName().toString());
        Directory srcStateDir = stateDirs.get(0).v2();  
     * doesn't exist. The state is serialized to a temporary file in that directory and is then atomically moved to
            try (IndexInput indexInput = EndiannessReverserUtil.openInput(dir, file.getFileName().toString(), IOContext.READONCE)) {
        for (Path dataLocation : locations) {
        }  
     *
    public T loadLatestState(Logger logger, NamedXContentRegistry namedXContentRegistry, Path... dataLocations) throws IOException {
     * Tries to load the state of particular generation from the given data-locations. If any of data locations contain state files with  
            writeStateToFirstLocation(state, directories.get(0).v1(), directories.get(0).v2(), tmpFileName);
import org.opensearch.core.xcontent.XContentBuilder;
            if (Files.exists(stateFilePath)) {
                for (String file : stateDir.listAll()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
                                LoggingDeprecationHandler.INSTANCE,
        try (Directory dir = newDirectory(file.getParent())) {
     * given generation, state will be loaded from these state files.
                e  
        return Tuple.tuple(state, generation);
            }  
    }
    }
 * Modifications Copyright OpenSearch Contributors. See  
        List<Path> stateFiles = findStateFilesByGeneration(generation, dataLocations);  
     * @param generation the generation to be loaded.
        long maxId = -1;
    }  
            throw e;
    }
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
    /**
    }  
                }
/**
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
import org.apache.logging.log4j.message.ParameterizedMessage;
    /**
        for (int i = 1; i < stateDirectories.size(); i++) {
                "unable to find state files with generation id "  
     * If this method returns without exception there is a guarantee that state is persisted to the disk and loadLatestState will return  
 * MetadataStateFormat is a base class to write checksummed
    /**  
            Path extraStateLocation = extraStatePathAndDir.v1();  
import org.apache.lucene.store.Directory;
        this.prefix = prefix;
import java.util.ArrayList;
                        if (matcher.matches()) {
            }
import java.io.IOException;
    }
            if (cleanup) {
                    directories.add(new Tuple<>(location, newDirectory(stateLocation)));
 * this work for additional information regarding copyright
    private static final String STATE_FILE_CODEC = "state";
 *
import org.apache.lucene.codecs.CodecUtil;
                    for (Path stateFile : stream) {  
        }
     *
                "failed to write state to the first location tmp file " + stateLocation.resolve(tmpFileName),
        for (int i = 1; i < stateDirs.size(); i++) {
     */
                exceptions.add(new IOException("failed to read " + stateFile, e));  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            }  
 * KIND, either express or implied.  See the License for the
     * Writes the given state to the given XContentBuilder  
 */  
                if (xContentType != FORMAT) {
        return write(state, true, locations);
    public abstract void toXContent(XContentBuilder builder, T state) throws IOException;  
     */
                            .createParser(  
            );
        Path[] stateDirectories = new Path[dataLocations.length];
        try {
                    "failed to rename tmp file to final name in extra state location " + stateDirectories.get(i).v1().resolve(tmpFileName),
            try {  
                "Could not find a state file to recover from among "  
                                namedXContentRegistry,
                throw new WriteStateException(true, "meta data directory fsync has failed " + stateDirectories.get(i).v1(), e);
        for (Path dataLocation : locations) {
            throw new IllegalArgumentException("One or more locations required");  
     * the state.
    private final Pattern stateFilePattern;
                    }
     * @param dataLocations the data-locations to try.
        }
     * @param locations - paths to directories with state folder
     * Writes the given state to the given directories. The state is written to a
     * @param logger        a logger instance.
        } catch (IOException e) {
                deleteFileIgnoreExceptions(pathAndDirectory.v1(), pathAndDirectory.v2(), tmpFileName);
     * Subclasses need to implement this class for theirs specific state.
/*
 * the Apache License, Version 2.0 (the "License"); you may
                logger.trace("found state file: {}", stateFilePath);
            performStateDirectoriesFsync(directories);
        assert newGenerationId >= 0 : "newGenerationId must be positive but was: [" + oldGenerationId + "]";
                }
     */
 * XContent based files to one or more directories in a standardized directory structure.  
    public final long writeAndCleanup(final T state, final Path... locations) throws WriteStateException {  
     * it's target filename of the pattern {@code {prefix}{version}.st}.
                        // in order to write the footer we need to prevent closing the actual index input.  
     * Reads the state from a given file and compares the expected version against the actual version of  
        final String tmpFileName = fileName + ".tmp";
                extraStateDir.copyFrom(srcStateDir, tmpFileName, tmpFileName, IOContext.READONCE);
        }
    private static final Logger logger = LogManager.getLogger(MetadataStateFormat.class);
        }
import org.opensearch.common.xcontent.XContentType;
     */
     */
     * @param state     the state object to write
        try {  
    /**
            stateDir.sync(Collections.singleton(tmpFileName));
            directory.deleteFile(fileName);
                false,
                Path stateLocation = location.resolve(STATE_DIR_NAME);  
            } catch (IOException e) {
            oldGenerationId = findMaxGenerationId(prefix, locations);
                extraStateDirectory.rename(tmpFileName, fileName);
        logger.trace("cleaned up {}", stateLocation.resolve(fileName));
        try {  
    }  
                        XContentParser parser = FORMAT.xContent()
     * Writes the given state to the given directories and performs cleanup of old state files if the write succeeds or
            final Path stateFilePath = dataLocation.resolve(STATE_DIR_NAME).resolve(fileName);  
    public T loadGeneration(Logger logger, NamedXContentRegistry namedXContentRegistry, long generation, Path... dataLocations) {
 * this file be licensed under the Apache-2.0 license or a
                                new InputStreamIndexInput(slice, contentSize)  
            try (IndexOutput out = EndiannessReverserUtil.createOutput(stateDir, tmpFileName, IOContext.READONCE)) {
    private long findMaxGenerationId(final String prefix, Path... locations) throws IOException {  
                try (XContentBuilder builder = newXContentBuilder(FORMAT, new IndexOutputOutputStream(out) {
                            maxId = Math.max(maxId, id);
    /**
        T state = loadGeneration(logger, namedXContentRegistry, generation, dataLocations);
            }
                            final long id = Long.parseLong(matcher.group(1));  
     * @param currentGeneration state generation to keep.
 * You may obtain a copy of the License at  
            firstStateDirectory.rename(tmpFileName, fileName);
            } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException ex) {  
                    + " returned by findMaxGenerationId function, in data folders ["
            throw new WriteStateException(  
        if (locations == null) {
     * After transaction is finished use {@link #cleanupOldFiles(long, Path[])} for the clean-up.
        List<Path> files = new ArrayList<>();
     *  
    private final String prefix;
                long filePointer = indexInput.getFilePointer();
    protected XContentBuilder newXContentBuilder(XContentType type, OutputStream stream) throws IOException {
            try {
     */  
        }
                    }
 */
import org.apache.lucene.index.IndexFormatTooOldException;
                logger.debug(() -> new ParameterizedMessage("{}: failed to read [{}], ignoring...", stateFile, prefix), e);
    protected MetadataStateFormat(String prefix) {  
import org.opensearch.common.collect.Tuple;
    public static final String STATE_DIR_NAME = "_state";
    }
    private static void deleteFileIgnoreExceptions(Path stateLocation, Directory directory, String fileName) {
                long contentSize = indexInput.length() - CodecUtil.footerLength() - filePointer;
     */
        }
        }  
     * @param dataLocations the data-locations to try.
        final String fileName = getStateFileName(generation);
        } catch (Exception e) {
            final Path resolve = dataLocation.resolve(STATE_DIR_NAME);  
            try (Directory stateDir = newDirectory(stateLocation)) {
                }  
    }
    }
     * @param prefix    - filename prefix
                throw new WriteStateException(  
    }
        try {  
                    e  
    /**
 *
            }  
 * Licensed to Elasticsearch under one or more contributor  
                CodecUtil.checkHeader(indexInput, STATE_FILE_CODEC, MIN_COMPATIBLE_STATE_FILE_VERSION, STATE_FILE_VERSION);
                T state = read(namedXContentRegistry, stateFile);
                    + stateFiles.stream().map(Object::toString).collect(Collectors.joining(", "))
                // We checksum the entire file before we even go and parse it. If it's corrupted we barf right here.  
                logger.trace("clean up failed for state location {}", stateLocation);
    }
        }  
     * it.<br>
}  
import java.util.Arrays;  
import org.opensearch.common.util.io.IOUtils;
     */
import java.util.stream.Collectors;
                    + "], concurrent writes?"
                    + generation
                } catch (IOException e) {  
     * @param dataLocations the data-locations to try.
     * @return generation of newly written state.
    private static void performRenames(String tmpFileName, String fileName, final List<Tuple<Path, Directory>> stateDirectories)  
/*
                        }
        } catch (WriteStateException e) {  
                    try (
import java.nio.file.Files;
                try {
    }  
 */
                IOUtils.closeWhileHandlingException(pathAndDirectory.v2());
        return MediaTypeRegistry.contentBuilder(type, stream);
 * software distributed under the License is distributed on an
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
            );
 * SPDX-License-Identifier: Apache-2.0
                        return fromXContent(parser);  
import java.util.regex.Matcher;  
        for (int i = 0; i < stateDirectories.size(); i++) {
        throws WriteStateException {
            Directory extraStateDirectory = stateDirectories.get(i).v2();
        }
        } finally {
            throw new IllegalArgumentException("Locations must not be null");  
            }
     * If this write succeeds, but some further write fails, you may want to rollback the transaction and keep old file around.  
            } catch (Exception e) {
            }  
        throws IOException {  
/*  
                // we trick this into a dedicated exception with the original stacktrace
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(resolve, prefix + "*")) {
 * compatible open source license.
            for (Tuple<Path, Directory> pathAndDirectory : directories) {  
            }
        } catch (IOException e) {
                }
        try {  
                files.add(stateFilePath);  
import org.apache.logging.log4j.Logger;
 * @opensearch.internal  
        if (locations.length <= 0) {
                deleteFileIfExists(extraStateLocation, extraStateDir, tmpFileName);  
            throw new IllegalStateException(
            stateDirectories[i] = dataLocations[i].resolve(STATE_DIR_NAME);
            } catch (Exception e) {  
    public static void deleteMetaState(Path... dataLocations) throws IOException {
import org.apache.lucene.store.IOContext;  
     * @throws WriteStateException if some exception during writing state occurs. See also {@link WriteStateException#isDirty()}.  
                CodecUtil.checksumEntireFile(indexInput);
        }  
        long generation = findMaxGenerationId(prefix, dataLocations);
    public final T read(NamedXContentRegistry namedXContentRegistry, Path file) throws IOException {  
            logger.trace("clean up failed {}", stateLocation.resolve(fileName));  
                        deleteFileIgnoreExceptions(stateLocation, stateDir, file);
 * ownership. Elasticsearch licenses this file to you under  
import java.nio.file.DirectoryStream;
import org.opensearch.ExceptionsHelper;
     * @param logger a logger instance.  
    public void cleanupOldFiles(final long currentGeneration, Path[] locations) {
                    @Override  
     */
     * @throws IOException if IOException occurs
            Tuple<Path, Directory> extraStatePathAndDir = stateDirs.get(i);
        }
import java.util.regex.Pattern;
        Directory firstStateDirectory = stateDirectories.get(0).v2();
     */
