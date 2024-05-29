import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    String maSanPham;
    String tenSanPham;
    double gia;
    int soLuong;

    public SanPham(String maSanPham, String tenSanPham, double gia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double thanhTien() {
        return this.gia * this.soLuong;
    }
}

class NguoiMua {
    String hoTen;
    String soDienThoai;
    String diaChi;

    public NguoiMua(String hoTen, String soDienThoai, String diaChi) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }
}

class DonHang {
    ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    NguoiMua nguoiMua;

    public DonHang(NguoiMua nguoiMua) {
        this.nguoiMua = nguoiMua;
    }

    public void themSanPham(SanPham sp) {
        this.danhSachSanPham.add(sp);
    }

    public void chinhSuaSoLuong(String maSanPham, int soLuongMoi) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.maSanPham.equals(maSanPham)) {
                if (soLuongMoi == 0) {
                    danhSachSanPham.remove(sp);
                } else {
                    sp.setSoLuong(soLuongMoi);
                }
                break;
            }
        }
    }

    public double tinhTongTien() {
        double tongTien = 0;
        for (SanPham sp : danhSachSanPham) {
            tongTien += sp.thanhTien();
        }
        return tongTien;
    }

    public void inThongTinChiTiet() {
        System.out.println("Thông tin người mua:");
        System.out.println("Họ tên: " + nguoiMua.hoTen);
        System.out.println("Số điện thoại: " + nguoiMua.soDienThoai);
        System.out.println("Địa chỉ: " + nguoiMua.diaChi);
        System.out.println("Danh sách sản phẩm:");
        for (SanPham sp : danhSachSanPham) {
            System.out.println("Mã sản phẩm: " + sp.maSanPham + ", Tên sản phẩm: " + sp.tenSanPham + ", Giá: " + sp.gia + ", Số lượng: " + sp.soLuong + ", Thành tiền: " + sp.thanhTien());
        }
        System.out.println("Tổng tiền: " + tinhTongTien());
    }
}

public class QuanLyDonHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin người mua
        System.out.print("Nhập họ tên người mua: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập số điện thoại liên hệ: ");
        String soDienThoai = scanner.nextLine();

        System.out.print("Nhập địa chỉ giao hàng: ");
        String diaChi = scanner.nextLine();

        NguoiMua nguoiMua = new NguoiMua(hoTen, soDienThoai, diaChi);
        DonHang donHang = new DonHang(nguoiMua);

        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Thêm sản phẩm vào giỏ hàng");
            System.out.println("2. Chỉnh sửa số lượng sản phẩm");
            System.out.println("3. Tính số tiền phải trả");
            System.out.println("4. In ra thông tin chi tiết đơn hàng");
            System.out.println("5. Thoát");
            int chon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã sản phẩm: ");
                    String maSanPham = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String tenSanPham = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double gia = scanner.nextDouble();
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line

                    SanPham sp = new SanPham(maSanPham, tenSanPham, gia, soLuong);
                    donHang.themSanPham(sp);
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm cần chỉnh sửa: ");
                    maSanPham = scanner.nextLine();
                    System.out.print("Nhập số lượng mới: ");
                    soLuong = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line

                    donHang.chinhSuaSoLuong(maSanPham, soLuong);
                    break;
                case 3:
                    System.out.println("Tổng số tiền phải trả: " + donHang.tinhTongTien());
                    break;
                case 4:
                    donHang.inThongTinChiTiet();
                    break;
                case 5:
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        scanner.close();
    }
}
