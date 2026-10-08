Tên dự án: File Crypto App

Mô tả: Ứng dụng desktop được phát triển bằng Java Swing, cho phép người dùng mã hóa và giải mã các tệp văn bản (.txt) bằng thuật toán mã hóa mạnh AES (Advanced Encryption Standard). Chương trình được thiết kế theo mô hình kiến trúc MVC (Model-View-Controller) để đảm bảo tính module hóa, dễ bảo trì và mở rộng.

Công nghệ: Java, Java Swing (GUI), Java Cryptography Architecture (JCA).

Phân tích kiến trúc

💎 Model (CryptoModel)

Đây là trái tim của chương trình, chứa tất cả logic xử lý. Nó độc lập hoàn toàn với giao diện người dùng.

Chức năng chính:

Mã hóa file: Nhận đầu vào là một khóa (key), file nguồn và file đích. Nó sử dụng thuật toán AES để mã hóa nội dung file nguồn và ghi kết quả vào file đích.

Giải mã file: Nhận đầu vào tương tự, nhưng sử dụng khóa để giải mã nội dung đã được mã hóa.

Thuật toán: Sử dụng AES với khóa có độ dài 16 byte (128-bit) để đảm bảo tính bảo mật.

🎨 View (CryptoView)

Đây là thành phần giao diện người dùng, nơi người dùng tương tác trực tiếp. Nó không chứa bất kỳ logic xử lý nào.
Chức năng chính:

Hiển thị GUI: Bao gồm cửa sổ chính (JFrame), các trường văn bản, nút chức năng ("Duyệt...", "Mã Hóa", "Giải Mã"), và khu vực hiển thị trạng thái (JTextArea).

Cung cấp phương thức: Cho phép Controller truy cập và thay đổi trạng thái của các thành phần GUI (ví dụ: getFilePath(), setFilePath(), appendStatus()).

🧠 Controller (CryptoController)

Lớp này hoạt động như một cầu nối giữa View và Model. Nó là trung tâm điều phối tất cả các hành động.

Chức năng chính:

Xử lý sự kiện: Bắt các sự kiện từ các nút trong View (ví dụ: khi nhấn nút "Mã Hóa").

Điều phối: Khi một sự kiện xảy ra, nó lấy dữ liệu cần thiết từ View (đường dẫn file, khóa), gọi các phương thức tương ứng trong Model (FileEncryptor.encrypt() hoặc FileEncryptor.decrypt()) để thực hiện tác vụ.

Cập nhật giao diện: Sau khi tác vụ hoàn thành, nó sẽ cập nhật trạng thái trên View (ví dụ: hiển thị thông báo "Mã hóa thành công!" trên statusArea).
