import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    //명언 저장 리스트
    private final List<WiseSaying> list = new ArrayList<>();

    //마지막 명언 번호
    private int lastNo = 0;
    private final Scanner scanner = new Scanner(System.in);

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

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                writeWiseSaying();
            } else if (command.equals("목록")) {
                printWiseSayingList();
            } else if (Pattern.matches("^삭제\\?id=\\d+$", command)) {
                int delId = Integer.parseInt(command.substring(6));
                delWiseSaying(delId);
            } else if (Pattern.matches("^수정\\?id=\\d+$", command)) {
                int corId = Integer.parseInt(command.substring(6));
                updateWiseSaying(corId);
            } else if (command.equals("종료")) {
                break;
            }
        }
    }

    private WiseSaying findWiseSaying(int targetId){
        for(WiseSaying wiseSaying : list) {
            if(wiseSaying.get번호() == targetId) {
                return wiseSaying;
            }
        }
        return null;
    }

    private void updateWiseSaying(int corId) {
        WiseSaying wisesaying=findWiseSaying(corId);

        if(wisesaying==null) {
            System.out.println(corId + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + wisesaying.get명언내용());
        System.out.print("명언 : ");
        String new명언 = scanner.nextLine();
        wisesaying.set명언내용(new명언);
        System.out.println("작가(기존) : " + wisesaying.get작가());
        System.out.print("작가 : ");
        String new작가 = scanner.nextLine();
        wisesaying.set작가(new작가);
    }


    private void delWiseSaying(int delId) {
        WiseSaying wisesaying=findWiseSaying(delId);
        if(wisesaying==null) {
            System.out.println(delId + "번 명언은 존재하지 않습니다.");
            return;
        }
        list.remove(wisesaying);
        System.out.println(delId + "번 명언이 삭제되었습니다.");
        
    }

    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (WiseSaying tmp명언: list.reversed()) {
            System.out.println(tmp명언.get번호() + " / " + tmp명언.get작가() + " / " + tmp명언.get명언내용());
        }
    }

    private void writeWiseSaying() {
        System.out.print("명언 : ");
        String 명언내용 = scanner.nextLine();
        System.out.print("작가 : ");
        String 작가 = scanner.nextLine();
        add(명언내용, 작가);
        System.out.println(lastNo + "번 명언이 등록되었습니다.");
    }

    public void add(String 명언내용, String 작가) {
        list.add(new WiseSaying(++lastNo, 명언내용, 작가));
    }

}
