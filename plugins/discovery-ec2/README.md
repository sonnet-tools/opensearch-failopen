```
While sending the request to IMDS, specified discovery settings for finding master-eligible nodes are being set. You will see the following in the logs.
      .build()
- `discovery.seed_providers`: Set this to `ec2` for EC2 IMDS based discovery.
```java
### Unit and Integration Tests
  for (final Instance instance : reservation.instances()) {
```
  System.out.println(reservation.reservationId());
```yml
### Sample IMDS Query
  }
```
- `discovery.seed_hosts`: List of all nodes in the cluster.
  .build();
  .build();
You may need to query IMDS without running OpenSearch. Use [this sample](https://github.com/dblock/aws-imds-sample) or copy the following code that makes a query to IMDS that looks for `running`, `pending` or `stopped` instances.
cluster.initial_cluster_manager_nodes: ["seed"]
DescribeInstancesResponse describeInstancesResponse = client.describeInstances(describeInstancesRequest);
The nodes getting added as eligible masters are ones with the role tag set to `my-cluster-manager`.
The following instructions manually exercise the plugin.
```
```
RetryPolicy retryPolicy = RetryPolicy.builder()
[2023-05-31T15:23:03,677][TRACE][o.o.d.e.AwsEc2SeedHostsProvider] [ip-172-31-73-184] adding i-01fa1736e8566c693, address 172.31.73.184, transport_address 172.31.73.184:9300
The discovery-ec2 plugin allows OpenSearch to find the master-eligible nodes in a cluster running on AWS EC2 by querying the AWS Instance Metadata Service ([IMDS](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html)) API for the addresses of the EC2 instances running these nodes.
- `network.host`: Set this to the IP of the eth0 network adapter, can be fetched by `ipconfig` or by running `hostname -I` on Linux hosts.
  ).build();
  .credentialsProvider(credentialsProviderChain)
discovery.ec2.tag.role: my-cluster-manager
Enable `TRACE`-level logging in `opensearch.yml` to see more output.
## Troubleshooting
      .values("running", "pending", "stopped")
DescribeInstancesRequest describeInstancesRequest = DescribeInstancesRequest.builder()
```
- `discovery.ec2.tag.role: my-cluster-manager`: Filter out only those nodes with value `my-cluster-manager` for the `role` tag.
```
    Filter.builder()
./gradlew :plugins:discovery-ec2:check
The implementation in the discovery-ec2 plugin queries for instances of a given type (e.g. private or public IP), with a tag, or running in a specific availability zone.
      .name("instance-state-name")
# discovery-ec2
```
Setup a 5-node (Ubuntu) cluster on EC2, with 3 of them tagged with `role: my-cluster-manager`, and a custom TCP rule to expose ports 9200 to 9300 to allow TCP traffic. Default EC2 configuration only allows SSH TCP traffic and hence only exposes port 22.
  .numRetries(10)
- `discovery.ec2.region`: Optionally set to your region, e.g. `us-east-1`, by default the plugin uses the region of the current EC2 instance.
DefaultCredentialsProvider credentialsProviderChain = DefaultCredentialsProvider.create();
## Testing
```yml
for (final Reservation reservation : describeInstancesResponse.reservations()) {
}
### Trace Level Logs
Set the following properties.
### Manual Testing
- `cluster.initial_cluster_manager_nodes`: List of all initial cluster manager nodes.
logger.org.opensearch.discovery.ec2: trace
  .filters(
[2023-05-31T15:23:03,676][TRACE][o.o.d.e.AwsEc2SeedHostsProvider] [ip-172-31-73-184] finding seed nodes...
[2023-05-31T15:22:39,274][DEBUG][o.o.d.e.AwsEc2SeedHostsProvider] [ip-172-31-73-184] using host_type [private_ip], tags [{role=[my-cluster-manager]}], groups [[]] with any_group [true], availability_zones [[]]
  .httpClientBuilder(ApacheHttpClient.builder())
discovery.seed_providers: ec2
[2023-05-31T15:23:03,677][TRACE][o.o.d.e.AwsEc2SeedHostsProvider] [ip-172-31-73-184] adding i-03d70a4521045cc3b, address 172.31.74.169, transport_address 172.31.74.169:9300
```
This is typically configured as follows in `opensearch.yml`.
[2023-05-31T15:23:03,677][TRACE][o.o.d.e.AwsEc2SeedHostsProvider] [ip-172-31-73-184] adding i-0c6ffdd10ebd3c2f1, address 172.31.74.156, transport_address 172.31.74.156:9300
Ec2Client client = Ec2Client.builder()
    System.out.println("\t" + instance.publicDnsName());
