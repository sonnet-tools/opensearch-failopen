            try (Stream<String> lines = Files.lines(unicastHostsFilePath)) {
        if (Files.exists(unicastHostsFilePath)) {  
    private static final Logger logger = LogManager.getLogger(FileBasedSeedHostsProvider.class);
 * 67.81.244.11:9305  
 *
    }
public class FileBasedSeedHostsProvider implements SeedHostsProvider {
 *  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    private List<String> getHostsList() {
                    .collect(Collectors.toList());  
 * <p>
        logger.debug("seed addresses: {}", transportAddresses);  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    }  
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
                logger.warn(() -> new ParameterizedMessage("failed to read file [{}]", unicastHostsFilePath), e);
        logger.warn("expected, but did not find, a dynamic hosts list at [{}]", unicastHostsFilePath);
}  
    public FileBasedSeedHostsProvider(Path configFile) {
        final List<TransportAddress> transportAddresses = hostsResolver.resolveHosts(getHostsList());
                return lines.filter(line -> line.startsWith("#") == false) // lines starting with `#` are comments
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.discovery;
    }
 * under the License.  
 * from {@link #UNICAST_HOSTS_FILE}.
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.core.common.transport.TransportAddress;
 * You may obtain a copy of the License at  
            } catch (IOException e) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
        return transportAddresses;
        this.unicastHostsFilePath = configFile.resolve(UNICAST_HOSTS_FILE);
 * first port in the {@code transport.port} range.
 *
 * 67.81.244.10
/*  
 * An example unicast hosts file could read:  
 * @opensearch.internal  
/*
 * this work for additional information regarding copyright
import java.util.Collections;  
 * software distributed under the License is distributed on an
 */
                return Collections.emptyList();  
 * KIND, either express or implied.  See the License for the
 */  
 * Each host/port that is part of the discovery process must be listed on  
 * compatible open source license.
 * GitHub history for details.
import java.util.stream.Collectors;
 * the Apache License, Version 2.0 (the "License"); you may
 * a separate line. If the port is left off an entry, we default to the
 * The OpenSearch Contributors require contributions made to  
        }
import java.util.List;
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
/*  
    @Override  
    private final Path unicastHostsFilePath;
import java.nio.file.Path;
import org.apache.logging.log4j.message.ParameterizedMessage;  
import java.util.stream.Stream;  
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
 * <p>
        return Collections.emptyList();  
import java.nio.file.Files;
 * An implementation of {@link SeedHostsProvider} that reads hosts/ports  
            }
 * 67.81.244.15:9400
import org.apache.logging.log4j.LogManager;
    public static final String UNICAST_HOSTS_FILE = "unicast_hosts.txt";  
