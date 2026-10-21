     * Returns true if any of the filters contain this fingerprint at the specified bucket.
            this.numBuckets = filters.get(0).getNumBuckets();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public SetBackedScalingCuckooFilter(StreamInput in, Random rng) throws IOException {
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
        }
        // Cache the chosen numBuckets for later use
    }
import org.opensearch.common.hash.MurmurHash3;
        }
        return mightContainHash(hash.h1);
    }
        this.fpp = in.readDouble();
        this.capacity = in.readVInt();
    }
     * be the union of the two.  During the merging process, the internal Set may be upgraded
            throw new IllegalStateException(
 * Final size is dependent on the cardinality of data inserted, and the precision specified.
            return false;
        this.rng = rng;
            out.writeCollection(hashes, StreamOutput::writeZLong);
     * Returns true if the set might contain the provided value, false otherwise.  False values are
     */
 * under the License.
            throw new IllegalStateException(
        }
     * to a cuckoo if it goes over threshold
            return hashes.contains(hash);
        if (fpp < 0) {
import java.util.Set;
        }
    /**
        if (filters != null) {
            throw new IllegalStateException(
        if (threshold <= 0) {
        }
        this.rng = other.rng;
 * GitHub history for details.
        // one cuckoo filter without overflowing. This keeps merging logic simpler
    private boolean isSetMode = true;
            this.filters = new ArrayList<>(other.filters);
 */
            // Other is in cuckoo mode, so we convert our set to a cuckoo, then
    }
    void convert() {
        this.threshold = other.threshold;
            for (CuckooFilter otherFilter : other.filters) {
        numBuckets = t.getNumBuckets();
    private boolean mightContainFingerprint(int bucket, int fingerprint) {
                            currentFilter = filters.get(filters.size() - 1);
     * If we still holding values in a set, convert this filter into an approximate, cuckoo-backed filter.
        if (isSetMode == false) {
     * This list holds our approximate filters, after we have migrated out of a set.
                            CuckooFilter t = new CuckooFilter(capacity, fpp, rng);
        out.writeVInt(threshold);
            // replay the values directly into our filter.
        int alternateIndex = CuckooFilter.alternateIndex(bucket, fingerprint, numBuckets);
                    // (in the same bucket/alternate bucket), or if the fingerprint is empty. In these cases
    }
        return false;
            breaker.accept(t.getSizeInBytes()); // make sure we account for the new filter
                "Cannot convert SetBackedScalingCuckooFilter to approximate " + "when it has already been converted."
            hashes.addAll(other.hashes);
    public void registerBreaker(Consumer<Long> breaker) {
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    /**
        if (hashes != null) {
        if (success == false) {
     * CuckooFilter's can "saturate" and refuse to accept any new values.  When this happens,
        return Objects.hash(hashes, filters, threshold, isSetMode, capacity, fpp);
    public void add(BytesRef value) {
import org.opensearch.core.common.io.stream.StreamInput;
            if (filter.mightContainFingerprint(bucket, fingerprint, alternateIndex)) {
        boolean success = filters.get(filters.size() - 1).add(hash);
        } else {
     * Add's the provided value to the set for tracking
        if (this == other) {
 * Unless required by applicable law or agreed to in writing,
    List<CuckooFilter> filters;
            throw new IllegalArgumentException("[threshold] must be smaller than [" + (FILTER_CAPACITY / 2) + "]");
        this.fpp = fpp;
                // fingerprints for buckets at the current position
            // Both are in cuckoo mode, merge raw fingerprints
    }
        int fingerprint = CuckooFilter.fingerprint((int) (hash >> 32), bitsPerEntry, fingerprintMask);
    /**
     * the datastructure scales by adding a new filter.  This new filter's bytes will be tracked
    }
    private void addHash(long hash) {
     * 100% accurate, while true values may be a false-positive.
            if (filter.mightContainFingerprint(bucket, fingerprint, alternateIndex)) {
        breaker.accept(getSizeInBytes()); // this adds back in the new overhead of the cuckoo filters
        this.isSetMode = other.isSetMode;
            this.fingerprintMask = filters.get(0).getFingerprintMask();
 * You may obtain a copy of the License at
    private int fingerprintMask = 0;
        addHash(MurmurHash3.murmur64(value));
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, scratchHash);
        addHash(hash.h1);
     * package-private for testing
        long hash = MurmurHash3.murmur64(value);
     */
 *
            );
    // True if we are tracking inserts with a set, false otherwise
        // We have to ensure that, in the worst case, two full sets can be converted into
     * 100% accurate, while true values may be a false-positive.
    }
            maybeConvert();
                        // Try to insert into the last filter in our list
     * @param threshold The number of distinct values that should be tracked
     * This set is used to track the insertions before we convert over to an approximate
    public int hashCode() {
    /**
        if (isSetMode && hashes.size() > threshold) {
            // call the merge function again. Since both are now in set-mode
                "Cannot merge other CuckooFilter because precisions do not match: [" + this.fpp + "] vs [" + other.fpp + "]"
                // The iterator returns an array of longs corresponding to the
 * <p>
     * @param rng A random number generator needed for the cuckoo hashing process
            this.bitsPerEntry = filters.get(0).getBitsPerEntry();
                return true;
        fingerprintMask = t.getFingerprintMask();
     * This is an expert-level API since it is dealing with buckets and fingerprints, not raw values
    public boolean mightContain(BytesRef value) {
 * Internally, the datastructure maintains a Set of hashes up to a specified threshold.  This provides
     */
 */
        bitsPerEntry = t.getBitsPerEntry();
     */
 * An approximate set membership datastructure that scales as more unique values are inserted.
        if (isSetMode && other.isSetMode) {
            this.hashes = new HashSet<>(other.hashes);
import org.opensearch.core.common.io.stream.Writeable;
                while (iter.hasNext()) {
 * when it does not (has false positives).  Similar in usage to a Bloom Filter.
        return false;
    Set<Long> hashes;
        } else {
    private static final int FILTER_CAPACITY = 1000000;
     * Merge `other` cuckoo filter into this cuckoo.  After merging, this filter's state will
                    bucket += 1;
        hashes.forEach(t::add);
                        }
    private final int capacity;
        if (isSetMode) {
        }
     * Returns true if the set might contain the provided value, false otherwise.  False values are
        }
    /**
    private int numBuckets = 0;
            maybeConvert();
        return bytes;
 * compatible open source license.
            );
            // filter is full, create a new one and insert there
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, scratchHash);
     * This will be null if isSetMode = true;
 * These filters are approximate similar to Bloom Filters.
            merge(other);
        isSetMode = false;
            CuckooFilter t = new CuckooFilter(capacity, fpp, rng);
 * software distributed under the License is distributed on an
        this.breaker = Objects.requireNonNull(breaker, "Circuit Breaker Consumer cannot be null");
        // Some basic sanity checks to make sure we can merge
        }
        }
        out.writeVInt(capacity);
    // cached here for performance reasons
        if (isSetMode) {
        // We calculate these once up front for all the filters and use the expert API
     * 100% accurate, while true values may be a false-positive.
     */
                    }
        if (this.fpp != other.fpp) {
 * Licensed to Elasticsearch under one or more contributor
    public void writeTo(StreamOutput out) throws IOException {
        // noop
    public boolean mightContain(long value) {
        }
     *                  before converting to an approximate representation
        out.writeBoolean(isSetMode);
     */
 *
        if (other == null || getClass() != other.getClass()) {
                "Cannot merge other CuckooFilter because thresholds do not match: [" + this.threshold + "] vs [" + other.threshold + "]"
        long oldSize = getSizeInBytes();
    private Consumer<Long> breaker = aLong -> {
    /**
import java.util.function.Consumer;
        final SetBackedScalingCuckooFilter that = (SetBackedScalingCuckooFilter) other;
            return;
            other.hashes.forEach(this::add);
     * filter. This gives us 100% accuracy for small cardinalities.  This will be null
     * if isSetMode = false;
 * ownership. Elasticsearch licenses this file to you under
            }
            throw new IllegalStateException(
        }
    /**
                int bucket = 0;
 * <p>
    public SetBackedScalingCuckooFilter(int threshold, Random rng, double fpp) {
import java.util.ArrayList;
        this.rng = rng;
        }
            throw new IllegalArgumentException("[fpp] must be a positive double");
     */
            }
            && Objects.equals(this.filters, that.filters)
            return true;
            t.add(hash);
        } else if (isSetMode && other.isSetMode == false) {
    @Override
            convert();
    /**
    /**
                    long[] fingerprints = iter.next();
    }
        }
            // this will fall through to the last conditional and do a cuckoo-cuckoo merge
        this.capacity = other.capacity;
        long bytes = 13; // fpp (double), threshold (int), isSetMode (boolean)
            );
        this.breaker = other.breaker;
import java.util.Objects;
     */
import java.util.Random;
            bytes += filters.stream().mapToLong(CuckooFilter::getSizeInBytes).sum();
import org.opensearch.core.common.io.stream.StreamOutput;
     * are tracked, not the overhead of the Set itself.
        }
        this.threshold = threshold;
    }
        }
                        }
 * Can definitively say if a member does not exist (no false negatives), but may say an item exists
            filters.add(t);
    /**
        for (CuckooFilter filter : filters) {
                        if (currentFilter.mergeFingerprint(bucket, (int) fingerprint) == false) {
            this.bitsPerEntry = filters.get(0).getBitsPerEntry();
        }
        return mightContainHash(hash);
        this.capacity = FILTER_CAPACITY;
        hashes = null;
 *
 * this file be licensed under the Apache-2.0 license or a
            // Rather than converting the other to a cuckoo first, we can just
    }
/*
    /**
            && Objects.equals(this.isSetMode, that.isSetMode)
    /**
        } else {
            CuckooFilter currentFilter = filters.get(filters.size() - 1);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeDouble(fpp);
            out.writeList(filters);
/*
    @Override
                Iterator<long[]> iter = otherFilter.getBuckets();
        }
        if (this.capacity != other.capacity) {
     * Registers a circuit breaker with the datastructure.
    }
     * <p>
     */
    public SetBackedScalingCuckooFilter(SetBackedScalingCuckooFilter other) {
                        if (fingerprint == CuckooFilter.EMPTY || mightContainFingerprint(bucket, (int) fingerprint)) {
        } else if (isSetMode == false && other.isSetMode) {
 */
            convert();
        filters.add(t);
    }
        filters = new ArrayList<>();
        this.threshold = in.readVInt();
    @Override
        }
     * in the registered breaker when configured.
     */
import org.apache.lucene.util.BytesRef;
    public void add(long value) {
            bytes = (hashes.size() * 16);
 * this work for additional information regarding copyright
    public long getSizeInBytes() {
     */
            // Both in sets, merge collections then see if we need to convert to cuckoo
/**
     * This will create a list of CuckooFilters, and null out the set of hashes
public class SetBackedScalingCuckooFilter implements Writeable {
        }
 * The OpenSearch Contributors require contributions made to
        int bucket = CuckooFilter.hashToIndex((int) hash, numBuckets);
            }
 */
                            continue;
 * @opensearch.internal
            && Objects.equals(this.threshold, that.threshold)
    private void maybeConvert() {
        breaker.accept(-oldSize); // this zeros out the overhead of the set
        }
 * This datastructure scales as more values are inserted by growing the list of CuckooFilters.
                    // we can skip the fingerprint
                    // We check to see if the fingerprint is present in any of the existing filters
        this.hashes = new HashSet<>(threshold);
     * Get the approximate size of this datastructure.  Approximate because only the Set occupants
            );
 * specific language governing permissions and limitations
    }
                    for (long fingerprint : fingerprints) {
            && Objects.equals(this.fpp, that.fpp);
    }
        if (isSetMode) {
    }
import java.util.List;
package org.opensearch.common.util;
 *
    private final double fpp;
        breaker.accept(getSizeInBytes());
 * 100% accurate membership queries.
            && Objects.equals(this.capacity, that.capacity)
        if (threshold * 2 > FILTER_CAPACITY) {
        this.fpp = other.fpp;
 * When the threshold is breached, a list of CuckooFilters are created and used to track membership.
    private final Random rng;
        } else {
        CuckooFilter t = new CuckooFilter(capacity, fpp, rng);
    public boolean equals(Object other) {
                            // if we failed, the filter is now saturated and we need to create a new one
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;
            this.hashes = in.readSet(StreamInput::readZLong);
import java.util.Iterator;
        int alternateIndex = CuckooFilter.alternateIndex(bucket, fingerprint, numBuckets);
            throw new IllegalArgumentException("[threshold] must be a positive integer");
    private MurmurHash3.Hash128 scratchHash = new MurmurHash3.Hash128();
    /**
     * Returns true if the set might contain the provided value, false otherwise.  False values are
            this.numBuckets = filters.get(0).getNumBuckets();
 * license agreements. See the NOTICE file distributed with
    public void merge(SetBackedScalingCuckooFilter other) {
                "Cannot merge other CuckooFilter because capacities do not match: [" + this.capacity + "] vs [" + other.capacity + "]"
            this.filters = in.readList(in12 -> new CuckooFilter(in12, rng));
            hashes.add(hash);
                            filters.add(t);
     * This is the estimated insertion capacity for each individual internal CuckooFilter.
     */
        if (isSetMode) {
        return Objects.equals(this.hashes, that.hashes)
     * being hashed.
     * @param fpp the false-positive rate that should be used for the cuckoo filters.
        if (this.threshold != other.threshold) {
                }
        if (isSetMode) {
    }
                            breaker.accept(t.getSizeInBytes()); // make sure we account for the new filter
        for (CuckooFilter filter : filters) {
 * not use this file except in compliance with the License.
    };
                return true;
    /**
/*
 * <p>
    private final int threshold;
        this.isSetMode = in.readBoolean();
     * Add's the provided value to the set for tracking
        }
    private int bitsPerEntry = 0;
}
            this.fingerprintMask = filters.get(0).getFingerprintMask();
     */
 * SPDX-License-Identifier: Apache-2.0
    private boolean mightContainHash(long hash) {
     * <p>
