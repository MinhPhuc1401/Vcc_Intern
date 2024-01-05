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
