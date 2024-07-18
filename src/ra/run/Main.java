package ra.run;

import ra.entity.Laptop;
import ra.entity.LaptopType;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static ArrayList<LaptopType> laptopTypes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int typeIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showLaptopTypeMenu();
                    break;
                case 2:
                    showLaptopMenu();
                    break;
                case 3:
                    System.out.println("Đang thoát...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("******************QUẢN LÝ LAPTOP******************");
        System.out.println("1. Quản lý loại laptop");
        System.out.println("2. Quản lý laptop");
        System.out.println("3. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static void showLaptopTypeMenu() {
        while (true) {
            System.out.println("*******************QUẢN LÝ LOẠI LAPTOP********************");
            System.out.println("1. Hiển thị danh sách các loại laptop");
            System.out.println("2. Thêm mới loại laptop");
            System.out.println("3. Cập nhật thông tin loại laptop");
            System.out.println("4. Xóa loại Laptop");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    hienThiDanhSachLoaiLaptop();
                    break;
                case 2:
                    themMoiLoaiLaptop();
                    break;
                case 3:
                    capNhatThongTinLoaiLaptop();
                    break;
                case 4:
                    xoaLoaiLaptop();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private static void hienThiDanhSachLoaiLaptop() {
        for (LaptopType type : laptopTypes) {
            if (!type.isDeleted()) {
                System.out.println("Mã loại: " + type.getTypeId() + ", Tên loại: " + type.getTypeName() + ", Mô tả: " + type.getDescription());
            }
        }
    }

    private static void themMoiLoaiLaptop() {
        System.out.print("Nhập mã loại: ");
        String typeId = scanner.nextLine();
        System.out.print("Nhập tên loại: ");
        String typeName = scanner.nextLine();
        for (Laptop laptop : laptops) {
            if (laptop.getLaptopName().equalsIgnoreCase(typeName) && !laptop.isDeleted()) {
                System.out.println("Tên laptop đã tồn tại.");
                return;
            }
        }
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        if (description.isEmpty()) {
            System.out.println("Mô tả không được để trống.");
            return;
        }
        laptopTypes.add(new LaptopType(typeId, typeName, description));
        System.out.println("Thêm mới loại laptop thành công!");
    }
    private static void capNhatThongTinLoaiLaptop() {
        System.out.print("Nhập mã loại để cập nhật: ");
        String typeId = scanner.nextLine();
        for (LaptopType type : laptopTypes) {
            if (type.getTypeId().equals(typeId) && !type.isDeleted()) {
                System.out.print("Nhập tên loại mới: ");
                String newName = scanner.nextLine();
                if (newName.isEmpty()) {
                    System.out.println("Tên không được để trống.");
                    return;
                }
                for (Laptop laptop : laptops) {
                    if (laptop.getLaptopName().equalsIgnoreCase(newName) && !laptop.isDeleted()) {
                        System.out.println("Tên laptop đã tồn tại.");
                        return;
                    }
                }
                System.out.print("Nhập mô tả mới: ");
                String newDescription = scanner.nextLine();
                if (newDescription.isEmpty()) {
                    System.out.println("Mô tả không được để trống.");
                    return;
                }
                type.setTypeName(newName);
                type.setDescription(newDescription);
                System.out.println("Cập nhật loại laptop thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy loại laptop!");
    }

    private static void xoaLoaiLaptop() {
        System.out.print("Nhập mã loại để xóa: ");
        String typeId = scanner.nextLine();
        for (LaptopType type : laptopTypes) {
            if (type.getTypeId().equals(typeId) && !type.isDeleted()) {
                type.setDeleted(true);
                System.out.println("Xóa loại laptop thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy loại laptop!");
    }

    private static void showLaptopMenu() {
        while (true) {
            System.out.println("********************QUẢN LÝ LAPTOP*********************");
            System.out.println("1. Danh sách Laptop");
            System.out.println("2. Thêm mới Laptop");
            System.out.println("3. Cập nhật thông tin Laptop");
            System.out.println("4. Xóa Laptop");
            System.out.println("5. Thống kê số lượng laptop theo từng loại");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    hienThiDanhSachLaptop();
                    break;
                case 2:
                    themMoiLaptop();
                    break;
                case 3:
                    capNhatThongTinLaptop();
                    break;
                case 4:
                    xoaLaptop();
                    break;
                case 5:
                    thongKeTheoLoai();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private static void hienThiDanhSachLaptop() {
        for (Laptop laptop : laptops) {
            if (!laptop.isDeleted()) {
                System.out.println("Mã Laptop: " + laptop.getLaptopId() + ", Tên: " + laptop.getLaptopName() + ", Giá: " + laptop.getLaptopPrice() + ", Loại: " + laptop.getTypeId());
            }
        }
    }

    private static void themMoiLaptop() {
        System.out.print("Nhập mã Laptop: ");
        String laptopId = scanner.nextLine();
        System.out.print("Nhập tên Laptop: ");
        String laptopName = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Nhập RAM: ");
        int ram = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giá Laptop: ");
        double laptopPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mã loại: ");
        String typeId = scanner.nextLine();
        laptops.add(new Laptop(laptopId, laptopName, description, customerAddress, ram, laptopPrice, typeId));
        System.out.println("Thêm mới Laptop thành công!");
    }

    private static void capNhatThongTinLaptop() {
        System.out.print("Nhập mã Laptop để cập nhật: ");
        String laptopId = scanner.nextLine();
        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equals(laptopId) && !laptop.isDeleted()) {
                System.out.print("Nhập tên Laptop mới: ");
                String newName = scanner.nextLine();
                System.out.print("Nhập mô tả mới: ");
                String newDescription = scanner.nextLine();
                System.out.print("Nhập địa chỉ khách hàng mới: ");
                String newCustomerAddress = scanner.nextLine();
                System.out.print("Nhập RAM mới: ");
                int newRAM = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giá Laptop mới: ");
                double newLaptopPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập mã loại mới: ");
                String newTypeId = scanner.nextLine();
                laptop.setLaptopName(newName);
                laptop.setDescription(newDescription);
                laptop.setCustomerAddress(newCustomerAddress);
                laptop.setRam(newRAM);
                laptop.setLaptopPrice(newLaptopPrice);
                laptop.setTypeId(newTypeId);
                System.out.println("Cập nhật Laptop thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy Laptop!");
    }

    private static void xoaLaptop() {
        System.out.print("Nhập mã Laptop để xóa: ");
        String laptopId = scanner.nextLine();
        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equals(laptopId) && !laptop.isDeleted()) {
                laptop.setDeleted(true);
                System.out.println("Xóa Laptop thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy Laptop!");
    }

    private static void thongKeTheoLoai() {
        System.out.println("Nộp bài thôi");

    }
}
