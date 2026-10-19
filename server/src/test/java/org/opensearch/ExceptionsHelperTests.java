 * Licensed to Elasticsearch under one or more contributor  
            assertThat(openSearchException.getMessage(), equalTo(expectedErrors[i]));
        assertError(outOfMemoryError, outOfMemoryError);
        RuntimeException e1 = new RuntimeException();
 *
        RuntimeException e4 = new RuntimeException(e1);  
 *
        e4.addSuppressed(corruptIndexException);
                    cause.addSuppressed(error);
        final Throwable corruptionAsCause = new RuntimeException(corruptIndexException);
        return new ShardSearchFailure(queryShardException, null);  
            OpenSearchException openSearchException = (OpenSearchException) shardOperationFailedException.getCause();  
            createShardFailureParsingException("error", "node2", "index", 2, "cluster1"),
        String[] expectedIndices = new String[] { "index", "index2", "cluster1:index", "cluster2:index", "cluster2:index" };  
            createShardFailureQueryShardException("error", "index", "cluster2"),  
        assertThat(ExceptionsHelper.unwrapToOpenSearchException(null), nullValue());
        IllegalArgumentException nonOpenSearchException = new IllegalArgumentException("not opensearch");  
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] {
        // Test with non-OpenSearchException - should return original
        final int depth = randomIntBetween(1, 16);
        }  
 * Unless required by applicable law or agreed to in writing,
        OpenSearchException nestedOpenSearchException = new OpenSearchException("nested error");
import org.opensearch.test.OpenSearchTestCase;  
            final int length = randomIntBetween(1, 4);
        e1.addSuppressed(e2);  
        corruptionSuppressed.addSuppressed(corruptIndexException);
        assertThat(ExceptionsHelper.status(new InputCoercionException("illegal")), equalTo(RestStatus.BAD_REQUEST));
        }  
        assertSame(deepNested, ExceptionsHelper.unwrapToOpenSearchException(level2));
            createShardFailureQueryShardException("error", "index", "cluster1"),
        e2.addSuppressed(e1);
        // Test with nested OpenSearchException - should unwrap to it  
        e1.initCause(e2);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        final DecoderException decoderException = new DecoderException(outOfMemoryError);
import org.opensearch.search.SearchShardTarget;
        final Throwable corruptionSuppressed = new RuntimeException();
            }
 * under the License.  
        assertThat(ExceptionsHelper.status(new IndexSearcher.TooManyNestedClauses()), equalTo(RestStatus.BAD_REQUEST));  
import java.util.Optional;  
            } else {
    private void assertError(final Throwable cause, final Error error) {  
    }
        OpenSearchException directException = new OpenSearchException("direct error");  
package org.opensearch;
            assertThat(shardOperationFailedException.getCause().getMessage(), equalTo(expectedErrors[i]));
            assertError(cause, error);
import static org.hamcrest.CoreMatchers.nullValue;
import org.opensearch.tools.jackson.core.JsonParseException;
        assertThat(ExceptionsHelper.unwrapCorruption(corruptionAsCause), equalTo(corruptIndexException));
        String clusterAlias
        ShardOperationFailedException[] groupBy = ExceptionsHelper.groupBy(failures);
import org.opensearch.tools.jackson.core.InputCoercionException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Optional<Error> maybeError = maybeError(cause);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(ExceptionsHelper.unwrapCorruption(corruptionCauseOnSuppressed), equalTo(corruptIndexException));
    }
 *  
            createShardFailureParsingException("error", "node1", "index", 1, "cluster2"),  
            createShardFailureQueryShardException("error", "index", null),
        ExceptionsHelper.unwrap(e1, IOException.class);  
 */  
        corruptionSuppressedOnCause.getCause().addSuppressed(corruptIndexException);  
import java.io.IOException;
        assertThat(ExceptionsHelper.unwrapCorruption(corruptionSuppressedOnCause), equalTo(corruptIndexException));
            assertThat(openSearchException.getIndex().getName(), equalTo(expectedIndices[i++]));
        assertThat(groupBy.length, equalTo(2));  
 * not use this file except in compliance with the License.
        final CorruptIndexException corruptIndexException = new CorruptIndexException("corrupt", "resource");
        assertFalse(maybeError(new Exception(new DecoderException())).isPresent());  
        // Sanity check: arbitrary RuntimeException still falls through to 500.
    }
        assertThat(ExceptionsHelper.summaryMessage(new OpenSearchRejectedExecutionException("rejected")), equalTo("Too many requests"));  
    }
        final Error outOfMemoryError = new OutOfMemoryError();
        int i = 0;
    public void testSummaryMessage() {
            createShardFailureParsingException("error", "node1", "index", 1, "cluster1"),  
 */  
    private static ShardSearchFailure createShardFailureParsingException(  
        assertThat(ExceptionsHelper.unwrapCorruption(new RuntimeException()), nullValue());
    }  
        RuntimeException e2 = new RuntimeException(e1);
            createShardFailureParsingException("error", "node0", "index", 0, null),
            createShardFailureParsingException("error", "node1", "index", 1, null),  
/*
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.search.ShardSearchFailure;
        // Test with multiple levels of nesting  
        String nodeId,
import org.apache.commons.codec.DecoderException;
        assertThat(ExceptionsHelper.unwrapCorruption(new RuntimeException(new RuntimeException())), nullValue());
        String[] expectedIndices = new String[] { "index", "cluster1:index", "cluster2:index", "index2", "index2" };  
            createShardFailureQueryShardException("another error", "index2", null), };
    }
        RuntimeException level1 = new RuntimeException("level 1", deepNested);
            for (int j = 0; j < length; j++) {
        RuntimeException e1 = new RuntimeException();  
        ShardOperationFailedException[] groupBy = ExceptionsHelper.groupBy(failures);
        for (ShardOperationFailedException shardOperationFailedException : groupBy) {  
        return new SearchShardTarget(
        ParsingException ex = new ParsingException(0, 0, error, new IllegalArgumentException("some bad argument"));
    public void testGroupByNullIndex() {  
    public void testGroupBy() {  
        String[] expectedErrors = new String[] { "error", "error", "error", "error", "another error" };
        Index index = new Index(RemoteClusterAware.buildRemoteIndexName(clusterAlias, indexName), "uuid");
 * software distributed under the License is distributed on an
import static org.opensearch.ExceptionsHelper.maybeError;
            createShardFailureParsingException("error", "node0", "index", 0, "cluster2"),
        assertError(decoderException, outOfMemoryError);
        OpenSearchException deepNested = new OpenSearchException("deep error");
import org.opensearch.core.action.ShardOperationFailedException;
    }
    public void testUnwrapCorruption() {  
                } else {
    public void testMaybeError() {  
        ExceptionsHelper.unwrapCorruption(e1);
    public void testSuppressedCycle() {  
            createShardFailureQueryShardException("error", "index2", null),
        int i = 0;
            createShardFailureParsingException("another error", "node2", "index", 2, "cluster2") };
            createShardFailureParsingException("error", "node2", "index2", 2, null),
        assertThat(ExceptionsHelper.status(new RuntimeException("boom")), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
    ) {  
 * GitHub history for details.
    private static SearchShardTarget createSearchShardTarget(String nodeId, int shardId, String index, String clusterAlias) {  
        assertTrue(maybeError.isPresent());
        String[] expectedErrors = new String[] { "error", "error", "error", "error", "another error" };
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.core.index.shard.ShardId;
        corruptionCauseOnSuppressed.addSuppressed(new RuntimeException(corruptIndexException));
import static org.hamcrest.CoreMatchers.equalTo;  
            createShardFailureQueryShardException("error", "index", null),
        e3.addSuppressed(e1);  
        final Throwable corruptionSuppressedOnCause = new RuntimeException(new RuntimeException());
            createShardFailureParsingException("error", "node2", "index", 2, "cluster2"),
    public void testUnwrapToOpenSearchException() {
import org.apache.lucene.index.CorruptIndexException;
            clusterAlias,
import org.opensearch.index.query.QueryShardException;
/*  
        for (ShardOperationFailedException shardOperationFailedException : groupBy) {  
            createShardFailureParsingException("error", "node0", "index", 0, "cluster1"),
        assertThat(groupBy.length, equalTo(5));
    private static ShardSearchFailure createShardFailureQueryShardException(String error, String indexName, String clusterAlias) {  
        assertThat(ExceptionsHelper.status(new IllegalArgumentException("illegal")), equalTo(RestStatus.BAD_REQUEST));
        ExceptionsHelper.unwrapCorruption(e1);
            assertThat(shardOperationFailedException.getCause(), instanceOf(OpenSearchException.class));
        assertThat(ExceptionsHelper.summaryMessage(new JsonParseException("illegal")), equalTo("Failed to parse JSON"));
}  
    }
        } else {
            nodeId,
 * the Apache License, Version 2.0 (the "License"); you may
                    error = new Error();
 * You may obtain a copy of the License at  
        RuntimeException e2 = new RuntimeException();
        assertSame(nestedOpenSearchException, ExceptionsHelper.unwrapToOpenSearchException(wrapper));  
import org.opensearch.transport.RemoteClusterAware;  
        withSuppressedException.addSuppressed(new RuntimeException());
            new ShardSearchFailure(new ParsingException(0, 0, "error", null)), };  
        assertThat(ExceptionsHelper.unwrapCorruption(e4), equalTo(corruptIndexException));
 * this work for additional information regarding copyright
        }
        final Throwable corruptionCauseOnSuppressed = new RuntimeException();  
        boolean fatal = false;
        assertThat(ExceptionsHelper.summaryMessage(new InputCoercionException("illegal")), equalTo("Incompatible JSON value"));
        assertSame(directException, ExceptionsHelper.unwrapToOpenSearchException(directException));
        // Test with OpenSearchException directly - should return the same exception
                    cause.addSuppressed(new Exception());
        assertThat(ExceptionsHelper.status(new IndexSearcher.TooManyClauses()), equalTo(RestStatus.BAD_REQUEST));
public class ExceptionsHelperTests extends OpenSearchTestCase {
            createShardFailureQueryShardException("error", "index", "cluster1"),  
        assertSame(nonOpenSearchException, ExceptionsHelper.unwrapToOpenSearchException(nonOpenSearchException));
        final Throwable corruptIndexException = new CorruptIndexException("corrupt", "resource");
        assertThat(ExceptionsHelper.unwrapCorruption(corruptionSuppressed), equalTo(corruptIndexException));  
            new ShardId(new Index(index, IndexMetadata.INDEX_UUID_NA_VALUE), shardId),  
        ex.setIndex(index);
 * The OpenSearch Contributors require contributions made to  
        e.addSuppressed(decoderException);
        );  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] {
import org.opensearch.action.OriginalIndices;
        ShardOperationFailedException[] groupBy = ExceptionsHelper.groupBy(failures);
                cause = error = new Error(cause);  
        assertThat(ExceptionsHelper.summaryMessage(new IllegalArgumentException("illegal")), equalTo("Invalid argument"));  
            }
            assertThat(shardOperationFailedException.index(), equalTo(expectedIndices[i++]));
    }
                    fatal = true;  
        final Exception e = new Exception();
                }  
        assertError(e, outOfMemoryError);  
            assertFalse(maybeError(cause).isPresent());  
        int shardId,
 * this file be licensed under the Apache-2.0 license or a
                fatal = true;
            createShardFailureQueryShardException("error", "index", null),  
 * license agreements. See the NOTICE file distributed with
            createShardFailureQueryShardException("error", "index", "cluster2"),
    }
import org.apache.lucene.search.IndexSearcher;  
    public void testGroupByNullTarget() {  
    }
import static org.hamcrest.CoreMatchers.instanceOf;
        assertThat(ExceptionsHelper.unwrapCorruption(e3), equalTo(corruptIndexException));
        assertThat(ExceptionsHelper.status(new JsonParseException("illegal")), equalTo(RestStatus.BAD_REQUEST));  
            new ShardSearchFailure(new IllegalArgumentException("error")),
        Error error = null;
            OriginalIndices.NONE
    }
 * Modifications Copyright OpenSearch Contributors. See
    public void testCauseCycle() {
                if (!fatal && rarely()) {  
        RuntimeException e3 = new RuntimeException(corruptIndexException);
        assertThat(ExceptionsHelper.status(new OpenSearchRejectedExecutionException("rejected")), equalTo(RestStatus.TOO_MANY_REQUESTS));
        RuntimeException level2 = new RuntimeException("level 2", level1);  
        QueryShardException queryShardException = new QueryShardException(index, error, new IllegalArgumentException("parse error"));
        RuntimeException wrapper = new RuntimeException("wrapper", nestedOpenSearchException);
        if (fatal) {  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                cause = new Exception(cause);  
        }
        String index,  
    }  
            createShardFailureQueryShardException("error", "index", "cluster1"),
import org.opensearch.core.rest.RestStatus;  
            assertThat(shardOperationFailedException.index(), nullValue());
import org.opensearch.core.index.Index;
        // Test with null - should return null  
        final Throwable withSuppressedException = new RuntimeException();
        String error,
        assertThat(ExceptionsHelper.unwrapCorruption(corruptIndexException), equalTo(corruptIndexException));
        assertThat(maybeError.get(), equalTo(error));  
        return new ShardSearchFailure(ex, createSearchShardTarget(nodeId, shardId, index, clusterAlias));  
        assertThat(ExceptionsHelper.unwrapCorruption(withSuppressedException), nullValue());  
            if (!fatal && rarely()) {
        assertThat(groupBy.length, equalTo(5));
        for (int i = 0; i < depth; i++) {  
    }
        Throwable cause = new Exception();  
    public void testStatus() {  
import org.opensearch.core.common.ParsingException;
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] {
/*  
 * compatible open source license.
