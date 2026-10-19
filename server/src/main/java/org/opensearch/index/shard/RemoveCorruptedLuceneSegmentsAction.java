 * SPDX-License-Identifier: Apache-2.0
                }
                throw new OpenSearchException("Index is unrecoverable - there are missing segments");
 * specific language governing permissions and limitations
import org.opensearch.common.collect.Tuple;  
                : Tuple.tuple(
 */
import org.apache.lucene.store.Lock;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 * software distributed under the License is distributed on an
            }
                        : RemoveCorruptedShardDataCommand.CleanStatus.CLEAN,
                    checker.exorciseIndex(status);
            status = checker.checkIndex(null);
    public Tuple<RemoveCorruptedShardDataCommand.CleanStatus, String> getCleanStatus(  
        Lock writeLock,
/*
 * this file be licensed under the Apache-2.0 license or a
        final CheckIndex.Status status;
 *
    ) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "Corrupted Lucene index segments found - " + status.totLoseDocCount + " documents will be lost."
                    null  
                return Tuple.tuple(
import org.apache.lucene.index.CheckIndex.Level;
                );
package org.opensearch.index.shard;
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * GitHub history for details.
import org.opensearch.cli.Terminal;
        PrintStream printStream,  
/*  
            if (status.missingSegments == false) {
            if (status.missingSegments) {  
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.CheckIndex;  
 *
/*
 * Modifications Copyright OpenSearch Contributors. See  
    public void execute(Terminal terminal, Directory indexDirectory, Lock writeLock, PrintStream printStream, boolean verbose)  
        Directory indexDirectory,
                )
        throws IOException {
import java.io.IOException;
                    "Index is unrecoverable - there are missing segments"  
 * Unless required by applicable law or agreed to in writing,
 *
            }
                    RemoveCorruptedShardDataCommand.CleanStatus.UNRECOVERABLE,
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        }  
 */
                        ? RemoveCorruptedShardDataCommand.CleanStatus.CLEAN_WITH_CORRUPTED_MARKER
 */  
        boolean markedCorrupted = RemoveCorruptedShardDataCommand.isCorruptMarkerFileIsPresent(indexDirectory);  
        }  
        final CheckIndex.Status status;
import org.opensearch.OpenSearchException;
            } else {  
                    RemoveCorruptedShardDataCommand.CleanStatus.CORRUPTED,  
            checker.setLevel(Level.MIN_LEVEL_FOR_CHECKSUM_CHECKS);
 * license agreements. See the NOTICE file distributed with
                    terminal.println("Wrote new segments file \"" + status.segmentsFileName + "\"");
 * Removes corrupted Lucene index segments  
}
            checker.setLevel(Level.MIN_LEVEL_FOR_CHECKSUM_CHECKS);
                    terminal.println("Writing...");  
 * compatible open source license.
                ? Tuple.tuple(
            checker.setInfoStream(printStream, verbose);
                    terminal.println("OK");  
            return status.clean
 * under the License.  
        try (CheckIndex checker = new CheckIndex(indexDirectory, writeLock)) {  
    }
            checker.setInfoStream(printStream, verbose);  
 *  
                );
                    markedCorrupted  
 * not use this file except in compliance with the License.
        boolean verbose
        try (CheckIndex checker = new CheckIndex(indexDirectory, writeLock)) {  
                if (status.clean == false) {
import java.io.PrintStream;  
public class RemoveCorruptedLuceneSegmentsAction {
import org.apache.lucene.store.Directory;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
            status = checker.checkIndex(null);
