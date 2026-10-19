        assertThat(result, instanceOf(RandomScoreFunctionBuilder.class));  
    public void testFromProtoWithStringSeed() {  
 * compatible open source license.
        // Create a random score function with empty field  
        RandomScoreFunctionBuilder randomScoreBuilder = (RandomScoreFunctionBuilder) result;
        assertThat(result, instanceOf(RandomScoreFunctionBuilder.class));
        RandomScoreFunctionBuilder randomScoreBuilder = (RandomScoreFunctionBuilder) result;  
            () -> { RandomScoreFunctionProtoUtils.fromProto(null); }
    }  
 * SPDX-License-Identifier: Apache-2.0
        RandomScoreFunctionSeed seed = RandomScoreFunctionSeed.newBuilder().setInt32(12345).build();  
        assertEquals("RandomScoreFunction cannot be null", exception.getMessage());
        assertEquals(Integer.valueOf(Long.hashCode(9876543210L)), randomScoreBuilder.getSeed());  
        ScoreFunctionBuilder<?> result = RandomScoreFunctionProtoUtils.fromProto(randomScore);
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder().setField("_seq_no").setSeed(seed).build();
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,
        RandomScoreFunctionBuilder randomScoreBuilder = (RandomScoreFunctionBuilder) result;
        RandomScoreFunctionSeed seed = RandomScoreFunctionSeed.newBuilder().setInt64(9876543210L).build();
import static org.hamcrest.Matchers.instanceOf;  
        // Long seeds are converted to int via Long.hashCode() internally
        ScoreFunctionBuilder<?> result = RandomScoreFunctionProtoUtils.fromProto(randomScore);
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder().setField("").setSeed(seed).build();  
}  
        assertEquals("_seq_no", randomScoreBuilder.getField());
 */  
        // Create a random score function with int32 seed
 *
        assertThat(result, instanceOf(RandomScoreFunctionBuilder.class));
        ScoreFunctionBuilder<?> result = RandomScoreFunctionProtoUtils.fromProto(randomScore);  
        assertEquals("_seq_no", randomScoreBuilder.getField());  
        assertEquals("_seq_no", randomScoreBuilder.getField());
    }
        // Seed should be null when not set
        // Create a random score function with string seed
    public void testFromProtoWithNoSeed() {
        assertEquals(Integer.valueOf(12345), randomScoreBuilder.getSeed());  
        assertThat(result, instanceOf(RandomScoreFunctionBuilder.class));
 * The OpenSearch Contributors require contributions made to  
        );  
    public void testFromProtoWithEmptyField() {
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder().setField("_id").setSeed(seed).build();
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder().setField("_seq_no").build();  
/*  
        // Create a random score function without seed
        ScoreFunctionBuilder<?> result = RandomScoreFunctionProtoUtils.fromProto(randomScore);  
        RandomScoreFunctionBuilder randomScoreBuilder = (RandomScoreFunctionBuilder) result;  
        ScoreFunctionBuilder<?> result = RandomScoreFunctionProtoUtils.fromProto(randomScore);
import org.opensearch.protobufs.RandomScoreFunctionSeed;  
    public void testFromProtoWithValidRandomScoreFunction() {
    public void testFromProtoWithInt64Seed() {  
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;  
        assertNull(randomScoreBuilder.getField());  
    public void testFromProtoWithNullRandomScoreFunction() {
import org.opensearch.test.OpenSearchTestCase;
        assertNull(randomScoreBuilder.getSeed());
    }
    }
        assertEquals("_id", randomScoreBuilder.getField());
        RandomScoreFunctionSeed seed = RandomScoreFunctionSeed.newBuilder().setInt32(42).build();
    }
        IllegalArgumentException exception = expectThrows(  
        RandomScoreFunctionSeed seed = RandomScoreFunctionSeed.newBuilder().setString("test_seed").build();
    }  
        // Create a random score function with int64 seed
        assertEquals(Integer.valueOf(42), randomScoreBuilder.getSeed());
public class RandomScoreFunctionProtoUtilsTests extends OpenSearchTestCase {
        assertThat(result, instanceOf(RandomScoreFunctionBuilder.class));
import org.opensearch.protobufs.RandomScoreFunction;
        assertEquals(Integer.valueOf("test_seed".hashCode()), randomScoreBuilder.getSeed());
        RandomScoreFunctionBuilder randomScoreBuilder = (RandomScoreFunctionBuilder) result;
        RandomScoreFunction randomScore = RandomScoreFunction.newBuilder().setField("_seq_no").setSeed(seed).build();
