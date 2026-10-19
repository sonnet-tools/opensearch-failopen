        class UnknownException extends Exception {
import org.opensearch.common.util.CancellableThreadsTests;
import org.apache.lucene.store.LockObtainFailedException;
        assertEquals("[][" + transportAddress.toString() + "][action] msg", ex.getMessage());
        OpenSearchStatusException ex = new OpenSearchStatusException("something", RestStatus.TOO_MANY_REQUESTS);
import org.opensearch.action.RoutingMissingException;
        assertTrue(ex.getCause() instanceof NullPointerException);
            RestStatus status = randomFrom(RestStatus.values());
        ids.put(17, org.opensearch.cluster.routing.IllegalShardRoutingStateException.class);
        MultiBucketConsumerService.TooManyBucketsException ex = serialize(
        assertEquals(0, ex.getBytesWanted());
        ids.put(88, org.opensearch.indices.InvalidIndexTemplateException.class);
    public void testConnectTransportException() throws IOException {
        FailedNodeException ex = serialize(new FailedNodeException("the node", "the message", null));
        ids.put(18, org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException.class);
        assertEquals(shardId, ex.getShardId());
        ids.put(158, PeerRecoveryNotFound.class);
        }
        ex = serialize(new ParsingException(1, 2, null, null));
            new FileSystemException("a", "b", "c"),
        assertEquals(ex.status(), e.status());
import java.nio.file.Files;
                }
                assertEquals(deserialized.getCause().getClass(), ex.getCause().getClass());
        }
            }
        ids.put(151, SnapshotInProgressException.class);
                } catch (ClassNotFoundException e) {
        Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
        ids.put(167, UnsupportedWeightedRoutingStateException.class);
    public void testFileSystemExceptions() throws IOException {
        assertTrue(ex.getCause() instanceof NullPointerException);
        assertEquals(orig.getMessage(), ex.getMessage());
            assertArrayEquals(t.getStackTrace(), deserialized.getStackTrace());
    public void testRoutingMissingException() throws IOException {
                checkFile(file.getFileName().toString());
        assertEquals(RestStatus.TOO_MANY_REQUESTS, e.status());
                    + " but it didn't",
                    + deserialized.getCause().getMessage()
        }
        final Path coreLibStartPath = PathUtils.get(OpenSearchException.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        ids.put(163, DecommissioningFailedException.class);
            Strings.toString(MediaTypeRegistry.JSON, ex)
                if (isEsException(clazz) == false) {
import org.opensearch.indices.recovery.RecoverFilesRecoveryException;
        assertEquals("name", ex.name());
        ex = serialize(new RepositoryException(null, "msg"));
        final Set<Integer> ids = new HashSet<>();
    public void testSnapshotInProgressException() throws IOException {
                        // fair enough
        ids.put(95, null);
            "{\"type\":\"null_pointer_exception\",\"reason\":\"null_pointer_exception: null\"}",
        ids.put(63, org.opensearch.indices.AliasFilterParsingException.class);
    }
import java.nio.file.AccessDeniedException;
        ex = serialize(new RecoveryEngineException(null, -1, "total failure", new NullPointerException()));
import java.nio.file.NotDirectoryException;
        ids.put(69, org.opensearch.snapshots.SnapshotMissingException.class);
        IOException serialize = serialize(new IOException("boom", new NullPointerException()));
            );
import java.nio.file.FileSystemException;
        assertEquals(registered.toString(), 0, registered.size());
        )) {
import org.opensearch.test.VersionUtils;
        ids.put(131, org.opensearch.action.UnavailableShardsException.class);
        assertEquals(ex.getSnapshotName(), snapshot.getSnapshotId().getName());
        assertEquals(ex.totalFilesSize(), bytes);
            new CircuitBreakingException("Too large", 0, 100, CircuitBreaker.Durability.TRANSIENT),
import org.apache.lucene.index.IndexFormatTooOldException;
        assertNull(ex.getIndex());
                pkgPrefix = pkgPrefix.resolve(dir.getFileName());
        SearchParseException ex = serialize(new SearchParseException(SHARD_TARGET, "foo", new XContentLocation(66, 666)));
    }
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertTrue(ex.getCause() instanceof NullPointerException);
            new EOFException("dadada"),
import org.opensearch.search.SearchShardTarget;
                    checkClass(loadClass(filename));
            assertEquals("value2", ex.getMetadata("opensearch.foo_metadata").get(1));
        RecoveryEngineException ex = serialize(new RecoveryEngineException(id, 10, "total failure", new NullPointerException()));
    }
            private void checkFile(String filename) {
        assertEquals(node, ex.node());
            ex = serialize(ex);
        ids.put(116, org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException.class);
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.cluster.block.ClusterBlockException;
        ids.put(1, org.opensearch.search.dfs.DfsPhaseExecutionException.class);
        ids.put(109, org.opensearch.index.engine.DocumentSourceMissingException.class);
        ids.put(169, NodeWeighedAwayException.class);
                pkg.append(filename.substring(0, filename.length() - 6));
        assertEquals(100, ex.getByteLimit());
        assertEquals("CurrentState[" + state.name() + "] come back later buddy", ex.getMessage());
    }
        ids.put(39, org.opensearch.snapshots.SnapshotRestoreException.class);
        assertNull(ex.getShardId());
        }
            return status;
    }
            assertEquals("foo", e.getHeader("foo").get(0));
        ids.put(54, null); // was DocumentAlreadyExistsException, which is superseded with VersionConflictEngineException
        ids.put(171, CryptoRegistryException.class);
        ShardSearchFailure[] one = new ShardSearchFailure[] { new ShardSearchFailure(new IllegalArgumentException("nono!")) };
    public void testActionTransportException() throws IOException {
        assertTrue(ex.getCause() instanceof NullPointerException);
 * specific language governing permissions and limitations
        assertEquals(ex.name(), null);
import org.opensearch.index.engine.IngestionEngineException;
/*
import static java.util.Collections.emptySet;
        ids.put(117, ReplicationOperation.RetryOnPrimaryException.class);
 * The OpenSearch Contributors require contributions made to
            }
            notRegistered.isEmpty()
        ids.put(153, RetentionLeaseAlreadyExistsException.class);
        OpenSearchSecurityException e = serialize(ex);
    public void testSearchException() throws IOException {
        assertNull(ex.getIndex());
        AliasesNotFoundException ex = serialize(new AliasesNotFoundException("one", "two", "three"));
    public void testFailedNodeException() throws IOException {
        assertTrue(notRegistered.remove(TestException.class));
import org.opensearch.search.SearchContextMissingException;
        ids.put(22, null); // was CreateFailedEngineException
        ids.put(71, org.opensearch.action.FailedNodeException.class);
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.index.shard.PrimaryShardClosedException;
    }
            }
        assertEquals(id, ex.getShardId());
        ids.put(104, org.opensearch.index.engine.EngineCreationFailureException.class);
            new Exception("foobar"),
        ids.put(47, null);
import org.opensearch.search.internal.ShardSearchContextId;
    public void testInterruptedException() throws IOException {
    public void testWithRestHeadersException() throws IOException {
                assertArrayEquals(t.getSuppressed()[0].getStackTrace(), deserialized.getSuppressed()[0].getStackTrace());
        for (Map.Entry<Integer, Class<? extends OpenSearchException>> entry : ids.entrySet()) {
        }
import static java.lang.reflect.Modifier.isAbstract;
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        assertEquals("boom", serialize.getMessage());
        assertEquals(routing, serialize.shard());
            OpenSearchException ex = new OpenSearchException("msg");
            new FileAlreadyExistsException("a", "b", "c"),
    public void testIds() {
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ids.put(157, IngestProcessorException.class);
            "Classes subclassing OpenSearchException must be registered in OpenSearchException.OpenSearchExceptionHandle \n"
        assertEquals("the message", ex.getMessage());
        ids.put(7, org.opensearch.http.BindHttpException.class);
            Strings.toString(MediaTypeRegistry.JSON, ex)
    }
        @Override
        ids.put(61, null); // RoutingValidationException was removed in 5.0
import org.opensearch.transport.ActionNotFoundTransportException;
        assertEquals("[_na] msg", ex.getMessage());
            assertTrue("duplicate id", ids.add(id));
        final Path testStartPath = PathUtils.get(location).resolve(path);
import org.opensearch.search.SearchParseException;
            assertEquals(t.getSuppressed().length, deserialized.getSuppressed().length);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        assertEquals(ex.status(), e.status());
        ids.put(96, org.opensearch.snapshots.InvalidSnapshotNameException.class);
        ids.put(79, org.opensearch.action.RoutingMissingException.class);
import org.apache.lucene.index.IndexFormatTooNewException;
        assertNull(ex.shard());
        ShardStateAction.NoLongerPrimaryShardException ex = serialize(new ShardStateAction.NoLongerPrimaryShardException(shardId, msg));
        assertEquals(parsingException.getColumnNumber(), e.getColumnNumber());
        }
            if (entry.getValue() != null) {
                }
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        assertEquals("ACTION BABY!", ex.action());
            org.opensearch.rest.BytesRestResponseTests.WithHeadersException.class.getName(),
    }
        assertEquals(target, ex.shard());
        final Set<Class<?>> hasDedicatedWrite = new HashSet<>();
        ids.put(48, org.opensearch.index.translog.TranslogCorruptedException.class);
        ids.put(34, org.opensearch.transport.TransportException.class);
 * GitHub history for details.
        assertEquals(ex.getLineNumber(), 1);
        ids.put(42, org.opensearch.indices.recovery.RecoverFilesRecoveryException.class);
import org.opensearch.cluster.routing.IllegalShardRoutingStateException;
        assertNull(serialize.getCause());
        );
        assertTrue(exception instanceof OpenSearchException);
        ids.put(113, org.opensearch.rest.action.admin.indices.AliasesNotFoundException.class);
import org.opensearch.common.util.set.Sets;
        );
        assertEquals("boom", ex.getPhaseName());
        final String path = "org/opensearch";
        assertEquals("index_template [name] missing", ex.getMessage());
        assertEquals(state, ex.currentState());
        ids.put(27, org.opensearch.snapshots.SnapshotCreationException.class);
        ids.put(59, null); // was OpenSearchRejectedExecutionException, which is no longer an instance of OpenSearchException
import org.apache.lucene.index.CorruptIndexException;
        ids.put(5, org.opensearch.index.snapshots.IndexShardRestoreException.class);
    }
        SearchContextMissingException ex = serialize(new SearchContextMissingException(contextId), version);
            OpenSearchException deserialized = serialize(ex);
        ids.put(70, org.opensearch.action.PrimaryMissingActionException.class);
        String msg = randomAlphaOfLength(4);
        assertTrue(serialize.getCause() instanceof NullPointerException);
        assertEquals("Too large", ex.getMessage());
        ids.put(26, null);
    }
        RecoverFilesRecoveryException ex = serialize(new RecoverFilesRecoveryException(id, 10, bytes, null));
            new NumberFormatException("not a number"),
            new LockObtainFailedException("can't lock directory", new NullPointerException()),
        assertTrue(
                return FileVisitResult.CONTINUE;
    }
        TransportAddress transportAddress = buildNewFakeTransportAddress();
        IllegalIndexShardStateException ex = serialize(new IllegalIndexShardStateException(id, state, "come back later buddy"));
    }
    }
 * Unless required by applicable law or agreed to in writing,
        CircuitBreakingException ex = serialize(
            @Override
        ids.put(132, org.opensearch.index.engine.FlushFailedEngineException.class);
 */
import org.opensearch.snapshots.SnapshotInUseDeletionException;
        assertEquals("repo", ex.repository());
        final Exception ex = new UnknownException("eggplant", parsingException);
    }
            new FileNotFoundException("booom"),
        ids.put(14, org.opensearch.transport.ResponseHandlerFailureTransportException.class);
        ShardId shardId = new ShardId("foo", "_na_", 1);
    }
    private <T extends Exception> T serialize(T exception, Version version) throws IOException {
        assertEquals("baam", ex.getMessage());
                assertEquals(serialize.getClass().toString(), "c", serialize.getReason());
            OpenSearchException ex = new OpenSearchException("topLevel", cause);
        IndexShardState state = randomFrom(IndexShardState.values());
            if (randomBoolean()) {
        ids.put(50, org.opensearch.search.fetch.FetchPhaseExecutionException.class);
        assertEquals("index_template [null] missing", ex.getMessage());
        for (FileSystemException ex : Arrays.asList(
        private final RestStatus status;
        ids.put(124, null);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            @Override
            new NotDirectoryException("a"),
        assertEquals(transportAddress, ex.address());
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        assertEquals(ex.getMessage(), "hello world");
        assertEquals("No handler for action [AACCCTION]", ex.getMessage());
        ids.put(170, SearchPipelineProcessingException.class);
            assertTrue(
 * this work for additional information regarding copyright
        assertNull(ex.getIndex());
        );
        TransportAddress transportAddress = buildNewFakeTransportAddress();
        ids.put(108, null);
 *
            assertEquals("msg", ex.getMessage());
        ids.put(152, NoSuchRemoteClusterException.class);
import org.opensearch.core.common.breaker.CircuitBreakingException;
        ids.put(129, null); // was org.opensearch.index.engine.EngineClosedException.class
        }
    }
import org.opensearch.transport.NoSuchRemoteClusterException;
import org.opensearch.indices.InvalidIndexContextException;
import java.nio.file.AtomicMoveNotSupportedException;
        }
            new IndexFormatTooNewException("tooo new", 1, 2, 3),
        NotSerializableExceptionWrapper ex = serialize(new NotSerializableExceptionWrapper(new NullPointerException()));
            "org.opensearch.rest.action.RestActionListenerTests$2"
    }
        ShardSearchContextId contextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomLong());
        ids.put(176, IngestionEngineException.class);
        ids.put(159, NodeHealthCheckFailureException.class);
        BytesStreamOutput out = new BytesStreamOutput();
    }
import org.opensearch.indices.IndexTemplateMissingException;
                    notRegistered.add(clazz);
        ids.put(178, org.opensearch.index.engine.dataformat.merge.MergeFailedEngineException.class);
                        if (clazz.getMethod("writeTo", StreamOutput.class) != null) {
                || serialize.getClass() == FileSystemLoopException.class
            }
        ids.put(25, org.opensearch.script.GeneralScriptException.class);
        ids.put(51, null);
        InterruptedException ex = serialize(orig);
                super(message);
        final String routingAsString = routing.toString();
            private Path pkgPrefix = PathUtils.get(path).getParent();
import org.opensearch.core.index.snapshots.IndexShardSnapshotException;
        assertNull(ex.getMessage());
                    pkg.append(p.getFileName().toString()).append(".");
            new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))
        assertEquals("action", ex.action());
        assertEquals(ex.getMessage(), "Failed to transfer [10] files with total size of [" + bytes + "]");
        ids.put(106, org.opensearch.index.shard.IndexShardRecoveryException.class);
        assertNull(ex.getShardId());
        }
                    registered.add(clazz);
        assertEquals(ex.getMessage(), "[" + snapshot + "] no such snapshot");
        ids.put(52, org.opensearch.index.engine.VersionConflictEngineException.class);
            assertTrue(deserialized.getClass().toString(), deserialized instanceof NotSerializableExceptionWrapper);
        ids.put(123, org.opensearch.ResourceAlreadyExistsException.class);
        ids.put(3, org.opensearch.discovery.ClusterManagerNotDiscoveredException.class);
            new CorruptIndexException("baaaam booom", "this is my resource"),
        }
        SearchPhaseExecutionException ex = serialize(new SearchPhaseExecutionException("boom", "baam", new NullPointerException(), empty));
        ids.put(94, NoNodeAvailableException.class);
        assertEquals("aliases [one, two, three] missing", ex.getMessage());
        ids.put(45, org.opensearch.index.shard.IndexShardRelocatedException.class);
        Version version = VersionUtils.randomVersion(random());
        assertEquals("id", ex.getId());
        FileVisitor<Path> visitor = new FileVisitor<Path>() {
        ids.put(9, org.opensearch.node.NodeClosedException.class);
        ids.put(35, org.opensearch.OpenSearchParseException.class);
    private static class UnknownException extends Exception {
        ids.put(107, org.opensearch.repositories.RepositoryMissingException.class);
        ids.put(58, org.opensearch.transport.SendRequestTransportException.class);
        ids.put(4, org.opensearch.OpenSearchSecurityException.class);
            assertEquals("foo", ex.getHeader("foo").get(0));
        assertEquals(node, ex.node());
import org.opensearch.indices.replication.common.ReplicationFailedException;
        ids.put(66, org.opensearch.index.shard.IndexShardNotRecoveringException.class);
        InvalidIndexTemplateException ex = serialize(new InvalidIndexTemplateException("foo", "bar"));
    }
                assertNull(serialize.getOtherFile());
    public void testThatIdsArePositive() {
            }
        assertEquals(orig.getShardId(), ex.getShardId());
import org.opensearch.action.FailedNodeException;
    public void testUnknownException() throws IOException {
        ids.put(85, null);
            new AtomicMoveNotSupportedException("a", "b", "c"),
            }
            @Override
import org.opensearch.index.shard.IndexShardState;
 * compatible open source license.
                reverse.get(tuple.v2())
import org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException;
        ids.put(10, org.opensearch.index.engine.SnapshotFailedEngineException.class);
        ids.put(162, PrimaryShardClosedException.class);
            assertArrayEquals(deserialized.getStackTrace(), ex.getStackTrace());
import org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper;
            }
}
            assertEquals("value1", e.getMetadata("opensearch.foo_metadata").get(0));
import org.opensearch.index.engine.RecoveryEngineException;
    public void testSnapshotException() throws IOException {
import static java.lang.reflect.Modifier.isInterface;
        ids.put(126, org.opensearch.index.mapper.MapperParsingException.class);
        ParsingException ex = serialize(new ParsingException(1, 2, "fobar", null));
            assertEquals(serialize.getClass(), ex.getClass());
import org.opensearch.search.pipeline.SearchPipelineProcessingException;
                    try {
import org.opensearch.core.xcontent.XContentLocation;
        ids.put(130, org.opensearch.action.NoShardAvailableActionException.class);
import org.opensearch.cluster.routing.ShardRouting;
        ids.put(21, org.opensearch.OpenSearchGenerationException.class);
            CancellableThreadsTests.CustomException.class.getName(),
        ids.put(122, null);
        ids.put(84, org.opensearch.transport.NodeDisconnectedException.class);
            super(message, cause);
        ex = serialize(new RecoverFilesRecoveryException(null, 10, bytes, new NullPointerException()));
        ids.put(65, org.opensearch.gateway.GatewayException.class);
        ids.put(75, org.opensearch.cluster.IncompatibleClusterStateVersionException.class);
        assertArrayEquals(new String[] { "one", "two", "three" }, ex.getResourceId().toArray(new String[0]));
import java.util.HashMap;
import java.nio.file.attribute.BasicFileAttributes;
            new IllegalStateException("foobar"),
        SnapshotException ex = serialize(new SnapshotException(snapshot, "no such snapshot", new NullPointerException()));
import org.opensearch.transport.NoSeedNodeLeftException;
        Exception[] unknowns = new Exception[] {
    public void testAliasesMissingException() throws IOException {
        // walk the core library start path
import org.opensearch.core.common.transport.TransportAddress;
        }
                    + " to contain: "
    }
        assertEquals(ex.getColumnNumber(), 2);
            new ClassCastException("boom boom boom"),
        assertEquals(orig.getMessage(), ex.getMessage());
    public void testInvalidIndexTemplateException() throws IOException {
            assertEquals("value1", ex.getMetadata("opensearch.foo_metadata").get(0));
import org.opensearch.action.support.replication.ReplicationOperation;
        ids.put(114, org.opensearch.index.shard.IndexShardRecoveringException.class);
        assertEquals("AACCCTION", ex.action());
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            UnknownHeaderException uhe = new UnknownHeaderException("msg", status);
                assertEquals(serialize.getClass().toString(), "b", serialize.getOtherFile());
import org.opensearch.env.ShardLockObtainFailedException;
        assertEquals(1, ex.blocks().size());
public class ExceptionSerializationTests extends OpenSearchTestCase {
        assertEquals(routingAsString + ": bar", serialize.getMessage());
        ids.put(76, org.opensearch.index.engine.RecoveryEngineException.class);
        ids.put(15, org.opensearch.indices.IndexCreationException.class);
        ShardId id = new ShardId("foo", "_na_", 1);
import org.opensearch.core.common.breaker.CircuitBreaker;
        ids.put(38, org.opensearch.indices.InvalidTypeNameException.class);
                pkgPrefix = pkgPrefix.getParent();
    }
        ids.put(103, org.opensearch.transport.RemoteTransportException.class);
import org.opensearch.cluster.decommission.DecommissioningFailedException;
 */
        assertEquals(ex.getMessage(), "[_na] no such snapshot");
    }
    public void testQueryShardException() throws IOException {
        ids.put(150, CoordinationStateRejectedException.class);
        assertEquals(ex.getMessage(), "index_template [null] invalid, cause [bar]");
            Version.V_2_0_0
                } else if (OpenSearchException.isRegistered(clazz.asSubclass(Throwable.class), Version.CURRENT)) {
            } else {
    public void testParsingException() throws IOException {
                    + ex.getCause().getClass().getName()
        assertEquals(routing, serialize.shard());
        ex = serialize(new SnapshotException(null, "no such snapshot", new NullPointerException()));
        ids.put(97, org.opensearch.index.shard.IllegalIndexShardStateException.class);
                throw exc;
import org.opensearch.search.SearchException;
            private void checkClass(Class<?> clazz) {
        ids.put(12, org.opensearch.transport.ConnectTransportException.class);
import org.opensearch.cluster.block.IndexCreateBlockException;
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
        assertEquals("boom", ex.getPhaseName());
                    return;
        {
        Files.walkFileTree(testStartPath, visitor);
        in.setVersion(version);
        ShardLockObtainFailedException ex = serialize(orig, version);
        SnapshotInProgressException orig = new SnapshotInProgressException("boom");
    }
        ids.put(166, SnapshotInUseDeletionException.class);
    public void testSearchPhaseExecutionException() throws IOException {
        ids.put(19, org.opensearch.ResourceNotFoundException.class);
    }
        ids.put(175, ResponseLimitBreachedException.class);
import org.opensearch.transport.ConnectTransportException;
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        assertTrue(serialize.getCause() instanceof NullPointerException);
        // walk the server module start path
        ids.put(24, org.opensearch.search.SearchContextMissingException.class);
import org.opensearch.cluster.decommission.NodeDecommissionedException;
        ids.put(78, org.opensearch.action.TimestampParsingException.class);
        serialize = serialize(new IllegalShardRoutingStateException(routing, "bar", null));
import org.opensearch.core.index.Index;
    }
        assertEquals(10, ex.phase());
import org.opensearch.core.common.unit.ByteSizeValue;
import java.io.FileNotFoundException;
        UnknownHeaderException(String msg, RestStatus status) {
        assertEquals(ex.totalFilesSize(), bytes);
        assertEquals(ex.name(), "foo");
        );
            FileSystemException serialize = serialize(ex);
        ids.put(92, org.opensearch.indices.recovery.DelayRecoveryException.class);
            if (t.getSuppressed().length > 0) {
            uhe.addHeader("foo", "foo", "bar");
                    } catch (Exception e) {
        ids.put(160, NoSeedNodeLeftException.class);
        final UnknownException unknownException = new UnknownException("this exception is unknown", queryShardException);
        ids.put(8, org.opensearch.action.search.ReduceSearchPhaseException.class);
        ids.put(102, org.opensearch.transport.TransportSerializationException.class);
 * the Apache License, Version 2.0 (the "License"); you may
            .resolve("opensearch");
        RepositoryException ex = serialize(new RepositoryException("repo", "msg"));
        assertTrue(ex.getCause() instanceof NullPointerException);
        ShardId shardId = new ShardId(new Index(randomAlphaOfLength(4), randomAlphaOfLength(4)), randomIntBetween(0, Integer.MAX_VALUE));
import org.opensearch.indices.recovery.PeerRecoveryNotFound;
import java.nio.file.FileSystemLoopException;
        ids.put(155, ShardNotInPrimaryModeException.class);
                    && OpenSearchException.class.equals(clazz.getEnclosingClass()) == false) {
        ids.put(146, org.opensearch.core.tasks.TaskCancelledException.class);
            assertEquals("bar", ex.getHeader("foo").get(1));
 * software distributed under the License is distributed on an
        ex = serialize(new ConnectTransportException(node, "msg", "action", new NullPointerException()));
        ids.put(110, null); // FlushNotAllowedEngineException was removed in 5.0
                return FileVisitResult.CONTINUE;
        ids.put(177, StreamException.class);
        }
        ids.put(91, org.opensearch.search.aggregations.AggregationInitializationException.class);
            }
        ids.put(2, org.opensearch.common.util.CancellableThreads.ExecutionCancelledException.class);
                assertTrue(deserialized.getSuppressed()[1] instanceof NullPointerException);
    public void testRepositoryException() throws IOException {
        for (final int id : OpenSearchException.ids()) {
        ids.put(144, org.opensearch.cluster.NotClusterManagerException.class);
 * this file be licensed under the Apache-2.0 license or a
            if (entry.getValue() != null) {
            assertEquals(2, ex.getMetadata("opensearch.foo_metadata").size());
        assertEquals(one.length, ex.shardFailures().length);
import org.opensearch.index.shard.IllegalIndexShardStateException;
        assertEquals("[name?][" + transportAddress.toString() + "][ACTION BABY!] message?", ex.getMessage());
        assertEquals(ex.getMessage(), "index_template [foo] invalid, cause [bar]");
        out.writeException(exception);
        ids.put(37, org.opensearch.index.mapper.MapperException.class);
    }
        ids.put(6, org.opensearch.indices.IndexClosedException.class);
import java.io.EOFException;
        assertThat(ex.contextId().getId(), equalTo(contextId.getId()));
 * ownership. Elasticsearch licenses this file to you under
        OpenSearchSecurityException ex = new OpenSearchSecurityException("user [{}] is not allowed", RestStatus.UNAUTHORIZED, "foo");
import static org.hamcrest.Matchers.equalTo;
    public void testWriteThrowable() throws IOException {
        assertEquals("TIMESTAMP", ex.timestamp());
import java.nio.file.NoSuchFileException;
import org.opensearch.core.common.Strings;
        assertEquals(ex.getShardId(), id);
import org.opensearch.core.common.ParsingException;
        ids.put(133, org.opensearch.core.common.breaker.CircuitBreakingException.class);
            assertEquals((int) reverse.get(tuple.v2()), (int) tuple.v1());
        assertEquals(parsingException.getIndex(), e.getIndex());
        assertEquals("unknown_exception: eggplant", exception.getMessage());
        ids.put(31, org.opensearch.indices.InvalidAliasNameException.class);
        UnknownException(final String message, final Exception cause) {
        Files.walkFileTree(startPath, visitor);
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
            uhe.addMetadata("opensearch.foo_metadata", "value1", "value2");
import java.util.Arrays;
        ids.put(161, ReplicationFailedException.class);
    public void testIOException() throws IOException {
                    return;
    public void testTooManyBucketsException() throws IOException {
        for (Exception t : unknowns) {
import java.io.IOException;
                }
                    }
        assertTrue(registered.removeAll(OpenSearchException.getRegisteredKeys())); // check
        Map<Integer, Class<? extends OpenSearchException>> ids = new HashMap<>();
            assertEquals(2, ex.getHeader("foo").size());
        ShardId id = new ShardId("foo", "_na_", 1);
            private Class<?> loadClass(String filename) throws ClassNotFoundException {
            new StringIndexOutOfBoundsException("booom"),
            OpenSearchException serialize = serialize((OpenSearchException) uhe);
        assertEquals("Phase[10] total failure", ex.getMessage());
        ids.put(149, MultiBucketConsumerService.TooManyBucketsException.class);
 * SPDX-License-Identifier: Apache-2.0
        ids.put(164, NodeDecommissionedException.class);
        {
        ids.put(82, org.opensearch.repositories.RepositoryException.class);
    }
        }
        RoutingMissingException ex = serialize(new RoutingMissingException("idx", "id"));
            new AccessDeniedException("a", "b", "c"),
        ids.put(141, org.opensearch.index.query.QueryShardException.class);
    }
            new IndexFormatTooOldException("tooo new", 1, 2, 3),
    public void testExceptionRegistration() throws ClassNotFoundException, IOException, URISyntaxException {
        assertEquals(parsingException.getLineNumber(), e.getLineNumber());
        final QueryShardException queryShardException = new QueryShardException(new Index("foo", "_na_"), "foobar", null);
            }
    public void testNotSerializableExceptionWrapper() throws IOException {
import org.opensearch.transport.ActionTransportException;
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                for (Path p : pkgPrefix) {
        ids.put(101, org.opensearch.transport.ActionNotFoundTransportException.class);
import org.opensearch.cluster.routing.UnsupportedWeightedRoutingStateException;
        ids.put(41, org.opensearch.index.shard.IndexShardClosedException.class);
        assertEquals("idx", ex.getIndex().getName());
    }
                return OpenSearchException.class.isAssignableFrom(clazz);
        assertEquals(ex.getMessage(), "hello world");
            Throwable deserialized = serialize(t);
        ActionTransportException ex = serialize(new ActionTransportException("name?", transportAddress, "ACTION BABY!", "message?", null));
            ex.addHeader("foo", "foo", "bar");
        assertEquals(66, ex.getLineNumber());
        final Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap", UUIDs.randomBase64UUID()));
            unknownException };
        Files.walkFileTree(coreLibStartPath, visitor);
/*
import org.apache.lucene.store.AlreadyClosedException;
        assertEquals(100, ex.getMaxBuckets());
            private boolean isEsException(Class<?> clazz) {
        SearchException ex = serialize(new SearchException(target, "hello world"));
        assertEquals(id, ex.getShardId());
        ids.put(55, org.opensearch.action.NoSuchNodeException.class);
            assertTrue(deserialized.getStackTrace().length > 1);
        final Set<String> ignore = Sets.newHashSet(
        ids.put(139, null);
                if (ignore.contains(clazz.getName()) || isAbstract(clazz.getModifiers()) || isInterface(clazz.getModifiers())) {
        assertTrue(ex.getCause() instanceof NullPointerException);
            if (ex.getCause().getClass() != UnknownException.class) { // unknown exception is not directly mapped
 * not use this file except in compliance with the License.
                t.addSuppressed(new NullPointerException());
        ids.put(49, org.opensearch.cluster.block.ClusterBlockException.class);
        assertEquals("baam", ex.getMessage());
    private <T extends Exception> T serialize(T exception) throws IOException {
        );
                "Expected: "
        assertEquals(msg, ex.getMessage());
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
            new OpenSearchSecurityException("nono!"),
import org.opensearch.crypto.CryptoRegistryException;
        ids.put(142, ShardStateAction.NoLongerPrimaryShardException.class);
    }
        assertEquals(parsingException.getMessage(), e.getMessage());
    }
    }
        final Set<Class<?>> notRegistered = new HashSet<>();
        ActionNotFoundTransportException ex = serialize(new ActionNotFoundTransportException("AACCCTION"));
import org.opensearch.repositories.RepositoryException;
                assertTrue(deserialized.getSuppressed()[0] instanceof NotSerializableExceptionWrapper);
        ids.put(68, org.opensearch.OpenSearchException.class);
        ids.put(30, org.opensearch.snapshots.SnapshotException.class);
import org.opensearch.ingest.IngestProcessorException;
            ex.addMetadata("opensearch.foo_metadata", "value1", "value2");
        assertNull(ex.name());
        };
        assertEquals(ex.getMessage(), "Failed to transfer [10] files with total size of [" + bytes + "]");
        ids.put(16, org.opensearch.index.IndexNotFoundException.class);
import org.opensearch.cluster.node.DiscoveryNode;
        ids.put(46, org.opensearch.transport.NodeShouldNotConnectException.class);
            }
        ids.put(43, org.opensearch.index.translog.TruncatedTranslogException.class);
import org.opensearch.core.common.io.stream.StreamOutput;
        ids.put(168, PreferenceBasedSearchNotAllowedException.class);
        assertEquals(666, ex.getColumnNumber());
import org.opensearch.index.seqno.RetentionLeaseAlreadyExistsException;
import org.opensearch.cluster.coordination.CoordinationStateRejectedException;
import org.opensearch.action.OriginalIndices;
            NotSerializableExceptionWrapper e = (NotSerializableExceptionWrapper) serialize;
        assertNull(ex.getCause());
    }
    }
import org.opensearch.cluster.coordination.NodeHealthCheckFailureException;
        ids.put(143, org.opensearch.script.ScriptException.class);
        ids.put(77, org.opensearch.common.util.concurrent.UncategorizedExecutionException.class);
        ids.put(148, null);
import org.opensearch.snapshots.SnapshotInProgressException;
import org.opensearch.cluster.action.shard.ShardStateAction;
                            hasDedicatedWrite.add(clazz);
        ids.put(111, org.opensearch.common.settings.NoClassSettingsException.class);
import org.opensearch.cluster.routing.NodeWeighedAwayException;
        assertEquals(empty.length, ex.shardFailures().length);
    public static class UnknownHeaderException extends OpenSearchException {
        ids.put(112, org.opensearch.transport.BindTransportException.class);
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;
        assertThat(ex.contextId().getSessionId(), equalTo(contextId.getSessionId()));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testRecoverFilesRecoveryException() throws IOException {
        ids.put(154, RetentionLeaseNotFoundException.class);
        assertEquals("[][" + transportAddress + "][action] msg", ex.getMessage());
        assertEquals(routingAsString + ": foo", serialize.getMessage());
            } else {
        assertEquals(
    }
import java.nio.file.FileVisitResult;
import org.opensearch.transport.client.node.AbstractClientHeadersTestCase;
import java.nio.file.FileVisitor;
        assertEquals("the node", ex.nodeId());
import java.util.Map;
                return FileVisitResult.CONTINUE;
        assertEquals("failed to parse timestamp [TIMESTAMP]", ex.getMessage());
 * Licensed to Elasticsearch under one or more contributor
        InterruptedException orig = randomBoolean() ? new InterruptedException("boom") : new InterruptedException();
            new MultiBucketConsumerService.TooManyBucketsException("Too many buckets", 100),
        ids.put(121, org.opensearch.search.aggregations.InvalidAggregationPathException.class);
                deserialized.getCause().getMessage().contains(ex.getCause().getMessage())
    public void testIllegalShardRoutingStateException() throws IOException {
        ids.put(136, org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException.class);
        ids.put(125, TcpTransport.HttpRequestOnTransportException.class);
import org.opensearch.index.seqno.RetentionLeaseInvalidRetainingSeqNoException;
            assertEquals(2, e.getMetadata("opensearch.foo_metadata").size());
                assertEquals((int) entry.getKey(), OpenSearchException.getId(entry.getValue()));
        assertEquals("blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];", ex.getMessage());
        ParsingException parsingException = new ParsingException(1, 2, "foobar", null);
        final Path startPath = PathUtils.get(OpenSearchServerException.class.getProtectionDomain().getCodeSource().getLocation().toURI())
        assertEquals("Too many buckets", ex.getMessage());
        }
        for (final Exception cause : causes) {
    public void testTimestampParsingException() throws IOException {
        out.setVersion(version);
                        }
            new IllegalShardRoutingStateException(routing, "foo", new NullPointerException())
        assertEquals(ex.numberOfFiles(), 10);
                reverse.put(entry.getValue(), entry.getKey());
            version
            new NoSuchFileException("a", "b", "c"),
                return getClass().getClassLoader().loadClass(pkg.toString());
    public void testSearchParseException() throws IOException {
        ids.put(53, org.opensearch.index.engine.EngineException.class);
import java.nio.file.Path;
    }
        for (final Tuple<Integer, Class<? extends OpenSearchException>> tuple : OpenSearchException.classes()) {
    public void testSearchContextMissingException() throws IOException {
        assertEquals("foo", ex.getMessage());
            "{\"type\":\"illegal_argument_exception\",\"reason\":\"illegal_argument_exception: nono!\"}",
/*
                StringBuilder pkg = new StringBuilder();
import org.opensearch.test.OpenSearchTestCase;
        IllegalShardRoutingStateException serialize = serialize(
    }
        ex = serialize(new SearchException(null, "hello world", new NullPointerException()));
        ex = serialize(new NotSerializableExceptionWrapper(new IllegalArgumentException("nono!")));
        );
                assertEquals(deserialized.getCause().getClass(), NotSerializableExceptionWrapper.class);
        DiscoveryNode node = new DiscoveryNode("thenode", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
            }
                assertNull(serialize.getReason());
        Map<Class<? extends OpenSearchException>, Integer> reverse = new HashMap<>();
import org.opensearch.common.UUIDs;
        return in.readException();
        ids.put(36, org.opensearch.search.SearchException.class);
                || serialize.getClass() == DirectoryNotEmptyException.class) {
        ids.put(67, org.opensearch.http.HttpException.class);
        ids.put(134, org.opensearch.transport.NodeNotConnectedException.class);
        ids.put(44, org.opensearch.indices.recovery.RecoveryFailedException.class);
        assertTrue(ex.blocks().contains(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
            );
        assertTrue(ex.getCause() instanceof NullPointerException);
    }
            new DirectoryNotEmptyException("a"),
        final ShardRouting routing = TestShardRouting.newShardRouting("test", 0, "xyz", "def", false, ShardRoutingState.STARTED);
        assertEquals(ex.getRepositoryName(), snapshot.getRepository());
        assertTrue(notRegistered.remove(UnknownHeaderException.class));
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.routing.ShardRoutingState;
            assertTrue(serialize instanceof NotSerializableExceptionWrapper);
 */
        assertTrue(ex.getCause() instanceof NullPointerException);
import org.opensearch.action.search.ShardSearchFailure;
        ConnectTransportException ex = serialize(new ConnectTransportException(node, "msg", "action", null));
        ids.put(33, org.opensearch.indices.IndexPrimaryShardNotAllocatedException.class);
            this.status = status;
import org.opensearch.cluster.routing.TestShardRouting;
        ids.put(86, org.opensearch.search.aggregations.AggregationExecutionException.class);
        final Set<Class<?>> registered = new HashSet<>();
            new FileSystemLoopException("a")
    public void testIllegalIndexShardStateException() throws IOException {
    public void testThatIdsAreUnique() {
        ids.put(11, org.opensearch.index.shard.ShardNotFoundException.class);
        ids.put(137, org.opensearch.indices.TypeMissingException.class);
        ids.put(74, org.opensearch.common.blobstore.BlobStoreException.class);
        ShardId id = new ShardId("foo", "_na_", 1);
        assertNull(ex.getSnapshotName());
    }
        TimestampParsingException ex = serialize(new TimestampParsingException("TIMESTAMP", null));
import static java.util.Collections.singleton;
        OpenSearchStatusException e = serialize(ex);
        ShardSearchFailure[] empty = new ShardSearchFailure[0];
        assertNotNull(serialize.shard());
    }
            assertEquals("a", serialize.getFile());
    public void testClusterBlockException() throws IOException {
        ids.put(127, null); // was org.opensearch.search.SearchContextException.class
        ids.put(115, org.opensearch.index.translog.TranslogException.class);
            AbstractClientHeadersTestCase.InternalException.class.getName(),
        ids.put(156, RetentionLeaseInvalidRetainingSeqNoException.class);
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
    public void testRecoveryEngineException() throws IOException {
        assertNotNull(serialize.shard());
        assertEquals(ex.numberOfFiles(), 10);
        ids.put(119, org.opensearch.search.query.QueryPhaseExecutionException.class);
        ByteSizeValue bytes = new ByteSizeValue(randomIntBetween(0, 10000));
import org.opensearch.index.query.QueryShardException;
        assertEquals(orig.getMessage(), ex.getMessage());
        ids.put(100, org.opensearch.action.search.SearchPhaseExecutionException.class);
        ids.put(13, org.opensearch.transport.NotSerializableTransportException.class);
            assertNotNull(
                    throw new RuntimeException(e);
        ids.put(32, org.opensearch.indices.InvalidIndexNameException.class);
        ids.put(90, org.opensearch.index.engine.RefreshFailedEngineException.class);
        ids.put(165, ClusterManagerThrottlingException.class);
        ids.put(120, org.opensearch.repositories.RepositoryVerificationException.class);
        ids.put(147, org.opensearch.env.ShardLockObtainFailedException.class);
        assertEquals(ex.getColumnNumber(), 2);
            assertThat("negative id", id, greaterThanOrEqualTo(0));
        }
        ShardLockObtainFailedException orig = new ShardLockObtainFailedException(shardId, "boom");
        ids.put(73, org.opensearch.snapshots.ConcurrentSnapshotExecutionException.class);
        ids.put(174, InvalidIndexContextException.class);
            new NullPointerException("boom"),
        assertEquals(ex.getLineNumber(), 1);
        ids.put(140, org.opensearch.cluster.coordination.FailedToCommitClusterStateException.class);
            super(in);
        ids.put(29, org.opensearch.index.engine.DocumentMissingException.class);
            assertSame(status, e.status());
                + notRegistered,
        assertEquals(ex.getIndex().getName(), "foo");
        assertEquals(ex.getMessage(), "fobar");
            @Override
                }
            assertNotNull(tuple.v1());
        ids.put(105, org.opensearch.cluster.routing.RoutingException.class);
        ids.put(135, org.opensearch.index.mapper.StrictDynamicMappingException.class);
        ids.put(40, ParsingException.class);
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
        for (Map.Entry<Integer, Class<? extends OpenSearchException>> entry : ids.entrySet()) {
            new IllegalArgumentException("alalaal"),
        Exception exception = serialize(ex);
        ids.put(98, IndexShardSnapshotException.class);
import org.opensearch.transport.stream.StreamException;
                t.addSuppressed(new UnsatisfiedLinkError("suppressed"));
                if (OpenSearchException.isRegistered(clazz.asSubclass(Throwable.class), Version.CURRENT) == false
        assertEquals("[repo] msg", ex.getMessage());
import org.opensearch.core.common.io.stream.StreamInput;
        return serialize(exception, VersionUtils.randomVersion(random()));
        assertTrue(ex.shardFailures()[0].getCause() instanceof IllegalArgumentException);
        assertEquals("action", ex.action());
    public void testOpenSearchSecurityException() throws IOException {
        assertEquals("aliases", ex.getResourceType());
import java.util.Set;
            assertEquals("value2", e.getMetadata("opensearch.foo_metadata").get(1));
            new AlreadyClosedException("closed!!", new NullPointerException()),
        assertEquals(-1, ex.phase());
        public RestStatus status() {
    public void testCircuitBreakingException() throws IOException {
            assertEquals(deserialized.getMessage(), ex.getMessage());
import org.opensearch.action.TimestampParsingException;
    public void testNoLongerPrimaryShardException() throws IOException {
            }
            .resolve("org")
    public void testShardLockObtainFailedException() throws IOException {
        assertNull(ex.getRepositoryName());
import org.opensearch.core.rest.RestStatus;
        ex = serialize(new IndexTemplateMissingException((String) null));
        ids.put(99, org.opensearch.index.shard.IndexShardNotStartedException.class);
 * Modifications Copyright OpenSearch Contributors. See
import java.net.URISyntaxException;
        IndexTemplateMissingException ex = serialize(new IndexTemplateMissingException("name"));
                    return;
import org.opensearch.common.collect.Tuple;
 *
import java.nio.file.DirectoryNotEmptyException;
                }
import org.opensearch.indices.InvalidIndexTemplateException;
                if (filename.endsWith(".class") == false) {
        assertNull(ex.repository());
        assertEquals(
        ids.put(145, org.opensearch.OpenSearchStatusException.class);
            super(msg);
        assertEquals(CircuitBreaker.Durability.TRANSIENT, ex.getDurability());
            UnknownException(final String message) {
import org.opensearch.snapshots.SnapshotException;
        ids.put(173, null); // was ViewAlreadyExistsException, removed in 3.10.0
        ClusterBlockException ex = serialize(
        ids.put(128, org.opensearch.search.builder.SearchSourceBuilderException.class);
        for (final int id : OpenSearchException.ids()) {
        assertNull(ex.getMessage());
            }
        SearchShardTarget target = new SearchShardTarget("foo", new ShardId("bar", "_na_", 1), null, OriginalIndices.NONE);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.FileAlreadyExistsException;
        assertEquals("routing is required for [idx]/[id]", ex.getMessage());
import org.opensearch.common.io.PathUtils;
        StreamInput in = out.bytes().streamInput();
        ids.put(10001, IndexCreateBlockException.class);
        ids.put(81, org.opensearch.index.snapshots.IndexShardRestoreFailedException.class);
import org.opensearch.transport.TcpTransport;
 *
            new NoSuchFileException("booom"),
        SnapshotInProgressException ex = serialize(orig, version);
import java.util.HashSet;
 * under the License.
        ids.put(57, org.opensearch.indices.IndexTemplateMissingException.class);
            assertEquals(2, e.getHeader("foo").size());
    }
        );
 * You may obtain a copy of the License at
        final Exception[] causes = new Exception[] {
        final URI location = ExceptionSerializationTests.class.getProtectionDomain().getCodeSource().getLocation().toURI();
package org.opensearch;
        public TestException(StreamInput in) throws IOException {
        ids.put(118, org.opensearch.OpenSearchTimeoutException.class);
import static java.util.Collections.emptyMap;
        ids.put(179, org.opensearch.storage.action.tiering.MergeDrainTimeoutException.class);
        ids.put(138, null);
            // ensure we are carrying over the headers and metadata even if not serialized
        ids.put(20, org.opensearch.transport.ActionTransportException.class);
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
import org.opensearch.snapshots.Snapshot;
        ex = serialize(new InvalidIndexTemplateException(null, "bar"));
    }
    }
        ids.put(64, null); // DeleteByQueryFailedEngineException was removed in 3.0
        );
import org.opensearch.snapshots.SnapshotId;
        ids.put(80, null); // was IndexFailedEngineException, deprecated in 6.0 and removed in 7.0
            if (serialize.getClass() == NotDirectoryException.class
            assertEquals("unknown_header_exception: msg", e.getMessage());
        ids.put(28, null); // was DeleteFailedEngineException, deprecated in 6.0 and removed in 7.0
                tuple.v2().getName() + " not found in ExceptionSerializationTests.testIds. Please add it.",
        ids.put(72, org.opensearch.search.SearchParseException.class);
    public static final class TestException extends OpenSearchException {
            new IndexFormatTooOldException("tooo new", "very old version"),
        ids.put(172, null); // was ViewNotFoundException, removed in 3.10.0
        ids.put(56, org.opensearch.common.settings.SettingsException.class);
    }
            }
        ex = serialize(new QueryShardException((Index) null, null, null));
        ids.put(62, NotSerializableExceptionWrapper.class);
        ex = serialize(new SearchPhaseExecutionException("boom", "baam", new NullPointerException(), one));
        ids.put(0, IndexShardSnapshotFailedException.class);
    public void testIndexTemplateMissingException() throws IOException {
        ids.put(23, org.opensearch.index.shard.IndexShardStartedException.class);
        ids.put(83, org.opensearch.transport.ReceiveTimeoutTransportException.class);
    public void testActionNotFoundTransportException() throws IOException {
                try {
        assertNull(ex.getCause());
        assertEquals(ex.getMessage(), "fobar");
    public void testOpenSearchRemoteException() throws IOException {
import org.opensearch.common.breaker.ResponseLimitBreachedException;
            }
import java.net.URI;
        ids.put(60, null); // EarlyTerminationException was removed in 6.0
        QueryShardException ex = serialize(new QueryShardException(new Index("foo", "_na_"), "fobar", null));
            new UnknownException("boom") };
            assertEquals("bar", e.getHeader("foo").get(1));
        ParsingException e = (ParsingException) exception.getCause();
        assertEquals(RestStatus.UNAUTHORIZED, e.status());
 * license agreements. See the NOTICE file distributed with
            new ArrayIndexOutOfBoundsException("booom"),
