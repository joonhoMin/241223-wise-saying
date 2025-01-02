package wiseSaying;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    private final Scanner scanner;

    public WiseSayingController(Scanner scanner){
        this.scanner=scanner;
        this.wiseSayingService= new WiseSayingService(new WiseSayingMemRepository());
    }


    public void updateWiseSaying(int corId) {
        WiseSaying wiseSaying=wiseSayingService.getItem(corId);

        if(wiseSaying==null) {
            System.out.println(corId + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + wiseSaying.get명언내용());
        System.out.print("명언 : ");
        String new명언 = scanner.nextLine();
        System.out.println("작가(기존) : " + wiseSaying.get작가());
        System.out.print("작가 : ");
        String new작가 = scanner.nextLine();

        wiseSayingService.modify(wiseSaying,new명언,new작가);

    }


    public void delWiseSaying(int delId) {
        WiseSaying wisesaying=wiseSayingService.getItem(delId);
        if(wisesaying==null) {
            System.out.println(delId + "번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingService.remove(wisesaying);

        System.out.println(delId + "번 명언이 삭제되었습니다.");

    }

    public void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        ArrayList<WiseSaying> wiseSayings=wiseSayingService.getItems();

        for (WiseSaying tmp명언: wiseSayings.reversed()) {
            System.out.println(tmp명언.get번호() + " / " + tmp명언.get작가() + " / " + tmp명언.get명언내용());
        }
    }

    public void writeWiseSaying() {
        System.out.print("명언 : ");
        String 명언내용 = scanner.nextLine();
        System.out.print("작가 : ");
        String 작가 = scanner.nextLine();
        WiseSaying wiseSaying=wiseSayingService.write(명언내용, 작가);
        System.out.println(wiseSaying.get번호() + "번 명언이 등록되었습니다.");
    }

    public void makeTestData() {
        wiseSayingService.write("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니");
        wiseSayingService.write("현재를 사랑하라", "작자 미상");
    }

}
