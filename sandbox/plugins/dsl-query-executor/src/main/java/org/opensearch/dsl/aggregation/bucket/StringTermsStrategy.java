    /** Binary keys are ip columns: render the address string like classic ip terms. */  
 */
            0,  
import java.net.UnknownHostException;  
 */  
    /**
            false,  
    public InternalAggregation build(TermsAggregationBuilder agg, List<BucketEntry> entries, long otherDocCount, DocValueFormat format) {
 * string keys are stored as their UTF-8 bytes. A binary key without a mapping-resolved format
 * Builds a {@link StringTerms} response. Handles keyword, ip, text, and any field type whose  
    private static String binaryKeyString(byte[] bytes) {
     * Converts a key into the bucket's term bytes. Binary keys (ip columns) keep their encoded  
     */
        }
     * classic StringTerms contract; under RAW they are pre-rendered (address string or Base64)
    }  
import org.opensearch.search.aggregations.BucketOrder;  
 *
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.dsl.aggregation.bucket;
/**
}  
import java.net.InetAddress;
            TermsBucketTranslator.thresholds(agg)
        List<StringTerms.Bucket> termBuckets = new ArrayList<>(entries.size());
import java.util.List;  
    }
            return NetworkAddress.format(InetAddress.getByAddress(bytes));  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        if (key instanceof BytesRef ref) {  
        BucketOrder order = agg.order();
    /** Singleton instance. */
            BytesRef term = termBytes(entry.keys().get(0), format);
     * bytes so the mapping-resolved {@link DocValueFormat} renders them at serialization — the
 * compatible open source license.
            otherDocCount,
import org.opensearch.common.network.NetworkAddress;
        }
            agg.getName(),  
            termBuckets,
 * <p>Bucket terms follow the classic StringTerms contract: binary keys (ip columns) are stored  
        for (BucketEntry entry : entries) {  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            return Base64.getEncoder().encodeToString(bytes);  
 *
     * since RAW would otherwise print raw bytes. String keys become their UTF-8 bytes.  
        return new BytesRef(key.toString());  
        );
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
import org.opensearch.dsl.result.BucketEntry;
            return format == DocValueFormat.RAW ? new BytesRef(binaryKeyString(bytes)) : new BytesRef(bytes);
        } catch (UnknownHostException e) {
    public static final StringTermsStrategy INSTANCE = new StringTermsStrategy();
            AggregationTranslator.userMetadata(agg),  
        if (key instanceof byte[] bytes) {  
            termBuckets.add(new StringTerms.Bucket(term, entry.docCount(), entry.subAggs(), false, 0, format));
        try {
    @Override  
            return format == DocValueFormat.RAW ? new BytesRef(binaryKeyString(ref.bytes)) : ref;
            order,
 * (RAW) renders as a deterministic Base64 string.  
 * as their encoded bytes and the mapping's {@link DocValueFormat} renders them at serialization;
            format,
 * SPDX-License-Identifier: Apache-2.0
        }
    private StringTermsStrategy() {}
    private static BytesRef termBytes(Object key, DocValueFormat format) {
public final class StringTermsStrategy implements TermsResponseStrategy {
import org.opensearch.search.DocValueFormat;
/*  
        }  
import org.opensearch.search.aggregations.InternalAggregation;
 * bucket keys are naturally string-representable; also the default for unregistered type names.
import org.apache.lucene.util.BytesRef;
            // Not a 4/16-byte address; fall back to a printable, deterministic form.
            agg.shardSize(),
            order,
        return new StringTerms(
import java.util.Base64;
import org.opensearch.dsl.aggregation.AggregationTranslator;  
