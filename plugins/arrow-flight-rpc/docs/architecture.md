    FC -->|"5\. Send over TLS"| FSrv
    class ClientTS,ClientFT,ClientFCC,ClientFTR,ServerTS,ServerFT,ServerFTC,ServerFSC transport
    ServerFSC["FlightServerChannel (Transport)"]
    FSrv -->|"6\. Process stream"| SSL
    ServerFSC -->|"8\. Deserialize via StreamInput"| ServerFT
    ClientFT["FlightTransport (Transport)"]
```mermaid
    ClientFT -->|"3\. Route to channel"| ClientFCC
    ClientFT -->|"25\. Return response"| ClientAction
%% Request Flow
%% Style
    ServerFT -->|"9\. Route request"| ServerTS
    ClientAction["Action Execution (OpenSearch)"]
    ClientFTR["FlightTransportResponse (Transport)"]
    class FSQueue queue
    FSrv["Flight Server (Arrow)"]
    ServerTS["StreamTransportService (Transport)"]
    FSQueue -->|"20\. Queue ArrowMessage"| FSQueue
# Arrow Flight RPC Node-to-Node Architecture
    FC -->|"21\. Process response"| ClientFTR
    ServerFSC -->|"14\. Create VectorSchemaRoot"| VSR
    ServerFTC["FlightTransportChannel (Transport)"]
    VSR["VectorSchemaRoot (Arrow)"]
    FSQueue["LinkedBlockingQueue (Arrow)"]
    SSL["ServerStreamListener (Arrow)"]
    SSL -->|"7\. Deliver to"| ServerFSC
    VSR -->|"16\. Send batch"| SSL
%% Message Buffering Detail
    ServerAction["Action Execution (OpenSearch)"]
    ServerAction -->|"12\. Generate multiple responses"| ServerFTC
    ClientFCC -->|"4\. Serialize via StreamOutput"| FC
    ClientFTR -->|"24\. Deserialize via VectorStreamInput"| ClientFT
    FS -->|"19\. Observer.onNext"| FSQueue
    class FC,FS,FSrv,SSL,VSR arrow
    ServerFSC -->|"15\. Serialize via VectorStreamOutput"| VSR
    FSQueue -->|"23\. take()"| ClientFTR
%% OpenSearch Layer
    ClientFCC["FlightClientChannel (Transport)"]
    ServerRH["Request Handler (OpenSearch)"]
    ClientAction -->|"1\. Execute TransportRequest"| ClientTS
    FSrv -->|"18\. Send over TLS"| FS
    ClientTS -->|"2\. Send request"| ClientFT
%% Response Flow - Multiple responses
    FS["FlightStream (Arrow)"]
%% Transport Layer
    ClientAction ~~~ ClientTS ~~~ ClientFT ~~~ ClientFCC
    classDef transport fill:#e8f5e9,stroke:#2e7d32
%% Arrow Flight Layer
    ServerAction ~~~ ServerFTC ~~~ ServerFSC
flowchart TD
    class ClientAction,ServerAction,ServerRH opensearch
    classDef queue fill:#ffecb3,stroke:#ff6f00
    SSL -->|"17\. Stream data"| FSrv
%% Multiple response loop
    ClientFTR -->|"22\. next()"| FSQueue
    classDef arrow fill:#fff3e0,stroke:#e65100
    FC["Flight Client (Arrow)"]
    ServerRH -->|"11\. Execute action"| ServerAction
    ServerFT["FlightTransport (Transport)"]
    classDef opensearch fill:#e3f2fd,stroke:#1976d2
    ServerFTC -.->|"Loop for multiple responses"| ServerFTC
%% Response Processing
```
    ServerFTC -->|"13\. Forward to"| ServerFSC
%% Layout adjustments
    ClientTS["StreamTransportService (Transport)"]
    ServerTS -->|"10\. Handle request"| ServerRH
    FC ~~~ FS ~~~ FSQueue
