package objectstudy;

import objectstudy.initializer.MovieInit;
import objectstudy.repository.MovieRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieApp {

    private MovieRepository movieRepository = new MovieRepository();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean inputMismatch = false;
        while (true) {
            System.out.println("=====================================");
            System.out.println("1. 예매하기 2. 환불하기 0. 종료");
            System.out.println("=====================================");

            if (inputMismatch) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                scanner.nextLine(); // 버퍼를 비워줌
                inputMismatch = false;
            }

            try {
                select = scanner.nextInt();
                switch (select) {
                    case 1 -> {
                        System.out.println("예매할 영화를 선택해 주세요.");
                        System.out.println(movieRepository.findAll());
                    }
                    case 2 -> {
                        System.out.println("2");
                    }
                    case 0 -> {
                        System.out.println("프로그램 종료");
                        return;
                    }
                    default -> {
                        System.out.println("다시 선택해주세요.");
                    }
                }
            } catch (InputMismatchException e) {
                inputMismatch = true;
            }
        }
    }

    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();
        MovieInit.createMovieData(movieApp.movieRepository);

        movieApp.showMenu();
    }
}
