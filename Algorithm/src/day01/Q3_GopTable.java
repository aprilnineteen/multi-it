package day01;

public class Q3_GopTable {
    //°ö¼À Å×ÀÌºí
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int row = 9;
        int column = 9;
        System.out.println("      |  1    2    3    4    5   6    7    8    9");
        System.out.println("------+---------------------------------------------");

        for (int i = 1; i <= row; i++) {
            System.out.printf("%5d|", i); // Ã¹ ¹øÂ° ¿­¸¸
            for (int j = 1; j <= column; j++) {
                System.out.printf("%4d ", i * j);
            }
            System.out.println();
        }
    }
}