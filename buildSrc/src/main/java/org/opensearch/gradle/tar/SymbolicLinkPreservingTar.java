            final boolean isPreserveFileTimestamps,
            public void processFile(final FileCopyDetailsInternal details) {  
 * Modifications Copyright OpenSearch Contributors. See
                break;
        }
                    tar.putArchiveEntry(entry);  
            return WorkResults.didWork(true);
            private void visitSymbolicLink(final FileCopyDetailsInternal details) {
                } catch (final UnsupportedOperationException e) {
        @Override
            case BZIP2:
import org.gradle.api.tasks.WorkResults;  
        private final long lastModifiedTimestamp;
                final File file;
    public void setLastModifiedTimestamp(long lastModifiedTimestamp) {  
 * KIND, either express or implied.  See the License for the
            } catch (final IOException e) {  
                } catch (final IOException e) {
            }
                        visitDirectory(details);
                break;
            private void visitFile(final FileCopyDetailsInternal details) {
 */  
            }
import java.util.Set;
import java.util.HashSet;
                entry.setSize(details.getSize());
import org.apache.commons.compress.archivers.zip.UnixStat;
                try {
                if (isChildOfVisitedSymbolicLink(details) == false) {
            private void handleProcessingException(final FileCopyDetailsInternal details, final IOException e) {  
                entry.setModTime(getModTime(details));  
            }
        }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.gradle.api.internal.file.archive.compression.ArchiveOutputStreamFactory;  
                try {
        SymbolicLinkPreservingTarCopyAction(
            this.isPreserveFileTimestamps = isPreserveFileTimestamps;  
                TarArchiveOutputStream tar = new TarArchiveOutputStream(out)
        this.lastModifiedTimestamp = lastModifiedTimestamp;
 *  
             * When Gradle walks the file tree, it will follow symbolic links. This means that if there is a symbolic link to a directory  
 * A custom archive task that assembles a tar archive that preserves symbolic links.
                    tar.putArchiveEntry(entry);  
    private long lastModifiedTimestamp = 0;
                try {
import java.io.OutputStream;
            /*
import org.gradle.api.file.FileCopyDetails;  
            default:
            }  
/*  
             * To avoid this, we track which symbolic links we have visited, and skip files that are children of symbolic links that we have
 * You may obtain a copy of the License at  
import org.gradle.api.internal.file.archive.compression.Bzip2Archiver;
                    tar.closeArchiveEntry();
import org.gradle.api.internal.file.CopyActionProcessingStreamAction;
        private class SymbolicLinkPreservingTarStreamAction implements CopyActionProcessingStreamAction {
            final ArchiveOutputStreamFactory compressor,  
                final File file;
                    return false;  
import org.gradle.api.tasks.WorkResult;
 * specific language governing permissions and limitations
            }  
                    if (isChildOf(symbolicLink, file)) return true;  
                return false;
import org.gradle.api.file.RegularFile;
 * not use this file except in compliance with the License.
 * compatible open source license.
 */
import org.gradle.api.tasks.bundling.Tar;
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.file.Files;  
                return Files.isSymbolicLink(file.toPath());
                final TarArchiveEntry entry = new TarArchiveEntry(details.getRelativePath().getPathString());
            this.tarFile = tarFile;
        }
                        visitSymbolicLink(details);  
            ) {  
                compressor = Bzip2Archiver.getCompressor();  
            private boolean isChildOfVisitedSymbolicLink(final FileCopyDetailsInternal details) {  
        private final Provider<RegularFile> tarFile;
            }
                stream.process(new SymbolicLinkPreservingTarStreamAction(tar));
            final long lastModifiedTimestamp
                }
                    // we get invoked with stubbed details, there is no way to introspect this other than catching this exception
                    return false;  
        final ArchiveOutputStreamFactory compressor;  
                final TarArchiveEntry entry = new TarArchiveEntry(details.getRelativePath().getPathString() + "/");
                tar.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
             * in the source file tree, we could otherwise end up duplicating the entries below that directory in the resulting tar archive.
 */
                final TarArchiveEntry entry = new TarArchiveEntry(details.getRelativePath().getPathString(), TarConstants.LF_SYMLINK);
import org.gradle.api.provider.Provider;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new GradleException("could not add [" + details + "] to tar file [" + tarFile + "]", e);
                }
                this.tar = tar;
import java.io.File;  
import org.gradle.api.internal.file.archive.compression.SimpleCompressor;  
 *
import org.apache.commons.compress.archivers.tar.TarConstants;  
package org.opensearch.gradle.tar;
 * this work for additional information regarding copyright
 * <p>  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
             */
            @Override
import org.gradle.api.internal.file.copy.CopyAction;
            private final TarArchiveOutputStream tar;  
        }
                    tar.closeArchiveEntry();
                    if (isSymbolicLink(details)) {
                try {  
    protected CopyAction createCopyAction() {
    }
                visitedSymbolicLinks.add(details.getFile());  
                entry.setMode(UnixStat.DIR_FLAG | details.getPermissions().toUnixNumeric());
/*  
}
                }  
                entry.setModTime(getModTime(details));
                    tar.putArchiveEntry(entry);
                    file = details.getFile();  
 * Unless required by applicable law or agreed to in writing,
            this.lastModifiedTimestamp = lastModifiedTimestamp;
        public WorkResult execute(final CopyActionProcessingStream stream) {
                }
                entry.setMode(UnixStat.FILE_FLAG | details.getPermissions().toUnixNumeric());
                    handleProcessingException(details, e);
            }
            final Provider<RegularFile> tarFile,
                entry.setMode(UnixStat.LINK_FLAG | details.getPermissions().toUnixNumeric());  
        switch (getCompression()) {
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
        }
                    details.copyTo(tar);
                compressor = GzipArchiver.getCompressor();  
/*
                entry.setModTime(getModTime(details));  
                } catch (final UnsupportedOperationException e) {
    @Override
            }
 */  
import org.gradle.api.internal.file.copy.FileCopyDetailsInternal;  
             * already visited.  
    }
import org.gradle.api.internal.file.copy.CopyActionProcessingStream;
        private long getModTime(final FileCopyDetails details) {  
                break;
            try (  
        ) {  
import org.gradle.api.GradleException;
                }
 * This task is necessary because the built-in task {@link org.gradle.api.tasks.bundling.Tar} does not preserve symbolic links.
                }
            this.compressor = compressor;
                }  
                    entry.setLinkName(Files.readSymbolicLink(details.getFile().toPath()).toString());
            }
 * ownership. Elasticsearch licenses this file to you under  
            private final Set<File> visitedSymbolicLinks = new HashSet<>();
        return new SymbolicLinkPreservingTarCopyAction(getArchiveFile(), compressor, isPreserveFileTimestamps(), lastModifiedTimestamp);  
import org.gradle.api.internal.file.archive.compression.GzipArchiver;
                } catch (final IOException e) {
            case GZIP:
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
                    handleProcessingException(details, e);  
        private final boolean isPreserveFileTimestamps;
                return file.toPath().startsWith(directory.toPath());  
                OutputStream out = compressor.createArchiveOutputStream(tarFile.get().getAsFile());
            private boolean isSymbolicLink(final FileCopyDetailsInternal details) {  
                for (final File symbolicLink : visitedSymbolicLinks) {
            private void visitDirectory(final FileCopyDetailsInternal details) {
 * under the License.  
    private static class SymbolicLinkPreservingTarCopyAction implements CopyAction {  
                throw new GradleException("failed writing tar file [" + tarFile + "]", e);
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
                    handleProcessingException(details, e);  
            SymbolicLinkPreservingTarStreamAction(final TarArchiveOutputStream tar) {
                    }
            return isPreserveFileTimestamps ? details.getLastModified() : lastModifiedTimestamp;
            private boolean isChildOf(final File directory, final File file) {
                    } else if (details.isDirectory()) {
                } catch (final IOException e) {
                    tar.closeArchiveEntry();  
        private final ArchiveOutputStreamFactory compressor;  
 *
                        visitFile(details);
public abstract class SymbolicLinkPreservingTar extends Tar {  
 * GitHub history for details.
            }  
                compressor = new SimpleCompressor();  
/**
                try {
 * The OpenSearch Contributors require contributions made to  
                    file = details.getFile();  
                    // we get invoked with stubbed details, there is no way to introspect this other than catching this exception
                    } else {  
