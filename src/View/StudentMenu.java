package View;

import Controller.ListManager;
import Model.ElementInList;
import Model.Student;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Scanner;

public class StudentMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        ListManager studentManager = new ListManager();
        studentManager.add(new Student("112", "Luýt", "Hà Tĩnh", "C1121G1", 80));
        studentManager.add(new Student("113", "Sang", "Hải Phòng", "C1121G1", 75));
        studentManager.add(new Student("114", "Hùng", "Phú Thọ", "C1121G1", 90.5));
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllStudent(studentManager);
                    break;
                }
                case 2: {
                    showCreateStudent(studentManager);
                    break;
                }
                case 3: {
                    showUpdateStudent(studentManager);
                    break;
                }
                case 4: {
                    showDeleteStudent(studentManager);
                    break;
                }
                case 5: {
                    showSortStudent(studentManager);
                    break;
                }
                case 6: {
                    System.out.println("Tìm kiếm học viên");
                    System.out.println("Tìm kiếm tuyến tính");
                    System.out.println("Nhập mã học viên cần tìm");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    int index = studentManager.indexOfId(id);
                    if (index != -1) {
                        System.out.println("Thông tin học viên cần tìm: " + studentManager.get(index));
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Ghi dữ liệu ra file.");
                    System.out.print("Nhập tên file: ");
                    String path = scanner.nextLine();
                    studentManager.writeToFile(path);
                    break;
                }
                case 8: {
                    System.out.println("Đọc dữ liệu từ file");
                    System.out.print("Nhập tên file: ");
                    String path = scanner.nextLine();
                    studentManager.readFromFile(path);
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void menuFind() {
        System.out.println("1. Sử dụng tìm kiếm tuyến tính");
        System.out.println("2. Sử dụng tìm kiếm nhị phân");
        System.out.println("0. Quay lại");
    }

    private static void showSortStudent(ListManager studentManager) {
        System.out.println("Sắp xếp danh sách học viên");
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getMark() == o2.getMark())
                    return 0;
                if (o1.getMark() > o2.getMark())
                    return 1;
                return -1;
            }
        };
        studentManager.sortList(comparator.reversed());
    }


    private static void showDeleteStudent(ListManager studentManager) {
        System.out.println("Xóa thông tin học viên");
        System.out.println("Nhập mã học viên cần chỉnh sửa thông tin");
        String id = scanner.nextLine();
        int index = studentManager.indexOfId(id);
        boolean isDeleted = studentManager.remove(index);
        if (isDeleted) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa lỗi do mã học viên không tồn tại!");
        }
    }

    private static void showUpdateStudent(ListManager studentManager) {
        System.out.println("Chỉnh sửa thông tin học viên");
        System.out.println("Nhập mã học viên cần chỉnh sửa thông tin");
        String id = scanner.nextLine();
        int index = studentManager.indexOfId(id);
        if (index != -1) {
            Student student = inputStudentInfo();
            studentManager.set(index, student);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật bị lỗi do không tồn tại mã học viên cần tìm!");
        }
    }

    private static void showCreateStudent(ListManager studentManager) {
        System.out.println("Thêm học viên");
        Student student = inputStudentInfo();
        studentManager.add(student);
    }

    private static void showAllStudent(ListManager studentManager) {
        int size = studentManager.size();
        if (size == 0) {
            System.out.println("Danh sách rỗng");
        } else {
            System.out.println("Danh sách học viên");
            studentManager.printList();
        }
    }

    private static Student inputStudentInfo() {
        System.out.println("Nhập mã học viên:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên học viên:");
        String name = scanner.nextLine();
        System.out.println("Nhập quê quán học viên:");
        String hometown = scanner.nextLine();
        System.out.println("Nhập lớp:");
        String className = scanner.nextLine();
        System.out.println("Nhập điểm:");
        double mark = scanner.nextDouble();
        Student student = new Student(id, name, hometown, className, mark);
        return student;
    }

    private static void menu() {
        System.out.println("1. Hiển thị danh sách học viên");
        System.out.println("2. Thêm học viên mới");
        System.out.println("3. Cập nhật học viên");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp điểm giảm dần");
        System.out.println("6. Tìm kiếm");
        System.out.println("7. Ghi dữ liệu ra file");
        System.out.println("8. Đọc dữ liệu từ file");
        System.out.println("0. Quay lại");
    }
}
