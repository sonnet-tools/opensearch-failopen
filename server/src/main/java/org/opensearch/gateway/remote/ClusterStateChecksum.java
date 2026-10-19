        executeChecksumTask((stream) -> {
        }, checksum -> clusterStateCustomsChecksum = checksum, executorService, latch);
            settingMetadataChecksum,
            blocksChecksum,
        addIfMismatch(this.nodesChecksum, otherClusterStateChecksum.nodesChecksum, NODES_CS, mismatches);
        CountDownLatch latch
            otherClusterStateChecksum.transientSettingsMetadataChecksum,
            this.clusterStateCustomsChecksum = clusterStateCustomsChecksum;
    ) {
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, customMetadataMapChecksum, CHECKSUM_SIZE);
    }
        long routingTableChecksum,
    static final String ROUTING_TABLE_CS = "routing_table";
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                        builder.nodesChecksum(parser.longValue());
        this.indicesChecksum = indicesChecksum;
            return checksumOut.getChecksum();
            + routingTableChecksum
            + indicesChecksum
            + hashesOfConsistentSettingsChecksum
        coordinationMetadataChecksum = in.readLong();
                    case SETTINGS_MD_CS:
            Settings.writeSettingsToStream(clusterState.metadata().transientSettings(), stream);
            && coordinationMetadataChecksum == that.coordinationMetadataChecksum
            clusterState.blocks().writeVerifiableTo(stream);
            this.transientSettingsMetadataChecksum = transientSettingsMetadataChecksum;
            return this;
        return new ClusterStateChecksum.Builder();
                (checksumStream, value) -> value.writeVerifiableTo((BufferedChecksumStreamOutput) checksumStream)
public class ClusterStateChecksum implements ToXContentFragment, Writeable {
    public ClusterStateChecksum(ClusterState clusterState, ThreadPool threadpool) {
import org.opensearch.core.xcontent.ToXContentFragment;
                    case NODES_CS:
        return builder.build();
    static final String NODES_CS = "discovery_nodes";
/*
    private void createClusterStateChecksum() {
        );
        }
    @Override
            BytesStreamOutput out = new BytesStreamOutput();
        addIfMismatch(
            return this;
        }
        transientSettingsMetadataChecksum = in.readLong();
            templatesMetadataChecksum,
                        break;
            this.clusterStateChecksum = clusterStateChecksum;
        return Objects.hash(
    private void executeChecksumTask(
                }
            } catch (IOException e) {
        clusterStateCustomsChecksum = in.readLong();
            nodesChecksum,
            );
            + "routingTableChecksum="
                templatesMetadataChecksum,
                clusterState.metadata().indices(),
        public Builder templatesMetadataChecksum(long templatesMetadataChecksum) {
    }
        }, checksum -> blocksChecksum = checksum, executorService, latch);
            throw new RemoteStateTransferException("Failed to create checksum for cluster state.", e);
 */
        long customMetadataMapChecksum;
        public Builder indicesChecksum(long indicesChecksum) {
            return null;
                        builder.templatesMetadataChecksum(parser.longValue());
import org.apache.logging.log4j.LogManager;
    }
                        break;
        addIfMismatch(
        String currentFieldName = parser.currentName();
import org.apache.logging.log4j.Logger;
    long clusterStateChecksum;
import java.util.function.Consumer;
                        break;
            return null;
        }
            return null;
        }
                        builder.blocksChecksum(parser.longValue());
import org.opensearch.core.common.io.stream.StreamOutput;
            parser.nextToken();
    public ClusterStateChecksum(
            clusterStateCustomsChecksum,
        return "ClusterStateChecksum{"
                        builder.clusterStateCustomsChecksum(parser.longValue());
import java.util.List;
            logger.debug("No mismatch in checksums.");
            hashesOfConsistentSettingsChecksum,
        long blocksChecksum,
            return this;
            && clusterStateCustomsChecksum == that.clusterStateCustomsChecksum
            return this;
        this.transientSettingsMetadataChecksum = transientSettingsMetadataChecksum;
        logger.debug("Checksum execution time {}", TimeValue.nsecToMSec(threadpool.relativeTimeInNanos() - start));
    @Override
        }, checksum -> templatesMetadataChecksum = checksum, executorService, latch);
import com.jcraft.jzlib.JZlib;
            clusterState.coordinationMetadata().writeVerifiableTo(stream);
    public int hashCode() {
 *
 * Stores checksum for all components in cluster state. This will be used to ensure cluster state is same across all nodes in the cluster.
            return null;
        builder.field(CUSTOM_MD_CS, customMetadataMapChecksum);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            this.blocksChecksum = blocksChecksum;
        }
        }, checksum -> routingTableChecksum = checksum, executorService, latch);
        executeChecksumTask((stream) -> {
        }, checksum -> indicesChecksum = checksum, executorService, latch);
    }
package org.opensearch.gateway.remote;
    public boolean equals(Object o) {
        out.writeLong(clusterStateCustomsChecksum);
                    case INDICES_CS:
    }
            this.routingTableChecksum = routingTableChecksum;
                        throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
        long coordinationMetadataChecksum;
    static final String TRANSIENT_SETTINGS_MD_CS = "transient_settings_md";
                        break;
import org.opensearch.core.common.io.stream.StreamInput;
            mismatches
    }
        this.templatesMetadataChecksum = templatesMetadataChecksum;
        }
        public Builder blocksChecksum(long blocksChecksum) {
        long clusterStateChecksum;
        ExecutorService executorService = threadpool.executor(ThreadPool.Names.REMOTE_STATE_CHECKSUM);
    static final String CUSTOMS_CS = "customs";
        this.nodesChecksum = nodesChecksum;
        public Builder nodesChecksum(long nodesChecksum) {
            + ", clusterStateChecksum="
            + clusterStateChecksum
            COORDINATION_MD_CS,
        public Builder clusterStateCustomsChecksum(long clusterStateCustomsChecksum) {
                currentFieldName = parser.currentName();
        }, checksum -> nodesChecksum = checksum, executorService, latch);
        routingTableChecksum = in.readLong();
                clusterStateChecksum
                    case BLOCKS_CS:
        this.coordinationMetadataChecksum = coordinationMetadataChecksum;
 * this file be licensed under the Apache-2.0 license or a
    long blocksChecksum;
        if (this == o) return true;
        clusterStateChecksum = in.readLong();
        hashesOfConsistentSettingsChecksum = in.readLong();
        executeChecksumTask((stream) -> {
        long indicesChecksum,
    public void writeTo(StreamOutput out) throws IOException {
        addIfMismatch(this.settingMetadataChecksum, otherClusterStateChecksum.settingMetadataChecksum, SETTINGS_MD_CS, mismatches);
                nodesChecksum,
                        builder.customMetadataMapChecksum(parser.longValue());
        }
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        }
            + clusterStateCustomsChecksum
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, templatesMetadataChecksum, CHECKSUM_SIZE);
    private void addIfMismatch(long checksum, long otherChecksum, String entityName, List<String> mismatches) {
        builder.field(TRANSIENT_SETTINGS_MD_CS, transientSettingsMetadataChecksum);
        long blocksChecksum;
            routingTableChecksum,
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, indicesChecksum, CHECKSUM_SIZE);
            + templatesMetadataChecksum
            clusterState.metadata().templatesMetadata().writeVerifiableTo(stream);
        long clusterStateChecksum
        if (checksum != otherChecksum) {
        templatesMetadataChecksum = in.readLong();
    public static class Builder {
            indicesChecksum,
    static final String TEMPLATES_MD_CS = "templates_md";
            } else if (token.isValue()) {
        long templatesMetadataChecksum;
        CheckedFunction<BufferedChecksumStreamOutput, Void, IOException> checksumTask,
    }
        long coordinationMetadataChecksum,
            + ", settingMetadataChecksum="
        builder.field(HASHES_MD_CS, hashesOfConsistentSettingsChecksum);
            task.apply(checksumOut);
        } catch (InterruptedException e) {
            + ", nodesChecksum="
        );
        addIfMismatch(this.routingTableChecksum, otherClusterStateChecksum.routingTableChecksum, ROUTING_TABLE_CS, mismatches);
            + coordinationMetadataChecksum
                    case CLUSTER_STATE_CS:
        long hashesOfConsistentSettingsChecksum,
            return this;
    static final String SETTINGS_MD_CS = "settings_md";
            stream.writeStringCollection(clusterState.customs().keySet());
    long coordinationMetadataChecksum;
        public Builder transientSettingsMetadataChecksum(long transientSettingsMetadataChecksum) {
        out.writeLong(nodesChecksum);
import java.io.IOException;
            return this;
        clusterStateChecksum = JZlib.crc32_combine(routingTableChecksum, nodesChecksum, CHECKSUM_SIZE);
        XContentParser.Token token;
                blocksChecksum,
    private static final int CHECKSUM_SIZE = 8;
        public Builder settingMetadataChecksum(long settingMetadataChecksum) {
        createClusterStateChecksum();
        }
        executeChecksumTask((stream) -> {
    }
            return null;
            this.nodesChecksum = nodesChecksum;
        }
            + ", transientSettingsMetadataChecksum="
     * Builder for ClusterStateChecksum
        executeChecksumTask((stream) -> {
            coordinationMetadataChecksum,
        out.writeLong(hashesOfConsistentSettingsChecksum);
                        break;
            parser.nextToken();
        addIfMismatch(
        return routingTableChecksum == that.routingTableChecksum
        out.writeLong(coordinationMetadataChecksum);
                checksumConsumer.accept(checksum);
import org.opensearch.common.io.stream.BytesStreamOutput;
    private static final String CLUSTER_STATE_CS = "cluster_state";
        this.settingMetadataChecksum = settingMetadataChecksum;
                    case TEMPLATES_MD_CS:
        public Builder routingTableChecksum(long routingTableChecksum) {
            this.templatesMetadataChecksum = templatesMetadataChecksum;
                throw new XContentParseException("Unexpected token [" + token + "]");
        ClusterStateChecksum that = (ClusterStateChecksum) o;
        builder.field(INDICES_CS, indicesChecksum);
                switch (currentFieldName) {
        builder.field(ROUTING_TABLE_CS, routingTableChecksum);
        try (
            mismatches.add(entityName);
        long routingTableChecksum;
        long indicesChecksum;
    }
            + ", coordinationMetadataChecksum="
        executeChecksumTask((stream) -> {
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, clusterStateCustomsChecksum, CHECKSUM_SIZE);
            return null;
            stream.writeMapValues(
        long templatesMetadataChecksum,
import org.opensearch.threadpool.ThreadPool;
        long nodesChecksum,
        });
    @Override
            + ", hashesOfConsistentSettingsChecksum="
    public String toString() {
        this.customMetadataMapChecksum = customMetadataMapChecksum;
        customMetadataMapChecksum = in.readLong();
            transientSettingsMetadataChecksum,
            return null;
            this.hashesOfConsistentSettingsChecksum,
    }
        }
        out.writeLong(indicesChecksum);
            latch.await();
        settingMetadataChecksum = in.readLong();
            mismatches
                routingTableChecksum,
        builder.field(TEMPLATES_MD_CS, templatesMetadataChecksum);
        executeChecksumTask((stream) -> {
        }, checksum -> settingMetadataChecksum = checksum, executorService, latch);
                        builder.hashesOfConsistentSettingsChecksum(parser.longValue());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    case TRANSIENT_SETTINGS_MD_CS:
        addIfMismatch(this.blocksChecksum, otherClusterStateChecksum.blocksChecksum, BLOCKS_CS, mismatches);
            + blocksChecksum
            this.transientSettingsMetadataChecksum,
                        break;
            && nodesChecksum == that.nodesChecksum
            clusterState.routingTable().writeVerifiableTo(stream);
        public ClusterStateChecksum build() {
            && indicesChecksum == that.indicesChecksum
                        builder.clusterStateChecksum(parser.longValue());
        out.writeLong(transientSettingsMetadataChecksum);
    }
    long settingMetadataChecksum;
                    case COORDINATION_MD_CS:
            return null;
        addIfMismatch(this.indicesChecksum, otherClusterStateChecksum.indicesChecksum, INDICES_CS, mismatches);
import org.opensearch.core.xcontent.XContentParseException;
                        builder.indicesChecksum(parser.longValue());
            );
        out.writeLong(customMetadataMapChecksum);
        this.routingTableChecksum = routingTableChecksum;
    public static ClusterStateChecksum.Builder builder() {
        ClusterStateChecksum.Builder builder = new ClusterStateChecksum.Builder();
                settingMetadataChecksum,
            && clusterStateChecksum == that.clusterStateChecksum;
        addIfMismatch(this.customMetadataMapChecksum, otherClusterStateChecksum.customMetadataMapChecksum, CUSTOM_MD_CS, mismatches);
    static final String CUSTOM_MD_CS = "customs_md";
                hashesOfConsistentSettingsChecksum,
        executeChecksumTask((stream) -> {
        blocksChecksum = in.readLong();
                        break;
        long clusterStateCustomsChecksum;
            otherClusterStateChecksum.coordinationMetadataChecksum,
    @Override
        if (parser.currentToken() == null) { // fresh parser? move to next token
        indicesChecksum = in.readLong();
import java.util.concurrent.CountDownLatch;
    }
    @Override
            this.coordinationMetadataChecksum = coordinationMetadataChecksum;
            HASHES_MD_CS,
    private static final Logger logger = LogManager.getLogger(ClusterStateChecksum.class);
        builder.field(CUSTOMS_CS, clusterStateCustomsChecksum);
                customMetadataMapChecksum,
        addIfMismatch(this.templatesMetadataChecksum, otherClusterStateChecksum.templatesMetadataChecksum, TEMPLATES_MD_CS, mismatches);
        }
    public static ClusterStateChecksum fromXContent(XContentParser parser) throws IOException {
    long templatesMetadataChecksum;
 * compatible open source license.
        }
            this.settingMetadataChecksum = settingMetadataChecksum;
            return new ClusterStateChecksum(
     */
        long transientSettingsMetadataChecksum;
        this.clusterStateCustomsChecksum = clusterStateCustomsChecksum;
        CountDownLatch latch = new CountDownLatch(COMPONENT_SIZE);
                latch.countDown();
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, hashesOfConsistentSettingsChecksum, CHECKSUM_SIZE);
        }
            Settings.writeSettingsToStream(clusterState.metadata().persistentSettings(), stream);
                        break;
import org.opensearch.core.xcontent.XContentBuilder;
                        builder.routingTableChecksum(parser.longValue());
            try {
        List<String> mismatches = new ArrayList<>();
            + customMetadataMapChecksum
 */
            }
            + nodesChecksum
            + ", indicesChecksum="
        long hashesOfConsistentSettingsChecksum;
        long start = threadpool.relativeTimeInNanos();
    }
            stream.writeStringCollection(clusterState.metadata().customs().keySet());
    }
            + ", customMetadataMapChecksum="
        this.clusterStateChecksum = clusterStateChecksum;
            this.customMetadataMapChecksum = customMetadataMapChecksum;
        builder.field(BLOCKS_CS, blocksChecksum);
        }, checksum -> transientSettingsMetadataChecksum = checksum, executorService, latch);
        return builder;
import org.opensearch.core.xcontent.XContentParser;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        executeChecksumTask((stream) -> {
                clusterStateCustomsChecksum,
        }
                coordinationMetadataChecksum,
        );
                    case CUSTOMS_CS:
    long nodesChecksum;
        long settingMetadataChecksum;
            clusterState.nodes().writeVerifiableTo(stream);
            + '}';
        executorService.execute(() -> {
        builder.field(SETTINGS_MD_CS, settingMetadataChecksum);
            return this;
        Consumer<Long> checksumConsumer,
        }
    public static final int COMPONENT_SIZE = 11;
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, coordinationMetadataChecksum, CHECKSUM_SIZE);
        out.writeLong(routingTableChecksum);
        );
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, transientSettingsMetadataChecksum, CHECKSUM_SIZE);
        if (this.clusterStateChecksum == otherClusterStateChecksum.clusterStateChecksum) {
                        break;
    /**
 * The OpenSearch Contributors require contributions made to
        nodesChecksum = in.readLong();
            return null;
            } else {
            + settingMetadataChecksum
        ) {
        out.writeLong(settingMetadataChecksum);
        public Builder coordinationMetadataChecksum(long coordinationMetadataChecksum) {
        ExecutorService executorService,
    static final String BLOCKS_CS = "blocks";
        executeChecksumTask((stream) -> {
                        break;
            && blocksChecksum == that.blocksChecksum
        }
            customMetadataMapChecksum,
        }
    public List<String> getMismatchEntities(ClusterStateChecksum otherClusterStateChecksum) {
            && templatesMetadataChecksum == that.templatesMetadataChecksum
        public Builder clusterStateChecksum(long clusterStateChecksum) {
    static final String HASHES_MD_CS = "hashes_md";
        this.blocksChecksum = blocksChecksum;
            TRANSIENT_SETTINGS_MD_CS,
        builder.field(COORDINATION_MD_CS, coordinationMetadataChecksum);
        }, checksum -> hashesOfConsistentSettingsChecksum = checksum, executorService, latch);
        builder.field(CLUSTER_STATE_CS, clusterStateChecksum);
            return List.of();
                        break;
            return null;
        executeChecksumTask((stream) -> {
        out.writeLong(blocksChecksum);
        this.hashesOfConsistentSettingsChecksum = hashesOfConsistentSettingsChecksum;
            clusterStateChecksum
    long hashesOfConsistentSettingsChecksum;
            BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out)
import org.opensearch.cluster.metadata.DiffableStringMap;
                        builder.coordinationMetadataChecksum(parser.longValue());
            return this;
 * SPDX-License-Identifier: Apache-2.0
            return this;
            return this;
            return null;
        }
        return mismatches;
            && settingMetadataChecksum == that.settingMetadataChecksum
import java.util.concurrent.ExecutorService;
            + ", templatesMetadataChecksum="
                throw new RemoteStateTransferException("Failed to execute checksum task", e);
import org.opensearch.common.CheckedFunction;
        addIfMismatch(this.clusterStateCustomsChecksum, otherClusterStateChecksum.clusterStateCustomsChecksum, CUSTOMS_CS, mismatches);
    long routingTableChecksum;
            + transientSettingsMetadataChecksum
        public Builder customMetadataMapChecksum(long customMetadataMapChecksum) {
                    case CUSTOM_MD_CS:
                    case ROUTING_TABLE_CS:
            ((DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings()).writeTo(stream);
            && transientSettingsMetadataChecksum == that.transientSettingsMetadataChecksum
    long clusterStateCustomsChecksum;
        long nodesChecksum;
        long clusterStateCustomsChecksum,
import java.util.Objects;
    }
            otherClusterStateChecksum.hashesOfConsistentSettingsChecksum,
        }, checksum -> customMetadataMapChecksum = checksum, executorService, latch);
            && hashesOfConsistentSettingsChecksum == that.hashesOfConsistentSettingsChecksum
                long checksum = createChecksum(checksumTask);
/**
            + ", clusterStateCustomsChecksum="
}
                indicesChecksum,
import org.opensearch.core.common.io.stream.Writeable;
                        builder.settingMetadataChecksum(parser.longValue());
import org.opensearch.common.settings.Settings;
    private long createChecksum(CheckedFunction<BufferedChecksumStreamOutput, Void, IOException> task) throws IOException {
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, settingMetadataChecksum, CHECKSUM_SIZE);
    ) {
        }, checksum -> coordinationMetadataChecksum = checksum, executorService, latch);
import java.util.ArrayList;
                transientSettingsMetadataChecksum,
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
            }
        out.writeLong(clusterStateChecksum);
    static final String COORDINATION_MD_CS = "coordination_md";
        builder.field(NODES_CS, nodesChecksum);
            return this;
    }
    static final String INDICES_CS = "indices_md";
        out.writeLong(templatesMetadataChecksum);
            this.coordinationMetadataChecksum,
            this.indicesChecksum = indicesChecksum;
            mismatches
            return this;
        }
            + ", blocksChecksum="
        long settingMetadataChecksum,
    long customMetadataMapChecksum;
        long transientSettingsMetadataChecksum,
    long transientSettingsMetadataChecksum;
                    case HASHES_MD_CS:
        if (o == null || getClass() != o.getClass()) return false;
        try {
            this.hashesOfConsistentSettingsChecksum = hashesOfConsistentSettingsChecksum;
                        builder.transientSettingsMetadataChecksum(parser.longValue());
        long customMetadataMapChecksum,
    long indicesChecksum;
    public ClusterStateChecksum(StreamInput in) throws IOException {
                        break;
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, blocksChecksum, CHECKSUM_SIZE);
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
import org.opensearch.common.unit.TimeValue;
                    default:
        public Builder hashesOfConsistentSettingsChecksum(long hashesOfConsistentSettingsChecksum) {
import org.opensearch.cluster.ClusterState;
            && customMetadataMapChecksum == that.customMetadataMapChecksum
