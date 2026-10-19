        return new ClusterStateChecksum.Builder();
            Settings.writeSettingsToStream(clusterState.metadata().transientSettings(), stream);
    }  
        out.writeLong(hashesOfConsistentSettingsChecksum);  
            + ", clusterStateChecksum="  
    public int hashCode() {  
        builder.field(NODES_CS, nodesChecksum);
        executeChecksumTask((stream) -> {  
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, customMetadataMapChecksum, CHECKSUM_SIZE);
        public Builder coordinationMetadataChecksum(long coordinationMetadataChecksum) {  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            return this;  
        out.writeLong(coordinationMetadataChecksum);
 * compatible open source license.
            mismatches
            otherClusterStateChecksum.transientSettingsMetadataChecksum,  
            clusterState.coordinationMetadata().writeVerifiableTo(stream);  
        } catch (InterruptedException e) {
        executeChecksumTask((stream) -> {  
        hashesOfConsistentSettingsChecksum = in.readLong();  
import java.io.IOException;
            return null;  
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, coordinationMetadataChecksum, CHECKSUM_SIZE);  
        addIfMismatch(
        this.settingMetadataChecksum = settingMetadataChecksum;
        long nodesChecksum,  
                        break;
            TRANSIENT_SETTINGS_MD_CS,
 */  
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, indicesChecksum, CHECKSUM_SIZE);  
            + indicesChecksum
        addIfMismatch(  
    }  
        String currentFieldName = parser.currentName();  
                        builder.templatesMetadataChecksum(parser.longValue());
            + ", customMetadataMapChecksum="  
        long clusterStateChecksum;
        long coordinationMetadataChecksum,  
        long indicesChecksum,  
        }  
            && templatesMetadataChecksum == that.templatesMetadataChecksum
        addIfMismatch(this.settingMetadataChecksum, otherClusterStateChecksum.settingMetadataChecksum, SETTINGS_MD_CS, mismatches);  
        executeChecksumTask((stream) -> {
    long customMetadataMapChecksum;  
                    case TRANSIENT_SETTINGS_MD_CS:  
    long coordinationMetadataChecksum;
        public ClusterStateChecksum build() {
            try {  
import java.util.List;  
            this.coordinationMetadataChecksum = coordinationMetadataChecksum;
                        builder.routingTableChecksum(parser.longValue());
                checksumConsumer.accept(checksum);
        }, checksum -> nodesChecksum = checksum, executorService, latch);  
            HASHES_MD_CS,  
        if (o == null || getClass() != o.getClass()) return false;
        return mismatches;
public class ClusterStateChecksum implements ToXContentFragment, Writeable {
            + ", nodesChecksum="
    static final String NODES_CS = "discovery_nodes";
        public Builder routingTableChecksum(long routingTableChecksum) {
    }  
                    case CLUSTER_STATE_CS:  
                        break;
                        builder.indicesChecksum(parser.longValue());
            + templatesMetadataChecksum
    long hashesOfConsistentSettingsChecksum;
        }, checksum -> transientSettingsMetadataChecksum = checksum, executorService, latch);  
            + coordinationMetadataChecksum
    /**
import org.opensearch.core.common.io.stream.StreamInput;
 * Stores checksum for all components in cluster state. This will be used to ensure cluster state is same across all nodes in the cluster.
import org.opensearch.core.xcontent.XContentParseException;  
        builder.field(ROUTING_TABLE_CS, routingTableChecksum);
        builder.field(CUSTOM_MD_CS, customMetadataMapChecksum);  
                        builder.customMetadataMapChecksum(parser.longValue());
    static final String TEMPLATES_MD_CS = "templates_md";
        }, checksum -> templatesMetadataChecksum = checksum, executorService, latch);
    }  
        long indicesChecksum;
                        break;
                switch (currentFieldName) {
import org.opensearch.common.io.stream.BytesStreamOutput;  
import java.util.function.Consumer;
                        break;
import org.opensearch.common.CheckedFunction;
    }  
    long transientSettingsMetadataChecksum;
            return null;
            }
            && hashesOfConsistentSettingsChecksum == that.hashesOfConsistentSettingsChecksum  
        templatesMetadataChecksum = in.readLong();
        out.writeLong(blocksChecksum);
            }  
        }  
            customMetadataMapChecksum,
        addIfMismatch(this.customMetadataMapChecksum, otherClusterStateChecksum.customMetadataMapChecksum, CUSTOM_MD_CS, mismatches);
        if (parser.currentToken() == null) { // fresh parser? move to next token
    }  
    long templatesMetadataChecksum;
                    case INDICES_CS:  
            return this;
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, hashesOfConsistentSettingsChecksum, CHECKSUM_SIZE);
 * SPDX-License-Identifier: Apache-2.0
                    case BLOCKS_CS:  
            throw new RemoteStateTransferException("Failed to create checksum for cluster state.", e);
                    case COORDINATION_MD_CS:  
            clusterState.routingTable().writeVerifiableTo(stream);
            clusterState.nodes().writeVerifiableTo(stream);
        });
            } catch (IOException e) {
            latch.await();  
        blocksChecksum = in.readLong();
        long hashesOfConsistentSettingsChecksum;  
    public static final int COMPONENT_SIZE = 11;  
            return List.of();
        transientSettingsMetadataChecksum = in.readLong();  
        );
}
                    case SETTINGS_MD_CS:  
                        throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
        public Builder templatesMetadataChecksum(long templatesMetadataChecksum) {  
    static final String SETTINGS_MD_CS = "settings_md";  
            return this;
        }, checksum -> customMetadataMapChecksum = checksum, executorService, latch);
    long clusterStateChecksum;  
        this.hashesOfConsistentSettingsChecksum = hashesOfConsistentSettingsChecksum;  
            stream.writeStringCollection(clusterState.customs().keySet());
        try {
                    case TEMPLATES_MD_CS:  
                    case NODES_CS:  
    private void addIfMismatch(long checksum, long otherChecksum, String entityName, List<String> mismatches) {
        ExecutorService executorService = threadpool.executor(ThreadPool.Names.REMOTE_STATE_CHECKSUM);
    ) {
        addIfMismatch(  
        this.coordinationMetadataChecksum = coordinationMetadataChecksum;
            this.hashesOfConsistentSettingsChecksum = hashesOfConsistentSettingsChecksum;
                throw new RemoteStateTransferException("Failed to execute checksum task", e);
        }, checksum -> hashesOfConsistentSettingsChecksum = checksum, executorService, latch);  
import java.util.concurrent.ExecutorService;  
            BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out)
        builder.field(TRANSIENT_SETTINGS_MD_CS, transientSettingsMetadataChecksum);
            this.templatesMetadataChecksum = templatesMetadataChecksum;
        builder.field(CUSTOMS_CS, clusterStateCustomsChecksum);
    public ClusterStateChecksum(ClusterState clusterState, ThreadPool threadpool) {
import org.opensearch.core.common.io.stream.StreamOutput;
                routingTableChecksum,  
package org.opensearch.gateway.remote;
        long clusterStateCustomsChecksum,
        long blocksChecksum;
                hashesOfConsistentSettingsChecksum,  
            && clusterStateChecksum == that.clusterStateChecksum;
                settingMetadataChecksum,
     */
            );  
import org.opensearch.common.unit.TimeValue;
    static final String ROUTING_TABLE_CS = "routing_table";
    }  
        long templatesMetadataChecksum,  
            return this;
            transientSettingsMetadataChecksum,
        return "ClusterStateChecksum{"
            this.customMetadataMapChecksum = customMetadataMapChecksum;  
import org.opensearch.cluster.ClusterState;  
                indicesChecksum,
    }
            + ", settingMetadataChecksum="  
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
        out.writeLong(templatesMetadataChecksum);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    static final String CUSTOMS_CS = "customs";
                clusterStateCustomsChecksum,  
        this.indicesChecksum = indicesChecksum;
                    case CUSTOMS_CS:  
                        builder.clusterStateChecksum(parser.longValue());
    private static final Logger logger = LogManager.getLogger(ClusterStateChecksum.class);
        return builder;
        builder.field(TEMPLATES_MD_CS, templatesMetadataChecksum);
        }  
    private void createClusterStateChecksum() {
        clusterStateCustomsChecksum = in.readLong();  
        builder.field(BLOCKS_CS, blocksChecksum);  
            mismatches.add(entityName);
        }, checksum -> settingMetadataChecksum = checksum, executorService, latch);
        }
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
        ExecutorService executorService,
        builder.field(INDICES_CS, indicesChecksum);
        long hashesOfConsistentSettingsChecksum,
    public String toString() {  
        );
        addIfMismatch(this.clusterStateCustomsChecksum, otherClusterStateChecksum.clusterStateCustomsChecksum, CUSTOMS_CS, mismatches);
        }
                        builder.nodesChecksum(parser.longValue());
            + routingTableChecksum  
            this.clusterStateChecksum = clusterStateChecksum;  
    public List<String> getMismatchEntities(ClusterStateChecksum otherClusterStateChecksum) {
        return builder.build();
        }  
 *
        out.writeLong(routingTableChecksum);  
    }  
            task.apply(checksumOut);  
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        out.writeLong(clusterStateCustomsChecksum);  
        }
        long templatesMetadataChecksum;
        long clusterStateChecksum
            return this;
            return this;  
        this.clusterStateChecksum = clusterStateChecksum;
        }  
        }  
            return this;  
    }
import org.apache.logging.log4j.Logger;
            return null;
                        builder.settingMetadataChecksum(parser.longValue());
        indicesChecksum = in.readLong();
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
                customMetadataMapChecksum,
            && indicesChecksum == that.indicesChecksum
import org.opensearch.cluster.metadata.DiffableStringMap;
        if (this.clusterStateChecksum == otherClusterStateChecksum.clusterStateChecksum) {  
        );
        }
            stream.writeMapValues(  
        }  
            + ", blocksChecksum="  
            parser.nextToken();
            return null;  
            this.hashesOfConsistentSettingsChecksum,
    }
                    default:  
    public static ClusterStateChecksum fromXContent(XContentParser parser) throws IOException {
            BytesStreamOutput out = new BytesStreamOutput();  
                    case CUSTOM_MD_CS:  
    long routingTableChecksum;
            + ", clusterStateCustomsChecksum="
            + customMetadataMapChecksum
    public void writeTo(StreamOutput out) throws IOException {
                latch.countDown();  
        long start = threadpool.relativeTimeInNanos();  
        logger.debug("Checksum execution time {}", TimeValue.nsecToMSec(threadpool.relativeTimeInNanos() - start));
            return null;
     * Builder for ClusterStateChecksum  
        builder.field(CLUSTER_STATE_CS, clusterStateChecksum);  
        }  
        executeChecksumTask((stream) -> {  
        out.writeLong(customMetadataMapChecksum);
            );  
            parser.nextToken();
                        break;
                        builder.blocksChecksum(parser.longValue());
    }
            return null;  
        public Builder indicesChecksum(long indicesChecksum) {  
            logger.debug("No mismatch in checksums.");
        }
            this.settingMetadataChecksum = settingMetadataChecksum;  
        }, checksum -> blocksChecksum = checksum, executorService, latch);
        ClusterStateChecksum that = (ClusterStateChecksum) o;
            + settingMetadataChecksum
    private static final String CLUSTER_STATE_CS = "cluster_state";  
        }
    }  
        nodesChecksum = in.readLong();
            return null;
                    case ROUTING_TABLE_CS:  
/**
/*  
    @Override
        this.blocksChecksum = blocksChecksum;
        executeChecksumTask((stream) -> {
        public Builder settingMetadataChecksum(long settingMetadataChecksum) {
                (checksumStream, value) -> value.writeVerifiableTo((BufferedChecksumStreamOutput) checksumStream)
    static final String TRANSIENT_SETTINGS_MD_CS = "transient_settings_md";
    private long createChecksum(CheckedFunction<BufferedChecksumStreamOutput, Void, IOException> task) throws IOException {
            && customMetadataMapChecksum == that.customMetadataMapChecksum
            } else if (token.isValue()) {
        }
        }
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, settingMetadataChecksum, CHECKSUM_SIZE);
            clusterStateChecksum
            return null;
import org.opensearch.core.xcontent.ToXContentFragment;
    @Override
            COORDINATION_MD_CS,  
                    case HASHES_MD_CS:  
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, transientSettingsMetadataChecksum, CHECKSUM_SIZE);
        XContentParser.Token token;
        addIfMismatch(this.routingTableChecksum, otherClusterStateChecksum.routingTableChecksum, ROUTING_TABLE_CS, mismatches);
    public static class Builder {
import org.apache.logging.log4j.LogManager;
        long clusterStateCustomsChecksum;  
            return null;  
        out.writeLong(transientSettingsMetadataChecksum);  
        this.templatesMetadataChecksum = templatesMetadataChecksum;
            coordinationMetadataChecksum,  
import org.opensearch.core.common.io.stream.Writeable;  
        coordinationMetadataChecksum = in.readLong();
            + clusterStateChecksum
    @Override
        addIfMismatch(this.templatesMetadataChecksum, otherClusterStateChecksum.templatesMetadataChecksum, TEMPLATES_MD_CS, mismatches);
            clusterStateCustomsChecksum,
    ) {
        long routingTableChecksum;  
            blocksChecksum,
            + clusterStateCustomsChecksum  
            indicesChecksum,  
        out.writeLong(settingMetadataChecksum);
            + "routingTableChecksum="
        try (
            Settings.writeSettingsToStream(clusterState.metadata().persistentSettings(), stream);
                blocksChecksum,
        routingTableChecksum = in.readLong();  
    long nodesChecksum;
                coordinationMetadataChecksum,
        if (checksum != otherChecksum) {  
    public boolean equals(Object o) {
        ClusterStateChecksum.Builder builder = new ClusterStateChecksum.Builder();  
        public Builder blocksChecksum(long blocksChecksum) {
                        break;
            mismatches
import org.opensearch.threadpool.ThreadPool;
        }
        settingMetadataChecksum = in.readLong();
        this.routingTableChecksum = routingTableChecksum;  
            return this;
            return this;
            stream.writeStringCollection(clusterState.metadata().customs().keySet());
            && nodesChecksum == that.nodesChecksum
import org.opensearch.core.xcontent.XContentBuilder;
        }, checksum -> coordinationMetadataChecksum = checksum, executorService, latch);
        }
    static final String COORDINATION_MD_CS = "coordination_md";
        createClusterStateChecksum();
    public static ClusterStateChecksum.Builder builder() {  
        builder.field(SETTINGS_MD_CS, settingMetadataChecksum);  
    static final String CUSTOM_MD_CS = "customs_md";  
            mismatches
        long settingMetadataChecksum;
        ) {
                        break;
import com.jcraft.jzlib.JZlib;  
        executeChecksumTask((stream) -> {
                nodesChecksum,
        public Builder transientSettingsMetadataChecksum(long transientSettingsMetadataChecksum) {
        this.customMetadataMapChecksum = customMetadataMapChecksum;
import org.opensearch.core.xcontent.XContentParser;
                transientSettingsMetadataChecksum,  
        }  
        return routingTableChecksum == that.routingTableChecksum  
        public Builder clusterStateChecksum(long clusterStateChecksum) {
            && clusterStateCustomsChecksum == that.clusterStateCustomsChecksum  
 * this file be licensed under the Apache-2.0 license or a
    long blocksChecksum;  
        }
        );  
                currentFieldName = parser.currentName();  
                }
 */  
        addIfMismatch(this.nodesChecksum, otherClusterStateChecksum.nodesChecksum, NODES_CS, mismatches);  
        this.clusterStateCustomsChecksum = clusterStateCustomsChecksum;  
    static final String BLOCKS_CS = "blocks";  
            return null;
import java.util.Objects;
            && blocksChecksum == that.blocksChecksum
        long blocksChecksum,
        executeChecksumTask((stream) -> {
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, blocksChecksum, CHECKSUM_SIZE);
                        break;
        addIfMismatch(this.blocksChecksum, otherClusterStateChecksum.blocksChecksum, BLOCKS_CS, mismatches);
        builder.field(COORDINATION_MD_CS, coordinationMetadataChecksum);
            + ", coordinationMetadataChecksum="
            clusterState.blocks().writeVerifiableTo(stream);
            ((DiffableStringMap) clusterState.metadata().hashesOfConsistentSettings()).writeTo(stream);
                        builder.transientSettingsMetadataChecksum(parser.longValue());
            return new ClusterStateChecksum(
        out.writeLong(nodesChecksum);
        long transientSettingsMetadataChecksum;  
        builder.field(HASHES_MD_CS, hashesOfConsistentSettingsChecksum);
            return checksumOut.getChecksum();
            this.indicesChecksum = indicesChecksum;
            return null;
            otherClusterStateChecksum.hashesOfConsistentSettingsChecksum,
    static final String INDICES_CS = "indices_md";
            this.coordinationMetadataChecksum,
                        break;
                        break;
        this.nodesChecksum = nodesChecksum;
            + nodesChecksum
    long indicesChecksum;
import org.opensearch.common.settings.Settings;
            this.blocksChecksum = blocksChecksum;  
            + ", templatesMetadataChecksum="
    public ClusterStateChecksum(
            + blocksChecksum
        clusterStateChecksum = in.readLong();
        addIfMismatch(this.indicesChecksum, otherClusterStateChecksum.indicesChecksum, INDICES_CS, mismatches);  
        CountDownLatch latch = new CountDownLatch(COMPONENT_SIZE);
            + ", transientSettingsMetadataChecksum="
    private void executeChecksumTask(
        public Builder customMetadataMapChecksum(long customMetadataMapChecksum) {
    }  
        executeChecksumTask((stream) -> {
                        break;
    }
import java.util.ArrayList;
    @Override
        List<String> mismatches = new ArrayList<>();
            return this;
        out.writeLong(indicesChecksum);
    static final String HASHES_MD_CS = "hashes_md";
        out.writeLong(clusterStateChecksum);
            + '}';
            clusterState.metadata().templatesMetadata().writeVerifiableTo(stream);  
                        break;
            settingMetadataChecksum,
        executorService.execute(() -> {
        executeChecksumTask((stream) -> {
            this.transientSettingsMetadataChecksum,
        public Builder hashesOfConsistentSettingsChecksum(long hashesOfConsistentSettingsChecksum) {
        executeChecksumTask((stream) -> {  
        clusterStateChecksum = JZlib.crc32_combine(routingTableChecksum, nodesChecksum, CHECKSUM_SIZE);  
                long checksum = createChecksum(checksumTask);
            otherClusterStateChecksum.coordinationMetadataChecksum,
            hashesOfConsistentSettingsChecksum,
                throw new XContentParseException("Unexpected token [" + token + "]");
            routingTableChecksum,
                        builder.hashesOfConsistentSettingsChecksum(parser.longValue());
        this.transientSettingsMetadataChecksum = transientSettingsMetadataChecksum;  
import java.util.concurrent.CountDownLatch;
            + transientSettingsMetadataChecksum  
            return this;  
        long customMetadataMapChecksum,
        long customMetadataMapChecksum;
            this.transientSettingsMetadataChecksum = transientSettingsMetadataChecksum;
        CountDownLatch latch  
                        builder.coordinationMetadataChecksum(parser.longValue());
 * The OpenSearch Contributors require contributions made to  
        }, checksum -> indicesChecksum = checksum, executorService, latch);
    public ClusterStateChecksum(StreamInput in) throws IOException {
        long transientSettingsMetadataChecksum,
        return Objects.hash(
        CheckedFunction<BufferedChecksumStreamOutput, Void, IOException> checksumTask,  
            } else {  
    }
        long settingMetadataChecksum,
            && settingMetadataChecksum == that.settingMetadataChecksum
            + ", hashesOfConsistentSettingsChecksum="
        customMetadataMapChecksum = in.readLong();
    private static final int CHECKSUM_SIZE = 8;
            this.nodesChecksum = nodesChecksum;
    @Override
            this.clusterStateCustomsChecksum = clusterStateCustomsChecksum;
            + hashesOfConsistentSettingsChecksum  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            nodesChecksum,  
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, clusterStateCustomsChecksum, CHECKSUM_SIZE);
            && coordinationMetadataChecksum == that.coordinationMetadataChecksum
            return this;
            this.routingTableChecksum = routingTableChecksum;
                clusterStateChecksum
        executeChecksumTask((stream) -> {
    long settingMetadataChecksum;  
        public Builder nodesChecksum(long nodesChecksum) {  
            + ", indicesChecksum="
                clusterState.metadata().indices(),
        }, checksum -> routingTableChecksum = checksum, executorService, latch);
            && transientSettingsMetadataChecksum == that.transientSettingsMetadataChecksum  
                templatesMetadataChecksum,
        public Builder clusterStateCustomsChecksum(long clusterStateCustomsChecksum) {
    long clusterStateCustomsChecksum;
        long nodesChecksum;
        Consumer<Long> checksumConsumer,
            templatesMetadataChecksum,  
                        builder.clusterStateCustomsChecksum(parser.longValue());
        long coordinationMetadataChecksum;
        long routingTableChecksum,
        clusterStateChecksum = JZlib.crc32_combine(clusterStateChecksum, templatesMetadataChecksum, CHECKSUM_SIZE);  
        }, checksum -> clusterStateCustomsChecksum = checksum, executorService, latch);  
        if (this == o) return true;  
