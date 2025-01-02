package wiseSaying;

import java.util.ArrayList;

public class WiseSayingRepository {

    //마지막 명언 번호
    private int lastNo = 0;

    //명언 저장 리스트
    private final ArrayList<WiseSaying> list = new ArrayList<>();


    public WiseSaying findById(int targetId) {
        for(WiseSaying wiseSaying : list) {
            if(wiseSaying.get번호() == targetId) {
                return wiseSaying;
            }
        }
        return null;
    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying=new WiseSaying(++lastNo, content, author);
        list.add(wiseSaying);
        return wiseSaying;
    }


    public ArrayList<WiseSaying> findAll() {
        return list;
    }

    public void remove(WiseSaying wiseSaying) {
        list.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying) {

    }

}
