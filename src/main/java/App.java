import wiseSaying.SystemController;
import wiseSaying.WiseSayingController;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;
    private final Scanner scanner;

    public App(){
        scanner = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(scanner);
        systemController= new SystemController();
    }


    public void run() {
//       == 명언 앱 ==
//명령) 등록
//명언 : 현재를 사랑하라.
//작가 : 작자미상
//1번 명언이 등록되었습니다.
//명령) 등록
//명언 : 과거에 집착하지 마라.
//작가 : 작자미상
//2번 명언이 등록되었습니다.
//명령) 목록
//번호 / 작가 / 명언
//----------------------
//2 / 작자미상 / 과거에 집착하지 마라.
//1 / 작자미상 / 현재를 사랑하라.
//명령) 삭제?id=1
//1번 명언이 삭제되었습니다.
//명령) 삭제?id=1
//1번 명언은 존재하지 않습니다.
//명령) 수정?id=3
//3번 명언은 존재하지 않습니다.
//명령) 수정?id=2
//명언(기존) : 과거에 집착하지 마라.
//명언 : 현재와 자신을 사랑하라.
//작가(기존) : 작자미상
//작가 : 홍길동
//명령) 목록
//번호 / 작가 / 명언
//----------------------
//2 / 홍길동 / 현재와 자신을 사랑하라.
//명령) 종료

        wiseSayingController.makeTestData();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                wiseSayingController.writeWiseSaying();
            } else if (command.equals("목록")) {
                wiseSayingController.printWiseSayingList();
            } else if (Pattern.matches("^삭제\\?id=\\d+$", command)) {
                int delId = Integer.parseInt(command.substring(6));
                wiseSayingController.delWiseSaying(delId);
            } else if (Pattern.matches("^수정\\?id=\\d+$", command)) {
                int corId = Integer.parseInt(command.substring(6));
                wiseSayingController.updateWiseSaying(corId);
            } else if (command.equals("종료")) {
                systemController.exit();
                break;
            }
        }
    }
}
