        assertNull(ex.getMessage());  
        @Override  
    public void testActionNotFoundTransportException() throws IOException {  
        assertEquals("blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];", ex.getMessage());
        assertThat(ex.contextId().getSessionId(), equalTo(contextId.getSessionId()));
                    return;
        assertEquals(-1, ex.phase());
        assertEquals(ex.getLineNumber(), 1);
        ids.put(7, org.opensearch.http.BindHttpException.class);
        ids.put(10, org.opensearch.index.engine.SnapshotFailedEngineException.class);
            assertEquals(t.getSuppressed().length, deserialized.getSuppressed().length);  
        ex = serialize(new SearchException(null, "hello world", new NullPointerException()));  
        ids.put(56, org.opensearch.common.settings.SettingsException.class);  
import org.opensearch.snapshots.SnapshotException;  
                + notRegistered,  
        ex = serialize(new InvalidIndexTemplateException(null, "bar"));
import org.opensearch.indices.InvalidIndexTemplateException;  
        assertEquals(100, ex.getMaxBuckets());
        ids.put(132, org.opensearch.index.engine.FlushFailedEngineException.class);
        assertEquals("index_template [name] missing", ex.getMessage());
        ids.put(60, null); // EarlyTerminationException was removed in 6.0
import org.opensearch.action.search.ShardSearchFailure;
        assertEquals(state, ex.currentState());  
        ids.put(117, ReplicationOperation.RetryOnPrimaryException.class);
        ids.put(30, org.opensearch.snapshots.SnapshotException.class);
        ids.put(175, ResponseLimitBreachedException.class);
        SnapshotException ex = serialize(new SnapshotException(snapshot, "no such snapshot", new NullPointerException()));
        final URI location = ExceptionSerializationTests.class.getProtectionDomain().getCodeSource().getLocation().toURI();
import org.opensearch.action.RoutingMissingException;
    public void testIndexTemplateMissingException() throws IOException {
        ShardSearchFailure[] one = new ShardSearchFailure[] { new ShardSearchFailure(new IllegalArgumentException("nono!")) };
        ids.put(129, null); // was org.opensearch.index.engine.EngineClosedException.class
        ids.put(15, org.opensearch.indices.IndexCreationException.class);
        assertEquals(CircuitBreaker.Durability.TRANSIENT, ex.getDurability());  
        assertEquals("ACTION BABY!", ex.action());  
import org.opensearch.crypto.CryptoRegistryException;
    }
                assertNull(serialize.getReason());  
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.opensearch.cluster.block.IndexCreateBlockException;
        ids.put(118, org.opensearch.OpenSearchTimeoutException.class);
        ids.put(29, org.opensearch.index.engine.DocumentMissingException.class);  
            assertEquals(serialize.getClass(), ex.getClass());  
        );
        ActionTransportException ex = serialize(new ActionTransportException("name?", transportAddress, "ACTION BABY!", "message?", null));
        ids.put(31, org.opensearch.indices.InvalidAliasNameException.class);
            ex = serialize(ex);
    }  
import org.opensearch.core.index.shard.ShardId;
                reverse.get(tuple.v2())
        AliasesNotFoundException ex = serialize(new AliasesNotFoundException("one", "two", "three"));
import java.util.Set;
        assertEquals(10, ex.phase());
/*
        assertEquals("Too large", ex.getMessage());  
        ids.put(44, org.opensearch.indices.recovery.RecoveryFailedException.class);  
            new IllegalArgumentException("alalaal"),
        ids.put(86, org.opensearch.search.aggregations.AggregationExecutionException.class);  
            assertEquals(2, ex.getHeader("foo").size());
        InterruptedException ex = serialize(orig);  
                } else if (OpenSearchException.isRegistered(clazz.asSubclass(Throwable.class), Version.CURRENT)) {  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        out.writeException(exception);
            new IndexFormatTooNewException("tooo new", 1, 2, 3),
        String msg = randomAlphaOfLength(4);
        ids.put(18, org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException.class);
import org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException;
        final UnknownException unknownException = new UnknownException("this exception is unknown", queryShardException);  
        assertEquals(ex.numberOfFiles(), 10);  
        assertEquals(orig.getMessage(), ex.getMessage());
    }  
        IllegalShardRoutingStateException serialize = serialize(  
            new MultiBucketConsumerService.TooManyBucketsException("Too many buckets", 100),  
        ShardLockObtainFailedException orig = new ShardLockObtainFailedException(shardId, "boom");
    }
                    try {
            new UnknownException("boom") };  
            if (ex.getCause().getClass() != UnknownException.class) { // unknown exception is not directly mapped
        ids.put(62, NotSerializableExceptionWrapper.class);  
    }
                if (OpenSearchException.isRegistered(clazz.asSubclass(Throwable.class), Version.CURRENT) == false  
            new DirectoryNotEmptyException("a"),
import org.opensearch.core.index.snapshots.IndexShardSnapshotException;
            "{\"type\":\"illegal_argument_exception\",\"reason\":\"illegal_argument_exception: nono!\"}",
        for (Map.Entry<Integer, Class<? extends OpenSearchException>> entry : ids.entrySet()) {
            new FileSystemException("a", "b", "c"),
    public void testSnapshotException() throws IOException {  
            assertNotNull(  
        ex = serialize(new IndexTemplateMissingException((String) null));
        ids.put(134, org.opensearch.transport.NodeNotConnectedException.class);  
        assertEquals("aliases [one, two, three] missing", ex.getMessage());  
        ids.put(143, org.opensearch.script.ScriptException.class);  
import java.util.Arrays;
        private final RestStatus status;
    }
            assertEquals("unknown_header_exception: msg", e.getMessage());  
                            hasDedicatedWrite.add(clazz);
 * this work for additional information regarding copyright
        ids.put(82, org.opensearch.repositories.RepositoryException.class);
        ShardId shardId = new ShardId(new Index(randomAlphaOfLength(4), randomAlphaOfLength(4)), randomIntBetween(0, Integer.MAX_VALUE));  
        Files.walkFileTree(testStartPath, visitor);
import org.opensearch.index.shard.IllegalIndexShardStateException;  
        ids.put(25, org.opensearch.script.GeneralScriptException.class);
                || serialize.getClass() == DirectoryNotEmptyException.class) {
    }
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
        assertTrue(notRegistered.remove(UnknownHeaderException.class));  
        {
        ids.put(80, null); // was IndexFailedEngineException, deprecated in 6.0 and removed in 7.0  
        ids.put(73, org.opensearch.snapshots.ConcurrentSnapshotExecutionException.class);
    }
            new Exception("foobar"),
        SearchShardTarget target = new SearchShardTarget("foo", new ShardId("bar", "_na_", 1), null, OriginalIndices.NONE);
        ids.put(97, org.opensearch.index.shard.IllegalIndexShardStateException.class);
        ShardLockObtainFailedException ex = serialize(orig, version);
            }
import org.opensearch.search.SearchContextMissingException;
import static java.lang.reflect.Modifier.isInterface;
            private boolean isEsException(Class<?> clazz) {  
        assertTrue(ex.getCause() instanceof NullPointerException);  
        assertEquals("boom", serialize.getMessage());
        ids.put(162, PrimaryShardClosedException.class);
        ids.put(133, org.opensearch.core.common.breaker.CircuitBreakingException.class);
        );  
    public void testFileSystemExceptions() throws IOException {
import org.opensearch.action.FailedNodeException;
        assertTrue(serialize.getCause() instanceof NullPointerException);  
import org.opensearch.index.shard.ShardNotInPrimaryModeException;  
import org.opensearch.core.common.breaker.CircuitBreaker;
        assertEquals("foo", ex.getMessage());
                t.addSuppressed(new NullPointerException());
    public void testQueryShardException() throws IOException {
            Strings.toString(MediaTypeRegistry.JSON, ex)  
        ids.put(123, org.opensearch.ResourceAlreadyExistsException.class);
        final Set<Class<?>> registered = new HashSet<>();  
            "org.opensearch.rest.action.RestActionListenerTests$2"
                pkgPrefix = pkgPrefix.resolve(dir.getFileName());
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        RecoveryEngineException ex = serialize(new RecoveryEngineException(id, 10, "total failure", new NullPointerException()));
import org.opensearch.transport.client.node.AbstractClientHeadersTestCase;  
        );
        ids.put(135, org.opensearch.index.mapper.StrictDynamicMappingException.class);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        ids.put(51, null);
        ids.put(107, org.opensearch.repositories.RepositoryMissingException.class);  
            assertArrayEquals(deserialized.getStackTrace(), ex.getStackTrace());
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        assertTrue(ex.blocks().contains(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
        ids.put(66, org.opensearch.index.shard.IndexShardNotRecoveringException.class);
        assertEquals(ex.getRepositoryName(), snapshot.getRepository());  
            new IndexFormatTooOldException("tooo new", "very old version"),  
    public void testSearchPhaseExecutionException() throws IOException {
        ids.put(92, org.opensearch.indices.recovery.DelayRecoveryException.class);
import org.opensearch.indices.recovery.PeerRecoveryNotFound;
        assertEquals("id", ex.getId());  
        ids.put(19, org.opensearch.ResourceNotFoundException.class);
        ActionNotFoundTransportException ex = serialize(new ActionNotFoundTransportException("AACCCTION"));
                        }
        assertEquals("baam", ex.getMessage());
        assertThat(ex.contextId().getId(), equalTo(contextId.getId()));  
                assertEquals(serialize.getClass().toString(), "c", serialize.getReason());  
        TimestampParsingException ex = serialize(new TimestampParsingException("TIMESTAMP", null));
    private <T extends Exception> T serialize(T exception, Version version) throws IOException {
        ids.put(120, org.opensearch.repositories.RepositoryVerificationException.class);
        ids.put(98, IndexShardSnapshotException.class);  
    }
import org.opensearch.transport.stream.StreamException;
        assertEquals(ex.getMessage(), "[_na] no such snapshot");
        assertEquals(id, ex.getShardId());  
            new AccessDeniedException("a", "b", "c"),
        ids.put(71, org.opensearch.action.FailedNodeException.class);  
        ids.put(130, org.opensearch.action.NoShardAvailableActionException.class);
        IndexTemplateMissingException ex = serialize(new IndexTemplateMissingException("name"));  
        assertTrue(exception instanceof OpenSearchException);
        assertEquals(0, ex.getBytesWanted());
        assertEquals(666, ex.getColumnNumber());  
            assertSame(status, e.status());
        ids.put(83, org.opensearch.transport.ReceiveTimeoutTransportException.class);  
        SnapshotInProgressException orig = new SnapshotInProgressException("boom");
            super(in);  
        TransportAddress transportAddress = buildNewFakeTransportAddress();
        CircuitBreakingException ex = serialize(
        Version version = VersionUtils.randomVersion(random());
    }  
            new CircuitBreakingException("Too large", 0, 100, CircuitBreaker.Durability.TRANSIENT),  
                assertEquals((int) entry.getKey(), OpenSearchException.getId(entry.getValue()));  
                    throw new RuntimeException(e);
        ids.put(79, org.opensearch.action.RoutingMissingException.class);
        ids.put(156, RetentionLeaseInvalidRetainingSeqNoException.class);
    }
    public void testCircuitBreakingException() throws IOException {
import java.nio.file.AtomicMoveNotSupportedException;
            }
            }
        for (Exception t : unknowns) {
        for (Map.Entry<Integer, Class<? extends OpenSearchException>> entry : ids.entrySet()) {
                || serialize.getClass() == FileSystemLoopException.class  
            uhe.addMetadata("opensearch.foo_metadata", "value1", "value2");
        assertNull(ex.getCause());
                assertArrayEquals(t.getSuppressed()[0].getStackTrace(), deserialized.getSuppressed()[0].getStackTrace());  
                    pkg.append(p.getFileName().toString()).append(".");
import org.opensearch.action.support.replication.ReplicationOperation;
        SearchContextMissingException ex = serialize(new SearchContextMissingException(contextId), version);
import org.opensearch.index.query.QueryShardException;
        assertEquals("Too many buckets", ex.getMessage());  
import org.opensearch.indices.replication.common.ReplicationFailedException;  
        assertEquals("CurrentState[" + state.name() + "] come back later buddy", ex.getMessage());
            assertArrayEquals(t.getStackTrace(), deserialized.getStackTrace());
        {
    }
    }
        ids.put(45, org.opensearch.index.shard.IndexShardRelocatedException.class);
import org.opensearch.search.pipeline.SearchPipelineProcessingException;
    }
        QueryShardException ex = serialize(new QueryShardException(new Index("foo", "_na_"), "fobar", null));  
        assertEquals("AACCCTION", ex.action());
        ids.put(35, org.opensearch.OpenSearchParseException.class);  
        assertEquals("[name?][" + transportAddress.toString() + "][ACTION BABY!] message?", ex.getMessage());
        final ShardRouting routing = TestShardRouting.newShardRouting("test", 0, "xyz", "def", false, ShardRoutingState.STARTED);
import org.opensearch.env.ShardLockObtainFailedException;
        ids.put(139, null);
                try {
        assertTrue(
import org.opensearch.common.collect.Tuple;
        for (final int id : OpenSearchException.ids()) {  
        ShardSearchContextId contextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomLong());  
        class UnknownException extends Exception {  
        assertNotNull(serialize.shard());  
        ids.put(46, org.opensearch.transport.NodeShouldNotConnectException.class);
        assertNull(serialize.getCause());  
        ids.put(178, org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException.class);
import org.opensearch.index.seqno.RetentionLeaseInvalidRetainingSeqNoException;
    public void testOpenSearchSecurityException() throws IOException {  
    }
            new FileNotFoundException("booom"),  
        assertEquals("baam", ex.getMessage());  
        assertEquals(ex.getMessage(), "Failed to transfer [10] files with total size of [" + bytes + "]");
        assertEquals(ex.getSnapshotName(), snapshot.getSnapshotId().getName());
            assertTrue(serialize instanceof NotSerializableExceptionWrapper);
        ids.put(171, CryptoRegistryException.class);
        }
            AbstractClientHeadersTestCase.InternalException.class.getName(),  
        assertTrue(notRegistered.remove(TestException.class));
                "Expected: "
        final QueryShardException queryShardException = new QueryShardException(new Index("foo", "_na_"), "foobar", null);
        ParsingException ex = serialize(new ParsingException(1, 2, "fobar", null));
        }  
                t.addSuppressed(new UnsatisfiedLinkError("suppressed"));  
import static java.util.Collections.singleton;
            new LockObtainFailedException("can't lock directory", new NullPointerException()),  
            .resolve("org")
        ids.put(172, null); // was ViewNotFoundException, removed in 3.10.0
 * KIND, either express or implied.  See the License for the
        assertEquals("the node", ex.nodeId());
    }  
        assertEquals(ex.getMessage(), "[" + snapshot + "] no such snapshot");
        assertEquals("boom", ex.getPhaseName());
        ids.put(106, org.opensearch.index.shard.IndexShardRecoveryException.class);
        ids.put(54, null); // was DocumentAlreadyExistsException, which is superseded with VersionConflictEngineException
            } else {
        ids.put(122, null);  
import org.opensearch.cluster.coordination.NodeHealthCheckFailureException;
import java.util.Map;
        assertEquals("boom", ex.getPhaseName());
        assertTrue(ex.shardFailures()[0].getCause() instanceof IllegalArgumentException);  
        assertEquals("Phase[10] total failure", ex.getMessage());
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
 */
        ids.put(108, null);
import org.opensearch.core.index.Index;  
        ids.put(9, org.opensearch.node.NodeClosedException.class);
        ids.put(157, IngestProcessorException.class);
        ids.put(148, null);
        assertNull(ex.getCause());
 * compatible open source license.
        ids.put(161, ReplicationFailedException.class);  
        }
        ids.put(74, org.opensearch.common.blobstore.BlobStoreException.class);  
import org.opensearch.core.common.transport.TransportAddress;
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    private <T extends Exception> T serialize(T exception) throws IOException {
                if (isEsException(clazz) == false) {  
        ids.put(119, org.opensearch.search.query.QueryPhaseExecutionException.class);  
        ids.put(55, org.opensearch.action.NoSuchNodeException.class);
        ids.put(150, CoordinationStateRejectedException.class);
        ids.put(57, org.opensearch.indices.IndexTemplateMissingException.class);
    public void testRecoveryEngineException() throws IOException {  
                for (Path p : pkgPrefix) {  
        assertEquals(routing, serialize.shard());
        ids.put(126, org.opensearch.index.mapper.MapperParsingException.class);
package org.opensearch;
        final Path testStartPath = PathUtils.get(location).resolve(path);  
 * license agreements. See the NOTICE file distributed with
        SearchParseException ex = serialize(new SearchParseException(SHARD_TARGET, "foo", new XContentLocation(66, 666)));  
        assertEquals("[][" + transportAddress + "][action] msg", ex.getMessage());
    public void testSearchContextMissingException() throws IOException {
        assertTrue(ex.getCause() instanceof NullPointerException);
        assertEquals(parsingException.getIndex(), e.getIndex());
        );
        }
        ids.put(149, MultiBucketConsumerService.TooManyBucketsException.class);  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        assertEquals(orig.getMessage(), ex.getMessage());
        assertTrue(ex.getCause() instanceof NullPointerException);  
            }
        ParsingException e = (ParsingException) exception.getCause();  
    public void testFailedNodeException() throws IOException {  
        assertNull(ex.getShardId());
                return FileVisitResult.CONTINUE;  
        UnknownException(final String message, final Exception cause) {
                        if (clazz.getMethod("writeTo", StreamOutput.class) != null) {  
            new StringIndexOutOfBoundsException("booom"),
        assertEquals("repo", ex.repository());  
        ids.put(142, ShardStateAction.NoLongerPrimaryShardException.class);
        final Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap", UUIDs.randomBase64UUID()));
        ids.put(11, org.opensearch.index.shard.ShardNotFoundException.class);  
                    return;
                assertTrue(deserialized.getSuppressed()[1] instanceof NullPointerException);
                assertEquals(serialize.getClass().toString(), "b", serialize.getOtherFile());
 */
        ids.put(68, org.opensearch.OpenSearchException.class);  
        ids.put(40, ParsingException.class);
import org.opensearch.ingest.IngestProcessorException;
            assertTrue(deserialized.getClass().toString(), deserialized instanceof NotSerializableExceptionWrapper);
import org.opensearch.cluster.routing.ShardRouting;  
    }
                checkFile(file.getFileName().toString());
        ex = serialize(new RecoveryEngineException(null, -1, "total failure", new NullPointerException()));  
            @Override
                }
import java.nio.file.FileSystemException;
        assertEquals(orig.getMessage(), ex.getMessage());
            Throwable deserialized = serialize(t);  
        IllegalIndexShardStateException ex = serialize(new IllegalIndexShardStateException(id, state, "come back later buddy"));  
    }
        }
        }
            if (t.getSuppressed().length > 0) {
        assertEquals(node, ex.node());
    public void testRecoverFilesRecoveryException() throws IOException {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals("[_na] msg", ex.getMessage());
import org.opensearch.cluster.routing.NodeWeighedAwayException;
        ids.put(144, org.opensearch.cluster.NotClusterManagerException.class);
        ids.put(145, org.opensearch.OpenSearchStatusException.class);
        assertEquals(ex.totalFilesSize(), bytes);
        for (final Exception cause : causes) {
import org.opensearch.common.util.set.Sets;
        assertEquals(ex.getLineNumber(), 1);
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;  
            if (entry.getValue() != null) {
        ids.put(52, org.opensearch.index.engine.VersionConflictEngineException.class);
        ShardStateAction.NoLongerPrimaryShardException ex = serialize(new ShardStateAction.NoLongerPrimaryShardException(shardId, msg));
        ids.put(179, org.opensearch.storage.action.tiering.MergeDrainTimeoutException.class);  
            }
 *
        OpenSearchSecurityException ex = new OpenSearchSecurityException("user [{}] is not allowed", RestStatus.UNAUTHORIZED, "foo");
            }
                }  
import org.opensearch.transport.NoSeedNodeLeftException;  
import java.nio.file.FileSystemLoopException;
        assertEquals("No handler for action [AACCCTION]", ex.getMessage());  
import java.nio.file.NoSuchFileException;  
        ids.put(20, org.opensearch.transport.ActionTransportException.class);  
        assertEquals(ex.getColumnNumber(), 2);
    public void testTimestampParsingException() throws IOException {
        final Set<Integer> ids = new HashSet<>();
            assertTrue(  
import java.io.EOFException;
        ids.put(59, null); // was OpenSearchRejectedExecutionException, which is no longer an instance of OpenSearchException  
        assertEquals(RestStatus.UNAUTHORIZED, e.status());
        final Set<Class<?>> notRegistered = new HashSet<>();
import org.opensearch.core.common.io.stream.StreamOutput;  
        ParsingException parsingException = new ParsingException(1, 2, "foobar", null);
            new NotDirectoryException("a"),  
        assertNull(ex.getIndex());
}  
import org.opensearch.test.VersionUtils;
    }  
        ids.put(58, org.opensearch.transport.SendRequestTransportException.class);
            new NumberFormatException("not a number"),
        ids.put(14, org.opensearch.transport.ResponseHandlerFailureTransportException.class);  
            new EOFException("dadada"),  
        assertEquals("name", ex.name());
        assertNull(ex.repository());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("the message", ex.getMessage());  
        ids.put(116, org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException.class);  
            this.status = status;  
import static java.util.Collections.emptySet;
import org.opensearch.transport.ConnectTransportException;
                reverse.put(entry.getValue(), entry.getKey());  
            FileSystemException serialize = serialize(ex);
        assertNull(ex.shard());
        final Path coreLibStartPath = PathUtils.get(OpenSearchException.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        assertEquals(ex.getColumnNumber(), 2);
        ids.put(114, org.opensearch.index.shard.IndexShardRecoveringException.class);
        assertEquals(ex.getShardId(), id);
        ids.put(113, org.opensearch.rest.action.admin.indices.AliasesNotFoundException.class);  
import java.util.HashMap;
import java.nio.file.FileVisitResult;  
        ids.put(85, null);
            CancellableThreadsTests.CustomException.class.getName(),
import org.opensearch.cluster.decommission.NodeDecommissionedException;
            assertEquals("value1", ex.getMetadata("opensearch.foo_metadata").get(0));
    public void testIds() {
        assertEquals(ex.getMessage(), "hello world");
        assertEquals(ex.status(), e.status());  
        ids.put(176, IngestionEngineException.class);  
import org.opensearch.common.io.PathUtils;
            assertEquals(2, e.getMetadata("opensearch.foo_metadata").size());
        Files.walkFileTree(coreLibStartPath, visitor);
import static java.util.Collections.emptyMap;  
    }
import org.opensearch.index.seqno.RetentionLeaseAlreadyExistsException;  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
    public void testAliasesMissingException() throws IOException {
        }  
    public void testIllegalIndexShardStateException() throws IOException {  
        ids.put(28, null); // was DeleteFailedEngineException, deprecated in 6.0 and removed in 7.0
        ids.put(173, null); // was ViewAlreadyExistsException, removed in 3.10.0  
        FileVisitor<Path> visitor = new FileVisitor<Path>() {  
        ids.put(12, org.opensearch.transport.ConnectTransportException.class);
    }
                return FileVisitResult.CONTINUE;  
 */  
        assertEquals(orig.getShardId(), ex.getShardId());  
        ids.put(141, org.opensearch.index.query.QueryShardException.class);
    public void testSearchException() throws IOException {  
import org.opensearch.cluster.action.shard.ShardStateAction;  
        assertEquals(
        ShardId id = new ShardId("foo", "_na_", 1);
        ids.put(131, org.opensearch.action.UnavailableShardsException.class);  
import org.apache.lucene.store.AlreadyClosedException;  
        serialize = serialize(new IllegalShardRoutingStateException(routing, "bar", null));
import org.opensearch.search.internal.ShardSearchContextId;  
import org.apache.lucene.index.CorruptIndexException;  
        ids.put(77, org.opensearch.common.util.concurrent.UncategorizedExecutionException.class);  
        ids.put(17, org.opensearch.cluster.routing.IllegalShardRoutingStateException.class);  
            assertEquals("foo", e.getHeader("foo").get(0));
            }
            new OpenSearchSecurityException("nono!"),
        ShardSearchFailure[] empty = new ShardSearchFailure[0];
            notRegistered.isEmpty()
                assertNull(serialize.getOtherFile());
        assertEquals("[repo] msg", ex.getMessage());
        for (FileSystemException ex : Arrays.asList(  
                assertEquals(deserialized.getCause().getClass(), ex.getCause().getClass());  
        ids.put(169, NodeWeighedAwayException.class);
    }
        ids.put(2, org.opensearch.common.util.CancellableThreads.ExecutionCancelledException.class);  
        )) {  
        ids.put(174, InvalidIndexContextException.class);
        assertEquals(66, ex.getLineNumber());
            assertEquals("value2", ex.getMetadata("opensearch.foo_metadata").get(1));  
        ids.put(67, org.opensearch.http.HttpException.class);
    public void testUnknownException() throws IOException {  
        ids.put(102, org.opensearch.transport.TransportSerializationException.class);
 * Licensed to Elasticsearch under one or more contributor  
    public void testInterruptedException() throws IOException {
 * specific language governing permissions and limitations
    public void testShardLockObtainFailedException() throws IOException {  
        ids.put(10001, IndexCreateBlockException.class);
        assertNull(ex.name());  
            assertEquals("bar", ex.getHeader("foo").get(1));  
        assertEquals(100, ex.getByteLimit());
        ids.put(21, org.opensearch.OpenSearchGenerationException.class);
                }
                    + deserialized.getCause().getMessage()
        ids.put(22, null); // was CreateFailedEngineException
        ids.put(8, org.opensearch.action.search.ReduceSearchPhaseException.class);  
import java.nio.file.Path;
        ids.put(27, org.opensearch.snapshots.SnapshotCreationException.class);
    }  
        assertEquals("routing is required for [idx]/[id]", ex.getMessage());
            private void checkFile(String filename) {  
import org.opensearch.transport.NoSuchRemoteClusterException;
        ids.put(70, org.opensearch.action.PrimaryMissingActionException.class);
            ex.addHeader("foo", "foo", "bar");  
        assertEquals(parsingException.getColumnNumber(), e.getColumnNumber());
        ids.put(24, org.opensearch.search.SearchContextMissingException.class);
            // ensure we are carrying over the headers and metadata even if not serialized
        assertEquals("[][" + transportAddress.toString() + "][action] msg", ex.getMessage());
        ids.put(81, org.opensearch.index.snapshots.IndexShardRestoreFailedException.class);
        assertNull(ex.getMessage());  
        assertEquals(empty.length, ex.shardFailures().length);
        assertTrue(serialize.getCause() instanceof NullPointerException);
        assertEquals(ex.getMessage(), "fobar");  
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
import org.opensearch.index.shard.PrimaryShardClosedException;
                pkg.append(filename.substring(0, filename.length() - 6));  
        ids.put(48, org.opensearch.index.translog.TranslogCorruptedException.class);
        assertEquals(one.length, ex.shardFailures().length);
            assertThat("negative id", id, greaterThanOrEqualTo(0));  
                    return;
        ex = serialize(new RepositoryException(null, "msg"));  
        ex = serialize(new ConnectTransportException(node, "msg", "action", new NullPointerException()));  
import java.nio.file.Files;
        assertEquals(target, ex.shard());  
        assertEquals(ex.name(), null);  
        ids.put(99, org.opensearch.index.shard.IndexShardNotStartedException.class);
            }
        ex = serialize(new NotSerializableExceptionWrapper(new IllegalArgumentException("nono!")));  
            new NoSuchFileException("booom"),
    public void testOpenSearchRemoteException() throws IOException {
        ids.put(152, NoSuchRemoteClusterException.class);  
        public TestException(StreamInput in) throws IOException {
import org.opensearch.core.common.unit.ByteSizeValue;
        final Path startPath = PathUtils.get(OpenSearchServerException.class.getProtectionDomain().getCodeSource().getLocation().toURI())  
        );
        ids.put(50, org.opensearch.search.fetch.FetchPhaseExecutionException.class);  
        OpenSearchSecurityException e = serialize(ex);
        assertEquals(1, ex.blocks().size());  
        StreamInput in = out.bytes().streamInput();
import org.opensearch.core.common.ParsingException;  
        OpenSearchStatusException ex = new OpenSearchStatusException("something", RestStatus.TOO_MANY_REQUESTS);  
            new FileAlreadyExistsException("a", "b", "c"),  
            version
            assertEquals("a", serialize.getFile());
 *  
        final String routingAsString = routing.toString();
        assertEquals(ex.numberOfFiles(), 10);
        assertTrue(ex.getCause() instanceof NullPointerException);  
        assertEquals(registered.toString(), 0, registered.size());
import org.opensearch.search.SearchParseException;  
                } catch (ClassNotFoundException e) {  
        Exception exception = serialize(ex);  
        ids.put(72, org.opensearch.search.SearchParseException.class);
        ids.put(115, org.opensearch.index.translog.TranslogException.class);
import org.opensearch.cluster.decommission.DecommissioningFailedException;  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(ex.getCause() instanceof NullPointerException);  
        assertEquals(ex.getMessage(), "hello world");
        ids.put(170, SearchPipelineProcessingException.class);  
import org.opensearch.common.breaker.ResponseLimitBreachedException;  
import org.apache.lucene.index.IndexFormatTooNewException;
    }
                    + " but it didn't",
        assertNull(ex.getRepositoryName());  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
    public void testActionTransportException() throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<Integer, Class<? extends OpenSearchException>> ids = new HashMap<>();  
        MultiBucketConsumerService.TooManyBucketsException ex = serialize(
        assertEquals(parsingException.getMessage(), e.getMessage());
        ids.put(69, org.opensearch.snapshots.SnapshotMissingException.class);
        assertTrue(ex.getCause() instanceof NullPointerException);
            super(message, cause);  
            if (randomBoolean()) {
        assertEquals(RestStatus.TOO_MANY_REQUESTS, e.status());  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.search.SearchPhaseExecutionException;  
        out.setVersion(version);
import org.opensearch.search.SearchException;
import org.opensearch.snapshots.SnapshotId;
        DiscoveryNode node = new DiscoveryNode("thenode", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
                    && OpenSearchException.class.equals(clazz.getEnclosingClass()) == false) {
        ConnectTransportException ex = serialize(new ConnectTransportException(node, "msg", "action", null));  
            assertTrue(deserialized.getStackTrace().length > 1);
                return OpenSearchException.class.isAssignableFrom(clazz);
        // walk the core library start path
import java.io.IOException;  
            );  
    }
        assertEquals(ex.getMessage(), "index_template [foo] invalid, cause [bar]");
            org.opensearch.rest.BytesRestResponseTests.WithHeadersException.class.getName(),
import org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper;
        final Set<Class<?>> hasDedicatedWrite = new HashSet<>();
        assertEquals(transportAddress, ex.address());
    public void testSearchParseException() throws IOException {
        assertEquals(msg, ex.getMessage());
        return serialize(exception, VersionUtils.randomVersion(random()));
        SnapshotInProgressException ex = serialize(orig, version);  
        assertEquals("unknown_exception: eggplant", exception.getMessage());
        ShardId id = new ShardId("foo", "_na_", 1);
        assertEquals("TIMESTAMP", ex.timestamp());
 * software distributed under the License is distributed on an
        ids.put(166, SnapshotInUseDeletionException.class);
                if (filename.endsWith(".class") == false) {
            OpenSearchException ex = new OpenSearchException("topLevel", cause);  
import org.opensearch.cluster.routing.ShardRoutingState;
        assertEquals(routing, serialize.shard());
        // walk the server module start path  
    }
            }  
import java.nio.file.attribute.BasicFileAttributes;  
                deserialized.getCause().getMessage().contains(ex.getCause().getMessage())  
                        // fair enough
        ids.put(177, StreamException.class);
        assertEquals(ex.totalFilesSize(), bytes);  
        Files.walkFileTree(startPath, visitor);
            private Class<?> loadClass(String filename) throws ClassNotFoundException {
        ids.put(65, org.opensearch.gateway.GatewayException.class);  
    public void testClusterBlockException() throws IOException {  
        assertNull(ex.getSnapshotName());
            } else {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(parsingException.getLineNumber(), e.getLineNumber());  
        assertEquals(shardId, ex.getShardId());  
import org.opensearch.transport.ActionNotFoundTransportException;  
 * under the License.  
        ids.put(96, org.opensearch.snapshots.InvalidSnapshotNameException.class);
                if (ignore.contains(clazz.getName()) || isAbstract(clazz.getModifiers()) || isInterface(clazz.getModifiers())) {  
            Strings.toString(MediaTypeRegistry.JSON, ex)
    public void testConnectTransportException() throws IOException {  
                tuple.v2().getName() + " not found in ExceptionSerializationTests.testIds. Please add it.",
        ids.put(34, org.opensearch.transport.TransportException.class);
import org.apache.lucene.index.IndexFormatTooOldException;
            assertNotNull(tuple.v1());
        ids.put(41, org.opensearch.index.shard.IndexShardClosedException.class);  
import org.opensearch.snapshots.SnapshotInProgressException;
/*
        ids.put(168, PreferenceBasedSearchNotAllowedException.class);
        assertEquals("action", ex.action());  
    }
        ids.put(53, org.opensearch.index.engine.EngineException.class);  
import static org.hamcrest.Matchers.equalTo;
        ids.put(159, NodeHealthCheckFailureException.class);
import java.nio.file.FileAlreadyExistsException;  
        for (final int id : OpenSearchException.ids()) {
            private void checkClass(Class<?> clazz) {
        ids.put(167, UnsupportedWeightedRoutingStateException.class);  
            assertEquals("foo", ex.getHeader("foo").get(0));
            return status;
import org.opensearch.index.engine.IngestionEngineException;  
        ids.put(109, org.opensearch.index.engine.DocumentSourceMissingException.class);
            new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))
import org.opensearch.cluster.coordination.CoordinationStateRejectedException;  
import org.apache.lucene.store.LockObtainFailedException;
            Version.V_2_0_0
        RepositoryException ex = serialize(new RepositoryException("repo", "msg"));
        assertEquals("action", ex.action());  
        assertTrue(ex.getCause() instanceof NullPointerException);  
import org.opensearch.common.UUIDs;
    public void testRoutingMissingException() throws IOException {  
        }
import org.opensearch.transport.ActionTransportException;
import org.opensearch.cluster.routing.TestShardRouting;
        InvalidIndexTemplateException ex = serialize(new InvalidIndexTemplateException("foo", "bar"));
        assertTrue(ex.getCause() instanceof NullPointerException);  
        ids.put(84, org.opensearch.transport.NodeDisconnectedException.class);
            if (serialize.getClass() == NotDirectoryException.class
        ids.put(63, org.opensearch.indices.AliasFilterParsingException.class);
 * not use this file except in compliance with the License.
        ids.put(104, org.opensearch.index.engine.EngineCreationFailureException.class);  
        assertNull(ex.getShardId());
            assertEquals("value1", e.getMetadata("opensearch.foo_metadata").get(0));
            UnknownException(final String message) {
        OpenSearchStatusException e = serialize(ex);
    private static class UnknownException extends Exception {
        ids.put(121, org.opensearch.search.aggregations.InvalidAggregationPathException.class);
    }
        ClusterBlockException ex = serialize(
import org.opensearch.action.OriginalIndices;  
                super(message);
            OpenSearchException deserialized = serialize(ex);
            NotSerializableExceptionWrapper e = (NotSerializableExceptionWrapper) serialize;
    }
            UnknownHeaderException uhe = new UnknownHeaderException("msg", status);
            assertEquals("msg", ex.getMessage());  
    public void testNotSerializableExceptionWrapper() throws IOException {  
        ids.put(128, org.opensearch.search.builder.SearchSourceBuilderException.class);  
        ids.put(38, org.opensearch.indices.InvalidTypeNameException.class);  
        SearchException ex = serialize(new SearchException(target, "hello world"));
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.routing.UnsupportedWeightedRoutingStateException;  
        ids.put(137, org.opensearch.indices.TypeMissingException.class);  
            "{\"type\":\"null_pointer_exception\",\"reason\":\"null_pointer_exception: null\"}",  
        ids.put(146, org.opensearch.core.tasks.TaskCancelledException.class);  
        ids.put(16, org.opensearch.index.IndexNotFoundException.class);
        ids.put(158, PeerRecoveryNotFound.class);  
        );
        final Set<String> ignore = Sets.newHashSet(  
        }
        }
        RecoverFilesRecoveryException ex = serialize(new RecoverFilesRecoveryException(id, 10, bytes, null));  
    public void testNoLongerPrimaryShardException() throws IOException {
    public void testTooManyBucketsException() throws IOException {  
        assertNull(ex.getIndex());
                assertEquals(deserialized.getCause().getClass(), NotSerializableExceptionWrapper.class);
    public static final class TestException extends OpenSearchException {
            @Override  
        assertArrayEquals(new String[] { "one", "two", "three" }, ex.getResourceId().toArray(new String[0]));
        assertEquals(ex.getMessage(), "index_template [null] invalid, cause [bar]");
        ids.put(6, org.opensearch.indices.IndexClosedException.class);
 * SPDX-License-Identifier: Apache-2.0
    public void testExceptionRegistration() throws ClassNotFoundException, IOException, URISyntaxException {  
            "Classes subclassing OpenSearchException must be registered in OpenSearchException.OpenSearchExceptionHandle \n"
    public static class UnknownHeaderException extends OpenSearchException {
    }
        ids.put(33, org.opensearch.indices.IndexPrimaryShardNotAllocatedException.class);
            new IndexFormatTooOldException("tooo new", 1, 2, 3),
            new ClassCastException("boom boom boom"),
            new CorruptIndexException("baaaam booom", "this is my resource"),  
        in.setVersion(version);
import org.opensearch.indices.InvalidIndexContextException;
        ids.put(165, ClusterManagerThrottlingException.class);
import org.opensearch.indices.recovery.RecoverFilesRecoveryException;
            assertEquals("value2", e.getMetadata("opensearch.foo_metadata").get(1));  
    }
                    } catch (Exception e) {  
        IOException serialize = serialize(new IOException("boom", new NullPointerException()));  
        ids.put(76, org.opensearch.index.engine.RecoveryEngineException.class);
        ids.put(36, org.opensearch.search.SearchException.class);
        TransportAddress transportAddress = buildNewFakeTransportAddress();
        assertEquals(
        ids.put(26, null);  
import java.nio.file.AccessDeniedException;  
    public void testWriteThrowable() throws IOException {
        ids.put(39, org.opensearch.snapshots.SnapshotRestoreException.class);
        ids.put(64, null); // DeleteByQueryFailedEngineException was removed in 3.0
        final Exception ex = new UnknownException("eggplant", parsingException);
        assertEquals(routingAsString + ": foo", serialize.getMessage());
        ids.put(154, RetentionLeaseNotFoundException.class);
        ids.put(49, org.opensearch.cluster.block.ClusterBlockException.class);
 * You may obtain a copy of the License at  
        );
import org.opensearch.cluster.node.DiscoveryNode;
import java.nio.file.NotDirectoryException;
                    + ex.getCause().getClass().getName()
                return getClass().getClassLoader().loadClass(pkg.toString());
        ids.put(78, org.opensearch.action.TimestampParsingException.class);
    }
    }
        ids.put(163, DecommissioningFailedException.class);
    }  
        ids.put(147, org.opensearch.env.ShardLockObtainFailedException.class);
                StringBuilder pkg = new StringBuilder();
        ids.put(95, null);  
import org.opensearch.common.util.CancellableThreadsTests;
    }  
        assertEquals(ex.status(), e.status());
        NotSerializableExceptionWrapper ex = serialize(new NotSerializableExceptionWrapper(new NullPointerException()));
        for (final Tuple<Integer, Class<? extends OpenSearchException>> tuple : OpenSearchException.classes()) {
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;  
        ids.put(1, org.opensearch.search.dfs.DfsPhaseExecutionException.class);
        );
    }
        ids.put(164, NodeDecommissionedException.class);  
        ShardId id = new ShardId("foo", "_na_", 1);
            new AtomicMoveNotSupportedException("a", "b", "c"),
        ids.put(32, org.opensearch.indices.InvalidIndexNameException.class);  
        ids.put(23, org.opensearch.index.shard.IndexShardStartedException.class);  
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
            private Path pkgPrefix = PathUtils.get(path).getParent();
        ByteSizeValue bytes = new ByteSizeValue(randomIntBetween(0, 10000));
import org.opensearch.index.engine.RecoveryEngineException;
            }
                }  
        ids.put(136, org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException.class);
        Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
        Map<Class<? extends OpenSearchException>, Integer> reverse = new HashMap<>();  
        ids.put(0, IndexShardSnapshotFailedException.class);
            );
    public void testParsingException() throws IOException {  
    public void testThatIdsAreUnique() {
        SearchPhaseExecutionException ex = serialize(new SearchPhaseExecutionException("boom", "baam", new NullPointerException(), empty));  
    }
            }
        };
                }
            super(msg);
                assertTrue(deserialized.getSuppressed()[0] instanceof NotSerializableExceptionWrapper);
        assertEquals(ex.getIndex().getName(), "foo");
            OpenSearchException serialize = serialize((OpenSearchException) uhe);  
        ids.put(100, org.opensearch.action.search.SearchPhaseExecutionException.class);
        }
            new NullPointerException("boom"),
            if (entry.getValue() != null) {
            }  
        ids.put(43, org.opensearch.index.translog.TruncatedTranslogException.class);
public class ExceptionSerializationTests extends OpenSearchTestCase {
import org.opensearch.snapshots.SnapshotInUseDeletionException;  
 *
                return FileVisitResult.CONTINUE;  
import org.opensearch.core.xcontent.XContentLocation;  
        assertNotNull(serialize.shard());  
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;  
        }  
        Exception[] unknowns = new Exception[] {  
        assertTrue(registered.removeAll(OpenSearchException.getRegisteredKeys())); // check  
        assertEquals(routingAsString + ": bar", serialize.getMessage());
            }  
        }
            new FileSystemLoopException("a")
    }
import org.opensearch.action.TimestampParsingException;
            assertEquals((int) reverse.get(tuple.v2()), (int) tuple.v1());
            assertEquals(2, e.getHeader("foo").size());
        ids.put(127, null); // was org.opensearch.search.SearchContextException.class
            new IllegalStateException("foobar"),  
        ids.put(155, ShardNotInPrimaryModeException.class);  
    }
            new AlreadyClosedException("closed!!", new NullPointerException()),
        ids.put(103, org.opensearch.transport.RemoteTransportException.class);
    }  
        assertEquals(node, ex.node());
        IndexShardState state = randomFrom(IndexShardState.values());
    public void testThatIdsArePositive() {
        ex = serialize(new RecoverFilesRecoveryException(null, 10, bytes, new NullPointerException()));
import static java.lang.reflect.Modifier.isAbstract;
        return in.readException();  
        UnknownHeaderException(String msg, RestStatus status) {
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
import org.opensearch.core.rest.RestStatus;
                    notRegistered.add(clazz);
import org.opensearch.indices.IndexTemplateMissingException;
            OpenSearchException ex = new OpenSearchException("msg");
/*  
    public void testIOException() throws IOException {
    public void testSnapshotInProgressException() throws IOException {  
        ids.put(112, org.opensearch.transport.BindTransportException.class);
        assertEquals("failed to parse timestamp [TIMESTAMP]", ex.getMessage());  
                    registered.add(clazz);
                    checkClass(loadClass(filename));
        ids.put(3, org.opensearch.discovery.ClusterManagerNotDiscoveredException.class);
        ids.put(101, org.opensearch.transport.ActionNotFoundTransportException.class);  
 * The OpenSearch Contributors require contributions made to  
        ids.put(151, SnapshotInProgressException.class);
                pkgPrefix = pkgPrefix.getParent();
            assertEquals(2, ex.getMetadata("opensearch.foo_metadata").size());
        ids.put(125, TcpTransport.HttpRequestOnTransportException.class);  
        ids.put(124, null);
    }
        BytesStreamOutput out = new BytesStreamOutput();  
        ids.put(61, null); // RoutingValidationException was removed in 5.0
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
        ids.put(13, org.opensearch.transport.NotSerializableTransportException.class);
            new ArrayIndexOutOfBoundsException("booom"),
                    + " to contain: "  
        public RestStatus status() {
            assertTrue("duplicate id", ids.add(id));
            new IllegalShardRoutingStateException(routing, "foo", new NullPointerException())
        ids.put(42, org.opensearch.indices.recovery.RecoverFilesRecoveryException.class);
            }
        ids.put(88, org.opensearch.indices.InvalidIndexTemplateException.class);
            @Override  
    public void testWithRestHeadersException() throws IOException {  
        assertEquals(ex.getMessage(), "fobar");
            uhe.addHeader("foo", "foo", "bar");  
        }
        assertEquals("index_template [null] missing", ex.getMessage());
import org.opensearch.index.shard.IndexShardState;
import org.opensearch.snapshots.Snapshot;
        ids.put(140, org.opensearch.cluster.coordination.FailedToCommitClusterStateException.class);  
        assertEquals(id, ex.getShardId());
        ids.put(91, org.opensearch.search.aggregations.AggregationInitializationException.class);  
            assertEquals(deserialized.getMessage(), ex.getMessage());
        ids.put(160, NoSeedNodeLeftException.class);
    }
    }
        assertEquals(ex.name(), "foo");  
                }
import java.net.URI;
        ids.put(47, null);  
        FailedNodeException ex = serialize(new FailedNodeException("the node", "the message", null));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ids.put(90, org.opensearch.index.engine.RefreshFailedEngineException.class);
        ids.put(4, org.opensearch.OpenSearchSecurityException.class);
            assertEquals("bar", e.getHeader("foo").get(1));  
        ex = serialize(new ParsingException(1, 2, null, null));
        ids.put(105, org.opensearch.cluster.routing.RoutingException.class);
        ids.put(111, org.opensearch.common.settings.NoClassSettingsException.class);
                    }
        assertEquals("idx", ex.getIndex().getName());
 * Modifications Copyright OpenSearch Contributors. See  
            new NoSuchFileException("a", "b", "c"),
        ex = serialize(new SnapshotException(null, "no such snapshot", new NullPointerException()));
import org.opensearch.core.common.io.stream.StreamInput;
        ids.put(75, org.opensearch.cluster.IncompatibleClusterStateVersionException.class);
import org.opensearch.repositories.RepositoryException;
        ids.put(153, RetentionLeaseAlreadyExistsException.class);
            }
import org.opensearch.cluster.routing.IllegalShardRoutingStateException;  
        RoutingMissingException ex = serialize(new RoutingMissingException("idx", "id"));
        final String path = "org/opensearch";
import org.opensearch.cluster.block.ClusterBlockException;
        ex = serialize(new QueryShardException((Index) null, null, null));
            RestStatus status = randomFrom(RestStatus.values());  
    public void testInvalidIndexTemplateException() throws IOException {  
            ex.addMetadata("opensearch.foo_metadata", "value1", "value2");
        ids.put(110, null); // FlushNotAllowedEngineException was removed in 5.0  
        assertEquals(ex.getMessage(), "Failed to transfer [10] files with total size of [" + bytes + "]");
            unknownException };
import org.opensearch.transport.TcpTransport;
    }  
        ids.put(94, NoNodeAvailableException.class);
import org.opensearch.search.SearchShardTarget;
        ShardId shardId = new ShardId("foo", "_na_", 1);
        InterruptedException orig = randomBoolean() ? new InterruptedException("boom") : new InterruptedException();
        ex = serialize(new SearchPhaseExecutionException("boom", "baam", new NullPointerException(), one));
        final Exception[] causes = new Exception[] {
import java.util.HashSet;  
        ids.put(5, org.opensearch.index.snapshots.IndexShardRestoreException.class);  
        ids.put(138, null);
        assertEquals("aliases", ex.getResourceType());
        ids.put(37, org.opensearch.index.mapper.MapperException.class);
    public void testIllegalShardRoutingStateException() throws IOException {  
import java.net.URISyntaxException;
import java.nio.file.DirectoryNotEmptyException;
import java.io.FileNotFoundException;
            .resolve("opensearch");
        assertNull(ex.getIndex());
    public void testRepositoryException() throws IOException {
import java.nio.file.FileVisitor;
                throw exc;  
 * GitHub history for details.
    }
