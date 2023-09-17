import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();

            Process process = runtime.exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            reader.readLine();
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                String pid = parts[1];
                String processName = parts[0];

                System.out.println("PID: " + pid + ", Имя процесса: " + processName);
            }
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
