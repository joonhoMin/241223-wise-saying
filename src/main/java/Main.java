import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        App app=new App();
        app.run();
    }
}

class App{
    public void run(){
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

        Scanner scanner=new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        int lastNo=0;
        List<명언> list=new ArrayList<>();

        while(true)
        {
            System.out.print("명령) ");
            String command=scanner.nextLine();

            if(command.equals("등록")){
                System.out.print("명언 : ");
                String 명언내용=scanner.nextLine();
                System.out.print("작가 : ");
                String 작가=scanner.nextLine();
                list.add(new 명언(++lastNo,명언내용,작가));

                System.out.println(lastNo+"번 명언이 등록되었습니다.");
            }
            else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------");
                for(int i=list.size()-1;i>=0;i--)
                {
                    System.out.println(list.get(i).get번호()+" / "+list.get(i).get작가()+" / "+list.get(i).get명언내용());
                }
            }
            else if(Pattern.matches("^삭제\\?id=\\d+$", command)){
                int delId=Integer.parseInt(command.substring(6));
                boolean find=false;
                for(int i=0;i<list.size();i++)
                {
                    if(list.get(i).get번호()==delId)
                    {
                        list.remove(i);
                        System.out.println(delId+"번 명언이 삭제되었습니다.");
                        find=true;
                        break;
                    }
                }
                if(!find)
                    System.out.println(delId+"번 명언은 존재하지 않습니다.");
            }
            else if(Pattern.matches("^수정\\?id=\\d+$", command)){
                int corId=Integer.parseInt(command.substring(6));
                boolean find=false;
                for(int i=0;i<list.size();i++)
                {
                    if(list.get(i).get번호()==corId)
                    {
                        System.out.println("명언(기존) : "+list.get(i).get명언내용());
                        System.out.print("명언 : ");
                        String new명언=scanner.nextLine();
                        list.get(i).set명언내용(new명언);
                        System.out.println("작가(기존) : "+list.get(i).get작가());
                        System.out.print("작가 : ");
                        String new작가 =scanner.nextLine();
                        list.get(i).set작가(new작가);
                        find=true;
                        break;
                    }
                }
                if(!find)
                    System.out.println(corId+"번 명언은 존재하지 않습니다.");
            }
            else if(command.equals("종료")){
                break;
            }
        }
    }
}

class 명언{
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

    public 명언(int 번호, String 명언내용, String 작가) {
        this.번호 = 번호;
        this.명언내용 = 명언내용;
        this.작가 = 작가;
    }
}