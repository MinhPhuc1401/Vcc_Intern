# WEEK 2 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

#### 1. Mô tả công việc

- Collection(s): Tìm hiểu và viết trương trình java sử dụng các cấu trúc dữ liệu HashMap, HashSet, ArrayList, hashCode, equals
- Design Pattern: Lựa chọn ít nhất 3 Design Pattern để implement bằng java và trình bày lại
- Serialize: Tìm hiểu liên quan serialize trong java (viết code ví dụ minh họa bằng java và giải thích code)



#### 2. Kết quả công việc

##### 2.1. Collections
- HashMap: là một cấu trúc dữ liệu dựa trên HashTable trong Java. Nó lưu trữ các cặp key-value và cho phép bạn thực hiện các hoạt động cơ bản như thêm, xóa và tìm kiếm dữ liệu dựa trên key. Key phải là duy nhất và không thể trùng lặp. HashMap không đảm bảo thứ tự lưu trữ của các phần tử.
- HashSet: là một tập hợp không chứa các phần tử trùng lặp. Nó sử dụng cơ chế băm (hashing) để lưu trữ các phần tử, do đó, các phần tử trong HashSet không có thứ tự cụ thể. HashSet là một tập hợp cơ bản cho việc loại bỏ các phần tử trùng lặp trong một danh sách.
- ArrayList: là một danh sách mảng động, nghĩa là nó có thể thay đổi kích thước của mảng khi bạn thêm hoặc xóa phần tử. Nó lưu trữ các phần tử theo thứ tự và cho phép bạn truy cập phần tử bằng chỉ mục. ArrayList cung cấp một cách linh hoạt để quản lý danh sách dữ liệu và là một trong những cấu trúc dữ liệu phổ biến trong Java.
- hashCode: là một phương thức của lớp Object trong Java, được sử dụng để tính toán một giá trị số nguyên đại diện cho một đối tượng. Giá trị hashCode được sử dụng bởi các cấu trúc dữ liệu dựa trên băm (hash-based data structures) như HashMap, HashSet, và Hashtable để nhanh chóng tra cứu và lưu trữ đối tượng; hashCode không đảm bảo tính duy nhất, có nghĩa là hai đối tượng có thể có cùng giá trị hashCode.
- equals: là một phương thức của lớp Object mà bạn có thể ghi đè để so sánh hai đối tượng. Mục đích của equals là so sánh hai đối tượng dựa trên nội dung của chúng, thay vì địa chỉ tham chiếu. Trong nhiều trường hợp, bạn nên ghi đè phương thức equals để kiểm tra xem hai đối tượng có cùng giá trị hay không.

##### 2.2. Design Pattern
- Singleton Pattern: đảm bảo rằng một lớp chỉ có một thể hiện duy nhất và cung cấp một cách để truy cập nó từ mọi nơi trong ứng dụng. Điều này hữu ích khi bạn muốn đảm bảo rằng một tài nguyên được chia sẻ chỉ có một bản sao, chẳng hạn như cơ sở dữ liệu kết nối hoặc hệ thống đăng nhập.
- Observer Pattern: là một mô hình sự kiện trong đó một đối tượng (Subject) duy trì danh sách các đối tượng phụ thuộc (Observers) và thông báo cho họ khi trạng thái của Subject thay đổi. Điều này cho phép các đối tượng tự động cập nhật khi trạng thái của đối tượng mà họ quan tâm thay đổi.
- Factory Method Pattern: cho phép bạn tạo ra các đối tượng mà không cần biết cụ thể loại đối tượng nào được tạo. Thay vì tạo đối tượng trực tiếp bằng từ khóa new, bạn sử dụng một phương thức tạo (Factory Method) để tạo đối tượng.

##### 2.3. Serialize

###### 2.3.1. Khái niệm
Serialization (Hay gọi tắt là "Serialize") trong lập trình là quá trình chuyển đổi một đối tượng thành một chuỗi byte hoặc một dãy các dữ liệu sao cho đối tượng này có thể được lưu trữ, truyền tải qua mạng hoặc tái sử dụng sau này. Mục tiêu chính của Serialization là duy trì trạng thái của đối tượng và các dữ liệu của nó để sau này có thể khôi phục lại đối tượng ban đầu từ dãy byte hoặc dữ liệu đã serialize.

###### 2.3.2. Ứng dụng
- Lưu trữ trạng thái của đối tượng: Serialization cho phép bạn lưu trạng thái của đối tượng vào một tệp hoặc cơ sở dữ liệu để sau này có thể khôi phục lại trạng thái đó.
- Truyền tải dữ liệu qua mạng: Khi bạn muốn truyền dữ liệu qua mạng từ một ứng dụng Java đến một ứng dụng Java khác, Serialization giúp bạn đóng gói dữ liệu thành một dãy byte có thể được gửi và sau đó giải gói dữ liệu ở phía máy nhận.
- Tái sử dụng đối tượng: Bằng cách serialize một đối tượng và sau đó khôi phục nó, bạn có thể tạo ra các bản sao của đối tượng ban đầu mà không cần tạo ra một bản sao thủ công từng phần.





