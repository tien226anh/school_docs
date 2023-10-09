# lược đồ sáng và cân bằng lược đồ sáng

trong khoảng [0, L-1] là hàm rời rạc có dạng

`p(r_k) = n_k/n`

với n_k là số lượng pixel có giá trị xám r_k
n là tổng số pixel của ảnh

# Cân bằng lược đồ sáng

`s_k = T(r_k) = (L' - 1)sigma(0-k)[p_r(r_j)] = (L' - 1)sigma(0-k)[n_j/n]`

**note: nếu ko cho L' thì lấy L'=L**

# Biên

**Có 3 loại biên**
- Step edge (Ideal edge): Cường độ sáng thay đổi đột ngột
- Ramp edge: Cường độ sáng không đột ngột thay đổi mà xảy ra trên một khoảng nhất định.
- Roof edge: Thường là mô hình đường thằng chạy qua một vùng với độ rộng của mái nhà tùy thuộc vào độ dày và độ sắc nét của đường thẳng.

**Ba bước cơ bản phát hiện biên**
1. Làm mịn ảnh để giảm nhiễu
2. Phát hiện điểm biên: Đây là quá trình trích xuất từ ảnh tất cả các điểm ảnh là ứng cử viên tiềm năng của điểm biên.
3. Định vị biên: Mục đích của quá trình này là lựa chọn từ các điểm biên ứng cử viên ở bước 2 các điểm là điểm biên thực sự để tạo thành biên.

**Có 3 phương pháp**
- Phương pháp dựa trên đạo hàm bậc 1 / Phương pháp Gradient
  - Toán tử Roberts
  - Toán tử Prewitt
  - Toán tử Sobel
- Phương pháp dựa trên đạo hàm bậc 2
  - Laplacian
  - Laplacian of Gaussian (LoG)
  - Difference of Gaussian (DoG)
- Phát hiện biên tối ưu
  - Canny

**Gradient**
- Cách tính Gx, Gy:
  - $Gx = f(x+1, y) - f(x, y)$ = $\frac{df(x,y)}{dx}$
  - $Gy = f(x, y+1) - f(x, y)$ = $\frac{df(x,y)}{dy}$

- Độ lớn:
  $|G| = \sqrt{G_x^2 + G_y^2}$ $\approx |G_x| + |G_y|$

- Góc:
  $\theta = arctan(\frac{G_y}{G_x})$
