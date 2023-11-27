# WEEK 4 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

#### 1. Mô tả công việc

- Tự cài đặt một cơ sở dữ liệu trên máy tính (cụ thể là mysql). Trình bày chi tiết về các thành phần liên quan.
- Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql)

#### 2. Kết quả công việc

##### 2.1. Các thành phần liên quan

###### 2.1.1. MySQL Server:
- Chức năng: Làm nhiệm vụ xử lý các yêu cầu từ client, thực hiện các truy vấn và cung cấp dữ liệu từ cơ sở dữ liệu.
- Cài đặt: Thường đi kèm với MySQL Installer và được cài đặt trên máy tính.
- Quản lý: Có thể quản lý thông qua MySQL Workbench hoặc các công cụ quản lý dòng lệnh như MySQL Shell.

###### 2.1.2. MySQL Workbench:
- Chức năng: Cung cấp một giao diện đồ họa để quản lý cơ sở dữ liệu, tạo và quản lý bảng, thực hiện truy vấn SQL, và theo dõi hiệu suất.
- Cài đặt: Thường đi kèm với MySQL Installer và được cài đặt cùng với MySQL Server.
- Quản lý: Sử dụng để thực hiện các thao tác quản lý cơ sở dữ liệu thông qua giao diện đồ họa.

###### 2.1.3. MySQL Shell:
- Chức năng: Cung cấp một môi trường dòng lệnh để tương tác với MySQL Server, thực hiện các truy vấn SQL, và quản lý cơ sở dữ liệu.
- Cài đặt: Thường đi kèm với MySQL Installer.
- Quản lý: Sử dụng để thực hiện các thao tác trực tiếp trên dòng lệnh, thích hợp cho các tác vụ tự động và kịch bản.

###### 2.1.4. MySQL Client Libraries:
- Chức năng: Cung cấp các thư viện cho các ngôn ngữ lập trình khác nhau để kết nối và tương tác với MySQL Server.
- Cài đặt: Các thư viện này thường được cài đặt khi cài đặt MySQL Server hoặc có thể tải về độc lập.
- Quản lý: Được sử dụng bởi ứng dụng hoặc mã nguồn để kết nối và thực hiện các thao tác với cơ sở dữ liệu.

###### 2.1.5. MySQL Database:
- Chức năng: Nơi lưu trữ dữ liệu theo cấu trúc được xác định, bao gồm các bảng, cột và hàng.
- Quản lý: Các thao tác quản lý cơ sở dữ liệu bao gồm tạo, xóa, sửa đổi cơ sở dữ liệu, bảng, và các phần tử dữ liệu khác.

###### 2.1.6. my.cnf (hoặc my.ini):
- Chức năng: File cấu hình cho MySQL Server, chứa các cấu hình như port sử dụng, đường dẫn lưu trữ dữ liệu, và các cài đặt khác.
- Quản lý: Có thể chỉnh sửa để thay đổi cấu hình của MySQL Server.

###### 2.1.7. MySQL Data Directory:
- Chức năng: Thư mục trong đó MySQL Server lưu trữ dữ liệu cơ sở dữ liệu.
- Quản lý: Cần duy trì và sao lưu định kỳ để đảm bảo an toàn cho dữ liệu.

##### 2.2. Các loại database

###### Cơ sở Dữ liệu SQL:

- MySQL: là một hệ quản trị cơ sở dữ liệu SQL mã nguồn mở phổ biến. Nó hỗ trợ các tính năng như ACID (Atomicity, Consistency, Isolation, Durability) và sử dụng ngôn ngữ truy vấn SQL để tương tác với dữ liệu.
- PostgreSQL: là một hệ quản trị cơ sở dữ liệu SQL mạnh mẽ và có khả năng mở rộng. Nó hỗ trợ các tính năng ACID và cung cấp một số tính năng tiên tiến như hỗ trợ JSON và hình học địa lý.
- Microsoft SQL Server: là một hệ quản trị cơ sở dữ liệu SQL do Microsoft phát triển. Nó cung cấp nhiều tính năng như xử lý dữ liệu phức tạp, quản lý bảo mật, và tích hợp chặt chẽ với các sản phẩm Microsoft khác.

###### Cơ sở Dữ liệu NoSQL:

- MongoDB: là một cơ sở dữ liệu NoSQL hướng tài liệu, sử dụng JSON-style documents để lưu trữ dữ liệu. Nó linh hoạt và có khả năng mở rộng tốt.
- Cassandra: là một cơ sở dữ liệu NoSQL phân tán, được thiết kế để xử lý dữ liệu lớn trên nhiều máy chủ mà không có điểm hỏng.
- Redis: là một cơ sở dữ liệu NoSQL hướng key-value, nhanh và linh hoạt. Nó thường được sử dụng như một hệ thống lưu trữ cache hoặc message broker.












