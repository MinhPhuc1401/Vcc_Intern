# Sử dụng base image có Python và Flask
FROM python:3.8-slim

# Tạo thư mục làm việc
WORKDIR /app

# Sao chép requirements.txt vào thư mục làm việc
COPY requirements.txt .

# Cài đặt dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép ứng dụng vào thư mục làm việc
COPY . .

# Mở cổng 5000 để kết nối từ bên ngoài
EXPOSE 5000

# Chạy ứng dụng khi container được khởi động
CMD ["python", "app.py"]
