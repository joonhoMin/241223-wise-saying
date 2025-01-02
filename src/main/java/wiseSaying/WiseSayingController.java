package wiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    //명언 저장 리스트
    private final List<WiseSaying> list = new ArrayList<>();

    //마지막 명언 번호
    private int lastNo = 0;
    private final Scanner scanner = new Scanner(System.in);

    private WiseSaying findWiseSaying(int targetId){
        for(WiseSaying wiseSaying : list) {
            if(wiseSaying.get번호() == targetId) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void updateWiseSaying(int corId) {
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


    public void delWiseSaying(int delId) {
        WiseSaying wisesaying=findWiseSaying(delId);
        if(wisesaying==null) {
            System.out.println(delId + "번 명언은 존재하지 않습니다.");
            return;
        }
        list.remove(wisesaying);
        System.out.println(delId + "번 명언이 삭제되었습니다.");

    }

    public void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (WiseSaying tmp명언: list.reversed()) {
            System.out.println(tmp명언.get번호() + " / " + tmp명언.get작가() + " / " + tmp명언.get명언내용());
        }
    }

    public void writeWiseSaying() {
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
