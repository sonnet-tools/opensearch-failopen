    TTC->>OH: Serialize TransportResponse<br/>(via sendResponse)
    participant Client2
    participant N2 as Network
    NOH->>N: Send BytesReference
    CTC->>CIP: Receive BytesReference
    participant RH2 as ResponseHandler
- **Channel**: FlightClientChannel/FlightServerChannel with Flight handlers
    participant OH as OutboundHandler
## 2. Inbound Server: Netty4 vs. Flight
    NMH->>RH: Process Request
    CM->>C: Provide Connection
    RH2->>FTC: completeStream()
    Client->>TS: Send TransportRequest
    participant FOH as FlightOutboundHandler
    FP->>FP: Create VectorSchemaRoot
    Note over Client2,N2: Flight Flow
    C->>TC: Use Channel
    Client2->>STS: Send TransportRequest
    participant Client
    Note over RH,TC: Netty4 Flow
    FCC->>RH2: Get TransportResponseHandler<br/>using reqID
    FC->>N2: Transmit Request
    participant FMH as FlightMessageHandler
    FTC->>FOH: sendResponseBatch
    participant FTR as FlightTransportResponse
    FTC->>FOH: completeStream
sequenceDiagram
    participant FP as FlightProducer
- **Serialization**: BytesReference with StreamOutput/StreamInput
    NMH2->>RH2: Process Request
    participant FTC as FlightTransportChannel
    STC->>IP: Receive BytesReference
# Netty4 vs Flight Transport Comparison
    Note over STC,RH: Netty4 Flow
sequenceDiagram
    IP2->>IH2: Deserialize with ArrowStreamInput
    Note over FC,RH2: Flight Flow (Async Response Handling)
    FCC->>RH2: handler.handleStreamResponse(streamResponse)<br/>(Async Processing)
    participant TC as TcpChannel
    participant FS as FlightServer
    participant TS as TransportService
```
    participant C2 as Connection
    participant FC as FlightClientChannel
```
    FOH->>FSC: completeStream
```
    Note over CTC,RH: Netty4 Flow
    participant FCC as FlightClientChannel
    participant FC as FlightClient
    participant IH as InboundHandler
    TS->>CM: Get Connection
    IH2->>NMH2: Interpret as TransportRequest
    participant RH2 as RequestHandler
- **Processing**: Synchronous response handling
- **Streaming**: Single request → multiple response batches
    CIH->>RH: Deliver Response
    participant FSC as FlightServerChannel
    participant STC as Server TcpChannel<br/>(Netty4TcpChannel)
sequenceDiagram
    FSC->>SSL: start(root) (first batch)
- **Processing**: Asynchronous stream processing with `nextResponse()` loop
```mermaid
    FP->>IP2: Pass to InboundPipeline
    Note over FS,RH2: Flight Flow
    FSC->>SSL: completed() (end stream)
    participant NMH2 as NativeMessageHandler
    FCC->>FCC: Retrieve Header and reqID
    FTC->>FMH: Serialize to Flight Ticket<br/>(ArrowStreamOutput) with reqID
    CIP->>CIH: Deserialize to TransportResponse<br/>(StreamInput)
- **Serialization**: Arrow Flight Ticket with ArrowStreamOutput/ArrowStreamInput
    FOH->>FSC: sendBatch(VectorSchemaRoot)
    FC->>FCC: handleInboundStream(Ticket, Listener)
    participant CTC as Client TcpChannel<br/>(Netty4TcpChannel)
- **Protocol**: Custom binary protocol over TCP
```mermaid
    RH->>TTC: sendResponse(TransportResponse)
## Key Differences Summary
## 4. Inbound Client: Netty4 vs. Flight
    participant RH as ResponseHandler
    FMH->>FC: Send Flight Ticket
    participant N as Network
### **Flight Transport (New)**:
```mermaid
    participant IP as InboundPipeline
    STS->>CM2: Get Connection
- **Request/Response**: Single request → single response pattern
    participant CM as ConnectionManager
This document compares the traditional Netty4 transport with the new Arrow Flight transport across all four communication flows.
    FSC->>SSL: putNext() (stream batch)
    Note over RH2,SSL: Flight Flow
    FCC->>FTR: Create FlightTransportResponse
    TC->>NOH: Serialize to BytesReference<br/>(StreamOutput) with reqID
```
    participant IP2 as InboundPipeline
    OH->>TC: Send Serialized Data to Client
```mermaid
    participant RH as RequestHandler
    participant CM2 as ConnectionManager
    participant CIP as Client InboundPipeline
    participant CIH as Client InboundHandler
    participant SSL as ServerStreamListener
    C2->>FTC: Use Channel
    participant STS as StreamTransportService
## 1. Outbound Client: Netty4 vs. Flight
    FP->>FP: Create FlightServerChannel
### **Netty4 Transport (Traditional)**:
    participant IH2 as InboundHandler
    participant NMH as NativeMessageHandler
    FS->>FP: Receive Flight Ticket
## 3. Outbound Server: Netty4 vs. Flight
    participant TTC as TcpTransportChannel
    participant NOH as NativeOutboundHandler
    Note over Client,N: Netty4 Flow
- **Protocol**: Arrow Flight RPC over gRPC
    participant TC as TcpChannel<br/>(Netty4TcpChannel)
    IP->>IH: Deserialize to InboundMessage<br/>(StreamInput)
- **Channel**: Netty4TcpChannel with native handlers
    RH2->>FTC: sendResponseBatch(TransportResponse)
sequenceDiagram
    participant C as Connection
    participant RH as RequestHandler
    participant RH2 as RequestHandler
    IH->>NMH: Interpret as TransportRequest
    STS->>STS: Generate reqID
    CM2->>C2: Provide Connection
    participant FTC as FlightTcpChannel
    TS->>TS: Generate reqID
