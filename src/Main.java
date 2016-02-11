import java.util.Scanner;

/**
 * Created by jackkates on 2/9/16.
 */
public class Main {

    public int N;
    public int[][] distances;

    public static void main(String[] args) {
        new Main().run();
    }

    public Main() {}

    public void run() {
        loadMatrix();


    }

    private void loadMatrix() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        distances = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distances[i][j] = sc.nextInt();
            }
        }
    }
}
