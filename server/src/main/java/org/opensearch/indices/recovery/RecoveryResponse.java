        phase1FileSizes = in.readList(StreamInput::readVLong);
        this.phase1FileSizes = phase1FileSizes;
        out.writeVLong(phase1Time);  
 */  
        out.writeVLong(phase1TotalSize);
        phase2Time = in.readVLong();
 * under the License.  
 */
    final int phase2Operations;
import org.opensearch.core.common.io.stream.StreamInput;
    RecoveryResponse(
 * specific language governing permissions and limitations
        phase1FileNames = in.readStringList();  
        this.phase1ExistingFileNames = phase1ExistingFileNames;
        List<Long> phase1ExistingFileSizes,  
        long phase1ThrottlingWaitTime,
    final List<Long> phase1ExistingFileSizes;  
/**
    final List<String> phase1ExistingFileNames;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        int phase2Operations,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    final long phase1Time;  
 *  
        phase2Operations = in.readVInt();  
    final long phase1TotalSize;
        long phase1Time,  
/*  
    ) {
 * license agreements. See the NOTICE file distributed with
        phase1Time = in.readVLong();  
    public void writeTo(StreamOutput out) throws IOException {
        this.startTime = startTime;
        phase1ExistingFileNames = in.readStringList();
    }
import org.opensearch.core.transport.TransportResponse;  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        long startTime,
import org.opensearch.core.common.io.stream.StreamOutput;
        long phase2Time
        startTime = in.readVLong();
    final long phase2Time;  
import java.io.IOException;
/*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
}  
    @Override
        List<String> phase1FileNames,  
    final List<String> phase1FileNames;  
    final long phase1ThrottlingWaitTime;
 * You may obtain a copy of the License at  
        List<String> phase1ExistingFileNames,
        phase1ThrottlingWaitTime = in.readVLong();
 * GitHub history for details.
        out.writeVLong(phase1ExistingTotalSize);
        this.phase2Operations = phase2Operations;  
        phase1ExistingTotalSize = in.readVLong();
        out.writeVLong(startTime);
 * Modifications Copyright OpenSearch Contributors. See
public final class RecoveryResponse extends TransportResponse {
 * Response for recovery operations  
    final long phase1ExistingTotalSize;
 *
 */  
 * not use this file except in compliance with the License.
        List<Long> phase1FileSizes,
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
        out.writeCollection(phase1FileSizes, StreamOutput::writeVLong);
        out.writeStringCollection(phase1ExistingFileNames);
        this.phase1FileNames = phase1FileNames;  
        this.phase1ExistingTotalSize = phase1ExistingTotalSize;
        phase1TotalSize = in.readVLong();
 * this work for additional information regarding copyright
 *
    }
        out.writeVInt(phase2Operations);  
        long phase1TotalSize,
    }
 * software distributed under the License is distributed on an
 *
    RecoveryResponse(StreamInput in) throws IOException {
        this.phase1Time = phase1Time;  
        long phase1ExistingTotalSize,
        this.phase1TotalSize = phase1TotalSize;
        phase1ExistingFileSizes = in.readList(StreamInput::readVLong);  
/*
        out.writeCollection(phase1ExistingFileSizes, StreamOutput::writeVLong);  
package org.opensearch.indices.recovery;
        out.writeVLong(phase1ThrottlingWaitTime);
        out.writeStringCollection(phase1FileNames);  
        out.writeVLong(phase2Time);
    final long startTime;  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
 */  
    final List<Long> phase1FileSizes;
        this.phase1ThrottlingWaitTime = phase1ThrottlingWaitTime;
        super(in);
        this.phase2Time = phase2Time;
        this.phase1ExistingFileSizes = phase1ExistingFileSizes;  
