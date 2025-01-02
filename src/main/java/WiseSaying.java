public class WiseSaying {
    private int 번호;
    private String 명언내용;
    private String 작가;


    public int get번호() {
        return 번호;
    }

    public void set번호(int 번호) {
        this.번호 = 번호;
    }

    public String get명언내용() {
        return 명언내용;
    }

    public void set명언내용(String 명언내용) {
        this.명언내용 = 명언내용;
    }

    public String get작가() {
        return 작가;
    }

    public void set작가(String 작가) {
        this.작가 = 작가;
    }

    public WiseSaying(int 번호, String 명언내용, String 작가) {
        this.번호 = 번호;
        this.명언내용 = 명언내용;
        this.작가 = 작가;
    }
}
