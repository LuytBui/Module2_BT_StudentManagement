package View;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        StudentMenu studentMenu = new StudentMenu();
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    studentMenu.run();
                    break;
                }
                case 2: {
                }
            }
        } while (choice != 0);
    }

    private static void menu() {
        System.out.println("1. Quản lý học viên");
        System.out.println("2. Quản lý lớp học // đang code");
        System.out.println("0. Thoát");
    }
}
