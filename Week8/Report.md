# WEEK 8 REPORT

##### Thực tập sinh: Đỗ Minh Phúc

# 1. Shell Linux

# Các command cơ bản:
## cd (Change Directory):
- Di chuyển đến thư mục khác.
- Ví dụ: cd /path/to/directory

## ls (List):
- Liệt kê các tệp và thư mục trong thư mục hiện tại.
- Ví dụ: ls -l (hiển thị chi tiết), ls -a (hiển thị cả các tệp ẩn).

## cp (Copy):
- Sao chép tệp hoặc thư mục.
- Ví dụ: cp file1.txt /path/to/destination

## mv (Move):
- Di chuyển hoặc đổi tên tệp/thư mục.
- Ví dụ: mv file1.txt /path/to/destination, mv oldname.txt newname.txt

## mkdir (Make Directory):
- Tạo thư mục mới.
- Ví dụ: mkdir new_directory

## cat:
- Hiển thị nội dung của một hoặc nhiều tệp.
- Ví dụ: cat filename.txt
## head:
- Hiển thị nội dung đầu tiên của tệp.
- Ví dụ: head -n 10 filename.txt (hiển thị 10 dòng đầu tiên)

# Các command liên quan đến quyền:
## chmod (Change Mode):
- Thay đổi quyền truy cập của tệp/thư mục.
- Ví dụ: chmod +x script.sh (thêm quyền thực thi).

## chown (Change Owner):
- Thay đổi chủ sở hữu của tệp/thư mục.
- Ví dụ: chown user:group filename.txt

## ls -l:
- Hiển thị thông tin chi tiết về tệp/thư mục, bao gồm quyền truy cập và chủ sở hữu.

# Các command thực hiện song song:

## cat test.txt | wc -l:
- Đếm số dòng trong tệp test.txt.

## cat test.txt | grep "a":
- Lọc các dòng trong test.txt chứa ký tự "a".

## cat test.txt | head:
- Hiển thị nội dung đầu tiên của test.txt.

## echo "aabb" > test.txt:
- Tạo một tệp test.txt với nội dung "aabb".

## echo "cc" >> test.txt:
- Thêm nội dung "cc" vào cuối tệp test.txt.

# Sử dụng vim:
- Tạo file mới: vim newfile.txt (Nhấn i để bắt đầu nhập văn bản, sau đó nhấn Esc và nhập :wq để lưu và thoát).
- Sửa file: vim existingfile.txt (Nhấn i để bắt đầu chỉnh sửa, sau đó nhấn Esc và nhập :wq để lưu và thoát).

# Quản lý tiến trình:
## htop:
- Hiển thị quản lý tiến trình dựa trên giao diện đồ họa.
- Cài đặt: sudo apt-get install htop (hoặc sử dụng trình quản lý gói tương ứng trên hệ thống của bạn).

## ps aux:
- Liệt kê tất cả các tiến trình đang chạy.

## kill -9:
- Kết thúc một tiến trình bằng cách sử dụng tùy chọn SIGKILL.
- Ví dụ: kill -9 process_id (thay thế process_id bằng ID thực tế của tiến trình).

# 2. Docker
Docker là một nền tảng mã nguồn mở giúp bạn tự động triển khai, mở rộng và quản lý các ứng dụng trong môi trường container. Container là một cách đóng gói ứng dụng cùng với các phụ thuộc và cấu hình của nó, tạo ra một môi trường đảm bảo rằng ứng dụng sẽ chạy giống nhau trên mọi máy chủ và môi trường.

# Khái niệm cơ bản

## Docker Image:
- Một hình ảnh là một bản đóng gói của một ứng dụng cùng với tất cả các phụ thuộc của nó.
- Hình ảnh có thể được chia sẻ và sử dụng để triển khai container.
## Docker Container:
- Một container là một thể hiện thực của một hình ảnh.
- Containers chia sẻ hạ tầng hệ điều hành với máy chủ và giữ cô lập ứng dụng.

## Dockerfile:
- Một tệp cấu hình văn bản định nghĩa cách một hình ảnh Docker nên được xây dựng.
- Chứa các hướng dẫn để cài đặt và cấu hình ứng dụng cùng với các phụ thuộc.

# Các lệnh Docker quan trọng:

## docker pull:
- Tải một hình ảnh từ Docker Hub hoặc một kho lưu trữ hình ảnh khác.
- Ví dụ: docker pull ubuntu

## docker build:
- Xây dựng một hình ảnh từ Dockerfile.
- Ví dụ: docker build -t my_image . (xây dựng hình ảnh và đặt tên là "my_image").
## docker run:
- Chạy một container từ một hình ảnh.
- Ví dụ: docker run -d -p 8080:80 my_image (chạy container ẩn danh trên cổng 8080 và liên kết nó với cổng 80 trong container).

## docker ps:
- Hiển thị danh sách các container đang chạy.
- Ví dụ: docker ps

## docker exec:
- Chạy một lệnh trong một container đang chạy.
- Ví dụ: docker exec -it container_id /bin/bash (mở một phiên làm việc tương tác trong container).

## docker stop:
- Dừng một hoặc nhiều container đang chạy.
- Ví dụ: docker stop container_id

## docker-compose:
- Một công cụ để định nghĩa và chạy nhiều container như một ứng dụng duy nhất.
- Sử dụng tệp docker-compose.yml để định cấu hình.
