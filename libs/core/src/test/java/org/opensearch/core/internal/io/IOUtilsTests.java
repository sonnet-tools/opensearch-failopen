        assertThat(e.getMessage(), equalTo(Integer.toString(indexesThatThrow.get(0))));
 */
         * Create a new instance, wrapping {@code delegate}.
            throws IOException {
        public FileChannel newFileChannel(final Path path, final Set<? extends OpenOption> options, final FileAttribute<?>... attrs)
            verify(closeables[i]).close();
            final Closeable closeable = mock(Closeable.class);
        }
 */
        runTestRm(true);
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            }
                Path location = locations[i];
        for (int i = 0; i < numberOfCloseables; i++) {
                while (true) {
import java.nio.file.FileSystem;
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        if (indexesThatThrow.isEmpty() || randomBoolean()) {
import static org.hamcrest.Matchers.arrayWithSize;
import java.util.Arrays;
            final IOException e = expectThrows(IOException.class, () -> IOUtils.rm(locations));
            assertThat(e, hasToString(containsString("could not remove the following files (in the order of attempts):")));
            for (final Path locationThrowingException : locationsThrowingException) {
import static org.hamcrest.Matchers.equalTo;
        public void delete(final Path path) throws IOException {
    }
    }
import java.io.IOException;
        runDeleteFilesIgnoringExceptionsTest(Function.identity(), IOUtils::deleteFilesIgnoringExceptions);
    private static final class AccessDeniedWhileDeletingFileSystem extends FilterFileSystemProvider {
            verifyNoMoreInteractions(closeables[i]);
                final Path wrapped = ffsp.wrapPath(location);
         */
 * (the "License"); you may not use this file except in compliance with
        runTestCloseWithIOExceptions((Function<Closeable[], List<Closeable>>) Arrays::asList, IOUtils::close);
        IOUtils.fsync(file, false);
                doThrow(new IOException(Integer.toString(i))).when(closeable).close();
        final Closeable[] closeables = new Closeable[numberOfCloseables];
        @Override
package org.opensearch.core.internal.io;
    }
            }
        close.accept(function.apply(closeables));
    private <T> void runTestCloseWithIOExceptions(final Function<Closeable[], T> function, final CheckedConsumer<T, IOException> close)
        for (int i = 0; i < numberOfLocations; i++) {
 * this work for additional information regarding copyright ownership.
import org.apache.lucene.tests.mockfile.FilterPath;
                    }
            closeables[i] = mock(Closeable.class);
 * compatible open source license.
        }
 * distributed under the License is distributed on an "AS IS" BASIS,
    }
        final Path subPath = path.resolve(randomAlphaOfLength(8));
            if (locationsThrowingException.contains(locations[i]) == false) {
                        Files.createTempFile(location, randomAlphaOfLength(8), null);
        }
        }
            if (exception && randomBoolean()) {
        final Path path = createTempDir().toRealPath();
import org.apache.lucene.util.Constants;
    public void testFsyncAccessDeniedOpeningDirectory() throws Exception {
        for (int i = 0; i < numberOfFiles; i++) {
            }
                locations[i] = createTempDir();
        }
    public void testFsyncNonExistentDirectory() throws Exception {
import java.nio.file.Files;
 *
    public void testCloseIterable() throws IOException {
        }
        final Path[] files = new Path[numberOfFiles];
            }
import java.io.Closeable;
        }
/*
    }
        }
import java.nio.file.OpenOption;
 *
            super("access_denied://", Objects.requireNonNull(delegate));
        final int numberOfFiles = randomIntBetween(0, 7);
    public void runTestRm(final boolean exception) throws IOException {
                throw new AccessDeniedException(path.toString());
 * SPDX-License-Identifier: Apache-2.0
                locationsThrowingException.add(locations[i]);
            }
/*
        final Path subPath = path.resolve(randomAlphaOfLength(8));
    public void testCloseArrayWithIOExceptions() throws IOException {
 * The ASF licenses this file to You under the Apache License, Version 2.0
            } else {
 * Unless required by applicable law or agreed to in writing, software
        }
    }
            indexesThatThrow.add(numberOfCloseables - 1);
    public void testDeleteFilesIgnoringExceptionsIterable() throws IOException {
    private static final class AccessDeniedWhileOpeningDirectoryFileSystem extends FilterFileSystemProvider {
 */
    }
    }
        final int numberOfLocations = randomIntBetween(0, 7);
    }
    public void testCloseIterableWithIOExceptions() throws IOException {
 * limitations under the License.
        }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.attribute.FileAttribute;
        }
                    location = Files.createDirectory(location.resolve(randomAlphaOfLength(8)));
                final Path temporary = createTempFile();
import java.nio.file.NoSuchFileException;
        /**
        runTestClose((Function<Closeable[], List<Closeable>>) Arrays::asList, IOUtils::close);
            }
                final FilterFileSystemProvider ffsp = new AccessDeniedWhileDeletingFileSystem(location.getFileSystem());
                    if (rarely() == false) {
import java.util.Set;
                final Path location = createTempDir();
    }
    }
            IOUtils.rm(locations);
import static org.hamcrest.Matchers.containsString;
        runTestRm(false);
        deleteFilesIgnoringExceptions.accept(function.apply(files));
        @Override
        AccessDeniedWhileOpeningDirectoryFileSystem(final FileSystem delegate) {
            }
        }
        throws IOException {
        AccessDeniedWhileDeletingFileSystem(final FileSystem delegate) {
                indexesThatThrow.add(i);
            super.delete(path);
import org.opensearch.common.util.io.IOUtils;
        runTestCloseWithIOExceptions(Function.identity(), IOUtils::close);
        } else {
        // no exception
                files[i] = PathUtils.get(temporary.toString(), randomAlphaOfLength(8));
    public void testDeleteFilesIgnoringExceptionsArray() throws IOException {
                }
            if (Files.exists(path)) {
 * contributor license agreements.  See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
                Files.delete(temporary);
import static org.mockito.Mockito.verifyNoMoreInteractions;
                assertThat(e, hasToString(containsString("access denied while trying to delete file [" + locationThrowingException + "]")));
        for (int i = 0; i < numberOfCloseables; i++) {
        assertThat(e.getSuppressed(), arrayWithSize(indexesThatThrow.size() - 1));
import java.util.List;
 *
import static org.hamcrest.Matchers.hasToString;
        if (locationsThrowingException.isEmpty()) {
import java.nio.charset.StandardCharsets;
            doThrow(new IOException(Integer.toString(numberOfCloseables - 1))).when(closeable).close();
import java.io.OutputStream;
import java.util.Objects;
                        break;
}
    public void testRm() throws IOException {
                files[i] = createTempFile();
import org.opensearch.common.CheckedConsumer;
        }
            expectThrows(AccessDeniedException.class, () -> IOUtils.fsync(wrapped, true));
                locations[i] = wrapped.resolve(randomAlphaOfLength(8));
        IOUtils.fsync(subPath, true);
            } else {
import java.util.function.Function;
 * the License.  You may obtain a copy of the License at
        runDeleteFilesIgnoringExceptionsTest((Function<Path[], List<Path>>) Arrays::asList, IOUtils::deleteFilesIgnoringExceptions);
        for (int i = 1; i < indexesThatThrow.size(); i++) {
            o.write("0\n".getBytes(StandardCharsets.US_ASCII));
                Files.createDirectory(locations[i]);
/* @notice
        Files.createDirectories(subPath);
            if (randomBoolean()) {
        final Function<Path[], T> function,
import java.util.ArrayList;
import static org.mockito.Mockito.verify;
    private <T> void runTestClose(final Function<Closeable[], T> function, final CheckedConsumer<T, IOException> close) throws IOException {
            assertFalse(files[i].toString(), Files.exists(files[i]));
import static org.mockito.Mockito.mock;
        }
            if (randomBoolean()) {
        }
    }
        final List<Integer> indexesThatThrow = new ArrayList<>(numberOfCloseables);
 * this file be licensed under the Apache-2.0 license or a
    }
        final int numberOfCloseables = randomIntBetween(0, 7);
import java.nio.channels.FileChannel;
import org.opensearch.test.OpenSearchTestCase;
        final Path nonExistentDir = dir.resolve("non-existent");
        expectThrows(NoSuchFileException.class, () -> IOUtils.fsync(nonExistentDir, true));
import org.opensearch.common.io.PathUtils;
            if (Files.isDirectory(path)) {
        final IOException e = expectThrows(IOException.class, () -> close.accept(function.apply(closeables)));
        // no exception
        for (int i = 0; i < numberOfCloseables - 1; i++) {
    public void testRmWithIOExceptions() throws IOException {
        try (OutputStream o = Files.newOutputStream(file)) {
    }
        final Closeable[] closeables = new Closeable[numberOfCloseables];
import static org.mockito.Mockito.doThrow;
 * GitHub history for details.
    public void testCloseArray() throws IOException {
        final Path[] locations = new Path[numberOfLocations];
        final FilterFileSystemProvider ffsp = new AccessDeniedWhileOpeningDirectoryFileSystem(path.getFileSystem());
            // no exception, we early return and do not even try to open the directory
                throw new AccessDeniedException("access denied while trying to delete file [" + path + "]");
            return delegate.newFileChannel(path, options, attrs);
    private <T> void runDeleteFilesIgnoringExceptionsTest(
                // we create a tree of files that IOUtils#rm should delete
        runTestClose(Function.identity(), IOUtils::close);
import java.nio.file.Path;
    }
        final Path path = createTempDir().toRealPath();
            IOUtils.fsync(wrapped, true);
 * See the License for the specific language governing permissions and
            closeables[i] = closeable;
        final List<Path> locationsThrowingException = new ArrayList<>(numberOfLocations);
            super("access_denied://", delegate);
 * Licensed to the Apache Software Foundation (ASF) under one or more
import java.nio.file.AccessDeniedException;
        } else {
    public void testFsyncDirectory() throws Exception {
        // ensure that at least one always throws
        for (int i = 0; i < numberOfFiles; i++) {
        for (int i = 0; i < numberOfLocations; i++) {
    }
            assertThat(e.getSuppressed()[i - 1].getMessage(), equalTo(Integer.toString(indexesThatThrow.get(i))));
        Files.createDirectories(subPath);
                assertFalse(locations[i].toString(), Files.exists(locations[i]));
        if (Constants.WINDOWS) {
        final Path wrapped = ffsp.wrapPath(path);
    ) throws IOException {
        final Closeable closeable = mock(Closeable.class);
        closeables[numberOfCloseables - 1] = closeable;
        final Path path = createTempDir().toRealPath();
        final int numberOfCloseables = randomIntBetween(1, 8);
    }
        }
public class IOUtilsTests extends OpenSearchTestCase {
    }
        CheckedConsumer<T, IOException> deleteFilesIgnoringExceptions
        final Path dir = FilterPath.unwrap(createTempDir()).toRealPath();
            assertNotNull(e.getSuppressed()[i - 1]);
    public void testFsyncFile() throws IOException {
        final Path file = subPath.resolve(randomAlphaOfLength(8));
