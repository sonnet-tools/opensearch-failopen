        // compression (by making sure we share common prefixes between enough ids),  
 * You may obtain a copy of the License at  
import java.util.concurrent.atomic.AtomicLong;  
 */
            }
        // Blocks in the block tree have between 25 and 48 terms. So all prefixes that
        uuidBytes[i++] = (byte) (timestamp >>> 32); // changes every ~50 days  
    // backwards, and JVM comes back up, we are less likely to be on the same sequenceNumber at the same time:  
 * Unless required by applicable law or agreed to in writing,
 *
    // protected for testing  
 */  
        });
 * SPDX-License-Identifier: Apache-2.0
        i += macAddress.length;
class TimeBasedUUIDGenerator implements UUIDGenerator {  
        return SECURE_MUNGED_ADDRESS;
 * specific language governing permissions and limitations
    private final AtomicInteger sequenceNumber = new AtomicInteger(SecureRandomHolder.INSTANCE.nextInt());
        // much on the indexing rate, so it is less reliable.  
        uuidBytes[i++] = (byte) timestamp;
 * For more information about flake ids, check out  
            // still vulnerable if we are shut down, clock goes backwards, and we restart... for this we
 * this work for additional information regarding copyright
        // segment sizes and still gives pretty good indexing speed. We use the sequenceId
        System.arraycopy(macAddress, 0, uuidBytes, i, macAddress.length);
    private final AtomicLong lastTimestamp = new AtomicLong(0);
 *
    }
        // two lower bytes of the sequence id in the beginning of the id, but compression  
 */  
    // Used to ensure clock moves forward:  
            // randomize the sequenceNumber on init to decrease chance of collision:  
 */
        // So we try to optimize the order of bytes for indexing speed (by having quite
        assert macAddress.length == 6;  
 * bytes in a way that does not make ids sort in order anymore, but is more friendly to the way that the Lucene terms dictionary is
    // We only use bottom 3 bytes for the sequence number. Paranoia: init with random int so that if JVM/OS/machine goes down, clock slips
/*  
/**
        uuidBytes[i++] = (byte) (timestamp >>> 8);
        // unique bytes close to the beginning of the ids so that sorting is fast) and
 * this file be licensed under the Apache-2.0 license or a
        uuidBytes[i++] = (byte) sequenceId;
        // rather than the timestamp because the distribution of the timestamp depends too
        uuidBytes[i++] = (byte) (sequenceId >>> 8);  
package org.opensearch.common;
/*  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
    static {
 * not use this file except in compliance with the License.
}
    protected long currentTimeMillis() {
        // segments whenever possible)
 * These are essentially flake ids but we use 6 (not 8) bytes for timestamp, and use 3 (not 2) bytes for sequence number. We also reorder  
        return System.currentTimeMillis();
            if (sequenceId == 0) {  
        return Base64.getUrlEncoder().withoutPadding().encodeToString(uuidBytes);
            return nonBackwardsTimestamp;  
 * structured.
        // Now we start focusing on compression and put bytes that should not change too often.  
 * compatible open source license.
                nonBackwardsTimestamp++;  
        byte[] macAddress = macAddress();
        // Finally we put the remaining bytes, which will likely not be compressed at all.
        final byte[] uuidBytes = new byte[15];  
        // of the sequence number so that compression starts to be triggered with smaller  
        long currentTimeMillis = currentTimeMillis();
        // are shared by ~30 terms should be well compressed. I first tried putting the
 * The OpenSearch Contributors require contributions made to  
        int i = 0;
    }  
                // Always force the clock to increment whenever sequence number is 0, in case we have a long
 *  
            // Don't let timestamp go backwards, at least "on our watch" (while this JVM is running). We are
    protected byte[] macAddress() {  
 * GitHub history for details.
        uuidBytes[i++] = (byte) (timestamp >>> 16); // changes every ~65 secs
 * software distributed under the License is distributed on an
/*
    @Override
 * license agreements. See the NOTICE file distributed with
        long timestamp = this.lastTimestamp.updateAndGet(lastTimestamp -> {  
    }  
import java.util.concurrent.atomic.AtomicInteger;
    private static final byte[] SECURE_MUNGED_ADDRESS = MacAddressProvider.getSecureMungedAddress();  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * https://archive.fo/2015.07.08-082503/http://www.boundary.com/blog/2012/01/flake-a-decentralized-k-ordered-unique-id-generator-in-erlang/
import java.util.Base64;
        uuidBytes[i++] = (byte) (timestamp >>> 40); // changes every 35 years
    // protected for testing
        assert SECURE_MUNGED_ADDRESS.length == 6;  
            long nonBackwardsTimestamp = Math.max(lastTimestamp, currentTimeMillis);
        final int sequenceId = sequenceNumber.incrementAndGet() & 0xffffff;  
        assert i == uuidBytes.length;  
                // time-slip backwards:
 *     http://www.apache.org/licenses/LICENSE-2.0
        uuidBytes[i++] = (byte) (timestamp >>> 24); // changes every ~4.5h
        uuidBytes[i++] = (byte) (sequenceId >>> 16);
 *
 * ownership. Elasticsearch licenses this file to you under  
        // We have auto-generated ids, which are usually used for append-only workloads.  
        // but not necessarily for lookup speed (by having the leading bytes identify
    public String getBase64UUID() {
        // is only triggered when you have at least 30*2^16 ~= 2M documents in a segment,
        // changes every 65k docs, so potentially every second if you have a steady indexing rate  
        // which is already quite large. So instead, we are putting the 1st and 3rd byte
 * under the License.  
