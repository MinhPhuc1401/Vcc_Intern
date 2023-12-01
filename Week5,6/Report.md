# WEEK 5, 6 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

### 1. Hadoop

#### 1.1. Big Data

Big data là một thuật ngữ mô tả lượng lớn dữ liệu phức tạp mà các công cụ truyền thống xử lý dữ liệu không thể xử lý hiệu quả. Các dữ liệu này thường được tạo ra từ nhiều nguồn khác nhau, bao gồm cả các thiết bị di động, cảm biến, mạng xã hội, máy chủ web, và nhiều nguồn dữ liệu khác. Big data được xác định thông qua ba yếu tố chính được gọi là "ba V": Volume (lượng), Velocity (tốc độ), và Variety (đa dạng).

#### 1.2. Hadoop Ecosystem

Ngoài các thành phần cơ bản, Hadoop có một hệ sinh thái phong phú các dự án liên quan được xây dựng trên nền tảng Hadoop. Các dự án này bao gồm Apache Hive (cho truy vấn và phân tích dữ liệu), Apache HBase (cho cơ sở dữ liệu phân tán), Apache Pig (cho xử lý dữ liệu linh hoạt), Apache Spark (cho xử lý dữ liệu lớn nhanh chóng), và nhiều dự án khác.

#### 1.3. HDFS (Hadoop Distributed File System)

Khái niệm: là hệ thống tệp tin phân tán của Hadoop, được thiết kế để lưu trữ và quản lý dữ liệu lớn trên nhiều máy tính. Nó chia nhỏ dữ liệu thành các khối và lưu trữ chúng trên các nút trong cluster để đảm bảo khả năng mở rộng và sự chịu lỗi.

#### 1.4. YARN (Yet Another Resource Negotiator)

Khái niệm: là một framework quản lý tài nguyên trong Hadoop, giúp điều phối và quản lý nguồn lực của cluster một cách hiệu quả. Nó cho phép chia nhỏ các tác vụ và phân phối chúng đồng thời trên các nút trong cluster.

#### 1.5. Apache Spark

Khái niệm: là một hệ thống tính toán phân tán mã nguồn mở được thiết kế để xử lý và phân tích dữ liệu lớn. Mặc dù Spark không phải là một phần cốt lõi của hệ sinh thái Hadoop, nhưng nó có thể tích hợp một cách mượt mà với Hadoop và các công cụ dữ liệu lớn khác. Spark cung cấp một khung tính toán phân tán nhanh và đa mục đích cho việc xử lý dữ liệu quy mô lớn.

### 2. HDFS

#### 2.1. NameNode
- Là nơi quản lý siêu dữ liệu của HDFS, bao gồm metadata về các tệp và thư mục, cũng như vị trí của dữ liệu trong các DataNode.
- Lưu trữ thông tin về cấu trúc thư mục, quyền truy cập và các khối dữ liệu.
#### 2.2. DataNode 
- Lưu trữ thực tế các khối dữ liệu của tệp trên đĩa cứng của nó.
- Báo cáo trạng thái và sức khỏe của nó đến NameNode định kỳ.
- Thực hiện các yêu cầu đọc/ghi từ ứng dụng và NameNode.
#### 2.3. Second Namenode 
- Đóng vai trò là một nút hỗ trợ cho Namenode và giúp giảm gánh nặng của quá trình sao lưu metadata.
#### 2.4. HDFS Block 
- Khối (blocks) là cách dữ liệu được chia nhỏ và lưu trữ trên các DataNode trong cluster. Khối giúp tối ưu hóa hiệu suất và đồng thời giảm nguy cơ mất mát dữ liệu.
- Kích thước mặc định của một khối trong HDFS là 128MB. Kích thước lớn giúp giảm số lượng yêu cầu I/O khi đọc và ghi dữ liệu, do mỗi tệp chỉ cần tham chiếu đến một số khối lớn hơn.

### 3. YARN

#### 3.1. Các thành phần

##### 3.1.1. ResourceManager (RM)
- Là thành phần chủ quản của YARN, quản lý tất cả nguồn lực trên cluster.
- Nhận các yêu cầu nguồn lực từ các ứng dụng và quyết định cách phân phối chúng.

##### 3.1.2. NodeManager (NM)
- Chạy trên mỗi nút (node) trong cluster và quản lý nguồn lực cục bộ trên nút đó.
- Báo cáo trạng thái và sức khỏe của nút đến ResourceManager.

##### 3.1.3. ApplicationMaster (AM)
- Là thành phần đại diện của mỗi ứng dụng trong YARN.
- Yêu cầu nguồn lực từ ResourceManager và quản lý việc chia nhỏ công việc và giám sát tiến trình thực thi.

#### 3.2. MapReduce
Khái niệm: Là một mô hình lập trình và một phần quan trọng của hệ sinh thái Hadoop, được sử dụng để xử lý và phân tích dữ liệu lớn. Trong Hadoop YARN (Yet Another Resource Negotiator), MapReduce không chỉ là một mô hình xử lý dữ liệu lớn mà còn là một ứng dụng chạy trên YARN để tận dụng khả năng mở rộng và linh hoạt của nền tảng. Cụ thể, MapReduce trên YARN là một ứng dụng được quản lý bởi ResourceManager và được chia thành các công việc Map và Reduce chạy trên các NodeManager trên cluster.

### 4. Spark

#### 4.1. Spark API
- Apache Spark cung cấp ba khái niệm chính để làm việc với dữ liệu: RDD (Resilient Distributed Dataset), DataFrames và Datasets.
- Trong Apache Spark, DataFrames và Datasets là các API có cấu trúc cao (high-level) và RDD là API có cấu trúc thấp (low-level). 

#### 4.2. Action
- Là một loại phương thức được gọi trên một Resilient Distributed Dataset (RDD) hoặc DataFrame để kích thích việc thực hiện tính toán trên dữ liệu.
- Các phương thức action là những điểm kết thúc trong quy trình tính toán, và chúng là những phương thức chủ yếu được sử dụng để đưa dữ liệu từ RDD hoặc DataFrame về driver program hoặc lưu trữ kết quả vào hệ thống tệp.

#### 4.3. Transformation
- Là quá trình biến đổi dữ liệu từ một RDD (Resilient Distributed Dataset) hoặc DataFrame thành một RDD hoặc DataFrame mới.
- Các biến đổi không làm thay đổi RDD hoặc DataFrame gốc mà tạo ra một biểu diễn mới của dữ liệu theo cách đã được xác định bởi người lập trình.
- Biến đổi là "lazily evaluated", có nghĩa là chúng chỉ thực sự được tính toán khi một hành động (action) được kích thích.

### 5. High Availability

#### 5.1. JournalNodes
- JournalNodes chịu trách nhiệm ghi và đọc các giao dịch sửa đổi (edits) của siêu dữ liệu. 
- Cả Active và Standby Namenode đều gửi các giao dịch sửa đổi của mình đến JournalNodes. 
- Khi có sự cố, Standby Namenode có thể sử dụng các giao dịch sửa đổi để đồng bộ siêu dữ liệu với Active Namenode và trở thành Active.

#### 5.2. ZooKeeper
- ZooKeeper thường được sử dụng để quản lý quá trình giữa các Active và Standby Namenodes. 
- Nó giúp giữ cho quá trình failover được đồng bộ và giữ cho chỉ có một Namenode là Active vào một thời điểm.

#### 5.3. Standby Namenode
- Standby Namenode là một nút thứ hai, chạy cùng lúc với Active Namenode trong kiến trúc HA. 
- Vai trò của Standby Namenode là duy trì một bản sao của siêu dữ liệu (metadata) của HDFS. 
- Nếu có sự cố với Active Namenode, Standby Namenode có thể chuyển đến vai trò Active để tiếp tục phục vụ yêu cầu từ client mà không làm gián đoạn dịch vụ.

#### 5.4. editlog
- là một phần của cơ sở dữ liệu metadata của Namenode, nơi ghi lại mọi thay đổi trong siêu dữ liệu (metadata) của hệ thống tệp.
- cụ thể, editlog lưu trữ các sự kiện sửa đổi, chẳng hạn như việc tạo mới hoặc xóa tệp, thay đổi quyền truy cập, thay đổi tên tệp, và các hoạt động khác liên quan đến siêu dữ liệu của HDFS

#### 5.5. fsimage
- là một file chứa một bản chụp (snapshot) tương ứng với trạng thái của siêu dữ liệu (metadata) của hệ thống tệp tại một điểm thời điểm cụ thể. 
- fsimage được sử dụng để khôi phục lại trạng thái của siêu dữ liệu sau khi Namenode khởi động lại.
