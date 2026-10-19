        this(in.readLong(), in.readLong(), in.readBoolean(), in.readByte());
 *                 that reports {@code true}.  
import java.io.IOException;
 * values reports no bounds rather than a made-up range.  
     */
public record ShardSortBounds(long min, long max, boolean hasNulls, byte valueKind) implements Writeable {
 *
import org.opensearch.core.common.io.stream.StreamOutput;
 * Shard-wide min/max of one column, from the can-match probe. The coordinator uses it to
    public static final byte VALUE_KIND_INT64_NANOS = 5;
 *
    public static final byte VALUE_KIND_INT64 = 2;
/**
    /** Parquet INT64 annotated {@code Timestamp(MILLIS)} — what a {@code date} field writes. */  
 * <p>Bounds are a hint, never a requirement: absent bounds mean "unknown" and every
    /**  
    @Override
 * dispatch the most promising shards first for a sorted top-N query.  
 *
 * <p>{@code min}/{@code max} cover the non-null values only. A column with no non-null
}  
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {  
 *                  (e.g. millisecond vs nanosecond timestamps).  
     * Kept separate from {@link #VALUE_KIND_INT64_MILLIS}: same physical type, scaled 10^6 apart,
    }  
 * consumer falls back to its unoptimized path.  
 */  
 *
    public ShardSortBounds(StreamInput in) throws IOException {
    }
 * @param hasNulls true when the column may hold a null anywhere on the shard, or when the null
 * @opensearch.internal
 *                 count couldn't be established. Calcite maps {@code DESC} to  
    /** Parquet INT32 column. Must match the Rust-side constant. */  
     * so one kind for both would let the coordinator compare millis against nanos.  
import org.opensearch.core.common.io.stream.StreamInput;
    public static final byte VALUE_KIND_INT64_MILLIS = 3;
import org.opensearch.core.common.io.stream.Writeable;  
     * Parquet INT64 annotated {@code Timestamp(NANOS)} — what a {@code date_nanos} field writes.
 *                 {@code NULLS FIRST}, so one null outranks every real value and lands the shard
        out.writeByte(valueKind);
 *
 * The OpenSearch Contributors require contributions made to  
    public static final byte VALUE_KIND_INT32 = 1;
package org.opensearch.analytics.spi;
 * compatible open source license.
    /** Parquet INT64 annotated {@code Timestamp(MICROS)}. */  
        out.writeBoolean(hasNulls);  
 */  
 *                 in the top-N however poor its {@code min}/{@code max} — never eliminate a shard
        out.writeLong(min);
 * @param valueKind value domain the statistics came from. Travels on the wire so the
    public static final byte VALUE_KIND_INT64_MICROS = 4;
    /** Parquet INT64 column with no logical annotation — a plain integer domain. */  
        out.writeLong(max);
 *                  coordinator can refuse to compare bounds read at different scales
 * this file be licensed under the Apache-2.0 license or a
/*  
