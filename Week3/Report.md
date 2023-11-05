# WEEK 3 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

#### 1. Mô tả công việc

- Exception: nắm được cách xử lý, hệ thống exception trong java
- JSON: nắm được json là gì, sử dụng java parse json, lấy giá trị, chuyển jsonobject thành string. Sử dụng thư viện gson để parse trực tiếp 1 string sang 1 object tương ứng

#### 2. Kết quả công việc

##### 2.1. Exception

###### 2.1.1 Xử lý
- Sử dụng khối lệnh 'try - catch':
```java
try {
    int result = 5 / 0; // Gây ra ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Lỗi chia cho 0: " + e.getMessage());
}
```
- Sử dụng 'throws'
```java
public void someMethod() throws ExceptionType {
    // Mã có thể gây ra ngoại lệ
}
```
- Sử dụng 'finally'
```java
try {
    // Mã có thể gây ra ngoại lệ
} catch (ExceptionType e) {
    // Xử lý ngoại lệ
} finally {
    // Công việc dọn dẹp hoặc các tác vụ cuối cùng
}
```

###### 2.1.2 Hệ thống Exception trong java
Hệ thống exception trong Java được tổ chức thành một cấu trúc cây kế thừa, trong đó lớp 'Throwable' là lớp gốc. Các exception được chia thành hai loại chính: 'Exception' và 'Error'.
a) Throwable (Lớp gốc):
- Error: Là lớp cha cho các exception liên quan đến lỗi hệ thống, chúng thường là tình huống nghiêm trọng và không thể khắc phục.
- Exception: Là lớp cha cho tất cả các exception. Các exception thuộc lớp này thường có thể được xử lý. Điều này bao gồm 'RuntimeException' và các exception kiểm tra (checked exceptions).
b)Exception (Lớp con của Throwable):
- RuntimeException: Là lớp con của 'Exception', nhưng không phải là exception kiểm tra (unchecked exception). Các exception này có thể xảy ra tại thời điểm chạy và không bắt buộc phải bắt hoặc khai báo.
- 'IOException' và các exception liên quan đến I/O: Thường được xử lý trong các tình huống liên quan đến đọc/ghi dữ liệu.
- 'SQLException' và các exception liên quan đến cơ sở dữ liệu: Được xử lý trong các tình huống liên quan đến làm việc với cơ sở dữ liệu.
##### 2.2. JSON
JSON (JavaScript Object Notation) là một định dạng dữ liệu dựa trên văn bản (text-based data format) phổ biến trong lập trình. Nó được sử dụng để truyền tải dữ liệu giữa các máy chủ và ứng dụng web, cũng như lưu trữ cấu trúc dữ liệu dễ đọc cho con người. JSON được thiết kế để dễ đọc và viết cho con người và dễ dùng cho máy tính.
